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
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorInputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorOutputStream;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.IniFile;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.cache.NpmPackage.IndexVersionSorter;
import org.hl7.fhir.utilities.cache.PackageCacheManager.PackageEntry;
import org.hl7.fhir.utilities.cache.PackageGenerator.PackageType;
import org.hl7.fhir.utilities.json.JSONUtil;
import org.hl7.fhir.utilities.json.JsonTrackingParser;

import com.google.common.base.Charsets;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * info and loader for a package 
 * 
 * Packages may exist on disk in the cache, or purely in memory when they are loaded on the fly
 * 
 * Packages are contained in subfolders (see the package spec). The FHIR resources will be in "package"
 * 
 * @author Grahame Grieve
 *
 */
public class NpmPackage {

  public class IndexVersionSorter implements Comparator<JsonObject> {

    @Override
    public int compare(JsonObject o0, JsonObject o1) {
      String v0 = JSONUtil.str(o0, "version"); 
      String v1 = JSONUtil.str(o1, "version"); 
      return v0.compareTo(v1);
    }
  }

  public static boolean isValidName(String pid) {
    return pid.matches("^[a-z][a-zA-Z0-9]*(\\.[a-z][a-zA-Z0-9\\-]*)+$");
  }

  public static boolean isValidVersion(String ver) {
    return ver.matches("^[0-9]+\\.[0-9]+\\.[0-9]+$");
  }

  public class NpmPackageFolder {
    private String name;
    private Map<String, List<String>> types = new HashMap<>();
    private Map<String, byte[]> content = new HashMap<String, byte[]>(); 
    private JsonObject index;
    private File folder;

    public NpmPackageFolder(String name) {
      super();
      this.name = name;
    }

    public String getName() {
      return name;
    }

    public void readIndex(JsonObject index) {
      this.index = index;
      for (JsonElement e : index.getAsJsonArray("files")) {
        JsonObject file = (JsonObject) e;
        String type = JSONUtil.str(file, "resourceType");
        String name = JSONUtil.str(file, "filename");
        if (!types.containsKey(type))
          types.put(type, new ArrayList<>());
        types.get(type).add(name);
      }
    }

    public List<String> listFiles() {
      List<String> res = new ArrayList<>();
      if (folder != null) {
        for (File f : folder.listFiles()) {
          if (!f.isDirectory() && !Utilities.existsInList(f.getName(), "package.json", ".index.json")) {
            res.add(f.getName());
          }
        }
      } else {
        for (String s : content.keySet()) {
          if (!Utilities.existsInList(s, "package.json", ".index.json")) {
            res.add(s);
          }
        }
      }
      Collections.sort(res);
      return res;
    }

    public Map<String, byte[]> getContent() {
      return content;
    }

    public byte[] fetchFile(String file) throws FileNotFoundException, IOException {
      if (folder != null) {
        File f = new File(Utilities.path(folder.getAbsolutePath(), file));
        if (f.exists()) {
          return TextFile.fileToBytes(f);
        } else {
          return null;
        }
      } else {
        return content.get(file);
      }
    }

    public boolean hasFile(String file) throws IOException {
      if (folder != null) {
        return new File(Utilities.path(folder.getAbsolutePath(), file)).exists();
      } else {
        return content.containsKey(file);
      }

    }

    public String dump() {
      return name + " ("+ (folder == null ? "null" : folder.toString())+") | "+Boolean.toString(index != null)+" | "+content.size()+" | "+types.size();
    }

    public void removeFile(String n) throws IOException {
      if (folder != null) {
        new File(Utilities.path(folder.getAbsolutePath(), n)).delete();
      } else {
        content.remove(n);
      }
      changedByLoader = true;      
    }

  }

  private String path;
  private JsonObject npm;
  private Map<String, NpmPackageFolder> folders = new HashMap<>();
  private boolean changedByLoader; // internal qa only!

  private NpmPackage() {

  }
  //  public NpmPackage(JsonObject npm, Map<String, byte[]> content, List<String> folders) {
  //    this.path = null;
  //    this.content = content;
  //    this.npm = npm;
  //    this.folders = folders;
  //  }

