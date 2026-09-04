package org.hl7.fhir.convertors.conv43_N.resources43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.CodeableConcept43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Duration43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Identifier43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Period43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.metadata43_N.ContactDetail43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.metadata43_N.DataRequirement43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.metadata43_N.Expression43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.metadata43_N.RelatedArtifact43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.metadata43_N.TriggerDefinition43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.metadata43_N.UsageContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Boolean43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Canonical43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Date43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.DateTime43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Id43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.MarkDown43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.String43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Uri43_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4b.model.PlanDefinition;
import org.hl7.fhir.model.core.DataRequirement;
import org.hl7.fhir.model.core.Enumeration;
import org.hl7.fhir.model.core.Enumerations;
import org.hl7.fhir.model.core.PlanDefinition.PlanDefinitionActionInputComponent;
import org.hl7.fhir.model.core.PlanDefinition.PlanDefinitionActionOutputComponent;

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

public class PlanDefinition43_N {

  public static org.hl7.fhir.model.core.PlanDefinition convertPlanDefinition(org.hl7.fhir.r4b.model.PlanDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.PlanDefinition tgt = new org.hl7.fhir.model.core.PlanDefinition();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri43_N.convertUri(src.getUrlElement()));
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    if (src.hasVersion())
      tgt.setVersionElement(String43_N.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String43_N.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String43_N.convertString(src.getTitleElement()));
    if (src.hasSubtitle())
      tgt.setSubtitleElement(String43_N.convertString(src.getSubtitleElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept43_N.convertCodeableConcept(src.getType()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations43_N.convertPublicationStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean43_N.convertBoolean(src.getExperimentalElement()));
    if (src.hasSubject())
      tgt.setSubject(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getSubject()));
    if (src.hasDate())
      tgt.setDateElement(DateTime43_N.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String43_N.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.r4b.model.ContactDetail t : src.getContact())
      tgt.addContact(ContactDetail43_N.convertContactDetail(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown43_N.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r4b.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(UsageContext43_N.convertUsageContext(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasPurpose())
      tgt.setPurposeElement(MarkDown43_N.convertMarkdown(src.getPurposeElement()));
    if (src.hasUsage())
      tgt.setUsageElement(String43_N.convertStringToMarkdown(src.getUsageElement()));
    if (src.hasCopyright())
      tgt.setCopyrightElement(MarkDown43_N.convertMarkdown(src.getCopyrightElement()));
    if (src.hasApprovalDate())
      tgt.setApprovalDateElement(Date43_N.convertDate(src.getApprovalDateElement()));
    if (src.hasLastReviewDate())
      tgt.setLastReviewDateElement(Date43_N.convertDate(src.getLastReviewDateElement()));
    if (src.hasEffectivePeriod())
      tgt.setEffectivePeriod(Period43_N.convertPeriod(src.getEffectivePeriod()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getTopic())
      tgt.addTopic(CodeableConcept43_N.convertCodeableConcept(t));
    for (org.hl7.fhir.r4b.model.ContactDetail t : src.getAuthor())
      tgt.addAuthor(ContactDetail43_N.convertContactDetail(t));
    for (org.hl7.fhir.r4b.model.ContactDetail t : src.getEditor())
      tgt.addEditor(ContactDetail43_N.convertContactDetail(t));
    for (org.hl7.fhir.r4b.model.ContactDetail t : src.getReviewer())
      tgt.addReviewer(ContactDetail43_N.convertContactDetail(t));
    for (org.hl7.fhir.r4b.model.ContactDetail t : src.getEndorser())
      tgt.addEndorser(ContactDetail43_N.convertContactDetail(t));
    for (org.hl7.fhir.r4b.model.RelatedArtifact t : src.getRelatedArtifact())
      tgt.addRelatedArtifact(RelatedArtifact43_N.convertRelatedArtifact(t));
    for (org.hl7.fhir.r4b.model.CanonicalType t : src.getLibrary())
      tgt.getLibraryList().add(Canonical43_N.convertCanonical(t));
    for (org.hl7.fhir.r4b.model.PlanDefinition.PlanDefinitionGoalComponent t : src.getGoal())
      tgt.addGoal(convertPlanDefinitionGoalComponent(t));
    for (org.hl7.fhir.r4b.model.PlanDefinition.PlanDefinitionActionComponent t : src.getAction())
      tgt.addAction(convertPlanDefinitionActionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.PlanDefinition convertPlanDefinition(org.hl7.fhir.model.core.PlanDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.PlanDefinition tgt = new org.hl7.fhir.r4b.model.PlanDefinition();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri43_N.convertUri(src.getUrlElement()));
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    if (src.hasVersion())
      tgt.setVersionElement(String43_N.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String43_N.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String43_N.convertString(src.getTitleElement()));
    if (src.hasSubtitle())
      tgt.setSubtitleElement(String43_N.convertString(src.getSubtitleElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept43_N.convertCodeableConcept(src.getType()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations43_N.convertPublicationStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean43_N.convertBoolean(src.getExperimentalElement()));
    if (src.hasSubject())
      tgt.setSubject(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getSubject()));
    if (src.hasDate())
      tgt.setDateElement(DateTime43_N.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String43_N.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.model.core.ContactDetail t : src.getContactList())
      tgt.addContact(ContactDetail43_N.convertContactDetail(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown43_N.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.model.core.UsageContext t : src.getUseContextList())
      tgt.addUseContext(UsageContext43_N.convertUsageContext(t));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getJurisdictionList())
      tgt.addJurisdiction(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasPurpose())
      tgt.setPurposeElement(MarkDown43_N.convertMarkdown(src.getPurposeElement()));
    if (src.hasUsage())
      tgt.setUsageElement(String43_N.convertString(src.getUsageElement()));
    if (src.hasCopyright())
      tgt.setCopyrightElement(MarkDown43_N.convertMarkdown(src.getCopyrightElement()));
    if (src.hasApprovalDate())
      tgt.setApprovalDateElement(Date43_N.convertDate(src.getApprovalDateElement()));
    if (src.hasLastReviewDate())
      tgt.setLastReviewDateElement(Date43_N.convertDate(src.getLastReviewDateElement()));
    if (src.hasEffectivePeriod())
      tgt.setEffectivePeriod(Period43_N.convertPeriod(src.getEffectivePeriod()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getTopicList())
      tgt.addTopic(CodeableConcept43_N.convertCodeableConcept(t));
    for (org.hl7.fhir.model.core.ContactDetail t : src.getAuthorList())
      tgt.addAuthor(ContactDetail43_N.convertContactDetail(t));
    for (org.hl7.fhir.model.core.ContactDetail t : src.getEditorList())
      tgt.addEditor(ContactDetail43_N.convertContactDetail(t));
    for (org.hl7.fhir.model.core.ContactDetail t : src.getReviewerList())
      tgt.addReviewer(ContactDetail43_N.convertContactDetail(t));
    for (org.hl7.fhir.model.core.ContactDetail t : src.getEndorserList())
      tgt.addEndorser(ContactDetail43_N.convertContactDetail(t));
    for (org.hl7.fhir.model.core.RelatedArtifact t : src.getRelatedArtifactList())
      tgt.addRelatedArtifact(RelatedArtifact43_N.convertRelatedArtifact(t));
    for (org.hl7.fhir.model.core.CanonicalType t : src.getLibraryList())
      tgt.getLibrary().add(Canonical43_N.convertCanonical(t));
    for (org.hl7.fhir.model.core.PlanDefinition.PlanDefinitionGoalComponent t : src.getGoalList())
      tgt.addGoal(convertPlanDefinitionGoalComponent(t));
    for (org.hl7.fhir.model.core.PlanDefinition.PlanDefinitionActionComponent t : src.getActionList())
      tgt.addAction(convertPlanDefinitionActionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.PlanDefinition.PlanDefinitionGoalComponent convertPlanDefinitionGoalComponent(org.hl7.fhir.r4b.model.PlanDefinition.PlanDefinitionGoalComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.PlanDefinition.PlanDefinitionGoalComponent tgt = new org.hl7.fhir.model.core.PlanDefinition.PlanDefinitionGoalComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept43_N.convertCodeableConcept(src.getCategory()));
    if (src.hasDescription())
      tgt.setDescription(CodeableConcept43_N.convertCodeableConcept(src.getDescription()));
    if (src.hasPriority())
      tgt.setPriority(CodeableConcept43_N.convertCodeableConcept(src.getPriority()));
    if (src.hasStart())
      tgt.setStart(CodeableConcept43_N.convertCodeableConcept(src.getStart()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getAddresses())
      tgt.addAddresses(CodeableConcept43_N.convertCodeableConcept(t));
    for (org.hl7.fhir.r4b.model.RelatedArtifact t : src.getDocumentation())
      tgt.addDocumentation(RelatedArtifact43_N.convertRelatedArtifact(t));
    for (org.hl7.fhir.r4b.model.PlanDefinition.PlanDefinitionGoalTargetComponent t : src.getTarget())
      tgt.addTarget(convertPlanDefinitionGoalTargetComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.PlanDefinition.PlanDefinitionGoalComponent convertPlanDefinitionGoalComponent(org.hl7.fhir.model.core.PlanDefinition.PlanDefinitionGoalComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.PlanDefinition.PlanDefinitionGoalComponent tgt = new org.hl7.fhir.r4b.model.PlanDefinition.PlanDefinitionGoalComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept43_N.convertCodeableConcept(src.getCategory()));
    if (src.hasDescription())
      tgt.setDescription(CodeableConcept43_N.convertCodeableConcept(src.getDescription()));
    if (src.hasPriority())
      tgt.setPriority(CodeableConcept43_N.convertCodeableConcept(src.getPriority()));
    if (src.hasStart())
      tgt.setStart(CodeableConcept43_N.convertCodeableConcept(src.getStart()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getAddressesList())
      tgt.addAddresses(CodeableConcept43_N.convertCodeableConcept(t));
    for (org.hl7.fhir.model.core.RelatedArtifact t : src.getDocumentationList())
      tgt.addDocumentation(RelatedArtifact43_N.convertRelatedArtifact(t));
    for (org.hl7.fhir.model.core.PlanDefinition.PlanDefinitionGoalTargetComponent t : src.getTargetList())
      tgt.addTarget(convertPlanDefinitionGoalTargetComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.PlanDefinition.PlanDefinitionGoalTargetComponent convertPlanDefinitionGoalTargetComponent(org.hl7.fhir.r4b.model.PlanDefinition.PlanDefinitionGoalTargetComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.PlanDefinition.PlanDefinitionGoalTargetComponent tgt = new org.hl7.fhir.model.core.PlanDefinition.PlanDefinitionGoalTargetComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasMeasure())
      tgt.setMeasure(CodeableConcept43_N.convertCodeableConcept(src.getMeasure()));
    if (src.hasDetail())
      tgt.setDetail(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getDetail()));
    if (src.hasDue())
      tgt.setDue(Duration43_N.convertDuration(src.getDue()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.PlanDefinition.PlanDefinitionGoalTargetComponent convertPlanDefinitionGoalTargetComponent(org.hl7.fhir.model.core.PlanDefinition.PlanDefinitionGoalTargetComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.PlanDefinition.PlanDefinitionGoalTargetComponent tgt = new org.hl7.fhir.r4b.model.PlanDefinition.PlanDefinitionGoalTargetComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasMeasure())
      tgt.setMeasure(CodeableConcept43_N.convertCodeableConcept(src.getMeasure()));
    if (src.hasDetail())
      tgt.setDetail(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getDetail()));
    if (src.hasDue())
      tgt.setDue(Duration43_N.convertDuration(src.getDue()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.PlanDefinition.PlanDefinitionActionComponent convertPlanDefinitionActionComponent(org.hl7.fhir.r4b.model.PlanDefinition.PlanDefinitionActionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.PlanDefinition.PlanDefinitionActionComponent tgt = new org.hl7.fhir.model.core.PlanDefinition.PlanDefinitionActionComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasPrefix())
      tgt.setPrefixElement(String43_N.convertString(src.getPrefixElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String43_N.convertString(src.getTitleElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_N.convertStringToMarkdown(src.getDescriptionElement()));
    if (src.hasTextEquivalent())
      tgt.setTextEquivalentElement(String43_N.convertStringToMarkdown(src.getTextEquivalentElement()));
    if (src.hasPriority())
      tgt.setPriorityElement(convertRequestPriority(src.getPriorityElement()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getCode())
      tgt.setCode(CodeableConcept43_N.convertCodeableConcept(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getReason())
      tgt.addReason(CodeableConcept43_N.convertCodeableConcept(t));
    for (org.hl7.fhir.r4b.model.RelatedArtifact t : src.getDocumentation())
      tgt.addDocumentation(RelatedArtifact43_N.convertRelatedArtifact(t));
    for (org.hl7.fhir.r4b.model.IdType t : src.getGoalId()) tgt.getGoalIdList().add(Id43_N.convertIdToString(t));
    if (src.hasSubject())
      tgt.setSubject(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getSubject()));
    for (org.hl7.fhir.r4b.model.TriggerDefinition t : src.getTrigger())
      tgt.addTrigger(TriggerDefinition43_N.convertTriggerDefinition(t));
    for (org.hl7.fhir.r4b.model.PlanDefinition.PlanDefinitionActionConditionComponent t : src.getCondition())
      tgt.addCondition(convertPlanDefinitionActionConditionComponent(t));
    for (org.hl7.fhir.r4b.model.DataRequirement t : src.getInput())
      tgt.addInput(wrapInput(DataRequirement43_N.convertDataRequirement(t)));
    for (org.hl7.fhir.r4b.model.DataRequirement t : src.getOutput())
      tgt.addOutput(wrapOutput(DataRequirement43_N.convertDataRequirement(t)));
    for (org.hl7.fhir.r4b.model.PlanDefinition.PlanDefinitionActionRelatedActionComponent t : src.getRelatedAction())
      tgt.addRelatedAction(convertPlanDefinitionActionRelatedActionComponent(t));
    if (src.hasTiming())
      tgt.setTiming(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getTiming()));
    for (org.hl7.fhir.r4b.model.PlanDefinition.PlanDefinitionActionParticipantComponent t : src.getParticipant())
      tgt.addParticipant(convertPlanDefinitionActionParticipantComponent(t));
    if (src.hasType())
      tgt.setType(CodeableConcept43_N.convertCodeableConcept(src.getType()));
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
    if (src.hasDefinition())
      tgt.setDefinition(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getDefinition()));
    if (src.hasTransform())
      tgt.setTransformElement(Canonical43_N.convertCanonical(src.getTransformElement()));
    for (org.hl7.fhir.r4b.model.PlanDefinition.PlanDefinitionActionDynamicValueComponent t : src.getDynamicValue())
      tgt.addDynamicValue(convertPlanDefinitionActionDynamicValueComponent(t));
    for (org.hl7.fhir.r4b.model.PlanDefinition.PlanDefinitionActionComponent t : src.getAction())
      tgt.addAction(convertPlanDefinitionActionComponent(t));
    return tgt;
  }

  private static PlanDefinitionActionOutputComponent wrapOutput(DataRequirement dr) {
    return new PlanDefinitionActionOutputComponent().setRequirement(dr);
  }

  private static PlanDefinitionActionInputComponent wrapInput(DataRequirement dr) {
    return new PlanDefinitionActionInputComponent().setRequirement(dr);
  }

  public static org.hl7.fhir.r4b.model.PlanDefinition.PlanDefinitionActionComponent convertPlanDefinitionActionComponent(org.hl7.fhir.model.core.PlanDefinition.PlanDefinitionActionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.PlanDefinition.PlanDefinitionActionComponent tgt = new org.hl7.fhir.r4b.model.PlanDefinition.PlanDefinitionActionComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasPrefix())
      tgt.setPrefixElement(String43_N.convertString(src.getPrefixElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String43_N.convertString(src.getTitleElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_N.convertString(src.getDescriptionElement()));
    if (src.hasTextEquivalent())
      tgt.setTextEquivalentElement(String43_N.convertString(src.getTextEquivalentElement()));
    if (src.hasPriority())
      tgt.setPriorityElement(convertRequestPriority(src.getPriorityElement()));
    if (src.hasCode()) tgt.addCode(CodeableConcept43_N.convertCodeableConcept(src.getCode()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getReasonList())
      tgt.addReason(CodeableConcept43_N.convertCodeableConcept(t));
    for (org.hl7.fhir.model.core.RelatedArtifact t : src.getDocumentationList())
      tgt.addDocumentation(RelatedArtifact43_N.convertRelatedArtifact(t));
    for (org.hl7.fhir.model.core.StringType t : src.getGoalIdList()) tgt.getGoalId().add(Id43_N.convertId(t));
    if (src.hasSubject())
      tgt.setSubject(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getSubject()));
    for (org.hl7.fhir.model.core.TriggerDefinition t : src.getTriggerList())
      tgt.addTrigger(TriggerDefinition43_N.convertTriggerDefinition(t));
    for (org.hl7.fhir.model.core.PlanDefinition.PlanDefinitionActionConditionComponent t : src.getConditionList())
      tgt.addCondition(convertPlanDefinitionActionConditionComponent(t));
    for (PlanDefinitionActionInputComponent t : src.getInputList())
      tgt.addInput(DataRequirement43_N.convertDataRequirement(t.getRequirement()));
    for (PlanDefinitionActionOutputComponent t : src.getOutputList())
      tgt.addOutput(DataRequirement43_N.convertDataRequirement(t.getRequirement()));
    for (org.hl7.fhir.model.core.PlanDefinition.PlanDefinitionActionRelatedActionComponent t : src.getRelatedActionList())
      tgt.addRelatedAction(convertPlanDefinitionActionRelatedActionComponent(t));
    if (src.hasTiming())
      tgt.setTiming(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getTiming()));
    for (org.hl7.fhir.model.core.PlanDefinition.PlanDefinitionActionParticipantComponent t : src.getParticipantList())
      tgt.addParticipant(convertPlanDefinitionActionParticipantComponent(t));
    if (src.hasType())
      tgt.setType(CodeableConcept43_N.convertCodeableConcept(src.getType()));
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
    if (src.hasDefinition())
      tgt.setDefinition(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getDefinition()));
    if (src.hasTransform())
      tgt.setTransformElement(Canonical43_N.convertCanonical(src.getTransformElement()));
    for (org.hl7.fhir.model.core.PlanDefinition.PlanDefinitionActionDynamicValueComponent t : src.getDynamicValueList())
      tgt.addDynamicValue(convertPlanDefinitionActionDynamicValueComponent(t));
    for (org.hl7.fhir.model.core.PlanDefinition.PlanDefinitionActionComponent t : src.getActionList())
      tgt.addAction(convertPlanDefinitionActionComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.RequestPriority> convertRequestPriority(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.RequestPriority> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Enumerations.RequestPriority> tgt = new Enumeration<>(new Enumerations.RequestPriorityEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.RequestPriority> convertRequestPriority(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.RequestPriority> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.RequestPriority> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.RequestPriorityEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case ROUTINE:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestPriority.ROUTINE);
                  break;
              case URGENT:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestPriority.URGENT);
                  break;
              case ASAP:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestPriority.ASAP);
                  break;
              case STAT:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestPriority.STAT);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestPriority.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ActionGroupingBehavior> convertActionGroupingBehavior(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.ActionGroupingBehavior> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Enumerations.ActionGroupingBehavior> tgt = new Enumeration<>(new Enumerations.ActionGroupingBehaviorEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case VISUALGROUP:
                  tgt.setValue(Enumerations.ActionGroupingBehavior.VISUALGROUP);
                  break;
              case LOGICALGROUP:
                  tgt.setValue(Enumerations.ActionGroupingBehavior.LOGICALGROUP);
                  break;
              case SENTENCEGROUP:
                  tgt.setValue(Enumerations.ActionGroupingBehavior.SENTENCEGROUP);
                  break;
              default:
                  tgt.setValue(Enumerations.ActionGroupingBehavior.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.ActionGroupingBehavior> convertActionGroupingBehavior(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ActionGroupingBehavior> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.ActionGroupingBehavior> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.ActionGroupingBehaviorEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case VISUALGROUP:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.ActionGroupingBehavior.VISUALGROUP);
                  break;
              case LOGICALGROUP:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.ActionGroupingBehavior.LOGICALGROUP);
                  break;
              case SENTENCEGROUP:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.ActionGroupingBehavior.SENTENCEGROUP);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.ActionGroupingBehavior.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ActionSelectionBehavior> convertActionSelectionBehavior(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.ActionSelectionBehavior> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Enumerations.ActionSelectionBehavior> tgt = new Enumeration<>(new Enumerations.ActionSelectionBehaviorEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case ANY:
                  tgt.setValue(Enumerations.ActionSelectionBehavior.ANY);
                  break;
              case ALL:
                  tgt.setValue(Enumerations.ActionSelectionBehavior.ALL);
                  break;
              case ALLORNONE:
                  tgt.setValue(Enumerations.ActionSelectionBehavior.ALLORNONE);
                  break;
              case EXACTLYONE:
                  tgt.setValue(Enumerations.ActionSelectionBehavior.EXACTLYONE);
                  break;
              case ATMOSTONE:
                  tgt.setValue(Enumerations.ActionSelectionBehavior.ATMOSTONE);
                  break;
              case ONEORMORE:
                  tgt.setValue(Enumerations.ActionSelectionBehavior.ONEORMORE);
                  break;
              default:
                  tgt.setValue(Enumerations.ActionSelectionBehavior.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.ActionSelectionBehavior> convertActionSelectionBehavior(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ActionSelectionBehavior> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.ActionSelectionBehavior> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.ActionSelectionBehaviorEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case ANY:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.ActionSelectionBehavior.ANY);
                  break;
              case ALL:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.ActionSelectionBehavior.ALL);
                  break;
              case ALLORNONE:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.ActionSelectionBehavior.ALLORNONE);
                  break;
              case EXACTLYONE:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.ActionSelectionBehavior.EXACTLYONE);
                  break;
              case ATMOSTONE:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.ActionSelectionBehavior.ATMOSTONE);
                  break;
              case ONEORMORE:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.ActionSelectionBehavior.ONEORMORE);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.ActionSelectionBehavior.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ActionRequiredBehavior> convertActionRequiredBehavior(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.ActionRequiredBehavior> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Enumerations.ActionRequiredBehavior> tgt = new Enumeration<>(new Enumerations.ActionRequiredBehaviorEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case MUST:
                  tgt.setValue(Enumerations.ActionRequiredBehavior.MUST);
                  break;
              case COULD:
                  tgt.setValue(Enumerations.ActionRequiredBehavior.COULD);
                  break;
              case MUSTUNLESSDOCUMENTED:
                  tgt.setValue(Enumerations.ActionRequiredBehavior.MUSTUNLESSDOCUMENTED);
                  break;
              default:
                  tgt.setValue(Enumerations.ActionRequiredBehavior.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.ActionRequiredBehavior> convertActionRequiredBehavior(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ActionRequiredBehavior> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.ActionRequiredBehavior> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.ActionRequiredBehaviorEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case MUST:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.ActionRequiredBehavior.MUST);
                  break;
              case COULD:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.ActionRequiredBehavior.COULD);
                  break;
              case MUSTUNLESSDOCUMENTED:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.ActionRequiredBehavior.MUSTUNLESSDOCUMENTED);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.ActionRequiredBehavior.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ActionPrecheckBehavior> convertActionPrecheckBehavior(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.ActionPrecheckBehavior> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Enumerations.ActionPrecheckBehavior> tgt = new Enumeration<>(new Enumerations.ActionPrecheckBehaviorEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case YES:
                  tgt.setValue(Enumerations.ActionPrecheckBehavior.YES);
                  break;
              case NO:
                  tgt.setValue(Enumerations.ActionPrecheckBehavior.NO);
                  break;
              default:
                  tgt.setValue(Enumerations.ActionPrecheckBehavior.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.ActionPrecheckBehavior> convertActionPrecheckBehavior(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ActionPrecheckBehavior> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.ActionPrecheckBehavior> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.ActionPrecheckBehaviorEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case YES:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.ActionPrecheckBehavior.YES);
                  break;
              case NO:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.ActionPrecheckBehavior.NO);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.ActionPrecheckBehavior.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ActionCardinalityBehavior> convertActionCardinalityBehavior(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.ActionCardinalityBehavior> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Enumerations.ActionCardinalityBehavior> tgt = new Enumeration<>(new Enumerations.ActionCardinalityBehaviorEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case SINGLE:
                  tgt.setValue(Enumerations.ActionCardinalityBehavior.SINGLE);
                  break;
              case MULTIPLE:
                  tgt.setValue(Enumerations.ActionCardinalityBehavior.MULTIPLE);
                  break;
              default:
                  tgt.setValue(Enumerations.ActionCardinalityBehavior.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.ActionCardinalityBehavior> convertActionCardinalityBehavior(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ActionCardinalityBehavior> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.ActionCardinalityBehavior> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.ActionCardinalityBehaviorEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case SINGLE:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.ActionCardinalityBehavior.SINGLE);
                  break;
              case MULTIPLE:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.ActionCardinalityBehavior.MULTIPLE);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.ActionCardinalityBehavior.NULL);
                  break;
          }
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.PlanDefinition.PlanDefinitionActionConditionComponent convertPlanDefinitionActionConditionComponent(org.hl7.fhir.r4b.model.PlanDefinition.PlanDefinitionActionConditionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.PlanDefinition.PlanDefinitionActionConditionComponent tgt = new org.hl7.fhir.model.core.PlanDefinition.PlanDefinitionActionConditionComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasKind())
      tgt.setKindElement(convertActionConditionKind(src.getKindElement()));
    if (src.hasExpression())
      tgt.setExpression(Expression43_N.convertExpression(src.getExpression()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.PlanDefinition.PlanDefinitionActionConditionComponent convertPlanDefinitionActionConditionComponent(org.hl7.fhir.model.core.PlanDefinition.PlanDefinitionActionConditionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.PlanDefinition.PlanDefinitionActionConditionComponent tgt = new org.hl7.fhir.r4b.model.PlanDefinition.PlanDefinitionActionConditionComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasKind())
      tgt.setKindElement(convertActionConditionKind(src.getKindElement()));
    if (src.hasExpression())
      tgt.setExpression(Expression43_N.convertExpression(src.getExpression()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ActionConditionKind> convertActionConditionKind(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.ActionConditionKind> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Enumerations.ActionConditionKind> tgt = new Enumeration<>(new Enumerations.ActionConditionKindEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case APPLICABILITY:
                  tgt.setValue(Enumerations.ActionConditionKind.APPLICABILITY);
                  break;
              case START:
                  tgt.setValue(Enumerations.ActionConditionKind.START);
                  break;
              case STOP:
                  tgt.setValue(Enumerations.ActionConditionKind.STOP);
                  break;
              default:
                  tgt.setValue(Enumerations.ActionConditionKind.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.ActionConditionKind> convertActionConditionKind(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ActionConditionKind> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.ActionConditionKind> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.ActionConditionKindEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case APPLICABILITY:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.ActionConditionKind.APPLICABILITY);
                  break;
              case START:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.ActionConditionKind.START);
                  break;
              case STOP:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.ActionConditionKind.STOP);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.ActionConditionKind.NULL);
                  break;
          }
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.PlanDefinition.PlanDefinitionActionRelatedActionComponent convertPlanDefinitionActionRelatedActionComponent(org.hl7.fhir.r4b.model.PlanDefinition.PlanDefinitionActionRelatedActionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.PlanDefinition.PlanDefinitionActionRelatedActionComponent tgt = new org.hl7.fhir.model.core.PlanDefinition.PlanDefinitionActionRelatedActionComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasActionId())
      tgt.setTargetIdElement(Id43_N.convertIdToString(src.getActionIdElement()));
    if (src.hasRelationship())
      tgt.setRelationshipElement(convertActionRelationshipType(src.getRelationshipElement()));
    if (src.hasOffset())
      tgt.setOffset(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getOffset()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.PlanDefinition.PlanDefinitionActionRelatedActionComponent convertPlanDefinitionActionRelatedActionComponent(org.hl7.fhir.model.core.PlanDefinition.PlanDefinitionActionRelatedActionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.PlanDefinition.PlanDefinitionActionRelatedActionComponent tgt = new org.hl7.fhir.r4b.model.PlanDefinition.PlanDefinitionActionRelatedActionComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasTargetId())
      tgt.setActionIdElement(Id43_N.convertId(src.getTargetIdElement()));
    if (src.hasRelationship())
      tgt.setRelationshipElement(convertActionRelationshipType(src.getRelationshipElement()));
    if (src.hasOffset())
      tgt.setOffset(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getOffset()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ActionRelationshipType> convertActionRelationshipType(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.ActionRelationshipType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Enumerations.ActionRelationshipType> tgt = new Enumeration<>(new Enumerations.ActionRelationshipTypeEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case BEFORESTART:
                  tgt.setValue(Enumerations.ActionRelationshipType.BEFORESTART);
                  break;
              case BEFORE:
                  tgt.setValue(Enumerations.ActionRelationshipType.BEFORE);
                  break;
              case BEFOREEND:
                  tgt.setValue(Enumerations.ActionRelationshipType.BEFOREEND);
                  break;
              case CONCURRENTWITHSTART:
                  tgt.setValue(Enumerations.ActionRelationshipType.CONCURRENTWITHSTART);
                  break;
              case CONCURRENT:
                  tgt.setValue(Enumerations.ActionRelationshipType.CONCURRENT);
                  break;
              case CONCURRENTWITHEND:
                  tgt.setValue(Enumerations.ActionRelationshipType.CONCURRENTWITHEND);
                  break;
              case AFTERSTART:
                  tgt.setValue(Enumerations.ActionRelationshipType.AFTERSTART);
                  break;
              case AFTER:
                  tgt.setValue(Enumerations.ActionRelationshipType.AFTER);
                  break;
              case AFTEREND:
                  tgt.setValue(Enumerations.ActionRelationshipType.AFTEREND);
                  break;
              default:
                  tgt.setValue(Enumerations.ActionRelationshipType.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.ActionRelationshipType> convertActionRelationshipType(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ActionRelationshipType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.ActionRelationshipType> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.ActionRelationshipTypeEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case BEFORESTART:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.ActionRelationshipType.BEFORESTART);
                  break;
              case BEFORE:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.ActionRelationshipType.BEFORE);
                  break;
              case BEFOREEND:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.ActionRelationshipType.BEFOREEND);
                  break;
              case CONCURRENTWITHSTART:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.ActionRelationshipType.CONCURRENTWITHSTART);
                  break;
              case CONCURRENT:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.ActionRelationshipType.CONCURRENT);
                  break;
              case CONCURRENTWITHEND:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.ActionRelationshipType.CONCURRENTWITHEND);
                  break;
              case AFTERSTART:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.ActionRelationshipType.AFTERSTART);
                  break;
              case AFTER:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.ActionRelationshipType.AFTER);
                  break;
              case AFTEREND:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.ActionRelationshipType.AFTEREND);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.ActionRelationshipType.NULL);
                  break;
          }
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.PlanDefinition.PlanDefinitionActionParticipantComponent convertPlanDefinitionActionParticipantComponent(org.hl7.fhir.r4b.model.PlanDefinition.PlanDefinitionActionParticipantComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.PlanDefinition.PlanDefinitionActionParticipantComponent tgt = new org.hl7.fhir.model.core.PlanDefinition.PlanDefinitionActionParticipantComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setTypeElement(convertActionParticipantType(src.getTypeElement()));
    if (src.hasRole())
      tgt.setRole(CodeableConcept43_N.convertCodeableConcept(src.getRole()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.PlanDefinition.PlanDefinitionActionParticipantComponent convertPlanDefinitionActionParticipantComponent(org.hl7.fhir.model.core.PlanDefinition.PlanDefinitionActionParticipantComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.PlanDefinition.PlanDefinitionActionParticipantComponent tgt = new org.hl7.fhir.r4b.model.PlanDefinition.PlanDefinitionActionParticipantComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setTypeElement(convertActionParticipantType(src.getTypeElement()));
    if (src.hasRole())
      tgt.setRole(CodeableConcept43_N.convertCodeableConcept(src.getRole()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ActionParticipantType> convertActionParticipantType(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.ActionParticipantType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Enumerations.ActionParticipantType> tgt = new Enumeration<>(new Enumerations.ActionParticipantTypeEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case PATIENT:
                  tgt.setValue(Enumerations.ActionParticipantType.PATIENT);
                  break;
              case PRACTITIONER:
                  tgt.setValue(Enumerations.ActionParticipantType.PRACTITIONER);
                  break;
              case RELATEDPERSON:
                  tgt.setValue(Enumerations.ActionParticipantType.RELATEDPERSON);
                  break;
              case DEVICE:
                  tgt.setValue(Enumerations.ActionParticipantType.DEVICE);
                  break;
              default:
                  tgt.setValue(Enumerations.ActionParticipantType.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.ActionParticipantType> convertActionParticipantType(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ActionParticipantType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.ActionParticipantType> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.ActionParticipantTypeEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case PATIENT:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.ActionParticipantType.PATIENT);
                  break;
              case PRACTITIONER:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.ActionParticipantType.PRACTITIONER);
                  break;
              case RELATEDPERSON:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.ActionParticipantType.RELATEDPERSON);
                  break;
              case DEVICE:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.ActionParticipantType.DEVICE);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.ActionParticipantType.NULL);
                  break;
          }
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.PlanDefinition.PlanDefinitionActionDynamicValueComponent convertPlanDefinitionActionDynamicValueComponent(org.hl7.fhir.r4b.model.PlanDefinition.PlanDefinitionActionDynamicValueComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.PlanDefinition.PlanDefinitionActionDynamicValueComponent tgt = new org.hl7.fhir.model.core.PlanDefinition.PlanDefinitionActionDynamicValueComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasPath())
      tgt.setPathElement(String43_N.convertString(src.getPathElement()));
    if (src.hasExpression())
      tgt.setExpression(Expression43_N.convertExpression(src.getExpression()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.PlanDefinition.PlanDefinitionActionDynamicValueComponent convertPlanDefinitionActionDynamicValueComponent(org.hl7.fhir.model.core.PlanDefinition.PlanDefinitionActionDynamicValueComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.PlanDefinition.PlanDefinitionActionDynamicValueComponent tgt = new org.hl7.fhir.r4b.model.PlanDefinition.PlanDefinitionActionDynamicValueComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasPath())
      tgt.setPathElement(String43_N.convertString(src.getPathElement()));
    if (src.hasExpression())
      tgt.setExpression(Expression43_N.convertExpression(src.getExpression()));
    return tgt;
  }
}