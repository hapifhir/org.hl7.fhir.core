package org.hl7.fhir.r5.test.utils;

import java.nio.file.Paths;

import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;

import java.lang.String;

@MarkedToMoveToAdjunctPackage
public class TestConstants {
    public static final String TX_CACHE = Paths.get("src","test","resources", "txCache").toAbsolutePath().toString();
    public static final String USER_AGENT = "fhir/r5-test-cases";
}
