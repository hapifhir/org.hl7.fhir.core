package org.hl7.fhir.convertors.conv40_50.resources40_50;

import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Annotation40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.CodeableConcept40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Identifier40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Decimal40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.String40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.special40_50.Reference40_50;
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
public class RiskAssessment40_50 {

  public static org.hl7.fhir.r5.model.RiskAssessment convertRiskAssessment(org.hl7.fhir.r4.model.RiskAssessment src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.RiskAssessment tgt = new org.hl7.fhir.r5.model.RiskAssessment();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_50.convertIdentifier(t));
    if (src.hasBasedOn())
      tgt.setBasedOn(Reference40_50.convertReference(src.getBasedOn()));
    if (src.hasParent())
      tgt.setParent(Reference40_50.convertReference(src.getParent()));
    if (src.hasStatus())
      tgt.setStatusElement(convertRiskAssessmentStatus(src.getStatusElement()));
    if (src.hasMethod())
      tgt.setMethod(CodeableConcept40_50.convertCodeableConcept(src.getMethod()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_50.convertCodeableConcept(src.getCode()));
    if (src.hasSubject())
      tgt.setSubject(Reference40_50.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference40_50.convertReference(src.getEncounter()));
    if (src.hasOccurrence())
      tgt.setOccurrence(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getOccurrence()));
    if (src.hasCondition())
      tgt.setCondition(Reference40_50.convertReference(src.getCondition()));
    if (src.hasPerformer())
      tgt.setPerformer(Reference40_50.convertReference(src.getPerformer()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReasonCode())
      tgt.addReason(CodeableConcept40_50.convertCodeableConceptToCodeableReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getReasonReference())
      tgt.addReason(Reference40_50.convertReferenceToCodeableReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getBasis()) tgt.addBasis(Reference40_50.convertReference(t));
    for (org.hl7.fhir.r4.model.RiskAssessment.RiskAssessmentPredictionComponent t : src.getPrediction())
      tgt.addPrediction(convertRiskAssessmentPredictionComponent(t));
    if (src.hasMitigation())
      tgt.setMitigationElement(String40_50.convertString(src.getMitigationElement()));
    for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.addNote(Annotation40_50.convertAnnotation(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.RiskAssessment convertRiskAssessment(org.hl7.fhir.r5.model.RiskAssessment src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.RiskAssessment tgt = new org.hl7.fhir.r4.model.RiskAssessment();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_50.convertIdentifier(t));
    if (src.hasBasedOn())
      tgt.setBasedOn(Reference40_50.convertReference(src.getBasedOn()));
    if (src.hasParent())
      tgt.setParent(Reference40_50.convertReference(src.getParent()));
    if (src.hasStatus())
      tgt.setStatusElement(convertRiskAssessmentStatus(src.getStatusElement()));
    if (src.hasMethod())
      tgt.setMethod(CodeableConcept40_50.convertCodeableConcept(src.getMethod()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_50.convertCodeableConcept(src.getCode()));
    if (src.hasSubject())
      tgt.setSubject(Reference40_50.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference40_50.convertReference(src.getEncounter()));
    if (src.hasOccurrence())
      tgt.setOccurrence(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getOccurrence()));
    if (src.hasCondition())
      tgt.setCondition(Reference40_50.convertReference(src.getCondition()));
    if (src.hasPerformer())
      tgt.setPerformer(Reference40_50.convertReference(src.getPerformer()));
    for (CodeableReference t : src.getReason())
      if (t.hasConcept())
        tgt.addReasonCode(CodeableConcept40_50.convertCodeableConcept(t.getConcept()));
    for (CodeableReference t : src.getReason())
      if (t.hasReference())
        tgt.addReasonReference(Reference40_50.convertReference(t.getReference()));
    for (org.hl7.fhir.r5.model.Reference t : src.getBasis()) tgt.addBasis(Reference40_50.convertReference(t));
    for (org.hl7.fhir.r5.model.RiskAssessment.RiskAssessmentPredictionComponent t : src.getPrediction())
      tgt.addPrediction(convertRiskAssessmentPredictionComponent(t));
    if (src.hasMitigation())
      tgt.setMitigationElement(String40_50.convertString(src.getMitigationElement()));
    for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.addNote(Annotation40_50.convertAnnotation(t));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ObservationStatus> convertRiskAssessmentStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.RiskAssessment.RiskAssessmentStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ObservationStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.ObservationStatusEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.RiskAssessment.RiskAssessmentStatus> convertRiskAssessmentStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ObservationStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.RiskAssessment.RiskAssessmentStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.RiskAssessment.RiskAssessmentStatusEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case REGISTERED:
        tgt.setValue(org.hl7.fhir.r4.model.RiskAssessment.RiskAssessmentStatus.REGISTERED);
        break;
      case PRELIMINARY:
        tgt.setValue(org.hl7.fhir.r4.model.RiskAssessment.RiskAssessmentStatus.PRELIMINARY);
        break;
      case FINAL:
        tgt.setValue(org.hl7.fhir.r4.model.RiskAssessment.RiskAssessmentStatus.FINAL);
        break;
      case AMENDED:
        tgt.setValue(org.hl7.fhir.r4.model.RiskAssessment.RiskAssessmentStatus.AMENDED);
        break;
      case CORRECTED:
        tgt.setValue(org.hl7.fhir.r4.model.RiskAssessment.RiskAssessmentStatus.CORRECTED);
        break;
      case CANCELLED:
        tgt.setValue(org.hl7.fhir.r4.model.RiskAssessment.RiskAssessmentStatus.CANCELLED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r4.model.RiskAssessment.RiskAssessmentStatus.ENTEREDINERROR);
        break;
      case UNKNOWN:
        tgt.setValue(org.hl7.fhir.r4.model.RiskAssessment.RiskAssessmentStatus.UNKNOWN);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.RiskAssessment.RiskAssessmentStatus.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.RiskAssessment.RiskAssessmentPredictionComponent convertRiskAssessmentPredictionComponent(org.hl7.fhir.r4.model.RiskAssessment.RiskAssessmentPredictionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.RiskAssessment.RiskAssessmentPredictionComponent tgt = new org.hl7.fhir.r5.model.RiskAssessment.RiskAssessmentPredictionComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasOutcome())
      tgt.setOutcome(CodeableConcept40_50.convertCodeableConcept(src.getOutcome()));
    if (src.hasProbability())
      tgt.setProbability(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getProbability()));
    if (src.hasQualitativeRisk())
      tgt.setQualitativeRisk(CodeableConcept40_50.convertCodeableConcept(src.getQualitativeRisk()));
    if (src.hasRelativeRisk())
      tgt.setRelativeRiskElement(Decimal40_50.convertDecimal(src.getRelativeRiskElement()));
    if (src.hasWhen())
      tgt.setWhen(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getWhen()));
    if (src.hasRationale())
      tgt.setRationaleElement(String40_50.convertString(src.getRationaleElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.RiskAssessment.RiskAssessmentPredictionComponent convertRiskAssessmentPredictionComponent(org.hl7.fhir.r5.model.RiskAssessment.RiskAssessmentPredictionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.RiskAssessment.RiskAssessmentPredictionComponent tgt = new org.hl7.fhir.r4.model.RiskAssessment.RiskAssessmentPredictionComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasOutcome())
      tgt.setOutcome(CodeableConcept40_50.convertCodeableConcept(src.getOutcome()));
    if (src.hasProbability())
      tgt.setProbability(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getProbability()));
    if (src.hasQualitativeRisk())
      tgt.setQualitativeRisk(CodeableConcept40_50.convertCodeableConcept(src.getQualitativeRisk()));
    if (src.hasRelativeRisk())
      tgt.setRelativeRiskElement(Decimal40_50.convertDecimal(src.getRelativeRiskElement()));
    if (src.hasWhen())
      tgt.setWhen(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getWhen()));
    if (src.hasRationale())
      tgt.setRationaleElement(String40_50.convertString(src.getRationaleElement()));
    return tgt;
  }
}