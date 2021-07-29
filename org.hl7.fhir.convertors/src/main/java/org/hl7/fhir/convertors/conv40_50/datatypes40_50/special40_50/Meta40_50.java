package org.hl7.fhir.convertors.conv40_50.datatypes40_50.special40_50;

import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Coding40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Canonical40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Id40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Instant40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Uri40_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Meta40_50 {
  public static org.hl7.fhir.r5.model.Meta convertMeta(org.hl7.fhir.r4.model.Meta src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.Meta tgt = new org.hl7.fhir.r5.model.Meta();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasVersionId()) tgt.setVersionIdElement(Id40_50.convertId(src.getVersionIdElement()));
    if (src.hasLastUpdated()) tgt.setLastUpdatedElement(Instant40_50.convertInstant(src.getLastUpdatedElement()));
    if (src.hasSource()) tgt.setSourceElement(Uri40_50.convertUri(src.getSourceElement()));
    for (org.hl7.fhir.r4.model.CanonicalType t : src.getProfile())
      tgt.getProfile().add(Canonical40_50.convertCanonical(t));
    for (org.hl7.fhir.r4.model.Coding t : src.getSecurity()) tgt.addSecurity(Coding40_50.convertCoding(t));
    for (org.hl7.fhir.r4.model.Coding t : src.getTag()) tgt.addTag(Coding40_50.convertCoding(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Meta convertMeta(org.hl7.fhir.r5.model.Meta src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.Meta tgt = new org.hl7.fhir.r4.model.Meta();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasVersionId()) tgt.setVersionIdElement(Id40_50.convertId(src.getVersionIdElement()));
    if (src.hasLastUpdated()) tgt.setLastUpdatedElement(Instant40_50.convertInstant(src.getLastUpdatedElement()));
    if (src.hasSource()) tgt.setSourceElement(Uri40_50.convertUri(src.getSourceElement()));
    for (org.hl7.fhir.r5.model.CanonicalType t : src.getProfile())
      tgt.getProfile().add(Canonical40_50.convertCanonical(t));
    for (org.hl7.fhir.r5.model.Coding t : src.getSecurity()) tgt.addSecurity(Coding40_50.convertCoding(t));
    for (org.hl7.fhir.r5.model.Coding t : src.getTag()) tgt.addTag(Coding40_50.convertCoding(t));
    return tgt;
  }
}
