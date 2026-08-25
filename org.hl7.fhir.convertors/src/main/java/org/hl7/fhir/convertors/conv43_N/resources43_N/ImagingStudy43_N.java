package org.hl7.fhir.convertors.conv43_N.resources43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Annotation43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.CodeableConcept43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Coding43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Identifier43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.DateTime43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Id43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.String43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.UnsignedInt43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.special43_N.Reference43_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.*;

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

public class ImagingStudy43_N {

  public static org.hl7.fhir.model.core.ImagingStudy convertImagingStudy(org.hl7.fhir.r4b.model.ImagingStudy src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ImagingStudy tgt = new org.hl7.fhir.model.core.ImagingStudy();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertImagingStudyStatus(src.getStatusElement()));
    for (org.hl7.fhir.r4b.model.Coding t : src.getModality())  
      tgt.addModality(new CodeableConcept().addCoding(Coding43_N.convertCoding(t)));
    if (src.hasSubject())
      tgt.setSubject(Reference43_N.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference43_N.convertReference(src.getEncounter()));
    if (src.hasStarted())
      tgt.setStartedElement(DateTime43_N.convertDateTime(src.getStartedElement()));
    for (org.hl7.fhir.r4b.model.Reference t : src.getBasedOn()) tgt.addBasedOn(Reference43_N.convertReference(t));
    if (src.hasReferrer())
      tgt.setReferrer(Reference43_N.convertReference(src.getReferrer()));
//    for (org.hl7.fhir.r4b.model.Reference t : src.getInterpreter())
//      tgt.addInterpreter(Reference43_N.convertReference(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getEndpoint()) tgt.addEndpoint(Reference43_N.convertReference(t));
    if (src.hasNumberOfSeries())
      tgt.setNumberOfSeriesElement(UnsignedInt43_N.convertUnsignedInt(src.getNumberOfSeriesElement()));
    if (src.hasNumberOfInstances())
      tgt.setNumberOfInstancesElement(UnsignedInt43_N.convertUnsignedInt(src.getNumberOfInstancesElement()));
    if (src.hasProcedureReference())
      tgt.addProcedure(Reference43_N.convertReference(src.getProcedureReference()));
    if (src.hasLocation())
      tgt.setLocation(Reference43_N.convertReference(src.getLocation()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getReasonCode())
      tgt.addReason(CodeableConcept43_N.convertCodeableConceptToCodeableReference(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getReasonReference())
      tgt.addReason(Reference43_N.convertReferenceToCodeableReference(t));
    for (org.hl7.fhir.r4b.model.Annotation t : src.getNote()) tgt.addNote(Annotation43_N.convertAnnotation(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_N.convertString(src.getDescriptionElement()));
    for (org.hl7.fhir.r4b.model.ImagingStudy.ImagingStudySeriesComponent t : src.getSeries())
      tgt.addSeries(convertImagingStudySeriesComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ImagingStudy convertImagingStudy(org.hl7.fhir.model.core.ImagingStudy src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ImagingStudy tgt = new org.hl7.fhir.r4b.model.ImagingStudy();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertImagingStudyStatus(src.getStatusElement()));
    for (CodeableConcept t : src.getModalityList())
      for (Coding tt : t.getCodingList())
        tgt.addModality(Coding43_N.convertCoding(tt));
    if (src.hasSubject())
      tgt.setSubject(Reference43_N.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference43_N.convertReference(src.getEncounter()));
    if (src.hasStarted())
      tgt.setStartedElement(DateTime43_N.convertDateTime(src.getStartedElement()));
    for (org.hl7.fhir.model.core.Reference t : src.getBasedOnList()) tgt.addBasedOn(Reference43_N.convertReference(t));
    if (src.hasReferrer())
      tgt.setReferrer(Reference43_N.convertReference(src.getReferrer()));
//    for (org.hl7.fhir.model.core.Reference t : src.getInterpreterList())
//      tgt.addInterpreter(Reference43_N.convertReference(t));
    for (org.hl7.fhir.model.core.Reference t : src.getEndpointList()) tgt.addEndpoint(Reference43_N.convertReference(t));
    if (src.hasNumberOfSeries())
      tgt.setNumberOfSeriesElement(UnsignedInt43_N.convertUnsignedInt(src.getNumberOfSeriesElement()));
    if (src.hasNumberOfInstances())
      tgt.setNumberOfInstancesElement(UnsignedInt43_N.convertUnsignedInt(src.getNumberOfInstancesElement()));
    for (Reference t : src.getProcedureList()) {
      tgt.setProcedureReference(Reference43_N.convertReference(t));
    }
    if (src.hasLocation())
      tgt.setLocation(Reference43_N.convertReference(src.getLocation()));
    for (CodeableReference t : src.getReasonList())
      if (t.hasConcept())
        tgt.addReasonCode(CodeableConcept43_N.convertCodeableConcept(t.getConcept()));
    for (CodeableReference t : src.getReasonList())
      if (t.hasReference())
        tgt.addReasonReference(Reference43_N.convertReference(t.getReference()));
    for (org.hl7.fhir.model.core.Annotation t : src.getNoteList()) tgt.addNote(Annotation43_N.convertAnnotation(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_N.convertString(src.getDescriptionElement()));
    for (org.hl7.fhir.model.core.ImagingStudy.ImagingStudySeriesComponent t : src.getSeriesList())
      tgt.addSeries(convertImagingStudySeriesComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.ImagingStudy.ImagingStudyStatus> convertImagingStudyStatus(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ImagingStudy.ImagingStudyStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<ImagingStudy.ImagingStudyStatus> tgt = new Enumeration<>(new ImagingStudy.ImagingStudyStatusEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case REGISTERED:
                  tgt.setValue(ImagingStudy.ImagingStudyStatus.REGISTERED);
                  break;
              case AVAILABLE:
                  tgt.setValue(ImagingStudy.ImagingStudyStatus.AVAILABLE);
                  break;
              case CANCELLED:
                  tgt.setValue(ImagingStudy.ImagingStudyStatus.CANCELLED);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(ImagingStudy.ImagingStudyStatus.ENTEREDINERROR);
                  break;
              case UNKNOWN:
                  tgt.setValue(ImagingStudy.ImagingStudyStatus.UNKNOWN);
                  break;
              default:
                  tgt.setValue(ImagingStudy.ImagingStudyStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ImagingStudy.ImagingStudyStatus> convertImagingStudyStatus(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.ImagingStudy.ImagingStudyStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ImagingStudy.ImagingStudyStatus> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.ImagingStudy.ImagingStudyStatusEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
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
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.ImagingStudy.ImagingStudySeriesComponent convertImagingStudySeriesComponent(org.hl7.fhir.r4b.model.ImagingStudy.ImagingStudySeriesComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ImagingStudy.ImagingStudySeriesComponent tgt = new org.hl7.fhir.model.core.ImagingStudy.ImagingStudySeriesComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasUid())
      tgt.setUidElement(Id43_N.convertId(src.getUidElement()));
    if (src.hasNumber())
      tgt.setNumberElement(UnsignedInt43_N.convertUnsignedInt(src.getNumberElement()));
    if (src.hasModality())
      tgt.setModality(new CodeableConcept().addCoding(Coding43_N.convertCoding(src.getModality())));
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_N.convertString(src.getDescriptionElement()));
    if (src.hasNumberOfInstances())
      tgt.setNumberOfInstancesElement(UnsignedInt43_N.convertUnsignedInt(src.getNumberOfInstancesElement()));
    for (org.hl7.fhir.r4b.model.Reference t : src.getEndpoint()) tgt.addEndpoint(Reference43_N.convertReference(t));
    if (src.hasBodySite())
      tgt.addBodySite(new CodeableReference(new CodeableConcept(Coding43_N.convertCoding(src.getBodySite()))));
    for (org.hl7.fhir.r4b.model.Reference t : src.getSpecimen()) tgt.addSpecimen(Reference43_N.convertReference(t));
    if (src.hasStarted())
      tgt.setStartedElement(DateTime43_N.convertDateTime(src.getStartedElement()));
    for (org.hl7.fhir.r4b.model.ImagingStudy.ImagingStudySeriesPerformerComponent t : src.getPerformer())
      tgt.addPerformer(convertImagingStudySeriesPerformerComponent(t));
    for (org.hl7.fhir.r4b.model.ImagingStudy.ImagingStudySeriesInstanceComponent t : src.getInstance())
      tgt.addInstance(convertImagingStudySeriesInstanceComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ImagingStudy.ImagingStudySeriesComponent convertImagingStudySeriesComponent(org.hl7.fhir.model.core.ImagingStudy.ImagingStudySeriesComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ImagingStudy.ImagingStudySeriesComponent tgt = new org.hl7.fhir.r4b.model.ImagingStudy.ImagingStudySeriesComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasUid())
      tgt.setUidElement(Id43_N.convertId(src.getUidElement()));
    if (src.hasNumber())
      tgt.setNumberElement(UnsignedInt43_N.convertUnsignedInt(src.getNumberElement()));
    if (src.hasModality())
      tgt.setModality(Coding43_N.convertCoding(src.getModality().getCodingFirstRep()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_N.convertString(src.getDescriptionElement()));
    if (src.hasNumberOfInstances())
      tgt.setNumberOfInstancesElement(UnsignedInt43_N.convertUnsignedInt(src.getNumberOfInstancesElement()));
    for (org.hl7.fhir.model.core.Reference t : src.getEndpointList()) tgt.addEndpoint(Reference43_N.convertReference(t));
    if (src.getBodySiteFirstRep().getConcept().hasCoding())
      tgt.setBodySite(Coding43_N.convertCoding(src.getBodySiteFirstRep().getConcept().getCodingFirstRep()));
    for (org.hl7.fhir.model.core.Reference t : src.getSpecimenList()) tgt.addSpecimen(Reference43_N.convertReference(t));
    if (src.hasStarted())
      tgt.setStartedElement(DateTime43_N.convertDateTime(src.getStartedElement()));
    for (org.hl7.fhir.model.core.ImagingStudy.ImagingStudySeriesPerformerComponent t : src.getPerformerList())
      tgt.addPerformer(convertImagingStudySeriesPerformerComponent(t));
    for (org.hl7.fhir.model.core.ImagingStudy.ImagingStudySeriesInstanceComponent t : src.getInstanceList())
      tgt.addInstance(convertImagingStudySeriesInstanceComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ImagingStudy.ImagingStudySeriesPerformerComponent convertImagingStudySeriesPerformerComponent(org.hl7.fhir.r4b.model.ImagingStudy.ImagingStudySeriesPerformerComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ImagingStudy.ImagingStudySeriesPerformerComponent tgt = new org.hl7.fhir.model.core.ImagingStudy.ImagingStudySeriesPerformerComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasFunction())
      tgt.setFunction(CodeableConcept43_N.convertCodeableConcept(src.getFunction()));
    if (src.hasActor())
      tgt.setActor(Reference43_N.convertReference(src.getActor()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ImagingStudy.ImagingStudySeriesPerformerComponent convertImagingStudySeriesPerformerComponent(org.hl7.fhir.model.core.ImagingStudy.ImagingStudySeriesPerformerComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ImagingStudy.ImagingStudySeriesPerformerComponent tgt = new org.hl7.fhir.r4b.model.ImagingStudy.ImagingStudySeriesPerformerComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasFunction())
      tgt.setFunction(CodeableConcept43_N.convertCodeableConcept(src.getFunction()));
    if (src.hasActor())
      tgt.setActor(Reference43_N.convertReference(src.getActor()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.ImagingStudy.ImagingStudySeriesInstanceComponent convertImagingStudySeriesInstanceComponent(org.hl7.fhir.r4b.model.ImagingStudy.ImagingStudySeriesInstanceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ImagingStudy.ImagingStudySeriesInstanceComponent tgt = new org.hl7.fhir.model.core.ImagingStudy.ImagingStudySeriesInstanceComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasUid())
      tgt.setUidElement(Id43_N.convertId(src.getUidElement()));
    if (src.hasNumber())
      tgt.setNumberElement(UnsignedInt43_N.convertUnsignedInt(src.getNumberElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String43_N.convertString(src.getTitleElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ImagingStudy.ImagingStudySeriesInstanceComponent convertImagingStudySeriesInstanceComponent(org.hl7.fhir.model.core.ImagingStudy.ImagingStudySeriesInstanceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ImagingStudy.ImagingStudySeriesInstanceComponent tgt = new org.hl7.fhir.r4b.model.ImagingStudy.ImagingStudySeriesInstanceComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasUid())
      tgt.setUidElement(Id43_N.convertId(src.getUidElement()));
    if (src.hasNumber())
      tgt.setNumberElement(UnsignedInt43_N.convertUnsignedInt(src.getNumberElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String43_N.convertString(src.getTitleElement()));
    return tgt;
  }
}