  public static NpmPackage fromFolder(String path) throws IOException {
    NpmPackage res = new NpmPackage();
    loadFiles(res, path, new File(path));
    res.checkIndexed(path);
    return res;
  }

  public static void loadFiles(NpmPackage res, String path, File source, String... exemptions) throws FileNotFoundException, IOException {
    res.npm = (JsonObject) new com.google.gson.JsonParser().parse(TextFile.fileToString(Utilities.path(path, "package", "package.json")));
    res.path = path;
    
    File dir = new File(path);
    for (File f : dir.listFiles()) {
      if (!isInternalExemptFile(f) && !Utilities.existsInList(f.getName(), exemptions)) {
        if (f.isDirectory()) {
          String d = f.getName();
          if (!d.equals("package")) {
            d = Utilities.path("package", d);
          }
          NpmPackageFolder folder = res.new NpmPackageFolder(d);
          folder.folder = f;
          res.folders.put(d, folder);
          File ij = new File(Utilities.path(f.getAbsolutePath(), ".index.json"));
          if (ij.exists()) {
            try {
              folder.readIndex(JsonTrackingParser.parseJson(ij));
            } catch (Exception e) {
              throw new IOException("Error parsing "+ij.getAbsolutePath()+": "+e.getMessage(), e);
            }
          }
          loadSubFolders(res, dir.getAbsolutePath(), f);
        } else {
          NpmPackageFolder folder = res.new NpmPackageFolder(Utilities.path("package", "$root"));
          folder.folder = dir;
          res.folders.put(Utilities.path("package", "$root"), folder);        
        }
      }
    }
  }

  public static boolean isInternalExemptFile(File f) {
    return Utilities.existsInList(f.getName(), ".git", ".svn") || Utilities.existsInList(f.getName(), "package-list.json");
  }

  private static void loadSubFolders(NpmPackage res, String rootPath, File dir) throws IOException {
    for (File f : dir.listFiles()) {
      if (f.isDirectory()) {
        String d = f.getAbsolutePath().substring(rootPath.length()+1);
        if (!d.startsWith("package")) {
          d = Utilities.path("package", d);
        }
        NpmPackageFolder folder = res.new NpmPackageFolder(d);
        folder.folder = f;
        res.folders.put(d, folder);
        File ij = new File(Utilities.path(f.getAbsolutePath(), ".index.json"));
        if (ij.exists()) {
          try {
            folder.readIndex(JsonTrackingParser.parseJson(ij));
          } catch (Exception e) {
            throw new IOException("Error parsing "+ij.getAbsolutePath()+": "+e.getMessage(), e);
          }
        }
        loadSubFolders(res, rootPath, f);
        
      }
    }    
  }

  public static NpmPackage fromFolder(String folder, PackageType defType, String... exemptions) throws IOException {
    NpmPackage res = new NpmPackage();
    loadFiles(res, folder, new File(folder), exemptions);
    if (!res.folders.containsKey("package")) {
      res.folders.put("package", res.new NpmPackageFolder("package"));
    }
    if (!res.folders.get("package").hasFile("package.json") && defType != null) {
      TextFile.stringToFile("{ \"type\" : \""+defType.getCode()+"\"}", Utilities.path(res.folders.get("package").folder.getAbsolutePath(), "package.json"));
    }
    res.npm = (JsonObject) new com.google.gson.JsonParser().parse(new String(res.folders.get("package").fetchFile("package.json")));
    return res;
  }

  private static final int BUFFER_SIZE = 1024;

  public static NpmPackage fromPackage(InputStream tgz) throws IOException {
    return fromPackage(tgz, null, false);
  }

  public static NpmPackage fromPackage(InputStream tgz, String desc) throws IOException {
    return fromPackage(tgz, desc, false);
  }

  public static NpmPackage fromPackage(InputStream tgz, String desc, boolean progress) throws IOException {
    NpmPackage res = new NpmPackage();
    res.readStream(tgz, desc, progress);
    return res;
  }

