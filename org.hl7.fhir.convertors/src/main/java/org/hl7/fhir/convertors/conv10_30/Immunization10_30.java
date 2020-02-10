package org.hl7.fhir.convertors.conv10_30;

import org.hl7.fhir.convertors.VersionConvertor_10_30;
import org.hl7.fhir.dstu2.model.BooleanType;
import org.hl7.fhir.dstu3.model.Coding;
import org.hl7.fhir.dstu3.model.Immunization.ImmunizationPractitionerComponent;
import org.hl7.fhir.exceptions.FHIRException;
import java.util.List;
import java.util.Collections;

public class Immunization10_30 {

    public static org.hl7.fhir.dstu2.model.Immunization convertImmunization(org.hl7.fhir.dstu3.model.Immunization src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Immunization tgt = new org.hl7.fhir.dstu2.model.Immunization();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_30.convertIdentifier(t));
        }
        if (src.hasStatus()) {
            tgt.setStatus(src.getStatus().toCode());
        }
        if (src.hasDateElement())
            tgt.setDateElement((org.hl7.fhir.dstu2.model.DateTimeType) VersionConvertor_10_30.convertType(src.getDateElement()));
        if (src.hasVaccineCode()) {
            tgt.setVaccineCode(VersionConvertor_10_30.convertCodeableConcept(src.getVaccineCode()));
        }
        if (src.hasPatient()) {
            tgt.setPatient(VersionConvertor_10_30.convertReference(src.getPatient()));
        }
        if (src.hasNotGivenElement()) {
            tgt.setWasNotGivenElement((BooleanType) VersionConvertor_10_30.convertType(src.getNotGivenElement()));
        }
        if (src.hasPrimarySource()) {
            tgt.setReported(!src.getPrimarySource());
        }
        if (src.hasPractitioner()) {
            tgt.setPerformer(VersionConvertor_10_30.convertReference(getPerformer(src.getPractitioner())));
        }
        if (src.hasPractitioner()) {
            tgt.setRequester(VersionConvertor_10_30.convertReference(getRequester(src.getPractitioner())));
        }
        if (src.hasEncounter()) {
            tgt.setEncounter(VersionConvertor_10_30.convertReference(src.getEncounter()));
        }
        if (src.hasManufacturer()) {
            tgt.setManufacturer(VersionConvertor_10_30.convertReference(src.getManufacturer()));
        }
        if (src.hasLocation()) {
            tgt.setLocation(VersionConvertor_10_30.convertReference(src.getLocation()));
        }
        if (src.hasLotNumberElement())
            tgt.setLotNumberElement((org.hl7.fhir.dstu2.model.StringType) VersionConvertor_10_30.convertType(src.getLotNumberElement()));
        if (src.hasExpirationDateElement())
            tgt.setExpirationDateElement((org.hl7.fhir.dstu2.model.DateType) VersionConvertor_10_30.convertType(src.getExpirationDateElement()));
        if (src.hasSite()) {
            tgt.setSite(VersionConvertor_10_30.convertCodeableConcept(src.getSite()));
        }
        if (src.hasRoute()) {
            tgt.setRoute(VersionConvertor_10_30.convertCodeableConcept(src.getRoute()));
        }
        if (src.hasDoseQuantity()) {
            tgt.setDoseQuantity(VersionConvertor_10_30.convertSimpleQuantity(src.getDoseQuantity()));
        }
        if (src.hasNote()) {
            for (org.hl7.fhir.dstu3.model.Annotation t : src.getNote()) tgt.addNote(VersionConvertor_10_30.convertAnnotation(t));
        }
        if (src.hasExplanation()) {
            tgt.setExplanation(convertImmunizationExplanationComponent(src.getExplanation()));
        }
        if (src.hasReaction()) {
            for (org.hl7.fhir.dstu3.model.Immunization.ImmunizationReactionComponent t : src.getReaction()) tgt.addReaction(convertImmunizationReactionComponent(t));
        }
        if (src.hasVaccinationProtocol()) {
            for (org.hl7.fhir.dstu3.model.Immunization.ImmunizationVaccinationProtocolComponent t : src.getVaccinationProtocol()) tgt.addVaccinationProtocol(convertImmunizationVaccinationProtocolComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Immunization convertImmunization(org.hl7.fhir.dstu2.model.Immunization src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Immunization tgt = new org.hl7.fhir.dstu3.model.Immunization();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_30.convertIdentifier(t));
        }
        try {
            if (src.hasStatus()) {
                tgt.setStatus(org.hl7.fhir.dstu3.model.Immunization.ImmunizationStatus.fromCode(src.getStatus()));
            }
        } catch (org.hl7.fhir.exceptions.FHIRException e) {
            throw new FHIRException(e);
        }
        if (src.hasDateElement())
            tgt.setDateElement((org.hl7.fhir.dstu3.model.DateTimeType) VersionConvertor_10_30.convertType(src.getDateElement()));
        if (src.hasVaccineCode()) {
            tgt.setVaccineCode(VersionConvertor_10_30.convertCodeableConcept(src.getVaccineCode()));
        }
        if (src.hasPatient()) {
            tgt.setPatient(VersionConvertor_10_30.convertReference(src.getPatient()));
        }
        if (src.hasWasNotGivenElement()) {
            tgt.setNotGivenElement((org.hl7.fhir.dstu3.model.BooleanType) VersionConvertor_10_30.convertType(src.getWasNotGivenElement()));
        }
        if (src.hasReported()) {
            tgt.setPrimarySource(!src.getReported());
        }
        if (src.hasPerformer())
            tgt.addPractitioner().setActor(VersionConvertor_10_30.convertReference(src.getPerformer())).setRole(new org.hl7.fhir.dstu3.model.CodeableConcept().addCoding(new Coding().setSystem("http://hl7.org/fhir/v2/0443").setCode("AP")));
        if (src.hasRequester())
            tgt.addPractitioner().setActor(VersionConvertor_10_30.convertReference(src.getRequester())).setRole(new org.hl7.fhir.dstu3.model.CodeableConcept().addCoding(new Coding().setSystem("http://hl7.org/fhir/v2/0443").setCode("OP")));
        if (src.hasEncounter()) {
            tgt.setEncounter(VersionConvertor_10_30.convertReference(src.getEncounter()));
        }
        if (src.hasManufacturer()) {
            tgt.setManufacturer(VersionConvertor_10_30.convertReference(src.getManufacturer()));
        }
        if (src.hasLocation()) {
            tgt.setLocation(VersionConvertor_10_30.convertReference(src.getLocation()));
        }
        if (src.hasLotNumberElement())
            tgt.setLotNumberElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_10_30.convertType(src.getLotNumberElement()));
        if (src.hasExpirationDateElement())
            tgt.setExpirationDateElement((org.hl7.fhir.dstu3.model.DateType) VersionConvertor_10_30.convertType(src.getExpirationDateElement()));
        if (src.hasSite()) {
            tgt.setSite(VersionConvertor_10_30.convertCodeableConcept(src.getSite()));
        }
        if (src.hasRoute()) {
            tgt.setRoute(VersionConvertor_10_30.convertCodeableConcept(src.getRoute()));
        }
        if (src.hasDoseQuantity()) {
            tgt.setDoseQuantity(VersionConvertor_10_30.convertSimpleQuantity(src.getDoseQuantity()));
        }
        if (src.hasNote()) {
            for (org.hl7.fhir.dstu2.model.Annotation t : src.getNote()) tgt.addNote(VersionConvertor_10_30.convertAnnotation(t));
        }
        if (src.hasExplanation()) {
            tgt.setExplanation(convertImmunizationExplanationComponent(src.getExplanation()));
        }
        if (src.hasReaction()) {
            for (org.hl7.fhir.dstu2.model.Immunization.ImmunizationReactionComponent t : src.getReaction()) tgt.addReaction(convertImmunizationReactionComponent(t));
        }
        if (src.hasVaccinationProtocol()) {
            for (org.hl7.fhir.dstu2.model.Immunization.ImmunizationVaccinationProtocolComponent t : src.getVaccinationProtocol()) tgt.addVaccinationProtocol(convertImmunizationVaccinationProtocolComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Immunization.ImmunizationExplanationComponent convertImmunizationExplanationComponent(org.hl7.fhir.dstu3.model.Immunization.ImmunizationExplanationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Immunization.ImmunizationExplanationComponent tgt = new org.hl7.fhir.dstu2.model.Immunization.ImmunizationExplanationComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasReason()) {
            for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getReason()) tgt.addReason(VersionConvertor_10_30.convertCodeableConcept(t));
        }
        if (src.hasReasonNotGiven()) {
            for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getReasonNotGiven()) tgt.addReasonNotGiven(VersionConvertor_10_30.convertCodeableConcept(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Immunization.ImmunizationExplanationComponent convertImmunizationExplanationComponent(org.hl7.fhir.dstu2.model.Immunization.ImmunizationExplanationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Immunization.ImmunizationExplanationComponent tgt = new org.hl7.fhir.dstu3.model.Immunization.ImmunizationExplanationComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasReason()) {
            for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getReason()) tgt.addReason(VersionConvertor_10_30.convertCodeableConcept(t));
        }
        if (src.hasReasonNotGiven()) {
            for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getReasonNotGiven()) tgt.addReasonNotGiven(VersionConvertor_10_30.convertCodeableConcept(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Immunization.ImmunizationReactionComponent convertImmunizationReactionComponent(org.hl7.fhir.dstu2.model.Immunization.ImmunizationReactionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Immunization.ImmunizationReactionComponent tgt = new org.hl7.fhir.dstu3.model.Immunization.ImmunizationReactionComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasDateElement())
            tgt.setDateElement((org.hl7.fhir.dstu3.model.DateTimeType) VersionConvertor_10_30.convertType(src.getDateElement()));
        if (src.hasDetail()) {
            tgt.setDetail(VersionConvertor_10_30.convertReference(src.getDetail()));
        }
        if (src.hasReportedElement()) {
            tgt.setReportedElement((org.hl7.fhir.dstu3.model.BooleanType) VersionConvertor_10_30.convertType(src.getReportedElement()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Immunization.ImmunizationReactionComponent convertImmunizationReactionComponent(org.hl7.fhir.dstu3.model.Immunization.ImmunizationReactionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Immunization.ImmunizationReactionComponent tgt = new org.hl7.fhir.dstu2.model.Immunization.ImmunizationReactionComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasDateElement())
            tgt.setDateElement((org.hl7.fhir.dstu2.model.DateTimeType) VersionConvertor_10_30.convertType(src.getDateElement()));
        if (src.hasDetail()) {
            tgt.setDetail(VersionConvertor_10_30.convertReference(src.getDetail()));
        }
        if (src.hasReportedElement()) {
            tgt.setReportedElement((BooleanType) VersionConvertor_10_30.convertType(src.getReportedElement()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Immunization.ImmunizationVaccinationProtocolComponent convertImmunizationVaccinationProtocolComponent(org.hl7.fhir.dstu3.model.Immunization.ImmunizationVaccinationProtocolComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Immunization.ImmunizationVaccinationProtocolComponent tgt = new org.hl7.fhir.dstu2.model.Immunization.ImmunizationVaccinationProtocolComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasDoseSequence()) {
            tgt.setDoseSequence(src.getDoseSequence());
        }
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.dstu2.model.StringType) VersionConvertor_10_30.convertType(src.getDescriptionElement()));
        if (src.hasAuthority()) {
            tgt.setAuthority(VersionConvertor_10_30.convertReference(src.getAuthority()));
        }
        if (src.hasSeriesElement())
            tgt.setSeriesElement((org.hl7.fhir.dstu2.model.StringType) VersionConvertor_10_30.convertType(src.getSeriesElement()));
        if (src.hasSeriesDoses()) {
            tgt.setSeriesDoses(src.getSeriesDoses());
        }
        if (src.hasTargetDisease()) {
            for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getTargetDisease()) tgt.addTargetDisease(VersionConvertor_10_30.convertCodeableConcept(t));
        }
        if (src.hasDoseStatus()) {
            tgt.setDoseStatus(VersionConvertor_10_30.convertCodeableConcept(src.getDoseStatus()));
        }
        if (src.hasDoseStatusReason()) {
            tgt.setDoseStatusReason(VersionConvertor_10_30.convertCodeableConcept(src.getDoseStatusReason()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Immunization.ImmunizationVaccinationProtocolComponent convertImmunizationVaccinationProtocolComponent(org.hl7.fhir.dstu2.model.Immunization.ImmunizationVaccinationProtocolComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Immunization.ImmunizationVaccinationProtocolComponent tgt = new org.hl7.fhir.dstu3.model.Immunization.ImmunizationVaccinationProtocolComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasDoseSequence()) {
            tgt.setDoseSequence(src.getDoseSequence());
        }
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_10_30.convertType(src.getDescriptionElement()));
        if (src.hasAuthority()) {
            tgt.setAuthority(VersionConvertor_10_30.convertReference(src.getAuthority()));
        }
        if (src.hasSeriesElement())
            tgt.setSeriesElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_10_30.convertType(src.getSeriesElement()));
        if (src.hasSeriesDoses()) {
            tgt.setSeriesDoses(src.getSeriesDoses());
        }
        if (src.hasTargetDisease()) {
            for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getTargetDisease()) tgt.addTargetDisease(VersionConvertor_10_30.convertCodeableConcept(t));
        }
        if (src.hasDoseStatus()) {
            tgt.setDoseStatus(VersionConvertor_10_30.convertCodeableConcept(src.getDoseStatus()));
        }
        if (src.hasDoseStatusReason()) {
            tgt.setDoseStatusReason(VersionConvertor_10_30.convertCodeableConcept(src.getDoseStatusReason()));
        }
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
