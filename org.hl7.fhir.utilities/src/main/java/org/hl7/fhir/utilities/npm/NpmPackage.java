package org.hl7.fhir.utilities.npm;

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
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
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
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.SimpleHTTPClient;
import org.hl7.fhir.utilities.SimpleHTTPClient.HTTPResult;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.json.model.JsonArray;
import org.hl7.fhir.utilities.json.model.JsonElement;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.model.JsonProperty;
import org.hl7.fhir.utilities.json.parser.JsonParser;
import org.hl7.fhir.utilities.npm.PackageGenerator.PackageType;

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

  public interface ITransformingLoader {

    byte[] load(File f);

  }

  public class PackageResourceInformationSorter implements Comparator<PackageResourceInformation> {
    @Override
    public int compare(PackageResourceInformation o1, PackageResourceInformation o2) {
      return o1.filename.compareTo(o2.filename);
    }
  }
  
  public class PackageResourceInformation {
    private String id;
    private String resourceType;
    private String url;
    private String version;
    private String filename;
    private String supplements;
    private String stype;
    
    public PackageResourceInformation(String root, JsonObject fi) throws IOException {
      super();
      id = fi.asString("id");
      resourceType = fi.asString("resourceType");
      url = fi.asString("url");
      version = fi.asString("version");
      filename = Utilities.path(root, fi.asString("filename"));
      supplements = fi.asString("supplements");
      stype = fi.asString("type");
    }
    public String getId() {
      return id;
    }
    public String getResourceType() {
      return resourceType;
    }
    public String getStatedType() {
      return stype;
    }
    public String getUrl() {
      return url;
    }
    public String getVersion() {
      return version;
    }
    public String getFilename() {
      return filename;
    }
    public String getSupplements() {
      return supplements;
    }
    
  }
  public class IndexVersionSorter implements Comparator<JsonObject> {

    @Override
    public int compare(JsonObject o0, JsonObject o1) {
      String v0 = o0.asString("version"); 
      String v1 = o1.asString("version"); 
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
    private Map<String, byte[]> content = new HashMap<>();
    private JsonObject index;
    private File folder;

    public NpmPackageFolder(String name) {
      super();
      this.name = name;
    }

    public Map<String, List<String>> getTypes() {
      return types;
    }

    public String getName() {
      return name;
    }

    public boolean readIndex(JsonObject index) {
      if (!index.has("index-version") || (index.asInteger("index-version") != NpmPackageIndexBuilder.CURRENT_INDEX_VERSION)) {
        return false;
      }
      this.index = index;
      for (JsonObject file : index.getJsonObjects("files")) {
        String type = file.asString("resourceType");
        String name = file.asString("filename");
        if (!types.containsKey(type))
          types.put(type, new ArrayList<>());
        types.get(type).add(name);
      }
      return true;
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
  private Map<String, Object> userData = new HashMap<>();

  /**
   * Constructor
   */
  private NpmPackage() {
    super();
  }

  /**
   * Factory method that parses a package from an extracted folder
   */
  public static NpmPackage fromFolder(String path) throws IOException {
    NpmPackage res = new NpmPackage();
    res.loadFiles(path, new File(path));
    res.checkIndexed(path);
    return res;
  }

  /**
   * Factory method that starts a new empty package using the given PackageGenerator to create the manifest
   */
  public static NpmPackage empty(PackageGenerator thePackageGenerator) {
    NpmPackage retVal = new NpmPackage();
    retVal.npm = thePackageGenerator.getRootJsonObject();
    return retVal;
  }

  /**
   * Factory method that starts a new empty package using the given PackageGenerator to create the manifest
   */
  public static NpmPackage empty() {
    NpmPackage retVal = new NpmPackage();
    return retVal;
  }

  public Map<String, Object> getUserData() {
    return userData;
  }

  public void loadFiles(String path, File source, String... exemptions) throws FileNotFoundException, IOException {
    this.npm = JsonParser.parseObject(TextFile.fileToString(Utilities.path(path, "package", "package.json")));
    this.path = path;
    
    File dir = new File(path);
    for (File f : dir.listFiles()) {
      if (!isInternalExemptFile(f) && !Utilities.existsInList(f.getName(), exemptions)) {
        if (f.isDirectory()) {
          String d = f.getName();
          if (!d.equals("package")) {
            d = Utilities.path("package", d);
          }
          NpmPackageFolder folder = this.new NpmPackageFolder(d);
          folder.folder = f;
          this.folders.put(d, folder);
          File ij = new File(Utilities.path(f.getAbsolutePath(), ".index.json"));
          if (ij.exists()) {
            try {
              if (!folder.readIndex(JsonParser.parseObject(ij))) {
                indexFolder(folder.getName(), folder);
              }
            } catch (Exception e) {
              throw new IOException("Error parsing "+ij.getAbsolutePath()+": "+e.getMessage(), e);
            }
          }
          loadSubFolders(dir.getAbsolutePath(), f);
        } else {
          NpmPackageFolder folder = this.new NpmPackageFolder(Utilities.path("package", "$root"));
          folder.folder = dir;
          this.folders.put(Utilities.path("package", "$root"), folder);        
        }
      }
    }
  }

  public static boolean isInternalExemptFile(File f) {
    return Utilities.existsInList(f.getName(), ".git", ".svn", ".DS_Store") || Utilities.existsInList(f.getName(), "package-list.json") ||
        Utilities.endsWithInList(f.getName(), ".tgz");
  }

  private void loadSubFolders(String rootPath, File dir) throws IOException {
    for (File f : dir.listFiles()) {
      if (f.isDirectory()) {
        String d = f.getAbsolutePath().substring(rootPath.length()+1);
        if (!d.startsWith("package")) {
          d = Utilities.path("package", d);
        }
        NpmPackageFolder folder = this.new NpmPackageFolder(d);
        folder.folder = f;
        this.folders.put(d, folder);
        File ij = new File(Utilities.path(f.getAbsolutePath(), ".index.json"));
        if (ij.exists()) {
          try {
            if (!folder.readIndex(JsonParser.parseObject(ij))) {
              indexFolder(folder.getName(), folder);
            }
          } catch (Exception e) {
            throw new IOException("Error parsing "+ij.getAbsolutePath()+": "+e.getMessage(), e);
          }
        }
        loadSubFolders(rootPath, f);        
      }
    }    
  }

  public static NpmPackage fromFolder(String folder, PackageType defType, String... exemptions) throws IOException {
    NpmPackage res = new NpmPackage();
    res.loadFiles(folder, new File(folder), exemptions);
    if (!res.folders.containsKey("package")) {
      res.folders.put("package", res.new NpmPackageFolder("package"));
    }
    if (!res.folders.get("package").hasFile("package.json") && defType != null) {
      TextFile.stringToFile("{ \"type\" : \""+defType.getCode()+"\"}", Utilities.path(res.folders.get("package").folder.getAbsolutePath(), "package.json"));
    }
    res.npm = JsonParser.parseObject(new String(res.folders.get("package").fetchFile("package.json")));
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
      npm = JsonParser.parseObject(folders.get("package").fetchFile("package.json"));
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
      if (folder.index == null) {
        indexFolder(desc, folder);
      }
    }
  }

  public void indexFolder(String desc, NpmPackageFolder folder) throws FileNotFoundException, IOException {
    List<String> remove = new ArrayList<>();
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
      folder.readIndex(JsonParser.parseObject(json));
      if (folder.folder != null) {
        TextFile.stringToFile(json, Utilities.path(folder.folder.getAbsolutePath(), ".index.json"));
      }
    } catch (Exception e) {
      TextFile.stringToFile(json, Utilities.path("[tmp]", ".index.json"));
      throw new IOException("Error parsing "+(desc == null ? "" : desc+"#")+"package/"+folder.name+"/.index.json: "+e.getMessage(), e);
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
      res.npm = JsonParser.parseObject(res.folders.get("package").fetchFile("package.json"));
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

  public List<PackageResourceInformation> listIndexedResources(String... types) throws IOException {
    List<PackageResourceInformation> res = new ArrayList<PackageResourceInformation>();
    for (NpmPackageFolder folder : folders.values()) {
      if (folder.index != null) {
        for (JsonObject fi : folder.index.getJsonObjects("files")) {
          if (Utilities.existsInList(fi.asString("resourceType"), types)) {
            res.add(new PackageResourceInformation(folder.folder == null ? "@"+folder.getName() : folder.folder.getAbsolutePath(), fi));
          }
        }
      }
    } 
    //    Collections.sort(res, new PackageResourceInformationSorter());
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
    for (JsonObject file : f.index.getJsonObjects("files")) {
      if (canonical.equals(file.asString("url"))) {
        if (version != null && version.equals(file.asString("version"))) {
          return load("package", file.asString("filename"));
        } else if (version == null) {
          matches.add(file);
        }
      }
      if (matches.size() > 0) {
        if (matches.size() == 1) {
          return load("package", matches.get(0).asString("filename"));          
        } else {
          Collections.sort(matches, new IndexVersionSorter());
          return load("package", matches.get(matches.size()-1).asString("filename"));          
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
    if (f == null) {
      f = folders.get(Utilities.path("package", folder));
    }
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
    return npm.asString("name");
  }

  /**
   * convenience method for getting the package id (which in NPM language is the same as the name)
   * @return
   */
  public String id() {
    return npm.asString("name");
  }

  public String date() {
    return npm.asString("date");
  }

  public String canonical() {
    return npm.asString("canonical");
  }

  /**
   * convenience method for getting the package version
   * @return
   */
  public String version() {
    return npm.asString("version");
  }

  /**
   * convenience method for getting the package fhir version
   * @return
   */
  public String fhirVersion() {
    if ("hl7.fhir.core".equals(npm.asString("name")))
      return npm.asString("version");
    else if (npm.asString("name").startsWith("hl7.fhir.r2.") || npm.asString("name").startsWith("hl7.fhir.r2b.") || npm.asString("name").startsWith("hl7.fhir.r3.") || 
        npm.asString("name").startsWith("hl7.fhir.r4.") || npm.asString("name").startsWith("hl7.fhir.r4b.") || npm.asString("name").startsWith("hl7.fhir.r5."))
      return npm.asString("version");
    else {
      JsonObject dep = null;
      if (npm.hasObject("dependencies")) {
        dep = npm.getJsonObject("dependencies");
        if (dep != null) {
          for (JsonProperty e : dep.getProperties()) {
            if (Utilities.existsInList(e.getName(), "hl7.fhir.r2.core", "hl7.fhir.r2b.core", "hl7.fhir.r3.core", "hl7.fhir.r4.core"))
              return e.getValue().asString();
            if (Utilities.existsInList(e.getName(), "hl7.fhir.core")) // while all packages are updated
              return e.getValue().asString();
          }
        }
      }
      if (npm.hasArray("fhirVersions")) {
        JsonArray e = npm.getJsonArray("fhirVersions");
        if (e.size() > 0) {
          return e.getItems().get(0).asString();
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
    return template.getCode().equals(type()) || template.getOldCode().equals(type()) ;
  }

  public String type() {
    return npm.asString("type");
  }

  public String description() {
    return npm.asString("description");
  }

  public String getPath() {
    return path;
  }

  public List<String> dependencies() {
    List<String> res = new ArrayList<>();
    if (npm.has("dependencies")) {
      for (JsonProperty e : npm.getJsonObject("dependencies").getProperties()) {
        res.add(e.getName()+"#"+e.getValue().asString());
      }
    }
    return res;
  }

  public String homepage() {
    return npm.asString("homepage");
  }

  public String url() {
    return npm.asString("url");
  }


  public String title() {
    return npm.asString("title");
  }

  public String toolsVersion() {
    return npm.asString("tools-version");
  }

  public String license() {
    return npm.asString("license");
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
    if (npm.hasPrimitive("url")) {
      return PackageHacker.fixPackageUrl(npm.asString("url"));
    } else {
      return npm.asString("canonical");
    }
  }

  public InputStream loadResource(String type, String id) throws IOException {
    NpmPackageFolder f = folders.get("package");
    JsonArray files = f.index.getJsonArray("files");
    for (JsonElement e : files.getItems()) {
      JsonObject i = (JsonObject) e;
      if (type.equals(i.asString("resourceType")) && id.equals(i.asString("id"))) {
        return load("package", i.asString("filename"));
      }
    }
    return null;
  }

  public InputStream loadExampleResource(String type, String id) throws IOException {
    NpmPackageFolder f = folders.get("example");
    if (f == null) {
      f = folders.get("package/example");      
    }
    if (f != null) {
      JsonArray files = f.index.getJsonArray("files");
      for (JsonElement e : files.getItems()) {
        JsonObject i = (JsonObject) e;
        if (type.equals(i.asString("resourceType")) && id.equals(i.asString("id"))) {
          return load("example", i.asString("filename"));
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
      byte[] cnt = indexer.build().getBytes(StandardCharsets.UTF_8);
      TextFile.bytesToFile(cnt, Utilities.path(dir.getAbsolutePath(), n, ".index.json"));
    }
    byte[] cnt = TextFile.stringToBytes(JsonParser.compose(npm, true), false);
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
        if (b == null) {
          System.out.println(name+" is null");
        } else {
          indexer.seeFile(s, b);
          if (!s.equals(".index.json") && !s.equals("package.json")) {
            TarArchiveEntry entry = new TarArchiveEntry(name);
            entry.setSize(b.length);
            tar.putArchiveEntry(entry);
            tar.write(b);
            tar.closeArchiveEntry();
          }
        }
      }
      byte[] cnt = indexer.build().getBytes(StandardCharsets.UTF_8);
      TarArchiveEntry entry = new TarArchiveEntry(n+"/.index.json");
      entry.setSize(cnt.length);
      tar.putArchiveEntry(entry);
      tar.write(cnt);
      tar.closeArchiveEntry();
    }
    byte[] cnt = TextFile.stringToBytes(JsonParser.compose(npm, true), false);
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

  /**
   * Keys are resource type names, values are filenames
   */
  public Map<String, List<String>> getTypes() {
    return folders.get("package").types;
  }

  public String fhirVersionList() {
    if (npm.has("fhirVersions")) {
      CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder();
      if (npm.hasArray("fhirVersions")) {
        for (String n : npm.getJsonArray("fhirVersions").asStrings()) {
          b.append(n);
        }
      }
      if (npm.hasPrimitive("fhirVersions")) {
        b.append(npm.asString("fhirVersions"));
      }
      return b.toString();
    } else
      return "";
  }

  public String dependencySummary() {
    if (npm.has("dependencies")) {
      CommaSeparatedStringBuilder b = new CommaSeparatedStringBuilder();
      for (JsonProperty e : npm.getJsonObject("dependencies").getProperties()) {
        b.append(e.getName()+"#"+e.getValue().asString());
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
    if (!folders.containsKey(folderName)) {
      folders.put(folderName, new NpmPackageFolder(folderName));
    }
    NpmPackageFolder folder = folders.get(folderName);
    folder.content.put(name, cnt);
    if (!folder.types.containsKey(type))
      folder.types.put(type, new ArrayList<>());
    folder.types.get(type).add(name);
    if ("package".equals(folderName) && "package.json".equals(name)) {
      try {
        npm = JsonParser.parseObject(cnt);
      } catch (IOException e) {
      }
    }
  }

  public void loadAllFiles() throws IOException {
    for (String folder : folders.keySet()) {
      NpmPackageFolder pf = folders.get(folder);
      String p = folder.contains("$") ? path : Utilities.path(path, folder);
      File file = new File(p);
      if (file.exists()) {
        for (File f : file.listFiles()) {
          if (!f.isDirectory() && !isInternalExemptFile(f)) {
            pf.getContent().put(f.getName(), TextFile.fileToBytes(f));
          }
        }
      }
    }
  }

  public void loadAllFiles(ITransformingLoader loader) throws IOException {
    for (String folder : folders.keySet()) {
      NpmPackageFolder pf = folders.get(folder);
      String p = folder.contains("$") ? path : Utilities.path(path, folder);
      for (File f : new File(p).listFiles()) {
        if (!f.isDirectory() && !isInternalExemptFile(f)) {
          pf.getContent().put(f.getName(), loader.load(f));
        }
      }
    }
  }

  public boolean isChangedByLoader() {
    return changedByLoader;
  }

  public boolean isCore() {
    return Utilities.existsInList(npm.asString("type"), "fhir.core", "Core");
  }

  public boolean isTx() {
    return npm.asString("name").startsWith("hl7.terminology");
  }

  public boolean hasCanonical(String url) {
    if (url == null) {
      return false;
    }
    String u = url.contains("|") ?  url.substring(0, url.indexOf("|")) : url;
    String v = url.contains("|") ?  url.substring(url.indexOf("|")+1) : null;
    NpmPackageFolder folder = folders.get("package");
    if (folder != null) {
      for (JsonObject o : folder.index.getJsonObjects("files")) {
        if (u.equals(o.asString("url"))) {
          if (v == null || v.equals(o.asString("version"))) {
            return true;
          }
        }
      }
    }
    return false;
  }

  public boolean canLazyLoad() throws IOException {
    for (NpmPackageFolder folder : folders.values()) {
      if (folder.folder == null) {        
        return false;
      }
    }
    if (Utilities.existsInList(name(), "fhir.test.data.r2", "fhir.test.data.r3", "fhir.test.data.r4", "fhir.tx.support.r2", "fhir.tx.support.r3", "fhir.tx.support.r4", "us.nlm.vsac")) {
      return true;
    }
    if (npm.asBoolean("lazy-load")) {
      return true;
    }
    if (!hasFile("other", "spec.internals")) {
      return false;
    }
    return true;
  }

  public boolean isNotForPublication() {
    return npm.asBoolean("notForPublication");
 }

  public InputStream load(PackageResourceInformation p) throws FileNotFoundException {
    if (p.filename.startsWith("@")) {
      String[] pl = p.filename.substring(1).split("\\/");
      return new ByteArrayInputStream(folders.get(pl[0]).content.get(pl[1]));
    } else {
      return new FileInputStream(p.filename);
    }
  }

  public Date dateAsDate() {
    try {
      String d = date();
      if (d == null) {
        switch (name()) {
        case "hl7.fhir.r2.core":  d = "20151024000000"; break;
        case "hl7.fhir.r2b.core": d = "20160330000000"; break;
        case "hl7.fhir.r3.core":  d = "20191024000000"; break;
        case "hl7.fhir.r4.core":  d = "20191030000000"; break;
        case "hl7.fhir.r4b.core": d = "202112200000000"; break;
        case "hl7.fhir.r5.core":  d = "20211219000000"; break;
        default:
          return new Date();
        }
      }
      return new SimpleDateFormat("yyyyMMddHHmmss").parse(d);
    } catch (ParseException e) {
      // this really really shouldn't happen
      return new Date();
    }
  }

  public static NpmPackage fromUrl(String source) throws IOException {
    SimpleHTTPClient fetcher = new SimpleHTTPClient();
    HTTPResult res = fetcher.get(source+"?nocache=" + System.currentTimeMillis());
    res.checkThrowException();
    return fromPackage(new ByteArrayInputStream(res.getContent()));
  }

  @Override
  public String toString() {
    return "NpmPackage "+name()+"#"+version()+" [path=" + path + "]";
  }
  
  
}