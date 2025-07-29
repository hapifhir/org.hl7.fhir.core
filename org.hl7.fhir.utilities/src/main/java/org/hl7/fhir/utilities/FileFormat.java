package org.hl7.fhir.utilities;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class FileFormat {

  public static boolean fileEncodingIsUtf8() {
    return Charset.defaultCharset().equals(StandardCharsets.UTF_8);
  }

  private static final String WARNING =
    """
    
    WARNING: Detected file encoding is %s which may cause unexpected results.
    To fix this issue, run this program with the parameter '-Dfile.encoding=UTF-8'
    Future releases may not be able to run at all with encoding %s
    
    """;
  public static void checkCharsetAndWarnIfNotUTF8(org.slf4j.Logger log) {
    if (fileEncodingIsUtf8()) return;
    log.warn(String.format(WARNING, Charset.defaultCharset(), Charset.defaultCharset()));
  }
}
