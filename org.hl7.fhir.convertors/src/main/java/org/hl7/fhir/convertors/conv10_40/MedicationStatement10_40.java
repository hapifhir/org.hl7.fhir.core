package org.hl7.fhir.convertors.conv10_40;

import org.hl7.fhir.convertors.VersionConvertor_10_40;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.Dosage.DosageDoseAndRateComponent;

public class MedicationStatement10_40 {

    public static org.hl7.fhir.dstu2.model.MedicationStatement convertMedicationStatement(org.hl7.fhir.r4.model.MedicationStatement src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.MedicationStatement tgt = new org.hl7.fhir.dstu2.model.MedicationStatement();
        VersionConvertor_10_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_40.convertIdentifier(t));
        tgt.setStatus(convertMedicationStatementStatus(src.getStatus()));
        tgt.setMedication(VersionConvertor_10_40.convertType(src.getMedication()));
        tgt.setPatient(VersionConvertor_10_40.convertReference(src.getSubject()));
        tgt.setEffective(VersionConvertor_10_40.convertType(src.getEffective()));
        tgt.setInformationSource(VersionConvertor_10_40.convertReference(src.getInformationSource()));
        for (org.hl7.fhir.r4.model.Reference t : src.getDerivedFrom()) tgt.addSupportingInformation(VersionConvertor_10_40.convertReference(t));
        if (src.hasDateAsserted())
            tgt.setDateAsserted(src.getDateAsserted());
        for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.setNote(t.getText());
        for (org.hl7.fhir.r4.model.Dosage t : src.getDosage()) tgt.addDosage(convertMedicationStatementDosageComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.MedicationStatement convertMedicationStatement(org.hl7.fhir.dstu2.model.MedicationStatement src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.MedicationStatement tgt = new org.hl7.fhir.r4.model.MedicationStatement();
        VersionConvertor_10_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_40.convertIdentifier(t));
        tgt.setStatus(convertMedicationStatementStatus(src.getStatus()));
        tgt.setMedication(VersionConvertor_10_40.convertType(src.getMedication()));
        tgt.setSubject(VersionConvertor_10_40.convertReference(src.getPatient()));
        tgt.setEffective(VersionConvertor_10_40.convertType(src.getEffective()));
        tgt.setInformationSource(VersionConvertor_10_40.convertReference(src.getInformationSource()));
        for (org.hl7.fhir.dstu2.model.Reference t : src.getSupportingInformation()) tgt.addDerivedFrom(VersionConvertor_10_40.convertReference(t));
        if (src.hasDateAsserted())
            tgt.setDateAsserted(src.getDateAsserted());
        if (src.hasNote())
            tgt.addNote().setText(src.getNote());
        for (org.hl7.fhir.dstu2.model.MedicationStatement.MedicationStatementDosageComponent t : src.getDosage()) tgt.addDosage(convertMedicationStatementDosageComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Dosage convertMedicationStatementDosageComponent(org.hl7.fhir.dstu2.model.MedicationStatement.MedicationStatementDosageComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Dosage tgt = new org.hl7.fhir.r4.model.Dosage();
        VersionConvertor_10_40.copyElement(src, tgt);
        tgt.setText(src.getText());
        tgt.setTiming(VersionConvertor_10_40.convertTiming(src.getTiming()));
        tgt.setAsNeeded(VersionConvertor_10_40.convertType(src.getAsNeeded()));
        if (src.hasSiteCodeableConcept())
            tgt.setSite(VersionConvertor_10_40.convertCodeableConcept(src.getSiteCodeableConcept()));
        tgt.setRoute(VersionConvertor_10_40.convertCodeableConcept(src.getRoute()));
        tgt.setMethod(VersionConvertor_10_40.convertCodeableConcept(src.getMethod()));
        if (src.hasRate()) {
            DosageDoseAndRateComponent dr = tgt.addDoseAndRate();
            if (src.hasRate())
                dr.setRate(VersionConvertor_10_40.convertType(src.getRate()));
        }
        tgt.setMaxDosePerPeriod(VersionConvertor_10_40.convertRatio(src.getMaxDosePerPeriod()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.MedicationStatement.MedicationStatementDosageComponent convertMedicationStatementDosageComponent(org.hl7.fhir.r4.model.Dosage src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.MedicationStatement.MedicationStatementDosageComponent tgt = new org.hl7.fhir.dstu2.model.MedicationStatement.MedicationStatementDosageComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        tgt.setText(src.getText());
        tgt.setTiming(VersionConvertor_10_40.convertTiming(src.getTiming()));
        tgt.setAsNeeded(VersionConvertor_10_40.convertType(src.getAsNeeded()));
        tgt.setSite(VersionConvertor_10_40.convertType(src.getSite()));
        tgt.setRoute(VersionConvertor_10_40.convertCodeableConcept(src.getRoute()));
        tgt.setMethod(VersionConvertor_10_40.convertCodeableConcept(src.getMethod()));
        if (src.hasDoseAndRate() && src.getDoseAndRate().get(0).hasRate())
            tgt.setRate(VersionConvertor_10_40.convertType(src.getDoseAndRate().get(0).getRate()));
        tgt.setMaxDosePerPeriod(VersionConvertor_10_40.convertRatio(src.getMaxDosePerPeriod()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus convertMedicationStatementStatus(org.hl7.fhir.dstu2.model.MedicationStatement.MedicationStatementStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case ACTIVE:
                return org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus.ACTIVE;
            case COMPLETED:
                return org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus.COMPLETED;
            case ENTEREDINERROR:
                return org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus.ENTEREDINERROR;
            case INTENDED:
                return org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus.INTENDED;
            default:
                return org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.MedicationStatement.MedicationStatementStatus convertMedicationStatementStatus(org.hl7.fhir.r4.model.MedicationStatement.MedicationStatementStatus src) throws FHIRException {
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
