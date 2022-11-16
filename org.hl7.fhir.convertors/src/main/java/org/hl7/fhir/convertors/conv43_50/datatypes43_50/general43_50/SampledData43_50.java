package org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Decimal43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.PositiveInt43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.String43_50;
import org.hl7.fhir.exceptions.FHIRException;

public class SampledData43_50 {
  public static org.hl7.fhir.r5.model.SampledData convertSampledData(org.hl7.fhir.r4b.model.SampledData src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.SampledData tgt = new org.hl7.fhir.r5.model.SampledData();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.hasOrigin()) tgt.setOrigin(SimpleQuantity43_50.convertSimpleQuantity(src.getOrigin()));
    if (src.hasPeriod()) tgt.setIntervalElement(Decimal43_50.convertDecimal(src.getPeriodElement()));
    if (src.hasFactor()) tgt.setFactorElement(Decimal43_50.convertDecimal(src.getFactorElement()));
    if (src.hasLowerLimit()) tgt.setLowerLimitElement(Decimal43_50.convertDecimal(src.getLowerLimitElement()));
    if (src.hasUpperLimit()) tgt.setUpperLimitElement(Decimal43_50.convertDecimal(src.getUpperLimitElement()));
    if (src.hasDimensions()) tgt.setDimensionsElement(PositiveInt43_50.convertPositiveInt(src.getDimensionsElement()));
    if (src.hasData()) tgt.setDataElement(String43_50.convertString(src.getDataElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.SampledData convertSampledData(org.hl7.fhir.r5.model.SampledData src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.SampledData tgt = new org.hl7.fhir.r4b.model.SampledData();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.hasOrigin()) tgt.setOrigin(SimpleQuantity43_50.convertSimpleQuantity(src.getOrigin()));
    if (src.hasInterval()) tgt.setPeriodElement(Decimal43_50.convertDecimal(src.getIntervalElement()));
    if (src.hasFactor()) tgt.setFactorElement(Decimal43_50.convertDecimal(src.getFactorElement()));
    if (src.hasLowerLimit()) tgt.setLowerLimitElement(Decimal43_50.convertDecimal(src.getLowerLimitElement()));
    if (src.hasUpperLimit()) tgt.setUpperLimitElement(Decimal43_50.convertDecimal(src.getUpperLimitElement()));
    if (src.hasDimensions()) tgt.setDimensionsElement(PositiveInt43_50.convertPositiveInt(src.getDimensionsElement()));
    if (src.hasData()) tgt.setDataElement(String43_50.convertString(src.getDataElement()));
    return tgt;
  }
}
