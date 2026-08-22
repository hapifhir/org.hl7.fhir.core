package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Annotation40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Duration40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Identifier40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.SimpleQuantity40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.DateTime40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.String40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Reference40_N;
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

public class Specimen40_N {

  public static org.hl7.fhir.model.core.Specimen convertSpecimen(org.hl7.fhir.r4.model.Specimen src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Specimen tgt = new org.hl7.fhir.model.core.Specimen();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertSpecimenStatus(src.getStatusElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    if (src.hasSubject())
      tgt.setSubject(Reference40_N.convertReference(src.getSubject()));
    if (src.hasReceivedTime())
      tgt.setReceivedTimeElement(DateTime40_N.convertDateTime(src.getReceivedTimeElement()));
    for (org.hl7.fhir.r4.model.Reference t : src.getParent()) tgt.addParent(Reference40_N.convertReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getRequest()) tgt.addRequest(Reference40_N.convertReference(t));
    if (src.hasCollection())
      tgt.setCollection(convertSpecimenCollectionComponent(src.getCollection()));
    for (org.hl7.fhir.r4.model.Specimen.SpecimenProcessingComponent t : src.getProcessing())
      tgt.addProcessing(convertSpecimenProcessingComponent(t));
    for (org.hl7.fhir.r4.model.Specimen.SpecimenContainerComponent t : src.getContainer())
      tgt.addContainer(convertSpecimenContainerComponent(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCondition())
      tgt.addCondition(CodeableConcept40_N.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.addNote(Annotation40_N.convertAnnotation(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Specimen convertSpecimen(org.hl7.fhir.model.core.Specimen src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Specimen tgt = new org.hl7.fhir.r4.model.Specimen();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertSpecimenStatus(src.getStatusElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    if (src.hasSubject())
      tgt.setSubject(Reference40_N.convertReference(src.getSubject()));
    if (src.hasReceivedTime())
      tgt.setReceivedTimeElement(DateTime40_N.convertDateTime(src.getReceivedTimeElement()));
    for (org.hl7.fhir.model.core.Reference t : src.getParentList()) tgt.addParent(Reference40_N.convertReference(t));
    for (org.hl7.fhir.model.core.Reference t : src.getRequestList()) tgt.addRequest(Reference40_N.convertReference(t));
    if (src.hasCollection())
      tgt.setCollection(convertSpecimenCollectionComponent(src.getCollection()));
    for (org.hl7.fhir.model.core.Specimen.SpecimenProcessingComponent t : src.getProcessingList())
      tgt.addProcessing(convertSpecimenProcessingComponent(t));
    for (org.hl7.fhir.model.core.Specimen.SpecimenContainerComponent t : src.getContainerList())
      tgt.addContainer(convertSpecimenContainerComponent(t));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getConditionList())
      tgt.addCondition(CodeableConcept40_N.convertCodeableConcept(t));
    for (org.hl7.fhir.model.core.Annotation t : src.getNoteList()) tgt.addNote(Annotation40_N.convertAnnotation(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Specimen.SpecimenStatus> convertSpecimenStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Specimen.SpecimenStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Specimen.SpecimenStatus> tgt = new Enumeration<>(new Specimen.SpecimenStatusEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Specimen.SpecimenStatus> convertSpecimenStatus(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Specimen.SpecimenStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Specimen.SpecimenStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Specimen.SpecimenStatusEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
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
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.Specimen.SpecimenCollectionComponent convertSpecimenCollectionComponent(org.hl7.fhir.r4.model.Specimen.SpecimenCollectionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Specimen.SpecimenCollectionComponent tgt = new org.hl7.fhir.model.core.Specimen.SpecimenCollectionComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasCollector())
      tgt.setCollector(Reference40_N.convertReference(src.getCollector()));
    if (src.hasCollected())
      tgt.setCollected(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getCollected()));
    if (src.hasDuration())
      tgt.setDuration(Duration40_N.convertDuration(src.getDuration()));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity40_N.convertSimpleQuantity(src.getQuantity()));
    if (src.hasMethod())
      tgt.setMethod(CodeableConcept40_N.convertCodeableConcept(src.getMethod()));
    if (src.hasBodySite())
      tgt.addBodyStructure().setConcept(CodeableConcept40_N.convertCodeableConcept(src.getBodySite()));
    if (src.hasFastingStatus())
      tgt.setFastingStatus(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getFastingStatus()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Specimen.SpecimenCollectionComponent convertSpecimenCollectionComponent(org.hl7.fhir.model.core.Specimen.SpecimenCollectionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Specimen.SpecimenCollectionComponent tgt = new org.hl7.fhir.r4.model.Specimen.SpecimenCollectionComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasCollector())
      tgt.setCollector(Reference40_N.convertReference(src.getCollector()));
    if (src.hasCollected())
      tgt.setCollected(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getCollected()));
    if (src.hasDuration())
      tgt.setDuration(Duration40_N.convertDuration(src.getDuration()));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity40_N.convertSimpleQuantity(src.getQuantity()));
    if (src.hasMethod())
      tgt.setMethod(CodeableConcept40_N.convertCodeableConcept(src.getMethod()));
    if (src.getBodyStructureFirstRep().hasConcept())
      tgt.setBodySite(CodeableConcept40_N.convertCodeableConcept(src.getBodyStructureFirstRep().getConcept()));
    if (src.hasFastingStatus())
      tgt.setFastingStatus(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getFastingStatus()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.Specimen.SpecimenProcessingComponent convertSpecimenProcessingComponent(org.hl7.fhir.r4.model.Specimen.SpecimenProcessingComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Specimen.SpecimenProcessingComponent tgt = new org.hl7.fhir.model.core.Specimen.SpecimenProcessingComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_N.convertString(src.getDescriptionElement()));
//    if (src.hasProcedure())
//      tgt.setProcedure(CodeableConcept40_N.convertCodeableConcept(src.getProcedure()));
    for (org.hl7.fhir.r4.model.Reference t : src.getAdditive()) tgt.addAdditive().getType().setReference(Reference40_N.convertReference(t));
    if (src.hasTime())
      tgt.setTime(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getTime()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Specimen.SpecimenProcessingComponent convertSpecimenProcessingComponent(org.hl7.fhir.model.core.Specimen.SpecimenProcessingComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Specimen.SpecimenProcessingComponent tgt = new org.hl7.fhir.r4.model.Specimen.SpecimenProcessingComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_N.convertString(src.getDescriptionElement()));
//    if (src.hasProcedure())
//      tgt.setProcedure(CodeableConcept40_N.convertCodeableConcept(src.getProcedure()));
    for (Specimen.SpecimenProcessingAdditiveComponent t : src.getAdditiveList()) tgt.addAdditive(Reference40_N.convertReference(t.getType().getReference()));
    if (src.hasTime())
      tgt.setTime(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getTime()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.Specimen.SpecimenContainerComponent convertSpecimenContainerComponent(org.hl7.fhir.r4.model.Specimen.SpecimenContainerComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Specimen.SpecimenContainerComponent tgt = new org.hl7.fhir.model.core.Specimen.SpecimenContainerComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
//    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
//      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
//    if (src.hasDescription())
//      tgt.setDescriptionElement(String40_N.convertString(src.getDescriptionElement()));
//    if (src.hasType())
//      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
//    if (src.hasCapacity())
//      tgt.setCapacity(SimpleQuantity40_N.convertSimpleQuantity(src.getCapacity()));
//    if (src.hasSpecimenQuantity())
//      tgt.setSpecimenQuantity(SimpleQuantity40_N.convertSimpleQuantity(src.getSpecimenQuantity()));
//    if (src.hasAdditive())
//      tgt.setAdditive(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getAdditive()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Specimen.SpecimenContainerComponent convertSpecimenContainerComponent(org.hl7.fhir.model.core.Specimen.SpecimenContainerComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Specimen.SpecimenContainerComponent tgt = new org.hl7.fhir.r4.model.Specimen.SpecimenContainerComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
//    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
//      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
//    if (src.hasDescription())
//      tgt.setDescriptionElement(String40_N.convertString(src.getDescriptionElement()));
//    if (src.hasType())
//      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
//    if (src.hasCapacity())
//      tgt.setCapacity(SimpleQuantity40_N.convertSimpleQuantity(src.getCapacity()));
//    if (src.hasSpecimenQuantity())
//      tgt.setSpecimenQuantity(SimpleQuantity40_N.convertSimpleQuantity(src.getSpecimenQuantity()));
//    if (src.hasAdditive())
//      tgt.setAdditive(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getAdditive()));
    return tgt;
  }
}