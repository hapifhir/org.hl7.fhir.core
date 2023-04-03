package org.hl7.fhir.r5.elementmodel;

import java.io.PrintStream;

/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.
  
  Redistribution and use in source and binary forms, with or without modification, 
  are permitted provided that the following conditions are met:
    
   * Redistributions of source code must retain the above copyright notice, this 
     list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright notice, 
     this list of conditions and the following disclaimer in the documentation 
     and/or other materials provided with the distribution.
   * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.
  
  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
  POSSIBILITY OF SUCH DAMAGE.
  
 */


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.Validate;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.conformance.profile.ProfileUtilities;
import org.hl7.fhir.r5.context.ContextUtilities;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.DataType;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent;
import org.hl7.fhir.r5.model.Enumerations.BindingStrength;
import org.hl7.fhir.r5.model.ICoding;
import org.hl7.fhir.r5.model.StringType;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind;
import org.hl7.fhir.r5.model.TypeConvertor;
import org.hl7.fhir.r5.model.ValueSet.ValueSetExpansionContainsComponent;
import org.hl7.fhir.r5.terminologies.ValueSetExpander.ValueSetExpansionOutcome;
import org.hl7.fhir.r5.utils.ToolingExtensions;
import org.hl7.fhir.utilities.ElementDecoration;
import org.hl7.fhir.utilities.ElementDecoration.DecorationType;
import org.hl7.fhir.utilities.SourceLocation;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

/**
 * This class represents the underlying reference model of FHIR
 * 
 * A resource is nothing but a set of elements, where every element has a 
 * name, maybe a stated type, maybe an id, and either a value or child elements 
 * (one or the other, but not both or neither)
 * 
 * @author Grahame Grieve
 *
 */
public class Element extends Base {

  public enum SpecialElement {
		CONTAINED, BUNDLE_ENTRY, BUNDLE_OUTCOME, BUNDLE_ISSUES, PARAMETER, LOGICAL;

    public static SpecialElement fromProperty(Property property) {
      if (property.getStructure().getType().equals("Parameters"))
        return PARAMETER;
      if (property.getStructure().getType().equals("Bundle") && property.getName().equals("resource"))
        return BUNDLE_ENTRY;
      if (property.getStructure().getType().equals("Bundle") && property.getName().equals("outcome"))
        return BUNDLE_OUTCOME;
      if (property.getStructure().getType().equals("Bundle") && property.getName().equals("issues"))
        return BUNDLE_ISSUES;
      if (property.getName().equals("contained")) 
        return CONTAINED;
      if (property.getStructure().getKind() == StructureDefinitionKind.LOGICAL)
        return LOGICAL;
      throw new FHIRException("Unknown resource containing a native resource: "+property.getDefinition().getId());
    }

    public String toHuman() {
      switch (this) {
      case BUNDLE_ENTRY: return "entry";
      case BUNDLE_OUTCOME: return "outcome";
      case BUNDLE_ISSUES: return "issues";
      case CONTAINED: return "contained";
      case PARAMETER: return "parameter";
      case LOGICAL: return "logical";
      default: return "??";        
      }
    }
	}

	private List<String> comments;// not relevant for production, but useful in documentation
	private String name;
	private String type;
	private String value;
	private int index = -1;
	private List<Element> children;
	private Property property;
  private Property elementProperty; // this is used when special is set to true - it tracks the underlying element property which is used in a few places
	private int line;
	private int col;
	private SpecialElement special;
	private XhtmlNode xhtml; // if this is populated, then value will also hold the string representation
	private String explicitType; // for xsi:type attribute
	private Element parentForValidator;
	private boolean hasParentForValidator;
	private String path;
	private List<ValidationMessage> messages;
	private boolean prohibited;
	private boolean required;
  private Map<String, List<Element>> childMap;
  private int descendentCount;
  private int instanceId;
  private boolean isNull;
  private Base source;
  private boolean ignorePropertyOrder;

	public Element(String name) {
		super();
		this.name = name;
	}

  public Element(Element other) {
    super();
    name = other.name;
    type = other.type;
    property = other.property;
    elementProperty = other.elementProperty;
    special = other.special;
  }
  
  public Element(String name, Property property) {
		super();
		this.name = name;
		this.property = property;
		if (property.isResource()) {
		  children = new ArrayList<>();
		}
	}

	public Element(String name, Property property, String type, String value) {
		super();
		this.name = name;
		this.property = property;
		this.type = type;
		this.value = value;
	}

	public void updateProperty(Property property, SpecialElement special, Property elementProperty) {
		this.property = property;
    this.elementProperty = elementProperty;
		this.special = special;
	}

