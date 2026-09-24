package org.hl7.fhir.r5.conformance.profile;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.r5.conformance.profile.MappingAssistant.MappingMergeModeOption;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.ElementDefinition.AdditionalBindingPurposeVS;
import org.hl7.fhir.r5.model.Enumerations.BindingStrength;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.junit.jupiter.api.Test;

/**
 * Covers the folding of additional bindings from obligation profiles into the working
 * element, in ProfileUtilities.updateFromDefinition.
 */
class ProfileUtilitiesObligationBindingTest {

  private static final String PATH = "Patient.gender";
  private static final String OBLIGATION_VALUE_SET = "http://example.org/ValueSet/from-obligation";

  @Test
  void additionalBindingFromAnObligationProfileIsAdded() throws Exception {
    ElementDefinition base = element();
    base.addType().setCode("code");
    ElementDefinition differential = element();

    updateFromDefinition(base, differential, obligationProfile());

    assertEquals(1, base.getBinding().getAdditional().size(),
        "the obligation profile's additional binding should have been folded in");
    assertEquals(OBLIGATION_VALUE_SET, base.getBinding().getAdditional().get(0).getValueSet());
  }

  @Test
  void anAdditionalBindingAlreadyPresentIsNotDuplicated() throws Exception {
    ElementDefinition base = element();
    base.addType().setCode("code");
    ElementDefinition differential = element();
    differential.getBinding()
        .addAdditional()
        .setPurpose(AdditionalBindingPurposeVS.PREFERRED)
        .setValueSet(OBLIGATION_VALUE_SET);

    updateFromDefinition(base, differential, obligationProfile());

    assertEquals(1, base.getBinding().getAdditional().size(),
        "the binding is already present, so it should not be added again");
  }

  private ElementDefinition element() {
    ElementDefinition ed = new ElementDefinition();
    ed.setId(PATH);
    ed.setPath(PATH);
    ed.getBinding().setStrength(BindingStrength.EXTENSIBLE);
    return ed;
  }

  /** A profile whose snapshot carries one additional binding on the same element. */
  private StructureDefinition obligationProfile() {
    StructureDefinition sd = new StructureDefinition();
    ElementDefinition ed = sd.getSnapshot().addElement();
    ed.setId(PATH);
    ed.setPath(PATH);
    ed.getBinding().setStrength(BindingStrength.EXTENSIBLE);
    ed.getBinding()
        .addAdditional()
        .setPurpose(AdditionalBindingPurposeVS.PREFERRED)
        .setValueSet(OBLIGATION_VALUE_SET);
    return sd;
  }

  @SuppressWarnings("unchecked")
  private void updateFromDefinition(
      ElementDefinition base, ElementDefinition differential, StructureDefinition obligationProfile)
      throws Exception {
    StructureDefinition baseSD = new StructureDefinition();
    StructureDefinition derivedSD = new StructureDefinition();
    ProfileUtilities profileUtilities = new ProfileUtilities(null, new ArrayList<>(), null);

    // obligationProfiles is populated from extensions on the derived profile, which needs a
    // populated worker context, so the profile is injected directly here.
    Field field = ProfileUtilities.class.getDeclaredField("obligationProfiles");
    field.setAccessible(true);
    ((List<StructureDefinition>) field.get(profileUtilities)).add(obligationProfile);

    MappingAssistant mappings =
        new MappingAssistant(MappingMergeModeOption.DUPLICATE, baseSD, derivedSD, "5.0.0", null);
    profileUtilities.updateFromDefinition(
        base, differential, "test", false, "http://example.org/StructureDefinition/test",
        baseSD, derivedSD, PATH, mappings, false);
  }
}
