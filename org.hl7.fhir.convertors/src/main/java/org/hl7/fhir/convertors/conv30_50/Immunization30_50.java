package org.hl7.fhir.convertors.conv30_50;

import org.hl7.fhir.convertors.VersionConvertor_30_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CodeableReference;

public class Immunization30_50 {

    public static org.hl7.fhir.r5.model.Immunization convertImmunization(org.hl7.fhir.dstu3.model.Immunization src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Immunization tgt = new org.hl7.fhir.r5.model.Immunization();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(t));
        if (src.hasStatus())
            tgt.setStatus(convertImmunizationStatus(src.getStatus()));
        if (src.hasVaccineCode())
            tgt.setVaccineCode(VersionConvertor_30_50.convertCodeableConcept(src.getVaccineCode()));
        if (src.hasPatient())
            tgt.setPatient(VersionConvertor_30_50.convertReference(src.getPatient()));
        if (src.hasEncounter())
            tgt.setEncounter(VersionConvertor_30_50.convertReference(src.getEncounter()));
        if (src.hasDate())
            tgt.setOccurrence(VersionConvertor_30_50.convertDateTime(src.getDateElement()));
        if (src.hasPrimarySource())
            tgt.setPrimarySource(src.getPrimarySource());
        if (src.hasReportOrigin())
            tgt.setInformationSource(VersionConvertor_30_50.convertCodeableConcept(src.getReportOrigin()));
        if (src.hasLocation())
            tgt.setLocation(VersionConvertor_30_50.convertReference(src.getLocation()));
        if (src.hasManufacturer())
            tgt.setManufacturer(VersionConvertor_30_50.convertReference(src.getManufacturer()));
        if (src.hasLotNumber())
            tgt.setLotNumber(src.getLotNumber());
        if (src.hasExpirationDate())
            tgt.setExpirationDate(src.getExpirationDate());
        if (src.hasSite())
            tgt.setSite(VersionConvertor_30_50.convertCodeableConcept(src.getSite()));
        if (src.hasRoute())
            tgt.setRoute(VersionConvertor_30_50.convertCodeableConcept(src.getRoute()));
        if (src.hasDoseQuantity())
            tgt.setDoseQuantity(VersionConvertor_30_50.convertSimpleQuantity(src.getDoseQuantity()));
        for (org.hl7.fhir.dstu3.model.Immunization.ImmunizationPractitionerComponent t : src.getPractitioner()) tgt.addPerformer(convertImmunizationPractitionerComponent(t));
        for (org.hl7.fhir.dstu3.model.Annotation t : src.getNote()) tgt.addNote(VersionConvertor_30_50.convertAnnotation(t));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getExplanation().getReason()) tgt.addReason(VersionConvertor_30_50.convertCodeableConceptToCodableReference(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Immunization convertImmunization(org.hl7.fhir.r5.model.Immunization src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Immunization tgt = new org.hl7.fhir.dstu3.model.Immunization();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(t));
        if (src.hasStatus())
            tgt.setStatus(convertImmunizationStatus(src.getStatus()));
        if (src.hasVaccineCode())
            tgt.setVaccineCode(VersionConvertor_30_50.convertCodeableConcept(src.getVaccineCode()));
        if (src.hasPatient())
            tgt.setPatient(VersionConvertor_30_50.convertReference(src.getPatient()));
        if (src.hasEncounter())
            tgt.setEncounter(VersionConvertor_30_50.convertReference(src.getEncounter()));
        if (src.hasOccurrenceDateTimeType())
            tgt.setDateElement(VersionConvertor_30_50.convertDateTime(src.getOccurrenceDateTimeType()));
        if (src.hasPrimarySource())
            tgt.setPrimarySource(src.getPrimarySource());
        if (src.hasInformationSourceCodeableConcept())
            tgt.setReportOrigin(VersionConvertor_30_50.convertCodeableConcept(src.getInformationSourceCodeableConcept()));
        if (src.hasLocation())
            tgt.setLocation(VersionConvertor_30_50.convertReference(src.getLocation()));
        if (src.hasManufacturer())
            tgt.setManufacturer(VersionConvertor_30_50.convertReference(src.getManufacturer()));
        if (src.hasLotNumber())
            tgt.setLotNumber(src.getLotNumber());
        if (src.hasExpirationDate())
            tgt.setExpirationDate(src.getExpirationDate());
        if (src.hasSite())
            tgt.setSite(VersionConvertor_30_50.convertCodeableConcept(src.getSite()));
        if (src.hasRoute())
            tgt.setRoute(VersionConvertor_30_50.convertCodeableConcept(src.getRoute()));
        if (src.hasDoseQuantity())
            tgt.setDoseQuantity(VersionConvertor_30_50.convertSimpleQuantity(src.getDoseQuantity()));
        for (org.hl7.fhir.r5.model.Immunization.ImmunizationPerformerComponent t : src.getPerformer()) tgt.addPractitioner(convertImmunizationPractitionerComponent(t));
        for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.addNote(VersionConvertor_30_50.convertAnnotation(t));
        for (CodeableReference t : src.getReason()) if (t.hasConcept())
            tgt.getExplanation().addReason(VersionConvertor_30_50.convertCodeableConcept(t.getConcept()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Immunization.ImmunizationPractitionerComponent convertImmunizationPractitionerComponent(org.hl7.fhir.r5.model.Immunization.ImmunizationPerformerComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Immunization.ImmunizationPractitionerComponent tgt = new org.hl7.fhir.dstu3.model.Immunization.ImmunizationPractitionerComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasFunction())
            tgt.setRole(VersionConvertor_30_50.convertCodeableConcept(src.getFunction()));
        if (src.hasActor())
            tgt.setActor(VersionConvertor_30_50.convertReference(src.getActor()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Immunization.ImmunizationPerformerComponent convertImmunizationPractitionerComponent(org.hl7.fhir.dstu3.model.Immunization.ImmunizationPractitionerComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Immunization.ImmunizationPerformerComponent tgt = new org.hl7.fhir.r5.model.Immunization.ImmunizationPerformerComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasRole())
            tgt.setFunction(VersionConvertor_30_50.convertCodeableConcept(src.getRole()));
        if (src.hasActor())
            tgt.setActor(VersionConvertor_30_50.convertReference(src.getActor()));
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Immunization.ImmunizationStatus convertImmunizationStatus(org.hl7.fhir.r5.model.Immunization.ImmunizationStatusCodes src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case COMPLETED:
                return org.hl7.fhir.dstu3.model.Immunization.ImmunizationStatus.COMPLETED;
            case ENTEREDINERROR:
                return org.hl7.fhir.dstu3.model.Immunization.ImmunizationStatus.ENTEREDINERROR;
            default:
                return org.hl7.fhir.dstu3.model.Immunization.ImmunizationStatus.NULL;
        }
    }

    static public org.hl7.fhir.r5.model.Immunization.ImmunizationStatusCodes convertImmunizationStatus(org.hl7.fhir.dstu3.model.Immunization.ImmunizationStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case COMPLETED:
                return org.hl7.fhir.r5.model.Immunization.ImmunizationStatusCodes.COMPLETED;
            case ENTEREDINERROR:
                return org.hl7.fhir.r5.model.Immunization.ImmunizationStatusCodes.ENTEREDINERROR;
            default:
                return org.hl7.fhir.r5.model.Immunization.ImmunizationStatusCodes.NULL;
        }
    }
}
