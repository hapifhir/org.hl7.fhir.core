package org.hl7.fhir.r4b.context;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleWorkerContextTests {
  public static Stream<Arguments> zipSlipData()  {

    return Stream.of(
      Arguments.of("zip-slip/zip-slip.zip", "Entry with an illegal path: ../evil.txt"),
      Arguments.of("zip-slip/zip-slip-2.zip", "Entry with an illegal path: child/../../evil.txt"),
      Arguments.of("zip-slip/zip-slip-peer.zip", "Entry with an illegal path: ../childpeer/evil.txt"),
      Arguments.of("zip-slip/zip-slip-win.zip", "Entry with an illegal path: ../evil.txt")
    );
  }

  @ParameterizedTest(name = "{index}: file {0}")
  @MethodSource("zipSlipData")
  public void testLoadFromClasspathZipSlip(String classPath, String expectedMessage) {
    RuntimeException thrown = Assertions.assertThrows(RuntimeException.class, () -> {SimpleWorkerContext.fromClassPath(classPath);});
    assertNotNull(thrown);
    assertEquals(expectedMessage, thrown.getMessage());
  }

  @Test
  public void testLoadFromClasspathBinaries() throws IOException {
    SimpleWorkerContext simpleWorkerContext = SimpleWorkerContext.fromClassPath("zip-slip/zip-normal.zip");

    final String testPath = "zip-normal/depth1/test.txt";
    assertTrue(simpleWorkerContext.binaries.containsKey(testPath));
    String testFileContent = new String(simpleWorkerContext.binaries.get(testPath), StandardCharsets.UTF_8);
    assertEquals("dummy file content", testFileContent);
  }
}
