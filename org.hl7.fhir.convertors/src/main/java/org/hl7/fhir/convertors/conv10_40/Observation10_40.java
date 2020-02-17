package org.hl7.fhir.convertors.conv10_40;

import org.hl7.fhir.convertors.VersionConvertor_10_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Observation10_40 {

    public static org.hl7.fhir.dstu2.model.Observation convertObservation(org.hl7.fhir.r4.model.Observation src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Observation tgt = new org.hl7.fhir.dstu2.model.Observation();
        VersionConvertor_10_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_40.convertIdentifier(t));
        if (src.hasStatus())
            tgt.setStatus(convertObservationStatus(src.getStatus()));
        for (org.hl7.fhir.r4.model.CodeableConcept c : src.getCategory()) tgt.setCategory(VersionConvertor_10_40.convertCodeableConcept(c));
        if (src.hasCode())
            tgt.setCode(VersionConvertor_10_40.convertCodeableConcept(src.getCode()));
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_10_40.convertReference(src.getSubject()));
        if (src.hasEncounter())
            tgt.setEncounter(VersionConvertor_10_40.convertReference(src.getEncounter()));
        if (src.hasEffective())
            tgt.setEffective(VersionConvertor_10_40.convertType(src.getEffective()));
        if (src.hasIssuedElement())
            tgt.setIssuedElement(VersionConvertor_10_40.convertInstant(src.getIssuedElement()));
        for (org.hl7.fhir.r4.model.Reference t : src.getPerformer()) tgt.addPerformer(VersionConvertor_10_40.convertReference(t));
        if (src.hasValue())
            tgt.setValue(VersionConvertor_10_40.convertType(src.getValue()));
        if (src.hasDataAbsentReason())
            tgt.setDataAbsentReason(VersionConvertor_10_40.convertCodeableConcept(src.getDataAbsentReason()));
        if (src.hasInterpretation())
            tgt.setInterpretation(VersionConvertor_10_40.convertCodeableConcept(src.getInterpretationFirstRep()));
        if (src.hasNote())
            tgt.setComments(src.getNoteFirstRep().getText());
        if (src.hasBodySite())
            tgt.setBodySite(VersionConvertor_10_40.convertCodeableConcept(src.getBodySite()));
        if (src.hasMethod())
            tgt.setMethod(VersionConvertor_10_40.convertCodeableConcept(src.getMethod()));
        if (src.hasSpecimen())
            tgt.setSpecimen(VersionConvertor_10_40.convertReference(src.getSpecimen()));
        if (src.hasDevice())
            tgt.setDevice(VersionConvertor_10_40.convertReference(src.getDevice()));
        for (org.hl7.fhir.r4.model.Observation.ObservationReferenceRangeComponent t : src.getReferenceRange()) tgt.addReferenceRange(convertObservationReferenceRangeComponent(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getHasMember()) tgt.addRelated(convertObservationRelatedComponent(t, org.hl7.fhir.dstu2.model.Observation.ObservationRelationshipType.HASMEMBER));
        for (org.hl7.fhir.r4.model.Reference t : src.getDerivedFrom()) tgt.addRelated(convertObservationRelatedComponent(t, org.hl7.fhir.dstu2.model.Observation.ObservationRelationshipType.DERIVEDFROM));
        for (org.hl7.fhir.r4.model.Observation.ObservationComponentComponent t : src.getComponent()) tgt.addComponent(convertObservationComponentComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Observation convertObservation(org.hl7.fhir.dstu2.model.Observation src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Observation tgt = new org.hl7.fhir.r4.model.Observation();
        VersionConvertor_10_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_40.convertIdentifier(t));
        if (src.hasStatus())
            tgt.setStatus(convertObservationStatus(src.getStatus()));
        if (src.hasCategory())
            tgt.addCategory(VersionConvertor_10_40.convertCodeableConcept(src.getCategory()));
        if (src.hasCode())
            tgt.setCode(VersionConvertor_10_40.convertCodeableConcept(src.getCode()));
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_10_40.convertReference(src.getSubject()));
        if (src.hasEncounter())
            tgt.setEncounter(VersionConvertor_10_40.convertReference(src.getEncounter()));
        if (src.hasEffective())
            tgt.setEffective(VersionConvertor_10_40.convertType(src.getEffective()));
        if (src.hasIssuedElement())
            tgt.setIssuedElement(VersionConvertor_10_40.convertInstant(src.getIssuedElement()));
        for (org.hl7.fhir.dstu2.model.Reference t : src.getPerformer()) tgt.addPerformer(VersionConvertor_10_40.convertReference(t));
        if (src.hasValue())
            tgt.setValue(VersionConvertor_10_40.convertType(src.getValue()));
        if (src.hasDataAbsentReason())
            tgt.setDataAbsentReason(VersionConvertor_10_40.convertCodeableConcept(src.getDataAbsentReason()));
        if (src.hasInterpretation())
            tgt.addInterpretation(VersionConvertor_10_40.convertCodeableConcept(src.getInterpretation()));
        if (src.hasComments())
            tgt.addNote().setText(src.getComments());
        if (src.hasBodySite())
            tgt.setBodySite(VersionConvertor_10_40.convertCodeableConcept(src.getBodySite()));
        if (src.hasMethod())
            tgt.setMethod(VersionConvertor_10_40.convertCodeableConcept(src.getMethod()));
        if (src.hasSpecimen())
            tgt.setSpecimen(VersionConvertor_10_40.convertReference(src.getSpecimen()));
        if (src.hasDevice())
            tgt.setDevice(VersionConvertor_10_40.convertReference(src.getDevice()));
        for (org.hl7.fhir.dstu2.model.Observation.ObservationReferenceRangeComponent t : src.getReferenceRange()) tgt.addReferenceRange(convertObservationReferenceRangeComponent(t));
        for (org.hl7.fhir.dstu2.model.Observation.ObservationRelatedComponent t : src.getRelated()) if (t.getType() == org.hl7.fhir.dstu2.model.Observation.ObservationRelationshipType.HASMEMBER)
            tgt.addHasMember(VersionConvertor_10_40.convertReference(t.getTarget()));
        else if (t.getType() == org.hl7.fhir.dstu2.model.Observation.ObservationRelationshipType.DERIVEDFROM)
            tgt.addDerivedFrom(VersionConvertor_10_40.convertReference(t.getTarget()));
        for (org.hl7.fhir.dstu2.model.Observation.ObservationComponentComponent t : src.getComponent()) tgt.addComponent(convertObservationComponentComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Observation.ObservationComponentComponent convertObservationComponentComponent(org.hl7.fhir.r4.model.Observation.ObservationComponentComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Observation.ObservationComponentComponent tgt = new org.hl7.fhir.dstu2.model.Observation.ObservationComponentComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCode(VersionConvertor_10_40.convertCodeableConcept(src.getCode()));
        if (src.hasValue())
            tgt.setValue(VersionConvertor_10_40.convertType(src.getValue()));
        if (src.hasDataAbsentReason())
            tgt.setDataAbsentReason(VersionConvertor_10_40.convertCodeableConcept(src.getDataAbsentReason()));
        for (org.hl7.fhir.r4.model.Observation.ObservationReferenceRangeComponent t : src.getReferenceRange()) tgt.addReferenceRange(convertObservationReferenceRangeComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Observation.ObservationComponentComponent convertObservationComponentComponent(org.hl7.fhir.dstu2.model.Observation.ObservationComponentComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Observation.ObservationComponentComponent tgt = new org.hl7.fhir.r4.model.Observation.ObservationComponentComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCode(VersionConvertor_10_40.convertCodeableConcept(src.getCode()));
        if (src.hasValue())
            tgt.setValue(VersionConvertor_10_40.convertType(src.getValue()));
        if (src.hasDataAbsentReason())
            tgt.setDataAbsentReason(VersionConvertor_10_40.convertCodeableConcept(src.getDataAbsentReason()));
        for (org.hl7.fhir.dstu2.model.Observation.ObservationReferenceRangeComponent t : src.getReferenceRange()) tgt.addReferenceRange(convertObservationReferenceRangeComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Observation.ObservationReferenceRangeComponent convertObservationReferenceRangeComponent(org.hl7.fhir.dstu2.model.Observation.ObservationReferenceRangeComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Observation.ObservationReferenceRangeComponent tgt = new org.hl7.fhir.r4.model.Observation.ObservationReferenceRangeComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        if (src.hasLow())
            tgt.setLow(VersionConvertor_10_40.convertSimpleQuantity(src.getLow()));
        if (src.hasHigh())
            tgt.setHigh(VersionConvertor_10_40.convertSimpleQuantity(src.getHigh()));
        if (src.hasMeaning())
            tgt.setType(VersionConvertor_10_40.convertCodeableConcept(src.getMeaning()));
        if (src.hasAge())
            tgt.setAge(VersionConvertor_10_40.convertRange(src.getAge()));
        if (src.hasTextElement())
            tgt.setTextElement(VersionConvertor_10_40.convertString(src.getTextElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Observation.ObservationReferenceRangeComponent convertObservationReferenceRangeComponent(org.hl7.fhir.r4.model.Observation.ObservationReferenceRangeComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Observation.ObservationReferenceRangeComponent tgt = new org.hl7.fhir.dstu2.model.Observation.ObservationReferenceRangeComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        if (src.hasLow())
            tgt.setLow(VersionConvertor_10_40.convertSimpleQuantity(src.getLow()));
        if (src.hasHigh())
            tgt.setHigh(VersionConvertor_10_40.convertSimpleQuantity(src.getHigh()));
        if (src.hasType())
            tgt.setMeaning(VersionConvertor_10_40.convertCodeableConcept(src.getType()));
        if (src.hasAge())
            tgt.setAge(VersionConvertor_10_40.convertRange(src.getAge()));
        if (src.hasTextElement())
            tgt.setTextElement(VersionConvertor_10_40.convertString(src.getTextElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Observation.ObservationRelatedComponent convertObservationRelatedComponent(org.hl7.fhir.r4.model.Reference src, org.hl7.fhir.dstu2.model.Observation.ObservationRelationshipType type) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu2.model.Observation.ObservationRelatedComponent tgt = new org.hl7.fhir.dstu2.model.Observation.ObservationRelatedComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        tgt.setType(type);
        tgt.setTarget(VersionConvertor_10_40.convertReference(src));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Observation.ObservationStatus convertObservationStatus(org.hl7.fhir.r4.model.Observation.ObservationStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case REGISTERED:
                return org.hl7.fhir.dstu2.model.Observation.ObservationStatus.REGISTERED;
            case PRELIMINARY:
                return org.hl7.fhir.dstu2.model.Observation.ObservationStatus.PRELIMINARY;
            case FINAL:
                return org.hl7.fhir.dstu2.model.Observation.ObservationStatus.FINAL;
            case AMENDED:
                return org.hl7.fhir.dstu2.model.Observation.ObservationStatus.AMENDED;
            case CANCELLED:
                return org.hl7.fhir.dstu2.model.Observation.ObservationStatus.CANCELLED;
            case ENTEREDINERROR:
                return org.hl7.fhir.dstu2.model.Observation.ObservationStatus.ENTEREDINERROR;
            case UNKNOWN:
                return org.hl7.fhir.dstu2.model.Observation.ObservationStatus.UNKNOWN;
            default:
                return org.hl7.fhir.dstu2.model.Observation.ObservationStatus.NULL;
        }
    }

    public static org.hl7.fhir.r4.model.Observation.ObservationStatus convertObservationStatus(org.hl7.fhir.dstu2.model.Observation.ObservationStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case REGISTERED:
                return org.hl7.fhir.r4.model.Observation.ObservationStatus.REGISTERED;
            case PRELIMINARY:
                return org.hl7.fhir.r4.model.Observation.ObservationStatus.PRELIMINARY;
            case FINAL:
                return org.hl7.fhir.r4.model.Observation.ObservationStatus.FINAL;
            case AMENDED:
                return org.hl7.fhir.r4.model.Observation.ObservationStatus.AMENDED;
            case CANCELLED:
                return org.hl7.fhir.r4.model.Observation.ObservationStatus.CANCELLED;
            case ENTEREDINERROR:
                return org.hl7.fhir.r4.model.Observation.ObservationStatus.ENTEREDINERROR;
            case UNKNOWN:
                return org.hl7.fhir.r4.model.Observation.ObservationStatus.UNKNOWN;
            default:
                return org.hl7.fhir.r4.model.Observation.ObservationStatus.NULL;
        }
    }
}
