package org.hl7.fhir.convertors.conv10_50;

import java.io.IOException;

import org.hl7.fhir.convertors.factory.VersionConvertorFactory_10_50;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Bundle10_50Test {

  @Test
  @DisplayName("Test 10_50 bundle conversion when resource is null")
  public void testNoResourceBundleConversion() throws IOException {
    org.hl7.fhir.r5.model.Bundle.BundleEntryComponent bec = new org.hl7.fhir.r5.model.Bundle.BundleEntryComponent()
      .setRequest(
        new org.hl7.fhir.r5.model.Bundle.BundleEntryRequestComponent()
          .setMethod(org.hl7.fhir.r5.model.Bundle.HTTPVerb.DELETE)
          .setUrl("Patient?identifier=123456")
      );

    org.hl7.fhir.r5.model.Bundle r5Bundle = new org.hl7.fhir.r5.model.Bundle()
      .addEntry(bec);

    org.hl7.fhir.dstu2.model.Resource dstu2Resource = VersionConvertorFactory_10_50.convertResource(r5Bundle);
    Assertions.assertNotNull(dstu2Resource);
    Assertions.assertTrue(dstu2Resource instanceof org.hl7.fhir.dstu2.model.Bundle);

    org.hl7.fhir.dstu2.model.Bundle dstu2Bundle = (org.hl7.fhir.dstu2.model.Bundle) dstu2Resource;
    Assertions.assertEquals(1, dstu2Bundle.getEntry().size());

    Assertions.assertNull(dstu2Bundle.getEntry().get(0).getResource());
  }
}
