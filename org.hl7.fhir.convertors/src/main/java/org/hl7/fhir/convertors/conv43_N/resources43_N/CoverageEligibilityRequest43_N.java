package org.hl7.fhir.convertors.conv43_N.resources43_N;

import java.util.stream.Collectors;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.CodeableConcept43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Identifier43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Money43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.SimpleQuantity43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Boolean43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.DateTime43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.PositiveInt43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.String43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.special43_N.Reference43_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4b.model.CoverageEligibilityRequest;
import org.hl7.fhir.model.core.Enumeration;
import org.hl7.fhir.model.core.Enumerations;

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

public class CoverageEligibilityRequest43_N {

  public static org.hl7.fhir.model.core.CoverageEligibilityRequest convertCoverageEligibilityRequest(org.hl7.fhir.r4b.model.CoverageEligibilityRequest src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.CoverageEligibilityRequest tgt = new org.hl7.fhir.model.core.CoverageEligibilityRequest();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertEligibilityRequestStatus(src.getStatusElement()));
    if (src.hasPriority())
      tgt.setPriority(CodeableConcept43_N.convertCodeableConcept(src.getPriority()));
    tgt.setPurposeList(src.getPurpose().stream()
      .map(CoverageEligibilityRequest43_N::convertEligibilityRequestPurpose)
      .collect(Collectors.toList()));
    if (src.hasPatient())
      tgt.setPatient(Reference43_N.convertReference(src.getPatient()));
    if (src.hasServiced())
      tgt.setServiced(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getServiced()));
    if (src.hasCreated())
      tgt.setCreatedElement(DateTime43_N.convertDateTime(src.getCreatedElement()));
    if (src.hasEnterer())
      tgt.setEnterer(Reference43_N.convertReference(src.getEnterer()));
    if (src.hasProvider())
      tgt.setProvider(Reference43_N.convertReference(src.getProvider()));
    if (src.hasInsurer())
      tgt.setInsurer(Reference43_N.convertReference(src.getInsurer()));
    if (src.hasFacility())
      tgt.setFacility(Reference43_N.convertReference(src.getFacility()));
    for (org.hl7.fhir.r4b.model.CoverageEligibilityRequest.SupportingInformationComponent t : src.getSupportingInfo())
      tgt.addSupportingInfo(convertSupportingInformationComponent(t));
    for (org.hl7.fhir.r4b.model.CoverageEligibilityRequest.InsuranceComponent t : src.getInsurance())
      tgt.addInsurance(convertInsuranceComponent(t));
    for (org.hl7.fhir.r4b.model.CoverageEligibilityRequest.DetailsComponent t : src.getItem())
      tgt.addItem(convertDetailsComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.CoverageEligibilityRequest convertCoverageEligibilityRequest(org.hl7.fhir.model.core.CoverageEligibilityRequest src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.CoverageEligibilityRequest tgt = new org.hl7.fhir.r4b.model.CoverageEligibilityRequest();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertEligibilityRequestStatus(src.getStatusElement()));
    if (src.hasPriority())
      tgt.setPriority(CodeableConcept43_N.convertCodeableConcept(src.getPriority()));
    tgt.setPurpose(src.getPurposeList().stream()
      .map(CoverageEligibilityRequest43_N::convertEligibilityRequestPurpose)
      .collect(Collectors.toList()));
    if (src.hasPatient())
      tgt.setPatient(Reference43_N.convertReference(src.getPatient()));
    if (src.hasServiced())
      tgt.setServiced(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getServiced()));
    if (src.hasCreated())
      tgt.setCreatedElement(DateTime43_N.convertDateTime(src.getCreatedElement()));
    if (src.hasEnterer())
      tgt.setEnterer(Reference43_N.convertReference(src.getEnterer()));
    if (src.hasProvider())
      tgt.setProvider(Reference43_N.convertReference(src.getProvider()));
    if (src.hasInsurer())
      tgt.setInsurer(Reference43_N.convertReference(src.getInsurer()));
    if (src.hasFacility())
      tgt.setFacility(Reference43_N.convertReference(src.getFacility()));
    for (org.hl7.fhir.model.core.CoverageEligibilityRequest.SupportingInformationComponent t : src.getSupportingInfoList())
      tgt.addSupportingInfo(convertSupportingInformationComponent(t));
    for (org.hl7.fhir.model.core.CoverageEligibilityRequest.InsuranceComponent t : src.getInsuranceList())
      tgt.addInsurance(convertInsuranceComponent(t));
    for (org.hl7.fhir.model.core.CoverageEligibilityRequest.DetailsComponent t : src.getItemList())
      tgt.addItem(convertDetailsComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.FinancialResourceStatusCodes> convertEligibilityRequestStatus(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.FinancialResourceStatusCodes> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Enumerations.FinancialResourceStatusCodes> tgt = new Enumeration<>(new Enumerations.FinancialResourceStatusCodesEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case ACTIVE:
                  tgt.setValue(Enumerations.FinancialResourceStatusCodes.ACTIVE);
                  break;
              case CANCELLED:
                  tgt.setValue(Enumerations.FinancialResourceStatusCodes.CANCELLED);
                  break;
              case DRAFT:
                  tgt.setValue(Enumerations.FinancialResourceStatusCodes.DRAFT);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(Enumerations.FinancialResourceStatusCodes.ENTEREDINERROR);
                  break;
              default:
                  tgt.setValue(Enumerations.FinancialResourceStatusCodes.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.FinancialResourceStatusCodes> convertEligibilityRequestStatus(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.FinancialResourceStatusCodes> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.FinancialResourceStatusCodes> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.FinancialResourceStatusCodesEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
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
      }
      return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.CoverageEligibilityRequest.EligibilityRequestPurpose> convertEligibilityRequestPurpose(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.CoverageEligibilityRequest.EligibilityRequestPurpose> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<org.hl7.fhir.model.core.CoverageEligibilityRequest.EligibilityRequestPurpose> tgt = new Enumeration<>(new org.hl7.fhir.model.core.CoverageEligibilityRequest.EligibilityRequestPurposeEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case AUTHREQUIREMENTS:
                  tgt.setValue(org.hl7.fhir.model.core.CoverageEligibilityRequest.EligibilityRequestPurpose.AUTHREQUIREMENTS);
                  break;
              case BENEFITS:
                  tgt.setValue(org.hl7.fhir.model.core.CoverageEligibilityRequest.EligibilityRequestPurpose.BENEFITS);
                  break;
              case DISCOVERY:
                  tgt.setValue(org.hl7.fhir.model.core.CoverageEligibilityRequest.EligibilityRequestPurpose.DISCOVERY);
                  break;
              case VALIDATION:
                  tgt.setValue(org.hl7.fhir.model.core.CoverageEligibilityRequest.EligibilityRequestPurpose.VALIDATION);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.model.core.CoverageEligibilityRequest.EligibilityRequestPurpose.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.CoverageEligibilityRequest.EligibilityRequestPurpose> convertEligibilityRequestPurpose(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.CoverageEligibilityRequest.EligibilityRequestPurpose> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<CoverageEligibilityRequest.EligibilityRequestPurpose> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new CoverageEligibilityRequest.EligibilityRequestPurposeEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case AUTHREQUIREMENTS:
                  tgt.setValue(CoverageEligibilityRequest.EligibilityRequestPurpose.AUTHREQUIREMENTS);
                  break;
              case BENEFITS:
                  tgt.setValue(CoverageEligibilityRequest.EligibilityRequestPurpose.BENEFITS);
                  break;
              case DISCOVERY:
                  tgt.setValue(CoverageEligibilityRequest.EligibilityRequestPurpose.DISCOVERY);
                  break;
              case VALIDATION:
                  tgt.setValue(CoverageEligibilityRequest.EligibilityRequestPurpose.VALIDATION);
                  break;
              default:
                  tgt.setValue(CoverageEligibilityRequest.EligibilityRequestPurpose.NULL);
                  break;
          }
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.CoverageEligibilityRequest.SupportingInformationComponent convertSupportingInformationComponent(org.hl7.fhir.r4b.model.CoverageEligibilityRequest.SupportingInformationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.CoverageEligibilityRequest.SupportingInformationComponent tgt = new org.hl7.fhir.model.core.CoverageEligibilityRequest.SupportingInformationComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(PositiveInt43_N.convertPositiveInt(src.getSequenceElement()));
    if (src.hasInformation())
      tgt.setInformation(Reference43_N.convertReference(src.getInformation()));
    if (src.hasAppliesToAll())
      tgt.setAppliesToAllElement(Boolean43_N.convertBoolean(src.getAppliesToAllElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.CoverageEligibilityRequest.SupportingInformationComponent convertSupportingInformationComponent(org.hl7.fhir.model.core.CoverageEligibilityRequest.SupportingInformationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.CoverageEligibilityRequest.SupportingInformationComponent tgt = new org.hl7.fhir.r4b.model.CoverageEligibilityRequest.SupportingInformationComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasSequence())
      tgt.setSequenceElement(PositiveInt43_N.convertPositiveInt(src.getSequenceElement()));
    if (src.hasInformation())
      tgt.setInformation(Reference43_N.convertReference(src.getInformation()));
    if (src.hasAppliesToAll())
      tgt.setAppliesToAllElement(Boolean43_N.convertBoolean(src.getAppliesToAllElement()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.CoverageEligibilityRequest.InsuranceComponent convertInsuranceComponent(org.hl7.fhir.r4b.model.CoverageEligibilityRequest.InsuranceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.CoverageEligibilityRequest.InsuranceComponent tgt = new org.hl7.fhir.model.core.CoverageEligibilityRequest.InsuranceComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasFocal())
      tgt.setFocalElement(Boolean43_N.convertBoolean(src.getFocalElement()));
    if (src.hasCoverage())
      tgt.setCoverage(Reference43_N.convertReference(src.getCoverage()));
    if (src.hasBusinessArrangement())
      tgt.setBusinessArrangementElement(String43_N.convertString(src.getBusinessArrangementElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.CoverageEligibilityRequest.InsuranceComponent convertInsuranceComponent(org.hl7.fhir.model.core.CoverageEligibilityRequest.InsuranceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.CoverageEligibilityRequest.InsuranceComponent tgt = new org.hl7.fhir.r4b.model.CoverageEligibilityRequest.InsuranceComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasFocal())
      tgt.setFocalElement(Boolean43_N.convertBoolean(src.getFocalElement()));
    if (src.hasCoverage())
      tgt.setCoverage(Reference43_N.convertReference(src.getCoverage()));
    if (src.hasBusinessArrangement())
      tgt.setBusinessArrangementElement(String43_N.convertString(src.getBusinessArrangementElement()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.CoverageEligibilityRequest.DetailsComponent convertDetailsComponent(org.hl7.fhir.r4b.model.CoverageEligibilityRequest.DetailsComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.CoverageEligibilityRequest.DetailsComponent tgt = new org.hl7.fhir.model.core.CoverageEligibilityRequest.DetailsComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r4b.model.PositiveIntType t : src.getSupportingInfoSequence())
      tgt.getSupportingInfoSequenceList().add(PositiveInt43_N.convertPositiveInt(t));
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept43_N.convertCodeableConcept(src.getCategory()));
    if (src.hasProductOrService())
      tgt.setProductOrService(CodeableConcept43_N.convertCodeableConcept(src.getProductOrService()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getModifier())
      tgt.addModifier(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasProvider())
      tgt.setProvider(Reference43_N.convertReference(src.getProvider()));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity43_N.convertSimpleQuantity(src.getQuantity()));
    if (src.hasUnitPrice())
      tgt.setUnitPrice(Money43_N.convertMoney(src.getUnitPrice()));
    if (src.hasFacility())
      tgt.setFacility(Reference43_N.convertReference(src.getFacility()));
    for (org.hl7.fhir.r4b.model.CoverageEligibilityRequest.DiagnosisComponent t : src.getDiagnosis())
      tgt.addDiagnosis(convertDiagnosisComponent(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getDetail()) tgt.addDetail(Reference43_N.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.CoverageEligibilityRequest.DetailsComponent convertDetailsComponent(org.hl7.fhir.model.core.CoverageEligibilityRequest.DetailsComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.CoverageEligibilityRequest.DetailsComponent tgt = new org.hl7.fhir.r4b.model.CoverageEligibilityRequest.DetailsComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.model.core.PositiveIntType t : src.getSupportingInfoSequenceList())
      tgt.getSupportingInfoSequence().add(PositiveInt43_N.convertPositiveInt(t));
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept43_N.convertCodeableConcept(src.getCategory()));
    if (src.hasProductOrService())
      tgt.setProductOrService(CodeableConcept43_N.convertCodeableConcept(src.getProductOrService()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getModifierList())
      tgt.addModifier(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasProvider())
      tgt.setProvider(Reference43_N.convertReference(src.getProvider()));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity43_N.convertSimpleQuantity(src.getQuantity()));
    if (src.hasUnitPrice())
      tgt.setUnitPrice(Money43_N.convertMoney(src.getUnitPrice()));
    if (src.hasFacility())
      tgt.setFacility(Reference43_N.convertReference(src.getFacility()));
    for (org.hl7.fhir.model.core.CoverageEligibilityRequest.DiagnosisComponent t : src.getDiagnosisList())
      tgt.addDiagnosis(convertDiagnosisComponent(t));
    for (org.hl7.fhir.model.core.Reference t : src.getDetailList()) tgt.addDetail(Reference43_N.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.CoverageEligibilityRequest.DiagnosisComponent convertDiagnosisComponent(org.hl7.fhir.r4b.model.CoverageEligibilityRequest.DiagnosisComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.CoverageEligibilityRequest.DiagnosisComponent tgt = new org.hl7.fhir.model.core.CoverageEligibilityRequest.DiagnosisComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasDiagnosisCodeableConcept())
      tgt.getDiagnosis().setConcept(CodeableConcept43_N.convertCodeableConcept(src.getDiagnosisCodeableConcept()));
    if (src.hasDiagnosisCodeableConcept())
      tgt.getDiagnosis().setReference(Reference43_N.convertReference(src.getDiagnosisReference()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.CoverageEligibilityRequest.DiagnosisComponent convertDiagnosisComponent(org.hl7.fhir.model.core.CoverageEligibilityRequest.DiagnosisComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.CoverageEligibilityRequest.DiagnosisComponent tgt = new org.hl7.fhir.r4b.model.CoverageEligibilityRequest.DiagnosisComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasDiagnosis())
      tgt.setDiagnosis(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getDiagnosis()));
    return tgt;
  }
}