package org.hl7.fhir.convertors.conv14_50.datatypes14_50;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.utilities.Utilities;

public class Element14_50 {
    static public void copyElement(org.hl7.fhir.dstu2016may.model.Element src, org.hl7.fhir.r5.model.Element tgt, String... exemptExtensions) throws FHIRException {
      if (src.hasId()) tgt.setId(src.getId());
      for (org.hl7.fhir.dstu2016may.model.Extension e : src.getExtension()) {
        if (!Utilities.existsInList(e.getUrl(), exemptExtensions) && !Extension14_50.mappedExtension(e.getUrl().toString()))
          tgt.addExtension(Extension14_50.convertExtension(e));
      }
    }

    static public void copyElement(org.hl7.fhir.r5.model.Element src, org.hl7.fhir.dstu2016may.model.Element tgt, String... exemptExtensions) throws FHIRException {
      if (src.hasId()) tgt.setId(src.getId());
      for (org.hl7.fhir.r5.model.Extension e : src.getExtension()) {
        if (!Utilities.existsInList(e.getUrl(), exemptExtensions)) {
          tgt.addExtension(Extension14_50.convertExtension(e));
        }
      }
    }
}
