package org.hl7.fhir.utilities.npm;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.SimpleHTTPClient;
import org.hl7.fhir.utilities.SimpleHTTPClient.HTTPResult;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.VersionUtilities;
import org.hl7.fhir.utilities.json.model.JsonArray;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.model.JsonProperty;
import org.hl7.fhir.utilities.json.parser.JsonParser;

public class PackageClient {

  private PackageServer server;
  private String address;


  public PackageClient(PackageServer server) {
    super();
    this.server = server;
    address = this.server.getUrl();
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
    return fetchCached(getPackageTarballUrl(id, ver));
  }

  private String getPackageTarballUrl(String id, String ver) throws IOException {
    if (server.getServerType() == PackageServer.PackageServerType.NPM) {
      return getNpmServerTarballUrl(id, ver);
    }
    return Utilities.pathURL(address, id, ver);
  }

  private String getNpmServerTarballUrl(String id, String ver) throws IOException {
    String packageDescriptorUrl = Utilities.pathURL(address, id, ver);
    JsonObject json;

      json = fetchJson(packageDescriptorUrl);
      JsonObject dist = json.getJsonObject("dist");
      return dist.getJsonString("tarball").asString();

  }

  public InputStream fetch(PackageInfo info) throws IOException {
    return fetchCached(getPackageTarballUrl(info.getId(), info.getVersion()));
  }

  public InputStream fetchCached(String url) throws IOException, FileNotFoundException {
    return fetchUrl(url, null);
  }

  public List<PackageInfo> getVersions(String id) throws IOException {
    String url = Utilities.pathURL(address, id);
    List<PackageInfo> res = new ArrayList<>();
    JsonObject json;
    try {
      json = fetchJson(url);
      JsonObject versions = json.getJsonObject("versions");
      boolean hasDates = true;
      if (versions != null) {
        for (JsonProperty v : versions.getProperties()) {
          JsonObject obj = versions.getJsonObject(v.getName());
          Instant d = getInstantFromPackageDate(obj);
          if (d == null) {
            hasDates = false;
          }
          res.add(new PackageInfo(obj.asString("Name", "name"),
            obj.asString("Version", "version"),
            obj.asString("FhirVersion", "fhirVersion"),
            obj.asString("Description", "description"),
            obj.asString("url"),
            obj.asString("canonical"),
            address, d));
        }
      }
      if (hasDates) {
        Collections.sort(res, new PackageInfo.PackageInfoSorter(true));
      } else {
        Collections.sort(res, new PackageInfo.PackageInfoSorter(false));
      }
    } catch (Exception e) {
      System.out.println("Error fetching "+url+": "+e.getMessage());
    }
    return res;    
  }

  @Nullable
  private static Instant getInstantFromPackageDate(JsonObject obj) {
    try {
      return obj.hasString("date") ? obj.asDate("date") : null;
    } catch (DateTimeParseException e) {
      try {
        return new SimpleDateFormat("yyyyMMddhhmmss").parse(obj.getJsonString("date").asString()).toInstant();
      } catch (ParseException ex) {
        // we tried to parse the date, but failed twice. We're just going to pretend we didn't get a date 
        return null;    
      }
    }
  }

  public List<PackageInfo> search(String name, String canonical, String fhirVersion, boolean preRelease) throws IOException {
    CommaSeparatedStringBuilder params = new CommaSeparatedStringBuilder("&");
    if (!Utilities.noString(name)) {
      params.append("name="+name);
    }
    if (!Utilities.noString(canonical)) {
      params.append("pkgcanonical="+canonical);
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
      boolean hasDates = true;
      for (JsonObject obj : json.asJsonObjects()) {
        Instant d = obj.has("date") ? obj.asDate("date") : null;
        if (d == null) {
          hasDates = false;
        }
        res.add(new PackageInfo(obj.asString("Name", "name"),
          obj.asString("Version", "version"),
          obj.asString("FhirVersion", "fhirVersion"),
          obj.asString("Description", "description"),
          obj.asString("url"),
          obj.asString("canonical"),
          address, d));
      }
      if (hasDates) {
        Collections.sort(res, new PackageInfo.PackageInfoSorter(true));
      } else {
        Collections.sort(res, new PackageInfo.PackageInfoSorter(false));
      }
    } catch (IOException e1) {
    }
    return res;    
  }  

  public Date getNewPackages(Date lastCalled, List<PackageInfo> updates) {
    return null;
  }
 
  private InputStream fetchUrl(String source, String accept) throws IOException {
    SimpleHTTPClient http = getSimpleHTTPClient();
    HTTPResult res = http.get(source, accept);
    res.checkThrowException();
    return new ByteArrayInputStream(res.getContent());
  }

  @Nonnull
  private SimpleHTTPClient getSimpleHTTPClient() {
    SimpleHTTPClient client = new SimpleHTTPClient();
    client.setAuthenticationMode(server.getAuthenticationMode());
    client.setUsername(server.getUsername());
    client.setPassword(server.getPassword());
    client.setToken(server.getToken());
    return client;
  }

  private JsonObject fetchJson(String source) throws IOException {
    String src = TextFile.streamToString(fetchUrl(source, "application/json"));
    //System.out.println(src);
    return JsonParser.parseObject(src);
  }
  
  private JsonArray fetchJsonArray(String source) throws IOException {
    String src = TextFile.streamToString(fetchUrl(source, "application/json"));
    //System.out.println(src);
    return (JsonArray) JsonParser.parse(src);
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
  
  public String getLatestVersion(String id, String specVersion) throws IOException {
    List<PackageInfo> list = getVersions(id);
    if (list.isEmpty()) {
      throw new IOException("Package not found: "+id);
    } else {
      String v = null;
      for (PackageInfo p : list) {
        if (VersionUtilities.isMajMinOrLaterPatch(specVersion, p.getVersion())) {
          v = p.getVersion();
        }
      }
      return v;
    }
  }

  protected PackageInfo getPackageInfoFromJSON(JsonObject o, String name, String canonical, String fhirVersion) {
      String id = o.asString("npm-name");
      String pname = o.asString("name");
      String pcanonical = o.asString("canonical");
      String description = o.asString("description");
      Instant d = o.has("date") ? o.asDate("date") : null;
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
        for (JsonObject e : o.getJsonObjects("editions")) {
          if (fhirVersion == null || fhirVersion.equals(e.asString("fhir-version"))) {
            String v = e.asString("ig-version");
            if (version == null || VersionUtilities.isThisOrLater(version, v)) {
              version = v;
              fVersion = e.getJsonArray("fhir-version").get(0).asString();
              url = e.asString("url");

              String npmPackage = e.asString("package");
              if (npmPackage != null && id == null) {
                id = npmPackage.substring(0, npmPackage.indexOf("#"));
              }
            }
          }
        }
      }
      return new PackageInfo(id, version, fVersion, description, url, pcanonical, address, d);
  }
  
  public List<PackageInfo> listFromRegistry(String name, String canonical, String fhirVersion) throws IOException {
    List<PackageInfo> result = new ArrayList<>();
    JsonObject packages = JsonParser.parseObjectFromUrl("https://raw.githubusercontent.com/FHIR/ig-registry/master/fhir-ig-list.json?nocache=" + System.currentTimeMillis());
    for (JsonObject o : packages.getJsonObjects("guides")) {
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
    params.append("dependency="+id.replace("#", "|"));
    try {
      JsonArray json = fetchJsonArray(Utilities.pathURL(address, "catalog?")+params.toString());
      for (JsonObject obj : json.asJsonObjects()) {
        list.add(obj.asString("Name", "name"));
      }
    } catch (IOException e1) {
    }
  }
  
}