package org.hl7.fhir.convertors.conv10_40;

import org.hl7.fhir.convertors.VersionConvertorAdvisor40;
import org.hl7.fhir.convertors.VersionConvertor_10_40;
import org.hl7.fhir.convertors.misc.IGR2ConvertorAdvisor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class Observation10_40Test {
    @Test
    @DisplayName("Test 10_40 Observation conversion")
    public void testObservationConversion() throws IOException {
        InputStream dstu2_input = this.getClass().getResourceAsStream("/0_observation_10.json");
        InputStream r4_exepected_input = this.getClass().getResourceAsStream("/0_observation_40.json");

        org.hl7.fhir.dstu2.model.Observation dstu2 = (org.hl7.fhir.dstu2.model.Observation) new org.hl7.fhir.dstu2.formats.JsonParser().parse(dstu2_input);
        VersionConvertorAdvisor40 advisor = new IGR2ConvertorAdvisor();
        org.hl7.fhir.r4.model.Resource r4_actual = VersionConvertor_10_40.convertResource(dstu2, advisor);

        org.hl7.fhir.r4.formats.JsonParser r4_parser = new org.hl7.fhir.r4.formats.JsonParser();
        org.hl7.fhir.r4.model.Resource r4_expected = r4_parser.parse(r4_exepected_input);

        Assertions.assertTrue(r4_expected.equalsDeep(r4_actual),
            "Failed comparing\n" + r4_parser.composeString(r4_actual) + "\nand\n" + r4_parser.composeString(r4_expected));
    }

}
