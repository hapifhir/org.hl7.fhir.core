package org.hl7.fhir.validation.service;

import static org.hl7.fhir.validation.tests.utilities.TestUtilities.getTerminologyCacheDirectory;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.AdditionalMatchers.and;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.endsWith;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.ArgumentMatchers.notNull;
import static org.mockito.ArgumentMatchers.startsWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.IOUtils;
import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.elementmodel.Manager;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.r5.utils.validation.IValidationPolicyAdvisor;
import org.hl7.fhir.utilities.TimeTracker;
import org.hl7.fhir.utilities.VersionUtil;
import org.hl7.fhir.utilities.settings.FhirSettings;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.service.model.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

class ValidationServiceTests {

  final String DUMMY_SOURCE = "dummySource";
  final String DUMMY_SOURCE1 = "dummySource1";
  final String DUMMY_SOURCE2 = "dummySource2";
  final String DUMMY_SOURCE3 = "dummySource3";
  final String DUMMY_OUTPUT = "dummyOutput";

  final String DUMMY_SV = "1.2.3";

  @DisplayName("Test validation session persists in session cache")
  @Test
  void validationSessionTest() throws Exception {
    TestingUtilities.injectCorePackageLoader();
    SessionCache sessionCache = Mockito.spy(new PassiveExpiringSessionCache());
    ValidationService myService = Mockito.spy(new ValidationService(sessionCache));

    List<FileInfo> filesToValidate = getFilesToValidate();

    ValidationRequest request = new ValidationRequest().setValidationEngineParameters(new ValidationEngineParameters().setTxServer(FhirSettings.getTxFhirDevelopment()).setTxCache(getTerminologyCacheDirectory("validationService"))).setFilesToValidate(filesToValidate);
    // Validation run 1...nothing cached yet
    myService.validateSources(request);
    verify(sessionCache, Mockito.times(1)).cacheSession(ArgumentMatchers.any(ValidationEngine.class));
    verify(sessionCache, Mockito.times(1)).cleanUp();
    verify(myService, Mockito.times(1)).buildValidationEngine(any(), any(), any(), any());
    Set<String> sessionIds = sessionCache.getSessionIds();
    if (sessionIds.stream().findFirst().isPresent()) {
      // Verify that after 1 run there is only one entry within the cache
      assertEquals(1, sessionIds.size());
      myService.validateSources(request.setSessionId(sessionIds.stream().findFirst().get()));
      // Verify that the cache has been called on twice with the id created in the first run
      verify(sessionCache, Mockito.times(2)).fetchSessionValidatorEngine(sessionIds.stream().findFirst().get());
      verify(sessionCache, Mockito.times(1)).cleanUp();
      verify(myService, Mockito.times(1)).buildValidationEngine(any(), any(), any(), any());
    } else {
      // If no sessions exist within the cache after a run, we auto-fail.
      fail();
    }
  }

  @DisplayName("Test validation session will inherit a base validation engine")
  @Test
  void validationSessionBaseEngineTest() throws Exception {
    TestingUtilities.injectCorePackageLoader();

    ValidationService myService = Mockito.spy(new ValidationService());

    ValidationEngineParameters baseContext = new ValidationEngineParameters().setBaseEngine("myDummyKey").setSv("4.0.1").setTxServer(FhirSettings.getTxFhirDevelopment()).setTxCache(getTerminologyCacheDirectory("validationService"));
    myService.putBaseEngine("myDummyKey", baseContext, null);
    verify(myService, Mockito.times(1)).buildValidationEngine(any(), any(), any(), any());

    {
      final List<FileInfo> filesToValidate = getFilesToValidate();
      final ValidationRequest request = new ValidationRequest().setValidationEngineParameters(new ValidationEngineParameters().setSv("4.0.1")).setFilesToValidate(filesToValidate);
      myService.validateSources(request);

      verify(myService, Mockito.times(0)).getBaseEngine("myDummyKey");
      verify(myService, Mockito.times(2)).buildValidationEngine(any(), any(), any(), any());
    }

    {
      final List<FileInfo> filesToValidate = getFilesToValidate();
      final ValidationRequest request = new ValidationRequest().setValidationEngineParameters(new ValidationEngineParameters().setBaseEngine("myDummyKey")).setFilesToValidate(filesToValidate);
      myService.validateSources(request);

      verify(myService, Mockito.times(1)).getBaseEngine("myDummyKey");
      verify(myService, Mockito.times(2)).buildValidationEngine(any(), any(), any(), any());
    }
  }

