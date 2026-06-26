package org.hl7.fhir.r5.elementmodel;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SHCParserTests {

  @Test
  void testEmptyInput() throws DataFormatException, IOException {
    SHCParser.inflate(new byte[0]);
  }

  @Test
  void inflate_rejectsOversizedOutput() throws IOException {
    // Produce a compressed stream that decompresses to 400 MB without holding 400 MB in memory.
    byte[] compressed = rawDeflateStream(400_000_000);

    assertThrows(DataFormatException.class, () -> SHCParser.inflate(compressed),
      "inflate() should throw DataFormatException when decompressed output exceeds the allowed limit");
  }

  /**
   * Streams {@code totalBytes} of repeated 0x61 ('a') through a Deflater in 64 KB chunks,
   * returning the complete raw DEFLATE output without holding {@code totalBytes} in memory.
   * The decompressed size of the result equals {@code totalBytes}.
   */
  private static byte[] rawDeflateStream(int totalBytes) throws IOException {
    Deflater deflater = new Deflater(Deflater.BEST_COMPRESSION, /* nowrap= */ true);
    byte[] chunk = new byte[65536];
    java.util.Arrays.fill(chunk, (byte) 'a');
    try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
      byte[] buf = new byte[4096];
      int remaining = totalBytes;
      while (remaining > 0) {
        int toWrite = Math.min(remaining, chunk.length);
        deflater.setInput(chunk, 0, toWrite);
        remaining -= toWrite;
        if (remaining == 0) {
          deflater.finish();
        }
        while (!deflater.needsInput() && !deflater.finished()) {
          out.write(buf, 0, deflater.deflate(buf));
        }
      }
      while (!deflater.finished()) {
        out.write(buf, 0, deflater.deflate(buf));
      }
      deflater.end();
      return out.toByteArray();
    }
  }
}
