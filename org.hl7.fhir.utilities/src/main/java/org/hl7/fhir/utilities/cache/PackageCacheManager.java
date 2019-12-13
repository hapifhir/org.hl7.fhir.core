package org.hl7.fhir.utilities.cache;

/*-
 * #%L
 * org.hl7.fhir.utilities
 * %%
 * Copyright (C) 2014 - 2019 Health Level 7
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */


import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorInputStream;
import org.apache.commons.io.FileUtils;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.utilities.IniFile;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.cache.NpmPackage.NpmPackageFolder;
import org.hl7.fhir.utilities.cache.PackageCacheManager.BuildRecord;
import org.hl7.fhir.utilities.cache.PackageCacheManager.BuildRecordSorter;
import org.hl7.fhir.utilities.json.JSONUtil;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * Package cache manager
 * 
 * API:
 * 
 * constructor
 *  getPackageUrl
 *  getPackageId
 *  findPackageCache 
 *  addPackageToCache  
 * 
 * @author Grahame Grieve
 *
 */
public class PackageCacheManager {

  public class BuildRecordSorter implements Comparator<BuildRecord> {

    @Override
    public int compare(BuildRecord arg0, BuildRecord arg1) {
      return arg1.date.compareTo(arg0.date);
    }
  }

  public class BuildRecord {

    private String url;
    private String packageId;
    private String repo;
    private Date date;
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

  /** if you don't provide and implementation of this interface, the PackageCacheManager will use the web directly. 
   * 
   * You can use this interface to 
   * @author graha
   *
   */
  public interface INetworkServices {
    
    InputStream resolvePackage(String packageId, String version);
  }
  
  public class VersionHistory {
    private String id;
    private String canonical;
    private String current;
    private Map<String, String> versions = new HashMap<>();
    public String getCanonical() {
      return canonical;
    }
    public String getCurrent() {
      return current;
    }
    public Map<String, String> getVersions() {
      return versions;
    }
    public String getId() {
      return id;
    } 
  }


  public class PackageEntry {

    private byte[] bytes;
    private String name;

    public PackageEntry(String name) {
      this.name = name;
    }

    public PackageEntry(String name, byte[] bytes) {
      this.name = name;
      this.bytes = bytes;
    }
  }

  public static final String PACKAGE_REGEX = "^[a-z][a-z0-9\\_\\-]*(\\.[a-z0-9\\_\\-]+)+$";
  public static final String PACKAGE_VERSION_REGEX = "^[a-z][a-z0-9\\_\\-]*(\\.[a-z0-9\\_\\-]+)+\\#[a-z0-9\\-\\_]+(\\.[a-z0-9\\-\\_]+)*$";

  private static final int BUFFER_SIZE = 1024;
  private static final String CACHE_VERSION = "3"; // second version - see wiki page
  private static final int ANALYSIS_VERSION = 2;

  private String cacheFolder;
  private boolean buildLoaded;
  private JsonArray buildInfo;
  private boolean progress = true;
  private List<NpmPackage> temporaryPackages = new ArrayList<NpmPackage>();
  private Map<String, String> ciList = new HashMap<String, String>();
  private List<String> allUrls;
  private Map<String, VersionHistory> historyCache = new HashMap<>();
  
  public PackageCacheManager(boolean userMode, int toolsVersion) throws IOException {
    if (userMode)
      cacheFolder = Utilities.path(System.getProperty("user.home"), ".fhir", "packages");
    else
      cacheFolder = Utilities.path("var", "lib", ".fhir", "packages");
    if (!(new File(cacheFolder).exists()))
      Utilities.createDirectory(cacheFolder);
    if (!(new File(Utilities.path(cacheFolder, "packages.ini")).exists()))
      TextFile.stringToFile("[cache]\r\nversion="+CACHE_VERSION+"\r\n\r\n[urls]\r\n\r\n[local]\r\n\r\n", Utilities.path(cacheFolder, "packages.ini"), false);  
    IniFile ini = new IniFile(Utilities.path(cacheFolder, "packages.ini"));
    boolean save = false;
    String v = ini.getStringProperty("cache", "version");    
    if (!CACHE_VERSION.equals(v)) {
      clearCache();
      ini.setStringProperty("cache", "version", CACHE_VERSION, null);
      save = true;
    }
    save = initUrlMaps(ini, save);
    if (save) {
      if (!CACHE_VERSION.equals(ini.getStringProperty("cache", "version"))) {
        throw new Error("what?");
      }
      ini.save();
    }
  }

