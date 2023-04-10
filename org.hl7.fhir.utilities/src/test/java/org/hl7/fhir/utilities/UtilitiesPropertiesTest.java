package org.hl7.fhir.utilities;

import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class UtilitiesPropertiesTest {

  @Test
    public void test() throws ClassNotFoundException {
  String className = new UtilitiesPropertiesImpl().getIPackageProviderClassName();

    assertEquals("org.hl7.fhir.utilities.UtilitiesPackageProvider", className);
  }

}