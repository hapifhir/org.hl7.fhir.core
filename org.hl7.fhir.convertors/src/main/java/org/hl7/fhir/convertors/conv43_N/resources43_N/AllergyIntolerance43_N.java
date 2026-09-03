package org.hl7.fhir.convertors.conv43_N.resources43_N;

import java.util.stream.Collectors;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Annotation43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.CodeableConcept43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Identifier43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.DateTime43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.String43_N;
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

public class AllergyIntolerance43_N {

  public static org.hl7.fhir.model.core.AllergyIntolerance convertAllergyIntolerance(org.hl7.fhir.r4b.model.AllergyIntolerance src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.AllergyIntolerance tgt = new org.hl7.fhir.model.core.AllergyIntolerance();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    if (src.hasClinicalStatus())
      tgt.setClinicalStatus(CodeableConcept43_N.convertCodeableConcept(src.getClinicalStatus()));
    if (src.hasVerificationStatus())
      tgt.setVerificationStatus(CodeableConcept43_N.convertCodeableConcept(src.getVerificationStatus()));
    if (src.hasType())
      tgt.setType(convertAllergyIntoleranceType(src.getTypeElement()));
    tgt.setCategoryList(src.getCategory().stream()
      .map(AllergyIntolerance43_N::convertAllergyIntoleranceCategory)
      .collect(Collectors.toList()));
    if (src.hasCriticality())
      tgt.setCriticalityElement(convertAllergyIntoleranceCriticality(src.getCriticalityElement()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_N.convertCodeableConcept(src.getCode()));
    if (src.hasPatient())
      tgt.setPatient(Reference43_N.convertReference(src.getPatient()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference43_N.convertReference(src.getEncounter()));
    if (src.hasOnset())
      tgt.setOnset(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getOnset()));
    if (src.hasRecordedDate())
      tgt.setRecordedDateElement(DateTime43_N.convertDateTime(src.getRecordedDateElement()));
    if (src.hasRecorder())
      tgt.setRecorder(Reference43_N.convertReference(src.getRecorder()));
    if (src.hasAsserter())
      tgt.setRecorder(Reference43_N.convertReference(src.getRecorder()));
    if (src.hasLastOccurrence())
      tgt.setLastOccurrenceElement(DateTime43_N.convertDateTime(src.getLastOccurrenceElement()));
    for (org.hl7.fhir.r4b.model.Annotation t : src.getNote()) tgt.addNote(Annotation43_N.convertAnnotation(t));
    for (org.hl7.fhir.r4b.model.AllergyIntolerance.AllergyIntoleranceReactionComponent t : src.getReaction())
      tgt.addReaction(convertAllergyIntoleranceReactionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.AllergyIntolerance convertAllergyIntolerance(org.hl7.fhir.model.core.AllergyIntolerance src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.AllergyIntolerance tgt = new org.hl7.fhir.r4b.model.AllergyIntolerance();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    if (src.hasClinicalStatus())
      tgt.setClinicalStatus(CodeableConcept43_N.convertCodeableConcept(src.getClinicalStatus()));
    if (src.hasVerificationStatus())
      tgt.setVerificationStatus(CodeableConcept43_N.convertCodeableConcept(src.getVerificationStatus()));
    if (src.hasType())
      tgt.setTypeElement(convertAllergyIntoleranceType(src.getType()));
    tgt.setCategory(src.getCategoryList().stream()
      .map(AllergyIntolerance43_N::convertAllergyIntoleranceCategory)
      .collect(Collectors.toList()));
    if (src.hasCriticality())
      tgt.setCriticalityElement(convertAllergyIntoleranceCriticality(src.getCriticalityElement()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_N.convertCodeableConcept(src.getCode()));
    if (src.hasPatient())
      tgt.setPatient(Reference43_N.convertReference(src.getPatient()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference43_N.convertReference(src.getEncounter()));
    if (src.hasOnset())
      tgt.setOnset(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getOnset()));
    if (src.hasRecordedDate())
      tgt.setRecordedDateElement(DateTime43_N.convertDateTime(src.getRecordedDateElement()));
    tgt.setRecorder(Reference43_N.convertReference(src.getRecorder()));
    if (src.hasLastOccurrence())
      tgt.setLastOccurrenceElement(DateTime43_N.convertDateTime(src.getLastOccurrenceElement()));
    for (org.hl7.fhir.model.core.Annotation t : src.getNoteList()) tgt.addNote(Annotation43_N.convertAnnotation(t));
    for (org.hl7.fhir.model.core.AllergyIntolerance.AllergyIntoleranceReactionComponent t : src.getReactionList())
      tgt.addReaction(convertAllergyIntoleranceReactionComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.CodeableConcept convertAllergyIntoleranceType(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.AllergyIntolerance.AllergyIntoleranceType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      CodeableConcept tgt = new CodeableConcept();
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.AllergyIntolerance.AllergyIntoleranceType> convertAllergyIntoleranceType(org.hl7.fhir.model.core.CodeableConcept src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.AllergyIntolerance.AllergyIntoleranceType> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.AllergyIntolerance.AllergyIntoleranceTypeEnumFactory());
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.hasCoding("http://hl7.org/fhir/allergy-intolerance-type", "allergy")) {
      tgt.setValue(org.hl7.fhir.r4b.model.AllergyIntolerance.AllergyIntoleranceType.ALLERGY);
    } else if (src.hasCoding("http://hl7.org/fhir/allergy-intolerance-type", "intolerance")) {
      tgt.setValue(org.hl7.fhir.r4b.model.AllergyIntolerance.AllergyIntoleranceType.INTOLERANCE);
    }
    return tgt;
  }

  static public org.hl7.fhir.model.core.CodeableConcept convertAllergyIntoleranceCategory(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.AllergyIntolerance.AllergyIntoleranceCategory> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
    CodeableConcept tgt = new CodeableConcept();
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.AllergyIntolerance.AllergyIntoleranceCategory> convertAllergyIntoleranceCategory(org.hl7.fhir.model.core.CodeableConcept src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.AllergyIntolerance.AllergyIntoleranceCategory> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.AllergyIntolerance.AllergyIntoleranceCategoryEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.hasCoding("http://hl7.org/fhir/ValueSet/allergy-intolerance-category", "food")) {
        tgt.setValue(org.hl7.fhir.r4b.model.AllergyIntolerance.AllergyIntoleranceCategory.FOOD);
      } else if (src.hasCoding("http://hl7.org/fhir/ValueSet/allergy-intolerance-category", "medication")) {
        tgt.setValue(org.hl7.fhir.r4b.model.AllergyIntolerance.AllergyIntoleranceCategory.MEDICATION);
      } else if (src.hasCoding("http://hl7.org/fhir/ValueSet/allergy-intolerance-category", "environment")) {
        tgt.setValue(org.hl7.fhir.r4b.model.AllergyIntolerance.AllergyIntoleranceCategory.ENVIRONMENT);
      } else if (src.hasCoding("http://hl7.org/fhir/ValueSet/allergy-intolerance-category", "biologic")) {
        tgt.setValue(org.hl7.fhir.r4b.model.AllergyIntolerance.AllergyIntoleranceCategory.BIOLOGIC);
      }
      return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.AllergyIntolerance.AllergyIntoleranceCriticality> convertAllergyIntoleranceCriticality(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.AllergyIntolerance.AllergyIntoleranceCriticality> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<AllergyIntolerance.AllergyIntoleranceCriticality> tgt = new Enumeration<>(new AllergyIntolerance.AllergyIntoleranceCriticalityEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.AllergyIntolerance.AllergyIntoleranceCriticality> convertAllergyIntoleranceCriticality(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.AllergyIntolerance.AllergyIntoleranceCriticality> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.AllergyIntolerance.AllergyIntoleranceCriticality> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.AllergyIntolerance.AllergyIntoleranceCriticalityEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case LOW:
                  tgt.setValue(org.hl7.fhir.r4b.model.AllergyIntolerance.AllergyIntoleranceCriticality.LOW);
                  break;
              case HIGH:
                  tgt.setValue(org.hl7.fhir.r4b.model.AllergyIntolerance.AllergyIntoleranceCriticality.HIGH);
                  break;
              case UNABLETOASSESS:
                  tgt.setValue(org.hl7.fhir.r4b.model.AllergyIntolerance.AllergyIntoleranceCriticality.UNABLETOASSESS);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4b.model.AllergyIntolerance.AllergyIntoleranceCriticality.NULL);
                  break;
          }
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.AllergyIntolerance.AllergyIntoleranceReactionComponent convertAllergyIntoleranceReactionComponent(org.hl7.fhir.r4b.model.AllergyIntolerance.AllergyIntoleranceReactionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.AllergyIntolerance.AllergyIntoleranceReactionComponent tgt = new org.hl7.fhir.model.core.AllergyIntolerance.AllergyIntoleranceReactionComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasSubstance())
      tgt.setSubstance(CodeableConcept43_N.convertCodeableConcept(src.getSubstance()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getManifestation())
      tgt.addManifestation(new CodeableReference(CodeableConcept43_N.convertCodeableConcept(t)));
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_N.convertString(src.getDescriptionElement()));
    if (src.hasOnset())
      tgt.setOnsetElement(DateTime43_N.convertDateTime(src.getOnsetElement()));
    if (src.hasSeverity())
      tgt.setSeverityElement(convertAllergyIntoleranceSeverity(src.getSeverityElement()));
    if (src.hasExposureRoute())
      tgt.setExposureRoute(CodeableConcept43_N.convertCodeableConcept(src.getExposureRoute()));
    for (org.hl7.fhir.r4b.model.Annotation t : src.getNote()) tgt.addNote(Annotation43_N.convertAnnotation(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.AllergyIntolerance.AllergyIntoleranceReactionComponent convertAllergyIntoleranceReactionComponent(org.hl7.fhir.model.core.AllergyIntolerance.AllergyIntoleranceReactionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.AllergyIntolerance.AllergyIntoleranceReactionComponent tgt = new org.hl7.fhir.r4b.model.AllergyIntolerance.AllergyIntoleranceReactionComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasSubstance())
      tgt.setSubstance(CodeableConcept43_N.convertCodeableConcept(src.getSubstance()));
    for (CodeableReference t : src.getManifestationList())
      if (t.hasConcept()) tgt.addManifestation(CodeableConcept43_N.convertCodeableConcept(t.getConcept()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_N.convertString(src.getDescriptionElement()));
    if (src.hasOnset())
      tgt.setOnsetElement(DateTime43_N.convertDateTime(src.getOnsetElement()));
    if (src.hasSeverity())
      tgt.setSeverityElement(convertAllergyIntoleranceSeverity(src.getSeverityElement()));
    if (src.hasExposureRoute())
      tgt.setExposureRoute(CodeableConcept43_N.convertCodeableConcept(src.getExposureRoute()));
    for (org.hl7.fhir.model.core.Annotation t : src.getNoteList()) tgt.addNote(Annotation43_N.convertAnnotation(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.AllergyIntolerance.AllergyIntoleranceSeverity> convertAllergyIntoleranceSeverity(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.AllergyIntolerance.AllergyIntoleranceSeverity> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<AllergyIntolerance.AllergyIntoleranceSeverity> tgt = new Enumeration<>(new AllergyIntolerance.AllergyIntoleranceSeverityEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.AllergyIntolerance.AllergyIntoleranceSeverity> convertAllergyIntoleranceSeverity(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.AllergyIntolerance.AllergyIntoleranceSeverity> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.AllergyIntolerance.AllergyIntoleranceSeverity> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.AllergyIntolerance.AllergyIntoleranceSeverityEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case MILD:
                  tgt.setValue(org.hl7.fhir.r4b.model.AllergyIntolerance.AllergyIntoleranceSeverity.MILD);
                  break;
              case MODERATE:
                  tgt.setValue(org.hl7.fhir.r4b.model.AllergyIntolerance.AllergyIntoleranceSeverity.MODERATE);
                  break;
              case SEVERE:
                  tgt.setValue(org.hl7.fhir.r4b.model.AllergyIntolerance.AllergyIntoleranceSeverity.SEVERE);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4b.model.AllergyIntolerance.AllergyIntoleranceSeverity.NULL);
                  break;
          }
      }
      return tgt;
  }
}