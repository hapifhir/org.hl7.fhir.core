package org.hl7.fhir.convertors.conv30_40;

import org.hl7.fhir.convertors.factory.VersionConvertorFactory_30_40;


import org.junit.jupiter.api.Test;

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
}
