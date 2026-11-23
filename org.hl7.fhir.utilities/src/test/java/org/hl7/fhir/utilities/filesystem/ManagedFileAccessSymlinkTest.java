package org.hl7.fhir.utilities.filesystem;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.io.TempDir;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Symbolic links and .. together. The file system follows a link before it applies the .. after it, so
 * ig/out-link/../secret.txt is next to where out-link leads, not ig/secret.txt: a check that normalises the text first
 * (as Path.normalize() does) is checking a different file from the one that gets opened.
 * <p/>
 * The layout (dir is a temp folder; only dir/ig is allowed):
 * <pre>
 * dir/ig/in.txt
 * dir/ig/a/b/             (folders)
 * dir/ig/in-link   -&gt; dir/ig/a/b
 * dir/ig/out-link  -&gt; dir/outside/target
 * dir/ig/up        -&gt; ..   (relative: dir)
 * dir/ig/chain1    -&gt; chain2 (relative), dir/ig/chain2 -&gt; dir/outside/target
 * dir/ig/file-link -&gt; dir/ig/in.txt
 * dir/ig/dangling  -&gt; dir/nowhere
 * dir/outside/secret.txt
 * dir/outside/target/inner.txt
 * </pre>
 * Not on Windows: there, the file system itself takes .. off the text before it follows any link, so
 * ig/out-link/../secret.txt really is ig/secret.txt (and making links needs privileges)
 */
@DisabledOnOs(OS.WINDOWS)
class ManagedFileAccessSymlinkTest {

  @TempDir
  Path tmp;

  private Path dir; // tmp, where it really is (on macOS, /var is a link to /private/var)
  private Path ig;

  @BeforeEach
  void setUp() throws IOException {
    dir = tmp.toRealPath();
    ig = Files.createDirectories(dir.resolve("ig"));
    Files.write(ig.resolve("in.txt"), "in".getBytes(StandardCharsets.UTF_8));
    Files.createDirectories(ig.resolve("a/b"));
    Path target = Files.createDirectories(dir.resolve("outside/target"));
    Files.write(target.resolve("inner.txt"), "inner".getBytes(StandardCharsets.UTF_8));
    Files.write(dir.resolve("outside/secret.txt"), "secret".getBytes(StandardCharsets.UTF_8));
    Files.createSymbolicLink(ig.resolve("in-link"), ig.resolve("a/b"));
    Files.createSymbolicLink(ig.resolve("out-link"), target);
    Files.createSymbolicLink(ig.resolve("up"), Paths.get(".."));
    Files.createSymbolicLink(ig.resolve("chain2"), target);
    Files.createSymbolicLink(ig.resolve("chain1"), Paths.get("chain2"));
    Files.createSymbolicLink(ig.resolve("file-link"), ig.resolve("in.txt"));
    Files.createSymbolicLink(ig.resolve("dangling"), dir.resolve("nowhere"));
    ManagedFileAccess.setAllowedPaths(List.of(ig.toString()));
  }

  @AfterEach
  void reset() {
    ManagedFileAccess.setAllowedPaths(ManagedFileAccess.defaultAllowedPaths());
    ManagedFileAccess.setAccessPolicy(ManagedFileAccess.defaultFileAccessPolicy());
  }

