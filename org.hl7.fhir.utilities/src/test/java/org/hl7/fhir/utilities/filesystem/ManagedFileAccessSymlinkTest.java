package org.hl7.fhir.utilities.filesystem;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.io.TempDir;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Symbolic links and .. together. The file system follows a link before it applies the .. after it, so
 * ig/out-link/../secret.txt is next to where out-link leads, not ig/secret.txt: a check that normalises the text first
 * (as Path.normalize() does) is checking a different file from the one that gets opened.
 * <p/>
 * dir is a temp folder, and only dir/ig is allowed. Each nested class builds just the files and links its cases use,
 * and shows that layout in its own comment.
 * <p/>
 * In the {@code whereAPathReallyIs} cases, path is relative to dir/ig, written as it is (not normalised); real is where
 * it really is, relative to dir (empty: nowhere, because it leads to a link to nowhere).
 * <p/>
 * Not on Windows: there, the file system itself takes .. off the text before it follows any link, so
 * ig/out-link/../secret.txt really is ig/secret.txt (and making links needs privileges)
 */
@DisabledOnOs(OS.WINDOWS)
class ManagedFileAccessSymlinkTest {

  @TempDir
  Path systemTempDir;

  private Path tempPath; // tmp, where it really is (on macOS, /var is a link to /private/var)
  private Path igPath;

  @BeforeEach
  void setUp() throws IOException {
    tempPath = systemTempDir.toRealPath();
    igPath = Files.createDirectories(tempPath.resolve("ig"));
    ManagedFileAccess.setAllowedPaths(List.of(igPath.toString()));
  }

  @AfterEach
  void reset() {
    ManagedFileAccess.setAllowedPaths(ManagedFileAccess.defaultAllowedPaths());
    ManagedFileAccess.setAccessPolicy(ManagedFileAccess.defaultFileAccessPolicy());
  }

  // --- building a layout (paths are relative to dir) ---

  private void file(String path, String content) throws IOException {
    Path p = tempPath.resolve(path);
    Files.createDirectories(p.getParent());
    Files.write(p, content.getBytes(StandardCharsets.UTF_8));
  }

  private void folder(String path) throws IOException {
    Files.createDirectories(tempPath.resolve(path));
  }

  /** target is used as it is: an absolute path, or a relative one (relative to the link's folder) */
  private void link(String path, Path target) throws IOException {
    Files.createSymbolicLink(tempPath.resolve(path), target);
  }

  // --- checks ---

  private void assertWhereItReallyIs(String path, String real, boolean inside) {
    String igPathName = igPath.toString() + "/" + path;
    Path realIgPath = ManagedFileAccess.realPath(igPathName);
    if (real.isEmpty()) {
      assertNull(realIgPath, path);
    } else {
      assertEquals(tempPath.resolve(real), realIgPath, path);
    }
    assertEquals(inside, ManagedFileAccess.isInside(igPath.toString(), igPathName), path);
  }

  /** every way in agrees: the one-argument forms, and a name in the IG's folder (the name from a zip entry, say) */
  private void assertEveryWayInRejects(String path) {
    String p = igPath.toString() + "/" + path;
    assertThrows(IOException.class, () -> ManagedFileAccess.file(p), path);
    assertThrows(IOException.class, () -> ManagedFileAccess.csfile(p), path);
    assertThrows(IOException.class, () -> ManagedFileAccess.inStream(p), path);
    assertThrows(IOException.class, () -> ManagedFileAccess.inStream(new java.io.File(p)), path);
    assertThrows(IOException.class, () -> ManagedFileAccess.fromPath(Paths.get(p)), path);
    assertThrows(IOException.class, () -> ManagedFileAccess.file(igPath.toString(), path), path);
    assertThrows(IOException.class, () -> ManagedFileAccess.file(igPath.toFile(), path), path);
    assertThrows(IOException.class, () -> ManagedFileAccess.csfile(igPath.toString(), path), path);
  }

