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


public class ResearchElementDefinition extends VersionConvertor_40_50 {

  public static org.hl7.fhir.r5.model.ResearchElementDefinition convertResearchElementDefinition(org.hl7.fhir.r4.model.ResearchElementDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ResearchElementDefinition tgt = new org.hl7.fhir.r5.model.ResearchElementDefinition();
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
    if (src.hasShortTitle())
      tgt.setShortTitleElement(convertString(src.getShortTitleElement()));
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
    for (org.hl7.fhir.r4.model.StringType t : src.getComment())
      tgt.getComment().add(convertString(t));
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
    if (src.hasType())
      tgt.setType(convertResearchElementType(src.getType()));
    if (src.hasVariableType())
      tgt.setVariableType(convertVariableType(src.getVariableType()));
    for (org.hl7.fhir.r4.model.ResearchElementDefinition.ResearchElementDefinitionCharacteristicComponent t : src.getCharacteristic())
      tgt.addCharacteristic(convertResearchElementDefinitionCharacteristicComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ResearchElementDefinition convertResearchElementDefinition(org.hl7.fhir.r5.model.ResearchElementDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ResearchElementDefinition tgt = new org.hl7.fhir.r4.model.ResearchElementDefinition();
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
    if (src.hasShortTitle())
      tgt.setShortTitleElement(convertString(src.getShortTitleElement()));
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
    for (org.hl7.fhir.r5.model.StringType t : src.getComment())
      tgt.getComment().add(convertString(t));
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
    if (src.hasType())
      tgt.setType(convertResearchElementType(src.getType()));
    if (src.hasVariableType())
      tgt.setVariableType(convertVariableType(src.getVariableType()));
    for (org.hl7.fhir.r5.model.ResearchElementDefinition.ResearchElementDefinitionCharacteristicComponent t : src.getCharacteristic())
      tgt.addCharacteristic(convertResearchElementDefinitionCharacteristicComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ResearchElementDefinition.ResearchElementType convertResearchElementType(org.hl7.fhir.r4.model.ResearchElementDefinition.ResearchElementType src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case POPULATION: return org.hl7.fhir.r5.model.ResearchElementDefinition.ResearchElementType.POPULATION;
    case EXPOSURE: return org.hl7.fhir.r5.model.ResearchElementDefinition.ResearchElementType.EXPOSURE;
    case OUTCOME: return org.hl7.fhir.r5.model.ResearchElementDefinition.ResearchElementType.OUTCOME;
    default: return org.hl7.fhir.r5.model.ResearchElementDefinition.ResearchElementType.NULL;
  }
}

  public static org.hl7.fhir.r4.model.ResearchElementDefinition.ResearchElementType convertResearchElementType(org.hl7.fhir.r5.model.ResearchElementDefinition.ResearchElementType src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case POPULATION: return org.hl7.fhir.r4.model.ResearchElementDefinition.ResearchElementType.POPULATION;
    case EXPOSURE: return org.hl7.fhir.r4.model.ResearchElementDefinition.ResearchElementType.EXPOSURE;
    case OUTCOME: return org.hl7.fhir.r4.model.ResearchElementDefinition.ResearchElementType.OUTCOME;
    default: return org.hl7.fhir.r4.model.ResearchElementDefinition.ResearchElementType.NULL;
  }
}

  public static org.hl7.fhir.r5.model.ResearchElementDefinition.VariableType convertVariableType(org.hl7.fhir.r4.model.ResearchElementDefinition.VariableType src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case DICHOTOMOUS: return org.hl7.fhir.r5.model.ResearchElementDefinition.VariableType.DICHOTOMOUS;
    case CONTINUOUS: return org.hl7.fhir.r5.model.ResearchElementDefinition.VariableType.CONTINUOUS;
    case DESCRIPTIVE: return org.hl7.fhir.r5.model.ResearchElementDefinition.VariableType.DESCRIPTIVE;
    default: return org.hl7.fhir.r5.model.ResearchElementDefinition.VariableType.NULL;
  }
}

  public static org.hl7.fhir.r4.model.ResearchElementDefinition.VariableType convertVariableType(org.hl7.fhir.r5.model.ResearchElementDefinition.VariableType src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case DICHOTOMOUS: return org.hl7.fhir.r4.model.ResearchElementDefinition.VariableType.DICHOTOMOUS;
    case CONTINUOUS: return org.hl7.fhir.r4.model.ResearchElementDefinition.VariableType.CONTINUOUS;
    case DESCRIPTIVE: return org.hl7.fhir.r4.model.ResearchElementDefinition.VariableType.DESCRIPTIVE;
    default: return org.hl7.fhir.r4.model.ResearchElementDefinition.VariableType.NULL;
  }
}

