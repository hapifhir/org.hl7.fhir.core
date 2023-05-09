package org.hl7.fhir.convertors.conv10_50.datatypes10_50;

import org.hl7.fhir.convertors.context.ConversionContext10_50;
import org.hl7.fhir.exceptions.FHIRException;

public class BackboneElement10_50 {
  static public void copyBackboneElement(
    org.hl7.fhir.dstu2.model.BackboneElement src,
    org.hl7.fhir.r5.model.BackboneElement tgt,
    String ... extensionUrlsToIgnore) throws FHIRException {
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt, extensionUrlsToIgnore);
    for (org.hl7.fhir.dstu2.model.Extension e : src.getModifierExtension()) {
      tgt.addModifierExtension(Extension10_50.convertExtension(e));
    }
  }

  static public void copyBackboneElement(
    org.hl7.fhir.r5.model.BackboneElement src,
    org.hl7.fhir.dstu2.model.BackboneElement tgt,
    String ... extensionUrlsToIgnore) throws FHIRException {
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt, extensionUrlsToIgnore);
    for (org.hl7.fhir.r5.model.Extension e : src.getModifierExtension()) {
      tgt.addModifierExtension(Extension10_50.convertExtension(e));
    }
  }
}
