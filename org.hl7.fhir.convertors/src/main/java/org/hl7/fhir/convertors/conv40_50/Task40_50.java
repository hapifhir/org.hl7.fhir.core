package org.hl7.fhir.convertors.conv40_50;


import org.hl7.fhir.convertors.VersionConvertor_40_50;
import org.hl7.fhir.exceptions.FHIRException;

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
public class Task40_50 extends VersionConvertor_40_50 {

    public static org.hl7.fhir.r5.model.Task convertTask(org.hl7.fhir.r4.model.Task src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Task tgt = new org.hl7.fhir.r5.model.Task();
        copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        if (src.hasInstantiatesCanonical())
            tgt.setInstantiatesCanonicalElement(convertCanonical(src.getInstantiatesCanonicalElement()));
        if (src.hasInstantiatesUri())
            tgt.setInstantiatesUriElement(convertUri(src.getInstantiatesUriElement()));
        for (org.hl7.fhir.r4.model.Reference t : src.getBasedOn()) tgt.addBasedOn(convertReference(t));
        if (src.hasGroupIdentifier())
            tgt.setGroupIdentifier(convertIdentifier(src.getGroupIdentifier()));
        for (org.hl7.fhir.r4.model.Reference t : src.getPartOf()) tgt.addPartOf(convertReference(t));
        if (src.hasStatus())
            tgt.setStatusElement(convertTaskStatus(src.getStatusElement()));
        if (src.hasStatusReason())
            tgt.setStatusReason(convertCodeableConcept(src.getStatusReason()));
        if (src.hasBusinessStatus())
            tgt.setBusinessStatus(convertCodeableConcept(src.getBusinessStatus()));
        if (src.hasIntent())
            tgt.setIntentElement(convertTaskIntent(src.getIntentElement()));
        if (src.hasPriority())
            tgt.setPriorityElement(convertTaskPriority(src.getPriorityElement()));
        if (src.hasCode())
            tgt.setCode(convertCodeableConcept(src.getCode()));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        if (src.hasFocus())
            tgt.setFocus(convertReference(src.getFocus()));
        if (src.hasFor())
            tgt.setFor(convertReference(src.getFor()));
        if (src.hasEncounter())
            tgt.setEncounter(convertReference(src.getEncounter()));
        if (src.hasExecutionPeriod())
            tgt.setExecutionPeriod(convertPeriod(src.getExecutionPeriod()));
        if (src.hasAuthoredOn())
            tgt.setAuthoredOnElement(convertDateTime(src.getAuthoredOnElement()));
        if (src.hasLastModified())
            tgt.setLastModifiedElement(convertDateTime(src.getLastModifiedElement()));
        if (src.hasRequester())
            tgt.setRequester(convertReference(src.getRequester()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getPerformerType()) tgt.addPerformerType(convertCodeableConcept(t));
        if (src.hasOwner())
            tgt.setOwner(convertReference(src.getOwner()));
        if (src.hasLocation())
            tgt.setLocation(convertReference(src.getLocation()));
        if (src.hasReasonCode())
            tgt.setReasonCode(convertCodeableConcept(src.getReasonCode()));
        if (src.hasReasonReference())
            tgt.setReasonReference(convertReference(src.getReasonReference()));
        for (org.hl7.fhir.r4.model.Reference t : src.getInsurance()) tgt.addInsurance(convertReference(t));
        for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.addNote(convertAnnotation(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getRelevantHistory()) tgt.addRelevantHistory(convertReference(t));
        if (src.hasRestriction())
            tgt.setRestriction(convertTaskRestrictionComponent(src.getRestriction()));
        for (org.hl7.fhir.r4.model.Task.ParameterComponent t : src.getInput()) tgt.addInput(convertParameterComponent(t));
        for (org.hl7.fhir.r4.model.Task.TaskOutputComponent t : src.getOutput()) tgt.addOutput(convertTaskOutputComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Task convertTask(org.hl7.fhir.r5.model.Task src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Task tgt = new org.hl7.fhir.r4.model.Task();
        copyDomainResource(src, tgt);
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        if (src.hasInstantiatesCanonical())
            tgt.setInstantiatesCanonicalElement(convertCanonical(src.getInstantiatesCanonicalElement()));
        if (src.hasInstantiatesUri())
            tgt.setInstantiatesUriElement(convertUri(src.getInstantiatesUriElement()));
        for (org.hl7.fhir.r5.model.Reference t : src.getBasedOn()) tgt.addBasedOn(convertReference(t));
        if (src.hasGroupIdentifier())
            tgt.setGroupIdentifier(convertIdentifier(src.getGroupIdentifier()));
        for (org.hl7.fhir.r5.model.Reference t : src.getPartOf()) tgt.addPartOf(convertReference(t));
        if (src.hasStatus())
            tgt.setStatusElement(convertTaskStatus(src.getStatusElement()));
        if (src.hasStatusReason())
            tgt.setStatusReason(convertCodeableConcept(src.getStatusReason()));
        if (src.hasBusinessStatus())
            tgt.setBusinessStatus(convertCodeableConcept(src.getBusinessStatus()));
        if (src.hasIntent())
            tgt.setIntentElement(convertTaskIntent(src.getIntentElement()));
        if (src.hasPriority())
            tgt.setPriorityElement(convertTaskPriority(src.getPriorityElement()));
        if (src.hasCode())
            tgt.setCode(convertCodeableConcept(src.getCode()));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        if (src.hasFocus())
            tgt.setFocus(convertReference(src.getFocus()));
        if (src.hasFor())
            tgt.setFor(convertReference(src.getFor()));
        if (src.hasEncounter())
            tgt.setEncounter(convertReference(src.getEncounter()));
        if (src.hasExecutionPeriod())
            tgt.setExecutionPeriod(convertPeriod(src.getExecutionPeriod()));
        if (src.hasAuthoredOn())
            tgt.setAuthoredOnElement(convertDateTime(src.getAuthoredOnElement()));
        if (src.hasLastModified())
            tgt.setLastModifiedElement(convertDateTime(src.getLastModifiedElement()));
        if (src.hasRequester())
            tgt.setRequester(convertReference(src.getRequester()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getPerformerType()) tgt.addPerformerType(convertCodeableConcept(t));
        if (src.hasOwner())
            tgt.setOwner(convertReference(src.getOwner()));
        if (src.hasLocation())
            tgt.setLocation(convertReference(src.getLocation()));
        if (src.hasReasonCode())
            tgt.setReasonCode(convertCodeableConcept(src.getReasonCode()));
        if (src.hasReasonReference())
            tgt.setReasonReference(convertReference(src.getReasonReference()));
        for (org.hl7.fhir.r5.model.Reference t : src.getInsurance()) tgt.addInsurance(convertReference(t));
        for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.addNote(convertAnnotation(t));
        for (org.hl7.fhir.r5.model.Reference t : src.getRelevantHistory()) tgt.addRelevantHistory(convertReference(t));
        if (src.hasRestriction())
            tgt.setRestriction(convertTaskRestrictionComponent(src.getRestriction()));
        for (org.hl7.fhir.r5.model.Task.ParameterComponent t : src.getInput()) tgt.addInput(convertParameterComponent(t));
        for (org.hl7.fhir.r5.model.Task.TaskOutputComponent t : src.getOutput()) tgt.addOutput(convertTaskOutputComponent(t));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Task.TaskStatus> convertTaskStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Task.TaskStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Task.TaskStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Task.TaskStatusEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case DRAFT:
                tgt.setValue(org.hl7.fhir.r5.model.Task.TaskStatus.DRAFT);
                break;
            case REQUESTED:
                tgt.setValue(org.hl7.fhir.r5.model.Task.TaskStatus.REQUESTED);
                break;
            case RECEIVED:
                tgt.setValue(org.hl7.fhir.r5.model.Task.TaskStatus.RECEIVED);
                break;
            case ACCEPTED:
                tgt.setValue(org.hl7.fhir.r5.model.Task.TaskStatus.ACCEPTED);
                break;
            case REJECTED:
                tgt.setValue(org.hl7.fhir.r5.model.Task.TaskStatus.REJECTED);
                break;
            case READY:
                tgt.setValue(org.hl7.fhir.r5.model.Task.TaskStatus.READY);
                break;
            case CANCELLED:
                tgt.setValue(org.hl7.fhir.r5.model.Task.TaskStatus.CANCELLED);
                break;
            case INPROGRESS:
                tgt.setValue(org.hl7.fhir.r5.model.Task.TaskStatus.INPROGRESS);
                break;
            case ONHOLD:
                tgt.setValue(org.hl7.fhir.r5.model.Task.TaskStatus.ONHOLD);
                break;
            case FAILED:
                tgt.setValue(org.hl7.fhir.r5.model.Task.TaskStatus.FAILED);
                break;
            case COMPLETED:
                tgt.setValue(org.hl7.fhir.r5.model.Task.TaskStatus.COMPLETED);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.r5.model.Task.TaskStatus.ENTEREDINERROR);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Task.TaskStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Task.TaskStatus> convertTaskStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Task.TaskStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Task.TaskStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Task.TaskStatusEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
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
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Task.TaskIntent> convertTaskIntent(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Task.TaskIntent> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Task.TaskIntent> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Task.TaskIntentEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case UNKNOWN:
                tgt.setValue(org.hl7.fhir.r5.model.Task.TaskIntent.UNKNOWN);
                break;
            case PROPOSAL:
                tgt.setValue(org.hl7.fhir.r5.model.Task.TaskIntent.PROPOSAL);
                break;
            case PLAN:
                tgt.setValue(org.hl7.fhir.r5.model.Task.TaskIntent.PLAN);
                break;
            case ORDER:
                tgt.setValue(org.hl7.fhir.r5.model.Task.TaskIntent.ORDER);
                break;
            case ORIGINALORDER:
                tgt.setValue(org.hl7.fhir.r5.model.Task.TaskIntent.ORIGINALORDER);
                break;
            case REFLEXORDER:
                tgt.setValue(org.hl7.fhir.r5.model.Task.TaskIntent.REFLEXORDER);
                break;
            case FILLERORDER:
                tgt.setValue(org.hl7.fhir.r5.model.Task.TaskIntent.FILLERORDER);
                break;
            case INSTANCEORDER:
                tgt.setValue(org.hl7.fhir.r5.model.Task.TaskIntent.INSTANCEORDER);
                break;
            case OPTION:
                tgt.setValue(org.hl7.fhir.r5.model.Task.TaskIntent.OPTION);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Task.TaskIntent.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Task.TaskIntent> convertTaskIntent(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Task.TaskIntent> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Task.TaskIntent> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Task.TaskIntentEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
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
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestPriority> convertTaskPriority(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Task.TaskPriority> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestPriority> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.RequestPriorityEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case ROUTINE:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestPriority.ROUTINE);
                break;
            case URGENT:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestPriority.URGENT);
                break;
            case ASAP:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestPriority.ASAP);
                break;
            case STAT:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestPriority.STAT);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestPriority.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Task.TaskPriority> convertTaskPriority(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestPriority> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Task.TaskPriority> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Task.TaskPriorityEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
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
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Task.TaskRestrictionComponent convertTaskRestrictionComponent(org.hl7.fhir.r4.model.Task.TaskRestrictionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Task.TaskRestrictionComponent tgt = new org.hl7.fhir.r5.model.Task.TaskRestrictionComponent();
        copyElement(src, tgt);
        if (src.hasRepetitions())
            tgt.setRepetitionsElement(convertPositiveInt(src.getRepetitionsElement()));
        if (src.hasPeriod())
            tgt.setPeriod(convertPeriod(src.getPeriod()));
        for (org.hl7.fhir.r4.model.Reference t : src.getRecipient()) tgt.addRecipient(convertReference(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Task.TaskRestrictionComponent convertTaskRestrictionComponent(org.hl7.fhir.r5.model.Task.TaskRestrictionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Task.TaskRestrictionComponent tgt = new org.hl7.fhir.r4.model.Task.TaskRestrictionComponent();
        copyElement(src, tgt);
        if (src.hasRepetitions())
            tgt.setRepetitionsElement(convertPositiveInt(src.getRepetitionsElement()));
        if (src.hasPeriod())
            tgt.setPeriod(convertPeriod(src.getPeriod()));
        for (org.hl7.fhir.r5.model.Reference t : src.getRecipient()) tgt.addRecipient(convertReference(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Task.ParameterComponent convertParameterComponent(org.hl7.fhir.r4.model.Task.ParameterComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Task.ParameterComponent tgt = new org.hl7.fhir.r5.model.Task.ParameterComponent();
        copyElement(src, tgt);
        if (src.hasType())
            tgt.setType(convertCodeableConcept(src.getType()));
        if (src.hasValue())
            tgt.setValue(convertType(src.getValue()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Task.ParameterComponent convertParameterComponent(org.hl7.fhir.r5.model.Task.ParameterComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Task.ParameterComponent tgt = new org.hl7.fhir.r4.model.Task.ParameterComponent();
        copyElement(src, tgt);
        if (src.hasType())
            tgt.setType(convertCodeableConcept(src.getType()));
        if (src.hasValue())
            tgt.setValue(convertType(src.getValue()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Task.TaskOutputComponent convertTaskOutputComponent(org.hl7.fhir.r4.model.Task.TaskOutputComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Task.TaskOutputComponent tgt = new org.hl7.fhir.r5.model.Task.TaskOutputComponent();
        copyElement(src, tgt);
        if (src.hasType())
            tgt.setType(convertCodeableConcept(src.getType()));
        if (src.hasValue())
            tgt.setValue(convertType(src.getValue()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Task.TaskOutputComponent convertTaskOutputComponent(org.hl7.fhir.r5.model.Task.TaskOutputComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Task.TaskOutputComponent tgt = new org.hl7.fhir.r4.model.Task.TaskOutputComponent();
        copyElement(src, tgt);
        if (src.hasType())
            tgt.setType(convertCodeableConcept(src.getType()));
        if (src.hasValue())
            tgt.setValue(convertType(src.getValue()));
        return tgt;
    }
}