  public static org.hl7.fhir.r5.model.ResearchElementDefinition.ResearchElementDefinitionCharacteristicComponent convertResearchElementDefinitionCharacteristicComponent(org.hl7.fhir.r4.model.ResearchElementDefinition.ResearchElementDefinitionCharacteristicComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ResearchElementDefinition.ResearchElementDefinitionCharacteristicComponent tgt = new org.hl7.fhir.r5.model.ResearchElementDefinition.ResearchElementDefinitionCharacteristicComponent();
    copyElement(src, tgt);
    if (src.hasDefinition())
      tgt.setDefinition(convertType(src.getDefinition()));
    for (org.hl7.fhir.r4.model.UsageContext t : src.getUsageContext())
      tgt.addUsageContext(convertUsageContext(t));
    if (src.hasExclude())
      tgt.setExcludeElement(convertBoolean(src.getExcludeElement()));
    if (src.hasUnitOfMeasure())
      tgt.setUnitOfMeasure(convertCodeableConcept(src.getUnitOfMeasure()));
    if (src.hasStudyEffectiveDescription())
      tgt.setStudyEffectiveDescriptionElement(convertString(src.getStudyEffectiveDescriptionElement()));
    if (src.hasStudyEffective())
      tgt.setStudyEffective(convertType(src.getStudyEffective()));
    if (src.hasStudyEffectiveTimeFromStart())
      tgt.setStudyEffectiveTimeFromStart(convertDuration(src.getStudyEffectiveTimeFromStart()));
    if (src.hasStudyEffectiveGroupMeasure())
      tgt.setStudyEffectiveGroupMeasure(convertGroupMeasure(src.getStudyEffectiveGroupMeasure()));
    if (src.hasParticipantEffectiveDescription())
      tgt.setParticipantEffectiveDescriptionElement(convertString(src.getParticipantEffectiveDescriptionElement()));
    if (src.hasParticipantEffective())
      tgt.setParticipantEffective(convertType(src.getParticipantEffective()));
    if (src.hasParticipantEffectiveTimeFromStart())
      tgt.setParticipantEffectiveTimeFromStart(convertDuration(src.getParticipantEffectiveTimeFromStart()));
    if (src.hasParticipantEffectiveGroupMeasure())
      tgt.setParticipantEffectiveGroupMeasure(convertGroupMeasure(src.getParticipantEffectiveGroupMeasure()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ResearchElementDefinition.ResearchElementDefinitionCharacteristicComponent convertResearchElementDefinitionCharacteristicComponent(org.hl7.fhir.r5.model.ResearchElementDefinition.ResearchElementDefinitionCharacteristicComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ResearchElementDefinition.ResearchElementDefinitionCharacteristicComponent tgt = new org.hl7.fhir.r4.model.ResearchElementDefinition.ResearchElementDefinitionCharacteristicComponent();
    copyElement(src, tgt);
    if (src.hasDefinition())
      tgt.setDefinition(convertType(src.getDefinition()));
    for (org.hl7.fhir.r5.model.UsageContext t : src.getUsageContext())
      tgt.addUsageContext(convertUsageContext(t));
    if (src.hasExclude())
      tgt.setExcludeElement(convertBoolean(src.getExcludeElement()));
    if (src.hasUnitOfMeasure())
      tgt.setUnitOfMeasure(convertCodeableConcept(src.getUnitOfMeasure()));
    if (src.hasStudyEffectiveDescription())
      tgt.setStudyEffectiveDescriptionElement(convertString(src.getStudyEffectiveDescriptionElement()));
    if (src.hasStudyEffective())
      tgt.setStudyEffective(convertType(src.getStudyEffective()));
    if (src.hasStudyEffectiveTimeFromStart())
      tgt.setStudyEffectiveTimeFromStart(convertDuration(src.getStudyEffectiveTimeFromStart()));
    if (src.hasStudyEffectiveGroupMeasure())
      tgt.setStudyEffectiveGroupMeasure(convertGroupMeasure(src.getStudyEffectiveGroupMeasure()));
    if (src.hasParticipantEffectiveDescription())
      tgt.setParticipantEffectiveDescriptionElement(convertString(src.getParticipantEffectiveDescriptionElement()));
    if (src.hasParticipantEffective())
      tgt.setParticipantEffective(convertType(src.getParticipantEffective()));
    if (src.hasParticipantEffectiveTimeFromStart())
      tgt.setParticipantEffectiveTimeFromStart(convertDuration(src.getParticipantEffectiveTimeFromStart()));
    if (src.hasParticipantEffectiveGroupMeasure())
      tgt.setParticipantEffectiveGroupMeasure(convertGroupMeasure(src.getParticipantEffectiveGroupMeasure()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ResearchElementDefinition.GroupMeasure convertGroupMeasure(org.hl7.fhir.r4.model.ResearchElementDefinition.GroupMeasure src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case MEAN: return org.hl7.fhir.r5.model.ResearchElementDefinition.GroupMeasure.MEAN;
    case MEDIAN: return org.hl7.fhir.r5.model.ResearchElementDefinition.GroupMeasure.MEDIAN;
    case MEANOFMEAN: return org.hl7.fhir.r5.model.ResearchElementDefinition.GroupMeasure.MEANOFMEAN;
    case MEANOFMEDIAN: return org.hl7.fhir.r5.model.ResearchElementDefinition.GroupMeasure.MEANOFMEDIAN;
    case MEDIANOFMEAN: return org.hl7.fhir.r5.model.ResearchElementDefinition.GroupMeasure.MEDIANOFMEAN;
    case MEDIANOFMEDIAN: return org.hl7.fhir.r5.model.ResearchElementDefinition.GroupMeasure.MEDIANOFMEDIAN;
    default: return org.hl7.fhir.r5.model.ResearchElementDefinition.GroupMeasure.NULL;
  }
}

  public static org.hl7.fhir.r4.model.ResearchElementDefinition.GroupMeasure convertGroupMeasure(org.hl7.fhir.r5.model.ResearchElementDefinition.GroupMeasure src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case MEAN: return org.hl7.fhir.r4.model.ResearchElementDefinition.GroupMeasure.MEAN;
    case MEDIAN: return org.hl7.fhir.r4.model.ResearchElementDefinition.GroupMeasure.MEDIAN;
    case MEANOFMEAN: return org.hl7.fhir.r4.model.ResearchElementDefinition.GroupMeasure.MEANOFMEAN;
    case MEANOFMEDIAN: return org.hl7.fhir.r4.model.ResearchElementDefinition.GroupMeasure.MEANOFMEDIAN;
    case MEDIANOFMEAN: return org.hl7.fhir.r4.model.ResearchElementDefinition.GroupMeasure.MEDIANOFMEAN;
    case MEDIANOFMEDIAN: return org.hl7.fhir.r4.model.ResearchElementDefinition.GroupMeasure.MEDIANOFMEDIAN;
    default: return org.hl7.fhir.r4.model.ResearchElementDefinition.GroupMeasure.NULL;
  }
}


}
