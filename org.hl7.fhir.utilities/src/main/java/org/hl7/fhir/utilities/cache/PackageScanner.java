package org.hl7.fhir.utilities.cache;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.hl7.fhir.utilities.CSVWriter;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.cache.PackageScanner.ResourceInfo;
import org.hl7.fhir.utilities.json.JsonTrackingParser;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class PackageScanner {
  public class ResourceInfo {

    private String filenameRoot;
    private String htmlName;
    private String id;
    
    public ResourceInfo(String filename, String id) {
      this.filenameRoot = Utilities.changeFileExt(filename, "");
      this.id = id;
    }

  }

  public static void main(String[] args) throws FileNotFoundException, IOException {
    new PackageScanner().scan(new File("C:\\web\\hl7.org\\fhir"), "c:\\temp\\package-scan.csv", "http://hl7.org/fhir");
  }

  private void scan(File folder, String dest, String url) throws IOException {
    CSVWriter csv = new CSVWriter(new FileOutputStream(dest));
    csv.line("path", "error", "name", "version", "fhir-version", "fhir-version-explicit", "canonical", "homepage",
        "url", "type", "#types", "#urls", "dependencies", "spec.internals");
    scanFolders(folder, csv, folder.getAbsolutePath(), url);
    csv.close();    
    System.out.println("done");
  }

  private void scanFolders(File folder, CSVWriter csv, String root, String url) {
    System.out.println(folder.getAbsolutePath());
    for (File file : folder.listFiles()) {
      if (file.isDirectory()) {
        scanFolders(file, csv, root, url);
      } else if (file.getName().endsWith(".tgz")) {
        processPackage(file, csv, root, url);
      }
    }
  }

  private void processPackage(File file, CSVWriter csv, String root, String url) {
    try {
      NpmPackage npm = NpmPackage.fromPackage(new FileInputStream(file));
      fix(npm, file, root, url);
      csv.line(file.getAbsolutePath(), "", npm.name(), npm.version(), npm.fhirVersion(), npm.fhirVersionList(), npm.canonical(), npm.homepage(),
          npm.url(), npm.type(), Integer.toString(npm.getTypes().size()), Integer.toString(npm.getUrls().size()), npm.dependencySummary(), Boolean.toString(npm.hasFile("other", "spec.internals")));
    } catch (Exception e) {
      try {
        csv.line(file.getAbsolutePath(), e.getMessage() == null ? "NPE" : e.getMessage());
      } catch (IOException e1) {
        e1.printStackTrace();
      }
    }
  }

  private void fix(NpmPackage npm, File file, String root, String url) throws FileNotFoundException, IOException {
    String u = Utilities.pathURL(url, Utilities.getDirectoryForFile(file.getAbsolutePath()).substring(root.length()).replace("\\", "/"));
    if (Utilities.getDirectoryForFile(file.getAbsolutePath()).equals("C:\\web\\hl7.org\\fhir")) {
      u = "http://hl7.org/fhir/R4";
    }
    boolean save = false;
    List<String> names = new ArrayList<>();
    names.addAll(npm.getContent().keySet());
    for (String s : names) {
      if (!s.startsWith("package/")) {
        save = true;
        String n = "package/"+s;
        npm.getContent().put(n, npm.getContent().get(s));
        npm.getContent().remove(s);
      }
    }

    if (!npm.getNpm().has("fhirVersions")) {
      JsonArray fv = new JsonArray();
      fv.add(npm.fhirVersion());
      npm.getNpm().add("fhirVersions", fv);
      save = true;
    }
    if (npm.getNpm().has("dependencies")) {
      JsonObject dep = npm.getNpm().getAsJsonObject("dependencies");
      for (Entry<String, JsonElement> e : dep.entrySet()) {
        if ("current".equals(e.getValue().getAsString())) {
          save = true;
          if ("hl7.fhir.us.core.r4".equals(e.getKey())) {
            dep.remove("hl7.fhir.us.core.r4");
            dep.addProperty("hl7.fhir.us.core", "3.0.1");
          } else if ("hl7.fhir.us.davinci-pas".equals(e.getKey())) {
            dep.remove("hl7.fhir.us.davinci-pas");
            dep.addProperty("hl7.fhir.us.davinci-pas", "0.1.0");
          } else if ("hl7.fhir.uv.sdc".equals(e.getKey())) {
            dep.remove("hl7.fhir.uv.sdc");
            if ("0.1.0".equals(npm.version()))
              dep.addProperty("hl7.fhir.uv.sdc", "2.5.0");
            else
              dep.addProperty("hl7.fhir.uv.sdc", "2.7.0");
          } else if ("hl7.fhir.us.core".equals(e.getKey())) {
            dep.remove("hl7.fhir.us.core");
            dep.addProperty("hl7.fhir.us.core", "3.0.1");
          } else if ("hl7.fhir.us.ccda.r4".equals(e.getKey())) {
            dep.remove("hl7.fhir.us.ccda.r4");
            dep.addProperty("hl7.fhir.us.ccda", "1.0.0");            
          }
        }
      }
    }
    if (!npm.hasFile("other", "spec.internals") && !file.getName().startsWith("hl7.fhir.r")) {
      save = true;
      npm.getContent().put("package/other/spec.internals", buildSpecInternals(npm.canonical(), Utilities.getDirectoryForFile(file.getAbsolutePath())));
    }
//    if (npm.url() == null || !npm.url().equals(u)) {
//      npm.getNpm().remove("url");
//      npm.getNpm().addProperty("url", u);
//      save = true;
//    }
//    if (!npm.canonical().startsWith("http://hl7.org")) {
//      npm.getNpm().remove("canonical");
//      npm.getNpm().addProperty("canonical", "http://hl7.org/fhir/smart-app-launch");
//      save = true;
//    }
//
    if (save) {
      File bck = new File(Utilities.changeFileExt(file.getAbsolutePath(), ".bcknpm"));
      if (bck.exists()) {
        bck.delete();
      }
      file.renameTo(bck);
      npm.save(new FileOutputStream(file));
    }
  }

  private byte[] buildSpecInternals(String canonical, String dir) throws FileNotFoundException, IOException {
    // the spec internals file contains 2 important things: a map from canonical URL to html path 
    // and a list of html target files
    
    List<ResourceInfo> rl = makeResList(dir);
    List<String> targets = new ArrayList<>();
    for (File f : new File(dir).listFiles()) {
      if (f.getName().endsWith(".html")) {
        targets.add(f.getName());
        String src = TextFile.fileToString(f);
        for (ResourceInfo r : rl) {
          if (r.htmlName == null) {
            if (src.contains(r.filenameRoot+".json")) {
              r.htmlName = f.getName();
            }
          }
        }
      }
    }
    StringBuilder b = new StringBuilder();
    b.append("{\r\n");
    b.append("  \"paths\": {");
    boolean first = true;
    for (ResourceInfo r : rl) {
      String link = r.htmlName;
      if (link == null) {
        System.out.println("No link found for "+r.id);
      } else {
        if (first) first = false; else b.append(",");
        b.append("\r\n    \"");
        b.append(Utilities.pathURL(canonical, r.id));
        b.append("\": \"");
        if (link.contains(".json.html") && new File(Utilities.path(dir,link. replace(".json", ""))).exists()) {
          link = link.replace(".json", "");
        }
        b.append(link);
        b.append("\"");
      }
    }
    b.append("\r\n  },\r\n");
    b.append("  \"targets\": [");
    first = true;
    for (String s : targets) {
      if (first) first = false; else b.append(",");
      b.append("\r\n    \"");
      b.append(s);
      b.append("\"");
    }
    b.append("  ]\r\n");
    b.append("}\r\n");
    return TextFile.stringToBytes(b.toString(), false);
  }

  private List<ResourceInfo> makeResList(String dir) {
    List<ResourceInfo> rl = new ArrayList<>();
    for (File f : new File(dir).listFiles()) {
      if (f.getName().endsWith(".json") && !f.getName().endsWith(".canonical.json")) {
        try {
          JsonObject obj = JsonTrackingParser.parseJson(f);
          if (obj.has("resourceType") && obj.has("id")) {
            rl.add(new ResourceInfo(f.getName(), obj.get("resourceType").getAsString() +"/"+ obj.get("id").getAsString()));
          }
        } catch (IOException e) {
        }
      }
    }
    return rl;
  }
 
}
