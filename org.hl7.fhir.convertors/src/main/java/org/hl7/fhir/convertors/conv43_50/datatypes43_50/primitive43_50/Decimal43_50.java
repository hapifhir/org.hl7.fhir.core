package org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50;

import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4b.model.DecimalType;

public class Decimal43_50 {
  public static org.hl7.fhir.r5.model.DecimalType convertDecimal(org.hl7.fhir.r4b.model.DecimalType src) throws FHIRException {
    org.hl7.fhir.r5.model.DecimalType tgt = src.hasValue() ? new org.hl7.fhir.r5.model.DecimalType(src.getValueAsString()) : new org.hl7.fhir.r5.model.DecimalType();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.DecimalType convertDecimal(org.hl7.fhir.r5.model.DecimalType src) throws FHIRException {
    org.hl7.fhir.r4b.model.DecimalType tgt = src.hasValue() ? new org.hl7.fhir.r4b.model.DecimalType(src.getValueAsString()) : new org.hl7.fhir.r4b.model.DecimalType();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    return tgt;
  }


  public static org.hl7.fhir.r5.model.Quantity convertDecimalToQuantity(org.hl7.fhir.r4b.model.DecimalType src) {
    org.hl7.fhir.r5.model.Quantity tgt = new org.hl7.fhir.r5.model.Quantity();
    if (src.hasValue()) {
      tgt.setValue(src.getValue());
      tgt.setSystem("http://unitsofmeasure.org");
      tgt.setCode("1");
    }
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    return tgt;
  }
}
