package org.hl7.fhir.utilities.cache;

import org.hl7.fhir.exceptions.FHIRException;

import java.io.IOException;

public interface IPackageCacheManager {


  String getPackageId(String canonical) throws IOException;

  String getPackageUrl(String packageId) throws IOException;

  NpmPackage loadPackage(String id, String version) throws FHIRException, IOException;
}
