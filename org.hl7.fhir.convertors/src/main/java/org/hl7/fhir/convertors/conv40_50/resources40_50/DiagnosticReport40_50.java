package org.hl7.fhir.convertors.conv40_50.resources40_50;

import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Attachment40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.CodeableConcept40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Identifier40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Instant40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.String40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.special40_50.Reference40_50;
import org.hl7.fhir.exceptions.FHIRException;

/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.
  
  Redistribution and use in source and binary forms, with or without modification, 
  are permitted provided that the following conditions are met:
  
   * Redistributions of source code must retain the above copyright notice, this 
     list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright notice, 
     this list of conditions and the following disclaimer in the documentation 
     and/or other materials provided with the distribution.
   * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.
  
  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
  POSSIBILITY OF SUCH DAMAGE.
  
*/
// Generated on Sun, Feb 24, 2019 11:37+1100 for FHIR v4.0.0
public class DiagnosticReport40_50 {

  public static org.hl7.fhir.r5.model.DiagnosticReport convertDiagnosticReport(org.hl7.fhir.r4.model.DiagnosticReport src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.DiagnosticReport tgt = new org.hl7.fhir.r5.model.DiagnosticReport();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_50.convertIdentifier(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getBasedOn()) tgt.addBasedOn(Reference40_50.convertReference(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertDiagnosticReportStatus(src.getStatusElement()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept40_50.convertCodeableConcept(t));
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_50.convertCodeableConcept(src.getCode()));
    if (src.hasSubject())
      tgt.setSubject(Reference40_50.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference40_50.convertReference(src.getEncounter()));
    if (src.hasEffective())
      tgt.setEffective(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getEffective()));
    if (src.hasIssued())
      tgt.setIssuedElement(Instant40_50.convertInstant(src.getIssuedElement()));
    for (org.hl7.fhir.r4.model.Reference t : src.getPerformer()) tgt.addPerformer(Reference40_50.convertReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getResultsInterpreter())
      tgt.addResultsInterpreter(Reference40_50.convertReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getSpecimen()) tgt.addSpecimen(Reference40_50.convertReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getResult()) tgt.addResult(Reference40_50.convertReference(t));
    for (org.hl7.fhir.r4.model.DiagnosticReport.DiagnosticReportMediaComponent t : src.getMedia())
      tgt.addMedia(convertDiagnosticReportMediaComponent(t));
    if (src.hasConclusion())
      tgt.setConclusionElement(String40_50.convertStringToMarkdown(src.getConclusionElement()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getConclusionCode())
      tgt.addConclusionCode(CodeableConcept40_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.Attachment t : src.getPresentedForm())
      tgt.addPresentedForm(Attachment40_50.convertAttachment(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.DiagnosticReport convertDiagnosticReport(org.hl7.fhir.r5.model.DiagnosticReport src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.DiagnosticReport tgt = new org.hl7.fhir.r4.model.DiagnosticReport();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_50.convertIdentifier(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getBasedOn()) tgt.addBasedOn(Reference40_50.convertReference(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertDiagnosticReportStatus(src.getStatusElement()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept40_50.convertCodeableConcept(t));
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_50.convertCodeableConcept(src.getCode()));
    if (src.hasSubject())
      tgt.setSubject(Reference40_50.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference40_50.convertReference(src.getEncounter()));
    if (src.hasEffective())
      tgt.setEffective(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getEffective()));
    if (src.hasIssued())
      tgt.setIssuedElement(Instant40_50.convertInstant(src.getIssuedElement()));
    for (org.hl7.fhir.r5.model.Reference t : src.getPerformer()) tgt.addPerformer(Reference40_50.convertReference(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getResultsInterpreter())
      tgt.addResultsInterpreter(Reference40_50.convertReference(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getSpecimen()) tgt.addSpecimen(Reference40_50.convertReference(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getResult()) tgt.addResult(Reference40_50.convertReference(t));
    for (org.hl7.fhir.r5.model.DiagnosticReport.DiagnosticReportMediaComponent t : src.getMedia())
      tgt.addMedia(convertDiagnosticReportMediaComponent(t));
    if (src.hasConclusion())
      tgt.setConclusionElement(String40_50.convertString(src.getConclusionElement()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getConclusionCode())
      tgt.addConclusionCode(CodeableConcept40_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.Attachment t : src.getPresentedForm())
      tgt.addPresentedForm(Attachment40_50.convertAttachment(t));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.DiagnosticReport.DiagnosticReportStatus> convertDiagnosticReportStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DiagnosticReport.DiagnosticReportStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.DiagnosticReport.DiagnosticReportStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.DiagnosticReport.DiagnosticReportStatusEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DiagnosticReport.DiagnosticReportStatus> convertDiagnosticReportStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.DiagnosticReport.DiagnosticReportStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DiagnosticReport.DiagnosticReportStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.DiagnosticReport.DiagnosticReportStatusEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case REGISTERED:
        tgt.setValue(org.hl7.fhir.r4.model.DiagnosticReport.DiagnosticReportStatus.REGISTERED);
        break;
      case PARTIAL:
        tgt.setValue(org.hl7.fhir.r4.model.DiagnosticReport.DiagnosticReportStatus.PARTIAL);
        break;
      case PRELIMINARY:
        tgt.setValue(org.hl7.fhir.r4.model.DiagnosticReport.DiagnosticReportStatus.PRELIMINARY);
        break;
      case FINAL:
        tgt.setValue(org.hl7.fhir.r4.model.DiagnosticReport.DiagnosticReportStatus.FINAL);
        break;
      case AMENDED:
        tgt.setValue(org.hl7.fhir.r4.model.DiagnosticReport.DiagnosticReportStatus.AMENDED);
        break;
      case CORRECTED:
        tgt.setValue(org.hl7.fhir.r4.model.DiagnosticReport.DiagnosticReportStatus.CORRECTED);
        break;
      case APPENDED:
        tgt.setValue(org.hl7.fhir.r4.model.DiagnosticReport.DiagnosticReportStatus.APPENDED);
        break;
      case CANCELLED:
        tgt.setValue(org.hl7.fhir.r4.model.DiagnosticReport.DiagnosticReportStatus.CANCELLED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r4.model.DiagnosticReport.DiagnosticReportStatus.ENTEREDINERROR);
        break;
      case UNKNOWN:
        tgt.setValue(org.hl7.fhir.r4.model.DiagnosticReport.DiagnosticReportStatus.UNKNOWN);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.DiagnosticReport.DiagnosticReportStatus.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.DiagnosticReport.DiagnosticReportMediaComponent convertDiagnosticReportMediaComponent(org.hl7.fhir.r4.model.DiagnosticReport.DiagnosticReportMediaComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.DiagnosticReport.DiagnosticReportMediaComponent tgt = new org.hl7.fhir.r5.model.DiagnosticReport.DiagnosticReportMediaComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasComment())
      tgt.setCommentElement(String40_50.convertString(src.getCommentElement()));
    if (src.hasLink())
      tgt.setLink(Reference40_50.convertReference(src.getLink()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.DiagnosticReport.DiagnosticReportMediaComponent convertDiagnosticReportMediaComponent(org.hl7.fhir.r5.model.DiagnosticReport.DiagnosticReportMediaComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.DiagnosticReport.DiagnosticReportMediaComponent tgt = new org.hl7.fhir.r4.model.DiagnosticReport.DiagnosticReportMediaComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasComment())
      tgt.setCommentElement(String40_50.convertString(src.getCommentElement()));
    if (src.hasLink())
      tgt.setLink(Reference40_50.convertReference(src.getLink()));
    return tgt;
  }
}