package org.hl7.fhir.convertors.conv30_40;

import ca.uhn.fhir.context.FhirContext;
import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_30_40;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_30_40;


import org.hl7.fhir.r4.elementmodel.Manager;
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

    InputStream r4_input = this.getClass().getResourceAsStream("/document_reference_30.json");
    InputStream dstu3_expected_output = this.getClass().getResourceAsStream("/document_reference_30_converted_to_40.json");

    org.hl7.fhir.dstu3.model.DocumentReference dstu3_actual = (org.hl7.fhir.dstu3.model.DocumentReference) new org.hl7.fhir.dstu3.formats.JsonParser().parse(r4_input);
    org.hl7.fhir.r4.model.Resource r4_conv = VersionConvertorFactory_30_40.convertResource(dstu3_actual);

    org.hl7.fhir.r4.formats.JsonParser r4_parser = new org.hl7.fhir.r4.formats.JsonParser();
    org.hl7.fhir.r4.model.Resource r4_expected = r4_parser.parse(dstu3_expected_output);

    Assertions.assertTrue(r4_expected.equalsDeep(r4_conv),
      "Failed comparing\n" + r4_parser.composeString(r4_expected) + "\nand\n" + r4_parser.composeString(r4_conv));
  }

  @Test
  void testDocumentReferenceConversion40To30() throws IOException {
    InputStream r4_input = this.getClass().getResourceAsStream("/document_reference_40.json");
    InputStream dstu3_expected_output = this.getClass().getResourceAsStream("/document_reference_40_converted_to_30.json");

    org.hl7.fhir.r4.model.DocumentReference r4_actual = (org.hl7.fhir.r4.model.DocumentReference) new org.hl7.fhir.r4.formats.JsonParser().parse(r4_input);
    org.hl7.fhir.dstu3.model.Resource dstu3_conv = VersionConvertorFactory_30_40.convertResource(r4_actual);

    org.hl7.fhir.dstu3.formats.JsonParser dstu3_parser = new org.hl7.fhir.dstu3.formats.JsonParser();
    org.hl7.fhir.dstu3.model.Resource dstu3_expected = dstu3_parser.parse(dstu3_expected_output);

    Assertions.assertTrue(dstu3_expected.equalsDeep(dstu3_conv),
      "Failed comparing\n" + dstu3_parser.composeString(dstu3_expected) + "\nand\n" + dstu3_parser.composeString(dstu3_conv));
  }
}