  public void readStream(InputStream tgz, String desc, boolean progress) throws IOException {
    GzipCompressorInputStream gzipIn;
    try {
      gzipIn = new GzipCompressorInputStream(tgz);
    } catch (Exception e) {
      throw new IOException("Error reading "+(desc == null ? "package" : desc)+": "+e.getMessage(), e);      
    }
    try (TarArchiveInputStream tarIn = new TarArchiveInputStream(gzipIn)) {
      TarArchiveEntry entry;

      int i = 0;
      int c = 12;
      while ((entry = (TarArchiveEntry) tarIn.getNextEntry()) != null) {
        i++;
        String n = entry.getName();
        if (entry.isDirectory()) {
          String dir = n.substring(0, n.length()-1);
          if (dir.startsWith("package/")) {
            dir = dir.substring(8);
          }
          folders.put(dir, new NpmPackageFolder(dir));
        } else {
          int count;
          byte data[] = new byte[BUFFER_SIZE];
          ByteArrayOutputStream fos = new ByteArrayOutputStream();
          try (BufferedOutputStream dest = new BufferedOutputStream(fos, BUFFER_SIZE)) {
            while ((count = tarIn.read(data, 0, BUFFER_SIZE)) != -1) {
              dest.write(data, 0, count);
            }
          }
          fos.close();
          loadFile(n, fos.toByteArray());
        }
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
    try {
      npm = JsonTrackingParser.parseJson(folders.get("package").fetchFile("package.json"));
    } catch (Exception e) {
      throw new IOException("Error parsing "+(desc == null ? "" : desc+"#")+"package/package.json: "+e.getMessage(), e);
    }
    checkIndexed(desc);
  }

  public void loadFile(String n, byte[] data) throws IOException {
    String dir = n.contains("/") ? n.substring(0, n.lastIndexOf("/")) : "$root";
    if (dir.startsWith("package/")) {
      dir = dir.substring(8);
    }
    n = n.substring(n.lastIndexOf("/")+1);
    NpmPackageFolder index = folders.get(dir);
    if (index == null) {
      index = new NpmPackageFolder(dir);
      folders.put(dir, index);
    }
    index.content.put(n, data);
  }

  private void checkIndexed(String desc) throws IOException {
    for (NpmPackageFolder folder : folders.values()) {
      List<String> remove = new ArrayList<>();
      if (folder.index == null) {
        NpmPackageIndexBuilder indexer = new NpmPackageIndexBuilder();
        indexer.start();
        for (String n : folder.listFiles()) {
          if (!indexer.seeFile(n, folder.fetchFile(n))) {
            remove.add(n);
          }
        } 
        for (String n : remove) {
          folder.removeFile(n);
        }
        String json = indexer.build();
        try {
          folder.readIndex(JsonTrackingParser.parseJson(json));
        } catch (Exception e) {
          TextFile.stringToFile(json, Utilities.path("[tmp]", ".index.json"));
          throw new IOException("Error parsing "+(desc == null ? "" : desc+"#")+"package/"+folder.name+"/.index.json: "+e.getMessage(), e);
        }
      }
    }
  }


  public static NpmPackage fromZip(InputStream stream, boolean dropRootFolder, String desc) throws IOException {
    NpmPackage res = new NpmPackage();
    ZipInputStream zip = new ZipInputStream(stream);
    ZipEntry ze;
    while ((ze = zip.getNextEntry()) != null) {
      int size;
      byte[] buffer = new byte[2048];

      ByteArrayOutputStream bytes = new ByteArrayOutputStream();
      BufferedOutputStream bos = new BufferedOutputStream(bytes, buffer.length);

      while ((size = zip.read(buffer, 0, buffer.length)) != -1) {
        bos.write(buffer, 0, size);
      }
      bos.flush();
      bos.close();
      if (bytes.size() > 0) {
        if (dropRootFolder) {
          res.loadFile(ze.getName().substring(ze.getName().indexOf("/")+1), bytes.toByteArray());
        } else {
          res.loadFile(ze.getName(), bytes.toByteArray());
        }
      }
      zip.closeEntry();
    }
    zip.close();         
    try {
      res.npm = JsonTrackingParser.parseJson(res.folders.get("package").fetchFile("package.json"));
    } catch (Exception e) {
      throw new IOException("Error parsing "+(desc == null ? "" : desc+"#")+"package/package.json: "+e.getMessage(), e);
    }
    res.checkIndexed(desc);
    return res;
  }


  /**
   * Accessing the contents of the package - get a list of files in a subfolder of the package 
   *
   * @param folder
   * @return
   * @throws IOException 
   */
  public List<String> list(String folder) throws IOException {
    List<String> res = new ArrayList<String>();
    if (folders.containsKey(folder)) {
      res.addAll(folders.get(folder).listFiles());
    } else if (folders.containsKey(Utilities.path("package", folder))) {
      res.addAll(folders.get(Utilities.path("package", folder)).listFiles());
    }
    return res;
  }

  public List<String> listResources(String... types) throws IOException {
    List<String> res = new ArrayList<String>();
    NpmPackageFolder folder = folders.get("package");
    for (String s : types) {
      if (folder.types.containsKey(s))
        res.addAll(folder.types.get(s));
    }
    Collections.sort(res);
    return res;
  }

  /**
   * use the name from listResources()
   * 
   * @param id
   * @return
   * @throws IOException
   */
  public InputStream loadResource(String file) throws IOException {
    NpmPackageFolder folder = folders.get("package");
    return new ByteArrayInputStream(folder.fetchFile(file));
  }

  /**
   * get a stream that contains the contents of a resource in the base folder, by it's canonical URL
   * 
   * @param url - the canonical URL of the resource (exact match only)
   * @return null if it is not found
   * @throws IOException
   */
  public InputStream loadByCanonical(String canonical) throws IOException {
    return loadByCanonicalVersion("package", canonical, null);    
  }
  
  /**
   * get a stream that contains the contents of a resource in the nominated folder, by it's canonical URL
   * 
   * @param folder - one of the folders in the package (main folder is "package")
   * @param url - the canonical URL of the resource (exact match only)
   * @return null if it is not found
   * @throws IOException
   */
  public InputStream loadByCanonical(String folder, String canonical) throws IOException {
    return loadByCanonicalVersion(folder, canonical, null);    
  }
    
  /**
   * get a stream that contains the contents of a resource in the base folder, by it's canonical URL
   * 
   * @param url - the canonical URL of the resource (exact match only)
   * @param version - the specified version (or null if the most recent)
   * 
   * @return null if it is not found
   * @throws IOException
   */
  public InputStream loadByCanonicalVersion(String canonical, String version) throws IOException {
    return loadByCanonicalVersion("package", canonical, version);
  }
  
  /**
   * get a stream that contains the contents of a resource in the nominated folder, by it's canonical URL
   * 
   * @param folder - one of the folders in the package (main folder is "package")
   * @param url - the canonical URL of the resource (exact match only)
   * @param version - the specified version (or null if the most recent)
   * 
   * @return null if it is not found
   * @throws IOException
   */
  public InputStream loadByCanonicalVersion(String folder, String canonical, String version) throws IOException {
    NpmPackageFolder f = folders.get(folder);
    List<JsonObject> matches = new ArrayList<>();
    for (JsonElement e : f.index.getAsJsonArray("files")) {
      JsonObject file = (JsonObject) e;
      if (canonical.equals(JSONUtil.str(file, "url"))) {
        if (version != null && version.equals(JSONUtil.str(file, "version"))) {
          return load("package", JSONUtil.str(file, "filename"));
        } else if (version == null) {
          matches.add(file);
        }
      }
      if (matches.size() > 0) {
        if (matches.size() == 1) {
          return load("package", JSONUtil.str(matches.get(0), "filename"));          
        } else {
          Collections.sort(matches, new IndexVersionSorter());
          return load("package", JSONUtil.str(matches.get(matches.size()-1), "filename"));          
        }
      }
    }
    return null;        
  }
    
  /**
   * get a stream that contains the contents of one of the files in the base package
   * 
   * @param file
   * @return
   * @throws IOException
   */
  public InputStream load(String file) throws IOException {
    return load("package", file);
  }
  /**
   * get a stream that contains the contents of one of the files in a folder
   * 
   * @param folder
   * @param file
   * @return
   * @throws IOException
   */
  public InputStream load(String folder, String file) throws IOException {
    NpmPackageFolder f = folders.get(folder);
    if (f == null) {
      f = folders.get(Utilities.path("package", folder));
    }
    if (f != null && f.hasFile(file)) {
      return new ByteArrayInputStream(f.fetchFile(file));
    } else {
      throw new IOException("Unable to find the file "+folder+"/"+file+" in the package "+name());
    }
  }

  public boolean hasFile(String folder, String file) throws IOException {
    NpmPackageFolder f = folders.get(folder);
    return f != null && f.hasFile(file);
  }


  /**
   * Handle to the package json file
   * 
   * @return
   */
  public JsonObject getNpm() {
    return npm;
  }

  /**
   * convenience method for getting the package name
   * @return
   */
  public String name() {
    return JSONUtil.str(npm, "name");
  }

  /**
   * convenience method for getting the package id (which in NPM language is the same as the name)
   * @return
   */
  public String id() {
    return JSONUtil.str(npm, "name");
  }

  public String date() {
    return JSONUtil.str(npm, "date");
  }

  public String canonical() {
    return JSONUtil.str(npm, "canonical");
  }

  /**
   * convenience method for getting the package version
   * @return
   */
  public String version() {
    return JSONUtil.str(npm, "version");
  }

  /**
   * convenience method for getting the package fhir version
   * @return
   */
  public String fhirVersion() {
    if ("hl7.fhir.core".equals(JSONUtil.str(npm, "name")))
      return JSONUtil.str(npm, "version");
    else if (JSONUtil.str(npm, "name").startsWith("hl7.fhir.r2.") || JSONUtil.str(npm, "name").startsWith("hl7.fhir.r2b.") || JSONUtil.str(npm, "name").startsWith("hl7.fhir.r3.") || JSONUtil.str(npm, "name").startsWith("hl7.fhir.r4.") || JSONUtil.str(npm, "name").startsWith("hl7.fhir.r5."))
      return JSONUtil.str(npm, "version");
    else {        
      JsonObject dep = npm.getAsJsonObject("dependencies");
      if (dep != null) {
        for (Entry<String, JsonElement> e : dep.entrySet()) {
          if (Utilities.existsInList(e.getKey(), "hl7.fhir.r2.core", "hl7.fhir.r2b.core", "hl7.fhir.r3.core", "hl7.fhir.r4.core"))
            return e.getValue().getAsString();
          if (Utilities.existsInList(e.getKey(), "hl7.fhir.core")) // while all packages are updated
            return e.getValue().getAsString();
        }
      }
      if (npm.has("fhirVersions")) {
        JsonElement e = npm.get("fhirVersions");
        if (e.isJsonArray() && e.getAsJsonArray().size() > 0) {
          return npm.getAsJsonArray("fhirVersions").get(0).getAsString();
        }
      }
      if (dep != null) {
        // legacy simplifier support:
        if (dep.has("simplifier.core.r4"))
          return "4.0";
        if (dep.has("simplifier.core.r3"))
          return "3.0";
        if (dep.has("simplifier.core.r2"))
          return "2.0";
      }
      throw new FHIRException("no core dependency or FHIR Version found in the Package definition");
    }
  }

  public String summary() {
    if (path != null)
      return path;
    else
      return "memory";
  }

  public boolean isType(PackageType template) {
    return template.getCode().equals(type());
  }

  public String type() {
    return JSONUtil.str(npm, "type");
  }

  public String description() {
    return JSONUtil.str(npm, "description");
  }

  public String getPath() {
    return path;
  }

  public List<String> dependencies() {
    List<String> res = new ArrayList<>();
    if (npm.has("dependencies")) {
      for (Entry<String, JsonElement> e : npm.getAsJsonObject("dependencies").entrySet()) {
        res.add(e.getKey()+"#"+e.getValue().getAsString());
      }
    }
    return res;
  }

  public String homepage() {
    return JSONUtil.str(npm, "homepage");
  }

  public String url() {
    return JSONUtil.str(npm, "url");
  }


  public String title() {
    return JSONUtil.str(npm, "title");
  }

  public String toolsVersion() {
    return JSONUtil.str(npm, "tools-version");
  }

  public String license() {
    return JSONUtil.str(npm, "license");
  }

  //  /**
  //   * only for use by the package manager itself
  //   * 
  //   * @param path
  //   */
  //  public void setPath(String path) {
  //    this.path = path;
  //  }

  public String getWebLocation() {
    if (npm.has("url")) {
      return npm.get("url").getAsString();
    } else {
      return JSONUtil.str(npm, "canonical");
    }
  }

  public InputStream loadResource(String type, String id) throws IOException {
    NpmPackageFolder f = folders.get("package");
    JsonArray files = f.index.getAsJsonArray("files");
    for (JsonElement e : files) {
      JsonObject i = (JsonObject) e;
      if (type.equals(JSONUtil.str(i, "resourceType")) && id.equals(JSONUtil.str(i, "id"))) {
        return load("package", JSONUtil.str(i, "filename"));
      }
    }
    return null;
  }

  public InputStream loadExampleResource(String type, String id) throws IOException {
    NpmPackageFolder f = folders.get("example");
    if (f != null) {
      JsonArray files = f.index.getAsJsonArray("files");
      for (JsonElement e : files) {
        JsonObject i = (JsonObject) e;
        if (type.equals(JSONUtil.str(i, "resourceType")) && id.equals(JSONUtil.str(i, "id"))) {
          return load("example", JSONUtil.str(i, "filename"));
        }
      }
    }
    return null;
  }

  /** special case when playing around inside the package **/
  public Map<String, NpmPackageFolder> getFolders() {
    return folders;
  }

  public void save(File directory) throws IOException {
    File dir = new File(Utilities.path(directory.getAbsolutePath(), name()));
    if (!dir.exists()) {
      Utilities.createDirectory(dir.getAbsolutePath());
    } else {
      Utilities.clearDirectory(dir.getAbsolutePath());
    }
    
    for (NpmPackageFolder folder : folders.values()) {
      String n = folder.name;

      File pd = new File(Utilities.path(dir.getAbsolutePath(), n));
      if (!pd.exists()) {
        Utilities.createDirectory(pd.getAbsolutePath());
      }
      NpmPackageIndexBuilder indexer = new NpmPackageIndexBuilder();
      indexer.start();
      for (String s : folder.content.keySet()) {
        byte[] b = folder.content.get(s);
        indexer.seeFile(s, b);
        if (!s.equals(".index.json") && !s.equals("package.json")) {
          TextFile.bytesToFile(b, Utilities.path(dir.getAbsolutePath(), n, s));
        }
      }
      byte[] cnt = indexer.build().getBytes(Charset.forName("UTF-8"));
      TextFile.bytesToFile(cnt, Utilities.path(dir.getAbsolutePath(), n, ".index.json"));
    }
    byte[] cnt = TextFile.stringToBytes(new GsonBuilder().setPrettyPrinting().create().toJson(npm), false);
    TextFile.bytesToFile(cnt, Utilities.path(dir.getAbsolutePath(), "package", "package.json"));
  }
  
  public void save(OutputStream stream) throws IOException {
    TarArchiveOutputStream tar;
    ByteArrayOutputStream OutputStream;
    BufferedOutputStream bufferedOutputStream;
    GzipCompressorOutputStream gzipOutputStream;

    OutputStream = new ByteArrayOutputStream();
    bufferedOutputStream = new BufferedOutputStream(OutputStream);
    gzipOutputStream = new GzipCompressorOutputStream(bufferedOutputStream);
    tar = new TarArchiveOutputStream(gzipOutputStream);


    for (NpmPackageFolder folder : folders.values()) {
      String n = folder.name;
      if (!"package".equals(n) && !(n.startsWith("package/") || n.startsWith("package\\"))) {
        n = "package/"+n;
      }
      NpmPackageIndexBuilder indexer = new NpmPackageIndexBuilder();
      indexer.start();
      for (String s : folder.content.keySet()) {
        byte[] b = folder.content.get(s);
        String name = n+"/"+s;
        indexer.seeFile(s, b);
        if (!s.equals(".index.json") && !s.equals("package.json")) {
          TarArchiveEntry entry = new TarArchiveEntry(name);
          entry.setSize(b.length);
          tar.putArchiveEntry(entry);
          tar.write(b);
          tar.closeArchiveEntry();
        }
      }
      byte[] cnt = indexer.build().getBytes(Charset.forName("UTF-8"));
      TarArchiveEntry entry = new TarArchiveEntry(n+"/.index.json");
      entry.setSize(cnt.length);
      tar.putArchiveEntry(entry);
      tar.write(cnt);
      tar.closeArchiveEntry();
    }
    byte[] cnt = TextFile.stringToBytes(new GsonBuilder().setPrettyPrinting().create().toJson(npm), false);
    TarArchiveEntry entry = new TarArchiveEntry("package/package.json");
    entry.setSize(cnt.length);
    tar.putArchiveEntry(entry);
    tar.write(cnt);
    tar.closeArchiveEntry();

    tar.finish();
    tar.close();
    gzipOutputStream.close();
    bufferedOutputStream.close();
    OutputStream.close();
    byte[] b = OutputStream.toByteArray();
    stream.write(b);
  }


  public Map<String, List<String>> getTypes() {
    return folders.get("package").types;
  }

  public String fhirVersionList() {
    if (npm.has("fhirVersions")) {
      CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder();
      for (JsonElement n : npm.getAsJsonArray("fhirVersions")) {
        b.append(n.getAsString());
      }
      return b.toString();
    } else
      return "";
  }

  public String dependencySummary() {
    if (npm.has("dependencies")) {
      CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder();
      for (Entry<String, JsonElement> e : npm.getAsJsonObject("dependencies").entrySet()) {
        b.append(e.getKey()+"#"+e.getValue().getAsString());
      }
      return b.toString();
    } else
      return "";
  }

  public void unPack(String dir) throws IOException {
    unPack (dir, false);
  }

  public void unPackWithAppend(String dir) throws IOException {
    unPack (dir, true);
  }

  public void unPack(String dir, boolean withAppend) throws IOException {
    for (NpmPackageFolder folder : folders.values()) {
      String dn = folder.getName();
      if (!dn.equals("package") && (dn.startsWith("package/") || dn.startsWith("package\\"))) {
        dn = dn.substring(8);
      }
      if (dn.equals("$root")) {
        dn = dir;
      } else {
         dn = Utilities.path(dir, dn);
      }
      Utilities.createDirectory(dn);
      for (String s : folder.listFiles()) {
        String fn = Utilities.path(dn, s);
        File f = new File(fn);
        if (withAppend && f.getName().startsWith("_append.")) {
          String appendFn = Utilities.path(dn, s.substring(8));
          if (new File(appendFn).exists())
            TextFile.appendBytesToFile(folder.fetchFile(s), appendFn);        
          else
            TextFile.bytesToFile(folder.fetchFile(s), appendFn);        
        } else
          TextFile.bytesToFile(folder.fetchFile(s), fn);
      }
//      if (path != null)
//        FileUtils.copyDirectory(new File(path), new File(dir));      
    }
  }

  public void debugDump(String purpose) {
//    System.out.println("Debug Dump of Package for '"+purpose+"'. Path = "+path);
//    System.out.println("  npm = "+name()+"#"+version()+", canonical = "+canonical());
//    System.out.println("  folders = "+folders.size());
//    for (String s : sorted(folders.keySet())) {
//      NpmPackageFolder folder = folders.get(s);
//      System.out.println("    "+folder.dump());
//    }
  }

  private List<String> sorted(Set<String> keys) {
    List<String> res = new ArrayList<String>();
    res.addAll(keys);
    Collections.sort(res);
    return res ;
  }

  public void clearFolder(String folderName) {
    NpmPackageFolder folder = folders.get(folderName);
    folder.content.clear();
    folder.types.clear();    
  }

  public void deleteFolder(String folderName) {
    folders.remove(folderName);
  }

  public void addFile(String folderName, String name, byte[] cnt, String type) {
    NpmPackageFolder folder = folders.get(folderName);
    folder.content.put(name, cnt);
    if (!folder.types.containsKey(type))
      folder.types.put(type, new ArrayList<>());
    folder.types.get(type).add(name);
  }

  public void loadAllFiles() throws IOException {
    for (String folder : folders.keySet()) {
      NpmPackageFolder pf = folders.get(folder);
      String p = folder.contains("$") ? path : Utilities.path(path, folder);
      for (File f : new File(p).listFiles()) {
        if (!f.isDirectory() && !isInternalExemptFile(f)) {
          pf.getContent().put(f.getName(), TextFile.fileToBytes(f));
        }
      }
    }
  }

  public boolean isChangedByLoader() {
    return changedByLoader;
  }
  
  
}

