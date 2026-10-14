package org.hl7.fhir.convertors.conv40_50;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_40_50;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * R4 Immunization.protocolApplied.doseNumber[x] is a positiveInt|string choice, while in R5 it is a
 * plain string. The conversion used to be done on the value rather than the element, which lost the
 * original type, and lost the element altogether where it had extensions but no value
 */
public class Immunization40_50Test {

  private static final String DAR = "http://hl7.org/fhir/StructureDefinition/data-absent-reason";

  private org.hl7.fhir.r4.model.Immunization makeImmunization(org.hl7.fhir.r4.model.Type doseNumber) {
    org.hl7.fhir.r4.model.Immunization src = new org.hl7.fhir.r4.model.Immunization();
    src.setStatus(org.hl7.fhir.r4.model.Immunization.ImmunizationStatus.COMPLETED);
    src.addProtocolApplied().setDoseNumber(doseNumber);
    return src;
  }

  private org.hl7.fhir.r5.model.Immunization toR5(org.hl7.fhir.r4.model.Immunization src) {
    return (org.hl7.fhir.r5.model.Immunization) VersionConvertorFactory_40_50.convertResource(src);
  }

  private org.hl7.fhir.r4.model.Immunization toR4(org.hl7.fhir.r5.model.Immunization src) {
    return (org.hl7.fhir.r4.model.Immunization) VersionConvertorFactory_40_50.convertResource(src);
  }

  @Test
  @DisplayName("A positiveInt doseNumber survives the round trip as a positiveInt")
  public void testPositiveIntDoseNumberRoundTrips() {
    org.hl7.fhir.r5.model.Immunization r5 = toR5(makeImmunization(new org.hl7.fhir.r4.model.PositiveIntType(2)));
    assertEquals("2", r5.getProtocolAppliedFirstRep().getDoseNumber());

    org.hl7.fhir.r4.model.Type tgt = toR4(r5).getProtocolAppliedFirstRep().getDoseNumber();
    assertTrue(tgt instanceof org.hl7.fhir.r4.model.PositiveIntType, "expected a positiveInt, not a " + tgt.fhirType());
    assertEquals("2", tgt.primitiveValue());
    assertFalse(tgt.hasExtension(VersionConvertorConstants.EXT_ORIGINAL_DATATYPE), "the marker extension should not be carried into R4");
  }

  @Test
  @DisplayName("A string doseNumber survives the round trip as a string")
  public void testStringDoseNumberRoundTrips() {
    org.hl7.fhir.r5.model.Immunization r5 = toR5(makeImmunization(new org.hl7.fhir.r4.model.StringType("2")));
    assertEquals("2", r5.getProtocolAppliedFirstRep().getDoseNumber());
    assertFalse(r5.getProtocolAppliedFirstRep().getDoseNumberElement().hasExtension(VersionConvertorConstants.EXT_ORIGINAL_DATATYPE));

    org.hl7.fhir.r4.model.Type tgt = toR4(r5).getProtocolAppliedFirstRep().getDoseNumber();
    assertTrue(tgt instanceof org.hl7.fhir.r4.model.StringType, "expected a string, not a " + tgt.fhirType());
    assertEquals("2", tgt.primitiveValue());
  }

  @Test
  @DisplayName("A doseNumber with extensions but no value is not lost")
  public void testValuelessDoseNumberRoundTrips() {
    org.hl7.fhir.r4.model.PositiveIntType doseNumber = new org.hl7.fhir.r4.model.PositiveIntType();
    doseNumber.addExtension(DAR, new org.hl7.fhir.r4.model.CodeType("unknown"));

    org.hl7.fhir.r5.model.Immunization r5 = toR5(makeImmunization(doseNumber));
    org.hl7.fhir.r5.model.StringType mid = r5.getProtocolAppliedFirstRep().getDoseNumberElement();
    assertFalse(mid.hasValue(), "a value-less doseNumber should not acquire a value");
    assertTrue(mid.hasExtension(DAR), "the data absent reason should survive the conversion to R5");

    org.hl7.fhir.r4.model.Type tgt = toR4(r5).getProtocolAppliedFirstRep().getDoseNumber();
    assertTrue(tgt instanceof org.hl7.fhir.r4.model.PositiveIntType, "expected a positiveInt, not a " + tgt.fhirType());
    assertFalse(((org.hl7.fhir.r4.model.PositiveIntType) tgt).hasValue(), "a value-less doseNumber should not acquire a value");
    assertTrue(tgt.hasExtension(DAR), "the data absent reason should survive the conversion back to R4");
    assertFalse(tgt.hasExtension(VersionConvertorConstants.EXT_ORIGINAL_DATATYPE), "the marker extension should not be carried into R4");
  }

  @Test
  @DisplayName("Extensions on a doseNumber that does have a value are not lost either")
  public void testDoseNumberExtensionsRoundTrip() {
    org.hl7.fhir.r4.model.PositiveIntType doseNumber = new org.hl7.fhir.r4.model.PositiveIntType(2);
    doseNumber.setId("d1");
    doseNumber.addExtension("http://example.org/test", new org.hl7.fhir.r4.model.StringType("x"));

    org.hl7.fhir.r4.model.Type tgt = toR4(toR5(makeImmunization(doseNumber))).getProtocolAppliedFirstRep().getDoseNumber();
    assertEquals("2", tgt.primitiveValue());
    assertEquals("d1", tgt.getId());
    assertTrue(tgt.hasExtension("http://example.org/test"));
  }
}
