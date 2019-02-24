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


public class CoverageEligibilityRequest extends VersionConvertor_40_50 {

  public static org.hl7.fhir.r5.model.CoverageEligibilityRequest convertCoverageEligibilityRequest(org.hl7.fhir.r4.model.CoverageEligibilityRequest src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.CoverageEligibilityRequest tgt = new org.hl7.fhir.r5.model.CoverageEligibilityRequest();
    copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatus(convertEligibilityRequestStatus(src.getStatus()));
    if (src.hasPriority())
      tgt.setPriority(convertCodeableConcept(src.getPriority()));
    for (org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CoverageEligibilityRequest.EligibilityRequestPurpose> t : src.getPurpose())
      tgt.addPurpose(convertEligibilityRequestPurpose(t.getValue()));
    if (src.hasPatient())
      tgt.setPatient(convertReference(src.getPatient()));
    if (src.hasServiced())
      tgt.setServiced(convertType(src.getServiced()));
    if (src.hasCreated())
      tgt.setCreatedElement(convertDateTime(src.getCreatedElement()));
    if (src.hasEnterer())
      tgt.setEnterer(convertReference(src.getEnterer()));
    if (src.hasProvider())
      tgt.setProvider(convertReference(src.getProvider()));
    if (src.hasInsurer())
      tgt.setInsurer(convertReference(src.getInsurer()));
    if (src.hasFacility())
      tgt.setFacility(convertReference(src.getFacility()));
    for (org.hl7.fhir.r4.model.CoverageEligibilityRequest.SupportingInformationComponent t : src.getSupportingInfo())
      tgt.addSupportingInfo(convertSupportingInformationComponent(t));
    for (org.hl7.fhir.r4.model.CoverageEligibilityRequest.InsuranceComponent t : src.getInsurance())
      tgt.addInsurance(convertInsuranceComponent(t));
    for (org.hl7.fhir.r4.model.CoverageEligibilityRequest.DetailsComponent t : src.getItem())
      tgt.addItem(convertDetailsComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CoverageEligibilityRequest convertCoverageEligibilityRequest(org.hl7.fhir.r5.model.CoverageEligibilityRequest src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.CoverageEligibilityRequest tgt = new org.hl7.fhir.r4.model.CoverageEligibilityRequest();
    copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatus(convertEligibilityRequestStatus(src.getStatus()));
    if (src.hasPriority())
      tgt.setPriority(convertCodeableConcept(src.getPriority()));
    for (org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CoverageEligibilityRequest.EligibilityRequestPurpose> t : src.getPurpose())
      tgt.addPurpose(convertEligibilityRequestPurpose(t.getValue()));
    if (src.hasPatient())
      tgt.setPatient(convertReference(src.getPatient()));
    if (src.hasServiced())
      tgt.setServiced(convertType(src.getServiced()));
    if (src.hasCreated())
      tgt.setCreatedElement(convertDateTime(src.getCreatedElement()));
    if (src.hasEnterer())
      tgt.setEnterer(convertReference(src.getEnterer()));
    if (src.hasProvider())
      tgt.setProvider(convertReference(src.getProvider()));
    if (src.hasInsurer())
      tgt.setInsurer(convertReference(src.getInsurer()));
    if (src.hasFacility())
      tgt.setFacility(convertReference(src.getFacility()));
    for (org.hl7.fhir.r5.model.CoverageEligibilityRequest.SupportingInformationComponent t : src.getSupportingInfo())
      tgt.addSupportingInfo(convertSupportingInformationComponent(t));
    for (org.hl7.fhir.r5.model.CoverageEligibilityRequest.InsuranceComponent t : src.getInsurance())
      tgt.addInsurance(convertInsuranceComponent(t));
    for (org.hl7.fhir.r5.model.CoverageEligibilityRequest.DetailsComponent t : src.getItem())
      tgt.addItem(convertDetailsComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.CoverageEligibilityRequest.EligibilityRequestStatus convertEligibilityRequestStatus(org.hl7.fhir.r4.model.CoverageEligibilityRequest.EligibilityRequestStatus src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case ACTIVE: return org.hl7.fhir.r5.model.CoverageEligibilityRequest.EligibilityRequestStatus.ACTIVE;
    case CANCELLED: return org.hl7.fhir.r5.model.CoverageEligibilityRequest.EligibilityRequestStatus.CANCELLED;
    case DRAFT: return org.hl7.fhir.r5.model.CoverageEligibilityRequest.EligibilityRequestStatus.DRAFT;
    case ENTEREDINERROR: return org.hl7.fhir.r5.model.CoverageEligibilityRequest.EligibilityRequestStatus.ENTEREDINERROR;
    default: return org.hl7.fhir.r5.model.CoverageEligibilityRequest.EligibilityRequestStatus.NULL;
  }
}

  public static org.hl7.fhir.r4.model.CoverageEligibilityRequest.EligibilityRequestStatus convertEligibilityRequestStatus(org.hl7.fhir.r5.model.CoverageEligibilityRequest.EligibilityRequestStatus src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case ACTIVE: return org.hl7.fhir.r4.model.CoverageEligibilityRequest.EligibilityRequestStatus.ACTIVE;
    case CANCELLED: return org.hl7.fhir.r4.model.CoverageEligibilityRequest.EligibilityRequestStatus.CANCELLED;
    case DRAFT: return org.hl7.fhir.r4.model.CoverageEligibilityRequest.EligibilityRequestStatus.DRAFT;
    case ENTEREDINERROR: return org.hl7.fhir.r4.model.CoverageEligibilityRequest.EligibilityRequestStatus.ENTEREDINERROR;
    default: return org.hl7.fhir.r4.model.CoverageEligibilityRequest.EligibilityRequestStatus.NULL;
  }
}

  public static org.hl7.fhir.r5.model.CoverageEligibilityRequest.EligibilityRequestPurpose convertEligibilityRequestPurpose(org.hl7.fhir.r4.model.CoverageEligibilityRequest.EligibilityRequestPurpose src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case AUTHREQUIREMENTS: return org.hl7.fhir.r5.model.CoverageEligibilityRequest.EligibilityRequestPurpose.AUTHREQUIREMENTS;
    case BENEFITS: return org.hl7.fhir.r5.model.CoverageEligibilityRequest.EligibilityRequestPurpose.BENEFITS;
    case DISCOVERY: return org.hl7.fhir.r5.model.CoverageEligibilityRequest.EligibilityRequestPurpose.DISCOVERY;
    case VALIDATION: return org.hl7.fhir.r5.model.CoverageEligibilityRequest.EligibilityRequestPurpose.VALIDATION;
    default: return org.hl7.fhir.r5.model.CoverageEligibilityRequest.EligibilityRequestPurpose.NULL;
  }
}

  public static org.hl7.fhir.r4.model.CoverageEligibilityRequest.EligibilityRequestPurpose convertEligibilityRequestPurpose(org.hl7.fhir.r5.model.CoverageEligibilityRequest.EligibilityRequestPurpose src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case AUTHREQUIREMENTS: return org.hl7.fhir.r4.model.CoverageEligibilityRequest.EligibilityRequestPurpose.AUTHREQUIREMENTS;
    case BENEFITS: return org.hl7.fhir.r4.model.CoverageEligibilityRequest.EligibilityRequestPurpose.BENEFITS;
    case DISCOVERY: return org.hl7.fhir.r4.model.CoverageEligibilityRequest.EligibilityRequestPurpose.DISCOVERY;
    case VALIDATION: return org.hl7.fhir.r4.model.CoverageEligibilityRequest.EligibilityRequestPurpose.VALIDATION;
    default: return org.hl7.fhir.r4.model.CoverageEligibilityRequest.EligibilityRequestPurpose.NULL;
  }
}

