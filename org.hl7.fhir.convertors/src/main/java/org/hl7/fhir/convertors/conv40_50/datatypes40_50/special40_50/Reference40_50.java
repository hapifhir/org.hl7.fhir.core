package org.hl7.fhir.convertors.conv40_50.datatypes40_50.special40_50;

import org.hl7.fhir.convertors.conv40_50.datatypes40_50.Element40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Identifier40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.String40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Uri40_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CodeableReference;

public class Reference40_50 {
  public static org.hl7.fhir.r5.model.Reference convertReference(org.hl7.fhir.r4.model.Reference src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.Reference tgt = new org.hl7.fhir.r5.model.Reference();
    Element40_50.copyElement(src, tgt);
    if (src.hasReference()) tgt.setReferenceElement(String40_50.convertString(src.getReferenceElement_()));
    if (src.hasType()) tgt.setTypeElement(Uri40_50.convertUri(src.getTypeElement()));
    if (src.hasIdentifier()) tgt.setIdentifier(Identifier40_50.convertIdentifier(src.getIdentifier()));
    if (src.hasDisplay()) tgt.setDisplayElement(String40_50.convertString(src.getDisplayElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Reference convertReference(org.hl7.fhir.r5.model.Reference src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.Reference tgt = new org.hl7.fhir.r4.model.Reference();
    Element40_50.copyElement(src, tgt);
    if (src.hasReference()) tgt.setReferenceElement(String40_50.convertString(src.getReferenceElement_()));
    if (src.hasType()) tgt.setTypeElement(Uri40_50.convertUri(src.getTypeElement()));
    if (src.hasIdentifier()) tgt.setIdentifier(Identifier40_50.convertIdentifier(src.getIdentifier()));
    if (src.hasDisplay()) tgt.setDisplayElement(String40_50.convertString(src.getDisplayElement()));
    return tgt;
  }

  public static CodeableReference convertReferenceToCodeableReference(org.hl7.fhir.r4.model.Reference src) {
    CodeableReference tgt = new CodeableReference();
    tgt.setReference(convertReference(src));
    return tgt;
  }
}
