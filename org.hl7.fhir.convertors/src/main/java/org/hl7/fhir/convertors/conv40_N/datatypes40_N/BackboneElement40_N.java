package org.hl7.fhir.convertors.conv40_N.datatypes40_N;

import java.util.Arrays;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Extension40_N;
import org.hl7.fhir.exceptions.FHIRException;

public class BackboneElement40_N {
  public static void copyBackboneElement(org.hl7.fhir.r4.model.BackboneElement src, org.hl7.fhir.model.core.BackboneElement tgt, String ... extensionUrlsToIgnore) throws FHIRException {
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt, extensionUrlsToIgnore);
    for (org.hl7.fhir.r4.model.Extension e : src.getModifierExtension()) {
      if (!isExemptExtension(e.getUrl(), extensionUrlsToIgnore)) {
        tgt.addModifierExtension(Extension40_N.convertExtension(e));
      }
    }
  }

  public static boolean isExemptExtension(String url, String[] extensionsToIgnore) {
    return Arrays.asList(extensionsToIgnore).contains(url);
  }
  
  public static void copyBackboneElement(org.hl7.fhir.model.core.BackboneElement src, org.hl7.fhir.r4.model.BackboneElement tgt, String... extensionUrlsToIgnore) throws FHIRException {
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt, extensionUrlsToIgnore);
    for (org.hl7.fhir.model.core.Extension e : src.getModifierExtensionList()) {
      if (!isExemptExtension(e.getUrl(), extensionUrlsToIgnore)) {
        tgt.addModifierExtension(Extension40_N.convertExtension(e));
      }
    }
  }

  public static void copyBackboneElement(org.hl7.fhir.model.core.BackboneType src, org.hl7.fhir.r4.model.BackboneType tgt, String... var) throws FHIRException {
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt, var);
    for (org.hl7.fhir.model.core.Extension e : src.getModifierExtensionList()) {
      tgt.addModifierExtension(Extension40_N.convertExtension(e));
    }
  }

  public static void copyBackboneElement(org.hl7.fhir.r4.model.BackboneType src, org.hl7.fhir.model.core.BackboneType tgt, String... var) throws FHIRException {
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt, var);
    for (org.hl7.fhir.r4.model.Extension e : src.getModifierExtension()) {
      tgt.addModifierExtension(Extension40_N.convertExtension(e));
    }
  }
}