  public static String userDir() throws IOException {
    return Utilities.path(System.getProperty("user.home"), ".fhir", "packages");
  }

  // ========================= Utilities ============================================================================
  
  private List<String> sorted(String[] keys) {
    List<String> names = new ArrayList<String>();
    for (String s : keys)
      names.add(s);
    Collections.sort(names);
    return names;
  }

  private NpmPackage loadPackageInfo(String path) throws IOException {
    NpmPackage pi = NpmPackage.fromFolder(path);
    return pi;
  }

  public String getFolder() {
    return cacheFolder;
  }





  private NpmPackage checkCurrency(String id, NpmPackage p) {
    // special case: current versions roll over, and we have to check their currency
    try {
      String url = ciList.get(id);
      JsonObject json = fetchJson(Utilities.pathURL(url, "package.manifest.json"));
      String currDate = JSONUtil.str(json, "date");
      String packDate = p.date();
      if (!currDate.equals(packDate))
        return null; // nup, we need a new copy 
      return p;
    } catch (Exception e) {
      return p;
    }
  }
  
  private JsonObject fetchJson(String source) throws IOException {
    URL url = new URL(source);
    URLConnection c = url.openConnection();
    return (JsonObject) new com.google.gson.JsonParser().parse(TextFile.streamToString(c.getInputStream()));
  }
  
  private InputStream fetchFromUrlSpecific(String source, boolean optional) throws FHIRException {
    try {
      URL url = new URL(source);
      URLConnection c = url.openConnection();
      return c.getInputStream();
    } catch (Exception e) {
      if (optional)
        return null;
      else
        throw new FHIRException(e.getMessage(), e);
    }
  }

  // ========================= Full Cache Management ============================================================================

  private void clearCache() throws IOException {
    for (File f : new File(cacheFolder).listFiles()) {
      if (f.isDirectory())
        FileUtils.deleteDirectory(f);
      else if (!f.getName().equals("packages.ini"))
        FileUtils.forceDelete(f);
    }    
    IniFile ini = new IniFile(Utilities.path(cacheFolder, "packages.ini"));
    ini.removeSection("packages");
    ini.save();
  }

//  private void checkDeleteVersion(String id, String ver, int minVer) {
//    if (hasPackage(id, ver)) {
//      boolean del = true;
//      NpmPackage pck;
//      try {
//        pck = loadPackageFromCacheOnly(id, ver);
//        if (pck.getNpm().has("tools-version")) {
//          del = pck.getNpm().get("tools-version").getAsInt() < minVer;
//        }
//      } catch (Exception e) {
//      }
//      if (del)
//        try {
//          removePackage(id, ver);
//        } catch (IOException e) {
//        }
//    }
//  }
  
//private void convertPackageCacheFrom1To2() throws IOException {
//for (File f : new File(cacheFolder).listFiles()) {
//  if (f.isDirectory() && f.getName().contains("-")) {
//    String s = f.getName();
//    int i = s.lastIndexOf("-");
//    s = s.substring(0, i)+"#"+s.substring(i+1);
//    File nf = new File(Utilities.path(cacheFolder, s));
//    if (!f.renameTo(nf))
//      throw new IOException("Unable to rename "+f.getAbsolutePath()+" to "+nf.getAbsolutePath());
//  }
//}
//}
  
  // ========================= URL maps (while waiting for package registry) ============================================================================
  
