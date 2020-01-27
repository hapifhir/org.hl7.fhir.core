package org.hl7.fhir.convertors.conv10_30;

import org.hl7.fhir.convertors.VersionConvertor_10_30;
import org.hl7.fhir.dstu3.model.Coding;
import org.hl7.fhir.dstu3.model.Immunization.ImmunizationPractitionerComponent;
import org.hl7.fhir.exceptions.FHIRException;

import java.util.List;

public class Immunization10_30 {

    public static org.hl7.fhir.dstu2.model.Immunization convertImmunization(org.hl7.fhir.dstu3.model.Immunization src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Immunization tgt = new org.hl7.fhir.dstu2.model.Immunization();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_30.convertIdentifier(t));
        tgt.setStatus(src.getStatus().toCode());
        if (src.hasDate())
            tgt.setDate(src.getDate());
        tgt.setVaccineCode(VersionConvertor_10_30.convertCodeableConcept(src.getVaccineCode()));
        tgt.setPatient(VersionConvertor_10_30.convertReference(src.getPatient()));
        tgt.setWasNotGiven(src.getNotGiven());
        tgt.setReported(!src.getPrimarySource());
        tgt.setPerformer(VersionConvertor_10_30.convertReference(getPerformer(src.getPractitioner())));
        tgt.setRequester(VersionConvertor_10_30.convertReference(getRequester(src.getPractitioner())));
        tgt.setEncounter(VersionConvertor_10_30.convertReference(src.getEncounter()));
        tgt.setManufacturer(VersionConvertor_10_30.convertReference(src.getManufacturer()));
        tgt.setLocation(VersionConvertor_10_30.convertReference(src.getLocation()));
        tgt.setLotNumber(src.getLotNumber());
        tgt.setExpirationDate(src.getExpirationDate());
        tgt.setSite(VersionConvertor_10_30.convertCodeableConcept(src.getSite()));
        tgt.setRoute(VersionConvertor_10_30.convertCodeableConcept(src.getRoute()));
        tgt.setDoseQuantity(VersionConvertor_10_30.convertSimpleQuantity(src.getDoseQuantity()));
        for (org.hl7.fhir.dstu3.model.Annotation t : src.getNote()) tgt.addNote(VersionConvertor_10_30.convertAnnotation(t));
        tgt.setExplanation(convertImmunizationExplanationComponent(src.getExplanation()));
        for (org.hl7.fhir.dstu3.model.Immunization.ImmunizationReactionComponent t : src.getReaction()) tgt.addReaction(convertImmunizationReactionComponent(t));
        for (org.hl7.fhir.dstu3.model.Immunization.ImmunizationVaccinationProtocolComponent t : src.getVaccinationProtocol()) tgt.addVaccinationProtocol(convertImmunizationVaccinationProtocolComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Immunization convertImmunization(org.hl7.fhir.dstu2.model.Immunization src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Immunization tgt = new org.hl7.fhir.dstu3.model.Immunization();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_30.convertIdentifier(t));
        try {
            tgt.setStatus(org.hl7.fhir.dstu3.model.Immunization.ImmunizationStatus.fromCode(src.getStatus()));
        } catch (org.hl7.fhir.exceptions.FHIRException e) {
            throw new FHIRException(e);
        }
        if (src.hasDate())
            tgt.setDate(src.getDate());
        tgt.setVaccineCode(VersionConvertor_10_30.convertCodeableConcept(src.getVaccineCode()));
        tgt.setPatient(VersionConvertor_10_30.convertReference(src.getPatient()));
        tgt.setNotGiven(src.getWasNotGiven());
        tgt.setPrimarySource(!src.getReported());
        if (src.hasPerformer())
            tgt.addPractitioner().setActor(VersionConvertor_10_30.convertReference(src.getPerformer())).setRole(new org.hl7.fhir.dstu3.model.CodeableConcept().addCoding(new Coding().setSystem("http://hl7.org/fhir/v2/0443").setCode("AP")));
        if (src.hasRequester())
            tgt.addPractitioner().setActor(VersionConvertor_10_30.convertReference(src.getRequester())).setRole(new org.hl7.fhir.dstu3.model.CodeableConcept().addCoding(new Coding().setSystem("http://hl7.org/fhir/v2/0443").setCode("OP")));
        tgt.setEncounter(VersionConvertor_10_30.convertReference(src.getEncounter()));
        tgt.setManufacturer(VersionConvertor_10_30.convertReference(src.getManufacturer()));
        tgt.setLocation(VersionConvertor_10_30.convertReference(src.getLocation()));
        tgt.setLotNumber(src.getLotNumber());
        tgt.setExpirationDate(src.getExpirationDate());
        tgt.setSite(VersionConvertor_10_30.convertCodeableConcept(src.getSite()));
        tgt.setRoute(VersionConvertor_10_30.convertCodeableConcept(src.getRoute()));
        tgt.setDoseQuantity(VersionConvertor_10_30.convertSimpleQuantity(src.getDoseQuantity()));
        for (org.hl7.fhir.dstu2.model.Annotation t : src.getNote()) tgt.addNote(VersionConvertor_10_30.convertAnnotation(t));
        tgt.setExplanation(convertImmunizationExplanationComponent(src.getExplanation()));
        for (org.hl7.fhir.dstu2.model.Immunization.ImmunizationReactionComponent t : src.getReaction()) tgt.addReaction(convertImmunizationReactionComponent(t));
        for (org.hl7.fhir.dstu2.model.Immunization.ImmunizationVaccinationProtocolComponent t : src.getVaccinationProtocol()) tgt.addVaccinationProtocol(convertImmunizationVaccinationProtocolComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Immunization.ImmunizationExplanationComponent convertImmunizationExplanationComponent(org.hl7.fhir.dstu3.model.Immunization.ImmunizationExplanationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Immunization.ImmunizationExplanationComponent tgt = new org.hl7.fhir.dstu2.model.Immunization.ImmunizationExplanationComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getReason()) tgt.addReason(VersionConvertor_10_30.convertCodeableConcept(t));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getReasonNotGiven()) tgt.addReasonNotGiven(VersionConvertor_10_30.convertCodeableConcept(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Immunization.ImmunizationExplanationComponent convertImmunizationExplanationComponent(org.hl7.fhir.dstu2.model.Immunization.ImmunizationExplanationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Immunization.ImmunizationExplanationComponent tgt = new org.hl7.fhir.dstu3.model.Immunization.ImmunizationExplanationComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getReason()) tgt.addReason(VersionConvertor_10_30.convertCodeableConcept(t));
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getReasonNotGiven()) tgt.addReasonNotGiven(VersionConvertor_10_30.convertCodeableConcept(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Immunization.ImmunizationReactionComponent convertImmunizationReactionComponent(org.hl7.fhir.dstu2.model.Immunization.ImmunizationReactionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Immunization.ImmunizationReactionComponent tgt = new org.hl7.fhir.dstu3.model.Immunization.ImmunizationReactionComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasDate())
            tgt.setDate(src.getDate());
        tgt.setDetail(VersionConvertor_10_30.convertReference(src.getDetail()));
        tgt.setReported(src.getReported());
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Immunization.ImmunizationReactionComponent convertImmunizationReactionComponent(org.hl7.fhir.dstu3.model.Immunization.ImmunizationReactionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Immunization.ImmunizationReactionComponent tgt = new org.hl7.fhir.dstu2.model.Immunization.ImmunizationReactionComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasDate())
            tgt.setDate(src.getDate());
        tgt.setDetail(VersionConvertor_10_30.convertReference(src.getDetail()));
        tgt.setReported(src.getReported());
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Immunization.ImmunizationVaccinationProtocolComponent convertImmunizationVaccinationProtocolComponent(org.hl7.fhir.dstu3.model.Immunization.ImmunizationVaccinationProtocolComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Immunization.ImmunizationVaccinationProtocolComponent tgt = new org.hl7.fhir.dstu2.model.Immunization.ImmunizationVaccinationProtocolComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        tgt.setDoseSequence(src.getDoseSequence());
        tgt.setDescription(src.getDescription());
        tgt.setAuthority(VersionConvertor_10_30.convertReference(src.getAuthority()));
        tgt.setSeries(src.getSeries());
        tgt.setSeriesDoses(src.getSeriesDoses());
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getTargetDisease()) tgt.addTargetDisease(VersionConvertor_10_30.convertCodeableConcept(t));
        tgt.setDoseStatus(VersionConvertor_10_30.convertCodeableConcept(src.getDoseStatus()));
        tgt.setDoseStatusReason(VersionConvertor_10_30.convertCodeableConcept(src.getDoseStatusReason()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Immunization.ImmunizationVaccinationProtocolComponent convertImmunizationVaccinationProtocolComponent(org.hl7.fhir.dstu2.model.Immunization.ImmunizationVaccinationProtocolComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Immunization.ImmunizationVaccinationProtocolComponent tgt = new org.hl7.fhir.dstu3.model.Immunization.ImmunizationVaccinationProtocolComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        tgt.setDoseSequence(src.getDoseSequence());
        tgt.setDescription(src.getDescription());
        tgt.setAuthority(VersionConvertor_10_30.convertReference(src.getAuthority()));
        tgt.setSeries(src.getSeries());
        tgt.setSeriesDoses(src.getSeriesDoses());
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getTargetDisease()) tgt.addTargetDisease(VersionConvertor_10_30.convertCodeableConcept(t));
        tgt.setDoseStatus(VersionConvertor_10_30.convertCodeableConcept(src.getDoseStatus()));
        tgt.setDoseStatusReason(VersionConvertor_10_30.convertCodeableConcept(src.getDoseStatusReason()));
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Reference getPerformer(List<ImmunizationPractitionerComponent> practitioner) {
        for (ImmunizationPractitionerComponent p : practitioner) {
            if (VersionConvertor_10_30.hasConcept(p.getRole(), "http://hl7.org/fhir/v2/0443", "AP"))
                return p.getActor();
        }
        return null;
    }

    static public org.hl7.fhir.dstu3.model.Reference getRequester(List<ImmunizationPractitionerComponent> practitioner) {
        for (ImmunizationPractitionerComponent p : practitioner) {
            if (VersionConvertor_10_30.hasConcept(p.getRole(), "http://hl7.org/fhir/v2/0443", "OP"))
                return p.getActor();
        }
        return null;
    }
}
