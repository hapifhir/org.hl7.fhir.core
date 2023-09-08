package org.hl7.fhir.convertors.conv43_50.resources43_50;

import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.CodeableConcept43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Identifier43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Period43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.SimpleQuantity43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.metadata43_50.ContactDetail43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.metadata43_50.Expression43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.metadata43_50.RelatedArtifact43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.metadata43_50.UsageContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Boolean43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Canonical43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Date43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.DateTime43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.MarkDown43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.String43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Uri43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.special43_50.Dosage43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.special43_50.Reference43_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CodeType;
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
public class ActivityDefinition43_50 {

  public static org.hl7.fhir.r5.model.ActivityDefinition convertActivityDefinition(org.hl7.fhir.r4b.model.ActivityDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ActivityDefinition tgt = new org.hl7.fhir.r5.model.ActivityDefinition();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri43_50.convertUri(src.getUrlElement()));
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    if (src.hasVersion())
      tgt.setVersionElement(String43_50.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String43_50.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String43_50.convertString(src.getTitleElement()));
    if (src.hasSubtitle())
      tgt.setSubtitleElement(String43_50.convertString(src.getSubtitleElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations43_50.convertPublicationStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean43_50.convertBoolean(src.getExperimentalElement()));
    if (src.hasSubject())
      tgt.setSubject(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getSubject()));
    if (src.hasDate())
      tgt.setDateElement(DateTime43_50.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String43_50.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.r4b.model.ContactDetail t : src.getContact())
      tgt.addContact(ContactDetail43_50.convertContactDetail(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown43_50.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r4b.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(UsageContext43_50.convertUsageContext(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasPurpose())
      tgt.setPurposeElement(MarkDown43_50.convertMarkdown(src.getPurposeElement()));
    if (src.hasUsage())
      tgt.setUsageElement(String43_50.convertStringToMarkdown(src.getUsageElement()));
    if (src.hasCopyright())
      tgt.setCopyrightElement(MarkDown43_50.convertMarkdown(src.getCopyrightElement()));
    if (src.hasApprovalDate())
      tgt.setApprovalDateElement(Date43_50.convertDate(src.getApprovalDateElement()));
    if (src.hasLastReviewDate())
      tgt.setLastReviewDateElement(Date43_50.convertDate(src.getLastReviewDateElement()));
    if (src.hasEffectivePeriod())
      tgt.setEffectivePeriod(Period43_50.convertPeriod(src.getEffectivePeriod()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getTopic())
      tgt.addTopic(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r4b.model.ContactDetail t : src.getAuthor())
      tgt.addAuthor(ContactDetail43_50.convertContactDetail(t));
    for (org.hl7.fhir.r4b.model.ContactDetail t : src.getEditor())
      tgt.addEditor(ContactDetail43_50.convertContactDetail(t));
    for (org.hl7.fhir.r4b.model.ContactDetail t : src.getReviewer())
      tgt.addReviewer(ContactDetail43_50.convertContactDetail(t));
    for (org.hl7.fhir.r4b.model.ContactDetail t : src.getEndorser())
      tgt.addEndorser(ContactDetail43_50.convertContactDetail(t));
    for (org.hl7.fhir.r4b.model.RelatedArtifact t : src.getRelatedArtifact())
      tgt.addRelatedArtifact(RelatedArtifact43_50.convertRelatedArtifact(t));
    for (org.hl7.fhir.r4b.model.CanonicalType t : src.getLibrary())
      tgt.getLibrary().add(Canonical43_50.convertCanonical(t));
    if (src.hasKind())
      tgt.setKindElement(convertActivityDefinitionKind(src.getKindElement()));
    if (src.hasProfile())
      tgt.setProfileElement(Canonical43_50.convertCanonical(src.getProfileElement()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_50.convertCodeableConcept(src.getCode()));
    if (src.hasIntent())
      tgt.setIntentElement(convertRequestIntent(src.getIntentElement()));
    if (src.hasPriority())
      tgt.setPriorityElement(convertRequestPriority(src.getPriorityElement()));
    if (src.hasDoNotPerform())
      tgt.setDoNotPerformElement(Boolean43_50.convertBoolean(src.getDoNotPerformElement()));
    if (src.hasTiming())
      tgt.setTiming(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getTiming()));
    if (src.hasLocation())
      tgt.setLocation(new CodeableReference(Reference43_50.convertReference(src.getLocation())));
    for (org.hl7.fhir.r4b.model.ActivityDefinition.ActivityDefinitionParticipantComponent t : src.getParticipant())
      tgt.addParticipant(convertActivityDefinitionParticipantComponent(t));
    if (src.hasProduct())
      tgt.setProduct(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getProduct()));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity43_50.convertSimpleQuantity(src.getQuantity()));
    for (org.hl7.fhir.r4b.model.Dosage t : src.getDosage()) tgt.addDosage(Dosage43_50.convertDosage(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getBodySite())
      tgt.addBodySite(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getSpecimenRequirement())
      tgt.getSpecimenRequirement().add(Reference43_50.convertReferenceToCanonical(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getObservationRequirement())
      tgt.getObservationRequirement().add(Reference43_50.convertReferenceToCanonical(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getObservationResultRequirement())
      tgt.getObservationResultRequirement().add(Reference43_50.convertReferenceToCanonical(t));
    if (src.hasTransform())
      tgt.setTransformElement(Canonical43_50.convertCanonical(src.getTransformElement()));
    for (org.hl7.fhir.r4b.model.ActivityDefinition.ActivityDefinitionDynamicValueComponent t : src.getDynamicValue())
      tgt.addDynamicValue(convertActivityDefinitionDynamicValueComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ActivityDefinition convertActivityDefinition(org.hl7.fhir.r5.model.ActivityDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ActivityDefinition tgt = new org.hl7.fhir.r4b.model.ActivityDefinition();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri43_50.convertUri(src.getUrlElement()));
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    if (src.hasVersion())
      tgt.setVersionElement(String43_50.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String43_50.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String43_50.convertString(src.getTitleElement()));
    if (src.hasSubtitle())
      tgt.setSubtitleElement(String43_50.convertString(src.getSubtitleElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations43_50.convertPublicationStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean43_50.convertBoolean(src.getExperimentalElement()));
    if (src.hasSubject())
      tgt.setSubject(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getSubject()));
    if (src.hasDate())
      tgt.setDateElement(DateTime43_50.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String43_50.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.r5.model.ContactDetail t : src.getContact())
      tgt.addContact(ContactDetail43_50.convertContactDetail(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown43_50.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r5.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(UsageContext43_50.convertUsageContext(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasPurpose())
      tgt.setPurposeElement(MarkDown43_50.convertMarkdown(src.getPurposeElement()));
    if (src.hasUsage())
      tgt.setUsageElement(String43_50.convertString(src.getUsageElement()));
    if (src.hasCopyright())
      tgt.setCopyrightElement(MarkDown43_50.convertMarkdown(src.getCopyrightElement()));
    if (src.hasApprovalDate())
      tgt.setApprovalDateElement(Date43_50.convertDate(src.getApprovalDateElement()));
    if (src.hasLastReviewDate())
      tgt.setLastReviewDateElement(Date43_50.convertDate(src.getLastReviewDateElement()));
    if (src.hasEffectivePeriod())
      tgt.setEffectivePeriod(Period43_50.convertPeriod(src.getEffectivePeriod()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getTopic())
      tgt.addTopic(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.ContactDetail t : src.getAuthor())
      tgt.addAuthor(ContactDetail43_50.convertContactDetail(t));
    for (org.hl7.fhir.r5.model.ContactDetail t : src.getEditor())
      tgt.addEditor(ContactDetail43_50.convertContactDetail(t));
    for (org.hl7.fhir.r5.model.ContactDetail t : src.getReviewer())
      tgt.addReviewer(ContactDetail43_50.convertContactDetail(t));
    for (org.hl7.fhir.r5.model.ContactDetail t : src.getEndorser())
      tgt.addEndorser(ContactDetail43_50.convertContactDetail(t));
    for (org.hl7.fhir.r5.model.RelatedArtifact t : src.getRelatedArtifact())
      tgt.addRelatedArtifact(RelatedArtifact43_50.convertRelatedArtifact(t));
    for (org.hl7.fhir.r5.model.CanonicalType t : src.getLibrary())
      tgt.getLibrary().add(Canonical43_50.convertCanonical(t));
    if (src.hasKind())
      tgt.setKindElement(convertActivityDefinitionKind(src.getKindElement()));
    if (src.hasProfile())
      tgt.setProfileElement(Canonical43_50.convertCanonical(src.getProfileElement()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_50.convertCodeableConcept(src.getCode()));
    if (src.hasIntent())
      tgt.setIntentElement(convertRequestIntent(src.getIntentElement()));
    if (src.hasPriority())
      tgt.setPriorityElement(convertRequestPriority(src.getPriorityElement()));
    if (src.hasDoNotPerform())
      tgt.setDoNotPerformElement(Boolean43_50.convertBoolean(src.getDoNotPerformElement()));
    if (src.hasTiming())
      tgt.setTiming(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getTiming()));
    if (src.getLocation().hasReference())
      tgt.setLocation(Reference43_50.convertReference(src.getLocation().getReference()));
    for (org.hl7.fhir.r5.model.ActivityDefinition.ActivityDefinitionParticipantComponent t : src.getParticipant())
      tgt.addParticipant(convertActivityDefinitionParticipantComponent(t));
    if (src.hasProduct())
      tgt.setProduct(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getProduct()));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity43_50.convertSimpleQuantity(src.getQuantity()));
    for (org.hl7.fhir.r5.model.Dosage t : src.getDosage()) tgt.addDosage(Dosage43_50.convertDosage(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getBodySite())
      tgt.addBodySite(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.CanonicalType t : src.getSpecimenRequirement())
      tgt.addSpecimenRequirement(Reference43_50.convertReferenceToCanonical(t));
    for (org.hl7.fhir.r5.model.CanonicalType t : src.getObservationRequirement())
      tgt.addObservationRequirement(Reference43_50.convertReferenceToCanonical(t));
    for (org.hl7.fhir.r5.model.CanonicalType t : src.getObservationResultRequirement())
      tgt.addObservationResultRequirement(Reference43_50.convertReferenceToCanonical(t));
    if (src.hasTransform())
      tgt.setTransformElement(Canonical43_50.convertCanonical(src.getTransformElement()));
    for (org.hl7.fhir.r5.model.ActivityDefinition.ActivityDefinitionDynamicValueComponent t : src.getDynamicValue())
      tgt.addDynamicValue(convertActivityDefinitionDynamicValueComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ActivityDefinition.RequestResourceTypes> convertActivityDefinitionKind(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ActivityDefinition.RequestResourceType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ActivityDefinition.RequestResourceTypes> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.ActivityDefinition.RequestResourceTypesEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case APPOINTMENT:
        tgt.setValue(org.hl7.fhir.r5.model.ActivityDefinition.RequestResourceTypes.APPOINTMENT);
        break;
      case APPOINTMENTRESPONSE:
        tgt.setValue(org.hl7.fhir.r5.model.ActivityDefinition.RequestResourceTypes.APPOINTMENTRESPONSE);
        break;
      case CAREPLAN:
        tgt.setValue(org.hl7.fhir.r5.model.ActivityDefinition.RequestResourceTypes.CAREPLAN);
        break;
      case CLAIM:
        tgt.setValue(org.hl7.fhir.r5.model.ActivityDefinition.RequestResourceTypes.CLAIM);
        break;
      case COMMUNICATIONREQUEST:
        tgt.setValue(org.hl7.fhir.r5.model.ActivityDefinition.RequestResourceTypes.COMMUNICATIONREQUEST);
        break;
      case DEVICEREQUEST:
        tgt.setValue(org.hl7.fhir.r5.model.ActivityDefinition.RequestResourceTypes.DEVICEREQUEST);
        break;
      case ENROLLMENTREQUEST:
        tgt.setValue(org.hl7.fhir.r5.model.ActivityDefinition.RequestResourceTypes.ENROLLMENTREQUEST);
        break;
      case IMMUNIZATIONRECOMMENDATION:
        tgt.setValue(org.hl7.fhir.r5.model.ActivityDefinition.RequestResourceTypes.IMMUNIZATIONRECOMMENDATION);
        break;
      case MEDICATIONREQUEST:
        tgt.setValue(org.hl7.fhir.r5.model.ActivityDefinition.RequestResourceTypes.MEDICATIONREQUEST);
        break;
      case NUTRITIONORDER:
        tgt.setValue(org.hl7.fhir.r5.model.ActivityDefinition.RequestResourceTypes.NUTRITIONORDER);
        break;
      case SERVICEREQUEST:
        tgt.setValue(org.hl7.fhir.r5.model.ActivityDefinition.RequestResourceTypes.SERVICEREQUEST);
        break;
      case SUPPLYREQUEST:
        tgt.setValue(org.hl7.fhir.r5.model.ActivityDefinition.RequestResourceTypes.SUPPLYREQUEST);
        break;
      case TASK:
        tgt.setValue(null);
        tgt.addExtension(VersionConvertorConstants.EXT_ACTUAL_RESOURCE_NAME, new CodeType("Task"));
        break;
      case VISIONPRESCRIPTION:
        tgt.setValue(org.hl7.fhir.r5.model.ActivityDefinition.RequestResourceTypes.VISIONPRESCRIPTION);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.ActivityDefinition.RequestResourceTypes.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ActivityDefinition.RequestResourceType> convertActivityDefinitionKind(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ActivityDefinition.RequestResourceTypes> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ActivityDefinition.RequestResourceType> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.ActivityDefinition.RequestResourceTypeEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt, VersionConvertorConstants.EXT_ACTUAL_RESOURCE_NAME);
    if (src.hasExtension(VersionConvertorConstants.EXT_ACTUAL_RESOURCE_NAME)) {
      tgt.setValueAsString(src.getExtensionString(VersionConvertorConstants.EXT_ACTUAL_RESOURCE_NAME));
    } else {
      switch (src.getValue()) {
      case APPOINTMENT:
        tgt.setValue(org.hl7.fhir.r4b.model.ActivityDefinition.RequestResourceType.APPOINTMENT);
        break;
      case APPOINTMENTRESPONSE:
        tgt.setValue(org.hl7.fhir.r4b.model.ActivityDefinition.RequestResourceType.APPOINTMENTRESPONSE);
        break;
      case CAREPLAN:
        tgt.setValue(org.hl7.fhir.r4b.model.ActivityDefinition.RequestResourceType.CAREPLAN);
        break;
      case CLAIM:
        tgt.setValue(org.hl7.fhir.r4b.model.ActivityDefinition.RequestResourceType.CLAIM);
        break;
      case COMMUNICATIONREQUEST:
        tgt.setValue(org.hl7.fhir.r4b.model.ActivityDefinition.RequestResourceType.COMMUNICATIONREQUEST);
        break;
      case DEVICEREQUEST:
        tgt.setValue(org.hl7.fhir.r4b.model.ActivityDefinition.RequestResourceType.DEVICEREQUEST);
        break;
      case ENROLLMENTREQUEST:
        tgt.setValue(org.hl7.fhir.r4b.model.ActivityDefinition.RequestResourceType.ENROLLMENTREQUEST);
        break;
      case IMMUNIZATIONRECOMMENDATION:
        tgt.setValue(org.hl7.fhir.r4b.model.ActivityDefinition.RequestResourceType.IMMUNIZATIONRECOMMENDATION);
        break;
      case MEDICATIONREQUEST:
        tgt.setValue(org.hl7.fhir.r4b.model.ActivityDefinition.RequestResourceType.MEDICATIONREQUEST);
        break;
      case NUTRITIONORDER:
        tgt.setValue(org.hl7.fhir.r4b.model.ActivityDefinition.RequestResourceType.NUTRITIONORDER);
        break;
      case SERVICEREQUEST:
        tgt.setValue(org.hl7.fhir.r4b.model.ActivityDefinition.RequestResourceType.SERVICEREQUEST);
        break;
      case SUPPLYREQUEST:
        tgt.setValue(org.hl7.fhir.r4b.model.ActivityDefinition.RequestResourceType.SUPPLYREQUEST);
        break;
      case VISIONPRESCRIPTION:
        tgt.setValue(org.hl7.fhir.r4b.model.ActivityDefinition.RequestResourceType.VISIONPRESCRIPTION);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.ActivityDefinition.RequestResourceType.NULL);
        break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestIntent> convertRequestIntent(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.RequestIntent> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestIntent> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.RequestIntentEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
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

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.RequestIntent> convertRequestIntent(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestIntent> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.RequestIntent> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.RequestIntentEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case PROPOSAL:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestIntent.PROPOSAL);
        break;
      case PLAN:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestIntent.PLAN);
        break;
      case DIRECTIVE:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestIntent.DIRECTIVE);
        break;
      case ORDER:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestIntent.ORDER);
        break;
      case ORIGINALORDER:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestIntent.ORIGINALORDER);
        break;
      case REFLEXORDER:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestIntent.REFLEXORDER);
        break;
      case FILLERORDER:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestIntent.FILLERORDER);
        break;
      case INSTANCEORDER:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestIntent.INSTANCEORDER);
        break;
      case OPTION:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestIntent.OPTION);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestIntent.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestPriority> convertRequestPriority(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.RequestPriority> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestPriority> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.RequestPriorityEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.RequestPriority> convertRequestPriority(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestPriority> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.RequestPriority> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.RequestPriorityEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
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
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ActivityDefinition.ActivityDefinitionParticipantComponent convertActivityDefinitionParticipantComponent(org.hl7.fhir.r4b.model.ActivityDefinition.ActivityDefinitionParticipantComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ActivityDefinition.ActivityDefinitionParticipantComponent tgt = new org.hl7.fhir.r5.model.ActivityDefinition.ActivityDefinitionParticipantComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setTypeElement(convertActivityParticipantType(src.getTypeElement()));
    if (src.hasRole())
      tgt.setRole(CodeableConcept43_50.convertCodeableConcept(src.getRole()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ActivityDefinition.ActivityDefinitionParticipantComponent convertActivityDefinitionParticipantComponent(org.hl7.fhir.r5.model.ActivityDefinition.ActivityDefinitionParticipantComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ActivityDefinition.ActivityDefinitionParticipantComponent tgt = new org.hl7.fhir.r4b.model.ActivityDefinition.ActivityDefinitionParticipantComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setTypeElement(convertActivityParticipantType(src.getTypeElement()));
    if (src.hasRole())
      tgt.setRole(CodeableConcept43_50.convertCodeableConcept(src.getRole()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionParticipantType> convertActivityParticipantType(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.ActionParticipantType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionParticipantType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.ActionParticipantTypeEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.ActionParticipantType> convertActivityParticipantType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionParticipantType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.ActionParticipantType> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.ActionParticipantTypeEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
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
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ActivityDefinition.ActivityDefinitionDynamicValueComponent convertActivityDefinitionDynamicValueComponent(org.hl7.fhir.r4b.model.ActivityDefinition.ActivityDefinitionDynamicValueComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ActivityDefinition.ActivityDefinitionDynamicValueComponent tgt = new org.hl7.fhir.r5.model.ActivityDefinition.ActivityDefinitionDynamicValueComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasPath())
      tgt.setPathElement(String43_50.convertString(src.getPathElement()));
    if (src.hasExpression())
      tgt.setExpression(Expression43_50.convertExpression(src.getExpression()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ActivityDefinition.ActivityDefinitionDynamicValueComponent convertActivityDefinitionDynamicValueComponent(org.hl7.fhir.r5.model.ActivityDefinition.ActivityDefinitionDynamicValueComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ActivityDefinition.ActivityDefinitionDynamicValueComponent tgt = new org.hl7.fhir.r4b.model.ActivityDefinition.ActivityDefinitionDynamicValueComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasPath())
      tgt.setPathElement(String43_50.convertString(src.getPathElement()));
    if (src.hasExpression())
      tgt.setExpression(Expression43_50.convertExpression(src.getExpression()));
    return tgt;
  }
}