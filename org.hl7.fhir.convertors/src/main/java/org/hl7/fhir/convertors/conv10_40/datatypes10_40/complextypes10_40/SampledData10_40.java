package org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40;

import org.hl7.fhir.convertors.conv10_40.datatypes10_40.Element10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.Decimal10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.PositiveInt10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.String10_40;
import org.hl7.fhir.exceptions.FHIRException;

public class SampledData10_40 {
  public static org.hl7.fhir.r4.model.SampledData convertSampledData(org.hl7.fhir.dstu2.model.SampledData src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4.model.SampledData tgt = new org.hl7.fhir.r4.model.SampledData();
    Element10_40.copyElement(src, tgt);
    if (src.hasOrigin()) tgt.setOrigin(SimpleQuantity10_40.convertSimpleQuantity(src.getOrigin()));
    if (src.hasPeriodElement()) tgt.setPeriodElement(Decimal10_40.convertDecimal(src.getPeriodElement()));
    if (src.hasFactorElement()) tgt.setFactorElement(Decimal10_40.convertDecimal(src.getFactorElement()));
    if (src.hasLowerLimitElement()) tgt.setLowerLimitElement(Decimal10_40.convertDecimal(src.getLowerLimitElement()));
    if (src.hasUpperLimitElement()) tgt.setUpperLimitElement(Decimal10_40.convertDecimal(src.getUpperLimitElement()));
    if (src.hasDimensionsElement())
      tgt.setDimensionsElement(PositiveInt10_40.convertPositiveInt(src.getDimensionsElement()));
    if (src.hasDataElement()) tgt.setDataElement(String10_40.convertString(src.getDataElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.SampledData convertSampledData(org.hl7.fhir.r4.model.SampledData src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2.model.SampledData tgt = new org.hl7.fhir.dstu2.model.SampledData();
    Element10_40.copyElement(src, tgt);
    if (src.hasOrigin()) tgt.setOrigin(SimpleQuantity10_40.convertSimpleQuantity(src.getOrigin()));
    if (src.hasPeriodElement()) tgt.setPeriodElement(Decimal10_40.convertDecimal(src.getPeriodElement()));
    if (src.hasFactorElement()) tgt.setFactorElement(Decimal10_40.convertDecimal(src.getFactorElement()));
    if (src.hasLowerLimitElement()) tgt.setLowerLimitElement(Decimal10_40.convertDecimal(src.getLowerLimitElement()));
    if (src.hasUpperLimitElement()) tgt.setUpperLimitElement(Decimal10_40.convertDecimal(src.getUpperLimitElement()));
    if (src.hasDimensionsElement())
      tgt.setDimensionsElement(PositiveInt10_40.convertPositiveInt(src.getDimensionsElement()));
    if (src.hasDataElement()) tgt.setDataElement(String10_40.convertString(src.getDataElement()));
    return tgt;
  }
}
