package org.hl7.fhir.convertors.conv30_50;

import org.hl7.fhir.convertors.VersionConvertor_30_50;
import org.hl7.fhir.exceptions.FHIRException;

import java.util.Collections;

public class Composition30_50 {

    public static org.hl7.fhir.r5.model.Composition convertComposition(org.hl7.fhir.dstu3.model.Composition src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Composition tgt = new org.hl7.fhir.r5.model.Composition();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        if (src.hasIdentifier())
            tgt.setIdentifier(VersionConvertor_30_50.convertIdentifier(src.getIdentifier()));
        if (src.hasStatus())
            tgt.setStatusElement(convertCompositionStatus(src.getStatusElement()));
        if (src.hasType())
            tgt.setType(VersionConvertor_30_50.convertCodeableConcept(src.getType()));
        if (src.hasClass_())
            tgt.addCategory(VersionConvertor_30_50.convertCodeableConcept(src.getClass_()));
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_30_50.convertReference(src.getSubject()));
        if (src.hasEncounter())
            tgt.setEncounter(VersionConvertor_30_50.convertReference(src.getEncounter()));
        if (src.hasDate())
            tgt.setDateElement(VersionConvertor_30_50.convertDateTime(src.getDateElement()));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getAuthor()) tgt.addAuthor(VersionConvertor_30_50.convertReference(t));
        if (src.hasTitle())
            tgt.setTitleElement(VersionConvertor_30_50.convertString(src.getTitleElement()));
        if (src.hasConfidentiality())
            tgt.setConfidentialityElement(convertDocumentConfidentiality(src.getConfidentialityElement()));
        for (org.hl7.fhir.dstu3.model.Composition.CompositionAttesterComponent t : src.getAttester()) tgt.addAttester(convertCompositionAttesterComponent(t));
        if (src.hasCustodian())
            tgt.setCustodian(VersionConvertor_30_50.convertReference(src.getCustodian()));
        for (org.hl7.fhir.dstu3.model.Composition.CompositionRelatesToComponent t : src.getRelatesTo()) tgt.addRelatesTo(convertCompositionRelatesToComponent(t));
        for (org.hl7.fhir.dstu3.model.Composition.CompositionEventComponent t : src.getEvent()) tgt.addEvent(convertCompositionEventComponent(t));
        for (org.hl7.fhir.dstu3.model.Composition.SectionComponent t : src.getSection()) tgt.addSection(convertSectionComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Composition convertComposition(org.hl7.fhir.r5.model.Composition src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Composition tgt = new org.hl7.fhir.dstu3.model.Composition();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        if (src.hasIdentifier())
            tgt.setIdentifier(VersionConvertor_30_50.convertIdentifier(src.getIdentifier()));
        if (src.hasStatus())
            tgt.setStatusElement(convertCompositionStatus(src.getStatusElement()));
        if (src.hasType())
            tgt.setType(VersionConvertor_30_50.convertCodeableConcept(src.getType()));
        if (src.hasCategory())
            tgt.setClass_(VersionConvertor_30_50.convertCodeableConcept(src.getCategoryFirstRep()));
        if (src.hasSubject())
            tgt.setSubject(VersionConvertor_30_50.convertReference(src.getSubject()));
        if (src.hasEncounter())
            tgt.setEncounter(VersionConvertor_30_50.convertReference(src.getEncounter()));
        if (src.hasDate())
            tgt.setDateElement(VersionConvertor_30_50.convertDateTime(src.getDateElement()));
        for (org.hl7.fhir.r5.model.Reference t : src.getAuthor()) tgt.addAuthor(VersionConvertor_30_50.convertReference(t));
        if (src.hasTitle())
            tgt.setTitleElement(VersionConvertor_30_50.convertString(src.getTitleElement()));
        if (src.hasConfidentiality())
            tgt.setConfidentialityElement(convertDocumentConfidentiality(src.getConfidentialityElement()));
        for (org.hl7.fhir.r5.model.Composition.CompositionAttesterComponent t : src.getAttester()) tgt.addAttester(convertCompositionAttesterComponent(t));
        if (src.hasCustodian())
            tgt.setCustodian(VersionConvertor_30_50.convertReference(src.getCustodian()));
        for (org.hl7.fhir.r5.model.Composition.CompositionRelatesToComponent t : src.getRelatesTo()) tgt.addRelatesTo(convertCompositionRelatesToComponent(t));
        for (org.hl7.fhir.r5.model.Composition.CompositionEventComponent t : src.getEvent()) tgt.addEvent(convertCompositionEventComponent(t));
        for (org.hl7.fhir.r5.model.Composition.SectionComponent t : src.getSection()) tgt.addSection(convertSectionComponent(t));
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Composition.CompositionAttestationMode> convertCompositionAttestationMode(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Composition.CompositionAttestationMode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Composition.CompositionAttestationMode> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Composition.CompositionAttestationModeEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case PERSONAL:
                tgt.setValue(org.hl7.fhir.dstu3.model.Composition.CompositionAttestationMode.PERSONAL);
                break;
            case PROFESSIONAL:
                tgt.setValue(org.hl7.fhir.dstu3.model.Composition.CompositionAttestationMode.PROFESSIONAL);
                break;
            case LEGAL:
                tgt.setValue(org.hl7.fhir.dstu3.model.Composition.CompositionAttestationMode.LEGAL);
                break;
            case OFFICIAL:
                tgt.setValue(org.hl7.fhir.dstu3.model.Composition.CompositionAttestationMode.OFFICIAL);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.Composition.CompositionAttestationMode.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Composition.CompositionAttestationMode> convertCompositionAttestationMode(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Composition.CompositionAttestationMode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Composition.CompositionAttestationMode> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Composition.CompositionAttestationModeEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case PERSONAL:
                tgt.setValue(org.hl7.fhir.r5.model.Composition.CompositionAttestationMode.PERSONAL);
                break;
            case PROFESSIONAL:
                tgt.setValue(org.hl7.fhir.r5.model.Composition.CompositionAttestationMode.PROFESSIONAL);
                break;
            case LEGAL:
                tgt.setValue(org.hl7.fhir.r5.model.Composition.CompositionAttestationMode.LEGAL);
                break;
            case OFFICIAL:
                tgt.setValue(org.hl7.fhir.r5.model.Composition.CompositionAttestationMode.OFFICIAL);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Composition.CompositionAttestationMode.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Composition.CompositionAttesterComponent convertCompositionAttesterComponent(org.hl7.fhir.dstu3.model.Composition.CompositionAttesterComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Composition.CompositionAttesterComponent tgt = new org.hl7.fhir.r5.model.Composition.CompositionAttesterComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasMode())
            tgt.setModeElement(convertCompositionAttestationMode(src.getMode().get(0)));
        if (src.hasTime())
            tgt.setTimeElement(VersionConvertor_30_50.convertDateTime(src.getTimeElement()));
        if (src.hasParty())
            tgt.setParty(VersionConvertor_30_50.convertReference(src.getParty()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Composition.CompositionAttesterComponent convertCompositionAttesterComponent(org.hl7.fhir.r5.model.Composition.CompositionAttesterComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Composition.CompositionAttesterComponent tgt = new org.hl7.fhir.dstu3.model.Composition.CompositionAttesterComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasMode())
            tgt.setMode(Collections.singletonList(convertCompositionAttestationMode(src.getModeElement())));
        if (src.hasTime())
            tgt.setTimeElement(VersionConvertor_30_50.convertDateTime(src.getTimeElement()));
        if (src.hasParty())
            tgt.setParty(VersionConvertor_30_50.convertReference(src.getParty()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Composition.CompositionEventComponent convertCompositionEventComponent(org.hl7.fhir.r5.model.Composition.CompositionEventComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Composition.CompositionEventComponent tgt = new org.hl7.fhir.dstu3.model.Composition.CompositionEventComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCode()) tgt.addCode(VersionConvertor_30_50.convertCodeableConcept(t));
        if (src.hasPeriod())
            tgt.setPeriod(VersionConvertor_30_50.convertPeriod(src.getPeriod()));
        for (org.hl7.fhir.r5.model.Reference t : src.getDetail()) tgt.addDetail(VersionConvertor_30_50.convertReference(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Composition.CompositionEventComponent convertCompositionEventComponent(org.hl7.fhir.dstu3.model.Composition.CompositionEventComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Composition.CompositionEventComponent tgt = new org.hl7.fhir.r5.model.Composition.CompositionEventComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getCode()) tgt.addCode(VersionConvertor_30_50.convertCodeableConcept(t));
        if (src.hasPeriod())
            tgt.setPeriod(VersionConvertor_30_50.convertPeriod(src.getPeriod()));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getDetail()) tgt.addDetail(VersionConvertor_30_50.convertReference(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Composition.CompositionRelatesToComponent convertCompositionRelatesToComponent(org.hl7.fhir.r5.model.Composition.CompositionRelatesToComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Composition.CompositionRelatesToComponent tgt = new org.hl7.fhir.dstu3.model.Composition.CompositionRelatesToComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCodeElement(convertDocumentRelationshipType(src.getCodeElement()));
        if (src.hasTarget())
            tgt.setTarget(VersionConvertor_30_50.convertType(src.getTarget()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Composition.CompositionRelatesToComponent convertCompositionRelatesToComponent(org.hl7.fhir.dstu3.model.Composition.CompositionRelatesToComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Composition.CompositionRelatesToComponent tgt = new org.hl7.fhir.r5.model.Composition.CompositionRelatesToComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCodeElement(convertDocumentRelationshipType(src.getCodeElement()));
        if (src.hasTarget())
            tgt.setTarget(VersionConvertor_30_50.convertType(src.getTarget()));
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Composition.DocumentRelationshipType> convertDocumentRelationshipType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.DocumentRelationshipType> src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Composition.DocumentRelationshipType> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Composition.DocumentRelationshipTypeEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case REPLACES:
                tgt.setValue(org.hl7.fhir.dstu3.model.Composition.DocumentRelationshipType.REPLACES);
                break;
            case TRANSFORMS:
                tgt.setValue(org.hl7.fhir.dstu3.model.Composition.DocumentRelationshipType.TRANSFORMS);
                break;
            case SIGNS:
                tgt.setValue(org.hl7.fhir.dstu3.model.Composition.DocumentRelationshipType.SIGNS);
                break;
            case APPENDS:
                tgt.setValue(org.hl7.fhir.dstu3.model.Composition.DocumentRelationshipType.APPENDS);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.Composition.DocumentRelationshipType.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.DocumentRelationshipType> convertDocumentRelationshipType(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Composition.DocumentRelationshipType> src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.DocumentRelationshipType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.DocumentRelationshipTypeEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case REPLACES:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DocumentRelationshipType.REPLACES);
                break;
            case TRANSFORMS:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DocumentRelationshipType.TRANSFORMS);
                break;
            case SIGNS:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DocumentRelationshipType.SIGNS);
                break;
            case APPENDS:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DocumentRelationshipType.APPENDS);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DocumentRelationshipType.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Composition.CompositionStatus> convertCompositionStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.CompositionStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Composition.CompositionStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Composition.CompositionStatusEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case PRELIMINARY:
                tgt.setValue(org.hl7.fhir.dstu3.model.Composition.CompositionStatus.PRELIMINARY);
                break;
            case FINAL:
                tgt.setValue(org.hl7.fhir.dstu3.model.Composition.CompositionStatus.FINAL);
                break;
            case AMENDED:
                tgt.setValue(org.hl7.fhir.dstu3.model.Composition.CompositionStatus.AMENDED);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.dstu3.model.Composition.CompositionStatus.ENTEREDINERROR);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.Composition.CompositionStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.CompositionStatus> convertCompositionStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Composition.CompositionStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.CompositionStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.CompositionStatusEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case PRELIMINARY:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.CompositionStatus.PRELIMINARY);
                break;
            case FINAL:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.CompositionStatus.FINAL);
                break;
            case AMENDED:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.CompositionStatus.AMENDED);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.CompositionStatus.ENTEREDINERROR);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.CompositionStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Composition.V3ConfidentialityClassification> convertDocumentConfidentiality(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Composition.DocumentConfidentiality> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Composition.V3ConfidentialityClassification> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Composition.V3ConfidentialityClassificationEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case U:
                tgt.setValue(org.hl7.fhir.r5.model.Composition.V3ConfidentialityClassification.U);
                break;
            case L:
                tgt.setValue(org.hl7.fhir.r5.model.Composition.V3ConfidentialityClassification.L);
                break;
            case M:
                tgt.setValue(org.hl7.fhir.r5.model.Composition.V3ConfidentialityClassification.M);
                break;
            case N:
                tgt.setValue(org.hl7.fhir.r5.model.Composition.V3ConfidentialityClassification.N);
                break;
            case R:
                tgt.setValue(org.hl7.fhir.r5.model.Composition.V3ConfidentialityClassification.R);
                break;
            case V:
                tgt.setValue(org.hl7.fhir.r5.model.Composition.V3ConfidentialityClassification.V);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Composition.V3ConfidentialityClassification.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Composition.DocumentConfidentiality> convertDocumentConfidentiality(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Composition.V3ConfidentialityClassification> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Composition.DocumentConfidentiality> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Composition.DocumentConfidentialityEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case U:
                tgt.setValue(org.hl7.fhir.dstu3.model.Composition.DocumentConfidentiality.U);
                break;
            case L:
                tgt.setValue(org.hl7.fhir.dstu3.model.Composition.DocumentConfidentiality.L);
                break;
            case M:
                tgt.setValue(org.hl7.fhir.dstu3.model.Composition.DocumentConfidentiality.M);
                break;
            case N:
                tgt.setValue(org.hl7.fhir.dstu3.model.Composition.DocumentConfidentiality.N);
                break;
            case R:
                tgt.setValue(org.hl7.fhir.dstu3.model.Composition.DocumentConfidentiality.R);
                break;
            case V:
                tgt.setValue(org.hl7.fhir.dstu3.model.Composition.DocumentConfidentiality.V);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.Composition.DocumentConfidentiality.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Composition.SectionComponent convertSectionComponent(org.hl7.fhir.r5.model.Composition.SectionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Composition.SectionComponent tgt = new org.hl7.fhir.dstu3.model.Composition.SectionComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasTitle())
            tgt.setTitleElement(VersionConvertor_30_50.convertString(src.getTitleElement()));
        if (src.hasCode())
            tgt.setCode(VersionConvertor_30_50.convertCodeableConcept(src.getCode()));
        if (src.hasText())
            tgt.setText(VersionConvertor_30_50.convertNarrative(src.getText()));
        if (src.hasMode())
            tgt.setModeElement(convertSectionMode(src.getModeElement()));
        if (src.hasOrderedBy())
            tgt.setOrderedBy(VersionConvertor_30_50.convertCodeableConcept(src.getOrderedBy()));
        for (org.hl7.fhir.r5.model.Reference t : src.getEntry()) tgt.addEntry(VersionConvertor_30_50.convertReference(t));
        if (src.hasEmptyReason())
            tgt.setEmptyReason(VersionConvertor_30_50.convertCodeableConcept(src.getEmptyReason()));
        for (org.hl7.fhir.r5.model.Composition.SectionComponent t : src.getSection()) tgt.addSection(convertSectionComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Composition.SectionComponent convertSectionComponent(org.hl7.fhir.dstu3.model.Composition.SectionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Composition.SectionComponent tgt = new org.hl7.fhir.r5.model.Composition.SectionComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasTitle())
            tgt.setTitleElement(VersionConvertor_30_50.convertString(src.getTitleElement()));
        if (src.hasCode())
            tgt.setCode(VersionConvertor_30_50.convertCodeableConcept(src.getCode()));
        if (src.hasText())
            tgt.setText(VersionConvertor_30_50.convertNarrative(src.getText()));
        if (src.hasMode())
            tgt.setModeElement(convertSectionMode(src.getModeElement()));
        if (src.hasOrderedBy())
            tgt.setOrderedBy(VersionConvertor_30_50.convertCodeableConcept(src.getOrderedBy()));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getEntry()) tgt.addEntry(VersionConvertor_30_50.convertReference(t));
        if (src.hasEmptyReason())
            tgt.setEmptyReason(VersionConvertor_30_50.convertCodeableConcept(src.getEmptyReason()));
        for (org.hl7.fhir.dstu3.model.Composition.SectionComponent t : src.getSection()) tgt.addSection(convertSectionComponent(t));
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Composition.SectionMode> convertSectionMode(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ListMode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Composition.SectionMode> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Composition.SectionModeEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case WORKING:
                tgt.setValue(org.hl7.fhir.dstu3.model.Composition.SectionMode.WORKING);
                break;
            case SNAPSHOT:
                tgt.setValue(org.hl7.fhir.dstu3.model.Composition.SectionMode.SNAPSHOT);
                break;
            case CHANGES:
                tgt.setValue(org.hl7.fhir.dstu3.model.Composition.SectionMode.CHANGES);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.Composition.SectionMode.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ListMode> convertSectionMode(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Composition.SectionMode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ListMode> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.ListModeEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case WORKING:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ListMode.WORKING);
                break;
            case SNAPSHOT:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ListMode.SNAPSHOT);
                break;
            case CHANGES:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ListMode.CHANGES);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ListMode.NULL);
                break;
        }
        return tgt;
    }
}