package org.hl7.fhir.convertors.conv40_50;


import org.hl7.fhir.convertors.VersionConvertor_40_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CodeableReference;

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
public class FamilyMemberHistory40_50 extends VersionConvertor_40_50 {

    public static org.hl7.fhir.r5.model.FamilyMemberHistory convertFamilyMemberHistory(org.hl7.fhir.r4.model.FamilyMemberHistory src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.FamilyMemberHistory tgt = new org.hl7.fhir.r5.model.FamilyMemberHistory();
        copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        for (org.hl7.fhir.r4.model.CanonicalType t : src.getInstantiatesCanonical()) tgt.getInstantiatesCanonical().add(convertCanonical(t));
        for (org.hl7.fhir.r4.model.UriType t : src.getInstantiatesUri()) tgt.getInstantiatesUri().add(convertUri(t));
        if (src.hasStatus())
            tgt.setStatusElement(convertFamilyHistoryStatus(src.getStatusElement()));
        if (src.hasDataAbsentReason())
            tgt.setDataAbsentReason(convertCodeableConcept(src.getDataAbsentReason()));
        if (src.hasPatient())
            tgt.setPatient(convertReference(src.getPatient()));
        if (src.hasDate())
            tgt.setDateElement(convertDateTime(src.getDateElement()));
        if (src.hasName())
            tgt.setNameElement(convertString(src.getNameElement()));
        if (src.hasRelationship())
            tgt.setRelationship(convertCodeableConcept(src.getRelationship()));
        if (src.hasSex())
            tgt.setSex(convertCodeableConcept(src.getSex()));
        if (src.hasBorn())
            tgt.setBorn(convertType(src.getBorn()));
        if (src.hasAge())
            tgt.setAge(convertType(src.getAge()));
        if (src.hasEstimatedAge())
            tgt.setEstimatedAgeElement(convertBoolean(src.getEstimatedAgeElement()));
        if (src.hasDeceased())
            tgt.setDeceased(convertType(src.getDeceased()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReasonCode()) tgt.addReason(convertCodeableConceptToCodeableReference(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getReasonReference()) tgt.addReason(convertReferenceToCodeableReference(t));
        for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.addNote(convertAnnotation(t));
        for (org.hl7.fhir.r4.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent t : src.getCondition()) tgt.addCondition(convertFamilyMemberHistoryConditionComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.FamilyMemberHistory convertFamilyMemberHistory(org.hl7.fhir.r5.model.FamilyMemberHistory src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.FamilyMemberHistory tgt = new org.hl7.fhir.r4.model.FamilyMemberHistory();
        copyDomainResource(src, tgt);
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        for (org.hl7.fhir.r5.model.CanonicalType t : src.getInstantiatesCanonical()) tgt.getInstantiatesCanonical().add(convertCanonical(t));
        for (org.hl7.fhir.r5.model.UriType t : src.getInstantiatesUri()) tgt.getInstantiatesUri().add(convertUri(t));
        if (src.hasStatus())
            tgt.setStatusElement(convertFamilyHistoryStatus(src.getStatusElement()));
        if (src.hasDataAbsentReason())
            tgt.setDataAbsentReason(convertCodeableConcept(src.getDataAbsentReason()));
        if (src.hasPatient())
            tgt.setPatient(convertReference(src.getPatient()));
        if (src.hasDate())
            tgt.setDateElement(convertDateTime(src.getDateElement()));
        if (src.hasName())
            tgt.setNameElement(convertString(src.getNameElement()));
        if (src.hasRelationship())
            tgt.setRelationship(convertCodeableConcept(src.getRelationship()));
        if (src.hasSex())
            tgt.setSex(convertCodeableConcept(src.getSex()));
        if (src.hasBorn())
            tgt.setBorn(convertType(src.getBorn()));
        if (src.hasAge())
            tgt.setAge(convertType(src.getAge()));
        if (src.hasEstimatedAge())
            tgt.setEstimatedAgeElement(convertBoolean(src.getEstimatedAgeElement()));
        if (src.hasDeceased())
            tgt.setDeceased(convertType(src.getDeceased()));
        for (CodeableReference t : src.getReason()) if (t.hasConcept())
            tgt.addReasonCode(convertCodeableConcept(t.getConcept()));
        for (CodeableReference t : src.getReason()) if (t.hasReference())
            tgt.addReasonReference(convertReference(t.getReference()));
        for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.addNote(convertAnnotation(t));
        for (org.hl7.fhir.r5.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent t : src.getCondition()) tgt.addCondition(convertFamilyMemberHistoryConditionComponent(t));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.FamilyMemberHistory.FamilyHistoryStatus> convertFamilyHistoryStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.FamilyMemberHistory.FamilyHistoryStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.FamilyMemberHistory.FamilyHistoryStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.FamilyMemberHistory.FamilyHistoryStatusEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case PARTIAL:
                tgt.setValue(org.hl7.fhir.r5.model.FamilyMemberHistory.FamilyHistoryStatus.PARTIAL);
                break;
            case COMPLETED:
                tgt.setValue(org.hl7.fhir.r5.model.FamilyMemberHistory.FamilyHistoryStatus.COMPLETED);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.r5.model.FamilyMemberHistory.FamilyHistoryStatus.ENTEREDINERROR);
                break;
            case HEALTHUNKNOWN:
                tgt.setValue(org.hl7.fhir.r5.model.FamilyMemberHistory.FamilyHistoryStatus.HEALTHUNKNOWN);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.FamilyMemberHistory.FamilyHistoryStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.FamilyMemberHistory.FamilyHistoryStatus> convertFamilyHistoryStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.FamilyMemberHistory.FamilyHistoryStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.FamilyMemberHistory.FamilyHistoryStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.FamilyMemberHistory.FamilyHistoryStatusEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case PARTIAL:
                tgt.setValue(org.hl7.fhir.r4.model.FamilyMemberHistory.FamilyHistoryStatus.PARTIAL);
                break;
            case COMPLETED:
                tgt.setValue(org.hl7.fhir.r4.model.FamilyMemberHistory.FamilyHistoryStatus.COMPLETED);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.r4.model.FamilyMemberHistory.FamilyHistoryStatus.ENTEREDINERROR);
                break;
            case HEALTHUNKNOWN:
                tgt.setValue(org.hl7.fhir.r4.model.FamilyMemberHistory.FamilyHistoryStatus.HEALTHUNKNOWN);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.FamilyMemberHistory.FamilyHistoryStatus.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent convertFamilyMemberHistoryConditionComponent(org.hl7.fhir.r4.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent tgt = new org.hl7.fhir.r5.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent();
        copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCode(convertCodeableConcept(src.getCode()));
        if (src.hasOutcome())
            tgt.setOutcome(convertCodeableConcept(src.getOutcome()));
        if (src.hasContributedToDeath())
            tgt.setContributedToDeathElement(convertBoolean(src.getContributedToDeathElement()));
        if (src.hasOnset())
            tgt.setOnset(convertType(src.getOnset()));
        for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.addNote(convertAnnotation(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent convertFamilyMemberHistoryConditionComponent(org.hl7.fhir.r5.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent tgt = new org.hl7.fhir.r4.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent();
        copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCode(convertCodeableConcept(src.getCode()));
        if (src.hasOutcome())
            tgt.setOutcome(convertCodeableConcept(src.getOutcome()));
        if (src.hasContributedToDeath())
            tgt.setContributedToDeathElement(convertBoolean(src.getContributedToDeathElement()));
        if (src.hasOnset())
            tgt.setOnset(convertType(src.getOnset()));
        for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.addNote(convertAnnotation(t));
        return tgt;
    }
}