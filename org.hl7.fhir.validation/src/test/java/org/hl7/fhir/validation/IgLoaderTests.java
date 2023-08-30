package org.hl7.fhir.validation;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.model.ImplementationGuide;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class IgLoaderTests {

  final static String DUMMY_PATH = Paths.get("src","test","resources", "igLoad", "my-dummy-ig.json").toAbsolutePath().toString();
  final static String DUMMY_FOO_PATH = Paths.get("src","test","resources", "igLoad", "my-dummy-ig[foo].json").toAbsolutePath().toString();

  @Mock
  FilesystemPackageCacheManager filesystemPackageCacheManager;

  @Mock
  SimpleWorkerContext simpleWorkerContext;

  @Mock
  org.hl7.fhir.utilities.TimeTracker timeTracker;

  private static Stream<Arguments> getTestIgLoadParams() {
      return Stream.of(
              Arguments.of(DUMMY_PATH, DUMMY_PATH, "4.0.1"),
              Arguments.of("[3.0.2]" + DUMMY_PATH, DUMMY_PATH, "3.0.2"),
              Arguments.of("[" + DUMMY_PATH, "[" + DUMMY_PATH, "4.0.1"),
              Arguments.of(DUMMY_FOO_PATH, DUMMY_FOO_PATH, "4.0.1"),
              Arguments.of("[3.0.2]"+DUMMY_FOO_PATH, DUMMY_FOO_PATH, "3.0.2")
      );
  }

  @ParameterizedTest
  @MethodSource("getTestIgLoadParams")
  public void testIgLoad(String packageString, String expectedPackageName, String expectedFhirVersion) throws IOException {

    final byte[] dummyBytes = {};
    final String dummyKey = "dummyKey";

    final Map<String, byte[]> dummyMap = new HashMap<>();
    dummyMap.put(dummyKey, dummyBytes);


      IgLoader igLoader = Mockito.spy(new IgLoader(
      filesystemPackageCacheManager,
      simpleWorkerContext,
      "4.0.1"
    ));

    doReturn(dummyMap).when(igLoader).loadIgSource(expectedPackageName, false, true);
    doReturn(timeTracker).when(simpleWorkerContext).clock();

    List<ImplementationGuide> igs = Collections.emptyList();
    igLoader.loadIg( igs,
      Collections.emptyMap(),
      packageString,
   false);

    Mockito.verify(igLoader, times(1)).loadResourceByVersion(expectedFhirVersion, dummyBytes, dummyKey);
  }

  @Test
  public void testFailIfInvalidFHIRVersion() throws IOException {
    IgLoader igLoader = Mockito.spy(new IgLoader(
      filesystemPackageCacheManager,
      simpleWorkerContext,
      "4.0.1"
    ));
    Exception exception = assertThrows(FHIRException.class, () -> {

      List<ImplementationGuide> igs = Collections.emptyList();
      igLoader.loadIg(igs,
        Collections.emptyMap(),
        "[0.1.2]" + DUMMY_PATH,
        false);
    });

    assertLinesMatch(Arrays.asList(".*Unsupported FHIR Version.*"), Arrays.asList(exception.getMessage()));
  }

  public static Stream<Arguments> zipSlipData()  {

    return Stream.of(
      Arguments.of("/zip-slip/zip-slip.zip", "Entry with an illegal path: ../evil.txt"),
      Arguments.of("/zip-slip/zip-slip-2.zip", "Entry with an illegal path: child/../../evil.txt"),
      Arguments.of("/zip-slip/zip-slip-peer.zip", "Entry with an illegal path: ../childpeer/evil.txt"),
      Arguments.of("/zip-slip/zip-slip-win.zip", "Entry with an illegal path: ../evil.txt")
    );
  }

  @ParameterizedTest(name = "{index}: file {0}")
  @MethodSource("zipSlipData")
  public void testReadZipSlip(String classPath, String expectedMessage) {
    RuntimeException thrown = Assertions.assertThrows(RuntimeException.class, () -> {
      IgLoader igLoader = Mockito.spy(new IgLoader(
        filesystemPackageCacheManager,
        simpleWorkerContext,
        "4.0.1"
      ));
      igLoader.readZip(IgLoaderTests.class.getResourceAsStream((classPath)));
    });
    assertNotNull(thrown);
    Assertions.assertEquals(expectedMessage, thrown.getMessage());
  }

  @Test
  public void testReadZip() throws IOException {
    IgLoader igLoader = Mockito.spy(new IgLoader(
      filesystemPackageCacheManager,
      simpleWorkerContext,
      "4.0.1"
    ));
    Map<String, byte[]> map = igLoader.readZip(IgLoaderTests.class.getResourceAsStream("/zip-slip/zip-normal.zip"));
    final String testPath = "zip-normal/depth1/test.txt";
    assertTrue(map.containsKey(testPath));
    String testFileContent = new String(map.get(testPath), StandardCharsets.UTF_8);
    Assertions.assertEquals("dummy file content", testFileContent);
  }
}
