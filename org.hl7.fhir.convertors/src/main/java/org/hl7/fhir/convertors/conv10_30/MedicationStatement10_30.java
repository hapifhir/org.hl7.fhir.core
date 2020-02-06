package org.hl7.fhir.convertors.conv10_30;

import org.hl7.fhir.convertors.VersionConvertor_10_30;
import org.hl7.fhir.dstu3.model.StringType;
import org.hl7.fhir.exceptions.FHIRException;
import java.util.Collections;

public class MedicationStatement10_30 {

    public static org.hl7.fhir.dstu3.model.MedicationStatement convertMedicationStatement(org.hl7.fhir.dstu2.model.MedicationStatement src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.MedicationStatement tgt = new org.hl7.fhir.dstu3.model.MedicationStatement();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_30.convertIdentifier(t));
        }
        if (src.hasStatus()) {
            tgt.setStatus(convertMedicationStatementStatus(src.getStatus()));
        }
        if (src.hasMedication()) {
            tgt.setMedication(VersionConvertor_10_30.convertType(src.getMedication()));
        }
        if (src.hasPatient()) {
            tgt.setSubject(VersionConvertor_10_30.convertReference(src.getPatient()));
        }
        if (src.hasEffective()) {
            tgt.setEffective(VersionConvertor_10_30.convertType(src.getEffective()));
        }
        if (src.hasInformationSource()) {
            tgt.setInformationSource(VersionConvertor_10_30.convertReference(src.getInformationSource()));
        }
        if (src.hasSupportingInformation()) {
            for (org.hl7.fhir.dstu2.model.Reference t : src.getSupportingInformation()) tgt.addDerivedFrom(VersionConvertor_10_30.convertReference(t));
        }
        if (src.hasDateAssertedElement())
            tgt.setDateAssertedElement((org.hl7.fhir.dstu3.model.DateTimeType) VersionConvertor_10_30.convertType(src.getDateAssertedElement()));
        if (src.hasReasonNotTaken()) {
            for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getReasonNotTaken()) tgt.addReasonNotTaken(VersionConvertor_10_30.convertCodeableConcept(t));
        }
        if (src.hasNoteElement())
            tgt.setNote(Collections.singletonList((org.hl7.fhir.dstu3.model.Annotation) VersionConvertor_10_30.convertType(src.getNoteElement())));
        if (src.hasDosage()) {
            for (org.hl7.fhir.dstu2.model.MedicationStatement.MedicationStatementDosageComponent t : src.getDosage()) tgt.addDosage(convertMedicationStatementDosageComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.MedicationStatement convertMedicationStatement(org.hl7.fhir.dstu3.model.MedicationStatement src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.MedicationStatement tgt = new org.hl7.fhir.dstu2.model.MedicationStatement();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_30.convertIdentifier(t));
        }
        if (src.hasStatus()) {
            tgt.setStatus(convertMedicationStatementStatus(src.getStatus()));
        }
        if (src.hasMedication()) {
            tgt.setMedication(VersionConvertor_10_30.convertType(src.getMedication()));
        }
        if (src.hasSubject()) {
            tgt.setPatient(VersionConvertor_10_30.convertReference(src.getSubject()));
        }
        if (src.hasEffective()) {
            tgt.setEffective(VersionConvertor_10_30.convertType(src.getEffective()));
        }
        if (src.hasInformationSource()) {
            tgt.setInformationSource(VersionConvertor_10_30.convertReference(src.getInformationSource()));
        }
        if (src.hasDerivedFrom()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getDerivedFrom()) tgt.addSupportingInformation(VersionConvertor_10_30.convertReference(t));
        }
        if (src.hasDateAssertedElement())
            tgt.setDateAssertedElement((org.hl7.fhir.dstu2.model.DateTimeType) VersionConvertor_10_30.convertType(src.getDateAssertedElement()));
        if (src.hasReasonNotTaken()) {
            for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getReasonNotTaken()) tgt.addReasonNotTaken(VersionConvertor_10_30.convertCodeableConcept(t));
        }
        if (src.hasNote()) {
            for (org.hl7.fhir.dstu3.model.Annotation t : src.getNote()) tgt.setNote(t.getText());
        }
        if (src.hasDosage()) {
            for (org.hl7.fhir.dstu3.model.Dosage t : src.getDosage()) tgt.addDosage(convertMedicationStatementDosageComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Dosage convertMedicationStatementDosageComponent(org.hl7.fhir.dstu2.model.MedicationStatement.MedicationStatementDosageComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Dosage tgt = new org.hl7.fhir.dstu3.model.Dosage();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasTextElement()) {
            tgt.setTextElement((StringType) VersionConvertor_10_30.convertType(src.getTextElement()));
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
        if (src.hasRate()) {
            tgt.setRate(VersionConvertor_10_30.convertType(src.getRate()));
        }
        if (src.hasMaxDosePerPeriod()) {
            tgt.setMaxDosePerPeriod(VersionConvertor_10_30.convertRatio(src.getMaxDosePerPeriod()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.MedicationStatement.MedicationStatementDosageComponent convertMedicationStatementDosageComponent(org.hl7.fhir.dstu3.model.Dosage src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.MedicationStatement.MedicationStatementDosageComponent tgt = new org.hl7.fhir.dstu2.model.MedicationStatement.MedicationStatementDosageComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasTextElement()) {
            tgt.setTextElement((org.hl7.fhir.dstu2.model.StringType) VersionConvertor_10_30.convertType(src.getTextElement()));
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
        if (src.hasRate()) {
            tgt.setRate(VersionConvertor_10_30.convertType(src.getRate()));
        }
        if (src.hasMaxDosePerPeriod()) {
            tgt.setMaxDosePerPeriod(VersionConvertor_10_30.convertRatio(src.getMaxDosePerPeriod()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.MedicationStatement.MedicationStatementStatus convertMedicationStatementStatus(org.hl7.fhir.dstu2.model.MedicationStatement.MedicationStatementStatus src) throws FHIRException {
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
            default:
                return org.hl7.fhir.dstu3.model.MedicationStatement.MedicationStatementStatus.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.MedicationStatement.MedicationStatementStatus convertMedicationStatementStatus(org.hl7.fhir.dstu3.model.MedicationStatement.MedicationStatementStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case ACTIVE:
                return org.hl7.fhir.dstu2.model.MedicationStatement.MedicationStatementStatus.ACTIVE;
            case COMPLETED:
                return org.hl7.fhir.dstu2.model.MedicationStatement.MedicationStatementStatus.COMPLETED;
            case ENTEREDINERROR:
                return org.hl7.fhir.dstu2.model.MedicationStatement.MedicationStatementStatus.ENTEREDINERROR;
            case INTENDED:
                return org.hl7.fhir.dstu2.model.MedicationStatement.MedicationStatementStatus.INTENDED;
            default:
                return org.hl7.fhir.dstu2.model.MedicationStatement.MedicationStatementStatus.NULL;
        }
    }
}
