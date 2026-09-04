package org.hl7.fhir.convertors.conv43_N.datatypes43_N.special43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Coding43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Canonical43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Id43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Instant43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Uri43_N;
import org.hl7.fhir.exceptions.FHIRException;

public class Meta43_N {
  public static org.hl7.fhir.model.core.Meta convertMeta(org.hl7.fhir.r4b.model.Meta src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.Meta tgt = new org.hl7.fhir.model.core.Meta();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.hasVersionId()) tgt.setVersionIdElement(Id43_N.convertId(src.getVersionIdElement()));
    if (src.hasLastUpdated()) tgt.setLastUpdatedElement(Instant43_N.convertInstant(src.getLastUpdatedElement()));
    if (src.hasSource()) tgt.setSourceElement(Uri43_N.convertUri(src.getSourceElement()));
    for (org.hl7.fhir.r4b.model.CanonicalType t : src.getProfile())
      tgt.getProfile().add(Canonical43_N.convertCanonical(t));
    for (org.hl7.fhir.r4b.model.Coding t : src.getSecurity()) tgt.addSecurity(Coding43_N.convertCoding(t));
    for (org.hl7.fhir.r4b.model.Coding t : src.getTag()) tgt.addTag(Coding43_N.convertCoding(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Meta convertMeta(org.hl7.fhir.model.core.Meta src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4b.model.Meta tgt = new org.hl7.fhir.r4b.model.Meta();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.hasVersionId()) tgt.setVersionIdElement(Id43_N.convertId(src.getVersionIdElement()));
    if (src.hasLastUpdated()) tgt.setLastUpdatedElement(Instant43_N.convertInstant(src.getLastUpdatedElement()));
    if (src.hasSource()) tgt.setSourceElement(Uri43_N.convertUri(src.getSourceElement()));
    for (org.hl7.fhir.model.core.CanonicalType t : src.getProfileList())
      tgt.getProfile().add(Canonical43_N.convertCanonical(t));
    for (org.hl7.fhir.model.core.Coding t : src.getSecurityList()) tgt.addSecurity(Coding43_N.convertCoding(t));
    for (org.hl7.fhir.model.core.Coding t : src.getTagList()) tgt.addTag(Coding43_N.convertCoding(t));
    return tgt;
  }
}
