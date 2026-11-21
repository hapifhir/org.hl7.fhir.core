package org.hl7.fhir.utilities;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import static org.junit.jupiter.api.Assertions.*;

/** unzipping only ever writes into the target folder */
class CompressionUtilitiesTest {

  @TempDir
  Path dir;

  private static ByteArrayInputStream zip(String... namesAndContent) throws IOException {
    ByteArrayOutputStream b = new ByteArrayOutputStream();
    try (ZipOutputStream z = new ZipOutputStream(b)) {
      for (int i = 0; i < namesAndContent.length; i += 2) {
        z.putNextEntry(new ZipEntry(namesAndContent[i]));
        if (namesAndContent[i + 1] != null) {
          z.write(namesAndContent[i + 1].getBytes(StandardCharsets.UTF_8));
        }
        z.closeEntry();
      }
    }
    return new ByteArrayInputStream(b.toByteArray());
  }

  @Test
  void unzipsIntoTheFolder() throws IOException {
    Path target = Files.createDirectories(dir.resolve("target"));
    CompressionUtilities.unzip(zip("a.txt", "a", "sub/", null, "sub/b.txt", "b"), target);
    assertEquals("a", Files.readString(target.resolve("a.txt")));
    assertEquals("b", Files.readString(target.resolve("sub/b.txt")));
  }

  /** a target written with . or .. in it is fine (it refused every entry) */
  @Test
  void aTargetWithDotsInItIsFine() throws IOException {
    Path target = Files.createDirectories(dir.resolve("target"));
    Files.createDirectories(dir.resolve("other"));
    CompressionUtilities.unzip(zip("a.txt", "a"), dir.resolve("other/../target/."));
    assertEquals("a", Files.readString(target.resolve("a.txt")));
  }

  @ParameterizedTest
  @ValueSource(strings = {"../evil.txt", "sub/../../evil.txt", "../target-other/evil.txt"})
  void entriesThatLeaveTheFolderAreRefused(String name) throws IOException {
    Path target = Files.createDirectories(dir.resolve("target"));
    assertThrows(IOException.class, () -> CompressionUtilities.unzip(zip(name, "evil"), target));
    assertFalse(Files.exists(dir.resolve("evil.txt")));
    assertFalse(Files.exists(dir.resolve("target-other")));
  }

  /** a link in the folder (already there, or put there by the zip) isn't written through */
  @Test
  void entriesAreNotWrittenThroughLinks() throws IOException {
    Path target = Files.createDirectories(dir.resolve("target"));
    Path elsewhere = Files.createDirectories(dir.resolve("elsewhere"));
    Path precious = Files.writeString(dir.resolve("precious.txt"), "precious");
    Files.createSymbolicLink(target.resolve("linked"), elsewhere);
    Files.createSymbolicLink(target.resolve("file.txt"), precious);
    assertThrows(IOException.class, () -> CompressionUtilities.unzip(zip("linked/evil.txt", "evil"), target));
    assertThrows(IOException.class, () -> CompressionUtilities.unzip(zip("file.txt", "evil"), target));
    assertFalse(Files.exists(elsewhere.resolve("evil.txt")));
    assertEquals("precious", Files.readString(precious));
    assertTrue(Files.isSymbolicLink(target.resolve("file.txt")));
  }

  @Test
  void aTargetThatIsALinkIsRefused() throws IOException {
    Path elsewhere = Files.createDirectories(dir.resolve("elsewhere"));
    Path link = Files.createSymbolicLink(dir.resolve("target"), elsewhere);
    assertThrows(IOException.class, () -> CompressionUtilities.unzip(zip("a.txt", "a"), link));
    assertFalse(Files.exists(elsewhere.resolve("a.txt")));
  }
}
