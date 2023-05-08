package org.hl7.fhir.convertors.conv14_30.datatypes14_30;

import org.hl7.fhir.convertors.context.ConversionContext14_30;
import org.hl7.fhir.exceptions.FHIRException;

public class BackboneElement14_30 {
  static public void copyBackboneElement(
    org.hl7.fhir.dstu2016may.model.BackboneElement src,
    org.hl7.fhir.dstu3.model.BackboneElement tgt,
    String ... extensionUrlsToIgnore) throws FHIRException {
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt, extensionUrlsToIgnore);
    for (org.hl7.fhir.dstu2016may.model.Extension e : src.getModifierExtension()) {
      tgt.addModifierExtension(Extension14_30.convertExtension(e));
    }
  }

  static public void copyBackboneElement(
    org.hl7.fhir.dstu3.model.BackboneElement src,
    org.hl7.fhir.dstu2016may.model.BackboneElement tgt,
    String ... extensionUrlsToIgnore) throws FHIRException {
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt, extensionUrlsToIgnore);
    for (org.hl7.fhir.dstu3.model.Extension e : src.getModifierExtension()) {
      tgt.addModifierExtension(Extension14_30.convertExtension(e));
    }
  }
}
