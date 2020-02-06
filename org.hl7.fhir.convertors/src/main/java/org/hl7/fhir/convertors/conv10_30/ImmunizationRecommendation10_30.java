package org.hl7.fhir.convertors.conv10_30;

import org.hl7.fhir.convertors.VersionConvertor_10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class ImmunizationRecommendation10_30 {

    public static org.hl7.fhir.dstu2.model.ImmunizationRecommendation convertImmunizationRecommendation(org.hl7.fhir.dstu3.model.ImmunizationRecommendation src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ImmunizationRecommendation tgt = new org.hl7.fhir.dstu2.model.ImmunizationRecommendation();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_30.convertIdentifier(t));
        }
        if (src.hasPatient()) {
            tgt.setPatient(VersionConvertor_10_30.convertReference(src.getPatient()));
        }
        if (src.hasRecommendation()) {
            for (org.hl7.fhir.dstu3.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationComponent t : src.getRecommendation()) tgt.addRecommendation(convertImmunizationRecommendationRecommendationComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ImmunizationRecommendation convertImmunizationRecommendation(org.hl7.fhir.dstu2.model.ImmunizationRecommendation src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ImmunizationRecommendation tgt = new org.hl7.fhir.dstu3.model.ImmunizationRecommendation();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_30.convertIdentifier(t));
        }
        if (src.hasPatient()) {
            tgt.setPatient(VersionConvertor_10_30.convertReference(src.getPatient()));
        }
        if (src.hasRecommendation()) {
            for (org.hl7.fhir.dstu2.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationComponent t : src.getRecommendation()) tgt.addRecommendation(convertImmunizationRecommendationRecommendationComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationComponent convertImmunizationRecommendationRecommendationComponent(org.hl7.fhir.dstu3.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationComponent tgt = new org.hl7.fhir.dstu2.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasDate())
            tgt.setDate(src.getDate());
        if (src.hasVaccineCode()) {
            tgt.setVaccineCode(VersionConvertor_10_30.convertCodeableConcept(src.getVaccineCode()));
        }
        if (src.hasDoseNumber()) {
            tgt.setDoseNumber(src.getDoseNumber());
        }
        if (src.hasForecastStatus()) {
            tgt.setForecastStatus(VersionConvertor_10_30.convertCodeableConcept(src.getForecastStatus()));
        }
        if (src.hasDateCriterion()) {
            for (org.hl7.fhir.dstu3.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationDateCriterionComponent t : src.getDateCriterion()) tgt.addDateCriterion(convertImmunizationRecommendationRecommendationDateCriterionComponent(t));
        }
        if (src.hasProtocol()) {
            tgt.setProtocol(convertImmunizationRecommendationRecommendationProtocolComponent(src.getProtocol()));
        }
        if (src.hasSupportingImmunization()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getSupportingImmunization()) tgt.addSupportingImmunization(VersionConvertor_10_30.convertReference(t));
        }
        if (src.hasSupportingPatientInformation()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getSupportingPatientInformation()) tgt.addSupportingPatientInformation(VersionConvertor_10_30.convertReference(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationComponent convertImmunizationRecommendationRecommendationComponent(org.hl7.fhir.dstu2.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationComponent tgt = new org.hl7.fhir.dstu3.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasDate())
            tgt.setDate(src.getDate());
        if (src.hasVaccineCode()) {
            tgt.setVaccineCode(VersionConvertor_10_30.convertCodeableConcept(src.getVaccineCode()));
        }
        if (src.hasDoseNumber()) {
            tgt.setDoseNumber(src.getDoseNumber());
        }
        if (src.hasForecastStatus()) {
            tgt.setForecastStatus(VersionConvertor_10_30.convertCodeableConcept(src.getForecastStatus()));
        }
        if (src.hasDateCriterion()) {
            for (org.hl7.fhir.dstu2.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationDateCriterionComponent t : src.getDateCriterion()) tgt.addDateCriterion(convertImmunizationRecommendationRecommendationDateCriterionComponent(t));
        }
        if (src.hasProtocol()) {
            tgt.setProtocol(convertImmunizationRecommendationRecommendationProtocolComponent(src.getProtocol()));
        }
        if (src.hasSupportingImmunization()) {
            for (org.hl7.fhir.dstu2.model.Reference t : src.getSupportingImmunization()) tgt.addSupportingImmunization(VersionConvertor_10_30.convertReference(t));
        }
        if (src.hasSupportingPatientInformation()) {
            for (org.hl7.fhir.dstu2.model.Reference t : src.getSupportingPatientInformation()) tgt.addSupportingPatientInformation(VersionConvertor_10_30.convertReference(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationDateCriterionComponent convertImmunizationRecommendationRecommendationDateCriterionComponent(org.hl7.fhir.dstu3.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationDateCriterionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationDateCriterionComponent tgt = new org.hl7.fhir.dstu2.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationDateCriterionComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasCode()) {
            tgt.setCode(VersionConvertor_10_30.convertCodeableConcept(src.getCode()));
        }
        if (src.hasValue()) {
            tgt.setValue(src.getValue());
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationDateCriterionComponent convertImmunizationRecommendationRecommendationDateCriterionComponent(org.hl7.fhir.dstu2.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationDateCriterionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationDateCriterionComponent tgt = new org.hl7.fhir.dstu3.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationDateCriterionComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasCode()) {
            tgt.setCode(VersionConvertor_10_30.convertCodeableConcept(src.getCode()));
        }
        if (src.hasValue()) {
            tgt.setValue(src.getValue());
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationProtocolComponent convertImmunizationRecommendationRecommendationProtocolComponent(org.hl7.fhir.dstu3.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationProtocolComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationProtocolComponent tgt = new org.hl7.fhir.dstu2.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationProtocolComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasDoseSequence()) {
            tgt.setDoseSequence(src.getDoseSequence());
        }
        if (src.hasDescription()) {
            tgt.setDescription(src.getDescription());
        }
        if (src.hasAuthority()) {
            tgt.setAuthority(VersionConvertor_10_30.convertReference(src.getAuthority()));
        }
        if (src.hasSeries()) {
            tgt.setSeries(src.getSeries());
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationProtocolComponent convertImmunizationRecommendationRecommendationProtocolComponent(org.hl7.fhir.dstu2.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationProtocolComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationProtocolComponent tgt = new org.hl7.fhir.dstu3.model.ImmunizationRecommendation.ImmunizationRecommendationRecommendationProtocolComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasDoseSequence()) {
            tgt.setDoseSequence(src.getDoseSequence());
        }
        if (src.hasDescription()) {
            tgt.setDescription(src.getDescription());
        }
        if (src.hasAuthority()) {
            tgt.setAuthority(VersionConvertor_10_30.convertReference(src.getAuthority()));
        }
        if (src.hasSeries()) {
            tgt.setSeries(src.getSeries());
        }
        return tgt;
    }
}