  private List<FileInfo> getFilesToValidate() throws IOException {
    List<FileInfo> filesToValidate = new ArrayList<>();
    String resource = IOUtils.toString(getFileFromResourceAsStream("detected_issues.json"), StandardCharsets.UTF_8);

    filesToValidate.add(new FileInfo().setFileName("test_resource.json").setFileContent(resource).setFileType(Manager.FhirFormat.JSON.getExtension()));
  return filesToValidate;
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

    validationService.convertSources(validationEngine, SINGLE_SOURCE_LIST, DUMMY_OUTPUT, null);

    verify(validationEngine).convert(DUMMY_SOURCE, DUMMY_OUTPUT);
  }

  @Test
  @DisplayName("Test that conversion throws an Exception when no -output or -outputSuffix params are set")
  public void convertSingleSourceNoOutput() {
    SessionCache sessionCache = mock(SessionCache.class);
    ValidationService validationService = new ValidationService(sessionCache);
    ValidationEngine validationEngine = mock(ValidationEngine.class);

    assertThrows( Exception.class, () -> validationService.convertSources(validationEngine, SINGLE_SOURCE_LIST,  null, null));
  }



  @Test
  @DisplayName("Test that conversion throws an Exception when multiple sources are set and an -output param is set")
  public void convertMultipleSourceOnlyOutput() {
    SessionCache sessionCache = mock(SessionCache.class);
    ValidationService validationService = new ValidationService(sessionCache);
    ValidationEngine validationEngine = mock(ValidationEngine.class);

    assertThrows( Exception.class, () -> validationService.convertSources(validationEngine, MULTIPLE_SOURCE_LIST, null, null)
    );
  }

  @Test
  @DisplayName("Test that conversion works when multiple sources are set and an output suffix parameter is set")
  public void convertMultipleSource() throws Exception {
    SessionCache sessionCache = mock(SessionCache.class);
    ValidationService validationService = new ValidationService(sessionCache);
    ValidationEngine validationEngine = mock(ValidationEngine.class);

    validationService.convertSources(validationEngine, MULTIPLE_SOURCE_LIST, null, DUMMY_OUTPUT);
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

    validationService.generateSnapshot(validationEngine, new GenerateSnapshotParameters(DUMMY_SV, SINGLE_SOURCE_LIST, DUMMY_OUTPUT, null));

    verify(validationEngine).snapshot(DUMMY_SOURCE, DUMMY_SV);
    verify(validationEngine).handleOutput(structureDefinition, DUMMY_OUTPUT, DUMMY_SV);
  }

  @Test
  @DisplayName("Test that snapshot generation throws an Exception when no -output or -outputSuffix params are set")
  public void generateSnapshotSingleSourceNoOutput() {
    SessionCache sessionCache = mock(SessionCache.class);
    ValidationService validationService = new ValidationService(sessionCache);
    ValidationEngine validationEngine = mock(ValidationEngine.class);

    assertThrows( Exception.class, () -> validationService.generateSnapshot(validationEngine, new GenerateSnapshotParameters(DUMMY_SV, SINGLE_SOURCE_LIST, null, null)));
  }

