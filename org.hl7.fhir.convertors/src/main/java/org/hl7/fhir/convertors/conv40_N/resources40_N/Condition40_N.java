package org.hl7.fhir.convertors.conv40_N.resources40_N;

import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Annotation40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Identifier40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.DateTime40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Reference40_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.CodeableConcept;
import org.hl7.fhir.model.core.CodeableReference;
import org.hl7.fhir.model.core.Coding;

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

public class Condition40_N {

  public static org.hl7.fhir.model.core.Condition convertCondition(org.hl7.fhir.r4.model.Condition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Condition tgt = new org.hl7.fhir.model.core.Condition();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    if (src.hasClinicalStatus())
      tgt.setClinicalStatus(CodeableConcept40_N.convertCodeableConcept(src.getClinicalStatus()));
    if (src.hasVerificationStatus())
      tgt.setVerificationStatus(CodeableConcept40_N.convertCodeableConcept(src.getVerificationStatus()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasSeverity())
      tgt.setSeverity(CodeableConcept40_N.convertCodeableConcept(src.getSeverity()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_N.convertCodeableConcept(src.getCode()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getBodySite())
      tgt.addBodyStructure().setConcept(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasSubject())
      tgt.setSubject(Reference40_N.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference40_N.convertReference(src.getEncounter()));
    if (src.hasOnset())
      tgt.setOnset(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getOnset()));
    if (src.hasAbatement())
      tgt.setAbatement(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getAbatement()));
    if (src.hasRecordedDate())
      tgt.setRecordedDateElement(DateTime40_N.convertDateTime(src.getRecordedDateElement()));
    if (src.hasRecorder())
      tgt.setRecorder(Reference40_N.convertReference(src.getRecorder()));
    if (src.hasAsserter())
      tgt.setAsserter(Reference40_N.convertReference(src.getAsserter()));
    for (org.hl7.fhir.r4.model.Condition.ConditionStageComponent t : src.getStage())
      tgt.addStage(convertConditionStageComponent(t));
    for (org.hl7.fhir.r4.model.Condition.ConditionEvidenceComponent t : src.getEvidence())
      tgt.getEvidenceList().addAll(convertConditionEvidenceComponent(t));
    for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.addNote(Annotation40_N.convertAnnotation(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Condition convertCondition(org.hl7.fhir.model.core.Condition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Condition tgt = new org.hl7.fhir.r4.model.Condition();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    if (src.hasClinicalStatus())
      tgt.setClinicalStatus(CodeableConcept40_N.convertCodeableConcept(src.getClinicalStatus()));
    if (src.hasVerificationStatus())
      tgt.setVerificationStatus(CodeableConcept40_N.convertCodeableConcept(src.getVerificationStatus()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getCategoryList())
      tgt.addCategory(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasSeverity())
      tgt.setSeverity(CodeableConcept40_N.convertCodeableConcept(src.getSeverity()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_N.convertCodeableConcept(src.getCode()));
    for (org.hl7.fhir.model.core.CodeableReference t : src.getBodyStructureList())
      tgt.addBodySite(CodeableConcept40_N.convertCodeableConcept(t.getConcept()));
    if (src.hasSubject())
      tgt.setSubject(Reference40_N.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference40_N.convertReference(src.getEncounter()));
    if (src.hasOnset())
      tgt.setOnset(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getOnset()));
    if (src.hasAbatement())
      tgt.setAbatement(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getAbatement()));
    if (src.hasRecordedDate())
      tgt.setRecordedDateElement(DateTime40_N.convertDateTime(src.getRecordedDateElement()));
    if (src.hasRecorder())
      tgt.setRecorder(Reference40_N.convertReference(src.getRecorder()));
    if (src.hasAsserter())
      tgt.setAsserter(Reference40_N.convertReference(src.getAsserter()));
    for (org.hl7.fhir.model.core.Condition.ConditionStageComponent t : src.getStageList())
      tgt.addStage(convertConditionStageComponent(t));
    for (CodeableReference t : src.getEvidenceList())
      tgt.addEvidence(convertConditionEvidenceComponent(t));
    for (org.hl7.fhir.model.core.Annotation t : src.getNoteList()) tgt.addNote(Annotation40_N.convertAnnotation(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.Condition.ConditionStageComponent convertConditionStageComponent(org.hl7.fhir.r4.model.Condition.ConditionStageComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Condition.ConditionStageComponent tgt = new org.hl7.fhir.model.core.Condition.ConditionStageComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasSummary())
      tgt.setSummary(CodeableConcept40_N.convertCodeableConcept(src.getSummary()));
    for (org.hl7.fhir.r4.model.Reference t : src.getAssessment()) tgt.addAssessment(Reference40_N.convertReference(t));
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Condition.ConditionStageComponent convertConditionStageComponent(org.hl7.fhir.model.core.Condition.ConditionStageComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Condition.ConditionStageComponent tgt = new org.hl7.fhir.r4.model.Condition.ConditionStageComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasSummary())
      tgt.setSummary(CodeableConcept40_N.convertCodeableConcept(src.getSummary()));
    for (org.hl7.fhir.model.core.Reference t : src.getAssessmentList()) tgt.addAssessment(Reference40_N.convertReference(t));
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    return tgt;
  }

  public static List<org.hl7.fhir.model.core.CodeableReference> convertConditionEvidenceComponent(org.hl7.fhir.r4.model.Condition.ConditionEvidenceComponent src) throws FHIRException {
    if (src == null)
      return null;
    List<org.hl7.fhir.model.core.CodeableReference> list = new ArrayList<>();
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCode()) {
      org.hl7.fhir.model.core.CodeableReference tgt = new org.hl7.fhir.model.core.CodeableReference();
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      tgt.setConcept(CodeableConcept40_N.convertCodeableConcept(t));
      list.add(tgt);
    }
    for (org.hl7.fhir.r4.model.Reference t : src.getDetail()) {
      org.hl7.fhir.model.core.CodeableReference tgt = new org.hl7.fhir.model.core.CodeableReference();
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      tgt.setReference(Reference40_N.convertReference(t));
      list.add(tgt);
    }
    return list;
  }

  public static org.hl7.fhir.r4.model.Condition.ConditionEvidenceComponent convertConditionEvidenceComponent(org.hl7.fhir.model.core.CodeableReference src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Condition.ConditionEvidenceComponent tgt = new org.hl7.fhir.r4.model.Condition.ConditionEvidenceComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasConcept())
      tgt.addCode(CodeableConcept40_N.convertCodeableConcept(src.getConcept()));
    if (src.hasReference())
      tgt.addDetail(Reference40_N.convertReference(src.getReference()));
    return tgt;
  }
  
}