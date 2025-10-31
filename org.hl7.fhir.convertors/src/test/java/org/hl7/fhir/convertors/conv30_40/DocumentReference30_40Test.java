package org.hl7.fhir.convertors.conv30_40;

import org.hl7.fhir.convertors.factory.VersionConvertorFactory_30_40;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DocumentReference30_40Test {
  @Test
  void nullDocStatusTest() {
    org.hl7.fhir.r4.model.DocumentReference src = new org.hl7.fhir.r4.model.DocumentReference();
    src.setDocStatus(null);
    src.getDocStatusElement().addExtension("http://example.org/dummy-extension", new org.hl7.fhir.r4.model.BooleanType(true));
    org.hl7.fhir.dstu3.model.DocumentReference tgt = (org.hl7.fhir.dstu3.model.DocumentReference) VersionConvertorFactory_30_40.convertResource(src);
    assertThat(tgt.getDocStatus()).isNull();
    assertThat(tgt.getDocStatusElement().getExtensionString("http://example.org/dummy-extension")).isEqualTo("true");
  }

  @Test
  public void testDocumentReferenceConversion30To40() throws IOException {

    InputStream dstu3InputJson = this.getClass().getResourceAsStream("/document_reference_30.json");
    InputStream r4ExpectedOutputJson = this.getClass().getResourceAsStream("/document_reference_30_converted_to_40.json");

    org.hl7.fhir.dstu3.model.DocumentReference dstu3Input = (org.hl7.fhir.dstu3.model.DocumentReference) new org.hl7.fhir.dstu3.formats.JsonParser().parse(dstu3InputJson);
    org.hl7.fhir.r4.model.Resource r4Converted = VersionConvertorFactory_30_40.convertResource(dstu3Input);

    org.hl7.fhir.r4.formats.JsonParser r4Parser = new org.hl7.fhir.r4.formats.JsonParser();
    org.hl7.fhir.r4.model.Resource r4Expected = r4Parser.parse(r4ExpectedOutputJson);

    Assertions.assertTrue(r4Expected.equalsDeep(r4Converted),
      "Failed comparing\n" + r4Parser.composeString(r4Expected) + "\nand\n" + r4Parser.composeString(r4Converted));
  }

  @Test
  void testDocumentReferenceConversion40To30() throws IOException {
    InputStream r4InputJson = this.getClass().getResourceAsStream("/document_reference_40.json");
    InputStream dstu3ExpectedOutputJson = this.getClass().getResourceAsStream("/document_reference_40_converted_to_30.json");

    org.hl7.fhir.r4.model.DocumentReference r4input = (org.hl7.fhir.r4.model.DocumentReference) new org.hl7.fhir.r4.formats.JsonParser().parse(r4InputJson);
    org.hl7.fhir.dstu3.model.Resource dstu3Converted = VersionConvertorFactory_30_40.convertResource(r4input);

    org.hl7.fhir.dstu3.formats.JsonParser dstu3Parser = new org.hl7.fhir.dstu3.formats.JsonParser();
    org.hl7.fhir.dstu3.model.Resource dstu3Expected = dstu3Parser.parse(dstu3ExpectedOutputJson);

    Assertions.assertTrue(dstu3Expected.equalsDeep(dstu3Converted),
      "Failed comparing\n" + dstu3Parser.composeString(dstu3Expected) + "\nand\n" + dstu3Parser.composeString(dstu3Converted));
  }
}
