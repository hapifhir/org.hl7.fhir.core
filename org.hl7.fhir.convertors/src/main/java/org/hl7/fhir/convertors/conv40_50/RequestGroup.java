package org.hl7.fhir.convertors.conv40_50;

import org.hl7.fhir.exceptions.FHIRException;

import org.hl7.fhir.convertors.VersionConvertor_40_50;


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


public class RequestGroup extends VersionConvertor_40_50 {

  public static org.hl7.fhir.r5.model.RequestGroup convertRequestGroup(org.hl7.fhir.r4.model.RequestGroup src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.RequestGroup tgt = new org.hl7.fhir.r5.model.RequestGroup();
    copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    for (org.hl7.fhir.r4.model.CanonicalType t : src.getInstantiatesCanonical())
      tgt.getInstantiatesCanonical().add(convertCanonical(t));
    for (org.hl7.fhir.r4.model.UriType t : src.getInstantiatesUri())
      tgt.getInstantiatesUri().add(convertUri(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getBasedOn())
      tgt.addBasedOn(convertReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getReplaces())
      tgt.addReplaces(convertReference(t));
    if (src.hasGroupIdentifier())
      tgt.setGroupIdentifier(convertIdentifier(src.getGroupIdentifier()));
    if (src.hasStatus())
      tgt.setStatus(convertRequestStatus(src.getStatus()));
    if (src.hasIntent())
      tgt.setIntent(convertRequestIntent(src.getIntent()));
    if (src.hasPriority())
      tgt.setPriority(convertRequestPriority(src.getPriority()));
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
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReasonCode())
      tgt.addReasonCode(convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getReasonReference())
      tgt.addReasonReference(convertReference(t));
    for (org.hl7.fhir.r4.model.Annotation t : src.getNote())
      tgt.addNote(convertAnnotation(t));
    for (org.hl7.fhir.r4.model.RequestGroup.RequestGroupActionComponent t : src.getAction())
      tgt.addAction(convertRequestGroupActionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.RequestGroup convertRequestGroup(org.hl7.fhir.r5.model.RequestGroup src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.RequestGroup tgt = new org.hl7.fhir.r4.model.RequestGroup();
    copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    for (org.hl7.fhir.r5.model.CanonicalType t : src.getInstantiatesCanonical())
      tgt.getInstantiatesCanonical().add(convertCanonical(t));
    for (org.hl7.fhir.r5.model.UriType t : src.getInstantiatesUri())
      tgt.getInstantiatesUri().add(convertUri(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getBasedOn())
      tgt.addBasedOn(convertReference(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getReplaces())
      tgt.addReplaces(convertReference(t));
    if (src.hasGroupIdentifier())
      tgt.setGroupIdentifier(convertIdentifier(src.getGroupIdentifier()));
    if (src.hasStatus())
      tgt.setStatus(convertRequestStatus(src.getStatus()));
    if (src.hasIntent())
      tgt.setIntent(convertRequestIntent(src.getIntent()));
    if (src.hasPriority())
      tgt.setPriority(convertRequestPriority(src.getPriority()));
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
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getReasonCode())
      tgt.addReasonCode(convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getReasonReference())
      tgt.addReasonReference(convertReference(t));
    for (org.hl7.fhir.r5.model.Annotation t : src.getNote())
      tgt.addNote(convertAnnotation(t));
    for (org.hl7.fhir.r5.model.RequestGroup.RequestGroupActionComponent t : src.getAction())
      tgt.addAction(convertRequestGroupActionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.RequestGroup.RequestStatus convertRequestStatus(org.hl7.fhir.r4.model.RequestGroup.RequestStatus src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case DRAFT: return org.hl7.fhir.r5.model.RequestGroup.RequestStatus.DRAFT;
    case ACTIVE: return org.hl7.fhir.r5.model.RequestGroup.RequestStatus.ACTIVE;
    case ONHOLD: return org.hl7.fhir.r5.model.RequestGroup.RequestStatus.ONHOLD;
    case REVOKED: return org.hl7.fhir.r5.model.RequestGroup.RequestStatus.REVOKED;
    case COMPLETED: return org.hl7.fhir.r5.model.RequestGroup.RequestStatus.COMPLETED;
    case ENTEREDINERROR: return org.hl7.fhir.r5.model.RequestGroup.RequestStatus.ENTEREDINERROR;
    case UNKNOWN: return org.hl7.fhir.r5.model.RequestGroup.RequestStatus.UNKNOWN;
    default: return org.hl7.fhir.r5.model.RequestGroup.RequestStatus.NULL;
  }
}

  public static org.hl7.fhir.r4.model.RequestGroup.RequestStatus convertRequestStatus(org.hl7.fhir.r5.model.RequestGroup.RequestStatus src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case DRAFT: return org.hl7.fhir.r4.model.RequestGroup.RequestStatus.DRAFT;
    case ACTIVE: return org.hl7.fhir.r4.model.RequestGroup.RequestStatus.ACTIVE;
    case ONHOLD: return org.hl7.fhir.r4.model.RequestGroup.RequestStatus.ONHOLD;
    case REVOKED: return org.hl7.fhir.r4.model.RequestGroup.RequestStatus.REVOKED;
    case COMPLETED: return org.hl7.fhir.r4.model.RequestGroup.RequestStatus.COMPLETED;
    case ENTEREDINERROR: return org.hl7.fhir.r4.model.RequestGroup.RequestStatus.ENTEREDINERROR;
    case UNKNOWN: return org.hl7.fhir.r4.model.RequestGroup.RequestStatus.UNKNOWN;
    default: return org.hl7.fhir.r4.model.RequestGroup.RequestStatus.NULL;
  }
}

  public static org.hl7.fhir.r5.model.RequestGroup.RequestIntent convertRequestIntent(org.hl7.fhir.r4.model.RequestGroup.RequestIntent src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case PROPOSAL: return org.hl7.fhir.r5.model.RequestGroup.RequestIntent.PROPOSAL;
    case PLAN: return org.hl7.fhir.r5.model.RequestGroup.RequestIntent.PLAN;
    case DIRECTIVE: return org.hl7.fhir.r5.model.RequestGroup.RequestIntent.DIRECTIVE;
    case ORDER: return org.hl7.fhir.r5.model.RequestGroup.RequestIntent.ORDER;
    case ORIGINALORDER: return org.hl7.fhir.r5.model.RequestGroup.RequestIntent.ORIGINALORDER;
    case REFLEXORDER: return org.hl7.fhir.r5.model.RequestGroup.RequestIntent.REFLEXORDER;
    case FILLERORDER: return org.hl7.fhir.r5.model.RequestGroup.RequestIntent.FILLERORDER;
    case INSTANCEORDER: return org.hl7.fhir.r5.model.RequestGroup.RequestIntent.INSTANCEORDER;
    case OPTION: return org.hl7.fhir.r5.model.RequestGroup.RequestIntent.OPTION;
    default: return org.hl7.fhir.r5.model.RequestGroup.RequestIntent.NULL;
  }
}

  public static org.hl7.fhir.r4.model.RequestGroup.RequestIntent convertRequestIntent(org.hl7.fhir.r5.model.RequestGroup.RequestIntent src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case PROPOSAL: return org.hl7.fhir.r4.model.RequestGroup.RequestIntent.PROPOSAL;
    case PLAN: return org.hl7.fhir.r4.model.RequestGroup.RequestIntent.PLAN;
    case DIRECTIVE: return org.hl7.fhir.r4.model.RequestGroup.RequestIntent.DIRECTIVE;
    case ORDER: return org.hl7.fhir.r4.model.RequestGroup.RequestIntent.ORDER;
    case ORIGINALORDER: return org.hl7.fhir.r4.model.RequestGroup.RequestIntent.ORIGINALORDER;
    case REFLEXORDER: return org.hl7.fhir.r4.model.RequestGroup.RequestIntent.REFLEXORDER;
    case FILLERORDER: return org.hl7.fhir.r4.model.RequestGroup.RequestIntent.FILLERORDER;
    case INSTANCEORDER: return org.hl7.fhir.r4.model.RequestGroup.RequestIntent.INSTANCEORDER;
    case OPTION: return org.hl7.fhir.r4.model.RequestGroup.RequestIntent.OPTION;
    default: return org.hl7.fhir.r4.model.RequestGroup.RequestIntent.NULL;
  }
}

  public static org.hl7.fhir.r5.model.RequestGroup.RequestPriority convertRequestPriority(org.hl7.fhir.r4.model.RequestGroup.RequestPriority src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case ROUTINE: return org.hl7.fhir.r5.model.RequestGroup.RequestPriority.ROUTINE;
    case URGENT: return org.hl7.fhir.r5.model.RequestGroup.RequestPriority.URGENT;
    case ASAP: return org.hl7.fhir.r5.model.RequestGroup.RequestPriority.ASAP;
    case STAT: return org.hl7.fhir.r5.model.RequestGroup.RequestPriority.STAT;
    default: return org.hl7.fhir.r5.model.RequestGroup.RequestPriority.NULL;
  }
}

