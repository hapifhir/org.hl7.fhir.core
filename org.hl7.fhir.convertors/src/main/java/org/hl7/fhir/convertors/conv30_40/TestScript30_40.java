package org.hl7.fhir.convertors.conv30_40;

import org.hl7.fhir.convertors.VersionConvertor_30_40;
import org.hl7.fhir.exceptions.FHIRException;
import java.util.Collections;

public class TestScript30_40 {

    public static org.hl7.fhir.r4.model.TestScript convertTestScript(org.hl7.fhir.dstu3.model.TestScript src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.TestScript tgt = new org.hl7.fhir.r4.model.TestScript();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        if (src.hasUrlElement())
            tgt.setUrlElement((org.hl7.fhir.r4.model.UriType) VersionConvertor_30_40.convertType(src.getUrlElement()));
        if (src.hasIdentifier())
            tgt.setIdentifier(VersionConvertor_30_40.convertIdentifier(src.getIdentifier()));
        if (src.hasVersionElement())
            tgt.setVersionElement((org.hl7.fhir.r4.model.StringType) VersionConvertor_30_40.convertType(src.getVersionElement()));
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.r4.model.StringType) VersionConvertor_30_40.convertType(src.getNameElement()));
        if (src.hasTitleElement())
            tgt.setTitleElement((org.hl7.fhir.r4.model.StringType) VersionConvertor_30_40.convertType(src.getTitleElement()));
        if (src.hasStatus())
            tgt.setStatus(VersionConvertor_30_40.convertPublicationStatus(src.getStatus()));
        if (src.hasExperimentalElement())
            tgt.setExperimentalElement((org.hl7.fhir.r4.model.BooleanType) VersionConvertor_30_40.convertType(src.getExperimentalElement()));
        if (src.hasDateElement())
            tgt.setDateElement(VersionConvertor_30_40.convertDateTime(src.getDateElement()));
        if (src.hasPublisherElement())
            tgt.setPublisherElement((org.hl7.fhir.r4.model.StringType) VersionConvertor_30_40.convertType(src.getPublisherElement()));
        if (src.hasContact()) {
            for (org.hl7.fhir.dstu3.model.ContactDetail t : src.getContact()) tgt.addContact(VersionConvertor_30_40.convertContactDetail(t));
        }
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.r4.model.MarkdownType) VersionConvertor_30_40.convertType(src.getDescriptionElement()));
        if (src.hasUseContext()) {
            for (org.hl7.fhir.dstu3.model.UsageContext t : src.getUseContext()) tgt.addUseContext(VersionConvertor_30_40.convertUsageContext(t));
        }
        if (src.hasJurisdiction()) {
            for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        if (src.hasPurposeElement())
            tgt.setPurposeElement((org.hl7.fhir.r4.model.MarkdownType) VersionConvertor_30_40.convertType(src.getPurposeElement()));
        if (src.hasCopyrightElement())
            tgt.setCopyrightElement((org.hl7.fhir.r4.model.MarkdownType) VersionConvertor_30_40.convertType(src.getCopyrightElement()));
        if (src.hasOrigin()) {
            for (org.hl7.fhir.dstu3.model.TestScript.TestScriptOriginComponent t : src.getOrigin()) tgt.addOrigin(convertTestScriptOriginComponent(t));
        }
        if (src.hasDestination()) {
            for (org.hl7.fhir.dstu3.model.TestScript.TestScriptDestinationComponent t : src.getDestination()) tgt.addDestination(convertTestScriptDestinationComponent(t));
        }
        if (src.hasMetadata())
            tgt.setMetadata(convertTestScriptMetadataComponent(src.getMetadata()));
        if (src.hasFixture()) {
            for (org.hl7.fhir.dstu3.model.TestScript.TestScriptFixtureComponent t : src.getFixture()) tgt.addFixture(convertTestScriptFixtureComponent(t));
        }
        if (src.hasProfile()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getProfile()) tgt.addProfile(VersionConvertor_30_40.convertReference(t));
        }
        if (src.hasVariable()) {
            for (org.hl7.fhir.dstu3.model.TestScript.TestScriptVariableComponent t : src.getVariable()) tgt.addVariable(convertTestScriptVariableComponent(t));
        }
        if (src.hasSetup())
            tgt.setSetup(convertTestScriptSetupComponent(src.getSetup()));
        if (src.hasTest()) {
            for (org.hl7.fhir.dstu3.model.TestScript.TestScriptTestComponent t : src.getTest()) tgt.addTest(convertTestScriptTestComponent(t));
        }
        if (src.hasTeardown())
            tgt.setTeardown(convertTestScriptTeardownComponent(src.getTeardown()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TestScript convertTestScript(org.hl7.fhir.r4.model.TestScript src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.TestScript tgt = new org.hl7.fhir.dstu3.model.TestScript();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        if (src.hasUrlElement())
            tgt.setUrlElement((org.hl7.fhir.dstu3.model.UriType) VersionConvertor_30_40.convertType(src.getUrlElement()));
        if (src.hasIdentifier())
            tgt.setIdentifier(VersionConvertor_30_40.convertIdentifier(src.getIdentifier()));
        if (src.hasVersionElement())
            tgt.setVersionElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_40.convertType(src.getVersionElement()));
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_40.convertType(src.getNameElement()));
        if (src.hasTitleElement())
            tgt.setTitleElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_40.convertType(src.getTitleElement()));
        if (src.hasStatus())
            tgt.setStatus(VersionConvertor_30_40.convertPublicationStatus(src.getStatus()));
        if (src.hasExperimentalElement())
            tgt.setExperimentalElement((org.hl7.fhir.dstu3.model.BooleanType) VersionConvertor_30_40.convertType(src.getExperimentalElement()));
        if (src.hasDateElement())
            tgt.setDateElement(VersionConvertor_30_40.convertDateTime(src.getDateElement()));
        if (src.hasPublisherElement())
            tgt.setPublisherElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_40.convertType(src.getPublisherElement()));
        if (src.hasContact()) {
            for (org.hl7.fhir.r4.model.ContactDetail t : src.getContact()) tgt.addContact(VersionConvertor_30_40.convertContactDetail(t));
        }
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.dstu3.model.MarkdownType) VersionConvertor_30_40.convertType(src.getDescriptionElement()));
        if (src.hasUseContext()) {
            for (org.hl7.fhir.r4.model.UsageContext t : src.getUseContext()) tgt.addUseContext(VersionConvertor_30_40.convertUsageContext(t));
        }
        if (src.hasJurisdiction()) {
            for (org.hl7.fhir.r4.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        if (src.hasPurposeElement())
            tgt.setPurposeElement((org.hl7.fhir.dstu3.model.MarkdownType) VersionConvertor_30_40.convertType(src.getPurposeElement()));
        if (src.hasCopyrightElement())
            tgt.setCopyrightElement((org.hl7.fhir.dstu3.model.MarkdownType) VersionConvertor_30_40.convertType(src.getCopyrightElement()));
        if (src.hasOrigin()) {
            for (org.hl7.fhir.r4.model.TestScript.TestScriptOriginComponent t : src.getOrigin()) tgt.addOrigin(convertTestScriptOriginComponent(t));
        }
        if (src.hasDestination()) {
            for (org.hl7.fhir.r4.model.TestScript.TestScriptDestinationComponent t : src.getDestination()) tgt.addDestination(convertTestScriptDestinationComponent(t));
        }
        if (src.hasMetadata())
            tgt.setMetadata(convertTestScriptMetadataComponent(src.getMetadata()));
        if (src.hasFixture()) {
            for (org.hl7.fhir.r4.model.TestScript.TestScriptFixtureComponent t : src.getFixture()) tgt.addFixture(convertTestScriptFixtureComponent(t));
        }
        if (src.hasProfile()) {
            for (org.hl7.fhir.r4.model.Reference t : src.getProfile()) tgt.addProfile(VersionConvertor_30_40.convertReference(t));
        }
        if (src.hasVariable()) {
            for (org.hl7.fhir.r4.model.TestScript.TestScriptVariableComponent t : src.getVariable()) tgt.addVariable(convertTestScriptVariableComponent(t));
        }
        if (src.hasSetup())
            tgt.setSetup(convertTestScriptSetupComponent(src.getSetup()));
        if (src.hasTest()) {
            for (org.hl7.fhir.r4.model.TestScript.TestScriptTestComponent t : src.getTest()) tgt.addTest(convertTestScriptTestComponent(t));
        }
        if (src.hasTeardown())
            tgt.setTeardown(convertTestScriptTeardownComponent(src.getTeardown()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.TestScript.TestScriptDestinationComponent convertTestScriptDestinationComponent(org.hl7.fhir.dstu3.model.TestScript.TestScriptDestinationComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.TestScript.TestScriptDestinationComponent tgt = new org.hl7.fhir.r4.model.TestScript.TestScriptDestinationComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasIndexElement())
            tgt.setIndexElement((org.hl7.fhir.r4.model.IntegerType) VersionConvertor_30_40.convertType(src.getIndexElement()));
        if (src.hasProfile())
            tgt.setProfile(VersionConvertor_30_40.convertCoding(src.getProfile()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TestScript.TestScriptDestinationComponent convertTestScriptDestinationComponent(org.hl7.fhir.r4.model.TestScript.TestScriptDestinationComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.TestScript.TestScriptDestinationComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.TestScriptDestinationComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasIndexElement())
            tgt.setIndexElement((org.hl7.fhir.dstu3.model.IntegerType) VersionConvertor_30_40.convertType(src.getIndexElement()));
        if (src.hasProfile())
            tgt.setProfile(VersionConvertor_30_40.convertCoding(src.getProfile()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.TestScript.TestScriptFixtureComponent convertTestScriptFixtureComponent(org.hl7.fhir.dstu3.model.TestScript.TestScriptFixtureComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.TestScript.TestScriptFixtureComponent tgt = new org.hl7.fhir.r4.model.TestScript.TestScriptFixtureComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasAutocreateElement())
            tgt.setAutocreateElement((org.hl7.fhir.r4.model.BooleanType) VersionConvertor_30_40.convertType(src.getAutocreateElement()));
        if (src.hasAutodeleteElement())
            tgt.setAutodeleteElement((org.hl7.fhir.r4.model.BooleanType) VersionConvertor_30_40.convertType(src.getAutodeleteElement()));
        if (src.hasResource())
            tgt.setResource(VersionConvertor_30_40.convertReference(src.getResource()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TestScript.TestScriptFixtureComponent convertTestScriptFixtureComponent(org.hl7.fhir.r4.model.TestScript.TestScriptFixtureComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.TestScript.TestScriptFixtureComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.TestScriptFixtureComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasAutocreateElement())
            tgt.setAutocreateElement((org.hl7.fhir.dstu3.model.BooleanType) VersionConvertor_30_40.convertType(src.getAutocreateElement()));
        if (src.hasAutodeleteElement())
            tgt.setAutodeleteElement((org.hl7.fhir.dstu3.model.BooleanType) VersionConvertor_30_40.convertType(src.getAutodeleteElement()));
        if (src.hasResource())
            tgt.setResource(VersionConvertor_30_40.convertReference(src.getResource()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.TestScript.TestScriptMetadataCapabilityComponent convertTestScriptMetadataCapabilityComponent(org.hl7.fhir.dstu3.model.TestScript.TestScriptMetadataCapabilityComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.TestScript.TestScriptMetadataCapabilityComponent tgt = new org.hl7.fhir.r4.model.TestScript.TestScriptMetadataCapabilityComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasRequiredElement())
            tgt.setRequiredElement((org.hl7.fhir.r4.model.BooleanType) VersionConvertor_30_40.convertType(src.getRequiredElement()));
        if (src.hasValidatedElement())
            tgt.setValidatedElement((org.hl7.fhir.r4.model.BooleanType) VersionConvertor_30_40.convertType(src.getValidatedElement()));
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.r4.model.StringType) VersionConvertor_30_40.convertType(src.getDescriptionElement()));
        if (src.hasOrigin()) {
            for (org.hl7.fhir.dstu3.model.IntegerType t : src.getOrigin()) tgt.addOrigin(t.getValue());
        }
        if (src.hasDestinationElement())
            tgt.setDestinationElement((org.hl7.fhir.r4.model.IntegerType) VersionConvertor_30_40.convertType(src.getDestinationElement()));
        if (src.hasLink()) {
            for (org.hl7.fhir.dstu3.model.UriType t : src.getLink()) tgt.addLink(t.getValue());
        }
        if (src.hasCapabilities())
            tgt.setCapabilitiesElement(VersionConvertor_30_40.convertReferenceToCanonical(src.getCapabilities()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TestScript.TestScriptMetadataCapabilityComponent convertTestScriptMetadataCapabilityComponent(org.hl7.fhir.r4.model.TestScript.TestScriptMetadataCapabilityComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.TestScript.TestScriptMetadataCapabilityComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.TestScriptMetadataCapabilityComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasRequiredElement())
            tgt.setRequiredElement((org.hl7.fhir.dstu3.model.BooleanType) VersionConvertor_30_40.convertType(src.getRequiredElement()));
        if (src.hasValidatedElement())
            tgt.setValidatedElement((org.hl7.fhir.dstu3.model.BooleanType) VersionConvertor_30_40.convertType(src.getValidatedElement()));
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_40.convertType(src.getDescriptionElement()));
        if (src.hasOrigin()) {
            for (org.hl7.fhir.r4.model.IntegerType t : src.getOrigin()) tgt.addOrigin(t.getValue());
        }
        if (src.hasDestinationElement())
            tgt.setDestinationElement((org.hl7.fhir.dstu3.model.IntegerType) VersionConvertor_30_40.convertType(src.getDestinationElement()));
        if (src.hasLink()) {
            for (org.hl7.fhir.r4.model.UriType t : src.getLink()) tgt.addLink(t.getValue());
        }
        if (src.hasCapabilities())
            tgt.setCapabilities(VersionConvertor_30_40.convertCanonicalToReference(src.getCapabilitiesElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.TestScript.TestScriptMetadataComponent convertTestScriptMetadataComponent(org.hl7.fhir.dstu3.model.TestScript.TestScriptMetadataComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.TestScript.TestScriptMetadataComponent tgt = new org.hl7.fhir.r4.model.TestScript.TestScriptMetadataComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasLink()) {
            for (org.hl7.fhir.dstu3.model.TestScript.TestScriptMetadataLinkComponent t : src.getLink()) tgt.addLink(convertTestScriptMetadataLinkComponent(t));
        }
        if (src.hasCapability()) {
            for (org.hl7.fhir.dstu3.model.TestScript.TestScriptMetadataCapabilityComponent t : src.getCapability()) tgt.addCapability(convertTestScriptMetadataCapabilityComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TestScript.TestScriptMetadataComponent convertTestScriptMetadataComponent(org.hl7.fhir.r4.model.TestScript.TestScriptMetadataComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.TestScript.TestScriptMetadataComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.TestScriptMetadataComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasLink()) {
            for (org.hl7.fhir.r4.model.TestScript.TestScriptMetadataLinkComponent t : src.getLink()) tgt.addLink(convertTestScriptMetadataLinkComponent(t));
        }
        if (src.hasCapability()) {
            for (org.hl7.fhir.r4.model.TestScript.TestScriptMetadataCapabilityComponent t : src.getCapability()) tgt.addCapability(convertTestScriptMetadataCapabilityComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.TestScript.TestScriptMetadataLinkComponent convertTestScriptMetadataLinkComponent(org.hl7.fhir.dstu3.model.TestScript.TestScriptMetadataLinkComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.TestScript.TestScriptMetadataLinkComponent tgt = new org.hl7.fhir.r4.model.TestScript.TestScriptMetadataLinkComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasUrlElement())
            tgt.setUrlElement((org.hl7.fhir.r4.model.UriType) VersionConvertor_30_40.convertType(src.getUrlElement()));
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.r4.model.StringType) VersionConvertor_30_40.convertType(src.getDescriptionElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TestScript.TestScriptMetadataLinkComponent convertTestScriptMetadataLinkComponent(org.hl7.fhir.r4.model.TestScript.TestScriptMetadataLinkComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.TestScript.TestScriptMetadataLinkComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.TestScriptMetadataLinkComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasUrlElement())
            tgt.setUrlElement((org.hl7.fhir.dstu3.model.UriType) VersionConvertor_30_40.convertType(src.getUrlElement()));
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_40.convertType(src.getDescriptionElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TestScript.TestScriptOriginComponent convertTestScriptOriginComponent(org.hl7.fhir.r4.model.TestScript.TestScriptOriginComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.TestScript.TestScriptOriginComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.TestScriptOriginComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasIndexElement())
            tgt.setIndexElement((org.hl7.fhir.dstu3.model.IntegerType) VersionConvertor_30_40.convertType(src.getIndexElement()));
        if (src.hasProfile())
            tgt.setProfile(VersionConvertor_30_40.convertCoding(src.getProfile()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.TestScript.TestScriptOriginComponent convertTestScriptOriginComponent(org.hl7.fhir.dstu3.model.TestScript.TestScriptOriginComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.TestScript.TestScriptOriginComponent tgt = new org.hl7.fhir.r4.model.TestScript.TestScriptOriginComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasIndexElement())
            tgt.setIndexElement((org.hl7.fhir.r4.model.IntegerType) VersionConvertor_30_40.convertType(src.getIndexElement()));
        if (src.hasProfile())
            tgt.setProfile(VersionConvertor_30_40.convertCoding(src.getProfile()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.TestScript.TestScriptSetupComponent convertTestScriptSetupComponent(org.hl7.fhir.dstu3.model.TestScript.TestScriptSetupComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.TestScript.TestScriptSetupComponent tgt = new org.hl7.fhir.r4.model.TestScript.TestScriptSetupComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasAction()) {
            for (org.hl7.fhir.dstu3.model.TestScript.SetupActionComponent t : src.getAction()) tgt.addAction(VersionConvertor_30_40.convertSetupActionComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TestScript.TestScriptSetupComponent convertTestScriptSetupComponent(org.hl7.fhir.r4.model.TestScript.TestScriptSetupComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.TestScript.TestScriptSetupComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.TestScriptSetupComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasAction()) {
            for (org.hl7.fhir.r4.model.TestScript.SetupActionComponent t : src.getAction()) tgt.addAction(VersionConvertor_30_40.convertSetupActionComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TestScript.TestScriptTeardownComponent convertTestScriptTeardownComponent(org.hl7.fhir.r4.model.TestScript.TestScriptTeardownComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.TestScript.TestScriptTeardownComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.TestScriptTeardownComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasAction()) {
            for (org.hl7.fhir.r4.model.TestScript.TeardownActionComponent t : src.getAction()) tgt.addAction(VersionConvertor_30_40.convertTeardownActionComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.TestScript.TestScriptTeardownComponent convertTestScriptTeardownComponent(org.hl7.fhir.dstu3.model.TestScript.TestScriptTeardownComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.TestScript.TestScriptTeardownComponent tgt = new org.hl7.fhir.r4.model.TestScript.TestScriptTeardownComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasAction()) {
            for (org.hl7.fhir.dstu3.model.TestScript.TeardownActionComponent t : src.getAction()) tgt.addAction(VersionConvertor_30_40.convertTeardownActionComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TestScript.TestScriptTestComponent convertTestScriptTestComponent(org.hl7.fhir.r4.model.TestScript.TestScriptTestComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.TestScript.TestScriptTestComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.TestScriptTestComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_40.convertType(src.getNameElement()));
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_40.convertType(src.getDescriptionElement()));
        if (src.hasAction()) {
            for (org.hl7.fhir.r4.model.TestScript.TestActionComponent t : src.getAction()) tgt.addAction(VersionConvertor_30_40.convertTestActionComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.TestScript.TestScriptTestComponent convertTestScriptTestComponent(org.hl7.fhir.dstu3.model.TestScript.TestScriptTestComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.TestScript.TestScriptTestComponent tgt = new org.hl7.fhir.r4.model.TestScript.TestScriptTestComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.r4.model.StringType) VersionConvertor_30_40.convertType(src.getNameElement()));
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.r4.model.StringType) VersionConvertor_30_40.convertType(src.getDescriptionElement()));
        if (src.hasAction()) {
            for (org.hl7.fhir.dstu3.model.TestScript.TestActionComponent t : src.getAction()) tgt.addAction(VersionConvertor_30_40.convertTestActionComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TestScript.TestScriptVariableComponent convertTestScriptVariableComponent(org.hl7.fhir.r4.model.TestScript.TestScriptVariableComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.TestScript.TestScriptVariableComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.TestScriptVariableComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_40.convertType(src.getNameElement()));
        if (src.hasDefaultValueElement())
            tgt.setDefaultValueElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_40.convertType(src.getDefaultValueElement()));
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_40.convertType(src.getDescriptionElement()));
        if (src.hasExpressionElement())
            tgt.setExpressionElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_40.convertType(src.getExpressionElement()));
        if (src.hasHeaderFieldElement())
            tgt.setHeaderFieldElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_40.convertType(src.getHeaderFieldElement()));
        if (src.hasHintElement())
            tgt.setHintElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_40.convertType(src.getHintElement()));
        if (src.hasPathElement())
            tgt.setPathElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_40.convertType(src.getPathElement()));
        if (src.hasSourceIdElement())
            tgt.setSourceIdElement((org.hl7.fhir.dstu3.model.IdType) VersionConvertor_30_40.convertType(src.getSourceIdElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.TestScript.TestScriptVariableComponent convertTestScriptVariableComponent(org.hl7.fhir.dstu3.model.TestScript.TestScriptVariableComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.TestScript.TestScriptVariableComponent tgt = new org.hl7.fhir.r4.model.TestScript.TestScriptVariableComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.r4.model.StringType) VersionConvertor_30_40.convertType(src.getNameElement()));
        if (src.hasDefaultValueElement())
            tgt.setDefaultValueElement((org.hl7.fhir.r4.model.StringType) VersionConvertor_30_40.convertType(src.getDefaultValueElement()));
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.r4.model.StringType) VersionConvertor_30_40.convertType(src.getDescriptionElement()));
        if (src.hasExpressionElement())
            tgt.setExpressionElement((org.hl7.fhir.r4.model.StringType) VersionConvertor_30_40.convertType(src.getExpressionElement()));
        if (src.hasHeaderFieldElement())
            tgt.setHeaderFieldElement((org.hl7.fhir.r4.model.StringType) VersionConvertor_30_40.convertType(src.getHeaderFieldElement()));
        if (src.hasHintElement())
            tgt.setHintElement((org.hl7.fhir.r4.model.StringType) VersionConvertor_30_40.convertType(src.getHintElement()));
        if (src.hasPathElement())
            tgt.setPathElement((org.hl7.fhir.r4.model.StringType) VersionConvertor_30_40.convertType(src.getPathElement()));
        if (src.hasSourceIdElement())
            tgt.setSourceIdElement((org.hl7.fhir.r4.model.IdType) VersionConvertor_30_40.convertType(src.getSourceIdElement()));
        return tgt;
    }
}
