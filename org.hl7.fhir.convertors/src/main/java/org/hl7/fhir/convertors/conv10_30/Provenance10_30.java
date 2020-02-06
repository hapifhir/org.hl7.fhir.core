package org.hl7.fhir.convertors.conv10_30;

import org.hl7.fhir.convertors.VersionConvertor_10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class Provenance10_30 {

    public static org.hl7.fhir.dstu2.model.Provenance convertProvenance(org.hl7.fhir.dstu3.model.Provenance src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Provenance tgt = new org.hl7.fhir.dstu2.model.Provenance();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        if (src.hasTarget()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getTarget()) tgt.addTarget(VersionConvertor_10_30.convertReference(t));
        }
        if (src.hasPeriod()) {
            tgt.setPeriod(VersionConvertor_10_30.convertPeriod(src.getPeriod()));
        }
        if (src.hasRecorded()) {
            tgt.setRecorded(src.getRecorded());
        }
        if (src.hasReason()) {
            for (org.hl7.fhir.dstu3.model.Coding t : src.getReason()) tgt.addReason().addCoding(VersionConvertor_10_30.convertCoding(t));
        }
        if (src.hasActivity()) {
            tgt.setActivity(new org.hl7.fhir.dstu2.model.CodeableConcept().addCoding(VersionConvertor_10_30.convertCoding(src.getActivity())));
        }
        if (src.hasLocation()) {
            tgt.setLocation(VersionConvertor_10_30.convertReference(src.getLocation()));
        }
        if (src.hasPolicy()) {
            for (org.hl7.fhir.dstu3.model.UriType t : src.getPolicy()) tgt.addPolicy(t.getValue());
        }
        if (src.hasAgent()) {
            for (org.hl7.fhir.dstu3.model.Provenance.ProvenanceAgentComponent t : src.getAgent()) tgt.addAgent(convertProvenanceAgentComponent(t));
        }
        if (src.hasEntity()) {
            for (org.hl7.fhir.dstu3.model.Provenance.ProvenanceEntityComponent t : src.getEntity()) tgt.addEntity(convertProvenanceEntityComponent(t));
        }
        if (src.hasSignature()) {
            for (org.hl7.fhir.dstu3.model.Signature t : src.getSignature()) tgt.addSignature(VersionConvertor_10_30.convertSignature(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Provenance convertProvenance(org.hl7.fhir.dstu2.model.Provenance src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Provenance tgt = new org.hl7.fhir.dstu3.model.Provenance();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        if (src.hasTarget()) {
            for (org.hl7.fhir.dstu2.model.Reference t : src.getTarget()) tgt.addTarget(VersionConvertor_10_30.convertReference(t));
        }
        if (src.hasPeriod()) {
            tgt.setPeriod(VersionConvertor_10_30.convertPeriod(src.getPeriod()));
        }
        if (src.hasRecorded()) {
            tgt.setRecorded(src.getRecorded());
        }
        if (src.hasReason()) {
            for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getReason()) for (org.hl7.fhir.dstu2.model.Coding tc : t.getCoding()) tgt.addReason(VersionConvertor_10_30.convertCoding(tc));
        }
        if (src.hasActivity()) {
            for (org.hl7.fhir.dstu2.model.Coding t : src.getActivity().getCoding()) tgt.setActivity(VersionConvertor_10_30.convertCoding(t));
        }
        if (src.hasLocation()) {
            tgt.setLocation(VersionConvertor_10_30.convertReference(src.getLocation()));
        }
        if (src.hasPolicy()) {
            for (org.hl7.fhir.dstu2.model.UriType t : src.getPolicy()) tgt.addPolicy(t.getValue());
        }
        if (src.hasAgent()) {
            for (org.hl7.fhir.dstu2.model.Provenance.ProvenanceAgentComponent t : src.getAgent()) tgt.addAgent(convertProvenanceAgentComponent(t));
        }
        if (src.hasEntity()) {
            for (org.hl7.fhir.dstu2.model.Provenance.ProvenanceEntityComponent t : src.getEntity()) tgt.addEntity(convertProvenanceEntityComponent(t));
        }
        if (src.hasSignature()) {
            for (org.hl7.fhir.dstu2.model.Signature t : src.getSignature()) tgt.addSignature(VersionConvertor_10_30.convertSignature(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Provenance.ProvenanceAgentComponent convertProvenanceAgentComponent(org.hl7.fhir.dstu3.model.Provenance.ProvenanceAgentComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Provenance.ProvenanceAgentComponent tgt = new org.hl7.fhir.dstu2.model.Provenance.ProvenanceAgentComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasWhoReference())
            tgt.setActor(VersionConvertor_10_30.convertReference(src.getWhoReference()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Provenance.ProvenanceAgentComponent convertProvenanceAgentComponent(org.hl7.fhir.dstu2.model.Provenance.ProvenanceAgentComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Provenance.ProvenanceAgentComponent tgt = new org.hl7.fhir.dstu3.model.Provenance.ProvenanceAgentComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasActor()) {
            tgt.setWho(VersionConvertor_10_30.convertReference(src.getActor()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Provenance.ProvenanceEntityComponent convertProvenanceEntityComponent(org.hl7.fhir.dstu3.model.Provenance.ProvenanceEntityComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Provenance.ProvenanceEntityComponent tgt = new org.hl7.fhir.dstu2.model.Provenance.ProvenanceEntityComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasRole()) {
            tgt.setRole(convertProvenanceEntityRole(src.getRole()));
        }
        if (src.hasWhatReference() && src.getWhatReference().hasReference())
            tgt.setReference(src.getWhatReference().getReference());
        if (src.hasAgent()) {
            for (org.hl7.fhir.dstu3.model.Provenance.ProvenanceAgentComponent t : src.getAgent()) tgt.setAgent(convertProvenanceAgentComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Provenance.ProvenanceEntityComponent convertProvenanceEntityComponent(org.hl7.fhir.dstu2.model.Provenance.ProvenanceEntityComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Provenance.ProvenanceEntityComponent tgt = new org.hl7.fhir.dstu3.model.Provenance.ProvenanceEntityComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasRole()) {
            tgt.setRole(convertProvenanceEntityRole(src.getRole()));
        }
        if (src.hasReference())
            tgt.setWhat(new org.hl7.fhir.dstu3.model.Reference().setReference(src.getReference()));
        if (src.hasAgent()) {
            tgt.addAgent(convertProvenanceAgentComponent(src.getAgent()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Provenance.ProvenanceEntityRole convertProvenanceEntityRole(org.hl7.fhir.dstu2.model.Provenance.ProvenanceEntityRole src) throws FHIRException {
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
            default:
                return org.hl7.fhir.dstu3.model.Provenance.ProvenanceEntityRole.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.Provenance.ProvenanceEntityRole convertProvenanceEntityRole(org.hl7.fhir.dstu3.model.Provenance.ProvenanceEntityRole src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case DERIVATION:
                return org.hl7.fhir.dstu2.model.Provenance.ProvenanceEntityRole.DERIVATION;
            case REVISION:
                return org.hl7.fhir.dstu2.model.Provenance.ProvenanceEntityRole.REVISION;
            case QUOTATION:
                return org.hl7.fhir.dstu2.model.Provenance.ProvenanceEntityRole.QUOTATION;
            case SOURCE:
                return org.hl7.fhir.dstu2.model.Provenance.ProvenanceEntityRole.SOURCE;
            default:
                return org.hl7.fhir.dstu2.model.Provenance.ProvenanceEntityRole.NULL;
        }
    }
}
