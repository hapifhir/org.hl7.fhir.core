package org.hl7.fhir.convertors.conv40_50.resources40_50;

import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Attachment40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.CodeableConcept40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Coding40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Identifier40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Period40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Boolean40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.DateTime40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.special40_50.Reference40_50;
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
public class Consent40_50 {

  public static org.hl7.fhir.r5.model.Consent convertConsent(org.hl7.fhir.r4.model.Consent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Consent tgt = new org.hl7.fhir.r5.model.Consent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_50.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertConsentState(src.getStatusElement()));
//    if (src.hasScope())
//      tgt.setScope(CodeableConcept40_50.convertCodeableConcept(src.getScope()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept40_50.convertCodeableConcept(t));
    if (src.hasPatient())
      tgt.setSubject(Reference40_50.convertReference(src.getPatient()));
    if (src.hasDateTime())
      tgt.setDateElement(DateTime40_50.convertDateTimeToDate(src.getDateTimeElement()));
    for (org.hl7.fhir.r4.model.Reference t : src.getPerformer()) tgt.addGrantee(Reference40_50.convertReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getOrganization()) tgt.addManager(Reference40_50.convertReference(t));
    if (src.hasSourceAttachment())
      tgt.addSourceAttachment(Attachment40_50.convertAttachment(src.getSourceAttachment()));
    if (src.hasSourceReference())
      tgt.addSourceReference(Reference40_50.convertReference(src.getSourceReference()));
//    for (org.hl7.fhir.r4.model.Consent.ConsentPolicyComponent t : src.getPolicy())
//      tgt.addPolicy(convertConsentPolicyComponent(t));
//    if (src.hasPolicyRule())
//      tgt.setPolicyRule(CodeableConcept40_50.convertCodeableConcept(src.getPolicyRule()));
    for (org.hl7.fhir.r4.model.Consent.ConsentVerificationComponent t : src.getVerification())
      tgt.addVerification(convertConsentVerificationComponent(t));
    if (src.hasProvision())
      tgt.addProvision(convertprovisionComponent(src.getProvision()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Consent convertConsent(org.hl7.fhir.r5.model.Consent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Consent tgt = new org.hl7.fhir.r4.model.Consent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_50.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertConsentState(src.getStatusElement()));
//    if (src.hasScope())
//      tgt.setScope(CodeableConcept40_50.convertCodeableConcept(src.getScope()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept40_50.convertCodeableConcept(t));
    if (src.hasSubject())
      tgt.setPatient(Reference40_50.convertReference(src.getSubject()));
    if (src.hasDate())
      tgt.setDateTimeElement(DateTime40_50.convertDateToDateTime(src.getDateElement()));
    for (org.hl7.fhir.r5.model.Reference t : src.getGrantee()) tgt.addPerformer(Reference40_50.convertReference(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getManager()) tgt.addOrganization(Reference40_50.convertReference(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getController())
      tgt.addOrganization(Reference40_50.convertReference(t));
    if (src.hasSourceAttachment())
      tgt.setSource(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getSourceAttachmentFirstRep()));
    if (src.hasSourceReference())
      tgt.setSource(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getSourceReferenceFirstRep()));
//    for (org.hl7.fhir.r5.model.Consent.ConsentPolicyComponent t : src.getPolicy())
//      tgt.addPolicy(convertConsentPolicyComponent(t));
//    if (src.hasPolicyRule())
//      tgt.setPolicyRule(CodeableConcept40_50.convertCodeableConcept(src.getPolicyRule()));
    for (org.hl7.fhir.r5.model.Consent.ConsentVerificationComponent t : src.getVerification())
      tgt.addVerification(convertConsentVerificationComponent(t));
    if (src.hasProvision())
      tgt.setProvision(convertprovisionComponent(src.getProvisionFirstRep()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Consent.ConsentState> convertConsentState(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Consent.ConsentState> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Consent.ConsentState> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Consent.ConsentStateEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case DRAFT:
        tgt.setValue(org.hl7.fhir.r5.model.Consent.ConsentState.DRAFT);
        break;
      case PROPOSED:
        tgt.setValue(org.hl7.fhir.r5.model.Consent.ConsentState.DRAFT);
        break;
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.r5.model.Consent.ConsentState.ACTIVE);
        break;
      case REJECTED:
        tgt.setValue(org.hl7.fhir.r5.model.Consent.ConsentState.INACTIVE);
        break;
      case INACTIVE:
        tgt.setValue(org.hl7.fhir.r5.model.Consent.ConsentState.INACTIVE);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r5.model.Consent.ConsentState.ENTEREDINERROR);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.Consent.ConsentState.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Consent.ConsentState> convertConsentState(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Consent.ConsentState> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Consent.ConsentState> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Consent.ConsentStateEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case DRAFT:
        tgt.setValue(org.hl7.fhir.r4.model.Consent.ConsentState.DRAFT);
        break;
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.r4.model.Consent.ConsentState.ACTIVE);
        break;
      case INACTIVE:
        tgt.setValue(org.hl7.fhir.r4.model.Consent.ConsentState.INACTIVE);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r4.model.Consent.ConsentState.ENTEREDINERROR);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.Consent.ConsentState.NULL);
        break;
    }
    return tgt;
  }

