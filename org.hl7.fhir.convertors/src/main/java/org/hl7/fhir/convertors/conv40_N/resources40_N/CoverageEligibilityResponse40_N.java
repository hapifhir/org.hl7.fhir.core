package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.CrossVersionElements40_N;
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

public class CoverageEligibilityResponse40_N {

  // statusReason is new in R6 - carried in R5 as a cross-version extension
  public static final String STATUS_REASON_EXTENSION_URL = "http://hl7.org/fhir/6.0/StructureDefinition/extension-CoverageEligibilityResponse.statusReason";

  public static org.hl7.fhir.model.core.CoverageEligibilityResponse convertCoverageEligibilityResponse(org.hl7.fhir.r4.model.CoverageEligibilityResponse src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.CoverageEligibilityResponse tgt = new org.hl7.fhir.model.core.CoverageEligibilityResponse();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt, STATUS_REASON_EXTENSION_URL, CrossVersionElements40_N.url("CoverageEligibilityResponse", "5.0", "event"));
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.getIdentifierList().add(org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Identifier40_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(CrossVersionElements40_N.toR6Code(src.getStatusElement(), convertStatus(src.getStatusElement()), src.fhirType(), "status"));
    if (src.hasExtension(STATUS_REASON_EXTENSION_URL))
      tgt.setStatusReason(src.getExtensionByUrl(STATUS_REASON_EXTENSION_URL).getValue().primitiveValue());
    for (org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CoverageEligibilityResponse.EligibilityResponsePurpose> t : src.getPurpose())
      tgt.getPurposeList().add(convertEligibilityResponsePurpose(t));
    if (src.hasPatient())
      tgt.setPatient(org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Reference40_N.convertReference(src.getPatient()));
    // R4 has no event
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "5.0", "event");
    // the types R4 and R6 allow differ: a value of a type the other version doesn't allow is an extension
    CrossVersionElements40_N.choiceToR6(src, src.getExtension(), src.fhirType(), "serviced", tgt, tgt.getExtension());
    if (src.hasCreated())
      tgt.setCreatedElement(org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.DateTime40_N.convertDateTime(src.getCreatedElement()));
    if (src.hasRequestor())
      tgt.setRequestor(org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Reference40_N.convertReference(src.getRequestor()));
    if (src.hasRequest())
      tgt.setRequest(org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Reference40_N.convertReference(src.getRequest()));
    if (src.hasOutcome())
      tgt.setOutcomeElement(CrossVersionElements40_N.toR6Code(src.getOutcomeElement(), convertEligibilityOutcome(src.getOutcomeElement()), src.fhirType(), "outcome"));
    if (src.hasDisposition())
      tgt.setDispositionElement(org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.String40_N.convertString(src.getDispositionElement()));
    if (src.hasInsurer())
      tgt.setInsurer(org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Reference40_N.convertReference(src.getInsurer()));
    for (org.hl7.fhir.r4.model.CoverageEligibilityResponse.InsuranceComponent t : src.getInsurance())
      tgt.getInsuranceList().add(convertInsuranceComponent(t));
    if (src.hasPreAuthRef())
      tgt.setPreAuthRefElement(org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.String40_N.convertString(src.getPreAuthRefElement()));
    if (src.hasForm())
      tgt.setForm(org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N.convertCodeableConcept(src.getForm()));
    for (org.hl7.fhir.r4.model.CoverageEligibilityResponse.ErrorsComponent t : src.getError())
      tgt.getErrorList().add(convertErrorsComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CoverageEligibilityResponse convertCoverageEligibilityResponse(org.hl7.fhir.model.core.CoverageEligibilityResponse src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.CoverageEligibilityResponse tgt = new org.hl7.fhir.r4.model.CoverageEligibilityResponse();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.getIdentifier().add(org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Identifier40_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(CrossVersionElements40_N.toR4Code(src.getStatusElement(), convertStatus(src.getStatusElement()), src.fhirType(), "status"));
    if (src.hasStatusReason())
      tgt.addExtension(STATUS_REASON_EXTENSION_URL, org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.String40_N.convertString(src.getStatusReasonElement()));
    for (org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.CoverageEligibilityResponse.EligibilityResponsePurpose> t : src.getPurposeList())
      tgt.getPurpose().add(convertEligibilityResponsePurpose(t));
    if (src.hasPatient())
      tgt.setPatient(org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Reference40_N.convertReference(src.getPatient()));
    CrossVersionElements40_N.elementsToExtensions(src, tgt.getExtension(), "5.0", "event");
    CrossVersionElements40_N.choiceToR4(src, src.getExtension(), src.fhirType(), "serviced", tgt, tgt.getExtension());
    if (src.hasCreated())
      tgt.setCreatedElement(org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.DateTime40_N.convertDateTime(src.getCreatedElement()));
    if (src.hasRequestor())
      tgt.setRequestor(org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Reference40_N.convertReference(src.getRequestor()));
    if (src.hasRequest())
      tgt.setRequest(org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Reference40_N.convertReference(src.getRequest()));
    if (src.hasOutcome())
      tgt.setOutcomeElement(CrossVersionElements40_N.toR4Code(src.getOutcomeElement(), convertEligibilityOutcome(src.getOutcomeElement()), src.fhirType(), "outcome"));
    if (src.hasDisposition())
      tgt.setDispositionElement(org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.String40_N.convertString(src.getDispositionElement()));
    if (src.hasInsurer())
      tgt.setInsurer(org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Reference40_N.convertReference(src.getInsurer()));
    for (org.hl7.fhir.model.core.CoverageEligibilityResponse.InsuranceComponent t : src.getInsuranceList())
      tgt.getInsurance().add(convertInsuranceComponent(t));
    if (src.hasPreAuthRef())
      tgt.setPreAuthRefElement(org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.String40_N.convertString(src.getPreAuthRefElement()));
    if (src.hasForm())
      tgt.setForm(org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N.convertCodeableConcept(src.getForm()));
    for (org.hl7.fhir.model.core.CoverageEligibilityResponse.ErrorsComponent t : src.getErrorList())
      tgt.getError().add(convertErrorsComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.CoverageEligibilityResponse.InsuranceComponent convertInsuranceComponent(org.hl7.fhir.r4.model.CoverageEligibilityResponse.InsuranceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.CoverageEligibilityResponse.InsuranceComponent tgt = new org.hl7.fhir.model.core.CoverageEligibilityResponse.InsuranceComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasCoverage())
      tgt.setCoverage(org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Reference40_N.convertReference(src.getCoverage()));
    if (src.hasInforce())
      tgt.setInforceElement(org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Boolean40_N.convertBoolean(src.getInforceElement()));
    if (src.hasBenefitPeriod())
      tgt.setBenefitPeriod(org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Period40_N.convertPeriod(src.getBenefitPeriod()));
    for (org.hl7.fhir.r4.model.CoverageEligibilityResponse.ItemsComponent t : src.getItem())
      tgt.getItemList().add(convertItemsComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CoverageEligibilityResponse.InsuranceComponent convertInsuranceComponent(org.hl7.fhir.model.core.CoverageEligibilityResponse.InsuranceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.CoverageEligibilityResponse.InsuranceComponent tgt = new org.hl7.fhir.r4.model.CoverageEligibilityResponse.InsuranceComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasCoverage())
      tgt.setCoverage(org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Reference40_N.convertReference(src.getCoverage()));
    if (src.hasInforce())
      tgt.setInforceElement(org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Boolean40_N.convertBoolean(src.getInforceElement()));
    if (src.hasBenefitPeriod())
      tgt.setBenefitPeriod(org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Period40_N.convertPeriod(src.getBenefitPeriod()));
    for (org.hl7.fhir.model.core.CoverageEligibilityResponse.ItemsComponent t : src.getItemList())
      tgt.getItem().add(convertItemsComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.CoverageEligibilityResponse.ItemsComponent convertItemsComponent(org.hl7.fhir.r4.model.CoverageEligibilityResponse.ItemsComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.CoverageEligibilityResponse.ItemsComponent tgt = new org.hl7.fhir.model.core.CoverageEligibilityResponse.ItemsComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasCategory())
      tgt.setCategory(org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N.convertCodeableConcept(src.getCategory()));
    if (src.hasProductOrService())
      tgt.setProductOrService(org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N.convertCodeableConcept(src.getProductOrService()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getModifier())
      tgt.getModifierList().add(org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasProvider())
      tgt.setProvider(org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Reference40_N.convertReference(src.getProvider()));
    if (src.hasExcluded())
      tgt.setExcludedElement(org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Boolean40_N.convertBoolean(src.getExcludedElement()));
    if (src.hasName())
      tgt.setNameElement(org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.String40_N.convertString(src.getNameElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.String40_N.convertStringToMarkdown(src.getDescriptionElement()));
    if (src.hasNetwork())
      tgt.setNetwork(org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N.convertCodeableConcept(src.getNetwork()));
    if (src.hasUnit())
      tgt.setUnit(org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N.convertCodeableConcept(src.getUnit()));
    if (src.hasTerm())
      tgt.setTerm(org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N.convertCodeableConcept(src.getTerm()));
    for (org.hl7.fhir.r4.model.CoverageEligibilityResponse.BenefitComponent t : src.getBenefit())
      tgt.getBenefitList().add(convertBenefitComponent(t));
    if (src.hasAuthorizationRequired())
      tgt.setAuthorizationRequiredElement(org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Boolean40_N.convertBoolean(src.getAuthorizationRequiredElement()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getAuthorizationSupporting())
      tgt.getAuthorizationSupportingList().add(org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasAuthorizationUrl())
      tgt.setAuthorizationUrlElement(org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Uri40_N.convertUri(src.getAuthorizationUrlElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CoverageEligibilityResponse.ItemsComponent convertItemsComponent(org.hl7.fhir.model.core.CoverageEligibilityResponse.ItemsComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.CoverageEligibilityResponse.ItemsComponent tgt = new org.hl7.fhir.r4.model.CoverageEligibilityResponse.ItemsComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasCategory())
      tgt.setCategory(org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N.convertCodeableConcept(src.getCategory()));
    if (src.hasProductOrService())
      tgt.setProductOrService(org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N.convertCodeableConcept(src.getProductOrService()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getModifierList())
      tgt.getModifier().add(org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasProvider())
      tgt.setProvider(org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Reference40_N.convertReference(src.getProvider()));
    if (src.hasExcluded())
      tgt.setExcludedElement(org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Boolean40_N.convertBoolean(src.getExcludedElement()));
    if (src.hasName())
      tgt.setNameElement(org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.String40_N.convertString(src.getNameElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.String40_N.convertString(src.getDescriptionElement()));
    if (src.hasNetwork())
      tgt.setNetwork(org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N.convertCodeableConcept(src.getNetwork()));
    if (src.hasUnit())
      tgt.setUnit(org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N.convertCodeableConcept(src.getUnit()));
    if (src.hasTerm())
      tgt.setTerm(org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N.convertCodeableConcept(src.getTerm()));
    for (org.hl7.fhir.model.core.CoverageEligibilityResponse.BenefitComponent t : src.getBenefitList())
      tgt.getBenefit().add(convertBenefitComponent(t));
    if (src.hasAuthorizationRequired())
      tgt.setAuthorizationRequiredElement(org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Boolean40_N.convertBoolean(src.getAuthorizationRequiredElement()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getAuthorizationSupportingList())
      tgt.getAuthorizationSupporting().add(org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasAuthorizationUrl())
      tgt.setAuthorizationUrlElement(org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Uri40_N.convertUri(src.getAuthorizationUrlElement()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.CoverageEligibilityResponse.BenefitComponent convertBenefitComponent(org.hl7.fhir.r4.model.CoverageEligibilityResponse.BenefitComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.CoverageEligibilityResponse.BenefitComponent tgt = new org.hl7.fhir.model.core.CoverageEligibilityResponse.BenefitComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N.convertCodeableConcept(src.getType()));
    // the types R4 and R6 allow differ: a value of a type the other version doesn't allow is an extension
    CrossVersionElements40_N.choiceToR6(src, src.getExtension(), src.fhirType(), "allowed", tgt, tgt.getExtension());
    // the types R4 and R6 allow differ: a value of a type the other version doesn't allow is an extension
    CrossVersionElements40_N.choiceToR6(src, src.getExtension(), src.fhirType(), "used", tgt, tgt.getExtension());
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CoverageEligibilityResponse.BenefitComponent convertBenefitComponent(org.hl7.fhir.model.core.CoverageEligibilityResponse.BenefitComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.CoverageEligibilityResponse.BenefitComponent tgt = new org.hl7.fhir.r4.model.CoverageEligibilityResponse.BenefitComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N.convertCodeableConcept(src.getType()));
    CrossVersionElements40_N.choiceToR4(src, src.getExtension(), src.fhirType(), "allowed", tgt, tgt.getExtension());
    CrossVersionElements40_N.choiceToR4(src, src.getExtension(), src.fhirType(), "used", tgt, tgt.getExtension());
    return tgt;
  }

  public static org.hl7.fhir.model.core.CoverageEligibilityResponse.ErrorsComponent convertErrorsComponent(org.hl7.fhir.r4.model.CoverageEligibilityResponse.ErrorsComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.CoverageEligibilityResponse.ErrorsComponent tgt = new org.hl7.fhir.model.core.CoverageEligibilityResponse.ErrorsComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt, CrossVersionElements40_N.url("CoverageEligibilityResponse.error", "5.0", "expression"));
    if (src.hasCode())
      tgt.setCode(org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N.convertCodeableConcept(src.getCode()));
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "5.0", "expression");
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CoverageEligibilityResponse.ErrorsComponent convertErrorsComponent(org.hl7.fhir.model.core.CoverageEligibilityResponse.ErrorsComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.CoverageEligibilityResponse.ErrorsComponent tgt = new org.hl7.fhir.r4.model.CoverageEligibilityResponse.ErrorsComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N.convertCodeableConcept(src.getCode()));
    CrossVersionElements40_N.elementsToExtensions(src, tgt.getExtension(), "5.0", "expression");
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.CoverageEligibilityResponse.EligibilityOutcome> convertEligibilityOutcome(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Enumerations.RemittanceOutcome> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    // same codes (queued | complete | error | partial)
    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.CoverageEligibilityResponse.EligibilityOutcome> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.CoverageEligibilityResponse.EligibilityOutcomeEnumFactory());
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.getValue() != null)
      tgt.setValueAsString(src.getValueAsString());
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Enumerations.RemittanceOutcome> convertEligibilityOutcome(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.CoverageEligibilityResponse.EligibilityOutcome> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Enumerations.RemittanceOutcome> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Enumerations.RemittanceOutcomeEnumFactory());
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.getValue() != null)
      tgt.setValueAsString(src.getValueAsString());
    return tgt;
  }

  // R4 has EligibilityResponseStatus; R6 has the shared FinancialResourceStatusCodes - the same codes
  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.FinancialResourceStatusCodes> convertStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CoverageEligibilityResponse.EligibilityResponseStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.FinancialResourceStatusCodes> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.Enumerations.FinancialResourceStatusCodesEnumFactory());
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.getValue() != null)
      tgt.setValueAsString(src.getValueAsString());
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CoverageEligibilityResponse.EligibilityResponseStatus> convertStatus(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.FinancialResourceStatusCodes> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CoverageEligibilityResponse.EligibilityResponseStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.CoverageEligibilityResponse.EligibilityResponseStatusEnumFactory());
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.getValue() != null)
      tgt.setValueAsString(src.getValueAsString());
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.CoverageEligibilityResponse.EligibilityResponsePurpose> convertEligibilityResponsePurpose(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CoverageEligibilityResponse.EligibilityResponsePurpose> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.CoverageEligibilityResponse.EligibilityResponsePurpose> tgt = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.CoverageEligibilityResponse.EligibilityResponsePurposeEnumFactory());
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case AUTHREQUIREMENTS:
          tgt.setValue(org.hl7.fhir.model.core.CoverageEligibilityResponse.EligibilityResponsePurpose.AUTHREQUIREMENTS);
          break;
        case BENEFITS:
          tgt.setValue(org.hl7.fhir.model.core.CoverageEligibilityResponse.EligibilityResponsePurpose.BENEFITS);
          break;
        case DISCOVERY:
          tgt.setValue(org.hl7.fhir.model.core.CoverageEligibilityResponse.EligibilityResponsePurpose.DISCOVERY);
          break;
        case VALIDATION:
          tgt.setValue(org.hl7.fhir.model.core.CoverageEligibilityResponse.EligibilityResponsePurpose.VALIDATION);
          break;
        default:
          tgt.setValue(org.hl7.fhir.model.core.CoverageEligibilityResponse.EligibilityResponsePurpose.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CoverageEligibilityResponse.EligibilityResponsePurpose> convertEligibilityResponsePurpose(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.CoverageEligibilityResponse.EligibilityResponsePurpose> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CoverageEligibilityResponse.EligibilityResponsePurpose> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.CoverageEligibilityResponse.EligibilityResponsePurposeEnumFactory());
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(null);
    } else {
      switch (src.getValue()) {
        case AUTHREQUIREMENTS:
          tgt.setValue(org.hl7.fhir.r4.model.CoverageEligibilityResponse.EligibilityResponsePurpose.AUTHREQUIREMENTS);
          break;
        case BENEFITS:
          tgt.setValue(org.hl7.fhir.r4.model.CoverageEligibilityResponse.EligibilityResponsePurpose.BENEFITS);
          break;
        case DISCOVERY:
          tgt.setValue(org.hl7.fhir.r4.model.CoverageEligibilityResponse.EligibilityResponsePurpose.DISCOVERY);
          break;
        case VALIDATION:
          tgt.setValue(org.hl7.fhir.r4.model.CoverageEligibilityResponse.EligibilityResponsePurpose.VALIDATION);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r4.model.CoverageEligibilityResponse.EligibilityResponsePurpose.NULL);
          break;
      }
    }
    return tgt;
  }

}
