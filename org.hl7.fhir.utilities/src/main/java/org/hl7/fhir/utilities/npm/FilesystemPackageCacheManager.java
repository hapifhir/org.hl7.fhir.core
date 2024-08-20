package org.hl7.fhir.utilities.npm;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Nonnull;

import lombok.Getter;
import lombok.With;
import org.apache.commons.io.FileUtils;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.utilities.IniFile;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.utilities.http.HTTPResult;
import org.hl7.fhir.utilities.http.ManagedWebAccess;
import org.hl7.fhir.utilities.json.model.JsonArray;
import org.hl7.fhir.utilities.json.model.JsonElement;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;
import org.hl7.fhir.utilities.npm.PackageList.PackageListEntry;
import org.hl7.fhir.utilities.settings.FhirSettings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.
  
  Redistribution and use in source and binary forms, with or without modification, 
  are permitted provided that the following conditions are met:
    
   * Redistributions of source code must retain the above copyright notice, this 
     list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright notice, 
     this list of conditions and the following disclaimer in the documentation 
     and/or other materials provided with the distribution.
   * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.
  
  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
  POSSIBILITY OF SUCH DAMAGE.
  
 */

/**
 * This is a package cache manager implementation that uses a local disk cache
 *
 * <p>
 * API:
 * <p>
 * constructor
 * getPackageUrl
 * getPackageId
 * findPackageCache
 * addPackageToCache
 *
 * @author Grahame Grieve
 */
public class FilesystemPackageCacheManager extends BasePackageCacheManager implements IPackageCacheManager {

  private final FilesystemPackageCacheManagerLocks locks;

  // When running in testing mode, some packages are provided from the test case repository rather than by the normal means
  // the PackageProvider is responsible for this. if no package provider is defined, or it declines to handle the package, 
  // then the normal means will be used
  public interface IPackageProvider {
    boolean handlesPackage(String id, String version);

    InputStreamWithSrc provide(String id, String version) throws IOException;
  }

  private static IPackageProvider packageProvider;
  public static final String PACKAGE_REGEX = "^[a-zA-Z][A-Za-z0-9\\_\\-]*(\\.[A-Za-z0-9\\_\\-]+)+$";
  public static final String PACKAGE_VERSION_REGEX = "^[A-Za-z][A-Za-z0-9\\_\\-]*(\\.[A-Za-z0-9\\_\\-]+)+\\#[A-Za-z0-9\\-\\_\\$]+(\\.[A-Za-z0-9\\-\\_\\$]+)*$";
  public static final String PACKAGE_VERSION_REGEX_OPT = "^[A-Za-z][A-Za-z0-9\\_\\-]*(\\.[A-Za-z0-9\\_\\-]+)+(\\#[A-Za-z0-9\\-\\_]+(\\.[A-Za-z0-9\\-\\_]+)*)?$";
  private static final Logger ourLog = LoggerFactory.getLogger(FilesystemPackageCacheManager.class);
  private static final String CACHE_VERSION = "3"; // second version - see wiki page
  private final File cacheFolder;

  private final List<NpmPackage> temporaryPackages = new ArrayList<>();
  private boolean buildLoaded = false;
  private final Map<String, String> ciList = new HashMap<>();
  private JsonArray buildInfo;
  private boolean suppressErrors;
  private boolean minimalMemory;

  public static class Builder {

    @Getter
    private final File cacheFolder;

    @With
    @Getter
    private final List<PackageServer> packageServers;

    public Builder() throws IOException {
      this.cacheFolder = getUserCacheFolder();
      this.packageServers = getPackageServersFromFHIRSettings();
    }

    private File getUserCacheFolder() throws IOException {
      return ManagedFileAccess.file(Utilities.path(System.getProperty("user.home"), ".fhir", "packages"));
    }

    private List<PackageServer> getPackageServersFromFHIRSettings() {
      List<PackageServer> packageServers = new ArrayList<>(getConfiguredServers());
      if (!isIgnoreDefaultPackageServers()) {
        packageServers.addAll(getDefaultServers());
      }
      return packageServers;
    }

    protected boolean isIgnoreDefaultPackageServers() {
      return FhirSettings.isIgnoreDefaultPackageServers();
    }

    @Nonnull
    protected List<PackageServer> getDefaultServers() {
      return PackageServer.defaultServers();
    }

    protected List<PackageServer> getConfiguredServers() {
      return PackageServer.getConfiguredServers();
    }

