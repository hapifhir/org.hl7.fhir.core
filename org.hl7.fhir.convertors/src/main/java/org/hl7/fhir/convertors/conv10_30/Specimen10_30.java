package org.hl7.fhir.convertors.conv10_30;

import org.hl7.fhir.convertors.VersionConvertor_10_30;
import org.hl7.fhir.dstu3.model.Specimen;
import org.hl7.fhir.exceptions.FHIRException;

public class Specimen10_30 {

    static public org.hl7.fhir.dstu2.model.Specimen convertSpecimen(Specimen src) {
        if (src == null) {
            return null;
        }
        org.hl7.fhir.dstu2.model.Specimen tgt = new org.hl7.fhir.dstu2.model.Specimen();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_30.convertIdentifier(t));
        if (src.hasAccessionIdentifier())
            tgt.setAccessionIdentifier(VersionConvertor_10_30.convertIdentifier(src.getAccessionIdentifier()));
        if (src.hasStatus())
            tgt.setStatus(convertSpecimenStatus(src.getStatus()));
        if (src.hasType())
            tgt.setType(VersionConvertor_10_30.convertCodeableConcept(src.getType()));
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_10_30.convertReference(src.getSubject()));
        if (src.hasReceivedTime())
            tgt.setReceivedTime(src.getReceivedTime());
        for (org.hl7.fhir.dstu3.model.Reference t : src.getParent()) tgt.addParent(VersionConvertor_10_30.convertReference(t));
        if (src.hasCollection())
            tgt.setCollection(convertSpecimenCollectionComponent(src.getCollection()));
        for (org.hl7.fhir.dstu3.model.Specimen.SpecimenProcessingComponent t : src.getProcessing()) tgt.addTreatment(convertSpecimenProcessingComponent(t));
        for (org.hl7.fhir.dstu3.model.Specimen.SpecimenContainerComponent t : src.getContainer()) tgt.addContainer(convertSpecimenContainerComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Specimen.SpecimenCollectionComponent convertSpecimenCollectionComponent(org.hl7.fhir.dstu3.model.Specimen.SpecimenCollectionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu2.model.Specimen.SpecimenCollectionComponent tgt = new org.hl7.fhir.dstu2.model.Specimen.SpecimenCollectionComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasCollector())
            tgt.setCollector(VersionConvertor_10_30.convertReference(src.getCollector()));
        if (src.hasCollected())
            tgt.setCollected(VersionConvertor_10_30.convertType(src.getCollected()));
        if (src.hasQuantity())
            tgt.setQuantity(VersionConvertor_10_30.convertSimpleQuantity(src.getQuantity()));
        if (src.hasMethod())
            tgt.setMethod(VersionConvertor_10_30.convertCodeableConcept(src.getMethod()));
        if (src.hasBodySite())
            tgt.setBodySite(VersionConvertor_10_30.convertCodeableConcept(src.getBodySite()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Specimen.SpecimenContainerComponent convertSpecimenContainerComponent(org.hl7.fhir.dstu3.model.Specimen.SpecimenContainerComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu2.model.Specimen.SpecimenContainerComponent tgt = new org.hl7.fhir.dstu2.model.Specimen.SpecimenContainerComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_30.convertIdentifier(t));
        if (src.hasDescription())
            tgt.setDescriptionElement(VersionConvertor_10_30.convertString(src.getDescriptionElement()));
        if (src.hasType())
            tgt.setType(VersionConvertor_10_30.convertCodeableConcept(src.getType()));
        if (src.hasCapacity())
            tgt.setCapacity(VersionConvertor_10_30.convertSimpleQuantity(src.getCapacity()));
        if (src.hasSpecimenQuantity())
            tgt.setSpecimenQuantity(VersionConvertor_10_30.convertSimpleQuantity(src.getSpecimenQuantity()));
        if (src.hasAdditive())
            tgt.setAdditive(VersionConvertor_10_30.convertType(src.getAdditive()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Specimen.SpecimenTreatmentComponent convertSpecimenProcessingComponent(org.hl7.fhir.dstu3.model.Specimen.SpecimenProcessingComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu2.model.Specimen.SpecimenTreatmentComponent tgt = new org.hl7.fhir.dstu2.model.Specimen.SpecimenTreatmentComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasDescription())
            tgt.setDescriptionElement(VersionConvertor_10_30.convertString(src.getDescriptionElement()));
        if (src.hasProcedure())
            tgt.setProcedure(VersionConvertor_10_30.convertCodeableConcept(src.getProcedure()));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getAdditive()) tgt.addAdditive(VersionConvertor_10_30.convertReference(t));
        return tgt;
    }

    static public org.hl7.fhir.dstu2.model.Specimen.SpecimenStatus convertSpecimenStatus(Specimen.SpecimenStatus status) {
        if (status == null) {
            return null;
        }
        switch(status) {
            case AVAILABLE:
                return org.hl7.fhir.dstu2.model.Specimen.SpecimenStatus.AVAILABLE;
            case UNAVAILABLE:
                return org.hl7.fhir.dstu2.model.Specimen.SpecimenStatus.UNAVAILABLE;
            case ENTEREDINERROR:
                return org.hl7.fhir.dstu2.model.Specimen.SpecimenStatus.ENTEREDINERROR;
            case UNSATISFACTORY:
                return org.hl7.fhir.dstu2.model.Specimen.SpecimenStatus.UNSATISFACTORY;
            case NULL:
                return org.hl7.fhir.dstu2.model.Specimen.SpecimenStatus.NULL;
            default:
                return org.hl7.fhir.dstu2.model.Specimen.SpecimenStatus.NULL;
        }
    }
}