  /** reads a path relative to dir/ig */
  private String read(String path) throws IOException {
    try (InputStream in = ManagedFileAccess.inStream(igPath + "/" + path)) {
      return new String(in.readAllBytes(), StandardCharsets.UTF_8);
    }
  }

  /** all the paths of 1 to maxDepth steps, each step one of steps */
  private static List<String> allPaths(String[] steps, int maxDepth) {
    List<String> paths = new ArrayList<>();
    List<String> last = List.of("");
    for (int depth = 1; depth <= maxDepth; depth++) {
      List<String> next = new ArrayList<>();
      for (String prefix : last) {
        for (String s : steps) {
          next.add(prefix.isEmpty() ? s : prefix + "/" + s);
        }
      }
      paths.addAll(next);
      last = next;
    }
    return paths;
  }

  /**
   * No links: . and .. are only text.
   * <pre>
   * dir/ig/in.txt
   * dir/ig/a/b/
   * dir/outside/secret.txt
   * </pre>
   */
  @Nested
  class PlainPaths {

    @BeforeEach
    void layout() throws IOException {
      file("ig/in.txt", "in");
      folder("ig/a/b");
      file("outside/secret.txt", "secret");
    }

    @ParameterizedTest(name = "{0}")
    @CsvSource({
      "in.txt,                          ig/in.txt,                true",
      "./in.txt,                        ig/in.txt,                true",
      "a/b/../../in.txt,                ig/in.txt,                true",
      "a/./b/../../in.txt,              ig/in.txt,                true",
      "../outside/secret.txt,           outside/secret.txt,       false",
      "a/../../outside/secret.txt,      outside/secret.txt,       false",
      // what doesn't exist yet is plain folders - but a .. can lead back into what does exist
      "new/sub/file.txt,                ig/new/sub/file.txt,      true",
      "new/../in.txt,                   ig/in.txt,                true",
      "new/../../outside/secret.txt,    outside/secret.txt,       false",
    })
    void whereAPathReallyIs(String path, String real, boolean inside) {
      assertWhereItReallyIs(path, real, inside);
    }

    @Test
    void aNameInTheIgFolderIsInTheIgFolder() throws IOException {
      assertEquals(igPath.resolve("in.txt").toFile(), ManagedFileAccess.file(igPath.toString(), "in.txt"));
    }
  }

  /**
   * A link that stays inside, then ..: the folder above where it leads, not above the link.
   * <pre>
   * dir/ig/in.txt
   * dir/ig/a/b/
   * dir/ig/in-link   -&gt; dir/ig/a/b
   * dir/outside/secret.txt
   * </pre>
   */
  @Nested
  class LinkThatStaysInside {

    @BeforeEach
    void layout() throws IOException {
      file("ig/in.txt", "in");
      folder("ig/a/b");
      link("ig/in-link", igPath.resolve("a/b"));
      file("outside/secret.txt", "secret");
    }

    @ParameterizedTest(name = "{0}")
    @CsvSource({
      "in-link/x.txt,                   ig/a/b/x.txt,             true",
      "in-link/../x.txt,                ig/a/x.txt,               true",
      "in-link/../../in.txt,            ig/in.txt,                true",
      "in-link/../../../outside/secret.txt, outside/secret.txt,   false",
      // a folder that doesn't exist yet, then .. back to the link
      "new/../in-link/../x.txt,         ig/a/x.txt,               true",
    })
    void whereAPathReallyIs(String path, String real, boolean inside) {
      assertWhereItReallyIs(path, real, inside);
    }

    @ParameterizedTest(name = "{0}")
    @ValueSource(strings = {
      "in-link/../../../outside/secret.txt",
    })
    void everyWayInRejects(String path) {
      assertEveryWayInRejects(path);
    }

    @Test
    void readingAndWritingThroughItIsFine() throws IOException {
      assertEquals("in", read("in-link/../../in.txt"));
      ManagedFileAccess.outStream(igPath + "/in-link/../made.txt").close();
      assertTrue(Files.exists(igPath.resolve("a/made.txt")));
    }
  }

