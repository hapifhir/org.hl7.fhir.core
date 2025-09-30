package org.hl7.fhir.r5.context;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.PackageInformation;
import org.hl7.fhir.r5.model.Parameters;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;
import org.hl7.fhir.utilities.npm.BasePackageCacheManager;
import org.hl7.fhir.utilities.npm.IPackageCacheManager;
import org.hl7.fhir.utilities.npm.NpmPackage;

import javax.annotation.Nonnull;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;

@MarkedToMoveToAdjunctPackage
public interface IWorkerContextManager {

  interface IPackageLoadingTracker {
    public void packageLoaded(String pid, String version);
  }

  interface ICanonicalResourceLocator {
    void findResource(Object caller, String url); // if it can be found, put it in the context
  }

  public IPackageCacheManager packageManager();

  public void setPackageManager(IPackageCacheManager manager);

  /**
   * Get the expansion parameters passed through the terminology server when txServer calls are made
   *
   * Note that the Validation Options override these when they are specified on validateCode
   */
  public void setExpansionParameters(Parameters expParameters);

  /**
   * Sets the locale for this worker context.
   *
   * @param locale The locale to use.
   * @deprecated Usage of this method is discouraged outside very specific scenarios in testing and the IG publisher.
   * It is preferred to set the locale via the constructor of the implementing class.
   */
  @Deprecated
  void setLocale(Locale locale);

//  @Deprecated
//  void setValidationMessageLanguage(Locale locale);

  /**
   * cache a resource for later retrieval using fetchResource.
   *
   * Note that various context implementations will have their own ways of loading
   * rseources, and not all need implement cacheResource.
   *
   * If the resource is loaded out of a package, call cacheResourceFromPackage instead
   * @param res
   * @throws FHIRException
   */
  public void cacheResource(Resource res) throws FHIRException;


  /**
   * cache a resource for later retrieval using fetchResource.
   *
   * The package information is used to help manage the cache internally, and to
   * help with reference resolution. Packages should be define using cachePackage (but don't have to be)
   *
   * Note that various context implementations will have their own ways of loading
   * rseources, and not all need implement cacheResource
   *
   * @param res
   * @throws FHIRException
   */
  public void cacheResourceFromPackage(Resource res, PackageInformation packageInfo) throws FHIRException;

  /**
   * Inform the cache about package dependencies. This can be used to help resolve references
   *
   * Note that the cache doesn't load dependencies
   *
   * @param packageInfo
   */
  @Deprecated
  public void cachePackage(PackageInformation packageInfo);

  /**
   * Load relevant resources of the appropriate types (as specified by the loader) from the nominated package
   *
   * note that the package system may use lazy loading; the loader will be called later when the classes that use the context need the relevant resource
   *
   * @param pi - the package to load
   * @param loader - an implemenation of IContextResourceLoader that knows how to read the resources in the package (e.g. for the appropriate version).
   * @return the number of resources loaded
   */
  int loadFromPackage(NpmPackage pi, IContextResourceLoader loader) throws FileNotFoundException, IOException, FHIRException;

  /**
   * Load relevant resources of the appropriate types (as specified by the loader) from the nominated package
   *
   * note that the package system may use lazy loading; the loader will be called later when the classes that use the context need the relevant resource
   *
   * @param pi - the package to load
   * @return the number of resources loaded
   */
  int loadPackage(NpmPackage pi) throws FileNotFoundException, IOException, FHIRException;

  /**
   * Load relevant resources of the appropriate types (as specified by the loader) from the nominated package
   *
   * note that the package system may use lazy loading; the loader will be called later when the classes that use the context need the relevant resource
   *
   * @param idAndVer - the package to load
   * @return the number of resources loaded
   */
  int loadPackage(String idAndVer) throws FileNotFoundException, IOException, FHIRException;


  /**
   * Load relevant resources of the appropriate types (as specified by the loader) from the nominated package
   *
   * note that the package system uses lazy loading; the loader will be called later when the classes that use the context need the relevant resource
   *
   * This method also loads all the packages that the package depends on (recursively)
   *
   * @param pi - the package to load
   * @param loader - an implemenation of IContextResourceLoader that knows how to read the resources in the package (e.g. for the appropriate version).
   * @param pcm - used to find and load additional dependencies
   * @return the number of resources loaded
   */
  int loadFromPackageAndDependencies(NpmPackage pi, IContextResourceLoader loader, BasePackageCacheManager pcm) throws FileNotFoundException, IOException, FHIRException;

}
