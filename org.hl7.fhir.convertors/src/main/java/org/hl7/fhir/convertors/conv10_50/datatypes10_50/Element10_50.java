package org.hl7.fhir.convertors.conv10_50.datatypes10_50;

import org.hl7.fhir.convertors.conv10_50.VersionConvertor_10_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Element10_50 {
    public static void copyElement(org.hl7.fhir.dstu2.model.Element src, org.hl7.fhir.r5.model.Element tgt, String... extensionsToIgnore) throws FHIRException {
      tgt.setId(src.getId());
      for (org.hl7.fhir.dstu2.model.Extension e : src.getExtension()) {
        if (!VersionConvertor_10_50.isExemptExtension(e.getUrl(), extensionsToIgnore)) {
          tgt.addExtension(Extension10_50.convertExtension(e));
        }
      }
    }

    public static void copyElement(org.hl7.fhir.r5.model.Element src, org.hl7.fhir.dstu2.model.Element tgt, String... extensionsToIgnore) throws FHIRException {
      tgt.setId(src.getId());
      for (org.hl7.fhir.r5.model.Extension e : src.getExtension()) {
        if (!VersionConvertor_10_50.isExemptExtension(e.getUrl(), extensionsToIgnore)) {
          tgt.addExtension(Extension10_50.convertExtension(e));
        }
      }
    }

    public static void copyElement(org.hl7.fhir.r5.model.DomainResource src, org.hl7.fhir.dstu2.model.Element tgt, String... extensionsToIgnore) throws FHIRException {
      tgt.setId(src.getId());
      for (org.hl7.fhir.r5.model.Extension e : src.getExtension()) {
        if (!VersionConvertor_10_50.isExemptExtension(e.getUrl(), extensionsToIgnore)) {
          tgt.addExtension(Extension10_50.convertExtension(e));
        }
      }
    }
}
