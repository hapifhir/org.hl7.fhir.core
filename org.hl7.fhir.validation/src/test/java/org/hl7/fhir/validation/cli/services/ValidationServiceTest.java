package org.hl7.fhir.validation.cli.services;

import org.apache.commons.io.IOUtils;
import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.elementmodel.Manager;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.utilities.TimeTracker;
import org.hl7.fhir.utilities.tests.ResourceLoaderTests;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.cli.model.CliContext;
import org.hl7.fhir.validation.cli.model.FileInfo;
import org.hl7.fhir.validation.cli.model.ValidationRequest;
import org.hl7.fhir.validation.tests.utilities.TestUtilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.hl7.fhir.validation.tests.utilities.TestUtilities.getTerminologyCacheDirectory;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.AdditionalMatchers.and;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

class ValidationServiceTest implements ResourceLoaderTests {

  final String DUMMY_SOURCE = "dummySource";
  final String DUMMY_SOURCE1 = "dummySource1";
  final String DUMMY_SOURCE2 = "dummySource2";
  final String DUMMY_SOURCE3 = "dummySource3";
  final String DUMMY_OUTPUT = "dummyOutput";

  final String DUMMY_SV = "1.2.3";

  @Test
  void validateSources() throws Exception {
    TestingUtilities.injectCorePackageLoader();
    SessionCache sessionCache = Mockito.spy(new SessionCache());
    ValidationService myService = new ValidationService(sessionCache);

    String resource = IOUtils.toString(getFileFromResourceAsStream("detected_issues.json"), StandardCharsets.UTF_8);
    List<FileInfo> filesToValidate = new ArrayList<>();
    filesToValidate.add(new FileInfo().setFileName("test_resource.json").setFileContent(resource).setFileType(Manager.FhirFormat.JSON.getExtension()));

    ValidationRequest request = new ValidationRequest().setCliContext(new CliContext().setTxCache(getTerminologyCacheDirectory("validationService"))).setFilesToValidate(filesToValidate);
    // Validation run 1...nothing cached yet
    myService.validateSources(request);
    verify(sessionCache, Mockito.times(1)).cacheSession(ArgumentMatchers.any(ValidationEngine.class));

    Set<String> sessionIds = sessionCache.getSessionIds();
    if (sessionIds.stream().findFirst().isPresent()) {
      // Verify that after 1 run there is only one entry within the cache
      Assertions.assertEquals(1, sessionIds.size());
      myService.validateSources(request);
      // Verify that the cache has been called on once with the id created in the first run
      verify(sessionCache, Mockito.times(1)).fetchSessionValidatorEngine(sessionIds.stream().findFirst().get());
    } else {
      // If no sessions exist within the cache after a run, we auto-fail.
      fail();
    }
  }

  private InputStream getFileFromResourceAsStream(String fileName) {
    // The class loader that loaded the class
    ClassLoader classLoader = getClass().getClassLoader();
    InputStream inputStream = classLoader.getResourceAsStream(fileName);

    // the stream holding the file content
    if (inputStream == null) {
      throw new IllegalArgumentException("file not found! " + fileName);
    } else {
      return inputStream;
    }
  }

  @Test
  @DisplayName("Test that conversion works when a single source is set and the -output param is set")
  public void convertSingleSource() throws Exception {
    SessionCache sessionCache = mock(SessionCache.class);
    ValidationService validationService = new ValidationService(sessionCache);
    ValidationEngine validationEngine = mock(ValidationEngine.class);

    CliContext cliContext = getCliContextSingleSource();
    validationService.convertSources(cliContext.setOutput(DUMMY_OUTPUT),validationEngine);

    verify(validationEngine).convert(DUMMY_SOURCE, DUMMY_OUTPUT);
  }

  @Test
  @DisplayName("Test that conversion throws an Exception when no -output or -outputSuffix params are set")
  public void convertSingleSourceNoOutput() throws Exception {
    SessionCache sessionCache = mock(SessionCache.class);
    ValidationService validationService = new ValidationService(sessionCache);
    ValidationEngine validationEngine = mock(ValidationEngine.class);

    CliContext cliContext = getCliContextSingleSource();
    Exception exception = assertThrows( Exception.class, () -> {
      validationService.convertSources(cliContext,validationEngine);
    });
  }



