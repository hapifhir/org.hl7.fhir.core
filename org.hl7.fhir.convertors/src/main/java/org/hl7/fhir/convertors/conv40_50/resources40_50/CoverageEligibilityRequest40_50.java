package org.hl7.fhir.convertors.conv40_50.resources40_50;

import org.hl7.fhir.convertors.factory.VersionConvertorFactory_40_50;
import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.CodeableConcept40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Identifier40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Money40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.SimpleQuantity40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Boolean40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.DateTime40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.PositiveInt40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.String40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.special40_50.Reference40_50;
import org.hl7.fhir.exceptions.FHIRException;

import java.util.stream.Collectors;

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
public class CoverageEligibilityRequest40_50 {

  public static org.hl7.fhir.r5.model.CoverageEligibilityRequest convertCoverageEligibilityRequest(org.hl7.fhir.r4.model.CoverageEligibilityRequest src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.CoverageEligibilityRequest tgt = new org.hl7.fhir.r5.model.CoverageEligibilityRequest();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_50.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertEligibilityRequestStatus(src.getStatusElement()));
    if (src.hasPriority())
      tgt.setPriority(CodeableConcept40_50.convertCodeableConcept(src.getPriority()));
    tgt.setPurpose(src.getPurpose().stream()
      .map(CoverageEligibilityRequest40_50::convertEligibilityRequestPurpose)
      .collect(Collectors.toList()));
    if (src.hasPatient())
      tgt.setPatient(Reference40_50.convertReference(src.getPatient()));
    if (src.hasServiced())
      tgt.setServiced(VersionConvertorFactory_40_50.convertType(src.getServiced()));
    if (src.hasCreated())
      tgt.setCreatedElement(DateTime40_50.convertDateTime(src.getCreatedElement()));
    if (src.hasEnterer())
      tgt.setEnterer(Reference40_50.convertReference(src.getEnterer()));
    if (src.hasProvider())
      tgt.setProvider(Reference40_50.convertReference(src.getProvider()));
    if (src.hasInsurer())
      tgt.setInsurer(Reference40_50.convertReference(src.getInsurer()));
    if (src.hasFacility())
      tgt.setFacility(Reference40_50.convertReference(src.getFacility()));
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
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_50.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertEligibilityRequestStatus(src.getStatusElement()));
    if (src.hasPriority())
      tgt.setPriority(CodeableConcept40_50.convertCodeableConcept(src.getPriority()));
    tgt.setPurpose(src.getPurpose().stream()
      .map(CoverageEligibilityRequest40_50::convertEligibilityRequestPurpose)
      .collect(Collectors.toList()));
    if (src.hasPatient())
      tgt.setPatient(Reference40_50.convertReference(src.getPatient()));
    if (src.hasServiced())
      tgt.setServiced(VersionConvertorFactory_40_50.convertType(src.getServiced()));
    if (src.hasCreated())
      tgt.setCreatedElement(DateTime40_50.convertDateTime(src.getCreatedElement()));
    if (src.hasEnterer())
      tgt.setEnterer(Reference40_50.convertReference(src.getEnterer()));
    if (src.hasProvider())
      tgt.setProvider(Reference40_50.convertReference(src.getProvider()));
    if (src.hasInsurer())
      tgt.setInsurer(Reference40_50.convertReference(src.getInsurer()));
    if (src.hasFacility())
      tgt.setFacility(Reference40_50.convertReference(src.getFacility()));
    for (org.hl7.fhir.r5.model.CoverageEligibilityRequest.SupportingInformationComponent t : src.getSupportingInfo())
      tgt.addSupportingInfo(convertSupportingInformationComponent(t));
    for (org.hl7.fhir.r5.model.CoverageEligibilityRequest.InsuranceComponent t : src.getInsurance())
      tgt.addInsurance(convertInsuranceComponent(t));
    for (org.hl7.fhir.r5.model.CoverageEligibilityRequest.DetailsComponent t : src.getItem())
      tgt.addItem(convertDetailsComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.FinancialResourceStatusCodes> convertEligibilityRequestStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CoverageEligibilityRequest.EligibilityRequestStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.FinancialResourceStatusCodes> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.FinancialResourceStatusCodesEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FinancialResourceStatusCodes.ACTIVE);
        break;
      case CANCELLED:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FinancialResourceStatusCodes.CANCELLED);
        break;
      case DRAFT:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FinancialResourceStatusCodes.DRAFT);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FinancialResourceStatusCodes.ENTEREDINERROR);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.FinancialResourceStatusCodes.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CoverageEligibilityRequest.EligibilityRequestStatus> convertEligibilityRequestStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.FinancialResourceStatusCodes> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CoverageEligibilityRequest.EligibilityRequestStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.CoverageEligibilityRequest.EligibilityRequestStatusEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.r4.model.CoverageEligibilityRequest.EligibilityRequestStatus.ACTIVE);
        break;
      case CANCELLED:
        tgt.setValue(org.hl7.fhir.r4.model.CoverageEligibilityRequest.EligibilityRequestStatus.CANCELLED);
        break;
      case DRAFT:
        tgt.setValue(org.hl7.fhir.r4.model.CoverageEligibilityRequest.EligibilityRequestStatus.DRAFT);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r4.model.CoverageEligibilityRequest.EligibilityRequestStatus.ENTEREDINERROR);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.CoverageEligibilityRequest.EligibilityRequestStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CoverageEligibilityRequest.EligibilityRequestPurpose> convertEligibilityRequestPurpose(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CoverageEligibilityRequest.EligibilityRequestPurpose> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CoverageEligibilityRequest.EligibilityRequestPurpose> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.CoverageEligibilityRequest.EligibilityRequestPurposeEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case AUTHREQUIREMENTS:
        tgt.setValue(org.hl7.fhir.r5.model.CoverageEligibilityRequest.EligibilityRequestPurpose.AUTHREQUIREMENTS);
        break;
      case BENEFITS:
        tgt.setValue(org.hl7.fhir.r5.model.CoverageEligibilityRequest.EligibilityRequestPurpose.BENEFITS);
        break;
      case DISCOVERY:
        tgt.setValue(org.hl7.fhir.r5.model.CoverageEligibilityRequest.EligibilityRequestPurpose.DISCOVERY);
        break;
      case VALIDATION:
        tgt.setValue(org.hl7.fhir.r5.model.CoverageEligibilityRequest.EligibilityRequestPurpose.VALIDATION);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.CoverageEligibilityRequest.EligibilityRequestPurpose.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CoverageEligibilityRequest.EligibilityRequestPurpose> convertEligibilityRequestPurpose(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CoverageEligibilityRequest.EligibilityRequestPurpose> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CoverageEligibilityRequest.EligibilityRequestPurpose> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.CoverageEligibilityRequest.EligibilityRequestPurposeEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case AUTHREQUIREMENTS:
        tgt.setValue(org.hl7.fhir.r4.model.CoverageEligibilityRequest.EligibilityRequestPurpose.AUTHREQUIREMENTS);
        break;
      case BENEFITS:
        tgt.setValue(org.hl7.fhir.r4.model.CoverageEligibilityRequest.EligibilityRequestPurpose.BENEFITS);
        break;
      case DISCOVERY:
        tgt.setValue(org.hl7.fhir.r4.model.CoverageEligibilityRequest.EligibilityRequestPurpose.DISCOVERY);
        break;
      case VALIDATION:
        tgt.setValue(org.hl7.fhir.r4.model.CoverageEligibilityRequest.EligibilityRequestPurpose.VALIDATION);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.CoverageEligibilityRequest.EligibilityRequestPurpose.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.CoverageEligibilityRequest.SupportingInformationComponent convertSupportingInformationComponent(org.hl7.fhir.r4.model.CoverageEligibilityRequest.SupportingInformationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.CoverageEligibilityRequest.SupportingInformationComponent tgt = new org.hl7.fhir.r5.model.CoverageEligibilityRequest.SupportingInformationComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(PositiveInt40_50.convertPositiveInt(src.getSequenceElement()));
    if (src.hasInformation())
      tgt.setInformation(Reference40_50.convertReference(src.getInformation()));
    if (src.hasAppliesToAll())
      tgt.setAppliesToAllElement(Boolean40_50.convertBoolean(src.getAppliesToAllElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CoverageEligibilityRequest.SupportingInformationComponent convertSupportingInformationComponent(org.hl7.fhir.r5.model.CoverageEligibilityRequest.SupportingInformationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.CoverageEligibilityRequest.SupportingInformationComponent tgt = new org.hl7.fhir.r4.model.CoverageEligibilityRequest.SupportingInformationComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(PositiveInt40_50.convertPositiveInt(src.getSequenceElement()));
    if (src.hasInformation())
      tgt.setInformation(Reference40_50.convertReference(src.getInformation()));
    if (src.hasAppliesToAll())
      tgt.setAppliesToAllElement(Boolean40_50.convertBoolean(src.getAppliesToAllElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.CoverageEligibilityRequest.InsuranceComponent convertInsuranceComponent(org.hl7.fhir.r4.model.CoverageEligibilityRequest.InsuranceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.CoverageEligibilityRequest.InsuranceComponent tgt = new org.hl7.fhir.r5.model.CoverageEligibilityRequest.InsuranceComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasFocal())
      tgt.setFocalElement(Boolean40_50.convertBoolean(src.getFocalElement()));
    if (src.hasCoverage())
      tgt.setCoverage(Reference40_50.convertReference(src.getCoverage()));
    if (src.hasBusinessArrangement())
      tgt.setBusinessArrangementElement(String40_50.convertString(src.getBusinessArrangementElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CoverageEligibilityRequest.InsuranceComponent convertInsuranceComponent(org.hl7.fhir.r5.model.CoverageEligibilityRequest.InsuranceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.CoverageEligibilityRequest.InsuranceComponent tgt = new org.hl7.fhir.r4.model.CoverageEligibilityRequest.InsuranceComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasFocal())
      tgt.setFocalElement(Boolean40_50.convertBoolean(src.getFocalElement()));
    if (src.hasCoverage())
      tgt.setCoverage(Reference40_50.convertReference(src.getCoverage()));
    if (src.hasBusinessArrangement())
      tgt.setBusinessArrangementElement(String40_50.convertString(src.getBusinessArrangementElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.CoverageEligibilityRequest.DetailsComponent convertDetailsComponent(org.hl7.fhir.r4.model.CoverageEligibilityRequest.DetailsComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.CoverageEligibilityRequest.DetailsComponent tgt = new org.hl7.fhir.r5.model.CoverageEligibilityRequest.DetailsComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    for (org.hl7.fhir.r4.model.PositiveIntType t : src.getSupportingInfoSequence())
      tgt.getSupportingInfoSequence().add(PositiveInt40_50.convertPositiveInt(t));
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept40_50.convertCodeableConcept(src.getCategory()));
    if (src.hasProductOrService())
      tgt.setProductOrService(CodeableConcept40_50.convertCodeableConcept(src.getProductOrService()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getModifier())
      tgt.addModifier(CodeableConcept40_50.convertCodeableConcept(t));
    if (src.hasProvider())
      tgt.setProvider(Reference40_50.convertReference(src.getProvider()));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity40_50.convertSimpleQuantity(src.getQuantity()));
    if (src.hasUnitPrice())
      tgt.setUnitPrice(Money40_50.convertMoney(src.getUnitPrice()));
    if (src.hasFacility())
      tgt.setFacility(Reference40_50.convertReference(src.getFacility()));
    for (org.hl7.fhir.r4.model.CoverageEligibilityRequest.DiagnosisComponent t : src.getDiagnosis())
      tgt.addDiagnosis(convertDiagnosisComponent(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getDetail()) tgt.addDetail(Reference40_50.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CoverageEligibilityRequest.DetailsComponent convertDetailsComponent(org.hl7.fhir.r5.model.CoverageEligibilityRequest.DetailsComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.CoverageEligibilityRequest.DetailsComponent tgt = new org.hl7.fhir.r4.model.CoverageEligibilityRequest.DetailsComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    for (org.hl7.fhir.r5.model.PositiveIntType t : src.getSupportingInfoSequence())
      tgt.getSupportingInfoSequence().add(PositiveInt40_50.convertPositiveInt(t));
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept40_50.convertCodeableConcept(src.getCategory()));
    if (src.hasProductOrService())
      tgt.setProductOrService(CodeableConcept40_50.convertCodeableConcept(src.getProductOrService()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getModifier())
      tgt.addModifier(CodeableConcept40_50.convertCodeableConcept(t));
    if (src.hasProvider())
      tgt.setProvider(Reference40_50.convertReference(src.getProvider()));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity40_50.convertSimpleQuantity(src.getQuantity()));
    if (src.hasUnitPrice())
      tgt.setUnitPrice(Money40_50.convertMoney(src.getUnitPrice()));
    if (src.hasFacility())
      tgt.setFacility(Reference40_50.convertReference(src.getFacility()));
    for (org.hl7.fhir.r5.model.CoverageEligibilityRequest.DiagnosisComponent t : src.getDiagnosis())
      tgt.addDiagnosis(convertDiagnosisComponent(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getDetail()) tgt.addDetail(Reference40_50.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.CoverageEligibilityRequest.DiagnosisComponent convertDiagnosisComponent(org.hl7.fhir.r4.model.CoverageEligibilityRequest.DiagnosisComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.CoverageEligibilityRequest.DiagnosisComponent tgt = new org.hl7.fhir.r5.model.CoverageEligibilityRequest.DiagnosisComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasDiagnosis())
      tgt.setDiagnosis(VersionConvertorFactory_40_50.convertType(src.getDiagnosis()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CoverageEligibilityRequest.DiagnosisComponent convertDiagnosisComponent(org.hl7.fhir.r5.model.CoverageEligibilityRequest.DiagnosisComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.CoverageEligibilityRequest.DiagnosisComponent tgt = new org.hl7.fhir.r4.model.CoverageEligibilityRequest.DiagnosisComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasDiagnosis())
      tgt.setDiagnosis(VersionConvertorFactory_40_50.convertType(src.getDiagnosis()));
    return tgt;
  }
}