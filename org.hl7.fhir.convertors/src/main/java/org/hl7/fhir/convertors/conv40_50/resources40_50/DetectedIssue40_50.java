package org.hl7.fhir.convertors.conv40_50.resources40_50;

import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.CodeableConcept40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Identifier40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.DateTime40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.String40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Uri40_50;
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
public class DetectedIssue40_50 {

  public static org.hl7.fhir.r5.model.DetectedIssue convertDetectedIssue(org.hl7.fhir.r4.model.DetectedIssue src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.DetectedIssue tgt = new org.hl7.fhir.r5.model.DetectedIssue();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_50.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertDetectedIssueStatus(src.getStatusElement()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_50.convertCodeableConcept(src.getCode()));
    if (src.hasSeverity())
      tgt.setSeverityElement(convertDetectedIssueSeverity(src.getSeverityElement()));
    if (src.hasPatient())
      tgt.setSubject(Reference40_50.convertReference(src.getPatient()));
    if (src.hasIdentified())
      tgt.setIdentified(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getIdentified()));
    if (src.hasAuthor())
      tgt.setAuthor(Reference40_50.convertReference(src.getAuthor()));
    for (org.hl7.fhir.r4.model.Reference t : src.getImplicated()) tgt.addImplicated(Reference40_50.convertReference(t));
    for (org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueEvidenceComponent t : src.getEvidence())
      tgt.addEvidence(convertDetectedIssueEvidenceComponent(t));
    if (src.hasDetail())
      tgt.setDetailElement(String40_50.convertStringToMarkdown(src.getDetailElement()));
    if (src.hasReference())
      tgt.setReferenceElement(Uri40_50.convertUri(src.getReferenceElement()));
    for (org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueMitigationComponent t : src.getMitigation())
      tgt.addMitigation(convertDetectedIssueMitigationComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.DetectedIssue convertDetectedIssue(org.hl7.fhir.r5.model.DetectedIssue src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.DetectedIssue tgt = new org.hl7.fhir.r4.model.DetectedIssue();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_50.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertDetectedIssueStatus(src.getStatusElement()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_50.convertCodeableConcept(src.getCode()));
    if (src.hasSeverity())
      tgt.setSeverityElement(convertDetectedIssueSeverity(src.getSeverityElement()));
    if (src.hasSubject())
      tgt.setPatient(Reference40_50.convertReference(src.getSubject()));
    if (src.hasIdentified())
      tgt.setIdentified(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getIdentified()));
    if (src.hasAuthor())
      tgt.setAuthor(Reference40_50.convertReference(src.getAuthor()));
    for (org.hl7.fhir.r5.model.Reference t : src.getImplicated()) tgt.addImplicated(Reference40_50.convertReference(t));
    for (org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueEvidenceComponent t : src.getEvidence())
      tgt.addEvidence(convertDetectedIssueEvidenceComponent(t));
    if (src.hasDetail())
      tgt.setDetailElement(String40_50.convertString(src.getDetailElement()));
    if (src.hasReference())
      tgt.setReferenceElement(Uri40_50.convertUri(src.getReferenceElement()));
    for (org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueMitigationComponent t : src.getMitigation())
      tgt.addMitigation(convertDetectedIssueMitigationComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueStatus> convertDetectedIssueStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueStatusEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case REGISTERED:
        tgt.setValue(org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueStatus.PRELIMINARY);
        break;
      case PRELIMINARY:
        tgt.setValue(org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueStatus.PRELIMINARY);
        break;
      case FINAL:
        tgt.setValue(org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueStatus.FINAL);
        break;
      case AMENDED:
        tgt.setValue(org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueStatus.FINAL);
        break;
      case CORRECTED:
        tgt.setValue(org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueStatus.MITIGATED);
        break;
      case CANCELLED:
        tgt.setValue(org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueStatus.MITIGATED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueStatus.ENTEREDINERROR);
        break;
      case UNKNOWN:
        tgt.setValue(org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueStatus.NULL);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueStatus> convertDetectedIssueStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueStatusEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case PRELIMINARY:
        tgt.setValue(org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueStatus.PRELIMINARY);
        break;
      case FINAL:
        tgt.setValue(org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueStatus.FINAL);
        break;
      case MITIGATED:
        tgt.setValue(org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueStatus.CORRECTED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueStatus.ENTEREDINERROR);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueSeverity> convertDetectedIssueSeverity(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueSeverity> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueSeverity> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueSeverityEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueSeverity> convertDetectedIssueSeverity(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueSeverity> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueSeverity> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueSeverityEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
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

  public static org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueEvidenceComponent convertDetectedIssueEvidenceComponent(org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueEvidenceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueEvidenceComponent tgt = new org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueEvidenceComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCode())
      tgt.addCode(CodeableConcept40_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getDetail()) tgt.addDetail(Reference40_50.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueEvidenceComponent convertDetectedIssueEvidenceComponent(org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueEvidenceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueEvidenceComponent tgt = new org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueEvidenceComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCode())
      tgt.addCode(CodeableConcept40_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getDetail()) tgt.addDetail(Reference40_50.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueMitigationComponent convertDetectedIssueMitigationComponent(org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueMitigationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueMitigationComponent tgt = new org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueMitigationComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasAction())
      tgt.setAction(CodeableConcept40_50.convertCodeableConcept(src.getAction()));
    if (src.hasDate())
      tgt.setDateElement(DateTime40_50.convertDateTime(src.getDateElement()));
    if (src.hasAuthor())
      tgt.setAuthor(Reference40_50.convertReference(src.getAuthor()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueMitigationComponent convertDetectedIssueMitigationComponent(org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueMitigationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueMitigationComponent tgt = new org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueMitigationComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasAction())
      tgt.setAction(CodeableConcept40_50.convertCodeableConcept(src.getAction()));
    if (src.hasDate())
      tgt.setDateElement(DateTime40_50.convertDateTime(src.getDateElement()));
    if (src.hasAuthor())
      tgt.setAuthor(Reference40_50.convertReference(src.getAuthor()));
    return tgt;
  }
}