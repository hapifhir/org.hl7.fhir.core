package org.hl7.fhir.r5.test.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import org.fhir.ucum.UcumEssenceService;
import org.hl7.fhir.r5.Constants;
import org.hl7.fhir.r5.context.IContextResourceLoader;
import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.model.Parameters;
import org.hl7.fhir.r5.terminologies.utilities.TerminologyCache;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.utilities.npm.BasePackageCacheManager.InputStreamWithSrc;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager.IPackageProvider;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.hl7.fhir.utilities.tests.BaseTestingUtilities;
import org.hl7.fhir.utilities.tests.TestConfig;

@Slf4j
public class TestingUtilities extends BaseTestingUtilities {

  public static class PackageProvider implements IPackageProvider {

    @Override
    public boolean handlesPackage(String id, String version) {
      return id.equals("hl7.fhir.r5.core");
    }

    @Override
    public InputStreamWithSrc provide(String id, String version) throws IOException {
      return new InputStreamWithSrc(TestingUtilities.loadR5CorePackageSource(), "Test Case Repository", "5.0.0");
    }

  }

  static public Map<String, SimpleWorkerContext> sharedContexts;

  final static public String DEFAULT_CONTEXT_VERSION = "5.0.0";

  /** Get an existing instantiation of a WorkerContext if available
   *
   * This uses the DEFAULT_CONTEXT_VERSION
   * */
  public static SimpleWorkerContext getSharedWorkerContext() {
    return getSharedWorkerContext(DEFAULT_CONTEXT_VERSION);
  }

  /**
   * Get an existing instantiation of a WorkerContext if available
   *
   * @param fhirVersion FHIR Version to get context for
   * @return
   */
  public static SimpleWorkerContext getSharedWorkerContext(String fhirVersion) {
    if (!Utilities.existsInList(fhirVersion, "1.0.2", "3.0.1", "4.0.1", "4.3.0", "5.0.0")) {
      throw new Error("illegal version: "+fhirVersion);
      
    }
    
    String normalizedVersion = VersionUtilities.getMajMin(fhirVersion);
    if (sharedContexts == null) {
      sharedContexts = new HashMap<>();
    }
    if (!sharedContexts.containsKey(normalizedVersion)) {
      SimpleWorkerContext sharedContext = getWorkerContext(fhirVersion);
        sharedContexts.put(normalizedVersion, sharedContext);
    }
    return sharedContexts.get(normalizedVersion);
  }

  public static SimpleWorkerContext getWorkerContext(String fhirVersion) {

    FilesystemPackageCacheManager pcm;
    try {
      pcm = new FilesystemPackageCacheManager.Builder().build();
      SimpleWorkerContext sharedContext = null;
      if (VersionUtilities.isR5Ver(fhirVersion)) {
        // for purposes of stability, the R5 core package comes from the test case repository
        sharedContext = getWorkerContext(loadR5CorePackage());
      } else {
        sharedContext = getWorkerContext(pcm.loadPackage(VersionUtilities.packageForVersion(fhirVersion), fhirVersion));
      }
      sharedContext.setUcumService(new UcumEssenceService(TestingUtilities.loadTestResourceStream("ucum", "ucum-essence.xml")));
      sharedContext.setExpansionParameters(new Parameters());
      if (!sharedContext.hasPackage("hl7.terminology.r5", null)) {
        NpmPackage utg = pcm.loadPackage("hl7.terminology.r5");
        log.info("Loading THO: "+utg.name()+"#"+utg.version());
        sharedContext.loadFromPackage(utg, new TestPackageLoader(Utilities.stringSet("CodeSystem", "ValueSet", "NamingSystem")));
      } 
      if (!sharedContext.hasPackage("hl7.fhir.uv.extensions", null)) {
        NpmPackage ext = pcm.loadPackage("hl7.fhir.uv.extensions", Constants.EXTENSIONS_WORKING_VERSION);
        log.info("Loading Extensions: "+ext.name()+"#"+ext.version());
        sharedContext.loadFromPackage(ext, new TestPackageLoader(Utilities.stringSet("CodeSystem", "ValueSet", "StructureDefinition")));
      } 
      return sharedContext;
    } catch (Exception e) {
      e.printStackTrace();
      throw new Error(e);
    }
  }

  public static NpmPackage loadR5CorePackage() throws IOException {
    return NpmPackage.fromPackage(loadR5CorePackageSource());
  }

  private static InputStream loadR5CorePackageSource() throws IOException {
    return TestingUtilities.loadTestResourceStream("r5", "packages", "hl7.fhir.r5.core.tgz");
  }

  public static String getTerminologyCacheDirectory() {
    return TestConfig.getInstance().getTxCacheDirectory("org.hl7.fhir.r5");
  }

  public static SimpleWorkerContext getWorkerContext(NpmPackage npmPackage) throws Exception {
    SimpleWorkerContext swc = new SimpleWorkerContext.SimpleWorkerContextBuilder().withAllowLoadingDuplicates(true).withUserAgent(TestConstants.USER_AGENT)
        .withTerminologyCachePath(getTerminologyCacheDirectory()).fromPackage(npmPackage);
    TerminologyCache.setCacheErrors(true);
    return swc;
  }

  public static SimpleWorkerContext getWorkerContext(NpmPackage npmPackage, IContextResourceLoader loader) throws Exception {
    SimpleWorkerContext swc = new SimpleWorkerContext.SimpleWorkerContextBuilder().withAllowLoadingDuplicates(true).withUserAgent(TestConstants.USER_AGENT)
        .withTerminologyCachePath(getTerminologyCacheDirectory()).fromPackage(npmPackage, loader, true);
    TerminologyCache.setCacheErrors(true);
    return swc;
  }

  static public String fixedpath;
  static public String contentpath;

  public static String home() throws IOException {
    if (fixedpath != null)
      return fixedpath;
    String s = System.getenv("FHIR_HOME");
    if (!Utilities.noString(s))
      return s;
    s = "C:\\work\\org.hl7.fhir\\build";
    // #TODO - what should we do with this?
    s = "/Users/jamesagnew/git/fhir";
    if (ManagedFileAccess.file(s).exists())
      return s;
    throw new Error("FHIR Home directory not configured");
  }


  public static String content() throws IOException {
    if (contentpath != null)
      return contentpath;
    String s = "R:\\fhir\\publish";
    if (ManagedFileAccess.file(s).exists())
      return s;
    return Utilities.path(home(), "publish");
  }

  // diretory that contains all the US implementation guides
  public static String us() throws IOException {
    if (fixedpath != null)
      return fixedpath;
    String s = System.getenv("FHIR_HOME");
    if (!Utilities.noString(s))
      return s;
    s = "C:\\work\\org.hl7.fhir.us";
    if (ManagedFileAccess.file(s).exists())
      return s;
    throw new Error("FHIR US directory not configured");
  }

  public static void injectCorePackageLoader() {
    FilesystemPackageCacheManager.setPackageProvider(new TestingUtilities.PackageProvider());    
  }

  public static boolean runningAsSurefire() {
    return "true".equals(System.getProperty("runningAsSurefire") != null ? System.getProperty("runningAsSurefire").toLowerCase(Locale.ENGLISH) : "");
  }
}