package org.hl7.fhir.utilities.npm;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.SimpleHTTPClient;
import org.hl7.fhir.utilities.SimpleHTTPClient.HTTPResult;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.json.JSONUtil;
import org.hl7.fhir.utilities.json.JsonTrackingParser;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class PackageClient {

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
      if (ver == null || ver.equals(pi.getVersion())) {
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
    return fetchUrl(url, null);
  }

  protected String fn(String url) {
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
          res.add(new PackageInfo(JSONUtil.str(obj, "name"),
            JSONUtil.str(obj, "version"),
            JSONUtil.str(obj, "FhirVersion"),
            JSONUtil.str(obj, "description"),
            JSONUtil.str(obj, "url"),
            JSONUtil.str(obj, "canonical"),
            address));
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
        res.add(new PackageInfo(JSONUtil.str(obj, "Name", "name"),
          JSONUtil.str(obj, "Version", "version"),
          JSONUtil.str(obj, "FhirVersion", "fhirVersion"),
          JSONUtil.str(obj, "Description", "description"),
          JSONUtil.str(obj, "url"),
          JSONUtil.str(obj, "canonical"),
          address));
      }
    } catch (IOException e1) {
    }
    return res;    
  }  

  public Date getNewPackages(Date lastCalled, List<PackageInfo> updates) {
    return null;
  }
 
  private InputStream fetchUrl(String source, String accept) throws IOException {
    SimpleHTTPClient http = new SimpleHTTPClient();
    HTTPResult res = http.get(source, accept);
    res.checkThrowException();
    return new ByteArrayInputStream(res.getContent());
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
      String v = list.get(0).getVersion();
      for (PackageInfo p : list) {
        if (VersionUtilities.isThisOrLater(v, p.getVersion())) {
          v = p.getVersion();
        }
      }
      return v;
    }
  }
  
  public String getLatestVersion(String id, String majMinVersion) throws IOException {
    List<PackageInfo> list = getVersions(id);
    if (list.isEmpty()) {
      throw new IOException("Package not found: "+id);
    } else {
      String v = majMinVersion;
      for (PackageInfo p : list) {
        if (VersionUtilities.isMajMinOrLaterPatch(v, p.getVersion())) {
          v = p.getVersion();
        }
      }
      return v;
    }
  }

  
  public List<PackageInfo> listFromRegistry(String name, String canonical, String fhirVersion) throws IOException {
    List<PackageInfo> result = new ArrayList<>();
    JsonObject packages = JsonTrackingParser.fetchJson("https://raw.githubusercontent.com/FHIR/ig-registry/master/fhir-ig-list.json?nocache=" + System.currentTimeMillis());
    for (JsonObject o : JSONUtil.objects(packages, "guides")) {
      if (o.has("canonical")) {
        String id = JSONUtil.str(o, "npm-name");
        String pname = JSONUtil.str(o, "name");
        String pcanonical = JSONUtil.str(o, "canonical");
        String description = JSONUtil.str(o, "description");
        boolean ok = true;
        if (ok && !Utilities.noString(name)) {
          ok = (pname != null && pname.contains(name)) || (description != null && description.contains(name)) || (id != null && id.contains(name)); 
        }
        if (ok && !Utilities.noString(canonical)) {
          ok = pcanonical.contains(canonical); 
        }
        String version = null;
        String fVersion = null;
        String url = null;
        
        if (ok) {
          // if we can find something...
          for (JsonObject e : JSONUtil.objects(o, "editions")) {
            if (fhirVersion == null || fhirVersion.equals(JSONUtil.str(e, "fhir-version"))) {
              String v = JSONUtil.str(e, "ig-version");
              if (version == null || VersionUtilities.isThisOrLater(version, v)) {
                version = v;
                fVersion = e.getAsJsonArray("fhir-version").get(0).getAsString();
                url = JSONUtil.str(e, "url");
              }
            }
          }
        }
        if (version != null) {  
          result.add(new PackageInfo(id, version, fVersion, description, url, pcanonical, address));
        }
      }
    }
    return result;
  }
  
}