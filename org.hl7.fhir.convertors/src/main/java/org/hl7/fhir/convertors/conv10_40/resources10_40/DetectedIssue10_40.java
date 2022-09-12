package org.hl7.fhir.convertors.conv10_40.resources10_40;

import org.hl7.fhir.convertors.context.ConversionContext10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.Reference10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.CodeableConcept10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.Identifier10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.DateTime10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.String10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.Uri10_40;
import org.hl7.fhir.exceptions.FHIRException;

public class DetectedIssue10_40 {

  public static org.hl7.fhir.dstu2.model.DetectedIssue convertDetectedIssue(org.hl7.fhir.r4.model.DetectedIssue src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.DetectedIssue tgt = new org.hl7.fhir.dstu2.model.DetectedIssue();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyDomainResource(src, tgt);
    if (src.hasPatient())
      tgt.setPatient(Reference10_40.convertReference(src.getPatient()));
    if (src.hasCode())
      tgt.setCategory(CodeableConcept10_40.convertCodeableConcept(src.getCode()));
    if (src.hasSeverity())
      tgt.setSeverityElement(convertDetectedIssueSeverity(src.getSeverityElement()));
    for (org.hl7.fhir.r4.model.Reference t : src.getImplicated()) tgt.addImplicated(Reference10_40.convertReference(t));
    if (src.hasDetailElement())
      tgt.setDetailElement(String10_40.convertString(src.getDetailElement()));
    if (src.hasIdentifiedDateTimeType())
      tgt.setDateElement(DateTime10_40.convertDateTime(src.getIdentifiedDateTimeType()));
    if (src.hasAuthor())
      tgt.setAuthor(Reference10_40.convertReference(src.getAuthor()));
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier10_40.convertIdentifier(src.getIdentifierFirstRep()));
    if (src.hasReferenceElement())
      tgt.setReferenceElement(Uri10_40.convertUri(src.getReferenceElement()));
    for (org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueMitigationComponent t : src.getMitigation())
      tgt.addMitigation(convertDetectedIssueMitigationComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.DetectedIssue convertDetectedIssue(org.hl7.fhir.dstu2.model.DetectedIssue src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.DetectedIssue tgt = new org.hl7.fhir.r4.model.DetectedIssue();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyDomainResource(src, tgt);
    if (src.hasPatient())
      tgt.setPatient(Reference10_40.convertReference(src.getPatient()));
    if (src.hasCategory())
      tgt.setCode(CodeableConcept10_40.convertCodeableConcept(src.getCategory()));
    if (src.hasSeverity())
      tgt.setSeverityElement(convertDetectedIssueSeverity(src.getSeverityElement()));
    for (org.hl7.fhir.dstu2.model.Reference t : src.getImplicated())
      tgt.addImplicated(Reference10_40.convertReference(t));
    if (src.hasDetailElement())
      tgt.setDetailElement(String10_40.convertString(src.getDetailElement()));
    if (src.hasDate())
      tgt.setIdentified(DateTime10_40.convertDateTime(src.getDateElement()));
    if (src.hasAuthor())
      tgt.setAuthor(Reference10_40.convertReference(src.getAuthor()));
    if (src.hasIdentifier())
      tgt.addIdentifier(Identifier10_40.convertIdentifier(src.getIdentifier()));
    if (src.hasReferenceElement())
      tgt.setReferenceElement(Uri10_40.convertUri(src.getReferenceElement()));
    for (org.hl7.fhir.dstu2.model.DetectedIssue.DetectedIssueMitigationComponent t : src.getMitigation())
      tgt.addMitigation(convertDetectedIssueMitigationComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueMitigationComponent convertDetectedIssueMitigationComponent(org.hl7.fhir.dstu2.model.DetectedIssue.DetectedIssueMitigationComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueMitigationComponent tgt = new org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueMitigationComponent();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyBackboneElement(src,tgt);
    if (src.hasAction())
      tgt.setAction(CodeableConcept10_40.convertCodeableConcept(src.getAction()));
    if (src.hasDate())
      tgt.setDateElement(DateTime10_40.convertDateTime(src.getDateElement()));
    if (src.hasAuthor())
      tgt.setAuthor(Reference10_40.convertReference(src.getAuthor()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.DetectedIssue.DetectedIssueMitigationComponent convertDetectedIssueMitigationComponent(org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueMitigationComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.DetectedIssue.DetectedIssueMitigationComponent tgt = new org.hl7.fhir.dstu2.model.DetectedIssue.DetectedIssueMitigationComponent();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyBackboneElement(src,tgt);
    if (src.hasAction())
      tgt.setAction(CodeableConcept10_40.convertCodeableConcept(src.getAction()));
    if (src.hasDate())
      tgt.setDateElement(DateTime10_40.convertDateTime(src.getDateElement()));
    if (src.hasAuthor())
      tgt.setAuthor(Reference10_40.convertReference(src.getAuthor()));
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.DetectedIssue.DetectedIssueSeverity> convertDetectedIssueSeverity(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueSeverity> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.DetectedIssue.DetectedIssueSeverity> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.DetectedIssue.DetectedIssueSeverityEnumFactory());
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueSeverity> convertDetectedIssueSeverity(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.DetectedIssue.DetectedIssueSeverity> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueSeverity> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueSeverityEnumFactory());
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case HIGH:
        tgt.setValue(org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueSeverity.HIGH);
        break;
      case MODERATE:
        tgt.setValue(org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueSeverity.MODERATE);
        break;
      case LOW:
        tgt.setValue(org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueSeverity.LOW);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueSeverity.NULL);
        break;
    }
    return tgt;
  }
}