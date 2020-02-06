package org.hl7.fhir.convertors.conv30_40;

import org.hl7.fhir.convertors.VersionConvertor_30_40;
import org.hl7.fhir.exceptions.FHIRException;

public class MessageHeader30_40 {

    public static org.hl7.fhir.dstu3.model.MessageHeader.MessageDestinationComponent convertMessageDestinationComponent(org.hl7.fhir.r4.model.MessageHeader.MessageDestinationComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.MessageHeader.MessageDestinationComponent tgt = new org.hl7.fhir.dstu3.model.MessageHeader.MessageDestinationComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasName())
            tgt.setName(src.getName());
        if (src.hasTarget())
            tgt.setTarget(VersionConvertor_30_40.convertReference(src.getTarget()));
        if (src.hasEndpoint())
            tgt.setEndpoint(src.getEndpoint());
        return tgt;
    }

    public static org.hl7.fhir.r4.model.MessageHeader.MessageDestinationComponent convertMessageDestinationComponent(org.hl7.fhir.dstu3.model.MessageHeader.MessageDestinationComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.MessageHeader.MessageDestinationComponent tgt = new org.hl7.fhir.r4.model.MessageHeader.MessageDestinationComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasName())
            tgt.setName(src.getName());
        if (src.hasTarget())
            tgt.setTarget(VersionConvertor_30_40.convertReference(src.getTarget()));
        if (src.hasEndpoint())
            tgt.setEndpoint(src.getEndpoint());
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.MessageHeader convertMessageHeader(org.hl7.fhir.r4.model.MessageHeader src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.MessageHeader tgt = new org.hl7.fhir.dstu3.model.MessageHeader();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        if (src.hasEventCoding())
            tgt.setEvent(VersionConvertor_30_40.convertCoding(src.getEventCoding()));
        if (src.hasDestination()) {
            for (org.hl7.fhir.r4.model.MessageHeader.MessageDestinationComponent t : src.getDestination()) tgt.addDestination(convertMessageDestinationComponent(t));
        }
        if (src.hasSender())
            tgt.setSender(VersionConvertor_30_40.convertReference(src.getSender()));
        if (src.hasEnterer())
            tgt.setEnterer(VersionConvertor_30_40.convertReference(src.getEnterer()));
        if (src.hasAuthor())
            tgt.setAuthor(VersionConvertor_30_40.convertReference(src.getAuthor()));
        if (src.hasSource())
            tgt.setSource(convertMessageSourceComponent(src.getSource()));
        if (src.hasResponsible())
            tgt.setResponsible(VersionConvertor_30_40.convertReference(src.getResponsible()));
        if (src.hasReason())
            tgt.setReason(VersionConvertor_30_40.convertCodeableConcept(src.getReason()));
        if (src.hasResponse())
            tgt.setResponse(convertMessageHeaderResponseComponent(src.getResponse()));
        if (src.hasFocus()) {
            for (org.hl7.fhir.r4.model.Reference t : src.getFocus()) tgt.addFocus(VersionConvertor_30_40.convertReference(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.MessageHeader convertMessageHeader(org.hl7.fhir.dstu3.model.MessageHeader src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.MessageHeader tgt = new org.hl7.fhir.r4.model.MessageHeader();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        if (src.hasEvent())
            tgt.setEvent(VersionConvertor_30_40.convertCoding(src.getEvent()));
        if (src.hasDestination()) {
            for (org.hl7.fhir.dstu3.model.MessageHeader.MessageDestinationComponent t : src.getDestination()) tgt.addDestination(convertMessageDestinationComponent(t));
        }
        if (src.hasSender())
            tgt.setSender(VersionConvertor_30_40.convertReference(src.getSender()));
        if (src.hasEnterer())
            tgt.setEnterer(VersionConvertor_30_40.convertReference(src.getEnterer()));
        if (src.hasAuthor())
            tgt.setAuthor(VersionConvertor_30_40.convertReference(src.getAuthor()));
        if (src.hasSource())
            tgt.setSource(convertMessageSourceComponent(src.getSource()));
        if (src.hasResponsible())
            tgt.setResponsible(VersionConvertor_30_40.convertReference(src.getResponsible()));
        if (src.hasReason())
            tgt.setReason(VersionConvertor_30_40.convertCodeableConcept(src.getReason()));
        if (src.hasResponse())
            tgt.setResponse(convertMessageHeaderResponseComponent(src.getResponse()));
        if (src.hasFocus()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getFocus()) tgt.addFocus(VersionConvertor_30_40.convertReference(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.MessageHeader.MessageHeaderResponseComponent convertMessageHeaderResponseComponent(org.hl7.fhir.dstu3.model.MessageHeader.MessageHeaderResponseComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.MessageHeader.MessageHeaderResponseComponent tgt = new org.hl7.fhir.r4.model.MessageHeader.MessageHeaderResponseComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasIdentifier())
            tgt.setIdentifier(src.getIdentifier());
        if (src.hasCode())
            tgt.setCode(convertResponseType(src.getCode()));
        if (src.hasDetails())
            tgt.setDetails(VersionConvertor_30_40.convertReference(src.getDetails()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.MessageHeader.MessageHeaderResponseComponent convertMessageHeaderResponseComponent(org.hl7.fhir.r4.model.MessageHeader.MessageHeaderResponseComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.MessageHeader.MessageHeaderResponseComponent tgt = new org.hl7.fhir.dstu3.model.MessageHeader.MessageHeaderResponseComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasIdentifier())
            tgt.setIdentifier(src.getIdentifier());
        if (src.hasCode())
            tgt.setCode(convertResponseType(src.getCode()));
        if (src.hasDetails())
            tgt.setDetails(VersionConvertor_30_40.convertReference(src.getDetails()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.MessageHeader.MessageSourceComponent convertMessageSourceComponent(org.hl7.fhir.dstu3.model.MessageHeader.MessageSourceComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.MessageHeader.MessageSourceComponent tgt = new org.hl7.fhir.r4.model.MessageHeader.MessageSourceComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasName())
            tgt.setName(src.getName());
        if (src.hasSoftware())
            tgt.setSoftware(src.getSoftware());
        if (src.hasVersion())
            tgt.setVersion(src.getVersion());
        if (src.hasContact())
            tgt.setContact(VersionConvertor_30_40.convertContactPoint(src.getContact()));
        if (src.hasEndpoint())
            tgt.setEndpoint(src.getEndpoint());
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.MessageHeader.MessageSourceComponent convertMessageSourceComponent(org.hl7.fhir.r4.model.MessageHeader.MessageSourceComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.MessageHeader.MessageSourceComponent tgt = new org.hl7.fhir.dstu3.model.MessageHeader.MessageSourceComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasName())
            tgt.setName(src.getName());
        if (src.hasSoftware())
            tgt.setSoftware(src.getSoftware());
        if (src.hasVersion())
            tgt.setVersion(src.getVersion());
        if (src.hasContact())
            tgt.setContact(VersionConvertor_30_40.convertContactPoint(src.getContact()));
        if (src.hasEndpoint())
            tgt.setEndpoint(src.getEndpoint());
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.MessageHeader.ResponseType convertResponseType(org.hl7.fhir.r4.model.MessageHeader.ResponseType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case OK:
                return org.hl7.fhir.dstu3.model.MessageHeader.ResponseType.OK;
            case TRANSIENTERROR:
                return org.hl7.fhir.dstu3.model.MessageHeader.ResponseType.TRANSIENTERROR;
            case FATALERROR:
                return org.hl7.fhir.dstu3.model.MessageHeader.ResponseType.FATALERROR;
            default:
                return org.hl7.fhir.dstu3.model.MessageHeader.ResponseType.NULL;
        }
    }

    static public org.hl7.fhir.r4.model.MessageHeader.ResponseType convertResponseType(org.hl7.fhir.dstu3.model.MessageHeader.ResponseType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case OK:
                return org.hl7.fhir.r4.model.MessageHeader.ResponseType.OK;
            case TRANSIENTERROR:
                return org.hl7.fhir.r4.model.MessageHeader.ResponseType.TRANSIENTERROR;
            case FATALERROR:
                return org.hl7.fhir.r4.model.MessageHeader.ResponseType.FATALERROR;
            default:
                return org.hl7.fhir.r4.model.MessageHeader.ResponseType.NULL;
        }
    }
}
