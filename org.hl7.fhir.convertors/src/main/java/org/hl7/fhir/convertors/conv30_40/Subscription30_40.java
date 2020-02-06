package org.hl7.fhir.convertors.conv30_40;

import org.hl7.fhir.convertors.VersionConvertor_30_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Subscription30_40 {

    public static org.hl7.fhir.r4.model.Subscription convertSubscription(org.hl7.fhir.dstu3.model.Subscription src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Subscription tgt = new org.hl7.fhir.r4.model.Subscription();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        if (src.hasStatus())
            tgt.setStatus(convertSubscriptionStatus(src.getStatus()));
        if (src.hasContact()) {
            for (org.hl7.fhir.dstu3.model.ContactPoint t : src.getContact()) tgt.addContact(VersionConvertor_30_40.convertContactPoint(t));
        }
        if (src.hasEnd())
            tgt.setEnd(src.getEnd());
        if (src.hasReason())
            tgt.setReason(src.getReason());
        if (src.hasCriteria())
            tgt.setCriteria(src.getCriteria());
        if (src.hasError())
            tgt.setError(src.getError());
        if (src.hasChannel())
            tgt.setChannel(convertSubscriptionChannelComponent(src.getChannel()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Subscription convertSubscription(org.hl7.fhir.r4.model.Subscription src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Subscription tgt = new org.hl7.fhir.dstu3.model.Subscription();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        if (src.hasStatus())
            tgt.setStatus(convertSubscriptionStatus(src.getStatus()));
        if (src.hasContact()) {
            for (org.hl7.fhir.r4.model.ContactPoint t : src.getContact()) tgt.addContact(VersionConvertor_30_40.convertContactPoint(t));
        }
        if (src.hasEnd())
            tgt.setEnd(src.getEnd());
        if (src.hasReason())
            tgt.setReason(src.getReason());
        if (src.hasCriteria())
            tgt.setCriteria(src.getCriteria());
        if (src.hasError())
            tgt.setError(src.getError());
        if (src.hasChannel())
            tgt.setChannel(convertSubscriptionChannelComponent(src.getChannel()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Subscription.SubscriptionChannelComponent convertSubscriptionChannelComponent(org.hl7.fhir.r4.model.Subscription.SubscriptionChannelComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Subscription.SubscriptionChannelComponent tgt = new org.hl7.fhir.dstu3.model.Subscription.SubscriptionChannelComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasType())
            tgt.setType(convertSubscriptionChannelType(src.getType()));
        if (src.hasEndpoint())
            tgt.setEndpoint(src.getEndpoint());
        if (src.hasPayload())
            tgt.setPayload(src.getPayload());
        if (src.hasHeader()) {
            for (org.hl7.fhir.r4.model.StringType t : src.getHeader()) tgt.addHeader(t.getValue());
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Subscription.SubscriptionChannelComponent convertSubscriptionChannelComponent(org.hl7.fhir.dstu3.model.Subscription.SubscriptionChannelComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Subscription.SubscriptionChannelComponent tgt = new org.hl7.fhir.r4.model.Subscription.SubscriptionChannelComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasType())
            tgt.setType(convertSubscriptionChannelType(src.getType()));
        if (src.hasEndpoint())
            tgt.setEndpoint(src.getEndpoint());
        if (src.hasPayload())
            tgt.setPayload(src.getPayload());
        if (src.hasHeader()) {
            for (org.hl7.fhir.dstu3.model.StringType t : src.getHeader()) tgt.addHeader(t.getValue());
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Subscription.SubscriptionChannelType convertSubscriptionChannelType(org.hl7.fhir.r4.model.Subscription.SubscriptionChannelType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case RESTHOOK:
                return org.hl7.fhir.dstu3.model.Subscription.SubscriptionChannelType.RESTHOOK;
            case WEBSOCKET:
                return org.hl7.fhir.dstu3.model.Subscription.SubscriptionChannelType.WEBSOCKET;
            case EMAIL:
                return org.hl7.fhir.dstu3.model.Subscription.SubscriptionChannelType.EMAIL;
            case SMS:
                return org.hl7.fhir.dstu3.model.Subscription.SubscriptionChannelType.SMS;
            case MESSAGE:
                return org.hl7.fhir.dstu3.model.Subscription.SubscriptionChannelType.MESSAGE;
            default:
                return org.hl7.fhir.dstu3.model.Subscription.SubscriptionChannelType.NULL;
        }
    }

    static public org.hl7.fhir.r4.model.Subscription.SubscriptionChannelType convertSubscriptionChannelType(org.hl7.fhir.dstu3.model.Subscription.SubscriptionChannelType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case RESTHOOK:
                return org.hl7.fhir.r4.model.Subscription.SubscriptionChannelType.RESTHOOK;
            case WEBSOCKET:
                return org.hl7.fhir.r4.model.Subscription.SubscriptionChannelType.WEBSOCKET;
            case EMAIL:
                return org.hl7.fhir.r4.model.Subscription.SubscriptionChannelType.EMAIL;
            case SMS:
                return org.hl7.fhir.r4.model.Subscription.SubscriptionChannelType.SMS;
            case MESSAGE:
                return org.hl7.fhir.r4.model.Subscription.SubscriptionChannelType.MESSAGE;
            default:
                return org.hl7.fhir.r4.model.Subscription.SubscriptionChannelType.NULL;
        }
    }

    static public org.hl7.fhir.r4.model.Subscription.SubscriptionStatus convertSubscriptionStatus(org.hl7.fhir.dstu3.model.Subscription.SubscriptionStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case REQUESTED:
                return org.hl7.fhir.r4.model.Subscription.SubscriptionStatus.REQUESTED;
            case ACTIVE:
                return org.hl7.fhir.r4.model.Subscription.SubscriptionStatus.ACTIVE;
            case ERROR:
                return org.hl7.fhir.r4.model.Subscription.SubscriptionStatus.ERROR;
            case OFF:
                return org.hl7.fhir.r4.model.Subscription.SubscriptionStatus.OFF;
            default:
                return org.hl7.fhir.r4.model.Subscription.SubscriptionStatus.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.Subscription.SubscriptionStatus convertSubscriptionStatus(org.hl7.fhir.r4.model.Subscription.SubscriptionStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case REQUESTED:
                return org.hl7.fhir.dstu3.model.Subscription.SubscriptionStatus.REQUESTED;
            case ACTIVE:
                return org.hl7.fhir.dstu3.model.Subscription.SubscriptionStatus.ACTIVE;
            case ERROR:
                return org.hl7.fhir.dstu3.model.Subscription.SubscriptionStatus.ERROR;
            case OFF:
                return org.hl7.fhir.dstu3.model.Subscription.SubscriptionStatus.OFF;
            default:
                return org.hl7.fhir.dstu3.model.Subscription.SubscriptionStatus.NULL;
        }
    }
}
