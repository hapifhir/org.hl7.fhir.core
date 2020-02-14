package org.hl7.fhir.convertors.conv30_50;

import org.hl7.fhir.convertors.VersionConvertor_30_50;
import org.hl7.fhir.exceptions.FHIRException;

public class AllergyIntolerance30_50 {

    public static org.hl7.fhir.dstu3.model.AllergyIntolerance convertAllergyIntolerance(org.hl7.fhir.r5.model.AllergyIntolerance src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.AllergyIntolerance tgt = new org.hl7.fhir.dstu3.model.AllergyIntolerance();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(t));
        if (src.hasClinicalStatus())
            tgt.setClinicalStatus(convertAllergyIntoleranceClinicalStatus(src.getClinicalStatus()));
        if (src.hasVerificationStatus())
            tgt.setVerificationStatus(convertAllergyIntoleranceVerificationStatus(src.getVerificationStatus()));
        if (src.hasType())
            tgt.setType(convertAllergyIntoleranceType(src.getType()));
        for (org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceCategory> t : src.getCategory()) VersionConvertor_30_50.copyElement(t, tgt.addCategoryElement().setValue(convertAllergyIntoleranceCategory(t.getValue())));
        if (src.hasCriticality())
            tgt.setCriticality(convertAllergyIntoleranceCriticality(src.getCriticality()));
        if (src.hasCode())
            tgt.setCode(VersionConvertor_30_50.convertCodeableConcept(src.getCode()));
        if (src.hasPatient())
            tgt.setPatient(VersionConvertor_30_50.convertReference(src.getPatient()));
        if (src.hasOnset())
            tgt.setOnset(VersionConvertor_30_50.convertType(src.getOnset()));
        if (src.hasRecordedDate())
            tgt.setAssertedDateElement(VersionConvertor_30_50.convertDateTime(src.getRecordedDateElement()));
        if (src.hasRecorder())
            tgt.setRecorder(VersionConvertor_30_50.convertReference(src.getRecorder()));
        if (src.hasAsserter())
            tgt.setAsserter(VersionConvertor_30_50.convertReference(src.getAsserter()));
        if (src.hasLastOccurrence())
            tgt.setLastOccurrenceElement(VersionConvertor_30_50.convertDateTime(src.getLastOccurrenceElement()));
        for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.addNote(VersionConvertor_30_50.convertAnnotation(t));
        for (org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceReactionComponent t : src.getReaction()) tgt.addReaction(convertAllergyIntoleranceReactionComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.AllergyIntolerance convertAllergyIntolerance(org.hl7.fhir.dstu3.model.AllergyIntolerance src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.AllergyIntolerance tgt = new org.hl7.fhir.r5.model.AllergyIntolerance();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(t));
        if (src.hasClinicalStatus())
            tgt.setClinicalStatus(convertAllergyIntoleranceClinicalStatus(src.getClinicalStatus()));
        if (src.hasVerificationStatus())
            tgt.setVerificationStatus(convertAllergyIntoleranceVerificationStatus(src.getVerificationStatus()));
        if (src.hasType())
            tgt.setType(convertAllergyIntoleranceType(src.getType()));
        for (org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceCategory> t : src.getCategory()) VersionConvertor_30_50.copyElement(t, tgt.addCategoryElement().setValue(convertAllergyIntoleranceCategory(t.getValue())));
        if (src.hasCriticality())
            tgt.setCriticality(convertAllergyIntoleranceCriticality(src.getCriticality()));
        if (src.hasCode())
            tgt.setCode(VersionConvertor_30_50.convertCodeableConcept(src.getCode()));
        if (src.hasPatient())
            tgt.setPatient(VersionConvertor_30_50.convertReference(src.getPatient()));
        if (src.hasOnset())
            tgt.setOnset(VersionConvertor_30_50.convertType(src.getOnset()));
        if (src.hasAssertedDate())
            tgt.setRecordedDateElement(VersionConvertor_30_50.convertDateTime(src.getAssertedDateElement()));
        if (src.hasRecorder())
            tgt.setRecorder(VersionConvertor_30_50.convertReference(src.getRecorder()));
        if (src.hasAsserter())
            tgt.setAsserter(VersionConvertor_30_50.convertReference(src.getAsserter()));
        if (src.hasLastOccurrence())
            tgt.setLastOccurrenceElement(VersionConvertor_30_50.convertDateTime(src.getLastOccurrenceElement()));
        for (org.hl7.fhir.dstu3.model.Annotation t : src.getNote()) tgt.addNote(VersionConvertor_30_50.convertAnnotation(t));
        for (org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceReactionComponent t : src.getReaction()) tgt.addReaction(convertAllergyIntoleranceReactionComponent(t));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceCategory convertAllergyIntoleranceCategory(org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceCategory src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case FOOD:
                return org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceCategory.FOOD;
            case MEDICATION:
                return org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceCategory.MEDICATION;
            case ENVIRONMENT:
                return org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceCategory.ENVIRONMENT;
            case BIOLOGIC:
                return org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceCategory.BIOLOGIC;
            default:
                return org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceCategory.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceCategory convertAllergyIntoleranceCategory(org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceCategory src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case FOOD:
                return org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceCategory.FOOD;
            case MEDICATION:
                return org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceCategory.MEDICATION;
            case ENVIRONMENT:
                return org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceCategory.ENVIRONMENT;
            case BIOLOGIC:
                return org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceCategory.BIOLOGIC;
            default:
                return org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceCategory.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceClinicalStatus convertAllergyIntoleranceClinicalStatus(org.hl7.fhir.r5.model.CodeableConcept src) throws FHIRException {
        if (src == null)
            return null;
        if (src.hasCoding("http://terminology.hl7.org/CodeSystem/allergyintolerance-clinical", "active"))
            return org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceClinicalStatus.ACTIVE;
        if (src.hasCoding("http://terminology.hl7.org/CodeSystem/allergyintolerance-clinical", "inactive"))
            return org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceClinicalStatus.INACTIVE;
        if (src.hasCoding("http://terminology.hl7.org/CodeSystem/allergyintolerance-clinical", "resolved"))
            return org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceClinicalStatus.RESOLVED;
        return org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceClinicalStatus.NULL;
    }

    static public org.hl7.fhir.r5.model.CodeableConcept convertAllergyIntoleranceClinicalStatus(org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceClinicalStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case ACTIVE:
                return new org.hl7.fhir.r5.model.CodeableConcept(new org.hl7.fhir.r5.model.Coding().setSystem("http://terminology.hl7.org/CodeSystem/allergyintolerance-clinical").setCode("active"));
            case INACTIVE:
                return new org.hl7.fhir.r5.model.CodeableConcept(new org.hl7.fhir.r5.model.Coding().setSystem("http://terminology.hl7.org/CodeSystem/allergyintolerance-clinical").setCode("inactive"));
            case RESOLVED:
                new org.hl7.fhir.r5.model.CodeableConcept(new org.hl7.fhir.r5.model.Coding().setSystem("http://terminology.hl7.org/CodeSystem/allergyintolerance-clinical").setCode("resolved"));
            default:
                return null;
        }
    }

    static public org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceCriticality convertAllergyIntoleranceCriticality(org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceCriticality src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case LOW:
                return org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceCriticality.LOW;
            case HIGH:
                return org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceCriticality.HIGH;
            case UNABLETOASSESS:
                return org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceCriticality.UNABLETOASSESS;
            default:
                return org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceCriticality.NULL;
        }
    }

    static public org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceCriticality convertAllergyIntoleranceCriticality(org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceCriticality src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case LOW:
                return org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceCriticality.LOW;
            case HIGH:
                return org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceCriticality.HIGH;
            case UNABLETOASSESS:
                return org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceCriticality.UNABLETOASSESS;
            default:
                return org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceCriticality.NULL;
        }
    }

