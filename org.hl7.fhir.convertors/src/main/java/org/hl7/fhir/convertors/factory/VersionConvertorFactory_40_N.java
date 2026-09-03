package org.hl7.fhir.convertors.factory;

import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_40_N;
import org.hl7.fhir.convertors.conv40_N.VersionConvertor_40_N;
import org.hl7.fhir.exceptions.FHIRException;

public final class VersionConvertorFactory_40_N extends VersionConvertorFactory {

  public static org.hl7.fhir.model.core.Resource convertResource(org.hl7.fhir.r4.model.Resource src) throws FHIRException {
    return convertResource(src, new BaseAdvisor_40_N());
  }

  public static org.hl7.fhir.model.core.Resource convertResource(org.hl7.fhir.r4.model.Resource src, BaseAdvisor_40_N advisor) throws FHIRException {
    cleanInputs(src, advisor);
    return src != null ? new VersionConvertor_40_N(advisor).convertResource(src) : null;
  }

  public static org.hl7.fhir.r4.model.Resource convertResource(org.hl7.fhir.model.core.Resource src) throws FHIRException {
    return convertResource(src, new BaseAdvisor_40_N());
  }

  public static org.hl7.fhir.r4.model.Resource convertResource(org.hl7.fhir.model.core.Resource src, BaseAdvisor_40_N advisor) throws FHIRException {
    cleanInputs(src, advisor);
    return src != null ? new VersionConvertor_40_N(advisor).convertResource(src) : null;
  }

  public static org.hl7.fhir.model.core.DataType convertType(org.hl7.fhir.r4.model.Type src) throws FHIRException {
    return convertType(src, new BaseAdvisor_40_N());
  }

  public static org.hl7.fhir.model.core.DataType convertType(org.hl7.fhir.r4.model.Type src, BaseAdvisor_40_N advisor) throws FHIRException {
    cleanInputs(src, advisor);
    return src != null ? new VersionConvertor_40_N(advisor).convertType(src) : null;
  }

  public static org.hl7.fhir.r4.model.Type convertType(org.hl7.fhir.model.core.DataType src) throws FHIRException {
    return convertType(src, new BaseAdvisor_40_N());
  }

  public static org.hl7.fhir.r4.model.Type convertType(org.hl7.fhir.model.core.DataType src, BaseAdvisor_40_N advisor) throws FHIRException {
    cleanInputs(src, advisor);
    return src != null ? new VersionConvertor_40_N(advisor).convertType(src) : null;
  }
}