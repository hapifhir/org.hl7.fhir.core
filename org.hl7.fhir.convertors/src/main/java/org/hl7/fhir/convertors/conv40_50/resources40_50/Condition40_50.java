package org.hl7.fhir.convertors.conv40_50.resources40_50;

import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Annotation40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.CodeableConcept40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Identifier40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.DateTime40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.special40_50.Reference40_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CodeableConcept;
import org.hl7.fhir.r5.model.CodeableReference;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.Condition.ConditionParticipantComponent;

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
public class Condition40_50 {

  public static org.hl7.fhir.r5.model.Condition convertCondition(org.hl7.fhir.r4.model.Condition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Condition tgt = new org.hl7.fhir.r5.model.Condition();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_50.convertIdentifier(t));
    if (src.hasClinicalStatus())
      tgt.setClinicalStatus(CodeableConcept40_50.convertCodeableConcept(src.getClinicalStatus()));
    if (src.hasVerificationStatus())
      tgt.setVerificationStatus(CodeableConcept40_50.convertCodeableConcept(src.getVerificationStatus()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept40_50.convertCodeableConcept(t));
    if (src.hasSeverity())
      tgt.setSeverity(CodeableConcept40_50.convertCodeableConcept(src.getSeverity()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_50.convertCodeableConcept(src.getCode()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getBodySite())
      tgt.addBodySite(CodeableConcept40_50.convertCodeableConcept(t));
    if (src.hasSubject())
      tgt.setSubject(Reference40_50.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference40_50.convertReference(src.getEncounter()));
    if (src.hasOnset())
      tgt.setOnset(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getOnset()));
    if (src.hasAbatement())
      tgt.setAbatement(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getAbatement()));
    if (src.hasRecordedDate())
      tgt.setRecordedDateElement(DateTime40_50.convertDateTime(src.getRecordedDateElement()));
    if (src.hasRecorder())
      tgt.addParticipant().setFunction(new CodeableConcept(new Coding("http://terminology.hl7.org/CodeSystem/provenance-participant-type", "author", "Author"))).setActor(Reference40_50.convertReference(src.getRecorder()));    
    if (src.hasAsserter())
      tgt.addParticipant().setFunction(new CodeableConcept(new Coding("http://terminology.hl7.org/CodeSystem/provenance-participant-type", "informant", "Informant"))).setActor(Reference40_50.convertReference(src.getAsserter()));
    for (org.hl7.fhir.r4.model.Condition.ConditionStageComponent t : src.getStage())
      tgt.addStage(convertConditionStageComponent(t));
    for (org.hl7.fhir.r4.model.Condition.ConditionEvidenceComponent t : src.getEvidence())
      tgt.getEvidence().addAll(convertConditionEvidenceComponent(t));
    for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.addNote(Annotation40_50.convertAnnotation(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Condition convertCondition(org.hl7.fhir.r5.model.Condition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Condition tgt = new org.hl7.fhir.r4.model.Condition();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_50.convertIdentifier(t));
    if (src.hasClinicalStatus())
      tgt.setClinicalStatus(CodeableConcept40_50.convertCodeableConcept(src.getClinicalStatus()));
    if (src.hasVerificationStatus())
      tgt.setVerificationStatus(CodeableConcept40_50.convertCodeableConcept(src.getVerificationStatus()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept40_50.convertCodeableConcept(t));
    if (src.hasSeverity())
      tgt.setSeverity(CodeableConcept40_50.convertCodeableConcept(src.getSeverity()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_50.convertCodeableConcept(src.getCode()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getBodySite())
      tgt.addBodySite(CodeableConcept40_50.convertCodeableConcept(t));
    if (src.hasSubject())
      tgt.setSubject(Reference40_50.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference40_50.convertReference(src.getEncounter()));
    if (src.hasOnset())
      tgt.setOnset(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getOnset()));
    if (src.hasAbatement())
      tgt.setAbatement(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getAbatement()));
    if (src.hasRecordedDate())
      tgt.setRecordedDateElement(DateTime40_50.convertDateTime(src.getRecordedDateElement()));
    for (org.hl7.fhir.r5.model.Condition.ConditionParticipantComponent t : src.getParticipant()) {
      if (t.getFunction().hasCoding("http://terminology.hl7.org/CodeSystem/provenance-participant-type", "author"))
        tgt.setRecorder(Reference40_50.convertReference(t.getActor()));
      if (t.getFunction().hasCoding("http://terminology.hl7.org/CodeSystem/provenance-participant-type", "informant"))
        tgt.setAsserter(Reference40_50.convertReference(t.getActor()));
    }
    for (org.hl7.fhir.r5.model.Condition.ConditionStageComponent t : src.getStage())
      tgt.addStage(convertConditionStageComponent(t));
    for (CodeableReference t : src.getEvidence())
      tgt.addEvidence(convertConditionEvidenceComponent(t));
    for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.addNote(Annotation40_50.convertAnnotation(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Condition.ConditionStageComponent convertConditionStageComponent(org.hl7.fhir.r4.model.Condition.ConditionStageComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Condition.ConditionStageComponent tgt = new org.hl7.fhir.r5.model.Condition.ConditionStageComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasSummary())
      tgt.setSummary(CodeableConcept40_50.convertCodeableConcept(src.getSummary()));
    for (org.hl7.fhir.r4.model.Reference t : src.getAssessment()) tgt.addAssessment(Reference40_50.convertReference(t));
    if (src.hasType())
      tgt.setType(CodeableConcept40_50.convertCodeableConcept(src.getType()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Condition.ConditionStageComponent convertConditionStageComponent(org.hl7.fhir.r5.model.Condition.ConditionStageComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Condition.ConditionStageComponent tgt = new org.hl7.fhir.r4.model.Condition.ConditionStageComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasSummary())
      tgt.setSummary(CodeableConcept40_50.convertCodeableConcept(src.getSummary()));
    for (org.hl7.fhir.r5.model.Reference t : src.getAssessment()) tgt.addAssessment(Reference40_50.convertReference(t));
    if (src.hasType())
      tgt.setType(CodeableConcept40_50.convertCodeableConcept(src.getType()));
    return tgt;
  }

  public static List<org.hl7.fhir.r5.model.CodeableReference> convertConditionEvidenceComponent(org.hl7.fhir.r4.model.Condition.ConditionEvidenceComponent src) throws FHIRException {
    if (src == null)
      return null;
    List<org.hl7.fhir.r5.model.CodeableReference> list = new ArrayList<>();
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCode()) {
      org.hl7.fhir.r5.model.CodeableReference tgt = new org.hl7.fhir.r5.model.CodeableReference();
      ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
      tgt.setConcept(CodeableConcept40_50.convertCodeableConcept(t));
      list.add(tgt);
    }
    for (org.hl7.fhir.r4.model.Reference t : src.getDetail()) {
      org.hl7.fhir.r5.model.CodeableReference tgt = new org.hl7.fhir.r5.model.CodeableReference();
      ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
      tgt.setReference(Reference40_50.convertReference(t));
      list.add(tgt);
    }
    return list;
  }

  public static org.hl7.fhir.r4.model.Condition.ConditionEvidenceComponent convertConditionEvidenceComponent(org.hl7.fhir.r5.model.CodeableReference src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Condition.ConditionEvidenceComponent tgt = new org.hl7.fhir.r4.model.Condition.ConditionEvidenceComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasConcept())
      tgt.addCode(CodeableConcept40_50.convertCodeableConcept(src.getConcept()));
    if (src.hasReference())
      tgt.addDetail(Reference40_50.convertReference(src.getReference()));
    return tgt;
  }
  
}