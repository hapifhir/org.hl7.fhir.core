package org.hl7.fhir.utilities;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class FileFormatTest {
  @Test
  public void testCurrentFileFormat() throws IOException {
    org.slf4j.Logger logger = mock(org.slf4j.Logger.class);

    FileFormat.checkCharsetAndWarnIfNotUTF8(logger);

    assertAWarningIsGivenWhenNotUTF8(logger);
  }

  private static void assertAWarningIsGivenWhenNotUTF8(org.slf4j.Logger logger) {
    if (Charset.defaultCharset().equals(StandardCharsets.UTF_8)) {
      verify(logger, Mockito.times(0)).warn(anyString());
    } else {
      verify(logger).warn(argThat((String warn) -> warn.contains("WARNING")));
    }
  }
}
