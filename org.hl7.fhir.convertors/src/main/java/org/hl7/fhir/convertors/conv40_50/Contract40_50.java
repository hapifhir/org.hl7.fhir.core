package org.hl7.fhir.convertors.conv40_50;


import org.hl7.fhir.convertors.VersionConvertor_40_50;
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
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        if (src.hasUrl())
            tgt.setUrlElement(convertUri(src.getUrlElement()));
        if (src.hasVersion())
            tgt.setVersionElement(convertString(src.getVersionElement()));
        if (src.hasStatus())
            tgt.setStatusElement(convertContractStatus(src.getStatusElement()));
        if (src.hasLegalState())
            tgt.setLegalState(convertCodeableConcept(src.getLegalState()));
        if (src.hasInstantiatesCanonical())
            tgt.setInstantiatesCanonical(convertReference(src.getInstantiatesCanonical()));
        if (src.hasInstantiatesUri())
            tgt.setInstantiatesUriElement(convertUri(src.getInstantiatesUriElement()));
        if (src.hasContentDerivative())
            tgt.setContentDerivative(convertCodeableConcept(src.getContentDerivative()));
        if (src.hasIssued())
            tgt.setIssuedElement(convertDateTime(src.getIssuedElement()));
        if (src.hasApplies())
            tgt.setApplies(convertPeriod(src.getApplies()));
        if (src.hasExpirationType())
            tgt.setExpirationType(convertCodeableConcept(src.getExpirationType()));
        for (org.hl7.fhir.r4.model.Reference t : src.getSubject()) tgt.addSubject(convertReference(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getAuthority()) tgt.addAuthority(convertReference(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getDomain()) tgt.addDomain(convertReference(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getSite()) tgt.addSite(convertReference(t));
        if (src.hasName())
            tgt.setNameElement(convertString(src.getNameElement()));
        if (src.hasTitle())
            tgt.setTitleElement(convertString(src.getTitleElement()));
        if (src.hasSubtitle())
            tgt.setSubtitleElement(convertString(src.getSubtitleElement()));
        for (org.hl7.fhir.r4.model.StringType t : src.getAlias()) tgt.getAlias().add(convertString(t));
        if (src.hasAuthor())
            tgt.setAuthor(convertReference(src.getAuthor()));
        if (src.hasScope())
            tgt.setScope(convertCodeableConcept(src.getScope()));
        if (src.hasTopic())
            tgt.setTopic(convertType(src.getTopic()));
        if (src.hasType())
            tgt.setType(convertCodeableConcept(src.getType()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getSubType()) tgt.addSubType(convertCodeableConcept(t));
        if (src.hasContentDefinition())
            tgt.setContentDefinition(convertContentDefinitionComponent(src.getContentDefinition()));
        for (org.hl7.fhir.r4.model.Contract.TermComponent t : src.getTerm()) tgt.addTerm(convertTermComponent(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getSupportingInfo()) tgt.addSupportingInfo(convertReference(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getRelevantHistory()) tgt.addRelevantHistory(convertReference(t));
        for (org.hl7.fhir.r4.model.Contract.SignatoryComponent t : src.getSigner()) tgt.addSigner(convertSignatoryComponent(t));
        for (org.hl7.fhir.r4.model.Contract.FriendlyLanguageComponent t : src.getFriendly()) tgt.addFriendly(convertFriendlyLanguageComponent(t));
        for (org.hl7.fhir.r4.model.Contract.LegalLanguageComponent t : src.getLegal()) tgt.addLegal(convertLegalLanguageComponent(t));
        for (org.hl7.fhir.r4.model.Contract.ComputableLanguageComponent t : src.getRule()) tgt.addRule(convertComputableLanguageComponent(t));
        if (src.hasLegallyBinding())
            tgt.setLegallyBinding(convertType(src.getLegallyBinding()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Contract convertContract(org.hl7.fhir.r5.model.Contract src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Contract tgt = new org.hl7.fhir.r4.model.Contract();
        copyDomainResource(src, tgt);
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        if (src.hasUrl())
            tgt.setUrlElement(convertUri(src.getUrlElement()));
        if (src.hasVersion())
            tgt.setVersionElement(convertString(src.getVersionElement()));
        if (src.hasStatus())
            tgt.setStatusElement(convertContractStatus(src.getStatusElement()));
        if (src.hasLegalState())
            tgt.setLegalState(convertCodeableConcept(src.getLegalState()));
        if (src.hasInstantiatesCanonical())
            tgt.setInstantiatesCanonical(convertReference(src.getInstantiatesCanonical()));
        if (src.hasInstantiatesUri())
            tgt.setInstantiatesUriElement(convertUri(src.getInstantiatesUriElement()));
        if (src.hasContentDerivative())
            tgt.setContentDerivative(convertCodeableConcept(src.getContentDerivative()));
        if (src.hasIssued())
            tgt.setIssuedElement(convertDateTime(src.getIssuedElement()));
        if (src.hasApplies())
            tgt.setApplies(convertPeriod(src.getApplies()));
        if (src.hasExpirationType())
            tgt.setExpirationType(convertCodeableConcept(src.getExpirationType()));
        for (org.hl7.fhir.r5.model.Reference t : src.getSubject()) tgt.addSubject(convertReference(t));
        for (org.hl7.fhir.r5.model.Reference t : src.getAuthority()) tgt.addAuthority(convertReference(t));
        for (org.hl7.fhir.r5.model.Reference t : src.getDomain()) tgt.addDomain(convertReference(t));
        for (org.hl7.fhir.r5.model.Reference t : src.getSite()) tgt.addSite(convertReference(t));
        if (src.hasName())
            tgt.setNameElement(convertString(src.getNameElement()));
        if (src.hasTitle())
            tgt.setTitleElement(convertString(src.getTitleElement()));
        if (src.hasSubtitle())
            tgt.setSubtitleElement(convertString(src.getSubtitleElement()));
        for (org.hl7.fhir.r5.model.StringType t : src.getAlias()) tgt.getAlias().add(convertString(t));
        if (src.hasAuthor())
            tgt.setAuthor(convertReference(src.getAuthor()));
        if (src.hasScope())
            tgt.setScope(convertCodeableConcept(src.getScope()));
        if (src.hasTopic())
            tgt.setTopic(convertType(src.getTopic()));
        if (src.hasType())
            tgt.setType(convertCodeableConcept(src.getType()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getSubType()) tgt.addSubType(convertCodeableConcept(t));
        if (src.hasContentDefinition())
            tgt.setContentDefinition(convertContentDefinitionComponent(src.getContentDefinition()));
        for (org.hl7.fhir.r5.model.Contract.TermComponent t : src.getTerm()) tgt.addTerm(convertTermComponent(t));
        for (org.hl7.fhir.r5.model.Reference t : src.getSupportingInfo()) tgt.addSupportingInfo(convertReference(t));
        for (org.hl7.fhir.r5.model.Reference t : src.getRelevantHistory()) tgt.addRelevantHistory(convertReference(t));
        for (org.hl7.fhir.r5.model.Contract.SignatoryComponent t : src.getSigner()) tgt.addSigner(convertSignatoryComponent(t));
        for (org.hl7.fhir.r5.model.Contract.FriendlyLanguageComponent t : src.getFriendly()) tgt.addFriendly(convertFriendlyLanguageComponent(t));
        for (org.hl7.fhir.r5.model.Contract.LegalLanguageComponent t : src.getLegal()) tgt.addLegal(convertLegalLanguageComponent(t));
        for (org.hl7.fhir.r5.model.Contract.ComputableLanguageComponent t : src.getRule()) tgt.addRule(convertComputableLanguageComponent(t));
        if (src.hasLegallyBinding())
            tgt.setLegallyBinding(convertType(src.getLegallyBinding()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Contract.ContractResourceStatusCodes> convertContractStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Contract.ContractStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Contract.ContractResourceStatusCodes> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Contract.ContractResourceStatusCodesEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
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
        VersionConvertor_40_50.copyElement(src, tgt);
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
        copyElement(src, tgt);
        if (src.hasType())
            tgt.setType(convertCodeableConcept(src.getType()));
        if (src.hasSubType())
            tgt.setSubType(convertCodeableConcept(src.getSubType()));
        if (src.hasPublisher())
            tgt.setPublisher(convertReference(src.getPublisher()));
        if (src.hasPublicationDate())
            tgt.setPublicationDateElement(convertDateTime(src.getPublicationDateElement()));
        if (src.hasPublicationStatus())
            tgt.setPublicationStatusElement(convertContractPublicationStatus(src.getPublicationStatusElement()));
        if (src.hasCopyright())
            tgt.setCopyrightElement(convertMarkdown(src.getCopyrightElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Contract.ContentDefinitionComponent convertContentDefinitionComponent(org.hl7.fhir.r5.model.Contract.ContentDefinitionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Contract.ContentDefinitionComponent tgt = new org.hl7.fhir.r4.model.Contract.ContentDefinitionComponent();
        copyElement(src, tgt);
        if (src.hasType())
            tgt.setType(convertCodeableConcept(src.getType()));
        if (src.hasSubType())
            tgt.setSubType(convertCodeableConcept(src.getSubType()));
        if (src.hasPublisher())
            tgt.setPublisher(convertReference(src.getPublisher()));
        if (src.hasPublicationDate())
            tgt.setPublicationDateElement(convertDateTime(src.getPublicationDateElement()));
        if (src.hasPublicationStatus())
            tgt.setPublicationStatusElement(convertContractPublicationStatus(src.getPublicationStatusElement()));
        if (src.hasCopyright())
            tgt.setCopyrightElement(convertMarkdown(src.getCopyrightElement()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Contract.ContractResourcePublicationStatusCodes> convertContractPublicationStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Contract.ContractPublicationStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Contract.ContractResourcePublicationStatusCodes> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Contract.ContractResourcePublicationStatusCodesEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
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
        VersionConvertor_40_50.copyElement(src, tgt);
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
        copyElement(src, tgt);
        if (src.hasIdentifier())
            tgt.setIdentifier(convertIdentifier(src.getIdentifier()));
        if (src.hasIssued())
            tgt.setIssuedElement(convertDateTime(src.getIssuedElement()));
        if (src.hasApplies())
            tgt.setApplies(convertPeriod(src.getApplies()));
        if (src.hasTopic())
            tgt.setTopic(convertType(src.getTopic()));
        if (src.hasType())
            tgt.setType(convertCodeableConcept(src.getType()));
        if (src.hasSubType())
            tgt.setSubType(convertCodeableConcept(src.getSubType()));
        if (src.hasText())
            tgt.setTextElement(convertString(src.getTextElement()));
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
        copyElement(src, tgt);
        if (src.hasIdentifier())
            tgt.setIdentifier(convertIdentifier(src.getIdentifier()));
        if (src.hasIssued())
            tgt.setIssuedElement(convertDateTime(src.getIssuedElement()));
        if (src.hasApplies())
            tgt.setApplies(convertPeriod(src.getApplies()));
        if (src.hasTopic())
            tgt.setTopic(convertType(src.getTopic()));
        if (src.hasType())
            tgt.setType(convertCodeableConcept(src.getType()));
        if (src.hasSubType())
            tgt.setSubType(convertCodeableConcept(src.getSubType()));
        if (src.hasText())
            tgt.setTextElement(convertString(src.getTextElement()));
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
        copyElement(src, tgt);
        for (org.hl7.fhir.r4.model.UnsignedIntType t : src.getNumber()) tgt.getNumber().add(convertUnsignedInt(t));
        if (src.hasClassification())
            tgt.setClassification(convertCoding(src.getClassification()));
        for (org.hl7.fhir.r4.model.Coding t : src.getCategory()) tgt.addCategory(convertCoding(t));
        for (org.hl7.fhir.r4.model.Coding t : src.getControl()) tgt.addControl(convertCoding(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Contract.SecurityLabelComponent convertSecurityLabelComponent(org.hl7.fhir.r5.model.Contract.SecurityLabelComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Contract.SecurityLabelComponent tgt = new org.hl7.fhir.r4.model.Contract.SecurityLabelComponent();
        copyElement(src, tgt);
        for (org.hl7.fhir.r5.model.UnsignedIntType t : src.getNumber()) tgt.getNumber().add(convertUnsignedInt(t));
        if (src.hasClassification())
            tgt.setClassification(convertCoding(src.getClassification()));
        for (org.hl7.fhir.r5.model.Coding t : src.getCategory()) tgt.addCategory(convertCoding(t));
        for (org.hl7.fhir.r5.model.Coding t : src.getControl()) tgt.addControl(convertCoding(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Contract.ContractOfferComponent convertContractOfferComponent(org.hl7.fhir.r4.model.Contract.ContractOfferComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Contract.ContractOfferComponent tgt = new org.hl7.fhir.r5.model.Contract.ContractOfferComponent();
        copyElement(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        for (org.hl7.fhir.r4.model.Contract.ContractPartyComponent t : src.getParty()) tgt.addParty(convertContractPartyComponent(t));
        if (src.hasTopic())
            tgt.setTopic(convertReference(src.getTopic()));
        if (src.hasType())
            tgt.setType(convertCodeableConcept(src.getType()));
        if (src.hasDecision())
            tgt.setDecision(convertCodeableConcept(src.getDecision()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getDecisionMode()) tgt.addDecisionMode(convertCodeableConcept(t));
        for (org.hl7.fhir.r4.model.Contract.AnswerComponent t : src.getAnswer()) tgt.addAnswer(convertAnswerComponent(t));
        if (src.hasText())
            tgt.setTextElement(convertString(src.getTextElement()));
        for (org.hl7.fhir.r4.model.StringType t : src.getLinkId()) tgt.getLinkId().add(convertString(t));
        for (org.hl7.fhir.r4.model.UnsignedIntType t : src.getSecurityLabelNumber()) tgt.getSecurityLabelNumber().add(convertUnsignedInt(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Contract.ContractOfferComponent convertContractOfferComponent(org.hl7.fhir.r5.model.Contract.ContractOfferComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Contract.ContractOfferComponent tgt = new org.hl7.fhir.r4.model.Contract.ContractOfferComponent();
        copyElement(src, tgt);
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        for (org.hl7.fhir.r5.model.Contract.ContractPartyComponent t : src.getParty()) tgt.addParty(convertContractPartyComponent(t));
        if (src.hasTopic())
            tgt.setTopic(convertReference(src.getTopic()));
        if (src.hasType())
            tgt.setType(convertCodeableConcept(src.getType()));
        if (src.hasDecision())
            tgt.setDecision(convertCodeableConcept(src.getDecision()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getDecisionMode()) tgt.addDecisionMode(convertCodeableConcept(t));
        for (org.hl7.fhir.r5.model.Contract.AnswerComponent t : src.getAnswer()) tgt.addAnswer(convertAnswerComponent(t));
        if (src.hasText())
            tgt.setTextElement(convertString(src.getTextElement()));
        for (org.hl7.fhir.r5.model.StringType t : src.getLinkId()) tgt.getLinkId().add(convertString(t));
        for (org.hl7.fhir.r5.model.UnsignedIntType t : src.getSecurityLabelNumber()) tgt.getSecurityLabelNumber().add(convertUnsignedInt(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Contract.ContractPartyComponent convertContractPartyComponent(org.hl7.fhir.r4.model.Contract.ContractPartyComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Contract.ContractPartyComponent tgt = new org.hl7.fhir.r5.model.Contract.ContractPartyComponent();
        copyElement(src, tgt);
        for (org.hl7.fhir.r4.model.Reference t : src.getReference()) tgt.addReference(convertReference(t));
        if (src.hasRole())
            tgt.setRole(convertCodeableConcept(src.getRole()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Contract.ContractPartyComponent convertContractPartyComponent(org.hl7.fhir.r5.model.Contract.ContractPartyComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Contract.ContractPartyComponent tgt = new org.hl7.fhir.r4.model.Contract.ContractPartyComponent();
        copyElement(src, tgt);
        for (org.hl7.fhir.r5.model.Reference t : src.getReference()) tgt.addReference(convertReference(t));
        if (src.hasRole())
            tgt.setRole(convertCodeableConcept(src.getRole()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Contract.AnswerComponent convertAnswerComponent(org.hl7.fhir.r4.model.Contract.AnswerComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Contract.AnswerComponent tgt = new org.hl7.fhir.r5.model.Contract.AnswerComponent();
        copyElement(src, tgt);
        if (src.hasValue())
            tgt.setValue(convertType(src.getValue()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Contract.AnswerComponent convertAnswerComponent(org.hl7.fhir.r5.model.Contract.AnswerComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Contract.AnswerComponent tgt = new org.hl7.fhir.r4.model.Contract.AnswerComponent();
        copyElement(src, tgt);
        if (src.hasValue())
            tgt.setValue(convertType(src.getValue()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Contract.ContractAssetComponent convertContractAssetComponent(org.hl7.fhir.r4.model.Contract.ContractAssetComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Contract.ContractAssetComponent tgt = new org.hl7.fhir.r5.model.Contract.ContractAssetComponent();
        copyElement(src, tgt);
        if (src.hasScope())
            tgt.setScope(convertCodeableConcept(src.getScope()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getType()) tgt.addType(convertCodeableConcept(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getTypeReference()) tgt.addTypeReference(convertReference(t));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getSubtype()) tgt.addSubtype(convertCodeableConcept(t));
        if (src.hasRelationship())
            tgt.setRelationship(convertCoding(src.getRelationship()));
        for (org.hl7.fhir.r4.model.Contract.AssetContextComponent t : src.getContext()) tgt.addContext(convertAssetContextComponent(t));
        if (src.hasCondition())
            tgt.setConditionElement(convertString(src.getConditionElement()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getPeriodType()) tgt.addPeriodType(convertCodeableConcept(t));
        for (org.hl7.fhir.r4.model.Period t : src.getPeriod()) tgt.addPeriod(convertPeriod(t));
        for (org.hl7.fhir.r4.model.Period t : src.getUsePeriod()) tgt.addUsePeriod(convertPeriod(t));
        if (src.hasText())
            tgt.setTextElement(convertString(src.getTextElement()));
        for (org.hl7.fhir.r4.model.StringType t : src.getLinkId()) tgt.getLinkId().add(convertString(t));
        for (org.hl7.fhir.r4.model.Contract.AnswerComponent t : src.getAnswer()) tgt.addAnswer(convertAnswerComponent(t));
        for (org.hl7.fhir.r4.model.UnsignedIntType t : src.getSecurityLabelNumber()) tgt.getSecurityLabelNumber().add(convertUnsignedInt(t));
        for (org.hl7.fhir.r4.model.Contract.ValuedItemComponent t : src.getValuedItem()) tgt.addValuedItem(convertValuedItemComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Contract.ContractAssetComponent convertContractAssetComponent(org.hl7.fhir.r5.model.Contract.ContractAssetComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Contract.ContractAssetComponent tgt = new org.hl7.fhir.r4.model.Contract.ContractAssetComponent();
        copyElement(src, tgt);
        if (src.hasScope())
            tgt.setScope(convertCodeableConcept(src.getScope()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getType()) tgt.addType(convertCodeableConcept(t));
        for (org.hl7.fhir.r5.model.Reference t : src.getTypeReference()) tgt.addTypeReference(convertReference(t));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getSubtype()) tgt.addSubtype(convertCodeableConcept(t));
        if (src.hasRelationship())
            tgt.setRelationship(convertCoding(src.getRelationship()));
        for (org.hl7.fhir.r5.model.Contract.AssetContextComponent t : src.getContext()) tgt.addContext(convertAssetContextComponent(t));
        if (src.hasCondition())
            tgt.setConditionElement(convertString(src.getConditionElement()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getPeriodType()) tgt.addPeriodType(convertCodeableConcept(t));
        for (org.hl7.fhir.r5.model.Period t : src.getPeriod()) tgt.addPeriod(convertPeriod(t));
        for (org.hl7.fhir.r5.model.Period t : src.getUsePeriod()) tgt.addUsePeriod(convertPeriod(t));
        if (src.hasText())
            tgt.setTextElement(convertString(src.getTextElement()));
        for (org.hl7.fhir.r5.model.StringType t : src.getLinkId()) tgt.getLinkId().add(convertString(t));
        for (org.hl7.fhir.r5.model.Contract.AnswerComponent t : src.getAnswer()) tgt.addAnswer(convertAnswerComponent(t));
        for (org.hl7.fhir.r5.model.UnsignedIntType t : src.getSecurityLabelNumber()) tgt.getSecurityLabelNumber().add(convertUnsignedInt(t));
        for (org.hl7.fhir.r5.model.Contract.ValuedItemComponent t : src.getValuedItem()) tgt.addValuedItem(convertValuedItemComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Contract.AssetContextComponent convertAssetContextComponent(org.hl7.fhir.r4.model.Contract.AssetContextComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Contract.AssetContextComponent tgt = new org.hl7.fhir.r5.model.Contract.AssetContextComponent();
        copyElement(src, tgt);
        if (src.hasReference())
            tgt.setReference(convertReference(src.getReference()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCode()) tgt.addCode(convertCodeableConcept(t));
        if (src.hasText())
            tgt.setTextElement(convertString(src.getTextElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Contract.AssetContextComponent convertAssetContextComponent(org.hl7.fhir.r5.model.Contract.AssetContextComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Contract.AssetContextComponent tgt = new org.hl7.fhir.r4.model.Contract.AssetContextComponent();
        copyElement(src, tgt);
        if (src.hasReference())
            tgt.setReference(convertReference(src.getReference()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCode()) tgt.addCode(convertCodeableConcept(t));
        if (src.hasText())
            tgt.setTextElement(convertString(src.getTextElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Contract.ValuedItemComponent convertValuedItemComponent(org.hl7.fhir.r4.model.Contract.ValuedItemComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Contract.ValuedItemComponent tgt = new org.hl7.fhir.r5.model.Contract.ValuedItemComponent();
        copyElement(src, tgt);
        if (src.hasEntity())
            tgt.setEntity(convertType(src.getEntity()));
        if (src.hasIdentifier())
            tgt.setIdentifier(convertIdentifier(src.getIdentifier()));
        if (src.hasEffectiveTime())
            tgt.setEffectiveTimeElement(convertDateTime(src.getEffectiveTimeElement()));
        if (src.hasQuantity())
            tgt.setQuantity(convertSimpleQuantity(src.getQuantity()));
        if (src.hasUnitPrice())
            tgt.setUnitPrice(convertMoney(src.getUnitPrice()));
        if (src.hasFactor())
            tgt.setFactorElement(convertDecimal(src.getFactorElement()));
        if (src.hasPoints())
            tgt.setPointsElement(convertDecimal(src.getPointsElement()));
        if (src.hasNet())
            tgt.setNet(convertMoney(src.getNet()));
        if (src.hasPayment())
            tgt.setPaymentElement(convertString(src.getPaymentElement()));
        if (src.hasPaymentDate())
            tgt.setPaymentDateElement(convertDateTime(src.getPaymentDateElement()));
        if (src.hasResponsible())
            tgt.setResponsible(convertReference(src.getResponsible()));
        if (src.hasRecipient())
            tgt.setRecipient(convertReference(src.getRecipient()));
        for (org.hl7.fhir.r4.model.StringType t : src.getLinkId()) tgt.getLinkId().add(convertString(t));
        for (org.hl7.fhir.r4.model.UnsignedIntType t : src.getSecurityLabelNumber()) tgt.getSecurityLabelNumber().add(convertUnsignedInt(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Contract.ValuedItemComponent convertValuedItemComponent(org.hl7.fhir.r5.model.Contract.ValuedItemComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Contract.ValuedItemComponent tgt = new org.hl7.fhir.r4.model.Contract.ValuedItemComponent();
        copyElement(src, tgt);
        if (src.hasEntity())
            tgt.setEntity(convertType(src.getEntity()));
        if (src.hasIdentifier())
            tgt.setIdentifier(convertIdentifier(src.getIdentifier()));
        if (src.hasEffectiveTime())
            tgt.setEffectiveTimeElement(convertDateTime(src.getEffectiveTimeElement()));
        if (src.hasQuantity())
            tgt.setQuantity(convertSimpleQuantity(src.getQuantity()));
        if (src.hasUnitPrice())
            tgt.setUnitPrice(convertMoney(src.getUnitPrice()));
        if (src.hasFactor())
            tgt.setFactorElement(convertDecimal(src.getFactorElement()));
        if (src.hasPoints())
            tgt.setPointsElement(convertDecimal(src.getPointsElement()));
        if (src.hasNet())
            tgt.setNet(convertMoney(src.getNet()));
        if (src.hasPayment())
            tgt.setPaymentElement(convertString(src.getPaymentElement()));
        if (src.hasPaymentDate())
            tgt.setPaymentDateElement(convertDateTime(src.getPaymentDateElement()));
        if (src.hasResponsible())
            tgt.setResponsible(convertReference(src.getResponsible()));
        if (src.hasRecipient())
            tgt.setRecipient(convertReference(src.getRecipient()));
        for (org.hl7.fhir.r5.model.StringType t : src.getLinkId()) tgt.getLinkId().add(convertString(t));
        for (org.hl7.fhir.r5.model.UnsignedIntType t : src.getSecurityLabelNumber()) tgt.getSecurityLabelNumber().add(convertUnsignedInt(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Contract.ActionComponent convertActionComponent(org.hl7.fhir.r4.model.Contract.ActionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Contract.ActionComponent tgt = new org.hl7.fhir.r5.model.Contract.ActionComponent();
        copyElement(src, tgt);
        if (src.hasDoNotPerform())
            tgt.setDoNotPerformElement(convertBoolean(src.getDoNotPerformElement()));
        if (src.hasType())
            tgt.setType(convertCodeableConcept(src.getType()));
        for (org.hl7.fhir.r4.model.Contract.ActionSubjectComponent t : src.getSubject()) tgt.addSubject(convertActionSubjectComponent(t));
        if (src.hasIntent())
            tgt.setIntent(convertCodeableConcept(src.getIntent()));
        for (org.hl7.fhir.r4.model.StringType t : src.getLinkId()) tgt.getLinkId().add(convertString(t));
        if (src.hasStatus())
            tgt.setStatus(convertCodeableConcept(src.getStatus()));
        if (src.hasContext())
            tgt.setContext(convertReference(src.getContext()));
        for (org.hl7.fhir.r4.model.StringType t : src.getContextLinkId()) tgt.getContextLinkId().add(convertString(t));
        if (src.hasOccurrence())
            tgt.setOccurrence(convertType(src.getOccurrence()));
        for (org.hl7.fhir.r4.model.Reference t : src.getRequester()) tgt.addRequester(convertReference(t));
        for (org.hl7.fhir.r4.model.StringType t : src.getRequesterLinkId()) tgt.getRequesterLinkId().add(convertString(t));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getPerformerType()) tgt.addPerformerType(convertCodeableConcept(t));
        if (src.hasPerformerRole())
            tgt.setPerformerRole(convertCodeableConcept(src.getPerformerRole()));
        if (src.hasPerformer())
            tgt.setPerformer(convertReference(src.getPerformer()));
        for (org.hl7.fhir.r4.model.StringType t : src.getPerformerLinkId()) tgt.getPerformerLinkId().add(convertString(t));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReasonCode()) tgt.addReason(convertCodeableConceptToCodeableReference(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getReasonReference()) tgt.addReason(convertReferenceToCodeableReference(t));
        for (org.hl7.fhir.r4.model.StringType t : src.getReasonLinkId()) tgt.getReasonLinkId().add(convertString(t));
        for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.addNote(convertAnnotation(t));
        for (org.hl7.fhir.r4.model.UnsignedIntType t : src.getSecurityLabelNumber()) tgt.getSecurityLabelNumber().add(convertUnsignedInt(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Contract.ActionComponent convertActionComponent(org.hl7.fhir.r5.model.Contract.ActionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Contract.ActionComponent tgt = new org.hl7.fhir.r4.model.Contract.ActionComponent();
        copyElement(src, tgt);
        if (src.hasDoNotPerform())
            tgt.setDoNotPerformElement(convertBoolean(src.getDoNotPerformElement()));
        if (src.hasType())
            tgt.setType(convertCodeableConcept(src.getType()));
        for (org.hl7.fhir.r5.model.Contract.ActionSubjectComponent t : src.getSubject()) tgt.addSubject(convertActionSubjectComponent(t));
        if (src.hasIntent())
            tgt.setIntent(convertCodeableConcept(src.getIntent()));
        for (org.hl7.fhir.r5.model.StringType t : src.getLinkId()) tgt.getLinkId().add(convertString(t));
        if (src.hasStatus())
            tgt.setStatus(convertCodeableConcept(src.getStatus()));
        if (src.hasContext())
            tgt.setContext(convertReference(src.getContext()));
        for (org.hl7.fhir.r5.model.StringType t : src.getContextLinkId()) tgt.getContextLinkId().add(convertString(t));
        if (src.hasOccurrence())
            tgt.setOccurrence(convertType(src.getOccurrence()));
        for (org.hl7.fhir.r5.model.Reference t : src.getRequester()) tgt.addRequester(convertReference(t));
        for (org.hl7.fhir.r5.model.StringType t : src.getRequesterLinkId()) tgt.getRequesterLinkId().add(convertString(t));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getPerformerType()) tgt.addPerformerType(convertCodeableConcept(t));
        if (src.hasPerformerRole())
            tgt.setPerformerRole(convertCodeableConcept(src.getPerformerRole()));
        if (src.hasPerformer())
            tgt.setPerformer(convertReference(src.getPerformer()));
        for (org.hl7.fhir.r5.model.StringType t : src.getPerformerLinkId()) tgt.getPerformerLinkId().add(convertString(t));
        for (CodeableReference t : src.getReason()) if (t.hasConcept())
            tgt.addReasonCode(convertCodeableConcept(t.getConcept()));
        for (CodeableReference t : src.getReason()) if (t.hasReference())
            tgt.addReasonReference(convertReference(t.getReference()));
        for (org.hl7.fhir.r5.model.StringType t : src.getReasonLinkId()) tgt.getReason().add(convertString(t));
        for (org.hl7.fhir.r5.model.StringType t : src.getReasonLinkId()) tgt.getReasonLinkId().add(convertString(t));
        for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.addNote(convertAnnotation(t));
        for (org.hl7.fhir.r5.model.UnsignedIntType t : src.getSecurityLabelNumber()) tgt.getSecurityLabelNumber().add(convertUnsignedInt(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Contract.ActionSubjectComponent convertActionSubjectComponent(org.hl7.fhir.r4.model.Contract.ActionSubjectComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Contract.ActionSubjectComponent tgt = new org.hl7.fhir.r5.model.Contract.ActionSubjectComponent();
        copyElement(src, tgt);
        for (org.hl7.fhir.r4.model.Reference t : src.getReference()) tgt.addReference(convertReference(t));
        if (src.hasRole())
            tgt.setRole(convertCodeableConcept(src.getRole()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Contract.ActionSubjectComponent convertActionSubjectComponent(org.hl7.fhir.r5.model.Contract.ActionSubjectComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Contract.ActionSubjectComponent tgt = new org.hl7.fhir.r4.model.Contract.ActionSubjectComponent();
        copyElement(src, tgt);
        for (org.hl7.fhir.r5.model.Reference t : src.getReference()) tgt.addReference(convertReference(t));
        if (src.hasRole())
            tgt.setRole(convertCodeableConcept(src.getRole()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Contract.SignatoryComponent convertSignatoryComponent(org.hl7.fhir.r4.model.Contract.SignatoryComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Contract.SignatoryComponent tgt = new org.hl7.fhir.r5.model.Contract.SignatoryComponent();
        copyElement(src, tgt);
        if (src.hasType())
            tgt.setType(convertCoding(src.getType()));
        if (src.hasParty())
            tgt.setParty(convertReference(src.getParty()));
        for (org.hl7.fhir.r4.model.Signature t : src.getSignature()) tgt.addSignature(convertSignature(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Contract.SignatoryComponent convertSignatoryComponent(org.hl7.fhir.r5.model.Contract.SignatoryComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Contract.SignatoryComponent tgt = new org.hl7.fhir.r4.model.Contract.SignatoryComponent();
        copyElement(src, tgt);
        if (src.hasType())
            tgt.setType(convertCoding(src.getType()));
        if (src.hasParty())
            tgt.setParty(convertReference(src.getParty()));
        for (org.hl7.fhir.r5.model.Signature t : src.getSignature()) tgt.addSignature(convertSignature(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Contract.FriendlyLanguageComponent convertFriendlyLanguageComponent(org.hl7.fhir.r4.model.Contract.FriendlyLanguageComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Contract.FriendlyLanguageComponent tgt = new org.hl7.fhir.r5.model.Contract.FriendlyLanguageComponent();
        copyElement(src, tgt);
        if (src.hasContent())
            tgt.setContent(convertType(src.getContent()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Contract.FriendlyLanguageComponent convertFriendlyLanguageComponent(org.hl7.fhir.r5.model.Contract.FriendlyLanguageComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Contract.FriendlyLanguageComponent tgt = new org.hl7.fhir.r4.model.Contract.FriendlyLanguageComponent();
        copyElement(src, tgt);
        if (src.hasContent())
            tgt.setContent(convertType(src.getContent()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Contract.LegalLanguageComponent convertLegalLanguageComponent(org.hl7.fhir.r4.model.Contract.LegalLanguageComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Contract.LegalLanguageComponent tgt = new org.hl7.fhir.r5.model.Contract.LegalLanguageComponent();
        copyElement(src, tgt);
        if (src.hasContent())
            tgt.setContent(convertType(src.getContent()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Contract.LegalLanguageComponent convertLegalLanguageComponent(org.hl7.fhir.r5.model.Contract.LegalLanguageComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Contract.LegalLanguageComponent tgt = new org.hl7.fhir.r4.model.Contract.LegalLanguageComponent();
        copyElement(src, tgt);
        if (src.hasContent())
            tgt.setContent(convertType(src.getContent()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Contract.ComputableLanguageComponent convertComputableLanguageComponent(org.hl7.fhir.r4.model.Contract.ComputableLanguageComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Contract.ComputableLanguageComponent tgt = new org.hl7.fhir.r5.model.Contract.ComputableLanguageComponent();
        copyElement(src, tgt);
        if (src.hasContent())
            tgt.setContent(convertType(src.getContent()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Contract.ComputableLanguageComponent convertComputableLanguageComponent(org.hl7.fhir.r5.model.Contract.ComputableLanguageComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Contract.ComputableLanguageComponent tgt = new org.hl7.fhir.r4.model.Contract.ComputableLanguageComponent();
        copyElement(src, tgt);
        if (src.hasContent())
            tgt.setContent(convertType(src.getContent()));
        return tgt;
    }
}