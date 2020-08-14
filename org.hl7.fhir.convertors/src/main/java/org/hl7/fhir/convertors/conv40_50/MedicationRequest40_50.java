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
public class MedicationRequest40_50 extends VersionConvertor_40_50 {

    public static org.hl7.fhir.r5.model.MedicationRequest convertMedicationRequest(org.hl7.fhir.r4.model.MedicationRequest src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.MedicationRequest tgt = new org.hl7.fhir.r5.model.MedicationRequest();
        copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        if (src.hasStatus())
            tgt.setStatusElement(convertMedicationRequestStatus(src.getStatusElement()));
        if (src.hasStatusReason())
            tgt.setStatusReason(convertCodeableConcept(src.getStatusReason()));
        if (src.hasIntent())
            tgt.setIntentElement(convertMedicationRequestIntent(src.getIntentElement()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCategory()) tgt.addCategory(convertCodeableConcept(t));
        if (src.hasPriority())
            tgt.setPriorityElement(convertMedicationRequestPriority(src.getPriorityElement()));
        if (src.hasDoNotPerform())
            tgt.setDoNotPerformElement(convertBoolean(src.getDoNotPerformElement()));
        if (src.hasReportedBooleanType())
            tgt.setReportedElement(convertBoolean(src.getReportedBooleanType()));
        if (src.hasReportedReference())
            tgt.setInformationSource(convertReference(src.getReportedReference()));
        if (src.hasMedicationCodeableConcept())
          tgt.getMedication().setConcept(convertCodeableConcept(src.getMedicationCodeableConcept()));
        if (src.hasMedicationReference())
          tgt.getMedication().setReference(convertReference(src.getMedicationReference()));
        if (src.hasSubject())
            tgt.setSubject(convertReference(src.getSubject()));
        if (src.hasEncounter())
            tgt.setEncounter(convertReference(src.getEncounter()));
        for (org.hl7.fhir.r4.model.Reference t : src.getSupportingInformation()) tgt.addSupportingInformation(convertReference(t));
        if (src.hasAuthoredOn())
            tgt.setAuthoredOnElement(convertDateTime(src.getAuthoredOnElement()));
        if (src.hasRequester())
            tgt.setRequester(convertReference(src.getRequester()));
        if (src.hasPerformer())
            tgt.setPerformer(convertReference(src.getPerformer()));
        if (src.hasPerformerType())
            tgt.setPerformerType(convertCodeableConcept(src.getPerformerType()));
        if (src.hasRecorder())
            tgt.setRecorder(convertReference(src.getRecorder()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReasonCode()) tgt.addReason().setConcept(convertCodeableConcept(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getReasonReference()) tgt.addReason().setReference(convertReference(t));
        for (org.hl7.fhir.r4.model.CanonicalType t : src.getInstantiatesCanonical()) tgt.getInstantiatesCanonical().add(convertCanonical(t));
        for (org.hl7.fhir.r4.model.UriType t : src.getInstantiatesUri()) tgt.getInstantiatesUri().add(convertUri(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getBasedOn()) tgt.addBasedOn(convertReference(t));
        if (src.hasGroupIdentifier())
            tgt.setGroupIdentifier(convertIdentifier(src.getGroupIdentifier()));
        if (src.hasCourseOfTherapyType())
            tgt.setCourseOfTherapyType(convertCodeableConcept(src.getCourseOfTherapyType()));
        for (org.hl7.fhir.r4.model.Reference t : src.getInsurance()) tgt.addInsurance(convertReference(t));
        for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.addNote(convertAnnotation(t));
        for (org.hl7.fhir.r4.model.Dosage t : src.getDosageInstruction()) tgt.addDosageInstruction(convertDosage(t));
        if (src.hasDispenseRequest())
            tgt.setDispenseRequest(convertMedicationRequestDispenseRequestComponent(src.getDispenseRequest()));
        if (src.hasSubstitution())
            tgt.setSubstitution(convertMedicationRequestSubstitutionComponent(src.getSubstitution()));
        if (src.hasPriorPrescription())
            tgt.setPriorPrescription(convertReference(src.getPriorPrescription()));
        for (org.hl7.fhir.r4.model.Reference t : src.getDetectedIssue()) tgt.addDetectedIssue(convertReference(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getEventHistory()) tgt.addEventHistory(convertReference(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.MedicationRequest convertMedicationRequest(org.hl7.fhir.r5.model.MedicationRequest src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.MedicationRequest tgt = new org.hl7.fhir.r4.model.MedicationRequest();
        copyDomainResource(src, tgt);
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        if (src.hasStatus())
            tgt.setStatusElement(convertMedicationRequestStatus(src.getStatusElement()));
        if (src.hasStatusReason())
            tgt.setStatusReason(convertCodeableConcept(src.getStatusReason()));
        if (src.hasIntent())
            tgt.setIntentElement(convertMedicationRequestIntent(src.getIntentElement()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCategory()) tgt.addCategory(convertCodeableConcept(t));
        if (src.hasPriority())
            tgt.setPriorityElement(convertMedicationRequestPriority(src.getPriorityElement()));
        if (src.hasDoNotPerform())
            tgt.setDoNotPerformElement(convertBoolean(src.getDoNotPerformElement()));
        if (src.hasReported())
            tgt.setReported(convertBoolean(src.getReportedElement()));
        if (src.hasInformationSource())
            tgt.setReported(convertReference(src.getInformationSource()));
        if (src.getMedication().hasReference())
          tgt.setMedication(convertType(src.getMedication().getReference()));
        if (src.getMedication().hasConcept())
          tgt.setMedication(convertType(src.getMedication().getConcept()));
        if (src.hasSubject())
            tgt.setSubject(convertReference(src.getSubject()));
        if (src.hasEncounter())
            tgt.setEncounter(convertReference(src.getEncounter()));
        for (org.hl7.fhir.r5.model.Reference t : src.getSupportingInformation()) tgt.addSupportingInformation(convertReference(t));
        if (src.hasAuthoredOn())
            tgt.setAuthoredOnElement(convertDateTime(src.getAuthoredOnElement()));
        if (src.hasRequester())
            tgt.setRequester(convertReference(src.getRequester()));
        if (src.hasPerformer())
            tgt.setPerformer(convertReference(src.getPerformer()));
        if (src.hasPerformerType())
            tgt.setPerformerType(convertCodeableConcept(src.getPerformerType()));
        if (src.hasRecorder())
            tgt.setRecorder(convertReference(src.getRecorder()));
        for (org.hl7.fhir.r5.model.CodeableReference t : src.getReason()) {
            if (t.hasConcept())
                tgt.addReasonCode(convertCodeableConcept(t.getConcept()));
            if (t.hasReference())
                tgt.addReasonReference(convertReference(t.getReference()));
        }
        for (org.hl7.fhir.r5.model.CanonicalType t : src.getInstantiatesCanonical()) tgt.getInstantiatesCanonical().add(convertCanonical(t));
        for (org.hl7.fhir.r5.model.UriType t : src.getInstantiatesUri()) tgt.getInstantiatesUri().add(convertUri(t));
        for (org.hl7.fhir.r5.model.Reference t : src.getBasedOn()) tgt.addBasedOn(convertReference(t));
        if (src.hasGroupIdentifier())
            tgt.setGroupIdentifier(convertIdentifier(src.getGroupIdentifier()));
        if (src.hasCourseOfTherapyType())
            tgt.setCourseOfTherapyType(convertCodeableConcept(src.getCourseOfTherapyType()));
        for (org.hl7.fhir.r5.model.Reference t : src.getInsurance()) tgt.addInsurance(convertReference(t));
        for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.addNote(convertAnnotation(t));
        for (org.hl7.fhir.r5.model.Dosage t : src.getDosageInstruction()) tgt.addDosageInstruction(convertDosage(t));
        if (src.hasDispenseRequest())
            tgt.setDispenseRequest(convertMedicationRequestDispenseRequestComponent(src.getDispenseRequest()));
        if (src.hasSubstitution())
            tgt.setSubstitution(convertMedicationRequestSubstitutionComponent(src.getSubstitution()));
        if (src.hasPriorPrescription())
            tgt.setPriorPrescription(convertReference(src.getPriorPrescription()));
        for (org.hl7.fhir.r5.model.Reference t : src.getDetectedIssue()) tgt.addDetectedIssue(convertReference(t));
        for (org.hl7.fhir.r5.model.Reference t : src.getEventHistory()) tgt.addEventHistory(convertReference(t));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MedicationRequest.MedicationrequestStatus> convertMedicationRequestStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MedicationRequest.MedicationrequestStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.MedicationRequest.MedicationrequestStatusEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case ACTIVE:
                tgt.setValue(org.hl7.fhir.r5.model.MedicationRequest.MedicationrequestStatus.ACTIVE);
                break;
            case ONHOLD:
                tgt.setValue(org.hl7.fhir.r5.model.MedicationRequest.MedicationrequestStatus.ONHOLD);
                break;
            case CANCELLED:
                tgt.setValue(org.hl7.fhir.r5.model.MedicationRequest.MedicationrequestStatus.CANCELLED);
                break;
            case COMPLETED:
                tgt.setValue(org.hl7.fhir.r5.model.MedicationRequest.MedicationrequestStatus.COMPLETED);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.r5.model.MedicationRequest.MedicationrequestStatus.ENTEREDINERROR);
                break;
            case STOPPED:
                tgt.setValue(org.hl7.fhir.r5.model.MedicationRequest.MedicationrequestStatus.STOPPED);
                break;
            case DRAFT:
                tgt.setValue(org.hl7.fhir.r5.model.MedicationRequest.MedicationrequestStatus.DRAFT);
                break;
            case UNKNOWN:
                tgt.setValue(org.hl7.fhir.r5.model.MedicationRequest.MedicationrequestStatus.UNKNOWN);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.MedicationRequest.MedicationrequestStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestStatus> convertMedicationRequestStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MedicationRequest.MedicationrequestStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestStatusEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case ACTIVE:
                tgt.setValue(org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestStatus.ACTIVE);
                break;
            case ONHOLD:
                tgt.setValue(org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestStatus.ONHOLD);
                break;
            case CANCELLED:
                tgt.setValue(org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestStatus.CANCELLED);
                break;
            case COMPLETED:
                tgt.setValue(org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestStatus.COMPLETED);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestStatus.ENTEREDINERROR);
                break;
            case STOPPED:
                tgt.setValue(org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestStatus.STOPPED);
                break;
            case DRAFT:
                tgt.setValue(org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestStatus.DRAFT);
                break;
            case UNKNOWN:
                tgt.setValue(org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestStatus.UNKNOWN);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestIntent> convertMedicationRequestIntent(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestIntent> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestIntent> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestIntentEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case PROPOSAL:
                tgt.setValue(org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestIntent.PROPOSAL);
                break;
            case PLAN:
                tgt.setValue(org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestIntent.PLAN);
                break;
            case ORDER:
                tgt.setValue(org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestIntent.ORDER);
                break;
            case ORIGINALORDER:
                tgt.setValue(org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestIntent.ORIGINALORDER);
                break;
            case REFLEXORDER:
                tgt.setValue(org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestIntent.REFLEXORDER);
                break;
            case FILLERORDER:
                tgt.setValue(org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestIntent.FILLERORDER);
                break;
            case INSTANCEORDER:
                tgt.setValue(org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestIntent.INSTANCEORDER);
                break;
            case OPTION:
                tgt.setValue(org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestIntent.OPTION);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestIntent.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestIntent> convertMedicationRequestIntent(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestIntent> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestIntent> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestIntentEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case PROPOSAL:
                tgt.setValue(org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestIntent.PROPOSAL);
                break;
            case PLAN:
                tgt.setValue(org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestIntent.PLAN);
                break;
            case ORDER:
                tgt.setValue(org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestIntent.ORDER);
                break;
            case ORIGINALORDER:
                tgt.setValue(org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestIntent.ORIGINALORDER);
                break;
            case REFLEXORDER:
                tgt.setValue(org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestIntent.REFLEXORDER);
                break;
            case FILLERORDER:
                tgt.setValue(org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestIntent.FILLERORDER);
                break;
            case INSTANCEORDER:
                tgt.setValue(org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestIntent.INSTANCEORDER);
                break;
            case OPTION:
                tgt.setValue(org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestIntent.OPTION);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestIntent.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestPriority> convertMedicationRequestPriority(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestPriority> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestPriority> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.RequestPriorityEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case ROUTINE:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestPriority.ROUTINE);
                break;
            case URGENT:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestPriority.URGENT);
                break;
            case ASAP:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestPriority.ASAP);
                break;
            case STAT:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestPriority.STAT);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestPriority.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestPriority> convertMedicationRequestPriority(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestPriority> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestPriority> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestPriorityEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case ROUTINE:
                tgt.setValue(org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestPriority.ROUTINE);
                break;
            case URGENT:
                tgt.setValue(org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestPriority.URGENT);
                break;
            case ASAP:
                tgt.setValue(org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestPriority.ASAP);
                break;
            case STAT:
                tgt.setValue(org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestPriority.STAT);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestPriority.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestDispenseRequestComponent convertMedicationRequestDispenseRequestComponent(org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestDispenseRequestComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestDispenseRequestComponent tgt = new org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestDispenseRequestComponent();
        copyElement(src, tgt);
        if (src.hasInitialFill())
            tgt.setInitialFill(convertMedicationRequestDispenseRequestInitialFillComponent(src.getInitialFill()));
        if (src.hasDispenseInterval())
            tgt.setDispenseInterval(convertDuration(src.getDispenseInterval()));
        if (src.hasValidityPeriod())
            tgt.setValidityPeriod(convertPeriod(src.getValidityPeriod()));
        if (src.hasNumberOfRepeatsAllowed())
            tgt.setNumberOfRepeatsAllowedElement(convertUnsignedInt(src.getNumberOfRepeatsAllowedElement()));
        if (src.hasQuantity())
            tgt.setQuantity(convertSimpleQuantity(src.getQuantity()));
        if (src.hasExpectedSupplyDuration())
            tgt.setExpectedSupplyDuration(convertDuration(src.getExpectedSupplyDuration()));
        if (src.hasPerformer())
            tgt.setDispenser(convertReference(src.getPerformer()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestDispenseRequestComponent convertMedicationRequestDispenseRequestComponent(org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestDispenseRequestComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestDispenseRequestComponent tgt = new org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestDispenseRequestComponent();
        copyElement(src, tgt);
        if (src.hasInitialFill())
            tgt.setInitialFill(convertMedicationRequestDispenseRequestInitialFillComponent(src.getInitialFill()));
        if (src.hasDispenseInterval())
            tgt.setDispenseInterval(convertDuration(src.getDispenseInterval()));
        if (src.hasValidityPeriod())
            tgt.setValidityPeriod(convertPeriod(src.getValidityPeriod()));
        if (src.hasNumberOfRepeatsAllowed())
            tgt.setNumberOfRepeatsAllowedElement(convertUnsignedInt(src.getNumberOfRepeatsAllowedElement()));
        if (src.hasQuantity())
            tgt.setQuantity(convertSimpleQuantity(src.getQuantity()));
        if (src.hasExpectedSupplyDuration())
            tgt.setExpectedSupplyDuration(convertDuration(src.getExpectedSupplyDuration()));
        if (src.hasDispenser())
            tgt.setPerformer(convertReference(src.getDispenser()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestDispenseRequestInitialFillComponent convertMedicationRequestDispenseRequestInitialFillComponent(org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestDispenseRequestInitialFillComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestDispenseRequestInitialFillComponent tgt = new org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestDispenseRequestInitialFillComponent();
        copyElement(src, tgt);
        if (src.hasQuantity())
            tgt.setQuantity(convertSimpleQuantity(src.getQuantity()));
        if (src.hasDuration())
            tgt.setDuration(convertDuration(src.getDuration()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestDispenseRequestInitialFillComponent convertMedicationRequestDispenseRequestInitialFillComponent(org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestDispenseRequestInitialFillComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestDispenseRequestInitialFillComponent tgt = new org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestDispenseRequestInitialFillComponent();
        copyElement(src, tgt);
        if (src.hasQuantity())
            tgt.setQuantity(convertSimpleQuantity(src.getQuantity()));
        if (src.hasDuration())
            tgt.setDuration(convertDuration(src.getDuration()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestSubstitutionComponent convertMedicationRequestSubstitutionComponent(org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestSubstitutionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestSubstitutionComponent tgt = new org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestSubstitutionComponent();
        copyElement(src, tgt);
        if (src.hasAllowed())
            tgt.setAllowed(convertType(src.getAllowed()));
        if (src.hasReason())
            tgt.setReason(convertCodeableConcept(src.getReason()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestSubstitutionComponent convertMedicationRequestSubstitutionComponent(org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestSubstitutionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestSubstitutionComponent tgt = new org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestSubstitutionComponent();
        copyElement(src, tgt);
        if (src.hasAllowed())
            tgt.setAllowed(convertType(src.getAllowed()));
        if (src.hasReason())
            tgt.setReason(convertCodeableConcept(src.getReason()));
        return tgt;
    }
}