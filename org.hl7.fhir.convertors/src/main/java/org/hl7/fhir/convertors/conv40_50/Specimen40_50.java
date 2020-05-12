package org.hl7.fhir.convertors.conv40_50;


import org.hl7.fhir.convertors.VersionConvertor_40_50;
import org.hl7.fhir.exceptions.FHIRException;

/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.
  
  Redistribution and use in source and binary forms, with or without modification, 
  are permitted provided that the following conditions are met:
  
   * Redistributions of source code must retain the above copyright notice, this 
     list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright notice, 
     this list of conditions and the following disclaimer in the documentation 
     and/or other materials provided with the distribution.
   * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.
  
  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
  POSSIBILITY OF SUCH DAMAGE.
  
*/
// Generated on Sun, Feb 24, 2019 11:37+1100 for FHIR v4.0.0
public class Specimen40_50 extends VersionConvertor_40_50 {

    public static org.hl7.fhir.r5.model.Specimen convertSpecimen(org.hl7.fhir.r4.model.Specimen src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Specimen tgt = new org.hl7.fhir.r5.model.Specimen();
        copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        if (src.hasAccessionIdentifier())
            tgt.setAccessionIdentifier(convertIdentifier(src.getAccessionIdentifier()));
        if (src.hasStatus())
            tgt.setStatusElement(convertSpecimenStatus(src.getStatusElement()));
        if (src.hasType())
            tgt.setType(convertCodeableConcept(src.getType()));
        if (src.hasSubject())
            tgt.setSubject(convertReference(src.getSubject()));
        if (src.hasReceivedTime())
            tgt.setReceivedTimeElement(convertDateTime(src.getReceivedTimeElement()));
        for (org.hl7.fhir.r4.model.Reference t : src.getParent()) tgt.addParent(convertReference(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getRequest()) tgt.addRequest(convertReference(t));
        if (src.hasCollection())
            tgt.setCollection(convertSpecimenCollectionComponent(src.getCollection()));
        for (org.hl7.fhir.r4.model.Specimen.SpecimenProcessingComponent t : src.getProcessing()) tgt.addProcessing(convertSpecimenProcessingComponent(t));
        for (org.hl7.fhir.r4.model.Specimen.SpecimenContainerComponent t : src.getContainer()) tgt.addContainer(convertSpecimenContainerComponent(t));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCondition()) tgt.addCondition(convertCodeableConcept(t));
        for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.addNote(convertAnnotation(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Specimen convertSpecimen(org.hl7.fhir.r5.model.Specimen src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Specimen tgt = new org.hl7.fhir.r4.model.Specimen();
        copyDomainResource(src, tgt);
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        if (src.hasAccessionIdentifier())
            tgt.setAccessionIdentifier(convertIdentifier(src.getAccessionIdentifier()));
        if (src.hasStatus())
            tgt.setStatusElement(convertSpecimenStatus(src.getStatusElement()));
        if (src.hasType())
            tgt.setType(convertCodeableConcept(src.getType()));
        if (src.hasSubject())
            tgt.setSubject(convertReference(src.getSubject()));
        if (src.hasReceivedTime())
            tgt.setReceivedTimeElement(convertDateTime(src.getReceivedTimeElement()));
        for (org.hl7.fhir.r5.model.Reference t : src.getParent()) tgt.addParent(convertReference(t));
        for (org.hl7.fhir.r5.model.Reference t : src.getRequest()) tgt.addRequest(convertReference(t));
        if (src.hasCollection())
            tgt.setCollection(convertSpecimenCollectionComponent(src.getCollection()));
        for (org.hl7.fhir.r5.model.Specimen.SpecimenProcessingComponent t : src.getProcessing()) tgt.addProcessing(convertSpecimenProcessingComponent(t));
        for (org.hl7.fhir.r5.model.Specimen.SpecimenContainerComponent t : src.getContainer()) tgt.addContainer(convertSpecimenContainerComponent(t));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCondition()) tgt.addCondition(convertCodeableConcept(t));
        for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.addNote(convertAnnotation(t));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Specimen.SpecimenStatus> convertSpecimenStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Specimen.SpecimenStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Specimen.SpecimenStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Specimen.SpecimenStatusEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case AVAILABLE:
                tgt.setValue(org.hl7.fhir.r5.model.Specimen.SpecimenStatus.AVAILABLE);
                break;
            case UNAVAILABLE:
                tgt.setValue(org.hl7.fhir.r5.model.Specimen.SpecimenStatus.UNAVAILABLE);
                break;
            case UNSATISFACTORY:
                tgt.setValue(org.hl7.fhir.r5.model.Specimen.SpecimenStatus.UNSATISFACTORY);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.r5.model.Specimen.SpecimenStatus.ENTEREDINERROR);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Specimen.SpecimenStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Specimen.SpecimenStatus> convertSpecimenStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Specimen.SpecimenStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Specimen.SpecimenStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Specimen.SpecimenStatusEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
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

    public static org.hl7.fhir.r5.model.Specimen.SpecimenCollectionComponent convertSpecimenCollectionComponent(org.hl7.fhir.r4.model.Specimen.SpecimenCollectionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Specimen.SpecimenCollectionComponent tgt = new org.hl7.fhir.r5.model.Specimen.SpecimenCollectionComponent();
        copyElement(src, tgt);
        if (src.hasCollector())
            tgt.setCollector(convertReference(src.getCollector()));
        if (src.hasCollected())
            tgt.setCollected(convertType(src.getCollected()));
        if (src.hasDuration())
            tgt.setDuration(convertDuration(src.getDuration()));
        if (src.hasQuantity())
            tgt.setQuantity(convertSimpleQuantity(src.getQuantity()));
        if (src.hasMethod())
            tgt.setMethod(convertCodeableConcept(src.getMethod()));
        if (src.hasBodySite())
            tgt.setBodySite(convertCodeableConcept(src.getBodySite()));
        if (src.hasFastingStatus())
            tgt.setFastingStatus(convertType(src.getFastingStatus()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Specimen.SpecimenCollectionComponent convertSpecimenCollectionComponent(org.hl7.fhir.r5.model.Specimen.SpecimenCollectionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Specimen.SpecimenCollectionComponent tgt = new org.hl7.fhir.r4.model.Specimen.SpecimenCollectionComponent();
        copyElement(src, tgt);
        if (src.hasCollector())
            tgt.setCollector(convertReference(src.getCollector()));
        if (src.hasCollected())
            tgt.setCollected(convertType(src.getCollected()));
        if (src.hasDuration())
            tgt.setDuration(convertDuration(src.getDuration()));
        if (src.hasQuantity())
            tgt.setQuantity(convertSimpleQuantity(src.getQuantity()));
        if (src.hasMethod())
            tgt.setMethod(convertCodeableConcept(src.getMethod()));
        if (src.hasBodySite())
            tgt.setBodySite(convertCodeableConcept(src.getBodySite()));
        if (src.hasFastingStatus())
            tgt.setFastingStatus(convertType(src.getFastingStatus()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Specimen.SpecimenProcessingComponent convertSpecimenProcessingComponent(org.hl7.fhir.r4.model.Specimen.SpecimenProcessingComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Specimen.SpecimenProcessingComponent tgt = new org.hl7.fhir.r5.model.Specimen.SpecimenProcessingComponent();
        copyElement(src, tgt);
        if (src.hasDescription())
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        if (src.hasProcedure())
            tgt.setProcedure(convertCodeableConcept(src.getProcedure()));
        for (org.hl7.fhir.r4.model.Reference t : src.getAdditive()) tgt.addAdditive(convertReference(t));
        if (src.hasTime())
            tgt.setTime(convertType(src.getTime()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Specimen.SpecimenProcessingComponent convertSpecimenProcessingComponent(org.hl7.fhir.r5.model.Specimen.SpecimenProcessingComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Specimen.SpecimenProcessingComponent tgt = new org.hl7.fhir.r4.model.Specimen.SpecimenProcessingComponent();
        copyElement(src, tgt);
        if (src.hasDescription())
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        if (src.hasProcedure())
            tgt.setProcedure(convertCodeableConcept(src.getProcedure()));
        for (org.hl7.fhir.r5.model.Reference t : src.getAdditive()) tgt.addAdditive(convertReference(t));
        if (src.hasTime())
            tgt.setTime(convertType(src.getTime()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Specimen.SpecimenContainerComponent convertSpecimenContainerComponent(org.hl7.fhir.r4.model.Specimen.SpecimenContainerComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Specimen.SpecimenContainerComponent tgt = new org.hl7.fhir.r5.model.Specimen.SpecimenContainerComponent();
        copyElement(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        if (src.hasType())
            tgt.setType(convertCodeableConcept(src.getType()));
        if (src.hasCapacity())
            tgt.setCapacity(convertSimpleQuantity(src.getCapacity()));
        if (src.hasSpecimenQuantity())
            tgt.setSpecimenQuantity(convertSimpleQuantity(src.getSpecimenQuantity()));
        if (src.hasAdditive())
            tgt.setAdditive(convertType(src.getAdditive()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Specimen.SpecimenContainerComponent convertSpecimenContainerComponent(org.hl7.fhir.r5.model.Specimen.SpecimenContainerComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Specimen.SpecimenContainerComponent tgt = new org.hl7.fhir.r4.model.Specimen.SpecimenContainerComponent();
        copyElement(src, tgt);
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        if (src.hasType())
            tgt.setType(convertCodeableConcept(src.getType()));
        if (src.hasCapacity())
            tgt.setCapacity(convertSimpleQuantity(src.getCapacity()));
        if (src.hasSpecimenQuantity())
            tgt.setSpecimenQuantity(convertSimpleQuantity(src.getSpecimenQuantity()));
        if (src.hasAdditive())
            tgt.setAdditive(convertType(src.getAdditive()));
        return tgt;
    }
}