package org.hl7.fhir.convertors.conv40_50;


import org.hl7.fhir.convertors.VersionConvertor_40_50;
import org.hl7.fhir.exceptions.FHIRException;

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
public class TestScript40_50 extends VersionConvertor_40_50 {

    public static org.hl7.fhir.r5.model.TestScript convertTestScript(org.hl7.fhir.r4.model.TestScript src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.TestScript tgt = new org.hl7.fhir.r5.model.TestScript();
        copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrlElement(convertUri(src.getUrlElement()));
        if (src.hasIdentifier())
            tgt.addIdentifier(convertIdentifier(src.getIdentifier()));
        if (src.hasVersion())
            tgt.setVersionElement(convertString(src.getVersionElement()));
        if (src.hasName())
            tgt.setNameElement(convertString(src.getNameElement()));
        if (src.hasTitle())
            tgt.setTitleElement(convertString(src.getTitleElement()));
        if (src.hasStatus())
            tgt.setStatusElement(Enumerations40_50.convertPublicationStatus(src.getStatusElement()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(convertBoolean(src.getExperimentalElement()));
        if (src.hasDate())
            tgt.setDateElement(convertDateTime(src.getDateElement()));
        if (src.hasPublisher())
            tgt.setPublisherElement(convertString(src.getPublisherElement()));
        for (org.hl7.fhir.r4.model.ContactDetail t : src.getContact()) tgt.addContact(convertContactDetail(t));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertMarkdown(src.getDescriptionElement()));
        for (org.hl7.fhir.r4.model.UsageContext t : src.getUseContext()) tgt.addUseContext(convertUsageContext(t));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(convertCodeableConcept(t));
        if (src.hasPurpose())
            tgt.setPurposeElement(convertMarkdown(src.getPurposeElement()));
        if (src.hasCopyright())
            tgt.setCopyrightElement(convertMarkdown(src.getCopyrightElement()));
        for (org.hl7.fhir.r4.model.TestScript.TestScriptOriginComponent t : src.getOrigin()) tgt.addOrigin(convertTestScriptOriginComponent(t));
        for (org.hl7.fhir.r4.model.TestScript.TestScriptDestinationComponent t : src.getDestination()) tgt.addDestination(convertTestScriptDestinationComponent(t));
        if (src.hasMetadata())
            tgt.setMetadata(convertTestScriptMetadataComponent(src.getMetadata()));
        for (org.hl7.fhir.r4.model.TestScript.TestScriptFixtureComponent t : src.getFixture()) tgt.addFixture(convertTestScriptFixtureComponent(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getProfile()) tgt.addProfile(convertReference(t));
        for (org.hl7.fhir.r4.model.TestScript.TestScriptVariableComponent t : src.getVariable()) tgt.addVariable(convertTestScriptVariableComponent(t));
        if (src.hasSetup())
            tgt.setSetup(convertTestScriptSetupComponent(src.getSetup()));
        for (org.hl7.fhir.r4.model.TestScript.TestScriptTestComponent t : src.getTest()) tgt.addTest(convertTestScriptTestComponent(t));
        if (src.hasTeardown())
            tgt.setTeardown(convertTestScriptTeardownComponent(src.getTeardown()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.TestScript convertTestScript(org.hl7.fhir.r5.model.TestScript src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.TestScript tgt = new org.hl7.fhir.r4.model.TestScript();
        copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrlElement(convertUri(src.getUrlElement()));
        if (src.hasIdentifier())
            tgt.setIdentifier(convertIdentifier(src.getIdentifierFirstRep()));
        if (src.hasVersion())
            tgt.setVersionElement(convertString(src.getVersionElement()));
        if (src.hasName())
            tgt.setNameElement(convertString(src.getNameElement()));
        if (src.hasTitle())
            tgt.setTitleElement(convertString(src.getTitleElement()));
        if (src.hasStatus())
            tgt.setStatusElement(Enumerations40_50.convertPublicationStatus(src.getStatusElement()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(convertBoolean(src.getExperimentalElement()));
        if (src.hasDate())
            tgt.setDateElement(convertDateTime(src.getDateElement()));
        if (src.hasPublisher())
            tgt.setPublisherElement(convertString(src.getPublisherElement()));
        for (org.hl7.fhir.r5.model.ContactDetail t : src.getContact()) tgt.addContact(convertContactDetail(t));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertMarkdown(src.getDescriptionElement()));
        for (org.hl7.fhir.r5.model.UsageContext t : src.getUseContext()) tgt.addUseContext(convertUsageContext(t));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(convertCodeableConcept(t));
        if (src.hasPurpose())
            tgt.setPurposeElement(convertMarkdown(src.getPurposeElement()));
        if (src.hasCopyright())
            tgt.setCopyrightElement(convertMarkdown(src.getCopyrightElement()));
        for (org.hl7.fhir.r5.model.TestScript.TestScriptOriginComponent t : src.getOrigin()) tgt.addOrigin(convertTestScriptOriginComponent(t));
        for (org.hl7.fhir.r5.model.TestScript.TestScriptDestinationComponent t : src.getDestination()) tgt.addDestination(convertTestScriptDestinationComponent(t));
        if (src.hasMetadata())
            tgt.setMetadata(convertTestScriptMetadataComponent(src.getMetadata()));
        for (org.hl7.fhir.r5.model.TestScript.TestScriptFixtureComponent t : src.getFixture()) tgt.addFixture(convertTestScriptFixtureComponent(t));
        for (org.hl7.fhir.r5.model.Reference t : src.getProfile()) tgt.addProfile(convertReference(t));
        for (org.hl7.fhir.r5.model.TestScript.TestScriptVariableComponent t : src.getVariable()) tgt.addVariable(convertTestScriptVariableComponent(t));
        if (src.hasSetup())
            tgt.setSetup(convertTestScriptSetupComponent(src.getSetup()));
        for (org.hl7.fhir.r5.model.TestScript.TestScriptTestComponent t : src.getTest()) tgt.addTest(convertTestScriptTestComponent(t));
        if (src.hasTeardown())
            tgt.setTeardown(convertTestScriptTeardownComponent(src.getTeardown()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.TestScript.TestScriptOriginComponent convertTestScriptOriginComponent(org.hl7.fhir.r4.model.TestScript.TestScriptOriginComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.TestScript.TestScriptOriginComponent tgt = new org.hl7.fhir.r5.model.TestScript.TestScriptOriginComponent();
        copyElement(src, tgt);
        if (src.hasIndex())
            tgt.setIndexElement(convertInteger(src.getIndexElement()));
        if (src.hasProfile())
            tgt.setProfile(convertCoding(src.getProfile()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.TestScript.TestScriptOriginComponent convertTestScriptOriginComponent(org.hl7.fhir.r5.model.TestScript.TestScriptOriginComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.TestScript.TestScriptOriginComponent tgt = new org.hl7.fhir.r4.model.TestScript.TestScriptOriginComponent();
        copyElement(src, tgt);
        if (src.hasIndex())
            tgt.setIndexElement(convertInteger(src.getIndexElement()));
        if (src.hasProfile())
            tgt.setProfile(convertCoding(src.getProfile()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.TestScript.TestScriptDestinationComponent convertTestScriptDestinationComponent(org.hl7.fhir.r4.model.TestScript.TestScriptDestinationComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.TestScript.TestScriptDestinationComponent tgt = new org.hl7.fhir.r5.model.TestScript.TestScriptDestinationComponent();
        copyElement(src, tgt);
        if (src.hasIndex())
            tgt.setIndexElement(convertInteger(src.getIndexElement()));
        if (src.hasProfile())
            tgt.setProfile(convertCoding(src.getProfile()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.TestScript.TestScriptDestinationComponent convertTestScriptDestinationComponent(org.hl7.fhir.r5.model.TestScript.TestScriptDestinationComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.TestScript.TestScriptDestinationComponent tgt = new org.hl7.fhir.r4.model.TestScript.TestScriptDestinationComponent();
        copyElement(src, tgt);
        if (src.hasIndex())
            tgt.setIndexElement(convertInteger(src.getIndexElement()));
        if (src.hasProfile())
            tgt.setProfile(convertCoding(src.getProfile()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.TestScript.TestScriptMetadataComponent convertTestScriptMetadataComponent(org.hl7.fhir.r4.model.TestScript.TestScriptMetadataComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.TestScript.TestScriptMetadataComponent tgt = new org.hl7.fhir.r5.model.TestScript.TestScriptMetadataComponent();
        copyElement(src, tgt);
        for (org.hl7.fhir.r4.model.TestScript.TestScriptMetadataLinkComponent t : src.getLink()) tgt.addLink(convertTestScriptMetadataLinkComponent(t));
        for (org.hl7.fhir.r4.model.TestScript.TestScriptMetadataCapabilityComponent t : src.getCapability()) tgt.addCapability(convertTestScriptMetadataCapabilityComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.TestScript.TestScriptMetadataComponent convertTestScriptMetadataComponent(org.hl7.fhir.r5.model.TestScript.TestScriptMetadataComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.TestScript.TestScriptMetadataComponent tgt = new org.hl7.fhir.r4.model.TestScript.TestScriptMetadataComponent();
        copyElement(src, tgt);
        for (org.hl7.fhir.r5.model.TestScript.TestScriptMetadataLinkComponent t : src.getLink()) tgt.addLink(convertTestScriptMetadataLinkComponent(t));
        for (org.hl7.fhir.r5.model.TestScript.TestScriptMetadataCapabilityComponent t : src.getCapability()) tgt.addCapability(convertTestScriptMetadataCapabilityComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.TestScript.TestScriptMetadataLinkComponent convertTestScriptMetadataLinkComponent(org.hl7.fhir.r4.model.TestScript.TestScriptMetadataLinkComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.TestScript.TestScriptMetadataLinkComponent tgt = new org.hl7.fhir.r5.model.TestScript.TestScriptMetadataLinkComponent();
        copyElement(src, tgt);
        if (src.hasUrl())
            tgt.setUrlElement(convertUri(src.getUrlElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.TestScript.TestScriptMetadataLinkComponent convertTestScriptMetadataLinkComponent(org.hl7.fhir.r5.model.TestScript.TestScriptMetadataLinkComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.TestScript.TestScriptMetadataLinkComponent tgt = new org.hl7.fhir.r4.model.TestScript.TestScriptMetadataLinkComponent();
        copyElement(src, tgt);
        if (src.hasUrl())
            tgt.setUrlElement(convertUri(src.getUrlElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.TestScript.TestScriptMetadataCapabilityComponent convertTestScriptMetadataCapabilityComponent(org.hl7.fhir.r4.model.TestScript.TestScriptMetadataCapabilityComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.TestScript.TestScriptMetadataCapabilityComponent tgt = new org.hl7.fhir.r5.model.TestScript.TestScriptMetadataCapabilityComponent();
        copyElement(src, tgt);
        if (src.hasRequired())
            tgt.setRequiredElement(convertBoolean(src.getRequiredElement()));
        if (src.hasValidated())
            tgt.setValidatedElement(convertBoolean(src.getValidatedElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        for (org.hl7.fhir.r4.model.IntegerType t : src.getOrigin()) tgt.getOrigin().add(convertInteger(t));
        if (src.hasDestination())
            tgt.setDestinationElement(convertInteger(src.getDestinationElement()));
        for (org.hl7.fhir.r4.model.UriType t : src.getLink()) tgt.getLink().add(convertUri(t));
        if (src.hasCapabilities())
            tgt.setCapabilitiesElement(convertCanonical(src.getCapabilitiesElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.TestScript.TestScriptMetadataCapabilityComponent convertTestScriptMetadataCapabilityComponent(org.hl7.fhir.r5.model.TestScript.TestScriptMetadataCapabilityComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.TestScript.TestScriptMetadataCapabilityComponent tgt = new org.hl7.fhir.r4.model.TestScript.TestScriptMetadataCapabilityComponent();
        copyElement(src, tgt);
        if (src.hasRequired())
            tgt.setRequiredElement(convertBoolean(src.getRequiredElement()));
        if (src.hasValidated())
            tgt.setValidatedElement(convertBoolean(src.getValidatedElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        for (org.hl7.fhir.r5.model.IntegerType t : src.getOrigin()) tgt.getOrigin().add(convertInteger(t));
        if (src.hasDestination())
            tgt.setDestinationElement(convertInteger(src.getDestinationElement()));
        for (org.hl7.fhir.r5.model.UriType t : src.getLink()) tgt.getLink().add(convertUri(t));
        if (src.hasCapabilities())
            tgt.setCapabilitiesElement(convertCanonical(src.getCapabilitiesElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.TestScript.TestScriptFixtureComponent convertTestScriptFixtureComponent(org.hl7.fhir.r4.model.TestScript.TestScriptFixtureComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.TestScript.TestScriptFixtureComponent tgt = new org.hl7.fhir.r5.model.TestScript.TestScriptFixtureComponent();
        copyElement(src, tgt);
        if (src.hasAutocreate())
            tgt.setAutocreateElement(convertBoolean(src.getAutocreateElement()));
        if (src.hasAutodelete())
            tgt.setAutodeleteElement(convertBoolean(src.getAutodeleteElement()));
        if (src.hasResource())
            tgt.setResource(convertReference(src.getResource()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.TestScript.TestScriptFixtureComponent convertTestScriptFixtureComponent(org.hl7.fhir.r5.model.TestScript.TestScriptFixtureComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.TestScript.TestScriptFixtureComponent tgt = new org.hl7.fhir.r4.model.TestScript.TestScriptFixtureComponent();
        copyElement(src, tgt);
        if (src.hasAutocreate())
            tgt.setAutocreateElement(convertBoolean(src.getAutocreateElement()));
        if (src.hasAutodelete())
            tgt.setAutodeleteElement(convertBoolean(src.getAutodeleteElement()));
        if (src.hasResource())
            tgt.setResource(convertReference(src.getResource()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.TestScript.TestScriptVariableComponent convertTestScriptVariableComponent(org.hl7.fhir.r4.model.TestScript.TestScriptVariableComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.TestScript.TestScriptVariableComponent tgt = new org.hl7.fhir.r5.model.TestScript.TestScriptVariableComponent();
        copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(convertString(src.getNameElement()));
        if (src.hasDefaultValue())
            tgt.setDefaultValueElement(convertString(src.getDefaultValueElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        if (src.hasExpression())
            tgt.setExpressionElement(convertString(src.getExpressionElement()));
        if (src.hasHeaderField())
            tgt.setHeaderFieldElement(convertString(src.getHeaderFieldElement()));
        if (src.hasHint())
            tgt.setHintElement(convertString(src.getHintElement()));
        if (src.hasPath())
            tgt.setPathElement(convertString(src.getPathElement()));
        if (src.hasSourceId())
            tgt.setSourceIdElement(convertId(src.getSourceIdElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.TestScript.TestScriptVariableComponent convertTestScriptVariableComponent(org.hl7.fhir.r5.model.TestScript.TestScriptVariableComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.TestScript.TestScriptVariableComponent tgt = new org.hl7.fhir.r4.model.TestScript.TestScriptVariableComponent();
        copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(convertString(src.getNameElement()));
        if (src.hasDefaultValue())
            tgt.setDefaultValueElement(convertString(src.getDefaultValueElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        if (src.hasExpression())
            tgt.setExpressionElement(convertString(src.getExpressionElement()));
        if (src.hasHeaderField())
            tgt.setHeaderFieldElement(convertString(src.getHeaderFieldElement()));
        if (src.hasHint())
            tgt.setHintElement(convertString(src.getHintElement()));
        if (src.hasPath())
            tgt.setPathElement(convertString(src.getPathElement()));
        if (src.hasSourceId())
            tgt.setSourceIdElement(convertId(src.getSourceIdElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.TestScript.TestScriptSetupComponent convertTestScriptSetupComponent(org.hl7.fhir.r4.model.TestScript.TestScriptSetupComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.TestScript.TestScriptSetupComponent tgt = new org.hl7.fhir.r5.model.TestScript.TestScriptSetupComponent();
        copyElement(src, tgt);
        for (org.hl7.fhir.r4.model.TestScript.SetupActionComponent t : src.getAction()) tgt.addAction(convertSetupActionComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.TestScript.TestScriptSetupComponent convertTestScriptSetupComponent(org.hl7.fhir.r5.model.TestScript.TestScriptSetupComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.TestScript.TestScriptSetupComponent tgt = new org.hl7.fhir.r4.model.TestScript.TestScriptSetupComponent();
        copyElement(src, tgt);
        for (org.hl7.fhir.r5.model.TestScript.SetupActionComponent t : src.getAction()) tgt.addAction(convertSetupActionComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.TestScript.SetupActionComponent convertSetupActionComponent(org.hl7.fhir.r4.model.TestScript.SetupActionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.TestScript.SetupActionComponent tgt = new org.hl7.fhir.r5.model.TestScript.SetupActionComponent();
        copyElement(src, tgt);
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
        copyElement(src, tgt);
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
        copyElement(src, tgt);
        if (src.hasType())
            tgt.setType(convertCoding(src.getType()));
        if (src.hasResource())
            tgt.setResource(org.hl7.fhir.r5.model.TestScript.FHIRDefinedType.fromCode(src.getResource()));
        if (src.hasLabel())
            tgt.setLabelElement(convertString(src.getLabelElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        if (src.hasAccept())
            tgt.setAcceptElement(convertCode(src.getAcceptElement()));
        if (src.hasContentType())
            tgt.setContentTypeElement(convertCode(src.getContentTypeElement()));
        if (src.hasDestination())
            tgt.setDestinationElement(convertInteger(src.getDestinationElement()));
        if (src.hasEncodeRequestUrl())
            tgt.setEncodeRequestUrlElement(convertBoolean(src.getEncodeRequestUrlElement()));
        if (src.hasMethod())
            tgt.setMethodElement(convertTestScriptRequestMethodCode(src.getMethodElement()));
        if (src.hasOrigin())
            tgt.setOriginElement(convertInteger(src.getOriginElement()));
        if (src.hasParams())
            tgt.setParamsElement(convertString(src.getParamsElement()));
        for (org.hl7.fhir.r4.model.TestScript.SetupActionOperationRequestHeaderComponent t : src.getRequestHeader()) tgt.addRequestHeader(convertSetupActionOperationRequestHeaderComponent(t));
        if (src.hasRequestId())
            tgt.setRequestIdElement(convertId(src.getRequestIdElement()));
        if (src.hasResponseId())
            tgt.setResponseIdElement(convertId(src.getResponseIdElement()));
        if (src.hasSourceId())
            tgt.setSourceIdElement(convertId(src.getSourceIdElement()));
        if (src.hasTargetId())
            tgt.setTargetIdElement(convertId(src.getTargetIdElement()));
        if (src.hasUrl())
            tgt.setUrlElement(convertString(src.getUrlElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.TestScript.SetupActionOperationComponent convertSetupActionOperationComponent(org.hl7.fhir.r5.model.TestScript.SetupActionOperationComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.TestScript.SetupActionOperationComponent tgt = new org.hl7.fhir.r4.model.TestScript.SetupActionOperationComponent();
        copyElement(src, tgt);
        if (src.hasType())
            tgt.setType(convertCoding(src.getType()));
        if (src.hasResource())
            tgt.setResource(src.getResource().toCode());
        if (src.hasLabel())
            tgt.setLabelElement(convertString(src.getLabelElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        if (src.hasAccept())
            tgt.setAcceptElement(convertCode(src.getAcceptElement()));
        if (src.hasContentType())
            tgt.setContentTypeElement(convertCode(src.getContentTypeElement()));
        if (src.hasDestination())
            tgt.setDestinationElement(convertInteger(src.getDestinationElement()));
        if (src.hasEncodeRequestUrl())
            tgt.setEncodeRequestUrlElement(convertBoolean(src.getEncodeRequestUrlElement()));
        if (src.hasMethod())
            tgt.setMethodElement(convertTestScriptRequestMethodCode(src.getMethodElement()));
        if (src.hasOrigin())
            tgt.setOriginElement(convertInteger(src.getOriginElement()));
        if (src.hasParams())
            tgt.setParamsElement(convertString(src.getParamsElement()));
        for (org.hl7.fhir.r5.model.TestScript.SetupActionOperationRequestHeaderComponent t : src.getRequestHeader()) tgt.addRequestHeader(convertSetupActionOperationRequestHeaderComponent(t));
        if (src.hasRequestId())
            tgt.setRequestIdElement(convertId(src.getRequestIdElement()));
        if (src.hasResponseId())
            tgt.setResponseIdElement(convertId(src.getResponseIdElement()));
        if (src.hasSourceId())
            tgt.setSourceIdElement(convertId(src.getSourceIdElement()));
        if (src.hasTargetId())
            tgt.setTargetIdElement(convertId(src.getTargetIdElement()));
        if (src.hasUrl())
            tgt.setUrlElement(convertString(src.getUrlElement()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestScript.TestScriptRequestMethodCode> convertTestScriptRequestMethodCode(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TestScript.TestScriptRequestMethodCode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestScript.TestScriptRequestMethodCode> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.TestScript.TestScriptRequestMethodCodeEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
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
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
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
        copyElement(src, tgt);
        if (src.hasField())
            tgt.setFieldElement(convertString(src.getFieldElement()));
        if (src.hasValue())
            tgt.setValueElement(convertString(src.getValueElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.TestScript.SetupActionOperationRequestHeaderComponent convertSetupActionOperationRequestHeaderComponent(org.hl7.fhir.r5.model.TestScript.SetupActionOperationRequestHeaderComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.TestScript.SetupActionOperationRequestHeaderComponent tgt = new org.hl7.fhir.r4.model.TestScript.SetupActionOperationRequestHeaderComponent();
        copyElement(src, tgt);
        if (src.hasField())
            tgt.setFieldElement(convertString(src.getFieldElement()));
        if (src.hasValue())
            tgt.setValueElement(convertString(src.getValueElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.TestScript.SetupActionAssertComponent convertSetupActionAssertComponent(org.hl7.fhir.r4.model.TestScript.SetupActionAssertComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.TestScript.SetupActionAssertComponent tgt = new org.hl7.fhir.r5.model.TestScript.SetupActionAssertComponent();
        copyElement(src, tgt);
        if (src.hasLabel())
            tgt.setLabelElement(convertString(src.getLabelElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        if (src.hasDirection())
            tgt.setDirectionElement(convertAssertionDirectionType(src.getDirectionElement()));
        if (src.hasCompareToSourceId())
            tgt.setCompareToSourceIdElement(convertString(src.getCompareToSourceIdElement()));
        if (src.hasCompareToSourceExpression())
            tgt.setCompareToSourceExpressionElement(convertString(src.getCompareToSourceExpressionElement()));
        if (src.hasCompareToSourcePath())
            tgt.setCompareToSourcePathElement(convertString(src.getCompareToSourcePathElement()));
        if (src.hasContentType())
            tgt.setContentTypeElement(convertCode(src.getContentTypeElement()));
        if (src.hasExpression())
            tgt.setExpressionElement(convertString(src.getExpressionElement()));
        if (src.hasHeaderField())
            tgt.setHeaderFieldElement(convertString(src.getHeaderFieldElement()));
        if (src.hasMinimumId())
            tgt.setMinimumIdElement(convertString(src.getMinimumIdElement()));
        if (src.hasNavigationLinks())
            tgt.setNavigationLinksElement(convertBoolean(src.getNavigationLinksElement()));
        if (src.hasOperator())
            tgt.setOperatorElement(convertAssertionOperatorType(src.getOperatorElement()));
        if (src.hasPath())
            tgt.setPathElement(convertString(src.getPathElement()));
        if (src.hasRequestMethod())
            tgt.setRequestMethodElement(convertTestScriptRequestMethodCode(src.getRequestMethodElement()));
        if (src.hasRequestURL())
            tgt.setRequestURLElement(convertString(src.getRequestURLElement()));
        if (src.hasResource())
            tgt.setResource(org.hl7.fhir.r5.model.TestScript.FHIRDefinedType.fromCode(src.getResource()));
        if (src.hasResponse())
            tgt.setResponseElement(convertAssertionResponseTypes(src.getResponseElement()));
        if (src.hasResponseCode())
            tgt.setResponseCodeElement(convertString(src.getResponseCodeElement()));
        if (src.hasSourceId())
            tgt.setSourceIdElement(convertId(src.getSourceIdElement()));
        if (src.hasValidateProfileId())
            tgt.setValidateProfileIdElement(convertId(src.getValidateProfileIdElement()));
        if (src.hasValue())
            tgt.setValueElement(convertString(src.getValueElement()));
        if (src.hasWarningOnly())
            tgt.setWarningOnlyElement(convertBoolean(src.getWarningOnlyElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.TestScript.SetupActionAssertComponent convertSetupActionAssertComponent(org.hl7.fhir.r5.model.TestScript.SetupActionAssertComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.TestScript.SetupActionAssertComponent tgt = new org.hl7.fhir.r4.model.TestScript.SetupActionAssertComponent();
        copyElement(src, tgt);
        if (src.hasLabel())
            tgt.setLabelElement(convertString(src.getLabelElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        if (src.hasDirection())
            tgt.setDirectionElement(convertAssertionDirectionType(src.getDirectionElement()));
        if (src.hasCompareToSourceId())
            tgt.setCompareToSourceIdElement(convertString(src.getCompareToSourceIdElement()));
        if (src.hasCompareToSourceExpression())
            tgt.setCompareToSourceExpressionElement(convertString(src.getCompareToSourceExpressionElement()));
        if (src.hasCompareToSourcePath())
            tgt.setCompareToSourcePathElement(convertString(src.getCompareToSourcePathElement()));
        if (src.hasContentType())
            tgt.setContentTypeElement(convertCode(src.getContentTypeElement()));
        if (src.hasExpression())
            tgt.setExpressionElement(convertString(src.getExpressionElement()));
        if (src.hasHeaderField())
            tgt.setHeaderFieldElement(convertString(src.getHeaderFieldElement()));
        if (src.hasMinimumId())
            tgt.setMinimumIdElement(convertString(src.getMinimumIdElement()));
        if (src.hasNavigationLinks())
            tgt.setNavigationLinksElement(convertBoolean(src.getNavigationLinksElement()));
        if (src.hasOperator())
            tgt.setOperatorElement(convertAssertionOperatorType(src.getOperatorElement()));
        if (src.hasPath())
            tgt.setPathElement(convertString(src.getPathElement()));
        if (src.hasRequestMethod())
            tgt.setRequestMethodElement(convertTestScriptRequestMethodCode(src.getRequestMethodElement()));
        if (src.hasRequestURL())
            tgt.setRequestURLElement(convertString(src.getRequestURLElement()));
        if (src.hasResource())
            tgt.setResource(src.getResource().toCode());
        if (src.hasResponse())
            tgt.setResponseElement(convertAssertionResponseTypes(src.getResponseElement()));
        if (src.hasResponseCode())
            tgt.setResponseCodeElement(convertString(src.getResponseCodeElement()));
        if (src.hasSourceId())
            tgt.setSourceIdElement(convertId(src.getSourceIdElement()));
        if (src.hasValidateProfileId())
            tgt.setValidateProfileIdElement(convertId(src.getValidateProfileIdElement()));
        if (src.hasValue())
            tgt.setValueElement(convertString(src.getValueElement()));
        if (src.hasWarningOnly())
            tgt.setWarningOnlyElement(convertBoolean(src.getWarningOnlyElement()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestScript.AssertionDirectionType> convertAssertionDirectionType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TestScript.AssertionDirectionType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestScript.AssertionDirectionType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.TestScript.AssertionDirectionTypeEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
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
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
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
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
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
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
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
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
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
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
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
        copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(convertString(src.getNameElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        for (org.hl7.fhir.r4.model.TestScript.TestActionComponent t : src.getAction()) tgt.addAction(convertTestActionComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.TestScript.TestScriptTestComponent convertTestScriptTestComponent(org.hl7.fhir.r5.model.TestScript.TestScriptTestComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.TestScript.TestScriptTestComponent tgt = new org.hl7.fhir.r4.model.TestScript.TestScriptTestComponent();
        copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(convertString(src.getNameElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        for (org.hl7.fhir.r5.model.TestScript.TestActionComponent t : src.getAction()) tgt.addAction(convertTestActionComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.TestScript.TestActionComponent convertTestActionComponent(org.hl7.fhir.r4.model.TestScript.TestActionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.TestScript.TestActionComponent tgt = new org.hl7.fhir.r5.model.TestScript.TestActionComponent();
        copyElement(src, tgt);
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
        copyElement(src, tgt);
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
        copyElement(src, tgt);
        for (org.hl7.fhir.r4.model.TestScript.TeardownActionComponent t : src.getAction()) tgt.addAction(convertTeardownActionComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.TestScript.TestScriptTeardownComponent convertTestScriptTeardownComponent(org.hl7.fhir.r5.model.TestScript.TestScriptTeardownComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.TestScript.TestScriptTeardownComponent tgt = new org.hl7.fhir.r4.model.TestScript.TestScriptTeardownComponent();
        copyElement(src, tgt);
        for (org.hl7.fhir.r5.model.TestScript.TeardownActionComponent t : src.getAction()) tgt.addAction(convertTeardownActionComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.TestScript.TeardownActionComponent convertTeardownActionComponent(org.hl7.fhir.r4.model.TestScript.TeardownActionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.TestScript.TeardownActionComponent tgt = new org.hl7.fhir.r5.model.TestScript.TeardownActionComponent();
        copyElement(src, tgt);
        if (src.hasOperation())
            tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.TestScript.TeardownActionComponent convertTeardownActionComponent(org.hl7.fhir.r5.model.TestScript.TeardownActionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.TestScript.TeardownActionComponent tgt = new org.hl7.fhir.r4.model.TestScript.TeardownActionComponent();
        copyElement(src, tgt);
        if (src.hasOperation())
            tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
        return tgt;
    }
}