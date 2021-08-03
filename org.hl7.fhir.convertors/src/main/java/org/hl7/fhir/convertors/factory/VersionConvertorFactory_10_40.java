package org.hl7.fhir.convertors.factory;

import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_10_40;
import org.hl7.fhir.convertors.conv10_40.VersionConvertor_10_40;
import org.hl7.fhir.exceptions.FHIRException;

public final class VersionConvertorFactory_10_40 {

  public static org.hl7.fhir.r4.model.Resource convertResource(org.hl7.fhir.dstu2.model.Resource src) throws FHIRException {
    return convertResource(src, new BaseAdvisor_10_40());
  }

  public static org.hl7.fhir.r4.model.Resource convertResource(org.hl7.fhir.dstu2.model.Resource src, BaseAdvisor_10_40 advisor) throws FHIRException {
    return new VersionConvertor_10_40(advisor).convertResource(src);
  }

  public static org.hl7.fhir.dstu2.model.Resource convertResource(org.hl7.fhir.r4.model.Resource src) throws FHIRException {
    return convertResource(src, new BaseAdvisor_10_40());
  }

  public static org.hl7.fhir.dstu2.model.Resource convertResource(org.hl7.fhir.r4.model.Resource src, BaseAdvisor_10_40 advisor) throws FHIRException {
    return new VersionConvertor_10_40(advisor).convertResource(src);
  }

  public static org.hl7.fhir.r4.model.Type convertType(org.hl7.fhir.dstu2.model.Type src) throws FHIRException {
    return convertType(src, new BaseAdvisor_10_40());
  }

  public static org.hl7.fhir.r4.model.Type convertType(org.hl7.fhir.dstu2.model.Type src, BaseAdvisor_10_40 advisor) throws FHIRException {
    return new VersionConvertor_10_40(advisor).convertType(src);
  }

  public static org.hl7.fhir.dstu2.model.Type convertType(org.hl7.fhir.r4.model.Type src) throws FHIRException {
    return convertType(src, new BaseAdvisor_10_40());
  }

  public static org.hl7.fhir.dstu2.model.Type convertType(org.hl7.fhir.r4.model.Type src, BaseAdvisor_10_40 advisor) throws FHIRException {
    return new VersionConvertor_10_40(advisor).convertType(src);
  }
}