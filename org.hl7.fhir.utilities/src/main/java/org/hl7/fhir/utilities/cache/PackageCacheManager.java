package org.hl7.fhir.utilities.cache;

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
import java.util.Locale;
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
import org.hl7.fhir.utilities.cache.PackageCacheManager.InputStreamWithSrc;
import org.hl7.fhir.utilities.cache.PackageClient.PackageInfo;
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

  public class InputStreamWithSrc {

    public InputStream stream;
    public String url;
    public String version;
    
    public InputStreamWithSrc(InputStream stream, String url, String version) {
      this.stream = stream;
      this.url = url;
      this.version = version;
    }
  }

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

  private static final String PRIMARY_SERVER = "http://packages.fhir.org";
  private static final String SECONDARY_SERVER = "http://packages2.fhir.org/packages";
//  private static final String SECONDARY_SERVER = "http://local.fhir.org:960/packages";
  public static final String PACKAGE_REGEX = "^[a-z][a-z0-9\\_\\-]*(\\.[a-z0-9\\_\\-]+)+$";
  public static final String PACKAGE_VERSION_REGEX = "^[a-z][a-z0-9\\_\\-]*(\\.[a-z0-9\\_\\-]+)+\\#[a-z0-9\\-\\_]+(\\.[a-z0-9\\-\\_]+)*$";
  private static final String CACHE_VERSION = "3"; // second version - see wiki page
  private String cacheFolder;
  private boolean progress = true;
  private List<NpmPackage> temporaryPackages = new ArrayList<NpmPackage>();
  
