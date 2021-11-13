package org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50;

import org.hl7.fhir.convertors.context.ConversionContext30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.Decimal30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.PositiveInt30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.String30_50;
import org.hl7.fhir.exceptions.FHIRException;

public class SampledData30_50 {
  public static org.hl7.fhir.r5.model.SampledData convertSampledData(org.hl7.fhir.dstu3.model.SampledData src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.SampledData tgt = new org.hl7.fhir.r5.model.SampledData();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.hasOrigin()) tgt.setOrigin(SimpleQuantity30_50.convertSimpleQuantity(src.getOrigin()));
    if (src.hasPeriod()) tgt.setPeriodElement(Decimal30_50.convertDecimal(src.getPeriodElement()));
    if (src.hasFactor()) tgt.setFactorElement(Decimal30_50.convertDecimal(src.getFactorElement()));
    if (src.hasLowerLimit()) tgt.setLowerLimitElement(Decimal30_50.convertDecimal(src.getLowerLimitElement()));
    if (src.hasUpperLimit()) tgt.setUpperLimitElement(Decimal30_50.convertDecimal(src.getUpperLimitElement()));
    if (src.hasDimensions()) tgt.setDimensionsElement(PositiveInt30_50.convertPositiveInt(src.getDimensionsElement()));
    if (src.hasData()) tgt.setDataElement(String30_50.convertString(src.getDataElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.SampledData convertSampledData(org.hl7.fhir.r5.model.SampledData src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.dstu3.model.SampledData tgt = new org.hl7.fhir.dstu3.model.SampledData();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.hasOrigin()) tgt.setOrigin(SimpleQuantity30_50.convertSimpleQuantity(src.getOrigin()));
    if (src.hasPeriod()) tgt.setPeriodElement(Decimal30_50.convertDecimal(src.getPeriodElement()));
    if (src.hasFactor()) tgt.setFactorElement(Decimal30_50.convertDecimal(src.getFactorElement()));
    if (src.hasLowerLimit()) tgt.setLowerLimitElement(Decimal30_50.convertDecimal(src.getLowerLimitElement()));
    if (src.hasUpperLimit()) tgt.setUpperLimitElement(Decimal30_50.convertDecimal(src.getUpperLimitElement()));
    if (src.hasDimensions()) tgt.setDimensionsElement(PositiveInt30_50.convertPositiveInt(src.getDimensionsElement()));
    if (src.hasData()) tgt.setDataElement(String30_50.convertString(src.getDataElement()));
    return tgt;
  }
}
