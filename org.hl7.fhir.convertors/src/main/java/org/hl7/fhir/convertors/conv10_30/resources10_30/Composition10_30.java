package org.hl7.fhir.convertors.conv10_30.resources10_30;

import org.hl7.fhir.convertors.context.ConversionContext10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.Narrative10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.Reference10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.CodeableConcept10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.Identifier10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.Period10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.DateTime10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.String10_30;
import org.hl7.fhir.exceptions.FHIRException;

import java.util.stream.Collectors;

public class Composition10_30 {

  public static org.hl7.fhir.dstu3.model.Composition convertComposition(org.hl7.fhir.dstu2.model.Composition src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Composition tgt = new org.hl7.fhir.dstu3.model.Composition();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyDomainResource(src, tgt);
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier10_30.convertIdentifier(src.getIdentifier()));
    if (src.hasDate())
      tgt.setDateElement(DateTime10_30.convertDateTime(src.getDateElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept10_30.convertCodeableConcept(src.getType()));
    if (src.hasClass_())
      tgt.setClass_(CodeableConcept10_30.convertCodeableConcept(src.getClass_()));
    if (src.hasTitleElement())
      tgt.setTitleElement(String10_30.convertString(src.getTitleElement()));
    if (src.hasStatus())
      tgt.setStatusElement(convertCompositionStatus(src.getStatusElement()));
    try {
      if (src.hasConfidentiality())
        tgt.setConfidentiality(org.hl7.fhir.dstu3.model.Composition.DocumentConfidentiality.fromCode(src.getConfidentiality()));
    } catch (org.hl7.fhir.exceptions.FHIRException e) {
      throw new FHIRException(e);
    }
    if (src.hasSubject())
      tgt.setSubject(Reference10_30.convertReference(src.getSubject()));
    for (org.hl7.fhir.dstu2.model.Reference t : src.getAuthor()) tgt.addAuthor(Reference10_30.convertReference(t));
    for (org.hl7.fhir.dstu2.model.Composition.CompositionAttesterComponent t : src.getAttester())
      tgt.addAttester(convertCompositionAttesterComponent(t));
    if (src.hasCustodian())
      tgt.setCustodian(Reference10_30.convertReference(src.getCustodian()));
    for (org.hl7.fhir.dstu2.model.Composition.CompositionEventComponent t : src.getEvent())
      tgt.addEvent(convertCompositionEventComponent(t));
    if (src.hasEncounter())
      tgt.setEncounter(Reference10_30.convertReference(src.getEncounter()));
    for (org.hl7.fhir.dstu2.model.Composition.SectionComponent t : src.getSection())
      tgt.addSection(convertSectionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Composition convertComposition(org.hl7.fhir.dstu3.model.Composition src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Composition tgt = new org.hl7.fhir.dstu2.model.Composition();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyDomainResource(src, tgt);
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier10_30.convertIdentifier(src.getIdentifier()));
    if (src.hasDate())
      tgt.setDateElement(DateTime10_30.convertDateTime(src.getDateElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept10_30.convertCodeableConcept(src.getType()));
    if (src.hasClass_())
      tgt.setClass_(CodeableConcept10_30.convertCodeableConcept(src.getClass_()));
    if (src.hasTitleElement())
      tgt.setTitleElement(String10_30.convertString(src.getTitleElement()));
    if (src.hasStatus())
      tgt.setStatusElement(convertCompositionStatus(src.getStatusElement()));
    tgt.setConfidentiality(src.getConfidentiality().toCode());
    if (src.hasSubject())
      tgt.setSubject(Reference10_30.convertReference(src.getSubject()));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getAuthor()) tgt.addAuthor(Reference10_30.convertReference(t));
    for (org.hl7.fhir.dstu3.model.Composition.CompositionAttesterComponent t : src.getAttester())
      tgt.addAttester(convertCompositionAttesterComponent(t));
    if (src.hasCustodian())
      tgt.setCustodian(Reference10_30.convertReference(src.getCustodian()));
    for (org.hl7.fhir.dstu3.model.Composition.CompositionEventComponent t : src.getEvent())
      tgt.addEvent(convertCompositionEventComponent(t));
    if (src.hasEncounter())
      tgt.setEncounter(Reference10_30.convertReference(src.getEncounter()));
    for (org.hl7.fhir.dstu3.model.Composition.SectionComponent t : src.getSection())
      tgt.addSection(convertSectionComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Composition.CompositionAttestationMode> convertCompositionAttestationMode(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Composition.CompositionAttestationMode> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Composition.CompositionAttestationMode> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Composition.CompositionAttestationModeEnumFactory());
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    switch (src.getValue()) {
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

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Composition.CompositionAttestationMode> convertCompositionAttestationMode(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Composition.CompositionAttestationMode> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Composition.CompositionAttestationMode> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Composition.CompositionAttestationModeEnumFactory());
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    switch (src.getValue()) {
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

  public static org.hl7.fhir.dstu3.model.Composition.CompositionAttesterComponent convertCompositionAttesterComponent(org.hl7.fhir.dstu2.model.Composition.CompositionAttesterComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Composition.CompositionAttesterComponent tgt = new org.hl7.fhir.dstu3.model.Composition.CompositionAttesterComponent();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    tgt.setMode(src.getMode().stream()
      .map(Composition10_30::convertCompositionAttestationMode)
      .collect(Collectors.toList()));
    if (src.hasTimeElement())
      tgt.setTimeElement(DateTime10_30.convertDateTime(src.getTimeElement()));
    if (src.hasParty())
      tgt.setParty(Reference10_30.convertReference(src.getParty()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Composition.CompositionAttesterComponent convertCompositionAttesterComponent(org.hl7.fhir.dstu3.model.Composition.CompositionAttesterComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Composition.CompositionAttesterComponent tgt = new org.hl7.fhir.dstu2.model.Composition.CompositionAttesterComponent();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    tgt.setMode(src.getMode().stream()
      .map(Composition10_30::convertCompositionAttestationMode)
      .collect(Collectors.toList()));
    if (src.hasTimeElement())
      tgt.setTimeElement(DateTime10_30.convertDateTime(src.getTimeElement()));
    if (src.hasParty())
      tgt.setParty(Reference10_30.convertReference(src.getParty()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Composition.CompositionEventComponent convertCompositionEventComponent(org.hl7.fhir.dstu3.model.Composition.CompositionEventComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Composition.CompositionEventComponent tgt = new org.hl7.fhir.dstu2.model.Composition.CompositionEventComponent();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getCode())
      tgt.addCode(CodeableConcept10_30.convertCodeableConcept(t));
    if (src.hasPeriod())
      tgt.setPeriod(Period10_30.convertPeriod(src.getPeriod()));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getDetail()) tgt.addDetail(Reference10_30.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Composition.CompositionEventComponent convertCompositionEventComponent(org.hl7.fhir.dstu2.model.Composition.CompositionEventComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Composition.CompositionEventComponent tgt = new org.hl7.fhir.dstu3.model.Composition.CompositionEventComponent();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getCode())
      tgt.addCode(CodeableConcept10_30.convertCodeableConcept(t));
    if (src.hasPeriod())
      tgt.setPeriod(Period10_30.convertPeriod(src.getPeriod()));
    for (org.hl7.fhir.dstu2.model.Reference t : src.getDetail()) tgt.addDetail(Reference10_30.convertReference(t));
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Composition.CompositionStatus> convertCompositionStatus(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Composition.CompositionStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Composition.CompositionStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Composition.CompositionStatusEnumFactory());
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    switch (src.getValue()) {
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

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Composition.CompositionStatus> convertCompositionStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Composition.CompositionStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Composition.CompositionStatus> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Composition.CompositionStatusEnumFactory());
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    switch (src.getValue()) {
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

  public static org.hl7.fhir.dstu3.model.Composition.SectionComponent convertSectionComponent(org.hl7.fhir.dstu2.model.Composition.SectionComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Composition.SectionComponent tgt = new org.hl7.fhir.dstu3.model.Composition.SectionComponent();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    if (src.hasTitleElement())
      tgt.setTitleElement(String10_30.convertString(src.getTitleElement()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept10_30.convertCodeableConcept(src.getCode()));
    if (src.hasText())
      tgt.setText(Narrative10_30.convertNarrative(src.getText()));
    try {
      if (src.hasMode())
        tgt.setMode(org.hl7.fhir.dstu3.model.Composition.SectionMode.fromCode(src.getMode()));
    } catch (org.hl7.fhir.exceptions.FHIRException e) {
      throw new FHIRException(e);
    }
    if (src.hasOrderedBy())
      tgt.setOrderedBy(CodeableConcept10_30.convertCodeableConcept(src.getOrderedBy()));
    for (org.hl7.fhir.dstu2.model.Reference t : src.getEntry()) tgt.addEntry(Reference10_30.convertReference(t));
    if (src.hasEmptyReason())
      tgt.setEmptyReason(CodeableConcept10_30.convertCodeableConcept(src.getEmptyReason()));
    for (org.hl7.fhir.dstu2.model.Composition.SectionComponent t : src.getSection())
      tgt.addSection(convertSectionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Composition.SectionComponent convertSectionComponent(org.hl7.fhir.dstu3.model.Composition.SectionComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Composition.SectionComponent tgt = new org.hl7.fhir.dstu2.model.Composition.SectionComponent();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    if (src.hasTitleElement())
      tgt.setTitleElement(String10_30.convertString(src.getTitleElement()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept10_30.convertCodeableConcept(src.getCode()));
    if (src.hasText())
      tgt.setText(Narrative10_30.convertNarrative(src.getText()));
    tgt.setMode(src.getMode().toCode());
    if (src.hasOrderedBy())
      tgt.setOrderedBy(CodeableConcept10_30.convertCodeableConcept(src.getOrderedBy()));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getEntry()) tgt.addEntry(Reference10_30.convertReference(t));
    if (src.hasEmptyReason())
      tgt.setEmptyReason(CodeableConcept10_30.convertCodeableConcept(src.getEmptyReason()));
    for (org.hl7.fhir.dstu3.model.Composition.SectionComponent t : src.getSection())
      tgt.addSection(convertSectionComponent(t));
    return tgt;
  }
}