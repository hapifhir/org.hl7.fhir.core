package org.hl7.fhir.convertors.conv40_50;


import org.hl7.fhir.convertors.VersionConvertor_40_50;
import org.hl7.fhir.exceptions.FHIRException;

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
public class ActivityDefinition40_50 extends VersionConvertor_40_50 {

    public static org.hl7.fhir.r5.model.ActivityDefinition convertActivityDefinition(org.hl7.fhir.r4.model.ActivityDefinition src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ActivityDefinition tgt = new org.hl7.fhir.r5.model.ActivityDefinition();
        copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrlElement(convertUri(src.getUrlElement()));
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        if (src.hasVersion())
            tgt.setVersionElement(convertString(src.getVersionElement()));
        if (src.hasName())
            tgt.setNameElement(convertString(src.getNameElement()));
        if (src.hasTitle())
            tgt.setTitleElement(convertString(src.getTitleElement()));
        if (src.hasSubtitle())
            tgt.setSubtitleElement(convertString(src.getSubtitleElement()));
        if (src.hasStatus())
            tgt.setStatusElement(Enumerations40_50.convertPublicationStatus(src.getStatusElement()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(convertBoolean(src.getExperimentalElement()));
        if (src.hasSubject())
            tgt.setSubject(convertType(src.getSubject()));
        if (src.hasDate())
            tgt.setDateElement(convertDateTime(src.getDateElement()));
        if (src.hasPublisher())
            tgt.setPublisherElement(convertString(src.getPublisherElement()));
        for (org.hl7.fhir.r4.model.ContactDetail t : src.getContact()) tgt.addContact(convertContactDetail(t));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertMarkdown(src.getDescriptionElement()));
        for (org.hl7.fhir.r4.model.UsageContext t : src.getUseContext()) tgt.addUseContext(convertUsageContext(t));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(convertCodeableConcept(t));
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
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getTopic()) tgt.addTopic(convertCodeableConcept(t));
        for (org.hl7.fhir.r4.model.ContactDetail t : src.getAuthor()) tgt.addAuthor(convertContactDetail(t));
        for (org.hl7.fhir.r4.model.ContactDetail t : src.getEditor()) tgt.addEditor(convertContactDetail(t));
        for (org.hl7.fhir.r4.model.ContactDetail t : src.getReviewer()) tgt.addReviewer(convertContactDetail(t));
        for (org.hl7.fhir.r4.model.ContactDetail t : src.getEndorser()) tgt.addEndorser(convertContactDetail(t));
        for (org.hl7.fhir.r4.model.RelatedArtifact t : src.getRelatedArtifact()) tgt.addRelatedArtifact(convertRelatedArtifact(t));
        for (org.hl7.fhir.r4.model.CanonicalType t : src.getLibrary()) tgt.getLibrary().add(convertCanonical(t));
        if (src.hasKind())
            tgt.setKindElement(convertActivityDefinitionKind(src.getKindElement()));
        if (src.hasProfile())
            tgt.setProfileElement(convertCanonical(src.getProfileElement()));
        if (src.hasCode())
            tgt.setCode(convertCodeableConcept(src.getCode()));
        if (src.hasIntent())
            tgt.setIntentElement(convertRequestIntent(src.getIntentElement()));
        if (src.hasPriority())
            tgt.setPriorityElement(convertRequestPriority(src.getPriorityElement()));
        if (src.hasDoNotPerform())
            tgt.setDoNotPerformElement(convertBoolean(src.getDoNotPerformElement()));
        if (src.hasTiming())
            tgt.setTiming(convertType(src.getTiming()));
        if (src.hasLocation())
            tgt.setLocation(convertReference(src.getLocation()));
        for (org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionParticipantComponent t : src.getParticipant()) tgt.addParticipant(convertActivityDefinitionParticipantComponent(t));
        if (src.hasProduct())
            tgt.setProduct(convertType(src.getProduct()));
        if (src.hasQuantity())
            tgt.setQuantity(convertSimpleQuantity(src.getQuantity()));
        for (org.hl7.fhir.r4.model.Dosage t : src.getDosage()) tgt.addDosage(convertDosage(t));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getBodySite()) tgt.addBodySite(convertCodeableConcept(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getSpecimenRequirement()) tgt.addSpecimenRequirement(convertReference(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getObservationRequirement()) tgt.addObservationRequirement(convertReference(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getObservationResultRequirement()) tgt.addObservationResultRequirement(convertReference(t));
        if (src.hasTransform())
            tgt.setTransformElement(convertCanonical(src.getTransformElement()));
        for (org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionDynamicValueComponent t : src.getDynamicValue()) tgt.addDynamicValue(convertActivityDefinitionDynamicValueComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ActivityDefinition convertActivityDefinition(org.hl7.fhir.r5.model.ActivityDefinition src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ActivityDefinition tgt = new org.hl7.fhir.r4.model.ActivityDefinition();
        copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrlElement(convertUri(src.getUrlElement()));
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        if (src.hasVersion())
            tgt.setVersionElement(convertString(src.getVersionElement()));
        if (src.hasName())
            tgt.setNameElement(convertString(src.getNameElement()));
        if (src.hasTitle())
            tgt.setTitleElement(convertString(src.getTitleElement()));
        if (src.hasSubtitle())
            tgt.setSubtitleElement(convertString(src.getSubtitleElement()));
        if (src.hasStatus())
            tgt.setStatusElement(Enumerations40_50.convertPublicationStatus(src.getStatusElement()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(convertBoolean(src.getExperimentalElement()));
        if (src.hasSubject())
            tgt.setSubject(convertType(src.getSubject()));
        if (src.hasDate())
            tgt.setDateElement(convertDateTime(src.getDateElement()));
        if (src.hasPublisher())
            tgt.setPublisherElement(convertString(src.getPublisherElement()));
        for (org.hl7.fhir.r5.model.ContactDetail t : src.getContact()) tgt.addContact(convertContactDetail(t));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertMarkdown(src.getDescriptionElement()));
        for (org.hl7.fhir.r5.model.UsageContext t : src.getUseContext()) tgt.addUseContext(convertUsageContext(t));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(convertCodeableConcept(t));
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
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getTopic()) tgt.addTopic(convertCodeableConcept(t));
        for (org.hl7.fhir.r5.model.ContactDetail t : src.getAuthor()) tgt.addAuthor(convertContactDetail(t));
        for (org.hl7.fhir.r5.model.ContactDetail t : src.getEditor()) tgt.addEditor(convertContactDetail(t));
        for (org.hl7.fhir.r5.model.ContactDetail t : src.getReviewer()) tgt.addReviewer(convertContactDetail(t));
        for (org.hl7.fhir.r5.model.ContactDetail t : src.getEndorser()) tgt.addEndorser(convertContactDetail(t));
        for (org.hl7.fhir.r5.model.RelatedArtifact t : src.getRelatedArtifact()) tgt.addRelatedArtifact(convertRelatedArtifact(t));
        for (org.hl7.fhir.r5.model.CanonicalType t : src.getLibrary()) tgt.getLibrary().add(convertCanonical(t));
        if (src.hasKind())
            tgt.setKindElement(convertActivityDefinitionKind(src.getKindElement()));
        if (src.hasProfile())
            tgt.setProfileElement(convertCanonical(src.getProfileElement()));
        if (src.hasCode())
            tgt.setCode(convertCodeableConcept(src.getCode()));
        if (src.hasIntent())
            tgt.setIntentElement(convertRequestIntent(src.getIntentElement()));
        if (src.hasPriority())
            tgt.setPriorityElement(convertRequestPriority(src.getPriorityElement()));
        if (src.hasDoNotPerform())
            tgt.setDoNotPerformElement(convertBoolean(src.getDoNotPerformElement()));
        if (src.hasTiming())
            tgt.setTiming(convertType(src.getTiming()));
        if (src.hasLocation())
            tgt.setLocation(convertReference(src.getLocation()));
        for (org.hl7.fhir.r5.model.ActivityDefinition.ActivityDefinitionParticipantComponent t : src.getParticipant()) tgt.addParticipant(convertActivityDefinitionParticipantComponent(t));
        if (src.hasProduct())
            tgt.setProduct(convertType(src.getProduct()));
        if (src.hasQuantity())
            tgt.setQuantity(convertSimpleQuantity(src.getQuantity()));
        for (org.hl7.fhir.r5.model.Dosage t : src.getDosage()) tgt.addDosage(convertDosage(t));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getBodySite()) tgt.addBodySite(convertCodeableConcept(t));
        for (org.hl7.fhir.r5.model.Reference t : src.getSpecimenRequirement()) tgt.addSpecimenRequirement(convertReference(t));
        for (org.hl7.fhir.r5.model.Reference t : src.getObservationRequirement()) tgt.addObservationRequirement(convertReference(t));
        for (org.hl7.fhir.r5.model.Reference t : src.getObservationResultRequirement()) tgt.addObservationResultRequirement(convertReference(t));
        if (src.hasTransform())
            tgt.setTransformElement(convertCanonical(src.getTransformElement()));
        for (org.hl7.fhir.r5.model.ActivityDefinition.ActivityDefinitionDynamicValueComponent t : src.getDynamicValue()) tgt.addDynamicValue(convertActivityDefinitionDynamicValueComponent(t));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ActivityDefinition.RequestResourceType> convertActivityDefinitionKind(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionKind> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ActivityDefinition.RequestResourceType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.ActivityDefinition.RequestResourceTypeEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case APPOINTMENT:
                tgt.setValue(org.hl7.fhir.r5.model.ActivityDefinition.RequestResourceType.APPOINTMENT);
                break;
            case APPOINTMENTRESPONSE:
                tgt.setValue(org.hl7.fhir.r5.model.ActivityDefinition.RequestResourceType.APPOINTMENTRESPONSE);
                break;
            case CAREPLAN:
                tgt.setValue(org.hl7.fhir.r5.model.ActivityDefinition.RequestResourceType.CAREPLAN);
                break;
            case CLAIM:
                tgt.setValue(org.hl7.fhir.r5.model.ActivityDefinition.RequestResourceType.CLAIM);
                break;
            case COMMUNICATIONREQUEST:
                tgt.setValue(org.hl7.fhir.r5.model.ActivityDefinition.RequestResourceType.COMMUNICATIONREQUEST);
                break;
            case CONTRACT:
                tgt.setValue(org.hl7.fhir.r5.model.ActivityDefinition.RequestResourceType.CONTRACT);
                break;
            case DEVICEREQUEST:
                tgt.setValue(org.hl7.fhir.r5.model.ActivityDefinition.RequestResourceType.DEVICEREQUEST);
                break;
            case ENROLLMENTREQUEST:
                tgt.setValue(org.hl7.fhir.r5.model.ActivityDefinition.RequestResourceType.ENROLLMENTREQUEST);
                break;
            case IMMUNIZATIONRECOMMENDATION:
                tgt.setValue(org.hl7.fhir.r5.model.ActivityDefinition.RequestResourceType.IMMUNIZATIONRECOMMENDATION);
                break;
            case MEDICATIONREQUEST:
                tgt.setValue(org.hl7.fhir.r5.model.ActivityDefinition.RequestResourceType.MEDICATIONREQUEST);
                break;
            case NUTRITIONORDER:
                tgt.setValue(org.hl7.fhir.r5.model.ActivityDefinition.RequestResourceType.NUTRITIONORDER);
                break;
            case SERVICEREQUEST:
                tgt.setValue(org.hl7.fhir.r5.model.ActivityDefinition.RequestResourceType.SERVICEREQUEST);
                break;
            case SUPPLYREQUEST:
                tgt.setValue(org.hl7.fhir.r5.model.ActivityDefinition.RequestResourceType.SUPPLYREQUEST);
                break;
            case TASK:
                tgt.setValue(org.hl7.fhir.r5.model.ActivityDefinition.RequestResourceType.TASK);
                break;
            case VISIONPRESCRIPTION:
                tgt.setValue(org.hl7.fhir.r5.model.ActivityDefinition.RequestResourceType.VISIONPRESCRIPTION);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.ActivityDefinition.RequestResourceType.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionKind> convertActivityDefinitionKind(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ActivityDefinition.RequestResourceType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionKind> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionKindEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case APPOINTMENT:
                tgt.setValue(org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionKind.APPOINTMENT);
                break;
            case APPOINTMENTRESPONSE:
                tgt.setValue(org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionKind.APPOINTMENTRESPONSE);
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
            case CONTRACT:
                tgt.setValue(org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionKind.CONTRACT);
                break;
            case DEVICEREQUEST:
                tgt.setValue(org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionKind.DEVICEREQUEST);
                break;
            case ENROLLMENTREQUEST:
                tgt.setValue(org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionKind.ENROLLMENTREQUEST);
                break;
            case IMMUNIZATIONRECOMMENDATION:
                tgt.setValue(org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionKind.IMMUNIZATIONRECOMMENDATION);
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
            case SUPPLYREQUEST:
                tgt.setValue(org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionKind.SUPPLYREQUEST);
                break;
            case TASK:
                tgt.setValue(org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionKind.TASK);
                break;
            case VISIONPRESCRIPTION:
                tgt.setValue(org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionKind.VISIONPRESCRIPTION);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionKind.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestIntent> convertRequestIntent(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ActivityDefinition.RequestIntent> src) throws FHIRException {
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

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ActivityDefinition.RequestIntent> convertRequestIntent(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestIntent> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ActivityDefinition.RequestIntent> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ActivityDefinition.RequestIntentEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
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
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestPriority> convertRequestPriority(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ActivityDefinition.RequestPriority> src) throws FHIRException {
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

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ActivityDefinition.RequestPriority> convertRequestPriority(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestPriority> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ActivityDefinition.RequestPriority> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ActivityDefinition.RequestPriorityEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
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
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ActivityDefinition.ActivityDefinitionParticipantComponent convertActivityDefinitionParticipantComponent(org.hl7.fhir.r4.model.ActivityDefinition.ActivityDefinitionParticipantComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ActivityDefinition.ActivityDefinitionParticipantComponent tgt = new org.hl7.fhir.r5.model.ActivityDefinition.ActivityDefinitionParticipantComponent();
        copyElement(src, tgt);
        if (src.hasType())
            tgt.setTypeElement(convertActivityParticipantType(src.getTypeElement()));
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
            tgt.setTypeElement(convertActivityParticipantType(src.getTypeElement()));
        if (src.hasRole())
            tgt.setRole(convertCodeableConcept(src.getRole()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionParticipantType> convertActivityParticipantType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ActivityDefinition.ActivityParticipantType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionParticipantType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.ActionParticipantTypeEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
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

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ActivityDefinition.ActivityParticipantType> convertActivityParticipantType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ActionParticipantType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ActivityDefinition.ActivityParticipantType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ActivityDefinition.ActivityParticipantTypeEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
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
        return tgt;
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