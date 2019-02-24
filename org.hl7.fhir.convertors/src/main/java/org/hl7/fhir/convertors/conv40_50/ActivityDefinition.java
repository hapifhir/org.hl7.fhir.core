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


public class ActivityDefinition extends VersionConvertor_40_50 {

  public static org.hl7.fhir.r5.model.ActivityDefinition convertActivityDefinition(org.hl7.fhir.r4.model.ActivityDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ActivityDefinition tgt = new org.hl7.fhir.r5.model.ActivityDefinition();
    copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(convertUri(src.getUrlElement()));
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    if (src.hasVersion())
      tgt.setVersionElement(convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(convertString(src.getTitleElement()));
    if (src.hasSubtitle())
      tgt.setSubtitleElement(convertString(src.getSubtitleElement()));
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
    for (org.hl7.fhir.r4.model.ContactDetail t : src.getContact())
      tgt.addContact(convertContactDetail(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r4.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(convertUsageContext(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(convertCodeableConcept(t));
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
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getTopic())
      tgt.addTopic(convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.ContactDetail t : src.getAuthor())
      tgt.addAuthor(convertContactDetail(t));
    for (org.hl7.fhir.r4.model.ContactDetail t : src.getEditor())
      tgt.addEditor(convertContactDetail(t));
    for (org.hl7.fhir.r4.model.ContactDetail t : src.getReviewer())
      tgt.addReviewer(convertContactDetail(t));
    for (org.hl7.fhir.r4.model.ContactDetail t : src.getEndorser())
      tgt.addEndorser(convertContactDetail(t));
    for (org.hl7.fhir.r4.model.RelatedArtifact t : src.getRelatedArtifact())
      tgt.addRelatedArtifact(convertRelatedArtifact(t));
    for (org.hl7.fhir.r4.model.CanonicalType t : src.getLibrary())
      tgt.getLibrary().add(convertCanonical(t));
    if (src.hasKind())
      tgt.setKind(convertActivityDefinitionKind(src.getKind()));
    if (src.hasProfile())
      tgt.setProfileElement(convertCanonical(src.getProfileElement()));
    if (src.hasCode())
      tgt.setCode(convertCodeableConcept(src.getCode()));
    if (src.hasIntent())
      tgt.setIntent(convertRequestIntent(src.getIntent()));
    if (src.hasPriority())
      tgt.setPriority(convertRequestPriority(src.getPriority()));
    if (src.hasDoNotPerform())
      tgt.setDoNotPerformElement(convertBoolean(src.getDoNotPerformElement()));
    if (src.hasTiming())
      tgt.setTiming(convertType(src.getTiming()));
    if (src.hasLocation())
      tgt.setLocation(convertReference(src.getLocation()));
    for (org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionParticipantComponent t : src.getParticipant())
      tgt.addParticipant(convertActivityDefinitionParticipantComponent(t));
    if (src.hasProduct())
      tgt.setProduct(convertType(src.getProduct()));
    if (src.hasQuantity())
      tgt.setQuantity(convertSimpleQuantity(src.getQuantity()));
    for (org.hl7.fhir.r4.model.Dosage t : src.getDosage())
      tgt.addDosage(convertDosage(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getBodySite())
      tgt.addBodySite(convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getSpecimenRequirement())
      tgt.addSpecimenRequirement(convertReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getObservationRequirement())
      tgt.addObservationRequirement(convertReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getObservationResultRequirement())
      tgt.addObservationResultRequirement(convertReference(t));
    if (src.hasTransform())
      tgt.setTransformElement(convertCanonical(src.getTransformElement()));
    for (org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionDynamicValueComponent t : src.getDynamicValue())
      tgt.addDynamicValue(convertActivityDefinitionDynamicValueComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ActivityDefinition convertActivityDefinition(org.hl7.fhir.r5.model.ActivityDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ActivityDefinition tgt = new org.hl7.fhir.r4.model.ActivityDefinition();
    copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(convertUri(src.getUrlElement()));
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    if (src.hasVersion())
      tgt.setVersionElement(convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(convertString(src.getTitleElement()));
    if (src.hasSubtitle())
      tgt.setSubtitleElement(convertString(src.getSubtitleElement()));
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
    for (org.hl7.fhir.r5.model.ContactDetail t : src.getContact())
      tgt.addContact(convertContactDetail(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r5.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(convertUsageContext(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(convertCodeableConcept(t));
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
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getTopic())
      tgt.addTopic(convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.ContactDetail t : src.getAuthor())
      tgt.addAuthor(convertContactDetail(t));
    for (org.hl7.fhir.r5.model.ContactDetail t : src.getEditor())
      tgt.addEditor(convertContactDetail(t));
    for (org.hl7.fhir.r5.model.ContactDetail t : src.getReviewer())
      tgt.addReviewer(convertContactDetail(t));
    for (org.hl7.fhir.r5.model.ContactDetail t : src.getEndorser())
      tgt.addEndorser(convertContactDetail(t));
    for (org.hl7.fhir.r5.model.RelatedArtifact t : src.getRelatedArtifact())
      tgt.addRelatedArtifact(convertRelatedArtifact(t));
    for (org.hl7.fhir.r5.model.CanonicalType t : src.getLibrary())
      tgt.getLibrary().add(convertCanonical(t));
    if (src.hasKind())
      tgt.setKind(convertActivityDefinitionKind(src.getKind()));
    if (src.hasProfile())
      tgt.setProfileElement(convertCanonical(src.getProfileElement()));
    if (src.hasCode())
      tgt.setCode(convertCodeableConcept(src.getCode()));
    if (src.hasIntent())
      tgt.setIntent(convertRequestIntent(src.getIntent()));
    if (src.hasPriority())
      tgt.setPriority(convertRequestPriority(src.getPriority()));
    if (src.hasDoNotPerform())
      tgt.setDoNotPerformElement(convertBoolean(src.getDoNotPerformElement()));
    if (src.hasTiming())
      tgt.setTiming(convertType(src.getTiming()));
    if (src.hasLocation())
      tgt.setLocation(convertReference(src.getLocation()));
    for (org.hl7.fhir.r5.model.ActivityDefinition.ActivityDefinitionParticipantComponent t : src.getParticipant())
      tgt.addParticipant(convertActivityDefinitionParticipantComponent(t));
    if (src.hasProduct())
      tgt.setProduct(convertType(src.getProduct()));
    if (src.hasQuantity())
      tgt.setQuantity(convertSimpleQuantity(src.getQuantity()));
    for (org.hl7.fhir.r5.model.Dosage t : src.getDosage())
      tgt.addDosage(convertDosage(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getBodySite())
      tgt.addBodySite(convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getSpecimenRequirement())
      tgt.addSpecimenRequirement(convertReference(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getObservationRequirement())
      tgt.addObservationRequirement(convertReference(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getObservationResultRequirement())
      tgt.addObservationResultRequirement(convertReference(t));
    if (src.hasTransform())
      tgt.setTransformElement(convertCanonical(src.getTransformElement()));
    for (org.hl7.fhir.r5.model.ActivityDefinition.ActivityDefinitionDynamicValueComponent t : src.getDynamicValue())
      tgt.addDynamicValue(convertActivityDefinitionDynamicValueComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ActivityDefinition.ActivityDefinitionKind convertActivityDefinitionKind(org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionKind src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case APPOINTMENT: return org.hl7.fhir.r5.model.ActivityDefinition.ActivityDefinitionKind.APPOINTMENT;
    case APPOINTMENTRESPONSE: return org.hl7.fhir.r5.model.ActivityDefinition.ActivityDefinitionKind.APPOINTMENTRESPONSE;
    case CAREPLAN: return org.hl7.fhir.r5.model.ActivityDefinition.ActivityDefinitionKind.CAREPLAN;
    case CLAIM: return org.hl7.fhir.r5.model.ActivityDefinition.ActivityDefinitionKind.CLAIM;
    case COMMUNICATIONREQUEST: return org.hl7.fhir.r5.model.ActivityDefinition.ActivityDefinitionKind.COMMUNICATIONREQUEST;
    case CONTRACT: return org.hl7.fhir.r5.model.ActivityDefinition.ActivityDefinitionKind.CONTRACT;
    case DEVICEREQUEST: return org.hl7.fhir.r5.model.ActivityDefinition.ActivityDefinitionKind.DEVICEREQUEST;
    case ENROLLMENTREQUEST: return org.hl7.fhir.r5.model.ActivityDefinition.ActivityDefinitionKind.ENROLLMENTREQUEST;
    case IMMUNIZATIONRECOMMENDATION: return org.hl7.fhir.r5.model.ActivityDefinition.ActivityDefinitionKind.IMMUNIZATIONRECOMMENDATION;
    case MEDICATIONREQUEST: return org.hl7.fhir.r5.model.ActivityDefinition.ActivityDefinitionKind.MEDICATIONREQUEST;
    case NUTRITIONORDER: return org.hl7.fhir.r5.model.ActivityDefinition.ActivityDefinitionKind.NUTRITIONORDER;
    case SERVICEREQUEST: return org.hl7.fhir.r5.model.ActivityDefinition.ActivityDefinitionKind.SERVICEREQUEST;
    case SUPPLYREQUEST: return org.hl7.fhir.r5.model.ActivityDefinition.ActivityDefinitionKind.SUPPLYREQUEST;
    case TASK: return org.hl7.fhir.r5.model.ActivityDefinition.ActivityDefinitionKind.TASK;
    case VISIONPRESCRIPTION: return org.hl7.fhir.r5.model.ActivityDefinition.ActivityDefinitionKind.VISIONPRESCRIPTION;
    default: return org.hl7.fhir.r5.model.ActivityDefinition.ActivityDefinitionKind.NULL;
  }
}

  public static org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionKind convertActivityDefinitionKind(org.hl7.fhir.r5.model.ActivityDefinition.ActivityDefinitionKind src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case APPOINTMENT: return org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionKind.APPOINTMENT;
    case APPOINTMENTRESPONSE: return org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionKind.APPOINTMENTRESPONSE;
    case CAREPLAN: return org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionKind.CAREPLAN;
    case CLAIM: return org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionKind.CLAIM;
    case COMMUNICATIONREQUEST: return org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionKind.COMMUNICATIONREQUEST;
    case CONTRACT: return org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionKind.CONTRACT;
    case DEVICEREQUEST: return org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionKind.DEVICEREQUEST;
    case ENROLLMENTREQUEST: return org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionKind.ENROLLMENTREQUEST;
    case IMMUNIZATIONRECOMMENDATION: return org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionKind.IMMUNIZATIONRECOMMENDATION;
    case MEDICATIONREQUEST: return org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionKind.MEDICATIONREQUEST;
    case NUTRITIONORDER: return org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionKind.NUTRITIONORDER;
    case SERVICEREQUEST: return org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionKind.SERVICEREQUEST;
    case SUPPLYREQUEST: return org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionKind.SUPPLYREQUEST;
    case TASK: return org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionKind.TASK;
    case VISIONPRESCRIPTION: return org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionKind.VISIONPRESCRIPTION;
    default: return org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionKind.NULL;
  }
}

  public static org.hl7.fhir.r5.model.ActivityDefinition.RequestIntent convertRequestIntent(org.hl7.fhir.r4.model.ActivityDefinition.RequestIntent src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case PROPOSAL: return org.hl7.fhir.r5.model.ActivityDefinition.RequestIntent.PROPOSAL;
    case PLAN: return org.hl7.fhir.r5.model.ActivityDefinition.RequestIntent.PLAN;
    case DIRECTIVE: return org.hl7.fhir.r5.model.ActivityDefinition.RequestIntent.DIRECTIVE;
    case ORDER: return org.hl7.fhir.r5.model.ActivityDefinition.RequestIntent.ORDER;
    case ORIGINALORDER: return org.hl7.fhir.r5.model.ActivityDefinition.RequestIntent.ORIGINALORDER;
    case REFLEXORDER: return org.hl7.fhir.r5.model.ActivityDefinition.RequestIntent.REFLEXORDER;
    case FILLERORDER: return org.hl7.fhir.r5.model.ActivityDefinition.RequestIntent.FILLERORDER;
    case INSTANCEORDER: return org.hl7.fhir.r5.model.ActivityDefinition.RequestIntent.INSTANCEORDER;
    case OPTION: return org.hl7.fhir.r5.model.ActivityDefinition.RequestIntent.OPTION;
    default: return org.hl7.fhir.r5.model.ActivityDefinition.RequestIntent.NULL;
  }
}

  public static org.hl7.fhir.r4.model.ActivityDefinition.RequestIntent convertRequestIntent(org.hl7.fhir.r5.model.ActivityDefinition.RequestIntent src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case PROPOSAL: return org.hl7.fhir.r4.model.ActivityDefinition.RequestIntent.PROPOSAL;
    case PLAN: return org.hl7.fhir.r4.model.ActivityDefinition.RequestIntent.PLAN;
    case DIRECTIVE: return org.hl7.fhir.r4.model.ActivityDefinition.RequestIntent.DIRECTIVE;
    case ORDER: return org.hl7.fhir.r4.model.ActivityDefinition.RequestIntent.ORDER;
    case ORIGINALORDER: return org.hl7.fhir.r4.model.ActivityDefinition.RequestIntent.ORIGINALORDER;
    case REFLEXORDER: return org.hl7.fhir.r4.model.ActivityDefinition.RequestIntent.REFLEXORDER;
    case FILLERORDER: return org.hl7.fhir.r4.model.ActivityDefinition.RequestIntent.FILLERORDER;
    case INSTANCEORDER: return org.hl7.fhir.r4.model.ActivityDefinition.RequestIntent.INSTANCEORDER;
    case OPTION: return org.hl7.fhir.r4.model.ActivityDefinition.RequestIntent.OPTION;
    default: return org.hl7.fhir.r4.model.ActivityDefinition.RequestIntent.NULL;
  }
}

  public static org.hl7.fhir.r5.model.ActivityDefinition.RequestPriority convertRequestPriority(org.hl7.fhir.r4.model.ActivityDefinition.RequestPriority src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case ROUTINE: return org.hl7.fhir.r5.model.ActivityDefinition.RequestPriority.ROUTINE;
    case URGENT: return org.hl7.fhir.r5.model.ActivityDefinition.RequestPriority.URGENT;
    case ASAP: return org.hl7.fhir.r5.model.ActivityDefinition.RequestPriority.ASAP;
    case STAT: return org.hl7.fhir.r5.model.ActivityDefinition.RequestPriority.STAT;
    default: return org.hl7.fhir.r5.model.ActivityDefinition.RequestPriority.NULL;
  }
}

  public static org.hl7.fhir.r4.model.ActivityDefinition.RequestPriority convertRequestPriority(org.hl7.fhir.r5.model.ActivityDefinition.RequestPriority src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case ROUTINE: return org.hl7.fhir.r4.model.ActivityDefinition.RequestPriority.ROUTINE;
    case URGENT: return org.hl7.fhir.r4.model.ActivityDefinition.RequestPriority.URGENT;
    case ASAP: return org.hl7.fhir.r4.model.ActivityDefinition.RequestPriority.ASAP;
    case STAT: return org.hl7.fhir.r4.model.ActivityDefinition.RequestPriority.STAT;
    default: return org.hl7.fhir.r4.model.ActivityDefinition.RequestPriority.NULL;
  }
}

  public static org.hl7.fhir.r5.model.ActivityDefinition.ActivityDefinitionParticipantComponent convertActivityDefinitionParticipantComponent(org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionParticipantComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ActivityDefinition.ActivityDefinitionParticipantComponent tgt = new org.hl7.fhir.r5.model.ActivityDefinition.ActivityDefinitionParticipantComponent();
    copyElement(src, tgt);
    if (src.hasType())
      tgt.setType(convertActivityParticipantType(src.getType()));
    if (src.hasRole())
      tgt.setRole(convertCodeableConcept(src.getRole()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionParticipantComponent convertActivityDefinitionParticipantComponent(org.hl7.fhir.r5.model.ActivityDefinition.ActivityDefinitionParticipantComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionParticipantComponent tgt = new org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionParticipantComponent();
    copyElement(src, tgt);
    if (src.hasType())
      tgt.setType(convertActivityParticipantType(src.getType()));
    if (src.hasRole())
      tgt.setRole(convertCodeableConcept(src.getRole()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ActivityDefinition.ActivityParticipantType convertActivityParticipantType(org.hl7.fhir.r4.model.ActivityDefinition.ActivityParticipantType src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case PATIENT: return org.hl7.fhir.r5.model.ActivityDefinition.ActivityParticipantType.PATIENT;
    case PRACTITIONER: return org.hl7.fhir.r5.model.ActivityDefinition.ActivityParticipantType.PRACTITIONER;
    case RELATEDPERSON: return org.hl7.fhir.r5.model.ActivityDefinition.ActivityParticipantType.RELATEDPERSON;
    case DEVICE: return org.hl7.fhir.r5.model.ActivityDefinition.ActivityParticipantType.DEVICE;
    default: return org.hl7.fhir.r5.model.ActivityDefinition.ActivityParticipantType.NULL;
  }
}

  public static org.hl7.fhir.r4.model.ActivityDefinition.ActivityParticipantType convertActivityParticipantType(org.hl7.fhir.r5.model.ActivityDefinition.ActivityParticipantType src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case PATIENT: return org.hl7.fhir.r4.model.ActivityDefinition.ActivityParticipantType.PATIENT;
    case PRACTITIONER: return org.hl7.fhir.r4.model.ActivityDefinition.ActivityParticipantType.PRACTITIONER;
    case RELATEDPERSON: return org.hl7.fhir.r4.model.ActivityDefinition.ActivityParticipantType.RELATEDPERSON;
    case DEVICE: return org.hl7.fhir.r4.model.ActivityDefinition.ActivityParticipantType.DEVICE;
    default: return org.hl7.fhir.r4.model.ActivityDefinition.ActivityParticipantType.NULL;
  }
}

  public static org.hl7.fhir.r5.model.ActivityDefinition.ActivityDefinitionDynamicValueComponent convertActivityDefinitionDynamicValueComponent(org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionDynamicValueComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ActivityDefinition.ActivityDefinitionDynamicValueComponent tgt = new org.hl7.fhir.r5.model.ActivityDefinition.ActivityDefinitionDynamicValueComponent();
    copyElement(src, tgt);
    if (src.hasPath())
      tgt.setPathElement(convertString(src.getPathElement()));
    if (src.hasExpression())
      tgt.setExpression(convertExpression(src.getExpression()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionDynamicValueComponent convertActivityDefinitionDynamicValueComponent(org.hl7.fhir.r5.model.ActivityDefinition.ActivityDefinitionDynamicValueComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionDynamicValueComponent tgt = new org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionDynamicValueComponent();
    copyElement(src, tgt);
    if (src.hasPath())
      tgt.setPathElement(convertString(src.getPathElement()));
    if (src.hasExpression())
      tgt.setExpression(convertExpression(src.getExpression()));
    return tgt;
  }


}
