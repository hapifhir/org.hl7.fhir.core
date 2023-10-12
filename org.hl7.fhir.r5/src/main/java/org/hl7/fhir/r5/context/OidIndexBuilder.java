package org.hl7.fhir.r5.context;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;

public class OidIndexBuilder {

  private File folder;
  private File target;

  public OidIndexBuilder(File ff, File of) {
    super();
    this.folder = ff;
    this.target = of;
  }

  public void build() {
    System.out.println("Generate OID index for "+folder.getAbsolutePath());
    target.delete();
    try {
      Set<String> matches = new HashSet<String>();
      
      Connection db = DriverManager.getConnection("jdbc:sqlite:"+target.getAbsolutePath());
      Statement stmt = db.createStatement();
      stmt.execute("CREATE TABLE OIDMap (\r\n"+
          "OID            nvarchar NOT NULL,\r\n"+
          "URL            nvarchar NOT NULL,\r\n"+
          "PRIMARY KEY (OID, URL))\r\n");

      PreparedStatement psql = db.prepareStatement("Insert into OIDMap (OID, URL) values (?, ?)");;
      for (File f : folder.listFiles()) {
        if (!f.getName().startsWith(".") && f.getName().endsWith(".json")) {
          try {
            JsonObject json = JsonParser.parseObject(f);
            processFile(psql, matches, json);
          } catch (Exception e) {
            System.out.println("Error processing "+f.getAbsolutePath()+" while generating OIDs: "+e.getMessage());
          }
        }
      }
      db.close();
    } catch (Exception e) {
      System.out.println("Error processing "+folder.getAbsolutePath()+" while generating OIDs: "+e.getMessage());
    }
  }  

  private void processFile(PreparedStatement psql, Set<String> matches, JsonObject json) throws SQLException {
    String rt = json.asString("resourceType");
    if (rt != null) {
      Set<String> oids = new HashSet<String>();
      String url = null;
      if ("NamingSystem".equals(rt)) {        
        for (JsonObject id : json.getJsonObjects("uniqueId")) {
          String t = id.asString("type");
          String v = id.asString("value");
          if ("url".equals(t) && v != null) {
            url = v;
          } else if ("oid".equals(t) && v != null) {
            oids.add(v);
          }
        }
        if (url != null) {
          for (String s : oids) {
            addOid(psql, matches, s, url);
          }
        }
      } else {            
        if (json.hasPrimitive("url")) { 
          url = json.asString("url");
          if (json.has("oid")) {
            oids.add(json.asString("oid"));
          }
          if (json.has("url")) {
            String v = json.asString("url");
            if (v != null && v.startsWith("urn:oid:")) {
              oids.add(v.substring(8));
            }
          }

          for (JsonObject id : json.getJsonObjects("identifier")) {
            String v = id.asString("value");
            if (v != null && v.startsWith("urn:oid:")) {
              oids.add(v.substring(8));
            }
          }
          if (!oids.isEmpty()) {
            for (String s : oids) {
              addOid(psql, matches, s, url);
            }
          }
        }
      }
    }
  }

  private void addOid(PreparedStatement psql, Set<String> matches, String oid, String url) throws SQLException {
    String key = oid+"@"+url;
    if (!matches.contains(key)) {
      matches.add(key);
      psql.setString(1, oid);
      psql.setString(2, url);
      psql.execute();
    }

  }

}
