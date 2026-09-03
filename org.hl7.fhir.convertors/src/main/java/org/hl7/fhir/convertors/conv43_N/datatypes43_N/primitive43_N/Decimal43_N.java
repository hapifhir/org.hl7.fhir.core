package org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.exceptions.FHIRException;

public class Decimal43_N {
  public static org.hl7.fhir.model.core.DecimalType convertDecimal(org.hl7.fhir.r4b.model.DecimalType src) throws FHIRException {
    org.hl7.fhir.model.core.DecimalType tgt = src.hasValue() ? new org.hl7.fhir.model.core.DecimalType(src.getValueAsString()) : new org.hl7.fhir.model.core.DecimalType();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.DecimalType convertDecimal(org.hl7.fhir.model.core.DecimalType src) throws FHIRException {
    org.hl7.fhir.r4b.model.DecimalType tgt = src.hasValue() ? new org.hl7.fhir.r4b.model.DecimalType(src.getValueAsString()) : new org.hl7.fhir.r4b.model.DecimalType();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.model.core.Quantity convertDecimalToQuantity(org.hl7.fhir.r4b.model.DecimalType src) {
    org.hl7.fhir.model.core.Quantity tgt = new org.hl7.fhir.model.core.Quantity();
    if (src.hasValue()) {
      tgt.setValue(src.getValue());
      tgt.setSystem("http://unitsofmeasure.org");
      tgt.setCode("1");
    }
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    return tgt;
  }
}
