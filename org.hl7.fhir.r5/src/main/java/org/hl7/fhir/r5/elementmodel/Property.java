package org.hl7.fhir.r5.elementmodel;

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
import java.util.List;

import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.conformance.profile.ProfileUtilities;
import org.hl7.fhir.r5.conformance.profile.ProfileUtilities.SourcedChildDefinitions;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.formats.FormatUtilities;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.ElementDefinition.PropertyRepresentation;
import org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent;
import org.hl7.fhir.r5.model.Extension;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind;
import org.hl7.fhir.r5.model.TypeDetails;
import org.hl7.fhir.r5.utils.ToolingExtensions;
import org.hl7.fhir.r5.utils.TypesUtilities;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.StringPair;
import org.hl7.fhir.utilities.Utilities;

public class Property {

	private IWorkerContext context;
	private ElementDefinition definition;
	private StructureDefinition structure;
  private ProfileUtilities profileUtilities;
  private TypeRefComponent type;

  public Property(IWorkerContext context, ElementDefinition definition, StructureDefinition structure, ProfileUtilities profileUtilities) {
		this.context = context;
		this.definition = definition;
		this.structure = structure;
    this.profileUtilities = profileUtilities;
	}


  public Property(IWorkerContext context, ElementDefinition definition, StructureDefinition structure, ProfileUtilities profileUtilities, String type) {
    this.context = context;
    this.definition = definition;
    this.structure = structure;
    this.profileUtilities = profileUtilities;
    for (TypeRefComponent tr : definition.getType()) {
      if (tr.getWorkingCode().equals(type)) {
        this.type = tr;
      }
    }
  }
  
	public Property(IWorkerContext context, ElementDefinition definition, StructureDefinition structure) {
    this(context, definition, structure, new ProfileUtilities(context, null, null));
	}

	public String getName() {
		return definition.getPath().substring(definition.getPath().lastIndexOf(".")+1);
	}

  public String getJsonName() {
    if (definition.hasExtension(ToolingExtensions.EXT_JSON_NAME)) {
      return ToolingExtensions.readStringExtension(definition, ToolingExtensions.EXT_JSON_NAME);
    } else {
      return getName();
    }
  }

  public String getXmlName() {
    if (definition.hasExtension(ToolingExtensions.EXT_XML_NAME)) {
      return ToolingExtensions.readStringExtension(definition, ToolingExtensions.EXT_XML_NAME);
    } else {
      return getName();
    }
  }

  public String getXmlNamespace() {
    if (ToolingExtensions.hasExtension(definition, "http://hl7.org/fhir/StructureDefinition/elementdefinition-namespace")) {
      return ToolingExtensions.readStringExtension(definition, "http://hl7.org/fhir/StructureDefinition/elementdefinition-namespace");
    } else if (ToolingExtensions.hasExtension(structure, "http://hl7.org/fhir/StructureDefinition/elementdefinition-namespace")) {
      return ToolingExtensions.readStringExtension(structure, "http://hl7.org/fhir/StructureDefinition/elementdefinition-namespace");
    } else {
      return FormatUtilities.FHIR_NS;
    }
  }
	
	public ElementDefinition getDefinition() {
		return definition;
	}

	public String getType() {
	  if (type != null) {
	    return type.getWorkingCode();
	  } else  if (definition.getType().size() == 0)
			return null;
		else if (definition.getType().size() > 1) {
			String tn = definition.getType().get(0).getWorkingCode();
			for (int i = 1; i < definition.getType().size(); i++) {
				if (!tn.equals(definition.getType().get(i).getWorkingCode()))
					return null; // though really, we shouldn't get here - type != null when definition.getType.size() > 1, or it should be
			}
			return tn;
		} else
			return definition.getType().get(0).getWorkingCode();
	}

