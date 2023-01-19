package org.hl7.fhir.convertors.misc;

import org.hl7.fhir.utilities.npm.NpmPackage;
import org.hl7.fhir.utilities.tests.ResourceLoaderTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class NpmPackageVersionConverterTests implements ResourceLoaderTests {
  @org.junit.jupiter.api.Test

  public void testNormalTgz() throws IOException {
    InputStream tgzStream = getResourceAsInputStream("misc", "npmPackageVersionConverter", "tgz-normal.tgz");
    NpmPackageVersionConverter converter = new NpmPackageVersionConverter(null, null, "r5", null);
    Map<String, byte[]> contents = converter.loadContentMap(tgzStream);
    String actual = new String(contents.get("depth1/test.txt"), StandardCharsets.UTF_8);
    assertEquals("dummy file content", actual);
  }

  @Test
  public void testEvilTgz() throws IOException {
    RuntimeException thrown = Assertions.assertThrows(RuntimeException.class, () -> {
      InputStream tgzStream = getResourceAsInputStream("misc", "npmPackageVersionConverter", "tgz-evil.tgz");
      NpmPackageVersionConverter converter = new NpmPackageVersionConverter(null, null, "r5", null);
      converter.loadContentMap(tgzStream);
    });
    assertNotNull(thrown);
    assertEquals("Entry with an illegal name: ../evil.txt", thrown.getMessage());
  }
}
