package org.hl7.fhir.convertors.conv10_30.resources10_30;

import org.apache.commons.codec.binary.Base64;
import org.hl7.fhir.convertors.conv10_30.VersionConvertor_10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.Element10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.Type10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.*;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.DateTime10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.Decimal10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.String10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.Reference10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class Contract10_30 {

    public static org.hl7.fhir.dstu3.model.Contract.AgentComponent convertAgentComponent(org.hl7.fhir.dstu2.model.Contract.ActorComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Contract.AgentComponent tgt = new org.hl7.fhir.dstu3.model.Contract.AgentComponent();
        Element10_30.copyElement(src, tgt);
        if (src.hasEntity())
            tgt.setActor(Reference10_30.convertReference(src.getEntity()));
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getRole()) tgt.addRole(CodeableConcept10_30.convertCodeableConcept(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Contract.ActorComponent convertAgentComponent(org.hl7.fhir.dstu3.model.Contract.AgentComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Contract.ActorComponent tgt = new org.hl7.fhir.dstu2.model.Contract.ActorComponent();
        Element10_30.copyElement(src, tgt);
        if (src.hasActor())
            tgt.setEntity(Reference10_30.convertReference(src.getActor()));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getRole()) tgt.addRole(CodeableConcept10_30.convertCodeableConcept(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Contract.ComputableLanguageComponent convertComputableLanguageComponent(org.hl7.fhir.dstu2.model.Contract.ComputableLanguageComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Contract.ComputableLanguageComponent tgt = new org.hl7.fhir.dstu3.model.Contract.ComputableLanguageComponent();
        Element10_30.copyElement(src, tgt);
        if (src.hasContent())
            tgt.setContent(Type10_30.convertType(src.getContent()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Contract.ComputableLanguageComponent convertComputableLanguageComponent(org.hl7.fhir.dstu3.model.Contract.ComputableLanguageComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Contract.ComputableLanguageComponent tgt = new org.hl7.fhir.dstu2.model.Contract.ComputableLanguageComponent();
        Element10_30.copyElement(src, tgt);
        if (src.hasContent())
            tgt.setContent(Type10_30.convertType(src.getContent()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Contract convertContract(org.hl7.fhir.dstu3.model.Contract src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Contract tgt = new org.hl7.fhir.dstu2.model.Contract();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        if (src.hasIdentifier())
            tgt.setIdentifier(Identifier10_30.convertIdentifier(src.getIdentifier()));
        if (src.hasIssuedElement())
            tgt.setIssuedElement(DateTime10_30.convertDateTime(src.getIssuedElement()));
        if (src.hasApplies())
            tgt.setApplies(Period10_30.convertPeriod(src.getApplies()));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getSubject()) tgt.addSubject(Reference10_30.convertReference(t));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getAuthority()) tgt.addAuthority(Reference10_30.convertReference(t));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getDomain()) tgt.addDomain(Reference10_30.convertReference(t));
        if (src.hasType())
            tgt.setType(CodeableConcept10_30.convertCodeableConcept(src.getType()));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getSubType()) tgt.addSubType(CodeableConcept10_30.convertCodeableConcept(t));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getAction()) tgt.addAction(CodeableConcept10_30.convertCodeableConcept(t));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getActionReason()) tgt.addActionReason(CodeableConcept10_30.convertCodeableConcept(t));
        for (org.hl7.fhir.dstu3.model.Contract.AgentComponent t : src.getAgent()) tgt.addActor(convertAgentComponent(t));
        for (org.hl7.fhir.dstu3.model.Contract.SignatoryComponent t : src.getSigner()) tgt.addSigner(convertSignatoryComponent(t));
        for (org.hl7.fhir.dstu3.model.Contract.ValuedItemComponent t : src.getValuedItem()) tgt.addValuedItem(convertValuedItemComponent(t));
        for (org.hl7.fhir.dstu3.model.Contract.TermComponent t : src.getTerm()) tgt.addTerm(convertTermComponent(t));
        if (src.hasBinding())
            tgt.setBinding(Type10_30.convertType(src.getBinding()));
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
            tgt.setIdentifier(Identifier10_30.convertIdentifier(src.getIdentifier()));
        if (src.hasIssuedElement())
            tgt.setIssuedElement(DateTime10_30.convertDateTime(src.getIssuedElement()));
        if (src.hasApplies())
            tgt.setApplies(Period10_30.convertPeriod(src.getApplies()));
        for (org.hl7.fhir.dstu2.model.Reference t : src.getSubject()) tgt.addSubject(Reference10_30.convertReference(t));
        for (org.hl7.fhir.dstu2.model.Reference t : src.getAuthority()) tgt.addAuthority(Reference10_30.convertReference(t));
        for (org.hl7.fhir.dstu2.model.Reference t : src.getDomain()) tgt.addDomain(Reference10_30.convertReference(t));
        if (src.hasType())
            tgt.setType(CodeableConcept10_30.convertCodeableConcept(src.getType()));
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getSubType()) tgt.addSubType(CodeableConcept10_30.convertCodeableConcept(t));
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getAction()) tgt.addAction(CodeableConcept10_30.convertCodeableConcept(t));
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getActionReason()) tgt.addActionReason(CodeableConcept10_30.convertCodeableConcept(t));
        for (org.hl7.fhir.dstu2.model.Contract.ActorComponent t : src.getActor()) tgt.addAgent(convertAgentComponent(t));
        for (org.hl7.fhir.dstu2.model.Contract.SignatoryComponent t : src.getSigner()) tgt.addSigner(convertSignatoryComponent(t));
        for (org.hl7.fhir.dstu2.model.Contract.ValuedItemComponent t : src.getValuedItem()) tgt.addValuedItem(convertValuedItemComponent(t));
        for (org.hl7.fhir.dstu2.model.Contract.TermComponent t : src.getTerm()) tgt.addTerm(convertTermComponent(t));
        if (src.hasBinding())
            tgt.setBinding(Type10_30.convertType(src.getBinding()));
        for (org.hl7.fhir.dstu2.model.Contract.FriendlyLanguageComponent t : src.getFriendly()) tgt.addFriendly(convertFriendlyLanguageComponent(t));
        for (org.hl7.fhir.dstu2.model.Contract.LegalLanguageComponent t : src.getLegal()) tgt.addLegal(convertLegalLanguageComponent(t));
        for (org.hl7.fhir.dstu2.model.Contract.ComputableLanguageComponent t : src.getRule()) tgt.addRule(convertComputableLanguageComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Contract.FriendlyLanguageComponent convertFriendlyLanguageComponent(org.hl7.fhir.dstu2.model.Contract.FriendlyLanguageComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Contract.FriendlyLanguageComponent tgt = new org.hl7.fhir.dstu3.model.Contract.FriendlyLanguageComponent();
        Element10_30.copyElement(src, tgt);
        if (src.hasContent())
            tgt.setContent(Type10_30.convertType(src.getContent()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Contract.FriendlyLanguageComponent convertFriendlyLanguageComponent(org.hl7.fhir.dstu3.model.Contract.FriendlyLanguageComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Contract.FriendlyLanguageComponent tgt = new org.hl7.fhir.dstu2.model.Contract.FriendlyLanguageComponent();
        Element10_30.copyElement(src, tgt);
        if (src.hasContent())
            tgt.setContent(Type10_30.convertType(src.getContent()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Contract.LegalLanguageComponent convertLegalLanguageComponent(org.hl7.fhir.dstu3.model.Contract.LegalLanguageComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Contract.LegalLanguageComponent tgt = new org.hl7.fhir.dstu2.model.Contract.LegalLanguageComponent();
        Element10_30.copyElement(src, tgt);
        if (src.hasContent())
            tgt.setContent(Type10_30.convertType(src.getContent()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Contract.LegalLanguageComponent convertLegalLanguageComponent(org.hl7.fhir.dstu2.model.Contract.LegalLanguageComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Contract.LegalLanguageComponent tgt = new org.hl7.fhir.dstu3.model.Contract.LegalLanguageComponent();
        Element10_30.copyElement(src, tgt);
        if (src.hasContent())
            tgt.setContent(Type10_30.convertType(src.getContent()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Contract.SignatoryComponent convertSignatoryComponent(org.hl7.fhir.dstu2.model.Contract.SignatoryComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Contract.SignatoryComponent tgt = new org.hl7.fhir.dstu3.model.Contract.SignatoryComponent();
        Element10_30.copyElement(src, tgt);
        if (src.hasType())
            tgt.setType(Coding10_30.convertCoding(src.getType()));
        if (src.hasParty())
            tgt.setParty(Reference10_30.convertReference(src.getParty()));
        if (src.hasSignature())
            tgt.addSignature(new org.hl7.fhir.dstu3.model.Signature().setBlob(src.getSignature().getBytes()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Contract.SignatoryComponent convertSignatoryComponent(org.hl7.fhir.dstu3.model.Contract.SignatoryComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Contract.SignatoryComponent tgt = new org.hl7.fhir.dstu2.model.Contract.SignatoryComponent();
        Element10_30.copyElement(src, tgt);
        if (src.hasType())
            tgt.setType(Coding10_30.convertCoding(src.getType()));
        if (src.hasParty())
            tgt.setParty(Reference10_30.convertReference(src.getParty()));
        for (org.hl7.fhir.dstu3.model.Signature t : src.getSignature()) tgt.setSignature(Base64.encodeBase64String(t.getBlob()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Contract.TermActorComponent convertTermAgentComponent(org.hl7.fhir.dstu3.model.Contract.TermAgentComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Contract.TermActorComponent tgt = new org.hl7.fhir.dstu2.model.Contract.TermActorComponent();
        Element10_30.copyElement(src, tgt);
        if (src.hasActor())
            tgt.setEntity(Reference10_30.convertReference(src.getActor()));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getRole()) tgt.addRole(CodeableConcept10_30.convertCodeableConcept(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Contract.TermAgentComponent convertTermAgentComponent(org.hl7.fhir.dstu2.model.Contract.TermActorComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Contract.TermAgentComponent tgt = new org.hl7.fhir.dstu3.model.Contract.TermAgentComponent();
        Element10_30.copyElement(src, tgt);
        if (src.hasEntity())
            tgt.setActor(Reference10_30.convertReference(src.getEntity()));
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getRole()) tgt.addRole(CodeableConcept10_30.convertCodeableConcept(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Contract.TermComponent convertTermComponent(org.hl7.fhir.dstu2.model.Contract.TermComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Contract.TermComponent tgt = new org.hl7.fhir.dstu3.model.Contract.TermComponent();
        Element10_30.copyElement(src, tgt);
        if (src.hasIdentifier())
            tgt.setIdentifier(Identifier10_30.convertIdentifier(src.getIdentifier()));
        if (src.hasIssuedElement())
            tgt.setIssuedElement(DateTime10_30.convertDateTime(src.getIssuedElement()));
        if (src.hasApplies())
            tgt.setApplies(Period10_30.convertPeriod(src.getApplies()));
        if (src.hasType())
            tgt.setType(CodeableConcept10_30.convertCodeableConcept(src.getType()));
        if (src.hasSubType())
            tgt.setSubType(CodeableConcept10_30.convertCodeableConcept(src.getSubType()));
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getAction()) tgt.addAction(CodeableConcept10_30.convertCodeableConcept(t));
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getActionReason()) tgt.addActionReason(CodeableConcept10_30.convertCodeableConcept(t));
        for (org.hl7.fhir.dstu2.model.Contract.TermActorComponent t : src.getActor()) tgt.addAgent(convertTermAgentComponent(t));
        if (src.hasTextElement())
            tgt.setTextElement(String10_30.convertString(src.getTextElement()));
        for (org.hl7.fhir.dstu2.model.Contract.TermValuedItemComponent t : src.getValuedItem()) tgt.addValuedItem(convertTermValuedItemComponent(t));
        for (org.hl7.fhir.dstu2.model.Contract.TermComponent t : src.getGroup()) tgt.addGroup(convertTermComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Contract.TermComponent convertTermComponent(org.hl7.fhir.dstu3.model.Contract.TermComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Contract.TermComponent tgt = new org.hl7.fhir.dstu2.model.Contract.TermComponent();
        Element10_30.copyElement(src, tgt);
        if (src.hasIdentifier())
            tgt.setIdentifier(Identifier10_30.convertIdentifier(src.getIdentifier()));
        if (src.hasIssuedElement())
            tgt.setIssuedElement(DateTime10_30.convertDateTime(src.getIssuedElement()));
        if (src.hasApplies())
            tgt.setApplies(Period10_30.convertPeriod(src.getApplies()));
        if (src.hasType())
            tgt.setType(CodeableConcept10_30.convertCodeableConcept(src.getType()));
        if (src.hasSubType())
            tgt.setSubType(CodeableConcept10_30.convertCodeableConcept(src.getSubType()));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getAction()) tgt.addAction(CodeableConcept10_30.convertCodeableConcept(t));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getActionReason()) tgt.addActionReason(CodeableConcept10_30.convertCodeableConcept(t));
        for (org.hl7.fhir.dstu3.model.Contract.TermAgentComponent t : src.getAgent()) tgt.addActor(convertTermAgentComponent(t));
        if (src.hasTextElement())
            tgt.setTextElement(String10_30.convertString(src.getTextElement()));
        for (org.hl7.fhir.dstu3.model.Contract.TermValuedItemComponent t : src.getValuedItem()) tgt.addValuedItem(convertTermValuedItemComponent(t));
        for (org.hl7.fhir.dstu3.model.Contract.TermComponent t : src.getGroup()) tgt.addGroup(convertTermComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Contract.TermValuedItemComponent convertTermValuedItemComponent(org.hl7.fhir.dstu3.model.Contract.TermValuedItemComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Contract.TermValuedItemComponent tgt = new org.hl7.fhir.dstu2.model.Contract.TermValuedItemComponent();
        Element10_30.copyElement(src, tgt);
        if (src.hasEntity())
            tgt.setEntity(Type10_30.convertType(src.getEntity()));
        if (src.hasIdentifier())
            tgt.setIdentifier(Identifier10_30.convertIdentifier(src.getIdentifier()));
        if (src.hasEffectiveTimeElement())
            tgt.setEffectiveTimeElement(DateTime10_30.convertDateTime(src.getEffectiveTimeElement()));
        if (src.hasQuantity())
            tgt.setQuantity(SimpleQuantity10_30.convertSimpleQuantity(src.getQuantity()));
        if (src.hasUnitPrice())
            tgt.setUnitPrice(Money10_30.convertMoney(src.getUnitPrice()));
        if (src.hasFactorElement())
            tgt.setFactorElement(Decimal10_30.convertDecimal(src.getFactorElement()));
        if (src.hasPointsElement())
            tgt.setPointsElement(Decimal10_30.convertDecimal(src.getPointsElement()));
        if (src.hasNet())
            tgt.setNet(Money10_30.convertMoney(src.getNet()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Contract.TermValuedItemComponent convertTermValuedItemComponent(org.hl7.fhir.dstu2.model.Contract.TermValuedItemComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Contract.TermValuedItemComponent tgt = new org.hl7.fhir.dstu3.model.Contract.TermValuedItemComponent();
        Element10_30.copyElement(src, tgt);
        if (src.hasEntity())
            tgt.setEntity(Type10_30.convertType(src.getEntity()));
        if (src.hasIdentifier())
            tgt.setIdentifier(Identifier10_30.convertIdentifier(src.getIdentifier()));
        if (src.hasEffectiveTimeElement())
            tgt.setEffectiveTimeElement(DateTime10_30.convertDateTime(src.getEffectiveTimeElement()));
        if (src.hasQuantity())
            tgt.setQuantity(SimpleQuantity10_30.convertSimpleQuantity(src.getQuantity()));
        if (src.hasUnitPrice())
            tgt.setUnitPrice(Money10_30.convertMoney(src.getUnitPrice()));
        if (src.hasFactorElement())
            tgt.setFactorElement(Decimal10_30.convertDecimal(src.getFactorElement()));
        if (src.hasPointsElement())
            tgt.setPointsElement(Decimal10_30.convertDecimal(src.getPointsElement()));
        if (src.hasNet())
            tgt.setNet(Money10_30.convertMoney(src.getNet()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Contract.ValuedItemComponent convertValuedItemComponent(org.hl7.fhir.dstu3.model.Contract.ValuedItemComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Contract.ValuedItemComponent tgt = new org.hl7.fhir.dstu2.model.Contract.ValuedItemComponent();
        Element10_30.copyElement(src, tgt);
        if (src.hasEntity())
            tgt.setEntity(Type10_30.convertType(src.getEntity()));
        if (src.hasIdentifier())
            tgt.setIdentifier(Identifier10_30.convertIdentifier(src.getIdentifier()));
        if (src.hasEffectiveTimeElement())
            tgt.setEffectiveTimeElement(DateTime10_30.convertDateTime(src.getEffectiveTimeElement()));
        if (src.hasQuantity())
            tgt.setQuantity(SimpleQuantity10_30.convertSimpleQuantity(src.getQuantity()));
        if (src.hasUnitPrice())
            tgt.setUnitPrice(Money10_30.convertMoney(src.getUnitPrice()));
        if (src.hasFactorElement())
            tgt.setFactorElement(Decimal10_30.convertDecimal(src.getFactorElement()));
        if (src.hasPointsElement())
            tgt.setPointsElement(Decimal10_30.convertDecimal(src.getPointsElement()));
        if (src.hasNet())
            tgt.setNet(Money10_30.convertMoney(src.getNet()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Contract.ValuedItemComponent convertValuedItemComponent(org.hl7.fhir.dstu2.model.Contract.ValuedItemComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Contract.ValuedItemComponent tgt = new org.hl7.fhir.dstu3.model.Contract.ValuedItemComponent();
        Element10_30.copyElement(src, tgt);
        if (src.hasEntity())
            tgt.setEntity(Type10_30.convertType(src.getEntity()));
        if (src.hasIdentifier())
            tgt.setIdentifier(Identifier10_30.convertIdentifier(src.getIdentifier()));
        if (src.hasEffectiveTimeElement())
            tgt.setEffectiveTimeElement(DateTime10_30.convertDateTime(src.getEffectiveTimeElement()));
        if (src.hasQuantity())
            tgt.setQuantity(SimpleQuantity10_30.convertSimpleQuantity(src.getQuantity()));
        if (src.hasUnitPrice())
            tgt.setUnitPrice(Money10_30.convertMoney(src.getUnitPrice()));
        if (src.hasFactorElement())
            tgt.setFactorElement(Decimal10_30.convertDecimal(src.getFactorElement()));
        if (src.hasPointsElement())
            tgt.setPointsElement(Decimal10_30.convertDecimal(src.getPointsElement()));
        if (src.hasNet())
            tgt.setNet(Money10_30.convertMoney(src.getNet()));
        return tgt;
    }
}