  public boolean initUrlMaps(IniFile ini, boolean save) {
    save = checkIniHasMapping("hl7.fhir.core", "http://hl7.org/fhir", ini) || save;
    save = checkIniHasMapping("hl7.fhir.pubpack", "http://fhir.org/packages/hl7.fhir.pubpack", ini) || save;
    
    save = checkIniHasMapping("hl7.fhir.r2.core", "http://hl7.org/fhir/DSTU2/hl7.fhir.r2.core.tgz", ini) || save;
    save = checkIniHasMapping("hl7.fhir.r2.examples", "http://hl7.org/fhir/DSTU2/hl7.fhir.r2.examples.tgz", ini) || save;
    save = checkIniHasMapping("hl7.fhir.r2.elements", "http://hl7.org/fhir/DSTU2/hl7.fhir.r2.elements.tgz", ini) || save;
    save = checkIniHasMapping("hl7.fhir.r2.expansions", "http://hl7.org/fhir/DSTU2/hl7.fhir.r2.expansions.tgz", ini) || save;
    save = checkIniHasMapping("hl7.fhir.r2b.core", "http://hl7.org/fhir/2016May/hl7.fhir.r2b.core.tgz", ini) || save;
    save = checkIniHasMapping("hl7.fhir.r2b.examples", "http://hl7.org/fhir/2016May/hl7.fhir.r2b.examples.tgz", ini) || save;
    save = checkIniHasMapping("hl7.fhir.r2b.elements", "http://hl7.org/fhir/2016May/hl7.fhir.r2b.elements.tgz", ini) || save;
    save = checkIniHasMapping("hl7.fhir.r2b.expansions", "http://hl7.org/fhir/2016May/hl7.fhir.r2b.expansions.tgz", ini) || save;
    save = checkIniHasMapping("hl7.fhir.r3.core", "http://hl7.org/fhir/STU3/hl7.fhir.r3.core.tgz", ini) || save;
    save = checkIniHasMapping("hl7.fhir.r3.examples", "http://hl7.org/fhir/STU3/hl7.fhir.r3.examples.tgz", ini) || save;
    save = checkIniHasMapping("hl7.fhir.r3.elements", "http://hl7.org/fhir/STU3/hl7.fhir.r3.elements.tgz", ini) || save;
    save = checkIniHasMapping("hl7.fhir.r3.expansions", "http://hl7.org/fhir/STU3/hl7.fhir.r3.expansions.tgz", ini) || save;
    save = checkIniHasMapping("hl7.fhir.r4.core", "http://hl7.org/fhir/R4/hl7.fhir.r4.core.tgz", ini) || save;
    save = checkIniHasMapping("hl7.fhir.r4.examples", "http://hl7.org/fhir/R4/hl7.fhir.r4.examples.tgz", ini) || save;
    save = checkIniHasMapping("hl7.fhir.r4.elements", "http://hl7.org/fhir/R4/hl7.fhir.r4.elements.tgz", ini) || save;
    save = checkIniHasMapping("hl7.fhir.r4.expansions", "http://hl7.org/fhir/R4/hl7.fhir.r4.expansions.tgz", ini) || save;

    save = checkIniHasMapping("hl7.fhir.r5.core", "http://build.fhir.org/package.tgz", ini) || save;

    save = checkIniHasMapping("fhir.argonaut.ehr", "http://fhir.org/guides/argonaut", ini) || save;
    save = checkIniHasMapping("fhir.argonaut.pd", "http://fhir.org/guides/argonaut-pd", ini) || save;
    save = checkIniHasMapping("fhir.argonaut.scheduling", "http://fhir.org/guides/argonaut-scheduling", ini) || save;
    save = checkIniHasMapping("fhir.hspc.acog", "http://hl7.org/fhir/fpar", ini) || save;
    save = checkIniHasMapping("hl7.fhir.au.argonaut", "http://hl7.org.au/fhir/argonaut", ini) || save;
    save = checkIniHasMapping("hl7.fhir.au.base", "http://hl7.org.au/fhir/base", ini) || save;
    save = checkIniHasMapping("hl7.fhir.au.pd", "http://hl7.org.au/fhir/pd", ini) || save;
    save = checkIniHasMapping("hl7.fhir.smart", "http://hl7.org/fhir/smart-app-launch", ini) || save;
    save = checkIniHasMapping("hl7.fhir.snomed", "http://hl7.org/fhir/ig/snomed", ini) || save;
    save = checkIniHasMapping("hl7.fhir.test.v10", "http://hl7.org/fhir/test-ig-10", ini) || save;
    save = checkIniHasMapping("hl7.fhir.test.v30", "http://hl7.org/fhir/test", ini) || save;
    save = checkIniHasMapping("hl7.fhir.us.breastcancer", "http://hl7.org/fhir/us/breastcancer", ini) || save;
    save = checkIniHasMapping("hl7.fhir.us.ccda", "http://hl7.org/fhir/us/ccda", ini) || save;
    save = checkIniHasMapping("hl7.fhir.us.cds.opioids", "http://hl7.org/fhir/ig/opioid-cds", ini) || save;
    save = checkIniHasMapping("hl7.fhir.us.core", "http://hl7.org/fhir/us/core", ini) || save;
    save = checkIniHasMapping("hl7.fhir.us.dafresearch", "http://hl7.org/fhir/us/daf-research", ini) || save;
    save = checkIniHasMapping("hl7.fhir.us.ecr", "http://fhir.hl7.org/us/ecr", ini) || save;
    save = checkIniHasMapping("hl7.fhir.us.hai", "http://hl7.org/fhir/us/hai", ini) || save;
    save = checkIniHasMapping("hl7.fhir.us.hedis", "http://hl7.org/fhir/us/hedis", ini) || save;
    save = checkIniHasMapping("hl7.fhir.us.meds", "http://hl7.org/fhir/us/meds", ini) || save;
    save = checkIniHasMapping("hl7.fhir.us.qicore", "http://hl7.org/fhir/us/qicore", ini) || save;
    save = checkIniHasMapping("hl7.fhir.us.sdc", "http://hl7.org/fhir/us/sdc", ini) || save;
    save = checkIniHasMapping("hl7.fhir.us.sdcde", "http://hl7.org/fhir/us/sdcde", ini) || save;
    save = checkIniHasMapping("hl7.fhir.uv.genomicsreporting", "http://hl7.org/fhir/uv/genomics-reporting", ini) || save;
    save = checkIniHasMapping("hl7.fhir.uv.immds", "http://hl7.org/fhir/uv/cdsi", ini) || save;
    save = checkIniHasMapping("hl7.fhir.uv.ips", "http://hl7.org/fhir/uv/ips", ini) || save;
    save = checkIniHasMapping("hl7.fhir.uv.phd", "http://hl7.org/fhir/devices", ini) || save;
    save = checkIniHasMapping("hl7.fhir.uv.vhdir", "http://hl7.org/fhir/ig/vhdir", ini) || save;
    save = checkIniHasMapping("hl7.fhir.vn.base", "http://hl7.org/fhir/ig/vietnam", ini) || save;
    save = checkIniHasMapping("hl7.fhir.uv.bulkdata", "http://hl7.org/fhir/uv/bulkdata", ini) || save;
    save = checkIniHasMapping("hl7.fhir.us.bulkdata", "http://hl7.org/fhir/uv/bulkdata", ini) || save;
    save = checkIniHasMapping("hl7.fhir.vocabpoc", "http://hl7.org/fhir/ig/vocab-poc", ini) || save;
    return save;
  }

