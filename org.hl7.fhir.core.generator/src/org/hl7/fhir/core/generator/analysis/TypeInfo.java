package org.hl7.fhir.core.generator.analysis;

import java.util.List;

import org.hl7.fhir.r5.model.ElementDefinition;

public class TypeInfo {

  private ElementDefinition defn;
  private String name;
  private List<ElementDefinition> children;
  private List<ElementDefinition> inheritedChildren;
  private String ancestorName;
  
  public ElementDefinition getDefn() {
    return defn;
  }
  public void setDefn(ElementDefinition defn) {
    this.defn = defn;
    defn.setUserData("java.type.info", this);
  }
  
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public List<ElementDefinition> getChildren() {
    return children;
  }
  public void setChildren(List<ElementDefinition> children) {
    this.children = children;
  }
  public List<ElementDefinition> getInheritedChildren() {
    return inheritedChildren;
  }
  public void setInheritedChildren(List<ElementDefinition> inheritedChildren) {
    this.inheritedChildren = inheritedChildren;
  }
  public String getAncestorName() {
    return ancestorName;
  }
  public void setAncestorName(String ancestorName) {
    this.ancestorName = ancestorName;
  }
  
}