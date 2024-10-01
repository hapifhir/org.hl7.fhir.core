package org.hl7.fhir.convertors.conv30_40.resources30_40;

import java.util.List;

import org.hl7.fhir.convertors.context.ConversionContext30_40;
import org.hl7.fhir.convertors.conv30_40.VersionConvertor_30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Reference30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.CodeableConcept30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Coding30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Identifier30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Period30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.DateTime30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.Uri30_40;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Identifier;

public class Consent30_40 {

  static public org.hl7.fhir.r4.model.Consent convertConsent(org.hl7.fhir.dstu3.model.Consent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Consent tgt = new org.hl7.fhir.r4.model.Consent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyDomainResource(src, tgt);
    if (src.hasIdentifier())
      tgt.addIdentifier(Identifier30_40.convertIdentifier(src.getIdentifier()));
    if (src.hasStatus())
      tgt.setStatusElement(convertConsentState(src.getStatusElement()));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept30_40.convertCodeableConcept(t));
    if (src.hasPatient())
      tgt.setPatient(Reference30_40.convertReference(src.getPatient()));
    if (src.hasDateTime())
      tgt.setDateTimeElement(DateTime30_40.convertDateTime(src.getDateTimeElement()));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getConsentingParty())
      tgt.addPerformer(Reference30_40.convertReference(t));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getOrganization())
      tgt.addOrganization(Reference30_40.convertReference(t));
    if (src.hasSource())
      tgt.setSource(ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().convertType(src.getSource()));
    for (org.hl7.fhir.dstu3.model.Consent.ConsentPolicyComponent t : src.getPolicy())
      tgt.addPolicy(convertConsentPolicyComponent(t));
    if (src.hasPolicyRule()) {
      org.hl7.fhir.r4.model.Coding c = new org.hl7.fhir.r4.model.Coding();
      c.setSystem(VersionConvertor_30_40.URN_IETF_RFC_3986);
      c.setCode(src.getPolicyRule());
      tgt.setPolicyRule(new CodeableConcept(c));
    }
    if (src.hasSecurityLabel() || src.hasPeriod() || src.hasActor() || src.hasAction() || src.hasPurpose() || src.hasDataPeriod() || src.hasData() || src.hasExcept()) {
      org.hl7.fhir.r4.model.Consent.ProvisionComponent pc = new org.hl7.fhir.r4.model.Consent.ProvisionComponent();
      if (src.hasPeriod())
        pc.setPeriod(Period30_40.convertPeriod(src.getPeriod()));
      for (org.hl7.fhir.dstu3.model.Consent.ConsentActorComponent t : src.getActor())
        pc.addActor(convertConsentActorComponent(t));
      for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getAction())
        pc.addAction(CodeableConcept30_40.convertCodeableConcept(t));
      for (org.hl7.fhir.dstu3.model.Coding t : src.getSecurityLabel())
        pc.addSecurityLabel(Coding30_40.convertCoding(t));
      for (org.hl7.fhir.dstu3.model.Coding t : src.getPurpose()) pc.addPurpose(Coding30_40.convertCoding(t));
      if (src.hasDataPeriod())
        pc.setDataPeriod(Period30_40.convertPeriod(src.getDataPeriod()));
      for (org.hl7.fhir.dstu3.model.Consent.ConsentDataComponent t : src.getData())
        pc.addData(convertConsentDataComponent(t));
      for (org.hl7.fhir.dstu3.model.Consent.ExceptComponent t : src.getExcept())
        pc.addProvision(convertExceptComponent(t));
      tgt.setProvision(pc);
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Consent convertConsent(org.hl7.fhir.r4.model.Consent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.Consent tgt = new org.hl7.fhir.dstu3.model.Consent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyDomainResource(src, tgt);
    List<Identifier> identifier = src.getIdentifier();
    if (identifier.size() > 0) {
      tgt.setIdentifier(Identifier30_40.convertIdentifier(identifier.get(0)));
      if (identifier.size() > 1) {
      }
    }
    if (src.hasStatus())
      tgt.setStatusElement(convertConsentState(src.getStatusElement()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept30_40.convertCodeableConcept(t));
    if (src.hasPatient())
      tgt.setPatient(Reference30_40.convertReference(src.getPatient()));
    if (src.hasDateTime())
      tgt.setDateTimeElement(DateTime30_40.convertDateTime(src.getDateTimeElement()));
    for (org.hl7.fhir.r4.model.Reference t : src.getPerformer())
      tgt.addConsentingParty(Reference30_40.convertReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getOrganization())
      tgt.addOrganization(Reference30_40.convertReference(t));
    if (src.hasSource())
      tgt.setSource(ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().convertType(src.getSource()));
    for (org.hl7.fhir.r4.model.Consent.ConsentPolicyComponent t : src.getPolicy())
      tgt.addPolicy(convertConsentPolicyComponent(t));
    if (src.hasPolicyRule()) {
      for (org.hl7.fhir.r4.model.Coding c : src.getPolicyRule().getCoding()) {
        if (VersionConvertor_30_40.URN_IETF_RFC_3986.equals(c.getSystem())) {
          tgt.setPolicyRule(c.getCode());
          break;
        }
      }
    }
    if (src.hasProvision()) {
      org.hl7.fhir.r4.model.Consent.ProvisionComponent p = src.getProvision();
      if (p.hasPeriod())
        tgt.setPeriod(Period30_40.convertPeriod(p.getPeriod()));
      for (org.hl7.fhir.r4.model.Consent.provisionActorComponent t : p.getActor())
        tgt.addActor(convertConsentActorComponent(t));
      for (org.hl7.fhir.r4.model.CodeableConcept t : p.getAction())
        tgt.addAction(CodeableConcept30_40.convertCodeableConcept(t));
      for (org.hl7.fhir.r4.model.Coding t : p.getSecurityLabel()) tgt.addSecurityLabel(Coding30_40.convertCoding(t));
      for (org.hl7.fhir.r4.model.Coding t : p.getPurpose()) tgt.addPurpose(Coding30_40.convertCoding(t));
      if (p.hasDataPeriod())
        tgt.setDataPeriod(Period30_40.convertPeriod(p.getDataPeriod()));
      for (org.hl7.fhir.r4.model.Consent.provisionDataComponent t : p.getData())
        tgt.addData(convertConsentDataComponent(t));
      for (org.hl7.fhir.r4.model.Consent.ProvisionComponent t : p.getProvision())
        tgt.addExcept(convertExceptComponent(t));
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Consent.ConsentActorComponent convertConsentActorComponent(org.hl7.fhir.r4.model.Consent.provisionActorComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.Consent.ConsentActorComponent tgt = new org.hl7.fhir.dstu3.model.Consent.ConsentActorComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src,tgt);
    if (src.hasRole())
      tgt.setRole(CodeableConcept30_40.convertCodeableConcept(src.getRole()));
    if (src.hasReference())
      tgt.setReference(Reference30_40.convertReference(src.getReference()));
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Consent.provisionActorComponent convertConsentActorComponent(org.hl7.fhir.dstu3.model.Consent.ConsentActorComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Consent.provisionActorComponent tgt = new org.hl7.fhir.r4.model.Consent.provisionActorComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src,tgt);
    if (src.hasRole())
      tgt.setRole(CodeableConcept30_40.convertCodeableConcept(src.getRole()));
    if (src.hasReference())
      tgt.setReference(Reference30_40.convertReference(src.getReference()));
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Consent.provisionDataComponent convertConsentDataComponent(org.hl7.fhir.dstu3.model.Consent.ConsentDataComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Consent.provisionDataComponent tgt = new org.hl7.fhir.r4.model.Consent.provisionDataComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src,tgt);
    if (src.hasMeaning())
      tgt.setMeaningElement(convertConsentDataMeaning(src.getMeaningElement()));
    if (src.hasReference())
      tgt.setReference(Reference30_40.convertReference(src.getReference()));
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Consent.ConsentDataComponent convertConsentDataComponent(org.hl7.fhir.r4.model.Consent.provisionDataComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.Consent.ConsentDataComponent tgt = new org.hl7.fhir.dstu3.model.Consent.ConsentDataComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src,tgt);
    if (src.hasMeaning())
      tgt.setMeaningElement(convertConsentDataMeaning(src.getMeaningElement()));
    if (src.hasReference())
      tgt.setReference(Reference30_40.convertReference(src.getReference()));
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Consent.ConsentDataMeaning> convertConsentDataMeaning(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Consent.ConsentDataMeaning> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Consent.ConsentDataMeaning> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Consent.ConsentDataMeaningEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
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

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Consent.ConsentDataMeaning> convertConsentDataMeaning(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Consent.ConsentDataMeaning> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Consent.ConsentDataMeaning> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Consent.ConsentDataMeaningEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case INSTANCE:
        tgt.setValue(org.hl7.fhir.dstu3.model.Consent.ConsentDataMeaning.INSTANCE);
        break;
      case RELATED:
        tgt.setValue(org.hl7.fhir.dstu3.model.Consent.ConsentDataMeaning.RELATED);
        break;
      case DEPENDENTS:
        tgt.setValue(org.hl7.fhir.dstu3.model.Consent.ConsentDataMeaning.DEPENDENTS);
        break;
      case AUTHOREDBY:
        tgt.setValue(org.hl7.fhir.dstu3.model.Consent.ConsentDataMeaning.AUTHOREDBY);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.Consent.ConsentDataMeaning.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Consent.ConsentProvisionType> convertConsentExceptType(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Consent.ConsentExceptType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Consent.ConsentProvisionType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Consent.ConsentProvisionTypeEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
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

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Consent.ConsentExceptType> convertConsentExceptType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Consent.ConsentProvisionType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Consent.ConsentExceptType> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Consent.ConsentExceptTypeEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case DENY:
        tgt.setValue(org.hl7.fhir.dstu3.model.Consent.ConsentExceptType.DENY);
        break;
      case PERMIT:
        tgt.setValue(org.hl7.fhir.dstu3.model.Consent.ConsentExceptType.PERMIT);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.Consent.ConsentExceptType.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Consent.ConsentPolicyComponent convertConsentPolicyComponent(org.hl7.fhir.r4.model.Consent.ConsentPolicyComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.Consent.ConsentPolicyComponent tgt = new org.hl7.fhir.dstu3.model.Consent.ConsentPolicyComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src,tgt);
    if (src.hasAuthority())
      tgt.setAuthorityElement(Uri30_40.convertUri(src.getAuthorityElement()));
    if (src.hasUri())
      tgt.setUriElement(Uri30_40.convertUri(src.getUriElement()));
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Consent.ConsentPolicyComponent convertConsentPolicyComponent(org.hl7.fhir.dstu3.model.Consent.ConsentPolicyComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Consent.ConsentPolicyComponent tgt = new org.hl7.fhir.r4.model.Consent.ConsentPolicyComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src,tgt);
    if (src.hasAuthority())
      tgt.setAuthorityElement(Uri30_40.convertUri(src.getAuthorityElement()));
    if (src.hasUri())
      tgt.setUriElement(Uri30_40.convertUri(src.getUriElement()));
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Consent.ConsentState> convertConsentState(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Consent.ConsentState> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Consent.ConsentState> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Consent.ConsentStateEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case DRAFT:
        tgt.setValue(org.hl7.fhir.dstu3.model.Consent.ConsentState.DRAFT);
        break;
      case PROPOSED:
        tgt.setValue(org.hl7.fhir.dstu3.model.Consent.ConsentState.PROPOSED);
        break;
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.dstu3.model.Consent.ConsentState.ACTIVE);
        break;
      case REJECTED:
        tgt.setValue(org.hl7.fhir.dstu3.model.Consent.ConsentState.REJECTED);
        break;
      case INACTIVE:
        tgt.setValue(org.hl7.fhir.dstu3.model.Consent.ConsentState.INACTIVE);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.dstu3.model.Consent.ConsentState.ENTEREDINERROR);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.Consent.ConsentState.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Consent.ConsentState> convertConsentState(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Consent.ConsentState> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Consent.ConsentState> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Consent.ConsentStateEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case DRAFT:
        tgt.setValue(org.hl7.fhir.r4.model.Consent.ConsentState.DRAFT);
        break;
      case PROPOSED:
        tgt.setValue(org.hl7.fhir.r4.model.Consent.ConsentState.PROPOSED);
        break;
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.r4.model.Consent.ConsentState.ACTIVE);
        break;
      case REJECTED:
        tgt.setValue(org.hl7.fhir.r4.model.Consent.ConsentState.REJECTED);
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

  static public org.hl7.fhir.dstu3.model.Consent.ExceptActorComponent convertExceptActorComponent(org.hl7.fhir.r4.model.Consent.provisionActorComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.Consent.ExceptActorComponent tgt = new org.hl7.fhir.dstu3.model.Consent.ExceptActorComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src,tgt);
    if (src.hasRole())
      tgt.setRole(CodeableConcept30_40.convertCodeableConcept(src.getRole()));
    if (src.hasReference())
      tgt.setReference(Reference30_40.convertReference(src.getReference()));
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Consent.provisionActorComponent convertExceptActorComponent(org.hl7.fhir.dstu3.model.Consent.ExceptActorComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Consent.provisionActorComponent tgt = new org.hl7.fhir.r4.model.Consent.provisionActorComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src,tgt);
    if (src.hasRole())
      tgt.setRole(CodeableConcept30_40.convertCodeableConcept(src.getRole()));
    if (src.hasReference())
      tgt.setReference(Reference30_40.convertReference(src.getReference()));
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Consent.ExceptComponent convertExceptComponent(org.hl7.fhir.r4.model.Consent.ProvisionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.Consent.ExceptComponent tgt = new org.hl7.fhir.dstu3.model.Consent.ExceptComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src,tgt);
    if (src.hasType())
      tgt.setTypeElement(convertConsentExceptType(src.getTypeElement()));
    if (src.hasPeriod())
      tgt.setPeriod(Period30_40.convertPeriod(src.getPeriod()));
    for (org.hl7.fhir.r4.model.Consent.provisionActorComponent t : src.getActor())
      tgt.addActor(convertExceptActorComponent(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getAction())
      tgt.addAction(CodeableConcept30_40.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.Coding t : src.getSecurityLabel()) tgt.addSecurityLabel(Coding30_40.convertCoding(t));
    for (org.hl7.fhir.r4.model.Coding t : src.getPurpose()) tgt.addPurpose(Coding30_40.convertCoding(t));
    for (org.hl7.fhir.r4.model.Coding t : src.getClass_()) tgt.addClass_(Coding30_40.convertCoding(t));
    for (CodeableConcept t : src.getCode()) tgt.addCode(Coding30_40.convertCoding(t));
    if (src.hasDataPeriod())
      tgt.setDataPeriod(Period30_40.convertPeriod(src.getDataPeriod()));
    for (org.hl7.fhir.r4.model.Consent.provisionDataComponent t : src.getData())
      tgt.addData(convertExceptDataComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Consent.ProvisionComponent convertExceptComponent(org.hl7.fhir.dstu3.model.Consent.ExceptComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Consent.ProvisionComponent tgt = new org.hl7.fhir.r4.model.Consent.ProvisionComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src,tgt);
    if (src.hasType())
      tgt.setTypeElement(convertConsentExceptType(src.getTypeElement()));
    if (src.hasPeriod())
      tgt.setPeriod(Period30_40.convertPeriod(src.getPeriod()));
    for (org.hl7.fhir.dstu3.model.Consent.ExceptActorComponent t : src.getActor())
      tgt.addActor(convertExceptActorComponent(t));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getAction())
      tgt.addAction(CodeableConcept30_40.convertCodeableConcept(t));
    for (org.hl7.fhir.dstu3.model.Coding t : src.getSecurityLabel()) tgt.addSecurityLabel(Coding30_40.convertCoding(t));
    for (org.hl7.fhir.dstu3.model.Coding t : src.getPurpose()) tgt.addPurpose(Coding30_40.convertCoding(t));
    for (org.hl7.fhir.dstu3.model.Coding t : src.getClass_()) tgt.addClass_(Coding30_40.convertCoding(t));
    for (org.hl7.fhir.dstu3.model.Coding t : src.getCode())
      tgt.addCode(new CodeableConcept(Coding30_40.convertCoding(t)));
    if (src.hasDataPeriod())
      tgt.setDataPeriod(Period30_40.convertPeriod(src.getDataPeriod()));
    for (org.hl7.fhir.dstu3.model.Consent.ExceptDataComponent t : src.getData())
      tgt.addData(convertExceptDataComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Consent.ExceptDataComponent convertExceptDataComponent(org.hl7.fhir.r4.model.Consent.provisionDataComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.Consent.ExceptDataComponent tgt = new org.hl7.fhir.dstu3.model.Consent.ExceptDataComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src,tgt);
    if (src.hasMeaning())
      tgt.setMeaningElement(convertConsentDataMeaning(src.getMeaningElement()));
    if (src.hasReference())
      tgt.setReference(Reference30_40.convertReference(src.getReference()));
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Consent.provisionDataComponent convertExceptDataComponent(org.hl7.fhir.dstu3.model.Consent.ExceptDataComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Consent.provisionDataComponent tgt = new org.hl7.fhir.r4.model.Consent.provisionDataComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src,tgt);
    if (src.hasMeaning())
      tgt.setMeaningElement(convertConsentDataMeaning(src.getMeaningElement()));
    if (src.hasReference())
      tgt.setReference(Reference30_40.convertReference(src.getReference()));
    return tgt;
  }
}