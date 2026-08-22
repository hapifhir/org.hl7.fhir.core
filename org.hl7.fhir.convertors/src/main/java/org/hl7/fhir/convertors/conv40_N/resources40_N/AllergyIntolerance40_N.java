package org.hl7.fhir.convertors.conv40_N.resources40_N;

import java.util.stream.Collectors;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Annotation40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Identifier40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.DateTime40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.String40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Reference40_N;
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

public class AllergyIntolerance40_N {

  public static org.hl7.fhir.model.core.AllergyIntolerance convertAllergyIntolerance(org.hl7.fhir.r4.model.AllergyIntolerance src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.AllergyIntolerance tgt = new org.hl7.fhir.model.core.AllergyIntolerance();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    if (src.hasClinicalStatus())
      tgt.setClinicalStatus(CodeableConcept40_N.convertCodeableConcept(src.getClinicalStatus()));
    if (src.hasVerificationStatus())
      tgt.setVerificationStatus(CodeableConcept40_N.convertCodeableConcept(src.getVerificationStatus()));
    if (src.hasType())
      tgt.setType(convertAllergyIntoleranceType(src.getTypeElement()));
    tgt.setCategoryList(src.getCategory().stream()
      .map(AllergyIntolerance40_N::convertAllergyIntoleranceCategory)
      .collect(Collectors.toList()));
    if (src.hasCriticality())
      tgt.setCriticalityElement(convertAllergyIntoleranceCriticality(src.getCriticalityElement()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_N.convertCodeableConcept(src.getCode()));
    if (src.hasPatient())
      tgt.setPatient(Reference40_N.convertReference(src.getPatient()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference40_N.convertReference(src.getEncounter()));
    if (src.hasOnset())
      tgt.setOnset(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getOnset()));
    if (src.hasRecordedDate())
      tgt.setRecordedDateElement(DateTime40_N.convertDateTime(src.getRecordedDateElement()));
    if (src.hasRecorder())
      tgt.setRecorder(Reference40_N.convertReference(src.getRecorder()));
    if (src.hasAsserter())
      tgt.setRecorder(Reference40_N.convertReference(src.getRecorder()));
    if (src.hasLastOccurrence())
      tgt.setLastOccurrenceElement(DateTime40_N.convertDateTime(src.getLastOccurrenceElement()));
    for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.addNote(Annotation40_N.convertAnnotation(t));
    for (org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceReactionComponent t : src.getReaction())
      tgt.addReaction(convertAllergyIntoleranceReactionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.AllergyIntolerance convertAllergyIntolerance(org.hl7.fhir.model.core.AllergyIntolerance src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.AllergyIntolerance tgt = new org.hl7.fhir.r4.model.AllergyIntolerance();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    if (src.hasClinicalStatus())
      tgt.setClinicalStatus(CodeableConcept40_N.convertCodeableConcept(src.getClinicalStatus()));
    if (src.hasVerificationStatus())
      tgt.setVerificationStatus(CodeableConcept40_N.convertCodeableConcept(src.getVerificationStatus()));
    if (src.hasType())
      tgt.setTypeElement(convertAllergyIntoleranceType(src.getType()));
    tgt.setCategory(src.getCategoryList().stream()
      .map(AllergyIntolerance40_N::convertAllergyIntoleranceCategory)
      .collect(Collectors.toList()));
    if (src.hasCriticality())
      tgt.setCriticalityElement(convertAllergyIntoleranceCriticality(src.getCriticalityElement()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_N.convertCodeableConcept(src.getCode()));
    if (src.hasPatient())
      tgt.setPatient(Reference40_N.convertReference(src.getPatient()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference40_N.convertReference(src.getEncounter()));
    if (src.hasOnset())
      tgt.setOnset(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getOnset()));
    if (src.hasRecordedDate())
      tgt.setRecordedDateElement(DateTime40_N.convertDateTime(src.getRecordedDateElement()));
    tgt.setRecorder(Reference40_N.convertReference(src.getRecorder()));
    if (src.hasLastOccurrence())
      tgt.setLastOccurrenceElement(DateTime40_N.convertDateTime(src.getLastOccurrenceElement()));
    for (org.hl7.fhir.model.core.Annotation t : src.getNoteList()) tgt.addNote(Annotation40_N.convertAnnotation(t));
    for (org.hl7.fhir.model.core.AllergyIntolerance.AllergyIntoleranceReactionComponent t : src.getReactionList())
      tgt.addReaction(convertAllergyIntoleranceReactionComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.CodeableConcept convertAllergyIntoleranceType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      CodeableConcept tgt = new CodeableConcept();
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
        // Add nothing
      } else {
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
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceType> convertAllergyIntoleranceType(org.hl7.fhir.model.core.CodeableConcept src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceTypeEnumFactory());
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasCoding("http://hl7.org/fhir/allergy-intolerance-type", "allergy")) {
      tgt.setValue(org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceType.ALLERGY);
    } else if (src.hasCoding("http://hl7.org/fhir/allergy-intolerance-type", "intolerance")) {
      tgt.setValue(org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceType.INTOLERANCE);
    }
    return tgt;
  }

  static public org.hl7.fhir.model.core.CodeableConcept convertAllergyIntoleranceCategory(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceCategory> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
    CodeableConcept tgt = new CodeableConcept();
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() != null) {
          switch (src.getValue()) {
              case FOOD:
                  tgt.addCoding("http://hl7.org/fhir/ValueSet/allergy-intolerance-category", "food", "Food");
                  break;
              case MEDICATION:
                tgt.addCoding("http://hl7.org/fhir/ValueSet/allergy-intolerance-category", "medication", "Medication");
                  break;
              case ENVIRONMENT:
                tgt.addCoding("http://hl7.org/fhir/ValueSet/allergy-intolerance-category", "environment", "Environment");
                  break;
              case BIOLOGIC:
                tgt.addCoding("http://hl7.org/fhir/ValueSet/allergy-intolerance-category", "biologic", "Biologic");
                  break;
              default:
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceCategory> convertAllergyIntoleranceCategory(org.hl7.fhir.model.core.CodeableConcept src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceCategory> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceCategoryEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.hasCoding("http://hl7.org/fhir/ValueSet/allergy-intolerance-category", "food")) {
        tgt.setValue(org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceCategory.FOOD);
      } else if (src.hasCoding("http://hl7.org/fhir/ValueSet/allergy-intolerance-category", "medication")) {
        tgt.setValue(org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceCategory.MEDICATION);
      } else if (src.hasCoding("http://hl7.org/fhir/ValueSet/allergy-intolerance-category", "environment")) {
        tgt.setValue(org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceCategory.ENVIRONMENT);
      } else if (src.hasCoding("http://hl7.org/fhir/ValueSet/allergy-intolerance-category", "biologic")) {
        tgt.setValue(org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceCategory.BIOLOGIC);
      }
      return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.AllergyIntolerance.AllergyIntoleranceCriticality> convertAllergyIntoleranceCriticality(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceCriticality> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<AllergyIntolerance.AllergyIntoleranceCriticality> tgt = new Enumeration<>(new AllergyIntolerance.AllergyIntoleranceCriticalityEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case LOW:
                  tgt.setValue(AllergyIntolerance.AllergyIntoleranceCriticality.LOW);
                  break;
              case HIGH:
                  tgt.setValue(AllergyIntolerance.AllergyIntoleranceCriticality.HIGH);
                  break;
              case UNABLETOASSESS:
                  tgt.setValue(AllergyIntolerance.AllergyIntoleranceCriticality.UNABLETOASSESS);
                  break;
              default:
                  tgt.setValue(AllergyIntolerance.AllergyIntoleranceCriticality.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceCriticality> convertAllergyIntoleranceCriticality(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.AllergyIntolerance.AllergyIntoleranceCriticality> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceCriticality> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceCriticalityEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
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
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.AllergyIntolerance.AllergyIntoleranceReactionComponent convertAllergyIntoleranceReactionComponent(org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceReactionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.AllergyIntolerance.AllergyIntoleranceReactionComponent tgt = new org.hl7.fhir.model.core.AllergyIntolerance.AllergyIntoleranceReactionComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasSubstance())
      tgt.setSubstance(CodeableConcept40_N.convertCodeableConcept(src.getSubstance()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getManifestation())
      tgt.addManifestation(new CodeableReference(CodeableConcept40_N.convertCodeableConcept(t)));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_N.convertString(src.getDescriptionElement()));
    if (src.hasOnset())
      tgt.setOnsetElement(DateTime40_N.convertDateTime(src.getOnsetElement()));
    if (src.hasSeverity())
      tgt.setSeverityElement(convertAllergyIntoleranceSeverity(src.getSeverityElement()));
    if (src.hasExposureRoute())
      tgt.setExposureRoute(CodeableConcept40_N.convertCodeableConcept(src.getExposureRoute()));
    for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.addNote(Annotation40_N.convertAnnotation(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceReactionComponent convertAllergyIntoleranceReactionComponent(org.hl7.fhir.model.core.AllergyIntolerance.AllergyIntoleranceReactionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceReactionComponent tgt = new org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceReactionComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasSubstance())
      tgt.setSubstance(CodeableConcept40_N.convertCodeableConcept(src.getSubstance()));
    for (CodeableReference t : src.getManifestationList())
      if (t.hasConcept()) tgt.addManifestation(CodeableConcept40_N.convertCodeableConcept(t.getConcept()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_N.convertString(src.getDescriptionElement()));
    if (src.hasOnset())
      tgt.setOnsetElement(DateTime40_N.convertDateTime(src.getOnsetElement()));
    if (src.hasSeverity())
      tgt.setSeverityElement(convertAllergyIntoleranceSeverity(src.getSeverityElement()));
    if (src.hasExposureRoute())
      tgt.setExposureRoute(CodeableConcept40_N.convertCodeableConcept(src.getExposureRoute()));
    for (org.hl7.fhir.model.core.Annotation t : src.getNoteList()) tgt.addNote(Annotation40_N.convertAnnotation(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.AllergyIntolerance.AllergyIntoleranceSeverity> convertAllergyIntoleranceSeverity(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceSeverity> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<AllergyIntolerance.AllergyIntoleranceSeverity> tgt = new Enumeration<>(new AllergyIntolerance.AllergyIntoleranceSeverityEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case MILD:
                  tgt.setValue(AllergyIntolerance.AllergyIntoleranceSeverity.MILD);
                  break;
              case MODERATE:
                  tgt.setValue(AllergyIntolerance.AllergyIntoleranceSeverity.MODERATE);
                  break;
              case SEVERE:
                  tgt.setValue(AllergyIntolerance.AllergyIntoleranceSeverity.SEVERE);
                  break;
              default:
                  tgt.setValue(AllergyIntolerance.AllergyIntoleranceSeverity.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceSeverity> convertAllergyIntoleranceSeverity(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.AllergyIntolerance.AllergyIntoleranceSeverity> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceSeverity> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceSeverityEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
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
      }
      return tgt;
  }
}