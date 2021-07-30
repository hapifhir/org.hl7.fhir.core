package org.hl7.fhir.convertors.conv14_40.datatypes14_40.primitivetypes14_40;

import org.hl7.fhir.convertors.context.ConversionContext14_40;
import org.hl7.fhir.exceptions.FHIRException;  import org.hl7.fhir.convertors.context.ConversionContext14_40;

public class Time14_40 {
    public static org.hl7.fhir.r4.model.TimeType convertTime(org.hl7.fhir.dstu2016may.model.TimeType src) throws FHIRException {
      org.hl7.fhir.r4.model.TimeType tgt = new org.hl7.fhir.r4.model.TimeType();
      if (src.hasValue()) tgt.setValue(src.getValue());
      ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
      return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.TimeType convertTime(org.hl7.fhir.r4.model.TimeType src) throws FHIRException {
      org.hl7.fhir.dstu2016may.model.TimeType tgt = new org.hl7.fhir.dstu2016may.model.TimeType();
      if (src.hasValue()) tgt.setValue(src.getValue());
      ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
      return tgt;
    }
}
