package org.hl7.fhir.convertors.conv43_N.resources43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.CodeableConcept43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Identifier43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Period43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.metadata43_N.ContactDetail43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.metadata43_N.Expression43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.metadata43_N.RelatedArtifact43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.metadata43_N.UsageContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Boolean43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Canonical43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Date43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.DateTime43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.MarkDown43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.String43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Uri43_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.Measure.MeasureTermComponent;

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

public class Measure43_N {

  public static org.hl7.fhir.model.core.Measure convertMeasure(org.hl7.fhir.r4b.model.Measure src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Measure tgt = new org.hl7.fhir.model.core.Measure();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri43_N.convertUri(src.getUrlElement()));
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    if (src.hasVersion())
      tgt.setVersionElement(String43_N.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String43_N.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String43_N.convertString(src.getTitleElement()));
    if (src.hasSubtitle())
      tgt.setSubtitleElement(String43_N.convertString(src.getSubtitleElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations43_N.convertPublicationStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean43_N.convertBoolean(src.getExperimentalElement()));
    if (src.hasSubject())
      tgt.setSubject(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getSubject()));
    if (src.hasDate())
      tgt.setDateElement(DateTime43_N.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String43_N.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.r4b.model.ContactDetail t : src.getContact())
      tgt.addContact(ContactDetail43_N.convertContactDetail(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown43_N.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r4b.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(UsageContext43_N.convertUsageContext(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasPurpose())
      tgt.setPurposeElement(MarkDown43_N.convertMarkdown(src.getPurposeElement()));
    if (src.hasUsage())
      tgt.setUsageElement(String43_N.convertStringToMarkdown(src.getUsageElement()));
    if (src.hasCopyright())
      tgt.setCopyrightElement(MarkDown43_N.convertMarkdown(src.getCopyrightElement()));
    if (src.hasApprovalDate())
      tgt.setApprovalDateElement(Date43_N.convertDate(src.getApprovalDateElement()));
    if (src.hasLastReviewDate())
      tgt.setLastReviewDateElement(Date43_N.convertDate(src.getLastReviewDateElement()));
    if (src.hasEffectivePeriod())
      tgt.setEffectivePeriod(Period43_N.convertPeriod(src.getEffectivePeriod()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getTopic())
      tgt.addTopic(CodeableConcept43_N.convertCodeableConcept(t));
    for (org.hl7.fhir.r4b.model.ContactDetail t : src.getAuthor())
      tgt.addAuthor(ContactDetail43_N.convertContactDetail(t));
    for (org.hl7.fhir.r4b.model.ContactDetail t : src.getEditor())
      tgt.addEditor(ContactDetail43_N.convertContactDetail(t));
    for (org.hl7.fhir.r4b.model.ContactDetail t : src.getReviewer())
      tgt.addReviewer(ContactDetail43_N.convertContactDetail(t));
    for (org.hl7.fhir.r4b.model.ContactDetail t : src.getEndorser())
      tgt.addEndorser(ContactDetail43_N.convertContactDetail(t));
    for (org.hl7.fhir.r4b.model.RelatedArtifact t : src.getRelatedArtifact())
      tgt.addRelatedArtifact(RelatedArtifact43_N.convertRelatedArtifact(t));
    for (org.hl7.fhir.r4b.model.CanonicalType t : src.getLibrary())
      tgt.getLibraryList().add(Canonical43_N.convertCanonical(t));
    if (src.hasDisclaimer())
      tgt.setDisclaimerElement(MarkDown43_N.convertMarkdown(src.getDisclaimerElement()));
    if (src.hasRiskAdjustment())
      tgt.setRiskAdjustmentElement(String43_N.convertStringToMarkdown(src.getRiskAdjustmentElement()));
    if (src.hasRateAggregation())
      tgt.setRateAggregationElement(String43_N.convertStringToMarkdown(src.getRateAggregationElement()));
    if (src.hasRationale())
      tgt.setRationaleElement(MarkDown43_N.convertMarkdown(src.getRationaleElement()));
    if (src.hasClinicalRecommendationStatement())
      tgt.setClinicalRecommendationStatementElement(MarkDown43_N.convertMarkdown(src.getClinicalRecommendationStatementElement()));
    for (org.hl7.fhir.r4b.model.MarkdownType t : src.getDefinition())
      tgt.addTerm().setDefinitionElement(MarkDown43_N.convertMarkdown(t));
    for (org.hl7.fhir.r4b.model.Measure.MeasureGroupComponent t : src.getGroup())
      tgt.addGroup(convertMeasureGroupComponent(t));
    for (org.hl7.fhir.r4b.model.Measure.MeasureSupplementalDataComponent t : src.getSupplementalData())
      tgt.addSupplementalData(convertMeasureSupplementalDataComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Measure convertMeasure(org.hl7.fhir.model.core.Measure src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Measure tgt = new org.hl7.fhir.r4b.model.Measure();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri43_N.convertUri(src.getUrlElement()));
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    if (src.hasVersion())
      tgt.setVersionElement(String43_N.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String43_N.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String43_N.convertString(src.getTitleElement()));
    if (src.hasSubtitle())
      tgt.setSubtitleElement(String43_N.convertString(src.getSubtitleElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations43_N.convertPublicationStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean43_N.convertBoolean(src.getExperimentalElement()));
    if (src.hasSubject())
      tgt.setSubject(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getSubject()));
    if (src.hasDate())
      tgt.setDateElement(DateTime43_N.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String43_N.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.model.core.ContactDetail t : src.getContactList())
      tgt.addContact(ContactDetail43_N.convertContactDetail(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown43_N.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.model.core.UsageContext t : src.getUseContextList())
      tgt.addUseContext(UsageContext43_N.convertUsageContext(t));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getJurisdictionList())
      tgt.addJurisdiction(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasPurpose())
      tgt.setPurposeElement(MarkDown43_N.convertMarkdown(src.getPurposeElement()));
    if (src.hasUsage())
      tgt.setUsageElement(String43_N.convertString(src.getUsageElement()));
    if (src.hasCopyright())
      tgt.setCopyrightElement(MarkDown43_N.convertMarkdown(src.getCopyrightElement()));
    if (src.hasApprovalDate())
      tgt.setApprovalDateElement(Date43_N.convertDate(src.getApprovalDateElement()));
    if (src.hasLastReviewDate())
      tgt.setLastReviewDateElement(Date43_N.convertDate(src.getLastReviewDateElement()));
    if (src.hasEffectivePeriod())
      tgt.setEffectivePeriod(Period43_N.convertPeriod(src.getEffectivePeriod()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getTopicList())
      tgt.addTopic(CodeableConcept43_N.convertCodeableConcept(t));
    for (org.hl7.fhir.model.core.ContactDetail t : src.getAuthorList())
      tgt.addAuthor(ContactDetail43_N.convertContactDetail(t));
    for (org.hl7.fhir.model.core.ContactDetail t : src.getEditorList())
      tgt.addEditor(ContactDetail43_N.convertContactDetail(t));
    for (org.hl7.fhir.model.core.ContactDetail t : src.getReviewerList())
      tgt.addReviewer(ContactDetail43_N.convertContactDetail(t));
    for (org.hl7.fhir.model.core.ContactDetail t : src.getEndorserList())
      tgt.addEndorser(ContactDetail43_N.convertContactDetail(t));
    for (org.hl7.fhir.model.core.RelatedArtifact t : src.getRelatedArtifactList())
      tgt.addRelatedArtifact(RelatedArtifact43_N.convertRelatedArtifact(t));
    for (org.hl7.fhir.model.core.CanonicalType t : src.getLibraryList())
      tgt.getLibrary().add(Canonical43_N.convertCanonical(t));
    if (src.hasDisclaimer())
      tgt.setDisclaimerElement(MarkDown43_N.convertMarkdown(src.getDisclaimerElement()));
    if (src.hasRiskAdjustment())
      tgt.setRiskAdjustmentElement(String43_N.convertString(src.getRiskAdjustmentElement()));
    if (src.hasRateAggregation())
      tgt.setRateAggregationElement(String43_N.convertString(src.getRateAggregationElement()));
    if (src.hasRationale())
      tgt.setRationaleElement(MarkDown43_N.convertMarkdown(src.getRationaleElement()));
    if (src.hasClinicalRecommendationStatement())
      tgt.setClinicalRecommendationStatementElement(MarkDown43_N.convertMarkdown(src.getClinicalRecommendationStatementElement()));
    for (MeasureTermComponent t : src.getTermList())
      tgt.getDefinition().add(MarkDown43_N.convertMarkdown(t.getDefinitionElement()));
    for (org.hl7.fhir.model.core.Measure.MeasureGroupComponent t : src.getGroupList())
      tgt.addGroup(convertMeasureGroupComponent(t));
    for (org.hl7.fhir.model.core.Measure.MeasureSupplementalDataComponent t : src.getSupplementalDataList())
      tgt.addSupplementalData(convertMeasureSupplementalDataComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.Measure.MeasureGroupComponent convertMeasureGroupComponent(org.hl7.fhir.r4b.model.Measure.MeasureGroupComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Measure.MeasureGroupComponent tgt = new org.hl7.fhir.model.core.Measure.MeasureGroupComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_N.convertCodeableConcept(src.getCode()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_N.convertStringToMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r4b.model.Measure.MeasureGroupPopulationComponent t : src.getPopulation())
      tgt.addPopulation(convertMeasureGroupPopulationComponent(t));
    for (org.hl7.fhir.r4b.model.Measure.MeasureGroupStratifierComponent t : src.getStratifier())
      tgt.addStratifier(convertMeasureGroupStratifierComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Measure.MeasureGroupComponent convertMeasureGroupComponent(org.hl7.fhir.model.core.Measure.MeasureGroupComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Measure.MeasureGroupComponent tgt = new org.hl7.fhir.r4b.model.Measure.MeasureGroupComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_N.convertCodeableConcept(src.getCode()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_N.convertString(src.getDescriptionElement()));
    for (org.hl7.fhir.model.core.Measure.MeasureGroupPopulationComponent t : src.getPopulationList())
      tgt.addPopulation(convertMeasureGroupPopulationComponent(t));
    for (org.hl7.fhir.model.core.Measure.MeasureGroupStratifierComponent t : src.getStratifierList())
      tgt.addStratifier(convertMeasureGroupStratifierComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.Measure.MeasureGroupPopulationComponent convertMeasureGroupPopulationComponent(org.hl7.fhir.r4b.model.Measure.MeasureGroupPopulationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Measure.MeasureGroupPopulationComponent tgt = new org.hl7.fhir.model.core.Measure.MeasureGroupPopulationComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_N.convertCodeableConcept(src.getCode()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_N.convertStringToMarkdown(src.getDescriptionElement()));
    if (src.hasCriteria())
      tgt.setCriteria(Expression43_N.convertExpression(src.getCriteria()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Measure.MeasureGroupPopulationComponent convertMeasureGroupPopulationComponent(org.hl7.fhir.model.core.Measure.MeasureGroupPopulationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Measure.MeasureGroupPopulationComponent tgt = new org.hl7.fhir.r4b.model.Measure.MeasureGroupPopulationComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_N.convertCodeableConcept(src.getCode()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_N.convertString(src.getDescriptionElement()));
    if (src.hasCriteria())
      tgt.setCriteria(Expression43_N.convertExpression(src.getCriteria()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.Measure.MeasureGroupStratifierComponent convertMeasureGroupStratifierComponent(org.hl7.fhir.r4b.model.Measure.MeasureGroupStratifierComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Measure.MeasureGroupStratifierComponent tgt = new org.hl7.fhir.model.core.Measure.MeasureGroupStratifierComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_N.convertCodeableConcept(src.getCode()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_N.convertStringToMarkdown(src.getDescriptionElement()));
    if (src.hasCriteria())
      tgt.setCriteria(Expression43_N.convertExpression(src.getCriteria()));
    for (org.hl7.fhir.r4b.model.Measure.MeasureGroupStratifierComponentComponent t : src.getComponent())
      tgt.addComponent(convertMeasureGroupStratifierComponentComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Measure.MeasureGroupStratifierComponent convertMeasureGroupStratifierComponent(org.hl7.fhir.model.core.Measure.MeasureGroupStratifierComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Measure.MeasureGroupStratifierComponent tgt = new org.hl7.fhir.r4b.model.Measure.MeasureGroupStratifierComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_N.convertCodeableConcept(src.getCode()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_N.convertString(src.getDescriptionElement()));
    if (src.hasCriteria())
      tgt.setCriteria(Expression43_N.convertExpression(src.getCriteria()));
    for (org.hl7.fhir.model.core.Measure.MeasureGroupStratifierComponentComponent t : src.getComponentList())
      tgt.addComponent(convertMeasureGroupStratifierComponentComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.Measure.MeasureGroupStratifierComponentComponent convertMeasureGroupStratifierComponentComponent(org.hl7.fhir.r4b.model.Measure.MeasureGroupStratifierComponentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Measure.MeasureGroupStratifierComponentComponent tgt = new org.hl7.fhir.model.core.Measure.MeasureGroupStratifierComponentComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_N.convertCodeableConcept(src.getCode()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_N.convertStringToMarkdown(src.getDescriptionElement()));
    if (src.hasCriteria())
      tgt.setCriteria(Expression43_N.convertExpression(src.getCriteria()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Measure.MeasureGroupStratifierComponentComponent convertMeasureGroupStratifierComponentComponent(org.hl7.fhir.model.core.Measure.MeasureGroupStratifierComponentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Measure.MeasureGroupStratifierComponentComponent tgt = new org.hl7.fhir.r4b.model.Measure.MeasureGroupStratifierComponentComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_N.convertCodeableConcept(src.getCode()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_N.convertString(src.getDescriptionElement()));
    if (src.hasCriteria())
      tgt.setCriteria(Expression43_N.convertExpression(src.getCriteria()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.Measure.MeasureSupplementalDataComponent convertMeasureSupplementalDataComponent(org.hl7.fhir.r4b.model.Measure.MeasureSupplementalDataComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Measure.MeasureSupplementalDataComponent tgt = new org.hl7.fhir.model.core.Measure.MeasureSupplementalDataComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_N.convertCodeableConcept(src.getCode()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getUsage())
      tgt.addUsage(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_N.convertStringToMarkdown(src.getDescriptionElement()));
    if (src.hasCriteria())
      tgt.setCriteria(Expression43_N.convertExpression(src.getCriteria()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Measure.MeasureSupplementalDataComponent convertMeasureSupplementalDataComponent(org.hl7.fhir.model.core.Measure.MeasureSupplementalDataComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Measure.MeasureSupplementalDataComponent tgt = new org.hl7.fhir.r4b.model.Measure.MeasureSupplementalDataComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_N.convertCodeableConcept(src.getCode()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getUsageList())
      tgt.addUsage(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_N.convertString(src.getDescriptionElement()));
    if (src.hasCriteria())
      tgt.setCriteria(Expression43_N.convertExpression(src.getCriteria()));
    return tgt;
  }
}