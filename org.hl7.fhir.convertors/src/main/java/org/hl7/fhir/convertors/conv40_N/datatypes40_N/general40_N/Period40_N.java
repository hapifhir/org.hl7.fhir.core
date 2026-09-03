package org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.DateTime40_N;
import org.hl7.fhir.exceptions.FHIRException;

public class Period40_N {
  public static org.hl7.fhir.model.core.Period convertPeriod(org.hl7.fhir.r4.model.Period src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.Period tgt = new org.hl7.fhir.model.core.Period();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasStart()) tgt.setStartElement(DateTime40_N.convertDateTime(src.getStartElement()));
    if (src.hasEnd()) tgt.setEndElement(DateTime40_N.convertDateTime(src.getEndElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Period convertPeriod(org.hl7.fhir.model.core.Period src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.Period tgt = new org.hl7.fhir.r4.model.Period();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasStart()) tgt.setStartElement(DateTime40_N.convertDateTime(src.getStartElement()));
    if (src.hasEnd()) tgt.setEndElement(DateTime40_N.convertDateTime(src.getEndElement()));
    return tgt;
  }
}
