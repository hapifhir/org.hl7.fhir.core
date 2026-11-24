package org.hl7.fhir.utilities.filesystem;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * File access can be limited to the files under some folders (the IG publisher: the IG's folder, temp and ~/.fhir).
 * What counts is where a file really is: .. and symbolic links can't get out, and /ig-other isn't under /ig
 */
class ManagedFileAccessAllowedPathsTest {

  @TempDir
  Path dir;

  @AfterEach
  void reset() {
    ManagedFileAccess.setAllowedPaths(ManagedFileAccess.defaultAllowedPaths());
    ManagedFileAccess.setAccessPolicy(ManagedFileAccess.defaultFileAccessPolicy());
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

  /** a file in a folder: the name comes from a zip entry, a reference etc, so it has to stay in the folder */
  @Test
  void aFileInAFolderStaysInTheFolder() throws IOException {
    Path ig = setUp();
    assertEquals(ig.resolve("in.txt").toFile(), ManagedFileAccess.file(ig.toString(), "in.txt"));
    assertEquals(ig.resolve("sub/a.txt").toFile(), ManagedFileAccess.file(ig.toFile(), "sub/a.txt"));
    ManagedFileAccess.file(ig.toString(), "sub/../in.txt");
    ManagedFileAccess.csfile(ig.toString(), "in.txt");
    for (String name : new String[] {"../ig-other/secret.txt", "../../etc/passwd", "sub/../../ig-other/secret.txt", "..", "", "."}) {
      assertThrows(IOException.class, () -> ManagedFileAccess.file(ig.toString(), name), name);
      assertThrows(IOException.class, () -> ManagedFileAccess.file(ig.toFile(), name), name);
      assertThrows(IOException.class, () -> ManagedFileAccess.csfile(ig.toString(), name), name);
      assertThrows(IOException.class, () -> ManagedFileAccess.csfile(ig.toFile(), name), name);
    }
    // even when there's no limit on where files can be
    ManagedFileAccess.setAllowedPaths(null);
    assertThrows(IOException.class, () -> ManagedFileAccess.file(ig.toString(), "../ig-other/secret.txt"));
    assertThrows(IOException.class, () -> ManagedFileAccess.csfile(ig.toFile(), "../../etc/passwd"));
  }

  /** the file in the folder is checked, not just the folder: a link in the folder can lead somewhere else */
  @Test
  void aFileInAFolderIsWhereItReallyIs() throws IOException {
    Path ig = setUp();
    Files.createSymbolicLink(ig.resolve("linked-folder"), dir.resolve("ig-other"));
    assertThrows(IOException.class, () -> ManagedFileAccess.file(ig.toString(), "linked-folder/secret.txt"));
    assertThrows(IOException.class, () -> ManagedFileAccess.csfile(ig.toString(), "linked-folder/secret.txt"));
  }

  /** opening a File follows the policy, as opening a path does */
  @Test
  void openingAFileFollowsThePolicy() throws IOException {
    Path ig = setUp();
    ManagedFileAccess.setAllowedPaths(null);
    ManagedFileAccess.setAccessPolicy(ManagedFileAccess.FileAccessPolicy.PROHIBITED);
    assertThrows(FileNotFoundException.class, () -> ManagedFileAccess.inStream(ig.resolve("in.txt").toFile()));
    assertThrows(FileNotFoundException.class, () -> ManagedFileAccess.outStream(ig.resolve("out.txt").toFile()));
    assertThrows(IOException.class, () -> ManagedFileAccess.inStream(ig.resolve("in.txt").toString()));
    assertFalse(Files.exists(ig.resolve("out.txt")));
    ManagedFileAccess.setAccessPolicy(ManagedFileAccess.FileAccessPolicy.DIRECT);
    ManagedFileAccess.inStream(ig.resolve("in.txt").toFile()).close();
    ManagedFileAccess.outStream(ig.resolve("out.txt").toFile()).close();
  }

  /**
   * A string that isn't a path on this platform (on Windows, a URL - : isn't allowed in a name; everywhere, a NUL) is
   * refused with an IOException, not the unchecked InvalidPathException
   */
  @Test
  void aStringThatIsntAPathIsRefused() throws IOException {
    Path ig = setUp();
    String bad = ig.resolve("a").toString() + "\u0000b";
    assertThrows(IOException.class, () -> ManagedFileAccess.file(bad));
    assertThrows(IOException.class, () -> ManagedFileAccess.inStream(bad));
    assertThrows(IOException.class, () -> ManagedFileAccess.file(ig.toString(), "a\u0000b"));
    ManagedFileAccess.setAllowedPaths(null);
    assertThrows(IOException.class, () -> ManagedFileAccess.file(ig.toString(), "a\u0000b"));
  }

  /** a way into the file system: given a folder, use the file "secret.txt" in it (or the folder itself, or a new file in it) */
  interface Access {
    Object use(Path ig, Path folder) throws IOException;
  }

  static java.util.stream.Stream<org.junit.jupiter.params.provider.Arguments> accesses() {
    return java.util.stream.Stream.of(
      access("file(String)", (ig, f) -> ManagedFileAccess.file(f.resolve("secret.txt").toString())),
      access("csfile(String)", (ig, f) -> ManagedFileAccess.csfile(f.resolve("secret.txt").toString())),
      access("file(String, String)", (ig, f) -> ManagedFileAccess.file(ig.toString(), ig.relativize(f.resolve("secret.txt")).toString())),
      access("file(File, String)", (ig, f) -> ManagedFileAccess.file(ig.toFile(), ig.relativize(f.resolve("secret.txt")).toString())),
      access("csfile(String, String)", (ig, f) -> ManagedFileAccess.csfile(ig.toString(), ig.relativize(f.resolve("secret.txt")).toString())),
      access("csfile(File, String)", (ig, f) -> ManagedFileAccess.csfile(ig.toFile(), ig.relativize(f.resolve("secret.txt")).toString())),
      access("inStream(String)", (ig, f) -> close(ManagedFileAccess.inStream(f.resolve("secret.txt").toString()))),
      access("inStream(File)", (ig, f) -> close(ManagedFileAccess.inStream(f.resolve("secret.txt").toFile()))),
      access("outStream(String)", (ig, f) -> close(ManagedFileAccess.outStream(f.resolve("new.txt").toString()))),
      access("outStream(File)", (ig, f) -> close(ManagedFileAccess.outStream(f.resolve("new.txt").toFile()))),
      access("fromPath", (ig, f) -> ManagedFileAccess.fromPath(f.resolve("secret.txt"))),
      access("listFiles", (ig, f) -> ManagedFileAccess.listFiles(f.toFile())));
  }

  private static org.junit.jupiter.params.provider.Arguments access(String name, Access a) {
    return org.junit.jupiter.params.provider.Arguments.of(name, a);
  }

  private static Object close(java.io.Closeable c) throws IOException {
    c.close();
    return c;
  }

  /** every way in refuses the folder next to the IG's, however it's reached: by .., by a link, or by name (/ig-other isn't in /ig) */
  @org.junit.jupiter.params.ParameterizedTest(name = "{0}")
  @org.junit.jupiter.params.provider.MethodSource("accesses")
  void everyWayInIsLimited(String name, Access access) throws IOException {
    Path ig = setUp();
    Files.createSymbolicLink(ig.resolve("linked-folder"), dir.resolve("ig-other"));
    for (Path other : new Path[] {ig.resolve("..").resolve("ig-other"), ig.resolve("linked-folder"), dir.resolve("ig-other")}) {
      assertThrows(IOException.class, () -> access.use(ig, other), name+": "+other);
    }
    assertFalse(Files.exists(dir.resolve("ig-other").resolve("new.txt")));
    // and the IG's own folder is fine
    Files.write(ig.resolve("secret.txt"), "not secret".getBytes(StandardCharsets.UTF_8));
    access.use(ig, ig);
  }

  /** PROHIBITED: every way in is refused, even to the IG's folder */
  @org.junit.jupiter.params.ParameterizedTest(name = "{0}")
  @org.junit.jupiter.params.provider.MethodSource("accesses")
  void everyWayInIsProhibited(String name, Access access) throws IOException {
    Path ig = setUp();
    Files.write(ig.resolve("secret.txt"), "not secret".getBytes(StandardCharsets.UTF_8));
    ManagedFileAccess.setAccessPolicy(ManagedFileAccess.FileAccessPolicy.PROHIBITED);
    assertThrows(IOException.class, () -> access.use(ig, ig), name);
    assertFalse(Files.exists(ig.resolve("new.txt")));
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

  /** a temporary file is made in a folder that may be accessed, and not in one that can't */
  @Test
  void tempFilesGoWherePolicyAllows() throws IOException {
    Path ig = setUp();
    File f = ManagedFileAccess.createTempFile(ig.toFile(), "tmp-", ".txt");
    assertTrue(f.isFile());
    assertEquals(ig.toRealPath(), f.getParentFile().toPath().toRealPath());
    assertThrows(IOException.class, () -> ManagedFileAccess.createTempFile(dir.resolve("ig-other").toFile(), "tmp-", ".txt"));
  }

  /** without a folder, temporary files and folders go in the system temp folder, which has to be one that may be accessed */
  @Test
  void theSystemTempFolderHasToBeAllowed() throws IOException {
    setUp(); // only the IG's folder
    assertThrows(IOException.class, () -> ManagedFileAccess.createTempFile("tmp-", ".txt"));
    assertThrows(IOException.class, () -> ManagedFileAccess.createTempDirectory("tmp-"));
    ManagedFileAccess.setAllowedPaths(List.of(System.getProperty("java.io.tmpdir")));
    File f = ManagedFileAccess.createTempFile("tmp-", ".txt");
    f.deleteOnExit();
    assertTrue(f.isFile());
    File d = ManagedFileAccess.createTempDirectory("tmp-");
    d.deleteOnExit();
    assertTrue(d.isDirectory());
  }
}
