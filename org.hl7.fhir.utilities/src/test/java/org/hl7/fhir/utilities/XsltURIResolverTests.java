package org.hl7.fhir.utilities;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.xml.transform.Source;
import javax.xml.transform.TransformerException;
import javax.xml.transform.URIResolver;
import javax.xml.transform.stream.StreamSource;

import org.apache.commons.io.FileUtils;
import org.hl7.fhir.utilities.xslt.XsltURIResolver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.io.TempDir;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * MyURIResolver must only serve local files that are inside its configured root directory.
 */
class XsltURIResolverTests {

  @TempDir
  Path tempDir;

  /** allowed directory within tempDir (allowed) **/
  Path allowedDirectory;

  /** outside directory (not allowed) **/
  Path outsideDirectory;

  @BeforeEach
  void setUp() throws Exception {
    allowedDirectory = tempDir.resolve("allowedDirectory");
    Files.createDirectories(allowedDirectory.resolve("sub"));
    Files.writeString(allowedDirectory.resolve("a.xsl"), "A");
    Files.writeString(allowedDirectory.resolve("sub").resolve("b.xsl"), "B");
    outsideDirectory = tempDir.resolve("outside.txt");
    Files.writeString(outsideDirectory, "OUTSIDE");
  }

  @ParameterizedTest(name = "{index}: {0}")
  @CsvSource({"a.xsl, A", "sub/b.xsl, B", "sub\\b.xsl, B", "sub/../a.xsl, A"})
  void relativeHrefResolvesUnderRoot(String href, String expected) throws Exception {
    XsltURIResolver resolver = new XsltURIResolver(allowedDirectory.toString(), null);

    assertThat(read(resolver.resolve(href, null))).isEqualTo(expected);
  }

  @Test
  void absoluteHrefInsideRootIsResolved() throws Exception {
    XsltURIResolver resolver = new XsltURIResolver(allowedDirectory.toString(), null);

    String href = allowedDirectory.resolve("sub").resolve("b.xsl").toAbsolutePath().toString();

    assertThat(read(resolver.resolve(href, null))).isEqualTo("B");
  }

  @Test
  void absoluteHrefOutsideRootIsRejected() {
    XsltURIResolver resolver = new XsltURIResolver(allowedDirectory.toString(), null);

    String href = outsideDirectory.toAbsolutePath().toString();

    assertThrows(TransformerException.class, () -> resolver.resolve(href, null));
  }

  /**
   * The target doesn't exist, so if toRealPath() ran first it would fail with NoSuchFileException.
   * Getting the "not permitted" refusal shows the lexical check ran before any filesystem access.
   */
  @Test
  void absoluteHrefOutsideRootIsRejectedBeforeFilesystemAccess() {
    XsltURIResolver resolver = new XsltURIResolver(allowedDirectory.toString(), null);

    String href = tempDir.resolve("missing").resolve("none.xml").toAbsolutePath().toString();

    TransformerException e = assertThrows(TransformerException.class, () -> resolver.resolve(href, null));
    assertThat(e).hasMessageContaining("is not permitted");
  }

  /**
   * A UNC path outside the root must be refused lexically: touching it would open an SMB connection,
   * which can leak an NTLM hash. The host is unresolvable so the test can't reach the network.
   */
  @Test
  @EnabledOnOs(OS.WINDOWS)
  void uncHrefIsRejectedBeforeFilesystemAccess() {
    XsltURIResolver resolver = new XsltURIResolver(allowedDirectory.toString(), null);

    TransformerException e = assertThrows(TransformerException.class, () -> resolver.resolve("\\\\host.invalid\\share\\x.xml", null));
    assertThat(e).hasMessageContaining("is not permitted");
  }

  @Test
  void absoluteHrefToSiblingDirectoryWithSharedPrefixIsRejected() throws Exception {
    Path sibling = tempDir.resolve("root-sibling");
    Files.createDirectories(sibling);
    Files.writeString(sibling.resolve("x.xsl"), "SIBLING");
    XsltURIResolver resolver = new XsltURIResolver(allowedDirectory.toString(), null);

    String href = sibling.resolve("x.xsl").toAbsolutePath().toString();

    assertThrows(TransformerException.class, () -> resolver.resolve(href, null));
  }

  @ParameterizedTest(name = "{index}: {0}")
  @ValueSource(strings = {"../outside.txt", "sub/../../outside.txt", "..\\outside.txt"})
  void traversalOutsideRootIsRejected(String href) {
    XsltURIResolver resolver = new XsltURIResolver(allowedDirectory.toString(), null);

    assertThrows(TransformerException.class, () -> resolver.resolve(href, null));
  }

