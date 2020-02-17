package org.hl7.fhir.convertors.conv10_50;

import org.hl7.fhir.convertors.VersionConvertor_10_50;
import org.hl7.fhir.exceptions.FHIRException;

public class AuditEvent10_50 {

    public static org.hl7.fhir.dstu2.model.AuditEvent convertAuditEvent(org.hl7.fhir.r5.model.AuditEvent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.AuditEvent tgt = new org.hl7.fhir.dstu2.model.AuditEvent();
        VersionConvertor_10_50.copyDomainResource(src, tgt);
        tgt.getEvent().setType(VersionConvertor_10_50.convertCoding(src.getType()));
        for (org.hl7.fhir.r5.model.Coding t : src.getSubtype()) tgt.getEvent().addSubtype(VersionConvertor_10_50.convertCoding(t));
        tgt.getEvent().setAction(convertAuditEventAction(src.getAction()));
        tgt.getEvent().setDateTime(src.getRecorded());
        tgt.getEvent().setOutcome(convertAuditEventOutcome(src.getOutcome()));
        tgt.getEvent().setOutcomeDesc(src.getOutcomeDesc());
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getPurposeOfEvent()) for (org.hl7.fhir.r5.model.Coding cc : t.getCoding()) tgt.getEvent().addPurposeOfEvent(VersionConvertor_10_50.convertCoding(cc));
        for (org.hl7.fhir.r5.model.AuditEvent.AuditEventAgentComponent t : src.getAgent()) tgt.addParticipant(convertAuditEventAgentComponent(t));
        if (src.hasSource())
            tgt.setSource(convertAuditEventSourceComponent(src.getSource()));
        for (org.hl7.fhir.r5.model.AuditEvent.AuditEventEntityComponent t : src.getEntity()) tgt.addObject(convertAuditEventEntityComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.AuditEvent convertAuditEvent(org.hl7.fhir.dstu2.model.AuditEvent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.AuditEvent tgt = new org.hl7.fhir.r5.model.AuditEvent();
        VersionConvertor_10_50.copyDomainResource(src, tgt);
        if (src.hasEvent()) {
            if (src.hasType())
                tgt.setType(VersionConvertor_10_50.convertCoding(src.getEvent().getType()));
            for (org.hl7.fhir.dstu2.model.Coding t : src.getEvent().getSubtype()) tgt.addSubtype(VersionConvertor_10_50.convertCoding(t));
            tgt.setAction(convertAuditEventAction(src.getEvent().getAction()));
            tgt.setRecorded(src.getEvent().getDateTime());
            tgt.setOutcome(convertAuditEventOutcome(src.getEvent().getOutcome()));
            tgt.setOutcomeDesc(src.getEvent().getOutcomeDesc());
            for (org.hl7.fhir.dstu2.model.Coding t : src.getEvent().getPurposeOfEvent()) tgt.addPurposeOfEvent().addCoding(VersionConvertor_10_50.convertCoding(t));
        }
        for (org.hl7.fhir.dstu2.model.AuditEvent.AuditEventParticipantComponent t : src.getParticipant()) tgt.addAgent(convertAuditEventAgentComponent(t));
        if (src.hasSource())
            tgt.setSource(convertAuditEventSourceComponent(src.getSource()));
        for (org.hl7.fhir.dstu2.model.AuditEvent.AuditEventObjectComponent t : src.getObject()) tgt.addEntity(convertAuditEventEntityComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.AuditEvent.AuditEventAction convertAuditEventAction(org.hl7.fhir.dstu2.model.AuditEvent.AuditEventAction src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case C:
                return org.hl7.fhir.r5.model.AuditEvent.AuditEventAction.C;
            case R:
                return org.hl7.fhir.r5.model.AuditEvent.AuditEventAction.R;
            case U:
                return org.hl7.fhir.r5.model.AuditEvent.AuditEventAction.U;
            case D:
                return org.hl7.fhir.r5.model.AuditEvent.AuditEventAction.D;
            case E:
                return org.hl7.fhir.r5.model.AuditEvent.AuditEventAction.E;
            default:
                return org.hl7.fhir.r5.model.AuditEvent.AuditEventAction.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.AuditEvent.AuditEventAction convertAuditEventAction(org.hl7.fhir.r5.model.AuditEvent.AuditEventAction src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case C:
                return org.hl7.fhir.dstu2.model.AuditEvent.AuditEventAction.C;
            case R:
                return org.hl7.fhir.dstu2.model.AuditEvent.AuditEventAction.R;
            case U:
                return org.hl7.fhir.dstu2.model.AuditEvent.AuditEventAction.U;
            case D:
                return org.hl7.fhir.dstu2.model.AuditEvent.AuditEventAction.D;
            case E:
                return org.hl7.fhir.dstu2.model.AuditEvent.AuditEventAction.E;
            default:
                return org.hl7.fhir.dstu2.model.AuditEvent.AuditEventAction.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.AuditEvent.AuditEventParticipantComponent convertAuditEventAgentComponent(org.hl7.fhir.r5.model.AuditEvent.AuditEventAgentComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.AuditEvent.AuditEventParticipantComponent tgt = new org.hl7.fhir.dstu2.model.AuditEvent.AuditEventParticipantComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getRole()) tgt.addRole(VersionConvertor_10_50.convertCodeableConcept(t));
        if (src.hasWho()) {
            if (src.getWho().hasIdentifier())
                tgt.setUserId(VersionConvertor_10_50.convertIdentifier(src.getWho().getIdentifier()));
            if (src.getWho().hasReference() || src.getWho().hasDisplay() || src.getWho().hasExtension() || src.getWho().hasId())
                tgt.setReference(VersionConvertor_10_50.convertReference(src.getWho()));
        }
        if (src.hasAltIdElement())
            tgt.setAltIdElement(VersionConvertor_10_50.convertString(src.getAltIdElement()));
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_10_50.convertString(src.getNameElement()));
        if (src.hasRequestorElement())
            tgt.setRequestorElement(VersionConvertor_10_50.convertBoolean(src.getRequestorElement()));
        if (src.hasLocation())
            tgt.setLocation(VersionConvertor_10_50.convertReference(src.getLocation()));
        for (org.hl7.fhir.r5.model.UriType t : src.getPolicy()) tgt.addPolicy(t.getValue());
        if (src.hasMedia())
            tgt.setMedia(VersionConvertor_10_50.convertCoding(src.getMedia()));
        if (src.hasNetwork())
            tgt.setNetwork(convertAuditEventAgentNetworkComponent(src.getNetwork()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getPurposeOfUse()) for (org.hl7.fhir.r5.model.Coding cc : t.getCoding()) tgt.addPurposeOfUse(VersionConvertor_10_50.convertCoding(cc));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.AuditEvent.AuditEventAgentComponent convertAuditEventAgentComponent(org.hl7.fhir.dstu2.model.AuditEvent.AuditEventParticipantComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.AuditEvent.AuditEventAgentComponent tgt = new org.hl7.fhir.r5.model.AuditEvent.AuditEventAgentComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getRole()) tgt.addRole(VersionConvertor_10_50.convertCodeableConcept(t));
        if (src.hasReference())
            tgt.setWho(VersionConvertor_10_50.convertReference(src.getReference()));
        if (src.hasUserId())
            tgt.getWho().setIdentifier(VersionConvertor_10_50.convertIdentifier(src.getUserId()));
        if (src.hasAltIdElement())
            tgt.setAltIdElement(VersionConvertor_10_50.convertString(src.getAltIdElement()));
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_10_50.convertString(src.getNameElement()));
        if (src.hasRequestorElement())
            tgt.setRequestorElement(VersionConvertor_10_50.convertBoolean(src.getRequestorElement()));
        if (src.hasLocation())
            tgt.setLocation(VersionConvertor_10_50.convertReference(src.getLocation()));
        for (org.hl7.fhir.dstu2.model.UriType t : src.getPolicy()) tgt.addPolicy(t.getValue());
        if (src.hasMedia())
            tgt.setMedia(VersionConvertor_10_50.convertCoding(src.getMedia()));
        if (src.hasNetwork())
            tgt.setNetwork(convertAuditEventAgentNetworkComponent(src.getNetwork()));
        for (org.hl7.fhir.dstu2.model.Coding t : src.getPurposeOfUse()) tgt.addPurposeOfUse().addCoding(VersionConvertor_10_50.convertCoding(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.AuditEvent.AuditEventAgentNetworkComponent convertAuditEventAgentNetworkComponent(org.hl7.fhir.dstu2.model.AuditEvent.AuditEventParticipantNetworkComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.AuditEvent.AuditEventAgentNetworkComponent tgt = new org.hl7.fhir.r5.model.AuditEvent.AuditEventAgentNetworkComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        if (src.hasAddressElement())
            tgt.setAddressElement(VersionConvertor_10_50.convertString(src.getAddressElement()));
        if (src.hasType())
            tgt.setType(convertAuditEventParticipantNetworkType(src.getType()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.AuditEvent.AuditEventParticipantNetworkComponent convertAuditEventAgentNetworkComponent(org.hl7.fhir.r5.model.AuditEvent.AuditEventAgentNetworkComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.AuditEvent.AuditEventParticipantNetworkComponent tgt = new org.hl7.fhir.dstu2.model.AuditEvent.AuditEventParticipantNetworkComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        if (src.hasAddressElement())
            tgt.setAddressElement(VersionConvertor_10_50.convertString(src.getAddressElement()));
        if (src.hasType())
            tgt.setType(convertAuditEventParticipantNetworkType(src.getType()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.AuditEvent.AuditEventEntityComponent convertAuditEventEntityComponent(org.hl7.fhir.dstu2.model.AuditEvent.AuditEventObjectComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.AuditEvent.AuditEventEntityComponent tgt = new org.hl7.fhir.r5.model.AuditEvent.AuditEventEntityComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        if (src.hasIdentifier())
            tgt.getWhat().setIdentifier(VersionConvertor_10_50.convertIdentifier(src.getIdentifier()));
        if (src.hasReference())
            tgt.setWhat(VersionConvertor_10_50.convertReference(src.getReference()));
        if (src.hasType())
            tgt.setType(VersionConvertor_10_50.convertCoding(src.getType()));
        if (src.hasRole())
            tgt.setRole(VersionConvertor_10_50.convertCoding(src.getRole()));
        if (src.hasLifecycle())
            tgt.setLifecycle(VersionConvertor_10_50.convertCoding(src.getLifecycle()));
        for (org.hl7.fhir.dstu2.model.Coding t : src.getSecurityLabel()) tgt.addSecurityLabel(VersionConvertor_10_50.convertCoding(t));
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_10_50.convertString(src.getNameElement()));
        if (src.hasQueryElement())
            tgt.setQueryElement(VersionConvertor_10_50.convertBase64Binary(src.getQueryElement()));
        for (org.hl7.fhir.dstu2.model.AuditEvent.AuditEventObjectDetailComponent t : src.getDetail()) tgt.addDetail(convertAuditEventEntityDetailComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.AuditEvent.AuditEventObjectComponent convertAuditEventEntityComponent(org.hl7.fhir.r5.model.AuditEvent.AuditEventEntityComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.AuditEvent.AuditEventObjectComponent tgt = new org.hl7.fhir.dstu2.model.AuditEvent.AuditEventObjectComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        if (src.hasWhat()) {
            if (src.getWhat().hasIdentifier())
                tgt.setIdentifier(VersionConvertor_10_50.convertIdentifier(src.getWhat().getIdentifier()));
            if (src.getWhat().hasReference() || src.getWhat().hasDisplay() || src.getWhat().hasExtension() || src.getWhat().hasId())
                tgt.setReference(VersionConvertor_10_50.convertReference(src.getWhat()));
        }
        if (src.hasType())
            tgt.setType(VersionConvertor_10_50.convertCoding(src.getType()));
        if (src.hasRole())
            tgt.setRole(VersionConvertor_10_50.convertCoding(src.getRole()));
        if (src.hasLifecycle())
            tgt.setLifecycle(VersionConvertor_10_50.convertCoding(src.getLifecycle()));
        for (org.hl7.fhir.r5.model.Coding t : src.getSecurityLabel()) tgt.addSecurityLabel(VersionConvertor_10_50.convertCoding(t));
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_10_50.convertString(src.getNameElement()));
        if (src.hasQueryElement())
            tgt.setQueryElement(VersionConvertor_10_50.convertBase64Binary(src.getQueryElement()));
        for (org.hl7.fhir.r5.model.AuditEvent.AuditEventEntityDetailComponent t : src.getDetail()) tgt.addDetail(convertAuditEventEntityDetailComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.AuditEvent.AuditEventEntityDetailComponent convertAuditEventEntityDetailComponent(org.hl7.fhir.dstu2.model.AuditEvent.AuditEventObjectDetailComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.AuditEvent.AuditEventEntityDetailComponent tgt = new org.hl7.fhir.r5.model.AuditEvent.AuditEventEntityDetailComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        if (src.hasTypeElement())
            tgt.setTypeElement(VersionConvertor_10_50.convertString(src.getTypeElement()));
        if (src.hasValue())
            tgt.setValue(new org.hl7.fhir.r5.model.Base64BinaryType(src.getValue()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.AuditEvent.AuditEventObjectDetailComponent convertAuditEventEntityDetailComponent(org.hl7.fhir.r5.model.AuditEvent.AuditEventEntityDetailComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.AuditEvent.AuditEventObjectDetailComponent tgt = new org.hl7.fhir.dstu2.model.AuditEvent.AuditEventObjectDetailComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        if (src.hasTypeElement())
            tgt.setTypeElement(VersionConvertor_10_50.convertString(src.getTypeElement()));
        if (src.hasValueStringType())
            tgt.setValue(src.getValueStringType().getValue().getBytes());
        else if (src.hasValueBase64BinaryType())
            tgt.setValue(src.getValueBase64BinaryType().getValue());
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.AuditEvent.AuditEventOutcome convertAuditEventOutcome(org.hl7.fhir.r5.model.AuditEvent.AuditEventOutcome src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case _0:
                return org.hl7.fhir.dstu2.model.AuditEvent.AuditEventOutcome._0;
            case _4:
                return org.hl7.fhir.dstu2.model.AuditEvent.AuditEventOutcome._4;
            case _8:
                return org.hl7.fhir.dstu2.model.AuditEvent.AuditEventOutcome._8;
            case _12:
                return org.hl7.fhir.dstu2.model.AuditEvent.AuditEventOutcome._12;
            default:
                return org.hl7.fhir.dstu2.model.AuditEvent.AuditEventOutcome.NULL;
        }
    }

    public static org.hl7.fhir.r5.model.AuditEvent.AuditEventOutcome convertAuditEventOutcome(org.hl7.fhir.dstu2.model.AuditEvent.AuditEventOutcome src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case _0:
                return org.hl7.fhir.r5.model.AuditEvent.AuditEventOutcome._0;
            case _4:
                return org.hl7.fhir.r5.model.AuditEvent.AuditEventOutcome._4;
            case _8:
                return org.hl7.fhir.r5.model.AuditEvent.AuditEventOutcome._8;
            case _12:
                return org.hl7.fhir.r5.model.AuditEvent.AuditEventOutcome._12;
            default:
                return org.hl7.fhir.r5.model.AuditEvent.AuditEventOutcome.NULL;
        }
    }

    public static org.hl7.fhir.r5.model.AuditEvent.AuditEventAgentNetworkType convertAuditEventParticipantNetworkType(org.hl7.fhir.dstu2.model.AuditEvent.AuditEventParticipantNetworkType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case _1:
                return org.hl7.fhir.r5.model.AuditEvent.AuditEventAgentNetworkType._1;
            case _2:
                return org.hl7.fhir.r5.model.AuditEvent.AuditEventAgentNetworkType._2;
            case _3:
                return org.hl7.fhir.r5.model.AuditEvent.AuditEventAgentNetworkType._3;
            case _4:
                return org.hl7.fhir.r5.model.AuditEvent.AuditEventAgentNetworkType._4;
            case _5:
                return org.hl7.fhir.r5.model.AuditEvent.AuditEventAgentNetworkType._5;
            default:
                return org.hl7.fhir.r5.model.AuditEvent.AuditEventAgentNetworkType.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.AuditEvent.AuditEventParticipantNetworkType convertAuditEventParticipantNetworkType(org.hl7.fhir.r5.model.AuditEvent.AuditEventAgentNetworkType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case _1:
                return org.hl7.fhir.dstu2.model.AuditEvent.AuditEventParticipantNetworkType._1;
            case _2:
                return org.hl7.fhir.dstu2.model.AuditEvent.AuditEventParticipantNetworkType._2;
            case _3:
                return org.hl7.fhir.dstu2.model.AuditEvent.AuditEventParticipantNetworkType._3;
            case _4:
                return org.hl7.fhir.dstu2.model.AuditEvent.AuditEventParticipantNetworkType._4;
            case _5:
                return org.hl7.fhir.dstu2.model.AuditEvent.AuditEventParticipantNetworkType._5;
            default:
                return org.hl7.fhir.dstu2.model.AuditEvent.AuditEventParticipantNetworkType.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.AuditEvent.AuditEventSourceComponent convertAuditEventSourceComponent(org.hl7.fhir.r5.model.AuditEvent.AuditEventSourceComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.AuditEvent.AuditEventSourceComponent tgt = new org.hl7.fhir.dstu2.model.AuditEvent.AuditEventSourceComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        if (src.hasSiteElement())
            tgt.setSiteElement(VersionConvertor_10_50.convertString(src.getSiteElement()));
        if (src.hasObserver())
            tgt.setIdentifier(VersionConvertor_10_50.convertIdentifier(src.getObserver().getIdentifier()));
        for (org.hl7.fhir.r5.model.Coding t : src.getType()) tgt.addType(VersionConvertor_10_50.convertCoding(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.AuditEvent.AuditEventSourceComponent convertAuditEventSourceComponent(org.hl7.fhir.dstu2.model.AuditEvent.AuditEventSourceComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.AuditEvent.AuditEventSourceComponent tgt = new org.hl7.fhir.r5.model.AuditEvent.AuditEventSourceComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        if (src.hasSiteElement())
            tgt.setSiteElement(VersionConvertor_10_50.convertString(src.getSiteElement()));
        if (src.hasIdentifier())
            tgt.getObserver().setIdentifier(VersionConvertor_10_50.convertIdentifier(src.getIdentifier()));
        for (org.hl7.fhir.dstu2.model.Coding t : src.getType()) tgt.addType(VersionConvertor_10_50.convertCoding(t));
        return tgt;
    }
}
