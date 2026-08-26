package org.hl7.fhir.model;

/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.
  
  Redistribution and use in source and binary forms, with or without modification, \
  are permitted provided that the following conditions are met:
  
   * Redistributions of source code must retain the above copyright notice, this \
     list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright notice, \
     this list of conditions and the following disclaimer in the documentation \
     and/or other materials provided with the distribution.
   * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.
  
  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS \"AS IS\" AND \
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED \
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. \
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, \
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT \
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR \
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, \
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) \
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE \
  POSSIBILITY OF SUCH DAMAGE.
  */

import ca.uhn.fhir.model.api.IElement;
import lombok.Getter;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.instance.model.api.IBase;
import org.hl7.fhir.model.core.*;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

import java.io.Serializable;
import java.util.*;

/**
 * Base class that sits below all FHIR Objects
 *
 */
public abstract class Base implements Serializable, IBase, IElement {

  //region class members

  /**
   * 1. context
   *
   * This might be null, in which case no context has been provided, and no version information is available
    */
  @Getter protected IModelContext modelContext;

  /**
   * 2. User data. User appended data items - allow users to add extra information to the class
   */
  private transient Map<String, Object> userData;

  /**
   * 3. Post Validation Definition information
   */
  private transient List<ValidationInformation> validationInfo;

  /**
   * 4. comment support - some formats carry comments, and they are captured here
   */
  private List<String> formatCommentsPre;
  private List<String> formatCommentsPost;

  //endregion

  //region version/context

  /**
   * Set the model context. Adoption only: an instance without a context can be given one, and 
   * re-asserting the same context is a (fast) no-op, but changing an existing context throws. 
   * The generated classes override this to cascade the context to all their children - the 
   * early return also cuts that recursion off, since a subtree whose root already carries the 
   * context is assumed to be consistent (assertModelContext exists to check that assumption)
   */
  public void setModelContext(IModelContext modelContext) {
    if (this.modelContext == modelContext) {
      return;
    }
    if (this.modelContext != null) {
      throw new FHIRException("Attempt to change the model context of an instance that already has one");
    }
    this.modelContext = modelContext;
  }

  /**
   * Impose the given model context on this object and everything below it, regardless of what 
   * contexts the tree carries now - the escape hatch from setModelContext's adoption-only rule, 
   * for moving a tree (or a subtree extracted from another tree) between contexts, or giving a 
   * context-free tree one retrospectively. Passing null detaches the tree from its context 
   * entirely, ready for re-adoption elsewhere. Deliberately walks every node with no shortcuts, 
   * since the tree may be in a mixed state - which also makes it listChildren()-slow, so it is 
   * a migration operation, not a hot path
   */
  public void changeModelContext(IModelContext modelContext) {
    this.modelContext = modelContext;
    List<Property> children = new ArrayList<Property>();
    listChildren(children);
    for (Property c : children) {
      for (Base b : c.getValues()) {
        if (b != null) {
          b.changeModelContext(modelContext);
        }
      }
    }
  }

  /**
   * Check that every node in the tree below this one carries the same model context as this 
   * one (including a uniformly null context), throwing FHIRException at the first mismatch, 
   * with the path to the offending element. This walks the tree with the listChildren() 
   * machinery, so it is much too slow for production paths - it exists for unit tests and 
   * debugging the coherence invariant that the constructors, setters, BaseList, and 
   * setModelContext cascades are meant to maintain
   */
  public void assertModelContext() throws FHIRException {
    assertModelContext(fhirType(), modelContext);
  }

  /** as assertModelContext(), but also requires that the tree's context IS the given one - used by the serialisers */
  public void assertModelContext(IModelContext expected) throws FHIRException {
    assertModelContext(fhirType(), expected);
  }

