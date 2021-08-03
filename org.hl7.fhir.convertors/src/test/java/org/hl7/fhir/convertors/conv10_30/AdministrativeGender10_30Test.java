package org.hl7.fhir.convertors.conv10_30;

import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_10_30;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_10_30;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class AdministrativeGender10_30Test {

    @Test
    @DisplayName("Test 10_30 extension present, value is not")
    public void testMedicationRequestConversion() throws IOException {
        InputStream dstu2_input = this.getClass().getResourceAsStream("/administrative_gender_null.json");
        org.hl7.fhir.dstu2.model.Patient dstu2 = (org.hl7.fhir.dstu2.model.Patient) new org.hl7.fhir.dstu2.formats.JsonParser().parse(dstu2_input);
      VersionConvertorFactory_10_30.convertResource(dstu2, new BaseAdvisor_10_30());
    }
}
