package org.hl7.fhir.convertors.conv40_50;

import org.hl7.fhir.convertors.factory.VersionConvertorFactory_40_50;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class ValueSet40_50Test {


  @Test
  @DisplayName("Test ValueSet R4 <-> R5 with property extensions")
  public void testValueExpressionConversion40_10() throws IOException {
    InputStream r4_stream = this.getClass().getResourceAsStream("/value_set_r4.json");
    org.hl7.fhir.r4.model.ValueSet r4_input = (org.hl7.fhir.r4.model.ValueSet) new org.hl7.fhir.r4.formats.JsonParser().parse(r4_stream);

    InputStream r5_stream = this.getClass().getResourceAsStream("/value_set_r5.json");
    org.hl7.fhir.r5.model.ValueSet r5_input = (org.hl7.fhir.r5.model.ValueSet) new org.hl7.fhir.r5.formats.JsonParser().parse(r5_stream);

    org.hl7.fhir.r5.model.ValueSet r5_output = (org.hl7.fhir.r5.model.ValueSet) VersionConvertorFactory_40_50.convertResource(r4_input);
    org.hl7.fhir.r4.model.ValueSet r4_output = (org.hl7.fhir.r4.model.ValueSet) VersionConvertorFactory_40_50.convertResource(r5_input);

    org.hl7.fhir.r5.formats.JsonParser r5_parser = new org.hl7.fhir.r5.formats.JsonParser();
    String r5_in = r5_parser.setOutputStyle(OutputStyle.PRETTY).composeString(r5_input);
    String r5_out = r5_parser.composeString(r5_output);
    boolean pass = r5_input.equalsDeep(r5_output);
    if (!pass) {
       System.out.println("R5. Expected out ->\n"+ r5_in + "\n\nActual out ->\n" + r5_out);
    }
    Assertions.assertTrue(pass);
    
    org.hl7.fhir.r4.formats.JsonParser r4_parser = new org.hl7.fhir.r4.formats.JsonParser();
    String r4_in = r4_parser.composeString(r4_input);
    String r4_out = r4_parser.composeString(r4_output);
    pass = r4_input.equalsDeep(r4_output);
    if (!pass) {
      System.out.println("R4. Expected out ->\n"+ r4_in + "\n\nActual out ->\n" + r4_out);
    }
    Assertions.assertTrue(pass);
  }

  
}
