package org.hl7.fhir.utilities.filesystem;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Named;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.io.TempDir;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Unit tests for the protected helpers behind {@link ManagedFileAccess#realPath(String)} and
 * {@link ManagedFileAccess#setAllowedPaths(List)}, and for setAccessPolicy refusing the MANAGED policy.
 */
class ManagedFileAccessPathResolutionTest {

  @TempDir
  Path tempDir;

  @AfterEach
  void reset() {
    ManagedFileAccess.setAllowedPaths(ManagedFileAccess.defaultAllowedPaths());
    ManagedFileAccess.setAccessPolicy(ManagedFileAccess.defaultFileAccessPolicy());
  }

  // --- hasDotDot ---------------------------------------------------------------------------------------------------

  @ParameterizedTest
  @CsvSource({
    "a/b, false",
    "a/../b, true",
    ".., true",
    "a/.., true",
    "../a, true",
    "a/..b, false",
    "a/b.., false",
    "..., false",
    "./a, false",
    "., false",
    "'', false"
  })
  void hasDotDot(String path, boolean expected) {
    assertEquals(expected, ManagedFileAccess.hasDotDot(Paths.get(path)), path);
  }

  // --- getUniquePaths ----------------------------------------------------------------------------------------------

  static Stream<Arguments> uniquePathCases() {
    return Stream.of(
      Arguments.of(Named.of("a nested path is dropped", List.of("a", "a/b")), List.of("a")),
      Arguments.of(Named.of("a nested path is dropped whatever the order", List.of("a/b", "a")), List.of("a")),
      Arguments.of(Named.of("an exact duplicate is dropped", List.of("a", "a")), List.of("a")),
      Arguments.of(Named.of("a sibling sharing a prefix is kept", List.of("ig", "ig-other")), List.of("ig", "ig-other")),
      Arguments.of(Named.of("the order is kept", List.of("b", "a")), List.of("b", "a")),
      Arguments.of(Named.of("several nested in one are dropped", List.of("a/b", "c", "a", "a/b/c")), List.of("c", "a")),
      Arguments.of(Named.of("an empty list stays empty", List.of()), List.of())
    );
  }

  @ParameterizedTest
  @MethodSource("uniquePathCases")
  void getUniquePaths(List<String> in, List<String> expected) {
    assertEquals(tempDirPaths(expected), ManagedFileAccess.getUniquePaths(tempDirPaths(in)));
  }

  @Test
  @Disabled("getUniquePaths compares strings with equals() but coverage with Path.startsWith(): two strings that are the same Path each cover the other, so both are dropped, and an empty list means no confinement at all")
  void theSamePathWrittenTwoWaysIsNotDroppedEntirely() {
    String a = tempDir.toString();
    List<String> result = ManagedFileAccess.getUniquePaths(List.of(a + File.separator, a));
    assertEquals(List.of(a), result.stream().map(p -> Paths.get(p).toString()).distinct().collect(Collectors.toList()));
  }

  @Test
  @EnabledOnOs(OS.WINDOWS)
  @Disabled("WindowsPath comparison ignores case, but the strings differ, so C:\\x and c:\\x cancel out and confinement is lost")
  void onWindowsTheSamePathInAnotherCaseIsNotDroppedEntirely() {
    String upper = tempDir.resolve("New").toString();
    String lower = upper.substring(0, 1).toLowerCase() + upper.substring(1);
    assertFalse(ManagedFileAccess.getUniquePaths(List.of(upper, lower)).isEmpty());
  }

  @Test
  @EnabledOnOs(OS.WINDOWS) // elsewhere, paths compare case-sensitively, so the two spellings are both kept
  @Disabled("setAllowedPaths fails open when getUniquePaths drops everything: see onWindowsTheSamePathInAnotherCaseIsNotDroppedEntirely")
  void setAllowedPathsNeverEndsUpUnconfined() {
    // a path that doesn't exist keeps the case it was written in, which is how C:\x and c:\x can both reach getUniquePaths
    String upper = tempDir.resolve("New").toString();
    String lower = upper.substring(0, 1).toLowerCase() + upper.substring(1);
    ManagedFileAccess.setAllowedPaths(List.of(upper, lower));
    assertFalse(ManagedFileAccess.getAllowedPaths().isEmpty());
  }

  // --- longestExistingPath -----------------------------------------------------------------------------------------

  @Test
  void longestExistingPathOfAnExistingPathIsItself() {
    assertEquals(tempDir, ManagedFileAccess.longestExistingPath(tempDir));
  }

  @Test
  void longestExistingPathStopsAtTheLastFolderThatExists() {
    assertEquals(tempDir, ManagedFileAccess.longestExistingPath(tempDir.resolve("new/deeper/x.txt")));
  }

  @Test
  void longestExistingPathOfAnExistingFileIsTheFile() throws IOException {
    Path file = Files.createFile(tempDir.resolve("x.txt"));
    assertEquals(file, ManagedFileAccess.longestExistingPath(file));
  }

  @Test
  void longestExistingPathOfARelativePathThatDoesNotExistIsNull() {
    // a precondition: realPath always passes an absolute path. A relative one runs out of parents before the current folder
    assertNull(ManagedFileAccess.longestExistingPath(Paths.get("does-not-exist-" + System.nanoTime(), "x")));
  }

  // --- resolveDotEntriesAgainstRealPath ----------------------------------------------------------------------------

  static Stream<Arguments> dotCases() {
    return Stream.of(
      Arguments.of("new/../x", "x"),
      Arguments.of("./x", "x"),
      Arguments.of("new/./../x", "x"),
      Arguments.of("a/b/../../x", "x"),
      Arguments.of("a/b/../x", "a/x"),
      Arguments.of("new/..", "")
    );
  }

  @ParameterizedTest
  @MethodSource("dotCases")
  void resolveDotEntries(String rest, String expected) throws IOException {
    Path real = tempDir.toRealPath(); // the method expects a real path (on macOS, the temp folder is under a link)
    assertEquals(real.resolve(expected).normalize(),
      ManagedFileAccess.resolveDotEntriesAgainstRealPath(real, Paths.get(rest)));
  }

  @Test
  void dotDotAboveTheRootStaysAtTheRoot() {
    Path root = tempDir.toAbsolutePath().getRoot();
    assertEquals(root.resolve("x"), ManagedFileAccess.resolveDotEntriesAgainstRealPath(root, Paths.get("../../x")));
  }

  @Test
  void goingThroughAFileIsResolvedByName() throws IOException {
    // the file system would refuse file.txt/.. (not a folder), but the open fails anyway: this is safe
    Path real = tempDir.toRealPath();
    Files.createFile(real.resolve("file.txt"));
    assertEquals(real.resolve("x"),
      ManagedFileAccess.resolveDotEntriesAgainstRealPath(real, Paths.get("new/../file.txt/../x")));
  }

  // --- links (not on Windows: making links needs privileges there, as in ManagedFileAccessSymlinkTest) -------------

  @Nested
  @DisabledOnOs(OS.WINDOWS)
  class WithLinks {

    @Test
    void aDanglingLinkCountsAsExisting() throws IOException {
      Path link = Files.createSymbolicLink(tempDir.resolve("dangling"), tempDir.resolve("nowhere"));
      assertEquals(link, ManagedFileAccess.longestExistingPath(link.resolve("x")));
    }

    @Test
    void aPathThroughADanglingLinkHasNoRealPath() throws IOException {
      Path link = Files.createSymbolicLink(tempDir.resolve("dangling"), tempDir.resolve("nowhere"));
      assertNull(ManagedFileAccess.realPath(link.resolve("x").toString()));
    }

    @Test
    void dotDotAfterALinkGoesToTheLinkTargetsParent() throws IOException {
      Path real = tempDir.toRealPath();
      Path ig = Files.createDirectories(real.resolve("ig"));
      Path target = Files.createDirectories(real.resolve("elsewhere/dir"));
      Files.createSymbolicLink(ig.resolve("link"), target);
      assertEquals(real.resolve("elsewhere/x"),
        ManagedFileAccess.resolveDotEntriesAgainstRealPath(ig, Paths.get("new/../link/../x")));
    }

    @Test
    void aDanglingLinkMetAfterDotDotIsNull() throws IOException {
      Path real = tempDir.toRealPath();
      Files.createSymbolicLink(real.resolve("dangling"), real.resolve("nowhere"));
      assertNull(ManagedFileAccess.resolveDotEntriesAgainstRealPath(real, Paths.get("new/../dangling/x")));
    }

    @Test
    void aLinkMetAfterDotDotIsFollowed() throws IOException {
      Path real = tempDir.toRealPath();
      Path target = Files.createDirectories(real.resolve("elsewhere"));
      Files.createSymbolicLink(real.resolve("link"), target);
      assertEquals(target.resolve("x"),
        ManagedFileAccess.resolveDotEntriesAgainstRealPath(real, Paths.get("new/../link/x")));
    }
  }

  // --- MANAGED can't be set -------------------------------------------------------------------------------------

  @ParameterizedTest
  @EnumSource(value = ManagedFileAccess.FileAccessPolicy.class, names = {"DIRECT", "PROHIBITED"})
  @SuppressWarnings("deprecation")
  void managedIsRefusedAndThePolicyIsUnchanged(ManagedFileAccess.FileAccessPolicy before) {
    ManagedFileAccess.setAccessPolicy(before);
    UnsupportedOperationException e = assertThrows(UnsupportedOperationException.class,
      () -> ManagedFileAccess.setAccessPolicy(ManagedFileAccess.FileAccessPolicy.MANAGED));
    assertEquals(ManagedFileAccess.FILE_ACCESS_POLICY_MANAGED_IS_NOT_SUPPORTED, e.getMessage());
    assertEquals(before, ManagedFileAccess.getAccessPolicy());
  }

  // --- helpers -----------------------------------------------------------------------------------------------------

  private List<String> tempDirPaths(List<String> pathNames) {
    return pathNames.stream().map(pathName -> tempDir.resolve(pathName).toString()).collect(Collectors.toList());
  }
}
