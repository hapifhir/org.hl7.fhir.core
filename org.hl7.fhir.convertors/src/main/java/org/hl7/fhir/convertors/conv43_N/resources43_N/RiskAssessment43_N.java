package org.hl7.fhir.convertors.conv43_N.resources43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Annotation43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.CodeableConcept43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Identifier43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Decimal43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.String43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.special43_N.Reference43_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4b.model.RiskAssessment;
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

public class RiskAssessment43_N {

  public static org.hl7.fhir.model.core.RiskAssessment convertRiskAssessment(org.hl7.fhir.r4b.model.RiskAssessment src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.RiskAssessment tgt = new org.hl7.fhir.model.core.RiskAssessment();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    if (src.hasBasedOn())
      tgt.setBasedOn(Reference43_N.convertReference(src.getBasedOn()));
    if (src.hasParent())
      tgt.setParent(Reference43_N.convertReference(src.getParent()));
    if (src.hasStatus())
      tgt.setStatusElement(convertRiskAssessmentStatus(src.getStatusElement()));
    if (src.hasMethod())
      tgt.setMethod(CodeableConcept43_N.convertCodeableConcept(src.getMethod()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_N.convertCodeableConcept(src.getCode()));
    if (src.hasSubject())
      tgt.setSubject(Reference43_N.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference43_N.convertReference(src.getEncounter()));
    if (src.hasOccurrence())
      tgt.setOccurrence(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getOccurrence()));
    if (src.hasCondition())
      tgt.setCondition(Reference43_N.convertReference(src.getCondition()));
    if (src.hasPerformer())
      tgt.setPerformer(Reference43_N.convertReference(src.getPerformer()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getReasonCode())
      tgt.addReason(CodeableConcept43_N.convertCodeableConceptToCodeableReference(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getReasonReference())
      tgt.addReason(Reference43_N.convertReferenceToCodeableReference(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getBasis()) tgt.addBasis(Reference43_N.convertReference(t));
    for (org.hl7.fhir.r4b.model.RiskAssessment.RiskAssessmentPredictionComponent t : src.getPrediction())
      tgt.addPrediction(convertRiskAssessmentPredictionComponent(t));
    if (src.hasMitigation())
      tgt.setMitigationElement(String43_N.convertString(src.getMitigationElement()));
    for (org.hl7.fhir.r4b.model.Annotation t : src.getNote()) tgt.addNote(Annotation43_N.convertAnnotation(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.RiskAssessment convertRiskAssessment(org.hl7.fhir.model.core.RiskAssessment src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.RiskAssessment tgt = new org.hl7.fhir.r4b.model.RiskAssessment();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    if (src.hasBasedOn())
      tgt.setBasedOn(Reference43_N.convertReference(src.getBasedOn()));
    if (src.hasParent())
      tgt.setParent(Reference43_N.convertReference(src.getParent()));
    if (src.hasStatus())
      tgt.setStatusElement(convertRiskAssessmentStatus(src.getStatusElement()));
    if (src.hasMethod())
      tgt.setMethod(CodeableConcept43_N.convertCodeableConcept(src.getMethod()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_N.convertCodeableConcept(src.getCode()));
    if (src.hasSubject())
      tgt.setSubject(Reference43_N.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference43_N.convertReference(src.getEncounter()));
    if (src.hasOccurrence())
      tgt.setOccurrence(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getOccurrence()));
    if (src.hasCondition())
      tgt.setCondition(Reference43_N.convertReference(src.getCondition()));
    if (src.hasPerformer())
      tgt.setPerformer(Reference43_N.convertReference(src.getPerformer()));
    for (CodeableReference t : src.getReasonList())
      if (t.hasConcept())
        tgt.addReasonCode(CodeableConcept43_N.convertCodeableConcept(t.getConcept()));
    for (CodeableReference t : src.getReasonList())
      if (t.hasReference())
        tgt.addReasonReference(Reference43_N.convertReference(t.getReference()));
    for (org.hl7.fhir.model.core.Reference t : src.getBasisList()) tgt.addBasis(Reference43_N.convertReference(t));
    for (org.hl7.fhir.model.core.RiskAssessment.RiskAssessmentPredictionComponent t : src.getPredictionList())
      tgt.addPrediction(convertRiskAssessmentPredictionComponent(t));
    if (src.hasMitigation())
      tgt.setMitigationElement(String43_N.convertString(src.getMitigationElement()));
    for (org.hl7.fhir.model.core.Annotation t : src.getNoteList()) tgt.addNote(Annotation43_N.convertAnnotation(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ObservationStatus> convertRiskAssessmentStatus(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.ObservationStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Enumerations.ObservationStatus> tgt = new Enumeration<>(new Enumerations.ObservationStatusEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.ObservationStatus> convertRiskAssessmentStatus(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ObservationStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.ObservationStatus> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.ObservationStatusEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
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
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.RiskAssessment.RiskAssessmentPredictionComponent convertRiskAssessmentPredictionComponent(org.hl7.fhir.r4b.model.RiskAssessment.RiskAssessmentPredictionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.RiskAssessment.RiskAssessmentPredictionComponent tgt = new org.hl7.fhir.model.core.RiskAssessment.RiskAssessmentPredictionComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasOutcome())
      tgt.setOutcome(CodeableConcept43_N.convertCodeableConcept(src.getOutcome()));
    if (src.hasProbability())
      tgt.setProbability(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getProbability()));
    if (src.hasQualitativeRisk())
      tgt.setQualitativeRisk(CodeableConcept43_N.convertCodeableConcept(src.getQualitativeRisk()));
    if (src.hasRelativeRisk())
      tgt.setRelativeRiskElement(Decimal43_N.convertDecimal(src.getRelativeRiskElement()));
    if (src.hasWhen())
      tgt.setWhen(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getWhen()));
    if (src.hasRationale())
      tgt.setRationaleElement(String43_N.convertString(src.getRationaleElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.RiskAssessment.RiskAssessmentPredictionComponent convertRiskAssessmentPredictionComponent(org.hl7.fhir.model.core.RiskAssessment.RiskAssessmentPredictionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.RiskAssessment.RiskAssessmentPredictionComponent tgt = new org.hl7.fhir.r4b.model.RiskAssessment.RiskAssessmentPredictionComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasOutcome())
      tgt.setOutcome(CodeableConcept43_N.convertCodeableConcept(src.getOutcome()));
    if (src.hasProbability())
      tgt.setProbability(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getProbability()));
    if (src.hasQualitativeRisk())
      tgt.setQualitativeRisk(CodeableConcept43_N.convertCodeableConcept(src.getQualitativeRisk()));
    if (src.hasRelativeRisk())
      tgt.setRelativeRiskElement(Decimal43_N.convertDecimal(src.getRelativeRiskElement()));
    if (src.hasWhen())
      tgt.setWhen(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getWhen()));
    if (src.hasRationale())
      tgt.setRationaleElement(String43_N.convertString(src.getRationaleElement()));
    return tgt;
  }
}