  private boolean checkIniHasMapping(String pid, String curl, IniFile ini) {
    if (curl.equals(ini.getStringProperty("urls", pid)))
      return false;
    ini.setStringProperty("urls", pid, curl, null);
    return true;
  }

  public void recordMap(String url, String id) throws IOException {
    if (url == null)
      return;
    
    if (!(new File(Utilities.path(cacheFolder, "packages.ini")).exists()))
        throw new Error("File "+Utilities.path(cacheFolder, "packages.ini")+" not found #1");
    IniFile ini = new IniFile(Utilities.path(cacheFolder, "packages.ini"));
    ini.setStringProperty("urls", id, url, null);
    if (!CACHE_VERSION.equals(ini.getStringProperty("cache", "version"))) {
      throw new Error("File "+Utilities.path(cacheFolder, "packages.ini")+" cache version mismatch: expected '"+CACHE_VERSION+"', found '"+ini.getStringProperty("cache", "version")+"'");
    }
    if (!(new File(Utilities.path(cacheFolder, "packages.ini")).exists()))
      throw new Error("File "+Utilities.path(cacheFolder, "packages.ini")+" not found #2");

    ini.save();
    if (!(new File(Utilities.path(cacheFolder, "packages.ini")).exists()))
      throw new Error("File "+Utilities.path(cacheFolder, "packages.ini")+" not found #3");
  }

