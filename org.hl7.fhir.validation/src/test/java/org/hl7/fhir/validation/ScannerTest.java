package org.hl7.fhir.validation;

import org.hl7.fhir.utilities.tests.ResourceLoaderTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ScannerTest implements ResourceLoaderTests {

  public static final String ZIP_NORMAL_ZIP = "zip-normal.zip";
  public static final String ZIP_SLIP_ZIP = "zip-slip.zip";
  Path tempDir;
  Path zipNormalPath;
  Path zipSlipPath;
  @BeforeAll
  public void beforeAll() throws IOException {
    tempDir = Files.createTempDirectory("scanner-zip");

    zipNormalPath = tempDir.resolve(ZIP_NORMAL_ZIP);
    zipSlipPath = tempDir.resolve(ZIP_SLIP_ZIP);
    copyResourceToFile(zipNormalPath, "scanner", ZIP_NORMAL_ZIP);
    copyResourceToFile(zipSlipPath, "scanner", ZIP_SLIP_ZIP);
  }
  
  @Test
  public void testNormalZip() throws IOException {
    Scanner scanner = new Scanner(null,null,null,null);
    scanner.unzip(zipNormalPath.toFile().getAbsolutePath(), tempDir.toFile().getAbsolutePath());

    Path expectedFilePath = tempDir.resolve("zip-normal").resolve("depth1").resolve("test.txt");
    String actualContent = Files.readString(expectedFilePath);
    assertEquals("dummy file content", actualContent);
  }

  @Test
  public void testSlipZip() throws IOException {
    RuntimeException thrown = Assertions.assertThrows(RuntimeException.class, () -> {
      Scanner scanner = new Scanner(null,null,null,null);
      scanner.unzip(zipSlipPath.toFile().getAbsolutePath(), tempDir.toFile().getAbsolutePath());
      //Code under test
    });
    assertNotNull(thrown);
  }
}
