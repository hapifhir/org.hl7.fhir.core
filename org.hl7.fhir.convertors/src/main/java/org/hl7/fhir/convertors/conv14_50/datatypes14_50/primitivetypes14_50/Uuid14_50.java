package org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50;

import org.hl7.fhir.convertors.conv14_50.datatypes14_50.Element14_50;
import org.hl7.fhir.exceptions.FHIRException; import org.hl7.fhir.convertors.context.ConversionContext14_50; 

public class Uuid14_50 {
    public static org.hl7.fhir.r5.model.UuidType convertUuid(org.hl7.fhir.dstu2016may.model.UuidType src) throws FHIRException {
      org.hl7.fhir.r5.model.UuidType tgt = new org.hl7.fhir.r5.model.UuidType();
      if (src.hasValue()) tgt.setValue(src.getValue());
      ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
      return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.UuidType convertUuid(org.hl7.fhir.r5.model.UuidType src) throws FHIRException {
      org.hl7.fhir.dstu2016may.model.UuidType tgt = new org.hl7.fhir.dstu2016may.model.UuidType();
      if (src.hasValue()) tgt.setValue(src.getValue());
      ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
      return tgt;
    }
}