//  public static org.hl7.fhir.r5.model.Consent.ConsentPolicyComponent convertConsentPolicyComponent(org.hl7.fhir.r4.model.Consent.ConsentPolicyComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.r5.model.Consent.ConsentPolicyComponent tgt = new org.hl7.fhir.r5.model.Consent.ConsentPolicyComponent();
//    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
//    if (src.hasAuthority())
//      tgt.setAuthorityElement(Uri40_50.convertUri(src.getAuthorityElement()));
//    if (src.hasUri())
//      tgt.setUriElement(Uri40_50.convertUri(src.getUriElement()));
//    return tgt;
//  }
//
//  public static org.hl7.fhir.r4.model.Consent.ConsentPolicyComponent convertConsentPolicyComponent(org.hl7.fhir.r5.model.Consent.ConsentPolicyComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.r4.model.Consent.ConsentPolicyComponent tgt = new org.hl7.fhir.r4.model.Consent.ConsentPolicyComponent();
//    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
//    if (src.hasAuthority())
//      tgt.setAuthorityElement(Uri40_50.convertUri(src.getAuthorityElement()));
//    if (src.hasUri())
//      tgt.setUriElement(Uri40_50.convertUri(src.getUriElement()));
//    return tgt;
//  }

  public static org.hl7.fhir.r5.model.Consent.ConsentVerificationComponent convertConsentVerificationComponent(org.hl7.fhir.r4.model.Consent.ConsentVerificationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Consent.ConsentVerificationComponent tgt = new org.hl7.fhir.r5.model.Consent.ConsentVerificationComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasVerified())
      tgt.setVerifiedElement(Boolean40_50.convertBoolean(src.getVerifiedElement()));
    if (src.hasVerifiedWith())
      tgt.setVerifiedWith(Reference40_50.convertReference(src.getVerifiedWith()));
    if (src.hasVerificationDate())
      tgt.getVerificationDate().add(DateTime40_50.convertDateTime(src.getVerificationDateElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Consent.ConsentVerificationComponent convertConsentVerificationComponent(org.hl7.fhir.r5.model.Consent.ConsentVerificationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Consent.ConsentVerificationComponent tgt = new org.hl7.fhir.r4.model.Consent.ConsentVerificationComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasVerified())
      tgt.setVerifiedElement(Boolean40_50.convertBoolean(src.getVerifiedElement()));
    if (src.hasVerifiedWith())
      tgt.setVerifiedWith(Reference40_50.convertReference(src.getVerifiedWith()));
    if (src.hasVerificationDate())
      tgt.setVerificationDateElement(DateTime40_50.convertDateTime(src.getVerificationDate().get(0)));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Consent.ProvisionComponent convertprovisionComponent(org.hl7.fhir.r4.model.Consent.ProvisionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Consent.ProvisionComponent tgt = new org.hl7.fhir.r5.model.Consent.ProvisionComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
//    if (src.hasType())
//      tgt.setTypeElement(convertConsentProvisionType(src.getTypeElement()));
    if (src.hasPeriod())
      tgt.setPeriod(Period40_50.convertPeriod(src.getPeriod()));
    for (org.hl7.fhir.r4.model.Consent.provisionActorComponent t : src.getActor())
      tgt.addActor(convertprovisionActorComponent(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getAction())
      tgt.addAction(CodeableConcept40_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.Coding t : src.getSecurityLabel()) tgt.addSecurityLabel(Coding40_50.convertCoding(t));
    for (org.hl7.fhir.r4.model.Coding t : src.getPurpose()) tgt.addPurpose(Coding40_50.convertCoding(t));
//    for (org.hl7.fhir.r4.model.Coding t : src.getClass_()) tgt.addClass_(Coding40_50.convertCoding(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCode())
      tgt.addCode(CodeableConcept40_50.convertCodeableConcept(t));
    if (src.hasDataPeriod())
      tgt.setDataPeriod(Period40_50.convertPeriod(src.getDataPeriod()));
    for (org.hl7.fhir.r4.model.Consent.provisionDataComponent t : src.getData())
      tgt.addData(convertprovisionDataComponent(t));
    for (org.hl7.fhir.r4.model.Consent.ProvisionComponent t : src.getProvision())
      tgt.addProvision(convertprovisionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Consent.ProvisionComponent convertprovisionComponent(org.hl7.fhir.r5.model.Consent.ProvisionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Consent.ProvisionComponent tgt = new org.hl7.fhir.r4.model.Consent.ProvisionComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
//    if (src.hasType())
//      tgt.setTypeElement(convertConsentProvisionType(src.getTypeElement()));
    if (src.hasPeriod())
      tgt.setPeriod(Period40_50.convertPeriod(src.getPeriod()));
    for (org.hl7.fhir.r5.model.Consent.ProvisionActorComponent t : src.getActor())
      tgt.addActor(convertprovisionActorComponent(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getAction())
      tgt.addAction(CodeableConcept40_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.Coding t : src.getSecurityLabel()) tgt.addSecurityLabel(Coding40_50.convertCoding(t));
    for (org.hl7.fhir.r5.model.Coding t : src.getPurpose()) tgt.addPurpose(Coding40_50.convertCoding(t));
//    for (org.hl7.fhir.r5.model.Coding t : src.getClass_()) tgt.addClass_(Coding40_50.convertCoding(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCode())
      tgt.addCode(CodeableConcept40_50.convertCodeableConcept(t));
    if (src.hasDataPeriod())
      tgt.setDataPeriod(Period40_50.convertPeriod(src.getDataPeriod()));
    for (org.hl7.fhir.r5.model.Consent.ProvisionDataComponent t : src.getData())
      tgt.addData(convertprovisionDataComponent(t));
    for (org.hl7.fhir.r5.model.Consent.ProvisionComponent t : src.getProvision())
      tgt.addProvision(convertprovisionComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ConsentProvisionType> convertConsentProvisionType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Consent.ConsentProvisionType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ConsentProvisionType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.ConsentProvisionTypeEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case DENY:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ConsentProvisionType.DENY);
        break;
      case PERMIT:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ConsentProvisionType.PERMIT);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ConsentProvisionType.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Consent.ConsentProvisionType> convertConsentProvisionType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ConsentProvisionType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Consent.ConsentProvisionType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Consent.ConsentProvisionTypeEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case DENY:
        tgt.setValue(org.hl7.fhir.r4.model.Consent.ConsentProvisionType.DENY);
        break;
      case PERMIT:
        tgt.setValue(org.hl7.fhir.r4.model.Consent.ConsentProvisionType.PERMIT);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.Consent.ConsentProvisionType.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Consent.ProvisionActorComponent convertprovisionActorComponent(org.hl7.fhir.r4.model.Consent.provisionActorComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Consent.ProvisionActorComponent tgt = new org.hl7.fhir.r5.model.Consent.ProvisionActorComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasRole())
      tgt.setRole(CodeableConcept40_50.convertCodeableConcept(src.getRole()));
    if (src.hasReference())
      tgt.setReference(Reference40_50.convertReference(src.getReference()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Consent.provisionActorComponent convertprovisionActorComponent(org.hl7.fhir.r5.model.Consent.ProvisionActorComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Consent.provisionActorComponent tgt = new org.hl7.fhir.r4.model.Consent.provisionActorComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasRole())
      tgt.setRole(CodeableConcept40_50.convertCodeableConcept(src.getRole()));
    if (src.hasReference())
      tgt.setReference(Reference40_50.convertReference(src.getReference()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Consent.ProvisionDataComponent convertprovisionDataComponent(org.hl7.fhir.r4.model.Consent.provisionDataComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Consent.ProvisionDataComponent tgt = new org.hl7.fhir.r5.model.Consent.ProvisionDataComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasMeaning())
      tgt.setMeaningElement(convertConsentDataMeaning(src.getMeaningElement()));
    if (src.hasReference())
      tgt.setReference(Reference40_50.convertReference(src.getReference()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Consent.provisionDataComponent convertprovisionDataComponent(org.hl7.fhir.r5.model.Consent.ProvisionDataComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Consent.provisionDataComponent tgt = new org.hl7.fhir.r4.model.Consent.provisionDataComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasMeaning())
      tgt.setMeaningElement(convertConsentDataMeaning(src.getMeaningElement()));
    if (src.hasReference())
      tgt.setReference(Reference40_50.convertReference(src.getReference()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ConsentDataMeaning> convertConsentDataMeaning(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Consent.ConsentDataMeaning> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ConsentDataMeaning> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.ConsentDataMeaningEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case INSTANCE:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ConsentDataMeaning.INSTANCE);
        break;
      case RELATED:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ConsentDataMeaning.RELATED);
        break;
      case DEPENDENTS:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ConsentDataMeaning.DEPENDENTS);
        break;
      case AUTHOREDBY:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ConsentDataMeaning.AUTHOREDBY);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ConsentDataMeaning.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Consent.ConsentDataMeaning> convertConsentDataMeaning(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ConsentDataMeaning> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Consent.ConsentDataMeaning> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Consent.ConsentDataMeaningEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case INSTANCE:
        tgt.setValue(org.hl7.fhir.r4.model.Consent.ConsentDataMeaning.INSTANCE);
        break;
      case RELATED:
        tgt.setValue(org.hl7.fhir.r4.model.Consent.ConsentDataMeaning.RELATED);
        break;
      case DEPENDENTS:
        tgt.setValue(org.hl7.fhir.r4.model.Consent.ConsentDataMeaning.DEPENDENTS);
        break;
      case AUTHOREDBY:
        tgt.setValue(org.hl7.fhir.r4.model.Consent.ConsentDataMeaning.AUTHOREDBY);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.Consent.ConsentDataMeaning.NULL);
        break;
    }
    return tgt;
  }
}
