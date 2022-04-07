package org.hl7.fhir.validation;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.model.ImplementationGuide;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class IgLoaderTests {

  final static String DUMMY_PATH = Paths.get("src","test","resources", "igLoad", "my-dummy-ig.json").toAbsolutePath().toString();

  @Mock
  FilesystemPackageCacheManager filesystemPackageCacheManager;

  @Mock
  SimpleWorkerContext simpleWorkerContext;

  @Mock
  org.hl7.fhir.utilities.TimeTracker timeTracker;

  private static Stream<Arguments> getTestIgLoadParams() {
      return Stream.of(
              Arguments.of(DUMMY_PATH, DUMMY_PATH, "4.0.1"),
              Arguments.of("[3.0.1]" + DUMMY_PATH, DUMMY_PATH, "3.0.1"),
              Arguments.of("[" + DUMMY_PATH, "[" + DUMMY_PATH, "4.0.1")
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
  public void testFailIfInvalidFHIRVersion() {
    Exception exception = assertThrows(FHIRException.class, () -> {
      IgLoader igLoader = Mockito.spy(new IgLoader(
        filesystemPackageCacheManager,
        simpleWorkerContext,
        "4.0.1"
      ));

      List<ImplementationGuide> igs = Collections.emptyList();
      igLoader.loadIg(igs,
        Collections.emptyMap(),
        "[0.1.2]" + DUMMY_PATH,
        false);
    });
  }
}
