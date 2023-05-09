package org.hl7.fhir.convertors.conv14_50.datatypes14_50;

import org.hl7.fhir.convertors.context.ConversionContext14_50;
import org.hl7.fhir.exceptions.FHIRException;

public class BackboneElement14_50 {
  static public void copyBackboneElement(
    org.hl7.fhir.dstu2016may.model.BackboneElement src,
    org.hl7.fhir.r5.model.BackboneElement tgt,
    String... extensionUrlsToIgnore) throws FHIRException {
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt, extensionUrlsToIgnore);
    for (org.hl7.fhir.dstu2016may.model.Extension e : src.getModifierExtension()) {
      tgt.addModifierExtension(Extension14_50.convertExtension(e));
    }
  }

  static public void copyBackboneElement(
    org.hl7.fhir.r5.model.BackboneElement src,
    org.hl7.fhir.dstu2016may.model.BackboneElement tgt,
    String... extensionUrlsToIgnore) throws FHIRException {
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt, extensionUrlsToIgnore);
    for (org.hl7.fhir.r5.model.Extension e : src.getModifierExtension()) {
      tgt.addModifierExtension(Extension14_50.convertExtension(e));
    }
  }
}
