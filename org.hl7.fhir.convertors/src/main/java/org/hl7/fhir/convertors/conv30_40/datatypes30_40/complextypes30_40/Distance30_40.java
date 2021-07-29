package org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40;

import org.hl7.fhir.exceptions.FHIRException; import org.hl7.fhir.convertors.context.ConversionContext30_40;

public class Distance30_40 {
    public static org.hl7.fhir.r4.model.Distance convertDistance(org.hl7.fhir.dstu3.model.Distance src) throws FHIRException {
      if (src == null) return null;
      org.hl7.fhir.r4.model.Distance tgt = new org.hl7.fhir.r4.model.Distance();
      Quantity30_40.copyQuantity(src, tgt);
      return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Distance convertDistance(org.hl7.fhir.r4.model.Distance src) throws FHIRException {
      if (src == null) return null;
      org.hl7.fhir.dstu3.model.Distance tgt = new org.hl7.fhir.dstu3.model.Distance();
      Quantity30_40.copyQuantity(src, tgt);
      return tgt;
    }
}
