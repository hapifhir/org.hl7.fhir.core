package org.hl7.fhir.convertors.conv10_30.datatypes10_30;

import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.Coding10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.Id10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.Instant10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class Meta10_30 {
    public static org.hl7.fhir.dstu3.model.Meta convertMeta(org.hl7.fhir.dstu2.model.Meta src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu3.model.Meta tgt = new org.hl7.fhir.dstu3.model.Meta();
      Element10_30.copyElement(src, tgt);
      if (src.hasVersionIdElement()) tgt.setVersionIdElement(Id10_30.convertId(src.getVersionIdElement()));
      if (src.hasLastUpdatedElement()) tgt.setLastUpdatedElement(Instant10_30.convertInstant(src.getLastUpdatedElement()));
      for (org.hl7.fhir.dstu2.model.UriType t : src.getProfile()) tgt.addProfile(t.getValue());
      for (org.hl7.fhir.dstu2.model.Coding t : src.getSecurity()) tgt.addSecurity(Coding10_30.convertCoding(t));
      for (org.hl7.fhir.dstu2.model.Coding t : src.getTag()) tgt.addTag(Coding10_30.convertCoding(t));
      return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Meta convertMeta(org.hl7.fhir.dstu3.model.Meta src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu2.model.Meta tgt = new org.hl7.fhir.dstu2.model.Meta();
      Element10_30.copyElement(src, tgt);
      if (src.hasVersionIdElement()) tgt.setVersionIdElement(Id10_30.convertId(src.getVersionIdElement()));
      if (src.hasLastUpdatedElement()) tgt.setLastUpdatedElement(Instant10_30.convertInstant(src.getLastUpdatedElement()));
      for (org.hl7.fhir.dstu3.model.UriType t : src.getProfile()) tgt.addProfile(t.getValue());
      for (org.hl7.fhir.dstu3.model.Coding t : src.getSecurity()) tgt.addSecurity(Coding10_30.convertCoding(t));
      for (org.hl7.fhir.dstu3.model.Coding t : src.getTag()) tgt.addTag(Coding10_30.convertCoding(t));
      return tgt;
    }
}
