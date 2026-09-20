package org.hl7.fhir.r5.conformance.profile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.hl7.fhir.r5.conformance.profile.MappingAssistant.MappingMergeModeOption;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.ElementDefinition.AdditionalBindingPurposeVS;
import org.hl7.fhir.r5.model.Enumerations.BindingStrength;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.junit.jupiter.api.Test;

/**
 * Covers the merge of an additional binding from a differential into the matching additional
 * binding inherited from the base, in ProfileUtilities.mergeAdditionalBinding.
 */
class ProfileUtilitiesAdditionalBindingTest {

  private static final String VALUE_SET = "http://example.org/ValueSet/test";
  private static final String PATH = "Patient.gender";

  @Test
  void mergedAdditionalBindingTakesAnyFromDifferential() throws Exception {
    ElementDefinition base = baseElement(false);
    ElementDefinition differential = differentialElement(true);

    updateFromDefinition(base, differential);

    assertEquals(1, base.getBinding().getAdditional().size(), "the additional bindings should have merged, not accumulated");
    assertTrue(
        base.getBinding().getAdditional().get(0).getAny(),
        "'any' set on the differential's additional binding should survive the merge");
  }

  @Test
  void mergedAdditionalBindingLeavesAnyUnsetWhenTheDifferentialDoesNotSetIt() throws Exception {
    ElementDefinition base = baseElement(false);
    ElementDefinition differential = differentialElement(false);
    // give the differential something else to contribute, so the two bindings are not identical
    differential.getBinding().getAdditional().get(0).setDocumentation("documentation from the differential");

    updateFromDefinition(base, differential);

    assertEquals(1, base.getBinding().getAdditional().size());
    assertFalse(base.getBinding().getAdditional().get(0).getAny());
    assertEquals("documentation from the differential", base.getBinding().getAdditional().get(0).getDocumentation());
  }

  @Test
  void mergedAdditionalBindingTakesAnyFalseFromDifferential() throws Exception {
    ElementDefinition base = baseElement(true);
    ElementDefinition differential = differentialElement(false);

    updateFromDefinition(base, differential);

    assertEquals(1, base.getBinding().getAdditional().size());
    assertFalse(base.getBinding().getAdditional().get(0).getAny(),
        "'any' = false on the differential should override 'any' = true inherited from the base");
  }

  @Test
  void mergedAdditionalBindingKeepsBaseAnyWhenTheDifferentialIsSilent() throws Exception {
    ElementDefinition base = baseElement(true);
    ElementDefinition differential = differentialElement(null);
    differential.getBinding().getAdditional().get(0).setDocumentation("documentation from the differential");

    updateFromDefinition(base, differential);

    assertEquals(1, base.getBinding().getAdditional().size());
    assertTrue(base.getBinding().getAdditional().get(0).getAny(),
        "a differential that does not mention 'any' should leave the inherited value alone");
  }

  /**
   * The base element carries a bindable type: updateFromDefinition drops the binding
   * altogether from an element that has no type able to carry one.
   */
  private ElementDefinition baseElement(boolean any) {
    ElementDefinition ed = new ElementDefinition();
    ed.setPath(PATH);
    ed.addType().setCode("code");
    addBinding(ed, any);
    return ed;
  }

  private ElementDefinition differentialElement(Boolean any) {
    ElementDefinition ed = new ElementDefinition();
    ed.setPath(PATH);
    addBinding(ed, any);
    return ed;
  }

  /** any == null leaves 'any' absent on the additional binding. */
  private void addBinding(ElementDefinition ed, Boolean any) {
    ed.getBinding().setStrength(BindingStrength.EXTENSIBLE);
    ElementDefinition.ElementDefinitionBindingAdditionalComponent ab = ed.getBinding()
        .addAdditional()
        .setPurpose(AdditionalBindingPurposeVS.PREFERRED)
        .setValueSet(VALUE_SET);
    if (any != null) {
      ab.setAny(any);
    }
  }

  private void updateFromDefinition(ElementDefinition base, ElementDefinition differential) throws Exception {
    StructureDefinition baseSD = new StructureDefinition();
    StructureDefinition derivedSD = new StructureDefinition();
    ProfileUtilities profileUtilities = new ProfileUtilities(null, new ArrayList<>(), null);
    MappingAssistant mappings =
        new MappingAssistant(MappingMergeModeOption.DUPLICATE, baseSD, derivedSD, "5.0.0", null);
    profileUtilities.updateFromDefinition(
        base, differential, "test", false, "http://example.org/StructureDefinition/test", baseSD, derivedSD, PATH, mappings, false);
  }
}
