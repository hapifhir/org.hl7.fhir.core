package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Identifier40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.DateTime40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.String40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Uri40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Reference40_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.DetectedIssue;
import org.hl7.fhir.model.core.Enumeration;

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

public class DetectedIssue40_N {

  public static org.hl7.fhir.model.core.DetectedIssue convertDetectedIssue(org.hl7.fhir.r4.model.DetectedIssue src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.DetectedIssue tgt = new org.hl7.fhir.model.core.DetectedIssue();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertDetectedIssueStatus(src.getStatusElement()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_N.convertCodeableConcept(src.getCode()));
    if (src.hasSeverity())
      tgt.setSeverity(convertDetectedIssueSeverity(src.getSeverityElement()));
    if (src.hasPatient())
      tgt.setSubject(Reference40_N.convertReference(src.getPatient()));
    if (src.hasIdentified())
      tgt.setIdentified(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getIdentified()));
    if (src.hasAuthor())
      tgt.setAuthor(Reference40_N.convertReference(src.getAuthor()));
    for (org.hl7.fhir.r4.model.Reference t : src.getImplicated()) tgt.addImplicated(Reference40_N.convertReference(t));
    for (org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueEvidenceComponent t : src.getEvidence())
      tgt.addEvidence(convertDetectedIssueEvidenceComponent(t));
    if (src.hasDetail())
      tgt.setDetailElement(String40_N.convertStringToMarkdown(src.getDetailElement()));
    if (src.hasReference())
      tgt.setReferenceElement(Uri40_N.convertUri(src.getReferenceElement()));
    for (org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueMitigationComponent t : src.getMitigation())
      tgt.addMitigation(convertDetectedIssueMitigationComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.DetectedIssue convertDetectedIssue(org.hl7.fhir.model.core.DetectedIssue src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.DetectedIssue tgt = new org.hl7.fhir.r4.model.DetectedIssue();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertDetectedIssueStatus(src.getStatusElement()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_N.convertCodeableConcept(src.getCode()));
    if (src.hasSeverity())
      tgt.setSeverityElement(convertDetectedIssueSeverity(src.getSeverity()));
    if (src.hasSubject())
      tgt.setPatient(Reference40_N.convertReference(src.getSubject()));
    if (src.hasIdentified())
      tgt.setIdentified(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getIdentified()));
    if (src.hasAuthor())
      tgt.setAuthor(Reference40_N.convertReference(src.getAuthor()));
    for (org.hl7.fhir.model.core.Reference t : src.getImplicatedList()) tgt.addImplicated(Reference40_N.convertReference(t));
    for (org.hl7.fhir.model.core.DetectedIssue.DetectedIssueEvidenceComponent t : src.getEvidenceList())
      tgt.addEvidence(convertDetectedIssueEvidenceComponent(t));
    if (src.hasDetail())
      tgt.setDetailElement(String40_N.convertString(src.getDetailElement()));
    if (src.hasReference())
      tgt.setReferenceElement(Uri40_N.convertUri(src.getReferenceElement()));
    for (org.hl7.fhir.model.core.DetectedIssue.DetectedIssueMitigationComponent t : src.getMitigationList())
      tgt.addMitigation(convertDetectedIssueMitigationComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.DetectedIssue.DetectedIssueStatus> convertDetectedIssueStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<DetectedIssue.DetectedIssueStatus> tgt = new Enumeration<>(new DetectedIssue.DetectedIssueStatusEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case REGISTERED:
                  tgt.setValue(DetectedIssue.DetectedIssueStatus.PRELIMINARY);
                  break;
              case PRELIMINARY:
                  tgt.setValue(DetectedIssue.DetectedIssueStatus.PRELIMINARY);
                  break;
              case FINAL:
                  tgt.setValue(DetectedIssue.DetectedIssueStatus.FINAL);
                  break;
              case AMENDED:
                  tgt.setValue(DetectedIssue.DetectedIssueStatus.FINAL);
                  break;
              case CORRECTED:
                  tgt.setValue(DetectedIssue.DetectedIssueStatus.MITIGATED);
                  break;
              case CANCELLED:
                  tgt.setValue(DetectedIssue.DetectedIssueStatus.MITIGATED);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(DetectedIssue.DetectedIssueStatus.ENTEREDINERROR);
                  break;
              case UNKNOWN:
                  tgt.setValue(DetectedIssue.DetectedIssueStatus.NULL);
                  break;
              default:
                  tgt.setValue(DetectedIssue.DetectedIssueStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueStatus> convertDetectedIssueStatus(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.DetectedIssue.DetectedIssueStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueStatusEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
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
      }
      return tgt;
  }

  static public org.hl7.fhir.model.core.CodeableConcept convertDetectedIssueSeverity(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueSeverity> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
    org.hl7.fhir.model.core.CodeableConcept tgt = new org.hl7.fhir.model.core.CodeableConcept();
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() != null) {
          switch (src.getValue()) {
              case HIGH:
                  tgt.addCoding("http://terminology.hl7.org/CodeSystem/detectedissue-severity", "high", "High");
                  break;
              case MODERATE:
                  tgt.addCoding("http://terminology.hl7.org/CodeSystem/detectedissue-severity", "moderate", "Moderate");
                  break;
              case LOW:
                  tgt.addCoding("http://terminology.hl7.org/CodeSystem/detectedissue-severity", "low", "Low");
                  break;
              default:
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueSeverity> convertDetectedIssueSeverity(org.hl7.fhir.model.core.CodeableConcept src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueSeverity> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueSeverityEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.hasCoding("http://terminology.hl7.org/CodeSystem/detectedissue-severity", "high")) {
        tgt.setValue(org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueSeverity.HIGH);
      } else if (src.hasCoding("http://terminology.hl7.org/CodeSystem/detectedissue-severity", "moderate")) {
        tgt.setValue(org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueSeverity.MODERATE);
      } else if (src.hasCoding("http://terminology.hl7.org/CodeSystem/detectedissue-severity", "low")) {
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.DetectedIssue.DetectedIssueEvidenceComponent convertDetectedIssueEvidenceComponent(org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueEvidenceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.DetectedIssue.DetectedIssueEvidenceComponent tgt = new org.hl7.fhir.model.core.DetectedIssue.DetectedIssueEvidenceComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCode())
      tgt.addCode(CodeableConcept40_N.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getDetail()) tgt.addDetail(Reference40_N.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueEvidenceComponent convertDetectedIssueEvidenceComponent(org.hl7.fhir.model.core.DetectedIssue.DetectedIssueEvidenceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueEvidenceComponent tgt = new org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueEvidenceComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getCodeList())
      tgt.addCode(CodeableConcept40_N.convertCodeableConcept(t));
    for (org.hl7.fhir.model.core.Reference t : src.getDetailList()) tgt.addDetail(Reference40_N.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.DetectedIssue.DetectedIssueMitigationComponent convertDetectedIssueMitigationComponent(org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueMitigationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.DetectedIssue.DetectedIssueMitigationComponent tgt = new org.hl7.fhir.model.core.DetectedIssue.DetectedIssueMitigationComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasAction())
      tgt.setAction(CodeableConcept40_N.convertCodeableConcept(src.getAction()));
    if (src.hasDate())
      tgt.setDateElement(DateTime40_N.convertDateTime(src.getDateElement()));
    if (src.hasAuthor())
      tgt.setAuthor(Reference40_N.convertReference(src.getAuthor()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueMitigationComponent convertDetectedIssueMitigationComponent(org.hl7.fhir.model.core.DetectedIssue.DetectedIssueMitigationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueMitigationComponent tgt = new org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueMitigationComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasAction())
      tgt.setAction(CodeableConcept40_N.convertCodeableConcept(src.getAction()));
    if (src.hasDate())
      tgt.setDateElement(DateTime40_N.convertDateTime(src.getDateElement()));
    if (src.hasAuthor())
      tgt.setAuthor(Reference40_N.convertReference(src.getAuthor()));
    return tgt;
  }
}