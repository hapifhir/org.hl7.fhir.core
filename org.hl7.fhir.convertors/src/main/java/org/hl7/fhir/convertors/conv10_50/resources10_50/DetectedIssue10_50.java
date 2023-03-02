package org.hl7.fhir.convertors.conv10_50.resources10_50;

import org.hl7.fhir.convertors.context.ConversionContext10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.Reference10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.CodeableConcept10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.Identifier10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.DateTime10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.String10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.Uri10_50;
import org.hl7.fhir.exceptions.FHIRException;

public class DetectedIssue10_50 {

  public static org.hl7.fhir.dstu2.model.DetectedIssue convertDetectedIssue(org.hl7.fhir.r5.model.DetectedIssue src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.DetectedIssue tgt = new org.hl7.fhir.dstu2.model.DetectedIssue();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyDomainResource(src, tgt);
    if (src.hasSubject())
      tgt.setPatient(Reference10_50.convertReference(src.getSubject()));
    if (src.hasCode())
      tgt.setCategory(CodeableConcept10_50.convertCodeableConcept(src.getCode()));
    if (src.hasSeverity())
      tgt.setSeverityElement(convertDetectedIssueSeverity(src.getSeverityElement()));
    for (org.hl7.fhir.r5.model.Reference t : src.getImplicated()) tgt.addImplicated(Reference10_50.convertReference(t));
    if (src.hasDetailElement())
      tgt.setDetailElement(String10_50.convertString(src.getDetailElement()));
    if (src.hasIdentifiedDateTimeType())
      tgt.setDateElement(DateTime10_50.convertDateTime(src.getIdentifiedDateTimeType()));
    if (src.hasAuthor())
      tgt.setAuthor(Reference10_50.convertReference(src.getAuthor()));
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier10_50.convertIdentifier(src.getIdentifierFirstRep()));
    if (src.hasReferenceElement())
      tgt.setReferenceElement(Uri10_50.convertUri(src.getReferenceElement()));
    for (org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueMitigationComponent t : src.getMitigation())
      tgt.addMitigation(convertDetectedIssueMitigationComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.DetectedIssue convertDetectedIssue(org.hl7.fhir.dstu2.model.DetectedIssue src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.DetectedIssue tgt = new org.hl7.fhir.r5.model.DetectedIssue();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyDomainResource(src, tgt);
    if (src.hasPatient())
      tgt.setSubject(Reference10_50.convertReference(src.getPatient()));
    if (src.hasCategory())
      tgt.setCode(CodeableConcept10_50.convertCodeableConcept(src.getCategory()));
    if (src.hasSeverity())
      tgt.setSeverityElement(convertDetectedIssueSeverity(src.getSeverityElement()));
    for (org.hl7.fhir.dstu2.model.Reference t : src.getImplicated())
      tgt.addImplicated(Reference10_50.convertReference(t));
    if (src.hasDetailElement())
      tgt.setDetailElement(String10_50.convertStringToMarkdown(src.getDetailElement()));
    if (src.hasDate())
      tgt.setIdentified(DateTime10_50.convertDateTime(src.getDateElement()));
    if (src.hasAuthor())
      tgt.setAuthor(Reference10_50.convertReference(src.getAuthor()));
    if (src.hasIdentifier())
      tgt.addIdentifier(Identifier10_50.convertIdentifier(src.getIdentifier()));
    if (src.hasReferenceElement())
      tgt.setReferenceElement(Uri10_50.convertUri(src.getReferenceElement()));
    for (org.hl7.fhir.dstu2.model.DetectedIssue.DetectedIssueMitigationComponent t : src.getMitigation())
      tgt.addMitigation(convertDetectedIssueMitigationComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.DetectedIssue.DetectedIssueMitigationComponent convertDetectedIssueMitigationComponent(org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueMitigationComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.DetectedIssue.DetectedIssueMitigationComponent tgt = new org.hl7.fhir.dstu2.model.DetectedIssue.DetectedIssueMitigationComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    if (src.hasAction())
      tgt.setAction(CodeableConcept10_50.convertCodeableConcept(src.getAction()));
    if (src.hasDate())
      tgt.setDateElement(DateTime10_50.convertDateTime(src.getDateElement()));
    if (src.hasAuthor())
      tgt.setAuthor(Reference10_50.convertReference(src.getAuthor()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueMitigationComponent convertDetectedIssueMitigationComponent(org.hl7.fhir.dstu2.model.DetectedIssue.DetectedIssueMitigationComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueMitigationComponent tgt = new org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueMitigationComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    if (src.hasAction())
      tgt.setAction(CodeableConcept10_50.convertCodeableConcept(src.getAction()));
    if (src.hasDate())
      tgt.setDateElement(DateTime10_50.convertDateTime(src.getDateElement()));
    if (src.hasAuthor())
      tgt.setAuthor(Reference10_50.convertReference(src.getAuthor()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueSeverity> convertDetectedIssueSeverity(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.DetectedIssue.DetectedIssueSeverity> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueSeverity> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueSeverityEnumFactory());
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case HIGH:
        tgt.setValue(org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueSeverity.HIGH);
        break;
      case MODERATE:
        tgt.setValue(org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueSeverity.MODERATE);
        break;
      case LOW:
        tgt.setValue(org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueSeverity.LOW);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueSeverity.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.DetectedIssue.DetectedIssueSeverity> convertDetectedIssueSeverity(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueSeverity> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.DetectedIssue.DetectedIssueSeverity> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.DetectedIssue.DetectedIssueSeverityEnumFactory());
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case HIGH:
        tgt.setValue(org.hl7.fhir.dstu2.model.DetectedIssue.DetectedIssueSeverity.HIGH);
        break;
      case MODERATE:
        tgt.setValue(org.hl7.fhir.dstu2.model.DetectedIssue.DetectedIssueSeverity.MODERATE);
        break;
      case LOW:
        tgt.setValue(org.hl7.fhir.dstu2.model.DetectedIssue.DetectedIssueSeverity.LOW);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu2.model.DetectedIssue.DetectedIssueSeverity.NULL);
        break;
    }
    return tgt;
  }
}