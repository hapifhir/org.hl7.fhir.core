package org.hl7.fhir.convertors.conv43_50.datatypes43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.special43_50.Extension43_50;
import org.hl7.fhir.exceptions.FHIRException;

public class BackboneElement43_50 {
  public static void copyBackboneElement(org.hl7.fhir.r4b.model.BackboneElement src, org.hl7.fhir.r5.model.BackboneElement tgt, String ... extensionUrlsToIgnore) throws FHIRException {
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt, extensionUrlsToIgnore);
    for (org.hl7.fhir.r4b.model.Extension e : src.getModifierExtension()) {
      tgt.addModifierExtension(Extension43_50.convertExtension(e));
    }
  }

  public static void copyBackboneElement(org.hl7.fhir.r5.model.BackboneElement src, org.hl7.fhir.r4b.model.BackboneElement tgt, String... extensionUrlsToIgnore) throws FHIRException {
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt, extensionUrlsToIgnore);
    for (org.hl7.fhir.r5.model.Extension e : src.getModifierExtension()) {
      tgt.addModifierExtension(Extension43_50.convertExtension(e));
    }
  }

  public static void copyBackboneElement(org.hl7.fhir.r5.model.BackboneType src, org.hl7.fhir.r4b.model.BackboneType tgt, String... var) throws FHIRException {
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt, var);
    for (org.hl7.fhir.r5.model.Extension e : src.getModifierExtension()) {
      tgt.addModifierExtension(Extension43_50.convertExtension(e));
    }
  }

  public static void copyBackboneElement(org.hl7.fhir.r4b.model.BackboneType src, org.hl7.fhir.r5.model.BackboneType tgt, String... var) throws FHIRException {
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt, var);
    for (org.hl7.fhir.r4b.model.Extension e : src.getModifierExtension()) {
      tgt.addModifierExtension(Extension43_50.convertExtension(e));
    }
  }
}
