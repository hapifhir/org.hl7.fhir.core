package org.hl7.fhir.r5.utils;

import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.ElementDefinition.DiscriminatorType;
import org.hl7.fhir.r5.model.ElementDefinition.SlicingRules;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
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
  @Test
  @DisplayName("Inherited differential slice uses snapshot slicing master")
  void inheritedDifferentialSliceUsesSnapshotSlicingMaster() {
    SimpleWorkerContext ctxt = TestingUtilities.getWorkerContext("4.0");
    StructureDefinition sd = new StructureDefinition();
    sd.setType("Observation");

    sd.getDifferential().getElement().add(new ElementDefinition("Observation"));
    sd.getDifferential().getElement().add(
        new ElementDefinition("Observation.category").setSliceName("us-core"));

    sd.getSnapshot().getElement().add(new ElementDefinition("Observation"));
    ElementDefinition master = new ElementDefinition("Observation.category");
    master.getSlicing()
        .setRules(SlicingRules.OPEN)
        .setOrdered(false)
        .addDiscriminator()
        .setType(DiscriminatorType.VALUE)
        .setPath("coding.system");
    sd.getSnapshot().getElement().add(master);
    sd.getSnapshot().getElement().add(
        new ElementDefinition("Observation.category").setSliceName("us-core"));

    DefinitionNavigator dn = new DefinitionNavigator(ctxt, sd, true, false);
    DefinitionNavigator category = dn.childByName("category");
    Assertions.assertNotNull(category);
    Assertions.assertEquals(1, category.slices().size());
    Assertions.assertEquals("us-core", category.slices().get(0).current().getSliceName());
  }

  @Test
  @DisplayName("ContentReference ignores slices of referenced element")
  void contentReferenceIgnoresSlicesOfReferencedElement() {
    SimpleWorkerContext ctxt = TestingUtilities.getWorkerContext("4.0");
    StructureDefinition sd = new StructureDefinition();
    sd.setType("Composition");

    sd.getSnapshot().getElement().add(new ElementDefinition("Composition"));
    ElementDefinition section = new ElementDefinition("Composition.section");
    section.getSlicing()
        .setRules(SlicingRules.OPEN)
        .setOrdered(false)
        .addDiscriminator()
        .setType(DiscriminatorType.VALUE)
        .setPath("code");
    sd.getSnapshot().getElement().add(section);
    sd.getSnapshot().getElement().add(new ElementDefinition("Composition.section.title"));
    sd.getSnapshot().getElement().add(
        new ElementDefinition("Composition.section.section")
            .setContentReference("#Composition.section"));
    sd.getSnapshot().getElement().add(
        new ElementDefinition("Composition.section").setSliceName("sectionProblems"));

    DefinitionNavigator dn = new DefinitionNavigator(ctxt, sd, false, true);
    DefinitionNavigator firstSection = dn.childByName("section");
    Assertions.assertNotNull(firstSection);
    DefinitionNavigator recursiveSection = firstSection.childByName("section");
    Assertions.assertNotNull(recursiveSection);

    Assertions.assertDoesNotThrow(recursiveSection::children);
    Assertions.assertNotNull(recursiveSection.childByName("title"));
    Assertions.assertNotNull(recursiveSection.childByName("section"));
  }

}
