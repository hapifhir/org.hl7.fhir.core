package org.hl7.fhir.convertors.conv30_50.resources30_50;

import org.hl7.fhir.convertors.context.ConversionContext30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.Reference30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Attachment30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.CodeableConcept30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Identifier30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.Instant30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.String30_50;
import org.hl7.fhir.exceptions.FHIRException;

public class DiagnosticReport30_50 {

  public static org.hl7.fhir.r5.model.DiagnosticReport convertDiagnosticReport(org.hl7.fhir.dstu3.model.DiagnosticReport src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.DiagnosticReport tgt = new org.hl7.fhir.r5.model.DiagnosticReport();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_50.convertIdentifier(t));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getBasedOn()) tgt.addBasedOn(Reference30_50.convertReference(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertDiagnosticReportStatus(src.getStatusElement()));
    if (src.hasCategory())
      tgt.addCategory(CodeableConcept30_50.convertCodeableConcept(src.getCategory()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept30_50.convertCodeableConcept(src.getCode()));
    if (src.hasSubject())
      tgt.setSubject(Reference30_50.convertReference(src.getSubject()));
    if (src.hasContext())
      tgt.setEncounter(Reference30_50.convertReference(src.getContext()));
    if (src.hasEffective())
      tgt.setEffective(ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().convertType(src.getEffective()));
    if (src.hasIssued())
      tgt.setIssuedElement(Instant30_50.convertInstant(src.getIssuedElement()));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getSpecimen()) tgt.addSpecimen(Reference30_50.convertReference(t));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getResult()) tgt.addResult(Reference30_50.convertReference(t));
    for (org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportImageComponent t : src.getImage())
      tgt.addMedia(convertDiagnosticReportImageComponent(t));
    if (src.hasConclusion())
      tgt.setConclusionElement(String30_50.convertStringToMarkdown(src.getConclusionElement()));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getCodedDiagnosis())
      tgt.addConclusionCode(CodeableConcept30_50.convertCodeableConcept(t));
    for (org.hl7.fhir.dstu3.model.Attachment t : src.getPresentedForm())
      tgt.addPresentedForm(Attachment30_50.convertAttachment(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.DiagnosticReport convertDiagnosticReport(org.hl7.fhir.r5.model.DiagnosticReport src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.DiagnosticReport tgt = new org.hl7.fhir.dstu3.model.DiagnosticReport();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_50.convertIdentifier(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getBasedOn()) tgt.addBasedOn(Reference30_50.convertReference(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertDiagnosticReportStatus(src.getStatusElement()));
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept30_50.convertCodeableConcept(src.getCategoryFirstRep()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept30_50.convertCodeableConcept(src.getCode()));
    if (src.hasSubject())
      tgt.setSubject(Reference30_50.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setContext(Reference30_50.convertReference(src.getEncounter()));
    if (src.hasEffective())
      tgt.setEffective(ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().convertType(src.getEffective()));
    if (src.hasIssued())
      tgt.setIssuedElement(Instant30_50.convertInstant(src.getIssuedElement()));
    for (org.hl7.fhir.r5.model.Reference t : src.getSpecimen()) tgt.addSpecimen(Reference30_50.convertReference(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getResult()) tgt.addResult(Reference30_50.convertReference(t));
    for (org.hl7.fhir.r5.model.DiagnosticReport.DiagnosticReportMediaComponent t : src.getMedia())
      tgt.addImage(convertDiagnosticReportImageComponent(t));
    if (src.hasConclusion())
      tgt.setConclusionElement(String30_50.convertString(src.getConclusionElement()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getConclusionCode())
      tgt.addCodedDiagnosis(CodeableConcept30_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.Attachment t : src.getPresentedForm())
      tgt.addPresentedForm(Attachment30_50.convertAttachment(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportImageComponent convertDiagnosticReportImageComponent(org.hl7.fhir.r5.model.DiagnosticReport.DiagnosticReportMediaComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportImageComponent tgt = new org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportImageComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    if (src.hasComment())
      tgt.setCommentElement(String30_50.convertString(src.getCommentElement()));
    if (src.hasLink())
      tgt.setLink(Reference30_50.convertReference(src.getLink()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.DiagnosticReport.DiagnosticReportMediaComponent convertDiagnosticReportImageComponent(org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportImageComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.DiagnosticReport.DiagnosticReportMediaComponent tgt = new org.hl7.fhir.r5.model.DiagnosticReport.DiagnosticReportMediaComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    if (src.hasComment())
      tgt.setCommentElement(String30_50.convertString(src.getCommentElement()));
    if (src.hasLink())
      tgt.setLink(Reference30_50.convertReference(src.getLink()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.DiagnosticReport.DiagnosticReportStatus> convertDiagnosticReportStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.DiagnosticReport.DiagnosticReportStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.DiagnosticReport.DiagnosticReportStatusEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case REGISTERED:
        tgt.setValue(org.hl7.fhir.r5.model.DiagnosticReport.DiagnosticReportStatus.REGISTERED);
        break;
      case PARTIAL:
        tgt.setValue(org.hl7.fhir.r5.model.DiagnosticReport.DiagnosticReportStatus.PARTIAL);
        break;
      case PRELIMINARY:
        tgt.setValue(org.hl7.fhir.r5.model.DiagnosticReport.DiagnosticReportStatus.PRELIMINARY);
        break;
      case FINAL:
        tgt.setValue(org.hl7.fhir.r5.model.DiagnosticReport.DiagnosticReportStatus.FINAL);
        break;
      case AMENDED:
        tgt.setValue(org.hl7.fhir.r5.model.DiagnosticReport.DiagnosticReportStatus.AMENDED);
        break;
      case CORRECTED:
        tgt.setValue(org.hl7.fhir.r5.model.DiagnosticReport.DiagnosticReportStatus.CORRECTED);
        break;
      case APPENDED:
        tgt.setValue(org.hl7.fhir.r5.model.DiagnosticReport.DiagnosticReportStatus.APPENDED);
        break;
      case CANCELLED:
        tgt.setValue(org.hl7.fhir.r5.model.DiagnosticReport.DiagnosticReportStatus.CANCELLED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r5.model.DiagnosticReport.DiagnosticReportStatus.ENTEREDINERROR);
        break;
      case UNKNOWN:
        tgt.setValue(org.hl7.fhir.r5.model.DiagnosticReport.DiagnosticReportStatus.UNKNOWN);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.DiagnosticReport.DiagnosticReportStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportStatus> convertDiagnosticReportStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.DiagnosticReport.DiagnosticReportStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportStatusEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case REGISTERED:
        tgt.setValue(org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportStatus.REGISTERED);
        break;
      case PARTIAL:
        tgt.setValue(org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportStatus.PARTIAL);
        break;
      case PRELIMINARY:
        tgt.setValue(org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportStatus.PRELIMINARY);
        break;
      case FINAL:
        tgt.setValue(org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportStatus.FINAL);
        break;
      case AMENDED:
        tgt.setValue(org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportStatus.AMENDED);
        break;
      case CORRECTED:
        tgt.setValue(org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportStatus.CORRECTED);
        break;
      case APPENDED:
        tgt.setValue(org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportStatus.APPENDED);
        break;
      case CANCELLED:
        tgt.setValue(org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportStatus.CANCELLED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportStatus.ENTEREDINERROR);
        break;
      case UNKNOWN:
        tgt.setValue(org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportStatus.UNKNOWN);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportStatus.NULL);
        break;
    }
    return tgt;
  }
}