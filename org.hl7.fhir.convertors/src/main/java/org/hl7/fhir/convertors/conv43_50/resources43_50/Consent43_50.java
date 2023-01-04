package org.hl7.fhir.convertors.conv43_50.resources43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Attachment43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.CodeableConcept43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Coding43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Identifier43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Period43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Boolean43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.DateTime43_50;
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
public class Consent43_50 {

  public static org.hl7.fhir.r5.model.Consent convertConsent(org.hl7.fhir.r4b.model.Consent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Consent tgt = new org.hl7.fhir.r5.model.Consent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertConsentState(src.getStatusElement()));
//    if (src.hasScope())
//      tgt.setScope(CodeableConcept43_50.convertCodeableConcept(src.getScope()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasPatient())
      tgt.setSubject(Reference43_50.convertReference(src.getPatient()));
    if (src.hasDateTime())
      tgt.setDateElement(DateTime43_50.convertDateTimeToDate(src.getDateTimeElement()));
    for (org.hl7.fhir.r4b.model.Reference t : src.getPerformer()) tgt.addGrantee(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getOrganization()) tgt.addManager(Reference43_50.convertReference(t));
    if (src.hasSourceAttachment())
      tgt.addSourceAttachment(Attachment43_50.convertAttachment(src.getSourceAttachment()));
    if (src.hasSourceReference())
      tgt.addSourceReference(Reference43_50.convertReference(src.getSourceReference()));
//    for (org.hl7.fhir.r4b.model.Consent.ConsentPolicyComponent t : src.getPolicy())
//      tgt.addPolicy(convertConsentPolicyComponent(t));
//    if (src.hasPolicyRule())
//      tgt.setPolicyRule(CodeableConcept43_50.convertCodeableConcept(src.getPolicyRule()));
    for (org.hl7.fhir.r4b.model.Consent.ConsentVerificationComponent t : src.getVerification())
      tgt.addVerification(convertConsentVerificationComponent(t));
    if (src.hasProvision())
      tgt.setProvision(convertprovisionComponent(src.getProvision()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Consent convertConsent(org.hl7.fhir.r5.model.Consent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Consent tgt = new org.hl7.fhir.r4b.model.Consent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertConsentState(src.getStatusElement()));
//    if (src.hasScope())
//      tgt.setScope(CodeableConcept43_50.convertCodeableConcept(src.getScope()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasSubject())
      tgt.setPatient(Reference43_50.convertReference(src.getSubject()));
    if (src.hasDate())
      tgt.setDateTimeElement(DateTime43_50.convertDateToDateTime(src.getDateElement()));
    for (org.hl7.fhir.r5.model.Reference t : src.getGrantee()) tgt.addPerformer(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getManager()) tgt.addOrganization(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getController())
      tgt.addOrganization(Reference43_50.convertReference(t));
    if (src.hasSourceAttachment())
      tgt.setSource(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getSourceAttachmentFirstRep()));
    if (src.hasSourceReference())
      tgt.setSource(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getSourceReferenceFirstRep()));
//    for (org.hl7.fhir.r5.model.Consent.ConsentPolicyComponent t : src.getPolicy())
//      tgt.addPolicy(convertConsentPolicyComponent(t));
//    if (src.hasPolicyRule())
//      tgt.setPolicyRule(CodeableConcept43_50.convertCodeableConcept(src.getPolicyRule()));
    for (org.hl7.fhir.r5.model.Consent.ConsentVerificationComponent t : src.getVerification())
      tgt.addVerification(convertConsentVerificationComponent(t));
    if (src.hasProvision())
      tgt.setProvision(convertprovisionComponent(src.getProvision()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Consent.ConsentState> convertConsentState(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Consent.ConsentState> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Consent.ConsentState> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Consent.ConsentStateEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Consent.ConsentState> convertConsentState(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Consent.ConsentState> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Consent.ConsentState> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Consent.ConsentStateEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case DRAFT:
        tgt.setValue(org.hl7.fhir.r4b.model.Consent.ConsentState.DRAFT);
        break;
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.r4b.model.Consent.ConsentState.ACTIVE);
        break;
      case INACTIVE:
        tgt.setValue(org.hl7.fhir.r4b.model.Consent.ConsentState.INACTIVE);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r4b.model.Consent.ConsentState.ENTEREDINERROR);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.Consent.ConsentState.NULL);
        break;
    }
    return tgt;
  }

