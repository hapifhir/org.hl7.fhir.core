package org.hl7.fhir.convertors.factory;

import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_10_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class VersionConvertorFactory_10_50NullHandlingTest {

  @Test
  @DisplayName("Check null DSTU2 resource with default advisor throws FHIRException.")
  void convertResourceWithDefaultAdvisorDSTU2() {
    Assertions.assertThrows(FHIRException.class, () -> {
      VersionConvertorFactory_10_50.convertResource((org.hl7.fhir.dstu2.model.Resource) null);
    });
  }

  @Test
  @DisplayName("Check null DSTU2 resource with custom advisor throws FHIRException when advisor is set to fail fast.")
  void convertResourceWithCustomAdvisorSetToFailFastDSTU2() {
    Assertions.assertThrows(FHIRException.class, () -> {
      VersionConvertorFactory_10_50.convertResource((org.hl7.fhir.dstu2.model.Resource) null, new BaseAdvisor_10_50(true));
    });
  }

  @Test
  @DisplayName("Check null DSTU2 resource with custom advisor returns null when advisor set to not fail fast.")
  void convertResourceWithCustomAdvisorSetToNotFailFastDSTU2() {
    Assertions.assertNull(VersionConvertorFactory_10_50.convertResource((org.hl7.fhir.dstu2.model.Resource) null,
      new BaseAdvisor_10_50(false)));
  }

  @Test
  @DisplayName("Check null R5 resource with default advisor throws FHIRException.")
  void convertResourceWithDefaultAdvisorR5() {
    Assertions.assertThrows(FHIRException.class, () -> {
      VersionConvertorFactory_10_50.convertResource((org.hl7.fhir.r5.model.Resource) null);
    });
  }

  @Test
  @DisplayName("Check null R5 resource with custom advisor throws FHIRException when advisor is set to fail fast.")
  void convertResourceWithCustomAdvisorSetToFailFastR5() {
    Assertions.assertThrows(FHIRException.class, () -> {
      VersionConvertorFactory_10_50.convertResource((org.hl7.fhir.r5.model.Resource) null, new BaseAdvisor_10_50(true));
    });
  }

  @Test
  @DisplayName("Check null R5 resource with custom advisor returns null when advisor set to not fail fast.")
  void convertResourceWithCustomAdvisorSetToNotFailFastR5() {
    Assertions.assertNull(VersionConvertorFactory_10_50.convertResource((org.hl7.fhir.r5.model.Resource) null,
      new BaseAdvisor_10_50(false)));
  }

  @Test
  @DisplayName("Check null DSTU2 type with default advisor throws FHIRException.")
  void convertTypeWithDefaultAdvisorDSTU2() {
    Assertions.assertThrows(FHIRException.class, () -> {
      VersionConvertorFactory_10_50.convertType((org.hl7.fhir.dstu2.model.Type) null);
    });
  }

  @Test
  @DisplayName("Check null DSTU2 type with custom advisor throws FHIRException when advisor is set to fail fast.")
  void convertTypeWithCustomAdvisorSetToFailFastDSTU2() {
    Assertions.assertThrows(FHIRException.class, () -> {
      VersionConvertorFactory_10_50.convertType((org.hl7.fhir.dstu2.model.Type) null, new BaseAdvisor_10_50(true));
    });
  }

  @Test
  @DisplayName("Check null DSTU2 type with custom advisor returns null when advisor set to not fail fast.")
  void convertTypeWithCustomAdvisorSetToNotFailFastDSTU2() {
    Assertions.assertNull(VersionConvertorFactory_10_50.convertType((org.hl7.fhir.dstu2.model.Type) null,
      new BaseAdvisor_10_50(false)));
  }

  @Test
  @DisplayName("Check null R5 type with default advisor throws FHIRException.")
  void convertTypeWithDefaultAdvisorR5() {
    Assertions.assertThrows(FHIRException.class, () -> {
      VersionConvertorFactory_10_50.convertType((org.hl7.fhir.r5.model.DataType) null);
    });
  }

  @Test
  @DisplayName("Check null R5 type with custom advisor throws FHIRException when advisor is set to fail fast.")
  void convertTypeWithCustomAdvisorSetToFailFastR5() {
    Assertions.assertThrows(FHIRException.class, () -> {
      VersionConvertorFactory_10_50.convertType((org.hl7.fhir.r5.model.DataType) null, new BaseAdvisor_10_50(true));
    });
  }

  @Test
  @DisplayName("Check null R5 type with custom advisor returns null when advisor set to not fail fast.")
  void convertTypeWithCustomAdvisorSetToNotFailFastR5() {
    Assertions.assertNull(VersionConvertorFactory_10_50.convertType((org.hl7.fhir.r5.model.DataType) null,
      new BaseAdvisor_10_50(false)));
  }

}