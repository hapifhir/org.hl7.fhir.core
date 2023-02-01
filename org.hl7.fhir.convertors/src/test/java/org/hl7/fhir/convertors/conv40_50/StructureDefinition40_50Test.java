package org.hl7.fhir.convertors.conv40_50;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.io.IOException;

import javax.annotation.Nullable;

import org.hl7.fhir.convertors.factory.VersionConvertorFactory_40_50;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StructureDefinition40_50Test {


  @Test
  @DisplayName("Test r5 -> r4 AuditEvent conversion.")
  public void testR5_R4() throws IOException {
    byte[] r4_input = getLineSeparatorNormalizedBytes("/sd-xpath-constraint-r4.xml");
    byte[] r5_input = getLineSeparatorNormalizedBytes("/sd-xpath-constraint-r5.xml");

    org.hl7.fhir.r5.model.StructureDefinition r5_actual = (org.hl7.fhir.r5.model.StructureDefinition) new org.hl7.fhir.r5.formats.XmlParser().parse(r5_input);
    org.hl7.fhir.r4.model.StructureDefinition r4_conv = (org.hl7.fhir.r4.model.StructureDefinition) VersionConvertorFactory_40_50.convertResource(r5_actual);
    byte[] r4_output = new org.hl7.fhir.r4.formats.XmlParser().setOutputStyle(org.hl7.fhir.r4.formats.IParser.OutputStyle.PRETTY).composeBytes(r4_conv);

    if (!r4_input.equals(r4_output)) {
      TextFile.bytesToFile(r4_output, Utilities.path("[tmp]", "r4-sd-out.xml"));
      TextFile.bytesToFile(r4_input, Utilities.path("[tmp]", "r4-sd-in.xml"));
    }
    assertArrayEquals(r4_input, r4_output);
  }

  @Nullable
  private byte[] getLineSeparatorNormalizedBytes(String fileName) throws IOException {
    return new String(TextFile.streamToBytes(this.getClass().getResourceAsStream(fileName))).replace(System.lineSeparator(), "\n").getBytes();
  }


  @Test
  @DisplayName("Test r4 -> r5 AuditEvent conversion.")
  public void testR4_R5() throws IOException {
    byte[] r4_input = getLineSeparatorNormalizedBytes("/sd-xpath-constraint-r4.xml");
    byte[] r5_input = getLineSeparatorNormalizedBytes("/sd-xpath-constraint-r5.xml");

    org.hl7.fhir.r4.model.StructureDefinition r4_actual = (org.hl7.fhir.r4.model.StructureDefinition) new org.hl7.fhir.r4.formats.XmlParser().parse(r4_input);
    org.hl7.fhir.r5.model.StructureDefinition r5_conv = (org.hl7.fhir.r5.model.StructureDefinition) VersionConvertorFactory_40_50.convertResource(r4_actual);
    byte[] r5_output = new org.hl7.fhir.r5.formats.XmlParser().setOutputStyle(org.hl7.fhir.r5.formats.IParser.OutputStyle.PRETTY).composeBytes(r5_conv);


    if (!r5_input.equals(r5_output)) {
      TextFile.bytesToFile(r5_output, Utilities.path("[tmp]", "r5-sd-out.xml"));
      TextFile.bytesToFile(r5_input, Utilities.path("[tmp]", "r5-sd-in.xml"));
    }
    assertArrayEquals(r5_input, r5_output);
  }

}
