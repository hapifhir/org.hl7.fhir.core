package org.hl7.fhir.convertors.conv14_50.datatypes14_50;

import org.hl7.fhir.convertors.context.ConversionContext14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.complextypes14_50.Coding14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50.Id14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50.Instant14_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Meta14_50 {
  public static org.hl7.fhir.r5.model.Meta convertMeta(org.hl7.fhir.dstu2016may.model.Meta src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.Meta tgt = new org.hl7.fhir.r5.model.Meta();
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
    if (src.hasVersionId()) tgt.setVersionIdElement(Id14_50.convertId(src.getVersionIdElement()));
    if (src.hasLastUpdated()) tgt.setLastUpdatedElement(Instant14_50.convertInstant(src.getLastUpdatedElement()));
    for (org.hl7.fhir.dstu2016may.model.UriType t : src.getProfile()) tgt.addProfile(t.getValue());
    for (org.hl7.fhir.dstu2016may.model.Coding t : src.getSecurity()) tgt.addSecurity(Coding14_50.convertCoding(t));
    for (org.hl7.fhir.dstu2016may.model.Coding t : src.getTag()) tgt.addTag(Coding14_50.convertCoding(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.Meta convertMeta(org.hl7.fhir.r5.model.Meta src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2016may.model.Meta tgt = new org.hl7.fhir.dstu2016may.model.Meta();
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
    if (src.hasVersionId()) tgt.setVersionIdElement(Id14_50.convertId(src.getVersionIdElement()));
    if (src.hasLastUpdated()) tgt.setLastUpdatedElement(Instant14_50.convertInstant(src.getLastUpdatedElement()));
    for (org.hl7.fhir.r5.model.UriType t : src.getProfile()) tgt.addProfile(t.getValue());
    for (org.hl7.fhir.r5.model.Coding t : src.getSecurity()) tgt.addSecurity(Coding14_50.convertCoding(t));
    for (org.hl7.fhir.r5.model.Coding t : src.getTag()) tgt.addTag(Coding14_50.convertCoding(t));
    return tgt;
  }
}
