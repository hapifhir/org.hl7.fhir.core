package org.hl7.fhir.r5.test.utils;

import java.nio.file.Paths;
import java.lang.String;

public class TestConstants {
    public static final String TX_CACHE = Paths.get("src","test","resources", "txCache").toAbsolutePath().toString();
    public static final String USER_AGENT = "fhir/r5-test-cases";
}
