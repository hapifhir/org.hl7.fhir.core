package org.hl7.fhir.convertors.conv30_50;

import org.hl7.fhir.convertors.VersionConvertor_30_50;
import org.hl7.fhir.exceptions.FHIRException;

public class AuditEvent30_50 {

    public static org.hl7.fhir.r5.model.AuditEvent convertAuditEvent(org.hl7.fhir.dstu3.model.AuditEvent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.AuditEvent tgt = new org.hl7.fhir.r5.model.AuditEvent();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        if (src.hasType())
            tgt.setType(VersionConvertor_30_50.convertCoding(src.getType()));
        for (org.hl7.fhir.dstu3.model.Coding t : src.getSubtype()) tgt.addSubtype(VersionConvertor_30_50.convertCoding(t));
        if (src.hasAction())
            tgt.setAction(convertAuditEventAction(src.getAction()));
        if (src.hasRecorded())
            tgt.setRecorded(src.getRecorded());
        if (src.hasOutcome())
            tgt.setOutcome(convertAuditEventOutcome(src.getOutcome()));
        if (src.hasOutcomeDesc())
            tgt.setOutcomeDesc(src.getOutcomeDesc());
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getPurposeOfEvent()) tgt.addPurposeOfEvent(VersionConvertor_30_50.convertCodeableConcept(t));
        for (org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAgentComponent t : src.getAgent()) tgt.addAgent(convertAuditEventAgentComponent(t));
        if (src.hasSource())
            tgt.setSource(convertAuditEventSourceComponent(src.getSource()));
        for (org.hl7.fhir.dstu3.model.AuditEvent.AuditEventEntityComponent t : src.getEntity()) tgt.addEntity(convertAuditEventEntityComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.AuditEvent convertAuditEvent(org.hl7.fhir.r5.model.AuditEvent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.AuditEvent tgt = new org.hl7.fhir.dstu3.model.AuditEvent();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        if (src.hasType())
            tgt.setType(VersionConvertor_30_50.convertCoding(src.getType()));
        for (org.hl7.fhir.r5.model.Coding t : src.getSubtype()) tgt.addSubtype(VersionConvertor_30_50.convertCoding(t));
        if (src.hasAction())
            tgt.setAction(convertAuditEventAction(src.getAction()));
        if (src.hasRecorded())
            tgt.setRecorded(src.getRecorded());
        if (src.hasOutcome())
            tgt.setOutcome(convertAuditEventOutcome(src.getOutcome()));
        if (src.hasOutcomeDesc())
            tgt.setOutcomeDesc(src.getOutcomeDesc());
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getPurposeOfEvent()) tgt.addPurposeOfEvent(VersionConvertor_30_50.convertCodeableConcept(t));
        for (org.hl7.fhir.r5.model.AuditEvent.AuditEventAgentComponent t : src.getAgent()) tgt.addAgent(convertAuditEventAgentComponent(t));
        if (src.hasSource())
            tgt.setSource(convertAuditEventSourceComponent(src.getSource()));
        for (org.hl7.fhir.r5.model.AuditEvent.AuditEventEntityComponent t : src.getEntity()) tgt.addEntity(convertAuditEventEntityComponent(t));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.AuditEvent.AuditEventAction convertAuditEventAction(org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAction src) throws FHIRException {
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

    static public org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAction convertAuditEventAction(org.hl7.fhir.r5.model.AuditEvent.AuditEventAction src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case C:
                return org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAction.C;
            case R:
                return org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAction.R;
            case U:
                return org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAction.U;
            case D:
                return org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAction.D;
            case E:
                return org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAction.E;
            default:
                return org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAction.NULL;
        }
    }

    public static org.hl7.fhir.r5.model.AuditEvent.AuditEventAgentComponent convertAuditEventAgentComponent(org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAgentComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.AuditEvent.AuditEventAgentComponent tgt = new org.hl7.fhir.r5.model.AuditEvent.AuditEventAgentComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getRole()) tgt.addRole(VersionConvertor_30_50.convertCodeableConcept(t));
        if (src.hasReference())
            tgt.setWho(VersionConvertor_30_50.convertReference(src.getReference()));
        if (src.hasUserId())
            tgt.getWho().setIdentifier(VersionConvertor_30_50.convertIdentifier(src.getUserId()));
        if (src.hasAltId())
            tgt.setAltId(src.getAltId());
        if (src.hasName())
            tgt.setName(src.getName());
        if (src.hasRequestor())
            tgt.setRequestor(src.getRequestor());
        if (src.hasLocation())
            tgt.setLocation(VersionConvertor_30_50.convertReference(src.getLocation()));
        for (org.hl7.fhir.dstu3.model.UriType t : src.getPolicy()) tgt.addPolicy(t.getValue());
        if (src.hasMedia())
            tgt.setMedia(VersionConvertor_30_50.convertCoding(src.getMedia()));
        if (src.hasNetwork())
            tgt.setNetwork(convertAuditEventAgentNetworkComponent(src.getNetwork()));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getPurposeOfUse()) tgt.addPurposeOfUse(VersionConvertor_30_50.convertCodeableConcept(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAgentComponent convertAuditEventAgentComponent(org.hl7.fhir.r5.model.AuditEvent.AuditEventAgentComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAgentComponent tgt = new org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAgentComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getRole()) tgt.addRole(VersionConvertor_30_50.convertCodeableConcept(t));
        if (src.hasWho()) {
            if (src.getWho().hasIdentifier())
                tgt.setUserId(VersionConvertor_30_50.convertIdentifier(src.getWho().getIdentifier()));
            if (src.getWho().hasReference() || src.getWho().hasDisplay() || src.getWho().hasExtension() || src.getWho().hasId())
                tgt.setReference(VersionConvertor_30_50.convertReference(src.getWho()));
        }
        if (src.hasAltId())
            tgt.setAltId(src.getAltId());
        if (src.hasName())
            tgt.setName(src.getName());
        if (src.hasRequestor())
            tgt.setRequestor(src.getRequestor());
        if (src.hasLocation())
            tgt.setLocation(VersionConvertor_30_50.convertReference(src.getLocation()));
        for (org.hl7.fhir.r5.model.UriType t : src.getPolicy()) tgt.addPolicy(t.getValue());
        if (src.hasMedia())
            tgt.setMedia(VersionConvertor_30_50.convertCoding(src.getMedia()));
        if (src.hasNetwork())
            tgt.setNetwork(convertAuditEventAgentNetworkComponent(src.getNetwork()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getPurposeOfUse()) tgt.addPurposeOfUse(VersionConvertor_30_50.convertCodeableConcept(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAgentNetworkComponent convertAuditEventAgentNetworkComponent(org.hl7.fhir.r5.model.AuditEvent.AuditEventAgentNetworkComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAgentNetworkComponent tgt = new org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAgentNetworkComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasAddress())
            tgt.setAddress(src.getAddress());
        if (src.hasType())
            tgt.setType(convertAuditEventAgentNetworkType(src.getType()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.AuditEvent.AuditEventAgentNetworkComponent convertAuditEventAgentNetworkComponent(org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAgentNetworkComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.AuditEvent.AuditEventAgentNetworkComponent tgt = new org.hl7.fhir.r5.model.AuditEvent.AuditEventAgentNetworkComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasAddress())
            tgt.setAddress(src.getAddress());
        if (src.hasType())
            tgt.setType(convertAuditEventAgentNetworkType(src.getType()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.AuditEvent.AuditEventAgentNetworkType convertAuditEventAgentNetworkType(org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAgentNetworkType src) throws FHIRException {
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

    static public org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAgentNetworkType convertAuditEventAgentNetworkType(org.hl7.fhir.r5.model.AuditEvent.AuditEventAgentNetworkType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case _1:
                return org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAgentNetworkType._1;
            case _2:
                return org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAgentNetworkType._2;
            case _3:
                return org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAgentNetworkType._3;
            case _4:
                return org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAgentNetworkType._4;
            case _5:
                return org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAgentNetworkType._5;
            default:
                return org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAgentNetworkType.NULL;
        }
    }

    public static org.hl7.fhir.r5.model.AuditEvent.AuditEventEntityComponent convertAuditEventEntityComponent(org.hl7.fhir.dstu3.model.AuditEvent.AuditEventEntityComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.AuditEvent.AuditEventEntityComponent tgt = new org.hl7.fhir.r5.model.AuditEvent.AuditEventEntityComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasIdentifier())
            tgt.getWhat().setIdentifier(VersionConvertor_30_50.convertIdentifier(src.getIdentifier()));
        if (src.hasReference())
            tgt.setWhat(VersionConvertor_30_50.convertReference(src.getReference()));
        if (src.hasType())
            tgt.setType(VersionConvertor_30_50.convertCoding(src.getType()));
        if (src.hasRole())
            tgt.setRole(VersionConvertor_30_50.convertCoding(src.getRole()));
        if (src.hasLifecycle())
            tgt.setLifecycle(VersionConvertor_30_50.convertCoding(src.getLifecycle()));
        for (org.hl7.fhir.dstu3.model.Coding t : src.getSecurityLabel()) tgt.addSecurityLabel(VersionConvertor_30_50.convertCoding(t));
        if (src.hasName())
            tgt.setName(src.getName());
        if (src.hasQuery())
            tgt.setQuery(src.getQuery());
        for (org.hl7.fhir.dstu3.model.AuditEvent.AuditEventEntityDetailComponent t : src.getDetail()) tgt.addDetail(convertAuditEventEntityDetailComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.AuditEvent.AuditEventEntityComponent convertAuditEventEntityComponent(org.hl7.fhir.r5.model.AuditEvent.AuditEventEntityComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.AuditEvent.AuditEventEntityComponent tgt = new org.hl7.fhir.dstu3.model.AuditEvent.AuditEventEntityComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasWhat()) {
            if (src.getWhat().hasIdentifier())
                tgt.setIdentifier(VersionConvertor_30_50.convertIdentifier(src.getWhat().getIdentifier()));
            if (src.getWhat().hasReference() || src.getWhat().hasDisplay() || src.getWhat().hasExtension() || src.getWhat().hasId())
                tgt.setReference(VersionConvertor_30_50.convertReference(src.getWhat()));
        }
        if (src.hasType())
            tgt.setType(VersionConvertor_30_50.convertCoding(src.getType()));
        if (src.hasRole())
            tgt.setRole(VersionConvertor_30_50.convertCoding(src.getRole()));
        if (src.hasLifecycle())
            tgt.setLifecycle(VersionConvertor_30_50.convertCoding(src.getLifecycle()));
        for (org.hl7.fhir.r5.model.Coding t : src.getSecurityLabel()) tgt.addSecurityLabel(VersionConvertor_30_50.convertCoding(t));
        if (src.hasName())
            tgt.setName(src.getName());
        if (src.hasQuery())
            tgt.setQuery(src.getQuery());
        for (org.hl7.fhir.r5.model.AuditEvent.AuditEventEntityDetailComponent t : src.getDetail()) tgt.addDetail(convertAuditEventEntityDetailComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.AuditEvent.AuditEventEntityDetailComponent convertAuditEventEntityDetailComponent(org.hl7.fhir.r5.model.AuditEvent.AuditEventEntityDetailComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.AuditEvent.AuditEventEntityDetailComponent tgt = new org.hl7.fhir.dstu3.model.AuditEvent.AuditEventEntityDetailComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasType())
            tgt.setType(src.getType());
        if (src.hasValueStringType())
            tgt.setValue(src.getValueStringType().getValue().getBytes());
        else if (src.hasValueBase64BinaryType())
            tgt.setValue(src.getValueBase64BinaryType().getValue());
        return tgt;
    }

    public static org.hl7.fhir.r5.model.AuditEvent.AuditEventEntityDetailComponent convertAuditEventEntityDetailComponent(org.hl7.fhir.dstu3.model.AuditEvent.AuditEventEntityDetailComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.AuditEvent.AuditEventEntityDetailComponent tgt = new org.hl7.fhir.r5.model.AuditEvent.AuditEventEntityDetailComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasType())
            tgt.setType(src.getType());
        if (src.hasValue())
            tgt.setValue(new org.hl7.fhir.r5.model.Base64BinaryType(src.getValue()));
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.AuditEvent.AuditEventOutcome convertAuditEventOutcome(org.hl7.fhir.r5.model.AuditEvent.AuditEventOutcome src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case _0:
                return org.hl7.fhir.dstu3.model.AuditEvent.AuditEventOutcome._0;
            case _4:
                return org.hl7.fhir.dstu3.model.AuditEvent.AuditEventOutcome._4;
            case _8:
                return org.hl7.fhir.dstu3.model.AuditEvent.AuditEventOutcome._8;
            case _12:
                return org.hl7.fhir.dstu3.model.AuditEvent.AuditEventOutcome._12;
            default:
                return org.hl7.fhir.dstu3.model.AuditEvent.AuditEventOutcome.NULL;
        }
    }

    static public org.hl7.fhir.r5.model.AuditEvent.AuditEventOutcome convertAuditEventOutcome(org.hl7.fhir.dstu3.model.AuditEvent.AuditEventOutcome src) throws FHIRException {
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

    public static org.hl7.fhir.dstu3.model.AuditEvent.AuditEventSourceComponent convertAuditEventSourceComponent(org.hl7.fhir.r5.model.AuditEvent.AuditEventSourceComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.AuditEvent.AuditEventSourceComponent tgt = new org.hl7.fhir.dstu3.model.AuditEvent.AuditEventSourceComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasSite())
            tgt.setSite(src.getSite());
        if (src.hasObserver())
            tgt.setIdentifier(VersionConvertor_30_50.convertIdentifier(src.getObserver().getIdentifier()));
        for (org.hl7.fhir.r5.model.Coding t : src.getType()) tgt.addType(VersionConvertor_30_50.convertCoding(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.AuditEvent.AuditEventSourceComponent convertAuditEventSourceComponent(org.hl7.fhir.dstu3.model.AuditEvent.AuditEventSourceComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.AuditEvent.AuditEventSourceComponent tgt = new org.hl7.fhir.r5.model.AuditEvent.AuditEventSourceComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasSite())
            tgt.setSite(src.getSite());
        if (src.hasIdentifier())
            tgt.getObserver().setIdentifier(VersionConvertor_30_50.convertIdentifier(src.getIdentifier()));
        for (org.hl7.fhir.dstu3.model.Coding t : src.getType()) tgt.addType(VersionConvertor_30_50.convertCoding(t));
        return tgt;
    }
}
