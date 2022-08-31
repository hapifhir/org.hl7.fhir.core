package org.hl7.fhir.convertors.conv43_50.resources43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.*;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.*;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.special43_50.Reference43_50;
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
public class Contract43_50 {

  public static org.hl7.fhir.r5.model.Contract convertContract(org.hl7.fhir.r4b.model.Contract src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Contract tgt = new org.hl7.fhir.r5.model.Contract();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    if (src.hasUrl())
      tgt.setUrlElement(Uri43_50.convertUri(src.getUrlElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String43_50.convertString(src.getVersionElement()));
    if (src.hasStatus())
      tgt.setStatusElement(convertContractStatus(src.getStatusElement()));
    if (src.hasLegalState())
      tgt.setLegalState(CodeableConcept43_50.convertCodeableConcept(src.getLegalState()));
    if (src.hasInstantiatesCanonical())
      tgt.setInstantiatesCanonical(Reference43_50.convertReference(src.getInstantiatesCanonical()));
    if (src.hasInstantiatesUri())
      tgt.setInstantiatesUriElement(Uri43_50.convertUri(src.getInstantiatesUriElement()));
    if (src.hasContentDerivative())
      tgt.setContentDerivative(CodeableConcept43_50.convertCodeableConcept(src.getContentDerivative()));
    if (src.hasIssued())
      tgt.setIssuedElement(DateTime43_50.convertDateTime(src.getIssuedElement()));
    if (src.hasApplies())
      tgt.setApplies(Period43_50.convertPeriod(src.getApplies()));
    if (src.hasExpirationType())
      tgt.setExpirationType(CodeableConcept43_50.convertCodeableConcept(src.getExpirationType()));
    for (org.hl7.fhir.r4b.model.Reference t : src.getSubject()) tgt.addSubject(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getAuthority()) tgt.addAuthority(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getDomain()) tgt.addDomain(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getSite()) tgt.addSite(Reference43_50.convertReference(t));
    if (src.hasName())
      tgt.setNameElement(String43_50.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String43_50.convertString(src.getTitleElement()));
    if (src.hasSubtitle())
      tgt.setSubtitleElement(String43_50.convertString(src.getSubtitleElement()));
    for (org.hl7.fhir.r4b.model.StringType t : src.getAlias()) tgt.getAlias().add(String43_50.convertString(t));
    if (src.hasAuthor())
      tgt.setAuthor(Reference43_50.convertReference(src.getAuthor()));
    if (src.hasScope())
      tgt.setScope(CodeableConcept43_50.convertCodeableConcept(src.getScope()));
    if (src.hasTopic())
      tgt.setTopic(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getTopic()));
    if (src.hasType())
      tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getSubType())
      tgt.addSubType(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasContentDefinition())
      tgt.setContentDefinition(convertContentDefinitionComponent(src.getContentDefinition()));
    for (org.hl7.fhir.r4b.model.Contract.TermComponent t : src.getTerm()) tgt.addTerm(convertTermComponent(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getSupportingInfo())
      tgt.addSupportingInfo(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getRelevantHistory())
      tgt.addRelevantHistory(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r4b.model.Contract.SignatoryComponent t : src.getSigner())
      tgt.addSigner(convertSignatoryComponent(t));
    for (org.hl7.fhir.r4b.model.Contract.FriendlyLanguageComponent t : src.getFriendly())
      tgt.addFriendly(convertFriendlyLanguageComponent(t));
    for (org.hl7.fhir.r4b.model.Contract.LegalLanguageComponent t : src.getLegal())
      tgt.addLegal(convertLegalLanguageComponent(t));
    for (org.hl7.fhir.r4b.model.Contract.ComputableLanguageComponent t : src.getRule())
      tgt.addRule(convertComputableLanguageComponent(t));
    if (src.hasLegallyBinding())
      tgt.setLegallyBinding(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getLegallyBinding()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Contract convertContract(org.hl7.fhir.r5.model.Contract src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Contract tgt = new org.hl7.fhir.r4b.model.Contract();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    if (src.hasUrl())
      tgt.setUrlElement(Uri43_50.convertUri(src.getUrlElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String43_50.convertString(src.getVersionElement()));
    if (src.hasStatus())
      tgt.setStatusElement(convertContractStatus(src.getStatusElement()));
    if (src.hasLegalState())
      tgt.setLegalState(CodeableConcept43_50.convertCodeableConcept(src.getLegalState()));
    if (src.hasInstantiatesCanonical())
      tgt.setInstantiatesCanonical(Reference43_50.convertReference(src.getInstantiatesCanonical()));
    if (src.hasInstantiatesUri())
      tgt.setInstantiatesUriElement(Uri43_50.convertUri(src.getInstantiatesUriElement()));
    if (src.hasContentDerivative())
      tgt.setContentDerivative(CodeableConcept43_50.convertCodeableConcept(src.getContentDerivative()));
    if (src.hasIssued())
      tgt.setIssuedElement(DateTime43_50.convertDateTime(src.getIssuedElement()));
    if (src.hasApplies())
      tgt.setApplies(Period43_50.convertPeriod(src.getApplies()));
    if (src.hasExpirationType())
      tgt.setExpirationType(CodeableConcept43_50.convertCodeableConcept(src.getExpirationType()));
    for (org.hl7.fhir.r5.model.Reference t : src.getSubject()) tgt.addSubject(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getAuthority()) tgt.addAuthority(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getDomain()) tgt.addDomain(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getSite()) tgt.addSite(Reference43_50.convertReference(t));
    if (src.hasName())
      tgt.setNameElement(String43_50.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String43_50.convertString(src.getTitleElement()));
    if (src.hasSubtitle())
      tgt.setSubtitleElement(String43_50.convertString(src.getSubtitleElement()));
    for (org.hl7.fhir.r5.model.StringType t : src.getAlias()) tgt.getAlias().add(String43_50.convertString(t));
    if (src.hasAuthor())
      tgt.setAuthor(Reference43_50.convertReference(src.getAuthor()));
    if (src.hasScope())
      tgt.setScope(CodeableConcept43_50.convertCodeableConcept(src.getScope()));
    if (src.hasTopic())
      tgt.setTopic(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getTopic()));
    if (src.hasType())
      tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getSubType())
      tgt.addSubType(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasContentDefinition())
      tgt.setContentDefinition(convertContentDefinitionComponent(src.getContentDefinition()));
    for (org.hl7.fhir.r5.model.Contract.TermComponent t : src.getTerm()) tgt.addTerm(convertTermComponent(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getSupportingInfo())
      tgt.addSupportingInfo(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getRelevantHistory())
      tgt.addRelevantHistory(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r5.model.Contract.SignatoryComponent t : src.getSigner())
      tgt.addSigner(convertSignatoryComponent(t));
    for (org.hl7.fhir.r5.model.Contract.FriendlyLanguageComponent t : src.getFriendly())
      tgt.addFriendly(convertFriendlyLanguageComponent(t));
    for (org.hl7.fhir.r5.model.Contract.LegalLanguageComponent t : src.getLegal())
      tgt.addLegal(convertLegalLanguageComponent(t));
    for (org.hl7.fhir.r5.model.Contract.ComputableLanguageComponent t : src.getRule())
      tgt.addRule(convertComputableLanguageComponent(t));
    if (src.hasLegallyBinding())
      tgt.setLegallyBinding(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getLegallyBinding()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Contract.ContractResourceStatusCodes> convertContractStatus(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Contract.ContractResourceStatusCodes> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Contract.ContractResourceStatusCodes> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Contract.ContractResourceStatusCodesEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
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

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Contract.ContractResourceStatusCodes> convertContractStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Contract.ContractResourceStatusCodes> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Contract.ContractResourceStatusCodes> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Contract.ContractResourceStatusCodesEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case AMENDED:
        tgt.setValue(org.hl7.fhir.r4b.model.Contract.ContractResourceStatusCodes.AMENDED);
        break;
      case APPENDED:
        tgt.setValue(org.hl7.fhir.r4b.model.Contract.ContractResourceStatusCodes.APPENDED);
        break;
      case CANCELLED:
        tgt.setValue(org.hl7.fhir.r4b.model.Contract.ContractResourceStatusCodes.CANCELLED);
        break;
      case DISPUTED:
        tgt.setValue(org.hl7.fhir.r4b.model.Contract.ContractResourceStatusCodes.DISPUTED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r4b.model.Contract.ContractResourceStatusCodes.ENTEREDINERROR);
        break;
      case EXECUTABLE:
        tgt.setValue(org.hl7.fhir.r4b.model.Contract.ContractResourceStatusCodes.EXECUTABLE);
        break;
      case EXECUTED:
        tgt.setValue(org.hl7.fhir.r4b.model.Contract.ContractResourceStatusCodes.EXECUTED);
        break;
      case NEGOTIABLE:
        tgt.setValue(org.hl7.fhir.r4b.model.Contract.ContractResourceStatusCodes.NEGOTIABLE);
        break;
      case OFFERED:
        tgt.setValue(org.hl7.fhir.r4b.model.Contract.ContractResourceStatusCodes.OFFERED);
        break;
      case POLICY:
        tgt.setValue(org.hl7.fhir.r4b.model.Contract.ContractResourceStatusCodes.POLICY);
        break;
      case REJECTED:
        tgt.setValue(org.hl7.fhir.r4b.model.Contract.ContractResourceStatusCodes.REJECTED);
        break;
      case RENEWED:
        tgt.setValue(org.hl7.fhir.r4b.model.Contract.ContractResourceStatusCodes.RENEWED);
        break;
      case REVOKED:
        tgt.setValue(org.hl7.fhir.r4b.model.Contract.ContractResourceStatusCodes.REVOKED);
        break;
      case RESOLVED:
        tgt.setValue(org.hl7.fhir.r4b.model.Contract.ContractResourceStatusCodes.RESOLVED);
        break;
      case TERMINATED:
        tgt.setValue(org.hl7.fhir.r4b.model.Contract.ContractResourceStatusCodes.TERMINATED);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.Contract.ContractResourceStatusCodes.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Contract.ContentDefinitionComponent convertContentDefinitionComponent(org.hl7.fhir.r4b.model.Contract.ContentDefinitionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Contract.ContentDefinitionComponent tgt = new org.hl7.fhir.r5.model.Contract.ContentDefinitionComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
    if (src.hasSubType())
      tgt.setSubType(CodeableConcept43_50.convertCodeableConcept(src.getSubType()));
    if (src.hasPublisher())
      tgt.setPublisher(Reference43_50.convertReference(src.getPublisher()));
    if (src.hasPublicationDate())
      tgt.setPublicationDateElement(DateTime43_50.convertDateTime(src.getPublicationDateElement()));
    if (src.hasPublicationStatus())
      tgt.setPublicationStatusElement(convertContractPublicationStatus(src.getPublicationStatusElement()));
    if (src.hasCopyright())
      tgt.setCopyrightElement(MarkDown43_50.convertMarkdown(src.getCopyrightElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Contract.ContentDefinitionComponent convertContentDefinitionComponent(org.hl7.fhir.r5.model.Contract.ContentDefinitionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Contract.ContentDefinitionComponent tgt = new org.hl7.fhir.r4b.model.Contract.ContentDefinitionComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
    if (src.hasSubType())
      tgt.setSubType(CodeableConcept43_50.convertCodeableConcept(src.getSubType()));
    if (src.hasPublisher())
      tgt.setPublisher(Reference43_50.convertReference(src.getPublisher()));
    if (src.hasPublicationDate())
      tgt.setPublicationDateElement(DateTime43_50.convertDateTime(src.getPublicationDateElement()));
    if (src.hasPublicationStatus())
      tgt.setPublicationStatusElement(convertContractPublicationStatus(src.getPublicationStatusElement()));
    if (src.hasCopyright())
      tgt.setCopyrightElement(MarkDown43_50.convertMarkdown(src.getCopyrightElement()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Contract.ContractResourcePublicationStatusCodes> convertContractPublicationStatus(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Contract.ContractResourcePublicationStatusCodes> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Contract.ContractResourcePublicationStatusCodes> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Contract.ContractResourcePublicationStatusCodesEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
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

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Contract.ContractResourcePublicationStatusCodes> convertContractPublicationStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Contract.ContractResourcePublicationStatusCodes> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Contract.ContractResourcePublicationStatusCodes> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Contract.ContractResourcePublicationStatusCodesEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case AMENDED:
        tgt.setValue(org.hl7.fhir.r4b.model.Contract.ContractResourcePublicationStatusCodes.AMENDED);
        break;
      case APPENDED:
        tgt.setValue(org.hl7.fhir.r4b.model.Contract.ContractResourcePublicationStatusCodes.APPENDED);
        break;
      case CANCELLED:
        tgt.setValue(org.hl7.fhir.r4b.model.Contract.ContractResourcePublicationStatusCodes.CANCELLED);
        break;
      case DISPUTED:
        tgt.setValue(org.hl7.fhir.r4b.model.Contract.ContractResourcePublicationStatusCodes.DISPUTED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r4b.model.Contract.ContractResourcePublicationStatusCodes.ENTEREDINERROR);
        break;
      case EXECUTABLE:
        tgt.setValue(org.hl7.fhir.r4b.model.Contract.ContractResourcePublicationStatusCodes.EXECUTABLE);
        break;
      case EXECUTED:
        tgt.setValue(org.hl7.fhir.r4b.model.Contract.ContractResourcePublicationStatusCodes.EXECUTED);
        break;
      case NEGOTIABLE:
        tgt.setValue(org.hl7.fhir.r4b.model.Contract.ContractResourcePublicationStatusCodes.NEGOTIABLE);
        break;
      case OFFERED:
        tgt.setValue(org.hl7.fhir.r4b.model.Contract.ContractResourcePublicationStatusCodes.OFFERED);
        break;
      case POLICY:
        tgt.setValue(org.hl7.fhir.r4b.model.Contract.ContractResourcePublicationStatusCodes.POLICY);
        break;
      case REJECTED:
        tgt.setValue(org.hl7.fhir.r4b.model.Contract.ContractResourcePublicationStatusCodes.REJECTED);
        break;
      case RENEWED:
        tgt.setValue(org.hl7.fhir.r4b.model.Contract.ContractResourcePublicationStatusCodes.RENEWED);
        break;
      case REVOKED:
        tgt.setValue(org.hl7.fhir.r4b.model.Contract.ContractResourcePublicationStatusCodes.REVOKED);
        break;
      case RESOLVED:
        tgt.setValue(org.hl7.fhir.r4b.model.Contract.ContractResourcePublicationStatusCodes.RESOLVED);
        break;
      case TERMINATED:
        tgt.setValue(org.hl7.fhir.r4b.model.Contract.ContractResourcePublicationStatusCodes.TERMINATED);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.Contract.ContractResourcePublicationStatusCodes.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Contract.TermComponent convertTermComponent(org.hl7.fhir.r4b.model.Contract.TermComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Contract.TermComponent tgt = new org.hl7.fhir.r5.model.Contract.TermComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier43_50.convertIdentifier(src.getIdentifier()));
    if (src.hasIssued())
      tgt.setIssuedElement(DateTime43_50.convertDateTime(src.getIssuedElement()));
    if (src.hasApplies())
      tgt.setApplies(Period43_50.convertPeriod(src.getApplies()));
    if (src.hasTopic())
      tgt.setTopic(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getTopic()));
    if (src.hasType())
      tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
    if (src.hasSubType())
      tgt.setSubType(CodeableConcept43_50.convertCodeableConcept(src.getSubType()));
    if (src.hasText())
      tgt.setTextElement(String43_50.convertString(src.getTextElement()));
    for (org.hl7.fhir.r4b.model.Contract.SecurityLabelComponent t : src.getSecurityLabel())
      tgt.addSecurityLabel(convertSecurityLabelComponent(t));
    if (src.hasOffer())
      tgt.setOffer(convertContractOfferComponent(src.getOffer()));
    for (org.hl7.fhir.r4b.model.Contract.ContractAssetComponent t : src.getAsset())
      tgt.addAsset(convertContractAssetComponent(t));
    for (org.hl7.fhir.r4b.model.Contract.ActionComponent t : src.getAction()) tgt.addAction(convertActionComponent(t));
    for (org.hl7.fhir.r4b.model.Contract.TermComponent t : src.getGroup()) tgt.addGroup(convertTermComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Contract.TermComponent convertTermComponent(org.hl7.fhir.r5.model.Contract.TermComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Contract.TermComponent tgt = new org.hl7.fhir.r4b.model.Contract.TermComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier43_50.convertIdentifier(src.getIdentifier()));
    if (src.hasIssued())
      tgt.setIssuedElement(DateTime43_50.convertDateTime(src.getIssuedElement()));
    if (src.hasApplies())
      tgt.setApplies(Period43_50.convertPeriod(src.getApplies()));
    if (src.hasTopic())
      tgt.setTopic(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getTopic()));
    if (src.hasType())
      tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
    if (src.hasSubType())
      tgt.setSubType(CodeableConcept43_50.convertCodeableConcept(src.getSubType()));
    if (src.hasText())
      tgt.setTextElement(String43_50.convertString(src.getTextElement()));
    for (org.hl7.fhir.r5.model.Contract.SecurityLabelComponent t : src.getSecurityLabel())
      tgt.addSecurityLabel(convertSecurityLabelComponent(t));
    if (src.hasOffer())
      tgt.setOffer(convertContractOfferComponent(src.getOffer()));
    for (org.hl7.fhir.r5.model.Contract.ContractAssetComponent t : src.getAsset())
      tgt.addAsset(convertContractAssetComponent(t));
    for (org.hl7.fhir.r5.model.Contract.ActionComponent t : src.getAction()) tgt.addAction(convertActionComponent(t));
    for (org.hl7.fhir.r5.model.Contract.TermComponent t : src.getGroup()) tgt.addGroup(convertTermComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Contract.SecurityLabelComponent convertSecurityLabelComponent(org.hl7.fhir.r4b.model.Contract.SecurityLabelComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Contract.SecurityLabelComponent tgt = new org.hl7.fhir.r5.model.Contract.SecurityLabelComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r4b.model.UnsignedIntType t : src.getNumber())
      tgt.getNumber().add(UnsignedInt43_50.convertUnsignedInt(t));
    if (src.hasClassification())
      tgt.setClassification(Coding43_50.convertCoding(src.getClassification()));
    for (org.hl7.fhir.r4b.model.Coding t : src.getCategory()) tgt.addCategory(Coding43_50.convertCoding(t));
    for (org.hl7.fhir.r4b.model.Coding t : src.getControl()) tgt.addControl(Coding43_50.convertCoding(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Contract.SecurityLabelComponent convertSecurityLabelComponent(org.hl7.fhir.r5.model.Contract.SecurityLabelComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Contract.SecurityLabelComponent tgt = new org.hl7.fhir.r4b.model.Contract.SecurityLabelComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r5.model.UnsignedIntType t : src.getNumber())
      tgt.getNumber().add(UnsignedInt43_50.convertUnsignedInt(t));
    if (src.hasClassification())
      tgt.setClassification(Coding43_50.convertCoding(src.getClassification()));
    for (org.hl7.fhir.r5.model.Coding t : src.getCategory()) tgt.addCategory(Coding43_50.convertCoding(t));
    for (org.hl7.fhir.r5.model.Coding t : src.getControl()) tgt.addControl(Coding43_50.convertCoding(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Contract.ContractOfferComponent convertContractOfferComponent(org.hl7.fhir.r4b.model.Contract.ContractOfferComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Contract.ContractOfferComponent tgt = new org.hl7.fhir.r5.model.Contract.ContractOfferComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    for (org.hl7.fhir.r4b.model.Contract.ContractPartyComponent t : src.getParty())
      tgt.addParty(convertContractPartyComponent(t));
    if (src.hasTopic())
      tgt.setTopic(Reference43_50.convertReference(src.getTopic()));
    if (src.hasType())
      tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
    if (src.hasDecision())
      tgt.setDecision(CodeableConcept43_50.convertCodeableConcept(src.getDecision()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getDecisionMode())
      tgt.addDecisionMode(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r4b.model.Contract.AnswerComponent t : src.getAnswer()) tgt.addAnswer(convertAnswerComponent(t));
    if (src.hasText())
      tgt.setTextElement(String43_50.convertString(src.getTextElement()));
    for (org.hl7.fhir.r4b.model.StringType t : src.getLinkId()) tgt.getLinkId().add(String43_50.convertString(t));
    for (org.hl7.fhir.r4b.model.UnsignedIntType t : src.getSecurityLabelNumber())
      tgt.getSecurityLabelNumber().add(UnsignedInt43_50.convertUnsignedInt(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Contract.ContractOfferComponent convertContractOfferComponent(org.hl7.fhir.r5.model.Contract.ContractOfferComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Contract.ContractOfferComponent tgt = new org.hl7.fhir.r4b.model.Contract.ContractOfferComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    for (org.hl7.fhir.r5.model.Contract.ContractPartyComponent t : src.getParty())
      tgt.addParty(convertContractPartyComponent(t));
    if (src.hasTopic())
      tgt.setTopic(Reference43_50.convertReference(src.getTopic()));
    if (src.hasType())
      tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
    if (src.hasDecision())
      tgt.setDecision(CodeableConcept43_50.convertCodeableConcept(src.getDecision()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getDecisionMode())
      tgt.addDecisionMode(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.Contract.AnswerComponent t : src.getAnswer()) tgt.addAnswer(convertAnswerComponent(t));
    if (src.hasText())
      tgt.setTextElement(String43_50.convertString(src.getTextElement()));
    for (org.hl7.fhir.r5.model.StringType t : src.getLinkId()) tgt.getLinkId().add(String43_50.convertString(t));
    for (org.hl7.fhir.r5.model.UnsignedIntType t : src.getSecurityLabelNumber())
      tgt.getSecurityLabelNumber().add(UnsignedInt43_50.convertUnsignedInt(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Contract.ContractPartyComponent convertContractPartyComponent(org.hl7.fhir.r4b.model.Contract.ContractPartyComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Contract.ContractPartyComponent tgt = new org.hl7.fhir.r5.model.Contract.ContractPartyComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r4b.model.Reference t : src.getReference()) tgt.addReference(Reference43_50.convertReference(t));
    if (src.hasRole())
      tgt.setRole(CodeableConcept43_50.convertCodeableConcept(src.getRole()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Contract.ContractPartyComponent convertContractPartyComponent(org.hl7.fhir.r5.model.Contract.ContractPartyComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Contract.ContractPartyComponent tgt = new org.hl7.fhir.r4b.model.Contract.ContractPartyComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r5.model.Reference t : src.getReference()) tgt.addReference(Reference43_50.convertReference(t));
    if (src.hasRole())
      tgt.setRole(CodeableConcept43_50.convertCodeableConcept(src.getRole()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Contract.AnswerComponent convertAnswerComponent(org.hl7.fhir.r4b.model.Contract.AnswerComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Contract.AnswerComponent tgt = new org.hl7.fhir.r5.model.Contract.AnswerComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasValue())
      tgt.setValue(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getValue()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Contract.AnswerComponent convertAnswerComponent(org.hl7.fhir.r5.model.Contract.AnswerComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Contract.AnswerComponent tgt = new org.hl7.fhir.r4b.model.Contract.AnswerComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasValue())
      tgt.setValue(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getValue()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Contract.ContractAssetComponent convertContractAssetComponent(org.hl7.fhir.r4b.model.Contract.ContractAssetComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Contract.ContractAssetComponent tgt = new org.hl7.fhir.r5.model.Contract.ContractAssetComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasScope())
      tgt.setScope(CodeableConcept43_50.convertCodeableConcept(src.getScope()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getType())
      tgt.addType(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getTypeReference())
      tgt.addTypeReference(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getSubtype())
      tgt.addSubtype(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasRelationship())
      tgt.setRelationship(Coding43_50.convertCoding(src.getRelationship()));
    for (org.hl7.fhir.r4b.model.Contract.AssetContextComponent t : src.getContext())
      tgt.addContext(convertAssetContextComponent(t));
    if (src.hasCondition())
      tgt.setConditionElement(String43_50.convertString(src.getConditionElement()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getPeriodType())
      tgt.addPeriodType(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r4b.model.Period t : src.getPeriod()) tgt.addPeriod(Period43_50.convertPeriod(t));
    for (org.hl7.fhir.r4b.model.Period t : src.getUsePeriod()) tgt.addUsePeriod(Period43_50.convertPeriod(t));
    if (src.hasText())
      tgt.setTextElement(String43_50.convertString(src.getTextElement()));
    for (org.hl7.fhir.r4b.model.StringType t : src.getLinkId()) tgt.getLinkId().add(String43_50.convertString(t));
    for (org.hl7.fhir.r4b.model.Contract.AnswerComponent t : src.getAnswer()) tgt.addAnswer(convertAnswerComponent(t));
    for (org.hl7.fhir.r4b.model.UnsignedIntType t : src.getSecurityLabelNumber())
      tgt.getSecurityLabelNumber().add(UnsignedInt43_50.convertUnsignedInt(t));
    for (org.hl7.fhir.r4b.model.Contract.ValuedItemComponent t : src.getValuedItem())
      tgt.addValuedItem(convertValuedItemComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Contract.ContractAssetComponent convertContractAssetComponent(org.hl7.fhir.r5.model.Contract.ContractAssetComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Contract.ContractAssetComponent tgt = new org.hl7.fhir.r4b.model.Contract.ContractAssetComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasScope())
      tgt.setScope(CodeableConcept43_50.convertCodeableConcept(src.getScope()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getType())
      tgt.addType(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getTypeReference())
      tgt.addTypeReference(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getSubtype())
      tgt.addSubtype(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasRelationship())
      tgt.setRelationship(Coding43_50.convertCoding(src.getRelationship()));
    for (org.hl7.fhir.r5.model.Contract.AssetContextComponent t : src.getContext())
      tgt.addContext(convertAssetContextComponent(t));
    if (src.hasCondition())
      tgt.setConditionElement(String43_50.convertString(src.getConditionElement()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getPeriodType())
      tgt.addPeriodType(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.Period t : src.getPeriod()) tgt.addPeriod(Period43_50.convertPeriod(t));
    for (org.hl7.fhir.r5.model.Period t : src.getUsePeriod()) tgt.addUsePeriod(Period43_50.convertPeriod(t));
    if (src.hasText())
      tgt.setTextElement(String43_50.convertString(src.getTextElement()));
    for (org.hl7.fhir.r5.model.StringType t : src.getLinkId()) tgt.getLinkId().add(String43_50.convertString(t));
    for (org.hl7.fhir.r5.model.Contract.AnswerComponent t : src.getAnswer()) tgt.addAnswer(convertAnswerComponent(t));
    for (org.hl7.fhir.r5.model.UnsignedIntType t : src.getSecurityLabelNumber())
      tgt.getSecurityLabelNumber().add(UnsignedInt43_50.convertUnsignedInt(t));
    for (org.hl7.fhir.r5.model.Contract.ValuedItemComponent t : src.getValuedItem())
      tgt.addValuedItem(convertValuedItemComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Contract.AssetContextComponent convertAssetContextComponent(org.hl7.fhir.r4b.model.Contract.AssetContextComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Contract.AssetContextComponent tgt = new org.hl7.fhir.r5.model.Contract.AssetContextComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasReference())
      tgt.setReference(Reference43_50.convertReference(src.getReference()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getCode())
      tgt.addCode(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasText())
      tgt.setTextElement(String43_50.convertString(src.getTextElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Contract.AssetContextComponent convertAssetContextComponent(org.hl7.fhir.r5.model.Contract.AssetContextComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Contract.AssetContextComponent tgt = new org.hl7.fhir.r4b.model.Contract.AssetContextComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasReference())
      tgt.setReference(Reference43_50.convertReference(src.getReference()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCode())
      tgt.addCode(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasText())
      tgt.setTextElement(String43_50.convertString(src.getTextElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Contract.ValuedItemComponent convertValuedItemComponent(org.hl7.fhir.r4b.model.Contract.ValuedItemComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Contract.ValuedItemComponent tgt = new org.hl7.fhir.r5.model.Contract.ValuedItemComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasEntity())
      tgt.setEntity(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getEntity()));
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier43_50.convertIdentifier(src.getIdentifier()));
    if (src.hasEffectiveTime())
      tgt.setEffectiveTimeElement(DateTime43_50.convertDateTime(src.getEffectiveTimeElement()));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity43_50.convertSimpleQuantity(src.getQuantity()));
    if (src.hasUnitPrice())
      tgt.setUnitPrice(Money43_50.convertMoney(src.getUnitPrice()));
    if (src.hasFactor())
      tgt.setFactorElement(Decimal43_50.convertDecimal(src.getFactorElement()));
    if (src.hasPoints())
      tgt.setPointsElement(Decimal43_50.convertDecimal(src.getPointsElement()));
    if (src.hasNet())
      tgt.setNet(Money43_50.convertMoney(src.getNet()));
    if (src.hasPayment())
      tgt.setPaymentElement(String43_50.convertString(src.getPaymentElement()));
    if (src.hasPaymentDate())
      tgt.setPaymentDateElement(DateTime43_50.convertDateTime(src.getPaymentDateElement()));
    if (src.hasResponsible())
      tgt.setResponsible(Reference43_50.convertReference(src.getResponsible()));
    if (src.hasRecipient())
      tgt.setRecipient(Reference43_50.convertReference(src.getRecipient()));
    for (org.hl7.fhir.r4b.model.StringType t : src.getLinkId()) tgt.getLinkId().add(String43_50.convertString(t));
    for (org.hl7.fhir.r4b.model.UnsignedIntType t : src.getSecurityLabelNumber())
      tgt.getSecurityLabelNumber().add(UnsignedInt43_50.convertUnsignedInt(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Contract.ValuedItemComponent convertValuedItemComponent(org.hl7.fhir.r5.model.Contract.ValuedItemComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Contract.ValuedItemComponent tgt = new org.hl7.fhir.r4b.model.Contract.ValuedItemComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasEntity())
      tgt.setEntity(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getEntity()));
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier43_50.convertIdentifier(src.getIdentifier()));
    if (src.hasEffectiveTime())
      tgt.setEffectiveTimeElement(DateTime43_50.convertDateTime(src.getEffectiveTimeElement()));
    if (src.hasQuantity())
      tgt.setQuantity(SimpleQuantity43_50.convertSimpleQuantity(src.getQuantity()));
    if (src.hasUnitPrice())
      tgt.setUnitPrice(Money43_50.convertMoney(src.getUnitPrice()));
    if (src.hasFactor())
      tgt.setFactorElement(Decimal43_50.convertDecimal(src.getFactorElement()));
    if (src.hasPoints())
      tgt.setPointsElement(Decimal43_50.convertDecimal(src.getPointsElement()));
    if (src.hasNet())
      tgt.setNet(Money43_50.convertMoney(src.getNet()));
    if (src.hasPayment())
      tgt.setPaymentElement(String43_50.convertString(src.getPaymentElement()));
    if (src.hasPaymentDate())
      tgt.setPaymentDateElement(DateTime43_50.convertDateTime(src.getPaymentDateElement()));
    if (src.hasResponsible())
      tgt.setResponsible(Reference43_50.convertReference(src.getResponsible()));
    if (src.hasRecipient())
      tgt.setRecipient(Reference43_50.convertReference(src.getRecipient()));
    for (org.hl7.fhir.r5.model.StringType t : src.getLinkId()) tgt.getLinkId().add(String43_50.convertString(t));
    for (org.hl7.fhir.r5.model.UnsignedIntType t : src.getSecurityLabelNumber())
      tgt.getSecurityLabelNumber().add(UnsignedInt43_50.convertUnsignedInt(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Contract.ActionComponent convertActionComponent(org.hl7.fhir.r4b.model.Contract.ActionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Contract.ActionComponent tgt = new org.hl7.fhir.r5.model.Contract.ActionComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasDoNotPerform())
      tgt.setDoNotPerformElement(Boolean43_50.convertBoolean(src.getDoNotPerformElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
    for (org.hl7.fhir.r4b.model.Contract.ActionSubjectComponent t : src.getSubject())
      tgt.addSubject(convertActionSubjectComponent(t));
    if (src.hasIntent())
      tgt.setIntent(CodeableConcept43_50.convertCodeableConcept(src.getIntent()));
    for (org.hl7.fhir.r4b.model.StringType t : src.getLinkId()) tgt.getLinkId().add(String43_50.convertString(t));
    if (src.hasStatus())
      tgt.setStatus(CodeableConcept43_50.convertCodeableConcept(src.getStatus()));
    if (src.hasContext())
      tgt.setContext(Reference43_50.convertReference(src.getContext()));
    for (org.hl7.fhir.r4b.model.StringType t : src.getContextLinkId())
      tgt.getContextLinkId().add(String43_50.convertString(t));
    if (src.hasOccurrence())
      tgt.setOccurrence(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getOccurrence()));
    for (org.hl7.fhir.r4b.model.Reference t : src.getRequester()) tgt.addRequester(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r4b.model.StringType t : src.getRequesterLinkId())
      tgt.getRequesterLinkId().add(String43_50.convertString(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getPerformerType())
      tgt.addPerformerType(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasPerformerRole())
      tgt.setPerformerRole(CodeableConcept43_50.convertCodeableConcept(src.getPerformerRole()));
    if (src.hasPerformer())
      tgt.setPerformer(Reference43_50.convertReference(src.getPerformer()));
    for (org.hl7.fhir.r4b.model.StringType t : src.getPerformerLinkId())
      tgt.getPerformerLinkId().add(String43_50.convertString(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getReasonCode())
      tgt.addReason(CodeableConcept43_50.convertCodeableConceptToCodeableReference(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getReasonReference())
      tgt.addReason(Reference43_50.convertReferenceToCodeableReference(t));
    for (org.hl7.fhir.r4b.model.StringType t : src.getReasonLinkId())
      tgt.getReasonLinkId().add(String43_50.convertString(t));
    for (org.hl7.fhir.r4b.model.Annotation t : src.getNote()) tgt.addNote(Annotation43_50.convertAnnotation(t));
    for (org.hl7.fhir.r4b.model.UnsignedIntType t : src.getSecurityLabelNumber())
      tgt.getSecurityLabelNumber().add(UnsignedInt43_50.convertUnsignedInt(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Contract.ActionComponent convertActionComponent(org.hl7.fhir.r5.model.Contract.ActionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Contract.ActionComponent tgt = new org.hl7.fhir.r4b.model.Contract.ActionComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasDoNotPerform())
      tgt.setDoNotPerformElement(Boolean43_50.convertBoolean(src.getDoNotPerformElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
    for (org.hl7.fhir.r5.model.Contract.ActionSubjectComponent t : src.getSubject())
      tgt.addSubject(convertActionSubjectComponent(t));
    if (src.hasIntent())
      tgt.setIntent(CodeableConcept43_50.convertCodeableConcept(src.getIntent()));
    for (org.hl7.fhir.r5.model.StringType t : src.getLinkId()) tgt.getLinkId().add(String43_50.convertString(t));
    if (src.hasStatus())
      tgt.setStatus(CodeableConcept43_50.convertCodeableConcept(src.getStatus()));
    if (src.hasContext())
      tgt.setContext(Reference43_50.convertReference(src.getContext()));
    for (org.hl7.fhir.r5.model.StringType t : src.getContextLinkId())
      tgt.getContextLinkId().add(String43_50.convertString(t));
    if (src.hasOccurrence())
      tgt.setOccurrence(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getOccurrence()));
    for (org.hl7.fhir.r5.model.Reference t : src.getRequester()) tgt.addRequester(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r5.model.StringType t : src.getRequesterLinkId())
      tgt.getRequesterLinkId().add(String43_50.convertString(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getPerformerType())
      tgt.addPerformerType(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasPerformerRole())
      tgt.setPerformerRole(CodeableConcept43_50.convertCodeableConcept(src.getPerformerRole()));
    if (src.hasPerformer())
      tgt.setPerformer(Reference43_50.convertReference(src.getPerformer()));
    for (org.hl7.fhir.r5.model.StringType t : src.getPerformerLinkId())
      tgt.getPerformerLinkId().add(String43_50.convertString(t));
    for (CodeableReference t : src.getReason())
      if (t.hasConcept())
        tgt.addReasonCode(CodeableConcept43_50.convertCodeableConcept(t.getConcept()));
    for (CodeableReference t : src.getReason())
      if (t.hasReference())
        tgt.addReasonReference(Reference43_50.convertReference(t.getReference()));
    for (org.hl7.fhir.r5.model.StringType t : src.getReasonLinkId()) tgt.getReason().add(String43_50.convertString(t));
    for (org.hl7.fhir.r5.model.StringType t : src.getReasonLinkId())
      tgt.getReasonLinkId().add(String43_50.convertString(t));
    for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.addNote(Annotation43_50.convertAnnotation(t));
    for (org.hl7.fhir.r5.model.UnsignedIntType t : src.getSecurityLabelNumber())
      tgt.getSecurityLabelNumber().add(UnsignedInt43_50.convertUnsignedInt(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Contract.ActionSubjectComponent convertActionSubjectComponent(org.hl7.fhir.r4b.model.Contract.ActionSubjectComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Contract.ActionSubjectComponent tgt = new org.hl7.fhir.r5.model.Contract.ActionSubjectComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r4b.model.Reference t : src.getReference()) tgt.addReference(Reference43_50.convertReference(t));
    if (src.hasRole())
      tgt.setRole(CodeableConcept43_50.convertCodeableConcept(src.getRole()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Contract.ActionSubjectComponent convertActionSubjectComponent(org.hl7.fhir.r5.model.Contract.ActionSubjectComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Contract.ActionSubjectComponent tgt = new org.hl7.fhir.r4b.model.Contract.ActionSubjectComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r5.model.Reference t : src.getReference()) tgt.addReference(Reference43_50.convertReference(t));
    if (src.hasRole())
      tgt.setRole(CodeableConcept43_50.convertCodeableConcept(src.getRole()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Contract.SignatoryComponent convertSignatoryComponent(org.hl7.fhir.r4b.model.Contract.SignatoryComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Contract.SignatoryComponent tgt = new org.hl7.fhir.r5.model.Contract.SignatoryComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(Coding43_50.convertCoding(src.getType()));
    if (src.hasParty())
      tgt.setParty(Reference43_50.convertReference(src.getParty()));
    for (org.hl7.fhir.r4b.model.Signature t : src.getSignature()) tgt.addSignature(Signature43_50.convertSignature(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Contract.SignatoryComponent convertSignatoryComponent(org.hl7.fhir.r5.model.Contract.SignatoryComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Contract.SignatoryComponent tgt = new org.hl7.fhir.r4b.model.Contract.SignatoryComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(Coding43_50.convertCoding(src.getType()));
    if (src.hasParty())
      tgt.setParty(Reference43_50.convertReference(src.getParty()));
    for (org.hl7.fhir.r5.model.Signature t : src.getSignature()) tgt.addSignature(Signature43_50.convertSignature(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Contract.FriendlyLanguageComponent convertFriendlyLanguageComponent(org.hl7.fhir.r4b.model.Contract.FriendlyLanguageComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Contract.FriendlyLanguageComponent tgt = new org.hl7.fhir.r5.model.Contract.FriendlyLanguageComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasContent())
      tgt.setContent(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getContent()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Contract.FriendlyLanguageComponent convertFriendlyLanguageComponent(org.hl7.fhir.r5.model.Contract.FriendlyLanguageComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Contract.FriendlyLanguageComponent tgt = new org.hl7.fhir.r4b.model.Contract.FriendlyLanguageComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasContent())
      tgt.setContent(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getContent()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Contract.LegalLanguageComponent convertLegalLanguageComponent(org.hl7.fhir.r4b.model.Contract.LegalLanguageComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Contract.LegalLanguageComponent tgt = new org.hl7.fhir.r5.model.Contract.LegalLanguageComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasContent())
      tgt.setContent(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getContent()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Contract.LegalLanguageComponent convertLegalLanguageComponent(org.hl7.fhir.r5.model.Contract.LegalLanguageComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Contract.LegalLanguageComponent tgt = new org.hl7.fhir.r4b.model.Contract.LegalLanguageComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasContent())
      tgt.setContent(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getContent()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Contract.ComputableLanguageComponent convertComputableLanguageComponent(org.hl7.fhir.r4b.model.Contract.ComputableLanguageComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Contract.ComputableLanguageComponent tgt = new org.hl7.fhir.r5.model.Contract.ComputableLanguageComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasContent())
      tgt.setContent(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getContent()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Contract.ComputableLanguageComponent convertComputableLanguageComponent(org.hl7.fhir.r5.model.Contract.ComputableLanguageComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Contract.ComputableLanguageComponent tgt = new org.hl7.fhir.r4b.model.Contract.ComputableLanguageComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasContent())
      tgt.setContent(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getContent()));
    return tgt;
  }
}