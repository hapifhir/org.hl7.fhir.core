package org.hl7.fhir.convertors.conv43_N.datatypes43_N;

import java.util.Arrays;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.special43_N.Extension43_N;
import org.hl7.fhir.exceptions.FHIRException;

public class BackboneElement43_N {
  public static void copyBackboneElement(org.hl7.fhir.r4b.model.BackboneElement src, org.hl7.fhir.model.core.BackboneElement tgt, String ... extensionUrlsToIgnore) throws FHIRException {
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt, extensionUrlsToIgnore);
    for (org.hl7.fhir.r4b.model.Extension e : src.getModifierExtension()) {
      if (!isExemptExtension(e.getUrl(), extensionUrlsToIgnore)) {
        tgt.addModifierExtension(Extension43_N.convertExtension(e));
      }
    }
  }

  public static boolean isExemptExtension(String url, String[] extensionsToIgnore) {
    return Arrays.asList(extensionsToIgnore).contains(url);
  }
  
  public static void copyBackboneElement(org.hl7.fhir.model.core.BackboneElement src, org.hl7.fhir.r4b.model.BackboneElement tgt, String... extensionUrlsToIgnore) throws FHIRException {
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt, extensionUrlsToIgnore);
    for (org.hl7.fhir.model.core.Extension e : src.getModifierExtensionList()) {
      if (!isExemptExtension(e.getUrl(), extensionUrlsToIgnore)) {
        tgt.addModifierExtension(Extension43_N.convertExtension(e));
      }
    }
  }

  public static void copyBackboneElement(org.hl7.fhir.model.core.BackboneType src, org.hl7.fhir.r4b.model.BackboneType tgt, String... var) throws FHIRException {
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt, var);
    for (org.hl7.fhir.model.core.Extension e : src.getModifierExtensionList()) {
      tgt.addModifierExtension(Extension43_N.convertExtension(e));
    }
  }

  public static void copyBackboneElement(org.hl7.fhir.r4b.model.BackboneType src, org.hl7.fhir.model.core.BackboneType tgt, String... var) throws FHIRException {
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt, var);
    for (org.hl7.fhir.r4b.model.Extension e : src.getModifierExtension()) {
      tgt.addModifierExtension(Extension43_N.convertExtension(e));
    }
  }
}
