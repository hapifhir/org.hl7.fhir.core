package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Identifier40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Period40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.DateTime40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.String40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Narrative40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Reference40_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.Composition;
import org.hl7.fhir.model.core.*;

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

public class Composition40_N {

  public static org.hl7.fhir.model.core.Composition convertComposition(org.hl7.fhir.r4.model.Composition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Composition tgt = new org.hl7.fhir.model.core.Composition();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    if (src.hasIdentifier())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(src.getIdentifier()));
    if (src.hasStatus())
      tgt.setStatusElement(convertCompositionStatus(src.getStatusElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasSubject())
      tgt.addSubject(Reference40_N.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference40_N.convertReference(src.getEncounter()));
    if (src.hasDate())
      tgt.setDateElement(DateTime40_N.convertDateTime(src.getDateElement()));
    for (org.hl7.fhir.r4.model.Reference t : src.getAuthor()) tgt.addAuthor(Reference40_N.convertReference(t));
    if (src.hasTitle())
      tgt.setTitleElement(String40_N.convertString(src.getTitleElement()));
    if (src.hasConfidentiality())
      tgt.getMeta().addSecurity().setCode(src.getConfidentiality().toCode());
    for (org.hl7.fhir.r4.model.Composition.CompositionAttesterComponent t : src.getAttester())
      tgt.addAttester(convertCompositionAttesterComponent(t));
    if (src.hasCustodian())
      tgt.setCustodian(Reference40_N.convertReference(src.getCustodian()));
    for (org.hl7.fhir.r4.model.Composition.CompositionRelatesToComponent t : src.getRelatesTo())
      tgt.addRelatesTo(convertCompositionRelatesToComponent(t));
    for (org.hl7.fhir.r4.model.Composition.CompositionEventComponent t : src.getEvent())
      tgt.addEvent(convertCompositionEventComponent(t));
    for (org.hl7.fhir.r4.model.Composition.SectionComponent t : src.getSection())
      tgt.addSection(convertSectionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Composition convertComposition(org.hl7.fhir.model.core.Composition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Composition tgt = new org.hl7.fhir.r4.model.Composition();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier40_N.convertIdentifier(src.getIdentifierFirstRep()));
    if (src.hasStatus())
      tgt.setStatusElement(convertCompositionStatus(src.getStatusElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getCategoryList())
      tgt.addCategory(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasSubject())
      tgt.setSubject(Reference40_N.convertReference(src.getSubjectFirstRep()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference40_N.convertReference(src.getEncounter()));
    if (src.hasDate())
      tgt.setDateElement(DateTime40_N.convertDateTime(src.getDateElement()));
    for (org.hl7.fhir.model.core.Reference t : src.getAuthorList()) tgt.addAuthor(Reference40_N.convertReference(t));
    if (src.hasTitle())
      tgt.setTitleElement(String40_N.convertString(src.getTitleElement()));
    if (src.getMeta().hasSecurity())
      tgt.setConfidentialityElement(convertDocumentConfidentiality(src.getMeta().getSecurityFirstRep()));
    for (org.hl7.fhir.model.core.Composition.CompositionAttesterComponent t : src.getAttesterList())
      tgt.addAttester(convertCompositionAttesterComponent(t));
    if (src.hasCustodian())
      tgt.setCustodian(Reference40_N.convertReference(src.getCustodian()));
    for (org.hl7.fhir.model.core.Composition.CompositionRelatesToComponent t : src.getRelatesToList())
      tgt.addRelatesTo(convertCompositionRelatesToComponent(t));
    for (org.hl7.fhir.model.core.Composition.CompositionEventComponent t : src.getEventList())
      tgt.addEvent(convertCompositionEventComponent(t));
    for (org.hl7.fhir.model.core.Composition.SectionComponent t : src.getSectionList())
      tgt.addSection(convertSectionComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.CompositionStatus> convertCompositionStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Composition.CompositionStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Enumerations.CompositionStatus> tgt = new Enumeration<>(new Enumerations.CompositionStatusEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case PRELIMINARY:
                  tgt.setValue(Enumerations.CompositionStatus.PRELIMINARY);
                  break;
              case FINAL:
                  tgt.setValue(Enumerations.CompositionStatus.FINAL);
                  break;
              case AMENDED:
                  tgt.setValue(Enumerations.CompositionStatus.AMENDED);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(Enumerations.CompositionStatus.ENTEREDINERROR);
                  break;
              default:
                  tgt.setValue(Enumerations.CompositionStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Composition.CompositionStatus> convertCompositionStatus(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.CompositionStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<Composition.CompositionStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new Composition.CompositionStatusEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case PRELIMINARY:
                  tgt.setValue(Composition.CompositionStatus.PRELIMINARY);
                  break;
              case FINAL:
                  tgt.setValue(Composition.CompositionStatus.FINAL);
                  break;
              case AMENDED:
                  tgt.setValue(Composition.CompositionStatus.AMENDED);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(Composition.CompositionStatus.ENTEREDINERROR);
                  break;
              default:
                  tgt.setValue(Composition.CompositionStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.model.core.Coding convertDocumentConfidentiality(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Composition.DocumentConfidentiality> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.model.core.Coding tgt = new org.hl7.fhir.model.core.Coding();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    tgt.setCode(src.getValue().toCode());
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Composition.DocumentConfidentiality> convertDocumentConfidentiality(org.hl7.fhir.model.core.Coding src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Composition.DocumentConfidentiality> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Composition.DocumentConfidentialityEnumFactory());
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    switch (src.getCode()) {
      case "U":
        tgt.setValue(org.hl7.fhir.r4.model.Composition.DocumentConfidentiality.U);
        break;
      case "L":
        tgt.setValue(org.hl7.fhir.r4.model.Composition.DocumentConfidentiality.L);
        break;
      case "M":
        tgt.setValue(org.hl7.fhir.r4.model.Composition.DocumentConfidentiality.M);
        break;
      case "N":
        tgt.setValue(org.hl7.fhir.r4.model.Composition.DocumentConfidentiality.N);
        break;
      case "R":
        tgt.setValue(org.hl7.fhir.r4.model.Composition.DocumentConfidentiality.R);
        break;
      case "V":
        tgt.setValue(org.hl7.fhir.r4.model.Composition.DocumentConfidentiality.V);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.Composition.DocumentConfidentiality.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.model.core.Composition.CompositionAttesterComponent convertCompositionAttesterComponent(org.hl7.fhir.r4.model.Composition.CompositionAttesterComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Composition.CompositionAttesterComponent tgt = new org.hl7.fhir.model.core.Composition.CompositionAttesterComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasMode())
      tgt.setMode(convertCompositionAttestationMode(src.getModeElement()));
    if (src.hasTime())
      tgt.setTimeElement(DateTime40_N.convertDateTime(src.getTimeElement()));
    if (src.hasParty())
      tgt.setParty(Reference40_N.convertReference(src.getParty()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Composition.CompositionAttesterComponent convertCompositionAttesterComponent(org.hl7.fhir.model.core.Composition.CompositionAttesterComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Composition.CompositionAttesterComponent tgt = new org.hl7.fhir.r4.model.Composition.CompositionAttesterComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasMode())
      tgt.setModeElement(convertCompositionAttestationMode(src.getMode()));
    if (src.hasTime())
      tgt.setTimeElement(DateTime40_N.convertDateTime(src.getTimeElement()));
    if (src.hasParty())
      tgt.setParty(Reference40_N.convertReference(src.getParty()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.CodeableConcept convertCompositionAttestationMode(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Composition.CompositionAttestationMode> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      CodeableConcept tgt = new CodeableConcept();
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
        // Add nothing
      } else {
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
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Composition.CompositionAttestationMode> convertCompositionAttestationMode(org.hl7.fhir.model.core.CodeableConcept src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Composition.CompositionAttestationMode> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Composition.CompositionAttestationModeEnumFactory());
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    switch (src.getCode("http://hl7.org/fhir/composition-attestation-mode")) {
      case "personal":
        tgt.setValue(org.hl7.fhir.r4.model.Composition.CompositionAttestationMode.PERSONAL);
        break;
      case "professional":
        tgt.setValue(org.hl7.fhir.r4.model.Composition.CompositionAttestationMode.PROFESSIONAL);
        break;
      case "legal":
        tgt.setValue(org.hl7.fhir.r4.model.Composition.CompositionAttestationMode.LEGAL);
        break;
      case "official":
        tgt.setValue(org.hl7.fhir.r4.model.Composition.CompositionAttestationMode.OFFICIAL);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.Composition.CompositionAttestationMode.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.model.core.Composition.CompositionRelatesToComponent convertCompositionRelatesToComponent(org.hl7.fhir.r4.model.Composition.CompositionRelatesToComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Composition.CompositionRelatesToComponent tgt = new org.hl7.fhir.model.core.Composition.CompositionRelatesToComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasCode())
      tgt.setType(convertDocumentRelationshipType(src.getCodeElement()));
    if (src.hasTargetReference())
      tgt.setTarget(Reference40_N.convertReference(src.getTargetReference()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Composition.CompositionRelatesToComponent convertCompositionRelatesToComponent(org.hl7.fhir.model.core.Composition.CompositionRelatesToComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Composition.CompositionRelatesToComponent tgt = new org.hl7.fhir.r4.model.Composition.CompositionRelatesToComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasType())
      tgt.setCodeElement(convertDocumentRelationshipType(src.getType()));
    if (src.hasTargetReference())
      tgt.setTarget(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getTargetReference()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.CodeableConcept convertDocumentRelationshipType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Composition.DocumentRelationshipType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
    org.hl7.fhir.model.core.CodeableConcept tgt = new org.hl7.fhir.model.core.CodeableConcept();
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() != null) {
          switch (src.getValue()) {
              case REPLACES:
                tgt.addCoding().setSystem("http://terminology.hl7.org/ValueSet/artifact-relationship-type").setCode("replaces").setDisplay("Replaces");
                  break;
              case TRANSFORMS:
                tgt.addCoding().setSystem("http://terminology.hl7.org/ValueSet/artifact-relationship-type").setCode("transforms").setDisplay("Transforms");
                  break;
              case SIGNS:
                tgt.addCoding().setSystem("http://terminology.hl7.org/ValueSet/artifact-relationship-type").setCode("signs").setDisplay("Signs");
                  break;
              case APPENDS:
                tgt.addCoding().setSystem("http://terminology.hl7.org/ValueSet/artifact-relationship-type").setCode("appends").setDisplay("Appends");
                  break;
              default:
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Composition.DocumentRelationshipType> convertDocumentRelationshipType(org.hl7.fhir.model.core.CodeableConcept src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<Composition.DocumentRelationshipType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new Composition.DocumentRelationshipTypeEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.hasCoding("http://terminology.hl7.org/ValueSet/artifact-relationship-type", "replaces")) {
        tgt.setValue(Composition.DocumentRelationshipType.REPLACES);
      } else if (src.hasCoding("http://terminology.hl7.org/ValueSet/artifact-relationship-type", "transforms")) {
        tgt.setValue(Composition.DocumentRelationshipType.TRANSFORMS);
      } else if (src.hasCoding("http://terminology.hl7.org/ValueSet/artifact-relationship-type", "signs")) {
        tgt.setValue(Composition.DocumentRelationshipType.SIGNS);
      } else if (src.hasCoding("http://terminology.hl7.org/ValueSet/artifact-relationship-type", "appends")) {
        tgt.setValue(Composition.DocumentRelationshipType.APPENDS);
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.Composition.CompositionEventComponent convertCompositionEventComponent(org.hl7.fhir.r4.model.Composition.CompositionEventComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Composition.CompositionEventComponent tgt = new org.hl7.fhir.model.core.Composition.CompositionEventComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCode())
      tgt.addDetail().setConcept(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasPeriod())
      tgt.setPeriod(Period40_N.convertPeriod(src.getPeriod()));
    for (org.hl7.fhir.r4.model.Reference t : src.getDetail()) tgt.addDetail().setReference(Reference40_N.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Composition.CompositionEventComponent convertCompositionEventComponent(org.hl7.fhir.model.core.Composition.CompositionEventComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Composition.CompositionEventComponent tgt = new org.hl7.fhir.r4.model.Composition.CompositionEventComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasPeriod())
      tgt.setPeriod(Period40_N.convertPeriod(src.getPeriod()));
    for (CodeableReference t : src.getDetailList()) {
      if (t.hasConcept()) {
        tgt.addCode(CodeableConcept40_N.convertCodeableConcept(t.getConcept()));
      }
      if (t.hasReference()) {
        tgt.addDetail(Reference40_N.convertReference(t.getReference()));
      }
    }
    return tgt;
  }

  public static org.hl7.fhir.model.core.Composition.SectionComponent convertSectionComponent(org.hl7.fhir.r4.model.Composition.SectionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Composition.SectionComponent tgt = new org.hl7.fhir.model.core.Composition.SectionComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasTitle())
      tgt.setTitleElement(String40_N.convertString(src.getTitleElement()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_N.convertCodeableConcept(src.getCode()));
    for (org.hl7.fhir.r4.model.Reference t : src.getAuthor()) tgt.addAuthor(Reference40_N.convertReference(t));
    if (src.hasFocus())
      tgt.setFocus(Reference40_N.convertReference(src.getFocus()));
    if (src.hasText())
      tgt.setText(Narrative40_N.convertNarrative(src.getText()));
//    if (src.hasMode())
//      tgt.setModeElement(convertSectionMode(src.getModeElement()));
    if (src.hasOrderedBy())
      tgt.setOrderedBy(CodeableConcept40_N.convertCodeableConcept(src.getOrderedBy()));
    for (org.hl7.fhir.r4.model.Reference t : src.getEntry()) tgt.addEntry(Reference40_N.convertReference(t));
    if (src.hasEmptyReason())
      tgt.setEmptyReason(CodeableConcept40_N.convertCodeableConcept(src.getEmptyReason()));
    for (org.hl7.fhir.r4.model.Composition.SectionComponent t : src.getSection())
      tgt.addSection(convertSectionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Composition.SectionComponent convertSectionComponent(org.hl7.fhir.model.core.Composition.SectionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Composition.SectionComponent tgt = new org.hl7.fhir.r4.model.Composition.SectionComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasTitle())
      tgt.setTitleElement(String40_N.convertString(src.getTitleElement()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_N.convertCodeableConcept(src.getCode()));
    for (org.hl7.fhir.model.core.Reference t : src.getAuthorList()) tgt.addAuthor(Reference40_N.convertReference(t));
    if (src.hasFocus())
      tgt.setFocus(Reference40_N.convertReference(src.getFocus()));
    if (src.hasText())
      tgt.setText(Narrative40_N.convertNarrative(src.getText()));
//    if (src.hasMode())
//      tgt.setModeElement(convertSectionMode(src.getModeElement()));
    if (src.hasOrderedBy())
      tgt.setOrderedBy(CodeableConcept40_N.convertCodeableConcept(src.getOrderedBy()));
    for (org.hl7.fhir.model.core.Reference t : src.getEntryList()) tgt.addEntry(Reference40_N.convertReference(t));
    if (src.hasEmptyReason())
      tgt.setEmptyReason(CodeableConcept40_N.convertCodeableConcept(src.getEmptyReason()));
    for (org.hl7.fhir.model.core.Composition.SectionComponent t : src.getSectionList())
      tgt.addSection(convertSectionComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.ListResource.ListMode> convertSectionMode(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Composition.SectionMode> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<ListResource.ListMode> tgt = new Enumeration<>(new ListResource.ListModeEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case WORKING:
                  tgt.setValue(ListResource.ListMode.WORKING);
                  break;
              case SNAPSHOT:
                  tgt.setValue(ListResource.ListMode.SNAPSHOT);
                  break;
              case CHANGES:
                  tgt.setValue(ListResource.ListMode.CHANGES);
                  break;
              default:
                  tgt.setValue(ListResource.ListMode.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Composition.SectionMode> convertSectionMode(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.ListResource.ListMode> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<Composition.SectionMode> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new Composition.SectionModeEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case WORKING:
                  tgt.setValue(Composition.SectionMode.WORKING);
                  break;
              case SNAPSHOT:
                  tgt.setValue(Composition.SectionMode.SNAPSHOT);
                  break;
              case CHANGES:
                  tgt.setValue(Composition.SectionMode.CHANGES);
                  break;
              default:
                  tgt.setValue(Composition.SectionMode.NULL);
                  break;
          }
      }
      return tgt;
  }
}