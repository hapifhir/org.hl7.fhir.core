package org.hl7.fhir.convertors.conv40_N;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_40_N;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * R4 Immunization.protocolApplied.doseNumber[x] is a positiveInt|string choice, while in R6 it is a
 * CodeableConcept. The conversion used to be done on the value rather than the element, which lost the
 * original type (a positiveInt came back as a string), and lost the element altogether where it had
 * extensions but no value. The same issue was fixed for R4/R5 in Immunization40_50Test
 */
class Immunization40_NTest {

  private static final String DAR = "http://hl7.org/fhir/StructureDefinition/data-absent-reason";

  private org.hl7.fhir.r4.model.Immunization makeImmunization(org.hl7.fhir.r4.model.Type doseNumber) {
    org.hl7.fhir.r4.model.Immunization src = new org.hl7.fhir.r4.model.Immunization();
    src.setStatus(org.hl7.fhir.r4.model.Immunization.ImmunizationStatus.COMPLETED);
    src.addProtocolApplied().setDoseNumber(doseNumber);
    return src;
  }

  private org.hl7.fhir.model.core.Immunization toR6(org.hl7.fhir.r4.model.Immunization src) {
    return (org.hl7.fhir.model.core.Immunization) VersionConvertorFactory_40_N.convertResource(src);
  }

  private org.hl7.fhir.r4.model.Immunization toR4(org.hl7.fhir.model.core.Immunization src) {
    return (org.hl7.fhir.r4.model.Immunization) VersionConvertorFactory_40_N.convertResource(src);
  }

  @Test
  @DisplayName("A positiveInt doseNumber survives the round trip as a positiveInt")
  void testPositiveIntDoseNumberRoundTrips() {
    org.hl7.fhir.model.core.Immunization r6 = toR6(makeImmunization(new org.hl7.fhir.r4.model.PositiveIntType(2)));
    assertEquals("2", r6.getProtocolAppliedFirstRep().getDoseNumber().getText());

    org.hl7.fhir.r4.model.Type tgt = toR4(r6).getProtocolAppliedFirstRep().getDoseNumber();
    assertTrue(tgt instanceof org.hl7.fhir.r4.model.PositiveIntType, "expected a positiveInt, not a " + tgt.fhirType());
    assertEquals("2", tgt.primitiveValue());
    assertFalse(tgt.hasExtension(VersionConvertorConstants.EXT_ORIGINAL_DATATYPE), "the marker extension should not be carried into R4");
  }

  @Test
  @DisplayName("A string doseNumber survives the round trip as a string")
  void testStringDoseNumberRoundTrips() {
    org.hl7.fhir.model.core.Immunization r6 = toR6(makeImmunization(new org.hl7.fhir.r4.model.StringType("2")));
    assertEquals("2", r6.getProtocolAppliedFirstRep().getDoseNumber().getText());
    assertFalse(r6.getProtocolAppliedFirstRep().getDoseNumber().hasExtension(VersionConvertorConstants.EXT_ORIGINAL_DATATYPE));

    org.hl7.fhir.r4.model.Type tgt = toR4(r6).getProtocolAppliedFirstRep().getDoseNumber();
    assertTrue(tgt instanceof org.hl7.fhir.r4.model.StringType, "expected a string, not a " + tgt.fhirType());
    assertEquals("2", tgt.primitiveValue());
  }

