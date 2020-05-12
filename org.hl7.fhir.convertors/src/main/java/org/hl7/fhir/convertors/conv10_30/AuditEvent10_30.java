package org.hl7.fhir.convertors.conv10_30;

import org.hl7.fhir.convertors.VersionConvertor_10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class AuditEvent10_30 {

    public static org.hl7.fhir.dstu2.model.AuditEvent convertAuditEvent(org.hl7.fhir.dstu3.model.AuditEvent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.AuditEvent tgt = new org.hl7.fhir.dstu2.model.AuditEvent();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        tgt.getEvent().setType(VersionConvertor_10_30.convertCoding(src.getType()));
        for (org.hl7.fhir.dstu3.model.Coding t : src.getSubtype()) tgt.getEvent().addSubtype(VersionConvertor_10_30.convertCoding(t));
        tgt.getEvent().setActionElement(convertAuditEventAction(src.getActionElement()));
        tgt.getEvent().setDateTime(src.getRecorded());
        tgt.getEvent().setOutcomeElement(convertAuditEventOutcome(src.getOutcomeElement()));
        tgt.getEvent().setOutcomeDesc(src.getOutcomeDesc());
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getPurposeOfEvent()) for (org.hl7.fhir.dstu3.model.Coding cc : t.getCoding()) tgt.getEvent().addPurposeOfEvent(VersionConvertor_10_30.convertCoding(cc));
        for (org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAgentComponent t : src.getAgent()) tgt.addParticipant(convertAuditEventAgentComponent(t));
        if (src.hasSource())
            tgt.setSource(convertAuditEventSourceComponent(src.getSource()));
        for (org.hl7.fhir.dstu3.model.AuditEvent.AuditEventEntityComponent t : src.getEntity()) tgt.addObject(convertAuditEventEntityComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.AuditEvent convertAuditEvent(org.hl7.fhir.dstu2.model.AuditEvent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.AuditEvent tgt = new org.hl7.fhir.dstu3.model.AuditEvent();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        if (src.hasEvent()) {
            if (src.hasType())
                tgt.setType(VersionConvertor_10_30.convertCoding(src.getEvent().getType()));
            for (org.hl7.fhir.dstu2.model.Coding t : src.getEvent().getSubtype()) tgt.addSubtype(VersionConvertor_10_30.convertCoding(t));
            tgt.setActionElement(convertAuditEventAction(src.getEvent().getActionElement()));
            tgt.setRecorded(src.getEvent().getDateTime());
            tgt.setOutcomeElement(convertAuditEventOutcome(src.getEvent().getOutcomeElement()));
            tgt.setOutcomeDesc(src.getEvent().getOutcomeDesc());
            for (org.hl7.fhir.dstu2.model.Coding t : src.getEvent().getPurposeOfEvent()) tgt.addPurposeOfEvent().addCoding(VersionConvertor_10_30.convertCoding(t));
        }
        for (org.hl7.fhir.dstu2.model.AuditEvent.AuditEventParticipantComponent t : src.getParticipant()) tgt.addAgent(convertAuditEventAgentComponent(t));
        if (src.hasSource())
            tgt.setSource(convertAuditEventSourceComponent(src.getSource()));
        for (org.hl7.fhir.dstu2.model.AuditEvent.AuditEventObjectComponent t : src.getObject()) tgt.addEntity(convertAuditEventEntityComponent(t));
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAction> convertAuditEventAction(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.AuditEvent.AuditEventAction> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAction> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.AuditEvent.AuditEventActionEnumFactory());
        VersionConvertor_10_30.copyElement(src, tgt);
        switch(src.getValue()) {
            case C:
                tgt.setValue(org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAction.C);
                break;
            case R:
                tgt.setValue(org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAction.R);
                break;
            case U:
                tgt.setValue(org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAction.U);
                break;
            case D:
                tgt.setValue(org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAction.D);
                break;
            case E:
                tgt.setValue(org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAction.E);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAction.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.AuditEvent.AuditEventAction> convertAuditEventAction(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAction> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.AuditEvent.AuditEventAction> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.AuditEvent.AuditEventActionEnumFactory());
        VersionConvertor_10_30.copyElement(src, tgt);
        switch(src.getValue()) {
            case C:
                tgt.setValue(org.hl7.fhir.dstu2.model.AuditEvent.AuditEventAction.C);
                break;
            case R:
                tgt.setValue(org.hl7.fhir.dstu2.model.AuditEvent.AuditEventAction.R);
                break;
            case U:
                tgt.setValue(org.hl7.fhir.dstu2.model.AuditEvent.AuditEventAction.U);
                break;
            case D:
                tgt.setValue(org.hl7.fhir.dstu2.model.AuditEvent.AuditEventAction.D);
                break;
            case E:
                tgt.setValue(org.hl7.fhir.dstu2.model.AuditEvent.AuditEventAction.E);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2.model.AuditEvent.AuditEventAction.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAgentComponent convertAuditEventAgentComponent(org.hl7.fhir.dstu2.model.AuditEvent.AuditEventParticipantComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAgentComponent tgt = new org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAgentComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getRole()) tgt.addRole(VersionConvertor_10_30.convertCodeableConcept(t));
        if (src.hasReference())
            tgt.setReference(VersionConvertor_10_30.convertReference(src.getReference()));
        if (src.hasUserId())
            tgt.setUserId(VersionConvertor_10_30.convertIdentifier(src.getUserId()));
        if (src.hasAltIdElement())
            tgt.setAltIdElement(VersionConvertor_10_30.convertString(src.getAltIdElement()));
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_10_30.convertString(src.getNameElement()));
        if (src.hasRequestorElement())
            tgt.setRequestorElement(VersionConvertor_10_30.convertBoolean(src.getRequestorElement()));
        if (src.hasLocation())
            tgt.setLocation(VersionConvertor_10_30.convertReference(src.getLocation()));
        for (org.hl7.fhir.dstu2.model.UriType t : src.getPolicy()) tgt.addPolicy(t.getValue());
        if (src.hasMedia())
            tgt.setMedia(VersionConvertor_10_30.convertCoding(src.getMedia()));
        if (src.hasNetwork())
            tgt.setNetwork(convertAuditEventAgentNetworkComponent(src.getNetwork()));
        for (org.hl7.fhir.dstu2.model.Coding t : src.getPurposeOfUse()) tgt.addPurposeOfUse().addCoding(VersionConvertor_10_30.convertCoding(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.AuditEvent.AuditEventParticipantComponent convertAuditEventAgentComponent(org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAgentComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.AuditEvent.AuditEventParticipantComponent tgt = new org.hl7.fhir.dstu2.model.AuditEvent.AuditEventParticipantComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getRole()) tgt.addRole(VersionConvertor_10_30.convertCodeableConcept(t));
        if (src.hasReference())
            tgt.setReference(VersionConvertor_10_30.convertReference(src.getReference()));
        if (src.hasUserId())
            tgt.setUserId(VersionConvertor_10_30.convertIdentifier(src.getUserId()));
        if (src.hasAltIdElement())
            tgt.setAltIdElement(VersionConvertor_10_30.convertString(src.getAltIdElement()));
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_10_30.convertString(src.getNameElement()));
        if (src.hasRequestorElement())
            tgt.setRequestorElement(VersionConvertor_10_30.convertBoolean(src.getRequestorElement()));
        if (src.hasLocation())
            tgt.setLocation(VersionConvertor_10_30.convertReference(src.getLocation()));
        for (org.hl7.fhir.dstu3.model.UriType t : src.getPolicy()) tgt.addPolicy(t.getValue());
        if (src.hasMedia())
            tgt.setMedia(VersionConvertor_10_30.convertCoding(src.getMedia()));
        if (src.hasNetwork())
            tgt.setNetwork(convertAuditEventAgentNetworkComponent(src.getNetwork()));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getPurposeOfUse()) for (org.hl7.fhir.dstu3.model.Coding cc : t.getCoding()) tgt.addPurposeOfUse(VersionConvertor_10_30.convertCoding(cc));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.AuditEvent.AuditEventParticipantNetworkComponent convertAuditEventAgentNetworkComponent(org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAgentNetworkComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.AuditEvent.AuditEventParticipantNetworkComponent tgt = new org.hl7.fhir.dstu2.model.AuditEvent.AuditEventParticipantNetworkComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasAddressElement())
            tgt.setAddressElement(VersionConvertor_10_30.convertString(src.getAddressElement()));
        if (src.hasType())
            tgt.setTypeElement(convertAuditEventParticipantNetworkType(src.getTypeElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAgentNetworkComponent convertAuditEventAgentNetworkComponent(org.hl7.fhir.dstu2.model.AuditEvent.AuditEventParticipantNetworkComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAgentNetworkComponent tgt = new org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAgentNetworkComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasAddressElement())
            tgt.setAddressElement(VersionConvertor_10_30.convertString(src.getAddressElement()));
        if (src.hasType())
            tgt.setTypeElement(convertAuditEventParticipantNetworkType(src.getTypeElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.AuditEvent.AuditEventEntityComponent convertAuditEventEntityComponent(org.hl7.fhir.dstu2.model.AuditEvent.AuditEventObjectComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.AuditEvent.AuditEventEntityComponent tgt = new org.hl7.fhir.dstu3.model.AuditEvent.AuditEventEntityComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasIdentifier())
            tgt.setIdentifier(VersionConvertor_10_30.convertIdentifier(src.getIdentifier()));
        if (src.hasReference())
            tgt.setReference(VersionConvertor_10_30.convertReference(src.getReference()));
        if (src.hasType())
            tgt.setType(VersionConvertor_10_30.convertCoding(src.getType()));
        if (src.hasRole())
            tgt.setRole(VersionConvertor_10_30.convertCoding(src.getRole()));
        if (src.hasLifecycle())
            tgt.setLifecycle(VersionConvertor_10_30.convertCoding(src.getLifecycle()));
        for (org.hl7.fhir.dstu2.model.Coding t : src.getSecurityLabel()) tgt.addSecurityLabel(VersionConvertor_10_30.convertCoding(t));
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_10_30.convertString(src.getNameElement()));
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement(VersionConvertor_10_30.convertString(src.getDescriptionElement()));
        if (src.hasQueryElement())
            tgt.setQueryElement(VersionConvertor_10_30.convertBase64Binary(src.getQueryElement()));
        for (org.hl7.fhir.dstu2.model.AuditEvent.AuditEventObjectDetailComponent t : src.getDetail()) tgt.addDetail(convertAuditEventEntityDetailComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.AuditEvent.AuditEventObjectComponent convertAuditEventEntityComponent(org.hl7.fhir.dstu3.model.AuditEvent.AuditEventEntityComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.AuditEvent.AuditEventObjectComponent tgt = new org.hl7.fhir.dstu2.model.AuditEvent.AuditEventObjectComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasIdentifier())
            tgt.setIdentifier(VersionConvertor_10_30.convertIdentifier(src.getIdentifier()));
        if (src.hasReference())
            tgt.setReference(VersionConvertor_10_30.convertReference(src.getReference()));
        if (src.hasType())
            tgt.setType(VersionConvertor_10_30.convertCoding(src.getType()));
        if (src.hasRole())
            tgt.setRole(VersionConvertor_10_30.convertCoding(src.getRole()));
        if (src.hasLifecycle())
            tgt.setLifecycle(VersionConvertor_10_30.convertCoding(src.getLifecycle()));
        for (org.hl7.fhir.dstu3.model.Coding t : src.getSecurityLabel()) tgt.addSecurityLabel(VersionConvertor_10_30.convertCoding(t));
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_10_30.convertString(src.getNameElement()));
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement(VersionConvertor_10_30.convertString(src.getDescriptionElement()));
        if (src.hasQueryElement())
            tgt.setQueryElement(VersionConvertor_10_30.convertBase64Binary(src.getQueryElement()));
        for (org.hl7.fhir.dstu3.model.AuditEvent.AuditEventEntityDetailComponent t : src.getDetail()) tgt.addDetail(convertAuditEventEntityDetailComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.AuditEvent.AuditEventObjectDetailComponent convertAuditEventEntityDetailComponent(org.hl7.fhir.dstu3.model.AuditEvent.AuditEventEntityDetailComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.AuditEvent.AuditEventObjectDetailComponent tgt = new org.hl7.fhir.dstu2.model.AuditEvent.AuditEventObjectDetailComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasTypeElement())
            tgt.setTypeElement(VersionConvertor_10_30.convertString(src.getTypeElement()));
        if (src.hasValueElement())
            tgt.setValueElement(VersionConvertor_10_30.convertBase64Binary(src.getValueElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.AuditEvent.AuditEventEntityDetailComponent convertAuditEventEntityDetailComponent(org.hl7.fhir.dstu2.model.AuditEvent.AuditEventObjectDetailComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.AuditEvent.AuditEventEntityDetailComponent tgt = new org.hl7.fhir.dstu3.model.AuditEvent.AuditEventEntityDetailComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasTypeElement())
            tgt.setTypeElement(VersionConvertor_10_30.convertString(src.getTypeElement()));
        if (src.hasValueElement())
            tgt.setValueElement(VersionConvertor_10_30.convertBase64Binary(src.getValueElement()));
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.AuditEvent.AuditEventOutcome> convertAuditEventOutcome(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.AuditEvent.AuditEventOutcome> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.AuditEvent.AuditEventOutcome> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.AuditEvent.AuditEventOutcomeEnumFactory());
        VersionConvertor_10_30.copyElement(src, tgt);
        switch(src.getValue()) {
            case _0:
                tgt.setValue(org.hl7.fhir.dstu3.model.AuditEvent.AuditEventOutcome._0);
                break;
            case _4:
                tgt.setValue(org.hl7.fhir.dstu3.model.AuditEvent.AuditEventOutcome._4);
                break;
            case _8:
                tgt.setValue(org.hl7.fhir.dstu3.model.AuditEvent.AuditEventOutcome._8);
                break;
            case _12:
                tgt.setValue(org.hl7.fhir.dstu3.model.AuditEvent.AuditEventOutcome._12);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.AuditEvent.AuditEventOutcome.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.AuditEvent.AuditEventOutcome> convertAuditEventOutcome(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.AuditEvent.AuditEventOutcome> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.AuditEvent.AuditEventOutcome> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.AuditEvent.AuditEventOutcomeEnumFactory());
        VersionConvertor_10_30.copyElement(src, tgt);
        switch(src.getValue()) {
            case _0:
                tgt.setValue(org.hl7.fhir.dstu2.model.AuditEvent.AuditEventOutcome._0);
                break;
            case _4:
                tgt.setValue(org.hl7.fhir.dstu2.model.AuditEvent.AuditEventOutcome._4);
                break;
            case _8:
                tgt.setValue(org.hl7.fhir.dstu2.model.AuditEvent.AuditEventOutcome._8);
                break;
            case _12:
                tgt.setValue(org.hl7.fhir.dstu2.model.AuditEvent.AuditEventOutcome._12);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2.model.AuditEvent.AuditEventOutcome.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.AuditEvent.AuditEventParticipantNetworkType> convertAuditEventParticipantNetworkType(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAgentNetworkType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.AuditEvent.AuditEventParticipantNetworkType> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.AuditEvent.AuditEventParticipantNetworkTypeEnumFactory());
        VersionConvertor_10_30.copyElement(src, tgt);
        switch(src.getValue()) {
            case _1:
                tgt.setValue(org.hl7.fhir.dstu2.model.AuditEvent.AuditEventParticipantNetworkType._1);
                break;
            case _2:
                tgt.setValue(org.hl7.fhir.dstu2.model.AuditEvent.AuditEventParticipantNetworkType._2);
                break;
            case _3:
                tgt.setValue(org.hl7.fhir.dstu2.model.AuditEvent.AuditEventParticipantNetworkType._3);
                break;
            case _4:
                tgt.setValue(org.hl7.fhir.dstu2.model.AuditEvent.AuditEventParticipantNetworkType._4);
                break;
            case _5:
                tgt.setValue(org.hl7.fhir.dstu2.model.AuditEvent.AuditEventParticipantNetworkType._5);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2.model.AuditEvent.AuditEventParticipantNetworkType.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAgentNetworkType> convertAuditEventParticipantNetworkType(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.AuditEvent.AuditEventParticipantNetworkType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAgentNetworkType> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAgentNetworkTypeEnumFactory());
        VersionConvertor_10_30.copyElement(src, tgt);
        switch(src.getValue()) {
            case _1:
                tgt.setValue(org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAgentNetworkType._1);
                break;
            case _2:
                tgt.setValue(org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAgentNetworkType._2);
                break;
            case _3:
                tgt.setValue(org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAgentNetworkType._3);
                break;
            case _4:
                tgt.setValue(org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAgentNetworkType._4);
                break;
            case _5:
                tgt.setValue(org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAgentNetworkType._5);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAgentNetworkType.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.AuditEvent.AuditEventSourceComponent convertAuditEventSourceComponent(org.hl7.fhir.dstu3.model.AuditEvent.AuditEventSourceComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.AuditEvent.AuditEventSourceComponent tgt = new org.hl7.fhir.dstu2.model.AuditEvent.AuditEventSourceComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasSiteElement())
            tgt.setSiteElement(VersionConvertor_10_30.convertString(src.getSiteElement()));
        if (src.hasIdentifier())
            tgt.setIdentifier(VersionConvertor_10_30.convertIdentifier(src.getIdentifier()));
        for (org.hl7.fhir.dstu3.model.Coding t : src.getType()) tgt.addType(VersionConvertor_10_30.convertCoding(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.AuditEvent.AuditEventSourceComponent convertAuditEventSourceComponent(org.hl7.fhir.dstu2.model.AuditEvent.AuditEventSourceComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.AuditEvent.AuditEventSourceComponent tgt = new org.hl7.fhir.dstu3.model.AuditEvent.AuditEventSourceComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasSiteElement())
            tgt.setSiteElement(VersionConvertor_10_30.convertString(src.getSiteElement()));
        if (src.hasIdentifier())
            tgt.setIdentifier(VersionConvertor_10_30.convertIdentifier(src.getIdentifier()));
        for (org.hl7.fhir.dstu2.model.Coding t : src.getType()) tgt.addType(VersionConvertor_10_30.convertCoding(t));
        return tgt;
    }
}