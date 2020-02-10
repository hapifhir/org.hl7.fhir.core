package org.hl7.fhir.convertors.conv10_30;

import org.hl7.fhir.convertors.VersionConvertor_10_30;
import org.hl7.fhir.dstu3.model.Dosage;
import org.hl7.fhir.exceptions.FHIRException;
import java.util.Collections;

public class MedicationDispense10_30 {

    public static org.hl7.fhir.dstu3.model.MedicationDispense convertMedicationDispense(org.hl7.fhir.dstu2.model.MedicationDispense src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.MedicationDispense tgt = new org.hl7.fhir.dstu3.model.MedicationDispense();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            tgt.addIdentifier(VersionConvertor_10_30.convertIdentifier(src.getIdentifier()));
        }
        if (src.hasStatus()) {
            tgt.setStatus(convertMedicationDispenseStatus(src.getStatus()));
        }
        if (src.hasMedication()) {
            tgt.setMedication(VersionConvertor_10_30.convertType(src.getMedication()));
        }
        if (src.hasPatient()) {
            tgt.setSubject(VersionConvertor_10_30.convertReference(src.getPatient()));
        }
        if (src.hasAuthorizingPrescription()) {
            for (org.hl7.fhir.dstu2.model.Reference t : src.getAuthorizingPrescription()) tgt.addAuthorizingPrescription(VersionConvertor_10_30.convertReference(t));
        }
        if (src.hasType()) {
            tgt.setType(VersionConvertor_10_30.convertCodeableConcept(src.getType()));
        }
        if (src.hasQuantity()) {
            tgt.setQuantity(VersionConvertor_10_30.convertSimpleQuantity(src.getQuantity()));
        }
        if (src.hasDaysSupply()) {
            tgt.setDaysSupply(VersionConvertor_10_30.convertSimpleQuantity(src.getDaysSupply()));
        }
        if (src.hasWhenPreparedElement())
            tgt.setWhenPreparedElement((org.hl7.fhir.dstu3.model.DateTimeType) VersionConvertor_10_30.convertType(src.getWhenPreparedElement()));
        if (src.hasWhenHandedOverElement())
            tgt.setWhenHandedOverElement((org.hl7.fhir.dstu3.model.DateTimeType) VersionConvertor_10_30.convertType(src.getWhenHandedOverElement()));
        if (src.hasDestination()) {
            tgt.setDestination(VersionConvertor_10_30.convertReference(src.getDestination()));
        }
        if (src.hasReceiver()) {
            for (org.hl7.fhir.dstu2.model.Reference t : src.getReceiver()) tgt.addReceiver(VersionConvertor_10_30.convertReference(t));
        }
        if (src.hasNoteElement())
            tgt.setNote(Collections.singletonList((org.hl7.fhir.dstu3.model.Annotation) VersionConvertor_10_30.convertType(src.getNoteElement())));
        if (src.hasDosageInstruction()) {
            for (org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseDosageInstructionComponent t : src.getDosageInstruction()) tgt.addDosageInstruction(convertMedicationDispenseDosageInstructionComponent(t));
        }
        if (src.hasSubstitution()) {
            tgt.setSubstitution(convertMedicationDispenseSubstitutionComponent(src.getSubstitution()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.MedicationDispense convertMedicationDispense(org.hl7.fhir.dstu3.model.MedicationDispense src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.MedicationDispense tgt = new org.hl7.fhir.dstu2.model.MedicationDispense();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            tgt.setIdentifier(VersionConvertor_10_30.convertIdentifier(src.getIdentifierFirstRep()));
        }
        if (src.hasStatus()) {
            tgt.setStatus(convertMedicationDispenseStatus(src.getStatus()));
        }
        if (src.hasMedication()) {
            tgt.setMedication(VersionConvertor_10_30.convertType(src.getMedication()));
        }
        if (src.hasSubject()) {
            tgt.setPatient(VersionConvertor_10_30.convertReference(src.getSubject()));
        }
        if (src.hasAuthorizingPrescription()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getAuthorizingPrescription()) tgt.addAuthorizingPrescription(VersionConvertor_10_30.convertReference(t));
        }
        if (src.hasType()) {
            tgt.setType(VersionConvertor_10_30.convertCodeableConcept(src.getType()));
        }
        if (src.hasQuantity()) {
            tgt.setQuantity(VersionConvertor_10_30.convertSimpleQuantity(src.getQuantity()));
        }
        if (src.hasDaysSupply()) {
            tgt.setDaysSupply(VersionConvertor_10_30.convertSimpleQuantity(src.getDaysSupply()));
        }
        if (src.hasWhenPreparedElement())
            tgt.setWhenPreparedElement((org.hl7.fhir.dstu2.model.DateTimeType) VersionConvertor_10_30.convertType(src.getWhenPreparedElement()));
        if (src.hasWhenHandedOverElement())
            tgt.setWhenHandedOverElement((org.hl7.fhir.dstu2.model.DateTimeType) VersionConvertor_10_30.convertType(src.getWhenHandedOverElement()));
        if (src.hasDestination()) {
            tgt.setDestination(VersionConvertor_10_30.convertReference(src.getDestination()));
        }
        if (src.hasReceiver()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getReceiver()) tgt.addReceiver(VersionConvertor_10_30.convertReference(t));
        }
        if (src.hasNote()) {
            for (org.hl7.fhir.dstu3.model.Annotation t : src.getNote()) tgt.setNote(t.getText());
        }
        if (src.hasDosageInstruction()) {
            for (org.hl7.fhir.dstu3.model.Dosage t : src.getDosageInstruction()) tgt.addDosageInstruction(convertMedicationDispenseDosageInstructionComponent(t));
        }
        if (src.hasSubstitution()) {
            tgt.setSubstitution(convertMedicationDispenseSubstitutionComponent(src.getSubstitution()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Dosage convertMedicationDispenseDosageInstructionComponent(org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseDosageInstructionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Dosage tgt = new org.hl7.fhir.dstu3.model.Dosage();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasText()) {
            tgt.setText(src.getText());
        }
        if (src.hasTiming()) {
            tgt.setTiming(VersionConvertor_10_30.convertTiming(src.getTiming()));
        }
        if (src.hasAsNeeded()) {
            tgt.setAsNeeded(VersionConvertor_10_30.convertType(src.getAsNeeded()));
        }
        if (src.hasSiteCodeableConcept())
            tgt.setSite(VersionConvertor_10_30.convertCodeableConcept(src.getSiteCodeableConcept()));
        if (src.hasRoute()) {
            tgt.setRoute(VersionConvertor_10_30.convertCodeableConcept(src.getRoute()));
        }
        if (src.hasMethod()) {
            tgt.setMethod(VersionConvertor_10_30.convertCodeableConcept(src.getMethod()));
        }
        if (src.hasDose()) {
            tgt.setDose(VersionConvertor_10_30.convertType(src.getDose()));
        }
        if (src.hasRate()) {
            tgt.setRate(VersionConvertor_10_30.convertType(src.getRate()));
        }
        if (src.hasMaxDosePerPeriod()) {
            tgt.setMaxDosePerPeriod(VersionConvertor_10_30.convertRatio(src.getMaxDosePerPeriod()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseDosageInstructionComponent convertMedicationDispenseDosageInstructionComponent(Dosage src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseDosageInstructionComponent tgt = new org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseDosageInstructionComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasText()) {
            tgt.setText(src.getText());
        }
        if (src.hasTiming()) {
            tgt.setTiming(VersionConvertor_10_30.convertTiming(src.getTiming()));
        }
        if (src.hasAsNeeded()) {
            tgt.setAsNeeded(VersionConvertor_10_30.convertType(src.getAsNeeded()));
        }
        if (src.hasSite()) {
            tgt.setSite(VersionConvertor_10_30.convertType(src.getSite()));
        }
        if (src.hasRoute()) {
            tgt.setRoute(VersionConvertor_10_30.convertCodeableConcept(src.getRoute()));
        }
        if (src.hasMethod()) {
            tgt.setMethod(VersionConvertor_10_30.convertCodeableConcept(src.getMethod()));
        }
        if (src.hasDose()) {
            tgt.setDose(VersionConvertor_10_30.convertType(src.getDose()));
        }
        if (src.hasRate()) {
            tgt.setRate(VersionConvertor_10_30.convertType(src.getRate()));
        }
        if (src.hasMaxDosePerPeriod()) {
            tgt.setMaxDosePerPeriod(VersionConvertor_10_30.convertRatio(src.getMaxDosePerPeriod()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseStatus convertMedicationDispenseStatus(org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case INPROGRESS:
                return org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseStatus.INPROGRESS;
            case ONHOLD:
                return org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseStatus.ONHOLD;
            case COMPLETED:
                return org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseStatus.COMPLETED;
            case ENTEREDINERROR:
                return org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseStatus.ENTEREDINERROR;
            case STOPPED:
                return org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseStatus.STOPPED;
            default:
                return org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseStatus.NULL;
        }
    }

    public static org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseStatus convertMedicationDispenseStatus(org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case INPROGRESS:
                return org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseStatus.INPROGRESS;
            case ONHOLD:
                return org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseStatus.ONHOLD;
            case COMPLETED:
                return org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseStatus.COMPLETED;
            case ENTEREDINERROR:
                return org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseStatus.ENTEREDINERROR;
            case STOPPED:
                return org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseStatus.STOPPED;
            default:
                return org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseStatus.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseSubstitutionComponent convertMedicationDispenseSubstitutionComponent(org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseSubstitutionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseSubstitutionComponent tgt = new org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseSubstitutionComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasType()) {
            tgt.setType(VersionConvertor_10_30.convertCodeableConcept(src.getType()));
        }
        if (src.hasReason()) {
            for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getReason()) tgt.addReason(VersionConvertor_10_30.convertCodeableConcept(t));
        }
        if (src.hasResponsibleParty()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getResponsibleParty()) tgt.addResponsibleParty(VersionConvertor_10_30.convertReference(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseSubstitutionComponent convertMedicationDispenseSubstitutionComponent(org.hl7.fhir.dstu2.model.MedicationDispense.MedicationDispenseSubstitutionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseSubstitutionComponent tgt = new org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseSubstitutionComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasType()) {
            tgt.setType(VersionConvertor_10_30.convertCodeableConcept(src.getType()));
        }
        if (src.hasReason()) {
            for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getReason()) tgt.addReason(VersionConvertor_10_30.convertCodeableConcept(t));
        }
        if (src.hasResponsibleParty()) {
            for (org.hl7.fhir.dstu2.model.Reference t : src.getResponsibleParty()) tgt.addResponsibleParty(VersionConvertor_10_30.convertReference(t));
        }
        return tgt;
    }
}
