package org.hl7.fhir.convertors.conv14_30;

import org.hl7.fhir.convertors.VersionConvertor_14_30;
import org.hl7.fhir.exceptions.FHIRException;

public class Conformance14_30 {

    static public org.hl7.fhir.dstu3.model.CapabilityStatement.ConditionalDeleteStatus convertConditionalDeleteStatus(org.hl7.fhir.dstu2016may.model.Conformance.ConditionalDeleteStatus src) throws FHIRException {
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

    static public org.hl7.fhir.dstu2016may.model.Conformance.ConditionalDeleteStatus convertConditionalDeleteStatus(org.hl7.fhir.dstu3.model.CapabilityStatement.ConditionalDeleteStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case NOTSUPPORTED:
                return org.hl7.fhir.dstu2016may.model.Conformance.ConditionalDeleteStatus.NOTSUPPORTED;
            case SINGLE:
                return org.hl7.fhir.dstu2016may.model.Conformance.ConditionalDeleteStatus.SINGLE;
            case MULTIPLE:
                return org.hl7.fhir.dstu2016may.model.Conformance.ConditionalDeleteStatus.MULTIPLE;
            default:
                return org.hl7.fhir.dstu2016may.model.Conformance.ConditionalDeleteStatus.NULL;
        }
    }

