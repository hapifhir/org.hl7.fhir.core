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
public class Measure40_50 extends VersionConvertor_40_50 {

    public static org.hl7.fhir.r5.model.Measure convertMeasure(org.hl7.fhir.r4.model.Measure src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Measure tgt = new org.hl7.fhir.r5.model.Measure();
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
        if (src.hasDisclaimer())
            tgt.setDisclaimerElement(convertMarkdown(src.getDisclaimerElement()));
        if (src.hasScoring())
            tgt.setScoring(convertCodeableConcept(src.getScoring()));
        if (src.hasCompositeScoring())
            tgt.setCompositeScoring(convertCodeableConcept(src.getCompositeScoring()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getType()) tgt.addType(convertCodeableConcept(t));
        if (src.hasRiskAdjustment())
            tgt.setRiskAdjustmentElement(convertString(src.getRiskAdjustmentElement()));
        if (src.hasRateAggregation())
            tgt.setRateAggregationElement(convertString(src.getRateAggregationElement()));
        if (src.hasRationale())
            tgt.setRationaleElement(convertMarkdown(src.getRationaleElement()));
        if (src.hasClinicalRecommendationStatement())
            tgt.setClinicalRecommendationStatementElement(convertMarkdown(src.getClinicalRecommendationStatementElement()));
        if (src.hasImprovementNotation())
            tgt.setImprovementNotation(convertCodeableConcept(src.getImprovementNotation()));
        for (org.hl7.fhir.r4.model.MarkdownType t : src.getDefinition()) tgt.getDefinition().add(convertMarkdown(t));
        if (src.hasGuidance())
            tgt.setGuidanceElement(convertMarkdown(src.getGuidanceElement()));
        for (org.hl7.fhir.r4.model.Measure.MeasureGroupComponent t : src.getGroup()) tgt.addGroup(convertMeasureGroupComponent(t));
        for (org.hl7.fhir.r4.model.Measure.MeasureSupplementalDataComponent t : src.getSupplementalData()) tgt.addSupplementalData(convertMeasureSupplementalDataComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Measure convertMeasure(org.hl7.fhir.r5.model.Measure src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Measure tgt = new org.hl7.fhir.r4.model.Measure();
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
        if (src.hasDisclaimer())
            tgt.setDisclaimerElement(convertMarkdown(src.getDisclaimerElement()));
        if (src.hasScoring())
            tgt.setScoring(convertCodeableConcept(src.getScoring()));
        if (src.hasCompositeScoring())
            tgt.setCompositeScoring(convertCodeableConcept(src.getCompositeScoring()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getType()) tgt.addType(convertCodeableConcept(t));
        if (src.hasRiskAdjustment())
            tgt.setRiskAdjustmentElement(convertString(src.getRiskAdjustmentElement()));
        if (src.hasRateAggregation())
            tgt.setRateAggregationElement(convertString(src.getRateAggregationElement()));
        if (src.hasRationale())
            tgt.setRationaleElement(convertMarkdown(src.getRationaleElement()));
        if (src.hasClinicalRecommendationStatement())
            tgt.setClinicalRecommendationStatementElement(convertMarkdown(src.getClinicalRecommendationStatementElement()));
        if (src.hasImprovementNotation())
            tgt.setImprovementNotation(convertCodeableConcept(src.getImprovementNotation()));
        for (org.hl7.fhir.r5.model.MarkdownType t : src.getDefinition()) tgt.getDefinition().add(convertMarkdown(t));
        if (src.hasGuidance())
            tgt.setGuidanceElement(convertMarkdown(src.getGuidanceElement()));
        for (org.hl7.fhir.r5.model.Measure.MeasureGroupComponent t : src.getGroup()) tgt.addGroup(convertMeasureGroupComponent(t));
        for (org.hl7.fhir.r5.model.Measure.MeasureSupplementalDataComponent t : src.getSupplementalData()) tgt.addSupplementalData(convertMeasureSupplementalDataComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Measure.MeasureGroupComponent convertMeasureGroupComponent(org.hl7.fhir.r4.model.Measure.MeasureGroupComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Measure.MeasureGroupComponent tgt = new org.hl7.fhir.r5.model.Measure.MeasureGroupComponent();
        copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCode(convertCodeableConcept(src.getCode()));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        for (org.hl7.fhir.r4.model.Measure.MeasureGroupPopulationComponent t : src.getPopulation()) tgt.addPopulation(convertMeasureGroupPopulationComponent(t));
        for (org.hl7.fhir.r4.model.Measure.MeasureGroupStratifierComponent t : src.getStratifier()) tgt.addStratifier(convertMeasureGroupStratifierComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Measure.MeasureGroupComponent convertMeasureGroupComponent(org.hl7.fhir.r5.model.Measure.MeasureGroupComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Measure.MeasureGroupComponent tgt = new org.hl7.fhir.r4.model.Measure.MeasureGroupComponent();
        copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCode(convertCodeableConcept(src.getCode()));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        for (org.hl7.fhir.r5.model.Measure.MeasureGroupPopulationComponent t : src.getPopulation()) tgt.addPopulation(convertMeasureGroupPopulationComponent(t));
        for (org.hl7.fhir.r5.model.Measure.MeasureGroupStratifierComponent t : src.getStratifier()) tgt.addStratifier(convertMeasureGroupStratifierComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Measure.MeasureGroupPopulationComponent convertMeasureGroupPopulationComponent(org.hl7.fhir.r4.model.Measure.MeasureGroupPopulationComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Measure.MeasureGroupPopulationComponent tgt = new org.hl7.fhir.r5.model.Measure.MeasureGroupPopulationComponent();
        copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCode(convertCodeableConcept(src.getCode()));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        if (src.hasCriteria())
            tgt.setCriteria(convertExpression(src.getCriteria()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Measure.MeasureGroupPopulationComponent convertMeasureGroupPopulationComponent(org.hl7.fhir.r5.model.Measure.MeasureGroupPopulationComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Measure.MeasureGroupPopulationComponent tgt = new org.hl7.fhir.r4.model.Measure.MeasureGroupPopulationComponent();
        copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCode(convertCodeableConcept(src.getCode()));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        if (src.hasCriteria())
            tgt.setCriteria(convertExpression(src.getCriteria()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Measure.MeasureGroupStratifierComponent convertMeasureGroupStratifierComponent(org.hl7.fhir.r4.model.Measure.MeasureGroupStratifierComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Measure.MeasureGroupStratifierComponent tgt = new org.hl7.fhir.r5.model.Measure.MeasureGroupStratifierComponent();
        copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCode(convertCodeableConcept(src.getCode()));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        if (src.hasCriteria())
            tgt.setCriteria(convertExpression(src.getCriteria()));
        for (org.hl7.fhir.r4.model.Measure.MeasureGroupStratifierComponentComponent t : src.getComponent()) tgt.addComponent(convertMeasureGroupStratifierComponentComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Measure.MeasureGroupStratifierComponent convertMeasureGroupStratifierComponent(org.hl7.fhir.r5.model.Measure.MeasureGroupStratifierComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Measure.MeasureGroupStratifierComponent tgt = new org.hl7.fhir.r4.model.Measure.MeasureGroupStratifierComponent();
        copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCode(convertCodeableConcept(src.getCode()));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        if (src.hasCriteria())
            tgt.setCriteria(convertExpression(src.getCriteria()));
        for (org.hl7.fhir.r5.model.Measure.MeasureGroupStratifierComponentComponent t : src.getComponent()) tgt.addComponent(convertMeasureGroupStratifierComponentComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Measure.MeasureGroupStratifierComponentComponent convertMeasureGroupStratifierComponentComponent(org.hl7.fhir.r4.model.Measure.MeasureGroupStratifierComponentComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Measure.MeasureGroupStratifierComponentComponent tgt = new org.hl7.fhir.r5.model.Measure.MeasureGroupStratifierComponentComponent();
        copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCode(convertCodeableConcept(src.getCode()));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        if (src.hasCriteria())
            tgt.setCriteria(convertExpression(src.getCriteria()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Measure.MeasureGroupStratifierComponentComponent convertMeasureGroupStratifierComponentComponent(org.hl7.fhir.r5.model.Measure.MeasureGroupStratifierComponentComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Measure.MeasureGroupStratifierComponentComponent tgt = new org.hl7.fhir.r4.model.Measure.MeasureGroupStratifierComponentComponent();
        copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCode(convertCodeableConcept(src.getCode()));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        if (src.hasCriteria())
            tgt.setCriteria(convertExpression(src.getCriteria()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Measure.MeasureSupplementalDataComponent convertMeasureSupplementalDataComponent(org.hl7.fhir.r4.model.Measure.MeasureSupplementalDataComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Measure.MeasureSupplementalDataComponent tgt = new org.hl7.fhir.r5.model.Measure.MeasureSupplementalDataComponent();
        copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCode(convertCodeableConcept(src.getCode()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getUsage()) tgt.addUsage(convertCodeableConcept(t));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        if (src.hasCriteria())
            tgt.setCriteria(convertExpression(src.getCriteria()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Measure.MeasureSupplementalDataComponent convertMeasureSupplementalDataComponent(org.hl7.fhir.r5.model.Measure.MeasureSupplementalDataComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Measure.MeasureSupplementalDataComponent tgt = new org.hl7.fhir.r4.model.Measure.MeasureSupplementalDataComponent();
        copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCode(convertCodeableConcept(src.getCode()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getUsage()) tgt.addUsage(convertCodeableConcept(t));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        if (src.hasCriteria())
            tgt.setCriteria(convertExpression(src.getCriteria()));
        return tgt;
    }
}