  public String getPackageUrl(String id) throws IOException {
    IniFile ini = new IniFile(Utilities.path(cacheFolder, "packages.ini"));
    return ini.getStringProperty("urls", id); 
  }
  
  public String getPackageId(String url) throws IOException {
    IniFile ini = new IniFile(Utilities.path(cacheFolder, "packages.ini"));
    String[] ids = ini.getPropertyNames("urls");
    if (ids != null) {
      for (String id : ids) {
        if (url.equals(ini.getStringProperty("urls", id)))
          return id;
      }
    }
    return null;
  }
  
  public void loadFromBuildServer() throws IOException, ParseException {
    buildLoaded = true; // whether it succeeds or not
    URL url = new URL("https://build.fhir.org/ig/qas.json?nocache=" + System.currentTimeMillis());
    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    connection.setRequestMethod("GET");
    InputStream json = connection.getInputStream();
    buildInfo = (JsonArray) new com.google.gson.JsonParser().parse(TextFile.streamToString(json));
  
    List<BuildRecord> builds = new ArrayList<>();
    
    for (JsonElement n : buildInfo) {
      JsonObject o = (JsonObject) n;
      if (o.has("url") && o.has("package-id") && o.get("package-id").getAsString().contains(".")) {
        String u = o.get("url").getAsString();
        if (u.contains("/ImplementationGuide/"))
          u = u.substring(0, u.indexOf("/ImplementationGuide/"));
        builds.add(new BuildRecord(u, o.get("package-id").getAsString(), o.get("repo").getAsString(), readDate(o.get("date").getAsString())));
      }
    }
    Collections.sort(builds, new BuildRecordSorter());
    for (BuildRecord bld : builds) {
      if (!ciList.containsKey(bld.getPackageId())) {
        recordMap(bld.getUrl(), bld.getPackageId());
        ciList.put(bld.getPackageId(), "https://build.fhir.org/ig/"+bld.getRepo());        
      }
    }
  }

  private Date readDate(String s) throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM, yyyy HH:mm:ss Z");
    return sdf.parse(s);
  }

  public boolean isBuildLoaded() {
    return buildLoaded;
  }


  public String buildPath(String url) {
    for (JsonElement e : buildInfo) {
      JsonObject j = (JsonObject) e;
      if (j.has("url") && (url.equals(j.get("url").getAsString()) || j.get("url").getAsString().startsWith(url+"/ImplementationGuide"))) {
        return "https://build.fhir.org/ig/"+j.get("repo").getAsString();
      }
    }
    return null;
  }
 
  public boolean checkBuildLoaded() throws IOException, ParseException {
    if (isBuildLoaded())
      return true;
    loadFromBuildServer();
    return false;
  }
  
  public Map<String, String> getCiList() {
    return ciList;
  }

