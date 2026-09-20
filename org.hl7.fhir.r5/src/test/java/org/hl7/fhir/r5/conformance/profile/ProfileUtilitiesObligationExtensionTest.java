package org.hl7.fhir.r5.conformance.profile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.r5.conformance.profile.MappingAssistant.MappingMergeModeOption;
import org.hl7.fhir.r5.extensions.ExtensionDefinitions;
import org.hl7.fhir.r5.model.CodeType;
import org.hl7.fhir.r5.model.ElementDefinition;
import org.hl7.fhir.r5.model.Extension;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.junit.jupiter.api.Test;

/**
 * Covers copying obligation extensions from an inherited obligation profile onto an
 * element the differential also touches, in ProfileUtilities.updateFromDefinition.
 */
class ProfileUtilitiesObligationExtensionTest {

  private static final String PATH = "Patient.birthDate";

  @Test
  void aComplexObligationExtensionIsCopiedRatherThanDereferenced() throws Exception {
    ElementDefinition base = element();
    ElementDefinition differential = element();
    differential.setShort("changed by the derived profile");

    updateFromDefinition(base, differential, obligationProfile());

    List<Extension> obligations =
        base.getExtensionsByUrl(ExtensionDefinitions.EXT_OBLIGATION_CORE);
    assertEquals(1, obligations.size(), "the obligation extension should have been copied");
    assertTrue(obligations.get(0).hasExtension("code"),
        "the nested parts of the obligation should survive the copy");
  }

  private ElementDefinition element() {
    ElementDefinition ed = new ElementDefinition();
    ed.setId(PATH);
    ed.setPath(PATH);
    return ed;
  }

  /**
   * obligation is a complex extension: nested extensions and no value[x], which is what
   * makes ext.getValue() null.
   */
  private StructureDefinition obligationProfile() {
    StructureDefinition sd = new StructureDefinition();
    ElementDefinition ed = sd.getSnapshot().addElement();
    ed.setId(PATH);
    ed.setPath(PATH);
    Extension obligation = new Extension(ExtensionDefinitions.EXT_OBLIGATION_CORE);
    obligation.addExtension("code", new CodeType("SHALL:populate"));
    ed.getExtension().add(obligation);
    return sd;
  }

  @SuppressWarnings("unchecked")
  private void updateFromDefinition(
      ElementDefinition base, ElementDefinition differential, StructureDefinition obligationProfile)
      throws Exception {
    StructureDefinition baseSD = new StructureDefinition();
    StructureDefinition derivedSD = new StructureDefinition();
    ProfileUtilities profileUtilities = new ProfileUtilities(null, new ArrayList<>(), null);

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
