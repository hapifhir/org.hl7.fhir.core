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
        if (src.hasStatus())
            tgt.setStatusElement(convertObservationStatus(src.getStatusElement()));
        if (src.hasCategory())
            tgt.addCategory(VersionConvertor_10_30.convertCodeableConcept(src.getCategory()));
        if (src.hasCode())
            tgt.setCode(VersionConvertor_10_30.convertCodeableConcept(src.getCode()));
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_10_30.convertReference(src.getSubject()));
        if (src.hasEncounter())
            tgt.setContext(VersionConvertor_10_30.convertReference(src.getEncounter()));
        if (src.hasEffective())
            tgt.setEffective(VersionConvertor_10_30.convertType(src.getEffective()));
        if (src.hasIssuedElement())
            tgt.setIssuedElement(VersionConvertor_10_30.convertInstant(src.getIssuedElement()));
        for (org.hl7.fhir.dstu2.model.Reference t : src.getPerformer()) tgt.addPerformer(VersionConvertor_10_30.convertReference(t));
        if (src.hasValue())
            tgt.setValue(VersionConvertor_10_30.convertType(src.getValue()));
        if (src.hasDataAbsentReason())
            tgt.setDataAbsentReason(VersionConvertor_10_30.convertCodeableConcept(src.getDataAbsentReason()));
        if (src.hasInterpretation())
            tgt.setInterpretation(VersionConvertor_10_30.convertCodeableConcept(src.getInterpretation()));
        if (src.hasCommentsElement())
            tgt.setCommentElement(VersionConvertor_10_30.convertString(src.getCommentsElement()));
        if (src.hasBodySite())
            tgt.setBodySite(VersionConvertor_10_30.convertCodeableConcept(src.getBodySite()));
        if (src.hasMethod())
            tgt.setMethod(VersionConvertor_10_30.convertCodeableConcept(src.getMethod()));
        if (src.hasSpecimen())
            tgt.setSpecimen(VersionConvertor_10_30.convertReference(src.getSpecimen()));
        if (src.hasDevice())
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
        if (src.hasStatus())
            tgt.setStatusElement(convertObservationStatus(src.getStatusElement()));
        for (org.hl7.fhir.dstu3.model.CodeableConcept c : src.getCategory()) tgt.setCategory(VersionConvertor_10_30.convertCodeableConcept(c));
        if (src.hasCode())
            tgt.setCode(VersionConvertor_10_30.convertCodeableConcept(src.getCode()));
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_10_30.convertReference(src.getSubject()));
        if (src.hasContext())
            tgt.setEncounter(VersionConvertor_10_30.convertReference(src.getContext()));
        if (src.hasEffective())
            tgt.setEffective(VersionConvertor_10_30.convertType(src.getEffective()));
        if (src.hasIssuedElement())
            tgt.setIssuedElement(VersionConvertor_10_30.convertInstant(src.getIssuedElement()));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getPerformer()) tgt.addPerformer(VersionConvertor_10_30.convertReference(t));
        if (src.hasValue())
            tgt.setValue(VersionConvertor_10_30.convertType(src.getValue()));
        if (src.hasDataAbsentReason())
            tgt.setDataAbsentReason(VersionConvertor_10_30.convertCodeableConcept(src.getDataAbsentReason()));
        if (src.hasInterpretation())
            tgt.setInterpretation(VersionConvertor_10_30.convertCodeableConcept(src.getInterpretation()));
        if (src.hasCommentElement())
            tgt.setCommentsElement(VersionConvertor_10_30.convertString(src.getCommentElement()));
        if (src.hasBodySite())
            tgt.setBodySite(VersionConvertor_10_30.convertCodeableConcept(src.getBodySite()));
        if (src.hasMethod())
            tgt.setMethod(VersionConvertor_10_30.convertCodeableConcept(src.getMethod()));
        if (src.hasSpecimen())
            tgt.setSpecimen(VersionConvertor_10_30.convertReference(src.getSpecimen()));
        if (src.hasDevice())
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
        if (src.hasCode())
            tgt.setCode(VersionConvertor_10_30.convertCodeableConcept(src.getCode()));
        if (src.hasValue())
            tgt.setValue(VersionConvertor_10_30.convertType(src.getValue()));
        if (src.hasDataAbsentReason())
            tgt.setDataAbsentReason(VersionConvertor_10_30.convertCodeableConcept(src.getDataAbsentReason()));
        for (org.hl7.fhir.dstu3.model.Observation.ObservationReferenceRangeComponent t : src.getReferenceRange()) tgt.addReferenceRange(convertObservationReferenceRangeComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Observation.ObservationComponentComponent convertObservationComponentComponent(org.hl7.fhir.dstu2.model.Observation.ObservationComponentComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Observation.ObservationComponentComponent tgt = new org.hl7.fhir.dstu3.model.Observation.ObservationComponentComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCode(VersionConvertor_10_30.convertCodeableConcept(src.getCode()));
        if (src.hasValue())
            tgt.setValue(VersionConvertor_10_30.convertType(src.getValue()));
        if (src.hasDataAbsentReason())
            tgt.setDataAbsentReason(VersionConvertor_10_30.convertCodeableConcept(src.getDataAbsentReason()));
        for (org.hl7.fhir.dstu2.model.Observation.ObservationReferenceRangeComponent t : src.getReferenceRange()) tgt.addReferenceRange(convertObservationReferenceRangeComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Observation.ObservationReferenceRangeComponent convertObservationReferenceRangeComponent(org.hl7.fhir.dstu2.model.Observation.ObservationReferenceRangeComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Observation.ObservationReferenceRangeComponent tgt = new org.hl7.fhir.dstu3.model.Observation.ObservationReferenceRangeComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasLow())
            tgt.setLow(VersionConvertor_10_30.convertSimpleQuantity(src.getLow()));
        if (src.hasHigh())
            tgt.setHigh(VersionConvertor_10_30.convertSimpleQuantity(src.getHigh()));
        if (src.hasMeaning())
            tgt.setType(VersionConvertor_10_30.convertCodeableConcept(src.getMeaning()));
        if (src.hasAge())
            tgt.setAge(VersionConvertor_10_30.convertRange(src.getAge()));
        if (src.hasTextElement())
            tgt.setTextElement(VersionConvertor_10_30.convertString(src.getTextElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Observation.ObservationReferenceRangeComponent convertObservationReferenceRangeComponent(org.hl7.fhir.dstu3.model.Observation.ObservationReferenceRangeComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Observation.ObservationReferenceRangeComponent tgt = new org.hl7.fhir.dstu2.model.Observation.ObservationReferenceRangeComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasLow())
            tgt.setLow(VersionConvertor_10_30.convertSimpleQuantity(src.getLow()));
        if (src.hasHigh())
            tgt.setHigh(VersionConvertor_10_30.convertSimpleQuantity(src.getHigh()));
        if (src.hasType())
            tgt.setMeaning(VersionConvertor_10_30.convertCodeableConcept(src.getType()));
        if (src.hasAge())
            tgt.setAge(VersionConvertor_10_30.convertRange(src.getAge()));
        if (src.hasTextElement())
            tgt.setTextElement(VersionConvertor_10_30.convertString(src.getTextElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Observation.ObservationRelatedComponent convertObservationRelatedComponent(org.hl7.fhir.dstu3.model.Observation.ObservationRelatedComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Observation.ObservationRelatedComponent tgt = new org.hl7.fhir.dstu2.model.Observation.ObservationRelatedComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasType())
            tgt.setTypeElement(convertObservationRelationshipType(src.getTypeElement()));
        if (src.hasTarget())
            tgt.setTarget(VersionConvertor_10_30.convertReference(src.getTarget()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Observation.ObservationRelatedComponent convertObservationRelatedComponent(org.hl7.fhir.dstu2.model.Observation.ObservationRelatedComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Observation.ObservationRelatedComponent tgt = new org.hl7.fhir.dstu3.model.Observation.ObservationRelatedComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasType())
            tgt.setTypeElement(convertObservationRelationshipType(src.getTypeElement()));
        if (src.hasTarget())
            tgt.setTarget(VersionConvertor_10_30.convertReference(src.getTarget()));
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Observation.ObservationRelationshipType> convertObservationRelationshipType(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Observation.ObservationRelationshipType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Observation.ObservationRelationshipType> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Observation.ObservationRelationshipTypeEnumFactory());
        VersionConvertor_10_30.copyElement(src, tgt);
        switch(src.getValue()) {
            case HASMEMBER:
                tgt.setValue(org.hl7.fhir.dstu3.model.Observation.ObservationRelationshipType.HASMEMBER);
                break;
            case DERIVEDFROM:
                tgt.setValue(org.hl7.fhir.dstu3.model.Observation.ObservationRelationshipType.DERIVEDFROM);
                break;
            case SEQUELTO:
                tgt.setValue(org.hl7.fhir.dstu3.model.Observation.ObservationRelationshipType.SEQUELTO);
                break;
            case REPLACES:
                tgt.setValue(org.hl7.fhir.dstu3.model.Observation.ObservationRelationshipType.REPLACES);
                break;
            case QUALIFIEDBY:
                tgt.setValue(org.hl7.fhir.dstu3.model.Observation.ObservationRelationshipType.QUALIFIEDBY);
                break;
            case INTERFEREDBY:
                tgt.setValue(org.hl7.fhir.dstu3.model.Observation.ObservationRelationshipType.INTERFEREDBY);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.Observation.ObservationRelationshipType.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Observation.ObservationRelationshipType> convertObservationRelationshipType(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Observation.ObservationRelationshipType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Observation.ObservationRelationshipType> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Observation.ObservationRelationshipTypeEnumFactory());
        VersionConvertor_10_30.copyElement(src, tgt);
        switch(src.getValue()) {
            case HASMEMBER:
                tgt.setValue(org.hl7.fhir.dstu2.model.Observation.ObservationRelationshipType.HASMEMBER);
                break;
            case DERIVEDFROM:
                tgt.setValue(org.hl7.fhir.dstu2.model.Observation.ObservationRelationshipType.DERIVEDFROM);
                break;
            case SEQUELTO:
                tgt.setValue(org.hl7.fhir.dstu2.model.Observation.ObservationRelationshipType.SEQUELTO);
                break;
            case REPLACES:
                tgt.setValue(org.hl7.fhir.dstu2.model.Observation.ObservationRelationshipType.REPLACES);
                break;
            case QUALIFIEDBY:
                tgt.setValue(org.hl7.fhir.dstu2.model.Observation.ObservationRelationshipType.QUALIFIEDBY);
                break;
            case INTERFEREDBY:
                tgt.setValue(org.hl7.fhir.dstu2.model.Observation.ObservationRelationshipType.INTERFEREDBY);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2.model.Observation.ObservationRelationshipType.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Observation.ObservationStatus> convertObservationStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Observation.ObservationStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Observation.ObservationStatus> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Observation.ObservationStatusEnumFactory());
        VersionConvertor_10_30.copyElement(src, tgt);
        switch(src.getValue()) {
            case REGISTERED:
                tgt.setValue(org.hl7.fhir.dstu2.model.Observation.ObservationStatus.REGISTERED);
                break;
            case PRELIMINARY:
                tgt.setValue(org.hl7.fhir.dstu2.model.Observation.ObservationStatus.PRELIMINARY);
                break;
            case FINAL:
                tgt.setValue(org.hl7.fhir.dstu2.model.Observation.ObservationStatus.FINAL);
                break;
            case AMENDED:
                tgt.setValue(org.hl7.fhir.dstu2.model.Observation.ObservationStatus.AMENDED);
                break;
            case CANCELLED:
                tgt.setValue(org.hl7.fhir.dstu2.model.Observation.ObservationStatus.CANCELLED);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.dstu2.model.Observation.ObservationStatus.ENTEREDINERROR);
                break;
            case UNKNOWN:
                tgt.setValue(org.hl7.fhir.dstu2.model.Observation.ObservationStatus.UNKNOWN);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2.model.Observation.ObservationStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Observation.ObservationStatus> convertObservationStatus(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Observation.ObservationStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Observation.ObservationStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Observation.ObservationStatusEnumFactory());
        VersionConvertor_10_30.copyElement(src, tgt);
        switch(src.getValue()) {
            case REGISTERED:
                tgt.setValue(org.hl7.fhir.dstu3.model.Observation.ObservationStatus.REGISTERED);
                break;
            case PRELIMINARY:
                tgt.setValue(org.hl7.fhir.dstu3.model.Observation.ObservationStatus.PRELIMINARY);
                break;
            case FINAL:
                tgt.setValue(org.hl7.fhir.dstu3.model.Observation.ObservationStatus.FINAL);
                break;
            case AMENDED:
                tgt.setValue(org.hl7.fhir.dstu3.model.Observation.ObservationStatus.AMENDED);
                break;
            case CANCELLED:
                tgt.setValue(org.hl7.fhir.dstu3.model.Observation.ObservationStatus.CANCELLED);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.dstu3.model.Observation.ObservationStatus.ENTEREDINERROR);
                break;
            case UNKNOWN:
                tgt.setValue(org.hl7.fhir.dstu3.model.Observation.ObservationStatus.UNKNOWN);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.Observation.ObservationStatus.NULL);
                break;
        }
        return tgt;
    }
}