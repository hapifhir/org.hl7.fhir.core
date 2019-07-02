package org.hl7.fhir.convertors.conv40_50;

/*-
 * #%L
 * org.hl7.fhir.convertors
 * %%
 * Copyright (C) 2014 - 2019 Health Level 7
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */


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


public class Account extends VersionConvertor_40_50 {

  public static org.hl7.fhir.r5.model.Account convertAccount(org.hl7.fhir.r4.model.Account src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Account tgt = new org.hl7.fhir.r5.model.Account();
    copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatus(convertAccountStatus(src.getStatus()));
    if (src.hasType())
      tgt.setType(convertCodeableConcept(src.getType()));
    if (src.hasName())
      tgt.setNameElement(convertString(src.getNameElement()));
    for (org.hl7.fhir.r4.model.Reference t : src.getSubject())
      tgt.addSubject(convertReference(t));
    if (src.hasServicePeriod())
      tgt.setServicePeriod(convertPeriod(src.getServicePeriod()));
    for (org.hl7.fhir.r4.model.Account.CoverageComponent t : src.getCoverage())
      tgt.addCoverage(convertCoverageComponent(t));
    if (src.hasOwner())
      tgt.setOwner(convertReference(src.getOwner()));
    if (src.hasDescription())
      tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
    for (org.hl7.fhir.r4.model.Account.GuarantorComponent t : src.getGuarantor())
      tgt.addGuarantor(convertGuarantorComponent(t));
    if (src.hasPartOf())
      tgt.setPartOf(convertReference(src.getPartOf()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Account convertAccount(org.hl7.fhir.r5.model.Account src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Account tgt = new org.hl7.fhir.r4.model.Account();
    copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatus(convertAccountStatus(src.getStatus()));
    if (src.hasType())
      tgt.setType(convertCodeableConcept(src.getType()));
    if (src.hasName())
      tgt.setNameElement(convertString(src.getNameElement()));
    for (org.hl7.fhir.r5.model.Reference t : src.getSubject())
      tgt.addSubject(convertReference(t));
    if (src.hasServicePeriod())
      tgt.setServicePeriod(convertPeriod(src.getServicePeriod()));
    for (org.hl7.fhir.r5.model.Account.CoverageComponent t : src.getCoverage())
      tgt.addCoverage(convertCoverageComponent(t));
    if (src.hasOwner())
      tgt.setOwner(convertReference(src.getOwner()));
    if (src.hasDescription())
      tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
    for (org.hl7.fhir.r5.model.Account.GuarantorComponent t : src.getGuarantor())
      tgt.addGuarantor(convertGuarantorComponent(t));
    if (src.hasPartOf())
      tgt.setPartOf(convertReference(src.getPartOf()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Account.AccountStatus convertAccountStatus(org.hl7.fhir.r4.model.Account.AccountStatus src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case ACTIVE: return org.hl7.fhir.r5.model.Account.AccountStatus.ACTIVE;
    case INACTIVE: return org.hl7.fhir.r5.model.Account.AccountStatus.INACTIVE;
    case ENTEREDINERROR: return org.hl7.fhir.r5.model.Account.AccountStatus.ENTEREDINERROR;
    case ONHOLD: return org.hl7.fhir.r5.model.Account.AccountStatus.ONHOLD;
    case UNKNOWN: return org.hl7.fhir.r5.model.Account.AccountStatus.UNKNOWN;
    default: return org.hl7.fhir.r5.model.Account.AccountStatus.NULL;
  }
}

  public static org.hl7.fhir.r4.model.Account.AccountStatus convertAccountStatus(org.hl7.fhir.r5.model.Account.AccountStatus src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case ACTIVE: return org.hl7.fhir.r4.model.Account.AccountStatus.ACTIVE;
    case INACTIVE: return org.hl7.fhir.r4.model.Account.AccountStatus.INACTIVE;
    case ENTEREDINERROR: return org.hl7.fhir.r4.model.Account.AccountStatus.ENTEREDINERROR;
    case ONHOLD: return org.hl7.fhir.r4.model.Account.AccountStatus.ONHOLD;
    case UNKNOWN: return org.hl7.fhir.r4.model.Account.AccountStatus.UNKNOWN;
    default: return org.hl7.fhir.r4.model.Account.AccountStatus.NULL;
  }
}

  public static org.hl7.fhir.r5.model.Account.CoverageComponent convertCoverageComponent(org.hl7.fhir.r4.model.Account.CoverageComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Account.CoverageComponent tgt = new org.hl7.fhir.r5.model.Account.CoverageComponent();
    copyElement(src, tgt);
    if (src.hasCoverage())
      tgt.setCoverage(convertReference(src.getCoverage()));
    if (src.hasPriority())
      tgt.setPriorityElement(convertPositiveInt(src.getPriorityElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Account.CoverageComponent convertCoverageComponent(org.hl7.fhir.r5.model.Account.CoverageComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Account.CoverageComponent tgt = new org.hl7.fhir.r4.model.Account.CoverageComponent();
    copyElement(src, tgt);
    if (src.hasCoverage())
      tgt.setCoverage(convertReference(src.getCoverage()));
    if (src.hasPriority())
      tgt.setPriorityElement(convertPositiveInt(src.getPriorityElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Account.GuarantorComponent convertGuarantorComponent(org.hl7.fhir.r4.model.Account.GuarantorComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Account.GuarantorComponent tgt = new org.hl7.fhir.r5.model.Account.GuarantorComponent();
    copyElement(src, tgt);
    if (src.hasParty())
      tgt.setParty(convertReference(src.getParty()));
    if (src.hasOnHold())
      tgt.setOnHoldElement(convertBoolean(src.getOnHoldElement()));
    if (src.hasPeriod())
      tgt.setPeriod(convertPeriod(src.getPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Account.GuarantorComponent convertGuarantorComponent(org.hl7.fhir.r5.model.Account.GuarantorComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Account.GuarantorComponent tgt = new org.hl7.fhir.r4.model.Account.GuarantorComponent();
    copyElement(src, tgt);
    if (src.hasParty())
      tgt.setParty(convertReference(src.getParty()));
    if (src.hasOnHold())
      tgt.setOnHoldElement(convertBoolean(src.getOnHoldElement()));
    if (src.hasPeriod())
      tgt.setPeriod(convertPeriod(src.getPeriod()));
    return tgt;
  }


}
