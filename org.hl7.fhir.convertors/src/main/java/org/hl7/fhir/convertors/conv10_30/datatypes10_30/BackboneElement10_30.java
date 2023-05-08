package org.hl7.fhir.convertors.conv10_30.datatypes10_30;

import org.hl7.fhir.convertors.context.ConversionContext10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class BackboneElement10_30 {
  static public void copyBackboneElement(
    org.hl7.fhir.dstu2.model.BackboneElement src,
    org.hl7.fhir.dstu3.model.BackboneElement tgt,
    String ... extensionUrlsToIgnore) throws FHIRException {
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt, extensionUrlsToIgnore);
    for (org.hl7.fhir.dstu2.model.Extension e : src.getModifierExtension()) {
      tgt.addModifierExtension(Extension10_30.convertExtension(e));
    }
  }

  static public void copyBackboneElement(
    org.hl7.fhir.dstu3.model.BackboneElement src,
    org.hl7.fhir.dstu2.model.BackboneElement tgt,
    String ... extensionUrlsToIgnore) throws FHIRException {
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt, extensionUrlsToIgnore);
    for (org.hl7.fhir.dstu3.model.Extension e : src.getModifierExtension()) {
      tgt.addModifierExtension(Extension10_30.convertExtension(e));
    }
  }
}
