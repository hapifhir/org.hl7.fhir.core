package org.hl7.fhir.convertors.conv43_N.resources43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.CodeableConcept43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Coding43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Identifier43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Period43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Code43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.DateTime43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.String43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.special43_N.Narrative43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.special43_N.Reference43_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4b.model.Composition;
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

public class Composition43_N {

  public static org.hl7.fhir.model.core.Composition convertComposition(org.hl7.fhir.r4b.model.Composition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Composition tgt = new org.hl7.fhir.model.core.Composition();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    if (src.hasIdentifier())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(src.getIdentifier()));
    if (src.hasStatus())
      tgt.setStatusElement(convertCompositionStatus(src.getStatusElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept43_N.convertCodeableConcept(src.getType()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasSubject())
      tgt.addSubject(Reference43_N.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference43_N.convertReference(src.getEncounter()));
    if (src.hasDate())
      tgt.setDateElement(DateTime43_N.convertDateTime(src.getDateElement()));
    for (org.hl7.fhir.r4b.model.Reference t : src.getAuthor()) tgt.addAuthor(Reference43_N.convertReference(t));
    if (src.hasTitle())
      tgt.setTitleElement(String43_N.convertString(src.getTitleElement()));
    if (src.hasConfidentiality())
      tgt.getMeta().addSecurity().setCode(src.getConfidentiality());
    for (org.hl7.fhir.r4b.model.Composition.CompositionAttesterComponent t : src.getAttester())
      tgt.addAttester(convertCompositionAttesterComponent(t));
    if (src.hasCustodian())
      tgt.setCustodian(Reference43_N.convertReference(src.getCustodian()));
    for (org.hl7.fhir.r4b.model.Composition.CompositionRelatesToComponent t : src.getRelatesTo())
      tgt.addRelatesTo(convertCompositionRelatesToComponent(t));
    for (org.hl7.fhir.r4b.model.Composition.CompositionEventComponent t : src.getEvent())
      tgt.addEvent(convertCompositionEventComponent(t));
    for (org.hl7.fhir.r4b.model.Composition.SectionComponent t : src.getSection())
      tgt.addSection(convertSectionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Composition convertComposition(org.hl7.fhir.model.core.Composition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Composition tgt = new org.hl7.fhir.r4b.model.Composition();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier43_N.convertIdentifier(src.getIdentifierFirstRep()));
    if (src.hasStatus())
      tgt.setStatusElement(convertCompositionStatus(src.getStatusElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept43_N.convertCodeableConcept(src.getType()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getCategoryList())
      tgt.addCategory(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasSubject())
      tgt.setSubject(Reference43_N.convertReference(src.getSubjectFirstRep()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference43_N.convertReference(src.getEncounter()));
    if (src.hasDate())
      tgt.setDateElement(DateTime43_N.convertDateTime(src.getDateElement()));
    for (org.hl7.fhir.model.core.Reference t : src.getAuthorList()) tgt.addAuthor(Reference43_N.convertReference(t));
    if (src.hasTitle())
      tgt.setTitleElement(String43_N.convertString(src.getTitleElement()));
    if (src.getMeta().hasSecurity())
      tgt.setConfidentialityElement(Code43_N.convertCode(src.getMeta().getSecurityFirstRep().getCodeElement()));
    for (org.hl7.fhir.model.core.Composition.CompositionAttesterComponent t : src.getAttesterList())
      tgt.addAttester(convertCompositionAttesterComponent(t));
    if (src.hasCustodian())
      tgt.setCustodian(Reference43_N.convertReference(src.getCustodian()));
    for (org.hl7.fhir.model.core.Composition.CompositionRelatesToComponent t : src.getRelatesToList())
      tgt.addRelatesTo(convertCompositionRelatesToComponent(t));
    for (org.hl7.fhir.model.core.Composition.CompositionEventComponent t : src.getEventList())
      tgt.addEvent(convertCompositionEventComponent(t));
    for (org.hl7.fhir.model.core.Composition.SectionComponent t : src.getSectionList())
      tgt.addSection(convertSectionComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.CompositionStatus> convertCompositionStatus(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.CompositionStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Enumerations.CompositionStatus> tgt = new Enumeration<>(new Enumerations.CompositionStatusEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.CompositionStatus> convertCompositionStatus(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.CompositionStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.CompositionStatus> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.CompositionStatusEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
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
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.Composition.CompositionAttesterComponent convertCompositionAttesterComponent(org.hl7.fhir.r4b.model.Composition.CompositionAttesterComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Composition.CompositionAttesterComponent tgt = new org.hl7.fhir.model.core.Composition.CompositionAttesterComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasMode())
      tgt.setMode(convertCompositionAttestationMode(src.getModeElement()));
    if (src.hasTime())
      tgt.setTimeElement(DateTime43_N.convertDateTime(src.getTimeElement()));
    if (src.hasParty())
      tgt.setParty(Reference43_N.convertReference(src.getParty()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Composition.CompositionAttesterComponent convertCompositionAttesterComponent(org.hl7.fhir.model.core.Composition.CompositionAttesterComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Composition.CompositionAttesterComponent tgt = new org.hl7.fhir.r4b.model.Composition.CompositionAttesterComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasMode())
      tgt.setModeElement(convertCompositionAttestationMode(src.getMode()));
    if (src.hasTime())
      tgt.setTimeElement(DateTime43_N.convertDateTime(src.getTimeElement()));
    if (src.hasParty())
      tgt.setParty(Reference43_N.convertReference(src.getParty()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.CodeableConcept convertCompositionAttestationMode(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Composition.CompositionAttestationMode> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      CodeableConcept tgt = new CodeableConcept();
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Composition.CompositionAttestationMode> convertCompositionAttestationMode(org.hl7.fhir.model.core.CodeableConcept src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Composition.CompositionAttestationMode> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Composition.CompositionAttestationModeEnumFactory());
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
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

  public static org.hl7.fhir.model.core.Composition.CompositionRelatesToComponent convertCompositionRelatesToComponent(org.hl7.fhir.r4b.model.Composition.CompositionRelatesToComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Composition.CompositionRelatesToComponent tgt = new org.hl7.fhir.model.core.Composition.CompositionRelatesToComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.hasCode())
      tgt.setType(convertDocumentRelationshipType(src.getCodeElement()));
    if (src.hasTargetReference())
      tgt.setTarget(Reference43_N.convertReference(src.getTargetReference()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Composition.CompositionRelatesToComponent convertCompositionRelatesToComponent(org.hl7.fhir.model.core.Composition.CompositionRelatesToComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Composition.CompositionRelatesToComponent tgt = new org.hl7.fhir.r4b.model.Composition.CompositionRelatesToComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.hasType())
      tgt.setCodeElement(convertDocumentRelationshipType(src.getType()));
    if (src.hasTargetReference())
      tgt.setTarget(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getTargetReference()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.CodeableConcept convertDocumentRelationshipType(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.DocumentRelationshipType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
    org.hl7.fhir.model.core.CodeableConcept tgt = new org.hl7.fhir.model.core.CodeableConcept();
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.DocumentRelationshipType> convertDocumentRelationshipType(org.hl7.fhir.model.core.CodeableConcept src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.DocumentRelationshipType> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.DocumentRelationshipTypeEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.hasCoding("http://terminology.hl7.org/ValueSet/artifact-relationship-type", "replaces")) {
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.DocumentRelationshipType.REPLACES);
      } else if (src.hasCoding("http://terminology.hl7.org/ValueSet/artifact-relationship-type", "transforms")) {
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.DocumentRelationshipType.TRANSFORMS);
      } else if (src.hasCoding("http://terminology.hl7.org/ValueSet/artifact-relationship-type", "signs")) {
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.DocumentRelationshipType.SIGNS);
      } else if (src.hasCoding("http://terminology.hl7.org/ValueSet/artifact-relationship-type", "appends")) {
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.DocumentRelationshipType.APPENDS);
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.Composition.CompositionEventComponent convertCompositionEventComponent(org.hl7.fhir.r4b.model.Composition.CompositionEventComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Composition.CompositionEventComponent tgt = new org.hl7.fhir.model.core.Composition.CompositionEventComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getCode())
      tgt.addDetail().setConcept(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasPeriod())
      tgt.setPeriod(Period43_N.convertPeriod(src.getPeriod()));
    for (org.hl7.fhir.r4b.model.Reference t : src.getDetail()) tgt.addDetail().setReference(Reference43_N.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Composition.CompositionEventComponent convertCompositionEventComponent(org.hl7.fhir.model.core.Composition.CompositionEventComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Composition.CompositionEventComponent tgt = new org.hl7.fhir.r4b.model.Composition.CompositionEventComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasPeriod())
      tgt.setPeriod(Period43_N.convertPeriod(src.getPeriod()));
    for (CodeableReference t : src.getDetailList()) {
      if (t.hasConcept()) {
        tgt.addCode(CodeableConcept43_N.convertCodeableConcept(t.getConcept()));
      }
      if (t.hasReference()) {
        tgt.addDetail(Reference43_N.convertReference(t.getReference()));
      }
    }
    return tgt;
  }

  public static org.hl7.fhir.model.core.Composition.SectionComponent convertSectionComponent(org.hl7.fhir.r4b.model.Composition.SectionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Composition.SectionComponent tgt = new org.hl7.fhir.model.core.Composition.SectionComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasTitle())
      tgt.setTitleElement(String43_N.convertString(src.getTitleElement()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_N.convertCodeableConcept(src.getCode()));
    for (org.hl7.fhir.r4b.model.Reference t : src.getAuthor()) tgt.addAuthor(Reference43_N.convertReference(t));
    if (src.hasFocus())
      tgt.setFocus(Reference43_N.convertReference(src.getFocus()));
    if (src.hasText())
      tgt.setText(Narrative43_N.convertNarrative(src.getText()));
//    if (src.hasMode())
//      tgt.setModeElement(convertSectionMode(src.getModeElement()));
    if (src.hasOrderedBy())
      tgt.setOrderedBy(CodeableConcept43_N.convertCodeableConcept(src.getOrderedBy()));
    for (org.hl7.fhir.r4b.model.Reference t : src.getEntry()) tgt.addEntry(Reference43_N.convertReference(t));
    if (src.hasEmptyReason())
      tgt.setEmptyReason(CodeableConcept43_N.convertCodeableConcept(src.getEmptyReason()));
    for (org.hl7.fhir.r4b.model.Composition.SectionComponent t : src.getSection())
      tgt.addSection(convertSectionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Composition.SectionComponent convertSectionComponent(org.hl7.fhir.model.core.Composition.SectionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Composition.SectionComponent tgt = new org.hl7.fhir.r4b.model.Composition.SectionComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasTitle())
      tgt.setTitleElement(String43_N.convertString(src.getTitleElement()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_N.convertCodeableConcept(src.getCode()));
    for (org.hl7.fhir.model.core.Reference t : src.getAuthorList()) tgt.addAuthor(Reference43_N.convertReference(t));
    if (src.hasFocus())
      tgt.setFocus(Reference43_N.convertReference(src.getFocus()));
    if (src.hasText())
      tgt.setText(Narrative43_N.convertNarrative(src.getText()));
//    if (src.hasMode())
//      tgt.setModeElement(convertSectionMode(src.getModeElement()));
    if (src.hasOrderedBy())
      tgt.setOrderedBy(CodeableConcept43_N.convertCodeableConcept(src.getOrderedBy()));
    for (org.hl7.fhir.model.core.Reference t : src.getEntryList()) tgt.addEntry(Reference43_N.convertReference(t));
    if (src.hasEmptyReason())
      tgt.setEmptyReason(CodeableConcept43_N.convertCodeableConcept(src.getEmptyReason()));
    for (org.hl7.fhir.model.core.Composition.SectionComponent t : src.getSectionList())
      tgt.addSection(convertSectionComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.ListResource.ListMode> convertSectionMode(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.ListMode> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<ListResource.ListMode> tgt = new Enumeration<>(new ListResource.ListModeEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.ListMode> convertSectionMode(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.ListResource.ListMode> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.ListMode> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.ListModeEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
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
      }
      return tgt;
  }
}