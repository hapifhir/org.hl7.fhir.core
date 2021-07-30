package org.hl7.fhir.convertors.conv10_30.datatypes10_30;

import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.String10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class Reference10_30 {
  public static org.hl7.fhir.dstu3.model.Reference convertReference(org.hl7.fhir.dstu2.model.Reference src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu3.model.Reference tgt = new org.hl7.fhir.dstu3.model.Reference();
    Element10_30.copyElement(src, tgt);
    if (src.hasReference()) tgt.setReference(src.getReference());
    if (src.hasDisplayElement()) tgt.setDisplayElement(String10_30.convertString(src.getDisplayElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Reference convertReference(org.hl7.fhir.dstu3.model.Reference src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2.model.Reference tgt = new org.hl7.fhir.dstu2.model.Reference();
    Element10_30.copyElement(src, tgt);
    if (src.hasReference()) tgt.setReference(src.getReference());
    if (src.hasDisplayElement()) tgt.setDisplayElement(String10_30.convertString(src.getDisplayElement()));
    return tgt;
  }
}
