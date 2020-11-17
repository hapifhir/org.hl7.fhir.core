package org.hl7.fhir.r5.test;

import static org.junit.jupiter.api.Assertions.*;

import org.hl7.fhir.r5.model.CapabilityStatement;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.model.CompartmentDefinition;
import org.hl7.fhir.r5.model.ConceptMap;
import org.hl7.fhir.r5.model.ExampleScenario;
import org.hl7.fhir.r5.model.GraphDefinition;
import org.hl7.fhir.r5.model.ImplementationGuide;
import org.hl7.fhir.r5.model.MessageDefinition;
import org.hl7.fhir.r5.model.NamingSystem;
import org.hl7.fhir.r5.model.OperationDefinition;
import org.hl7.fhir.r5.model.SearchParameter;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.StructureMap;
import org.hl7.fhir.r5.model.TerminologyCapabilities;
import org.hl7.fhir.r5.model.ValueSet;
import org.junit.jupiter.api.Test;

class ResourceTests {

  @Test
  void testSupportsCopyright() {
    assertTrue(new CodeSystem().supportsCopyright());
    assertTrue(new ValueSet().supportsCopyright());
    assertTrue(new ConceptMap().supportsCopyright());
    assertTrue(new TerminologyCapabilities().supportsCopyright()); 
    assertTrue(new CapabilityStatement().supportsCopyright()); 
    assertTrue(new StructureDefinition().supportsCopyright()); 
    assertTrue(new ImplementationGuide().supportsCopyright()); 
    assertTrue(new MessageDefinition().supportsCopyright()); 
    assertTrue(new StructureMap().supportsCopyright()); 
    assertTrue(new ExampleScenario().supportsCopyright()); 
    assertFalse(new SearchParameter().supportsCopyright());
    assertFalse(new NamingSystem().supportsCopyright()); 
    assertFalse(new OperationDefinition().supportsCopyright()); 
    assertFalse(new CompartmentDefinition().supportsCopyright()); 
    assertFalse(new GraphDefinition().supportsCopyright()); 
  }

}
