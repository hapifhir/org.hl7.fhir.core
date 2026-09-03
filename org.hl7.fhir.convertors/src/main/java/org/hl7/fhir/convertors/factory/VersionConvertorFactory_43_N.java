package org.hl7.fhir.convertors.factory;

import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_43_N;
import org.hl7.fhir.convertors.conv43_N.VersionConvertor_43_N;
import org.hl7.fhir.exceptions.FHIRException;

public final class VersionConvertorFactory_43_N extends VersionConvertorFactory {

  public static org.hl7.fhir.model.core.Resource convertResource(org.hl7.fhir.r4b.model.Resource src) throws FHIRException {
    return convertResource(src, new BaseAdvisor_43_N());
  }

  public static org.hl7.fhir.model.core.Resource convertResource(org.hl7.fhir.r4b.model.Resource src, BaseAdvisor_43_N advisor) throws FHIRException {
    cleanInputs(src, advisor);
    return src != null ? new VersionConvertor_43_N(advisor).convertResource(src) : null;
  }

  public static org.hl7.fhir.r4b.model.Resource convertResource(org.hl7.fhir.model.core.Resource src) throws FHIRException {
    return convertResource(src, new BaseAdvisor_43_N());
  }

  public static org.hl7.fhir.r4b.model.Resource convertResource(org.hl7.fhir.model.core.Resource src, BaseAdvisor_43_N advisor) throws FHIRException {
    cleanInputs(src, advisor);
    return src != null ? new VersionConvertor_43_N(advisor).convertResource(src) : null;
  }

  public static org.hl7.fhir.model.core.DataType convertType(org.hl7.fhir.r4b.model.DataType src) throws FHIRException {
    return convertType(src, new BaseAdvisor_43_N());
  }

  public static org.hl7.fhir.model.core.DataType convertType(org.hl7.fhir.r4b.model.DataType src, BaseAdvisor_43_N advisor) throws FHIRException {
    cleanInputs(src, advisor);
    return src != null ? new VersionConvertor_43_N(advisor).convertType(src) : null;
  }

  public static org.hl7.fhir.r4b.model.DataType convertType(org.hl7.fhir.model.core.DataType src) throws FHIRException {
    return convertType(src, new BaseAdvisor_43_N());
  }

  public static org.hl7.fhir.r4b.model.DataType convertType(org.hl7.fhir.model.core.DataType src, BaseAdvisor_43_N advisor) throws FHIRException {
    cleanInputs(src, advisor);
    return src != null ? new VersionConvertor_43_N(advisor).convertType(src) : null;
  }
}