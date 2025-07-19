package org.hl7.fhir.validation;

import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.npm.NpmPackageIndexBuilder;

import java.sql.*;

public class SQLiteINpmPackageIndexBuilderDBImpl implements NpmPackageIndexBuilder.INpmPackageIndexBuilderDBImpl {
  private String dbFilename;
  private Connection conn;
  private PreparedStatement psql;

  @Override
  public void start(String filename) {
    dbFilename = filename;
    try {
      ManagedFileAccess.file(filename).delete();
      conn = DriverManager.getConnection("jdbc:sqlite:" + filename);
      Statement stmt = conn.createStatement();
      stmt.execute("CREATE TABLE ResourceList (\r\n" +
        "FileName       nvarchar NOT NULL,\r\n" +
        "ResourceType   nvarchar NOT NULL,\r\n" +
        "Id             nvarchar NULL,\r\n" +
        "Url            nvarchar NULL,\r\n" +
        "Version        nvarchar NULL,\r\n" +
        "Kind           nvarchar NULL,\r\n" +
        "Type           nvarchar NULL,\r\n" +
        "Supplements    nvarchar NULL,\r\n" +
        "Content        nvarchar NULL,\r\n" +
        "ValueSet       nvarchar NULL,\r\n" +
        "Derivation     nvarchar NULL,\r\n" +
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

  @Override
  public void seeFile(String name, JsonObject fi) throws Exception {
    if (psql != null) {
      psql.setString(1, name); // FileName);
      psql.setString(2, fi.asString("resourceType")); // ResourceType");
      psql.setString(3, fi.asString("id")); // Id");
      psql.setString(4, fi.asString("url")); // Url");
      psql.setString(5, fi.asString("version")); // Version");
      psql.setString(6, fi.asString("kind")); // Kind");
      psql.setString(7, fi.asString("type")); // Type");
      psql.setString(8, fi.asString("supplements")); // Supplements");
      psql.setString(9, fi.asString("content")); // Content");
      psql.setString(10, fi.asString("valueSet")); // ValueSet");
      psql.setString(10, fi.asString("derivation")); // Derivation");
      psql.execute();
    }
  }

  @Override
  public void close() {
    try {
      if (conn != null) {
        conn.close();
      }
    } catch (Exception e) {
      // nothing
    }
  }

  public static class SQLiteINpmPackageIndexBuilderDBImplFactory implements NpmPackageIndexBuilder.INpmPackageIndexBuilderDBImplFactory {

    @Override
    public NpmPackageIndexBuilder.INpmPackageIndexBuilderDBImpl create() {
      return new SQLiteINpmPackageIndexBuilderDBImpl();
    }
  }
}
