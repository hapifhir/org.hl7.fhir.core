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
public class Library40_50 extends VersionConvertor_40_50 {

    public static org.hl7.fhir.r5.model.Library convertLibrary(org.hl7.fhir.r4.model.Library src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Library tgt = new org.hl7.fhir.r5.model.Library();
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
        if (src.hasType())
            tgt.setType(convertCodeableConcept(src.getType()));
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
        for (org.hl7.fhir.r4.model.ParameterDefinition t : src.getParameter()) tgt.addParameter(convertParameterDefinition(t));
        for (org.hl7.fhir.r4.model.DataRequirement t : src.getDataRequirement()) tgt.addDataRequirement(convertDataRequirement(t));
        for (org.hl7.fhir.r4.model.Attachment t : src.getContent()) tgt.addContent(convertAttachment(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Library convertLibrary(org.hl7.fhir.r5.model.Library src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Library tgt = new org.hl7.fhir.r4.model.Library();
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
        if (src.hasType())
            tgt.setType(convertCodeableConcept(src.getType()));
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
        for (org.hl7.fhir.r5.model.ParameterDefinition t : src.getParameter()) tgt.addParameter(convertParameterDefinition(t));
        for (org.hl7.fhir.r5.model.DataRequirement t : src.getDataRequirement()) tgt.addDataRequirement(convertDataRequirement(t));
        for (org.hl7.fhir.r5.model.Attachment t : src.getContent()) tgt.addContent(convertAttachment(t));
        return tgt;
    }
}