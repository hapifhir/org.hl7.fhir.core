package org.hl7.fhir.validation;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.hl7.fhir.convertors.factory.VersionConvertorFactory_10_50;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_14_50;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_30_50;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_40_50;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_43_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.context.IWorkerContext.IContextResourceLoader;
import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.elementmodel.Manager;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.formats.XmlParser;
import org.hl7.fhir.r5.model.Constants;
import org.hl7.fhir.r5.model.ImplementationGuide;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.utils.structuremap.StructureMapUtilities;
import org.hl7.fhir.utilities.IniFile;
import org.hl7.fhir.utilities.SimpleHTTPClient;
import org.hl7.fhir.utilities.SimpleHTTPClient.HTTPResult;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.npm.NpmPackage;
import org.hl7.fhir.utilities.turtle.Turtle;
import org.hl7.fhir.validation.ValidationEngine.IValidationEngineLoader;
import org.hl7.fhir.validation.ValidatorUtils.SourceFile;
import org.hl7.fhir.validation.cli.utils.Common;
import org.hl7.fhir.validation.cli.utils.VersionSourceInformation;

import lombok.Getter;

public class IgLoader implements IValidationEngineLoader {

  private static final String[] IGNORED_EXTENSIONS = {"md", "css", "js", "png", "gif", "jpg", "html", "tgz", "pack", "zip"};
  private static final String[] EXEMPT_FILES = {"spec.internals", "version.info", "schematron.zip", "package.json"};
  private static final int SCAN_HEADER_SIZE = 2048;

  @Getter private final FilesystemPackageCacheManager packageCacheManager;
  @Getter private final SimpleWorkerContext context;
  @Getter private final String version;
  @Getter private final boolean isDebug;

  public IgLoader(FilesystemPackageCacheManager packageCacheManager,
                  SimpleWorkerContext context,
                  String theVersion) {
      this(packageCacheManager, context, theVersion, false);
  }

  public IgLoader(FilesystemPackageCacheManager packageCacheManager,
                  SimpleWorkerContext context,
                  String theVersion,
                  boolean isDebug) {
      this.packageCacheManager = packageCacheManager;
      this.context = context;
      this.version = theVersion;
      this.isDebug = isDebug;
  }

  /**
   *
   * @param igs
   * @param binaries
   * @param src Source of the IG
   *
   * @param recursive
   * @throws IOException
   * @throws FHIRException
   *
   * @see IgLoader#loadIgSource(String, boolean, boolean) loadIgSource for detailed description of the src parameter
   */
  public void loadIg(List<ImplementationGuide> igs,
                     Map<String, byte[]> binaries,
                     String src,
                     boolean recursive) throws IOException, FHIRException {

    final String explicitFhirVersion;
    final String srcPackage;
    if (src.startsWith("[") && src.indexOf(']', 1) > 1) {
      explicitFhirVersion = src.substring(1,src.indexOf(']', 1));
      srcPackage = src.substring(src.indexOf(']',1) + 1);
      if (!VersionUtilities.isSupportedVersion(explicitFhirVersion)) {
        throw new FHIRException("Unsupported FHIR Version: " + explicitFhirVersion + " valid versions are " + VersionUtilities.listSupportedVersions());
      }
    } else {
      explicitFhirVersion = null;
      srcPackage = src;
    }

    NpmPackage npm = srcPackage.matches(FilesystemPackageCacheManager.PACKAGE_VERSION_REGEX_OPT) && !new File(srcPackage).exists() ? getPackageCacheManager().loadPackage(srcPackage, null) : null;
    if (npm != null) {
      for (String s : npm.dependencies()) {
        if (!getContext().getLoadedPackages().contains(s)) {
          if (!VersionUtilities.isCorePackage(s)) {
            loadIg(igs, binaries, s, false);
          }
        }
      }
      System.out.print("  Load " + srcPackage);
      if (!srcPackage.contains("#")) {
        System.out.print("#" + npm.version());
      }
      IContextResourceLoader loader = ValidatorUtils.loaderForVersion(npm.fhirVersion());
      loader.setPatchUrls(VersionUtilities.isCorePackage(npm.id()));
      int count = getContext().loadFromPackage(npm, loader);
      System.out.println(" - " + count + " resources (" + getContext().clock().milestone() + ")");
    } else {
      System.out.print("  Load " + srcPackage);
      String canonical = null;
      int count = 0;
      Map<String, byte[]> source = loadIgSource(srcPackage, recursive, true);
      String version = Constants.VERSION;
      if (getVersion() != null) {
        version = getVersion();
      }
      if (source.containsKey("version.info")) {
        version = readInfoVersion(source.get("version.info"));
      }
      if (explicitFhirVersion != null) {
        version = explicitFhirVersion;
      }

      for (Map.Entry<String, byte[]> t : source.entrySet()) {
        String fn = t.getKey();
        if (!exemptFile(fn)) {
          Resource r = loadFileWithErrorChecking(version, t, fn);
          if (r != null) {
            count++;
            getContext().cacheResource(r);
            if (r instanceof ImplementationGuide) {
              canonical = ((ImplementationGuide) r).getUrl();
              igs.add((ImplementationGuide) r);
              if (canonical.contains("/ImplementationGuide/")) {
                Resource r2 = r.copy();
                ((ImplementationGuide) r2).setUrl(canonical.substring(0, canonical.indexOf("/ImplementationGuide/")));
                getContext().cacheResource(r2);
              }
            }
          }
        }
      }
      if (canonical != null) {
        ValidatorUtils.grabNatives(binaries, source, canonical);
      }
      System.out.println(" - " + count + " resources (" + getContext().clock().milestone() + ")");
    }
  }

