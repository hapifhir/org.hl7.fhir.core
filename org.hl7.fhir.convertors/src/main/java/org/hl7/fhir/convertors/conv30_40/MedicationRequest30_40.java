package org.hl7.fhir.convertors.conv30_40;

import org.hl7.fhir.convertors.VersionConvertor_30_40;
import org.hl7.fhir.exceptions.FHIRException;

public class MedicationRequest30_40 {

    public static org.hl7.fhir.r4.model.MedicationRequest convertMedicationRequest(org.hl7.fhir.dstu3.model.MedicationRequest src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.MedicationRequest tgt = new org.hl7.fhir.r4.model.MedicationRequest();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getBasedOn()) tgt.addBasedOn(VersionConvertor_30_40.convertReference(t));
        if (src.hasGroupIdentifier())
            tgt.setGroupIdentifier(VersionConvertor_30_40.convertIdentifier(src.getGroupIdentifier()));
        if (src.hasStatus())
            tgt.setStatusElement(convertMedicationRequestStatus(src.getStatusElement()));
        if (src.hasIntent())
            tgt.setIntentElement(convertMedicationRequestIntent(src.getIntentElement()));
        if (src.hasPriority())
            tgt.setPriorityElement(convertMedicationRequestPriority(src.getPriorityElement()));
        if (src.hasMedication())
            tgt.setMedication(VersionConvertor_30_40.convertType(src.getMedication()));
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_30_40.convertReference(src.getSubject()));
        if (src.hasContext())
            tgt.setEncounter(VersionConvertor_30_40.convertReference(src.getContext()));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getSupportingInformation()) tgt.addSupportingInformation(VersionConvertor_30_40.convertReference(t));
        if (src.hasAuthoredOn())
            tgt.setAuthoredOnElement(VersionConvertor_30_40.convertDateTime(src.getAuthoredOnElement()));
        if (src.hasRecorder())
            tgt.setRecorder(VersionConvertor_30_40.convertReference(src.getRecorder()));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getReasonCode()) tgt.addReasonCode(VersionConvertor_30_40.convertCodeableConcept(t));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getReasonReference()) tgt.addReasonReference(VersionConvertor_30_40.convertReference(t));
        for (org.hl7.fhir.dstu3.model.Annotation t : src.getNote()) tgt.addNote(VersionConvertor_30_40.convertAnnotation(t));
        for (org.hl7.fhir.dstu3.model.Dosage t : src.getDosageInstruction()) tgt.addDosageInstruction(VersionConvertor_30_40.convertDosage(t));
        if (src.hasDispenseRequest())
            tgt.setDispenseRequest(convertMedicationRequestDispenseRequestComponent(src.getDispenseRequest()));
        if (src.hasSubstitution())
            tgt.setSubstitution(convertMedicationRequestSubstitutionComponent(src.getSubstitution()));
        if (src.hasPriorPrescription())
            tgt.setPriorPrescription(VersionConvertor_30_40.convertReference(src.getPriorPrescription()));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getDetectedIssue()) tgt.addDetectedIssue(VersionConvertor_30_40.convertReference(t));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getEventHistory()) tgt.addEventHistory(VersionConvertor_30_40.convertReference(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.MedicationRequest convertMedicationRequest(org.hl7.fhir.r4.model.MedicationRequest src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.MedicationRequest tgt = new org.hl7.fhir.dstu3.model.MedicationRequest();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getBasedOn()) tgt.addBasedOn(VersionConvertor_30_40.convertReference(t));
        if (src.hasGroupIdentifier())
            tgt.setGroupIdentifier(VersionConvertor_30_40.convertIdentifier(src.getGroupIdentifier()));
        if (src.hasStatus())
            tgt.setStatusElement(convertMedicationRequestStatus(src.getStatusElement()));
        if (src.hasIntent())
            tgt.setIntentElement(convertMedicationRequestIntent(src.getIntentElement()));
        if (src.hasPriority())
            tgt.setPriorityElement(convertMedicationRequestPriority(src.getPriorityElement()));
        if (src.hasMedication())
            tgt.setMedication(VersionConvertor_30_40.convertType(src.getMedication()));
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_30_40.convertReference(src.getSubject()));
        if (src.hasEncounter())
            tgt.setContext(VersionConvertor_30_40.convertReference(src.getEncounter()));
        for (org.hl7.fhir.r4.model.Reference t : src.getSupportingInformation()) tgt.addSupportingInformation(VersionConvertor_30_40.convertReference(t));
        if (src.hasAuthoredOn())
            tgt.setAuthoredOnElement(VersionConvertor_30_40.convertDateTime(src.getAuthoredOnElement()));
        if (src.hasRecorder())
            tgt.setRecorder(VersionConvertor_30_40.convertReference(src.getRecorder()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReasonCode()) tgt.addReasonCode(VersionConvertor_30_40.convertCodeableConcept(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getReasonReference()) tgt.addReasonReference(VersionConvertor_30_40.convertReference(t));
        for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.addNote(VersionConvertor_30_40.convertAnnotation(t));
        for (org.hl7.fhir.r4.model.Dosage t : src.getDosageInstruction()) tgt.addDosageInstruction(VersionConvertor_30_40.convertDosage(t));
        if (src.hasDispenseRequest())
            tgt.setDispenseRequest(convertMedicationRequestDispenseRequestComponent(src.getDispenseRequest()));
        if (src.hasSubstitution())
            tgt.setSubstitution(convertMedicationRequestSubstitutionComponent(src.getSubstitution()));
        if (src.hasPriorPrescription())
            tgt.setPriorPrescription(VersionConvertor_30_40.convertReference(src.getPriorPrescription()));
        for (org.hl7.fhir.r4.model.Reference t : src.getDetectedIssue()) tgt.addDetectedIssue(VersionConvertor_30_40.convertReference(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getEventHistory()) tgt.addEventHistory(VersionConvertor_30_40.convertReference(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestDispenseRequestComponent convertMedicationRequestDispenseRequestComponent(org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestDispenseRequestComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestDispenseRequestComponent tgt = new org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestDispenseRequestComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasValidityPeriod())
            tgt.setValidityPeriod(VersionConvertor_30_40.convertPeriod(src.getValidityPeriod()));
        if (src.hasNumberOfRepeatsAllowed())
            tgt.setNumberOfRepeatsAllowed(src.getNumberOfRepeatsAllowed());
        if (src.hasQuantity())
            tgt.setQuantity(VersionConvertor_30_40.convertSimpleQuantity(src.getQuantity()));
        if (src.hasExpectedSupplyDuration())
            tgt.setExpectedSupplyDuration(VersionConvertor_30_40.convertDuration(src.getExpectedSupplyDuration()));
        if (src.hasPerformer())
            tgt.setPerformer(VersionConvertor_30_40.convertReference(src.getPerformer()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestDispenseRequestComponent convertMedicationRequestDispenseRequestComponent(org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestDispenseRequestComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestDispenseRequestComponent tgt = new org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestDispenseRequestComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasValidityPeriod())
            tgt.setValidityPeriod(VersionConvertor_30_40.convertPeriod(src.getValidityPeriod()));
        if (src.hasNumberOfRepeatsAllowed())
            tgt.setNumberOfRepeatsAllowed(src.getNumberOfRepeatsAllowed());
        if (src.hasQuantity())
            tgt.setQuantity(VersionConvertor_30_40.convertSimpleQuantity(src.getQuantity()));
        if (src.hasExpectedSupplyDuration())
            tgt.setExpectedSupplyDuration(VersionConvertor_30_40.convertDuration(src.getExpectedSupplyDuration()));
        if (src.hasPerformer())
            tgt.setPerformer(VersionConvertor_30_40.convertReference(src.getPerformer()));
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestIntent> convertMedicationRequestIntent(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestIntent> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestIntent> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestIntentEnumFactory());
        VersionConvertor_30_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case PROPOSAL:
                tgt.setValue(org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestIntent.PROPOSAL);
                break;
            case PLAN:
                tgt.setValue(org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestIntent.PLAN);
                break;
            case ORDER:
                tgt.setValue(org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestIntent.ORDER);
                break;
            case INSTANCEORDER:
                tgt.setValue(org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestIntent.INSTANCEORDER);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestIntent.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestIntent> convertMedicationRequestIntent(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestIntent> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestIntent> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestIntentEnumFactory());
        VersionConvertor_30_40.copyElement(src, tgt);
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
            case INSTANCEORDER:
                tgt.setValue(org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestIntent.INSTANCEORDER);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestIntent.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestPriority> convertMedicationRequestPriority(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestPriority> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestPriority> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestPriorityEnumFactory());
        VersionConvertor_30_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case ROUTINE:
                tgt.setValue(org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestPriority.ROUTINE);
                break;
            case URGENT:
                tgt.setValue(org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestPriority.URGENT);
                break;
            case STAT:
                tgt.setValue(org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestPriority.STAT);
                break;
            case ASAP:
                tgt.setValue(org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestPriority.ASAP);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestPriority.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestPriority> convertMedicationRequestPriority(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestPriority> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestPriority> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestPriorityEnumFactory());
        VersionConvertor_30_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case ROUTINE:
                tgt.setValue(org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestPriority.ROUTINE);
                break;
            case URGENT:
                tgt.setValue(org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestPriority.URGENT);
                break;
            case STAT:
                tgt.setValue(org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestPriority.STAT);
                break;
            case ASAP:
                tgt.setValue(org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestPriority.ASAP);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestPriority.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestStatus> convertMedicationRequestStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestStatusEnumFactory());
        VersionConvertor_30_40.copyElement(src, tgt);
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

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestStatus> convertMedicationRequestStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestStatusEnumFactory());
        VersionConvertor_30_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case ACTIVE:
                tgt.setValue(org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestStatus.ACTIVE);
                break;
            case ONHOLD:
                tgt.setValue(org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestStatus.ONHOLD);
                break;
            case CANCELLED:
                tgt.setValue(org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestStatus.CANCELLED);
                break;
            case COMPLETED:
                tgt.setValue(org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestStatus.COMPLETED);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestStatus.ENTEREDINERROR);
                break;
            case STOPPED:
                tgt.setValue(org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestStatus.STOPPED);
                break;
            case DRAFT:
                tgt.setValue(org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestStatus.DRAFT);
                break;
            case UNKNOWN:
                tgt.setValue(org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestStatus.UNKNOWN);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestStatus.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestSubstitutionComponent convertMedicationRequestSubstitutionComponent(org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestSubstitutionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestSubstitutionComponent tgt = new org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestSubstitutionComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasAllowedBooleanType())
            tgt.setAllowedElement(VersionConvertor_30_40.convertBoolean(src.getAllowedBooleanType()));
        if (src.hasReason())
            tgt.setReason(VersionConvertor_30_40.convertCodeableConcept(src.getReason()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestSubstitutionComponent convertMedicationRequestSubstitutionComponent(org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestSubstitutionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestSubstitutionComponent tgt = new org.hl7.fhir.r4.model.MedicationRequest.MedicationRequestSubstitutionComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasAllowed())
            tgt.setAllowed(VersionConvertor_30_40.convertBoolean(src.getAllowedElement()));
        if (src.hasReason())
            tgt.setReason(VersionConvertor_30_40.convertCodeableConcept(src.getReason()));
        return tgt;
    }
}