package org.hl7.fhir.convertors.conv43_N.resources43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.CodeableConcept43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Identifier43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.DateTime43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.String43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Uri43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.special43_N.Reference43_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.DetectedIssue;
import org.hl7.fhir.model.core.Enumeration;
import org.hl7.fhir.r4b.model.Enumerations;

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

public class DetectedIssue43_N {

  public static org.hl7.fhir.model.core.DetectedIssue convertDetectedIssue(org.hl7.fhir.r4b.model.DetectedIssue src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.DetectedIssue tgt = new org.hl7.fhir.model.core.DetectedIssue();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertDetectedIssueStatus(src.getStatusElement()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_N.convertCodeableConcept(src.getCode()));
    if (src.hasSeverity())
      tgt.setSeverity(convertDetectedIssueSeverity(src.getSeverityElement()));
    if (src.hasPatient())
      tgt.setSubject(Reference43_N.convertReference(src.getPatient()));
    if (src.hasIdentified())
      tgt.setIdentified(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getIdentified()));
    if (src.hasAuthor())
      tgt.setAuthor(Reference43_N.convertReference(src.getAuthor()));
    for (org.hl7.fhir.r4b.model.Reference t : src.getImplicated()) tgt.addImplicated(Reference43_N.convertReference(t));
    for (org.hl7.fhir.r4b.model.DetectedIssue.DetectedIssueEvidenceComponent t : src.getEvidence())
      tgt.addEvidence(convertDetectedIssueEvidenceComponent(t));
    if (src.hasDetail())
      tgt.setDetailElement(String43_N.convertStringToMarkdown(src.getDetailElement()));
    if (src.hasReference())
      tgt.setReferenceElement(Uri43_N.convertUri(src.getReferenceElement()));
    for (org.hl7.fhir.r4b.model.DetectedIssue.DetectedIssueMitigationComponent t : src.getMitigation())
      tgt.addMitigation(convertDetectedIssueMitigationComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.DetectedIssue convertDetectedIssue(org.hl7.fhir.model.core.DetectedIssue src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.DetectedIssue tgt = new org.hl7.fhir.r4b.model.DetectedIssue();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertDetectedIssueStatus(src.getStatusElement()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_N.convertCodeableConcept(src.getCode()));
    if (src.hasSeverity())
      tgt.setSeverityElement(convertDetectedIssueSeverity(src.getSeverity()));
    if (src.hasSubject())
      tgt.setPatient(Reference43_N.convertReference(src.getSubject()));
    if (src.hasIdentified())
      tgt.setIdentified(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getIdentified()));
    if (src.hasAuthor())
      tgt.setAuthor(Reference43_N.convertReference(src.getAuthor()));
    for (org.hl7.fhir.model.core.Reference t : src.getImplicatedList()) tgt.addImplicated(Reference43_N.convertReference(t));
    for (org.hl7.fhir.model.core.DetectedIssue.DetectedIssueEvidenceComponent t : src.getEvidenceList())
      tgt.addEvidence(convertDetectedIssueEvidenceComponent(t));
    if (src.hasDetail())
      tgt.setDetailElement(String43_N.convertString(src.getDetailElement()));
    if (src.hasReference())
      tgt.setReferenceElement(Uri43_N.convertUri(src.getReferenceElement()));
    for (org.hl7.fhir.model.core.DetectedIssue.DetectedIssueMitigationComponent t : src.getMitigationList())
      tgt.addMitigation(convertDetectedIssueMitigationComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.DetectedIssue.DetectedIssueStatus> convertDetectedIssueStatus(org.hl7.fhir.r4b.model.Enumeration<Enumerations.ObservationStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<DetectedIssue.DetectedIssueStatus> tgt = new Enumeration<>(new DetectedIssue.DetectedIssueStatusEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.ObservationStatus> convertDetectedIssueStatus(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.DetectedIssue.DetectedIssueStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.ObservationStatus> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new Enumerations.ObservationStatusEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case PRELIMINARY:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.ObservationStatus.PRELIMINARY);
                  break;
              case FINAL:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.ObservationStatus.FINAL);
                  break;
              case MITIGATED:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.ObservationStatus.CORRECTED);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.ObservationStatus.ENTEREDINERROR);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.ObservationStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.model.core.CodeableConcept convertDetectedIssueSeverity(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.DetectedIssue.DetectedIssueSeverity> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
    org.hl7.fhir.model.core.CodeableConcept tgt = new org.hl7.fhir.model.core.CodeableConcept();
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.DetectedIssue.DetectedIssueSeverity> convertDetectedIssueSeverity(org.hl7.fhir.model.core.CodeableConcept src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.DetectedIssue.DetectedIssueSeverity> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.DetectedIssue.DetectedIssueSeverityEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.hasCoding("http://terminology.hl7.org/CodeSystem/detectedissue-severity", "high")) {
        tgt.setValue(org.hl7.fhir.r4b.model.DetectedIssue.DetectedIssueSeverity.HIGH);
      } else if (src.hasCoding("http://terminology.hl7.org/CodeSystem/detectedissue-severity", "moderate")) {
        tgt.setValue(org.hl7.fhir.r4b.model.DetectedIssue.DetectedIssueSeverity.MODERATE);
      } else if (src.hasCoding("http://terminology.hl7.org/CodeSystem/detectedissue-severity", "low")) {
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.DetectedIssue.DetectedIssueEvidenceComponent convertDetectedIssueEvidenceComponent(org.hl7.fhir.r4b.model.DetectedIssue.DetectedIssueEvidenceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.DetectedIssue.DetectedIssueEvidenceComponent tgt = new org.hl7.fhir.model.core.DetectedIssue.DetectedIssueEvidenceComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getCode())
      tgt.addCode(CodeableConcept43_N.convertCodeableConcept(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getDetail()) tgt.addDetail(Reference43_N.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.DetectedIssue.DetectedIssueEvidenceComponent convertDetectedIssueEvidenceComponent(org.hl7.fhir.model.core.DetectedIssue.DetectedIssueEvidenceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.DetectedIssue.DetectedIssueEvidenceComponent tgt = new org.hl7.fhir.r4b.model.DetectedIssue.DetectedIssueEvidenceComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getCodeList())
      tgt.addCode(CodeableConcept43_N.convertCodeableConcept(t));
    for (org.hl7.fhir.model.core.Reference t : src.getDetailList()) tgt.addDetail(Reference43_N.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.DetectedIssue.DetectedIssueMitigationComponent convertDetectedIssueMitigationComponent(org.hl7.fhir.r4b.model.DetectedIssue.DetectedIssueMitigationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.DetectedIssue.DetectedIssueMitigationComponent tgt = new org.hl7.fhir.model.core.DetectedIssue.DetectedIssueMitigationComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasAction())
      tgt.setAction(CodeableConcept43_N.convertCodeableConcept(src.getAction()));
    if (src.hasDate())
      tgt.setDateElement(DateTime43_N.convertDateTime(src.getDateElement()));
    if (src.hasAuthor())
      tgt.setAuthor(Reference43_N.convertReference(src.getAuthor()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.DetectedIssue.DetectedIssueMitigationComponent convertDetectedIssueMitigationComponent(org.hl7.fhir.model.core.DetectedIssue.DetectedIssueMitigationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.DetectedIssue.DetectedIssueMitigationComponent tgt = new org.hl7.fhir.r4b.model.DetectedIssue.DetectedIssueMitigationComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasAction())
      tgt.setAction(CodeableConcept43_N.convertCodeableConcept(src.getAction()));
    if (src.hasDate())
      tgt.setDateElement(DateTime43_N.convertDateTime(src.getDateElement()));
    if (src.hasAuthor())
      tgt.setAuthor(Reference43_N.convertReference(src.getAuthor()));
    return tgt;
  }
}