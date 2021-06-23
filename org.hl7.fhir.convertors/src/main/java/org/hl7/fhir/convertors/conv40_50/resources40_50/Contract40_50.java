package org.hl7.fhir.convertors.conv40_50.resources40_50;


import org.hl7.fhir.convertors.VersionConvertor_40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.Element40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.Type40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.*;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.*;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.special40_50.Reference40_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CodeableReference;

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
public class Contract40_50 extends VersionConvertor_40_50 {

    public static org.hl7.fhir.r5.model.Contract convertContract(org.hl7.fhir.r4.model.Contract src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Contract tgt = new org.hl7.fhir.r5.model.Contract();
        copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(Identifier40_50.convertIdentifier(t));
        if (src.hasUrl())
            tgt.setUrlElement(Uri40_50.convertUri(src.getUrlElement()));
        if (src.hasVersion())
            tgt.setVersionElement(String40_50.convertString(src.getVersionElement()));
        if (src.hasStatus())
            tgt.setStatusElement(convertContractStatus(src.getStatusElement()));
        if (src.hasLegalState())
            tgt.setLegalState(CodeableConcept40_50.convertCodeableConcept(src.getLegalState()));
        if (src.hasInstantiatesCanonical())
            tgt.setInstantiatesCanonical(Reference40_50.convertReference(src.getInstantiatesCanonical()));
        if (src.hasInstantiatesUri())
            tgt.setInstantiatesUriElement(Uri40_50.convertUri(src.getInstantiatesUriElement()));
        if (src.hasContentDerivative())
            tgt.setContentDerivative(CodeableConcept40_50.convertCodeableConcept(src.getContentDerivative()));
        if (src.hasIssued())
            tgt.setIssuedElement(DateTime40_50.convertDateTime(src.getIssuedElement()));
        if (src.hasApplies())
            tgt.setApplies(Period40_50.convertPeriod(src.getApplies()));
        if (src.hasExpirationType())
            tgt.setExpirationType(CodeableConcept40_50.convertCodeableConcept(src.getExpirationType()));
        for (org.hl7.fhir.r4.model.Reference t : src.getSubject()) tgt.addSubject(Reference40_50.convertReference(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getAuthority()) tgt.addAuthority(Reference40_50.convertReference(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getDomain()) tgt.addDomain(Reference40_50.convertReference(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getSite()) tgt.addSite(Reference40_50.convertReference(t));
        if (src.hasName())
            tgt.setNameElement(String40_50.convertString(src.getNameElement()));
        if (src.hasTitle())
            tgt.setTitleElement(String40_50.convertString(src.getTitleElement()));
        if (src.hasSubtitle())
            tgt.setSubtitleElement(String40_50.convertString(src.getSubtitleElement()));
        for (org.hl7.fhir.r4.model.StringType t : src.getAlias()) tgt.getAlias().add(String40_50.convertString(t));
        if (src.hasAuthor())
            tgt.setAuthor(Reference40_50.convertReference(src.getAuthor()));
        if (src.hasScope())
            tgt.setScope(CodeableConcept40_50.convertCodeableConcept(src.getScope()));
        if (src.hasTopic())
            tgt.setTopic(Type40_50.convertType(src.getTopic()));
        if (src.hasType())
            tgt.setType(CodeableConcept40_50.convertCodeableConcept(src.getType()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getSubType()) tgt.addSubType(CodeableConcept40_50.convertCodeableConcept(t));
        if (src.hasContentDefinition())
            tgt.setContentDefinition(convertContentDefinitionComponent(src.getContentDefinition()));
        for (org.hl7.fhir.r4.model.Contract.TermComponent t : src.getTerm()) tgt.addTerm(convertTermComponent(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getSupportingInfo()) tgt.addSupportingInfo(Reference40_50.convertReference(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getRelevantHistory()) tgt.addRelevantHistory(Reference40_50.convertReference(t));
        for (org.hl7.fhir.r4.model.Contract.SignatoryComponent t : src.getSigner()) tgt.addSigner(convertSignatoryComponent(t));
        for (org.hl7.fhir.r4.model.Contract.FriendlyLanguageComponent t : src.getFriendly()) tgt.addFriendly(convertFriendlyLanguageComponent(t));
        for (org.hl7.fhir.r4.model.Contract.LegalLanguageComponent t : src.getLegal()) tgt.addLegal(convertLegalLanguageComponent(t));
        for (org.hl7.fhir.r4.model.Contract.ComputableLanguageComponent t : src.getRule()) tgt.addRule(convertComputableLanguageComponent(t));
        if (src.hasLegallyBinding())
            tgt.setLegallyBinding(Type40_50.convertType(src.getLegallyBinding()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Contract convertContract(org.hl7.fhir.r5.model.Contract src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Contract tgt = new org.hl7.fhir.r4.model.Contract();
        copyDomainResource(src, tgt);
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(Identifier40_50.convertIdentifier(t));
        if (src.hasUrl())
            tgt.setUrlElement(Uri40_50.convertUri(src.getUrlElement()));
        if (src.hasVersion())
            tgt.setVersionElement(String40_50.convertString(src.getVersionElement()));
        if (src.hasStatus())
            tgt.setStatusElement(convertContractStatus(src.getStatusElement()));
        if (src.hasLegalState())
            tgt.setLegalState(CodeableConcept40_50.convertCodeableConcept(src.getLegalState()));
        if (src.hasInstantiatesCanonical())
            tgt.setInstantiatesCanonical(Reference40_50.convertReference(src.getInstantiatesCanonical()));
        if (src.hasInstantiatesUri())
            tgt.setInstantiatesUriElement(Uri40_50.convertUri(src.getInstantiatesUriElement()));
        if (src.hasContentDerivative())
            tgt.setContentDerivative(CodeableConcept40_50.convertCodeableConcept(src.getContentDerivative()));
        if (src.hasIssued())
            tgt.setIssuedElement(DateTime40_50.convertDateTime(src.getIssuedElement()));
        if (src.hasApplies())
            tgt.setApplies(Period40_50.convertPeriod(src.getApplies()));
        if (src.hasExpirationType())
            tgt.setExpirationType(CodeableConcept40_50.convertCodeableConcept(src.getExpirationType()));
        for (org.hl7.fhir.r5.model.Reference t : src.getSubject()) tgt.addSubject(Reference40_50.convertReference(t));
        for (org.hl7.fhir.r5.model.Reference t : src.getAuthority()) tgt.addAuthority(Reference40_50.convertReference(t));
        for (org.hl7.fhir.r5.model.Reference t : src.getDomain()) tgt.addDomain(Reference40_50.convertReference(t));
        for (org.hl7.fhir.r5.model.Reference t : src.getSite()) tgt.addSite(Reference40_50.convertReference(t));
        if (src.hasName())
            tgt.setNameElement(String40_50.convertString(src.getNameElement()));
        if (src.hasTitle())
            tgt.setTitleElement(String40_50.convertString(src.getTitleElement()));
        if (src.hasSubtitle())
            tgt.setSubtitleElement(String40_50.convertString(src.getSubtitleElement()));
        for (org.hl7.fhir.r5.model.StringType t : src.getAlias()) tgt.getAlias().add(String40_50.convertString(t));
        if (src.hasAuthor())
            tgt.setAuthor(Reference40_50.convertReference(src.getAuthor()));
        if (src.hasScope())
            tgt.setScope(CodeableConcept40_50.convertCodeableConcept(src.getScope()));
        if (src.hasTopic())
            tgt.setTopic(Type40_50.convertType(src.getTopic()));
        if (src.hasType())
            tgt.setType(CodeableConcept40_50.convertCodeableConcept(src.getType()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getSubType()) tgt.addSubType(CodeableConcept40_50.convertCodeableConcept(t));
        if (src.hasContentDefinition())
            tgt.setContentDefinition(convertContentDefinitionComponent(src.getContentDefinition()));
        for (org.hl7.fhir.r5.model.Contract.TermComponent t : src.getTerm()) tgt.addTerm(convertTermComponent(t));
        for (org.hl7.fhir.r5.model.Reference t : src.getSupportingInfo()) tgt.addSupportingInfo(Reference40_50.convertReference(t));
        for (org.hl7.fhir.r5.model.Reference t : src.getRelevantHistory()) tgt.addRelevantHistory(Reference40_50.convertReference(t));
        for (org.hl7.fhir.r5.model.Contract.SignatoryComponent t : src.getSigner()) tgt.addSigner(convertSignatoryComponent(t));
        for (org.hl7.fhir.r5.model.Contract.FriendlyLanguageComponent t : src.getFriendly()) tgt.addFriendly(convertFriendlyLanguageComponent(t));
        for (org.hl7.fhir.r5.model.Contract.LegalLanguageComponent t : src.getLegal()) tgt.addLegal(convertLegalLanguageComponent(t));
        for (org.hl7.fhir.r5.model.Contract.ComputableLanguageComponent t : src.getRule()) tgt.addRule(convertComputableLanguageComponent(t));
        if (src.hasLegallyBinding())
            tgt.setLegallyBinding(Type40_50.convertType(src.getLegallyBinding()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Contract.ContractResourceStatusCodes> convertContractStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Contract.ContractStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Contract.ContractResourceStatusCodes> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Contract.ContractResourceStatusCodesEnumFactory());
        Element40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case AMENDED:
                tgt.setValue(org.hl7.fhir.r5.model.Contract.ContractResourceStatusCodes.AMENDED);
                break;
            case APPENDED:
                tgt.setValue(org.hl7.fhir.r5.model.Contract.ContractResourceStatusCodes.APPENDED);
                break;
            case CANCELLED:
                tgt.setValue(org.hl7.fhir.r5.model.Contract.ContractResourceStatusCodes.CANCELLED);
                break;
            case DISPUTED:
                tgt.setValue(org.hl7.fhir.r5.model.Contract.ContractResourceStatusCodes.DISPUTED);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.r5.model.Contract.ContractResourceStatusCodes.ENTEREDINERROR);
                break;
            case EXECUTABLE:
                tgt.setValue(org.hl7.fhir.r5.model.Contract.ContractResourceStatusCodes.EXECUTABLE);
                break;
            case EXECUTED:
                tgt.setValue(org.hl7.fhir.r5.model.Contract.ContractResourceStatusCodes.EXECUTED);
                break;
            case NEGOTIABLE:
                tgt.setValue(org.hl7.fhir.r5.model.Contract.ContractResourceStatusCodes.NEGOTIABLE);
                break;
            case OFFERED:
                tgt.setValue(org.hl7.fhir.r5.model.Contract.ContractResourceStatusCodes.OFFERED);
                break;
            case POLICY:
                tgt.setValue(org.hl7.fhir.r5.model.Contract.ContractResourceStatusCodes.POLICY);
                break;
            case REJECTED:
                tgt.setValue(org.hl7.fhir.r5.model.Contract.ContractResourceStatusCodes.REJECTED);
                break;
            case RENEWED:
                tgt.setValue(org.hl7.fhir.r5.model.Contract.ContractResourceStatusCodes.RENEWED);
                break;
            case REVOKED:
                tgt.setValue(org.hl7.fhir.r5.model.Contract.ContractResourceStatusCodes.REVOKED);
                break;
            case RESOLVED:
                tgt.setValue(org.hl7.fhir.r5.model.Contract.ContractResourceStatusCodes.RESOLVED);
                break;
            case TERMINATED:
                tgt.setValue(org.hl7.fhir.r5.model.Contract.ContractResourceStatusCodes.TERMINATED);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Contract.ContractResourceStatusCodes.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Contract.ContractStatus> convertContractStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Contract.ContractResourceStatusCodes> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Contract.ContractStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Contract.ContractStatusEnumFactory());
        Element40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case AMENDED:
                tgt.setValue(org.hl7.fhir.r4.model.Contract.ContractStatus.AMENDED);
                break;
            case APPENDED:
                tgt.setValue(org.hl7.fhir.r4.model.Contract.ContractStatus.APPENDED);
                break;
            case CANCELLED:
                tgt.setValue(org.hl7.fhir.r4.model.Contract.ContractStatus.CANCELLED);
                break;
            case DISPUTED:
                tgt.setValue(org.hl7.fhir.r4.model.Contract.ContractStatus.DISPUTED);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.r4.model.Contract.ContractStatus.ENTEREDINERROR);
                break;
            case EXECUTABLE:
                tgt.setValue(org.hl7.fhir.r4.model.Contract.ContractStatus.EXECUTABLE);
                break;
            case EXECUTED:
                tgt.setValue(org.hl7.fhir.r4.model.Contract.ContractStatus.EXECUTED);
                break;
            case NEGOTIABLE:
                tgt.setValue(org.hl7.fhir.r4.model.Contract.ContractStatus.NEGOTIABLE);
                break;
            case OFFERED:
                tgt.setValue(org.hl7.fhir.r4.model.Contract.ContractStatus.OFFERED);
                break;
            case POLICY:
                tgt.setValue(org.hl7.fhir.r4.model.Contract.ContractStatus.POLICY);
                break;
            case REJECTED:
                tgt.setValue(org.hl7.fhir.r4.model.Contract.ContractStatus.REJECTED);
                break;
            case RENEWED:
                tgt.setValue(org.hl7.fhir.r4.model.Contract.ContractStatus.RENEWED);
                break;
            case REVOKED:
                tgt.setValue(org.hl7.fhir.r4.model.Contract.ContractStatus.REVOKED);
                break;
            case RESOLVED:
                tgt.setValue(org.hl7.fhir.r4.model.Contract.ContractStatus.RESOLVED);
                break;
            case TERMINATED:
                tgt.setValue(org.hl7.fhir.r4.model.Contract.ContractStatus.TERMINATED);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.Contract.ContractStatus.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Contract.ContentDefinitionComponent convertContentDefinitionComponent(org.hl7.fhir.r4.model.Contract.ContentDefinitionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Contract.ContentDefinitionComponent tgt = new org.hl7.fhir.r5.model.Contract.ContentDefinitionComponent();
        Element40_50.copyElement(src, tgt);
        if (src.hasType())
            tgt.setType(CodeableConcept40_50.convertCodeableConcept(src.getType()));
        if (src.hasSubType())
            tgt.setSubType(CodeableConcept40_50.convertCodeableConcept(src.getSubType()));
        if (src.hasPublisher())
            tgt.setPublisher(Reference40_50.convertReference(src.getPublisher()));
        if (src.hasPublicationDate())
            tgt.setPublicationDateElement(DateTime40_50.convertDateTime(src.getPublicationDateElement()));
        if (src.hasPublicationStatus())
            tgt.setPublicationStatusElement(convertContractPublicationStatus(src.getPublicationStatusElement()));
        if (src.hasCopyright())
            tgt.setCopyrightElement(MarkDown40_50.convertMarkdown(src.getCopyrightElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Contract.ContentDefinitionComponent convertContentDefinitionComponent(org.hl7.fhir.r5.model.Contract.ContentDefinitionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Contract.ContentDefinitionComponent tgt = new org.hl7.fhir.r4.model.Contract.ContentDefinitionComponent();
        Element40_50.copyElement(src, tgt);
        if (src.hasType())
            tgt.setType(CodeableConcept40_50.convertCodeableConcept(src.getType()));
        if (src.hasSubType())
            tgt.setSubType(CodeableConcept40_50.convertCodeableConcept(src.getSubType()));
        if (src.hasPublisher())
            tgt.setPublisher(Reference40_50.convertReference(src.getPublisher()));
        if (src.hasPublicationDate())
            tgt.setPublicationDateElement(DateTime40_50.convertDateTime(src.getPublicationDateElement()));
        if (src.hasPublicationStatus())
            tgt.setPublicationStatusElement(convertContractPublicationStatus(src.getPublicationStatusElement()));
        if (src.hasCopyright())
            tgt.setCopyrightElement(MarkDown40_50.convertMarkdown(src.getCopyrightElement()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Contract.ContractResourcePublicationStatusCodes> convertContractPublicationStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Contract.ContractPublicationStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Contract.ContractResourcePublicationStatusCodes> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Contract.ContractResourcePublicationStatusCodesEnumFactory());
        Element40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case AMENDED:
                tgt.setValue(org.hl7.fhir.r5.model.Contract.ContractResourcePublicationStatusCodes.AMENDED);
                break;
            case APPENDED:
                tgt.setValue(org.hl7.fhir.r5.model.Contract.ContractResourcePublicationStatusCodes.APPENDED);
                break;
            case CANCELLED:
                tgt.setValue(org.hl7.fhir.r5.model.Contract.ContractResourcePublicationStatusCodes.CANCELLED);
                break;
            case DISPUTED:
                tgt.setValue(org.hl7.fhir.r5.model.Contract.ContractResourcePublicationStatusCodes.DISPUTED);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.r5.model.Contract.ContractResourcePublicationStatusCodes.ENTEREDINERROR);
                break;
            case EXECUTABLE:
                tgt.setValue(org.hl7.fhir.r5.model.Contract.ContractResourcePublicationStatusCodes.EXECUTABLE);
                break;
            case EXECUTED:
                tgt.setValue(org.hl7.fhir.r5.model.Contract.ContractResourcePublicationStatusCodes.EXECUTED);
                break;
            case NEGOTIABLE:
                tgt.setValue(org.hl7.fhir.r5.model.Contract.ContractResourcePublicationStatusCodes.NEGOTIABLE);
                break;
            case OFFERED:
                tgt.setValue(org.hl7.fhir.r5.model.Contract.ContractResourcePublicationStatusCodes.OFFERED);
                break;
            case POLICY:
                tgt.setValue(org.hl7.fhir.r5.model.Contract.ContractResourcePublicationStatusCodes.POLICY);
                break;
            case REJECTED:
                tgt.setValue(org.hl7.fhir.r5.model.Contract.ContractResourcePublicationStatusCodes.REJECTED);
                break;
            case RENEWED:
                tgt.setValue(org.hl7.fhir.r5.model.Contract.ContractResourcePublicationStatusCodes.RENEWED);
                break;
            case REVOKED:
                tgt.setValue(org.hl7.fhir.r5.model.Contract.ContractResourcePublicationStatusCodes.REVOKED);
                break;
            case RESOLVED:
                tgt.setValue(org.hl7.fhir.r5.model.Contract.ContractResourcePublicationStatusCodes.RESOLVED);
                break;
            case TERMINATED:
                tgt.setValue(org.hl7.fhir.r5.model.Contract.ContractResourcePublicationStatusCodes.TERMINATED);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Contract.ContractResourcePublicationStatusCodes.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Contract.ContractPublicationStatus> convertContractPublicationStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Contract.ContractResourcePublicationStatusCodes> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Contract.ContractPublicationStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Contract.ContractPublicationStatusEnumFactory());
        Element40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case AMENDED:
                tgt.setValue(org.hl7.fhir.r4.model.Contract.ContractPublicationStatus.AMENDED);
                break;
            case APPENDED:
                tgt.setValue(org.hl7.fhir.r4.model.Contract.ContractPublicationStatus.APPENDED);
                break;
            case CANCELLED:
                tgt.setValue(org.hl7.fhir.r4.model.Contract.ContractPublicationStatus.CANCELLED);
                break;
            case DISPUTED:
                tgt.setValue(org.hl7.fhir.r4.model.Contract.ContractPublicationStatus.DISPUTED);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.r4.model.Contract.ContractPublicationStatus.ENTEREDINERROR);
                break;
            case EXECUTABLE:
                tgt.setValue(org.hl7.fhir.r4.model.Contract.ContractPublicationStatus.EXECUTABLE);
                break;
            case EXECUTED:
                tgt.setValue(org.hl7.fhir.r4.model.Contract.ContractPublicationStatus.EXECUTED);
                break;
            case NEGOTIABLE:
                tgt.setValue(org.hl7.fhir.r4.model.Contract.ContractPublicationStatus.NEGOTIABLE);
                break;
            case OFFERED:
                tgt.setValue(org.hl7.fhir.r4.model.Contract.ContractPublicationStatus.OFFERED);
                break;
            case POLICY:
                tgt.setValue(org.hl7.fhir.r4.model.Contract.ContractPublicationStatus.POLICY);
                break;
            case REJECTED:
                tgt.setValue(org.hl7.fhir.r4.model.Contract.ContractPublicationStatus.REJECTED);
                break;
            case RENEWED:
                tgt.setValue(org.hl7.fhir.r4.model.Contract.ContractPublicationStatus.RENEWED);
                break;
            case REVOKED:
                tgt.setValue(org.hl7.fhir.r4.model.Contract.ContractPublicationStatus.REVOKED);
                break;
            case RESOLVED:
                tgt.setValue(org.hl7.fhir.r4.model.Contract.ContractPublicationStatus.RESOLVED);
                break;
            case TERMINATED:
                tgt.setValue(org.hl7.fhir.r4.model.Contract.ContractPublicationStatus.TERMINATED);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.Contract.ContractPublicationStatus.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Contract.TermComponent convertTermComponent(org.hl7.fhir.r4.model.Contract.TermComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Contract.TermComponent tgt = new org.hl7.fhir.r5.model.Contract.TermComponent();
        Element40_50.copyElement(src, tgt);
        if (src.hasIdentifier())
            tgt.setIdentifier(Identifier40_50.convertIdentifier(src.getIdentifier()));
        if (src.hasIssued())
            tgt.setIssuedElement(DateTime40_50.convertDateTime(src.getIssuedElement()));
        if (src.hasApplies())
            tgt.setApplies(Period40_50.convertPeriod(src.getApplies()));
        if (src.hasTopic())
            tgt.setTopic(Type40_50.convertType(src.getTopic()));
        if (src.hasType())
            tgt.setType(CodeableConcept40_50.convertCodeableConcept(src.getType()));
        if (src.hasSubType())
            tgt.setSubType(CodeableConcept40_50.convertCodeableConcept(src.getSubType()));
        if (src.hasText())
            tgt.setTextElement(String40_50.convertString(src.getTextElement()));
        for (org.hl7.fhir.r4.model.Contract.SecurityLabelComponent t : src.getSecurityLabel()) tgt.addSecurityLabel(convertSecurityLabelComponent(t));
        if (src.hasOffer())
            tgt.setOffer(convertContractOfferComponent(src.getOffer()));
        for (org.hl7.fhir.r4.model.Contract.ContractAssetComponent t : src.getAsset()) tgt.addAsset(convertContractAssetComponent(t));
        for (org.hl7.fhir.r4.model.Contract.ActionComponent t : src.getAction()) tgt.addAction(convertActionComponent(t));
        for (org.hl7.fhir.r4.model.Contract.TermComponent t : src.getGroup()) tgt.addGroup(convertTermComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Contract.TermComponent convertTermComponent(org.hl7.fhir.r5.model.Contract.TermComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Contract.TermComponent tgt = new org.hl7.fhir.r4.model.Contract.TermComponent();
        Element40_50.copyElement(src, tgt);
        if (src.hasIdentifier())
            tgt.setIdentifier(Identifier40_50.convertIdentifier(src.getIdentifier()));
        if (src.hasIssued())
            tgt.setIssuedElement(DateTime40_50.convertDateTime(src.getIssuedElement()));
        if (src.hasApplies())
            tgt.setApplies(Period40_50.convertPeriod(src.getApplies()));
        if (src.hasTopic())
            tgt.setTopic(Type40_50.convertType(src.getTopic()));
        if (src.hasType())
            tgt.setType(CodeableConcept40_50.convertCodeableConcept(src.getType()));
        if (src.hasSubType())
            tgt.setSubType(CodeableConcept40_50.convertCodeableConcept(src.getSubType()));
        if (src.hasText())
            tgt.setTextElement(String40_50.convertString(src.getTextElement()));
        for (org.hl7.fhir.r5.model.Contract.SecurityLabelComponent t : src.getSecurityLabel()) tgt.addSecurityLabel(convertSecurityLabelComponent(t));
        if (src.hasOffer())
            tgt.setOffer(convertContractOfferComponent(src.getOffer()));
        for (org.hl7.fhir.r5.model.Contract.ContractAssetComponent t : src.getAsset()) tgt.addAsset(convertContractAssetComponent(t));
        for (org.hl7.fhir.r5.model.Contract.ActionComponent t : src.getAction()) tgt.addAction(convertActionComponent(t));
        for (org.hl7.fhir.r5.model.Contract.TermComponent t : src.getGroup()) tgt.addGroup(convertTermComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Contract.SecurityLabelComponent convertSecurityLabelComponent(org.hl7.fhir.r4.model.Contract.SecurityLabelComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Contract.SecurityLabelComponent tgt = new org.hl7.fhir.r5.model.Contract.SecurityLabelComponent();
        Element40_50.copyElement(src, tgt);
        for (org.hl7.fhir.r4.model.UnsignedIntType t : src.getNumber()) tgt.getNumber().add(UnsignedInt40_50.convertUnsignedInt(t));
        if (src.hasClassification())
            tgt.setClassification(Coding40_50.convertCoding(src.getClassification()));
        for (org.hl7.fhir.r4.model.Coding t : src.getCategory()) tgt.addCategory(Coding40_50.convertCoding(t));
        for (org.hl7.fhir.r4.model.Coding t : src.getControl()) tgt.addControl(Coding40_50.convertCoding(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Contract.SecurityLabelComponent convertSecurityLabelComponent(org.hl7.fhir.r5.model.Contract.SecurityLabelComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Contract.SecurityLabelComponent tgt = new org.hl7.fhir.r4.model.Contract.SecurityLabelComponent();
        Element40_50.copyElement(src, tgt);
        for (org.hl7.fhir.r5.model.UnsignedIntType t : src.getNumber()) tgt.getNumber().add(UnsignedInt40_50.convertUnsignedInt(t));
        if (src.hasClassification())
            tgt.setClassification(Coding40_50.convertCoding(src.getClassification()));
        for (org.hl7.fhir.r5.model.Coding t : src.getCategory()) tgt.addCategory(Coding40_50.convertCoding(t));
        for (org.hl7.fhir.r5.model.Coding t : src.getControl()) tgt.addControl(Coding40_50.convertCoding(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Contract.ContractOfferComponent convertContractOfferComponent(org.hl7.fhir.r4.model.Contract.ContractOfferComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Contract.ContractOfferComponent tgt = new org.hl7.fhir.r5.model.Contract.ContractOfferComponent();
        Element40_50.copyElement(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(Identifier40_50.convertIdentifier(t));
        for (org.hl7.fhir.r4.model.Contract.ContractPartyComponent t : src.getParty()) tgt.addParty(convertContractPartyComponent(t));
        if (src.hasTopic())
            tgt.setTopic(Reference40_50.convertReference(src.getTopic()));
        if (src.hasType())
            tgt.setType(CodeableConcept40_50.convertCodeableConcept(src.getType()));
        if (src.hasDecision())
            tgt.setDecision(CodeableConcept40_50.convertCodeableConcept(src.getDecision()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getDecisionMode()) tgt.addDecisionMode(CodeableConcept40_50.convertCodeableConcept(t));
        for (org.hl7.fhir.r4.model.Contract.AnswerComponent t : src.getAnswer()) tgt.addAnswer(convertAnswerComponent(t));
        if (src.hasText())
            tgt.setTextElement(String40_50.convertString(src.getTextElement()));
        for (org.hl7.fhir.r4.model.StringType t : src.getLinkId()) tgt.getLinkId().add(String40_50.convertString(t));
        for (org.hl7.fhir.r4.model.UnsignedIntType t : src.getSecurityLabelNumber()) tgt.getSecurityLabelNumber().add(UnsignedInt40_50.convertUnsignedInt(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Contract.ContractOfferComponent convertContractOfferComponent(org.hl7.fhir.r5.model.Contract.ContractOfferComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Contract.ContractOfferComponent tgt = new org.hl7.fhir.r4.model.Contract.ContractOfferComponent();
        Element40_50.copyElement(src, tgt);
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(Identifier40_50.convertIdentifier(t));
        for (org.hl7.fhir.r5.model.Contract.ContractPartyComponent t : src.getParty()) tgt.addParty(convertContractPartyComponent(t));
        if (src.hasTopic())
            tgt.setTopic(Reference40_50.convertReference(src.getTopic()));
        if (src.hasType())
            tgt.setType(CodeableConcept40_50.convertCodeableConcept(src.getType()));
        if (src.hasDecision())
            tgt.setDecision(CodeableConcept40_50.convertCodeableConcept(src.getDecision()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getDecisionMode()) tgt.addDecisionMode(CodeableConcept40_50.convertCodeableConcept(t));
        for (org.hl7.fhir.r5.model.Contract.AnswerComponent t : src.getAnswer()) tgt.addAnswer(convertAnswerComponent(t));
        if (src.hasText())
            tgt.setTextElement(String40_50.convertString(src.getTextElement()));
        for (org.hl7.fhir.r5.model.StringType t : src.getLinkId()) tgt.getLinkId().add(String40_50.convertString(t));
        for (org.hl7.fhir.r5.model.UnsignedIntType t : src.getSecurityLabelNumber()) tgt.getSecurityLabelNumber().add(UnsignedInt40_50.convertUnsignedInt(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Contract.ContractPartyComponent convertContractPartyComponent(org.hl7.fhir.r4.model.Contract.ContractPartyComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Contract.ContractPartyComponent tgt = new org.hl7.fhir.r5.model.Contract.ContractPartyComponent();
        Element40_50.copyElement(src, tgt);
        for (org.hl7.fhir.r4.model.Reference t : src.getReference()) tgt.addReference(Reference40_50.convertReference(t));
        if (src.hasRole())
            tgt.setRole(CodeableConcept40_50.convertCodeableConcept(src.getRole()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Contract.ContractPartyComponent convertContractPartyComponent(org.hl7.fhir.r5.model.Contract.ContractPartyComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Contract.ContractPartyComponent tgt = new org.hl7.fhir.r4.model.Contract.ContractPartyComponent();
        Element40_50.copyElement(src, tgt);
        for (org.hl7.fhir.r5.model.Reference t : src.getReference()) tgt.addReference(Reference40_50.convertReference(t));
        if (src.hasRole())
            tgt.setRole(CodeableConcept40_50.convertCodeableConcept(src.getRole()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Contract.AnswerComponent convertAnswerComponent(org.hl7.fhir.r4.model.Contract.AnswerComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Contract.AnswerComponent tgt = new org.hl7.fhir.r5.model.Contract.AnswerComponent();
        Element40_50.copyElement(src, tgt);
        if (src.hasValue())
            tgt.setValue(Type40_50.convertType(src.getValue()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Contract.AnswerComponent convertAnswerComponent(org.hl7.fhir.r5.model.Contract.AnswerComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Contract.AnswerComponent tgt = new org.hl7.fhir.r4.model.Contract.AnswerComponent();
        Element40_50.copyElement(src, tgt);
        if (src.hasValue())
            tgt.setValue(Type40_50.convertType(src.getValue()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Contract.ContractAssetComponent convertContractAssetComponent(org.hl7.fhir.r4.model.Contract.ContractAssetComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Contract.ContractAssetComponent tgt = new org.hl7.fhir.r5.model.Contract.ContractAssetComponent();
        Element40_50.copyElement(src, tgt);
        if (src.hasScope())
            tgt.setScope(CodeableConcept40_50.convertCodeableConcept(src.getScope()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getType()) tgt.addType(CodeableConcept40_50.convertCodeableConcept(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getTypeReference()) tgt.addTypeReference(Reference40_50.convertReference(t));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getSubtype()) tgt.addSubtype(CodeableConcept40_50.convertCodeableConcept(t));
        if (src.hasRelationship())
            tgt.setRelationship(Coding40_50.convertCoding(src.getRelationship()));
        for (org.hl7.fhir.r4.model.Contract.AssetContextComponent t : src.getContext()) tgt.addContext(convertAssetContextComponent(t));
        if (src.hasCondition())
            tgt.setConditionElement(String40_50.convertString(src.getConditionElement()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getPeriodType()) tgt.addPeriodType(CodeableConcept40_50.convertCodeableConcept(t));
        for (org.hl7.fhir.r4.model.Period t : src.getPeriod()) tgt.addPeriod(Period40_50.convertPeriod(t));
        for (org.hl7.fhir.r4.model.Period t : src.getUsePeriod()) tgt.addUsePeriod(Period40_50.convertPeriod(t));
        if (src.hasText())
            tgt.setTextElement(String40_50.convertString(src.getTextElement()));
        for (org.hl7.fhir.r4.model.StringType t : src.getLinkId()) tgt.getLinkId().add(String40_50.convertString(t));
        for (org.hl7.fhir.r4.model.Contract.AnswerComponent t : src.getAnswer()) tgt.addAnswer(convertAnswerComponent(t));
        for (org.hl7.fhir.r4.model.UnsignedIntType t : src.getSecurityLabelNumber()) tgt.getSecurityLabelNumber().add(UnsignedInt40_50.convertUnsignedInt(t));
        for (org.hl7.fhir.r4.model.Contract.ValuedItemComponent t : src.getValuedItem()) tgt.addValuedItem(convertValuedItemComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Contract.ContractAssetComponent convertContractAssetComponent(org.hl7.fhir.r5.model.Contract.ContractAssetComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Contract.ContractAssetComponent tgt = new org.hl7.fhir.r4.model.Contract.ContractAssetComponent();
        Element40_50.copyElement(src, tgt);
        if (src.hasScope())
            tgt.setScope(CodeableConcept40_50.convertCodeableConcept(src.getScope()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getType()) tgt.addType(CodeableConcept40_50.convertCodeableConcept(t));
        for (org.hl7.fhir.r5.model.Reference t : src.getTypeReference()) tgt.addTypeReference(Reference40_50.convertReference(t));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getSubtype()) tgt.addSubtype(CodeableConcept40_50.convertCodeableConcept(t));
        if (src.hasRelationship())
            tgt.setRelationship(Coding40_50.convertCoding(src.getRelationship()));
        for (org.hl7.fhir.r5.model.Contract.AssetContextComponent t : src.getContext()) tgt.addContext(convertAssetContextComponent(t));
        if (src.hasCondition())
            tgt.setConditionElement(String40_50.convertString(src.getConditionElement()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getPeriodType()) tgt.addPeriodType(CodeableConcept40_50.convertCodeableConcept(t));
        for (org.hl7.fhir.r5.model.Period t : src.getPeriod()) tgt.addPeriod(Period40_50.convertPeriod(t));
        for (org.hl7.fhir.r5.model.Period t : src.getUsePeriod()) tgt.addUsePeriod(Period40_50.convertPeriod(t));
        if (src.hasText())
            tgt.setTextElement(String40_50.convertString(src.getTextElement()));
        for (org.hl7.fhir.r5.model.StringType t : src.getLinkId()) tgt.getLinkId().add(String40_50.convertString(t));
        for (org.hl7.fhir.r5.model.Contract.AnswerComponent t : src.getAnswer()) tgt.addAnswer(convertAnswerComponent(t));
        for (org.hl7.fhir.r5.model.UnsignedIntType t : src.getSecurityLabelNumber()) tgt.getSecurityLabelNumber().add(UnsignedInt40_50.convertUnsignedInt(t));
        for (org.hl7.fhir.r5.model.Contract.ValuedItemComponent t : src.getValuedItem()) tgt.addValuedItem(convertValuedItemComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Contract.AssetContextComponent convertAssetContextComponent(org.hl7.fhir.r4.model.Contract.AssetContextComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Contract.AssetContextComponent tgt = new org.hl7.fhir.r5.model.Contract.AssetContextComponent();
        Element40_50.copyElement(src, tgt);
        if (src.hasReference())
            tgt.setReference(Reference40_50.convertReference(src.getReference()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCode()) tgt.addCode(CodeableConcept40_50.convertCodeableConcept(t));
        if (src.hasText())
            tgt.setTextElement(String40_50.convertString(src.getTextElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Contract.AssetContextComponent convertAssetContextComponent(org.hl7.fhir.r5.model.Contract.AssetContextComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Contract.AssetContextComponent tgt = new org.hl7.fhir.r4.model.Contract.AssetContextComponent();
        Element40_50.copyElement(src, tgt);
        if (src.hasReference())
            tgt.setReference(Reference40_50.convertReference(src.getReference()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCode()) tgt.addCode(CodeableConcept40_50.convertCodeableConcept(t));
        if (src.hasText())
            tgt.setTextElement(String40_50.convertString(src.getTextElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Contract.ValuedItemComponent convertValuedItemComponent(org.hl7.fhir.r4.model.Contract.ValuedItemComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Contract.ValuedItemComponent tgt = new org.hl7.fhir.r5.model.Contract.ValuedItemComponent();
        Element40_50.copyElement(src, tgt);
        if (src.hasEntity())
            tgt.setEntity(Type40_50.convertType(src.getEntity()));
        if (src.hasIdentifier())
            tgt.setIdentifier(Identifier40_50.convertIdentifier(src.getIdentifier()));
        if (src.hasEffectiveTime())
            tgt.setEffectiveTimeElement(DateTime40_50.convertDateTime(src.getEffectiveTimeElement()));
        if (src.hasQuantity())
            tgt.setQuantity(SimpleQuantity40_50.convertSimpleQuantity(src.getQuantity()));
        if (src.hasUnitPrice())
            tgt.setUnitPrice(Money40_50.convertMoney(src.getUnitPrice()));
        if (src.hasFactor())
            tgt.setFactorElement(Decimal40_50.convertDecimal(src.getFactorElement()));
        if (src.hasPoints())
            tgt.setPointsElement(Decimal40_50.convertDecimal(src.getPointsElement()));
        if (src.hasNet())
            tgt.setNet(Money40_50.convertMoney(src.getNet()));
        if (src.hasPayment())
            tgt.setPaymentElement(String40_50.convertString(src.getPaymentElement()));
        if (src.hasPaymentDate())
            tgt.setPaymentDateElement(DateTime40_50.convertDateTime(src.getPaymentDateElement()));
        if (src.hasResponsible())
            tgt.setResponsible(Reference40_50.convertReference(src.getResponsible()));
        if (src.hasRecipient())
            tgt.setRecipient(Reference40_50.convertReference(src.getRecipient()));
        for (org.hl7.fhir.r4.model.StringType t : src.getLinkId()) tgt.getLinkId().add(String40_50.convertString(t));
        for (org.hl7.fhir.r4.model.UnsignedIntType t : src.getSecurityLabelNumber()) tgt.getSecurityLabelNumber().add(UnsignedInt40_50.convertUnsignedInt(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Contract.ValuedItemComponent convertValuedItemComponent(org.hl7.fhir.r5.model.Contract.ValuedItemComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Contract.ValuedItemComponent tgt = new org.hl7.fhir.r4.model.Contract.ValuedItemComponent();
        Element40_50.copyElement(src, tgt);
        if (src.hasEntity())
            tgt.setEntity(Type40_50.convertType(src.getEntity()));
        if (src.hasIdentifier())
            tgt.setIdentifier(Identifier40_50.convertIdentifier(src.getIdentifier()));
        if (src.hasEffectiveTime())
            tgt.setEffectiveTimeElement(DateTime40_50.convertDateTime(src.getEffectiveTimeElement()));
        if (src.hasQuantity())
            tgt.setQuantity(SimpleQuantity40_50.convertSimpleQuantity(src.getQuantity()));
        if (src.hasUnitPrice())
            tgt.setUnitPrice(Money40_50.convertMoney(src.getUnitPrice()));
        if (src.hasFactor())
            tgt.setFactorElement(Decimal40_50.convertDecimal(src.getFactorElement()));
        if (src.hasPoints())
            tgt.setPointsElement(Decimal40_50.convertDecimal(src.getPointsElement()));
        if (src.hasNet())
            tgt.setNet(Money40_50.convertMoney(src.getNet()));
        if (src.hasPayment())
            tgt.setPaymentElement(String40_50.convertString(src.getPaymentElement()));
        if (src.hasPaymentDate())
            tgt.setPaymentDateElement(DateTime40_50.convertDateTime(src.getPaymentDateElement()));
        if (src.hasResponsible())
            tgt.setResponsible(Reference40_50.convertReference(src.getResponsible()));
        if (src.hasRecipient())
            tgt.setRecipient(Reference40_50.convertReference(src.getRecipient()));
        for (org.hl7.fhir.r5.model.StringType t : src.getLinkId()) tgt.getLinkId().add(String40_50.convertString(t));
        for (org.hl7.fhir.r5.model.UnsignedIntType t : src.getSecurityLabelNumber()) tgt.getSecurityLabelNumber().add(UnsignedInt40_50.convertUnsignedInt(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Contract.ActionComponent convertActionComponent(org.hl7.fhir.r4.model.Contract.ActionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Contract.ActionComponent tgt = new org.hl7.fhir.r5.model.Contract.ActionComponent();
        Element40_50.copyElement(src, tgt);
        if (src.hasDoNotPerform())
            tgt.setDoNotPerformElement(Boolean40_50.convertBoolean(src.getDoNotPerformElement()));
        if (src.hasType())
            tgt.setType(CodeableConcept40_50.convertCodeableConcept(src.getType()));
        for (org.hl7.fhir.r4.model.Contract.ActionSubjectComponent t : src.getSubject()) tgt.addSubject(convertActionSubjectComponent(t));
        if (src.hasIntent())
            tgt.setIntent(CodeableConcept40_50.convertCodeableConcept(src.getIntent()));
        for (org.hl7.fhir.r4.model.StringType t : src.getLinkId()) tgt.getLinkId().add(String40_50.convertString(t));
        if (src.hasStatus())
            tgt.setStatus(CodeableConcept40_50.convertCodeableConcept(src.getStatus()));
        if (src.hasContext())
            tgt.setContext(Reference40_50.convertReference(src.getContext()));
        for (org.hl7.fhir.r4.model.StringType t : src.getContextLinkId()) tgt.getContextLinkId().add(String40_50.convertString(t));
        if (src.hasOccurrence())
            tgt.setOccurrence(Type40_50.convertType(src.getOccurrence()));
        for (org.hl7.fhir.r4.model.Reference t : src.getRequester()) tgt.addRequester(Reference40_50.convertReference(t));
        for (org.hl7.fhir.r4.model.StringType t : src.getRequesterLinkId()) tgt.getRequesterLinkId().add(String40_50.convertString(t));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getPerformerType()) tgt.addPerformerType(CodeableConcept40_50.convertCodeableConcept(t));
        if (src.hasPerformerRole())
            tgt.setPerformerRole(CodeableConcept40_50.convertCodeableConcept(src.getPerformerRole()));
        if (src.hasPerformer())
            tgt.setPerformer(Reference40_50.convertReference(src.getPerformer()));
        for (org.hl7.fhir.r4.model.StringType t : src.getPerformerLinkId()) tgt.getPerformerLinkId().add(String40_50.convertString(t));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReasonCode()) tgt.addReason(CodeableConcept40_50.convertCodeableConceptToCodeableReference(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getReasonReference()) tgt.addReason(Reference40_50.convertReferenceToCodeableReference(t));
        for (org.hl7.fhir.r4.model.StringType t : src.getReasonLinkId()) tgt.getReasonLinkId().add(String40_50.convertString(t));
        for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.addNote(Annotation40_50.convertAnnotation(t));
        for (org.hl7.fhir.r4.model.UnsignedIntType t : src.getSecurityLabelNumber()) tgt.getSecurityLabelNumber().add(UnsignedInt40_50.convertUnsignedInt(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Contract.ActionComponent convertActionComponent(org.hl7.fhir.r5.model.Contract.ActionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Contract.ActionComponent tgt = new org.hl7.fhir.r4.model.Contract.ActionComponent();
        Element40_50.copyElement(src, tgt);
        if (src.hasDoNotPerform())
            tgt.setDoNotPerformElement(Boolean40_50.convertBoolean(src.getDoNotPerformElement()));
        if (src.hasType())
            tgt.setType(CodeableConcept40_50.convertCodeableConcept(src.getType()));
        for (org.hl7.fhir.r5.model.Contract.ActionSubjectComponent t : src.getSubject()) tgt.addSubject(convertActionSubjectComponent(t));
        if (src.hasIntent())
            tgt.setIntent(CodeableConcept40_50.convertCodeableConcept(src.getIntent()));
        for (org.hl7.fhir.r5.model.StringType t : src.getLinkId()) tgt.getLinkId().add(String40_50.convertString(t));
        if (src.hasStatus())
            tgt.setStatus(CodeableConcept40_50.convertCodeableConcept(src.getStatus()));
        if (src.hasContext())
            tgt.setContext(Reference40_50.convertReference(src.getContext()));
        for (org.hl7.fhir.r5.model.StringType t : src.getContextLinkId()) tgt.getContextLinkId().add(String40_50.convertString(t));
        if (src.hasOccurrence())
            tgt.setOccurrence(Type40_50.convertType(src.getOccurrence()));
        for (org.hl7.fhir.r5.model.Reference t : src.getRequester()) tgt.addRequester(Reference40_50.convertReference(t));
        for (org.hl7.fhir.r5.model.StringType t : src.getRequesterLinkId()) tgt.getRequesterLinkId().add(String40_50.convertString(t));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getPerformerType()) tgt.addPerformerType(CodeableConcept40_50.convertCodeableConcept(t));
        if (src.hasPerformerRole())
            tgt.setPerformerRole(CodeableConcept40_50.convertCodeableConcept(src.getPerformerRole()));
        if (src.hasPerformer())
            tgt.setPerformer(Reference40_50.convertReference(src.getPerformer()));
        for (org.hl7.fhir.r5.model.StringType t : src.getPerformerLinkId()) tgt.getPerformerLinkId().add(String40_50.convertString(t));
        for (CodeableReference t : src.getReason()) if (t.hasConcept())
            tgt.addReasonCode(CodeableConcept40_50.convertCodeableConcept(t.getConcept()));
        for (CodeableReference t : src.getReason()) if (t.hasReference())
            tgt.addReasonReference(Reference40_50.convertReference(t.getReference()));
        for (org.hl7.fhir.r5.model.StringType t : src.getReasonLinkId()) tgt.getReason().add(String40_50.convertString(t));
        for (org.hl7.fhir.r5.model.StringType t : src.getReasonLinkId()) tgt.getReasonLinkId().add(String40_50.convertString(t));
        for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.addNote(Annotation40_50.convertAnnotation(t));
        for (org.hl7.fhir.r5.model.UnsignedIntType t : src.getSecurityLabelNumber()) tgt.getSecurityLabelNumber().add(UnsignedInt40_50.convertUnsignedInt(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Contract.ActionSubjectComponent convertActionSubjectComponent(org.hl7.fhir.r4.model.Contract.ActionSubjectComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Contract.ActionSubjectComponent tgt = new org.hl7.fhir.r5.model.Contract.ActionSubjectComponent();
        Element40_50.copyElement(src, tgt);
        for (org.hl7.fhir.r4.model.Reference t : src.getReference()) tgt.addReference(Reference40_50.convertReference(t));
        if (src.hasRole())
            tgt.setRole(CodeableConcept40_50.convertCodeableConcept(src.getRole()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Contract.ActionSubjectComponent convertActionSubjectComponent(org.hl7.fhir.r5.model.Contract.ActionSubjectComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Contract.ActionSubjectComponent tgt = new org.hl7.fhir.r4.model.Contract.ActionSubjectComponent();
        Element40_50.copyElement(src, tgt);
        for (org.hl7.fhir.r5.model.Reference t : src.getReference()) tgt.addReference(Reference40_50.convertReference(t));
        if (src.hasRole())
            tgt.setRole(CodeableConcept40_50.convertCodeableConcept(src.getRole()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Contract.SignatoryComponent convertSignatoryComponent(org.hl7.fhir.r4.model.Contract.SignatoryComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Contract.SignatoryComponent tgt = new org.hl7.fhir.r5.model.Contract.SignatoryComponent();
        Element40_50.copyElement(src, tgt);
        if (src.hasType())
            tgt.setType(Coding40_50.convertCoding(src.getType()));
        if (src.hasParty())
            tgt.setParty(Reference40_50.convertReference(src.getParty()));
        for (org.hl7.fhir.r4.model.Signature t : src.getSignature()) tgt.addSignature(Signature40_50.convertSignature(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Contract.SignatoryComponent convertSignatoryComponent(org.hl7.fhir.r5.model.Contract.SignatoryComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Contract.SignatoryComponent tgt = new org.hl7.fhir.r4.model.Contract.SignatoryComponent();
        Element40_50.copyElement(src, tgt);
        if (src.hasType())
            tgt.setType(Coding40_50.convertCoding(src.getType()));
        if (src.hasParty())
            tgt.setParty(Reference40_50.convertReference(src.getParty()));
        for (org.hl7.fhir.r5.model.Signature t : src.getSignature()) tgt.addSignature(Signature40_50.convertSignature(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Contract.FriendlyLanguageComponent convertFriendlyLanguageComponent(org.hl7.fhir.r4.model.Contract.FriendlyLanguageComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Contract.FriendlyLanguageComponent tgt = new org.hl7.fhir.r5.model.Contract.FriendlyLanguageComponent();
        Element40_50.copyElement(src, tgt);
        if (src.hasContent())
            tgt.setContent(Type40_50.convertType(src.getContent()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Contract.FriendlyLanguageComponent convertFriendlyLanguageComponent(org.hl7.fhir.r5.model.Contract.FriendlyLanguageComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Contract.FriendlyLanguageComponent tgt = new org.hl7.fhir.r4.model.Contract.FriendlyLanguageComponent();
        Element40_50.copyElement(src, tgt);
        if (src.hasContent())
            tgt.setContent(Type40_50.convertType(src.getContent()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Contract.LegalLanguageComponent convertLegalLanguageComponent(org.hl7.fhir.r4.model.Contract.LegalLanguageComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Contract.LegalLanguageComponent tgt = new org.hl7.fhir.r5.model.Contract.LegalLanguageComponent();
        Element40_50.copyElement(src, tgt);
        if (src.hasContent())
            tgt.setContent(Type40_50.convertType(src.getContent()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Contract.LegalLanguageComponent convertLegalLanguageComponent(org.hl7.fhir.r5.model.Contract.LegalLanguageComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Contract.LegalLanguageComponent tgt = new org.hl7.fhir.r4.model.Contract.LegalLanguageComponent();
        Element40_50.copyElement(src, tgt);
        if (src.hasContent())
            tgt.setContent(Type40_50.convertType(src.getContent()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Contract.ComputableLanguageComponent convertComputableLanguageComponent(org.hl7.fhir.r4.model.Contract.ComputableLanguageComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Contract.ComputableLanguageComponent tgt = new org.hl7.fhir.r5.model.Contract.ComputableLanguageComponent();
        Element40_50.copyElement(src, tgt);
        if (src.hasContent())
            tgt.setContent(Type40_50.convertType(src.getContent()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Contract.ComputableLanguageComponent convertComputableLanguageComponent(org.hl7.fhir.r5.model.Contract.ComputableLanguageComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Contract.ComputableLanguageComponent tgt = new org.hl7.fhir.r4.model.Contract.ComputableLanguageComponent();
        Element40_50.copyElement(src, tgt);
        if (src.hasContent())
            tgt.setContent(Type40_50.convertType(src.getContent()));
        return tgt;
    }
}