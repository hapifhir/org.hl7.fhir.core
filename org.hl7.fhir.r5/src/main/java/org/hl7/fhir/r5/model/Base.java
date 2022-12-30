package org.hl7.fhir.r5.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.instance.model.api.IBase;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

import ca.uhn.fhir.model.api.IElement;

public abstract class Base implements Serializable, IBase, IElement {

  public enum ValidationReason {
    Validation, MatchingSlice, Expression    
  }
  
  public enum ProfileSource {
    BaseDefinition, ConfigProfile, MetaProfile, ProfileDependency, FromExpression,  GlobalProfile
  }
  
  public static class ValidationMode {
    private ValidationReason reason;
    private ProfileSource source;
    public ValidationMode(ValidationReason reason, ProfileSource source) {
      super();
      this.reason = reason;
      this.source = source;
    }
    public ValidationReason getReason() {
      return reason;
    }
    public ProfileSource getSource() {
      return source;
    }
    public ValidationMode withSource(ProfileSource source) {
      ValidationMode res = new ValidationMode(reason, source);
      return res;
    }
    public ValidationMode withReason(ValidationReason reason) {
      ValidationMode res = new ValidationMode(reason, source);
      return res;
    }
  }
  
  public class ValidationInfo {
    private StructureDefinition structure;
    private ElementDefinition definition;
    private ValidationReason reason;
    private ProfileSource source;
    private boolean valid;
    
    public ValidationInfo(StructureDefinition structure, ElementDefinition definition, ValidationMode mode) {
      super();
      this.structure = structure;
      this.definition = definition;
      this.reason = mode.reason;
      this.source = mode.source;
    }
    
    public StructureDefinition getStructure() {
      return structure;
    }
    
    public ElementDefinition getDefinition() {
      return definition;
    }
    
    public ValidationReason getReason() {
      return reason;
    }

    public ProfileSource getSource() {
      return source;
    }

    public boolean isValid() {
      return valid;
    }
    public void setValid(boolean valid) {
      this.valid = valid;
    }

  }

  /**
   * User appended data items - allow users to add extra information to the class
   */
  private transient Map<String, Object> userData; 

  /**
   * Post Validation Definition information
   */
  private transient List<ValidationInfo> validationInfo;

  /**
   * Round tracking xml comments for testing convenience
   */
  private List<String> formatCommentsPre; 
   
  /**
   * Round tracking xml comments for testing convenience
   */
  private List<String> formatCommentsPost; 
   
  
  public Object getUserData(String name) {
    if (userData == null)
      return null;
    return userData.get(name);
  }
  
  public void setUserData(String name, Object value) {
    if (userData == null)
      userData = new HashMap<String, Object>();
    userData.put(name, value);
  }

  public void clearUserData(String name) {
    if (userData != null)
      userData.remove(name);
  }
  
  public void setUserDataINN(String name, Object value) {
    if (value == null)
      return;
    
    if (userData == null)
      userData = new HashMap<String, Object>();
    userData.put(name, value);
  }

  public boolean hasUserData(String name) {
    if (userData == null)
      return false;
    else
      return userData.containsKey(name) && (userData.get(name) != null);
  }

	public String getUserString(String name) {
    Object ud = getUserData(name);
    if (ud == null)
      return null;
    if (ud instanceof String)
      return (String) ud;
    return ud.toString();
  }

  public int getUserInt(String name) {
    if (!hasUserData(name))
      return 0;
    return (Integer) getUserData(name);
  }

  public void copyUserData(Base other) {
    if (other.userData != null) {
      if (userData == null) {
        userData = new HashMap<>();
      }
      userData.putAll(other.userData);
    }
  }      

  public boolean hasFormatComment() {
  	return (formatCommentsPre != null && !formatCommentsPre.isEmpty()) || (formatCommentsPost != null && !formatCommentsPost.isEmpty());
  }
  
  public List<String> getFormatCommentsPre() {
    if (formatCommentsPre == null)
      formatCommentsPre = new ArrayList<String>();
    return formatCommentsPre;
  }
  
  public List<String> getFormatCommentsPost() {
    if (formatCommentsPost == null)
      formatCommentsPost = new ArrayList<String>();
    return formatCommentsPost;
  }  
  
	// these 3 allow evaluation engines to get access to primitive values
	public boolean isPrimitive() {
		return false;
	}
	
  public boolean isBooleanPrimitive() {
    return false;
  }

	public boolean hasPrimitiveValue() {
		return isPrimitive();
	}
	
	public String primitiveValue() {
		return null;
	}
	
  public boolean isDateTime() {
    return false;
  }

  public BaseDateTimeType dateTimeValue() {
    return null;
  }
  
	public abstract String fhirType() ;
	
	public boolean hasType(String... name) {
		String t = fhirType();
		for (String n : name)
		  if (n.equalsIgnoreCase(t))
		  	return true;
		return false;
	}
	
	protected void listChildren(List<Property> result) {
	  // nothing
	}
	
