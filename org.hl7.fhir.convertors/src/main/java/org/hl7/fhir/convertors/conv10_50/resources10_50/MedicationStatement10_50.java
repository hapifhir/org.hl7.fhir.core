package org.hl7.fhir.convertors.conv10_50.resources10_50;

import org.hl7.fhir.convertors.VersionConvertor_10_50;
import org.hl7.fhir.convertors.VersionConvertor_30_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.Dosage.DosageDoseAndRateComponent;

public class MedicationStatement10_50 {

    public static org.hl7.fhir.dstu2.model.MedicationStatement convertMedicationStatement(org.hl7.fhir.r5.model.MedicationUsage src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.MedicationStatement tgt = new org.hl7.fhir.dstu2.model.MedicationStatement();
        VersionConvertor_10_50.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_50.convertIdentifier(t));
        if (src.hasStatus())
            tgt.setStatusElement(convertMedicationStatementStatus(src.getStatusElement()));
        if (src.getMedication().hasConcept()) {
          tgt.setMedication(VersionConvertor_10_50.convertType(src.getMedication().getConcept()));
        }
        if (src.getMedication().hasReference()) {
          tgt.setMedication(VersionConvertor_10_50.convertType(src.getMedication().getReference()));
        }
        if (src.hasSubject())
            tgt.setPatient(VersionConvertor_10_50.convertReference(src.getSubject()));
        if (src.hasEffective())
            tgt.setEffective(VersionConvertor_10_50.convertType(src.getEffective()));
        if (src.hasInformationSource())
            tgt.setInformationSource(VersionConvertor_10_50.convertReference(src.getInformationSource()));
        for (org.hl7.fhir.r5.model.Reference t : src.getDerivedFrom()) tgt.addSupportingInformation(VersionConvertor_10_50.convertReference(t));
        if (src.hasDateAsserted())
            tgt.setDateAssertedElement(VersionConvertor_10_50.convertDateTime(src.getDateAssertedElement()));
        for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.setNote(t.getText());
        for (org.hl7.fhir.r5.model.Dosage t : src.getDosage()) tgt.addDosage(convertMedicationStatementDosageComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.MedicationUsage convertMedicationStatement(org.hl7.fhir.dstu2.model.MedicationStatement src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.MedicationUsage tgt = new org.hl7.fhir.r5.model.MedicationUsage();
        VersionConvertor_10_50.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_50.convertIdentifier(t));
        if (src.hasStatus())
            tgt.setStatusElement(convertMedicationStatementStatus(src.getStatusElement()));
        if (src.hasMedicationCodeableConcept()) {
          tgt.getMedication().setConcept(VersionConvertor_10_50.convertCodeableConcept(src.getMedicationCodeableConcept()));
        }
        if (src.hasMedicationReference()) {
          tgt.getMedication().setReference(VersionConvertor_10_50.convertReference(src.getMedicationReference()));
        }
        if (src.hasPatient())
            tgt.setSubject(VersionConvertor_10_50.convertReference(src.getPatient()));
        if (src.hasEffective())
            tgt.setEffective(VersionConvertor_10_50.convertType(src.getEffective()));
        if (src.hasInformationSource())
            tgt.setInformationSource(VersionConvertor_10_50.convertReference(src.getInformationSource()));
        for (org.hl7.fhir.dstu2.model.Reference t : src.getSupportingInformation()) tgt.addDerivedFrom(VersionConvertor_10_50.convertReference(t));
        if (src.hasDateAsserted())
            tgt.setDateAssertedElement(VersionConvertor_10_50.convertDateTime(src.getDateAssertedElement()));
        if (src.hasNote())
            tgt.addNote().setText(src.getNote());
        for (org.hl7.fhir.dstu2.model.MedicationStatement.MedicationStatementDosageComponent t : src.getDosage()) tgt.addDosage(convertMedicationStatementDosageComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Dosage convertMedicationStatementDosageComponent(org.hl7.fhir.dstu2.model.MedicationStatement.MedicationStatementDosageComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Dosage tgt = new org.hl7.fhir.r5.model.Dosage();
        VersionConvertor_10_50.copyElement(src, tgt);
        if (src.hasTextElement())
            tgt.setTextElement(VersionConvertor_10_50.convertString(src.getTextElement()));
        if (src.hasTiming())
            tgt.setTiming(VersionConvertor_10_50.convertTiming(src.getTiming()));
        if (src.hasAsNeeded())
            tgt.setAsNeeded(VersionConvertor_10_50.convertType(src.getAsNeeded()));
        if (src.hasSiteCodeableConcept())
            tgt.setSite(VersionConvertor_10_50.convertCodeableConcept(src.getSiteCodeableConcept()));
        if (src.hasRoute())
            tgt.setRoute(VersionConvertor_10_50.convertCodeableConcept(src.getRoute()));
        if (src.hasMethod())
            tgt.setMethod(VersionConvertor_10_50.convertCodeableConcept(src.getMethod()));
        if (src.hasRate()) {
            DosageDoseAndRateComponent dr = tgt.addDoseAndRate();
            if (src.hasRate())
                dr.setRate(VersionConvertor_10_50.convertType(src.getRate()));
        }
        if (src.hasMaxDosePerPeriod())
            tgt.setMaxDosePerPeriod(VersionConvertor_10_50.convertRatio(src.getMaxDosePerPeriod()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.MedicationStatement.MedicationStatementDosageComponent convertMedicationStatementDosageComponent(org.hl7.fhir.r5.model.Dosage src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.MedicationStatement.MedicationStatementDosageComponent tgt = new org.hl7.fhir.dstu2.model.MedicationStatement.MedicationStatementDosageComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        if (src.hasTextElement())
            tgt.setTextElement(VersionConvertor_10_50.convertString(src.getTextElement()));
        if (src.hasTiming())
            tgt.setTiming(VersionConvertor_10_50.convertTiming(src.getTiming()));
        if (src.hasAsNeeded())
            tgt.setAsNeeded(VersionConvertor_10_50.convertType(src.getAsNeeded()));
        if (src.hasSite())
            tgt.setSite(VersionConvertor_10_50.convertType(src.getSite()));
        if (src.hasRoute())
            tgt.setRoute(VersionConvertor_10_50.convertCodeableConcept(src.getRoute()));
        if (src.hasMethod())
            tgt.setMethod(VersionConvertor_10_50.convertCodeableConcept(src.getMethod()));
        if (src.hasDoseAndRate() && src.getDoseAndRate().get(0).hasRate())
            tgt.setRate(VersionConvertor_10_50.convertType(src.getDoseAndRate().get(0).getRate()));
        if (src.hasMaxDosePerPeriod())
            tgt.setMaxDosePerPeriod(VersionConvertor_10_50.convertRatio(src.getMaxDosePerPeriod()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MedicationUsage.MedicationUsageStatusCodes> convertMedicationStatementStatus(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.MedicationStatement.MedicationStatementStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MedicationUsage.MedicationUsageStatusCodes> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.MedicationUsage.MedicationUsageStatusCodesEnumFactory());
        VersionConvertor_10_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case ACTIVE:
                tgt.setValue(org.hl7.fhir.r5.model.MedicationUsage.MedicationUsageStatusCodes.COMPLETED);
                break;
            case COMPLETED:
                tgt.setValue(org.hl7.fhir.r5.model.MedicationUsage.MedicationUsageStatusCodes.COMPLETED);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.r5.model.MedicationUsage.MedicationUsageStatusCodes.ENTEREDINERROR);
                break;
            case INTENDED:
                tgt.setValue(org.hl7.fhir.r5.model.MedicationUsage.MedicationUsageStatusCodes.UNKNOWN);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.MedicationUsage.MedicationUsageStatusCodes.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.MedicationStatement.MedicationStatementStatus> convertMedicationStatementStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MedicationUsage.MedicationUsageStatusCodes> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.MedicationStatement.MedicationStatementStatus> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.MedicationStatement.MedicationStatementStatusEnumFactory());
        VersionConvertor_10_50.copyElement(src, tgt);
        switch(src.getValue()) {
//            case ACTIVE:
//                tgt.setValue(org.hl7.fhir.dstu2.model.MedicationStatement.MedicationStatementStatus.ACTIVE);
//                break;
            case COMPLETED:
                tgt.setValue(org.hl7.fhir.dstu2.model.MedicationStatement.MedicationStatementStatus.COMPLETED);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.dstu2.model.MedicationStatement.MedicationStatementStatus.ENTEREDINERROR);
                break;
            case UNKNOWN:
                tgt.setValue(org.hl7.fhir.dstu2.model.MedicationStatement.MedicationStatementStatus.INTENDED);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2.model.MedicationStatement.MedicationStatementStatus.NULL);
                break;
        }
        return tgt;
    }
}