	public String getType(String elementName) {
	  if (type != null) {
      return type.getWorkingCode();
    } 
	  if (!definition.getPath().contains("."))
      return definition.getPath();
    ElementDefinition ed = definition;
    if (definition.hasContentReference()) {
      String url = null;
      String path = definition.getContentReference();
      if (!path.startsWith("#")) {
        if (path.contains("#")) {
          url = path.substring(0, path.indexOf("#"));
          path = path.substring(path.indexOf("#")+1);
        } else {
          throw new Error("Illegal content reference '"+path+"'");
        }
      } else {
        path = path.substring(1);
      }
      StructureDefinition sd = (url == null || url.equals(structure.getUrl())) ? structure : context.fetchResource(StructureDefinition.class, url, structure);
      if (sd == null) {
        throw new Error("Unknown Type in content reference '"+path+"'");        
      }
      boolean found = false;
      for (ElementDefinition d : sd.getSnapshot().getElement()) {
        if (d.hasId() && d.getId().equals(path)) {
          found = true;
          ed = d;
        }
      }
      if (!found)
        throw new Error("Unable to resolve "+definition.getContentReference()+" at "+definition.getPath()+" on "+sd.getUrl());
    }
    if (ed.getType().size() == 0)
			return null;
    else if (ed.getType().size() > 1) {
      String t = ed.getType().get(0).getCode();
			boolean all = true;
      for (TypeRefComponent tr : ed.getType()) {
				if (!t.equals(tr.getCode()))
					all = false;
			}
			if (all)
				return t;
      String tail = ed.getPath().substring(ed.getPath().lastIndexOf(".")+1);
      if (tail.endsWith("[x]") && elementName != null && elementName.startsWith(tail.substring(0, tail.length()-3))) {
				String name = elementName.substring(tail.length()-3);
        return isPrimitive(lowFirst(name)) ? lowFirst(name) : name;        
			} else {
	      if (ToolingExtensions.hasExtension(ed, "http://hl7.org/fhir/StructureDefinition/elementdefinition-defaulttype"))
	        return ToolingExtensions.readStringExtension(ed, "http://hl7.org/fhir/StructureDefinition/elementdefinition-defaulttype");
        throw new Error("logic error, gettype when types > 1, name mismatch for "+elementName+" on at "+ed.getPath());
			}
    } else if (ed.getType().get(0).getCode() == null) {
      if (Utilities.existsInList(ed.getId(), "Element.id", "Extension.url"))
        return "string";
      else
        return structure.getId();
		} else
      return ed.getType().get(0).getWorkingCode();
	}

  public boolean hasType(String elementName) {
    if (type != null) {
      return false; // ?
    } else if (definition.getType().size() == 0) {
      return false;
    } else if (isJsonPrimitiveChoice()) { 
      for (TypeRefComponent tr : definition.getType()) {
        if (elementName.equals(tr.getWorkingCode())) {
          return true;
        }
      }
      return false;
    } else if (definition.getType().size() > 1) {
      String t = definition.getType().get(0).getCode();
      boolean all = true;
      for (TypeRefComponent tr : definition.getType()) {
        if (!t.equals(tr.getCode()))
          all = false;
      }
      if (all)
        return true;
      String tail = definition.getPath().substring(definition.getPath().lastIndexOf(".")+1);
      if (tail.endsWith("[x]") && elementName.startsWith(tail.substring(0, tail.length()-3))) {
//        String name = elementName.substring(tail.length()-3);
        return true;        
      } else
        return false;
    } else
      return true;
  }

	public StructureDefinition getStructure() {
		return structure;
	}

	/**
	 * Is the given name a primitive
	 * 
	 * @param E.g. "Observation.status"
	 */
	public boolean isPrimitiveName(String name) {
	  String code = getType(name);
      return isPrimitive(code);
	}

	/**
	 * Is the given type a primitive
	 * 
	 * @param E.g. "integer"
	 */
	public boolean isPrimitive(String code) {
	  return context.isPrimitiveType(code);
	}

	public boolean isPrimitive() {
	  return isPrimitive(getType());
	}
	private String lowFirst(String t) {
		return t.substring(0, 1).toLowerCase()+t.substring(1);
	}

