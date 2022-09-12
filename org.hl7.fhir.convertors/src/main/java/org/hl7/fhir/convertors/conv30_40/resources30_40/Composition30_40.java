package org.hl7.fhir.convertors.conv30_40.resources30_40;

import java.util.Collections;

import org.hl7.fhir.convertors.context.ConversionContext30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Narrative30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Reference30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.CodeableConcept30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Identifier30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Period30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.DateTime30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.String30_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Composition30_40 {

  public static org.hl7.fhir.dstu3.model.Composition convertComposition(org.hl7.fhir.r4.model.Composition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.Composition tgt = new org.hl7.fhir.dstu3.model.Composition();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyDomainResource(src, tgt);
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier30_40.convertIdentifier(src.getIdentifier()));
    if (src.hasStatus())
      tgt.setStatusElement(convertCompositionStatus(src.getStatusElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept30_40.convertCodeableConcept(src.getType()));
    if (src.hasCategory())
      tgt.setClass_(CodeableConcept30_40.convertCodeableConcept(src.getCategoryFirstRep()));
    if (src.hasSubject())
      tgt.setSubject(Reference30_40.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference30_40.convertReference(src.getEncounter()));
    if (src.hasDateElement())
      tgt.setDateElement(DateTime30_40.convertDateTime(src.getDateElement()));
    for (org.hl7.fhir.r4.model.Reference t : src.getAuthor())
      tgt.addAuthor(Reference30_40.convertReference(t));
    if (src.hasTitle())
      tgt.setTitleElement(String30_40.convertString(src.getTitleElement()));
    if (src.hasConfidentiality())
      tgt.setConfidentialityElement(convertDocumentConfidentiality(src.getConfidentialityElement()));
    for (org.hl7.fhir.r4.model.Composition.CompositionAttesterComponent t : src.getAttester())
      tgt.addAttester(convertCompositionAttesterComponent(t));
    if (src.hasCustodian())
      tgt.setCustodian(Reference30_40.convertReference(src.getCustodian()));
    for (org.hl7.fhir.r4.model.Composition.CompositionRelatesToComponent t : src.getRelatesTo())
      tgt.addRelatesTo(convertCompositionRelatesToComponent(t));
    for (org.hl7.fhir.r4.model.Composition.CompositionEventComponent t : src.getEvent())
      tgt.addEvent(convertCompositionEventComponent(t));
    for (org.hl7.fhir.r4.model.Composition.SectionComponent t : src.getSection())
      tgt.addSection(convertSectionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Composition convertComposition(org.hl7.fhir.dstu3.model.Composition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Composition tgt = new org.hl7.fhir.r4.model.Composition();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyDomainResource(src, tgt);
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier30_40.convertIdentifier(src.getIdentifier()));
    if (src.hasStatus())
      tgt.setStatusElement(convertCompositionStatus(src.getStatusElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept30_40.convertCodeableConcept(src.getType()));
    if (src.hasClass_())
      tgt.addCategory(CodeableConcept30_40.convertCodeableConcept(src.getClass_()));
    if (src.hasSubject())
      tgt.setSubject(Reference30_40.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference30_40.convertReference(src.getEncounter()));
    if (src.hasDateElement())
      tgt.setDateElement(DateTime30_40.convertDateTime(src.getDateElement()));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getAuthor())
      tgt.addAuthor(Reference30_40.convertReference(t));
    if (src.hasTitle())
      tgt.setTitleElement(String30_40.convertString(src.getTitleElement()));
    if (src.hasConfidentiality())
      tgt.setConfidentialityElement(convertDocumentConfidentiality(src.getConfidentialityElement()));
    for (org.hl7.fhir.dstu3.model.Composition.CompositionAttesterComponent t : src.getAttester())
      tgt.addAttester(convertCompositionAttesterComponent(t));
    if (src.hasCustodian())
      tgt.setCustodian(Reference30_40.convertReference(src.getCustodian()));
    for (org.hl7.fhir.dstu3.model.Composition.CompositionRelatesToComponent t : src.getRelatesTo())
      tgt.addRelatesTo(convertCompositionRelatesToComponent(t));
    for (org.hl7.fhir.dstu3.model.Composition.CompositionEventComponent t : src.getEvent())
      tgt.addEvent(convertCompositionEventComponent(t));
    for (org.hl7.fhir.dstu3.model.Composition.SectionComponent t : src.getSection())
      tgt.addSection(convertSectionComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Composition.CompositionAttestationMode> convertCompositionAttestationMode(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Composition.CompositionAttestationMode> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Composition.CompositionAttestationMode> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Composition.CompositionAttestationModeEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Composition.CompositionAttestationMode> convertCompositionAttestationMode(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Composition.CompositionAttestationMode> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Composition.CompositionAttestationMode> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Composition.CompositionAttestationModeEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
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

  public static org.hl7.fhir.dstu3.model.Composition.CompositionAttesterComponent convertCompositionAttesterComponent(org.hl7.fhir.r4.model.Composition.CompositionAttesterComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.Composition.CompositionAttesterComponent tgt = new org.hl7.fhir.dstu3.model.Composition.CompositionAttesterComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src,tgt);
    if (src.hasMode())
      tgt.setMode(Collections.singletonList(convertCompositionAttestationMode(src.getModeElement())));
    if (src.hasTime())
      tgt.setTimeElement(DateTime30_40.convertDateTime(src.getTimeElement()));
    if (src.hasParty())
      tgt.setParty(Reference30_40.convertReference(src.getParty()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Composition.CompositionAttesterComponent convertCompositionAttesterComponent(org.hl7.fhir.dstu3.model.Composition.CompositionAttesterComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Composition.CompositionAttesterComponent tgt = new org.hl7.fhir.r4.model.Composition.CompositionAttesterComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src,tgt);
    if (src.hasMode())
      tgt.setModeElement(convertCompositionAttestationMode(src.getMode().get(0)));
    if (src.hasTime())
      tgt.setTimeElement(DateTime30_40.convertDateTime(src.getTimeElement()));
    if (src.hasParty())
      tgt.setParty(Reference30_40.convertReference(src.getParty()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Composition.CompositionEventComponent convertCompositionEventComponent(org.hl7.fhir.dstu3.model.Composition.CompositionEventComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Composition.CompositionEventComponent tgt = new org.hl7.fhir.r4.model.Composition.CompositionEventComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src,tgt);
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getCode())
      tgt.addCode(CodeableConcept30_40.convertCodeableConcept(t));
    if (src.hasPeriod())
      tgt.setPeriod(Period30_40.convertPeriod(src.getPeriod()));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getDetail())
      tgt.addDetail(Reference30_40.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Composition.CompositionEventComponent convertCompositionEventComponent(org.hl7.fhir.r4.model.Composition.CompositionEventComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.Composition.CompositionEventComponent tgt = new org.hl7.fhir.dstu3.model.Composition.CompositionEventComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src,tgt);
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCode())
      tgt.addCode(CodeableConcept30_40.convertCodeableConcept(t));
    if (src.hasPeriod())
      tgt.setPeriod(Period30_40.convertPeriod(src.getPeriod()));
    for (org.hl7.fhir.r4.model.Reference t : src.getDetail())
      tgt.addDetail(Reference30_40.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Composition.CompositionRelatesToComponent convertCompositionRelatesToComponent(org.hl7.fhir.dstu3.model.Composition.CompositionRelatesToComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Composition.CompositionRelatesToComponent tgt = new org.hl7.fhir.r4.model.Composition.CompositionRelatesToComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src,tgt);
    if (src.hasCode())
      tgt.setCodeElement(convertDocumentRelationshipType(src.getCodeElement()));
    if (src.hasTarget())
      tgt.setTarget(ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().convertType(src.getTarget()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Composition.CompositionRelatesToComponent convertCompositionRelatesToComponent(org.hl7.fhir.r4.model.Composition.CompositionRelatesToComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.Composition.CompositionRelatesToComponent tgt = new org.hl7.fhir.dstu3.model.Composition.CompositionRelatesToComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src,tgt);
    if (src.hasCode())
      tgt.setCodeElement(convertDocumentRelationshipType(src.getCodeElement()));
    if (src.hasTarget())
      tgt.setTarget(ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().convertType(src.getTarget()));
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Composition.CompositionStatus> convertCompositionStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Composition.CompositionStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Composition.CompositionStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Composition.CompositionStatusEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
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

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Composition.CompositionStatus> convertCompositionStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Composition.CompositionStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Composition.CompositionStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Composition.CompositionStatusEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Composition.DocumentConfidentiality> convertDocumentConfidentiality(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Composition.DocumentConfidentiality> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Composition.DocumentConfidentiality> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Composition.DocumentConfidentialityEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
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

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Composition.DocumentConfidentiality> convertDocumentConfidentiality(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Composition.DocumentConfidentiality> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Composition.DocumentConfidentiality> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Composition.DocumentConfidentialityEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
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

  public static org.hl7.fhir.dstu3.model.Composition.SectionComponent convertSectionComponent(org.hl7.fhir.r4.model.Composition.SectionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.Composition.SectionComponent tgt = new org.hl7.fhir.dstu3.model.Composition.SectionComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src,tgt);
    if (src.hasTitle())
      tgt.setTitleElement(String30_40.convertString(src.getTitleElement()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept30_40.convertCodeableConcept(src.getCode()));
    if (src.hasText())
      tgt.setText(Narrative30_40.convertNarrative(src.getText()));
    if (src.hasMode())
      tgt.setModeElement(convertSectionMode(src.getModeElement()));
    if (src.hasOrderedBy())
      tgt.setOrderedBy(CodeableConcept30_40.convertCodeableConcept(src.getOrderedBy()));
    for (org.hl7.fhir.r4.model.Reference t : src.getEntry())
      tgt.addEntry(Reference30_40.convertReference(t));
    if (src.hasEmptyReason())
      tgt.setEmptyReason(CodeableConcept30_40.convertCodeableConcept(src.getEmptyReason()));
    for (org.hl7.fhir.r4.model.Composition.SectionComponent t : src.getSection())
      tgt.addSection(convertSectionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Composition.SectionComponent convertSectionComponent(org.hl7.fhir.dstu3.model.Composition.SectionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Composition.SectionComponent tgt = new org.hl7.fhir.r4.model.Composition.SectionComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src,tgt);
    if (src.hasTitle())
      tgt.setTitleElement(String30_40.convertString(src.getTitleElement()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept30_40.convertCodeableConcept(src.getCode()));
    if (src.hasText())
      tgt.setText(Narrative30_40.convertNarrative(src.getText()));
    if (src.hasMode())
      tgt.setModeElement(convertSectionMode(src.getModeElement()));
    if (src.hasOrderedBy())
      tgt.setOrderedBy(CodeableConcept30_40.convertCodeableConcept(src.getOrderedBy()));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getEntry())
      tgt.addEntry(Reference30_40.convertReference(t));
    if (src.hasEmptyReason())
      tgt.setEmptyReason(CodeableConcept30_40.convertCodeableConcept(src.getEmptyReason()));
    for (org.hl7.fhir.dstu3.model.Composition.SectionComponent t : src.getSection())
      tgt.addSection(convertSectionComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Composition.SectionMode> convertSectionMode(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Composition.SectionMode> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Composition.SectionMode> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Composition.SectionModeEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
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

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Composition.SectionMode> convertSectionMode(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Composition.SectionMode> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Composition.SectionMode> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Composition.SectionModeEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Composition.DocumentRelationshipType> convertDocumentRelationshipType(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Composition.DocumentRelationshipType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Composition.DocumentRelationshipType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Composition.DocumentRelationshipTypeEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
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

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Composition.DocumentRelationshipType> convertDocumentRelationshipType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Composition.DocumentRelationshipType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Composition.DocumentRelationshipType> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Composition.DocumentRelationshipTypeEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
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

}