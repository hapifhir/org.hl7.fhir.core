package org.hl7.fhir.convertors.conv10_30;

import org.hl7.fhir.convertors.VersionConvertor_10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class Observation10_30 {

    public static org.hl7.fhir.dstu3.model.Observation convertObservation(org.hl7.fhir.dstu2.model.Observation src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Observation tgt = new org.hl7.fhir.dstu3.model.Observation();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_30.convertIdentifier(t));
        tgt.setStatus(convertObservationStatus(src.getStatus()));
        tgt.addCategory(VersionConvertor_10_30.convertCodeableConcept(src.getCategory()));
        tgt.setCode(VersionConvertor_10_30.convertCodeableConcept(src.getCode()));
        tgt.setSubject(VersionConvertor_10_30.convertReference(src.getSubject()));
        tgt.setContext(VersionConvertor_10_30.convertReference(src.getEncounter()));
        tgt.setEffective(VersionConvertor_10_30.convertType(src.getEffective()));
        tgt.setIssued(src.getIssued());
        for (org.hl7.fhir.dstu2.model.Reference t : src.getPerformer()) tgt.addPerformer(VersionConvertor_10_30.convertReference(t));
        tgt.setValue(VersionConvertor_10_30.convertType(src.getValue()));
        tgt.setDataAbsentReason(VersionConvertor_10_30.convertCodeableConcept(src.getDataAbsentReason()));
        tgt.setInterpretation(VersionConvertor_10_30.convertCodeableConcept(src.getInterpretation()));
        tgt.setComment(src.getComments());
        tgt.setBodySite(VersionConvertor_10_30.convertCodeableConcept(src.getBodySite()));
        tgt.setMethod(VersionConvertor_10_30.convertCodeableConcept(src.getMethod()));
        tgt.setSpecimen(VersionConvertor_10_30.convertReference(src.getSpecimen()));
        tgt.setDevice(VersionConvertor_10_30.convertReference(src.getDevice()));
        for (org.hl7.fhir.dstu2.model.Observation.ObservationReferenceRangeComponent t : src.getReferenceRange()) tgt.addReferenceRange(convertObservationReferenceRangeComponent(t));
        for (org.hl7.fhir.dstu2.model.Observation.ObservationRelatedComponent t : src.getRelated()) tgt.addRelated(convertObservationRelatedComponent(t));
        for (org.hl7.fhir.dstu2.model.Observation.ObservationComponentComponent t : src.getComponent()) tgt.addComponent(convertObservationComponentComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Observation convertObservation(org.hl7.fhir.dstu3.model.Observation src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Observation tgt = new org.hl7.fhir.dstu2.model.Observation();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_30.convertIdentifier(t));
        tgt.setStatus(convertObservationStatus(src.getStatus()));
        for (org.hl7.fhir.dstu3.model.CodeableConcept c : src.getCategory()) tgt.setCategory(VersionConvertor_10_30.convertCodeableConcept(c));
        tgt.setCode(VersionConvertor_10_30.convertCodeableConcept(src.getCode()));
        tgt.setSubject(VersionConvertor_10_30.convertReference(src.getSubject()));
        tgt.setEncounter(VersionConvertor_10_30.convertReference(src.getContext()));
        tgt.setEffective(VersionConvertor_10_30.convertType(src.getEffective()));
        tgt.setIssued(src.getIssued());
        for (org.hl7.fhir.dstu3.model.Reference t : src.getPerformer()) tgt.addPerformer(VersionConvertor_10_30.convertReference(t));
        tgt.setValue(VersionConvertor_10_30.convertType(src.getValue()));
        tgt.setDataAbsentReason(VersionConvertor_10_30.convertCodeableConcept(src.getDataAbsentReason()));
        tgt.setInterpretation(VersionConvertor_10_30.convertCodeableConcept(src.getInterpretation()));
        tgt.setComments(src.getComment());
        tgt.setBodySite(VersionConvertor_10_30.convertCodeableConcept(src.getBodySite()));
        tgt.setMethod(VersionConvertor_10_30.convertCodeableConcept(src.getMethod()));
        tgt.setSpecimen(VersionConvertor_10_30.convertReference(src.getSpecimen()));
        tgt.setDevice(VersionConvertor_10_30.convertReference(src.getDevice()));
        for (org.hl7.fhir.dstu3.model.Observation.ObservationReferenceRangeComponent t : src.getReferenceRange()) tgt.addReferenceRange(convertObservationReferenceRangeComponent(t));
        for (org.hl7.fhir.dstu3.model.Observation.ObservationRelatedComponent t : src.getRelated()) tgt.addRelated(convertObservationRelatedComponent(t));
        for (org.hl7.fhir.dstu3.model.Observation.ObservationComponentComponent t : src.getComponent()) tgt.addComponent(convertObservationComponentComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Observation.ObservationComponentComponent convertObservationComponentComponent(org.hl7.fhir.dstu3.model.Observation.ObservationComponentComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Observation.ObservationComponentComponent tgt = new org.hl7.fhir.dstu2.model.Observation.ObservationComponentComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        tgt.setCode(VersionConvertor_10_30.convertCodeableConcept(src.getCode()));
        tgt.setValue(VersionConvertor_10_30.convertType(src.getValue()));
        tgt.setDataAbsentReason(VersionConvertor_10_30.convertCodeableConcept(src.getDataAbsentReason()));
        for (org.hl7.fhir.dstu3.model.Observation.ObservationReferenceRangeComponent t : src.getReferenceRange()) tgt.addReferenceRange(convertObservationReferenceRangeComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Observation.ObservationComponentComponent convertObservationComponentComponent(org.hl7.fhir.dstu2.model.Observation.ObservationComponentComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Observation.ObservationComponentComponent tgt = new org.hl7.fhir.dstu3.model.Observation.ObservationComponentComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        tgt.setCode(VersionConvertor_10_30.convertCodeableConcept(src.getCode()));
        tgt.setValue(VersionConvertor_10_30.convertType(src.getValue()));
        tgt.setDataAbsentReason(VersionConvertor_10_30.convertCodeableConcept(src.getDataAbsentReason()));
        for (org.hl7.fhir.dstu2.model.Observation.ObservationReferenceRangeComponent t : src.getReferenceRange()) tgt.addReferenceRange(convertObservationReferenceRangeComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Observation.ObservationReferenceRangeComponent convertObservationReferenceRangeComponent(org.hl7.fhir.dstu2.model.Observation.ObservationReferenceRangeComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Observation.ObservationReferenceRangeComponent tgt = new org.hl7.fhir.dstu3.model.Observation.ObservationReferenceRangeComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        tgt.setLow(VersionConvertor_10_30.convertSimpleQuantity(src.getLow()));
        tgt.setHigh(VersionConvertor_10_30.convertSimpleQuantity(src.getHigh()));
        tgt.setType(VersionConvertor_10_30.convertCodeableConcept(src.getMeaning()));
        tgt.setAge(VersionConvertor_10_30.convertRange(src.getAge()));
        tgt.setText(src.getText());
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Observation.ObservationReferenceRangeComponent convertObservationReferenceRangeComponent(org.hl7.fhir.dstu3.model.Observation.ObservationReferenceRangeComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Observation.ObservationReferenceRangeComponent tgt = new org.hl7.fhir.dstu2.model.Observation.ObservationReferenceRangeComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        tgt.setLow(VersionConvertor_10_30.convertSimpleQuantity(src.getLow()));
        tgt.setHigh(VersionConvertor_10_30.convertSimpleQuantity(src.getHigh()));
        tgt.setMeaning(VersionConvertor_10_30.convertCodeableConcept(src.getType()));
        tgt.setAge(VersionConvertor_10_30.convertRange(src.getAge()));
        tgt.setText(src.getText());
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Observation.ObservationRelatedComponent convertObservationRelatedComponent(org.hl7.fhir.dstu3.model.Observation.ObservationRelatedComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Observation.ObservationRelatedComponent tgt = new org.hl7.fhir.dstu2.model.Observation.ObservationRelatedComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        tgt.setType(convertObservationRelationshipType(src.getType()));
        tgt.setTarget(VersionConvertor_10_30.convertReference(src.getTarget()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Observation.ObservationRelatedComponent convertObservationRelatedComponent(org.hl7.fhir.dstu2.model.Observation.ObservationRelatedComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Observation.ObservationRelatedComponent tgt = new org.hl7.fhir.dstu3.model.Observation.ObservationRelatedComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        tgt.setType(convertObservationRelationshipType(src.getType()));
        tgt.setTarget(VersionConvertor_10_30.convertReference(src.getTarget()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Observation.ObservationRelationshipType convertObservationRelationshipType(org.hl7.fhir.dstu2.model.Observation.ObservationRelationshipType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case HASMEMBER:
                return org.hl7.fhir.dstu3.model.Observation.ObservationRelationshipType.HASMEMBER;
            case DERIVEDFROM:
                return org.hl7.fhir.dstu3.model.Observation.ObservationRelationshipType.DERIVEDFROM;
            case SEQUELTO:
                return org.hl7.fhir.dstu3.model.Observation.ObservationRelationshipType.SEQUELTO;
            case REPLACES:
                return org.hl7.fhir.dstu3.model.Observation.ObservationRelationshipType.REPLACES;
            case QUALIFIEDBY:
                return org.hl7.fhir.dstu3.model.Observation.ObservationRelationshipType.QUALIFIEDBY;
            case INTERFEREDBY:
                return org.hl7.fhir.dstu3.model.Observation.ObservationRelationshipType.INTERFEREDBY;
            default:
                return org.hl7.fhir.dstu3.model.Observation.ObservationRelationshipType.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.Observation.ObservationRelationshipType convertObservationRelationshipType(org.hl7.fhir.dstu3.model.Observation.ObservationRelationshipType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case HASMEMBER:
                return org.hl7.fhir.dstu2.model.Observation.ObservationRelationshipType.HASMEMBER;
            case DERIVEDFROM:
                return org.hl7.fhir.dstu2.model.Observation.ObservationRelationshipType.DERIVEDFROM;
            case SEQUELTO:
                return org.hl7.fhir.dstu2.model.Observation.ObservationRelationshipType.SEQUELTO;
            case REPLACES:
                return org.hl7.fhir.dstu2.model.Observation.ObservationRelationshipType.REPLACES;
            case QUALIFIEDBY:
                return org.hl7.fhir.dstu2.model.Observation.ObservationRelationshipType.QUALIFIEDBY;
            case INTERFEREDBY:
                return org.hl7.fhir.dstu2.model.Observation.ObservationRelationshipType.INTERFEREDBY;
            default:
                return org.hl7.fhir.dstu2.model.Observation.ObservationRelationshipType.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.Observation.ObservationStatus convertObservationStatus(org.hl7.fhir.dstu3.model.Observation.ObservationStatus src) throws FHIRException {
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

    public static org.hl7.fhir.dstu3.model.Observation.ObservationStatus convertObservationStatus(org.hl7.fhir.dstu2.model.Observation.ObservationStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case REGISTERED:
                return org.hl7.fhir.dstu3.model.Observation.ObservationStatus.REGISTERED;
            case PRELIMINARY:
                return org.hl7.fhir.dstu3.model.Observation.ObservationStatus.PRELIMINARY;
            case FINAL:
                return org.hl7.fhir.dstu3.model.Observation.ObservationStatus.FINAL;
            case AMENDED:
                return org.hl7.fhir.dstu3.model.Observation.ObservationStatus.AMENDED;
            case CANCELLED:
                return org.hl7.fhir.dstu3.model.Observation.ObservationStatus.CANCELLED;
            case ENTEREDINERROR:
                return org.hl7.fhir.dstu3.model.Observation.ObservationStatus.ENTEREDINERROR;
            case UNKNOWN:
                return org.hl7.fhir.dstu3.model.Observation.ObservationStatus.UNKNOWN;
            default:
                return org.hl7.fhir.dstu3.model.Observation.ObservationStatus.NULL;
        }
    }
}
