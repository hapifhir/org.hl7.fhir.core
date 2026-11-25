package org.hl7.fhir.convertors.conv40_N;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_40_N;
import org.hl7.fhir.model.core.Availability;
import org.hl7.fhir.model.core.CodeableConcept;
import org.hl7.fhir.model.core.CodeableReference;
import org.hl7.fhir.model.core.Extension;
import org.hl7.fhir.model.core.Organization;
import org.hl7.fhir.model.core.Reference;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * An extension whose value is an R6 datatype that R4 doesn't have goes into R4 as a complex extension (one
 * sub-extension per element, marked with original-datatype), and comes back as the same datatype
 */
class CrossVersionDatatype40_NTest {

  private static final String TZ = "http://hl7.org/fhir/StructureDefinition/timezone";

  private static Organization roundTrip(Organization src, org.hl7.fhir.r4.model.Organization[] r4) {
    r4[0] = (org.hl7.fhir.r4.model.Organization) VersionConvertorFactory_40_N.convertResource(src);
    return (Organization) VersionConvertorFactory_40_N.convertResource(r4[0]);
  }

  @Test
  @DisplayName("An Availability extension value round trips through R4")
  void testAvailability() {
    Availability av = new Availability();
    Availability.AvailabilityAvailableTimeComponent at = av.addAvailableTime();
    at.addDaysOfWeek(org.hl7.fhir.model.core.Enumerations.DaysOfWeek.MON);
    at.addDaysOfWeek(org.hl7.fhir.model.core.Enumerations.DaysOfWeek.TUE);
    at.setAvailableStartTime("09:00:00");
    at.getAvailableStartTimeElement().addExtension(TZ, new org.hl7.fhir.model.core.CodeType("America/New_York"));
    at.setAvailableEndTime("17:00:00");
    av.addNotAvailableTime().setDescription("Christmas")
      .getDuring().setStartElement(new org.hl7.fhir.model.core.DateTimeType("2026-12-25"));

    Organization src = new Organization();
    src.setName("Test");
    src.addExtension(new Extension().setUrl("http://example.org/availability").setValue(av));

    org.hl7.fhir.r4.model.Organization[] r4 = new org.hl7.fhir.r4.model.Organization[1];
    Organization back = roundTrip(src, r4);

    org.hl7.fhir.r4.model.Extension ext = r4[0].getExtensionByUrl("http://example.org/availability");
    assertNull(ext.getValue(), "R4 has no Availability, so there should be no value");
    assertEquals("Availability", ext.getExtensionString(VersionConvertorConstants.EXT_ORIGINAL_DATATYPE));
    assertEquals(2, ext.getExtensionByUrl("availableTime").getExtensionsByUrl("daysOfWeek").size());

    assertTrue(src.equalsDeep(back), "the Availability should come back unchanged");
  }

  @Test
  @DisplayName("A CodeableReference extension value round trips through R4")
  void testCodeableReference() {
    CodeableReference cr = new CodeableReference();
    cr.setConcept(new CodeableConcept().setText("a concept"));
    cr.setReference(new Reference().setReference("Patient/p1"));

    Organization src = new Organization();
    src.setName("Test");
    src.addExtension(new Extension().setUrl("http://example.org/cr").setValue(cr));

    org.hl7.fhir.r4.model.Organization[] r4 = new org.hl7.fhir.r4.model.Organization[1];
    Organization back = roundTrip(src, r4);

    org.hl7.fhir.r4.model.Extension ext = r4[0].getExtensionByUrl("http://example.org/cr");
    assertTrue(ext.getExtensionByUrl("concept").getValue() instanceof org.hl7.fhir.r4.model.CodeableConcept);
    assertTrue(ext.getExtensionByUrl("reference").getValue() instanceof org.hl7.fhir.r4.model.Reference);
    assertTrue(src.equalsDeep(back), "the CodeableReference should come back unchanged");
  }
}
