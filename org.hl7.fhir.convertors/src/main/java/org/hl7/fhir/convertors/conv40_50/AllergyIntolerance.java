package org.hl7.fhir.convertors.conv40_50;

import org.hl7.fhir.exceptions.FHIRException;

import org.hl7.fhir.convertors.VersionConvertor_40_50;


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


public class AllergyIntolerance extends VersionConvertor_40_50 {

  public static org.hl7.fhir.r5.model.AllergyIntolerance convertAllergyIntolerance(org.hl7.fhir.r4.model.AllergyIntolerance src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.AllergyIntolerance tgt = new org.hl7.fhir.r5.model.AllergyIntolerance();
    copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    if (src.hasClinicalStatus())
      tgt.setClinicalStatus(convertCodeableConcept(src.getClinicalStatus()));
    if (src.hasVerificationStatus())
      tgt.setVerificationStatus(convertCodeableConcept(src.getVerificationStatus()));
    if (src.hasType())
      tgt.setType(convertAllergyIntoleranceType(src.getType()));
    for (org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceCategory> t : src.getCategory())
      tgt.addCategory(convertAllergyIntoleranceCategory(t.getValue()));
    if (src.hasCriticality())
      tgt.setCriticality(convertAllergyIntoleranceCriticality(src.getCriticality()));
    if (src.hasCode())
      tgt.setCode(convertCodeableConcept(src.getCode()));
    if (src.hasPatient())
      tgt.setPatient(convertReference(src.getPatient()));
    if (src.hasEncounter())
      tgt.setEncounter(convertReference(src.getEncounter()));
    if (src.hasOnset())
      tgt.setOnset(convertType(src.getOnset()));
    if (src.hasRecordedDate())
      tgt.setRecordedDateElement(convertDateTime(src.getRecordedDateElement()));
    if (src.hasRecorder())
      tgt.setRecorder(convertReference(src.getRecorder()));
    if (src.hasAsserter())
      tgt.setAsserter(convertReference(src.getAsserter()));
    if (src.hasLastOccurrence())
      tgt.setLastOccurrenceElement(convertDateTime(src.getLastOccurrenceElement()));
    for (org.hl7.fhir.r4.model.Annotation t : src.getNote())
      tgt.addNote(convertAnnotation(t));
    for (org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceReactionComponent t : src.getReaction())
      tgt.addReaction(convertAllergyIntoleranceReactionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.AllergyIntolerance convertAllergyIntolerance(org.hl7.fhir.r5.model.AllergyIntolerance src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.AllergyIntolerance tgt = new org.hl7.fhir.r4.model.AllergyIntolerance();
    copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    if (src.hasClinicalStatus())
      tgt.setClinicalStatus(convertCodeableConcept(src.getClinicalStatus()));
    if (src.hasVerificationStatus())
      tgt.setVerificationStatus(convertCodeableConcept(src.getVerificationStatus()));
    if (src.hasType())
      tgt.setType(convertAllergyIntoleranceType(src.getType()));
    for (org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceCategory> t : src.getCategory())
      tgt.addCategory(convertAllergyIntoleranceCategory(t.getValue()));
    if (src.hasCriticality())
      tgt.setCriticality(convertAllergyIntoleranceCriticality(src.getCriticality()));
    if (src.hasCode())
      tgt.setCode(convertCodeableConcept(src.getCode()));
    if (src.hasPatient())
      tgt.setPatient(convertReference(src.getPatient()));
    if (src.hasEncounter())
      tgt.setEncounter(convertReference(src.getEncounter()));
    if (src.hasOnset())
      tgt.setOnset(convertType(src.getOnset()));
    if (src.hasRecordedDate())
      tgt.setRecordedDateElement(convertDateTime(src.getRecordedDateElement()));
    if (src.hasRecorder())
      tgt.setRecorder(convertReference(src.getRecorder()));
    if (src.hasAsserter())
      tgt.setAsserter(convertReference(src.getAsserter()));
    if (src.hasLastOccurrence())
      tgt.setLastOccurrenceElement(convertDateTime(src.getLastOccurrenceElement()));
    for (org.hl7.fhir.r5.model.Annotation t : src.getNote())
      tgt.addNote(convertAnnotation(t));
    for (org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceReactionComponent t : src.getReaction())
      tgt.addReaction(convertAllergyIntoleranceReactionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceType convertAllergyIntoleranceType(org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceType src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case ALLERGY: return org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceType.ALLERGY;
    case INTOLERANCE: return org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceType.INTOLERANCE;
    default: return org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceType.NULL;
  }
}

  public static org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceType convertAllergyIntoleranceType(org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceType src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case ALLERGY: return org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceType.ALLERGY;
    case INTOLERANCE: return org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceType.INTOLERANCE;
    default: return org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceType.NULL;
  }
}

  public static org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceCategory convertAllergyIntoleranceCategory(org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceCategory src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case FOOD: return org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceCategory.FOOD;
    case MEDICATION: return org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceCategory.MEDICATION;
    case ENVIRONMENT: return org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceCategory.ENVIRONMENT;
    case BIOLOGIC: return org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceCategory.BIOLOGIC;
    default: return org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceCategory.NULL;
  }
}

  public static org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceCategory convertAllergyIntoleranceCategory(org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceCategory src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case FOOD: return org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceCategory.FOOD;
    case MEDICATION: return org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceCategory.MEDICATION;
    case ENVIRONMENT: return org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceCategory.ENVIRONMENT;
    case BIOLOGIC: return org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceCategory.BIOLOGIC;
    default: return org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceCategory.NULL;
  }
}

