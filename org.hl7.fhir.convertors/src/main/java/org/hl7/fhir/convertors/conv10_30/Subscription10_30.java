package org.hl7.fhir.convertors.conv10_30;

import org.hl7.fhir.convertors.VersionConvertor_10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class Subscription10_30 {

    public static org.hl7.fhir.dstu3.model.Subscription convertSubscription(org.hl7.fhir.dstu2.model.Subscription src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Subscription tgt = new org.hl7.fhir.dstu3.model.Subscription();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        if (src.hasCriteriaElement())
            tgt.setCriteriaElement(VersionConvertor_10_30.convertString(src.getCriteriaElement()));
        for (org.hl7.fhir.dstu2.model.ContactPoint t : src.getContact()) tgt.addContact(VersionConvertor_10_30.convertContactPoint(t));
        if (src.hasReasonElement())
            tgt.setReasonElement(VersionConvertor_10_30.convertString(src.getReasonElement()));
        if (src.hasStatus())
            tgt.setStatusElement(convertSubscriptionStatus(src.getStatusElement()));
        if (src.hasErrorElement())
            tgt.setErrorElement(VersionConvertor_10_30.convertString(src.getErrorElement()));
        if (src.hasChannel())
            tgt.setChannel(convertSubscriptionChannelComponent(src.getChannel()));
        if (src.hasEndElement())
            tgt.setEndElement(VersionConvertor_10_30.convertInstant(src.getEndElement()));
        for (org.hl7.fhir.dstu2.model.Coding t : src.getTag()) tgt.addTag(VersionConvertor_10_30.convertCoding(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Subscription convertSubscription(org.hl7.fhir.dstu3.model.Subscription src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Subscription tgt = new org.hl7.fhir.dstu2.model.Subscription();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        if (src.hasCriteriaElement())
            tgt.setCriteriaElement(VersionConvertor_10_30.convertString(src.getCriteriaElement()));
        for (org.hl7.fhir.dstu3.model.ContactPoint t : src.getContact()) tgt.addContact(VersionConvertor_10_30.convertContactPoint(t));
        if (src.hasReasonElement())
            tgt.setReasonElement(VersionConvertor_10_30.convertString(src.getReasonElement()));
        if (src.hasStatus())
            tgt.setStatusElement(convertSubscriptionStatus(src.getStatusElement()));
        if (src.hasErrorElement())
            tgt.setErrorElement(VersionConvertor_10_30.convertString(src.getErrorElement()));
        if (src.hasChannel())
            tgt.setChannel(convertSubscriptionChannelComponent(src.getChannel()));
        if (src.hasEndElement())
            tgt.setEndElement(VersionConvertor_10_30.convertInstant(src.getEndElement()));
        for (org.hl7.fhir.dstu3.model.Coding t : src.getTag()) tgt.addTag(VersionConvertor_10_30.convertCoding(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Subscription.SubscriptionChannelComponent convertSubscriptionChannelComponent(org.hl7.fhir.dstu3.model.Subscription.SubscriptionChannelComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Subscription.SubscriptionChannelComponent tgt = new org.hl7.fhir.dstu2.model.Subscription.SubscriptionChannelComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasType())
            tgt.setTypeElement(convertSubscriptionChannelType(src.getTypeElement()));
        if (src.hasEndpointElement())
            tgt.setEndpointElement(VersionConvertor_10_30.convertUri(src.getEndpointElement()));
        if (src.hasPayloadElement())
            tgt.setPayloadElement(VersionConvertor_10_30.convertString(src.getPayloadElement()));
        if (src.hasHeader())
            tgt.setHeaderElement(VersionConvertor_10_30.convertString(src.getHeader().get(0)));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Subscription.SubscriptionChannelComponent convertSubscriptionChannelComponent(org.hl7.fhir.dstu2.model.Subscription.SubscriptionChannelComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Subscription.SubscriptionChannelComponent tgt = new org.hl7.fhir.dstu3.model.Subscription.SubscriptionChannelComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasType())
            tgt.setTypeElement(convertSubscriptionChannelType(src.getTypeElement()));
        if (src.hasEndpointElement())
            tgt.setEndpointElement(VersionConvertor_10_30.convertUri(src.getEndpointElement()));
        if (src.hasPayloadElement())
            tgt.setPayloadElement(VersionConvertor_10_30.convertString(src.getPayloadElement()));
        tgt.addHeader(src.getHeader());
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Subscription.SubscriptionChannelType> convertSubscriptionChannelType(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Subscription.SubscriptionChannelType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Subscription.SubscriptionChannelType> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Subscription.SubscriptionChannelTypeEnumFactory());
        VersionConvertor_10_30.copyElement(src, tgt);
        switch(src.getValue()) {
            case RESTHOOK:
                tgt.setValue(org.hl7.fhir.dstu3.model.Subscription.SubscriptionChannelType.RESTHOOK);
                break;
            case WEBSOCKET:
                tgt.setValue(org.hl7.fhir.dstu3.model.Subscription.SubscriptionChannelType.WEBSOCKET);
                break;
            case EMAIL:
                tgt.setValue(org.hl7.fhir.dstu3.model.Subscription.SubscriptionChannelType.EMAIL);
                break;
            case SMS:
                tgt.setValue(org.hl7.fhir.dstu3.model.Subscription.SubscriptionChannelType.SMS);
                break;
            case MESSAGE:
                tgt.setValue(org.hl7.fhir.dstu3.model.Subscription.SubscriptionChannelType.MESSAGE);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.Subscription.SubscriptionChannelType.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Subscription.SubscriptionChannelType> convertSubscriptionChannelType(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Subscription.SubscriptionChannelType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Subscription.SubscriptionChannelType> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Subscription.SubscriptionChannelTypeEnumFactory());
        VersionConvertor_10_30.copyElement(src, tgt);
        switch(src.getValue()) {
            case RESTHOOK:
                tgt.setValue(org.hl7.fhir.dstu2.model.Subscription.SubscriptionChannelType.RESTHOOK);
                break;
            case WEBSOCKET:
                tgt.setValue(org.hl7.fhir.dstu2.model.Subscription.SubscriptionChannelType.WEBSOCKET);
                break;
            case EMAIL:
                tgt.setValue(org.hl7.fhir.dstu2.model.Subscription.SubscriptionChannelType.EMAIL);
                break;
            case SMS:
                tgt.setValue(org.hl7.fhir.dstu2.model.Subscription.SubscriptionChannelType.SMS);
                break;
            case MESSAGE:
                tgt.setValue(org.hl7.fhir.dstu2.model.Subscription.SubscriptionChannelType.MESSAGE);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2.model.Subscription.SubscriptionChannelType.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Subscription.SubscriptionStatus> convertSubscriptionStatus(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Subscription.SubscriptionStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Subscription.SubscriptionStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Subscription.SubscriptionStatusEnumFactory());
        VersionConvertor_10_30.copyElement(src, tgt);
        switch(src.getValue()) {
            case REQUESTED:
                tgt.setValue(org.hl7.fhir.dstu3.model.Subscription.SubscriptionStatus.REQUESTED);
                break;
            case ACTIVE:
                tgt.setValue(org.hl7.fhir.dstu3.model.Subscription.SubscriptionStatus.ACTIVE);
                break;
            case ERROR:
                tgt.setValue(org.hl7.fhir.dstu3.model.Subscription.SubscriptionStatus.ERROR);
                break;
            case OFF:
                tgt.setValue(org.hl7.fhir.dstu3.model.Subscription.SubscriptionStatus.OFF);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.Subscription.SubscriptionStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Subscription.SubscriptionStatus> convertSubscriptionStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Subscription.SubscriptionStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Subscription.SubscriptionStatus> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Subscription.SubscriptionStatusEnumFactory());
        VersionConvertor_10_30.copyElement(src, tgt);
        switch(src.getValue()) {
            case REQUESTED:
                tgt.setValue(org.hl7.fhir.dstu2.model.Subscription.SubscriptionStatus.REQUESTED);
                break;
            case ACTIVE:
                tgt.setValue(org.hl7.fhir.dstu2.model.Subscription.SubscriptionStatus.ACTIVE);
                break;
            case ERROR:
                tgt.setValue(org.hl7.fhir.dstu2.model.Subscription.SubscriptionStatus.ERROR);
                break;
            case OFF:
                tgt.setValue(org.hl7.fhir.dstu2.model.Subscription.SubscriptionStatus.OFF);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2.model.Subscription.SubscriptionStatus.NULL);
                break;
        }
        return tgt;
    }
}