    public static org.hl7.fhir.dstu2016may.model.Conformance convertConformance(org.hl7.fhir.dstu3.model.CapabilityStatement src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Conformance tgt = new org.hl7.fhir.dstu2016may.model.Conformance();
        VersionConvertor_14_30.copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrl(src.getUrl());
        if (src.hasVersion())
            tgt.setVersion(src.getVersion());
        if (src.hasName())
            tgt.setName(src.getName());
        if (src.hasStatus()) {
            tgt.setStatus(VersionConvertor_14_30.convertConformanceResourceStatus(src.getStatus()));
        }
        if (src.hasExperimental())
            tgt.setExperimental(src.getExperimental());
        if (src.hasDate())
            tgt.setDate(src.getDate());
        if (src.hasPublisher())
            tgt.setPublisher(src.getPublisher());
        if (src.hasContact()) {
            for (org.hl7.fhir.dstu3.model.ContactDetail t : src.getContact()) tgt.addContact(convertConformanceContactComponent(t));
        }
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.dstu3.model.UsageContext t : src.getUseContext()) if (t.hasValueCodeableConcept())
            tgt.addUseContext(VersionConvertor_14_30.convertCodeableConcept(t.getValueCodeableConcept()));
        if (src.hasJurisdiction()) {
            for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getJurisdiction()) tgt.addUseContext(VersionConvertor_14_30.convertCodeableConcept(t));
        }
        if (src.hasPurpose())
            tgt.setRequirements(src.getPurpose());
        if (src.hasCopyright())
            tgt.setCopyright(src.getCopyright());
        if (src.hasKind()) {
            tgt.setKind(convertConformanceStatementKind(src.getKind()));
        }
        if (src.hasSoftware()) {
            tgt.setSoftware(convertConformanceSoftwareComponent(src.getSoftware()));
        }
        if (src.hasImplementation()) {
            tgt.setImplementation(convertConformanceImplementationComponent(src.getImplementation()));
        }
        if (src.hasFhirVersion()) {
            tgt.setFhirVersion(src.getFhirVersion());
        }
        if (src.hasAcceptUnknown()) {
            tgt.setAcceptUnknown(convertUnknownContentCode(src.getAcceptUnknown()));
        }
        if (src.hasFormat()) {
            for (org.hl7.fhir.dstu3.model.CodeType t : src.getFormat()) tgt.addFormat(t.getValue());
        }
        if (src.hasProfile()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getProfile()) tgt.addProfile(VersionConvertor_14_30.convertReference(t));
        }
        if (src.hasRest()) {
            for (org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestComponent t : src.getRest()) tgt.addRest(convertConformanceRestComponent(t));
        }
        if (src.hasMessaging()) {
            for (org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingComponent t : src.getMessaging()) tgt.addMessaging(convertConformanceMessagingComponent(t));
        }
        if (src.hasDocument()) {
            for (org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementDocumentComponent t : src.getDocument()) tgt.addDocument(convertConformanceDocumentComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CapabilityStatement convertConformance(org.hl7.fhir.dstu2016may.model.Conformance src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.CapabilityStatement tgt = new org.hl7.fhir.dstu3.model.CapabilityStatement();
        VersionConvertor_14_30.copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrl(src.getUrl());
        if (src.hasVersion())
            tgt.setVersion(src.getVersion());
        if (src.hasName())
            tgt.setName(src.getName());
        if (src.hasStatus()) {
            tgt.setStatus(VersionConvertor_14_30.convertConformanceResourceStatus(src.getStatus()));
        }
        if (src.hasExperimental())
            tgt.setExperimental(src.getExperimental());
        if (src.hasDate())
            tgt.setDate(src.getDate());
        if (src.hasPublisher())
            tgt.setPublisher(src.getPublisher());
        if (src.hasContact()) {
            for (org.hl7.fhir.dstu2016may.model.Conformance.ConformanceContactComponent t : src.getContact()) tgt.addContact(convertConformanceContactComponent(t));
        }
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
        if (src.hasKind()) {
            tgt.setKind(convertConformanceStatementKind(src.getKind()));
        }
        if (src.hasSoftware()) {
            tgt.setSoftware(convertConformanceSoftwareComponent(src.getSoftware()));
        }
        if (src.hasImplementation()) {
            tgt.setImplementation(convertConformanceImplementationComponent(src.getImplementation()));
        }
        if (src.hasFhirVersion()) {
            tgt.setFhirVersion(src.getFhirVersion());
        }
        if (src.hasAcceptUnknown()) {
            tgt.setAcceptUnknown(convertUnknownContentCode(src.getAcceptUnknown()));
        }
        if (src.hasFormat()) {
            for (org.hl7.fhir.dstu2016may.model.CodeType t : src.getFormat()) tgt.addFormat(t.getValue());
        }
        if (src.hasProfile()) {
            for (org.hl7.fhir.dstu2016may.model.Reference t : src.getProfile()) tgt.addProfile(VersionConvertor_14_30.convertReference(t));
        }
        if (src.hasRest()) {
            for (org.hl7.fhir.dstu2016may.model.Conformance.ConformanceRestComponent t : src.getRest()) tgt.addRest(convertConformanceRestComponent(t));
        }
        if (src.hasMessaging()) {
            for (org.hl7.fhir.dstu2016may.model.Conformance.ConformanceMessagingComponent t : src.getMessaging()) tgt.addMessaging(convertConformanceMessagingComponent(t));
        }
        if (src.hasDocument()) {
            for (org.hl7.fhir.dstu2016may.model.Conformance.ConformanceDocumentComponent t : src.getDocument()) tgt.addDocument(convertConformanceDocumentComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ContactDetail convertConformanceContactComponent(org.hl7.fhir.dstu2016may.model.Conformance.ConformanceContactComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ContactDetail tgt = new org.hl7.fhir.dstu3.model.ContactDetail();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasName())
            tgt.setName(src.getName());
        if (src.hasTelecom()) {
            for (org.hl7.fhir.dstu2016may.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_14_30.convertContactPoint(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Conformance.ConformanceContactComponent convertConformanceContactComponent(org.hl7.fhir.dstu3.model.ContactDetail src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Conformance.ConformanceContactComponent tgt = new org.hl7.fhir.dstu2016may.model.Conformance.ConformanceContactComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasName())
            tgt.setName(src.getName());
        if (src.hasTelecom()) {
            for (org.hl7.fhir.dstu3.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_14_30.convertContactPoint(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Conformance.ConformanceDocumentComponent convertConformanceDocumentComponent(org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementDocumentComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Conformance.ConformanceDocumentComponent tgt = new org.hl7.fhir.dstu2016may.model.Conformance.ConformanceDocumentComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasMode()) {
            tgt.setMode(convertDocumentMode(src.getMode()));
        }
        if (src.hasDocumentation())
            tgt.setDocumentation(src.getDocumentation());
        if (src.hasProfile()) {
            tgt.setProfile(VersionConvertor_14_30.convertReference(src.getProfile()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementDocumentComponent convertConformanceDocumentComponent(org.hl7.fhir.dstu2016may.model.Conformance.ConformanceDocumentComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementDocumentComponent tgt = new org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementDocumentComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasMode()) {
            tgt.setMode(convertDocumentMode(src.getMode()));
        }
        if (src.hasDocumentation())
            tgt.setDocumentation(src.getDocumentation());
        if (src.hasProfile()) {
            tgt.setProfile(VersionConvertor_14_30.convertReference(src.getProfile()));
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.CapabilityStatement.EventCapabilityMode convertConformanceEventMode(org.hl7.fhir.dstu2016may.model.Conformance.ConformanceEventMode src) throws FHIRException {
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

    static public org.hl7.fhir.dstu2016may.model.Conformance.ConformanceEventMode convertConformanceEventMode(org.hl7.fhir.dstu3.model.CapabilityStatement.EventCapabilityMode src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case SENDER:
                return org.hl7.fhir.dstu2016may.model.Conformance.ConformanceEventMode.SENDER;
            case RECEIVER:
                return org.hl7.fhir.dstu2016may.model.Conformance.ConformanceEventMode.RECEIVER;
            default:
                return org.hl7.fhir.dstu2016may.model.Conformance.ConformanceEventMode.NULL;
        }
    }

    public static org.hl7.fhir.dstu2016may.model.Conformance.ConformanceImplementationComponent convertConformanceImplementationComponent(org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementImplementationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Conformance.ConformanceImplementationComponent tgt = new org.hl7.fhir.dstu2016may.model.Conformance.ConformanceImplementationComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasDescription()) {
            tgt.setDescription(src.getDescription());
        }
        if (src.hasUrl())
            tgt.setUrl(src.getUrl());
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementImplementationComponent convertConformanceImplementationComponent(org.hl7.fhir.dstu2016may.model.Conformance.ConformanceImplementationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementImplementationComponent tgt = new org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementImplementationComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasDescription()) {
            tgt.setDescription(src.getDescription());
        }
        if (src.hasUrl())
            tgt.setUrl(src.getUrl());
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Conformance.ConformanceMessagingComponent convertConformanceMessagingComponent(org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Conformance.ConformanceMessagingComponent tgt = new org.hl7.fhir.dstu2016may.model.Conformance.ConformanceMessagingComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasEndpoint()) {
            for (org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingEndpointComponent t : src.getEndpoint()) tgt.addEndpoint(convertConformanceMessagingEndpointComponent(t));
        }
        if (src.hasReliableCache())
            tgt.setReliableCache(src.getReliableCache());
        if (src.hasDocumentation())
            tgt.setDocumentation(src.getDocumentation());
        if (src.hasEvent()) {
            for (org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingEventComponent t : src.getEvent()) tgt.addEvent(convertConformanceMessagingEventComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingComponent convertConformanceMessagingComponent(org.hl7.fhir.dstu2016may.model.Conformance.ConformanceMessagingComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingComponent tgt = new org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasEndpoint()) {
            for (org.hl7.fhir.dstu2016may.model.Conformance.ConformanceMessagingEndpointComponent t : src.getEndpoint()) tgt.addEndpoint(convertConformanceMessagingEndpointComponent(t));
        }
        if (src.hasReliableCache())
            tgt.setReliableCache(src.getReliableCache());
        if (src.hasDocumentation())
            tgt.setDocumentation(src.getDocumentation());
        if (src.hasEvent()) {
            for (org.hl7.fhir.dstu2016may.model.Conformance.ConformanceMessagingEventComponent t : src.getEvent()) tgt.addEvent(convertConformanceMessagingEventComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingEndpointComponent convertConformanceMessagingEndpointComponent(org.hl7.fhir.dstu2016may.model.Conformance.ConformanceMessagingEndpointComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingEndpointComponent tgt = new org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingEndpointComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasProtocol()) {
            tgt.setProtocol(VersionConvertor_14_30.convertCoding(src.getProtocol()));
        }
        if (src.hasAddress()) {
            tgt.setAddress(src.getAddress());
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Conformance.ConformanceMessagingEndpointComponent convertConformanceMessagingEndpointComponent(org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingEndpointComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Conformance.ConformanceMessagingEndpointComponent tgt = new org.hl7.fhir.dstu2016may.model.Conformance.ConformanceMessagingEndpointComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasProtocol()) {
            tgt.setProtocol(VersionConvertor_14_30.convertCoding(src.getProtocol()));
        }
        if (src.hasAddress()) {
            tgt.setAddress(src.getAddress());
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingEventComponent convertConformanceMessagingEventComponent(org.hl7.fhir.dstu2016may.model.Conformance.ConformanceMessagingEventComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingEventComponent tgt = new org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingEventComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasCode()) {
            tgt.setCode(VersionConvertor_14_30.convertCoding(src.getCode()));
        }
        if (src.hasCategory()) {
            tgt.setCategory(convertMessageSignificanceCategory(src.getCategory()));
        }
        if (src.hasMode()) {
            tgt.setMode(convertConformanceEventMode(src.getMode()));
        }
        if (src.hasFocus()) {
            tgt.setFocus(src.getFocus());
        }
        if (src.hasRequest()) {
            tgt.setRequest(VersionConvertor_14_30.convertReference(src.getRequest()));
        }
        if (src.hasResponse()) {
            tgt.setResponse(VersionConvertor_14_30.convertReference(src.getResponse()));
        }
        if (src.hasDocumentation())
            tgt.setDocumentation(src.getDocumentation());
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Conformance.ConformanceMessagingEventComponent convertConformanceMessagingEventComponent(org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementMessagingEventComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Conformance.ConformanceMessagingEventComponent tgt = new org.hl7.fhir.dstu2016may.model.Conformance.ConformanceMessagingEventComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasCode()) {
            tgt.setCode(VersionConvertor_14_30.convertCoding(src.getCode()));
        }
        if (src.hasCategory()) {
            tgt.setCategory(convertMessageSignificanceCategory(src.getCategory()));
        }
        if (src.hasMode()) {
            tgt.setMode(convertConformanceEventMode(src.getMode()));
        }
        if (src.hasFocus()) {
            tgt.setFocus(src.getFocus());
        }
        if (src.hasRequest()) {
            tgt.setRequest(VersionConvertor_14_30.convertReference(src.getRequest()));
        }
        if (src.hasResponse()) {
            tgt.setResponse(VersionConvertor_14_30.convertReference(src.getResponse()));
        }
        if (src.hasDocumentation())
            tgt.setDocumentation(src.getDocumentation());
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestComponent convertConformanceRestComponent(org.hl7.fhir.dstu2016may.model.Conformance.ConformanceRestComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestComponent tgt = new org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasMode()) {
            tgt.setMode(convertRestfulConformanceMode(src.getMode()));
        }
        if (src.hasDocumentation())
            tgt.setDocumentation(src.getDocumentation());
        if (src.hasSecurity()) {
            tgt.setSecurity(convertConformanceRestSecurityComponent(src.getSecurity()));
        }
        if (src.hasResource()) {
            for (org.hl7.fhir.dstu2016may.model.Conformance.ConformanceRestResourceComponent t : src.getResource()) tgt.addResource(convertConformanceRestResourceComponent(t));
        }
        if (src.hasInteraction()) {
            for (org.hl7.fhir.dstu2016may.model.Conformance.SystemInteractionComponent t : src.getInteraction()) tgt.addInteraction(convertSystemInteractionComponent(t));
        }
        if (src.hasSearchParam()) {
            for (org.hl7.fhir.dstu2016may.model.Conformance.ConformanceRestResourceSearchParamComponent t : src.getSearchParam()) tgt.addSearchParam(convertConformanceRestResourceSearchParamComponent(t));
        }
        if (src.hasOperation()) {
            for (org.hl7.fhir.dstu2016may.model.Conformance.ConformanceRestOperationComponent t : src.getOperation()) tgt.addOperation(convertConformanceRestOperationComponent(t));
        }
        if (src.hasCompartment()) {
            for (org.hl7.fhir.dstu2016may.model.UriType t : src.getCompartment()) tgt.addCompartment(t.getValue());
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Conformance.ConformanceRestComponent convertConformanceRestComponent(org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Conformance.ConformanceRestComponent tgt = new org.hl7.fhir.dstu2016may.model.Conformance.ConformanceRestComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasMode()) {
            tgt.setMode(convertRestfulConformanceMode(src.getMode()));
        }
        if (src.hasDocumentation())
            tgt.setDocumentation(src.getDocumentation());
        if (src.hasSecurity()) {
            tgt.setSecurity(convertConformanceRestSecurityComponent(src.getSecurity()));
        }
        if (src.hasResource()) {
            for (org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestResourceComponent t : src.getResource()) tgt.addResource(convertConformanceRestResourceComponent(t));
        }
        if (src.hasInteraction()) {
            for (org.hl7.fhir.dstu3.model.CapabilityStatement.SystemInteractionComponent t : src.getInteraction()) tgt.addInteraction(convertSystemInteractionComponent(t));
        }
        if (src.hasSearchParam()) {
            for (org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent t : src.getSearchParam()) tgt.addSearchParam(convertConformanceRestResourceSearchParamComponent(t));
        }
        if (src.hasOperation()) {
            for (org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestOperationComponent t : src.getOperation()) tgt.addOperation(convertConformanceRestOperationComponent(t));
        }
        if (src.hasCompartment()) {
            for (org.hl7.fhir.dstu3.model.UriType t : src.getCompartment()) tgt.addCompartment(t.getValue());
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Conformance.ConformanceRestOperationComponent convertConformanceRestOperationComponent(org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestOperationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Conformance.ConformanceRestOperationComponent tgt = new org.hl7.fhir.dstu2016may.model.Conformance.ConformanceRestOperationComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasName()) {
            tgt.setName(src.getName());
        }
        if (src.hasDefinition()) {
            tgt.setDefinition(VersionConvertor_14_30.convertReference(src.getDefinition()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestOperationComponent convertConformanceRestOperationComponent(org.hl7.fhir.dstu2016may.model.Conformance.ConformanceRestOperationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestOperationComponent tgt = new org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestOperationComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasName()) {
            tgt.setName(src.getName());
        }
        if (src.hasDefinition()) {
            tgt.setDefinition(VersionConvertor_14_30.convertReference(src.getDefinition()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Conformance.ConformanceRestResourceComponent convertConformanceRestResourceComponent(org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestResourceComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Conformance.ConformanceRestResourceComponent tgt = new org.hl7.fhir.dstu2016may.model.Conformance.ConformanceRestResourceComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasType()) {
            tgt.setType(src.getType());
        }
        if (src.hasProfile()) {
            tgt.setProfile(VersionConvertor_14_30.convertReference(src.getProfile()));
        }
        if (src.hasInteraction()) {
            for (org.hl7.fhir.dstu3.model.CapabilityStatement.ResourceInteractionComponent t : src.getInteraction()) tgt.addInteraction(convertResourceInteractionComponent(t));
        }
        if (src.hasVersioning()) {
            tgt.setVersioning(convertResourceVersionPolicy(src.getVersioning()));
        }
        if (src.hasReadHistory())
            tgt.setReadHistory(src.getReadHistory());
        if (src.hasUpdateCreate())
            tgt.setUpdateCreate(src.getUpdateCreate());
        if (src.hasConditionalCreate())
            tgt.setConditionalCreate(src.getConditionalCreate());
        if (src.hasConditionalUpdate())
            tgt.setConditionalUpdate(src.getConditionalUpdate());
        if (src.hasConditionalDelete()) {
            tgt.setConditionalDelete(convertConditionalDeleteStatus(src.getConditionalDelete()));
        }
        if (src.hasSearchInclude()) {
            for (org.hl7.fhir.dstu3.model.StringType t : src.getSearchInclude()) tgt.addSearchInclude(t.getValue());
        }
        if (src.hasSearchRevInclude()) {
            for (org.hl7.fhir.dstu3.model.StringType t : src.getSearchRevInclude()) tgt.addSearchRevInclude(t.getValue());
        }
        if (src.hasSearchParam()) {
            for (org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent t : src.getSearchParam()) tgt.addSearchParam(convertConformanceRestResourceSearchParamComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestResourceComponent convertConformanceRestResourceComponent(org.hl7.fhir.dstu2016may.model.Conformance.ConformanceRestResourceComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestResourceComponent tgt = new org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestResourceComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasType()) {
            tgt.setType(src.getType());
        }
        if (src.hasProfile()) {
            tgt.setProfile(VersionConvertor_14_30.convertReference(src.getProfile()));
        }
        if (src.hasInteraction()) {
            for (org.hl7.fhir.dstu2016may.model.Conformance.ResourceInteractionComponent t : src.getInteraction()) tgt.addInteraction(convertResourceInteractionComponent(t));
        }
        if (src.hasVersioning()) {
            tgt.setVersioning(convertResourceVersionPolicy(src.getVersioning()));
        }
        if (src.hasReadHistory())
            tgt.setReadHistory(src.getReadHistory());
        if (src.hasUpdateCreate())
            tgt.setUpdateCreate(src.getUpdateCreate());
        if (src.hasConditionalCreate())
            tgt.setConditionalCreate(src.getConditionalCreate());
        if (src.hasConditionalUpdate())
            tgt.setConditionalUpdate(src.getConditionalUpdate());
        if (src.hasConditionalDelete()) {
            tgt.setConditionalDelete(convertConditionalDeleteStatus(src.getConditionalDelete()));
        }
        if (src.hasSearchInclude()) {
            for (org.hl7.fhir.dstu2016may.model.StringType t : src.getSearchInclude()) tgt.addSearchInclude(t.getValue());
        }
        if (src.hasSearchRevInclude()) {
            for (org.hl7.fhir.dstu2016may.model.StringType t : src.getSearchRevInclude()) tgt.addSearchRevInclude(t.getValue());
        }
        if (src.hasSearchParam()) {
            for (org.hl7.fhir.dstu2016may.model.Conformance.ConformanceRestResourceSearchParamComponent t : src.getSearchParam()) tgt.addSearchParam(convertConformanceRestResourceSearchParamComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent convertConformanceRestResourceSearchParamComponent(org.hl7.fhir.dstu2016may.model.Conformance.ConformanceRestResourceSearchParamComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent tgt = new org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasName()) {
            tgt.setName(src.getName());
        }
        if (src.hasDefinition())
            tgt.setDefinition(src.getDefinition());
        if (src.hasType()) {
            tgt.setType(VersionConvertor_14_30.convertSearchParamType(src.getType()));
        }
        if (src.hasDocumentation())
            tgt.setDocumentation(src.getDocumentation());
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Conformance.ConformanceRestResourceSearchParamComponent convertConformanceRestResourceSearchParamComponent(org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Conformance.ConformanceRestResourceSearchParamComponent tgt = new org.hl7.fhir.dstu2016may.model.Conformance.ConformanceRestResourceSearchParamComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasName()) {
            tgt.setName(src.getName());
        }
        if (src.hasDefinition())
            tgt.setDefinition(src.getDefinition());
        if (src.hasType()) {
            tgt.setType(VersionConvertor_14_30.convertSearchParamType(src.getType()));
        }
        if (src.hasDocumentation())
            tgt.setDocumentation(src.getDocumentation());
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestSecurityCertificateComponent convertConformanceRestSecurityCertificateComponent(org.hl7.fhir.dstu2016may.model.Conformance.ConformanceRestSecurityCertificateComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestSecurityCertificateComponent tgt = new org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestSecurityCertificateComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasType())
            tgt.setType(src.getType());
        if (src.hasBlob())
            tgt.setBlob(src.getBlob());
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Conformance.ConformanceRestSecurityCertificateComponent convertConformanceRestSecurityCertificateComponent(org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestSecurityCertificateComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Conformance.ConformanceRestSecurityCertificateComponent tgt = new org.hl7.fhir.dstu2016may.model.Conformance.ConformanceRestSecurityCertificateComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasType())
            tgt.setType(src.getType());
        if (src.hasBlob())
            tgt.setBlob(src.getBlob());
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Conformance.ConformanceRestSecurityComponent convertConformanceRestSecurityComponent(org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestSecurityComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Conformance.ConformanceRestSecurityComponent tgt = new org.hl7.fhir.dstu2016may.model.Conformance.ConformanceRestSecurityComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasCors())
            tgt.setCors(src.getCors());
        if (src.hasService()) {
            for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getService()) tgt.addService(VersionConvertor_14_30.convertCodeableConcept(t));
        }
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        if (src.hasCertificate()) {
            for (org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestSecurityCertificateComponent t : src.getCertificate()) tgt.addCertificate(convertConformanceRestSecurityCertificateComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestSecurityComponent convertConformanceRestSecurityComponent(org.hl7.fhir.dstu2016may.model.Conformance.ConformanceRestSecurityComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestSecurityComponent tgt = new org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementRestSecurityComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasCors())
            tgt.setCors(src.getCors());
        if (src.hasService()) {
            for (org.hl7.fhir.dstu2016may.model.CodeableConcept t : src.getService()) tgt.addService(VersionConvertor_14_30.convertCodeableConcept(t));
        }
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        if (src.hasCertificate()) {
            for (org.hl7.fhir.dstu2016may.model.Conformance.ConformanceRestSecurityCertificateComponent t : src.getCertificate()) tgt.addCertificate(convertConformanceRestSecurityCertificateComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementSoftwareComponent convertConformanceSoftwareComponent(org.hl7.fhir.dstu2016may.model.Conformance.ConformanceSoftwareComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementSoftwareComponent tgt = new org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementSoftwareComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasName()) {
            tgt.setName(src.getName());
        }
        if (src.hasVersion())
            tgt.setVersion(src.getVersion());
        if (src.hasReleaseDate())
            tgt.setReleaseDate(src.getReleaseDate());
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Conformance.ConformanceSoftwareComponent convertConformanceSoftwareComponent(org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementSoftwareComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Conformance.ConformanceSoftwareComponent tgt = new org.hl7.fhir.dstu2016may.model.Conformance.ConformanceSoftwareComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasName()) {
            tgt.setName(src.getName());
        }
        if (src.hasVersion())
            tgt.setVersion(src.getVersion());
        if (src.hasReleaseDate())
            tgt.setReleaseDate(src.getReleaseDate());
        return tgt;
    }

    static public org.hl7.fhir.dstu2016may.model.Conformance.ConformanceStatementKind convertConformanceStatementKind(org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementKind src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case INSTANCE:
                return org.hl7.fhir.dstu2016may.model.Conformance.ConformanceStatementKind.INSTANCE;
            case CAPABILITY:
                return org.hl7.fhir.dstu2016may.model.Conformance.ConformanceStatementKind.CAPABILITY;
            case REQUIREMENTS:
                return org.hl7.fhir.dstu2016may.model.Conformance.ConformanceStatementKind.REQUIREMENTS;
            default:
                return org.hl7.fhir.dstu2016may.model.Conformance.ConformanceStatementKind.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.CapabilityStatement.CapabilityStatementKind convertConformanceStatementKind(org.hl7.fhir.dstu2016may.model.Conformance.ConformanceStatementKind src) throws FHIRException {
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

    static public org.hl7.fhir.dstu2016may.model.Conformance.DocumentMode convertDocumentMode(org.hl7.fhir.dstu3.model.CapabilityStatement.DocumentMode src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case PRODUCER:
                return org.hl7.fhir.dstu2016may.model.Conformance.DocumentMode.PRODUCER;
            case CONSUMER:
                return org.hl7.fhir.dstu2016may.model.Conformance.DocumentMode.CONSUMER;
            default:
                return org.hl7.fhir.dstu2016may.model.Conformance.DocumentMode.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.CapabilityStatement.DocumentMode convertDocumentMode(org.hl7.fhir.dstu2016may.model.Conformance.DocumentMode src) throws FHIRException {
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

    static public org.hl7.fhir.dstu3.model.CapabilityStatement.MessageSignificanceCategory convertMessageSignificanceCategory(org.hl7.fhir.dstu2016may.model.Conformance.MessageSignificanceCategory src) throws FHIRException {
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

    static public org.hl7.fhir.dstu2016may.model.Conformance.MessageSignificanceCategory convertMessageSignificanceCategory(org.hl7.fhir.dstu3.model.CapabilityStatement.MessageSignificanceCategory src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case CONSEQUENCE:
                return org.hl7.fhir.dstu2016may.model.Conformance.MessageSignificanceCategory.CONSEQUENCE;
            case CURRENCY:
                return org.hl7.fhir.dstu2016may.model.Conformance.MessageSignificanceCategory.CURRENCY;
            case NOTIFICATION:
                return org.hl7.fhir.dstu2016may.model.Conformance.MessageSignificanceCategory.NOTIFICATION;
            default:
                return org.hl7.fhir.dstu2016may.model.Conformance.MessageSignificanceCategory.NULL;
        }
    }

    public static org.hl7.fhir.dstu3.model.CapabilityStatement.ResourceInteractionComponent convertResourceInteractionComponent(org.hl7.fhir.dstu2016may.model.Conformance.ResourceInteractionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.CapabilityStatement.ResourceInteractionComponent tgt = new org.hl7.fhir.dstu3.model.CapabilityStatement.ResourceInteractionComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasCode()) {
            tgt.setCode(convertTypeRestfulInteraction(src.getCode()));
        }
        if (src.hasDocumentation())
            tgt.setDocumentation(src.getDocumentation());
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.Conformance.ResourceInteractionComponent convertResourceInteractionComponent(org.hl7.fhir.dstu3.model.CapabilityStatement.ResourceInteractionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Conformance.ResourceInteractionComponent tgt = new org.hl7.fhir.dstu2016may.model.Conformance.ResourceInteractionComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasCode()) {
            tgt.setCode(convertTypeRestfulInteraction(src.getCode()));
        }
        if (src.hasDocumentation())
            tgt.setDocumentation(src.getDocumentation());
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.CapabilityStatement.ResourceVersionPolicy convertResourceVersionPolicy(org.hl7.fhir.dstu2016may.model.Conformance.ResourceVersionPolicy src) throws FHIRException {
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

    static public org.hl7.fhir.dstu2016may.model.Conformance.ResourceVersionPolicy convertResourceVersionPolicy(org.hl7.fhir.dstu3.model.CapabilityStatement.ResourceVersionPolicy src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case NOVERSION:
                return org.hl7.fhir.dstu2016may.model.Conformance.ResourceVersionPolicy.NOVERSION;
            case VERSIONED:
                return org.hl7.fhir.dstu2016may.model.Conformance.ResourceVersionPolicy.VERSIONED;
            case VERSIONEDUPDATE:
                return org.hl7.fhir.dstu2016may.model.Conformance.ResourceVersionPolicy.VERSIONEDUPDATE;
            default:
                return org.hl7.fhir.dstu2016may.model.Conformance.ResourceVersionPolicy.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.CapabilityStatement.RestfulCapabilityMode convertRestfulConformanceMode(org.hl7.fhir.dstu2016may.model.Conformance.RestfulConformanceMode src) throws FHIRException {
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

    static public org.hl7.fhir.dstu2016may.model.Conformance.RestfulConformanceMode convertRestfulConformanceMode(org.hl7.fhir.dstu3.model.CapabilityStatement.RestfulCapabilityMode src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case CLIENT:
                return org.hl7.fhir.dstu2016may.model.Conformance.RestfulConformanceMode.CLIENT;
            case SERVER:
                return org.hl7.fhir.dstu2016may.model.Conformance.RestfulConformanceMode.SERVER;
            default:
                return org.hl7.fhir.dstu2016may.model.Conformance.RestfulConformanceMode.NULL;
        }
    }

    public static org.hl7.fhir.dstu2016may.model.Conformance.SystemInteractionComponent convertSystemInteractionComponent(org.hl7.fhir.dstu3.model.CapabilityStatement.SystemInteractionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Conformance.SystemInteractionComponent tgt = new org.hl7.fhir.dstu2016may.model.Conformance.SystemInteractionComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasCode()) {
            tgt.setCode(convertSystemRestfulInteraction(src.getCode()));
        }
        if (src.hasDocumentation())
            tgt.setDocumentation(src.getDocumentation());
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CapabilityStatement.SystemInteractionComponent convertSystemInteractionComponent(org.hl7.fhir.dstu2016may.model.Conformance.SystemInteractionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.CapabilityStatement.SystemInteractionComponent tgt = new org.hl7.fhir.dstu3.model.CapabilityStatement.SystemInteractionComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasCode()) {
            tgt.setCode(convertSystemRestfulInteraction(src.getCode()));
        }
        if (src.hasDocumentation())
            tgt.setDocumentation(src.getDocumentation());
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.CapabilityStatement.SystemRestfulInteraction convertSystemRestfulInteraction(org.hl7.fhir.dstu2016may.model.Conformance.SystemRestfulInteraction src) throws FHIRException {
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

    static public org.hl7.fhir.dstu2016may.model.Conformance.SystemRestfulInteraction convertSystemRestfulInteraction(org.hl7.fhir.dstu3.model.CapabilityStatement.SystemRestfulInteraction src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case TRANSACTION:
                return org.hl7.fhir.dstu2016may.model.Conformance.SystemRestfulInteraction.TRANSACTION;
            case SEARCHSYSTEM:
                return org.hl7.fhir.dstu2016may.model.Conformance.SystemRestfulInteraction.SEARCHSYSTEM;
            case HISTORYSYSTEM:
                return org.hl7.fhir.dstu2016may.model.Conformance.SystemRestfulInteraction.HISTORYSYSTEM;
            default:
                return org.hl7.fhir.dstu2016may.model.Conformance.SystemRestfulInteraction.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.CapabilityStatement.TypeRestfulInteraction convertTypeRestfulInteraction(org.hl7.fhir.dstu2016may.model.Conformance.TypeRestfulInteraction src) throws FHIRException {
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

    static public org.hl7.fhir.dstu2016may.model.Conformance.TypeRestfulInteraction convertTypeRestfulInteraction(org.hl7.fhir.dstu3.model.CapabilityStatement.TypeRestfulInteraction src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case READ:
                return org.hl7.fhir.dstu2016may.model.Conformance.TypeRestfulInteraction.READ;
            case VREAD:
                return org.hl7.fhir.dstu2016may.model.Conformance.TypeRestfulInteraction.VREAD;
            case UPDATE:
                return org.hl7.fhir.dstu2016may.model.Conformance.TypeRestfulInteraction.UPDATE;
            case DELETE:
                return org.hl7.fhir.dstu2016may.model.Conformance.TypeRestfulInteraction.DELETE;
            case HISTORYINSTANCE:
                return org.hl7.fhir.dstu2016may.model.Conformance.TypeRestfulInteraction.HISTORYINSTANCE;
            case HISTORYTYPE:
                return org.hl7.fhir.dstu2016may.model.Conformance.TypeRestfulInteraction.HISTORYTYPE;
            case CREATE:
                return org.hl7.fhir.dstu2016may.model.Conformance.TypeRestfulInteraction.CREATE;
            case SEARCHTYPE:
                return org.hl7.fhir.dstu2016may.model.Conformance.TypeRestfulInteraction.SEARCHTYPE;
            default:
                return org.hl7.fhir.dstu2016may.model.Conformance.TypeRestfulInteraction.NULL;
        }
    }

    static public org.hl7.fhir.dstu2016may.model.Conformance.UnknownContentCode convertUnknownContentCode(org.hl7.fhir.dstu3.model.CapabilityStatement.UnknownContentCode src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case NO:
                return org.hl7.fhir.dstu2016may.model.Conformance.UnknownContentCode.NO;
            case EXTENSIONS:
                return org.hl7.fhir.dstu2016may.model.Conformance.UnknownContentCode.EXTENSIONS;
            case ELEMENTS:
                return org.hl7.fhir.dstu2016may.model.Conformance.UnknownContentCode.ELEMENTS;
            case BOTH:
                return org.hl7.fhir.dstu2016may.model.Conformance.UnknownContentCode.BOTH;
            default:
                return org.hl7.fhir.dstu2016may.model.Conformance.UnknownContentCode.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.CapabilityStatement.UnknownContentCode convertUnknownContentCode(org.hl7.fhir.dstu2016may.model.Conformance.UnknownContentCode src) throws FHIRException {
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
}
