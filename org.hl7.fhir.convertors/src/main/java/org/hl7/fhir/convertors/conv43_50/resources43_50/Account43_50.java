package org.hl7.fhir.convertors.conv43_50.resources43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.CodeableConcept43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Identifier43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Period43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Boolean43_50;
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
public class Account43_50 {

  public static org.hl7.fhir.r5.model.Account convertAccount(org.hl7.fhir.r4b.model.Account src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Account tgt = new org.hl7.fhir.r5.model.Account();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertAccountStatus(src.getStatusElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
    if (src.hasName())
      tgt.setNameElement(String43_50.convertString(src.getNameElement()));
    for (org.hl7.fhir.r4b.model.Reference t : src.getSubject()) tgt.addSubject(Reference43_50.convertReference(t));
    if (src.hasServicePeriod())
      tgt.setServicePeriod(Period43_50.convertPeriod(src.getServicePeriod()));
    for (org.hl7.fhir.r4b.model.Account.CoverageComponent t : src.getCoverage())
      tgt.addCoverage(convertCoverageComponent(t));
    if (src.hasOwner())
      tgt.setOwner(Reference43_50.convertReference(src.getOwner()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_50.convertStringToMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r4b.model.Account.GuarantorComponent t : src.getGuarantor())
      tgt.addGuarantor(convertGuarantorComponent(t));
//    if (src.hasPartOf())
//      tgt.setPartOf(Reference43_50.convertReference(src.getPartOf()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Account convertAccount(org.hl7.fhir.r5.model.Account src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Account tgt = new org.hl7.fhir.r4b.model.Account();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertAccountStatus(src.getStatusElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
    if (src.hasName())
      tgt.setNameElement(String43_50.convertString(src.getNameElement()));
    for (org.hl7.fhir.r5.model.Reference t : src.getSubject()) tgt.addSubject(Reference43_50.convertReference(t));
    if (src.hasServicePeriod())
      tgt.setServicePeriod(Period43_50.convertPeriod(src.getServicePeriod()));
    for (org.hl7.fhir.r5.model.Account.CoverageComponent t : src.getCoverage())
      tgt.addCoverage(convertCoverageComponent(t));
    if (src.hasOwner())
      tgt.setOwner(Reference43_50.convertReference(src.getOwner()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_50.convertString(src.getDescriptionElement()));
    for (org.hl7.fhir.r5.model.Account.GuarantorComponent t : src.getGuarantor())
      tgt.addGuarantor(convertGuarantorComponent(t));
//    if (src.hasPartOf())
//      tgt.setPartOf(Reference43_50.convertReference(src.getPartOf()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Account.AccountStatus> convertAccountStatus(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Account.AccountStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Account.AccountStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Account.AccountStatusEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.r5.model.Account.AccountStatus.ACTIVE);
        break;
      case INACTIVE:
        tgt.setValue(org.hl7.fhir.r5.model.Account.AccountStatus.INACTIVE);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r5.model.Account.AccountStatus.ENTEREDINERROR);
        break;
      case ONHOLD:
        tgt.setValue(org.hl7.fhir.r5.model.Account.AccountStatus.ONHOLD);
        break;
      case UNKNOWN:
        tgt.setValue(org.hl7.fhir.r5.model.Account.AccountStatus.UNKNOWN);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.Account.AccountStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Account.AccountStatus> convertAccountStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Account.AccountStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Account.AccountStatus> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Account.AccountStatusEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.r4b.model.Account.AccountStatus.ACTIVE);
        break;
      case INACTIVE:
        tgt.setValue(org.hl7.fhir.r4b.model.Account.AccountStatus.INACTIVE);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r4b.model.Account.AccountStatus.ENTEREDINERROR);
        break;
      case ONHOLD:
        tgt.setValue(org.hl7.fhir.r4b.model.Account.AccountStatus.ONHOLD);
        break;
      case UNKNOWN:
        tgt.setValue(org.hl7.fhir.r4b.model.Account.AccountStatus.UNKNOWN);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.Account.AccountStatus.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Account.CoverageComponent convertCoverageComponent(org.hl7.fhir.r4b.model.Account.CoverageComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Account.CoverageComponent tgt = new org.hl7.fhir.r5.model.Account.CoverageComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasCoverage())
      tgt.setCoverage(Reference43_50.convertReference(src.getCoverage()));
    if (src.hasPriority())
      tgt.setPriorityElement(PositiveInt43_50.convertPositiveInt(src.getPriorityElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Account.CoverageComponent convertCoverageComponent(org.hl7.fhir.r5.model.Account.CoverageComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Account.CoverageComponent tgt = new org.hl7.fhir.r4b.model.Account.CoverageComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasCoverage())
      tgt.setCoverage(Reference43_50.convertReference(src.getCoverage()));
    if (src.hasPriority())
      tgt.setPriorityElement(PositiveInt43_50.convertPositiveInt(src.getPriorityElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Account.GuarantorComponent convertGuarantorComponent(org.hl7.fhir.r4b.model.Account.GuarantorComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Account.GuarantorComponent tgt = new org.hl7.fhir.r5.model.Account.GuarantorComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasParty())
      tgt.setParty(Reference43_50.convertReference(src.getParty()));
    if (src.hasOnHold())
      tgt.setOnHoldElement(Boolean43_50.convertBoolean(src.getOnHoldElement()));
    if (src.hasPeriod())
      tgt.setPeriod(Period43_50.convertPeriod(src.getPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Account.GuarantorComponent convertGuarantorComponent(org.hl7.fhir.r5.model.Account.GuarantorComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Account.GuarantorComponent tgt = new org.hl7.fhir.r4b.model.Account.GuarantorComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasParty())
      tgt.setParty(Reference43_50.convertReference(src.getParty()));
    if (src.hasOnHold())
      tgt.setOnHoldElement(Boolean43_50.convertBoolean(src.getOnHoldElement()));
    if (src.hasPeriod())
      tgt.setPeriod(Period43_50.convertPeriod(src.getPeriod()));
    return tgt;
  }
}