  @Test
  void symlinkedDirectoryPointingOutsideRootIsRejected() throws Exception {
    Path outsideDir = Files.createDirectories(tempDir.resolve("outside-dir"));
    Files.writeString(outsideDir.resolve("secret.xsl"), "SECRET");
    createSymlinkOrSkip(allowedDirectory.resolve("pivot"), outsideDir);
    XsltURIResolver resolver = new XsltURIResolver(allowedDirectory.toString(), null);

    assertThrows(TransformerException.class, () -> resolver.resolve("pivot/secret.xsl", null));
  }

  @Test
  void symlinkedFilePointingOutsideRootIsRejected() {
    createSymlinkOrSkip(allowedDirectory.resolve("link.xsl"), outsideDirectory);
    XsltURIResolver resolver = new XsltURIResolver(allowedDirectory.toString(), null);

    assertThrows(TransformerException.class, () -> resolver.resolve("link.xsl", null));
  }

  @Test
  void symlinkPointingInsideRootIsResolved() throws Exception {
    createSymlinkOrSkip(allowedDirectory.resolve("alias"), allowedDirectory.resolve("sub"));
    XsltURIResolver resolver = new XsltURIResolver(allowedDirectory.toString(), null);

    assertThat(read(resolver.resolve("alias/b.xsl", null))).isEqualTo("B");
  }

  @Test
  void symlinkedRootIsResolved() throws Exception {
    Path linkedRoot = tempDir.resolve("linked-root");
    createSymlinkOrSkip(linkedRoot, allowedDirectory);
    XsltURIResolver resolver = new XsltURIResolver(linkedRoot.toString(), null);

    assertThat(read(resolver.resolve("sub/b.xsl", null))).isEqualTo("B");
  }

  @ParameterizedTest(name = "{index}: {0}")
  @ValueSource(strings = {"http://example.org/a.xsl", "https://example.org/a.xsl"})
  void remoteHrefWithoutAltIsRejected(String href) {
    XsltURIResolver resolver = new XsltURIResolver(allowedDirectory.toString(), null);

    TransformerException e = assertThrows(TransformerException.class, () -> resolver.resolve(href, null));
    assertThat(e).hasMessageContaining("remote resources require a caller-supplied resolver");
  }

  @Test
  void remoteHrefIsRejectedWhenAltReturnsNull() {
    URIResolver declining = (href, base) -> null;
    XsltURIResolver resolver = new XsltURIResolver(allowedDirectory.toString(), declining);

    TransformerException e = assertThrows(TransformerException.class, () -> resolver.resolve("http://example.org/a.xsl", null));
    assertThat(e).hasMessageContaining("remote resources require a caller-supplied resolver");
  }

  @Test
  void remoteHrefIsServedByAlt() throws Exception {
    Source fromAlt = new StreamSource(new ByteArrayInputStream("ALT".getBytes(StandardCharsets.UTF_8)));
    XsltURIResolver resolver = new XsltURIResolver(allowedDirectory.toString(), (href, base) -> fromAlt);

    assertThat(resolver.resolve("http://example.org/a.xsl", null)).isSameAs(fromAlt);
  }

  @Test
  void nullRootIsRejected() {
    XsltURIResolver resolver = new XsltURIResolver(null, null);

    assertThrows(TransformerException.class, () -> resolver.resolve("a.xsl", null));
  }

  @Test
  void tmpVariableRootIsExpanded() throws Exception {
    Path tmp = Path.of(Utilities.path("[tmp]"));
    Path tmpRoot = Files.createTempDirectory(tmp, "my-uri-resolver-");
    try {
      Files.createDirectories(tmpRoot.resolve("sub"));
      Files.writeString(tmpRoot.resolve("a.xsl"), "TMP-A");
      Files.writeString(tmpRoot.resolve("sub").resolve("b.xsl"), "TMP-B");
      XsltURIResolver resolver = new XsltURIResolver("[tmp]/" + tmpRoot.getFileName(), null);

      assertThat(read(resolver.resolve("a.xsl", null))).isEqualTo("TMP-A");
      assertThat(read(resolver.resolve("sub/b.xsl", null))).isEqualTo("TMP-B");
    } finally {
      FileUtils.deleteDirectory(tmpRoot.toFile());
    }
  }

  /** Creates a symlink, or skips the test where the platform or user cannot (for example, Windows without the privilege). */
  static void createSymlinkOrSkip(Path link, Path target) {
    try {
      Files.createSymbolicLink(link, target);
    } catch (IOException | UnsupportedOperationException e) {
      assumeTrue(false, "symlinks not supported here: " + e);
    }
  }

  private static String read(Source source) throws Exception {
    assertThat(source).isInstanceOf(StreamSource.class);
    try (InputStream in = ((StreamSource) source).getInputStream()) {
      return new String(in.readAllBytes(), StandardCharsets.UTF_8);
    }
  }
}