    private Builder(File cacheFolder, List<PackageServer> packageServers) {
      this.cacheFolder = cacheFolder;
      this.packageServers = packageServers;
    }

    public Builder withCacheFolder(String cacheFolderPath) throws IOException {
      File cacheFolder = ManagedFileAccess.file(cacheFolderPath);
      if (!cacheFolder.exists()) {
        throw new FHIRException("The folder '" + cacheFolder + "' could not be found");
      }
      return new Builder(cacheFolder, this.packageServers);
    }

    public Builder withSystemCacheFolder() throws IOException {
      final File systemCacheFolder;
      if (Utilities.isWindows()) {
        systemCacheFolder = ManagedFileAccess.file(Utilities.path(System.getenv("ProgramData"), ".fhir", "packages"));
      } else {
        systemCacheFolder = ManagedFileAccess.file(Utilities.path("/var", "lib", ".fhir", "packages"));
      }
      return new Builder(systemCacheFolder, this.packageServers);
    }

    public Builder withTestingCacheFolder() throws IOException {
      return new Builder(ManagedFileAccess.file(Utilities.path("[tmp]", ".fhir", "packages")), this.packageServers);
    }

    public FilesystemPackageCacheManager build() throws IOException {
      return new FilesystemPackageCacheManager(cacheFolder, packageServers);
    }
  }

  private FilesystemPackageCacheManager(@Nonnull File cacheFolder, @Nonnull List<PackageServer> packageServers) throws IOException {
    super(packageServers);
    this.cacheFolder = cacheFolder;

    try {
      this.locks = FilesystemPackageCacheManagerLocks.getFilesystemPackageCacheManagerLocks(cacheFolder);
    } catch (RuntimeException e) {
      if (e.getCause() instanceof IOException) {
        throw (IOException) e.getCause();
      } else {
        throw e;
      }
    }

    prepareCacheFolder();
  }

  /**
   * Check if the cache folder exists and is valid.
   * <p>
   * If it doesn't exist, create it.
   * <p>
   * If it does exist and isn't valid, delete it and create a new one.
   * <p>
   * If it does exist and is valid, just do some cleanup (temp directories, etc) and we're good to go.
   *
   * @throws IOException
   */
  protected void prepareCacheFolder() throws IOException {
    locks.getCacheLock().doWriteWithLock(() -> {
      System.out.println(">>> prepareCacheFolder"+ " Thread: " + Thread.currentThread().getId());

      if (!(cacheFolder.exists())) {
        System.out.println(">>> cache folder does not exist. Creating." + " Thread: " + Thread.currentThread().getId());
        Utilities.createDirectory(cacheFolder.getAbsolutePath());
        createIniFile();
      } else {
        if (!isCacheFolderValid()) {
          System.out.println(">>> cache folder is not valid. Clearing and recreating."+ " Thread: " + Thread.currentThread().getId());
          clearCache();
          createIniFile();
          System.out.println(">>> cache folder recreated."+ " Thread: " + Thread.currentThread().getId());
        } else {
          System.out.println(">>> cache folder is valid. deleting old temp."+ " Thread: " + Thread.currentThread().getId());
          deleteOldTempDirectories();
          System.out.println(">>> old temps deleted."+ " Thread: " + Thread.currentThread().getId());
        }
      }
      return null;
    });
  }

  private boolean isCacheFolderValid() throws IOException {
    String iniPath = getPackagesIniPath();
    File iniFile = ManagedFileAccess.file(iniPath);
    if (!(iniFile.exists())) {
      return false;
    }
    IniFile ini = new IniFile(iniPath);
    String v = ini.getStringProperty("cache", "version");
    if (!CACHE_VERSION.equals(v)) {
      return false;
    }
    return true;
  }

  private void deleteOldTempDirectories() throws IOException {
    for (File f : cacheFolder.listFiles()) {
      if (f.isDirectory() && Utilities.isValidUUID(f.getName())) {
        System.out.println(">>> clear temp directory : " + f.getAbsolutePath() + " Thread: " + Thread.currentThread().getId());
        Utilities.clearDirectory(f.getAbsolutePath());
        f.delete();
      }
    }
  }


  private void initPackageServers() {
    myPackageServers.addAll(getConfiguredServers());
    if (!isIgnoreDefaultPackageServers()) {
      myPackageServers.addAll(getDefaultServers());
    }
  }

  protected boolean isIgnoreDefaultPackageServers() {
    return FhirSettings.isIgnoreDefaultPackageServers();
  }

