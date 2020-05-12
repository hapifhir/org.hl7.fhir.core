package org.hl7.fhir.convertors.conv30_50;

import org.hl7.fhir.convertors.VersionConvertor_30_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CodeableReference;
import org.hl7.fhir.r5.model.MedicationAdministration.MedicationAdministrationStatusCodesEnumFactory;

public class MedicationAdministration30_50 {

    public static org.hl7.fhir.dstu3.model.MedicationAdministration convertMedicationAdministration(org.hl7.fhir.r5.model.MedicationAdministration src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.MedicationAdministration tgt = new org.hl7.fhir.dstu3.model.MedicationAdministration();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(t));
        for (org.hl7.fhir.r5.model.UriType t : src.getInstantiatesUri()) tgt.addDefinition().setReference(t.getValue());
        for (org.hl7.fhir.r5.model.Reference t : src.getPartOf()) tgt.addPartOf(VersionConvertor_30_50.convertReference(t));
        if (src.hasStatus())
            tgt.setStatusElement(convertMedicationAdministrationStatus(src.getStatusElement()));
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
        if (src.hasOccurence())
            tgt.setEffective(VersionConvertor_30_50.convertType(src.getOccurence()));
        for (org.hl7.fhir.r5.model.MedicationAdministration.MedicationAdministrationPerformerComponent t : src.getPerformer()) tgt.addPerformer(convertMedicationAdministrationPerformerComponent(t));
        for (CodeableReference t : src.getReason()) if (t.hasConcept())
            tgt.addReasonCode(VersionConvertor_30_50.convertCodeableConcept(t.getConcept()));
        for (CodeableReference t : src.getReason()) if (t.hasReference())
            tgt.addReasonReference(VersionConvertor_30_50.convertReference(t.getReference()));
        if (src.hasRequest())
            tgt.setPrescription(VersionConvertor_30_50.convertReference(src.getRequest()));
        for (org.hl7.fhir.r5.model.Reference t : src.getDevice()) tgt.addDevice(VersionConvertor_30_50.convertReference(t));
        for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.addNote(VersionConvertor_30_50.convertAnnotation(t));
        if (src.hasDosage())
            tgt.setDosage(convertMedicationAdministrationDosageComponent(src.getDosage()));
        for (org.hl7.fhir.r5.model.Reference t : src.getEventHistory()) tgt.addEventHistory(VersionConvertor_30_50.convertReference(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.MedicationAdministration convertMedicationAdministration(org.hl7.fhir.dstu3.model.MedicationAdministration src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.MedicationAdministration tgt = new org.hl7.fhir.r5.model.MedicationAdministration();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(t));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getDefinition()) tgt.addInstantiatesUri(t.getReference());
        for (org.hl7.fhir.dstu3.model.Reference t : src.getPartOf()) tgt.addPartOf(VersionConvertor_30_50.convertReference(t));
        if (src.hasStatus())
            tgt.setStatusElement(convertMedicationAdministrationStatus(src.getStatusElement()));
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
        if (src.hasEffective())
            tgt.setOccurence(VersionConvertor_30_50.convertType(src.getEffective()));
        for (org.hl7.fhir.dstu3.model.MedicationAdministration.MedicationAdministrationPerformerComponent t : src.getPerformer()) tgt.addPerformer(convertMedicationAdministrationPerformerComponent(t));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getReasonCode()) tgt.addReason(VersionConvertor_30_50.convertCodeableConceptToCodableReference(t));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getReasonReference()) tgt.addReason(VersionConvertor_30_50.convertReferenceToCodableReference(t));
        if (src.hasPrescription())
            tgt.setRequest(VersionConvertor_30_50.convertReference(src.getPrescription()));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getDevice()) tgt.addDevice(VersionConvertor_30_50.convertReference(t));
        for (org.hl7.fhir.dstu3.model.Annotation t : src.getNote()) tgt.addNote(VersionConvertor_30_50.convertAnnotation(t));
        if (src.hasDosage())
            tgt.setDosage(convertMedicationAdministrationDosageComponent(src.getDosage()));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getEventHistory()) tgt.addEventHistory(VersionConvertor_30_50.convertReference(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.MedicationAdministration.MedicationAdministrationDosageComponent convertMedicationAdministrationDosageComponent(org.hl7.fhir.r5.model.MedicationAdministration.MedicationAdministrationDosageComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.MedicationAdministration.MedicationAdministrationDosageComponent tgt = new org.hl7.fhir.dstu3.model.MedicationAdministration.MedicationAdministrationDosageComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasText())
            tgt.setTextElement(VersionConvertor_30_50.convertString(src.getTextElement()));
        if (src.hasSite())
            tgt.setSite(VersionConvertor_30_50.convertCodeableConcept(src.getSite()));
        if (src.hasRoute())
            tgt.setRoute(VersionConvertor_30_50.convertCodeableConcept(src.getRoute()));
        if (src.hasMethod())
            tgt.setMethod(VersionConvertor_30_50.convertCodeableConcept(src.getMethod()));
        if (src.hasDose())
            tgt.setDose(VersionConvertor_30_50.convertSimpleQuantity(src.getDose()));
        if (src.hasRate())
            tgt.setRate(VersionConvertor_30_50.convertType(src.getRate()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.MedicationAdministration.MedicationAdministrationDosageComponent convertMedicationAdministrationDosageComponent(org.hl7.fhir.dstu3.model.MedicationAdministration.MedicationAdministrationDosageComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.MedicationAdministration.MedicationAdministrationDosageComponent tgt = new org.hl7.fhir.r5.model.MedicationAdministration.MedicationAdministrationDosageComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasText())
            tgt.setTextElement(VersionConvertor_30_50.convertString(src.getTextElement()));
        if (src.hasSite())
            tgt.setSite(VersionConvertor_30_50.convertCodeableConcept(src.getSite()));
        if (src.hasRoute())
            tgt.setRoute(VersionConvertor_30_50.convertCodeableConcept(src.getRoute()));
        if (src.hasMethod())
            tgt.setMethod(VersionConvertor_30_50.convertCodeableConcept(src.getMethod()));
        if (src.hasDose())
            tgt.setDose(VersionConvertor_30_50.convertSimpleQuantity(src.getDose()));
        if (src.hasRate())
            tgt.setRate(VersionConvertor_30_50.convertType(src.getRate()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.MedicationAdministration.MedicationAdministrationPerformerComponent convertMedicationAdministrationPerformerComponent(org.hl7.fhir.dstu3.model.MedicationAdministration.MedicationAdministrationPerformerComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.MedicationAdministration.MedicationAdministrationPerformerComponent tgt = new org.hl7.fhir.r5.model.MedicationAdministration.MedicationAdministrationPerformerComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasActor())
            tgt.setActor(VersionConvertor_30_50.convertReference(src.getActor()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.MedicationAdministration.MedicationAdministrationPerformerComponent convertMedicationAdministrationPerformerComponent(org.hl7.fhir.r5.model.MedicationAdministration.MedicationAdministrationPerformerComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.MedicationAdministration.MedicationAdministrationPerformerComponent tgt = new org.hl7.fhir.dstu3.model.MedicationAdministration.MedicationAdministrationPerformerComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasActor())
            tgt.setActor(VersionConvertor_30_50.convertReference(src.getActor()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MedicationAdministration.MedicationAdministrationStatusCodes> convertMedicationAdministrationStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.MedicationAdministration.MedicationAdministrationStatus> src) {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MedicationAdministration.MedicationAdministrationStatusCodes> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new MedicationAdministrationStatusCodesEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        tgt.setValue(org.hl7.fhir.r5.model.MedicationAdministration.MedicationAdministrationStatusCodes.fromCode(src.getValueAsString()));
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.MedicationAdministration.MedicationAdministrationStatus> convertMedicationAdministrationStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MedicationAdministration.MedicationAdministrationStatusCodes> src) {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.MedicationAdministration.MedicationAdministrationStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.MedicationAdministration.MedicationAdministrationStatus>();
        VersionConvertor_30_50.copyElement(src, tgt);
        tgt.setValue(org.hl7.fhir.dstu3.model.MedicationAdministration.MedicationAdministrationStatus.fromCode(src.getValueAsString()));
        return tgt;
    }
}