  public List<String> getUrls() throws IOException {
    if (allUrls == null)
    {
      IniFile ini = new IniFile(Utilities.path(cacheFolder, "packages.ini"));
      allUrls = new ArrayList<>();
      for (String s : ini.getPropertyNames("urls"))
        allUrls.add(ini.getStringProperty("urls", s));
      try {
        URL url = new URL("https://raw.githubusercontent.com/FHIR/ig-registry/master/fhir-ig-list.json?nocache=" + System.currentTimeMillis());
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        InputStream json = connection.getInputStream();
        JsonObject packages = (JsonObject) new com.google.gson.JsonParser().parse(TextFile.streamToString(json));
        JsonArray guides = packages.getAsJsonArray("guides");
        for (JsonElement g : guides) {
          JsonObject gi = (JsonObject) g;
          if (gi.has("canonical"))
            if (!allUrls.contains(gi.get("canonical").getAsString()))
              allUrls.add(gi.get("canonical").getAsString());
        }
      } catch (Exception e) {
        System.out.println("Listing known Implementation Guides failed: "+e.getMessage());
      }
    }
    return allUrls;    
  }

  // ========================= Package API ============================================================================

  public void removePackage(String id, String ver) throws IOException  {
    String f = Utilities.path(cacheFolder, id+"#"+ver);
    Utilities.clearDirectory(f);    
    IniFile ini = new IniFile(Utilities.path(cacheFolder, "packages.ini"));
    ini.removeProperty("packages", id+"#"+ver);
    ini.save();
    new File(f).delete();
  }

  /**
   * get the latest version of the package from what is in the cache
   * @param id
   * @return
   * @throws IOException
   */
  public NpmPackage loadPackageFromCacheOnly(String id) throws IOException {
    List<String> l = sorted(new File(cacheFolder).list());
    for (int i = l.size()-1; i >= 0; i--) {
      String f = l.get(i);
      if (f.startsWith(id+"#")) {
        return loadPackageInfo(Utilities.path(cacheFolder, f)); 
      }
    }
    return null;    
  }
  
  /** 
   * Load the identified package from the cache - it it exists 
   * 
   * This is for special purpose only. Generally, use the loadPackage method
   *  
   * @param id
   * @param version
   * @return
   * @throws IOException
   */
  public NpmPackage loadPackageFromCacheOnly(String id, String version) throws IOException {
    for (NpmPackage p : temporaryPackages) {
      if (p.name().equals(id) && ("current".equals(version) || "dev".equals(version) || p.version().equals(version)))
        return p;
    }
    for (String f : sorted(new File(cacheFolder).list())) {
      if (f.equals(id+"#"+version)) {
        return loadPackageInfo(Utilities.path(cacheFolder, f)); 
      }
    }
    if ("dev".equals(version))
      return loadPackageFromCacheOnly(id, "current");
    else
      return null;
  }