  private void assertModelContext(String path, IModelContext expected) {
    if (this.modelContext != expected) {
      throw new FHIRException("Model context mismatch at "+path+": expected "+describeContext(expected)+" but found "+describeContext(this.modelContext));
    }
    List<Property> children = new ArrayList<Property>();
    listChildren(children);
    for (Property c : children) {
      int i = 0;
      for (Base b : c.getValues()) {
        if (b != null) {
          b.assertModelContext(path+"."+c.getName()+(c.isList() ? "["+i+"]" : ""), expected);
        }
        i++;
      }
    }
  }

  private static String describeContext(IModelContext modelContext) {
    return modelContext == null ? "no context" : modelContext.getClass().getSimpleName()+"@"+Integer.toHexString(System.identityHashCode(modelContext));
  }

  /**
   * The core FHIR version in use, from the model context (null if no context was provided). 
   * These classes are versionless: they represent R6 and everything after it, with elements 
   * added over time and marked (on the property definitions) with the versions they apply to. 
   * So this is not "the version this object was compiled for" - it is the version of the 
   * package the instance is being used against, which determines which of the defined 
   * elements are actually applicable
   */
  public String getFHIRVersion() {
    return modelContext == null ? null : modelContext.getFHIRVersion();
  }
  //endregion

  //region User Data
  /** the user data item with the given name, or null if there isn't one */
  public Object getUserData(String name) {
    if (userData == null)
      return null;
    return userData.get(name);
  }
  
  /** set the named user data item, replacing any existing value */
  public void setUserData(String name, Object value) {
    if (userData == null)
      userData = new HashMap<String, Object>();
    userData.put(name, value);
  }

  /** remove the named user data item, if present */
  public void clearUserData(String name) {
    if (userData != null)
      userData.remove(name);
  }

  /** set the named user data item If Not Null: a null value leaves any existing entry untouched */
  public void setUserDataINN(String name, Object value) {
    if (value == null)
      return;
    
    if (userData == null)
      userData = new HashMap<String, Object>();
    userData.put(name, value);
  }

  /** true if the named user data item is present with a non-null value */
  public boolean hasUserData(String name) {
    if (userData == null)
      return false;
    else
      return userData.containsKey(name) && (userData.get(name) != null);
  }

  /** the named user data item as a string (toString() for non-strings), or null if absent */
	public String getUserString(String name) {
    Object ud = getUserData(name);
    if (ud == null)
      return null;
    if (ud instanceof String)
      return (String) ud;
    return ud.toString();
  }

  /** the named user data item as an int, or 0 if absent (throws if present but not an Integer) */
  public int getUserInt(String name) {
    if (!hasUserData(name))
      return 0;
    return (Integer) getUserData(name);
  }

  /** merge the other object's user data into this one - shared names are overwritten, others are kept */
  public void copyUserData(Base other) {
    if (other.userData != null) {
      if (userData == null) {
        userData = new HashMap<>();
      }
      userData.putAll(other.userData);
    }
  }
  //endregion

  //region Format Comments


  /** true if any source-format comments (XML/JSON comments captured by the parsers for round-tripping) are present */
  public boolean hasFormatComment() {
    return hasFormatCommentPre() || hasFormatCommentPost();
  }
  
  /** true if there are comments that appeared before this element in the source */
  public boolean hasFormatCommentPre() {
    return formatCommentsPre != null && !formatCommentsPre.isEmpty();
  }
  
  /** true if there are comments that appeared after this element in the source (only relevant at the end of a set of children) */
  public boolean hasFormatCommentPost() {
    return formatCommentsPost != null && !formatCommentsPost.isEmpty();
  }
  
  /** the comments that appeared before this element in the source (never null - created on demand) */
  public List<String> getFormatCommentsPre() {
    if (formatCommentsPre == null)
      formatCommentsPre = new ArrayList<String>();
    return formatCommentsPre;
  }
  
  /** the comments that appeared after this element in the source (never null - created on demand) */
  public List<String> getFormatCommentsPost() {
    if (formatCommentsPost == null)
      formatCommentsPost = new ArrayList<String>();
    return formatCommentsPost;
  }  
  

