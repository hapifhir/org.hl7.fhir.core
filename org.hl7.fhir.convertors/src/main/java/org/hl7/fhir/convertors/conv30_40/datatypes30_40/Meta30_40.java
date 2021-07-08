package org.hl7.fhir.convertors.conv30_40.datatypes30_40;

import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Coding30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.Id30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.Instant30_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Meta30_40 {
    public static org.hl7.fhir.r4.model.Meta convertMeta(org.hl7.fhir.dstu3.model.Meta src) throws FHIRException {
      if (src == null) return null;
      org.hl7.fhir.r4.model.Meta tgt = new org.hl7.fhir.r4.model.Meta();
      Element30_40.copyElement(src, tgt);
      if (src.hasVersionId()) tgt.setVersionIdElement(Id30_40.convertId(src.getVersionIdElement()));
      if (src.hasLastUpdated()) tgt.setLastUpdatedElement(Instant30_40.convertInstant(src.getLastUpdatedElement()));
      for (org.hl7.fhir.dstu3.model.UriType t : src.getProfile()) tgt.addProfile(t.getValue());
      for (org.hl7.fhir.dstu3.model.Coding t : src.getSecurity()) tgt.addSecurity(Coding30_40.convertCoding(t));
      for (org.hl7.fhir.dstu3.model.Coding t : src.getTag()) tgt.addTag(Coding30_40.convertCoding(t));
      return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Meta convertMeta(org.hl7.fhir.r4.model.Meta src) throws FHIRException {
      if (src == null) return null;
      org.hl7.fhir.dstu3.model.Meta tgt = new org.hl7.fhir.dstu3.model.Meta();
      Element30_40.copyElement(src, tgt);
      if (src.hasVersionId()) tgt.setVersionIdElement(Id30_40.convertId(src.getVersionIdElement()));
      if (src.hasLastUpdated()) tgt.setLastUpdatedElement(Instant30_40.convertInstant(src.getLastUpdatedElement()));
      for (org.hl7.fhir.r4.model.UriType t : src.getProfile()) tgt.addProfile(t.getValue());
      for (org.hl7.fhir.r4.model.Coding t : src.getSecurity()) tgt.addSecurity(Coding30_40.convertCoding(t));
      for (org.hl7.fhir.r4.model.Coding t : src.getTag()) tgt.addTag(Coding30_40.convertCoding(t));
      return tgt;
    }
}
