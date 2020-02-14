package org.hl7.fhir.r5.test;

import java.io.IOException;

import org.apache.commons.lang3.SystemUtils;

import org.hl7.fhir.utilities.Utilities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Path Tests")
public class UtilitiesTests {

    @Test
    @DisplayName("Tests java temp directory is created correctly")
    public void testTempDir() throws IOException {
        Assertions.assertEquals(Utilities.path("[tmp]", "test.txt"), SystemUtils.IS_OS_WINDOWS ? "c:\\temp\\test.txt" : System.getProperty("java.io.tmpdir") + "test.txt");
    }

    @Test
    @DisplayName("Tests user system property is correct")
    public void testUserDir() throws IOException {
        Assertions.assertEquals(Utilities.path("[user]", "test.txt"), SystemUtils.IS_OS_WINDOWS ? System.getProperty("user.home") + "\\test.txt" : System.getProperty("user.home") + "/test.txt");
    }

    @Test
    @DisplayName("Tests JAVA_HOME is initialized correctly")
    public void testJavaHome() throws IOException {
        Assertions.assertEquals(Utilities.path("[JAVA_HOME]", "test.txt"), SystemUtils.IS_OS_WINDOWS ? System.getenv("JAVA_HOME") + "\\test.txt" : System.getenv("JAVA_HOME") + "/test.txt");
    }

}