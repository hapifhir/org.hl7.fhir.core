package org.hl7.fhir.convertors.conv43_50.resources43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.*;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.*;
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
public class ChargeItem43_50 {

  public static org.hl7.fhir.r5.model.ChargeItem convertChargeItem(org.hl7.fhir.r4b.model.ChargeItem src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ChargeItem tgt = new org.hl7.fhir.r5.model.ChargeItem();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    for (org.hl7.fhir.r4b.model.UriType t : src.getDefinitionUri()) tgt.getDefinitionUri().add(Uri43_50.convertUri(t));
    for (org.hl7.fhir.r4b.model.CanonicalType t : src.getDefinitionCanonical())
      tgt.getDefinitionCanonical().add(Canonical43_50.convertCanonical(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertChargeItemStatus(src.getStatusElement()));
    for (org.hl7.fhir.r4b.model.Reference t : src.getPartOf()) tgt.addPartOf(Reference43_50.convertReference(t));
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_50.convertCodeableConcept(src.getCode()));
    if (src.hasSubject())
      tgt.setSubject(Reference43_50.convertReference(src.getSubject()));
    if (src.hasContext())
      tgt.setContext(Reference43_50.convertReference(src.getContext()));
    if (src.hasOccurrence())
      tgt.setOccurrence(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getOccurrence()));
    for (org.hl7.fhir.r4b.model.ChargeItem.ChargeItemPerformerComponent t : src.getPerformer())
      tgt.addPerformer(convertChargeItemPerformerComponent(t));
    if (src.hasPerformingOrganization())
      tgt.setPerformingOrganization(Reference43_50.convertReference(src.getPerformingOrganization()));
    if (src.hasRequestingOrganization())
      tgt.setRequestingOrganization(Reference43_50.convertReference(src.getRequestingOrganization()));
    if (src.hasCostCenter())
      tgt.setCostCenter(Reference43_50.convertReference(src.getCostCenter()));
    if (src.hasQuantity())
      tgt.setQuantity(Quantity43_50.convertQuantity(src.getQuantity()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getBodysite())
      tgt.addBodysite(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasFactorOverride())
      tgt.setFactorOverrideElement(Decimal43_50.convertDecimal(src.getFactorOverrideElement()));
    if (src.hasPriceOverride())
      tgt.setPriceOverride(Money43_50.convertMoney(src.getPriceOverride()));
    if (src.hasOverrideReason())
      tgt.setOverrideReasonElement(String43_50.convertString(src.getOverrideReasonElement()));
    if (src.hasEnterer())
      tgt.setEnterer(Reference43_50.convertReference(src.getEnterer()));
    if (src.hasEnteredDate())
      tgt.setEnteredDateElement(DateTime43_50.convertDateTime(src.getEnteredDateElement()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getReason())
      tgt.addReason(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getService()) tgt.addService(Reference43_50.convertReference(t));
    if (src.hasProductCodeableConcept())
      tgt.addProduct().setConcept(CodeableConcept43_50.convertCodeableConcept(src.getProductCodeableConcept()));
    else if (src.hasProductReference())
      tgt.addProduct().setReference(Reference43_50.convertReference(src.getProductReference()));
    for (org.hl7.fhir.r4b.model.Reference t : src.getAccount()) tgt.addAccount(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r4b.model.Annotation t : src.getNote()) tgt.addNote(Annotation43_50.convertAnnotation(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getSupportingInformation())
      tgt.addSupportingInformation(Reference43_50.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ChargeItem convertChargeItem(org.hl7.fhir.r5.model.ChargeItem src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ChargeItem tgt = new org.hl7.fhir.r4b.model.ChargeItem();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    for (org.hl7.fhir.r5.model.UriType t : src.getDefinitionUri()) tgt.getDefinitionUri().add(Uri43_50.convertUri(t));
    for (org.hl7.fhir.r5.model.CanonicalType t : src.getDefinitionCanonical())
      tgt.getDefinitionCanonical().add(Canonical43_50.convertCanonical(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertChargeItemStatus(src.getStatusElement()));
    for (org.hl7.fhir.r5.model.Reference t : src.getPartOf()) tgt.addPartOf(Reference43_50.convertReference(t));
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_50.convertCodeableConcept(src.getCode()));
    if (src.hasSubject())
      tgt.setSubject(Reference43_50.convertReference(src.getSubject()));
    if (src.hasContext())
      tgt.setContext(Reference43_50.convertReference(src.getContext()));
    if (src.hasOccurrence())
      tgt.setOccurrence(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getOccurrence()));
    for (org.hl7.fhir.r5.model.ChargeItem.ChargeItemPerformerComponent t : src.getPerformer())
      tgt.addPerformer(convertChargeItemPerformerComponent(t));
    if (src.hasPerformingOrganization())
      tgt.setPerformingOrganization(Reference43_50.convertReference(src.getPerformingOrganization()));
    if (src.hasRequestingOrganization())
      tgt.setRequestingOrganization(Reference43_50.convertReference(src.getRequestingOrganization()));
    if (src.hasCostCenter())
      tgt.setCostCenter(Reference43_50.convertReference(src.getCostCenter()));
    if (src.hasQuantity())
      tgt.setQuantity(Quantity43_50.convertQuantity(src.getQuantity()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getBodysite())
      tgt.addBodysite(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasFactorOverride())
      tgt.setFactorOverrideElement(Decimal43_50.convertDecimal(src.getFactorOverrideElement()));
    if (src.hasPriceOverride())
      tgt.setPriceOverride(Money43_50.convertMoney(src.getPriceOverride()));
    if (src.hasOverrideReason())
      tgt.setOverrideReasonElement(String43_50.convertString(src.getOverrideReasonElement()));
    if (src.hasEnterer())
      tgt.setEnterer(Reference43_50.convertReference(src.getEnterer()));
    if (src.hasEnteredDate())
      tgt.setEnteredDateElement(DateTime43_50.convertDateTime(src.getEnteredDateElement()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getReason())
      tgt.addReason(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getService()) tgt.addService(Reference43_50.convertReference(t));
    if (src.getProductFirstRep().hasConcept())
      tgt.setProduct(CodeableConcept43_50.convertCodeableConcept(src.getProductFirstRep().getConcept()));
    if (src.getProductFirstRep().hasReference())
      tgt.setProduct(Reference43_50.convertReference(src.getProductFirstRep().getReference()));
    for (org.hl7.fhir.r5.model.Reference t : src.getAccount()) tgt.addAccount(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.addNote(Annotation43_50.convertAnnotation(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getSupportingInformation())
      tgt.addSupportingInformation(Reference43_50.convertReference(t));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ChargeItem.ChargeItemStatus> convertChargeItemStatus(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ChargeItem.ChargeItemStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ChargeItem.ChargeItemStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.ChargeItem.ChargeItemStatusEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ChargeItem.ChargeItemStatus> convertChargeItemStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ChargeItem.ChargeItemStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.ChargeItem.ChargeItemStatus> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.ChargeItem.ChargeItemStatusEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case PLANNED:
        tgt.setValue(org.hl7.fhir.r4b.model.ChargeItem.ChargeItemStatus.PLANNED);
        break;
      case BILLABLE:
        tgt.setValue(org.hl7.fhir.r4b.model.ChargeItem.ChargeItemStatus.BILLABLE);
        break;
      case NOTBILLABLE:
        tgt.setValue(org.hl7.fhir.r4b.model.ChargeItem.ChargeItemStatus.NOTBILLABLE);
        break;
      case ABORTED:
        tgt.setValue(org.hl7.fhir.r4b.model.ChargeItem.ChargeItemStatus.ABORTED);
        break;
      case BILLED:
        tgt.setValue(org.hl7.fhir.r4b.model.ChargeItem.ChargeItemStatus.BILLED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r4b.model.ChargeItem.ChargeItemStatus.ENTEREDINERROR);
        break;
      case UNKNOWN:
        tgt.setValue(org.hl7.fhir.r4b.model.ChargeItem.ChargeItemStatus.UNKNOWN);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.ChargeItem.ChargeItemStatus.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ChargeItem.ChargeItemPerformerComponent convertChargeItemPerformerComponent(org.hl7.fhir.r4b.model.ChargeItem.ChargeItemPerformerComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ChargeItem.ChargeItemPerformerComponent tgt = new org.hl7.fhir.r5.model.ChargeItem.ChargeItemPerformerComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasFunction())
      tgt.setFunction(CodeableConcept43_50.convertCodeableConcept(src.getFunction()));
    if (src.hasActor())
      tgt.setActor(Reference43_50.convertReference(src.getActor()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ChargeItem.ChargeItemPerformerComponent convertChargeItemPerformerComponent(org.hl7.fhir.r5.model.ChargeItem.ChargeItemPerformerComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ChargeItem.ChargeItemPerformerComponent tgt = new org.hl7.fhir.r4b.model.ChargeItem.ChargeItemPerformerComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasFunction())
      tgt.setFunction(CodeableConcept43_50.convertCodeableConcept(src.getFunction()));
    if (src.hasActor())
      tgt.setActor(Reference43_50.convertReference(src.getActor()));
    return tgt;
  }
}