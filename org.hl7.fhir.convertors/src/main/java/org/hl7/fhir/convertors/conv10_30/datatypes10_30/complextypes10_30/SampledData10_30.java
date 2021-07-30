package org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30;

import org.hl7.fhir.convertors.conv10_30.datatypes10_30.Element10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.Decimal10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.PositiveInt10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.String10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class SampledData10_30 {
  public static org.hl7.fhir.dstu3.model.SampledData convertSampledData(org.hl7.fhir.dstu2.model.SampledData src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu3.model.SampledData tgt = new org.hl7.fhir.dstu3.model.SampledData();
    Element10_30.copyElement(src, tgt);
    if (src.hasOrigin()) tgt.setOrigin(SimpleQuantity10_30.convertSimpleQuantity(src.getOrigin()));
    if (src.hasPeriodElement()) tgt.setPeriodElement(Decimal10_30.convertDecimal(src.getPeriodElement()));
    if (src.hasFactorElement()) tgt.setFactorElement(Decimal10_30.convertDecimal(src.getFactorElement()));
    if (src.hasLowerLimitElement()) tgt.setLowerLimitElement(Decimal10_30.convertDecimal(src.getLowerLimitElement()));
    if (src.hasUpperLimitElement()) tgt.setUpperLimitElement(Decimal10_30.convertDecimal(src.getUpperLimitElement()));
    if (src.hasDimensionsElement())
      tgt.setDimensionsElement(PositiveInt10_30.convertPositiveInt(src.getDimensionsElement()));
    if (src.hasDataElement()) tgt.setDataElement(String10_30.convertString(src.getDataElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.SampledData convertSampledData(org.hl7.fhir.dstu3.model.SampledData src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2.model.SampledData tgt = new org.hl7.fhir.dstu2.model.SampledData();
    Element10_30.copyElement(src, tgt);
    if (src.hasOrigin()) tgt.setOrigin(SimpleQuantity10_30.convertSimpleQuantity(src.getOrigin()));
    if (src.hasPeriodElement()) tgt.setPeriodElement(Decimal10_30.convertDecimal(src.getPeriodElement()));
    if (src.hasFactorElement()) tgt.setFactorElement(Decimal10_30.convertDecimal(src.getFactorElement()));
    if (src.hasLowerLimitElement()) tgt.setLowerLimitElement(Decimal10_30.convertDecimal(src.getLowerLimitElement()));
    if (src.hasUpperLimitElement()) tgt.setUpperLimitElement(Decimal10_30.convertDecimal(src.getUpperLimitElement()));
    if (src.hasDimensionsElement())
      tgt.setDimensionsElement(PositiveInt10_30.convertPositiveInt(src.getDimensionsElement()));
    if (src.hasDataElement()) tgt.setDataElement(String10_30.convertString(src.getDataElement()));
    return tgt;
  }
}
