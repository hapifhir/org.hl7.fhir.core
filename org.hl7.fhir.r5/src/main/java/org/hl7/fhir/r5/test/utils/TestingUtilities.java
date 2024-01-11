package org.hl7.fhir.r5.test.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.fhir.ucum.UcumEssenceService;
import org.hl7.fhir.r5.context.IContextResourceLoader;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.model.Parameters;
import org.hl7.fhir.r5.terminologies.utilities.TerminologyCache;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.npm.BasePackageCacheManager.InputStreamWithSrc;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager.IPackageProvider;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.hl7.fhir.utilities.tests.BaseTestingUtilities;
import org.hl7.fhir.utilities.tests.TestConfig;

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

  static public Map<String, IWorkerContext> fcontexts;

  final static public String DEFAULT_CONTEXT_VERSION = "5.0.0";

  /** Get an existing instantiation of a WorkerContext if available
   *
   * This uses the DEFAULT_CONTEXT_VERSION
   * */
  public static IWorkerContext getSharedWorkerContext() {
    return getSharedWorkerContext(DEFAULT_CONTEXT_VERSION);
  }

  /**
   * Get an existing instantiation of a WorkerContext if available
   *
   * @param version FHIR Version to get context for
   * @return
   */
  public static IWorkerContext getSharedWorkerContext(String version) {
    if (!Utilities.existsInList(version, "1.0.2", "3.0.1", "4.0.1", "4.3.0", "5.0.0")) {
      throw new Error("illegal version: "+version);
      
    }
    
    String v = VersionUtilities.getMajMin(version);
    if (fcontexts == null) {
      fcontexts = new HashMap<>();
    }
    if (!fcontexts.containsKey(v)) {
        IWorkerContext fcontext = getWorkerContext(version);
        fcontexts.put(v, fcontext);
    }
    return fcontexts.get(v);
  }

  public static IWorkerContext getWorkerContext(String version) {

    FilesystemPackageCacheManager pcm;
    try {
      pcm = new FilesystemPackageCacheManager.Builder().build();
      IWorkerContext fcontext = null;
      if (VersionUtilities.isR5Ver(version)) {
        // for purposes of stability, the R5 core package comes from the test case repository
        fcontext = getWorkerContext(loadR5CorePackage());
      } else {
        fcontext = getWorkerContext(pcm.loadPackage(VersionUtilities.packageForVersion(version), version));
      }
      fcontext.setUcumService(new UcumEssenceService(TestingUtilities.loadTestResourceStream("ucum", "ucum-essence.xml")));
      fcontext.setExpansionParameters(new Parameters());
      if (!fcontext.hasPackage("hl7.terminology.r5", null)) {
        NpmPackage utg = pcm.loadPackage("hl7.terminology.r5");
        System.out.println("Loading THO: "+utg.name()+"#"+utg.version());
        fcontext.loadFromPackage(utg, new TestPackageLoader(Utilities.strings("CodeSystem", "ValueSet")));
      } 
      if (!fcontext.hasPackage("hl7.fhir.uv.extensions", null)) {
        NpmPackage ext = pcm.loadPackage("hl7.fhir.uv.extensions", "1.0.0");
        System.out.println("Loading Extensions: "+ext.name()+"#"+ext.version());
        fcontext.loadFromPackage(ext, new TestPackageLoader(Utilities.strings("CodeSystem", "ValueSet", "StructureDefinition")));
      } 
      return fcontext;
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

  public static String home() {
    if (fixedpath != null)
      return fixedpath;
    String s = System.getenv("FHIR_HOME");
    if (!Utilities.noString(s))
      return s;
    s = "C:\\work\\org.hl7.fhir\\build";
    // FIXME: change this back
    s = "/Users/jamesagnew/git/fhir";
    if (new File(s).exists())
      return s;
    throw new Error("FHIR Home directory not configured");
  }


  public static String content() throws IOException {
    if (contentpath != null)
      return contentpath;
    String s = "R:\\fhir\\publish";
    if (new File(s).exists())
      return s;
    return Utilities.path(home(), "publish");
  }

  // diretory that contains all the US implementation guides
  public static String us() {
    if (fixedpath != null)
      return fixedpath;
    String s = System.getenv("FHIR_HOME");
    if (!Utilities.noString(s))
      return s;
    s = "C:\\work\\org.hl7.fhir.us";
    if (new File(s).exists())
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