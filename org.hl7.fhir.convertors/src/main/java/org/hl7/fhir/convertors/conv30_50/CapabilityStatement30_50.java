package org.hl7.fhir.convertors.conv30_50;

import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.convertors.VersionConvertor_30_50;
import org.hl7.fhir.exceptions.FHIRException;

import java.util.stream.Collectors;

public class CapabilityStatement30_50 {

    public static org.hl7.fhir.r5.model.CapabilityStatement convertCapabilityStatement(org.hl7.fhir.dstu3.model.CapabilityStatement src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.CapabilityStatement tgt = new org.hl7.fhir.r5.model.CapabilityStatement();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrlElement(VersionConvertor_30_50.convertUri(src.getUrlElement()));
        if (src.hasVersion())
            tgt.setVersionElement(VersionConvertor_30_50.convertString(src.getVersionElement()));
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_30_50.convertString(src.getNameElement()));
        if (src.hasTitle())
            tgt.setTitleElement(VersionConvertor_30_50.convertString(src.getTitleElement()));
        if (src.hasStatus())
            tgt.setStatusElement(VersionConvertor_30_50.convertPublicationStatus(src.getStatusElement()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(VersionConvertor_30_50.convertBoolean(src.getExperimentalElement()));
        if (src.hasDate())
            tgt.setDateElement(VersionConvertor_30_50.convertDateTime(src.getDateElement()));
        if (src.hasPublisher())
            tgt.setPublisherElement(VersionConvertor_30_50.convertString(src.getPublisherElement()));
        for (org.hl7.fhir.dstu3.model.ContactDetail t : src.getContact()) tgt.addContact(VersionConvertor_30_50.convertContactDetail(t));
        if (src.hasDescription())
            tgt.setDescriptionElement(VersionConvertor_30_50.convertMarkdown(src.getDescriptionElement()));
        for (org.hl7.fhir.dstu3.model.UsageContext t : src.getUseContext()) tgt.addUseContext(VersionConvertor_30_50.convertUsageContext(t));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(VersionConvertor_30_50.convertCodeableConcept(t));
        if (src.hasPurpose())
            tgt.setPurposeElement(VersionConvertor_30_50.convertMarkdown(src.getPurposeElement()));
        if (src.hasCopyright())
            tgt.setCopyrightElement(VersionConvertor_30_50.convertMarkdown(src.getCopyrightElement()));
        if (src.hasKind())
            tgt.setKindElement(convertCapabilityStatementKind(src.getKindElement()));
        for (org.hl7.fhir.dstu3.model.UriType t : src.getInstantiates()) tgt.addInstantiates(t.getValue());
        if (src.hasSoftware())
            tgt.setSoftware(convertCapabilityStatementSoftwareComponent(src.getSoftware()));
        if (src.hasImplementation())
            tgt.setImplementation(convertCapabilityStatementImplementationComponent(src.getImplementation()));
        if (src.hasFhirVersion())
            tgt.setFhirVersion(org.hl7.fhir.r5.model.Enumerations.FHIRVersion.fromCode(src.getFhirVersion()));
        if (src.hasAcceptUnknown())
            tgt.addExtension().setUrl("http://hl7.org/fhir/3.0/StructureDefinition/extension-CapabilityStatement.acceptUnknown").setValue(new org.hl7.fhir.r5.model.CodeType(src.getAcceptUnknownElement().asStringValue()));
        for (org.hl7.fhir.dstu3.model.CodeType t : src.getFormat()) tgt.addFormat(t.getValue());
        for (org.hl7.fhir.dstu3.model.CodeType t : src.getPatchFormat()) tgt.addPatchFormat(t.getValue());
        for (org.hl7.fhir.dstu3.model.UriType t : src.getImplementationGuide()) tgt.addImplementationGuide(t.getValue());
        for (org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestComponent t : src.getRest()) tgt.addRest(convertCapabilityStatementRestComponent(t));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getProfile()) tgt.addExtension("http://hl7.org/fhir/3.0/StructureDefinition/extension-CapabilityStatement.profile", VersionConvertor_30_50.convertReference(t));
        for (org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingComponent t : src.getMessaging()) tgt.addMessaging(convertCapabilityStatementMessagingComponent(t));
        for (org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementDocumentComponent t : src.getDocument()) tgt.addDocument(convertCapabilityStatementDocumentComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CapabilityStatement convertCapabilityStatement(org.hl7.fhir.r5.model.CapabilityStatement src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.CapabilityStatement tgt = new org.hl7.fhir.dstu3.model.CapabilityStatement();
        VersionConvertor_30_50.copyDomainResource(src, tgt, "http://hl7.org/fhir/3.0/StructureDefinition/extension-CapabilityStatement.acceptUnknown", "http://hl7.org/fhir/3.0/StructureDefinition/extension-CapabilityStatement.profile");
        if (src.hasUrl())
            tgt.setUrlElement(VersionConvertor_30_50.convertUri(src.getUrlElement()));
        if (src.hasVersion())
            tgt.setVersionElement(VersionConvertor_30_50.convertString(src.getVersionElement()));
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_30_50.convertString(src.getNameElement()));
        if (src.hasTitle())
            tgt.setTitleElement(VersionConvertor_30_50.convertString(src.getTitleElement()));
        if (src.hasStatus())
            tgt.setStatusElement(VersionConvertor_30_50.convertPublicationStatus(src.getStatusElement()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(VersionConvertor_30_50.convertBoolean(src.getExperimentalElement()));
        if (src.hasDate())
            tgt.setDateElement(VersionConvertor_30_50.convertDateTime(src.getDateElement()));
        if (src.hasPublisher())
            tgt.setPublisherElement(VersionConvertor_30_50.convertString(src.getPublisherElement()));
        for (org.hl7.fhir.r5.model.ContactDetail t : src.getContact()) tgt.addContact(VersionConvertor_30_50.convertContactDetail(t));
        if (src.hasDescription())
            tgt.setDescriptionElement(VersionConvertor_30_50.convertMarkdown(src.getDescriptionElement()));
        for (org.hl7.fhir.r5.model.UsageContext t : src.getUseContext()) tgt.addUseContext(VersionConvertor_30_50.convertUsageContext(t));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(VersionConvertor_30_50.convertCodeableConcept(t));
        if (src.hasPurpose())
            tgt.setPurposeElement(VersionConvertor_30_50.convertMarkdown(src.getPurposeElement()));
        if (src.hasCopyright())
            tgt.setCopyrightElement(VersionConvertor_30_50.convertMarkdown(src.getCopyrightElement()));
        if (src.hasKind())
            tgt.setKindElement(convertCapabilityStatementKind(src.getKindElement()));
        for (org.hl7.fhir.r5.model.UriType t : src.getInstantiates()) tgt.addInstantiates(t.getValue());
        if (src.hasSoftware())
            tgt.setSoftware(convertCapabilityStatementSoftwareComponent(src.getSoftware()));
        if (src.hasImplementation())
            tgt.setImplementation(convertCapabilityStatementImplementationComponent(src.getImplementation()));
        if (src.hasFhirVersion())
            tgt.setFhirVersion(src.getFhirVersion().toCode());
        if (src.hasExtension("http://hl7.org/fhir/3.0/StructureDefinition/extension-CapabilityStatement.acceptUnknown"))
            tgt.setAcceptUnknown(org.hl7.fhir.dstu3.model.CapabilityStatement.UnknownContentCode.fromCode(src.getExtensionByUrl("http://hl7.org/fhir/3.0/StructureDefinition/extension-CapabilityStatement.acceptUnknown").getValue().primitiveValue()));
        for (org.hl7.fhir.r5.model.CodeType t : src.getFormat()) tgt.addFormat(t.getValue());
        for (org.hl7.fhir.r5.model.CodeType t : src.getPatchFormat()) tgt.addPatchFormat(t.getValue());
        for (org.hl7.fhir.r5.model.UriType t : src.getImplementationGuide()) tgt.addImplementationGuide(t.getValue());
        for (org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestComponent r : src.getRest()) for (org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestResourceComponent rr : r.getResource()) for (org.hl7.fhir.r5.model.CanonicalType t : rr.getSupportedProfile()) tgt.addProfile(VersionConvertor_30_50.convertCanonicalToReference(t));
        for (org.hl7.fhir.r5.model.Extension ext : src.getExtension()) {
            if ("http://hl7.org/fhir/3.0/StructureDefinition/extension-CapabilityStatement.profile".equals(ext.getUrl())) {
                tgt.addProfile(VersionConvertor_30_50.convertReference((org.hl7.fhir.r5.model.Reference) ext.getValue()));
            }
        }
        for (org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestComponent t : src.getRest()) tgt.addRest(convertCapabilityStatementRestComponent(t));
        for (org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementMessagingComponent t : src.getMessaging()) tgt.addMessaging(convertCapabilityStatementMessagingComponent(t));
        for (org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementDocumentComponent t : src.getDocument()) tgt.addDocument(convertCapabilityStatementDocumentComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementDocumentComponent convertCapabilityStatementDocumentComponent(org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementDocumentComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementDocumentComponent tgt = new org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementDocumentComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasMode())
            tgt.setModeElement(convertDocumentMode(src.getModeElement()));
        if (src.hasDocumentation())
            tgt.setDocumentation(src.getDocumentation());
        if (src.hasProfile())
            tgt.setProfileElement(VersionConvertor_30_50.convertReferenceToCanonical(src.getProfile()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementDocumentComponent convertCapabilityStatementDocumentComponent(org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementDocumentComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementDocumentComponent tgt = new org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementDocumentComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasMode())
            tgt.setModeElement(convertDocumentMode(src.getModeElement()));
        if (src.hasDocumentation())
            tgt.setDocumentation(src.getDocumentation());
        if (src.hasProfile())
            tgt.setProfile(VersionConvertor_30_50.convertCanonicalToReference(src.getProfileElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementImplementationComponent convertCapabilityStatementImplementationComponent(org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementImplementationComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementImplementationComponent tgt = new org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementImplementationComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasDescription())
            tgt.setDescriptionElement(VersionConvertor_30_50.convertString(src.getDescriptionElement()));
        if (src.hasUrl())
            tgt.setUrl(src.getUrl());
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementImplementationComponent convertCapabilityStatementImplementationComponent(org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementImplementationComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementImplementationComponent tgt = new org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementImplementationComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasDescription())
            tgt.setDescriptionElement(VersionConvertor_30_50.convertString(src.getDescriptionElement()));
        if (src.hasUrl())
            tgt.setUrl(src.getUrl());
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementKind> convertCapabilityStatementKind(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.CapabilityStatementKind> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementKind> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementKindEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case INSTANCE:
                tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementKind.INSTANCE);
                break;
            case CAPABILITY:
                tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementKind.CAPABILITY);
                break;
            case REQUIREMENTS:
                tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementKind.REQUIREMENTS);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementKind.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.CapabilityStatementKind> convertCapabilityStatementKind(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementKind> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.CapabilityStatementKind> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.CapabilityStatementKindEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case INSTANCE:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.CapabilityStatementKind.INSTANCE);
                break;
            case CAPABILITY:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.CapabilityStatementKind.CAPABILITY);
                break;
            case REQUIREMENTS:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.CapabilityStatementKind.REQUIREMENTS);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.CapabilityStatementKind.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingComponent convertCapabilityStatementMessagingComponent(org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementMessagingComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingComponent tgt = new org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        for (org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementMessagingEndpointComponent t : src.getEndpoint()) tgt.addEndpoint(convertCapabilityStatementMessagingEndpointComponent(t));
        if (src.hasReliableCache())
            tgt.setReliableCacheElement(VersionConvertor_30_50.convertUnsignedInt(src.getReliableCacheElement()));
        if (src.hasDocumentation())
            tgt.setDocumentation(src.getDocumentation());
        for (org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementMessagingSupportedMessageComponent t : src.getSupportedMessage()) tgt.addSupportedMessage(convertCapabilityStatementMessagingSupportedMessageComponent(t));
        for (org.hl7.fhir.r5.model.Extension e : src.getExtensionsByUrl(VersionConvertorConstants.IG_CONFORMANCE_MESSAGE_EVENT)) {
            org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingEventComponent event = new org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingEventComponent();
            tgt.addEvent(event);
            event.setCode(VersionConvertor_30_50.convertCoding((org.hl7.fhir.r5.model.Coding) e.getExtensionByUrl("code").getValue()));
            if (e.hasExtension("category"))
                event.setCategory(org.hl7.fhir.dstu3.model.CapabilityStatement.MessageSignificanceCategory.fromCode(e.getExtensionByUrl("category").getValue().toString()));
            event.setMode(org.hl7.fhir.dstu3.model.CapabilityStatement.EventCapabilityMode.fromCode(e.getExtensionByUrl("mode").getValue().toString()));
            org.hl7.fhir.r5.model.Extension focusE = e.getExtensionByUrl("focus");
            if (focusE.getValue().hasPrimitiveValue())
                event.setFocus(focusE.getValue().toString());
            else {
                event.setFocusElement(new org.hl7.fhir.dstu3.model.CodeType());
                VersionConvertor_30_50.copyElement(focusE.getValue(), event.getFocusElement());
            }
            event.setRequest(VersionConvertor_30_50.convertReference((org.hl7.fhir.r5.model.Reference) e.getExtensionByUrl("request").getValue()));
            event.setResponse(VersionConvertor_30_50.convertReference((org.hl7.fhir.r5.model.Reference) e.getExtensionByUrl("response").getValue()));
            if (e.hasExtension("documentation"))
                event.setDocumentation(e.getExtensionByUrl("documentation").getValue().toString());
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementMessagingComponent convertCapabilityStatementMessagingComponent(org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementMessagingComponent tgt = new org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementMessagingComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        for (org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingEndpointComponent t : src.getEndpoint()) tgt.addEndpoint(convertCapabilityStatementMessagingEndpointComponent(t));
        if (src.hasReliableCache())
            tgt.setReliableCacheElement(VersionConvertor_30_50.convertUnsignedInt(src.getReliableCacheElement()));
        if (src.hasDocumentation())
            tgt.setDocumentation(src.getDocumentation());
        for (org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingSupportedMessageComponent t : src.getSupportedMessage()) tgt.addSupportedMessage(convertCapabilityStatementMessagingSupportedMessageComponent(t));
        for (org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingEventComponent t : src.getEvent()) {
            org.hl7.fhir.r5.model.Extension e = new org.hl7.fhir.r5.model.Extension(VersionConvertorConstants.IG_CONFORMANCE_MESSAGE_EVENT);
            e.addExtension(new org.hl7.fhir.r5.model.Extension("code", VersionConvertor_30_50.convertCoding(t.getCode())));
            if (t.hasCategory())
                e.addExtension(new org.hl7.fhir.r5.model.Extension("category", new org.hl7.fhir.r5.model.CodeType(t.getCategory().toCode())));
            e.addExtension(new org.hl7.fhir.r5.model.Extension("mode", new org.hl7.fhir.r5.model.CodeType(t.getMode().toCode())));
            if (t.getFocusElement().hasValue())
                e.addExtension(new org.hl7.fhir.r5.model.Extension("focus", new org.hl7.fhir.r5.model.StringType(t.getFocus())));
            else {
                org.hl7.fhir.r5.model.CodeType focus = new org.hl7.fhir.r5.model.CodeType();
                org.hl7.fhir.r5.model.Extension focusE = new org.hl7.fhir.r5.model.Extension("focus", focus);
                VersionConvertor_30_50.copyElement(t.getFocusElement(), focus);
                e.addExtension(focusE);
            }
            e.addExtension(new org.hl7.fhir.r5.model.Extension("request", VersionConvertor_30_50.convertReference(t.getRequest())));
            e.addExtension(new org.hl7.fhir.r5.model.Extension("response", VersionConvertor_30_50.convertReference(t.getResponse())));
            if (t.hasDocumentation())
                e.addExtension(new org.hl7.fhir.r5.model.Extension("documentation", new org.hl7.fhir.r5.model.StringType(t.getDocumentation())));
            tgt.addExtension(e);
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingEndpointComponent convertCapabilityStatementMessagingEndpointComponent(org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementMessagingEndpointComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingEndpointComponent tgt = new org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingEndpointComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasProtocol())
            tgt.setProtocol(VersionConvertor_30_50.convertCoding(src.getProtocol()));
        if (src.hasAddress())
            tgt.setAddress(src.getAddress());
        return tgt;
    }

    public static org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementMessagingEndpointComponent convertCapabilityStatementMessagingEndpointComponent(org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingEndpointComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementMessagingEndpointComponent tgt = new org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementMessagingEndpointComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasProtocol())
            tgt.setProtocol(VersionConvertor_30_50.convertCoding(src.getProtocol()));
        if (src.hasAddress())
            tgt.setAddress(src.getAddress());
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingSupportedMessageComponent convertCapabilityStatementMessagingSupportedMessageComponent(org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementMessagingSupportedMessageComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingSupportedMessageComponent tgt = new org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingSupportedMessageComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasMode())
            tgt.setModeElement(convertEventCapabilityMode(src.getModeElement()));
        if (src.hasDefinition())
            tgt.setDefinition(VersionConvertor_30_50.convertCanonicalToReference(src.getDefinitionElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementMessagingSupportedMessageComponent convertCapabilityStatementMessagingSupportedMessageComponent(org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingSupportedMessageComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementMessagingSupportedMessageComponent tgt = new org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementMessagingSupportedMessageComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasMode())
            tgt.setModeElement(convertEventCapabilityMode(src.getModeElement()));
        if (src.hasDefinition())
            tgt.setDefinitionElement(VersionConvertor_30_50.convertReferenceToCanonical(src.getDefinition()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestComponent convertCapabilityStatementRestComponent(org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestComponent tgt = new org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasMode())
            tgt.setModeElement(convertRestfulCapabilityMode(src.getModeElement()));
        if (src.hasDocumentation())
            tgt.setDocumentation(src.getDocumentation());
        if (src.hasSecurity())
            tgt.setSecurity(convertCapabilityStatementRestSecurityComponent(src.getSecurity()));
        for (org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestResourceComponent t : src.getResource()) tgt.addResource(convertCapabilityStatementRestResourceComponent(t));
        for (org.hl7.fhir.r5.model.CapabilityStatement.SystemInteractionComponent t : src.getInteraction()) tgt.addInteraction(convertSystemInteractionComponent(t));
        for (org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent t : src.getSearchParam()) tgt.addSearchParam(convertCapabilityStatementRestResourceSearchParamComponent(t));
        for (org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestResourceOperationComponent t : src.getOperation()) tgt.addOperation(convertCapabilityStatementRestOperationComponent(t));
        for (org.hl7.fhir.r5.model.UriType t : src.getCompartment()) tgt.addCompartment(t.getValue());
        return tgt;
    }

    public static org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestComponent convertCapabilityStatementRestComponent(org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestComponent tgt = new org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasMode())
            tgt.setModeElement(convertRestfulCapabilityMode(src.getModeElement()));
        if (src.hasDocumentation())
            tgt.setDocumentation(src.getDocumentation());
        if (src.hasSecurity())
            tgt.setSecurity(convertCapabilityStatementRestSecurityComponent(src.getSecurity()));
        for (org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestResourceComponent t : src.getResource()) tgt.addResource(convertCapabilityStatementRestResourceComponent(t));
        for (org.hl7.fhir.dstu3.model.CapabilityStatement.SystemInteractionComponent t : src.getInteraction()) tgt.addInteraction(convertSystemInteractionComponent(t));
        for (org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent t : src.getSearchParam()) tgt.addSearchParam(convertCapabilityStatementRestResourceSearchParamComponent(t));
        for (org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestOperationComponent t : src.getOperation()) tgt.addOperation(convertCapabilityStatementRestOperationComponent(t));
        for (org.hl7.fhir.dstu3.model.UriType t : src.getCompartment()) tgt.addCompartment(t.getValue());
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestOperationComponent convertCapabilityStatementRestOperationComponent(org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestResourceOperationComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestOperationComponent tgt = new org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestOperationComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_30_50.convertString(src.getNameElement()));
        if (src.hasDefinition())
            tgt.setDefinition(VersionConvertor_30_50.convertCanonicalToReference(src.getDefinitionElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestResourceOperationComponent convertCapabilityStatementRestOperationComponent(org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestOperationComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestResourceOperationComponent tgt = new org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestResourceOperationComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_30_50.convertString(src.getNameElement()));
        if (src.hasDefinition())
            tgt.setDefinitionElement(VersionConvertor_30_50.convertReferenceToCanonical(src.getDefinition()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestResourceComponent convertCapabilityStatementRestResourceComponent(org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestResourceComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestResourceComponent tgt = new org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestResourceComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasType())
            tgt.setTypeElement(VersionConvertor_30_50.convertCode(src.getTypeElement()));
        if (src.hasProfile())
            tgt.setProfile(VersionConvertor_30_50.convertCanonicalToReference(src.getProfileElement()));
        if (src.hasDocumentation())
            tgt.setDocumentationElement(VersionConvertor_30_50.convertMarkdown(src.getDocumentationElement()));
        for (org.hl7.fhir.r5.model.CapabilityStatement.ResourceInteractionComponent t : src.getInteraction()) tgt.addInteraction(convertResourceInteractionComponent(t));
        if (src.hasVersioning())
            tgt.setVersioningElement(convertResourceVersionPolicy(src.getVersioningElement()));
        if (src.hasReadHistory())
            tgt.setReadHistoryElement(VersionConvertor_30_50.convertBoolean(src.getReadHistoryElement()));
        if (src.hasUpdateCreate())
            tgt.setUpdateCreateElement(VersionConvertor_30_50.convertBoolean(src.getUpdateCreateElement()));
        if (src.hasConditionalCreate())
            tgt.setConditionalCreateElement(VersionConvertor_30_50.convertBoolean(src.getConditionalCreateElement()));
        if (src.hasConditionalRead())
            tgt.setConditionalReadElement(convertConditionalReadStatus(src.getConditionalReadElement()));
        if (src.hasConditionalUpdate())
            tgt.setConditionalUpdateElement(VersionConvertor_30_50.convertBoolean(src.getConditionalUpdateElement()));
        if (src.hasConditionalDelete())
            tgt.setConditionalDeleteElement(convertConditionalDeleteStatus(src.getConditionalDeleteElement()));
        tgt.setReferencePolicy(src.getReferencePolicy().stream()
                .map(CapabilityStatement30_50::convertReferenceHandlingPolicy)
                .collect(Collectors.toList()));
        for (org.hl7.fhir.r5.model.StringType t : src.getSearchInclude()) tgt.addSearchInclude(t.getValue());
        for (org.hl7.fhir.r5.model.StringType t : src.getSearchRevInclude()) tgt.addSearchRevInclude(t.getValue());
        for (org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent t : src.getSearchParam()) tgt.addSearchParam(convertCapabilityStatementRestResourceSearchParamComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestResourceComponent convertCapabilityStatementRestResourceComponent(org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestResourceComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestResourceComponent tgt = new org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestResourceComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasType())
            tgt.setTypeElement(VersionConvertor_30_50.convertCode(src.getTypeElement()));
        if (src.hasProfile())
            tgt.setProfileElement(VersionConvertor_30_50.convertReferenceToCanonical(src.getProfile()));
        if (src.hasDocumentation())
            tgt.setDocumentationElement(VersionConvertor_30_50.convertMarkdown(src.getDocumentationElement()));
        for (org.hl7.fhir.dstu3.model.CapabilityStatement.ResourceInteractionComponent t : src.getInteraction()) tgt.addInteraction(convertResourceInteractionComponent(t));
        if (src.hasVersioning())
            tgt.setVersioningElement(convertResourceVersionPolicy(src.getVersioningElement()));
        if (src.hasReadHistory())
            tgt.setReadHistoryElement(VersionConvertor_30_50.convertBoolean(src.getReadHistoryElement()));
        if (src.hasUpdateCreate())
            tgt.setUpdateCreateElement(VersionConvertor_30_50.convertBoolean(src.getUpdateCreateElement()));
        if (src.hasConditionalCreate())
            tgt.setConditionalCreateElement(VersionConvertor_30_50.convertBoolean(src.getConditionalCreateElement()));
        if (src.hasConditionalRead())
            tgt.setConditionalReadElement(convertConditionalReadStatus(src.getConditionalReadElement()));
        if (src.hasConditionalUpdate())
            tgt.setConditionalUpdateElement(VersionConvertor_30_50.convertBoolean(src.getConditionalUpdateElement()));
        if (src.hasConditionalDelete())
            tgt.setConditionalDeleteElement(convertConditionalDeleteStatus(src.getConditionalDeleteElement()));
        tgt.setReferencePolicy(src.getReferencePolicy().stream()
                .map(CapabilityStatement30_50::convertReferenceHandlingPolicy)
                .collect(Collectors.toList()));
        for (org.hl7.fhir.dstu3.model.StringType t : src.getSearchInclude()) tgt.addSearchInclude(t.getValue());
        for (org.hl7.fhir.dstu3.model.StringType t : src.getSearchRevInclude()) tgt.addSearchRevInclude(t.getValue());
        for (org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent t : src.getSearchParam()) tgt.addSearchParam(convertCapabilityStatementRestResourceSearchParamComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent convertCapabilityStatementRestResourceSearchParamComponent(org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent tgt = new org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_30_50.convertString(src.getNameElement()));
        if (src.hasDefinition())
            tgt.setDefinition(src.getDefinition());
        if (src.hasType())
            tgt.setTypeElement(VersionConvertor_30_50.convertSearchParamType(src.getTypeElement()));
        if (src.hasDocumentation())
            tgt.setDocumentation(src.getDocumentation());
        return tgt;
    }

    public static org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent convertCapabilityStatementRestResourceSearchParamComponent(org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent tgt = new org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_30_50.convertString(src.getNameElement()));
        if (src.hasDefinition())
            tgt.setDefinition(src.getDefinition());
        if (src.hasType())
            tgt.setTypeElement(VersionConvertor_30_50.convertSearchParamType(src.getTypeElement()));
        if (src.hasDocumentation())
            tgt.setDocumentation(src.getDocumentation());
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestSecurityComponent convertCapabilityStatementRestSecurityComponent(org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestSecurityComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestSecurityComponent tgt = new org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestSecurityComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasCors())
            tgt.setCorsElement(VersionConvertor_30_50.convertBoolean(src.getCorsElement()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getService()) tgt.addService(VersionConvertor_30_50.convertCodeableConcept(t));
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        return tgt;
    }

    public static org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestSecurityComponent convertCapabilityStatementRestSecurityComponent(org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestSecurityComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestSecurityComponent tgt = new org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestSecurityComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasCors())
            tgt.setCorsElement(VersionConvertor_30_50.convertBoolean(src.getCorsElement()));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getService()) tgt.addService(VersionConvertor_30_50.convertCodeableConcept(t));
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementSoftwareComponent convertCapabilityStatementSoftwareComponent(org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementSoftwareComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementSoftwareComponent tgt = new org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementSoftwareComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_30_50.convertString(src.getNameElement()));
        if (src.hasVersion())
            tgt.setVersionElement(VersionConvertor_30_50.convertString(src.getVersionElement()));
        if (src.hasReleaseDate())
            tgt.setReleaseDateElement(VersionConvertor_30_50.convertDateTime(src.getReleaseDateElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementSoftwareComponent convertCapabilityStatementSoftwareComponent(org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementSoftwareComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementSoftwareComponent tgt = new org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementSoftwareComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_30_50.convertString(src.getNameElement()));
        if (src.hasVersion())
            tgt.setVersionElement(VersionConvertor_30_50.convertString(src.getVersionElement()));
        if (src.hasReleaseDate())
            tgt.setReleaseDateElement(VersionConvertor_30_50.convertDateTime(src.getReleaseDateElement()));
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.ConditionalDeleteStatus> convertConditionalDeleteStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CapabilityStatement.ConditionalDeleteStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.ConditionalDeleteStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.CapabilityStatement.ConditionalDeleteStatusEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case NOTSUPPORTED:
                tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.ConditionalDeleteStatus.NOTSUPPORTED);
                break;
            case SINGLE:
                tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.ConditionalDeleteStatus.SINGLE);
                break;
            case MULTIPLE:
                tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.ConditionalDeleteStatus.MULTIPLE);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.ConditionalDeleteStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CapabilityStatement.ConditionalDeleteStatus> convertConditionalDeleteStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.ConditionalDeleteStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CapabilityStatement.ConditionalDeleteStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.CapabilityStatement.ConditionalDeleteStatusEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case NOTSUPPORTED:
                tgt.setValue(org.hl7.fhir.r5.model.CapabilityStatement.ConditionalDeleteStatus.NOTSUPPORTED);
                break;
            case SINGLE:
                tgt.setValue(org.hl7.fhir.r5.model.CapabilityStatement.ConditionalDeleteStatus.SINGLE);
                break;
            case MULTIPLE:
                tgt.setValue(org.hl7.fhir.r5.model.CapabilityStatement.ConditionalDeleteStatus.MULTIPLE);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.CapabilityStatement.ConditionalDeleteStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.ConditionalReadStatus> convertConditionalReadStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CapabilityStatement.ConditionalReadStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.ConditionalReadStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.CapabilityStatement.ConditionalReadStatusEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case NOTSUPPORTED:
                tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.ConditionalReadStatus.NOTSUPPORTED);
                break;
            case MODIFIEDSINCE:
                tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.ConditionalReadStatus.MODIFIEDSINCE);
                break;
            case NOTMATCH:
                tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.ConditionalReadStatus.NOTMATCH);
                break;
            case FULLSUPPORT:
                tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.ConditionalReadStatus.FULLSUPPORT);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.ConditionalReadStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CapabilityStatement.ConditionalReadStatus> convertConditionalReadStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.ConditionalReadStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CapabilityStatement.ConditionalReadStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.CapabilityStatement.ConditionalReadStatusEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case NOTSUPPORTED:
                tgt.setValue(org.hl7.fhir.r5.model.CapabilityStatement.ConditionalReadStatus.NOTSUPPORTED);
                break;
            case MODIFIEDSINCE:
                tgt.setValue(org.hl7.fhir.r5.model.CapabilityStatement.ConditionalReadStatus.MODIFIEDSINCE);
                break;
            case NOTMATCH:
                tgt.setValue(org.hl7.fhir.r5.model.CapabilityStatement.ConditionalReadStatus.NOTMATCH);
                break;
            case FULLSUPPORT:
                tgt.setValue(org.hl7.fhir.r5.model.CapabilityStatement.ConditionalReadStatus.FULLSUPPORT);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.CapabilityStatement.ConditionalReadStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.DocumentMode> convertDocumentMode(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CapabilityStatement.DocumentMode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.DocumentMode> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.CapabilityStatement.DocumentModeEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case PRODUCER:
                tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.DocumentMode.PRODUCER);
                break;
            case CONSUMER:
                tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.DocumentMode.CONSUMER);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.DocumentMode.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CapabilityStatement.DocumentMode> convertDocumentMode(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.DocumentMode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CapabilityStatement.DocumentMode> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.CapabilityStatement.DocumentModeEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case PRODUCER:
                tgt.setValue(org.hl7.fhir.r5.model.CapabilityStatement.DocumentMode.PRODUCER);
                break;
            case CONSUMER:
                tgt.setValue(org.hl7.fhir.r5.model.CapabilityStatement.DocumentMode.CONSUMER);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.CapabilityStatement.DocumentMode.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CapabilityStatement.EventCapabilityMode> convertEventCapabilityMode(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.EventCapabilityMode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CapabilityStatement.EventCapabilityMode> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.CapabilityStatement.EventCapabilityModeEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case SENDER:
                tgt.setValue(org.hl7.fhir.r5.model.CapabilityStatement.EventCapabilityMode.SENDER);
                break;
            case RECEIVER:
                tgt.setValue(org.hl7.fhir.r5.model.CapabilityStatement.EventCapabilityMode.RECEIVER);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.CapabilityStatement.EventCapabilityMode.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.EventCapabilityMode> convertEventCapabilityMode(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CapabilityStatement.EventCapabilityMode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.EventCapabilityMode> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.CapabilityStatement.EventCapabilityModeEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case SENDER:
                tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.EventCapabilityMode.SENDER);
                break;
            case RECEIVER:
                tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.EventCapabilityMode.RECEIVER);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.EventCapabilityMode.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.ReferenceHandlingPolicy> convertReferenceHandlingPolicy(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CapabilityStatement.ReferenceHandlingPolicy> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.ReferenceHandlingPolicy> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.CapabilityStatement.ReferenceHandlingPolicyEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case LITERAL:
                tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.ReferenceHandlingPolicy.LITERAL);
                break;
            case LOGICAL:
                tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.ReferenceHandlingPolicy.LOGICAL);
                break;
            case RESOLVES:
                tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.ReferenceHandlingPolicy.RESOLVES);
                break;
            case ENFORCED:
                tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.ReferenceHandlingPolicy.ENFORCED);
                break;
            case LOCAL:
                tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.ReferenceHandlingPolicy.LOCAL);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.ReferenceHandlingPolicy.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CapabilityStatement.ReferenceHandlingPolicy> convertReferenceHandlingPolicy(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.ReferenceHandlingPolicy> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CapabilityStatement.ReferenceHandlingPolicy> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.CapabilityStatement.ReferenceHandlingPolicyEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case LITERAL:
                tgt.setValue(org.hl7.fhir.r5.model.CapabilityStatement.ReferenceHandlingPolicy.LITERAL);
                break;
            case LOGICAL:
                tgt.setValue(org.hl7.fhir.r5.model.CapabilityStatement.ReferenceHandlingPolicy.LOGICAL);
                break;
            case RESOLVES:
                tgt.setValue(org.hl7.fhir.r5.model.CapabilityStatement.ReferenceHandlingPolicy.RESOLVES);
                break;
            case ENFORCED:
                tgt.setValue(org.hl7.fhir.r5.model.CapabilityStatement.ReferenceHandlingPolicy.ENFORCED);
                break;
            case LOCAL:
                tgt.setValue(org.hl7.fhir.r5.model.CapabilityStatement.ReferenceHandlingPolicy.LOCAL);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.CapabilityStatement.ReferenceHandlingPolicy.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.CapabilityStatement.ResourceInteractionComponent convertResourceInteractionComponent(org.hl7.fhir.dstu3.model.CapabilityStatement.ResourceInteractionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.CapabilityStatement.ResourceInteractionComponent tgt = new org.hl7.fhir.r5.model.CapabilityStatement.ResourceInteractionComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCodeElement(convertTypeRestfulInteraction(src.getCodeElement()));
        if (src.hasDocumentation())
            tgt.setDocumentation(src.getDocumentation());
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CapabilityStatement.ResourceInteractionComponent convertResourceInteractionComponent(org.hl7.fhir.r5.model.CapabilityStatement.ResourceInteractionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.CapabilityStatement.ResourceInteractionComponent tgt = new org.hl7.fhir.dstu3.model.CapabilityStatement.ResourceInteractionComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCodeElement(convertTypeRestfulInteraction(src.getCodeElement()));
        if (src.hasDocumentation())
            tgt.setDocumentation(src.getDocumentation());
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CapabilityStatement.ResourceVersionPolicy> convertResourceVersionPolicy(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.ResourceVersionPolicy> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CapabilityStatement.ResourceVersionPolicy> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.CapabilityStatement.ResourceVersionPolicyEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case NOVERSION:
                tgt.setValue(org.hl7.fhir.r5.model.CapabilityStatement.ResourceVersionPolicy.NOVERSION);
                break;
            case VERSIONED:
                tgt.setValue(org.hl7.fhir.r5.model.CapabilityStatement.ResourceVersionPolicy.VERSIONED);
                break;
            case VERSIONEDUPDATE:
                tgt.setValue(org.hl7.fhir.r5.model.CapabilityStatement.ResourceVersionPolicy.VERSIONEDUPDATE);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.CapabilityStatement.ResourceVersionPolicy.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.ResourceVersionPolicy> convertResourceVersionPolicy(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CapabilityStatement.ResourceVersionPolicy> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.ResourceVersionPolicy> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.CapabilityStatement.ResourceVersionPolicyEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case NOVERSION:
                tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.ResourceVersionPolicy.NOVERSION);
                break;
            case VERSIONED:
                tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.ResourceVersionPolicy.VERSIONED);
                break;
            case VERSIONEDUPDATE:
                tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.ResourceVersionPolicy.VERSIONEDUPDATE);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.ResourceVersionPolicy.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.RestfulCapabilityMode> convertRestfulCapabilityMode(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RestfulCapabilityMode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.RestfulCapabilityMode> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.CapabilityStatement.RestfulCapabilityModeEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case CLIENT:
                tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.RestfulCapabilityMode.CLIENT);
                break;
            case SERVER:
                tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.RestfulCapabilityMode.SERVER);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.RestfulCapabilityMode.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RestfulCapabilityMode> convertRestfulCapabilityMode(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.RestfulCapabilityMode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RestfulCapabilityMode> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.RestfulCapabilityModeEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case CLIENT:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RestfulCapabilityMode.CLIENT);
                break;
            case SERVER:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RestfulCapabilityMode.SERVER);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RestfulCapabilityMode.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CapabilityStatement.SystemInteractionComponent convertSystemInteractionComponent(org.hl7.fhir.r5.model.CapabilityStatement.SystemInteractionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.CapabilityStatement.SystemInteractionComponent tgt = new org.hl7.fhir.dstu3.model.CapabilityStatement.SystemInteractionComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCodeElement(convertSystemRestfulInteraction(src.getCodeElement()));
        if (src.hasDocumentation())
            tgt.setDocumentation(src.getDocumentation());
        return tgt;
    }

    public static org.hl7.fhir.r5.model.CapabilityStatement.SystemInteractionComponent convertSystemInteractionComponent(org.hl7.fhir.dstu3.model.CapabilityStatement.SystemInteractionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.CapabilityStatement.SystemInteractionComponent tgt = new org.hl7.fhir.r5.model.CapabilityStatement.SystemInteractionComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCodeElement(convertSystemRestfulInteraction(src.getCodeElement()));
        if (src.hasDocumentation())
            tgt.setDocumentation(src.getDocumentation());
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CapabilityStatement.SystemRestfulInteraction> convertSystemRestfulInteraction(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.SystemRestfulInteraction> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CapabilityStatement.SystemRestfulInteraction> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.CapabilityStatement.SystemRestfulInteractionEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case TRANSACTION:
                tgt.setValue(org.hl7.fhir.r5.model.CapabilityStatement.SystemRestfulInteraction.TRANSACTION);
                break;
            case BATCH:
                tgt.setValue(org.hl7.fhir.r5.model.CapabilityStatement.SystemRestfulInteraction.BATCH);
                break;
            case SEARCHSYSTEM:
                tgt.setValue(org.hl7.fhir.r5.model.CapabilityStatement.SystemRestfulInteraction.SEARCHSYSTEM);
                break;
            case HISTORYSYSTEM:
                tgt.setValue(org.hl7.fhir.r5.model.CapabilityStatement.SystemRestfulInteraction.HISTORYSYSTEM);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.CapabilityStatement.SystemRestfulInteraction.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.SystemRestfulInteraction> convertSystemRestfulInteraction(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CapabilityStatement.SystemRestfulInteraction> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.SystemRestfulInteraction> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.CapabilityStatement.SystemRestfulInteractionEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case TRANSACTION:
                tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.SystemRestfulInteraction.TRANSACTION);
                break;
            case BATCH:
                tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.SystemRestfulInteraction.BATCH);
                break;
            case SEARCHSYSTEM:
                tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.SystemRestfulInteraction.SEARCHSYSTEM);
                break;
            case HISTORYSYSTEM:
                tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.SystemRestfulInteraction.HISTORYSYSTEM);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.SystemRestfulInteraction.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CapabilityStatement.TypeRestfulInteraction> convertTypeRestfulInteraction(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.TypeRestfulInteraction> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CapabilityStatement.TypeRestfulInteraction> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.CapabilityStatement.TypeRestfulInteractionEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case READ:
                tgt.setValue(org.hl7.fhir.r5.model.CapabilityStatement.TypeRestfulInteraction.READ);
                break;
            case VREAD:
                tgt.setValue(org.hl7.fhir.r5.model.CapabilityStatement.TypeRestfulInteraction.VREAD);
                break;
            case UPDATE:
                tgt.setValue(org.hl7.fhir.r5.model.CapabilityStatement.TypeRestfulInteraction.UPDATE);
                break;
            case PATCH:
                tgt.setValue(org.hl7.fhir.r5.model.CapabilityStatement.TypeRestfulInteraction.PATCH);
                break;
            case DELETE:
                tgt.setValue(org.hl7.fhir.r5.model.CapabilityStatement.TypeRestfulInteraction.DELETE);
                break;
            case HISTORYINSTANCE:
                tgt.setValue(org.hl7.fhir.r5.model.CapabilityStatement.TypeRestfulInteraction.HISTORYINSTANCE);
                break;
            case HISTORYTYPE:
                tgt.setValue(org.hl7.fhir.r5.model.CapabilityStatement.TypeRestfulInteraction.HISTORYTYPE);
                break;
            case CREATE:
                tgt.setValue(org.hl7.fhir.r5.model.CapabilityStatement.TypeRestfulInteraction.CREATE);
                break;
            case SEARCHTYPE:
                tgt.setValue(org.hl7.fhir.r5.model.CapabilityStatement.TypeRestfulInteraction.SEARCHTYPE);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.CapabilityStatement.TypeRestfulInteraction.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.TypeRestfulInteraction> convertTypeRestfulInteraction(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CapabilityStatement.TypeRestfulInteraction> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.TypeRestfulInteraction> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.CapabilityStatement.TypeRestfulInteractionEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case READ:
                tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.TypeRestfulInteraction.READ);
                break;
            case VREAD:
                tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.TypeRestfulInteraction.VREAD);
                break;
            case UPDATE:
                tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.TypeRestfulInteraction.UPDATE);
                break;
            case PATCH:
                tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.TypeRestfulInteraction.PATCH);
                break;
            case DELETE:
                tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.TypeRestfulInteraction.DELETE);
                break;
            case HISTORYINSTANCE:
                tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.TypeRestfulInteraction.HISTORYINSTANCE);
                break;
            case HISTORYTYPE:
                tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.TypeRestfulInteraction.HISTORYTYPE);
                break;
            case CREATE:
                tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.TypeRestfulInteraction.CREATE);
                break;
            case SEARCHTYPE:
                tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.TypeRestfulInteraction.SEARCHTYPE);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.TypeRestfulInteraction.NULL);
                break;
        }
        return tgt;
    }
}