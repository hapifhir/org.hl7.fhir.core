package org.hl7.fhir.r4b.terminologies;

import org.hl7.fhir.utilities.tests.ResourceLoaderTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TerminologyCacheManagerTests implements ResourceLoaderTests {
 
  Path tempDir;

  @BeforeAll
  public void beforeAll() throws IOException {
    tempDir = Files.createTempDirectory("terminology-cache-manager");
    tempDir.resolve("child").toFile().mkdir();
  }

  @Test
  public void testNormalZip() throws IOException {
    InputStream normalInputStream = getResourceAsInputStream("zip-slip", "zip-normal.zip");
    TerminologyCacheManager.unzip( normalInputStream, tempDir.toFile().getAbsolutePath());

    Path expectedFilePath = tempDir.resolve("zip-normal").resolve("depth1").resolve("test.txt");
    String actualContent = Files.readString(expectedFilePath);
    assertEquals("dummy file content", actualContent);
  }

  public static Stream<Arguments> zipSlipData()  {

    return Stream.of(
      Arguments.of("zip-slip.zip", "../evil.txt"),
      Arguments.of("zip-slip-2.zip", "child/../../evil.txt"),
      Arguments.of("zip-slip-peer.zip", "../childpeer/evil.txt"),
      Arguments.of("zip-slip-win.zip", "../evil.txt")
    );
  }

  @ParameterizedTest(name = "{index}: file {0}")
  @MethodSource("zipSlipData")
  public void testLoadFromClasspathZipSlip(String fileName, String expectedMessage) {
    RuntimeException thrown = Assertions.assertThrows(RuntimeException.class, () -> {
      InputStream slipInputStream = getResourceAsInputStream("zip-slip", fileName);
      TerminologyCacheManager.unzip( slipInputStream, tempDir.toFile().getAbsolutePath());
      //Code under test
    });
    assertNotNull(thrown);
    Assertions.assertTrue(thrown.getMessage().endsWith(expectedMessage));
  }
}