  @Test
  @DisplayName("Test that conversion throws an Exception when multiple sources are set and an -output param is set")
  public void convertMultipleSourceOnlyOutput() throws Exception {
    SessionCache sessionCache = mock(SessionCache.class);
    ValidationService validationService = new ValidationService(sessionCache);
    ValidationEngine validationEngine = mock(ValidationEngine.class);

    CliContext cliContext = getCliContextMultipleSource();
    assertThrows( Exception.class, () -> {
        validationService.convertSources(cliContext,validationEngine);
      }
    );
  }

  @Test
  @DisplayName("Test that conversion works when multiple sources are set and an output suffix parameter is set")
  public void convertMultipleSource() throws Exception {
    SessionCache sessionCache = mock(SessionCache.class);
    ValidationService validationService = new ValidationService(sessionCache);
    ValidationEngine validationEngine = mock(ValidationEngine.class);

    CliContext cliContext = getCliContextMultipleSource();
    validationService.convertSources(cliContext.setOutputSuffix(DUMMY_OUTPUT),validationEngine);
    verify(validationEngine).convert(eq(DUMMY_SOURCE1), and(startsWith(DUMMY_SOURCE1), endsWith(DUMMY_OUTPUT)));
    verify(validationEngine).convert(eq(DUMMY_SOURCE2), and(startsWith(DUMMY_SOURCE2), endsWith(DUMMY_OUTPUT)));
    verify(validationEngine).convert(eq(DUMMY_SOURCE3), and(startsWith(DUMMY_SOURCE3), endsWith(DUMMY_OUTPUT)));
  }

  @Test
  @DisplayName("Test that snapshot generation works when a single source is set and the -output param is set")
  public void generateSnapshotSingleSource() throws Exception {
    SessionCache sessionCache = mock(SessionCache.class);
    ValidationService validationService = new ValidationService(sessionCache);
    ValidationEngine validationEngine = mock(ValidationEngine.class);
    StructureDefinition structureDefinition = mock(StructureDefinition.class);
    when(validationEngine.snapshot(DUMMY_SOURCE, DUMMY_SV)).thenReturn(structureDefinition);
    CliContext cliContext = getCliContextSingleSource();
    validationService.generateSnapshot(cliContext.setOutput(DUMMY_OUTPUT).setSv(DUMMY_SV),validationEngine);

    verify(validationEngine).snapshot(DUMMY_SOURCE, DUMMY_SV);
    verify(validationEngine).handleOutput(structureDefinition, DUMMY_OUTPUT, DUMMY_SV);
  }

  @Test
  @DisplayName("Test that snapshot generation throws an Exception when no -output or -outputSuffix params are set")
  public void generateSnapshotSingleSourceNoOutput() throws Exception {
    SessionCache sessionCache = mock(SessionCache.class);
    ValidationService validationService = new ValidationService(sessionCache);
    ValidationEngine validationEngine = mock(ValidationEngine.class);

    CliContext cliContext = getCliContextSingleSource();
    Exception exception = assertThrows( Exception.class, () -> {
      validationService.generateSnapshot(cliContext.setSv(DUMMY_SV),validationEngine);
    });
  }

  @Test
  @DisplayName("Test that snapshot generation throws an Exception when multiple sources are set and an -output param is set")
  public void generateSnapshotMultipleSourceOnlyOutput() throws Exception {
    SessionCache sessionCache = mock(SessionCache.class);
    ValidationService validationService = new ValidationService(sessionCache);
    ValidationEngine validationEngine = mock(ValidationEngine.class);

    CliContext cliContext = getCliContextMultipleSource();
    assertThrows( Exception.class, () -> {
      validationService.generateSnapshot(cliContext.setOutput(DUMMY_OUTPUT).setSv(DUMMY_SV),validationEngine);
      }
    );
  }

