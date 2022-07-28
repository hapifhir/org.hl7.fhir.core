package org.hl7.fhir.convertors.conv43_50.resources43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Annotation43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.CodeableConcept43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Identifier43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Decimal43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.String43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.special43_50.Reference43_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CodeableReference;

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
public class RiskAssessment43_50 {

  public static org.hl7.fhir.r5.model.RiskAssessment convertRiskAssessment(org.hl7.fhir.r4b.model.RiskAssessment src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.RiskAssessment tgt = new org.hl7.fhir.r5.model.RiskAssessment();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    if (src.hasBasedOn())
      tgt.setBasedOn(Reference43_50.convertReference(src.getBasedOn()));
    if (src.hasParent())
      tgt.setParent(Reference43_50.convertReference(src.getParent()));
    if (src.hasStatus())
      tgt.setStatusElement(convertRiskAssessmentStatus(src.getStatusElement()));
    if (src.hasMethod())
      tgt.setMethod(CodeableConcept43_50.convertCodeableConcept(src.getMethod()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_50.convertCodeableConcept(src.getCode()));
    if (src.hasSubject())
      tgt.setSubject(Reference43_50.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference43_50.convertReference(src.getEncounter()));
    if (src.hasOccurrence())
      tgt.setOccurrence(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getOccurrence()));
    if (src.hasCondition())
      tgt.setCondition(Reference43_50.convertReference(src.getCondition()));
    if (src.hasPerformer())
      tgt.setPerformer(Reference43_50.convertReference(src.getPerformer()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getReasonCode())
      tgt.addReason(CodeableConcept43_50.convertCodeableConceptToCodeableReference(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getReasonReference())
      tgt.addReason(Reference43_50.convertReferenceToCodeableReference(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getBasis()) tgt.addBasis(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r4b.model.RiskAssessment.RiskAssessmentPredictionComponent t : src.getPrediction())
      tgt.addPrediction(convertRiskAssessmentPredictionComponent(t));
    if (src.hasMitigation())
      tgt.setMitigationElement(String43_50.convertString(src.getMitigationElement()));
    for (org.hl7.fhir.r4b.model.Annotation t : src.getNote()) tgt.addNote(Annotation43_50.convertAnnotation(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.RiskAssessment convertRiskAssessment(org.hl7.fhir.r5.model.RiskAssessment src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.RiskAssessment tgt = new org.hl7.fhir.r4b.model.RiskAssessment();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    if (src.hasBasedOn())
      tgt.setBasedOn(Reference43_50.convertReference(src.getBasedOn()));
    if (src.hasParent())
      tgt.setParent(Reference43_50.convertReference(src.getParent()));
    if (src.hasStatus())
      tgt.setStatusElement(convertRiskAssessmentStatus(src.getStatusElement()));
    if (src.hasMethod())
      tgt.setMethod(CodeableConcept43_50.convertCodeableConcept(src.getMethod()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_50.convertCodeableConcept(src.getCode()));
    if (src.hasSubject())
      tgt.setSubject(Reference43_50.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference43_50.convertReference(src.getEncounter()));
    if (src.hasOccurrence())
      tgt.setOccurrence(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getOccurrence()));
    if (src.hasCondition())
      tgt.setCondition(Reference43_50.convertReference(src.getCondition()));
    if (src.hasPerformer())
      tgt.setPerformer(Reference43_50.convertReference(src.getPerformer()));
    for (CodeableReference t : src.getReason())
      if (t.hasConcept())
        tgt.addReasonCode(CodeableConcept43_50.convertCodeableConcept(t.getConcept()));
    for (CodeableReference t : src.getReason())
      if (t.hasReference())
        tgt.addReasonReference(Reference43_50.convertReference(t.getReference()));
    for (org.hl7.fhir.r5.model.Reference t : src.getBasis()) tgt.addBasis(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r5.model.RiskAssessment.RiskAssessmentPredictionComponent t : src.getPrediction())
      tgt.addPrediction(convertRiskAssessmentPredictionComponent(t));
    if (src.hasMitigation())
      tgt.setMitigationElement(String43_50.convertString(src.getMitigationElement()));
    for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.addNote(Annotation43_50.convertAnnotation(t));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ObservationStatus> convertRiskAssessmentStatus(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.ObservationStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ObservationStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.ObservationStatusEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case REGISTERED:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ObservationStatus.REGISTERED);
        break;
      case PRELIMINARY:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ObservationStatus.PRELIMINARY);
        break;
      case FINAL:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ObservationStatus.FINAL);
        break;
      case AMENDED:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ObservationStatus.AMENDED);
        break;
      case CORRECTED:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ObservationStatus.CORRECTED);
        break;
      case CANCELLED:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ObservationStatus.CANCELLED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ObservationStatus.ENTEREDINERROR);
        break;
      case UNKNOWN:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ObservationStatus.UNKNOWN);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ObservationStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.ObservationStatus> convertRiskAssessmentStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ObservationStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.ObservationStatus> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.ObservationStatusEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case REGISTERED:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.ObservationStatus.REGISTERED);
        break;
      case PRELIMINARY:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.ObservationStatus.PRELIMINARY);
        break;
      case FINAL:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.ObservationStatus.FINAL);
        break;
      case AMENDED:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.ObservationStatus.AMENDED);
        break;
      case CORRECTED:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.ObservationStatus.CORRECTED);
        break;
      case CANCELLED:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.ObservationStatus.CANCELLED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.ObservationStatus.ENTEREDINERROR);
        break;
      case UNKNOWN:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.ObservationStatus.UNKNOWN);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.ObservationStatus.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.RiskAssessment.RiskAssessmentPredictionComponent convertRiskAssessmentPredictionComponent(org.hl7.fhir.r4b.model.RiskAssessment.RiskAssessmentPredictionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.RiskAssessment.RiskAssessmentPredictionComponent tgt = new org.hl7.fhir.r5.model.RiskAssessment.RiskAssessmentPredictionComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasOutcome())
      tgt.setOutcome(CodeableConcept43_50.convertCodeableConcept(src.getOutcome()));
    if (src.hasProbability())
      tgt.setProbability(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getProbability()));
    if (src.hasQualitativeRisk())
      tgt.setQualitativeRisk(CodeableConcept43_50.convertCodeableConcept(src.getQualitativeRisk()));
    if (src.hasRelativeRisk())
      tgt.setRelativeRiskElement(Decimal43_50.convertDecimal(src.getRelativeRiskElement()));
    if (src.hasWhen())
      tgt.setWhen(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getWhen()));
    if (src.hasRationale())
      tgt.setRationaleElement(String43_50.convertString(src.getRationaleElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.RiskAssessment.RiskAssessmentPredictionComponent convertRiskAssessmentPredictionComponent(org.hl7.fhir.r5.model.RiskAssessment.RiskAssessmentPredictionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.RiskAssessment.RiskAssessmentPredictionComponent tgt = new org.hl7.fhir.r4b.model.RiskAssessment.RiskAssessmentPredictionComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasOutcome())
      tgt.setOutcome(CodeableConcept43_50.convertCodeableConcept(src.getOutcome()));
    if (src.hasProbability())
      tgt.setProbability(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getProbability()));
    if (src.hasQualitativeRisk())
      tgt.setQualitativeRisk(CodeableConcept43_50.convertCodeableConcept(src.getQualitativeRisk()));
    if (src.hasRelativeRisk())
      tgt.setRelativeRiskElement(Decimal43_50.convertDecimal(src.getRelativeRiskElement()));
    if (src.hasWhen())
      tgt.setWhen(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getWhen()));
    if (src.hasRationale())
      tgt.setRationaleElement(String43_50.convertString(src.getRationaleElement()));
    return tgt;
  }
}