	public SpecialElement getSpecial() {
		return special;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		if (type == null)
			return property.getType(name);
		else
		  return type;
	}

	public String getValue() {
		return value;
	}

	public boolean hasChildren() {
		return !(children == null || children.isEmpty());
	}

	public List<Element> getChildren() {
		if (children == null)
			children = new ArrayList<Element>();
		return children;
	}

	public boolean hasComments() {
		return !(comments == null || comments.isEmpty());
	}

	public List<String> getComments() {
		if (comments == null)
			comments = new ArrayList<String>();
		return comments;
	}

	public Property getProperty() {
		return property;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Element setType(String type) {
		this.type = type;
		return this;

	}

	public boolean isNull() {
    return isNull;
  }

  public void setNull(boolean isNull) {
    this.isNull = isNull;
  }

  public boolean hasValue() {
		return value != null;
	}

	public List<Element> getChildrenByName(String name) {
		List<Element> res = new ArrayList<Element>();
		if (children.size() > 20) {
      populateChildMap();
      List<Element> l = childMap.get(name);
      if (l != null) {
        res.addAll(l);
      }
    } else {
  		if (hasChildren()) {
  			for (Element child : children)
  				if (name.equals(child.getName()))
  					res.add(child);
  		}
    }
		return res;
	}

	public void numberChildren() {
		if (children == null)
			return;
		
		String last = "";
		int index = 0;
		for (Element child : children) {
			if (child.getProperty().isList()) {
			  if (last.equals(child.getName())) {
			  	index++;
			  } else {
			  	last = child.getName();
			  	index = 0;
			  }
		  	child.index = index;
			} else {
				child.index = -1;
			}
			child.numberChildren();
		}	
	}

	public int getIndex() {
		return index;
	}

	public boolean hasIndex() {
		return index > -1;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getChildValue(String name) {
		if (children == null)
			return null;
		for (Element child : children) {
			if (name.equals(child.getName()))
				return child.getValue();
		}
		for (Element child : children) {
      if (name.equals(child.getNameBase()))
        return child.getValue();
    }
  	return null;
	}

  private String getNameBase() {
    if (property.isChoice()) {
      return property.getName().replace("[x]", "");
    } else  {
      return getName();
    }
  }

  public void setChildValue(String name, String value) {
    if (children == null)
      children = new ArrayList<Element>();
    for (Element child : children) {
      if (name.equals(child.getName())) {
        if (!child.isPrimitive())
          throw new Error("Cannot set a value of a non-primitive type ("+name+" on "+this.getName()+")");
        child.setValue(value);
      }
    }
    childMap = null;
    try {
      setProperty(name.hashCode(), name, new StringType(value));
    } catch (FHIRException e) {
      throw new Error(e);
    }
  }

  public List<Element> getChildren(String name) {
    List<Element> res = new ArrayList<Element>(); 
    if (children.size() > 20) {
      populateChildMap();
      List<Element> l = childMap.get(name);
      if (l != null) {
        res.addAll(l);
      }
    } else {
      if (children != null)
        for (Element child : children) {
          if (name.equals(child.getName()))
            res.add(child);
        }
    }
		return res;
	}

  public boolean hasType() {
    if (type == null)
      return property.hasType(name);
    else
      return true;
  }

  @Override
  public String fhirType() {
    return getType();
  }

  @Override
	public Base[] getProperty(int hash, String name, boolean checkValid) throws FHIRException {
  	if (isPrimitive() && (hash == "value".hashCode()) && !Utilities.noString(value)) {
//  		String tn = getType();
//  		throw new Error(tn+" not done yet");
  	  Base[] b = new Base[1];
  	  b[0] = new StringType(value);
  	  return b;
  	}
  		
  	List<Base> result = new ArrayList<Base>();
  	if (children != null) {
  	  if (children.size() > 20) {
  	    populateChildMap();
        List<Element> l = childMap.get(name);
        if (l != null) {
          result.addAll(l);
        }
  	  } else {
      	for (Element child : children) {
  	    	if (child.getName().equals(name)) {
  			    result.add(child);
  	    	}
      		if (child.getName().startsWith(name) && child.getProperty().isChoice() && child.getProperty().getName().equals(name+"[x]")) {
  	    		result.add(child);
      		}
      	}
  	  }
  	}
  	if (result.isEmpty() && checkValid) {
//  		throw new FHIRException("not determined yet");
  	}
  	return result.toArray(new Base[result.size()]);
	}

  private void populateChildMap() {
    if (childMap == null) {
      childMap = new HashMap<>();
      for (Element child : children) {
        String n;
        if (child.getProperty().getName().endsWith("[x]")) {
          n = child.getProperty().getName();
          n = n.substring(0, n.length()-3);
        } else {
          n = child.getName();
        }
        List<Element> l = childMap.get(n);
        if (l == null) {
          l = new ArrayList<Element>();
          childMap.put(n,l);
        }
        l.add(child);
      }  	      
    }
  }

	@Override
	protected void listChildren(List<org.hl7.fhir.r5.model.Property> childProps) {
	  if (children != null) {
	    Map<String, org.hl7.fhir.r5.model.Property> map = new HashMap<String, org.hl7.fhir.r5.model.Property>();
	    for (Element c : children) {
	      org.hl7.fhir.r5.model.Property p = map.get(c.getName());
	      if (p == null) {
  	      p = new org.hl7.fhir.r5.model.Property(c.getName(), c.fhirType(), c.getProperty().getDefinition().getDefinition(), c.getProperty().getDefinition().getMin(), maxToInt(c.getProperty().getDefinition().getMax()), c);
          childProps.add(p);
          map.put(c.getName(), p);
  	      
	      } else
	        p.getValues().add(c);
	    }
	  }
	}
	
  @Override
  public Base setProperty(int hash, String name, Base value) throws FHIRException {
    if ("xhtml".equals(getType()) && (hash == "value".hashCode())) {
      this.xhtml = TypeConvertor.castToXhtml(value);
      this.value =  TypeConvertor.castToXhtmlString(value);
      return this;
    }
    if (isPrimitive() && (hash == "value".hashCode())) {
      this.value = TypeConvertor.castToString(value).asStringValue();
      return this;
    }
    
    if (!value.isPrimitive() && !(value instanceof Element)) {
      if (isDataType(value)) 
        value = convertToElement(property.getChild(name), value);
      else
        throw new FHIRException("Cannot set property "+name+" on "+this.name+" - value is not a primitive type ("+value.fhirType()+") or an ElementModel type");
    }
    
    childMap = null;
    if (children == null)
      children = new ArrayList<Element>();
    Element childForValue = null;
    
    // look through existing children
    for (Element child : children) {
      if (child.getName().equals(name)) {
        if (!child.isList()) {
          childForValue = child;
          break;
        } else {
          Element ne = new Element(child);
          children.add(ne);
          numberChildren();
          childForValue = ne;
          break;
        }
      }
    }

    int i = 0;
    if (childForValue == null)
      for (Property p : property.getChildProperties(this.name, type)) {
        int t = -1;
        for (int c =0; c < children.size(); c++) {
          Element e = children.get(c);
          if (p.getName().equals(e.getName()))
            t = c;
        }
        if (t >= i)
          i = t+1;
        if (p.getName().equals(name) || p.getName().equals(name+"[x]")) {
          Element ne = new Element(name, p);
          children.add(i, ne);
          childForValue = ne;
          break;
        }
      }
    
    if (childForValue == null)
      throw new Error("Cannot set property "+name+" on "+this.name);
    else if (value.isPrimitive()) {
      if (childForValue.property.getName().endsWith("[x]"))
        childForValue.name = name+Utilities.capitalize(value.fhirType());
      childForValue.setValue(value.primitiveValue());
    } else {
      Element ve = (Element) value;
      childForValue.type = ve.getType();
      if (childForValue.property.getName().endsWith("[x]"))
        childForValue.name = name+Utilities.capitalize(childForValue.type);
      else if (value.isResource()) {
        if (childForValue.elementProperty == null)
          childForValue.elementProperty = childForValue.property;
        childForValue.property = ve.property;
        childForValue.special = SpecialElement.BUNDLE_ENTRY;
      }
      if (ve.children != null) {
        if (childForValue.children == null)
          childForValue.children = new ArrayList<Element>();
        else 
          childForValue.children.clear();
        childForValue.children.addAll(ve.children);
      }
    }
    return childForValue;
  }

  private Base convertToElement(Property prop, Base v) throws FHIRException {
    return new ObjectConverter(property.getContext()).convert(prop, (DataType) v);
  }

  private boolean isDataType(Base v) {
    return v instanceof DataType && new ContextUtilities(property.getContext()).getTypeNames().contains(v.fhirType());
  }

  @Override
  public Base makeProperty(int hash, String name) throws FHIRException {
    if (isPrimitive() && (hash == "value".hashCode())) {
      return new StringType(value);
    } else {
      return makeElement(name);
    }
  }

  public Element makeElement(String name) throws FHIRException {
    if (children == null)
      children = new ArrayList<Element>();
    
    // look through existing children
    for (Element child : children) {
      if (child.getName().equals(name)) {
        if (!child.isList()) {
          return child;
        } else {
          Element ne = new Element(child);
          children.add(ne);
          numberChildren();
          return ne;
        }
      }
    }

    for (Property p : property.getChildProperties(this.name, type)) {
      if (p.getName().equals(name)) {
        Element ne = new Element(name, p);
        children.add(ne);
        return ne;
      } else if (p.getDefinition().isChoice() && name.startsWith(p.getName().replace("[x]", ""))) {
        String type = name.substring(p.getName().length()-3);
        if (new ContextUtilities(property.getContext()).isPrimitiveDatatype(Utilities.uncapitalize(type))) {
          type = Utilities.uncapitalize(type);
        }
        Element ne = new Element(name, p);
        ne.setType(type);
        children.add(ne);
        return ne;
        
      }
    }
      
    throw new Error("Unrecognised name "+name+" on "+this.name); 
  }

  public Element forceElement(String name) throws FHIRException {
    if (children == null)
      children = new ArrayList<Element>();
    
    // look through existing children
    for (Element child : children) {
      if (child.getName().equals(name)) {
        return child;
      }
    }

    for (Property p : property.getChildProperties(this.name, type)) {
      if (p.getName().equals(name)) {
        Element ne = new Element(name, p);
        children.add(ne);
        return ne;
      }
    }
      
    throw new Error("Unrecognised name "+name+" on "+this.name); 
  }


	private int maxToInt(String max) {
    if (max.equals("*"))
      return Integer.MAX_VALUE;
    else
      return Integer.parseInt(max);
	}

	@Override
	public boolean isPrimitive() {
		return type != null ? property.isPrimitive(type) : property.isPrimitive(property.getType(name));
	}
	
  @Override
  public boolean isBooleanPrimitive() {
    return isPrimitive() && ("boolean".equals(type) || "boolean".equals(property.getType(name)));
  }
 
  @Override
  public boolean isResource() {
    return property.isResource();
  }
  

	@Override
	public boolean hasPrimitiveValue() {
		return property.isPrimitiveName(name) || property.IsLogicalAndHasPrimitiveValue(name);
	}
	

	@Override
	public String primitiveValue() {
		if (isPrimitive() || value != null)
		  return value;
		else {
			if (hasPrimitiveValue() && children != null) {
				for (Element c : children) {
					if (c.getName().equals("value"))
						return c.primitiveValue();
				}
			}
			return null;
		}
	}
	
	// for the validator
  public int line() {
    return line;
  }

  public int col() {
    return col;
  }

	public Element markLocation(int line, int col) {
		this.line = line;
		this.col = col;	
		return this;
	}

  public Element markLocation(SourceLocation loc) {
    this.line = loc.getLine();
    this.col = loc.getColumn(); 
    return this;
  }

  public Element markLocation(Element src) {
    this.line = src.line();
    this.col = src.col(); 
    return this;
  }

	public void clearDecorations() {
	  clearUserData("fhir.decorations");
	  for (Element e : children) {
	    e.clearDecorations();	  
	  }
    childMap = null;
	}
	
	public void markValidation(StructureDefinition profile, ElementDefinition definition) {
	  @SuppressWarnings("unchecked")
    List<ElementDecoration> decorations = (List<ElementDecoration>) getUserData("fhir.decorations");
	  if (decorations == null) {
	    decorations = new ArrayList<>();
	    setUserData("fhir.decorations", decorations);
	  }
	  decorations.add(new ElementDecoration(DecorationType.TYPE, profile.getWebPath(), definition.getPath()));
	  if (definition.getId() != null && tail(definition.getId()).contains(":")) {
	    String[] details = tail(definition.getId()).split(":");
	    decorations.add(new ElementDecoration(DecorationType.SLICE, null, details[1]));
	  }
	}
	
  private String tail(String id) {
    return id.contains(".") ? id.substring(id.lastIndexOf(".")+1) : id;
  }

  public Element getNamedChild(String name) {
    if (children == null)
      return null;
    if (children.size() > 20) {
      populateChildMap();
      List<Element> l = childMap.get(name);
      if (l == null) {
        // try the other way (in case of complicated naming rules)
      } else if (l.size() > 1) {
        throw new Error("Attempt to read a single element when there is more than one present ("+name+")");
      } else {
        return l.get(0);
      }
    } else {
      
    }
    Element result = null;
    
    for (Element child : children) {
      if (child.getName() != null && name != null && child.getProperty() != null && child.getProperty().getDefinition() != null && child.fhirType() != null) {
        if (child.getName().equals(name) || (child.getName().length() >  child.fhirType().length() && child.getName().substring(0, child.getName().length() - child.fhirType().length()).equals(name) && child.getProperty().getDefinition().isChoice())) {
          if (result == null)
            result = child;
          else 
            throw new Error("Attempt to read a single element when there is more than one present ("+name+")");
        }
      }
    }
	  return result;
	}

  public void getNamedChildren(String name, List<Element> list) {
  	if (children != null)
  	  if (children.size() > 20) {
        populateChildMap();
        List<Element> l = childMap.get(name);
        if (l != null) {
          list.addAll(l);
        }
      } else {
  		  for (Element child : children) 
  			  if (child.getName().equals(name))
  				  list.add(child);
      }
  }

  public String getNamedChildValue(String name) {
  	Element child = getNamedChild(name);
  	return child == null ? null : child.value;
  }

  public void getNamedChildrenWithWildcard(String string, List<Element> values) {
	  Validate.isTrue(string.endsWith("[x]"));
	  
	  String start = string.substring(0, string.length() - 3);
	  	if (children != null) {
	  		for (Element child : children) { 
	  			if (child.getName().startsWith(start)) {
	  				values.add(child);
	  			}
	  		}
	  	}
  }

  
	public XhtmlNode getXhtml() {
		return xhtml;
	}

	public Element setXhtml(XhtmlNode xhtml) {
		this.xhtml = xhtml;
		return this;
 	}

	@Override
	public boolean isEmpty() {
  	// GG: this used to also test !"".equals(value). 
    // the condition where "" is empty and there are no children is an error, and so this really only manifested as an issue in corner cases technical testing of the validator / FHIRPath.
	  // it should not cause any problems in real life.
		if (value != null) {   
			return false;
		}
		for (Element next : getChildren()) {
			if (!next.isEmpty()) {
				return false;
			}
		}
		return true;
	}

  public Property getElementProperty() {
    return elementProperty;
  }

  public boolean hasElementProperty() {
    return elementProperty != null;
  }

  public boolean hasChild(String name) {
    return getNamedChild(name) != null;
  }

  public boolean hasChildren(String name) {
    if (children != null)
      for (Element child : children) 
        if (child.getName().equals(name))
          return true;
    return false;
  }

  @Override
  public String toString() {
    if (name.equals(fhirType()) && isResource()) {
      return fhirType()+"/"+getIdBase() + "["+(children == null || hasValue() ? value : Integer.toString(children.size())+" children")+"]";
      
    } else if (isResource()) {
      return name+"="+fhirType()+"/"+getIdBase()+ "["+(children == null || hasValue() ? value : Integer.toString(children.size())+" children")+"]";
    } else {
      return name+"="+fhirType() + "["+(children == null || hasValue() ? value : Integer.toString(children.size())+" children")+"]";
    }
  }

  @Override
  public String getIdBase() {
    return getChildValue("id");
  }

  @Override
  public void setIdBase(String value) {
    setChildValue("id", value);
  }


  @Override
  public boolean equalsDeep(Base other) {
    if (!super.equalsDeep(other))
      return false;
    if (isPrimitive() && other.isPrimitive())
      return primitiveValue().equals(other.primitiveValue());
    if (isPrimitive() || other.isPrimitive())
      return false;
    Set<String> processed  = new HashSet<String>();
    for (org.hl7.fhir.r5.model.Property p : children()) {
      String name = p.getName();
      processed.add(name);
      org.hl7.fhir.r5.model.Property o = other.getChildByName(name);
      if (!equalsDeep(p, o))
        return false;
    }
    for (org.hl7.fhir.r5.model.Property p : children()) {
      String name = p.getName();
      if (!processed.contains(name)) {
        org.hl7.fhir.r5.model.Property o = other.getChildByName(name);
        if (!equalsDeep(p, o))
          return false;
      }
    }
    return true;
  }

  private boolean equalsDeep(org.hl7.fhir.r5.model.Property p, org.hl7.fhir.r5.model.Property o) {
    if (o == null || p == null)
      return false;
    if (p.getValues().size() != o.getValues().size())
      return false;
    for (int i = 0; i < p.getValues().size(); i++)
      if (!Base.compareDeep(p.getValues().get(i), o.getValues().get(i), true))
        return false;
    return true;
  }

  @Override
  public boolean equalsShallow(Base other) {
    if (!super.equalsShallow(other))
      return false;
    if (isPrimitive() && other.isPrimitive())
      return primitiveValue().equals(other.primitiveValue());
    if (isPrimitive() || other.isPrimitive())
      return false;
    return true; //?
  }

  public DataType asType() throws FHIRException {
    return new ObjectConverter(property.getContext()).convertToType(this);
  }

  @Override
  public boolean isMetadataBased() {
    return true;
  }

  public boolean isList() {
    if (elementProperty != null)
      return elementProperty.isList();
    else
      return property.isList();
  }
  
  public boolean isBaseList() {
    if (elementProperty != null)
      return elementProperty.isBaseList();
    else
      return property.isBaseList();
  }
  
  @Override
  public String[] getTypesForProperty(int hash, String name) throws FHIRException {
    Property p = property.getChildSimpleName(this.name, name);
    if (p != null) {
      Set<String> types = new HashSet<String>();
      for (TypeRefComponent tr : p.getDefinition().getType()) {
        types.add(tr.getCode());
      }
      return types.toArray(new String[]{});
    }
    return super.getTypesForProperty(hash, name);

  }

  public void sort() {
    if (children != null) {
      List<Element> remove = new ArrayList<Element>();
      for (Element child : children) {
        child.sort();
        if (child.isEmpty())
          remove.add(child);
      }
      children.removeAll(remove);
      Collections.sort(children, new ElementSortComparator(this, this.property));
      childMap = null;
    }
  }

  public class ElementSortComparator implements Comparator<Element> {
    private List<ElementDefinition> children;
    public ElementSortComparator(Element e, Property property) {
      String tn = e.getType();
      StructureDefinition sd = property.getContext().fetchResource(StructureDefinition.class, ProfileUtilities.sdNs(tn, null));
      if (sd != null && !sd.getAbstract())
        children = sd.getSnapshot().getElement();
      else
        children = property.getStructure().getSnapshot().getElement();
    }
    
    @Override
    public int compare(Element e0, Element e1) {
      int i0 = find(e0);
      int i1 = find(e1);
      return Integer.compare(i0, i1);
    }
    private int find(Element e0) {
      int i =  e0.elementProperty != null ? children.indexOf(e0.elementProperty.getDefinition()) :  children.indexOf(e0.property.getDefinition());
      return i; 
    }

  }

  public class ICodingImpl implements ICoding {
    private String system;
    private String version;
    private String code;
    private String display;
    private boolean doesSystem;
    private boolean doesVersion;
    private boolean doesCode;
    private boolean doesDisplay;
    public ICodingImpl(boolean doesCode, boolean doesSystem, boolean doesVersion, boolean doesDisplay) {
      super();
      this.doesCode = doesCode;
      this.doesSystem = doesSystem;
      this.doesVersion = doesVersion;
      this.doesDisplay = doesDisplay;
    }
    public String getSystem() {
      return system;
    }
    public String getVersion() {
      return version;
    }
    public String getCode() {
      return code;
    }
    public String getDisplay() {
      return display;
    }
    public boolean hasSystem() {
      return !Utilities.noString(system); 
    }
    public boolean hasVersion() {
      return !Utilities.noString(version);
    }
    public boolean hasCode() {
      return !Utilities.noString(code);
    }
    public boolean hasDisplay() {
      return !Utilities.noString(display);
    }
    public boolean supportsSystem() {
      return doesSystem;
    }
    public boolean supportsVersion() {
      return doesVersion;
    }
    public boolean supportsCode() {
      return doesCode;
    }
    public boolean supportsDisplay() {
      return doesDisplay;
    }    
  }

  public ICoding getAsICoding() throws FHIRException {
    if ("code".equals(fhirType())) {
      if (property.getDefinition().getBinding().getStrength() != BindingStrength.REQUIRED)
        return null;
      ICodingImpl c = new ICodingImpl(true, true, false, false);
      c.code = primitiveValue();
      ValueSetExpansionOutcome vse = property.getContext().expandVS(property.getStructure(), property.getDefinition().getBinding(), true, false);
      if (vse.getValueset() == null)
        return null;
      for (ValueSetExpansionContainsComponent cc : vse.getValueset().getExpansion().getContains()) {
        if (cc.getCode().equals(c.code)) {
          c.system = cc.getSystem();
          if (cc.hasVersion()) {
            c.doesVersion = true;
            c.version = cc.getVersion();
          }
          if (cc.hasDisplay()) {
            c.doesDisplay = true;
            c.display = cc.getDisplay();
          }
        }
      }
      if (c.system == null)
        return null;
      return c;   
    } else if ("Coding".equals(fhirType())) {
      ICodingImpl c = new ICodingImpl(true, true, true, true);
      c.system = getNamedChildValue("system");
      c.code = getNamedChildValue("code");
      c.display = getNamedChildValue("display");
      c.version = getNamedChildValue("version");
      return c;
    } else if ("Quantity".equals(fhirType())) {
      ICodingImpl c = new ICodingImpl(true, true, false, false);
      c.system = getNamedChildValue("system");
      c.code = getNamedChildValue("code");
      return c;
    } else 
      return null;
  }

  public String getExplicitType() {
    return explicitType;
  }

  public void setExplicitType(String explicitType) {
    this.explicitType = explicitType;
  }

  public boolean hasDescendant(Element element) {
    if (children != null) {
      for (Element child : children) {
        if (element == child || child.hasDescendant(element)) {
          return true;        
        }
      }
    }
    return false;
  }

  public Element getExtension(String url) {
    if (children != null) {
      for (Element child : children) {
        if (Utilities.existsInList(child.getName(), "extension", "modifierExtension")) {
          String u = child.getChildValue("url");
          if (url.equals(u)) {
            return child;
          }
        }
      }
    }
    return null;
  }

  public Base getExtensionValue(String url) {
    if (children != null) {
      for (Element child : children) {
        if (Utilities.existsInList(child.getName(), "extension", "modifierExtension")) {
          String u = child.getChildValue("url");
          if (url.equals(u)) {
            return child.getNamedChild("value");
          }
        }
      }
    }
    return null;
  }

  public boolean hasExtension(String url) {
    if (children != null) {
      for (Element child : children) {
        if (Utilities.existsInList(child.getName(), "extension", "modifierExtension")) {
          String u = child.getChildValue("url");
          if (url.equals(u)) {
            return true;
          }
        }
      }
    }
    return false;
  }

  /**
   * this is set by the instance validator. There's no reason to maintain this when working with an element tree, and so it should be ignored outside the validator
   */
  public Element getParentForValidator() {
    if (!hasParentForValidator) {
      throw new Error("Parent not set");
    }
    return parentForValidator;
  }

  public void setParentForValidator(Element parentForValidator) {
    this.parentForValidator = parentForValidator;
    this.hasParentForValidator = true;
  }
  
  public boolean hasParentForValidator() {
    return hasParentForValidator;
  }

  public void clear() {
    comments = null;
    children.clear();
    childMap = null;
    property = null;
    elementProperty = null;
    xhtml = null;
    path = null;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }  
  
  public void addMessage(ValidationMessage vm) {
    if (messages == null) {
      messages = new ArrayList<>();
    }
    messages.add(vm);
  }

  public boolean hasMessages() {
    return messages != null && !messages.isEmpty();
  }

  public List<ValidationMessage> getMessages() {
    return messages;
  }

  public void removeChild(String name) {
    children.removeIf(n -> name.equals(n.getName()));
    childMap = null;
  }

  public boolean isProhibited() {
    return prohibited;
  }

  public void setProhibited(boolean prohibited) {
    this.prohibited = prohibited;
  }

  public boolean isRequired() {
    return required;
  }

  public void setRequired(boolean required) {
    this.required = required;
  }

  public int getDescendentCount() {
    return descendentCount;
  }

  public void setDescendentCount(int descendentCount) {
    this.descendentCount = descendentCount;
  }

  public int countDescendents() {
    if (descendentCount > 0) {
      return descendentCount;
    } else if (children != null) {
      descendentCount = children.size();
      for (Element e : children) {
        descendentCount = descendentCount + e.countDescendents();
      }
    } else {
      descendentCount = 0;
    }
    return descendentCount;
  }

  public int getInstanceId() {
    return instanceId;
  }

  public void setInstanceId(int instanceId) {
    this.instanceId = instanceId;
  }


  @Override
  public boolean hasValidationInfo() {
    return hasSource() ? source.hasValidationInfo() : super.hasValidationInfo();
  }

  @Override
  public List<ValidationInfo> getValidationInfo() {
    return hasSource() ? source.getValidationInfo() : super.getValidationInfo();
  }

  @Override
  public ValidationInfo addDefinition(StructureDefinition source, ElementDefinition defn, ValidationMode mode) {
    if (this.source != null) {
      return this.source.addDefinition(source, defn, mode);
    } else {
      return super.addDefinition(source, defn, mode);
    }
  }

  public boolean hasSource() {
    return source != null;
  }

  
  public Base getSource() {
    return source;
  }

  public void setSource(Base source) {
    this.source = source;
  }

  public void printToOutput() {
    printToOutput(System.out, "");
    
  }

  public void printToOutput(PrintStream stream) {
    printToOutput(stream, "");
    
  }

  private void printToOutput(PrintStream out, String indent) {
    String s = indent+name +(index == -1 ? "" : "["+index+"]") +(special != null ? "$"+special.toHuman(): "")+ (type!= null || explicitType != null ? " : "+type+(explicitType != null ? "/'"+explicitType+"'" : "") : "");
    if (isNull) {
      s = s + " = (null)";
    } else if (value != null) {
      s = s + " = '"+value+"'";      
    } else if (xhtml != null) {
      s = s + " = (xhtml)";
    }
    if (property != null) {
      s = s +" {"+property.summary();
      if (elementProperty != null) {
        s = s +" -> "+elementProperty.summary();
      }
      s = s + "}";
    }
    if (line > 0) {
      s = s + " (l"+line+":c"+col+")";
    }
    out.println(s);
    if (children != null) {
      for (Element child : children) {
        child.printToOutput(out, indent+"  ");
      }
    }
    
  }

  private String msgCounts() {
    int e = 0;
    int w = 0;
    int h = 0;
    for (ValidationMessage msg : messages) {
      switch (msg.getLevel()) {
      case ERROR:
        e++;
        break;
      case FATAL:
        e++;
        break;
      case INFORMATION:
        h++;
        break;
      case NULL:
        break;
      case WARNING:
        w++;
        break;
      default:
        break;      
      }
    }
    return "e:"+e+",w:"+w+",h:"+h;
  }

  public void populatePaths(String path) {
    if (path == null) {
      path = fhirType();
    }
    setPath(path);
    if (children != null) {
      for (Element n : children) {
        n.populatePaths(path+"."+n.getName());
      }
    }
    
  }

  public String fhirTypeRoot() {
    if (fhirType().contains("/")) {
      return fhirType().substring(fhirType().lastIndexOf("/")+1);
    } else {
      return fhirType();
    }
  }

  public void setElement(String string, Element map) {
    throw new Error("Not done yet");    
  }

  public Element addElement(String name) {
    if (children == null)
      children = new ArrayList<Element>();

    for (Property p : property.getChildProperties(this.name, type)) {
      if (p.getName().equals(name)) {
        if (!p.isList()) {
          throw new Error(name+" on "+this.name+" is not a list, so can't add an element"); 
        }
        Element ne = new Element(name, p);
        children.add(ne);
        return ne;
      }
    }

    throw new Error("Unrecognised name "+name+" on "+this.name); 
  }

  @Override
  public Base copy() {
    Element element = new Element(this);
    this.copyValues(element);
    return element;
  }

  @Override
  public void copyValues(Base dst) {
    super.copyValues(dst);
    
    Element dest = (Element) dst;
    if (comments != null) {
      dest.comments = new ArrayList<>();
      dest.comments.addAll(comments);
    } else {
      dest.comments = null;
    }
    dest.value = value;
    if (children != null) {
      dest.children = new ArrayList<>();
      dest.children.addAll(children);
    } else {
      dest.children = null;
    }
    dest.line = line;
    dest.col = col;
    dest.xhtml = xhtml;
    dest.explicitType = explicitType;
    dest.hasParentForValidator = false;
    dest.path = path;
    dest.messages = null;
    dest.prohibited = prohibited;
    dest.required = required;
    dest.childMap = null;
    dest.descendentCount = descendentCount;
    dest.instanceId = instanceId;
    dest.isNull = isNull;
    dest.source = source;
  }
  
  public Base setProperty(String name, Base value) throws FHIRException {
    setChildValue(name, value.primitiveValue());
    return this;
  }

  public boolean isIgnorePropertyOrder() {
    return ignorePropertyOrder;
  }

  public void setIgnorePropertyOrder(boolean ignorePropertyOrder) {
    this.ignorePropertyOrder = ignorePropertyOrder;
    if (children != null) {
      for (Element e : children) {
        e.setIgnorePropertyOrder(ignorePropertyOrder);
      }
    }
  }
  

  private String webPath;
  public boolean hasWebPath() {
    return webPath != null;
  }
  public String getWebPath() {
    return webPath;
  }
  public void setWebPath(String webPath) {
    if (webPath != null && webPath.startsWith("file:")) {
      System.out.println("!"); // FIXME
    }
    this.webPath = webPath;
  }

  public String getTranslation(String lang) {
    for (Element e : getChildren()) {
      if (e.fhirType().equals("Extension")) {
        String url = e.getNamedChildValue("url");
        if (ToolingExtensions.EXT_TRANSLATION.equals(url)) {
          String l = null;
          String v = null;
          for (Element g : e.getChildren()) {
            if (g.fhirType().equals("Extension")) {
              String u = g.getNamedChildValue("url");
              if ("lang".equals(u)) {
                l = g.getNamedChildValue("value");
              } else if ("value".equals(u)) {
                v = g.getNamedChildValue("value");
              }
            }
          }
          if (lang.equals(l)) {
            return v;
          }
        }
      }
    }
    return null;
  }
}