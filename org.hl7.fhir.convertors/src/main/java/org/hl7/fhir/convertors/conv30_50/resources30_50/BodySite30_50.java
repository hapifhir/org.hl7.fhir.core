package org.hl7.fhir.convertors.conv30_50.resources30_50;

import org.hl7.fhir.convertors.context.ConversionContext30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.Reference30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Attachment30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Identifier30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.Boolean30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.String30_50;
import org.hl7.fhir.exceptions.FHIRException;

public class BodySite30_50 {

  public static org.hl7.fhir.r5.model.BodyStructure convertBodySite(org.hl7.fhir.dstu3.model.BodySite src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.BodyStructure tgt = new org.hl7.fhir.r5.model.BodyStructure();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_50.convertIdentifier(t));
    if (src.hasActive())
      tgt.setActiveElement(Boolean30_50.convertBoolean(src.getActiveElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String30_50.convertStringToMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.dstu3.model.Attachment t : src.getImage()) tgt.addImage(Attachment30_50.convertAttachment(t));
    if (src.hasPatient())
      tgt.setPatient(Reference30_50.convertReference(src.getPatient()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.BodySite convertBodySite(org.hl7.fhir.r5.model.BodyStructure src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.BodySite tgt = new org.hl7.fhir.dstu3.model.BodySite();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_50.convertIdentifier(t));
    if (src.hasActive())
      tgt.setActiveElement(Boolean30_50.convertBoolean(src.getActiveElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String30_50.convertString(src.getDescriptionElement()));
    for (org.hl7.fhir.r5.model.Attachment t : src.getImage()) tgt.addImage(Attachment30_50.convertAttachment(t));
    if (src.hasPatient())
      tgt.setPatient(Reference30_50.convertReference(src.getPatient()));
    return tgt;
  }
}