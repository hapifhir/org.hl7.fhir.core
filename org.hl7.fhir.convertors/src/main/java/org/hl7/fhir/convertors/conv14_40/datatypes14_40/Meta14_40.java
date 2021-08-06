package org.hl7.fhir.convertors.conv14_40.datatypes14_40;

import org.hl7.fhir.convertors.context.ConversionContext14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.complextypes14_40.Coding14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.primitivetypes14_40.Id14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.primitivetypes14_40.Instant14_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Meta14_40 {
  public static org.hl7.fhir.r4.model.Meta convertMeta(org.hl7.fhir.dstu2016may.model.Meta src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4.model.Meta tgt = new org.hl7.fhir.r4.model.Meta();
    ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
    if (src.hasVersionId()) tgt.setVersionIdElement(Id14_40.convertId(src.getVersionIdElement()));
    if (src.hasLastUpdated()) tgt.setLastUpdatedElement(Instant14_40.convertInstant(src.getLastUpdatedElement()));
    for (org.hl7.fhir.dstu2016may.model.UriType t : src.getProfile()) tgt.addProfile(t.getValue());
    for (org.hl7.fhir.dstu2016may.model.Coding t : src.getSecurity()) tgt.addSecurity(Coding14_40.convertCoding(t));
    for (org.hl7.fhir.dstu2016may.model.Coding t : src.getTag()) tgt.addTag(Coding14_40.convertCoding(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.Meta convertMeta(org.hl7.fhir.r4.model.Meta src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2016may.model.Meta tgt = new org.hl7.fhir.dstu2016may.model.Meta();
    ConversionContext14_40.INSTANCE.getVersionConvertor_14_40().copyElement(src, tgt);
    if (src.hasVersionId()) tgt.setVersionIdElement(Id14_40.convertId(src.getVersionIdElement()));
    if (src.hasLastUpdated()) tgt.setLastUpdatedElement(Instant14_40.convertInstant(src.getLastUpdatedElement()));
    for (org.hl7.fhir.r4.model.UriType t : src.getProfile()) tgt.addProfile(t.getValue());
    for (org.hl7.fhir.r4.model.Coding t : src.getSecurity()) tgt.addSecurity(Coding14_40.convertCoding(t));
    for (org.hl7.fhir.r4.model.Coding t : src.getTag()) tgt.addTag(Coding14_40.convertCoding(t));
    return tgt;
  }
}