  @Test
  @DisplayName("Test that snapshot generation works when multiple sources are set and an output suffix parameter is set")
  public void generateSnapshotMultipleSource() throws Exception {
    SessionCache sessionCache = mock(SessionCache.class);
    ValidationService validationService = new ValidationService(sessionCache);
    ValidationEngine validationEngine = mock(ValidationEngine.class);

    StructureDefinition structureDefinition1 = mock(StructureDefinition.class);
    StructureDefinition structureDefinition2 = mock(StructureDefinition.class);
    StructureDefinition structureDefinition3 = mock(StructureDefinition.class);

    when(validationEngine.snapshot(DUMMY_SOURCE1, DUMMY_SV)).thenReturn(structureDefinition1);
    when(validationEngine.snapshot(DUMMY_SOURCE2, DUMMY_SV)).thenReturn(structureDefinition2);
    when(validationEngine.snapshot(DUMMY_SOURCE3, DUMMY_SV)).thenReturn(structureDefinition3);


    CliContext cliContext = getCliContextMultipleSource();
    validationService.generateSnapshot(cliContext.setOutputSuffix(DUMMY_OUTPUT).setSv(DUMMY_SV),validationEngine);
    verify(validationEngine).snapshot(DUMMY_SOURCE1, DUMMY_SV);
    verify(validationEngine).handleOutput(eq(structureDefinition1), and(startsWith(DUMMY_SOURCE1),endsWith(DUMMY_OUTPUT)), eq(DUMMY_SV));
    verify(validationEngine).snapshot(DUMMY_SOURCE2, DUMMY_SV);
    verify(validationEngine).handleOutput(eq(structureDefinition2), and(startsWith(DUMMY_SOURCE2), endsWith(DUMMY_OUTPUT)), eq(DUMMY_SV));
    verify(validationEngine).snapshot(DUMMY_SOURCE3, DUMMY_SV);
    verify(validationEngine).handleOutput(eq(structureDefinition3), and(startsWith(DUMMY_SOURCE3), endsWith(DUMMY_OUTPUT)), eq(DUMMY_SV));

  }

  private CliContext getCliContextSingleSource() {
    CliContext cliContext;
    cliContext = new CliContext().setSources(Arrays.asList(DUMMY_SOURCE));
    return cliContext;
  }
  private CliContext getCliContextMultipleSource() {
    CliContext cliContext;
    cliContext = new CliContext().setSources(Arrays.asList(DUMMY_SOURCE1, DUMMY_SOURCE2, DUMMY_SOURCE3));
    return cliContext;
  }

  /* This is a particularly long way to test that a single field in ValidationEngine was set.
     However, it does provide example code to test other parts of the buildValidationEngine method as well.
  */
  @Test
  public void buildValidationEngineTest() throws IOException, URISyntaxException {

    final org.hl7.fhir.utilities.TimeTracker timeTracker = mock(org.hl7.fhir.utilities.TimeTracker.class);

    final SimpleWorkerContext workerContext = mock(SimpleWorkerContext.class);

    final ValidationEngine validationEngine = mock(ValidationEngine.class);
    when(validationEngine.getContext()).thenReturn(workerContext);

    final ValidationService validationService = new ValidationService() {
      @Override
      protected ValidationEngine.ValidationEngineBuilder getValidationEngineBuilder() {

        ValidationEngine.ValidationEngineBuilder validationEngineBuilder = mock(ValidationEngine.ValidationEngineBuilder.class);

        when(validationEngineBuilder.withTHO(anyBoolean())).thenReturn(validationEngineBuilder);
        when(validationEngineBuilder.withVersion(isNull())).thenReturn(validationEngineBuilder);
        when(validationEngineBuilder.withTimeTracker(any())).thenReturn(validationEngineBuilder);
        when(validationEngineBuilder.withUserAgent(anyString())).thenReturn(validationEngineBuilder);
        try {
          when(validationEngineBuilder.fromSource(isNull())).thenReturn(validationEngine);
        } catch (IOException e) {
          throw new RuntimeException(e);
        } catch (URISyntaxException e) {
          throw new RuntimeException(e);
        }
        return validationEngineBuilder;
      }

      @Override
      protected void loadIgsAndExtensions(ValidationEngine validationEngine, CliContext cliContext, TimeTracker timeTracker) throws IOException, URISyntaxException {
        //Don't care. Do nothing.
      }
    };

    Path path = Files.createTempFile("fhir-settings", "json");

    copyResourceToFile(path, "settings", "settings-example.json");

    CliContext cliContext = new CliContext();

    cliContext.setFhirSettingsFile(path.toAbsolutePath().toString());
    validationService.buildValidationEngine(cliContext, null, timeTracker);

    verify(validationEngine).setFhirSettings(argThat(settings -> "dummy-api-key".equals(settings.getApiKey())));
  }
}