	public boolean isResource() {
	  if (type != null) {
	    String tc = type.getCode();
      return (("Resource".equals(tc) || "DomainResource".equals(tc)) ||  Utilities.existsInList(tc, context.getResourceNames()));
	  } else if (definition.getType().size() > 0) {
      String tc = definition.getType().get(0).getCode();
      return definition.getType().size() == 1 && (("Resource".equals(tc) || "DomainResource".equals(tc)) ||  Utilities.existsInList(tc, context.getResourceNames()));
    }
	  else {
	    return !definition.getPath().contains(".") && (structure.getKind() == StructureDefinitionKind.RESOURCE);
	  }
	}

  public boolean isList() {
    return !"1".equals(definition.getMax());
  }

  public boolean isBaseList() {
    return !"1".equals(definition.getBase().getMax());
  }

  public String getScopedPropertyName() {
    return definition.getBase().getPath();
  }

  private boolean isElementWithOnlyExtension(final ElementDefinition ed, final List<ElementDefinition> children) {
    boolean result = false;
    if (!ed.getType().isEmpty()) {
      result = true;
      for (final ElementDefinition ele : children) {
        if (!ele.getPath().contains("extension")) {
          result = false;
          break;
        }
      }
    }
    return result;
  }
  
	public boolean IsLogicalAndHasPrimitiveValue(String name) {
//		if (canBePrimitive!= null)
//			return canBePrimitive;
		
  	if (structure.getKind() != StructureDefinitionKind.LOGICAL)
  		return false;
  	if (!hasType(name))
  		return false;
  	StructureDefinition sd = context.fetchResource(StructureDefinition.class, structure.getUrl().substring(0, structure.getUrl().lastIndexOf("/")+1)+getType(name));
  	if (sd == null)
  	  sd = context.fetchResource(StructureDefinition.class, ProfileUtilities.sdNs(getType(name), null));
    if (sd != null && sd.getKind() == StructureDefinitionKind.PRIMITIVETYPE)
      return true;
  	if (sd == null || sd.getKind() != StructureDefinitionKind.LOGICAL)
  		return false;
  	for (ElementDefinition ed : sd.getSnapshot().getElement()) {
  		if (ed.getPath().equals(sd.getId()+".value") && ed.getType().size() == 1 && isPrimitive(ed.getType().get(0).getCode())) {
  			return true;
  		}
  	}
  	return false;
	}

  public boolean isChoice() {
    if (type != null) {
      return true;
    }
    if (definition.getType().size() <= 1)
      return false;
    String tn = definition.getType().get(0).getCode();
    for (int i = 1; i < definition.getType().size(); i++) 
      if (!definition.getType().get(i).getCode().equals(tn))
        return true;
    return false;
  }


