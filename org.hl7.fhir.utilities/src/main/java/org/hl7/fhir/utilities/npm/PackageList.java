package org.hl7.fhir.utilities.npm;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hl7.fhir.utilities.FhirPublication;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.json.JsonException;
import org.hl7.fhir.utilities.json.model.JsonArray;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;

public class PackageList {

  public static class PackageListEntry {
    private JsonObject json;

    private PackageListEntry(JsonObject json) {
      super();
      this.json = json;
    }
    
    public String version() {
      return json.asString("version");
    }

    public String path() {
      return json.asString("path");
    }

    public boolean current() {
      return json.has("current") && json.asBoolean("current");
    }

    public boolean cibuild() {
      return "ci-build".equals(json.asString("status"));
    }

    public String sequence() {
      return json.asString("sequence");
   }

    public String fhirVersion() {
      if (json.has("fhir-version")) // legacy
        return json.asString("fhir-version");
      return json.asString("fhirversion");
    }

    public String status() {
      return json.asString("status");
    }

    public String desc() {
      return json.asString("desc");
    }

    public String date() {
      return json.asString("date");
    }

    public void setDate(String date) {
      json.set("date", date);      
    }

    public String name() {
      return json.asString("name");
    }
    
    public List<String> subPackages() {
      List<String> list = new ArrayList<>();
      if (json.has("sub-packages")) {
        list.addAll(json.getStrings("sub-packages"));
      }
      return list;
    }
    
    public void clearSubPackages() {
      json.remove("sub-packages");
    }
    public void addSubPackage(String s) {
      json.forceArray("sub-packages").add(s);  
    }
    
    private boolean isPartofMainSpec() {
      return Utilities.startsWithInList(path(), "http://hl7.org/fhir/DSTU2", "http://hl7.org/fhir/2015Sep", "http://hl7.org/fhir/2015May");
    }
    
    /**
     * For a variety of reasons in the past, the path is not always under the canonical
     * this method determines the path *if it exists*
     * 
     * @param root
     * @param v
     * @throws IOException 
     */
    public String determineLocalPath(String url, String root) throws IOException {
      if (!isPartofMainSpec() && path().startsWith(url+"/")) {
        String tail = path().substring(url.length()+1);
        return Utilities.path(root, tail);
      } else {
        return null;
      }
    }
    
    public void setCurrent(boolean b) {
      if (b) {
        json.set("current", true);
      } else {
        if (json.has("current")) {
          json.remove("current");
        }
      }
    }

    public void init(String version, String path, String status, String sequence, FhirPublication fhirVersion) {
      json.set("version", version);      
      json.set("path", path);
      json.set("status", status);
      json.set("sequence", sequence);
      if (fhirVersion != null) {
        json.set("fhirversion", fhirVersion.toCode());
      }
    }
    
    public void describe(String desc, String descMD, String changes) {
      if (!Utilities.noString(desc)) {
        json.set("desc", desc);
      }
      if (!Utilities.noString(descMD)) {
        json.set("descmd", descMD);
      }
      if (!Utilities.noString(changes)) {
        json.set("changes", changes);
      }
    }

    public JsonObject json() {
      return json;
    }

    public Instant instant() throws ParseException {
      return json.asInstant("date");
    }

    /**
     * only used for a technical correction. tcPath is the name of archive file (web reference) containing the content before correction
     * 
     * @param asString
     * @param webpath
     * @param asString2
     * @param asString3
     * @param fhirVersion
     * @param tcName
     */
    public void update(String version, String path, String status, String sequence, FhirPublication fhirVersion, String tcPath, String date) {
      JsonObject tc = new JsonObject();
      json.forceArray("corrections").add(tc);
      tc.set("version", json.asString("version"));
      tc.set("path", tcPath);
      tc.set("date", date);

      json.set("version", version);      
      json.set("path", path);
      json.set("status", status);
      json.set("sequence", sequence);
      if (fhirVersion != null) {
        json.set("fhirversion", fhirVersion.toCode());
      }
      setDate(date);
    }

  }
  
  private String source;
  private JsonObject json;
  private List<PackageListEntry> list = new ArrayList<>();
  private List<PackageListEntry> versions = new ArrayList<>();
  private PackageListEntry cibuild;
  
