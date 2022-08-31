package org.hl7.fhir.convertors.conv43_50.resources43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Annotation43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.CodeableConcept43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Identifier43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Date43_50;
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
public class Goal43_50 {

  public static org.hl7.fhir.r5.model.Goal convertGoal(org.hl7.fhir.r4b.model.Goal src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Goal tgt = new org.hl7.fhir.r5.model.Goal();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    if (src.hasLifecycleStatus())
      tgt.setLifecycleStatusElement(convertGoalLifecycleStatus(src.getLifecycleStatusElement()));
    if (src.hasAchievementStatus())
      tgt.setAchievementStatus(CodeableConcept43_50.convertCodeableConcept(src.getAchievementStatus()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasPriority())
      tgt.setPriority(CodeableConcept43_50.convertCodeableConcept(src.getPriority()));
    if (src.hasDescription())
      tgt.setDescription(CodeableConcept43_50.convertCodeableConcept(src.getDescription()));
    if (src.hasSubject())
      tgt.setSubject(Reference43_50.convertReference(src.getSubject()));
    if (src.hasStart())
      tgt.setStart(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getStart()));
    for (org.hl7.fhir.r4b.model.Goal.GoalTargetComponent t : src.getTarget())
      tgt.addTarget(convertGoalTargetComponent(t));
    if (src.hasStatusDate())
      tgt.setStatusDateElement(Date43_50.convertDate(src.getStatusDateElement()));
    if (src.hasStatusReason())
      tgt.setStatusReasonElement(String43_50.convertString(src.getStatusReasonElement()));
    for (org.hl7.fhir.r4b.model.Reference t : src.getAddresses()) tgt.addAddresses(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r4b.model.Annotation t : src.getNote()) tgt.addNote(Annotation43_50.convertAnnotation(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getOutcomeCode())
      tgt.addOutcome(CodeableConcept43_50.convertCodeableConceptToCodeableReference(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getOutcomeReference())
      tgt.addOutcome(Reference43_50.convertReferenceToCodeableReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Goal convertGoal(org.hl7.fhir.r5.model.Goal src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Goal tgt = new org.hl7.fhir.r4b.model.Goal();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    if (src.hasLifecycleStatus())
      tgt.setLifecycleStatusElement(convertGoalLifecycleStatus(src.getLifecycleStatusElement()));
    if (src.hasAchievementStatus())
      tgt.setAchievementStatus(CodeableConcept43_50.convertCodeableConcept(src.getAchievementStatus()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasPriority())
      tgt.setPriority(CodeableConcept43_50.convertCodeableConcept(src.getPriority()));
    if (src.hasDescription())
      tgt.setDescription(CodeableConcept43_50.convertCodeableConcept(src.getDescription()));
    if (src.hasSubject())
      tgt.setSubject(Reference43_50.convertReference(src.getSubject()));
    if (src.hasStart())
      tgt.setStart(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getStart()));
    for (org.hl7.fhir.r5.model.Goal.GoalTargetComponent t : src.getTarget())
      tgt.addTarget(convertGoalTargetComponent(t));
    if (src.hasStatusDate())
      tgt.setStatusDateElement(Date43_50.convertDate(src.getStatusDateElement()));
    if (src.hasStatusReason())
      tgt.setStatusReasonElement(String43_50.convertString(src.getStatusReasonElement()));
    for (org.hl7.fhir.r5.model.Reference t : src.getAddresses()) tgt.addAddresses(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.addNote(Annotation43_50.convertAnnotation(t));
    for (CodeableReference t : src.getOutcome())
      if (t.hasConcept())
        tgt.addOutcomeCode(CodeableConcept43_50.convertCodeableConcept(t.getConcept()));
    for (CodeableReference t : src.getOutcome())
      if (t.hasReference())
        tgt.addOutcomeReference(Reference43_50.convertReference(t.getReference()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Goal.GoalLifecycleStatus> convertGoalLifecycleStatus(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Goal.GoalLifecycleStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Goal.GoalLifecycleStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Goal.GoalLifecycleStatusEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case PROPOSED:
        tgt.setValue(org.hl7.fhir.r5.model.Goal.GoalLifecycleStatus.PROPOSED);
        break;
      case PLANNED:
        tgt.setValue(org.hl7.fhir.r5.model.Goal.GoalLifecycleStatus.PLANNED);
        break;
      case ACCEPTED:
        tgt.setValue(org.hl7.fhir.r5.model.Goal.GoalLifecycleStatus.ACCEPTED);
        break;
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.r5.model.Goal.GoalLifecycleStatus.ACTIVE);
        break;
      case ONHOLD:
        tgt.setValue(org.hl7.fhir.r5.model.Goal.GoalLifecycleStatus.ONHOLD);
        break;
      case COMPLETED:
        tgt.setValue(org.hl7.fhir.r5.model.Goal.GoalLifecycleStatus.COMPLETED);
        break;
      case CANCELLED:
        tgt.setValue(org.hl7.fhir.r5.model.Goal.GoalLifecycleStatus.CANCELLED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r5.model.Goal.GoalLifecycleStatus.ENTEREDINERROR);
        break;
      case REJECTED:
        tgt.setValue(org.hl7.fhir.r5.model.Goal.GoalLifecycleStatus.REJECTED);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.Goal.GoalLifecycleStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Goal.GoalLifecycleStatus> convertGoalLifecycleStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Goal.GoalLifecycleStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Goal.GoalLifecycleStatus> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Goal.GoalLifecycleStatusEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case PROPOSED:
        tgt.setValue(org.hl7.fhir.r4b.model.Goal.GoalLifecycleStatus.PROPOSED);
        break;
      case PLANNED:
        tgt.setValue(org.hl7.fhir.r4b.model.Goal.GoalLifecycleStatus.PLANNED);
        break;
      case ACCEPTED:
        tgt.setValue(org.hl7.fhir.r4b.model.Goal.GoalLifecycleStatus.ACCEPTED);
        break;
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.r4b.model.Goal.GoalLifecycleStatus.ACTIVE);
        break;
      case ONHOLD:
        tgt.setValue(org.hl7.fhir.r4b.model.Goal.GoalLifecycleStatus.ONHOLD);
        break;
      case COMPLETED:
        tgt.setValue(org.hl7.fhir.r4b.model.Goal.GoalLifecycleStatus.COMPLETED);
        break;
      case CANCELLED:
        tgt.setValue(org.hl7.fhir.r4b.model.Goal.GoalLifecycleStatus.CANCELLED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r4b.model.Goal.GoalLifecycleStatus.ENTEREDINERROR);
        break;
      case REJECTED:
        tgt.setValue(org.hl7.fhir.r4b.model.Goal.GoalLifecycleStatus.REJECTED);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.Goal.GoalLifecycleStatus.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Goal.GoalTargetComponent convertGoalTargetComponent(org.hl7.fhir.r4b.model.Goal.GoalTargetComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Goal.GoalTargetComponent tgt = new org.hl7.fhir.r5.model.Goal.GoalTargetComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasMeasure())
      tgt.setMeasure(CodeableConcept43_50.convertCodeableConcept(src.getMeasure()));
    if (src.hasDetail())
      tgt.setDetail(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getDetail()));
    if (src.hasDue())
      tgt.setDue(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getDue()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Goal.GoalTargetComponent convertGoalTargetComponent(org.hl7.fhir.r5.model.Goal.GoalTargetComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Goal.GoalTargetComponent tgt = new org.hl7.fhir.r4b.model.Goal.GoalTargetComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasMeasure())
      tgt.setMeasure(CodeableConcept43_50.convertCodeableConcept(src.getMeasure()));
    if (src.hasDetail())
      tgt.setDetail(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getDetail()));
    if (src.hasDue())
      tgt.setDue(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getDue()));
    return tgt;
  }
}