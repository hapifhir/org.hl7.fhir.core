package org.hl7.fhir.convertors.factory;

import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_14_40;
import org.hl7.fhir.exceptions.FHIRException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class VersionConvertorFactory_14_40NullHandlingTest {

  @Test
  @DisplayName("Check null DSTU2016MAY resource with default advisor throws FHIRException.")
  void convertResourceWithDefaultAdvisorDSTU2016MAY() {
    Assertions.assertThrows(FHIRException.class, () -> {
      VersionConvertorFactory_14_40.convertResource((org.hl7.fhir.dstu2016may.model.Resource) null);
    });
  }

  @Test
  @DisplayName("Check null DSTU2016MAY resource with custom advisor throws FHIRException when advisor is set to fail fast.")
  void convertResourceWithCustomAdvisorSetToFailFastDSTU2016MAY() {
    Assertions.assertThrows(FHIRException.class, () -> {
      VersionConvertorFactory_14_40.convertResource((org.hl7.fhir.dstu2016may.model.Resource) null, new BaseAdvisor_14_40(true));
    });
  }

  @Test
  @DisplayName("Check null DSTU2016MAY resource with custom advisor returns null when advisor set to not fail fast.")
  void convertResourceWithCustomAdvisorSetToNotFailFastDSTU2016MAY() {
    Assertions.assertNull(VersionConvertorFactory_14_40.convertResource((org.hl7.fhir.dstu2016may.model.Resource) null,
      new BaseAdvisor_14_40(false)));
  }

  @Test
  @DisplayName("Check null R4 resource with default advisor throws FHIRException.")
  void convertResourceWithDefaultAdvisorR4() {
    Assertions.assertThrows(FHIRException.class, () -> {
      VersionConvertorFactory_14_40.convertResource((org.hl7.fhir.r4.model.Resource) null);
    });
  }

  @Test
  @DisplayName("Check null R4 resource with custom advisor throws FHIRException when advisor is set to fail fast.")
  void convertResourceWithCustomAdvisorSetToFailFastR4() {
    Assertions.assertThrows(FHIRException.class, () -> {
      VersionConvertorFactory_14_40.convertResource((org.hl7.fhir.r4.model.Resource) null, new BaseAdvisor_14_40(true));
    });
  }

  @Test
  @DisplayName("Check null R4 resource with custom advisor returns null when advisor set to not fail fast.")
  void convertResourceWithCustomAdvisorSetToNotFailFastR4() {
    Assertions.assertNull(VersionConvertorFactory_14_40.convertResource((org.hl7.fhir.r4.model.Resource) null,
      new BaseAdvisor_14_40(false)));
  }

  @Test
  @DisplayName("Check null DSTU2016MAY type with default advisor throws FHIRException.")
  void convertTypeWithDefaultAdvisorDSTU2016MAY() {
    Assertions.assertThrows(FHIRException.class, () -> {
      VersionConvertorFactory_14_40.convertType((org.hl7.fhir.dstu2016may.model.Type) null);
    });
  }

  @Test
  @DisplayName("Check null DSTU2016MAY type with custom advisor throws FHIRException when advisor is set to fail fast.")
  void convertTypeWithCustomAdvisorSetToFailFastDSTU2016MAY() {
    Assertions.assertThrows(FHIRException.class, () -> {
      VersionConvertorFactory_14_40.convertType((org.hl7.fhir.dstu2016may.model.Type) null, new BaseAdvisor_14_40(true));
    });
  }

  @Test
  @DisplayName("Check null DSTU2016MAY type with custom advisor returns null when advisor set to not fail fast.")
  void convertTypeWithCustomAdvisorSetToNotFailFastDSTU2016MAY() {
    Assertions.assertNull(VersionConvertorFactory_14_40.convertType((org.hl7.fhir.dstu2016may.model.Type) null,
      new BaseAdvisor_14_40(false)));
  }

  @Test
  @DisplayName("Check null R4 type with default advisor throws FHIRException.")
  void convertTypeWithDefaultAdvisorR4() {
    Assertions.assertThrows(FHIRException.class, () -> {
      VersionConvertorFactory_14_40.convertType((org.hl7.fhir.r4.model.Type) null);
    });
  }

  @Test
  @DisplayName("Check null R4 type with custom advisor throws FHIRException when advisor is set to fail fast.")
  void convertTypeWithCustomAdvisorSetToFailFastR4() {
    Assertions.assertThrows(FHIRException.class, () -> {
      VersionConvertorFactory_14_40.convertType((org.hl7.fhir.r4.model.Type) null, new BaseAdvisor_14_40(true));
    });
  }

  @Test
  @DisplayName("Check null R4 type with custom advisor returns null when advisor set to not fail fast.")
  void convertTypeWithCustomAdvisorSetToNotFailFastR4() {
    Assertions.assertNull(VersionConvertorFactory_14_40.convertType((org.hl7.fhir.r4.model.Type) null,
      new BaseAdvisor_14_40(false)));
  }

}