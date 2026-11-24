package org.hl7.fhir.validation.special;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    Files.writeString(dir.resolve("manifest.json"), "{\n  \"resourceType\" : \"Parameters\"\n}");
    Files.writeString(dir.resolve("ValueSet-x.json"), "{}");
    Files.writeString(dir.resolve("CodeSystem-y-1.0.0.json"), "{}");
    assertDoesNotThrow(() -> PackageReGenerator.checkOutputFolderCanBeCleared(dir.toString()));
  }

  @Test
  void anEarlierXmlRunsOutputCanBeCleared() throws IOException {
    Path dir = tempDir;
    Files.writeString(dir.resolve("manifest.xml"), "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<Parameters xmlns=\"http://hl7.org/fhir\"/>");
    Files.writeString(dir.resolve("ValueSet-x.xml"), "<ValueSet/>");
    assertDoesNotThrow(() -> PackageReGenerator.checkOutputFolderCanBeCleared(dir.toString()));
  }

  /** a manifest.json on its own doesn't make a folder output: other tools write manifest.json too */
  @Test
  void aManifestThatIsNotParametersIsNotEnough() throws IOException {
    Path dir = tempDir;
    Files.writeString(dir.resolve("manifest.json"), "{ \"name\" : \"my-web-app\", \"icons\" : [] }");
    Files.writeString(dir.resolve("ValueSet-x.json"), "{}");
    assertThrows(IOException.class, () -> PackageReGenerator.checkOutputFolderCanBeCleared(dir.toString()));
  }

  @Test
  void anEarlierRunsOutputWithSomethingElseInItIsNotCleared() throws IOException {
    Path dir = tempDir;
    Files.writeString(dir.resolve("manifest.json"), "{\"resourceType\":\"Parameters\"}");
    Files.writeString(dir.resolve("ValueSet-x.json"), "{}");
    Files.writeString(dir.resolve("notes.txt"), "precious");
    assertThrows(IOException.class, () -> PackageReGenerator.checkOutputFolderCanBeCleared(dir.toString()));
  }

  @Test
  void anEarlierRunsOutputWithAFolderInItIsNotCleared() throws IOException {
    Path dir = tempDir;
    Files.writeString(dir.resolve("manifest.json"), "{\"resourceType\":\"Parameters\"}");
    Files.createDirectory(dir.resolve("src"));
    assertThrows(IOException.class, () -> PackageReGenerator.checkOutputFolderCanBeCleared(dir.toString()));
  }

  @Test
  void otherFilesWithoutAManifestAreNotCleared() throws IOException {
    Path dir = tempDir;
    Files.writeString(dir.resolve("ValueSet-x.json"), "{}");
    assertThrows(IOException.class, () -> PackageReGenerator.checkOutputFolderCanBeCleared(dir.toString()));
  }

  @ParameterizedTest
  @ValueSource(strings = {"package.json", "data.json", "valueset-x.json", "ValueSet-.json", "-x.json", "Value2Set-x.json", "ValueSet-x.txt", "ValueSet-x.json.bak"})
  void filesNotNamedAsOutputAreNotCleared(String name) throws IOException {
    Path dir = tempDir;
    Files.writeString(dir.resolve("manifest.json"), "{\"resourceType\":\"Parameters\"}");
    Files.writeString(dir.resolve(name), "{}");
    assertThrows(IOException.class, () -> PackageReGenerator.checkOutputFolderCanBeCleared(dir.toString()));
  }

  @Test
  void aFolderWithOtherThingsInItIsNotCleared() throws IOException {
    Path dir = tempDir;
    Files.writeString(dir.resolve("thesis.docx"), "precious");
    assertThrows(IOException.class, () -> PackageReGenerator.checkOutputFolderCanBeCleared(dir.toString()));
  }
}
