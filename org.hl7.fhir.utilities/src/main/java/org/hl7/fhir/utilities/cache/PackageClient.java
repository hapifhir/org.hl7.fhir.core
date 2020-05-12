package org.hl7.fhir.utilities.cache;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.cache.PackageClient.PackageInfo;
import org.hl7.fhir.utilities.json.JSONUtil;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class PackageClient {

  public class PackageInfo {
    private String id;
    private String version;
    private String fhirVersion;
    private String description;
    private String url;
    private String canonical;
    
    public PackageInfo(String id, String version, String fhirVersion, String description, String url, String canonical) {
      super();
      this.id = id;
      this.version = version;
      this.fhirVersion = fhirVersion;
      this.description = description;
      this.url = url;
      if (url == null && id != null && version != null) {
        url = Utilities.pathURL(address, id, version);
      }
      this.canonical = canonical;
    }
    public String getId() {
      return id;
    }
    public String getVersion() {
      return version;
    }
    public String getFhirVersion() {
      return fhirVersion;
    }
    public String getDescription() {
      return description;
    }
    public String getUrl() {
      return url;
    }
    
    public String getCanonical() {
      return canonical;
    }
    @Override
    public String toString() {
      return id+"#"+(version == null ? "?pc-pi?" : version)+(fhirVersion == null ? "": " ("+canonical+") for FHIR "+fhirVersion)+(url == null ? "" : " @"+url)+(description == null ? "" : " '"+description+"'");
    }    
  }
 
  private String address;
  private String cacheFolder;


  public PackageClient(String address) {
    super();
    this.address = address;
    try {
      cacheFolder = Utilities.path(System.getProperty("user.home"), ".fhir", "package-client");
      Utilities.createDirectory(cacheFolder);
    } catch (IOException e) {
    }
  }

  public boolean exists(String id, String ver) throws IOException {
    List<PackageInfo> vl = getVersions(id);
    for (PackageInfo pi : vl) {
      if (ver.equals(pi.getVersion())) {
        return true;
      }
    }
    return false;
  }

  public InputStream fetch(String id, String ver) throws IOException {
    return fetchCached(Utilities.pathURL(address, id, ver));
  }

  public InputStream fetch(PackageInfo info) throws IOException {
    return fetchCached(Utilities.pathURL(address, info.getId(), info.getVersion()));
  }

  public InputStream fetchNpm(String id, String ver) throws IOException {
    return fetchCached(Utilities.pathURL(address, id, "-", id+"-"+ver+".tgz"));
  }

  public InputStream fetchCached(String url) throws IOException, FileNotFoundException {
    File cacheFile = new File(Utilities.path(cacheFolder, fn(url)));
    if (cacheFile.exists()) {
      return new FileInputStream(cacheFile);
    }
    TextFile.bytesToFile(TextFile.streamToBytes(fetchUrl(url, null)), cacheFile);
    return new FileInputStream(cacheFile);
  }

  private String fn(String url) {
    String[] p = url.split("\\/");
    return p[2]+"-"+p[p.length-2]+"-"+p[p.length-1]+".tgz";
  }

  public List<PackageInfo> getVersions(String id) throws IOException {
    List<PackageInfo> res = new ArrayList<>();
    JsonObject json;
    try {
      json = fetchJson(Utilities.pathURL(address, id));
      JsonObject versions = json.getAsJsonObject("versions");
      if (versions != null) {
        for (String v : sorted(versions.keySet())) {
          JsonObject obj = versions.getAsJsonObject(v);
          res.add(new PackageInfo(JSONUtil.str(obj, "name"), JSONUtil.str(obj, "version"), JSONUtil.str(obj, "FhirVersion"), JSONUtil.str(obj, "description"), JSONUtil.str(obj, "url"), JSONUtil.str(obj, "canonical")));
        }
      }
    } catch (FileNotFoundException e) {
    }
    return res;    
  }
   
  private List<String> sorted(Set<String> keys) {
    List<String> res = new ArrayList<>();
    res.addAll(keys);
    Collections.sort(res);
    return res;
  }

  public List<PackageInfo> search(String name, String canonical, String fhirVersion, boolean preRelease) throws IOException {
    CommaSeparatedStringBuilder params = new CommaSeparatedStringBuilder("&");
    if (!Utilities.noString(name)) {
      params.append("name="+name);
    }
    if (!Utilities.noString(canonical)) {
      params.append("canonical="+canonical);
    }
    if (!Utilities.noString(fhirVersion)) {
      params.append("fhirversion="+fhirVersion);
    }
    if (preRelease) {
      params.append("prerelease="+preRelease);
    }
    List<PackageInfo> res = new ArrayList<>();
    try {
      JsonArray json = fetchJsonArray(Utilities.pathURL(address, "catalog?")+params.toString());
      for (JsonElement e : json) {
        JsonObject obj = (JsonObject) e;
        res.add(new PackageInfo(JSONUtil.str(obj, "Name", "name"), JSONUtil.str(obj, "Version", "version"), JSONUtil.str(obj, "FhirVersion", "fhirVersion"), JSONUtil.str(obj, "Description", "description"), JSONUtil.str(obj, "url"), JSONUtil.str(obj, "canonical")));
      }
    } catch (IOException e1) {
    }
    return res;    
  }  

  public Date getNewPackages(Date lastCalled, List<PackageInfo> updates) {
    return null;
  }
 
  private InputStream fetchUrl(String source, String accept) throws IOException {
    URL url = new URL(source);
    URLConnection c = url.openConnection();
    if (accept != null) {
      c.setRequestProperty("accept", accept);
    }
    return c.getInputStream();
  }
  
  private JsonObject fetchJson(String source) throws IOException {
    String src = TextFile.streamToString(fetchUrl(source, "application/json"));
    //System.out.println(src);
    return (JsonObject) new com.google.gson.JsonParser().parse(src);
  }
  
  private JsonArray fetchJsonArray(String source) throws IOException {
    String src = TextFile.streamToString(fetchUrl(source, "application/json"));
    //System.out.println(src);
    return (JsonArray) new com.google.gson.JsonParser().parse(src);
  }

  public String url(String id, String v) {
    return Utilities.pathURL(address, id, v);
  }

  public String getLatestVersion(String id) throws IOException {
    List<PackageInfo> list = getVersions(id);
    if (list.isEmpty()) {
      throw new IOException("Package not found: "+id);
    } else {
      String v = list.get(0).version;
      for (PackageInfo p : list) {
        if (VersionUtilities.isThisOrLater(v, p.version)) {
          v = p.version;
        }
      }
      return v;
    }
  }
  

}