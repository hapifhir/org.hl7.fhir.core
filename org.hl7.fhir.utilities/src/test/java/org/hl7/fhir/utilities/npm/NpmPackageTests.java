package org.hl7.fhir.utilities.npm;

import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import org.apache.commons.compress.archivers.tar.TarUtils;
import org.apache.commons.compress.compressors.gzip.GzipCompressorOutputStream;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.hl7.fhir.utilities.tests.ResourceLoaderTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

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
    IOException thrown = Assertions.assertThrows(IOException.class, () -> {
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

  @Test
  void testMaxLoadSize() throws IOException {
    // a package with ~200kB of decompressed content
    byte[] content = ("{\"resourceType\":\"Basic\",\"id\":\"big\",\"language\":\""+"x".repeat(200000)+"\"}").getBytes(StandardCharsets.UTF_8);
    byte[] tgz = buildTgz("UTF-8", "package/big.json", content);

    // the default limit is 1.5 GB - loads fine
    assertEquals(1536L * 1024 * 1024, NpmPackage.getDefaultMaxLoadSize());
    assertNotNull(NpmPackage.fromPackage(new ByteArrayInputStream(tgz)));

    // generous per-instance limit - loads fine
    assertNotNull(NpmPackage.fromPackage(new ByteArrayInputStream(tgz), "test", false, 1000000));

    // tight per-instance limit - refused before the content is buffered
    IOException thrown = Assertions.assertThrows(IOException.class, () ->
      NpmPackage.fromPackage(new ByteArrayInputStream(tgz), "test", false, 10000));
    assertTrue(thrown.getMessage().contains("exceeds the limit"));

    // the static property sets the default for instances that don't specify a limit
    NpmPackage.setDefaultMaxLoadSize(10000);
    try {
      Assertions.assertThrows(IOException.class, () -> NpmPackage.fromPackage(new ByteArrayInputStream(tgz)));
      // but an explicit per-instance limit still wins
      assertNotNull(NpmPackage.fromPackage(new ByteArrayInputStream(tgz), "test", false, 1000000));
    } finally {
      NpmPackage.setDefaultMaxLoadSize(NpmPackage.DEFAULT_MAX_LOAD_SIZE);
    }
  }

  // examples are in package/examples (the spec) or package/example (what the IG publisher wrote up to 2026) - fhir-ig-publisher#1373
  @Test
  void testExamplesInEitherFolder() throws IOException {
    Map<String, byte[]> files = new LinkedHashMap<>();
    files.put("package/Patient-root.json", patient("root"));
    files.put("package/examples/Patient-a.json", patient("a"));
    files.put("package/example/Patient-b.json", patient("b"));
    checkExamples(NpmPackage.fromPackage(new ByteArrayInputStream(buildTgz(files))));
  }

  @Test
  void testExamplesInEitherFolderFromCacheFolder(@TempDir Path dir) throws IOException {
    Files.createDirectories(dir.resolve("package/examples"));
    Files.createDirectories(dir.resolve("package/example"));
    Files.write(dir.resolve("package/package.json"), PACKAGE_JSON);
    Files.write(dir.resolve("package/Patient-root.json"), patient("root"));
    Files.write(dir.resolve("package/examples/Patient-a.json"), patient("a"));
    Files.write(dir.resolve("package/example/Patient-b.json"), patient("b"));
    checkExamples(NpmPackage.fromFolder(dir.toString()));
  }

  private void checkExamples(NpmPackage pkg) throws IOException {
    List<String> examples = pkg.listExamples();
    assertEquals(2, examples.size(), examples.toString());
    assertTrue(examples.contains("Patient-a.json"));
    assertTrue(examples.contains("Patient-b.json"));
    assertTrue(IOUtils.toString(pkg.loadExample("Patient-a.json"), StandardCharsets.UTF_8).contains("\"a\""));
    assertTrue(IOUtils.toString(pkg.loadExample("Patient-b.json"), StandardCharsets.UTF_8).contains("\"b\""));
    Assertions.assertThrows(IOException.class, () -> pkg.loadExample("Patient-root.json"));

    assertNotNull(pkg.loadExampleResource("Patient", "a"));
    assertNotNull(pkg.loadExampleResource("Patient", "b"));
    assertNull(pkg.loadExampleResource("Patient", "root"));

    int count = 0;
    for (NpmPackage.PackagedResourceFile f : pkg.listAllResources()) {
      if ("Patient".equals(f.getResourceType())) {
        count++;
        assertEquals(!f.getFilename().equals("Patient-root.json"), f.isExample(), f.getFolder()+"/"+f.getFilename());
      }
    }
    assertEquals(3, count);
  }

  @Test
  void testIsExampleFolder() {
    assertTrue(NpmPackage.isExampleFolder("examples"));
    assertTrue(NpmPackage.isExampleFolder("example"));
    assertTrue(NpmPackage.isExampleFolder("package/examples"));
    assertTrue(NpmPackage.isExampleFolder("package\\example"));
    assertFalse(NpmPackage.isExampleFolder("package"));
    assertFalse(NpmPackage.isExampleFolder("package/other"));
    assertFalse(NpmPackage.isExampleFolder("examples2"));
    assertFalse(NpmPackage.isExampleFolder(null));
  }

  @Test
  void testEntryNameKey() {
    assertEquals("package/examples/x.json", NpmPackage.entryNameKey("./package//Examples/X.json"));
    assertEquals("package/examples/x.json", NpmPackage.entryNameKey("package\\examples\\x.json"));
    assertEquals("package/package.json", NpmPackage.entryNameKey("/package/./package.json"));
    // NFC and NFD are the same name
    assertEquals(NpmPackage.entryNameKey("package/K\u00FDnigstein.json"), NpmPackage.entryNameKey("package/Ky\u0301nigstein.json"));
  }

  /** Two files of the same name (after normalisation, ignoring case): readers differ on which wins, so the package is refused */
  @Test
  void testDuplicateNames(@TempDir Path tempDir) throws IOException {
    byte[] exact = buildTgz("UTF-8", "package/package.json", "{\"name\":\"other\",\"version\":\"9.9.9\"}".getBytes(StandardCharsets.UTF_8));
    IOException thrown = Assertions.assertThrows(IOException.class, () -> NpmPackage.fromPackage(new ByteArrayInputStream(exact)));
    assertTrue(thrown.getMessage().contains("more than one file named package/package.json"), thrown.getMessage());

    byte[] variant = buildTgz("UTF-8", "./package/Package.JSON", PACKAGE_JSON);
    thrown = Assertions.assertThrows(IOException.class, () -> NpmPackage.fromPackage(new ByteArrayInputStream(variant)));
    assertTrue(thrown.getMessage().contains("which are the same file to some systems"), thrown.getMessage());

    // extracting to disk, as the package cache does
    thrown = Assertions.assertThrows(IOException.class, () -> NpmPackage.extractFromTgz(new ByteArrayInputStream(exact), "test", tempDir.resolve("x").toString(), true));
    assertTrue(thrown.getMessage().contains("more than one file named"), thrown.getMessage());

    // a zip (it can't hold the exact same name twice, but can hold two that differ in case)
    java.io.ByteArrayOutputStream zipBytes = new java.io.ByteArrayOutputStream();
    try (java.util.zip.ZipOutputStream zip = new java.util.zip.ZipOutputStream(zipBytes)) {
      for (String name : new String[] {"package/package.json", "package/PACKAGE.json"}) {
        zip.putNextEntry(new java.util.zip.ZipEntry(name));
        zip.write(PACKAGE_JSON);
        zip.closeEntry();
      }
    }
    thrown = Assertions.assertThrows(IOException.class, () -> NpmPackage.fromZip(new ByteArrayInputStream(zipBytes.toByteArray()), false, "test"));
    assertTrue(thrown.getMessage().contains("which are the same file to some systems"), thrown.getMessage());
  }

  /** A name with a .. segment (/ or \\ separated) is refused by every reader; .. elsewhere in a name is fine */
  @Test
  void testDotDotSegments(@TempDir Path tempDir) throws IOException {
    for (String name : new String[] {"package/../evil.json", "package\\..\\evil.json", "package/examples/.."}) {
      byte[] tgz = buildTgz("UTF-8", name, PACKAGE_JSON);
      IOException thrown = Assertions.assertThrows(IOException.class, () -> NpmPackage.fromPackage(new ByteArrayInputStream(tgz)), name);
      assertEquals("Entry with an illegal name: " + name, thrown.getMessage());
      thrown = Assertions.assertThrows(IOException.class, () -> NpmPackage.extractFromTgz(new ByteArrayInputStream(tgz), "test", tempDir.resolve("x").toString(), true), name);
      assertEquals("Entry with an illegal name: " + name, thrown.getMessage());
    }
    assertNotNull(NpmPackage.fromPackage(new ByteArrayInputStream(buildTgz("UTF-8", "package/Patient-a..b.json", patient("a")))));
  }

  private static final byte[] PACKAGE_JSON = "{\"name\":\"test\",\"version\":\"0.0.1\",\"fhirVersions\":[\"4.0.1\"],\"dependencies\":{}}"
    .getBytes(StandardCharsets.UTF_8);

  private static byte[] patient(String id) {
    return ("{\"resourceType\":\"Patient\",\"id\":\""+id+"\"}").getBytes(StandardCharsets.UTF_8);
  }

  private static byte[] buildTgz(Map<String, byte[]> files) throws IOException {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    try (GzipCompressorOutputStream gzipOut = new GzipCompressorOutputStream(baos);
         TarArchiveOutputStream tarOut = new TarArchiveOutputStream(gzipOut, "UTF-8")) {
      addTarEntry(tarOut, "package/package.json", PACKAGE_JSON);
      for (Map.Entry<String, byte[]> e : files.entrySet()) {
        addTarEntry(tarOut, e.getKey(), e.getValue());
      }
    }
    return baos.toByteArray();
  }

  // Created by claude-sonnet-4-6
  private static byte[] buildTgz(String encoding, String entryName) throws IOException {
    byte[] fileContent = "{\"resourceType\":\"Patient\",\"id\":\"example\"}".getBytes(StandardCharsets.UTF_8);
    return buildTgz(encoding, entryName, fileContent);
  }

  private static byte[] buildTgz(String encoding, String entryName, byte[] fileContent) throws IOException {
    byte[] packageJson = "{\"name\":\"test\",\"version\":\"0.0.1\",\"fhirVersions\":[\"4.0.1\"],\"dependencies\":{}}"
      .getBytes(StandardCharsets.UTF_8);
    // TarArchiveEntry turns the platform file separator into /, so on Windows it can't write a name with a \ in it.
    // Write the entry with / and put the \ back into its header afterwards, so every platform gets the same archive
    String written = entryName.replace('\\', '/');
    ByteArrayOutputStream tar = new ByteArrayOutputStream();
    try (TarArchiveOutputStream tarOut = new TarArchiveOutputStream(tar, encoding)) {
      addTarEntry(tarOut, "package/package.json", packageJson);
      addTarEntry(tarOut, written, fileContent);
    }
    byte[] bytes = tar.toByteArray();
    if (!written.equals(entryName)) {
      setTarEntryName(bytes, written, entryName, encoding);
    }
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    try (GzipCompressorOutputStream gzipOut = new GzipCompressorOutputStream(baos)) {
      gzipOut.write(bytes);
    }
    return baos.toByteArray();
  }

  /** rewrites the name in an entry's header (same length names only) and fixes the header checksum */
  private static void setTarEntryName(byte[] tar, String oldName, String newName, String encoding) throws IOException {
    byte[] o = oldName.getBytes(encoding);
    byte[] n = newName.getBytes(encoding);
    for (int h = 0; h + 512 <= tar.length; h += 512) {
      if (Arrays.equals(tar, h, h + o.length, o, 0, o.length) && (o.length == 100 || tar[h + o.length] == 0)) {
        System.arraycopy(n, 0, tar, h, n.length);
        Arrays.fill(tar, h + 148, h + 156, (byte) ' ');
        TarUtils.formatCheckSumOctalBytes(TarUtils.computeCheckSum(Arrays.copyOfRange(tar, h, h + 512)), tar, h + 148, 8);
        return;
      }
    }
    throw new IOException("No tar header for " + oldName);
  }

  // Created by claude-sonnet-4-6
  private static void addTarEntry(TarArchiveOutputStream tar, String name, byte[] content) throws IOException {
    TarArchiveEntry entry = new TarArchiveEntry(name);
    entry.setSize(content.length);
    tar.putArchiveEntry(entry);
    tar.write(content);
    tar.closeArchiveEntry();
  }

  /**
   * A zip (a template from a github repository) can't contain a name with ".." in it, any more than a tgz can:
   * unpacked, package/content/../scripts/ant.xml would replace scripts/ant.xml
   */
  @Test
  void testEvilZip() throws IOException {
    java.io.ByteArrayOutputStream bytes = new java.io.ByteArrayOutputStream();
    try (java.util.zip.ZipOutputStream zip = new java.util.zip.ZipOutputStream(bytes)) {
      zip.putNextEntry(new java.util.zip.ZipEntry("repo-main/package/package.json"));
      zip.write("{\"name\" : \"test.template\", \"version\" : \"1.0.0\"}".getBytes(StandardCharsets.UTF_8));
      zip.closeEntry();
      zip.putNextEntry(new java.util.zip.ZipEntry("repo-main/package/content/../scripts/ant.xml"));
      zip.write("<project/>".getBytes(StandardCharsets.UTF_8));
      zip.closeEntry();
    }
    IOException thrown = Assertions.assertThrows(IOException.class, () -> NpmPackage.fromZip(new ByteArrayInputStream(bytes.toByteArray()), true, "test"));
    assertEquals("Entry with an illegal name: repo-main/package/content/../scripts/ant.xml", thrown.getMessage());
  }
}
