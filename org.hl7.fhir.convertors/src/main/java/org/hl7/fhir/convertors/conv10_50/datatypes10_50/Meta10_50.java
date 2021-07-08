package org.hl7.fhir.convertors.conv10_50.datatypes10_50;

import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.Coding10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.Id10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.Instant10_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Meta10_50 {
    public static org.hl7.fhir.r5.model.Meta convertMeta(org.hl7.fhir.dstu2.model.Meta src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.r5.model.Meta tgt = new org.hl7.fhir.r5.model.Meta();
      Element10_50.copyElement(src, tgt);
      if (src.hasVersionIdElement()) tgt.setVersionIdElement(Id10_50.convertId(src.getVersionIdElement()));
      if (src.hasLastUpdatedElement()) tgt.setLastUpdatedElement(Instant10_50.convertInstant(src.getLastUpdatedElement()));
      for (org.hl7.fhir.dstu2.model.UriType t : src.getProfile()) tgt.addProfile(t.getValue());
      for (org.hl7.fhir.dstu2.model.Coding t : src.getSecurity()) tgt.addSecurity(Coding10_50.convertCoding(t));
      for (org.hl7.fhir.dstu2.model.Coding t : src.getTag()) tgt.addTag(Coding10_50.convertCoding(t));
      return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Meta convertMeta(org.hl7.fhir.r5.model.Meta src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu2.model.Meta tgt = new org.hl7.fhir.dstu2.model.Meta();
      Element10_50.copyElement(src, tgt);
      if (src.hasVersionIdElement()) tgt.setVersionIdElement(Id10_50.convertId(src.getVersionIdElement()));
      if (src.hasLastUpdatedElement()) tgt.setLastUpdatedElement(Instant10_50.convertInstant(src.getLastUpdatedElement()));
      for (org.hl7.fhir.r5.model.UriType t : src.getProfile()) tgt.addProfile(t.getValue());
      for (org.hl7.fhir.r5.model.Coding t : src.getSecurity()) tgt.addSecurity(Coding10_50.convertCoding(t));
      for (org.hl7.fhir.r5.model.Coding t : src.getTag()) tgt.addTag(Coding10_50.convertCoding(t));
      return tgt;
    }
}
