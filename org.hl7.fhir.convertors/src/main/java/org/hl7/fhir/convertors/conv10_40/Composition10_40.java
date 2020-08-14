package org.hl7.fhir.convertors.conv10_40;

import org.hl7.fhir.convertors.VersionConvertor_10_40;
import org.hl7.fhir.exceptions.FHIRException;

import java.util.Collections;

public class Composition10_40 {

    public static org.hl7.fhir.dstu2.model.Composition convertComposition(org.hl7.fhir.r4.model.Composition src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Composition tgt = new org.hl7.fhir.dstu2.model.Composition();
        VersionConvertor_10_40.copyDomainResource(src, tgt);
        if (src.hasIdentifier())
            tgt.setIdentifier(VersionConvertor_10_40.convertIdentifier(src.getIdentifier()));
        if (src.hasDate())
            tgt.setDateElement(VersionConvertor_10_40.convertDateTime(src.getDateElement()));
        if (src.hasType())
            tgt.setType(VersionConvertor_10_40.convertCodeableConcept(src.getType()));
        if (src.hasCategory())
            tgt.setClass_(VersionConvertor_10_40.convertCodeableConcept(src.getCategoryFirstRep()));
        if (src.hasTitleElement())
            tgt.setTitleElement(VersionConvertor_10_40.convertString(src.getTitleElement()));
        if (src.hasStatus())
            tgt.setStatusElement(convertCompositionStatus(src.getStatusElement()));
        tgt.setConfidentiality(src.getConfidentiality().toCode());
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_10_40.convertReference(src.getSubject()));
        for (org.hl7.fhir.r4.model.Reference t : src.getAuthor()) tgt.addAuthor(VersionConvertor_10_40.convertReference(t));
        for (org.hl7.fhir.r4.model.Composition.CompositionAttesterComponent t : src.getAttester()) tgt.addAttester(convertCompositionAttesterComponent(t));
        if (src.hasCustodian())
            tgt.setCustodian(VersionConvertor_10_40.convertReference(src.getCustodian()));
        for (org.hl7.fhir.r4.model.Composition.CompositionEventComponent t : src.getEvent()) tgt.addEvent(convertCompositionEventComponent(t));
        if (src.hasEncounter())
            tgt.setEncounter(VersionConvertor_10_40.convertReference(src.getEncounter()));
        for (org.hl7.fhir.r4.model.Composition.SectionComponent t : src.getSection()) tgt.addSection(convertSectionComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Composition convertComposition(org.hl7.fhir.dstu2.model.Composition src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Composition tgt = new org.hl7.fhir.r4.model.Composition();
        VersionConvertor_10_40.copyDomainResource(src, tgt);
        if (src.hasIdentifier())
            tgt.setIdentifier(VersionConvertor_10_40.convertIdentifier(src.getIdentifier()));
        if (src.hasDate())
            tgt.setDateElement(VersionConvertor_10_40.convertDateTime(src.getDateElement()));
        if (src.hasType())
            tgt.setType(VersionConvertor_10_40.convertCodeableConcept(src.getType()));
        if (src.hasClass_())
            tgt.addCategory(VersionConvertor_10_40.convertCodeableConcept(src.getClass_()));
        if (src.hasTitleElement())
            tgt.setTitleElement(VersionConvertor_10_40.convertString(src.getTitleElement()));
        if (src.hasStatus())
            tgt.setStatusElement(convertCompositionStatus(src.getStatusElement()));
        try {
            if (src.hasConfidentiality())
                tgt.setConfidentiality(org.hl7.fhir.r4.model.Composition.DocumentConfidentiality.fromCode(src.getConfidentiality()));
        } catch (org.hl7.fhir.exceptions.FHIRException e) {
            throw new FHIRException(e);
        }
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_10_40.convertReference(src.getSubject()));
        for (org.hl7.fhir.dstu2.model.Reference t : src.getAuthor()) tgt.addAuthor(VersionConvertor_10_40.convertReference(t));
        for (org.hl7.fhir.dstu2.model.Composition.CompositionAttesterComponent t : src.getAttester()) tgt.addAttester(convertCompositionAttesterComponent(t));
        if (src.hasCustodian())
            tgt.setCustodian(VersionConvertor_10_40.convertReference(src.getCustodian()));
        for (org.hl7.fhir.dstu2.model.Composition.CompositionEventComponent t : src.getEvent()) tgt.addEvent(convertCompositionEventComponent(t));
        if (src.hasEncounter())
            tgt.setEncounter(VersionConvertor_10_40.convertReference(src.getEncounter()));
        for (org.hl7.fhir.dstu2.model.Composition.SectionComponent t : src.getSection()) tgt.addSection(convertSectionComponent(t));
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Composition.CompositionAttestationMode> convertCompositionAttestationMode(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Composition.CompositionAttestationMode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Composition.CompositionAttestationMode> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Composition.CompositionAttestationModeEnumFactory());
        VersionConvertor_10_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case PERSONAL:
                tgt.setValue(org.hl7.fhir.r4.model.Composition.CompositionAttestationMode.PERSONAL);
                break;
            case PROFESSIONAL:
                tgt.setValue(org.hl7.fhir.r4.model.Composition.CompositionAttestationMode.PROFESSIONAL);
                break;
            case LEGAL:
                tgt.setValue(org.hl7.fhir.r4.model.Composition.CompositionAttestationMode.LEGAL);
                break;
            case OFFICIAL:
                tgt.setValue(org.hl7.fhir.r4.model.Composition.CompositionAttestationMode.OFFICIAL);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.Composition.CompositionAttestationMode.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Composition.CompositionAttestationMode> convertCompositionAttestationMode(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Composition.CompositionAttestationMode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Composition.CompositionAttestationMode> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Composition.CompositionAttestationModeEnumFactory());
        VersionConvertor_10_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case PERSONAL:
                tgt.setValue(org.hl7.fhir.dstu2.model.Composition.CompositionAttestationMode.PERSONAL);
                break;
            case PROFESSIONAL:
                tgt.setValue(org.hl7.fhir.dstu2.model.Composition.CompositionAttestationMode.PROFESSIONAL);
                break;
            case LEGAL:
                tgt.setValue(org.hl7.fhir.dstu2.model.Composition.CompositionAttestationMode.LEGAL);
                break;
            case OFFICIAL:
                tgt.setValue(org.hl7.fhir.dstu2.model.Composition.CompositionAttestationMode.OFFICIAL);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2.model.Composition.CompositionAttestationMode.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Composition.CompositionAttesterComponent convertCompositionAttesterComponent(org.hl7.fhir.r4.model.Composition.CompositionAttesterComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Composition.CompositionAttesterComponent tgt = new org.hl7.fhir.dstu2.model.Composition.CompositionAttesterComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        if (src.hasMode())
            tgt.setMode(Collections.singletonList(convertCompositionAttestationMode(src.getModeElement())));
        if (src.hasTimeElement())
            tgt.setTimeElement(VersionConvertor_10_40.convertDateTime(src.getTimeElement()));
        if (src.hasParty())
            tgt.setParty(VersionConvertor_10_40.convertReference(src.getParty()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Composition.CompositionAttesterComponent convertCompositionAttesterComponent(org.hl7.fhir.dstu2.model.Composition.CompositionAttesterComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Composition.CompositionAttesterComponent tgt = new org.hl7.fhir.r4.model.Composition.CompositionAttesterComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        if (src.hasMode())
            tgt.setModeElement(convertCompositionAttestationMode(src.getMode().get(0)));
        if (src.hasTimeElement())
            tgt.setTimeElement(VersionConvertor_10_40.convertDateTime(src.getTimeElement()));
        if (src.hasParty())
            tgt.setParty(VersionConvertor_10_40.convertReference(src.getParty()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Composition.CompositionEventComponent convertCompositionEventComponent(org.hl7.fhir.r4.model.Composition.CompositionEventComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Composition.CompositionEventComponent tgt = new org.hl7.fhir.dstu2.model.Composition.CompositionEventComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCode()) tgt.addCode(VersionConvertor_10_40.convertCodeableConcept(t));
        if (src.hasPeriod())
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
        if (src.hasPeriod())
            tgt.setPeriod(VersionConvertor_10_40.convertPeriod(src.getPeriod()));
        for (org.hl7.fhir.dstu2.model.Reference t : src.getDetail()) tgt.addDetail(VersionConvertor_10_40.convertReference(t));
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Composition.CompositionStatus> convertCompositionStatus(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Composition.CompositionStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Composition.CompositionStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Composition.CompositionStatusEnumFactory());
        VersionConvertor_10_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case PRELIMINARY:
                tgt.setValue(org.hl7.fhir.r4.model.Composition.CompositionStatus.PRELIMINARY);
                break;
            case FINAL:
                tgt.setValue(org.hl7.fhir.r4.model.Composition.CompositionStatus.FINAL);
                break;
            case AMENDED:
                tgt.setValue(org.hl7.fhir.r4.model.Composition.CompositionStatus.AMENDED);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.r4.model.Composition.CompositionStatus.ENTEREDINERROR);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.Composition.CompositionStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Composition.CompositionStatus> convertCompositionStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Composition.CompositionStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Composition.CompositionStatus> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Composition.CompositionStatusEnumFactory());
        VersionConvertor_10_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case PRELIMINARY:
                tgt.setValue(org.hl7.fhir.dstu2.model.Composition.CompositionStatus.PRELIMINARY);
                break;
            case FINAL:
                tgt.setValue(org.hl7.fhir.dstu2.model.Composition.CompositionStatus.FINAL);
                break;
            case AMENDED:
                tgt.setValue(org.hl7.fhir.dstu2.model.Composition.CompositionStatus.AMENDED);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.dstu2.model.Composition.CompositionStatus.ENTEREDINERROR);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2.model.Composition.CompositionStatus.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Composition.SectionComponent convertSectionComponent(org.hl7.fhir.dstu2.model.Composition.SectionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Composition.SectionComponent tgt = new org.hl7.fhir.r4.model.Composition.SectionComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        if (src.hasTitleElement())
            tgt.setTitleElement(VersionConvertor_10_40.convertString(src.getTitleElement()));
        if (src.hasCode())
            tgt.setCode(VersionConvertor_10_40.convertCodeableConcept(src.getCode()));
        if (src.hasText())
            tgt.setText(VersionConvertor_10_40.convertNarrative(src.getText()));
        try {
            if (src.hasMode())
                tgt.setMode(org.hl7.fhir.r4.model.Composition.SectionMode.fromCode(src.getMode()));
        } catch (org.hl7.fhir.exceptions.FHIRException e) {
            throw new FHIRException(e);
        }
        if (src.hasOrderedBy())
            tgt.setOrderedBy(VersionConvertor_10_40.convertCodeableConcept(src.getOrderedBy()));
        for (org.hl7.fhir.dstu2.model.Reference t : src.getEntry()) tgt.addEntry(VersionConvertor_10_40.convertReference(t));
        if (src.hasEmptyReason())
            tgt.setEmptyReason(VersionConvertor_10_40.convertCodeableConcept(src.getEmptyReason()));
        for (org.hl7.fhir.dstu2.model.Composition.SectionComponent t : src.getSection()) tgt.addSection(convertSectionComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Composition.SectionComponent convertSectionComponent(org.hl7.fhir.r4.model.Composition.SectionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Composition.SectionComponent tgt = new org.hl7.fhir.dstu2.model.Composition.SectionComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        if (src.hasTitleElement())
            tgt.setTitleElement(VersionConvertor_10_40.convertString(src.getTitleElement()));
        if (src.hasCode())
            tgt.setCode(VersionConvertor_10_40.convertCodeableConcept(src.getCode()));
        if (src.hasText())
            tgt.setText(VersionConvertor_10_40.convertNarrative(src.getText()));
        tgt.setMode(src.getMode().toCode());
        if (src.hasOrderedBy())
            tgt.setOrderedBy(VersionConvertor_10_40.convertCodeableConcept(src.getOrderedBy()));
        for (org.hl7.fhir.r4.model.Reference t : src.getEntry()) tgt.addEntry(VersionConvertor_10_40.convertReference(t));
        if (src.hasEmptyReason())
            tgt.setEmptyReason(VersionConvertor_10_40.convertCodeableConcept(src.getEmptyReason()));
        for (org.hl7.fhir.r4.model.Composition.SectionComponent t : src.getSection()) tgt.addSection(convertSectionComponent(t));
        return tgt;
    }
}