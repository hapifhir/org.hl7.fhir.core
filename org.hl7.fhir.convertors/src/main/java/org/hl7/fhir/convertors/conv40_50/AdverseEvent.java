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


public class AdverseEvent extends VersionConvertor_40_50 {

  public static org.hl7.fhir.r5.model.AdverseEvent convertAdverseEvent(org.hl7.fhir.r4.model.AdverseEvent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.AdverseEvent tgt = new org.hl7.fhir.r5.model.AdverseEvent();
    copyDomainResource(src, tgt);
    if (src.hasIdentifier())
      tgt.setIdentifier(convertIdentifier(src.getIdentifier()));
    if (src.hasActuality())
      tgt.setActuality(convertAdverseEventActuality(src.getActuality()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(convertCodeableConcept(t));
    if (src.hasEvent())
      tgt.setEvent(convertCodeableConcept(src.getEvent()));
    if (src.hasSubject())
      tgt.setSubject(convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(convertReference(src.getEncounter()));
    if (src.hasDate())
      tgt.setDateElement(convertDateTime(src.getDateElement()));
    if (src.hasDetected())
      tgt.setDetectedElement(convertDateTime(src.getDetectedElement()));
    if (src.hasRecordedDate())
      tgt.setRecordedDateElement(convertDateTime(src.getRecordedDateElement()));
    for (org.hl7.fhir.r4.model.Reference t : src.getResultingCondition())
      tgt.addResultingCondition(convertReference(t));
    if (src.hasLocation())
      tgt.setLocation(convertReference(src.getLocation()));
    if (src.hasSeriousness())
      tgt.setSeriousness(convertCodeableConcept(src.getSeriousness()));
    if (src.hasSeverity())
      tgt.setSeverity(convertCodeableConcept(src.getSeverity()));
    if (src.hasOutcome())
      tgt.setOutcome(convertCodeableConcept(src.getOutcome()));
    if (src.hasRecorder())
      tgt.setRecorder(convertReference(src.getRecorder()));
    for (org.hl7.fhir.r4.model.Reference t : src.getContributor())
      tgt.addContributor(convertReference(t));
    for (org.hl7.fhir.r4.model.AdverseEvent.AdverseEventSuspectEntityComponent t : src.getSuspectEntity())
      tgt.addSuspectEntity(convertAdverseEventSuspectEntityComponent(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getSubjectMedicalHistory())
      tgt.addSubjectMedicalHistory(convertReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getReferenceDocument())
      tgt.addReferenceDocument(convertReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getStudy())
      tgt.addStudy(convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.AdverseEvent convertAdverseEvent(org.hl7.fhir.r5.model.AdverseEvent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.AdverseEvent tgt = new org.hl7.fhir.r4.model.AdverseEvent();
    copyDomainResource(src, tgt);
    if (src.hasIdentifier())
      tgt.setIdentifier(convertIdentifier(src.getIdentifier()));
    if (src.hasActuality())
      tgt.setActuality(convertAdverseEventActuality(src.getActuality()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(convertCodeableConcept(t));
    if (src.hasEvent())
      tgt.setEvent(convertCodeableConcept(src.getEvent()));
    if (src.hasSubject())
      tgt.setSubject(convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(convertReference(src.getEncounter()));
    if (src.hasDate())
      tgt.setDateElement(convertDateTime(src.getDateElement()));
    if (src.hasDetected())
      tgt.setDetectedElement(convertDateTime(src.getDetectedElement()));
    if (src.hasRecordedDate())
      tgt.setRecordedDateElement(convertDateTime(src.getRecordedDateElement()));
    for (org.hl7.fhir.r5.model.Reference t : src.getResultingCondition())
      tgt.addResultingCondition(convertReference(t));
    if (src.hasLocation())
      tgt.setLocation(convertReference(src.getLocation()));
    if (src.hasSeriousness())
      tgt.setSeriousness(convertCodeableConcept(src.getSeriousness()));
    if (src.hasSeverity())
      tgt.setSeverity(convertCodeableConcept(src.getSeverity()));
    if (src.hasOutcome())
      tgt.setOutcome(convertCodeableConcept(src.getOutcome()));
    if (src.hasRecorder())
      tgt.setRecorder(convertReference(src.getRecorder()));
    for (org.hl7.fhir.r5.model.Reference t : src.getContributor())
      tgt.addContributor(convertReference(t));
    for (org.hl7.fhir.r5.model.AdverseEvent.AdverseEventSuspectEntityComponent t : src.getSuspectEntity())
      tgt.addSuspectEntity(convertAdverseEventSuspectEntityComponent(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getSubjectMedicalHistory())
      tgt.addSubjectMedicalHistory(convertReference(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getReferenceDocument())
      tgt.addReferenceDocument(convertReference(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getStudy())
      tgt.addStudy(convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.AdverseEvent.AdverseEventActuality convertAdverseEventActuality(org.hl7.fhir.r4.model.AdverseEvent.AdverseEventActuality src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case ACTUAL: return org.hl7.fhir.r5.model.AdverseEvent.AdverseEventActuality.ACTUAL;
    case POTENTIAL: return org.hl7.fhir.r5.model.AdverseEvent.AdverseEventActuality.POTENTIAL;
    default: return org.hl7.fhir.r5.model.AdverseEvent.AdverseEventActuality.NULL;
  }
}

  public static org.hl7.fhir.r4.model.AdverseEvent.AdverseEventActuality convertAdverseEventActuality(org.hl7.fhir.r5.model.AdverseEvent.AdverseEventActuality src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case ACTUAL: return org.hl7.fhir.r4.model.AdverseEvent.AdverseEventActuality.ACTUAL;
    case POTENTIAL: return org.hl7.fhir.r4.model.AdverseEvent.AdverseEventActuality.POTENTIAL;
    default: return org.hl7.fhir.r4.model.AdverseEvent.AdverseEventActuality.NULL;
  }
}

  public static org.hl7.fhir.r5.model.AdverseEvent.AdverseEventSuspectEntityComponent convertAdverseEventSuspectEntityComponent(org.hl7.fhir.r4.model.AdverseEvent.AdverseEventSuspectEntityComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.AdverseEvent.AdverseEventSuspectEntityComponent tgt = new org.hl7.fhir.r5.model.AdverseEvent.AdverseEventSuspectEntityComponent();
    copyElement(src, tgt);
    if (src.hasInstance())
      tgt.setInstance(convertReference(src.getInstance()));
    for (org.hl7.fhir.r4.model.AdverseEvent.AdverseEventSuspectEntityCausalityComponent t : src.getCausality())
      tgt.addCausality(convertAdverseEventSuspectEntityCausalityComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.AdverseEvent.AdverseEventSuspectEntityComponent convertAdverseEventSuspectEntityComponent(org.hl7.fhir.r5.model.AdverseEvent.AdverseEventSuspectEntityComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.AdverseEvent.AdverseEventSuspectEntityComponent tgt = new org.hl7.fhir.r4.model.AdverseEvent.AdverseEventSuspectEntityComponent();
    copyElement(src, tgt);
    if (src.hasInstance())
      tgt.setInstance(convertReference(src.getInstance()));
    for (org.hl7.fhir.r5.model.AdverseEvent.AdverseEventSuspectEntityCausalityComponent t : src.getCausality())
      tgt.addCausality(convertAdverseEventSuspectEntityCausalityComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.AdverseEvent.AdverseEventSuspectEntityCausalityComponent convertAdverseEventSuspectEntityCausalityComponent(org.hl7.fhir.r4.model.AdverseEvent.AdverseEventSuspectEntityCausalityComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.AdverseEvent.AdverseEventSuspectEntityCausalityComponent tgt = new org.hl7.fhir.r5.model.AdverseEvent.AdverseEventSuspectEntityCausalityComponent();
    copyElement(src, tgt);
    if (src.hasAssessment())
      tgt.setAssessment(convertCodeableConcept(src.getAssessment()));
    if (src.hasProductRelatedness())
      tgt.setProductRelatednessElement(convertString(src.getProductRelatednessElement()));
    if (src.hasAuthor())
      tgt.setAuthor(convertReference(src.getAuthor()));
    if (src.hasMethod())
      tgt.setMethod(convertCodeableConcept(src.getMethod()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.AdverseEvent.AdverseEventSuspectEntityCausalityComponent convertAdverseEventSuspectEntityCausalityComponent(org.hl7.fhir.r5.model.AdverseEvent.AdverseEventSuspectEntityCausalityComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.AdverseEvent.AdverseEventSuspectEntityCausalityComponent tgt = new org.hl7.fhir.r4.model.AdverseEvent.AdverseEventSuspectEntityCausalityComponent();
    copyElement(src, tgt);
    if (src.hasAssessment())
      tgt.setAssessment(convertCodeableConcept(src.getAssessment()));
    if (src.hasProductRelatedness())
      tgt.setProductRelatednessElement(convertString(src.getProductRelatednessElement()));
    if (src.hasAuthor())
      tgt.setAuthor(convertReference(src.getAuthor()));
    if (src.hasMethod())
      tgt.setMethod(convertCodeableConcept(src.getMethod()));
    return tgt;
  }


}