//  private List<String> allUrls;
//  private Map<String, VersionHistory> historyCache = new HashMap<>();
  
  // ========================= Initialization ============================================================================

  public PackageCacheManager(boolean userMode, int toolsVersion) throws IOException {
    if (userMode)
      cacheFolder = Utilities.path(System.getProperty("user.home"), ".fhir", "packages");
    else
      cacheFolder = Utilities.path("var", "lib", ".fhir", "packages");
    if (!(new File(cacheFolder).exists()))
      Utilities.createDirectory(cacheFolder);
    if (!(new File(Utilities.path(cacheFolder, "packages.ini")).exists()))
      TextFile.stringToFile("[cache]\r\nversion="+CACHE_VERSION+"\r\n\r\n[urls]\r\n\r\n[local]\r\n\r\n", Utilities.path(cacheFolder, "packages.ini"), false);  
    createIniFile();
  }

  public void loadFromFolder(String packagesFolder) throws IOException {
    File[] files = new File(packagesFolder).listFiles();
    if (files != null) {
      for (File f : files) {
        if (f.getName().endsWith(".tgz")) {
          temporaryPackages.add(NpmPackage.fromPackage(new FileInputStream(f)));
        }
      }
    }
  }
  
  // ========================= Utilities ============================================================================
  
  public String getFolder() {
    return cacheFolder;
  }

  private static String userDir() throws IOException {
    return Utilities.path(System.getProperty("user.home"), ".fhir", "packages");
  }

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

  private JsonObject fetchJson(String source) throws IOException {
    URL url = new URL(source);
    URLConnection c = url.openConnection();
    return (JsonObject) new com.google.gson.JsonParser().parse(TextFile.streamToString(c.getInputStream()));
  }
  
  private void clearCache() throws IOException {
    for (File f : new File(cacheFolder).listFiles()) {
      if (f.isDirectory()) {
        Utilities.clearDirectory(f.getAbsolutePath());
        FileUtils.deleteDirectory(f);
      }
      else if (!f.getName().equals("packages.ini"))
        FileUtils.forceDelete(f);
    }    
    IniFile ini = new IniFile(Utilities.path(cacheFolder, "packages.ini"));
    ini.removeSection("packages");
    ini.save();
  }

  private void createIniFile() throws IOException {
    IniFile ini = new IniFile(Utilities.path(cacheFolder, "packages.ini"));
    boolean save = false;
    String v = ini.getStringProperty("cache", "version");    
    if (!CACHE_VERSION.equals(v)) {
      clearCache();
      ini.setStringProperty("cache", "version", CACHE_VERSION, null);
      save = true;
    }
  }

  private void checkValidVersionString(String version, String id) {
    if (Utilities.noString(version)) {
      throw new FHIRException("Cannot add package "+id+" to the package cache - a version must be provided");
    }
    if (version.startsWith("file:")) {
      throw new FHIRException("Cannot add package "+id+" to the package cache - the version '"+version+"' is illegal in this context");
    }
    for (char ch : version.toCharArray()) {
      if (!Character.isAlphabetic(ch) && !Character.isDigit(ch) && !Utilities.existsInList(ch, '.', '-')) {
        throw new FHIRException("Cannot add package "+id+" to the package cache - the version '"+version+"' is illegal (ch '"+ch+"'");
      }
    }
  }

  private String getPackageId(String canonical, String server) throws IOException {
    PackageClient pc = new PackageClient(server);
    List<PackageInfo> res = pc.search(null, canonical, null, false);
    if (res.size() == 0) {
      return null;
    } else {
      // this is driven by HL7 Australia (http://hl7.org.au/fhir/ is the canonical url for the base package, and the root for all the others)
      for (PackageInfo pi : res) {
        if (canonical.equals(pi.getCanonical())) {
          return pi.getId();
        }
      }
      return res.get(0).getId();
    }
  }

  private String getPackageUrl(String packageId, String server) throws IOException {
    PackageClient pc = new PackageClient(server);
    List<PackageInfo> res = pc.search(packageId, null, null, false);
    if (res.size() == 0) {
      return null;
    } else {
      return res.get(0).getUrl();
    }
  }

  private void listSpecs(Map<String, String> specList, String server) throws IOException {
    PackageClient pc = new PackageClient(server);
    List<PackageInfo> matches = pc.search(null, null, null, false);
    for (PackageInfo m : matches) {
      if (!specList.containsKey(m.getId())) {
        specList.put(m.getId(), m.getUrl());
      }
    }    
  }

  private InputStreamWithSrc loadFromPackageServer(String id, String v) {
    // release hack:
    if ("4.4.0".equals(v)) {v = "4.2.0"; };
    PackageClient pc = new PackageClient(PRIMARY_SERVER);
    String u = null;
    InputStream stream;
    try {
      if (Utilities.noString(v)) {
        v = pc.getLatestVersion(id);
      }
      stream = pc.fetch(id, v);
      u = pc.url(id, v);
    } catch (IOException e) {
      pc = new PackageClient(SECONDARY_SERVER);
      try {
        if (Utilities.noString(v)) {
          v = pc.getLatestVersion(id);
        }
        stream = pc.fetch(id, v);
        u = pc.url(id, v);
      } catch (IOException e1) {
        // ok, well, we'll try the old way
        return fetchTheOldWay(id, v);
      }
    }
    return new InputStreamWithSrc(stream, pc.url(id, v), v);
  }

  public String getLatestVersion(String id) throws IOException {
    PackageClient pc = new PackageClient(PRIMARY_SERVER);
    try {
        return pc.getLatestVersion(id);
    } catch (IOException e) {
      pc = new PackageClient(SECONDARY_SERVER);
      try {
        return pc.getLatestVersion(id);
      } catch (IOException e1) {
        return fetchVersionTheOldWay(id);
      }
    }
  }



  private NpmPackage loadPackageFromFile(String id, String folder) throws IOException {
    File f = new File(Utilities.path(folder, id));
    if (!f.exists()) {
      throw new FHIRException("Package '"+id+"  not found in folder "+folder);
    }
    if (!f.isDirectory()) {
      throw new FHIRException("File for '"+id+"  found in folder "+folder+", not a folder");
    }
    File fp = new File(Utilities.path(folder, id, "package", "package.json"));
    if (!fp.exists()) {
      throw new FHIRException("Package '"+id+"  found in folder "+folder+", but does not contain a package.json file in /package");
    }
    return NpmPackage.fromFolder(f.getAbsolutePath());
  }


  // ========================= Package Mgmt API =======================================================================

  /**
   * Clear the cache
   * 
   * @throws IOException
   */
  public void clear() throws IOException {
    clearCache();
  }
    
  /**
   * Remove a particular package from the cache
   * 
   * @param id
   * @param ver
   * @throws IOException
   */
  public void removePackage(String id, String ver) throws IOException  {
    String f = Utilities.path(cacheFolder, id+"#"+ver);
    File ff = new File(f);
    if (ff.exists()) {    
      Utilities.clearDirectory(f);    
      IniFile ini = new IniFile(Utilities.path(cacheFolder, "packages.ini"));
      ini.removeProperty("packages", id+"#"+ver);
      ini.save();
      ff.delete();
    }
  }

  /**
   * Load the latest version of the identified package from the cache - it it exists
   * 
   * @param id
   * @return
   * @throws IOException
   */
  public NpmPackage loadPackageFromCacheOnly(String id) throws IOException {
    return loadPackageFromCacheOnly(id, null);    
  }
  
  /** 
   * Load the identified package from the cache - it it exists 
   * 
   * This is for special purpose only (testing, control over speed of loading). 
   * Generally, use the loadPackage method
   *  
   * @param id
   * @param version
   * @return
   * @throws IOException
   */
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
    for (String f : sorted(new File(cacheFolder).list())) {
      if (f.equals(id+"#"+version) || (Utilities.noString(version) && f.startsWith(id+"#"))) {
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
    checkValidVersionString(version, id);
    if (progress ) {
      System.out.println("Installing "+id+"#"+(version == null ? "?" : version)+" to the package cache");
      System.out.print("  Fetching:");
    }

    NpmPackage npm = NpmPackage.fromPackage(tgz, sourceDesc, true);

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
    try {
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
    } catch (Exception e) {
      try {
        // don't leave a half extracted package behind
        Utilities.clearDirectory(packRoot);
        new File(packRoot).delete();
      } catch (Exception ei) {
        // nothing
      }
      throw e;
    }
  }

  public String getPackageId(String canonical) throws IOException {
    String result = null;
    if (result == null) {
      result = getPackageId(canonical, PRIMARY_SERVER);
    }
    if (result == null) {
      result = getPackageId(canonical, SECONDARY_SERVER);
    }
    if (result == null) {
      result = getPackageIdFromBuildList(canonical);
    }
    return result;
  }

  public String getPackageUrl(String packageId) throws IOException {
    String result = null;
    NpmPackage npm = loadPackageFromCacheOnly(packageId);
    if (npm != null) {
      return npm.canonical();
    }      
    if (result == null) {
      getPackageUrl(packageId, PRIMARY_SERVER);
    }
    if (result == null) {
      result = getPackageUrl(packageId, SECONDARY_SERVER);
    }
    if (result == null) {
      result = getPackageUrlFromBuildList(packageId);
    }
    return result;
  }
  
  public void listAllIds(Map<String, String> specList) throws IOException {
    for (NpmPackage p : temporaryPackages) {
      specList.put(p.name(), p.canonical());
    }
    listSpecs(specList, PRIMARY_SERVER);
    listSpecs(specList, SECONDARY_SERVER);
    addCIBuildSpecs(specList);
  }

  public NpmPackage loadPackage(String id, String v) throws FHIRException, IOException {
    //ok, try to resolve locally
    if (!Utilities.noString(v) && v.startsWith("file:")) {
      return loadPackageFromFile(id, v.substring(5));
    }
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

    // nup, don't have it locally (or it's expired)
    InputStreamWithSrc source;
    if ("current".equals(v)) {
      // special case - fetch from ci-build server
      source = loadFromCIBuild(id);
    } else {
      source = loadFromPackageServer(id, v);
    }
    return addPackageToCache(id, v == null ? source.version : v, source.stream, source.url);
  }


  // ---------- Current Build SubSystem --------------------------------------------------------------------------------------

  private boolean buildLoaded = false;
  private Map<String, String> ciList = new HashMap<String, String>();
  private JsonArray buildInfo;

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
  
  private InputStreamWithSrc loadFromCIBuild(String id) throws IOException {
    checkBuildLoaded();
    if (ciList.containsKey(id)) {
      InputStream stream = fetchFromUrlSpecific(Utilities.pathURL(ciList.get(id), "package.tgz"), false);
      return new InputStreamWithSrc(stream, Utilities.pathURL(ciList.get(id), "package.tgz"), "current");
    } else if (id.startsWith("hl7.fhir.r5")) {
      InputStream stream = fetchFromUrlSpecific(Utilities.pathURL("http://hl7.org/fhir/2020Feb", id+".tgz"), false);
      return new InputStreamWithSrc(stream, Utilities.pathURL("http://hl7.org/fhir/2020Feb", id+".tgz"), "current");
    } else {
      throw new FHIRException("The package '"+id+"' has not entry on the current build server");
    }
  }
  
  private String getPackageIdFromBuildList(String canonical) throws IOException {
    checkBuildLoaded();
    if (buildInfo != null) {
      for (JsonElement n : buildInfo) {
        JsonObject o = (JsonObject) n;
        if (canonical.equals(JSONUtil.str(o, "url"))) {
          return JSONUtil.str(o, "package-id");
        }
      }
      for (JsonElement n : buildInfo) {
        JsonObject o = (JsonObject) n;
        if (JSONUtil.str(o, "url").startsWith(canonical+"/ImplementationGuide/")) {
          return JSONUtil.str(o, "package-id");
        }
      }
    }
    return null;
  }
  
  private String getPackageUrlFromBuildList(String packageId) throws IOException {
    checkBuildLoaded();
    for (JsonElement n : buildInfo) {
      JsonObject o = (JsonObject) n;
      if (packageId.equals(JSONUtil.str(o, "package-id"))) {
        return JSONUtil.str(o, "url");
      }
    }
    return null;
  }


  private void addCIBuildSpecs(Map<String, String> specList) throws IOException {
    checkBuildLoaded();
    for (JsonElement n : buildInfo) {
      JsonObject o = (JsonObject) n;
      if (!specList.containsKey(JSONUtil.str(o, "package-id"))) {
        specList.put(JSONUtil.str(o, "package-id"), JSONUtil.str(o, "url"));
      }
    }    
  }


  private NpmPackage checkCurrency(String id, NpmPackage p) throws IOException {
    checkBuildLoaded();
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
  
  private boolean checkBuildLoaded() {
    if (buildLoaded)
      return true;
    try {
      loadFromBuildServer();
    } catch (Exception e) {
      System.out.println("Error connecting to build server - running without build ("+e.getMessage()+")");
    }
    return false;
  }
  
  
  private void loadFromBuildServer() throws IOException {
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
        builds.add(new BuildRecord(u, o.get("package-id").getAsString(), getRepo(o.get("repo").getAsString()), readDate(o.get("date").getAsString())));
      }
    }
    Collections.sort(builds, new BuildRecordSorter());
    for (BuildRecord bld : builds) {
      if (!ciList.containsKey(bld.getPackageId())) {
        ciList.put(bld.getPackageId(), "https://build.fhir.org/ig/"+bld.getRepo());        
      }
    }
    buildLoaded = true; // whether it succeeds or not
  }