  /**
   * path is relative to dir/ig, written as it is (not normalised); real is where it really is, relative to dir (empty:
   * nowhere - it leads to a link to nowhere)
   */
  @ParameterizedTest(name = "{0}")
  @CsvSource({
    // plain paths
    "in.txt,                          ig/in.txt,                true",
    "./in.txt,                        ig/in.txt,                true",
    "a/b/../../in.txt,                ig/in.txt,                true",
    "a/./b/../../in.txt,              ig/in.txt,                true",
    "../outside/secret.txt,           outside/secret.txt,       false",
    "a/../../outside/secret.txt,      outside/secret.txt,       false",
    // a link that stays inside, then ..: the folder above where it leads, not above the link
    "in-link/x.txt,                   ig/a/b/x.txt,             true",
    "in-link/../x.txt,                ig/a/x.txt,               true",
    "in-link/../../in.txt,            ig/in.txt,                true",
    "in-link/../../../outside/secret.txt, outside/secret.txt,   false",
    // a link out, then ..: this is what normalising the text first let through (it looks like ig/secret.txt)
    "out-link/inner.txt,              outside/target/inner.txt, false",
    "out-link/../secret.txt,          outside/secret.txt,       false",
    "out-link/../new.txt,             outside/new.txt,          false",
    "out-link/./../secret.txt,        outside/secret.txt,       false",
    // out and back in again is in
    "out-link/../../ig/in.txt,        ig/in.txt,                true",
    // a relative link to the folder above
    "up/outside/secret.txt,           outside/secret.txt,       false",
    "up/ig/in.txt,                    ig/in.txt,                true",
    "up/ig/out-link/../secret.txt,    outside/secret.txt,       false",
    // links to links
    "chain1/inner.txt,                outside/target/inner.txt, false",
    "chain1/../secret.txt,            outside/secret.txt,       false",
    "file-link,                       ig/in.txt,                true",
    // what doesn't exist yet is plain folders - but a .. can lead back into what does exist
    "new/sub/file.txt,                ig/new/sub/file.txt,      true",
    "new/../in.txt,                   ig/in.txt,                true",
    "new/../../outside/secret.txt,    outside/secret.txt,       false",
    "new/../out-link/../secret.txt,   outside/secret.txt,       false",
    "new/../in-link/../x.txt,         ig/a/x.txt,               true",
    "new/x/../../out-link/inner.txt,  outside/target/inner.txt, false",
    "out-link/new/../../secret.txt,   outside/secret.txt,       false",
    // a link to nowhere is nowhere
    "dangling,                        '',                       false",
    "dangling/x.txt,                  '',                       false",
  })
  void whereAPathReallyIs(String path, String real, boolean inside) throws IOException {
    String p = ig.toString() + "/" + path;
    Path rp = ManagedFileAccess.realPath(p);
    if (real.isEmpty()) {
      assertNull(rp, path);
    } else {
      assertEquals(dir.resolve(real), rp, path);
    }
    assertEquals(inside, ManagedFileAccess.isInside(ig.toString(), p), path);
  }

  /** every way in agrees: the one-argument forms, and a name in the IG's folder (the name from a zip entry, say) */
  @ParameterizedTest(name = "{0}")
  @CsvSource({
    "out-link/../secret.txt",
    "chain1/../secret.txt",
    "up/ig/out-link/../secret.txt",
    "new/../out-link/../secret.txt",
    "in-link/../../../outside/secret.txt",
  })
  void aLinkThenDotDotCantGetOut(String path) throws IOException {
    String p = ig.toString() + "/" + path;
    assertThrows(IOException.class, () -> ManagedFileAccess.file(p), path);
    assertThrows(IOException.class, () -> ManagedFileAccess.csfile(p), path);
    assertThrows(IOException.class, () -> ManagedFileAccess.inStream(p), path);
    assertThrows(IOException.class, () -> ManagedFileAccess.inStream(new java.io.File(p)), path);
    assertThrows(IOException.class, () -> ManagedFileAccess.fromPath(Paths.get(p)), path);
    assertThrows(IOException.class, () -> ManagedFileAccess.file(ig.toString(), path), path);
    assertThrows(IOException.class, () -> ManagedFileAccess.file(ig.toFile(), path), path);
    assertThrows(IOException.class, () -> ManagedFileAccess.csfile(ig.toString(), path), path);
  }

  /** writing through a link and .. writes nothing outside */
  @Test
  void writingThroughALinkThenDotDotWritesNothingOutside() {
    assertThrows(IOException.class, () -> ManagedFileAccess.outStream(ig + "/out-link/../new.txt").close());
    assertThrows(IOException.class, () -> ManagedFileAccess.outStream(new java.io.File(ig + "/out-link/../new.txt")).close());
    assertThrows(IOException.class, () -> ManagedFileAccess.createTempFile(new java.io.File(ig + "/out-link/.."), "tmp-", ".txt"));
    assertFalse(Files.exists(dir.resolve("outside/new.txt")));
    try (java.util.stream.Stream<Path> s = Files.list(dir.resolve("outside"))) {
      assertEquals(2, s.count()); // secret.txt and target, and nothing new
    } catch (IOException e) {
      fail(e);
    }
  }