  /**
   *
   * @param source
   * @param opName
   * @param asIg
   * @return
   * @throws FHIRException
   * @throws IOException
   *
   *    * @see IgLoader#loadIgSource(String, boolean, boolean) loadIgSource for detailed description of the src parameter
   */

  public Content loadContent(String source, String opName, boolean asIg, boolean mustLoad) throws FHIRException, IOException {
    Map<String, byte[]> s = loadIgSource(source, false, asIg);
    Content res = new Content();
    if (!mustLoad && s.size() == 0) {
      return null;
    }
    if (s.size() != 1)
      throw new FHIRException("Unable to find resource " + source + " to " + opName);
    for (Map.Entry<String, byte[]> t : s.entrySet()) {
      res.setFocus(t.getValue());
      if (t.getKey().endsWith(".json"))
        res.setCntType(Manager.FhirFormat.JSON);
      else if (t.getKey().endsWith(".xml"))
        res.setCntType(Manager.FhirFormat.XML);
      else if (t.getKey().endsWith(".ttl"))
        res.setCntType(Manager.FhirFormat.TURTLE);
      else if (t.getKey().endsWith(".shc"))
        res.setCntType(Manager.FhirFormat.SHC);
      else if (t.getKey().endsWith(".txt"))
        res.setCntType(Manager.FhirFormat.TEXT);
      else if (t.getKey().endsWith(".fml") || t.getKey().endsWith(".map"))
        res.setCntType(Manager.FhirFormat.FML);
      else
        throw new FHIRException("Todo: Determining resource type is not yet done");
    }
    return res;
  }

  /**
   *
   * @param src can be one of the following:
   *      <br> - a canonical url for an ig - this will be converted to a package id and loaded into the cache
   *      <br> - a package id for an ig - this will be loaded into the cache
   *      <br> - a direct reference to a package ("package.tgz") - this will be extracted by the cache manager, but not put in the cache
   *      <br> - a folder containing resources - these will be loaded directly
   * @param recursive if true and src resolves to a folder, recursively find and load IgSources from that directory
   * @param explore should be true if we're trying to load an -ig parameter, and false if we're loading source
   *
   * @return
   * @throws FHIRException
   * @throws IOException
   */
  public Map<String, byte[]> loadIgSource(String src,
                                          boolean recursive,
                                          boolean explore) throws FHIRException, IOException {
    //
    if (Common.isNetworkPath(src)) {
      String v = null;
      if (src.contains("|")) {
        v = src.substring(src.indexOf("|") + 1);
        src = src.substring(0, src.indexOf("|"));
      }
      String pid = explore ? getPackageCacheManager().getPackageId(src) : null;
      if (!Utilities.noString(pid))
        return fetchByPackage(pid + (v == null ? "" : "#" + v), false);
      else
        return fetchFromUrl(src + (v == null ? "" : "|" + v), explore);
    }

    File f = new File(Utilities.path(src));
    if (f.exists()) {
      if (f.isDirectory() && new File(Utilities.path(src, "package.tgz")).exists()) {
        FileInputStream stream = new FileInputStream(Utilities.path(src, "package.tgz"));
        try {
          return loadPackage(stream, Utilities.path(src, "package.tgz"), false);
        } finally {
          stream.close();
        }
      }
      if (f.isDirectory() && new File(Utilities.path(src, "igpack.zip")).exists()) {
        FileInputStream stream = new FileInputStream(Utilities.path(src, "igpack.zip"));
        try {
          return readZip(stream);
        } finally {
          stream.close();
        }
      }
      if (f.isDirectory() && new File(Utilities.path(src, "validator.pack")).exists()) {
        FileInputStream stream = new FileInputStream(Utilities.path(src, "validator.pack"));
        try {
          return readZip(stream);
        } finally {
          stream.close();
        }
      }
      if (f.isDirectory()) {
        return scanDirectory(f, recursive);
      }
      FileInputStream stream = new FileInputStream(src);
      try {
        if (src.endsWith(".tgz")) {
          Map<String, byte[]> res = loadPackage(stream, src, false);
          return res;
        }
        if (src.endsWith(".pack")) {
          return readZip(stream);
        }
        if (src.endsWith("igpack.zip")) {
          return readZip(stream);
        }
      } finally {
        stream.close();
      }

      Manager.FhirFormat fmt = ResourceChecker.checkIsResource(getContext(), isDebug(), TextFile.fileToBytes(f), src, true);
      if (fmt != null) {
        Map<String, byte[]> res = new HashMap<String, byte[]>();
        res.put(Utilities.changeFileExt(src, "." + fmt.getExtension()), TextFile.fileToBytesNCS(src));
        return res;
      }
    } else if ((src.matches(FilesystemPackageCacheManager.PACKAGE_REGEX) || src.matches(FilesystemPackageCacheManager.PACKAGE_VERSION_REGEX)) && !src.endsWith(".zip") && !src.endsWith(".tgz")) {
      return fetchByPackage(src, false);
    }
    throw new FHIRException("Unable to find/resolve/read " + (explore ? "-ig " : "") + src);
  }