  public static org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceCriticality convertAllergyIntoleranceCriticality(org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceCriticality src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case LOW: return org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceCriticality.LOW;
    case HIGH: return org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceCriticality.HIGH;
    case UNABLETOASSESS: return org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceCriticality.UNABLETOASSESS;
    default: return org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceCriticality.NULL;
  }
}

  public static org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceCriticality convertAllergyIntoleranceCriticality(org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceCriticality src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case LOW: return org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceCriticality.LOW;
    case HIGH: return org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceCriticality.HIGH;
    case UNABLETOASSESS: return org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceCriticality.UNABLETOASSESS;
    default: return org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceCriticality.NULL;
  }
}

  public static org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceReactionComponent convertAllergyIntoleranceReactionComponent(org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceReactionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceReactionComponent tgt = new org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceReactionComponent();
    copyElement(src, tgt);
    if (src.hasSubstance())
      tgt.setSubstance(convertCodeableConcept(src.getSubstance()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getManifestation())
      tgt.addManifestation(convertCodeableConcept(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
    if (src.hasOnset())
      tgt.setOnsetElement(convertDateTime(src.getOnsetElement()));
    if (src.hasSeverity())
      tgt.setSeverity(convertAllergyIntoleranceSeverity(src.getSeverity()));
    if (src.hasExposureRoute())
      tgt.setExposureRoute(convertCodeableConcept(src.getExposureRoute()));
    for (org.hl7.fhir.r4.model.Annotation t : src.getNote())
      tgt.addNote(convertAnnotation(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceReactionComponent convertAllergyIntoleranceReactionComponent(org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceReactionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceReactionComponent tgt = new org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceReactionComponent();
    copyElement(src, tgt);
    if (src.hasSubstance())
      tgt.setSubstance(convertCodeableConcept(src.getSubstance()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getManifestation())
      tgt.addManifestation(convertCodeableConcept(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
    if (src.hasOnset())
      tgt.setOnsetElement(convertDateTime(src.getOnsetElement()));
    if (src.hasSeverity())
      tgt.setSeverity(convertAllergyIntoleranceSeverity(src.getSeverity()));
    if (src.hasExposureRoute())
      tgt.setExposureRoute(convertCodeableConcept(src.getExposureRoute()));
    for (org.hl7.fhir.r5.model.Annotation t : src.getNote())
      tgt.addNote(convertAnnotation(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceSeverity convertAllergyIntoleranceSeverity(org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceSeverity src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case MILD: return org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceSeverity.MILD;
    case MODERATE: return org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceSeverity.MODERATE;
    case SEVERE: return org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceSeverity.SEVERE;
    default: return org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceSeverity.NULL;
  }
}

  public static org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceSeverity convertAllergyIntoleranceSeverity(org.hl7.fhir.r5.model.AllergyIntolerance.AllergyIntoleranceSeverity src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case MILD: return org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceSeverity.MILD;
    case MODERATE: return org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceSeverity.MODERATE;
    case SEVERE: return org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceSeverity.SEVERE;
    default: return org.hl7.fhir.r4.model.AllergyIntolerance.AllergyIntoleranceSeverity.NULL;
  }
}


}
