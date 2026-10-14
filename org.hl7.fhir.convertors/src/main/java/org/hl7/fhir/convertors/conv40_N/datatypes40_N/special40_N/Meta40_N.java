package org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Coding40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Canonical40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Id40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Instant40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Uri40_N;
import org.hl7.fhir.exceptions.FHIRException;

public class Meta40_N {
  public static org.hl7.fhir.model.core.Meta convertMeta(org.hl7.fhir.r4.model.Meta src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.model.core.Meta tgt = new org.hl7.fhir.model.core.Meta();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasVersionId()) tgt.setVersionIdElement(Id40_N.convertId(src.getVersionIdElement()));
    if (src.hasLastUpdated()) tgt.setLastUpdatedElement(Instant40_N.convertInstant(src.getLastUpdatedElement()));
    if (src.hasSource()) tgt.setSourceElement(Uri40_N.convertUri(src.getSourceElement()));
    for (org.hl7.fhir.r4.model.CanonicalType t : src.getProfile())
      tgt.getProfile().add(Canonical40_N.convertCanonical(t));
    for (org.hl7.fhir.r4.model.Coding t : src.getSecurity()) tgt.addSecurity(Coding40_N.convertCoding(t));
    for (org.hl7.fhir.r4.model.Coding t : src.getTag()) tgt.addTag(Coding40_N.convertCoding(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Meta convertMeta(org.hl7.fhir.model.core.Meta src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.Meta tgt = new org.hl7.fhir.r4.model.Meta();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasVersionId()) tgt.setVersionIdElement(Id40_N.convertId(src.getVersionIdElement()));
    if (src.hasLastUpdated()) tgt.setLastUpdatedElement(Instant40_N.convertInstant(src.getLastUpdatedElement()));
    if (src.hasSource()) tgt.setSourceElement(Uri40_N.convertUri(src.getSourceElement()));
    for (org.hl7.fhir.model.core.CanonicalType t : src.getProfileList())
      tgt.getProfile().add(Canonical40_N.convertCanonical(t));
    for (org.hl7.fhir.model.core.Coding t : src.getSecurityList()) tgt.addSecurity(Coding40_N.convertCoding(t));
    for (org.hl7.fhir.model.core.Coding t : src.getTagList()) tgt.addTag(Coding40_N.convertCoding(t));
    return tgt;
  }
}
