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
            tgt.setStatus(convertMedicationStatementStatus(src.getStatus()));
        if (src.hasCategory())
            tgt.addCategory(VersionConvertor_30_50.convertCodeableConcept(src.getCategory()));
        if (src.hasMedication())
            tgt.setMedication(VersionConvertor_30_50.convertType(src.getMedication()));
        if (src.hasEffective())
            tgt.setEffective(VersionConvertor_30_50.convertType(src.getEffective()));
        if (src.hasDateAsserted())
            tgt.setDateAsserted(src.getDateAsserted());
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
            tgt.setStatus(convertMedicationStatementStatus(src.getStatus()));
        if (src.hasCategory())
            tgt.setCategory(VersionConvertor_30_50.convertCodeableConcept(src.getCategoryFirstRep()));
        if (src.hasMedication())
            tgt.setMedication(VersionConvertor_30_50.convertType(src.getMedication()));
        if (src.hasEffective())
            tgt.setEffective(VersionConvertor_30_50.convertType(src.getEffective()));
        if (src.hasDateAsserted())
            tgt.setDateAsserted(src.getDateAsserted());
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

    static public org.hl7.fhir.dstu3.model.MedicationStatement.MedicationStatementStatus convertMedicationStatementStatus(org.hl7.fhir.r5.model.MedicationUsage.MedicationUsageStatusCodes src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case ACTIVE:
                return org.hl7.fhir.dstu3.model.MedicationStatement.MedicationStatementStatus.ACTIVE;
            case COMPLETED:
                return org.hl7.fhir.dstu3.model.MedicationStatement.MedicationStatementStatus.COMPLETED;
            case ENTEREDINERROR:
                return org.hl7.fhir.dstu3.model.MedicationStatement.MedicationStatementStatus.ENTEREDINERROR;
            case INTENDED:
                return org.hl7.fhir.dstu3.model.MedicationStatement.MedicationStatementStatus.INTENDED;
            case STOPPED:
                return org.hl7.fhir.dstu3.model.MedicationStatement.MedicationStatementStatus.STOPPED;
            case ONHOLD:
                return org.hl7.fhir.dstu3.model.MedicationStatement.MedicationStatementStatus.ONHOLD;
            default:
                return org.hl7.fhir.dstu3.model.MedicationStatement.MedicationStatementStatus.NULL;
        }
    }

    static public org.hl7.fhir.r5.model.MedicationUsage.MedicationUsageStatusCodes convertMedicationStatementStatus(org.hl7.fhir.dstu3.model.MedicationStatement.MedicationStatementStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case ACTIVE:
                return org.hl7.fhir.r5.model.MedicationUsage.MedicationUsageStatusCodes.ACTIVE;
            case COMPLETED:
                return org.hl7.fhir.r5.model.MedicationUsage.MedicationUsageStatusCodes.COMPLETED;
            case ENTEREDINERROR:
                return org.hl7.fhir.r5.model.MedicationUsage.MedicationUsageStatusCodes.ENTEREDINERROR;
            case INTENDED:
                return org.hl7.fhir.r5.model.MedicationUsage.MedicationUsageStatusCodes.INTENDED;
            case STOPPED:
                return org.hl7.fhir.r5.model.MedicationUsage.MedicationUsageStatusCodes.STOPPED;
            case ONHOLD:
                return org.hl7.fhir.r5.model.MedicationUsage.MedicationUsageStatusCodes.ONHOLD;
            default:
                return org.hl7.fhir.r5.model.MedicationUsage.MedicationUsageStatusCodes.NULL;
        }
    }
}
