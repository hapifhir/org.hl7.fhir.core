package org.hl7.fhir.utilities.filesystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

/**
 * File access can be limited to the files under some folders (the IG publisher: the IG's folder, temp and ~/.fhir).
 * What counts is where a file really is: .. and symbolic links can't get out, and /ig-other isn't under /ig
 */
class ManagedFileAccessAllowedPathsTest {

  @TempDir
  Path dir;

  @AfterEach
  void reset() {
    ManagedFileAccess.setAllowedPaths(null);
  }

  private Path setUp() throws IOException {
    Path ig = Files.createDirectories(dir.resolve("ig"));
    Files.write(ig.resolve("in.txt"), "in".getBytes(StandardCharsets.UTF_8));
    Path other = Files.createDirectories(dir.resolve("ig-other"));
    Files.write(other.resolve("secret.txt"), "secret".getBytes(StandardCharsets.UTF_8));
    ManagedFileAccess.setAllowedPaths(List.of(ig.toString()));
    return ig;
  }

  @Test
  void filesInsideAreFine() throws IOException {
    Path ig = setUp();
    assertEquals("in", new String(ManagedFileAccess.inStream(ig.resolve("in.txt").toString()).readAllBytes(), StandardCharsets.UTF_8));
    Files.createDirectories(ig.resolve("sub"));
    ManagedFileAccess.outStream(ig.resolve("sub/../out.txt").toString()).close();
    ManagedFileAccess.file(ig.resolve("not-yet/there.txt").toString());
  }

  @Test
  void filesOutsideAreRefused() throws IOException {
    Path ig = setUp();
    assertThrows(IOException.class, () -> ManagedFileAccess.inStream(dir.resolve("ig-other/secret.txt").toString()));
    assertThrows(IOException.class, () -> ManagedFileAccess.inStream(ig.resolve("../ig-other/secret.txt").toString()));
    assertThrows(IOException.class, () -> ManagedFileAccess.outStream(dir.resolve("ig-other/new.txt").toString()));
    assertThrows(IOException.class, () -> ManagedFileAccess.file(dir.resolve("ig-other").toString()));
    assertThrows(FileNotFoundException.class, () -> ManagedFileAccess.inStream(dir.resolve("ig-other/secret.txt").toFile()));
    assertThrows(FileNotFoundException.class, () -> ManagedFileAccess.outStream(dir.resolve("ig-other/new.txt").toFile()));
  }

  @Test
  void linksAreFollowed() throws IOException {
    Path ig = setUp();
    Files.createSymbolicLink(ig.resolve("link.txt"), dir.resolve("ig-other/secret.txt"));
    Files.createSymbolicLink(ig.resolve("linked-folder"), dir.resolve("ig-other"));
    Files.createSymbolicLink(ig.resolve("broken.txt"), dir.resolve("nowhere.txt"));
    assertThrows(IOException.class, () -> ManagedFileAccess.inStream(ig.resolve("link.txt").toString()));
    assertThrows(IOException.class, () -> ManagedFileAccess.outStream(ig.resolve("linked-folder/new.txt").toString()));
    assertThrows(IOException.class, () -> ManagedFileAccess.file(ig.resolve("broken.txt").toString()));
  }

  @Test
  void noLimitByDefault() throws IOException {
    setUp();
    ManagedFileAccess.setAllowedPaths(null);
    ManagedFileAccess.inStream(dir.resolve("ig-other/secret.txt").toString()).close();
  }

  /** working out a folder or a file name from a path opens nothing, so the policy doesn't apply (even to a relative path) */
  @Test
  void pathTextIsNotPoliced() throws IOException {
    setUp();
    assertEquals("input" + java.io.File.separator + "resources", org.hl7.fhir.utilities.FileUtilities.getDirectoryForFile("input/resources/StructureDefinition-x.json"));
    assertEquals("StructureDefinition-x", org.hl7.fhir.utilities.FileUtilities.fileTitle("input/resources/StructureDefinition-x.json"));
  }

  /** a folder inside another, or the same one twice, isn't listed again */
  @Test
  void pathsInsideOthersAreNotRepeated() throws IOException {
    Path fhir = Files.createDirectories(dir.resolve(".fhir"));
    Path packages = Files.createDirectories(fhir.resolve("packages"));
    Path settings = fhir.resolve("fhir-settings.json");
    Path ig = Files.createDirectories(dir.resolve("ig"));
    Path igOther = Files.createDirectories(dir.resolve("ig-other"));
    ManagedFileAccess.setAllowedPaths(java.util.Arrays.asList(ig.toString(), fhir.toString(), packages.toString(), settings.toString(), ig.toString(), igOther.toString()));
    assertEquals(List.of(ig.toRealPath().toString(), fhir.toRealPath().toString(), igOther.toRealPath().toString()), ManagedFileAccess.getAllowedPaths());
  }
}