  @Nonnull
  protected List<PackageServer> getDefaultServers() {
    return PackageServer.defaultServers();
  }

  protected List<PackageServer> getConfiguredServers() {
    return PackageServer.getConfiguredServers();
  }

  public boolean isMinimalMemory() {
    return minimalMemory;
  }

  public void setMinimalMemory(boolean minimalMemory) {
    this.minimalMemory = minimalMemory;
  }

  public String getFolder() {
    return cacheFolder.getAbsolutePath();
  }

  private NpmPackage loadPackageInfo(String path) throws IOException {
    return minimalMemory ? NpmPackage.fromFolderMinimal(path, false) : NpmPackage.fromFolder(path, false);
  }

  private void clearCache() throws IOException {
    System.out.println(">>> clearCache " + " Thread: " + Thread.currentThread().getId());
    for (File f : cacheFolder.listFiles()) {
      if (f.isDirectory()) {
        Utilities.clearDirectory(f.getAbsolutePath());
        try {
          FileUtils.deleteDirectory(f);
        } catch (Exception e1) {
          try {
            FileUtils.deleteDirectory(f);
          } catch (Exception e2) {
            // just give up
          }
        }

      } else if (!f.getName().equals("packages.ini")) {
        FileUtils.forceDelete(f);
      }

    }
  }

  private void createIniFile() throws IOException {
    IniFile ini = new IniFile(getPackagesIniPath());
    ini.setStringProperty("cache", "version", CACHE_VERSION, null);
    ini.save();
  }

  private String getPackagesIniPath() throws IOException {
    return Utilities.path(cacheFolder, "packages.ini");
  }

  private void checkValidVersionString(String version, String id) {
    if (Utilities.noString(version)) {
      throw new FHIRException("Cannot add package " + id + " to the package cache - a version must be provided");
    }
    if (version.startsWith("file:")) {
      throw new FHIRException("Cannot add package " + id + " to the package cache - the version '" + version + "' is illegal in this context");
    }
    for (char ch : version.toCharArray()) {
      if (!Character.isAlphabetic(ch) && !Character.isDigit(ch) && !Utilities.existsInList(ch, '.', '-', '$')) {
        throw new FHIRException("Cannot add package " + id + " to the package cache - the version '" + version + "' is illegal (ch '" + ch + "'");
      }
    }
  }

  protected InputStreamWithSrc loadFromPackageServer(String id, String version) {
    InputStreamWithSrc retVal = super.loadFromPackageServer(id, version);
    if (retVal != null) {
      return retVal;
    }

    retVal = super.loadFromPackageServer(id, VersionUtilities.getMajMin(version) + ".x");
    if (retVal != null) {
      return retVal;
    }

    // ok, well, we'll try the old way
    return fetchTheOldWay(id, version);
  }

  public String getLatestVersion(String id) throws IOException {
    for (PackageServer nextPackageServer : getPackageServers()) {
      // special case:
      if (!(Utilities.existsInList(id, CommonPackages.ID_PUBPACK, "hl7.terminology.r5") && PackageServer.PRIMARY_SERVER.equals(nextPackageServer.getUrl()))) {
        PackageClient pc = new PackageClient(nextPackageServer);
        try {
          return pc.getLatestVersion(id);
        } catch (IOException e) {
          ourLog.info("Failed to determine latest version of package {} from server: {}", id, nextPackageServer.toString());
        }
      }
    }
    try {
      return fetchVersionTheOldWay(id);
    } catch (Exception e) {
      ourLog.info("Failed to determine latest version of package {} from server: {}", id, "build.fhir.org");
    }
    // still here? use the latest version we previously found or at least, is in the cache

    String version = getLatestVersionFromCache(id);
    if (version != null) {
      return version;
    }
    throw new FHIRException("Unable to find the last version for package " + id + ": no local copy, and no network access");
  }

  public String getLatestVersionFromCache(String id) throws IOException {
    for (String f : Utilities.reverseSorted(cacheFolder.list())) {
      File cf = ManagedFileAccess.file(Utilities.path(cacheFolder, f));
      if (cf.isDirectory()) {
        if (f.startsWith(id + "#")) {
          String ver = f.substring(f.indexOf("#") + 1);
          ourLog.info("Latest version of package {} found locally is {} - using that", id, ver);
          return ver;
        }
      }
    }
    return null;
  }