  public void scanForIgVersion(String src,
                               boolean recursive,
                               VersionSourceInformation versions) throws Exception {
    Map<String, byte[]> source = loadIgSourceForVersion(src, recursive, true, versions);
    if (source != null) {
      if (source.containsKey("version.info")) {
        versions.see(readInfoVersion(source.get("version.info")), "version.info in " + src);
      } else if (source.size() == 1) {
        for (byte[] v : source.values()) {
          scanForFhirVersion(versions, src, v);
        }
      }
    }
  }

  public void scanForVersions(List<String> sources, VersionSourceInformation versions) throws FHIRException, IOException {
    List<SourceFile> refs = new ArrayList<>();
    ValidatorUtils.parseSources(sources, refs, context);
    for (SourceFile ref : refs) {
      Content cnt = loadContent(ref.getRef(), "validate", false, true);      
      scanForFhirVersion(versions, ref.getRef(), cnt.getFocus());
    }
  }

  private void scanForFhirVersion(VersionSourceInformation versions, String ref, byte[] cnt) throws IOException {
    String s = TextFile.bytesToString(cnt.length > SCAN_HEADER_SIZE ? Arrays.copyOfRange(cnt, 0, SCAN_HEADER_SIZE) : cnt).trim();
    try {
      int i = s.indexOf("fhirVersion");
      if (i > 1) {
        boolean xml = s.charAt(i) == '<';
        i = find(s, i, '"');
        if (!xml) {
          i = find(s, i+1, '"');          
        }
        if (i > 0) {
          int j = find(s, i+1, '"');
          if (j > 0) {
            String v = s.substring(i+1, j);
            if (VersionUtilities.isSemVer(v)) {
              versions.see(VersionUtilities.getMajMin(v), "fhirVersion in " + ref);
              return;
            }
          }
        }
        i = find(s, i, '\'');
        if (!xml) {
          i = find(s, i+1, '\'');          
        }
        if (i > 0) {
          int j = find(s, i+1, '\'');
          if (j > 0) {
            String v = s.substring(i, j);
            if (VersionUtilities.isSemVer(v)) {
              versions.see(VersionUtilities.getMajMin(v), "fhirVersion in " + ref);
              return;
            }
          }
        }
      }
    } catch (Exception e) {
      // nothing
    }
    if (s.contains("http://hl7.org/fhir/3.0")) {
      versions.see("3.0", "Profile in " + ref);
      return;
    }
    if (s.contains("http://hl7.org/fhir/1.0")) {
      versions.see("1.0", "Profile in " + ref);
      return;
    }
    if (s.contains("http://hl7.org/fhir/4.0")) {
      versions.see("4.0", "Profile in " + ref);
      return;
    }
    if (s.contains("http://hl7.org/fhir/1.4")) {
      versions.see("1.4", "Profile in " + ref);
      return;
    }
  }

