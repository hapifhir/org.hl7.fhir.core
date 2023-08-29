package org.hl7.fhir.convertors.conv30_50.resources30_50;

import java.util.Collections;

import org.hl7.fhir.convertors.context.ConversionContext30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.Narrative30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.Reference30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.CodeableConcept30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Identifier30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Period30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.DateTime30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.String30_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CodeableReference;
import org.hl7.fhir.r5.model.RelatedArtifact;

public class Composition30_50 {

  public static org.hl7.fhir.r5.model.Composition convertComposition(org.hl7.fhir.dstu3.model.Composition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Composition tgt = new org.hl7.fhir.r5.model.Composition();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyDomainResource(src, tgt);
    if (src.hasIdentifier())
      tgt.addIdentifier(Identifier30_50.convertIdentifier(src.getIdentifier()));
    if (src.hasStatus())
      tgt.setStatusElement(convertCompositionStatus(src.getStatusElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept30_50.convertCodeableConcept(src.getType()));
    if (src.hasClass_())
      tgt.addCategory(CodeableConcept30_50.convertCodeableConcept(src.getClass_()));
    if (src.hasSubject())
      tgt.addSubject(Reference30_50.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference30_50.convertReference(src.getEncounter()));
    if (src.hasDate())
      tgt.setDateElement(DateTime30_50.convertDateTime(src.getDateElement()));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getAuthor()) tgt.addAuthor(Reference30_50.convertReference(t));
    if (src.hasTitle())
      tgt.setTitleElement(String30_50.convertString(src.getTitleElement()));
    if (src.hasConfidentiality())
      tgt.getMeta().addSecurity(convertDocumentConfidentiality(src.getConfidentialityElement()));
    for (org.hl7.fhir.dstu3.model.Composition.CompositionAttesterComponent t : src.getAttester())
      tgt.addAttester(convertCompositionAttesterComponent(t));
    if (src.hasCustodian())
      tgt.setCustodian(Reference30_50.convertReference(src.getCustodian()));
    for (org.hl7.fhir.dstu3.model.Composition.CompositionRelatesToComponent t : src.getRelatesTo())
      tgt.addRelatesTo(convertCompositionRelatesToComponent(t));
    for (org.hl7.fhir.dstu3.model.Composition.CompositionEventComponent t : src.getEvent())
      tgt.addEvent(convertCompositionEventComponent(t));
    for (org.hl7.fhir.dstu3.model.Composition.SectionComponent t : src.getSection())
      tgt.addSection(convertSectionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Composition convertComposition(org.hl7.fhir.r5.model.Composition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.Composition tgt = new org.hl7.fhir.dstu3.model.Composition();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyDomainResource(src, tgt);
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier30_50.convertIdentifier(src.getIdentifierFirstRep()));
    if (src.hasStatus())
      tgt.setStatusElement(convertCompositionStatus(src.getStatusElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept30_50.convertCodeableConcept(src.getType()));
    if (src.hasCategory())
      tgt.setClass_(CodeableConcept30_50.convertCodeableConcept(src.getCategoryFirstRep()));
    if (src.hasSubject())
      tgt.setSubject(Reference30_50.convertReference(src.getSubjectFirstRep()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference30_50.convertReference(src.getEncounter()));
    if (src.hasDate())
      tgt.setDateElement(DateTime30_50.convertDateTime(src.getDateElement()));
    for (org.hl7.fhir.r5.model.Reference t : src.getAuthor()) tgt.addAuthor(Reference30_50.convertReference(t));
    if (src.hasTitle())
      tgt.setTitleElement(String30_50.convertString(src.getTitleElement()));
    if (src.getMeta().hasSecurity())
      tgt.setConfidentialityElement(convertDocumentConfidentiality(src.getMeta().getSecurityFirstRep()));
    for (org.hl7.fhir.r5.model.Composition.CompositionAttesterComponent t : src.getAttester())
      tgt.addAttester(convertCompositionAttesterComponent(t));
    if (src.hasCustodian())
      tgt.setCustodian(Reference30_50.convertReference(src.getCustodian()));
    for (RelatedArtifact t : src.getRelatesTo())
      tgt.addRelatesTo(convertCompositionRelatesToComponent(t));
    for (org.hl7.fhir.r5.model.Composition.CompositionEventComponent t : src.getEvent())
      tgt.addEvent(convertCompositionEventComponent(t));
    for (org.hl7.fhir.r5.model.Composition.SectionComponent t : src.getSection())
      tgt.addSection(convertSectionComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Composition.CompositionAttestationMode> convertCompositionAttestationMode(org.hl7.fhir.r5.model.CodeableConcept src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Composition.CompositionAttestationMode> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Composition.CompositionAttestationModeEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    switch (src.getCode("http://hl7.org/fhir/composition-attestation-mode")) {
      case "personal":
        tgt.setValue(org.hl7.fhir.dstu3.model.Composition.CompositionAttestationMode.PERSONAL);
        break;
      case "professional":
        tgt.setValue(org.hl7.fhir.dstu3.model.Composition.CompositionAttestationMode.PROFESSIONAL);
        break;
      case "legal":
        tgt.setValue(org.hl7.fhir.dstu3.model.Composition.CompositionAttestationMode.LEGAL);
        break;
      case "official":
        tgt.setValue(org.hl7.fhir.dstu3.model.Composition.CompositionAttestationMode.OFFICIAL);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.Composition.CompositionAttestationMode.NULL);
        break;
    }
    return tgt;
  }


  static public org.hl7.fhir.r5.model.CodeableConcept convertCompositionAttestationMode(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Composition.CompositionAttestationMode> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.CodeableConcept tgt = new org.hl7.fhir.r5.model.CodeableConcept();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
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

  public static org.hl7.fhir.r5.model.Composition.CompositionAttesterComponent convertCompositionAttesterComponent(org.hl7.fhir.dstu3.model.Composition.CompositionAttesterComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Composition.CompositionAttesterComponent tgt = new org.hl7.fhir.r5.model.Composition.CompositionAttesterComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    if (src.hasMode())
      tgt.setMode(convertCompositionAttestationMode(src.getMode().get(0)));
    if (src.hasTime())
      tgt.setTimeElement(DateTime30_50.convertDateTime(src.getTimeElement()));
    if (src.hasParty())
      tgt.setParty(Reference30_50.convertReference(src.getParty()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Composition.CompositionAttesterComponent convertCompositionAttesterComponent(org.hl7.fhir.r5.model.Composition.CompositionAttesterComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.Composition.CompositionAttesterComponent tgt = new org.hl7.fhir.dstu3.model.Composition.CompositionAttesterComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    if (src.hasMode())
      tgt.setMode(Collections.singletonList(convertCompositionAttestationMode(src.getMode())));
    if (src.hasTime())
      tgt.setTimeElement(DateTime30_50.convertDateTime(src.getTimeElement()));
    if (src.hasParty())
      tgt.setParty(Reference30_50.convertReference(src.getParty()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Composition.CompositionEventComponent convertCompositionEventComponent(org.hl7.fhir.r5.model.Composition.CompositionEventComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.Composition.CompositionEventComponent tgt = new org.hl7.fhir.dstu3.model.Composition.CompositionEventComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    if (src.hasPeriod())
      tgt.setPeriod(Period30_50.convertPeriod(src.getPeriod()));
    for (CodeableReference t : src.getDetail()) {
      if (t.hasConcept()) {
        tgt.addCode(CodeableConcept30_50.convertCodeableConcept(t.getConcept()));
      }
      if (t.hasReference()) {
        tgt.addDetail(Reference30_50.convertReference(t.getReference()));
      }
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Composition.CompositionEventComponent convertCompositionEventComponent(org.hl7.fhir.dstu3.model.Composition.CompositionEventComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Composition.CompositionEventComponent tgt = new org.hl7.fhir.r5.model.Composition.CompositionEventComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getCode())
      tgt.addDetail().setConcept(CodeableConcept30_50.convertCodeableConcept(t));
    if (src.hasPeriod())
      tgt.setPeriod(Period30_50.convertPeriod(src.getPeriod()));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getDetail()) tgt.addDetail().setReference(Reference30_50.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Composition.CompositionRelatesToComponent convertCompositionRelatesToComponent(org.hl7.fhir.r5.model.RelatedArtifact src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.Composition.CompositionRelatesToComponent tgt = new org.hl7.fhir.dstu3.model.Composition.CompositionRelatesToComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.hasType())
      tgt.setCodeElement(convertDocumentRelationshipType(src.getTypeElement()));
    if (src.hasResourceReference())
      tgt.setTarget(ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().convertType(src.getResourceReference()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.RelatedArtifact convertCompositionRelatesToComponent(org.hl7.fhir.dstu3.model.Composition.CompositionRelatesToComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.RelatedArtifact tgt = new org.hl7.fhir.r5.model.RelatedArtifact();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.hasCode())
      tgt.setTypeElement(convertDocumentRelationshipType(src.getCodeElement()));
    if (src.hasTargetReference())
      tgt.setResourceReference(Reference30_50.convertReference(src.getTargetReference()));
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Composition.DocumentRelationshipType> convertDocumentRelationshipType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.RelatedArtifact.RelatedArtifactType> src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Composition.DocumentRelationshipType> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Composition.DocumentRelationshipTypeEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
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

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.RelatedArtifact.RelatedArtifactType> convertDocumentRelationshipType(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Composition.DocumentRelationshipType> src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.RelatedArtifact.RelatedArtifactType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.RelatedArtifact.RelatedArtifactTypeEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case REPLACES:
        tgt.setValue(org.hl7.fhir.r5.model.RelatedArtifact.RelatedArtifactType.REPLACES);
        break;
      case TRANSFORMS:
        tgt.setValue(org.hl7.fhir.r5.model.RelatedArtifact.RelatedArtifactType.TRANSFORMS);
        break;
      case SIGNS:
        tgt.setValue(org.hl7.fhir.r5.model.RelatedArtifact.RelatedArtifactType.SIGNS);
        break;
      case APPENDS:
        tgt.setValue(org.hl7.fhir.r5.model.RelatedArtifact.RelatedArtifactType.APPENDS);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.RelatedArtifact.RelatedArtifactType.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Composition.CompositionStatus> convertCompositionStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.CompositionStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Composition.CompositionStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Composition.CompositionStatusEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
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

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.CompositionStatus> convertCompositionStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Composition.CompositionStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.CompositionStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.CompositionStatusEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
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

  static public org.hl7.fhir.r5.model.Coding convertDocumentConfidentiality(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Composition.DocumentConfidentiality> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Coding tgt = new org.hl7.fhir.r5.model.Coding();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    tgt.setCode(src.getValue().toCode());
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Composition.DocumentConfidentiality> convertDocumentConfidentiality(org.hl7.fhir.r5.model.Coding src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Composition.DocumentConfidentiality> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Composition.DocumentConfidentialityEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    switch (src.getCode()) {
      case "U":
        tgt.setValue(org.hl7.fhir.dstu3.model.Composition.DocumentConfidentiality.U);
        break;
      case "L":
        tgt.setValue(org.hl7.fhir.dstu3.model.Composition.DocumentConfidentiality.L);
        break;
      case "M":
        tgt.setValue(org.hl7.fhir.dstu3.model.Composition.DocumentConfidentiality.M);
        break;
      case "N":
        tgt.setValue(org.hl7.fhir.dstu3.model.Composition.DocumentConfidentiality.N);
        break;
      case "R":
        tgt.setValue(org.hl7.fhir.dstu3.model.Composition.DocumentConfidentiality.R);
        break;
      case "V":
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
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    if (src.hasTitle())
      tgt.setTitleElement(String30_50.convertString(src.getTitleElement()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept30_50.convertCodeableConcept(src.getCode()));
    if (src.hasText())
      tgt.setText(Narrative30_50.convertNarrative(src.getText()));
//    if (src.hasMode())
//      tgt.setModeElement(convertSectionMode(src.getModeElement()));
    if (src.hasOrderedBy())
      tgt.setOrderedBy(CodeableConcept30_50.convertCodeableConcept(src.getOrderedBy()));
    for (org.hl7.fhir.r5.model.Reference t : src.getEntry()) tgt.addEntry(Reference30_50.convertReference(t));
    if (src.hasEmptyReason())
      tgt.setEmptyReason(CodeableConcept30_50.convertCodeableConcept(src.getEmptyReason()));
    for (org.hl7.fhir.r5.model.Composition.SectionComponent t : src.getSection())
      tgt.addSection(convertSectionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Composition.SectionComponent convertSectionComponent(org.hl7.fhir.dstu3.model.Composition.SectionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Composition.SectionComponent tgt = new org.hl7.fhir.r5.model.Composition.SectionComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    if (src.hasTitle())
      tgt.setTitleElement(String30_50.convertString(src.getTitleElement()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept30_50.convertCodeableConcept(src.getCode()));
    if (src.hasText())
      tgt.setText(Narrative30_50.convertNarrative(src.getText()));
//    if (src.hasMode())
//      tgt.setModeElement(convertSectionMode(src.getModeElement()));
    if (src.hasOrderedBy())
      tgt.setOrderedBy(CodeableConcept30_50.convertCodeableConcept(src.getOrderedBy()));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getEntry()) tgt.addEntry(Reference30_50.convertReference(t));
    if (src.hasEmptyReason())
      tgt.setEmptyReason(CodeableConcept30_50.convertCodeableConcept(src.getEmptyReason()));
    for (org.hl7.fhir.dstu3.model.Composition.SectionComponent t : src.getSection())
      tgt.addSection(convertSectionComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Composition.SectionMode> convertSectionMode(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ListMode> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Composition.SectionMode> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Composition.SectionModeEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
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

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ListMode> convertSectionMode(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Composition.SectionMode> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ListMode> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.ListModeEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    switch (src.getValue()) {
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