package org.hl7.fhir.convertors.conv10_50;

import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.convertors.VersionConvertor_10_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestComponent;
import org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestResourceComponent;
import org.hl7.fhir.r5.model.CapabilityStatement.SystemRestfulInteraction;

public class Conformance10_50 {

    public static org.hl7.fhir.dstu2.model.Conformance.ConditionalDeleteStatus convertConditionalDeleteStatus(org.hl7.fhir.r5.model.CapabilityStatement.ConditionalDeleteStatus src) throws FHIRException {
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

    public static org.hl7.fhir.r5.model.CapabilityStatement.ConditionalDeleteStatus convertConditionalDeleteStatus(org.hl7.fhir.dstu2.model.Conformance.ConditionalDeleteStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case NOTSUPPORTED:
                return org.hl7.fhir.r5.model.CapabilityStatement.ConditionalDeleteStatus.NOTSUPPORTED;
            case SINGLE:
                return org.hl7.fhir.r5.model.CapabilityStatement.ConditionalDeleteStatus.SINGLE;
            case MULTIPLE:
                return org.hl7.fhir.r5.model.CapabilityStatement.ConditionalDeleteStatus.MULTIPLE;
            default:
                return org.hl7.fhir.r5.model.CapabilityStatement.ConditionalDeleteStatus.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.Conformance convertConformance(org.hl7.fhir.r5.model.CapabilityStatement src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Conformance tgt = new org.hl7.fhir.dstu2.model.Conformance();
        VersionConvertor_10_50.copyDomainResource(src, tgt, "http://hl7.org/fhir/3.0/StructureDefinition/extension-CapabilityStatement.acceptUnknown");
        tgt.setUrl(src.getUrl());
        tgt.setVersion(src.getVersion());
        tgt.setName(src.getName());
        tgt.setStatus(VersionConvertor_10_50.convertConformanceResourceStatus(src.getStatus()));
        if (src.hasExperimental())
            tgt.setExperimental(src.getExperimental());
        if (src.hasDate())
            tgt.setDate(src.getDate());
        tgt.setPublisher(src.getPublisher());
        for (org.hl7.fhir.r5.model.ContactDetail t : src.getContact()) tgt.addContact(convertConformanceContactComponent(t));
        tgt.setDescription(src.getDescription());
        tgt.setRequirements(src.getPurpose());
        tgt.setCopyright(src.getCopyright());
        tgt.setKind(convertConformanceStatementKind(src.getKind()));
        tgt.setSoftware(convertConformanceSoftwareComponent(src.getSoftware()));
        if (src.hasImplementation())
            tgt.setImplementation(convertConformanceImplementationComponent(src.getImplementation()));
        if (src.hasFhirVersion())
            tgt.setFhirVersion(src.getFhirVersion().toCode());
        if (src.hasExtension("http://hl7.org/fhir/3.0/StructureDefinition/extension-CapabilityStatement.acceptUnknown"))
            tgt.setAcceptUnknown(org.hl7.fhir.dstu2.model.Conformance.UnknownContentCode.fromCode(src.getExtensionByUrl("http://hl7.org/fhir/3.0/StructureDefinition/extension-CapabilityStatement.acceptUnknown").getValue().primitiveValue()));
        for (org.hl7.fhir.r5.model.CodeType t : src.getFormat()) tgt.addFormat(t.getValue());
        for (CapabilityStatementRestComponent r : src.getRest()) for (CapabilityStatementRestResourceComponent rr : r.getResource()) for (org.hl7.fhir.r5.model.CanonicalType t : rr.getSupportedProfile()) tgt.addProfile(VersionConvertor_10_50.convertCanonicalToReference(t));
        for (org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestComponent t : src.getRest()) tgt.addRest(convertConformanceRestComponent(t));
        for (org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementMessagingComponent t : src.getMessaging()) tgt.addMessaging(convertConformanceMessagingComponent(t));
        for (org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementDocumentComponent t : src.getDocument()) tgt.addDocument(convertConformanceDocumentComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.CapabilityStatement convertConformance(org.hl7.fhir.dstu2.model.Conformance src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.CapabilityStatement tgt = new org.hl7.fhir.r5.model.CapabilityStatement();
        VersionConvertor_10_50.copyDomainResource(src, tgt);
        tgt.setUrl(src.getUrl());
        tgt.setVersion(src.getVersion());
        tgt.setName(src.getName());
        tgt.setStatus(VersionConvertor_10_50.convertConformanceResourceStatus(src.getStatus()));
        if (src.hasExperimental())
            tgt.setExperimental(src.getExperimental());
        if (src.hasDate())
            tgt.setDate(src.getDate());
        tgt.setPublisher(src.getPublisher());
        for (org.hl7.fhir.dstu2.model.Conformance.ConformanceContactComponent t : src.getContact()) tgt.addContact(convertConformanceContactComponent(t));
        tgt.setDescription(src.getDescription());
        tgt.setPurpose(src.getRequirements());
        tgt.setCopyright(src.getCopyright());
        tgt.setKind(convertConformanceStatementKind(src.getKind()));
        tgt.setSoftware(convertConformanceSoftwareComponent(src.getSoftware()));
        tgt.setImplementation(convertConformanceImplementationComponent(src.getImplementation()));
        tgt.setFhirVersion(org.hl7.fhir.r5.model.Enumerations.FHIRVersion.fromCode(src.getFhirVersion()));
        if (src.hasAcceptUnknown())
            tgt.addExtension().setUrl("http://hl7.org/fhir/3.0/StructureDefinition/extension-CapabilityStatement.acceptUnknown").setValue(new org.hl7.fhir.r5.model.CodeType(src.getAcceptUnknownElement().asStringValue()));
        for (org.hl7.fhir.dstu2.model.CodeType t : src.getFormat()) tgt.addFormat(t.getValue());
        for (org.hl7.fhir.dstu2.model.Conformance.ConformanceRestComponent t : src.getRest()) tgt.addRest(convertConformanceRestComponent(t));
        for (org.hl7.fhir.dstu2.model.Conformance.ConformanceMessagingComponent t : src.getMessaging()) tgt.addMessaging(convertConformanceMessagingComponent(t));
        for (org.hl7.fhir.dstu2.model.Conformance.ConformanceDocumentComponent t : src.getDocument()) tgt.addDocument(convertConformanceDocumentComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Conformance.ConformanceContactComponent convertConformanceContactComponent(org.hl7.fhir.r5.model.ContactDetail src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Conformance.ConformanceContactComponent tgt = new org.hl7.fhir.dstu2.model.Conformance.ConformanceContactComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        tgt.setName(src.getName());
        for (org.hl7.fhir.r5.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_10_50.convertContactPoint(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ContactDetail convertConformanceContactComponent(org.hl7.fhir.dstu2.model.Conformance.ConformanceContactComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.ContactDetail tgt = new org.hl7.fhir.r5.model.ContactDetail();
        VersionConvertor_10_50.copyElement(src, tgt);
        tgt.setName(src.getName());
        for (org.hl7.fhir.dstu2.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_10_50.convertContactPoint(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementDocumentComponent convertConformanceDocumentComponent(org.hl7.fhir.dstu2.model.Conformance.ConformanceDocumentComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementDocumentComponent tgt = new org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementDocumentComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        tgt.setMode(convertDocumentMode(src.getMode()));
        tgt.setDocumentation(src.getDocumentation());
        tgt.setProfileElement(VersionConvertor_10_50.convertReferenceToCanonical(src.getProfile()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Conformance.ConformanceDocumentComponent convertConformanceDocumentComponent(org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementDocumentComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Conformance.ConformanceDocumentComponent tgt = new org.hl7.fhir.dstu2.model.Conformance.ConformanceDocumentComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        tgt.setMode(convertDocumentMode(src.getMode()));
        tgt.setDocumentation(src.getDocumentation());
        tgt.setProfile(VersionConvertor_10_50.convertCanonicalToReference(src.getProfileElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Conformance.ConformanceImplementationComponent convertConformanceImplementationComponent(org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementImplementationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Conformance.ConformanceImplementationComponent tgt = new org.hl7.fhir.dstu2.model.Conformance.ConformanceImplementationComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        tgt.setDescription(src.getDescription());
        tgt.setUrl(src.getUrl());
        return tgt;
    }

    public static org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementImplementationComponent convertConformanceImplementationComponent(org.hl7.fhir.dstu2.model.Conformance.ConformanceImplementationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementImplementationComponent tgt = new org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementImplementationComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        tgt.setDescription(src.getDescription());
        tgt.setUrl(src.getUrl());
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Conformance.ConformanceMessagingComponent convertConformanceMessagingComponent(org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementMessagingComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Conformance.ConformanceMessagingComponent tgt = new org.hl7.fhir.dstu2.model.Conformance.ConformanceMessagingComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        for (org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementMessagingEndpointComponent t : src.getEndpoint()) tgt.addEndpoint(convertConformanceMessagingEndpointComponent(t));
        tgt.setReliableCache(src.getReliableCache());
        tgt.setDocumentation(src.getDocumentation());
        for (org.hl7.fhir.r5.model.Extension e : src.getExtensionsByUrl(VersionConvertorConstants.IG_CONFORMANCE_MESSAGE_EVENT)) {
            org.hl7.fhir.dstu2.model.Conformance.ConformanceMessagingEventComponent event = new org.hl7.fhir.dstu2.model.Conformance.ConformanceMessagingEventComponent();
            tgt.addEvent(event);
            event.setCode(VersionConvertor_10_50.convertCoding((org.hl7.fhir.r5.model.Coding) e.getExtensionByUrl("code").getValue()));
            if (e.hasExtension("category"))
                event.setCategory(org.hl7.fhir.dstu2.model.Conformance.MessageSignificanceCategory.fromCode(e.getExtensionByUrl("category").getValue().toString()));
            event.setMode(org.hl7.fhir.dstu2.model.Conformance.ConformanceEventMode.fromCode(e.getExtensionByUrl("mode").getValue().toString()));
            event.setCode(VersionConvertor_10_50.convertCoding((org.hl7.fhir.r5.model.Coding) e.getExtensionByUrl("code").getValue()));
            org.hl7.fhir.r5.model.Extension focusE = e.getExtensionByUrl("focus");
            if (focusE.getValue().hasPrimitiveValue())
                event.setFocus(focusE.getValue().toString());
            else {
                event.setFocusElement(new org.hl7.fhir.dstu2.model.CodeType());
                VersionConvertor_10_50.copyElement(focusE.getValue(), event.getFocusElement());
            }
            event.setRequest(VersionConvertor_10_50.convertReference((org.hl7.fhir.r5.model.Reference) e.getExtensionByUrl("request").getValue()));
            event.setResponse(VersionConvertor_10_50.convertReference((org.hl7.fhir.r5.model.Reference) e.getExtensionByUrl("response").getValue()));
            if (e.hasExtension("documentation"))
                event.setDocumentation(e.getExtensionByUrl("documentation").getValue().toString());
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementMessagingComponent convertConformanceMessagingComponent(org.hl7.fhir.dstu2.model.Conformance.ConformanceMessagingComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementMessagingComponent tgt = new org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementMessagingComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        for (org.hl7.fhir.dstu2.model.Conformance.ConformanceMessagingEndpointComponent t : src.getEndpoint()) tgt.addEndpoint(convertConformanceMessagingEndpointComponent(t));
        tgt.setReliableCache(src.getReliableCache());
        tgt.setDocumentation(src.getDocumentation());
        for (org.hl7.fhir.dstu2.model.Conformance.ConformanceMessagingEventComponent t : src.getEvent()) {
            org.hl7.fhir.r5.model.Extension e = new org.hl7.fhir.r5.model.Extension(VersionConvertorConstants.IG_CONFORMANCE_MESSAGE_EVENT);
            e.addExtension(new org.hl7.fhir.r5.model.Extension("code", VersionConvertor_10_50.convertCoding(t.getCode())));
            if (t.hasCategory())
                e.addExtension(new org.hl7.fhir.r5.model.Extension("category", new org.hl7.fhir.r5.model.CodeType(t.getCategory().toCode())));
            e.addExtension(new org.hl7.fhir.r5.model.Extension("mode", new org.hl7.fhir.r5.model.CodeType(t.getMode().toCode())));
            if (t.getFocusElement().hasValue())
                e.addExtension(new org.hl7.fhir.r5.model.Extension("focus", new org.hl7.fhir.r5.model.StringType(t.getFocus())));
            else {
                org.hl7.fhir.r5.model.CodeType focus = new org.hl7.fhir.r5.model.CodeType();
                org.hl7.fhir.r5.model.Extension focusE = new org.hl7.fhir.r5.model.Extension("focus", focus);
                VersionConvertor_10_50.copyElement(t.getFocusElement(), focus);
                e.addExtension(focusE);
            }
            e.addExtension(new org.hl7.fhir.r5.model.Extension("request", VersionConvertor_10_50.convertReference(t.getRequest())));
            e.addExtension(new org.hl7.fhir.r5.model.Extension("response", VersionConvertor_10_50.convertReference(t.getResponse())));
            if (t.hasDocumentation())
                e.addExtension(new org.hl7.fhir.r5.model.Extension("documentation", new org.hl7.fhir.r5.model.StringType(t.getDocumentation())));
            tgt.addExtension(e);
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementMessagingEndpointComponent convertConformanceMessagingEndpointComponent(org.hl7.fhir.dstu2.model.Conformance.ConformanceMessagingEndpointComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementMessagingEndpointComponent tgt = new org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementMessagingEndpointComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        tgt.setProtocol(VersionConvertor_10_50.convertCoding(src.getProtocol()));
        tgt.setAddress(src.getAddress());
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Conformance.ConformanceMessagingEndpointComponent convertConformanceMessagingEndpointComponent(org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementMessagingEndpointComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Conformance.ConformanceMessagingEndpointComponent tgt = new org.hl7.fhir.dstu2.model.Conformance.ConformanceMessagingEndpointComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        tgt.setProtocol(VersionConvertor_10_50.convertCoding(src.getProtocol()));
        tgt.setAddress(src.getAddress());
        return tgt;
    }

    public static org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestComponent convertConformanceRestComponent(org.hl7.fhir.dstu2.model.Conformance.ConformanceRestComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestComponent tgt = new org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        tgt.setMode(convertRestfulConformanceMode(src.getMode()));
        tgt.setDocumentation(src.getDocumentation());
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

    public static org.hl7.fhir.dstu2.model.Conformance.ConformanceRestComponent convertConformanceRestComponent(org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Conformance.ConformanceRestComponent tgt = new org.hl7.fhir.dstu2.model.Conformance.ConformanceRestComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        tgt.setMode(convertRestfulConformanceMode(src.getMode()));
        tgt.setDocumentation(src.getDocumentation());
        tgt.setSecurity(convertConformanceRestSecurityComponent(src.getSecurity()));
        for (org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestResourceComponent t : src.getResource()) tgt.addResource(convertConformanceRestResourceComponent(t));
        boolean batch = false;
        boolean transaction = false;
        for (org.hl7.fhir.r5.model.CapabilityStatement.SystemInteractionComponent t : src.getInteraction()) {
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
        for (org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent t : src.getSearchParam()) tgt.addSearchParam(convertConformanceRestResourceSearchParamComponent(t));
        for (org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestResourceOperationComponent t : src.getOperation()) tgt.addOperation(convertConformanceRestOperationComponent(t));
        for (org.hl7.fhir.r5.model.UriType t : src.getCompartment()) tgt.addCompartment(t.getValue());
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Conformance.ConformanceRestOperationComponent convertConformanceRestOperationComponent(org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestResourceOperationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Conformance.ConformanceRestOperationComponent tgt = new org.hl7.fhir.dstu2.model.Conformance.ConformanceRestOperationComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        tgt.setName(src.getName());
        tgt.setDefinition(VersionConvertor_10_50.convertCanonicalToReference(src.getDefinitionElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestResourceOperationComponent convertConformanceRestOperationComponent(org.hl7.fhir.dstu2.model.Conformance.ConformanceRestOperationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestResourceOperationComponent tgt = new org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestResourceOperationComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        tgt.setName(src.getName());
        tgt.setDefinitionElement(VersionConvertor_10_50.convertReferenceToCanonical(src.getDefinition()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestResourceComponent convertConformanceRestResourceComponent(org.hl7.fhir.dstu2.model.Conformance.ConformanceRestResourceComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestResourceComponent tgt = new org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestResourceComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        tgt.setType(src.getType());
        tgt.setProfileElement(VersionConvertor_10_50.convertReferenceToCanonical(src.getProfile()));
        for (org.hl7.fhir.dstu2.model.Conformance.ResourceInteractionComponent t : src.getInteraction()) tgt.addInteraction(convertResourceInteractionComponent(t));
        tgt.setVersioning(convertResourceVersionPolicy(src.getVersioning()));
        tgt.setReadHistory(src.getReadHistory());
        tgt.setUpdateCreate(src.getUpdateCreate());
        tgt.setConditionalCreate(src.getConditionalCreate());
        tgt.setConditionalUpdate(src.getConditionalUpdate());
        tgt.setConditionalDelete(convertConditionalDeleteStatus(src.getConditionalDelete()));
        for (org.hl7.fhir.dstu2.model.StringType t : src.getSearchInclude()) tgt.addSearchInclude(t.getValue());
        for (org.hl7.fhir.dstu2.model.StringType t : src.getSearchRevInclude()) tgt.addSearchRevInclude(t.getValue());
        for (org.hl7.fhir.dstu2.model.Conformance.ConformanceRestResourceSearchParamComponent t : src.getSearchParam()) tgt.addSearchParam(convertConformanceRestResourceSearchParamComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Conformance.ConformanceRestResourceComponent convertConformanceRestResourceComponent(org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestResourceComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Conformance.ConformanceRestResourceComponent tgt = new org.hl7.fhir.dstu2.model.Conformance.ConformanceRestResourceComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        if (src.hasType()) {
            tgt.setType(src.getType());
        }
        if (src.hasProfile())
            tgt.setProfile(VersionConvertor_10_50.convertCanonicalToReference(src.getProfileElement()));
        for (org.hl7.fhir.r5.model.CapabilityStatement.ResourceInteractionComponent t : src.getInteraction()) tgt.addInteraction(convertResourceInteractionComponent(t));
        tgt.setVersioning(convertResourceVersionPolicy(src.getVersioning()));
        tgt.setReadHistory(src.getReadHistory());
        tgt.setUpdateCreate(src.getUpdateCreate());
        tgt.setConditionalCreate(src.getConditionalCreate());
        tgt.setConditionalUpdate(src.getConditionalUpdate());
        tgt.setConditionalDelete(convertConditionalDeleteStatus(src.getConditionalDelete()));
        for (org.hl7.fhir.r5.model.StringType t : src.getSearchInclude()) tgt.addSearchInclude(t.getValue());
        for (org.hl7.fhir.r5.model.StringType t : src.getSearchRevInclude()) tgt.addSearchRevInclude(t.getValue());
        for (org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent t : src.getSearchParam()) tgt.addSearchParam(convertConformanceRestResourceSearchParamComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent convertConformanceRestResourceSearchParamComponent(org.hl7.fhir.dstu2.model.Conformance.ConformanceRestResourceSearchParamComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent tgt = new org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        tgt.setName(src.getName());
        tgt.setDefinition(src.getDefinition());
        tgt.setType(VersionConvertor_10_50.convertSearchParamType(src.getType()));
        tgt.setDocumentation(src.getDocumentation());
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Conformance.ConformanceRestResourceSearchParamComponent convertConformanceRestResourceSearchParamComponent(org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestResourceSearchParamComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Conformance.ConformanceRestResourceSearchParamComponent tgt = new org.hl7.fhir.dstu2.model.Conformance.ConformanceRestResourceSearchParamComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        tgt.setName(src.getName());
        tgt.setDefinition(src.getDefinition());
        tgt.setType(VersionConvertor_10_50.convertSearchParamType(src.getType()));
        tgt.setDocumentation(src.getDocumentation());
        return tgt;
    }

    public static org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestSecurityComponent convertConformanceRestSecurityComponent(org.hl7.fhir.dstu2.model.Conformance.ConformanceRestSecurityComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestSecurityComponent tgt = new org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestSecurityComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        tgt.setCors(src.getCors());
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getService()) tgt.addService(VersionConvertor_10_50.convertCodeableConcept(t));
        tgt.setDescription(src.getDescription());
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Conformance.ConformanceRestSecurityComponent convertConformanceRestSecurityComponent(org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementRestSecurityComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Conformance.ConformanceRestSecurityComponent tgt = new org.hl7.fhir.dstu2.model.Conformance.ConformanceRestSecurityComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        tgt.setCors(src.getCors());
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getService()) tgt.addService(VersionConvertor_10_50.convertCodeableConcept(t));
        tgt.setDescription(src.getDescription());
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Conformance.ConformanceSoftwareComponent convertConformanceSoftwareComponent(org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementSoftwareComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Conformance.ConformanceSoftwareComponent tgt = new org.hl7.fhir.dstu2.model.Conformance.ConformanceSoftwareComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        tgt.setName(src.getName());
        tgt.setVersion(src.getVersion());
        tgt.setReleaseDate(src.getReleaseDate());
        return tgt;
    }

    public static org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementSoftwareComponent convertConformanceSoftwareComponent(org.hl7.fhir.dstu2.model.Conformance.ConformanceSoftwareComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementSoftwareComponent tgt = new org.hl7.fhir.r5.model.CapabilityStatement.CapabilityStatementSoftwareComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        tgt.setName(src.getName());
        tgt.setVersion(src.getVersion());
        tgt.setReleaseDate(src.getReleaseDate());
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Conformance.ConformanceStatementKind convertConformanceStatementKind(org.hl7.fhir.r5.model.Enumerations.CapabilityStatementKind src) throws FHIRException {
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

    public static org.hl7.fhir.r5.model.Enumerations.CapabilityStatementKind convertConformanceStatementKind(org.hl7.fhir.dstu2.model.Conformance.ConformanceStatementKind src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case INSTANCE:
                return org.hl7.fhir.r5.model.Enumerations.CapabilityStatementKind.INSTANCE;
            case CAPABILITY:
                return org.hl7.fhir.r5.model.Enumerations.CapabilityStatementKind.CAPABILITY;
            case REQUIREMENTS:
                return org.hl7.fhir.r5.model.Enumerations.CapabilityStatementKind.REQUIREMENTS;
            default:
                return org.hl7.fhir.r5.model.Enumerations.CapabilityStatementKind.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.Conformance.DocumentMode convertDocumentMode(org.hl7.fhir.r5.model.CapabilityStatement.DocumentMode src) throws FHIRException {
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

    public static org.hl7.fhir.r5.model.CapabilityStatement.DocumentMode convertDocumentMode(org.hl7.fhir.dstu2.model.Conformance.DocumentMode src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case PRODUCER:
                return org.hl7.fhir.r5.model.CapabilityStatement.DocumentMode.PRODUCER;
            case CONSUMER:
                return org.hl7.fhir.r5.model.CapabilityStatement.DocumentMode.CONSUMER;
            default:
                return org.hl7.fhir.r5.model.CapabilityStatement.DocumentMode.NULL;
        }
    }

    public static org.hl7.fhir.r5.model.CapabilityStatement.ResourceInteractionComponent convertResourceInteractionComponent(org.hl7.fhir.dstu2.model.Conformance.ResourceInteractionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.CapabilityStatement.ResourceInteractionComponent tgt = new org.hl7.fhir.r5.model.CapabilityStatement.ResourceInteractionComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        tgt.setCode(convertTypeRestfulInteraction(src.getCode()));
        tgt.setDocumentation(src.getDocumentation());
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Conformance.ResourceInteractionComponent convertResourceInteractionComponent(org.hl7.fhir.r5.model.CapabilityStatement.ResourceInteractionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Conformance.ResourceInteractionComponent tgt = new org.hl7.fhir.dstu2.model.Conformance.ResourceInteractionComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        tgt.setCode(convertTypeRestfulInteraction(src.getCode()));
        tgt.setDocumentation(src.getDocumentation());
        return tgt;
    }

    public static org.hl7.fhir.r5.model.CapabilityStatement.ResourceVersionPolicy convertResourceVersionPolicy(org.hl7.fhir.dstu2.model.Conformance.ResourceVersionPolicy src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case NOVERSION:
                return org.hl7.fhir.r5.model.CapabilityStatement.ResourceVersionPolicy.NOVERSION;
            case VERSIONED:
                return org.hl7.fhir.r5.model.CapabilityStatement.ResourceVersionPolicy.VERSIONED;
            case VERSIONEDUPDATE:
                return org.hl7.fhir.r5.model.CapabilityStatement.ResourceVersionPolicy.VERSIONEDUPDATE;
            default:
                return org.hl7.fhir.r5.model.CapabilityStatement.ResourceVersionPolicy.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.Conformance.ResourceVersionPolicy convertResourceVersionPolicy(org.hl7.fhir.r5.model.CapabilityStatement.ResourceVersionPolicy src) throws FHIRException {
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

    public static org.hl7.fhir.r5.model.Enumerations.RestfulCapabilityMode convertRestfulConformanceMode(org.hl7.fhir.dstu2.model.Conformance.RestfulConformanceMode src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case CLIENT:
                return org.hl7.fhir.r5.model.Enumerations.RestfulCapabilityMode.CLIENT;
            case SERVER:
                return org.hl7.fhir.r5.model.Enumerations.RestfulCapabilityMode.SERVER;
            default:
                return org.hl7.fhir.r5.model.Enumerations.RestfulCapabilityMode.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.Conformance.RestfulConformanceMode convertRestfulConformanceMode(org.hl7.fhir.r5.model.Enumerations.RestfulCapabilityMode src) throws FHIRException {
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

    public static org.hl7.fhir.dstu2.model.Conformance.SystemInteractionComponent convertSystemInteractionComponent(org.hl7.fhir.r5.model.CapabilityStatement.SystemInteractionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Conformance.SystemInteractionComponent tgt = new org.hl7.fhir.dstu2.model.Conformance.SystemInteractionComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        tgt.setCode(convertSystemRestfulInteraction(src.getCode()));
        tgt.setDocumentation(src.getDocumentation());
        return tgt;
    }

    public static org.hl7.fhir.r5.model.CapabilityStatement.SystemInteractionComponent convertSystemInteractionComponent(org.hl7.fhir.dstu2.model.Conformance.SystemInteractionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.CapabilityStatement.SystemInteractionComponent tgt = new org.hl7.fhir.r5.model.CapabilityStatement.SystemInteractionComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        tgt.setCode(convertSystemRestfulInteraction(src.getCode()));
        tgt.setDocumentation(src.getDocumentation());
        return tgt;
    }

    public static org.hl7.fhir.r5.model.CapabilityStatement.SystemRestfulInteraction convertSystemRestfulInteraction(org.hl7.fhir.dstu2.model.Conformance.SystemRestfulInteraction src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case TRANSACTION:
                return org.hl7.fhir.r5.model.CapabilityStatement.SystemRestfulInteraction.TRANSACTION;
            case SEARCHSYSTEM:
                return org.hl7.fhir.r5.model.CapabilityStatement.SystemRestfulInteraction.SEARCHSYSTEM;
            case HISTORYSYSTEM:
                return org.hl7.fhir.r5.model.CapabilityStatement.SystemRestfulInteraction.HISTORYSYSTEM;
            default:
                return org.hl7.fhir.r5.model.CapabilityStatement.SystemRestfulInteraction.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.Conformance.SystemRestfulInteraction convertSystemRestfulInteraction(org.hl7.fhir.r5.model.CapabilityStatement.SystemRestfulInteraction src) throws FHIRException {
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

    public static org.hl7.fhir.dstu2.model.Conformance.TypeRestfulInteraction convertTypeRestfulInteraction(org.hl7.fhir.r5.model.CapabilityStatement.TypeRestfulInteraction src) throws FHIRException {
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

    public static org.hl7.fhir.r5.model.CapabilityStatement.TypeRestfulInteraction convertTypeRestfulInteraction(org.hl7.fhir.dstu2.model.Conformance.TypeRestfulInteraction src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case READ:
                return org.hl7.fhir.r5.model.CapabilityStatement.TypeRestfulInteraction.READ;
            case VREAD:
                return org.hl7.fhir.r5.model.CapabilityStatement.TypeRestfulInteraction.VREAD;
            case UPDATE:
                return org.hl7.fhir.r5.model.CapabilityStatement.TypeRestfulInteraction.UPDATE;
            case DELETE:
                return org.hl7.fhir.r5.model.CapabilityStatement.TypeRestfulInteraction.DELETE;
            case HISTORYINSTANCE:
                return org.hl7.fhir.r5.model.CapabilityStatement.TypeRestfulInteraction.HISTORYINSTANCE;
            case HISTORYTYPE:
                return org.hl7.fhir.r5.model.CapabilityStatement.TypeRestfulInteraction.HISTORYTYPE;
            case CREATE:
                return org.hl7.fhir.r5.model.CapabilityStatement.TypeRestfulInteraction.CREATE;
            case SEARCHTYPE:
                return org.hl7.fhir.r5.model.CapabilityStatement.TypeRestfulInteraction.SEARCHTYPE;
            default:
                return org.hl7.fhir.r5.model.CapabilityStatement.TypeRestfulInteraction.NULL;
        }
    }
}
