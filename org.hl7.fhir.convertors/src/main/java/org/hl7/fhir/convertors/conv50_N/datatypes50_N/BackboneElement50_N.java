package org.hl7.fhir.convertors.conv50_N.datatypes50_N;

import java.util.Arrays;

import org.hl7.fhir.convertors.context.ConversionContext50_N;
import org.hl7.fhir.convertors.conv50_N.datatypes50_N.special50_N.Extension50_N;
import org.hl7.fhir.exceptions.FHIRException;

public class BackboneElement50_N {
  public static void copyBackboneElement(org.hl7.fhir.r5.model.BackboneElement src, org.hl7.fhir.model.core.BackboneElement tgt, String ... extensionUrlsToIgnore) throws FHIRException {
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt, extensionUrlsToIgnore);
    for (org.hl7.fhir.r5.model.Extension e : src.getModifierExtension()) {
      if (!isExemptExtension(e.getUrl(), extensionUrlsToIgnore)) {
        tgt.addModifierExtension(Extension50_N.convertExtension(e));
      }
    }
  }

  public static boolean isExemptExtension(String url, String[] extensionsToIgnore) {
    return Arrays.asList(extensionsToIgnore).contains(url);
  }
  
  public static void copyBackboneElement(org.hl7.fhir.model.core.BackboneElement src, org.hl7.fhir.r5.model.BackboneElement tgt, String... extensionUrlsToIgnore) throws FHIRException {
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt, extensionUrlsToIgnore);
    for (org.hl7.fhir.model.core.Extension e : src.getModifierExtensionList()) {
      if (!isExemptExtension(e.getUrl(), extensionUrlsToIgnore)) {
        tgt.addModifierExtension(Extension50_N.convertExtension(e));
      }
    }
  }

  public static void copyBackboneElement(org.hl7.fhir.model.core.BackboneType src, org.hl7.fhir.r5.model.BackboneType tgt, String... var) throws FHIRException {
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt, var);
    for (org.hl7.fhir.model.core.Extension e : src.getModifierExtensionList()) {
      tgt.addModifierExtension(Extension50_N.convertExtension(e));
    }
  }

  public static void copyBackboneElement(org.hl7.fhir.r5.model.BackboneType src, org.hl7.fhir.model.core.BackboneType tgt, String... var) throws FHIRException {
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt, var);
    for (org.hl7.fhir.r5.model.Extension e : src.getModifierExtension()) {
      tgt.addModifierExtension(Extension50_N.convertExtension(e));
    }
  }
}
