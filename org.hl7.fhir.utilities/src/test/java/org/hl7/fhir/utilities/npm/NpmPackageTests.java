package org.hl7.fhir.utilities.npm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;
import org.hl7.fhir.utilities.tests.ResourceLoaderTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NpmPackageTests implements ResourceLoaderTests {
  @Test
  public void testNormalTgz() throws IOException {
    InputStream tgzStream = getResourceAsInputStream("npm", "tar", "tgz-normal.tgz");
    NpmPackage npmPackage = NpmPackage.fromPackage(tgzStream);

    InputStream inputStream = npmPackage.load("depth1", "test.txt");
    String actual = IOUtils.toString(inputStream, StandardCharsets.UTF_8.name());
    assertEquals("dummy file content", actual);
  }

  @Test
  public void testEvilTgz() throws IOException {
    RuntimeException thrown = Assertions.assertThrows(RuntimeException.class, () -> {
      InputStream tgzStream = getResourceAsInputStream("npm", "tar", "tgz-evil.tgz");
      NpmPackage npmPackage = NpmPackage.fromPackage(tgzStream);
    });
    assertNotNull(thrown);
    assertEquals("Entry with an illegal name: ../evil.txt", thrown.getMessage());
  }
}
