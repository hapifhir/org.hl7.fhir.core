package org.hl7.fhir.convertors.conv40_50.resources40_50;

import java.util.stream.Collectors;

import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Annotation40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.CodeableConcept40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Identifier40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.DateTime40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.String40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.special40_50.Reference40_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceParticipantComponent;
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
public class AllergyIntolerance40_50 {

  public static org.hl7.fhir.r5.model.AllergyIntolerance convertAllergyIntolerance(org.hl7.fhir.r4.model.AllergyIntolerance src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.AllergyIntolerance tgt = new org.hl7.fhir.r5.model.AllergyIntolerance();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_50.convertIdentifier(t));
    if (src.hasClinicalStatus())
      tgt.setClinicalStatus(CodeableConcept40_50.convertCodeableConcept(src.getClinicalStatus()));
    if (src.hasVerificationStatus())
      tgt.setVerificationStatus(CodeableConcept40_50.convertCodeableConcept(src.getVerificationStatus()));
    if (src.hasType())
      tgt.setType(convertAllergyIntoleranceType(src.getTypeElement()));
    tgt.setCategory(src.getCategory().stream()
      .map(AllergyIntolerance40_50::convertAllergyIntoleranceCategory)
      .collect(Collectors.toList()));
    if (src.hasCriticality())
      tgt.setCriticalityElement(convertAllergyIntoleranceCriticality(src.getCriticalityElement()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_50.convertCodeableConcept(src.getCode()));
    if (src.hasPatient())
      tgt.setPatient(Reference40_50.convertReference(src.getPatient()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference40_50.convertReference(src.getEncounter()));
    if (src.hasOnset())
      tgt.setOnset(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getOnset()));
    if (src.hasRecordedDate())
      tgt.setRecordedDateElement(DateTime40_50.convertDateTime(src.getRecordedDateElement()));
    if (src.hasRecorder())
      tgt.addParticipant(new AllergyIntoleranceParticipantComponent()
          .setFunction(new CodeableConcept().addCoding(new Coding("http://terminology.hl7.org/CodeSystem/provenance-participant-type", "author", "Author")))
          .setActor(Reference40_50.convertReference(src.getRecorder())));
    if (src.hasAsserter())
      tgt.addParticipant(new AllergyIntoleranceParticipantComponent()
          .setFunction(new CodeableConcept().addCoding(new Coding("http://terminology.hl7.org/CodeSystem/provenance-participant-type", "attester", "Attester")))
          .setActor(Reference40_50.convertReference(src.getRecorder())));
    if (src.hasLastOccurrence())
      tgt.setLastOccurrenceElement(DateTime40_50.convertDateTime(src.getLastOccurrenceElement()));
    for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.addNote(Annotation40_50.convertAnnotation(t));
    for (org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceReactionComponent t : src.getReaction())
      tgt.addReaction(convertAllergyIntoleranceReactionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.AllergyIntolerance convertAllergyIntolerance(org.hl7.fhir.r5.model.AllergyIntolerance src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.AllergyIntolerance tgt = new org.hl7.fhir.r4.model.AllergyIntolerance();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_50.convertIdentifier(t));
    if (src.hasClinicalStatus())
      tgt.setClinicalStatus(CodeableConcept40_50.convertCodeableConcept(src.getClinicalStatus()));
    if (src.hasVerificationStatus())
      tgt.setVerificationStatus(CodeableConcept40_50.convertCodeableConcept(src.getVerificationStatus()));
    if (src.hasType())
      tgt.setTypeElement(convertAllergyIntoleranceType(src.getType()));
    tgt.setCategory(src.getCategory().stream()
      .map(AllergyIntolerance40_50::convertAllergyIntoleranceCategory)
      .collect(Collectors.toList()));
    if (src.hasCriticality())
      tgt.setCriticalityElement(convertAllergyIntoleranceCriticality(src.getCriticalityElement()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_50.convertCodeableConcept(src.getCode()));
    if (src.hasPatient())
      tgt.setPatient(Reference40_50.convertReference(src.getPatient()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference40_50.convertReference(src.getEncounter()));
    if (src.hasOnset())
      tgt.setOnset(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getOnset()));
    if (src.hasRecordedDate())
      tgt.setRecordedDateElement(DateTime40_50.convertDateTime(src.getRecordedDateElement()));
    for (AllergyIntoleranceParticipantComponent t : src.getParticipant()) {
      if (t.getFunction().hasCoding("http://terminology.hl7.org/CodeSystem/provenance-participant-type", "author"))
        tgt.setRecorder(Reference40_50.convertReference(t.getActor()));
      if (t.getFunction().hasCoding("http://terminology.hl7.org/CodeSystem/provenance-participant-type", "attester"))
        tgt.setAsserter(Reference40_50.convertReference(t.getActor()));
    }
    if (src.hasLastOccurrence())
      tgt.setLastOccurrenceElement(DateTime40_50.convertDateTime(src.getLastOccurrenceElement()));
    for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.addNote(Annotation40_50.convertAnnotation(t));
    for (org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceReactionComponent t : src.getReaction())
      tgt.addReaction(convertAllergyIntoleranceReactionComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.CodeableConcept convertAllergyIntoleranceType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.CodeableConcept tgt = new org.hl7.fhir.r5.model.CodeableConcept();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
    case ALLERGY:
      tgt.addCoding("http://hl7.org/fhir/allergy-intolerance-type", "allergy", "Allergy");
      break;
    case INTOLERANCE:
      tgt.addCoding("http://hl7.org/fhir/allergy-intolerance-type", "intolerance", "Intolerance");
      break;
    default:
      break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceType> convertAllergyIntoleranceType(org.hl7.fhir.r5.model.CodeableConcept src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceTypeEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasCoding("http://hl7.org/fhir/allergy-intolerance-type", "allergy")) {
      tgt.setValue(org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceType.ALLERGY);
    } else if (src.hasCoding("http://hl7.org/fhir/allergy-intolerance-type", "intolerance")) {
      tgt.setValue(org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceType.INTOLERANCE);
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceCategory> convertAllergyIntoleranceCategory(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceCategory> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceCategory> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceCategoryEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case FOOD:
        tgt.setValue(org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceCategory.FOOD);
        break;
      case MEDICATION:
        tgt.setValue(org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceCategory.MEDICATION);
        break;
      case ENVIRONMENT:
        tgt.setValue(org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceCategory.ENVIRONMENT);
        break;
      case BIOLOGIC:
        tgt.setValue(org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceCategory.BIOLOGIC);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceCategory.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceCategory> convertAllergyIntoleranceCategory(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceCategory> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceCategory> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceCategoryEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case FOOD:
        tgt.setValue(org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceCategory.FOOD);
        break;
      case MEDICATION:
        tgt.setValue(org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceCategory.MEDICATION);
        break;
      case ENVIRONMENT:
        tgt.setValue(org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceCategory.ENVIRONMENT);
        break;
      case BIOLOGIC:
        tgt.setValue(org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceCategory.BIOLOGIC);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceCategory.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceCriticality> convertAllergyIntoleranceCriticality(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceCriticality> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceCriticality> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceCriticalityEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case LOW:
        tgt.setValue(org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceCriticality.LOW);
        break;
      case HIGH:
        tgt.setValue(org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceCriticality.HIGH);
        break;
      case UNABLETOASSESS:
        tgt.setValue(org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceCriticality.UNABLETOASSESS);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceCriticality.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceCriticality> convertAllergyIntoleranceCriticality(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceCriticality> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceCriticality> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceCriticalityEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case LOW:
        tgt.setValue(org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceCriticality.LOW);
        break;
      case HIGH:
        tgt.setValue(org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceCriticality.HIGH);
        break;
      case UNABLETOASSESS:
        tgt.setValue(org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceCriticality.UNABLETOASSESS);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceCriticality.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceReactionComponent convertAllergyIntoleranceReactionComponent(org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceReactionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceReactionComponent tgt = new org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceReactionComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasSubstance())
      tgt.setSubstance(CodeableConcept40_50.convertCodeableConcept(src.getSubstance()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getManifestation())
      tgt.addManifestation(new CodeableReference(CodeableConcept40_50.convertCodeableConcept(t)));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_50.convertString(src.getDescriptionElement()));
    if (src.hasOnset())
      tgt.setOnsetElement(DateTime40_50.convertDateTime(src.getOnsetElement()));
    if (src.hasSeverity())
      tgt.setSeverityElement(convertAllergyIntoleranceSeverity(src.getSeverityElement()));
    if (src.hasExposureRoute())
      tgt.setExposureRoute(CodeableConcept40_50.convertCodeableConcept(src.getExposureRoute()));
    for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.addNote(Annotation40_50.convertAnnotation(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceReactionComponent convertAllergyIntoleranceReactionComponent(org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceReactionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceReactionComponent tgt = new org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceReactionComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasSubstance())
      tgt.setSubstance(CodeableConcept40_50.convertCodeableConcept(src.getSubstance()));
    for (CodeableReference t : src.getManifestation())
      if (t.hasConcept()) tgt.addManifestation(CodeableConcept40_50.convertCodeableConcept(t.getConcept()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_50.convertString(src.getDescriptionElement()));
    if (src.hasOnset())
      tgt.setOnsetElement(DateTime40_50.convertDateTime(src.getOnsetElement()));
    if (src.hasSeverity())
      tgt.setSeverityElement(convertAllergyIntoleranceSeverity(src.getSeverityElement()));
    if (src.hasExposureRoute())
      tgt.setExposureRoute(CodeableConcept40_50.convertCodeableConcept(src.getExposureRoute()));
    for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.addNote(Annotation40_50.convertAnnotation(t));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceSeverity> convertAllergyIntoleranceSeverity(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceSeverity> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceSeverity> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceSeverityEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case MILD:
        tgt.setValue(org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceSeverity.MILD);
        break;
      case MODERATE:
        tgt.setValue(org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceSeverity.MODERATE);
        break;
      case SEVERE:
        tgt.setValue(org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceSeverity.SEVERE);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceSeverity.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceSeverity> convertAllergyIntoleranceSeverity(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceSeverity> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceSeverity> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceSeverityEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case MILD:
        tgt.setValue(org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceSeverity.MILD);
        break;
      case MODERATE:
        tgt.setValue(org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceSeverity.MODERATE);
        break;
      case SEVERE:
        tgt.setValue(org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceSeverity.SEVERE);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceSeverity.NULL);
        break;
    }
    return tgt;
  }
}