  /**
   * A link out, then ..: this is what normalising the text first let through (it looks like ig/secret.txt).
   * <pre>
   * dir/ig/in.txt
   * dir/ig/out-link  -&gt; dir/outside/target
   * dir/outside/secret.txt
   * dir/outside/target/inner.txt
   * </pre>
   */
  @Nested
  class LinkOut {

    @BeforeEach
    void layout() throws IOException {
      file("ig/in.txt", "in");
      file("outside/secret.txt", "secret");
      file("outside/target/inner.txt", "inner");
      link("ig/out-link", tempPath.resolve("outside/target"));
    }

    @ParameterizedTest(name = "{0}")
    @CsvSource({
      "out-link/inner.txt,              outside/target/inner.txt, false",
      "out-link/../secret.txt,          outside/secret.txt,       false",
      "out-link/../new.txt,             outside/new.txt,          false",
      "out-link/./../secret.txt,        outside/secret.txt,       false",
      // out and back in again is in
      "out-link/../../ig/in.txt,        ig/in.txt,                true",
      // with folders that don't exist yet, before or after the link
      "new/../out-link/../secret.txt,   outside/secret.txt,       false",
      "new/x/../../out-link/inner.txt,  outside/target/inner.txt, false",
      "out-link/new/../../secret.txt,   outside/secret.txt,       false",
    })
    void whereAPathReallyIs(String path, String real, boolean inside) {
      assertWhereItReallyIs(path, real, inside);
    }

    @ParameterizedTest(name = "{0}")
    @ValueSource(strings = {
      "out-link/../secret.txt",
      "new/../out-link/../secret.txt",
    })
    void everyWayInRejects(String path) {
      assertEveryWayInRejects(path);
    }

    @Test
    void outAndBackInCanBeRead() throws IOException {
      assertEquals("in", read("out-link/../../ig/in.txt"));
    }

    /** writing through a link and .. writes nothing outside */
    @Test
    void writingThroughItThenDotDotWritesNothingOutside() throws IOException {
      assertThrows(IOException.class, () -> ManagedFileAccess.outStream(igPath + "/out-link/../new.txt").close());
      assertThrows(IOException.class, () -> ManagedFileAccess.outStream(new java.io.File(igPath + "/out-link/../new.txt")).close());
      assertThrows(IOException.class, () -> ManagedFileAccess.createTempFile(new java.io.File(igPath + "/out-link/.."), "tmp-", ".txt"));
      assertFalse(Files.exists(tempPath.resolve("outside/new.txt")));
      try (Stream<Path> s = Files.list(tempPath.resolve("outside"))) {
        assertEquals(2, s.count()); // secret.txt and target, and nothing new
      }
    }

    /** an allowed folder named through a link and .. is where it really is, too */
    @Test
    void allowedPathsAreWhereTheyReallyAre() throws IOException {
      ManagedFileAccess.setAllowedPaths(List.of(igPath + "/out-link/.."));
      assertEquals(List.of(tempPath.resolve("outside").toString()), ManagedFileAccess.getAllowedPaths());
      ManagedFileAccess.inStream(tempPath.resolve("outside/secret.txt").toString()).close();
      assertThrows(IOException.class, () -> ManagedFileAccess.inStream(igPath.resolve("in.txt").toString()));
    }
  }

  /**
   * A relative link to the folder above.
   * <pre>
   * dir/ig/in.txt
   * dir/ig/up        -&gt; ..   (relative: dir)
   * dir/ig/out-link  -&gt; dir/outside/target
   * dir/outside/secret.txt
   * dir/outside/target/
   * </pre>
   */
  @Nested
  class LinkToTheFolderAbove {

    @BeforeEach
    void layout() throws IOException {
      file("ig/in.txt", "in");
      file("outside/secret.txt", "secret");
      folder("outside/target");
      link("ig/up", Paths.get(".."));
      link("ig/out-link", tempPath.resolve("outside/target"));
    }

