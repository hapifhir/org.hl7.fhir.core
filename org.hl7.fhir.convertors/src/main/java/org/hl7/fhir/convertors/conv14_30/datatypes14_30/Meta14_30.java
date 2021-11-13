package org.hl7.fhir.convertors.conv14_30.datatypes14_30;

import org.hl7.fhir.convertors.context.ConversionContext14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.primitivetypes14_30.Code14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.primitivetypes14_30.Id14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.primitivetypes14_30.Instant14_30;
import org.hl7.fhir.exceptions.FHIRException;

public class Meta14_30 {
  public static org.hl7.fhir.dstu3.model.Meta convertMeta(org.hl7.fhir.dstu2016may.model.Meta src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu3.model.Meta tgt = new org.hl7.fhir.dstu3.model.Meta();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    if (src.hasVersionId()) tgt.setVersionIdElement(Id14_30.convertId(src.getVersionIdElement()));
    if (src.hasLastUpdated()) tgt.setLastUpdatedElement(Instant14_30.convertInstant(src.getLastUpdatedElement()));
    for (org.hl7.fhir.dstu2016may.model.UriType t : src.getProfile()) tgt.addProfile(t.getValue());
    for (org.hl7.fhir.dstu2016may.model.Coding t : src.getSecurity()) tgt.addSecurity(Code14_30.convertCoding(t));
    for (org.hl7.fhir.dstu2016may.model.Coding t : src.getTag()) tgt.addTag(Code14_30.convertCoding(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.Meta convertMeta(org.hl7.fhir.dstu3.model.Meta src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2016may.model.Meta tgt = new org.hl7.fhir.dstu2016may.model.Meta();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    if (src.hasVersionId()) tgt.setVersionIdElement(Id14_30.convertId(src.getVersionIdElement()));
    if (src.hasLastUpdated()) tgt.setLastUpdatedElement(Instant14_30.convertInstant(src.getLastUpdatedElement()));
    for (org.hl7.fhir.dstu3.model.UriType t : src.getProfile()) tgt.addProfile(t.getValue());
    for (org.hl7.fhir.dstu3.model.Coding t : src.getSecurity()) tgt.addSecurity(Code14_30.convertCoding(t));
    for (org.hl7.fhir.dstu3.model.Coding t : src.getTag()) tgt.addTag(Code14_30.convertCoding(t));
    return tgt;
  }
}
