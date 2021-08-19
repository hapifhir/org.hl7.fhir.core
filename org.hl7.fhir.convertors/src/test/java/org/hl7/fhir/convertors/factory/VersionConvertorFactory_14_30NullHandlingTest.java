package org.hl7.fhir.convertors.factory;

import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_14_30;
import org.hl7.fhir.exceptions.FHIRException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class VersionConvertorFactory_14_30NullHandlingTest {

  @Test
  @DisplayName("Check null DSTU2016MAY resource with default advisor throws FHIRException.")
  void convertResourceWithDefaultAdvisorDSTU2016MAY() {
    Assertions.assertThrows(FHIRException.class, () -> {
      VersionConvertorFactory_14_30.convertResource((org.hl7.fhir.dstu2016may.model.Resource) null);
    });
  }

  @Test
  @DisplayName("Check null DSTU2016MAY resource with custom advisor throws FHIRException when advisor is set to fail fast.")
  void convertResourceWithCustomAdvisorSetToFailFastDSTU2016MAY() {
    Assertions.assertThrows(FHIRException.class, () -> {
      VersionConvertorFactory_14_30.convertResource((org.hl7.fhir.dstu2016may.model.Resource) null, new BaseAdvisor_14_30(true));
    });
  }

  @Test
  @DisplayName("Check null DSTU2016MAY resource with custom advisor returns null when advisor set to not fail fast.")
  void convertResourceWithCustomAdvisorSetToNotFailFastDSTU2016MAY() {
    Assertions.assertNull(VersionConvertorFactory_14_30.convertResource((org.hl7.fhir.dstu2016may.model.Resource) null,
      new BaseAdvisor_14_30(false)));
  }

  @Test
  @DisplayName("Check null DSTU3 resource with default advisor throws FHIRException.")
  void convertResourceWithDefaultAdvisorDSTU3() {
    Assertions.assertThrows(FHIRException.class, () -> {
      VersionConvertorFactory_14_30.convertResource((org.hl7.fhir.dstu3.model.Resource) null);
    });
  }

  @Test
  @DisplayName("Check null DSTU3 resource with custom advisor throws FHIRException when advisor is set to fail fast.")
  void convertResourceWithCustomAdvisorSetToFailFastDSTU3() {
    Assertions.assertThrows(FHIRException.class, () -> {
      VersionConvertorFactory_14_30.convertResource((org.hl7.fhir.dstu3.model.Resource) null, new BaseAdvisor_14_30(true));
    });
  }

  @Test
  @DisplayName("Check null DSTU3 resource with custom advisor returns null when advisor set to not fail fast.")
  void convertResourceWithCustomAdvisorSetToNotFailFastDSTU3() {
    Assertions.assertNull(VersionConvertorFactory_14_30.convertResource((org.hl7.fhir.dstu3.model.Resource) null,
      new BaseAdvisor_14_30(false)));
  }

  @Test
  @DisplayName("Check null DSTU2016MAY type with default advisor throws FHIRException.")
  void convertTypeWithDefaultAdvisorDSTU2016MAY() {
    Assertions.assertThrows(FHIRException.class, () -> {
      VersionConvertorFactory_14_30.convertType((org.hl7.fhir.dstu2016may.model.Type) null);
    });
  }

  @Test
  @DisplayName("Check null DSTU2016MAY type with custom advisor throws FHIRException when advisor is set to fail fast.")
  void convertTypeWithCustomAdvisorSetToFailFastDSTU2016MAY() {
    Assertions.assertThrows(FHIRException.class, () -> {
      VersionConvertorFactory_14_30.convertType((org.hl7.fhir.dstu2016may.model.Type) null, new BaseAdvisor_14_30(true));
    });
  }

  @Test
  @DisplayName("Check null DSTU2016MAY type with custom advisor returns null when advisor set to not fail fast.")
  void convertTypeWithCustomAdvisorSetToNotFailFastDSTU2016MAY() {
    Assertions.assertNull(VersionConvertorFactory_14_30.convertType((org.hl7.fhir.dstu2016may.model.Type) null,
      new BaseAdvisor_14_30(false)));
  }

  @Test
  @DisplayName("Check null DSTU3 type with default advisor throws FHIRException.")
  void convertTypeWithDefaultAdvisorDSTU3() {
    Assertions.assertThrows(FHIRException.class, () -> {
      VersionConvertorFactory_14_30.convertType((org.hl7.fhir.dstu3.model.Type) null);
    });
  }

  @Test
  @DisplayName("Check null DSTU3 type with custom advisor throws FHIRException when advisor is set to fail fast.")
  void convertTypeWithCustomAdvisorSetToFailFastDSTU3() {
    Assertions.assertThrows(FHIRException.class, () -> {
      VersionConvertorFactory_14_30.convertType((org.hl7.fhir.dstu3.model.Type) null, new BaseAdvisor_14_30(true));
    });
  }

  @Test
  @DisplayName("Check null DSTU3 type with custom advisor returns null when advisor set to not fail fast.")
  void convertTypeWithCustomAdvisorSetToNotFailFastDSTU3() {
    Assertions.assertNull(VersionConvertorFactory_14_30.convertType((org.hl7.fhir.dstu3.model.Type) null,
      new BaseAdvisor_14_30(false)));
  }

}