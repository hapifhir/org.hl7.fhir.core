package org.hl7.fhir.convertors.conv40_50;

import org.hl7.fhir.convertors.factory.VersionConvertorFactory_30_40;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_40_50;
import org.hl7.fhir.r4.model.AllergyIntolerance;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class AllergyIntolerance40_50Test {
    @Test
    @DisplayName("Test r4 -> r5 conversion for AllergyIntolerance with resolved clinical status")
    public void test1() {
        // Given resource with dstu3 resource with resolved clinicalStatus
        org.hl7.fhir.r4.model.AllergyIntolerance r4AllergyIntolerance = new org.hl7.fhir.r4.model.AllergyIntolerance();

        r4AllergyIntolerance.setClinicalStatus(new CodeableConcept(new Coding().setCode("resolved")));
        // When convertor is called
        org.hl7.fhir.r5.model.Resource r5Resource = VersionConvertorFactory_40_50.convertResource(r4AllergyIntolerance);

        // Then r5 resource should have resolved clinicalStatus
        Assertions.assertTrue(r5Resource instanceof org.hl7.fhir.r5.model.AllergyIntolerance);
        org.hl7.fhir.r5.model.AllergyIntolerance r5AllergyIntolerance = (org.hl7.fhir.r5.model.AllergyIntolerance) r5Resource;

        List<org.hl7.fhir.r5.model.Coding> r5AllergyCodeableConcept = r5AllergyIntolerance.getClinicalStatus().getCoding();
        Assertions.assertEquals(1, r5AllergyCodeableConcept.size());

        String r5AllergyCode = r5AllergyCodeableConcept.get(0).getCode();
        Assertions.assertEquals("resolved", r5AllergyCode);

    }
}
