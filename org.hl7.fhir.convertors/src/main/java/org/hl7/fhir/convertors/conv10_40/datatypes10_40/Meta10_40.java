package org.hl7.fhir.convertors.conv10_40.datatypes10_40;

import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.Coding10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.Id10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.Instant10_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Meta10_40 {
    public static org.hl7.fhir.r4.model.Meta convertMeta(org.hl7.fhir.dstu2.model.Meta src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.r4.model.Meta tgt = new org.hl7.fhir.r4.model.Meta();
      Element10_40.copyElement(src, tgt);
      if (src.hasVersionIdElement()) tgt.setVersionIdElement(Id10_40.convertId(src.getVersionIdElement()));
      if (src.hasLastUpdatedElement()) tgt.setLastUpdatedElement(Instant10_40.convertInstant(src.getLastUpdatedElement()));
      for (org.hl7.fhir.dstu2.model.UriType t : src.getProfile()) tgt.addProfile(t.getValue());
      for (org.hl7.fhir.dstu2.model.Coding t : src.getSecurity()) tgt.addSecurity(Coding10_40.convertCoding(t));
      for (org.hl7.fhir.dstu2.model.Coding t : src.getTag()) tgt.addTag(Coding10_40.convertCoding(t));
      return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Meta convertMeta(org.hl7.fhir.r4.model.Meta src) throws FHIRException {
      if (src == null || src.isEmpty()) return null;
      org.hl7.fhir.dstu2.model.Meta tgt = new org.hl7.fhir.dstu2.model.Meta();
      Element10_40.copyElement(src, tgt);
      if (src.hasVersionIdElement()) tgt.setVersionIdElement(Id10_40.convertId(src.getVersionIdElement()));
      if (src.hasLastUpdatedElement()) tgt.setLastUpdatedElement(Instant10_40.convertInstant(src.getLastUpdatedElement()));
      for (org.hl7.fhir.r4.model.UriType t : src.getProfile()) tgt.addProfile(t.getValue());
      for (org.hl7.fhir.r4.model.Coding t : src.getSecurity()) tgt.addSecurity(Coding10_40.convertCoding(t));
      for (org.hl7.fhir.r4.model.Coding t : src.getTag()) tgt.addTag(Coding10_40.convertCoding(t));
      return tgt;
    }
}
