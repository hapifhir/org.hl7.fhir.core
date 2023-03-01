package org.hl7.fhir.convertors.conv40_50.resources40_50;

import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Annotation40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.CodeableConcept40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Coding40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Identifier40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.DateTime40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Id40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.String40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.UnsignedInt40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.special40_50.Reference40_50;
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
public class ImagingStudy40_50 {

  public static org.hl7.fhir.r5.model.ImagingStudy convertImagingStudy(org.hl7.fhir.r4.model.ImagingStudy src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ImagingStudy tgt = new org.hl7.fhir.r5.model.ImagingStudy();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_50.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertImagingStudyStatus(src.getStatusElement()));
    for (org.hl7.fhir.r4.model.Coding t : src.getModality())  
      tgt.addModality(new CodeableConcept().addCoding(Coding40_50.convertCoding(t)));
    if (src.hasSubject())
      tgt.setSubject(Reference40_50.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference40_50.convertReference(src.getEncounter()));
    if (src.hasStarted())
      tgt.setStartedElement(DateTime40_50.convertDateTime(src.getStartedElement()));
    for (org.hl7.fhir.r4.model.Reference t : src.getBasedOn()) tgt.addBasedOn(Reference40_50.convertReference(t));
    if (src.hasReferrer())
      tgt.setReferrer(Reference40_50.convertReference(src.getReferrer()));
//    for (org.hl7.fhir.r4.model.Reference t : src.getInterpreter())
//      tgt.addInterpreter(Reference40_50.convertReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getEndpoint()) tgt.addEndpoint(Reference40_50.convertReference(t));
    if (src.hasNumberOfSeries())
      tgt.setNumberOfSeriesElement(UnsignedInt40_50.convertUnsignedInt(src.getNumberOfSeriesElement()));
    if (src.hasNumberOfInstances())
      tgt.setNumberOfInstancesElement(UnsignedInt40_50.convertUnsignedInt(src.getNumberOfInstancesElement()));
    if (src.hasProcedureReference())
      tgt.addProcedure().setReference(Reference40_50.convertReference(src.getProcedureReference()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getProcedureCode())
      tgt.addProcedure().setConcept(CodeableConcept40_50.convertCodeableConcept(t));
    if (src.hasLocation())
      tgt.setLocation(Reference40_50.convertReference(src.getLocation()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReasonCode())
      tgt.addReason(CodeableConcept40_50.convertCodeableConceptToCodeableReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getReasonReference())
      tgt.addReason(Reference40_50.convertReferenceToCodeableReference(t));
    for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.addNote(Annotation40_50.convertAnnotation(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_50.convertString(src.getDescriptionElement()));
    for (org.hl7.fhir.r4.model.ImagingStudy.ImagingStudySeriesComponent t : src.getSeries())
      tgt.addSeries(convertImagingStudySeriesComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ImagingStudy convertImagingStudy(org.hl7.fhir.r5.model.ImagingStudy src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ImagingStudy tgt = new org.hl7.fhir.r4.model.ImagingStudy();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_50.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertImagingStudyStatus(src.getStatusElement()));
    for (CodeableConcept t : src.getModality())
      for (Coding tt : t.getCoding())
        tgt.addModality(Coding40_50.convertCoding(tt));
    if (src.hasSubject())
      tgt.setSubject(Reference40_50.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference40_50.convertReference(src.getEncounter()));
    if (src.hasStarted())
      tgt.setStartedElement(DateTime40_50.convertDateTime(src.getStartedElement()));
    for (org.hl7.fhir.r5.model.Reference t : src.getBasedOn()) tgt.addBasedOn(Reference40_50.convertReference(t));
    if (src.hasReferrer())
      tgt.setReferrer(Reference40_50.convertReference(src.getReferrer()));
//    for (org.hl7.fhir.r5.model.Reference t : src.getInterpreter())
//      tgt.addInterpreter(Reference40_50.convertReference(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getEndpoint()) tgt.addEndpoint(Reference40_50.convertReference(t));
    if (src.hasNumberOfSeries())
      tgt.setNumberOfSeriesElement(UnsignedInt40_50.convertUnsignedInt(src.getNumberOfSeriesElement()));
    if (src.hasNumberOfInstances())
      tgt.setNumberOfInstancesElement(UnsignedInt40_50.convertUnsignedInt(src.getNumberOfInstancesElement()));
    for (CodeableReference t : src.getProcedure()) {
      if (t.hasConcept())
        tgt.addProcedureCode(CodeableConcept40_50.convertCodeableConcept(t.getConcept()));
      if (t.hasReference()) {
        tgt.setProcedureReference(Reference40_50.convertReference(t.getReference()));
      }
    }
    if (src.hasLocation())
      tgt.setLocation(Reference40_50.convertReference(src.getLocation()));
    for (CodeableReference t : src.getReason())
      if (t.hasConcept())
        tgt.addReasonCode(CodeableConcept40_50.convertCodeableConcept(t.getConcept()));
    for (CodeableReference t : src.getReason())
      if (t.hasReference())
        tgt.addReasonReference(Reference40_50.convertReference(t.getReference()));
    for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.addNote(Annotation40_50.convertAnnotation(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_50.convertString(src.getDescriptionElement()));
    for (org.hl7.fhir.r5.model.ImagingStudy.ImagingStudySeriesComponent t : src.getSeries())
      tgt.addSeries(convertImagingStudySeriesComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ImagingStudy.ImagingStudyStatus> convertImagingStudyStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ImagingStudy.ImagingStudyStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ImagingStudy.ImagingStudyStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.ImagingStudy.ImagingStudyStatusEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ImagingStudy.ImagingStudyStatus> convertImagingStudyStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ImagingStudy.ImagingStudyStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ImagingStudy.ImagingStudyStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ImagingStudy.ImagingStudyStatusEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case REGISTERED:
        tgt.setValue(org.hl7.fhir.r4.model.ImagingStudy.ImagingStudyStatus.REGISTERED);
        break;
      case AVAILABLE:
        tgt.setValue(org.hl7.fhir.r4.model.ImagingStudy.ImagingStudyStatus.AVAILABLE);
        break;
      case CANCELLED:
        tgt.setValue(org.hl7.fhir.r4.model.ImagingStudy.ImagingStudyStatus.CANCELLED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r4.model.ImagingStudy.ImagingStudyStatus.ENTEREDINERROR);
        break;
      case UNKNOWN:
        tgt.setValue(org.hl7.fhir.r4.model.ImagingStudy.ImagingStudyStatus.UNKNOWN);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.ImagingStudy.ImagingStudyStatus.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ImagingStudy.ImagingStudySeriesComponent convertImagingStudySeriesComponent(org.hl7.fhir.r4.model.ImagingStudy.ImagingStudySeriesComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ImagingStudy.ImagingStudySeriesComponent tgt = new org.hl7.fhir.r5.model.ImagingStudy.ImagingStudySeriesComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasUid())
      tgt.setUidElement(Id40_50.convertId(src.getUidElement()));
    if (src.hasNumber())
      tgt.setNumberElement(UnsignedInt40_50.convertUnsignedInt(src.getNumberElement()));
    if (src.hasModality())
      tgt.setModality(new CodeableConcept().addCoding(Coding40_50.convertCoding(src.getModality())));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_50.convertString(src.getDescriptionElement()));
    if (src.hasNumberOfInstances())
      tgt.setNumberOfInstancesElement(UnsignedInt40_50.convertUnsignedInt(src.getNumberOfInstancesElement()));
    for (org.hl7.fhir.r4.model.Reference t : src.getEndpoint()) tgt.addEndpoint(Reference40_50.convertReference(t));
    if (src.hasBodySite())
      tgt.setBodySite(new CodeableReference(new CodeableConcept(Coding40_50.convertCoding(src.getBodySite()))));
    if (src.hasLaterality())
      tgt.setLaterality(new CodeableConcept(Coding40_50.convertCoding(src.getLaterality())));
    for (org.hl7.fhir.r4.model.Reference t : src.getSpecimen()) tgt.addSpecimen(Reference40_50.convertReference(t));
    if (src.hasStarted())
      tgt.setStartedElement(DateTime40_50.convertDateTime(src.getStartedElement()));
    for (org.hl7.fhir.r4.model.ImagingStudy.ImagingStudySeriesPerformerComponent t : src.getPerformer())
      tgt.addPerformer(convertImagingStudySeriesPerformerComponent(t));
    for (org.hl7.fhir.r4.model.ImagingStudy.ImagingStudySeriesInstanceComponent t : src.getInstance())
      tgt.addInstance(convertImagingStudySeriesInstanceComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ImagingStudy.ImagingStudySeriesComponent convertImagingStudySeriesComponent(org.hl7.fhir.r5.model.ImagingStudy.ImagingStudySeriesComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ImagingStudy.ImagingStudySeriesComponent tgt = new org.hl7.fhir.r4.model.ImagingStudy.ImagingStudySeriesComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasUid())
      tgt.setUidElement(Id40_50.convertId(src.getUidElement()));
    if (src.hasNumber())
      tgt.setNumberElement(UnsignedInt40_50.convertUnsignedInt(src.getNumberElement()));
    if (src.hasModality())
      tgt.setModality(Coding40_50.convertCoding(src.getModality().getCodingFirstRep()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_50.convertString(src.getDescriptionElement()));
    if (src.hasNumberOfInstances())
      tgt.setNumberOfInstancesElement(UnsignedInt40_50.convertUnsignedInt(src.getNumberOfInstancesElement()));
    for (org.hl7.fhir.r5.model.Reference t : src.getEndpoint()) tgt.addEndpoint(Reference40_50.convertReference(t));
    if (src.getBodySite().getConcept().hasCoding())
      tgt.setBodySite(Coding40_50.convertCoding(src.getBodySite().getConcept().getCodingFirstRep()));
    if (src.getLaterality().hasCoding())
      tgt.setLaterality(Coding40_50.convertCoding(src.getLaterality().getCodingFirstRep()));
    for (org.hl7.fhir.r5.model.Reference t : src.getSpecimen()) tgt.addSpecimen(Reference40_50.convertReference(t));
    if (src.hasStarted())
      tgt.setStartedElement(DateTime40_50.convertDateTime(src.getStartedElement()));
    for (org.hl7.fhir.r5.model.ImagingStudy.ImagingStudySeriesPerformerComponent t : src.getPerformer())
      tgt.addPerformer(convertImagingStudySeriesPerformerComponent(t));
    for (org.hl7.fhir.r5.model.ImagingStudy.ImagingStudySeriesInstanceComponent t : src.getInstance())
      tgt.addInstance(convertImagingStudySeriesInstanceComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ImagingStudy.ImagingStudySeriesPerformerComponent convertImagingStudySeriesPerformerComponent(org.hl7.fhir.r4.model.ImagingStudy.ImagingStudySeriesPerformerComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ImagingStudy.ImagingStudySeriesPerformerComponent tgt = new org.hl7.fhir.r5.model.ImagingStudy.ImagingStudySeriesPerformerComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasFunction())
      tgt.setFunction(CodeableConcept40_50.convertCodeableConcept(src.getFunction()));
    if (src.hasActor())
      tgt.setActor(Reference40_50.convertReference(src.getActor()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ImagingStudy.ImagingStudySeriesPerformerComponent convertImagingStudySeriesPerformerComponent(org.hl7.fhir.r5.model.ImagingStudy.ImagingStudySeriesPerformerComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ImagingStudy.ImagingStudySeriesPerformerComponent tgt = new org.hl7.fhir.r4.model.ImagingStudy.ImagingStudySeriesPerformerComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasFunction())
      tgt.setFunction(CodeableConcept40_50.convertCodeableConcept(src.getFunction()));
    if (src.hasActor())
      tgt.setActor(Reference40_50.convertReference(src.getActor()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ImagingStudy.ImagingStudySeriesInstanceComponent convertImagingStudySeriesInstanceComponent(org.hl7.fhir.r4.model.ImagingStudy.ImagingStudySeriesInstanceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ImagingStudy.ImagingStudySeriesInstanceComponent tgt = new org.hl7.fhir.r5.model.ImagingStudy.ImagingStudySeriesInstanceComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasUid())
      tgt.setUidElement(Id40_50.convertId(src.getUidElement()));
    if (src.hasSopClass())
      tgt.setSopClass(Coding40_50.convertCoding(src.getSopClass()));
    if (src.hasNumber())
      tgt.setNumberElement(UnsignedInt40_50.convertUnsignedInt(src.getNumberElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String40_50.convertString(src.getTitleElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ImagingStudy.ImagingStudySeriesInstanceComponent convertImagingStudySeriesInstanceComponent(org.hl7.fhir.r5.model.ImagingStudy.ImagingStudySeriesInstanceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ImagingStudy.ImagingStudySeriesInstanceComponent tgt = new org.hl7.fhir.r4.model.ImagingStudy.ImagingStudySeriesInstanceComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasUid())
      tgt.setUidElement(Id40_50.convertId(src.getUidElement()));
    if (src.hasSopClass())
      tgt.setSopClass(Coding40_50.convertCoding(src.getSopClass()));
    if (src.hasNumber())
      tgt.setNumberElement(UnsignedInt40_50.convertUnsignedInt(src.getNumberElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String40_50.convertString(src.getTitleElement()));
    return tgt;
  }
}