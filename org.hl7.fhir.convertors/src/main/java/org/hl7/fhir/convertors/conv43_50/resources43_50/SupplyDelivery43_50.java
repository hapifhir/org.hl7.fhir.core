package org.hl7.fhir.convertors.conv43_50.resources43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.CodeableConcept43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Identifier43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.SimpleQuantity43_50;
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
public class SupplyDelivery43_50 {

  public static org.hl7.fhir.r5.model.SupplyDelivery convertSupplyDelivery(org.hl7.fhir.r4b.model.SupplyDelivery src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.SupplyDelivery tgt = new org.hl7.fhir.r5.model.SupplyDelivery();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getBasedOn()) tgt.addBasedOn(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getPartOf()) tgt.addPartOf(Reference43_50.convertReference(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertSupplyDeliveryStatus(src.getStatusElement()));
    if (src.hasPatient())
      tgt.setPatient(Reference43_50.convertReference(src.getPatient()));
    if (src.hasType())
      tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
    if (src.hasSuppliedItem())
      tgt.setSuppliedItem(convertSupplyDeliverySuppliedItemComponent(src.getSuppliedItem()));
    if (src.hasOccurrence())
      tgt.setOccurrence(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getOccurrence()));
    if (src.hasSupplier())
      tgt.setSupplier(Reference43_50.convertReference(src.getSupplier()));
    if (src.hasDestination())
      tgt.setDestination(Reference43_50.convertReference(src.getDestination()));
    for (org.hl7.fhir.r4b.model.Reference t : src.getReceiver()) tgt.addReceiver(Reference43_50.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.SupplyDelivery convertSupplyDelivery(org.hl7.fhir.r5.model.SupplyDelivery src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.SupplyDelivery tgt = new org.hl7.fhir.r4b.model.SupplyDelivery();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getBasedOn()) tgt.addBasedOn(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getPartOf()) tgt.addPartOf(Reference43_50.convertReference(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertSupplyDeliveryStatus(src.getStatusElement()));
    if (src.hasPatient())
      tgt.setPatient(Reference43_50.convertReference(src.getPatient()));
    if (src.hasType())
      tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
    if (src.hasSuppliedItem())
      tgt.setSuppliedItem(convertSupplyDeliverySuppliedItemComponent(src.getSuppliedItem()));
    if (src.hasOccurrence())
      tgt.setOccurrence(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getOccurrence()));
    if (src.hasSupplier())
      tgt.setSupplier(Reference43_50.convertReference(src.getSupplier()));
    if (src.hasDestination())
      tgt.setDestination(Reference43_50.convertReference(src.getDestination()));
    for (org.hl7.fhir.r5.model.Reference t : src.getReceiver()) tgt.addReceiver(Reference43_50.convertReference(t));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.SupplyDelivery.SupplyDeliveryStatus> convertSupplyDeliveryStatus(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.SupplyDelivery.SupplyDeliveryStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.SupplyDelivery.SupplyDeliveryStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.SupplyDelivery.SupplyDeliveryStatusEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case INPROGRESS:
        tgt.setValue(org.hl7.fhir.r5.model.SupplyDelivery.SupplyDeliveryStatus.INPROGRESS);
        break;
      case COMPLETED:
        tgt.setValue(org.hl7.fhir.r5.model.SupplyDelivery.SupplyDeliveryStatus.COMPLETED);
        break;
      case ABANDONED:
        tgt.setValue(org.hl7.fhir.r5.model.SupplyDelivery.SupplyDeliveryStatus.ABANDONED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r5.model.SupplyDelivery.SupplyDeliveryStatus.ENTEREDINERROR);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.SupplyDelivery.SupplyDeliveryStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.SupplyDelivery.SupplyDeliveryStatus> convertSupplyDeliveryStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.SupplyDelivery.SupplyDeliveryStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.SupplyDelivery.SupplyDeliveryStatus> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.SupplyDelivery.SupplyDeliveryStatusEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case INPROGRESS:
        tgt.setValue(org.hl7.fhir.r4b.model.SupplyDelivery.SupplyDeliveryStatus.INPROGRESS);
        break;
      case COMPLETED:
        tgt.setValue(org.hl7.fhir.r4b.model.SupplyDelivery.SupplyDeliveryStatus.COMPLETED);
        break;
      case ABANDONED:
        tgt.setValue(org.hl7.fhir.r4b.model.SupplyDelivery.SupplyDeliveryStatus.ABANDONED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r4b.model.SupplyDelivery.SupplyDeliveryStatus.ENTEREDINERROR);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.SupplyDelivery.SupplyDeliveryStatus.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.SupplyDelivery.SupplyDeliverySuppliedItemComponent convertSupplyDeliverySuppliedItemComponent(org.hl7.fhir.r4b.model.SupplyDelivery.SupplyDeliverySuppliedItemComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.SupplyDelivery.SupplyDeliverySuppliedItemComponent tgt = new org.hl7.fhir.r5.model.SupplyDelivery.SupplyDeliverySuppliedItemComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity43_50.convertSimpleQuantity(src.getQuantity()));
    if (src.hasItem())
      tgt.setItem(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getItem()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.SupplyDelivery.SupplyDeliverySuppliedItemComponent convertSupplyDeliverySuppliedItemComponent(org.hl7.fhir.r5.model.SupplyDelivery.SupplyDeliverySuppliedItemComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.SupplyDelivery.SupplyDeliverySuppliedItemComponent tgt = new org.hl7.fhir.r4b.model.SupplyDelivery.SupplyDeliverySuppliedItemComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity43_50.convertSimpleQuantity(src.getQuantity()));
    if (src.hasItem())
      tgt.setItem(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getItem()));
    return tgt;
  }
}