  /**
   * Add an already fetched package to the cache
   */
  public NpmPackage addPackageToCache(String id, String version, InputStream tgz, String sourceDesc) throws IOException {
    if (progress ) {
      System.out.println("Installing "+id+"#"+(version == null ? "?" : version)+" to the package cache");
      System.out.print("  Fetching:");
    }
    
    NpmPackage npm = NpmPackage.fromPackage(tgz, sourceDesc, true);
    
    recordMap(npm.canonical(), npm.name());
    
    if (progress ) {
      System.out.println();
      System.out.print("  Installing: ");
    }
    if (npm.name() == null || id == null || !id.equals(npm.name())) {
      if (!id.equals("hl7.fhir.r5.core")) {// temporary work around
        throw new IOException("Attempt to import a mis-identified package. Expected "+id+", got "+npm.name());
      }
    }
    if (version == null)
      version = npm.version();
    
    String packRoot = Utilities.path(cacheFolder, id+"#"+version);
    Utilities.createDirectory(packRoot);
    Utilities.clearDirectory(packRoot);
      
    int i = 0;
    int c = 0;
    int size = 0;
    for (Entry<String, NpmPackageFolder> e : npm.getFolders().entrySet()) {
      String dir = e.getKey().equals("package") ? Utilities.path(packRoot, "package") : Utilities.path(packRoot, "package",  e.getKey());;
      if (!(new File(dir).exists()))
        Utilities.createDirectory(dir);
      for (Entry<String, byte[]> fe : e.getValue().getContent().entrySet()) {
        String fn = Utilities.path(dir, fe.getKey());
        byte[] cnt = fe.getValue();
        TextFile.bytesToFile(cnt, fn);
        size = size + cnt.length;
        i++;
        if (progress && i % 50 == 0) {
          c++;
          System.out.print(".");
          if (c == 120) {
            System.out.println("");
            System.out.print("  ");
            c = 2;
          }
        }    
      }
    }
 
    
    IniFile ini = new IniFile(Utilities.path(cacheFolder, "packages.ini"));
    ini.setTimeStampFormat("yyyyMMddhhmmss");
    ini.setTimestampProperty("packages", id+"#"+version, Timestamp.from(Instant.now()), null);
    ini.setIntegerProperty("package-sizes", id+"#"+version, size, null);
    ini.save();
    if (progress)
      System.out.println(" done.");

    NpmPackage pck = loadPackageInfo(packRoot);
    if (!id.equals(JSONUtil.str(npm.getNpm(), "name")) || !version.equals(JSONUtil.str(npm.getNpm(), "version"))) {
      if (!id.equals(JSONUtil.str(npm.getNpm(), "name"))) {
        npm.getNpm().addProperty("original-name", JSONUtil.str(npm.getNpm(), "name"));
        npm.getNpm().remove("name");
        npm.getNpm().addProperty("name", id);
      }
      if (!version.equals(JSONUtil.str(npm.getNpm(), "version"))) {
        npm.getNpm().addProperty("original-version", JSONUtil.str(npm.getNpm(), "version"));
        npm.getNpm().remove("version");
        npm.getNpm().addProperty("version", version);
      }
      TextFile.stringToFile(new GsonBuilder().setPrettyPrinting().create().toJson(npm.getNpm()), Utilities.path(cacheFolder, id+"#"+version, "package", "package.json"), false);
    }

    return pck;
  }

  public NpmPackage loadPackage(String id) throws FHIRException, IOException {
    throw new Error("Not done yet");
  }
  
  public NpmPackage loadPackage(String id, String v) throws FHIRException, IOException {
    NpmPackage p = loadPackageFromCacheOnly(id, v);
    if (p != null) {
      if ("current".equals(v)) {
        p = checkCurrency(id, p);
      }
      if (p != null)
        return p;
    }

    if ("dev".equals(v)) {
      p = loadPackageFromCacheOnly(id, "current");
      p = checkCurrency(id, p);
      if (p != null)
        return p;
      v = "current";
    }

    String url = getPackageUrl(id);
    if (url == null)
      throw new FHIRException("Unable to resolve the package '"+id+"'");
    if (url.contains(".tgz")) {
      InputStream stream = fetchFromUrlSpecific(url, true);
      if (stream != null)
        return addPackageToCache(id, v, stream, url);
      throw new FHIRException("Unable to find the package source for '"+id+"' at "+url);      
    }
    if (v == null) {
      InputStream stream = fetchFromUrlSpecific(Utilities.pathURL(url, "package.tgz"), true);
      if (stream == null && isBuildLoaded()) { 
        stream = fetchFromUrlSpecific(Utilities.pathURL(buildPath(url), "package.tgz"), true);
      }
      if (stream != null)
        return addPackageToCache(id, null, stream, url);
      throw new FHIRException("Unable to find the package source for '"+id+"' at "+url);
    } else if ("current".equals(v) && ciList.containsKey(id)){
      InputStream stream = fetchFromUrlSpecific(Utilities.pathURL(ciList.get(id), "package.tgz"), true);
      return addPackageToCache(id, v, stream, Utilities.pathURL(ciList.get(id), "package.tgz"));
    } else {
      String pu = Utilities.pathURL(url, "package-list.json");
      JsonObject json;
      try {
        json = fetchJson(pu);
      } catch (Exception e) {
        String pv = Utilities.pathURL(url, v, "package.tgz");
        try {
          InputStream stream = fetchFromUrlSpecific(pv, true);
          return addPackageToCache(id, v, stream, pv);
        } catch (Exception e1) {
          throw new FHIRException("Error fetching package directly ("+pv+"), or fetching package list for "+id+" from "+pu+": "+e1.getMessage(), e1);
        }  
      }
      if (!id.equals(JSONUtil.str(json, "package-id")))
        throw new FHIRException("Package ids do not match in "+pu+": "+id+" vs "+JSONUtil.str(json, "package-id"));
      for (JsonElement e : json.getAsJsonArray("list")) {
        JsonObject vo = (JsonObject) e;
        if (v.equals(JSONUtil.str(vo, "version"))) {
          InputStream stream = fetchFromUrlSpecific(Utilities.pathURL(JSONUtil.str(vo, "path"), "package.tgz"), true);
          if (stream == null)
            throw new FHIRException("Unable to find the package source for '"+id+"#"+v+"' at "+Utilities.pathURL(JSONUtil.str(vo, "path"), "package.tgz"));
          return addPackageToCache(id, v, stream, Utilities.pathURL(JSONUtil.str(vo, "path"), "package.tgz"));
        }
      }
//      // special case: current version
//      if (id.equals("hl7.fhir.core") && v.equals(currentVersion)) {
//        InputStream stream = fetchFromUrlSpecific(Utilities.pathURL("http://build.fhir.org", "package.tgz"), true);
//        if (stream == null)
//          throw new FHIRException("Unable to find the package source for '"+id+"#"+v+"' at "+Utilities.pathURL("http://build.fhir.org", "package.tgz"));
//        return addPackageToCache(id, v, stream);
//      }
      throw new FHIRException("Unable to resolve version "+v+" for package "+id);
    }
  }


//  public void loadFromFolder(String packagesFolder) throws IOException {
//    for (File f : new File(packagesFolder).listFiles()) {
//      if (f.getName().endsWith(".tgz")) {
//        temporaryPackages.add(extractLocally(new FileInputStream(f), f.getName()));
//      }
//    }
//  }
//