    @ParameterizedTest(name = "{0}")
    @CsvSource({
      "up/outside/secret.txt,           outside/secret.txt,       false",
      "up/ig/in.txt,                    ig/in.txt,                true",
      "up/ig/out-link/../secret.txt,    outside/secret.txt,       false",
    })
    void whereAPathReallyIs(String path, String real, boolean inside) {
      assertWhereItReallyIs(path, real, inside);
    }

    @ParameterizedTest(name = "{0}")
    @ValueSource(strings = {
      "up/ig/out-link/../secret.txt",
    })
    void everyWayInRejects(String path) {
      assertEveryWayInRejects(path);
    }
  }

  /**
   * Links to links, and a link to a file.
   * <pre>
   * dir/ig/in.txt
   * dir/ig/chain1    -&gt; chain2 (relative)
   * dir/ig/chain2    -&gt; dir/outside/target
   * dir/ig/file-link -&gt; dir/ig/in.txt
   * dir/outside/secret.txt
   * dir/outside/target/inner.txt
   * </pre>
   */
  @Nested
  class LinksToLinks {

    @BeforeEach
    void layout() throws IOException {
      file("ig/in.txt", "in");
      file("outside/secret.txt", "secret");
      file("outside/target/inner.txt", "inner");
      link("ig/chain2", tempPath.resolve("outside/target"));
      link("ig/chain1", Paths.get("chain2"));
      link("ig/file-link", igPath.resolve("in.txt"));
    }

    @ParameterizedTest(name = "{0}")
    @CsvSource({
      "chain1/inner.txt,                outside/target/inner.txt, false",
      "chain1/../secret.txt,            outside/secret.txt,       false",
      "file-link,                       ig/in.txt,                true",
    })
    void whereAPathReallyIs(String path, String real, boolean inside) {
      assertWhereItReallyIs(path, real, inside);
    }

    @ParameterizedTest(name = "{0}")
    @ValueSource(strings = {
      "chain1/../secret.txt",
    })
    void everyWayInRejects(String path) {
      assertEveryWayInRejects(path);
    }

    @Test
    void aLinkToAFileInsideCanBeRead() throws IOException {
      assertEquals("in", read("file-link"));
    }
  }

  /**
   * A link to nowhere is nowhere.
   * <pre>
   * dir/ig/dangling  -&gt; dir/nowhere
   * </pre>
   */
  @Nested
  class DanglingLink {

    @BeforeEach
    void layout() throws IOException {
      link("ig/dangling", tempPath.resolve("nowhere"));
    }

    @ParameterizedTest(name = "{0}")
    @CsvSource({
      "dangling,                        '',                       false",
      "dangling/x.txt,                  '',                       false",
    })
    void whereAPathReallyIs(String path, String real, boolean inside) {
      assertWhereItReallyIs(path, real, inside);
    }
  }

  /**
   * Against the file system itself, for every path of up to 4 steps through the layout (the folders, the links, .,
   * .., and a folder that doesn't exist): where the path exists, realPath has to say what toRealPath() (the file
   * system) says; and the policy allows it exactly when that's inside dir/ig. Where it doesn't exist, realPath must
   * still not put it inside dir/ig if the part that exists isn't.
   * <pre>
   * dir/ig/in.txt
   * dir/ig/a/b/
   * dir/ig/in-link   -&gt; dir/ig/a/b
   * dir/ig/out-link  -&gt; dir/outside/target
   * dir/ig/up        -&gt; ..   (relative: dir)
   * dir/ig/chain1    -&gt; chain2 (relative), dir/ig/chain2 -&gt; dir/outside/target
   * dir/ig/file-link -&gt; dir/ig/in.txt
   * dir/outside/target/
   * </pre>
   */
  @Nested
  class EveryPathAgainstTheFileSystem {

