package org.hl7.fhir.convertors.conv40_50.resources40_50;

import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.*;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.*;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.special40_50.Reference40_50;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_40_50;
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
public class ChargeItem40_50 {

  public static org.hl7.fhir.r5.model.ChargeItem convertChargeItem(org.hl7.fhir.r4.model.ChargeItem src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ChargeItem tgt = new org.hl7.fhir.r5.model.ChargeItem();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_50.convertIdentifier(t));
    for (org.hl7.fhir.r4.model.UriType t : src.getDefinitionUri()) tgt.getDefinitionUri().add(Uri40_50.convertUri(t));
    for (org.hl7.fhir.r4.model.CanonicalType t : src.getDefinitionCanonical())
      tgt.getDefinitionCanonical().add(Canonical40_50.convertCanonical(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertChargeItemStatus(src.getStatusElement()));
    for (org.hl7.fhir.r4.model.Reference t : src.getPartOf()) tgt.addPartOf(Reference40_50.convertReference(t));
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_50.convertCodeableConcept(src.getCode()));
    if (src.hasSubject())
      tgt.setSubject(Reference40_50.convertReference(src.getSubject()));
    if (src.hasContext())
      tgt.setContext(Reference40_50.convertReference(src.getContext()));
    if (src.hasOccurrence())
      tgt.setOccurrence(VersionConvertorFactory_40_50.convertType(src.getOccurrence()));
    for (org.hl7.fhir.r4.model.ChargeItem.ChargeItemPerformerComponent t : src.getPerformer())
      tgt.addPerformer(convertChargeItemPerformerComponent(t));
    if (src.hasPerformingOrganization())
      tgt.setPerformingOrganization(Reference40_50.convertReference(src.getPerformingOrganization()));
    if (src.hasRequestingOrganization())
      tgt.setRequestingOrganization(Reference40_50.convertReference(src.getRequestingOrganization()));
    if (src.hasCostCenter())
      tgt.setCostCenter(Reference40_50.convertReference(src.getCostCenter()));
    if (src.hasQuantity())
      tgt.setQuantity(Quantity40_50.convertQuantity(src.getQuantity()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getBodysite())
      tgt.addBodysite(CodeableConcept40_50.convertCodeableConcept(t));
    if (src.hasFactorOverride())
      tgt.setFactorOverrideElement(Decimal40_50.convertDecimal(src.getFactorOverrideElement()));
    if (src.hasPriceOverride())
      tgt.setPriceOverride(Money40_50.convertMoney(src.getPriceOverride()));
    if (src.hasOverrideReason())
      tgt.setOverrideReasonElement(String40_50.convertString(src.getOverrideReasonElement()));
    if (src.hasEnterer())
      tgt.setEnterer(Reference40_50.convertReference(src.getEnterer()));
    if (src.hasEnteredDate())
      tgt.setEnteredDateElement(DateTime40_50.convertDateTime(src.getEnteredDateElement()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReason())
      tgt.addReason(CodeableConcept40_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getService()) tgt.addService(Reference40_50.convertReference(t));
    if (src.hasProduct())
      tgt.setProduct(VersionConvertorFactory_40_50.convertType(src.getProduct()));
    for (org.hl7.fhir.r4.model.Reference t : src.getAccount()) tgt.addAccount(Reference40_50.convertReference(t));
    for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.addNote(Annotation40_50.convertAnnotation(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getSupportingInformation())
      tgt.addSupportingInformation(Reference40_50.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ChargeItem convertChargeItem(org.hl7.fhir.r5.model.ChargeItem src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ChargeItem tgt = new org.hl7.fhir.r4.model.ChargeItem();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_50.convertIdentifier(t));
    for (org.hl7.fhir.r5.model.UriType t : src.getDefinitionUri()) tgt.getDefinitionUri().add(Uri40_50.convertUri(t));
    for (org.hl7.fhir.r5.model.CanonicalType t : src.getDefinitionCanonical())
      tgt.getDefinitionCanonical().add(Canonical40_50.convertCanonical(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertChargeItemStatus(src.getStatusElement()));
    for (org.hl7.fhir.r5.model.Reference t : src.getPartOf()) tgt.addPartOf(Reference40_50.convertReference(t));
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_50.convertCodeableConcept(src.getCode()));
    if (src.hasSubject())
      tgt.setSubject(Reference40_50.convertReference(src.getSubject()));
    if (src.hasContext())
      tgt.setContext(Reference40_50.convertReference(src.getContext()));
    if (src.hasOccurrence())
      tgt.setOccurrence(VersionConvertorFactory_40_50.convertType(src.getOccurrence()));
    for (org.hl7.fhir.r5.model.ChargeItem.ChargeItemPerformerComponent t : src.getPerformer())
      tgt.addPerformer(convertChargeItemPerformerComponent(t));
    if (src.hasPerformingOrganization())
      tgt.setPerformingOrganization(Reference40_50.convertReference(src.getPerformingOrganization()));
    if (src.hasRequestingOrganization())
      tgt.setRequestingOrganization(Reference40_50.convertReference(src.getRequestingOrganization()));
    if (src.hasCostCenter())
      tgt.setCostCenter(Reference40_50.convertReference(src.getCostCenter()));
    if (src.hasQuantity())
      tgt.setQuantity(Quantity40_50.convertQuantity(src.getQuantity()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getBodysite())
      tgt.addBodysite(CodeableConcept40_50.convertCodeableConcept(t));
    if (src.hasFactorOverride())
      tgt.setFactorOverrideElement(Decimal40_50.convertDecimal(src.getFactorOverrideElement()));
    if (src.hasPriceOverride())
      tgt.setPriceOverride(Money40_50.convertMoney(src.getPriceOverride()));
    if (src.hasOverrideReason())
      tgt.setOverrideReasonElement(String40_50.convertString(src.getOverrideReasonElement()));
    if (src.hasEnterer())
      tgt.setEnterer(Reference40_50.convertReference(src.getEnterer()));
    if (src.hasEnteredDate())
      tgt.setEnteredDateElement(DateTime40_50.convertDateTime(src.getEnteredDateElement()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getReason())
      tgt.addReason(CodeableConcept40_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getService()) tgt.addService(Reference40_50.convertReference(t));
    if (src.hasProduct())
      tgt.setProduct(VersionConvertorFactory_40_50.convertType(src.getProduct()));
    for (org.hl7.fhir.r5.model.Reference t : src.getAccount()) tgt.addAccount(Reference40_50.convertReference(t));
    for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.addNote(Annotation40_50.convertAnnotation(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getSupportingInformation())
      tgt.addSupportingInformation(Reference40_50.convertReference(t));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ChargeItem.ChargeItemStatus> convertChargeItemStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ChargeItem.ChargeItemStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ChargeItem.ChargeItemStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.ChargeItem.ChargeItemStatusEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case PLANNED:
        tgt.setValue(org.hl7.fhir.r5.model.ChargeItem.ChargeItemStatus.PLANNED);
        break;
      case BILLABLE:
        tgt.setValue(org.hl7.fhir.r5.model.ChargeItem.ChargeItemStatus.BILLABLE);
        break;
      case NOTBILLABLE:
        tgt.setValue(org.hl7.fhir.r5.model.ChargeItem.ChargeItemStatus.NOTBILLABLE);
        break;
      case ABORTED:
        tgt.setValue(org.hl7.fhir.r5.model.ChargeItem.ChargeItemStatus.ABORTED);
        break;
      case BILLED:
        tgt.setValue(org.hl7.fhir.r5.model.ChargeItem.ChargeItemStatus.BILLED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r5.model.ChargeItem.ChargeItemStatus.ENTEREDINERROR);
        break;
      case UNKNOWN:
        tgt.setValue(org.hl7.fhir.r5.model.ChargeItem.ChargeItemStatus.UNKNOWN);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.ChargeItem.ChargeItemStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ChargeItem.ChargeItemStatus> convertChargeItemStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ChargeItem.ChargeItemStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ChargeItem.ChargeItemStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ChargeItem.ChargeItemStatusEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case PLANNED:
        tgt.setValue(org.hl7.fhir.r4.model.ChargeItem.ChargeItemStatus.PLANNED);
        break;
      case BILLABLE:
        tgt.setValue(org.hl7.fhir.r4.model.ChargeItem.ChargeItemStatus.BILLABLE);
        break;
      case NOTBILLABLE:
        tgt.setValue(org.hl7.fhir.r4.model.ChargeItem.ChargeItemStatus.NOTBILLABLE);
        break;
      case ABORTED:
        tgt.setValue(org.hl7.fhir.r4.model.ChargeItem.ChargeItemStatus.ABORTED);
        break;
      case BILLED:
        tgt.setValue(org.hl7.fhir.r4.model.ChargeItem.ChargeItemStatus.BILLED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r4.model.ChargeItem.ChargeItemStatus.ENTEREDINERROR);
        break;
      case UNKNOWN:
        tgt.setValue(org.hl7.fhir.r4.model.ChargeItem.ChargeItemStatus.UNKNOWN);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.ChargeItem.ChargeItemStatus.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ChargeItem.ChargeItemPerformerComponent convertChargeItemPerformerComponent(org.hl7.fhir.r4.model.ChargeItem.ChargeItemPerformerComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ChargeItem.ChargeItemPerformerComponent tgt = new org.hl7.fhir.r5.model.ChargeItem.ChargeItemPerformerComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasFunction())
      tgt.setFunction(CodeableConcept40_50.convertCodeableConcept(src.getFunction()));
    if (src.hasActor())
      tgt.setActor(Reference40_50.convertReference(src.getActor()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ChargeItem.ChargeItemPerformerComponent convertChargeItemPerformerComponent(org.hl7.fhir.r5.model.ChargeItem.ChargeItemPerformerComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ChargeItem.ChargeItemPerformerComponent tgt = new org.hl7.fhir.r4.model.ChargeItem.ChargeItemPerformerComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasFunction())
      tgt.setFunction(CodeableConcept40_50.convertCodeableConcept(src.getFunction()));
    if (src.hasActor())
      tgt.setActor(Reference40_50.convertReference(src.getActor()));
    return tgt;
  }
}