package org.hl7.fhir.convertors.conv43_50.resources43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.CodeableConcept43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Identifier43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Period43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.metadata43_50.ContactDetail43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.metadata43_50.UsageContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Boolean43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Canonical43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Date43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.DateTime43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.MarkDown43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.String43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Uri43_50;
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
public class ChargeItemDefinition43_50 {

  public static org.hl7.fhir.r5.model.ChargeItemDefinition convertChargeItemDefinition(org.hl7.fhir.r4b.model.ChargeItemDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ChargeItemDefinition tgt = new org.hl7.fhir.r5.model.ChargeItemDefinition();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri43_50.convertUri(src.getUrlElement()));
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    if (src.hasVersion())
      tgt.setVersionElement(String43_50.convertString(src.getVersionElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String43_50.convertString(src.getTitleElement()));
    for (org.hl7.fhir.r4b.model.UriType t : src.getDerivedFromUri()) tgt.getDerivedFromUri().add(Uri43_50.convertUri(t));
    for (org.hl7.fhir.r4b.model.CanonicalType t : src.getPartOf())
      tgt.getPartOf().add(Canonical43_50.convertCanonical(t));
    for (org.hl7.fhir.r4b.model.CanonicalType t : src.getReplaces())
      tgt.getReplaces().add(Canonical43_50.convertCanonical(t));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations43_50.convertPublicationStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean43_50.convertBoolean(src.getExperimentalElement()));
    if (src.hasDate())
      tgt.setDateElement(DateTime43_50.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String43_50.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.r4b.model.ContactDetail t : src.getContact())
      tgt.addContact(ContactDetail43_50.convertContactDetail(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown43_50.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r4b.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(UsageContext43_50.convertUsageContext(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasCopyright())
      tgt.setCopyrightElement(MarkDown43_50.convertMarkdown(src.getCopyrightElement()));
    if (src.hasApprovalDate())
      tgt.setApprovalDateElement(Date43_50.convertDate(src.getApprovalDateElement()));
    if (src.hasLastReviewDate())
      tgt.setLastReviewDateElement(Date43_50.convertDate(src.getLastReviewDateElement()));
    if (src.hasEffectivePeriod())
      tgt.setEffectivePeriod(Period43_50.convertPeriod(src.getEffectivePeriod()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_50.convertCodeableConcept(src.getCode()));
    for (org.hl7.fhir.r4b.model.Reference t : src.getInstance()) tgt.addInstance(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r4b.model.ChargeItemDefinition.ChargeItemDefinitionApplicabilityComponent t : src.getApplicability())
      tgt.addApplicability(convertChargeItemDefinitionApplicabilityComponent(t));
    for (org.hl7.fhir.r4b.model.ChargeItemDefinition.ChargeItemDefinitionPropertyGroupComponent t : src.getPropertyGroup())
      tgt.addPropertyGroup(convertChargeItemDefinitionPropertyGroupComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ChargeItemDefinition convertChargeItemDefinition(org.hl7.fhir.r5.model.ChargeItemDefinition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ChargeItemDefinition tgt = new org.hl7.fhir.r4b.model.ChargeItemDefinition();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri43_50.convertUri(src.getUrlElement()));
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    if (src.hasVersion())
      tgt.setVersionElement(String43_50.convertString(src.getVersionElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String43_50.convertString(src.getTitleElement()));
    for (org.hl7.fhir.r5.model.UriType t : src.getDerivedFromUri()) tgt.getDerivedFromUri().add(Uri43_50.convertUri(t));
    for (org.hl7.fhir.r5.model.CanonicalType t : src.getPartOf())
      tgt.getPartOf().add(Canonical43_50.convertCanonical(t));
    for (org.hl7.fhir.r5.model.CanonicalType t : src.getReplaces())
      tgt.getReplaces().add(Canonical43_50.convertCanonical(t));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations43_50.convertPublicationStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean43_50.convertBoolean(src.getExperimentalElement()));
    if (src.hasDate())
      tgt.setDateElement(DateTime43_50.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String43_50.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.r5.model.ContactDetail t : src.getContact())
      tgt.addContact(ContactDetail43_50.convertContactDetail(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown43_50.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r5.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(UsageContext43_50.convertUsageContext(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasCopyright())
      tgt.setCopyrightElement(MarkDown43_50.convertMarkdown(src.getCopyrightElement()));
    if (src.hasApprovalDate())
      tgt.setApprovalDateElement(Date43_50.convertDate(src.getApprovalDateElement()));
    if (src.hasLastReviewDate())
      tgt.setLastReviewDateElement(Date43_50.convertDate(src.getLastReviewDateElement()));
    if (src.hasEffectivePeriod())
      tgt.setEffectivePeriod(Period43_50.convertPeriod(src.getEffectivePeriod()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_50.convertCodeableConcept(src.getCode()));
    for (org.hl7.fhir.r5.model.Reference t : src.getInstance()) tgt.addInstance(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r5.model.ChargeItemDefinition.ChargeItemDefinitionApplicabilityComponent t : src.getApplicability())
      tgt.addApplicability(convertChargeItemDefinitionApplicabilityComponent(t));
    for (org.hl7.fhir.r5.model.ChargeItemDefinition.ChargeItemDefinitionPropertyGroupComponent t : src.getPropertyGroup())
      tgt.addPropertyGroup(convertChargeItemDefinitionPropertyGroupComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ChargeItemDefinition.ChargeItemDefinitionApplicabilityComponent convertChargeItemDefinitionApplicabilityComponent(org.hl7.fhir.r4b.model.ChargeItemDefinition.ChargeItemDefinitionApplicabilityComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ChargeItemDefinition.ChargeItemDefinitionApplicabilityComponent tgt = new org.hl7.fhir.r5.model.ChargeItemDefinition.ChargeItemDefinitionApplicabilityComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasDescription())
      tgt.getCondition().setDescriptionElement(String43_50.convertString(src.getDescriptionElement()));
    if (src.hasLanguage())
      tgt.getCondition().setLanguage(src.getLanguage());
    if (src.hasExpression())
      tgt.getCondition().setExpressionElement(String43_50.convertString(src.getExpressionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ChargeItemDefinition.ChargeItemDefinitionApplicabilityComponent convertChargeItemDefinitionApplicabilityComponent(org.hl7.fhir.r5.model.ChargeItemDefinition.ChargeItemDefinitionApplicabilityComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ChargeItemDefinition.ChargeItemDefinitionApplicabilityComponent tgt = new org.hl7.fhir.r4b.model.ChargeItemDefinition.ChargeItemDefinitionApplicabilityComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.getCondition().hasDescription())
      tgt.setDescriptionElement(String43_50.convertString(src.getCondition().getDescriptionElement()));
    if (src.getCondition().hasLanguage())
      tgt.setLanguageElement(String43_50.convertString(src.getCondition().getLanguageElement()));
    if (src.getCondition().hasExpression())
      tgt.setExpressionElement(String43_50.convertString(src.getCondition().getExpressionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ChargeItemDefinition.ChargeItemDefinitionPropertyGroupComponent convertChargeItemDefinitionPropertyGroupComponent(org.hl7.fhir.r4b.model.ChargeItemDefinition.ChargeItemDefinitionPropertyGroupComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ChargeItemDefinition.ChargeItemDefinitionPropertyGroupComponent tgt = new org.hl7.fhir.r5.model.ChargeItemDefinition.ChargeItemDefinitionPropertyGroupComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r4b.model.ChargeItemDefinition.ChargeItemDefinitionApplicabilityComponent t : src.getApplicability())
      tgt.addApplicability(convertChargeItemDefinitionApplicabilityComponent(t));
//    for (org.hl7.fhir.r4b.model.ChargeItemDefinition.ChargeItemDefinitionPropertyGroupPriceComponentComponent t : src.getPriceComponent())
//      tgt.addPriceComponent(convertChargeItemDefinitionPropertyGroupPriceComponentComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ChargeItemDefinition.ChargeItemDefinitionPropertyGroupComponent convertChargeItemDefinitionPropertyGroupComponent(org.hl7.fhir.r5.model.ChargeItemDefinition.ChargeItemDefinitionPropertyGroupComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ChargeItemDefinition.ChargeItemDefinitionPropertyGroupComponent tgt = new org.hl7.fhir.r4b.model.ChargeItemDefinition.ChargeItemDefinitionPropertyGroupComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r5.model.ChargeItemDefinition.ChargeItemDefinitionApplicabilityComponent t : src.getApplicability())
      tgt.addApplicability(convertChargeItemDefinitionApplicabilityComponent(t));
//    for (org.hl7.fhir.r5.model.ChargeItemDefinition.ChargeItemDefinitionPropertyGroupPriceComponentComponent t : src.getPriceComponent())
//      tgt.addPriceComponent(convertChargeItemDefinitionPropertyGroupPriceComponentComponent(t));
    return tgt;
  }

//  public static org.hl7.fhir.r5.model.ChargeItemDefinition.ChargeItemDefinitionPropertyGroupPriceComponentComponent convertChargeItemDefinitionPropertyGroupPriceComponentComponent(org.hl7.fhir.r4b.model.ChargeItemDefinition.ChargeItemDefinitionPropertyGroupPriceComponentComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.r5.model.ChargeItemDefinition.ChargeItemDefinitionPropertyGroupPriceComponentComponent tgt = new org.hl7.fhir.r5.model.ChargeItemDefinition.ChargeItemDefinitionPropertyGroupPriceComponentComponent();
//    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
//    if (src.hasType())
//      tgt.setTypeElement(convertChargeItemDefinitionPriceComponentType(src.getTypeElement()));
//    if (src.hasCode())
//      tgt.setCode(CodeableConcept43_50.convertCodeableConcept(src.getCode()));
//    if (src.hasFactor())
//      tgt.setFactorElement(Decimal43_50.convertDecimal(src.getFactorElement()));
//    if (src.hasAmount())
//      tgt.setAmount(Money43_50.convertMoney(src.getAmount()));
//    return tgt;
//  }
//
//  public static org.hl7.fhir.r4b.model.ChargeItemDefinition.ChargeItemDefinitionPropertyGroupPriceComponentComponent convertChargeItemDefinitionPropertyGroupPriceComponentComponent(org.hl7.fhir.r5.model.ChargeItemDefinition.ChargeItemDefinitionPropertyGroupPriceComponentComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.r4b.model.ChargeItemDefinition.ChargeItemDefinitionPropertyGroupPriceComponentComponent tgt = new org.hl7.fhir.r4b.model.ChargeItemDefinition.ChargeItemDefinitionPropertyGroupPriceComponentComponent();
//    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
//    if (src.hasType())
//      tgt.setTypeElement(convertChargeItemDefinitionPriceComponentType(src.getTypeElement()));
//    if (src.hasCode())
//      tgt.setCode(CodeableConcept43_50.convertCodeableConcept(src.getCode()));
//    if (src.hasFactor())
//      tgt.setFactorElement(Decimal43_50.convertDecimal(src.getFactorElement()));
//    if (src.hasAmount())
//      tgt.setAmount(Money43_50.convertMoney(src.getAmount()));
//    return tgt;
//  }
//
//  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.InvoicePriceComponentType> convertChargeItemDefinitionPriceComponentType(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.InvoicePriceComponentType> src) throws FHIRException {
//    if (src == null || src.isEmpty())
//      return null;
//    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.InvoicePriceComponentType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.InvoicePriceComponentTypeEnumFactory());
//    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
//    switch (src.getValue()) {
//      case BASE:
//        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.InvoicePriceComponentType.BASE);
//        break;
//      case SURCHARGE:
//        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.InvoicePriceComponentType.SURCHARGE);
//        break;
//      case DEDUCTION:
//        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.InvoicePriceComponentType.DEDUCTION);
//        break;
//      case DISCOUNT:
//        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.InvoicePriceComponentType.DISCOUNT);
//        break;
//      case TAX:
//        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.InvoicePriceComponentType.TAX);
//        break;
//      case INFORMATIONAL:
//        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.InvoicePriceComponentType.INFORMATIONAL);
//        break;
//      default:
//        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.InvoicePriceComponentType.NULL);
//        break;
//    }
//    return tgt;
//  }
//
//  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.InvoicePriceComponentType> convertChargeItemDefinitionPriceComponentType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.InvoicePriceComponentType> src) throws FHIRException {
//    if (src == null || src.isEmpty())
//      return null;
//    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.InvoicePriceComponentType> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.InvoicePriceComponentTypeEnumFactory());
//    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
//    switch (src.getValue()) {
//      case BASE:
//        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.InvoicePriceComponentType.BASE);
//        break;
//      case SURCHARGE:
//        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.InvoicePriceComponentType.SURCHARGE);
//        break;
//      case DEDUCTION:
//        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.InvoicePriceComponentType.DEDUCTION);
//        break;
//      case DISCOUNT:
//        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.InvoicePriceComponentType.DISCOUNT);
//        break;
//      case TAX:
//        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.InvoicePriceComponentType.TAX);
//        break;
//      case INFORMATIONAL:
//        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.InvoicePriceComponentType.INFORMATIONAL);
//        break;
//      default:
//        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.InvoicePriceComponentType.NULL);
//        break;
//    }
//    return tgt;
//  }
}