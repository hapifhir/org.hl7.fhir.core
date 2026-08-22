package org.hl7.fhir.convertors.conv40_N.resources40_N;

import java.util.stream.Collectors;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Coding40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.metadata40_N.ContactDetail40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.metadata40_N.UsageContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Boolean40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Canonical40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Code40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.DateTime40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.MarkDown40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.String40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.UnsignedInt40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Uri40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Url40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Reference40_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.CapabilityStatement;
import org.hl7.fhir.model.core.Enumeration;
import org.hl7.fhir.model.core.Enumerations;
import org.hl7.fhir.r4.model.CodeType;

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

public class CapabilityStatement40_N {

  public static org.hl7.fhir.model.core.CapabilityStatement convertCapabilityStatement(org.hl7.fhir.r4.model.CapabilityStatement src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.CapabilityStatement tgt = new org.hl7.fhir.model.core.CapabilityStatement();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri40_N.convertUri(src.getUrlElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String40_N.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String40_N.convertString(src.getTitleElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations40_N.convertPublicationStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean40_N.convertBoolean(src.getExperimentalElement()));
    if (src.hasDate())
      tgt.setDateElement(DateTime40_N.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String40_N.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.r4.model.ContactDetail t : src.getContact())
      tgt.addContact(ContactDetail40_N.convertContactDetail(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown40_N.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r4.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(UsageContext40_N.convertUsageContext(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasPurpose())
      tgt.setPurposeElement(MarkDown40_N.convertMarkdown(src.getPurposeElement()));
    if (src.hasCopyright())
      tgt.setCopyrightElement(MarkDown40_N.convertMarkdown(src.getCopyrightElement()));
    if (src.hasKind())
      tgt.setKindElement(convertCapabilityStatementKind(src.getKindElement()));
    for (org.hl7.fhir.r4.model.CanonicalType t : src.getInstantiates())
      tgt.getInstantiatesList().add(Canonical40_N.convertCanonical(t));
    for (org.hl7.fhir.r4.model.CanonicalType t : src.getImports())
      tgt.getImportsList().add(Canonical40_N.convertCanonical(t));
    if (src.hasSoftware())
      tgt.setSoftware(convertCapabilityStatementSoftwareComponent(src.getSoftware()));
    if (src.hasImplementation())
      tgt.setImplementation(convertCapabilityStatementImplementationComponent(src.getImplementation()));
    if (src.hasFhirVersion())
      tgt.setFhirVersionElement(Enumerations40_N.convertFHIRVersion(src.getFhirVersionElement()));
    for (org.hl7.fhir.r4.model.CodeType t : src.getFormat()) tgt.getFormatList().add(Code40_N.convertCode(t));
    for (org.hl7.fhir.r4.model.CodeType t : src.getPatchFormat()) {
      var s = new org.hl7.fhir.model.core.Enumeration<>(new org.hl7.fhir.model.core.CapabilityStatement.PatchMimeTypesEnumFactory());
      s.setValueAsString(t.getValueAsString());
      tgt.getPatchFormatList().add(s);
    };
    for (org.hl7.fhir.r4.model.CanonicalType t : src.getImplementationGuide())
      tgt.getImplementationGuideList().add(Canonical40_N.convertCanonical(t));
    for (org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestComponent t : src.getRest())
      tgt.addRest(convertCapabilityStatementRestComponent(t));
    for (org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementMessagingComponent t : src.getMessaging())
      tgt.addMessaging(convertCapabilityStatementMessagingComponent(t));
    for (org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementDocumentComponent t : src.getDocument())
      tgt.addDocument(convertCapabilityStatementDocumentComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CapabilityStatement convertCapabilityStatement(org.hl7.fhir.model.core.CapabilityStatement src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.CapabilityStatement tgt = new org.hl7.fhir.r4.model.CapabilityStatement();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri40_N.convertUri(src.getUrlElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String40_N.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String40_N.convertString(src.getTitleElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations40_N.convertPublicationStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean40_N.convertBoolean(src.getExperimentalElement()));
    if (src.hasDate())
      tgt.setDateElement(DateTime40_N.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String40_N.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.model.core.ContactDetail t : src.getContactList())
      tgt.addContact(ContactDetail40_N.convertContactDetail(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown40_N.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.model.core.UsageContext t : src.getUseContextList())
      tgt.addUseContext(UsageContext40_N.convertUsageContext(t));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getJurisdictionList())
      tgt.addJurisdiction(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasPurpose())
      tgt.setPurposeElement(MarkDown40_N.convertMarkdown(src.getPurposeElement()));
    if (src.hasCopyright())
      tgt.setCopyrightElement(MarkDown40_N.convertMarkdown(src.getCopyrightElement()));
    if (src.hasKind())
      tgt.setKindElement(convertCapabilityStatementKind(src.getKindElement()));
    for (org.hl7.fhir.model.core.CanonicalType t : src.getInstantiatesList())
      tgt.getInstantiates().add(Canonical40_N.convertCanonical(t));
    for (org.hl7.fhir.model.core.CanonicalType t : src.getImportsList())
      tgt.getImports().add(Canonical40_N.convertCanonical(t));
    if (src.hasSoftware())
      tgt.setSoftware(convertCapabilityStatementSoftwareComponent(src.getSoftware()));
    if (src.hasImplementation())
      tgt.setImplementation(convertCapabilityStatementImplementationComponent(src.getImplementation()));
    if (src.hasFhirVersion())
      tgt.setFhirVersionElement(Enumerations40_N.convertFHIRVersion(src.getFhirVersionElement()));
    for (org.hl7.fhir.model.core.CodeType t : src.getFormatList()) tgt.getFormat().add(Code40_N.convertCode(t));
    for (Enumeration<org.hl7.fhir.model.core.CapabilityStatement.PatchMimeTypes> t : src.getPatchFormatList()) tgt.getPatchFormat().add(new CodeType(t.getCode()));
    for (org.hl7.fhir.model.core.CanonicalType t : src.getImplementationGuideList())
      tgt.getImplementationGuide().add(Canonical40_N.convertCanonical(t));
    for (org.hl7.fhir.model.core.CapabilityStatement.CapabilityStatementRestComponent t : src.getRestList())
      tgt.addRest(convertCapabilityStatementRestComponent(t));
    for (org.hl7.fhir.model.core.CapabilityStatement.CapabilityStatementMessagingComponent t : src.getMessagingList())
      tgt.addMessaging(convertCapabilityStatementMessagingComponent(t));
    for (org.hl7.fhir.model.core.CapabilityStatement.CapabilityStatementDocumentComponent t : src.getDocumentList())
      tgt.addDocument(convertCapabilityStatementDocumentComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.CapabilityStatementKind> convertCapabilityStatementKind(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementKind> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Enumerations.CapabilityStatementKind> tgt = new Enumeration<>(new Enumerations.CapabilityStatementKindEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case INSTANCE:
                  tgt.setValue(Enumerations.CapabilityStatementKind.INSTANCE);
                  break;
              case CAPABILITY:
                  tgt.setValue(Enumerations.CapabilityStatementKind.CAPABILITY);
                  break;
              case REQUIREMENTS:
                  tgt.setValue(Enumerations.CapabilityStatementKind.REQUIREMENTS);
                  break;
              default:
                  tgt.setValue(Enumerations.CapabilityStatementKind.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementKind> convertCapabilityStatementKind(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.CapabilityStatementKind> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<CapabilityStatement.CapabilityStatementKind> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new CapabilityStatement.CapabilityStatementKindEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case INSTANCE:
                  tgt.setValue(CapabilityStatement.CapabilityStatementKind.INSTANCE);
                  break;
              case CAPABILITY:
                  tgt.setValue(CapabilityStatement.CapabilityStatementKind.CAPABILITY);
                  break;
              case REQUIREMENTS:
                  tgt.setValue(CapabilityStatement.CapabilityStatementKind.REQUIREMENTS);
                  break;
              default:
                  tgt.setValue(CapabilityStatement.CapabilityStatementKind.NULL);
                  break;
          }
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.CapabilityStatement.CapabilityStatementSoftwareComponent convertCapabilityStatementSoftwareComponent(org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementSoftwareComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.CapabilityStatement.CapabilityStatementSoftwareComponent tgt = new org.hl7.fhir.model.core.CapabilityStatement.CapabilityStatementSoftwareComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String40_N.convertString(src.getVersionElement()));
    if (src.hasReleaseDate())
      tgt.setReleaseDateElement(DateTime40_N.convertDateTime(src.getReleaseDateElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementSoftwareComponent convertCapabilityStatementSoftwareComponent(org.hl7.fhir.model.core.CapabilityStatement.CapabilityStatementSoftwareComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementSoftwareComponent tgt = new org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementSoftwareComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String40_N.convertString(src.getVersionElement()));
    if (src.hasReleaseDate())
      tgt.setReleaseDateElement(DateTime40_N.convertDateTime(src.getReleaseDateElement()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.CapabilityStatement.CapabilityStatementImplementationComponent convertCapabilityStatementImplementationComponent(org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementImplementationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.CapabilityStatement.CapabilityStatementImplementationComponent tgt = new org.hl7.fhir.model.core.CapabilityStatement.CapabilityStatementImplementationComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_N.convertStringToMarkdown(src.getDescriptionElement()));
    if (src.hasUrl())
      tgt.setUrlElement(Url40_N.convertUrl(src.getUrlElement()));
    if (src.hasCustodian())
      tgt.setCustodian(Reference40_N.convertReference(src.getCustodian()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementImplementationComponent convertCapabilityStatementImplementationComponent(org.hl7.fhir.model.core.CapabilityStatement.CapabilityStatementImplementationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementImplementationComponent tgt = new org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementImplementationComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_N.convertString(src.getDescriptionElement()));
    if (src.hasUrl())
      tgt.setUrlElement(Url40_N.convertUrl(src.getUrlElement()));
    if (src.hasCustodian())
      tgt.setCustodian(Reference40_N.convertReference(src.getCustodian()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.CapabilityStatement.CapabilityStatementRestComponent convertCapabilityStatementRestComponent(org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.CapabilityStatement.CapabilityStatementRestComponent tgt = new org.hl7.fhir.model.core.CapabilityStatement.CapabilityStatementRestComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasMode())
      tgt.setModeElement(convertRestfulCapabilityMode(src.getModeElement()));
    if (src.hasDocumentation())
      tgt.setDocumentationElement(MarkDown40_N.convertMarkdown(src.getDocumentationElement()));
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
      tgt.getCompartmentList().add(Canonical40_N.convertCanonical(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestComponent convertCapabilityStatementRestComponent(org.hl7.fhir.model.core.CapabilityStatement.CapabilityStatementRestComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestComponent tgt = new org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasMode())
      tgt.setModeElement(convertRestfulCapabilityMode(src.getModeElement()));
    if (src.hasDocumentation())
      tgt.setDocumentationElement(MarkDown40_N.convertMarkdown(src.getDocumentationElement()));
    if (src.hasSecurity())
      tgt.setSecurity(convertCapabilityStatementRestSecurityComponent(src.getSecurity()));
    for (org.hl7.fhir.model.core.CapabilityStatement.CapabilityStatementRestResourceComponent t : src.getResourceList())
      tgt.addResource(convertCapabilityStatementRestResourceComponent(t));
    for (org.hl7.fhir.model.core.CapabilityStatement.SystemInteractionComponent t : src.getInteractionList())
      tgt.addInteraction(convertSystemInteractionComponent(t));
    for (org.hl7.fhir.model.core.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent t : src.getSearchParamList())
      tgt.addSearchParam(convertCapabilityStatementRestResourceSearchParamComponent(t));
    for (org.hl7.fhir.model.core.CapabilityStatement.CapabilityStatementRestResourceOperationComponent t : src.getOperationList())
      tgt.addOperation(convertCapabilityStatementRestResourceOperationComponent(t));
    for (org.hl7.fhir.model.core.CanonicalType t : src.getCompartmentList())
      tgt.getCompartment().add(Canonical40_N.convertCanonical(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.CapabilityStatement.RestfulCapabilityMode> convertRestfulCapabilityMode(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CapabilityStatement.RestfulCapabilityMode> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<org.hl7.fhir.model.core.CapabilityStatement.RestfulCapabilityMode> tgt = new Enumeration<>(new org.hl7.fhir.model.core.CapabilityStatement.RestfulCapabilityModeEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case CLIENT:
                  tgt.setValue(org.hl7.fhir.model.core.CapabilityStatement.RestfulCapabilityMode.CLIENT);
                  break;
              case SERVER:
                  tgt.setValue(org.hl7.fhir.model.core.CapabilityStatement.RestfulCapabilityMode.SERVER);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.model.core.CapabilityStatement.RestfulCapabilityMode.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CapabilityStatement.RestfulCapabilityMode> convertRestfulCapabilityMode(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.CapabilityStatement.RestfulCapabilityMode> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<CapabilityStatement.RestfulCapabilityMode> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new CapabilityStatement.RestfulCapabilityModeEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case CLIENT:
                  tgt.setValue(CapabilityStatement.RestfulCapabilityMode.CLIENT);
                  break;
              case SERVER:
                  tgt.setValue(CapabilityStatement.RestfulCapabilityMode.SERVER);
                  break;
              default:
                  tgt.setValue(CapabilityStatement.RestfulCapabilityMode.NULL);
                  break;
          }
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.CapabilityStatement.CapabilityStatementRestSecurityComponent convertCapabilityStatementRestSecurityComponent(org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestSecurityComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.CapabilityStatement.CapabilityStatementRestSecurityComponent tgt = new org.hl7.fhir.model.core.CapabilityStatement.CapabilityStatementRestSecurityComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasCors())
      tgt.setCorsElement(Boolean40_N.convertBoolean(src.getCorsElement()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getService())
      tgt.addService(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown40_N.convertMarkdown(src.getDescriptionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestSecurityComponent convertCapabilityStatementRestSecurityComponent(org.hl7.fhir.model.core.CapabilityStatement.CapabilityStatementRestSecurityComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestSecurityComponent tgt = new org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestSecurityComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasCors())
      tgt.setCorsElement(Boolean40_N.convertBoolean(src.getCorsElement()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getServiceList())
      tgt.addService(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown40_N.convertMarkdown(src.getDescriptionElement()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.CapabilityStatement.CapabilityStatementRestResourceComponent convertCapabilityStatementRestResourceComponent(org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestResourceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.CapabilityStatement.CapabilityStatementRestResourceComponent tgt = new org.hl7.fhir.model.core.CapabilityStatement.CapabilityStatementRestResourceComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setTypeElement(Uri40_N.convertUriFromCode(src.getTypeElement()));
    if (src.hasProfile())
      tgt.setProfileElement(Canonical40_N.convertCanonical(src.getProfileElement()));
    for (org.hl7.fhir.r4.model.CanonicalType t : src.getSupportedProfile())
      tgt.getSupportedProfileList().add(Canonical40_N.convertCanonical(t));
    if (src.hasDocumentation())
      tgt.setDocumentationElement(MarkDown40_N.convertMarkdown(src.getDocumentationElement()));
    for (org.hl7.fhir.r4.model.CapabilityStatement.ResourceInteractionComponent t : src.getInteraction())
      tgt.addInteraction(convertResourceInteractionComponent(t));
    if (src.hasVersioning())
      tgt.setVersioningElement(convertResourceVersionPolicy(src.getVersioningElement()));
    if (src.hasReadHistory())
      tgt.setReadHistoryElement(Boolean40_N.convertBoolean(src.getReadHistoryElement()));
    if (src.hasUpdateCreate())
      tgt.setUpdateCreateElement(Boolean40_N.convertBoolean(src.getUpdateCreateElement()));
    if (src.hasConditionalCreate())
      tgt.setConditionalCreateElement(Boolean40_N.convertBoolean(src.getConditionalCreateElement()));
    if (src.hasConditionalRead())
      tgt.setConditionalReadElement(convertConditionalReadStatus(src.getConditionalReadElement()));
    if (src.hasConditionalUpdate())
      tgt.setConditionalUpdateElement(Boolean40_N.convertBoolean(src.getConditionalUpdateElement()));
    if (src.hasConditionalDelete())
      tgt.setConditionalDeleteElement(convertConditionalDeleteStatus(src.getConditionalDeleteElement()));
    tgt.setReferencePolicyList(src.getReferencePolicy().stream()
      .map(CapabilityStatement40_N::convertReferenceHandlingPolicy)
      .collect(Collectors.toList()));
    for (org.hl7.fhir.r4.model.StringType t : src.getSearchInclude())
      tgt.getSearchIncludeList().add(String40_N.convertString(t));
    for (org.hl7.fhir.r4.model.StringType t : src.getSearchRevInclude())
      tgt.getSearchRevIncludeList().add(String40_N.convertString(t));
    for (org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent t : src.getSearchParam())
      tgt.addSearchParam(convertCapabilityStatementRestResourceSearchParamComponent(t));
    for (org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestResourceOperationComponent t : src.getOperation())
      tgt.addOperation(convertCapabilityStatementRestResourceOperationComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestResourceComponent convertCapabilityStatementRestResourceComponent(org.hl7.fhir.model.core.CapabilityStatement.CapabilityStatementRestResourceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestResourceComponent tgt = new org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestResourceComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setTypeElement(Uri40_N.convertUriToCode(src.getTypeElement()));
    if (src.hasProfile())
      tgt.setProfileElement(Canonical40_N.convertCanonical(src.getProfileElement()));
    for (org.hl7.fhir.model.core.CanonicalType t : src.getSupportedProfileList())
      tgt.getSupportedProfile().add(Canonical40_N.convertCanonical(t));
    if (src.hasDocumentation())
      tgt.setDocumentationElement(MarkDown40_N.convertMarkdown(src.getDocumentationElement()));
    for (org.hl7.fhir.model.core.CapabilityStatement.ResourceInteractionComponent t : src.getInteractionList())
      tgt.addInteraction(convertResourceInteractionComponent(t));
    if (src.hasVersioning())
      tgt.setVersioningElement(convertResourceVersionPolicy(src.getVersioningElement()));
    if (src.hasReadHistory())
      tgt.setReadHistoryElement(Boolean40_N.convertBoolean(src.getReadHistoryElement()));
    if (src.hasUpdateCreate())
      tgt.setUpdateCreateElement(Boolean40_N.convertBoolean(src.getUpdateCreateElement()));
    if (src.hasConditionalCreate())
      tgt.setConditionalCreateElement(Boolean40_N.convertBoolean(src.getConditionalCreateElement()));
    if (src.hasConditionalRead())
      tgt.setConditionalReadElement(convertConditionalReadStatus(src.getConditionalReadElement()));
    if (src.hasConditionalUpdate())
      tgt.setConditionalUpdateElement(Boolean40_N.convertBoolean(src.getConditionalUpdateElement()));
    if (src.hasConditionalDelete())
      tgt.setConditionalDeleteElement(convertConditionalDeleteStatus(src.getConditionalDeleteElement()));
    tgt.setReferencePolicy(src.getReferencePolicyList().stream()
      .map(CapabilityStatement40_N::convertReferenceHandlingPolicy)
      .collect(Collectors.toList()));
    for (org.hl7.fhir.model.core.StringType t : src.getSearchIncludeList())
      tgt.getSearchInclude().add(String40_N.convertString(t));
    for (org.hl7.fhir.model.core.StringType t : src.getSearchRevIncludeList())
      tgt.getSearchRevInclude().add(String40_N.convertString(t));
    for (org.hl7.fhir.model.core.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent t : src.getSearchParamList())
      tgt.addSearchParam(convertCapabilityStatementRestResourceSearchParamComponent(t));
    for (org.hl7.fhir.model.core.CapabilityStatement.CapabilityStatementRestResourceOperationComponent t : src.getOperationList())
      tgt.addOperation(convertCapabilityStatementRestResourceOperationComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.CapabilityStatement.ResourceVersionPolicy> convertResourceVersionPolicy(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CapabilityStatement.ResourceVersionPolicy> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<org.hl7.fhir.model.core.CapabilityStatement.ResourceVersionPolicy> tgt = new Enumeration<>(new org.hl7.fhir.model.core.CapabilityStatement.ResourceVersionPolicyEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case NOVERSION:
                  tgt.setValue(org.hl7.fhir.model.core.CapabilityStatement.ResourceVersionPolicy.NOVERSION);
                  break;
              case VERSIONED:
                  tgt.setValue(org.hl7.fhir.model.core.CapabilityStatement.ResourceVersionPolicy.VERSIONED);
                  break;
              case VERSIONEDUPDATE:
                  tgt.setValue(org.hl7.fhir.model.core.CapabilityStatement.ResourceVersionPolicy.VERSIONEDUPDATE);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.model.core.CapabilityStatement.ResourceVersionPolicy.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CapabilityStatement.ResourceVersionPolicy> convertResourceVersionPolicy(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.CapabilityStatement.ResourceVersionPolicy> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<CapabilityStatement.ResourceVersionPolicy> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new CapabilityStatement.ResourceVersionPolicyEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case NOVERSION:
                  tgt.setValue(CapabilityStatement.ResourceVersionPolicy.NOVERSION);
                  break;
              case VERSIONED:
                  tgt.setValue(CapabilityStatement.ResourceVersionPolicy.VERSIONED);
                  break;
              case VERSIONEDUPDATE:
                  tgt.setValue(CapabilityStatement.ResourceVersionPolicy.VERSIONEDUPDATE);
                  break;
              default:
                  tgt.setValue(CapabilityStatement.ResourceVersionPolicy.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.CapabilityStatement.ConditionalReadStatus> convertConditionalReadStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CapabilityStatement.ConditionalReadStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<org.hl7.fhir.model.core.CapabilityStatement.ConditionalReadStatus> tgt = new Enumeration<>(new org.hl7.fhir.model.core.CapabilityStatement.ConditionalReadStatusEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case NOTSUPPORTED:
                  tgt.setValue(org.hl7.fhir.model.core.CapabilityStatement.ConditionalReadStatus.NOTSUPPORTED);
                  break;
              case MODIFIEDSINCE:
                  tgt.setValue(org.hl7.fhir.model.core.CapabilityStatement.ConditionalReadStatus.MODIFIEDSINCE);
                  break;
              case NOTMATCH:
                  tgt.setValue(org.hl7.fhir.model.core.CapabilityStatement.ConditionalReadStatus.NOTMATCH);
                  break;
              case FULLSUPPORT:
                  tgt.setValue(org.hl7.fhir.model.core.CapabilityStatement.ConditionalReadStatus.FULLSUPPORT);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.model.core.CapabilityStatement.ConditionalReadStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CapabilityStatement.ConditionalReadStatus> convertConditionalReadStatus(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.CapabilityStatement.ConditionalReadStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<CapabilityStatement.ConditionalReadStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new CapabilityStatement.ConditionalReadStatusEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case NOTSUPPORTED:
                  tgt.setValue(CapabilityStatement.ConditionalReadStatus.NOTSUPPORTED);
                  break;
              case MODIFIEDSINCE:
                  tgt.setValue(CapabilityStatement.ConditionalReadStatus.MODIFIEDSINCE);
                  break;
              case NOTMATCH:
                  tgt.setValue(CapabilityStatement.ConditionalReadStatus.NOTMATCH);
                  break;
              case FULLSUPPORT:
                  tgt.setValue(CapabilityStatement.ConditionalReadStatus.FULLSUPPORT);
                  break;
              default:
                  tgt.setValue(CapabilityStatement.ConditionalReadStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.CapabilityStatement.ConditionalDeleteStatus> convertConditionalDeleteStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CapabilityStatement.ConditionalDeleteStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<org.hl7.fhir.model.core.CapabilityStatement.ConditionalDeleteStatus> tgt = new Enumeration<>(new org.hl7.fhir.model.core.CapabilityStatement.ConditionalDeleteStatusEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case NOTSUPPORTED:
                  tgt.setValue(org.hl7.fhir.model.core.CapabilityStatement.ConditionalDeleteStatus.NOTSUPPORTED);
                  break;
              case SINGLE:
                  tgt.setValue(org.hl7.fhir.model.core.CapabilityStatement.ConditionalDeleteStatus.SINGLE);
                  break;
              case MULTIPLE:
                  tgt.setValue(org.hl7.fhir.model.core.CapabilityStatement.ConditionalDeleteStatus.MULTIPLE);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.model.core.CapabilityStatement.ConditionalDeleteStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CapabilityStatement.ConditionalDeleteStatus> convertConditionalDeleteStatus(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.CapabilityStatement.ConditionalDeleteStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<CapabilityStatement.ConditionalDeleteStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new CapabilityStatement.ConditionalDeleteStatusEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case NOTSUPPORTED:
                  tgt.setValue(CapabilityStatement.ConditionalDeleteStatus.NOTSUPPORTED);
                  break;
              case SINGLE:
                  tgt.setValue(CapabilityStatement.ConditionalDeleteStatus.SINGLE);
                  break;
              case MULTIPLE:
                  tgt.setValue(CapabilityStatement.ConditionalDeleteStatus.MULTIPLE);
                  break;
              default:
                  tgt.setValue(CapabilityStatement.ConditionalDeleteStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.CapabilityStatement.ReferenceHandlingPolicy> convertReferenceHandlingPolicy(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CapabilityStatement.ReferenceHandlingPolicy> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<org.hl7.fhir.model.core.CapabilityStatement.ReferenceHandlingPolicy> tgt = new Enumeration<>(new org.hl7.fhir.model.core.CapabilityStatement.ReferenceHandlingPolicyEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case LITERAL:
                  tgt.setValue(org.hl7.fhir.model.core.CapabilityStatement.ReferenceHandlingPolicy.LITERAL);
                  break;
              case LOGICAL:
                  tgt.setValue(org.hl7.fhir.model.core.CapabilityStatement.ReferenceHandlingPolicy.LOGICAL);
                  break;
              case RESOLVES:
                  tgt.setValue(org.hl7.fhir.model.core.CapabilityStatement.ReferenceHandlingPolicy.RESOLVES);
                  break;
              case ENFORCED:
                  tgt.setValue(org.hl7.fhir.model.core.CapabilityStatement.ReferenceHandlingPolicy.ENFORCED);
                  break;
              case LOCAL:
                  tgt.setValue(org.hl7.fhir.model.core.CapabilityStatement.ReferenceHandlingPolicy.LOCAL);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.model.core.CapabilityStatement.ReferenceHandlingPolicy.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CapabilityStatement.ReferenceHandlingPolicy> convertReferenceHandlingPolicy(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.CapabilityStatement.ReferenceHandlingPolicy> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<CapabilityStatement.ReferenceHandlingPolicy> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new CapabilityStatement.ReferenceHandlingPolicyEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case LITERAL:
                  tgt.setValue(CapabilityStatement.ReferenceHandlingPolicy.LITERAL);
                  break;
              case LOGICAL:
                  tgt.setValue(CapabilityStatement.ReferenceHandlingPolicy.LOGICAL);
                  break;
              case RESOLVES:
                  tgt.setValue(CapabilityStatement.ReferenceHandlingPolicy.RESOLVES);
                  break;
              case ENFORCED:
                  tgt.setValue(CapabilityStatement.ReferenceHandlingPolicy.ENFORCED);
                  break;
              case LOCAL:
                  tgt.setValue(CapabilityStatement.ReferenceHandlingPolicy.LOCAL);
                  break;
              default:
                  tgt.setValue(CapabilityStatement.ReferenceHandlingPolicy.NULL);
                  break;
          }
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.CapabilityStatement.ResourceInteractionComponent convertResourceInteractionComponent(org.hl7.fhir.r4.model.CapabilityStatement.ResourceInteractionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.CapabilityStatement.ResourceInteractionComponent tgt = new org.hl7.fhir.model.core.CapabilityStatement.ResourceInteractionComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCodeElement(convertTypeRestfulInteraction(src.getCodeElement()));
    if (src.hasDocumentation())
      tgt.setDocumentationElement(MarkDown40_N.convertMarkdown(src.getDocumentationElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CapabilityStatement.ResourceInteractionComponent convertResourceInteractionComponent(org.hl7.fhir.model.core.CapabilityStatement.ResourceInteractionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.CapabilityStatement.ResourceInteractionComponent tgt = new org.hl7.fhir.r4.model.CapabilityStatement.ResourceInteractionComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCodeElement(convertTypeRestfulInteraction(src.getCodeElement()));
    if (src.hasDocumentation())
      tgt.setDocumentationElement(MarkDown40_N.convertMarkdown(src.getDocumentationElement()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.CapabilityStatement.TypeRestfulInteraction> convertTypeRestfulInteraction(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CapabilityStatement.TypeRestfulInteraction> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<org.hl7.fhir.model.core.CapabilityStatement.TypeRestfulInteraction> tgt = new Enumeration<>(new org.hl7.fhir.model.core.CapabilityStatement.TypeRestfulInteractionEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case READ:
                  tgt.setValue(org.hl7.fhir.model.core.CapabilityStatement.TypeRestfulInteraction.READ);
                  break;
              case VREAD:
                  tgt.setValue(org.hl7.fhir.model.core.CapabilityStatement.TypeRestfulInteraction.VREAD);
                  break;
              case UPDATE:
                  tgt.setValue(org.hl7.fhir.model.core.CapabilityStatement.TypeRestfulInteraction.UPDATE);
                  break;
              case PATCH:
                  tgt.setValue(org.hl7.fhir.model.core.CapabilityStatement.TypeRestfulInteraction.PATCH);
                  break;
              case DELETE:
                  tgt.setValue(org.hl7.fhir.model.core.CapabilityStatement.TypeRestfulInteraction.DELETE);
                  break;
              case HISTORYINSTANCE:
                  tgt.setValue(org.hl7.fhir.model.core.CapabilityStatement.TypeRestfulInteraction.HISTORYINSTANCE);
                  break;
              case HISTORYTYPE:
                  tgt.setValue(org.hl7.fhir.model.core.CapabilityStatement.TypeRestfulInteraction.HISTORYTYPE);
                  break;
              case CREATE:
                  tgt.setValue(org.hl7.fhir.model.core.CapabilityStatement.TypeRestfulInteraction.CREATE);
                  break;
              case SEARCHTYPE:
                  tgt.setValue(org.hl7.fhir.model.core.CapabilityStatement.TypeRestfulInteraction.SEARCHTYPE);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.model.core.CapabilityStatement.TypeRestfulInteraction.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CapabilityStatement.TypeRestfulInteraction> convertTypeRestfulInteraction(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.CapabilityStatement.TypeRestfulInteraction> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<CapabilityStatement.TypeRestfulInteraction> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new CapabilityStatement.TypeRestfulInteractionEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case READ:
                  tgt.setValue(CapabilityStatement.TypeRestfulInteraction.READ);
                  break;
              case VREAD:
                  tgt.setValue(CapabilityStatement.TypeRestfulInteraction.VREAD);
                  break;
              case UPDATE:
                  tgt.setValue(CapabilityStatement.TypeRestfulInteraction.UPDATE);
                  break;
              case PATCH:
                  tgt.setValue(CapabilityStatement.TypeRestfulInteraction.PATCH);
                  break;
              case DELETE:
                  tgt.setValue(CapabilityStatement.TypeRestfulInteraction.DELETE);
                  break;
              case HISTORYINSTANCE:
                  tgt.setValue(CapabilityStatement.TypeRestfulInteraction.HISTORYINSTANCE);
                  break;
              case HISTORYTYPE:
                  tgt.setValue(CapabilityStatement.TypeRestfulInteraction.HISTORYTYPE);
                  break;
              case CREATE:
                  tgt.setValue(CapabilityStatement.TypeRestfulInteraction.CREATE);
                  break;
              case SEARCHTYPE:
                  tgt.setValue(CapabilityStatement.TypeRestfulInteraction.SEARCHTYPE);
                  break;
              default:
                  tgt.setValue(CapabilityStatement.TypeRestfulInteraction.NULL);
                  break;
          }
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent convertCapabilityStatementRestResourceSearchParamComponent(org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent tgt = new org.hl7.fhir.model.core.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    if (src.hasDefinition())
      tgt.setDefinitionElement(Canonical40_N.convertCanonical(src.getDefinitionElement()));
    if (src.hasType())
      tgt.setTypeElement(Enumerations40_N.convertSearchParamType(src.getTypeElement()));
    if (src.hasDocumentation())
      tgt.setDocumentationElement(MarkDown40_N.convertMarkdown(src.getDocumentationElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent convertCapabilityStatementRestResourceSearchParamComponent(org.hl7.fhir.model.core.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent tgt = new org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    if (src.hasDefinition())
      tgt.setDefinitionElement(Canonical40_N.convertCanonical(src.getDefinitionElement()));
    if (src.hasType())
      tgt.setTypeElement(Enumerations40_N.convertSearchParamType(src.getTypeElement()));
    if (src.hasDocumentation())
      tgt.setDocumentationElement(MarkDown40_N.convertMarkdown(src.getDocumentationElement()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.CapabilityStatement.CapabilityStatementRestResourceOperationComponent convertCapabilityStatementRestResourceOperationComponent(org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestResourceOperationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.CapabilityStatement.CapabilityStatementRestResourceOperationComponent tgt = new org.hl7.fhir.model.core.CapabilityStatement.CapabilityStatementRestResourceOperationComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    if (src.hasDefinition())
      tgt.setDefinitionElement(Canonical40_N.convertCanonical(src.getDefinitionElement()));
    if (src.hasDocumentation())
      tgt.setDocumentationElement(MarkDown40_N.convertMarkdown(src.getDocumentationElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestResourceOperationComponent convertCapabilityStatementRestResourceOperationComponent(org.hl7.fhir.model.core.CapabilityStatement.CapabilityStatementRestResourceOperationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestResourceOperationComponent tgt = new org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestResourceOperationComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    if (src.hasDefinition())
      tgt.setDefinitionElement(Canonical40_N.convertCanonical(src.getDefinitionElement()));
    if (src.hasDocumentation())
      tgt.setDocumentationElement(MarkDown40_N.convertMarkdown(src.getDocumentationElement()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.CapabilityStatement.SystemInteractionComponent convertSystemInteractionComponent(org.hl7.fhir.r4.model.CapabilityStatement.SystemInteractionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.CapabilityStatement.SystemInteractionComponent tgt = new org.hl7.fhir.model.core.CapabilityStatement.SystemInteractionComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCodeElement(convertSystemRestfulInteraction(src.getCodeElement()));
    if (src.hasDocumentation())
      tgt.setDocumentationElement(MarkDown40_N.convertMarkdown(src.getDocumentationElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CapabilityStatement.SystemInteractionComponent convertSystemInteractionComponent(org.hl7.fhir.model.core.CapabilityStatement.SystemInteractionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.CapabilityStatement.SystemInteractionComponent tgt = new org.hl7.fhir.r4.model.CapabilityStatement.SystemInteractionComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCodeElement(convertSystemRestfulInteraction(src.getCodeElement()));
    if (src.hasDocumentation())
      tgt.setDocumentationElement(MarkDown40_N.convertMarkdown(src.getDocumentationElement()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.CapabilityStatement.SystemRestfulInteraction> convertSystemRestfulInteraction(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CapabilityStatement.SystemRestfulInteraction> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<org.hl7.fhir.model.core.CapabilityStatement.SystemRestfulInteraction> tgt = new Enumeration<>(new org.hl7.fhir.model.core.CapabilityStatement.SystemRestfulInteractionEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case TRANSACTION:
                  tgt.setValue(org.hl7.fhir.model.core.CapabilityStatement.SystemRestfulInteraction.TRANSACTION);
                  break;
              case BATCH:
                  tgt.setValue(org.hl7.fhir.model.core.CapabilityStatement.SystemRestfulInteraction.BATCH);
                  break;
              case SEARCHSYSTEM:
                  tgt.setValue(org.hl7.fhir.model.core.CapabilityStatement.SystemRestfulInteraction.SEARCHSYSTEM);
                  break;
              case HISTORYSYSTEM:
                  tgt.setValue(org.hl7.fhir.model.core.CapabilityStatement.SystemRestfulInteraction.HISTORYSYSTEM);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.model.core.CapabilityStatement.SystemRestfulInteraction.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CapabilityStatement.SystemRestfulInteraction> convertSystemRestfulInteraction(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.CapabilityStatement.SystemRestfulInteraction> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<CapabilityStatement.SystemRestfulInteraction> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new CapabilityStatement.SystemRestfulInteractionEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case TRANSACTION:
                  tgt.setValue(CapabilityStatement.SystemRestfulInteraction.TRANSACTION);
                  break;
              case BATCH:
                  tgt.setValue(CapabilityStatement.SystemRestfulInteraction.BATCH);
                  break;
              case SEARCHSYSTEM:
                  tgt.setValue(CapabilityStatement.SystemRestfulInteraction.SEARCHSYSTEM);
                  break;
              case HISTORYSYSTEM:
                  tgt.setValue(CapabilityStatement.SystemRestfulInteraction.HISTORYSYSTEM);
                  break;
              default:
                  tgt.setValue(CapabilityStatement.SystemRestfulInteraction.NULL);
                  break;
          }
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.CapabilityStatement.CapabilityStatementMessagingComponent convertCapabilityStatementMessagingComponent(org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementMessagingComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.CapabilityStatement.CapabilityStatementMessagingComponent tgt = new org.hl7.fhir.model.core.CapabilityStatement.CapabilityStatementMessagingComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementMessagingEndpointComponent t : src.getEndpoint())
      tgt.addEndpoint(convertCapabilityStatementMessagingEndpointComponent(t));
    if (src.hasReliableCache())
      tgt.setReliableCacheElement(UnsignedInt40_N.convertUnsignedInt(src.getReliableCacheElement()));
    if (src.hasDocumentation())
      tgt.setDocumentationElement(MarkDown40_N.convertMarkdown(src.getDocumentationElement()));
    for (org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementMessagingSupportedMessageComponent t : src.getSupportedMessage())
      tgt.addSupportedMessage(convertCapabilityStatementMessagingSupportedMessageComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementMessagingComponent convertCapabilityStatementMessagingComponent(org.hl7.fhir.model.core.CapabilityStatement.CapabilityStatementMessagingComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementMessagingComponent tgt = new org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementMessagingComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.model.core.CapabilityStatement.CapabilityStatementMessagingEndpointComponent t : src.getEndpointList())
      tgt.addEndpoint(convertCapabilityStatementMessagingEndpointComponent(t));
    if (src.hasReliableCache())
      tgt.setReliableCacheElement(UnsignedInt40_N.convertUnsignedInt(src.getReliableCacheElement()));
    if (src.hasDocumentation())
      tgt.setDocumentationElement(MarkDown40_N.convertMarkdown(src.getDocumentationElement()));
    for (org.hl7.fhir.model.core.CapabilityStatement.CapabilityStatementMessagingSupportedMessageComponent t : src.getSupportedMessageList())
      tgt.addSupportedMessage(convertCapabilityStatementMessagingSupportedMessageComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.CapabilityStatement.CapabilityStatementMessagingEndpointComponent convertCapabilityStatementMessagingEndpointComponent(org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementMessagingEndpointComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.CapabilityStatement.CapabilityStatementMessagingEndpointComponent tgt = new org.hl7.fhir.model.core.CapabilityStatement.CapabilityStatementMessagingEndpointComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasProtocol())
      tgt.setProtocol(Coding40_N.convertCoding(src.getProtocol()));
    if (src.hasAddress())
      tgt.setAddressElement(Url40_N.convertUrl(src.getAddressElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementMessagingEndpointComponent convertCapabilityStatementMessagingEndpointComponent(org.hl7.fhir.model.core.CapabilityStatement.CapabilityStatementMessagingEndpointComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementMessagingEndpointComponent tgt = new org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementMessagingEndpointComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasProtocol())
      tgt.setProtocol(Coding40_N.convertCoding(src.getProtocol()));
    if (src.hasAddress())
      tgt.setAddressElement(Url40_N.convertUrl(src.getAddressElement()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.CapabilityStatement.CapabilityStatementMessagingSupportedMessageComponent convertCapabilityStatementMessagingSupportedMessageComponent(org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementMessagingSupportedMessageComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.CapabilityStatement.CapabilityStatementMessagingSupportedMessageComponent tgt = new org.hl7.fhir.model.core.CapabilityStatement.CapabilityStatementMessagingSupportedMessageComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasMode())
      tgt.setModeElement(convertEventCapabilityMode(src.getModeElement()));
    if (src.hasDefinition())
      tgt.setDefinitionElement(Canonical40_N.convertCanonical(src.getDefinitionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementMessagingSupportedMessageComponent convertCapabilityStatementMessagingSupportedMessageComponent(org.hl7.fhir.model.core.CapabilityStatement.CapabilityStatementMessagingSupportedMessageComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementMessagingSupportedMessageComponent tgt = new org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementMessagingSupportedMessageComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasMode())
      tgt.setModeElement(convertEventCapabilityMode(src.getModeElement()));
    if (src.hasDefinition())
      tgt.setDefinitionElement(Canonical40_N.convertCanonical(src.getDefinitionElement()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.CapabilityStatement.EventCapabilityMode> convertEventCapabilityMode(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CapabilityStatement.EventCapabilityMode> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<org.hl7.fhir.model.core.CapabilityStatement.EventCapabilityMode> tgt = new Enumeration<>(new org.hl7.fhir.model.core.CapabilityStatement.EventCapabilityModeEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case SENDER:
                  tgt.setValue(org.hl7.fhir.model.core.CapabilityStatement.EventCapabilityMode.SENDER);
                  break;
              case RECEIVER:
                  tgt.setValue(org.hl7.fhir.model.core.CapabilityStatement.EventCapabilityMode.RECEIVER);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.model.core.CapabilityStatement.EventCapabilityMode.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CapabilityStatement.EventCapabilityMode> convertEventCapabilityMode(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.CapabilityStatement.EventCapabilityMode> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<CapabilityStatement.EventCapabilityMode> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new CapabilityStatement.EventCapabilityModeEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case SENDER:
                  tgt.setValue(CapabilityStatement.EventCapabilityMode.SENDER);
                  break;
              case RECEIVER:
                  tgt.setValue(CapabilityStatement.EventCapabilityMode.RECEIVER);
                  break;
              default:
                  tgt.setValue(CapabilityStatement.EventCapabilityMode.NULL);
                  break;
          }
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.CapabilityStatement.CapabilityStatementDocumentComponent convertCapabilityStatementDocumentComponent(org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementDocumentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.CapabilityStatement.CapabilityStatementDocumentComponent tgt = new org.hl7.fhir.model.core.CapabilityStatement.CapabilityStatementDocumentComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasMode())
      tgt.setModeElement(convertDocumentMode(src.getModeElement()));
    if (src.hasDocumentation())
      tgt.setDocumentationElement(MarkDown40_N.convertMarkdown(src.getDocumentationElement()));
    if (src.hasProfile())
      tgt.setProfileElement(Canonical40_N.convertCanonical(src.getProfileElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementDocumentComponent convertCapabilityStatementDocumentComponent(org.hl7.fhir.model.core.CapabilityStatement.CapabilityStatementDocumentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementDocumentComponent tgt = new org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementDocumentComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasMode())
      tgt.setModeElement(convertDocumentMode(src.getModeElement()));
    if (src.hasDocumentation())
      tgt.setDocumentationElement(MarkDown40_N.convertMarkdown(src.getDocumentationElement()));
    if (src.hasProfile())
      tgt.setProfileElement(Canonical40_N.convertCanonical(src.getProfileElement()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.CapabilityStatement.DocumentMode> convertDocumentMode(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CapabilityStatement.DocumentMode> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<org.hl7.fhir.model.core.CapabilityStatement.DocumentMode> tgt = new Enumeration<>(new org.hl7.fhir.model.core.CapabilityStatement.DocumentModeEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case PRODUCER:
                  tgt.setValue(org.hl7.fhir.model.core.CapabilityStatement.DocumentMode.PRODUCER);
                  break;
              case CONSUMER:
                  tgt.setValue(org.hl7.fhir.model.core.CapabilityStatement.DocumentMode.CONSUMER);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.model.core.CapabilityStatement.DocumentMode.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CapabilityStatement.DocumentMode> convertDocumentMode(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.CapabilityStatement.DocumentMode> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<CapabilityStatement.DocumentMode> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new CapabilityStatement.DocumentModeEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case PRODUCER:
                  tgt.setValue(CapabilityStatement.DocumentMode.PRODUCER);
                  break;
              case CONSUMER:
                  tgt.setValue(CapabilityStatement.DocumentMode.CONSUMER);
                  break;
              default:
                  tgt.setValue(CapabilityStatement.DocumentMode.NULL);
                  break;
          }
      }
      return tgt;
  }
}