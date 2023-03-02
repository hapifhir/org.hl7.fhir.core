package org.hl7.fhir.convertors.conv43_50.resources43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Attachment43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.CodeableConcept43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Identifier43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Instant43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.String43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.special43_50.Reference43_50;
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
public class DiagnosticReport43_50 {

  public static org.hl7.fhir.r5.model.DiagnosticReport convertDiagnosticReport(org.hl7.fhir.r4b.model.DiagnosticReport src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.DiagnosticReport tgt = new org.hl7.fhir.r5.model.DiagnosticReport();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getBasedOn()) tgt.addBasedOn(Reference43_50.convertReference(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertDiagnosticReportStatus(src.getStatusElement()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_50.convertCodeableConcept(src.getCode()));
    if (src.hasSubject())
      tgt.setSubject(Reference43_50.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference43_50.convertReference(src.getEncounter()));
    if (src.hasEffective())
      tgt.setEffective(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getEffective()));
    if (src.hasIssued())
      tgt.setIssuedElement(Instant43_50.convertInstant(src.getIssuedElement()));
    for (org.hl7.fhir.r4b.model.Reference t : src.getPerformer()) tgt.addPerformer(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getResultsInterpreter())
      tgt.addResultsInterpreter(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getSpecimen()) tgt.addSpecimen(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getResult()) tgt.addResult(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r4b.model.DiagnosticReport.DiagnosticReportMediaComponent t : src.getMedia())
      tgt.addMedia(convertDiagnosticReportMediaComponent(t));
    if (src.hasConclusion())
      tgt.setConclusionElement(String43_50.convertStringToMarkdown(src.getConclusionElement()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getConclusionCode())
      tgt.addConclusionCode(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r4b.model.Attachment t : src.getPresentedForm())
      tgt.addPresentedForm(Attachment43_50.convertAttachment(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.DiagnosticReport convertDiagnosticReport(org.hl7.fhir.r5.model.DiagnosticReport src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.DiagnosticReport tgt = new org.hl7.fhir.r4b.model.DiagnosticReport();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getBasedOn()) tgt.addBasedOn(Reference43_50.convertReference(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertDiagnosticReportStatus(src.getStatusElement()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_50.convertCodeableConcept(src.getCode()));
    if (src.hasSubject())
      tgt.setSubject(Reference43_50.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference43_50.convertReference(src.getEncounter()));
    if (src.hasEffective())
      tgt.setEffective(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getEffective()));
    if (src.hasIssued())
      tgt.setIssuedElement(Instant43_50.convertInstant(src.getIssuedElement()));
    for (org.hl7.fhir.r5.model.Reference t : src.getPerformer()) tgt.addPerformer(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getResultsInterpreter())
      tgt.addResultsInterpreter(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getSpecimen()) tgt.addSpecimen(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getResult()) tgt.addResult(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r5.model.DiagnosticReport.DiagnosticReportMediaComponent t : src.getMedia())
      tgt.addMedia(convertDiagnosticReportMediaComponent(t));
    if (src.hasConclusion())
      tgt.setConclusionElement(String43_50.convertString(src.getConclusionElement()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getConclusionCode())
      tgt.addConclusionCode(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.Attachment t : src.getPresentedForm())
      tgt.addPresentedForm(Attachment43_50.convertAttachment(t));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.DiagnosticReport.DiagnosticReportStatus> convertDiagnosticReportStatus(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.DiagnosticReport.DiagnosticReportStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.DiagnosticReport.DiagnosticReportStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.DiagnosticReport.DiagnosticReportStatusEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.DiagnosticReport.DiagnosticReportStatus> convertDiagnosticReportStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.DiagnosticReport.DiagnosticReportStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.DiagnosticReport.DiagnosticReportStatus> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.DiagnosticReport.DiagnosticReportStatusEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case REGISTERED:
        tgt.setValue(org.hl7.fhir.r4b.model.DiagnosticReport.DiagnosticReportStatus.REGISTERED);
        break;
      case PARTIAL:
        tgt.setValue(org.hl7.fhir.r4b.model.DiagnosticReport.DiagnosticReportStatus.PARTIAL);
        break;
      case PRELIMINARY:
        tgt.setValue(org.hl7.fhir.r4b.model.DiagnosticReport.DiagnosticReportStatus.PRELIMINARY);
        break;
      case FINAL:
        tgt.setValue(org.hl7.fhir.r4b.model.DiagnosticReport.DiagnosticReportStatus.FINAL);
        break;
      case AMENDED:
        tgt.setValue(org.hl7.fhir.r4b.model.DiagnosticReport.DiagnosticReportStatus.AMENDED);
        break;
      case CORRECTED:
        tgt.setValue(org.hl7.fhir.r4b.model.DiagnosticReport.DiagnosticReportStatus.CORRECTED);
        break;
      case APPENDED:
        tgt.setValue(org.hl7.fhir.r4b.model.DiagnosticReport.DiagnosticReportStatus.APPENDED);
        break;
      case CANCELLED:
        tgt.setValue(org.hl7.fhir.r4b.model.DiagnosticReport.DiagnosticReportStatus.CANCELLED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r4b.model.DiagnosticReport.DiagnosticReportStatus.ENTEREDINERROR);
        break;
      case UNKNOWN:
        tgt.setValue(org.hl7.fhir.r4b.model.DiagnosticReport.DiagnosticReportStatus.UNKNOWN);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.DiagnosticReport.DiagnosticReportStatus.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.DiagnosticReport.DiagnosticReportMediaComponent convertDiagnosticReportMediaComponent(org.hl7.fhir.r4b.model.DiagnosticReport.DiagnosticReportMediaComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.DiagnosticReport.DiagnosticReportMediaComponent tgt = new org.hl7.fhir.r5.model.DiagnosticReport.DiagnosticReportMediaComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasComment())
      tgt.setCommentElement(String43_50.convertString(src.getCommentElement()));
    if (src.hasLink())
      tgt.setLink(Reference43_50.convertReference(src.getLink()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.DiagnosticReport.DiagnosticReportMediaComponent convertDiagnosticReportMediaComponent(org.hl7.fhir.r5.model.DiagnosticReport.DiagnosticReportMediaComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.DiagnosticReport.DiagnosticReportMediaComponent tgt = new org.hl7.fhir.r4b.model.DiagnosticReport.DiagnosticReportMediaComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasComment())
      tgt.setCommentElement(String43_50.convertString(src.getCommentElement()));
    if (src.hasLink())
      tgt.setLink(Reference43_50.convertReference(src.getLink()));
    return tgt;
  }
}