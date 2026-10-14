package org.hl7.fhir.convertors.conv43_N.resources43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.CodeableConcept43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Identifier43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Period43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Boolean43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.PositiveInt43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.String43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.special43_N.Reference43_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.Account;
import org.hl7.fhir.model.core.Enumeration;

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

public class Account43_N {

  public static org.hl7.fhir.model.core.Account convertAccount(org.hl7.fhir.r4b.model.Account src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Account tgt = new org.hl7.fhir.model.core.Account();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertAccountStatus(src.getStatusElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept43_N.convertCodeableConcept(src.getType()));
    if (src.hasName())
      tgt.setNameElement(String43_N.convertString(src.getNameElement()));
    for (org.hl7.fhir.r4b.model.Reference t : src.getSubject()) tgt.addSubject(Reference43_N.convertReference(t));
    if (src.hasServicePeriod())
      tgt.setServicePeriod(Period43_N.convertPeriod(src.getServicePeriod()));
    for (org.hl7.fhir.r4b.model.Account.CoverageComponent t : src.getCoverage())
      tgt.addCoverage(convertCoverageComponent(t));
    if (src.hasOwner())
      tgt.setOwner(Reference43_N.convertReference(src.getOwner()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_N.convertStringToMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r4b.model.Account.GuarantorComponent t : src.getGuarantor())
      tgt.addGuarantor(convertGuarantorComponent(t));
//    if (src.hasPartOf())
//      tgt.setPartOf(Reference43_N.convertReference(src.getPartOf()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Account convertAccount(org.hl7.fhir.model.core.Account src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Account tgt = new org.hl7.fhir.r4b.model.Account();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertAccountStatus(src.getStatusElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept43_N.convertCodeableConcept(src.getType()));
    if (src.hasName())
      tgt.setNameElement(String43_N.convertString(src.getNameElement()));
    for (org.hl7.fhir.model.core.Reference t : src.getSubjectList()) tgt.addSubject(Reference43_N.convertReference(t));
    if (src.hasServicePeriod())
      tgt.setServicePeriod(Period43_N.convertPeriod(src.getServicePeriod()));
    for (org.hl7.fhir.model.core.Account.CoverageComponent t : src.getCoverageList())
      tgt.addCoverage(convertCoverageComponent(t));
    if (src.hasOwner())
      tgt.setOwner(Reference43_N.convertReference(src.getOwner()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_N.convertString(src.getDescriptionElement()));
    for (org.hl7.fhir.model.core.Account.GuarantorComponent t : src.getGuarantorList())
      tgt.addGuarantor(convertGuarantorComponent(t));
//    if (src.hasPartOf())
//      tgt.setPartOf(Reference43_N.convertReference(src.getPartOf()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Account.AccountStatus> convertAccountStatus(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Account.AccountStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Account.AccountStatus> tgt = new Enumeration<>(new Account.AccountStatusEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case ACTIVE:
                  tgt.setValue(Account.AccountStatus.ACTIVE);
                  break;
              case INACTIVE:
                  tgt.setValue(Account.AccountStatus.INACTIVE);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(Account.AccountStatus.ENTEREDINERROR);
                  break;
              case ONHOLD:
                  tgt.setValue(Account.AccountStatus.ONHOLD);
                  break;
              case UNKNOWN:
                  tgt.setValue(Account.AccountStatus.UNKNOWN);
                  break;
              default:
                  tgt.setValue(Account.AccountStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Account.AccountStatus> convertAccountStatus(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Account.AccountStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Account.AccountStatus> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Account.AccountStatusEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
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
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.Account.CoverageComponent convertCoverageComponent(org.hl7.fhir.r4b.model.Account.CoverageComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Account.CoverageComponent tgt = new org.hl7.fhir.model.core.Account.CoverageComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasCoverage())
      tgt.setCoverage(Reference43_N.convertReference(src.getCoverage()));
    if (src.hasPriority())
      tgt.setPriorityElement(PositiveInt43_N.convertPositiveInt(src.getPriorityElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Account.CoverageComponent convertCoverageComponent(org.hl7.fhir.model.core.Account.CoverageComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Account.CoverageComponent tgt = new org.hl7.fhir.r4b.model.Account.CoverageComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasCoverage())
      tgt.setCoverage(Reference43_N.convertReference(src.getCoverage()));
    if (src.hasPriority())
      tgt.setPriorityElement(PositiveInt43_N.convertPositiveInt(src.getPriorityElement()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.Account.GuarantorComponent convertGuarantorComponent(org.hl7.fhir.r4b.model.Account.GuarantorComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Account.GuarantorComponent tgt = new org.hl7.fhir.model.core.Account.GuarantorComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasParty())
      tgt.setParty(Reference43_N.convertReference(src.getParty()));
    if (src.hasOnHold())
      tgt.setOnHoldElement(Boolean43_N.convertBoolean(src.getOnHoldElement()));
    if (src.hasPeriod())
      tgt.setPeriod(Period43_N.convertPeriod(src.getPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Account.GuarantorComponent convertGuarantorComponent(org.hl7.fhir.model.core.Account.GuarantorComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Account.GuarantorComponent tgt = new org.hl7.fhir.r4b.model.Account.GuarantorComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasParty())
      tgt.setParty(Reference43_N.convertReference(src.getParty()));
    if (src.hasOnHold())
      tgt.setOnHoldElement(Boolean43_N.convertBoolean(src.getOnHoldElement()));
    if (src.hasPeriod())
      tgt.setPeriod(Period43_N.convertPeriod(src.getPeriod()));
    return tgt;
  }
}