  private NpmPackage loadPackageFromFile(String id, String folder) throws IOException {
    File f = ManagedFileAccess.file(Utilities.path(folder, id));
    if (!f.exists()) {
      throw new FHIRException("Package '" + id + "  not found in folder " + folder);
    }
    if (!f.isDirectory()) {
      throw new FHIRException("File for '" + id + "  found in folder " + folder + ", not a folder");
    }
    File fp = ManagedFileAccess.file(Utilities.path(folder, id, "package", "package.json"));
    if (!fp.exists()) {
      throw new FHIRException("Package '" + id + "  found in folder " + folder + ", but does not contain a package.json file in /package");
    }
    return NpmPackage.fromFolder(f.getAbsolutePath());
  }

  /**
   * Clear the cache
   *
   * @throws IOException
   */
  public void clear() throws IOException {
    this.locks.getCacheLock().doWriteWithLock(() -> {
      System.out.println(">>> start write lock for cache clear Thread: " + Thread.currentThread().getId());
      clearCache();
      System.out.println(">>> end write lock for cache clear Thread: " + Thread.currentThread().getId());
      return null;
      });
  }

  // ========================= Utilities ============================================================================

  /**
   * Remove a particular package from the cache
   *
   * @param id
   * @param ver
   * @throws IOException
   */
  public void removePackage(String id, String ver) throws IOException {
    locks.getPackageLock(id + "#" + ver).doWriteWithLock(() -> {
      System.out.println(">>> start write lock for " + id + "#" + ver + " delete package Thread: " + Thread.currentThread().getId());

      String f = Utilities.path(cacheFolder, id + "#" + ver);
      File ff = ManagedFileAccess.file(f);
      if (ff.exists()) {
        Utilities.clearDirectory(f);
        ff.delete();
      }
      System.out.println(">>> end write lock for " + id + "#" + ver + " delete package Thread: " + Thread.currentThread().getId());

      return null;
    });
  }

  /**
   * Load the identified package from the cache - if it exists
   * <p>
   * This is for special purpose only (testing, control over speed of loading).
   * Generally, use the loadPackage method
   *
   * @param id
   * @param version
   * @return
   * @throws IOException
   */
  @Override
  public NpmPackage loadPackageFromCacheOnly(String id, String version) throws IOException {

    if (!Utilities.noString(version) && version.startsWith("file:")) {
      return loadPackageFromFile(id, version.substring(5));
    }

    for (NpmPackage p : temporaryPackages) {
      if (p.name().equals(id) && ("current".equals(version) || "dev".equals(version) || p.version().equals(version))) {
        return p;
      }
      if (p.name().equals(id) && Utilities.noString(version)) {
        return p;
      }
    }

    String foundPackageFolder = findPackageFolder(id, version);
    if (foundPackageFolder != null) {
      NpmPackage foundPackage = locks.getPackageLock(foundPackageFolder).doReadWithLock(() -> {
        System.out.println(">>> start read lock for " + id + "#" + version + " cache only Thread: " + Thread.currentThread().getId());

        String path = Utilities.path(cacheFolder, foundPackageFolder);
        File directory = ManagedFileAccess.file(path);

        /* Check if the directory still exists now that we have a read lock. findPackageFolder does no locking in order
        to avoid locking every potential package directory, so it's possible that a package deletion has occurred.
        * */
        if (!directory.exists()) {
          return null;
        }
        NpmPackage npmPackage = loadPackageInfo(path);
        System.out.println(">>> end read lock for " + id + "#" + version + " cache only Thread: " + Thread.currentThread().getId());

        return npmPackage;
      });
      if (foundPackage != null) {
        if (foundPackage.isIndexed()){
          return foundPackage;
        } else {
          return locks.getPackageLock(foundPackageFolder).doWriteWithLock(() -> {
            // Since another thread may have already indexed the package since our read, we need to check again
            NpmPackage output = loadPackageInfo(foundPackage.getPath());
            if (output.isIndexed()) {
              return output;
            }
            String path = Utilities.path(cacheFolder, foundPackageFolder);
            output.checkIndexed(path);
            return output;
          });
          }
      }
    }
    if ("dev".equals(version))
      return loadPackageFromCacheOnly(id, "current");
    else
      return null;
  }