  public void copyFormatComments(Base other) {
    if (other.hasFormatComment()) {
      formatCommentsPre = new ArrayList<>();
      formatCommentsPre.addAll(other.formatCommentsPre);      
    } else {
      formatCommentsPre = null;
    }
  }
  

  /** append the given comments (if any) to the pre-element comments */
  public void addFormatCommentsPre(List<String> comments) {
    if (comments != null && !comments.isEmpty()) {
      getFormatCommentsPre().addAll(comments); 
    }    
  }

  /** append the given comments (if any) to the post-element comments */
  public void addFormatCommentsPost(List<String> comments) {
    if (comments != null && !comments.isEmpty()) {
      getFormatCommentsPost().addAll(comments); 
    }    
  }

  //endregion

  //region simplified direct access

  /**
   * @return the FHIR type name of the instance (not the java class name). For anonymous types 
   *   (inner backbone elements), it is the path, e.g. Patient.contact
   */
  public abstract String fhirType() ;

  /**
   * Note that this is potentially misleading on ElementDefinition that has a 'type'
   * property - don't mistakenly use this thinking it's going to look at ElementDefinition.type
   *
   * @param name - fhir type name
   * @return- true if it 'has' this type (including by specialization)
   */
  public boolean hasType(String... name) {
    String t = fhirType();
    for (String n : name) {
      if (n.equalsIgnoreCase(t))
        return true;
      if (n.contains(".")) {
        @SuppressWarnings("checkstyle:stringImplicitPatternUsage")
        //single literal character split
        String[] p = n.split("\\.");
        if (p.length == 2 && Utilities.existsInList(p[0], "FHIR", "CDA") && p[1].equalsIgnoreCase(t))
          return true;
      }
    }
    return false;
  }

  /** true if this is a resource (including contained/bundled ones), as opposed to a data type or element */
  public boolean isResource() {
    return false;
  }


  /**
   * @return true if the data type is a primitive type and might have a primitive value
   *   (which will be accessed as a string, irrespective of the stated value)
   */
  public boolean isPrimitive() {
    return false;
  }

  /**
   * @return true if the type is primitive, and there's value (e.g. no Data-Absent-Reason extension etc)
   */
  public boolean hasPrimitiveValue() {
    return primitiveValue() != null;
  }

  /**
   * @return true if the type is primitive, and there could be a value (irrespective of whether it's present e.g. no Data-Absent-Reason extension etc)
   */
  public boolean canHavePrimitiveValue() {
    return false;
  }

  /**
   * @return the primitive value if there is one, as a string irrespective of the actual type (e.g. dates converted to their FHIR string representation)
   *    return null if the value is not a primitive or there is no value (might be extensions instead)
   */
  public String primitiveValue() {
    return null;
  }
  /**
   * @return true if the type is boolean, and the primitive value can only be 'true' or 'false'
   */
  public boolean isBooleanPrimitive() {
    return false;
  }

  /**
   * @return true if the type is date|dateTime|instant, and the primitive value is a date/time of some precision
   */
  public boolean isDateTime() {
    return false;
  }

  /**
   * @return the date/time value if there is one, or null
   */
  public BaseDateTimeType dateTimeValue() {
    return null;
  }

  /**
   * true if this element has no content: no value, no children with content, no id, no 
   * extensions. Base-level features (user data, format comments, validation info) don't count 
   * as content. Overridden by the generated classes.
   */
  public boolean isEmpty() {
    return true; // things on base does not count
  }

  /**
   * true if this implementation navigates its children via metadata (definitions) rather than 
   * generated code - i.e. the element model, where child names and types come from a 
   * StructureDefinition at runtime. Affects which operand drives deep equality (see 
   * compareDeep) - the outcomes are the same either way
   */
  protected boolean isMetadataBased() {
    return false;
  }

