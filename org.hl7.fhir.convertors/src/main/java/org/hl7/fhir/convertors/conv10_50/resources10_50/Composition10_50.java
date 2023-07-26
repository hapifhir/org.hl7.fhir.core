package org.hl7.fhir.convertors.conv10_50.resources10_50;

import java.util.Collections;

import org.hl7.fhir.convertors.context.ConversionContext10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.Narrative10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.Reference10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.CodeableConcept10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.Identifier10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.Period10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.Code10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.DateTime10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.String10_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CodeableReference;

public class Composition10_50 {

  public static org.hl7.fhir.r5.model.Composition convertComposition(org.hl7.fhir.dstu2.model.Composition src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Composition tgt = new org.hl7.fhir.r5.model.Composition();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyDomainResource(src, tgt);
    if (src.hasIdentifier())
      tgt.addIdentifier(Identifier10_50.convertIdentifier(src.getIdentifier()));
    if (src.hasDate())
      tgt.setDateElement(DateTime10_50.convertDateTime(src.getDateElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept10_50.convertCodeableConcept(src.getType()));
    if (src.hasClass_())
      tgt.addCategory(CodeableConcept10_50.convertCodeableConcept(src.getClass_()));
    if (src.hasTitleElement())
      tgt.setTitleElement(String10_50.convertString(src.getTitleElement()));
    if (src.hasStatus())
      tgt.setStatusElement(convertCompositionStatus(src.getStatusElement()));
    try {
      if (src.hasConfidentiality())
        tgt.getMeta().addSecurity().setCodeElement(Code10_50.convertCode(src.getConfidentialityElement()));
    } catch (org.hl7.fhir.exceptions.FHIRException e) {
      throw new FHIRException(e);
    }
    if (src.hasSubject())
      tgt.addSubject(Reference10_50.convertReference(src.getSubject()));
    for (org.hl7.fhir.dstu2.model.Reference t : src.getAuthor()) tgt.addAuthor(Reference10_50.convertReference(t));
    for (org.hl7.fhir.dstu2.model.Composition.CompositionAttesterComponent t : src.getAttester())
      tgt.addAttester(convertCompositionAttesterComponent(t));
    if (src.hasCustodian())
      tgt.setCustodian(Reference10_50.convertReference(src.getCustodian()));
    for (org.hl7.fhir.dstu2.model.Composition.CompositionEventComponent t : src.getEvent())
      tgt.addEvent(convertCompositionEventComponent(t));
    if (src.hasEncounter())
      tgt.setEncounter(Reference10_50.convertReference(src.getEncounter()));
    for (org.hl7.fhir.dstu2.model.Composition.SectionComponent t : src.getSection())
      tgt.addSection(convertSectionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Composition convertComposition(org.hl7.fhir.r5.model.Composition src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Composition tgt = new org.hl7.fhir.dstu2.model.Composition();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyDomainResource(src, tgt);
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier10_50.convertIdentifier(src.getIdentifierFirstRep()));
    if (src.hasDate())
      tgt.setDateElement(DateTime10_50.convertDateTime(src.getDateElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept10_50.convertCodeableConcept(src.getType()));
    if (src.hasCategory())
      tgt.setClass_(CodeableConcept10_50.convertCodeableConcept(src.getCategoryFirstRep()));
    if (src.hasTitleElement())
      tgt.setTitleElement(String10_50.convertString(src.getTitleElement()));
    if (src.hasStatus())
      tgt.setStatusElement(convertCompositionStatus(src.getStatusElement()));
    tgt.setConfidentiality(src.getMeta().getSecurityFirstRep().getCode());
    if (src.hasSubject())
      tgt.setSubject(Reference10_50.convertReference(src.getSubjectFirstRep()));
    for (org.hl7.fhir.r5.model.Reference t : src.getAuthor()) tgt.addAuthor(Reference10_50.convertReference(t));
    for (org.hl7.fhir.r5.model.Composition.CompositionAttesterComponent t : src.getAttester())
      tgt.addAttester(convertCompositionAttesterComponent(t));
    if (src.hasCustodian())
      tgt.setCustodian(Reference10_50.convertReference(src.getCustodian()));
    for (org.hl7.fhir.r5.model.Composition.CompositionEventComponent t : src.getEvent())
      tgt.addEvent(convertCompositionEventComponent(t));
    if (src.hasEncounter())
      tgt.setEncounter(Reference10_50.convertReference(src.getEncounter()));
    for (org.hl7.fhir.r5.model.Composition.SectionComponent t : src.getSection())
      tgt.addSection(convertSectionComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Composition.CompositionAttestationMode> convertCompositionAttestationMode(org.hl7.fhir.r5.model.CodeableConcept src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Composition.CompositionAttestationMode> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Composition.CompositionAttestationModeEnumFactory());
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    switch (src.getCode("http://hl7.org/fhir/composition-attestation-mode")) {
      case "personal":
        tgt.setValue(org.hl7.fhir.dstu2.model.Composition.CompositionAttestationMode.PERSONAL);
        break;
      case "professional":
        tgt.setValue(org.hl7.fhir.dstu2.model.Composition.CompositionAttestationMode.PROFESSIONAL);
        break;
      case "legal":
        tgt.setValue(org.hl7.fhir.dstu2.model.Composition.CompositionAttestationMode.LEGAL);
        break;
      case "official":
        tgt.setValue(org.hl7.fhir.dstu2.model.Composition.CompositionAttestationMode.OFFICIAL);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu2.model.Composition.CompositionAttestationMode.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.CodeableConcept convertCompositionAttestationMode(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Composition.CompositionAttestationMode> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.CodeableConcept tgt = new org.hl7.fhir.r5.model.CodeableConcept();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case PERSONAL:
        tgt.addCoding().setSystem("http://hl7.org/fhir/composition-attestation-mode").setCode("personal");
        break;
      case PROFESSIONAL:
        tgt.addCoding().setSystem("http://hl7.org/fhir/composition-attestation-mode").setCode("professional");
        break;
      case LEGAL:
        tgt.addCoding().setSystem("http://hl7.org/fhir/composition-attestation-mode").setCode("legal");
        break;
      case OFFICIAL:
        tgt.addCoding().setSystem("http://hl7.org/fhir/composition-attestation-mode").setCode("official");
        break;
      default:
        break;
    }
    return tgt;
  }
  public static org.hl7.fhir.dstu2.model.Composition.CompositionAttesterComponent convertCompositionAttesterComponent(org.hl7.fhir.r5.model.Composition.CompositionAttesterComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Composition.CompositionAttesterComponent tgt = new org.hl7.fhir.dstu2.model.Composition.CompositionAttesterComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    if (src.hasMode())
      tgt.setMode(Collections.singletonList(convertCompositionAttestationMode(src.getMode())));
    if (src.hasTimeElement())
      tgt.setTimeElement(DateTime10_50.convertDateTime(src.getTimeElement()));
    if (src.hasParty())
      tgt.setParty(Reference10_50.convertReference(src.getParty()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Composition.CompositionAttesterComponent convertCompositionAttesterComponent(org.hl7.fhir.dstu2.model.Composition.CompositionAttesterComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Composition.CompositionAttesterComponent tgt = new org.hl7.fhir.r5.model.Composition.CompositionAttesterComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    if (src.hasMode())
      tgt.setMode(convertCompositionAttestationMode(src.getMode().get(0)));
    if (src.hasTimeElement())
      tgt.setTimeElement(DateTime10_50.convertDateTime(src.getTimeElement()));
    if (src.hasParty())
      tgt.setParty(Reference10_50.convertReference(src.getParty()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Composition.CompositionEventComponent convertCompositionEventComponent(org.hl7.fhir.r5.model.Composition.CompositionEventComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Composition.CompositionEventComponent tgt = new org.hl7.fhir.dstu2.model.Composition.CompositionEventComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    if (src.hasPeriod())
      tgt.setPeriod(Period10_50.convertPeriod(src.getPeriod()));
    for (CodeableReference t : src.getDetail()) {
      if (t.hasConcept()) {
        tgt.addCode(CodeableConcept10_50.convertCodeableConcept(t.getConcept()));
      }
      if (t.hasReference()) {
        tgt.addDetail(Reference10_50.convertReference(t.getReference()));
      }
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Composition.CompositionEventComponent convertCompositionEventComponent(org.hl7.fhir.dstu2.model.Composition.CompositionEventComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Composition.CompositionEventComponent tgt = new org.hl7.fhir.r5.model.Composition.CompositionEventComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getCode())
      tgt.addDetail().setConcept(CodeableConcept10_50.convertCodeableConcept(t));
    if (src.hasPeriod())
      tgt.setPeriod(Period10_50.convertPeriod(src.getPeriod()));
    for (org.hl7.fhir.dstu2.model.Reference t : src.getDetail()) tgt.addDetail().setReference(Reference10_50.convertReference(t));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.CompositionStatus> convertCompositionStatus(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Composition.CompositionStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.CompositionStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.CompositionStatusEnumFactory());
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    switch (src.getValue()) {
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

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Composition.CompositionStatus> convertCompositionStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.CompositionStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Composition.CompositionStatus> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Composition.CompositionStatusEnumFactory());
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
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

  public static org.hl7.fhir.dstu2.model.Composition.SectionComponent convertSectionComponent(org.hl7.fhir.r5.model.Composition.SectionComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Composition.SectionComponent tgt = new org.hl7.fhir.dstu2.model.Composition.SectionComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    if (src.hasTitleElement())
      tgt.setTitleElement(String10_50.convertString(src.getTitleElement()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept10_50.convertCodeableConcept(src.getCode()));
    if (src.hasText())
      tgt.setText(Narrative10_50.convertNarrative(src.getText()));
//    tgt.setMode(src.getMode().toCode());
    if (src.hasOrderedBy())
      tgt.setOrderedBy(CodeableConcept10_50.convertCodeableConcept(src.getOrderedBy()));
    for (org.hl7.fhir.r5.model.Reference t : src.getEntry()) tgt.addEntry(Reference10_50.convertReference(t));
    if (src.hasEmptyReason())
      tgt.setEmptyReason(CodeableConcept10_50.convertCodeableConcept(src.getEmptyReason()));
    for (org.hl7.fhir.r5.model.Composition.SectionComponent t : src.getSection())
      tgt.addSection(convertSectionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Composition.SectionComponent convertSectionComponent(org.hl7.fhir.dstu2.model.Composition.SectionComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Composition.SectionComponent tgt = new org.hl7.fhir.r5.model.Composition.SectionComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    if (src.hasTitleElement())
      tgt.setTitleElement(String10_50.convertString(src.getTitleElement()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept10_50.convertCodeableConcept(src.getCode()));
    if (src.hasText())
      tgt.setText(Narrative10_50.convertNarrative(src.getText()));
//    try {
//      if (src.hasMode())
//        tgt.setMode(org.hl7.fhir.r5.model.Enumerations.ListMode.fromCode(src.getMode()));
//    } catch (org.hl7.fhir.exceptions.FHIRException e) {
//      throw new FHIRException(e);
//    }
    if (src.hasOrderedBy())
      tgt.setOrderedBy(CodeableConcept10_50.convertCodeableConcept(src.getOrderedBy()));
    for (org.hl7.fhir.dstu2.model.Reference t : src.getEntry()) tgt.addEntry(Reference10_50.convertReference(t));
    if (src.hasEmptyReason())
      tgt.setEmptyReason(CodeableConcept10_50.convertCodeableConcept(src.getEmptyReason()));
    for (org.hl7.fhir.dstu2.model.Composition.SectionComponent t : src.getSection())
      tgt.addSection(convertSectionComponent(t));
    return tgt;
  }
}