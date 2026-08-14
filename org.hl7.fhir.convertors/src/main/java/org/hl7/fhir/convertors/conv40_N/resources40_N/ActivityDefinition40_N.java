package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Identifier40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Period40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.SimpleQuantity40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.metadata40_N.ContactDetail40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.metadata40_N.Expression40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.metadata40_N.RelatedArtifact40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.metadata40_N.UsageContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Boolean40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Canonical40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Date40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.DateTime40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.MarkDown40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.String40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Uri40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Dosage40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Reference40_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.*;

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

public class ActivityDefinition40_N {

  public static org.hl7.fhir.model.core.ActivityDefinition convertActivityDefinition(org.hl7.fhir.r4.model.ActivityDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ActivityDefinition tgt = new org.hl7.fhir.model.core.ActivityDefinition();
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
    if (src.hasKind())
      tgt.setKindElement(convertActivityDefinitionKind(src.getKindElement()));
    if (src.hasProfile())
      tgt.setProfileElement(Canonical40_N.convertCanonical(src.getProfileElement()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_N.convertCodeableConcept(src.getCode()));
    if (src.hasIntent())
      tgt.setIntentElement(convertRequestIntent(src.getIntentElement()));
    if (src.hasPriority())
      tgt.setPriorityElement(convertRequestPriority(src.getPriorityElement()));
    if (src.hasDoNotPerform())
      tgt.setDoNotPerformElement(Boolean40_N.convertBoolean(src.getDoNotPerformElement()));
    if (src.hasTiming())
      tgt.setTiming(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getTiming()));
    if (src.hasLocation())
      tgt.setLocation(new CodeableReference(Reference40_N.convertReference(src.getLocation())));
    for (org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionParticipantComponent t : src.getParticipant())
      tgt.addParticipant(convertActivityDefinitionParticipantComponent(t));
    if (src.hasProduct())
      tgt.setProduct(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getProduct()));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity40_N.convertSimpleQuantity(src.getQuantity()));
    for (org.hl7.fhir.r4.model.Dosage t : src.getDosage()) tgt.getDosageInstruction().getStepFirstRep().addComponent(Dosage40_N.convertDosage(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getBodySite())
      tgt.addBodySite(CodeableConcept40_N.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getSpecimenRequirement())
      tgt.getSpecimenRequirementList().add(Reference40_N.convertReferenceToCanonical(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getObservationRequirement())
      tgt.getObservationRequirementList().add(Reference40_N.convertReferenceToCanonical(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getObservationResultRequirement())
      tgt.getObservationResultRequirementList().add(Reference40_N.convertReferenceToCanonical(t));
    if (src.hasTransform())
      tgt.setTransformElement(Canonical40_N.convertCanonical(src.getTransformElement()));
    for (org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionDynamicValueComponent t : src.getDynamicValue())
      tgt.addDynamicValue(convertActivityDefinitionDynamicValueComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ActivityDefinition convertActivityDefinition(org.hl7.fhir.model.core.ActivityDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ActivityDefinition tgt = new org.hl7.fhir.r4.model.ActivityDefinition();
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
    if (src.hasKind())
      tgt.setKindElement(convertActivityDefinitionKind(src.getKindElement()));
    if (src.hasProfile())
      tgt.setProfileElement(Canonical40_N.convertCanonical(src.getProfileElement()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_N.convertCodeableConcept(src.getCode()));
    if (src.hasIntent())
      tgt.setIntentElement(convertRequestIntent(src.getIntentElement()));
    if (src.hasPriority())
      tgt.setPriorityElement(convertRequestPriority(src.getPriorityElement()));
    if (src.hasDoNotPerform())
      tgt.setDoNotPerformElement(Boolean40_N.convertBoolean(src.getDoNotPerformElement()));
    if (src.hasTiming())
      tgt.setTiming(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getTiming()));
    if (src.getLocation().hasReference())
      tgt.setLocation(Reference40_N.convertReference(src.getLocation().getReference()));
    for (org.hl7.fhir.model.core.ActivityDefinition.ActivityDefinitionParticipantComponent t : src.getParticipantList())
      tgt.addParticipant(convertActivityDefinitionParticipantComponent(t));
    if (src.hasProduct())
      tgt.setProduct(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getProduct()));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity40_N.convertSimpleQuantity(src.getQuantity()));
    for (DosageDetails.DosageDetailsStepComponent t : src.getDosageInstruction().getStepList()) tgt.addDosage(Dosage40_N.convertDosage(t.getComponentFirstRep()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getBodySiteList())
      tgt.addBodySite(CodeableConcept40_N.convertCodeableConcept(t));
    for (org.hl7.fhir.model.core.CanonicalType t : src.getSpecimenRequirementList())
      tgt.addSpecimenRequirement(Reference40_N.convertReferenceToCanonical(t));
    for (org.hl7.fhir.model.core.CanonicalType t : src.getObservationRequirementList())
      tgt.addObservationRequirement(Reference40_N.convertReferenceToCanonical(t));
    for (org.hl7.fhir.model.core.CanonicalType t : src.getObservationResultRequirementList())
      tgt.addObservationResultRequirement(Reference40_N.convertReferenceToCanonical(t));
    if (src.hasTransform())
      tgt.setTransformElement(Canonical40_N.convertCanonical(src.getTransformElement()));
    for (org.hl7.fhir.model.core.ActivityDefinition.ActivityDefinitionDynamicValueComponent t : src.getDynamicValueList())
      tgt.addDynamicValue(convertActivityDefinitionDynamicValueComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.ActivityDefinition.RequestResourceTypes> convertActivityDefinitionKind(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionKind> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<ActivityDefinition.RequestResourceTypes> tgt = new Enumeration<>(new ActivityDefinition.RequestResourceTypesEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case APPOINTMENT:
                  tgt.setValue(ActivityDefinition.RequestResourceTypes.APPOINTMENT);
                  break;
              case CAREPLAN:
                  tgt.setValue(ActivityDefinition.RequestResourceTypes.CAREPLAN);
                  break;
              case CLAIM:
                  tgt.setValue(ActivityDefinition.RequestResourceTypes.CLAIM);
                  break;
              case COMMUNICATIONREQUEST:
                  tgt.setValue(ActivityDefinition.RequestResourceTypes.COMMUNICATIONREQUEST);
                  break;
              case DEVICEREQUEST:
                  tgt.setValue(ActivityDefinition.RequestResourceTypes.DEVICEREQUEST);
                  break;
              case MEDICATIONREQUEST:
                  tgt.setValue(ActivityDefinition.RequestResourceTypes.MEDICATIONREQUEST);
                  break;
              case NUTRITIONORDER:
                  tgt.setValue(ActivityDefinition.RequestResourceTypes.NUTRITIONORDER);
                  break;
              case SERVICEREQUEST:
                  tgt.setValue(ActivityDefinition.RequestResourceTypes.SERVICEREQUEST);
                  break;
              case TASK:
                  tgt.setValue(null);
                  tgt.addExtension(VersionConvertorConstants.EXT_ACTUAL_RESOURCE_NAME, new CodeType("Task"));
                  break;
              case VISIONPRESCRIPTION:
                  tgt.setValue(ActivityDefinition.RequestResourceTypes.VISIONPRESCRIPTION);
                  break;
              default:
                  tgt.setValue(ActivityDefinition.RequestResourceTypes.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionKind> convertActivityDefinitionKind(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.ActivityDefinition.RequestResourceTypes> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionKind> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionKindEnumFactory());
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt, VersionConvertorConstants.EXT_ACTUAL_RESOURCE_NAME);
    if (src.hasExtension(VersionConvertorConstants.EXT_ACTUAL_RESOURCE_NAME)) {
      tgt.setValueAsString(src.getExtensionString(VersionConvertorConstants.EXT_ACTUAL_RESOURCE_NAME));
    } else {
        if (src.getValue() == null) {
            tgt.setValue(null);
        } else {
            switch (src.getValue()) {
                case APPOINTMENT:
                    tgt.setValue(org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionKind.APPOINTMENT);
                    break;
                case CAREPLAN:
                    tgt.setValue(org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionKind.CAREPLAN);
                    break;
                case CLAIM:
                    tgt.setValue(org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionKind.CLAIM);
                    break;
                case COMMUNICATIONREQUEST:
                    tgt.setValue(org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionKind.COMMUNICATIONREQUEST);
                    break;
                case DEVICEREQUEST:
                    tgt.setValue(org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionKind.DEVICEREQUEST);
                    break;
                case MEDICATIONREQUEST:
                    tgt.setValue(org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionKind.MEDICATIONREQUEST);
                    break;
                case NUTRITIONORDER:
                    tgt.setValue(org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionKind.NUTRITIONORDER);
                    break;
                case SERVICEREQUEST:
                    tgt.setValue(org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionKind.SERVICEREQUEST);
                    break;
                case VISIONPRESCRIPTION:
                    tgt.setValue(org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionKind.VISIONPRESCRIPTION);
                    break;
                default:
                    tgt.setValue(org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionKind.NULL);
                    break;
            }
        }
    }
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.RequestIntent> convertRequestIntent(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ActivityDefinition.RequestIntent> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Enumerations.RequestIntent> tgt = new Enumeration<>(new Enumerations.RequestIntentEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case PROPOSAL:
                  tgt.setValue(Enumerations.RequestIntent.PROPOSAL);
                  break;
              case PLAN:
                  tgt.setValue(Enumerations.RequestIntent.PLAN);
                  break;
              case DIRECTIVE:
                  tgt.setValue(Enumerations.RequestIntent.DIRECTIVE);
                  break;
              case ORDER:
                  tgt.setValue(Enumerations.RequestIntent.ORDER);
                  break;
              case ORIGINALORDER:
                  tgt.setValue(Enumerations.RequestIntent.ORIGINALORDER);
                  break;
              case REFLEXORDER:
                  tgt.setValue(Enumerations.RequestIntent.REFLEXORDER);
                  break;
              case FILLERORDER:
                  tgt.setValue(Enumerations.RequestIntent.FILLERORDER);
                  break;
              case INSTANCEORDER:
                  tgt.setValue(Enumerations.RequestIntent.INSTANCEORDER);
                  break;
              case OPTION:
                  tgt.setValue(Enumerations.RequestIntent.OPTION);
                  break;
              default:
                  tgt.setValue(Enumerations.RequestIntent.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ActivityDefinition.RequestIntent> convertRequestIntent(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.RequestIntent> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ActivityDefinition.RequestIntent> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ActivityDefinition.RequestIntentEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case PROPOSAL:
                  tgt.setValue(org.hl7.fhir.r4.model.ActivityDefinition.RequestIntent.PROPOSAL);
                  break;
              case PLAN:
                  tgt.setValue(org.hl7.fhir.r4.model.ActivityDefinition.RequestIntent.PLAN);
                  break;
              case DIRECTIVE:
                  tgt.setValue(org.hl7.fhir.r4.model.ActivityDefinition.RequestIntent.DIRECTIVE);
                  break;
              case ORDER:
                  tgt.setValue(org.hl7.fhir.r4.model.ActivityDefinition.RequestIntent.ORDER);
                  break;
              case ORIGINALORDER:
                  tgt.setValue(org.hl7.fhir.r4.model.ActivityDefinition.RequestIntent.ORIGINALORDER);
                  break;
              case REFLEXORDER:
                  tgt.setValue(org.hl7.fhir.r4.model.ActivityDefinition.RequestIntent.REFLEXORDER);
                  break;
              case FILLERORDER:
                  tgt.setValue(org.hl7.fhir.r4.model.ActivityDefinition.RequestIntent.FILLERORDER);
                  break;
              case INSTANCEORDER:
                  tgt.setValue(org.hl7.fhir.r4.model.ActivityDefinition.RequestIntent.INSTANCEORDER);
                  break;
              case OPTION:
                  tgt.setValue(org.hl7.fhir.r4.model.ActivityDefinition.RequestIntent.OPTION);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4.model.ActivityDefinition.RequestIntent.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.RequestPriority> convertRequestPriority(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ActivityDefinition.RequestPriority> src) throws FHIRException {
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ActivityDefinition.RequestPriority> convertRequestPriority(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.RequestPriority> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ActivityDefinition.RequestPriority> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ActivityDefinition.RequestPriorityEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case ROUTINE:
                  tgt.setValue(org.hl7.fhir.r4.model.ActivityDefinition.RequestPriority.ROUTINE);
                  break;
              case URGENT:
                  tgt.setValue(org.hl7.fhir.r4.model.ActivityDefinition.RequestPriority.URGENT);
                  break;
              case ASAP:
                  tgt.setValue(org.hl7.fhir.r4.model.ActivityDefinition.RequestPriority.ASAP);
                  break;
              case STAT:
                  tgt.setValue(org.hl7.fhir.r4.model.ActivityDefinition.RequestPriority.STAT);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4.model.ActivityDefinition.RequestPriority.NULL);
                  break;
          }
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.ActivityDefinition.ActivityDefinitionParticipantComponent convertActivityDefinitionParticipantComponent(org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionParticipantComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ActivityDefinition.ActivityDefinitionParticipantComponent tgt = new org.hl7.fhir.model.core.ActivityDefinition.ActivityDefinitionParticipantComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setTypeElement(convertActivityParticipantType(src.getTypeElement()));
    if (src.hasRole())
      tgt.setRole(CodeableConcept40_N.convertCodeableConcept(src.getRole()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionParticipantComponent convertActivityDefinitionParticipantComponent(org.hl7.fhir.model.core.ActivityDefinition.ActivityDefinitionParticipantComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionParticipantComponent tgt = new org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionParticipantComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setTypeElement(convertActivityParticipantType(src.getTypeElement()));
    if (src.hasRole())
      tgt.setRole(CodeableConcept40_N.convertCodeableConcept(src.getRole()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ActionParticipantType> convertActivityParticipantType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ActivityDefinition.ActivityParticipantType> src) throws FHIRException {
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ActivityDefinition.ActivityParticipantType> convertActivityParticipantType(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.ActionParticipantType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ActivityDefinition.ActivityParticipantType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ActivityDefinition.ActivityParticipantTypeEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case PATIENT:
                  tgt.setValue(org.hl7.fhir.r4.model.ActivityDefinition.ActivityParticipantType.PATIENT);
                  break;
              case PRACTITIONER:
                  tgt.setValue(org.hl7.fhir.r4.model.ActivityDefinition.ActivityParticipantType.PRACTITIONER);
                  break;
              case RELATEDPERSON:
                  tgt.setValue(org.hl7.fhir.r4.model.ActivityDefinition.ActivityParticipantType.RELATEDPERSON);
                  break;
              case DEVICE:
                  tgt.setValue(org.hl7.fhir.r4.model.ActivityDefinition.ActivityParticipantType.DEVICE);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4.model.ActivityDefinition.ActivityParticipantType.NULL);
                  break;
          }
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.ActivityDefinition.ActivityDefinitionDynamicValueComponent convertActivityDefinitionDynamicValueComponent(org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionDynamicValueComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ActivityDefinition.ActivityDefinitionDynamicValueComponent tgt = new org.hl7.fhir.model.core.ActivityDefinition.ActivityDefinitionDynamicValueComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasPath())
      tgt.setPathElement(String40_N.convertString(src.getPathElement()));
    if (src.hasExpression())
      tgt.setExpression(Expression40_N.convertExpression(src.getExpression()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionDynamicValueComponent convertActivityDefinitionDynamicValueComponent(org.hl7.fhir.model.core.ActivityDefinition.ActivityDefinitionDynamicValueComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionDynamicValueComponent tgt = new org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionDynamicValueComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasPath())
      tgt.setPathElement(String40_N.convertString(src.getPathElement()));
    if (src.hasExpression())
      tgt.setExpression(Expression40_N.convertExpression(src.getExpression()));
    return tgt;
  }
}