package org.hl7.fhir.convertors.conv43_50.resources43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.CodeableConcept43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Identifier43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Quantity43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.DateTime43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.special43_50.Reference43_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CodeableReference;

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
public class SupplyRequest43_50 {

  public static org.hl7.fhir.r5.model.SupplyRequest convertSupplyRequest(org.hl7.fhir.r4b.model.SupplyRequest src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.SupplyRequest tgt = new org.hl7.fhir.r5.model.SupplyRequest();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertSupplyRequestStatus(src.getStatusElement()));
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept43_50.convertCodeableConcept(src.getCategory()));
    if (src.hasPriority())
      tgt.setPriorityElement(convertRequestPriority(src.getPriorityElement()));
    if (src.hasItem()) {
      if (src.hasItemCodeableConcept()) {
        tgt.getItem().setConcept(CodeableConcept43_50.convertCodeableConcept(src.getItemCodeableConcept()));
      } else {
        tgt.getItem().setReference(Reference43_50.convertReference(src.getItemReference()));
      }
    }
    if (src.hasQuantity())
      tgt.setQuantity(Quantity43_50.convertQuantity(src.getQuantity()));
    for (org.hl7.fhir.r4b.model.SupplyRequest.SupplyRequestParameterComponent t : src.getParameter())
      tgt.addParameter(convertSupplyRequestParameterComponent(t));
    if (src.hasOccurrence())
      tgt.setOccurrence(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getOccurrence()));
    if (src.hasAuthoredOn())
      tgt.setAuthoredOnElement(DateTime43_50.convertDateTime(src.getAuthoredOnElement()));
    if (src.hasRequester())
      tgt.setRequester(Reference43_50.convertReference(src.getRequester()));
    for (org.hl7.fhir.r4b.model.Reference t : src.getSupplier()) tgt.addSupplier(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getReasonCode())
      tgt.addReason(CodeableConcept43_50.convertCodeableConceptToCodeableReference(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getReasonReference())
      tgt.addReason(Reference43_50.convertReferenceToCodeableReference(t));
    if (src.hasDeliverFrom())
      tgt.setDeliverFrom(Reference43_50.convertReference(src.getDeliverFrom()));
    if (src.hasDeliverTo())
      tgt.setDeliverTo(Reference43_50.convertReference(src.getDeliverTo()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.SupplyRequest convertSupplyRequest(org.hl7.fhir.r5.model.SupplyRequest src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.SupplyRequest tgt = new org.hl7.fhir.r4b.model.SupplyRequest();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertSupplyRequestStatus(src.getStatusElement()));
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept43_50.convertCodeableConcept(src.getCategory()));
    if (src.hasPriority())
      tgt.setPriorityElement(convertRequestPriority(src.getPriorityElement()));
    if (src.hasItem()) {
      if (src.getItem().hasReference()) {
        tgt.setItem(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getItem().getReference()));
      } else {
        tgt.setItem(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getItem().getConcept()));
      }
    }
    if (src.hasQuantity())
      tgt.setQuantity(Quantity43_50.convertQuantity(src.getQuantity()));
    for (org.hl7.fhir.r5.model.SupplyRequest.SupplyRequestParameterComponent t : src.getParameter())
      tgt.addParameter(convertSupplyRequestParameterComponent(t));
    if (src.hasOccurrence())
      tgt.setOccurrence(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getOccurrence()));
    if (src.hasAuthoredOn())
      tgt.setAuthoredOnElement(DateTime43_50.convertDateTime(src.getAuthoredOnElement()));
    if (src.hasRequester())
      tgt.setRequester(Reference43_50.convertReference(src.getRequester()));
    for (org.hl7.fhir.r5.model.Reference t : src.getSupplier()) tgt.addSupplier(Reference43_50.convertReference(t));
    for (CodeableReference t : src.getReason())
      if (t.hasConcept())
        tgt.addReasonCode(CodeableConcept43_50.convertCodeableConcept(t.getConcept()));
    for (CodeableReference t : src.getReason())
      if (t.hasReference())
        tgt.addReasonReference(Reference43_50.convertReference(t.getReference()));
    if (src.hasDeliverFrom())
      tgt.setDeliverFrom(Reference43_50.convertReference(src.getDeliverFrom()));
    if (src.hasDeliverTo())
      tgt.setDeliverTo(Reference43_50.convertReference(src.getDeliverTo()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.SupplyRequest.SupplyRequestStatus> convertSupplyRequestStatus(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.SupplyRequest.SupplyRequestStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.SupplyRequest.SupplyRequestStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.SupplyRequest.SupplyRequestStatusEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case DRAFT:
        tgt.setValue(org.hl7.fhir.r5.model.SupplyRequest.SupplyRequestStatus.DRAFT);
        break;
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.r5.model.SupplyRequest.SupplyRequestStatus.ACTIVE);
        break;
      case SUSPENDED:
        tgt.setValue(org.hl7.fhir.r5.model.SupplyRequest.SupplyRequestStatus.SUSPENDED);
        break;
      case CANCELLED:
        tgt.setValue(org.hl7.fhir.r5.model.SupplyRequest.SupplyRequestStatus.CANCELLED);
        break;
      case COMPLETED:
        tgt.setValue(org.hl7.fhir.r5.model.SupplyRequest.SupplyRequestStatus.COMPLETED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r5.model.SupplyRequest.SupplyRequestStatus.ENTEREDINERROR);
        break;
      case UNKNOWN:
        tgt.setValue(org.hl7.fhir.r5.model.SupplyRequest.SupplyRequestStatus.UNKNOWN);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.SupplyRequest.SupplyRequestStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.SupplyRequest.SupplyRequestStatus> convertSupplyRequestStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.SupplyRequest.SupplyRequestStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.SupplyRequest.SupplyRequestStatus> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.SupplyRequest.SupplyRequestStatusEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case DRAFT:
        tgt.setValue(org.hl7.fhir.r4b.model.SupplyRequest.SupplyRequestStatus.DRAFT);
        break;
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.r4b.model.SupplyRequest.SupplyRequestStatus.ACTIVE);
        break;
      case SUSPENDED:
        tgt.setValue(org.hl7.fhir.r4b.model.SupplyRequest.SupplyRequestStatus.SUSPENDED);
        break;
      case CANCELLED:
        tgt.setValue(org.hl7.fhir.r4b.model.SupplyRequest.SupplyRequestStatus.CANCELLED);
        break;
      case COMPLETED:
        tgt.setValue(org.hl7.fhir.r4b.model.SupplyRequest.SupplyRequestStatus.COMPLETED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r4b.model.SupplyRequest.SupplyRequestStatus.ENTEREDINERROR);
        break;
      case UNKNOWN:
        tgt.setValue(org.hl7.fhir.r4b.model.SupplyRequest.SupplyRequestStatus.UNKNOWN);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.SupplyRequest.SupplyRequestStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestPriority> convertRequestPriority(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.RequestPriority> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestPriority> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.RequestPriorityEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case ROUTINE:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestPriority.ROUTINE);
        break;
      case URGENT:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestPriority.URGENT);
        break;
      case ASAP:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestPriority.ASAP);
        break;
      case STAT:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestPriority.STAT);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestPriority.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.RequestPriority> convertRequestPriority(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestPriority> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.RequestPriority> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.RequestPriorityEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case ROUTINE:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestPriority.ROUTINE);
        break;
      case URGENT:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestPriority.URGENT);
        break;
      case ASAP:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestPriority.ASAP);
        break;
      case STAT:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestPriority.STAT);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestPriority.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.SupplyRequest.SupplyRequestParameterComponent convertSupplyRequestParameterComponent(org.hl7.fhir.r4b.model.SupplyRequest.SupplyRequestParameterComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.SupplyRequest.SupplyRequestParameterComponent tgt = new org.hl7.fhir.r5.model.SupplyRequest.SupplyRequestParameterComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_50.convertCodeableConcept(src.getCode()));
    if (src.hasValue())
      tgt.setValue(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getValue()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.SupplyRequest.SupplyRequestParameterComponent convertSupplyRequestParameterComponent(org.hl7.fhir.r5.model.SupplyRequest.SupplyRequestParameterComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.SupplyRequest.SupplyRequestParameterComponent tgt = new org.hl7.fhir.r4b.model.SupplyRequest.SupplyRequestParameterComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_50.convertCodeableConcept(src.getCode()));
    if (src.hasValue())
      tgt.setValue(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getValue()));
    return tgt;
  }
}