//  private String buildPath(String url) {
//    for (JsonElement e : buildInfo) {
//      JsonObject j = (JsonObject) e;
//      if (j.has("url") && (url.equals(j.get("url").getAsString()) || j.get("url").getAsString().startsWith(url+"/ImplementationGuide"))) {
//        return "https://build.fhir.org/ig/"+j.get("repo").getAsString();
//      }
//    }
//    return null;
//  }
// 
  private String getRepo(String path) {
    String[] p = path.split("\\/");
    return p[0]+"/"+p[1];
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
      } catch (Exception e) {
        url = null;
      }
    }
    if (url == null) {
      throw new FHIRException("Unable to resolve package id "+id+"#"+v);
    }
    if (url.contains("/ImplementationGuide/")) {
      url = url.substring(0, url.indexOf("/ImplementationGuide/"));
    }
    String pu = Utilities.pathURL(url, "package-list.json");
    String aurl = pu;
    JsonObject json;
    try {
      json = fetchJson(pu);
    } catch (Exception e) {
      String pv = Utilities.pathURL(url, v, "package.tgz");
      try {
        aurl = pv;
        InputStreamWithSrc src = new InputStreamWithSrc(fetchFromUrlSpecific(pv, true), pv, v);
        return src;
      } catch (Exception e1) {
        throw new FHIRException("Error fetching package directly ("+pv+"), or fetching package list for "+id+" from "+pu+": "+e1.getMessage(), e1);
      }  
    }
    if (!id.equals(JSONUtil.str(json, "package-id")))
      throw new FHIRException("Package ids do not match in "+pu+": "+id+" vs "+JSONUtil.str(json, "package-id"));
    for (JsonElement e : json.getAsJsonArray("list")) {
      JsonObject vo = (JsonObject) e;
      if (v.equals(JSONUtil.str(vo, "version"))) {
        aurl = Utilities.pathURL(JSONUtil.str(vo, "path"), "package.tgz");
        String u = Utilities.pathURL(JSONUtil.str(vo, "path"), "package.tgz");
        return new InputStreamWithSrc(fetchFromUrlSpecific(u, true), u, v);
      }
    }

    return null;
  }

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
      throw new FHIRException("Unable to resolve package id "+id);
    }
    String pu = Utilities.pathURL(url, "package-list.json");
    JsonObject json = fetchJson(pu);
    if (!id.equals(JSONUtil.str(json, "package-id")))
      throw new FHIRException("Package ids do not match in "+pu+": "+id+" vs "+JSONUtil.str(json, "package-id"));
    for (JsonElement e : json.getAsJsonArray("list")) {
      JsonObject vo = (JsonObject) e;
      if (JSONUtil.bool(vo, "current")) {
        return JSONUtil.str(vo, "version");
      }
    }

    return null;
  }

  private String getUrlForPackage(String id) {
    if ("hl7.fhir.xver-extensions".equals(id)) {
      return "http://fhir.org/packages/hl7.fhir.xver-extensions";
    }
    return null;
  }



//public List<String> getUrls() throws IOException {
//  if (allUrls == null)
//  {
//    IniFile ini = new IniFile(Utilities.path(cacheFolder, "packages.ini"));
//    allUrls = new ArrayList<>();
//    for (String s : ini.getPropertyNames("urls"))
//      allUrls.add(ini.getStringProperty("urls", s));
//    try {
//      URL url = new URL("https://raw.githubusercontent.com/FHIR/ig-registry/master/fhir-ig-list.json?nocache=" + System.currentTimeMillis());
//      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//      connection.setRequestMethod("GET");
//      InputStream json = connection.getInputStream();
//      JsonObject packages = (JsonObject) new com.google.gson.JsonParser().parse(TextFile.streamToString(json));
//      JsonArray guides = packages.getAsJsonArray("guides");
//      for (JsonElement g : guides) {
//        JsonObject gi = (JsonObject) g;
//        if (gi.has("canonical"))
//          if (!allUrls.contains(gi.get("canonical").getAsString()))
//            allUrls.add(gi.get("canonical").getAsString());
//      }
//    } catch (Exception e) {
//      System.out.println("Listing known Implementation Guides failed: "+e.getMessage());
//    }
//  }
//  return allUrls;    
//}
}