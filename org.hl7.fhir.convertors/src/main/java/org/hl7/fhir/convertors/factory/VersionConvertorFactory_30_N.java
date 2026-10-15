package org.hl7.fhir.convertors.factory;

import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_30_50;
import org.hl7.fhir.convertors.conv30_50.VersionConvertor_30_50;
import org.hl7.fhir.exceptions.FHIRException;

public final class VersionConvertorFactory_30_N extends VersionConvertorFactory {

  public static org.hl7.fhir.model.core.Resource convertResource(org.hl7.fhir.dstu3.model.Resource src) throws FHIRException {
    return convertResource(src, new BaseAdvisor_30_50());
  }

  public static org.hl7.fhir.model.core.Resource convertResource(org.hl7.fhir.dstu3.model.Resource src, BaseAdvisor_30_50 advisor) throws FHIRException {
    cleanInputs(src, advisor);
    return src != null ? VersionConvertorFactory_50_N.convertResource(new VersionConvertor_30_50(advisor).convertResource(src)) : null;
  }

  public static org.hl7.fhir.dstu3.model.Resource convertResource(org.hl7.fhir.model.core.Resource src) throws FHIRException {
    return convertResource(src, new BaseAdvisor_30_50());
  }

  public static org.hl7.fhir.dstu3.model.Resource convertResource(org.hl7.fhir.model.core.Resource src, BaseAdvisor_30_50 advisor) throws FHIRException {
    cleanInputs(src, advisor);
    return src != null ? new VersionConvertor_30_50(advisor).convertResource(VersionConvertorFactory_50_N.convertResource(src)) : null;
  }

  public static org.hl7.fhir.model.core.DataType convertType(org.hl7.fhir.dstu3.model.Type src) throws FHIRException {
    return convertType(src, new BaseAdvisor_30_50());
  }

  public static org.hl7.fhir.model.core.DataType convertType(org.hl7.fhir.dstu3.model.Type src, BaseAdvisor_30_50 advisor) throws FHIRException {
    cleanInputs(src, advisor);
    return src != null ? VersionConvertorFactory_50_N.convertType(new VersionConvertor_30_50(advisor).convertType(src)) : null;
  }

  public static org.hl7.fhir.dstu3.model.Type convertType(org.hl7.fhir.model.core.DataType src) throws FHIRException {
    return convertType(src, new BaseAdvisor_30_50());
  }

  public static org.hl7.fhir.dstu3.model.Type convertType(org.hl7.fhir.model.core.DataType src, BaseAdvisor_30_50 advisor) throws FHIRException {
    cleanInputs(src, advisor);
    return src != null ? new VersionConvertor_30_50(advisor).convertType(VersionConvertorFactory_50_N.convertType(src)) : null;
  }
}