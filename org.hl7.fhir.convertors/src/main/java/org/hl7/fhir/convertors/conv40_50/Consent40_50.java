package org.hl7.fhir.convertors.conv40_50;


import org.hl7.fhir.convertors.VersionConvertor_40_50;
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
public class Consent40_50 extends VersionConvertor_40_50 {

    public static org.hl7.fhir.r5.model.Consent convertConsent(org.hl7.fhir.r4.model.Consent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Consent tgt = new org.hl7.fhir.r5.model.Consent();
        copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        if (src.hasStatus())
            tgt.setStatusElement(convertConsentState(src.getStatusElement()));
        if (src.hasScope())
            tgt.setScope(convertCodeableConcept(src.getScope()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCategory()) tgt.addCategory(convertCodeableConcept(t));
        if (src.hasPatient())
            tgt.setSubject(convertReference(src.getPatient()));
        if (src.hasDateTime())
            tgt.setDateTimeElement(convertDateTime(src.getDateTimeElement()));
        for (org.hl7.fhir.r4.model.Reference t : src.getPerformer()) tgt.addPerformer(convertReference(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getOrganization()) tgt.addOrganization(convertReference(t));
        if (src.hasSourceAttachment())
            tgt.addSourceAttachment(convertAttachment(src.getSourceAttachment()));
        if (src.hasSourceReference())
            tgt.addSourceReference(convertReference(src.getSourceReference()));
        for (org.hl7.fhir.r4.model.Consent.ConsentPolicyComponent t : src.getPolicy()) tgt.addPolicy(convertConsentPolicyComponent(t));
        if (src.hasPolicyRule())
            tgt.setPolicyRule(convertCodeableConcept(src.getPolicyRule()));
        for (org.hl7.fhir.r4.model.Consent.ConsentVerificationComponent t : src.getVerification()) tgt.addVerification(convertConsentVerificationComponent(t));
        if (src.hasProvision())
            tgt.setProvision(convertprovisionComponent(src.getProvision()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Consent convertConsent(org.hl7.fhir.r5.model.Consent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Consent tgt = new org.hl7.fhir.r4.model.Consent();
        copyDomainResource(src, tgt);
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        if (src.hasStatus())
            tgt.setStatusElement(convertConsentState(src.getStatusElement()));
        if (src.hasScope())
            tgt.setScope(convertCodeableConcept(src.getScope()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCategory()) tgt.addCategory(convertCodeableConcept(t));
        if (src.hasSubject())
            tgt.setPatient(convertReference(src.getSubject()));
        if (src.hasDateTime())
            tgt.setDateTimeElement(convertDateTime(src.getDateTimeElement()));
        for (org.hl7.fhir.r5.model.Reference t : src.getPerformer()) tgt.addPerformer(convertReference(t));
        for (org.hl7.fhir.r5.model.Reference t : src.getOrganization()) tgt.addOrganization(convertReference(t));
        if (src.hasSourceAttachment())
            tgt.setSource(convertType(src.getSourceAttachmentFirstRep()));
        if (src.hasSourceReference())
            tgt.setSource(convertType(src.getSourceReferenceFirstRep()));
        for (org.hl7.fhir.r5.model.Consent.ConsentPolicyComponent t : src.getPolicy()) tgt.addPolicy(convertConsentPolicyComponent(t));
        if (src.hasPolicyRule())
            tgt.setPolicyRule(convertCodeableConcept(src.getPolicyRule()));
        for (org.hl7.fhir.r5.model.Consent.ConsentVerificationComponent t : src.getVerification()) tgt.addVerification(convertConsentVerificationComponent(t));
        if (src.hasProvision())
            tgt.setProvision(convertprovisionComponent(src.getProvision()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Consent.ConsentState> convertConsentState(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Consent.ConsentState> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Consent.ConsentState> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Consent.ConsentStateEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
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
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
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
            tgt.getVerificationDate().add(convertDateTime(src.getVerificationDateElement()));
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
            tgt.setVerificationDateElement(convertDateTime(src.getVerificationDate().get(0)));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Consent.ProvisionComponent convertprovisionComponent(org.hl7.fhir.r4.model.Consent.provisionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Consent.ProvisionComponent tgt = new org.hl7.fhir.r5.model.Consent.ProvisionComponent();
        copyElement(src, tgt);
        if (src.hasType())
            tgt.setTypeElement(convertConsentProvisionType(src.getTypeElement()));
        if (src.hasPeriod())
            tgt.setPeriod(convertPeriod(src.getPeriod()));
        for (org.hl7.fhir.r4.model.Consent.provisionActorComponent t : src.getActor()) tgt.addActor(convertprovisionActorComponent(t));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getAction()) tgt.addAction(convertCodeableConcept(t));
        for (org.hl7.fhir.r4.model.Coding t : src.getSecurityLabel()) tgt.addSecurityLabel(convertCoding(t));
        for (org.hl7.fhir.r4.model.Coding t : src.getPurpose()) tgt.addPurpose(convertCoding(t));
        for (org.hl7.fhir.r4.model.Coding t : src.getClass_()) tgt.addClass_(convertCoding(t));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCode()) tgt.addCode(convertCodeableConcept(t));
        if (src.hasDataPeriod())
            tgt.setDataPeriod(convertPeriod(src.getDataPeriod()));
        for (org.hl7.fhir.r4.model.Consent.provisionDataComponent t : src.getData()) tgt.addData(convertprovisionDataComponent(t));
        for (org.hl7.fhir.r4.model.Consent.provisionComponent t : src.getProvision()) tgt.addProvision(convertprovisionComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Consent.provisionComponent convertprovisionComponent(org.hl7.fhir.r5.model.Consent.ProvisionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Consent.provisionComponent tgt = new org.hl7.fhir.r4.model.Consent.provisionComponent();
        copyElement(src, tgt);
        if (src.hasType())
            tgt.setTypeElement(convertConsentProvisionType(src.getTypeElement()));
        if (src.hasPeriod())
            tgt.setPeriod(convertPeriod(src.getPeriod()));
        for (org.hl7.fhir.r5.model.Consent.ProvisionActorComponent t : src.getActor()) tgt.addActor(convertprovisionActorComponent(t));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getAction()) tgt.addAction(convertCodeableConcept(t));
        for (org.hl7.fhir.r5.model.Coding t : src.getSecurityLabel()) tgt.addSecurityLabel(convertCoding(t));
        for (org.hl7.fhir.r5.model.Coding t : src.getPurpose()) tgt.addPurpose(convertCoding(t));
        for (org.hl7.fhir.r5.model.Coding t : src.getClass_()) tgt.addClass_(convertCoding(t));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCode()) tgt.addCode(convertCodeableConcept(t));
        if (src.hasDataPeriod())
            tgt.setDataPeriod(convertPeriod(src.getDataPeriod()));
        for (org.hl7.fhir.r5.model.Consent.ProvisionDataComponent t : src.getData()) tgt.addData(convertprovisionDataComponent(t));
        for (org.hl7.fhir.r5.model.Consent.ProvisionComponent t : src.getProvision()) tgt.addProvision(convertprovisionComponent(t));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Consent.ConsentProvisionType> convertConsentProvisionType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Consent.ConsentProvisionType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Consent.ConsentProvisionType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Consent.ConsentProvisionTypeEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case DENY:
                tgt.setValue(org.hl7.fhir.r5.model.Consent.ConsentProvisionType.DENY);
                break;
            case PERMIT:
                tgt.setValue(org.hl7.fhir.r5.model.Consent.ConsentProvisionType.PERMIT);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Consent.ConsentProvisionType.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Consent.ConsentProvisionType> convertConsentProvisionType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Consent.ConsentProvisionType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Consent.ConsentProvisionType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Consent.ConsentProvisionTypeEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
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
        copyElement(src, tgt);
        if (src.hasRole())
            tgt.setRole(convertCodeableConcept(src.getRole()));
        if (src.hasReference())
            tgt.setReference(convertReference(src.getReference()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Consent.provisionActorComponent convertprovisionActorComponent(org.hl7.fhir.r5.model.Consent.ProvisionActorComponent src) throws FHIRException {
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

    public static org.hl7.fhir.r5.model.Consent.ProvisionDataComponent convertprovisionDataComponent(org.hl7.fhir.r4.model.Consent.provisionDataComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Consent.ProvisionDataComponent tgt = new org.hl7.fhir.r5.model.Consent.ProvisionDataComponent();
        copyElement(src, tgt);
        if (src.hasMeaning())
            tgt.setMeaningElement(convertConsentDataMeaning(src.getMeaningElement()));
        if (src.hasReference())
            tgt.setReference(convertReference(src.getReference()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Consent.provisionDataComponent convertprovisionDataComponent(org.hl7.fhir.r5.model.Consent.ProvisionDataComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Consent.provisionDataComponent tgt = new org.hl7.fhir.r4.model.Consent.provisionDataComponent();
        copyElement(src, tgt);
        if (src.hasMeaning())
            tgt.setMeaningElement(convertConsentDataMeaning(src.getMeaningElement()));
        if (src.hasReference())
            tgt.setReference(convertReference(src.getReference()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Consent.ConsentDataMeaning> convertConsentDataMeaning(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Consent.ConsentDataMeaning> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Consent.ConsentDataMeaning> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Consent.ConsentDataMeaningEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case INSTANCE:
                tgt.setValue(org.hl7.fhir.r5.model.Consent.ConsentDataMeaning.INSTANCE);
                break;
            case RELATED:
                tgt.setValue(org.hl7.fhir.r5.model.Consent.ConsentDataMeaning.RELATED);
                break;
            case DEPENDENTS:
                tgt.setValue(org.hl7.fhir.r5.model.Consent.ConsentDataMeaning.DEPENDENTS);
                break;
            case AUTHOREDBY:
                tgt.setValue(org.hl7.fhir.r5.model.Consent.ConsentDataMeaning.AUTHOREDBY);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Consent.ConsentDataMeaning.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Consent.ConsentDataMeaning> convertConsentDataMeaning(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Consent.ConsentDataMeaning> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Consent.ConsentDataMeaning> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Consent.ConsentDataMeaningEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
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