package org.hl7.fhir.convertors.conv30_50;

import org.hl7.fhir.convertors.VersionConvertor_30_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CodeableReference;
import java.util.Collections;

public class MedicationRequest30_50 {

    public static org.hl7.fhir.dstu3.model.MedicationRequest convertMedicationRequest(org.hl7.fhir.r5.model.MedicationRequest src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.MedicationRequest tgt = new org.hl7.fhir.dstu3.model.MedicationRequest();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(t));
        }
        if (src.hasBasedOn()) {
            for (org.hl7.fhir.r5.model.Reference t : src.getBasedOn()) tgt.addBasedOn(VersionConvertor_30_50.convertReference(t));
        }
        if (src.hasGroupIdentifier())
            tgt.setGroupIdentifier(VersionConvertor_30_50.convertIdentifier(src.getGroupIdentifier()));
        if (src.hasStatus())
            tgt.setStatus(convertMedicationRequestStatus(src.getStatus()));
        if (src.hasIntent())
            tgt.setIntent(convertMedicationRequestIntent(src.getIntent()));
        if (src.hasPriority())
            tgt.setPriority(convertMedicationRequestPriority(src.getPriority()));
        if (src.hasMedication())
            tgt.setMedication(VersionConvertor_30_50.convertType(src.getMedication()));
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_30_50.convertReference(src.getSubject()));
        if (src.hasEncounter())
            tgt.setContext(VersionConvertor_30_50.convertReference(src.getEncounter()));
        if (src.hasSupportingInformation()) {
            for (org.hl7.fhir.r5.model.Reference t : src.getSupportingInformation()) tgt.addSupportingInformation(VersionConvertor_30_50.convertReference(t));
        }
        if (src.hasAuthoredOnElement())
            tgt.setAuthoredOnElement((org.hl7.fhir.dstu3.model.DateTimeType) VersionConvertor_30_50.convertType(src.getAuthoredOnElement()));
        if (src.hasRecorder())
            tgt.setRecorder(VersionConvertor_30_50.convertReference(src.getRecorder()));
        for (CodeableReference t : src.getReason()) {
            if (t.hasConcept()) {
                tgt.addReasonCode(VersionConvertor_30_50.convertCodeableConcept(t.getConcept()));
            }
            if (t.hasReference()) {
                tgt.addReasonReference(VersionConvertor_30_50.convertReference(t.getReference()));
            }
        }
        if (src.hasNote()) {
            for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.addNote(VersionConvertor_30_50.convertAnnotation(t));
        }
        if (src.hasDosageInstruction()) {
            for (org.hl7.fhir.r5.model.Dosage t : src.getDosageInstruction()) tgt.addDosageInstruction(VersionConvertor_30_50.convertDosage(t));
        }
        if (src.hasDispenseRequest())
            tgt.setDispenseRequest(convertMedicationRequestDispenseRequestComponent(src.getDispenseRequest()));
        if (src.hasSubstitution())
            tgt.setSubstitution(convertMedicationRequestSubstitutionComponent(src.getSubstitution()));
        if (src.hasPriorPrescription())
            tgt.setPriorPrescription(VersionConvertor_30_50.convertReference(src.getPriorPrescription()));
        if (src.hasDetectedIssue()) {
            for (org.hl7.fhir.r5.model.Reference t : src.getDetectedIssue()) tgt.addDetectedIssue(VersionConvertor_30_50.convertReference(t));
        }
        if (src.hasEventHistory()) {
            for (org.hl7.fhir.r5.model.Reference t : src.getEventHistory()) tgt.addEventHistory(VersionConvertor_30_50.convertReference(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.MedicationRequest convertMedicationRequest(org.hl7.fhir.dstu3.model.MedicationRequest src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.MedicationRequest tgt = new org.hl7.fhir.r5.model.MedicationRequest();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(t));
        }
        if (src.hasBasedOn()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getBasedOn()) tgt.addBasedOn(VersionConvertor_30_50.convertReference(t));
        }
        if (src.hasGroupIdentifier())
            tgt.setGroupIdentifier(VersionConvertor_30_50.convertIdentifier(src.getGroupIdentifier()));
        if (src.hasStatus())
            tgt.setStatus(convertMedicationRequestStatus(src.getStatus()));
        if (src.hasIntent())
            tgt.setIntent(convertMedicationRequestIntent(src.getIntent()));
        if (src.hasPriority())
            tgt.setPriority(convertMedicationRequestPriority(src.getPriority()));
        if (src.hasMedication())
            tgt.setMedication(VersionConvertor_30_50.convertType(src.getMedication()));
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_30_50.convertReference(src.getSubject()));
        if (src.hasContext())
            tgt.setEncounter(VersionConvertor_30_50.convertReference(src.getContext()));
        if (src.hasSupportingInformation()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getSupportingInformation()) tgt.addSupportingInformation(VersionConvertor_30_50.convertReference(t));
        }
        if (src.hasAuthoredOnElement())
            tgt.setAuthoredOnElement((org.hl7.fhir.r5.model.DateTimeType) VersionConvertor_30_50.convertType(src.getAuthoredOnElement()));
        if (src.hasRecorder())
            tgt.setRecorder(VersionConvertor_30_50.convertReference(src.getRecorder()));
        if (src.hasReasonCode()) {
            for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getReasonCode()) tgt.addReason(new CodeableReference().setConcept(VersionConvertor_30_50.convertCodeableConcept(t)));
        }
        if (src.hasReasonReference()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getReasonReference()) tgt.addReason(new CodeableReference().setReference(VersionConvertor_30_50.convertReference(t)));
        }
        if (src.hasNote()) {
            for (org.hl7.fhir.dstu3.model.Annotation t : src.getNote()) tgt.addNote(VersionConvertor_30_50.convertAnnotation(t));
        }
        if (src.hasDosageInstruction()) {
            for (org.hl7.fhir.dstu3.model.Dosage t : src.getDosageInstruction()) tgt.addDosageInstruction(VersionConvertor_30_50.convertDosage(t));
        }
        if (src.hasDispenseRequest())
            tgt.setDispenseRequest(convertMedicationRequestDispenseRequestComponent(src.getDispenseRequest()));
        if (src.hasSubstitution())
            tgt.setSubstitution(convertMedicationRequestSubstitutionComponent(src.getSubstitution()));
        if (src.hasPriorPrescription())
            tgt.setPriorPrescription(VersionConvertor_30_50.convertReference(src.getPriorPrescription()));
        if (src.hasDetectedIssue()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getDetectedIssue()) tgt.addDetectedIssue(VersionConvertor_30_50.convertReference(t));
        }
        if (src.hasEventHistory()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getEventHistory()) tgt.addEventHistory(VersionConvertor_30_50.convertReference(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestDispenseRequestComponent convertMedicationRequestDispenseRequestComponent(org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestDispenseRequestComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestDispenseRequestComponent tgt = new org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestDispenseRequestComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasValidityPeriod())
            tgt.setValidityPeriod(VersionConvertor_30_50.convertPeriod(src.getValidityPeriod()));
        if (src.hasNumberOfRepeatsAllowedElement())
            tgt.setNumberOfRepeatsAllowedElement((org.hl7.fhir.r5.model.UnsignedIntType) VersionConvertor_30_50.convertType(src.getNumberOfRepeatsAllowedElement()));
        if (src.hasQuantity())
            tgt.setQuantity(VersionConvertor_30_50.convertSimpleQuantity(src.getQuantity()));
        if (src.hasExpectedSupplyDuration())
            tgt.setExpectedSupplyDuration(VersionConvertor_30_50.convertDuration(src.getExpectedSupplyDuration()));
        if (src.hasPerformer())
            tgt.setDispenser(VersionConvertor_30_50.convertReference(src.getPerformer()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestDispenseRequestComponent convertMedicationRequestDispenseRequestComponent(org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestDispenseRequestComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestDispenseRequestComponent tgt = new org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestDispenseRequestComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasValidityPeriod())
            tgt.setValidityPeriod(VersionConvertor_30_50.convertPeriod(src.getValidityPeriod()));
        if (src.hasNumberOfRepeatsAllowedElement())
            tgt.setNumberOfRepeatsAllowedElement((org.hl7.fhir.dstu3.model.PositiveIntType) VersionConvertor_30_50.convertType(src.getNumberOfRepeatsAllowedElement()));
        if (src.hasQuantity())
            tgt.setQuantity(VersionConvertor_30_50.convertSimpleQuantity(src.getQuantity()));
        if (src.hasExpectedSupplyDuration())
            tgt.setExpectedSupplyDuration(VersionConvertor_30_50.convertDuration(src.getExpectedSupplyDuration()));
        if (src.hasDispenser())
            tgt.setPerformer(VersionConvertor_30_50.convertReference(src.getDispenser()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestIntent convertMedicationRequestIntent(org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestIntent src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case PROPOSAL:
                return org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestIntent.PROPOSAL;
            case PLAN:
                return org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestIntent.PLAN;
            case ORDER:
                return org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestIntent.ORDER;
            case INSTANCEORDER:
                return org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestIntent.INSTANCEORDER;
            default:
                return org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestIntent.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestIntent convertMedicationRequestIntent(org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestIntent src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case PROPOSAL:
                return org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestIntent.PROPOSAL;
            case PLAN:
                return org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestIntent.PLAN;
            case ORDER:
                return org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestIntent.ORDER;
            case INSTANCEORDER:
                return org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestIntent.INSTANCEORDER;
            default:
                return org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestIntent.NULL;
        }
    }

    static public org.hl7.fhir.r5.model.Enumerations.RequestPriority convertMedicationRequestPriority(org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestPriority src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case ROUTINE:
                return org.hl7.fhir.r5.model.Enumerations.RequestPriority.ROUTINE;
            case URGENT:
                return org.hl7.fhir.r5.model.Enumerations.RequestPriority.URGENT;
            case STAT:
                return org.hl7.fhir.r5.model.Enumerations.RequestPriority.STAT;
            case ASAP:
                return org.hl7.fhir.r5.model.Enumerations.RequestPriority.ASAP;
            default:
                return org.hl7.fhir.r5.model.Enumerations.RequestPriority.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestPriority convertMedicationRequestPriority(org.hl7.fhir.r5.model.Enumerations.RequestPriority src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case ROUTINE:
                return org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestPriority.ROUTINE;
            case URGENT:
                return org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestPriority.URGENT;
            case STAT:
                return org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestPriority.STAT;
            case ASAP:
                return org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestPriority.ASAP;
            default:
                return org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestPriority.NULL;
        }
    }

    static public org.hl7.fhir.r5.model.MedicationRequest.MedicationrequestStatus convertMedicationRequestStatus(org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case ACTIVE:
                return org.hl7.fhir.r5.model.MedicationRequest.MedicationrequestStatus.ACTIVE;
            case ONHOLD:
                return org.hl7.fhir.r5.model.MedicationRequest.MedicationrequestStatus.ONHOLD;
            case CANCELLED:
                return org.hl7.fhir.r5.model.MedicationRequest.MedicationrequestStatus.CANCELLED;
            case COMPLETED:
                return org.hl7.fhir.r5.model.MedicationRequest.MedicationrequestStatus.COMPLETED;
            case ENTEREDINERROR:
                return org.hl7.fhir.r5.model.MedicationRequest.MedicationrequestStatus.ENTEREDINERROR;
            case STOPPED:
                return org.hl7.fhir.r5.model.MedicationRequest.MedicationrequestStatus.STOPPED;
            case DRAFT:
                return org.hl7.fhir.r5.model.MedicationRequest.MedicationrequestStatus.DRAFT;
            case UNKNOWN:
                return org.hl7.fhir.r5.model.MedicationRequest.MedicationrequestStatus.UNKNOWN;
            default:
                return org.hl7.fhir.r5.model.MedicationRequest.MedicationrequestStatus.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestStatus convertMedicationRequestStatus(org.hl7.fhir.r5.model.MedicationRequest.MedicationrequestStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case ACTIVE:
                return org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestStatus.ACTIVE;
            case ONHOLD:
                return org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestStatus.ONHOLD;
            case CANCELLED:
                return org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestStatus.CANCELLED;
            case COMPLETED:
                return org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestStatus.COMPLETED;
            case ENTEREDINERROR:
                return org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestStatus.ENTEREDINERROR;
            case STOPPED:
                return org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestStatus.STOPPED;
            case DRAFT:
                return org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestStatus.DRAFT;
            case UNKNOWN:
                return org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestStatus.UNKNOWN;
            default:
                return org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestStatus.NULL;
        }
    }

    public static org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestSubstitutionComponent convertMedicationRequestSubstitutionComponent(org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestSubstitutionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestSubstitutionComponent tgt = new org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestSubstitutionComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasAllowed())
            tgt.setAllowed(VersionConvertor_30_50.convertBoolean(src.getAllowedElement()));
        if (src.hasReason())
            tgt.setReason(VersionConvertor_30_50.convertCodeableConcept(src.getReason()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestSubstitutionComponent convertMedicationRequestSubstitutionComponent(org.hl7.fhir.r5.model.MedicationRequest.MedicationRequestSubstitutionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestSubstitutionComponent tgt = new org.hl7.fhir.dstu3.model.MedicationRequest.MedicationRequestSubstitutionComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasAllowedBooleanType())
            tgt.setAllowedElement(VersionConvertor_30_50.convertBoolean(src.getAllowedBooleanType()));
        if (src.hasReason())
            tgt.setReason(VersionConvertor_30_50.convertCodeableConcept(src.getReason()));
        return tgt;
    }
}
