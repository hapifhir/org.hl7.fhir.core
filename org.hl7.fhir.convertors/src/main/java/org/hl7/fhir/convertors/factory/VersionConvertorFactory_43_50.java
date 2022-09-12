package org.hl7.fhir.convertors.factory;

import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_43_50;
import org.hl7.fhir.convertors.conv43_50.VersionConvertor_43_50;
import org.hl7.fhir.exceptions.FHIRException;

public final class VersionConvertorFactory_43_50 extends VersionConvertorFactory {

  public static org.hl7.fhir.r5.model.Resource convertResource(org.hl7.fhir.r4b.model.Resource src) throws FHIRException {
    return convertResource(src, new BaseAdvisor_43_50());
  }

  public static org.hl7.fhir.r5.model.Resource convertResource(org.hl7.fhir.r4b.model.Resource src, BaseAdvisor_43_50 advisor) throws FHIRException {
    cleanInputs(src, advisor);
    return src != null ? new VersionConvertor_43_50(advisor).convertResource(src) : null;
  }

  public static org.hl7.fhir.r4b.model.Resource convertResource(org.hl7.fhir.r5.model.Resource src) throws FHIRException {
    return convertResource(src, new BaseAdvisor_43_50());
  }

  public static org.hl7.fhir.r4b.model.Resource convertResource(org.hl7.fhir.r5.model.Resource src, BaseAdvisor_43_50 advisor) throws FHIRException {
    cleanInputs(src, advisor);
    return src != null ? new VersionConvertor_43_50(advisor).convertResource(src) : null;
  }

  public static org.hl7.fhir.r5.model.DataType convertType(org.hl7.fhir.r4b.model.DataType src) throws FHIRException {
    return convertType(src, new BaseAdvisor_43_50());
  }

  public static org.hl7.fhir.r5.model.DataType convertType(org.hl7.fhir.r4b.model.DataType src, BaseAdvisor_43_50 advisor) throws FHIRException {
    cleanInputs(src, advisor);
    return src != null ? new VersionConvertor_43_50(advisor).convertType(src) : null;
  }

  public static org.hl7.fhir.r4b.model.DataType convertType(org.hl7.fhir.r5.model.DataType src) throws FHIRException {
    return convertType(src, new BaseAdvisor_43_50());
  }

  public static org.hl7.fhir.r4b.model.DataType convertType(org.hl7.fhir.r5.model.DataType src, BaseAdvisor_43_50 advisor) throws FHIRException {
    cleanInputs(src, advisor);
    return src != null ? new VersionConvertor_43_50(advisor).convertType(src) : null;
  }
}