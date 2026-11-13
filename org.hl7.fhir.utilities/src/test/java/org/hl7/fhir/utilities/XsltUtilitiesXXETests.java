package org.hl7.fhir.utilities;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

/**
 * Demonstrates local-file disclosure via an XML external entity whose SYSTEM identifier is an
 * absolute path, resolved by MyURIResolver in the resolver-bearing saxonTransform overloads.
 */
class XsltUtilitiesXXETests {

  private static final String CANARY = "CURRENT-CANARY";

  private static final String XSL = """
    <?xml version="1.0"?>
    <xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
      <xsl:output method="text" omit-xml-declaration="yes"/>
      <xsl:template match="/"><xsl:value-of select="/root"/></xsl:template>
    </xsl:stylesheet>
    """;

  @TempDir
  Path work;

  Path source;
  Path style;
  Path output;

  @BeforeEach
  void setUp() throws Exception {
    Path secret = work.resolve("canary-secret.txt");
    Files.writeString(secret, CANARY);

    String xml = "<?xml version=\"1.0\"?>\n"
      + "<!DOCTYPE root [<!ENTITY xxe SYSTEM \"" + secret.toAbsolutePath() + "\">]>\n"
      + "<root>&xxe;</root>\n";

    source = work.resolve("input.xml");
    style = work.resolve("identity.xsl");
    output = work.resolve("output.txt");
    Files.writeString(source, xml);
    Files.writeString(style, XSL);
  }

  @Test
  void twoArgOverloadBlocksExternalEntity() {
    assertThrows(Exception.class, () -> XsltUtilities.saxonTransform(source.toString(), style.toString()));
  }

  @Test
  void sixArgOverloadDoesNotLeakLocalFile() throws Exception {
    try {
      XsltUtilities.saxonTransform(work.toString(), source.toString(), style.toString(), output.toString(), null, null);
    } catch (Exception e) {
      return; // blocked: acceptable
    }
    assertThat(readOutput()).doesNotContain(CANARY);
  }

  @Test
  void fiveArgOverloadDoesNotLeakLocalFile() throws Exception {
    try {
      XsltUtilities.saxonTransform(work.toString(), source.toString(), style.toString(), output.toString(), null);
    } catch (Exception e) {
      return; // blocked: acceptable
    }
    assertThat(readOutput()).doesNotContain(CANARY);
  }

  private String readOutput() throws Exception {
    return Files.readString(output);
  }
}
