package org.hl7.fhir.convertors.conv50_N;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import org.hl7.fhir.convertors.factory.VersionConvertorFactory_50_N;
import org.junit.jupiter.api.Test;

class DeviceDefinition50_NTest {

  @Test
  void deviceDefinitionConvertsToUnifiedModelAndBack() {
    org.hl7.fhir.r5.model.DeviceDefinition source = new org.hl7.fhir.r5.model.DeviceDefinition();
    source.setId("device-definition");
    source.setModelNumber("model-123");

    org.hl7.fhir.model.core.DeviceDefinition unified =
        assertInstanceOf(org.hl7.fhir.model.core.DeviceDefinition.class, VersionConvertorFactory_50_N.convertResource(source));
    assertEquals("model-123", unified.getModelNumber());

    org.hl7.fhir.r5.model.DeviceDefinition back =
        assertInstanceOf(org.hl7.fhir.r5.model.DeviceDefinition.class, VersionConvertorFactory_50_N.convertResource(unified));
    assertEquals("model-123", back.getModelNumber());
  }
}