  private int find(String s, int i, char c) {
    while (i < s.length() && s.charAt(i) != c) {
      i++;
    }
    return i == s.length() ? -1 : i;
  }

  protected Map<String, byte[]> readZip(InputStream stream) throws IOException {
    Map<String, byte[]> res = new HashMap<>();
    ZipInputStream zip = new ZipInputStream(stream);
    ZipEntry zipEntry;
    while ((zipEntry = zip.getNextEntry()) != null) {
      String entryName = zipEntry.getName();
      if (entryName.contains("..") || Path.of(entryName).isAbsolute()) {
        throw new RuntimeException("Entry with an illegal path: " + entryName);
      }
      ByteArrayOutputStream b = new ByteArrayOutputStream();
      int n;
      byte[] buf = new byte[1024];
      while ((n = ((InputStream) zip).read(buf, 0, 1024)) > -1) {
        b.write(buf, 0, n);
      }
      res.put(entryName, b.toByteArray());
      zip.closeEntry();
    }
    zip.close();
    return res;
  }

  private String loadPackageForVersion(InputStream stream) throws FHIRException, IOException {
    return NpmPackage.fromPackage(stream).fhirVersion();
  }

  private InputStream fetchFromUrlSpecific(String source, boolean optional) throws FHIRException, IOException {
    try {
      SimpleHTTPClient http = new SimpleHTTPClient();
      HTTPResult res = http.get(source + "?nocache=" + System.currentTimeMillis());
      res.checkThrowException();
      return new ByteArrayInputStream(res.getContent());
    } catch (IOException e) {
      if (optional)
        return null;
      else
        throw e;
    }
  }

  private Map<String, byte[]> loadIgSourceForVersion(String src,
                                                     boolean recursive,
                                                     boolean explore,
                                                     VersionSourceInformation versions) throws FHIRException, IOException {
    if (Common.isNetworkPath(src)) {
      String v = null;
      if (src.contains("|")) {
        v = src.substring(src.indexOf("|") + 1);
        src = src.substring(0, src.indexOf("|"));
      }
      String pid = getPackageCacheManager().getPackageId(src);
      if (!Utilities.noString(pid)) {
        versions.see(fetchVersionByPackage(pid + (v == null ? "" : "#" + v)), "Package " + src);
        return null;
      } else {
        return fetchVersionFromUrl(src + (v == null ? "" : "|" + v), explore, versions);
      }
    }

    File f = new File(Utilities.path(src));
    if (f.exists()) {
      if (f.isDirectory() && new File(Utilities.path(src, "package.tgz")).exists()) {
        versions.see(loadPackageForVersion(new FileInputStream(Utilities.path(src, "package.tgz"))), "Package " + src);
        return null;
      }
      if (f.isDirectory() && new File(Utilities.path(src, "igpack.zip")).exists())
        return readZip(new FileInputStream(Utilities.path(src, "igpack.zip")));
      if (f.isDirectory() && new File(Utilities.path(src, "validator.pack")).exists())
        return readZip(new FileInputStream(Utilities.path(src, "validator.pack")));
      if (f.isDirectory())
        return scanDirectory(f, recursive);
      if (src.endsWith(".tgz")) {
        versions.see(loadPackageForVersion(new FileInputStream(src)), "Package " + src);
        return null;
      }
      if (src.endsWith(".pack"))
        return readZip(new FileInputStream(src));
      if (src.endsWith("igpack.zip"))
        return readZip(new FileInputStream(src));
      Manager.FhirFormat fmt = ResourceChecker.checkIsResource(getContext(), isDebug(), TextFile.fileToBytes(f), src, true);
      if (fmt != null) {
        Map<String, byte[]> res = new HashMap<String, byte[]>();
        res.put(Utilities.changeFileExt(src, "." + fmt.getExtension()), TextFile.fileToBytesNCS(src));
        return res;
      }
    } else if ((src.matches(FilesystemPackageCacheManager.PACKAGE_REGEX) || src.matches(FilesystemPackageCacheManager.PACKAGE_VERSION_REGEX)) && !src.endsWith(".zip") && !src.endsWith(".tgz")) {
      versions.see(fetchVersionByPackage(src), "Package " + src);
      return null;
    }
    throw new FHIRException("Unable to find/resolve/read -ig " + src);
  }


