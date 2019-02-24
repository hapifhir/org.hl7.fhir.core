package org.hl7.fhir.convertors.conv40_50;

import org.hl7.fhir.exceptions.FHIRException;

import org.hl7.fhir.convertors.VersionConvertor_40_50;


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


public class CapabilityStatement extends VersionConvertor_40_50 {

  public static org.hl7.fhir.r5.model.CapabilityStatement convertCapabilityStatement(org.hl7.fhir.r4.model.CapabilityStatement src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.CapabilityStatement tgt = new org.hl7.fhir.r5.model.CapabilityStatement();
    copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(convertUri(src.getUrlElement()));
    if (src.hasVersion())
      tgt.setVersionElement(convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(convertString(src.getTitleElement()));
    if (src.hasStatus())
      tgt.setStatus(Enumerations.convertPublicationStatus(src.getStatus()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(convertBoolean(src.getExperimentalElement()));
    if (src.hasDate())
      tgt.setDateElement(convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(convertString(src.getPublisherElement()));
    for (org.hl7.fhir.r4.model.ContactDetail t : src.getContact())
      tgt.addContact(convertContactDetail(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r4.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(convertUsageContext(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(convertCodeableConcept(t));
    if (src.hasPurpose())
      tgt.setPurposeElement(convertMarkdown(src.getPurposeElement()));
    if (src.hasCopyright())
      tgt.setCopyrightElement(convertMarkdown(src.getCopyrightElement()));
    if (src.hasKind())
      tgt.setKind(convertCapabilityStatementKind(src.getKind()));
    for (org.hl7.fhir.r4.model.CanonicalType t : src.getInstantiates())
      tgt.getInstantiates().add(convertCanonical(t));
    for (org.hl7.fhir.r4.model.CanonicalType t : src.getImports())
      tgt.getImports().add(convertCanonical(t));
    if (src.hasSoftware())
      tgt.setSoftware(convertCapabilityStatementSoftwareComponent(src.getSoftware()));
    if (src.hasImplementation())
      tgt.setImplementation(convertCapabilityStatementImplementationComponent(src.getImplementation()));
    if (src.hasFhirVersion())
      tgt.setFhirVersion(Enumerations.convertFHIRVersion(src.getFhirVersion()));
    for (org.hl7.fhir.r4.model.CodeType t : src.getFormat())
      tgt.getFormat().add(convertCode(t));
    for (org.hl7.fhir.r4.model.CodeType t : src.getPatchFormat())
      tgt.getPatchFormat().add(convertCode(t));
    for (org.hl7.fhir.r4.model.CanonicalType t : src.getImplementationGuide())
      tgt.getImplementationGuide().add(convertCanonical(t));
    for (org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestComponent t : src.getRest())
      tgt.addRest(convertCapabilityStatementRestComponent(t));
    for (org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementMessagingComponent t : src.getMessaging())
      tgt.addMessaging(convertCapabilityStatementMessagingComponent(t));
    for (org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementDocumentComponent t : src.getDocument())
      tgt.addDocument(convertCapabilityStatementDocumentComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CapabilityStatement convertCapabilityStatement(org.hl7.fhir.r5.model.CapabilityStatement src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.CapabilityStatement tgt = new org.hl7.fhir.r4.model.CapabilityStatement();
    copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(convertUri(src.getUrlElement()));
    if (src.hasVersion())
      tgt.setVersionElement(convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(convertString(src.getTitleElement()));
    if (src.hasStatus())
      tgt.setStatus(Enumerations.convertPublicationStatus(src.getStatus()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(convertBoolean(src.getExperimentalElement()));
    if (src.hasDate())
      tgt.setDateElement(convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(convertString(src.getPublisherElement()));
    for (org.hl7.fhir.r5.model.ContactDetail t : src.getContact())
      tgt.addContact(convertContactDetail(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r5.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(convertUsageContext(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(convertCodeableConcept(t));
    if (src.hasPurpose())
      tgt.setPurposeElement(convertMarkdown(src.getPurposeElement()));
    if (src.hasCopyright())
      tgt.setCopyrightElement(convertMarkdown(src.getCopyrightElement()));
    if (src.hasKind())
      tgt.setKind(convertCapabilityStatementKind(src.getKind()));
    for (org.hl7.fhir.r5.model.CanonicalType t : src.getInstantiates())
      tgt.getInstantiates().add(convertCanonical(t));
    for (org.hl7.fhir.r5.model.CanonicalType t : src.getImports())
      tgt.getImports().add(convertCanonical(t));
    if (src.hasSoftware())
      tgt.setSoftware(convertCapabilityStatementSoftwareComponent(src.getSoftware()));
    if (src.hasImplementation())
      tgt.setImplementation(convertCapabilityStatementImplementationComponent(src.getImplementation()));
    if (src.hasFhirVersion())
      tgt.setFhirVersion(Enumerations.convertFHIRVersion(src.getFhirVersion()));
    for (org.hl7.fhir.r5.model.CodeType t : src.getFormat())
      tgt.getFormat().add(convertCode(t));
    for (org.hl7.fhir.r5.model.CodeType t : src.getPatchFormat())
      tgt.getPatchFormat().add(convertCode(t));
    for (org.hl7.fhir.r5.model.CanonicalType t : src.getImplementationGuide())
      tgt.getImplementationGuide().add(convertCanonical(t));
    for (org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestComponent t : src.getRest())
      tgt.addRest(convertCapabilityStatementRestComponent(t));
    for (org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementMessagingComponent t : src.getMessaging())
      tgt.addMessaging(convertCapabilityStatementMessagingComponent(t));
    for (org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementDocumentComponent t : src.getDocument())
      tgt.addDocument(convertCapabilityStatementDocumentComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementKind convertCapabilityStatementKind(org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementKind src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case INSTANCE: return org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementKind.INSTANCE;
    case CAPABILITY: return org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementKind.CAPABILITY;
    case REQUIREMENTS: return org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementKind.REQUIREMENTS;
    default: return org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementKind.NULL;
  }
}

  public static org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementKind convertCapabilityStatementKind(org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementKind src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case INSTANCE: return org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementKind.INSTANCE;
    case CAPABILITY: return org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementKind.CAPABILITY;
    case REQUIREMENTS: return org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementKind.REQUIREMENTS;
    default: return org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementKind.NULL;
  }
}

  public static org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementSoftwareComponent convertCapabilityStatementSoftwareComponent(org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementSoftwareComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementSoftwareComponent tgt = new org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementSoftwareComponent();
    copyElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(convertString(src.getNameElement()));
    if (src.hasVersion())
      tgt.setVersionElement(convertString(src.getVersionElement()));
    if (src.hasReleaseDate())
      tgt.setReleaseDateElement(convertDateTime(src.getReleaseDateElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementSoftwareComponent convertCapabilityStatementSoftwareComponent(org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementSoftwareComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementSoftwareComponent tgt = new org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementSoftwareComponent();
    copyElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(convertString(src.getNameElement()));
    if (src.hasVersion())
      tgt.setVersionElement(convertString(src.getVersionElement()));
    if (src.hasReleaseDate())
      tgt.setReleaseDateElement(convertDateTime(src.getReleaseDateElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementImplementationComponent convertCapabilityStatementImplementationComponent(org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementImplementationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementImplementationComponent tgt = new org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementImplementationComponent();
    copyElement(src, tgt);
    if (src.hasDescription())
      tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
    if (src.hasUrl())
      tgt.setUrlElement(convertUrl(src.getUrlElement()));
    if (src.hasCustodian())
      tgt.setCustodian(convertReference(src.getCustodian()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementImplementationComponent convertCapabilityStatementImplementationComponent(org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementImplementationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementImplementationComponent tgt = new org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementImplementationComponent();
    copyElement(src, tgt);
    if (src.hasDescription())
      tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
    if (src.hasUrl())
      tgt.setUrlElement(convertUrl(src.getUrlElement()));
    if (src.hasCustodian())
      tgt.setCustodian(convertReference(src.getCustodian()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestComponent convertCapabilityStatementRestComponent(org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestComponent tgt = new org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestComponent();
    copyElement(src, tgt);
    if (src.hasMode())
      tgt.setMode(convertRestfulCapabilityMode(src.getMode()));
    if (src.hasDocumentation())
      tgt.setDocumentationElement(convertMarkdown(src.getDocumentationElement()));
    if (src.hasSecurity())
      tgt.setSecurity(convertCapabilityStatementRestSecurityComponent(src.getSecurity()));
    for (org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestResourceComponent t : src.getResource())
      tgt.addResource(convertCapabilityStatementRestResourceComponent(t));
    for (org.hl7.fhir.r4.model.CapabilityStatement.SystemInteractionComponent t : src.getInteraction())
      tgt.addInteraction(convertSystemInteractionComponent(t));
    for (org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent t : src.getSearchParam())
      tgt.addSearchParam(convertCapabilityStatementRestResourceSearchParamComponent(t));
    for (org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestResourceOperationComponent t : src.getOperation())
      tgt.addOperation(convertCapabilityStatementRestResourceOperationComponent(t));
    for (org.hl7.fhir.r4.model.CanonicalType t : src.getCompartment())
      tgt.getCompartment().add(convertCanonical(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestComponent convertCapabilityStatementRestComponent(org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestComponent tgt = new org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestComponent();
    copyElement(src, tgt);
    if (src.hasMode())
      tgt.setMode(convertRestfulCapabilityMode(src.getMode()));
    if (src.hasDocumentation())
      tgt.setDocumentationElement(convertMarkdown(src.getDocumentationElement()));
    if (src.hasSecurity())
      tgt.setSecurity(convertCapabilityStatementRestSecurityComponent(src.getSecurity()));
    for (org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestResourceComponent t : src.getResource())
      tgt.addResource(convertCapabilityStatementRestResourceComponent(t));
    for (org.hl7.fhir.r5.model.CapabilityStatement.SystemInteractionComponent t : src.getInteraction())
      tgt.addInteraction(convertSystemInteractionComponent(t));
    for (org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent t : src.getSearchParam())
      tgt.addSearchParam(convertCapabilityStatementRestResourceSearchParamComponent(t));
    for (org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestResourceOperationComponent t : src.getOperation())
      tgt.addOperation(convertCapabilityStatementRestResourceOperationComponent(t));
    for (org.hl7.fhir.r5.model.CanonicalType t : src.getCompartment())
      tgt.getCompartment().add(convertCanonical(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.CapabilityStatement.RestfulCapabilityMode convertRestfulCapabilityMode(org.hl7.fhir.r4.model.CapabilityStatement.RestfulCapabilityMode src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case CLIENT: return org.hl7.fhir.r5.model.CapabilityStatement.RestfulCapabilityMode.CLIENT;
    case SERVER: return org.hl7.fhir.r5.model.CapabilityStatement.RestfulCapabilityMode.SERVER;
    default: return org.hl7.fhir.r5.model.CapabilityStatement.RestfulCapabilityMode.NULL;
  }
}

  public static org.hl7.fhir.r4.model.CapabilityStatement.RestfulCapabilityMode convertRestfulCapabilityMode(org.hl7.fhir.r5.model.CapabilityStatement.RestfulCapabilityMode src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case CLIENT: return org.hl7.fhir.r4.model.CapabilityStatement.RestfulCapabilityMode.CLIENT;
    case SERVER: return org.hl7.fhir.r4.model.CapabilityStatement.RestfulCapabilityMode.SERVER;
    default: return org.hl7.fhir.r4.model.CapabilityStatement.RestfulCapabilityMode.NULL;
  }
}

  public static org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestSecurityComponent convertCapabilityStatementRestSecurityComponent(org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestSecurityComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestSecurityComponent tgt = new org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestSecurityComponent();
    copyElement(src, tgt);
    if (src.hasCors())
      tgt.setCorsElement(convertBoolean(src.getCorsElement()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getService())
      tgt.addService(convertCodeableConcept(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(convertMarkdown(src.getDescriptionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestSecurityComponent convertCapabilityStatementRestSecurityComponent(org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestSecurityComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestSecurityComponent tgt = new org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestSecurityComponent();
    copyElement(src, tgt);
    if (src.hasCors())
      tgt.setCorsElement(convertBoolean(src.getCorsElement()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getService())
      tgt.addService(convertCodeableConcept(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(convertMarkdown(src.getDescriptionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestResourceComponent convertCapabilityStatementRestResourceComponent(org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestResourceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestResourceComponent tgt = new org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestResourceComponent();
    copyElement(src, tgt);
    if (src.hasType())
      tgt.setTypeElement(convertCode(src.getTypeElement()));
    if (src.hasProfile())
      tgt.setProfileElement(convertCanonical(src.getProfileElement()));
    for (org.hl7.fhir.r4.model.CanonicalType t : src.getSupportedProfile())
      tgt.getSupportedProfile().add(convertCanonical(t));
    if (src.hasDocumentation())
      tgt.setDocumentationElement(convertMarkdown(src.getDocumentationElement()));
    for (org.hl7.fhir.r4.model.CapabilityStatement.ResourceInteractionComponent t : src.getInteraction())
      tgt.addInteraction(convertResourceInteractionComponent(t));
    if (src.hasVersioning())
      tgt.setVersioning(convertResourceVersionPolicy(src.getVersioning()));
    if (src.hasReadHistory())
      tgt.setReadHistoryElement(convertBoolean(src.getReadHistoryElement()));
    if (src.hasUpdateCreate())
      tgt.setUpdateCreateElement(convertBoolean(src.getUpdateCreateElement()));
    if (src.hasConditionalCreate())
      tgt.setConditionalCreateElement(convertBoolean(src.getConditionalCreateElement()));
    if (src.hasConditionalRead())
      tgt.setConditionalRead(convertConditionalReadStatus(src.getConditionalRead()));
    if (src.hasConditionalUpdate())
      tgt.setConditionalUpdateElement(convertBoolean(src.getConditionalUpdateElement()));
    if (src.hasConditionalDelete())
      tgt.setConditionalDelete(convertConditionalDeleteStatus(src.getConditionalDelete()));
    for (org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CapabilityStatement.ReferenceHandlingPolicy> t : src.getReferencePolicy())
      tgt.addReferencePolicy(convertReferenceHandlingPolicy(t.getValue()));
    for (org.hl7.fhir.r4.model.StringType t : src.getSearchInclude())
      tgt.getSearchInclude().add(convertString(t));
    for (org.hl7.fhir.r4.model.StringType t : src.getSearchRevInclude())
      tgt.getSearchRevInclude().add(convertString(t));
    for (org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent t : src.getSearchParam())
      tgt.addSearchParam(convertCapabilityStatementRestResourceSearchParamComponent(t));
    for (org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestResourceOperationComponent t : src.getOperation())
      tgt.addOperation(convertCapabilityStatementRestResourceOperationComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestResourceComponent convertCapabilityStatementRestResourceComponent(org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestResourceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestResourceComponent tgt = new org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestResourceComponent();
    copyElement(src, tgt);
    if (src.hasType())
      tgt.setTypeElement(convertCode(src.getTypeElement()));
    if (src.hasProfile())
      tgt.setProfileElement(convertCanonical(src.getProfileElement()));
    for (org.hl7.fhir.r5.model.CanonicalType t : src.getSupportedProfile())
      tgt.getSupportedProfile().add(convertCanonical(t));
    if (src.hasDocumentation())
      tgt.setDocumentationElement(convertMarkdown(src.getDocumentationElement()));
    for (org.hl7.fhir.r5.model.CapabilityStatement.ResourceInteractionComponent t : src.getInteraction())
      tgt.addInteraction(convertResourceInteractionComponent(t));
    if (src.hasVersioning())
      tgt.setVersioning(convertResourceVersionPolicy(src.getVersioning()));
    if (src.hasReadHistory())
      tgt.setReadHistoryElement(convertBoolean(src.getReadHistoryElement()));
    if (src.hasUpdateCreate())
      tgt.setUpdateCreateElement(convertBoolean(src.getUpdateCreateElement()));
    if (src.hasConditionalCreate())
      tgt.setConditionalCreateElement(convertBoolean(src.getConditionalCreateElement()));
    if (src.hasConditionalRead())
      tgt.setConditionalRead(convertConditionalReadStatus(src.getConditionalRead()));
    if (src.hasConditionalUpdate())
      tgt.setConditionalUpdateElement(convertBoolean(src.getConditionalUpdateElement()));
    if (src.hasConditionalDelete())
      tgt.setConditionalDelete(convertConditionalDeleteStatus(src.getConditionalDelete()));
    for (org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CapabilityStatement.ReferenceHandlingPolicy> t : src.getReferencePolicy())
      tgt.addReferencePolicy(convertReferenceHandlingPolicy(t.getValue()));
    for (org.hl7.fhir.r5.model.StringType t : src.getSearchInclude())
      tgt.getSearchInclude().add(convertString(t));
    for (org.hl7.fhir.r5.model.StringType t : src.getSearchRevInclude())
      tgt.getSearchRevInclude().add(convertString(t));
    for (org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent t : src.getSearchParam())
      tgt.addSearchParam(convertCapabilityStatementRestResourceSearchParamComponent(t));
    for (org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestResourceOperationComponent t : src.getOperation())
      tgt.addOperation(convertCapabilityStatementRestResourceOperationComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.CapabilityStatement.ResourceVersionPolicy convertResourceVersionPolicy(org.hl7.fhir.r4.model.CapabilityStatement.ResourceVersionPolicy src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case NOVERSION: return org.hl7.fhir.r5.model.CapabilityStatement.ResourceVersionPolicy.NOVERSION;
    case VERSIONED: return org.hl7.fhir.r5.model.CapabilityStatement.ResourceVersionPolicy.VERSIONED;
    case VERSIONEDUPDATE: return org.hl7.fhir.r5.model.CapabilityStatement.ResourceVersionPolicy.VERSIONEDUPDATE;
    default: return org.hl7.fhir.r5.model.CapabilityStatement.ResourceVersionPolicy.NULL;
  }
}

  public static org.hl7.fhir.r4.model.CapabilityStatement.ResourceVersionPolicy convertResourceVersionPolicy(org.hl7.fhir.r5.model.CapabilityStatement.ResourceVersionPolicy src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case NOVERSION: return org.hl7.fhir.r4.model.CapabilityStatement.ResourceVersionPolicy.NOVERSION;
    case VERSIONED: return org.hl7.fhir.r4.model.CapabilityStatement.ResourceVersionPolicy.VERSIONED;
    case VERSIONEDUPDATE: return org.hl7.fhir.r4.model.CapabilityStatement.ResourceVersionPolicy.VERSIONEDUPDATE;
    default: return org.hl7.fhir.r4.model.CapabilityStatement.ResourceVersionPolicy.NULL;
  }
}

  public static org.hl7.fhir.r5.model.CapabilityStatement.ConditionalReadStatus convertConditionalReadStatus(org.hl7.fhir.r4.model.CapabilityStatement.ConditionalReadStatus src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case NOTSUPPORTED: return org.hl7.fhir.r5.model.CapabilityStatement.ConditionalReadStatus.NOTSUPPORTED;
    case MODIFIEDSINCE: return org.hl7.fhir.r5.model.CapabilityStatement.ConditionalReadStatus.MODIFIEDSINCE;
    case NOTMATCH: return org.hl7.fhir.r5.model.CapabilityStatement.ConditionalReadStatus.NOTMATCH;
    case FULLSUPPORT: return org.hl7.fhir.r5.model.CapabilityStatement.ConditionalReadStatus.FULLSUPPORT;
    default: return org.hl7.fhir.r5.model.CapabilityStatement.ConditionalReadStatus.NULL;
  }
}

  public static org.hl7.fhir.r4.model.CapabilityStatement.ConditionalReadStatus convertConditionalReadStatus(org.hl7.fhir.r5.model.CapabilityStatement.ConditionalReadStatus src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case NOTSUPPORTED: return org.hl7.fhir.r4.model.CapabilityStatement.ConditionalReadStatus.NOTSUPPORTED;
    case MODIFIEDSINCE: return org.hl7.fhir.r4.model.CapabilityStatement.ConditionalReadStatus.MODIFIEDSINCE;
    case NOTMATCH: return org.hl7.fhir.r4.model.CapabilityStatement.ConditionalReadStatus.NOTMATCH;
    case FULLSUPPORT: return org.hl7.fhir.r4.model.CapabilityStatement.ConditionalReadStatus.FULLSUPPORT;
    default: return org.hl7.fhir.r4.model.CapabilityStatement.ConditionalReadStatus.NULL;
  }
}

  public static org.hl7.fhir.r5.model.CapabilityStatement.ConditionalDeleteStatus convertConditionalDeleteStatus(org.hl7.fhir.r4.model.CapabilityStatement.ConditionalDeleteStatus src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case NOTSUPPORTED: return org.hl7.fhir.r5.model.CapabilityStatement.ConditionalDeleteStatus.NOTSUPPORTED;
    case SINGLE: return org.hl7.fhir.r5.model.CapabilityStatement.ConditionalDeleteStatus.SINGLE;
    case MULTIPLE: return org.hl7.fhir.r5.model.CapabilityStatement.ConditionalDeleteStatus.MULTIPLE;
    default: return org.hl7.fhir.r5.model.CapabilityStatement.ConditionalDeleteStatus.NULL;
  }
}

  public static org.hl7.fhir.r4.model.CapabilityStatement.ConditionalDeleteStatus convertConditionalDeleteStatus(org.hl7.fhir.r5.model.CapabilityStatement.ConditionalDeleteStatus src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case NOTSUPPORTED: return org.hl7.fhir.r4.model.CapabilityStatement.ConditionalDeleteStatus.NOTSUPPORTED;
    case SINGLE: return org.hl7.fhir.r4.model.CapabilityStatement.ConditionalDeleteStatus.SINGLE;
    case MULTIPLE: return org.hl7.fhir.r4.model.CapabilityStatement.ConditionalDeleteStatus.MULTIPLE;
    default: return org.hl7.fhir.r4.model.CapabilityStatement.ConditionalDeleteStatus.NULL;
  }
}

  public static org.hl7.fhir.r5.model.CapabilityStatement.ReferenceHandlingPolicy convertReferenceHandlingPolicy(org.hl7.fhir.r4.model.CapabilityStatement.ReferenceHandlingPolicy src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case LITERAL: return org.hl7.fhir.r5.model.CapabilityStatement.ReferenceHandlingPolicy.LITERAL;
    case LOGICAL: return org.hl7.fhir.r5.model.CapabilityStatement.ReferenceHandlingPolicy.LOGICAL;
    case RESOLVES: return org.hl7.fhir.r5.model.CapabilityStatement.ReferenceHandlingPolicy.RESOLVES;
    case ENFORCED: return org.hl7.fhir.r5.model.CapabilityStatement.ReferenceHandlingPolicy.ENFORCED;
    case LOCAL: return org.hl7.fhir.r5.model.CapabilityStatement.ReferenceHandlingPolicy.LOCAL;
    default: return org.hl7.fhir.r5.model.CapabilityStatement.ReferenceHandlingPolicy.NULL;
  }
}

  public static org.hl7.fhir.r4.model.CapabilityStatement.ReferenceHandlingPolicy convertReferenceHandlingPolicy(org.hl7.fhir.r5.model.CapabilityStatement.ReferenceHandlingPolicy src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case LITERAL: return org.hl7.fhir.r4.model.CapabilityStatement.ReferenceHandlingPolicy.LITERAL;
    case LOGICAL: return org.hl7.fhir.r4.model.CapabilityStatement.ReferenceHandlingPolicy.LOGICAL;
    case RESOLVES: return org.hl7.fhir.r4.model.CapabilityStatement.ReferenceHandlingPolicy.RESOLVES;
    case ENFORCED: return org.hl7.fhir.r4.model.CapabilityStatement.ReferenceHandlingPolicy.ENFORCED;
    case LOCAL: return org.hl7.fhir.r4.model.CapabilityStatement.ReferenceHandlingPolicy.LOCAL;
    default: return org.hl7.fhir.r4.model.CapabilityStatement.ReferenceHandlingPolicy.NULL;
  }
}

  public static org.hl7.fhir.r5.model.CapabilityStatement.ResourceInteractionComponent convertResourceInteractionComponent(org.hl7.fhir.r4.model.CapabilityStatement.ResourceInteractionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.CapabilityStatement.ResourceInteractionComponent tgt = new org.hl7.fhir.r5.model.CapabilityStatement.ResourceInteractionComponent();
    copyElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(convertTypeRestfulInteraction(src.getCode()));
    if (src.hasDocumentation())
      tgt.setDocumentationElement(convertMarkdown(src.getDocumentationElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CapabilityStatement.ResourceInteractionComponent convertResourceInteractionComponent(org.hl7.fhir.r5.model.CapabilityStatement.ResourceInteractionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.CapabilityStatement.ResourceInteractionComponent tgt = new org.hl7.fhir.r4.model.CapabilityStatement.ResourceInteractionComponent();
    copyElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(convertTypeRestfulInteraction(src.getCode()));
    if (src.hasDocumentation())
      tgt.setDocumentationElement(convertMarkdown(src.getDocumentationElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.CapabilityStatement.TypeRestfulInteraction convertTypeRestfulInteraction(org.hl7.fhir.r4.model.CapabilityStatement.TypeRestfulInteraction src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case READ: return org.hl7.fhir.r5.model.CapabilityStatement.TypeRestfulInteraction.READ;
    case VREAD: return org.hl7.fhir.r5.model.CapabilityStatement.TypeRestfulInteraction.VREAD;
    case UPDATE: return org.hl7.fhir.r5.model.CapabilityStatement.TypeRestfulInteraction.UPDATE;
    case PATCH: return org.hl7.fhir.r5.model.CapabilityStatement.TypeRestfulInteraction.PATCH;
    case DELETE: return org.hl7.fhir.r5.model.CapabilityStatement.TypeRestfulInteraction.DELETE;
    case HISTORYINSTANCE: return org.hl7.fhir.r5.model.CapabilityStatement.TypeRestfulInteraction.HISTORYINSTANCE;
    case HISTORYTYPE: return org.hl7.fhir.r5.model.CapabilityStatement.TypeRestfulInteraction.HISTORYTYPE;
    case CREATE: return org.hl7.fhir.r5.model.CapabilityStatement.TypeRestfulInteraction.CREATE;
    case SEARCHTYPE: return org.hl7.fhir.r5.model.CapabilityStatement.TypeRestfulInteraction.SEARCHTYPE;
    default: return org.hl7.fhir.r5.model.CapabilityStatement.TypeRestfulInteraction.NULL;
  }
}

  public static org.hl7.fhir.r4.model.CapabilityStatement.TypeRestfulInteraction convertTypeRestfulInteraction(org.hl7.fhir.r5.model.CapabilityStatement.TypeRestfulInteraction src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case READ: return org.hl7.fhir.r4.model.CapabilityStatement.TypeRestfulInteraction.READ;
    case VREAD: return org.hl7.fhir.r4.model.CapabilityStatement.TypeRestfulInteraction.VREAD;
    case UPDATE: return org.hl7.fhir.r4.model.CapabilityStatement.TypeRestfulInteraction.UPDATE;
    case PATCH: return org.hl7.fhir.r4.model.CapabilityStatement.TypeRestfulInteraction.PATCH;
    case DELETE: return org.hl7.fhir.r4.model.CapabilityStatement.TypeRestfulInteraction.DELETE;
    case HISTORYINSTANCE: return org.hl7.fhir.r4.model.CapabilityStatement.TypeRestfulInteraction.HISTORYINSTANCE;
    case HISTORYTYPE: return org.hl7.fhir.r4.model.CapabilityStatement.TypeRestfulInteraction.HISTORYTYPE;
    case CREATE: return org.hl7.fhir.r4.model.CapabilityStatement.TypeRestfulInteraction.CREATE;
    case SEARCHTYPE: return org.hl7.fhir.r4.model.CapabilityStatement.TypeRestfulInteraction.SEARCHTYPE;
    default: return org.hl7.fhir.r4.model.CapabilityStatement.TypeRestfulInteraction.NULL;
  }
}

  public static org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent convertCapabilityStatementRestResourceSearchParamComponent(org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent tgt = new org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent();
    copyElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(convertString(src.getNameElement()));
    if (src.hasDefinition())
      tgt.setDefinitionElement(convertCanonical(src.getDefinitionElement()));
    if (src.hasType())
      tgt.setType(Enumerations.convertSearchParamType(src.getType()));
    if (src.hasDocumentation())
      tgt.setDocumentationElement(convertMarkdown(src.getDocumentationElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent convertCapabilityStatementRestResourceSearchParamComponent(org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent tgt = new org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent();
    copyElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(convertString(src.getNameElement()));
    if (src.hasDefinition())
      tgt.setDefinitionElement(convertCanonical(src.getDefinitionElement()));
    if (src.hasType())
      tgt.setType(Enumerations.convertSearchParamType(src.getType()));
    if (src.hasDocumentation())
      tgt.setDocumentationElement(convertMarkdown(src.getDocumentationElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestResourceOperationComponent convertCapabilityStatementRestResourceOperationComponent(org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestResourceOperationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestResourceOperationComponent tgt = new org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestResourceOperationComponent();
    copyElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(convertString(src.getNameElement()));
    if (src.hasDefinition())
      tgt.setDefinitionElement(convertCanonical(src.getDefinitionElement()));
    if (src.hasDocumentation())
      tgt.setDocumentationElement(convertMarkdown(src.getDocumentationElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestResourceOperationComponent convertCapabilityStatementRestResourceOperationComponent(org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestResourceOperationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestResourceOperationComponent tgt = new org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestResourceOperationComponent();
    copyElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(convertString(src.getNameElement()));
    if (src.hasDefinition())
      tgt.setDefinitionElement(convertCanonical(src.getDefinitionElement()));
    if (src.hasDocumentation())
      tgt.setDocumentationElement(convertMarkdown(src.getDocumentationElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.CapabilityStatement.SystemInteractionComponent convertSystemInteractionComponent(org.hl7.fhir.r4.model.CapabilityStatement.SystemInteractionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.CapabilityStatement.SystemInteractionComponent tgt = new org.hl7.fhir.r5.model.CapabilityStatement.SystemInteractionComponent();
    copyElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(convertSystemRestfulInteraction(src.getCode()));
    if (src.hasDocumentation())
      tgt.setDocumentationElement(convertMarkdown(src.getDocumentationElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CapabilityStatement.SystemInteractionComponent convertSystemInteractionComponent(org.hl7.fhir.r5.model.CapabilityStatement.SystemInteractionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.CapabilityStatement.SystemInteractionComponent tgt = new org.hl7.fhir.r4.model.CapabilityStatement.SystemInteractionComponent();
    copyElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(convertSystemRestfulInteraction(src.getCode()));
    if (src.hasDocumentation())
      tgt.setDocumentationElement(convertMarkdown(src.getDocumentationElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.CapabilityStatement.SystemRestfulInteraction convertSystemRestfulInteraction(org.hl7.fhir.r4.model.CapabilityStatement.SystemRestfulInteraction src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case TRANSACTION: return org.hl7.fhir.r5.model.CapabilityStatement.SystemRestfulInteraction.TRANSACTION;
    case BATCH: return org.hl7.fhir.r5.model.CapabilityStatement.SystemRestfulInteraction.BATCH;
    case SEARCHSYSTEM: return org.hl7.fhir.r5.model.CapabilityStatement.SystemRestfulInteraction.SEARCHSYSTEM;
    case HISTORYSYSTEM: return org.hl7.fhir.r5.model.CapabilityStatement.SystemRestfulInteraction.HISTORYSYSTEM;
    default: return org.hl7.fhir.r5.model.CapabilityStatement.SystemRestfulInteraction.NULL;
  }
}

  public static org.hl7.fhir.r4.model.CapabilityStatement.SystemRestfulInteraction convertSystemRestfulInteraction(org.hl7.fhir.r5.model.CapabilityStatement.SystemRestfulInteraction src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case TRANSACTION: return org.hl7.fhir.r4.model.CapabilityStatement.SystemRestfulInteraction.TRANSACTION;
    case BATCH: return org.hl7.fhir.r4.model.CapabilityStatement.SystemRestfulInteraction.BATCH;
    case SEARCHSYSTEM: return org.hl7.fhir.r4.model.CapabilityStatement.SystemRestfulInteraction.SEARCHSYSTEM;
    case HISTORYSYSTEM: return org.hl7.fhir.r4.model.CapabilityStatement.SystemRestfulInteraction.HISTORYSYSTEM;
    default: return org.hl7.fhir.r4.model.CapabilityStatement.SystemRestfulInteraction.NULL;
  }
}

  public static org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementMessagingComponent convertCapabilityStatementMessagingComponent(org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementMessagingComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementMessagingComponent tgt = new org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementMessagingComponent();
    copyElement(src, tgt);
    for (org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementMessagingEndpointComponent t : src.getEndpoint())
      tgt.addEndpoint(convertCapabilityStatementMessagingEndpointComponent(t));
    if (src.hasReliableCache())
      tgt.setReliableCacheElement(convertUnsignedInt(src.getReliableCacheElement()));
    if (src.hasDocumentation())
      tgt.setDocumentationElement(convertMarkdown(src.getDocumentationElement()));
    for (org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementMessagingSupportedMessageComponent t : src.getSupportedMessage())
      tgt.addSupportedMessage(convertCapabilityStatementMessagingSupportedMessageComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementMessagingComponent convertCapabilityStatementMessagingComponent(org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementMessagingComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementMessagingComponent tgt = new org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementMessagingComponent();
    copyElement(src, tgt);
    for (org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementMessagingEndpointComponent t : src.getEndpoint())
      tgt.addEndpoint(convertCapabilityStatementMessagingEndpointComponent(t));
    if (src.hasReliableCache())
      tgt.setReliableCacheElement(convertUnsignedInt(src.getReliableCacheElement()));
    if (src.hasDocumentation())
      tgt.setDocumentationElement(convertMarkdown(src.getDocumentationElement()));
    for (org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementMessagingSupportedMessageComponent t : src.getSupportedMessage())
      tgt.addSupportedMessage(convertCapabilityStatementMessagingSupportedMessageComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementMessagingEndpointComponent convertCapabilityStatementMessagingEndpointComponent(org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementMessagingEndpointComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementMessagingEndpointComponent tgt = new org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementMessagingEndpointComponent();
    copyElement(src, tgt);
    if (src.hasProtocol())
      tgt.setProtocol(convertCoding(src.getProtocol()));
    if (src.hasAddress())
      tgt.setAddressElement(convertUrl(src.getAddressElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementMessagingEndpointComponent convertCapabilityStatementMessagingEndpointComponent(org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementMessagingEndpointComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementMessagingEndpointComponent tgt = new org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementMessagingEndpointComponent();
    copyElement(src, tgt);
    if (src.hasProtocol())
      tgt.setProtocol(convertCoding(src.getProtocol()));
    if (src.hasAddress())
      tgt.setAddressElement(convertUrl(src.getAddressElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementMessagingSupportedMessageComponent convertCapabilityStatementMessagingSupportedMessageComponent(org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementMessagingSupportedMessageComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementMessagingSupportedMessageComponent tgt = new org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementMessagingSupportedMessageComponent();
    copyElement(src, tgt);
    if (src.hasMode())
      tgt.setMode(convertEventCapabilityMode(src.getMode()));
    if (src.hasDefinition())
      tgt.setDefinitionElement(convertCanonical(src.getDefinitionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementMessagingSupportedMessageComponent convertCapabilityStatementMessagingSupportedMessageComponent(org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementMessagingSupportedMessageComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementMessagingSupportedMessageComponent tgt = new org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementMessagingSupportedMessageComponent();
    copyElement(src, tgt);
    if (src.hasMode())
      tgt.setMode(convertEventCapabilityMode(src.getMode()));
    if (src.hasDefinition())
      tgt.setDefinitionElement(convertCanonical(src.getDefinitionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.CapabilityStatement.EventCapabilityMode convertEventCapabilityMode(org.hl7.fhir.r4.model.CapabilityStatement.EventCapabilityMode src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case SENDER: return org.hl7.fhir.r5.model.CapabilityStatement.EventCapabilityMode.SENDER;
    case RECEIVER: return org.hl7.fhir.r5.model.CapabilityStatement.EventCapabilityMode.RECEIVER;
    default: return org.hl7.fhir.r5.model.CapabilityStatement.EventCapabilityMode.NULL;
  }
}

  public static org.hl7.fhir.r4.model.CapabilityStatement.EventCapabilityMode convertEventCapabilityMode(org.hl7.fhir.r5.model.CapabilityStatement.EventCapabilityMode src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case SENDER: return org.hl7.fhir.r4.model.CapabilityStatement.EventCapabilityMode.SENDER;
    case RECEIVER: return org.hl7.fhir.r4.model.CapabilityStatement.EventCapabilityMode.RECEIVER;
    default: return org.hl7.fhir.r4.model.CapabilityStatement.EventCapabilityMode.NULL;
  }
}

  public static org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementDocumentComponent convertCapabilityStatementDocumentComponent(org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementDocumentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementDocumentComponent tgt = new org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementDocumentComponent();
    copyElement(src, tgt);
    if (src.hasMode())
      tgt.setMode(convertDocumentMode(src.getMode()));
    if (src.hasDocumentation())
      tgt.setDocumentationElement(convertMarkdown(src.getDocumentationElement()));
    if (src.hasProfile())
      tgt.setProfileElement(convertCanonical(src.getProfileElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementDocumentComponent convertCapabilityStatementDocumentComponent(org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementDocumentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementDocumentComponent tgt = new org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementDocumentComponent();
    copyElement(src, tgt);
    if (src.hasMode())
      tgt.setMode(convertDocumentMode(src.getMode()));
    if (src.hasDocumentation())
      tgt.setDocumentationElement(convertMarkdown(src.getDocumentationElement()));
    if (src.hasProfile())
      tgt.setProfileElement(convertCanonical(src.getProfileElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.CapabilityStatement.DocumentMode convertDocumentMode(org.hl7.fhir.r4.model.CapabilityStatement.DocumentMode src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case PRODUCER: return org.hl7.fhir.r5.model.CapabilityStatement.DocumentMode.PRODUCER;
    case CONSUMER: return org.hl7.fhir.r5.model.CapabilityStatement.DocumentMode.CONSUMER;
    default: return org.hl7.fhir.r5.model.CapabilityStatement.DocumentMode.NULL;
  }
}

  public static org.hl7.fhir.r4.model.CapabilityStatement.DocumentMode convertDocumentMode(org.hl7.fhir.r5.model.CapabilityStatement.DocumentMode src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case PRODUCER: return org.hl7.fhir.r4.model.CapabilityStatement.DocumentMode.PRODUCER;
    case CONSUMER: return org.hl7.fhir.r4.model.CapabilityStatement.DocumentMode.CONSUMER;
    default: return org.hl7.fhir.r4.model.CapabilityStatement.DocumentMode.NULL;
  }
}


}
