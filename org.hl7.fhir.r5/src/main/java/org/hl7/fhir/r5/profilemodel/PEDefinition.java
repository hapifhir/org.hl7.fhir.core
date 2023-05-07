package org.hl7.fhir.r5.profilemodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.xmlbeans.impl.xb.xsdschema.All;
import org.hl7.fhir.exceptions.DefinitionException;
import org.hl7.fhir.r5.context.ContextUtilities;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.ElementDefinition.TypeRefComponent;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.profilemodel.PEDefinition.PEDefinitionElementMode;
import org.hl7.fhir.utilities.Utilities;

public abstract class PEDefinition {

  public enum PEDefinitionElementMode {
    Resource, Element, DataType, Extension
  }

  protected PEBuilder builder;
  protected String name;
  protected String path;
  protected StructureDefinition profile;
  protected ElementDefinition definition;
  protected List<PEType> types;
  protected Map<String, List<PEDefinition>> children = new HashMap<>();
  private boolean recursing;
  private boolean mustHaveValue;
  private boolean inFixedValue;
  
//  /**
//   * Don't create one of these directly - always use the public methods on ProfiledElementBuilder
//   *  
//   * @param builder
//   * @param baseElement
//   * @param profiledElement
//   * @param data
//   */
//  protected PEDefinition(PEBuilder builder, String name, 
//      ElementDefinition definition, Base data) {
//    super();
//    this.builder = builder;
//    this.name = name;
//    this.definition = definition;
////    this.data = data;
//  }

  protected PEDefinition(PEBuilder builder, String name, StructureDefinition profile, ElementDefinition definition, String ppath) {
    this.builder = builder;
    this.name = name;
    this.profile = profile;
    this.definition = definition;
    this.path = path == null ? name : ppath+"."+name;
  }


  /** 
   * @return The name of the element or slice in the profile (always unique amongst children)
   */
  public String name() {
    return name;
  }

  /** 
   * @return The path of the element or slice in the profile (name.name.name...)
   */
  public String path() {
    return path;
  }

  /**
   * @return The name of the element in the resource (may be different to the slice name)
   */
  public String schemaName() {
    return definition.getName();
  }
  
  /**
   * @return a list of types. There is usually at least one type; it might be Element, Type, BackboneElement or BackboneType
   * 
   * The following elements don't have types (true primitives): Element.id. Extension.url, PrimitiveType.value
   */
  public List<PEType> types() {
    if (types == null) {
      List<PEType> ltypes = new ArrayList<>();
      listTypes(ltypes);
      types = ltypes;
    }
    return types;
  }
  
  protected abstract void listTypes(List<PEType> types);
  
  /**
   * @return The minimum number of repeats allowed
   */
  public int min() {
    return mustHaveValue ? 1 : definition.getMin();
  }
  
  /**
   * @return the maximum number of repeats allowed
   */
  public int max() {
    return definition.getMax() == null || "*".equals(definition.getMax()) ? Integer.MAX_VALUE : Integer.parseInt(definition.getMax());
  }
  
  /**
   * @return the definition of the element in the profile (fully populated)
   * 
   * Note that the profile definition might be the same as a base definition, when the tree runs off the end of what's profiled
   */
  public ElementDefinition definition() {
    return definition;
  }
  
  /**
   * @return the definition of the element in the base specification
   * 
   * Note that the profile definition might be the same as a base definition, when the tree runs off the end of what's profiled
   */
  public ElementDefinition baseDefinition() {
    String type = definition.getBase().getPath();
    if (type.contains(".")) {
      type= type.substring(0, type.indexOf("."));
    }
    StructureDefinition sd = builder.getContext().fetchTypeDefinition(type);
    return sd.getSnapshot().getElementByPath(definition.getBase().getPath(), true);
  }
  
  /**
   * @return the short documentation of the definition (shown in the profile table view)
   */
  public String shortDocumentation() {
    return definition.getShort();
  }
  
