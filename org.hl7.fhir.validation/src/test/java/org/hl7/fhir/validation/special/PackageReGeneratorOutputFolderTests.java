package org.hl7.fhir.validation.special;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

/** -re-package empties its output folder, but only one that is empty or holds an earlier run's output */
class PackageReGeneratorOutputFolderTests {

  @TempDir
  Path tempDir;

  @Test
  void aNewOrEmptyFolderCanBeCleared() throws IOException {
    Path dir = tempDir;
    assertDoesNotThrow(() -> PackageReGenerator.checkOutputFolderCanBeCleared(dir.resolve("new").toString()));
    assertDoesNotThrow(() -> PackageReGenerator.checkOutputFolderCanBeCleared(dir.toString()));
  }

  @Test
  void anEarlierRunsOutputCanBeCleared() throws IOException {
    Path dir = tempDir;
    Files.writeString(dir.resolve("manifest.json"), "{}");
    Files.writeString(dir.resolve("ValueSet-x.json"), "{}");
    assertDoesNotThrow(() -> PackageReGenerator.checkOutputFolderCanBeCleared(dir.toString()));
  }

  @Test
  void aFolderWithOtherThingsInItIsNotCleared() throws IOException {
    Path dir = tempDir;
    Files.writeString(dir.resolve("thesis.docx"), "precious");
    assertThrows(IOException.class, () -> PackageReGenerator.checkOutputFolderCanBeCleared(dir.toString()));
  }
}
