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


public class EffectEvidenceSynthesis extends VersionConvertor_40_50 {

  public static org.hl7.fhir.r5.model.EffectEvidenceSynthesis convertEffectEvidenceSynthesis(org.hl7.fhir.r4.model.EffectEvidenceSynthesis src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.EffectEvidenceSynthesis tgt = new org.hl7.fhir.r5.model.EffectEvidenceSynthesis();
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
    if (src.hasStatus())
      tgt.setStatus(Enumerations.convertPublicationStatus(src.getStatus()));
    if (src.hasDate())
      tgt.setDateElement(convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(convertString(src.getPublisherElement()));
    for (org.hl7.fhir.r4.model.ContactDetail t : src.getContact())
      tgt.addContact(convertContactDetail(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r4.model.Annotation t : src.getNote())
      tgt.addNote(convertAnnotation(t));
    for (org.hl7.fhir.r4.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(convertUsageContext(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(convertCodeableConcept(t));
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
    if (src.hasSynthesisType())
      tgt.setSynthesisType(convertCodeableConcept(src.getSynthesisType()));
    if (src.hasStudyType())
      tgt.setStudyType(convertCodeableConcept(src.getStudyType()));
    if (src.hasPopulation())
      tgt.setPopulation(convertReference(src.getPopulation()));
    if (src.hasExposure())
      tgt.setExposure(convertReference(src.getExposure()));
    if (src.hasExposureAlternative())
      tgt.setExposureAlternative(convertReference(src.getExposureAlternative()));
    if (src.hasOutcome())
      tgt.setOutcome(convertReference(src.getOutcome()));
    if (src.hasSampleSize())
      tgt.setSampleSize(convertEffectEvidenceSynthesisSampleSizeComponent(src.getSampleSize()));
    for (org.hl7.fhir.r4.model.EffectEvidenceSynthesis.EffectEvidenceSynthesisResultsByExposureComponent t : src.getResultsByExposure())
      tgt.addResultsByExposure(convertEffectEvidenceSynthesisResultsByExposureComponent(t));
    for (org.hl7.fhir.r4.model.EffectEvidenceSynthesis.EffectEvidenceSynthesisEffectEstimateComponent t : src.getEffectEstimate())
      tgt.addEffectEstimate(convertEffectEvidenceSynthesisEffectEstimateComponent(t));
    for (org.hl7.fhir.r4.model.EffectEvidenceSynthesis.EffectEvidenceSynthesisCertaintyComponent t : src.getCertainty())
      tgt.addCertainty(convertEffectEvidenceSynthesisCertaintyComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.EffectEvidenceSynthesis convertEffectEvidenceSynthesis(org.hl7.fhir.r5.model.EffectEvidenceSynthesis src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.EffectEvidenceSynthesis tgt = new org.hl7.fhir.r4.model.EffectEvidenceSynthesis();
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
    if (src.hasStatus())
      tgt.setStatus(Enumerations.convertPublicationStatus(src.getStatus()));
    if (src.hasDate())
      tgt.setDateElement(convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(convertString(src.getPublisherElement()));
    for (org.hl7.fhir.r5.model.ContactDetail t : src.getContact())
      tgt.addContact(convertContactDetail(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r5.model.Annotation t : src.getNote())
      tgt.addNote(convertAnnotation(t));
    for (org.hl7.fhir.r5.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(convertUsageContext(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(convertCodeableConcept(t));
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
    if (src.hasSynthesisType())
      tgt.setSynthesisType(convertCodeableConcept(src.getSynthesisType()));
    if (src.hasStudyType())
      tgt.setStudyType(convertCodeableConcept(src.getStudyType()));
    if (src.hasPopulation())
      tgt.setPopulation(convertReference(src.getPopulation()));
    if (src.hasExposure())
      tgt.setExposure(convertReference(src.getExposure()));
    if (src.hasExposureAlternative())
      tgt.setExposureAlternative(convertReference(src.getExposureAlternative()));
    if (src.hasOutcome())
      tgt.setOutcome(convertReference(src.getOutcome()));
    if (src.hasSampleSize())
      tgt.setSampleSize(convertEffectEvidenceSynthesisSampleSizeComponent(src.getSampleSize()));
    for (org.hl7.fhir.r5.model.EffectEvidenceSynthesis.EffectEvidenceSynthesisResultsByExposureComponent t : src.getResultsByExposure())
      tgt.addResultsByExposure(convertEffectEvidenceSynthesisResultsByExposureComponent(t));
    for (org.hl7.fhir.r5.model.EffectEvidenceSynthesis.EffectEvidenceSynthesisEffectEstimateComponent t : src.getEffectEstimate())
      tgt.addEffectEstimate(convertEffectEvidenceSynthesisEffectEstimateComponent(t));
    for (org.hl7.fhir.r5.model.EffectEvidenceSynthesis.EffectEvidenceSynthesisCertaintyComponent t : src.getCertainty())
      tgt.addCertainty(convertEffectEvidenceSynthesisCertaintyComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.EffectEvidenceSynthesis.EffectEvidenceSynthesisSampleSizeComponent convertEffectEvidenceSynthesisSampleSizeComponent(org.hl7.fhir.r4.model.EffectEvidenceSynthesis.EffectEvidenceSynthesisSampleSizeComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.EffectEvidenceSynthesis.EffectEvidenceSynthesisSampleSizeComponent tgt = new org.hl7.fhir.r5.model.EffectEvidenceSynthesis.EffectEvidenceSynthesisSampleSizeComponent();
    copyElement(src, tgt);
    if (src.hasDescription())
      tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
    if (src.hasNumberOfStudies())
      tgt.setNumberOfStudiesElement(convertInteger(src.getNumberOfStudiesElement()));
    if (src.hasNumberOfParticipants())
      tgt.setNumberOfParticipantsElement(convertInteger(src.getNumberOfParticipantsElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.EffectEvidenceSynthesis.EffectEvidenceSynthesisSampleSizeComponent convertEffectEvidenceSynthesisSampleSizeComponent(org.hl7.fhir.r5.model.EffectEvidenceSynthesis.EffectEvidenceSynthesisSampleSizeComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.EffectEvidenceSynthesis.EffectEvidenceSynthesisSampleSizeComponent tgt = new org.hl7.fhir.r4.model.EffectEvidenceSynthesis.EffectEvidenceSynthesisSampleSizeComponent();
    copyElement(src, tgt);
    if (src.hasDescription())
      tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
    if (src.hasNumberOfStudies())
      tgt.setNumberOfStudiesElement(convertInteger(src.getNumberOfStudiesElement()));
    if (src.hasNumberOfParticipants())
      tgt.setNumberOfParticipantsElement(convertInteger(src.getNumberOfParticipantsElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.EffectEvidenceSynthesis.EffectEvidenceSynthesisResultsByExposureComponent convertEffectEvidenceSynthesisResultsByExposureComponent(org.hl7.fhir.r4.model.EffectEvidenceSynthesis.EffectEvidenceSynthesisResultsByExposureComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.EffectEvidenceSynthesis.EffectEvidenceSynthesisResultsByExposureComponent tgt = new org.hl7.fhir.r5.model.EffectEvidenceSynthesis.EffectEvidenceSynthesisResultsByExposureComponent();
    copyElement(src, tgt);
    if (src.hasDescription())
      tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
    if (src.hasExposureState())
      tgt.setExposureState(convertExposureState(src.getExposureState()));
    if (src.hasVariantState())
      tgt.setVariantState(convertCodeableConcept(src.getVariantState()));
    if (src.hasRiskEvidenceSynthesis())
      tgt.setRiskEvidenceSynthesis(convertReference(src.getRiskEvidenceSynthesis()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.EffectEvidenceSynthesis.EffectEvidenceSynthesisResultsByExposureComponent convertEffectEvidenceSynthesisResultsByExposureComponent(org.hl7.fhir.r5.model.EffectEvidenceSynthesis.EffectEvidenceSynthesisResultsByExposureComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.EffectEvidenceSynthesis.EffectEvidenceSynthesisResultsByExposureComponent tgt = new org.hl7.fhir.r4.model.EffectEvidenceSynthesis.EffectEvidenceSynthesisResultsByExposureComponent();
    copyElement(src, tgt);
    if (src.hasDescription())
      tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
    if (src.hasExposureState())
      tgt.setExposureState(convertExposureState(src.getExposureState()));
    if (src.hasVariantState())
      tgt.setVariantState(convertCodeableConcept(src.getVariantState()));
    if (src.hasRiskEvidenceSynthesis())
      tgt.setRiskEvidenceSynthesis(convertReference(src.getRiskEvidenceSynthesis()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.EffectEvidenceSynthesis.ExposureState convertExposureState(org.hl7.fhir.r4.model.EffectEvidenceSynthesis.ExposureState src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case EXPOSURE: return org.hl7.fhir.r5.model.EffectEvidenceSynthesis.ExposureState.EXPOSURE;
    case EXPOSUREALTERNATIVE: return org.hl7.fhir.r5.model.EffectEvidenceSynthesis.ExposureState.EXPOSUREALTERNATIVE;
    default: return org.hl7.fhir.r5.model.EffectEvidenceSynthesis.ExposureState.NULL;
  }
}

  public static org.hl7.fhir.r4.model.EffectEvidenceSynthesis.ExposureState convertExposureState(org.hl7.fhir.r5.model.EffectEvidenceSynthesis.ExposureState src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case EXPOSURE: return org.hl7.fhir.r4.model.EffectEvidenceSynthesis.ExposureState.EXPOSURE;
    case EXPOSUREALTERNATIVE: return org.hl7.fhir.r4.model.EffectEvidenceSynthesis.ExposureState.EXPOSUREALTERNATIVE;
    default: return org.hl7.fhir.r4.model.EffectEvidenceSynthesis.ExposureState.NULL;
  }
}

  public static org.hl7.fhir.r5.model.EffectEvidenceSynthesis.EffectEvidenceSynthesisEffectEstimateComponent convertEffectEvidenceSynthesisEffectEstimateComponent(org.hl7.fhir.r4.model.EffectEvidenceSynthesis.EffectEvidenceSynthesisEffectEstimateComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.EffectEvidenceSynthesis.EffectEvidenceSynthesisEffectEstimateComponent tgt = new org.hl7.fhir.r5.model.EffectEvidenceSynthesis.EffectEvidenceSynthesisEffectEstimateComponent();
    copyElement(src, tgt);
    if (src.hasDescription())
      tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
    if (src.hasType())
      tgt.setType(convertCodeableConcept(src.getType()));
    if (src.hasVariantState())
      tgt.setVariantState(convertCodeableConcept(src.getVariantState()));
    if (src.hasValue())
      tgt.setValueElement(convertDecimal(src.getValueElement()));
    if (src.hasUnitOfMeasure())
      tgt.setUnitOfMeasure(convertCodeableConcept(src.getUnitOfMeasure()));
    for (org.hl7.fhir.r4.model.EffectEvidenceSynthesis.EffectEvidenceSynthesisEffectEstimatePrecisionEstimateComponent t : src.getPrecisionEstimate())
      tgt.addPrecisionEstimate(convertEffectEvidenceSynthesisEffectEstimatePrecisionEstimateComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.EffectEvidenceSynthesis.EffectEvidenceSynthesisEffectEstimateComponent convertEffectEvidenceSynthesisEffectEstimateComponent(org.hl7.fhir.r5.model.EffectEvidenceSynthesis.EffectEvidenceSynthesisEffectEstimateComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.EffectEvidenceSynthesis.EffectEvidenceSynthesisEffectEstimateComponent tgt = new org.hl7.fhir.r4.model.EffectEvidenceSynthesis.EffectEvidenceSynthesisEffectEstimateComponent();
    copyElement(src, tgt);
    if (src.hasDescription())
      tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
    if (src.hasType())
      tgt.setType(convertCodeableConcept(src.getType()));
    if (src.hasVariantState())
      tgt.setVariantState(convertCodeableConcept(src.getVariantState()));
    if (src.hasValue())
      tgt.setValueElement(convertDecimal(src.getValueElement()));
    if (src.hasUnitOfMeasure())
      tgt.setUnitOfMeasure(convertCodeableConcept(src.getUnitOfMeasure()));
    for (org.hl7.fhir.r5.model.EffectEvidenceSynthesis.EffectEvidenceSynthesisEffectEstimatePrecisionEstimateComponent t : src.getPrecisionEstimate())
      tgt.addPrecisionEstimate(convertEffectEvidenceSynthesisEffectEstimatePrecisionEstimateComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.EffectEvidenceSynthesis.EffectEvidenceSynthesisEffectEstimatePrecisionEstimateComponent convertEffectEvidenceSynthesisEffectEstimatePrecisionEstimateComponent(org.hl7.fhir.r4.model.EffectEvidenceSynthesis.EffectEvidenceSynthesisEffectEstimatePrecisionEstimateComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.EffectEvidenceSynthesis.EffectEvidenceSynthesisEffectEstimatePrecisionEstimateComponent tgt = new org.hl7.fhir.r5.model.EffectEvidenceSynthesis.EffectEvidenceSynthesisEffectEstimatePrecisionEstimateComponent();
    copyElement(src, tgt);
    if (src.hasType())
      tgt.setType(convertCodeableConcept(src.getType()));
    if (src.hasLevel())
      tgt.setLevelElement(convertDecimal(src.getLevelElement()));
    if (src.hasFrom())
      tgt.setFromElement(convertDecimal(src.getFromElement()));
    if (src.hasTo())
      tgt.setToElement(convertDecimal(src.getToElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.EffectEvidenceSynthesis.EffectEvidenceSynthesisEffectEstimatePrecisionEstimateComponent convertEffectEvidenceSynthesisEffectEstimatePrecisionEstimateComponent(org.hl7.fhir.r5.model.EffectEvidenceSynthesis.EffectEvidenceSynthesisEffectEstimatePrecisionEstimateComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.EffectEvidenceSynthesis.EffectEvidenceSynthesisEffectEstimatePrecisionEstimateComponent tgt = new org.hl7.fhir.r4.model.EffectEvidenceSynthesis.EffectEvidenceSynthesisEffectEstimatePrecisionEstimateComponent();
    copyElement(src, tgt);
    if (src.hasType())
      tgt.setType(convertCodeableConcept(src.getType()));
    if (src.hasLevel())
      tgt.setLevelElement(convertDecimal(src.getLevelElement()));
    if (src.hasFrom())
      tgt.setFromElement(convertDecimal(src.getFromElement()));
    if (src.hasTo())
      tgt.setToElement(convertDecimal(src.getToElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.EffectEvidenceSynthesis.EffectEvidenceSynthesisCertaintyComponent convertEffectEvidenceSynthesisCertaintyComponent(org.hl7.fhir.r4.model.EffectEvidenceSynthesis.EffectEvidenceSynthesisCertaintyComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.EffectEvidenceSynthesis.EffectEvidenceSynthesisCertaintyComponent tgt = new org.hl7.fhir.r5.model.EffectEvidenceSynthesis.EffectEvidenceSynthesisCertaintyComponent();
    copyElement(src, tgt);
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getRating())
      tgt.addRating(convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.Annotation t : src.getNote())
      tgt.addNote(convertAnnotation(t));
    for (org.hl7.fhir.r4.model.EffectEvidenceSynthesis.EffectEvidenceSynthesisCertaintyCertaintySubcomponentComponent t : src.getCertaintySubcomponent())
      tgt.addCertaintySubcomponent(convertEffectEvidenceSynthesisCertaintyCertaintySubcomponentComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.EffectEvidenceSynthesis.EffectEvidenceSynthesisCertaintyComponent convertEffectEvidenceSynthesisCertaintyComponent(org.hl7.fhir.r5.model.EffectEvidenceSynthesis.EffectEvidenceSynthesisCertaintyComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.EffectEvidenceSynthesis.EffectEvidenceSynthesisCertaintyComponent tgt = new org.hl7.fhir.r4.model.EffectEvidenceSynthesis.EffectEvidenceSynthesisCertaintyComponent();
    copyElement(src, tgt);
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getRating())
      tgt.addRating(convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.Annotation t : src.getNote())
      tgt.addNote(convertAnnotation(t));
    for (org.hl7.fhir.r5.model.EffectEvidenceSynthesis.EffectEvidenceSynthesisCertaintyCertaintySubcomponentComponent t : src.getCertaintySubcomponent())
      tgt.addCertaintySubcomponent(convertEffectEvidenceSynthesisCertaintyCertaintySubcomponentComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.EffectEvidenceSynthesis.EffectEvidenceSynthesisCertaintyCertaintySubcomponentComponent convertEffectEvidenceSynthesisCertaintyCertaintySubcomponentComponent(org.hl7.fhir.r4.model.EffectEvidenceSynthesis.EffectEvidenceSynthesisCertaintyCertaintySubcomponentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.EffectEvidenceSynthesis.EffectEvidenceSynthesisCertaintyCertaintySubcomponentComponent tgt = new org.hl7.fhir.r5.model.EffectEvidenceSynthesis.EffectEvidenceSynthesisCertaintyCertaintySubcomponentComponent();
    copyElement(src, tgt);
    if (src.hasType())
      tgt.setType(convertCodeableConcept(src.getType()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getRating())
      tgt.addRating(convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.Annotation t : src.getNote())
      tgt.addNote(convertAnnotation(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.EffectEvidenceSynthesis.EffectEvidenceSynthesisCertaintyCertaintySubcomponentComponent convertEffectEvidenceSynthesisCertaintyCertaintySubcomponentComponent(org.hl7.fhir.r5.model.EffectEvidenceSynthesis.EffectEvidenceSynthesisCertaintyCertaintySubcomponentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.EffectEvidenceSynthesis.EffectEvidenceSynthesisCertaintyCertaintySubcomponentComponent tgt = new org.hl7.fhir.r4.model.EffectEvidenceSynthesis.EffectEvidenceSynthesisCertaintyCertaintySubcomponentComponent();
    copyElement(src, tgt);
    if (src.hasType())
      tgt.setType(convertCodeableConcept(src.getType()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getRating())
      tgt.addRating(convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.Annotation t : src.getNote())
      tgt.addNote(convertAnnotation(t));
    return tgt;
  }


}
