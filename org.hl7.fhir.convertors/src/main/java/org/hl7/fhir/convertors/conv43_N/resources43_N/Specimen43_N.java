package org.hl7.fhir.convertors.conv43_N.resources43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Annotation43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.CodeableConcept43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Duration43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Identifier43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.SimpleQuantity43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.DateTime43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.String43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.special43_N.Reference43_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.Enumeration;
import org.hl7.fhir.model.core.Specimen;

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

public class Specimen43_N {

  public static org.hl7.fhir.model.core.Specimen convertSpecimen(org.hl7.fhir.r4b.model.Specimen src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Specimen tgt = new org.hl7.fhir.model.core.Specimen();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertSpecimenStatus(src.getStatusElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept43_N.convertCodeableConcept(src.getType()));
    if (src.hasSubject())
      tgt.setSubject(Reference43_N.convertReference(src.getSubject()));
    if (src.hasReceivedTime())
      tgt.setReceivedTimeElement(DateTime43_N.convertDateTime(src.getReceivedTimeElement()));
    for (org.hl7.fhir.r4b.model.Reference t : src.getParent()) tgt.addParent(Reference43_N.convertReference(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getRequest()) tgt.addRequest(Reference43_N.convertReference(t));
    if (src.hasCollection())
      tgt.setCollection(convertSpecimenCollectionComponent(src.getCollection()));
    for (org.hl7.fhir.r4b.model.Specimen.SpecimenProcessingComponent t : src.getProcessing())
      tgt.addProcessing(convertSpecimenProcessingComponent(t));
    for (org.hl7.fhir.r4b.model.Specimen.SpecimenContainerComponent t : src.getContainer())
      tgt.addContainer(convertSpecimenContainerComponent(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getCondition())
      tgt.addCondition(CodeableConcept43_N.convertCodeableConcept(t));
    for (org.hl7.fhir.r4b.model.Annotation t : src.getNote()) tgt.addNote(Annotation43_N.convertAnnotation(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Specimen convertSpecimen(org.hl7.fhir.model.core.Specimen src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Specimen tgt = new org.hl7.fhir.r4b.model.Specimen();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertSpecimenStatus(src.getStatusElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept43_N.convertCodeableConcept(src.getType()));
    if (src.hasSubject())
      tgt.setSubject(Reference43_N.convertReference(src.getSubject()));
    if (src.hasReceivedTime())
      tgt.setReceivedTimeElement(DateTime43_N.convertDateTime(src.getReceivedTimeElement()));
    for (org.hl7.fhir.model.core.Reference t : src.getParentList()) tgt.addParent(Reference43_N.convertReference(t));
    for (org.hl7.fhir.model.core.Reference t : src.getRequestList()) tgt.addRequest(Reference43_N.convertReference(t));
    if (src.hasCollection())
      tgt.setCollection(convertSpecimenCollectionComponent(src.getCollection()));
    for (org.hl7.fhir.model.core.Specimen.SpecimenProcessingComponent t : src.getProcessingList())
      tgt.addProcessing(convertSpecimenProcessingComponent(t));
    for (org.hl7.fhir.model.core.Specimen.SpecimenContainerComponent t : src.getContainerList())
      tgt.addContainer(convertSpecimenContainerComponent(t));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getConditionList())
      tgt.addCondition(CodeableConcept43_N.convertCodeableConcept(t));
    for (org.hl7.fhir.model.core.Annotation t : src.getNoteList()) tgt.addNote(Annotation43_N.convertAnnotation(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Specimen.SpecimenStatus> convertSpecimenStatus(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Specimen.SpecimenStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Specimen.SpecimenStatus> tgt = new Enumeration<>(new Specimen.SpecimenStatusEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case AVAILABLE:
                  tgt.setValue(Specimen.SpecimenStatus.AVAILABLE);
                  break;
              case UNAVAILABLE:
                  tgt.setValue(Specimen.SpecimenStatus.UNAVAILABLE);
                  break;
              case UNSATISFACTORY:
                  tgt.setValue(Specimen.SpecimenStatus.UNSATISFACTORY);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(Specimen.SpecimenStatus.ENTEREDINERROR);
                  break;
              default:
                  tgt.setValue(Specimen.SpecimenStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Specimen.SpecimenStatus> convertSpecimenStatus(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Specimen.SpecimenStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Specimen.SpecimenStatus> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Specimen.SpecimenStatusEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
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
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.Specimen.SpecimenCollectionComponent convertSpecimenCollectionComponent(org.hl7.fhir.r4b.model.Specimen.SpecimenCollectionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Specimen.SpecimenCollectionComponent tgt = new org.hl7.fhir.model.core.Specimen.SpecimenCollectionComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasCollector())
      tgt.setCollector(Reference43_N.convertReference(src.getCollector()));
    if (src.hasCollected())
      tgt.setCollected(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getCollected()));
    if (src.hasDuration())
      tgt.setDuration(Duration43_N.convertDuration(src.getDuration()));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity43_N.convertSimpleQuantity(src.getQuantity()));
    if (src.hasMethod())
      tgt.setMethod(CodeableConcept43_N.convertCodeableConcept(src.getMethod()));
    if (src.hasBodySite())
      tgt.addBodyStructure().setConcept(CodeableConcept43_N.convertCodeableConcept(src.getBodySite()));
    if (src.hasFastingStatus())
      tgt.setFastingStatus(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getFastingStatus()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Specimen.SpecimenCollectionComponent convertSpecimenCollectionComponent(org.hl7.fhir.model.core.Specimen.SpecimenCollectionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Specimen.SpecimenCollectionComponent tgt = new org.hl7.fhir.r4b.model.Specimen.SpecimenCollectionComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasCollector())
      tgt.setCollector(Reference43_N.convertReference(src.getCollector()));
    if (src.hasCollected())
      tgt.setCollected(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getCollected()));
    if (src.hasDuration())
      tgt.setDuration(Duration43_N.convertDuration(src.getDuration()));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity43_N.convertSimpleQuantity(src.getQuantity()));
    if (src.hasMethod())
      tgt.setMethod(CodeableConcept43_N.convertCodeableConcept(src.getMethod()));
    if (src.getBodyStructureFirstRep().hasConcept())
      tgt.setBodySite(CodeableConcept43_N.convertCodeableConcept(src.getBodyStructureFirstRep().getConcept()));
    if (src.hasFastingStatus())
      tgt.setFastingStatus(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getFastingStatus()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.Specimen.SpecimenProcessingComponent convertSpecimenProcessingComponent(org.hl7.fhir.r4b.model.Specimen.SpecimenProcessingComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Specimen.SpecimenProcessingComponent tgt = new org.hl7.fhir.model.core.Specimen.SpecimenProcessingComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_N.convertString(src.getDescriptionElement()));
//    if (src.hasProcedure())
//      tgt.setProcedure(CodeableConcept43_N.convertCodeableConcept(src.getProcedure()));
    for (org.hl7.fhir.r4b.model.Reference t : src.getAdditive()) tgt.addAdditive().getType().setReference(Reference43_N.convertReference(t));
    if (src.hasTime())
      tgt.setTime(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getTime()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Specimen.SpecimenProcessingComponent convertSpecimenProcessingComponent(org.hl7.fhir.model.core.Specimen.SpecimenProcessingComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Specimen.SpecimenProcessingComponent tgt = new org.hl7.fhir.r4b.model.Specimen.SpecimenProcessingComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_N.convertString(src.getDescriptionElement()));
//    if (src.hasProcedure())
//      tgt.setProcedure(CodeableConcept43_N.convertCodeableConcept(src.getProcedure()));
    for (Specimen.SpecimenProcessingAdditiveComponent t : src.getAdditiveList()) tgt.addAdditive(Reference43_N.convertReference(t.getType().getReference()));
    if (src.hasTime())
      tgt.setTime(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getTime()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.Specimen.SpecimenContainerComponent convertSpecimenContainerComponent(org.hl7.fhir.r4b.model.Specimen.SpecimenContainerComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Specimen.SpecimenContainerComponent tgt = new org.hl7.fhir.model.core.Specimen.SpecimenContainerComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
//    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
//      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
//    if (src.hasDescription())
//      tgt.setDescriptionElement(String43_N.convertString(src.getDescriptionElement()));
//    if (src.hasType())
//      tgt.setType(CodeableConcept43_N.convertCodeableConcept(src.getType()));
//    if (src.hasCapacity())
//      tgt.setCapacity(SimpleQuantity43_N.convertSimpleQuantity(src.getCapacity()));
//    if (src.hasSpecimenQuantity())
//      tgt.setSpecimenQuantity(SimpleQuantity43_N.convertSimpleQuantity(src.getSpecimenQuantity()));
//    if (src.hasAdditive())
//      tgt.setAdditive(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getAdditive()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Specimen.SpecimenContainerComponent convertSpecimenContainerComponent(org.hl7.fhir.model.core.Specimen.SpecimenContainerComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Specimen.SpecimenContainerComponent tgt = new org.hl7.fhir.r4b.model.Specimen.SpecimenContainerComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
//    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
//      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
//    if (src.hasDescription())
//      tgt.setDescriptionElement(String43_N.convertString(src.getDescriptionElement()));
//    if (src.hasType())
//      tgt.setType(CodeableConcept43_N.convertCodeableConcept(src.getType()));
//    if (src.hasCapacity())
//      tgt.setCapacity(SimpleQuantity43_N.convertSimpleQuantity(src.getCapacity()));
//    if (src.hasSpecimenQuantity())
//      tgt.setSpecimenQuantity(SimpleQuantity43_N.convertSimpleQuantity(src.getSpecimenQuantity()));
//    if (src.hasAdditive())
//      tgt.setAdditive(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getAdditive()));
    return tgt;
  }
}