	public Base setProperty(String name, Base value) throws FHIRException {
	  throw new FHIRException("Attempt to set unknown property "+name);
	}
	
	public Base addChild(String name) throws FHIRException {
    throw new FHIRException("Attempt to add child with unknown name "+name);
  }

	public boolean removeChild(String name, Base value) {
    throw new FHIRException("Attempt to remove child with unknown name "+name);
	}
  /**
   * Supports iterating the children elements in some generic processor or browser
   * All defined children will be listed, even if they have no value on this instance
   * 
   * Note that the actual content of primitive or xhtml elements is not iterated explicitly.
   * To find these, the processing code must recognise the element as a primitive, typecast
   * the value to a {@link DataType}, and examine the value
   *  
   * @return a list of all the children defined for this element
   */
  public List<Property> children() {
  	List<Property> result = new ArrayList<Property>();
  	listChildren(result);
  	return result;
  }

  public Property getChildByName(String name) {
    List<Property> children = new ArrayList<Property>();
    listChildren(children);
    for (Property c : children)
      if (c.getName().equals(name) || c.getName().equals(name+"[x]")) {
        return c;
      }
      return null;
    }
  
  public List<Base> listChildrenByName(String name) throws FHIRException {
    List<Base> result = new ArrayList<Base>();
  	for (Base b : listChildrenByName(name, true))
  		if (b != null)
  		  result.add(b);
    return result;
  }

  public Base[] listChildrenByName(String name, boolean checkValid) throws FHIRException {
  	if (name.equals("*")) {
  		List<Property> children = new ArrayList<Property>();
  		listChildren(children);
  		List<Base> result = new ArrayList<Base>();
  		for (Property c : children)
				result.addAll(c.getValues());
  		return result.toArray(new Base[result.size()]);
  	}
  	else
    	return getProperty(name.hashCode(), name, checkValid);
  }

	public boolean isEmpty() {
	  return true; // userData does not count
  }

	public boolean equalsDeep(Base other) {
	  return other != null;
  }  
  
	public boolean equalsShallow(Base other) {
	  return other != null;
  }  
  
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
	
	private static boolean noList(List<? extends Base> list) {
    return list == null || list.isEmpty() || (list.size() == 1 && list.get(0).isEmpty());
  }

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
	
	public static boolean compareDeep(XhtmlNode div1, XhtmlNode div2, boolean allowNull) {
		if (div1 == null && div2 == null && allowNull)
			return true;
		if (div1 == null || div2 == null)
			return false;
		return div1.equalsDeep(div2);
  }


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
	
	protected boolean isMetadataBased() {
  	return false;
	}

	public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
		if (checkValid)
			throw new FHIRException("Attempt to read invalid property '"+name+"' on type "+fhirType());
  	return null; 
	}

	public Base setProperty(int hash, String name, Base value) throws FHIRException {
		throw new FHIRException("Attempt to write to invalid property '"+name+"' on type "+fhirType());
	}

	public Base makeProperty(int hash, String name) throws FHIRException {
		throw new FHIRException("Attempt to make an invalid property '"+name+"' on type "+fhirType());
	}

	public String[] getTypesForProperty(int hash, String name) throws FHIRException {
    throw new FHIRException("Attempt to get types for an invalid property '"+name+"' on type "+fhirType());
	}
	
	public static boolean equals(String v1, String v2) {
  	if (v1 == null && v2 == null)
  		return true;
  	else if (v1 == null || v2 == null)
    	return false;
  	else
  		return v1.equals(v2);
	}

  public boolean isResource() {
    return false;
  }
	

  public abstract String getIdBase();
  public abstract void setIdBase(String value);

  public Property getNamedProperty(String _name) throws FHIRException {
    return getNamedProperty(_name.hashCode(), _name, false);
  }
  public Property getNamedProperty(int _hash, String _name, boolean _checkValid) throws FHIRException {
    if (_checkValid)
      throw new FHIRException("Attempt to read invalid property '"+_name+"' on type "+fhirType());
    return null; 
  }

  public void copyValues(Base dst) {   
  }

  /**
   * return XHTML if this is an XHTML node, else null
   * 
   * @return
   */
  public XhtmlNode getXhtml() {
    return null;
  }


  public boolean hasValidationInfo() {
    return validationInfo != null;
  }

  /**
   * A list of definitions that the validator matched this element to.
   * Note that the element doesn't have to conform to these definitions - check whether they're valid 
   * Some of the definitions will be noted because of slice matching
   * 
   * @return
   */
  public List<ValidationInfo> getValidationInfo() {
    return validationInfo;
  }

  public ValidationInfo addDefinition(StructureDefinition structure, ElementDefinition defn, ValidationMode mode) {
    if (validationInfo == null) {
      validationInfo = new ArrayList<>();
    }
    for (ValidationInfo t : validationInfo) {
      if (t.structure == structure && t.definition == defn && t.reason == mode.reason && t.source == mode.source) {
        return t;
      }
    }
    ValidationInfo vi = new ValidationInfo(structure, defn, mode);
    this.validationInfo.add(vi);
    return vi;
  }
}