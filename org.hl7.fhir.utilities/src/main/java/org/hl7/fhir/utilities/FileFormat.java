package org.hl7.fhir.utilities;

import java.io.PrintStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class FileFormat {

  public static boolean fileEncodingIsUtf8() {
    return Charset.defaultCharset().equals(StandardCharsets.UTF_8);
  }

  private static final String WARNING = "WARNING: Default file encoding is " + Charset.defaultCharset() + " which may cause unexpected results.\n"
    + "         To fix this issue, run this program with the parameter '-Dfile.encoding=UTF-8'\n"
    + "         Future releases may not be able to run at all with encoding " + Charset.defaultCharset() + "\n";

  public static void checkCharsetAndWarnIfNotUTF8(PrintStream out) {
    if (fileEncodingIsUtf8()) return;
    out.println("");
    out.print(WARNING);
    out.println("");
  }

  public static void checkCharsetAndWarnIfNotUTF8(org.slf4j.Logger log) {
    log.warn(WARNING);
  }
}
