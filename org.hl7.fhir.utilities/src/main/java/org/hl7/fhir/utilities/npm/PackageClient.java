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
import org.hl7.fhir.utilities.json.JsonUtilities;
import org.hl7.fhir.utilities.json.JsonTrackingParser;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class PackageClient {

  public static final String PRIMARY_SERVER = "http://packages.fhir.org";
  public static final String SECONDARY_SERVER = "https://packages2.fhir.org/packages";

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
          res.add(new PackageInfo(JsonUtilities.str(obj, "Name", "name"),
            JsonUtilities.str(obj, "Version", "version"),
            JsonUtilities.str(obj, "FhirVersion", "fhirVersion"),
            JsonUtilities.str(obj, "Description", "description"),
            JsonUtilities.str(obj, "url"),
            JsonUtilities.str(obj, "canonical"),
            address));
        }
      }
    } catch (Exception e) {
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
        res.add(new PackageInfo(JsonUtilities.str(obj, "Name", "name"),
          JsonUtilities.str(obj, "Version", "version"),
          JsonUtilities.str(obj, "FhirVersion", "fhirVersion"),
          JsonUtilities.str(obj, "Description", "description"),
          JsonUtilities.str(obj, "url"),
          JsonUtilities.str(obj, "canonical"),
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

  protected PackageInfo getPackageInfoFromJSON(JsonObject o, String name, String canonical, String fhirVersion) {
      String id = JsonUtilities.str(o, "npm-name");
      String pname = JsonUtilities.str(o, "name");
      String pcanonical = JsonUtilities.str(o, "canonical");
      String description = JsonUtilities.str(o, "description");
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
        for (JsonObject e : JsonUtilities.objects(o, "editions")) {
          if (fhirVersion == null || fhirVersion.equals(JsonUtilities.str(e, "fhir-version"))) {
            String v = JsonUtilities.str(e, "ig-version");
            if (version == null || VersionUtilities.isThisOrLater(version, v)) {
              version = v;
              fVersion = e.getAsJsonArray("fhir-version").get(0).getAsString();
              url = JsonUtilities.str(e, "url");

              String npmPackage = JsonUtilities.str(e, "package");
              if (npmPackage != null && id == null) {
                id = npmPackage.substring(0, npmPackage.indexOf("#"));
              }
            }
          }
        }
      }
      return new PackageInfo(id, version, fVersion, description, url, pcanonical, address);
  }
  
  public List<PackageInfo> listFromRegistry(String name, String canonical, String fhirVersion) throws IOException {
    List<PackageInfo> result = new ArrayList<>();
    JsonObject packages = JsonTrackingParser.fetchJson("https://raw.githubusercontent.com/FHIR/ig-registry/master/fhir-ig-list.json?nocache=" + System.currentTimeMillis());
    for (JsonObject o : JsonUtilities.objects(packages, "guides")) {
      if (o.has("canonical")) {
      final PackageInfo packageInfo = getPackageInfoFromJSON(o, name, canonical, fhirVersion);
        if (packageInfo.getVersion() != null) {
          result.add(packageInfo);
        }
      }
    }
    return result;
  }

  public void findDependents(Set<String> list, String id) {
    CommaSeparatedStringBuilder params = new CommaSeparatedStringBuilder("&");
    params.append("dependency="+id);
    try {
      JsonArray json = fetchJsonArray(Utilities.pathURL(address, "catalog?")+params.toString());
      for (JsonElement e : json) {
        JsonObject obj = (JsonObject) e;
        list.add(JsonUtilities.str(obj, "Name", "name"));
      }
    } catch (IOException e1) {
    }
  }
  
}