  /**
   * turn true if a package exists
   * @param id
   * @param version
   * @return
   */
  public boolean hasPackage(String id, String version) {
    for (NpmPackage p : temporaryPackages) {
      if (p.name().equals(id) && ("current".equals(version) || "dev".equals(version) || p.version().equals(version)))
        return true;
    }
    for (String f : sorted(new File(cacheFolder).list())) {
      if (f.equals(id+"#"+version)) {
        return true; 
      }
    }
    if ("dev".equals(version))
      return hasPackage(id, "current");
    else
      return false;
  }


  /**
   * List which versions of a package are available
   * 
   * @param url
   * @return
   * @throws IOException
   */

  public VersionHistory listVersions(String url) throws IOException {
    if (historyCache.containsKey(url))
      return historyCache.get(url);
    
    URL url1 = new URL(Utilities.pathURL(url, "package-list.json")+"?nocache=" + System.currentTimeMillis());
    HttpURLConnection connection = (HttpURLConnection) url1.openConnection();
    connection.setRequestMethod("GET");
    InputStream json = connection.getInputStream();
    JsonObject packageList = (JsonObject) new com.google.gson.JsonParser().parse(TextFile.streamToString(json));
    VersionHistory res = new VersionHistory();
    res.id = JSONUtil.str(packageList, "package-id");
    res.canonical = JSONUtil.str(packageList, "canonical");
    for (JsonElement j : packageList.getAsJsonArray("list")) {
      JsonObject jo = (JsonObject) j;
      if ("current".equals(JSONUtil.str(jo, "version")))
        res.current = JSONUtil.str(jo, "path");
      else
        res.versions.put(JSONUtil.str(jo, "version"), JSONUtil.str(jo, "path"));
    }
    historyCache.put(url, res);
    return res;
  }


  /**
   * Clear the cache
   * 
   * @throws IOException
   */
  public void clear() throws IOException {
    clearCache();
  }
    
  public void loadFromFolder(String packagesFolder) throws IOException {
    for (File f : new File(packagesFolder).listFiles()) {
      if (f.getName().endsWith(".tgz")) {
        temporaryPackages.add(NpmPackage.fromPackage(new FileInputStream(f)));
      }
    }
  }
}
