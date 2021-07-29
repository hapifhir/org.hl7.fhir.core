package org.hl7.fhir.convertors.conv30_40.resources30_40;

import org.hl7.fhir.convertors.conv30_40.VersionConvertor_30_40; import org.hl7.fhir.convertors.context.ConversionContext30_40; import org.hl7.fhir.convertors.factory.VersionConvertorFactory_30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Element30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.CodeableConcept30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Coding30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.ContactPoint30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.Id30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.String30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Reference30_40;
import org.hl7.fhir.exceptions.FHIRException; import org.hl7.fhir.convertors.context.ConversionContext30_40;

public class MessageHeader30_40 {

    public static org.hl7.fhir.dstu3.model.MessageHeader.MessageDestinationComponent convertMessageDestinationComponent(org.hl7.fhir.r4.model.MessageHeader.MessageDestinationComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.MessageHeader.MessageDestinationComponent tgt = new org.hl7.fhir.dstu3.model.MessageHeader.MessageDestinationComponent();
        ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(String30_40.convertString(src.getNameElement()));
        if (src.hasTarget())
            tgt.setTarget(Reference30_40.convertReference(src.getTarget()));
        if (src.hasEndpoint())
            tgt.setEndpoint(src.getEndpoint());
        return tgt;
    }

    public static org.hl7.fhir.r4.model.MessageHeader.MessageDestinationComponent convertMessageDestinationComponent(org.hl7.fhir.dstu3.model.MessageHeader.MessageDestinationComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.MessageHeader.MessageDestinationComponent tgt = new org.hl7.fhir.r4.model.MessageHeader.MessageDestinationComponent();
        ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(String30_40.convertString(src.getNameElement()));
        if (src.hasTarget())
            tgt.setTarget(Reference30_40.convertReference(src.getTarget()));
        if (src.hasEndpoint())
            tgt.setEndpoint(src.getEndpoint());
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.MessageHeader convertMessageHeader(org.hl7.fhir.r4.model.MessageHeader src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.MessageHeader tgt = new org.hl7.fhir.dstu3.model.MessageHeader();
        ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyDomainResource(src, tgt);
        if (src.hasEventCoding())
            tgt.setEvent(Coding30_40.convertCoding(src.getEventCoding()));
        for (org.hl7.fhir.r4.model.MessageHeader.MessageDestinationComponent t : src.getDestination()) tgt.addDestination(convertMessageDestinationComponent(t));
        if (src.hasSender())
            tgt.setSender(Reference30_40.convertReference(src.getSender()));
        if (src.hasEnterer())
            tgt.setEnterer(Reference30_40.convertReference(src.getEnterer()));
        if (src.hasAuthor())
            tgt.setAuthor(Reference30_40.convertReference(src.getAuthor()));
        if (src.hasSource())
            tgt.setSource(convertMessageSourceComponent(src.getSource()));
        if (src.hasResponsible())
            tgt.setResponsible(Reference30_40.convertReference(src.getResponsible()));
        if (src.hasReason())
            tgt.setReason(CodeableConcept30_40.convertCodeableConcept(src.getReason()));
        if (src.hasResponse())
            tgt.setResponse(convertMessageHeaderResponseComponent(src.getResponse()));
        for (org.hl7.fhir.r4.model.Reference t : src.getFocus()) tgt.addFocus(Reference30_40.convertReference(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.MessageHeader convertMessageHeader(org.hl7.fhir.dstu3.model.MessageHeader src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.MessageHeader tgt = new org.hl7.fhir.r4.model.MessageHeader();
        ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyDomainResource(src, tgt);
        if (src.hasEvent())
            tgt.setEvent(Coding30_40.convertCoding(src.getEvent()));
        for (org.hl7.fhir.dstu3.model.MessageHeader.MessageDestinationComponent t : src.getDestination()) tgt.addDestination(convertMessageDestinationComponent(t));
        if (src.hasSender())
            tgt.setSender(Reference30_40.convertReference(src.getSender()));
        if (src.hasEnterer())
            tgt.setEnterer(Reference30_40.convertReference(src.getEnterer()));
        if (src.hasAuthor())
            tgt.setAuthor(Reference30_40.convertReference(src.getAuthor()));
        if (src.hasSource())
            tgt.setSource(convertMessageSourceComponent(src.getSource()));
        if (src.hasResponsible())
            tgt.setResponsible(Reference30_40.convertReference(src.getResponsible()));
        if (src.hasReason())
            tgt.setReason(CodeableConcept30_40.convertCodeableConcept(src.getReason()));
        if (src.hasResponse())
            tgt.setResponse(convertMessageHeaderResponseComponent(src.getResponse()));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getFocus()) tgt.addFocus(Reference30_40.convertReference(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.MessageHeader.MessageHeaderResponseComponent convertMessageHeaderResponseComponent(org.hl7.fhir.dstu3.model.MessageHeader.MessageHeaderResponseComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.MessageHeader.MessageHeaderResponseComponent tgt = new org.hl7.fhir.r4.model.MessageHeader.MessageHeaderResponseComponent();
        ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
        if (src.hasIdentifier())
            tgt.setIdentifierElement(Id30_40.convertId(src.getIdentifierElement()));
        if (src.hasCode())
            tgt.setCodeElement(convertResponseType(src.getCodeElement()));
        if (src.hasDetails())
            tgt.setDetails(Reference30_40.convertReference(src.getDetails()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.MessageHeader.MessageHeaderResponseComponent convertMessageHeaderResponseComponent(org.hl7.fhir.r4.model.MessageHeader.MessageHeaderResponseComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.MessageHeader.MessageHeaderResponseComponent tgt = new org.hl7.fhir.dstu3.model.MessageHeader.MessageHeaderResponseComponent();
        ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
        if (src.hasIdentifier())
            tgt.setIdentifierElement(Id30_40.convertId(src.getIdentifierElement()));
        if (src.hasCode())
            tgt.setCodeElement(convertResponseType(src.getCodeElement()));
        if (src.hasDetails())
            tgt.setDetails(Reference30_40.convertReference(src.getDetails()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.MessageHeader.MessageSourceComponent convertMessageSourceComponent(org.hl7.fhir.dstu3.model.MessageHeader.MessageSourceComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.MessageHeader.MessageSourceComponent tgt = new org.hl7.fhir.r4.model.MessageHeader.MessageSourceComponent();
        ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(String30_40.convertString(src.getNameElement()));
        if (src.hasSoftware())
            tgt.setSoftwareElement(String30_40.convertString(src.getSoftwareElement()));
        if (src.hasVersion())
            tgt.setVersionElement(String30_40.convertString(src.getVersionElement()));
        if (src.hasContact())
            tgt.setContact(ContactPoint30_40.convertContactPoint(src.getContact()));
        if (src.hasEndpoint())
            tgt.setEndpoint(src.getEndpoint());
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.MessageHeader.MessageSourceComponent convertMessageSourceComponent(org.hl7.fhir.r4.model.MessageHeader.MessageSourceComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.MessageHeader.MessageSourceComponent tgt = new org.hl7.fhir.dstu3.model.MessageHeader.MessageSourceComponent();
        ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(String30_40.convertString(src.getNameElement()));
        if (src.hasSoftware())
            tgt.setSoftwareElement(String30_40.convertString(src.getSoftwareElement()));
        if (src.hasVersion())
            tgt.setVersionElement(String30_40.convertString(src.getVersionElement()));
        if (src.hasContact())
            tgt.setContact(ContactPoint30_40.convertContactPoint(src.getContact()));
        if (src.hasEndpoint())
            tgt.setEndpoint(src.getEndpoint());
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.MessageHeader.ResponseType> convertResponseType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MessageHeader.ResponseType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.MessageHeader.ResponseType> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.MessageHeader.ResponseTypeEnumFactory());
        ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
        switch(src.getValue()) {
            case OK:
                tgt.setValue(org.hl7.fhir.dstu3.model.MessageHeader.ResponseType.OK);
                break;
            case TRANSIENTERROR:
                tgt.setValue(org.hl7.fhir.dstu3.model.MessageHeader.ResponseType.TRANSIENTERROR);
                break;
            case FATALERROR:
                tgt.setValue(org.hl7.fhir.dstu3.model.MessageHeader.ResponseType.FATALERROR);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.MessageHeader.ResponseType.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MessageHeader.ResponseType> convertResponseType(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.MessageHeader.ResponseType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.MessageHeader.ResponseType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.MessageHeader.ResponseTypeEnumFactory());
        ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
        switch(src.getValue()) {
            case OK:
                tgt.setValue(org.hl7.fhir.r4.model.MessageHeader.ResponseType.OK);
                break;
            case TRANSIENTERROR:
                tgt.setValue(org.hl7.fhir.r4.model.MessageHeader.ResponseType.TRANSIENTERROR);
                break;
            case FATALERROR:
                tgt.setValue(org.hl7.fhir.r4.model.MessageHeader.ResponseType.FATALERROR);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.MessageHeader.ResponseType.NULL);
                break;
        }
        return tgt;
    }
}