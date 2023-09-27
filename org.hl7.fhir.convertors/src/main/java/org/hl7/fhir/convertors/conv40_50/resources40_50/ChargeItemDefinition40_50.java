package org.hl7.fhir.convertors.conv40_50.resources40_50;

import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.CodeableConcept40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Identifier40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Money40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Period40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.metadata40_50.ContactDetail40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.metadata40_50.UsageContext40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Boolean40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Canonical40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Date40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.DateTime40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Decimal40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.MarkDown40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.String40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Uri40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.special40_50.Reference40_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.MonetaryComponent;

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
public class ChargeItemDefinition40_50 {

  public static org.hl7.fhir.r5.model.ChargeItemDefinition convertChargeItemDefinition(org.hl7.fhir.r4.model.ChargeItemDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ChargeItemDefinition tgt = new org.hl7.fhir.r5.model.ChargeItemDefinition();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri40_50.convertUri(src.getUrlElement()));
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_50.convertIdentifier(t));
    if (src.hasVersion())
      tgt.setVersionElement(String40_50.convertString(src.getVersionElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String40_50.convertString(src.getTitleElement()));
    for (org.hl7.fhir.r4.model.UriType t : src.getDerivedFromUri()) tgt.getDerivedFromUri().add(Uri40_50.convertUri(t));
    for (org.hl7.fhir.r4.model.CanonicalType t : src.getPartOf())
      tgt.getPartOf().add(Canonical40_50.convertCanonical(t));
    for (org.hl7.fhir.r4.model.CanonicalType t : src.getReplaces())
      tgt.getReplaces().add(Canonical40_50.convertCanonical(t));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations40_50.convertPublicationStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean40_50.convertBoolean(src.getExperimentalElement()));
    if (src.hasDate())
      tgt.setDateElement(DateTime40_50.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String40_50.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.r4.model.ContactDetail t : src.getContact())
      tgt.addContact(ContactDetail40_50.convertContactDetail(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown40_50.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r4.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(UsageContext40_50.convertUsageContext(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(CodeableConcept40_50.convertCodeableConcept(t));
    if (src.hasCopyright())
      tgt.setCopyrightElement(MarkDown40_50.convertMarkdown(src.getCopyrightElement()));
    if (src.hasApprovalDate())
      tgt.setApprovalDateElement(Date40_50.convertDate(src.getApprovalDateElement()));
    if (src.hasLastReviewDate())
      tgt.setLastReviewDateElement(Date40_50.convertDate(src.getLastReviewDateElement()));
    if (src.hasEffectivePeriod())
      tgt.setEffectivePeriod(Period40_50.convertPeriod(src.getEffectivePeriod()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_50.convertCodeableConcept(src.getCode()));
    for (org.hl7.fhir.r4.model.Reference t : src.getInstance()) tgt.addInstance(Reference40_50.convertReference(t));
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
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri40_50.convertUri(src.getUrlElement()));
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_50.convertIdentifier(t));
    if (src.hasVersion())
      tgt.setVersionElement(String40_50.convertString(src.getVersionElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String40_50.convertString(src.getTitleElement()));
    for (org.hl7.fhir.r5.model.UriType t : src.getDerivedFromUri()) tgt.getDerivedFromUri().add(Uri40_50.convertUri(t));
    for (org.hl7.fhir.r5.model.CanonicalType t : src.getPartOf())
      tgt.getPartOf().add(Canonical40_50.convertCanonical(t));
    for (org.hl7.fhir.r5.model.CanonicalType t : src.getReplaces())
      tgt.getReplaces().add(Canonical40_50.convertCanonical(t));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations40_50.convertPublicationStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean40_50.convertBoolean(src.getExperimentalElement()));
    if (src.hasDate())
      tgt.setDateElement(DateTime40_50.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String40_50.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.r5.model.ContactDetail t : src.getContact())
      tgt.addContact(ContactDetail40_50.convertContactDetail(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown40_50.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r5.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(UsageContext40_50.convertUsageContext(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(CodeableConcept40_50.convertCodeableConcept(t));
    if (src.hasCopyright())
      tgt.setCopyrightElement(MarkDown40_50.convertMarkdown(src.getCopyrightElement()));
    if (src.hasApprovalDate())
      tgt.setApprovalDateElement(Date40_50.convertDate(src.getApprovalDateElement()));
    if (src.hasLastReviewDate())
      tgt.setLastReviewDateElement(Date40_50.convertDate(src.getLastReviewDateElement()));
    if (src.hasEffectivePeriod())
      tgt.setEffectivePeriod(Period40_50.convertPeriod(src.getEffectivePeriod()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_50.convertCodeableConcept(src.getCode()));
    for (org.hl7.fhir.r5.model.Reference t : src.getInstance()) tgt.addInstance(Reference40_50.convertReference(t));
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
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasDescription())
      tgt.getCondition().setDescriptionElement(String40_50.convertString(src.getDescriptionElement()));
    if (src.hasLanguage())
      tgt.getCondition().setLanguage(src.getLanguage());
    if (src.hasExpression())
      tgt.getCondition().setExpressionElement(String40_50.convertString(src.getExpressionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ChargeItemDefinition.ChargeItemDefinitionApplicabilityComponent convertChargeItemDefinitionApplicabilityComponent(org.hl7.fhir.r5.model.ChargeItemDefinition.ChargeItemDefinitionApplicabilityComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ChargeItemDefinition.ChargeItemDefinitionApplicabilityComponent tgt = new org.hl7.fhir.r4.model.ChargeItemDefinition.ChargeItemDefinitionApplicabilityComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.getCondition().hasDescription())
      tgt.setDescriptionElement(String40_50.convertString(src.getCondition().getDescriptionElement()));
    if (src.getCondition().hasLanguage())
      tgt.setLanguageElement(String40_50.convertString(src.getCondition().getLanguageElement()));
    if (src.getCondition().hasExpression())
      tgt.setExpressionElement(String40_50.convertString(src.getCondition().getExpressionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ChargeItemDefinition.ChargeItemDefinitionPropertyGroupComponent convertChargeItemDefinitionPropertyGroupComponent(org.hl7.fhir.r4.model.ChargeItemDefinition.ChargeItemDefinitionPropertyGroupComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ChargeItemDefinition.ChargeItemDefinitionPropertyGroupComponent tgt = new org.hl7.fhir.r5.model.ChargeItemDefinition.ChargeItemDefinitionPropertyGroupComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
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
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r5.model.ChargeItemDefinition.ChargeItemDefinitionApplicabilityComponent t : src.getApplicability())
      tgt.addApplicability(convertChargeItemDefinitionApplicabilityComponent(t));
    for (org.hl7.fhir.r5.model.MonetaryComponent t : src.getPriceComponent())
      tgt.addPriceComponent(convertChargeItemDefinitionPropertyGroupPriceComponentComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.MonetaryComponent convertChargeItemDefinitionPropertyGroupPriceComponentComponent(org.hl7.fhir.r4.model.ChargeItemDefinition.ChargeItemDefinitionPropertyGroupPriceComponentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.MonetaryComponent tgt = new org.hl7.fhir.r5.model.MonetaryComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasType())
      tgt.setTypeElement(convertChargeItemDefinitionPriceComponentType(src.getTypeElement()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_50.convertCodeableConcept(src.getCode()));
    if (src.hasFactor())
      tgt.setFactorElement(Decimal40_50.convertDecimal(src.getFactorElement()));
    if (src.hasAmount())
      tgt.setAmount(Money40_50.convertMoney(src.getAmount()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ChargeItemDefinition.ChargeItemDefinitionPropertyGroupPriceComponentComponent convertChargeItemDefinitionPropertyGroupPriceComponentComponent(org.hl7.fhir.r5.model.MonetaryComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ChargeItemDefinition.ChargeItemDefinitionPropertyGroupPriceComponentComponent tgt = new org.hl7.fhir.r4.model.ChargeItemDefinition.ChargeItemDefinitionPropertyGroupPriceComponentComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasType())
      tgt.setTypeElement(convertChargeItemDefinitionPriceComponentType(src.getTypeElement()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_50.convertCodeableConcept(src.getCode()));
    if (src.hasFactor())
      tgt.setFactorElement(Decimal40_50.convertDecimal(src.getFactorElement()));
    if (src.hasAmount())
      tgt.setAmount(Money40_50.convertMoney(src.getAmount()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MonetaryComponent.PriceComponentType> convertChargeItemDefinitionPriceComponentType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ChargeItemDefinition.ChargeItemDefinitionPriceComponentType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MonetaryComponent.PriceComponentType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.MonetaryComponent.PriceComponentTypeEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case BASE:
        tgt.setValue(org.hl7.fhir.r5.model.MonetaryComponent.PriceComponentType.BASE);
        break;
      case SURCHARGE:
        tgt.setValue(org.hl7.fhir.r5.model.MonetaryComponent.PriceComponentType.SURCHARGE);
        break;
      case DEDUCTION:
        tgt.setValue(org.hl7.fhir.r5.model.MonetaryComponent.PriceComponentType.DEDUCTION);
        break;
      case DISCOUNT:
        tgt.setValue(org.hl7.fhir.r5.model.MonetaryComponent.PriceComponentType.DISCOUNT);
        break;
      case TAX:
        tgt.setValue(org.hl7.fhir.r5.model.MonetaryComponent.PriceComponentType.TAX);
        break;
      case INFORMATIONAL:
        tgt.setValue(org.hl7.fhir.r5.model.MonetaryComponent.PriceComponentType.INFORMATIONAL);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.MonetaryComponent.PriceComponentType.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ChargeItemDefinition.ChargeItemDefinitionPriceComponentType> convertChargeItemDefinitionPriceComponentType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.MonetaryComponent.PriceComponentType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ChargeItemDefinition.ChargeItemDefinitionPriceComponentType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ChargeItemDefinition.ChargeItemDefinitionPriceComponentTypeEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case BASE:
        tgt.setValue(org.hl7.fhir.r4.model.ChargeItemDefinition.ChargeItemDefinitionPriceComponentType.BASE);
        break;
      case SURCHARGE:
        tgt.setValue(org.hl7.fhir.r4.model.ChargeItemDefinition.ChargeItemDefinitionPriceComponentType.SURCHARGE);
        break;
      case DEDUCTION:
        tgt.setValue(org.hl7.fhir.r4.model.ChargeItemDefinition.ChargeItemDefinitionPriceComponentType.DEDUCTION);
        break;
      case DISCOUNT:
        tgt.setValue(org.hl7.fhir.r4.model.ChargeItemDefinition.ChargeItemDefinitionPriceComponentType.DISCOUNT);
        break;
      case TAX:
        tgt.setValue(org.hl7.fhir.r4.model.ChargeItemDefinition.ChargeItemDefinitionPriceComponentType.TAX);
        break;
      case INFORMATIONAL:
        tgt.setValue(org.hl7.fhir.r4.model.ChargeItemDefinition.ChargeItemDefinitionPriceComponentType.INFORMATIONAL);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.ChargeItemDefinition.ChargeItemDefinitionPriceComponentType.NULL);
        break;
    }
    return tgt;
  }
}