package org.hl7.fhir.core.generator.analysis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hl7.fhir.core.generator.engine.Definitions;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.SearchParameter;
import org.hl7.fhir.r5.model.StructureDefinition;

public class Analysis {

  // background
  private Definitions definitions;
  private StructureDefinition structure;
  private String className;
  
  private StructureDefinition ancestor;
  private boolean isAbstract;
  private boolean isInterface;
  
  private List<TypeInfo> typeList = new ArrayList<>();
  private TypeInfo rootType;
  private Map<String, TypeInfo> types = new HashMap<>();
  private Map<String, EnumInfo> enums =  new HashMap<>();
  private List<SearchParameter> searchParams = new ArrayList<>();
  
//  private Map<ElementDefinition, String> typeNames = new HashMap<ElementDefinition, String>();
//  private List<String> typeNameStrings = new ArrayList<String>();
//  private List<ElementDefinition> enums = new ArrayList<ElementDefinition>();
//  private List<String> enumNames = new ArrayList<String>();
//  private List<ElementDefinition> strucs  = new ArrayList<ElementDefinition>();
//  private String classname;

  
  public Analysis(Definitions definitions, StructureDefinition sd) {
    this.definitions = definitions;
    this.structure = sd;
  }

  public Definitions getDefinitions() {
    return definitions;
  }

  public StructureDefinition getStructure() {
    return structure;
  }

  public StructureDefinition getAncestor() {
    return ancestor;
  }

  public void setAncestor(StructureDefinition ancestor) {
    this.ancestor = ancestor;
  }

  public Map<String, TypeInfo> getTypes() {
    return types;
  }


  public Map<String, EnumInfo> getEnums() {
    return enums;
  }

  public boolean isAbstract() {
    return isAbstract;
  }

  public void setAbstract(boolean isAbstract) {
    this.isAbstract = isAbstract;
  }

  public boolean isInterface() {
    return isInterface;
  }

  public void setInterface(boolean isInterface) {
    this.isInterface = isInterface;
  }

  public List<SearchParameter> getSearchParams() {
    return searchParams;
  }

  public void setSearchParams(List<SearchParameter> searchParams) {
    this.searchParams = searchParams;
  }

  public String getClassName() {
    return className;
  }

  public void setClassName(String name) {
    this.className = name;
  }

  public String getName() {
    return structure.getName();
  }

  public List<TypeInfo> getTypeList() {
    return typeList;
  }

  public TypeInfo getRootType() {
    return rootType;
  }

  public void setRootType(TypeInfo rootType) {
    this.rootType = rootType;
  }

  
}