    public static org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceReactionComponent convertAllergyIntoleranceReactionComponent(org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceReactionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceReactionComponent tgt = new org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceReactionComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasSubstance())
            tgt.setSubstance(VersionConvertor_30_50.convertCodeableConcept(src.getSubstance()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getManifestation()) tgt.addManifestation(VersionConvertor_30_50.convertCodeableConcept(t));
        if (src.hasDescription())
            tgt.setDescriptionElement(VersionConvertor_30_50.convertString(src.getDescriptionElement()));
        if (src.hasOnset())
            tgt.setOnsetElement(VersionConvertor_30_50.convertDateTime(src.getOnsetElement()));
        if (src.hasSeverity())
            tgt.setSeverity(convertAllergyIntoleranceSeverity(src.getSeverity()));
        if (src.hasExposureRoute())
            tgt.setExposureRoute(VersionConvertor_30_50.convertCodeableConcept(src.getExposureRoute()));
        for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.addNote(VersionConvertor_30_50.convertAnnotation(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceReactionComponent convertAllergyIntoleranceReactionComponent(org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceReactionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceReactionComponent tgt = new org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceReactionComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasSubstance())
            tgt.setSubstance(VersionConvertor_30_50.convertCodeableConcept(src.getSubstance()));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getManifestation()) tgt.addManifestation(VersionConvertor_30_50.convertCodeableConcept(t));
        if (src.hasDescription())
            tgt.setDescriptionElement(VersionConvertor_30_50.convertString(src.getDescriptionElement()));
        if (src.hasOnset())
            tgt.setOnsetElement(VersionConvertor_30_50.convertDateTime(src.getOnsetElement()));
        if (src.hasSeverity())
            tgt.setSeverity(convertAllergyIntoleranceSeverity(src.getSeverity()));
        if (src.hasExposureRoute())
            tgt.setExposureRoute(VersionConvertor_30_50.convertCodeableConcept(src.getExposureRoute()));
        for (org.hl7.fhir.dstu3.model.Annotation t : src.getNote()) tgt.addNote(VersionConvertor_30_50.convertAnnotation(t));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceSeverity convertAllergyIntoleranceSeverity(org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceSeverity src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case MILD:
                return org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceSeverity.MILD;
            case MODERATE:
                return org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceSeverity.MODERATE;
            case SEVERE:
                return org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceSeverity.SEVERE;
            default:
                return org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceSeverity.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceSeverity convertAllergyIntoleranceSeverity(org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceSeverity src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case MILD:
                return org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceSeverity.MILD;
            case MODERATE:
                return org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceSeverity.MODERATE;
            case SEVERE:
                return org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceSeverity.SEVERE;
            default:
                return org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceSeverity.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceType convertAllergyIntoleranceType(org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case ALLERGY:
                return org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceType.ALLERGY;
            case INTOLERANCE:
                return org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceType.INTOLERANCE;
            default:
                return org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceType.NULL;
        }
    }

    static public org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceType convertAllergyIntoleranceType(org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case ALLERGY:
                return org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceType.ALLERGY;
            case INTOLERANCE:
                return org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceType.INTOLERANCE;
            default:
                return org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceType.NULL;
        }
    }

    static public org.hl7.fhir.r5.model.CodeableConcept convertAllergyIntoleranceVerificationStatus(org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceVerificationStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case UNCONFIRMED:
                return new org.hl7.fhir.r5.model.CodeableConcept(new org.hl7.fhir.r5.model.Coding().setSystem("http://terminology.hl7.org/CodeSystem/allergyintolerance-verification").setCode("unconfirmed"));
            case CONFIRMED:
                return new org.hl7.fhir.r5.model.CodeableConcept(new org.hl7.fhir.r5.model.Coding().setSystem("http://terminology.hl7.org/CodeSystem/allergyintolerance-verification").setCode("confirmed"));
            case REFUTED:
                return new org.hl7.fhir.r5.model.CodeableConcept(new org.hl7.fhir.r5.model.Coding().setSystem("http://terminology.hl7.org/CodeSystem/allergyintolerance-verification").setCode("refuted"));
            case ENTEREDINERROR:
                return new org.hl7.fhir.r5.model.CodeableConcept(new org.hl7.fhir.r5.model.Coding().setSystem("http://terminology.hl7.org/CodeSystem/allergyintolerance-verification").setCode("entered-in-error"));
            default:
                return null;
        }
    }

    static public org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceVerificationStatus convertAllergyIntoleranceVerificationStatus(org.hl7.fhir.r5.model.CodeableConcept src) throws FHIRException {
        if (src == null)
            return null;
        if (src.hasCoding("http://terminology.hl7.org/CodeSystem/allergyintolerance-verification", "unconfirmed"))
            return org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceVerificationStatus.UNCONFIRMED;
        if (src.hasCoding("http://terminology.hl7.org/CodeSystem/allergyintolerance-verification", "confirmed"))
            return org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceVerificationStatus.CONFIRMED;
        if (src.hasCoding("http://terminology.hl7.org/CodeSystem/allergyintolerance-verification", "refuted"))
            return org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceVerificationStatus.REFUTED;
        if (src.hasCoding("http://terminology.hl7.org/CodeSystem/allergyintolerance-verification", "entered-in-error"))
            return org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceVerificationStatus.ENTEREDINERROR;
        return org.hl7.fhir.dstu3.model.AllergyIntolerance.AllergyIntoleranceVerificationStatus.NULL;
    }
}
