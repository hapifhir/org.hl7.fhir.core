package org.hl7.fhir.convertors.conv14_40.datatypes14_40.complextypes14_40;

import org.hl7.fhir.convertors.conv14_40.datatypes14_40.Element14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.primitivetypes14_40.Decimal14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.primitivetypes14_40.PositiveInt14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.primitivetypes14_40.String14_40;
import org.hl7.fhir.exceptions.FHIRException;

public class SampledData14_40 {
    public static org.hl7.fhir.r4.model.SampledData convertSampledData(org.hl7.fhir.dstu2016may.model.SampledData src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.r4.model.SampledData tgt = new org.hl7.fhir.r4.model.SampledData();
      Element14_40.copyElement(src, tgt);
      if (src.hasOrigin()) tgt.setOrigin(SimpleQuantity14_40.convertSimpleQuantity(src.getOrigin()));
      if (src.hasPeriodElement()) tgt.setPeriodElement(Decimal14_40.convertDecimal(src.getPeriodElement()));
      if (src.hasFactor()) tgt.setFactorElement(Decimal14_40.convertDecimal(src.getFactorElement()));
      if (src.hasLowerLimit()) tgt.setLowerLimitElement(Decimal14_40.convertDecimal(src.getLowerLimitElement()));
      if (src.hasUpperLimit()) tgt.setUpperLimitElement(Decimal14_40.convertDecimal(src.getUpperLimitElement()));
      if (src.hasDimensionsElement()) tgt.setDimensionsElement(PositiveInt14_40.convertPositiveInt(src.getDimensionsElement()));
      if (src.hasDataElement()) tgt.setDataElement(String14_40.convertString(src.getDataElement()));
      return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.SampledData convertSampledData(org.hl7.fhir.r4.model.SampledData src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu2016may.model.SampledData tgt = new org.hl7.fhir.dstu2016may.model.SampledData();
      Element14_40.copyElement(src, tgt);
      if (src.hasOrigin()) tgt.setOrigin(SimpleQuantity14_40.convertSimpleQuantity(src.getOrigin()));
      if (src.hasPeriodElement()) tgt.setPeriodElement(Decimal14_40.convertDecimal(src.getPeriodElement()));
      if (src.hasFactor()) tgt.setFactorElement(Decimal14_40.convertDecimal(src.getFactorElement()));
      if (src.hasLowerLimit()) tgt.setLowerLimitElement(Decimal14_40.convertDecimal(src.getLowerLimitElement()));
      if (src.hasUpperLimit()) tgt.setUpperLimitElement(Decimal14_40.convertDecimal(src.getUpperLimitElement()));
      if (src.hasDimensionsElement()) tgt.setDimensionsElement(PositiveInt14_40.convertPositiveInt(src.getDimensionsElement()));
      if (src.hasDataElement()) tgt.setDataElement(String14_40.convertString(src.getDataElement()));
      return tgt;
    }
}
