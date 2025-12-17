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

import java.util.List;

import org.hl7.fhir.utilities.TimeTracker;
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
    when(validationService.determineVersion(anyList(), anyList(), anyBoolean(), anyBoolean())).thenReturn("5.0.1");
    when(validationService.initializeValidator(any(ValidationEngineParameters.class), any(InstanceValidatorParameters.class), anyString(), any(TimeTracker.class), anyList())).thenReturn(validationEngine);
  }

  @Test
  void usesRepackageParametersPackages() throws Exception {

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
}