  /** the xhtml content if this is an xhtml node (Narrative.div's value), else null */
  public XhtmlNode getXhtml() {
    return null;
  }

  /** set the xhtml content if this is an xhtml node; anything else throws */
  public Base setXhtml(XhtmlNode node) {
    throw new FHIRException("This node does not support xhtml");
  }

  /**
   * the id of this instance, whatever kind it is: the element id for elements and data types, 
   * Resource.id for resources. Exists so that code can work with ids without knowing which kind 
   * of object it's holding (and to implement the HAPI interfaces)
   */
  public abstract String getIdBase();

  /** set the id of this instance - see getIdBase() */
  public abstract void setIdBase(String value);

  //endregion

  //region Property Based Access

  /**
   * Supports iterating the children elements in some generic processor or browser
   * All defined children will be listed, even if they have no value on this instance
   *
   * Note that the actual content of primitive or xhtml elements is not iterated explicitly.
   * To find these, the processing code must recognise the element as a primitive, and use @link primitiveValue
   *
   * @return an immutable list of all the children defined for this element
   */
  public List<Property> getChildren() {
    List<Property> result = new ArrayList<Property>();
    listChildren(result);
    return Collections.unmodifiableList(result);
  }
  /**
   * Return the named child as a Property, or null if the name is unknown. Matches choice 
   * properties by their "[x]" name given the bare stem (asking for "value" finds "value[x]"). 
   * Note: implemented as a scan over listChildren(), so it builds every Property to find one - 
   * prefer getNamedProperty where performance matters.
   */
  public Property getChildByName(String name) {
    List<Property> children = new ArrayList<Property>();
    listChildren(children);
    for (Property c : children)
      if (c.getName().equals(name) || c.getName().equals(name+"[x]")) {
        return c;
      }
    return null;
  }

  /**
   * Add a Property for every defined child of this type to the list, whether or not it has a 
   * value on this instance. The machinery behind getChildren(); overridden by the generated 
   * classes (this base implementation contributes nothing - Base itself has no elements).
   */
  protected void listChildren(List<Property> result) {
    // nothing
  }

  /**
   * Return the current values of the named child as an immutable list, never containing nulls 
   * (and never null itself - no values is an empty list). "*" returns the values of all children. 
   * Unknown names return an empty list when checkValid is false, and throw when it is true.
   */
  public List<Base> getChildValues(String name, boolean checkValid) throws FHIRException {
    List<Base> result = new ArrayList<Base>();
    if (name.equals("*")) {
      List<Property> children = new ArrayList<Property>();
      listChildren(children);
      for (Property c : children)
        for (Base b : c.getValues())
          if (b != null)
            result.add(b);
    } else {
      Base[] values = getNamedValue(name, checkValid);
      if (values != null)
        for (Base b : values)
          if (b != null)
            result.add(b);
    }
    return Collections.unmodifiableList(result);
  }

  /**
   * Return the single value of the named child: null if there is no value, the value if there 
   * is one, and an Error if there are several - for children the caller knows to be singular. 
   * Unknown names return null when checkValid is false, and throw when it is true.
   */
  public Base getSingleChildValue(String name, boolean checkValid) {
    List<Base> values = getChildValues(name, checkValid);
    if (values.size() > 1) {
      throw new FHIRException("Too many values for " + name + " found - only one allowed");
    } else {
      return values.isEmpty() ? null : values.get(0);
    }
  }