  public PackageList() {
    super();
    json = new JsonObject();
    json.add("list", new JsonArray());
  }

  public PackageList(JsonObject json) {
    this.json = json;
    for (JsonObject o : json.getJsonObjects("list")) {
      PackageListEntry e = new PackageListEntry(o);
      list.add(e);
      if ("current".equals(o.asString("version"))) {
        cibuild = e;
      } else {
        versions.add(e);
      }
    }
  }

  public static PackageList fromFile(File f) throws JsonException, IOException {
    return new PackageList(JsonParser.parseObject(f)).setSource(f.getAbsolutePath());
  }
  
  public PackageList setSource(String src) {
    this.source = src;
    return this;
  }

  public static PackageList fromFile(String f) throws JsonException, IOException {
    return new PackageList(JsonParser.parseObjectFromFile(f)).setSource(f);    
  }
  
  public static PackageList fromContent(byte[] cnt) throws JsonException, IOException {
    return new PackageList(JsonParser.parseObject(cnt)).setSource("unknown");
  }
  
  public static PackageList fromUrl(String url) throws JsonException, IOException {
    return new PackageList(JsonParser.parseObjectFromUrl(url)).setSource(url);
  }
  
  public String source() {
    return source;
  }

  public String canonical() {
    return json.asString("canonical");
  }

  public String pid() {
    return json.asString("package-id");
  }
  
  public boolean hasPid() {
    return json.has("package-id");
  }

  public String category() {
    return json.asString("category");
  }
  
  public List<PackageListEntry> list() {
    return list;
  }
  
  public List<PackageListEntry> versions() {
    return versions;
  }

  public PackageListEntry ciBuild() {
    return cibuild;
  }

  public String toJson() {
    return JsonParser.compose(json, true);
  }

  public PackageListEntry newVersion(String version, String path, String status, String sequence, FhirPublication fhirVersion) {
    JsonObject o = new JsonObject();
    PackageListEntry e = new PackageListEntry(o);
    versions.add(0, e);
    if (cibuild != null) {
      json.getJsonArray("list").add(1, o);
      list.add(1, e);
    } else {
      json.getJsonArray("list").add(0, o);     
      list.add(0, e);
    }
    e.init(version, path, status, sequence, fhirVersion);
    return e;
  }

  public void init(String name, String canonical, String title, String category, String introduction) {
    json.add("package-id", name);
    json.add("canonical", canonical);
    json.add("title", title);
    json.add("category", category);
    json.add("introduction", introduction);

  }

  public void addCIBuild(String version, String path, String desc, String status) {
    if (cibuild != null) {
      json.getJsonArray("list").remove(cibuild.json);
    }
    cibuild = new PackageListEntry(new JsonObject());
    cibuild.init(version, path, status, status, null);
    json.getJsonArray("list").add(0, cibuild.json);    
  }

  public PackageListEntry findByVersion(String version) {
    for (PackageListEntry p : versions) {
      if (version.equals(p.version())) {
        return p;
      }
    }
    return null;
  }

  public void save(String filepath) throws IOException {
    TextFile.stringToFile(toJson(), filepath);
  }

  public String determineLocalPath(String url, String root) throws IOException {
    if (canonical().startsWith(url+"/")) {
      String tail = canonical().substring(url.length()+1);
      return Utilities.path(root, tail);
    } else {
      return null;
    }
  }

  public String title() {
    return json.asString("title");
  }

  public PackageListEntry current() {
    for (PackageListEntry e : list) {
      if (e.current() && !"ci-build".equals(e.status())) {
        return e;
      }
    }
    return null;
  }

  public PackageListEntry latest() {
    for (PackageListEntry e : list) {
      if (!"ci-build".equals(e.status())) {
        return e;
      }
    }
    return null;
  }
  
  public String intro() {
    return json.asString("introduction");
  }

  public List<PackageListEntry> milestones() {
    List<PackageListEntry> list = new ArrayList<>();
    for (PackageListEntry t : versions) {
      if (t.name() != null) {
        list.add(t);
      }
    }
    return list;
  }

  public boolean hasPath(String pathVer) {
    for (PackageListEntry t : versions) {
      if (t.path() != null && t.path().equals(pathVer)) {
        return true;
      }
    }
    return false;
  }


}
