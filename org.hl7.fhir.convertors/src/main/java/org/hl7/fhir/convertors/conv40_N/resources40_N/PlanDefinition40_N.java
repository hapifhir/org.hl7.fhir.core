package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Duration40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Identifier40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Period40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.metadata40_N.ContactDetail40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.metadata40_N.DataRequirement40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.metadata40_N.Expression40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.metadata40_N.RelatedArtifact40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.metadata40_N.TriggerDefinition40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.metadata40_N.UsageContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Boolean40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Canonical40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Date40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.DateTime40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Id40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.MarkDown40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.String40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Uri40_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.PlanDefinition;
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

public class PlanDefinition40_N {

  public static org.hl7.fhir.model.core.PlanDefinition convertPlanDefinition(org.hl7.fhir.r4.model.PlanDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.PlanDefinition tgt = new org.hl7.fhir.model.core.PlanDefinition();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri40_N.convertUri(src.getUrlElement()));
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    if (src.hasVersion())
      tgt.setVersionElement(String40_N.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String40_N.convertString(src.getTitleElement()));
    if (src.hasSubtitle())
      tgt.setSubtitleElement(String40_N.convertString(src.getSubtitleElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations40_N.convertPublicationStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean40_N.convertBoolean(src.getExperimentalElement()));
    if (src.hasSubject())
      tgt.setSubject(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getSubject()));
    if (src.hasDate())
      tgt.setDateElement(DateTime40_N.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String40_N.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.r4.model.ContactDetail t : src.getContact())
      tgt.addContact(ContactDetail40_N.convertContactDetail(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown40_N.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r4.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(UsageContext40_N.convertUsageContext(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasPurpose())
      tgt.setPurposeElement(MarkDown40_N.convertMarkdown(src.getPurposeElement()));
    if (src.hasUsage())
      tgt.setUsageElement(String40_N.convertStringToMarkdown(src.getUsageElement()));
    if (src.hasCopyright())
      tgt.setCopyrightElement(MarkDown40_N.convertMarkdown(src.getCopyrightElement()));
    if (src.hasApprovalDate())
      tgt.setApprovalDateElement(Date40_N.convertDate(src.getApprovalDateElement()));
    if (src.hasLastReviewDate())
      tgt.setLastReviewDateElement(Date40_N.convertDate(src.getLastReviewDateElement()));
    if (src.hasEffectivePeriod())
      tgt.setEffectivePeriod(Period40_N.convertPeriod(src.getEffectivePeriod()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getTopic())
      tgt.addTopic(CodeableConcept40_N.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.ContactDetail t : src.getAuthor())
      tgt.addAuthor(ContactDetail40_N.convertContactDetail(t));
    for (org.hl7.fhir.r4.model.ContactDetail t : src.getEditor())
      tgt.addEditor(ContactDetail40_N.convertContactDetail(t));
    for (org.hl7.fhir.r4.model.ContactDetail t : src.getReviewer())
      tgt.addReviewer(ContactDetail40_N.convertContactDetail(t));
    for (org.hl7.fhir.r4.model.ContactDetail t : src.getEndorser())
      tgt.addEndorser(ContactDetail40_N.convertContactDetail(t));
    for (org.hl7.fhir.r4.model.RelatedArtifact t : src.getRelatedArtifact())
      tgt.addRelatedArtifact(RelatedArtifact40_N.convertRelatedArtifact(t));
    for (org.hl7.fhir.r4.model.CanonicalType t : src.getLibrary())
      tgt.getLibraryList().add(Canonical40_N.convertCanonical(t));
    for (org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionGoalComponent t : src.getGoal())
      tgt.addGoal(convertPlanDefinitionGoalComponent(t));
    for (org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionComponent t : src.getAction())
      tgt.addAction(convertPlanDefinitionActionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.PlanDefinition convertPlanDefinition(org.hl7.fhir.model.core.PlanDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.PlanDefinition tgt = new org.hl7.fhir.r4.model.PlanDefinition();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri40_N.convertUri(src.getUrlElement()));
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    if (src.hasVersion())
      tgt.setVersionElement(String40_N.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String40_N.convertString(src.getTitleElement()));
    if (src.hasSubtitle())
      tgt.setSubtitleElement(String40_N.convertString(src.getSubtitleElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations40_N.convertPublicationStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean40_N.convertBoolean(src.getExperimentalElement()));
    if (src.hasSubject())
      tgt.setSubject(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getSubject()));
    if (src.hasDate())
      tgt.setDateElement(DateTime40_N.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String40_N.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.model.core.ContactDetail t : src.getContactList())
      tgt.addContact(ContactDetail40_N.convertContactDetail(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown40_N.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.model.core.UsageContext t : src.getUseContextList())
      tgt.addUseContext(UsageContext40_N.convertUsageContext(t));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getJurisdictionList())
      tgt.addJurisdiction(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasPurpose())
      tgt.setPurposeElement(MarkDown40_N.convertMarkdown(src.getPurposeElement()));
    if (src.hasUsage())
      tgt.setUsageElement(String40_N.convertString(src.getUsageElement()));
    if (src.hasCopyright())
      tgt.setCopyrightElement(MarkDown40_N.convertMarkdown(src.getCopyrightElement()));
    if (src.hasApprovalDate())
      tgt.setApprovalDateElement(Date40_N.convertDate(src.getApprovalDateElement()));
    if (src.hasLastReviewDate())
      tgt.setLastReviewDateElement(Date40_N.convertDate(src.getLastReviewDateElement()));
    if (src.hasEffectivePeriod())
      tgt.setEffectivePeriod(Period40_N.convertPeriod(src.getEffectivePeriod()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getTopicList())
      tgt.addTopic(CodeableConcept40_N.convertCodeableConcept(t));
    for (org.hl7.fhir.model.core.ContactDetail t : src.getAuthorList())
      tgt.addAuthor(ContactDetail40_N.convertContactDetail(t));
    for (org.hl7.fhir.model.core.ContactDetail t : src.getEditorList())
      tgt.addEditor(ContactDetail40_N.convertContactDetail(t));
    for (org.hl7.fhir.model.core.ContactDetail t : src.getReviewerList())
      tgt.addReviewer(ContactDetail40_N.convertContactDetail(t));
    for (org.hl7.fhir.model.core.ContactDetail t : src.getEndorserList())
      tgt.addEndorser(ContactDetail40_N.convertContactDetail(t));
    for (org.hl7.fhir.model.core.RelatedArtifact t : src.getRelatedArtifactList())
      tgt.addRelatedArtifact(RelatedArtifact40_N.convertRelatedArtifact(t));
    for (org.hl7.fhir.model.core.CanonicalType t : src.getLibraryList())
      tgt.getLibrary().add(Canonical40_N.convertCanonical(t));
    for (org.hl7.fhir.model.core.PlanDefinition.PlanDefinitionGoalComponent t : src.getGoalList())
      tgt.addGoal(convertPlanDefinitionGoalComponent(t));
    for (org.hl7.fhir.model.core.PlanDefinition.PlanDefinitionActionComponent t : src.getActionList())
      tgt.addAction(convertPlanDefinitionActionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.PlanDefinition.PlanDefinitionGoalComponent convertPlanDefinitionGoalComponent(org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionGoalComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.PlanDefinition.PlanDefinitionGoalComponent tgt = new org.hl7.fhir.model.core.PlanDefinition.PlanDefinitionGoalComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept40_N.convertCodeableConcept(src.getCategory()));
    if (src.hasDescription())
      tgt.setDescription(CodeableConcept40_N.convertCodeableConcept(src.getDescription()));
    if (src.hasPriority())
      tgt.setPriority(CodeableConcept40_N.convertCodeableConcept(src.getPriority()));
    if (src.hasStart())
      tgt.setStart(CodeableConcept40_N.convertCodeableConcept(src.getStart()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getAddresses())
      tgt.addAddresses(CodeableConcept40_N.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.RelatedArtifact t : src.getDocumentation())
      tgt.addDocumentation(RelatedArtifact40_N.convertRelatedArtifact(t));
    for (org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionGoalTargetComponent t : src.getTarget())
      tgt.addTarget(convertPlanDefinitionGoalTargetComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionGoalComponent convertPlanDefinitionGoalComponent(org.hl7.fhir.model.core.PlanDefinition.PlanDefinitionGoalComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionGoalComponent tgt = new org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionGoalComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept40_N.convertCodeableConcept(src.getCategory()));
    if (src.hasDescription())
      tgt.setDescription(CodeableConcept40_N.convertCodeableConcept(src.getDescription()));
    if (src.hasPriority())
      tgt.setPriority(CodeableConcept40_N.convertCodeableConcept(src.getPriority()));
    if (src.hasStart())
      tgt.setStart(CodeableConcept40_N.convertCodeableConcept(src.getStart()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getAddressesList())
      tgt.addAddresses(CodeableConcept40_N.convertCodeableConcept(t));
    for (org.hl7.fhir.model.core.RelatedArtifact t : src.getDocumentationList())
      tgt.addDocumentation(RelatedArtifact40_N.convertRelatedArtifact(t));
    for (org.hl7.fhir.model.core.PlanDefinition.PlanDefinitionGoalTargetComponent t : src.getTargetList())
      tgt.addTarget(convertPlanDefinitionGoalTargetComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.PlanDefinition.PlanDefinitionGoalTargetComponent convertPlanDefinitionGoalTargetComponent(org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionGoalTargetComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.PlanDefinition.PlanDefinitionGoalTargetComponent tgt = new org.hl7.fhir.model.core.PlanDefinition.PlanDefinitionGoalTargetComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasMeasure())
      tgt.setMeasure(CodeableConcept40_N.convertCodeableConcept(src.getMeasure()));
    if (src.hasDetail())
      tgt.setDetail(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getDetail()));
    if (src.hasDue())
      tgt.setDue(Duration40_N.convertDuration(src.getDue()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionGoalTargetComponent convertPlanDefinitionGoalTargetComponent(org.hl7.fhir.model.core.PlanDefinition.PlanDefinitionGoalTargetComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionGoalTargetComponent tgt = new org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionGoalTargetComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasMeasure())
      tgt.setMeasure(CodeableConcept40_N.convertCodeableConcept(src.getMeasure()));
    if (src.hasDetail())
      tgt.setDetail(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getDetail()));
    if (src.hasDue())
      tgt.setDue(Duration40_N.convertDuration(src.getDue()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.PlanDefinition.PlanDefinitionActionComponent convertPlanDefinitionActionComponent(org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.PlanDefinition.PlanDefinitionActionComponent tgt = new org.hl7.fhir.model.core.PlanDefinition.PlanDefinitionActionComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasPrefix())
      tgt.setPrefixElement(String40_N.convertString(src.getPrefixElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String40_N.convertString(src.getTitleElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_N.convertStringToMarkdown(src.getDescriptionElement()));
    if (src.hasTextEquivalent())
      tgt.setTextEquivalentElement(String40_N.convertStringToMarkdown(src.getTextEquivalentElement()));
    if (src.hasPriority())
      tgt.setPriorityElement(convertRequestPriority(src.getPriorityElement()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCode())
      tgt.setCode(CodeableConcept40_N.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReason())
      tgt.addReason(CodeableConcept40_N.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.RelatedArtifact t : src.getDocumentation())
      tgt.addDocumentation(RelatedArtifact40_N.convertRelatedArtifact(t));
    for (org.hl7.fhir.r4.model.IdType t : src.getGoalId()) tgt.getGoalIdList().add(Id40_N.convertIdToString(t));
    if (src.hasSubject())
      tgt.setSubject(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getSubject()));
    for (org.hl7.fhir.r4.model.TriggerDefinition t : src.getTrigger())
      tgt.addTrigger(TriggerDefinition40_N.convertTriggerDefinition(t));
    for (org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionConditionComponent t : src.getCondition())
      tgt.addCondition(convertPlanDefinitionActionConditionComponent(t));
    for (org.hl7.fhir.r4.model.DataRequirement t : src.getInput())
      tgt.addInput(wrapInput(DataRequirement40_N.convertDataRequirement(t)));
    for (org.hl7.fhir.r4.model.DataRequirement t : src.getOutput())
      tgt.addOutput(wrapOutput(DataRequirement40_N.convertDataRequirement(t)));
    for (org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionRelatedActionComponent t : src.getRelatedAction())
      tgt.addRelatedAction(convertPlanDefinitionActionRelatedActionComponent(t));
    if (src.hasTiming())
      tgt.setTiming(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getTiming()));
    for (org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionParticipantComponent t : src.getParticipant())
      tgt.addParticipant(convertPlanDefinitionActionParticipantComponent(t));
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
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
      tgt.setDefinition(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getDefinition()));
    if (src.hasTransform())
      tgt.setTransformElement(Canonical40_N.convertCanonical(src.getTransformElement()));
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

  public static org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionComponent convertPlanDefinitionActionComponent(org.hl7.fhir.model.core.PlanDefinition.PlanDefinitionActionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionComponent tgt = new org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasPrefix())
      tgt.setPrefixElement(String40_N.convertString(src.getPrefixElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String40_N.convertString(src.getTitleElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_N.convertString(src.getDescriptionElement()));
    if (src.hasTextEquivalent())
      tgt.setTextEquivalentElement(String40_N.convertString(src.getTextEquivalentElement()));
    if (src.hasPriority())
      tgt.setPriorityElement(convertRequestPriority(src.getPriorityElement()));
    if (src.hasCode()) tgt.addCode(CodeableConcept40_N.convertCodeableConcept(src.getCode()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getReasonList())
      tgt.addReason(CodeableConcept40_N.convertCodeableConcept(t));
    for (org.hl7.fhir.model.core.RelatedArtifact t : src.getDocumentationList())
      tgt.addDocumentation(RelatedArtifact40_N.convertRelatedArtifact(t));
    for (org.hl7.fhir.model.core.StringType t : src.getGoalIdList()) tgt.getGoalId().add(Id40_N.convertId(t));
    if (src.hasSubject())
      tgt.setSubject(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getSubject()));
    for (org.hl7.fhir.model.core.TriggerDefinition t : src.getTriggerList())
      tgt.addTrigger(TriggerDefinition40_N.convertTriggerDefinition(t));
    for (org.hl7.fhir.model.core.PlanDefinition.PlanDefinitionActionConditionComponent t : src.getConditionList())
      tgt.addCondition(convertPlanDefinitionActionConditionComponent(t));
    for (PlanDefinitionActionInputComponent t : src.getInputList())
      tgt.addInput(DataRequirement40_N.convertDataRequirement(t.getRequirement()));
    for (PlanDefinitionActionOutputComponent t : src.getOutputList())
      tgt.addOutput(DataRequirement40_N.convertDataRequirement(t.getRequirement()));
    for (org.hl7.fhir.model.core.PlanDefinition.PlanDefinitionActionRelatedActionComponent t : src.getRelatedActionList())
      tgt.addRelatedAction(convertPlanDefinitionActionRelatedActionComponent(t));
    if (src.hasTiming())
      tgt.setTiming(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getTiming()));
    for (org.hl7.fhir.model.core.PlanDefinition.PlanDefinitionActionParticipantComponent t : src.getParticipantList())
      tgt.addParticipant(convertPlanDefinitionActionParticipantComponent(t));
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
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
      tgt.setDefinition(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getDefinition()));
    if (src.hasTransform())
      tgt.setTransformElement(Canonical40_N.convertCanonical(src.getTransformElement()));
    for (org.hl7.fhir.model.core.PlanDefinition.PlanDefinitionActionDynamicValueComponent t : src.getDynamicValueList())
      tgt.addDynamicValue(convertPlanDefinitionActionDynamicValueComponent(t));
    for (org.hl7.fhir.model.core.PlanDefinition.PlanDefinitionActionComponent t : src.getActionList())
      tgt.addAction(convertPlanDefinitionActionComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.RequestPriority> convertRequestPriority(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.PlanDefinition.RequestPriority> src) throws FHIRException {
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.PlanDefinition.RequestPriority> convertRequestPriority(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.RequestPriority> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<PlanDefinition.RequestPriority> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new PlanDefinition.RequestPriorityEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case ROUTINE:
                  tgt.setValue(PlanDefinition.RequestPriority.ROUTINE);
                  break;
              case URGENT:
                  tgt.setValue(PlanDefinition.RequestPriority.URGENT);
                  break;
              case ASAP:
                  tgt.setValue(PlanDefinition.RequestPriority.ASAP);
                  break;
              case STAT:
                  tgt.setValue(PlanDefinition.RequestPriority.STAT);
                  break;
              default:
                  tgt.setValue(PlanDefinition.RequestPriority.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ActionGroupingBehavior> convertActionGroupingBehavior(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.PlanDefinition.ActionGroupingBehavior> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Enumerations.ActionGroupingBehavior> tgt = new Enumeration<>(new Enumerations.ActionGroupingBehaviorEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.PlanDefinition.ActionGroupingBehavior> convertActionGroupingBehavior(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ActionGroupingBehavior> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<PlanDefinition.ActionGroupingBehavior> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new PlanDefinition.ActionGroupingBehaviorEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case VISUALGROUP:
                  tgt.setValue(PlanDefinition.ActionGroupingBehavior.VISUALGROUP);
                  break;
              case LOGICALGROUP:
                  tgt.setValue(PlanDefinition.ActionGroupingBehavior.LOGICALGROUP);
                  break;
              case SENTENCEGROUP:
                  tgt.setValue(PlanDefinition.ActionGroupingBehavior.SENTENCEGROUP);
                  break;
              default:
                  tgt.setValue(PlanDefinition.ActionGroupingBehavior.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ActionSelectionBehavior> convertActionSelectionBehavior(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.PlanDefinition.ActionSelectionBehavior> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Enumerations.ActionSelectionBehavior> tgt = new Enumeration<>(new Enumerations.ActionSelectionBehaviorEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.PlanDefinition.ActionSelectionBehavior> convertActionSelectionBehavior(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ActionSelectionBehavior> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<PlanDefinition.ActionSelectionBehavior> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new PlanDefinition.ActionSelectionBehaviorEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case ANY:
                  tgt.setValue(PlanDefinition.ActionSelectionBehavior.ANY);
                  break;
              case ALL:
                  tgt.setValue(PlanDefinition.ActionSelectionBehavior.ALL);
                  break;
              case ALLORNONE:
                  tgt.setValue(PlanDefinition.ActionSelectionBehavior.ALLORNONE);
                  break;
              case EXACTLYONE:
                  tgt.setValue(PlanDefinition.ActionSelectionBehavior.EXACTLYONE);
                  break;
              case ATMOSTONE:
                  tgt.setValue(PlanDefinition.ActionSelectionBehavior.ATMOSTONE);
                  break;
              case ONEORMORE:
                  tgt.setValue(PlanDefinition.ActionSelectionBehavior.ONEORMORE);
                  break;
              default:
                  tgt.setValue(PlanDefinition.ActionSelectionBehavior.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ActionRequiredBehavior> convertActionRequiredBehavior(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.PlanDefinition.ActionRequiredBehavior> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Enumerations.ActionRequiredBehavior> tgt = new Enumeration<>(new Enumerations.ActionRequiredBehaviorEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.PlanDefinition.ActionRequiredBehavior> convertActionRequiredBehavior(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ActionRequiredBehavior> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<PlanDefinition.ActionRequiredBehavior> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new PlanDefinition.ActionRequiredBehaviorEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case MUST:
                  tgt.setValue(PlanDefinition.ActionRequiredBehavior.MUST);
                  break;
              case COULD:
                  tgt.setValue(PlanDefinition.ActionRequiredBehavior.COULD);
                  break;
              case MUSTUNLESSDOCUMENTED:
                  tgt.setValue(PlanDefinition.ActionRequiredBehavior.MUSTUNLESSDOCUMENTED);
                  break;
              default:
                  tgt.setValue(PlanDefinition.ActionRequiredBehavior.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ActionPrecheckBehavior> convertActionPrecheckBehavior(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.PlanDefinition.ActionPrecheckBehavior> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Enumerations.ActionPrecheckBehavior> tgt = new Enumeration<>(new Enumerations.ActionPrecheckBehaviorEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.PlanDefinition.ActionPrecheckBehavior> convertActionPrecheckBehavior(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ActionPrecheckBehavior> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<PlanDefinition.ActionPrecheckBehavior> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new PlanDefinition.ActionPrecheckBehaviorEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case YES:
                  tgt.setValue(PlanDefinition.ActionPrecheckBehavior.YES);
                  break;
              case NO:
                  tgt.setValue(PlanDefinition.ActionPrecheckBehavior.NO);
                  break;
              default:
                  tgt.setValue(PlanDefinition.ActionPrecheckBehavior.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ActionCardinalityBehavior> convertActionCardinalityBehavior(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.PlanDefinition.ActionCardinalityBehavior> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Enumerations.ActionCardinalityBehavior> tgt = new Enumeration<>(new Enumerations.ActionCardinalityBehaviorEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.PlanDefinition.ActionCardinalityBehavior> convertActionCardinalityBehavior(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ActionCardinalityBehavior> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<PlanDefinition.ActionCardinalityBehavior> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new PlanDefinition.ActionCardinalityBehaviorEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case SINGLE:
                  tgt.setValue(PlanDefinition.ActionCardinalityBehavior.SINGLE);
                  break;
              case MULTIPLE:
                  tgt.setValue(PlanDefinition.ActionCardinalityBehavior.MULTIPLE);
                  break;
              default:
                  tgt.setValue(PlanDefinition.ActionCardinalityBehavior.NULL);
                  break;
          }
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.PlanDefinition.PlanDefinitionActionConditionComponent convertPlanDefinitionActionConditionComponent(org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionConditionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.PlanDefinition.PlanDefinitionActionConditionComponent tgt = new org.hl7.fhir.model.core.PlanDefinition.PlanDefinitionActionConditionComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasKind())
      tgt.setKindElement(convertActionConditionKind(src.getKindElement()));
    if (src.hasExpression())
      tgt.setExpression(Expression40_N.convertExpression(src.getExpression()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionConditionComponent convertPlanDefinitionActionConditionComponent(org.hl7.fhir.model.core.PlanDefinition.PlanDefinitionActionConditionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionConditionComponent tgt = new org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionConditionComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasKind())
      tgt.setKindElement(convertActionConditionKind(src.getKindElement()));
    if (src.hasExpression())
      tgt.setExpression(Expression40_N.convertExpression(src.getExpression()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ActionConditionKind> convertActionConditionKind(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.PlanDefinition.ActionConditionKind> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Enumerations.ActionConditionKind> tgt = new Enumeration<>(new Enumerations.ActionConditionKindEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.PlanDefinition.ActionConditionKind> convertActionConditionKind(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ActionConditionKind> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<PlanDefinition.ActionConditionKind> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new PlanDefinition.ActionConditionKindEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case APPLICABILITY:
                  tgt.setValue(PlanDefinition.ActionConditionKind.APPLICABILITY);
                  break;
              case START:
                  tgt.setValue(PlanDefinition.ActionConditionKind.START);
                  break;
              case STOP:
                  tgt.setValue(PlanDefinition.ActionConditionKind.STOP);
                  break;
              default:
                  tgt.setValue(PlanDefinition.ActionConditionKind.NULL);
                  break;
          }
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.PlanDefinition.PlanDefinitionActionRelatedActionComponent convertPlanDefinitionActionRelatedActionComponent(org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionRelatedActionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.PlanDefinition.PlanDefinitionActionRelatedActionComponent tgt = new org.hl7.fhir.model.core.PlanDefinition.PlanDefinitionActionRelatedActionComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasActionId())
      tgt.setTargetIdElement(Id40_N.convertIdToString(src.getActionIdElement()));
    if (src.hasRelationship())
      tgt.setRelationshipElement(convertActionRelationshipType(src.getRelationshipElement()));
    if (src.hasOffset())
      tgt.setOffset(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getOffset()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionRelatedActionComponent convertPlanDefinitionActionRelatedActionComponent(org.hl7.fhir.model.core.PlanDefinition.PlanDefinitionActionRelatedActionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionRelatedActionComponent tgt = new org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionRelatedActionComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasTargetId())
      tgt.setActionIdElement(Id40_N.convertId(src.getTargetIdElement()));
    if (src.hasRelationship())
      tgt.setRelationshipElement(convertActionRelationshipType(src.getRelationshipElement()));
    if (src.hasOffset())
      tgt.setOffset(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getOffset()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ActionRelationshipType> convertActionRelationshipType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.PlanDefinition.ActionRelationshipType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Enumerations.ActionRelationshipType> tgt = new Enumeration<>(new Enumerations.ActionRelationshipTypeEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.PlanDefinition.ActionRelationshipType> convertActionRelationshipType(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ActionRelationshipType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<PlanDefinition.ActionRelationshipType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new PlanDefinition.ActionRelationshipTypeEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case BEFORESTART:
                  tgt.setValue(PlanDefinition.ActionRelationshipType.BEFORESTART);
                  break;
              case BEFORE:
                  tgt.setValue(PlanDefinition.ActionRelationshipType.BEFORE);
                  break;
              case BEFOREEND:
                  tgt.setValue(PlanDefinition.ActionRelationshipType.BEFOREEND);
                  break;
              case CONCURRENTWITHSTART:
                  tgt.setValue(PlanDefinition.ActionRelationshipType.CONCURRENTWITHSTART);
                  break;
              case CONCURRENT:
                  tgt.setValue(PlanDefinition.ActionRelationshipType.CONCURRENT);
                  break;
              case CONCURRENTWITHEND:
                  tgt.setValue(PlanDefinition.ActionRelationshipType.CONCURRENTWITHEND);
                  break;
              case AFTERSTART:
                  tgt.setValue(PlanDefinition.ActionRelationshipType.AFTERSTART);
                  break;
              case AFTER:
                  tgt.setValue(PlanDefinition.ActionRelationshipType.AFTER);
                  break;
              case AFTEREND:
                  tgt.setValue(PlanDefinition.ActionRelationshipType.AFTEREND);
                  break;
              default:
                  tgt.setValue(PlanDefinition.ActionRelationshipType.NULL);
                  break;
          }
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.PlanDefinition.PlanDefinitionActionParticipantComponent convertPlanDefinitionActionParticipantComponent(org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionParticipantComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.PlanDefinition.PlanDefinitionActionParticipantComponent tgt = new org.hl7.fhir.model.core.PlanDefinition.PlanDefinitionActionParticipantComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setTypeElement(convertActionParticipantType(src.getTypeElement()));
    if (src.hasRole())
      tgt.setRole(CodeableConcept40_N.convertCodeableConcept(src.getRole()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionParticipantComponent convertPlanDefinitionActionParticipantComponent(org.hl7.fhir.model.core.PlanDefinition.PlanDefinitionActionParticipantComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionParticipantComponent tgt = new org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionParticipantComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setTypeElement(convertActionParticipantType(src.getTypeElement()));
    if (src.hasRole())
      tgt.setRole(CodeableConcept40_N.convertCodeableConcept(src.getRole()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ActionParticipantType> convertActionParticipantType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.PlanDefinition.ActionParticipantType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Enumerations.ActionParticipantType> tgt = new Enumeration<>(new Enumerations.ActionParticipantTypeEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.PlanDefinition.ActionParticipantType> convertActionParticipantType(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ActionParticipantType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<PlanDefinition.ActionParticipantType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new PlanDefinition.ActionParticipantTypeEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case PATIENT:
                  tgt.setValue(PlanDefinition.ActionParticipantType.PATIENT);
                  break;
              case PRACTITIONER:
                  tgt.setValue(PlanDefinition.ActionParticipantType.PRACTITIONER);
                  break;
              case RELATEDPERSON:
                  tgt.setValue(PlanDefinition.ActionParticipantType.RELATEDPERSON);
                  break;
              case DEVICE:
                  tgt.setValue(PlanDefinition.ActionParticipantType.DEVICE);
                  break;
              default:
                  tgt.setValue(PlanDefinition.ActionParticipantType.NULL);
                  break;
          }
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.PlanDefinition.PlanDefinitionActionDynamicValueComponent convertPlanDefinitionActionDynamicValueComponent(org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionDynamicValueComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.PlanDefinition.PlanDefinitionActionDynamicValueComponent tgt = new org.hl7.fhir.model.core.PlanDefinition.PlanDefinitionActionDynamicValueComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasPath())
      tgt.setPathElement(String40_N.convertString(src.getPathElement()));
    if (src.hasExpression())
      tgt.setExpression(Expression40_N.convertExpression(src.getExpression()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionDynamicValueComponent convertPlanDefinitionActionDynamicValueComponent(org.hl7.fhir.model.core.PlanDefinition.PlanDefinitionActionDynamicValueComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionDynamicValueComponent tgt = new org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionDynamicValueComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasPath())
      tgt.setPathElement(String40_N.convertString(src.getPathElement()));
    if (src.hasExpression())
      tgt.setExpression(Expression40_N.convertExpression(src.getExpression()));
    return tgt;
  }
}