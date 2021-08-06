package org.hl7.fhir.convertors.conv14_40.datatypes14_40.primitivetypes14_40;

import org.hl7.fhir.convertors.context.ConversionContext14_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Uuid14_40 {
  public static org.hl7.fhir.r4.model.UuidType convertUuid(org.hl7.fhir.dstu2016may.model.UuidType src) throws FHIRException {
    org.hl7.fhir.r4.model.UuidType tgt = new org.hl7.fhir.r4.model.UuidType();
    if (src.hasValue()) tgt.setValue(src.getValue());
    ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.UuidType convertUuid(org.hl7.fhir.r4.model.UuidType src) throws FHIRException {
    org.hl7.fhir.dstu2016may.model.UuidType tgt = new org.hl7.fhir.dstu2016may.model.UuidType();
    if (src.hasValue()) tgt.setValue(src.getValue());
    ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
    return tgt;
  }
}
