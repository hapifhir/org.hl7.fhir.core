package org.hl7.fhir.utilities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class ZipGeneratorTest {

  @TempDir
  Path tmp;

  private void link(Path link, Path target) {
    try {
      Files.createSymbolicLink(link, target);
    } catch (IOException | UnsupportedOperationException e) {
      Assumptions.abort("Symbolic links not supported here: " + e.getMessage());
    }
  }

  private Map<String, String> zipAndRead(Path src) throws IOException {
    Path zip = tmp.resolve("out.zip");
    ZipGenerator gen = new ZipGenerator(zip.toString());
    gen.addFolder(src.toString(), "", false);
    gen.close();
    Map<String, String> res = new HashMap<>();
    try (ZipInputStream zin = new ZipInputStream(Files.newInputStream(zip))) {
      ZipEntry e;
      while ((e = zin.getNextEntry()) != null) {
        res.put(e.getName(), new String(zin.readAllBytes(), StandardCharsets.UTF_8));
      }
    }
    return res;
  }

  @Test
  void fileSymlinkWithDifferentNameIsFollowed() throws IOException {
    // the node_modules/.bin/xlsx -> ../xlsx/bin/xlsx.njs case
    Path src = Files.createDirectories(tmp.resolve("src"));
    Path bin = Files.createDirectories(src.resolve("xlsx/bin"));
    Files.writeString(bin.resolve("xlsx.njs"), "script");
    Path dotBin = Files.createDirectories(src.resolve(".bin"));
    link(dotBin.resolve("xlsx"), Paths.get("../xlsx/bin/xlsx.njs"));

    Map<String, String> entries = zipAndRead(src);
    assertEquals("script", entries.get("xlsx/bin/xlsx.njs"));
    assertEquals("script", entries.get(".bin/xlsx"));
  }

  @Test
  void brokenSymlinkIsSkipped() throws IOException {
    Path src = Files.createDirectories(tmp.resolve("src"));
    Files.writeString(src.resolve("real.txt"), "real");
    link(src.resolve("dangling.txt"), Paths.get("does-not-exist.txt"));

    Map<String, String> entries = zipAndRead(src);
    assertEquals("real", entries.get("real.txt"));
    assertFalse(entries.containsKey("dangling.txt"));
  }

  @Test
  void directorySymlinkIsSkippedSoCyclesTerminate() throws IOException {
    Path src = Files.createDirectories(tmp.resolve("src"));
    Path sub = Files.createDirectories(src.resolve("sub"));
    Files.writeString(sub.resolve("a.txt"), "a");
    link(sub.resolve("loop"), Paths.get(".."));

    Map<String, String> entries = zipAndRead(src);
    assertEquals("a", entries.get("sub/a.txt"));
    assertTrue(entries.keySet().stream().noneMatch(n -> n.contains("loop")));
  }
}
