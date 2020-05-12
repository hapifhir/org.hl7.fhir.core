package org.hl7.fhir.convertors.conv14_40;

import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.convertors.VersionConvertor_14_40;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestComponent;
import org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestResourceComponent;

public class Conformance14_40 {

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CapabilityStatement.ConditionalDeleteStatus> convertConditionalDeleteStatus(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Conformance.ConditionalDeleteStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CapabilityStatement.ConditionalDeleteStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.CapabilityStatement.ConditionalDeleteStatusEnumFactory());
        VersionConvertor_14_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case NOTSUPPORTED:
                tgt.setValue(org.hl7.fhir.r4.model.CapabilityStatement.ConditionalDeleteStatus.NOTSUPPORTED);
                break;
            case SINGLE:
                tgt.setValue(org.hl7.fhir.r4.model.CapabilityStatement.ConditionalDeleteStatus.SINGLE);
                break;
            case MULTIPLE:
                tgt.setValue(org.hl7.fhir.r4.model.CapabilityStatement.ConditionalDeleteStatus.MULTIPLE);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.CapabilityStatement.ConditionalDeleteStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Conformance.ConditionalDeleteStatus> convertConditionalDeleteStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CapabilityStatement.ConditionalDeleteStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Conformance.ConditionalDeleteStatus> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.Conformance.ConditionalDeleteStatusEnumFactory());
        VersionConvertor_14_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case NOTSUPPORTED:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Conformance.ConditionalDeleteStatus.NOTSUPPORTED);
                break;
            case SINGLE:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Conformance.ConditionalDeleteStatus.SINGLE);
                break;
            case MULTIPLE:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Conformance.ConditionalDeleteStatus.MULTIPLE);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Conformance.ConditionalDeleteStatus.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Conformance convertConformance(org.hl7.fhir.r4.model.CapabilityStatement src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Conformance tgt = new org.hl7.fhir.dstu2016may.model.Conformance();
        VersionConvertor_14_40.copyDomainResource(src, tgt, "http://hl7.org/fhir/3.0/StructureDefinition/extension-CapabilityStatement.acceptUnknown");
        if (src.hasUrl())
            tgt.setUrlElement(VersionConvertor_14_40.convertUri(src.getUrlElement()));
        if (src.hasVersion())
            tgt.setVersionElement(VersionConvertor_14_40.convertString(src.getVersionElement()));
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_14_40.convertString(src.getNameElement()));
        if (src.hasStatus())
            tgt.setStatusElement(VersionConvertor_14_40.convertConformanceResourceStatus(src.getStatusElement()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(VersionConvertor_14_40.convertBoolean(src.getExperimentalElement()));
        if (src.hasDate())
            tgt.setDateElement(VersionConvertor_14_40.convertDateTime(src.getDateElement()));
        if (src.hasPublisher())
            tgt.setPublisherElement(VersionConvertor_14_40.convertString(src.getPublisherElement()));
        for (org.hl7.fhir.r4.model.ContactDetail t : src.getContact()) tgt.addContact(convertConformanceContactComponent(t));
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.r4.model.UsageContext t : src.getUseContext()) if (t.hasValueCodeableConcept())
            tgt.addUseContext(VersionConvertor_14_40.convertCodeableConcept(t.getValueCodeableConcept()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getJurisdiction()) tgt.addUseContext(VersionConvertor_14_40.convertCodeableConcept(t));
        if (src.hasPurpose())
            tgt.setRequirements(src.getPurpose());
        if (src.hasCopyright())
            tgt.setCopyright(src.getCopyright());
        if (src.hasKind())
            tgt.setKindElement(convertConformanceStatementKind(src.getKindElement()));
        if (src.hasSoftware())
            tgt.setSoftware(convertConformanceSoftwareComponent(src.getSoftware()));
        if (src.hasImplementation())
            tgt.setImplementation(convertConformanceImplementationComponent(src.getImplementation()));
        tgt.setFhirVersion(src.getFhirVersion().toCode());
        if (src.hasExtension("http://hl7.org/fhir/3.0/StructureDefinition/extension-CapabilityStatement.acceptUnknown"))
            tgt.setAcceptUnknown(org.hl7.fhir.dstu2016may.model.Conformance.UnknownContentCode.fromCode(src.getExtensionByUrl("http://hl7.org/fhir/3.0/StructureDefinition/extension-CapabilityStatement.acceptUnknown").getValue().primitiveValue()));
        for (org.hl7.fhir.r4.model.CodeType t : src.getFormat()) tgt.addFormat(t.getValue());
        for (CapabilityStatementRestComponent r : src.getRest()) for (CapabilityStatementRestResourceComponent rr : r.getResource()) for (org.hl7.fhir.r4.model.CanonicalType t : rr.getSupportedProfile()) tgt.addProfile(VersionConvertor_14_40.convertCanonicalToReference(t));
        for (org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestComponent t : src.getRest()) tgt.addRest(convertConformanceRestComponent(t));
        for (org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementMessagingComponent t : src.getMessaging()) tgt.addMessaging(convertConformanceMessagingComponent(t));
        for (org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementDocumentComponent t : src.getDocument()) tgt.addDocument(convertConformanceDocumentComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.CapabilityStatement convertConformance(org.hl7.fhir.dstu2016may.model.Conformance src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.CapabilityStatement tgt = new org.hl7.fhir.r4.model.CapabilityStatement();
        VersionConvertor_14_40.copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrlElement(VersionConvertor_14_40.convertUri(src.getUrlElement()));
        if (src.hasVersion())
            tgt.setVersionElement(VersionConvertor_14_40.convertString(src.getVersionElement()));
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_14_40.convertString(src.getNameElement()));
        if (src.hasStatus())
            tgt.setStatusElement(VersionConvertor_14_40.convertConformanceResourceStatus(src.getStatusElement()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(VersionConvertor_14_40.convertBoolean(src.getExperimentalElement()));
        if (src.hasDate())
            tgt.setDateElement(VersionConvertor_14_40.convertDateTime(src.getDateElement()));
        if (src.hasPublisher())
            tgt.setPublisherElement(VersionConvertor_14_40.convertString(src.getPublisherElement()));
        for (org.hl7.fhir.dstu2016may.model.Conformance.ConformanceContactComponent t : src.getContact()) tgt.addContact(convertConformanceContactComponent(t));
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.dstu2016may.model.CodeableConcept t : src.getUseContext()) if (VersionConvertor_14_40.isJurisdiction(t))
            tgt.addJurisdiction(VersionConvertor_14_40.convertCodeableConcept(t));
        else
            tgt.addUseContext(VersionConvertor_14_40.convertCodeableConceptToUsageContext(t));
        if (src.hasRequirements())
            tgt.setPurpose(src.getRequirements());
        if (src.hasCopyright())
            tgt.setCopyright(src.getCopyright());
        if (src.hasKind())
            tgt.setKindElement(convertConformanceStatementKind(src.getKindElement()));
        if (src.hasSoftware())
            tgt.setSoftware(convertConformanceSoftwareComponent(src.getSoftware()));
        if (src.hasImplementation())
            tgt.setImplementation(convertConformanceImplementationComponent(src.getImplementation()));
        if (src.hasFhirVersion())
            tgt.setFhirVersion(org.hl7.fhir.r4.model.Enumerations.FHIRVersion.fromCode(src.getFhirVersion()));
        if (src.hasAcceptUnknown())
            tgt.addExtension().setUrl("http://hl7.org/fhir/3.0/StructureDefinition/extension-CapabilityStatement.acceptUnknown").setValue(new org.hl7.fhir.r4.model.CodeType(src.getAcceptUnknownElement().asStringValue()));
        for (org.hl7.fhir.dstu2016may.model.CodeType t : src.getFormat()) tgt.addFormat(t.getValue());
        for (org.hl7.fhir.dstu2016may.model.Conformance.ConformanceRestComponent t : src.getRest()) tgt.addRest(convertConformanceRestComponent(t));
        for (org.hl7.fhir.dstu2016may.model.Conformance.ConformanceMessagingComponent t : src.getMessaging()) tgt.addMessaging(convertConformanceMessagingComponent(t));
        for (org.hl7.fhir.dstu2016may.model.Conformance.ConformanceDocumentComponent t : src.getDocument()) tgt.addDocument(convertConformanceDocumentComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Conformance.ConformanceContactComponent convertConformanceContactComponent(org.hl7.fhir.r4.model.ContactDetail src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Conformance.ConformanceContactComponent tgt = new org.hl7.fhir.dstu2016may.model.Conformance.ConformanceContactComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_14_40.convertString(src.getNameElement()));
        for (org.hl7.fhir.r4.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_14_40.convertContactPoint(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ContactDetail convertConformanceContactComponent(org.hl7.fhir.dstu2016may.model.Conformance.ConformanceContactComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.ContactDetail tgt = new org.hl7.fhir.r4.model.ContactDetail();
        VersionConvertor_14_40.copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_14_40.convertString(src.getNameElement()));
        for (org.hl7.fhir.dstu2016may.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_14_40.convertContactPoint(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Conformance.ConformanceDocumentComponent convertConformanceDocumentComponent(org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementDocumentComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Conformance.ConformanceDocumentComponent tgt = new org.hl7.fhir.dstu2016may.model.Conformance.ConformanceDocumentComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        if (src.hasMode())
            tgt.setModeElement(convertDocumentMode(src.getModeElement()));
        if (src.hasDocumentation())
            tgt.setDocumentation(src.getDocumentation());
        if (src.hasProfileElement())
            tgt.setProfile(VersionConvertor_14_40.convertCanonicalToReference(src.getProfileElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementDocumentComponent convertConformanceDocumentComponent(org.hl7.fhir.dstu2016may.model.Conformance.ConformanceDocumentComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementDocumentComponent tgt = new org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementDocumentComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        if (src.hasMode())
            tgt.setModeElement(convertDocumentMode(src.getModeElement()));
        if (src.hasDocumentation())
            tgt.setDocumentation(src.getDocumentation());
        if (src.hasProfile())
            tgt.setProfileElement(VersionConvertor_14_40.convertReferenceToCanonical(src.getProfile()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementImplementationComponent convertConformanceImplementationComponent(org.hl7.fhir.dstu2016may.model.Conformance.ConformanceImplementationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementImplementationComponent tgt = new org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementImplementationComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement(VersionConvertor_14_40.convertString(src.getDescriptionElement()));
        if (src.hasUrl())
            tgt.setUrl(src.getUrl());
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Conformance.ConformanceImplementationComponent convertConformanceImplementationComponent(org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementImplementationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Conformance.ConformanceImplementationComponent tgt = new org.hl7.fhir.dstu2016may.model.Conformance.ConformanceImplementationComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement(VersionConvertor_14_40.convertString(src.getDescriptionElement()));
        if (src.hasUrl())
            tgt.setUrl(src.getUrl());
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Conformance.ConformanceMessagingComponent convertConformanceMessagingComponent(org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementMessagingComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Conformance.ConformanceMessagingComponent tgt = new org.hl7.fhir.dstu2016may.model.Conformance.ConformanceMessagingComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        for (org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementMessagingEndpointComponent t : src.getEndpoint()) tgt.addEndpoint(convertConformanceMessagingEndpointComponent(t));
        if (src.hasReliableCache())
            tgt.setReliableCacheElement(VersionConvertor_14_40.convertUnsignedInt(src.getReliableCacheElement()));
        if (src.hasDocumentation())
            tgt.setDocumentation(src.getDocumentation());
        for (org.hl7.fhir.r4.model.Extension e : src.getExtensionsByUrl(VersionConvertorConstants.IG_CONFORMANCE_MESSAGE_EVENT)) {
            org.hl7.fhir.dstu2016may.model.Conformance.ConformanceMessagingEventComponent event = new org.hl7.fhir.dstu2016may.model.Conformance.ConformanceMessagingEventComponent();
            tgt.addEvent(event);
            event.setCode(VersionConvertor_14_40.convertCoding((org.hl7.fhir.r4.model.Coding) e.getExtensionByUrl("code").getValue()));
            if (e.hasExtension("category"))
                event.setCategory(org.hl7.fhir.dstu2016may.model.Conformance.MessageSignificanceCategory.fromCode(e.getExtensionByUrl("category").getValue().toString()));
            event.setMode(org.hl7.fhir.dstu2016may.model.Conformance.ConformanceEventMode.fromCode(e.getExtensionByUrl("mode").getValue().toString()));
            event.setCode(VersionConvertor_14_40.convertCoding((org.hl7.fhir.r4.model.Coding) e.getExtensionByUrl("code").getValue()));
            if (e.hasExtension("category"))
                event.setCategory(org.hl7.fhir.dstu2016may.model.Conformance.MessageSignificanceCategory.fromCode(e.getExtensionByUrl("category").getValue().toString()));
            event.setMode(org.hl7.fhir.dstu2016may.model.Conformance.ConformanceEventMode.fromCode(e.getExtensionByUrl("mode").getValue().toString()));
            org.hl7.fhir.r4.model.Extension focusE = e.getExtensionByUrl("focus");
            if (focusE.getValue().hasPrimitiveValue())
                event.setFocus(focusE.getValue().toString());
            else {
                event.setFocusElement(new org.hl7.fhir.dstu2016may.model.CodeType());
                VersionConvertor_14_40.copyElement(focusE.getValue(), event.getFocusElement());
            }
            event.setRequest(VersionConvertor_14_40.convertReference((org.hl7.fhir.r4.model.Reference) e.getExtensionByUrl("request").getValue()));
            event.setResponse(VersionConvertor_14_40.convertReference((org.hl7.fhir.r4.model.Reference) e.getExtensionByUrl("response").getValue()));
            if (e.hasExtension("documentation"))
                event.setDocumentation(e.getExtensionByUrl("documentation").getValue().toString());
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementMessagingComponent convertConformanceMessagingComponent(org.hl7.fhir.dstu2016may.model.Conformance.ConformanceMessagingComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementMessagingComponent tgt = new org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementMessagingComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        for (org.hl7.fhir.dstu2016may.model.Conformance.ConformanceMessagingEndpointComponent t : src.getEndpoint()) tgt.addEndpoint(convertConformanceMessagingEndpointComponent(t));
        if (src.hasReliableCache())
            tgt.setReliableCacheElement(VersionConvertor_14_40.convertUnsignedInt(src.getReliableCacheElement()));
        if (src.hasDocumentation())
            tgt.setDocumentation(src.getDocumentation());
        for (org.hl7.fhir.dstu2016may.model.Conformance.ConformanceMessagingEventComponent t : src.getEvent()) {
            org.hl7.fhir.r4.model.Extension e = new org.hl7.fhir.r4.model.Extension(VersionConvertorConstants.IG_CONFORMANCE_MESSAGE_EVENT);
            e.addExtension(new org.hl7.fhir.r4.model.Extension("code", VersionConvertor_14_40.convertCoding(t.getCode())));
            if (t.hasCategory())
                e.addExtension(new org.hl7.fhir.r4.model.Extension("category", new org.hl7.fhir.r4.model.CodeType(t.getCategory().toCode())));
            e.addExtension(new org.hl7.fhir.r4.model.Extension("mode", new org.hl7.fhir.r4.model.CodeType(t.getMode().toCode())));
            if (t.getFocusElement().hasValue())
                e.addExtension(new org.hl7.fhir.r4.model.Extension("focus", new org.hl7.fhir.r4.model.StringType(t.getFocus())));
            else {
                org.hl7.fhir.r4.model.CodeType focus = new org.hl7.fhir.r4.model.CodeType();
                org.hl7.fhir.r4.model.Extension focusE = new org.hl7.fhir.r4.model.Extension("focus", focus);
                VersionConvertor_14_40.copyElement(t.getFocusElement(), focus);
                e.addExtension(focusE);
            }
            e.addExtension(new org.hl7.fhir.r4.model.Extension("request", VersionConvertor_14_40.convertReference(t.getRequest())));
            e.addExtension(new org.hl7.fhir.r4.model.Extension("response", VersionConvertor_14_40.convertReference(t.getResponse())));
            if (t.hasDocumentation())
                e.addExtension(new org.hl7.fhir.r4.model.Extension("documentation", new org.hl7.fhir.r4.model.StringType(t.getDocumentation())));
            tgt.addExtension(e);
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementMessagingEndpointComponent convertConformanceMessagingEndpointComponent(org.hl7.fhir.dstu2016may.model.Conformance.ConformanceMessagingEndpointComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementMessagingEndpointComponent tgt = new org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementMessagingEndpointComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        if (src.hasProtocol())
            tgt.setProtocol(VersionConvertor_14_40.convertCoding(src.getProtocol()));
        if (src.hasAddress())
            tgt.setAddress(src.getAddress());
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Conformance.ConformanceMessagingEndpointComponent convertConformanceMessagingEndpointComponent(org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementMessagingEndpointComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Conformance.ConformanceMessagingEndpointComponent tgt = new org.hl7.fhir.dstu2016may.model.Conformance.ConformanceMessagingEndpointComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        if (src.hasProtocol())
            tgt.setProtocol(VersionConvertor_14_40.convertCoding(src.getProtocol()));
        if (src.hasAddress())
            tgt.setAddress(src.getAddress());
        return tgt;
    }

    public static org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestComponent convertConformanceRestComponent(org.hl7.fhir.dstu2016may.model.Conformance.ConformanceRestComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestComponent tgt = new org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        if (src.hasMode())
            tgt.setModeElement(convertRestfulConformanceMode(src.getModeElement()));
        if (src.hasDocumentation())
            tgt.setDocumentation(src.getDocumentation());
        if (src.hasSecurity())
            tgt.setSecurity(convertConformanceRestSecurityComponent(src.getSecurity()));
        for (org.hl7.fhir.dstu2016may.model.Conformance.ConformanceRestResourceComponent t : src.getResource()) tgt.addResource(convertConformanceRestResourceComponent(t));
        for (org.hl7.fhir.dstu2016may.model.Conformance.SystemInteractionComponent t : src.getInteraction()) tgt.addInteraction(convertSystemInteractionComponent(t));
        for (org.hl7.fhir.dstu2016may.model.Conformance.ConformanceRestResourceSearchParamComponent t : src.getSearchParam()) tgt.addSearchParam(convertConformanceRestResourceSearchParamComponent(t));
        for (org.hl7.fhir.dstu2016may.model.Conformance.ConformanceRestOperationComponent t : src.getOperation()) tgt.addOperation(convertConformanceRestOperationComponent(t));
        for (org.hl7.fhir.dstu2016may.model.UriType t : src.getCompartment()) tgt.addCompartment(t.getValue());
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Conformance.ConformanceRestComponent convertConformanceRestComponent(org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Conformance.ConformanceRestComponent tgt = new org.hl7.fhir.dstu2016may.model.Conformance.ConformanceRestComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        if (src.hasMode())
            tgt.setModeElement(convertRestfulConformanceMode(src.getModeElement()));
        if (src.hasDocumentation())
            tgt.setDocumentation(src.getDocumentation());
        if (src.hasSecurity())
            tgt.setSecurity(convertConformanceRestSecurityComponent(src.getSecurity()));
        for (org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestResourceComponent t : src.getResource()) tgt.addResource(convertConformanceRestResourceComponent(t));
        for (org.hl7.fhir.r4.model.CapabilityStatement.SystemInteractionComponent t : src.getInteraction()) tgt.addInteraction(convertSystemInteractionComponent(t));
        for (org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent t : src.getSearchParam()) tgt.addSearchParam(convertConformanceRestResourceSearchParamComponent(t));
        for (org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestResourceOperationComponent t : src.getOperation()) tgt.addOperation(convertConformanceRestOperationComponent(t));
        for (org.hl7.fhir.r4.model.UriType t : src.getCompartment()) tgt.addCompartment(t.getValue());
        return tgt;
    }

    public static org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestResourceOperationComponent convertConformanceRestOperationComponent(org.hl7.fhir.dstu2016may.model.Conformance.ConformanceRestOperationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestResourceOperationComponent tgt = new org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestResourceOperationComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_14_40.convertString(src.getNameElement()));
        if (src.hasDefinition())
            tgt.setDefinitionElement(VersionConvertor_14_40.convertReferenceToCanonical(src.getDefinition()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Conformance.ConformanceRestOperationComponent convertConformanceRestOperationComponent(org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestResourceOperationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Conformance.ConformanceRestOperationComponent tgt = new org.hl7.fhir.dstu2016may.model.Conformance.ConformanceRestOperationComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_14_40.convertString(src.getNameElement()));
        if (src.hasDefinitionElement())
            tgt.setDefinition(VersionConvertor_14_40.convertCanonicalToReference(src.getDefinitionElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Conformance.ConformanceRestResourceComponent convertConformanceRestResourceComponent(org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestResourceComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Conformance.ConformanceRestResourceComponent tgt = new org.hl7.fhir.dstu2016may.model.Conformance.ConformanceRestResourceComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        if (src.hasTypeElement())
            tgt.setTypeElement(VersionConvertor_14_40.convertCode(src.getTypeElement()));
        if (src.hasProfileElement())
            tgt.setProfile(VersionConvertor_14_40.convertCanonicalToReference(src.getProfileElement()));
        for (org.hl7.fhir.r4.model.CapabilityStatement.ResourceInteractionComponent t : src.getInteraction()) tgt.addInteraction(convertResourceInteractionComponent(t));
        if (src.hasVersioning())
            tgt.setVersioningElement(convertResourceVersionPolicy(src.getVersioningElement()));
        if (src.hasReadHistory())
            tgt.setReadHistoryElement(VersionConvertor_14_40.convertBoolean(src.getReadHistoryElement()));
        if (src.hasUpdateCreate())
            tgt.setUpdateCreateElement(VersionConvertor_14_40.convertBoolean(src.getUpdateCreateElement()));
        if (src.hasConditionalCreate())
            tgt.setConditionalCreateElement(VersionConvertor_14_40.convertBoolean(src.getConditionalCreateElement()));
        if (src.hasConditionalUpdate())
            tgt.setConditionalUpdateElement(VersionConvertor_14_40.convertBoolean(src.getConditionalUpdateElement()));
        if (src.hasConditionalDelete())
            tgt.setConditionalDeleteElement(convertConditionalDeleteStatus(src.getConditionalDeleteElement()));
        for (org.hl7.fhir.r4.model.StringType t : src.getSearchInclude()) tgt.addSearchInclude(t.getValue());
        for (org.hl7.fhir.r4.model.StringType t : src.getSearchRevInclude()) tgt.addSearchRevInclude(t.getValue());
        for (org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent t : src.getSearchParam()) tgt.addSearchParam(convertConformanceRestResourceSearchParamComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestResourceComponent convertConformanceRestResourceComponent(org.hl7.fhir.dstu2016may.model.Conformance.ConformanceRestResourceComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestResourceComponent tgt = new org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestResourceComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        if (src.hasTypeElement())
            tgt.setTypeElement(VersionConvertor_14_40.convertCode(src.getTypeElement()));
        if (src.hasProfile())
            tgt.setProfileElement(VersionConvertor_14_40.convertReferenceToCanonical(src.getProfile()));
        for (org.hl7.fhir.dstu2016may.model.Conformance.ResourceInteractionComponent t : src.getInteraction()) tgt.addInteraction(convertResourceInteractionComponent(t));
        if (src.hasVersioning())
            tgt.setVersioningElement(convertResourceVersionPolicy(src.getVersioningElement()));
        if (src.hasReadHistory())
            tgt.setReadHistoryElement(VersionConvertor_14_40.convertBoolean(src.getReadHistoryElement()));
        if (src.hasUpdateCreate())
            tgt.setUpdateCreateElement(VersionConvertor_14_40.convertBoolean(src.getUpdateCreateElement()));
        if (src.hasConditionalCreate())
            tgt.setConditionalCreateElement(VersionConvertor_14_40.convertBoolean(src.getConditionalCreateElement()));
        if (src.hasConditionalUpdate())
            tgt.setConditionalUpdateElement(VersionConvertor_14_40.convertBoolean(src.getConditionalUpdateElement()));
        if (src.hasConditionalDelete())
            tgt.setConditionalDeleteElement(convertConditionalDeleteStatus(src.getConditionalDeleteElement()));
        for (org.hl7.fhir.dstu2016may.model.StringType t : src.getSearchInclude()) tgt.addSearchInclude(t.getValue());
        for (org.hl7.fhir.dstu2016may.model.StringType t : src.getSearchRevInclude()) tgt.addSearchRevInclude(t.getValue());
        for (org.hl7.fhir.dstu2016may.model.Conformance.ConformanceRestResourceSearchParamComponent t : src.getSearchParam()) tgt.addSearchParam(convertConformanceRestResourceSearchParamComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent convertConformanceRestResourceSearchParamComponent(org.hl7.fhir.dstu2016may.model.Conformance.ConformanceRestResourceSearchParamComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent tgt = new org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_14_40.convertString(src.getNameElement()));
        if (src.hasDefinition())
            tgt.setDefinition(src.getDefinition());
        if (src.hasType())
            tgt.setTypeElement(VersionConvertor_14_40.convertSearchParamType(src.getTypeElement()));
        if (src.hasDocumentation())
            tgt.setDocumentation(src.getDocumentation());
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Conformance.ConformanceRestResourceSearchParamComponent convertConformanceRestResourceSearchParamComponent(org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Conformance.ConformanceRestResourceSearchParamComponent tgt = new org.hl7.fhir.dstu2016may.model.Conformance.ConformanceRestResourceSearchParamComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_14_40.convertString(src.getNameElement()));
        if (src.hasDefinition())
            tgt.setDefinition(src.getDefinition());
        if (src.hasType())
            tgt.setTypeElement(VersionConvertor_14_40.convertSearchParamType(src.getTypeElement()));
        if (src.hasDocumentation())
            tgt.setDocumentation(src.getDocumentation());
        return tgt;
    }

    public static org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestSecurityComponent convertConformanceRestSecurityComponent(org.hl7.fhir.dstu2016may.model.Conformance.ConformanceRestSecurityComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestSecurityComponent tgt = new org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestSecurityComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        if (src.hasCors())
            tgt.setCorsElement(VersionConvertor_14_40.convertBoolean(src.getCorsElement()));
        for (org.hl7.fhir.dstu2016may.model.CodeableConcept t : src.getService()) tgt.addService(VersionConvertor_14_40.convertCodeableConcept(t));
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Conformance.ConformanceRestSecurityComponent convertConformanceRestSecurityComponent(org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementRestSecurityComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Conformance.ConformanceRestSecurityComponent tgt = new org.hl7.fhir.dstu2016may.model.Conformance.ConformanceRestSecurityComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        if (src.hasCors())
            tgt.setCorsElement(VersionConvertor_14_40.convertBoolean(src.getCorsElement()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getService()) tgt.addService(VersionConvertor_14_40.convertCodeableConcept(t));
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        return tgt;
    }

    public static org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementSoftwareComponent convertConformanceSoftwareComponent(org.hl7.fhir.dstu2016may.model.Conformance.ConformanceSoftwareComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementSoftwareComponent tgt = new org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementSoftwareComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_14_40.convertString(src.getNameElement()));
        if (src.hasVersion())
            tgt.setVersionElement(VersionConvertor_14_40.convertString(src.getVersionElement()));
        if (src.hasReleaseDate())
            tgt.setReleaseDateElement(VersionConvertor_14_40.convertDateTime(src.getReleaseDateElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Conformance.ConformanceSoftwareComponent convertConformanceSoftwareComponent(org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementSoftwareComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Conformance.ConformanceSoftwareComponent tgt = new org.hl7.fhir.dstu2016may.model.Conformance.ConformanceSoftwareComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_14_40.convertString(src.getNameElement()));
        if (src.hasVersion())
            tgt.setVersionElement(VersionConvertor_14_40.convertString(src.getVersionElement()));
        if (src.hasReleaseDate())
            tgt.setReleaseDateElement(VersionConvertor_14_40.convertDateTime(src.getReleaseDateElement()));
        return tgt;
    }

    static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Conformance.ConformanceStatementKind> convertConformanceStatementKind(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementKind> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Conformance.ConformanceStatementKind> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.Conformance.ConformanceStatementKindEnumFactory());
        VersionConvertor_14_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case INSTANCE:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Conformance.ConformanceStatementKind.INSTANCE);
                break;
            case CAPABILITY:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Conformance.ConformanceStatementKind.CAPABILITY);
                break;
            case REQUIREMENTS:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Conformance.ConformanceStatementKind.REQUIREMENTS);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Conformance.ConformanceStatementKind.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementKind> convertConformanceStatementKind(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Conformance.ConformanceStatementKind> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementKind> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementKindEnumFactory());
        VersionConvertor_14_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case INSTANCE:
                tgt.setValue(org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementKind.INSTANCE);
                break;
            case CAPABILITY:
                tgt.setValue(org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementKind.CAPABILITY);
                break;
            case REQUIREMENTS:
                tgt.setValue(org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementKind.REQUIREMENTS);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.CapabilityStatement.CapabilityStatementKind.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CapabilityStatement.DocumentMode> convertDocumentMode(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Conformance.DocumentMode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CapabilityStatement.DocumentMode> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.CapabilityStatement.DocumentModeEnumFactory());
        VersionConvertor_14_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case PRODUCER:
                tgt.setValue(org.hl7.fhir.r4.model.CapabilityStatement.DocumentMode.PRODUCER);
                break;
            case CONSUMER:
                tgt.setValue(org.hl7.fhir.r4.model.CapabilityStatement.DocumentMode.CONSUMER);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.CapabilityStatement.DocumentMode.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Conformance.DocumentMode> convertDocumentMode(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CapabilityStatement.DocumentMode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Conformance.DocumentMode> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.Conformance.DocumentModeEnumFactory());
        VersionConvertor_14_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case PRODUCER:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Conformance.DocumentMode.PRODUCER);
                break;
            case CONSUMER:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Conformance.DocumentMode.CONSUMER);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Conformance.DocumentMode.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.CapabilityStatement.ResourceInteractionComponent convertResourceInteractionComponent(org.hl7.fhir.dstu2016may.model.Conformance.ResourceInteractionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.CapabilityStatement.ResourceInteractionComponent tgt = new org.hl7.fhir.r4.model.CapabilityStatement.ResourceInteractionComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCodeElement(convertTypeRestfulInteraction(src.getCodeElement()));
        if (src.hasDocumentation())
            tgt.setDocumentation(src.getDocumentation());
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Conformance.ResourceInteractionComponent convertResourceInteractionComponent(org.hl7.fhir.r4.model.CapabilityStatement.ResourceInteractionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Conformance.ResourceInteractionComponent tgt = new org.hl7.fhir.dstu2016may.model.Conformance.ResourceInteractionComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCodeElement(convertTypeRestfulInteraction(src.getCodeElement()));
        if (src.hasDocumentation())
            tgt.setDocumentation(src.getDocumentation());
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CapabilityStatement.ResourceVersionPolicy> convertResourceVersionPolicy(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Conformance.ResourceVersionPolicy> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CapabilityStatement.ResourceVersionPolicy> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.CapabilityStatement.ResourceVersionPolicyEnumFactory());
        VersionConvertor_14_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case NOVERSION:
                tgt.setValue(org.hl7.fhir.r4.model.CapabilityStatement.ResourceVersionPolicy.NOVERSION);
                break;
            case VERSIONED:
                tgt.setValue(org.hl7.fhir.r4.model.CapabilityStatement.ResourceVersionPolicy.VERSIONED);
                break;
            case VERSIONEDUPDATE:
                tgt.setValue(org.hl7.fhir.r4.model.CapabilityStatement.ResourceVersionPolicy.VERSIONEDUPDATE);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.CapabilityStatement.ResourceVersionPolicy.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Conformance.ResourceVersionPolicy> convertResourceVersionPolicy(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CapabilityStatement.ResourceVersionPolicy> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Conformance.ResourceVersionPolicy> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.Conformance.ResourceVersionPolicyEnumFactory());
        VersionConvertor_14_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case NOVERSION:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Conformance.ResourceVersionPolicy.NOVERSION);
                break;
            case VERSIONED:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Conformance.ResourceVersionPolicy.VERSIONED);
                break;
            case VERSIONEDUPDATE:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Conformance.ResourceVersionPolicy.VERSIONEDUPDATE);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Conformance.ResourceVersionPolicy.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Conformance.RestfulConformanceMode> convertRestfulConformanceMode(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CapabilityStatement.RestfulCapabilityMode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Conformance.RestfulConformanceMode> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.Conformance.RestfulConformanceModeEnumFactory());
        VersionConvertor_14_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case CLIENT:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Conformance.RestfulConformanceMode.CLIENT);
                break;
            case SERVER:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Conformance.RestfulConformanceMode.SERVER);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Conformance.RestfulConformanceMode.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CapabilityStatement.RestfulCapabilityMode> convertRestfulConformanceMode(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Conformance.RestfulConformanceMode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CapabilityStatement.RestfulCapabilityMode> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.CapabilityStatement.RestfulCapabilityModeEnumFactory());
        VersionConvertor_14_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case CLIENT:
                tgt.setValue(org.hl7.fhir.r4.model.CapabilityStatement.RestfulCapabilityMode.CLIENT);
                break;
            case SERVER:
                tgt.setValue(org.hl7.fhir.r4.model.CapabilityStatement.RestfulCapabilityMode.SERVER);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.CapabilityStatement.RestfulCapabilityMode.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Conformance.SystemInteractionComponent convertSystemInteractionComponent(org.hl7.fhir.r4.model.CapabilityStatement.SystemInteractionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Conformance.SystemInteractionComponent tgt = new org.hl7.fhir.dstu2016may.model.Conformance.SystemInteractionComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCodeElement(convertSystemRestfulInteraction(src.getCodeElement()));
        if (src.hasDocumentation())
            tgt.setDocumentation(src.getDocumentation());
        return tgt;
    }

    public static org.hl7.fhir.r4.model.CapabilityStatement.SystemInteractionComponent convertSystemInteractionComponent(org.hl7.fhir.dstu2016may.model.Conformance.SystemInteractionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.CapabilityStatement.SystemInteractionComponent tgt = new org.hl7.fhir.r4.model.CapabilityStatement.SystemInteractionComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCodeElement(convertSystemRestfulInteraction(src.getCodeElement()));
        if (src.hasDocumentation())
            tgt.setDocumentation(src.getDocumentation());
        return tgt;
    }

    static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Conformance.SystemRestfulInteraction> convertSystemRestfulInteraction(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CapabilityStatement.SystemRestfulInteraction> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Conformance.SystemRestfulInteraction> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.Conformance.SystemRestfulInteractionEnumFactory());
        VersionConvertor_14_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case TRANSACTION:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Conformance.SystemRestfulInteraction.TRANSACTION);
                break;
            case SEARCHSYSTEM:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Conformance.SystemRestfulInteraction.SEARCHSYSTEM);
                break;
            case HISTORYSYSTEM:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Conformance.SystemRestfulInteraction.HISTORYSYSTEM);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Conformance.SystemRestfulInteraction.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CapabilityStatement.SystemRestfulInteraction> convertSystemRestfulInteraction(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Conformance.SystemRestfulInteraction> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CapabilityStatement.SystemRestfulInteraction> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.CapabilityStatement.SystemRestfulInteractionEnumFactory());
        VersionConvertor_14_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case TRANSACTION:
                tgt.setValue(org.hl7.fhir.r4.model.CapabilityStatement.SystemRestfulInteraction.TRANSACTION);
                break;
            case SEARCHSYSTEM:
                tgt.setValue(org.hl7.fhir.r4.model.CapabilityStatement.SystemRestfulInteraction.SEARCHSYSTEM);
                break;
            case HISTORYSYSTEM:
                tgt.setValue(org.hl7.fhir.r4.model.CapabilityStatement.SystemRestfulInteraction.HISTORYSYSTEM);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.CapabilityStatement.SystemRestfulInteraction.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CapabilityStatement.TypeRestfulInteraction> convertTypeRestfulInteraction(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Conformance.TypeRestfulInteraction> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CapabilityStatement.TypeRestfulInteraction> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.CapabilityStatement.TypeRestfulInteractionEnumFactory());
        VersionConvertor_14_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case READ:
                tgt.setValue(org.hl7.fhir.r4.model.CapabilityStatement.TypeRestfulInteraction.READ);
                break;
            case VREAD:
                tgt.setValue(org.hl7.fhir.r4.model.CapabilityStatement.TypeRestfulInteraction.VREAD);
                break;
            case UPDATE:
                tgt.setValue(org.hl7.fhir.r4.model.CapabilityStatement.TypeRestfulInteraction.UPDATE);
                break;
            case DELETE:
                tgt.setValue(org.hl7.fhir.r4.model.CapabilityStatement.TypeRestfulInteraction.DELETE);
                break;
            case HISTORYINSTANCE:
                tgt.setValue(org.hl7.fhir.r4.model.CapabilityStatement.TypeRestfulInteraction.HISTORYINSTANCE);
                break;
            case HISTORYTYPE:
                tgt.setValue(org.hl7.fhir.r4.model.CapabilityStatement.TypeRestfulInteraction.HISTORYTYPE);
                break;
            case CREATE:
                tgt.setValue(org.hl7.fhir.r4.model.CapabilityStatement.TypeRestfulInteraction.CREATE);
                break;
            case SEARCHTYPE:
                tgt.setValue(org.hl7.fhir.r4.model.CapabilityStatement.TypeRestfulInteraction.SEARCHTYPE);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.CapabilityStatement.TypeRestfulInteraction.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Conformance.TypeRestfulInteraction> convertTypeRestfulInteraction(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CapabilityStatement.TypeRestfulInteraction> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Conformance.TypeRestfulInteraction> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.Conformance.TypeRestfulInteractionEnumFactory());
        VersionConvertor_14_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case READ:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Conformance.TypeRestfulInteraction.READ);
                break;
            case VREAD:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Conformance.TypeRestfulInteraction.VREAD);
                break;
            case UPDATE:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Conformance.TypeRestfulInteraction.UPDATE);
                break;
            case DELETE:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Conformance.TypeRestfulInteraction.DELETE);
                break;
            case HISTORYINSTANCE:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Conformance.TypeRestfulInteraction.HISTORYINSTANCE);
                break;
            case HISTORYTYPE:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Conformance.TypeRestfulInteraction.HISTORYTYPE);
                break;
            case CREATE:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Conformance.TypeRestfulInteraction.CREATE);
                break;
            case SEARCHTYPE:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Conformance.TypeRestfulInteraction.SEARCHTYPE);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Conformance.TypeRestfulInteraction.NULL);
                break;
        }
        return tgt;
    }
}