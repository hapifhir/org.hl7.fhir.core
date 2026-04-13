package org.hl7.fhir.utilities;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SQLiteLoadWarningTest {

  @Test
  void sqliteNativeLibraryIsLoadedFromUnnamedModule() throws Exception {
    // Opening any sqlite connection causes SQLiteJDBCLoader to call
    // System.load() from an unnamed module.
    // On JDK 22+ without --enable-native-access=ALL-UNNAMED this prints to stderr:
    //   WARNING: java.lang.System::load has been called by
    //   org.sqlite.SQLiteJDBCLoader in an unnamed module
    PrintStream originalErr = System.err;
    ByteArrayOutputStream capturedErr = new ByteArrayOutputStream();
    try {
      System.setErr(new PrintStream(capturedErr));
      try (Connection conn = DriverManager.getConnection("jdbc:sqlite::memory:")) {
        // connection is enough — no queries needed
      }
      capturedErr.flush();
    } finally {
      System.setErr(originalErr);
    }
    assertEquals("", capturedErr.toString());
  }
}
