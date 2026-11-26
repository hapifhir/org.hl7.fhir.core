package org.hl7.fhir.utilities.npm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorOutputStream;
import org.junit.jupiter.api.Test;

/**
 * NpmPackage.readTgz is how every reader of a package (NpmPackage.readStream, extractFromTgz,
 * NpmPackageVersionConverter) gets the entries, and refuses the ones that are refused
 */
class NpmPackageReadTgzTests {

  private static byte[] tgz(String... namesAndContents) throws IOException {
    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
    try (TarArchiveOutputStream tar = new TarArchiveOutputStream(new GzipCompressorOutputStream(bytes))) {
      for (int i = 0; i < namesAndContents.length; i = i + 2) {
        TarArchiveEntry entry = new TarArchiveEntry(namesAndContents[i]);
        byte[] content = namesAndContents[i+1] == null ? new byte[0] : namesAndContents[i+1].getBytes(StandardCharsets.UTF_8);
        if (namesAndContents[i+1] != null) {
          entry.setSize(content.length);
        }
        tar.putArchiveEntry(entry);
        tar.write(content);
        tar.closeArchiveEntry();
      }
    }
    return bytes.toByteArray();
  }

  private static class Recorder implements NpmPackage.TgzEntryHandler {
    final List<String> seen = new ArrayList<>();

    @Override
    public void folder(String name) {
      seen.add("folder " + name);
    }

    @Override
    public void file(String name, InputStream content) throws IOException {
      seen.add("file " + name + " = " + new String(content.readAllBytes(), StandardCharsets.UTF_8));
    }
  }

  @Test
  void handsOverTheEntriesInOrderAndCountsTheSize() throws IOException {
    byte[] tgz = tgz("package/", null, "package/package.json", "{}", "package/other/x.json", "abcde");
    Recorder r = new Recorder();
    long size = NpmPackage.readTgz(new ByteArrayInputStream(tgz), "test", 0, r);
    assertEquals(List.of("folder package/", "file package/package.json = {}", "file package/other/x.json = abcde"), r.seen);
    assertEquals(7, size);
  }

  @Test
  void aFileThatIsNotReadIsNotCounted() throws IOException {
    byte[] tgz = tgz("package/a.json", "0123456789", "package/b.json", "0123456789");
    long size = NpmPackage.readTgz(new ByteArrayInputStream(tgz), "test", 15, new NpmPackage.TgzEntryHandler() {
      @Override
      public void folder(String name) {
      }

      @Override
      public void file(String name, InputStream content) {
        // skipped
      }
    });
    assertEquals(0, size);
  }

  @Test
  void refusesWhatDecompressesPastTheLimit() throws IOException {
    byte[] tgz = tgz("package/a.json", "0123456789", "package/b.json", "0123456789");
    IOException e = assertThrows(IOException.class, () -> NpmPackage.readTgz(new ByteArrayInputStream(tgz), "test", 15, new Recorder()));
    assertTrue(e.getMessage().contains("exceeds the limit of 15"), e.getMessage());
    assertEquals(20, NpmPackage.readTgz(new ByteArrayInputStream(tgz), "test", 20, new Recorder()));
  }

  @Test
  void refusesTwoFilesOfTheSameName() throws IOException {
    byte[] tgz = tgz("package/a.json", "1", "package/A.json", "2");
    assertThrows(IOException.class, () -> NpmPackage.readTgz(new ByteArrayInputStream(tgz), "test", 0, new Recorder()));
  }

  @Test
  void refusesANameWithADotDotSegment() throws IOException {
    byte[] tgz = tgz("package/../evil.json", "1");
    assertThrows(IOException.class, () -> NpmPackage.readTgz(new ByteArrayInputStream(tgz), "test", 0, new Recorder()));
  }

  @Test
  void refusesSomethingThatIsNotATgz() {
    assertThrows(IOException.class, () -> NpmPackage.readTgz(new ByteArrayInputStream("not a package".getBytes(StandardCharsets.UTF_8)), "test", 0, new Recorder()));
  }
}
