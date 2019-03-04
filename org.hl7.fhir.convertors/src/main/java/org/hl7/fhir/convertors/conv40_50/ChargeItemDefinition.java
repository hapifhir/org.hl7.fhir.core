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


public class ChargeItemDefinition extends VersionConvertor_40_50 {

  public static org.hl7.fhir.r5.model.ChargeItemDefinition convertChargeItemDefinition(org.hl7.fhir.r4.model.ChargeItemDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ChargeItemDefinition tgt = new org.hl7.fhir.r5.model.ChargeItemDefinition();
    copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(convertUri(src.getUrlElement()));
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    if (src.hasVersion())
      tgt.setVersionElement(convertString(src.getVersionElement()));
    if (src.hasTitle())
      tgt.setTitleElement(convertString(src.getTitleElement()));
    for (org.hl7.fhir.r4.model.UriType t : src.getDerivedFromUri())
      tgt.getDerivedFromUri().add(convertUri(t));
    for (org.hl7.fhir.r4.model.CanonicalType t : src.getPartOf())
      tgt.getPartOf().add(convertCanonical(t));
    for (org.hl7.fhir.r4.model.CanonicalType t : src.getReplaces())
      tgt.getReplaces().add(convertCanonical(t));
    if (src.hasStatus())
      tgt.setStatus(Enumerations.convertPublicationStatus(src.getStatus()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(convertBoolean(src.getExperimentalElement()));
    if (src.hasDate())
      tgt.setDateElement(convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(convertString(src.getPublisherElement()));
    for (org.hl7.fhir.r4.model.ContactDetail t : src.getContact())
      tgt.addContact(convertContactDetail(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(convertMarkdown(src.getDescriptionElement()));
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
    if (src.hasCode())
      tgt.setCode(convertCodeableConcept(src.getCode()));
    for (org.hl7.fhir.r4.model.Reference t : src.getInstance())
      tgt.addInstance(convertReference(t));
    for (org.hl7.fhir.r4.model.ChargeItemDefinition.ChargeItemDefinitionApplicabilityComponent t : src.getApplicability())
      tgt.addApplicability(convertChargeItemDefinitionApplicabilityComponent(t));
    for (org.hl7.fhir.r4.model.ChargeItemDefinition.ChargeItemDefinitionPropertyGroupComponent t : src.getPropertyGroup())
      tgt.addPropertyGroup(convertChargeItemDefinitionPropertyGroupComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ChargeItemDefinition convertChargeItemDefinition(org.hl7.fhir.r5.model.ChargeItemDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ChargeItemDefinition tgt = new org.hl7.fhir.r4.model.ChargeItemDefinition();
    copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(convertUri(src.getUrlElement()));
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    if (src.hasVersion())
      tgt.setVersionElement(convertString(src.getVersionElement()));
    if (src.hasTitle())
      tgt.setTitleElement(convertString(src.getTitleElement()));
    for (org.hl7.fhir.r5.model.UriType t : src.getDerivedFromUri())
      tgt.getDerivedFromUri().add(convertUri(t));
    for (org.hl7.fhir.r5.model.CanonicalType t : src.getPartOf())
      tgt.getPartOf().add(convertCanonical(t));
    for (org.hl7.fhir.r5.model.CanonicalType t : src.getReplaces())
      tgt.getReplaces().add(convertCanonical(t));
    if (src.hasStatus())
      tgt.setStatus(Enumerations.convertPublicationStatus(src.getStatus()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(convertBoolean(src.getExperimentalElement()));
    if (src.hasDate())
      tgt.setDateElement(convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(convertString(src.getPublisherElement()));
    for (org.hl7.fhir.r5.model.ContactDetail t : src.getContact())
      tgt.addContact(convertContactDetail(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(convertMarkdown(src.getDescriptionElement()));
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
    if (src.hasCode())
      tgt.setCode(convertCodeableConcept(src.getCode()));
    for (org.hl7.fhir.r5.model.Reference t : src.getInstance())
      tgt.addInstance(convertReference(t));
    for (org.hl7.fhir.r5.model.ChargeItemDefinition.ChargeItemDefinitionApplicabilityComponent t : src.getApplicability())
      tgt.addApplicability(convertChargeItemDefinitionApplicabilityComponent(t));
    for (org.hl7.fhir.r5.model.ChargeItemDefinition.ChargeItemDefinitionPropertyGroupComponent t : src.getPropertyGroup())
      tgt.addPropertyGroup(convertChargeItemDefinitionPropertyGroupComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ChargeItemDefinition.ChargeItemDefinitionApplicabilityComponent convertChargeItemDefinitionApplicabilityComponent(org.hl7.fhir.r4.model.ChargeItemDefinition.ChargeItemDefinitionApplicabilityComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ChargeItemDefinition.ChargeItemDefinitionApplicabilityComponent tgt = new org.hl7.fhir.r5.model.ChargeItemDefinition.ChargeItemDefinitionApplicabilityComponent();
    copyElement(src, tgt);
    if (src.hasDescription())
      tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
    if (src.hasLanguage())
      tgt.setLanguageElement(convertString(src.getLanguageElement()));
    if (src.hasExpression())
      tgt.setExpressionElement(convertString(src.getExpressionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ChargeItemDefinition.ChargeItemDefinitionApplicabilityComponent convertChargeItemDefinitionApplicabilityComponent(org.hl7.fhir.r5.model.ChargeItemDefinition.ChargeItemDefinitionApplicabilityComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ChargeItemDefinition.ChargeItemDefinitionApplicabilityComponent tgt = new org.hl7.fhir.r4.model.ChargeItemDefinition.ChargeItemDefinitionApplicabilityComponent();
    copyElement(src, tgt);
    if (src.hasDescription())
      tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
    if (src.hasLanguage())
      tgt.setLanguageElement(convertString(src.getLanguageElement()));
    if (src.hasExpression())
      tgt.setExpressionElement(convertString(src.getExpressionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ChargeItemDefinition.ChargeItemDefinitionPropertyGroupComponent convertChargeItemDefinitionPropertyGroupComponent(org.hl7.fhir.r4.model.ChargeItemDefinition.ChargeItemDefinitionPropertyGroupComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ChargeItemDefinition.ChargeItemDefinitionPropertyGroupComponent tgt = new org.hl7.fhir.r5.model.ChargeItemDefinition.ChargeItemDefinitionPropertyGroupComponent();
    copyElement(src, tgt);
    for (org.hl7.fhir.r4.model.ChargeItemDefinition.ChargeItemDefinitionApplicabilityComponent t : src.getApplicability())
      tgt.addApplicability(convertChargeItemDefinitionApplicabilityComponent(t));
    for (org.hl7.fhir.r4.model.ChargeItemDefinition.ChargeItemDefinitionPropertyGroupPriceComponentComponent t : src.getPriceComponent())
      tgt.addPriceComponent(convertChargeItemDefinitionPropertyGroupPriceComponentComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ChargeItemDefinition.ChargeItemDefinitionPropertyGroupComponent convertChargeItemDefinitionPropertyGroupComponent(org.hl7.fhir.r5.model.ChargeItemDefinition.ChargeItemDefinitionPropertyGroupComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ChargeItemDefinition.ChargeItemDefinitionPropertyGroupComponent tgt = new org.hl7.fhir.r4.model.ChargeItemDefinition.ChargeItemDefinitionPropertyGroupComponent();
    copyElement(src, tgt);
    for (org.hl7.fhir.r5.model.ChargeItemDefinition.ChargeItemDefinitionApplicabilityComponent t : src.getApplicability())
      tgt.addApplicability(convertChargeItemDefinitionApplicabilityComponent(t));
    for (org.hl7.fhir.r5.model.ChargeItemDefinition.ChargeItemDefinitionPropertyGroupPriceComponentComponent t : src.getPriceComponent())
      tgt.addPriceComponent(convertChargeItemDefinitionPropertyGroupPriceComponentComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ChargeItemDefinition.ChargeItemDefinitionPropertyGroupPriceComponentComponent convertChargeItemDefinitionPropertyGroupPriceComponentComponent(org.hl7.fhir.r4.model.ChargeItemDefinition.ChargeItemDefinitionPropertyGroupPriceComponentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ChargeItemDefinition.ChargeItemDefinitionPropertyGroupPriceComponentComponent tgt = new org.hl7.fhir.r5.model.ChargeItemDefinition.ChargeItemDefinitionPropertyGroupPriceComponentComponent();
    copyElement(src, tgt);
    if (src.hasType())
      tgt.setType(convertChargeItemDefinitionPriceComponentType(src.getType()));
    if (src.hasCode())
      tgt.setCode(convertCodeableConcept(src.getCode()));
    if (src.hasFactor())
      tgt.setFactorElement(convertDecimal(src.getFactorElement()));
    if (src.hasAmount())
      tgt.setAmount(convertMoney(src.getAmount()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ChargeItemDefinition.ChargeItemDefinitionPropertyGroupPriceComponentComponent convertChargeItemDefinitionPropertyGroupPriceComponentComponent(org.hl7.fhir.r5.model.ChargeItemDefinition.ChargeItemDefinitionPropertyGroupPriceComponentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ChargeItemDefinition.ChargeItemDefinitionPropertyGroupPriceComponentComponent tgt = new org.hl7.fhir.r4.model.ChargeItemDefinition.ChargeItemDefinitionPropertyGroupPriceComponentComponent();
    copyElement(src, tgt);
    if (src.hasType())
      tgt.setType(convertChargeItemDefinitionPriceComponentType(src.getType()));
    if (src.hasCode())
      tgt.setCode(convertCodeableConcept(src.getCode()));
    if (src.hasFactor())
      tgt.setFactorElement(convertDecimal(src.getFactorElement()));
    if (src.hasAmount())
      tgt.setAmount(convertMoney(src.getAmount()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ChargeItemDefinition.ChargeItemDefinitionPriceComponentType convertChargeItemDefinitionPriceComponentType(org.hl7.fhir.r4.model.ChargeItemDefinition.ChargeItemDefinitionPriceComponentType src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case BASE: return org.hl7.fhir.r5.model.ChargeItemDefinition.ChargeItemDefinitionPriceComponentType.BASE;
    case SURCHARGE: return org.hl7.fhir.r5.model.ChargeItemDefinition.ChargeItemDefinitionPriceComponentType.SURCHARGE;
    case DEDUCTION: return org.hl7.fhir.r5.model.ChargeItemDefinition.ChargeItemDefinitionPriceComponentType.DEDUCTION;
    case DISCOUNT: return org.hl7.fhir.r5.model.ChargeItemDefinition.ChargeItemDefinitionPriceComponentType.DISCOUNT;
    case TAX: return org.hl7.fhir.r5.model.ChargeItemDefinition.ChargeItemDefinitionPriceComponentType.TAX;
    case INFORMATIONAL: return org.hl7.fhir.r5.model.ChargeItemDefinition.ChargeItemDefinitionPriceComponentType.INFORMATIONAL;
    default: return org.hl7.fhir.r5.model.ChargeItemDefinition.ChargeItemDefinitionPriceComponentType.NULL;
  }
}

  public static org.hl7.fhir.r4.model.ChargeItemDefinition.ChargeItemDefinitionPriceComponentType convertChargeItemDefinitionPriceComponentType(org.hl7.fhir.r5.model.ChargeItemDefinition.ChargeItemDefinitionPriceComponentType src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case BASE: return org.hl7.fhir.r4.model.ChargeItemDefinition.ChargeItemDefinitionPriceComponentType.BASE;
    case SURCHARGE: return org.hl7.fhir.r4.model.ChargeItemDefinition.ChargeItemDefinitionPriceComponentType.SURCHARGE;
    case DEDUCTION: return org.hl7.fhir.r4.model.ChargeItemDefinition.ChargeItemDefinitionPriceComponentType.DEDUCTION;
    case DISCOUNT: return org.hl7.fhir.r4.model.ChargeItemDefinition.ChargeItemDefinitionPriceComponentType.DISCOUNT;
    case TAX: return org.hl7.fhir.r4.model.ChargeItemDefinition.ChargeItemDefinitionPriceComponentType.TAX;
    case INFORMATIONAL: return org.hl7.fhir.r4.model.ChargeItemDefinition.ChargeItemDefinitionPriceComponentType.INFORMATIONAL;
    default: return org.hl7.fhir.r4.model.ChargeItemDefinition.ChargeItemDefinitionPriceComponentType.NULL;
  }
}


}
