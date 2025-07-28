package org.hl7.fhir.convertors.conv30_40.resources30_40;

import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.convertors.context.ConversionContext30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Reference30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Attachment30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.CodeableConcept30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Identifier30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.Instant30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.String30_40;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.DiagnosticReport;
import org.hl7.fhir.r4.model.Enumeration;

public class DiagnosticReport30_40 {

  public static org.hl7.fhir.r4.model.DiagnosticReport convertDiagnosticReport(org.hl7.fhir.dstu3.model.DiagnosticReport src) throws FHIRException {
    if (src == null)
      return null;

    org.hl7.fhir.r4.model.DiagnosticReport tgt = new org.hl7.fhir.r4.model.DiagnosticReport();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_40.convertIdentifier(t));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getBasedOn())
      tgt.addBasedOn(Reference30_40.convertReference(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertDiagnosticReportStatus(src.getStatusElement()));
    if (src.hasCategory())
      tgt.addCategory(CodeableConcept30_40.convertCodeableConcept(src.getCategory()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept30_40.convertCodeableConcept(src.getCode()));
    if (src.hasSubject())
      tgt.setSubject(Reference30_40.convertReference(src.getSubject()));
    if (src.hasContext())
      tgt.setEncounter(Reference30_40.convertReference(src.getContext()));
    if (src.hasEffective())
      tgt.setEffective(ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().convertType(src.getEffective()));
    if (src.hasIssued())
      tgt.setIssuedElement(Instant30_40.convertInstant(src.getIssuedElement()));
    for (org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportPerformerComponent t : src.getPerformer()) {
      org.hl7.fhir.r4.model.Reference performer = convertDiagnosticReportPerformerComponent(t);
      if (performer != null) {
        tgt.addPerformer(performer);
      }
    }
    for (org.hl7.fhir.dstu3.model.Reference t : src.getSpecimen())
      tgt.addSpecimen(Reference30_40.convertReference(t));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getResult())
      tgt.addResult(Reference30_40.convertReference(t));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getImagingStudy())
      tgt.addImagingStudy(Reference30_40.convertReference(t));
    for (org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportImageComponent t : src.getImage())
      tgt.addMedia(convertDiagnosticReportImageComponent(t));
    if (src.hasConclusion())
      tgt.setConclusionElement(String30_40.convertString(src.getConclusionElement()));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getCodedDiagnosis())
      tgt.addConclusionCode(CodeableConcept30_40.convertCodeableConcept(t));
    for (org.hl7.fhir.dstu3.model.Attachment t : src.getPresentedForm())
      tgt.addPresentedForm(Attachment30_40.convertAttachment(t));
    return tgt;
  }


  public static org.hl7.fhir.dstu3.model.DiagnosticReport convertDiagnosticReport(org.hl7.fhir.r4.model.DiagnosticReport src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.DiagnosticReport tgt = new org.hl7.fhir.dstu3.model.DiagnosticReport();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_40.convertIdentifier(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getBasedOn())
      tgt.addBasedOn(Reference30_40.convertReference(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertDiagnosticReportStatus(src.getStatusElement()));
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept30_40.convertCodeableConcept(src.getCategoryFirstRep()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept30_40.convertCodeableConcept(src.getCode()));
    if (src.hasSubject())
      tgt.setSubject(Reference30_40.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setContext(Reference30_40.convertReference(src.getEncounter()));
    if (src.hasEffective())
      tgt.setEffective(ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().convertType(src.getEffective()));
    if (src.hasIssued())
      tgt.setIssuedElement(Instant30_40.convertInstant(src.getIssuedElement()));
    for (org.hl7.fhir.r4.model.Reference t : src.getPerformer()) {
      org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportPerformerComponent performer = convertDiagnosticReportPerformerComponent(t);
      if (performer != null) {
        tgt.addPerformer(performer);
      }
    }
    for (org.hl7.fhir.r4.model.Reference t : src.getSpecimen())
      tgt.addSpecimen(Reference30_40.convertReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getResult())
      tgt.addResult(Reference30_40.convertReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getImagingStudy())
      tgt.addImagingStudy(Reference30_40.convertReference(t));
    for (org.hl7.fhir.r4.model.DiagnosticReport.DiagnosticReportMediaComponent t : src.getMedia())
      tgt.addImage(convertDiagnosticReportImageComponent(t));
    if (src.hasConclusion())
      tgt.setConclusionElement(String30_40.convertString(src.getConclusionElement()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getConclusionCode())
      tgt.addCodedDiagnosis(CodeableConcept30_40.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.Attachment t : src.getPresentedForm())
      tgt.addPresentedForm(Attachment30_40.convertAttachment(t));
    return tgt;
  }

  private static org.hl7.fhir.r4.model.Reference convertDiagnosticReportPerformerComponent(org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportPerformerComponent src) {
    if (src == null || !src.hasActor())
      return null;

    org.hl7.fhir.r4.model.Reference tgt = Reference30_40.convertReference(src.getActor());
    if (src.hasRole()) {
      tgt.addExtension(VersionConvertorConstants.EXT_DIA_REP_PERFORMER, CodeableConcept30_40.convertCodeableConcept(src.getRole()));
    }

    return tgt;
  }

  private static org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportPerformerComponent convertDiagnosticReportPerformerComponent(org.hl7.fhir.r4.model.Reference src) {
    if (src == null)
      return null;

    org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportPerformerComponent tgt = new org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportPerformerComponent();
    tgt.setActor(Reference30_40.convertReference(src, VersionConvertorConstants.EXT_DIA_REP_PERFORMER));
    if (src.hasExtension(VersionConvertorConstants.EXT_DIA_REP_PERFORMER)) {
      org.hl7.fhir.r4.model.Extension extension = src.getExtensionByUrl(VersionConvertorConstants.EXT_DIA_REP_PERFORMER);
      if (extension.getValue() instanceof org.hl7.fhir.r4.model.CodeableConcept) {
        tgt.setRole(CodeableConcept30_40.convertCodeableConcept((org.hl7.fhir.r4.model.CodeableConcept) extension.getValue()));
      }
    }

    return tgt;
  }


  public static org.hl7.fhir.r4.model.DiagnosticReport.DiagnosticReportMediaComponent convertDiagnosticReportImageComponent(org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportImageComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.DiagnosticReport.DiagnosticReportMediaComponent tgt = new org.hl7.fhir.r4.model.DiagnosticReport.DiagnosticReportMediaComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src,tgt);
    if (src.hasComment())
      tgt.setCommentElement(String30_40.convertString(src.getCommentElement()));
    if (src.hasLink())
      tgt.setLink(Reference30_40.convertReference(src.getLink()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportImageComponent convertDiagnosticReportImageComponent(org.hl7.fhir.r4.model.DiagnosticReport.DiagnosticReportMediaComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportImageComponent tgt = new org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportImageComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src,tgt);
    if (src.hasComment())
      tgt.setCommentElement(String30_40.convertString(src.getCommentElement()));
    if (src.hasLink())
      tgt.setLink(Reference30_40.convertReference(src.getLink()));
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DiagnosticReport.DiagnosticReportStatus> convertDiagnosticReportStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<DiagnosticReport.DiagnosticReportStatus> tgt = new Enumeration<>(new DiagnosticReport.DiagnosticReportStatusEnumFactory());
      ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case REGISTERED:
                  tgt.setValue(DiagnosticReport.DiagnosticReportStatus.REGISTERED);
                  break;
              case PARTIAL:
                  tgt.setValue(DiagnosticReport.DiagnosticReportStatus.PARTIAL);
                  break;
              case PRELIMINARY:
                  tgt.setValue(DiagnosticReport.DiagnosticReportStatus.PRELIMINARY);
                  break;
              case FINAL:
                  tgt.setValue(DiagnosticReport.DiagnosticReportStatus.FINAL);
                  break;
              case AMENDED:
                  tgt.setValue(DiagnosticReport.DiagnosticReportStatus.AMENDED);
                  break;
              case CORRECTED:
                  tgt.setValue(DiagnosticReport.DiagnosticReportStatus.CORRECTED);
                  break;
              case APPENDED:
                  tgt.setValue(DiagnosticReport.DiagnosticReportStatus.APPENDED);
                  break;
              case CANCELLED:
                  tgt.setValue(DiagnosticReport.DiagnosticReportStatus.CANCELLED);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(DiagnosticReport.DiagnosticReportStatus.ENTEREDINERROR);
                  break;
              case UNKNOWN:
                  tgt.setValue(DiagnosticReport.DiagnosticReportStatus.UNKNOWN);
                  break;
              default:
                  tgt.setValue(DiagnosticReport.DiagnosticReportStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportStatus> convertDiagnosticReportStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DiagnosticReport.DiagnosticReportStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.DiagnosticReport.DiagnosticReportStatusEnumFactory());
      ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
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
      }
      return tgt;
  }
}