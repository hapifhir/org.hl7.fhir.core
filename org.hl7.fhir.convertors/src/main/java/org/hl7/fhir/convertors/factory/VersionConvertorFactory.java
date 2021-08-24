package org.hl7.fhir.convertors.factory;

import org.hl7.fhir.convertors.advisors.interfaces.BaseAdvisor;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.instance.model.api.IBaseDatatype;
import org.hl7.fhir.instance.model.api.IBaseResource;

public abstract class VersionConvertorFactory {
  public static void cleanInputs(IBaseResource res, BaseAdvisor advisor) {
    checkDataAndAdvisor(res, advisor);
  }

  public static void cleanInputs(IBaseDatatype res, BaseAdvisor advisor) {
    checkDataAndAdvisor(res, advisor);
  }

  private static void checkDataAndAdvisor(Object o, BaseAdvisor advisor) {
    if (advisor == null) {
      throw new FHIRException("Null conversion advisor passed to factory method.");
    }
    if (advisor.failFastOnNullOrUnknownEntry() && o == null) {
      throw new FHIRException("ConversionFactory received null input. Conversion advisor set to failFastOnNullInput.");
    }
  }
}
