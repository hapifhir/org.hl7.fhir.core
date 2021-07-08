package org.hl7.fhir.convertors.conv14_30.datatypes14_30.complextypes14_30;

import org.hl7.fhir.convertors.conv14_30.datatypes14_30.Element14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.primitivetypes14_30.Decimal14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.primitivetypes14_30.PositiveInt14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.primitivetypes14_30.String14_30;
import org.hl7.fhir.exceptions.FHIRException;

public class SampledData14_30 {
    public static org.hl7.fhir.dstu3.model.SampledData convertSampledData(org.hl7.fhir.dstu2016may.model.SampledData src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu3.model.SampledData tgt = new org.hl7.fhir.dstu3.model.SampledData();
      Element14_30.copyElement(src, tgt);
      if (src.hasOrigin()) tgt.setOrigin(SimpleQuantity14_30.convertSimpleQuantity(src.getOrigin()));
      if (src.hasPeriodElement()) tgt.setPeriodElement(Decimal14_30.convertDecimal(src.getPeriodElement()));
      if (src.hasFactor()) tgt.setFactorElement(Decimal14_30.convertDecimal(src.getFactorElement()));
      if (src.hasLowerLimit()) tgt.setLowerLimitElement(Decimal14_30.convertDecimal(src.getLowerLimitElement()));
      if (src.hasUpperLimit()) tgt.setUpperLimitElement(Decimal14_30.convertDecimal(src.getUpperLimitElement()));
      if (src.hasDimensionsElement()) tgt.setDimensionsElement(PositiveInt14_30.convertPositiveInt(src.getDimensionsElement()));
      if (src.hasDataElement()) tgt.setDataElement(String14_30.convertString(src.getDataElement()));
      return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.SampledData convertSampledData(org.hl7.fhir.dstu3.model.SampledData src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu2016may.model.SampledData tgt = new org.hl7.fhir.dstu2016may.model.SampledData();
      Element14_30.copyElement(src, tgt);
      if (src.hasOrigin()) tgt.setOrigin(SimpleQuantity14_30.convertSimpleQuantity(src.getOrigin()));
      if (src.hasPeriodElement()) tgt.setPeriodElement(Decimal14_30.convertDecimal(src.getPeriodElement()));
      if (src.hasFactor()) tgt.setFactorElement(Decimal14_30.convertDecimal(src.getFactorElement()));
      if (src.hasLowerLimit()) tgt.setLowerLimitElement(Decimal14_30.convertDecimal(src.getLowerLimitElement()));
      if (src.hasUpperLimit()) tgt.setUpperLimitElement(Decimal14_30.convertDecimal(src.getUpperLimitElement()));
      if (src.hasDimensionsElement()) tgt.setDimensionsElement(PositiveInt14_30.convertPositiveInt(src.getDimensionsElement()));
      if (src.hasDataElement()) tgt.setDataElement(String14_30.convertString(src.getDataElement()));
      return tgt;
    }
}
