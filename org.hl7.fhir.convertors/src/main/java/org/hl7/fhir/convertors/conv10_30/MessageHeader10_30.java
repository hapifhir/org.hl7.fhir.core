package org.hl7.fhir.convertors.conv10_30;

import org.hl7.fhir.convertors.VersionConvertor_10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class MessageHeader10_30 {

    public static org.hl7.fhir.dstu3.model.MessageHeader.MessageDestinationComponent convertMessageDestinationComponent(org.hl7.fhir.dstu2.model.MessageHeader.MessageDestinationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.MessageHeader.MessageDestinationComponent tgt = new org.hl7.fhir.dstu3.model.MessageHeader.MessageDestinationComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        tgt.setName(src.getName());
        tgt.setTarget(VersionConvertor_10_30.convertReference(src.getTarget()));
        tgt.setEndpoint(src.getEndpoint());
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.MessageHeader.MessageDestinationComponent convertMessageDestinationComponent(org.hl7.fhir.dstu3.model.MessageHeader.MessageDestinationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.MessageHeader.MessageDestinationComponent tgt = new org.hl7.fhir.dstu2.model.MessageHeader.MessageDestinationComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        tgt.setName(src.getName());
        tgt.setTarget(VersionConvertor_10_30.convertReference(src.getTarget()));
        tgt.setEndpoint(src.getEndpoint());
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.MessageHeader convertMessageHeader(org.hl7.fhir.dstu3.model.MessageHeader src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.MessageHeader tgt = new org.hl7.fhir.dstu2.model.MessageHeader();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        tgt.setTimestamp(src.getTimestamp());
        tgt.setEvent(VersionConvertor_10_30.convertCoding(src.getEvent()));
        tgt.setResponse(convertMessageHeaderResponseComponent(src.getResponse()));
        tgt.setSource(convertMessageSourceComponent(src.getSource()));
        for (org.hl7.fhir.dstu3.model.MessageHeader.MessageDestinationComponent t : src.getDestination()) tgt.addDestination(convertMessageDestinationComponent(t));
        tgt.setEnterer(VersionConvertor_10_30.convertReference(src.getEnterer()));
        tgt.setAuthor(VersionConvertor_10_30.convertReference(src.getAuthor()));
        tgt.setReceiver(VersionConvertor_10_30.convertReference(src.getReceiver()));
        tgt.setResponsible(VersionConvertor_10_30.convertReference(src.getResponsible()));
        tgt.setReason(VersionConvertor_10_30.convertCodeableConcept(src.getReason()));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getFocus()) tgt.addData(VersionConvertor_10_30.convertReference(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.MessageHeader convertMessageHeader(org.hl7.fhir.dstu2.model.MessageHeader src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.MessageHeader tgt = new org.hl7.fhir.dstu3.model.MessageHeader();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        tgt.setTimestamp(src.getTimestamp());
        tgt.setEvent(VersionConvertor_10_30.convertCoding(src.getEvent()));
        tgt.setResponse(convertMessageHeaderResponseComponent(src.getResponse()));
        tgt.setSource(convertMessageSourceComponent(src.getSource()));
        for (org.hl7.fhir.dstu2.model.MessageHeader.MessageDestinationComponent t : src.getDestination()) tgt.addDestination(convertMessageDestinationComponent(t));
        tgt.setEnterer(VersionConvertor_10_30.convertReference(src.getEnterer()));
        tgt.setAuthor(VersionConvertor_10_30.convertReference(src.getAuthor()));
        tgt.setReceiver(VersionConvertor_10_30.convertReference(src.getReceiver()));
        tgt.setResponsible(VersionConvertor_10_30.convertReference(src.getResponsible()));
        tgt.setReason(VersionConvertor_10_30.convertCodeableConcept(src.getReason()));
        for (org.hl7.fhir.dstu2.model.Reference t : src.getData()) tgt.addFocus(VersionConvertor_10_30.convertReference(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.MessageHeader.MessageHeaderResponseComponent convertMessageHeaderResponseComponent(org.hl7.fhir.dstu3.model.MessageHeader.MessageHeaderResponseComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.MessageHeader.MessageHeaderResponseComponent tgt = new org.hl7.fhir.dstu2.model.MessageHeader.MessageHeaderResponseComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        tgt.setIdentifier(src.getIdentifier());
        tgt.setCode(convertResponseType(src.getCode()));
        tgt.setDetails(VersionConvertor_10_30.convertReference(src.getDetails()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.MessageHeader.MessageHeaderResponseComponent convertMessageHeaderResponseComponent(org.hl7.fhir.dstu2.model.MessageHeader.MessageHeaderResponseComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.MessageHeader.MessageHeaderResponseComponent tgt = new org.hl7.fhir.dstu3.model.MessageHeader.MessageHeaderResponseComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        tgt.setIdentifier(src.getIdentifier());
        tgt.setCode(convertResponseType(src.getCode()));
        tgt.setDetails(VersionConvertor_10_30.convertReference(src.getDetails()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.MessageHeader.MessageSourceComponent convertMessageSourceComponent(org.hl7.fhir.dstu2.model.MessageHeader.MessageSourceComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.MessageHeader.MessageSourceComponent tgt = new org.hl7.fhir.dstu3.model.MessageHeader.MessageSourceComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        tgt.setName(src.getName());
        tgt.setSoftware(src.getSoftware());
        tgt.setVersion(src.getVersion());
        tgt.setContact(VersionConvertor_10_30.convertContactPoint(src.getContact()));
        tgt.setEndpoint(src.getEndpoint());
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.MessageHeader.MessageSourceComponent convertMessageSourceComponent(org.hl7.fhir.dstu3.model.MessageHeader.MessageSourceComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.MessageHeader.MessageSourceComponent tgt = new org.hl7.fhir.dstu2.model.MessageHeader.MessageSourceComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        tgt.setName(src.getName());
        tgt.setSoftware(src.getSoftware());
        tgt.setVersion(src.getVersion());
        tgt.setContact(VersionConvertor_10_30.convertContactPoint(src.getContact()));
        tgt.setEndpoint(src.getEndpoint());
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.MessageHeader.ResponseType convertResponseType(org.hl7.fhir.dstu2.model.MessageHeader.ResponseType src) throws FHIRException {
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

    public static org.hl7.fhir.dstu2.model.MessageHeader.ResponseType convertResponseType(org.hl7.fhir.dstu3.model.MessageHeader.ResponseType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case OK:
                return org.hl7.fhir.dstu2.model.MessageHeader.ResponseType.OK;
            case TRANSIENTERROR:
                return org.hl7.fhir.dstu2.model.MessageHeader.ResponseType.TRANSIENTERROR;
            case FATALERROR:
                return org.hl7.fhir.dstu2.model.MessageHeader.ResponseType.FATALERROR;
            default:
                return org.hl7.fhir.dstu2.model.MessageHeader.ResponseType.NULL;
        }
    }
}
