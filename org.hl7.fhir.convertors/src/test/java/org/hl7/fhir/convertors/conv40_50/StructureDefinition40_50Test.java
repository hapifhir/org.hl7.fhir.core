package org.hl7.fhir.convertors.conv40_50;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.apache.commons.text.StringEscapeUtils;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_40_50;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StructureDefinition40_50Test {


  @Test
  @DisplayName("Test r5 -> r4 AuditEvent conversion.")
  public void testR5_R4() throws IOException {
    byte[] r4_input = TextFile.streamToBytes(this.getClass().getResourceAsStream("/sd-xpath-constraint-r4.xml"));
    byte[] r5_input = TextFile.streamToBytes(this.getClass().getResourceAsStream("/sd-xpath-constraint-r5.xml"));

    org.hl7.fhir.r5.model.StructureDefinition r5_actual = (org.hl7.fhir.r5.model.StructureDefinition) new org.hl7.fhir.r5.formats.XmlParser().parse(r5_input);
    org.hl7.fhir.r4.model.StructureDefinition r4_conv = (org.hl7.fhir.r4.model.StructureDefinition) VersionConvertorFactory_40_50.convertResource(r5_actual);
    byte[] r4_output = new org.hl7.fhir.r4.formats.XmlParser().setOutputStyle(org.hl7.fhir.r4.formats.IParser.OutputStyle.PRETTY).composeBytes(r4_conv);

    printBytes("r4_input", r4_input);
    printBytes("r4_output", r4_output);
    assertArrayEquals(r4_input, r4_output);
  }


  @Test
  @DisplayName("Test r4 -> r5 AuditEvent conversion.")
  public void testR4_R5() throws IOException {
    byte[] r4_input = TextFile.streamToBytes(this.getClass().getResourceAsStream("/sd-xpath-constraint-r4.xml"));
    byte[] r5_input = TextFile.streamToBytes(this.getClass().getResourceAsStream("/sd-xpath-constraint-r5.xml"));

    org.hl7.fhir.r4.model.StructureDefinition r4_actual = (org.hl7.fhir.r4.model.StructureDefinition) new org.hl7.fhir.r4.formats.XmlParser().parse(r4_input);
    org.hl7.fhir.r5.model.StructureDefinition r5_conv = (org.hl7.fhir.r5.model.StructureDefinition) VersionConvertorFactory_40_50.convertResource(r4_actual);
    byte[] r5_output = new org.hl7.fhir.r5.formats.XmlParser().setOutputStyle(org.hl7.fhir.r5.formats.IParser.OutputStyle.PRETTY).composeBytes(r5_conv);
    
    printBytes("r5_input", r5_input);
    printBytes("r5_output", r5_output);
    assertArrayEquals(r5_input, r5_output);
  }

  private void printBytes(String nameOfVariable, byte[] bytes) {
    System.out.println("---MY PERSONAL DEBUG START name=" + nameOfVariable + " length=" + bytes.length +" ---");
    System.out.println(StringEscapeUtils.escapeJava(new String(bytes)));
    System.out.println("---MY PERSONAL DEBUG (" + nameOfVariable + ") END---");
  }
}
