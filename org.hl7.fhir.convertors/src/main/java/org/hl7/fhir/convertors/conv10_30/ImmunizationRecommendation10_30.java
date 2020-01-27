package org.hl7.fhir.convertors.conv10_30;

import org.hl7.fhir.convertors.VersionConvertor_10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class ImmunizationRecommendation10_30 {

    public static org.hl7.fhir.dstu2.model.ImmunizationRecommendation convertImmunizationRecommendation(org.hl7.fhir.dstu3.model.ImmunizationRecommendation src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ImmunizationRecommendation tgt = new org.hl7.fhir.dstu2.model.ImmunizationRecommendation();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_30.convertIdentifier(t));
        tgt.setPatient(VersionConvertor_10_30.convertReference(src.getPatient()));
        for (org.hl7.fhir.dstu3.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationComponent t : src.getRecommendation()) tgt.addRecommendation(convertImmunizationRecommendationRecommendationComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ImmunizationRecommendation convertImmunizationRecommendation(org.hl7.fhir.dstu2.model.ImmunizationRecommendation src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ImmunizationRecommendation tgt = new org.hl7.fhir.dstu3.model.ImmunizationRecommendation();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_30.convertIdentifier(t));
        tgt.setPatient(VersionConvertor_10_30.convertReference(src.getPatient()));
        for (org.hl7.fhir.dstu2.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationComponent t : src.getRecommendation()) tgt.addRecommendation(convertImmunizationRecommendationRecommendationComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationComponent convertImmunizationRecommendationRecommendationComponent(org.hl7.fhir.dstu3.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationComponent tgt = new org.hl7.fhir.dstu2.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasDate())
            tgt.setDate(src.getDate());
        tgt.setVaccineCode(VersionConvertor_10_30.convertCodeableConcept(src.getVaccineCode()));
        tgt.setDoseNumber(src.getDoseNumber());
        tgt.setForecastStatus(VersionConvertor_10_30.convertCodeableConcept(src.getForecastStatus()));
        for (org.hl7.fhir.dstu3.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationDateCriterionComponent t : src.getDateCriterion()) tgt.addDateCriterion(convertImmunizationRecommendationRecommendationDateCriterionComponent(t));
        tgt.setProtocol(convertImmunizationRecommendationRecommendationProtocolComponent(src.getProtocol()));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getSupportingImmunization()) tgt.addSupportingImmunization(VersionConvertor_10_30.convertReference(t));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getSupportingPatientInformation()) tgt.addSupportingPatientInformation(VersionConvertor_10_30.convertReference(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationComponent convertImmunizationRecommendationRecommendationComponent(org.hl7.fhir.dstu2.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationComponent tgt = new org.hl7.fhir.dstu3.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasDate())
            tgt.setDate(src.getDate());
        tgt.setVaccineCode(VersionConvertor_10_30.convertCodeableConcept(src.getVaccineCode()));
        tgt.setDoseNumber(src.getDoseNumber());
        tgt.setForecastStatus(VersionConvertor_10_30.convertCodeableConcept(src.getForecastStatus()));
        for (org.hl7.fhir.dstu2.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationDateCriterionComponent t : src.getDateCriterion()) tgt.addDateCriterion(convertImmunizationRecommendationRecommendationDateCriterionComponent(t));
        tgt.setProtocol(convertImmunizationRecommendationRecommendationProtocolComponent(src.getProtocol()));
        for (org.hl7.fhir.dstu2.model.Reference t : src.getSupportingImmunization()) tgt.addSupportingImmunization(VersionConvertor_10_30.convertReference(t));
        for (org.hl7.fhir.dstu2.model.Reference t : src.getSupportingPatientInformation()) tgt.addSupportingPatientInformation(VersionConvertor_10_30.convertReference(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationDateCriterionComponent convertImmunizationRecommendationRecommendationDateCriterionComponent(org.hl7.fhir.dstu3.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationDateCriterionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationDateCriterionComponent tgt = new org.hl7.fhir.dstu2.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationDateCriterionComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        tgt.setCode(VersionConvertor_10_30.convertCodeableConcept(src.getCode()));
        tgt.setValue(src.getValue());
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationDateCriterionComponent convertImmunizationRecommendationRecommendationDateCriterionComponent(org.hl7.fhir.dstu2.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationDateCriterionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationDateCriterionComponent tgt = new org.hl7.fhir.dstu3.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationDateCriterionComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        tgt.setCode(VersionConvertor_10_30.convertCodeableConcept(src.getCode()));
        tgt.setValue(src.getValue());
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationProtocolComponent convertImmunizationRecommendationRecommendationProtocolComponent(org.hl7.fhir.dstu3.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationProtocolComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationProtocolComponent tgt = new org.hl7.fhir.dstu2.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationProtocolComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        tgt.setDoseSequence(src.getDoseSequence());
        tgt.setDescription(src.getDescription());
        tgt.setAuthority(VersionConvertor_10_30.convertReference(src.getAuthority()));
        tgt.setSeries(src.getSeries());
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationProtocolComponent convertImmunizationRecommendationRecommendationProtocolComponent(org.hl7.fhir.dstu2.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationProtocolComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationProtocolComponent tgt = new org.hl7.fhir.dstu3.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationProtocolComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        tgt.setDoseSequence(src.getDoseSequence());
        tgt.setDescription(src.getDescription());
        tgt.setAuthority(VersionConvertor_10_30.convertReference(src.getAuthority()));
        tgt.setSeries(src.getSeries());
        return tgt;
    }
}
