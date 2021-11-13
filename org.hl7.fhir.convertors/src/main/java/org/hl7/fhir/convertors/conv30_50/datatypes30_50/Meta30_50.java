package org.hl7.fhir.convertors.conv30_50.datatypes30_50;

import org.hl7.fhir.convertors.context.ConversionContext30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Coding30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.Id30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.Instant30_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Meta30_50 {
  public static org.hl7.fhir.r5.model.Meta convertMeta(org.hl7.fhir.dstu3.model.Meta src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.Meta tgt = new org.hl7.fhir.r5.model.Meta();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.hasVersionId()) tgt.setVersionIdElement(Id30_50.convertId(src.getVersionIdElement()));
    if (src.hasLastUpdated()) tgt.setLastUpdatedElement(Instant30_50.convertInstant(src.getLastUpdatedElement()));
    for (org.hl7.fhir.dstu3.model.UriType t : src.getProfile()) tgt.addProfile(t.getValue());
    for (org.hl7.fhir.dstu3.model.Coding t : src.getSecurity()) tgt.addSecurity(Coding30_50.convertCoding(t));
    for (org.hl7.fhir.dstu3.model.Coding t : src.getTag()) tgt.addTag(Coding30_50.convertCoding(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Meta convertMeta(org.hl7.fhir.r5.model.Meta src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.dstu3.model.Meta tgt = new org.hl7.fhir.dstu3.model.Meta();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.hasVersionId()) tgt.setVersionIdElement(Id30_50.convertId(src.getVersionIdElement()));
    if (src.hasLastUpdated()) tgt.setLastUpdatedElement(Instant30_50.convertInstant(src.getLastUpdatedElement()));
    for (org.hl7.fhir.r5.model.UriType t : src.getProfile()) tgt.addProfile(t.getValue());
    for (org.hl7.fhir.r5.model.Coding t : src.getSecurity()) tgt.addSecurity(Coding30_50.convertCoding(t));
    for (org.hl7.fhir.r5.model.Coding t : src.getTag()) tgt.addTag(Coding30_50.convertCoding(t));
    return tgt;
  }
}
