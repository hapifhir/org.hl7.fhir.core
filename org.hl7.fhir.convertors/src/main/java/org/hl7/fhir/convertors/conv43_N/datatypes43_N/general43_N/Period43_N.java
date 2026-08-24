package org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.DateTime43_N;
import org.hl7.fhir.exceptions.FHIRException;

public class Period43_N {
  public static org.hl7.fhir.model.core.Period convertPeriod(org.hl7.fhir.r4b.model.Period src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.Period tgt = new org.hl7.fhir.model.core.Period();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.hasStart()) tgt.setStartElement(DateTime43_N.convertDateTime(src.getStartElement()));
    if (src.hasEnd()) tgt.setEndElement(DateTime43_N.convertDateTime(src.getEndElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Period convertPeriod(org.hl7.fhir.model.core.Period src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.Period tgt = new org.hl7.fhir.r4b.model.Period();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.hasStart()) tgt.setStartElement(DateTime43_N.convertDateTime(src.getStartElement()));
    if (src.hasEnd()) tgt.setEndElement(DateTime43_N.convertDateTime(src.getEndElement()));
    return tgt;
  }
}
