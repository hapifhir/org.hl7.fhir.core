package org.hl7.fhir.utilities;

import org.hl7.fhir.utilities.npm.BasePackageCacheManager;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;

import java.io.IOException;

public class UtilitiesPackageProvider  implements FilesystemPackageCacheManager.IPackageProvider {

    @Override
    public boolean handlesPackage(String id, String version) {
      return false;
    }

    @Override
    public BasePackageCacheManager.InputStreamWithSrc provide(String id, String version) throws IOException {
     throw new IOException("This should never be called.");
    }


}