  private String findPackageFolder(String id, String version) throws IOException {
    String foundPackageFolder = null;
    String foundVersion = null;
    for (String currentPackageFolder : Utilities.reverseSorted(cacheFolder.list())) {
      File cf = ManagedFileAccess.file(Utilities.path(cacheFolder, currentPackageFolder));
      if (cf.isDirectory()) {
        if (currentPackageFolder.equals(id + "#" + version) || (Utilities.noString(version) && currentPackageFolder.startsWith(id + "#"))) {
          return currentPackageFolder;
        }
        if (version != null && !version.equals("current") && (version.endsWith(".x") || Utilities.charCount(version, '.') < 2) && currentPackageFolder.contains("#")) {
          String[] parts = currentPackageFolder.split("#");
          if (parts[0].equals(id) && VersionUtilities.isMajMinOrLaterPatch((foundVersion != null ? foundVersion : version), parts[1])) {
            foundVersion = parts[1];
            foundPackageFolder = currentPackageFolder;
          }
        }
      }
    }
    return foundPackageFolder;
  }

  /**
   * Add an already fetched package to the cache
   */
  @Override
  public NpmPackage addPackageToCache(final String id, final String version, final InputStream packageTgzInputStream, final String sourceDesc) throws IOException {
    checkValidVersionString(version, id);
    return locks.getPackageLock(id + "#" + version).doWriteWithLock(() -> {
      System.out.println(">>> start write lock for " + id + "#" + version + " Thread: " + Thread.currentThread().getId());

      String uuid = UUID.randomUUID().toString().toLowerCase();
      String tempDir = Utilities.path(cacheFolder, uuid);

      NpmPackage npm = NpmPackage.extractFromTgz(packageTgzInputStream, sourceDesc, tempDir, minimalMemory);

      log("");
      log("Installing " + id + "#" + version);

      if ((npm.name() != null && id != null && !id.equalsIgnoreCase(npm.name()))) {
        if (!suppressErrors && (!id.equals("hl7.fhir.r5.core") && !id.equals("hl7.fhir.us.immds"))) {// temporary work around
          throw new IOException("Attempt to import a mis-identified package. Expected " + id + ", got " + npm.name());
        }
      }


      NpmPackage pck = null;
      String packRoot = Utilities.path(cacheFolder, id + "#" + version);
      try {
        // ok, now we have a lock on it... check if something created it while we were waiting
        if (!ManagedFileAccess.file(packRoot).exists() || Utilities.existsInList(version, "current", "dev")) {
          Utilities.createDirectory(packRoot);
          try {
            Utilities.clearDirectory(packRoot);
          } catch (Throwable t) {
            log("Unable to clear directory: " + packRoot + ": " + t.getMessage() + " - this may cause problems later");
          }
          Utilities.renameDirectory(tempDir, packRoot);

          log(" done.");
        } else {
          Utilities.clearDirectory(tempDir);
          ManagedFileAccess.file(tempDir).delete();
        }
        if (!id.equals(npm.getNpm().asString("name")) || !version.equals(npm.getNpm().asString("version"))) {
          if (!id.equals(npm.getNpm().asString("name"))) {
            npm.getNpm().add("original-name", npm.getNpm().asString("name"));
            npm.getNpm().remove("name");
            npm.getNpm().add("name", id);
          }
          if (!version.equals(npm.getNpm().asString("version"))) {
            npm.getNpm().add("original-version", npm.getNpm().asString("version"));
            npm.getNpm().remove("version");
            npm.getNpm().add("version", version);
          }
          TextFile.stringToFile(JsonParser.compose(npm.getNpm(), true), Utilities.path(cacheFolder, id + "#" + version, "package", "package.json"));
        }
        pck = loadPackageInfo(packRoot);
        if (pck != null && !pck.isIndexed()) {
          pck.checkIndexed(packRoot);
        }
      } catch (Exception e) {
        try {
          // don't leave a half extracted package behind
          log("Clean up package " + packRoot + " because installation failed: " + e.getMessage());
          e.printStackTrace();
          Utilities.clearDirectory(packRoot);
          ManagedFileAccess.file(packRoot).delete();
        } catch (Exception ignored) {
          // nothing
        }
        throw e;
      }
      System.out.println(">>> end write lock for " + id + "#" + version + " Thread: " + Thread.currentThread().getId());
      return pck;
    });
  }

  private void log(String s) {
    if (!silent) {
      System.out.println(s);
    }
  }

  @Override
  public String getPackageUrl(String packageId) throws IOException {
    String result = super.getPackageUrl(packageId);
    if (result == null) {
      result = getPackageUrlFromBuildList(packageId);
    }

    return result;
  }

