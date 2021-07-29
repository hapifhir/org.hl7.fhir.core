package org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40;

import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Element30_40;
import org.hl7.fhir.exceptions.FHIRException; import org.hl7.fhir.convertors.context.ConversionContext30_40;

public class Range30_40 {
    public static org.hl7.fhir.r4.model.Range convertRange(org.hl7.fhir.dstu3.model.Range src) throws FHIRException {
      if (src == null) return null;
      org.hl7.fhir.r4.model.Range tgt = new org.hl7.fhir.r4.model.Range();
      ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
      if (src.hasLow()) tgt.setLow(SimpleQuantity30_40.convertSimpleQuantity(src.getLow()));
      if (src.hasHigh()) tgt.setHigh(SimpleQuantity30_40.convertSimpleQuantity(src.getHigh()));
      return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Range convertRange(org.hl7.fhir.r4.model.Range src) throws FHIRException {
      if (src == null) return null;
      org.hl7.fhir.dstu3.model.Range tgt = new org.hl7.fhir.dstu3.model.Range();
      ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
      if (src.hasLow()) tgt.setLow(SimpleQuantity30_40.convertSimpleQuantity(src.getLow()));
      if (src.hasHigh()) tgt.setHigh(SimpleQuantity30_40.convertSimpleQuantity(src.getHigh()));
      return tgt;
    }
}