  /**
   * Return the named child as a Property - the property's definitional metadata plus its current 
   * value(s). Choice properties answer to both the "[x]" name and the type-suffixed names 
   * (e.g. "value[x]" and "valueQuantity"). Unknown names return null when _checkValid is false, 
   * and throw when it is true. Overridden by the generated classes.
   */
  public Property getNamedProperty(String _name, boolean _checkValid) throws FHIRException {
    if (_checkValid)
      throw new FHIRException("Attempt to read invalid property '"+_name+"' on type "+fhirType());
    return null;
  }
  /**
   * Return the current value(s) of the named child - just the values, no metadata (see 
   * getNamedProperty for that). Choice properties answer to the bare stem only (e.g. "value", 
   * not "value[x]" or "valueQuantity"). Unknown names return null when checkValid is false, and 
   * throw when it is true. Overridden by the generated classes.
   */
  public Base[] getNamedValue(String name, boolean checkValid) throws FHIRException {
    if (checkValid)
      throw new FHIRException("Attempt to read invalid property '"+name+"' on type "+fhirType());
    return null;
  }

  /**
   * Create a new, empty instance of the named child, add it to this object, and return it. 
   * Only works for complex types: lists append the new instance, and singletons are set to it, 
   * replacing any existing value. Primitive-typed properties throw regardless of cardinality 
   * (use setProperty or the typed setters), as do abstract types (e.g. contained resources). 
   * Choice properties use the type-suffixed name (e.g. "valueQuantity", not "value[x]"). 
   * Overridden by the generated classes; throws for unknown names.
   */
  public Base addChild(String name) throws FHIRException {
    throw new FHIRException("Attempt to add child with unknown name "+name);
  }

  /**
   * Return the named child, creating it if necessary: existing values (or, for lists, a newly 
   * appended element) are returned rather than replaced - unlike addChild, which always makes a 
   * new instance. Primitives return their element (a primitive stands in for its own "value"). 
   * Throws for unknown names and for children that cannot be made (e.g. abstract resources). 
   * Overridden by the generated classes.
   */
  public Base makeProperty(String name) throws FHIRException {
    throw new FHIRException("Attempt to make an invalid property '"+name+"' on type "+fhirType());
  }

  /**
   * Set the named child to the given value, casting it to the property's type (an exception if 
   * it cannot be cast). For a list property the value is appended, not substituted. Choice 
   * properties use the "[x]" form of the name. Overridden by the generated classes; throws for 
   * unknown names.
   */
  public Base setProperty(String name, Base value) throws FHIRException {
    throw new FHIRException("Attempt to set unknown property "+name);
  }

  /**
   * Remove the given value from the named child. Same matching rule as List.remove: for lists, 
   * the matching (by equals) element is removed; for singletons, the property is cleared if it 
   * holds the given value. Passing null clears a singleton unconditionally. No effect if the 
   * value isn't found. Overridden by the generated classes; throws for unknown names.
   */
  public void removeChild(String name, Base value) throws FHIRException {
    throw new FHIRException("Attempt to remove child with unknown name "+name);
  }


  //endregion

  //region equality testing

  /**
   * Full structural equality: subclasses compare every child element recursively (complex and 
   * primitive), including element ids and extensions - even extensions on primitives. Not object 
   * identity; the Base-level features (user data etc.) are not compared. This base implementation 
   * only checks for null.
   */
	public boolean equalsDeep(Base other) {
	  return other != null;
  }

  /**
   * Local value equality: subclasses compare only the primitive values held directly by this 
   * element. Complex children are ignored entirely, and primitives are compared by value alone 
   * (extensions and ids don't count). Answers "is this element itself the same?" where equalsDeep 
   * answers "is this whole subtree the same?". This base implementation only checks for null.
   */
	public boolean equalsShallow(Base other) {
	  return other != null;
  }

  /** true if the list is effectively absent: null, empty, or a single empty element */
  private static boolean noList(List<? extends Base> list) {
    return list == null || list.isEmpty() || (list.size() == 1 && list.get(0).isEmpty());
  }

  /** null-safe string equality (both null == equal) */
  public static boolean equals(String v1, String v2) {
    if (v1 == null && v2 == null)
      return true;
    else if (v1 == null || v2 == null)
      return false;
    else
      return v1.equals(v2);
  }

