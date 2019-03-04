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


public class CoverageEligibilityResponse extends VersionConvertor_40_50 {

  public static org.hl7.fhir.r5.model.CoverageEligibilityResponse convertCoverageEligibilityResponse(org.hl7.fhir.r4.model.CoverageEligibilityResponse src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.CoverageEligibilityResponse tgt = new org.hl7.fhir.r5.model.CoverageEligibilityResponse();
    copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatus(convertEligibilityResponseStatus(src.getStatus()));
    for (org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CoverageEligibilityResponse.EligibilityResponsePurpose> t : src.getPurpose())
      tgt.addPurpose(convertEligibilityResponsePurpose(t.getValue()));
    if (src.hasPatient())
      tgt.setPatient(convertReference(src.getPatient()));
    if (src.hasServiced())
      tgt.setServiced(convertType(src.getServiced()));
    if (src.hasCreated())
      tgt.setCreatedElement(convertDateTime(src.getCreatedElement()));
    if (src.hasRequestor())
      tgt.setRequestor(convertReference(src.getRequestor()));
    if (src.hasRequest())
      tgt.setRequest(convertReference(src.getRequest()));
    if (src.hasOutcome())
      tgt.setOutcome(convertRemittanceOutcome(src.getOutcome()));
    if (src.hasDisposition())
      tgt.setDispositionElement(convertString(src.getDispositionElement()));
    if (src.hasInsurer())
      tgt.setInsurer(convertReference(src.getInsurer()));
    for (org.hl7.fhir.r4.model.CoverageEligibilityResponse.InsuranceComponent t : src.getInsurance())
      tgt.addInsurance(convertInsuranceComponent(t));
    if (src.hasPreAuthRef())
      tgt.setPreAuthRefElement(convertString(src.getPreAuthRefElement()));
    if (src.hasForm())
      tgt.setForm(convertCodeableConcept(src.getForm()));
    for (org.hl7.fhir.r4.model.CoverageEligibilityResponse.ErrorsComponent t : src.getError())
      tgt.addError(convertErrorsComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CoverageEligibilityResponse convertCoverageEligibilityResponse(org.hl7.fhir.r5.model.CoverageEligibilityResponse src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.CoverageEligibilityResponse tgt = new org.hl7.fhir.r4.model.CoverageEligibilityResponse();
    copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatus(convertEligibilityResponseStatus(src.getStatus()));
    for (org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CoverageEligibilityResponse.EligibilityResponsePurpose> t : src.getPurpose())
      tgt.addPurpose(convertEligibilityResponsePurpose(t.getValue()));
    if (src.hasPatient())
      tgt.setPatient(convertReference(src.getPatient()));
    if (src.hasServiced())
      tgt.setServiced(convertType(src.getServiced()));
    if (src.hasCreated())
      tgt.setCreatedElement(convertDateTime(src.getCreatedElement()));
    if (src.hasRequestor())
      tgt.setRequestor(convertReference(src.getRequestor()));
    if (src.hasRequest())
      tgt.setRequest(convertReference(src.getRequest()));
    if (src.hasOutcome())
      tgt.setOutcome(convertRemittanceOutcome(src.getOutcome()));
    if (src.hasDisposition())
      tgt.setDispositionElement(convertString(src.getDispositionElement()));
    if (src.hasInsurer())
      tgt.setInsurer(convertReference(src.getInsurer()));
    for (org.hl7.fhir.r5.model.CoverageEligibilityResponse.InsuranceComponent t : src.getInsurance())
      tgt.addInsurance(convertInsuranceComponent(t));
    if (src.hasPreAuthRef())
      tgt.setPreAuthRefElement(convertString(src.getPreAuthRefElement()));
    if (src.hasForm())
      tgt.setForm(convertCodeableConcept(src.getForm()));
    for (org.hl7.fhir.r5.model.CoverageEligibilityResponse.ErrorsComponent t : src.getError())
      tgt.addError(convertErrorsComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.CoverageEligibilityResponse.EligibilityResponseStatus convertEligibilityResponseStatus(org.hl7.fhir.r4.model.CoverageEligibilityResponse.EligibilityResponseStatus src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case ACTIVE: return org.hl7.fhir.r5.model.CoverageEligibilityResponse.EligibilityResponseStatus.ACTIVE;
    case CANCELLED: return org.hl7.fhir.r5.model.CoverageEligibilityResponse.EligibilityResponseStatus.CANCELLED;
    case DRAFT: return org.hl7.fhir.r5.model.CoverageEligibilityResponse.EligibilityResponseStatus.DRAFT;
    case ENTEREDINERROR: return org.hl7.fhir.r5.model.CoverageEligibilityResponse.EligibilityResponseStatus.ENTEREDINERROR;
    default: return org.hl7.fhir.r5.model.CoverageEligibilityResponse.EligibilityResponseStatus.NULL;
  }
}

  public static org.hl7.fhir.r4.model.CoverageEligibilityResponse.EligibilityResponseStatus convertEligibilityResponseStatus(org.hl7.fhir.r5.model.CoverageEligibilityResponse.EligibilityResponseStatus src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case ACTIVE: return org.hl7.fhir.r4.model.CoverageEligibilityResponse.EligibilityResponseStatus.ACTIVE;
    case CANCELLED: return org.hl7.fhir.r4.model.CoverageEligibilityResponse.EligibilityResponseStatus.CANCELLED;
    case DRAFT: return org.hl7.fhir.r4.model.CoverageEligibilityResponse.EligibilityResponseStatus.DRAFT;
    case ENTEREDINERROR: return org.hl7.fhir.r4.model.CoverageEligibilityResponse.EligibilityResponseStatus.ENTEREDINERROR;
    default: return org.hl7.fhir.r4.model.CoverageEligibilityResponse.EligibilityResponseStatus.NULL;
  }
}

  public static org.hl7.fhir.r5.model.CoverageEligibilityResponse.EligibilityResponsePurpose convertEligibilityResponsePurpose(org.hl7.fhir.r4.model.CoverageEligibilityResponse.EligibilityResponsePurpose src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case AUTHREQUIREMENTS: return org.hl7.fhir.r5.model.CoverageEligibilityResponse.EligibilityResponsePurpose.AUTHREQUIREMENTS;
    case BENEFITS: return org.hl7.fhir.r5.model.CoverageEligibilityResponse.EligibilityResponsePurpose.BENEFITS;
    case DISCOVERY: return org.hl7.fhir.r5.model.CoverageEligibilityResponse.EligibilityResponsePurpose.DISCOVERY;
    case VALIDATION: return org.hl7.fhir.r5.model.CoverageEligibilityResponse.EligibilityResponsePurpose.VALIDATION;
    default: return org.hl7.fhir.r5.model.CoverageEligibilityResponse.EligibilityResponsePurpose.NULL;
  }
}

  public static org.hl7.fhir.r4.model.CoverageEligibilityResponse.EligibilityResponsePurpose convertEligibilityResponsePurpose(org.hl7.fhir.r5.model.CoverageEligibilityResponse.EligibilityResponsePurpose src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case AUTHREQUIREMENTS: return org.hl7.fhir.r4.model.CoverageEligibilityResponse.EligibilityResponsePurpose.AUTHREQUIREMENTS;
    case BENEFITS: return org.hl7.fhir.r4.model.CoverageEligibilityResponse.EligibilityResponsePurpose.BENEFITS;
    case DISCOVERY: return org.hl7.fhir.r4.model.CoverageEligibilityResponse.EligibilityResponsePurpose.DISCOVERY;
    case VALIDATION: return org.hl7.fhir.r4.model.CoverageEligibilityResponse.EligibilityResponsePurpose.VALIDATION;
    default: return org.hl7.fhir.r4.model.CoverageEligibilityResponse.EligibilityResponsePurpose.NULL;
  }
}

