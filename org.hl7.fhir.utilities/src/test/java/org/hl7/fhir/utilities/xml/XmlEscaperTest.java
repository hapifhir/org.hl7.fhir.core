package org.hl7.fhir.utilities.xml;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class XmlEscaperTest {

  /** The escaping as it was done before, one character and one write at a time. */
  private static byte[] reference(byte[] input) throws IOException {
    ByteArrayOutputStream target = new ByteArrayOutputStream();
    BufferedReader buffer = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(input)));
    int i;
    while ((i = buffer.read()) != -1) {
      char c = (char) i;
      if (c == '<')
        target.write("&lt;".getBytes(StandardCharsets.UTF_8));
      else if (c == '>')
        target.write("&gt;".getBytes(StandardCharsets.UTF_8));
      else if (c == '&')
        target.write("&amp;".getBytes(StandardCharsets.UTF_8));
      else if (c == '"')
        target.write("&quot;".getBytes(StandardCharsets.UTF_8));
      else
        target.write((byte) i);
    }
    return target.toByteArray();
  }

  private static byte[] escape(byte[] input) throws IOException {
    ByteArrayOutputStream target = new ByteArrayOutputStream();
    XmlEscaper.convert(new ByteArrayInputStream(input), target);
    return target.toByteArray();
  }

  private static String repeat(String s, int length) {
    StringBuilder b = new StringBuilder();
    while (b.length() < length) {
      b.append(s);
    }
    return b.toString();
  }

  static Stream<String> inputs() {
    Random random = new Random(42);
    StringBuilder mixed = new StringBuilder();
    String alphabet = "<>&\"'abc xyz\r\n\té€😀";
    for (int i = 0; i < 50000; i++) {
      mixed.append(alphabet.charAt(random.nextInt(alphabet.length())));
    }
    return Stream.of(
      "",
      "plain text",
      "<Patient xmlns=\"http://hl7.org/fhir\"><id value=\"a&b\"/></Patient>",
      "\r\n\t  leading and trailing whitespace  \r\n",
      // characters that aren't ASCII are written as their low byte, as before
      "naïve café – 日本語 😀",
      // escapes either side of the read block boundary
      repeat("a", 8191) + "<&>\"" + repeat("b", 8190) + "&",
      repeat("<&\">", 40000),
      mixed.toString());
  }

  @ParameterizedTest
  @MethodSource("inputs")
  void sameBytesAsEscapingOneCharacterAtATime(String input) throws IOException {
    byte[] bytes = input.getBytes(Charset.defaultCharset());
    assertArrayEquals(reference(bytes), escape(bytes));
  }

  // some of these are larger than the 8 KB output buffer and end with a write smaller than it, which
  // is only on disk if the buffer is flushed
  @ParameterizedTest
  @MethodSource("inputs")
  void convertsFiles(String input, @TempDir Path dir) throws IOException {
    byte[] bytes = input.getBytes(Charset.defaultCharset());
    Path source = dir.resolve("source.txt");
    Path target = dir.resolve("target.txt");
    Files.write(source, bytes);
    XmlEscaper.convert(source.toString(), target.toString());
    assertArrayEquals(reference(bytes), Files.readAllBytes(target));
  }

  @Test
  void writesInBlocks() throws IOException {
    int[] writes = new int[1];
    OutputStream counting = new OutputStream() {
      @Override
      public void write(int b) {
        writes[0]++;
      }

      @Override
      public void write(byte[] b, int off, int len) {
        writes[0]++;
      }
    };
    InputStream source = new ByteArrayInputStream(repeat("<text & more>", 100000).getBytes(StandardCharsets.UTF_8));
    XmlEscaper.convert(source, counting);
    assertTrue(writes[0] < 200, "expected the output to be written in blocks, but there were " + writes[0] + " writes");
  }
}
