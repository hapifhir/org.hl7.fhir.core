package org.hl7.fhir.utilities.xml;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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

  /** What the escaping should produce: the UTF-8 input with the four characters escaped, as UTF-8. */
  private static byte[] reference(String input) {
    return input.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;").replace("\"", "&quot;").getBytes(StandardCharsets.UTF_8);
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
      // characters that aren't ASCII come out as the same UTF-8
      "naïve café – 日本語 😀",
      // escapes either side of the read block boundary
      repeat("a", 8191) + "<&>\"" + repeat("b", 8190) + "&",
      // a surrogate pair split across the read block boundary
      repeat("a", 8191) + "😀" + repeat("b", 100),
      // and one whose escaped output straddles the writer's buffer
      repeat("&", 1638) + "日本語😀" + repeat("<", 3000),
      repeat("<&\">", 40000),
      mixed.toString());
  }

  @ParameterizedTest
  @MethodSource("inputs")
  void escapesAndKeepsUtf8(String input) throws IOException {
    byte[] bytes = input.getBytes(StandardCharsets.UTF_8);
    assertArrayEquals(reference(input), escape(bytes));
  }

  // some of these are larger than the 8 KB output buffer and end with a write smaller than it, which
  // is only on disk if the buffer is flushed
  @ParameterizedTest
  @MethodSource("inputs")
  void convertsFiles(String input, @TempDir Path dir) throws IOException {
    byte[] bytes = input.getBytes(StandardCharsets.UTF_8);
    Path source = dir.resolve("source.txt");
    Path target = dir.resolve("target.txt");
    Files.write(source, bytes);
    XmlEscaper.convert(source.toString(), target.toString());
    assertArrayEquals(reference(input), Files.readAllBytes(target));
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
    // 2.3 MB of output: one write per byte would be millions; the writer's buffer makes it a few hundred
    // at most (how few depends on the JDK)
    assertTrue(writes[0] < 1000, "expected the output to be written in blocks, but there were " + writes[0] + " writes");
  }
}