  public static org.hl7.fhir.r4.model.RequestGroup.RequestPriority convertRequestPriority(org.hl7.fhir.r5.model.RequestGroup.RequestPriority src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case ROUTINE: return org.hl7.fhir.r4.model.RequestGroup.RequestPriority.ROUTINE;
    case URGENT: return org.hl7.fhir.r4.model.RequestGroup.RequestPriority.URGENT;
    case ASAP: return org.hl7.fhir.r4.model.RequestGroup.RequestPriority.ASAP;
    case STAT: return org.hl7.fhir.r4.model.RequestGroup.RequestPriority.STAT;
    default: return org.hl7.fhir.r4.model.RequestGroup.RequestPriority.NULL;
  }
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
      tgt.setPriority(convertRequestPriority(src.getPriority()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCode())
      tgt.addCode(convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.RelatedArtifact t : src.getDocumentation())
      tgt.addDocumentation(convertRelatedArtifact(t));
    for (org.hl7.fhir.r4.model.RequestGroup.RequestGroupActionConditionComponent t : src.getCondition())
      tgt.addCondition(convertRequestGroupActionConditionComponent(t));
    for (org.hl7.fhir.r4.model.RequestGroup.RequestGroupActionRelatedActionComponent t : src.getRelatedAction())
      tgt.addRelatedAction(convertRequestGroupActionRelatedActionComponent(t));
    if (src.hasTiming())
      tgt.setTiming(convertType(src.getTiming()));
    for (org.hl7.fhir.r4.model.Reference t : src.getParticipant())
      tgt.addParticipant(convertReference(t));
    if (src.hasType())
      tgt.setType(convertCodeableConcept(src.getType()));
    if (src.hasGroupingBehavior())
      tgt.setGroupingBehavior(convertActionGroupingBehavior(src.getGroupingBehavior()));
    if (src.hasSelectionBehavior())
      tgt.setSelectionBehavior(convertActionSelectionBehavior(src.getSelectionBehavior()));
    if (src.hasRequiredBehavior())
      tgt.setRequiredBehavior(convertActionRequiredBehavior(src.getRequiredBehavior()));
    if (src.hasPrecheckBehavior())
      tgt.setPrecheckBehavior(convertActionPrecheckBehavior(src.getPrecheckBehavior()));
    if (src.hasCardinalityBehavior())
      tgt.setCardinalityBehavior(convertActionCardinalityBehavior(src.getCardinalityBehavior()));
    if (src.hasResource())
      tgt.setResource(convertReference(src.getResource()));
    for (org.hl7.fhir.r4.model.RequestGroup.RequestGroupActionComponent t : src.getAction())
      tgt.addAction(convertRequestGroupActionComponent(t));
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
      tgt.setPriority(convertRequestPriority(src.getPriority()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCode())
      tgt.addCode(convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.RelatedArtifact t : src.getDocumentation())
      tgt.addDocumentation(convertRelatedArtifact(t));
    for (org.hl7.fhir.r5.model.RequestGroup.RequestGroupActionConditionComponent t : src.getCondition())
      tgt.addCondition(convertRequestGroupActionConditionComponent(t));
    for (org.hl7.fhir.r5.model.RequestGroup.RequestGroupActionRelatedActionComponent t : src.getRelatedAction())
      tgt.addRelatedAction(convertRequestGroupActionRelatedActionComponent(t));
    if (src.hasTiming())
      tgt.setTiming(convertType(src.getTiming()));
    for (org.hl7.fhir.r5.model.Reference t : src.getParticipant())
      tgt.addParticipant(convertReference(t));
    if (src.hasType())
      tgt.setType(convertCodeableConcept(src.getType()));
    if (src.hasGroupingBehavior())
      tgt.setGroupingBehavior(convertActionGroupingBehavior(src.getGroupingBehavior()));
    if (src.hasSelectionBehavior())
      tgt.setSelectionBehavior(convertActionSelectionBehavior(src.getSelectionBehavior()));
    if (src.hasRequiredBehavior())
      tgt.setRequiredBehavior(convertActionRequiredBehavior(src.getRequiredBehavior()));
    if (src.hasPrecheckBehavior())
      tgt.setPrecheckBehavior(convertActionPrecheckBehavior(src.getPrecheckBehavior()));
    if (src.hasCardinalityBehavior())
      tgt.setCardinalityBehavior(convertActionCardinalityBehavior(src.getCardinalityBehavior()));
    if (src.hasResource())
      tgt.setResource(convertReference(src.getResource()));
    for (org.hl7.fhir.r5.model.RequestGroup.RequestGroupActionComponent t : src.getAction())
      tgt.addAction(convertRequestGroupActionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.RequestGroup.ActionGroupingBehavior convertActionGroupingBehavior(org.hl7.fhir.r4.model.RequestGroup.ActionGroupingBehavior src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case VISUALGROUP: return org.hl7.fhir.r5.model.RequestGroup.ActionGroupingBehavior.VISUALGROUP;
    case LOGICALGROUP: return org.hl7.fhir.r5.model.RequestGroup.ActionGroupingBehavior.LOGICALGROUP;
    case SENTENCEGROUP: return org.hl7.fhir.r5.model.RequestGroup.ActionGroupingBehavior.SENTENCEGROUP;
    default: return org.hl7.fhir.r5.model.RequestGroup.ActionGroupingBehavior.NULL;
  }
}

  public static org.hl7.fhir.r4.model.RequestGroup.ActionGroupingBehavior convertActionGroupingBehavior(org.hl7.fhir.r5.model.RequestGroup.ActionGroupingBehavior src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case VISUALGROUP: return org.hl7.fhir.r4.model.RequestGroup.ActionGroupingBehavior.VISUALGROUP;
    case LOGICALGROUP: return org.hl7.fhir.r4.model.RequestGroup.ActionGroupingBehavior.LOGICALGROUP;
    case SENTENCEGROUP: return org.hl7.fhir.r4.model.RequestGroup.ActionGroupingBehavior.SENTENCEGROUP;
    default: return org.hl7.fhir.r4.model.RequestGroup.ActionGroupingBehavior.NULL;
  }
}

  public static org.hl7.fhir.r5.model.RequestGroup.ActionSelectionBehavior convertActionSelectionBehavior(org.hl7.fhir.r4.model.RequestGroup.ActionSelectionBehavior src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case ANY: return org.hl7.fhir.r5.model.RequestGroup.ActionSelectionBehavior.ANY;
    case ALL: return org.hl7.fhir.r5.model.RequestGroup.ActionSelectionBehavior.ALL;
    case ALLORNONE: return org.hl7.fhir.r5.model.RequestGroup.ActionSelectionBehavior.ALLORNONE;
    case EXACTLYONE: return org.hl7.fhir.r5.model.RequestGroup.ActionSelectionBehavior.EXACTLYONE;
    case ATMOSTONE: return org.hl7.fhir.r5.model.RequestGroup.ActionSelectionBehavior.ATMOSTONE;
    case ONEORMORE: return org.hl7.fhir.r5.model.RequestGroup.ActionSelectionBehavior.ONEORMORE;
    default: return org.hl7.fhir.r5.model.RequestGroup.ActionSelectionBehavior.NULL;
  }
}