  public List<Property> getChildProperties(String elementName, String statedType) throws FHIRException {
    String cacheKey = structure.getVUrl()+"#"+definition.getPath()+":"+elementName+"/"+statedType;
    List<Property> cached = profileUtilities.getCachedPropertyList().get(cacheKey);
    if (cached != null) {
      return cached;
    }
    ElementDefinition ed = definition;
    StructureDefinition sd = structure;
    SourcedChildDefinitions children = profileUtilities.getChildMap(sd, ed);
    String url = null;
    if (children.getList().isEmpty() || isElementWithOnlyExtension(ed, children.getList())) {
      // ok, find the right definitions
      String t = null;
      if (ed.getType().size() == 1)
        t = ed.getType().get(0).getWorkingCode();
      else if (ed.getType().size() == 0)
        throw new Error("types == 0, and no children found on "+getDefinition().getPath());
      else {
        t = ed.getType().get(0).getWorkingCode();
        boolean all = true;
        for (TypeRefComponent tr : ed.getType()) {
          if (!tr.getWorkingCode().equals(t)) {
            all = false;
            break;
          }
        }
        if (!all) {
          // ok, it's polymorphic
          if (ed.hasRepresentation(PropertyRepresentation.TYPEATTR)) {
            t = statedType;
            if (t == null && ToolingExtensions.hasExtension(ed, "http://hl7.org/fhir/StructureDefinition/elementdefinition-defaulttype"))
              t = ToolingExtensions.readStringExtension(ed, "http://hl7.org/fhir/StructureDefinition/elementdefinition-defaulttype");
            boolean ok = false;
            for (TypeRefComponent tr : ed.getType()) { 
              if (tr.getWorkingCode().equals(t)) 
                ok = true;
              if (Utilities.isAbsoluteUrl(tr.getWorkingCode())) {
                StructureDefinition sdt = context.fetchResource(StructureDefinition.class, tr.getWorkingCode());
                if (sdt != null && sdt.getTypeTail().equals(t)) {
                  url = tr.getWorkingCode();
                  ok = true;
                }
              }
              if (ok)
                break;
            }
             if (!ok)
               throw new DefinitionException("Type '"+t+"' is not an acceptable type for '"+elementName+"' on property "+definition.getPath());
            
          } else {
            t = elementName.substring(tail(ed.getPath()).length() - 3);
            if (isPrimitive(lowFirst(t)))
              t = lowFirst(t);
          }
        }
      }
      if (!"xhtml".equals(t)) {
        for (TypeRefComponent aType: ed.getType()) {
          if (aType.getWorkingCode().equals(t)) {
            if (aType.hasProfile()) {
              assert aType.getProfile().size() == 1; 
              url = aType.getProfile().get(0).getValue();
            } else {
              url = ProfileUtilities.sdNs(t, null);
            }
            break;
          }
        }
        if (url==null)
          throw new FHIRException("Unable to find type " + t + " for element " + elementName + " with path " + ed.getPath());
        sd = context.fetchResource(StructureDefinition.class, url);        
        if (sd == null)
          throw new DefinitionException("Unable to find type '"+t+"' for name '"+elementName+"' on property "+definition.getPath());
        children = profileUtilities.getChildMap(sd, sd.getSnapshot().getElement().get(0));
      }
    }
    List<Property> properties = new ArrayList<Property>();
    for (ElementDefinition child : children.getList()) {
      properties.add(new Property(context, child, sd, this.profileUtilities));
    }
    profileUtilities.getCachedPropertyList().put(cacheKey, properties);
    return properties;
  }

  protected List<Property> getChildProperties(TypeDetails type) throws DefinitionException {
    ElementDefinition ed = definition;
    StructureDefinition sd = structure;
    SourcedChildDefinitions children = profileUtilities.getChildMap(sd, ed);
    if (children.getList().isEmpty()) {
      // ok, find the right definitions
      String t = null;
      if (ed.getType().size() == 1)
        t = ed.getType().get(0).getCode();
      else if (ed.getType().size() == 0)
        throw new Error("types == 0, and no children found");
      else {
        t = ed.getType().get(0).getCode();
        boolean all = true;
        for (TypeRefComponent tr : ed.getType()) {
          if (!tr.getCode().equals(t)) {
            all = false;
            break;
          }
        }
        if (!all) {
          // ok, it's polymorphic
          t = type.getType();
        }
      }
      if (!"xhtml".equals(t)) {
        sd = context.fetchResource(StructureDefinition.class, t);
        if (sd == null)
          throw new DefinitionException("Unable to find class '"+t+"' for name '"+ed.getPath()+"' on property "+definition.getPath());
        children = profileUtilities.getChildMap(sd, sd.getSnapshot().getElement().get(0));
      }
    }
    List<Property> properties = new ArrayList<Property>();
    for (ElementDefinition child : children.getList()) {
      properties.add(new Property(context, child, sd, this.profileUtilities));
    }
    return properties;
  }

  private String tail(String path) {
    return path.contains(".") ? path.substring(path.lastIndexOf(".")+1) : path;
  }

  public Property getChild(String elementName, String childName) throws FHIRException {
    List<Property> children = getChildProperties(elementName, null);
    for (Property p : children) {
      if (p.getName().equals(childName)) {
        return p;
      }
    }
    return null;
  }

