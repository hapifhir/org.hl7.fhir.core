package org.hl7.fhir.convertors.conv40_50;

/*-
 * #%L
 * org.hl7.fhir.convertors
 * %%
 * Copyright (C) 2014 - 2019 Health Level 7
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
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
public class PlanDefinition extends VersionConvertor_40_50 {

    public static org.hl7.fhir.r5.model.PlanDefinition convertPlanDefinition(org.hl7.fhir.r4.model.PlanDefinition src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.PlanDefinition tgt = new org.hl7.fhir.r5.model.PlanDefinition();
        copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrlElement(convertUri(src.getUrlElement()));
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        }
        if (src.hasVersion())
            tgt.setVersionElement(convertString(src.getVersionElement()));
        if (src.hasName())
            tgt.setNameElement(convertString(src.getNameElement()));
        if (src.hasTitle())
            tgt.setTitleElement(convertString(src.getTitleElement()));
        if (src.hasSubtitle())
            tgt.setSubtitleElement(convertString(src.getSubtitleElement()));
        if (src.hasType())
            tgt.setType(convertCodeableConcept(src.getType()));
        if (src.hasStatus())
            tgt.setStatus(Enumerations.convertPublicationStatus(src.getStatus()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(convertBoolean(src.getExperimentalElement()));
        if (src.hasSubject())
            tgt.setSubject(convertType(src.getSubject()));
        if (src.hasDate())
            tgt.setDateElement(convertDateTime(src.getDateElement()));
        if (src.hasPublisher())
            tgt.setPublisherElement(convertString(src.getPublisherElement()));
        if (src.hasContact()) {
            for (org.hl7.fhir.r4.model.ContactDetail t : src.getContact()) tgt.addContact(convertContactDetail(t));
        }
        if (src.hasDescription())
            tgt.setDescriptionElement(convertMarkdown(src.getDescriptionElement()));
        if (src.hasUseContext()) {
            for (org.hl7.fhir.r4.model.UsageContext t : src.getUseContext()) tgt.addUseContext(convertUsageContext(t));
        }
        if (src.hasJurisdiction()) {
            for (org.hl7.fhir.r4.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(convertCodeableConcept(t));
        }
        if (src.hasPurpose())
            tgt.setPurposeElement(convertMarkdown(src.getPurposeElement()));
        if (src.hasUsage())
            tgt.setUsageElement(convertString(src.getUsageElement()));
        if (src.hasCopyright())
            tgt.setCopyrightElement(convertMarkdown(src.getCopyrightElement()));
        if (src.hasApprovalDate())
            tgt.setApprovalDateElement(convertDate(src.getApprovalDateElement()));
        if (src.hasLastReviewDate())
            tgt.setLastReviewDateElement(convertDate(src.getLastReviewDateElement()));
        if (src.hasEffectivePeriod())
            tgt.setEffectivePeriod(convertPeriod(src.getEffectivePeriod()));
        if (src.hasTopic()) {
            for (org.hl7.fhir.r4.model.CodeableConcept t : src.getTopic()) tgt.addTopic(convertCodeableConcept(t));
        }
        if (src.hasAuthor()) {
            for (org.hl7.fhir.r4.model.ContactDetail t : src.getAuthor()) tgt.addAuthor(convertContactDetail(t));
        }
        if (src.hasEditor()) {
            for (org.hl7.fhir.r4.model.ContactDetail t : src.getEditor()) tgt.addEditor(convertContactDetail(t));
        }
        if (src.hasReviewer()) {
            for (org.hl7.fhir.r4.model.ContactDetail t : src.getReviewer()) tgt.addReviewer(convertContactDetail(t));
        }
        if (src.hasEndorser()) {
            for (org.hl7.fhir.r4.model.ContactDetail t : src.getEndorser()) tgt.addEndorser(convertContactDetail(t));
        }
        if (src.hasRelatedArtifact()) {
            for (org.hl7.fhir.r4.model.RelatedArtifact t : src.getRelatedArtifact()) tgt.addRelatedArtifact(convertRelatedArtifact(t));
        }
        if (src.hasLibrary()) {
            for (org.hl7.fhir.r4.model.CanonicalType t : src.getLibrary()) tgt.getLibrary().add(convertCanonical(t));
        }
        if (src.hasGoal()) {
            for (org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionGoalComponent t : src.getGoal()) tgt.addGoal(convertPlanDefinitionGoalComponent(t));
        }
        if (src.hasAction()) {
            for (org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionComponent t : src.getAction()) tgt.addAction(convertPlanDefinitionActionComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.PlanDefinition convertPlanDefinition(org.hl7.fhir.r5.model.PlanDefinition src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.PlanDefinition tgt = new org.hl7.fhir.r4.model.PlanDefinition();
        copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrlElement(convertUri(src.getUrlElement()));
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        }
        if (src.hasVersion())
            tgt.setVersionElement(convertString(src.getVersionElement()));
        if (src.hasName())
            tgt.setNameElement(convertString(src.getNameElement()));
        if (src.hasTitle())
            tgt.setTitleElement(convertString(src.getTitleElement()));
        if (src.hasSubtitle())
            tgt.setSubtitleElement(convertString(src.getSubtitleElement()));
        if (src.hasType())
            tgt.setType(convertCodeableConcept(src.getType()));
        if (src.hasStatus())
            tgt.setStatus(Enumerations.convertPublicationStatus(src.getStatus()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(convertBoolean(src.getExperimentalElement()));
        if (src.hasSubject())
            tgt.setSubject(convertType(src.getSubject()));
        if (src.hasDate())
            tgt.setDateElement(convertDateTime(src.getDateElement()));
        if (src.hasPublisher())
            tgt.setPublisherElement(convertString(src.getPublisherElement()));
        if (src.hasContact()) {
            for (org.hl7.fhir.r5.model.ContactDetail t : src.getContact()) tgt.addContact(convertContactDetail(t));
        }
        if (src.hasDescription())
            tgt.setDescriptionElement(convertMarkdown(src.getDescriptionElement()));
        if (src.hasUseContext()) {
            for (org.hl7.fhir.r5.model.UsageContext t : src.getUseContext()) tgt.addUseContext(convertUsageContext(t));
        }
        if (src.hasJurisdiction()) {
            for (org.hl7.fhir.r5.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(convertCodeableConcept(t));
        }
        if (src.hasPurpose())
            tgt.setPurposeElement(convertMarkdown(src.getPurposeElement()));
        if (src.hasUsage())
            tgt.setUsageElement(convertString(src.getUsageElement()));
        if (src.hasCopyright())
            tgt.setCopyrightElement(convertMarkdown(src.getCopyrightElement()));
        if (src.hasApprovalDate())
            tgt.setApprovalDateElement(convertDate(src.getApprovalDateElement()));
        if (src.hasLastReviewDate())
            tgt.setLastReviewDateElement(convertDate(src.getLastReviewDateElement()));
        if (src.hasEffectivePeriod())
            tgt.setEffectivePeriod(convertPeriod(src.getEffectivePeriod()));
        if (src.hasTopic()) {
            for (org.hl7.fhir.r5.model.CodeableConcept t : src.getTopic()) tgt.addTopic(convertCodeableConcept(t));
        }
        if (src.hasAuthor()) {
            for (org.hl7.fhir.r5.model.ContactDetail t : src.getAuthor()) tgt.addAuthor(convertContactDetail(t));
        }
        if (src.hasEditor()) {
            for (org.hl7.fhir.r5.model.ContactDetail t : src.getEditor()) tgt.addEditor(convertContactDetail(t));
        }
        if (src.hasReviewer()) {
            for (org.hl7.fhir.r5.model.ContactDetail t : src.getReviewer()) tgt.addReviewer(convertContactDetail(t));
        }
        if (src.hasEndorser()) {
            for (org.hl7.fhir.r5.model.ContactDetail t : src.getEndorser()) tgt.addEndorser(convertContactDetail(t));
        }
        if (src.hasRelatedArtifact()) {
            for (org.hl7.fhir.r5.model.RelatedArtifact t : src.getRelatedArtifact()) tgt.addRelatedArtifact(convertRelatedArtifact(t));
        }
        if (src.hasLibrary()) {
            for (org.hl7.fhir.r5.model.CanonicalType t : src.getLibrary()) tgt.getLibrary().add(convertCanonical(t));
        }
        if (src.hasGoal()) {
            for (org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionGoalComponent t : src.getGoal()) tgt.addGoal(convertPlanDefinitionGoalComponent(t));
        }
        if (src.hasAction()) {
            for (org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionActionComponent t : src.getAction()) tgt.addAction(convertPlanDefinitionActionComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionGoalComponent convertPlanDefinitionGoalComponent(org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionGoalComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionGoalComponent tgt = new org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionGoalComponent();
        copyElement(src, tgt);
        if (src.hasCategory())
            tgt.setCategory(convertCodeableConcept(src.getCategory()));
        if (src.hasDescription())
            tgt.setDescription(convertCodeableConcept(src.getDescription()));
        if (src.hasPriority())
            tgt.setPriority(convertCodeableConcept(src.getPriority()));
        if (src.hasStart())
            tgt.setStart(convertCodeableConcept(src.getStart()));
        if (src.hasAddresses()) {
            for (org.hl7.fhir.r4.model.CodeableConcept t : src.getAddresses()) tgt.addAddresses(convertCodeableConcept(t));
        }
        if (src.hasDocumentation()) {
            for (org.hl7.fhir.r4.model.RelatedArtifact t : src.getDocumentation()) tgt.addDocumentation(convertRelatedArtifact(t));
        }
        if (src.hasTarget()) {
            for (org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionGoalTargetComponent t : src.getTarget()) tgt.addTarget(convertPlanDefinitionGoalTargetComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionGoalComponent convertPlanDefinitionGoalComponent(org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionGoalComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionGoalComponent tgt = new org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionGoalComponent();
        copyElement(src, tgt);
        if (src.hasCategory())
            tgt.setCategory(convertCodeableConcept(src.getCategory()));
        if (src.hasDescription())
            tgt.setDescription(convertCodeableConcept(src.getDescription()));
        if (src.hasPriority())
            tgt.setPriority(convertCodeableConcept(src.getPriority()));
        if (src.hasStart())
            tgt.setStart(convertCodeableConcept(src.getStart()));
        if (src.hasAddresses()) {
            for (org.hl7.fhir.r5.model.CodeableConcept t : src.getAddresses()) tgt.addAddresses(convertCodeableConcept(t));
        }
        if (src.hasDocumentation()) {
            for (org.hl7.fhir.r5.model.RelatedArtifact t : src.getDocumentation()) tgt.addDocumentation(convertRelatedArtifact(t));
        }
        if (src.hasTarget()) {
            for (org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionGoalTargetComponent t : src.getTarget()) tgt.addTarget(convertPlanDefinitionGoalTargetComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionGoalTargetComponent convertPlanDefinitionGoalTargetComponent(org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionGoalTargetComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionGoalTargetComponent tgt = new org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionGoalTargetComponent();
        copyElement(src, tgt);
        if (src.hasMeasure())
            tgt.setMeasure(convertCodeableConcept(src.getMeasure()));
        if (src.hasDetail())
            tgt.setDetail(convertType(src.getDetail()));
        if (src.hasDue())
            tgt.setDue(convertDuration(src.getDue()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionGoalTargetComponent convertPlanDefinitionGoalTargetComponent(org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionGoalTargetComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionGoalTargetComponent tgt = new org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionGoalTargetComponent();
        copyElement(src, tgt);
        if (src.hasMeasure())
            tgt.setMeasure(convertCodeableConcept(src.getMeasure()));
        if (src.hasDetail())
            tgt.setDetail(convertType(src.getDetail()));
        if (src.hasDue())
            tgt.setDue(convertDuration(src.getDue()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionActionComponent convertPlanDefinitionActionComponent(org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionActionComponent tgt = new org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionActionComponent();
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
        if (src.hasCode()) {
            for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCode()) tgt.addCode(convertCodeableConcept(t));
        }
        if (src.hasReason()) {
            for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReason()) tgt.addReason(convertCodeableConcept(t));
        }
        if (src.hasDocumentation()) {
            for (org.hl7.fhir.r4.model.RelatedArtifact t : src.getDocumentation()) tgt.addDocumentation(convertRelatedArtifact(t));
        }
        if (src.hasGoalId()) {
            for (org.hl7.fhir.r4.model.IdType t : src.getGoalId()) tgt.getGoalId().add(convertId(t));
        }
        if (src.hasSubject())
            tgt.setSubject(convertType(src.getSubject()));
        if (src.hasTrigger()) {
            for (org.hl7.fhir.r4.model.TriggerDefinition t : src.getTrigger()) tgt.addTrigger(convertTriggerDefinition(t));
        }
        if (src.hasCondition()) {
            for (org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionConditionComponent t : src.getCondition()) tgt.addCondition(convertPlanDefinitionActionConditionComponent(t));
        }
        if (src.hasInput()) {
            for (org.hl7.fhir.r4.model.DataRequirement t : src.getInput()) tgt.addInput(convertDataRequirement(t));
        }
        if (src.hasOutput()) {
            for (org.hl7.fhir.r4.model.DataRequirement t : src.getOutput()) tgt.addOutput(convertDataRequirement(t));
        }
        if (src.hasRelatedAction()) {
            for (org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionRelatedActionComponent t : src.getRelatedAction()) tgt.addRelatedAction(convertPlanDefinitionActionRelatedActionComponent(t));
        }
        if (src.hasTiming())
            tgt.setTiming(convertType(src.getTiming()));
        if (src.hasParticipant()) {
            for (org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionParticipantComponent t : src.getParticipant()) tgt.addParticipant(convertPlanDefinitionActionParticipantComponent(t));
        }
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
        // if (src.hasDefinition())
        // tgt.setDefinitionElement(convertType(src.getDefinitionElement()));
        if (src.hasTransform())
            tgt.setTransformElement(convertCanonical(src.getTransformElement()));
        if (src.hasDynamicValue()) {
            for (org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionDynamicValueComponent t : src.getDynamicValue()) tgt.addDynamicValue(convertPlanDefinitionActionDynamicValueComponent(t));
        }
        if (src.hasAction()) {
            for (org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionComponent t : src.getAction()) tgt.addAction(convertPlanDefinitionActionComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionComponent convertPlanDefinitionActionComponent(org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionActionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionComponent tgt = new org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionComponent();
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
        if (src.hasCode()) {
            for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCode()) tgt.addCode(convertCodeableConcept(t));
        }
        if (src.hasReason()) {
            for (org.hl7.fhir.r5.model.CodeableConcept t : src.getReason()) tgt.addReason(convertCodeableConcept(t));
        }
        if (src.hasDocumentation()) {
            for (org.hl7.fhir.r5.model.RelatedArtifact t : src.getDocumentation()) tgt.addDocumentation(convertRelatedArtifact(t));
        }
        if (src.hasGoalId()) {
            for (org.hl7.fhir.r5.model.IdType t : src.getGoalId()) tgt.getGoalId().add(convertId(t));
        }
        if (src.hasSubject())
            tgt.setSubject(convertType(src.getSubject()));
        if (src.hasTrigger()) {
            for (org.hl7.fhir.r5.model.TriggerDefinition t : src.getTrigger()) tgt.addTrigger(convertTriggerDefinition(t));
        }
        if (src.hasCondition()) {
            for (org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionActionConditionComponent t : src.getCondition()) tgt.addCondition(convertPlanDefinitionActionConditionComponent(t));
        }
        if (src.hasInput()) {
            for (org.hl7.fhir.r5.model.DataRequirement t : src.getInput()) tgt.addInput(convertDataRequirement(t));
        }
        if (src.hasOutput()) {
            for (org.hl7.fhir.r5.model.DataRequirement t : src.getOutput()) tgt.addOutput(convertDataRequirement(t));
        }
        if (src.hasRelatedAction()) {
            for (org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionActionRelatedActionComponent t : src.getRelatedAction()) tgt.addRelatedAction(convertPlanDefinitionActionRelatedActionComponent(t));
        }
        if (src.hasTiming())
            tgt.setTiming(convertType(src.getTiming()));
        if (src.hasParticipant()) {
            for (org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionActionParticipantComponent t : src.getParticipant()) tgt.addParticipant(convertPlanDefinitionActionParticipantComponent(t));
        }
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
        // if (src.hasDefinition())
        // tgt.setDefinitionElement(convertType(src.getDefinitionElement()));
        if (src.hasTransform())
            tgt.setTransformElement(convertCanonical(src.getTransformElement()));
        if (src.hasDynamicValue()) {
            for (org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionActionDynamicValueComponent t : src.getDynamicValue()) tgt.addDynamicValue(convertPlanDefinitionActionDynamicValueComponent(t));
        }
        if (src.hasAction()) {
            for (org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionActionComponent t : src.getAction()) tgt.addAction(convertPlanDefinitionActionComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Enumerations.RequestPriority convertRequestPriority(org.hl7.fhir.r4.model.PlanDefinition.RequestPriority src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case ROUTINE:
                return org.hl7.fhir.r5.model.Enumerations.RequestPriority.ROUTINE;
            case URGENT:
                return org.hl7.fhir.r5.model.Enumerations.RequestPriority.URGENT;
            case ASAP:
                return org.hl7.fhir.r5.model.Enumerations.RequestPriority.ASAP;
            case STAT:
                return org.hl7.fhir.r5.model.Enumerations.RequestPriority.STAT;
            default:
                return org.hl7.fhir.r5.model.Enumerations.RequestPriority.NULL;
        }
    }

    public static org.hl7.fhir.r4.model.PlanDefinition.RequestPriority convertRequestPriority(org.hl7.fhir.r5.model.Enumerations.RequestPriority src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case ROUTINE:
                return org.hl7.fhir.r4.model.PlanDefinition.RequestPriority.ROUTINE;
            case URGENT:
                return org.hl7.fhir.r4.model.PlanDefinition.RequestPriority.URGENT;
            case ASAP:
                return org.hl7.fhir.r4.model.PlanDefinition.RequestPriority.ASAP;
            case STAT:
                return org.hl7.fhir.r4.model.PlanDefinition.RequestPriority.STAT;
            default:
                return org.hl7.fhir.r4.model.PlanDefinition.RequestPriority.NULL;
        }
    }

    public static org.hl7.fhir.r5.model.Enumerations.ActionGroupingBehavior convertActionGroupingBehavior(org.hl7.fhir.r4.model.PlanDefinition.ActionGroupingBehavior src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case VISUALGROUP:
                return org.hl7.fhir.r5.model.Enumerations.ActionGroupingBehavior.VISUALGROUP;
            case LOGICALGROUP:
                return org.hl7.fhir.r5.model.Enumerations.ActionGroupingBehavior.LOGICALGROUP;
            case SENTENCEGROUP:
                return org.hl7.fhir.r5.model.Enumerations.ActionGroupingBehavior.SENTENCEGROUP;
            default:
                return org.hl7.fhir.r5.model.Enumerations.ActionGroupingBehavior.NULL;
        }
    }

    public static org.hl7.fhir.r4.model.PlanDefinition.ActionGroupingBehavior convertActionGroupingBehavior(org.hl7.fhir.r5.model.Enumerations.ActionGroupingBehavior src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case VISUALGROUP:
                return org.hl7.fhir.r4.model.PlanDefinition.ActionGroupingBehavior.VISUALGROUP;
            case LOGICALGROUP:
                return org.hl7.fhir.r4.model.PlanDefinition.ActionGroupingBehavior.LOGICALGROUP;
            case SENTENCEGROUP:
                return org.hl7.fhir.r4.model.PlanDefinition.ActionGroupingBehavior.SENTENCEGROUP;
            default:
                return org.hl7.fhir.r4.model.PlanDefinition.ActionGroupingBehavior.NULL;
        }
    }

    public static org.hl7.fhir.r5.model.Enumerations.ActionSelectionBehavior convertActionSelectionBehavior(org.hl7.fhir.r4.model.PlanDefinition.ActionSelectionBehavior src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case ANY:
                return org.hl7.fhir.r5.model.Enumerations.ActionSelectionBehavior.ANY;
            case ALL:
                return org.hl7.fhir.r5.model.Enumerations.ActionSelectionBehavior.ALL;
            case ALLORNONE:
                return org.hl7.fhir.r5.model.Enumerations.ActionSelectionBehavior.ALLORNONE;
            case EXACTLYONE:
                return org.hl7.fhir.r5.model.Enumerations.ActionSelectionBehavior.EXACTLYONE;
            case ATMOSTONE:
                return org.hl7.fhir.r5.model.Enumerations.ActionSelectionBehavior.ATMOSTONE;
            case ONEORMORE:
                return org.hl7.fhir.r5.model.Enumerations.ActionSelectionBehavior.ONEORMORE;
            default:
                return org.hl7.fhir.r5.model.Enumerations.ActionSelectionBehavior.NULL;
        }
    }

    public static org.hl7.fhir.r4.model.PlanDefinition.ActionSelectionBehavior convertActionSelectionBehavior(org.hl7.fhir.r5.model.Enumerations.ActionSelectionBehavior src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case ANY:
                return org.hl7.fhir.r4.model.PlanDefinition.ActionSelectionBehavior.ANY;
            case ALL:
                return org.hl7.fhir.r4.model.PlanDefinition.ActionSelectionBehavior.ALL;
            case ALLORNONE:
                return org.hl7.fhir.r4.model.PlanDefinition.ActionSelectionBehavior.ALLORNONE;
            case EXACTLYONE:
                return org.hl7.fhir.r4.model.PlanDefinition.ActionSelectionBehavior.EXACTLYONE;
            case ATMOSTONE:
                return org.hl7.fhir.r4.model.PlanDefinition.ActionSelectionBehavior.ATMOSTONE;
            case ONEORMORE:
                return org.hl7.fhir.r4.model.PlanDefinition.ActionSelectionBehavior.ONEORMORE;
            default:
                return org.hl7.fhir.r4.model.PlanDefinition.ActionSelectionBehavior.NULL;
        }
    }

    public static org.hl7.fhir.r5.model.Enumerations.ActionRequiredBehavior convertActionRequiredBehavior(org.hl7.fhir.r4.model.PlanDefinition.ActionRequiredBehavior src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case MUST:
                return org.hl7.fhir.r5.model.Enumerations.ActionRequiredBehavior.MUST;
            case COULD:
                return org.hl7.fhir.r5.model.Enumerations.ActionRequiredBehavior.COULD;
            case MUSTUNLESSDOCUMENTED:
                return org.hl7.fhir.r5.model.Enumerations.ActionRequiredBehavior.MUSTUNLESSDOCUMENTED;
            default:
                return org.hl7.fhir.r5.model.Enumerations.ActionRequiredBehavior.NULL;
        }
    }

    public static org.hl7.fhir.r4.model.PlanDefinition.ActionRequiredBehavior convertActionRequiredBehavior(org.hl7.fhir.r5.model.Enumerations.ActionRequiredBehavior src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case MUST:
                return org.hl7.fhir.r4.model.PlanDefinition.ActionRequiredBehavior.MUST;
            case COULD:
                return org.hl7.fhir.r4.model.PlanDefinition.ActionRequiredBehavior.COULD;
            case MUSTUNLESSDOCUMENTED:
                return org.hl7.fhir.r4.model.PlanDefinition.ActionRequiredBehavior.MUSTUNLESSDOCUMENTED;
            default:
                return org.hl7.fhir.r4.model.PlanDefinition.ActionRequiredBehavior.NULL;
        }
    }

    public static org.hl7.fhir.r5.model.Enumerations.ActionPrecheckBehavior convertActionPrecheckBehavior(org.hl7.fhir.r4.model.PlanDefinition.ActionPrecheckBehavior src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case YES:
                return org.hl7.fhir.r5.model.Enumerations.ActionPrecheckBehavior.YES;
            case NO:
                return org.hl7.fhir.r5.model.Enumerations.ActionPrecheckBehavior.NO;
            default:
                return org.hl7.fhir.r5.model.Enumerations.ActionPrecheckBehavior.NULL;
        }
    }

    public static org.hl7.fhir.r4.model.PlanDefinition.ActionPrecheckBehavior convertActionPrecheckBehavior(org.hl7.fhir.r5.model.Enumerations.ActionPrecheckBehavior src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case YES:
                return org.hl7.fhir.r4.model.PlanDefinition.ActionPrecheckBehavior.YES;
            case NO:
                return org.hl7.fhir.r4.model.PlanDefinition.ActionPrecheckBehavior.NO;
            default:
                return org.hl7.fhir.r4.model.PlanDefinition.ActionPrecheckBehavior.NULL;
        }
    }

    public static org.hl7.fhir.r5.model.Enumerations.ActionCardinalityBehavior convertActionCardinalityBehavior(org.hl7.fhir.r4.model.PlanDefinition.ActionCardinalityBehavior src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case SINGLE:
                return org.hl7.fhir.r5.model.Enumerations.ActionCardinalityBehavior.SINGLE;
            case MULTIPLE:
                return org.hl7.fhir.r5.model.Enumerations.ActionCardinalityBehavior.MULTIPLE;
            default:
                return org.hl7.fhir.r5.model.Enumerations.ActionCardinalityBehavior.NULL;
        }
    }

    public static org.hl7.fhir.r4.model.PlanDefinition.ActionCardinalityBehavior convertActionCardinalityBehavior(org.hl7.fhir.r5.model.Enumerations.ActionCardinalityBehavior src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case SINGLE:
                return org.hl7.fhir.r4.model.PlanDefinition.ActionCardinalityBehavior.SINGLE;
            case MULTIPLE:
                return org.hl7.fhir.r4.model.PlanDefinition.ActionCardinalityBehavior.MULTIPLE;
            default:
                return org.hl7.fhir.r4.model.PlanDefinition.ActionCardinalityBehavior.NULL;
        }
    }

    public static org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionActionConditionComponent convertPlanDefinitionActionConditionComponent(org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionConditionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionActionConditionComponent tgt = new org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionActionConditionComponent();
        copyElement(src, tgt);
        if (src.hasKind())
            tgt.setKind(convertActionConditionKind(src.getKind()));
        if (src.hasExpression())
            tgt.setExpression(convertExpression(src.getExpression()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionConditionComponent convertPlanDefinitionActionConditionComponent(org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionActionConditionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionConditionComponent tgt = new org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionConditionComponent();
        copyElement(src, tgt);
        if (src.hasKind())
            tgt.setKind(convertActionConditionKind(src.getKind()));
        if (src.hasExpression())
            tgt.setExpression(convertExpression(src.getExpression()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Enumerations.ActionConditionKind convertActionConditionKind(org.hl7.fhir.r4.model.PlanDefinition.ActionConditionKind src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case APPLICABILITY:
                return org.hl7.fhir.r5.model.Enumerations.ActionConditionKind.APPLICABILITY;
            case START:
                return org.hl7.fhir.r5.model.Enumerations.ActionConditionKind.START;
            case STOP:
                return org.hl7.fhir.r5.model.Enumerations.ActionConditionKind.STOP;
            default:
                return org.hl7.fhir.r5.model.Enumerations.ActionConditionKind.NULL;
        }
    }

    public static org.hl7.fhir.r4.model.PlanDefinition.ActionConditionKind convertActionConditionKind(org.hl7.fhir.r5.model.Enumerations.ActionConditionKind src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case APPLICABILITY:
                return org.hl7.fhir.r4.model.PlanDefinition.ActionConditionKind.APPLICABILITY;
            case START:
                return org.hl7.fhir.r4.model.PlanDefinition.ActionConditionKind.START;
            case STOP:
                return org.hl7.fhir.r4.model.PlanDefinition.ActionConditionKind.STOP;
            default:
                return org.hl7.fhir.r4.model.PlanDefinition.ActionConditionKind.NULL;
        }
    }

    public static org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionActionRelatedActionComponent convertPlanDefinitionActionRelatedActionComponent(org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionRelatedActionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionActionRelatedActionComponent tgt = new org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionActionRelatedActionComponent();
        copyElement(src, tgt);
        if (src.hasActionId())
            tgt.setActionIdElement(convertId(src.getActionIdElement()));
        if (src.hasRelationship())
            tgt.setRelationship(convertActionRelationshipType(src.getRelationship()));
        if (src.hasOffset())
            tgt.setOffset(convertType(src.getOffset()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionRelatedActionComponent convertPlanDefinitionActionRelatedActionComponent(org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionActionRelatedActionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionRelatedActionComponent tgt = new org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionRelatedActionComponent();
        copyElement(src, tgt);
        if (src.hasActionId())
            tgt.setActionIdElement(convertId(src.getActionIdElement()));
        if (src.hasRelationship())
            tgt.setRelationship(convertActionRelationshipType(src.getRelationship()));
        if (src.hasOffset())
            tgt.setOffset(convertType(src.getOffset()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Enumerations.ActionRelationshipType convertActionRelationshipType(org.hl7.fhir.r4.model.PlanDefinition.ActionRelationshipType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case BEFORESTART:
                return org.hl7.fhir.r5.model.Enumerations.ActionRelationshipType.BEFORESTART;
            case BEFORE:
                return org.hl7.fhir.r5.model.Enumerations.ActionRelationshipType.BEFORE;
            case BEFOREEND:
                return org.hl7.fhir.r5.model.Enumerations.ActionRelationshipType.BEFOREEND;
            case CONCURRENTWITHSTART:
                return org.hl7.fhir.r5.model.Enumerations.ActionRelationshipType.CONCURRENTWITHSTART;
            case CONCURRENT:
                return org.hl7.fhir.r5.model.Enumerations.ActionRelationshipType.CONCURRENT;
            case CONCURRENTWITHEND:
                return org.hl7.fhir.r5.model.Enumerations.ActionRelationshipType.CONCURRENTWITHEND;
            case AFTERSTART:
                return org.hl7.fhir.r5.model.Enumerations.ActionRelationshipType.AFTERSTART;
            case AFTER:
                return org.hl7.fhir.r5.model.Enumerations.ActionRelationshipType.AFTER;
            case AFTEREND:
                return org.hl7.fhir.r5.model.Enumerations.ActionRelationshipType.AFTEREND;
            default:
                return org.hl7.fhir.r5.model.Enumerations.ActionRelationshipType.NULL;
        }
    }

    public static org.hl7.fhir.r4.model.PlanDefinition.ActionRelationshipType convertActionRelationshipType(org.hl7.fhir.r5.model.Enumerations.ActionRelationshipType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case BEFORESTART:
                return org.hl7.fhir.r4.model.PlanDefinition.ActionRelationshipType.BEFORESTART;
            case BEFORE:
                return org.hl7.fhir.r4.model.PlanDefinition.ActionRelationshipType.BEFORE;
            case BEFOREEND:
                return org.hl7.fhir.r4.model.PlanDefinition.ActionRelationshipType.BEFOREEND;
            case CONCURRENTWITHSTART:
                return org.hl7.fhir.r4.model.PlanDefinition.ActionRelationshipType.CONCURRENTWITHSTART;
            case CONCURRENT:
                return org.hl7.fhir.r4.model.PlanDefinition.ActionRelationshipType.CONCURRENT;
            case CONCURRENTWITHEND:
                return org.hl7.fhir.r4.model.PlanDefinition.ActionRelationshipType.CONCURRENTWITHEND;
            case AFTERSTART:
                return org.hl7.fhir.r4.model.PlanDefinition.ActionRelationshipType.AFTERSTART;
            case AFTER:
                return org.hl7.fhir.r4.model.PlanDefinition.ActionRelationshipType.AFTER;
            case AFTEREND:
                return org.hl7.fhir.r4.model.PlanDefinition.ActionRelationshipType.AFTEREND;
            default:
                return org.hl7.fhir.r4.model.PlanDefinition.ActionRelationshipType.NULL;
        }
    }

    public static org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionActionParticipantComponent convertPlanDefinitionActionParticipantComponent(org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionParticipantComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionActionParticipantComponent tgt = new org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionActionParticipantComponent();
        copyElement(src, tgt);
        if (src.hasType())
            tgt.setType(convertActionParticipantType(src.getType()));
        if (src.hasRole())
            tgt.setRole(convertCodeableConcept(src.getRole()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionParticipantComponent convertPlanDefinitionActionParticipantComponent(org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionActionParticipantComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionParticipantComponent tgt = new org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionParticipantComponent();
        copyElement(src, tgt);
        if (src.hasType())
            tgt.setType(convertActionParticipantType(src.getType()));
        if (src.hasRole())
            tgt.setRole(convertCodeableConcept(src.getRole()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Enumerations.ActionParticipantType convertActionParticipantType(org.hl7.fhir.r4.model.PlanDefinition.ActionParticipantType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case PATIENT:
                return org.hl7.fhir.r5.model.Enumerations.ActionParticipantType.PATIENT;
            case PRACTITIONER:
                return org.hl7.fhir.r5.model.Enumerations.ActionParticipantType.PRACTITIONER;
            case RELATEDPERSON:
                return org.hl7.fhir.r5.model.Enumerations.ActionParticipantType.RELATEDPERSON;
            case DEVICE:
                return org.hl7.fhir.r5.model.Enumerations.ActionParticipantType.DEVICE;
            default:
                return org.hl7.fhir.r5.model.Enumerations.ActionParticipantType.NULL;
        }
    }

    public static org.hl7.fhir.r4.model.PlanDefinition.ActionParticipantType convertActionParticipantType(org.hl7.fhir.r5.model.Enumerations.ActionParticipantType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case PATIENT:
                return org.hl7.fhir.r4.model.PlanDefinition.ActionParticipantType.PATIENT;
            case PRACTITIONER:
                return org.hl7.fhir.r4.model.PlanDefinition.ActionParticipantType.PRACTITIONER;
            case RELATEDPERSON:
                return org.hl7.fhir.r4.model.PlanDefinition.ActionParticipantType.RELATEDPERSON;
            case DEVICE:
                return org.hl7.fhir.r4.model.PlanDefinition.ActionParticipantType.DEVICE;
            default:
                return org.hl7.fhir.r4.model.PlanDefinition.ActionParticipantType.NULL;
        }
    }

    public static org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionActionDynamicValueComponent convertPlanDefinitionActionDynamicValueComponent(org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionDynamicValueComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionActionDynamicValueComponent tgt = new org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionActionDynamicValueComponent();
        copyElement(src, tgt);
        if (src.hasPath())
            tgt.setPathElement(convertString(src.getPathElement()));
        if (src.hasExpression())
            tgt.setExpression(convertExpression(src.getExpression()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionDynamicValueComponent convertPlanDefinitionActionDynamicValueComponent(org.hl7.fhir.r5.model.PlanDefinition.PlanDefinitionActionDynamicValueComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionDynamicValueComponent tgt = new org.hl7.fhir.r4.model.PlanDefinition.PlanDefinitionActionDynamicValueComponent();
        copyElement(src, tgt);
        if (src.hasPath())
            tgt.setPathElement(convertString(src.getPathElement()));
        if (src.hasExpression())
            tgt.setExpression(convertExpression(src.getExpression()));
        return tgt;
    }
}
