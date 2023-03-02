package org.hl7.fhir.convertors.conv43_50.resources43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Annotation43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.CodeableConcept43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Coding43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Identifier43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.DateTime43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Id43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.String43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.UnsignedInt43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.special43_50.Reference43_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CodeableConcept;
import org.hl7.fhir.r5.model.CodeableReference;
import org.hl7.fhir.r5.model.Coding;

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
public class ImagingStudy43_50 {

  public static org.hl7.fhir.r5.model.ImagingStudy convertImagingStudy(org.hl7.fhir.r4b.model.ImagingStudy src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ImagingStudy tgt = new org.hl7.fhir.r5.model.ImagingStudy();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertImagingStudyStatus(src.getStatusElement()));
    for (org.hl7.fhir.r4b.model.Coding t : src.getModality())  
      tgt.addModality(new CodeableConcept().addCoding(Coding43_50.convertCoding(t)));
    if (src.hasSubject())
      tgt.setSubject(Reference43_50.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference43_50.convertReference(src.getEncounter()));
    if (src.hasStarted())
      tgt.setStartedElement(DateTime43_50.convertDateTime(src.getStartedElement()));
    for (org.hl7.fhir.r4b.model.Reference t : src.getBasedOn()) tgt.addBasedOn(Reference43_50.convertReference(t));
    if (src.hasReferrer())
      tgt.setReferrer(Reference43_50.convertReference(src.getReferrer()));
//    for (org.hl7.fhir.r4b.model.Reference t : src.getInterpreter())
//      tgt.addInterpreter(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getEndpoint()) tgt.addEndpoint(Reference43_50.convertReference(t));
    if (src.hasNumberOfSeries())
      tgt.setNumberOfSeriesElement(UnsignedInt43_50.convertUnsignedInt(src.getNumberOfSeriesElement()));
    if (src.hasNumberOfInstances())
      tgt.setNumberOfInstancesElement(UnsignedInt43_50.convertUnsignedInt(src.getNumberOfInstancesElement()));
    if (src.hasProcedureReference())
      tgt.addProcedure().setReference(Reference43_50.convertReference(src.getProcedureReference()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getProcedureCode())
      tgt.addProcedure().setConcept(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasLocation())
      tgt.setLocation(Reference43_50.convertReference(src.getLocation()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getReasonCode())
      tgt.addReason(CodeableConcept43_50.convertCodeableConceptToCodeableReference(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getReasonReference())
      tgt.addReason(Reference43_50.convertReferenceToCodeableReference(t));
    for (org.hl7.fhir.r4b.model.Annotation t : src.getNote()) tgt.addNote(Annotation43_50.convertAnnotation(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_50.convertString(src.getDescriptionElement()));
    for (org.hl7.fhir.r4b.model.ImagingStudy.ImagingStudySeriesComponent t : src.getSeries())
      tgt.addSeries(convertImagingStudySeriesComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ImagingStudy convertImagingStudy(org.hl7.fhir.r5.model.ImagingStudy src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ImagingStudy tgt = new org.hl7.fhir.r4b.model.ImagingStudy();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertImagingStudyStatus(src.getStatusElement()));
    for (CodeableConcept t : src.getModality())
      for (Coding tt : t.getCoding())
        tgt.addModality(Coding43_50.convertCoding(tt));
    if (src.hasSubject())
      tgt.setSubject(Reference43_50.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference43_50.convertReference(src.getEncounter()));
    if (src.hasStarted())
      tgt.setStartedElement(DateTime43_50.convertDateTime(src.getStartedElement()));
    for (org.hl7.fhir.r5.model.Reference t : src.getBasedOn()) tgt.addBasedOn(Reference43_50.convertReference(t));
    if (src.hasReferrer())
      tgt.setReferrer(Reference43_50.convertReference(src.getReferrer()));
//    for (org.hl7.fhir.r5.model.Reference t : src.getInterpreter())
//      tgt.addInterpreter(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getEndpoint()) tgt.addEndpoint(Reference43_50.convertReference(t));
    if (src.hasNumberOfSeries())
      tgt.setNumberOfSeriesElement(UnsignedInt43_50.convertUnsignedInt(src.getNumberOfSeriesElement()));
    if (src.hasNumberOfInstances())
      tgt.setNumberOfInstancesElement(UnsignedInt43_50.convertUnsignedInt(src.getNumberOfInstancesElement()));
    for (CodeableReference t : src.getProcedure()) {
      if (t.hasConcept())
        tgt.addProcedureCode(CodeableConcept43_50.convertCodeableConcept(t.getConcept()));
      if (t.hasReference()) {
        tgt.setProcedureReference(Reference43_50.convertReference(t.getReference()));
      }
    }
    if (src.hasLocation())
      tgt.setLocation(Reference43_50.convertReference(src.getLocation()));
    for (CodeableReference t : src.getReason())
      if (t.hasConcept())
        tgt.addReasonCode(CodeableConcept43_50.convertCodeableConcept(t.getConcept()));
    for (CodeableReference t : src.getReason())
      if (t.hasReference())
        tgt.addReasonReference(Reference43_50.convertReference(t.getReference()));
    for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.addNote(Annotation43_50.convertAnnotation(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_50.convertString(src.getDescriptionElement()));
    for (org.hl7.fhir.r5.model.ImagingStudy.ImagingStudySeriesComponent t : src.getSeries())
      tgt.addSeries(convertImagingStudySeriesComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ImagingStudy.ImagingStudyStatus> convertImagingStudyStatus(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ImagingStudy.ImagingStudyStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ImagingStudy.ImagingStudyStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.ImagingStudy.ImagingStudyStatusEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case REGISTERED:
        tgt.setValue(org.hl7.fhir.r5.model.ImagingStudy.ImagingStudyStatus.REGISTERED);
        break;
      case AVAILABLE:
        tgt.setValue(org.hl7.fhir.r5.model.ImagingStudy.ImagingStudyStatus.AVAILABLE);
        break;
      case CANCELLED:
        tgt.setValue(org.hl7.fhir.r5.model.ImagingStudy.ImagingStudyStatus.CANCELLED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r5.model.ImagingStudy.ImagingStudyStatus.ENTEREDINERROR);
        break;
      case UNKNOWN:
        tgt.setValue(org.hl7.fhir.r5.model.ImagingStudy.ImagingStudyStatus.UNKNOWN);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.ImagingStudy.ImagingStudyStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ImagingStudy.ImagingStudyStatus> convertImagingStudyStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ImagingStudy.ImagingStudyStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ImagingStudy.ImagingStudyStatus> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.ImagingStudy.ImagingStudyStatusEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case REGISTERED:
        tgt.setValue(org.hl7.fhir.r4b.model.ImagingStudy.ImagingStudyStatus.REGISTERED);
        break;
      case AVAILABLE:
        tgt.setValue(org.hl7.fhir.r4b.model.ImagingStudy.ImagingStudyStatus.AVAILABLE);
        break;
      case CANCELLED:
        tgt.setValue(org.hl7.fhir.r4b.model.ImagingStudy.ImagingStudyStatus.CANCELLED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r4b.model.ImagingStudy.ImagingStudyStatus.ENTEREDINERROR);
        break;
      case UNKNOWN:
        tgt.setValue(org.hl7.fhir.r4b.model.ImagingStudy.ImagingStudyStatus.UNKNOWN);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.ImagingStudy.ImagingStudyStatus.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ImagingStudy.ImagingStudySeriesComponent convertImagingStudySeriesComponent(org.hl7.fhir.r4b.model.ImagingStudy.ImagingStudySeriesComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ImagingStudy.ImagingStudySeriesComponent tgt = new org.hl7.fhir.r5.model.ImagingStudy.ImagingStudySeriesComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasUid())
      tgt.setUidElement(Id43_50.convertId(src.getUidElement()));
    if (src.hasNumber())
      tgt.setNumberElement(UnsignedInt43_50.convertUnsignedInt(src.getNumberElement()));
    if (src.hasModality())
      tgt.setModality(new CodeableConcept().addCoding(Coding43_50.convertCoding(src.getModality())));
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_50.convertString(src.getDescriptionElement()));
    if (src.hasNumberOfInstances())
      tgt.setNumberOfInstancesElement(UnsignedInt43_50.convertUnsignedInt(src.getNumberOfInstancesElement()));
    for (org.hl7.fhir.r4b.model.Reference t : src.getEndpoint()) tgt.addEndpoint(Reference43_50.convertReference(t));
    if (src.hasBodySite())
      tgt.setBodySite(new CodeableReference(new CodeableConcept(Coding43_50.convertCoding(src.getBodySite()))));
    if (src.hasLaterality())
      tgt.setLaterality(new CodeableConcept(Coding43_50.convertCoding(src.getLaterality())));
    for (org.hl7.fhir.r4b.model.Reference t : src.getSpecimen()) tgt.addSpecimen(Reference43_50.convertReference(t));
    if (src.hasStarted())
      tgt.setStartedElement(DateTime43_50.convertDateTime(src.getStartedElement()));
    for (org.hl7.fhir.r4b.model.ImagingStudy.ImagingStudySeriesPerformerComponent t : src.getPerformer())
      tgt.addPerformer(convertImagingStudySeriesPerformerComponent(t));
    for (org.hl7.fhir.r4b.model.ImagingStudy.ImagingStudySeriesInstanceComponent t : src.getInstance())
      tgt.addInstance(convertImagingStudySeriesInstanceComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ImagingStudy.ImagingStudySeriesComponent convertImagingStudySeriesComponent(org.hl7.fhir.r5.model.ImagingStudy.ImagingStudySeriesComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ImagingStudy.ImagingStudySeriesComponent tgt = new org.hl7.fhir.r4b.model.ImagingStudy.ImagingStudySeriesComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasUid())
      tgt.setUidElement(Id43_50.convertId(src.getUidElement()));
    if (src.hasNumber())
      tgt.setNumberElement(UnsignedInt43_50.convertUnsignedInt(src.getNumberElement()));
    if (src.hasModality())
      tgt.setModality(Coding43_50.convertCoding(src.getModality().getCodingFirstRep()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_50.convertString(src.getDescriptionElement()));
    if (src.hasNumberOfInstances())
      tgt.setNumberOfInstancesElement(UnsignedInt43_50.convertUnsignedInt(src.getNumberOfInstancesElement()));
    for (org.hl7.fhir.r5.model.Reference t : src.getEndpoint()) tgt.addEndpoint(Reference43_50.convertReference(t));
    if (src.getBodySite().getConcept().hasCoding())
      tgt.setBodySite(Coding43_50.convertCoding(src.getBodySite().getConcept().getCodingFirstRep()));
    if (src.getLaterality().hasCoding())
      tgt.setLaterality(Coding43_50.convertCoding(src.getLaterality().getCodingFirstRep()));
    for (org.hl7.fhir.r5.model.Reference t : src.getSpecimen()) tgt.addSpecimen(Reference43_50.convertReference(t));
    if (src.hasStarted())
      tgt.setStartedElement(DateTime43_50.convertDateTime(src.getStartedElement()));
    for (org.hl7.fhir.r5.model.ImagingStudy.ImagingStudySeriesPerformerComponent t : src.getPerformer())
      tgt.addPerformer(convertImagingStudySeriesPerformerComponent(t));
    for (org.hl7.fhir.r5.model.ImagingStudy.ImagingStudySeriesInstanceComponent t : src.getInstance())
      tgt.addInstance(convertImagingStudySeriesInstanceComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ImagingStudy.ImagingStudySeriesPerformerComponent convertImagingStudySeriesPerformerComponent(org.hl7.fhir.r4b.model.ImagingStudy.ImagingStudySeriesPerformerComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ImagingStudy.ImagingStudySeriesPerformerComponent tgt = new org.hl7.fhir.r5.model.ImagingStudy.ImagingStudySeriesPerformerComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasFunction())
      tgt.setFunction(CodeableConcept43_50.convertCodeableConcept(src.getFunction()));
    if (src.hasActor())
      tgt.setActor(Reference43_50.convertReference(src.getActor()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ImagingStudy.ImagingStudySeriesPerformerComponent convertImagingStudySeriesPerformerComponent(org.hl7.fhir.r5.model.ImagingStudy.ImagingStudySeriesPerformerComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ImagingStudy.ImagingStudySeriesPerformerComponent tgt = new org.hl7.fhir.r4b.model.ImagingStudy.ImagingStudySeriesPerformerComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasFunction())
      tgt.setFunction(CodeableConcept43_50.convertCodeableConcept(src.getFunction()));
    if (src.hasActor())
      tgt.setActor(Reference43_50.convertReference(src.getActor()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ImagingStudy.ImagingStudySeriesInstanceComponent convertImagingStudySeriesInstanceComponent(org.hl7.fhir.r4b.model.ImagingStudy.ImagingStudySeriesInstanceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ImagingStudy.ImagingStudySeriesInstanceComponent tgt = new org.hl7.fhir.r5.model.ImagingStudy.ImagingStudySeriesInstanceComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasUid())
      tgt.setUidElement(Id43_50.convertId(src.getUidElement()));
    if (src.hasSopClass())
      tgt.setSopClass(Coding43_50.convertCoding(src.getSopClass()));
    if (src.hasNumber())
      tgt.setNumberElement(UnsignedInt43_50.convertUnsignedInt(src.getNumberElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String43_50.convertString(src.getTitleElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ImagingStudy.ImagingStudySeriesInstanceComponent convertImagingStudySeriesInstanceComponent(org.hl7.fhir.r5.model.ImagingStudy.ImagingStudySeriesInstanceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ImagingStudy.ImagingStudySeriesInstanceComponent tgt = new org.hl7.fhir.r4b.model.ImagingStudy.ImagingStudySeriesInstanceComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasUid())
      tgt.setUidElement(Id43_50.convertId(src.getUidElement()));
    if (src.hasSopClass())
      tgt.setSopClass(Coding43_50.convertCoding(src.getSopClass()));
    if (src.hasNumber())
      tgt.setNumberElement(UnsignedInt43_50.convertUnsignedInt(src.getNumberElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String43_50.convertString(src.getTitleElement()));
    return tgt;
  }
}