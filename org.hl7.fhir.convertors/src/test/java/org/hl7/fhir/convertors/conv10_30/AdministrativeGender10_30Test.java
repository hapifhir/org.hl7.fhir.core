package org.hl7.fhir.convertors.conv10_30;

import org.hl7.fhir.convertors.VersionConvertorAdvisor30;
import org.hl7.fhir.convertors.VersionConvertor_10_30;
import org.hl7.fhir.convertors.loaders.R2ToR3Loader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.io.InputStream;
import java.util.stream.Stream;

public class AdministrativeGender10_30Test {

    @Test
    @DisplayName("Test 10_30 extension present, value is not")
    public void testMedicationRequestConversion() throws IOException {
        InputStream dstu2_input = this.getClass().getResourceAsStream("/administrative_gender_null.json");
        org.hl7.fhir.dstu2.model.Patient dstu2 = (org.hl7.fhir.dstu2.model.Patient) new org.hl7.fhir.dstu2.formats.JsonParser().parse(dstu2_input);
        VersionConvertorAdvisor30 advisor = new R2ToR3Loader();
        org.hl7.fhir.dstu3.model.Resource stu_actual = VersionConvertor_10_30.convertResource(dstu2, advisor);
    }
}
