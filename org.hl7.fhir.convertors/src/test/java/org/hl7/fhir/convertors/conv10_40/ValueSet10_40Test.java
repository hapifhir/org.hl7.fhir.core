package org.hl7.fhir.convertors.conv10_40;

import java.io.IOException;
import java.io.InputStream;

import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_10_40;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_10_40;
import org.hl7.fhir.convertors.misc.IGR2ConvertorAdvisor;
import org.hl7.fhir.r4.formats.JsonParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ValueSet10_40Test {
  @Test
  @DisplayName("Test 10_40 ValueSet conversion")
  public void testValueSetConversion() throws IOException {
    InputStream dstu2_input = this.getClass().getResourceAsStream("/0_valueset_vision_base_codes_10.json");
    InputStream r4_exepected_input = this.getClass().getResourceAsStream("/0_valueset_vision_base_codes_40.json");

    org.hl7.fhir.dstu2.model.ValueSet dstu2 = (org.hl7.fhir.dstu2.model.ValueSet) new org.hl7.fhir.dstu2.formats.JsonParser().parse(dstu2_input);
    BaseAdvisor_10_40 advisor = new IGR2ConvertorAdvisor();
    org.hl7.fhir.r4.model.Resource r4_actual = VersionConvertorFactory_10_40.convertResource(dstu2, advisor);

    org.hl7.fhir.r4.formats.JsonParser r4_parser = new org.hl7.fhir.r4.formats.JsonParser();
    JsonParser parser = new JsonParser();
    String composeString = parser.composeString(r4_actual);
    org.hl7.fhir.r4.model.Resource r4_expected = r4_parser.parse(r4_exepected_input);

    Assertions.assertTrue(r4_expected.equalsDeep(r4_actual),
      "Failed comparing\n" + r4_parser.composeString(r4_actual) + "\nand\n" + r4_parser.composeString(r4_expected));
  }

}
