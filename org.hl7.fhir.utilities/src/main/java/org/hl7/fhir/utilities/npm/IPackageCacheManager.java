package org.hl7.fhir.utilities.npm;

import java.io.IOException;
import java.io.InputStream;

import org.hl7.fhir.exceptions.FHIRException;

public interface IPackageCacheManager {

  String getPackageId(String canonicalUrl) throws IOException;

  NpmPackage addPackageToCache(String id, String version, InputStream packageTgzInputStream, String sourceDesc) throws IOException;

  String getPackageUrl(String packageId) throws IOException;

  /**
   * Load the package specified by the id and version specified by the parameters.
   * <p/>
   * Depending on the implementation logic, this may be from the package cache, or resolved from another service.
   *
   * @param id The package id
   * @param version The package version. If this is null, the implementation logic will attempt to resolve an
   *                appropriate version based on the package id.
   * @return the NPM Package
   * @throws FHIRException
   * @throws IOException
   */
  NpmPackage loadPackage(String id, String version) throws FHIRException, IOException;
  
  /**
   * Load the package specified by the id and version specified in the idAndVer parameter.
   * <p/>
   * Depending on the implementation logic, this may be from the package cache, or resolved from another service.
   *
   * @param idAndVer - use id#ver
   * @return the NPM Package or
   * @throws FHIRException
   * @throws IOException
   */
  NpmPackage loadPackage(String idAndVer) throws FHIRException, IOException;
}
