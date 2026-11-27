package org.hl7.fhir.utilities;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

import org.hl7.fhir.utilities.xslt.XsltUtilities;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.junit.jupiter.api.parallel.ResourceLock;
import org.junit.jupiter.api.parallel.Resources;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

/**
 * Demonstrates local-file disclosure via an XML external entity whose SYSTEM identifier is an
 * absolute path, resolved by XsltURIResolver / XsltZipURIResolver in the resolver-bearing
 * saxonTransform and transform overloads. Also checks that ordinary transforms and stylesheet
 * includes still work through those overloads.
 */
class XsltUtilitiesXXETests {

  private static final String CANARY = "CURRENT-CANARY";

  /**
   * Outputs the text of the root element. In the XXE tests, this copies whatever {@code &xxe;} expanded to
   * into the output file, so a leak of the secret file is visible to the assertions. In the
   * ordinary-document tests, the root contains "hello".
   */
  private static final String XSL = """
    <?xml version="1.0"?>
    <xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
      <xsl:output method="text" omit-xml-declaration="yes"/>
      <xsl:template match="/"><xsl:value-of select="/root"/></xsl:template>
    </xsl:stylesheet>
    """;

  /*
   * INCLUDED_XSL and INCLUDING_XSL are used only by the Map-overload tests that check xsl:include
   * still resolves from the supplied map. They are not part of the exploit.
   */
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
  Path tempDir;

  Path source;
  Path style;
  Path output;

  @BeforeEach
  void setUp() throws Exception {
    Path secret = tempDir.resolve("canary-secret.txt");
    Files.writeString(secret, CANARY);

    /*
     * XML whose external entity points at the secret file. If the entity is resolved (before the
     * fix, XsltURIResolver opened the absolute path directly), &xxe; is replaced with the file's
     * contents:
     *
     *   <root>CURRENT-CANARY</root>
     */
    String inputXml = "<?xml version=\"1.0\"?>\n"
      + "<!DOCTYPE root [<!ENTITY xxe SYSTEM \"" + secret.toAbsolutePath() + "\">]>\n"
      + "<root>&xxe;</root>\n";

    source = tempDir.resolve("input.xml");
    style = tempDir.resolve("identity.xsl");
    output = tempDir.resolve("output.txt");
    Files.writeString(source, inputXml);
    Files.writeString(style, XSL);
  }

  @Test
  void twoArgOverloadBlocksExternalEntity() {
    Exception e = assertThrows(Exception.class, () -> XsltUtilities.saxonTransform(source.toString(), style.toString()));
    // Rejected by the XXE-protected parser, not just by Saxon's ACCESS_EXTERNAL_DTD setting
    assertThat(messages(e)).contains("DOCTYPE is disallowed");
  }

  /**
   * Runs each public transform overload with a given source and stylesheet, and returns the
   * principal output as text.
   */
  enum Overload {
    MAP_SAXON_TRANSFORM {
      @Override
      String run(Path dir, Path source, Path style, Path output) throws Exception {
        return new String(XsltUtilities.saxonTransform(Map.of(), Files.readAllBytes(source), Files.readAllBytes(style)), StandardCharsets.UTF_8);
      }
    },
    MAP_TRANSFORM {
      @Override
      String run(Path dir, Path source, Path style, Path output) throws Exception {
        return new String(XsltUtilities.transform(Map.of(), Files.readAllBytes(source), Files.readAllBytes(style)), StandardCharsets.UTF_8);
      }
    },
    TWO_ARG_SAXON_TRANSFORM {
      @Override
      String run(Path dir, Path source, Path style, Path output) throws Exception {
        return XsltUtilities.saxonTransform(source.toString(), style.toString());
      }
    },
    FIVE_ARG_SAXON_TRANSFORM {
      @Override
      String run(Path dir, Path source, Path style, Path output) throws Exception {
        XsltUtilities.saxonTransform(dir.toString(), source.toString(), style.toString(), output.toString(), null);
        return Files.readString(output);
      }
    },
    SIX_ARG_SAXON_TRANSFORM {
      @Override
      String run(Path dir, Path source, Path style, Path output) throws Exception {
        XsltUtilities.saxonTransform(dir.toString(), source.toString(), style.toString(), output.toString(), null, null);
        return Files.readString(output);
      }
    },
    FILE_TRANSFORM {
      @Override
      String run(Path dir, Path source, Path style, Path output) throws Exception {
        XsltUtilities.transform(dir.toString(), source.toString(), style.toString(), output.toString(), null);
        return Files.readString(output);
      }
    };

