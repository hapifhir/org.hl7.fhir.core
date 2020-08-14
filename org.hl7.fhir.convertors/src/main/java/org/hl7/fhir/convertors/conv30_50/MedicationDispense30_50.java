package org.hl7.fhir.convertors.conv30_50;

import org.hl7.fhir.convertors.VersionConvertor_10_50;
import org.hl7.fhir.convertors.VersionConvertor_30_50;
import org.hl7.fhir.exceptions.FHIRException;

public class MedicationDispense30_50 {

    public static org.hl7.fhir.dstu3.model.MedicationDispense convertMedicationDispense(org.hl7.fhir.r5.model.MedicationDispense src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.MedicationDispense tgt = new org.hl7.fhir.dstu3.model.MedicationDispense();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(t));
        for (org.hl7.fhir.r5.model.Reference t : src.getPartOf()) tgt.addPartOf(VersionConvertor_30_50.convertReference(t));
        if (src.hasStatus())
            tgt.setStatusElement(convertMedicationDispenseStatus(src.getStatusElement()));
        if (src.hasCategory())
            tgt.setCategory(VersionConvertor_30_50.convertCodeableConcept(src.getCategoryFirstRep()));
        if (src.getMedication().hasConcept())
          tgt.setMedication(VersionConvertor_30_50.convertType(src.getMedication().getConcept()));
      if (src.getMedication().hasReference())
        tgt.setMedication(VersionConvertor_30_50.convertType(src.getMedication().getReference()));
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_30_50.convertReference(src.getSubject()));
        if (src.hasEncounter())
            tgt.setContext(VersionConvertor_30_50.convertReference(src.getEncounter()));
        for (org.hl7.fhir.r5.model.Reference t : src.getSupportingInformation()) tgt.addSupportingInformation(VersionConvertor_30_50.convertReference(t));
        for (org.hl7.fhir.r5.model.MedicationDispense.MedicationDispensePerformerComponent t : src.getPerformer()) tgt.addPerformer(convertMedicationDispensePerformerComponent(t));
        for (org.hl7.fhir.r5.model.Reference t : src.getAuthorizingPrescription()) tgt.addAuthorizingPrescription(VersionConvertor_30_50.convertReference(t));
        if (src.hasType())
            tgt.setType(VersionConvertor_30_50.convertCodeableConcept(src.getType()));
        if (src.hasQuantity())
            tgt.setQuantity(VersionConvertor_30_50.convertSimpleQuantity(src.getQuantity()));
        if (src.hasDaysSupply())
            tgt.setDaysSupply(VersionConvertor_30_50.convertSimpleQuantity(src.getDaysSupply()));
        if (src.hasWhenPrepared())
            tgt.setWhenPreparedElement(VersionConvertor_30_50.convertDateTime(src.getWhenPreparedElement()));
        if (src.hasWhenHandedOver())
            tgt.setWhenHandedOverElement(VersionConvertor_30_50.convertDateTime(src.getWhenHandedOverElement()));
        if (src.hasDestination())
            tgt.setDestination(VersionConvertor_30_50.convertReference(src.getDestination()));
        for (org.hl7.fhir.r5.model.Reference t : src.getReceiver()) tgt.addReceiver(VersionConvertor_30_50.convertReference(t));
        for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.addNote(VersionConvertor_30_50.convertAnnotation(t));
        for (org.hl7.fhir.r5.model.Dosage t : src.getDosageInstruction()) tgt.addDosageInstruction(VersionConvertor_30_50.convertDosage(t));
        if (src.hasSubstitution())
            tgt.setSubstitution(convertMedicationDispenseSubstitutionComponent(src.getSubstitution()));
        for (org.hl7.fhir.r5.model.Reference t : src.getDetectedIssue()) tgt.addDetectedIssue(VersionConvertor_30_50.convertReference(t));
        for (org.hl7.fhir.r5.model.Reference t : src.getEventHistory()) tgt.addEventHistory(VersionConvertor_30_50.convertReference(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.MedicationDispense convertMedicationDispense(org.hl7.fhir.dstu3.model.MedicationDispense src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.MedicationDispense tgt = new org.hl7.fhir.r5.model.MedicationDispense();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(t));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getPartOf()) tgt.addPartOf(VersionConvertor_30_50.convertReference(t));
        if (src.hasStatus())
            tgt.setStatusElement(convertMedicationDispenseStatus(src.getStatusElement()));
        if (src.hasCategory())
            tgt.addCategory(VersionConvertor_30_50.convertCodeableConcept(src.getCategory()));
        if (src.hasMedicationCodeableConcept())
          tgt.getMedication().setConcept(VersionConvertor_30_50.convertCodeableConcept(src.getMedicationCodeableConcept()));
        if (src.hasMedicationReference())
          tgt.getMedication().setReference(VersionConvertor_30_50.convertReference(src.getMedicationReference()));
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_30_50.convertReference(src.getSubject()));
        if (src.hasContext())
            tgt.setEncounter(VersionConvertor_30_50.convertReference(src.getContext()));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getSupportingInformation()) tgt.addSupportingInformation(VersionConvertor_30_50.convertReference(t));
        for (org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispensePerformerComponent t : src.getPerformer()) tgt.addPerformer(convertMedicationDispensePerformerComponent(t));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getAuthorizingPrescription()) tgt.addAuthorizingPrescription(VersionConvertor_30_50.convertReference(t));
        if (src.hasType())
            tgt.setType(VersionConvertor_30_50.convertCodeableConcept(src.getType()));
        if (src.hasQuantity())
            tgt.setQuantity(VersionConvertor_30_50.convertSimpleQuantity(src.getQuantity()));
        if (src.hasDaysSupply())
            tgt.setDaysSupply(VersionConvertor_30_50.convertSimpleQuantity(src.getDaysSupply()));
        if (src.hasWhenPrepared())
            tgt.setWhenPreparedElement(VersionConvertor_30_50.convertDateTime(src.getWhenPreparedElement()));
        if (src.hasWhenHandedOver())
            tgt.setWhenHandedOverElement(VersionConvertor_30_50.convertDateTime(src.getWhenHandedOverElement()));
        if (src.hasDestination())
            tgt.setDestination(VersionConvertor_30_50.convertReference(src.getDestination()));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getReceiver()) tgt.addReceiver(VersionConvertor_30_50.convertReference(t));
        for (org.hl7.fhir.dstu3.model.Annotation t : src.getNote()) tgt.addNote(VersionConvertor_30_50.convertAnnotation(t));
        for (org.hl7.fhir.dstu3.model.Dosage t : src.getDosageInstruction()) tgt.addDosageInstruction(VersionConvertor_30_50.convertDosage(t));
        if (src.hasSubstitution())
            tgt.setSubstitution(convertMedicationDispenseSubstitutionComponent(src.getSubstitution()));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getDetectedIssue()) tgt.addDetectedIssue(VersionConvertor_30_50.convertReference(t));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getEventHistory()) tgt.addEventHistory(VersionConvertor_30_50.convertReference(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.MedicationDispense.MedicationDispensePerformerComponent convertMedicationDispensePerformerComponent(org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispensePerformerComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.MedicationDispense.MedicationDispensePerformerComponent tgt = new org.hl7.fhir.r5.model.MedicationDispense.MedicationDispensePerformerComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasActor())
            tgt.setActor(VersionConvertor_30_50.convertReference(src.getActor()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispensePerformerComponent convertMedicationDispensePerformerComponent(org.hl7.fhir.r5.model.MedicationDispense.MedicationDispensePerformerComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispensePerformerComponent tgt = new org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispensePerformerComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasActor())
            tgt.setActor(VersionConvertor_30_50.convertReference(src.getActor()));
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseStatus> convertMedicationDispenseStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MedicationDispense.MedicationDispenseStatusCodes> src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseStatus>();
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case PREPARATION:
                tgt.setValue(org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseStatus.PREPARATION);
                break;
            case INPROGRESS:
                tgt.setValue(org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseStatus.INPROGRESS);
                break;
            case ONHOLD:
                tgt.setValue(org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseStatus.ONHOLD);
                break;
            case COMPLETED:
                tgt.setValue(org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseStatus.COMPLETED);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseStatus.ENTEREDINERROR);
                break;
            case STOPPED:
                tgt.setValue(org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseStatus.STOPPED);
                break;
            case DECLINED:
                tgt.setValue(org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseStatus.STOPPED);
                break;
            case NULL:
                tgt.setValue(org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MedicationDispense.MedicationDispenseStatusCodes> convertMedicationDispenseStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseStatus> src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MedicationDispense.MedicationDispenseStatusCodes> tgt = new org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MedicationDispense.MedicationDispenseStatusCodes>(new org.hl7.fhir.r5.model.MedicationDispense.MedicationDispenseStatusCodesEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case PREPARATION:
                tgt.setValue(org.hl7.fhir.r5.model.MedicationDispense.MedicationDispenseStatusCodes.PREPARATION);
                break;
            case INPROGRESS:
                tgt.setValue(org.hl7.fhir.r5.model.MedicationDispense.MedicationDispenseStatusCodes.INPROGRESS);
                break;
            case ONHOLD:
                tgt.setValue(org.hl7.fhir.r5.model.MedicationDispense.MedicationDispenseStatusCodes.ONHOLD);
                break;
            case COMPLETED:
                tgt.setValue(org.hl7.fhir.r5.model.MedicationDispense.MedicationDispenseStatusCodes.COMPLETED);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.r5.model.MedicationDispense.MedicationDispenseStatusCodes.ENTEREDINERROR);
                break;
            case STOPPED:
                tgt.setValue(org.hl7.fhir.r5.model.MedicationDispense.MedicationDispenseStatusCodes.STOPPED);
                break;
            case NULL:
                tgt.setValue(org.hl7.fhir.r5.model.MedicationDispense.MedicationDispenseStatusCodes.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.MedicationDispense.MedicationDispenseSubstitutionComponent convertMedicationDispenseSubstitutionComponent(org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseSubstitutionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.MedicationDispense.MedicationDispenseSubstitutionComponent tgt = new org.hl7.fhir.r5.model.MedicationDispense.MedicationDispenseSubstitutionComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasWasSubstituted())
            tgt.setWasSubstitutedElement(VersionConvertor_30_50.convertBoolean(src.getWasSubstitutedElement()));
        if (src.hasType())
            tgt.setType(VersionConvertor_30_50.convertCodeableConcept(src.getType()));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getReason()) tgt.addReason(VersionConvertor_30_50.convertCodeableConcept(t));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getResponsibleParty()) tgt.setResponsibleParty(VersionConvertor_30_50.convertReference(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseSubstitutionComponent convertMedicationDispenseSubstitutionComponent(org.hl7.fhir.r5.model.MedicationDispense.MedicationDispenseSubstitutionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseSubstitutionComponent tgt = new org.hl7.fhir.dstu3.model.MedicationDispense.MedicationDispenseSubstitutionComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasWasSubstituted())
            tgt.setWasSubstitutedElement(VersionConvertor_30_50.convertBoolean(src.getWasSubstitutedElement()));
        if (src.hasType())
            tgt.setType(VersionConvertor_30_50.convertCodeableConcept(src.getType()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getReason()) tgt.addReason(VersionConvertor_30_50.convertCodeableConcept(t));
        if (src.hasResponsibleParty())
            tgt.addResponsibleParty(VersionConvertor_30_50.convertReference(src.getResponsibleParty()));
        return tgt;
    }
}