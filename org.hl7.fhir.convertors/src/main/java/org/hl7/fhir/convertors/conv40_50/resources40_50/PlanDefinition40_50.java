package org.hl7.fhir.convertors.conv40_50.resources40_50;

import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.CodeableConcept40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Duration40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Identifier40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Period40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.metadata40_50.ContactDetail40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.metadata40_50.DataRequirement40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.metadata40_50.Expression40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.metadata40_50.RelatedArtifact40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.metadata40_50.TriggerDefinition40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.metadata40_50.UsageContext40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Boolean40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Canonical40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Date40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.DateTime40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Id40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.MarkDown40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.String40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Uri40_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.DataRequirement;
import org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionActionInputComponent;
import org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionActionOutputComponent;

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
public class PlanDefinition40_50 {

  public static org.hl7.fhir.r5.model.PlanDefinition convertPlanDefinition(org.hl7.fhir.r4.model.PlanDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.PlanDefinition tgt = new org.hl7.fhir.r5.model.PlanDefinition();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri40_50.convertUri(src.getUrlElement()));
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_50.convertIdentifier(t));
    if (src.hasVersion())
      tgt.setVersionElement(String40_50.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String40_50.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String40_50.convertString(src.getTitleElement()));
    if (src.hasSubtitle())
      tgt.setSubtitleElement(String40_50.convertString(src.getSubtitleElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept40_50.convertCodeableConcept(src.getType()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations40_50.convertPublicationStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean40_50.convertBoolean(src.getExperimentalElement()));
    if (src.hasSubject())
      tgt.setSubject(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getSubject()));
    if (src.hasDate())
      tgt.setDateElement(DateTime40_50.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String40_50.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.r4.model.ContactDetail t : src.getContact())
      tgt.addContact(ContactDetail40_50.convertContactDetail(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown40_50.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r4.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(UsageContext40_50.convertUsageContext(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(CodeableConcept40_50.convertCodeableConcept(t));
    if (src.hasPurpose())
      tgt.setPurposeElement(MarkDown40_50.convertMarkdown(src.getPurposeElement()));
    if (src.hasUsage())
      tgt.setUsageElement(String40_50.convertStringToMarkdown(src.getUsageElement()));
    if (src.hasCopyright())
      tgt.setCopyrightElement(MarkDown40_50.convertMarkdown(src.getCopyrightElement()));
    if (src.hasApprovalDate())
      tgt.setApprovalDateElement(Date40_50.convertDate(src.getApprovalDateElement()));
    if (src.hasLastReviewDate())
      tgt.setLastReviewDateElement(Date40_50.convertDate(src.getLastReviewDateElement()));
    if (src.hasEffectivePeriod())
      tgt.setEffectivePeriod(Period40_50.convertPeriod(src.getEffectivePeriod()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getTopic())
      tgt.addTopic(CodeableConcept40_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.ContactDetail t : src.getAuthor())
      tgt.addAuthor(ContactDetail40_50.convertContactDetail(t));
    for (org.hl7.fhir.r4.model.ContactDetail t : src.getEditor())
      tgt.addEditor(ContactDetail40_50.convertContactDetail(t));
    for (org.hl7.fhir.r4.model.ContactDetail t : src.getReviewer())
      tgt.addReviewer(ContactDetail40_50.convertContactDetail(t));
    for (org.hl7.fhir.r4.model.ContactDetail t : src.getEndorser())
      tgt.addEndorser(ContactDetail40_50.convertContactDetail(t));
    for (org.hl7.fhir.r4.model.RelatedArtifact t : src.getRelatedArtifact())
      tgt.addRelatedArtifact(RelatedArtifact40_50.convertRelatedArtifact(t));
    for (org.hl7.fhir.r4.model.CanonicalType t : src.getLibrary())
      tgt.getLibrary().add(Canonical40_50.convertCanonical(t));
    for (org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionGoalComponent t : src.getGoal())
      tgt.addGoal(convertPlanDefinitionGoalComponent(t));
    for (org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionComponent t : src.getAction())
      tgt.addAction(convertPlanDefinitionActionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.PlanDefinition convertPlanDefinition(org.hl7.fhir.r5.model.PlanDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.PlanDefinition tgt = new org.hl7.fhir.r4.model.PlanDefinition();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri40_50.convertUri(src.getUrlElement()));
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_50.convertIdentifier(t));
    if (src.hasVersion())
      tgt.setVersionElement(String40_50.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String40_50.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String40_50.convertString(src.getTitleElement()));
    if (src.hasSubtitle())
      tgt.setSubtitleElement(String40_50.convertString(src.getSubtitleElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept40_50.convertCodeableConcept(src.getType()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations40_50.convertPublicationStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean40_50.convertBoolean(src.getExperimentalElement()));
    if (src.hasSubject())
      tgt.setSubject(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getSubject()));
    if (src.hasDate())
      tgt.setDateElement(DateTime40_50.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String40_50.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.r5.model.ContactDetail t : src.getContact())
      tgt.addContact(ContactDetail40_50.convertContactDetail(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown40_50.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r5.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(UsageContext40_50.convertUsageContext(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(CodeableConcept40_50.convertCodeableConcept(t));
    if (src.hasPurpose())
      tgt.setPurposeElement(MarkDown40_50.convertMarkdown(src.getPurposeElement()));
    if (src.hasUsage())
      tgt.setUsageElement(String40_50.convertString(src.getUsageElement()));
    if (src.hasCopyright())
      tgt.setCopyrightElement(MarkDown40_50.convertMarkdown(src.getCopyrightElement()));
    if (src.hasApprovalDate())
      tgt.setApprovalDateElement(Date40_50.convertDate(src.getApprovalDateElement()));
    if (src.hasLastReviewDate())
      tgt.setLastReviewDateElement(Date40_50.convertDate(src.getLastReviewDateElement()));
    if (src.hasEffectivePeriod())
      tgt.setEffectivePeriod(Period40_50.convertPeriod(src.getEffectivePeriod()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getTopic())
      tgt.addTopic(CodeableConcept40_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.ContactDetail t : src.getAuthor())
      tgt.addAuthor(ContactDetail40_50.convertContactDetail(t));
    for (org.hl7.fhir.r5.model.ContactDetail t : src.getEditor())
      tgt.addEditor(ContactDetail40_50.convertContactDetail(t));
    for (org.hl7.fhir.r5.model.ContactDetail t : src.getReviewer())
      tgt.addReviewer(ContactDetail40_50.convertContactDetail(t));
    for (org.hl7.fhir.r5.model.ContactDetail t : src.getEndorser())
      tgt.addEndorser(ContactDetail40_50.convertContactDetail(t));
    for (org.hl7.fhir.r5.model.RelatedArtifact t : src.getRelatedArtifact())
      tgt.addRelatedArtifact(RelatedArtifact40_50.convertRelatedArtifact(t));
    for (org.hl7.fhir.r5.model.CanonicalType t : src.getLibrary())
      tgt.getLibrary().add(Canonical40_50.convertCanonical(t));
    for (org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionGoalComponent t : src.getGoal())
      tgt.addGoal(convertPlanDefinitionGoalComponent(t));
    for (org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionActionComponent t : src.getAction())
      tgt.addAction(convertPlanDefinitionActionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionGoalComponent convertPlanDefinitionGoalComponent(org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionGoalComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionGoalComponent tgt = new org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionGoalComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept40_50.convertCodeableConcept(src.getCategory()));
    if (src.hasDescription())
      tgt.setDescription(CodeableConcept40_50.convertCodeableConcept(src.getDescription()));
    if (src.hasPriority())
      tgt.setPriority(CodeableConcept40_50.convertCodeableConcept(src.getPriority()));
    if (src.hasStart())
      tgt.setStart(CodeableConcept40_50.convertCodeableConcept(src.getStart()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getAddresses())
      tgt.addAddresses(CodeableConcept40_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.RelatedArtifact t : src.getDocumentation())
      tgt.addDocumentation(RelatedArtifact40_50.convertRelatedArtifact(t));
    for (org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionGoalTargetComponent t : src.getTarget())
      tgt.addTarget(convertPlanDefinitionGoalTargetComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionGoalComponent convertPlanDefinitionGoalComponent(org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionGoalComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionGoalComponent tgt = new org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionGoalComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept40_50.convertCodeableConcept(src.getCategory()));
    if (src.hasDescription())
      tgt.setDescription(CodeableConcept40_50.convertCodeableConcept(src.getDescription()));
    if (src.hasPriority())
      tgt.setPriority(CodeableConcept40_50.convertCodeableConcept(src.getPriority()));
    if (src.hasStart())
      tgt.setStart(CodeableConcept40_50.convertCodeableConcept(src.getStart()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getAddresses())
      tgt.addAddresses(CodeableConcept40_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.RelatedArtifact t : src.getDocumentation())
      tgt.addDocumentation(RelatedArtifact40_50.convertRelatedArtifact(t));
    for (org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionGoalTargetComponent t : src.getTarget())
      tgt.addTarget(convertPlanDefinitionGoalTargetComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionGoalTargetComponent convertPlanDefinitionGoalTargetComponent(org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionGoalTargetComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionGoalTargetComponent tgt = new org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionGoalTargetComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasMeasure())
      tgt.setMeasure(CodeableConcept40_50.convertCodeableConcept(src.getMeasure()));
    if (src.hasDetail())
      tgt.setDetail(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getDetail()));
    if (src.hasDue())
      tgt.setDue(Duration40_50.convertDuration(src.getDue()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionGoalTargetComponent convertPlanDefinitionGoalTargetComponent(org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionGoalTargetComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionGoalTargetComponent tgt = new org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionGoalTargetComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasMeasure())
      tgt.setMeasure(CodeableConcept40_50.convertCodeableConcept(src.getMeasure()));
    if (src.hasDetail())
      tgt.setDetail(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getDetail()));
    if (src.hasDue())
      tgt.setDue(Duration40_50.convertDuration(src.getDue()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionActionComponent convertPlanDefinitionActionComponent(org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionActionComponent tgt = new org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionActionComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasPrefix())
      tgt.setPrefixElement(String40_50.convertString(src.getPrefixElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String40_50.convertString(src.getTitleElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_50.convertStringToMarkdown(src.getDescriptionElement()));
    if (src.hasTextEquivalent())
      tgt.setTextEquivalentElement(String40_50.convertStringToMarkdown(src.getTextEquivalentElement()));
    if (src.hasPriority())
      tgt.setPriorityElement(convertRequestPriority(src.getPriorityElement()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCode())
      tgt.setCode(CodeableConcept40_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReason())
      tgt.addReason(CodeableConcept40_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.RelatedArtifact t : src.getDocumentation())
      tgt.addDocumentation(RelatedArtifact40_50.convertRelatedArtifact(t));
    for (org.hl7.fhir.r4.model.IdType t : src.getGoalId()) tgt.getGoalId().add(Id40_50.convertId(t));
    if (src.hasSubject())
      tgt.setSubject(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getSubject()));
    for (org.hl7.fhir.r4.model.TriggerDefinition t : src.getTrigger())
      tgt.addTrigger(TriggerDefinition40_50.convertTriggerDefinition(t));
    for (org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionConditionComponent t : src.getCondition())
      tgt.addCondition(convertPlanDefinitionActionConditionComponent(t));
    for (org.hl7.fhir.r4.model.DataRequirement t : src.getInput())
      tgt.addInput(wrapInput(DataRequirement40_50.convertDataRequirement(t)));
    for (org.hl7.fhir.r4.model.DataRequirement t : src.getOutput())
      tgt.addOutput(wrapOutput(DataRequirement40_50.convertDataRequirement(t)));
    for (org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionRelatedActionComponent t : src.getRelatedAction())
      tgt.addRelatedAction(convertPlanDefinitionActionRelatedActionComponent(t));
    if (src.hasTiming())
      tgt.setTiming(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getTiming()));
    for (org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionParticipantComponent t : src.getParticipant())
      tgt.addParticipant(convertPlanDefinitionActionParticipantComponent(t));
    if (src.hasType())
      tgt.setType(CodeableConcept40_50.convertCodeableConcept(src.getType()));
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
      tgt.setDefinition(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getDefinition()));
    if (src.hasTransform())
      tgt.setTransformElement(Canonical40_50.convertCanonical(src.getTransformElement()));
    for (org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionDynamicValueComponent t : src.getDynamicValue())
      tgt.addDynamicValue(convertPlanDefinitionActionDynamicValueComponent(t));
    for (org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionComponent t : src.getAction())
      tgt.addAction(convertPlanDefinitionActionComponent(t));
    return tgt;
  }

  private static PlanDefinitionActionOutputComponent wrapOutput(DataRequirement dr) {
    return new PlanDefinitionActionOutputComponent().setRequirement(dr);
  }

  private static PlanDefinitionActionInputComponent wrapInput(DataRequirement dr) {
    return new PlanDefinitionActionInputComponent().setRequirement(dr);
  }

  public static org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionComponent convertPlanDefinitionActionComponent(org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionActionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionComponent tgt = new org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasPrefix())
      tgt.setPrefixElement(String40_50.convertString(src.getPrefixElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String40_50.convertString(src.getTitleElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_50.convertString(src.getDescriptionElement()));
    if (src.hasTextEquivalent())
      tgt.setTextEquivalentElement(String40_50.convertString(src.getTextEquivalentElement()));
    if (src.hasPriority())
      tgt.setPriorityElement(convertRequestPriority(src.getPriorityElement()));
    if (src.hasCode()) tgt.addCode(CodeableConcept40_50.convertCodeableConcept(src.getCode()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getReason())
      tgt.addReason(CodeableConcept40_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.RelatedArtifact t : src.getDocumentation())
      tgt.addDocumentation(RelatedArtifact40_50.convertRelatedArtifact(t));
    for (org.hl7.fhir.r5.model.IdType t : src.getGoalId()) tgt.getGoalId().add(Id40_50.convertId(t));
    if (src.hasSubject())
      tgt.setSubject(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getSubject()));
    for (org.hl7.fhir.r5.model.TriggerDefinition t : src.getTrigger())
      tgt.addTrigger(TriggerDefinition40_50.convertTriggerDefinition(t));
    for (org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionActionConditionComponent t : src.getCondition())
      tgt.addCondition(convertPlanDefinitionActionConditionComponent(t));
    for (PlanDefinitionActionInputComponent t : src.getInput())
      tgt.addInput(DataRequirement40_50.convertDataRequirement(t.getRequirement()));
    for (PlanDefinitionActionOutputComponent t : src.getOutput())
      tgt.addOutput(DataRequirement40_50.convertDataRequirement(t.getRequirement()));
    for (org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionActionRelatedActionComponent t : src.getRelatedAction())
      tgt.addRelatedAction(convertPlanDefinitionActionRelatedActionComponent(t));
    if (src.hasTiming())
      tgt.setTiming(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getTiming()));
    for (org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionActionParticipantComponent t : src.getParticipant())
      tgt.addParticipant(convertPlanDefinitionActionParticipantComponent(t));
    if (src.hasType())
      tgt.setType(CodeableConcept40_50.convertCodeableConcept(src.getType()));
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
      tgt.setDefinition(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getDefinition()));
    if (src.hasTransform())
      tgt.setTransformElement(Canonical40_50.convertCanonical(src.getTransformElement()));
    for (org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionActionDynamicValueComponent t : src.getDynamicValue())
      tgt.addDynamicValue(convertPlanDefinitionActionDynamicValueComponent(t));
    for (org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionActionComponent t : src.getAction())
      tgt.addAction(convertPlanDefinitionActionComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestPriority> convertRequestPriority(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.PlanDefinition.RequestPriority> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestPriority> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.RequestPriorityEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.PlanDefinition.RequestPriority> convertRequestPriority(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestPriority> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.PlanDefinition.RequestPriority> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.PlanDefinition.RequestPriorityEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case ROUTINE:
        tgt.setValue(org.hl7.fhir.r4.model.PlanDefinition.RequestPriority.ROUTINE);
        break;
      case URGENT:
        tgt.setValue(org.hl7.fhir.r4.model.PlanDefinition.RequestPriority.URGENT);
        break;
      case ASAP:
        tgt.setValue(org.hl7.fhir.r4.model.PlanDefinition.RequestPriority.ASAP);
        break;
      case STAT:
        tgt.setValue(org.hl7.fhir.r4.model.PlanDefinition.RequestPriority.STAT);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.PlanDefinition.RequestPriority.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionGroupingBehavior> convertActionGroupingBehavior(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.PlanDefinition.ActionGroupingBehavior> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionGroupingBehavior> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.ActionGroupingBehaviorEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.PlanDefinition.ActionGroupingBehavior> convertActionGroupingBehavior(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionGroupingBehavior> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.PlanDefinition.ActionGroupingBehavior> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.PlanDefinition.ActionGroupingBehaviorEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case VISUALGROUP:
        tgt.setValue(org.hl7.fhir.r4.model.PlanDefinition.ActionGroupingBehavior.VISUALGROUP);
        break;
      case LOGICALGROUP:
        tgt.setValue(org.hl7.fhir.r4.model.PlanDefinition.ActionGroupingBehavior.LOGICALGROUP);
        break;
      case SENTENCEGROUP:
        tgt.setValue(org.hl7.fhir.r4.model.PlanDefinition.ActionGroupingBehavior.SENTENCEGROUP);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.PlanDefinition.ActionGroupingBehavior.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionSelectionBehavior> convertActionSelectionBehavior(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.PlanDefinition.ActionSelectionBehavior> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionSelectionBehavior> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.ActionSelectionBehaviorEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.PlanDefinition.ActionSelectionBehavior> convertActionSelectionBehavior(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionSelectionBehavior> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.PlanDefinition.ActionSelectionBehavior> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.PlanDefinition.ActionSelectionBehaviorEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case ANY:
        tgt.setValue(org.hl7.fhir.r4.model.PlanDefinition.ActionSelectionBehavior.ANY);
        break;
      case ALL:
        tgt.setValue(org.hl7.fhir.r4.model.PlanDefinition.ActionSelectionBehavior.ALL);
        break;
      case ALLORNONE:
        tgt.setValue(org.hl7.fhir.r4.model.PlanDefinition.ActionSelectionBehavior.ALLORNONE);
        break;
      case EXACTLYONE:
        tgt.setValue(org.hl7.fhir.r4.model.PlanDefinition.ActionSelectionBehavior.EXACTLYONE);
        break;
      case ATMOSTONE:
        tgt.setValue(org.hl7.fhir.r4.model.PlanDefinition.ActionSelectionBehavior.ATMOSTONE);
        break;
      case ONEORMORE:
        tgt.setValue(org.hl7.fhir.r4.model.PlanDefinition.ActionSelectionBehavior.ONEORMORE);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.PlanDefinition.ActionSelectionBehavior.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionRequiredBehavior> convertActionRequiredBehavior(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.PlanDefinition.ActionRequiredBehavior> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionRequiredBehavior> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.ActionRequiredBehaviorEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.PlanDefinition.ActionRequiredBehavior> convertActionRequiredBehavior(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionRequiredBehavior> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.PlanDefinition.ActionRequiredBehavior> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.PlanDefinition.ActionRequiredBehaviorEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case MUST:
        tgt.setValue(org.hl7.fhir.r4.model.PlanDefinition.ActionRequiredBehavior.MUST);
        break;
      case COULD:
        tgt.setValue(org.hl7.fhir.r4.model.PlanDefinition.ActionRequiredBehavior.COULD);
        break;
      case MUSTUNLESSDOCUMENTED:
        tgt.setValue(org.hl7.fhir.r4.model.PlanDefinition.ActionRequiredBehavior.MUSTUNLESSDOCUMENTED);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.PlanDefinition.ActionRequiredBehavior.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionPrecheckBehavior> convertActionPrecheckBehavior(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.PlanDefinition.ActionPrecheckBehavior> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionPrecheckBehavior> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.ActionPrecheckBehaviorEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.PlanDefinition.ActionPrecheckBehavior> convertActionPrecheckBehavior(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionPrecheckBehavior> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.PlanDefinition.ActionPrecheckBehavior> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.PlanDefinition.ActionPrecheckBehaviorEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case YES:
        tgt.setValue(org.hl7.fhir.r4.model.PlanDefinition.ActionPrecheckBehavior.YES);
        break;
      case NO:
        tgt.setValue(org.hl7.fhir.r4.model.PlanDefinition.ActionPrecheckBehavior.NO);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.PlanDefinition.ActionPrecheckBehavior.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionCardinalityBehavior> convertActionCardinalityBehavior(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.PlanDefinition.ActionCardinalityBehavior> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionCardinalityBehavior> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.ActionCardinalityBehaviorEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.PlanDefinition.ActionCardinalityBehavior> convertActionCardinalityBehavior(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionCardinalityBehavior> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.PlanDefinition.ActionCardinalityBehavior> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.PlanDefinition.ActionCardinalityBehaviorEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case SINGLE:
        tgt.setValue(org.hl7.fhir.r4.model.PlanDefinition.ActionCardinalityBehavior.SINGLE);
        break;
      case MULTIPLE:
        tgt.setValue(org.hl7.fhir.r4.model.PlanDefinition.ActionCardinalityBehavior.MULTIPLE);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.PlanDefinition.ActionCardinalityBehavior.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionActionConditionComponent convertPlanDefinitionActionConditionComponent(org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionConditionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionActionConditionComponent tgt = new org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionActionConditionComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasKind())
      tgt.setKindElement(convertActionConditionKind(src.getKindElement()));
    if (src.hasExpression())
      tgt.setExpression(Expression40_50.convertExpression(src.getExpression()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionConditionComponent convertPlanDefinitionActionConditionComponent(org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionActionConditionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionConditionComponent tgt = new org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionConditionComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasKind())
      tgt.setKindElement(convertActionConditionKind(src.getKindElement()));
    if (src.hasExpression())
      tgt.setExpression(Expression40_50.convertExpression(src.getExpression()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionConditionKind> convertActionConditionKind(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.PlanDefinition.ActionConditionKind> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionConditionKind> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.ActionConditionKindEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.PlanDefinition.ActionConditionKind> convertActionConditionKind(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionConditionKind> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.PlanDefinition.ActionConditionKind> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.PlanDefinition.ActionConditionKindEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case APPLICABILITY:
        tgt.setValue(org.hl7.fhir.r4.model.PlanDefinition.ActionConditionKind.APPLICABILITY);
        break;
      case START:
        tgt.setValue(org.hl7.fhir.r4.model.PlanDefinition.ActionConditionKind.START);
        break;
      case STOP:
        tgt.setValue(org.hl7.fhir.r4.model.PlanDefinition.ActionConditionKind.STOP);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.PlanDefinition.ActionConditionKind.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionActionRelatedActionComponent convertPlanDefinitionActionRelatedActionComponent(org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionRelatedActionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionActionRelatedActionComponent tgt = new org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionActionRelatedActionComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasActionId())
      tgt.setTargetIdElement(Id40_50.convertId(src.getActionIdElement()));
    if (src.hasRelationship())
      tgt.setRelationshipElement(convertActionRelationshipType(src.getRelationshipElement()));
    if (src.hasOffset())
      tgt.setOffset(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getOffset()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionRelatedActionComponent convertPlanDefinitionActionRelatedActionComponent(org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionActionRelatedActionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionRelatedActionComponent tgt = new org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionRelatedActionComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasTargetId())
      tgt.setActionIdElement(Id40_50.convertId(src.getTargetIdElement()));
    if (src.hasRelationship())
      tgt.setRelationshipElement(convertActionRelationshipType(src.getRelationshipElement()));
    if (src.hasOffset())
      tgt.setOffset(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getOffset()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionRelationshipType> convertActionRelationshipType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.PlanDefinition.ActionRelationshipType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionRelationshipType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.ActionRelationshipTypeEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.PlanDefinition.ActionRelationshipType> convertActionRelationshipType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionRelationshipType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.PlanDefinition.ActionRelationshipType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.PlanDefinition.ActionRelationshipTypeEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case BEFORESTART:
        tgt.setValue(org.hl7.fhir.r4.model.PlanDefinition.ActionRelationshipType.BEFORESTART);
        break;
      case BEFORE:
        tgt.setValue(org.hl7.fhir.r4.model.PlanDefinition.ActionRelationshipType.BEFORE);
        break;
      case BEFOREEND:
        tgt.setValue(org.hl7.fhir.r4.model.PlanDefinition.ActionRelationshipType.BEFOREEND);
        break;
      case CONCURRENTWITHSTART:
        tgt.setValue(org.hl7.fhir.r4.model.PlanDefinition.ActionRelationshipType.CONCURRENTWITHSTART);
        break;
      case CONCURRENT:
        tgt.setValue(org.hl7.fhir.r4.model.PlanDefinition.ActionRelationshipType.CONCURRENT);
        break;
      case CONCURRENTWITHEND:
        tgt.setValue(org.hl7.fhir.r4.model.PlanDefinition.ActionRelationshipType.CONCURRENTWITHEND);
        break;
      case AFTERSTART:
        tgt.setValue(org.hl7.fhir.r4.model.PlanDefinition.ActionRelationshipType.AFTERSTART);
        break;
      case AFTER:
        tgt.setValue(org.hl7.fhir.r4.model.PlanDefinition.ActionRelationshipType.AFTER);
        break;
      case AFTEREND:
        tgt.setValue(org.hl7.fhir.r4.model.PlanDefinition.ActionRelationshipType.AFTEREND);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.PlanDefinition.ActionRelationshipType.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionActionParticipantComponent convertPlanDefinitionActionParticipantComponent(org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionParticipantComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionActionParticipantComponent tgt = new org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionActionParticipantComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setTypeElement(convertActionParticipantType(src.getTypeElement()));
    if (src.hasRole())
      tgt.setRole(CodeableConcept40_50.convertCodeableConcept(src.getRole()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionParticipantComponent convertPlanDefinitionActionParticipantComponent(org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionActionParticipantComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionParticipantComponent tgt = new org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionParticipantComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setTypeElement(convertActionParticipantType(src.getTypeElement()));
    if (src.hasRole())
      tgt.setRole(CodeableConcept40_50.convertCodeableConcept(src.getRole()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionParticipantType> convertActionParticipantType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.PlanDefinition.ActionParticipantType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionParticipantType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.ActionParticipantTypeEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case PATIENT:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionParticipantType.PATIENT);
        break;
      case PRACTITIONER:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionParticipantType.PRACTITIONER);
        break;
      case RELATEDPERSON:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionParticipantType.RELATEDPERSON);
        break;
      case DEVICE:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionParticipantType.DEVICE);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ActionParticipantType.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.PlanDefinition.ActionParticipantType> convertActionParticipantType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionParticipantType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.PlanDefinition.ActionParticipantType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.PlanDefinition.ActionParticipantTypeEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case PATIENT:
        tgt.setValue(org.hl7.fhir.r4.model.PlanDefinition.ActionParticipantType.PATIENT);
        break;
      case PRACTITIONER:
        tgt.setValue(org.hl7.fhir.r4.model.PlanDefinition.ActionParticipantType.PRACTITIONER);
        break;
      case RELATEDPERSON:
        tgt.setValue(org.hl7.fhir.r4.model.PlanDefinition.ActionParticipantType.RELATEDPERSON);
        break;
      case DEVICE:
        tgt.setValue(org.hl7.fhir.r4.model.PlanDefinition.ActionParticipantType.DEVICE);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.PlanDefinition.ActionParticipantType.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionActionDynamicValueComponent convertPlanDefinitionActionDynamicValueComponent(org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionDynamicValueComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionActionDynamicValueComponent tgt = new org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionActionDynamicValueComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasPath())
      tgt.setPathElement(String40_50.convertString(src.getPathElement()));
    if (src.hasExpression())
      tgt.setExpression(Expression40_50.convertExpression(src.getExpression()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionDynamicValueComponent convertPlanDefinitionActionDynamicValueComponent(org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionActionDynamicValueComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionDynamicValueComponent tgt = new org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionDynamicValueComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasPath())
      tgt.setPathElement(String40_50.convertString(src.getPathElement()));
    if (src.hasExpression())
      tgt.setExpression(Expression40_50.convertExpression(src.getExpression()));
    return tgt;
  }
}