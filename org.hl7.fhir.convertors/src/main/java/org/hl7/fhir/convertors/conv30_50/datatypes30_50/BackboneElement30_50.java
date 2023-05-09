package org.hl7.fhir.convertors.conv30_50.datatypes30_50;

import org.hl7.fhir.convertors.context.ConversionContext30_50;
import org.hl7.fhir.exceptions.FHIRException;

public class BackboneElement30_50 {
  static public void copyBackboneElement(org.hl7.fhir.dstu3.model.BackboneElement src, org.hl7.fhir.r5.model.BackboneElement tgt, String ... extensionUrlsToIgnore) throws FHIRException {
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src,tgt, extensionUrlsToIgnore);
    for (org.hl7.fhir.dstu3.model.Extension e : src.getModifierExtension()) {
      tgt.addModifierExtension(Extension30_50.convertExtension(e));
    }
  }

  static public void copyBackboneElement(org.hl7.fhir.r5.model.BackboneElement src, org.hl7.fhir.dstu3.model.BackboneElement tgt, String ... extensionUrlsToIgnore) throws FHIRException {
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt, extensionUrlsToIgnore);
    for (org.hl7.fhir.r5.model.Extension e : src.getModifierExtension()) {
      tgt.addModifierExtension(Extension30_50.convertExtension(e));
    }
  }
}
