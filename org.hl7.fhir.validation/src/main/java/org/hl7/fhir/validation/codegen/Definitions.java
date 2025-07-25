package org.hl7.fhir.validation.codegen;

import org.hl7.fhir.r5.context.CanonicalResourceManager;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.extensions.ExtensionDefinitions;
import org.hl7.fhir.r5.extensions.ExtensionUtilities;
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
import org.hl7.fhir.utilities.Utilities;

public class Definitions {

  private IWorkerContext context;
  
  public Definitions(IWorkerContext context) {
    super();
    this.context = context;
  }
  
  private CanonicalResourceManager<CodeSystem> codeSystems = new CanonicalResourceManager<>(true, false);
  private CanonicalResourceManager<ValueSet> valuesets = new CanonicalResourceManager<>(true, false);
  private CanonicalResourceManager<ConceptMap> conceptMaps = new CanonicalResourceManager<>(true, false);
  
  private CanonicalResourceManager<CapabilityStatement> statements = new CanonicalResourceManager<>(true, false);
  private CanonicalResourceManager<StructureDefinition> structures = new CanonicalResourceManager<>(true, false);
  private CanonicalResourceManager<OperationDefinition> operations = new CanonicalResourceManager<>(true, false);
  private CanonicalResourceManager<SearchParameter> searchParams = new CanonicalResourceManager<>(true, false);
  private CanonicalResourceManager<CompartmentDefinition> compartments = new CanonicalResourceManager<>(true, false);
  
  
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
    if (sd == null) {
      sd = context.fetchTypeDefinition(tn);
    }
    return sd != null && sd.getKind() == StructureDefinitionKind.PRIMITIVETYPE && sd.getDerivation() == TypeDerivationRule.SPECIALIZATION;
  }
  
  public boolean hasResource(String tn) {
    StructureDefinition sd = structures.get("http://hl7.org/fhir/StructureDefinition/"+tn);
    return sd != null && sd.getKind() == StructureDefinitionKind.RESOURCE && sd.getDerivation() == TypeDerivationRule.SPECIALIZATION;

  }
  public StructureDefinition getType(String tn) {
    StructureDefinition sd = structures.get("http://hl7.org/fhir/StructureDefinition/"+tn);
    if (sd == null) {
      sd = structures.get(tn); 
    }
    if (sd == null) {
      sd = context.fetchTypeDefinition(tn); 
    }
    return sd;
  }
  public void fix() {
//    StructureDefinition aa = structures.get("http://hl7.org/fhir/StructureDefinition/ArtifactAssessment");
//    if (aa != null) {
//      for (ElementDefinition ed : aa.getSnapshot().getElement()) {
//        fixAATypes(ed);
//      }
//      for (ElementDefinition ed : aa.getDifferential().getElement()) {
//        fixAATypes(ed);
//      }
//    }
    for (StructureDefinition sd : structures.getList()) {
      if (sd.hasExtension(ExtensionDefinitions.EXT_RESOURCE_IMPLEMENTS) &&
          !Utilities.existsInList(sd.getType(), "MedicationKnowledge", "ObservationDefinition", "SpecimenDefinition")) {
        sd.setBaseDefinition(ExtensionUtilities.readStringExtension(sd, ExtensionDefinitions.EXT_RESOURCE_IMPLEMENTS));
      }
    }
  }
  public IWorkerContext getContext() {
    return context;
  }
  public boolean isPrimitive(String name) {
    StructureDefinition sd = getStructures().get(typeNs(name));
    if (sd == null) {
      sd = context.fetchTypeDefinition(name);
    }
    return sd != null && sd.getKind() == StructureDefinitionKind.PRIMITIVETYPE;
    
    // TODO Auto-generated method stub
    
  }

  private String typeNs(String name) {
    return "http://hl7.org/fhir/StructureDefinition/"+name;
  }
//  private void fixAATypes(ElementDefinition ed) {
//    if (ed.getPath().equals("ArtifactAssessment.approvalDate")) {
//      ed.getTypeFirstRep().setCode("date");
//    }
//    if (ed.getPath().equals("ArtifactAssessment.lastReviewDate")) {
//      ed.getTypeFirstRep().setCode("date");
//    }
//  }
 
 
  
}