  public static org.hl7.fhir.r5.model.CoverageEligibilityRequest.SupportingInformationComponent convertSupportingInformationComponent(org.hl7.fhir.r4.model.CoverageEligibilityRequest.SupportingInformationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.CoverageEligibilityRequest.SupportingInformationComponent tgt = new org.hl7.fhir.r5.model.CoverageEligibilityRequest.SupportingInformationComponent();
    copyElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(convertPositiveInt(src.getSequenceElement()));
    if (src.hasInformation())
      tgt.setInformation(convertReference(src.getInformation()));
    if (src.hasAppliesToAll())
      tgt.setAppliesToAllElement(convertBoolean(src.getAppliesToAllElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CoverageEligibilityRequest.SupportingInformationComponent convertSupportingInformationComponent(org.hl7.fhir.r5.model.CoverageEligibilityRequest.SupportingInformationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.CoverageEligibilityRequest.SupportingInformationComponent tgt = new org.hl7.fhir.r4.model.CoverageEligibilityRequest.SupportingInformationComponent();
    copyElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(convertPositiveInt(src.getSequenceElement()));
    if (src.hasInformation())
      tgt.setInformation(convertReference(src.getInformation()));
    if (src.hasAppliesToAll())
      tgt.setAppliesToAllElement(convertBoolean(src.getAppliesToAllElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.CoverageEligibilityRequest.InsuranceComponent convertInsuranceComponent(org.hl7.fhir.r4.model.CoverageEligibilityRequest.InsuranceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.CoverageEligibilityRequest.InsuranceComponent tgt = new org.hl7.fhir.r5.model.CoverageEligibilityRequest.InsuranceComponent();
    copyElement(src, tgt);
    if (src.hasFocal())
      tgt.setFocalElement(convertBoolean(src.getFocalElement()));
    if (src.hasCoverage())
      tgt.setCoverage(convertReference(src.getCoverage()));
    if (src.hasBusinessArrangement())
      tgt.setBusinessArrangementElement(convertString(src.getBusinessArrangementElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CoverageEligibilityRequest.InsuranceComponent convertInsuranceComponent(org.hl7.fhir.r5.model.CoverageEligibilityRequest.InsuranceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.CoverageEligibilityRequest.InsuranceComponent tgt = new org.hl7.fhir.r4.model.CoverageEligibilityRequest.InsuranceComponent();
    copyElement(src, tgt);
    if (src.hasFocal())
      tgt.setFocalElement(convertBoolean(src.getFocalElement()));
    if (src.hasCoverage())
      tgt.setCoverage(convertReference(src.getCoverage()));
    if (src.hasBusinessArrangement())
      tgt.setBusinessArrangementElement(convertString(src.getBusinessArrangementElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.CoverageEligibilityRequest.DetailsComponent convertDetailsComponent(org.hl7.fhir.r4.model.CoverageEligibilityRequest.DetailsComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.CoverageEligibilityRequest.DetailsComponent tgt = new org.hl7.fhir.r5.model.CoverageEligibilityRequest.DetailsComponent();
    copyElement(src, tgt);
    for (org.hl7.fhir.r4.model.PositiveIntType t : src.getSupportingInfoSequence())
      tgt.getSupportingInfoSequence().add(convertPositiveInt(t));
    if (src.hasCategory())
      tgt.setCategory(convertCodeableConcept(src.getCategory()));
    if (src.hasProductOrService())
      tgt.setProductOrService(convertCodeableConcept(src.getProductOrService()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getModifier())
      tgt.addModifier(convertCodeableConcept(t));
    if (src.hasProvider())
      tgt.setProvider(convertReference(src.getProvider()));
    if (src.hasQuantity())
      tgt.setQuantity(convertSimpleQuantity(src.getQuantity()));
    if (src.hasUnitPrice())
      tgt.setUnitPrice(convertMoney(src.getUnitPrice()));
    if (src.hasFacility())
      tgt.setFacility(convertReference(src.getFacility()));
    for (org.hl7.fhir.r4.model.CoverageEligibilityRequest.DiagnosisComponent t : src.getDiagnosis())
      tgt.addDiagnosis(convertDiagnosisComponent(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getDetail())
      tgt.addDetail(convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CoverageEligibilityRequest.DetailsComponent convertDetailsComponent(org.hl7.fhir.r5.model.CoverageEligibilityRequest.DetailsComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.CoverageEligibilityRequest.DetailsComponent tgt = new org.hl7.fhir.r4.model.CoverageEligibilityRequest.DetailsComponent();
    copyElement(src, tgt);
    for (org.hl7.fhir.r5.model.PositiveIntType t : src.getSupportingInfoSequence())
      tgt.getSupportingInfoSequence().add(convertPositiveInt(t));
    if (src.hasCategory())
      tgt.setCategory(convertCodeableConcept(src.getCategory()));
    if (src.hasProductOrService())
      tgt.setProductOrService(convertCodeableConcept(src.getProductOrService()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getModifier())
      tgt.addModifier(convertCodeableConcept(t));
    if (src.hasProvider())
      tgt.setProvider(convertReference(src.getProvider()));
    if (src.hasQuantity())
      tgt.setQuantity(convertSimpleQuantity(src.getQuantity()));
    if (src.hasUnitPrice())
      tgt.setUnitPrice(convertMoney(src.getUnitPrice()));
    if (src.hasFacility())
      tgt.setFacility(convertReference(src.getFacility()));
    for (org.hl7.fhir.r5.model.CoverageEligibilityRequest.DiagnosisComponent t : src.getDiagnosis())
      tgt.addDiagnosis(convertDiagnosisComponent(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getDetail())
      tgt.addDetail(convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.CoverageEligibilityRequest.DiagnosisComponent convertDiagnosisComponent(org.hl7.fhir.r4.model.CoverageEligibilityRequest.DiagnosisComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.CoverageEligibilityRequest.DiagnosisComponent tgt = new org.hl7.fhir.r5.model.CoverageEligibilityRequest.DiagnosisComponent();
    copyElement(src, tgt);
    if (src.hasDiagnosis())
      tgt.setDiagnosis(convertType(src.getDiagnosis()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CoverageEligibilityRequest.DiagnosisComponent convertDiagnosisComponent(org.hl7.fhir.r5.model.CoverageEligibilityRequest.DiagnosisComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.CoverageEligibilityRequest.DiagnosisComponent tgt = new org.hl7.fhir.r4.model.CoverageEligibilityRequest.DiagnosisComponent();
    copyElement(src, tgt);
    if (src.hasDiagnosis())
      tgt.setDiagnosis(convertType(src.getDiagnosis()));
    return tgt;
  }


}
