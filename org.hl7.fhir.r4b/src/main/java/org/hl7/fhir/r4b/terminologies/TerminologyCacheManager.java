package org.hl7.fhir.r4b.terminologies;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import org.hl7.fhir.utilities.SimpleHTTPClient;
import org.hl7.fhir.utilities.SimpleHTTPClient.HTTPResult;
import org.hl7.fhir.utilities.IniFile;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;

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
    File f = new File(cacheFolder);
    if (!f.exists()) {
      Utilities.createDirectory(cacheFolder);      
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
      System.out.println("Initialise terminology cache from "+source);

      SimpleHTTPClient http = new SimpleHTTPClient();
      HTTPResult res = http.get(source+"?nocache=" + System.currentTimeMillis());
      res.checkThrowException();
      unzip(new ByteArrayInputStream(res.getContent()), cacheFolder);
    } catch (Exception e) {
      System.out.println("No - can't initialise cache from "+source+": "+e.getMessage());
    }
  }

  public static void unzip(InputStream is, String targetDir) throws IOException {
    try (ZipInputStream zipIn = new ZipInputStream(is)) {
      for (ZipEntry ze; (ze = zipIn.getNextEntry()) != null; ) {
        Path path = Path.of(Utilities.path(targetDir, ze.getName())).normalize();
        String pathString = path.toFile().getAbsolutePath();
        if (!path.startsWith(Path.of(targetDir).normalize())) {
          // see: https://snyk.io/research/zip-slip-vulnerability
          throw new RuntimeException("Entry with an illegal path: " + ze.getName());
        }
        if (ze.isDirectory()) {
          Utilities.createDirectory(pathString);
        } else {
          Utilities.createDirectory(Utilities.getDirectoryForFile(pathString));
          TextFile.streamToFileNoClose(zipIn, pathString);
        }
      }
    }
  }

  private void clearCache() throws IOException {
    Utilities.clearDirectory(cacheFolder);    
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
          System.err.println(e);
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
    System.out.println("Sending tx-cache to "+url+" ("+Utilities.describeSize(bs.toByteArray().length)+")");
    SimpleHTTPClient http = new SimpleHTTPClient();
    http.setAuthenticationMode(SimpleHTTPClient.AuthenticationMode.BASIC);
    http.setUsername(token.substring(0, token.indexOf(':')));
    http.setPassword(token.substring(token.indexOf(':')+1));
    HTTPResult res = http.put(url, "application/zip", bs.toByteArray(), null); // accept doesn't matter
    if (res.getCode() >= 300) {
      System.out.println("sending cache failed: "+res.getCode());
    } else {
      System.out.println("Sent cache");      
    }
  }

}
