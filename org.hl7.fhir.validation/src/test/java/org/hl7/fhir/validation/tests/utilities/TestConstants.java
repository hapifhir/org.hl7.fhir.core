package org.hl7.fhir.validation.tests.utilities;

import java.nio.file.Paths;

public class TestConstants {
  public static final java.lang.String TX_CACHE = Paths.get("src","test","resources", "txCache").toAbsolutePath().toString();

  public static final java.lang.String TX_CACHE_LOG = Paths.get(System.getProperty("user.dir"), "tx.log.html").toAbsolutePath().toString();

  public static final String USER_AGENT = "fhir/test-cases";
}