  /** string comparison; if allowNull, absent (null or empty) on both sides counts as equal */
  public static boolean compareDeep(String s1, String s2, boolean allowNull) {
    if (allowNull) {
      boolean noLeft = s1 == null || Utilities.noString(s1);
      boolean noRight = s2 == null || Utilities.noString(s2);
      if (noLeft && noRight) {
        return true;
      }
    }
    if (s1 == null || s2 == null)
      return false;
    return s1.equals(s2);   
  }

  /** xhtml comparison via XhtmlNode.equalsDeep; if allowNull, null on both sides counts as equal */
  public static boolean compareDeep(XhtmlNode div1, XhtmlNode div2, boolean allowNull) {
    if (div1 == null && div2 == null && allowNull)
      return true;
    if (div1 == null || div2 == null)
      return false;
    return div1.equalsDeep(div2);
  }

  /** ordered pairwise value-only comparison of primitive lists (see compareValues); sizes must match */
  public static boolean compareValues(List<? extends PrimitiveType> e1, List<? extends PrimitiveType> e2, boolean allowNull) {
    if (e1 == null && e2 == null && allowNull)
      return true;
    if (e1 == null || e2 == null)
      return false;
    if (e1.size() != e2.size())
      return false;
    for (int i = 0; i < e1.size(); i++) {
      if (!compareValues(e1.get(i), e2.get(i), allowNull))
        return false;
    }
    return true;
  }

  /** 
   * value-only comparison of two primitives (same class + same value, via equalsShallow; 
   * extensions and ids ignored); if allowNull, missing or empty on both sides counts as equal 
   */
  public static boolean compareValues(PrimitiveType e1, PrimitiveType e2, boolean allowNull) {
    boolean noLeft = e1 == null || e1.isEmpty();
    boolean noRight = e2 == null || e2.isEmpty();
    if (noLeft && noRight && allowNull) {
      return true;
    }
    if (noLeft != noRight)
      return false;
    return e1.equalsShallow(e2);
  }

  /** ordered pairwise deep comparison of lists (see compareDeep); if allowNull, effectively-absent lists on both sides count as equal */
  public static boolean compareDeep(List<? extends Base> e1, List<? extends Base> e2, boolean allowNull) {
		if (noList(e1) && noList(e2) && allowNull)
			return true;
		if (noList(e1) || noList(e2))
			return false;
		if (e1.size() != e2.size())
			return false;
		for (int i = 0; i < e1.size(); i++) {
			if (!compareDeep(e1.get(i), e2.get(i), allowNull))
				return false;
		}
		return true;
	}
	
  /** 
   * full deep comparison of two elements via equalsDeep; if allowNull, empty on both sides counts 
   * as equal. When exactly one side is metadata-based, evaluation is delegated to that side (the 
   * outcome must be the same either way; this just keeps debugging deterministic) 
   */
  public static boolean compareDeep(Base e1, Base e2, boolean allowNull) {
		if (allowNull) {
			boolean noLeft = e1 == null || e1.isEmpty();
			boolean noRight = e2 == null || e2.isEmpty();
			if (noLeft && noRight) {
			return true;
			}
		}
		if (e1 == null || e2 == null)
			return false;
		if (e2.isMetadataBased() && !e1.isMetadataBased()) // respect existing order for debugging consistency; outcome must be the same either way
			return e2.equalsDeep(e1);
		else
		return e1.equalsDeep(e2);
	}


  //endregion

  //region clone/copy

  /** the Base-level features that copy() can carry over to the clone - the element content itself is always copied */
  public enum CopyObjectOptions { USER_DATA, COMMENTS, VALIDATION_INFO}
  public static final EnumSet<CopyObjectOptions> COPY_DATA = EnumSet.of(CopyObjectOptions.USER_DATA);
  public static final EnumSet<CopyObjectOptions> COPY_NOTHING = EnumSet.noneOf(CopyObjectOptions.class);
  public static final EnumSet<CopyObjectOptions> COPY_ALL = EnumSet.of(CopyObjectOptions.USER_DATA, CopyObjectOptions.COMMENTS, CopyObjectOptions.VALIDATION_INFO);

