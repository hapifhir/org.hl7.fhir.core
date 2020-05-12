package org.hl7.fhir.convertors.conv40_50;


import org.hl7.fhir.convertors.VersionConvertor_40_50;
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
public class Condition40_50 extends VersionConvertor_40_50 {

    public static org.hl7.fhir.r5.model.Condition convertCondition(org.hl7.fhir.r4.model.Condition src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Condition tgt = new org.hl7.fhir.r5.model.Condition();
        copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        if (src.hasClinicalStatus())
            tgt.setClinicalStatus(convertCodeableConcept(src.getClinicalStatus()));
        if (src.hasVerificationStatus())
            tgt.setVerificationStatus(convertCodeableConcept(src.getVerificationStatus()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCategory()) tgt.addCategory(convertCodeableConcept(t));
        if (src.hasSeverity())
            tgt.setSeverity(convertCodeableConcept(src.getSeverity()));
        if (src.hasCode())
            tgt.setCode(convertCodeableConcept(src.getCode()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getBodySite()) tgt.addBodySite(convertCodeableConcept(t));
        if (src.hasSubject())
            tgt.setSubject(convertReference(src.getSubject()));
        if (src.hasEncounter())
            tgt.setEncounter(convertReference(src.getEncounter()));
        if (src.hasOnset())
            tgt.setOnset(convertType(src.getOnset()));
        if (src.hasAbatement())
            tgt.setAbatement(convertType(src.getAbatement()));
        if (src.hasRecordedDate())
            tgt.setRecordedDateElement(convertDateTime(src.getRecordedDateElement()));
        if (src.hasRecorder())
            tgt.setRecorder(convertReference(src.getRecorder()));
        if (src.hasAsserter())
            tgt.setAsserter(convertReference(src.getAsserter()));
        for (org.hl7.fhir.r4.model.Condition.ConditionStageComponent t : src.getStage()) tgt.addStage(convertConditionStageComponent(t));
        for (org.hl7.fhir.r4.model.Condition.ConditionEvidenceComponent t : src.getEvidence()) tgt.addEvidence(convertConditionEvidenceComponent(t));
        for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.addNote(convertAnnotation(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Condition convertCondition(org.hl7.fhir.r5.model.Condition src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Condition tgt = new org.hl7.fhir.r4.model.Condition();
        copyDomainResource(src, tgt);
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        if (src.hasClinicalStatus())
            tgt.setClinicalStatus(convertCodeableConcept(src.getClinicalStatus()));
        if (src.hasVerificationStatus())
            tgt.setVerificationStatus(convertCodeableConcept(src.getVerificationStatus()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCategory()) tgt.addCategory(convertCodeableConcept(t));
        if (src.hasSeverity())
            tgt.setSeverity(convertCodeableConcept(src.getSeverity()));
        if (src.hasCode())
            tgt.setCode(convertCodeableConcept(src.getCode()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getBodySite()) tgt.addBodySite(convertCodeableConcept(t));
        if (src.hasSubject())
            tgt.setSubject(convertReference(src.getSubject()));
        if (src.hasEncounter())
            tgt.setEncounter(convertReference(src.getEncounter()));
        if (src.hasOnset())
            tgt.setOnset(convertType(src.getOnset()));
        if (src.hasAbatement())
            tgt.setAbatement(convertType(src.getAbatement()));
        if (src.hasRecordedDate())
            tgt.setRecordedDateElement(convertDateTime(src.getRecordedDateElement()));
        if (src.hasRecorder())
            tgt.setRecorder(convertReference(src.getRecorder()));
        if (src.hasAsserter())
            tgt.setAsserter(convertReference(src.getAsserter()));
        for (org.hl7.fhir.r5.model.Condition.ConditionStageComponent t : src.getStage()) tgt.addStage(convertConditionStageComponent(t));
        for (org.hl7.fhir.r5.model.Condition.ConditionEvidenceComponent t : src.getEvidence()) tgt.addEvidence(convertConditionEvidenceComponent(t));
        for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.addNote(convertAnnotation(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Condition.ConditionStageComponent convertConditionStageComponent(org.hl7.fhir.r4.model.Condition.ConditionStageComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Condition.ConditionStageComponent tgt = new org.hl7.fhir.r5.model.Condition.ConditionStageComponent();
        copyElement(src, tgt);
        if (src.hasSummary())
            tgt.setSummary(convertCodeableConcept(src.getSummary()));
        for (org.hl7.fhir.r4.model.Reference t : src.getAssessment()) tgt.addAssessment(convertReference(t));
        if (src.hasType())
            tgt.setType(convertCodeableConcept(src.getType()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Condition.ConditionStageComponent convertConditionStageComponent(org.hl7.fhir.r5.model.Condition.ConditionStageComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Condition.ConditionStageComponent tgt = new org.hl7.fhir.r4.model.Condition.ConditionStageComponent();
        copyElement(src, tgt);
        if (src.hasSummary())
            tgt.setSummary(convertCodeableConcept(src.getSummary()));
        for (org.hl7.fhir.r5.model.Reference t : src.getAssessment()) tgt.addAssessment(convertReference(t));
        if (src.hasType())
            tgt.setType(convertCodeableConcept(src.getType()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Condition.ConditionEvidenceComponent convertConditionEvidenceComponent(org.hl7.fhir.r4.model.Condition.ConditionEvidenceComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Condition.ConditionEvidenceComponent tgt = new org.hl7.fhir.r5.model.Condition.ConditionEvidenceComponent();
        copyElement(src, tgt);
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCode()) tgt.addCode(convertCodeableConcept(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getDetail()) tgt.addDetail(convertReference(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Condition.ConditionEvidenceComponent convertConditionEvidenceComponent(org.hl7.fhir.r5.model.Condition.ConditionEvidenceComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Condition.ConditionEvidenceComponent tgt = new org.hl7.fhir.r4.model.Condition.ConditionEvidenceComponent();
        copyElement(src, tgt);
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCode()) tgt.addCode(convertCodeableConcept(t));
        for (org.hl7.fhir.r5.model.Reference t : src.getDetail()) tgt.addDetail(convertReference(t));
        return tgt;
    }
}