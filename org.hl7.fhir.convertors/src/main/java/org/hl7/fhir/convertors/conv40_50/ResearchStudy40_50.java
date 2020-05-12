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
public class ResearchStudy40_50 extends VersionConvertor_40_50 {

    public static org.hl7.fhir.r5.model.ResearchStudy convertResearchStudy(org.hl7.fhir.r4.model.ResearchStudy src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ResearchStudy tgt = new org.hl7.fhir.r5.model.ResearchStudy();
        copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        if (src.hasTitle())
            tgt.setTitleElement(convertString(src.getTitleElement()));
        for (org.hl7.fhir.r4.model.Reference t : src.getProtocol()) tgt.addProtocol(convertReference(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getPartOf()) tgt.addPartOf(convertReference(t));
        if (src.hasStatus())
            tgt.setStatusElement(convertResearchStudyStatus(src.getStatusElement()));
        if (src.hasPrimaryPurposeType())
            tgt.setPrimaryPurposeType(convertCodeableConcept(src.getPrimaryPurposeType()));
        if (src.hasPhase())
            tgt.setPhase(convertCodeableConcept(src.getPhase()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCategory()) tgt.addCategory(convertCodeableConcept(t));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getFocus()) tgt.addFocus(convertCodeableConcept(t));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCondition()) tgt.addCondition(convertCodeableConcept(t));
        for (org.hl7.fhir.r4.model.ContactDetail t : src.getContact()) tgt.addContact(convertContactDetail(t));
        for (org.hl7.fhir.r4.model.RelatedArtifact t : src.getRelatedArtifact()) tgt.addRelatedArtifact(convertRelatedArtifact(t));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getKeyword()) tgt.addKeyword(convertCodeableConcept(t));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getLocation()) tgt.addLocation(convertCodeableConcept(t));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertMarkdown(src.getDescriptionElement()));
        for (org.hl7.fhir.r4.model.Reference t : src.getEnrollment()) tgt.addEnrollment(convertReference(t));
        if (src.hasPeriod())
            tgt.setPeriod(convertPeriod(src.getPeriod()));
        if (src.hasSponsor())
            tgt.setSponsor(convertReference(src.getSponsor()));
        if (src.hasPrincipalInvestigator())
            tgt.setPrincipalInvestigator(convertReference(src.getPrincipalInvestigator()));
        for (org.hl7.fhir.r4.model.Reference t : src.getSite()) tgt.addSite(convertReference(t));
        if (src.hasReasonStopped())
            tgt.setReasonStopped(convertCodeableConcept(src.getReasonStopped()));
        for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.addNote(convertAnnotation(t));
        for (org.hl7.fhir.r4.model.ResearchStudy.ResearchStudyArmComponent t : src.getArm()) tgt.addArm(convertResearchStudyArmComponent(t));
        for (org.hl7.fhir.r4.model.ResearchStudy.ResearchStudyObjectiveComponent t : src.getObjective()) tgt.addObjective(convertResearchStudyObjectiveComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ResearchStudy convertResearchStudy(org.hl7.fhir.r5.model.ResearchStudy src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ResearchStudy tgt = new org.hl7.fhir.r4.model.ResearchStudy();
        copyDomainResource(src, tgt);
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        if (src.hasTitle())
            tgt.setTitleElement(convertString(src.getTitleElement()));
        for (org.hl7.fhir.r5.model.Reference t : src.getProtocol()) tgt.addProtocol(convertReference(t));
        for (org.hl7.fhir.r5.model.Reference t : src.getPartOf()) tgt.addPartOf(convertReference(t));
        if (src.hasStatus())
            tgt.setStatusElement(convertResearchStudyStatus(src.getStatusElement()));
        if (src.hasPrimaryPurposeType())
            tgt.setPrimaryPurposeType(convertCodeableConcept(src.getPrimaryPurposeType()));
        if (src.hasPhase())
            tgt.setPhase(convertCodeableConcept(src.getPhase()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCategory()) tgt.addCategory(convertCodeableConcept(t));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getFocus()) tgt.addFocus(convertCodeableConcept(t));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCondition()) tgt.addCondition(convertCodeableConcept(t));
        for (org.hl7.fhir.r5.model.ContactDetail t : src.getContact()) tgt.addContact(convertContactDetail(t));
        for (org.hl7.fhir.r5.model.RelatedArtifact t : src.getRelatedArtifact()) tgt.addRelatedArtifact(convertRelatedArtifact(t));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getKeyword()) tgt.addKeyword(convertCodeableConcept(t));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getLocation()) tgt.addLocation(convertCodeableConcept(t));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertMarkdown(src.getDescriptionElement()));
        for (org.hl7.fhir.r5.model.Reference t : src.getEnrollment()) tgt.addEnrollment(convertReference(t));
        if (src.hasPeriod())
            tgt.setPeriod(convertPeriod(src.getPeriod()));
        if (src.hasSponsor())
            tgt.setSponsor(convertReference(src.getSponsor()));
        if (src.hasPrincipalInvestigator())
            tgt.setPrincipalInvestigator(convertReference(src.getPrincipalInvestigator()));
        for (org.hl7.fhir.r5.model.Reference t : src.getSite()) tgt.addSite(convertReference(t));
        if (src.hasReasonStopped())
            tgt.setReasonStopped(convertCodeableConcept(src.getReasonStopped()));
        for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.addNote(convertAnnotation(t));
        for (org.hl7.fhir.r5.model.ResearchStudy.ResearchStudyArmComponent t : src.getArm()) tgt.addArm(convertResearchStudyArmComponent(t));
        for (org.hl7.fhir.r5.model.ResearchStudy.ResearchStudyObjectiveComponent t : src.getObjective()) tgt.addObjective(convertResearchStudyObjectiveComponent(t));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ResearchStudy.ResearchStudyStatus> convertResearchStudyStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ResearchStudy.ResearchStudyStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ResearchStudy.ResearchStudyStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.ResearchStudy.ResearchStudyStatusEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case ACTIVE:
                tgt.setValue(org.hl7.fhir.r5.model.ResearchStudy.ResearchStudyStatus.ACTIVE);
                break;
            case ADMINISTRATIVELYCOMPLETED:
                tgt.setValue(org.hl7.fhir.r5.model.ResearchStudy.ResearchStudyStatus.ADMINISTRATIVELYCOMPLETED);
                break;
            case APPROVED:
                tgt.setValue(org.hl7.fhir.r5.model.ResearchStudy.ResearchStudyStatus.APPROVED);
                break;
            case CLOSEDTOACCRUAL:
                tgt.setValue(org.hl7.fhir.r5.model.ResearchStudy.ResearchStudyStatus.CLOSEDTOACCRUAL);
                break;
            case CLOSEDTOACCRUALANDINTERVENTION:
                tgt.setValue(org.hl7.fhir.r5.model.ResearchStudy.ResearchStudyStatus.CLOSEDTOACCRUALANDINTERVENTION);
                break;
            case COMPLETED:
                tgt.setValue(org.hl7.fhir.r5.model.ResearchStudy.ResearchStudyStatus.COMPLETED);
                break;
            case DISAPPROVED:
                tgt.setValue(org.hl7.fhir.r5.model.ResearchStudy.ResearchStudyStatus.DISAPPROVED);
                break;
            case INREVIEW:
                tgt.setValue(org.hl7.fhir.r5.model.ResearchStudy.ResearchStudyStatus.INREVIEW);
                break;
            case TEMPORARILYCLOSEDTOACCRUAL:
                tgt.setValue(org.hl7.fhir.r5.model.ResearchStudy.ResearchStudyStatus.TEMPORARILYCLOSEDTOACCRUAL);
                break;
            case TEMPORARILYCLOSEDTOACCRUALANDINTERVENTION:
                tgt.setValue(org.hl7.fhir.r5.model.ResearchStudy.ResearchStudyStatus.TEMPORARILYCLOSEDTOACCRUALANDINTERVENTION);
                break;
            case WITHDRAWN:
                tgt.setValue(org.hl7.fhir.r5.model.ResearchStudy.ResearchStudyStatus.WITHDRAWN);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.ResearchStudy.ResearchStudyStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ResearchStudy.ResearchStudyStatus> convertResearchStudyStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ResearchStudy.ResearchStudyStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ResearchStudy.ResearchStudyStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ResearchStudy.ResearchStudyStatusEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case ACTIVE:
                tgt.setValue(org.hl7.fhir.r4.model.ResearchStudy.ResearchStudyStatus.ACTIVE);
                break;
            case ADMINISTRATIVELYCOMPLETED:
                tgt.setValue(org.hl7.fhir.r4.model.ResearchStudy.ResearchStudyStatus.ADMINISTRATIVELYCOMPLETED);
                break;
            case APPROVED:
                tgt.setValue(org.hl7.fhir.r4.model.ResearchStudy.ResearchStudyStatus.APPROVED);
                break;
            case CLOSEDTOACCRUAL:
                tgt.setValue(org.hl7.fhir.r4.model.ResearchStudy.ResearchStudyStatus.CLOSEDTOACCRUAL);
                break;
            case CLOSEDTOACCRUALANDINTERVENTION:
                tgt.setValue(org.hl7.fhir.r4.model.ResearchStudy.ResearchStudyStatus.CLOSEDTOACCRUALANDINTERVENTION);
                break;
            case COMPLETED:
                tgt.setValue(org.hl7.fhir.r4.model.ResearchStudy.ResearchStudyStatus.COMPLETED);
                break;
            case DISAPPROVED:
                tgt.setValue(org.hl7.fhir.r4.model.ResearchStudy.ResearchStudyStatus.DISAPPROVED);
                break;
            case INREVIEW:
                tgt.setValue(org.hl7.fhir.r4.model.ResearchStudy.ResearchStudyStatus.INREVIEW);
                break;
            case TEMPORARILYCLOSEDTOACCRUAL:
                tgt.setValue(org.hl7.fhir.r4.model.ResearchStudy.ResearchStudyStatus.TEMPORARILYCLOSEDTOACCRUAL);
                break;
            case TEMPORARILYCLOSEDTOACCRUALANDINTERVENTION:
                tgt.setValue(org.hl7.fhir.r4.model.ResearchStudy.ResearchStudyStatus.TEMPORARILYCLOSEDTOACCRUALANDINTERVENTION);
                break;
            case WITHDRAWN:
                tgt.setValue(org.hl7.fhir.r4.model.ResearchStudy.ResearchStudyStatus.WITHDRAWN);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.ResearchStudy.ResearchStudyStatus.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ResearchStudy.ResearchStudyArmComponent convertResearchStudyArmComponent(org.hl7.fhir.r4.model.ResearchStudy.ResearchStudyArmComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ResearchStudy.ResearchStudyArmComponent tgt = new org.hl7.fhir.r5.model.ResearchStudy.ResearchStudyArmComponent();
        copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(convertString(src.getNameElement()));
        if (src.hasType())
            tgt.setType(convertCodeableConcept(src.getType()));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ResearchStudy.ResearchStudyArmComponent convertResearchStudyArmComponent(org.hl7.fhir.r5.model.ResearchStudy.ResearchStudyArmComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ResearchStudy.ResearchStudyArmComponent tgt = new org.hl7.fhir.r4.model.ResearchStudy.ResearchStudyArmComponent();
        copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(convertString(src.getNameElement()));
        if (src.hasType())
            tgt.setType(convertCodeableConcept(src.getType()));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ResearchStudy.ResearchStudyObjectiveComponent convertResearchStudyObjectiveComponent(org.hl7.fhir.r4.model.ResearchStudy.ResearchStudyObjectiveComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ResearchStudy.ResearchStudyObjectiveComponent tgt = new org.hl7.fhir.r5.model.ResearchStudy.ResearchStudyObjectiveComponent();
        copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(convertString(src.getNameElement()));
        if (src.hasType())
            tgt.setType(convertCodeableConcept(src.getType()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ResearchStudy.ResearchStudyObjectiveComponent convertResearchStudyObjectiveComponent(org.hl7.fhir.r5.model.ResearchStudy.ResearchStudyObjectiveComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ResearchStudy.ResearchStudyObjectiveComponent tgt = new org.hl7.fhir.r4.model.ResearchStudy.ResearchStudyObjectiveComponent();
        copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(convertString(src.getNameElement()));
        if (src.hasType())
            tgt.setType(convertCodeableConcept(src.getType()));
        return tgt;
    }
}