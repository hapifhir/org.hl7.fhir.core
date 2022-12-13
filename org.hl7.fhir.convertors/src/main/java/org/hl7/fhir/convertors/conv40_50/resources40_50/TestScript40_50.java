package org.hl7.fhir.convertors.conv40_50.resources40_50;

import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.CodeableConcept40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Coding40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Identifier40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.metadata40_50.ContactDetail40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.metadata40_50.UsageContext40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Boolean40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Canonical40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Code40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.DateTime40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Id40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Integer40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.MarkDown40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.String40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Uri40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.special40_50.Reference40_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CanonicalType;
import org.hl7.fhir.r5.model.TestScript.TestScriptScopeComponent;

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
public class TestScript40_50 {

  public static org.hl7.fhir.r5.model.TestScript convertTestScript(org.hl7.fhir.r4.model.TestScript src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestScript tgt = new org.hl7.fhir.r5.model.TestScript();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Extension ext : src.getExtensionsByUrl("http://hl7.org/fhir/5.0/StructureDefinition/extension-TestScript.scope")) {
      // the advisor will get this ignored.
      TestScriptScopeComponent scope = tgt.addScope();
      scope.setArtifact(ext.getExtensionString("artifact"));
      org.hl7.fhir.r4.model.Extension se = ext.getExtensionByUrl("conformance");
      if (se != null) {
        scope.setConformance(CodeableConcept40_50.convertCodeableConcept((org.hl7.fhir.r4.model.CodeableConcept) se.getValue()));
      }
      se = ext.getExtensionByUrl("phase");
      if (se != null) {
        scope.setPhase(CodeableConcept40_50.convertCodeableConcept((org.hl7.fhir.r4.model.CodeableConcept) se.getValue()));
      }
    }
    if (src.hasUrl())
      tgt.setUrlElement(Uri40_50.convertUri(src.getUrlElement()));
    if (src.hasIdentifier())
      tgt.addIdentifier(Identifier40_50.convertIdentifier(src.getIdentifier()));
    if (src.hasVersion())
      tgt.setVersionElement(String40_50.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String40_50.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String40_50.convertString(src.getTitleElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations40_50.convertPublicationStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean40_50.convertBoolean(src.getExperimentalElement()));
    if (src.hasDate())
      tgt.setDateElement(DateTime40_50.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String40_50.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.r4.model.ContactDetail t : src.getContact())
      tgt.addContact(ContactDetail40_50.convertContactDetail(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown40_50.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r4.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(UsageContext40_50.convertUsageContext(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(CodeableConcept40_50.convertCodeableConcept(t));
    if (src.hasPurpose())
      tgt.setPurposeElement(MarkDown40_50.convertMarkdown(src.getPurposeElement()));
    if (src.hasCopyright())
      tgt.setCopyrightElement(MarkDown40_50.convertMarkdown(src.getCopyrightElement()));
    for (org.hl7.fhir.r4.model.TestScript.TestScriptOriginComponent t : src.getOrigin())
      tgt.addOrigin(convertTestScriptOriginComponent(t));
    for (org.hl7.fhir.r4.model.TestScript.TestScriptDestinationComponent t : src.getDestination())
      tgt.addDestination(convertTestScriptDestinationComponent(t));
    if (src.hasMetadata())
      tgt.setMetadata(convertTestScriptMetadataComponent(src.getMetadata()));
    for (org.hl7.fhir.r4.model.TestScript.TestScriptFixtureComponent t : src.getFixture())
      tgt.addFixture(convertTestScriptFixtureComponent(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getProfile()) tgt.getProfile().add(Reference40_50.convertReferenceToCanonical(t));
    for (org.hl7.fhir.r4.model.TestScript.TestScriptVariableComponent t : src.getVariable())
      tgt.addVariable(convertTestScriptVariableComponent(t));
    if (src.hasSetup())
      tgt.setSetup(convertTestScriptSetupComponent(src.getSetup()));
    for (org.hl7.fhir.r4.model.TestScript.TestScriptTestComponent t : src.getTest())
      tgt.addTest(convertTestScriptTestComponent(t));
    if (src.hasTeardown())
      tgt.setTeardown(convertTestScriptTeardownComponent(src.getTeardown()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.TestScript convertTestScript(org.hl7.fhir.r5.model.TestScript src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.TestScript tgt = new org.hl7.fhir.r4.model.TestScript();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri40_50.convertUri(src.getUrlElement()));
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier40_50.convertIdentifier(src.getIdentifierFirstRep()));
    if (src.hasVersion())
      tgt.setVersionElement(String40_50.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String40_50.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String40_50.convertString(src.getTitleElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations40_50.convertPublicationStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean40_50.convertBoolean(src.getExperimentalElement()));
    if (src.hasDate())
      tgt.setDateElement(DateTime40_50.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String40_50.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.r5.model.ContactDetail t : src.getContact())
      tgt.addContact(ContactDetail40_50.convertContactDetail(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown40_50.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r5.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(UsageContext40_50.convertUsageContext(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(CodeableConcept40_50.convertCodeableConcept(t));
    if (src.hasPurpose())
      tgt.setPurposeElement(MarkDown40_50.convertMarkdown(src.getPurposeElement()));
    if (src.hasCopyright())
      tgt.setCopyrightElement(MarkDown40_50.convertMarkdown(src.getCopyrightElement()));
    for (org.hl7.fhir.r5.model.TestScript.TestScriptOriginComponent t : src.getOrigin())
      tgt.addOrigin(convertTestScriptOriginComponent(t));
    for (org.hl7.fhir.r5.model.TestScript.TestScriptDestinationComponent t : src.getDestination())
      tgt.addDestination(convertTestScriptDestinationComponent(t));
    if (src.hasMetadata())
      tgt.setMetadata(convertTestScriptMetadataComponent(src.getMetadata()));
    for (org.hl7.fhir.r5.model.TestScript.TestScriptFixtureComponent t : src.getFixture())
      tgt.addFixture(convertTestScriptFixtureComponent(t));
    for (CanonicalType t : src.getProfile()) tgt.addProfile(Reference40_50.convertCanonicalToReference(t));
    for (org.hl7.fhir.r5.model.TestScript.TestScriptVariableComponent t : src.getVariable())
      tgt.addVariable(convertTestScriptVariableComponent(t));
    if (src.hasSetup())
      tgt.setSetup(convertTestScriptSetupComponent(src.getSetup()));
    for (org.hl7.fhir.r5.model.TestScript.TestScriptTestComponent t : src.getTest())
      tgt.addTest(convertTestScriptTestComponent(t));
    if (src.hasTeardown())
      tgt.setTeardown(convertTestScriptTeardownComponent(src.getTeardown()));
    for (TestScriptScopeComponent scope : src.getScope()) {
      org.hl7.fhir.r4.model.Extension ext = tgt.addExtension();
      ext.setUrl("http://hl7.org/fhir/5.0/StructureDefinition/extension-TestScript.scope");
      if (scope.hasArtifact()) {
        org.hl7.fhir.r4.model.Extension se = ext.addExtension();
        se.setUrl("artifact");
        se.setValue(Canonical40_50.convertCanonical(scope.getArtifactElement()));
      }
      if (scope.hasConformance()) {
        org.hl7.fhir.r4.model.Extension se = ext.addExtension();
        se.setUrl("conformance");
        se.setValue(CodeableConcept40_50.convertCodeableConcept(scope.getConformance()));
      }
      if (scope.hasPhase()) {
        org.hl7.fhir.r4.model.Extension se = ext.addExtension();
        se.setUrl("phase");
        se.setValue(CodeableConcept40_50.convertCodeableConcept(scope.getPhase()));
      }      
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestScript.TestScriptOriginComponent convertTestScriptOriginComponent(org.hl7.fhir.r4.model.TestScript.TestScriptOriginComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestScript.TestScriptOriginComponent tgt = new org.hl7.fhir.r5.model.TestScript.TestScriptOriginComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasIndex())
      tgt.setIndexElement(Integer40_50.convertInteger(src.getIndexElement()));
    if (src.hasProfile())
      tgt.setProfile(Coding40_50.convertCoding(src.getProfile()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.TestScript.TestScriptOriginComponent convertTestScriptOriginComponent(org.hl7.fhir.r5.model.TestScript.TestScriptOriginComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.TestScript.TestScriptOriginComponent tgt = new org.hl7.fhir.r4.model.TestScript.TestScriptOriginComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasIndex())
      tgt.setIndexElement(Integer40_50.convertInteger(src.getIndexElement()));
    if (src.hasProfile())
      tgt.setProfile(Coding40_50.convertCoding(src.getProfile()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestScript.TestScriptDestinationComponent convertTestScriptDestinationComponent(org.hl7.fhir.r4.model.TestScript.TestScriptDestinationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestScript.TestScriptDestinationComponent tgt = new org.hl7.fhir.r5.model.TestScript.TestScriptDestinationComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasIndex())
      tgt.setIndexElement(Integer40_50.convertInteger(src.getIndexElement()));
    if (src.hasProfile())
      tgt.setProfile(Coding40_50.convertCoding(src.getProfile()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.TestScript.TestScriptDestinationComponent convertTestScriptDestinationComponent(org.hl7.fhir.r5.model.TestScript.TestScriptDestinationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.TestScript.TestScriptDestinationComponent tgt = new org.hl7.fhir.r4.model.TestScript.TestScriptDestinationComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasIndex())
      tgt.setIndexElement(Integer40_50.convertInteger(src.getIndexElement()));
    if (src.hasProfile())
      tgt.setProfile(Coding40_50.convertCoding(src.getProfile()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestScript.TestScriptMetadataComponent convertTestScriptMetadataComponent(org.hl7.fhir.r4.model.TestScript.TestScriptMetadataComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestScript.TestScriptMetadataComponent tgt = new org.hl7.fhir.r5.model.TestScript.TestScriptMetadataComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r4.model.TestScript.TestScriptMetadataLinkComponent t : src.getLink())
      tgt.addLink(convertTestScriptMetadataLinkComponent(t));
    for (org.hl7.fhir.r4.model.TestScript.TestScriptMetadataCapabilityComponent t : src.getCapability())
      tgt.addCapability(convertTestScriptMetadataCapabilityComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.TestScript.TestScriptMetadataComponent convertTestScriptMetadataComponent(org.hl7.fhir.r5.model.TestScript.TestScriptMetadataComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.TestScript.TestScriptMetadataComponent tgt = new org.hl7.fhir.r4.model.TestScript.TestScriptMetadataComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r5.model.TestScript.TestScriptMetadataLinkComponent t : src.getLink())
      tgt.addLink(convertTestScriptMetadataLinkComponent(t));
    for (org.hl7.fhir.r5.model.TestScript.TestScriptMetadataCapabilityComponent t : src.getCapability())
      tgt.addCapability(convertTestScriptMetadataCapabilityComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestScript.TestScriptMetadataLinkComponent convertTestScriptMetadataLinkComponent(org.hl7.fhir.r4.model.TestScript.TestScriptMetadataLinkComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestScript.TestScriptMetadataLinkComponent tgt = new org.hl7.fhir.r5.model.TestScript.TestScriptMetadataLinkComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri40_50.convertUri(src.getUrlElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_50.convertString(src.getDescriptionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.TestScript.TestScriptMetadataLinkComponent convertTestScriptMetadataLinkComponent(org.hl7.fhir.r5.model.TestScript.TestScriptMetadataLinkComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.TestScript.TestScriptMetadataLinkComponent tgt = new org.hl7.fhir.r4.model.TestScript.TestScriptMetadataLinkComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri40_50.convertUri(src.getUrlElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_50.convertString(src.getDescriptionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestScript.TestScriptMetadataCapabilityComponent convertTestScriptMetadataCapabilityComponent(org.hl7.fhir.r4.model.TestScript.TestScriptMetadataCapabilityComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestScript.TestScriptMetadataCapabilityComponent tgt = new org.hl7.fhir.r5.model.TestScript.TestScriptMetadataCapabilityComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasRequired())
      tgt.setRequiredElement(Boolean40_50.convertBoolean(src.getRequiredElement()));
    if (src.hasValidated())
      tgt.setValidatedElement(Boolean40_50.convertBoolean(src.getValidatedElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_50.convertString(src.getDescriptionElement()));
    for (org.hl7.fhir.r4.model.IntegerType t : src.getOrigin()) tgt.getOrigin().add(Integer40_50.convertInteger(t));
    if (src.hasDestination())
      tgt.setDestinationElement(Integer40_50.convertInteger(src.getDestinationElement()));
    for (org.hl7.fhir.r4.model.UriType t : src.getLink()) tgt.getLink().add(Uri40_50.convertUri(t));
    if (src.hasCapabilities())
      tgt.setCapabilitiesElement(Canonical40_50.convertCanonical(src.getCapabilitiesElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.TestScript.TestScriptMetadataCapabilityComponent convertTestScriptMetadataCapabilityComponent(org.hl7.fhir.r5.model.TestScript.TestScriptMetadataCapabilityComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.TestScript.TestScriptMetadataCapabilityComponent tgt = new org.hl7.fhir.r4.model.TestScript.TestScriptMetadataCapabilityComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasRequired())
      tgt.setRequiredElement(Boolean40_50.convertBoolean(src.getRequiredElement()));
    if (src.hasValidated())
      tgt.setValidatedElement(Boolean40_50.convertBoolean(src.getValidatedElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_50.convertString(src.getDescriptionElement()));
    for (org.hl7.fhir.r5.model.IntegerType t : src.getOrigin()) tgt.getOrigin().add(Integer40_50.convertInteger(t));
    if (src.hasDestination())
      tgt.setDestinationElement(Integer40_50.convertInteger(src.getDestinationElement()));
    for (org.hl7.fhir.r5.model.UriType t : src.getLink()) tgt.getLink().add(Uri40_50.convertUri(t));
    if (src.hasCapabilities())
      tgt.setCapabilitiesElement(Canonical40_50.convertCanonical(src.getCapabilitiesElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestScript.TestScriptFixtureComponent convertTestScriptFixtureComponent(org.hl7.fhir.r4.model.TestScript.TestScriptFixtureComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestScript.TestScriptFixtureComponent tgt = new org.hl7.fhir.r5.model.TestScript.TestScriptFixtureComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasAutocreate())
      tgt.setAutocreateElement(Boolean40_50.convertBoolean(src.getAutocreateElement()));
    if (src.hasAutodelete())
      tgt.setAutodeleteElement(Boolean40_50.convertBoolean(src.getAutodeleteElement()));
    if (src.hasResource())
      tgt.setResource(Reference40_50.convertReference(src.getResource()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.TestScript.TestScriptFixtureComponent convertTestScriptFixtureComponent(org.hl7.fhir.r5.model.TestScript.TestScriptFixtureComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.TestScript.TestScriptFixtureComponent tgt = new org.hl7.fhir.r4.model.TestScript.TestScriptFixtureComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasAutocreate())
      tgt.setAutocreateElement(Boolean40_50.convertBoolean(src.getAutocreateElement()));
    if (src.hasAutodelete())
      tgt.setAutodeleteElement(Boolean40_50.convertBoolean(src.getAutodeleteElement()));
    if (src.hasResource())
      tgt.setResource(Reference40_50.convertReference(src.getResource()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestScript.TestScriptVariableComponent convertTestScriptVariableComponent(org.hl7.fhir.r4.model.TestScript.TestScriptVariableComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestScript.TestScriptVariableComponent tgt = new org.hl7.fhir.r5.model.TestScript.TestScriptVariableComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String40_50.convertString(src.getNameElement()));
    if (src.hasDefaultValue())
      tgt.setDefaultValueElement(String40_50.convertString(src.getDefaultValueElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_50.convertString(src.getDescriptionElement()));
    if (src.hasExpression())
      tgt.setExpressionElement(String40_50.convertString(src.getExpressionElement()));
    if (src.hasHeaderField())
      tgt.setHeaderFieldElement(String40_50.convertString(src.getHeaderFieldElement()));
    if (src.hasHint())
      tgt.setHintElement(String40_50.convertString(src.getHintElement()));
    if (src.hasPath())
      tgt.setPathElement(String40_50.convertString(src.getPathElement()));
    if (src.hasSourceId())
      tgt.setSourceIdElement(Id40_50.convertId(src.getSourceIdElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.TestScript.TestScriptVariableComponent convertTestScriptVariableComponent(org.hl7.fhir.r5.model.TestScript.TestScriptVariableComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.TestScript.TestScriptVariableComponent tgt = new org.hl7.fhir.r4.model.TestScript.TestScriptVariableComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String40_50.convertString(src.getNameElement()));
    if (src.hasDefaultValue())
      tgt.setDefaultValueElement(String40_50.convertString(src.getDefaultValueElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_50.convertString(src.getDescriptionElement()));
    if (src.hasExpression())
      tgt.setExpressionElement(String40_50.convertString(src.getExpressionElement()));
    if (src.hasHeaderField())
      tgt.setHeaderFieldElement(String40_50.convertString(src.getHeaderFieldElement()));
    if (src.hasHint())
      tgt.setHintElement(String40_50.convertString(src.getHintElement()));
    if (src.hasPath())
      tgt.setPathElement(String40_50.convertString(src.getPathElement()));
    if (src.hasSourceId())
      tgt.setSourceIdElement(Id40_50.convertId(src.getSourceIdElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestScript.TestScriptSetupComponent convertTestScriptSetupComponent(org.hl7.fhir.r4.model.TestScript.TestScriptSetupComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestScript.TestScriptSetupComponent tgt = new org.hl7.fhir.r5.model.TestScript.TestScriptSetupComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r4.model.TestScript.SetupActionComponent t : src.getAction())
      tgt.addAction(convertSetupActionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.TestScript.TestScriptSetupComponent convertTestScriptSetupComponent(org.hl7.fhir.r5.model.TestScript.TestScriptSetupComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.TestScript.TestScriptSetupComponent tgt = new org.hl7.fhir.r4.model.TestScript.TestScriptSetupComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r5.model.TestScript.SetupActionComponent t : src.getAction())
      tgt.addAction(convertSetupActionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestScript.SetupActionComponent convertSetupActionComponent(org.hl7.fhir.r4.model.TestScript.SetupActionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestScript.SetupActionComponent tgt = new org.hl7.fhir.r5.model.TestScript.SetupActionComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasOperation())
      tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    if (src.hasAssert())
      tgt.setAssert(convertSetupActionAssertComponent(src.getAssert()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.TestScript.SetupActionComponent convertSetupActionComponent(org.hl7.fhir.r5.model.TestScript.SetupActionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.TestScript.SetupActionComponent tgt = new org.hl7.fhir.r4.model.TestScript.SetupActionComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasOperation())
      tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    if (src.hasAssert())
      tgt.setAssert(convertSetupActionAssertComponent(src.getAssert()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestScript.SetupActionOperationComponent convertSetupActionOperationComponent(org.hl7.fhir.r4.model.TestScript.SetupActionOperationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestScript.SetupActionOperationComponent tgt = new org.hl7.fhir.r5.model.TestScript.SetupActionOperationComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(Coding40_50.convertCoding(src.getType()));
    if (src.hasResource())
      tgt.setResource(src.getResource());
    if (src.hasLabel())
      tgt.setLabelElement(String40_50.convertString(src.getLabelElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_50.convertString(src.getDescriptionElement()));
    if (src.hasAccept())
      tgt.setAcceptElement(Code40_50.convertCode(src.getAcceptElement()));
    if (src.hasContentType())
      tgt.setContentTypeElement(Code40_50.convertCode(src.getContentTypeElement()));
    if (src.hasDestination())
      tgt.setDestinationElement(Integer40_50.convertInteger(src.getDestinationElement()));
    if (src.hasEncodeRequestUrl())
      tgt.setEncodeRequestUrlElement(Boolean40_50.convertBoolean(src.getEncodeRequestUrlElement()));
    if (src.hasMethod())
      tgt.setMethodElement(convertTestScriptRequestMethodCode(src.getMethodElement()));
    if (src.hasOrigin())
      tgt.setOriginElement(Integer40_50.convertInteger(src.getOriginElement()));
    if (src.hasParams())
      tgt.setParamsElement(String40_50.convertString(src.getParamsElement()));
    for (org.hl7.fhir.r4.model.TestScript.SetupActionOperationRequestHeaderComponent t : src.getRequestHeader())
      tgt.addRequestHeader(convertSetupActionOperationRequestHeaderComponent(t));
    if (src.hasRequestId())
      tgt.setRequestIdElement(Id40_50.convertId(src.getRequestIdElement()));
    if (src.hasResponseId())
      tgt.setResponseIdElement(Id40_50.convertId(src.getResponseIdElement()));
    if (src.hasSourceId())
      tgt.setSourceIdElement(Id40_50.convertId(src.getSourceIdElement()));
    if (src.hasTargetId())
      tgt.setTargetIdElement(Id40_50.convertId(src.getTargetIdElement()));
    if (src.hasUrl())
      tgt.setUrlElement(String40_50.convertString(src.getUrlElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.TestScript.SetupActionOperationComponent convertSetupActionOperationComponent(org.hl7.fhir.r5.model.TestScript.SetupActionOperationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.TestScript.SetupActionOperationComponent tgt = new org.hl7.fhir.r4.model.TestScript.SetupActionOperationComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(Coding40_50.convertCoding(src.getType()));
    if (src.hasResource())
      tgt.setResource(src.getResource());
    if (src.hasLabel())
      tgt.setLabelElement(String40_50.convertString(src.getLabelElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_50.convertString(src.getDescriptionElement()));
    if (src.hasAccept())
      tgt.setAcceptElement(Code40_50.convertCode(src.getAcceptElement()));
    if (src.hasContentType())
      tgt.setContentTypeElement(Code40_50.convertCode(src.getContentTypeElement()));
    if (src.hasDestination())
      tgt.setDestinationElement(Integer40_50.convertInteger(src.getDestinationElement()));
    if (src.hasEncodeRequestUrl())
      tgt.setEncodeRequestUrlElement(Boolean40_50.convertBoolean(src.getEncodeRequestUrlElement()));
    if (src.hasMethod())
      tgt.setMethodElement(convertTestScriptRequestMethodCode(src.getMethodElement()));
    if (src.hasOrigin())
      tgt.setOriginElement(Integer40_50.convertInteger(src.getOriginElement()));
    if (src.hasParams())
      tgt.setParamsElement(String40_50.convertString(src.getParamsElement()));
    for (org.hl7.fhir.r5.model.TestScript.SetupActionOperationRequestHeaderComponent t : src.getRequestHeader())
      tgt.addRequestHeader(convertSetupActionOperationRequestHeaderComponent(t));
    if (src.hasRequestId())
      tgt.setRequestIdElement(Id40_50.convertId(src.getRequestIdElement()));
    if (src.hasResponseId())
      tgt.setResponseIdElement(Id40_50.convertId(src.getResponseIdElement()));
    if (src.hasSourceId())
      tgt.setSourceIdElement(Id40_50.convertId(src.getSourceIdElement()));
    if (src.hasTargetId())
      tgt.setTargetIdElement(Id40_50.convertId(src.getTargetIdElement()));
    if (src.hasUrl())
      tgt.setUrlElement(String40_50.convertString(src.getUrlElement()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestScript.TestScriptRequestMethodCode> convertTestScriptRequestMethodCode(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TestScript.TestScriptRequestMethodCode> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestScript.TestScriptRequestMethodCode> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.TestScript.TestScriptRequestMethodCodeEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case DELETE:
        tgt.setValue(org.hl7.fhir.r5.model.TestScript.TestScriptRequestMethodCode.DELETE);
        break;
      case GET:
        tgt.setValue(org.hl7.fhir.r5.model.TestScript.TestScriptRequestMethodCode.GET);
        break;
      case OPTIONS:
        tgt.setValue(org.hl7.fhir.r5.model.TestScript.TestScriptRequestMethodCode.OPTIONS);
        break;
      case PATCH:
        tgt.setValue(org.hl7.fhir.r5.model.TestScript.TestScriptRequestMethodCode.PATCH);
        break;
      case POST:
        tgt.setValue(org.hl7.fhir.r5.model.TestScript.TestScriptRequestMethodCode.POST);
        break;
      case PUT:
        tgt.setValue(org.hl7.fhir.r5.model.TestScript.TestScriptRequestMethodCode.PUT);
        break;
      case HEAD:
        tgt.setValue(org.hl7.fhir.r5.model.TestScript.TestScriptRequestMethodCode.HEAD);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.TestScript.TestScriptRequestMethodCode.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TestScript.TestScriptRequestMethodCode> convertTestScriptRequestMethodCode(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestScript.TestScriptRequestMethodCode> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TestScript.TestScriptRequestMethodCode> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.TestScript.TestScriptRequestMethodCodeEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case DELETE:
        tgt.setValue(org.hl7.fhir.r4.model.TestScript.TestScriptRequestMethodCode.DELETE);
        break;
      case GET:
        tgt.setValue(org.hl7.fhir.r4.model.TestScript.TestScriptRequestMethodCode.GET);
        break;
      case OPTIONS:
        tgt.setValue(org.hl7.fhir.r4.model.TestScript.TestScriptRequestMethodCode.OPTIONS);
        break;
      case PATCH:
        tgt.setValue(org.hl7.fhir.r4.model.TestScript.TestScriptRequestMethodCode.PATCH);
        break;
      case POST:
        tgt.setValue(org.hl7.fhir.r4.model.TestScript.TestScriptRequestMethodCode.POST);
        break;
      case PUT:
        tgt.setValue(org.hl7.fhir.r4.model.TestScript.TestScriptRequestMethodCode.PUT);
        break;
      case HEAD:
        tgt.setValue(org.hl7.fhir.r4.model.TestScript.TestScriptRequestMethodCode.HEAD);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.TestScript.TestScriptRequestMethodCode.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestScript.SetupActionOperationRequestHeaderComponent convertSetupActionOperationRequestHeaderComponent(org.hl7.fhir.r4.model.TestScript.SetupActionOperationRequestHeaderComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestScript.SetupActionOperationRequestHeaderComponent tgt = new org.hl7.fhir.r5.model.TestScript.SetupActionOperationRequestHeaderComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasField())
      tgt.setFieldElement(String40_50.convertString(src.getFieldElement()));
    if (src.hasValue())
      tgt.setValueElement(String40_50.convertString(src.getValueElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.TestScript.SetupActionOperationRequestHeaderComponent convertSetupActionOperationRequestHeaderComponent(org.hl7.fhir.r5.model.TestScript.SetupActionOperationRequestHeaderComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.TestScript.SetupActionOperationRequestHeaderComponent tgt = new org.hl7.fhir.r4.model.TestScript.SetupActionOperationRequestHeaderComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasField())
      tgt.setFieldElement(String40_50.convertString(src.getFieldElement()));
    if (src.hasValue())
      tgt.setValueElement(String40_50.convertString(src.getValueElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestScript.SetupActionAssertComponent convertSetupActionAssertComponent(org.hl7.fhir.r4.model.TestScript.SetupActionAssertComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestScript.SetupActionAssertComponent tgt = new org.hl7.fhir.r5.model.TestScript.SetupActionAssertComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasLabel())
      tgt.setLabelElement(String40_50.convertString(src.getLabelElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_50.convertString(src.getDescriptionElement()));
    if (src.hasDirection())
      tgt.setDirectionElement(convertAssertionDirectionType(src.getDirectionElement()));
    if (src.hasCompareToSourceId())
      tgt.setCompareToSourceIdElement(String40_50.convertString(src.getCompareToSourceIdElement()));
    if (src.hasCompareToSourceExpression())
      tgt.setCompareToSourceExpressionElement(String40_50.convertString(src.getCompareToSourceExpressionElement()));
    if (src.hasCompareToSourcePath())
      tgt.setCompareToSourcePathElement(String40_50.convertString(src.getCompareToSourcePathElement()));
    if (src.hasContentType())
      tgt.setContentTypeElement(Code40_50.convertCode(src.getContentTypeElement()));
    if (src.hasExpression())
      tgt.setExpressionElement(String40_50.convertString(src.getExpressionElement()));
    if (src.hasHeaderField())
      tgt.setHeaderFieldElement(String40_50.convertString(src.getHeaderFieldElement()));
    if (src.hasMinimumId())
      tgt.setMinimumIdElement(String40_50.convertString(src.getMinimumIdElement()));
    if (src.hasNavigationLinks())
      tgt.setNavigationLinksElement(Boolean40_50.convertBoolean(src.getNavigationLinksElement()));
    if (src.hasOperator())
      tgt.setOperatorElement(convertAssertionOperatorType(src.getOperatorElement()));
    if (src.hasPath())
      tgt.setPathElement(String40_50.convertString(src.getPathElement()));
    if (src.hasRequestMethod())
      tgt.setRequestMethodElement(convertTestScriptRequestMethodCode(src.getRequestMethodElement()));
    if (src.hasRequestURL())
      tgt.setRequestURLElement(String40_50.convertString(src.getRequestURLElement()));
    if (src.hasResource())
      tgt.setResource(src.getResource());
    if (src.hasResponse())
      tgt.setResponseElement(convertAssertionResponseTypes(src.getResponseElement()));
    if (src.hasResponseCode())
      tgt.setResponseCodeElement(String40_50.convertString(src.getResponseCodeElement()));
    if (src.hasSourceId())
      tgt.setSourceIdElement(Id40_50.convertId(src.getSourceIdElement()));
    if (src.hasValidateProfileId())
      tgt.setValidateProfileIdElement(Id40_50.convertId(src.getValidateProfileIdElement()));
    if (src.hasValue())
      tgt.setValueElement(String40_50.convertString(src.getValueElement()));
    if (src.hasWarningOnly())
      tgt.setWarningOnlyElement(Boolean40_50.convertBoolean(src.getWarningOnlyElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.TestScript.SetupActionAssertComponent convertSetupActionAssertComponent(org.hl7.fhir.r5.model.TestScript.SetupActionAssertComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.TestScript.SetupActionAssertComponent tgt = new org.hl7.fhir.r4.model.TestScript.SetupActionAssertComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasLabel())
      tgt.setLabelElement(String40_50.convertString(src.getLabelElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_50.convertString(src.getDescriptionElement()));
    if (src.hasDirection())
      tgt.setDirectionElement(convertAssertionDirectionType(src.getDirectionElement()));
    if (src.hasCompareToSourceId())
      tgt.setCompareToSourceIdElement(String40_50.convertString(src.getCompareToSourceIdElement()));
    if (src.hasCompareToSourceExpression())
      tgt.setCompareToSourceExpressionElement(String40_50.convertString(src.getCompareToSourceExpressionElement()));
    if (src.hasCompareToSourcePath())
      tgt.setCompareToSourcePathElement(String40_50.convertString(src.getCompareToSourcePathElement()));
    if (src.hasContentType())
      tgt.setContentTypeElement(Code40_50.convertCode(src.getContentTypeElement()));
    if (src.hasExpression())
      tgt.setExpressionElement(String40_50.convertString(src.getExpressionElement()));
    if (src.hasHeaderField())
      tgt.setHeaderFieldElement(String40_50.convertString(src.getHeaderFieldElement()));
    if (src.hasMinimumId())
      tgt.setMinimumIdElement(String40_50.convertString(src.getMinimumIdElement()));
    if (src.hasNavigationLinks())
      tgt.setNavigationLinksElement(Boolean40_50.convertBoolean(src.getNavigationLinksElement()));
    if (src.hasOperator())
      tgt.setOperatorElement(convertAssertionOperatorType(src.getOperatorElement()));
    if (src.hasPath())
      tgt.setPathElement(String40_50.convertString(src.getPathElement()));
    if (src.hasRequestMethod())
      tgt.setRequestMethodElement(convertTestScriptRequestMethodCode(src.getRequestMethodElement()));
    if (src.hasRequestURL())
      tgt.setRequestURLElement(String40_50.convertString(src.getRequestURLElement()));
    if (src.hasResource())
      tgt.setResource(src.getResource());
    if (src.hasResponse())
      tgt.setResponseElement(convertAssertionResponseTypes(src.getResponseElement()));
    if (src.hasResponseCode())
      tgt.setResponseCodeElement(String40_50.convertString(src.getResponseCodeElement()));
    if (src.hasSourceId())
      tgt.setSourceIdElement(Id40_50.convertId(src.getSourceIdElement()));
    if (src.hasValidateProfileId())
      tgt.setValidateProfileIdElement(Id40_50.convertId(src.getValidateProfileIdElement()));
    if (src.hasValue())
      tgt.setValueElement(String40_50.convertString(src.getValueElement()));
    if (src.hasWarningOnly())
      tgt.setWarningOnlyElement(Boolean40_50.convertBoolean(src.getWarningOnlyElement()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestScript.AssertionDirectionType> convertAssertionDirectionType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TestScript.AssertionDirectionType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestScript.AssertionDirectionType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.TestScript.AssertionDirectionTypeEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case RESPONSE:
        tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionDirectionType.RESPONSE);
        break;
      case REQUEST:
        tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionDirectionType.REQUEST);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionDirectionType.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TestScript.AssertionDirectionType> convertAssertionDirectionType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestScript.AssertionDirectionType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TestScript.AssertionDirectionType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.TestScript.AssertionDirectionTypeEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case RESPONSE:
        tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionDirectionType.RESPONSE);
        break;
      case REQUEST:
        tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionDirectionType.REQUEST);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionDirectionType.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestScript.AssertionOperatorType> convertAssertionOperatorType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TestScript.AssertionOperatorType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestScript.AssertionOperatorType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.TestScript.AssertionOperatorTypeEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case EQUALS:
        tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionOperatorType.EQUALS);
        break;
      case NOTEQUALS:
        tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionOperatorType.NOTEQUALS);
        break;
      case IN:
        tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionOperatorType.IN);
        break;
      case NOTIN:
        tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionOperatorType.NOTIN);
        break;
      case GREATERTHAN:
        tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionOperatorType.GREATERTHAN);
        break;
      case LESSTHAN:
        tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionOperatorType.LESSTHAN);
        break;
      case EMPTY:
        tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionOperatorType.EMPTY);
        break;
      case NOTEMPTY:
        tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionOperatorType.NOTEMPTY);
        break;
      case CONTAINS:
        tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionOperatorType.CONTAINS);
        break;
      case NOTCONTAINS:
        tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionOperatorType.NOTCONTAINS);
        break;
      case EVAL:
        tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionOperatorType.EVAL);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionOperatorType.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TestScript.AssertionOperatorType> convertAssertionOperatorType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestScript.AssertionOperatorType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TestScript.AssertionOperatorType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.TestScript.AssertionOperatorTypeEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case EQUALS:
        tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionOperatorType.EQUALS);
        break;
      case NOTEQUALS:
        tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionOperatorType.NOTEQUALS);
        break;
      case IN:
        tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionOperatorType.IN);
        break;
      case NOTIN:
        tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionOperatorType.NOTIN);
        break;
      case GREATERTHAN:
        tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionOperatorType.GREATERTHAN);
        break;
      case LESSTHAN:
        tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionOperatorType.LESSTHAN);
        break;
      case EMPTY:
        tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionOperatorType.EMPTY);
        break;
      case NOTEMPTY:
        tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionOperatorType.NOTEMPTY);
        break;
      case CONTAINS:
        tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionOperatorType.CONTAINS);
        break;
      case NOTCONTAINS:
        tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionOperatorType.NOTCONTAINS);
        break;
      case EVAL:
        tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionOperatorType.EVAL);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionOperatorType.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestScript.AssertionResponseTypes> convertAssertionResponseTypes(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TestScript.AssertionResponseTypes> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestScript.AssertionResponseTypes> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.TestScript.AssertionResponseTypesEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case OKAY:
        tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionResponseTypes.OKAY);
        break;
      case CREATED:
        tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionResponseTypes.CREATED);
        break;
      case NOCONTENT:
        tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionResponseTypes.NOCONTENT);
        break;
      case NOTMODIFIED:
        tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionResponseTypes.NOTMODIFIED);
        break;
      case BAD:
        tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionResponseTypes.BAD);
        break;
      case FORBIDDEN:
        tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionResponseTypes.FORBIDDEN);
        break;
      case NOTFOUND:
        tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionResponseTypes.NOTFOUND);
        break;
      case METHODNOTALLOWED:
        tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionResponseTypes.METHODNOTALLOWED);
        break;
      case CONFLICT:
        tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionResponseTypes.CONFLICT);
        break;
      case GONE:
        tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionResponseTypes.GONE);
        break;
      case PRECONDITIONFAILED:
        tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionResponseTypes.PRECONDITIONFAILED);
        break;
      case UNPROCESSABLE:
        tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionResponseTypes.UNPROCESSABLE);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionResponseTypes.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TestScript.AssertionResponseTypes> convertAssertionResponseTypes(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestScript.AssertionResponseTypes> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TestScript.AssertionResponseTypes> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.TestScript.AssertionResponseTypesEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case OKAY:
        tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionResponseTypes.OKAY);
        break;
      case CREATED:
        tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionResponseTypes.CREATED);
        break;
      case NOCONTENT:
        tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionResponseTypes.NOCONTENT);
        break;
      case NOTMODIFIED:
        tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionResponseTypes.NOTMODIFIED);
        break;
      case BAD:
        tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionResponseTypes.BAD);
        break;
      case FORBIDDEN:
        tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionResponseTypes.FORBIDDEN);
        break;
      case NOTFOUND:
        tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionResponseTypes.NOTFOUND);
        break;
      case METHODNOTALLOWED:
        tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionResponseTypes.METHODNOTALLOWED);
        break;
      case CONFLICT:
        tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionResponseTypes.CONFLICT);
        break;
      case GONE:
        tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionResponseTypes.GONE);
        break;
      case PRECONDITIONFAILED:
        tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionResponseTypes.PRECONDITIONFAILED);
        break;
      case UNPROCESSABLE:
        tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionResponseTypes.UNPROCESSABLE);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionResponseTypes.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestScript.TestScriptTestComponent convertTestScriptTestComponent(org.hl7.fhir.r4.model.TestScript.TestScriptTestComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestScript.TestScriptTestComponent tgt = new org.hl7.fhir.r5.model.TestScript.TestScriptTestComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String40_50.convertString(src.getNameElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_50.convertString(src.getDescriptionElement()));
    for (org.hl7.fhir.r4.model.TestScript.TestActionComponent t : src.getAction())
      tgt.addAction(convertTestActionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.TestScript.TestScriptTestComponent convertTestScriptTestComponent(org.hl7.fhir.r5.model.TestScript.TestScriptTestComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.TestScript.TestScriptTestComponent tgt = new org.hl7.fhir.r4.model.TestScript.TestScriptTestComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String40_50.convertString(src.getNameElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_50.convertString(src.getDescriptionElement()));
    for (org.hl7.fhir.r5.model.TestScript.TestActionComponent t : src.getAction())
      tgt.addAction(convertTestActionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestScript.TestActionComponent convertTestActionComponent(org.hl7.fhir.r4.model.TestScript.TestActionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestScript.TestActionComponent tgt = new org.hl7.fhir.r5.model.TestScript.TestActionComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasOperation())
      tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    if (src.hasAssert())
      tgt.setAssert(convertSetupActionAssertComponent(src.getAssert()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.TestScript.TestActionComponent convertTestActionComponent(org.hl7.fhir.r5.model.TestScript.TestActionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.TestScript.TestActionComponent tgt = new org.hl7.fhir.r4.model.TestScript.TestActionComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasOperation())
      tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    if (src.hasAssert())
      tgt.setAssert(convertSetupActionAssertComponent(src.getAssert()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestScript.TestScriptTeardownComponent convertTestScriptTeardownComponent(org.hl7.fhir.r4.model.TestScript.TestScriptTeardownComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestScript.TestScriptTeardownComponent tgt = new org.hl7.fhir.r5.model.TestScript.TestScriptTeardownComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r4.model.TestScript.TeardownActionComponent t : src.getAction())
      tgt.addAction(convertTeardownActionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.TestScript.TestScriptTeardownComponent convertTestScriptTeardownComponent(org.hl7.fhir.r5.model.TestScript.TestScriptTeardownComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.TestScript.TestScriptTeardownComponent tgt = new org.hl7.fhir.r4.model.TestScript.TestScriptTeardownComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r5.model.TestScript.TeardownActionComponent t : src.getAction())
      tgt.addAction(convertTeardownActionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestScript.TeardownActionComponent convertTeardownActionComponent(org.hl7.fhir.r4.model.TestScript.TeardownActionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestScript.TeardownActionComponent tgt = new org.hl7.fhir.r5.model.TestScript.TeardownActionComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasOperation())
      tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.TestScript.TeardownActionComponent convertTeardownActionComponent(org.hl7.fhir.r5.model.TestScript.TeardownActionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.TestScript.TeardownActionComponent tgt = new org.hl7.fhir.r4.model.TestScript.TeardownActionComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasOperation())
      tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    return tgt;
  }
}