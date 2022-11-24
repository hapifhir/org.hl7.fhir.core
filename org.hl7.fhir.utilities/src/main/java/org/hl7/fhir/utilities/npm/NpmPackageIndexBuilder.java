package org.hl7.fhir.utilities.npm;

import java.io.File;
import java.io.IOException;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.json.model.JsonArray;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;

/**
 * This class builds the .index.json for a package 
 * 
 * @author grahame
 *
 */
public class NpmPackageIndexBuilder {
  
  private JsonObject index;
  private JsonArray files;
  
  public void start() {
    index = new JsonObject();
    index.add("index-version", 1);
    files = new JsonArray();
    index.add("files", files);
  }
  
  public boolean seeFile(String name, byte[] content) {
    if (name.endsWith(".json")) {
      try {
        JsonObject json = JsonParser.parseObject(content);
        if (json.has("resourceType")) {
          // ok we treat it as a resource
          JsonObject fi = new JsonObject();
          files.add(fi);
          fi.add("filename", name);
          fi.add("resourceType", json.asString("resourceType")); 
          if (json.hasPrimitive("id")) {
            fi.add("id", json.asString("id"));
          }
          if (json.hasPrimitive("url")) {
            fi.add("url", json.asString("url"));
          }
          if (json.hasPrimitive("version")) {
            fi.add("version", json.asString("version"));
          }
          if (json.hasPrimitive("kind")) {
            fi.add("kind", json.asString("kind"));
          }
          if (json.hasPrimitive("type")) {
            fi.add("type", json.asString("type"));
          }
          if (json.hasPrimitive("supplements")) {
            fi.add("supplements", json.asString("supplements"));
          }
        }
      } catch (Exception e) {
        System.out.println("Error parsing "+name+": "+e.getMessage());
        if (name.contains("openapi")) {
          return false;
        }
      }
    }
    return true;
  }
  
  public String build() {
    String res = JsonParser.compose(index, true);
    index = null;
    files = null;
    return res;
  }
  
//  private Map<String, List<String>> types = new HashMap<>();
//  private Map<String, String> canonicalMap = new HashMap<>();


  public void executeWithStatus(String folder) throws IOException {
    System.out.print("Index Package "+folder+" ... ");
    execute(folder);
    System.out.println("done");
  }
  
  public void execute(String folder) throws IOException {
    if (existsFolder(folder, "package")) {
      folder = Utilities.path(folder, "package"); 
    }
    if (!existsFile(folder, "package.json")) {
      throw new FHIRException("Not a proper package? (can't find package.json)");
    }
    start();
    File dir = new File(folder);
    for (File f : dir.listFiles()) {
      seeFile(f.getName(), TextFile.fileToBytes(f));
    }
    TextFile.stringToFile(build(), Utilities.path(folder, ".index.json"));
  }


  private boolean existsFolder(String... args) throws IOException {
    File f = new File(Utilities.path(args));
    return f.exists() && f.isDirectory();
  }

  private boolean existsFile(String... args) throws IOException {
    File f = new File(Utilities.path(args));
    return f.exists() && !f.isDirectory();
  }


  public static void main(String[] args) throws IOException {
    new NpmPackageIndexBuilder().executeWithStatus("C:\\work\\org.hl7.fhir\\packages\\hl7.fhir.rX\\hl7.fhir.r4.core");
    new NpmPackageIndexBuilder().executeWithStatus("C:\\work\\org.hl7.fhir\\packages\\hl7.fhir.rX\\hl7.fhir.r4.examples");
    new NpmPackageIndexBuilder().executeWithStatus("C:\\work\\org.hl7.fhir\\packages\\hl7.fhir.rX\\hl7.fhir.r4.expansions");
    new NpmPackageIndexBuilder().executeWithStatus("C:\\work\\org.hl7.fhir\\packages\\hl7.fhir.rX\\hl7.fhir.r4.elements");
    new NpmPackageIndexBuilder().executeWithStatus("C:\\work\\org.hl7.fhir\\packages\\hl7.fhir.rX\\hl7.fhir.r3.core");
    new NpmPackageIndexBuilder().executeWithStatus("C:\\work\\org.hl7.fhir\\packages\\hl7.fhir.rX\\hl7.fhir.r3.examples");
    new NpmPackageIndexBuilder().executeWithStatus("C:\\work\\org.hl7.fhir\\packages\\hl7.fhir.rX\\hl7.fhir.r3.expansions");
    new NpmPackageIndexBuilder().executeWithStatus("C:\\work\\org.hl7.fhir\\packages\\hl7.fhir.rX\\hl7.fhir.r3.elements");
    new NpmPackageIndexBuilder().executeWithStatus("C:\\work\\org.hl7.fhir\\packages\\hl7.fhir.rX\\hl7.fhir.r2b.core");
    new NpmPackageIndexBuilder().executeWithStatus("C:\\work\\org.hl7.fhir\\packages\\hl7.fhir.rX\\hl7.fhir.r2b.examples");
    new NpmPackageIndexBuilder().executeWithStatus("C:\\work\\org.hl7.fhir\\packages\\hl7.fhir.rX\\hl7.fhir.r2b.expansions");
    new NpmPackageIndexBuilder().executeWithStatus("C:\\work\\org.hl7.fhir\\packages\\hl7.fhir.rX\\hl7.fhir.r2.core");
    new NpmPackageIndexBuilder().executeWithStatus("C:\\work\\org.hl7.fhir\\packages\\hl7.fhir.rX\\hl7.fhir.r2.examples");
    new NpmPackageIndexBuilder().executeWithStatus("C:\\work\\org.hl7.fhir\\packages\\hl7.fhir.rX\\hl7.fhir.r2.expansions");
    new NpmPackageIndexBuilder().executeWithStatus("C:\\work\\org.hl7.fhir\\packages\\hl7.fhir.rX\\hl7.fhir.r2.elements");
    new NpmPackageIndexBuilder().executeWithStatus("C:\\work\\org.hl7.fhir\\packages\\fhir.test.data\\fhir.test.data.r2");
    new NpmPackageIndexBuilder().executeWithStatus("C:\\work\\org.hl7.fhir\\packages\\fhir.test.data\\fhir.test.data.r3");
    new NpmPackageIndexBuilder().executeWithStatus("C:\\work\\org.hl7.fhir\\packages\\fhir.test.data\\fhir.test.data.r4");
    new NpmPackageIndexBuilder().executeWithStatus("C:\\work\\org.hl7.fhir\\packages\\fhir.tx.support\\fhir.tx.support.r2");
    new NpmPackageIndexBuilder().executeWithStatus("C:\\work\\org.hl7.fhir\\packages\\fhir.tx.support\\fhir.tx.support.r3");
    new NpmPackageIndexBuilder().executeWithStatus("C:\\work\\org.hl7.fhir\\packages\\fhir.tx.support\\fhir.tx.support.r4");
    new NpmPackageIndexBuilder().executeWithStatus("C:\\work\\org.hl7.fhir\\packages\\hl7.fhir.rX\\hl7.fhir.core#1.0.2");
    new NpmPackageIndexBuilder().executeWithStatus("C:\\work\\org.hl7.fhir\\packages\\hl7.fhir.rX\\hl7.fhir.core#1.4.0");
    new NpmPackageIndexBuilder().executeWithStatus("C:\\work\\org.hl7.fhir\\packages\\hl7.fhir.rX\\hl7.fhir.core#3.0.2");
    new NpmPackageIndexBuilder().executeWithStatus("C:\\work\\org.hl7.fhir\\packages\\hl7.fhir.rX\\hl7.fhir.core#4.0.1");
  }

}