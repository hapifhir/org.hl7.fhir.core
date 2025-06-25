package org.hl7.fhir.r5.terminologies;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.utilities.IniFile;
import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;
import org.hl7.fhir.utilities.FileUtilities;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.utilities.http.HTTPResult;
import org.hl7.fhir.utilities.http.ManagedWebAccess;

@MarkedToMoveToAdjunctPackage
@Slf4j
public class TerminologyCacheManager {

  // if either the CACHE_VERSION of the stated maj/min server versions change, the 
  // cache will be blown. Note that the stated terminology server version is 
  // the CapabilityStatement.software.version 
  private static final String CACHE_VERSION = "1";

  private String cacheFolder;
  private String version;
  private String ghOrg;
  private String ghRepo;
  private String ghBranch;

  public TerminologyCacheManager(String serverVersion, String rootDir, String ghOrg, String ghRepo, String ghBranch) throws IOException {
    super();
    //    this.rootDir = rootDir;
    this.ghOrg = ghOrg;
    this.ghRepo = ghRepo;
    this.ghBranch = ghBranch;

    version = CACHE_VERSION+"/"+VersionUtilities.getMajMin(serverVersion);

    if (Utilities.noString(ghOrg) || Utilities.noString(ghRepo) || Utilities.noString(ghBranch)) {
      cacheFolder = Utilities.path(rootDir, "temp", "tx-cache");
    } else {
      cacheFolder = Utilities.path(System.getProperty("user.home"), ".fhir", "tx-cache", ghOrg, ghRepo, ghBranch);
    }
  }

  public void initialize() throws IOException {
    File f = ManagedFileAccess.file(cacheFolder);
    if (!f.exists()) {
      FileUtilities.createDirectory(cacheFolder);      
    }
    if (!version.equals(getCacheVersion())) {
      clearCache();
      fillCache("https://tx.fhir.org/tx-cache/"+ghOrg+"/"+ghRepo+"/"+ghBranch+".zip");
    }
    if (!version.equals(getCacheVersion())) {
      clearCache();
      fillCache("https://tx.fhir.org/tx-cache/"+ghOrg+"/"+ghRepo+"/default.zip");
    }
    if (!version.equals(getCacheVersion())) {
      clearCache();
    }

    IniFile ini = new IniFile(Utilities.path(cacheFolder, "cache.ini"));
    ini.setStringProperty("cache", "version", version, null);
    ini.setDateProperty("cache", "last-use", new Date(), null);
    ini.save();
  }

  private void fillCache(String source) throws IOException {
    try {
      log.info("Initialise terminology cache from "+source);

      HTTPResult res = ManagedWebAccess.get(Arrays.asList("web"), source+"?nocache=" + System.currentTimeMillis());
      res.checkThrowException();
      unzip(new ByteArrayInputStream(res.getContent()), cacheFolder);
    } catch (Exception e) {
      log.error("No - can't initialise cache from "+source+": "+e.getMessage(), e);
    }
  }

  public static void unzip(InputStream is, String targetDir) throws IOException {
    try (ZipInputStream zipIn = new ZipInputStream(is)) {
      for (ZipEntry ze; (ze = zipIn.getNextEntry()) != null; ) {
        Path path = Path.of(Utilities.path(targetDir, ze.getName())).normalize();
        String pathString = ManagedFileAccess.fromPath(path).getAbsolutePath();
        if (!path.startsWith(Path.of(targetDir).normalize())) {
          // see: https://snyk.io/research/zip-slip-vulnerability
          throw new RuntimeException("Entry with an illegal path: " + ze.getName());
        }
        if (ze.isDirectory()) {
          FileUtilities.createDirectory(pathString);
        } else {
          FileUtilities.createDirectory(FileUtilities.getDirectoryForFile(pathString));
          FileUtilities.streamToFileNoClose(zipIn, pathString);
        }
      }
    }
  }

  private void clearCache() throws IOException {
    FileUtilities.clearDirectory(cacheFolder);    
  }

  private String getCacheVersion() throws IOException {
    IniFile ini = new IniFile(Utilities.path(cacheFolder, "cache.ini"));
    return ini.getStringProperty("cache", "version");
  }

  public String getFolder() {
    return cacheFolder;
  }

  private void zipDirectory(OutputStream outputStream) throws IOException {
    try (ZipOutputStream zs = new ZipOutputStream(outputStream)) {
      Path pp = Paths.get(cacheFolder);
      Files.walk(pp)
      .forEach(path -> {
        try {
          if (Files.isDirectory(path)) {
            zs.putNextEntry(new ZipEntry(pp.relativize(path).toString() + "/"));
          } else {
            ZipEntry zipEntry = new ZipEntry(pp.relativize(path).toString());
            zs.putNextEntry(zipEntry);
            Files.copy(path, zs);
            zs.closeEntry();
          }
        } catch (IOException e) {
          log.error(e.getMessage(), e);
        }
      });
    }
  }

  
  public void commit(String token) throws IOException {
    // create a zip of all the files 
    ByteArrayOutputStream bs = new ByteArrayOutputStream();
    zipDirectory(bs);

    // post it to
    String url = "https://tx.fhir.org/post/tx-cache/"+ghOrg+"/"+ghRepo+"/"+ghBranch+".zip";
    log.info("Sending tx-cache to "+url+" ("+Utilities.describeSize(bs.toByteArray().length)+")");
    HTTPResult res = ManagedWebAccess.accessor(Arrays.asList("web"))
        .withBasicAuth(token.substring(0, token.indexOf(':')), token.substring(token.indexOf(':') + 1))
        .put(url, bs.toByteArray(), null, "application/zip");
    
    if (res.getCode() >= 300) {
      log.error("sending cache failed: "+res.getCode());
    } else {
      log.info("Sent cache");
    }
  }

}