  public Property getChild(String name, TypeDetails type) throws DefinitionException {
    List<Property> children = getChildProperties(type);
    for (Property p : children) {
      if (p.getName().equals(name) || p.getName().equals(name+"[x]")) {
        return p;
      }
    }
    return null;
  }

  public Property getChild(String name) throws FHIRException {
    List<Property> children = getChildProperties(name, null);
    for (Property p : children) {
      if (p.getName().equals(name)) {
        return p;
      }
    }
    return null;
  }

  public Property getChildSimpleName(String elementName, String name) throws FHIRException {
    List<Property> children = getChildProperties(elementName, null);
    for (Property p : children) {
      if (p.getName().equals(name) || p.getName().equals(name+"[x]")) {
        return p;
      }
    }
    return null;
  }

  public IWorkerContext getContext() {
    return context;
  }

  @Override
  public String toString() {
    return definition.getPath();
  }


  public boolean isJsonKeyArray() {
    return definition.hasExtension(ToolingExtensions.EXT_JSON_PROP_KEY);
  }


  public String getJsonKeyProperty() {
    return ToolingExtensions.readStringExtension(definition, ToolingExtensions.EXT_JSON_PROP_KEY);
  }


  public boolean hasTypeSpecifier() {
    return definition.hasExtension(ToolingExtensions.EXT_TYPE_SPEC);
  }


  public List<StringPair> getTypeSpecifiers() {
    List<StringPair> res = new ArrayList<>();
    for (Extension e : definition.getExtensionsByUrl(ToolingExtensions.EXT_TYPE_SPEC)) {
      res.add(new StringPair(ToolingExtensions.readStringExtension(e,  "condition"), ToolingExtensions.readStringExtension(e,  "type")));
    }
    return res;
  }


  public Property cloneToType(StructureDefinition sd) {
    Property res = new Property(context, definition.copy(), sd);
    res.definition.getType().clear();
    res.definition.getType().add(new TypeRefComponent(sd.getUrl()));
    return res;
  }


  public boolean hasImpliedPrefix() {
    return definition.hasExtension(ToolingExtensions.EXT_IMPLIED_PREFIX);
  }


  public String getImpliedPrefix() {
    return ToolingExtensions.readStringExtension(definition, ToolingExtensions.EXT_IMPLIED_PREFIX);
  }


  public boolean isNullable() {    
    return ToolingExtensions.readBoolExtension(definition, ToolingExtensions.EXT_JSON_NULLABLE);
  }


  public String summary() {
    return structure.getUrl()+"#"+definition.getId();
  }


  public boolean canBeEmpty() {
    if (definition.hasExtension(ToolingExtensions.EXT_JSON_EMPTY)) {
      return !"absent".equals(ToolingExtensions.readStringExtension(definition, ToolingExtensions.EXT_JSON_EMPTY));
    } else {
      return false;
    }
  }


  public boolean isLogical() {
    return structure.getKind() == StructureDefinitionKind.LOGICAL;
  }


  public ProfileUtilities getUtils() {
    return profileUtilities;
  }

  public boolean isJsonPrimitiveChoice() {
    return ToolingExtensions.readBoolExtension(definition, ToolingExtensions.EXT_JSON_PRIMITIVE_CHOICE);
  }

  public Object typeSummary() {
    CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder(" | ");
    for (TypeRefComponent t : definition.getType()) {
      b.append(t.getCode());
    }
    return b.toString();
  }


  public boolean hasJsonName() {
    return definition.hasExtension(ToolingExtensions.EXT_JSON_NAME);
  }


  public boolean isTranslatable() {
    boolean ok = ToolingExtensions.readBoolExtension(definition, ToolingExtensions.EXT_TRANSLATABLE);
    if (!ok && !Utilities.existsInList(definition.getBase().getPath(), "Reference.reference", "Coding.version", "Identifier.value", "SampledData.offsets", "SampledData.data", "ContactPoint.value")) {
      String t = getType();
      ok = Utilities.existsInList(t, "string", "markdown");
    }
    return ok;
  }

  
}