  private Map<String, byte[]> fetchByPackage(String src, boolean loadInContext) throws FHIRException, IOException {
    String id = src;
    String version = null;
    if (src.contains("#")) {
      id = src.substring(0, src.indexOf("#"));
      version = src.substring(src.indexOf("#") + 1);
    }
    if (version == null) {
      version = getPackageCacheManager().getLatestVersion(id);
    }
    NpmPackage pi;
    if (version == null) {
      pi = getPackageCacheManager().loadPackageFromCacheOnly(id);
      if (pi != null)
        System.out.println("   ... Using version " + pi.version());
    } else
      pi = getPackageCacheManager().loadPackageFromCacheOnly(id, version);
    if (pi == null) {
      return resolvePackage(id, version, loadInContext);
    } else
      return loadPackage(pi, loadInContext);
  }

  private Map<String, byte[]> loadPackage(InputStream stream, String name, boolean loadInContext) throws FHIRException, IOException {
    return loadPackage(NpmPackage.fromPackage(stream), loadInContext);
  }

  public Map<String, byte[]> loadPackage(NpmPackage pi, boolean loadInContext) throws FHIRException, IOException {
    Map<String, byte[]> res = new HashMap<String, byte[]>();
    for (String s : pi.dependencies()) {
      if (s.endsWith(".x") && s.length() > 2) {
        String packageMajorMinor = s.substring(0, s.length() - 2);
        boolean found = false;
        for (int i = 0; i < getContext().getLoadedPackages().size() && !found; ++i) {
          String loadedPackage = getContext().getLoadedPackages().get(i);
          if (loadedPackage.startsWith(packageMajorMinor)) {
            found = true;
          }
        }
        if (found)
          continue;
      }
      if (!getContext().getLoadedPackages().contains(s)) {
        if (!VersionUtilities.isCorePackage(s)) {
          System.out.println("+  .. load IG from " + s);
          res.putAll(fetchByPackage(s, loadInContext));
        }
      }
    }

    if (loadInContext) {
//      getContext().getLoadedPackages().add(pi.name() + "#" + pi.version());
      getContext().loadFromPackage(pi, ValidatorUtils.loaderForVersion(pi.fhirVersion()));
    }
    for (String s : pi.listResources("CodeSystem", "ConceptMap", "ImplementationGuide", "CapabilityStatement", "SearchParameter", "Conformance", "StructureMap", "ValueSet", "StructureDefinition")) {
      res.put(s, TextFile.streamToBytes(pi.load("package", s)));
    }
    String ini = "[FHIR]\r\nversion=" + pi.fhirVersion() + "\r\n";
    res.put("version.info", ini.getBytes());
    return res;
  }

  private Map<String, byte[]> resolvePackage(String id, String v, boolean loadInContext) throws FHIRException, IOException {
    NpmPackage pi = getPackageCacheManager().loadPackage(id, v);
    if (pi != null && v == null)
      System.out.println("   ... Using version " + pi.version());
    return loadPackage(pi,  loadInContext);
  }

  private String readInfoVersion(byte[] bs) throws IOException {
    String is = TextFile.bytesToString(bs);
    is = is.trim();
    IniFile ini = new IniFile(new ByteArrayInputStream(TextFile.stringToBytes(is, false)));
    return ini.getStringProperty("FHIR", "version");
  }

  private byte[] fetchFromUrlSpecific(String source, String contentType, boolean optional, List<String> errors) throws FHIRException, IOException {
    try {
      SimpleHTTPClient http = new SimpleHTTPClient();
      try {
        // try with cache-busting option and then try withhout in case the server doesn't support that
        HTTPResult res = http.get(source + "?nocache=" + System.currentTimeMillis(), contentType);
        res.checkThrowException();
        return res.getContent();
      } catch (Exception e) {
        HTTPResult res = http.get(source, contentType);
        res.checkThrowException();
        return res.getContent();
      }
    } catch (IOException e) {
      if (errors != null) {
        errors.add("Error accessing " + source + ": " + e.getMessage());
      }
      if (optional)
        return null;
      else
        throw e;
    }
  }

