package org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40;

import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Element30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.Decimal30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.PositiveInt30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.String30_40;
import org.hl7.fhir.exceptions.FHIRException;

public class SampledData30_40 {
    public static org.hl7.fhir.r4.model.SampledData convertSampledData(org.hl7.fhir.dstu3.model.SampledData src) throws FHIRException {
      if (src == null) return null;
      org.hl7.fhir.r4.model.SampledData tgt = new org.hl7.fhir.r4.model.SampledData();
      Element30_40.copyElement(src, tgt);
      if (src.hasOrigin()) tgt.setOrigin(SimpleQuantity30_40.convertSimpleQuantity(src.getOrigin()));
      if (src.hasPeriod()) tgt.setPeriodElement(Decimal30_40.convertDecimal(src.getPeriodElement()));
      if (src.hasFactor()) tgt.setFactorElement(Decimal30_40.convertDecimal(src.getFactorElement()));
      if (src.hasLowerLimit()) tgt.setLowerLimitElement(Decimal30_40.convertDecimal(src.getLowerLimitElement()));
      if (src.hasUpperLimit()) tgt.setUpperLimitElement(Decimal30_40.convertDecimal(src.getUpperLimitElement()));
      if (src.hasDimensions()) tgt.setDimensionsElement(PositiveInt30_40.convertPositiveInt(src.getDimensionsElement()));
      if (src.hasData()) tgt.setDataElement(String30_40.convertString(src.getDataElement()));
      return tgt;
    }

    public static org.hl7.fhir.dstu3.model.SampledData convertSampledData(org.hl7.fhir.r4.model.SampledData src) throws FHIRException {
      if (src == null) return null;
      org.hl7.fhir.dstu3.model.SampledData tgt = new org.hl7.fhir.dstu3.model.SampledData();
      Element30_40.copyElement(src, tgt);
      if (src.hasOrigin()) tgt.setOrigin(SimpleQuantity30_40.convertSimpleQuantity(src.getOrigin()));
      if (src.hasPeriod()) tgt.setPeriodElement(Decimal30_40.convertDecimal(src.getPeriodElement()));
      if (src.hasFactor()) tgt.setFactorElement(Decimal30_40.convertDecimal(src.getFactorElement()));
      if (src.hasLowerLimit()) tgt.setLowerLimitElement(Decimal30_40.convertDecimal(src.getLowerLimitElement()));
      if (src.hasUpperLimit()) tgt.setUpperLimitElement(Decimal30_40.convertDecimal(src.getUpperLimitElement()));
      if (src.hasDimensions()) tgt.setDimensionsElement(PositiveInt30_40.convertPositiveInt(src.getDimensionsElement()));
      if (src.hasData()) tgt.setDataElement(String30_40.convertString(src.getDataElement()));
      return tgt;
    }
}