//  public static org.hl7.fhir.r5.model.Consent.ConsentPolicyComponent convertConsentPolicyComponent(org.hl7.fhir.r4b.model.Consent.ConsentPolicyComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.r5.model.Consent.ConsentPolicyComponent tgt = new org.hl7.fhir.r5.model.Consent.ConsentPolicyComponent();
//    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
//    if (src.hasAuthority())
//      tgt.setAuthorityElement(Uri43_50.convertUri(src.getAuthorityElement()));
//    if (src.hasUri())
//      tgt.setUriElement(Uri43_50.convertUri(src.getUriElement()));
//    return tgt;
//  }
//
//  public static org.hl7.fhir.r4b.model.Consent.ConsentPolicyComponent convertConsentPolicyComponent(org.hl7.fhir.r5.model.Consent.ConsentPolicyComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.r4b.model.Consent.ConsentPolicyComponent tgt = new org.hl7.fhir.r4b.model.Consent.ConsentPolicyComponent();
//    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
//    if (src.hasAuthority())
//      tgt.setAuthorityElement(Uri43_50.convertUri(src.getAuthorityElement()));
//    if (src.hasUri())
//      tgt.setUriElement(Uri43_50.convertUri(src.getUriElement()));
//    return tgt;
//  }

  public static org.hl7.fhir.r5.model.Consent.ConsentVerificationComponent convertConsentVerificationComponent(org.hl7.fhir.r4b.model.Consent.ConsentVerificationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Consent.ConsentVerificationComponent tgt = new org.hl7.fhir.r5.model.Consent.ConsentVerificationComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasVerified())
      tgt.setVerifiedElement(Boolean43_50.convertBoolean(src.getVerifiedElement()));
    if (src.hasVerifiedWith())
      tgt.setVerifiedWith(Reference43_50.convertReference(src.getVerifiedWith()));
    if (src.hasVerificationDate())
      tgt.getVerificationDate().add(DateTime43_50.convertDateTime(src.getVerificationDateElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Consent.ConsentVerificationComponent convertConsentVerificationComponent(org.hl7.fhir.r5.model.Consent.ConsentVerificationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Consent.ConsentVerificationComponent tgt = new org.hl7.fhir.r4b.model.Consent.ConsentVerificationComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasVerified())
      tgt.setVerifiedElement(Boolean43_50.convertBoolean(src.getVerifiedElement()));
    if (src.hasVerifiedWith())
      tgt.setVerifiedWith(Reference43_50.convertReference(src.getVerifiedWith()));
    if (src.hasVerificationDate())
      tgt.setVerificationDateElement(DateTime43_50.convertDateTime(src.getVerificationDate().get(0)));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Consent.ProvisionComponent convertprovisionComponent(org.hl7.fhir.r4b.model.Consent.ProvisionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Consent.ProvisionComponent tgt = new org.hl7.fhir.r5.model.Consent.ProvisionComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setTypeElement(convertConsentProvisionType(src.getTypeElement()));
    if (src.hasPeriod())
      tgt.setPeriod(Period43_50.convertPeriod(src.getPeriod()));
    for (org.hl7.fhir.r4b.model.Consent.ProvisionActorComponent t : src.getActor())
      tgt.addActor(convertprovisionActorComponent(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getAction())
      tgt.addAction(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r4b.model.Coding t : src.getSecurityLabel()) tgt.addSecurityLabel(Coding43_50.convertCoding(t));
    for (org.hl7.fhir.r4b.model.Coding t : src.getPurpose()) tgt.addPurpose(Coding43_50.convertCoding(t));
//    for (org.hl7.fhir.r4b.model.Coding t : src.getClass_()) tgt.addClass_(Coding43_50.convertCoding(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getCode())
      tgt.addCode(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasDataPeriod())
      tgt.setDataPeriod(Period43_50.convertPeriod(src.getDataPeriod()));
    for (org.hl7.fhir.r4b.model.Consent.ProvisionDataComponent t : src.getData())
      tgt.addData(convertprovisionDataComponent(t));
    for (org.hl7.fhir.r4b.model.Consent.ProvisionComponent t : src.getProvision())
      tgt.addProvision(convertprovisionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Consent.ProvisionComponent convertprovisionComponent(org.hl7.fhir.r5.model.Consent.ProvisionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Consent.ProvisionComponent tgt = new org.hl7.fhir.r4b.model.Consent.ProvisionComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setTypeElement(convertConsentProvisionType(src.getTypeElement()));
    if (src.hasPeriod())
      tgt.setPeriod(Period43_50.convertPeriod(src.getPeriod()));
    for (org.hl7.fhir.r5.model.Consent.ProvisionActorComponent t : src.getActor())
      tgt.addActor(convertprovisionActorComponent(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getAction())
      tgt.addAction(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.Coding t : src.getSecurityLabel()) tgt.addSecurityLabel(Coding43_50.convertCoding(t));
    for (org.hl7.fhir.r5.model.Coding t : src.getPurpose()) tgt.addPurpose(Coding43_50.convertCoding(t));
//    for (org.hl7.fhir.r5.model.Coding t : src.getClass_()) tgt.addClass_(Coding43_50.convertCoding(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCode())
      tgt.addCode(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasDataPeriod())
      tgt.setDataPeriod(Period43_50.convertPeriod(src.getDataPeriod()));
    for (org.hl7.fhir.r5.model.Consent.ProvisionDataComponent t : src.getData())
      tgt.addData(convertprovisionDataComponent(t));
    for (org.hl7.fhir.r5.model.Consent.ProvisionComponent t : src.getProvision())
      tgt.addProvision(convertprovisionComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ConsentProvisionType> convertConsentProvisionType(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Consent.ConsentProvisionType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ConsentProvisionType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.ConsentProvisionTypeEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Consent.ConsentProvisionType> convertConsentProvisionType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ConsentProvisionType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Consent.ConsentProvisionType> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Consent.ConsentProvisionTypeEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case DENY:
        tgt.setValue(org.hl7.fhir.r4b.model.Consent.ConsentProvisionType.DENY);
        break;
      case PERMIT:
        tgt.setValue(org.hl7.fhir.r4b.model.Consent.ConsentProvisionType.PERMIT);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.Consent.ConsentProvisionType.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Consent.ProvisionActorComponent convertprovisionActorComponent(org.hl7.fhir.r4b.model.Consent.ProvisionActorComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Consent.ProvisionActorComponent tgt = new org.hl7.fhir.r5.model.Consent.ProvisionActorComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasRole())
      tgt.setRole(CodeableConcept43_50.convertCodeableConcept(src.getRole()));
    if (src.hasReference())
      tgt.setReference(Reference43_50.convertReference(src.getReference()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Consent.ProvisionActorComponent convertprovisionActorComponent(org.hl7.fhir.r5.model.Consent.ProvisionActorComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Consent.ProvisionActorComponent tgt = new org.hl7.fhir.r4b.model.Consent.ProvisionActorComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasRole())
      tgt.setRole(CodeableConcept43_50.convertCodeableConcept(src.getRole()));
    if (src.hasReference())
      tgt.setReference(Reference43_50.convertReference(src.getReference()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Consent.ProvisionDataComponent convertprovisionDataComponent(org.hl7.fhir.r4b.model.Consent.ProvisionDataComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Consent.ProvisionDataComponent tgt = new org.hl7.fhir.r5.model.Consent.ProvisionDataComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasMeaning())
      tgt.setMeaningElement(convertConsentDataMeaning(src.getMeaningElement()));
    if (src.hasReference())
      tgt.setReference(Reference43_50.convertReference(src.getReference()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Consent.ProvisionDataComponent convertprovisionDataComponent(org.hl7.fhir.r5.model.Consent.ProvisionDataComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Consent.ProvisionDataComponent tgt = new org.hl7.fhir.r4b.model.Consent.ProvisionDataComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasMeaning())
      tgt.setMeaningElement(convertConsentDataMeaning(src.getMeaningElement()));
    if (src.hasReference())
      tgt.setReference(Reference43_50.convertReference(src.getReference()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ConsentDataMeaning> convertConsentDataMeaning(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Consent.ConsentDataMeaning> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ConsentDataMeaning> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.ConsentDataMeaningEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Consent.ConsentDataMeaning> convertConsentDataMeaning(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ConsentDataMeaning> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Consent.ConsentDataMeaning> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Consent.ConsentDataMeaningEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case INSTANCE:
        tgt.setValue(org.hl7.fhir.r4b.model.Consent.ConsentDataMeaning.INSTANCE);
        break;
      case RELATED:
        tgt.setValue(org.hl7.fhir.r4b.model.Consent.ConsentDataMeaning.RELATED);
        break;
      case DEPENDENTS:
        tgt.setValue(org.hl7.fhir.r4b.model.Consent.ConsentDataMeaning.DEPENDENTS);
        break;
      case AUTHOREDBY:
        tgt.setValue(org.hl7.fhir.r4b.model.Consent.ConsentDataMeaning.AUTHOREDBY);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.Consent.ConsentDataMeaning.NULL);
        break;
    }
    return tgt;
  }
}
