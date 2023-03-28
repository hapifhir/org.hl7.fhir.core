package org.hl7.fhir.r5.test.utils;

import org.hl7.fhir.utilities.npm.BasePackageCacheManager;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;

import java.io.IOException;

public class PackageProvider implements FilesystemPackageCacheManager.IPackageProvider {

  @Override
  public boolean handlesPackage(String id, String version) {
    return id.equals("hl7.fhir.r5.core");
  }

  @Override
  public BasePackageCacheManager.InputStreamWithSrc provide(String id, String version) throws IOException {
    return new BasePackageCacheManager.InputStreamWithSrc(TestingUtilities.loadR5CorePackageSource(), "Test Case Repository", "5.0.0");
  }

}