  @Override
  public NpmPackage loadPackage(String id, String version) throws FHIRException, IOException {
    //ok, try to resolve locally
    if (!Utilities.noString(version) && version.startsWith("file:")) {
      return loadPackageFromFile(id, version.substring(5));
    }

    if (version == null && id.contains("#")) {
      version = id.substring(id.indexOf("#") + 1);
      id = id.substring(0, id.indexOf("#"));
    }

    if (version == null) {
      try {
        version = getLatestVersion(id);
      } catch (Exception e) {
        version = null;
      }
    }
    NpmPackage p = loadPackageFromCacheOnly(id, version);
    if (p != null) {
      if ("current".equals(version)) {
        p = checkCurrency(id, p);
      }
      if (p != null)
        return p;
    }

    if ("dev".equals(version)) {
      p = loadPackageFromCacheOnly(id, "current");
      p = checkCurrency(id, p);
      if (p != null)
        return p;
      version = "current";
    }

    log("Installing " + id + "#" + (version == null ? "?" : version) + " to the package cache");
    log("  Fetching:");

    // nup, don't have it locally (or it's expired)
    FilesystemPackageCacheManager.InputStreamWithSrc source;
    if (false && packageProvider != null && packageProvider.handlesPackage(id, version)) {
      source = packageProvider.provide(id, version);
    } else if (Utilities.isAbsoluteUrl(version)) {
      source = fetchSourceFromUrlSpecific(version);
    } else if ("current".equals(version) || (version != null && version.startsWith("current$"))) {
      // special case - fetch from ci-build server
      source = loadFromCIBuild(id, version.startsWith("current$") ? version.substring(8) : null);
    } else {
      source = loadFromPackageServer(id, version);
    }
    if (source == null) {
      throw new FHIRException("Unable to find package " + id + "#" + version);
    }
    return addPackageToCache(id, source.version, source.stream, source.url);
  }

  private InputStreamWithSrc fetchSourceFromUrlSpecific(String url) {
    return new InputStreamWithSrc(fetchFromUrlSpecific(url, false), url, "current");
  }

  private InputStream fetchFromUrlSpecific(String source, boolean optional) throws FHIRException {
    try {
      HTTPResult res = ManagedWebAccess.get(source);
      res.checkThrowException();
      return new ByteArrayInputStream(res.getContent());
    } catch (Exception e) {
      if (optional)
        return null;
      else
        throw new FHIRException("Unable to fetch: " + e.getMessage(), e);
    }
  }

  private InputStreamWithSrc loadFromCIBuild(String id, String branch) throws IOException {
    checkBuildLoaded();
    if (ciList.containsKey(id)) {
      if (branch == null) {
        InputStream stream;
        try {
          stream = fetchFromUrlSpecific(Utilities.pathURL(ciList.get(id), "package.tgz"), false);
        } catch (Exception e) {
          stream = fetchFromUrlSpecific(Utilities.pathURL(ciList.get(id), "branches", "main", "package.tgz"), false);
        }
        return new InputStreamWithSrc(stream, Utilities.pathURL(ciList.get(id), "package.tgz"), "current");
      } else {
        InputStream stream = fetchFromUrlSpecific(Utilities.pathURL(ciList.get(id), "branches", branch, "package.tgz"), false);
        return new InputStreamWithSrc(stream, Utilities.pathURL(ciList.get(id), "branches", branch, "package.tgz"), "current$" + branch);
      }
    } else if (id.startsWith("hl7.fhir.r6")) {
      InputStream stream = fetchFromUrlSpecific(Utilities.pathURL("http://build.fhir.org", id + ".tgz"), false);
      return new InputStreamWithSrc(stream, Utilities.pathURL("http://build.fhir.org", id + ".tgz"), "current");
    } else {
      throw new FHIRException("The package '" + id + "' has no entry on the current build server (" + ciList.toString() + ")");
    }
  }

  private String getPackageUrlFromBuildList(String packageId) throws IOException {
    checkBuildLoaded();
    for (JsonObject o : buildInfo.asJsonObjects()) {
      if (packageId.equals(o.asString("package-id"))) {
        return o.asString("url");
      }
    }
    return null;
  }

  @Override
  public String getPackageId(String canonicalUrl) throws IOException {
    String retVal = findCanonicalInLocalCache(canonicalUrl);

    if (retVal == null) {
      retVal = super.getPackageId(canonicalUrl);
    }

    if (retVal == null) {
      retVal = getPackageIdFromBuildList(canonicalUrl);
    }

    return retVal;
  }


