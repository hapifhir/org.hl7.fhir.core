package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Attachment40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Coding40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Identifier40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Period40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Boolean40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.DateTime40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Reference40_N;
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

public class Consent40_N {

  public static org.hl7.fhir.model.core.Consent convertConsent(org.hl7.fhir.r4.model.Consent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Consent tgt = new org.hl7.fhir.model.core.Consent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertConsentState(src.getStatusElement()));
//    if (src.hasScope())
//      tgt.setScope(CodeableConcept40_N.convertCodeableConcept(src.getScope()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasPatient())
      tgt.setSubject(Reference40_N.convertReference(src.getPatient()));
    if (src.hasDateTime())
      tgt.setDateElement(DateTime40_N.convertDateTimeToDate(src.getDateTimeElement()));
    for (org.hl7.fhir.r4.model.Reference t : src.getPerformer()) tgt.addGrantee(Reference40_N.convertReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getOrganization()) tgt.addManager(Reference40_N.convertReference(t));
    if (src.hasSourceAttachment())
      tgt.addSourceAttachment(Attachment40_N.convertAttachment(src.getSourceAttachment()));
    if (src.hasSourceReference())
      tgt.addSourceReference(Reference40_N.convertReference(src.getSourceReference()));
//    for (org.hl7.fhir.r4.model.Consent.ConsentPolicyComponent t : src.getPolicy())
//      tgt.addPolicy(convertConsentPolicyComponent(t));
//    if (src.hasPolicyRule())
//      tgt.setPolicyRule(CodeableConcept40_N.convertCodeableConcept(src.getPolicyRule()));
    for (org.hl7.fhir.r4.model.Consent.ConsentVerificationComponent t : src.getVerification())
      tgt.addVerification(convertConsentVerificationComponent(t));
    if (src.hasProvision())
      tgt.addProvision(convertprovisionComponent(src.getProvision()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Consent convertConsent(org.hl7.fhir.model.core.Consent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Consent tgt = new org.hl7.fhir.r4.model.Consent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertConsentState(src.getStatusElement()));
//    if (src.hasScope())
//      tgt.setScope(CodeableConcept40_N.convertCodeableConcept(src.getScope()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getCategoryList())
      tgt.addCategory(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasSubject())
      tgt.setPatient(Reference40_N.convertReference(src.getSubject()));
    if (src.hasDate())
      tgt.setDateTimeElement(DateTime40_N.convertDateToDateTime(src.getDateElement()));
    for (org.hl7.fhir.model.core.Reference t : src.getGranteeList()) tgt.addPerformer(Reference40_N.convertReference(t));
    for (org.hl7.fhir.model.core.Reference t : src.getManagerList()) tgt.addOrganization(Reference40_N.convertReference(t));
    for (org.hl7.fhir.model.core.Reference t : src.getControllerList())
      tgt.addOrganization(Reference40_N.convertReference(t));
    if (src.hasSourceAttachment())
      tgt.setSource(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getSourceAttachmentFirstRep()));
    if (src.hasSourceReference())
      tgt.setSource(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getSourceReferenceFirstRep()));
//    for (org.hl7.fhir.model.core.Consent.ConsentPolicyComponent t : src.getPolicyList())
//      tgt.addPolicy(convertConsentPolicyComponent(t));
//    if (src.hasPolicyRule())
//      tgt.setPolicyRule(CodeableConcept40_N.convertCodeableConcept(src.getPolicyRule()));
    for (org.hl7.fhir.model.core.Consent.ConsentVerificationComponent t : src.getVerificationList())
      tgt.addVerification(convertConsentVerificationComponent(t));
    if (src.hasProvision())
      tgt.setProvision(convertprovisionComponent(src.getProvisionFirstRep()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Consent.ConsentState> convertConsentState(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Consent.ConsentState> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Consent.ConsentState> tgt = new Enumeration<>(new Consent.ConsentStateEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Consent.ConsentState> convertConsentState(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Consent.ConsentState> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Consent.ConsentState> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Consent.ConsentStateEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
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
      }
      return tgt;
  }

//  public static org.hl7.fhir.model.core.Consent.ConsentPolicyComponent convertConsentPolicyComponent(org.hl7.fhir.r4.model.Consent.ConsentPolicyComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.model.core.Consent.ConsentPolicyComponent tgt = new org.hl7.fhir.model.core.Consent.ConsentPolicyComponent();
//    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
//    if (src.hasAuthority())
//      tgt.setAuthorityElement(Uri40_N.convertUri(src.getAuthorityElement()));
//    if (src.hasUri())
//      tgt.setUriElement(Uri40_N.convertUri(src.getUriElement()));
//    return tgt;
//  }
//
//  public static org.hl7.fhir.r4.model.Consent.ConsentPolicyComponent convertConsentPolicyComponent(org.hl7.fhir.model.core.Consent.ConsentPolicyComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.r4.model.Consent.ConsentPolicyComponent tgt = new org.hl7.fhir.r4.model.Consent.ConsentPolicyComponent();
//    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
//    if (src.hasAuthority())
//      tgt.setAuthorityElement(Uri40_N.convertUri(src.getAuthorityElement()));
//    if (src.hasUri())
//      tgt.setUriElement(Uri40_N.convertUri(src.getUriElement()));
//    return tgt;
//  }

  public static org.hl7.fhir.model.core.Consent.ConsentVerificationComponent convertConsentVerificationComponent(org.hl7.fhir.r4.model.Consent.ConsentVerificationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Consent.ConsentVerificationComponent tgt = new org.hl7.fhir.model.core.Consent.ConsentVerificationComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasVerified())
      tgt.setVerifiedElement(Boolean40_N.convertBoolean(src.getVerifiedElement()));
    if (src.hasVerifiedWith())
      tgt.setVerifiedWith(Reference40_N.convertReference(src.getVerifiedWith()));
    if (src.hasVerificationDate())
      tgt.getDateList().add(DateTime40_N.convertDateTime(src.getVerificationDateElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Consent.ConsentVerificationComponent convertConsentVerificationComponent(org.hl7.fhir.model.core.Consent.ConsentVerificationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Consent.ConsentVerificationComponent tgt = new org.hl7.fhir.r4.model.Consent.ConsentVerificationComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasVerified())
      tgt.setVerifiedElement(Boolean40_N.convertBoolean(src.getVerifiedElement()));
    if (src.hasVerifiedWith())
      tgt.setVerifiedWith(Reference40_N.convertReference(src.getVerifiedWith()));
    if (src.hasDate())
      tgt.setVerificationDateElement(DateTime40_N.convertDateTime(src.getDateList().get(0)));
    return tgt;
  }

  public static org.hl7.fhir.model.core.Consent.ProvisionComponent convertprovisionComponent(org.hl7.fhir.r4.model.Consent.ProvisionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Consent.ProvisionComponent tgt = new org.hl7.fhir.model.core.Consent.ProvisionComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
//    if (src.hasType())
//      tgt.setTypeElement(convertConsentProvisionType(src.getTypeElement()));
    if (src.hasPeriod())
      tgt.setPeriod(Period40_N.convertPeriod(src.getPeriod()));
    for (org.hl7.fhir.r4.model.Consent.provisionActorComponent t : src.getActor())
      tgt.addActor(convertprovisionActorComponent(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getAction())
      tgt.addAction(CodeableConcept40_N.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.Coding t : src.getSecurityLabel()) tgt.addSecurityLabel(Coding40_N.convertCoding(t));
    for (org.hl7.fhir.r4.model.Coding t : src.getPurpose()) tgt.addPurpose(Coding40_N.convertCoding(t));
//    for (org.hl7.fhir.r4.model.Coding t : src.getClass_()) tgt.addClass_(Coding40_N.convertCoding(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCode())
      tgt.addCode(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasDataPeriod())
      tgt.setDataPeriod(Period40_N.convertPeriod(src.getDataPeriod()));
    for (org.hl7.fhir.r4.model.Consent.provisionDataComponent t : src.getData())
      tgt.addData(convertprovisionDataComponent(t));
    for (org.hl7.fhir.r4.model.Consent.ProvisionComponent t : src.getProvision())
      tgt.addProvision(convertprovisionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Consent.ProvisionComponent convertprovisionComponent(org.hl7.fhir.model.core.Consent.ProvisionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Consent.ProvisionComponent tgt = new org.hl7.fhir.r4.model.Consent.ProvisionComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
//    if (src.hasType())
//      tgt.setTypeElement(convertConsentProvisionType(src.getTypeElement()));
    if (src.hasPeriod())
      tgt.setPeriod(Period40_N.convertPeriod(src.getPeriod()));
    for (org.hl7.fhir.model.core.Consent.ProvisionActorComponent t : src.getActorList())
      tgt.addActor(convertprovisionActorComponent(t));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getActionList())
      tgt.addAction(CodeableConcept40_N.convertCodeableConcept(t));
    for (org.hl7.fhir.model.core.Coding t : src.getSecurityLabelList()) tgt.addSecurityLabel(Coding40_N.convertCoding(t));
    for (org.hl7.fhir.model.core.Coding t : src.getPurposeList()) tgt.addPurpose(Coding40_N.convertCoding(t));
//    for (org.hl7.fhir.model.core.Coding t : src.getClass_List()) tgt.addClass_(Coding40_N.convertCoding(t));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getCodeList())
      tgt.addCode(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasDataPeriod())
      tgt.setDataPeriod(Period40_N.convertPeriod(src.getDataPeriod()));
    for (org.hl7.fhir.model.core.Consent.ProvisionDataComponent t : src.getDataList())
      tgt.addData(convertprovisionDataComponent(t));
    for (org.hl7.fhir.model.core.Consent.ProvisionComponent t : src.getProvisionList())
      tgt.addProvision(convertprovisionComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Consent.ConsentProvisionType> convertConsentProvisionType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Consent.ConsentProvisionType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Consent.ConsentProvisionType> tgt = new Enumeration<>(new Consent.ConsentProvisionTypeEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Consent.ConsentProvisionType> convertConsentProvisionType(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Consent.ConsentProvisionType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Consent.ConsentProvisionType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Consent.ConsentProvisionTypeEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
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
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.Consent.ProvisionActorComponent convertprovisionActorComponent(org.hl7.fhir.r4.model.Consent.provisionActorComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Consent.ProvisionActorComponent tgt = new org.hl7.fhir.model.core.Consent.ProvisionActorComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasRole())
      tgt.setRole(CodeableConcept40_N.convertCodeableConcept(src.getRole()));
    if (src.hasReference())
      tgt.setReference(Reference40_N.convertReference(src.getReference()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Consent.provisionActorComponent convertprovisionActorComponent(org.hl7.fhir.model.core.Consent.ProvisionActorComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Consent.provisionActorComponent tgt = new org.hl7.fhir.r4.model.Consent.provisionActorComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasRole())
      tgt.setRole(CodeableConcept40_N.convertCodeableConcept(src.getRole()));
    if (src.hasReference())
      tgt.setReference(Reference40_N.convertReference(src.getReference()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.Consent.ProvisionDataComponent convertprovisionDataComponent(org.hl7.fhir.r4.model.Consent.provisionDataComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Consent.ProvisionDataComponent tgt = new org.hl7.fhir.model.core.Consent.ProvisionDataComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasMeaning())
      tgt.setMeaningElement(convertConsentDataMeaning(src.getMeaningElement()));
    if (src.hasReference())
      tgt.setReference(Reference40_N.convertReference(src.getReference()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Consent.provisionDataComponent convertprovisionDataComponent(org.hl7.fhir.model.core.Consent.ProvisionDataComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Consent.provisionDataComponent tgt = new org.hl7.fhir.r4.model.Consent.provisionDataComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasMeaning())
      tgt.setMeaningElement(convertConsentDataMeaning(src.getMeaningElement()));
    if (src.hasReference())
      tgt.setReference(Reference40_N.convertReference(src.getReference()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Consent.ConsentDataMeaning> convertConsentDataMeaning(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Consent.ConsentDataMeaning> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Consent.ConsentDataMeaning> tgt = new Enumeration<>(new Consent.ConsentDataMeaningEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Consent.ConsentDataMeaning> convertConsentDataMeaning(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Consent.ConsentDataMeaning> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Consent.ConsentDataMeaning> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Consent.ConsentDataMeaningEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
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
      }
      return tgt;
  }
}
