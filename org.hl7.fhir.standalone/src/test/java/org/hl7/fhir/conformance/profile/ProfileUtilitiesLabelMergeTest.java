package org.hl7.fhir.conformance.profile;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.Method;
import java.util.ArrayList;

import org.hl7.fhir.model.core.ElementDefinition;
import org.hl7.fhir.model.core.StructureDefinition;
import org.hl7.fhir.services.conformance.profile.MappingAssistant;
import org.hl7.fhir.services.conformance.profile.MappingAssistant.MappingMergeModeOption;
import org.hl7.fhir.services.conformance.profile.ProfileUtilities;
import org.junit.jupiter.api.Test;

/**
 * R6 counterpart of the org.hl7.fhir.r5 test of the same name, covering the "..." append
 * convention for ElementDefinition.label in ProfileUtilities.mergeStrings.
 */
class ProfileUtilitiesLabelMergeTest {

  private static final String PATH = "Patient.gender";

  @Test
  void labelStartingWithEllipsisIsAppendedToTheBaseLabel() throws Exception {
    ElementDefinition base = element("Base label");
    ElementDefinition differential = element("...and more");

    updateFromDefinition(base, differential);

    assertEquals("Base label and more", base.getLabel());
  }

  @Test
  void spaceAfterTheEllipsisIsNotDoubled() throws Exception {
    ElementDefinition base = element("Base label");
    ElementDefinition differential = element("... and more");

    updateFromDefinition(base, differential);

    assertEquals("Base label and more", base.getLabel());
  }

  @Test
  void labelNotStartingWithEllipsisReplacesTheBaseLabel() throws Exception {
    ElementDefinition base = element("Base label");
    ElementDefinition differential = element("Replacement label");

    updateFromDefinition(base, differential);

    assertEquals("Replacement label", base.getLabel());
  }

  private ElementDefinition element(String label) {
    ElementDefinition ed = new ElementDefinition();
    ed.setPath(PATH);
    ed.setLabel(label);
    return ed;
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
