package org.hl7.fhir.convertors.conv14_50.datatypes14_50.complextypes14_50;

import org.hl7.fhir.convertors.conv14_50.datatypes14_50.Element14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50.Decimal14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50.PositiveInt14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50.String14_50;
import org.hl7.fhir.exceptions.FHIRException;

public class SampledData14_50 {
    public static org.hl7.fhir.r5.model.SampledData convertSampledData(org.hl7.fhir.dstu2016may.model.SampledData src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.r5.model.SampledData tgt = new org.hl7.fhir.r5.model.SampledData();
      Element14_50.copyElement(src, tgt);
      if (src.hasOrigin()) tgt.setOrigin(SimpleQuantity14_50.convertSimpleQuantity(src.getOrigin()));
      if (src.hasPeriodElement()) tgt.setPeriodElement(Decimal14_50.convertDecimal(src.getPeriodElement()));
      if (src.hasFactor()) tgt.setFactorElement(Decimal14_50.convertDecimal(src.getFactorElement()));
      if (src.hasLowerLimit()) tgt.setLowerLimitElement(Decimal14_50.convertDecimal(src.getLowerLimitElement()));
      if (src.hasUpperLimit()) tgt.setUpperLimitElement(Decimal14_50.convertDecimal(src.getUpperLimitElement()));
      if (src.hasDimensionsElement()) tgt.setDimensionsElement(PositiveInt14_50.convertPositiveInt(src.getDimensionsElement()));
      if (src.hasDataElement()) tgt.setDataElement(String14_50.convertString(src.getDataElement()));
      return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.SampledData convertSampledData(org.hl7.fhir.r5.model.SampledData src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu2016may.model.SampledData tgt = new org.hl7.fhir.dstu2016may.model.SampledData();
      Element14_50.copyElement(src, tgt);
      if (src.hasOrigin()) tgt.setOrigin(SimpleQuantity14_50.convertSimpleQuantity(src.getOrigin()));
      if (src.hasPeriodElement()) tgt.setPeriodElement(Decimal14_50.convertDecimal(src.getPeriodElement()));
      if (src.hasFactor()) tgt.setFactorElement(Decimal14_50.convertDecimal(src.getFactorElement()));
      if (src.hasLowerLimit()) tgt.setLowerLimitElement(Decimal14_50.convertDecimal(src.getLowerLimitElement()));
      if (src.hasUpperLimit()) tgt.setUpperLimitElement(Decimal14_50.convertDecimal(src.getUpperLimitElement()));
      if (src.hasDimensionsElement()) tgt.setDimensionsElement(PositiveInt14_50.convertPositiveInt(src.getDimensionsElement()));
      if (src.hasDataElement()) tgt.setDataElement(String14_50.convertString(src.getDataElement()));
      return tgt;
    }
}