  @Test
  @DisplayName("A doseNumber with extensions but no value is not lost")
  void testValuelessDoseNumberRoundTrips() {
    org.hl7.fhir.r4.model.PositiveIntType doseNumber = new org.hl7.fhir.r4.model.PositiveIntType();
    doseNumber.addExtension(DAR, new org.hl7.fhir.r4.model.CodeType("asked-unknown"));

    org.hl7.fhir.model.core.Immunization r6 = toR6(makeImmunization(doseNumber));
    org.hl7.fhir.model.core.CodeableConcept mid = r6.getProtocolAppliedFirstRep().getDoseNumber();
    assertFalse(mid.hasText(), "a value-less doseNumber should not acquire a value");
    assertTrue(mid.hasExtension(DAR), "the data absent reason should survive the conversion to R6");

    org.hl7.fhir.r4.model.Type tgt = toR4(r6).getProtocolAppliedFirstRep().getDoseNumber();
    assertTrue(tgt instanceof org.hl7.fhir.r4.model.PositiveIntType, "expected a positiveInt, not a " + (tgt == null ? "missing doseNumber" : tgt.fhirType()));
    assertFalse(((org.hl7.fhir.r4.model.PositiveIntType) tgt).hasValue(), "a value-less doseNumber should not acquire a value");
    assertTrue(tgt.hasExtension(DAR), "the data absent reason should survive the conversion back to R4");
    assertFalse(tgt.hasExtension(VersionConvertorConstants.EXT_ORIGINAL_DATATYPE), "the marker extension should not be carried into R4");
  }

  @Test
  @DisplayName("Extensions on a doseNumber that does have a value are not lost either")
  void testDoseNumberExtensionsRoundTrip() {
    org.hl7.fhir.r4.model.PositiveIntType doseNumber = new org.hl7.fhir.r4.model.PositiveIntType(2);
    doseNumber.setId("d1");
    doseNumber.addExtension("http://example.org/test", new org.hl7.fhir.r4.model.StringType("x"));

    org.hl7.fhir.r4.model.Type tgt = toR4(toR6(makeImmunization(doseNumber))).getProtocolAppliedFirstRep().getDoseNumber();
    assertEquals("2", tgt.primitiveValue());
    assertEquals("d1", tgt.getId());
    assertTrue(tgt.hasExtension("http://example.org/test"));
  }

  @Test
  @DisplayName("seriesDoses is converted the same way")
  void testSeriesDosesRoundTrips() {
    org.hl7.fhir.r4.model.Immunization src = makeImmunization(new org.hl7.fhir.r4.model.PositiveIntType(1));
    src.getProtocolAppliedFirstRep().setSeriesDoses(new org.hl7.fhir.r4.model.PositiveIntType(3));

    org.hl7.fhir.r4.model.Type tgt = toR4(toR6(src)).getProtocolAppliedFirstRep().getSeriesDoses();
    assertTrue(tgt instanceof org.hl7.fhir.r4.model.PositiveIntType, "expected a positiveInt, not a " + tgt.fhirType());
    assertEquals("3", tgt.primitiveValue());
  }

  @Test
  @DisplayName("A contained Immunization round-trips intact (the IG Publisher case, HL7/fhir-ig-publisher#1362)")
  void testContainedImmunizationRoundTrips() {
    org.hl7.fhir.r4.model.PositiveIntType absent = new org.hl7.fhir.r4.model.PositiveIntType();
    absent.addExtension(DAR, new org.hl7.fhir.r4.model.CodeType("asked-unknown"));
    org.hl7.fhir.r4.model.Immunization dar = makeImmunization(absent);
    dar.setId("dar");
    org.hl7.fhir.r4.model.Immunization valued = makeImmunization(new org.hl7.fhir.r4.model.PositiveIntType(2));
    valued.setId("valued");

    org.hl7.fhir.r4.model.Questionnaire src = new org.hl7.fhir.r4.model.Questionnaire();
    src.setStatus(org.hl7.fhir.r4.model.Enumerations.PublicationStatus.DRAFT);
    src.addContained(dar);
    src.addContained(valued);

    org.hl7.fhir.r4.model.Questionnaire back = (org.hl7.fhir.r4.model.Questionnaire) VersionConvertorFactory_40_N.convertResource(
        VersionConvertorFactory_40_N.convertResource(src));
    assertTrue(src.equalsDeep(back), "the contained Immunizations should round-trip unchanged");
  }
}
