package org.hl7.fhir.services.utilities;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.services.context.IWorkerContext;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.utilities.npm.BasePackageCacheManager.InputStreamWithSrc;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager.IPackageProvider;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.hl7.fhir.utilities.tests.BaseTestingUtilities;
import org.hl7.fhir.utilities.tests.TestConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.Map;

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

  static public Map<String, IWorkerContext> sharedContexts;

  final static public String DEFAULT_CONTEXT_VERSION = "5.0.0";

  public static NpmPackage loadR5CorePackage() throws IOException {
    return NpmPackage.fromPackage(loadR5CorePackageSource());
  }

  private static InputStream loadR5CorePackageSource() throws IOException {
    return TestingUtilities.loadTestResourceStream("r5", "packages", "hl7.fhir.r5.core.tgz");
  }

  public static String getTerminologyCacheDirectory() {
    return TestConfig.getInstance().getTxCacheDirectory("org.hl7.fhir.context");
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
    FilesystemPackageCacheManager.setPackageProvider(new PackageProvider());
  }

  public static boolean runningAsSurefire() {
    return "true".equals(System.getProperty("runningAsSurefire") != null ? System.getProperty("runningAsSurefire").toLowerCase(Locale.ENGLISH) : "");
  }
}