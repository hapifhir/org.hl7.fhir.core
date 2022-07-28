package org.hl7.fhir.convertors.conv43_50.resources43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Annotation43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.CodeableConcept43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Identifier43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.DateTime43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.String43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Uri43_50;
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
public class ClinicalImpression43_50 {

  public static org.hl7.fhir.r5.model.ClinicalImpression convertClinicalImpression(org.hl7.fhir.r4b.model.ClinicalImpression src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ClinicalImpression tgt = new org.hl7.fhir.r5.model.ClinicalImpression();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertClinicalImpressionStatus(src.getStatusElement()));
    if (src.hasStatusReason())
      tgt.setStatusReason(CodeableConcept43_50.convertCodeableConcept(src.getStatusReason()));
    // if (src.hasCode())
    // tgt.setCode(convertCodeableConcept(src.getCode()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_50.convertString(src.getDescriptionElement()));
    if (src.hasSubject())
      tgt.setSubject(Reference43_50.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference43_50.convertReference(src.getEncounter()));
    if (src.hasEffective())
      tgt.setEffective(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getEffective()));
    if (src.hasDate())
      tgt.setDateElement(DateTime43_50.convertDateTime(src.getDateElement()));
    if (src.hasAssessor())
      tgt.setPerformer(Reference43_50.convertReference(src.getAssessor()));
    if (src.hasPrevious())
      tgt.setPrevious(Reference43_50.convertReference(src.getPrevious()));
    for (org.hl7.fhir.r4b.model.Reference t : src.getProblem()) tgt.addProblem(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r4b.model.UriType t : src.getProtocol()) tgt.getProtocol().add(Uri43_50.convertUri(t));
    if (src.hasSummary())
      tgt.setSummaryElement(String43_50.convertString(src.getSummaryElement()));
    for (org.hl7.fhir.r4b.model.ClinicalImpression.ClinicalImpressionFindingComponent t : src.getFinding())
      tgt.addFinding(convertClinicalImpressionFindingComponent(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getPrognosisCodeableConcept())
      tgt.addPrognosisCodeableConcept(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getPrognosisReference())
      tgt.addPrognosisReference(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getSupportingInfo())
      tgt.addSupportingInfo(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r4b.model.Annotation t : src.getNote()) tgt.addNote(Annotation43_50.convertAnnotation(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ClinicalImpression convertClinicalImpression(org.hl7.fhir.r5.model.ClinicalImpression src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ClinicalImpression tgt = new org.hl7.fhir.r4b.model.ClinicalImpression();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertClinicalImpressionStatus(src.getStatusElement()));
    if (src.hasStatusReason())
      tgt.setStatusReason(CodeableConcept43_50.convertCodeableConcept(src.getStatusReason()));
    // if (src.hasCode())
    // tgt.setCode(convertCodeableConcept(src.getCode()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_50.convertString(src.getDescriptionElement()));
    if (src.hasSubject())
      tgt.setSubject(Reference43_50.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference43_50.convertReference(src.getEncounter()));
    if (src.hasEffective())
      tgt.setEffective(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getEffective()));
    if (src.hasDate())
      tgt.setDateElement(DateTime43_50.convertDateTime(src.getDateElement()));
    if (src.hasPerformer())
      tgt.setAssessor(Reference43_50.convertReference(src.getPerformer()));
    if (src.hasPrevious())
      tgt.setPrevious(Reference43_50.convertReference(src.getPrevious()));
    for (org.hl7.fhir.r5.model.Reference t : src.getProblem()) tgt.addProblem(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r5.model.UriType t : src.getProtocol()) tgt.getProtocol().add(Uri43_50.convertUri(t));
    if (src.hasSummary())
      tgt.setSummaryElement(String43_50.convertString(src.getSummaryElement()));
    for (org.hl7.fhir.r5.model.ClinicalImpression.ClinicalImpressionFindingComponent t : src.getFinding())
      tgt.addFinding(convertClinicalImpressionFindingComponent(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getPrognosisCodeableConcept())
      tgt.addPrognosisCodeableConcept(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getPrognosisReference())
      tgt.addPrognosisReference(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getSupportingInfo())
      tgt.addSupportingInfo(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.addNote(Annotation43_50.convertAnnotation(t));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.EventStatus> convertClinicalImpressionStatus(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ClinicalImpression.ClinicalImpressionStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.EventStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.EventStatusEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case INPROGRESS:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.EventStatus.INPROGRESS);
        break;
      case COMPLETED:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.EventStatus.COMPLETED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.EventStatus.ENTEREDINERROR);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.EventStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ClinicalImpression.ClinicalImpressionStatus> convertClinicalImpressionStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.EventStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ClinicalImpression.ClinicalImpressionStatus> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.ClinicalImpression.ClinicalImpressionStatusEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case INPROGRESS:
        tgt.setValue(org.hl7.fhir.r4b.model.ClinicalImpression.ClinicalImpressionStatus.INPROGRESS);
        break;
      case COMPLETED:
        tgt.setValue(org.hl7.fhir.r4b.model.ClinicalImpression.ClinicalImpressionStatus.COMPLETED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r4b.model.ClinicalImpression.ClinicalImpressionStatus.ENTEREDINERROR);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.ClinicalImpression.ClinicalImpressionStatus.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ClinicalImpression.ClinicalImpressionFindingComponent convertClinicalImpressionFindingComponent(org.hl7.fhir.r4b.model.ClinicalImpression.ClinicalImpressionFindingComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ClinicalImpression.ClinicalImpressionFindingComponent tgt = new org.hl7.fhir.r5.model.ClinicalImpression.ClinicalImpressionFindingComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasItemCodeableConcept())
      tgt.setItem(CodeableConcept43_50.convertCodeableConceptToCodeableReference(src.getItemCodeableConcept()));
    if (src.hasItemReference())
      tgt.setItem(Reference43_50.convertReferenceToCodeableReference(src.getItemReference()));
    if (src.hasBasis())
      tgt.setBasisElement(String43_50.convertString(src.getBasisElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ClinicalImpression.ClinicalImpressionFindingComponent convertClinicalImpressionFindingComponent(org.hl7.fhir.r5.model.ClinicalImpression.ClinicalImpressionFindingComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ClinicalImpression.ClinicalImpressionFindingComponent tgt = new org.hl7.fhir.r4b.model.ClinicalImpression.ClinicalImpressionFindingComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasItem() && src.getItem().hasConcept())
      tgt.setItemCodeableConcept(CodeableConcept43_50.convertCodeableConcept(src.getItem().getConcept()));
    if (src.hasItem() && src.getItem().hasReference())
      tgt.setItemReference(Reference43_50.convertReference(src.getItem().getReference()));
    if (src.hasBasis())
      tgt.setBasisElement(String43_50.convertString(src.getBasisElement()));
    return tgt;
  }
}