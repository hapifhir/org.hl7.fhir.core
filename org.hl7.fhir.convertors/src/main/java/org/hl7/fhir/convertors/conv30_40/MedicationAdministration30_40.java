package org.hl7.fhir.convertors.conv30_40;

import org.hl7.fhir.convertors.VersionConvertor_30_40;
import org.hl7.fhir.exceptions.FHIRException;

public class MedicationAdministration30_40 {

    public static org.hl7.fhir.dstu3.model.MedicationAdministration convertMedicationAdministration(org.hl7.fhir.r4.model.MedicationAdministration src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.MedicationAdministration tgt = new org.hl7.fhir.dstu3.model.MedicationAdministration();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        }
        if (src.hasInstantiates()) {
            for (org.hl7.fhir.r4.model.UriType t : src.getInstantiates()) tgt.addDefinition().setReference(t.getValue());
        }
        if (src.hasPartOf()) {
            for (org.hl7.fhir.r4.model.Reference t : src.getPartOf()) tgt.addPartOf(VersionConvertor_30_40.convertReference(t));
        }
        if (src.hasStatus())
            tgt.setStatus(convertMedicationAdministrationStatus(src.getStatus()));
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
        if (src.hasEffective())
            tgt.setEffective(VersionConvertor_30_40.convertType(src.getEffective()));
        if (src.hasPerformer()) {
            for (org.hl7.fhir.r4.model.MedicationAdministration.MedicationAdministrationPerformerComponent t : src.getPerformer()) tgt.addPerformer(convertMedicationAdministrationPerformerComponent(t));
        }
        if (src.hasReasonCode()) {
            for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReasonCode()) tgt.addReasonCode(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        if (src.hasReasonReference()) {
            for (org.hl7.fhir.r4.model.Reference t : src.getReasonReference()) tgt.addReasonReference(VersionConvertor_30_40.convertReference(t));
        }
        if (src.hasRequest())
            tgt.setPrescription(VersionConvertor_30_40.convertReference(src.getRequest()));
        if (src.hasDevice()) {
            for (org.hl7.fhir.r4.model.Reference t : src.getDevice()) tgt.addDevice(VersionConvertor_30_40.convertReference(t));
        }
        if (src.hasNote()) {
            for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.addNote(VersionConvertor_30_40.convertAnnotation(t));
        }
        if (src.hasDosage())
            tgt.setDosage(convertMedicationAdministrationDosageComponent(src.getDosage()));
        if (src.hasEventHistory()) {
            for (org.hl7.fhir.r4.model.Reference t : src.getEventHistory()) tgt.addEventHistory(VersionConvertor_30_40.convertReference(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.MedicationAdministration convertMedicationAdministration(org.hl7.fhir.dstu3.model.MedicationAdministration src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.MedicationAdministration tgt = new org.hl7.fhir.r4.model.MedicationAdministration();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        }
        if (src.hasDefinition()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getDefinition()) tgt.addInstantiates(t.getReference());
        }
        if (src.hasPartOf()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getPartOf()) tgt.addPartOf(VersionConvertor_30_40.convertReference(t));
        }
        if (src.hasStatus())
            tgt.setStatus(convertMedicationAdministrationStatus(src.getStatus()));
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
        if (src.hasEffective())
            tgt.setEffective(VersionConvertor_30_40.convertType(src.getEffective()));
        if (src.hasPerformer()) {
            for (org.hl7.fhir.dstu3.model.MedicationAdministration.MedicationAdministrationPerformerComponent t : src.getPerformer()) tgt.addPerformer(convertMedicationAdministrationPerformerComponent(t));
        }
        if (src.hasReasonCode()) {
            for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getReasonCode()) tgt.addReasonCode(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        if (src.hasReasonReference()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getReasonReference()) tgt.addReasonReference(VersionConvertor_30_40.convertReference(t));
        }
        if (src.hasPrescription())
            tgt.setRequest(VersionConvertor_30_40.convertReference(src.getPrescription()));
        if (src.hasDevice()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getDevice()) tgt.addDevice(VersionConvertor_30_40.convertReference(t));
        }
        if (src.hasNote()) {
            for (org.hl7.fhir.dstu3.model.Annotation t : src.getNote()) tgt.addNote(VersionConvertor_30_40.convertAnnotation(t));
        }
        if (src.hasDosage())
            tgt.setDosage(convertMedicationAdministrationDosageComponent(src.getDosage()));
        if (src.hasEventHistory()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getEventHistory()) tgt.addEventHistory(VersionConvertor_30_40.convertReference(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.MedicationAdministration.MedicationAdministrationDosageComponent convertMedicationAdministrationDosageComponent(org.hl7.fhir.dstu3.model.MedicationAdministration.MedicationAdministrationDosageComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.MedicationAdministration.MedicationAdministrationDosageComponent tgt = new org.hl7.fhir.r4.model.MedicationAdministration.MedicationAdministrationDosageComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasText())
            tgt.setText(src.getText());
        if (src.hasSite())
            tgt.setSite(VersionConvertor_30_40.convertCodeableConcept(src.getSite()));
        if (src.hasRoute())
            tgt.setRoute(VersionConvertor_30_40.convertCodeableConcept(src.getRoute()));
        if (src.hasMethod())
            tgt.setMethod(VersionConvertor_30_40.convertCodeableConcept(src.getMethod()));
        if (src.hasDose())
            tgt.setDose(VersionConvertor_30_40.convertSimpleQuantity(src.getDose()));
        if (src.hasRate())
            tgt.setRate(VersionConvertor_30_40.convertType(src.getRate()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.MedicationAdministration.MedicationAdministrationDosageComponent convertMedicationAdministrationDosageComponent(org.hl7.fhir.r4.model.MedicationAdministration.MedicationAdministrationDosageComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.MedicationAdministration.MedicationAdministrationDosageComponent tgt = new org.hl7.fhir.dstu3.model.MedicationAdministration.MedicationAdministrationDosageComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasText())
            tgt.setText(src.getText());
        if (src.hasSite())
            tgt.setSite(VersionConvertor_30_40.convertCodeableConcept(src.getSite()));
        if (src.hasRoute())
            tgt.setRoute(VersionConvertor_30_40.convertCodeableConcept(src.getRoute()));
        if (src.hasMethod())
            tgt.setMethod(VersionConvertor_30_40.convertCodeableConcept(src.getMethod()));
        if (src.hasDose())
            tgt.setDose(VersionConvertor_30_40.convertSimpleQuantity(src.getDose()));
        if (src.hasRate())
            tgt.setRate(VersionConvertor_30_40.convertType(src.getRate()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.MedicationAdministration.MedicationAdministrationPerformerComponent convertMedicationAdministrationPerformerComponent(org.hl7.fhir.dstu3.model.MedicationAdministration.MedicationAdministrationPerformerComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.MedicationAdministration.MedicationAdministrationPerformerComponent tgt = new org.hl7.fhir.r4.model.MedicationAdministration.MedicationAdministrationPerformerComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasActor())
            tgt.setActor(VersionConvertor_30_40.convertReference(src.getActor()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.MedicationAdministration.MedicationAdministrationPerformerComponent convertMedicationAdministrationPerformerComponent(org.hl7.fhir.r4.model.MedicationAdministration.MedicationAdministrationPerformerComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.MedicationAdministration.MedicationAdministrationPerformerComponent tgt = new org.hl7.fhir.dstu3.model.MedicationAdministration.MedicationAdministrationPerformerComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasActor())
            tgt.setActor(VersionConvertor_30_40.convertReference(src.getActor()));
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.MedicationAdministration.MedicationAdministrationStatus convertMedicationAdministrationStatus(String src) throws FHIRException {
        if (src == null)
            return null;
        return org.hl7.fhir.dstu3.model.MedicationAdministration.MedicationAdministrationStatus.fromCode(src);
    }

    static public String convertMedicationAdministrationStatus(org.hl7.fhir.dstu3.model.MedicationAdministration.MedicationAdministrationStatus src) throws FHIRException {
        if (src == null)
            return null;
        return src.toCode();
    }
}
