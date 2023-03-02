package org.hl7.fhir.convertors.conv43_50.resources43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.CodeableConcept43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Identifier43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Period43_50;
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
public class Measure43_50 {

  public static org.hl7.fhir.r5.model.Measure convertMeasure(org.hl7.fhir.r4b.model.Measure src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Measure tgt = new org.hl7.fhir.r5.model.Measure();
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
    if (src.hasDisclaimer())
      tgt.setDisclaimerElement(MarkDown43_50.convertMarkdown(src.getDisclaimerElement()));
    if (src.hasScoring())
      tgt.setScoring(CodeableConcept43_50.convertCodeableConcept(src.getScoring()));
    if (src.hasCompositeScoring())
      tgt.setCompositeScoring(CodeableConcept43_50.convertCodeableConcept(src.getCompositeScoring()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getType())
      tgt.addType(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasRiskAdjustment())
      tgt.setRiskAdjustmentElement(String43_50.convertStringToMarkdown(src.getRiskAdjustmentElement()));
    if (src.hasRateAggregation())
      tgt.setRateAggregationElement(String43_50.convertStringToMarkdown(src.getRateAggregationElement()));
    if (src.hasRationale())
      tgt.setRationaleElement(MarkDown43_50.convertMarkdown(src.getRationaleElement()));
    if (src.hasClinicalRecommendationStatement())
      tgt.setClinicalRecommendationStatementElement(MarkDown43_50.convertMarkdown(src.getClinicalRecommendationStatementElement()));
    if (src.hasImprovementNotation())
      tgt.setImprovementNotation(CodeableConcept43_50.convertCodeableConcept(src.getImprovementNotation()));
    for (org.hl7.fhir.r4b.model.MarkdownType t : src.getDefinition())
      tgt.addTerm().setDefinitionElement(MarkDown43_50.convertMarkdown(t));
    if (src.hasGuidance())
      tgt.setGuidanceElement(MarkDown43_50.convertMarkdown(src.getGuidanceElement()));
    for (org.hl7.fhir.r4b.model.Measure.MeasureGroupComponent t : src.getGroup())
      tgt.addGroup(convertMeasureGroupComponent(t));
    for (org.hl7.fhir.r4b.model.Measure.MeasureSupplementalDataComponent t : src.getSupplementalData())
      tgt.addSupplementalData(convertMeasureSupplementalDataComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Measure convertMeasure(org.hl7.fhir.r5.model.Measure src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Measure tgt = new org.hl7.fhir.r4b.model.Measure();
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
    if (src.hasDisclaimer())
      tgt.setDisclaimerElement(MarkDown43_50.convertMarkdown(src.getDisclaimerElement()));
    if (src.hasScoring())
      tgt.setScoring(CodeableConcept43_50.convertCodeableConcept(src.getScoring()));
    if (src.hasCompositeScoring())
      tgt.setCompositeScoring(CodeableConcept43_50.convertCodeableConcept(src.getCompositeScoring()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getType())
      tgt.addType(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasRiskAdjustment())
      tgt.setRiskAdjustmentElement(String43_50.convertString(src.getRiskAdjustmentElement()));
    if (src.hasRateAggregation())
      tgt.setRateAggregationElement(String43_50.convertString(src.getRateAggregationElement()));
    if (src.hasRationale())
      tgt.setRationaleElement(MarkDown43_50.convertMarkdown(src.getRationaleElement()));
    if (src.hasClinicalRecommendationStatement())
      tgt.setClinicalRecommendationStatementElement(MarkDown43_50.convertMarkdown(src.getClinicalRecommendationStatementElement()));
    if (src.hasImprovementNotation())
      tgt.setImprovementNotation(CodeableConcept43_50.convertCodeableConcept(src.getImprovementNotation()));
    for (MeasureTermComponent t : src.getTerm())
      tgt.getDefinition().add(MarkDown43_50.convertMarkdown(t.getDefinitionElement()));
    if (src.hasGuidance())
      tgt.setGuidanceElement(MarkDown43_50.convertMarkdown(src.getGuidanceElement()));
    for (org.hl7.fhir.r5.model.Measure.MeasureGroupComponent t : src.getGroup())
      tgt.addGroup(convertMeasureGroupComponent(t));
    for (org.hl7.fhir.r5.model.Measure.MeasureSupplementalDataComponent t : src.getSupplementalData())
      tgt.addSupplementalData(convertMeasureSupplementalDataComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Measure.MeasureGroupComponent convertMeasureGroupComponent(org.hl7.fhir.r4b.model.Measure.MeasureGroupComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Measure.MeasureGroupComponent tgt = new org.hl7.fhir.r5.model.Measure.MeasureGroupComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_50.convertCodeableConcept(src.getCode()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_50.convertStringToMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r4b.model.Measure.MeasureGroupPopulationComponent t : src.getPopulation())
      tgt.addPopulation(convertMeasureGroupPopulationComponent(t));
    for (org.hl7.fhir.r4b.model.Measure.MeasureGroupStratifierComponent t : src.getStratifier())
      tgt.addStratifier(convertMeasureGroupStratifierComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Measure.MeasureGroupComponent convertMeasureGroupComponent(org.hl7.fhir.r5.model.Measure.MeasureGroupComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Measure.MeasureGroupComponent tgt = new org.hl7.fhir.r4b.model.Measure.MeasureGroupComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_50.convertCodeableConcept(src.getCode()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_50.convertString(src.getDescriptionElement()));
    for (org.hl7.fhir.r5.model.Measure.MeasureGroupPopulationComponent t : src.getPopulation())
      tgt.addPopulation(convertMeasureGroupPopulationComponent(t));
    for (org.hl7.fhir.r5.model.Measure.MeasureGroupStratifierComponent t : src.getStratifier())
      tgt.addStratifier(convertMeasureGroupStratifierComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Measure.MeasureGroupPopulationComponent convertMeasureGroupPopulationComponent(org.hl7.fhir.r4b.model.Measure.MeasureGroupPopulationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Measure.MeasureGroupPopulationComponent tgt = new org.hl7.fhir.r5.model.Measure.MeasureGroupPopulationComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_50.convertCodeableConcept(src.getCode()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_50.convertStringToMarkdown(src.getDescriptionElement()));
    if (src.hasCriteria())
      tgt.setCriteria(Expression43_50.convertExpression(src.getCriteria()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Measure.MeasureGroupPopulationComponent convertMeasureGroupPopulationComponent(org.hl7.fhir.r5.model.Measure.MeasureGroupPopulationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Measure.MeasureGroupPopulationComponent tgt = new org.hl7.fhir.r4b.model.Measure.MeasureGroupPopulationComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_50.convertCodeableConcept(src.getCode()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_50.convertString(src.getDescriptionElement()));
    if (src.hasCriteria())
      tgt.setCriteria(Expression43_50.convertExpression(src.getCriteria()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Measure.MeasureGroupStratifierComponent convertMeasureGroupStratifierComponent(org.hl7.fhir.r4b.model.Measure.MeasureGroupStratifierComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Measure.MeasureGroupStratifierComponent tgt = new org.hl7.fhir.r5.model.Measure.MeasureGroupStratifierComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_50.convertCodeableConcept(src.getCode()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_50.convertStringToMarkdown(src.getDescriptionElement()));
    if (src.hasCriteria())
      tgt.setCriteria(Expression43_50.convertExpression(src.getCriteria()));
    for (org.hl7.fhir.r4b.model.Measure.MeasureGroupStratifierComponentComponent t : src.getComponent())
      tgt.addComponent(convertMeasureGroupStratifierComponentComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Measure.MeasureGroupStratifierComponent convertMeasureGroupStratifierComponent(org.hl7.fhir.r5.model.Measure.MeasureGroupStratifierComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Measure.MeasureGroupStratifierComponent tgt = new org.hl7.fhir.r4b.model.Measure.MeasureGroupStratifierComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_50.convertCodeableConcept(src.getCode()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_50.convertString(src.getDescriptionElement()));
    if (src.hasCriteria())
      tgt.setCriteria(Expression43_50.convertExpression(src.getCriteria()));
    for (org.hl7.fhir.r5.model.Measure.MeasureGroupStratifierComponentComponent t : src.getComponent())
      tgt.addComponent(convertMeasureGroupStratifierComponentComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Measure.MeasureGroupStratifierComponentComponent convertMeasureGroupStratifierComponentComponent(org.hl7.fhir.r4b.model.Measure.MeasureGroupStratifierComponentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Measure.MeasureGroupStratifierComponentComponent tgt = new org.hl7.fhir.r5.model.Measure.MeasureGroupStratifierComponentComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_50.convertCodeableConcept(src.getCode()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_50.convertStringToMarkdown(src.getDescriptionElement()));
    if (src.hasCriteria())
      tgt.setCriteria(Expression43_50.convertExpression(src.getCriteria()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Measure.MeasureGroupStratifierComponentComponent convertMeasureGroupStratifierComponentComponent(org.hl7.fhir.r5.model.Measure.MeasureGroupStratifierComponentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Measure.MeasureGroupStratifierComponentComponent tgt = new org.hl7.fhir.r4b.model.Measure.MeasureGroupStratifierComponentComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_50.convertCodeableConcept(src.getCode()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_50.convertString(src.getDescriptionElement()));
    if (src.hasCriteria())
      tgt.setCriteria(Expression43_50.convertExpression(src.getCriteria()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Measure.MeasureSupplementalDataComponent convertMeasureSupplementalDataComponent(org.hl7.fhir.r4b.model.Measure.MeasureSupplementalDataComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Measure.MeasureSupplementalDataComponent tgt = new org.hl7.fhir.r5.model.Measure.MeasureSupplementalDataComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_50.convertCodeableConcept(src.getCode()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getUsage())
      tgt.addUsage(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_50.convertStringToMarkdown(src.getDescriptionElement()));
    if (src.hasCriteria())
      tgt.setCriteria(Expression43_50.convertExpression(src.getCriteria()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Measure.MeasureSupplementalDataComponent convertMeasureSupplementalDataComponent(org.hl7.fhir.r5.model.Measure.MeasureSupplementalDataComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Measure.MeasureSupplementalDataComponent tgt = new org.hl7.fhir.r4b.model.Measure.MeasureSupplementalDataComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_50.convertCodeableConcept(src.getCode()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getUsage())
      tgt.addUsage(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_50.convertString(src.getDescriptionElement()));
    if (src.hasCriteria())
      tgt.setCriteria(Expression43_50.convertExpression(src.getCriteria()));
    return tgt;
  }
}