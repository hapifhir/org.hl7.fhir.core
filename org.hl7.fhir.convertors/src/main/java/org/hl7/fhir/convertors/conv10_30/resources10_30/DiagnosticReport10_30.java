package org.hl7.fhir.convertors.conv10_30.resources10_30;

import org.hl7.fhir.convertors.context.ConversionContext10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.Reference10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.Attachment10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.CodeableConcept10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.Identifier10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.Instant10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.String10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class DiagnosticReport10_30 {

  public static org.hl7.fhir.dstu2.model.DiagnosticReport convertDiagnosticReport(org.hl7.fhir.dstu3.model.DiagnosticReport src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.DiagnosticReport tgt = new org.hl7.fhir.dstu2.model.DiagnosticReport();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_30.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertDiagnosticReportStatus(src.getStatusElement()));
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept10_30.convertCodeableConcept(src.getCategory()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept10_30.convertCodeableConcept(src.getCode()));
    if (src.hasSubject())
      tgt.setSubject(Reference10_30.convertReference(src.getSubject()));
    if (src.hasContext())
      tgt.setEncounter(Reference10_30.convertReference(src.getContext()));
    if (src.hasEffective())
      tgt.setEffective(ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().convertType(src.getEffective()));
    if (src.hasIssuedElement())
      tgt.setIssuedElement(Instant10_30.convertInstant(src.getIssuedElement()));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getBasedOn()) tgt.addRequest(Reference10_30.convertReference(t));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getSpecimen()) tgt.addSpecimen(Reference10_30.convertReference(t));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getResult()) tgt.addResult(Reference10_30.convertReference(t));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getImagingStudy())
      tgt.addImagingStudy(Reference10_30.convertReference(t));
    for (org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportImageComponent t : src.getImage())
      tgt.addImage(convertDiagnosticReportImageComponent(t));
    if (src.hasConclusionElement())
      tgt.setConclusionElement(String10_30.convertString(src.getConclusionElement()));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getCodedDiagnosis())
      tgt.addCodedDiagnosis(CodeableConcept10_30.convertCodeableConcept(t));
    for (org.hl7.fhir.dstu3.model.Attachment t : src.getPresentedForm())
      tgt.addPresentedForm(Attachment10_30.convertAttachment(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.DiagnosticReport convertDiagnosticReport(org.hl7.fhir.dstu2.model.DiagnosticReport src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.DiagnosticReport tgt = new org.hl7.fhir.dstu3.model.DiagnosticReport();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_30.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertDiagnosticReportStatus(src.getStatusElement()));
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept10_30.convertCodeableConcept(src.getCategory()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept10_30.convertCodeableConcept(src.getCode()));
    if (src.hasSubject())
      tgt.setSubject(Reference10_30.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setContext(Reference10_30.convertReference(src.getEncounter()));
    if (src.hasEffective())
      tgt.setEffective(ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().convertType(src.getEffective()));
    if (src.hasIssuedElement())
      tgt.setIssuedElement(Instant10_30.convertInstant(src.getIssuedElement()));
    for (org.hl7.fhir.dstu2.model.Reference t : src.getRequest()) tgt.addBasedOn(Reference10_30.convertReference(t));
    for (org.hl7.fhir.dstu2.model.Reference t : src.getSpecimen()) tgt.addSpecimen(Reference10_30.convertReference(t));
    for (org.hl7.fhir.dstu2.model.Reference t : src.getResult()) tgt.addResult(Reference10_30.convertReference(t));
    for (org.hl7.fhir.dstu2.model.Reference t : src.getImagingStudy())
      tgt.addImagingStudy(Reference10_30.convertReference(t));
    for (org.hl7.fhir.dstu2.model.DiagnosticReport.DiagnosticReportImageComponent t : src.getImage())
      tgt.addImage(convertDiagnosticReportImageComponent(t));
    if (src.hasConclusionElement())
      tgt.setConclusionElement(String10_30.convertString(src.getConclusionElement()));
    for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getCodedDiagnosis())
      tgt.addCodedDiagnosis(CodeableConcept10_30.convertCodeableConcept(t));
    for (org.hl7.fhir.dstu2.model.Attachment t : src.getPresentedForm())
      tgt.addPresentedForm(Attachment10_30.convertAttachment(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportImageComponent convertDiagnosticReportImageComponent(org.hl7.fhir.dstu2.model.DiagnosticReport.DiagnosticReportImageComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportImageComponent tgt = new org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportImageComponent();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyBackboneElement(src,tgt);
    if (src.hasCommentElement())
      tgt.setCommentElement(String10_30.convertString(src.getCommentElement()));
    if (src.hasLink())
      tgt.setLink(Reference10_30.convertReference(src.getLink()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.DiagnosticReport.DiagnosticReportImageComponent convertDiagnosticReportImageComponent(org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportImageComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.DiagnosticReport.DiagnosticReportImageComponent tgt = new org.hl7.fhir.dstu2.model.DiagnosticReport.DiagnosticReportImageComponent();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyBackboneElement(src,tgt);
    if (src.hasCommentElement())
      tgt.setCommentElement(String10_30.convertString(src.getCommentElement()));
    if (src.hasLink())
      tgt.setLink(Reference10_30.convertReference(src.getLink()));
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportStatus> convertDiagnosticReportStatus(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.DiagnosticReport.DiagnosticReportStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportStatusEnumFactory());
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    switch (src.getValue()) {
      case REGISTERED:
        tgt.setValue(org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportStatus.REGISTERED);
        break;
      case PARTIAL:
        tgt.setValue(org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportStatus.PARTIAL);
        break;
      case FINAL:
        tgt.setValue(org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportStatus.FINAL);
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
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.DiagnosticReport.DiagnosticReportStatus> convertDiagnosticReportStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.DiagnosticReport.DiagnosticReportStatus> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.DiagnosticReport.DiagnosticReportStatusEnumFactory());
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    switch (src.getValue()) {
      case REGISTERED:
        tgt.setValue(org.hl7.fhir.dstu2.model.DiagnosticReport.DiagnosticReportStatus.REGISTERED);
        break;
      case PARTIAL:
        tgt.setValue(org.hl7.fhir.dstu2.model.DiagnosticReport.DiagnosticReportStatus.PARTIAL);
        break;
      case FINAL:
        tgt.setValue(org.hl7.fhir.dstu2.model.DiagnosticReport.DiagnosticReportStatus.FINAL);
        break;
      case CORRECTED:
        tgt.setValue(org.hl7.fhir.dstu2.model.DiagnosticReport.DiagnosticReportStatus.CORRECTED);
        break;
      case APPENDED:
        tgt.setValue(org.hl7.fhir.dstu2.model.DiagnosticReport.DiagnosticReportStatus.APPENDED);
        break;
      case CANCELLED:
        tgt.setValue(org.hl7.fhir.dstu2.model.DiagnosticReport.DiagnosticReportStatus.CANCELLED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.dstu2.model.DiagnosticReport.DiagnosticReportStatus.ENTEREDINERROR);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu2.model.DiagnosticReport.DiagnosticReportStatus.NULL);
        break;
    }
    return tgt;
  }
}