package org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.CrossVersionElements40_N;
import org.hl7.fhir.exceptions.FHIRException;

public class Date40_N {
  public static org.hl7.fhir.model.core.DateType convertDate(org.hl7.fhir.r4.model.DateType src) throws FHIRException {
    org.hl7.fhir.model.core.DateType tgt = src.hasValue() ? new org.hl7.fhir.model.core.DateType(src.getValueAsString()) : new org.hl7.fhir.model.core.DateType();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.DateType convertDate(org.hl7.fhir.model.core.DateType src) throws FHIRException {
    org.hl7.fhir.r4.model.DateType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.DateType(src.getValueAsString()) : new org.hl7.fhir.r4.model.DateType();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.model.core.DateTimeType convertDatetoDateTime(org.hl7.fhir.r4.model.DateType src) {
    org.hl7.fhir.model.core.DateTimeType tgt = src.hasValue() ? new org.hl7.fhir.model.core.DateTimeType(src.getValueAsString()) : new org.hl7.fhir.model.core.DateTimeType();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.DateType convertDateTimeToDate(org.hl7.fhir.model.core.DateTimeType src) {
    org.hl7.fhir.r4.model.DateType tgt = src.hasValue() ? new org.hl7.fhir.r4.model.DateType(src.getValueAsString()) : new org.hl7.fhir.r4.model.DateType();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    return tgt;
  }

  /**
   * R6 dateTime to R4 date for path.name: a value with more precision than a date goes to R4 as its date, and
   * the full value in a cross-version extension (version: the version that made it a dateTime)
   */
  public static org.hl7.fhir.r4.model.DateType convertDateTimeToDate(org.hl7.fhir.model.core.DateTimeType src, String path, String version, String name) {
    if (!src.hasValue() || src.getValueAsString().length() <= 10)
      return convertDateTimeToDate(src);
    org.hl7.fhir.r4.model.DateType tgt = new org.hl7.fhir.r4.model.DateType(src.getValueAsString().substring(0, 10));
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    tgt.addExtension(CrossVersionElements40_N.url(path, version, name), new org.hl7.fhir.r4.model.DateTimeType(src.getValueAsString()));
    return tgt;
  }

  /**
   * R4 to R6: the reverse of {@link #convertDateTimeToDate(org.hl7.fhir.model.core.DateTimeType, String, String, String)}
   */
  public static org.hl7.fhir.model.core.DateTimeType convertDatetoDateTime(org.hl7.fhir.r4.model.DateType src, String path, String version, String name) {
    org.hl7.fhir.model.core.DateTimeType tgt = convertDatetoDateTime(src);
    String url = CrossVersionElements40_N.url(path, version, name);
    if (tgt.hasExtension(url)) {
      tgt.setValueAsString(tgt.getExtensionByUrl(url).getValue().primitiveValue());
      tgt.getExtension().removeIf(e -> url.equals(e.getUrl()));
    }
    return tgt;
  }
}
