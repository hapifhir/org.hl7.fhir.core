package org.hl7.fhir.conformance.profile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Method;
import java.util.ArrayList;

import org.hl7.fhir.model.core.ElementDefinition;
import org.hl7.fhir.model.core.ElementDefinition.AdditionalBindingPurposeVS;
import org.hl7.fhir.model.core.Enumerations.BindingStrength;
import org.hl7.fhir.model.core.StructureDefinition;
import org.hl7.fhir.services.conformance.profile.MappingAssistant;
import org.hl7.fhir.services.conformance.profile.MappingAssistant.MappingMergeModeOption;
import org.hl7.fhir.services.conformance.profile.ProfileUtilities;
import org.junit.jupiter.api.Test;

/**
 * R6 counterpart of the org.hl7.fhir.r5 test of the same name, covering the merge of an
 * additional binding from a differential into the matching one inherited from the base.
 */
class ProfileUtilitiesAdditionalBindingTest {

  private static final String VALUE_SET = "http://example.org/ValueSet/test";
  private static final String PATH = "Patient.gender";

  @Test
  void mergedAdditionalBindingTakesAnyFromDifferential() throws Exception {
    ElementDefinition base = baseElement();
    ElementDefinition differential = differentialElement(true);

    updateFromDefinition(base, differential);

    assertEquals(1, base.getBinding().getAdditionalList().size(),
        "the additional bindings should have merged, not accumulated");
    assertTrue(base.getBinding().getAdditionalList().get(0).getAny(),
        "'any' set on the differential's additional binding should survive the merge");
  }

  @Test
  void mergedAdditionalBindingLeavesAnyUnsetWhenTheDifferentialDoesNotSetIt() throws Exception {
    ElementDefinition base = baseElement();
    ElementDefinition differential = differentialElement(false);
    differential.getBinding().getAdditionalList().get(0)
        .setDocumentation("documentation from the differential");

    updateFromDefinition(base, differential);

    assertEquals(1, base.getBinding().getAdditionalList().size());
    assertFalse(base.getBinding().getAdditionalList().get(0).getAny());
  }

  /**
   * The base element carries a bindable type: updateFromDefinition drops the binding
   * altogether from an element that has no type able to carry one.
   */
  private ElementDefinition baseElement() {
    ElementDefinition ed = new ElementDefinition();
    ed.setPath(PATH);
    ed.addType().setCode("code");
    addBinding(ed, false);
    return ed;
  }

  private ElementDefinition differentialElement(boolean any) {
    ElementDefinition ed = new ElementDefinition();
    ed.setPath(PATH);
    addBinding(ed, any);
    return ed;
  }

  private void addBinding(ElementDefinition ed, boolean any) {
    ed.getBinding().setStrength(BindingStrength.EXTENSIBLE);
    ed.getBinding()
        .addAdditional()
        .setPurpose(AdditionalBindingPurposeVS.PREFERRED)
        .setValueSet(VALUE_SET)
        .setAny(any);
  }

  /** updateFromDefinition is protected, and this test is in a different package. */
  private void updateFromDefinition(ElementDefinition base, ElementDefinition differential)
      throws Exception {
    StructureDefinition baseSD = new StructureDefinition();
    StructureDefinition derivedSD = new StructureDefinition();
    ProfileUtilities profileUtilities = new ProfileUtilities(null, new ArrayList<>(), null);
    MappingAssistant mappings =
        new MappingAssistant(MappingMergeModeOption.DUPLICATE, baseSD, derivedSD, "6.0.0", null);
    Method method = ProfileUtilities.class.getDeclaredMethod("updateFromDefinition",
        ElementDefinition.class, ElementDefinition.class, String.class, boolean.class, String.class,
        StructureDefinition.class, StructureDefinition.class, String.class, MappingAssistant.class,
        boolean.class);
    method.setAccessible(true);
    method.invoke(profileUtilities, base, differential, "test", false,
        "http://example.org/StructureDefinition/test", baseSD, derivedSD, PATH, mappings, false);
  }
}
