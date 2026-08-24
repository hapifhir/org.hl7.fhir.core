package org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N;

import org.hl7.fhir.convertors.context.ConversionContext50_N;
import org.hl7.fhir.exceptions.FHIRException;

public class Decimal50_N {
  public static org.hl7.fhir.model.core.DecimalType convertDecimal(org.hl7.fhir.r5.model.DecimalType src) throws FHIRException {
    org.hl7.fhir.model.core.DecimalType tgt = src.hasValue() ? new org.hl7.fhir.model.core.DecimalType(src.getValueAsString()) : new org.hl7.fhir.model.core.DecimalType();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r5.model.DecimalType convertDecimal(org.hl7.fhir.model.core.DecimalType src) throws FHIRException {
    org.hl7.fhir.r5.model.DecimalType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.DecimalType(src.getValueAsString()) : new org.hl7.fhir.r5.model.DecimalType();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.model.core.Quantity convertDecimalToQuantity(org.hl7.fhir.r5.model.DecimalType src) {
    org.hl7.fhir.model.core.Quantity tgt = new org.hl7.fhir.model.core.Quantity();
    if (src.hasValue()) {
      tgt.setValue(src.getValue());
      tgt.setSystem("http://unitsofmeasure.org");
      tgt.setCode("1");
    }
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    return tgt;
  }
}