  /**
   * Produce a deep copy of this object: all element content, recursively. The options say which 
   * Base-level features (user data, format comments, validation info) travel with it - use the 
   * COPY_* constants for the common cases. Implemented by the generated classes.
   */
  public abstract Base copy(EnumSet<CopyObjectOptions> options); //

  /**
   * Copy this object's content onto dst: this implementation copies the option-selected 
   * Base-level features; the generated overrides copy their element content (passing the 
   * options down to every child they copy) and call super
   */
  public void copyValues(Base dst, EnumSet<CopyObjectOptions> options) {
    dst.setModelContext(modelContext); // no-op on the normal path (copy() constructs dst with this context); adopts a fresh dst; throws rather than corrupting a dst that belongs to a different context
    if (options.contains(CopyObjectOptions.USER_DATA)) {
      dst.userData = new HashMap<>();
      dst.userData.putAll(userData);
    }
    if (options.contains(CopyObjectOptions.COMMENTS)) {
      dst.formatCommentsPost = new ArrayList<>();
      dst.formatCommentsPost.addAll(formatCommentsPost);
      dst.formatCommentsPre = new ArrayList<>();
      dst.formatCommentsPre.addAll(formatCommentsPre);
    }
    if (options.contains(CopyObjectOptions.VALIDATION_INFO)) {
      dst.validationInfo = new ArrayList<>();
      dst.validationInfo.addAll(validationInfo);
    }
  }

  //endregion

  //region Validation Information
  /** true if the validator has recorded any definition matches on this element */
  public boolean hasValidationInfo() {
    return validationInfo != null;
  }

  /**
   * The definitions the validator matched this element to (or null if there are none). Being 
   * listed doesn't mean the element conforms - check isValid on the entries; some entries are 
   * noted in the course of slice matching
   */
  public List<ValidationInformation> getValidationInfo() {
    return validationInfo;
  }

  /** the recorded definition matches that come from the given profile (matched by instance identity) */
  public List<ValidationInformation>  getValidationInfoForProfile(StructureDefinition profile) {
    List<ValidationInformation> ret = new ArrayList<ValidationInformation>();
    for (ValidationInformation v : getValidationInfo()) {
      if (v.getStructure() == profile) {
        ret.add(v);
      }
    }
    return ret;
  }

  /**
   * Record that the validator matched this element to the given definition. Registering the 
   * same structure/definition/mode again returns the existing record rather than duplicating it
   */
  public ValidationInformation addDefinition(StructureDefinition structure, ElementDefinition defn, ValidationInformation.ValidationMode mode) {
    if (validationInfo == null) {
      validationInfo = new ArrayList<>();
    }
    for (ValidationInformation t : validationInfo) {
      if (t.getStructure() == structure && t.getDefinition() == defn && t.getReason() == mode.getReason() && t.getSource() == mode.getSource()) {
        return t;
      }
    }
    ValidationInformation vi = new ValidationInformation(structure, defn, mode);
    this.validationInfo.add(vi);
    return vi;
  }

  public boolean isValid() {
    if (hasValidationInfo()) {
      return false;
    } else {
      boolean valid = true;
      for (ValidationInformation t : validationInfo) {
        if (!t.isValid()) {
          valid = false;
        }
      }
      return valid;
    }
  }

  /** true if the validator has already recorded a match of this element to the given definition (used to break validation cycles) */
  public boolean hasValidated(StructureDefinition sd, ElementDefinition ed) {
    if (validationInfo != null) {
      for (ValidationInformation vi : validationInfo) {
        if (vi.getDefinition()  == ed && vi.getStructure() == sd) {
          return true;
        }
      }
    }
    return false;
  }

  //endregion

}