  private Map<String, byte[]> fetchVersionFromUrl(String src,
                                                  boolean explore,
                                                  VersionSourceInformation versions) throws FHIRException, IOException {
    if (src.endsWith(".tgz")) {
      versions.see(loadPackageForVersion(fetchFromUrlSpecific(src, false)), "From Package " + src);
      return null;
    }
    if (src.endsWith(".pack"))
      return readZip(fetchFromUrlSpecific(src, false));
    if (src.endsWith("igpack.zip"))
      return readZip(fetchFromUrlSpecific(src, false));

    InputStream stream = null;
    if (explore) {
      stream = fetchFromUrlSpecific(Utilities.pathURL(src, "package.tgz"), true);
      if (stream != null) {
        versions.see(loadPackageForVersion(stream), "From Package at " + src);
        return null;
      }
      // todo: these options are deprecated - remove once all IGs have been rebuilt post R4 technical correction
      stream = fetchFromUrlSpecific(Utilities.pathURL(src, "igpack.zip"), true);
      if (stream != null)
        return readZip(stream);
      stream = fetchFromUrlSpecific(Utilities.pathURL(src, "validator.pack"), true);
      if (stream != null)
        return readZip(stream);
      stream = fetchFromUrlSpecific(Utilities.pathURL(src, "validator.pack"), true);
      //// -----
    }

    // ok, having tried all that... now we'll just try to access it directly
    byte[] cnt;
    if (stream == null)
      cnt = fetchFromUrlSpecific(src, "application/json", true, null);
    else
      cnt = TextFile.streamToBytes(stream);

    Manager.FhirFormat fmt = ResourceChecker.checkIsResource(getContext(), isDebug(), cnt, src, true);
    if (fmt != null) {
      Map<String, byte[]> res = new HashMap<String, byte[]>();
      res.put(Utilities.changeFileExt(src, "." + fmt.getExtension()), cnt);
      return res;
    }
    String fn = Utilities.path("[tmp]", "fetch-resource-error-content.bin");
    TextFile.bytesToFile(cnt, fn);
    System.out.println("Error Fetching " + src);
    System.out.println("Some content was found, saved to " + fn);
    System.out.println("1st 100 bytes = " + presentForDebugging(cnt));
    throw new FHIRException("Unable to find/resolve/read " + (explore ? "-ig " : "") + src);
  }

  private String fetchVersionByPackage(String src) throws FHIRException, IOException {
    String id = src;
    String version = null;
    if (src.contains("#")) {
      id = src.substring(0, src.indexOf("#"));
      version = src.substring(src.indexOf("#") + 1);
    }
    if (version == null) {
      version = getPackageCacheManager().getLatestVersion(id);
    }
    NpmPackage pi = null;
    if (version == null) {
      pi = getPackageCacheManager().loadPackageFromCacheOnly(id);
      if (pi != null)
        System.out.println("   ... Using version " + pi.version());
    } else
      pi = getPackageCacheManager().loadPackageFromCacheOnly(id, version);
    if (pi == null) {
      return resolvePackageForVersion(id, version);
    } else {
      return pi.fhirVersion();
    }
  }

  private Map<String, byte[]> fetchFromUrl(String src, boolean explore) throws FHIRException, IOException {
    if (src.endsWith(".tgz"))
      return loadPackage(fetchFromUrlSpecific(src, false), src, false);
    if (src.endsWith(".pack"))
      return readZip(fetchFromUrlSpecific(src, false));
    if (src.endsWith("igpack.zip"))
      return readZip(fetchFromUrlSpecific(src, false));

    InputStream stream = null;
    if (explore) {
      stream = fetchFromUrlSpecific(Utilities.pathURL(src, "package.tgz"), true);
      if (stream != null)
        return loadPackage(stream, Utilities.pathURL(src, "package.tgz"), false);
      // todo: these options are deprecated - remove once all IGs have been rebuilt post R4 technical correction
      stream = fetchFromUrlSpecific(Utilities.pathURL(src, "igpack.zip"), true);
      if (stream != null)
        return readZip(stream);
      stream = fetchFromUrlSpecific(Utilities.pathURL(src, "validator.pack"), true);
      if (stream != null)
        return readZip(stream);
      stream = fetchFromUrlSpecific(Utilities.pathURL(src, "validator.pack"), true);
      //// -----
    }

    // ok, having tried all that... now we'll just try to access it directly
    byte[] cnt;
    List<String> errors = new ArrayList<>();
    if (stream != null) {
      cnt = TextFile.streamToBytes(stream);
    } else {
      cnt = fetchFromUrlSpecific(src, "application/json", true, errors);
      if (cnt == null) {
        cnt = fetchFromUrlSpecific(src, "application/xml", true, errors);
      }
    }
    if (cnt == null) {
      throw new FHIRException("Unable to fetch content from " + src + " (" + errors.toString() + ")");

    }
    Manager.FhirFormat fmt = checkFormat(cnt, src);
    if (fmt != null) {
      Map<String, byte[]> res = new HashMap<>();
      res.put(Utilities.changeFileExt(src, "." + fmt.getExtension()), cnt);
      return res;
    }
    throw new FHIRException("Unable to read content from " + src + ": cannot determine format");
  }

