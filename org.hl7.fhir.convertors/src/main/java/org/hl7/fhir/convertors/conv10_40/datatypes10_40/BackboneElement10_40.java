package org.hl7.fhir.convertors.conv10_40.datatypes10_40;

import org.hl7.fhir.convertors.context.ConversionContext10_40;
import org.hl7.fhir.exceptions.FHIRException;

public class BackboneElement10_40 {
  static public void copyBackboneElement(
    org.hl7.fhir.dstu2.model.BackboneElement src,
    org.hl7.fhir.r4.model.BackboneElement tgt,
    String ... extensionUrlsToIgnore) throws FHIRException {
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt, extensionUrlsToIgnore);
    for (org.hl7.fhir.dstu2.model.Extension e : src.getModifierExtension()) {
      tgt.addModifierExtension(Extension10_40.convertExtension(e));
    }
  }

  static public void copyBackboneElement(
    org.hl7.fhir.r4.model.BackboneElement src,
    org.hl7.fhir.dstu2.model.BackboneElement tgt,
    String ... extensionUrlsToIgnore) throws FHIRException {
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt, extensionUrlsToIgnore);
    for (org.hl7.fhir.r4.model.Extension e : src.getModifierExtension()) {
      tgt.addModifierExtension(Extension10_40.convertExtension(e));
    }
  }
}
