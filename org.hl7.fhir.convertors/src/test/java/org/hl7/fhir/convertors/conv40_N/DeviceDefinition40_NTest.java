package org.hl7.fhir.convertors.conv40_N;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import org.hl7.fhir.convertors.factory.VersionConvertorFactory_40_N;
import org.junit.jupiter.api.Test;

class DeviceDefinition40_NTest {

  @Test
  void deviceDefinitionInBundleConvertsToUnifiedModelAndBack() {
    org.hl7.fhir.r4.model.DeviceDefinition deviceDefinition = new org.hl7.fhir.r4.model.DeviceDefinition();
    deviceDefinition.setId("device-definition");
    deviceDefinition.setModelNumber("model-123");

    org.hl7.fhir.r4.model.Bundle source = new org.hl7.fhir.r4.model.Bundle();
    source.addEntry().setResource(deviceDefinition);

    org.hl7.fhir.model.core.Bundle unified =
        (org.hl7.fhir.model.core.Bundle) VersionConvertorFactory_40_N.convertResource(source);
    org.hl7.fhir.model.core.DeviceDefinition unifiedDeviceDefinition =
        assertInstanceOf(org.hl7.fhir.model.core.DeviceDefinition.class, unified.getEntryList().get(0).getResource());
    assertEquals("model-123", unifiedDeviceDefinition.getModelNumber());

    org.hl7.fhir.r4.model.Bundle back =
        (org.hl7.fhir.r4.model.Bundle) VersionConvertorFactory_40_N.convertResource(unified);
    org.hl7.fhir.r4.model.DeviceDefinition convertedDeviceDefinition =
        assertInstanceOf(org.hl7.fhir.r4.model.DeviceDefinition.class, back.getEntryFirstRep().getResource());
    assertEquals("model-123", convertedDeviceDefinition.getModelNumber());
  }
}
