package org.hl7.fhir.convertors.conv40_50;


import org.hl7.fhir.convertors.VersionConvertor_40_50;
import org.hl7.fhir.exceptions.FHIRException;

/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.
  
  Redistribution and use in source and binary forms, with or without modification, 
  are permitted provided that the following conditions are met:
  
   * Redistributions of source code must retain the above copyright notice, this 
     list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright notice, 
     this list of conditions and the following disclaimer in the documentation 
     and/or other materials provided with the distribution.
   * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.
  
  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
  POSSIBILITY OF SUCH DAMAGE.
  
*/
// Generated on Sun, Feb 24, 2019 11:37+1100 for FHIR v4.0.0
public class Composition40_50 extends VersionConvertor_40_50 {

    public static org.hl7.fhir.r5.model.Composition convertComposition(org.hl7.fhir.r4.model.Composition src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Composition tgt = new org.hl7.fhir.r5.model.Composition();
        copyDomainResource(src, tgt);
        if (src.hasIdentifier())
            tgt.setIdentifier(convertIdentifier(src.getIdentifier()));
        if (src.hasStatus())
            tgt.setStatusElement(convertCompositionStatus(src.getStatusElement()));
        if (src.hasType())
            tgt.setType(convertCodeableConcept(src.getType()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCategory()) tgt.addCategory(convertCodeableConcept(t));
        if (src.hasSubject())
            tgt.setSubject(convertReference(src.getSubject()));
        if (src.hasEncounter())
            tgt.setEncounter(convertReference(src.getEncounter()));
        if (src.hasDate())
            tgt.setDateElement(convertDateTime(src.getDateElement()));
        for (org.hl7.fhir.r4.model.Reference t : src.getAuthor()) tgt.addAuthor(convertReference(t));
        if (src.hasTitle())
            tgt.setTitleElement(convertString(src.getTitleElement()));
        if (src.hasConfidentiality())
            tgt.setConfidentialityElement(convertDocumentConfidentiality(src.getConfidentialityElement()));
        for (org.hl7.fhir.r4.model.Composition.CompositionAttesterComponent t : src.getAttester()) tgt.addAttester(convertCompositionAttesterComponent(t));
        if (src.hasCustodian())
            tgt.setCustodian(convertReference(src.getCustodian()));
        for (org.hl7.fhir.r4.model.Composition.CompositionRelatesToComponent t : src.getRelatesTo()) tgt.addRelatesTo(convertCompositionRelatesToComponent(t));
        for (org.hl7.fhir.r4.model.Composition.CompositionEventComponent t : src.getEvent()) tgt.addEvent(convertCompositionEventComponent(t));
        for (org.hl7.fhir.r4.model.Composition.SectionComponent t : src.getSection()) tgt.addSection(convertSectionComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Composition convertComposition(org.hl7.fhir.r5.model.Composition src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Composition tgt = new org.hl7.fhir.r4.model.Composition();
        copyDomainResource(src, tgt);
        if (src.hasIdentifier())
            tgt.setIdentifier(convertIdentifier(src.getIdentifier()));
        if (src.hasStatus())
            tgt.setStatusElement(convertCompositionStatus(src.getStatusElement()));
        if (src.hasType())
            tgt.setType(convertCodeableConcept(src.getType()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCategory()) tgt.addCategory(convertCodeableConcept(t));
        if (src.hasSubject())
            tgt.setSubject(convertReference(src.getSubject()));
        if (src.hasEncounter())
            tgt.setEncounter(convertReference(src.getEncounter()));
        if (src.hasDate())
            tgt.setDateElement(convertDateTime(src.getDateElement()));
        for (org.hl7.fhir.r5.model.Reference t : src.getAuthor()) tgt.addAuthor(convertReference(t));
        if (src.hasTitle())
            tgt.setTitleElement(convertString(src.getTitleElement()));
        if (src.hasConfidentiality())
            tgt.setConfidentialityElement(convertDocumentConfidentiality(src.getConfidentialityElement()));
        for (org.hl7.fhir.r5.model.Composition.CompositionAttesterComponent t : src.getAttester()) tgt.addAttester(convertCompositionAttesterComponent(t));
        if (src.hasCustodian())
            tgt.setCustodian(convertReference(src.getCustodian()));
        for (org.hl7.fhir.r5.model.Composition.CompositionRelatesToComponent t : src.getRelatesTo()) tgt.addRelatesTo(convertCompositionRelatesToComponent(t));
        for (org.hl7.fhir.r5.model.Composition.CompositionEventComponent t : src.getEvent()) tgt.addEvent(convertCompositionEventComponent(t));
        for (org.hl7.fhir.r5.model.Composition.SectionComponent t : src.getSection()) tgt.addSection(convertSectionComponent(t));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.CompositionStatus> convertCompositionStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Composition.CompositionStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.CompositionStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.CompositionStatusEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
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

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Composition.CompositionStatus> convertCompositionStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.CompositionStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Composition.CompositionStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Composition.CompositionStatusEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
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

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Composition.V3ConfidentialityClassification> convertDocumentConfidentiality(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Composition.DocumentConfidentiality> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Composition.V3ConfidentialityClassification> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Composition.V3ConfidentialityClassificationEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
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

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Composition.DocumentConfidentiality> convertDocumentConfidentiality(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Composition.V3ConfidentialityClassification> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Composition.DocumentConfidentiality> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Composition.DocumentConfidentialityEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case U:
                tgt.setValue(org.hl7.fhir.r4.model.Composition.DocumentConfidentiality.U);
                break;
            case L:
                tgt.setValue(org.hl7.fhir.r4.model.Composition.DocumentConfidentiality.L);
                break;
            case M:
                tgt.setValue(org.hl7.fhir.r4.model.Composition.DocumentConfidentiality.M);
                break;
            case N:
                tgt.setValue(org.hl7.fhir.r4.model.Composition.DocumentConfidentiality.N);
                break;
            case R:
                tgt.setValue(org.hl7.fhir.r4.model.Composition.DocumentConfidentiality.R);
                break;
            case V:
                tgt.setValue(org.hl7.fhir.r4.model.Composition.DocumentConfidentiality.V);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.Composition.DocumentConfidentiality.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Composition.CompositionAttesterComponent convertCompositionAttesterComponent(org.hl7.fhir.r4.model.Composition.CompositionAttesterComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Composition.CompositionAttesterComponent tgt = new org.hl7.fhir.r5.model.Composition.CompositionAttesterComponent();
        copyElement(src, tgt);
        if (src.hasMode())
            tgt.setModeElement(convertCompositionAttestationMode(src.getModeElement()));
        if (src.hasTime())
            tgt.setTimeElement(convertDateTime(src.getTimeElement()));
        if (src.hasParty())
            tgt.setParty(convertReference(src.getParty()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Composition.CompositionAttesterComponent convertCompositionAttesterComponent(org.hl7.fhir.r5.model.Composition.CompositionAttesterComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Composition.CompositionAttesterComponent tgt = new org.hl7.fhir.r4.model.Composition.CompositionAttesterComponent();
        copyElement(src, tgt);
        if (src.hasMode())
            tgt.setModeElement(convertCompositionAttestationMode(src.getModeElement()));
        if (src.hasTime())
            tgt.setTimeElement(convertDateTime(src.getTimeElement()));
        if (src.hasParty())
            tgt.setParty(convertReference(src.getParty()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Composition.CompositionAttestationMode> convertCompositionAttestationMode(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Composition.CompositionAttestationMode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Composition.CompositionAttestationMode> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Composition.CompositionAttestationModeEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
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

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Composition.CompositionAttestationMode> convertCompositionAttestationMode(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Composition.CompositionAttestationMode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Composition.CompositionAttestationMode> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Composition.CompositionAttestationModeEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
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

    public static org.hl7.fhir.r5.model.Composition.CompositionRelatesToComponent convertCompositionRelatesToComponent(org.hl7.fhir.r4.model.Composition.CompositionRelatesToComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Composition.CompositionRelatesToComponent tgt = new org.hl7.fhir.r5.model.Composition.CompositionRelatesToComponent();
        copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCodeElement(convertDocumentRelationshipType(src.getCodeElement()));
        if (src.hasTarget())
            tgt.setTarget(convertType(src.getTarget()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Composition.CompositionRelatesToComponent convertCompositionRelatesToComponent(org.hl7.fhir.r5.model.Composition.CompositionRelatesToComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Composition.CompositionRelatesToComponent tgt = new org.hl7.fhir.r4.model.Composition.CompositionRelatesToComponent();
        copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCodeElement(convertDocumentRelationshipType(src.getCodeElement()));
        if (src.hasTarget())
            tgt.setTarget(convertType(src.getTarget()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.DocumentRelationshipType> convertDocumentRelationshipType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Composition.DocumentRelationshipType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.DocumentRelationshipType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.DocumentRelationshipTypeEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
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

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Composition.DocumentRelationshipType> convertDocumentRelationshipType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.DocumentRelationshipType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Composition.DocumentRelationshipType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Composition.DocumentRelationshipTypeEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case REPLACES:
                tgt.setValue(org.hl7.fhir.r4.model.Composition.DocumentRelationshipType.REPLACES);
                break;
            case TRANSFORMS:
                tgt.setValue(org.hl7.fhir.r4.model.Composition.DocumentRelationshipType.TRANSFORMS);
                break;
            case SIGNS:
                tgt.setValue(org.hl7.fhir.r4.model.Composition.DocumentRelationshipType.SIGNS);
                break;
            case APPENDS:
                tgt.setValue(org.hl7.fhir.r4.model.Composition.DocumentRelationshipType.APPENDS);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.Composition.DocumentRelationshipType.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Composition.CompositionEventComponent convertCompositionEventComponent(org.hl7.fhir.r4.model.Composition.CompositionEventComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Composition.CompositionEventComponent tgt = new org.hl7.fhir.r5.model.Composition.CompositionEventComponent();
        copyElement(src, tgt);
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCode()) tgt.addCode(convertCodeableConcept(t));
        if (src.hasPeriod())
            tgt.setPeriod(convertPeriod(src.getPeriod()));
        for (org.hl7.fhir.r4.model.Reference t : src.getDetail()) tgt.addDetail(convertReference(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Composition.CompositionEventComponent convertCompositionEventComponent(org.hl7.fhir.r5.model.Composition.CompositionEventComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Composition.CompositionEventComponent tgt = new org.hl7.fhir.r4.model.Composition.CompositionEventComponent();
        copyElement(src, tgt);
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCode()) tgt.addCode(convertCodeableConcept(t));
        if (src.hasPeriod())
            tgt.setPeriod(convertPeriod(src.getPeriod()));
        for (org.hl7.fhir.r5.model.Reference t : src.getDetail()) tgt.addDetail(convertReference(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Composition.SectionComponent convertSectionComponent(org.hl7.fhir.r4.model.Composition.SectionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Composition.SectionComponent tgt = new org.hl7.fhir.r5.model.Composition.SectionComponent();
        copyElement(src, tgt);
        if (src.hasTitle())
            tgt.setTitleElement(convertString(src.getTitleElement()));
        if (src.hasCode())
            tgt.setCode(convertCodeableConcept(src.getCode()));
        for (org.hl7.fhir.r4.model.Reference t : src.getAuthor()) tgt.addAuthor(convertReference(t));
        if (src.hasFocus())
            tgt.setFocus(convertReference(src.getFocus()));
        if (src.hasText())
            tgt.setText(convertNarrative(src.getText()));
        if (src.hasMode())
            tgt.setModeElement(convertSectionMode(src.getModeElement()));
        if (src.hasOrderedBy())
            tgt.setOrderedBy(convertCodeableConcept(src.getOrderedBy()));
        for (org.hl7.fhir.r4.model.Reference t : src.getEntry()) tgt.addEntry(convertReference(t));
        if (src.hasEmptyReason())
            tgt.setEmptyReason(convertCodeableConcept(src.getEmptyReason()));
        for (org.hl7.fhir.r4.model.Composition.SectionComponent t : src.getSection()) tgt.addSection(convertSectionComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Composition.SectionComponent convertSectionComponent(org.hl7.fhir.r5.model.Composition.SectionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Composition.SectionComponent tgt = new org.hl7.fhir.r4.model.Composition.SectionComponent();
        copyElement(src, tgt);
        if (src.hasTitle())
            tgt.setTitleElement(convertString(src.getTitleElement()));
        if (src.hasCode())
            tgt.setCode(convertCodeableConcept(src.getCode()));
        for (org.hl7.fhir.r5.model.Reference t : src.getAuthor()) tgt.addAuthor(convertReference(t));
        if (src.hasFocus())
            tgt.setFocus(convertReference(src.getFocus()));
        if (src.hasText())
            tgt.setText(convertNarrative(src.getText()));
        if (src.hasMode())
            tgt.setModeElement(convertSectionMode(src.getModeElement()));
        if (src.hasOrderedBy())
            tgt.setOrderedBy(convertCodeableConcept(src.getOrderedBy()));
        for (org.hl7.fhir.r5.model.Reference t : src.getEntry()) tgt.addEntry(convertReference(t));
        if (src.hasEmptyReason())
            tgt.setEmptyReason(convertCodeableConcept(src.getEmptyReason()));
        for (org.hl7.fhir.r5.model.Composition.SectionComponent t : src.getSection()) tgt.addSection(convertSectionComponent(t));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ListMode> convertSectionMode(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Composition.SectionMode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ListMode> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.ListModeEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
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

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Composition.SectionMode> convertSectionMode(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ListMode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Composition.SectionMode> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Composition.SectionModeEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case WORKING:
                tgt.setValue(org.hl7.fhir.r4.model.Composition.SectionMode.WORKING);
                break;
            case SNAPSHOT:
                tgt.setValue(org.hl7.fhir.r4.model.Composition.SectionMode.SNAPSHOT);
                break;
            case CHANGES:
                tgt.setValue(org.hl7.fhir.r4.model.Composition.SectionMode.CHANGES);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.Composition.SectionMode.NULL);
                break;
        }
        return tgt;
    }
}