package org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40;

import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Element30_40;
import org.hl7.fhir.exceptions.FHIRException; import org.hl7.fhir.convertors.context.ConversionContext30_40;

public class Integer30_40 {
    public static org.hl7.fhir.r4.model.IntegerType convertInteger(org.hl7.fhir.dstu3.model.IntegerType src) throws FHIRException {
      org.hl7.fhir.r4.model.IntegerType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.IntegerType(src.getValue()) : new org.hl7.fhir.r4.model.IntegerType();
      ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
      return tgt;
    }

    public static org.hl7.fhir.dstu3.model.IntegerType convertInteger(org.hl7.fhir.r4.model.IntegerType src) throws FHIRException {
      org.hl7.fhir.dstu3.model.IntegerType tgt = src.hasValue() ? new org.hl7.fhir.dstu3.model.IntegerType(src.getValue()) : new org.hl7.fhir.dstu3.model.IntegerType();
      ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
      return tgt;
    }
}
