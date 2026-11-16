package org.hl7.fhir.utilities;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

/**
 * Demonstrates local-file disclosure via an XML external entity whose SYSTEM identifier is an
 * absolute path, resolved by MyURIResolver / ZipURIResolver in the resolver-bearing
 * saxonTransform and transform overloads. Also checks that ordinary transforms and stylesheet
 * includes still work through those overloads.
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

  private static final String INCLUDED_XSL = """
    <?xml version="1.0"?>
    <xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
      <xsl:template name="greet">included:<xsl:value-of select="/root"/></xsl:template>
    </xsl:stylesheet>
    """;

  private static final String INCLUDING_XSL = """
    <?xml version="1.0"?>
    <xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
      <xsl:include href="included.xsl"/>
      <xsl:output method="text" omit-xml-declaration="yes"/>
      <xsl:template match="/"><xsl:call-template name="greet"/></xsl:template>
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

  @Test
  void transformOverloadDoesNotLeakLocalFile() throws Exception {
    try {
      XsltUtilities.transform(work.toString(), source.toString(), style.toString(), output.toString(), null);
    } catch (Exception e) {
      return; // blocked: acceptable
    }
    assertThat(readOutput()).doesNotContain(CANARY);
  }

  @Test
  void mapSaxonTransformOverloadDoesNotLeakLocalFile() throws Exception {
    byte[] out;
    try {
      out = XsltUtilities.saxonTransform(Map.of("other.xsl", XSL.getBytes(StandardCharsets.UTF_8)), Files.readAllBytes(source), Files.readAllBytes(style));
    } catch (Exception e) {
      return; // blocked: acceptable
    }
    assertThat(new String(out, StandardCharsets.UTF_8)).doesNotContain(CANARY);
  }

  @Test
  void mapTransformOverloadDoesNotLeakLocalFile() throws Exception {
    byte[] out;
    try {
      out = XsltUtilities.transform(Map.of("other.xsl", XSL.getBytes(StandardCharsets.UTF_8)), Files.readAllBytes(source), Files.readAllBytes(style));
    } catch (Exception e) {
      return; // blocked: acceptable
    }
    assertThat(new String(out, StandardCharsets.UTF_8)).doesNotContain(CANARY);
  }

  @Test
  void mapSaxonTransformOverloadResolvesIncludeFromMap() throws Exception {
    byte[] out = XsltUtilities.saxonTransform(Map.of("included.xsl", INCLUDED_XSL.getBytes(StandardCharsets.UTF_8)),
      Files.readAllBytes(writePlainSource()), INCLUDING_XSL.getBytes(StandardCharsets.UTF_8));

    assertThat(new String(out, StandardCharsets.UTF_8)).isEqualTo("included:hello");
  }

  @Test
  void mapTransformOverloadResolvesIncludeFromMap() throws Exception {
    byte[] out = XsltUtilities.transform(Map.of("included.xsl", INCLUDED_XSL.getBytes(StandardCharsets.UTF_8)),
      Files.readAllBytes(writePlainSource()), INCLUDING_XSL.getBytes(StandardCharsets.UTF_8));

    assertThat(new String(out, StandardCharsets.UTF_8)).isEqualTo("included:hello");
  }

  @Test
  void mapSaxonTransformOverloadRejectsIncludeMissingFromMap() throws Exception {
    byte[] plain = Files.readAllBytes(writePlainSource());
    byte[] including = INCLUDING_XSL.getBytes(StandardCharsets.UTF_8);
    Map<String, byte[]> files = Map.of();

    assertThrows(Exception.class, () -> XsltUtilities.saxonTransform(files, plain, including));
  }

  @Test
  void sixArgOverloadTransformsOrdinaryDocument() throws Exception {
    Path plain = writePlainSource();
    Path paramStyle = work.resolve("param.xsl");
    Files.writeString(paramStyle, """
      <?xml version="1.0"?>
      <xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
        <xsl:output method="text" omit-xml-declaration="yes"/>
        <xsl:param name="suffix"/>
        <xsl:template match="/"><xsl:value-of select="/root"/><xsl:value-of select="$suffix"/></xsl:template>
      </xsl:stylesheet>
      """);

    XsltUtilities.saxonTransform(work.toString(), plain.toString(), paramStyle.toString(), output.toString(), null, Map.of("suffix", "-world"));

    assertThat(readOutput()).isEqualTo("hello-world");
  }

  @Test
  void fiveArgOverloadTransformsOrdinaryDocument() throws Exception {
    Path plain = writePlainSource();

    XsltUtilities.saxonTransform(work.toString(), plain.toString(), style.toString(), output.toString(), null);

    assertThat(readOutput()).isEqualTo("hello");
  }

  @Test
  void transformOverloadTransformsOrdinaryDocument() throws Exception {
    Path plain = writePlainSource();

    XsltUtilities.transform(work.toString(), plain.toString(), style.toString(), output.toString(), null);

    assertThat(readOutput()).isEqualTo("hello");
  }

  @Test
  void stylesheetIncludeFromSubdirectoryResolvesUnderXsltDir() throws Exception {
    Path plain = writePlainSource();
    Files.createDirectories(work.resolve("sub"));
    Files.writeString(work.resolve("sub").resolve("included.xsl"), """
      <?xml version="1.0"?>
      <xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
        <xsl:template name="greet">included:<xsl:value-of select="/root"/></xsl:template>
      </xsl:stylesheet>
      """);
    Path including = work.resolve("including.xsl");
    Files.writeString(including, """
      <?xml version="1.0"?>
      <xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
        <xsl:include href="sub/included.xsl"/>
        <xsl:output method="text" omit-xml-declaration="yes"/>
        <xsl:template match="/"><xsl:call-template name="greet"/></xsl:template>
      </xsl:stylesheet>
      """);

    XsltUtilities.saxonTransform(work.toString(), plain.toString(), including.toString(), output.toString(), null);

    assertThat(readOutput()).isEqualTo("included:hello");
  }

  private Path writePlainSource() throws Exception {
    Path plain = work.resolve("plain.xml");
    Files.writeString(plain, "<?xml version=\"1.0\"?>\n<root>hello</root>\n");
    return plain;
  }

  private String readOutput() throws Exception {
    return Files.readString(output);
  }
}
