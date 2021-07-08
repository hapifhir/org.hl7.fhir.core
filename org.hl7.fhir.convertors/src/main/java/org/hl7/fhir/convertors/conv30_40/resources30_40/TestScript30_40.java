package org.hl7.fhir.convertors.conv30_40.resources30_40;

import org.hl7.fhir.convertors.conv30_40.VersionConvertor_30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Element30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.CodeableConcept30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Coding30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Identifier30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Timing30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.ContactDetail30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.*;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Reference30_40;
import org.hl7.fhir.exceptions.FHIRException;

public class TestScript30_40 {

    public static org.hl7.fhir.r4.model.TestScript convertTestScript(org.hl7.fhir.dstu3.model.TestScript src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.TestScript tgt = new org.hl7.fhir.r4.model.TestScript();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrlElement(Uri30_40.convertUri(src.getUrlElement()));
        if (src.hasIdentifier())
            tgt.setIdentifier(Identifier30_40.convertIdentifier(src.getIdentifier()));
        if (src.hasVersion())
            tgt.setVersionElement(String30_40.convertString(src.getVersionElement()));
        if (src.hasName())
            tgt.setNameElement(String30_40.convertString(src.getNameElement()));
        if (src.hasTitle())
            tgt.setTitleElement(String30_40.convertString(src.getTitleElement()));
        if (src.hasStatus())
            tgt.setStatusElement(Enumerations30_40.convertPublicationStatus(src.getStatusElement()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(Boolean30_40.convertBoolean(src.getExperimentalElement()));
        if (src.hasDateElement())
            tgt.setDateElement(DateTime30_40.convertDateTime(src.getDateElement()));
        if (src.hasPublisher())
            tgt.setPublisherElement(String30_40.convertString(src.getPublisherElement()));
        for (org.hl7.fhir.dstu3.model.ContactDetail t : src.getContact()) tgt.addContact(ContactDetail30_40.convertContactDetail(t));
        if (src.hasDescription())
            tgt.setDescriptionElement(MarkDown30_40.convertMarkdown(src.getDescriptionElement()));
        for (org.hl7.fhir.dstu3.model.UsageContext t : src.getUseContext()) tgt.addUseContext(Timing30_40.convertUsageContext(t));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(CodeableConcept30_40.convertCodeableConcept(t));
        if (src.hasPurpose())
            tgt.setPurposeElement(MarkDown30_40.convertMarkdown(src.getPurposeElement()));
        if (src.hasCopyright())
            tgt.setCopyrightElement(MarkDown30_40.convertMarkdown(src.getCopyrightElement()));
        for (org.hl7.fhir.dstu3.model.TestScript.TestScriptOriginComponent t : src.getOrigin()) tgt.addOrigin(convertTestScriptOriginComponent(t));
        for (org.hl7.fhir.dstu3.model.TestScript.TestScriptDestinationComponent t : src.getDestination()) tgt.addDestination(convertTestScriptDestinationComponent(t));
        if (src.hasMetadata())
            tgt.setMetadata(convertTestScriptMetadataComponent(src.getMetadata()));
        for (org.hl7.fhir.dstu3.model.TestScript.TestScriptFixtureComponent t : src.getFixture()) tgt.addFixture(convertTestScriptFixtureComponent(t));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getProfile()) tgt.addProfile(Reference30_40.convertReference(t));
        for (org.hl7.fhir.dstu3.model.TestScript.TestScriptVariableComponent t : src.getVariable()) tgt.addVariable(convertTestScriptVariableComponent(t));
        if (src.hasSetup())
            tgt.setSetup(convertTestScriptSetupComponent(src.getSetup()));
        for (org.hl7.fhir.dstu3.model.TestScript.TestScriptTestComponent t : src.getTest()) tgt.addTest(convertTestScriptTestComponent(t));
        if (src.hasTeardown())
            tgt.setTeardown(convertTestScriptTeardownComponent(src.getTeardown()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TestScript convertTestScript(org.hl7.fhir.r4.model.TestScript src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.TestScript tgt = new org.hl7.fhir.dstu3.model.TestScript();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrlElement(Uri30_40.convertUri(src.getUrlElement()));
        if (src.hasIdentifier())
            tgt.setIdentifier(Identifier30_40.convertIdentifier(src.getIdentifier()));
        if (src.hasVersion())
            tgt.setVersionElement(String30_40.convertString(src.getVersionElement()));
        if (src.hasName())
            tgt.setNameElement(String30_40.convertString(src.getNameElement()));
        if (src.hasTitle())
            tgt.setTitleElement(String30_40.convertString(src.getTitleElement()));
        if (src.hasStatus())
            tgt.setStatusElement(Enumerations30_40.convertPublicationStatus(src.getStatusElement()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(Boolean30_40.convertBoolean(src.getExperimentalElement()));
        if (src.hasDateElement())
            tgt.setDateElement(DateTime30_40.convertDateTime(src.getDateElement()));
        if (src.hasPublisher())
            tgt.setPublisherElement(String30_40.convertString(src.getPublisherElement()));
        for (org.hl7.fhir.r4.model.ContactDetail t : src.getContact()) tgt.addContact(ContactDetail30_40.convertContactDetail(t));
        if (src.hasDescription())
            tgt.setDescriptionElement(MarkDown30_40.convertMarkdown(src.getDescriptionElement()));
        for (org.hl7.fhir.r4.model.UsageContext t : src.getUseContext()) tgt.addUseContext(Timing30_40.convertUsageContext(t));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(CodeableConcept30_40.convertCodeableConcept(t));
        if (src.hasPurpose())
            tgt.setPurposeElement(MarkDown30_40.convertMarkdown(src.getPurposeElement()));
        if (src.hasCopyright())
            tgt.setCopyrightElement(MarkDown30_40.convertMarkdown(src.getCopyrightElement()));
        for (org.hl7.fhir.r4.model.TestScript.TestScriptOriginComponent t : src.getOrigin()) tgt.addOrigin(convertTestScriptOriginComponent(t));
        for (org.hl7.fhir.r4.model.TestScript.TestScriptDestinationComponent t : src.getDestination()) tgt.addDestination(convertTestScriptDestinationComponent(t));
        if (src.hasMetadata())
            tgt.setMetadata(convertTestScriptMetadataComponent(src.getMetadata()));
        for (org.hl7.fhir.r4.model.TestScript.TestScriptFixtureComponent t : src.getFixture()) tgt.addFixture(convertTestScriptFixtureComponent(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getProfile()) tgt.addProfile(Reference30_40.convertReference(t));
        for (org.hl7.fhir.r4.model.TestScript.TestScriptVariableComponent t : src.getVariable()) tgt.addVariable(convertTestScriptVariableComponent(t));
        if (src.hasSetup())
            tgt.setSetup(convertTestScriptSetupComponent(src.getSetup()));
        for (org.hl7.fhir.r4.model.TestScript.TestScriptTestComponent t : src.getTest()) tgt.addTest(convertTestScriptTestComponent(t));
        if (src.hasTeardown())
            tgt.setTeardown(convertTestScriptTeardownComponent(src.getTeardown()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.TestScript.TestScriptDestinationComponent convertTestScriptDestinationComponent(org.hl7.fhir.dstu3.model.TestScript.TestScriptDestinationComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.TestScript.TestScriptDestinationComponent tgt = new org.hl7.fhir.r4.model.TestScript.TestScriptDestinationComponent();
        Element30_40.copyElement(src, tgt);
        if (src.hasIndex())
            tgt.setIndexElement(Integer30_40.convertInteger(src.getIndexElement()));
        if (src.hasProfile())
            tgt.setProfile(Coding30_40.convertCoding(src.getProfile()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TestScript.TestScriptDestinationComponent convertTestScriptDestinationComponent(org.hl7.fhir.r4.model.TestScript.TestScriptDestinationComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.TestScript.TestScriptDestinationComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.TestScriptDestinationComponent();
        Element30_40.copyElement(src, tgt);
        if (src.hasIndex())
            tgt.setIndexElement(Integer30_40.convertInteger(src.getIndexElement()));
        if (src.hasProfile())
            tgt.setProfile(Coding30_40.convertCoding(src.getProfile()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.TestScript.TestScriptFixtureComponent convertTestScriptFixtureComponent(org.hl7.fhir.dstu3.model.TestScript.TestScriptFixtureComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.TestScript.TestScriptFixtureComponent tgt = new org.hl7.fhir.r4.model.TestScript.TestScriptFixtureComponent();
        Element30_40.copyElement(src, tgt);
        if (src.hasAutocreate())
            tgt.setAutocreateElement(Boolean30_40.convertBoolean(src.getAutocreateElement()));
        if (src.hasAutodelete())
            tgt.setAutodeleteElement(Boolean30_40.convertBoolean(src.getAutodeleteElement()));
        if (src.hasResource())
            tgt.setResource(Reference30_40.convertReference(src.getResource()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TestScript.TestScriptFixtureComponent convertTestScriptFixtureComponent(org.hl7.fhir.r4.model.TestScript.TestScriptFixtureComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.TestScript.TestScriptFixtureComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.TestScriptFixtureComponent();
        Element30_40.copyElement(src, tgt);
        if (src.hasAutocreate())
            tgt.setAutocreateElement(Boolean30_40.convertBoolean(src.getAutocreateElement()));
        if (src.hasAutodelete())
            tgt.setAutodeleteElement(Boolean30_40.convertBoolean(src.getAutodeleteElement()));
        if (src.hasResource())
            tgt.setResource(Reference30_40.convertReference(src.getResource()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.TestScript.TestScriptMetadataCapabilityComponent convertTestScriptMetadataCapabilityComponent(org.hl7.fhir.dstu3.model.TestScript.TestScriptMetadataCapabilityComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.TestScript.TestScriptMetadataCapabilityComponent tgt = new org.hl7.fhir.r4.model.TestScript.TestScriptMetadataCapabilityComponent();
        Element30_40.copyElement(src, tgt);
        if (src.hasRequired())
            tgt.setRequiredElement(Boolean30_40.convertBoolean(src.getRequiredElement()));
        if (src.hasValidated())
            tgt.setValidatedElement(Boolean30_40.convertBoolean(src.getValidatedElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(String30_40.convertString(src.getDescriptionElement()));
        for (org.hl7.fhir.dstu3.model.IntegerType t : src.getOrigin()) tgt.addOrigin(t.getValue());
        if (src.hasDestination())
            tgt.setDestinationElement(Integer30_40.convertInteger(src.getDestinationElement()));
        for (org.hl7.fhir.dstu3.model.UriType t : src.getLink()) tgt.addLink(t.getValue());
        if (src.hasCapabilities())
            tgt.setCapabilitiesElement(Reference30_40.convertReferenceToCanonical(src.getCapabilities()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TestScript.TestScriptMetadataCapabilityComponent convertTestScriptMetadataCapabilityComponent(org.hl7.fhir.r4.model.TestScript.TestScriptMetadataCapabilityComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.TestScript.TestScriptMetadataCapabilityComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.TestScriptMetadataCapabilityComponent();
        Element30_40.copyElement(src, tgt);
        if (src.hasRequired())
            tgt.setRequiredElement(Boolean30_40.convertBoolean(src.getRequiredElement()));
        if (src.hasValidated())
            tgt.setValidatedElement(Boolean30_40.convertBoolean(src.getValidatedElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(String30_40.convertString(src.getDescriptionElement()));
        for (org.hl7.fhir.r4.model.IntegerType t : src.getOrigin()) tgt.addOrigin(t.getValue());
        if (src.hasDestination())
            tgt.setDestinationElement(Integer30_40.convertInteger(src.getDestinationElement()));
        for (org.hl7.fhir.r4.model.UriType t : src.getLink()) tgt.addLink(t.getValue());
        if (src.hasCapabilities())
            tgt.setCapabilities(Reference30_40.convertCanonicalToReference(src.getCapabilitiesElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.TestScript.TestScriptMetadataComponent convertTestScriptMetadataComponent(org.hl7.fhir.dstu3.model.TestScript.TestScriptMetadataComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.TestScript.TestScriptMetadataComponent tgt = new org.hl7.fhir.r4.model.TestScript.TestScriptMetadataComponent();
        Element30_40.copyElement(src, tgt);
        for (org.hl7.fhir.dstu3.model.TestScript.TestScriptMetadataLinkComponent t : src.getLink()) tgt.addLink(convertTestScriptMetadataLinkComponent(t));
        for (org.hl7.fhir.dstu3.model.TestScript.TestScriptMetadataCapabilityComponent t : src.getCapability()) tgt.addCapability(convertTestScriptMetadataCapabilityComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TestScript.TestScriptMetadataComponent convertTestScriptMetadataComponent(org.hl7.fhir.r4.model.TestScript.TestScriptMetadataComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.TestScript.TestScriptMetadataComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.TestScriptMetadataComponent();
        Element30_40.copyElement(src, tgt);
        for (org.hl7.fhir.r4.model.TestScript.TestScriptMetadataLinkComponent t : src.getLink()) tgt.addLink(convertTestScriptMetadataLinkComponent(t));
        for (org.hl7.fhir.r4.model.TestScript.TestScriptMetadataCapabilityComponent t : src.getCapability()) tgt.addCapability(convertTestScriptMetadataCapabilityComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.TestScript.TestScriptMetadataLinkComponent convertTestScriptMetadataLinkComponent(org.hl7.fhir.dstu3.model.TestScript.TestScriptMetadataLinkComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.TestScript.TestScriptMetadataLinkComponent tgt = new org.hl7.fhir.r4.model.TestScript.TestScriptMetadataLinkComponent();
        Element30_40.copyElement(src, tgt);
        if (src.hasUrl())
            tgt.setUrlElement(Uri30_40.convertUri(src.getUrlElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(String30_40.convertString(src.getDescriptionElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TestScript.TestScriptMetadataLinkComponent convertTestScriptMetadataLinkComponent(org.hl7.fhir.r4.model.TestScript.TestScriptMetadataLinkComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.TestScript.TestScriptMetadataLinkComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.TestScriptMetadataLinkComponent();
        Element30_40.copyElement(src, tgt);
        if (src.hasUrl())
            tgt.setUrlElement(Uri30_40.convertUri(src.getUrlElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(String30_40.convertString(src.getDescriptionElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TestScript.TestScriptOriginComponent convertTestScriptOriginComponent(org.hl7.fhir.r4.model.TestScript.TestScriptOriginComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.TestScript.TestScriptOriginComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.TestScriptOriginComponent();
        Element30_40.copyElement(src, tgt);
        if (src.hasIndex())
            tgt.setIndexElement(Integer30_40.convertInteger(src.getIndexElement()));
        if (src.hasProfile())
            tgt.setProfile(Coding30_40.convertCoding(src.getProfile()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.TestScript.TestScriptOriginComponent convertTestScriptOriginComponent(org.hl7.fhir.dstu3.model.TestScript.TestScriptOriginComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.TestScript.TestScriptOriginComponent tgt = new org.hl7.fhir.r4.model.TestScript.TestScriptOriginComponent();
        Element30_40.copyElement(src, tgt);
        if (src.hasIndex())
            tgt.setIndexElement(Integer30_40.convertInteger(src.getIndexElement()));
        if (src.hasProfile())
            tgt.setProfile(Coding30_40.convertCoding(src.getProfile()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.TestScript.TestScriptSetupComponent convertTestScriptSetupComponent(org.hl7.fhir.dstu3.model.TestScript.TestScriptSetupComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.TestScript.TestScriptSetupComponent tgt = new org.hl7.fhir.r4.model.TestScript.TestScriptSetupComponent();
        Element30_40.copyElement(src, tgt);
        for (org.hl7.fhir.dstu3.model.TestScript.SetupActionComponent t : src.getAction()) tgt.addAction(convertSetupActionComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TestScript.TestScriptSetupComponent convertTestScriptSetupComponent(org.hl7.fhir.r4.model.TestScript.TestScriptSetupComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.TestScript.TestScriptSetupComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.TestScriptSetupComponent();
        Element30_40.copyElement(src, tgt);
        for (org.hl7.fhir.r4.model.TestScript.SetupActionComponent t : src.getAction()) tgt.addAction(convertSetupActionComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TestScript.TestScriptTeardownComponent convertTestScriptTeardownComponent(org.hl7.fhir.r4.model.TestScript.TestScriptTeardownComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.TestScript.TestScriptTeardownComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.TestScriptTeardownComponent();
        Element30_40.copyElement(src, tgt);
        for (org.hl7.fhir.r4.model.TestScript.TeardownActionComponent t : src.getAction()) tgt.addAction(convertTeardownActionComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.TestScript.TestScriptTeardownComponent convertTestScriptTeardownComponent(org.hl7.fhir.dstu3.model.TestScript.TestScriptTeardownComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.TestScript.TestScriptTeardownComponent tgt = new org.hl7.fhir.r4.model.TestScript.TestScriptTeardownComponent();
        Element30_40.copyElement(src, tgt);
        for (org.hl7.fhir.dstu3.model.TestScript.TeardownActionComponent t : src.getAction()) tgt.addAction(convertTeardownActionComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TestScript.TestScriptTestComponent convertTestScriptTestComponent(org.hl7.fhir.r4.model.TestScript.TestScriptTestComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.TestScript.TestScriptTestComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.TestScriptTestComponent();
        Element30_40.copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(String30_40.convertString(src.getNameElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(String30_40.convertString(src.getDescriptionElement()));
        for (org.hl7.fhir.r4.model.TestScript.TestActionComponent t : src.getAction()) tgt.addAction(convertTestActionComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.TestScript.TestScriptTestComponent convertTestScriptTestComponent(org.hl7.fhir.dstu3.model.TestScript.TestScriptTestComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.TestScript.TestScriptTestComponent tgt = new org.hl7.fhir.r4.model.TestScript.TestScriptTestComponent();
        Element30_40.copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(String30_40.convertString(src.getNameElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(String30_40.convertString(src.getDescriptionElement()));
        for (org.hl7.fhir.dstu3.model.TestScript.TestActionComponent t : src.getAction()) tgt.addAction(convertTestActionComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TestScript.TestScriptVariableComponent convertTestScriptVariableComponent(org.hl7.fhir.r4.model.TestScript.TestScriptVariableComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.TestScript.TestScriptVariableComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.TestScriptVariableComponent();
        Element30_40.copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(String30_40.convertString(src.getNameElement()));
        if (src.hasDefaultValue())
            tgt.setDefaultValueElement(String30_40.convertString(src.getDefaultValueElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(String30_40.convertString(src.getDescriptionElement()));
        if (src.hasExpression())
            tgt.setExpressionElement(String30_40.convertString(src.getExpressionElement()));
        if (src.hasHeaderField())
            tgt.setHeaderFieldElement(String30_40.convertString(src.getHeaderFieldElement()));
        if (src.hasHint())
            tgt.setHintElement(String30_40.convertString(src.getHintElement()));
        if (src.hasPath())
            tgt.setPathElement(String30_40.convertString(src.getPathElement()));
        if (src.hasSourceId())
            tgt.setSourceIdElement(Id30_40.convertId(src.getSourceIdElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.TestScript.TestScriptVariableComponent convertTestScriptVariableComponent(org.hl7.fhir.dstu3.model.TestScript.TestScriptVariableComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.TestScript.TestScriptVariableComponent tgt = new org.hl7.fhir.r4.model.TestScript.TestScriptVariableComponent();
        Element30_40.copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(String30_40.convertString(src.getNameElement()));
        if (src.hasDefaultValue())
            tgt.setDefaultValueElement(String30_40.convertString(src.getDefaultValueElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(String30_40.convertString(src.getDescriptionElement()));
        if (src.hasExpression())
            tgt.setExpressionElement(String30_40.convertString(src.getExpressionElement()));
        if (src.hasHeaderField())
            tgt.setHeaderFieldElement(String30_40.convertString(src.getHeaderFieldElement()));
        if (src.hasHint())
            tgt.setHintElement(String30_40.convertString(src.getHintElement()));
        if (src.hasPath())
            tgt.setPathElement(String30_40.convertString(src.getPathElement()));
        if (src.hasSourceId())
            tgt.setSourceIdElement(Id30_40.convertId(src.getSourceIdElement()));
        return tgt;
    }

  public static org.hl7.fhir.r4.model.TestScript.SetupActionComponent convertSetupActionComponent(org.hl7.fhir.dstu3.model.TestScript.SetupActionComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.TestScript.SetupActionComponent tgt = new org.hl7.fhir.r4.model.TestScript.SetupActionComponent();
    Element30_40.copyElement(src, tgt);
    if (src.hasOperation()) tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    if (src.hasAssert()) tgt.setAssert(convertSetupActionAssertComponent(src.getAssert()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.TestScript.SetupActionComponent convertSetupActionComponent(org.hl7.fhir.r4.model.TestScript.SetupActionComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.dstu3.model.TestScript.SetupActionComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.SetupActionComponent();
    Element30_40.copyElement(src, tgt);
    if (src.hasOperation()) tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    if (src.hasAssert()) tgt.setAssert(convertSetupActionAssertComponent(src.getAssert()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.TestScript.SetupActionOperationComponent convertSetupActionOperationComponent(org.hl7.fhir.dstu3.model.TestScript.SetupActionOperationComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.TestScript.SetupActionOperationComponent tgt = new org.hl7.fhir.r4.model.TestScript.SetupActionOperationComponent();
    Element30_40.copyElement(src, tgt);
    if (src.hasType()) tgt.setType(Coding30_40.convertCoding(src.getType()));
    if (src.hasResource()) tgt.setResourceElement(Code30_40.convertCode(src.getResourceElement()));
    if (src.hasLabel()) tgt.setLabelElement(String30_40.convertString(src.getLabelElement()));
    if (src.hasDescription()) tgt.setDescriptionElement(String30_40.convertString(src.getDescriptionElement()));
    if (src.hasAccept()) tgt.setAccept(convertContentType(src.getAccept()));
    if (src.hasContentType()) tgt.setContentType(convertContentType(src.getContentType()));
    if (src.hasDestination()) tgt.setDestinationElement(Integer30_40.convertInteger(src.getDestinationElement()));
    if (src.hasEncodeRequestUrl()) tgt.setEncodeRequestUrlElement(Boolean30_40.convertBoolean(src.getEncodeRequestUrlElement()));
    if (src.hasOrigin()) tgt.setOriginElement(Integer30_40.convertInteger(src.getOriginElement()));
    if (src.hasParams()) tgt.setParamsElement(String30_40.convertString(src.getParamsElement()));
    for (org.hl7.fhir.dstu3.model.TestScript.SetupActionOperationRequestHeaderComponent t : src.getRequestHeader())
      tgt.addRequestHeader(convertSetupActionOperationRequestHeaderComponent(t));
    if (src.hasRequestId()) tgt.setRequestIdElement(Id30_40.convertId(src.getRequestIdElement()));
    if (src.hasResponseId()) tgt.setResponseIdElement(Id30_40.convertId(src.getResponseIdElement()));
    if (src.hasSourceId()) tgt.setSourceIdElement(Id30_40.convertId(src.getSourceIdElement()));
    if (src.hasTargetId()) tgt.setTargetId(src.getTargetId());
    if (src.hasUrl()) tgt.setUrlElement(String30_40.convertString(src.getUrlElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.TestScript.SetupActionOperationComponent convertSetupActionOperationComponent(org.hl7.fhir.r4.model.TestScript.SetupActionOperationComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.dstu3.model.TestScript.SetupActionOperationComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.SetupActionOperationComponent();
    Element30_40.copyElement(src, tgt);
    if (src.hasType()) tgt.setType(Coding30_40.convertCoding(src.getType()));
    if (src.hasResource()) tgt.setResourceElement(Code30_40.convertCode(src.getResourceElement()));
    if (src.hasLabel()) tgt.setLabelElement(String30_40.convertString(src.getLabelElement()));
    if (src.hasDescription()) tgt.setDescriptionElement(String30_40.convertString(src.getDescriptionElement()));
    if (src.hasAccept()) tgt.setAccept(convertContentType(src.getAccept()));
    if (src.hasContentType()) tgt.setContentType(convertContentType(src.getContentType()));
    if (src.hasDestination()) tgt.setDestinationElement(Integer30_40.convertInteger(src.getDestinationElement()));
    if (src.hasEncodeRequestUrl()) tgt.setEncodeRequestUrlElement(Boolean30_40.convertBoolean(src.getEncodeRequestUrlElement()));
    if (src.hasOrigin()) tgt.setOriginElement(Integer30_40.convertInteger(src.getOriginElement()));
    if (src.hasParams()) tgt.setParamsElement(String30_40.convertString(src.getParamsElement()));
    for (org.hl7.fhir.r4.model.TestScript.SetupActionOperationRequestHeaderComponent t : src.getRequestHeader())
      tgt.addRequestHeader(convertSetupActionOperationRequestHeaderComponent(t));
    if (src.hasRequestId()) tgt.setRequestIdElement(Id30_40.convertId(src.getRequestIdElement()));
    if (src.hasResponseId()) tgt.setResponseIdElement(Id30_40.convertId(src.getResponseIdElement()));
    if (src.hasSourceId()) tgt.setSourceIdElement(Id30_40.convertId(src.getSourceIdElement()));
    if (src.hasTargetId()) tgt.setTargetId(src.getTargetId());
    if (src.hasUrl()) tgt.setUrlElement(String30_40.convertString(src.getUrlElement()));
    return tgt;
  }

  static public String convertContentType(org.hl7.fhir.dstu3.model.TestScript.ContentType src) throws FHIRException {
    if (src == null) return null;
    switch (src) {
      case XML:
        return "application/fhir+xml";
      case JSON:
        return "application/fhir+json";
      case TTL:
        return "text/turtle";
      case NONE:
        return null;
      default:
        return null;
    }
  }

  static public org.hl7.fhir.dstu3.model.TestScript.ContentType convertContentType(String src) throws FHIRException {
    if (src == null) return null;
    if (src.contains("xml")) return org.hl7.fhir.dstu3.model.TestScript.ContentType.XML;
    if (src.contains("json")) return org.hl7.fhir.dstu3.model.TestScript.ContentType.JSON;
    if (src.contains("tu")) return org.hl7.fhir.dstu3.model.TestScript.ContentType.TTL;
    return org.hl7.fhir.dstu3.model.TestScript.ContentType.NONE;
  }

  public static org.hl7.fhir.r4.model.TestScript.SetupActionOperationRequestHeaderComponent convertSetupActionOperationRequestHeaderComponent(org.hl7.fhir.dstu3.model.TestScript.SetupActionOperationRequestHeaderComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.TestScript.SetupActionOperationRequestHeaderComponent tgt = new org.hl7.fhir.r4.model.TestScript.SetupActionOperationRequestHeaderComponent();
    Element30_40.copyElement(src, tgt);
    if (src.hasField()) tgt.setFieldElement(String30_40.convertString(src.getFieldElement()));
    if (src.hasValue()) tgt.setValueElement(String30_40.convertString(src.getValueElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.TestScript.SetupActionOperationRequestHeaderComponent convertSetupActionOperationRequestHeaderComponent(org.hl7.fhir.r4.model.TestScript.SetupActionOperationRequestHeaderComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.dstu3.model.TestScript.SetupActionOperationRequestHeaderComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.SetupActionOperationRequestHeaderComponent();
    Element30_40.copyElement(src, tgt);
    if (src.hasField()) tgt.setFieldElement(String30_40.convertString(src.getFieldElement()));
    if (src.hasValue()) tgt.setValueElement(String30_40.convertString(src.getValueElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.TestScript.SetupActionAssertComponent convertSetupActionAssertComponent(org.hl7.fhir.dstu3.model.TestScript.SetupActionAssertComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.TestScript.SetupActionAssertComponent tgt = new org.hl7.fhir.r4.model.TestScript.SetupActionAssertComponent();
    Element30_40.copyElement(src, tgt);
    if (src.hasLabel()) tgt.setLabelElement(String30_40.convertString(src.getLabelElement()));
    if (src.hasDescription()) tgt.setDescriptionElement(String30_40.convertString(src.getDescriptionElement()));
    if (src.hasDirection()) tgt.setDirectionElement(convertAssertionDirectionType(src.getDirectionElement()));
    if (src.hasCompareToSourceId()) tgt.setCompareToSourceIdElement(String30_40.convertString(src.getCompareToSourceIdElement()));
    if (src.hasCompareToSourceExpression())
      tgt.setCompareToSourceExpressionElement(String30_40.convertString(src.getCompareToSourceExpressionElement()));
    if (src.hasCompareToSourcePath())
      tgt.setCompareToSourcePathElement(String30_40.convertString(src.getCompareToSourcePathElement()));
    if (src.hasContentType()) tgt.setContentType(convertContentType(src.getContentType()));
    if (src.hasExpression()) tgt.setExpressionElement(String30_40.convertString(src.getExpressionElement()));
    if (src.hasHeaderField()) tgt.setHeaderFieldElement(String30_40.convertString(src.getHeaderFieldElement()));
    if (src.hasMinimumId()) tgt.setMinimumIdElement(String30_40.convertString(src.getMinimumIdElement()));
    if (src.hasNavigationLinks()) tgt.setNavigationLinksElement(Boolean30_40.convertBoolean(src.getNavigationLinksElement()));
    if (src.hasOperator()) tgt.setOperatorElement(convertAssertionOperatorType(src.getOperatorElement()));
    if (src.hasPath()) tgt.setPathElement(String30_40.convertString(src.getPathElement()));
    if (src.hasRequestMethod())
      tgt.setRequestMethodElement(convertTestScriptRequestMethodCode(src.getRequestMethodElement()));
    if (src.hasRequestURL()) tgt.setRequestURLElement(String30_40.convertString(src.getRequestURLElement()));
    if (src.hasResource()) tgt.setResourceElement(Code30_40.convertCode(src.getResourceElement()));
    if (src.hasResponse()) tgt.setResponseElement(convertAssertionResponseTypes(src.getResponseElement()));
    if (src.hasResponseCode()) tgt.setResponseCodeElement(String30_40.convertString(src.getResponseCodeElement()));
    if (src.hasSourceId()) tgt.setSourceIdElement(Id30_40.convertId(src.getSourceIdElement()));
    if (src.hasValidateProfileId()) tgt.setValidateProfileIdElement(Id30_40.convertId(src.getValidateProfileIdElement()));
    if (src.hasValue()) tgt.setValueElement(String30_40.convertString(src.getValueElement()));
    if (src.hasWarningOnly()) tgt.setWarningOnlyElement(Boolean30_40.convertBoolean(src.getWarningOnlyElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.TestScript.SetupActionAssertComponent convertSetupActionAssertComponent(org.hl7.fhir.r4.model.TestScript.SetupActionAssertComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.dstu3.model.TestScript.SetupActionAssertComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.SetupActionAssertComponent();
    Element30_40.copyElement(src, tgt);
    if (src.hasLabel()) tgt.setLabelElement(String30_40.convertString(src.getLabelElement()));
    if (src.hasDescription()) tgt.setDescriptionElement(String30_40.convertString(src.getDescriptionElement()));
    if (src.hasDirection()) tgt.setDirectionElement(convertAssertionDirectionType(src.getDirectionElement()));
    if (src.hasCompareToSourceId()) tgt.setCompareToSourceIdElement(String30_40.convertString(src.getCompareToSourceIdElement()));
    if (src.hasCompareToSourceExpression())
      tgt.setCompareToSourceExpressionElement(String30_40.convertString(src.getCompareToSourceExpressionElement()));
    if (src.hasCompareToSourcePath())
      tgt.setCompareToSourcePathElement(String30_40.convertString(src.getCompareToSourcePathElement()));
    if (src.hasContentType()) tgt.setContentType(convertContentType(src.getContentType()));
    if (src.hasExpression()) tgt.setExpressionElement(String30_40.convertString(src.getExpressionElement()));
    if (src.hasHeaderField()) tgt.setHeaderFieldElement(String30_40.convertString(src.getHeaderFieldElement()));
    if (src.hasMinimumId()) tgt.setMinimumIdElement(String30_40.convertString(src.getMinimumIdElement()));
    if (src.hasNavigationLinks()) tgt.setNavigationLinksElement(Boolean30_40.convertBoolean(src.getNavigationLinksElement()));
    if (src.hasOperator()) tgt.setOperatorElement(convertAssertionOperatorType(src.getOperatorElement()));
    if (src.hasPath()) tgt.setPathElement(String30_40.convertString(src.getPathElement()));
    if (src.hasRequestMethod())
      tgt.setRequestMethodElement(convertTestScriptRequestMethodCode(src.getRequestMethodElement()));
    if (src.hasRequestURL()) tgt.setRequestURLElement(String30_40.convertString(src.getRequestURLElement()));
    if (src.hasResource()) tgt.setResourceElement(Code30_40.convertCode(src.getResourceElement()));
    if (src.hasResponse()) tgt.setResponseElement(convertAssertionResponseTypes(src.getResponseElement()));
    if (src.hasResponseCode()) tgt.setResponseCodeElement(String30_40.convertString(src.getResponseCodeElement()));
    if (src.hasSourceId()) tgt.setSourceIdElement(Id30_40.convertId(src.getSourceIdElement()));
    if (src.hasValidateProfileId()) tgt.setValidateProfileIdElement(Id30_40.convertId(src.getValidateProfileIdElement()));
    if (src.hasValue()) tgt.setValueElement(String30_40.convertString(src.getValueElement()));
    if (src.hasWarningOnly()) tgt.setWarningOnlyElement(Boolean30_40.convertBoolean(src.getWarningOnlyElement()));
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TestScript.AssertionDirectionType> convertAssertionDirectionType(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.TestScript.AssertionDirectionType> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TestScript.AssertionDirectionType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.TestScript.AssertionDirectionTypeEnumFactory());
    Element30_40.copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionDirectionType.NULL);
    } else {
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
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.TestScript.AssertionDirectionType> convertAssertionDirectionType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TestScript.AssertionDirectionType> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.TestScript.AssertionDirectionType> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.TestScript.AssertionDirectionTypeEnumFactory());
    Element30_40.copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionDirectionType.NULL);
    } else {
      switch (src.getValue()) {
        case RESPONSE:
          tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionDirectionType.RESPONSE);
          break;
        case REQUEST:
          tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionDirectionType.REQUEST);
          break;
        default:
          tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionDirectionType.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TestScript.AssertionOperatorType> convertAssertionOperatorType(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.TestScript.AssertionOperatorType> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TestScript.AssertionOperatorType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.TestScript.AssertionOperatorTypeEnumFactory());
    Element30_40.copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionOperatorType.NULL);
    } else {
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
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.TestScript.AssertionOperatorType> convertAssertionOperatorType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TestScript.AssertionOperatorType> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.TestScript.AssertionOperatorType> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.TestScript.AssertionOperatorTypeEnumFactory());
    Element30_40.copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionOperatorType.NULL);
    } else {
      switch (src.getValue()) {
        case EQUALS:
          tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionOperatorType.EQUALS);
          break;
        case NOTEQUALS:
          tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionOperatorType.NOTEQUALS);
          break;
        case IN:
          tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionOperatorType.IN);
          break;
        case NOTIN:
          tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionOperatorType.NOTIN);
          break;
        case GREATERTHAN:
          tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionOperatorType.GREATERTHAN);
          break;
        case LESSTHAN:
          tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionOperatorType.LESSTHAN);
          break;
        case EMPTY:
          tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionOperatorType.EMPTY);
          break;
        case NOTEMPTY:
          tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionOperatorType.NOTEMPTY);
          break;
        case CONTAINS:
          tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionOperatorType.CONTAINS);
          break;
        case NOTCONTAINS:
          tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionOperatorType.NOTCONTAINS);
          break;
        case EVAL:
          tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionOperatorType.EVAL);
          break;
        default:
          tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionOperatorType.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TestScript.TestScriptRequestMethodCode> convertTestScriptRequestMethodCode(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.TestScript.TestScriptRequestMethodCode> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TestScript.TestScriptRequestMethodCode> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.TestScript.TestScriptRequestMethodCodeEnumFactory());
    Element30_40.copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.r4.model.TestScript.TestScriptRequestMethodCode.NULL);
    } else {
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
        default:
          tgt.setValue(org.hl7.fhir.r4.model.TestScript.TestScriptRequestMethodCode.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.TestScript.TestScriptRequestMethodCode> convertTestScriptRequestMethodCode(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TestScript.TestScriptRequestMethodCode> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.TestScript.TestScriptRequestMethodCode> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.TestScript.TestScriptRequestMethodCodeEnumFactory());
    Element30_40.copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.TestScriptRequestMethodCode.NULL);
    } else {
      switch (src.getValue()) {
        case DELETE:
          tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.TestScriptRequestMethodCode.DELETE);
          break;
        case GET:
          tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.TestScriptRequestMethodCode.GET);
          break;
        case OPTIONS:
          tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.TestScriptRequestMethodCode.OPTIONS);
          break;
        case PATCH:
          tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.TestScriptRequestMethodCode.PATCH);
          break;
        case POST:
          tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.TestScriptRequestMethodCode.POST);
          break;
        case PUT:
          tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.TestScriptRequestMethodCode.PUT);
          break;
        default:
          tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.TestScriptRequestMethodCode.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TestScript.AssertionResponseTypes> convertAssertionResponseTypes(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.TestScript.AssertionResponseTypes> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TestScript.AssertionResponseTypes> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.TestScript.AssertionResponseTypesEnumFactory());
    Element30_40.copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionResponseTypes.NULL);
    } else {
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
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.TestScript.AssertionResponseTypes> convertAssertionResponseTypes(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TestScript.AssertionResponseTypes> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.TestScript.AssertionResponseTypes> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.TestScript.AssertionResponseTypesEnumFactory());
    Element30_40.copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionResponseTypes.NULL);
    } else {
      switch (src.getValue()) {
        case OKAY:
          tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionResponseTypes.OKAY);
          break;
        case CREATED:
          tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionResponseTypes.CREATED);
          break;
        case NOCONTENT:
          tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionResponseTypes.NOCONTENT);
          break;
        case NOTMODIFIED:
          tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionResponseTypes.NOTMODIFIED);
          break;
        case BAD:
          tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionResponseTypes.BAD);
          break;
        case FORBIDDEN:
          tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionResponseTypes.FORBIDDEN);
          break;
        case NOTFOUND:
          tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionResponseTypes.NOTFOUND);
          break;
        case METHODNOTALLOWED:
          tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionResponseTypes.METHODNOTALLOWED);
          break;
        case CONFLICT:
          tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionResponseTypes.CONFLICT);
          break;
        case GONE:
          tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionResponseTypes.GONE);
          break;
        case PRECONDITIONFAILED:
          tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionResponseTypes.PRECONDITIONFAILED);
          break;
        case UNPROCESSABLE:
          tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionResponseTypes.UNPROCESSABLE);
          break;
        default:
          tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionResponseTypes.NULL);
          break;
      }
    }
    return tgt;
  }

  public static org.hl7.fhir.r4.model.TestScript.TestActionComponent convertTestActionComponent(org.hl7.fhir.dstu3.model.TestScript.TestActionComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.TestScript.TestActionComponent tgt = new org.hl7.fhir.r4.model.TestScript.TestActionComponent();
    Element30_40.copyElement(src, tgt);
    if (src.hasOperation()) tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    if (src.hasAssert()) tgt.setAssert(convertSetupActionAssertComponent(src.getAssert()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.TestScript.TestActionComponent convertTestActionComponent(org.hl7.fhir.r4.model.TestScript.TestActionComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.dstu3.model.TestScript.TestActionComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.TestActionComponent();
    Element30_40.copyElement(src, tgt);
    if (src.hasOperation()) tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    if (src.hasAssert()) tgt.setAssert(convertSetupActionAssertComponent(src.getAssert()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.TestScript.TeardownActionComponent convertTeardownActionComponent(org.hl7.fhir.dstu3.model.TestScript.TeardownActionComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r4.model.TestScript.TeardownActionComponent tgt = new org.hl7.fhir.r4.model.TestScript.TeardownActionComponent();
    Element30_40.copyElement(src, tgt);
    if (src.hasOperation()) tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.TestScript.TeardownActionComponent convertTeardownActionComponent(org.hl7.fhir.r4.model.TestScript.TeardownActionComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.dstu3.model.TestScript.TeardownActionComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.TeardownActionComponent();
    Element30_40.copyElement(src, tgt);
    if (src.hasOperation()) tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    return tgt;
  }
}