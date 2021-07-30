package org.hl7.fhir.convertors.factory;

import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_10_50;
import org.hl7.fhir.convertors.conv10_50.VersionConvertor_10_50;
import org.hl7.fhir.exceptions.FHIRException;

public final class VersionConvertorFactory_10_50 {

  public static org.hl7.fhir.r5.model.Resource convertResource(org.hl7.fhir.dstu2.model.Resource src) throws FHIRException {
    return convertResource(src, new BaseAdvisor_10_50());
  }

  public static org.hl7.fhir.r5.model.Resource convertResource(org.hl7.fhir.dstu2.model.Resource src, BaseAdvisor_10_50 advisor) throws FHIRException {
    return new VersionConvertor_10_50(advisor).convertResource(src);
  }

  public static org.hl7.fhir.dstu2.model.Resource convertResource(org.hl7.fhir.r5.model.Resource src) throws FHIRException {
    return convertResource(src, new BaseAdvisor_10_50());
  }

  public static org.hl7.fhir.dstu2.model.Resource convertResource(org.hl7.fhir.r5.model.Resource src, BaseAdvisor_10_50 advisor) throws FHIRException {
    return new VersionConvertor_10_50(advisor).convertResource(src);
  }

  public static org.hl7.fhir.r5.model.DataType convertType(org.hl7.fhir.dstu2.model.Type src) throws FHIRException {
    return convertType(src, new BaseAdvisor_10_50());
  }

  public static org.hl7.fhir.r5.model.DataType convertType(org.hl7.fhir.dstu2.model.Type src, BaseAdvisor_10_50 advisor) throws FHIRException {
    return new VersionConvertor_10_50(advisor).convertType(src);
  }

  public static org.hl7.fhir.dstu2.model.Type convertType(org.hl7.fhir.r5.model.DataType src) throws FHIRException {
    return convertType(src, new BaseAdvisor_10_50());
  }

  public static org.hl7.fhir.dstu2.model.Type convertType(org.hl7.fhir.r5.model.DataType src, BaseAdvisor_10_50 advisor) throws FHIRException {
    return new VersionConvertor_10_50(advisor).convertType(src);
  }
}