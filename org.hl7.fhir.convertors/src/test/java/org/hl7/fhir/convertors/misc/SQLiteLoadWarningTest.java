package org.hl7.fhir.convertors.misc;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;

class SQLiteLoadWarningTest {

  @Test
  void sqliteNativeLibraryIsLoadedFromUnnamedModule() throws Exception {
    // Opening any sqlite connection causes SQLiteJDBCLoader to call
    // System.load() from an unnamed module.
    // On JDK 22+ this prints to stderr:
    //   WARNING: java.lang.System::load has been called by
    //   org.sqlite.SQLiteJDBCLoader in an unnamed module
    try (Connection conn = DriverManager.getConnection("jdbc:sqlite::memory:")) {
      // connection is enough — no queries needed
    }
  }
}
