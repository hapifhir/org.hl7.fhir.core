package org.hl7.fhir.convertors.conv30_40;

import org.hl7.fhir.convertors.VersionConvertor_30_40;
import org.hl7.fhir.exceptions.FHIRException;

public class MedicationStatement30_40 {

    public static org.hl7.fhir.dstu3.model.MedicationStatement convertMedicationStatement(org.hl7.fhir.r4.model.MedicationStatement src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.MedicationStatement tgt = new org.hl7.fhir.dstu3.model.MedicationStatement();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getBasedOn()) tgt.addBasedOn(VersionConvertor_30_40.convertReference(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getPartOf()) tgt.addPartOf(VersionConvertor_30_40.convertReference(t));
        if (src.hasContext())
            tgt.setContext(VersionConvertor_30_40.convertReference(src.getContext()));
        if (src.hasStatus())
            tgt.setStatusElement(convertMedicationStatementStatus(src.getStatusElement()));
        if (src.hasCategory())
            tgt.setCategory(VersionConvertor_30_40.convertCodeableConcept(src.getCategory()));
        if (src.hasMedication())
            tgt.setMedication(VersionConvertor_30_40.convertType(src.getMedication()));
        if (src.hasEffective())
            tgt.setEffective(VersionConvertor_30_40.convertType(src.getEffective()));
        if (src.hasDateAsserted())
            tgt.setDateAssertedElement(VersionConvertor_30_40.convertDateTime(src.getDateAssertedElement()));
        if (src.hasInformationSource())
            tgt.setInformationSource(VersionConvertor_30_40.convertReference(src.getInformationSource()));
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_30_40.convertReference(src.getSubject()));
        for (org.hl7.fhir.r4.model.Reference t : src.getDerivedFrom()) tgt.addDerivedFrom(VersionConvertor_30_40.convertReference(t));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReasonCode()) tgt.addReasonCode(VersionConvertor_30_40.convertCodeableConcept(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getReasonReference()) tgt.addReasonReference(VersionConvertor_30_40.convertReference(t));
        for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.addNote(VersionConvertor_30_40.convertAnnotation(t));
        for (org.hl7.fhir.r4.model.Dosage t : src.getDosage()) tgt.addDosage(VersionConvertor_30_40.convertDosage(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.MedicationStatement convertMedicationStatement(org.hl7.fhir.dstu3.model.MedicationStatement src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.MedicationStatement tgt = new org.hl7.fhir.r4.model.MedicationStatement();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getBasedOn()) tgt.addBasedOn(VersionConvertor_30_40.convertReference(t));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getPartOf()) tgt.addPartOf(VersionConvertor_30_40.convertReference(t));
        if (src.hasContext())
            tgt.setContext(VersionConvertor_30_40.convertReference(src.getContext()));
        if (src.hasStatus())
            tgt.setStatusElement(convertMedicationStatementStatus(src.getStatusElement()));
        if (src.hasCategory())
            tgt.setCategory(VersionConvertor_30_40.convertCodeableConcept(src.getCategory()));
        if (src.hasMedication())
            tgt.setMedication(VersionConvertor_30_40.convertType(src.getMedication()));
        if (src.hasEffective())
            tgt.setEffective(VersionConvertor_30_40.convertType(src.getEffective()));
        if (src.hasDateAsserted())
            tgt.setDateAssertedElement(VersionConvertor_30_40.convertDateTime(src.getDateAssertedElement()));
        if (src.hasInformationSource())
            tgt.setInformationSource(VersionConvertor_30_40.convertReference(src.getInformationSource()));
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_30_40.convertReference(src.getSubject()));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getDerivedFrom()) tgt.addDerivedFrom(VersionConvertor_30_40.convertReference(t));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getReasonCode()) tgt.addReasonCode(VersionConvertor_30_40.convertCodeableConcept(t));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getReasonReference()) tgt.addReasonReference(VersionConvertor_30_40.convertReference(t));
        for (org.hl7.fhir.dstu3.model.Annotation t : src.getNote()) tgt.addNote(VersionConvertor_30_40.convertAnnotation(t));
        for (org.hl7.fhir.dstu3.model.Dosage t : src.getDosage()) tgt.addDosage(VersionConvertor_30_40.convertDosage(t));
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.MedicationStatement.MedicationStatementStatus> convertMedicationStatementStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.MedicationStatement.MedicationStatementStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.MedicationStatement.MedicationStatementStatusEnumFactory());
        VersionConvertor_30_40.copyElement(src, tgt);
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

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus> convertMedicationStatementStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.MedicationStatement.MedicationStatementStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatusEnumFactory());
        VersionConvertor_30_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case ACTIVE:
                tgt.setValue(org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus.ACTIVE);
                break;
            case COMPLETED:
                tgt.setValue(org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus.COMPLETED);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus.ENTEREDINERROR);
                break;
            case INTENDED:
                tgt.setValue(org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus.INTENDED);
                break;
            case STOPPED:
                tgt.setValue(org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus.STOPPED);
                break;
            case ONHOLD:
                tgt.setValue(org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus.ONHOLD);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus.NULL);
                break;
        }
        return tgt;
    }
}