  public static org.hl7.fhir.r4.model.RequestGroup.ActionSelectionBehavior convertActionSelectionBehavior(org.hl7.fhir.r5.model.RequestGroup.ActionSelectionBehavior src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case ANY: return org.hl7.fhir.r4.model.RequestGroup.ActionSelectionBehavior.ANY;
    case ALL: return org.hl7.fhir.r4.model.RequestGroup.ActionSelectionBehavior.ALL;
    case ALLORNONE: return org.hl7.fhir.r4.model.RequestGroup.ActionSelectionBehavior.ALLORNONE;
    case EXACTLYONE: return org.hl7.fhir.r4.model.RequestGroup.ActionSelectionBehavior.EXACTLYONE;
    case ATMOSTONE: return org.hl7.fhir.r4.model.RequestGroup.ActionSelectionBehavior.ATMOSTONE;
    case ONEORMORE: return org.hl7.fhir.r4.model.RequestGroup.ActionSelectionBehavior.ONEORMORE;
    default: return org.hl7.fhir.r4.model.RequestGroup.ActionSelectionBehavior.NULL;
  }
}

  public static org.hl7.fhir.r5.model.RequestGroup.ActionRequiredBehavior convertActionRequiredBehavior(org.hl7.fhir.r4.model.RequestGroup.ActionRequiredBehavior src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case MUST: return org.hl7.fhir.r5.model.RequestGroup.ActionRequiredBehavior.MUST;
    case COULD: return org.hl7.fhir.r5.model.RequestGroup.ActionRequiredBehavior.COULD;
    case MUSTUNLESSDOCUMENTED: return org.hl7.fhir.r5.model.RequestGroup.ActionRequiredBehavior.MUSTUNLESSDOCUMENTED;
    default: return org.hl7.fhir.r5.model.RequestGroup.ActionRequiredBehavior.NULL;
  }
}

  public static org.hl7.fhir.r4.model.RequestGroup.ActionRequiredBehavior convertActionRequiredBehavior(org.hl7.fhir.r5.model.RequestGroup.ActionRequiredBehavior src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case MUST: return org.hl7.fhir.r4.model.RequestGroup.ActionRequiredBehavior.MUST;
    case COULD: return org.hl7.fhir.r4.model.RequestGroup.ActionRequiredBehavior.COULD;
    case MUSTUNLESSDOCUMENTED: return org.hl7.fhir.r4.model.RequestGroup.ActionRequiredBehavior.MUSTUNLESSDOCUMENTED;
    default: return org.hl7.fhir.r4.model.RequestGroup.ActionRequiredBehavior.NULL;
  }
}

  public static org.hl7.fhir.r5.model.RequestGroup.ActionPrecheckBehavior convertActionPrecheckBehavior(org.hl7.fhir.r4.model.RequestGroup.ActionPrecheckBehavior src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case YES: return org.hl7.fhir.r5.model.RequestGroup.ActionPrecheckBehavior.YES;
    case NO: return org.hl7.fhir.r5.model.RequestGroup.ActionPrecheckBehavior.NO;
    default: return org.hl7.fhir.r5.model.RequestGroup.ActionPrecheckBehavior.NULL;
  }
}

  public static org.hl7.fhir.r4.model.RequestGroup.ActionPrecheckBehavior convertActionPrecheckBehavior(org.hl7.fhir.r5.model.RequestGroup.ActionPrecheckBehavior src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case YES: return org.hl7.fhir.r4.model.RequestGroup.ActionPrecheckBehavior.YES;
    case NO: return org.hl7.fhir.r4.model.RequestGroup.ActionPrecheckBehavior.NO;
    default: return org.hl7.fhir.r4.model.RequestGroup.ActionPrecheckBehavior.NULL;
  }
}

  public static org.hl7.fhir.r5.model.RequestGroup.ActionCardinalityBehavior convertActionCardinalityBehavior(org.hl7.fhir.r4.model.RequestGroup.ActionCardinalityBehavior src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case SINGLE: return org.hl7.fhir.r5.model.RequestGroup.ActionCardinalityBehavior.SINGLE;
    case MULTIPLE: return org.hl7.fhir.r5.model.RequestGroup.ActionCardinalityBehavior.MULTIPLE;
    default: return org.hl7.fhir.r5.model.RequestGroup.ActionCardinalityBehavior.NULL;
  }
}

  public static org.hl7.fhir.r4.model.RequestGroup.ActionCardinalityBehavior convertActionCardinalityBehavior(org.hl7.fhir.r5.model.RequestGroup.ActionCardinalityBehavior src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case SINGLE: return org.hl7.fhir.r4.model.RequestGroup.ActionCardinalityBehavior.SINGLE;
    case MULTIPLE: return org.hl7.fhir.r4.model.RequestGroup.ActionCardinalityBehavior.MULTIPLE;
    default: return org.hl7.fhir.r4.model.RequestGroup.ActionCardinalityBehavior.NULL;
  }
}

  public static org.hl7.fhir.r5.model.RequestGroup.RequestGroupActionConditionComponent convertRequestGroupActionConditionComponent(org.hl7.fhir.r4.model.RequestGroup.RequestGroupActionConditionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.RequestGroup.RequestGroupActionConditionComponent tgt = new org.hl7.fhir.r5.model.RequestGroup.RequestGroupActionConditionComponent();
    copyElement(src, tgt);
    if (src.hasKind())
      tgt.setKind(convertActionConditionKind(src.getKind()));
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
      tgt.setKind(convertActionConditionKind(src.getKind()));
    if (src.hasExpression())
      tgt.setExpression(convertExpression(src.getExpression()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.RequestGroup.ActionConditionKind convertActionConditionKind(org.hl7.fhir.r4.model.RequestGroup.ActionConditionKind src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case APPLICABILITY: return org.hl7.fhir.r5.model.RequestGroup.ActionConditionKind.APPLICABILITY;
    case START: return org.hl7.fhir.r5.model.RequestGroup.ActionConditionKind.START;
    case STOP: return org.hl7.fhir.r5.model.RequestGroup.ActionConditionKind.STOP;
    default: return org.hl7.fhir.r5.model.RequestGroup.ActionConditionKind.NULL;
  }
}

  public static org.hl7.fhir.r4.model.RequestGroup.ActionConditionKind convertActionConditionKind(org.hl7.fhir.r5.model.RequestGroup.ActionConditionKind src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case APPLICABILITY: return org.hl7.fhir.r4.model.RequestGroup.ActionConditionKind.APPLICABILITY;
    case START: return org.hl7.fhir.r4.model.RequestGroup.ActionConditionKind.START;
    case STOP: return org.hl7.fhir.r4.model.RequestGroup.ActionConditionKind.STOP;
    default: return org.hl7.fhir.r4.model.RequestGroup.ActionConditionKind.NULL;
  }
}

  public static org.hl7.fhir.r5.model.RequestGroup.RequestGroupActionRelatedActionComponent convertRequestGroupActionRelatedActionComponent(org.hl7.fhir.r4.model.RequestGroup.RequestGroupActionRelatedActionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.RequestGroup.RequestGroupActionRelatedActionComponent tgt = new org.hl7.fhir.r5.model.RequestGroup.RequestGroupActionRelatedActionComponent();
    copyElement(src, tgt);
    if (src.hasActionId())
      tgt.setActionIdElement(convertId(src.getActionIdElement()));
    if (src.hasRelationship())
      tgt.setRelationship(convertActionRelationshipType(src.getRelationship()));
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
      tgt.setRelationship(convertActionRelationshipType(src.getRelationship()));
    if (src.hasOffset())
      tgt.setOffset(convertType(src.getOffset()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.RequestGroup.ActionRelationshipType convertActionRelationshipType(org.hl7.fhir.r4.model.RequestGroup.ActionRelationshipType src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case BEFORESTART: return org.hl7.fhir.r5.model.RequestGroup.ActionRelationshipType.BEFORESTART;
    case BEFORE: return org.hl7.fhir.r5.model.RequestGroup.ActionRelationshipType.BEFORE;
    case BEFOREEND: return org.hl7.fhir.r5.model.RequestGroup.ActionRelationshipType.BEFOREEND;
    case CONCURRENTWITHSTART: return org.hl7.fhir.r5.model.RequestGroup.ActionRelationshipType.CONCURRENTWITHSTART;
    case CONCURRENT: return org.hl7.fhir.r5.model.RequestGroup.ActionRelationshipType.CONCURRENT;
    case CONCURRENTWITHEND: return org.hl7.fhir.r5.model.RequestGroup.ActionRelationshipType.CONCURRENTWITHEND;
    case AFTERSTART: return org.hl7.fhir.r5.model.RequestGroup.ActionRelationshipType.AFTERSTART;
    case AFTER: return org.hl7.fhir.r5.model.RequestGroup.ActionRelationshipType.AFTER;
    case AFTEREND: return org.hl7.fhir.r5.model.RequestGroup.ActionRelationshipType.AFTEREND;
    default: return org.hl7.fhir.r5.model.RequestGroup.ActionRelationshipType.NULL;
  }
}

  public static org.hl7.fhir.r4.model.RequestGroup.ActionRelationshipType convertActionRelationshipType(org.hl7.fhir.r5.model.RequestGroup.ActionRelationshipType src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case BEFORESTART: return org.hl7.fhir.r4.model.RequestGroup.ActionRelationshipType.BEFORESTART;
    case BEFORE: return org.hl7.fhir.r4.model.RequestGroup.ActionRelationshipType.BEFORE;
    case BEFOREEND: return org.hl7.fhir.r4.model.RequestGroup.ActionRelationshipType.BEFOREEND;
    case CONCURRENTWITHSTART: return org.hl7.fhir.r4.model.RequestGroup.ActionRelationshipType.CONCURRENTWITHSTART;
    case CONCURRENT: return org.hl7.fhir.r4.model.RequestGroup.ActionRelationshipType.CONCURRENT;
    case CONCURRENTWITHEND: return org.hl7.fhir.r4.model.RequestGroup.ActionRelationshipType.CONCURRENTWITHEND;
    case AFTERSTART: return org.hl7.fhir.r4.model.RequestGroup.ActionRelationshipType.AFTERSTART;
    case AFTER: return org.hl7.fhir.r4.model.RequestGroup.ActionRelationshipType.AFTER;
    case AFTEREND: return org.hl7.fhir.r4.model.RequestGroup.ActionRelationshipType.AFTEREND;
    default: return org.hl7.fhir.r4.model.RequestGroup.ActionRelationshipType.NULL;
  }
}


}
