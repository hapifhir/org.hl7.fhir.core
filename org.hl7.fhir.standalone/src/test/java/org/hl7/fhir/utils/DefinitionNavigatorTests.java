package org.hl7.fhir.utils;

import org.hl7.fhir.services.utilities.DefinitionNavigator;
import org.hl7.fhir.standalone.context.SimpleWorkerContext;
import org.hl7.fhir.model.core.StructureDefinition;
import org.hl7.fhir.standalone.testing.TestingUtilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DefinitionNavigatorTests {

  @Test
  @DisplayName("Test ContentReference")
  void getCurrent() {

    SimpleWorkerContext ctxt = TestingUtilities.getWorkerContext("4.0");
    StructureDefinition sd = ctxt.fetchResource(StructureDefinition.class, "http://hl7.org/fhir/StructureDefinition/PlanDefinition");
    DefinitionNavigator dn = new DefinitionNavigator(ctxt, sd, false, true);
    Assertions.assertNotNull(dn);
    DefinitionNavigator dn1 = dn.childByName("action");
    Assertions.assertNotNull(dn1);
    dn1 = dn1.childByName("input");
    Assertions.assertNotNull(dn1);

    dn1 = dn.childByName("action");
    Assertions.assertNotNull(dn1);
    dn1 = dn1.childByName("action");
    Assertions.assertNotNull(dn1);
    dn1 = dn1.childByName("input");
    Assertions.assertNotNull(dn1);
  }
}
