package org.hl7.fhir.convertors.factory;

import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_40_50;
import org.hl7.fhir.convertors.conv40_50.VersionConvertor_40_50;
import org.hl7.fhir.exceptions.FHIRException;

public final class VersionConvertorFactory_40_50 extends VersionConvertorFactory {

  public static org.hl7.fhir.r5.model.Resource convertResource(org.hl7.fhir.r4.model.Resource src) throws FHIRException {
    return convertResource(src, new BaseAdvisor_40_50());
  }

  public static org.hl7.fhir.r5.model.Resource convertResource(org.hl7.fhir.r4.model.Resource src, BaseAdvisor_40_50 advisor) throws FHIRException {
    cleanInputs(src, advisor);
    return src != null ? new VersionConvertor_40_50(advisor).convertResource(src) : null;
  }

  public static org.hl7.fhir.r4.model.Resource convertResource(org.hl7.fhir.r5.model.Resource src) throws FHIRException {
    return convertResource(src, new BaseAdvisor_40_50());
  }

  public static org.hl7.fhir.r4.model.Resource convertResource(org.hl7.fhir.r5.model.Resource src, BaseAdvisor_40_50 advisor) throws FHIRException {
    cleanInputs(src, advisor);
    return src != null ? new VersionConvertor_40_50(advisor).convertResource(src) : null;
  }

  public static org.hl7.fhir.r5.model.DataType convertType(org.hl7.fhir.r4.model.Type src) throws FHIRException {
    return convertType(src, new BaseAdvisor_40_50());
  }

  public static org.hl7.fhir.r5.model.DataType convertType(org.hl7.fhir.r4.model.Type src, BaseAdvisor_40_50 advisor) throws FHIRException {
    cleanInputs(src, advisor);
    return src != null ? new VersionConvertor_40_50(advisor).convertType(src) : null;
  }

  public static org.hl7.fhir.r4.model.Type convertType(org.hl7.fhir.r5.model.DataType src) throws FHIRException {
    return convertType(src, new BaseAdvisor_40_50());
  }

  public static org.hl7.fhir.r4.model.Type convertType(org.hl7.fhir.r5.model.DataType src, BaseAdvisor_40_50 advisor) throws FHIRException {
    cleanInputs(src, advisor);
    return src != null ? new VersionConvertor_40_50(advisor).convertType(src) : null;
  }
}