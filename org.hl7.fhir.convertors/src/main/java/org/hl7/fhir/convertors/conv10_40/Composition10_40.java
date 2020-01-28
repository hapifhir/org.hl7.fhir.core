package org.hl7.fhir.convertors.conv10_40;

import org.hl7.fhir.convertors.VersionConvertor_10_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Composition10_40 {

    public static org.hl7.fhir.dstu2.model.Composition convertComposition(org.hl7.fhir.r4.model.Composition src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Composition tgt = new org.hl7.fhir.dstu2.model.Composition();
        VersionConvertor_10_40.copyDomainResource(src, tgt);
        tgt.setIdentifier(VersionConvertor_10_40.convertIdentifier(src.getIdentifier()));
        if (src.hasDate())
            tgt.setDate(src.getDate());
        tgt.setType(VersionConvertor_10_40.convertCodeableConcept(src.getType()));
        if (src.hasCategory())
            tgt.setClass_(VersionConvertor_10_40.convertCodeableConcept(src.getCategoryFirstRep()));
        tgt.setTitle(src.getTitle());
        tgt.setStatus(convertCompositionStatus(src.getStatus()));
        tgt.setConfidentiality(src.getConfidentiality().toCode());
        tgt.setSubject(VersionConvertor_10_40.convertReference(src.getSubject()));
        for (org.hl7.fhir.r4.model.Reference t : src.getAuthor()) tgt.addAuthor(VersionConvertor_10_40.convertReference(t));
        for (org.hl7.fhir.r4.model.Composition.CompositionAttesterComponent t : src.getAttester()) tgt.addAttester(convertCompositionAttesterComponent(t));
        tgt.setCustodian(VersionConvertor_10_40.convertReference(src.getCustodian()));
        for (org.hl7.fhir.r4.model.Composition.CompositionEventComponent t : src.getEvent()) tgt.addEvent(convertCompositionEventComponent(t));
        tgt.setEncounter(VersionConvertor_10_40.convertReference(src.getEncounter()));
        for (org.hl7.fhir.r4.model.Composition.SectionComponent t : src.getSection()) tgt.addSection(convertSectionComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Composition convertComposition(org.hl7.fhir.dstu2.model.Composition src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Composition tgt = new org.hl7.fhir.r4.model.Composition();
        VersionConvertor_10_40.copyDomainResource(src, tgt);
        tgt.setIdentifier(VersionConvertor_10_40.convertIdentifier(src.getIdentifier()));
        if (src.hasDate())
            tgt.setDate(src.getDate());
        tgt.setType(VersionConvertor_10_40.convertCodeableConcept(src.getType()));
        tgt.addCategory(VersionConvertor_10_40.convertCodeableConcept(src.getClass_()));
        tgt.setTitle(src.getTitle());
        tgt.setStatus(convertCompositionStatus(src.getStatus()));
        try {
            tgt.setConfidentiality(org.hl7.fhir.r4.model.Composition.DocumentConfidentiality.fromCode(src.getConfidentiality()));
        } catch (org.hl7.fhir.exceptions.FHIRException e) {
            throw new FHIRException(e);
        }
        tgt.setSubject(VersionConvertor_10_40.convertReference(src.getSubject()));
        for (org.hl7.fhir.dstu2.model.Reference t : src.getAuthor()) tgt.addAuthor(VersionConvertor_10_40.convertReference(t));
        for (org.hl7.fhir.dstu2.model.Composition.CompositionAttesterComponent t : src.getAttester()) tgt.addAttester(convertCompositionAttesterComponent(t));
        tgt.setCustodian(VersionConvertor_10_40.convertReference(src.getCustodian()));
        for (org.hl7.fhir.dstu2.model.Composition.CompositionEventComponent t : src.getEvent()) tgt.addEvent(convertCompositionEventComponent(t));
        tgt.setEncounter(VersionConvertor_10_40.convertReference(src.getEncounter()));
        for (org.hl7.fhir.dstu2.model.Composition.SectionComponent t : src.getSection()) tgt.addSection(convertSectionComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Composition.CompositionAttestationMode convertCompositionAttestationMode(org.hl7.fhir.dstu2.model.Composition.CompositionAttestationMode src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case PERSONAL:
                return org.hl7.fhir.r4.model.Composition.CompositionAttestationMode.PERSONAL;
            case PROFESSIONAL:
                return org.hl7.fhir.r4.model.Composition.CompositionAttestationMode.PROFESSIONAL;
            case LEGAL:
                return org.hl7.fhir.r4.model.Composition.CompositionAttestationMode.LEGAL;
            case OFFICIAL:
                return org.hl7.fhir.r4.model.Composition.CompositionAttestationMode.OFFICIAL;
            default:
                return org.hl7.fhir.r4.model.Composition.CompositionAttestationMode.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.Composition.CompositionAttestationMode convertCompositionAttestationMode(org.hl7.fhir.r4.model.Composition.CompositionAttestationMode src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case PERSONAL:
                return org.hl7.fhir.dstu2.model.Composition.CompositionAttestationMode.PERSONAL;
            case PROFESSIONAL:
                return org.hl7.fhir.dstu2.model.Composition.CompositionAttestationMode.PROFESSIONAL;
            case LEGAL:
                return org.hl7.fhir.dstu2.model.Composition.CompositionAttestationMode.LEGAL;
            case OFFICIAL:
                return org.hl7.fhir.dstu2.model.Composition.CompositionAttestationMode.OFFICIAL;
            default:
                return org.hl7.fhir.dstu2.model.Composition.CompositionAttestationMode.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.Composition.CompositionAttesterComponent convertCompositionAttesterComponent(org.hl7.fhir.r4.model.Composition.CompositionAttesterComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Composition.CompositionAttesterComponent tgt = new org.hl7.fhir.dstu2.model.Composition.CompositionAttesterComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        if (src.hasMode())
            tgt.addMode(convertCompositionAttestationMode(src.getMode()));
        tgt.setTime(src.getTime());
        tgt.setParty(VersionConvertor_10_40.convertReference(src.getParty()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Composition.CompositionAttesterComponent convertCompositionAttesterComponent(org.hl7.fhir.dstu2.model.Composition.CompositionAttesterComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Composition.CompositionAttesterComponent tgt = new org.hl7.fhir.r4.model.Composition.CompositionAttesterComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        if (src.hasMode())
            tgt.setMode(convertCompositionAttestationMode(src.getMode().get(0).getValue()));
        tgt.setTime(src.getTime());
        tgt.setParty(VersionConvertor_10_40.convertReference(src.getParty()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Composition.CompositionEventComponent convertCompositionEventComponent(org.hl7.fhir.r4.model.Composition.CompositionEventComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Composition.CompositionEventComponent tgt = new org.hl7.fhir.dstu2.model.Composition.CompositionEventComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCode()) tgt.addCode(VersionConvertor_10_40.convertCodeableConcept(t));
        tgt.setPeriod(VersionConvertor_10_40.convertPeriod(src.getPeriod()));
        for (org.hl7.fhir.r4.model.Reference t : src.getDetail()) tgt.addDetail(VersionConvertor_10_40.convertReference(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Composition.CompositionEventComponent convertCompositionEventComponent(org.hl7.fhir.dstu2.model.Composition.CompositionEventComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Composition.CompositionEventComponent tgt = new org.hl7.fhir.r4.model.Composition.CompositionEventComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getCode()) tgt.addCode(VersionConvertor_10_40.convertCodeableConcept(t));
        tgt.setPeriod(VersionConvertor_10_40.convertPeriod(src.getPeriod()));
        for (org.hl7.fhir.dstu2.model.Reference t : src.getDetail()) tgt.addDetail(VersionConvertor_10_40.convertReference(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Composition.CompositionStatus convertCompositionStatus(org.hl7.fhir.dstu2.model.Composition.CompositionStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case PRELIMINARY:
                return org.hl7.fhir.r4.model.Composition.CompositionStatus.PRELIMINARY;
            case FINAL:
                return org.hl7.fhir.r4.model.Composition.CompositionStatus.FINAL;
            case AMENDED:
                return org.hl7.fhir.r4.model.Composition.CompositionStatus.AMENDED;
            case ENTEREDINERROR:
                return org.hl7.fhir.r4.model.Composition.CompositionStatus.ENTEREDINERROR;
            default:
                return org.hl7.fhir.r4.model.Composition.CompositionStatus.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.Composition.CompositionStatus convertCompositionStatus(org.hl7.fhir.r4.model.Composition.CompositionStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case PRELIMINARY:
                return org.hl7.fhir.dstu2.model.Composition.CompositionStatus.PRELIMINARY;
            case FINAL:
                return org.hl7.fhir.dstu2.model.Composition.CompositionStatus.FINAL;
            case AMENDED:
                return org.hl7.fhir.dstu2.model.Composition.CompositionStatus.AMENDED;
            case ENTEREDINERROR:
                return org.hl7.fhir.dstu2.model.Composition.CompositionStatus.ENTEREDINERROR;
            default:
                return org.hl7.fhir.dstu2.model.Composition.CompositionStatus.NULL;
        }
    }

    public static org.hl7.fhir.r4.model.Composition.SectionComponent convertSectionComponent(org.hl7.fhir.dstu2.model.Composition.SectionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Composition.SectionComponent tgt = new org.hl7.fhir.r4.model.Composition.SectionComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        tgt.setTitle(src.getTitle());
        tgt.setCode(VersionConvertor_10_40.convertCodeableConcept(src.getCode()));
        tgt.setText(VersionConvertor_10_40.convertNarrative(src.getText()));
        try {
            tgt.setMode(org.hl7.fhir.r4.model.Composition.SectionMode.fromCode(src.getMode()));
        } catch (org.hl7.fhir.exceptions.FHIRException e) {
            throw new FHIRException(e);
        }
        tgt.setOrderedBy(VersionConvertor_10_40.convertCodeableConcept(src.getOrderedBy()));
        for (org.hl7.fhir.dstu2.model.Reference t : src.getEntry()) tgt.addEntry(VersionConvertor_10_40.convertReference(t));
        tgt.setEmptyReason(VersionConvertor_10_40.convertCodeableConcept(src.getEmptyReason()));
        for (org.hl7.fhir.dstu2.model.Composition.SectionComponent t : src.getSection()) tgt.addSection(convertSectionComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Composition.SectionComponent convertSectionComponent(org.hl7.fhir.r4.model.Composition.SectionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Composition.SectionComponent tgt = new org.hl7.fhir.dstu2.model.Composition.SectionComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        tgt.setTitle(src.getTitle());
        tgt.setCode(VersionConvertor_10_40.convertCodeableConcept(src.getCode()));
        tgt.setText(VersionConvertor_10_40.convertNarrative(src.getText()));
        tgt.setMode(src.getMode().toCode());
        tgt.setOrderedBy(VersionConvertor_10_40.convertCodeableConcept(src.getOrderedBy()));
        for (org.hl7.fhir.r4.model.Reference t : src.getEntry()) tgt.addEntry(VersionConvertor_10_40.convertReference(t));
        tgt.setEmptyReason(VersionConvertor_10_40.convertCodeableConcept(src.getEmptyReason()));
        for (org.hl7.fhir.r4.model.Composition.SectionComponent t : src.getSection()) tgt.addSection(convertSectionComponent(t));
        return tgt;
    }
}
