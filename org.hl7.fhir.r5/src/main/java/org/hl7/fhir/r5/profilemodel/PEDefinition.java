package org.hl7.fhir.r5.profilemodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.NotImplementedException;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.ValueSet;

public abstract class PEDefinition {

  protected PEBuilder builder;
  protected String name;
  protected StructureDefinition baseStructure;
  protected ElementDefinition baseDefinition;
  protected StructureDefinition profileStructure;
  protected ElementDefinition profiledDefinition;
  protected List<PEType> types;
  protected Map<String, List<PEDefinition>> children = new HashMap<>();
  private boolean recursing;
  
  /**
   * Don't create one of these directly - always use the public methods on ProfiledElementBuilder
   *  
   * @param builder
   * @param baseElement
   * @param profiledElement
   * @param data
   */
  protected PEDefinition(PEBuilder builder, String name, ElementDefinition baseDefinition,
      ElementDefinition profiledDefinition, Base data) {
    super();
    this.builder = builder;
    this.name = name;
    this.baseDefinition = baseDefinition;
    this.profiledDefinition = profiledDefinition;
//    this.data = data;
  }

  protected PEDefinition(PEBuilder builder, String name, StructureDefinition base, ElementDefinition baseDefinition, 
      StructureDefinition profile, ElementDefinition profiledDefinition) {
    this.builder = builder;
    this.name = name;
    this.baseStructure = base;
    this.baseDefinition = baseDefinition;
    this.profileStructure = profile;
    this.profiledDefinition = profiledDefinition;
  }


  /** 
   * @return The name of the element or slice in the profile (always unique amongst children)
   */
  public String name() {
    return name;
  }

  /**
   * @return The name of the element in the resource (may be different to the slice name)
   */
  public String schemaName() {
    return baseDefinition.getName();
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
    return profiledDefinition.getMin();
  }
  
  /**
   * @return the maximum number of repeats allowed
   */
  public int max() {
    return "*".equals(profiledDefinition.getMax()) ? Integer.MAX_VALUE : Integer.parseInt(profiledDefinition.getMax());
  }
  
  /**
   * @return the definition of the element in the profile (fully populated)
   * 
   * Note that the profile definition might be the same as a base definition, when the tree runs off the end of what's profiled
   */
  public ElementDefinition definition() {
    return profiledDefinition;
  }
  
  /**
   * @return the definition of the element in the base specification
   * 
   * Note that the profile definition might be the same as a base definition, when the tree runs off the end of what's profiled
   */
  public ElementDefinition baseDefinition() {
    return baseDefinition;
  }
  
  /**
   * @return the short documentation of the definition (shown in the profile table view)
   */
  public String shortDocumentation() {
    return profiledDefinition.getShort();
  }
  
  /**
   * @return the full definition of the element (markdown syntax)
   */
  public String documentation() {
    return profiledDefinition.getDefinition();
  }
  
//  /**
//   * @return if the profiled definition has a value set 
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
    if (children.containsKey(typeUrl)) {
      return children.get(typeUrl);      
    } 
    List<PEDefinition> res = new ArrayList<>();
    makeChildren(typeUrl, res);
    children.put(typeUrl, res);
    return res;
  }
  
  protected abstract void makeChildren(String typeUrl, List<PEDefinition> children);

  @Override
  public String toString() {
    return name+"("+schemaName()+"):"+types().toString()+" ["+min()+":"+(max() == Integer.MAX_VALUE ? "*" : max() )+"] \""+shortDocumentation()+"\"";
  }

  public boolean isRecursing() {
    return recursing;
  }

  public void setRecursing(boolean recursing) {
    this.recursing = recursing;
  }
  
}


