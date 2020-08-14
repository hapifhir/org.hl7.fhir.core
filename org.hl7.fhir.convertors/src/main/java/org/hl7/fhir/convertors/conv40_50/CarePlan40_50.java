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
public class CarePlan40_50 extends VersionConvertor_40_50 {

    public static org.hl7.fhir.r5.model.CarePlan convertCarePlan(org.hl7.fhir.r4.model.CarePlan src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.CarePlan tgt = new org.hl7.fhir.r5.model.CarePlan();
        copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        for (org.hl7.fhir.r4.model.CanonicalType t : src.getInstantiatesCanonical()) tgt.getInstantiatesCanonical().add(convertCanonical(t));
        for (org.hl7.fhir.r4.model.UriType t : src.getInstantiatesUri()) tgt.getInstantiatesUri().add(convertUri(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getBasedOn()) tgt.addBasedOn(convertReference(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getReplaces()) tgt.addReplaces(convertReference(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getPartOf()) tgt.addPartOf(convertReference(t));
        if (src.hasStatus())
            tgt.setStatusElement(convertCarePlanStatus(src.getStatusElement()));
        if (src.hasIntent())
            tgt.setIntentElement(convertCarePlanIntent(src.getIntentElement()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCategory()) tgt.addCategory(convertCodeableConcept(t));
        if (src.hasTitle())
            tgt.setTitleElement(convertString(src.getTitleElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        if (src.hasSubject())
            tgt.setSubject(convertReference(src.getSubject()));
        if (src.hasEncounter())
            tgt.setEncounter(convertReference(src.getEncounter()));
        if (src.hasPeriod())
            tgt.setPeriod(convertPeriod(src.getPeriod()));
        if (src.hasCreated())
            tgt.setCreatedElement(convertDateTime(src.getCreatedElement()));
        if (src.hasAuthor())
            tgt.setAuthor(convertReference(src.getAuthor()));
        for (org.hl7.fhir.r4.model.Reference t : src.getContributor()) tgt.addContributor(convertReference(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getCareTeam()) tgt.addCareTeam(convertReference(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getAddresses()) tgt.addAddresses(convertReferenceToCodeableReference(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getSupportingInfo()) tgt.addSupportingInfo(convertReference(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getGoal()) tgt.addGoal(convertReference(t));
        for (org.hl7.fhir.r4.model.CarePlan.CarePlanActivityComponent t : src.getActivity()) tgt.addActivity(convertCarePlanActivityComponent(t));
        for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.addNote(convertAnnotation(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.CarePlan convertCarePlan(org.hl7.fhir.r5.model.CarePlan src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.CarePlan tgt = new org.hl7.fhir.r4.model.CarePlan();
        copyDomainResource(src, tgt);
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        for (org.hl7.fhir.r5.model.CanonicalType t : src.getInstantiatesCanonical()) tgt.getInstantiatesCanonical().add(convertCanonical(t));
        for (org.hl7.fhir.r5.model.UriType t : src.getInstantiatesUri()) tgt.getInstantiatesUri().add(convertUri(t));
        for (org.hl7.fhir.r5.model.Reference t : src.getBasedOn()) tgt.addBasedOn(convertReference(t));
        for (org.hl7.fhir.r5.model.Reference t : src.getReplaces()) tgt.addReplaces(convertReference(t));
        for (org.hl7.fhir.r5.model.Reference t : src.getPartOf()) tgt.addPartOf(convertReference(t));
        if (src.hasStatus())
            tgt.setStatusElement(convertCarePlanStatus(src.getStatusElement()));
        if (src.hasIntent())
            tgt.setIntentElement(convertCarePlanIntent(src.getIntentElement()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCategory()) tgt.addCategory(convertCodeableConcept(t));
        if (src.hasTitle())
            tgt.setTitleElement(convertString(src.getTitleElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        if (src.hasSubject())
            tgt.setSubject(convertReference(src.getSubject()));
        if (src.hasEncounter())
            tgt.setEncounter(convertReference(src.getEncounter()));
        if (src.hasPeriod())
            tgt.setPeriod(convertPeriod(src.getPeriod()));
        if (src.hasCreated())
            tgt.setCreatedElement(convertDateTime(src.getCreatedElement()));
        if (src.hasAuthor())
            tgt.setAuthor(convertReference(src.getAuthor()));
        for (org.hl7.fhir.r5.model.Reference t : src.getContributor()) tgt.addContributor(convertReference(t));
        for (org.hl7.fhir.r5.model.Reference t : src.getCareTeam()) tgt.addCareTeam(convertReference(t));
        for (CodeableReference t : src.getAddresses()) if (t.hasReference())
            tgt.addAddresses(convertReference(t.getReference()));
        for (org.hl7.fhir.r5.model.Reference t : src.getSupportingInfo()) tgt.addSupportingInfo(convertReference(t));
        for (org.hl7.fhir.r5.model.Reference t : src.getGoal()) tgt.addGoal(convertReference(t));
        for (org.hl7.fhir.r5.model.CarePlan.CarePlanActivityComponent t : src.getActivity()) tgt.addActivity(convertCarePlanActivityComponent(t));
        for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.addNote(convertAnnotation(t));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestStatus> convertCarePlanStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CarePlan.CarePlanStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.RequestStatusEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case DRAFT:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestStatus.DRAFT);
                break;
            case ACTIVE:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestStatus.ACTIVE);
                break;
            case ONHOLD:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestStatus.ONHOLD);
                break;
            case REVOKED:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestStatus.REVOKED);
                break;
            case COMPLETED:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestStatus.COMPLETED);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestStatus.ENTEREDINERROR);
                break;
            case UNKNOWN:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestStatus.UNKNOWN);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CarePlan.CarePlanStatus> convertCarePlanStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CarePlan.CarePlanStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.CarePlan.CarePlanStatusEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case DRAFT:
                tgt.setValue(org.hl7.fhir.r4.model.CarePlan.CarePlanStatus.DRAFT);
                break;
            case ACTIVE:
                tgt.setValue(org.hl7.fhir.r4.model.CarePlan.CarePlanStatus.ACTIVE);
                break;
            case ONHOLD:
                tgt.setValue(org.hl7.fhir.r4.model.CarePlan.CarePlanStatus.ONHOLD);
                break;
            case REVOKED:
                tgt.setValue(org.hl7.fhir.r4.model.CarePlan.CarePlanStatus.REVOKED);
                break;
            case COMPLETED:
                tgt.setValue(org.hl7.fhir.r4.model.CarePlan.CarePlanStatus.COMPLETED);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.r4.model.CarePlan.CarePlanStatus.ENTEREDINERROR);
                break;
            case UNKNOWN:
                tgt.setValue(org.hl7.fhir.r4.model.CarePlan.CarePlanStatus.UNKNOWN);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.CarePlan.CarePlanStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CarePlan.CarePlanIntent> convertCarePlanIntent(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CarePlan.CarePlanIntent> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CarePlan.CarePlanIntent> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.CarePlan.CarePlanIntentEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case PROPOSAL:
                tgt.setValue(org.hl7.fhir.r5.model.CarePlan.CarePlanIntent.PROPOSAL);
                break;
            case PLAN:
                tgt.setValue(org.hl7.fhir.r5.model.CarePlan.CarePlanIntent.PLAN);
                break;
            case ORDER:
                tgt.setValue(org.hl7.fhir.r5.model.CarePlan.CarePlanIntent.ORDER);
                break;
            case OPTION:
                tgt.setValue(org.hl7.fhir.r5.model.CarePlan.CarePlanIntent.OPTION);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.CarePlan.CarePlanIntent.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CarePlan.CarePlanIntent> convertCarePlanIntent(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CarePlan.CarePlanIntent> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CarePlan.CarePlanIntent> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.CarePlan.CarePlanIntentEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case PROPOSAL:
                tgt.setValue(org.hl7.fhir.r4.model.CarePlan.CarePlanIntent.PROPOSAL);
                break;
            case PLAN:
                tgt.setValue(org.hl7.fhir.r4.model.CarePlan.CarePlanIntent.PLAN);
                break;
            case ORDER:
                tgt.setValue(org.hl7.fhir.r4.model.CarePlan.CarePlanIntent.ORDER);
                break;
            case OPTION:
                tgt.setValue(org.hl7.fhir.r4.model.CarePlan.CarePlanIntent.OPTION);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.CarePlan.CarePlanIntent.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.CarePlan.CarePlanActivityComponent convertCarePlanActivityComponent(org.hl7.fhir.r4.model.CarePlan.CarePlanActivityComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.CarePlan.CarePlanActivityComponent tgt = new org.hl7.fhir.r5.model.CarePlan.CarePlanActivityComponent();
        copyElement(src, tgt);
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getOutcomeCodeableConcept()) tgt.addOutcome(convertCodeableConceptToCodeableReference(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getOutcomeReference()) tgt.addOutcome(convertReferenceToCodeableReference(t));
        for (org.hl7.fhir.r4.model.Annotation t : src.getProgress()) tgt.addProgress(convertAnnotation(t));
        if (src.hasReference())
            tgt.setReference(convertReference(src.getReference()));
        if (src.hasDetail())
            tgt.setDetail(convertCarePlanActivityDetailComponent(src.getDetail()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.CarePlan.CarePlanActivityComponent convertCarePlanActivityComponent(org.hl7.fhir.r5.model.CarePlan.CarePlanActivityComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.CarePlan.CarePlanActivityComponent tgt = new org.hl7.fhir.r4.model.CarePlan.CarePlanActivityComponent();
        copyElement(src, tgt);
        for (CodeableReference t : src.getOutcome()) if (t.hasConcept())
            tgt.addOutcomeCodeableConcept(convertCodeableConcept(t.getConcept()));
        for (CodeableReference t : src.getOutcome()) if (t.hasReference())
            tgt.addOutcomeReference(convertReference(t.getReference()));
        for (org.hl7.fhir.r5.model.Annotation t : src.getProgress()) tgt.addProgress(convertAnnotation(t));
        if (src.hasReference())
            tgt.setReference(convertReference(src.getReference()));
        if (src.hasDetail())
            tgt.setDetail(convertCarePlanActivityDetailComponent(src.getDetail()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.CarePlan.CarePlanActivityDetailComponent convertCarePlanActivityDetailComponent(org.hl7.fhir.r4.model.CarePlan.CarePlanActivityDetailComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.CarePlan.CarePlanActivityDetailComponent tgt = new org.hl7.fhir.r5.model.CarePlan.CarePlanActivityDetailComponent();
        copyElement(src, tgt);
        if (src.hasKind())
            tgt.setKindElement(convertCarePlanActivityKind(src.getKindElement()));
        for (org.hl7.fhir.r4.model.CanonicalType t : src.getInstantiatesCanonical()) tgt.getInstantiatesCanonical().add(convertCanonical(t));
        for (org.hl7.fhir.r4.model.UriType t : src.getInstantiatesUri()) tgt.getInstantiatesUri().add(convertUri(t));
        if (src.hasCode())
            tgt.setCode(convertCodeableConcept(src.getCode()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReasonCode()) tgt.addReason(convertCodeableConceptToCodeableReference(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getReasonReference()) tgt.addReason(convertReferenceToCodeableReference(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getGoal()) tgt.addGoal(convertReference(t));
        if (src.hasStatus())
            tgt.setStatusElement(convertCarePlanActivityStatus(src.getStatusElement()));
        if (src.hasStatusReason())
            tgt.setStatusReason(convertCodeableConcept(src.getStatusReason()));
        if (src.hasDoNotPerform())
            tgt.setDoNotPerformElement(convertBoolean(src.getDoNotPerformElement()));
        if (src.hasScheduled())
            tgt.setScheduled(convertType(src.getScheduled()));
        if (src.hasLocation())
            tgt.getLocation().setReference(convertReference(src.getLocation()));
        for (org.hl7.fhir.r4.model.Reference t : src.getPerformer()) tgt.addPerformer(convertReference(t));
        if (src.hasProduct())
            tgt.setProduct(convertType(src.getProduct()));
        if (src.hasDailyAmount())
            tgt.setDailyAmount(convertSimpleQuantity(src.getDailyAmount()));
        if (src.hasQuantity())
            tgt.setQuantity(convertSimpleQuantity(src.getQuantity()));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.CarePlan.CarePlanActivityDetailComponent convertCarePlanActivityDetailComponent(org.hl7.fhir.r5.model.CarePlan.CarePlanActivityDetailComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.CarePlan.CarePlanActivityDetailComponent tgt = new org.hl7.fhir.r4.model.CarePlan.CarePlanActivityDetailComponent();
        copyElement(src, tgt);
        if (src.hasKind())
            tgt.setKindElement(convertCarePlanActivityKind(src.getKindElement()));
        for (org.hl7.fhir.r5.model.CanonicalType t : src.getInstantiatesCanonical()) tgt.getInstantiatesCanonical().add(convertCanonical(t));
        for (org.hl7.fhir.r5.model.UriType t : src.getInstantiatesUri()) tgt.getInstantiatesUri().add(convertUri(t));
        if (src.hasCode())
            tgt.setCode(convertCodeableConcept(src.getCode()));
        for (CodeableReference t : src.getReason()) if (t.hasConcept())
            tgt.addReasonCode(convertCodeableConcept(t.getConcept()));
        for (CodeableReference t : src.getReason()) if (t.hasReference())
            tgt.addReasonReference(convertReference(t.getReference()));
        for (org.hl7.fhir.r5.model.Reference t : src.getGoal()) tgt.addGoal(convertReference(t));
        if (src.hasStatus())
            tgt.setStatusElement(convertCarePlanActivityStatus(src.getStatusElement()));
        if (src.hasStatusReason())
            tgt.setStatusReason(convertCodeableConcept(src.getStatusReason()));
        if (src.hasDoNotPerform())
            tgt.setDoNotPerformElement(convertBoolean(src.getDoNotPerformElement()));
        if (src.hasScheduled())
            tgt.setScheduled(convertType(src.getScheduled()));
        if (src.getLocation().hasReference())
            tgt.setLocation(convertReference(src.getLocation().getReference()));
        for (org.hl7.fhir.r5.model.Reference t : src.getPerformer()) tgt.addPerformer(convertReference(t));
        if (src.hasProduct())
            tgt.setProduct(convertType(src.getProduct()));
        if (src.hasDailyAmount())
            tgt.setDailyAmount(convertSimpleQuantity(src.getDailyAmount()));
        if (src.hasQuantity())
            tgt.setQuantity(convertSimpleQuantity(src.getQuantity()));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CarePlan.CarePlanActivityKind> convertCarePlanActivityKind(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CarePlan.CarePlanActivityKind> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CarePlan.CarePlanActivityKind> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.CarePlan.CarePlanActivityKindEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case APPOINTMENT:
                tgt.setValue(org.hl7.fhir.r5.model.CarePlan.CarePlanActivityKind.APPOINTMENT);
                break;
            case COMMUNICATIONREQUEST:
                tgt.setValue(org.hl7.fhir.r5.model.CarePlan.CarePlanActivityKind.COMMUNICATIONREQUEST);
                break;
            case DEVICEREQUEST:
                tgt.setValue(org.hl7.fhir.r5.model.CarePlan.CarePlanActivityKind.DEVICEREQUEST);
                break;
            case MEDICATIONREQUEST:
                tgt.setValue(org.hl7.fhir.r5.model.CarePlan.CarePlanActivityKind.MEDICATIONREQUEST);
                break;
            case NUTRITIONORDER:
                tgt.setValue(org.hl7.fhir.r5.model.CarePlan.CarePlanActivityKind.NUTRITIONORDER);
                break;
            case TASK:
                tgt.setValue(org.hl7.fhir.r5.model.CarePlan.CarePlanActivityKind.TASK);
                break;
            case SERVICEREQUEST:
                tgt.setValue(org.hl7.fhir.r5.model.CarePlan.CarePlanActivityKind.SERVICEREQUEST);
                break;
            case VISIONPRESCRIPTION:
                tgt.setValue(org.hl7.fhir.r5.model.CarePlan.CarePlanActivityKind.VISIONPRESCRIPTION);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.CarePlan.CarePlanActivityKind.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CarePlan.CarePlanActivityKind> convertCarePlanActivityKind(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CarePlan.CarePlanActivityKind> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CarePlan.CarePlanActivityKind> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.CarePlan.CarePlanActivityKindEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case APPOINTMENT:
                tgt.setValue(org.hl7.fhir.r4.model.CarePlan.CarePlanActivityKind.APPOINTMENT);
                break;
            case COMMUNICATIONREQUEST:
                tgt.setValue(org.hl7.fhir.r4.model.CarePlan.CarePlanActivityKind.COMMUNICATIONREQUEST);
                break;
            case DEVICEREQUEST:
                tgt.setValue(org.hl7.fhir.r4.model.CarePlan.CarePlanActivityKind.DEVICEREQUEST);
                break;
            case MEDICATIONREQUEST:
                tgt.setValue(org.hl7.fhir.r4.model.CarePlan.CarePlanActivityKind.MEDICATIONREQUEST);
                break;
            case NUTRITIONORDER:
                tgt.setValue(org.hl7.fhir.r4.model.CarePlan.CarePlanActivityKind.NUTRITIONORDER);
                break;
            case TASK:
                tgt.setValue(org.hl7.fhir.r4.model.CarePlan.CarePlanActivityKind.TASK);
                break;
            case SERVICEREQUEST:
                tgt.setValue(org.hl7.fhir.r4.model.CarePlan.CarePlanActivityKind.SERVICEREQUEST);
                break;
            case VISIONPRESCRIPTION:
                tgt.setValue(org.hl7.fhir.r4.model.CarePlan.CarePlanActivityKind.VISIONPRESCRIPTION);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.CarePlan.CarePlanActivityKind.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CarePlan.CarePlanActivityStatus> convertCarePlanActivityStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CarePlan.CarePlanActivityStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CarePlan.CarePlanActivityStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.CarePlan.CarePlanActivityStatusEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case NOTSTARTED:
                tgt.setValue(org.hl7.fhir.r5.model.CarePlan.CarePlanActivityStatus.NOTSTARTED);
                break;
            case SCHEDULED:
                tgt.setValue(org.hl7.fhir.r5.model.CarePlan.CarePlanActivityStatus.SCHEDULED);
                break;
            case INPROGRESS:
                tgt.setValue(org.hl7.fhir.r5.model.CarePlan.CarePlanActivityStatus.INPROGRESS);
                break;
            case ONHOLD:
                tgt.setValue(org.hl7.fhir.r5.model.CarePlan.CarePlanActivityStatus.ONHOLD);
                break;
            case COMPLETED:
                tgt.setValue(org.hl7.fhir.r5.model.CarePlan.CarePlanActivityStatus.COMPLETED);
                break;
            case CANCELLED:
                tgt.setValue(org.hl7.fhir.r5.model.CarePlan.CarePlanActivityStatus.CANCELLED);
                break;
            case STOPPED:
                tgt.setValue(org.hl7.fhir.r5.model.CarePlan.CarePlanActivityStatus.STOPPED);
                break;
            case UNKNOWN:
                tgt.setValue(org.hl7.fhir.r5.model.CarePlan.CarePlanActivityStatus.UNKNOWN);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.r5.model.CarePlan.CarePlanActivityStatus.ENTEREDINERROR);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.CarePlan.CarePlanActivityStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CarePlan.CarePlanActivityStatus> convertCarePlanActivityStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CarePlan.CarePlanActivityStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CarePlan.CarePlanActivityStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.CarePlan.CarePlanActivityStatusEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case NOTSTARTED:
                tgt.setValue(org.hl7.fhir.r4.model.CarePlan.CarePlanActivityStatus.NOTSTARTED);
                break;
            case SCHEDULED:
                tgt.setValue(org.hl7.fhir.r4.model.CarePlan.CarePlanActivityStatus.SCHEDULED);
                break;
            case INPROGRESS:
                tgt.setValue(org.hl7.fhir.r4.model.CarePlan.CarePlanActivityStatus.INPROGRESS);
                break;
            case ONHOLD:
                tgt.setValue(org.hl7.fhir.r4.model.CarePlan.CarePlanActivityStatus.ONHOLD);
                break;
            case COMPLETED:
                tgt.setValue(org.hl7.fhir.r4.model.CarePlan.CarePlanActivityStatus.COMPLETED);
                break;
            case CANCELLED:
                tgt.setValue(org.hl7.fhir.r4.model.CarePlan.CarePlanActivityStatus.CANCELLED);
                break;
            case STOPPED:
                tgt.setValue(org.hl7.fhir.r4.model.CarePlan.CarePlanActivityStatus.STOPPED);
                break;
            case UNKNOWN:
                tgt.setValue(org.hl7.fhir.r4.model.CarePlan.CarePlanActivityStatus.UNKNOWN);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.r4.model.CarePlan.CarePlanActivityStatus.ENTEREDINERROR);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.CarePlan.CarePlanActivityStatus.NULL);
                break;
        }
        return tgt;
    }
}