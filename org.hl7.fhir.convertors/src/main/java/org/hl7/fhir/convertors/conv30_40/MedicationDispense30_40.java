package org.hl7.fhir.convertors.conv30_40;

import org.hl7.fhir.convertors.VersionConvertor_30_40;
import org.hl7.fhir.exceptions.FHIRException;
import java.util.Collections;

public class MedicationDispense30_40 {

    public static org.hl7.fhir.dstu3.model.MedicationDispense convertMedicationDispense(org.hl7.fhir.r4.model.MedicationDispense src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.MedicationDispense tgt = new org.hl7.fhir.dstu3.model.MedicationDispense();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        }
        if (src.hasPartOf()) {
            for (org.hl7.fhir.r4.model.Reference t : src.getPartOf()) tgt.addPartOf(VersionConvertor_30_40.convertReference(t));
        }
        if (src.hasStatus())
            tgt.setStatus(convertMedicationDispenseStatus(src.getStatus()));
        if (src.hasCategory())
            tgt.setCategory(VersionConvertor_30_40.convertCodeableConcept(src.getCategory()));
        if (src.hasMedication())
            tgt.setMedication(VersionConvertor_30_40.convertType(src.getMedication()));
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_30_40.convertReference(src.getSubject()));
        if (src.hasContext())
            tgt.setContext(VersionConvertor_30_40.convertReference(src.getContext()));
        if (src.hasSupportingInformation()) {
            for (org.hl7.fhir.r4.model.Reference t : src.getSupportingInformation()) tgt.addSupportingInformation(VersionConvertor_30_40.convertReference(t));
        }
        if (src.hasPerformer()) {
            for (org.hl7.fhir.r4.model.MedicationDispense.MedicationDispensePerformerComponent t : src.getPerformer()) tgt.addPerformer(convertMedicationDispensePerformerComponent(t));
        }
        if (src.hasAuthorizingPrescription()) {
            for (org.hl7.fhir.r4.model.Reference t : src.getAuthorizingPrescription()) tgt.addAuthorizingPrescription(VersionConvertor_30_40.convertReference(t));
        }
        if (src.hasType())
            tgt.setType(VersionConvertor_30_40.convertCodeableConcept(src.getType()));
        if (src.hasQuantity())
            tgt.setQuantity(VersionConvertor_30_40.convertSimpleQuantity(src.getQuantity()));
        if (src.hasDaysSupply())
            tgt.setDaysSupply(VersionConvertor_30_40.convertSimpleQuantity(src.getDaysSupply()));
        if (src.hasWhenPrepared())
            tgt.setWhenPreparedElement(VersionConvertor_30_40.convertDateTime(src.getWhenPreparedElement()));
        if (src.hasWhenHandedOver())
            tgt.setWhenHandedOverElement(VersionConvertor_30_40.convertDateTime(src.getWhenHandedOverElement()));
        if (src.hasDestination())
            tgt.setDestination(VersionConvertor_30_40.convertReference(src.getDestination()));
        if (src.hasReceiver()) {
            for (org.hl7.fhir.r4.model.Reference t : src.getReceiver()) tgt.addReceiver(VersionConvertor_30_40.convertReference(t));
        }
        if (src.hasNote()) {
            for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.addNote(VersionConvertor_30_40.convertAnnotation(t));
        }
        if (src.hasDosageInstruction()) {
            for (org.hl7.fhir.r4.model.Dosage t : src.getDosageInstruction()) tgt.addDosageInstruction(VersionConvertor_30_40.convertDosage(t));
        }
        if (src.hasSubstitution())
            tgt.setSubstitution(convertMedicationDispenseSubstitutionComponent(src.getSubstitution()));
        if (src.hasDetectedIssue()) {
            for (org.hl7.fhir.r4.model.Reference t : src.getDetectedIssue()) tgt.addDetectedIssue(VersionConvertor_30_40.convertReference(t));
        }
        if (src.hasEventHistory()) {
            for (org.hl7.fhir.r4.model.Reference t : src.getEventHistory()) tgt.addEventHistory(VersionConvertor_30_40.convertReference(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.MedicationDispense convertMedicationDispense(org.hl7.fhir.dstu3.model.MedicationDispense src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.MedicationDispense tgt = new org.hl7.fhir.r4.model.MedicationDispense();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        }
        if (src.hasPartOf()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getPartOf()) tgt.addPartOf(VersionConvertor_30_40.convertReference(t));
        }
        if (src.hasStatus())
            tgt.setStatus(convertMedicationDispenseStatus(src.getStatus()));
        if (src.hasCategory())
            tgt.setCategory(VersionConvertor_30_40.convertCodeableConcept(src.getCategory()));
        if (src.hasMedication())
            tgt.setMedication(VersionConvertor_30_40.convertType(src.getMedication()));
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_30_40.convertReference(src.getSubject()));
        if (src.hasContext())
            tgt.setContext(VersionConvertor_30_40.convertReference(src.getContext()));
        if (src.hasSupportingInformation()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getSupportingInformation()) tgt.addSupportingInformation(VersionConvertor_30_40.convertReference(t));
        }
        if (src.hasPerformer()) {
            for (org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispensePerformerComponent t : src.getPerformer()) tgt.addPerformer(convertMedicationDispensePerformerComponent(t));
        }
        if (src.hasAuthorizingPrescription()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getAuthorizingPrescription()) tgt.addAuthorizingPrescription(VersionConvertor_30_40.convertReference(t));
        }
        if (src.hasType())
            tgt.setType(VersionConvertor_30_40.convertCodeableConcept(src.getType()));
        if (src.hasQuantity())
            tgt.setQuantity(VersionConvertor_30_40.convertSimpleQuantity(src.getQuantity()));
        if (src.hasDaysSupply())
            tgt.setDaysSupply(VersionConvertor_30_40.convertSimpleQuantity(src.getDaysSupply()));
        if (src.hasWhenPrepared())
            tgt.setWhenPreparedElement(VersionConvertor_30_40.convertDateTime(src.getWhenPreparedElement()));
        if (src.hasWhenHandedOver())
            tgt.setWhenHandedOverElement(VersionConvertor_30_40.convertDateTime(src.getWhenHandedOverElement()));
        if (src.hasDestination())
            tgt.setDestination(VersionConvertor_30_40.convertReference(src.getDestination()));
        if (src.hasReceiver()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getReceiver()) tgt.addReceiver(VersionConvertor_30_40.convertReference(t));
        }
        if (src.hasNote()) {
            for (org.hl7.fhir.dstu3.model.Annotation t : src.getNote()) tgt.addNote(VersionConvertor_30_40.convertAnnotation(t));
        }
        if (src.hasDosageInstruction()) {
            for (org.hl7.fhir.dstu3.model.Dosage t : src.getDosageInstruction()) tgt.addDosageInstruction(VersionConvertor_30_40.convertDosage(t));
        }
        if (src.hasSubstitution())
            tgt.setSubstitution(convertMedicationDispenseSubstitutionComponent(src.getSubstitution()));
        if (src.hasDetectedIssue()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getDetectedIssue()) tgt.addDetectedIssue(VersionConvertor_30_40.convertReference(t));
        }
        if (src.hasEventHistory()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getEventHistory()) tgt.addEventHistory(VersionConvertor_30_40.convertReference(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispensePerformerComponent convertMedicationDispensePerformerComponent(org.hl7.fhir.r4.model.MedicationDispense.MedicationDispensePerformerComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispensePerformerComponent tgt = new org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispensePerformerComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasActor())
            tgt.setActor(VersionConvertor_30_40.convertReference(src.getActor()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.MedicationDispense.MedicationDispensePerformerComponent convertMedicationDispensePerformerComponent(org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispensePerformerComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.MedicationDispense.MedicationDispensePerformerComponent tgt = new org.hl7.fhir.r4.model.MedicationDispense.MedicationDispensePerformerComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasActor())
            tgt.setActor(VersionConvertor_30_40.convertReference(src.getActor()));
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseStatus convertMedicationDispenseStatus(String src) throws FHIRException {
        if (src == null)
            return null;
        return org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseStatus.fromCode(src);
    }

    static public String convertMedicationDispenseStatus(org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseStatus src) throws FHIRException {
        if (src == null)
            return null;
        return src.toCode();
    }

    public static org.hl7.fhir.r4.model.MedicationDispense.MedicationDispenseSubstitutionComponent convertMedicationDispenseSubstitutionComponent(org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseSubstitutionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.MedicationDispense.MedicationDispenseSubstitutionComponent tgt = new org.hl7.fhir.r4.model.MedicationDispense.MedicationDispenseSubstitutionComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasWasSubstitutedElement())
            tgt.setWasSubstitutedElement((org.hl7.fhir.r4.model.BooleanType) VersionConvertor_30_40.convertType(src.getWasSubstitutedElement()));
        if (src.hasType())
            tgt.setType(VersionConvertor_30_40.convertCodeableConcept(src.getType()));
        if (src.hasReason()) {
            for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getReason()) tgt.addReason(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        if (src.hasResponsibleParty()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getResponsibleParty()) tgt.addResponsibleParty(VersionConvertor_30_40.convertReference(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseSubstitutionComponent convertMedicationDispenseSubstitutionComponent(org.hl7.fhir.r4.model.MedicationDispense.MedicationDispenseSubstitutionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseSubstitutionComponent tgt = new org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseSubstitutionComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasWasSubstitutedElement())
            tgt.setWasSubstitutedElement((org.hl7.fhir.dstu3.model.BooleanType) VersionConvertor_30_40.convertType(src.getWasSubstitutedElement()));
        if (src.hasType())
            tgt.setType(VersionConvertor_30_40.convertCodeableConcept(src.getType()));
        if (src.hasReason()) {
            for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReason()) tgt.addReason(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        if (src.hasResponsibleParty()) {
            for (org.hl7.fhir.r4.model.Reference t : src.getResponsibleParty()) tgt.addResponsibleParty(VersionConvertor_30_40.convertReference(t));
        }
        return tgt;
    }
}
