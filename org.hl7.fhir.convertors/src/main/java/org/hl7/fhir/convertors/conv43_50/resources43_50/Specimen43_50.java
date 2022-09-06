package org.hl7.fhir.convertors.conv43_50.resources43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Annotation43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.CodeableConcept43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Duration43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Identifier43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.SimpleQuantity43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.DateTime43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.String43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.special43_50.Reference43_50;
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
public class Specimen43_50 {

  public static org.hl7.fhir.r5.model.Specimen convertSpecimen(org.hl7.fhir.r4b.model.Specimen src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Specimen tgt = new org.hl7.fhir.r5.model.Specimen();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    if (src.hasAccessionIdentifier())
      tgt.setAccessionIdentifier(Identifier43_50.convertIdentifier(src.getAccessionIdentifier()));
    if (src.hasStatus())
      tgt.setStatusElement(convertSpecimenStatus(src.getStatusElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
    if (src.hasSubject())
      tgt.setSubject(Reference43_50.convertReference(src.getSubject()));
    if (src.hasReceivedTime())
      tgt.setReceivedTimeElement(DateTime43_50.convertDateTime(src.getReceivedTimeElement()));
    for (org.hl7.fhir.r4b.model.Reference t : src.getParent()) tgt.addParent(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getRequest()) tgt.addRequest(Reference43_50.convertReference(t));
    if (src.hasCollection())
      tgt.setCollection(convertSpecimenCollectionComponent(src.getCollection()));
    for (org.hl7.fhir.r4b.model.Specimen.SpecimenProcessingComponent t : src.getProcessing())
      tgt.addProcessing(convertSpecimenProcessingComponent(t));
    for (org.hl7.fhir.r4b.model.Specimen.SpecimenContainerComponent t : src.getContainer())
      tgt.addContainer(convertSpecimenContainerComponent(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getCondition())
      tgt.addCondition(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r4b.model.Annotation t : src.getNote()) tgt.addNote(Annotation43_50.convertAnnotation(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Specimen convertSpecimen(org.hl7.fhir.r5.model.Specimen src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Specimen tgt = new org.hl7.fhir.r4b.model.Specimen();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    if (src.hasAccessionIdentifier())
      tgt.setAccessionIdentifier(Identifier43_50.convertIdentifier(src.getAccessionIdentifier()));
    if (src.hasStatus())
      tgt.setStatusElement(convertSpecimenStatus(src.getStatusElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
    if (src.hasSubject())
      tgt.setSubject(Reference43_50.convertReference(src.getSubject()));
    if (src.hasReceivedTime())
      tgt.setReceivedTimeElement(DateTime43_50.convertDateTime(src.getReceivedTimeElement()));
    for (org.hl7.fhir.r5.model.Reference t : src.getParent()) tgt.addParent(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getRequest()) tgt.addRequest(Reference43_50.convertReference(t));
    if (src.hasCollection())
      tgt.setCollection(convertSpecimenCollectionComponent(src.getCollection()));
    for (org.hl7.fhir.r5.model.Specimen.SpecimenProcessingComponent t : src.getProcessing())
      tgt.addProcessing(convertSpecimenProcessingComponent(t));
    for (org.hl7.fhir.r5.model.Specimen.SpecimenContainerComponent t : src.getContainer())
      tgt.addContainer(convertSpecimenContainerComponent(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCondition())
      tgt.addCondition(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.addNote(Annotation43_50.convertAnnotation(t));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Specimen.SpecimenStatus> convertSpecimenStatus(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Specimen.SpecimenStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Specimen.SpecimenStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Specimen.SpecimenStatusEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
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

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Specimen.SpecimenStatus> convertSpecimenStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Specimen.SpecimenStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Specimen.SpecimenStatus> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Specimen.SpecimenStatusEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case AVAILABLE:
        tgt.setValue(org.hl7.fhir.r4b.model.Specimen.SpecimenStatus.AVAILABLE);
        break;
      case UNAVAILABLE:
        tgt.setValue(org.hl7.fhir.r4b.model.Specimen.SpecimenStatus.UNAVAILABLE);
        break;
      case UNSATISFACTORY:
        tgt.setValue(org.hl7.fhir.r4b.model.Specimen.SpecimenStatus.UNSATISFACTORY);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r4b.model.Specimen.SpecimenStatus.ENTEREDINERROR);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.Specimen.SpecimenStatus.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Specimen.SpecimenCollectionComponent convertSpecimenCollectionComponent(org.hl7.fhir.r4b.model.Specimen.SpecimenCollectionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Specimen.SpecimenCollectionComponent tgt = new org.hl7.fhir.r5.model.Specimen.SpecimenCollectionComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasCollector())
      tgt.setCollector(Reference43_50.convertReference(src.getCollector()));
    if (src.hasCollected())
      tgt.setCollected(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getCollected()));
    if (src.hasDuration())
      tgt.setDuration(Duration43_50.convertDuration(src.getDuration()));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity43_50.convertSimpleQuantity(src.getQuantity()));
    if (src.hasMethod())
      tgt.setMethod(CodeableConcept43_50.convertCodeableConcept(src.getMethod()));
    if (src.hasBodySite())
      tgt.getBodySite().setConcept(CodeableConcept43_50.convertCodeableConcept(src.getBodySite()));
    if (src.hasFastingStatus())
      tgt.setFastingStatus(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getFastingStatus()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Specimen.SpecimenCollectionComponent convertSpecimenCollectionComponent(org.hl7.fhir.r5.model.Specimen.SpecimenCollectionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Specimen.SpecimenCollectionComponent tgt = new org.hl7.fhir.r4b.model.Specimen.SpecimenCollectionComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasCollector())
      tgt.setCollector(Reference43_50.convertReference(src.getCollector()));
    if (src.hasCollected())
      tgt.setCollected(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getCollected()));
    if (src.hasDuration())
      tgt.setDuration(Duration43_50.convertDuration(src.getDuration()));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity43_50.convertSimpleQuantity(src.getQuantity()));
    if (src.hasMethod())
      tgt.setMethod(CodeableConcept43_50.convertCodeableConcept(src.getMethod()));
    if (src.getBodySite().hasConcept())
      tgt.setBodySite(CodeableConcept43_50.convertCodeableConcept(src.getBodySite().getConcept()));
    if (src.hasFastingStatus())
      tgt.setFastingStatus(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getFastingStatus()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Specimen.SpecimenProcessingComponent convertSpecimenProcessingComponent(org.hl7.fhir.r4b.model.Specimen.SpecimenProcessingComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Specimen.SpecimenProcessingComponent tgt = new org.hl7.fhir.r5.model.Specimen.SpecimenProcessingComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_50.convertString(src.getDescriptionElement()));
//    if (src.hasProcedure())
//      tgt.setProcedure(CodeableConcept43_50.convertCodeableConcept(src.getProcedure()));
    for (org.hl7.fhir.r4b.model.Reference t : src.getAdditive()) tgt.addAdditive(Reference43_50.convertReference(t));
    if (src.hasTime())
      tgt.setTime(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getTime()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Specimen.SpecimenProcessingComponent convertSpecimenProcessingComponent(org.hl7.fhir.r5.model.Specimen.SpecimenProcessingComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Specimen.SpecimenProcessingComponent tgt = new org.hl7.fhir.r4b.model.Specimen.SpecimenProcessingComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_50.convertString(src.getDescriptionElement()));
//    if (src.hasProcedure())
//      tgt.setProcedure(CodeableConcept43_50.convertCodeableConcept(src.getProcedure()));
    for (org.hl7.fhir.r5.model.Reference t : src.getAdditive()) tgt.addAdditive(Reference43_50.convertReference(t));
    if (src.hasTime())
      tgt.setTime(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getTime()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Specimen.SpecimenContainerComponent convertSpecimenContainerComponent(org.hl7.fhir.r4b.model.Specimen.SpecimenContainerComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Specimen.SpecimenContainerComponent tgt = new org.hl7.fhir.r5.model.Specimen.SpecimenContainerComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
//    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
//      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
//    if (src.hasDescription())
//      tgt.setDescriptionElement(String43_50.convertString(src.getDescriptionElement()));
//    if (src.hasType())
//      tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
//    if (src.hasCapacity())
//      tgt.setCapacity(SimpleQuantity43_50.convertSimpleQuantity(src.getCapacity()));
//    if (src.hasSpecimenQuantity())
//      tgt.setSpecimenQuantity(SimpleQuantity43_50.convertSimpleQuantity(src.getSpecimenQuantity()));
//    if (src.hasAdditive())
//      tgt.setAdditive(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getAdditive()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Specimen.SpecimenContainerComponent convertSpecimenContainerComponent(org.hl7.fhir.r5.model.Specimen.SpecimenContainerComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Specimen.SpecimenContainerComponent tgt = new org.hl7.fhir.r4b.model.Specimen.SpecimenContainerComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
//    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
//      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
//    if (src.hasDescription())
//      tgt.setDescriptionElement(String43_50.convertString(src.getDescriptionElement()));
//    if (src.hasType())
//      tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
//    if (src.hasCapacity())
//      tgt.setCapacity(SimpleQuantity43_50.convertSimpleQuantity(src.getCapacity()));
//    if (src.hasSpecimenQuantity())
//      tgt.setSpecimenQuantity(SimpleQuantity43_50.convertSimpleQuantity(src.getSpecimenQuantity()));
//    if (src.hasAdditive())
//      tgt.setAdditive(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getAdditive()));
    return tgt;
  }
}