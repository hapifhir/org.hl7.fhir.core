package org.hl7.fhir.utilities.npm;

import java.io.*;

import java.util.*;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import lombok.Getter;
import lombok.Setter;
import lombok.With;
import org.apache.commons.io.FileUtils;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.utilities.*;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.utilities.http.HTTPResult;
import org.hl7.fhir.utilities.http.ManagedWebAccess;
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

  private final FilesystemPackageCacheManagerLocks.LockParameters lockParameters;

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

  @Getter
  private final CIBuildClient ciBuildClient;

  @Nonnull
  private final File cacheFolder;

  private final List<NpmPackage> temporaryPackages = new ArrayList<>();

  private boolean suppressErrors;

  @Setter
  @Getter
  private boolean minimalMemory;

  public static class Builder {

    @Getter
    private final File cacheFolder;

    @With
    @Getter
    private final List<PackageServer> packageServers;

    @With
    @Getter
    private final CIBuildClient ciBuildClient;

    @With
    @Getter
    private final FilesystemPackageCacheManagerLocks.LockParameters lockParameters;

    public Builder() throws IOException {
      this.cacheFolder = getUserCacheFolder();
      this.packageServers = getPackageServersFromFHIRSettings();
      this.lockParameters = null;
      this.ciBuildClient = new CIBuildClient();
    }

    private Builder(File cacheFolder, List<PackageServer> packageServers, CIBuildClient ciBuildClient, FilesystemPackageCacheManagerLocks.LockParameters lockParameters) {
      this.cacheFolder = cacheFolder;
      this.packageServers = packageServers;
      this.ciBuildClient = ciBuildClient;
      this.lockParameters = lockParameters;
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

    public Builder withCacheFolder(String cacheFolderPath) throws IOException {
      File cacheFolder = ManagedFileAccess.file(cacheFolderPath);
      if (!cacheFolder.exists()) {
        throw new FHIRException("The folder '" + cacheFolder + "' could not be found");
      }
      return new Builder(cacheFolder, this.packageServers, this.ciBuildClient, this.lockParameters);
    }

    public Builder withSystemCacheFolder() throws IOException {
      final File systemCacheFolder;
      if (Utilities.isWindows()) {
        systemCacheFolder = ManagedFileAccess.file(Utilities.path(System.getenv("ProgramData"), ".fhir", "packages"));
      } else {
        systemCacheFolder = ManagedFileAccess.file(Utilities.path("/var", "lib", ".fhir", "packages"));
      }
      return new Builder(systemCacheFolder,  this.packageServers, this.ciBuildClient, this.lockParameters);
    }

    public Builder withTestingCacheFolder() throws IOException {
      return new Builder(ManagedFileAccess.file(Utilities.path("[tmp]", ".fhir", "packages")), this.packageServers, this.ciBuildClient, this.lockParameters);
    }

    public FilesystemPackageCacheManager build() throws IOException {
      final FilesystemPackageCacheManagerLocks locks;
      try {
        locks = FilesystemPackageCacheManagerLocks.getFilesystemPackageCacheManagerLocks(cacheFolder);
      } catch (RuntimeException e) {
        if (e.getCause() instanceof IOException) {
          throw (IOException) e.getCause();
        } else {
          throw e;
        }
      }
      return new FilesystemPackageCacheManager(cacheFolder, packageServers, ciBuildClient, locks, lockParameters);
    }
  }

  private FilesystemPackageCacheManager(@Nonnull File cacheFolder, @Nonnull List<PackageServer> packageServers, CIBuildClient ciBuildClient, @Nonnull FilesystemPackageCacheManagerLocks locks, @Nullable FilesystemPackageCacheManagerLocks.LockParameters lockParameters) throws IOException {
    super(packageServers);
    this.cacheFolder = cacheFolder;
    this.ciBuildClient = ciBuildClient;
    this.locks = locks;
    this.lockParameters = lockParameters;
    prepareCacheFolder();
  }

  /**
   * Check if the cache folder exists and is valid.
   * <p>
   * If it doesn't exist, create it.
   * <p>
   * If it does exist and isn't valid, delete it and create a new one.
   * <p>
   * If it does exist and is valid, just do some cleanup (delete temp download directories, etc.)
   *
   * @throws IOException if the cache folder can't be created
   */
  protected void prepareCacheFolder() throws IOException {
    locks.getCacheLock().doWriteWithLock(() -> {

      if (!(cacheFolder.exists())) {
        FileUtilities.createDirectory(cacheFolder.getAbsolutePath());
        createIniFile();
      } else {
        if (!iniFileExists()) {
          createIniFile();
        }
        if (!isIniFileCurrentVersion()) {
          clearCache();
          createIniFile();
        }
        deleteOldTempDirectories();
        cleanUpCorruptPackages();
      }
      return null;
    });
  }

  /*
    Look for .lock files that are not actively held by a process. If found, delete the lock file, and the package
    referenced.
   */
  protected void cleanUpCorruptPackages() throws IOException {
    for (File file : Objects.requireNonNull(cacheFolder.listFiles())) {
      if (file.getName().endsWith(".lock")) {
        if (locks.getCacheLock().canLockFileBeHeldByThisProcess(file)) {
          String packageDirectoryName = file.getName().substring(0, file.getName().length() - 5);
          log("Detected potential incomplete package installed in cache: " + packageDirectoryName + ". Attempting to delete");

          File packageDirectory = ManagedFileAccess.file(Utilities.path(cacheFolder, packageDirectoryName));
          if (packageDirectory.exists()) {
            FileUtilities.clearDirectory(packageDirectory.getAbsolutePath());
            packageDirectory.delete();
          }
          file.delete();
          log("Deleted potential incomplete package: " + packageDirectoryName);
        }
      }
    }
  }

  private boolean iniFileExists() throws IOException {
    String iniPath = getPackagesIniPath();
    File iniFile = ManagedFileAccess.file(iniPath);
    return iniFile.exists();
  }

  private boolean isIniFileCurrentVersion() throws IOException {
    String iniPath = getPackagesIniPath();
    IniFile ini = new IniFile(iniPath);
    String version = ini.getStringProperty("cache", "version");
    return CACHE_VERSION.equals(version);
  }

  private void deleteOldTempDirectories() throws IOException {
    for (File f : Objects.requireNonNull(cacheFolder.listFiles())) {
      if (f.isDirectory() && UUIDUtilities.isValidUUID(f.getName())) {
        FileUtilities.clearDirectory(f.getAbsolutePath());
        f.delete();
      }
    }
  }

  public String getFolder() {
    return cacheFolder.getAbsolutePath();
  }

  private NpmPackage loadPackageInfo(String path) throws IOException {
    return minimalMemory ? NpmPackage.fromFolderMinimal(path, false) : NpmPackage.fromFolder(path, false);
  }

  private void clearCache() throws IOException {
    for (File f : Objects.requireNonNull(cacheFolder.listFiles())) {
      if (f.isDirectory()) {
        FileUtilities.atomicDeleteDirectory(f.getAbsolutePath());

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
      if (!(Utilities.existsInList(id, CommonPackages.ID_PUBPACK, "hl7.terminology.r5") && PackageServer.SECONDARY_SERVER.equals(nextPackageServer.getUrl()))) {
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
   * @throws IOException If the cache cannot be cleared
   */
  public void clear() throws IOException {
    this.locks.getCacheLock().doWriteWithLock(() -> {
      clearCache();
      return null;
    });
  }

  // ========================= Utilities ============================================================================

  /**
   * Remove a particular package from the cache
   *
   * @param id The id of the package to remove
   * @param version The literal version of the package to remove. Values such as 'current' and 'dev' are not allowed.
   * @throws IOException If the package cannot be removed
   */
  public void removePackage(String id, String version) throws IOException {
    locks.getPackageLock(id + "#" + version).doWriteWithLock(() -> {

      String f = Utilities.path(cacheFolder, id + "#" + version);
        File ff = ManagedFileAccess.file(f);
        if (ff.exists()) {
          FileUtilities.atomicDeleteDirectory(f);
        }
      return null;
    }, lockParameters);
  }

  /**
   * Load the identified package from the cache - if it exists
   * <p/>
   * This is for special purpose only (testing, control over speed of loading).
   * <p/>
   * Generally, use the loadPackage method
   *
   * @param id The id of the package to load
   * @param version The version of the package to load. Values such as 'current' and 'dev' are allowed.
   * @return The package, or null if it is not found
   * @throws IOException If the package cannot be loaded
   */
  @Override
  public NpmPackage loadPackageFromCacheOnly(String id, @Nullable String version) throws IOException {

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
        String path = Utilities.path(cacheFolder, foundPackageFolder);
        File directory = ManagedFileAccess.file(path);

        /* Check if the directory still exists now that we have a read lock. findPackageFolder does no locking in order
        to avoid locking every potential package directory, so it's possible that a package deletion has occurred.
        * */
        if (!directory.exists()) {
          return null;
        }
        return loadPackageInfo(path);
      }, lockParameters);
      if (foundPackage != null) {
        if (foundPackage.isIndexed()){
          return foundPackage;
        } else {
          return locks.getPackageLock(foundPackageFolder).doWriteWithLock(() -> {
            File directory = ManagedFileAccess.file(foundPackage.getPath());

        /* Check if the directory still exists now that we have a write lock. findPackageFolder does no locking in order
        to avoid locking every potential package directory, so it's possible that a package deletion has occurred.
        * */
            if (!directory.exists()) {
              return null;
            }

            // Since another thread may have already indexed the package since our read, we need to check again
            NpmPackage output = loadPackageInfo(foundPackage.getPath());
            if (output.isIndexed()) {
              return output;
            }
            String path = Utilities.path(cacheFolder, foundPackageFolder);
            output.checkIndexed(path);
            return output;
          }, lockParameters);
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

      String tempDir = Utilities.generateUniqueRandomUUIDPath(cacheFolder.getAbsolutePath());

      NpmPackage extractedNpm = NpmPackage.extractFromTgz(packageTgzInputStream, sourceDesc, tempDir, minimalMemory);

      log("");
      log("Installing " + id + "#" + version);

      if ((extractedNpm.name() != null && id != null && !id.equalsIgnoreCase(extractedNpm.name()) && !id.equalsIgnoreCase(extractedNpm.name()+"."+VersionUtilities.getNameForVersion(extractedNpm.fhirVersion())))) {
        if (!suppressErrors && (!id.equals("hl7.fhir.r5.core") && !id.equals("hl7.fhir.us.immds"))) {// temporary work around
          throw new IOException("Attempt to import a mis-identified package. Expected " + id + ", got " + extractedNpm.name());
        }
      }

      NpmPackage npmPackage;
      String packageRoot = Utilities.path(cacheFolder, id + "#" + version);
      try {
        if (!id.equals(extractedNpm.getNpm().asString("name")) || !version.equals(extractedNpm.getNpm().asString("version"))) {
          if (!id.equals(extractedNpm.getNpm().asString("name"))) {
            extractedNpm.getNpm().add("original-name", extractedNpm.getNpm().asString("name"));
            extractedNpm.getNpm().remove("name");
            extractedNpm.getNpm().add("name", id);
          }
          if (!version.equals(extractedNpm.getNpm().asString("version"))) {
            extractedNpm.getNpm().add("original-version", extractedNpm.getNpm().asString("version"));
            extractedNpm.getNpm().remove("version");
            extractedNpm.getNpm().add("version", version);
          }
          FileUtilities.stringToFile(JsonParser.compose(extractedNpm.getNpm(), true), Utilities.path(tempDir, "package", "package.json"));
        }

        final NpmPackage tempPackage = loadPackageInfo(tempDir);
        if (tempPackage != null && !tempPackage.isIndexed()) {
          tempPackage.checkIndexed(packageRoot);
        }

        if (!ManagedFileAccess.file(packageRoot).exists() || Utilities.existsInList(version, "current", "dev")) {
          FileUtilities.createDirectory(packageRoot);
          try {
            FileUtilities.clearDirectory(packageRoot);
          } catch (Throwable t) {
            log("Unable to clear directory: " + packageRoot + ": " + t.getMessage() + " - this may cause problems later");
          }
          FileUtilities.renameDirectory(tempDir, packageRoot);

          npmPackage = loadPackageInfo(packageRoot);

          log(" done.");
        } else {
          FileUtilities.clearDirectory(tempDir);
          ManagedFileAccess.file(tempDir).delete();
        }
        npmPackage = loadPackageInfo(packageRoot);

      } catch (Exception e) {
        try {
          // don't leave a half extracted package behind
          log("Clean up package " + packageRoot + " because installation failed: " + e.getMessage());
          e.printStackTrace();
          FileUtilities.clearDirectory(packageRoot);
          ManagedFileAccess.file(packageRoot).delete();
        } catch (Exception ignored) {
          // nothing
        }
        throw e;
      }
      return npmPackage;
    }, lockParameters);
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
      result = ciBuildClient.getPackageUrl(packageId);
    }
    return result;
  }

  /**
   * do not use this in minimal memory mode
   * @param packagesFolder
   * @throws IOException
   */
  public void loadFromFolder(String packagesFolder) throws IOException {
    assert !minimalMemory;

    File[] files = ManagedFileAccess.file(packagesFolder).listFiles();
    if (files != null) {
      for (File f : files) {
        if (f.getName().endsWith(".tgz")) {
          FileInputStream fs = ManagedFileAccess.inStream(f);
          try {
            temporaryPackages.add(NpmPackage.fromPackage(fs));
          } finally {
            fs.close();
          }
        }
      }
    }
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
        p = nullIfNotCurrentPackage(id, p);
      }
      if (p != null)
        return p;
    }

    if ("dev".equals(version)) {
      p = loadPackageFromCacheOnly(id, "current");
      p = nullIfNotCurrentPackage(id, p);
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
      source = ciBuildClient.loadFromCIBuild(id, version.startsWith("current$") ? version.substring(8) : null);
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
      HTTPResult res = ManagedWebAccess.get(Arrays.asList("web"), source);
      res.checkThrowException();
      return new ByteArrayInputStream(res.getContent());
    } catch (Exception e) {
      if (optional)
        return null;
      else
        throw new FHIRException("Unable to fetch: " + e.getMessage(), e);
    }
  }



  @Override
  public String getPackageId(String canonicalUrl) throws IOException {
    String retVal = findCanonicalInLocalCache(canonicalUrl);

    if (retVal == null) {
      retVal = super.getPackageId(canonicalUrl);
    }

    if (retVal == null) {
      retVal = ciBuildClient.getPackageId(canonicalUrl);
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

  /**
   * Checks https://
   *
   * @param id
   * @param npmPackage
   * @return
   */
  private NpmPackage nullIfNotCurrentPackage(String id, NpmPackage npmPackage) {
    // special case: current versions roll over, and we have to check their currency
    try {
      return ciBuildClient.isCurrent(id, npmPackage) ? npmPackage : null;
    } catch (Exception e) {
      log("Unable to check package currency: " + id + ": " + id);
    }
    return npmPackage;
  }

  // ----- the old way, from before package server, while everything gets onto the package server
  private InputStreamWithSrc fetchTheOldWay(String id, String v) {
    String url = getUrlForPackage(id);
    if (url == null) {
      try {
        url = ciBuildClient.getPackageUrl(id);
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
        url = ciBuildClient.getPackageUrl(id);
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
      return "https://fhir.org/packages/hl7.fhir.xver-extensions";
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