    abstract String run(Path dir, Path source, Path style, Path output) throws Exception;
  }

  @ParameterizedTest(name = "{index}: {0}")
  @EnumSource(Overload.class)
  @ResourceLock(Resources.SYSTEM_ERR)
  void resultDocumentIsRefused(Overload overload) throws Exception {
    Path pwned = tempDir.resolve("pwned.txt");
    Path resultDocStyle = tempDir.resolve("result-document.xsl");
    Files.writeString(resultDocStyle, """
      <?xml version="1.0"?>
      <xsl:stylesheet version="3.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
        <xsl:output method="text"/>
        <xsl:template match="/">
          <xsl:result-document href="%s" method="text">pwned</xsl:result-document>
        </xsl:template>
      </xsl:stylesheet>
      """.formatted(pwned.toUri()));
    Path plain = writePlainSource();

    /*
     * With extension functions disabled (see XsltUtilities.restrictEnvironment), Saxon refuses
     * xsl:result-document when the stylesheet is compiled, before the result-document handler is
     * ever reached. The exception only says "Errors were reported during stylesheet compilation":
     * the reason goes to Saxon's default error listener, which writes to System.err, so that's
     * captured to check the stylesheet was refused for the right reason.
     */
    PrintStream originalErr = System.err;
    ByteArrayOutputStream err = new ByteArrayOutputStream();
    System.setErr(new PrintStream(err, true, StandardCharsets.UTF_8));
    try {
      assertThrows(Exception.class, () -> overload.run(tempDir, plain, resultDocStyle, output));
    } finally {
      System.setErr(originalErr);
    }

    assertThat(err.toString(StandardCharsets.UTF_8)).contains("xsl:result-document is disabled when extension functions are disabled");
    assertThat(pwned).doesNotExist();
  }

  @ParameterizedTest(name = "{index}: {0}")
  @EnumSource(Overload.class)
  void environmentIsHidden(Overload overload) throws Exception {
    assumeTrue(System.getenv("PATH") != null, "needs PATH set to show it is hidden");
    Path envStyle = tempDir.resolve("env.xsl");
    Files.writeString(envStyle, """
      <?xml version="1.0"?>
      <xsl:stylesheet version="3.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
        <xsl:output method="text"/>
        <xsl:template match="/">env=<xsl:value-of select="environment-variable('PATH')"/>;all=<xsl:value-of select="string-join(available-environment-variables(), ',')"/>;prop=<xsl:value-of select="system-property('user.home')"/>;version=<xsl:value-of select="system-property('xsl:version')"/></xsl:template>
      </xsl:stylesheet>
      """);
    Path plain = writePlainSource();

    String out = overload.run(tempDir, plain, envStyle, output);

    // xsl: namespace properties still work; environment variables and Java system properties don't
    assertThat(out).matches("env=;all=;prop=;version=\\d\\.\\d");
  }

  /** All the messages in the exception's cause chain, so assertions don't depend on how Saxon wraps them. */
  private static String messages(Throwable e) {
    StringBuilder b = new StringBuilder();
    for (Throwable t = e; t != null; t = t.getCause()) {
      b.append(t.getMessage()).append('\n');
    }
    return b.toString();
  }

  @Test
  void sixArgOverloadDoesNotLeakLocalFile() throws Exception {
    try {
      XsltUtilities.saxonTransform(tempDir.toString(), source.toString(), style.toString(), output.toString(), null, null);
    } catch (Exception e) {
      return; // blocked: acceptable
    }
    assertThat(readOutput()).doesNotContain(CANARY);
  }

