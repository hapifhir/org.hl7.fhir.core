package org.hl7.fhir.utilities;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

import javax.xml.transform.URIResolver;
import javax.xml.transform.stream.StreamSource;

import org.hl7.fhir.utilities.xslt.XsltUtilities;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import com.sun.net.httpserver.HttpServer;

/**
 * External entities inside documents that are loaded during a transform (document(), xsl:include)
 * rather than in the top-level source. These documents are returned by XsltURIResolver /
 * XsltZipURIResolver (or the default resolver for http) as plain StreamSources, so the
 * XXE-protected source parsing does not apply to them.
 * <p>
 * Each test passes if the transform fails or the output does not contain the canary.
 */
class XsltResolvedDocumentXXETests {

  private static final String CANARY = "RESOLVED-DOC-CANARY";

  /** Copies the text of whatever document($href) returns; href comes from the source document. */
  private static final String DOCUMENT_XSL = """
    <?xml version="1.0"?>
    <xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
      <xsl:output method="text" omit-xml-declaration="yes"/>
      <xsl:template match="/"><xsl:value-of select="document(/root/@href)/d"/></xsl:template>
    </xsl:stylesheet>
    """;

  /** Includes a stylesheet that may carry its own DOCTYPE. */
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

  Path xsltDir;
  Path secret;
  Path output;
  HttpServer server;

  @BeforeEach
  void setUp() throws Exception {
    xsltDir = Files.createDirectories(work.resolve("xslt"));
    // outside xsltDir, so XsltURIResolver must not serve it directly
    secret = work.resolve("canary-secret.txt");
    Files.writeString(secret, CANARY);
    output = work.resolve("output.txt");
  }

  @AfterEach
  void tearDown() {
    if (server != null) {
      server.stop(0);
    }
  }

  private String entityDocument() {
    return entityDocument(secret.toAbsolutePath().toString());
  }

  /** Same, with the SYSTEM id as an absolute file: URI (not resolved against the document base). */
  private String fileUriEntityDocument() {
    return entityDocument(secret.toUri().toString());
  }

  private static String entityDocument(String systemId) {
    return "<?xml version=\"1.0\"?>\n"
      + "<!DOCTYPE d [<!ENTITY xxe SYSTEM \"" + systemId + "\">]>\n"
      + "<d>&xxe;</d>\n";
  }

  private String entityStylesheet() {
    return "<?xml version=\"1.0\"?>\n"
      + "<!DOCTYPE xsl:stylesheet [<!ENTITY xxe SYSTEM \"" + secret.toAbsolutePath() + "\">]>\n"
      + "<xsl:stylesheet version=\"1.0\" xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\">\n"
      + "  <xsl:template name=\"greet\">&xxe;</xsl:template>\n"
      + "</xsl:stylesheet>\n";
  }

  private Path sourceWithHref(String href) throws Exception {
    Path source = work.resolve("input.xml");
    Files.writeString(source, "<?xml version=\"1.0\"?>\n<root href=\"" + href + "\"/>\n");
    return source;
  }

  private Path writeStylesheet(String name, String content) throws Exception {
    Path p = xsltDir.resolve(name);
    Files.writeString(p, content);
    return p;
  }

  private void assertNoCanary(ThrowingSupplier<String> transform) {
    String out;
    try {
      out = transform.get();
    } catch (Exception e) {
      System.out.println("blocked: " + e); // acceptable; printed so the reason can be checked
      return;
    }
    assertThat(out).doesNotContain(CANARY);
  }

  @FunctionalInterface
  private interface ThrowingSupplier<T> {
    T get() throws Exception;
  }

  // --- xsltDir overloads: document() of a file inside xsltDir -------------------------------

  @Test
  void saxonTransformDocumentInXsltDirDoesNotLeakLocalFile() throws Exception {
    Files.writeString(xsltDir.resolve("data.xml"), entityDocument());
    Path style = writeStylesheet("doc.xsl", DOCUMENT_XSL);
    Path source = sourceWithHref("data.xml");

    assertNoCanary(() -> {
      XsltUtilities.saxonTransform(xsltDir.toString(), source.toString(), style.toString(), output.toString(), null);
      return Files.readString(output);
    });
  }

