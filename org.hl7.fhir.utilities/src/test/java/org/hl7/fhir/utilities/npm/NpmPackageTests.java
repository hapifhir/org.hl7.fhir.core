package org.hl7.fhir.utilities.npm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;import java.util.List;

import org.apache.commons.compress.archivers.tar.TarArchiveEntry;import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;import org.apache.commons.compress.compressors.gzip.GzipCompressorOutputStream;import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.ByteArrayOutputStream;import org.hl7.fhir.utilities.tests.ResourceLoaderTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NpmPackageTests implements ResourceLoaderTests {
  @Test
  void testNormalTgz() throws IOException {
    InputStream tgzStream = getResourceAsInputStream("npm", "tar", "tgz-normal.tgz");
    NpmPackage npmPackage = NpmPackage.fromPackage(tgzStream);

    InputStream inputStream = npmPackage.load("depth1", "test.txt");
    String actual = IOUtils.toString(inputStream, StandardCharsets.UTF_8.name());
    assertEquals("dummy file content", actual);
  }

  @Test
  void testEvilTgz() {
    RuntimeException thrown = Assertions.assertThrows(RuntimeException.class, () -> {
      InputStream tgzStream = getResourceAsInputStream("npm", "tar", "tgz-evil.tgz");
      NpmPackage.fromPackage(tgzStream);
    });
    assertNotNull(thrown);
    assertEquals("Entry with an illegal name: ../evil.txt", thrown.getMessage());
  }

  // Created by claude-sonnet-4-6
  @Test
  void testTgzWithUtf8EncodedNonAsciiFilename() throws IOException {
    byte[] tgz = buildTgz("UTF-8", "package/examples/Patient - Ludger Kýnigstein.json");
    NpmPackage pkg = NpmPackage.fromPackage(new ByteArrayInputStream(tgz));
    List<String> files = pkg.list("examples");
    assertTrue(files.contains("Patient - Ludger Kýnigstein.json"));
  }

  // Created by claude-sonnet-4-6
  @Test
  void testTgzWithLatin1EncodedNonAsciiFilename() throws IOException {
    // Regression: packages like KBV.Basis store tar entry names in Latin-1.
    // Byte 0xFD ('ý') is invalid UTF-8, so commons-compress 1.27.1 replaced it
    // with '?' (illegal in Windows paths) when file.encoding=UTF-8 was active.
    byte[] tgz = buildTgz("ISO-8859-1", "package/examples/Patient - Ludger Kýnigstein.json");
    NpmPackage pkg = NpmPackage.fromPackage(new ByteArrayInputStream(tgz));
    List<String> files = pkg.list("examples");
    assertTrue(files.contains("Patient - Ludger Kýnigstein.json"));
  }

  // Created by claude-sonnet-4-6
  private static byte[] buildTgz(String encoding, String entryName) throws IOException {
    byte[] packageJson = "{\"name\":\"test\",\"version\":\"0.0.1\",\"fhirVersions\":[\"4.0.1\"],\"dependencies\":{}}"
      .getBytes(StandardCharsets.UTF_8);
    byte[] fileContent = "{\"resourceType\":\"Patient\",\"id\":\"example\"}".getBytes(StandardCharsets.UTF_8);
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    try (GzipCompressorOutputStream gzipOut = new GzipCompressorOutputStream(baos);
         TarArchiveOutputStream tarOut = new TarArchiveOutputStream(gzipOut, encoding)) {
      addTarEntry(tarOut, "package/package.json", packageJson);
      addTarEntry(tarOut, entryName, fileContent);
    }
    return baos.toByteArray();
  }

  // Created by claude-sonnet-4-6
  private static void addTarEntry(TarArchiveOutputStream tar, String name, byte[] content) throws IOException {
    TarArchiveEntry entry = new TarArchiveEntry(name);
    entry.setSize(content.length);
    tar.putArchiveEntry(entry);
    tar.write(content);
    tar.closeArchiveEntry();
  }
}

