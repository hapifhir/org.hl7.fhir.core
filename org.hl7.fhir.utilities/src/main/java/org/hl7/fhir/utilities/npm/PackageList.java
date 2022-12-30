package org.hl7.fhir.utilities.npm;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.utilities.FhirPublication;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.json.JsonException;
import org.hl7.fhir.utilities.json.model.JsonArray;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;
import org.hl7.fhir.utilities.npm.PackageList.PackageListEntry;

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

    public boolean isPartofMainSpec() {
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
      json.set("fhirversion", fhirVersion.toCode());    
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
}
