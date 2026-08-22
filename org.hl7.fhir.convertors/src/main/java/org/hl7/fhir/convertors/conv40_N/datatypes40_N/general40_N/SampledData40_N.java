package org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Decimal40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.PositiveInt40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.String40_N;
import org.hl7.fhir.exceptions.FHIRException;

public class SampledData40_N {
  public static org.hl7.fhir.model.core.SampledData convertSampledData(org.hl7.fhir.r4.model.SampledData src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.SampledData tgt = new org.hl7.fhir.model.core.SampledData();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasOrigin()) tgt.setOrigin(SimpleQuantity40_N.convertSimpleQuantity(src.getOrigin()));
    if (src.hasPeriod()) tgt.setIntervalElement(Decimal40_N.convertDecimal(src.getPeriodElement()));
    if (src.hasFactor()) tgt.setFactorElement(Decimal40_N.convertDecimal(src.getFactorElement()));
    if (src.hasLowerLimit()) tgt.setLowerLimitElement(Decimal40_N.convertDecimal(src.getLowerLimitElement()));
    if (src.hasUpperLimit()) tgt.setUpperLimitElement(Decimal40_N.convertDecimal(src.getUpperLimitElement()));
    if (src.hasDimensions()) tgt.setDimensionsElement(PositiveInt40_N.convertPositiveInt(src.getDimensionsElement()));
    if (src.hasData()) tgt.setDataElement(String40_N.convertString(src.getDataElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.SampledData convertSampledData(org.hl7.fhir.model.core.SampledData src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.SampledData tgt = new org.hl7.fhir.r4.model.SampledData();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasOrigin()) tgt.setOrigin(SimpleQuantity40_N.convertSimpleQuantity(src.getOrigin()));
    if (src.hasInterval()) tgt.setPeriodElement(Decimal40_N.convertDecimal(src.getIntervalElement()));
    if (src.hasFactor()) tgt.setFactorElement(Decimal40_N.convertDecimal(src.getFactorElement()));
    if (src.hasLowerLimit()) tgt.setLowerLimitElement(Decimal40_N.convertDecimal(src.getLowerLimitElement()));
    if (src.hasUpperLimit()) tgt.setUpperLimitElement(Decimal40_N.convertDecimal(src.getUpperLimitElement()));
    if (src.hasDimensions()) tgt.setDimensionsElement(PositiveInt40_N.convertPositiveInt(src.getDimensionsElement()));
    if (src.hasData()) tgt.setDataElement(String40_N.convertString(src.getDataElement()));
    return tgt;
  }
}