  /** what's inside is still fine, links and .. included */
  @Test
  void whatIsInsideIsStillFine() throws IOException {
    assertEquals("in", new String(ManagedFileAccess.inStream(ig + "/in-link/../../in.txt").readAllBytes(), StandardCharsets.UTF_8));
    assertEquals("in", new String(ManagedFileAccess.inStream(ig + "/file-link").readAllBytes(), StandardCharsets.UTF_8));
    assertEquals("in", new String(ManagedFileAccess.inStream(ig + "/out-link/../../ig/in.txt").readAllBytes(), StandardCharsets.UTF_8));
    ManagedFileAccess.outStream(ig + "/in-link/../made.txt").close();
    assertTrue(Files.exists(ig.resolve("a/made.txt")));
    assertEquals(ig.resolve("in.txt").toFile(), ManagedFileAccess.file(ig.toString(), "in.txt"));
  }

  /** an allowed folder named through a link and .. is where it really is, too */
  @Test
  void allowedPathsAreWhereTheyReallyAre() throws IOException {
    ManagedFileAccess.setAllowedPaths(List.of(ig + "/out-link/.."));
    assertEquals(List.of(dir.resolve("outside").toString()), ManagedFileAccess.getAllowedPaths());
    ManagedFileAccess.inStream(dir.resolve("outside/secret.txt").toString()).close();
    assertThrows(IOException.class, () -> ManagedFileAccess.inStream(ig.resolve("in.txt").toString()));
  }

  /**
   * Against the file system itself, for every path of up to 4 steps through the layout (the folders, the links, .,
   * .., and a folder that doesn't exist): where the path exists, realPath has to say what toRealPath() (the file
   * system) says; and the policy allows it exactly when that's inside dir/ig. Where it doesn't exist, realPath must
   * still not put it inside dir/ig if the part that exists isn't
   */
  @Test
  void agreesWithTheFileSystemForEveryPath() throws IOException {
    String[] steps = {"a", "b", "..", ".", "in-link", "out-link", "up", "chain1", "file-link", "new", "ig", "outside", "target"};
    List<String> paths = new ArrayList<>();
    paths.add("");
    List<String> last = List.of("");
    for (int depth = 1; depth <= 4; depth++) {
      List<String> next = new ArrayList<>();
      for (String prefix : last) {
        for (String s : steps) {
          next.add(prefix.isEmpty() ? s : prefix + "/" + s);
        }
      }
      paths.addAll(next);
      last = next;
    }
    Path realIg = ig.toRealPath();
    int existing = 0;
    for (String path : paths) {
      String p = path.isEmpty() ? ig.toString() : ig + "/" + path;
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
        assertEquals(os.startsWith(realIg), ManagedFileAccess.isInside(ig.toString(), p), path);
        if (!os.startsWith(realIg)) {
          assertThrows(IOException.class, () -> ManagedFileAccess.file(p), path);
        }
      }
    }
    assertTrue(existing > 300, "only " + existing + " paths existed"); // the walk is doing what it's meant to
  }

  /**
   * For a path that doesn't exist yet, the file system's answer is where it ends up once its missing folders are made.
   * Each path gets a fresh copy of the layout (the folders made for one would change the next), so this takes a
   * sample: every path of up to 3 steps that has a missing folder in it
   */
  @Test
  void agreesWithTheFileSystemOnceTheMissingFoldersAreMade() throws IOException {
    String[] steps = {"..", "in-link", "out-link", "up", "new", "a"};
    List<String> paths = new ArrayList<>();
    List<String> last = List.of("");
    for (int depth = 1; depth <= 3; depth++) {
      List<String> next = new ArrayList<>();
      for (String prefix : last) {
        for (String s : steps) {
          next.add(prefix.isEmpty() ? s : prefix + "/" + s);
        }
      }
      paths.addAll(next);
      last = next;
    }
    int checked = 0;
    for (String path : paths) {
      if (!path.contains("new")) {
        continue;
      }
      String file = path + "/f.txt";
      // a fresh layout, in its own folder
      ManagedFileAccess.setAllowedPaths(null);
      Path root = Files.createTempDirectory(dir, "case").toRealPath();
      Path cig = Files.createDirectories(root.resolve("ig"));
      Files.createDirectories(cig.resolve("a/b"));
      Path target = Files.createDirectories(root.resolve("outside/target"));
      Files.createSymbolicLink(cig.resolve("in-link"), cig.resolve("a/b"));
      Files.createSymbolicLink(cig.resolve("out-link"), target);
      Files.createSymbolicLink(cig.resolve("up"), Paths.get(".."));
      String p = cig + "/" + file;
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