  @Test
  @DisplayName("Test that snapshot generation throws an Exception when multiple sources are set and an -output param is set")
  public void generateSnapshotMultipleSourceOnlyOutput() {
    SessionCache sessionCache = mock(SessionCache.class);
    ValidationService validationService = new ValidationService(sessionCache);
    ValidationEngine validationEngine = mock(ValidationEngine.class);

    assertThrows( Exception.class, () -> validationService.generateSnapshot(validationEngine, new GenerateSnapshotParameters(DUMMY_SV, MULTIPLE_SOURCE_LIST, DUMMY_OUTPUT, null))
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


    validationService.generateSnapshot(validationEngine, new GenerateSnapshotParameters(DUMMY_SV, MULTIPLE_SOURCE_LIST, null, DUMMY_OUTPUT));
    verify(validationEngine).snapshot(DUMMY_SOURCE1, DUMMY_SV);
    verify(validationEngine).handleOutput(eq(structureDefinition1), and(startsWith(DUMMY_SOURCE1),endsWith(DUMMY_OUTPUT)), eq(DUMMY_SV));
    verify(validationEngine).snapshot(DUMMY_SOURCE2, DUMMY_SV);
    verify(validationEngine).handleOutput(eq(structureDefinition2), and(startsWith(DUMMY_SOURCE2), endsWith(DUMMY_OUTPUT)), eq(DUMMY_SV));
    verify(validationEngine).snapshot(DUMMY_SOURCE3, DUMMY_SV);
    verify(validationEngine).handleOutput(eq(structureDefinition3), and(startsWith(DUMMY_SOURCE3), endsWith(DUMMY_OUTPUT)), eq(DUMMY_SV));

  }

  private final List<String> SINGLE_SOURCE_LIST = List.of(DUMMY_SOURCE);

  private final List<String> MULTIPLE_SOURCE_LIST = List.of(DUMMY_SOURCE1, DUMMY_SOURCE2, DUMMY_SOURCE3);


  /*  This is a particularly long way to test that fields in ValidationEngine are
      set to expected default values.

      It also provides example code to test other parts of the buildValidationEngine method as well.
  */
  @Test
  public void buildValidationEngineTest() throws IOException, URISyntaxException {
    final TimeTracker timeTracker = mock(TimeTracker.class);
    final SimpleWorkerContext workerContext = mock(SimpleWorkerContext.class);

    final ValidationEngine mockValidationEngine = mock(ValidationEngine.class);
    when(mockValidationEngine.getContext()).thenReturn(workerContext);
    when(mockValidationEngine.getPolicyAdvisor()).thenReturn(mock(IValidationPolicyAdvisor.class));

    final ValidationEngine.ValidationEngineBuilder mockValidationEngineBuilder = mock(ValidationEngine.ValidationEngineBuilder.class);
    final ValidationService validationService = createFakeValidationService(mockValidationEngineBuilder, mockValidationEngine);

    ValidationEngineParameters validationEngineParameters = new ValidationEngineParameters();
    InstanceValidatorParameters instanceValidatorParameters = new InstanceValidatorParameters();
    validationService.buildValidationEngine(validationEngineParameters, instanceValidatorParameters, null, timeTracker);

    verify(mockValidationEngine).setFetcher(notNull());
    verify(mockValidationEngineBuilder).withUserAgent(eq("fhir/validator/" + VersionUtil.getVersion()));
  }

  @Test
  public void buildValidationEngineDisableDefaultResourceFetcherTest() throws IOException, URISyntaxException {
    final TimeTracker timeTracker = mock(TimeTracker.class);
    final SimpleWorkerContext workerContext = mock(SimpleWorkerContext.class);

    final ValidationEngine mockValidationEngine = mock(ValidationEngine.class);
    when(mockValidationEngine.getContext()).thenReturn(workerContext);
    when(mockValidationEngine.getPolicyAdvisor()).thenReturn(mock(IValidationPolicyAdvisor.class));
    final ValidationEngine.ValidationEngineBuilder mockValidationEngineBuilder = mock(ValidationEngine.ValidationEngineBuilder.class);
    final ValidationService validationService = createFakeValidationService(mockValidationEngineBuilder, mockValidationEngine);

    ValidationEngineParameters validationEngineParameters = new ValidationEngineParameters();
    InstanceValidatorParameters instanceValidatorParameters = new InstanceValidatorParameters();

    validationEngineParameters.setDisableDefaultResourceFetcher(true);
    validationService.buildValidationEngine(validationEngineParameters, instanceValidatorParameters, null, timeTracker);

    verify(mockValidationEngine, never()).setFetcher(any());
    verify(mockValidationEngineBuilder).withUserAgent(eq("fhir/validator/" + VersionUtil.getVersion()));
  }

  private static ValidationService createFakeValidationService(ValidationEngine.ValidationEngineBuilder validationEngineBuilder, ValidationEngine validationEngine) {
    return new ValidationService() {
      @Override
      protected ValidationEngine.ValidationEngineBuilder getValidationEngineBuilder() {
        when(validationEngineBuilder.withDefaultInstanceValidatorParameters(any(InstanceValidatorParameters.class))).thenReturn(validationEngineBuilder);
        when(validationEngineBuilder.withThoVersion(anyString())).thenReturn(validationEngineBuilder);
        when(validationEngineBuilder.withVersion(isNull())).thenReturn(validationEngineBuilder);
        when(validationEngineBuilder.withTimeTracker(any())).thenReturn(validationEngineBuilder);
        when(validationEngineBuilder.withUserAgent(anyString())).thenReturn(validationEngineBuilder);
        when(validationEngineBuilder.withExtensionsVersion(anyString())).thenReturn(validationEngineBuilder);
        try {
          when(validationEngineBuilder.fromSource(isNull())).thenReturn(validationEngine);
        } catch (IOException | URISyntaxException e) {
          throw new RuntimeException(e);
        }
        return validationEngineBuilder;
      }

      @Override
      protected void loadIgsAndExtensions(ValidationEngine validationEngine, List<String> igs, boolean isRecursive) {
        //Don't care. Do nothing.
      }
    };
  }


}