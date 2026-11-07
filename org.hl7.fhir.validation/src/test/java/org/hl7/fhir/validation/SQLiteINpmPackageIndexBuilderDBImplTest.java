package org.hl7.fhir.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.npm.NpmPackageIndexBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class SQLiteINpmPackageIndexBuilderDBImplTest {

  @TempDir
  Path tempDir;

  private static JsonObject entry(String resourceType, String id, String... fields) {
    JsonObject fi = new JsonObject();
    fi.add("resourceType", resourceType);
    fi.add("id", id);
    for (int i = 0; i < fields.length; i += 2) {
      fi.add(fields[i], fields[i + 1]);
    }
    return fi;
  }

  private static int countRows(String filename) throws SQLException {
    try (Connection c = DriverManager.getConnection("jdbc:sqlite:" + filename);
         Statement s = c.createStatement();
         ResultSet rs = s.executeQuery("select count(*) from ResourceList")) {
      return rs.getInt(1);
    }
  }

  @Test
  void writesValueSetAndDerivationToTheirOwnColumns() throws Exception {
    String filename = tempDir.resolve(".index.db").toString();
    SQLiteINpmPackageIndexBuilderDBImpl db = new SQLiteINpmPackageIndexBuilderDBImpl();
    db.start(filename);
    db.seeFile("CodeSystem-cs.json", entry("CodeSystem", "cs", "url", "http://example.org/cs", "content", "complete", "valueSet", "http://example.org/vs"));
    db.seeFile("StructureDefinition-sd.json", entry("StructureDefinition", "sd", "url", "http://example.org/sd", "kind", "resource", "type", "Patient", "derivation", "constraint"));
    db.close();

    try (Connection c = DriverManager.getConnection("jdbc:sqlite:" + filename);
         Statement s = c.createStatement()) {
      try (ResultSet rs = s.executeQuery("select ValueSet, Derivation, Content from ResourceList where Id = 'cs'")) {
        assertEquals("http://example.org/vs", rs.getString(1));
        assertNull(rs.getString(2));
        assertEquals("complete", rs.getString(3));
      }
      try (ResultSet rs = s.executeQuery("select ValueSet, Derivation, Kind, Type from ResourceList where Id = 'sd'")) {
        assertNull(rs.getString(1));
        assertEquals("constraint", rs.getString(2));
        assertEquals("resource", rs.getString(3));
        assertEquals("Patient", rs.getString(4));
      }
    }
  }

  @Test
  void rowsAreCommittedTogetherOnClose() throws Exception {
    String filename = tempDir.resolve(".index.db").toString();
    SQLiteINpmPackageIndexBuilderDBImpl db = new SQLiteINpmPackageIndexBuilderDBImpl();
    db.start(filename);
    for (int i = 0; i < 3; i++) {
      db.seeFile("Patient-p" + i + ".json", entry("Patient", "p" + i));
    }
    // in auto-commit mode each row would already be on disk, one sync each
    assertEquals(0, countRows(filename));
    db.close();
    assertEquals(3, countRows(filename));
  }

  @Test
  void aFailedInsertDoesNotLoseTheOtherRows() throws Exception {
    String filename = tempDir.resolve(".index.db").toString();
    SQLiteINpmPackageIndexBuilderDBImpl db = new SQLiteINpmPackageIndexBuilderDBImpl();
    db.start(filename);
    db.seeFile("Patient-p.json", entry("Patient", "p"));
    // FileName is the primary key: the insert fails, but the transaction goes on
    assertThrows(SQLException.class, () -> db.seeFile("Patient-p.json", entry("Patient", "p")));
    db.seeFile("Patient-q.json", entry("Patient", "q"));
    db.close();
    assertEquals(2, countRows(filename));
  }

  @Test
  void interleavedBuildersEachWriteTheirOwnIndex() throws Exception {
    NpmPackageIndexBuilder.INpmPackageIndexBuilderDBImplFactory old = NpmPackageIndexBuilder.getExtensionFactory();
    NpmPackageIndexBuilder.setExtensionFactory(new SQLiteINpmPackageIndexBuilderDBImpl.SQLiteINpmPackageIndexBuilderDBImplFactory());
    try {
      String fa = tempDir.resolve("a.db").toString();
      String fb = tempDir.resolve("b.db").toString();
      NpmPackageIndexBuilder a = new NpmPackageIndexBuilder();
      NpmPackageIndexBuilder b = new NpmPackageIndexBuilder();
      a.start(fa);
      a.seeFile("Patient-a1.json", patient("a1"));
      b.start(fb);
      b.seeFile("Patient-b1.json", patient("b1"));
      a.seeFile("Patient-a2.json", patient("a2"));
      b.build();
      a.build();
      assertEquals(2, countRows(fa));
      assertEquals(1, countRows(fb));
    } finally {
      NpmPackageIndexBuilder.setExtensionFactory(old);
    }
  }

  private static byte[] patient(String id) {
    return ("{\"resourceType\": \"Patient\", \"id\": \"" + id + "\"}").getBytes(StandardCharsets.UTF_8);
  }

  @Test
  void failedCommitLeavesNoRowsAndDoesNotThrow() throws Exception {
    String filename = tempDir.resolve(".index.db").toString();
    SQLiteINpmPackageIndexBuilderDBImpl db = new SQLiteINpmPackageIndexBuilderDBImpl();
    db.start(filename);
    db.seeFile("Patient-p.json", entry("Patient", "p"));
    // an open read transaction holds a shared lock, so the commit can't get the exclusive lock it needs
    try (Connection reader = DriverManager.getConnection("jdbc:sqlite:" + filename)) {
      reader.setAutoCommit(false);
      try (Statement s = reader.createStatement(); ResultSet rs = s.executeQuery("select count(*) from ResourceList")) {
        assertEquals(0, rs.getInt(1));
        db.close(); // must not throw
      }
      reader.rollback();
    }
    // nothing was written
    assertEquals(0, countRows(filename));
    db.close(); // closing again is harmless
  }
}
