package org.hl7.fhir.convertors.conv30_50.datatypes30_50;

import org.hl7.fhir.exceptions.FHIRException;

public class Element30_50 {
    static public void copyElement(org.hl7.fhir.dstu3.model.Element src, org.hl7.fhir.r5.model.Element tgt, String... extensionsToIgnore) throws FHIRException {
      if (src.hasId()) tgt.setId(src.getId());
      for (org.hl7.fhir.dstu3.model.Extension e : src.getExtension()) {
        if (!Extension30_50.isExemptExtension(e.getUrl(), extensionsToIgnore)) {
          tgt.addExtension(Extension30_50.convertExtension(e));
        }
      }
    }

    static public void copyElement(org.hl7.fhir.r5.model.Element src, org.hl7.fhir.dstu3.model.Element tgt, String... extensionsToIgnore) throws FHIRException {
      if (src.hasId()) tgt.setId(src.getId());
      for (org.hl7.fhir.r5.model.Extension e : src.getExtension()) {
        if (!Extension30_50.isExemptExtension(e.getUrl(), extensionsToIgnore)) {
          tgt.addExtension(Extension30_50.convertExtension(e));
        }
      }
    }
}
