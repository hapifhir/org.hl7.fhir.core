package org.hl7.fhir.convertors.conv30_40;

import org.hl7.fhir.convertors.VersionConvertor_30_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Composition30_40 {

    public static org.hl7.fhir.dstu3.model.Composition convertComposition(org.hl7.fhir.r4.model.Composition src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Composition tgt = new org.hl7.fhir.dstu3.model.Composition();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        if (src.hasIdentifier())
            tgt.setIdentifier(VersionConvertor_30_40.convertIdentifier(src.getIdentifier()));
        if (src.hasStatus())
            tgt.setStatus(convertCompositionStatus(src.getStatus()));
        if (src.hasType())
            tgt.setType(VersionConvertor_30_40.convertCodeableConcept(src.getType()));
        if (src.hasCategory())
            tgt.setClass_(VersionConvertor_30_40.convertCodeableConcept(src.getCategoryFirstRep()));
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_30_40.convertReference(src.getSubject()));
        if (src.hasEncounter())
            tgt.setEncounter(VersionConvertor_30_40.convertReference(src.getEncounter()));
        if (src.hasDateElement())
            tgt.setDateElement(VersionConvertor_30_40.convertDateTime(src.getDateElement()));
        if (src.hasAuthor()) {
            for (org.hl7.fhir.r4.model.Reference t : src.getAuthor()) tgt.addAuthor(VersionConvertor_30_40.convertReference(t));
        }
        if (src.hasTitle())
            tgt.setTitle(src.getTitle());
        if (src.hasConfidentiality())
            tgt.setConfidentiality(convertDocumentConfidentiality(src.getConfidentiality()));
        if (src.hasAttester()) {
            for (org.hl7.fhir.r4.model.Composition.CompositionAttesterComponent t : src.getAttester()) tgt.addAttester(convertCompositionAttesterComponent(t));
        }
        if (src.hasCustodian())
            tgt.setCustodian(VersionConvertor_30_40.convertReference(src.getCustodian()));
        if (src.hasRelatesTo()) {
            for (org.hl7.fhir.r4.model.Composition.CompositionRelatesToComponent t : src.getRelatesTo()) tgt.addRelatesTo(convertCompositionRelatesToComponent(t));
        }
        if (src.hasEvent()) {
            for (org.hl7.fhir.r4.model.Composition.CompositionEventComponent t : src.getEvent()) tgt.addEvent(convertCompositionEventComponent(t));
        }
        if (src.hasSection()) {
            for (org.hl7.fhir.r4.model.Composition.SectionComponent t : src.getSection()) tgt.addSection(convertSectionComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Composition convertComposition(org.hl7.fhir.dstu3.model.Composition src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Composition tgt = new org.hl7.fhir.r4.model.Composition();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        if (src.hasIdentifier())
            tgt.setIdentifier(VersionConvertor_30_40.convertIdentifier(src.getIdentifier()));
        if (src.hasStatus())
            tgt.setStatus(convertCompositionStatus(src.getStatus()));
        if (src.hasType())
            tgt.setType(VersionConvertor_30_40.convertCodeableConcept(src.getType()));
        if (src.hasClass_())
            tgt.addCategory(VersionConvertor_30_40.convertCodeableConcept(src.getClass_()));
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_30_40.convertReference(src.getSubject()));
        if (src.hasEncounter())
            tgt.setEncounter(VersionConvertor_30_40.convertReference(src.getEncounter()));
        if (src.hasDateElement())
            tgt.setDateElement(VersionConvertor_30_40.convertDateTime(src.getDateElement()));
        if (src.hasAuthor()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getAuthor()) tgt.addAuthor(VersionConvertor_30_40.convertReference(t));
        }
        if (src.hasTitle())
            tgt.setTitle(src.getTitle());
        if (src.hasConfidentiality())
            tgt.setConfidentiality(convertDocumentConfidentiality(src.getConfidentiality()));
        if (src.hasAttester()) {
            for (org.hl7.fhir.dstu3.model.Composition.CompositionAttesterComponent t : src.getAttester()) tgt.addAttester(convertCompositionAttesterComponent(t));
        }
        if (src.hasCustodian())
            tgt.setCustodian(VersionConvertor_30_40.convertReference(src.getCustodian()));
        if (src.hasRelatesTo()) {
            for (org.hl7.fhir.dstu3.model.Composition.CompositionRelatesToComponent t : src.getRelatesTo()) tgt.addRelatesTo(convertCompositionRelatesToComponent(t));
        }
        if (src.hasEvent()) {
            for (org.hl7.fhir.dstu3.model.Composition.CompositionEventComponent t : src.getEvent()) tgt.addEvent(convertCompositionEventComponent(t));
        }
        if (src.hasSection()) {
            for (org.hl7.fhir.dstu3.model.Composition.SectionComponent t : src.getSection()) tgt.addSection(convertSectionComponent(t));
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Composition.CompositionAttestationMode convertCompositionAttestationMode(org.hl7.fhir.r4.model.Composition.CompositionAttestationMode src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case PERSONAL:
                return org.hl7.fhir.dstu3.model.Composition.CompositionAttestationMode.PERSONAL;
            case PROFESSIONAL:
                return org.hl7.fhir.dstu3.model.Composition.CompositionAttestationMode.PROFESSIONAL;
            case LEGAL:
                return org.hl7.fhir.dstu3.model.Composition.CompositionAttestationMode.LEGAL;
            case OFFICIAL:
                return org.hl7.fhir.dstu3.model.Composition.CompositionAttestationMode.OFFICIAL;
            default:
                return org.hl7.fhir.dstu3.model.Composition.CompositionAttestationMode.NULL;
        }
    }

    static public org.hl7.fhir.r4.model.Composition.CompositionAttestationMode convertCompositionAttestationMode(org.hl7.fhir.dstu3.model.Composition.CompositionAttestationMode src) throws FHIRException {
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

    public static org.hl7.fhir.dstu3.model.Composition.CompositionAttesterComponent convertCompositionAttesterComponent(org.hl7.fhir.r4.model.Composition.CompositionAttesterComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Composition.CompositionAttesterComponent tgt = new org.hl7.fhir.dstu3.model.Composition.CompositionAttesterComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasMode())
            tgt.addMode(convertCompositionAttestationMode(src.getMode()));
        if (src.hasTime())
            tgt.setTimeElement(VersionConvertor_30_40.convertDateTime(src.getTimeElement()));
        if (src.hasParty())
            tgt.setParty(VersionConvertor_30_40.convertReference(src.getParty()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Composition.CompositionAttesterComponent convertCompositionAttesterComponent(org.hl7.fhir.dstu3.model.Composition.CompositionAttesterComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Composition.CompositionAttesterComponent tgt = new org.hl7.fhir.r4.model.Composition.CompositionAttesterComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasMode())
            tgt.setMode(convertCompositionAttestationMode(src.getMode().get(0).getValue()));
        if (src.hasTime())
            tgt.setTimeElement(VersionConvertor_30_40.convertDateTime(src.getTimeElement()));
        if (src.hasParty())
            tgt.setParty(VersionConvertor_30_40.convertReference(src.getParty()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Composition.CompositionEventComponent convertCompositionEventComponent(org.hl7.fhir.dstu3.model.Composition.CompositionEventComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Composition.CompositionEventComponent tgt = new org.hl7.fhir.r4.model.Composition.CompositionEventComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasCode()) {
            for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getCode()) tgt.addCode(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        if (src.hasPeriod())
            tgt.setPeriod(VersionConvertor_30_40.convertPeriod(src.getPeriod()));
        if (src.hasDetail()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getDetail()) tgt.addDetail(VersionConvertor_30_40.convertReference(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Composition.CompositionEventComponent convertCompositionEventComponent(org.hl7.fhir.r4.model.Composition.CompositionEventComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Composition.CompositionEventComponent tgt = new org.hl7.fhir.dstu3.model.Composition.CompositionEventComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasCode()) {
            for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCode()) tgt.addCode(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        if (src.hasPeriod())
            tgt.setPeriod(VersionConvertor_30_40.convertPeriod(src.getPeriod()));
        if (src.hasDetail()) {
            for (org.hl7.fhir.r4.model.Reference t : src.getDetail()) tgt.addDetail(VersionConvertor_30_40.convertReference(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Composition.CompositionRelatesToComponent convertCompositionRelatesToComponent(org.hl7.fhir.dstu3.model.Composition.CompositionRelatesToComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Composition.CompositionRelatesToComponent tgt = new org.hl7.fhir.r4.model.Composition.CompositionRelatesToComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCode(VersionConvertor_30_40.convertDocumentRelationshipType(src.getCode()));
        if (src.hasTarget())
            tgt.setTarget(VersionConvertor_30_40.convertType(src.getTarget()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Composition.CompositionRelatesToComponent convertCompositionRelatesToComponent(org.hl7.fhir.r4.model.Composition.CompositionRelatesToComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Composition.CompositionRelatesToComponent tgt = new org.hl7.fhir.dstu3.model.Composition.CompositionRelatesToComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCode(VersionConvertor_30_40.convertDocumentRelationshipType(src.getCode()));
        if (src.hasTarget())
            tgt.setTarget(VersionConvertor_30_40.convertType(src.getTarget()));
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Composition.CompositionStatus convertCompositionStatus(org.hl7.fhir.dstu3.model.Composition.CompositionStatus src) throws FHIRException {
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

    static public org.hl7.fhir.dstu3.model.Composition.CompositionStatus convertCompositionStatus(org.hl7.fhir.r4.model.Composition.CompositionStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case PRELIMINARY:
                return org.hl7.fhir.dstu3.model.Composition.CompositionStatus.PRELIMINARY;
            case FINAL:
                return org.hl7.fhir.dstu3.model.Composition.CompositionStatus.FINAL;
            case AMENDED:
                return org.hl7.fhir.dstu3.model.Composition.CompositionStatus.AMENDED;
            case ENTEREDINERROR:
                return org.hl7.fhir.dstu3.model.Composition.CompositionStatus.ENTEREDINERROR;
            default:
                return org.hl7.fhir.dstu3.model.Composition.CompositionStatus.NULL;
        }
    }

    static public org.hl7.fhir.r4.model.Composition.DocumentConfidentiality convertDocumentConfidentiality(org.hl7.fhir.dstu3.model.Composition.DocumentConfidentiality src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case U:
                return org.hl7.fhir.r4.model.Composition.DocumentConfidentiality.U;
            case L:
                return org.hl7.fhir.r4.model.Composition.DocumentConfidentiality.L;
            case M:
                return org.hl7.fhir.r4.model.Composition.DocumentConfidentiality.M;
            case N:
                return org.hl7.fhir.r4.model.Composition.DocumentConfidentiality.N;
            case R:
                return org.hl7.fhir.r4.model.Composition.DocumentConfidentiality.R;
            case V:
                return org.hl7.fhir.r4.model.Composition.DocumentConfidentiality.V;
            default:
                return org.hl7.fhir.r4.model.Composition.DocumentConfidentiality.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.Composition.DocumentConfidentiality convertDocumentConfidentiality(org.hl7.fhir.r4.model.Composition.DocumentConfidentiality src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case U:
                return org.hl7.fhir.dstu3.model.Composition.DocumentConfidentiality.U;
            case L:
                return org.hl7.fhir.dstu3.model.Composition.DocumentConfidentiality.L;
            case M:
                return org.hl7.fhir.dstu3.model.Composition.DocumentConfidentiality.M;
            case N:
                return org.hl7.fhir.dstu3.model.Composition.DocumentConfidentiality.N;
            case R:
                return org.hl7.fhir.dstu3.model.Composition.DocumentConfidentiality.R;
            case V:
                return org.hl7.fhir.dstu3.model.Composition.DocumentConfidentiality.V;
            default:
                return org.hl7.fhir.dstu3.model.Composition.DocumentConfidentiality.NULL;
        }
    }

    public static org.hl7.fhir.dstu3.model.Composition.SectionComponent convertSectionComponent(org.hl7.fhir.r4.model.Composition.SectionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Composition.SectionComponent tgt = new org.hl7.fhir.dstu3.model.Composition.SectionComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasTitle())
            tgt.setTitle(src.getTitle());
        if (src.hasCode())
            tgt.setCode(VersionConvertor_30_40.convertCodeableConcept(src.getCode()));
        if (src.hasText())
            tgt.setText(VersionConvertor_30_40.convertNarrative(src.getText()));
        if (src.hasMode())
            tgt.setMode(convertSectionMode(src.getMode()));
        if (src.hasOrderedBy())
            tgt.setOrderedBy(VersionConvertor_30_40.convertCodeableConcept(src.getOrderedBy()));
        if (src.hasEntry()) {
            for (org.hl7.fhir.r4.model.Reference t : src.getEntry()) tgt.addEntry(VersionConvertor_30_40.convertReference(t));
        }
        if (src.hasEmptyReason())
            tgt.setEmptyReason(VersionConvertor_30_40.convertCodeableConcept(src.getEmptyReason()));
        if (src.hasSection()) {
            for (org.hl7.fhir.r4.model.Composition.SectionComponent t : src.getSection()) tgt.addSection(convertSectionComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Composition.SectionComponent convertSectionComponent(org.hl7.fhir.dstu3.model.Composition.SectionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Composition.SectionComponent tgt = new org.hl7.fhir.r4.model.Composition.SectionComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasTitle())
            tgt.setTitle(src.getTitle());
        if (src.hasCode())
            tgt.setCode(VersionConvertor_30_40.convertCodeableConcept(src.getCode()));
        if (src.hasText())
            tgt.setText(VersionConvertor_30_40.convertNarrative(src.getText()));
        if (src.hasMode())
            tgt.setMode(convertSectionMode(src.getMode()));
        if (src.hasOrderedBy())
            tgt.setOrderedBy(VersionConvertor_30_40.convertCodeableConcept(src.getOrderedBy()));
        if (src.hasEntry()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getEntry()) tgt.addEntry(VersionConvertor_30_40.convertReference(t));
        }
        if (src.hasEmptyReason())
            tgt.setEmptyReason(VersionConvertor_30_40.convertCodeableConcept(src.getEmptyReason()));
        if (src.hasSection()) {
            for (org.hl7.fhir.dstu3.model.Composition.SectionComponent t : src.getSection()) tgt.addSection(convertSectionComponent(t));
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Composition.SectionMode convertSectionMode(org.hl7.fhir.dstu3.model.Composition.SectionMode src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case WORKING:
                return org.hl7.fhir.r4.model.Composition.SectionMode.WORKING;
            case SNAPSHOT:
                return org.hl7.fhir.r4.model.Composition.SectionMode.SNAPSHOT;
            case CHANGES:
                return org.hl7.fhir.r4.model.Composition.SectionMode.CHANGES;
            default:
                return org.hl7.fhir.r4.model.Composition.SectionMode.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.Composition.SectionMode convertSectionMode(org.hl7.fhir.r4.model.Composition.SectionMode src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case WORKING:
                return org.hl7.fhir.dstu3.model.Composition.SectionMode.WORKING;
            case SNAPSHOT:
                return org.hl7.fhir.dstu3.model.Composition.SectionMode.SNAPSHOT;
            case CHANGES:
                return org.hl7.fhir.dstu3.model.Composition.SectionMode.CHANGES;
            default:
                return org.hl7.fhir.dstu3.model.Composition.SectionMode.NULL;
        }
    }
}
