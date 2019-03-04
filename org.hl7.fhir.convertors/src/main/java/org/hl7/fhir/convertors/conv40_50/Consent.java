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


public class Consent extends VersionConvertor_40_50 {

  public static org.hl7.fhir.r5.model.Consent convertConsent(org.hl7.fhir.r4.model.Consent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Consent tgt = new org.hl7.fhir.r5.model.Consent();
    copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatus(convertConsentState(src.getStatus()));
    if (src.hasScope())
      tgt.setScope(convertCodeableConcept(src.getScope()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(convertCodeableConcept(t));
    if (src.hasPatient())
      tgt.setPatient(convertReference(src.getPatient()));
    if (src.hasDateTime())
      tgt.setDateTimeElement(convertDateTime(src.getDateTimeElement()));
    for (org.hl7.fhir.r4.model.Reference t : src.getPerformer())
      tgt.addPerformer(convertReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getOrganization())
      tgt.addOrganization(convertReference(t));
    if (src.hasSource())
      tgt.setSource(convertType(src.getSource()));
    for (org.hl7.fhir.r4.model.Consent.ConsentPolicyComponent t : src.getPolicy())
      tgt.addPolicy(convertConsentPolicyComponent(t));
    if (src.hasPolicyRule())
      tgt.setPolicyRule(convertCodeableConcept(src.getPolicyRule()));
    for (org.hl7.fhir.r4.model.Consent.ConsentVerificationComponent t : src.getVerification())
      tgt.addVerification(convertConsentVerificationComponent(t));
    if (src.hasProvision())
      tgt.setProvision(convertprovisionComponent(src.getProvision()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Consent convertConsent(org.hl7.fhir.r5.model.Consent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Consent tgt = new org.hl7.fhir.r4.model.Consent();
    copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatus(convertConsentState(src.getStatus()));
    if (src.hasScope())
      tgt.setScope(convertCodeableConcept(src.getScope()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(convertCodeableConcept(t));
    if (src.hasPatient())
      tgt.setPatient(convertReference(src.getPatient()));
    if (src.hasDateTime())
      tgt.setDateTimeElement(convertDateTime(src.getDateTimeElement()));
    for (org.hl7.fhir.r5.model.Reference t : src.getPerformer())
      tgt.addPerformer(convertReference(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getOrganization())
      tgt.addOrganization(convertReference(t));
    if (src.hasSource())
      tgt.setSource(convertType(src.getSource()));
    for (org.hl7.fhir.r5.model.Consent.ConsentPolicyComponent t : src.getPolicy())
      tgt.addPolicy(convertConsentPolicyComponent(t));
    if (src.hasPolicyRule())
      tgt.setPolicyRule(convertCodeableConcept(src.getPolicyRule()));
    for (org.hl7.fhir.r5.model.Consent.ConsentVerificationComponent t : src.getVerification())
      tgt.addVerification(convertConsentVerificationComponent(t));
    if (src.hasProvision())
      tgt.setProvision(convertprovisionComponent(src.getProvision()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Consent.ConsentState convertConsentState(org.hl7.fhir.r4.model.Consent.ConsentState src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case DRAFT: return org.hl7.fhir.r5.model.Consent.ConsentState.DRAFT;
    case PROPOSED: return org.hl7.fhir.r5.model.Consent.ConsentState.PROPOSED;
    case ACTIVE: return org.hl7.fhir.r5.model.Consent.ConsentState.ACTIVE;
    case REJECTED: return org.hl7.fhir.r5.model.Consent.ConsentState.REJECTED;
    case INACTIVE: return org.hl7.fhir.r5.model.Consent.ConsentState.INACTIVE;
    case ENTEREDINERROR: return org.hl7.fhir.r5.model.Consent.ConsentState.ENTEREDINERROR;
    default: return org.hl7.fhir.r5.model.Consent.ConsentState.NULL;
  }
}

  public static org.hl7.fhir.r4.model.Consent.ConsentState convertConsentState(org.hl7.fhir.r5.model.Consent.ConsentState src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case DRAFT: return org.hl7.fhir.r4.model.Consent.ConsentState.DRAFT;
    case PROPOSED: return org.hl7.fhir.r4.model.Consent.ConsentState.PROPOSED;
    case ACTIVE: return org.hl7.fhir.r4.model.Consent.ConsentState.ACTIVE;
    case REJECTED: return org.hl7.fhir.r4.model.Consent.ConsentState.REJECTED;
    case INACTIVE: return org.hl7.fhir.r4.model.Consent.ConsentState.INACTIVE;
    case ENTEREDINERROR: return org.hl7.fhir.r4.model.Consent.ConsentState.ENTEREDINERROR;
    default: return org.hl7.fhir.r4.model.Consent.ConsentState.NULL;
  }
}

  public static org.hl7.fhir.r5.model.Consent.ConsentPolicyComponent convertConsentPolicyComponent(org.hl7.fhir.r4.model.Consent.ConsentPolicyComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Consent.ConsentPolicyComponent tgt = new org.hl7.fhir.r5.model.Consent.ConsentPolicyComponent();
    copyElement(src, tgt);
    if (src.hasAuthority())
      tgt.setAuthorityElement(convertUri(src.getAuthorityElement()));
    if (src.hasUri())
      tgt.setUriElement(convertUri(src.getUriElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Consent.ConsentPolicyComponent convertConsentPolicyComponent(org.hl7.fhir.r5.model.Consent.ConsentPolicyComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Consent.ConsentPolicyComponent tgt = new org.hl7.fhir.r4.model.Consent.ConsentPolicyComponent();
    copyElement(src, tgt);
    if (src.hasAuthority())
      tgt.setAuthorityElement(convertUri(src.getAuthorityElement()));
    if (src.hasUri())
      tgt.setUriElement(convertUri(src.getUriElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Consent.ConsentVerificationComponent convertConsentVerificationComponent(org.hl7.fhir.r4.model.Consent.ConsentVerificationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Consent.ConsentVerificationComponent tgt = new org.hl7.fhir.r5.model.Consent.ConsentVerificationComponent();
    copyElement(src, tgt);
    if (src.hasVerified())
      tgt.setVerifiedElement(convertBoolean(src.getVerifiedElement()));
    if (src.hasVerifiedWith())
      tgt.setVerifiedWith(convertReference(src.getVerifiedWith()));
    if (src.hasVerificationDate())
      tgt.setVerificationDateElement(convertDateTime(src.getVerificationDateElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Consent.ConsentVerificationComponent convertConsentVerificationComponent(org.hl7.fhir.r5.model.Consent.ConsentVerificationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Consent.ConsentVerificationComponent tgt = new org.hl7.fhir.r4.model.Consent.ConsentVerificationComponent();
    copyElement(src, tgt);
    if (src.hasVerified())
      tgt.setVerifiedElement(convertBoolean(src.getVerifiedElement()));
    if (src.hasVerifiedWith())
      tgt.setVerifiedWith(convertReference(src.getVerifiedWith()));
    if (src.hasVerificationDate())
      tgt.setVerificationDateElement(convertDateTime(src.getVerificationDateElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Consent.provisionComponent convertprovisionComponent(org.hl7.fhir.r4.model.Consent.provisionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Consent.provisionComponent tgt = new org.hl7.fhir.r5.model.Consent.provisionComponent();
    copyElement(src, tgt);
    if (src.hasType())
      tgt.setType(convertConsentProvisionType(src.getType()));
    if (src.hasPeriod())
      tgt.setPeriod(convertPeriod(src.getPeriod()));
    for (org.hl7.fhir.r4.model.Consent.provisionActorComponent t : src.getActor())
      tgt.addActor(convertprovisionActorComponent(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getAction())
      tgt.addAction(convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.Coding t : src.getSecurityLabel())
      tgt.addSecurityLabel(convertCoding(t));
    for (org.hl7.fhir.r4.model.Coding t : src.getPurpose())
      tgt.addPurpose(convertCoding(t));
    for (org.hl7.fhir.r4.model.Coding t : src.getClass_())
      tgt.addClass_(convertCoding(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCode())
      tgt.addCode(convertCodeableConcept(t));
    if (src.hasDataPeriod())
      tgt.setDataPeriod(convertPeriod(src.getDataPeriod()));
    for (org.hl7.fhir.r4.model.Consent.provisionDataComponent t : src.getData())
      tgt.addData(convertprovisionDataComponent(t));
    for (org.hl7.fhir.r4.model.Consent.provisionComponent t : src.getProvision())
      tgt.addProvision(convertprovisionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Consent.provisionComponent convertprovisionComponent(org.hl7.fhir.r5.model.Consent.provisionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Consent.provisionComponent tgt = new org.hl7.fhir.r4.model.Consent.provisionComponent();
    copyElement(src, tgt);
    if (src.hasType())
      tgt.setType(convertConsentProvisionType(src.getType()));
    if (src.hasPeriod())
      tgt.setPeriod(convertPeriod(src.getPeriod()));
    for (org.hl7.fhir.r5.model.Consent.provisionActorComponent t : src.getActor())
      tgt.addActor(convertprovisionActorComponent(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getAction())
      tgt.addAction(convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.Coding t : src.getSecurityLabel())
      tgt.addSecurityLabel(convertCoding(t));
    for (org.hl7.fhir.r5.model.Coding t : src.getPurpose())
      tgt.addPurpose(convertCoding(t));
    for (org.hl7.fhir.r5.model.Coding t : src.getClass_())
      tgt.addClass_(convertCoding(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCode())
      tgt.addCode(convertCodeableConcept(t));
    if (src.hasDataPeriod())
      tgt.setDataPeriod(convertPeriod(src.getDataPeriod()));
    for (org.hl7.fhir.r5.model.Consent.provisionDataComponent t : src.getData())
      tgt.addData(convertprovisionDataComponent(t));
    for (org.hl7.fhir.r5.model.Consent.provisionComponent t : src.getProvision())
      tgt.addProvision(convertprovisionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Consent.ConsentProvisionType convertConsentProvisionType(org.hl7.fhir.r4.model.Consent.ConsentProvisionType src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case DENY: return org.hl7.fhir.r5.model.Consent.ConsentProvisionType.DENY;
    case PERMIT: return org.hl7.fhir.r5.model.Consent.ConsentProvisionType.PERMIT;
    default: return org.hl7.fhir.r5.model.Consent.ConsentProvisionType.NULL;
  }
}

  public static org.hl7.fhir.r4.model.Consent.ConsentProvisionType convertConsentProvisionType(org.hl7.fhir.r5.model.Consent.ConsentProvisionType src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case DENY: return org.hl7.fhir.r4.model.Consent.ConsentProvisionType.DENY;
    case PERMIT: return org.hl7.fhir.r4.model.Consent.ConsentProvisionType.PERMIT;
    default: return org.hl7.fhir.r4.model.Consent.ConsentProvisionType.NULL;
  }
}

  public static org.hl7.fhir.r5.model.Consent.provisionActorComponent convertprovisionActorComponent(org.hl7.fhir.r4.model.Consent.provisionActorComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Consent.provisionActorComponent tgt = new org.hl7.fhir.r5.model.Consent.provisionActorComponent();
    copyElement(src, tgt);
    if (src.hasRole())
      tgt.setRole(convertCodeableConcept(src.getRole()));
    if (src.hasReference())
      tgt.setReference(convertReference(src.getReference()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Consent.provisionActorComponent convertprovisionActorComponent(org.hl7.fhir.r5.model.Consent.provisionActorComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Consent.provisionActorComponent tgt = new org.hl7.fhir.r4.model.Consent.provisionActorComponent();
    copyElement(src, tgt);
    if (src.hasRole())
      tgt.setRole(convertCodeableConcept(src.getRole()));
    if (src.hasReference())
      tgt.setReference(convertReference(src.getReference()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Consent.provisionDataComponent convertprovisionDataComponent(org.hl7.fhir.r4.model.Consent.provisionDataComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Consent.provisionDataComponent tgt = new org.hl7.fhir.r5.model.Consent.provisionDataComponent();
    copyElement(src, tgt);
    if (src.hasMeaning())
      tgt.setMeaning(convertConsentDataMeaning(src.getMeaning()));
    if (src.hasReference())
      tgt.setReference(convertReference(src.getReference()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Consent.provisionDataComponent convertprovisionDataComponent(org.hl7.fhir.r5.model.Consent.provisionDataComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Consent.provisionDataComponent tgt = new org.hl7.fhir.r4.model.Consent.provisionDataComponent();
    copyElement(src, tgt);
    if (src.hasMeaning())
      tgt.setMeaning(convertConsentDataMeaning(src.getMeaning()));
    if (src.hasReference())
      tgt.setReference(convertReference(src.getReference()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Consent.ConsentDataMeaning convertConsentDataMeaning(org.hl7.fhir.r4.model.Consent.ConsentDataMeaning src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case INSTANCE: return org.hl7.fhir.r5.model.Consent.ConsentDataMeaning.INSTANCE;
    case RELATED: return org.hl7.fhir.r5.model.Consent.ConsentDataMeaning.RELATED;
    case DEPENDENTS: return org.hl7.fhir.r5.model.Consent.ConsentDataMeaning.DEPENDENTS;
    case AUTHOREDBY: return org.hl7.fhir.r5.model.Consent.ConsentDataMeaning.AUTHOREDBY;
    default: return org.hl7.fhir.r5.model.Consent.ConsentDataMeaning.NULL;
  }
}

  public static org.hl7.fhir.r4.model.Consent.ConsentDataMeaning convertConsentDataMeaning(org.hl7.fhir.r5.model.Consent.ConsentDataMeaning src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case INSTANCE: return org.hl7.fhir.r4.model.Consent.ConsentDataMeaning.INSTANCE;
    case RELATED: return org.hl7.fhir.r4.model.Consent.ConsentDataMeaning.RELATED;
    case DEPENDENTS: return org.hl7.fhir.r4.model.Consent.ConsentDataMeaning.DEPENDENTS;
    case AUTHOREDBY: return org.hl7.fhir.r4.model.Consent.ConsentDataMeaning.AUTHOREDBY;
    default: return org.hl7.fhir.r4.model.Consent.ConsentDataMeaning.NULL;
  }
}


}
