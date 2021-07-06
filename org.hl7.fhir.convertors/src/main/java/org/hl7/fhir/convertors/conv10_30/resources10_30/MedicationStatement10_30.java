package org.hl7.fhir.convertors.conv10_30.resources10_30;

import org.hl7.fhir.convertors.conv10_30.VersionConvertor_10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.Element10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.Type10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.CodeableConcept10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.Identifier10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.Ratio10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.Timing10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.DateTime10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.String10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.Reference10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class MedicationStatement10_30 {

    public static org.hl7.fhir.dstu3.model.MedicationStatement convertMedicationStatement(org.hl7.fhir.dstu2.model.MedicationStatement src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.MedicationStatement tgt = new org.hl7.fhir.dstu3.model.MedicationStatement();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(Identifier10_30.convertIdentifier(t));
        if (src.hasStatus())
            tgt.setStatusElement(convertMedicationStatementStatus(src.getStatusElement()));
        if (src.hasMedication())
            tgt.setMedication(Type10_30.convertType(src.getMedication()));
        if (src.hasPatient())
            tgt.setSubject(Reference10_30.convertReference(src.getPatient()));
        if (src.hasEffective())
            tgt.setEffective(Type10_30.convertType(src.getEffective()));
        if (src.hasInformationSource())
            tgt.setInformationSource(Reference10_30.convertReference(src.getInformationSource()));
        for (org.hl7.fhir.dstu2.model.Reference t : src.getSupportingInformation()) tgt.addDerivedFrom(Reference10_30.convertReference(t));
        if (src.hasDateAsserted())
            tgt.setDateAssertedElement(DateTime10_30.convertDateTime(src.getDateAssertedElement()));
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getReasonNotTaken()) tgt.addReasonNotTaken(CodeableConcept10_30.convertCodeableConcept(t));
        if (src.hasNote())
            tgt.addNote().setText(src.getNote());
        for (org.hl7.fhir.dstu2.model.MedicationStatement.MedicationStatementDosageComponent t : src.getDosage()) tgt.addDosage(convertMedicationStatementDosageComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.MedicationStatement convertMedicationStatement(org.hl7.fhir.dstu3.model.MedicationStatement src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.MedicationStatement tgt = new org.hl7.fhir.dstu2.model.MedicationStatement();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(Identifier10_30.convertIdentifier(t));
        if (src.hasStatus())
            tgt.setStatusElement(convertMedicationStatementStatus(src.getStatusElement()));
        if (src.hasMedication())
            tgt.setMedication(Type10_30.convertType(src.getMedication()));
        if (src.hasSubject())
            tgt.setPatient(Reference10_30.convertReference(src.getSubject()));
        if (src.hasEffective())
            tgt.setEffective(Type10_30.convertType(src.getEffective()));
        if (src.hasInformationSource())
            tgt.setInformationSource(Reference10_30.convertReference(src.getInformationSource()));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getDerivedFrom()) tgt.addSupportingInformation(Reference10_30.convertReference(t));
        if (src.hasDateAsserted())
            tgt.setDateAssertedElement(DateTime10_30.convertDateTime(src.getDateAssertedElement()));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getReasonNotTaken()) tgt.addReasonNotTaken(CodeableConcept10_30.convertCodeableConcept(t));
        for (org.hl7.fhir.dstu3.model.Annotation t : src.getNote()) tgt.setNote(t.getText());
        for (org.hl7.fhir.dstu3.model.Dosage t : src.getDosage()) tgt.addDosage(convertMedicationStatementDosageComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Dosage convertMedicationStatementDosageComponent(org.hl7.fhir.dstu2.model.MedicationStatement.MedicationStatementDosageComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Dosage tgt = new org.hl7.fhir.dstu3.model.Dosage();
        Element10_30.copyElement(src, tgt);
        if (src.hasTextElement())
            tgt.setTextElement(String10_30.convertString(src.getTextElement()));
        if (src.hasTiming())
            tgt.setTiming(Timing10_30.convertTiming(src.getTiming()));
        if (src.hasAsNeeded())
            tgt.setAsNeeded(Type10_30.convertType(src.getAsNeeded()));
        if (src.hasSiteCodeableConcept())
            tgt.setSite(CodeableConcept10_30.convertCodeableConcept(src.getSiteCodeableConcept()));
        if (src.hasRoute())
            tgt.setRoute(CodeableConcept10_30.convertCodeableConcept(src.getRoute()));
        if (src.hasMethod())
            tgt.setMethod(CodeableConcept10_30.convertCodeableConcept(src.getMethod()));
        if (src.hasRate())
            tgt.setRate(Type10_30.convertType(src.getRate()));
        if (src.hasMaxDosePerPeriod())
            tgt.setMaxDosePerPeriod(Ratio10_30.convertRatio(src.getMaxDosePerPeriod()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.MedicationStatement.MedicationStatementDosageComponent convertMedicationStatementDosageComponent(org.hl7.fhir.dstu3.model.Dosage src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.MedicationStatement.MedicationStatementDosageComponent tgt = new org.hl7.fhir.dstu2.model.MedicationStatement.MedicationStatementDosageComponent();
        Element10_30.copyElement(src, tgt);
        if (src.hasTextElement())
            tgt.setTextElement(String10_30.convertString(src.getTextElement()));
        if (src.hasTiming())
            tgt.setTiming(Timing10_30.convertTiming(src.getTiming()));
        if (src.hasAsNeeded())
            tgt.setAsNeeded(Type10_30.convertType(src.getAsNeeded()));
        if (src.hasSite())
            tgt.setSite(Type10_30.convertType(src.getSite()));
        if (src.hasRoute())
            tgt.setRoute(CodeableConcept10_30.convertCodeableConcept(src.getRoute()));
        if (src.hasMethod())
            tgt.setMethod(CodeableConcept10_30.convertCodeableConcept(src.getMethod()));
        if (src.hasRate())
            tgt.setRate(Type10_30.convertType(src.getRate()));
        if (src.hasMaxDosePerPeriod())
            tgt.setMaxDosePerPeriod(Ratio10_30.convertRatio(src.getMaxDosePerPeriod()));
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.MedicationStatement.MedicationStatementStatus> convertMedicationStatementStatus(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.MedicationStatement.MedicationStatementStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.MedicationStatement.MedicationStatementStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.MedicationStatement.MedicationStatementStatusEnumFactory());
        Element10_30.copyElement(src, tgt);
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
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.MedicationStatement.MedicationStatementStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.MedicationStatement.MedicationStatementStatus> convertMedicationStatementStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.MedicationStatement.MedicationStatementStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.MedicationStatement.MedicationStatementStatus> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.MedicationStatement.MedicationStatementStatusEnumFactory());
        Element10_30.copyElement(src, tgt);
        switch(src.getValue()) {
            case ACTIVE:
                tgt.setValue(org.hl7.fhir.dstu2.model.MedicationStatement.MedicationStatementStatus.ACTIVE);
                break;
            case COMPLETED:
                tgt.setValue(org.hl7.fhir.dstu2.model.MedicationStatement.MedicationStatementStatus.COMPLETED);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.dstu2.model.MedicationStatement.MedicationStatementStatus.ENTEREDINERROR);
                break;
            case INTENDED:
                tgt.setValue(org.hl7.fhir.dstu2.model.MedicationStatement.MedicationStatementStatus.INTENDED);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2.model.MedicationStatement.MedicationStatementStatus.NULL);
                break;
        }
        return tgt;
    }
}