package org.hl7.fhir.convertors.conv43_50.resources43_50;

import java.util.stream.Collectors;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.CodeableConcept43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Identifier43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Money43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.SimpleQuantity43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Boolean43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.DateTime43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.PositiveInt43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.String43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.special43_50.Reference43_50;
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
public class CoverageEligibilityRequest43_50 {

  public static org.hl7.fhir.r5.model.CoverageEligibilityRequest convertCoverageEligibilityRequest(org.hl7.fhir.r4b.model.CoverageEligibilityRequest src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.CoverageEligibilityRequest tgt = new org.hl7.fhir.r5.model.CoverageEligibilityRequest();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertEligibilityRequestStatus(src.getStatusElement()));
    if (src.hasPriority())
      tgt.setPriority(CodeableConcept43_50.convertCodeableConcept(src.getPriority()));
    tgt.setPurpose(src.getPurpose().stream()
      .map(CoverageEligibilityRequest43_50::convertEligibilityRequestPurpose)
      .collect(Collectors.toList()));
    if (src.hasPatient())
      tgt.setPatient(Reference43_50.convertReference(src.getPatient()));
    if (src.hasServiced())
      tgt.setServiced(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getServiced()));
    if (src.hasCreated())
      tgt.setCreatedElement(DateTime43_50.convertDateTime(src.getCreatedElement()));
    if (src.hasEnterer())
      tgt.setEnterer(Reference43_50.convertReference(src.getEnterer()));
    if (src.hasProvider())
      tgt.setProvider(Reference43_50.convertReference(src.getProvider()));
    if (src.hasInsurer())
      tgt.setInsurer(Reference43_50.convertReference(src.getInsurer()));
    if (src.hasFacility())
      tgt.setFacility(Reference43_50.convertReference(src.getFacility()));
    for (org.hl7.fhir.r4b.model.CoverageEligibilityRequest.SupportingInformationComponent t : src.getSupportingInfo())
      tgt.addSupportingInfo(convertSupportingInformationComponent(t));
    for (org.hl7.fhir.r4b.model.CoverageEligibilityRequest.InsuranceComponent t : src.getInsurance())
      tgt.addInsurance(convertInsuranceComponent(t));
    for (org.hl7.fhir.r4b.model.CoverageEligibilityRequest.DetailsComponent t : src.getItem())
      tgt.addItem(convertDetailsComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.CoverageEligibilityRequest convertCoverageEligibilityRequest(org.hl7.fhir.r5.model.CoverageEligibilityRequest src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.CoverageEligibilityRequest tgt = new org.hl7.fhir.r4b.model.CoverageEligibilityRequest();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertEligibilityRequestStatus(src.getStatusElement()));
    if (src.hasPriority())
      tgt.setPriority(CodeableConcept43_50.convertCodeableConcept(src.getPriority()));
    tgt.setPurpose(src.getPurpose().stream()
      .map(CoverageEligibilityRequest43_50::convertEligibilityRequestPurpose)
      .collect(Collectors.toList()));
    if (src.hasPatient())
      tgt.setPatient(Reference43_50.convertReference(src.getPatient()));
    if (src.hasServiced())
      tgt.setServiced(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getServiced()));
    if (src.hasCreated())
      tgt.setCreatedElement(DateTime43_50.convertDateTime(src.getCreatedElement()));
    if (src.hasEnterer())
      tgt.setEnterer(Reference43_50.convertReference(src.getEnterer()));
    if (src.hasProvider())
      tgt.setProvider(Reference43_50.convertReference(src.getProvider()));
    if (src.hasInsurer())
      tgt.setInsurer(Reference43_50.convertReference(src.getInsurer()));
    if (src.hasFacility())
      tgt.setFacility(Reference43_50.convertReference(src.getFacility()));
    for (org.hl7.fhir.r5.model.CoverageEligibilityRequest.SupportingInformationComponent t : src.getSupportingInfo())
      tgt.addSupportingInfo(convertSupportingInformationComponent(t));
    for (org.hl7.fhir.r5.model.CoverageEligibilityRequest.InsuranceComponent t : src.getInsurance())
      tgt.addInsurance(convertInsuranceComponent(t));
    for (org.hl7.fhir.r5.model.CoverageEligibilityRequest.DetailsComponent t : src.getItem())
      tgt.addItem(convertDetailsComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.FinancialResourceStatusCodes> convertEligibilityRequestStatus(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.FinancialResourceStatusCodes> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.FinancialResourceStatusCodes> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.FinancialResourceStatusCodesEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.FinancialResourceStatusCodes> convertEligibilityRequestStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.FinancialResourceStatusCodes> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.FinancialResourceStatusCodes> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.FinancialResourceStatusCodesEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.FinancialResourceStatusCodes.ACTIVE);
        break;
      case CANCELLED:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.FinancialResourceStatusCodes.CANCELLED);
        break;
      case DRAFT:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.FinancialResourceStatusCodes.DRAFT);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.FinancialResourceStatusCodes.ENTEREDINERROR);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.FinancialResourceStatusCodes.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CoverageEligibilityRequest.EligibilityRequestPurpose> convertEligibilityRequestPurpose(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.CoverageEligibilityRequest.EligibilityRequestPurpose> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CoverageEligibilityRequest.EligibilityRequestPurpose> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.CoverageEligibilityRequest.EligibilityRequestPurposeEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.CoverageEligibilityRequest.EligibilityRequestPurpose> convertEligibilityRequestPurpose(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CoverageEligibilityRequest.EligibilityRequestPurpose> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.CoverageEligibilityRequest.EligibilityRequestPurpose> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.CoverageEligibilityRequest.EligibilityRequestPurposeEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case AUTHREQUIREMENTS:
        tgt.setValue(org.hl7.fhir.r4b.model.CoverageEligibilityRequest.EligibilityRequestPurpose.AUTHREQUIREMENTS);
        break;
      case BENEFITS:
        tgt.setValue(org.hl7.fhir.r4b.model.CoverageEligibilityRequest.EligibilityRequestPurpose.BENEFITS);
        break;
      case DISCOVERY:
        tgt.setValue(org.hl7.fhir.r4b.model.CoverageEligibilityRequest.EligibilityRequestPurpose.DISCOVERY);
        break;
      case VALIDATION:
        tgt.setValue(org.hl7.fhir.r4b.model.CoverageEligibilityRequest.EligibilityRequestPurpose.VALIDATION);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.CoverageEligibilityRequest.EligibilityRequestPurpose.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.CoverageEligibilityRequest.SupportingInformationComponent convertSupportingInformationComponent(org.hl7.fhir.r4b.model.CoverageEligibilityRequest.SupportingInformationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.CoverageEligibilityRequest.SupportingInformationComponent tgt = new org.hl7.fhir.r5.model.CoverageEligibilityRequest.SupportingInformationComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(PositiveInt43_50.convertPositiveInt(src.getSequenceElement()));
    if (src.hasInformation())
      tgt.setInformation(Reference43_50.convertReference(src.getInformation()));
    if (src.hasAppliesToAll())
      tgt.setAppliesToAllElement(Boolean43_50.convertBoolean(src.getAppliesToAllElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.CoverageEligibilityRequest.SupportingInformationComponent convertSupportingInformationComponent(org.hl7.fhir.r5.model.CoverageEligibilityRequest.SupportingInformationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.CoverageEligibilityRequest.SupportingInformationComponent tgt = new org.hl7.fhir.r4b.model.CoverageEligibilityRequest.SupportingInformationComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(PositiveInt43_50.convertPositiveInt(src.getSequenceElement()));
    if (src.hasInformation())
      tgt.setInformation(Reference43_50.convertReference(src.getInformation()));
    if (src.hasAppliesToAll())
      tgt.setAppliesToAllElement(Boolean43_50.convertBoolean(src.getAppliesToAllElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.CoverageEligibilityRequest.InsuranceComponent convertInsuranceComponent(org.hl7.fhir.r4b.model.CoverageEligibilityRequest.InsuranceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.CoverageEligibilityRequest.InsuranceComponent tgt = new org.hl7.fhir.r5.model.CoverageEligibilityRequest.InsuranceComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasFocal())
      tgt.setFocalElement(Boolean43_50.convertBoolean(src.getFocalElement()));
    if (src.hasCoverage())
      tgt.setCoverage(Reference43_50.convertReference(src.getCoverage()));
    if (src.hasBusinessArrangement())
      tgt.setBusinessArrangementElement(String43_50.convertString(src.getBusinessArrangementElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.CoverageEligibilityRequest.InsuranceComponent convertInsuranceComponent(org.hl7.fhir.r5.model.CoverageEligibilityRequest.InsuranceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.CoverageEligibilityRequest.InsuranceComponent tgt = new org.hl7.fhir.r4b.model.CoverageEligibilityRequest.InsuranceComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasFocal())
      tgt.setFocalElement(Boolean43_50.convertBoolean(src.getFocalElement()));
    if (src.hasCoverage())
      tgt.setCoverage(Reference43_50.convertReference(src.getCoverage()));
    if (src.hasBusinessArrangement())
      tgt.setBusinessArrangementElement(String43_50.convertString(src.getBusinessArrangementElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.CoverageEligibilityRequest.DetailsComponent convertDetailsComponent(org.hl7.fhir.r4b.model.CoverageEligibilityRequest.DetailsComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.CoverageEligibilityRequest.DetailsComponent tgt = new org.hl7.fhir.r5.model.CoverageEligibilityRequest.DetailsComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r4b.model.PositiveIntType t : src.getSupportingInfoSequence())
      tgt.getSupportingInfoSequence().add(PositiveInt43_50.convertPositiveInt(t));
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept43_50.convertCodeableConcept(src.getCategory()));
    if (src.hasProductOrService())
      tgt.setProductOrService(CodeableConcept43_50.convertCodeableConcept(src.getProductOrService()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getModifier())
      tgt.addModifier(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasProvider())
      tgt.setProvider(Reference43_50.convertReference(src.getProvider()));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity43_50.convertSimpleQuantity(src.getQuantity()));
    if (src.hasUnitPrice())
      tgt.setUnitPrice(Money43_50.convertMoney(src.getUnitPrice()));
    if (src.hasFacility())
      tgt.setFacility(Reference43_50.convertReference(src.getFacility()));
    for (org.hl7.fhir.r4b.model.CoverageEligibilityRequest.DiagnosisComponent t : src.getDiagnosis())
      tgt.addDiagnosis(convertDiagnosisComponent(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getDetail()) tgt.addDetail(Reference43_50.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.CoverageEligibilityRequest.DetailsComponent convertDetailsComponent(org.hl7.fhir.r5.model.CoverageEligibilityRequest.DetailsComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.CoverageEligibilityRequest.DetailsComponent tgt = new org.hl7.fhir.r4b.model.CoverageEligibilityRequest.DetailsComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r5.model.PositiveIntType t : src.getSupportingInfoSequence())
      tgt.getSupportingInfoSequence().add(PositiveInt43_50.convertPositiveInt(t));
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept43_50.convertCodeableConcept(src.getCategory()));
    if (src.hasProductOrService())
      tgt.setProductOrService(CodeableConcept43_50.convertCodeableConcept(src.getProductOrService()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getModifier())
      tgt.addModifier(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasProvider())
      tgt.setProvider(Reference43_50.convertReference(src.getProvider()));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity43_50.convertSimpleQuantity(src.getQuantity()));
    if (src.hasUnitPrice())
      tgt.setUnitPrice(Money43_50.convertMoney(src.getUnitPrice()));
    if (src.hasFacility())
      tgt.setFacility(Reference43_50.convertReference(src.getFacility()));
    for (org.hl7.fhir.r5.model.CoverageEligibilityRequest.DiagnosisComponent t : src.getDiagnosis())
      tgt.addDiagnosis(convertDiagnosisComponent(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getDetail()) tgt.addDetail(Reference43_50.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.CoverageEligibilityRequest.DiagnosisComponent convertDiagnosisComponent(org.hl7.fhir.r4b.model.CoverageEligibilityRequest.DiagnosisComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.CoverageEligibilityRequest.DiagnosisComponent tgt = new org.hl7.fhir.r5.model.CoverageEligibilityRequest.DiagnosisComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasDiagnosis())
      tgt.setDiagnosis(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getDiagnosis()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.CoverageEligibilityRequest.DiagnosisComponent convertDiagnosisComponent(org.hl7.fhir.r5.model.CoverageEligibilityRequest.DiagnosisComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.CoverageEligibilityRequest.DiagnosisComponent tgt = new org.hl7.fhir.r4b.model.CoverageEligibilityRequest.DiagnosisComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasDiagnosis())
      tgt.setDiagnosis(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getDiagnosis()));
    return tgt;
  }
}