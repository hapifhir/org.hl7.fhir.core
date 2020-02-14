package org.hl7.fhir.convertors.conv10_30;

import org.hl7.fhir.convertors.VersionConvertor_10_30;
import org.hl7.fhir.dstu3.model.CapabilityStatement.SystemRestfulInteraction;
import org.hl7.fhir.exceptions.FHIRException;

public class Conformance10_30 {

    public static org.hl7.fhir.dstu2.model.Conformance.ConditionalDeleteStatus convertConditionalDeleteStatus(org.hl7.fhir.dstu3.model.CapabilityStatement.ConditionalDeleteStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case NOTSUPPORTED:
                return org.hl7.fhir.dstu2.model.Conformance.ConditionalDeleteStatus.NOTSUPPORTED;
            case SINGLE:
                return org.hl7.fhir.dstu2.model.Conformance.ConditionalDeleteStatus.SINGLE;
            case MULTIPLE:
                return org.hl7.fhir.dstu2.model.Conformance.ConditionalDeleteStatus.MULTIPLE;
            default:
                return org.hl7.fhir.dstu2.model.Conformance.ConditionalDeleteStatus.NULL;
        }
    }

    public static org.hl7.fhir.dstu3.model.CapabilityStatement.ConditionalDeleteStatus convertConditionalDeleteStatus(org.hl7.fhir.dstu2.model.Conformance.ConditionalDeleteStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case NOTSUPPORTED:
                return org.hl7.fhir.dstu3.model.CapabilityStatement.ConditionalDeleteStatus.NOTSUPPORTED;
            case SINGLE:
                return org.hl7.fhir.dstu3.model.CapabilityStatement.ConditionalDeleteStatus.SINGLE;
            case MULTIPLE:
                return org.hl7.fhir.dstu3.model.CapabilityStatement.ConditionalDeleteStatus.MULTIPLE;
            default:
                return org.hl7.fhir.dstu3.model.CapabilityStatement.ConditionalDeleteStatus.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.Conformance convertConformance(org.hl7.fhir.dstu3.model.CapabilityStatement src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Conformance tgt = new org.hl7.fhir.dstu2.model.Conformance();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        if (src.hasUrlElement())
            tgt.setUrlElement(VersionConvertor_10_30.convertUri(src.getUrlElement()));
        if (src.hasVersionElement())
            tgt.setVersionElement(VersionConvertor_10_30.convertString(src.getVersionElement()));
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_10_30.convertString(src.getNameElement()));
        if (src.hasStatus())
            tgt.setStatus(VersionConvertor_10_30.convertConformanceResourceStatus(src.getStatus()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(VersionConvertor_10_30.convertBoolean(src.getExperimentalElement()));
        if (src.hasDate())
            tgt.setDateElement(VersionConvertor_10_30.convertDateTime(src.getDateElement()));
        if (src.hasPublisherElement())
            tgt.setPublisherElement(VersionConvertor_10_30.convertString(src.getPublisherElement()));
        for (org.hl7.fhir.dstu3.model.ContactDetail t : src.getContact()) tgt.addContact(convertConformanceContactComponent(t));
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        if (src.hasPurpose())
            tgt.setRequirements(src.getPurpose());
        if (src.hasCopyright())
            tgt.setCopyright(src.getCopyright());
        if (src.hasKind())
            tgt.setKind(convertConformanceStatementKind(src.getKind()));
        if (src.hasSoftware())
            tgt.setSoftware(convertConformanceSoftwareComponent(src.getSoftware()));
        if (src.hasImplementation())
            tgt.setImplementation(convertConformanceImplementationComponent(src.getImplementation()));
        if (src.hasFhirVersionElement())
            tgt.setFhirVersionElement(VersionConvertor_10_30.convertId(src.getFhirVersionElement()));
        if (src.hasAcceptUnknown())
            tgt.setAcceptUnknown(convertUnknownContentCode(src.getAcceptUnknown()));
        for (org.hl7.fhir.dstu3.model.CodeType t : src.getFormat()) tgt.addFormat(t.getValue());
        for (org.hl7.fhir.dstu3.model.Reference t : src.getProfile()) tgt.addProfile(VersionConvertor_10_30.convertReference(t));
        for (org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestComponent t : src.getRest()) tgt.addRest(convertConformanceRestComponent(t));
        for (org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingComponent t : src.getMessaging()) tgt.addMessaging(convertConformanceMessagingComponent(t));
        for (org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementDocumentComponent t : src.getDocument()) tgt.addDocument(convertConformanceDocumentComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CapabilityStatement convertConformance(org.hl7.fhir.dstu2.model.Conformance src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.CapabilityStatement tgt = new org.hl7.fhir.dstu3.model.CapabilityStatement();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        if (src.hasUrlElement())
            tgt.setUrlElement(VersionConvertor_10_30.convertUri(src.getUrlElement()));
        if (src.hasVersionElement())
            tgt.setVersionElement(VersionConvertor_10_30.convertString(src.getVersionElement()));
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_10_30.convertString(src.getNameElement()));
        if (src.hasStatus())
            tgt.setStatus(VersionConvertor_10_30.convertConformanceResourceStatus(src.getStatus()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(VersionConvertor_10_30.convertBoolean(src.getExperimentalElement()));
        if (src.hasDate())
            tgt.setDateElement(VersionConvertor_10_30.convertDateTime(src.getDateElement()));
        if (src.hasPublisherElement())
            tgt.setPublisherElement(VersionConvertor_10_30.convertString(src.getPublisherElement()));
        for (org.hl7.fhir.dstu2.model.Conformance.ConformanceContactComponent t : src.getContact()) tgt.addContact(convertConformanceContactComponent(t));
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        if (src.hasRequirements())
            tgt.setPurpose(src.getRequirements());
        if (src.hasCopyright())
            tgt.setCopyright(src.getCopyright());
        if (src.hasKind())
            tgt.setKind(convertConformanceStatementKind(src.getKind()));
        if (src.hasSoftware())
            tgt.setSoftware(convertConformanceSoftwareComponent(src.getSoftware()));
        if (src.hasImplementation())
            tgt.setImplementation(convertConformanceImplementationComponent(src.getImplementation()));
        if (src.hasFhirVersionElement())
            tgt.setFhirVersionElement(VersionConvertor_10_30.convertId(src.getFhirVersionElement()));
        if (src.hasAcceptUnknown())
            tgt.setAcceptUnknown(convertUnknownContentCode(src.getAcceptUnknown()));
        for (org.hl7.fhir.dstu2.model.CodeType t : src.getFormat()) tgt.addFormat(t.getValue());
        for (org.hl7.fhir.dstu2.model.Reference t : src.getProfile()) tgt.addProfile(VersionConvertor_10_30.convertReference(t));
        for (org.hl7.fhir.dstu2.model.Conformance.ConformanceRestComponent t : src.getRest()) tgt.addRest(convertConformanceRestComponent(t));
        for (org.hl7.fhir.dstu2.model.Conformance.ConformanceMessagingComponent t : src.getMessaging()) tgt.addMessaging(convertConformanceMessagingComponent(t));
        for (org.hl7.fhir.dstu2.model.Conformance.ConformanceDocumentComponent t : src.getDocument()) tgt.addDocument(convertConformanceDocumentComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Conformance.ConformanceContactComponent convertConformanceContactComponent(org.hl7.fhir.dstu3.model.ContactDetail src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Conformance.ConformanceContactComponent tgt = new org.hl7.fhir.dstu2.model.Conformance.ConformanceContactComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_10_30.convertString(src.getNameElement()));
        for (org.hl7.fhir.dstu3.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_10_30.convertContactPoint(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ContactDetail convertConformanceContactComponent(org.hl7.fhir.dstu2.model.Conformance.ConformanceContactComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ContactDetail tgt = new org.hl7.fhir.dstu3.model.ContactDetail();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_10_30.convertString(src.getNameElement()));
        for (org.hl7.fhir.dstu2.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_10_30.convertContactPoint(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Conformance.ConformanceDocumentComponent convertConformanceDocumentComponent(org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementDocumentComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Conformance.ConformanceDocumentComponent tgt = new org.hl7.fhir.dstu2.model.Conformance.ConformanceDocumentComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasMode())
            tgt.setMode(convertDocumentMode(src.getMode()));
        if (src.hasDocumentationElement())
            tgt.setDocumentationElement(VersionConvertor_10_30.convertString(src.getDocumentationElement()));
        if (src.hasProfile())
            tgt.setProfile(VersionConvertor_10_30.convertReference(src.getProfile()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementDocumentComponent convertConformanceDocumentComponent(org.hl7.fhir.dstu2.model.Conformance.ConformanceDocumentComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementDocumentComponent tgt = new org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementDocumentComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasMode())
            tgt.setMode(convertDocumentMode(src.getMode()));
        if (src.hasDocumentationElement())
            tgt.setDocumentationElement(VersionConvertor_10_30.convertString(src.getDocumentationElement()));
        if (src.hasProfile())
            tgt.setProfile(VersionConvertor_10_30.convertReference(src.getProfile()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Conformance.ConformanceEventMode convertConformanceEventMode(org.hl7.fhir.dstu3.model.CapabilityStatement.EventCapabilityMode src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case SENDER:
                return org.hl7.fhir.dstu2.model.Conformance.ConformanceEventMode.SENDER;
            case RECEIVER:
                return org.hl7.fhir.dstu2.model.Conformance.ConformanceEventMode.RECEIVER;
            default:
                return org.hl7.fhir.dstu2.model.Conformance.ConformanceEventMode.NULL;
        }
    }

    public static org.hl7.fhir.dstu3.model.CapabilityStatement.EventCapabilityMode convertConformanceEventMode(org.hl7.fhir.dstu2.model.Conformance.ConformanceEventMode src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case SENDER:
                return org.hl7.fhir.dstu3.model.CapabilityStatement.EventCapabilityMode.SENDER;
            case RECEIVER:
                return org.hl7.fhir.dstu3.model.CapabilityStatement.EventCapabilityMode.RECEIVER;
            default:
                return org.hl7.fhir.dstu3.model.CapabilityStatement.EventCapabilityMode.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.Conformance.ConformanceImplementationComponent convertConformanceImplementationComponent(org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementImplementationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Conformance.ConformanceImplementationComponent tgt = new org.hl7.fhir.dstu2.model.Conformance.ConformanceImplementationComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement(VersionConvertor_10_30.convertString(src.getDescriptionElement()));
        if (src.hasUrlElement())
            tgt.setUrlElement(VersionConvertor_10_30.convertUri(src.getUrlElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementImplementationComponent convertConformanceImplementationComponent(org.hl7.fhir.dstu2.model.Conformance.ConformanceImplementationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementImplementationComponent tgt = new org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementImplementationComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement(VersionConvertor_10_30.convertString(src.getDescriptionElement()));
        if (src.hasUrlElement())
            tgt.setUrlElement(VersionConvertor_10_30.convertUri(src.getUrlElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingComponent convertConformanceMessagingComponent(org.hl7.fhir.dstu2.model.Conformance.ConformanceMessagingComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingComponent tgt = new org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        for (org.hl7.fhir.dstu2.model.Conformance.ConformanceMessagingEndpointComponent t : src.getEndpoint()) tgt.addEndpoint(convertConformanceMessagingEndpointComponent(t));
        if (src.hasReliableCacheElement())
            tgt.setReliableCacheElement(VersionConvertor_10_30.convertUnsignedInt(src.getReliableCacheElement()));
        if (src.hasDocumentationElement())
            tgt.setDocumentationElement(VersionConvertor_10_30.convertString(src.getDocumentationElement()));
        for (org.hl7.fhir.dstu2.model.Conformance.ConformanceMessagingEventComponent t : src.getEvent()) tgt.addEvent(convertConformanceMessagingEventComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Conformance.ConformanceMessagingComponent convertConformanceMessagingComponent(org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Conformance.ConformanceMessagingComponent tgt = new org.hl7.fhir.dstu2.model.Conformance.ConformanceMessagingComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        for (org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingEndpointComponent t : src.getEndpoint()) tgt.addEndpoint(convertConformanceMessagingEndpointComponent(t));
        if (src.hasReliableCacheElement())
            tgt.setReliableCacheElement(VersionConvertor_10_30.convertUnsignedInt(src.getReliableCacheElement()));
        if (src.hasDocumentationElement())
            tgt.setDocumentationElement(VersionConvertor_10_30.convertString(src.getDocumentationElement()));
        for (org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingEventComponent t : src.getEvent()) tgt.addEvent(convertConformanceMessagingEventComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingEndpointComponent convertConformanceMessagingEndpointComponent(org.hl7.fhir.dstu2.model.Conformance.ConformanceMessagingEndpointComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingEndpointComponent tgt = new org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingEndpointComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasProtocol())
            tgt.setProtocol(VersionConvertor_10_30.convertCoding(src.getProtocol()));
        if (src.hasAddressElement())
            tgt.setAddressElement(VersionConvertor_10_30.convertUri(src.getAddressElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Conformance.ConformanceMessagingEndpointComponent convertConformanceMessagingEndpointComponent(org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingEndpointComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Conformance.ConformanceMessagingEndpointComponent tgt = new org.hl7.fhir.dstu2.model.Conformance.ConformanceMessagingEndpointComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasProtocol())
            tgt.setProtocol(VersionConvertor_10_30.convertCoding(src.getProtocol()));
        if (src.hasAddressElement())
            tgt.setAddressElement(VersionConvertor_10_30.convertUri(src.getAddressElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingEventComponent convertConformanceMessagingEventComponent(org.hl7.fhir.dstu2.model.Conformance.ConformanceMessagingEventComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingEventComponent tgt = new org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingEventComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCode(VersionConvertor_10_30.convertCoding(src.getCode()));
        if (src.hasCategory())
            tgt.setCategory(convertMessageSignificanceCategory(src.getCategory()));
        if (src.hasMode())
            tgt.setMode(convertConformanceEventMode(src.getMode()));
        if (src.hasFocusElement())
            tgt.setFocusElement(VersionConvertor_10_30.convertCode(src.getFocusElement()));
        if (src.hasRequest())
            tgt.setRequest(VersionConvertor_10_30.convertReference(src.getRequest()));
        if (src.hasResponse())
            tgt.setResponse(VersionConvertor_10_30.convertReference(src.getResponse()));
        if (src.hasDocumentationElement())
            tgt.setDocumentationElement(VersionConvertor_10_30.convertString(src.getDocumentationElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Conformance.ConformanceMessagingEventComponent convertConformanceMessagingEventComponent(org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingEventComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Conformance.ConformanceMessagingEventComponent tgt = new org.hl7.fhir.dstu2.model.Conformance.ConformanceMessagingEventComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCode(VersionConvertor_10_30.convertCoding(src.getCode()));
        if (src.hasCategory())
            tgt.setCategory(convertMessageSignificanceCategory(src.getCategory()));
        if (src.hasMode())
            tgt.setMode(convertConformanceEventMode(src.getMode()));
        if (src.hasFocusElement())
            tgt.setFocusElement(VersionConvertor_10_30.convertCode(src.getFocusElement()));
        if (src.hasRequest())
            tgt.setRequest(VersionConvertor_10_30.convertReference(src.getRequest()));
        if (src.hasResponse())
            tgt.setResponse(VersionConvertor_10_30.convertReference(src.getResponse()));
        if (src.hasDocumentationElement())
            tgt.setDocumentationElement(VersionConvertor_10_30.convertString(src.getDocumentationElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestComponent convertConformanceRestComponent(org.hl7.fhir.dstu2.model.Conformance.ConformanceRestComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestComponent tgt = new org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasMode())
            tgt.setMode(convertRestfulConformanceMode(src.getMode()));
        if (src.hasDocumentationElement())
            tgt.setDocumentationElement(VersionConvertor_10_30.convertString(src.getDocumentationElement()));
        if (src.hasSecurity())
            tgt.setSecurity(convertConformanceRestSecurityComponent(src.getSecurity()));
        for (org.hl7.fhir.dstu2.model.Conformance.ConformanceRestResourceComponent t : src.getResource()) tgt.addResource(convertConformanceRestResourceComponent(t));
        for (org.hl7.fhir.dstu2.model.Conformance.SystemInteractionComponent t : src.getInteraction()) tgt.addInteraction(convertSystemInteractionComponent(t));
        if (src.getTransactionMode() == org.hl7.fhir.dstu2.model.Conformance.TransactionMode.BATCH || src.getTransactionMode() == org.hl7.fhir.dstu2.model.Conformance.TransactionMode.BOTH)
            tgt.addInteraction().setCode(SystemRestfulInteraction.BATCH);
        for (org.hl7.fhir.dstu2.model.Conformance.ConformanceRestResourceSearchParamComponent t : src.getSearchParam()) tgt.addSearchParam(convertConformanceRestResourceSearchParamComponent(t));
        for (org.hl7.fhir.dstu2.model.Conformance.ConformanceRestOperationComponent t : src.getOperation()) tgt.addOperation(convertConformanceRestOperationComponent(t));
        for (org.hl7.fhir.dstu2.model.UriType t : src.getCompartment()) tgt.addCompartment(t.getValue());
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Conformance.ConformanceRestComponent convertConformanceRestComponent(org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Conformance.ConformanceRestComponent tgt = new org.hl7.fhir.dstu2.model.Conformance.ConformanceRestComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasMode())
            tgt.setMode(convertRestfulConformanceMode(src.getMode()));
        if (src.hasDocumentationElement())
            tgt.setDocumentationElement(VersionConvertor_10_30.convertString(src.getDocumentationElement()));
        if (src.hasSecurity())
            tgt.setSecurity(convertConformanceRestSecurityComponent(src.getSecurity()));
        for (org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestResourceComponent t : src.getResource()) tgt.addResource(convertConformanceRestResourceComponent(t));
        boolean batch = false;
        boolean transaction = false;
        for (org.hl7.fhir.dstu3.model.CapabilityStatement.SystemInteractionComponent t : src.getInteraction()) {
            if (t.getCode().equals(SystemRestfulInteraction.BATCH))
                batch = true;
            else
                tgt.addInteraction(convertSystemInteractionComponent(t));
            if (t.getCode().equals(SystemRestfulInteraction.TRANSACTION))
                transaction = true;
        }
        if (batch)
            tgt.setTransactionMode(transaction ? org.hl7.fhir.dstu2.model.Conformance.TransactionMode.BOTH : org.hl7.fhir.dstu2.model.Conformance.TransactionMode.BATCH);
        else
            tgt.setTransactionMode(transaction ? org.hl7.fhir.dstu2.model.Conformance.TransactionMode.TRANSACTION : org.hl7.fhir.dstu2.model.Conformance.TransactionMode.NOTSUPPORTED);
        for (org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent t : src.getSearchParam()) tgt.addSearchParam(convertConformanceRestResourceSearchParamComponent(t));
        for (org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestOperationComponent t : src.getOperation()) tgt.addOperation(convertConformanceRestOperationComponent(t));
        for (org.hl7.fhir.dstu3.model.UriType t : src.getCompartment()) tgt.addCompartment(t.getValue());
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestOperationComponent convertConformanceRestOperationComponent(org.hl7.fhir.dstu2.model.Conformance.ConformanceRestOperationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestOperationComponent tgt = new org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestOperationComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_10_30.convertString(src.getNameElement()));
        if (src.hasDefinition())
            tgt.setDefinition(VersionConvertor_10_30.convertReference(src.getDefinition()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Conformance.ConformanceRestOperationComponent convertConformanceRestOperationComponent(org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestOperationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Conformance.ConformanceRestOperationComponent tgt = new org.hl7.fhir.dstu2.model.Conformance.ConformanceRestOperationComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_10_30.convertString(src.getNameElement()));
        if (src.hasDefinition())
            tgt.setDefinition(VersionConvertor_10_30.convertReference(src.getDefinition()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Conformance.ConformanceRestResourceComponent convertConformanceRestResourceComponent(org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestResourceComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Conformance.ConformanceRestResourceComponent tgt = new org.hl7.fhir.dstu2.model.Conformance.ConformanceRestResourceComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasTypeElement())
            tgt.setTypeElement(VersionConvertor_10_30.convertCode(src.getTypeElement()));
        if (src.hasProfile())
            tgt.setProfile(VersionConvertor_10_30.convertReference(src.getProfile()));
        for (org.hl7.fhir.dstu3.model.CapabilityStatement.ResourceInteractionComponent t : src.getInteraction()) tgt.addInteraction(convertResourceInteractionComponent(t));
        if (src.hasVersioning())
            tgt.setVersioning(convertResourceVersionPolicy(src.getVersioning()));
        if (src.hasReadHistoryElement())
            tgt.setReadHistoryElement(VersionConvertor_10_30.convertBoolean(src.getReadHistoryElement()));
        if (src.hasUpdateCreateElement())
            tgt.setUpdateCreateElement(VersionConvertor_10_30.convertBoolean(src.getUpdateCreateElement()));
        if (src.hasConditionalCreateElement())
            tgt.setConditionalCreateElement(VersionConvertor_10_30.convertBoolean(src.getConditionalCreateElement()));
        if (src.hasConditionalUpdateElement())
            tgt.setConditionalUpdateElement(VersionConvertor_10_30.convertBoolean(src.getConditionalUpdateElement()));
        if (src.hasConditionalDelete())
            tgt.setConditionalDelete(convertConditionalDeleteStatus(src.getConditionalDelete()));
        for (org.hl7.fhir.dstu3.model.StringType t : src.getSearchInclude()) tgt.addSearchInclude(t.getValue());
        for (org.hl7.fhir.dstu3.model.StringType t : src.getSearchRevInclude()) tgt.addSearchRevInclude(t.getValue());
        for (org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent t : src.getSearchParam()) tgt.addSearchParam(convertConformanceRestResourceSearchParamComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestResourceComponent convertConformanceRestResourceComponent(org.hl7.fhir.dstu2.model.Conformance.ConformanceRestResourceComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestResourceComponent tgt = new org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestResourceComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasTypeElement())
            tgt.setTypeElement(VersionConvertor_10_30.convertCode(src.getTypeElement()));
        if (src.hasProfile())
            tgt.setProfile(VersionConvertor_10_30.convertReference(src.getProfile()));
        for (org.hl7.fhir.dstu2.model.Conformance.ResourceInteractionComponent t : src.getInteraction()) tgt.addInteraction(convertResourceInteractionComponent(t));
        if (src.hasVersioning())
            tgt.setVersioning(convertResourceVersionPolicy(src.getVersioning()));
        if (src.hasReadHistoryElement())
            tgt.setReadHistoryElement(VersionConvertor_10_30.convertBoolean(src.getReadHistoryElement()));
        if (src.hasUpdateCreateElement())
            tgt.setUpdateCreateElement(VersionConvertor_10_30.convertBoolean(src.getUpdateCreateElement()));
        if (src.hasConditionalCreateElement())
            tgt.setConditionalCreateElement(VersionConvertor_10_30.convertBoolean(src.getConditionalCreateElement()));
        if (src.hasConditionalUpdateElement())
            tgt.setConditionalUpdateElement(VersionConvertor_10_30.convertBoolean(src.getConditionalUpdateElement()));
        if (src.hasConditionalDelete())
            tgt.setConditionalDelete(convertConditionalDeleteStatus(src.getConditionalDelete()));
        for (org.hl7.fhir.dstu2.model.StringType t : src.getSearchInclude()) tgt.addSearchInclude(t.getValue());
        for (org.hl7.fhir.dstu2.model.StringType t : src.getSearchRevInclude()) tgt.addSearchRevInclude(t.getValue());
        for (org.hl7.fhir.dstu2.model.Conformance.ConformanceRestResourceSearchParamComponent t : src.getSearchParam()) tgt.addSearchParam(convertConformanceRestResourceSearchParamComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Conformance.ConformanceRestResourceSearchParamComponent convertConformanceRestResourceSearchParamComponent(org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Conformance.ConformanceRestResourceSearchParamComponent tgt = new org.hl7.fhir.dstu2.model.Conformance.ConformanceRestResourceSearchParamComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_10_30.convertString(src.getNameElement()));
        if (src.hasDefinitionElement())
            tgt.setDefinitionElement(VersionConvertor_10_30.convertUri(src.getDefinitionElement()));
        if (src.hasType())
            tgt.setType(VersionConvertor_10_30.convertSearchParamType(src.getType()));
        if (src.hasDocumentationElement())
            tgt.setDocumentationElement(VersionConvertor_10_30.convertString(src.getDocumentationElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent convertConformanceRestResourceSearchParamComponent(org.hl7.fhir.dstu2.model.Conformance.ConformanceRestResourceSearchParamComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent tgt = new org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_10_30.convertString(src.getNameElement()));
        if (src.hasDefinitionElement())
            tgt.setDefinitionElement(VersionConvertor_10_30.convertUri(src.getDefinitionElement()));
        if (src.hasType())
            tgt.setType(VersionConvertor_10_30.convertSearchParamType(src.getType()));
        if (src.hasDocumentationElement())
            tgt.setDocumentationElement(VersionConvertor_10_30.convertString(src.getDocumentationElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Conformance.ConformanceRestSecurityCertificateComponent convertConformanceRestSecurityCertificateComponent(org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestSecurityCertificateComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Conformance.ConformanceRestSecurityCertificateComponent tgt = new org.hl7.fhir.dstu2.model.Conformance.ConformanceRestSecurityCertificateComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasTypeElement())
            tgt.setTypeElement(VersionConvertor_10_30.convertCode(src.getTypeElement()));
        if (src.hasBlobElement())
            tgt.setBlobElement(VersionConvertor_10_30.convertBase64Binary(src.getBlobElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestSecurityCertificateComponent convertConformanceRestSecurityCertificateComponent(org.hl7.fhir.dstu2.model.Conformance.ConformanceRestSecurityCertificateComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestSecurityCertificateComponent tgt = new org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestSecurityCertificateComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasTypeElement())
            tgt.setTypeElement(VersionConvertor_10_30.convertCode(src.getTypeElement()));
        if (src.hasBlobElement())
            tgt.setBlobElement(VersionConvertor_10_30.convertBase64Binary(src.getBlobElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestSecurityComponent convertConformanceRestSecurityComponent(org.hl7.fhir.dstu2.model.Conformance.ConformanceRestSecurityComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestSecurityComponent tgt = new org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestSecurityComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasCorsElement())
            tgt.setCorsElement(VersionConvertor_10_30.convertBoolean(src.getCorsElement()));
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getService()) tgt.addService(VersionConvertor_10_30.convertCodeableConcept(t));
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement(VersionConvertor_10_30.convertString(src.getDescriptionElement()));
        for (org.hl7.fhir.dstu2.model.Conformance.ConformanceRestSecurityCertificateComponent t : src.getCertificate()) tgt.addCertificate(convertConformanceRestSecurityCertificateComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Conformance.ConformanceRestSecurityComponent convertConformanceRestSecurityComponent(org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestSecurityComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Conformance.ConformanceRestSecurityComponent tgt = new org.hl7.fhir.dstu2.model.Conformance.ConformanceRestSecurityComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasCorsElement())
            tgt.setCorsElement(VersionConvertor_10_30.convertBoolean(src.getCorsElement()));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getService()) tgt.addService(VersionConvertor_10_30.convertCodeableConcept(t));
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement(VersionConvertor_10_30.convertString(src.getDescriptionElement()));
        for (org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestSecurityCertificateComponent t : src.getCertificate()) tgt.addCertificate(convertConformanceRestSecurityCertificateComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementSoftwareComponent convertConformanceSoftwareComponent(org.hl7.fhir.dstu2.model.Conformance.ConformanceSoftwareComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementSoftwareComponent tgt = new org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementSoftwareComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_10_30.convertString(src.getNameElement()));
        if (src.hasVersionElement())
            tgt.setVersionElement(VersionConvertor_10_30.convertString(src.getVersionElement()));
        if (src.hasReleaseDateElement())
            tgt.setReleaseDateElement(VersionConvertor_10_30.convertDateTime(src.getReleaseDateElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Conformance.ConformanceSoftwareComponent convertConformanceSoftwareComponent(org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementSoftwareComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Conformance.ConformanceSoftwareComponent tgt = new org.hl7.fhir.dstu2.model.Conformance.ConformanceSoftwareComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_10_30.convertString(src.getNameElement()));
        if (src.hasVersionElement())
            tgt.setVersionElement(VersionConvertor_10_30.convertString(src.getVersionElement()));
        if (src.hasReleaseDateElement())
            tgt.setReleaseDateElement(VersionConvertor_10_30.convertDateTime(src.getReleaseDateElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementKind convertConformanceStatementKind(org.hl7.fhir.dstu2.model.Conformance.ConformanceStatementKind src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case INSTANCE:
                return org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementKind.INSTANCE;
            case CAPABILITY:
                return org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementKind.CAPABILITY;
            case REQUIREMENTS:
                return org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementKind.REQUIREMENTS;
            default:
                return org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementKind.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.Conformance.ConformanceStatementKind convertConformanceStatementKind(org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementKind src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case INSTANCE:
                return org.hl7.fhir.dstu2.model.Conformance.ConformanceStatementKind.INSTANCE;
            case CAPABILITY:
                return org.hl7.fhir.dstu2.model.Conformance.ConformanceStatementKind.CAPABILITY;
            case REQUIREMENTS:
                return org.hl7.fhir.dstu2.model.Conformance.ConformanceStatementKind.REQUIREMENTS;
            default:
                return org.hl7.fhir.dstu2.model.Conformance.ConformanceStatementKind.NULL;
        }
    }

    public static org.hl7.fhir.dstu3.model.CapabilityStatement.DocumentMode convertDocumentMode(org.hl7.fhir.dstu2.model.Conformance.DocumentMode src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case PRODUCER:
                return org.hl7.fhir.dstu3.model.CapabilityStatement.DocumentMode.PRODUCER;
            case CONSUMER:
                return org.hl7.fhir.dstu3.model.CapabilityStatement.DocumentMode.CONSUMER;
            default:
                return org.hl7.fhir.dstu3.model.CapabilityStatement.DocumentMode.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.Conformance.DocumentMode convertDocumentMode(org.hl7.fhir.dstu3.model.CapabilityStatement.DocumentMode src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case PRODUCER:
                return org.hl7.fhir.dstu2.model.Conformance.DocumentMode.PRODUCER;
            case CONSUMER:
                return org.hl7.fhir.dstu2.model.Conformance.DocumentMode.CONSUMER;
            default:
                return org.hl7.fhir.dstu2.model.Conformance.DocumentMode.NULL;
        }
    }

    public static org.hl7.fhir.dstu3.model.CapabilityStatement.MessageSignificanceCategory convertMessageSignificanceCategory(org.hl7.fhir.dstu2.model.Conformance.MessageSignificanceCategory src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case CONSEQUENCE:
                return org.hl7.fhir.dstu3.model.CapabilityStatement.MessageSignificanceCategory.CONSEQUENCE;
            case CURRENCY:
                return org.hl7.fhir.dstu3.model.CapabilityStatement.MessageSignificanceCategory.CURRENCY;
            case NOTIFICATION:
                return org.hl7.fhir.dstu3.model.CapabilityStatement.MessageSignificanceCategory.NOTIFICATION;
            default:
                return org.hl7.fhir.dstu3.model.CapabilityStatement.MessageSignificanceCategory.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.Conformance.MessageSignificanceCategory convertMessageSignificanceCategory(org.hl7.fhir.dstu3.model.CapabilityStatement.MessageSignificanceCategory src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case CONSEQUENCE:
                return org.hl7.fhir.dstu2.model.Conformance.MessageSignificanceCategory.CONSEQUENCE;
            case CURRENCY:
                return org.hl7.fhir.dstu2.model.Conformance.MessageSignificanceCategory.CURRENCY;
            case NOTIFICATION:
                return org.hl7.fhir.dstu2.model.Conformance.MessageSignificanceCategory.NOTIFICATION;
            default:
                return org.hl7.fhir.dstu2.model.Conformance.MessageSignificanceCategory.NULL;
        }
    }

    public static org.hl7.fhir.dstu3.model.CapabilityStatement.ResourceInteractionComponent convertResourceInteractionComponent(org.hl7.fhir.dstu2.model.Conformance.ResourceInteractionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.CapabilityStatement.ResourceInteractionComponent tgt = new org.hl7.fhir.dstu3.model.CapabilityStatement.ResourceInteractionComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCode(convertTypeRestfulInteraction(src.getCode()));
        if (src.hasDocumentationElement())
            tgt.setDocumentationElement(VersionConvertor_10_30.convertString(src.getDocumentationElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Conformance.ResourceInteractionComponent convertResourceInteractionComponent(org.hl7.fhir.dstu3.model.CapabilityStatement.ResourceInteractionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Conformance.ResourceInteractionComponent tgt = new org.hl7.fhir.dstu2.model.Conformance.ResourceInteractionComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCode(convertTypeRestfulInteraction(src.getCode()));
        if (src.hasDocumentationElement())
            tgt.setDocumentationElement(VersionConvertor_10_30.convertString(src.getDocumentationElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Conformance.ResourceVersionPolicy convertResourceVersionPolicy(org.hl7.fhir.dstu3.model.CapabilityStatement.ResourceVersionPolicy src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case NOVERSION:
                return org.hl7.fhir.dstu2.model.Conformance.ResourceVersionPolicy.NOVERSION;
            case VERSIONED:
                return org.hl7.fhir.dstu2.model.Conformance.ResourceVersionPolicy.VERSIONED;
            case VERSIONEDUPDATE:
                return org.hl7.fhir.dstu2.model.Conformance.ResourceVersionPolicy.VERSIONEDUPDATE;
            default:
                return org.hl7.fhir.dstu2.model.Conformance.ResourceVersionPolicy.NULL;
        }
    }

    public static org.hl7.fhir.dstu3.model.CapabilityStatement.ResourceVersionPolicy convertResourceVersionPolicy(org.hl7.fhir.dstu2.model.Conformance.ResourceVersionPolicy src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case NOVERSION:
                return org.hl7.fhir.dstu3.model.CapabilityStatement.ResourceVersionPolicy.NOVERSION;
            case VERSIONED:
                return org.hl7.fhir.dstu3.model.CapabilityStatement.ResourceVersionPolicy.VERSIONED;
            case VERSIONEDUPDATE:
                return org.hl7.fhir.dstu3.model.CapabilityStatement.ResourceVersionPolicy.VERSIONEDUPDATE;
            default:
                return org.hl7.fhir.dstu3.model.CapabilityStatement.ResourceVersionPolicy.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.Conformance.RestfulConformanceMode convertRestfulConformanceMode(org.hl7.fhir.dstu3.model.CapabilityStatement.RestfulCapabilityMode src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case CLIENT:
                return org.hl7.fhir.dstu2.model.Conformance.RestfulConformanceMode.CLIENT;
            case SERVER:
                return org.hl7.fhir.dstu2.model.Conformance.RestfulConformanceMode.SERVER;
            default:
                return org.hl7.fhir.dstu2.model.Conformance.RestfulConformanceMode.NULL;
        }
    }

    public static org.hl7.fhir.dstu3.model.CapabilityStatement.RestfulCapabilityMode convertRestfulConformanceMode(org.hl7.fhir.dstu2.model.Conformance.RestfulConformanceMode src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case CLIENT:
                return org.hl7.fhir.dstu3.model.CapabilityStatement.RestfulCapabilityMode.CLIENT;
            case SERVER:
                return org.hl7.fhir.dstu3.model.CapabilityStatement.RestfulCapabilityMode.SERVER;
            default:
                return org.hl7.fhir.dstu3.model.CapabilityStatement.RestfulCapabilityMode.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.Conformance.SystemInteractionComponent convertSystemInteractionComponent(org.hl7.fhir.dstu3.model.CapabilityStatement.SystemInteractionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Conformance.SystemInteractionComponent tgt = new org.hl7.fhir.dstu2.model.Conformance.SystemInteractionComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCode(convertSystemRestfulInteraction(src.getCode()));
        if (src.hasDocumentationElement())
            tgt.setDocumentationElement(VersionConvertor_10_30.convertString(src.getDocumentationElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CapabilityStatement.SystemInteractionComponent convertSystemInteractionComponent(org.hl7.fhir.dstu2.model.Conformance.SystemInteractionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.CapabilityStatement.SystemInteractionComponent tgt = new org.hl7.fhir.dstu3.model.CapabilityStatement.SystemInteractionComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCode(convertSystemRestfulInteraction(src.getCode()));
        if (src.hasDocumentationElement())
            tgt.setDocumentationElement(VersionConvertor_10_30.convertString(src.getDocumentationElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CapabilityStatement.SystemRestfulInteraction convertSystemRestfulInteraction(org.hl7.fhir.dstu2.model.Conformance.SystemRestfulInteraction src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case TRANSACTION:
                return org.hl7.fhir.dstu3.model.CapabilityStatement.SystemRestfulInteraction.TRANSACTION;
            case SEARCHSYSTEM:
                return org.hl7.fhir.dstu3.model.CapabilityStatement.SystemRestfulInteraction.SEARCHSYSTEM;
            case HISTORYSYSTEM:
                return org.hl7.fhir.dstu3.model.CapabilityStatement.SystemRestfulInteraction.HISTORYSYSTEM;
            default:
                return org.hl7.fhir.dstu3.model.CapabilityStatement.SystemRestfulInteraction.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.Conformance.SystemRestfulInteraction convertSystemRestfulInteraction(org.hl7.fhir.dstu3.model.CapabilityStatement.SystemRestfulInteraction src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case TRANSACTION:
                return org.hl7.fhir.dstu2.model.Conformance.SystemRestfulInteraction.TRANSACTION;
            case SEARCHSYSTEM:
                return org.hl7.fhir.dstu2.model.Conformance.SystemRestfulInteraction.SEARCHSYSTEM;
            case HISTORYSYSTEM:
                return org.hl7.fhir.dstu2.model.Conformance.SystemRestfulInteraction.HISTORYSYSTEM;
            default:
                return org.hl7.fhir.dstu2.model.Conformance.SystemRestfulInteraction.NULL;
        }
    }

    public static org.hl7.fhir.dstu3.model.CapabilityStatement.TypeRestfulInteraction convertTypeRestfulInteraction(org.hl7.fhir.dstu2.model.Conformance.TypeRestfulInteraction src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case READ:
                return org.hl7.fhir.dstu3.model.CapabilityStatement.TypeRestfulInteraction.READ;
            case VREAD:
                return org.hl7.fhir.dstu3.model.CapabilityStatement.TypeRestfulInteraction.VREAD;
            case UPDATE:
                return org.hl7.fhir.dstu3.model.CapabilityStatement.TypeRestfulInteraction.UPDATE;
            case DELETE:
                return org.hl7.fhir.dstu3.model.CapabilityStatement.TypeRestfulInteraction.DELETE;
            case HISTORYINSTANCE:
                return org.hl7.fhir.dstu3.model.CapabilityStatement.TypeRestfulInteraction.HISTORYINSTANCE;
            case HISTORYTYPE:
                return org.hl7.fhir.dstu3.model.CapabilityStatement.TypeRestfulInteraction.HISTORYTYPE;
            case CREATE:
                return org.hl7.fhir.dstu3.model.CapabilityStatement.TypeRestfulInteraction.CREATE;
            case SEARCHTYPE:
                return org.hl7.fhir.dstu3.model.CapabilityStatement.TypeRestfulInteraction.SEARCHTYPE;
            default:
                return org.hl7.fhir.dstu3.model.CapabilityStatement.TypeRestfulInteraction.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.Conformance.TypeRestfulInteraction convertTypeRestfulInteraction(org.hl7.fhir.dstu3.model.CapabilityStatement.TypeRestfulInteraction src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case READ:
                return org.hl7.fhir.dstu2.model.Conformance.TypeRestfulInteraction.READ;
            case VREAD:
                return org.hl7.fhir.dstu2.model.Conformance.TypeRestfulInteraction.VREAD;
            case UPDATE:
                return org.hl7.fhir.dstu2.model.Conformance.TypeRestfulInteraction.UPDATE;
            case DELETE:
                return org.hl7.fhir.dstu2.model.Conformance.TypeRestfulInteraction.DELETE;
            case HISTORYINSTANCE:
                return org.hl7.fhir.dstu2.model.Conformance.TypeRestfulInteraction.HISTORYINSTANCE;
            case HISTORYTYPE:
                return org.hl7.fhir.dstu2.model.Conformance.TypeRestfulInteraction.HISTORYTYPE;
            case CREATE:
                return org.hl7.fhir.dstu2.model.Conformance.TypeRestfulInteraction.CREATE;
            case SEARCHTYPE:
                return org.hl7.fhir.dstu2.model.Conformance.TypeRestfulInteraction.SEARCHTYPE;
            default:
                return org.hl7.fhir.dstu2.model.Conformance.TypeRestfulInteraction.NULL;
        }
    }

    public static org.hl7.fhir.dstu3.model.CapabilityStatement.UnknownContentCode convertUnknownContentCode(org.hl7.fhir.dstu2.model.Conformance.UnknownContentCode src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case NO:
                return org.hl7.fhir.dstu3.model.CapabilityStatement.UnknownContentCode.NO;
            case EXTENSIONS:
                return org.hl7.fhir.dstu3.model.CapabilityStatement.UnknownContentCode.EXTENSIONS;
            case ELEMENTS:
                return org.hl7.fhir.dstu3.model.CapabilityStatement.UnknownContentCode.ELEMENTS;
            case BOTH:
                return org.hl7.fhir.dstu3.model.CapabilityStatement.UnknownContentCode.BOTH;
            default:
                return org.hl7.fhir.dstu3.model.CapabilityStatement.UnknownContentCode.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.Conformance.UnknownContentCode convertUnknownContentCode(org.hl7.fhir.dstu3.model.CapabilityStatement.UnknownContentCode src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case NO:
                return org.hl7.fhir.dstu2.model.Conformance.UnknownContentCode.NO;
            case EXTENSIONS:
                return org.hl7.fhir.dstu2.model.Conformance.UnknownContentCode.EXTENSIONS;
            case ELEMENTS:
                return org.hl7.fhir.dstu2.model.Conformance.UnknownContentCode.ELEMENTS;
            case BOTH:
                return org.hl7.fhir.dstu2.model.Conformance.UnknownContentCode.BOTH;
            default:
                return org.hl7.fhir.dstu2.model.Conformance.UnknownContentCode.NULL;
        }
    }
}
