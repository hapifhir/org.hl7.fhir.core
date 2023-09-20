package org.hl7.fhir.utilities.npm;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.json.model.JsonArray;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;

/**
 * This class builds the .index.json for a package 
 * 
 * it also builds a .index.db since that may provide faster access
 * 
 * @author grahame
 *
 */
public class NpmPackageIndexBuilder {
  
  public static final Integer CURRENT_INDEX_VERSION = 2;
  private JsonObject index;
  private JsonArray files;
  private Connection conn;
  private PreparedStatement psql;
  private String dbFilename;
  
  public void start(String filename) {
    index = new JsonObject();
    index.add("index-version", CURRENT_INDEX_VERSION);
    files = new JsonArray();
    index.add("files", files);


    dbFilename = filename;
    if (filename != null) {
      try {
        new File(filename).delete();
        conn = DriverManager.getConnection("jdbc:sqlite:"+filename); 
        Statement stmt = conn.createStatement();
        stmt.execute("CREATE TABLE ResourceList (\r\n"+
            "FileName       nvarchar NOT NULL,\r\n"+
            "ResourceType   nvarchar NOT NULL,\r\n"+
            "Id             nvarchar NULL,\r\n"+
            "Url            nvarchar NULL,\r\n"+
            "Version        nvarchar NULL,\r\n"+
            "Kind           nvarchar NULL,\r\n"+
            "Type           nvarchar NULL,\r\n"+
            "Supplements    nvarchar NULL,\r\n"+
            "Content        nvarchar NULL,\r\n"+
            "ValueSet       nvarchar NULL,\r\n"+
            "Derivation     nvarchar NULL,\r\n"+
            "PRIMARY KEY (FileName))\r\n");

        psql = conn.prepareStatement("Insert into ResourceList (FileName, ResourceType, Id, Url, Version, Kind, Type, Supplements, Content, ValueSet) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
      } catch (Exception e) {
        if (conn != null) { 
          try {
            conn.close();
          } catch (SQLException e1) {
          }
        }
        conn = null;
      }
    }
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
          if (json.hasPrimitive("content")) {
            fi.add("content", json.asString("content"));
          }
          if (json.hasPrimitive("valueSet")) {
            fi.add("valueSet", json.asString("valueSet"));
          }
          if (json.hasPrimitive("derivation")) {
            fi.add("derivation", json.asString("derivation"));
          }
          if (psql != null) {
            psql.setString(1, name); // FileName); 
            psql.setString(2, json.asString("resourceType")); // ResourceType"); 
            psql.setString(3, json.asString("id")); // Id"); 
            psql.setString(4, json.asString("url")); // Url"); 
            psql.setString(5, json.asString("version")); // Version"); 
            psql.setString(6, json.asString("kind")); // Kind");
            psql.setString(7, json.asString("type")); // Type"); 
            psql.setString(8, json.asString("supplements")); // Supplements"); 
            psql.setString(9, json.asString("content")); // Content");
            psql.setString(10, json.asString("valueSet")); // ValueSet");
            psql.setString(10, json.asString("derivation")); // ValueSet");
            psql.execute();
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
    try {
      if (conn != null) {
        conn.close();
      }
    } catch (Exception e) {
      // nothing
    }
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
    start(Utilities.path(folder, ".index.db"));
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

  public String getDbFilename() {
    return dbFilename;
  }

}