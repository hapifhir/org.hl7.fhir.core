package org.hl7.fhir.convertors.conv14_30;

import org.hl7.fhir.convertors.VersionConvertor_14_30;
import org.hl7.fhir.exceptions.FHIRException;

public class Conformance14_30 {

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.ConditionalDeleteStatus> convertConditionalDeleteStatus(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Conformance.ConditionalDeleteStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.ConditionalDeleteStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.CapabilityStatement.ConditionalDeleteStatusEnumFactory());
        VersionConvertor_14_30.copyElement(src, tgt);
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

    static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Conformance.ConditionalDeleteStatus> convertConditionalDeleteStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.ConditionalDeleteStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Conformance.ConditionalDeleteStatus> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.Conformance.ConditionalDeleteStatusEnumFactory());
        VersionConvertor_14_30.copyElement(src, tgt);
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

    public static org.hl7.fhir.dstu2016may.model.Conformance convertConformance(org.hl7.fhir.dstu3.model.CapabilityStatement src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Conformance tgt = new org.hl7.fhir.dstu2016may.model.Conformance();
        VersionConvertor_14_30.copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrlElement(VersionConvertor_14_30.convertUri(src.getUrlElement()));
        if (src.hasVersion())
            tgt.setVersionElement(VersionConvertor_14_30.convertString(src.getVersionElement()));
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_14_30.convertString(src.getNameElement()));
        if (src.hasStatus())
            tgt.setStatusElement(VersionConvertor_14_30.convertConformanceResourceStatus(src.getStatusElement()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(VersionConvertor_14_30.convertBoolean(src.getExperimentalElement()));
        if (src.hasDate())
            tgt.setDateElement(VersionConvertor_14_30.convertDateTime(src.getDateElement()));
        if (src.hasPublisher())
            tgt.setPublisherElement(VersionConvertor_14_30.convertString(src.getPublisherElement()));
        for (org.hl7.fhir.dstu3.model.ContactDetail t : src.getContact()) tgt.addContact(convertConformanceContactComponent(t));
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.dstu3.model.UsageContext t : src.getUseContext()) if (t.hasValueCodeableConcept())
            tgt.addUseContext(VersionConvertor_14_30.convertCodeableConcept(t.getValueCodeableConcept()));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getJurisdiction()) tgt.addUseContext(VersionConvertor_14_30.convertCodeableConcept(t));
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
        if (src.hasFhirVersionElement())
            tgt.setFhirVersionElement(VersionConvertor_14_30.convertId(src.getFhirVersionElement()));
        if (src.hasAcceptUnknown())
            tgt.setAcceptUnknownElement(convertUnknownContentCode(src.getAcceptUnknownElement()));
        for (org.hl7.fhir.dstu3.model.CodeType t : src.getFormat()) tgt.addFormat(t.getValue());
        for (org.hl7.fhir.dstu3.model.Reference t : src.getProfile()) tgt.addProfile(VersionConvertor_14_30.convertReference(t));
        for (org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestComponent t : src.getRest()) tgt.addRest(convertConformanceRestComponent(t));
        for (org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingComponent t : src.getMessaging()) tgt.addMessaging(convertConformanceMessagingComponent(t));
        for (org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementDocumentComponent t : src.getDocument()) tgt.addDocument(convertConformanceDocumentComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CapabilityStatement convertConformance(org.hl7.fhir.dstu2016may.model.Conformance src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.CapabilityStatement tgt = new org.hl7.fhir.dstu3.model.CapabilityStatement();
        VersionConvertor_14_30.copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrlElement(VersionConvertor_14_30.convertUri(src.getUrlElement()));
        if (src.hasVersion())
            tgt.setVersionElement(VersionConvertor_14_30.convertString(src.getVersionElement()));
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_14_30.convertString(src.getNameElement()));
        if (src.hasStatus())
            tgt.setStatusElement(VersionConvertor_14_30.convertConformanceResourceStatus(src.getStatusElement()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(VersionConvertor_14_30.convertBoolean(src.getExperimentalElement()));
        if (src.hasDate())
            tgt.setDateElement(VersionConvertor_14_30.convertDateTime(src.getDateElement()));
        if (src.hasPublisher())
            tgt.setPublisherElement(VersionConvertor_14_30.convertString(src.getPublisherElement()));
        for (org.hl7.fhir.dstu2016may.model.Conformance.ConformanceContactComponent t : src.getContact()) tgt.addContact(convertConformanceContactComponent(t));
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.dstu2016may.model.CodeableConcept t : src.getUseContext()) if (VersionConvertor_14_30.isJurisdiction(t))
            tgt.addJurisdiction(VersionConvertor_14_30.convertCodeableConcept(t));
        else
            tgt.addUseContext(VersionConvertor_14_30.convertCodeableConceptToUsageContext(t));
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
        if (src.hasFhirVersionElement())
            tgt.setFhirVersionElement(VersionConvertor_14_30.convertId(src.getFhirVersionElement()));
        if (src.hasAcceptUnknown())
            tgt.setAcceptUnknownElement(convertUnknownContentCode(src.getAcceptUnknownElement()));
        for (org.hl7.fhir.dstu2016may.model.CodeType t : src.getFormat()) tgt.addFormat(t.getValue());
        for (org.hl7.fhir.dstu2016may.model.Reference t : src.getProfile()) tgt.addProfile(VersionConvertor_14_30.convertReference(t));
        for (org.hl7.fhir.dstu2016may.model.Conformance.ConformanceRestComponent t : src.getRest()) tgt.addRest(convertConformanceRestComponent(t));
        for (org.hl7.fhir.dstu2016may.model.Conformance.ConformanceMessagingComponent t : src.getMessaging()) tgt.addMessaging(convertConformanceMessagingComponent(t));
        for (org.hl7.fhir.dstu2016may.model.Conformance.ConformanceDocumentComponent t : src.getDocument()) tgt.addDocument(convertConformanceDocumentComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ContactDetail convertConformanceContactComponent(org.hl7.fhir.dstu2016may.model.Conformance.ConformanceContactComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ContactDetail tgt = new org.hl7.fhir.dstu3.model.ContactDetail();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_14_30.convertString(src.getNameElement()));
        for (org.hl7.fhir.dstu2016may.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_14_30.convertContactPoint(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Conformance.ConformanceContactComponent convertConformanceContactComponent(org.hl7.fhir.dstu3.model.ContactDetail src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Conformance.ConformanceContactComponent tgt = new org.hl7.fhir.dstu2016may.model.Conformance.ConformanceContactComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_14_30.convertString(src.getNameElement()));
        for (org.hl7.fhir.dstu3.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_14_30.convertContactPoint(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Conformance.ConformanceDocumentComponent convertConformanceDocumentComponent(org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementDocumentComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Conformance.ConformanceDocumentComponent tgt = new org.hl7.fhir.dstu2016may.model.Conformance.ConformanceDocumentComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasMode())
            tgt.setModeElement(convertDocumentMode(src.getModeElement()));
        if (src.hasDocumentation())
            tgt.setDocumentationElement(VersionConvertor_14_30.convertString(src.getDocumentationElement()));
        if (src.hasProfile())
            tgt.setProfile(VersionConvertor_14_30.convertReference(src.getProfile()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementDocumentComponent convertConformanceDocumentComponent(org.hl7.fhir.dstu2016may.model.Conformance.ConformanceDocumentComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementDocumentComponent tgt = new org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementDocumentComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasMode())
            tgt.setModeElement(convertDocumentMode(src.getModeElement()));
        if (src.hasDocumentation())
            tgt.setDocumentationElement(VersionConvertor_14_30.convertString(src.getDocumentationElement()));
        if (src.hasProfile())
            tgt.setProfile(VersionConvertor_14_30.convertReference(src.getProfile()));
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.EventCapabilityMode> convertConformanceEventMode(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Conformance.ConformanceEventMode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.EventCapabilityMode> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.CapabilityStatement.EventCapabilityModeEnumFactory());
        VersionConvertor_14_30.copyElement(src, tgt);
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

    static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Conformance.ConformanceEventMode> convertConformanceEventMode(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.EventCapabilityMode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Conformance.ConformanceEventMode> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.Conformance.ConformanceEventModeEnumFactory());
        VersionConvertor_14_30.copyElement(src, tgt);
        switch(src.getValue()) {
            case SENDER:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Conformance.ConformanceEventMode.SENDER);
                break;
            case RECEIVER:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Conformance.ConformanceEventMode.RECEIVER);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Conformance.ConformanceEventMode.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Conformance.ConformanceImplementationComponent convertConformanceImplementationComponent(org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementImplementationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Conformance.ConformanceImplementationComponent tgt = new org.hl7.fhir.dstu2016may.model.Conformance.ConformanceImplementationComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement(VersionConvertor_14_30.convertString(src.getDescriptionElement()));
        if (src.hasUrl())
            tgt.setUrlElement(VersionConvertor_14_30.convertUri(src.getUrlElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementImplementationComponent convertConformanceImplementationComponent(org.hl7.fhir.dstu2016may.model.Conformance.ConformanceImplementationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementImplementationComponent tgt = new org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementImplementationComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement(VersionConvertor_14_30.convertString(src.getDescriptionElement()));
        if (src.hasUrl())
            tgt.setUrlElement(VersionConvertor_14_30.convertUri(src.getUrlElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Conformance.ConformanceMessagingComponent convertConformanceMessagingComponent(org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Conformance.ConformanceMessagingComponent tgt = new org.hl7.fhir.dstu2016may.model.Conformance.ConformanceMessagingComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        for (org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingEndpointComponent t : src.getEndpoint()) tgt.addEndpoint(convertConformanceMessagingEndpointComponent(t));
        if (src.hasReliableCache())
            tgt.setReliableCacheElement(VersionConvertor_14_30.convertUnsignedInt(src.getReliableCacheElement()));
        if (src.hasDocumentation())
            tgt.setDocumentationElement(VersionConvertor_14_30.convertString(src.getDocumentationElement()));
        for (org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingEventComponent t : src.getEvent()) tgt.addEvent(convertConformanceMessagingEventComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingComponent convertConformanceMessagingComponent(org.hl7.fhir.dstu2016may.model.Conformance.ConformanceMessagingComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingComponent tgt = new org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        for (org.hl7.fhir.dstu2016may.model.Conformance.ConformanceMessagingEndpointComponent t : src.getEndpoint()) tgt.addEndpoint(convertConformanceMessagingEndpointComponent(t));
        if (src.hasReliableCache())
            tgt.setReliableCacheElement(VersionConvertor_14_30.convertUnsignedInt(src.getReliableCacheElement()));
        if (src.hasDocumentation())
            tgt.setDocumentationElement(VersionConvertor_14_30.convertString(src.getDocumentationElement()));
        for (org.hl7.fhir.dstu2016may.model.Conformance.ConformanceMessagingEventComponent t : src.getEvent()) tgt.addEvent(convertConformanceMessagingEventComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingEndpointComponent convertConformanceMessagingEndpointComponent(org.hl7.fhir.dstu2016may.model.Conformance.ConformanceMessagingEndpointComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingEndpointComponent tgt = new org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingEndpointComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasProtocol())
            tgt.setProtocol(VersionConvertor_14_30.convertCoding(src.getProtocol()));
        if (src.hasAddressElement())
            tgt.setAddressElement(VersionConvertor_14_30.convertUri(src.getAddressElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Conformance.ConformanceMessagingEndpointComponent convertConformanceMessagingEndpointComponent(org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingEndpointComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Conformance.ConformanceMessagingEndpointComponent tgt = new org.hl7.fhir.dstu2016may.model.Conformance.ConformanceMessagingEndpointComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasProtocol())
            tgt.setProtocol(VersionConvertor_14_30.convertCoding(src.getProtocol()));
        if (src.hasAddressElement())
            tgt.setAddressElement(VersionConvertor_14_30.convertUri(src.getAddressElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingEventComponent convertConformanceMessagingEventComponent(org.hl7.fhir.dstu2016may.model.Conformance.ConformanceMessagingEventComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingEventComponent tgt = new org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingEventComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCode(VersionConvertor_14_30.convertCoding(src.getCode()));
        if (src.hasCategory())
            tgt.setCategoryElement(convertMessageSignificanceCategory(src.getCategoryElement()));
        if (src.hasMode())
            tgt.setModeElement(convertConformanceEventMode(src.getModeElement()));
        if (src.hasFocusElement())
            tgt.setFocusElement(VersionConvertor_14_30.convertCode(src.getFocusElement()));
        if (src.hasRequest())
            tgt.setRequest(VersionConvertor_14_30.convertReference(src.getRequest()));
        if (src.hasResponse())
            tgt.setResponse(VersionConvertor_14_30.convertReference(src.getResponse()));
        if (src.hasDocumentation())
            tgt.setDocumentationElement(VersionConvertor_14_30.convertString(src.getDocumentationElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Conformance.ConformanceMessagingEventComponent convertConformanceMessagingEventComponent(org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingEventComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Conformance.ConformanceMessagingEventComponent tgt = new org.hl7.fhir.dstu2016may.model.Conformance.ConformanceMessagingEventComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCode(VersionConvertor_14_30.convertCoding(src.getCode()));
        if (src.hasCategory())
            tgt.setCategoryElement(convertMessageSignificanceCategory(src.getCategoryElement()));
        if (src.hasMode())
            tgt.setModeElement(convertConformanceEventMode(src.getModeElement()));
        if (src.hasFocusElement())
            tgt.setFocusElement(VersionConvertor_14_30.convertCode(src.getFocusElement()));
        if (src.hasRequest())
            tgt.setRequest(VersionConvertor_14_30.convertReference(src.getRequest()));
        if (src.hasResponse())
            tgt.setResponse(VersionConvertor_14_30.convertReference(src.getResponse()));
        if (src.hasDocumentation())
            tgt.setDocumentationElement(VersionConvertor_14_30.convertString(src.getDocumentationElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestComponent convertConformanceRestComponent(org.hl7.fhir.dstu2016may.model.Conformance.ConformanceRestComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestComponent tgt = new org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasMode())
            tgt.setModeElement(convertRestfulConformanceMode(src.getModeElement()));
        if (src.hasDocumentation())
            tgt.setDocumentationElement(VersionConvertor_14_30.convertString(src.getDocumentationElement()));
        if (src.hasSecurity())
            tgt.setSecurity(convertConformanceRestSecurityComponent(src.getSecurity()));
        for (org.hl7.fhir.dstu2016may.model.Conformance.ConformanceRestResourceComponent t : src.getResource()) tgt.addResource(convertConformanceRestResourceComponent(t));
        for (org.hl7.fhir.dstu2016may.model.Conformance.SystemInteractionComponent t : src.getInteraction()) tgt.addInteraction(convertSystemInteractionComponent(t));
        for (org.hl7.fhir.dstu2016may.model.Conformance.ConformanceRestResourceSearchParamComponent t : src.getSearchParam()) tgt.addSearchParam(convertConformanceRestResourceSearchParamComponent(t));
        for (org.hl7.fhir.dstu2016may.model.Conformance.ConformanceRestOperationComponent t : src.getOperation()) tgt.addOperation(convertConformanceRestOperationComponent(t));
        for (org.hl7.fhir.dstu2016may.model.UriType t : src.getCompartment()) tgt.addCompartment(t.getValue());
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Conformance.ConformanceRestComponent convertConformanceRestComponent(org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Conformance.ConformanceRestComponent tgt = new org.hl7.fhir.dstu2016may.model.Conformance.ConformanceRestComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasMode())
            tgt.setModeElement(convertRestfulConformanceMode(src.getModeElement()));
        if (src.hasDocumentation())
            tgt.setDocumentationElement(VersionConvertor_14_30.convertString(src.getDocumentationElement()));
        if (src.hasSecurity())
            tgt.setSecurity(convertConformanceRestSecurityComponent(src.getSecurity()));
        for (org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestResourceComponent t : src.getResource()) tgt.addResource(convertConformanceRestResourceComponent(t));
        for (org.hl7.fhir.dstu3.model.CapabilityStatement.SystemInteractionComponent t : src.getInteraction()) tgt.addInteraction(convertSystemInteractionComponent(t));
        for (org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent t : src.getSearchParam()) tgt.addSearchParam(convertConformanceRestResourceSearchParamComponent(t));
        for (org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestOperationComponent t : src.getOperation()) tgt.addOperation(convertConformanceRestOperationComponent(t));
        for (org.hl7.fhir.dstu3.model.UriType t : src.getCompartment()) tgt.addCompartment(t.getValue());
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Conformance.ConformanceRestOperationComponent convertConformanceRestOperationComponent(org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestOperationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Conformance.ConformanceRestOperationComponent tgt = new org.hl7.fhir.dstu2016may.model.Conformance.ConformanceRestOperationComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_14_30.convertString(src.getNameElement()));
        if (src.hasDefinition())
            tgt.setDefinition(VersionConvertor_14_30.convertReference(src.getDefinition()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestOperationComponent convertConformanceRestOperationComponent(org.hl7.fhir.dstu2016may.model.Conformance.ConformanceRestOperationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestOperationComponent tgt = new org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestOperationComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_14_30.convertString(src.getNameElement()));
        if (src.hasDefinition())
            tgt.setDefinition(VersionConvertor_14_30.convertReference(src.getDefinition()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Conformance.ConformanceRestResourceComponent convertConformanceRestResourceComponent(org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestResourceComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Conformance.ConformanceRestResourceComponent tgt = new org.hl7.fhir.dstu2016may.model.Conformance.ConformanceRestResourceComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasTypeElement())
            tgt.setTypeElement(VersionConvertor_14_30.convertCode(src.getTypeElement()));
        if (src.hasProfile())
            tgt.setProfile(VersionConvertor_14_30.convertReference(src.getProfile()));
        for (org.hl7.fhir.dstu3.model.CapabilityStatement.ResourceInteractionComponent t : src.getInteraction()) tgt.addInteraction(convertResourceInteractionComponent(t));
        if (src.hasVersioning())
            tgt.setVersioningElement(convertResourceVersionPolicy(src.getVersioningElement()));
        if (src.hasReadHistory())
            tgt.setReadHistoryElement(VersionConvertor_14_30.convertBoolean(src.getReadHistoryElement()));
        if (src.hasUpdateCreate())
            tgt.setUpdateCreateElement(VersionConvertor_14_30.convertBoolean(src.getUpdateCreateElement()));
        if (src.hasConditionalCreate())
            tgt.setConditionalCreateElement(VersionConvertor_14_30.convertBoolean(src.getConditionalCreateElement()));
        if (src.hasConditionalUpdate())
            tgt.setConditionalUpdateElement(VersionConvertor_14_30.convertBoolean(src.getConditionalUpdateElement()));
        if (src.hasConditionalDelete())
            tgt.setConditionalDeleteElement(convertConditionalDeleteStatus(src.getConditionalDeleteElement()));
        for (org.hl7.fhir.dstu3.model.StringType t : src.getSearchInclude()) tgt.addSearchInclude(t.getValue());
        for (org.hl7.fhir.dstu3.model.StringType t : src.getSearchRevInclude()) tgt.addSearchRevInclude(t.getValue());
        for (org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent t : src.getSearchParam()) tgt.addSearchParam(convertConformanceRestResourceSearchParamComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestResourceComponent convertConformanceRestResourceComponent(org.hl7.fhir.dstu2016may.model.Conformance.ConformanceRestResourceComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestResourceComponent tgt = new org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestResourceComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasTypeElement())
            tgt.setTypeElement(VersionConvertor_14_30.convertCode(src.getTypeElement()));
        if (src.hasProfile())
            tgt.setProfile(VersionConvertor_14_30.convertReference(src.getProfile()));
        for (org.hl7.fhir.dstu2016may.model.Conformance.ResourceInteractionComponent t : src.getInteraction()) tgt.addInteraction(convertResourceInteractionComponent(t));
        if (src.hasVersioning())
            tgt.setVersioningElement(convertResourceVersionPolicy(src.getVersioningElement()));
        if (src.hasReadHistory())
            tgt.setReadHistoryElement(VersionConvertor_14_30.convertBoolean(src.getReadHistoryElement()));
        if (src.hasUpdateCreate())
            tgt.setUpdateCreateElement(VersionConvertor_14_30.convertBoolean(src.getUpdateCreateElement()));
        if (src.hasConditionalCreate())
            tgt.setConditionalCreateElement(VersionConvertor_14_30.convertBoolean(src.getConditionalCreateElement()));
        if (src.hasConditionalUpdate())
            tgt.setConditionalUpdateElement(VersionConvertor_14_30.convertBoolean(src.getConditionalUpdateElement()));
        if (src.hasConditionalDelete())
            tgt.setConditionalDeleteElement(convertConditionalDeleteStatus(src.getConditionalDeleteElement()));
        for (org.hl7.fhir.dstu2016may.model.StringType t : src.getSearchInclude()) tgt.addSearchInclude(t.getValue());
        for (org.hl7.fhir.dstu2016may.model.StringType t : src.getSearchRevInclude()) tgt.addSearchRevInclude(t.getValue());
        for (org.hl7.fhir.dstu2016may.model.Conformance.ConformanceRestResourceSearchParamComponent t : src.getSearchParam()) tgt.addSearchParam(convertConformanceRestResourceSearchParamComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent convertConformanceRestResourceSearchParamComponent(org.hl7.fhir.dstu2016may.model.Conformance.ConformanceRestResourceSearchParamComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent tgt = new org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_14_30.convertString(src.getNameElement()));
        if (src.hasDefinition())
            tgt.setDefinitionElement(VersionConvertor_14_30.convertUri(src.getDefinitionElement()));
        if (src.hasType())
            tgt.setTypeElement(VersionConvertor_14_30.convertSearchParamType(src.getTypeElement()));
        if (src.hasDocumentation())
            tgt.setDocumentationElement(VersionConvertor_14_30.convertString(src.getDocumentationElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Conformance.ConformanceRestResourceSearchParamComponent convertConformanceRestResourceSearchParamComponent(org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Conformance.ConformanceRestResourceSearchParamComponent tgt = new org.hl7.fhir.dstu2016may.model.Conformance.ConformanceRestResourceSearchParamComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_14_30.convertString(src.getNameElement()));
        if (src.hasDefinition())
            tgt.setDefinitionElement(VersionConvertor_14_30.convertUri(src.getDefinitionElement()));
        if (src.hasType())
            tgt.setTypeElement(VersionConvertor_14_30.convertSearchParamType(src.getTypeElement()));
        if (src.hasDocumentation())
            tgt.setDocumentationElement(VersionConvertor_14_30.convertString(src.getDocumentationElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestSecurityCertificateComponent convertConformanceRestSecurityCertificateComponent(org.hl7.fhir.dstu2016may.model.Conformance.ConformanceRestSecurityCertificateComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestSecurityCertificateComponent tgt = new org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestSecurityCertificateComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasType())
            tgt.setTypeElement(VersionConvertor_14_30.convertCode(src.getTypeElement()));
        if (src.hasBlob())
            tgt.setBlobElement(VersionConvertor_14_30.convertBase64Binary(src.getBlobElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Conformance.ConformanceRestSecurityCertificateComponent convertConformanceRestSecurityCertificateComponent(org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestSecurityCertificateComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Conformance.ConformanceRestSecurityCertificateComponent tgt = new org.hl7.fhir.dstu2016may.model.Conformance.ConformanceRestSecurityCertificateComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasType())
            tgt.setTypeElement(VersionConvertor_14_30.convertCode(src.getTypeElement()));
        if (src.hasBlob())
            tgt.setBlobElement(VersionConvertor_14_30.convertBase64Binary(src.getBlobElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Conformance.ConformanceRestSecurityComponent convertConformanceRestSecurityComponent(org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestSecurityComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Conformance.ConformanceRestSecurityComponent tgt = new org.hl7.fhir.dstu2016may.model.Conformance.ConformanceRestSecurityComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasCors())
            tgt.setCorsElement(VersionConvertor_14_30.convertBoolean(src.getCorsElement()));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getService()) tgt.addService(VersionConvertor_14_30.convertCodeableConcept(t));
        if (src.hasDescription())
            tgt.setDescriptionElement(VersionConvertor_14_30.convertString(src.getDescriptionElement()));
        for (org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestSecurityCertificateComponent t : src.getCertificate()) tgt.addCertificate(convertConformanceRestSecurityCertificateComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestSecurityComponent convertConformanceRestSecurityComponent(org.hl7.fhir.dstu2016may.model.Conformance.ConformanceRestSecurityComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestSecurityComponent tgt = new org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestSecurityComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasCors())
            tgt.setCorsElement(VersionConvertor_14_30.convertBoolean(src.getCorsElement()));
        for (org.hl7.fhir.dstu2016may.model.CodeableConcept t : src.getService()) tgt.addService(VersionConvertor_14_30.convertCodeableConcept(t));
        if (src.hasDescription())
            tgt.setDescriptionElement(VersionConvertor_14_30.convertString(src.getDescriptionElement()));
        for (org.hl7.fhir.dstu2016may.model.Conformance.ConformanceRestSecurityCertificateComponent t : src.getCertificate()) tgt.addCertificate(convertConformanceRestSecurityCertificateComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementSoftwareComponent convertConformanceSoftwareComponent(org.hl7.fhir.dstu2016may.model.Conformance.ConformanceSoftwareComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementSoftwareComponent tgt = new org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementSoftwareComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_14_30.convertString(src.getNameElement()));
        if (src.hasVersion())
            tgt.setVersionElement(VersionConvertor_14_30.convertString(src.getVersionElement()));
        if (src.hasReleaseDate())
            tgt.setReleaseDateElement(VersionConvertor_14_30.convertDateTime(src.getReleaseDateElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Conformance.ConformanceSoftwareComponent convertConformanceSoftwareComponent(org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementSoftwareComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Conformance.ConformanceSoftwareComponent tgt = new org.hl7.fhir.dstu2016may.model.Conformance.ConformanceSoftwareComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_14_30.convertString(src.getNameElement()));
        if (src.hasVersion())
            tgt.setVersionElement(VersionConvertor_14_30.convertString(src.getVersionElement()));
        if (src.hasReleaseDate())
            tgt.setReleaseDateElement(VersionConvertor_14_30.convertDateTime(src.getReleaseDateElement()));
        return tgt;
    }

    static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Conformance.ConformanceStatementKind> convertConformanceStatementKind(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementKind> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Conformance.ConformanceStatementKind> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.Conformance.ConformanceStatementKindEnumFactory());
        VersionConvertor_14_30.copyElement(src, tgt);
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

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementKind> convertConformanceStatementKind(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Conformance.ConformanceStatementKind> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementKind> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementKindEnumFactory());
        VersionConvertor_14_30.copyElement(src, tgt);
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

    static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Conformance.DocumentMode> convertDocumentMode(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.DocumentMode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Conformance.DocumentMode> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.Conformance.DocumentModeEnumFactory());
        VersionConvertor_14_30.copyElement(src, tgt);
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

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.DocumentMode> convertDocumentMode(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Conformance.DocumentMode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.DocumentMode> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.CapabilityStatement.DocumentModeEnumFactory());
        VersionConvertor_14_30.copyElement(src, tgt);
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

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.MessageSignificanceCategory> convertMessageSignificanceCategory(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Conformance.MessageSignificanceCategory> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.MessageSignificanceCategory> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.CapabilityStatement.MessageSignificanceCategoryEnumFactory());
        VersionConvertor_14_30.copyElement(src, tgt);
        switch(src.getValue()) {
            case CONSEQUENCE:
                tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.MessageSignificanceCategory.CONSEQUENCE);
                break;
            case CURRENCY:
                tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.MessageSignificanceCategory.CURRENCY);
                break;
            case NOTIFICATION:
                tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.MessageSignificanceCategory.NOTIFICATION);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.MessageSignificanceCategory.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Conformance.MessageSignificanceCategory> convertMessageSignificanceCategory(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.MessageSignificanceCategory> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Conformance.MessageSignificanceCategory> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.Conformance.MessageSignificanceCategoryEnumFactory());
        VersionConvertor_14_30.copyElement(src, tgt);
        switch(src.getValue()) {
            case CONSEQUENCE:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Conformance.MessageSignificanceCategory.CONSEQUENCE);
                break;
            case CURRENCY:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Conformance.MessageSignificanceCategory.CURRENCY);
                break;
            case NOTIFICATION:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Conformance.MessageSignificanceCategory.NOTIFICATION);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Conformance.MessageSignificanceCategory.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CapabilityStatement.ResourceInteractionComponent convertResourceInteractionComponent(org.hl7.fhir.dstu2016may.model.Conformance.ResourceInteractionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.CapabilityStatement.ResourceInteractionComponent tgt = new org.hl7.fhir.dstu3.model.CapabilityStatement.ResourceInteractionComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCodeElement(convertTypeRestfulInteraction(src.getCodeElement()));
        if (src.hasDocumentation())
            tgt.setDocumentationElement(VersionConvertor_14_30.convertString(src.getDocumentationElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Conformance.ResourceInteractionComponent convertResourceInteractionComponent(org.hl7.fhir.dstu3.model.CapabilityStatement.ResourceInteractionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Conformance.ResourceInteractionComponent tgt = new org.hl7.fhir.dstu2016may.model.Conformance.ResourceInteractionComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCodeElement(convertTypeRestfulInteraction(src.getCodeElement()));
        if (src.hasDocumentation())
            tgt.setDocumentationElement(VersionConvertor_14_30.convertString(src.getDocumentationElement()));
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.ResourceVersionPolicy> convertResourceVersionPolicy(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Conformance.ResourceVersionPolicy> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.ResourceVersionPolicy> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.CapabilityStatement.ResourceVersionPolicyEnumFactory());
        VersionConvertor_14_30.copyElement(src, tgt);
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

    static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Conformance.ResourceVersionPolicy> convertResourceVersionPolicy(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.ResourceVersionPolicy> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Conformance.ResourceVersionPolicy> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.Conformance.ResourceVersionPolicyEnumFactory());
        VersionConvertor_14_30.copyElement(src, tgt);
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

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.RestfulCapabilityMode> convertRestfulConformanceMode(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Conformance.RestfulConformanceMode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.RestfulCapabilityMode> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.CapabilityStatement.RestfulCapabilityModeEnumFactory());
        VersionConvertor_14_30.copyElement(src, tgt);
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

    static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Conformance.RestfulConformanceMode> convertRestfulConformanceMode(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.RestfulCapabilityMode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Conformance.RestfulConformanceMode> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.Conformance.RestfulConformanceModeEnumFactory());
        VersionConvertor_14_30.copyElement(src, tgt);
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

    public static org.hl7.fhir.dstu2016may.model.Conformance.SystemInteractionComponent convertSystemInteractionComponent(org.hl7.fhir.dstu3.model.CapabilityStatement.SystemInteractionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Conformance.SystemInteractionComponent tgt = new org.hl7.fhir.dstu2016may.model.Conformance.SystemInteractionComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCodeElement(convertSystemRestfulInteraction(src.getCodeElement()));
        if (src.hasDocumentation())
            tgt.setDocumentationElement(VersionConvertor_14_30.convertString(src.getDocumentationElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CapabilityStatement.SystemInteractionComponent convertSystemInteractionComponent(org.hl7.fhir.dstu2016may.model.Conformance.SystemInteractionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.CapabilityStatement.SystemInteractionComponent tgt = new org.hl7.fhir.dstu3.model.CapabilityStatement.SystemInteractionComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCodeElement(convertSystemRestfulInteraction(src.getCodeElement()));
        if (src.hasDocumentation())
            tgt.setDocumentationElement(VersionConvertor_14_30.convertString(src.getDocumentationElement()));
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.SystemRestfulInteraction> convertSystemRestfulInteraction(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Conformance.SystemRestfulInteraction> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.SystemRestfulInteraction> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.CapabilityStatement.SystemRestfulInteractionEnumFactory());
        VersionConvertor_14_30.copyElement(src, tgt);
        switch(src.getValue()) {
            case TRANSACTION:
                tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.SystemRestfulInteraction.TRANSACTION);
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

    static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Conformance.SystemRestfulInteraction> convertSystemRestfulInteraction(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.SystemRestfulInteraction> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Conformance.SystemRestfulInteraction> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.Conformance.SystemRestfulInteractionEnumFactory());
        VersionConvertor_14_30.copyElement(src, tgt);
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

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.TypeRestfulInteraction> convertTypeRestfulInteraction(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Conformance.TypeRestfulInteraction> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.TypeRestfulInteraction> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.CapabilityStatement.TypeRestfulInteractionEnumFactory());
        VersionConvertor_14_30.copyElement(src, tgt);
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

    static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Conformance.TypeRestfulInteraction> convertTypeRestfulInteraction(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.TypeRestfulInteraction> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Conformance.TypeRestfulInteraction> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.Conformance.TypeRestfulInteractionEnumFactory());
        VersionConvertor_14_30.copyElement(src, tgt);
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

    static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Conformance.UnknownContentCode> convertUnknownContentCode(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.UnknownContentCode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Conformance.UnknownContentCode> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.Conformance.UnknownContentCodeEnumFactory());
        VersionConvertor_14_30.copyElement(src, tgt);
        switch(src.getValue()) {
            case NO:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Conformance.UnknownContentCode.NO);
                break;
            case EXTENSIONS:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Conformance.UnknownContentCode.EXTENSIONS);
                break;
            case ELEMENTS:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Conformance.UnknownContentCode.ELEMENTS);
                break;
            case BOTH:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Conformance.UnknownContentCode.BOTH);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.Conformance.UnknownContentCode.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.UnknownContentCode> convertUnknownContentCode(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.Conformance.UnknownContentCode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.CapabilityStatement.UnknownContentCode> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.CapabilityStatement.UnknownContentCodeEnumFactory());
        VersionConvertor_14_30.copyElement(src, tgt);
        switch(src.getValue()) {
            case NO:
                tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.UnknownContentCode.NO);
                break;
            case EXTENSIONS:
                tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.UnknownContentCode.EXTENSIONS);
                break;
            case ELEMENTS:
                tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.UnknownContentCode.ELEMENTS);
                break;
            case BOTH:
                tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.UnknownContentCode.BOTH);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.CapabilityStatement.UnknownContentCode.NULL);
                break;
        }
        return tgt;
    }
}