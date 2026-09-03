package org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.exceptions.FHIRException;

public class Decimal40_N {
  public static org.hl7.fhir.model.core.DecimalType convertDecimal(org.hl7.fhir.r4.model.DecimalType src) throws FHIRException {
    org.hl7.fhir.model.core.DecimalType tgt = src.hasValue() ? new org.hl7.fhir.model.core.DecimalType(src.getValueAsString()) : new org.hl7.fhir.model.core.DecimalType();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.DecimalType convertDecimal(org.hl7.fhir.model.core.DecimalType src) throws FHIRException {
    org.hl7.fhir.r4.model.DecimalType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.DecimalType(src.getValueAsString()) : new org.hl7.fhir.r4.model.DecimalType();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.model.core.Quantity convertDecimalToQuantity(org.hl7.fhir.r4.model.DecimalType src) {
    org.hl7.fhir.model.core.Quantity tgt = new org.hl7.fhir.model.core.Quantity();
    if (src.hasValue()) {
      tgt.setValue(src.getValue());
      tgt.setSystem("http://unitsofmeasure.org");
      tgt.setCode("1");
    }
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    return tgt;
  }
}
