package org.hl7.fhir.convertors.conv43_N.resources43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Attachment43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.CodeableConcept43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Coding43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Identifier43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Period43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Boolean43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.DateTime43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.special43_N.Reference43_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.Consent;
import org.hl7.fhir.model.core.Enumeration;
import org.hl7.fhir.model.core.Enumerations;

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

public class Consent43_N {

  public static org.hl7.fhir.model.core.Consent convertConsent(org.hl7.fhir.r4b.model.Consent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Consent tgt = new org.hl7.fhir.model.core.Consent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertConsentState(src.getStatusElement()));
//    if (src.hasScope())
//      tgt.setScope(CodeableConcept43_N.convertCodeableConcept(src.getScope()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasPatient())
      tgt.setSubject(Reference43_N.convertReference(src.getPatient()));
    if (src.hasDateTime())
      tgt.setDateElement(DateTime43_N.convertDateTimeToDate(src.getDateTimeElement()));
    for (org.hl7.fhir.r4b.model.Reference t : src.getPerformer()) tgt.addGrantee(Reference43_N.convertReference(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getOrganization()) tgt.addManager(Reference43_N.convertReference(t));
    if (src.hasSourceAttachment())
      tgt.addSourceAttachment(Attachment43_N.convertAttachment(src.getSourceAttachment()));
    if (src.hasSourceReference())
      tgt.addSourceReference(Reference43_N.convertReference(src.getSourceReference()));
//    for (org.hl7.fhir.r4b.model.Consent.ConsentPolicyComponent t : src.getPolicy())
//      tgt.addPolicy(convertConsentPolicyComponent(t));
//    if (src.hasPolicyRule())
//      tgt.setPolicyRule(CodeableConcept43_N.convertCodeableConcept(src.getPolicyRule()));
    for (org.hl7.fhir.r4b.model.Consent.ConsentVerificationComponent t : src.getVerification())
      tgt.addVerification(convertConsentVerificationComponent(t));
    if (src.hasProvision())
      tgt.addProvision(convertprovisionComponent(src.getProvision()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Consent convertConsent(org.hl7.fhir.model.core.Consent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Consent tgt = new org.hl7.fhir.r4b.model.Consent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertConsentState(src.getStatusElement()));
//    if (src.hasScope())
//      tgt.setScope(CodeableConcept43_N.convertCodeableConcept(src.getScope()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getCategoryList())
      tgt.addCategory(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasSubject())
      tgt.setPatient(Reference43_N.convertReference(src.getSubject()));
    if (src.hasDate())
      tgt.setDateTimeElement(DateTime43_N.convertDateToDateTime(src.getDateElement()));
    for (org.hl7.fhir.model.core.Reference t : src.getGranteeList()) tgt.addPerformer(Reference43_N.convertReference(t));
    for (org.hl7.fhir.model.core.Reference t : src.getManagerList()) tgt.addOrganization(Reference43_N.convertReference(t));
    for (org.hl7.fhir.model.core.Reference t : src.getControllerList())
      tgt.addOrganization(Reference43_N.convertReference(t));
    if (src.hasSourceAttachment())
      tgt.setSource(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getSourceAttachmentFirstRep()));
    if (src.hasSourceReference())
      tgt.setSource(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getSourceReferenceFirstRep()));
//    for (org.hl7.fhir.model.core.Consent.ConsentPolicyComponent t : src.getPolicyList())
//      tgt.addPolicy(convertConsentPolicyComponent(t));
//    if (src.hasPolicyRule())
//      tgt.setPolicyRule(CodeableConcept43_N.convertCodeableConcept(src.getPolicyRule()));
    for (org.hl7.fhir.model.core.Consent.ConsentVerificationComponent t : src.getVerificationList())
      tgt.addVerification(convertConsentVerificationComponent(t));
    if (src.hasProvision())
      tgt.setProvision(convertprovisionComponent(src.getProvisionFirstRep()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Consent.ConsentState> convertConsentState(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Consent.ConsentState> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Consent.ConsentState> tgt = new Enumeration<>(new Consent.ConsentStateEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case DRAFT:
                  tgt.setValue(Consent.ConsentState.DRAFT);
                  break;
              case PROPOSED:
                  tgt.setValue(Consent.ConsentState.DRAFT);
                  break;
              case ACTIVE:
                  tgt.setValue(Consent.ConsentState.ACTIVE);
                  break;
              case REJECTED:
                  tgt.setValue(Consent.ConsentState.INACTIVE);
                  break;
              case INACTIVE:
                  tgt.setValue(Consent.ConsentState.INACTIVE);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(Consent.ConsentState.ENTEREDINERROR);
                  break;
              default:
                  tgt.setValue(Consent.ConsentState.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Consent.ConsentState> convertConsentState(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Consent.ConsentState> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Consent.ConsentState> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Consent.ConsentStateEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
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
      }
      return tgt;
  }

//  public static org.hl7.fhir.model.core.Consent.ConsentPolicyComponent convertConsentPolicyComponent(org.hl7.fhir.r4b.model.Consent.ConsentPolicyComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.model.core.Consent.ConsentPolicyComponent tgt = new org.hl7.fhir.model.core.Consent.ConsentPolicyComponent();
//    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
//    if (src.hasAuthority())
//      tgt.setAuthorityElement(Uri43_N.convertUri(src.getAuthorityElement()));
//    if (src.hasUri())
//      tgt.setUriElement(Uri43_N.convertUri(src.getUriElement()));
//    return tgt;
//  }
//
//  public static org.hl7.fhir.r4b.model.Consent.ConsentPolicyComponent convertConsentPolicyComponent(org.hl7.fhir.model.core.Consent.ConsentPolicyComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.r4b.model.Consent.ConsentPolicyComponent tgt = new org.hl7.fhir.r4b.model.Consent.ConsentPolicyComponent();
//    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
//    if (src.hasAuthority())
//      tgt.setAuthorityElement(Uri43_N.convertUri(src.getAuthorityElement()));
//    if (src.hasUri())
//      tgt.setUriElement(Uri43_N.convertUri(src.getUriElement()));
//    return tgt;
//  }

  public static org.hl7.fhir.model.core.Consent.ConsentVerificationComponent convertConsentVerificationComponent(org.hl7.fhir.r4b.model.Consent.ConsentVerificationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Consent.ConsentVerificationComponent tgt = new org.hl7.fhir.model.core.Consent.ConsentVerificationComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasVerified())
      tgt.setVerifiedElement(Boolean43_N.convertBoolean(src.getVerifiedElement()));
    if (src.hasVerifiedWith())
      tgt.setVerifiedWith(Reference43_N.convertReference(src.getVerifiedWith()));
    if (src.hasVerificationDate())
      tgt.getDateList().add(DateTime43_N.convertDateTime(src.getVerificationDateElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Consent.ConsentVerificationComponent convertConsentVerificationComponent(org.hl7.fhir.model.core.Consent.ConsentVerificationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Consent.ConsentVerificationComponent tgt = new org.hl7.fhir.r4b.model.Consent.ConsentVerificationComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasVerified())
      tgt.setVerifiedElement(Boolean43_N.convertBoolean(src.getVerifiedElement()));
    if (src.hasVerifiedWith())
      tgt.setVerifiedWith(Reference43_N.convertReference(src.getVerifiedWith()));
    if (src.hasDate())
      tgt.setVerificationDateElement(DateTime43_N.convertDateTime(src.getDateList().get(0)));
    return tgt;
  }

  public static org.hl7.fhir.model.core.Consent.ProvisionComponent convertprovisionComponent(org.hl7.fhir.r4b.model.Consent.ProvisionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Consent.ProvisionComponent tgt = new org.hl7.fhir.model.core.Consent.ProvisionComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
//    if (src.hasType())
//      tgt.setTypeElement(convertConsentProvisionType(src.getTypeElement()));
    if (src.hasPeriod())
      tgt.setPeriod(Period43_N.convertPeriod(src.getPeriod()));
    for (org.hl7.fhir.r4b.model.Consent.ProvisionActorComponent t : src.getActor())
      tgt.addActor(convertProvisionActorComponent(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getAction())
      tgt.addAction(CodeableConcept43_N.convertCodeableConcept(t));
    for (org.hl7.fhir.r4b.model.Coding t : src.getSecurityLabel()) tgt.addSecurityLabel(Coding43_N.convertCoding(t));
    for (org.hl7.fhir.r4b.model.Coding t : src.getPurpose()) tgt.addPurpose(Coding43_N.convertCoding(t));
//    for (org.hl7.fhir.r4b.model.Coding t : src.getClass_()) tgt.addClass_(Coding43_N.convertCoding(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getCode())
      tgt.addCode(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasDataPeriod())
      tgt.setDataPeriod(Period43_N.convertPeriod(src.getDataPeriod()));
    for (org.hl7.fhir.r4b.model.Consent.ProvisionDataComponent t : src.getData())
      tgt.addData(convertprovisionDataComponent(t));
    for (org.hl7.fhir.r4b.model.Consent.ProvisionComponent t : src.getProvision())
      tgt.addProvision(convertprovisionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Consent.ProvisionComponent convertprovisionComponent(org.hl7.fhir.model.core.Consent.ProvisionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Consent.ProvisionComponent tgt = new org.hl7.fhir.r4b.model.Consent.ProvisionComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
//    if (src.hasType())
//      tgt.setTypeElement(convertConsentProvisionType(src.getTypeElement()));
    if (src.hasPeriod())
      tgt.setPeriod(Period43_N.convertPeriod(src.getPeriod()));
    for (org.hl7.fhir.model.core.Consent.ProvisionActorComponent t : src.getActorList())
      tgt.addActor(convertProvisionActorComponent(t));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getActionList())
      tgt.addAction(CodeableConcept43_N.convertCodeableConcept(t));
    for (org.hl7.fhir.model.core.Coding t : src.getSecurityLabelList()) tgt.addSecurityLabel(Coding43_N.convertCoding(t));
    for (org.hl7.fhir.model.core.Coding t : src.getPurposeList()) tgt.addPurpose(Coding43_N.convertCoding(t));
//    for (org.hl7.fhir.model.core.Coding t : src.getClass_List()) tgt.addClass_(Coding43_N.convertCoding(t));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getCodeList())
      tgt.addCode(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasDataPeriod())
      tgt.setDataPeriod(Period43_N.convertPeriod(src.getDataPeriod()));
    for (org.hl7.fhir.model.core.Consent.ProvisionDataComponent t : src.getDataList())
      tgt.addData(convertprovisionDataComponent(t));
    for (org.hl7.fhir.model.core.Consent.ProvisionComponent t : src.getProvisionList())
      tgt.addProvision(convertprovisionComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Consent.ConsentProvisionType> convertConsentProvisionType(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Consent.ConsentProvisionType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Consent.ConsentProvisionType> tgt = new Enumeration<>(new Consent.ConsentProvisionTypeEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case DENY:
                  tgt.setValue(Consent.ConsentProvisionType.DENY);
                  break;
              case PERMIT:
                  tgt.setValue(Consent.ConsentProvisionType.PERMIT);
                  break;
              default:
                  tgt.setValue(Consent.ConsentProvisionType.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Consent.ConsentProvisionType> convertConsentProvisionType(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Consent.ConsentProvisionType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Consent.ConsentProvisionType> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Consent.ConsentProvisionTypeEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
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
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.Consent.ProvisionActorComponent convertProvisionActorComponent(org.hl7.fhir.r4b.model.Consent.ProvisionActorComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Consent.ProvisionActorComponent tgt = new org.hl7.fhir.model.core.Consent.ProvisionActorComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasRole())
      tgt.setRole(CodeableConcept43_N.convertCodeableConcept(src.getRole()));
    if (src.hasReference())
      tgt.setReference(Reference43_N.convertReference(src.getReference()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Consent.ProvisionActorComponent convertProvisionActorComponent(org.hl7.fhir.model.core.Consent.ProvisionActorComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Consent.ProvisionActorComponent tgt = new org.hl7.fhir.r4b.model.Consent.ProvisionActorComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasRole())
      tgt.setRole(CodeableConcept43_N.convertCodeableConcept(src.getRole()));
    if (src.hasReference())
      tgt.setReference(Reference43_N.convertReference(src.getReference()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.Consent.ProvisionDataComponent convertprovisionDataComponent(org.hl7.fhir.r4b.model.Consent.ProvisionDataComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Consent.ProvisionDataComponent tgt = new org.hl7.fhir.model.core.Consent.ProvisionDataComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasMeaning())
      tgt.setMeaningElement(convertConsentDataMeaning(src.getMeaningElement()));
    if (src.hasReference())
      tgt.setReference(Reference43_N.convertReference(src.getReference()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Consent.ProvisionDataComponent convertprovisionDataComponent(org.hl7.fhir.model.core.Consent.ProvisionDataComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Consent.ProvisionDataComponent tgt = new org.hl7.fhir.r4b.model.Consent.ProvisionDataComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasMeaning())
      tgt.setMeaningElement(convertConsentDataMeaning(src.getMeaningElement()));
    if (src.hasReference())
      tgt.setReference(Reference43_N.convertReference(src.getReference()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Consent.ConsentDataMeaning> convertConsentDataMeaning(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Consent.ConsentDataMeaning> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Consent.ConsentDataMeaning> tgt = new Enumeration<>(new Consent.ConsentDataMeaningEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case INSTANCE:
                  tgt.setValue(Consent.ConsentDataMeaning.INSTANCE);
                  break;
              case RELATED:
                  tgt.setValue(Consent.ConsentDataMeaning.RELATED);
                  break;
              case DEPENDENTS:
                  tgt.setValue(Consent.ConsentDataMeaning.DEPENDENTS);
                  break;
              case AUTHOREDBY:
                  tgt.setValue(Consent.ConsentDataMeaning.AUTHOREDBY);
                  break;
              default:
                  tgt.setValue(Consent.ConsentDataMeaning.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Consent.ConsentDataMeaning> convertConsentDataMeaning(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Consent.ConsentDataMeaning> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Consent.ConsentDataMeaning> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Consent.ConsentDataMeaningEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
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
      }
      return tgt;
  }
}
