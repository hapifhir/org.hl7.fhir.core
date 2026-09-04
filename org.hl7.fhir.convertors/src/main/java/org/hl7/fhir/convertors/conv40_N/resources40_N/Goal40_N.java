package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Annotation40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Identifier40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Date40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.String40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Reference40_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.CodeableReference;
import org.hl7.fhir.model.core.Enumeration;
import org.hl7.fhir.model.core.Goal;

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

public class Goal40_N {

  public static org.hl7.fhir.model.core.Goal convertGoal(org.hl7.fhir.r4.model.Goal src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Goal tgt = new org.hl7.fhir.model.core.Goal();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    if (src.hasLifecycleStatus())
      tgt.setLifecycleStatusElement(convertGoalLifecycleStatus(src.getLifecycleStatusElement()));
    if (src.hasAchievementStatus())
      tgt.setAchievementStatus(CodeableConcept40_N.convertCodeableConcept(src.getAchievementStatus()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasPriority())
      tgt.setPriority(CodeableConcept40_N.convertCodeableConcept(src.getPriority()));
    if (src.hasDescription())
      tgt.setDescription(CodeableConcept40_N.convertCodeableConcept(src.getDescription()));
    if (src.hasSubject())
      tgt.setSubject(Reference40_N.convertReference(src.getSubject()));
    if (src.hasStart())
      tgt.setStart(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getStart()));
    for (org.hl7.fhir.r4.model.Goal.GoalTargetComponent t : src.getTarget())
      tgt.addTarget(convertGoalTargetComponent(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getAddresses()) tgt.addAddresses(Reference40_N.convertReference(t));
    for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.addNote(Annotation40_N.convertAnnotation(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Goal convertGoal(org.hl7.fhir.model.core.Goal src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Goal tgt = new org.hl7.fhir.r4.model.Goal();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    if (src.hasLifecycleStatus())
      tgt.setLifecycleStatusElement(convertGoalLifecycleStatus(src.getLifecycleStatusElement()));
    if (src.hasAchievementStatus())
      tgt.setAchievementStatus(CodeableConcept40_N.convertCodeableConcept(src.getAchievementStatus()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getCategoryList())
      tgt.addCategory(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasPriority())
      tgt.setPriority(CodeableConcept40_N.convertCodeableConcept(src.getPriority()));
    if (src.hasDescription())
      tgt.setDescription(CodeableConcept40_N.convertCodeableConcept(src.getDescription()));
    if (src.hasSubject())
      tgt.setSubject(Reference40_N.convertReference(src.getSubject()));
    if (src.hasStart())
      tgt.setStart(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getStart()));
    for (org.hl7.fhir.model.core.Goal.GoalTargetComponent t : src.getTargetList())
      tgt.addTarget(convertGoalTargetComponent(t));
    for (org.hl7.fhir.model.core.Reference t : src.getAddressesList()) tgt.addAddresses(Reference40_N.convertReference(t));
    for (org.hl7.fhir.model.core.Annotation t : src.getNoteList()) tgt.addNote(Annotation40_N.convertAnnotation(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Goal.GoalLifecycleStatus> convertGoalLifecycleStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Goal.GoalLifecycleStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Goal.GoalLifecycleStatus> tgt = new Enumeration<>(new Goal.GoalLifecycleStatusEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case PROPOSED:
                  tgt.setValue(Goal.GoalLifecycleStatus.PROPOSED);
                  break;
              case PLANNED:
                  tgt.setValue(Goal.GoalLifecycleStatus.PLANNED);
                  break;
              case ACCEPTED:
                  tgt.setValue(Goal.GoalLifecycleStatus.ACCEPTED);
                  break;
              case ACTIVE:
                  tgt.setValue(Goal.GoalLifecycleStatus.ACTIVE);
                  break;
              case ONHOLD:
                  tgt.setValue(Goal.GoalLifecycleStatus.ONHOLD);
                  break;
              case COMPLETED:
                  tgt.setValue(Goal.GoalLifecycleStatus.COMPLETED);
                  break;
              case CANCELLED:
                  tgt.setValue(Goal.GoalLifecycleStatus.CANCELLED);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(Goal.GoalLifecycleStatus.ENTEREDINERROR);
                  break;
              case REJECTED:
                  tgt.setValue(Goal.GoalLifecycleStatus.REJECTED);
                  break;
              default:
                  tgt.setValue(Goal.GoalLifecycleStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Goal.GoalLifecycleStatus> convertGoalLifecycleStatus(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Goal.GoalLifecycleStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Goal.GoalLifecycleStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Goal.GoalLifecycleStatusEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case PROPOSED:
                  tgt.setValue(org.hl7.fhir.r4.model.Goal.GoalLifecycleStatus.PROPOSED);
                  break;
              case PLANNED:
                  tgt.setValue(org.hl7.fhir.r4.model.Goal.GoalLifecycleStatus.PLANNED);
                  break;
              case ACCEPTED:
                  tgt.setValue(org.hl7.fhir.r4.model.Goal.GoalLifecycleStatus.ACCEPTED);
                  break;
              case ACTIVE:
                  tgt.setValue(org.hl7.fhir.r4.model.Goal.GoalLifecycleStatus.ACTIVE);
                  break;
              case ONHOLD:
                  tgt.setValue(org.hl7.fhir.r4.model.Goal.GoalLifecycleStatus.ONHOLD);
                  break;
              case COMPLETED:
                  tgt.setValue(org.hl7.fhir.r4.model.Goal.GoalLifecycleStatus.COMPLETED);
                  break;
              case CANCELLED:
                  tgt.setValue(org.hl7.fhir.r4.model.Goal.GoalLifecycleStatus.CANCELLED);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(org.hl7.fhir.r4.model.Goal.GoalLifecycleStatus.ENTEREDINERROR);
                  break;
              case REJECTED:
                  tgt.setValue(org.hl7.fhir.r4.model.Goal.GoalLifecycleStatus.REJECTED);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4.model.Goal.GoalLifecycleStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.Goal.GoalTargetComponent convertGoalTargetComponent(org.hl7.fhir.r4.model.Goal.GoalTargetComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Goal.GoalTargetComponent tgt = new org.hl7.fhir.model.core.Goal.GoalTargetComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasMeasure())
      tgt.setMeasure(CodeableConcept40_N.convertCodeableConcept(src.getMeasure()));
    if (src.hasDetail())
      tgt.setDetail(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getDetail()));
    if (src.hasDue())
      tgt.setDue(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getDue()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Goal.GoalTargetComponent convertGoalTargetComponent(org.hl7.fhir.model.core.Goal.GoalTargetComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Goal.GoalTargetComponent tgt = new org.hl7.fhir.r4.model.Goal.GoalTargetComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasMeasure())
      tgt.setMeasure(CodeableConcept40_N.convertCodeableConcept(src.getMeasure()));
    if (src.hasDetail())
      tgt.setDetail(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getDetail()));
    if (src.hasDue())
      tgt.setDue(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getDue()));
    return tgt;
  }
}