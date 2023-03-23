package org.hl7.fhir.convertors.conv43_50.resources43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.CodeableConcept43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Identifier43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Period43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Code43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.DateTime43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.String43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.special43_50.Narrative43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.special43_50.Reference43_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CodeableReference;
import org.hl7.fhir.r5.model.RelatedArtifact;

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
public class Composition43_50 {

  public static org.hl7.fhir.r5.model.Composition convertComposition(org.hl7.fhir.r4b.model.Composition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Composition tgt = new org.hl7.fhir.r5.model.Composition();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    if (src.hasIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(src.getIdentifier()));
    if (src.hasStatus())
      tgt.setStatusElement(convertCompositionStatus(src.getStatusElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasSubject())
      tgt.addSubject(Reference43_50.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference43_50.convertReference(src.getEncounter()));
    if (src.hasDate())
      tgt.setDateElement(DateTime43_50.convertDateTime(src.getDateElement()));
    for (org.hl7.fhir.r4b.model.Reference t : src.getAuthor()) tgt.addAuthor(Reference43_50.convertReference(t));
    if (src.hasTitle())
      tgt.setTitleElement(String43_50.convertString(src.getTitleElement()));
    if (src.hasConfidentiality())
      tgt.getMeta().addSecurity().setCodeElement(Code43_50.convertCode(src.getConfidentialityElement()));
    for (org.hl7.fhir.r4b.model.Composition.CompositionAttesterComponent t : src.getAttester())
      tgt.addAttester(convertCompositionAttesterComponent(t));
    if (src.hasCustodian())
      tgt.setCustodian(Reference43_50.convertReference(src.getCustodian()));
    for (org.hl7.fhir.r4b.model.Composition.CompositionRelatesToComponent t : src.getRelatesTo())
      tgt.addRelatesTo(convertCompositionRelatesToComponent(t));
    for (org.hl7.fhir.r4b.model.Composition.CompositionEventComponent t : src.getEvent())
      tgt.addEvent(convertCompositionEventComponent(t));
    for (org.hl7.fhir.r4b.model.Composition.SectionComponent t : src.getSection())
      tgt.addSection(convertSectionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Composition convertComposition(org.hl7.fhir.r5.model.Composition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Composition tgt = new org.hl7.fhir.r4b.model.Composition();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier43_50.convertIdentifier(src.getIdentifierFirstRep()));
    if (src.hasStatus())
      tgt.setStatusElement(convertCompositionStatus(src.getStatusElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasSubject())
      tgt.setSubject(Reference43_50.convertReference(src.getSubjectFirstRep()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference43_50.convertReference(src.getEncounter()));
    if (src.hasDate())
      tgt.setDateElement(DateTime43_50.convertDateTime(src.getDateElement()));
    for (org.hl7.fhir.r5.model.Reference t : src.getAuthor()) tgt.addAuthor(Reference43_50.convertReference(t));
    if (src.hasTitle())
      tgt.setTitleElement(String43_50.convertString(src.getTitleElement()));
    if (src.getMeta().hasSecurity())
      tgt.setConfidentialityElement(Code43_50.convertCode(src.getMeta().getSecurityFirstRep().getCodeElement()));
    for (org.hl7.fhir.r5.model.Composition.CompositionAttesterComponent t : src.getAttester())
      tgt.addAttester(convertCompositionAttesterComponent(t));
    if (src.hasCustodian())
      tgt.setCustodian(Reference43_50.convertReference(src.getCustodian()));
    for (RelatedArtifact t : src.getRelatesTo())
      tgt.addRelatesTo(convertCompositionRelatesToComponent(t));
    for (org.hl7.fhir.r5.model.Composition.CompositionEventComponent t : src.getEvent())
      tgt.addEvent(convertCompositionEventComponent(t));
    for (org.hl7.fhir.r5.model.Composition.SectionComponent t : src.getSection())
      tgt.addSection(convertSectionComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.CompositionStatus> convertCompositionStatus(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.CompositionStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.CompositionStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.CompositionStatusEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.CompositionStatus> convertCompositionStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.CompositionStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.CompositionStatus> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.CompositionStatusEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case PRELIMINARY:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.CompositionStatus.PRELIMINARY);
        break;
      case FINAL:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.CompositionStatus.FINAL);
        break;
      case AMENDED:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.CompositionStatus.AMENDED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.CompositionStatus.ENTEREDINERROR);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.CompositionStatus.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Composition.CompositionAttesterComponent convertCompositionAttesterComponent(org.hl7.fhir.r4b.model.Composition.CompositionAttesterComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Composition.CompositionAttesterComponent tgt = new org.hl7.fhir.r5.model.Composition.CompositionAttesterComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasMode())
      tgt.setMode(convertCompositionAttestationMode(src.getModeElement()));
    if (src.hasTime())
      tgt.setTimeElement(DateTime43_50.convertDateTime(src.getTimeElement()));
    if (src.hasParty())
      tgt.setParty(Reference43_50.convertReference(src.getParty()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Composition.CompositionAttesterComponent convertCompositionAttesterComponent(org.hl7.fhir.r5.model.Composition.CompositionAttesterComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Composition.CompositionAttesterComponent tgt = new org.hl7.fhir.r4b.model.Composition.CompositionAttesterComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasMode())
      tgt.setModeElement(convertCompositionAttestationMode(src.getMode()));
    if (src.hasTime())
      tgt.setTimeElement(DateTime43_50.convertDateTime(src.getTimeElement()));
    if (src.hasParty())
      tgt.setParty(Reference43_50.convertReference(src.getParty()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.CodeableConcept convertCompositionAttestationMode(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Composition.CompositionAttestationMode> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.CodeableConcept tgt = new org.hl7.fhir.r5.model.CodeableConcept();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Composition.CompositionAttestationMode> convertCompositionAttestationMode(org.hl7.fhir.r5.model.CodeableConcept src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Composition.CompositionAttestationMode> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Composition.CompositionAttestationModeEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getCode("http://hl7.org/fhir/composition-attestation-mode")) {
      case "personal":
        tgt.setValue(org.hl7.fhir.r4b.model.Composition.CompositionAttestationMode.PERSONAL);
        break;
      case "professional":
        tgt.setValue(org.hl7.fhir.r4b.model.Composition.CompositionAttestationMode.PROFESSIONAL);
        break;
      case "legal":
        tgt.setValue(org.hl7.fhir.r4b.model.Composition.CompositionAttestationMode.LEGAL);
        break;
      case "official":
        tgt.setValue(org.hl7.fhir.r4b.model.Composition.CompositionAttestationMode.OFFICIAL);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.Composition.CompositionAttestationMode.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.RelatedArtifact convertCompositionRelatesToComponent(org.hl7.fhir.r4b.model.Composition.CompositionRelatesToComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.RelatedArtifact tgt = new org.hl7.fhir.r5.model.RelatedArtifact();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.hasCode())
      tgt.setTypeElement(convertDocumentRelationshipType(src.getCodeElement()));
    if (src.hasTargetReference())
      tgt.setResourceReference(Reference43_50.convertReference(src.getTargetReference()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Composition.CompositionRelatesToComponent convertCompositionRelatesToComponent(org.hl7.fhir.r5.model.RelatedArtifact src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Composition.CompositionRelatesToComponent tgt = new org.hl7.fhir.r4b.model.Composition.CompositionRelatesToComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.hasType())
      tgt.setCodeElement(convertDocumentRelationshipType(src.getTypeElement()));
    if (src.hasResourceReference())
      tgt.setTarget(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getResourceReference()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.RelatedArtifact.RelatedArtifactType> convertDocumentRelationshipType(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.DocumentRelationshipType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.RelatedArtifact.RelatedArtifactType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.RelatedArtifact.RelatedArtifactTypeEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.DocumentRelationshipType> convertDocumentRelationshipType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.RelatedArtifact.RelatedArtifactType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.DocumentRelationshipType> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.DocumentRelationshipTypeEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case REPLACES:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.DocumentRelationshipType.REPLACES);
        break;
      case TRANSFORMS:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.DocumentRelationshipType.TRANSFORMS);
        break;
      case SIGNS:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.DocumentRelationshipType.SIGNS);
        break;
      case APPENDS:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.DocumentRelationshipType.APPENDS);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.DocumentRelationshipType.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Composition.CompositionEventComponent convertCompositionEventComponent(org.hl7.fhir.r4b.model.Composition.CompositionEventComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Composition.CompositionEventComponent tgt = new org.hl7.fhir.r5.model.Composition.CompositionEventComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getCode())
      tgt.addDetail().setConcept(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasPeriod())
      tgt.setPeriod(Period43_50.convertPeriod(src.getPeriod()));
    for (org.hl7.fhir.r4b.model.Reference t : src.getDetail()) tgt.addDetail().setReference(Reference43_50.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Composition.CompositionEventComponent convertCompositionEventComponent(org.hl7.fhir.r5.model.Composition.CompositionEventComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Composition.CompositionEventComponent tgt = new org.hl7.fhir.r4b.model.Composition.CompositionEventComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasPeriod())
      tgt.setPeriod(Period43_50.convertPeriod(src.getPeriod()));
    for (CodeableReference t : src.getDetail()) {
      if (t.hasConcept()) {
        tgt.addCode(CodeableConcept43_50.convertCodeableConcept(t.getConcept()));
      }
      if (t.hasReference()) {
        tgt.addDetail(Reference43_50.convertReference(t.getReference()));
      }
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Composition.SectionComponent convertSectionComponent(org.hl7.fhir.r4b.model.Composition.SectionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Composition.SectionComponent tgt = new org.hl7.fhir.r5.model.Composition.SectionComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasTitle())
      tgt.setTitleElement(String43_50.convertString(src.getTitleElement()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_50.convertCodeableConcept(src.getCode()));
    for (org.hl7.fhir.r4b.model.Reference t : src.getAuthor()) tgt.addAuthor(Reference43_50.convertReference(t));
    if (src.hasFocus())
      tgt.setFocus(Reference43_50.convertReference(src.getFocus()));
    if (src.hasText())
      tgt.setText(Narrative43_50.convertNarrative(src.getText()));
//    if (src.hasMode())
//      tgt.setModeElement(convertSectionMode(src.getModeElement()));
    if (src.hasOrderedBy())
      tgt.setOrderedBy(CodeableConcept43_50.convertCodeableConcept(src.getOrderedBy()));
    for (org.hl7.fhir.r4b.model.Reference t : src.getEntry()) tgt.addEntry(Reference43_50.convertReference(t));
    if (src.hasEmptyReason())
      tgt.setEmptyReason(CodeableConcept43_50.convertCodeableConcept(src.getEmptyReason()));
    for (org.hl7.fhir.r4b.model.Composition.SectionComponent t : src.getSection())
      tgt.addSection(convertSectionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Composition.SectionComponent convertSectionComponent(org.hl7.fhir.r5.model.Composition.SectionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Composition.SectionComponent tgt = new org.hl7.fhir.r4b.model.Composition.SectionComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasTitle())
      tgt.setTitleElement(String43_50.convertString(src.getTitleElement()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_50.convertCodeableConcept(src.getCode()));
    for (org.hl7.fhir.r5.model.Reference t : src.getAuthor()) tgt.addAuthor(Reference43_50.convertReference(t));
    if (src.hasFocus())
      tgt.setFocus(Reference43_50.convertReference(src.getFocus()));
    if (src.hasText())
      tgt.setText(Narrative43_50.convertNarrative(src.getText()));
//    if (src.hasMode())
//      tgt.setModeElement(convertSectionMode(src.getModeElement()));
    if (src.hasOrderedBy())
      tgt.setOrderedBy(CodeableConcept43_50.convertCodeableConcept(src.getOrderedBy()));
    for (org.hl7.fhir.r5.model.Reference t : src.getEntry()) tgt.addEntry(Reference43_50.convertReference(t));
    if (src.hasEmptyReason())
      tgt.setEmptyReason(CodeableConcept43_50.convertCodeableConcept(src.getEmptyReason()));
    for (org.hl7.fhir.r5.model.Composition.SectionComponent t : src.getSection())
      tgt.addSection(convertSectionComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ListMode> convertSectionMode(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.ListMode> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ListMode> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.ListModeEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.ListMode> convertSectionMode(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ListMode> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.ListMode> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.ListModeEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case WORKING:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.ListMode.WORKING);
        break;
      case SNAPSHOT:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.ListMode.SNAPSHOT);
        break;
      case CHANGES:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.ListMode.CHANGES);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.ListMode.NULL);
        break;
    }
    return tgt;
  }
}