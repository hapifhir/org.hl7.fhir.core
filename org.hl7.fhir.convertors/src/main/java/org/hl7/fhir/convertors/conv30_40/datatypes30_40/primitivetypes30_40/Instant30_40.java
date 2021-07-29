package org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40;

import org.hl7.fhir.convertors.context.ConversionContext30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Element30_40;
import org.hl7.fhir.exceptions.FHIRException; import org.hl7.fhir.convertors.context.ConversionContext30_40;

public class Instant30_40 {
    public static org.hl7.fhir.r4.model.InstantType convertInstant(org.hl7.fhir.dstu3.model.InstantType src) throws FHIRException {
      org.hl7.fhir.r4.model.InstantType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.InstantType(src.getValueAsString()) : new org.hl7.fhir.r4.model.InstantType();
      ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
      return tgt;
    }

    public static org.hl7.fhir.dstu3.model.InstantType convertInstant(org.hl7.fhir.r4.model.InstantType src) throws FHIRException {
      org.hl7.fhir.dstu3.model.InstantType tgt = src.hasValue() ? new org.hl7.fhir.dstu3.model.InstantType(src.getValueAsString()) : new org.hl7.fhir.dstu3.model.InstantType();
      ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
      return tgt;
    }
}
