package org.hl7.fhir.utilities;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;

import static org.assertj.core.api.Assertions.assertThat;

class SQLiteLoadWarningTest {

  @Test
  void sqliteNativeLibraryIsLoadedFromUnnamedModule() throws Exception {
    // Opening any sqlite connection causes SQLiteJDBCLoader to call
    // System.load() from an unnamed module.
    // On JDK 22+ without --enable-native-access=ALL-UNNAMED this prints to stderr:
    //   WARNING: java.lang.System::load has been called by
    //   org.sqlite.SQLiteJDBCLoader in an unnamed module
    //
    // Module.isNativeAccessEnabled() was added in JDK 22. On older runtimes the
    // warning is never emitted, so no assertion is needed.
    if (Runtime.version().feature() >= 22) {
      try {
        Method isNativeAccessEnabled = Module.class.getMethod("isNativeAccessEnabled");
        boolean enabled = (boolean) isNativeAccessEnabled.invoke(
          SQLiteLoadWarningTest.class.getModule());
        assertThat(enabled)
          .as("Native access must be enabled for the unnamed module " +
              "(--enable-native-access=ALL-UNNAMED) to suppress the " +
              "SQLiteJDBCLoader warning on JDK 22+")
          .isTrue();
      } catch (NoSuchMethodException e) {
        // safety net — should not occur on JDK 22+
      }
    }

    try (Connection conn = DriverManager.getConnection("jdbc:sqlite::memory:")) {
      // connection is enough — no queries needed
    }
  }
}
