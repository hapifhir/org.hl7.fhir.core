package org.hl7.fhir.convertors.conv40_50;


import org.hl7.fhir.convertors.VersionConvertor_40_50;
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
public class RequestGroup40_50 extends VersionConvertor_40_50 {

    public static org.hl7.fhir.r5.model.RequestGroup convertRequestGroup(org.hl7.fhir.r4.model.RequestGroup src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.RequestGroup tgt = new org.hl7.fhir.r5.model.RequestGroup();
        copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        for (org.hl7.fhir.r4.model.CanonicalType t : src.getInstantiatesCanonical()) tgt.getInstantiatesCanonical().add(convertCanonical(t));
        for (org.hl7.fhir.r4.model.UriType t : src.getInstantiatesUri()) tgt.getInstantiatesUri().add(convertUri(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getBasedOn()) tgt.addBasedOn(convertReference(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getReplaces()) tgt.addReplaces(convertReference(t));
        if (src.hasGroupIdentifier())
            tgt.setGroupIdentifier(convertIdentifier(src.getGroupIdentifier()));
        if (src.hasStatus())
            tgt.setStatusElement(convertRequestStatus(src.getStatusElement()));
        if (src.hasIntent())
            tgt.setIntentElement(convertRequestIntent(src.getIntentElement()));
        if (src.hasPriority())
            tgt.setPriorityElement(convertRequestPriority(src.getPriorityElement()));
        if (src.hasCode())
            tgt.setCode(convertCodeableConcept(src.getCode()));
        if (src.hasSubject())
            tgt.setSubject(convertReference(src.getSubject()));
        if (src.hasEncounter())
            tgt.setEncounter(convertReference(src.getEncounter()));
        if (src.hasAuthoredOn())
            tgt.setAuthoredOnElement(convertDateTime(src.getAuthoredOnElement()));
        if (src.hasAuthor())
            tgt.setAuthor(convertReference(src.getAuthor()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReasonCode()) tgt.addReason(convertCodeableConceptToCodeableReference(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getReasonReference()) tgt.addReason(convertReferenceToCodeableReference(t));
        for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.addNote(convertAnnotation(t));
        for (org.hl7.fhir.r4.model.RequestGroup.RequestGroupActionComponent t : src.getAction()) tgt.addAction(convertRequestGroupActionComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.RequestGroup convertRequestGroup(org.hl7.fhir.r5.model.RequestGroup src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.RequestGroup tgt = new org.hl7.fhir.r4.model.RequestGroup();
        copyDomainResource(src, tgt);
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        for (org.hl7.fhir.r5.model.CanonicalType t : src.getInstantiatesCanonical()) tgt.getInstantiatesCanonical().add(convertCanonical(t));
        for (org.hl7.fhir.r5.model.UriType t : src.getInstantiatesUri()) tgt.getInstantiatesUri().add(convertUri(t));
        for (org.hl7.fhir.r5.model.Reference t : src.getBasedOn()) tgt.addBasedOn(convertReference(t));
        for (org.hl7.fhir.r5.model.Reference t : src.getReplaces()) tgt.addReplaces(convertReference(t));
        if (src.hasGroupIdentifier())
            tgt.setGroupIdentifier(convertIdentifier(src.getGroupIdentifier()));
        if (src.hasStatus())
            tgt.setStatusElement(convertRequestStatus(src.getStatusElement()));
        if (src.hasIntent())
            tgt.setIntentElement(convertRequestIntent(src.getIntentElement()));
        if (src.hasPriority())
            tgt.setPriorityElement(convertRequestPriority(src.getPriorityElement()));
        if (src.hasCode())
            tgt.setCode(convertCodeableConcept(src.getCode()));
        if (src.hasSubject())
            tgt.setSubject(convertReference(src.getSubject()));
        if (src.hasEncounter())
            tgt.setEncounter(convertReference(src.getEncounter()));
        if (src.hasAuthoredOn())
            tgt.setAuthoredOnElement(convertDateTime(src.getAuthoredOnElement()));
        if (src.hasAuthor())
            tgt.setAuthor(convertReference(src.getAuthor()));
        for (CodeableReference t : src.getReason()) if (t.hasConcept())
            tgt.addReasonCode(convertCodeableConcept(t.getConcept()));
        for (CodeableReference t : src.getReason()) if (t.hasReference())
            tgt.addReasonReference(convertReference(t.getReference()));
        for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.addNote(convertAnnotation(t));
        for (org.hl7.fhir.r5.model.RequestGroup.RequestGroupActionComponent t : src.getAction()) tgt.addAction(convertRequestGroupActionComponent(t));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestStatus> convertRequestStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.RequestGroup.RequestStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.RequestStatusEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case DRAFT:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestStatus.DRAFT);
                break;
            case ACTIVE:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestStatus.ACTIVE);
                break;
            case ONHOLD:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestStatus.ONHOLD);
                break;
            case REVOKED:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestStatus.REVOKED);
                break;
            case COMPLETED:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestStatus.COMPLETED);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestStatus.ENTEREDINERROR);
                break;
            case UNKNOWN:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestStatus.UNKNOWN);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.RequestGroup.RequestStatus> convertRequestStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.RequestGroup.RequestStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.RequestGroup.RequestStatusEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case DRAFT:
                tgt.setValue(org.hl7.fhir.r4.model.RequestGroup.RequestStatus.DRAFT);
                break;
            case ACTIVE:
                tgt.setValue(org.hl7.fhir.r4.model.RequestGroup.RequestStatus.ACTIVE);
                break;
            case ONHOLD:
                tgt.setValue(org.hl7.fhir.r4.model.RequestGroup.RequestStatus.ONHOLD);
                break;
            case REVOKED:
                tgt.setValue(org.hl7.fhir.r4.model.RequestGroup.RequestStatus.REVOKED);
                break;
            case COMPLETED:
                tgt.setValue(org.hl7.fhir.r4.model.RequestGroup.RequestStatus.COMPLETED);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.r4.model.RequestGroup.RequestStatus.ENTEREDINERROR);
                break;
            case UNKNOWN:
                tgt.setValue(org.hl7.fhir.r4.model.RequestGroup.RequestStatus.UNKNOWN);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.RequestGroup.RequestStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestIntent> convertRequestIntent(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.RequestGroup.RequestIntent> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestIntent> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.RequestIntentEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case PROPOSAL:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestIntent.PROPOSAL);
                break;
            case PLAN:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestIntent.PLAN);
                break;
            case DIRECTIVE:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestIntent.DIRECTIVE);
                break;
            case ORDER:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestIntent.ORDER);
                break;
            case ORIGINALORDER:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestIntent.ORIGINALORDER);
                break;
            case REFLEXORDER:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestIntent.REFLEXORDER);
                break;
            case FILLERORDER:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestIntent.FILLERORDER);
                break;
            case INSTANCEORDER:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestIntent.INSTANCEORDER);
                break;
            case OPTION:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestIntent.OPTION);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestIntent.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.RequestGroup.RequestIntent> convertRequestIntent(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestIntent> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.RequestGroup.RequestIntent> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.RequestGroup.RequestIntentEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case PROPOSAL:
                tgt.setValue(org.hl7.fhir.r4.model.RequestGroup.RequestIntent.PROPOSAL);
                break;
            case PLAN:
                tgt.setValue(org.hl7.fhir.r4.model.RequestGroup.RequestIntent.PLAN);
                break;
            case DIRECTIVE:
                tgt.setValue(org.hl7.fhir.r4.model.RequestGroup.RequestIntent.DIRECTIVE);
                break;
            case ORDER:
                tgt.setValue(org.hl7.fhir.r4.model.RequestGroup.RequestIntent.ORDER);
                break;
            case ORIGINALORDER:
                tgt.setValue(org.hl7.fhir.r4.model.RequestGroup.RequestIntent.ORIGINALORDER);
                break;
            case REFLEXORDER:
                tgt.setValue(org.hl7.fhir.r4.model.RequestGroup.RequestIntent.REFLEXORDER);
                break;
            case FILLERORDER:
                tgt.setValue(org.hl7.fhir.r4.model.RequestGroup.RequestIntent.FILLERORDER);
                break;
            case INSTANCEORDER:
                tgt.setValue(org.hl7.fhir.r4.model.RequestGroup.RequestIntent.INSTANCEORDER);
                break;
            case OPTION:
                tgt.setValue(org.hl7.fhir.r4.model.RequestGroup.RequestIntent.OPTION);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.RequestGroup.RequestIntent.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestPriority> convertRequestPriority(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.RequestGroup.RequestPriority> src) throws FHIRException {
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

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.RequestGroup.RequestPriority> convertRequestPriority(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestPriority> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.RequestGroup.RequestPriority> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.RequestGroup.RequestPriorityEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case ROUTINE:
                tgt.setValue(org.hl7.fhir.r4.model.RequestGroup.RequestPriority.ROUTINE);
                break;
            case URGENT:
                tgt.setValue(org.hl7.fhir.r4.model.RequestGroup.RequestPriority.URGENT);
                break;
            case ASAP:
                tgt.setValue(org.hl7.fhir.r4.model.RequestGroup.RequestPriority.ASAP);
                break;
            case STAT:
                tgt.setValue(org.hl7.fhir.r4.model.RequestGroup.RequestPriority.STAT);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.RequestGroup.RequestPriority.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.RequestGroup.RequestGroupActionComponent convertRequestGroupActionComponent(org.hl7.fhir.r4.model.RequestGroup.RequestGroupActionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.RequestGroup.RequestGroupActionComponent tgt = new org.hl7.fhir.r5.model.RequestGroup.RequestGroupActionComponent();
        copyElement(src, tgt);
        if (src.hasPrefix())
            tgt.setPrefixElement(convertString(src.getPrefixElement()));
        if (src.hasTitle())
            tgt.setTitleElement(convertString(src.getTitleElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        if (src.hasTextEquivalent())
            tgt.setTextEquivalentElement(convertString(src.getTextEquivalentElement()));
        if (src.hasPriority())
            tgt.setPriorityElement(convertRequestPriority(src.getPriorityElement()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCode()) tgt.addCode(convertCodeableConcept(t));
        for (org.hl7.fhir.r4.model.RelatedArtifact t : src.getDocumentation()) tgt.addDocumentation(convertRelatedArtifact(t));
        for (org.hl7.fhir.r4.model.RequestGroup.RequestGroupActionConditionComponent t : src.getCondition()) tgt.addCondition(convertRequestGroupActionConditionComponent(t));
        for (org.hl7.fhir.r4.model.RequestGroup.RequestGroupActionRelatedActionComponent t : src.getRelatedAction()) tgt.addRelatedAction(convertRequestGroupActionRelatedActionComponent(t));
        if (src.hasTiming())
            tgt.setTiming(convertType(src.getTiming()));
        for (org.hl7.fhir.r4.model.Reference t : src.getParticipant()) tgt.addParticipant(convertReference(t));
        if (src.hasType())
            tgt.setType(convertCodeableConcept(src.getType()));
        if (src.hasGroupingBehavior())
            tgt.setGroupingBehaviorElement(convertActionGroupingBehavior(src.getGroupingBehaviorElement()));
        if (src.hasSelectionBehavior())
            tgt.setSelectionBehaviorElement(convertActionSelectionBehavior(src.getSelectionBehaviorElement()));
        if (src.hasRequiredBehavior())
            tgt.setRequiredBehaviorElement(convertActionRequiredBehavior(src.getRequiredBehaviorElement()));
        if (src.hasPrecheckBehavior())
            tgt.setPrecheckBehaviorElement(convertActionPrecheckBehavior(src.getPrecheckBehaviorElement()));
        if (src.hasCardinalityBehavior())
            tgt.setCardinalityBehaviorElement(convertActionCardinalityBehavior(src.getCardinalityBehaviorElement()));
        if (src.hasResource())
            tgt.setResource(convertReference(src.getResource()));
        for (org.hl7.fhir.r4.model.RequestGroup.RequestGroupActionComponent t : src.getAction()) tgt.addAction(convertRequestGroupActionComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.RequestGroup.RequestGroupActionComponent convertRequestGroupActionComponent(org.hl7.fhir.r5.model.RequestGroup.RequestGroupActionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.RequestGroup.RequestGroupActionComponent tgt = new org.hl7.fhir.r4.model.RequestGroup.RequestGroupActionComponent();
        copyElement(src, tgt);
        if (src.hasPrefix())
            tgt.setPrefixElement(convertString(src.getPrefixElement()));
        if (src.hasTitle())
            tgt.setTitleElement(convertString(src.getTitleElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        if (src.hasTextEquivalent())
            tgt.setTextEquivalentElement(convertString(src.getTextEquivalentElement()));
        if (src.hasPriority())
            tgt.setPriorityElement(convertRequestPriority(src.getPriorityElement()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCode()) tgt.addCode(convertCodeableConcept(t));
        for (org.hl7.fhir.r5.model.RelatedArtifact t : src.getDocumentation()) tgt.addDocumentation(convertRelatedArtifact(t));
        for (org.hl7.fhir.r5.model.RequestGroup.RequestGroupActionConditionComponent t : src.getCondition()) tgt.addCondition(convertRequestGroupActionConditionComponent(t));
        for (org.hl7.fhir.r5.model.RequestGroup.RequestGroupActionRelatedActionComponent t : src.getRelatedAction()) tgt.addRelatedAction(convertRequestGroupActionRelatedActionComponent(t));
        if (src.hasTiming())
            tgt.setTiming(convertType(src.getTiming()));
        for (org.hl7.fhir.r5.model.Reference t : src.getParticipant()) tgt.addParticipant(convertReference(t));
        if (src.hasType())
            tgt.setType(convertCodeableConcept(src.getType()));
        if (src.hasGroupingBehavior())
            tgt.setGroupingBehaviorElement(convertActionGroupingBehavior(src.getGroupingBehaviorElement()));
        if (src.hasSelectionBehavior())
            tgt.setSelectionBehaviorElement(convertActionSelectionBehavior(src.getSelectionBehaviorElement()));
        if (src.hasRequiredBehavior())
            tgt.setRequiredBehaviorElement(convertActionRequiredBehavior(src.getRequiredBehaviorElement()));
        if (src.hasPrecheckBehavior())
            tgt.setPrecheckBehaviorElement(convertActionPrecheckBehavior(src.getPrecheckBehaviorElement()));
        if (src.hasCardinalityBehavior())
            tgt.setCardinalityBehaviorElement(convertActionCardinalityBehavior(src.getCardinalityBehaviorElement()));
        if (src.hasResource())
            tgt.setResource(convertReference(src.getResource()));
        for (org.hl7.fhir.r5.model.RequestGroup.RequestGroupActionComponent t : src.getAction()) tgt.addAction(convertRequestGroupActionComponent(t));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionGroupingBehavior> convertActionGroupingBehavior(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.RequestGroup.ActionGroupingBehavior> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionGroupingBehavior> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.ActionGroupingBehaviorEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case VISUALGROUP:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionGroupingBehavior.VISUALGROUP);
                break;
            case LOGICALGROUP:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionGroupingBehavior.LOGICALGROUP);
                break;
            case SENTENCEGROUP:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionGroupingBehavior.SENTENCEGROUP);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionGroupingBehavior.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.RequestGroup.ActionGroupingBehavior> convertActionGroupingBehavior(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionGroupingBehavior> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.RequestGroup.ActionGroupingBehavior> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.RequestGroup.ActionGroupingBehaviorEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case VISUALGROUP:
                tgt.setValue(org.hl7.fhir.r4.model.RequestGroup.ActionGroupingBehavior.VISUALGROUP);
                break;
            case LOGICALGROUP:
                tgt.setValue(org.hl7.fhir.r4.model.RequestGroup.ActionGroupingBehavior.LOGICALGROUP);
                break;
            case SENTENCEGROUP:
                tgt.setValue(org.hl7.fhir.r4.model.RequestGroup.ActionGroupingBehavior.SENTENCEGROUP);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.RequestGroup.ActionGroupingBehavior.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionSelectionBehavior> convertActionSelectionBehavior(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.RequestGroup.ActionSelectionBehavior> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionSelectionBehavior> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.ActionSelectionBehaviorEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case ANY:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionSelectionBehavior.ANY);
                break;
            case ALL:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionSelectionBehavior.ALL);
                break;
            case ALLORNONE:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionSelectionBehavior.ALLORNONE);
                break;
            case EXACTLYONE:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionSelectionBehavior.EXACTLYONE);
                break;
            case ATMOSTONE:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionSelectionBehavior.ATMOSTONE);
                break;
            case ONEORMORE:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionSelectionBehavior.ONEORMORE);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionSelectionBehavior.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.RequestGroup.ActionSelectionBehavior> convertActionSelectionBehavior(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionSelectionBehavior> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.RequestGroup.ActionSelectionBehavior> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.RequestGroup.ActionSelectionBehaviorEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case ANY:
                tgt.setValue(org.hl7.fhir.r4.model.RequestGroup.ActionSelectionBehavior.ANY);
                break;
            case ALL:
                tgt.setValue(org.hl7.fhir.r4.model.RequestGroup.ActionSelectionBehavior.ALL);
                break;
            case ALLORNONE:
                tgt.setValue(org.hl7.fhir.r4.model.RequestGroup.ActionSelectionBehavior.ALLORNONE);
                break;
            case EXACTLYONE:
                tgt.setValue(org.hl7.fhir.r4.model.RequestGroup.ActionSelectionBehavior.EXACTLYONE);
                break;
            case ATMOSTONE:
                tgt.setValue(org.hl7.fhir.r4.model.RequestGroup.ActionSelectionBehavior.ATMOSTONE);
                break;
            case ONEORMORE:
                tgt.setValue(org.hl7.fhir.r4.model.RequestGroup.ActionSelectionBehavior.ONEORMORE);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.RequestGroup.ActionSelectionBehavior.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionRequiredBehavior> convertActionRequiredBehavior(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.RequestGroup.ActionRequiredBehavior> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionRequiredBehavior> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.ActionRequiredBehaviorEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case MUST:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionRequiredBehavior.MUST);
                break;
            case COULD:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionRequiredBehavior.COULD);
                break;
            case MUSTUNLESSDOCUMENTED:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionRequiredBehavior.MUSTUNLESSDOCUMENTED);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionRequiredBehavior.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.RequestGroup.ActionRequiredBehavior> convertActionRequiredBehavior(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionRequiredBehavior> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.RequestGroup.ActionRequiredBehavior> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.RequestGroup.ActionRequiredBehaviorEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case MUST:
                tgt.setValue(org.hl7.fhir.r4.model.RequestGroup.ActionRequiredBehavior.MUST);
                break;
            case COULD:
                tgt.setValue(org.hl7.fhir.r4.model.RequestGroup.ActionRequiredBehavior.COULD);
                break;
            case MUSTUNLESSDOCUMENTED:
                tgt.setValue(org.hl7.fhir.r4.model.RequestGroup.ActionRequiredBehavior.MUSTUNLESSDOCUMENTED);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.RequestGroup.ActionRequiredBehavior.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionPrecheckBehavior> convertActionPrecheckBehavior(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.RequestGroup.ActionPrecheckBehavior> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionPrecheckBehavior> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.ActionPrecheckBehaviorEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case YES:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionPrecheckBehavior.YES);
                break;
            case NO:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionPrecheckBehavior.NO);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionPrecheckBehavior.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.RequestGroup.ActionPrecheckBehavior> convertActionPrecheckBehavior(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionPrecheckBehavior> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.RequestGroup.ActionPrecheckBehavior> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.RequestGroup.ActionPrecheckBehaviorEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case YES:
                tgt.setValue(org.hl7.fhir.r4.model.RequestGroup.ActionPrecheckBehavior.YES);
                break;
            case NO:
                tgt.setValue(org.hl7.fhir.r4.model.RequestGroup.ActionPrecheckBehavior.NO);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.RequestGroup.ActionPrecheckBehavior.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionCardinalityBehavior> convertActionCardinalityBehavior(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.RequestGroup.ActionCardinalityBehavior> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionCardinalityBehavior> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.ActionCardinalityBehaviorEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case SINGLE:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionCardinalityBehavior.SINGLE);
                break;
            case MULTIPLE:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionCardinalityBehavior.MULTIPLE);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionCardinalityBehavior.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.RequestGroup.ActionCardinalityBehavior> convertActionCardinalityBehavior(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionCardinalityBehavior> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.RequestGroup.ActionCardinalityBehavior> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.RequestGroup.ActionCardinalityBehaviorEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case SINGLE:
                tgt.setValue(org.hl7.fhir.r4.model.RequestGroup.ActionCardinalityBehavior.SINGLE);
                break;
            case MULTIPLE:
                tgt.setValue(org.hl7.fhir.r4.model.RequestGroup.ActionCardinalityBehavior.MULTIPLE);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.RequestGroup.ActionCardinalityBehavior.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.RequestGroup.RequestGroupActionConditionComponent convertRequestGroupActionConditionComponent(org.hl7.fhir.r4.model.RequestGroup.RequestGroupActionConditionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.RequestGroup.RequestGroupActionConditionComponent tgt = new org.hl7.fhir.r5.model.RequestGroup.RequestGroupActionConditionComponent();
        copyElement(src, tgt);
        if (src.hasKind())
            tgt.setKindElement(convertActionConditionKind(src.getKindElement()));
        if (src.hasExpression())
            tgt.setExpression(convertExpression(src.getExpression()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.RequestGroup.RequestGroupActionConditionComponent convertRequestGroupActionConditionComponent(org.hl7.fhir.r5.model.RequestGroup.RequestGroupActionConditionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.RequestGroup.RequestGroupActionConditionComponent tgt = new org.hl7.fhir.r4.model.RequestGroup.RequestGroupActionConditionComponent();
        copyElement(src, tgt);
        if (src.hasKind())
            tgt.setKindElement(convertActionConditionKind(src.getKindElement()));
        if (src.hasExpression())
            tgt.setExpression(convertExpression(src.getExpression()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionConditionKind> convertActionConditionKind(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.RequestGroup.ActionConditionKind> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionConditionKind> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.ActionConditionKindEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case APPLICABILITY:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionConditionKind.APPLICABILITY);
                break;
            case START:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionConditionKind.START);
                break;
            case STOP:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionConditionKind.STOP);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionConditionKind.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.RequestGroup.ActionConditionKind> convertActionConditionKind(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionConditionKind> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.RequestGroup.ActionConditionKind> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.RequestGroup.ActionConditionKindEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case APPLICABILITY:
                tgt.setValue(org.hl7.fhir.r4.model.RequestGroup.ActionConditionKind.APPLICABILITY);
                break;
            case START:
                tgt.setValue(org.hl7.fhir.r4.model.RequestGroup.ActionConditionKind.START);
                break;
            case STOP:
                tgt.setValue(org.hl7.fhir.r4.model.RequestGroup.ActionConditionKind.STOP);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.RequestGroup.ActionConditionKind.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.RequestGroup.RequestGroupActionRelatedActionComponent convertRequestGroupActionRelatedActionComponent(org.hl7.fhir.r4.model.RequestGroup.RequestGroupActionRelatedActionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.RequestGroup.RequestGroupActionRelatedActionComponent tgt = new org.hl7.fhir.r5.model.RequestGroup.RequestGroupActionRelatedActionComponent();
        copyElement(src, tgt);
        if (src.hasActionId())
            tgt.setActionIdElement(convertId(src.getActionIdElement()));
        if (src.hasRelationship())
            tgt.setRelationshipElement(convertActionRelationshipType(src.getRelationshipElement()));
        if (src.hasOffset())
            tgt.setOffset(convertType(src.getOffset()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.RequestGroup.RequestGroupActionRelatedActionComponent convertRequestGroupActionRelatedActionComponent(org.hl7.fhir.r5.model.RequestGroup.RequestGroupActionRelatedActionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.RequestGroup.RequestGroupActionRelatedActionComponent tgt = new org.hl7.fhir.r4.model.RequestGroup.RequestGroupActionRelatedActionComponent();
        copyElement(src, tgt);
        if (src.hasActionId())
            tgt.setActionIdElement(convertId(src.getActionIdElement()));
        if (src.hasRelationship())
            tgt.setRelationshipElement(convertActionRelationshipType(src.getRelationshipElement()));
        if (src.hasOffset())
            tgt.setOffset(convertType(src.getOffset()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionRelationshipType> convertActionRelationshipType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.RequestGroup.ActionRelationshipType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionRelationshipType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.ActionRelationshipTypeEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case BEFORESTART:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionRelationshipType.BEFORESTART);
                break;
            case BEFORE:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionRelationshipType.BEFORE);
                break;
            case BEFOREEND:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionRelationshipType.BEFOREEND);
                break;
            case CONCURRENTWITHSTART:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionRelationshipType.CONCURRENTWITHSTART);
                break;
            case CONCURRENT:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionRelationshipType.CONCURRENT);
                break;
            case CONCURRENTWITHEND:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionRelationshipType.CONCURRENTWITHEND);
                break;
            case AFTERSTART:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionRelationshipType.AFTERSTART);
                break;
            case AFTER:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionRelationshipType.AFTER);
                break;
            case AFTEREND:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionRelationshipType.AFTEREND);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionRelationshipType.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.RequestGroup.ActionRelationshipType> convertActionRelationshipType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionRelationshipType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.RequestGroup.ActionRelationshipType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.RequestGroup.ActionRelationshipTypeEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case BEFORESTART:
                tgt.setValue(org.hl7.fhir.r4.model.RequestGroup.ActionRelationshipType.BEFORESTART);
                break;
            case BEFORE:
                tgt.setValue(org.hl7.fhir.r4.model.RequestGroup.ActionRelationshipType.BEFORE);
                break;
            case BEFOREEND:
                tgt.setValue(org.hl7.fhir.r4.model.RequestGroup.ActionRelationshipType.BEFOREEND);
                break;
            case CONCURRENTWITHSTART:
                tgt.setValue(org.hl7.fhir.r4.model.RequestGroup.ActionRelationshipType.CONCURRENTWITHSTART);
                break;
            case CONCURRENT:
                tgt.setValue(org.hl7.fhir.r4.model.RequestGroup.ActionRelationshipType.CONCURRENT);
                break;
            case CONCURRENTWITHEND:
                tgt.setValue(org.hl7.fhir.r4.model.RequestGroup.ActionRelationshipType.CONCURRENTWITHEND);
                break;
            case AFTERSTART:
                tgt.setValue(org.hl7.fhir.r4.model.RequestGroup.ActionRelationshipType.AFTERSTART);
                break;
            case AFTER:
                tgt.setValue(org.hl7.fhir.r4.model.RequestGroup.ActionRelationshipType.AFTER);
                break;
            case AFTEREND:
                tgt.setValue(org.hl7.fhir.r4.model.RequestGroup.ActionRelationshipType.AFTEREND);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.RequestGroup.ActionRelationshipType.NULL);
                break;
        }
        return tgt;
    }
}