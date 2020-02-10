package org.hl7.fhir.convertors.conv30_40;

import org.hl7.fhir.convertors.VersionConvertor_30_40;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.CodeableConcept;
import java.util.List;
import java.util.Collections;

public class Consent30_40 {

    static public org.hl7.fhir.r4.model.Consent convertConsent(org.hl7.fhir.dstu3.model.Consent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Consent tgt = new org.hl7.fhir.r4.model.Consent();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        if (src.hasIdentifier())
            tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(src.getIdentifier()));
        if (src.hasStatus())
            tgt.setStatus(convertConsentState(src.getStatus()));
        if (src.hasCategory()) {
            for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getCategory()) tgt.addCategory(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        if (src.hasPatient())
            tgt.setPatient(VersionConvertor_30_40.convertReference(src.getPatient()));
        if (src.hasDateTimeElement())
            tgt.setDateTimeElement(VersionConvertor_30_40.convertDateTime(src.getDateTimeElement()));
        if (src.hasConsentingParty()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getConsentingParty()) tgt.addPerformer(VersionConvertor_30_40.convertReference(t));
        }
        if (src.hasOrganization()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getOrganization()) tgt.addOrganization(VersionConvertor_30_40.convertReference(t));
        }
        if (src.hasSource())
            tgt.setSource(VersionConvertor_30_40.convertType(src.getSource()));
        if (src.hasPolicy()) {
            for (org.hl7.fhir.dstu3.model.Consent.ConsentPolicyComponent t : src.getPolicy()) tgt.addPolicy(convertConsentPolicyComponent(t));
        }
        if (src.hasPolicyRule()) {
            org.hl7.fhir.r4.model.Coding c = new org.hl7.fhir.r4.model.Coding();
            c.setSystem(VersionConvertor_30_40.URN_IETF_RFC_3986);
            if (src.hasPolicyRule()) {
                c.setCode(src.getPolicyRule());
            }
            tgt.setPolicyRule(new CodeableConcept(c));
        }
        if (src.hasSecurityLabel() || src.hasPeriod() || src.hasActor() || src.hasAction() || src.hasPurpose() || src.hasDataPeriod() || src.hasData() || src.hasExcept()) {
            org.hl7.fhir.r4.model.Consent.provisionComponent pc = new org.hl7.fhir.r4.model.Consent.provisionComponent();
            if (src.hasPeriod())
                pc.setPeriod(VersionConvertor_30_40.convertPeriod(src.getPeriod()));
            if (src.hasActor()) {
                for (org.hl7.fhir.dstu3.model.Consent.ConsentActorComponent t : src.getActor()) pc.addActor(convertConsentActorComponent(t));
            }
            if (src.hasAction()) {
                for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getAction()) pc.addAction(VersionConvertor_30_40.convertCodeableConcept(t));
            }
            if (src.hasSecurityLabel()) {
                for (org.hl7.fhir.dstu3.model.Coding t : src.getSecurityLabel()) pc.addSecurityLabel(VersionConvertor_30_40.convertCoding(t));
            }
            if (src.hasPurpose()) {
                for (org.hl7.fhir.dstu3.model.Coding t : src.getPurpose()) pc.addPurpose(VersionConvertor_30_40.convertCoding(t));
            }
            if (src.hasDataPeriod())
                pc.setDataPeriod(VersionConvertor_30_40.convertPeriod(src.getDataPeriod()));
            if (src.hasData()) {
                for (org.hl7.fhir.dstu3.model.Consent.ConsentDataComponent t : src.getData()) pc.addData(convertConsentDataComponent(t));
            }
            if (src.hasExcept()) {
                for (org.hl7.fhir.dstu3.model.Consent.ExceptComponent t : src.getExcept()) pc.addProvision(convertExceptComponent(t));
            }
            tgt.setProvision(pc);
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Consent convertConsent(org.hl7.fhir.r4.model.Consent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Consent tgt = new org.hl7.fhir.dstu3.model.Consent();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        List<org.hl7.fhir.r4.model.Identifier> identifier = src.getIdentifier();
        if (identifier.size() > 0) {
            tgt.setIdentifier(VersionConvertor_30_40.convertIdentifier(identifier.get(0)));
            if (identifier.size() > 1) {
            }
        }
        if (src.hasStatus())
            tgt.setStatus(convertConsentState(src.getStatus()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCategory()) tgt.addCategory(VersionConvertor_30_40.convertCodeableConcept(t));
        if (src.hasPatient())
            tgt.setPatient(VersionConvertor_30_40.convertReference(src.getPatient()));
        if (src.hasDateTimeElement())
            tgt.setDateTimeElement(VersionConvertor_30_40.convertDateTime(src.getDateTimeElement()));
        for (org.hl7.fhir.r4.model.Reference t : src.getPerformer()) tgt.addConsentingParty(VersionConvertor_30_40.convertReference(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getOrganization()) tgt.addOrganization(VersionConvertor_30_40.convertReference(t));
        if (src.hasSource())
            tgt.setSource(VersionConvertor_30_40.convertType(src.getSource()));
        for (org.hl7.fhir.r4.model.Consent.ConsentPolicyComponent t : src.getPolicy()) tgt.addPolicy(convertConsentPolicyComponent(t));
        if (src.hasPolicyRule()) {
            for (org.hl7.fhir.r4.model.Coding c : src.getPolicyRule().getCoding()) {
                if (VersionConvertor_30_40.URN_IETF_RFC_3986.equals(c.getSystem())) {
                    tgt.setPolicyRule(c.getCode());
                    break;
                }
            }
        }
        if (src.hasProvision()) {
            org.hl7.fhir.r4.model.Consent.provisionComponent p = src.getProvision();
            if (p.hasPeriod())
                tgt.setPeriod(VersionConvertor_30_40.convertPeriod(p.getPeriod()));
            for (org.hl7.fhir.r4.model.Consent.provisionActorComponent t : p.getActor()) tgt.addActor(convertConsentActorComponent(t));
            for (org.hl7.fhir.r4.model.CodeableConcept t : p.getAction()) tgt.addAction(VersionConvertor_30_40.convertCodeableConcept(t));
            for (org.hl7.fhir.r4.model.Coding t : p.getSecurityLabel()) tgt.addSecurityLabel(VersionConvertor_30_40.convertCoding(t));
            for (org.hl7.fhir.r4.model.Coding t : p.getPurpose()) tgt.addPurpose(VersionConvertor_30_40.convertCoding(t));
            if (p.hasDataPeriod())
                tgt.setDataPeriod(VersionConvertor_30_40.convertPeriod(p.getDataPeriod()));
            for (org.hl7.fhir.r4.model.Consent.provisionDataComponent t : p.getData()) tgt.addData(convertConsentDataComponent(t));
            for (org.hl7.fhir.r4.model.Consent.provisionComponent t : p.getProvision()) tgt.addExcept(convertExceptComponent(t));
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Consent.ConsentActorComponent convertConsentActorComponent(org.hl7.fhir.r4.model.Consent.provisionActorComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Consent.ConsentActorComponent tgt = new org.hl7.fhir.dstu3.model.Consent.ConsentActorComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasRole())
            tgt.setRole(VersionConvertor_30_40.convertCodeableConcept(src.getRole()));
        if (src.hasReference())
            tgt.setReference(VersionConvertor_30_40.convertReference(src.getReference()));
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Consent.provisionActorComponent convertConsentActorComponent(org.hl7.fhir.dstu3.model.Consent.ConsentActorComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Consent.provisionActorComponent tgt = new org.hl7.fhir.r4.model.Consent.provisionActorComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasRole())
            tgt.setRole(VersionConvertor_30_40.convertCodeableConcept(src.getRole()));
        if (src.hasReference())
            tgt.setReference(VersionConvertor_30_40.convertReference(src.getReference()));
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Consent.provisionDataComponent convertConsentDataComponent(org.hl7.fhir.dstu3.model.Consent.ConsentDataComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Consent.provisionDataComponent tgt = new org.hl7.fhir.r4.model.Consent.provisionDataComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasMeaning())
            tgt.setMeaning(convertConsentDataMeaning(src.getMeaning()));
        if (src.hasReference())
            tgt.setReference(VersionConvertor_30_40.convertReference(src.getReference()));
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Consent.ConsentDataComponent convertConsentDataComponent(org.hl7.fhir.r4.model.Consent.provisionDataComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Consent.ConsentDataComponent tgt = new org.hl7.fhir.dstu3.model.Consent.ConsentDataComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasMeaning())
            tgt.setMeaning(convertConsentDataMeaning(src.getMeaning()));
        if (src.hasReference())
            tgt.setReference(VersionConvertor_30_40.convertReference(src.getReference()));
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Consent.ConsentDataMeaning convertConsentDataMeaning(org.hl7.fhir.dstu3.model.Consent.ConsentDataMeaning src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case INSTANCE:
                return org.hl7.fhir.r4.model.Consent.ConsentDataMeaning.INSTANCE;
            case RELATED:
                return org.hl7.fhir.r4.model.Consent.ConsentDataMeaning.RELATED;
            case DEPENDENTS:
                return org.hl7.fhir.r4.model.Consent.ConsentDataMeaning.DEPENDENTS;
            case AUTHOREDBY:
                return org.hl7.fhir.r4.model.Consent.ConsentDataMeaning.AUTHOREDBY;
            default:
                return org.hl7.fhir.r4.model.Consent.ConsentDataMeaning.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.Consent.ConsentDataMeaning convertConsentDataMeaning(org.hl7.fhir.r4.model.Consent.ConsentDataMeaning src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case INSTANCE:
                return org.hl7.fhir.dstu3.model.Consent.ConsentDataMeaning.INSTANCE;
            case RELATED:
                return org.hl7.fhir.dstu3.model.Consent.ConsentDataMeaning.RELATED;
            case DEPENDENTS:
                return org.hl7.fhir.dstu3.model.Consent.ConsentDataMeaning.DEPENDENTS;
            case AUTHOREDBY:
                return org.hl7.fhir.dstu3.model.Consent.ConsentDataMeaning.AUTHOREDBY;
            default:
                return org.hl7.fhir.dstu3.model.Consent.ConsentDataMeaning.NULL;
        }
    }

    static public org.hl7.fhir.r4.model.Consent.ConsentProvisionType convertConsentExceptType(org.hl7.fhir.dstu3.model.Consent.ConsentExceptType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case DENY:
                return org.hl7.fhir.r4.model.Consent.ConsentProvisionType.DENY;
            case PERMIT:
                return org.hl7.fhir.r4.model.Consent.ConsentProvisionType.PERMIT;
            default:
                return org.hl7.fhir.r4.model.Consent.ConsentProvisionType.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.Consent.ConsentExceptType convertConsentExceptType(org.hl7.fhir.r4.model.Consent.ConsentProvisionType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case DENY:
                return org.hl7.fhir.dstu3.model.Consent.ConsentExceptType.DENY;
            case PERMIT:
                return org.hl7.fhir.dstu3.model.Consent.ConsentExceptType.PERMIT;
            default:
                return org.hl7.fhir.dstu3.model.Consent.ConsentExceptType.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.Consent.ConsentPolicyComponent convertConsentPolicyComponent(org.hl7.fhir.r4.model.Consent.ConsentPolicyComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Consent.ConsentPolicyComponent tgt = new org.hl7.fhir.dstu3.model.Consent.ConsentPolicyComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasAuthorityElement())
            tgt.setAuthorityElement((org.hl7.fhir.dstu3.model.UriType) VersionConvertor_30_40.convertType(src.getAuthorityElement()));
        if (src.hasUriElement())
            tgt.setUriElement((org.hl7.fhir.dstu3.model.UriType) VersionConvertor_30_40.convertType(src.getUriElement()));
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Consent.ConsentPolicyComponent convertConsentPolicyComponent(org.hl7.fhir.dstu3.model.Consent.ConsentPolicyComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Consent.ConsentPolicyComponent tgt = new org.hl7.fhir.r4.model.Consent.ConsentPolicyComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasAuthorityElement())
            tgt.setAuthorityElement((org.hl7.fhir.r4.model.UriType) VersionConvertor_30_40.convertType(src.getAuthorityElement()));
        if (src.hasUriElement())
            tgt.setUriElement((org.hl7.fhir.r4.model.UriType) VersionConvertor_30_40.convertType(src.getUriElement()));
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Consent.ConsentState convertConsentState(org.hl7.fhir.r4.model.Consent.ConsentState src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case DRAFT:
                return org.hl7.fhir.dstu3.model.Consent.ConsentState.DRAFT;
            case PROPOSED:
                return org.hl7.fhir.dstu3.model.Consent.ConsentState.PROPOSED;
            case ACTIVE:
                return org.hl7.fhir.dstu3.model.Consent.ConsentState.ACTIVE;
            case REJECTED:
                return org.hl7.fhir.dstu3.model.Consent.ConsentState.REJECTED;
            case INACTIVE:
                return org.hl7.fhir.dstu3.model.Consent.ConsentState.INACTIVE;
            case ENTEREDINERROR:
                return org.hl7.fhir.dstu3.model.Consent.ConsentState.ENTEREDINERROR;
            default:
                return org.hl7.fhir.dstu3.model.Consent.ConsentState.NULL;
        }
    }

    static public org.hl7.fhir.r4.model.Consent.ConsentState convertConsentState(org.hl7.fhir.dstu3.model.Consent.ConsentState src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case DRAFT:
                return org.hl7.fhir.r4.model.Consent.ConsentState.DRAFT;
            case PROPOSED:
                return org.hl7.fhir.r4.model.Consent.ConsentState.PROPOSED;
            case ACTIVE:
                return org.hl7.fhir.r4.model.Consent.ConsentState.ACTIVE;
            case REJECTED:
                return org.hl7.fhir.r4.model.Consent.ConsentState.REJECTED;
            case INACTIVE:
                return org.hl7.fhir.r4.model.Consent.ConsentState.INACTIVE;
            case ENTEREDINERROR:
                return org.hl7.fhir.r4.model.Consent.ConsentState.ENTEREDINERROR;
            default:
                return org.hl7.fhir.r4.model.Consent.ConsentState.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.Consent.ExceptActorComponent convertExceptActorComponent(org.hl7.fhir.r4.model.Consent.provisionActorComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Consent.ExceptActorComponent tgt = new org.hl7.fhir.dstu3.model.Consent.ExceptActorComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasRole())
            tgt.setRole(VersionConvertor_30_40.convertCodeableConcept(src.getRole()));
        if (src.hasReference())
            tgt.setReference(VersionConvertor_30_40.convertReference(src.getReference()));
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Consent.provisionActorComponent convertExceptActorComponent(org.hl7.fhir.dstu3.model.Consent.ExceptActorComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Consent.provisionActorComponent tgt = new org.hl7.fhir.r4.model.Consent.provisionActorComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasRole())
            tgt.setRole(VersionConvertor_30_40.convertCodeableConcept(src.getRole()));
        if (src.hasReference())
            tgt.setReference(VersionConvertor_30_40.convertReference(src.getReference()));
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Consent.ExceptComponent convertExceptComponent(org.hl7.fhir.r4.model.Consent.provisionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Consent.ExceptComponent tgt = new org.hl7.fhir.dstu3.model.Consent.ExceptComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasType())
            tgt.setType(convertConsentExceptType(src.getType()));
        if (src.hasPeriod())
            tgt.setPeriod(VersionConvertor_30_40.convertPeriod(src.getPeriod()));
        if (src.hasActor()) {
            for (org.hl7.fhir.r4.model.Consent.provisionActorComponent t : src.getActor()) tgt.addActor(convertExceptActorComponent(t));
        }
        if (src.hasAction()) {
            for (org.hl7.fhir.r4.model.CodeableConcept t : src.getAction()) tgt.addAction(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        if (src.hasSecurityLabel()) {
            for (org.hl7.fhir.r4.model.Coding t : src.getSecurityLabel()) tgt.addSecurityLabel(VersionConvertor_30_40.convertCoding(t));
        }
        if (src.hasPurpose()) {
            for (org.hl7.fhir.r4.model.Coding t : src.getPurpose()) tgt.addPurpose(VersionConvertor_30_40.convertCoding(t));
        }
        if (src.hasClass_()) {
            for (org.hl7.fhir.r4.model.Coding t : src.getClass_()) tgt.addClass_(VersionConvertor_30_40.convertCoding(t));
        }
        if (src.hasCode()) {
            for (CodeableConcept t : src.getCode()) tgt.addCode(VersionConvertor_30_40.convertCoding(t));
        }
        if (src.hasDataPeriod())
            tgt.setDataPeriod(VersionConvertor_30_40.convertPeriod(src.getDataPeriod()));
        if (src.hasData()) {
            for (org.hl7.fhir.r4.model.Consent.provisionDataComponent t : src.getData()) tgt.addData(convertExceptDataComponent(t));
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Consent.provisionComponent convertExceptComponent(org.hl7.fhir.dstu3.model.Consent.ExceptComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Consent.provisionComponent tgt = new org.hl7.fhir.r4.model.Consent.provisionComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasType())
            tgt.setType(convertConsentExceptType(src.getType()));
        if (src.hasPeriod())
            tgt.setPeriod(VersionConvertor_30_40.convertPeriod(src.getPeriod()));
        if (src.hasActor()) {
            for (org.hl7.fhir.dstu3.model.Consent.ExceptActorComponent t : src.getActor()) tgt.addActor(convertExceptActorComponent(t));
        }
        if (src.hasAction()) {
            for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getAction()) tgt.addAction(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        if (src.hasSecurityLabel()) {
            for (org.hl7.fhir.dstu3.model.Coding t : src.getSecurityLabel()) tgt.addSecurityLabel(VersionConvertor_30_40.convertCoding(t));
        }
        if (src.hasPurpose()) {
            for (org.hl7.fhir.dstu3.model.Coding t : src.getPurpose()) tgt.addPurpose(VersionConvertor_30_40.convertCoding(t));
        }
        if (src.hasClass_()) {
            for (org.hl7.fhir.dstu3.model.Coding t : src.getClass_()) tgt.addClass_(VersionConvertor_30_40.convertCoding(t));
        }
        if (src.hasCode()) {
            for (org.hl7.fhir.dstu3.model.Coding t : src.getCode()) tgt.addCode(new CodeableConcept(VersionConvertor_30_40.convertCoding(t)));
        }
        if (src.hasDataPeriod())
            tgt.setDataPeriod(VersionConvertor_30_40.convertPeriod(src.getDataPeriod()));
        if (src.hasData()) {
            for (org.hl7.fhir.dstu3.model.Consent.ExceptDataComponent t : src.getData()) tgt.addData(convertExceptDataComponent(t));
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Consent.ExceptDataComponent convertExceptDataComponent(org.hl7.fhir.r4.model.Consent.provisionDataComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Consent.ExceptDataComponent tgt = new org.hl7.fhir.dstu3.model.Consent.ExceptDataComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasMeaning())
            tgt.setMeaning(convertConsentDataMeaning(src.getMeaning()));
        if (src.hasReference())
            tgt.setReference(VersionConvertor_30_40.convertReference(src.getReference()));
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Consent.provisionDataComponent convertExceptDataComponent(org.hl7.fhir.dstu3.model.Consent.ExceptDataComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Consent.provisionDataComponent tgt = new org.hl7.fhir.r4.model.Consent.provisionDataComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasMeaning())
            tgt.setMeaning(convertConsentDataMeaning(src.getMeaning()));
        if (src.hasReference())
            tgt.setReference(VersionConvertor_30_40.convertReference(src.getReference()));
        return tgt;
    }
}
