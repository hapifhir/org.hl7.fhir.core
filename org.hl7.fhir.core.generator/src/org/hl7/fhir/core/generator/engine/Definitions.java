package org.hl7.fhir.core.generator.engine;

import org.hl7.fhir.r5.context.CanonicalResourceManager;
import org.hl7.fhir.r5.model.CapabilityStatement;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.CodeSystem.ConceptDefinitionComponent;
import org.hl7.fhir.r5.model.CompartmentDefinition;
import org.hl7.fhir.r5.model.ConceptMap;
import org.hl7.fhir.r5.model.OperationDefinition;
import org.hl7.fhir.r5.model.SearchParameter;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind;
import org.hl7.fhir.r5.model.StructureDefinition.TypeDerivationRule;
import org.hl7.fhir.r5.model.ValueSet;

public class Definitions {

  private CanonicalResourceManager<CodeSystem> codeSystems = new CanonicalResourceManager<>(true);
  private CanonicalResourceManager<ValueSet> valuesets = new CanonicalResourceManager<>(true);
  private CanonicalResourceManager<ConceptMap> conceptMaps = new CanonicalResourceManager<>(true);
  
  private CanonicalResourceManager<CapabilityStatement> statements = new CanonicalResourceManager<>(true);
  private CanonicalResourceManager<StructureDefinition> structures = new CanonicalResourceManager<>(true);
  private CanonicalResourceManager<OperationDefinition> operations = new CanonicalResourceManager<>(true);
  private CanonicalResourceManager<SearchParameter> searchParams = new CanonicalResourceManager<>(true);
  private CanonicalResourceManager<CompartmentDefinition> compartments = new CanonicalResourceManager<>(true);
  
  
  public CanonicalResourceManager<CodeSystem> getCodeSystems() {
    return codeSystems;
  }
  public CanonicalResourceManager<ValueSet> getValuesets() {
    return valuesets;
  }
  public CanonicalResourceManager<ConceptMap> getConceptMaps() {
    return conceptMaps;
  }
  public CanonicalResourceManager<CapabilityStatement> getStatements() {
    return statements;
  }
  public CanonicalResourceManager<StructureDefinition> getStructures() {
    return structures;
  }
  public CanonicalResourceManager<OperationDefinition> getOperations() {
    return operations;
  }
  public CanonicalResourceManager<SearchParameter> getSearchParams() {
    return searchParams;
  }
  public CanonicalResourceManager<CompartmentDefinition> getCompartments() {
    return compartments;
  }
  
  public String getCodeDefinition(String system, String code) {
    CodeSystem cs = codeSystems.get(system);
    if (cs == null) {
      return null;
    } else {
      ConceptDefinitionComponent cc = cs.getDefinitionByCode(code);
      return cc == null ? null : cc.getDefinition();
    }
  }
  
  public boolean hasPrimitiveType(String tn) {
    StructureDefinition sd = structures.get("http://hl7.org/fhir/StructureDefinition/"+tn);
    return sd != null && sd.getKind() == StructureDefinitionKind.PRIMITIVETYPE && sd.getDerivation() == TypeDerivationRule.SPECIALIZATION;
  }
  
  public boolean hasResource(String tn) {
    StructureDefinition sd = structures.get("http://hl7.org/fhir/StructureDefinition/"+tn);
    return sd != null && sd.getKind() == StructureDefinitionKind.RESOURCE && sd.getDerivation() == TypeDerivationRule.SPECIALIZATION;

  }
  public StructureDefinition getType(String tn) {
    StructureDefinition sd = structures.get("http://hl7.org/fhir/StructureDefinition/"+tn);
    return sd;
  }
 
  
}