  public static org.hl7.fhir.r5.model.Enumerations.RemittanceOutcome convertRemittanceOutcome(org.hl7.fhir.r4.model.Enumerations.RemittanceOutcome src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case QUEUED: return org.hl7.fhir.r5.model.Enumerations.RemittanceOutcome.QUEUED;
    case COMPLETE: return org.hl7.fhir.r5.model.Enumerations.RemittanceOutcome.COMPLETE;
    case ERROR: return org.hl7.fhir.r5.model.Enumerations.RemittanceOutcome.ERROR;
    case PARTIAL: return org.hl7.fhir.r5.model.Enumerations.RemittanceOutcome.PARTIAL;
    default: return org.hl7.fhir.r5.model.Enumerations.RemittanceOutcome.NULL;
  }
}

  public static org.hl7.fhir.r4.model.Enumerations.RemittanceOutcome convertRemittanceOutcome(org.hl7.fhir.r5.model.Enumerations.RemittanceOutcome src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case QUEUED: return org.hl7.fhir.r4.model.Enumerations.RemittanceOutcome.QUEUED;
    case COMPLETE: return org.hl7.fhir.r4.model.Enumerations.RemittanceOutcome.COMPLETE;
    case ERROR: return org.hl7.fhir.r4.model.Enumerations.RemittanceOutcome.ERROR;
    case PARTIAL: return org.hl7.fhir.r4.model.Enumerations.RemittanceOutcome.PARTIAL;
    default: return org.hl7.fhir.r4.model.Enumerations.RemittanceOutcome.NULL;
  }
}

  public static org.hl7.fhir.r5.model.CoverageEligibilityResponse.InsuranceComponent convertInsuranceComponent(org.hl7.fhir.r4.model.CoverageEligibilityResponse.InsuranceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.CoverageEligibilityResponse.InsuranceComponent tgt = new org.hl7.fhir.r5.model.CoverageEligibilityResponse.InsuranceComponent();
    copyElement(src, tgt);
    if (src.hasCoverage())
      tgt.setCoverage(convertReference(src.getCoverage()));
    if (src.hasInforce())
      tgt.setInforceElement(convertBoolean(src.getInforceElement()));
    if (src.hasBenefitPeriod())
      tgt.setBenefitPeriod(convertPeriod(src.getBenefitPeriod()));
    for (org.hl7.fhir.r4.model.CoverageEligibilityResponse.ItemsComponent t : src.getItem())
      tgt.addItem(convertItemsComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CoverageEligibilityResponse.InsuranceComponent convertInsuranceComponent(org.hl7.fhir.r5.model.CoverageEligibilityResponse.InsuranceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.CoverageEligibilityResponse.InsuranceComponent tgt = new org.hl7.fhir.r4.model.CoverageEligibilityResponse.InsuranceComponent();
    copyElement(src, tgt);
    if (src.hasCoverage())
      tgt.setCoverage(convertReference(src.getCoverage()));
    if (src.hasInforce())
      tgt.setInforceElement(convertBoolean(src.getInforceElement()));
    if (src.hasBenefitPeriod())
      tgt.setBenefitPeriod(convertPeriod(src.getBenefitPeriod()));
    for (org.hl7.fhir.r5.model.CoverageEligibilityResponse.ItemsComponent t : src.getItem())
      tgt.addItem(convertItemsComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.CoverageEligibilityResponse.ItemsComponent convertItemsComponent(org.hl7.fhir.r4.model.CoverageEligibilityResponse.ItemsComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.CoverageEligibilityResponse.ItemsComponent tgt = new org.hl7.fhir.r5.model.CoverageEligibilityResponse.ItemsComponent();
    copyElement(src, tgt);
    if (src.hasCategory())
      tgt.setCategory(convertCodeableConcept(src.getCategory()));
    if (src.hasProductOrService())
      tgt.setProductOrService(convertCodeableConcept(src.getProductOrService()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getModifier())
      tgt.addModifier(convertCodeableConcept(t));
    if (src.hasProvider())
      tgt.setProvider(convertReference(src.getProvider()));
    if (src.hasExcluded())
      tgt.setExcludedElement(convertBoolean(src.getExcludedElement()));
    if (src.hasName())
      tgt.setNameElement(convertString(src.getNameElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
    if (src.hasNetwork())
      tgt.setNetwork(convertCodeableConcept(src.getNetwork()));
    if (src.hasUnit())
      tgt.setUnit(convertCodeableConcept(src.getUnit()));
    if (src.hasTerm())
      tgt.setTerm(convertCodeableConcept(src.getTerm()));
    for (org.hl7.fhir.r4.model.CoverageEligibilityResponse.BenefitComponent t : src.getBenefit())
      tgt.addBenefit(convertBenefitComponent(t));
    if (src.hasAuthorizationRequired())
      tgt.setAuthorizationRequiredElement(convertBoolean(src.getAuthorizationRequiredElement()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getAuthorizationSupporting())
      tgt.addAuthorizationSupporting(convertCodeableConcept(t));
    if (src.hasAuthorizationUrl())
      tgt.setAuthorizationUrlElement(convertUri(src.getAuthorizationUrlElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CoverageEligibilityResponse.ItemsComponent convertItemsComponent(org.hl7.fhir.r5.model.CoverageEligibilityResponse.ItemsComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.CoverageEligibilityResponse.ItemsComponent tgt = new org.hl7.fhir.r4.model.CoverageEligibilityResponse.ItemsComponent();
    copyElement(src, tgt);
    if (src.hasCategory())
      tgt.setCategory(convertCodeableConcept(src.getCategory()));
    if (src.hasProductOrService())
      tgt.setProductOrService(convertCodeableConcept(src.getProductOrService()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getModifier())
      tgt.addModifier(convertCodeableConcept(t));
    if (src.hasProvider())
      tgt.setProvider(convertReference(src.getProvider()));
    if (src.hasExcluded())
      tgt.setExcludedElement(convertBoolean(src.getExcludedElement()));
    if (src.hasName())
      tgt.setNameElement(convertString(src.getNameElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
    if (src.hasNetwork())
      tgt.setNetwork(convertCodeableConcept(src.getNetwork()));
    if (src.hasUnit())
      tgt.setUnit(convertCodeableConcept(src.getUnit()));
    if (src.hasTerm())
      tgt.setTerm(convertCodeableConcept(src.getTerm()));
    for (org.hl7.fhir.r5.model.CoverageEligibilityResponse.BenefitComponent t : src.getBenefit())
      tgt.addBenefit(convertBenefitComponent(t));
    if (src.hasAuthorizationRequired())
      tgt.setAuthorizationRequiredElement(convertBoolean(src.getAuthorizationRequiredElement()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getAuthorizationSupporting())
      tgt.addAuthorizationSupporting(convertCodeableConcept(t));
    if (src.hasAuthorizationUrl())
      tgt.setAuthorizationUrlElement(convertUri(src.getAuthorizationUrlElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.CoverageEligibilityResponse.BenefitComponent convertBenefitComponent(org.hl7.fhir.r4.model.CoverageEligibilityResponse.BenefitComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.CoverageEligibilityResponse.BenefitComponent tgt = new org.hl7.fhir.r5.model.CoverageEligibilityResponse.BenefitComponent();
    copyElement(src, tgt);
    if (src.hasType())
      tgt.setType(convertCodeableConcept(src.getType()));
    if (src.hasAllowed())
      tgt.setAllowed(convertType(src.getAllowed()));
    if (src.hasUsed())
      tgt.setUsed(convertType(src.getUsed()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CoverageEligibilityResponse.BenefitComponent convertBenefitComponent(org.hl7.fhir.r5.model.CoverageEligibilityResponse.BenefitComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.CoverageEligibilityResponse.BenefitComponent tgt = new org.hl7.fhir.r4.model.CoverageEligibilityResponse.BenefitComponent();
    copyElement(src, tgt);
    if (src.hasType())
      tgt.setType(convertCodeableConcept(src.getType()));
    if (src.hasAllowed())
      tgt.setAllowed(convertType(src.getAllowed()));
    if (src.hasUsed())
      tgt.setUsed(convertType(src.getUsed()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.CoverageEligibilityResponse.ErrorsComponent convertErrorsComponent(org.hl7.fhir.r4.model.CoverageEligibilityResponse.ErrorsComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.CoverageEligibilityResponse.ErrorsComponent tgt = new org.hl7.fhir.r5.model.CoverageEligibilityResponse.ErrorsComponent();
    copyElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(convertCodeableConcept(src.getCode()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CoverageEligibilityResponse.ErrorsComponent convertErrorsComponent(org.hl7.fhir.r5.model.CoverageEligibilityResponse.ErrorsComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.CoverageEligibilityResponse.ErrorsComponent tgt = new org.hl7.fhir.r4.model.CoverageEligibilityResponse.ErrorsComponent();
    copyElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(convertCodeableConcept(src.getCode()));
    return tgt;
  }


}
