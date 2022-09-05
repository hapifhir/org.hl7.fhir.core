package org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50;

import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Decimal40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.PositiveInt40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.String40_50;
import org.hl7.fhir.exceptions.FHIRException;

public class SampledData40_50 {
  public static org.hl7.fhir.r5.model.SampledData convertSampledData(org.hl7.fhir.r4.model.SampledData src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.SampledData tgt = new org.hl7.fhir.r5.model.SampledData();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasOrigin()) tgt.setOrigin(SimpleQuantity40_50.convertSimpleQuantity(src.getOrigin()));
    if (src.hasPeriod()) tgt.setIntervalElement(Decimal40_50.convertDecimal(src.getPeriodElement()));
    if (src.hasFactor()) tgt.setFactorElement(Decimal40_50.convertDecimal(src.getFactorElement()));
    if (src.hasLowerLimit()) tgt.setLowerLimitElement(Decimal40_50.convertDecimal(src.getLowerLimitElement()));
    if (src.hasUpperLimit()) tgt.setUpperLimitElement(Decimal40_50.convertDecimal(src.getUpperLimitElement()));
    if (src.hasDimensions()) tgt.setDimensionsElement(PositiveInt40_50.convertPositiveInt(src.getDimensionsElement()));
    if (src.hasData()) tgt.setDataElement(String40_50.convertString(src.getDataElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.SampledData convertSampledData(org.hl7.fhir.r5.model.SampledData src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.SampledData tgt = new org.hl7.fhir.r4.model.SampledData();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasOrigin()) tgt.setOrigin(SimpleQuantity40_50.convertSimpleQuantity(src.getOrigin()));
    if (src.hasInterval()) tgt.setPeriodElement(Decimal40_50.convertDecimal(src.getIntervalElement()));
    if (src.hasFactor()) tgt.setFactorElement(Decimal40_50.convertDecimal(src.getFactorElement()));
    if (src.hasLowerLimit()) tgt.setLowerLimitElement(Decimal40_50.convertDecimal(src.getLowerLimitElement()));
    if (src.hasUpperLimit()) tgt.setUpperLimitElement(Decimal40_50.convertDecimal(src.getUpperLimitElement()));
    if (src.hasDimensions()) tgt.setDimensionsElement(PositiveInt40_50.convertPositiveInt(src.getDimensionsElement()));
    if (src.hasData()) tgt.setDataElement(String40_50.convertString(src.getDataElement()));
    return tgt;
  }
}
