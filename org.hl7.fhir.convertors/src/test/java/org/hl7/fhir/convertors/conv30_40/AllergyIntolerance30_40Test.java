package org.hl7.fhir.convertors.conv30_40;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_30_40;
import org.junit.jupiter.api.Assertions;

public class AllergyIntolerance30_40Test {
    @Test
    @DisplayName("Test stu3 -> r4 conversion for AllergyIntolerance with resolved clinical status")
    public void test1() {
        // Given resource with dstu3 resource with resolved clinicalStatus
        org.hl7.fhir.dstu3.model.AllergyIntolerance dstu3Allergy = new org.hl7.fhir.dstu3.model.AllergyIntolerance();
        dstu3Allergy.setClinicalStatus(
                org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceClinicalStatus.RESOLVED);

        // When convertor is called
        org.hl7.fhir.r4.model.Resource r4Resource = VersionConvertorFactory_30_40.convertResource(dstu3Allergy);

        // Then r4 resource should have resolved clinicalStatus
        Assertions.assertTrue(r4Resource instanceof org.hl7.fhir.r4.model.AllergyIntolerance);
        org.hl7.fhir.r4.model.AllergyIntolerance r4Allergy = (org.hl7.fhir.r4.model.AllergyIntolerance) r4Resource;

        List<org.hl7.fhir.r4.model.Coding> r4AllergyCodeableConcept = r4Allergy.getClinicalStatus().getCoding();
        Assertions.assertEquals(1, r4AllergyCodeableConcept.size());

        String r4AllergyCode = r4AllergyCodeableConcept.get(0).getCode();
        Assertions.assertEquals("resolved", r4AllergyCode);

    }
}
