package org.hl7.fhir.convertors.conv30_40;

import org.hl7.fhir.convertors.VersionConvertor_30_40;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.Identifier;
import org.hl7.fhir.r4.model.Reference;
import org.hl7.fhir.r4.model.Type;
import org.hl7.fhir.r4.model.UriType;

public class Provenance30_40 {

    public static org.hl7.fhir.r4.model.CodeableConcept convertCodingToCodeableConcept(org.hl7.fhir.dstu3.model.Coding src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.CodeableConcept tgt = new org.hl7.fhir.r4.model.CodeableConcept();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasSystem())
            tgt.getCodingFirstRep().setSystem(src.getSystem());
        if (src.hasVersion())
            tgt.getCodingFirstRep().setVersion(src.getVersion());
        if (src.hasCode())
            tgt.getCodingFirstRep().setCode(src.getCode());
        if (src.hasDisplay())
            tgt.getCodingFirstRep().setDisplay(src.getDisplay());
        if (src.hasUserSelected())
            tgt.getCodingFirstRep().setUserSelected(src.getUserSelected());
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Provenance convertProvenance(org.hl7.fhir.r4.model.Provenance src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Provenance tgt = new org.hl7.fhir.dstu3.model.Provenance();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        if (src.hasTarget()) {
            for (org.hl7.fhir.r4.model.Reference t : src.getTarget()) tgt.addTarget(VersionConvertor_30_40.convertReference(t));
        }
        if (src.hasOccurredPeriod())
            tgt.setPeriod(VersionConvertor_30_40.convertPeriod(src.getOccurredPeriod()));
        if (src.hasRecorded())
            tgt.setRecordedElement(VersionConvertor_30_40.convertInstant(src.getRecordedElement()));
        if (src.hasPolicy()) {
            for (org.hl7.fhir.r4.model.UriType t : src.getPolicy()) tgt.addPolicy(t.getValue());
        }
        if (src.hasLocation())
            tgt.setLocation(VersionConvertor_30_40.convertReference(src.getLocation()));
        if (src.hasReason()) {
            for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReason()) for (org.hl7.fhir.r4.model.Coding tc : t.getCoding()) tgt.addReason(VersionConvertor_30_40.convertCoding(tc));
        }
        if (src.hasActivity())
            tgt.setActivity(VersionConvertor_30_40.convertCoding(src.getActivity()));
        if (src.hasAgent()) {
            for (org.hl7.fhir.r4.model.Provenance.ProvenanceAgentComponent t : src.getAgent()) tgt.addAgent(convertProvenanceAgentComponent(t));
        }
        if (src.hasEntity()) {
            for (org.hl7.fhir.r4.model.Provenance.ProvenanceEntityComponent t : src.getEntity()) tgt.addEntity(convertProvenanceEntityComponent(t));
        }
        if (src.hasSignature()) {
            for (org.hl7.fhir.r4.model.Signature t : src.getSignature()) tgt.addSignature(VersionConvertor_30_40.convertSignature(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Provenance convertProvenance(org.hl7.fhir.dstu3.model.Provenance src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Provenance tgt = new org.hl7.fhir.r4.model.Provenance();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        if (src.hasTarget()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getTarget()) tgt.addTarget(VersionConvertor_30_40.convertReference(t));
        }
        if (src.hasPeriod())
            tgt.setOccurred(VersionConvertor_30_40.convertPeriod(src.getPeriod()));
        if (src.hasRecorded())
            tgt.setRecordedElement(VersionConvertor_30_40.convertInstant(src.getRecordedElement()));
        if (src.hasPolicy()) {
            for (org.hl7.fhir.dstu3.model.UriType t : src.getPolicy()) tgt.addPolicy(t.getValue());
        }
        if (src.hasLocation())
            tgt.setLocation(VersionConvertor_30_40.convertReference(src.getLocation()));
        if (src.hasReason()) {
            for (org.hl7.fhir.dstu3.model.Coding t : src.getReason()) tgt.addReason(convertCodingToCodeableConcept(t));
        }
        if (src.hasActivity())
            tgt.setActivity(convertCodingToCodeableConcept(src.getActivity()));
        if (src.hasAgent()) {
            for (org.hl7.fhir.dstu3.model.Provenance.ProvenanceAgentComponent t : src.getAgent()) tgt.addAgent(convertProvenanceAgentComponent(t));
        }
        if (src.hasEntity()) {
            for (org.hl7.fhir.dstu3.model.Provenance.ProvenanceEntityComponent t : src.getEntity()) tgt.addEntity(convertProvenanceEntityComponent(t));
        }
        if (src.hasSignature()) {
            for (org.hl7.fhir.dstu3.model.Signature t : src.getSignature()) tgt.addSignature(VersionConvertor_30_40.convertSignature(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Provenance.ProvenanceAgentComponent convertProvenanceAgentComponent(org.hl7.fhir.r4.model.Provenance.ProvenanceAgentComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Provenance.ProvenanceAgentComponent tgt = new org.hl7.fhir.dstu3.model.Provenance.ProvenanceAgentComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasRole()) {
            for (org.hl7.fhir.r4.model.CodeableConcept t : src.getRole()) tgt.addRole(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        if (src.hasWho())
            tgt.setWho(VersionConvertor_30_40.convertType(src.getWho()));
        if (src.hasOnBehalfOf())
            tgt.setOnBehalfOf(VersionConvertor_30_40.convertType(src.getOnBehalfOf()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Provenance.ProvenanceAgentComponent convertProvenanceAgentComponent(org.hl7.fhir.dstu3.model.Provenance.ProvenanceAgentComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Provenance.ProvenanceAgentComponent tgt = new org.hl7.fhir.r4.model.Provenance.ProvenanceAgentComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getRole()) tgt.addRole(VersionConvertor_30_40.convertCodeableConcept(t));
        if (src.hasWho()) {
            Type t = VersionConvertor_30_40.convertType(src.getWho());
            if (t instanceof Reference)
                tgt.setWho((Reference) t);
            if (t instanceof UriType)
                tgt.getWho().setReference(t.primitiveValue());
        }
        if (src.hasOnBehalfOf()) {
            Type t = VersionConvertor_30_40.convertType(src.getOnBehalfOf());
            if (t instanceof Reference)
                tgt.setOnBehalfOf((Reference) t);
            if (t instanceof UriType)
                tgt.getOnBehalfOf().setReference(t.primitiveValue());
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Provenance.ProvenanceEntityComponent convertProvenanceEntityComponent(org.hl7.fhir.r4.model.Provenance.ProvenanceEntityComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Provenance.ProvenanceEntityComponent tgt = new org.hl7.fhir.dstu3.model.Provenance.ProvenanceEntityComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasRole())
            tgt.setRole(convertProvenanceEntityRole(src.getRole()));
        if (src.hasWhat())
            tgt.setWhat(VersionConvertor_30_40.convertType(src.getWhat()));
        if (src.hasAgent()) {
            for (org.hl7.fhir.r4.model.Provenance.ProvenanceAgentComponent t : src.getAgent()) tgt.addAgent(convertProvenanceAgentComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Provenance.ProvenanceEntityComponent convertProvenanceEntityComponent(org.hl7.fhir.dstu3.model.Provenance.ProvenanceEntityComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Provenance.ProvenanceEntityComponent tgt = new org.hl7.fhir.r4.model.Provenance.ProvenanceEntityComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasRole())
            tgt.setRole(convertProvenanceEntityRole(src.getRole()));
        if (src.hasWhat()) {
            Type t = VersionConvertor_30_40.convertType(src.getWhat());
            if (t instanceof Reference)
                tgt.setWhat((Reference) t);
            else if (t instanceof Identifier)
                tgt.getWhat().setIdentifier((Identifier) t);
            else if (t instanceof UriType)
                tgt.getWhat().setReference(t.primitiveValue());
        }
        for (org.hl7.fhir.dstu3.model.Provenance.ProvenanceAgentComponent t : src.getAgent()) tgt.addAgent(convertProvenanceAgentComponent(t));
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Provenance.ProvenanceEntityRole convertProvenanceEntityRole(org.hl7.fhir.dstu3.model.Provenance.ProvenanceEntityRole src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case DERIVATION:
                return org.hl7.fhir.r4.model.Provenance.ProvenanceEntityRole.DERIVATION;
            case REVISION:
                return org.hl7.fhir.r4.model.Provenance.ProvenanceEntityRole.REVISION;
            case QUOTATION:
                return org.hl7.fhir.r4.model.Provenance.ProvenanceEntityRole.QUOTATION;
            case SOURCE:
                return org.hl7.fhir.r4.model.Provenance.ProvenanceEntityRole.SOURCE;
            case REMOVAL:
                return org.hl7.fhir.r4.model.Provenance.ProvenanceEntityRole.REMOVAL;
            default:
                return org.hl7.fhir.r4.model.Provenance.ProvenanceEntityRole.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.Provenance.ProvenanceEntityRole convertProvenanceEntityRole(org.hl7.fhir.r4.model.Provenance.ProvenanceEntityRole src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case DERIVATION:
                return org.hl7.fhir.dstu3.model.Provenance.ProvenanceEntityRole.DERIVATION;
            case REVISION:
                return org.hl7.fhir.dstu3.model.Provenance.ProvenanceEntityRole.REVISION;
            case QUOTATION:
                return org.hl7.fhir.dstu3.model.Provenance.ProvenanceEntityRole.QUOTATION;
            case SOURCE:
                return org.hl7.fhir.dstu3.model.Provenance.ProvenanceEntityRole.SOURCE;
            case REMOVAL:
                return org.hl7.fhir.dstu3.model.Provenance.ProvenanceEntityRole.REMOVAL;
            default:
                return org.hl7.fhir.dstu3.model.Provenance.ProvenanceEntityRole.NULL;
        }
    }
}
