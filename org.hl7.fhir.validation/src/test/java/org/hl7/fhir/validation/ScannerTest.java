package org.hl7.fhir.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

import org.hl7.fhir.utilities.tests.ResourceLoaderTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ScannerTest implements ResourceLoaderTests {

  public static final String ZIP_NORMAL_ZIP = "zip-normal.zip";
  public static final String ZIP_SLIP_ZIP = "zip-slip.zip";
  public static final String ZIP_SLIP_2_ZIP = "zip-slip-2.zip";
  public static final String ZIP_SLIP_PEER_ZIP = "zip-slip-peer.zip";
  public static final String ZIP_SLIP_WIN_ZIP = "zip-slip-win.zip";

  Path tempDir;
  Path zipNormalPath;
  Path zipSlipPath;

  Path zipSlip2Path;

  Path zipSlipPeerPath;

  Path zipSlipWinPath;

  @BeforeAll
  public void beforeAll() throws IOException {
    tempDir = Files.createTempDirectory("scanner-zip");
    tempDir.resolve("child").toFile().mkdir();
    zipNormalPath = tempDir.resolve(ZIP_NORMAL_ZIP);
    zipSlipPath = tempDir.resolve(ZIP_SLIP_ZIP);
    zipSlip2Path = tempDir.resolve(ZIP_SLIP_2_ZIP);
    zipSlipPeerPath = tempDir.resolve(ZIP_SLIP_PEER_ZIP);
    zipSlipWinPath = tempDir.resolve(ZIP_SLIP_WIN_ZIP);

    copyResourceToFile(zipNormalPath, "zip-slip", ZIP_NORMAL_ZIP);
    copyResourceToFile(zipSlipPath, "zip-slip", ZIP_SLIP_ZIP);
    copyResourceToFile(zipSlip2Path, "zip-slip", ZIP_SLIP_2_ZIP);
    copyResourceToFile(zipSlipPeerPath, "zip-slip", ZIP_SLIP_PEER_ZIP);
    copyResourceToFile(zipSlipWinPath, "zip-slip", ZIP_SLIP_WIN_ZIP);
  }
  
  @Test
  public void testNormalZip() throws IOException {
    Scanner scanner = new Scanner(null,null,null,null);
    scanner.unzip(zipNormalPath.toFile().getAbsolutePath(), tempDir.toFile().getAbsolutePath());

    Path expectedFilePath = tempDir.resolve("zip-normal").resolve("depth1").resolve("test.txt");
    String actualContent = Files.readString(expectedFilePath);
    assertEquals("dummy file content", actualContent);
  }

  public  Stream<Arguments> zipSlipData()  {

    return Stream.of(
      Arguments.of(zipSlipPath, "Entry with an illegal path: ../evil.txt"),
      Arguments.of(zipSlip2Path, "Entry with an illegal path: child/../../evil.txt"),
      Arguments.of(zipSlipPeerPath, "Entry with an illegal path: ../childpeer/evil.txt"),
      Arguments.of(zipSlipWinPath, "Entry with an illegal path: ../evil.txt")
    );
  }

  @ParameterizedTest(name = "{index}: file {0}")
  @MethodSource("zipSlipData")
  public void testUnzipZipSlip(Path path, String expectedMessage) {
    RuntimeException thrown = Assertions.assertThrows(RuntimeException.class, () -> {
      Scanner scanner = new Scanner(null,null,null,null);
      scanner.unzip(path.toFile().getAbsolutePath(), tempDir.toFile().getAbsolutePath());
    });
    assertNotNull(thrown);
    assertEquals(expectedMessage, thrown.getMessage());
  }

}
