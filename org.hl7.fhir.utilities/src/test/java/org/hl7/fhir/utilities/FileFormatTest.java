package org.hl7.fhir.utilities;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class FileFormatTest {
  @Test
  public void testCurrentFileFormat() throws IOException {
    ByteArrayOutputStream bo = new ByteArrayOutputStream();

    FileFormat.checkCharsetAndWarnIfNotUTF8(new PrintStream(bo));

    bo.flush();
    String allWrittenLines = new String(bo.toByteArray());

    assertAWarningIsGivenWhenNotUTF8(allWrittenLines);
  }

  private static void assertAWarningIsGivenWhenNotUTF8(String allWrittenLines) {
    if (Charset.defaultCharset().equals(StandardCharsets.UTF_8)) {
      assertEquals(0, allWrittenLines.length());
    } else {
      assertThat(allWrittenLines, containsString("WARNING"));
    }
  }
}
