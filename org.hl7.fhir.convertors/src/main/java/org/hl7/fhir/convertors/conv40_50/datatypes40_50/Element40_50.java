package org.hl7.fhir.convertors.conv40_50.datatypes40_50;

import org.hl7.fhir.convertors.VersionConvertor_40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.special40_50.Extension40_50;
import org.hl7.fhir.exceptions.FHIRException;

import java.util.Arrays;

public class Element40_50 {
  public static void copyElement(org.hl7.fhir.r4.model.Element src, org.hl7.fhir.r5.model.Element tgt, String... extensionsToIgnore) throws FHIRException {
    if (src.hasId()) tgt.setId(src.getId());
    for (org.hl7.fhir.r4.model.Extension e : src.getExtension()) {
      if (!isExemptExtension(e.getUrl(), extensionsToIgnore)) {
        tgt.addExtension(Extension40_50.convertExtension(e));
      }
    }
  }

  public static void copyElement(org.hl7.fhir.r5.model.Element src, org.hl7.fhir.r4.model.Element tgt, String... extensionsToIgnore) throws FHIRException {
    if (src.hasId()) tgt.setId(src.getId());
    for (org.hl7.fhir.r5.model.Extension e : src.getExtension()) {
      if (!isExemptExtension(e.getUrl(), extensionsToIgnore)) {
        tgt.addExtension(Extension40_50.convertExtension(e));
      }
    }
  }

  static public boolean isExemptExtension(String url, String[] extensionsToIgnore) {
    return Arrays.asList(extensionsToIgnore).contains(url);
  }
}
