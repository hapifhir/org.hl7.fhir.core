package org.hl7.fhir.convertors.conv43_50.datatypes43_50.special43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Coding43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Canonical43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Id43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Instant43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Uri43_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Meta43_50 {
  public static org.hl7.fhir.r5.model.Meta convertMeta(org.hl7.fhir.r4b.model.Meta src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.Meta tgt = new org.hl7.fhir.r5.model.Meta();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.hasVersionId()) tgt.setVersionIdElement(Id43_50.convertId(src.getVersionIdElement()));
    if (src.hasLastUpdated()) tgt.setLastUpdatedElement(Instant43_50.convertInstant(src.getLastUpdatedElement()));
    if (src.hasSource()) tgt.setSourceElement(Uri43_50.convertUri(src.getSourceElement()));
    for (org.hl7.fhir.r4b.model.CanonicalType t : src.getProfile())
      tgt.getProfile().add(Canonical43_50.convertCanonical(t));
    for (org.hl7.fhir.r4b.model.Coding t : src.getSecurity()) tgt.addSecurity(Coding43_50.convertCoding(t));
    for (org.hl7.fhir.r4b.model.Coding t : src.getTag()) tgt.addTag(Coding43_50.convertCoding(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Meta convertMeta(org.hl7.fhir.r5.model.Meta src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.Meta tgt = new org.hl7.fhir.r4b.model.Meta();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.hasVersionId()) tgt.setVersionIdElement(Id43_50.convertId(src.getVersionIdElement()));
    if (src.hasLastUpdated()) tgt.setLastUpdatedElement(Instant43_50.convertInstant(src.getLastUpdatedElement()));
    if (src.hasSource()) tgt.setSourceElement(Uri43_50.convertUri(src.getSourceElement()));
    for (org.hl7.fhir.r5.model.CanonicalType t : src.getProfile())
      tgt.getProfile().add(Canonical43_50.convertCanonical(t));
    for (org.hl7.fhir.r5.model.Coding t : src.getSecurity()) tgt.addSecurity(Coding43_50.convertCoding(t));
    for (org.hl7.fhir.r5.model.Coding t : src.getTag()) tgt.addTag(Coding43_50.convertCoding(t));
    return tgt;
  }
}
