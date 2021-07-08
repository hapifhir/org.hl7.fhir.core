package org.hl7.fhir.convertors.conv30_40.resources30_40;

import org.hl7.fhir.convertors.conv30_40.VersionConvertor_30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Element30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.CodeableConcept30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Coding30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Identifier30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.Base64Binary30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.Boolean30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.Instant30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.String30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Reference30_40;
import org.hl7.fhir.exceptions.FHIRException;

public class AuditEvent30_40 {

    public static org.hl7.fhir.dstu3.model.AuditEvent convertAuditEvent(org.hl7.fhir.r4.model.AuditEvent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.AuditEvent tgt = new org.hl7.fhir.dstu3.model.AuditEvent();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        if (src.hasType())
            tgt.setType(Coding30_40.convertCoding(src.getType()));
        for (org.hl7.fhir.r4.model.Coding t : src.getSubtype()) tgt.addSubtype(Coding30_40.convertCoding(t));
        if (src.hasAction())
            tgt.setActionElement(convertAuditEventAction(src.getActionElement()));
        if (src.hasRecorded())
            tgt.setRecordedElement(Instant30_40.convertInstant(src.getRecordedElement()));
        if (src.hasOutcome())
            tgt.setOutcomeElement(convertAuditEventOutcome(src.getOutcomeElement()));
        if (src.hasOutcomeDesc())
            tgt.setOutcomeDescElement(String30_40.convertString(src.getOutcomeDescElement()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getPurposeOfEvent()) tgt.addPurposeOfEvent(CodeableConcept30_40.convertCodeableConcept(t));
        for (org.hl7.fhir.r4.model.AuditEvent.AuditEventAgentComponent t : src.getAgent()) tgt.addAgent(convertAuditEventAgentComponent(t));
        if (src.hasSource())
            tgt.setSource(convertAuditEventSourceComponent(src.getSource()));
        for (org.hl7.fhir.r4.model.AuditEvent.AuditEventEntityComponent t : src.getEntity()) tgt.addEntity(convertAuditEventEntityComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.AuditEvent convertAuditEvent(org.hl7.fhir.dstu3.model.AuditEvent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.AuditEvent tgt = new org.hl7.fhir.r4.model.AuditEvent();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        if (src.hasType())
            tgt.setType(Coding30_40.convertCoding(src.getType()));
        for (org.hl7.fhir.dstu3.model.Coding t : src.getSubtype()) tgt.addSubtype(Coding30_40.convertCoding(t));
        if (src.hasAction())
            tgt.setActionElement(convertAuditEventAction(src.getActionElement()));
        if (src.hasRecorded())
            tgt.setRecordedElement(Instant30_40.convertInstant(src.getRecordedElement()));
        if (src.hasOutcome())
            tgt.setOutcomeElement(convertAuditEventOutcome(src.getOutcomeElement()));
        if (src.hasOutcomeDesc())
            tgt.setOutcomeDescElement(String30_40.convertString(src.getOutcomeDescElement()));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getPurposeOfEvent()) tgt.addPurposeOfEvent(CodeableConcept30_40.convertCodeableConcept(t));
        for (org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAgentComponent t : src.getAgent()) tgt.addAgent(convertAuditEventAgentComponent(t));
        if (src.hasSource())
            tgt.setSource(convertAuditEventSourceComponent(src.getSource()));
        for (org.hl7.fhir.dstu3.model.AuditEvent.AuditEventEntityComponent t : src.getEntity()) tgt.addEntity(convertAuditEventEntityComponent(t));
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.AuditEvent.AuditEventAction> convertAuditEventAction(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAction> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.AuditEvent.AuditEventAction> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.AuditEvent.AuditEventActionEnumFactory());
        Element30_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case C:
                tgt.setValue(org.hl7.fhir.r4.model.AuditEvent.AuditEventAction.C);
                break;
            case R:
                tgt.setValue(org.hl7.fhir.r4.model.AuditEvent.AuditEventAction.R);
                break;
            case U:
                tgt.setValue(org.hl7.fhir.r4.model.AuditEvent.AuditEventAction.U);
                break;
            case D:
                tgt.setValue(org.hl7.fhir.r4.model.AuditEvent.AuditEventAction.D);
                break;
            case E:
                tgt.setValue(org.hl7.fhir.r4.model.AuditEvent.AuditEventAction.E);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.AuditEvent.AuditEventAction.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAction> convertAuditEventAction(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.AuditEvent.AuditEventAction> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAction> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.AuditEvent.AuditEventActionEnumFactory());
        Element30_40.copyElement(src, tgt);
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

    public static org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAgentComponent convertAuditEventAgentComponent(org.hl7.fhir.r4.model.AuditEvent.AuditEventAgentComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAgentComponent tgt = new org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAgentComponent();
        Element30_40.copyElement(src, tgt);
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getRole()) tgt.addRole(CodeableConcept30_40.convertCodeableConcept(t));
        if (src.hasWho()) {
            if (src.getWho().hasIdentifier())
                tgt.setUserId(Identifier30_40.convertIdentifier(src.getWho().getIdentifier()));
            if (src.getWho().hasReference() || src.getWho().hasDisplay() || src.getWho().hasExtension() || src.getWho().hasId())
                tgt.setReference(Reference30_40.convertReference(src.getWho()));
        }
        if (src.hasAltId())
            tgt.setAltIdElement(String30_40.convertString(src.getAltIdElement()));
        if (src.hasName())
            tgt.setNameElement(String30_40.convertString(src.getNameElement()));
        if (src.hasRequestor())
            tgt.setRequestorElement(Boolean30_40.convertBoolean(src.getRequestorElement()));
        if (src.hasLocation())
            tgt.setLocation(Reference30_40.convertReference(src.getLocation()));
        for (org.hl7.fhir.r4.model.UriType t : src.getPolicy()) tgt.addPolicy(t.getValue());
        if (src.hasMedia())
            tgt.setMedia(Coding30_40.convertCoding(src.getMedia()));
        if (src.hasNetwork())
            tgt.setNetwork(convertAuditEventAgentNetworkComponent(src.getNetwork()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getPurposeOfUse()) tgt.addPurposeOfUse(CodeableConcept30_40.convertCodeableConcept(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.AuditEvent.AuditEventAgentComponent convertAuditEventAgentComponent(org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAgentComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.AuditEvent.AuditEventAgentComponent tgt = new org.hl7.fhir.r4.model.AuditEvent.AuditEventAgentComponent();
        Element30_40.copyElement(src, tgt);
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getRole()) tgt.addRole(CodeableConcept30_40.convertCodeableConcept(t));
        if (src.hasReference())
            tgt.setWho(Reference30_40.convertReference(src.getReference()));
        if (src.hasUserId())
            tgt.getWho().setIdentifier(Identifier30_40.convertIdentifier(src.getUserId()));
        if (src.hasAltId())
            tgt.setAltIdElement(String30_40.convertString(src.getAltIdElement()));
        if (src.hasName())
            tgt.setNameElement(String30_40.convertString(src.getNameElement()));
        if (src.hasRequestor())
            tgt.setRequestorElement(Boolean30_40.convertBoolean(src.getRequestorElement()));
        if (src.hasLocation())
            tgt.setLocation(Reference30_40.convertReference(src.getLocation()));
        for (org.hl7.fhir.dstu3.model.UriType t : src.getPolicy()) tgt.addPolicy(t.getValue());
        if (src.hasMedia())
            tgt.setMedia(Coding30_40.convertCoding(src.getMedia()));
        if (src.hasNetwork())
            tgt.setNetwork(convertAuditEventAgentNetworkComponent(src.getNetwork()));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getPurposeOfUse()) tgt.addPurposeOfUse(CodeableConcept30_40.convertCodeableConcept(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.AuditEvent.AuditEventAgentNetworkComponent convertAuditEventAgentNetworkComponent(org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAgentNetworkComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.AuditEvent.AuditEventAgentNetworkComponent tgt = new org.hl7.fhir.r4.model.AuditEvent.AuditEventAgentNetworkComponent();
        Element30_40.copyElement(src, tgt);
        if (src.hasAddress())
            tgt.setAddressElement(String30_40.convertString(src.getAddressElement()));
        if (src.hasType())
            tgt.setTypeElement(convertAuditEventAgentNetworkType(src.getTypeElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAgentNetworkComponent convertAuditEventAgentNetworkComponent(org.hl7.fhir.r4.model.AuditEvent.AuditEventAgentNetworkComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAgentNetworkComponent tgt = new org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAgentNetworkComponent();
        Element30_40.copyElement(src, tgt);
        if (src.hasAddress())
            tgt.setAddressElement(String30_40.convertString(src.getAddressElement()));
        if (src.hasType())
            tgt.setTypeElement(convertAuditEventAgentNetworkType(src.getTypeElement()));
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAgentNetworkType> convertAuditEventAgentNetworkType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.AuditEvent.AuditEventAgentNetworkType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAgentNetworkType> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAgentNetworkTypeEnumFactory());
        Element30_40.copyElement(src, tgt);
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

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.AuditEvent.AuditEventAgentNetworkType> convertAuditEventAgentNetworkType(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.AuditEvent.AuditEventAgentNetworkType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.AuditEvent.AuditEventAgentNetworkType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.AuditEvent.AuditEventAgentNetworkTypeEnumFactory());
        Element30_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case _1:
                tgt.setValue(org.hl7.fhir.r4.model.AuditEvent.AuditEventAgentNetworkType._1);
                break;
            case _2:
                tgt.setValue(org.hl7.fhir.r4.model.AuditEvent.AuditEventAgentNetworkType._2);
                break;
            case _3:
                tgt.setValue(org.hl7.fhir.r4.model.AuditEvent.AuditEventAgentNetworkType._3);
                break;
            case _4:
                tgt.setValue(org.hl7.fhir.r4.model.AuditEvent.AuditEventAgentNetworkType._4);
                break;
            case _5:
                tgt.setValue(org.hl7.fhir.r4.model.AuditEvent.AuditEventAgentNetworkType._5);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.AuditEvent.AuditEventAgentNetworkType.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.AuditEvent.AuditEventEntityComponent convertAuditEventEntityComponent(org.hl7.fhir.dstu3.model.AuditEvent.AuditEventEntityComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.AuditEvent.AuditEventEntityComponent tgt = new org.hl7.fhir.r4.model.AuditEvent.AuditEventEntityComponent();
        Element30_40.copyElement(src, tgt);
        if (src.hasIdentifier())
            tgt.getWhat().setIdentifier(Identifier30_40.convertIdentifier(src.getIdentifier()));
        if (src.hasReference())
            tgt.setWhat(Reference30_40.convertReference(src.getReference()));
        if (src.hasType())
            tgt.setType(Coding30_40.convertCoding(src.getType()));
        if (src.hasRole())
            tgt.setRole(Coding30_40.convertCoding(src.getRole()));
        if (src.hasLifecycle())
            tgt.setLifecycle(Coding30_40.convertCoding(src.getLifecycle()));
        for (org.hl7.fhir.dstu3.model.Coding t : src.getSecurityLabel()) tgt.addSecurityLabel(Coding30_40.convertCoding(t));
        if (src.hasName())
            tgt.setNameElement(String30_40.convertString(src.getNameElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(String30_40.convertString(src.getDescriptionElement()));
        if (src.hasQuery())
            tgt.setQueryElement(Base64Binary30_40.convertBase64Binary(src.getQueryElement()));
        for (org.hl7.fhir.dstu3.model.AuditEvent.AuditEventEntityDetailComponent t : src.getDetail()) tgt.addDetail(convertAuditEventEntityDetailComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.AuditEvent.AuditEventEntityComponent convertAuditEventEntityComponent(org.hl7.fhir.r4.model.AuditEvent.AuditEventEntityComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.AuditEvent.AuditEventEntityComponent tgt = new org.hl7.fhir.dstu3.model.AuditEvent.AuditEventEntityComponent();
        Element30_40.copyElement(src, tgt);
        if (src.hasWhat()) {
            if (src.getWhat().hasIdentifier())
                tgt.setIdentifier(Identifier30_40.convertIdentifier(src.getWhat().getIdentifier()));
            if (src.getWhat().hasReference() || src.getWhat().hasDisplay() || src.getWhat().hasExtension() || src.getWhat().hasId())
                tgt.setReference(Reference30_40.convertReference(src.getWhat()));
        }
        if (src.hasType())
            tgt.setType(Coding30_40.convertCoding(src.getType()));
        if (src.hasRole())
            tgt.setRole(Coding30_40.convertCoding(src.getRole()));
        if (src.hasLifecycle())
            tgt.setLifecycle(Coding30_40.convertCoding(src.getLifecycle()));
        for (org.hl7.fhir.r4.model.Coding t : src.getSecurityLabel()) tgt.addSecurityLabel(Coding30_40.convertCoding(t));
        if (src.hasName())
            tgt.setNameElement(String30_40.convertString(src.getNameElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(String30_40.convertString(src.getDescriptionElement()));
        if (src.hasQuery())
            tgt.setQueryElement(Base64Binary30_40.convertBase64Binary(src.getQueryElement()));
        for (org.hl7.fhir.r4.model.AuditEvent.AuditEventEntityDetailComponent t : src.getDetail()) tgt.addDetail(convertAuditEventEntityDetailComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.AuditEvent.AuditEventEntityDetailComponent convertAuditEventEntityDetailComponent(org.hl7.fhir.dstu3.model.AuditEvent.AuditEventEntityDetailComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.AuditEvent.AuditEventEntityDetailComponent tgt = new org.hl7.fhir.r4.model.AuditEvent.AuditEventEntityDetailComponent();
        Element30_40.copyElement(src, tgt);
        if (src.hasType())
            tgt.setTypeElement(String30_40.convertString(src.getTypeElement()));
        if (src.hasValue())
            tgt.setValue(new org.hl7.fhir.r4.model.Base64BinaryType(src.getValue()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.AuditEvent.AuditEventEntityDetailComponent convertAuditEventEntityDetailComponent(org.hl7.fhir.r4.model.AuditEvent.AuditEventEntityDetailComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.AuditEvent.AuditEventEntityDetailComponent tgt = new org.hl7.fhir.dstu3.model.AuditEvent.AuditEventEntityDetailComponent();
        Element30_40.copyElement(src, tgt);
        if (src.hasType())
            tgt.setTypeElement(String30_40.convertString(src.getTypeElement()));
        if (src.hasValueStringType())
            tgt.setValue(src.getValueStringType().getValue().getBytes());
        else if (src.hasValueBase64BinaryType())
            tgt.setValue(src.getValueBase64BinaryType().getValue());
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.AuditEvent.AuditEventOutcome> convertAuditEventOutcome(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.AuditEvent.AuditEventOutcome> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.AuditEvent.AuditEventOutcome> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.AuditEvent.AuditEventOutcomeEnumFactory());
        Element30_40.copyElement(src, tgt);
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

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.AuditEvent.AuditEventOutcome> convertAuditEventOutcome(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.AuditEvent.AuditEventOutcome> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.AuditEvent.AuditEventOutcome> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.AuditEvent.AuditEventOutcomeEnumFactory());
        Element30_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case _0:
                tgt.setValue(org.hl7.fhir.r4.model.AuditEvent.AuditEventOutcome._0);
                break;
            case _4:
                tgt.setValue(org.hl7.fhir.r4.model.AuditEvent.AuditEventOutcome._4);
                break;
            case _8:
                tgt.setValue(org.hl7.fhir.r4.model.AuditEvent.AuditEventOutcome._8);
                break;
            case _12:
                tgt.setValue(org.hl7.fhir.r4.model.AuditEvent.AuditEventOutcome._12);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.AuditEvent.AuditEventOutcome.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.AuditEvent.AuditEventSourceComponent convertAuditEventSourceComponent(org.hl7.fhir.r4.model.AuditEvent.AuditEventSourceComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.AuditEvent.AuditEventSourceComponent tgt = new org.hl7.fhir.dstu3.model.AuditEvent.AuditEventSourceComponent();
        Element30_40.copyElement(src, tgt);
        if (src.hasSite())
            tgt.setSiteElement(String30_40.convertString(src.getSiteElement()));
        if (src.hasObserver())
            tgt.setIdentifier(Identifier30_40.convertIdentifier(src.getObserver().getIdentifier()));
        for (org.hl7.fhir.r4.model.Coding t : src.getType()) tgt.addType(Coding30_40.convertCoding(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.AuditEvent.AuditEventSourceComponent convertAuditEventSourceComponent(org.hl7.fhir.dstu3.model.AuditEvent.AuditEventSourceComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.AuditEvent.AuditEventSourceComponent tgt = new org.hl7.fhir.r4.model.AuditEvent.AuditEventSourceComponent();
        Element30_40.copyElement(src, tgt);
        if (src.hasSite())
            tgt.setSiteElement(String30_40.convertString(src.getSiteElement()));
        if (src.hasIdentifier())
            tgt.getObserver().setIdentifier(Identifier30_40.convertIdentifier(src.getIdentifier()));
        for (org.hl7.fhir.dstu3.model.Coding t : src.getType()) tgt.addType(Coding30_40.convertCoding(t));
        return tgt;
    }
}