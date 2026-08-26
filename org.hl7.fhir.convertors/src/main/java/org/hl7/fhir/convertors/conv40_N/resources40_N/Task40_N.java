package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Annotation40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Identifier40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Period40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Canonical40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.DateTime40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.PositiveInt40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.String40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Uri40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Reference40_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.CodeableReference;
import org.hl7.fhir.model.core.Enumeration;
import org.hl7.fhir.model.core.Enumerations;
import org.hl7.fhir.model.core.Task;

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

public class Task40_N {

  public static org.hl7.fhir.model.core.Task convertTask(org.hl7.fhir.r4.model.Task src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Task tgt = new org.hl7.fhir.model.core.Task();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getBasedOn()) tgt.addBasedOn(Reference40_N.convertReference(t));
    if (src.hasGroupIdentifier())
      tgt.setGroupIdentifier(Identifier40_N.convertIdentifier(src.getGroupIdentifier()));
    for (org.hl7.fhir.r4.model.Reference t : src.getPartOf()) tgt.addPartOf(Reference40_N.convertReference(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertTaskStatus(src.getStatusElement()));
    if (src.hasStatusReason())
      tgt.addStatusReason(CodeableConcept40_N.convertCodeableConceptToCodeableReference(src.getStatusReason()));
    if (src.hasBusinessStatus())
      tgt.setBusinessStatus(CodeableConcept40_N.convertCodeableConcept(src.getBusinessStatus()));
    if (src.hasIntent())
      tgt.setIntentElement(convertTaskIntent(src.getIntentElement()));
    if (src.hasPriority())
      tgt.setPriorityElement(convertTaskPriority(src.getPriorityElement()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_N.convertCodeableConcept(src.getCode()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_N.convertStringToMarkdown(src.getDescriptionElement()));
    if (src.hasFocus())
      tgt.addFocus().setValue(Reference40_N.convertReference(src.getFocus()));
    if (src.hasFor())
      tgt.setFor(Reference40_N.convertReference(src.getFor()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference40_N.convertReference(src.getEncounter()));
    if (src.hasExecutionPeriod())
      tgt.setExecutionPeriod(Period40_N.convertPeriod(src.getExecutionPeriod()));
    if (src.hasAuthoredOn())
      tgt.setAuthoredOnElement(DateTime40_N.convertDateTime(src.getAuthoredOnElement()));
    if (src.hasLastModified())
      tgt.setLastModifiedElement(DateTime40_N.convertDateTime(src.getLastModifiedElement()));
    if (src.hasRequester())
      tgt.setRequester(Reference40_N.convertReference(src.getRequester()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getPerformerType())
      tgt.addRequestedPerformer(CodeableConcept40_N.convertCodeableConceptToCodeableReference(t));
    if (src.hasOwner())
      tgt.setOwner(Reference40_N.convertReference(src.getOwner()));
    if (src.hasLocation())
      tgt.setLocation(Reference40_N.convertReference(src.getLocation()));
    if (src.hasReasonCode())
      tgt.addReason(CodeableConcept40_N.convertCodeableConceptToCodeableReference(src.getReasonCode()));
    if (src.hasReasonReference())
      tgt.addReason(Reference40_N.convertReferenceToCodeableReference(src.getReasonReference()));
    for (org.hl7.fhir.r4.model.Reference t : src.getInsurance()) tgt.addInsurance(Reference40_N.convertReference(t));
    for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.addNote(Annotation40_N.convertAnnotation(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getRelevantHistory())
      tgt.addRelevantHistory(Reference40_N.convertReference(t));
    if (src.hasRestriction())
      tgt.setRestriction(convertTaskRestrictionComponent(src.getRestriction()));
    for (org.hl7.fhir.r4.model.Task.ParameterComponent t : src.getInput()) tgt.addInput(convertParameterComponent(t));
    for (org.hl7.fhir.r4.model.Task.TaskOutputComponent t : src.getOutput())
      tgt.addOutput(convertTaskOutputComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Task convertTask(org.hl7.fhir.model.core.Task src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Task tgt = new org.hl7.fhir.r4.model.Task();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    for (org.hl7.fhir.model.core.Reference t : src.getBasedOnList()) tgt.addBasedOn(Reference40_N.convertReference(t));
    if (src.hasGroupIdentifier())
      tgt.setGroupIdentifier(Identifier40_N.convertIdentifier(src.getGroupIdentifier()));
    for (org.hl7.fhir.model.core.Reference t : src.getPartOfList()) tgt.addPartOf(Reference40_N.convertReference(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertTaskStatus(src.getStatusElement()));
    if (src.hasStatusReason())
      tgt.setStatusReason(CodeableConcept40_N.convertCodeableReferenceToCodeableConcept(src.getStatusReasonFirstRep()));
    if (src.hasBusinessStatus())
      tgt.setBusinessStatus(CodeableConcept40_N.convertCodeableConcept(src.getBusinessStatus()));
    if (src.hasIntent())
      tgt.setIntentElement(convertTaskIntent(src.getIntentElement()));
    if (src.hasPriority())
      tgt.setPriorityElement(convertTaskPriority(src.getPriorityElement()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_N.convertCodeableConcept(src.getCode()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_N.convertString(src.getDescriptionElement()));
    if (src.hasFocus())
      tgt.setFocus(Reference40_N.convertReference(src.getFocusFirstRep().getValueReference()));
    if (src.hasFor())
      tgt.setFor(Reference40_N.convertReference(src.getFor()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference40_N.convertReference(src.getEncounter()));
    if (src.hasExecutionPeriod())
      tgt.setExecutionPeriod(Period40_N.convertPeriod(src.getExecutionPeriod()));
    if (src.hasAuthoredOn())
      tgt.setAuthoredOnElement(DateTime40_N.convertDateTime(src.getAuthoredOnElement()));
    if (src.hasLastModified())
      tgt.setLastModifiedElement(DateTime40_N.convertDateTime(src.getLastModifiedElement()));
    if (src.hasRequester())
      tgt.setRequester(Reference40_N.convertReference(src.getRequester()));
    for (org.hl7.fhir.model.core.CodeableReference t : src.getRequestedPerformerList())
      tgt.addPerformerType(CodeableConcept40_N.convertCodeableReferenceToCodeableConcept(t));
    if (src.hasOwner())
      tgt.setOwner(Reference40_N.convertReference(src.getOwner()));
    if (src.hasLocation())
      tgt.setLocation(Reference40_N.convertReference(src.getLocation()));
    for (CodeableReference t : src.getReasonList()) {
      if (t.hasConcept())
        tgt.setReasonCode(CodeableConcept40_N.convertCodeableConcept(t.getConcept()));
      else if (t.hasReference())
        tgt.setReasonReference(Reference40_N.convertReference(t.getReference()));
    }
    for (org.hl7.fhir.model.core.Reference t : src.getInsuranceList()) tgt.addInsurance(Reference40_N.convertReference(t));
    for (org.hl7.fhir.model.core.Annotation t : src.getNoteList()) tgt.addNote(Annotation40_N.convertAnnotation(t));
    for (org.hl7.fhir.model.core.Reference t : src.getRelevantHistoryList())
      tgt.addRelevantHistory(Reference40_N.convertReference(t));
    if (src.hasRestriction())
      tgt.setRestriction(convertTaskRestrictionComponent(src.getRestriction()));
    for (org.hl7.fhir.model.core.Task.TaskInputComponent t : src.getInputList()) tgt.addInput(convertParameterComponent(t));
    for (org.hl7.fhir.model.core.Task.TaskOutputComponent t : src.getOutputList())
      tgt.addOutput(convertTaskOutputComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Task.TaskStatus> convertTaskStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Task.TaskStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Task.TaskStatus> tgt = new Enumeration<>(new Task.TaskStatusEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case DRAFT:
                  tgt.setValue(Task.TaskStatus.DRAFT);
                  break;
              case REQUESTED:
                  tgt.setValue(Task.TaskStatus.REQUESTED);
                  break;
              case RECEIVED:
                  tgt.setValue(Task.TaskStatus.RECEIVED);
                  break;
              case ACCEPTED:
                  tgt.setValue(Task.TaskStatus.ACCEPTED);
                  break;
              case REJECTED:
                  tgt.setValue(Task.TaskStatus.REJECTED);
                  break;
              case READY:
                  tgt.setValue(Task.TaskStatus.READY);
                  break;
              case CANCELLED:
                  tgt.setValue(Task.TaskStatus.CANCELLED);
                  break;
              case INPROGRESS:
                  tgt.setValue(Task.TaskStatus.INPROGRESS);
                  break;
              case ONHOLD:
                  tgt.setValue(Task.TaskStatus.ONHOLD);
                  break;
              case FAILED:
                  tgt.setValue(Task.TaskStatus.FAILED);
                  break;
              case COMPLETED:
                  tgt.setValue(Task.TaskStatus.COMPLETED);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(Task.TaskStatus.ENTEREDINERROR);
                  break;
              default:
                  tgt.setValue(Task.TaskStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Task.TaskStatus> convertTaskStatus(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Task.TaskStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Task.TaskStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Task.TaskStatusEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case DRAFT:
                  tgt.setValue(org.hl7.fhir.r4.model.Task.TaskStatus.DRAFT);
                  break;
              case REQUESTED:
                  tgt.setValue(org.hl7.fhir.r4.model.Task.TaskStatus.REQUESTED);
                  break;
              case RECEIVED:
                  tgt.setValue(org.hl7.fhir.r4.model.Task.TaskStatus.RECEIVED);
                  break;
              case ACCEPTED:
                  tgt.setValue(org.hl7.fhir.r4.model.Task.TaskStatus.ACCEPTED);
                  break;
              case REJECTED:
                  tgt.setValue(org.hl7.fhir.r4.model.Task.TaskStatus.REJECTED);
                  break;
              case READY:
                  tgt.setValue(org.hl7.fhir.r4.model.Task.TaskStatus.READY);
                  break;
              case CANCELLED:
                  tgt.setValue(org.hl7.fhir.r4.model.Task.TaskStatus.CANCELLED);
                  break;
              case INPROGRESS:
                  tgt.setValue(org.hl7.fhir.r4.model.Task.TaskStatus.INPROGRESS);
                  break;
              case ONHOLD:
                  tgt.setValue(org.hl7.fhir.r4.model.Task.TaskStatus.ONHOLD);
                  break;
              case FAILED:
                  tgt.setValue(org.hl7.fhir.r4.model.Task.TaskStatus.FAILED);
                  break;
              case COMPLETED:
                  tgt.setValue(org.hl7.fhir.r4.model.Task.TaskStatus.COMPLETED);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(org.hl7.fhir.r4.model.Task.TaskStatus.ENTEREDINERROR);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4.model.Task.TaskStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Task.TaskIntent> convertTaskIntent(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Task.TaskIntent> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Task.TaskIntent> tgt = new Enumeration<>(new Task.TaskIntentEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case UNKNOWN:
                  tgt.setValue(Task.TaskIntent.UNKNOWN);
                  break;
              case PROPOSAL:
                  tgt.setValue(Task.TaskIntent.PROPOSAL);
                  break;
              case PLAN:
                  tgt.setValue(Task.TaskIntent.PLAN);
                  break;
              case ORDER:
                  tgt.setValue(Task.TaskIntent.ORDER);
                  break;
              case ORIGINALORDER:
                  tgt.setValue(Task.TaskIntent.ORIGINALORDER);
                  break;
              case REFLEXORDER:
                  tgt.setValue(Task.TaskIntent.REFLEXORDER);
                  break;
              case FILLERORDER:
                  tgt.setValue(Task.TaskIntent.FILLERORDER);
                  break;
              case INSTANCEORDER:
                  tgt.setValue(Task.TaskIntent.INSTANCEORDER);
                  break;
              case OPTION:
                  tgt.setValue(Task.TaskIntent.OPTION);
                  break;
              default:
                  tgt.setValue(Task.TaskIntent.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Task.TaskIntent> convertTaskIntent(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Task.TaskIntent> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Task.TaskIntent> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Task.TaskIntentEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case UNKNOWN:
                  tgt.setValue(org.hl7.fhir.r4.model.Task.TaskIntent.UNKNOWN);
                  break;
              case PROPOSAL:
                  tgt.setValue(org.hl7.fhir.r4.model.Task.TaskIntent.PROPOSAL);
                  break;
              case PLAN:
                  tgt.setValue(org.hl7.fhir.r4.model.Task.TaskIntent.PLAN);
                  break;
              case ORDER:
                  tgt.setValue(org.hl7.fhir.r4.model.Task.TaskIntent.ORDER);
                  break;
              case ORIGINALORDER:
                  tgt.setValue(org.hl7.fhir.r4.model.Task.TaskIntent.ORIGINALORDER);
                  break;
              case REFLEXORDER:
                  tgt.setValue(org.hl7.fhir.r4.model.Task.TaskIntent.REFLEXORDER);
                  break;
              case FILLERORDER:
                  tgt.setValue(org.hl7.fhir.r4.model.Task.TaskIntent.FILLERORDER);
                  break;
              case INSTANCEORDER:
                  tgt.setValue(org.hl7.fhir.r4.model.Task.TaskIntent.INSTANCEORDER);
                  break;
              case OPTION:
                  tgt.setValue(org.hl7.fhir.r4.model.Task.TaskIntent.OPTION);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4.model.Task.TaskIntent.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.RequestPriority> convertTaskPriority(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Task.TaskPriority> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Enumerations.RequestPriority> tgt = new Enumeration<>(new Enumerations.RequestPriorityEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case ROUTINE:
                  tgt.setValue(Enumerations.RequestPriority.ROUTINE);
                  break;
              case URGENT:
                  tgt.setValue(Enumerations.RequestPriority.URGENT);
                  break;
              case ASAP:
                  tgt.setValue(Enumerations.RequestPriority.ASAP);
                  break;
              case STAT:
                  tgt.setValue(Enumerations.RequestPriority.STAT);
                  break;
              default:
                  tgt.setValue(Enumerations.RequestPriority.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Task.TaskPriority> convertTaskPriority(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.RequestPriority> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Task.TaskPriority> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Task.TaskPriorityEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case ROUTINE:
                  tgt.setValue(org.hl7.fhir.r4.model.Task.TaskPriority.ROUTINE);
                  break;
              case URGENT:
                  tgt.setValue(org.hl7.fhir.r4.model.Task.TaskPriority.URGENT);
                  break;
              case ASAP:
                  tgt.setValue(org.hl7.fhir.r4.model.Task.TaskPriority.ASAP);
                  break;
              case STAT:
                  tgt.setValue(org.hl7.fhir.r4.model.Task.TaskPriority.STAT);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4.model.Task.TaskPriority.NULL);
                  break;
          }
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.Task.TaskRestrictionComponent convertTaskRestrictionComponent(org.hl7.fhir.r4.model.Task.TaskRestrictionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Task.TaskRestrictionComponent tgt = new org.hl7.fhir.model.core.Task.TaskRestrictionComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasRepetitions())
      tgt.setRepetitionsElement(PositiveInt40_N.convertPositiveInt(src.getRepetitionsElement()));
    if (src.hasPeriod())
      tgt.setPeriod(Period40_N.convertPeriod(src.getPeriod()));
    for (org.hl7.fhir.r4.model.Reference t : src.getRecipient()) tgt.addRecipient(Reference40_N.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Task.TaskRestrictionComponent convertTaskRestrictionComponent(org.hl7.fhir.model.core.Task.TaskRestrictionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Task.TaskRestrictionComponent tgt = new org.hl7.fhir.r4.model.Task.TaskRestrictionComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasRepetitions())
      tgt.setRepetitionsElement(PositiveInt40_N.convertPositiveInt(src.getRepetitionsElement()));
    if (src.hasPeriod())
      tgt.setPeriod(Period40_N.convertPeriod(src.getPeriod()));
    for (org.hl7.fhir.model.core.Reference t : src.getRecipientList()) tgt.addRecipient(Reference40_N.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.Task.TaskInputComponent convertParameterComponent(org.hl7.fhir.r4.model.Task.ParameterComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Task.TaskInputComponent tgt = new org.hl7.fhir.model.core.Task.TaskInputComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    if (src.hasValue())
      tgt.setValue(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getValue()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Task.ParameterComponent convertParameterComponent(org.hl7.fhir.model.core.Task.TaskInputComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Task.ParameterComponent tgt = new org.hl7.fhir.r4.model.Task.ParameterComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    if (src.hasValue())
      tgt.setValue(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getValue()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.Task.TaskOutputComponent convertTaskOutputComponent(org.hl7.fhir.r4.model.Task.TaskOutputComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Task.TaskOutputComponent tgt = new org.hl7.fhir.model.core.Task.TaskOutputComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    if (src.hasValue())
      tgt.setValue(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getValue()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Task.TaskOutputComponent convertTaskOutputComponent(org.hl7.fhir.model.core.Task.TaskOutputComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Task.TaskOutputComponent tgt = new org.hl7.fhir.r4.model.Task.TaskOutputComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    if (src.hasValue())
      tgt.setValue(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getValue()));
    return tgt;
  }
}