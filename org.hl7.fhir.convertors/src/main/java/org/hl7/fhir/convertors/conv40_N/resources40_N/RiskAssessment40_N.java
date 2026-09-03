package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Annotation40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Identifier40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Decimal40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.String40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Reference40_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.RiskAssessment;
import org.hl7.fhir.model.core.CodeableReference;
import org.hl7.fhir.model.core.Enumeration;
import org.hl7.fhir.model.core.Enumerations;

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

public class RiskAssessment40_N {

  public static org.hl7.fhir.model.core.RiskAssessment convertRiskAssessment(org.hl7.fhir.r4.model.RiskAssessment src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.RiskAssessment tgt = new org.hl7.fhir.model.core.RiskAssessment();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    if (src.hasBasedOn())
      tgt.setBasedOn(Reference40_N.convertReference(src.getBasedOn()));
    if (src.hasParent())
      tgt.setParent(Reference40_N.convertReference(src.getParent()));
    if (src.hasStatus())
      tgt.setStatusElement(convertRiskAssessmentStatus(src.getStatusElement()));
    if (src.hasMethod())
      tgt.setMethod(CodeableConcept40_N.convertCodeableConcept(src.getMethod()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_N.convertCodeableConcept(src.getCode()));
    if (src.hasSubject())
      tgt.setSubject(Reference40_N.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference40_N.convertReference(src.getEncounter()));
    if (src.hasOccurrence())
      tgt.setOccurrence(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getOccurrence()));
    if (src.hasCondition())
      tgt.setCondition(Reference40_N.convertReference(src.getCondition()));
    if (src.hasPerformer())
      tgt.setPerformer(Reference40_N.convertReference(src.getPerformer()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReasonCode())
      tgt.addReason(CodeableConcept40_N.convertCodeableConceptToCodeableReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getReasonReference())
      tgt.addReason(Reference40_N.convertReferenceToCodeableReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getBasis()) tgt.addBasis(Reference40_N.convertReference(t));
    for (org.hl7.fhir.r4.model.RiskAssessment.RiskAssessmentPredictionComponent t : src.getPrediction())
      tgt.addPrediction(convertRiskAssessmentPredictionComponent(t));
    if (src.hasMitigation())
      tgt.setMitigationElement(String40_N.convertString(src.getMitigationElement()));
    for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.addNote(Annotation40_N.convertAnnotation(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.RiskAssessment convertRiskAssessment(org.hl7.fhir.model.core.RiskAssessment src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.RiskAssessment tgt = new org.hl7.fhir.r4.model.RiskAssessment();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    if (src.hasBasedOn())
      tgt.setBasedOn(Reference40_N.convertReference(src.getBasedOn()));
    if (src.hasParent())
      tgt.setParent(Reference40_N.convertReference(src.getParent()));
    if (src.hasStatus())
      tgt.setStatusElement(convertRiskAssessmentStatus(src.getStatusElement()));
    if (src.hasMethod())
      tgt.setMethod(CodeableConcept40_N.convertCodeableConcept(src.getMethod()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_N.convertCodeableConcept(src.getCode()));
    if (src.hasSubject())
      tgt.setSubject(Reference40_N.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference40_N.convertReference(src.getEncounter()));
    if (src.hasOccurrence())
      tgt.setOccurrence(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getOccurrence()));
    if (src.hasCondition())
      tgt.setCondition(Reference40_N.convertReference(src.getCondition()));
    if (src.hasPerformer())
      tgt.setPerformer(Reference40_N.convertReference(src.getPerformer()));
    for (CodeableReference t : src.getReasonList())
      if (t.hasConcept())
        tgt.addReasonCode(CodeableConcept40_N.convertCodeableConcept(t.getConcept()));
    for (CodeableReference t : src.getReasonList())
      if (t.hasReference())
        tgt.addReasonReference(Reference40_N.convertReference(t.getReference()));
    for (org.hl7.fhir.model.core.Reference t : src.getBasisList()) tgt.addBasis(Reference40_N.convertReference(t));
    for (org.hl7.fhir.model.core.RiskAssessment.RiskAssessmentPredictionComponent t : src.getPredictionList())
      tgt.addPrediction(convertRiskAssessmentPredictionComponent(t));
    if (src.hasMitigation())
      tgt.setMitigationElement(String40_N.convertString(src.getMitigationElement()));
    for (org.hl7.fhir.model.core.Annotation t : src.getNoteList()) tgt.addNote(Annotation40_N.convertAnnotation(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ObservationStatus> convertRiskAssessmentStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.RiskAssessment.RiskAssessmentStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Enumerations.ObservationStatus> tgt = new Enumeration<>(new Enumerations.ObservationStatusEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case REGISTERED:
                  tgt.setValue(Enumerations.ObservationStatus.REGISTERED);
                  break;
              case PRELIMINARY:
                  tgt.setValue(Enumerations.ObservationStatus.PRELIMINARY);
                  break;
              case FINAL:
                  tgt.setValue(Enumerations.ObservationStatus.FINAL);
                  break;
              case AMENDED:
                  tgt.setValue(Enumerations.ObservationStatus.AMENDED);
                  break;
              case CORRECTED:
                  tgt.setValue(Enumerations.ObservationStatus.CORRECTED);
                  break;
              case CANCELLED:
                  tgt.setValue(Enumerations.ObservationStatus.CANCELLED);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(Enumerations.ObservationStatus.ENTEREDINERROR);
                  break;
              case UNKNOWN:
                  tgt.setValue(Enumerations.ObservationStatus.UNKNOWN);
                  break;
              default:
                  tgt.setValue(Enumerations.ObservationStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.RiskAssessment.RiskAssessmentStatus> convertRiskAssessmentStatus(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ObservationStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<RiskAssessment.RiskAssessmentStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new RiskAssessment.RiskAssessmentStatusEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case REGISTERED:
                  tgt.setValue(RiskAssessment.RiskAssessmentStatus.REGISTERED);
                  break;
              case PRELIMINARY:
                  tgt.setValue(RiskAssessment.RiskAssessmentStatus.PRELIMINARY);
                  break;
              case FINAL:
                  tgt.setValue(RiskAssessment.RiskAssessmentStatus.FINAL);
                  break;
              case AMENDED:
                  tgt.setValue(RiskAssessment.RiskAssessmentStatus.AMENDED);
                  break;
              case CORRECTED:
                  tgt.setValue(RiskAssessment.RiskAssessmentStatus.CORRECTED);
                  break;
              case CANCELLED:
                  tgt.setValue(RiskAssessment.RiskAssessmentStatus.CANCELLED);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(RiskAssessment.RiskAssessmentStatus.ENTEREDINERROR);
                  break;
              case UNKNOWN:
                  tgt.setValue(RiskAssessment.RiskAssessmentStatus.UNKNOWN);
                  break;
              default:
                  tgt.setValue(RiskAssessment.RiskAssessmentStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.RiskAssessment.RiskAssessmentPredictionComponent convertRiskAssessmentPredictionComponent(org.hl7.fhir.r4.model.RiskAssessment.RiskAssessmentPredictionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.RiskAssessment.RiskAssessmentPredictionComponent tgt = new org.hl7.fhir.model.core.RiskAssessment.RiskAssessmentPredictionComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasOutcome())
      tgt.setOutcome(CodeableConcept40_N.convertCodeableConcept(src.getOutcome()));
    if (src.hasProbability())
      tgt.setProbability(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getProbability()));
    if (src.hasQualitativeRisk())
      tgt.setQualitativeRisk(CodeableConcept40_N.convertCodeableConcept(src.getQualitativeRisk()));
    if (src.hasRelativeRisk())
      tgt.setRelativeRiskElement(Decimal40_N.convertDecimal(src.getRelativeRiskElement()));
    if (src.hasWhen())
      tgt.setWhen(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getWhen()));
    if (src.hasRationale())
      tgt.setRationaleElement(String40_N.convertString(src.getRationaleElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.RiskAssessment.RiskAssessmentPredictionComponent convertRiskAssessmentPredictionComponent(org.hl7.fhir.model.core.RiskAssessment.RiskAssessmentPredictionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.RiskAssessment.RiskAssessmentPredictionComponent tgt = new org.hl7.fhir.r4.model.RiskAssessment.RiskAssessmentPredictionComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasOutcome())
      tgt.setOutcome(CodeableConcept40_N.convertCodeableConcept(src.getOutcome()));
    if (src.hasProbability())
      tgt.setProbability(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getProbability()));
    if (src.hasQualitativeRisk())
      tgt.setQualitativeRisk(CodeableConcept40_N.convertCodeableConcept(src.getQualitativeRisk()));
    if (src.hasRelativeRisk())
      tgt.setRelativeRiskElement(Decimal40_N.convertDecimal(src.getRelativeRiskElement()));
    if (src.hasWhen())
      tgt.setWhen(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getWhen()));
    if (src.hasRationale())
      tgt.setRationaleElement(String40_N.convertString(src.getRationaleElement()));
    return tgt;
  }
}