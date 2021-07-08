package org.hl7.fhir.convertors.conv30_40.resources30_40;

import org.hl7.fhir.convertors.conv30_40.VersionConvertor_30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Element30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Type30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.*;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.DateTime30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.String30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Reference30_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Specimen30_40 {

    public static org.hl7.fhir.r4.model.Specimen convertSpecimen(org.hl7.fhir.dstu3.model.Specimen src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Specimen tgt = new org.hl7.fhir.r4.model.Specimen();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(Identifier30_40.convertIdentifier(t));
        if (src.hasAccessionIdentifier())
            tgt.setAccessionIdentifier(Identifier30_40.convertIdentifier(src.getAccessionIdentifier()));
        if (src.hasStatus())
            tgt.setStatusElement(convertSpecimenStatus(src.getStatusElement()));
        if (src.hasType())
            tgt.setType(CodeableConcept30_40.convertCodeableConcept(src.getType()));
        if (src.hasSubject())
            tgt.setSubject(Reference30_40.convertReference(src.getSubject()));
        if (src.hasReceivedTime())
            tgt.setReceivedTimeElement(DateTime30_40.convertDateTime(src.getReceivedTimeElement()));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getParent()) tgt.addParent(Reference30_40.convertReference(t));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getRequest()) tgt.addRequest(Reference30_40.convertReference(t));
        if (src.hasCollection())
            tgt.setCollection(convertSpecimenCollectionComponent(src.getCollection()));
        for (org.hl7.fhir.dstu3.model.Specimen.SpecimenProcessingComponent t : src.getProcessing()) tgt.addProcessing(convertSpecimenProcessingComponent(t));
        for (org.hl7.fhir.dstu3.model.Specimen.SpecimenContainerComponent t : src.getContainer()) tgt.addContainer(convertSpecimenContainerComponent(t));
        for (org.hl7.fhir.dstu3.model.Annotation t : src.getNote()) tgt.addNote(Annotation30_40.convertAnnotation(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Specimen convertSpecimen(org.hl7.fhir.r4.model.Specimen src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Specimen tgt = new org.hl7.fhir.dstu3.model.Specimen();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(Identifier30_40.convertIdentifier(t));
        if (src.hasAccessionIdentifier())
            tgt.setAccessionIdentifier(Identifier30_40.convertIdentifier(src.getAccessionIdentifier()));
        if (src.hasStatus())
            tgt.setStatusElement(convertSpecimenStatus(src.getStatusElement()));
        if (src.hasType())
            tgt.setType(CodeableConcept30_40.convertCodeableConcept(src.getType()));
        if (src.hasSubject())
            tgt.setSubject(Reference30_40.convertReference(src.getSubject()));
        if (src.hasReceivedTime())
            tgt.setReceivedTimeElement(DateTime30_40.convertDateTime(src.getReceivedTimeElement()));
        for (org.hl7.fhir.r4.model.Reference t : src.getParent()) tgt.addParent(Reference30_40.convertReference(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getRequest()) tgt.addRequest(Reference30_40.convertReference(t));
        if (src.hasCollection())
            tgt.setCollection(convertSpecimenCollectionComponent(src.getCollection()));
        for (org.hl7.fhir.r4.model.Specimen.SpecimenProcessingComponent t : src.getProcessing()) tgt.addProcessing(convertSpecimenProcessingComponent(t));
        for (org.hl7.fhir.r4.model.Specimen.SpecimenContainerComponent t : src.getContainer()) tgt.addContainer(convertSpecimenContainerComponent(t));
        for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.addNote(Annotation30_40.convertAnnotation(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Specimen.SpecimenCollectionComponent convertSpecimenCollectionComponent(org.hl7.fhir.r4.model.Specimen.SpecimenCollectionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Specimen.SpecimenCollectionComponent tgt = new org.hl7.fhir.dstu3.model.Specimen.SpecimenCollectionComponent();
        Element30_40.copyElement(src, tgt);
        if (src.hasCollector())
            tgt.setCollector(Reference30_40.convertReference(src.getCollector()));
        if (src.hasCollected())
            tgt.setCollected(Type30_40.convertType(src.getCollected()));
        if (src.hasQuantity())
            tgt.setQuantity(SimpleQuantity30_40.convertSimpleQuantity(src.getQuantity()));
        if (src.hasMethod())
            tgt.setMethod(CodeableConcept30_40.convertCodeableConcept(src.getMethod()));
        if (src.hasBodySite())
            tgt.setBodySite(CodeableConcept30_40.convertCodeableConcept(src.getBodySite()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Specimen.SpecimenCollectionComponent convertSpecimenCollectionComponent(org.hl7.fhir.dstu3.model.Specimen.SpecimenCollectionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Specimen.SpecimenCollectionComponent tgt = new org.hl7.fhir.r4.model.Specimen.SpecimenCollectionComponent();
        Element30_40.copyElement(src, tgt);
        if (src.hasCollector())
            tgt.setCollector(Reference30_40.convertReference(src.getCollector()));
        if (src.hasCollected())
            tgt.setCollected(Type30_40.convertType(src.getCollected()));
        if (src.hasQuantity())
            tgt.setQuantity(SimpleQuantity30_40.convertSimpleQuantity(src.getQuantity()));
        if (src.hasMethod())
            tgt.setMethod(CodeableConcept30_40.convertCodeableConcept(src.getMethod()));
        if (src.hasBodySite())
            tgt.setBodySite(CodeableConcept30_40.convertCodeableConcept(src.getBodySite()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Specimen.SpecimenContainerComponent convertSpecimenContainerComponent(org.hl7.fhir.r4.model.Specimen.SpecimenContainerComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Specimen.SpecimenContainerComponent tgt = new org.hl7.fhir.dstu3.model.Specimen.SpecimenContainerComponent();
        Element30_40.copyElement(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(Identifier30_40.convertIdentifier(t));
        if (src.hasDescription())
            tgt.setDescriptionElement(String30_40.convertString(src.getDescriptionElement()));
        if (src.hasType())
            tgt.setType(CodeableConcept30_40.convertCodeableConcept(src.getType()));
        if (src.hasCapacity())
            tgt.setCapacity(SimpleQuantity30_40.convertSimpleQuantity(src.getCapacity()));
        if (src.hasSpecimenQuantity())
            tgt.setSpecimenQuantity(SimpleQuantity30_40.convertSimpleQuantity(src.getSpecimenQuantity()));
        if (src.hasAdditive())
            tgt.setAdditive(Type30_40.convertType(src.getAdditive()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Specimen.SpecimenContainerComponent convertSpecimenContainerComponent(org.hl7.fhir.dstu3.model.Specimen.SpecimenContainerComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Specimen.SpecimenContainerComponent tgt = new org.hl7.fhir.r4.model.Specimen.SpecimenContainerComponent();
        Element30_40.copyElement(src, tgt);
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(Identifier30_40.convertIdentifier(t));
        if (src.hasDescription())
            tgt.setDescriptionElement(String30_40.convertString(src.getDescriptionElement()));
        if (src.hasType())
            tgt.setType(CodeableConcept30_40.convertCodeableConcept(src.getType()));
        if (src.hasCapacity())
            tgt.setCapacity(SimpleQuantity30_40.convertSimpleQuantity(src.getCapacity()));
        if (src.hasSpecimenQuantity())
            tgt.setSpecimenQuantity(SimpleQuantity30_40.convertSimpleQuantity(src.getSpecimenQuantity()));
        if (src.hasAdditive())
            tgt.setAdditive(Type30_40.convertType(src.getAdditive()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Specimen.SpecimenProcessingComponent convertSpecimenProcessingComponent(org.hl7.fhir.dstu3.model.Specimen.SpecimenProcessingComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Specimen.SpecimenProcessingComponent tgt = new org.hl7.fhir.r4.model.Specimen.SpecimenProcessingComponent();
        Element30_40.copyElement(src, tgt);
        if (src.hasDescription())
            tgt.setDescriptionElement(String30_40.convertString(src.getDescriptionElement()));
        if (src.hasProcedure())
            tgt.setProcedure(CodeableConcept30_40.convertCodeableConcept(src.getProcedure()));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getAdditive()) tgt.addAdditive(Reference30_40.convertReference(t));
        if (src.hasTime())
            tgt.setTime(Type30_40.convertType(src.getTime()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Specimen.SpecimenProcessingComponent convertSpecimenProcessingComponent(org.hl7.fhir.r4.model.Specimen.SpecimenProcessingComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Specimen.SpecimenProcessingComponent tgt = new org.hl7.fhir.dstu3.model.Specimen.SpecimenProcessingComponent();
        Element30_40.copyElement(src, tgt);
        if (src.hasDescription())
            tgt.setDescriptionElement(String30_40.convertString(src.getDescriptionElement()));
        if (src.hasProcedure())
            tgt.setProcedure(CodeableConcept30_40.convertCodeableConcept(src.getProcedure()));
        for (org.hl7.fhir.r4.model.Reference t : src.getAdditive()) tgt.addAdditive(Reference30_40.convertReference(t));
        if (src.hasTime())
            tgt.setTime(Type30_40.convertType(src.getTime()));
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Specimen.SpecimenStatus> convertSpecimenStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Specimen.SpecimenStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Specimen.SpecimenStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Specimen.SpecimenStatusEnumFactory());
        Element30_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case AVAILABLE:
                tgt.setValue(org.hl7.fhir.dstu3.model.Specimen.SpecimenStatus.AVAILABLE);
                break;
            case UNAVAILABLE:
                tgt.setValue(org.hl7.fhir.dstu3.model.Specimen.SpecimenStatus.UNAVAILABLE);
                break;
            case UNSATISFACTORY:
                tgt.setValue(org.hl7.fhir.dstu3.model.Specimen.SpecimenStatus.UNSATISFACTORY);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.dstu3.model.Specimen.SpecimenStatus.ENTEREDINERROR);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.Specimen.SpecimenStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Specimen.SpecimenStatus> convertSpecimenStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Specimen.SpecimenStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Specimen.SpecimenStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Specimen.SpecimenStatusEnumFactory());
        Element30_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case AVAILABLE:
                tgt.setValue(org.hl7.fhir.r4.model.Specimen.SpecimenStatus.AVAILABLE);
                break;
            case UNAVAILABLE:
                tgt.setValue(org.hl7.fhir.r4.model.Specimen.SpecimenStatus.UNAVAILABLE);
                break;
            case UNSATISFACTORY:
                tgt.setValue(org.hl7.fhir.r4.model.Specimen.SpecimenStatus.UNSATISFACTORY);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.r4.model.Specimen.SpecimenStatus.ENTEREDINERROR);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.Specimen.SpecimenStatus.NULL);
                break;
        }
        return tgt;
    }
}