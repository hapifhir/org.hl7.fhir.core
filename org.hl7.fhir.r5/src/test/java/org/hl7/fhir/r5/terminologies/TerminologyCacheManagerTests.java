package org.hl7.fhir.r5.terminologies;

import org.hl7.fhir.utilities.tests.ResourceLoaderTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TerminologyCacheManagerTests implements ResourceLoaderTests {

  public static final String ZIP_NORMAL_ZIP = "zip-normal.zip";
  public static final String ZIP_SLIP_ZIP = "zip-slip.zip";

  public static final String ZIP_SLIP_2_ZIP = "zip-slip-2.zip";
  Path tempDir;

  @BeforeAll
  public void beforeAll() throws IOException {
    tempDir = Files.createTempDirectory("terminology-cache-manager");

    tempDir.resolve("child").toFile().mkdir();
    getResourceAsInputStream("terminologyCacheManager", ZIP_SLIP_ZIP);
  }

  @Test
  public void testNormalZip() throws IOException {
    InputStream normalInputStream = getResourceAsInputStream( "terminologyCacheManager", ZIP_NORMAL_ZIP);
    TerminologyCacheManager.unzip( normalInputStream, tempDir.toFile().getAbsolutePath());

    Path expectedFilePath = tempDir.resolve("zip-normal").resolve("depth1").resolve("test.txt");
    String actualContent = Files.readString(expectedFilePath);
    assertEquals("dummy file content", actualContent);
  }

  @Test
  public void testSlipZip() throws IOException {
    RuntimeException thrown = Assertions.assertThrows(RuntimeException.class, () -> {
      InputStream slipInputStream = getResourceAsInputStream( "terminologyCacheManager", ZIP_SLIP_ZIP);
      TerminologyCacheManager.unzip( slipInputStream, tempDir.toFile().getAbsolutePath());
      //Code under test
    });
    assertNotNull(thrown);
    assertEquals("Entry with an illegal path: ../evil.txt", thrown.getMessage());
  }

  @Test
  public void testSlip2Zip() throws IOException {
    RuntimeException thrown = Assertions.assertThrows(RuntimeException.class, () -> {
      InputStream slipInputStream = getResourceAsInputStream( "terminologyCacheManager", ZIP_SLIP_2_ZIP);
      TerminologyCacheManager.unzip( slipInputStream, tempDir.toFile().getAbsolutePath());
      //Code under test
    });
    assertNotNull(thrown);
    assertEquals("Entry with an illegal path: child/../../evil.txt", thrown.getMessage());
  }

}
