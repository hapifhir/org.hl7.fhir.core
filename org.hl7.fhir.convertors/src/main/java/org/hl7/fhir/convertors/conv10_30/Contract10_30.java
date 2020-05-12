package org.hl7.fhir.convertors.conv10_30;

import org.apache.commons.codec.binary.Base64;
import org.hl7.fhir.convertors.VersionConvertor_10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class Contract10_30 {

    public static org.hl7.fhir.dstu3.model.Contract.AgentComponent convertAgentComponent(org.hl7.fhir.dstu2.model.Contract.ActorComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Contract.AgentComponent tgt = new org.hl7.fhir.dstu3.model.Contract.AgentComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasEntity())
            tgt.setActor(VersionConvertor_10_30.convertReference(src.getEntity()));
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getRole()) tgt.addRole(VersionConvertor_10_30.convertCodeableConcept(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Contract.ActorComponent convertAgentComponent(org.hl7.fhir.dstu3.model.Contract.AgentComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Contract.ActorComponent tgt = new org.hl7.fhir.dstu2.model.Contract.ActorComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasActor())
            tgt.setEntity(VersionConvertor_10_30.convertReference(src.getActor()));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getRole()) tgt.addRole(VersionConvertor_10_30.convertCodeableConcept(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Contract.ComputableLanguageComponent convertComputableLanguageComponent(org.hl7.fhir.dstu2.model.Contract.ComputableLanguageComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Contract.ComputableLanguageComponent tgt = new org.hl7.fhir.dstu3.model.Contract.ComputableLanguageComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasContent())
            tgt.setContent(VersionConvertor_10_30.convertType(src.getContent()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Contract.ComputableLanguageComponent convertComputableLanguageComponent(org.hl7.fhir.dstu3.model.Contract.ComputableLanguageComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Contract.ComputableLanguageComponent tgt = new org.hl7.fhir.dstu2.model.Contract.ComputableLanguageComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasContent())
            tgt.setContent(VersionConvertor_10_30.convertType(src.getContent()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Contract convertContract(org.hl7.fhir.dstu3.model.Contract src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Contract tgt = new org.hl7.fhir.dstu2.model.Contract();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        if (src.hasIdentifier())
            tgt.setIdentifier(VersionConvertor_10_30.convertIdentifier(src.getIdentifier()));
        if (src.hasIssuedElement())
            tgt.setIssuedElement(VersionConvertor_10_30.convertDateTime(src.getIssuedElement()));
        if (src.hasApplies())
            tgt.setApplies(VersionConvertor_10_30.convertPeriod(src.getApplies()));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getSubject()) tgt.addSubject(VersionConvertor_10_30.convertReference(t));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getAuthority()) tgt.addAuthority(VersionConvertor_10_30.convertReference(t));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getDomain()) tgt.addDomain(VersionConvertor_10_30.convertReference(t));
        if (src.hasType())
            tgt.setType(VersionConvertor_10_30.convertCodeableConcept(src.getType()));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getSubType()) tgt.addSubType(VersionConvertor_10_30.convertCodeableConcept(t));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getAction()) tgt.addAction(VersionConvertor_10_30.convertCodeableConcept(t));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getActionReason()) tgt.addActionReason(VersionConvertor_10_30.convertCodeableConcept(t));
        for (org.hl7.fhir.dstu3.model.Contract.AgentComponent t : src.getAgent()) tgt.addActor(convertAgentComponent(t));
        for (org.hl7.fhir.dstu3.model.Contract.SignatoryComponent t : src.getSigner()) tgt.addSigner(convertSignatoryComponent(t));
        for (org.hl7.fhir.dstu3.model.Contract.ValuedItemComponent t : src.getValuedItem()) tgt.addValuedItem(convertValuedItemComponent(t));
        for (org.hl7.fhir.dstu3.model.Contract.TermComponent t : src.getTerm()) tgt.addTerm(convertTermComponent(t));
        if (src.hasBinding())
            tgt.setBinding(VersionConvertor_10_30.convertType(src.getBinding()));
        for (org.hl7.fhir.dstu3.model.Contract.FriendlyLanguageComponent t : src.getFriendly()) tgt.addFriendly(convertFriendlyLanguageComponent(t));
        for (org.hl7.fhir.dstu3.model.Contract.LegalLanguageComponent t : src.getLegal()) tgt.addLegal(convertLegalLanguageComponent(t));
        for (org.hl7.fhir.dstu3.model.Contract.ComputableLanguageComponent t : src.getRule()) tgt.addRule(convertComputableLanguageComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Contract convertContract(org.hl7.fhir.dstu2.model.Contract src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Contract tgt = new org.hl7.fhir.dstu3.model.Contract();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        if (src.hasIdentifier())
            tgt.setIdentifier(VersionConvertor_10_30.convertIdentifier(src.getIdentifier()));
        if (src.hasIssuedElement())
            tgt.setIssuedElement(VersionConvertor_10_30.convertDateTime(src.getIssuedElement()));
        if (src.hasApplies())
            tgt.setApplies(VersionConvertor_10_30.convertPeriod(src.getApplies()));
        for (org.hl7.fhir.dstu2.model.Reference t : src.getSubject()) tgt.addSubject(VersionConvertor_10_30.convertReference(t));
        for (org.hl7.fhir.dstu2.model.Reference t : src.getAuthority()) tgt.addAuthority(VersionConvertor_10_30.convertReference(t));
        for (org.hl7.fhir.dstu2.model.Reference t : src.getDomain()) tgt.addDomain(VersionConvertor_10_30.convertReference(t));
        if (src.hasType())
            tgt.setType(VersionConvertor_10_30.convertCodeableConcept(src.getType()));
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getSubType()) tgt.addSubType(VersionConvertor_10_30.convertCodeableConcept(t));
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getAction()) tgt.addAction(VersionConvertor_10_30.convertCodeableConcept(t));
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getActionReason()) tgt.addActionReason(VersionConvertor_10_30.convertCodeableConcept(t));
        for (org.hl7.fhir.dstu2.model.Contract.ActorComponent t : src.getActor()) tgt.addAgent(convertAgentComponent(t));
        for (org.hl7.fhir.dstu2.model.Contract.SignatoryComponent t : src.getSigner()) tgt.addSigner(convertSignatoryComponent(t));
        for (org.hl7.fhir.dstu2.model.Contract.ValuedItemComponent t : src.getValuedItem()) tgt.addValuedItem(convertValuedItemComponent(t));
        for (org.hl7.fhir.dstu2.model.Contract.TermComponent t : src.getTerm()) tgt.addTerm(convertTermComponent(t));
        if (src.hasBinding())
            tgt.setBinding(VersionConvertor_10_30.convertType(src.getBinding()));
        for (org.hl7.fhir.dstu2.model.Contract.FriendlyLanguageComponent t : src.getFriendly()) tgt.addFriendly(convertFriendlyLanguageComponent(t));
        for (org.hl7.fhir.dstu2.model.Contract.LegalLanguageComponent t : src.getLegal()) tgt.addLegal(convertLegalLanguageComponent(t));
        for (org.hl7.fhir.dstu2.model.Contract.ComputableLanguageComponent t : src.getRule()) tgt.addRule(convertComputableLanguageComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Contract.FriendlyLanguageComponent convertFriendlyLanguageComponent(org.hl7.fhir.dstu2.model.Contract.FriendlyLanguageComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Contract.FriendlyLanguageComponent tgt = new org.hl7.fhir.dstu3.model.Contract.FriendlyLanguageComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasContent())
            tgt.setContent(VersionConvertor_10_30.convertType(src.getContent()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Contract.FriendlyLanguageComponent convertFriendlyLanguageComponent(org.hl7.fhir.dstu3.model.Contract.FriendlyLanguageComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Contract.FriendlyLanguageComponent tgt = new org.hl7.fhir.dstu2.model.Contract.FriendlyLanguageComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasContent())
            tgt.setContent(VersionConvertor_10_30.convertType(src.getContent()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Contract.LegalLanguageComponent convertLegalLanguageComponent(org.hl7.fhir.dstu3.model.Contract.LegalLanguageComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Contract.LegalLanguageComponent tgt = new org.hl7.fhir.dstu2.model.Contract.LegalLanguageComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasContent())
            tgt.setContent(VersionConvertor_10_30.convertType(src.getContent()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Contract.LegalLanguageComponent convertLegalLanguageComponent(org.hl7.fhir.dstu2.model.Contract.LegalLanguageComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Contract.LegalLanguageComponent tgt = new org.hl7.fhir.dstu3.model.Contract.LegalLanguageComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasContent())
            tgt.setContent(VersionConvertor_10_30.convertType(src.getContent()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Contract.SignatoryComponent convertSignatoryComponent(org.hl7.fhir.dstu2.model.Contract.SignatoryComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Contract.SignatoryComponent tgt = new org.hl7.fhir.dstu3.model.Contract.SignatoryComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasType())
            tgt.setType(VersionConvertor_10_30.convertCoding(src.getType()));
        if (src.hasParty())
            tgt.setParty(VersionConvertor_10_30.convertReference(src.getParty()));
        if (src.hasSignature())
            tgt.addSignature(new org.hl7.fhir.dstu3.model.Signature().setBlob(src.getSignature().getBytes()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Contract.SignatoryComponent convertSignatoryComponent(org.hl7.fhir.dstu3.model.Contract.SignatoryComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Contract.SignatoryComponent tgt = new org.hl7.fhir.dstu2.model.Contract.SignatoryComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasType())
            tgt.setType(VersionConvertor_10_30.convertCoding(src.getType()));
        if (src.hasParty())
            tgt.setParty(VersionConvertor_10_30.convertReference(src.getParty()));
        for (org.hl7.fhir.dstu3.model.Signature t : src.getSignature()) tgt.setSignature(Base64.encodeBase64String(t.getBlob()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Contract.TermActorComponent convertTermAgentComponent(org.hl7.fhir.dstu3.model.Contract.TermAgentComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Contract.TermActorComponent tgt = new org.hl7.fhir.dstu2.model.Contract.TermActorComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasActor())
            tgt.setEntity(VersionConvertor_10_30.convertReference(src.getActor()));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getRole()) tgt.addRole(VersionConvertor_10_30.convertCodeableConcept(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Contract.TermAgentComponent convertTermAgentComponent(org.hl7.fhir.dstu2.model.Contract.TermActorComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Contract.TermAgentComponent tgt = new org.hl7.fhir.dstu3.model.Contract.TermAgentComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasEntity())
            tgt.setActor(VersionConvertor_10_30.convertReference(src.getEntity()));
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getRole()) tgt.addRole(VersionConvertor_10_30.convertCodeableConcept(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Contract.TermComponent convertTermComponent(org.hl7.fhir.dstu2.model.Contract.TermComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Contract.TermComponent tgt = new org.hl7.fhir.dstu3.model.Contract.TermComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasIdentifier())
            tgt.setIdentifier(VersionConvertor_10_30.convertIdentifier(src.getIdentifier()));
        if (src.hasIssuedElement())
            tgt.setIssuedElement(VersionConvertor_10_30.convertDateTime(src.getIssuedElement()));
        if (src.hasApplies())
            tgt.setApplies(VersionConvertor_10_30.convertPeriod(src.getApplies()));
        if (src.hasType())
            tgt.setType(VersionConvertor_10_30.convertCodeableConcept(src.getType()));
        if (src.hasSubType())
            tgt.setSubType(VersionConvertor_10_30.convertCodeableConcept(src.getSubType()));
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getAction()) tgt.addAction(VersionConvertor_10_30.convertCodeableConcept(t));
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getActionReason()) tgt.addActionReason(VersionConvertor_10_30.convertCodeableConcept(t));
        for (org.hl7.fhir.dstu2.model.Contract.TermActorComponent t : src.getActor()) tgt.addAgent(convertTermAgentComponent(t));
        if (src.hasTextElement())
            tgt.setTextElement(VersionConvertor_10_30.convertString(src.getTextElement()));
        for (org.hl7.fhir.dstu2.model.Contract.TermValuedItemComponent t : src.getValuedItem()) tgt.addValuedItem(convertTermValuedItemComponent(t));
        for (org.hl7.fhir.dstu2.model.Contract.TermComponent t : src.getGroup()) tgt.addGroup(convertTermComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Contract.TermComponent convertTermComponent(org.hl7.fhir.dstu3.model.Contract.TermComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Contract.TermComponent tgt = new org.hl7.fhir.dstu2.model.Contract.TermComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasIdentifier())
            tgt.setIdentifier(VersionConvertor_10_30.convertIdentifier(src.getIdentifier()));
        if (src.hasIssuedElement())
            tgt.setIssuedElement(VersionConvertor_10_30.convertDateTime(src.getIssuedElement()));
        if (src.hasApplies())
            tgt.setApplies(VersionConvertor_10_30.convertPeriod(src.getApplies()));
        if (src.hasType())
            tgt.setType(VersionConvertor_10_30.convertCodeableConcept(src.getType()));
        if (src.hasSubType())
            tgt.setSubType(VersionConvertor_10_30.convertCodeableConcept(src.getSubType()));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getAction()) tgt.addAction(VersionConvertor_10_30.convertCodeableConcept(t));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getActionReason()) tgt.addActionReason(VersionConvertor_10_30.convertCodeableConcept(t));
        for (org.hl7.fhir.dstu3.model.Contract.TermAgentComponent t : src.getAgent()) tgt.addActor(convertTermAgentComponent(t));
        if (src.hasTextElement())
            tgt.setTextElement(VersionConvertor_10_30.convertString(src.getTextElement()));
        for (org.hl7.fhir.dstu3.model.Contract.TermValuedItemComponent t : src.getValuedItem()) tgt.addValuedItem(convertTermValuedItemComponent(t));
        for (org.hl7.fhir.dstu3.model.Contract.TermComponent t : src.getGroup()) tgt.addGroup(convertTermComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Contract.TermValuedItemComponent convertTermValuedItemComponent(org.hl7.fhir.dstu3.model.Contract.TermValuedItemComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Contract.TermValuedItemComponent tgt = new org.hl7.fhir.dstu2.model.Contract.TermValuedItemComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasEntity())
            tgt.setEntity(VersionConvertor_10_30.convertType(src.getEntity()));
        if (src.hasIdentifier())
            tgt.setIdentifier(VersionConvertor_10_30.convertIdentifier(src.getIdentifier()));
        if (src.hasEffectiveTimeElement())
            tgt.setEffectiveTimeElement(VersionConvertor_10_30.convertDateTime(src.getEffectiveTimeElement()));
        if (src.hasQuantity())
            tgt.setQuantity(VersionConvertor_10_30.convertSimpleQuantity(src.getQuantity()));
        if (src.hasUnitPrice())
            tgt.setUnitPrice(VersionConvertor_10_30.convertMoney(src.getUnitPrice()));
        if (src.hasFactorElement())
            tgt.setFactorElement(VersionConvertor_10_30.convertDecimal(src.getFactorElement()));
        if (src.hasPointsElement())
            tgt.setPointsElement(VersionConvertor_10_30.convertDecimal(src.getPointsElement()));
        if (src.hasNet())
            tgt.setNet(VersionConvertor_10_30.convertMoney(src.getNet()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Contract.TermValuedItemComponent convertTermValuedItemComponent(org.hl7.fhir.dstu2.model.Contract.TermValuedItemComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Contract.TermValuedItemComponent tgt = new org.hl7.fhir.dstu3.model.Contract.TermValuedItemComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasEntity())
            tgt.setEntity(VersionConvertor_10_30.convertType(src.getEntity()));
        if (src.hasIdentifier())
            tgt.setIdentifier(VersionConvertor_10_30.convertIdentifier(src.getIdentifier()));
        if (src.hasEffectiveTimeElement())
            tgt.setEffectiveTimeElement(VersionConvertor_10_30.convertDateTime(src.getEffectiveTimeElement()));
        if (src.hasQuantity())
            tgt.setQuantity(VersionConvertor_10_30.convertSimpleQuantity(src.getQuantity()));
        if (src.hasUnitPrice())
            tgt.setUnitPrice(VersionConvertor_10_30.convertMoney(src.getUnitPrice()));
        if (src.hasFactorElement())
            tgt.setFactorElement(VersionConvertor_10_30.convertDecimal(src.getFactorElement()));
        if (src.hasPointsElement())
            tgt.setPointsElement(VersionConvertor_10_30.convertDecimal(src.getPointsElement()));
        if (src.hasNet())
            tgt.setNet(VersionConvertor_10_30.convertMoney(src.getNet()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Contract.ValuedItemComponent convertValuedItemComponent(org.hl7.fhir.dstu3.model.Contract.ValuedItemComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Contract.ValuedItemComponent tgt = new org.hl7.fhir.dstu2.model.Contract.ValuedItemComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasEntity())
            tgt.setEntity(VersionConvertor_10_30.convertType(src.getEntity()));
        if (src.hasIdentifier())
            tgt.setIdentifier(VersionConvertor_10_30.convertIdentifier(src.getIdentifier()));
        if (src.hasEffectiveTimeElement())
            tgt.setEffectiveTimeElement(VersionConvertor_10_30.convertDateTime(src.getEffectiveTimeElement()));
        if (src.hasQuantity())
            tgt.setQuantity(VersionConvertor_10_30.convertSimpleQuantity(src.getQuantity()));
        if (src.hasUnitPrice())
            tgt.setUnitPrice(VersionConvertor_10_30.convertMoney(src.getUnitPrice()));
        if (src.hasFactorElement())
            tgt.setFactorElement(VersionConvertor_10_30.convertDecimal(src.getFactorElement()));
        if (src.hasPointsElement())
            tgt.setPointsElement(VersionConvertor_10_30.convertDecimal(src.getPointsElement()));
        if (src.hasNet())
            tgt.setNet(VersionConvertor_10_30.convertMoney(src.getNet()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Contract.ValuedItemComponent convertValuedItemComponent(org.hl7.fhir.dstu2.model.Contract.ValuedItemComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Contract.ValuedItemComponent tgt = new org.hl7.fhir.dstu3.model.Contract.ValuedItemComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasEntity())
            tgt.setEntity(VersionConvertor_10_30.convertType(src.getEntity()));
        if (src.hasIdentifier())
            tgt.setIdentifier(VersionConvertor_10_30.convertIdentifier(src.getIdentifier()));
        if (src.hasEffectiveTimeElement())
            tgt.setEffectiveTimeElement(VersionConvertor_10_30.convertDateTime(src.getEffectiveTimeElement()));
        if (src.hasQuantity())
            tgt.setQuantity(VersionConvertor_10_30.convertSimpleQuantity(src.getQuantity()));
        if (src.hasUnitPrice())
            tgt.setUnitPrice(VersionConvertor_10_30.convertMoney(src.getUnitPrice()));
        if (src.hasFactorElement())
            tgt.setFactorElement(VersionConvertor_10_30.convertDecimal(src.getFactorElement()));
        if (src.hasPointsElement())
            tgt.setPointsElement(VersionConvertor_10_30.convertDecimal(src.getPointsElement()));
        if (src.hasNet())
            tgt.setNet(VersionConvertor_10_30.convertMoney(src.getNet()));
        return tgt;
    }
}