    @BeforeEach
    void layout() throws IOException {
      file("ig/in.txt", "in");
      folder("ig/a/b");
      folder("outside/target");
      Path target = tempPath.resolve("outside/target");
      link("ig/in-link", igPath.resolve("a/b"));
      link("ig/out-link", target);
      link("ig/up", Paths.get(".."));
      link("ig/chain2", target);
      link("ig/chain1", Paths.get("chain2"));
      link("ig/file-link", igPath.resolve("in.txt"));
    }

    @Test
    void agreesWithTheFileSystemForEveryPath() throws IOException {
      String[] steps = {"a", "b", "..", ".", "in-link", "out-link", "up", "chain1", "file-link", "new", "ig", "outside", "target"};
      List<String> paths = new ArrayList<>();
      paths.add("");
      paths.addAll(allPaths(steps, 4));
      Path realIg = igPath.toRealPath();
      int existing = 0;
      for (String path : paths) {
        String p = path.isEmpty() ? igPath.toString() : igPath + "/" + path;
        Path rp = ManagedFileAccess.realPath(p);
        Path os;
        try {
          os = Paths.get(p).toRealPath();
        } catch (IOException e) {
          os = null;
        }
        if (os != null) {
          existing++;
          assertEquals(os, rp, path);
          assertEquals(os.startsWith(realIg), ManagedFileAccess.isInside(igPath.toString(), p), path);
          if (!os.startsWith(realIg)) {
            assertThrows(IOException.class, () -> ManagedFileAccess.file(p), path);
          }
        }
      }
      assertTrue(existing > 300, "only " + existing + " paths existed"); // the walk is doing what it's meant to
    }
  }

  /**
   * For a path that doesn't exist yet, the file system's answer is where it ends up once its missing folders are made.
   * Each path gets a fresh copy of the layout (the folders made for one would change the next), so this takes a
   * sample: every path of up to 3 steps that has a missing folder in it. The layout, in a new folder root under dir
   * for each path:
   * <pre>
   * root/ig/a/b/
   * root/ig/in-link  -&gt; root/ig/a/b
   * root/ig/out-link -&gt; root/outside/target
   * root/ig/up       -&gt; ..   (relative: root)
   * root/outside/target/
   * </pre>
   */
  @Nested
  class MissingFoldersAgainstTheFileSystem {

    /** builds the layout in a new folder, and returns its ig folder */
    private Path freshLayout() throws IOException {
      Path root = Files.createTempDirectory(tempPath, "case").toRealPath();
      Path cig = Files.createDirectories(root.resolve("ig"));
      Files.createDirectories(cig.resolve("a/b"));
      Path target = Files.createDirectories(root.resolve("outside/target"));
      Files.createSymbolicLink(cig.resolve("in-link"), cig.resolve("a/b"));
      Files.createSymbolicLink(cig.resolve("out-link"), target);
      Files.createSymbolicLink(cig.resolve("up"), Paths.get(".."));
      return cig;
    }

    @Test
    void agreesWithTheFileSystemOnceTheMissingFoldersAreMade() throws IOException {
      String[] steps = {"..", "in-link", "out-link", "up", "new", "a"};
      int checked = 0;
      for (String path : allPaths(steps, 3)) {
        if (!path.contains("new")) {
          continue;
        }
        ManagedFileAccess.setAllowedPaths(null);
        Path cig = freshLayout();
        String p = cig + "/" + path + "/f.txt";
        Path rp = ManagedFileAccess.realPath(p);
        // make the missing folders, as the file system goes (Files.createDirectories works on the text, so a step at a time)
        Path cur = cig;
        for (String s : path.split("/")) {
          cur = cur.resolve(s);
          if (!Files.exists(cur)) {
            Files.createDirectory(cur);
          }
        }
        Files.write(Paths.get(p), new byte[0]);
        Path os = Paths.get(p).toRealPath();
        assertEquals(os, rp, path);
        checked++;
      }
      assertTrue(checked > 50, "only " + checked + " checked");
    }
  }
}
