package org.hl7.fhir.validation.cli.tasks;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mockConstruction;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.utilities.TimeTracker;
import org.hl7.fhir.validation.cli.param.Arg;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.service.ValidationService;
import org.hl7.fhir.validation.service.model.InstanceValidatorParameters;
import org.hl7.fhir.validation.service.model.ValidationEngineParameters;
import org.hl7.fhir.validation.special.PackageReGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedConstruction;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class RePackageTaskTests {

  @Mock
  ValidationService validationService;

  @Mock
  ValidationEngine validationEngine;

  @BeforeEach
  void setUp() throws Exception {
    //when(validationService.determineVersion(anyList(), anyList(), anyBoolean(), anyBoolean())).thenReturn("5.0.1");
    //when(validationService.initializeValidator(any(ValidationEngineParameters.class), any(InstanceValidatorParameters.class), anyString(), any(TimeTracker.class), anyList())).thenReturn(validationEngine);
  }

  @Test
  void usesRepackageParametersPackages() throws Exception {

    // Move the following two statements to a beforeEach if using Mocking is preferred
    when(validationService.determineVersion(anyList(), anyList(), anyBoolean(), anyBoolean())).thenReturn("5.0.1");
    when(validationService.initializeValidator(any(ValidationEngineParameters.class), any(InstanceValidatorParameters.class), anyString(), any(TimeTracker.class), anyList())).thenReturn(validationEngine);

    String[] args = new String[]{"-re-package", "some.package#1.2.3",
      "-scope igs", "-mode cnt",
      "-mode tx", "-mode api",
      "-output", "/tmp/uuu/temp/out.tgz",
      "-ignore-list", "urn:ietf:bcp:47,urn:iso:std:iso:3166",
      "-include-conforms-to true",
      "-package-name", "some.repackage#1.2.3-patch"};

    try (MockedConstruction<PackageReGenerator> construction = mockConstruction(PackageReGenerator.class, (mock, context) -> {
      when(mock.setContext(any())).thenReturn(mock);
      when(mock.setOutput(anyString())).thenReturn(mock);
      when(mock.setOutputType(any())).thenReturn(mock);
      when(mock.setJson(anyBoolean())).thenReturn(mock);
      when(mock.setModes(any())).thenReturn(mock);
      when(mock.setNpmId(anyString())).thenReturn(mock);
      when(mock.addPackages(any())).thenReturn(mock);
      when(mock.setScope(any())).thenReturn(mock);
      when(mock.setIgnoreList(any())).thenReturn(mock);
      when(mock.setIncludeList(any())).thenReturn(mock);
      when(mock.setIncludeConformsTo(anyBoolean())).thenReturn(mock);
    })) {
      new RePackageTask().executeTask(validationService, args);

      assertThat(construction.constructed()).hasSize(1);
      PackageReGenerator packageReGenerator = construction.constructed().get(0);
      verify(packageReGenerator).addPackages(eq(List.of("some.package#1.2.3")));
    }
  }

  @Test
  void usesTxPackPackagesWithoutMockingFrameworks() throws Exception {
    String[] args = new String[]{"-re-package", "some.package#1.2.3",
      "-scope igs", "-mode cnt",
      "-mode tx", "-mode api",
      "-output", "/tmp/uuu/temp/out.tgz",
      "-ignore-list", "urn:ietf:bcp:47,urn:iso:std:iso:3166",
      "-include-conforms-to true",
      "-package-name", "some.repackage#1.2.3-patch"};

    RecordingRePackageTask task = new RecordingRePackageTask();
    RePackageTask.ValidationEngineTaskInstance instance = task.getValidationEngineTaskInstance(Arg.of(args));

    instance.executeTask(new ValidationService(), createMinimalValidationEngine());

    assertThat(task.getRecordingGenerator().getRecordedPackages())
      .containsExactly("some.package#1.2.3");
  }

  private ValidationEngine createMinimalValidationEngine() throws Exception {
    Constructor<ValidationEngine> ctor = ValidationEngine.class.getDeclaredConstructor(InstanceValidatorParameters.class);
    ctor.setAccessible(true);
    return ctor.newInstance(new InstanceValidatorParameters());
  }

  private static class RecordingRePackageTask extends RePackageTask {
    private RecordingPackageReGenerator recordingGenerator;

    @Override
    protected PackageReGenerator createPackageReGenerator() {
      recordingGenerator = new RecordingPackageReGenerator();
      return recordingGenerator;
    }

    RecordingPackageReGenerator getRecordingGenerator() {
      return recordingGenerator;
    }
  }

  private static class RecordingPackageReGenerator extends PackageReGenerator {
    private final List<String> recordedPackages = new ArrayList<>();

    @Override
    public PackageReGenerator setContext(org.hl7.fhir.r5.context.IWorkerContext context) {
      return this;
    }

    @Override
    public PackageReGenerator setOutput(String output) {
      return this;
    }

    @Override
    public PackageReGenerator setOutputType(ExpansionPackageGeneratorOutputType outputType) {
      return this;
    }

    @Override
    public PackageReGenerator setJson(boolean json) {
      return this;
    }

    @Override
    public PackageReGenerator setModes(java.util.Set<String> modeParams) {
      return this;
    }

    @Override
    public PackageReGenerator setNpmId(String npmId) {
      return this;
    }

    @Override
    public PackageReGenerator addPackages(List<String> packageIds) {
      recordedPackages.addAll(packageIds);
      return this;
    }

    @Override
    public PackageReGenerator setScope(ExpansionPackageGeneratorScope scope) {
      return this;
    }

    @Override
    public PackageReGenerator setIgnoreList(List<String> ignoreList) {
      return this;
    }

    @Override
    public PackageReGenerator setIncludeList(List<org.hl7.fhir.r5.model.CanonicalResource> includeList) {
      return this;
    }

    @Override
    public PackageReGenerator setIncludeConformsTo(boolean includeConformsTo) {
      return this;
    }

    @Override
    public void generateExpansionPackage() {
      // Intentionally empty for test isolation
    }

    List<String> getRecordedPackages() {
      return recordedPackages;
    }
  }
}
