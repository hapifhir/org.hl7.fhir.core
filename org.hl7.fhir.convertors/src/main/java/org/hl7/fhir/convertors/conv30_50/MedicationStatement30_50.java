package org.hl7.fhir.convertors.conv30_50;

import org.hl7.fhir.convertors.VersionConvertor_30_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CodeableReference;

public class MedicationStatement30_50 {

    public static org.hl7.fhir.r5.model.MedicationUsage convertMedicationStatement(org.hl7.fhir.dstu3.model.MedicationStatement src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.MedicationUsage tgt = new org.hl7.fhir.r5.model.MedicationUsage();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(t));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getBasedOn()) tgt.addBasedOn(VersionConvertor_30_50.convertReference(t));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getPartOf()) tgt.addPartOf(VersionConvertor_30_50.convertReference(t));
        if (src.hasContext())
            tgt.setEncounter(VersionConvertor_30_50.convertReference(src.getContext()));
        if (src.hasStatus())
            tgt.setStatusElement(convertMedicationStatementStatus(src.getStatusElement()));
        if (src.hasCategory())
            tgt.addCategory(VersionConvertor_30_50.convertCodeableConcept(src.getCategory()));
        if (src.hasMedicationCodeableConcept()) {
          tgt.getMedication().setConcept(VersionConvertor_30_50.convertCodeableConcept(src.getMedicationCodeableConcept()));
        }
        if (src.hasMedicationReference()) {
          tgt.getMedication().setReference(VersionConvertor_30_50.convertReference(src.getMedicationReference()));
        }
        if (src.hasEffective())
            tgt.setEffective(VersionConvertor_30_50.convertType(src.getEffective()));
        if (src.hasDateAsserted())
            tgt.setDateAssertedElement(VersionConvertor_30_50.convertDateTime(src.getDateAssertedElement()));
        if (src.hasInformationSource())
            tgt.setInformationSource(VersionConvertor_30_50.convertReference(src.getInformationSource()));
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_30_50.convertReference(src.getSubject()));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getDerivedFrom()) tgt.addDerivedFrom(VersionConvertor_30_50.convertReference(t));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getReasonCode()) tgt.addReason(VersionConvertor_30_50.convertCodeableConceptToCodableReference(t));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getReasonReference()) tgt.addReason(VersionConvertor_30_50.convertReferenceToCodableReference(t));
        for (org.hl7.fhir.dstu3.model.Annotation t : src.getNote()) tgt.addNote(VersionConvertor_30_50.convertAnnotation(t));
        for (org.hl7.fhir.dstu3.model.Dosage t : src.getDosage()) tgt.addDosage(VersionConvertor_30_50.convertDosage(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.MedicationStatement convertMedicationStatement(org.hl7.fhir.r5.model.MedicationUsage src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.MedicationStatement tgt = new org.hl7.fhir.dstu3.model.MedicationStatement();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(t));
        for (org.hl7.fhir.r5.model.Reference t : src.getBasedOn()) tgt.addBasedOn(VersionConvertor_30_50.convertReference(t));
        for (org.hl7.fhir.r5.model.Reference t : src.getPartOf()) tgt.addPartOf(VersionConvertor_30_50.convertReference(t));
        if (src.hasEncounter())
            tgt.setContext(VersionConvertor_30_50.convertReference(src.getEncounter()));
        if (src.hasStatus())
            tgt.setStatusElement(convertMedicationStatementStatus(src.getStatusElement()));
        if (src.hasCategory())
            tgt.setCategory(VersionConvertor_30_50.convertCodeableConcept(src.getCategoryFirstRep()));
        if (src.getMedication().hasConcept()) {
          tgt.setMedication(VersionConvertor_30_50.convertType(src.getMedication().getConcept()));
        }
        if (src.getMedication().hasReference()) {
          tgt.setMedication(VersionConvertor_30_50.convertType(src.getMedication().getReference()));
        }
        if (src.hasEffective())
            tgt.setEffective(VersionConvertor_30_50.convertType(src.getEffective()));
        if (src.hasDateAsserted())
            tgt.setDateAssertedElement(VersionConvertor_30_50.convertDateTime(src.getDateAssertedElement()));
        if (src.hasInformationSource())
            tgt.setInformationSource(VersionConvertor_30_50.convertReference(src.getInformationSource()));
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_30_50.convertReference(src.getSubject()));
        for (org.hl7.fhir.r5.model.Reference t : src.getDerivedFrom()) tgt.addDerivedFrom(VersionConvertor_30_50.convertReference(t));
        for (CodeableReference t : src.getReason()) if (t.hasConcept())
            tgt.addReasonCode(VersionConvertor_30_50.convertCodeableConcept(t.getConcept()));
        for (CodeableReference t : src.getReason()) if (t.hasReference())
            tgt.addReasonReference(VersionConvertor_30_50.convertReference(t.getReference()));
        for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.addNote(VersionConvertor_30_50.convertAnnotation(t));
        for (org.hl7.fhir.r5.model.Dosage t : src.getDosage()) tgt.addDosage(VersionConvertor_30_50.convertDosage(t));
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.MedicationStatement.MedicationStatementStatus> convertMedicationStatementStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MedicationUsage.MedicationUsageStatusCodes> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.MedicationStatement.MedicationStatementStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.MedicationStatement.MedicationStatementStatusEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case ACTIVE:
                tgt.setValue(org.hl7.fhir.dstu3.model.MedicationStatement.MedicationStatementStatus.ACTIVE);
                break;
            case COMPLETED:
                tgt.setValue(org.hl7.fhir.dstu3.model.MedicationStatement.MedicationStatementStatus.COMPLETED);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.dstu3.model.MedicationStatement.MedicationStatementStatus.ENTEREDINERROR);
                break;
            case INTENDED:
                tgt.setValue(org.hl7.fhir.dstu3.model.MedicationStatement.MedicationStatementStatus.INTENDED);
                break;
            case STOPPED:
                tgt.setValue(org.hl7.fhir.dstu3.model.MedicationStatement.MedicationStatementStatus.STOPPED);
                break;
            case ONHOLD:
                tgt.setValue(org.hl7.fhir.dstu3.model.MedicationStatement.MedicationStatementStatus.ONHOLD);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.MedicationStatement.MedicationStatementStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MedicationUsage.MedicationUsageStatusCodes> convertMedicationStatementStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.MedicationStatement.MedicationStatementStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MedicationUsage.MedicationUsageStatusCodes> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.MedicationUsage.MedicationUsageStatusCodesEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case ACTIVE:
                tgt.setValue(org.hl7.fhir.r5.model.MedicationUsage.MedicationUsageStatusCodes.ACTIVE);
                break;
            case COMPLETED:
                tgt.setValue(org.hl7.fhir.r5.model.MedicationUsage.MedicationUsageStatusCodes.COMPLETED);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.r5.model.MedicationUsage.MedicationUsageStatusCodes.ENTEREDINERROR);
                break;
            case INTENDED:
                tgt.setValue(org.hl7.fhir.r5.model.MedicationUsage.MedicationUsageStatusCodes.INTENDED);
                break;
            case STOPPED:
                tgt.setValue(org.hl7.fhir.r5.model.MedicationUsage.MedicationUsageStatusCodes.STOPPED);
                break;
            case ONHOLD:
                tgt.setValue(org.hl7.fhir.r5.model.MedicationUsage.MedicationUsageStatusCodes.ONHOLD);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.MedicationUsage.MedicationUsageStatusCodes.NULL);
                break;
        }
        return tgt;
    }
}