package org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N;

import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Quantity40_N;
import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.exceptions.FHIRException;

public class Decimal40_N {
  public static org.hl7.fhir.model.core.DecimalType convertDecimal(org.hl7.fhir.r4.model.DecimalType src) throws FHIRException {
    org.hl7.fhir.model.core.DecimalType tgt = src.hasValue() ? new org.hl7.fhir.model.core.DecimalType(src.getValueAsString()) : new org.hl7.fhir.model.core.DecimalType();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.DecimalType convertDecimal(org.hl7.fhir.model.core.DecimalType src) throws FHIRException {
    org.hl7.fhir.r4.model.DecimalType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.DecimalType(src.getValueAsString()) : new org.hl7.fhir.r4.model.DecimalType();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    return tgt;
  }

  /**
   * For R4 decimals that became R6 Quantities: the decimal is the value (the R4 decimal doesn't say what the units are),
   * unless the R6 quantity was kept whole on the decimal, in the extension url, by {@link #convertQuantityToDecimal}
   */
  public static org.hl7.fhir.model.core.Quantity convertDecimalToQuantity(org.hl7.fhir.r4.model.DecimalType src, String url) throws FHIRException {
    if (src.hasExtension(url) && src.getExtensionByUrl(url).getValue() instanceof org.hl7.fhir.r4.model.Quantity)
      return Quantity40_N.convertQuantity((org.hl7.fhir.r4.model.Quantity) src.getExtensionByUrl(url).getValue());
    org.hl7.fhir.model.core.Quantity tgt = new org.hl7.fhir.model.core.Quantity();
    if (src.hasValue()) {
      tgt.setValue(src.getValue());
    }
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt, url);
    return tgt;
  }

  /**
   * The reverse of {@link #convertDecimalToQuantity}: the value, and if the quantity has more than that (units, a
   * comparator), the whole quantity in the extension url on the decimal
   */
  public static org.hl7.fhir.r4.model.DecimalType convertQuantityToDecimal(org.hl7.fhir.model.core.Quantity src, String url) throws FHIRException {
    org.hl7.fhir.r4.model.DecimalType tgt = convertDecimal(src.getValueElement());
    if (src.hasComparator() || src.hasUnit() || src.hasSystem() || src.hasCode() || src.hasId() || src.hasExtension())
      tgt.addExtension(url, Quantity40_N.convertQuantity(src));
    return tgt;
  }
}