  @Test
  void fiveArgOverloadDoesNotLeakLocalFile() throws Exception {
    try {
      XsltUtilities.saxonTransform(tempDir.toString(), source.toString(), style.toString(), output.toString(), null);
    } catch (Exception e) {
      return; // blocked: acceptable
    }
    assertThat(readOutput()).doesNotContain(CANARY);
  }

  @Test
  void transformOverloadDoesNotLeakLocalFile() throws Exception {
    try {
      XsltUtilities.transform(tempDir.toString(), source.toString(), style.toString(), output.toString(), null);
    } catch (Exception e) {
      return; // blocked: acceptable
    }
    assertThat(readOutput()).doesNotContain(CANARY);
  }

  @Test
  void mapSaxonTransformOverloadDoesNotLeakLocalFile() {
    byte[] out;
    try {
      out = XsltUtilities.saxonTransform(Map.of("other.xsl", XSL.getBytes(StandardCharsets.UTF_8)), Files.readAllBytes(source), Files.readAllBytes(style));
    } catch (Exception e) {
      return; // blocked: acceptable
    }
    assertThat(new String(out, StandardCharsets.UTF_8)).doesNotContain(CANARY);
  }

  @Test
  void mapTransformOverloadDoesNotLeakLocalFile() {
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
    Path paramStyle = tempDir.resolve("param.xsl");
    Files.writeString(paramStyle, """
      <?xml version="1.0"?>
      <xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
        <xsl:output method="text" omit-xml-declaration="yes"/>
        <xsl:param name="suffix"/>
        <xsl:template match="/"><xsl:value-of select="/root"/><xsl:value-of select="$suffix"/></xsl:template>
      </xsl:stylesheet>
      """);

    XsltUtilities.saxonTransform(tempDir.toString(), plain.toString(), paramStyle.toString(), output.toString(), null, Map.of("suffix", "-world"));

    assertThat(readOutput()).isEqualTo("hello-world");
  }

  @Test
  void fiveArgOverloadTransformsOrdinaryDocument() throws Exception {
    Path plain = writePlainSource();

    XsltUtilities.saxonTransform(tempDir.toString(), plain.toString(), style.toString(), output.toString(), null);

    assertThat(readOutput()).isEqualTo("hello");
  }

  @Test
  void transformOverloadTransformsOrdinaryDocument() throws Exception {
    Path plain = writePlainSource();

    XsltUtilities.transform(tempDir.toString(), plain.toString(), style.toString(), output.toString(), null);

    assertThat(readOutput()).isEqualTo("hello");
  }

  @Test
  void stylesheetIncludeFromSubdirectoryResolvesUnderXsltDir() throws Exception {
    Path plain = writePlainSource();
    Files.createDirectories(tempDir.resolve("sub"));
    Files.writeString(tempDir.resolve("sub").resolve("included.xsl"), """
      <?xml version="1.0"?>
      <xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
        <xsl:template name="greet">included:<xsl:value-of select="/root"/></xsl:template>
      </xsl:stylesheet>
      """);
    Path including = tempDir.resolve("including.xsl");
    Files.writeString(including, """
      <?xml version="1.0"?>
      <xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
        <xsl:include href="sub/included.xsl"/>
        <xsl:output method="text" omit-xml-declaration="yes"/>
        <xsl:template match="/"><xsl:call-template name="greet"/></xsl:template>
      </xsl:stylesheet>
      """);

    XsltUtilities.saxonTransform(tempDir.toString(), plain.toString(), including.toString(), output.toString(), null);

    assertThat(readOutput()).isEqualTo("included:hello");
  }

  private Path writePlainSource() throws Exception {
    Path plain = tempDir.resolve("plain.xml");
    Files.writeString(plain, "<?xml version=\"1.0\"?>\n<root>hello</root>\n");
    return plain;
  }

  private String readOutput() throws Exception {
    return Files.readString(output);
  }
}
