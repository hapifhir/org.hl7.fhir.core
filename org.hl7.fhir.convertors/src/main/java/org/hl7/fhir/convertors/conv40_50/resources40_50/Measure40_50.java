package org.hl7.fhir.convertors.conv40_50.resources40_50;

import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.CodeableConcept40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Identifier40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Period40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.metadata40_50.ContactDetail40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.metadata40_50.Expression40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.metadata40_50.RelatedArtifact40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.metadata40_50.UsageContext40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Boolean40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Canonical40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Date40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.DateTime40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.MarkDown40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.String40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Uri40_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.Measure.MeasureTermComponent;

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
public class Measure40_50 {

  public static org.hl7.fhir.r5.model.Measure convertMeasure(org.hl7.fhir.r4.model.Measure src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Measure tgt = new org.hl7.fhir.r5.model.Measure();
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
    if (src.hasDisclaimer())
      tgt.setDisclaimerElement(MarkDown40_50.convertMarkdown(src.getDisclaimerElement()));
    if (src.hasScoring())
      tgt.setScoring(CodeableConcept40_50.convertCodeableConcept(src.getScoring()));
    if (src.hasCompositeScoring())
      tgt.setCompositeScoring(CodeableConcept40_50.convertCodeableConcept(src.getCompositeScoring()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getType())
      tgt.addType(CodeableConcept40_50.convertCodeableConcept(t));
    if (src.hasRiskAdjustment())
      tgt.setRiskAdjustmentElement(String40_50.convertStringToMarkdown(src.getRiskAdjustmentElement()));
    if (src.hasRateAggregation())
      tgt.setRateAggregationElement(String40_50.convertStringToMarkdown(src.getRateAggregationElement()));
    if (src.hasRationale())
      tgt.setRationaleElement(MarkDown40_50.convertMarkdown(src.getRationaleElement()));
    if (src.hasClinicalRecommendationStatement())
      tgt.setClinicalRecommendationStatementElement(MarkDown40_50.convertMarkdown(src.getClinicalRecommendationStatementElement()));
    if (src.hasImprovementNotation())
      tgt.setImprovementNotation(CodeableConcept40_50.convertCodeableConcept(src.getImprovementNotation()));
    for (org.hl7.fhir.r4.model.MarkdownType t : src.getDefinition())
      tgt.addTerm().setDefinitionElement(MarkDown40_50.convertMarkdown(t));
    if (src.hasGuidance())
      tgt.setGuidanceElement(MarkDown40_50.convertMarkdown(src.getGuidanceElement()));
    for (org.hl7.fhir.r4.model.Measure.MeasureGroupComponent t : src.getGroup())
      tgt.addGroup(convertMeasureGroupComponent(t));
    for (org.hl7.fhir.r4.model.Measure.MeasureSupplementalDataComponent t : src.getSupplementalData())
      tgt.addSupplementalData(convertMeasureSupplementalDataComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Measure convertMeasure(org.hl7.fhir.r5.model.Measure src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Measure tgt = new org.hl7.fhir.r4.model.Measure();
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
    if (src.hasDisclaimer())
      tgt.setDisclaimerElement(MarkDown40_50.convertMarkdown(src.getDisclaimerElement()));
    if (src.hasScoring())
      tgt.setScoring(CodeableConcept40_50.convertCodeableConcept(src.getScoring()));
    if (src.hasCompositeScoring())
      tgt.setCompositeScoring(CodeableConcept40_50.convertCodeableConcept(src.getCompositeScoring()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getType())
      tgt.addType(CodeableConcept40_50.convertCodeableConcept(t));
    if (src.hasRiskAdjustment())
      tgt.setRiskAdjustmentElement(String40_50.convertString(src.getRiskAdjustmentElement()));
    if (src.hasRateAggregation())
      tgt.setRateAggregationElement(String40_50.convertString(src.getRateAggregationElement()));
    if (src.hasRationale())
      tgt.setRationaleElement(MarkDown40_50.convertMarkdown(src.getRationaleElement()));
    if (src.hasClinicalRecommendationStatement())
      tgt.setClinicalRecommendationStatementElement(MarkDown40_50.convertMarkdown(src.getClinicalRecommendationStatementElement()));
    if (src.hasImprovementNotation())
      tgt.setImprovementNotation(CodeableConcept40_50.convertCodeableConcept(src.getImprovementNotation()));
    for (MeasureTermComponent t : src.getTerm())
      tgt.getDefinition().add(MarkDown40_50.convertMarkdown(t.getDefinitionElement()));
    if (src.hasGuidance())
      tgt.setGuidanceElement(MarkDown40_50.convertMarkdown(src.getGuidanceElement()));
    for (org.hl7.fhir.r5.model.Measure.MeasureGroupComponent t : src.getGroup())
      tgt.addGroup(convertMeasureGroupComponent(t));
    for (org.hl7.fhir.r5.model.Measure.MeasureSupplementalDataComponent t : src.getSupplementalData())
      tgt.addSupplementalData(convertMeasureSupplementalDataComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Measure.MeasureGroupComponent convertMeasureGroupComponent(org.hl7.fhir.r4.model.Measure.MeasureGroupComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Measure.MeasureGroupComponent tgt = new org.hl7.fhir.r5.model.Measure.MeasureGroupComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_50.convertCodeableConcept(src.getCode()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_50.convertStringToMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r4.model.Measure.MeasureGroupPopulationComponent t : src.getPopulation())
      tgt.addPopulation(convertMeasureGroupPopulationComponent(t));
    for (org.hl7.fhir.r4.model.Measure.MeasureGroupStratifierComponent t : src.getStratifier())
      tgt.addStratifier(convertMeasureGroupStratifierComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Measure.MeasureGroupComponent convertMeasureGroupComponent(org.hl7.fhir.r5.model.Measure.MeasureGroupComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Measure.MeasureGroupComponent tgt = new org.hl7.fhir.r4.model.Measure.MeasureGroupComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_50.convertCodeableConcept(src.getCode()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_50.convertString(src.getDescriptionElement()));
    for (org.hl7.fhir.r5.model.Measure.MeasureGroupPopulationComponent t : src.getPopulation())
      tgt.addPopulation(convertMeasureGroupPopulationComponent(t));
    for (org.hl7.fhir.r5.model.Measure.MeasureGroupStratifierComponent t : src.getStratifier())
      tgt.addStratifier(convertMeasureGroupStratifierComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Measure.MeasureGroupPopulationComponent convertMeasureGroupPopulationComponent(org.hl7.fhir.r4.model.Measure.MeasureGroupPopulationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Measure.MeasureGroupPopulationComponent tgt = new org.hl7.fhir.r5.model.Measure.MeasureGroupPopulationComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_50.convertCodeableConcept(src.getCode()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_50.convertStringToMarkdown(src.getDescriptionElement()));
    if (src.hasCriteria())
      tgt.setCriteria(Expression40_50.convertExpression(src.getCriteria()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Measure.MeasureGroupPopulationComponent convertMeasureGroupPopulationComponent(org.hl7.fhir.r5.model.Measure.MeasureGroupPopulationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Measure.MeasureGroupPopulationComponent tgt = new org.hl7.fhir.r4.model.Measure.MeasureGroupPopulationComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_50.convertCodeableConcept(src.getCode()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_50.convertString(src.getDescriptionElement()));
    if (src.hasCriteria())
      tgt.setCriteria(Expression40_50.convertExpression(src.getCriteria()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Measure.MeasureGroupStratifierComponent convertMeasureGroupStratifierComponent(org.hl7.fhir.r4.model.Measure.MeasureGroupStratifierComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Measure.MeasureGroupStratifierComponent tgt = new org.hl7.fhir.r5.model.Measure.MeasureGroupStratifierComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_50.convertCodeableConcept(src.getCode()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_50.convertStringToMarkdown(src.getDescriptionElement()));
    if (src.hasCriteria())
      tgt.setCriteria(Expression40_50.convertExpression(src.getCriteria()));
    for (org.hl7.fhir.r4.model.Measure.MeasureGroupStratifierComponentComponent t : src.getComponent())
      tgt.addComponent(convertMeasureGroupStratifierComponentComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Measure.MeasureGroupStratifierComponent convertMeasureGroupStratifierComponent(org.hl7.fhir.r5.model.Measure.MeasureGroupStratifierComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Measure.MeasureGroupStratifierComponent tgt = new org.hl7.fhir.r4.model.Measure.MeasureGroupStratifierComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_50.convertCodeableConcept(src.getCode()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_50.convertString(src.getDescriptionElement()));
    if (src.hasCriteria())
      tgt.setCriteria(Expression40_50.convertExpression(src.getCriteria()));
    for (org.hl7.fhir.r5.model.Measure.MeasureGroupStratifierComponentComponent t : src.getComponent())
      tgt.addComponent(convertMeasureGroupStratifierComponentComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Measure.MeasureGroupStratifierComponentComponent convertMeasureGroupStratifierComponentComponent(org.hl7.fhir.r4.model.Measure.MeasureGroupStratifierComponentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Measure.MeasureGroupStratifierComponentComponent tgt = new org.hl7.fhir.r5.model.Measure.MeasureGroupStratifierComponentComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_50.convertCodeableConcept(src.getCode()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_50.convertStringToMarkdown(src.getDescriptionElement()));
    if (src.hasCriteria())
      tgt.setCriteria(Expression40_50.convertExpression(src.getCriteria()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Measure.MeasureGroupStratifierComponentComponent convertMeasureGroupStratifierComponentComponent(org.hl7.fhir.r5.model.Measure.MeasureGroupStratifierComponentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Measure.MeasureGroupStratifierComponentComponent tgt = new org.hl7.fhir.r4.model.Measure.MeasureGroupStratifierComponentComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_50.convertCodeableConcept(src.getCode()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_50.convertString(src.getDescriptionElement()));
    if (src.hasCriteria())
      tgt.setCriteria(Expression40_50.convertExpression(src.getCriteria()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Measure.MeasureSupplementalDataComponent convertMeasureSupplementalDataComponent(org.hl7.fhir.r4.model.Measure.MeasureSupplementalDataComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Measure.MeasureSupplementalDataComponent tgt = new org.hl7.fhir.r5.model.Measure.MeasureSupplementalDataComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_50.convertCodeableConcept(src.getCode()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getUsage())
      tgt.addUsage(CodeableConcept40_50.convertCodeableConcept(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_50.convertStringToMarkdown(src.getDescriptionElement()));
    if (src.hasCriteria())
      tgt.setCriteria(Expression40_50.convertExpression(src.getCriteria()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Measure.MeasureSupplementalDataComponent convertMeasureSupplementalDataComponent(org.hl7.fhir.r5.model.Measure.MeasureSupplementalDataComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Measure.MeasureSupplementalDataComponent tgt = new org.hl7.fhir.r4.model.Measure.MeasureSupplementalDataComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_50.convertCodeableConcept(src.getCode()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getUsage())
      tgt.addUsage(CodeableConcept40_50.convertCodeableConcept(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_50.convertString(src.getDescriptionElement()));
    if (src.hasCriteria())
      tgt.setCriteria(Expression40_50.convertExpression(src.getCriteria()));
    return tgt;
  }
}