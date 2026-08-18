package org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Decimal43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.PositiveInt43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.String43_N;
import org.hl7.fhir.exceptions.FHIRException;

public class SampledData43_N {
  public static org.hl7.fhir.model.core.SampledData convertSampledData(org.hl7.fhir.r4b.model.SampledData src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.SampledData tgt = new org.hl7.fhir.model.core.SampledData();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.hasOrigin()) tgt.setOrigin(SimpleQuantity43_N.convertSimpleQuantity(src.getOrigin()));
    if (src.hasPeriod()) tgt.setIntervalElement(Decimal43_N.convertDecimal(src.getPeriodElement()));
    if (src.hasFactor()) tgt.setFactorElement(Decimal43_N.convertDecimal(src.getFactorElement()));
    if (src.hasLowerLimit()) tgt.setLowerLimitElement(Decimal43_N.convertDecimal(src.getLowerLimitElement()));
    if (src.hasUpperLimit()) tgt.setUpperLimitElement(Decimal43_N.convertDecimal(src.getUpperLimitElement()));
    if (src.hasDimensions()) tgt.setDimensionsElement(PositiveInt43_N.convertPositiveInt(src.getDimensionsElement()));
    if (src.hasData()) tgt.setDataElement(String43_N.convertString(src.getDataElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.SampledData convertSampledData(org.hl7.fhir.model.core.SampledData src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.SampledData tgt = new org.hl7.fhir.r4b.model.SampledData();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.hasOrigin()) tgt.setOrigin(SimpleQuantity43_N.convertSimpleQuantity(src.getOrigin()));
    if (src.hasInterval()) tgt.setPeriodElement(Decimal43_N.convertDecimal(src.getIntervalElement()));
    if (src.hasFactor()) tgt.setFactorElement(Decimal43_N.convertDecimal(src.getFactorElement()));
    if (src.hasLowerLimit()) tgt.setLowerLimitElement(Decimal43_N.convertDecimal(src.getLowerLimitElement()));
    if (src.hasUpperLimit()) tgt.setUpperLimitElement(Decimal43_N.convertDecimal(src.getUpperLimitElement()));
    if (src.hasDimensions()) tgt.setDimensionsElement(PositiveInt43_N.convertPositiveInt(src.getDimensionsElement()));
    if (src.hasData()) tgt.setDataElement(String43_N.convertString(src.getDataElement()));
    return tgt;
  }
}