  public String findCanonicalInLocalCache(String canonicalUrl) {
    try {
      for (String pf : listPackages()) {
        if (ManagedFileAccess.file(Utilities.path(cacheFolder, pf, "package", "package.json")).exists()) {
          JsonObject npm = JsonParser.parseObjectFromFile(Utilities.path(cacheFolder, pf, "package", "package.json"));
          if (canonicalUrl.equals(npm.asString("canonical"))) {
            return npm.asString("name");
          }
        }
      }
    } catch (IOException e) {
    }
    return null;
  }

  // ========================= Package Mgmt API =======================================================================

  private String getPackageIdFromBuildList(String canonical) throws IOException {
    if (canonical == null) {
      return null;
    }
    checkBuildLoaded();
    if (buildInfo != null) {
      for (JsonElement n : buildInfo) {
        JsonObject o = (JsonObject) n;
        if (canonical.equals(o.asString("url"))) {
          return o.asString("package-id");
        }
      }
      for (JsonElement n : buildInfo) {
        JsonObject o = (JsonObject) n;
        if (o.asString("url").startsWith(canonical + "/ImplementationGuide/")) {
          return o.asString("package-id");
        }
      }
    }
    return null;
  }

  private NpmPackage checkCurrency(String id, NpmPackage p) throws IOException {
    checkBuildLoaded();
    // special case: current versions roll over, and we have to check their currency
    try {
      String url = ciList.get(id);
      JsonObject json = JsonParser.parseObjectFromUrl(Utilities.pathURL(url, "package.manifest.json"));
      String currDate = json.asString("date");
      String packDate = p.date();
      if (!currDate.equals(packDate)) {
        return null; // nup, we need a new copy
      }
    } catch (Exception e) {
      log("Unable to check package currency: " + id + ": " + id);
    }
    return p;
  }

  private void checkBuildLoaded() {
    if (!buildLoaded) {
      try {
        loadFromBuildServer();
      } catch (Exception e) {
        try {
          // we always pause a second and try again - the most common reason to be here is that the file was being changed on the server
          Thread.sleep(1000);
          loadFromBuildServer();
        } catch (Exception e2) {
          log("Error connecting to build server - running without build (" + e2.getMessage() + ")");
        }
      }
    }
  }

  private void loadFromBuildServer() throws IOException {

    HTTPResult res = ManagedWebAccess.get("https://build.fhir.org/ig/qas.json?nocache=" + System.currentTimeMillis());
    res.checkThrowException();

    buildInfo = (JsonArray) JsonParser.parse(TextFile.bytesToString(res.getContent()));

    List<BuildRecord> builds = new ArrayList<>();

    for (JsonElement n : buildInfo) {
      JsonObject o = (JsonObject) n;
      if (o.has("url") && o.has("package-id") && o.asString("package-id").contains(".")) {
        String u = o.asString("url");
        if (u.contains("/ImplementationGuide/"))
          u = u.substring(0, u.indexOf("/ImplementationGuide/"));
        builds.add(new BuildRecord(u, o.asString("package-id"), getRepo(o.asString("repo")), readDate(o.asString("date"))));
      }
    }
    Collections.sort(builds, new BuildRecordSorter());
    for (BuildRecord bld : builds) {
      if (!ciList.containsKey(bld.getPackageId())) {
        ciList.put(bld.getPackageId(), "https://build.fhir.org/ig/" + bld.getRepo());
      }
    }
    buildLoaded = true;
  }

  private String getRepo(String path) {
    String[] p = path.split("\\/");
    return p[0] + "/" + p[1];
  }

  private Date readDate(String s) {
    SimpleDateFormat sdf = new SimpleDateFormat("EEE, dd MMM, yyyy HH:mm:ss Z", new Locale("en", "US"));
    try {
      return sdf.parse(s);
    } catch (ParseException e) {
      e.printStackTrace();
      return new Date();
    }
  }

