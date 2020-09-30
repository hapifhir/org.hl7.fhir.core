package org.hl7.fhir.utilities.npm;

import org.hl7.fhir.exceptions.FHIRException;

import java.io.IOException;
import java.io.InputStream;

public interface IPackageCacheManager {

  String getPackageId(String canonicalUrl) throws IOException;

  NpmPackage addPackageToCache(String id, String version, InputStream packageTgzInputStream, String sourceDesc) throws IOException;

  String getPackageUrl(String packageId) throws IOException;

  NpmPackage loadPackage(String id, String version) throws FHIRException, IOException;
  
  /**
   * 
   * @param idAndVer - use id#ver
   * @return
   * @throws FHIRException
   * @throws IOException
   */
  NpmPackage loadPackage(String idAndVer) throws FHIRException, IOException;
}