  @Test
  void transformDocumentInXsltDirDoesNotLeakLocalFile() throws Exception {
    Files.writeString(xsltDir.resolve("data.xml"), entityDocument());
    Path style = writeStylesheet("doc.xsl", DOCUMENT_XSL);
    Path source = sourceWithHref("data.xml");

    assertNoCanary(() -> {
      XsltUtilities.transform(xsltDir.toString(), source.toString(), style.toString(), output.toString(), null);
      return Files.readString(output);
    });
  }

  // --- xsltDir overloads: xsl:include of a stylesheet inside xsltDir -----------------------

  @Test
  void saxonTransformIncludeInXsltDirDoesNotLeakLocalFile() throws Exception {
    writeStylesheet("included.xsl", entityStylesheet());
    Path style = writeStylesheet("including.xsl", INCLUDING_XSL);
    Path source = sourceWithHref("unused");

    assertNoCanary(() -> {
      XsltUtilities.saxonTransform(xsltDir.toString(), source.toString(), style.toString(), output.toString(), null);
      return Files.readString(output);
    });
  }

  // --- Map overloads: document() of a map entry --------------------------------------------

  @Test
  void mapSaxonTransformDocumentFromMapDoesNotLeakLocalFile() throws Exception {
    Map<String, byte[]> files = Map.of("data.xml", entityDocument().getBytes(StandardCharsets.UTF_8));
    byte[] source = Files.readAllBytes(sourceWithHref("data.xml"));

    assertNoCanary(() -> new String(XsltUtilities.saxonTransform(files, source, DOCUMENT_XSL.getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8));
  }

  @Test
  void mapTransformDocumentFromMapDoesNotLeakLocalFile() throws Exception {
    Map<String, byte[]> files = Map.of("data.xml", entityDocument().getBytes(StandardCharsets.UTF_8));
    byte[] source = Files.readAllBytes(sourceWithHref("data.xml"));

    assertNoCanary(() -> new String(XsltUtilities.transform(files, source, DOCUMENT_XSL.getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8));
  }

  // --- http document named by the source; no alt resolver ------------------------------------
  // With alt == null every http(s) href fails (NPE: the fallback factory has no URIResolver),
  // so these pass without loading anything. Kept to record that behaviour.

  @Test
  void saxonTransformRemoteDocumentNamedBySourceDoesNotLeakLocalFile() throws Exception {
    String url = serve(entityDocument());
    Path style = writeStylesheet("doc.xsl", DOCUMENT_XSL);
    Path source = sourceWithHref(url);

    assertNoCanary(() -> {
      XsltUtilities.saxonTransform(xsltDir.toString(), source.toString(), style.toString(), output.toString(), null);
      return Files.readString(output);
    });
  }

  @Test
  void transformRemoteDocumentNamedBySourceDoesNotLeakLocalFile() throws Exception {
    String url = serve(entityDocument());
    Path style = writeStylesheet("doc.xsl", DOCUMENT_XSL);
    Path source = sourceWithHref(url);

    assertNoCanary(() -> {
      XsltUtilities.transform(xsltDir.toString(), source.toString(), style.toString(), output.toString(), null);
      return Files.readString(output);
    });
  }

  // --- http document named by the source, fetched by a caller-supplied alt resolver ------

  /** A plausible alt resolver: fetch the URL as-is. */
  private static final URIResolver FETCHING_ALT = (href, base) -> new StreamSource(href);

  @Test
  void saxonTransformRemoteDocumentViaAltDoesNotLeakLocalFile() throws Exception {
    String url = serve(entityDocument());
    Path style = writeStylesheet("doc.xsl", DOCUMENT_XSL);
    Path source = sourceWithHref(url);

    assertNoCanary(() -> {
      XsltUtilities.saxonTransform(xsltDir.toString(), source.toString(), style.toString(), output.toString(), FETCHING_ALT);
      return Files.readString(output);
    });
  }

  @Test
  void transformRemoteDocumentViaAltDoesNotLeakLocalFile() throws Exception {
    String url = serve(entityDocument());
    Path style = writeStylesheet("doc.xsl", DOCUMENT_XSL);
    Path source = sourceWithHref(url);

    assertNoCanary(() -> {
      XsltUtilities.transform(xsltDir.toString(), source.toString(), style.toString(), output.toString(), FETCHING_ALT);
      return Files.readString(output);
    });
  }

  // --- same paths, SYSTEM id as an absolute file: URI -------------------------------------

  @Test
  void saxonTransformRemoteDocumentViaAltWithFileUriDoesNotLeakLocalFile() throws Exception {
    String url = serve(fileUriEntityDocument());
    Path style = writeStylesheet("doc.xsl", DOCUMENT_XSL);
    Path source = sourceWithHref(url);

    assertNoCanary(() -> {
      XsltUtilities.saxonTransform(xsltDir.toString(), source.toString(), style.toString(), output.toString(), FETCHING_ALT);
      return Files.readString(output);
    });
  }

  @Test
  void transformRemoteDocumentViaAltWithFileUriDoesNotLeakLocalFile() throws Exception {
    String url = serve(fileUriEntityDocument());
    Path style = writeStylesheet("doc.xsl", DOCUMENT_XSL);
    Path source = sourceWithHref(url);

    assertNoCanary(() -> {
      XsltUtilities.transform(xsltDir.toString(), source.toString(), style.toString(), output.toString(), FETCHING_ALT);
      return Files.readString(output);
    });
  }

  @Test
  void saxonTransformDocumentInXsltDirWithFileUriDoesNotLeakLocalFile() throws Exception {
    Files.writeString(xsltDir.resolve("data.xml"), fileUriEntityDocument());
    Path style = writeStylesheet("doc.xsl", DOCUMENT_XSL);
    Path source = sourceWithHref("data.xml");

    assertNoCanary(() -> {
      XsltUtilities.saxonTransform(xsltDir.toString(), source.toString(), style.toString(), output.toString(), null);
      return Files.readString(output);
    });
  }

  @Test
  void mapSaxonTransformDocumentFromMapWithFileUriDoesNotLeakLocalFile() throws Exception {
    Map<String, byte[]> files = Map.of("data.xml", fileUriEntityDocument().getBytes(StandardCharsets.UTF_8));
    byte[] source = Files.readAllBytes(sourceWithHref("data.xml"));

    assertNoCanary(() -> new String(XsltUtilities.saxonTransform(files, source, DOCUMENT_XSL.getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8));
  }

  // --- controls: the same paths load a harmless document, so the tests above are not vacuous --

  private static final String PLAIN_DOCUMENT = "<?xml version=\"1.0\"?>\n<d>plain</d>\n";

  @Test
  void controlDocumentInXsltDirIsLoaded() throws Exception {
    Files.writeString(xsltDir.resolve("data.xml"), PLAIN_DOCUMENT);
    Path style = writeStylesheet("doc.xsl", DOCUMENT_XSL);
    Path source = sourceWithHref("data.xml");

    XsltUtilities.saxonTransform(xsltDir.toString(), source.toString(), style.toString(), output.toString(), null);

    assertThat(Files.readString(output)).isEqualTo("plain");
  }

  @Test
  void controlDocumentFromMapIsLoaded() throws Exception {
    Map<String, byte[]> files = Map.of("data.xml", PLAIN_DOCUMENT.getBytes(StandardCharsets.UTF_8));
    byte[] source = Files.readAllBytes(sourceWithHref("data.xml"));

    byte[] out = XsltUtilities.saxonTransform(files, source, DOCUMENT_XSL.getBytes(StandardCharsets.UTF_8));

    assertThat(new String(out, StandardCharsets.UTF_8)).isEqualTo("plain");
  }

  @Test
  void controlRemoteDocumentViaAltIsLoaded() throws Exception {
    String url = serve(PLAIN_DOCUMENT);
    Path style = writeStylesheet("doc.xsl", DOCUMENT_XSL);
    Path source = sourceWithHref(url);

    XsltUtilities.saxonTransform(xsltDir.toString(), source.toString(), style.toString(), output.toString(), FETCHING_ALT);

    assertThat(Files.readString(output)).isEqualTo("plain");
  }

  /** Serves body at http://127.0.0.1:{port}/data.xml and returns the URL. */
  private String serve(String body) throws Exception {
    byte[] bytes = body.getBytes(StandardCharsets.UTF_8);
    server = HttpServer.create(new InetSocketAddress("127.0.0.1", 0), 0);
    server.createContext("/data.xml", exchange -> {
      exchange.getResponseHeaders().add("Content-Type", "application/xml");
      exchange.sendResponseHeaders(200, bytes.length);
      try (OutputStream os = exchange.getResponseBody()) {
        os.write(bytes);
      }
    });
    server.start();
    return "http://127.0.0.1:" + server.getAddress().getPort() + "/data.xml";
  }
}
