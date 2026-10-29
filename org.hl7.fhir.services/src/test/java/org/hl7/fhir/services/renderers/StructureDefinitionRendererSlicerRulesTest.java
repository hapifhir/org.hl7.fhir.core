package org.hl7.fhir.services.renderers;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.hl7.fhir.model.core.ElementDefinition;
import org.hl7.fhir.model.core.ElementDefinition.DiscriminatorType;
import org.hl7.fhir.model.core.ElementDefinition.SlicingRules;
import org.junit.jupiter.api.Test;

class StructureDefinitionRendererSlicerRulesTest {

  private ElementDefinition makeSlicer() {
    ElementDefinition ed = new ElementDefinition();
    ed.setId("Patient.identifier");
    ed.setPath("Patient.identifier");
    ed.getSlicing().setRules(SlicingRules.OPEN).addDiscriminator().setType(DiscriminatorType.VALUE).setPath("system");
    ed.setMin(1);
    return ed;
  }

  @Test
  void slicingAndCardinalityAreNotRules() {
    assertFalse(StructureDefinitionRenderer.hasSlicerRules(makeSlicer(), false));
  }

  @Test
  void emptyChildrenCreatedByGettersAreNotRules() {
    ElementDefinition ed = makeSlicer();
    ed.getBase().getPath();
    ed.getBinding().getStrength();
    assertFalse(ed.hasBase());
    assertFalse(ed.hasBinding());
    assertFalse(StructureDefinitionRenderer.hasSlicerRules(ed, false));
  }

  @Test
  void aConstraintOnTheSlicerIsARule() {
    ElementDefinition ed = makeSlicer();
    ed.getBase();
    ed.setMustSupport(true);
    assertTrue(StructureDefinitionRenderer.hasSlicerRules(ed, false));
  }
}
