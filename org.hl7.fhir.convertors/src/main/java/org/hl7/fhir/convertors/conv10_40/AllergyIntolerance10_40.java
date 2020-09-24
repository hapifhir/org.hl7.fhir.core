package org.hl7.fhir.convertors.conv10_40;

import org.hl7.fhir.convertors.VersionConvertor_10_40;
import org.hl7.fhir.dstu2.model.AllergyIntolerance;
import org.hl7.fhir.exceptions.FHIRException;

public class AllergyIntolerance10_40 {
    public static org.hl7.fhir.r4.model.AllergyIntolerance convertAllergyIntolerance(org.hl7.fhir.dstu2.model.AllergyIntolerance src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.AllergyIntolerance tgt = new org.hl7.fhir.r4.model.AllergyIntolerance();
        VersionConvertor_10_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_40.convertIdentifier(t));
        if (src.hasOnset())
            tgt.setOnset(VersionConvertor_10_40.convertType(src.getOnsetElement()));
        if (src.hasRecordedDate())
            tgt.setRecordedDateElement(VersionConvertor_10_40.convertDateTime(src.getRecordedDateElement()));
        if (src.hasRecorder())
            tgt.setRecorder(VersionConvertor_10_40.convertReference(src.getRecorder()));
        if (src.hasPatient())
            tgt.setPatient(VersionConvertor_10_40.convertReference(src.getPatient()));
        if (src.hasReporter())
            tgt.setAsserter(VersionConvertor_10_40.convertReference(src.getReporter()));
        if (src.hasSubstance())
            tgt.setCode(VersionConvertor_10_40.convertCodeableConcept(src.getSubstance()));
        if (src.hasStatus()) {
            if (src.getStatus() != org.hl7.fhir.dstu2.model.AllergyIntolerance.AllergyIntoleranceStatus.REFUTED
                    && src.getStatus() != org.hl7.fhir.dstu2.model.AllergyIntolerance.AllergyIntoleranceStatus.ENTEREDINERROR) {
                org.hl7.fhir.r4.model.Coding code = new org.hl7.fhir.r4.model.Coding();
                code.setSystem("http://terminology.hl7.org/CodeSystem/allergyintolerance-clinical");
                code.setCode(src.getStatus().toCode());
                tgt.setClinicalStatus(new org.hl7.fhir.r4.model.CodeableConcept(code));
            }
            if (src.getStatus() != org.hl7.fhir.dstu2.model.AllergyIntolerance.AllergyIntoleranceStatus.ACTIVE
                    && src.getStatus() != org.hl7.fhir.dstu2.model.AllergyIntolerance.AllergyIntoleranceStatus.RESOLVED) {
                org.hl7.fhir.r4.model.Coding code = new org.hl7.fhir.r4.model.Coding();
                code.setSystem("http://terminology.hl7.org/CodeSystem/allergyintolerance-verification");
                code.setCode(src.getStatus().toCode());
                tgt.setVerificationStatus(new org.hl7.fhir.r4.model.CodeableConcept(code));
            }
        }
        if (src.hasCriticality())
            tgt.setCriticality(translateAllergyIntoleranceCriticality(src.getCriticality()));
        if (src.hasType())
            tgt.setType(org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceType.fromCode(src.getType().toCode()));
        if (src.hasCategory())
            tgt.addCategory(org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceCategory.fromCode(src.getCategory().toCode()));
        if (src.hasLastOccurenceElement())
            tgt.setLastOccurrenceElement(VersionConvertor_10_40.convertDateTime(src.getLastOccurenceElement()));
        if (src.hasNote())
            tgt.addNote(VersionConvertor_10_40.convertAnnotation(src.getNote()));
        for (org.hl7.fhir.dstu2.model.AllergyIntolerance.AllergyIntoleranceReactionComponent reaction : src.getReaction())
            tgt.addReaction(algReaction(reaction));
        return tgt;
    }

    private static org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceReactionComponent algReaction(AllergyIntolerance.AllergyIntoleranceReactionComponent src) {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceReactionComponent tgt = new org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceReactionComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        for (org.hl7.fhir.dstu2.model.Extension extension : src.getModifierExtension()) tgt.addExtension(VersionConvertor_10_40.convertExtension(extension));
        if (src.hasSubstance())
            tgt.setSubstance(VersionConvertor_10_40.convertCodeableConcept(src.getSubstance()));
        if (src.hasCertainty())
            tgt.addExtension(new org.hl7.fhir.r4.model.Extension(
                    "http://hl7.org/fhir/AllergyIntolerance-r2-certainty",
                    new org.hl7.fhir.r4.model.StringType(src.getCertainty().toCode())
            ));
        for (org.hl7.fhir.dstu2.model.CodeableConcept concept : src.getManifestation()) tgt.addManifestation(VersionConvertor_10_40.convertCodeableConcept(concept));
        if (src.hasDescription())
            tgt.setDescriptionElement(VersionConvertor_10_40.convertString(src.getDescriptionElement()));
        if (src.hasOnset())
            tgt.setOnsetElement(VersionConvertor_10_40.convertDateTime(src.getOnsetElement()));
        if (src.hasSeverity())
            tgt.setSeverity(org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceSeverity.fromCode(src.getSeverity().toCode()));
        if (src.hasExposureRoute())
            tgt.setExposureRoute(VersionConvertor_10_40.convertCodeableConcept(src.getExposureRoute()));
        if (src.hasNote())
            tgt.addNote(VersionConvertor_10_40.convertAnnotation(src.getNote()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceCriticality translateAllergyIntoleranceCriticality(org.hl7.fhir.dstu2.model.AllergyIntolerance.AllergyIntoleranceCriticality src) {
        switch(src) {
            case CRITL:
                return org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceCriticality.LOW;
            case CRITH:
                return org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceCriticality.HIGH;
            case CRITU:
                return org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceCriticality.UNABLETOASSESS;
            default:
                return org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceCriticality.NULL;
        }
    }
}
