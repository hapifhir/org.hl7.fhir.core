package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.CrossVersionElements40_N;
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

  public static final String TYPE_SYSTEM = "http://hl7.org/fhir/allergy-intolerance-type";
  public static final String CATEGORY_SYSTEM = "http://hl7.org/fhir/allergy-intolerance-category";
  // R6 type and category concepts that the R4 codes can't hold
  public static final String TYPE_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-AllergyIntolerance.type";
  public static final String CATEGORY_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-AllergyIntolerance.category";

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
    if (src.hasType()) {
      CodeableConcept kept = CodeableConcept40_N.keptCodeableConcept(src.getTypeElement(), TYPE_EXTENSION_URL);
      tgt.setType(kept != null ? kept : convertAllergyIntoleranceType(src.getTypeElement()));
    }
    for (org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceCategory> t : src.getCategory()) {
      CodeableConcept kept = CodeableConcept40_N.keptCodeableConcept(t, CATEGORY_EXTENSION_URL);
      tgt.addCategory(kept != null ? kept : convertAllergyIntoleranceCategory(t));
    }
    if (src.hasCriticality())
      tgt.setCriticalityElement(CrossVersionElements40_N.toR6Code(src.getCriticalityElement(), convertAllergyIntoleranceCriticality(src.getCriticalityElement()), src.fhirType(), "criticality"));
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_N.convertCodeableConcept(src.getCode()));
    if (src.hasPatient())
      tgt.setPatient(Reference40_N.convertReference(src.getPatient()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference40_N.convertReference(src.getEncounter()));
    // the types R4 and R6 allow differ: a value of a type the other version doesn't allow is an extension
    CrossVersionElements40_N.choiceToR6(src, src.getExtension(), src.fhirType(), "onset", tgt, tgt.getExtension());
    if (src.hasRecordedDate())
      tgt.setRecordedDateElement(DateTime40_N.convertDateTime(src.getRecordedDateElement()));
    if (src.hasRecorder())
      tgt.setRecorder(Reference40_N.convertReference(src.getRecorder()));
    if (src.hasAsserter())
      tgt.setAsserter(Reference40_N.convertReference(src.getAsserter()));
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
    if (src.hasType()) {
      tgt.setTypeElement(convertAllergyIntoleranceType(src.getType()));
      CodeableConcept40_N.keepCodeableConcept(src.getType(), tgt.getTypeElement(), convertAllergyIntoleranceType(tgt.getTypeElement()), TYPE_EXTENSION_URL);
    }
    for (CodeableConcept t : src.getCategoryList()) {
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceCategory> c = convertAllergyIntoleranceCategory(t);
      CodeableConcept40_N.keepCodeableConcept(t, c, convertAllergyIntoleranceCategory(c), CATEGORY_EXTENSION_URL);
      tgt.getCategory().add(c);
    }
    if (src.hasCriticality())
      tgt.setCriticalityElement(CrossVersionElements40_N.toR4Code(src.getCriticalityElement(), convertAllergyIntoleranceCriticality(src.getCriticalityElement()), src.fhirType(), "criticality"));
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_N.convertCodeableConcept(src.getCode()));
    if (src.hasPatient())
      tgt.setPatient(Reference40_N.convertReference(src.getPatient()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference40_N.convertReference(src.getEncounter()));
    CrossVersionElements40_N.choiceToR4(src, src.getExtension(), src.fhirType(), "onset", tgt, tgt.getExtension());
    if (src.hasRecordedDate())
      tgt.setRecordedDateElement(DateTime40_N.convertDateTime(src.getRecordedDateElement()));
    if (src.hasRecorder())
      tgt.setRecorder(Reference40_N.convertReference(src.getRecorder()));
    if (src.hasAsserter())
      tgt.setAsserter(Reference40_N.convertReference(src.getAsserter()));
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
                  tgt.addCoding(TYPE_SYSTEM, "allergy", "Allergy");
                  break;
              case INTOLERANCE:
                  tgt.addCoding(TYPE_SYSTEM, "intolerance", "Intolerance");
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
    if (src.hasCoding(TYPE_SYSTEM, "allergy")) {
      tgt.setValue(org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceType.ALLERGY);
    } else if (src.hasCoding(TYPE_SYSTEM, "intolerance")) {
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
                  tgt.addCoding(CATEGORY_SYSTEM, "food", "Food");
                  break;
              case MEDICATION:
                tgt.addCoding(CATEGORY_SYSTEM, "medication", "Medication");
                  break;
              case ENVIRONMENT:
                tgt.addCoding(CATEGORY_SYSTEM, "environment", "Environment");
                  break;
              case BIOLOGIC:
                tgt.addCoding(CATEGORY_SYSTEM, "biologic", "Biologic");
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
      if (src.hasCoding(CATEGORY_SYSTEM, "food")) {
        tgt.setValue(org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceCategory.FOOD);
      } else if (src.hasCoding(CATEGORY_SYSTEM, "medication")) {
        tgt.setValue(org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceCategory.MEDICATION);
      } else if (src.hasCoding(CATEGORY_SYSTEM, "environment")) {
        tgt.setValue(org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceCategory.ENVIRONMENT);
      } else if (src.hasCoding(CATEGORY_SYSTEM, "biologic")) {
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
      tgt.addManifestation(CodeableConcept40_N.convertCodeableConceptToCodeableReference(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_N.convertString(src.getDescriptionElement()));
    if (src.hasOnset())
      tgt.setOnsetElement(DateTime40_N.convertDateTime(src.getOnsetElement()));
    if (src.hasSeverity())
      tgt.setSeverityElement(CrossVersionElements40_N.toR6Code(src.getSeverityElement(), convertAllergyIntoleranceSeverity(src.getSeverityElement()), src.fhirType(), "severity"));
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
      tgt.addManifestation(CodeableConcept40_N.convertCodeableReferenceToCodeableConcept(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_N.convertString(src.getDescriptionElement()));
    if (src.hasOnset())
      tgt.setOnsetElement(DateTime40_N.convertDateTime(src.getOnsetElement()));
    if (src.hasSeverity())
      tgt.setSeverityElement(CrossVersionElements40_N.toR4Code(src.getSeverityElement(), convertAllergyIntoleranceSeverity(src.getSeverityElement()), src.fhirType(), "severity"));
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