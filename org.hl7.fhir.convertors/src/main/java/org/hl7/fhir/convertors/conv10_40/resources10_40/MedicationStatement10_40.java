package org.hl7.fhir.convertors.conv10_40.resources10_40;

import org.hl7.fhir.convertors.conv10_40.VersionConvertor_10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.Element10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.Type10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.CodeableConcept10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.Identifier10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.Ratio10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.Timing10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.DateTime10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.String10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.Reference10_40;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.Dosage.DosageDoseAndRateComponent;

public class MedicationStatement10_40 {

    public static org.hl7.fhir.dstu2.model.MedicationStatement convertMedicationStatement(org.hl7.fhir.r4.model.MedicationStatement src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.MedicationStatement tgt = new org.hl7.fhir.dstu2.model.MedicationStatement();
        VersionConvertor_10_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(Identifier10_40.convertIdentifier(t));
        if (src.hasStatus())
            tgt.setStatusElement(convertMedicationStatementStatus(src.getStatusElement()));
        if (src.hasMedication())
            tgt.setMedication(Type10_40.convertType(src.getMedication()));
        if (src.hasSubject())
            tgt.setPatient(Reference10_40.convertReference(src.getSubject()));
        if (src.hasEffective())
            tgt.setEffective(Type10_40.convertType(src.getEffective()));
        if (src.hasInformationSource())
            tgt.setInformationSource(Reference10_40.convertReference(src.getInformationSource()));
        for (org.hl7.fhir.r4.model.Reference t : src.getDerivedFrom()) tgt.addSupportingInformation(Reference10_40.convertReference(t));
        if (src.hasDateAsserted())
            tgt.setDateAssertedElement(DateTime10_40.convertDateTime(src.getDateAssertedElement()));
        for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.setNote(t.getText());
        for (org.hl7.fhir.r4.model.Dosage t : src.getDosage()) tgt.addDosage(convertMedicationStatementDosageComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.MedicationStatement convertMedicationStatement(org.hl7.fhir.dstu2.model.MedicationStatement src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.MedicationStatement tgt = new org.hl7.fhir.r4.model.MedicationStatement();
        VersionConvertor_10_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(Identifier10_40.convertIdentifier(t));
        if (src.hasStatus())
            tgt.setStatusElement(convertMedicationStatementStatus(src.getStatusElement()));
        if (src.hasMedication())
            tgt.setMedication(Type10_40.convertType(src.getMedication()));
        if (src.hasPatient())
            tgt.setSubject(Reference10_40.convertReference(src.getPatient()));
        if (src.hasEffective())
            tgt.setEffective(Type10_40.convertType(src.getEffective()));
        if (src.hasInformationSource())
            tgt.setInformationSource(Reference10_40.convertReference(src.getInformationSource()));
        for (org.hl7.fhir.dstu2.model.Reference t : src.getSupportingInformation()) tgt.addDerivedFrom(Reference10_40.convertReference(t));
        if (src.hasDateAsserted())
            tgt.setDateAssertedElement(DateTime10_40.convertDateTime(src.getDateAssertedElement()));
        if (src.hasNote())
            tgt.addNote().setText(src.getNote());
        for (org.hl7.fhir.dstu2.model.MedicationStatement.MedicationStatementDosageComponent t : src.getDosage()) tgt.addDosage(convertMedicationStatementDosageComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Dosage convertMedicationStatementDosageComponent(org.hl7.fhir.dstu2.model.MedicationStatement.MedicationStatementDosageComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Dosage tgt = new org.hl7.fhir.r4.model.Dosage();
        Element10_40.copyElement(src, tgt);
        if (src.hasTextElement())
            tgt.setTextElement(String10_40.convertString(src.getTextElement()));
        if (src.hasTiming())
            tgt.setTiming(Timing10_40.convertTiming(src.getTiming()));
        if (src.hasAsNeeded())
            tgt.setAsNeeded(Type10_40.convertType(src.getAsNeeded()));
        if (src.hasSiteCodeableConcept())
            tgt.setSite(CodeableConcept10_40.convertCodeableConcept(src.getSiteCodeableConcept()));
        if (src.hasRoute())
            tgt.setRoute(CodeableConcept10_40.convertCodeableConcept(src.getRoute()));
        if (src.hasMethod())
            tgt.setMethod(CodeableConcept10_40.convertCodeableConcept(src.getMethod()));
        if (src.hasRate()) {
            DosageDoseAndRateComponent dr = tgt.addDoseAndRate();
            if (src.hasRate())
                dr.setRate(Type10_40.convertType(src.getRate()));
        }
        if (src.hasMaxDosePerPeriod())
            tgt.setMaxDosePerPeriod(Ratio10_40.convertRatio(src.getMaxDosePerPeriod()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.MedicationStatement.MedicationStatementDosageComponent convertMedicationStatementDosageComponent(org.hl7.fhir.r4.model.Dosage src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.MedicationStatement.MedicationStatementDosageComponent tgt = new org.hl7.fhir.dstu2.model.MedicationStatement.MedicationStatementDosageComponent();
        Element10_40.copyElement(src, tgt);
        if (src.hasTextElement())
            tgt.setTextElement(String10_40.convertString(src.getTextElement()));
        if (src.hasTiming())
            tgt.setTiming(Timing10_40.convertTiming(src.getTiming()));
        if (src.hasAsNeeded())
            tgt.setAsNeeded(Type10_40.convertType(src.getAsNeeded()));
        if (src.hasSite())
            tgt.setSite(Type10_40.convertType(src.getSite()));
        if (src.hasRoute())
            tgt.setRoute(CodeableConcept10_40.convertCodeableConcept(src.getRoute()));
        if (src.hasMethod())
            tgt.setMethod(CodeableConcept10_40.convertCodeableConcept(src.getMethod()));
        if (src.hasDoseAndRate() && src.getDoseAndRate().get(0).hasRate())
            tgt.setRate(Type10_40.convertType(src.getDoseAndRate().get(0).getRate()));
        if (src.hasMaxDosePerPeriod())
            tgt.setMaxDosePerPeriod(Ratio10_40.convertRatio(src.getMaxDosePerPeriod()));
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus> convertMedicationStatementStatus(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.MedicationStatement.MedicationStatementStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatusEnumFactory());
        Element10_40.copyElement(src, tgt);
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
            default:
                tgt.setValue(org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.MedicationStatement.MedicationStatementStatus> convertMedicationStatementStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.MedicationStatement.MedicationStatementStatus> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.MedicationStatement.MedicationStatementStatusEnumFactory());
        Element10_40.copyElement(src, tgt);
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