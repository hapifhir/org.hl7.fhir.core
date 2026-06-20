package org.hl7.fhir.r5.context;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.HashSet;
import java.util.Set;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;

@MarkedToMoveToAdjunctPackage
@Slf4j
public class OidIndexBuilder {

  private File folder;
  private File target;

  public OidIndexBuilder(File ff, File of) {
    super();
    this.folder = ff;
    this.target = of;
  }

  public void build() {
    log.info("Generate OID index for "+folder.getAbsolutePath());
    target.delete();
    try {
      Set<String> matches = new HashSet<String>();
      
      Connection db = DriverManager.getConnection("jdbc:sqlite:"+target.getAbsolutePath());
      Statement stmt = db.createStatement();
      stmt.execute("CREATE TABLE OIDMap (\r\n"+
          "OID            nvarchar NOT NULL,\r\n"+
          "TYPE           nvarchar NOT NULL,\r\n"+
          "URL            nvarchar NOT NULL,\r\n"+
          "VERSION        nvarchar NULL,\r\n"+
          "Status         nvarchar NOT NULL,\r\n"+
          "PRIMARY KEY (OID, URL))\r\n");

      PreparedStatement psql = db.prepareStatement("Insert into OIDMap (OID, TYPE, URL, VERSION, Status) values (?, ?, ?, ?, ?)");
      for (File f : folder.listFiles()) {
        if (!f.getName().startsWith(".") && f.getName().endsWith(".json")) {
          try {
            JsonObject json = JsonParser.parseObject(f);
            processFile(psql, matches, json);
          } catch (Exception e) {
            log.error("Error processing "+f.getAbsolutePath()+" while generating OIDs: "+e.getMessage(), e);
          }
        }
      }
      db.close();
    } catch (Exception e) {
      log.error("Error processing "+folder.getAbsolutePath()+" while generating OIDs: "+e.getMessage(), e);
    }
  }  

  private void processFile(PreparedStatement psql, Set<String> matches, JsonObject json) throws SQLException {
    String rt = json.asString("resourceType");
    if (rt != null) {
      Set<String> oids = new HashSet<String>();
      String url = null;
      String status = json.asString("status");
      String version = json.asString("version");
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
            addOid(psql, matches, s, rt, url, version, status);
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
              addOid(psql, matches, s, rt, url, version, status);
            }
          }
        }
      }
    }
  }

  private void addOid(PreparedStatement psql, Set<String> matches, String oid, String type, String url, String version, String status) throws SQLException {
    String key = oid+"@"+url;
    if (!matches.contains(key)) {
      matches.add(key);
      psql.setString(1, oid);
      psql.setString(2, type);
      psql.setString(3, url);
      if (version == null) {
        psql.setNull(4, Types.NVARCHAR);
      } else {
        psql.setString(4, version);  
      }
      psql.setString(5, status);
      psql.execute();
    }

  }

}
