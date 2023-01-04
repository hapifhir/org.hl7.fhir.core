package org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50;

import org.hl7.fhir.convertors.context.ConversionContext10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.Decimal10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.PositiveInt10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.String10_50;
import org.hl7.fhir.exceptions.FHIRException;

public class SampledData10_50 {
  public static org.hl7.fhir.r5.model.SampledData convertSampledData(org.hl7.fhir.dstu2.model.SampledData src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.SampledData tgt = new org.hl7.fhir.r5.model.SampledData();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    if (src.hasOrigin()) tgt.setOrigin(SimpleQuantity10_50.convertSimpleQuantity(src.getOrigin()));
    if (src.hasPeriodElement()) tgt.setIntervalElement(Decimal10_50.convertDecimal(src.getPeriodElement()));
    if (src.hasFactorElement()) tgt.setFactorElement(Decimal10_50.convertDecimal(src.getFactorElement()));
    if (src.hasLowerLimitElement()) tgt.setLowerLimitElement(Decimal10_50.convertDecimal(src.getLowerLimitElement()));
    if (src.hasUpperLimitElement()) tgt.setUpperLimitElement(Decimal10_50.convertDecimal(src.getUpperLimitElement()));
    if (src.hasDimensionsElement())
      tgt.setDimensionsElement(PositiveInt10_50.convertPositiveInt(src.getDimensionsElement()));
    if (src.hasDataElement()) tgt.setDataElement(String10_50.convertString(src.getDataElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.SampledData convertSampledData(org.hl7.fhir.r5.model.SampledData src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2.model.SampledData tgt = new org.hl7.fhir.dstu2.model.SampledData();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    if (src.hasOrigin()) tgt.setOrigin(SimpleQuantity10_50.convertSimpleQuantity(src.getOrigin()));
    if (src.hasIntervalElement()) tgt.setPeriodElement(Decimal10_50.convertDecimal(src.getIntervalElement()));
    if (src.hasFactorElement()) tgt.setFactorElement(Decimal10_50.convertDecimal(src.getFactorElement()));
    if (src.hasLowerLimitElement()) tgt.setLowerLimitElement(Decimal10_50.convertDecimal(src.getLowerLimitElement()));
    if (src.hasUpperLimitElement()) tgt.setUpperLimitElement(Decimal10_50.convertDecimal(src.getUpperLimitElement()));
    if (src.hasDimensionsElement())
      tgt.setDimensionsElement(PositiveInt10_50.convertPositiveInt(src.getDimensionsElement()));
    if (src.hasDataElement()) tgt.setDataElement(String10_50.convertString(src.getDataElement()));
    return tgt;
  }
}