  // ----- the old way, from before package server, while everything gets onto the package server
  private InputStreamWithSrc fetchTheOldWay(String id, String v) {
    String url = getUrlForPackage(id);
    if (url == null) {
      try {
        url = getPackageUrlFromBuildList(id);
      } catch (Exception ignored) {

      }
    }
    if (url == null) {
      throw new FHIRException("Unable to resolve package id " + id + "#" + v);
    }
    if (url.contains("/ImplementationGuide/")) {
      url = url.substring(0, url.indexOf("/ImplementationGuide/"));
    }
    String pu = Utilities.pathURL(url, "package-list.json");

    PackageList pl;
    try {
      pl = PackageList.fromUrl(pu);
    } catch (Exception e) {
      String pv = Utilities.pathURL(url, v, "package.tgz");
      try {
        return new InputStreamWithSrc(fetchFromUrlSpecific(pv, false), pv, v);
      } catch (Exception e1) {
        throw new FHIRException("Error fetching package directly (" + pv + "), or fetching package list for " + id + " from " + pu + ": " + e1.getMessage(), e1);
      }
    }
    if (!id.equals(pl.pid()))
      throw new FHIRException("Package ids do not match in " + pu + ": " + id + " vs " + pl.pid());
    for (PackageListEntry vo : pl.versions()) {
      if (v.equals(vo.version())) {

        String u = Utilities.pathURL(vo.path(), "package.tgz");
        return new InputStreamWithSrc(fetchFromUrlSpecific(u, true), u, v);
      }
    }

    return null;
  }


  // ---------- Current Build SubSystem --------------------------------------------------------------------------------------

  private String fetchVersionTheOldWay(String id) throws IOException {
    String url = getUrlForPackage(id);
    if (url == null) {
      try {
        url = getPackageUrlFromBuildList(id);
      } catch (Exception e) {
        url = null;
      }
    }
    if (url == null) {
      throw new FHIRException("Unable to resolve package id " + id);
    }
    PackageList pl = PackageList.fromUrl(Utilities.pathURL(url, "package-list.json"));
    if (!id.equals(pl.pid()))
      throw new FHIRException("Package ids do not match in " + pl.source() + ": " + id + " vs " + pl.pid());
    for (PackageListEntry vo : pl.versions()) {
      if (vo.current()) {
        return vo.version();
      }
    }

    return null;
  }

  private String getUrlForPackage(String id) {
    if (CommonPackages.ID_XVER.equals(id)) {
      return "http://fhir.org/packages/hl7.fhir.xver-extensions";
    }
    return null;
  }

  public List<String> listPackages() {
    List<String> res = new ArrayList<>();
    for (File f : cacheFolder.listFiles()) {
      if (f.isDirectory() && f.getName().contains("#")) {
        res.add(f.getName());
      }
    }
    return res;
  }

  public interface CacheLockFunction<T> {
    T get() throws IOException;
  }

  public class BuildRecordSorter implements Comparator<BuildRecord> {

    @Override
    public int compare(BuildRecord arg0, BuildRecord arg1) {
      return arg1.date.compareTo(arg0.date);
    }
  }

  public class BuildRecord {

    private final String url;
    private final String packageId;
    private final String repo;
    private final Date date;

    public BuildRecord(String url, String packageId, String repo, Date date) {
      super();
      this.url = url;
      this.packageId = packageId;
      this.repo = repo;
      this.date = date;
    }

    public String getUrl() {
      return url;
    }

    public String getPackageId() {
      return packageId;
    }

    public String getRepo() {
      return repo;
    }

    public Date getDate() {
      return date;
    }

  }

  public boolean packageExists(String id, String ver) throws IOException {
    if (packageInstalled(id, ver)) {
      return true;
    }
    for (PackageServer s : getPackageServers()) {
      if (new PackageClient(s).exists(id, ver)) {
        return true;
      }
    }
    return false;
  }

  public boolean packageInstalled(String id, String version) {
    for (NpmPackage p : temporaryPackages) {
      if (p.name().equals(id) && ("current".equals(version) || "dev".equals(version) || p.version().equals(version))) {
        return true;
      }
      if (p.name().equals(id) && Utilities.noString(version)) {
        return true;
      }
    }

    for (String f : Utilities.sorted(cacheFolder.list())) {
      if (f.equals(id + "#" + version) || (Utilities.noString(version) && f.startsWith(id + "#"))) {
        return true;
      }
    }
    if ("dev".equals(version))
      return packageInstalled(id, "current");
    else
      return false;
  }

  public boolean isSuppressErrors() {
    return suppressErrors;
  }

  public void setSuppressErrors(boolean suppressErrors) {
    this.suppressErrors = suppressErrors;
  }

  public static IPackageProvider getPackageProvider() {
    return packageProvider;
  }

  public static void setPackageProvider(IPackageProvider packageProvider) {
    FilesystemPackageCacheManager.packageProvider = packageProvider;
  }


}
