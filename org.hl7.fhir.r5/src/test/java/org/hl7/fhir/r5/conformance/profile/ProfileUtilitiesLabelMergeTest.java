package org.hl7.fhir.r5.conformance.profile;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.hl7.fhir.r5.conformance.profile.MappingAssistant.MappingMergeModeOption;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.junit.jupiter.api.Test;

/**
 * Covers the "..." append convention for ElementDefinition.label, in
 * ProfileUtilities.mergeStrings.
 */
class ProfileUtilitiesLabelMergeTest {

  private static final String PATH = "Patient.gender";

  @Test
  void labelStartingWithEllipsisIsAppendedToTheBaseLabel() throws Exception {
    ElementDefinition base = element("Base label");
    ElementDefinition differential = element("...and more");

    updateFromDefinition(base, differential);

    assertEquals("Base label\r\nand more", base.getLabel());
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
