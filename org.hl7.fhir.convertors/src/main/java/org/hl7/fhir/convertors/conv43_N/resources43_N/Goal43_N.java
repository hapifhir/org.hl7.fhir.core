package org.hl7.fhir.convertors.conv43_N.resources43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Annotation43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.CodeableConcept43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Identifier43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Date43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.String43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.special43_N.Reference43_N;
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

public class Goal43_N {

  public static org.hl7.fhir.model.core.Goal convertGoal(org.hl7.fhir.r4b.model.Goal src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Goal tgt = new org.hl7.fhir.model.core.Goal();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    if (src.hasLifecycleStatus())
      tgt.setLifecycleStatusElement(convertGoalLifecycleStatus(src.getLifecycleStatusElement()));
    if (src.hasAchievementStatus())
      tgt.setAchievementStatus(CodeableConcept43_N.convertCodeableConcept(src.getAchievementStatus()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasPriority())
      tgt.setPriority(CodeableConcept43_N.convertCodeableConcept(src.getPriority()));
    if (src.hasDescription())
      tgt.setDescription(CodeableConcept43_N.convertCodeableConcept(src.getDescription()));
    if (src.hasSubject())
      tgt.setSubject(Reference43_N.convertReference(src.getSubject()));
    if (src.hasStart())
      tgt.setStart(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getStart()));
    for (org.hl7.fhir.r4b.model.Goal.GoalTargetComponent t : src.getTarget())
      tgt.addTarget(convertGoalTargetComponent(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getAddresses()) tgt.addAddresses(Reference43_N.convertReference(t));
    for (org.hl7.fhir.r4b.model.Annotation t : src.getNote()) tgt.addNote(Annotation43_N.convertAnnotation(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Goal convertGoal(org.hl7.fhir.model.core.Goal src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Goal tgt = new org.hl7.fhir.r4b.model.Goal();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    if (src.hasLifecycleStatus())
      tgt.setLifecycleStatusElement(convertGoalLifecycleStatus(src.getLifecycleStatusElement()));
    if (src.hasAchievementStatus())
      tgt.setAchievementStatus(CodeableConcept43_N.convertCodeableConcept(src.getAchievementStatus()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getCategoryList())
      tgt.addCategory(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasPriority())
      tgt.setPriority(CodeableConcept43_N.convertCodeableConcept(src.getPriority()));
    if (src.hasDescription())
      tgt.setDescription(CodeableConcept43_N.convertCodeableConcept(src.getDescription()));
    if (src.hasSubject())
      tgt.setSubject(Reference43_N.convertReference(src.getSubject()));
    if (src.hasStart())
      tgt.setStart(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getStart()));
    for (org.hl7.fhir.model.core.Goal.GoalTargetComponent t : src.getTargetList())
      tgt.addTarget(convertGoalTargetComponent(t));
    for (org.hl7.fhir.model.core.Reference t : src.getAddressesList()) tgt.addAddresses(Reference43_N.convertReference(t));
    for (org.hl7.fhir.model.core.Annotation t : src.getNoteList()) tgt.addNote(Annotation43_N.convertAnnotation(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Goal.GoalLifecycleStatus> convertGoalLifecycleStatus(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Goal.GoalLifecycleStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Goal.GoalLifecycleStatus> tgt = new Enumeration<>(new Goal.GoalLifecycleStatusEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Goal.GoalLifecycleStatus> convertGoalLifecycleStatus(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Goal.GoalLifecycleStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Goal.GoalLifecycleStatus> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Goal.GoalLifecycleStatusEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
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
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.Goal.GoalTargetComponent convertGoalTargetComponent(org.hl7.fhir.r4b.model.Goal.GoalTargetComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Goal.GoalTargetComponent tgt = new org.hl7.fhir.model.core.Goal.GoalTargetComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasMeasure())
      tgt.setMeasure(CodeableConcept43_N.convertCodeableConcept(src.getMeasure()));
    if (src.hasDetail())
      tgt.setDetail(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getDetail()));
    if (src.hasDue())
      tgt.setDue(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getDue()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Goal.GoalTargetComponent convertGoalTargetComponent(org.hl7.fhir.model.core.Goal.GoalTargetComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Goal.GoalTargetComponent tgt = new org.hl7.fhir.r4b.model.Goal.GoalTargetComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasMeasure())
      tgt.setMeasure(CodeableConcept43_N.convertCodeableConcept(src.getMeasure()));
    if (src.hasDetail())
      tgt.setDetail(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getDetail()));
    if (src.hasDue())
      tgt.setDue(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getDue()));
    return tgt;
  }
}