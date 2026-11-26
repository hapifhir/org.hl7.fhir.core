package org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.CrossVersionElements40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Decimal40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.PositiveInt40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.String40_N;
import org.hl7.fhir.exceptions.FHIRException;

public class SampledData40_N {

  private static boolean isMilliseconds(org.hl7.fhir.model.core.SampledData src) {
    return !src.hasIntervalUnit() || "ms".equals(src.getIntervalUnit());
  }
  public static org.hl7.fhir.model.core.SampledData convertSampledData(org.hl7.fhir.r4.model.SampledData src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.SampledData tgt = new org.hl7.fhir.model.core.SampledData();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt, CrossVersionElements40_N.urls("SampledData", "5.0", new String[] {"interval", "intervalUnit", "codeMap", "offsets"}, CrossVersionElements40_N.urls("SampledData", "6.0", new String[] {})));
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "5.0", "interval", "intervalUnit", "codeMap", "offsets");
    if (src.hasOrigin()) tgt.setOrigin(SimpleQuantity40_N.convertSimpleQuantity(src.getOrigin()));
    if (src.hasPeriod()) {
      tgt.setIntervalElement(Decimal40_N.convertDecimal(src.getPeriodElement()));
      tgt.setIntervalUnit("ms");
    }
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
    CrossVersionElements40_N.elementsToExtensions(src, tgt.getExtension(), "5.0", "codeMap", "offsets");
    // R4 period is the interval in milliseconds: any other unit stays in R6 terms, in the extensions
    if (src.hasInterval() && !isMilliseconds(src))
      CrossVersionElements40_N.elementsToExtensions(src, tgt.getExtension(), "5.0", "interval", "intervalUnit");
    if (src.hasOrigin()) tgt.setOrigin(SimpleQuantity40_N.convertSimpleQuantity(src.getOrigin()));
    if (src.hasInterval() && isMilliseconds(src)) tgt.setPeriodElement(Decimal40_N.convertDecimal(src.getIntervalElement()));
    if (src.hasFactor()) tgt.setFactorElement(Decimal40_N.convertDecimal(src.getFactorElement()));
    if (src.hasLowerLimit()) tgt.setLowerLimitElement(Decimal40_N.convertDecimal(src.getLowerLimitElement()));
    if (src.hasUpperLimit()) tgt.setUpperLimitElement(Decimal40_N.convertDecimal(src.getUpperLimitElement()));
    if (src.hasDimensions()) tgt.setDimensionsElement(PositiveInt40_N.convertPositiveInt(src.getDimensionsElement()));
    if (src.hasData()) tgt.setDataElement(String40_N.convertString(src.getDataElement()));
    return tgt;
  }
}
