package org.hl7.fhir.convertors.conv10_40;

import org.hl7.fhir.convertors.VersionConvertorAdvisor40;
import org.hl7.fhir.convertors.VersionConvertor_10_40;
import org.hl7.fhir.convertors.misc.IGR2ConvertorAdvisor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.io.InputStream;
import java.util.stream.Stream;

public class AllergyIntolerance10_40Test {
    private static Stream<Arguments> filesPaths() {
        return Stream.of(
                Arguments.of("/0_allergy_intolerance_10.json", "/0_allergy_intolerance_40.json"),
                Arguments.of("/1_allergy_intolerance_10.json", "/1_allergy_intolerance_40.json")
        );
    }

    @ParameterizedTest
    @MethodSource("filesPaths")
    @DisplayName("Test 10_40 AllergyIntolerance conversion")
    public void testMedicationRequestConversion(String dstu2_path, String r4_path) throws IOException {
        InputStream dstu2_input = this.getClass().getResourceAsStream(dstu2_path);
        InputStream r4_exepected_input = this.getClass().getResourceAsStream(r4_path);

        org.hl7.fhir.dstu2.model.AllergyIntolerance dstu2 = (org.hl7.fhir.dstu2.model.AllergyIntolerance) new org.hl7.fhir.dstu2.formats.JsonParser().parse(dstu2_input);
        VersionConvertorAdvisor40 advisor = new IGR2ConvertorAdvisor();
        org.hl7.fhir.r4.model.Resource r4_actual = VersionConvertor_10_40.convertResource(dstu2, advisor);

        org.hl7.fhir.r4.formats.JsonParser r4_parser = new org.hl7.fhir.r4.formats.JsonParser();
        org.hl7.fhir.r4.model.Resource r4_expected = r4_parser.parse(r4_exepected_input);

        if (!r4_expected.equalsDeep(r4_actual)) {
          System.out.println("Expected");
          System.out.println(r4_parser.composeString(r4_expected));
          System.out.println();
          System.out.println("Actual");
          System.out.println(r4_parser.composeString(r4_actual));
        }
        Assertions.assertTrue(r4_expected.equalsDeep(r4_actual), "Failed comparing\n" + r4_parser.composeString(r4_actual) + "\nand\n" + r4_parser.composeString(r4_expected)
        );
    }
}