  private boolean isIgnoreFile(File ff) {
    if (ff.getName().startsWith(".") || ff.getAbsolutePath().contains(".git")) {
      return true;
    }
    return Utilities.existsInList(Utilities.getFileExtension(ff.getName()).toLowerCase(), IGNORED_EXTENSIONS);
  }

  private Map<String, byte[]> scanDirectory(File f, boolean recursive) throws IOException {
    Map<String, byte[]> res = new HashMap<>();
    for (File ff : f.listFiles()) {
      if (ff.isDirectory() && recursive) {
        res.putAll(scanDirectory(ff, true));
      } else if (!ff.isDirectory() && !isIgnoreFile(ff)) {
        Manager.FhirFormat fmt = ResourceChecker.checkIsResource(getContext(), isDebug(), TextFile.fileToBytes(ff), ff.getAbsolutePath(), true);
        if (fmt != null) {
          res.put(Utilities.changeFileExt(ff.getName(), "." + fmt.getExtension()), TextFile.fileToBytes(ff.getAbsolutePath()));
        }
      }
    }
    return res;
  }

  private String resolvePackageForVersion(String id, String v) throws FHIRException, IOException {
    NpmPackage pi = getPackageCacheManager().loadPackage(id, v);
    return pi.fhirVersion();
  }

  private String presentForDebugging(byte[] cnt) {
    StringBuilder b = new StringBuilder();
    for (int i = 0; i < Integer.min(cnt.length, 50); i++) {
      b.append(Integer.toHexString(cnt[i]));
    }
    return b.toString();
  }

  private Manager.FhirFormat checkFormat(byte[] cnt, String filename) {
    System.out.println("   ..Detect format for " + filename);
    try {
      org.hl7.fhir.utilities.json.parser.JsonParser.parseObject(cnt);
      return Manager.FhirFormat.JSON;
    } catch (Exception e) {
      log("Not JSON: " + e.getMessage());
    }
    try {
      ValidatorUtils.parseXml(cnt);
      return Manager.FhirFormat.XML;
    } catch (Exception e) {
      log("Not XML: " + e.getMessage());
    }
    try {
      new Turtle().parse(TextFile.bytesToString(cnt));
      return Manager.FhirFormat.TURTLE;
    } catch (Exception e) {
      log("Not Turtle: " + e.getMessage());
    }
    try {
      new StructureMapUtilities(getContext(), null, null).parse(TextFile.bytesToString(cnt), null);
      return Manager.FhirFormat.TEXT;
    } catch (Exception e) {
      log("Not Text: " + e.getMessage());
    }
    log("     .. not a resource: " + filename);
    return null;
  }

  private boolean exemptFile(String fn) {
    return Utilities.existsInList(fn, EXEMPT_FILES);
  }

  protected Resource loadFileWithErrorChecking(String version, Map.Entry<String, byte[]> t, String fn) {
    log("* load file: " + fn);
    Resource r = null;
    try {
      r = loadResourceByVersion(version, t.getValue(), fn);
      log(" .. success");
    } catch (Exception e) {
      if (!isDebug()) {
        System.out.print("* load file: " + fn);
      }
      System.out.println(" - ignored due to error: " + (e.getMessage() == null ? " (null - NPE)" : e.getMessage()));
      if (isDebug() || ((e.getMessage() != null && e.getMessage().contains("cannot be cast")))) {
        e.printStackTrace();
      }
      e.printStackTrace();
    }
    return r;
  }

