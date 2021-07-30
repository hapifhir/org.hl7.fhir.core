package org.hl7.fhir.convertors.conv14_40.datatypes14_40.primitivetypes14_40;

import org.hl7.fhir.convertors.context.ConversionContext14_40;
import org.hl7.fhir.exceptions.FHIRException;  import org.hl7.fhir.convertors.context.ConversionContext14_40;

public class Code14_40 {
    public static org.hl7.fhir.r4.model.CodeType convertCode(org.hl7.fhir.dstu2016may.model.CodeType src) throws FHIRException {
      org.hl7.fhir.r4.model.CodeType tgt = new org.hl7.fhir.r4.model.CodeType();
      if (src.hasValue()) tgt.setValue(src.getValue());
      ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
      return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.CodeType convertCode(org.hl7.fhir.r4.model.CodeType src) throws FHIRException {
      org.hl7.fhir.dstu2016may.model.CodeType tgt = new org.hl7.fhir.dstu2016may.model.CodeType();
      if (src.hasValue()) tgt.setValue(src.getValue());
      ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
      return tgt;
    }
}
