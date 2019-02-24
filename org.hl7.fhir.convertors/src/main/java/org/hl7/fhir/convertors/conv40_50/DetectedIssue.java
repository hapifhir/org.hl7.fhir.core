package org.hl7.fhir.convertors.conv40_50;

import org.hl7.fhir.exceptions.FHIRException;

import org.hl7.fhir.convertors.VersionConvertor_40_50;


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


public class DetectedIssue extends VersionConvertor_40_50 {

  public static org.hl7.fhir.r5.model.DetectedIssue convertDetectedIssue(org.hl7.fhir.r4.model.DetectedIssue src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.DetectedIssue tgt = new org.hl7.fhir.r5.model.DetectedIssue();
    copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatus(convertDetectedIssueStatus(src.getStatus()));
    if (src.hasCode())
      tgt.setCode(convertCodeableConcept(src.getCode()));
    if (src.hasSeverity())
      tgt.setSeverity(convertDetectedIssueSeverity(src.getSeverity()));
    if (src.hasPatient())
      tgt.setPatient(convertReference(src.getPatient()));
    if (src.hasIdentified())
      tgt.setIdentified(convertType(src.getIdentified()));
    if (src.hasAuthor())
      tgt.setAuthor(convertReference(src.getAuthor()));
    for (org.hl7.fhir.r4.model.Reference t : src.getImplicated())
      tgt.addImplicated(convertReference(t));
    for (org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueEvidenceComponent t : src.getEvidence())
      tgt.addEvidence(convertDetectedIssueEvidenceComponent(t));
    if (src.hasDetail())
      tgt.setDetailElement(convertString(src.getDetailElement()));
    if (src.hasReference())
      tgt.setReferenceElement(convertUri(src.getReferenceElement()));
    for (org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueMitigationComponent t : src.getMitigation())
      tgt.addMitigation(convertDetectedIssueMitigationComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.DetectedIssue convertDetectedIssue(org.hl7.fhir.r5.model.DetectedIssue src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.DetectedIssue tgt = new org.hl7.fhir.r4.model.DetectedIssue();
    copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatus(convertDetectedIssueStatus(src.getStatus()));
    if (src.hasCode())
      tgt.setCode(convertCodeableConcept(src.getCode()));
    if (src.hasSeverity())
      tgt.setSeverity(convertDetectedIssueSeverity(src.getSeverity()));
    if (src.hasPatient())
      tgt.setPatient(convertReference(src.getPatient()));
    if (src.hasIdentified())
      tgt.setIdentified(convertType(src.getIdentified()));
    if (src.hasAuthor())
      tgt.setAuthor(convertReference(src.getAuthor()));
    for (org.hl7.fhir.r5.model.Reference t : src.getImplicated())
      tgt.addImplicated(convertReference(t));
    for (org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueEvidenceComponent t : src.getEvidence())
      tgt.addEvidence(convertDetectedIssueEvidenceComponent(t));
    if (src.hasDetail())
      tgt.setDetailElement(convertString(src.getDetailElement()));
    if (src.hasReference())
      tgt.setReferenceElement(convertUri(src.getReferenceElement()));
    for (org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueMitigationComponent t : src.getMitigation())
      tgt.addMitigation(convertDetectedIssueMitigationComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueStatus convertDetectedIssueStatus(org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueStatus src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case REGISTERED: return org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueStatus.REGISTERED;
    case PRELIMINARY: return org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueStatus.PRELIMINARY;
    case FINAL: return org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueStatus.FINAL;
    case AMENDED: return org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueStatus.AMENDED;
    case CORRECTED: return org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueStatus.CORRECTED;
    case CANCELLED: return org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueStatus.CANCELLED;
    case ENTEREDINERROR: return org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueStatus.ENTEREDINERROR;
    case UNKNOWN: return org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueStatus.UNKNOWN;
    default: return org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueStatus.NULL;
  }
}

  public static org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueStatus convertDetectedIssueStatus(org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueStatus src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case REGISTERED: return org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueStatus.REGISTERED;
    case PRELIMINARY: return org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueStatus.PRELIMINARY;
    case FINAL: return org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueStatus.FINAL;
    case AMENDED: return org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueStatus.AMENDED;
    case CORRECTED: return org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueStatus.CORRECTED;
    case CANCELLED: return org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueStatus.CANCELLED;
    case ENTEREDINERROR: return org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueStatus.ENTEREDINERROR;
    case UNKNOWN: return org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueStatus.UNKNOWN;
    default: return org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueStatus.NULL;
  }
}

  public static org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueSeverity convertDetectedIssueSeverity(org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueSeverity src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case HIGH: return org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueSeverity.HIGH;
    case MODERATE: return org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueSeverity.MODERATE;
    case LOW: return org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueSeverity.LOW;
    default: return org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueSeverity.NULL;
  }
}

  public static org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueSeverity convertDetectedIssueSeverity(org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueSeverity src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case HIGH: return org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueSeverity.HIGH;
    case MODERATE: return org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueSeverity.MODERATE;
    case LOW: return org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueSeverity.LOW;
    default: return org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueSeverity.NULL;
  }
}

  public static org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueEvidenceComponent convertDetectedIssueEvidenceComponent(org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueEvidenceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueEvidenceComponent tgt = new org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueEvidenceComponent();
    copyElement(src, tgt);
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCode())
      tgt.addCode(convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getDetail())
      tgt.addDetail(convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueEvidenceComponent convertDetectedIssueEvidenceComponent(org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueEvidenceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueEvidenceComponent tgt = new org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueEvidenceComponent();
    copyElement(src, tgt);
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCode())
      tgt.addCode(convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getDetail())
      tgt.addDetail(convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueMitigationComponent convertDetectedIssueMitigationComponent(org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueMitigationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueMitigationComponent tgt = new org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueMitigationComponent();
    copyElement(src, tgt);
    if (src.hasAction())
      tgt.setAction(convertCodeableConcept(src.getAction()));
    if (src.hasDate())
      tgt.setDateElement(convertDateTime(src.getDateElement()));
    if (src.hasAuthor())
      tgt.setAuthor(convertReference(src.getAuthor()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueMitigationComponent convertDetectedIssueMitigationComponent(org.hl7.fhir.r5.model.DetectedIssue.DetectedIssueMitigationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueMitigationComponent tgt = new org.hl7.fhir.r4.model.DetectedIssue.DetectedIssueMitigationComponent();
    copyElement(src, tgt);
    if (src.hasAction())
      tgt.setAction(convertCodeableConcept(src.getAction()));
    if (src.hasDate())
      tgt.setDateElement(convertDateTime(src.getDateElement()));
    if (src.hasAuthor())
      tgt.setAuthor(convertReference(src.getAuthor()));
    return tgt;
  }


}