  public Resource loadResourceByVersion(String fhirVersion, byte[] content, String fn) throws IOException, FHIRException {
    Resource r;
    if (fhirVersion.startsWith("3.0")) {
      org.hl7.fhir.dstu3.model.Resource res;
      if (fn.endsWith(".xml") && !fn.endsWith("template.xml"))
        res = new org.hl7.fhir.dstu3.formats.XmlParser().parse(new ByteArrayInputStream(content));
      else if (fn.endsWith(".json") && !fn.endsWith("template.json"))
        res = new org.hl7.fhir.dstu3.formats.JsonParser().parse(new ByteArrayInputStream(content));
      else if (fn.endsWith(".txt") || fn.endsWith(".map")  || fn.endsWith(".fml"))
        res = new org.hl7.fhir.dstu3.utils.StructureMapUtilities(org.hl7.fhir.dstu3.context.SimpleWorkerContext.fromNothing()).parse(new String(content));
      else
        throw new FHIRException("Unsupported format for " + fn);
      r = VersionConvertorFactory_30_50.convertResource(res);
    } else if (fhirVersion.startsWith("4.0")) {
      org.hl7.fhir.r4.model.Resource res;
      if (fn.endsWith(".xml") && !fn.endsWith("template.xml"))
        res = new org.hl7.fhir.r4.formats.XmlParser().parse(new ByteArrayInputStream(content));
      else if (fn.endsWith(".json") && !fn.endsWith("template.json"))
        res = new org.hl7.fhir.r4.formats.JsonParser().parse(new ByteArrayInputStream(content));
      else if (fn.endsWith(".txt") || fn.endsWith(".map")  || fn.endsWith(".fml"))
        res = new org.hl7.fhir.r4.utils.StructureMapUtilities(org.hl7.fhir.r4.context.SimpleWorkerContext.fromNothing()).parse(new String(content), fn);
      else
        throw new FHIRException("Unsupported format for " + fn);
      r = VersionConvertorFactory_40_50.convertResource(res);
    } else if (fhirVersion.startsWith("4.3")) {
      org.hl7.fhir.r4b.model.Resource res;
      if (fn.endsWith(".xml") && !fn.endsWith("template.xml"))
        res = new org.hl7.fhir.r4b.formats.XmlParser().parse(new ByteArrayInputStream(content));
      else if (fn.endsWith(".json") && !fn.endsWith("template.json"))
        res = new org.hl7.fhir.r4b.formats.JsonParser().parse(new ByteArrayInputStream(content));
      else if (fn.endsWith(".txt") || fn.endsWith(".map")  || fn.endsWith(".fml"))
        res = new org.hl7.fhir.r4b.utils.structuremap.StructureMapUtilities(org.hl7.fhir.r4b.context.SimpleWorkerContext.fromNothing()).parse(new String(content), fn);
      else
        throw new FHIRException("Unsupported format for " + fn);
      r = VersionConvertorFactory_43_50.convertResource(res);
    } else if (fhirVersion.startsWith("1.4")) {
      org.hl7.fhir.dstu2016may.model.Resource res;
      if (fn.endsWith(".xml") && !fn.endsWith("template.xml"))
        res = new org.hl7.fhir.dstu2016may.formats.XmlParser().parse(new ByteArrayInputStream(content));
      else if (fn.endsWith(".json") && !fn.endsWith("template.json"))
        res = new org.hl7.fhir.dstu2016may.formats.JsonParser().parse(new ByteArrayInputStream(content));
      else
        throw new FHIRException("Unsupported format for " + fn);
      r = VersionConvertorFactory_14_50.convertResource(res);
    } else if (fhirVersion.startsWith("1.0")) {
      org.hl7.fhir.dstu2.model.Resource res;
      if (fn.endsWith(".xml") && !fn.endsWith("template.xml"))
        res = new org.hl7.fhir.dstu2.formats.JsonParser().parse(new ByteArrayInputStream(content));
      else if (fn.endsWith(".json") && !fn.endsWith("template.json"))
        res = new org.hl7.fhir.dstu2.formats.JsonParser().parse(new ByteArrayInputStream(content));
      else
        throw new FHIRException("Unsupported format for " + fn);
      r = VersionConvertorFactory_10_50.convertResource(res, new org.hl7.fhir.convertors.misc.IGR2ConvertorAdvisor5());
    } else if (fhirVersion.startsWith("5.0")) {
      if (fn.endsWith(".xml") && !fn.endsWith("template.xml"))
        r = new XmlParser().parse(new ByteArrayInputStream(content));
      else if (fn.endsWith(".json") && !fn.endsWith("template.json"))
        r = new JsonParser().parse(new ByteArrayInputStream(content));
      else if (fn.endsWith(".txt"))
        r = new StructureMapUtilities(getContext(), null, null).parse(TextFile.bytesToString(content), fn);
      else if (fn.endsWith(".map") || fn.endsWith(".fml"))
        r = new StructureMapUtilities(context).parse(new String(content), fn);
      else
        throw new FHIRException("Unsupported format for " + fn);
    } else
      throw new FHIRException("Unsupported version " + fhirVersion);
    return r;
  }

  private void log(String s) {
    if (isDebug()) System.out.println(s);
  }

  @Override
  public void load(Content cnt) throws FHIRException, IOException {
    Resource res = loadResourceByVersion(version, cnt.getFocus(), cnt.getExampleFileName());
    context.cacheResource(res);
  }
}
