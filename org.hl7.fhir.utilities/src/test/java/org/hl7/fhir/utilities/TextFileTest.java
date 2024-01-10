package org.hl7.fhir.utilities;

import org.junit.jupiter.api.*;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test bench for {@link TextFile}.
 *
 * @author Quentin Ligier
 **/
class TextFileTest {

  private static final String SAMPLE_CONTENT = "Line 1\nLine 2\nLine 3";
  private static final List<String> SAMPLE_CONTENT_LINES = List.of("Line 1", "Line 2", "Line 3");
  private static final String BOM = "\uFEFF";

  private static File readFile;
  private final static List<File> createdFiles = new ArrayList<>(4);

  @BeforeAll
  static void setUp() throws IOException {
    readFile = createTempFile();
    readFile.deleteOnExit();
    Files.writeString(readFile.toPath(), SAMPLE_CONTENT);
  }

  @AfterAll
  static void tearDown() throws IOException {
    for (final var file : createdFiles) {
      Files.deleteIfExists(file.toPath());
    }
  }

  @Test
  void testReadAllLines() throws IOException {
    final var readLines = TextFile.readAllLines(readFile.getAbsolutePath());
    assertEquals(3, readLines.size());
    assertEquals(SAMPLE_CONTENT_LINES, readLines);
  }

  @Test
  void testBytesToString1() {
    final var converted = TextFile.bytesToString(SAMPLE_CONTENT.getBytes(StandardCharsets.UTF_8));
    assertEquals(SAMPLE_CONTENT, converted);
  }

  @Test
  void testBytesToString2() {
    final var bytesWithoutBom = SAMPLE_CONTENT.getBytes(StandardCharsets.UTF_8);
    final var bomBytes = BOM.getBytes(StandardCharsets.UTF_8);
    final var bytesWithBom = Arrays.copyOf(bomBytes, bomBytes.length + bytesWithoutBom.length);
    System.arraycopy(bytesWithoutBom, 0, bytesWithBom, bomBytes.length, bytesWithoutBom.length);

    var converted = TextFile.bytesToString(bytesWithoutBom, true);
    assertEquals(SAMPLE_CONTENT, converted);

    converted = TextFile.bytesToString(bytesWithoutBom, false);
    assertEquals(SAMPLE_CONTENT, converted);

    converted = TextFile.bytesToString(bytesWithBom, true);
    assertEquals(SAMPLE_CONTENT, converted);

    converted = TextFile.bytesToString(bytesWithBom, false);
    assertEquals(BOM + SAMPLE_CONTENT, converted);
  }

  @Test
  void testFileToString1() throws IOException {
    final var read = TextFile.fileToString(readFile);
    assertEquals(SAMPLE_CONTENT, read);
  }

  @Test
  void testFileToString2() throws IOException {
    final var read = TextFile.fileToString(readFile.getAbsolutePath());
    assertEquals(SAMPLE_CONTENT, read);
  }

  @Test
  void testFileToBytes1() throws IOException {
    final var read = TextFile.fileToBytes(readFile);
    assertArrayEquals(SAMPLE_CONTENT.getBytes(StandardCharsets.UTF_8), read);
  }

  @Test
  void testFileToBytesNCS() throws IOException {
    final var read = TextFile.fileToBytesNCS(readFile.getAbsolutePath());
    assertArrayEquals(SAMPLE_CONTENT.getBytes(StandardCharsets.UTF_8), read);
  }

  @Test
  void testFileToBytes2() throws IOException {
    final var read = TextFile.fileToBytes(readFile.getAbsolutePath());
    assertArrayEquals(SAMPLE_CONTENT.getBytes(StandardCharsets.UTF_8), read);
  }

  @Test
  void testStringToFile() throws IOException {
    final var writeFile = createTempFile();
    TextFile.stringToFile(SAMPLE_CONTENT, writeFile, true);
    assertEquals(BOM + SAMPLE_CONTENT, Files.readString(writeFile.toPath()));

    TextFile.stringToFile(SAMPLE_CONTENT, writeFile, false);
    assertEquals(SAMPLE_CONTENT, Files.readString(writeFile.toPath()));
  }

  @Test
  void testWriteAllLines() throws IOException {
    final var writeFile = createTempFile();
    TextFile.writeAllLines(writeFile.getAbsolutePath(), SAMPLE_CONTENT_LINES);
    assertEquals(SAMPLE_CONTENT_LINES, Files.readAllLines(writeFile.toPath()));
  }

  private static File createTempFile() throws IOException {
    final var file = Files.createTempFile("test_fhir_utilities_", ".txt").toFile();
    file.deleteOnExit();
    createdFiles.add(file);
    return file;
  }
}