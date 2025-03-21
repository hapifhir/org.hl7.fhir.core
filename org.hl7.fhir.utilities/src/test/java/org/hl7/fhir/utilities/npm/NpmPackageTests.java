package org.hl7.fhir.utilities.npm;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.Sets;
import org.apache.commons.io.IOUtils;

import org.hl7.fhir.utilities.tests.ResourceLoaderTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
  public void testFHIRTgz() throws IOException {
    InputStream tgzStream = getResourceAsInputStream("npm", "tar", "cqf-ccc.tgz");
    NpmPackage npmPackage = NpmPackage.fromPackage(tgzStream);

    Map<String, NpmPackage.NpmPackageFolder> folders = npmPackage.getFolders();
    Sets.SetView<String> result = Sets.symmetricDifference(folders.keySet(), Set.of(
      "package",
      "other",
      "tests"));
    assertTrue(result.isEmpty());

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