  /**
   * @return the full definition of the element (markdown syntax)
   */
  public String documentation() {
    return definition.getDefinition();
  }
  
//  /**
//   * @return if the profiled definition has a value set, get the expansion 
//   */
//  public ValueSet expansion() {
//    throw new NotImplementedException("Not done yet");
//  }
//  
  /**
   * @param typeUrl - the url of one of the types listed in types()
   * @return - the list of children for the nominated type
   * 
   * Warning: profiles and resources can be recursive; you can't iterate this tree until you get 
   * to the leaves because you will never get to a child that doesn't have children (extensions have extensions etc)
   * 
   */
  public List<PEDefinition> children(String typeUrl) {
    return children(typeUrl, false);
  }
  
  public List<PEDefinition> children(String typeUrl, boolean allFixed) {
    if (children.containsKey(typeUrl+"$"+allFixed)) {
      return children.get(typeUrl+"$"+allFixed);      
    } 
    List<PEDefinition> res = new ArrayList<>();
    makeChildren(typeUrl, res, allFixed);
    children.put(typeUrl+"$"+allFixed, res);
    return res;    
  }
  
  public List<PEDefinition> children() {
    if (types().size() == 1) {
      return children(types.get(0).getUrl(), false);
    } else {
      throw new DefinitionException("Attempt to get children for an element that doesn't have a single type (types = "+types()+")");
    }
  }
  
  public List<PEDefinition> children(boolean allFixed) {
    if (types().size() == 1) {
      return children(types.get(0).getUrl(), allFixed);
    } else {
      throw new DefinitionException("Attempt to get children for an element that doesn't have a single type (types = "+types()+")");
    }
  }
  
  /**
   * @return True if the element has a fixed value. This will always be false if fixedProps = false when the builder is created
   */
  public boolean fixedValue() {
    return definition.hasFixed() || definition.hasPattern();
  }
  
  protected abstract void makeChildren(String typeUrl, List<PEDefinition> children, boolean allFixed);

  @Override
  public String toString() {
    return name+"("+schemaName()+"):"+types().toString()+" ["+min()+":"+(max() == Integer.MAX_VALUE ? "*" : max() )+"] \""+shortDocumentation()+"\"";
  }

  /**
   * @return true if the builder observes that this element is recursing (extensions have extensions)
   * 
   * Note that this is unreliable and may be withdrawn if it can't be fixed
   */
  public boolean isRecursing() {
    return recursing;
  }

  protected void setRecursing(boolean recursing) {
    this.recursing = recursing;
  }
  
  protected boolean isMustHaveValue() {
    return mustHaveValue;
  }

  protected void setMustHaveValue(boolean mustHaveValue) {
    this.mustHaveValue = mustHaveValue;
  }

  /**
   * @return true if this property is inside an element that has an assigned fixed value
   */
  public boolean isInFixedValue() {
    return inFixedValue;
  }


  protected void setInFixedValue(boolean inFixedValue) {
    this.inFixedValue = inFixedValue;
  }


  /** 
   * This is public to support unit testing - there's no reason to use it otherwise
   * 
   * @return used in the instance processor to differentiate slices
   */
  public abstract String fhirpath();


  public boolean isList() {
    return "*".equals(definition.getBase().getMax());
  }


  public boolean repeats() {
    return max() > 1;
  }
  
  public PEDefinitionElementMode mode() {
    if (builder.isResource(definition.getBase().getPath())) {
      return PEDefinitionElementMode.Resource;
    }
    for (TypeRefComponent tr : definition.getType()) {
      if ("Extension".equals(tr.getWorkingCode())) {
        return PEDefinitionElementMode.Extension;
      }
      if (!Utilities.existsInList(tr.getWorkingCode(), "Element", "BackboneElement")) {
        return PEDefinitionElementMode.DataType;
      }
    }
    return PEDefinitionElementMode.Element;
  }

  /**
   * @return true if this element is profiled one way or another
   */
  public boolean isProfiled() {
    return !profile.getUrl().startsWith("http://hl7.org/fhir/StructureDefinition");
  }

}


