package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.CrossVersionElements40_N;
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

  public static final String RELATIONSHIP_SYSTEM = "http://terminology.hl7.org/CodeSystem/artifact-relationship-type";
  // R6 codeable concepts that R4 codes can't hold (other codes, other codings, text)
  public static final String ATTESTER_MODE_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-Composition.attester.mode";
  public static final String RELATES_TO_TYPE_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-Composition.relatesTo.type";
  // R6 relatesTo.target[x] types that R4 doesn't have
  public static final String RELATES_TO_TARGET_EXTENSION_URL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-Composition.relatesTo.target";

  private static void keepCodeableConcept(org.hl7.fhir.model.core.CodeableConcept src, org.hl7.fhir.r4.model.Element tgt, org.hl7.fhir.model.core.CodeableConcept regenerated, String url) throws FHIRException {
    if (tgt != null && (regenerated == null || !src.equalsDeep(regenerated)))
      tgt.addExtension(url, CodeableConcept40_N.convertCodeableConcept(src));
  }

  private static boolean hasKeptCodeableConcept(org.hl7.fhir.r4.model.Element src, String url) {
    return src.hasExtension(url);
  }

  private static org.hl7.fhir.model.core.CodeableConcept keptCodeableConcept(org.hl7.fhir.r4.model.Element src, String url) throws FHIRException {
    return CodeableConcept40_N.convertCodeableConcept((org.hl7.fhir.r4.model.CodeableConcept) src.getExtensionByUrl(url).getValue());
  }

  public static final String CONFIDENTIALITY_SYSTEM = "http://terminology.hl7.org/CodeSystem/v3-Confidentiality";

  private static boolean isConfidentiality(org.hl7.fhir.model.core.Coding c) {
    return (CONFIDENTIALITY_SYSTEM.equals(c.getSystem()) || !c.hasSystem()) && org.hl7.fhir.utilities.Utilities.existsInList(c.getCode(), "U", "L", "M", "N", "R", "V");
  }

  public static org.hl7.fhir.model.core.Composition convertComposition(org.hl7.fhir.r4.model.Composition src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Composition tgt = new org.hl7.fhir.model.core.Composition();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt, CrossVersionElements40_N.urls("Composition", "5.0", new String[] {"url", "version", "useContext", "name", "note"}, CrossVersionElements40_N.urls("Composition", "6.0", new String[] {"consent", "basedOn", "participant", "classification"})));
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "5.0", "url", "version", "useContext", "name", "note");
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "6.0", "consent", "basedOn", "participant", "classification");
    if (src.hasIdentifier())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(src.getIdentifier()));
    CrossVersionElements40_N.extraValuesToR6(src.getExtension(), tgt, "identifier", tgt.getExtension());
    if (src.hasStatus())
      tgt.setStatusElement(CrossVersionElements40_N.toR6Code(src.getStatusElement(), convertCompositionStatus(src.getStatusElement()), src.fhirType(), "status"));
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasSubject())
      tgt.addSubject(Reference40_N.convertReference(src.getSubject()));
    CrossVersionElements40_N.extraValuesToR6(src.getExtension(), tgt, "subject", tgt.getExtension());
    if (src.hasEncounter())
      tgt.setEncounter(Reference40_N.convertReference(src.getEncounter()));
    if (src.hasDate())
      tgt.setDateElement(DateTime40_N.convertDateTime(src.getDateElement()));
    for (org.hl7.fhir.r4.model.Reference t : src.getAuthor()) tgt.addAuthor(Reference40_N.convertReference(t));
    if (src.hasTitle())
      tgt.setTitleElement(String40_N.convertString(src.getTitleElement()));
    // R6 moved confidentiality to a security label: the last one (see below). If R4 has no confidentiality, the
    // security labels that look like it are marked as just labels
    if (src.hasConfidentiality())
      tgt.getMeta().addSecurity(convertDocumentConfidentiality(src.getConfidentialityElement()));
    else
      for (org.hl7.fhir.model.core.Coding c : tgt.getMeta().getSecurityList())
        if (isConfidentiality(c))
          c.addExtension(VersionConvertorConstants.EXT_SECURITY_LABEL_ONLY, new org.hl7.fhir.model.core.BooleanType(true));
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
    CrossVersionElements40_N.elementsToExtensions(src, tgt.getExtension(), "5.0", "url", "version", "useContext", "name", "note");
    CrossVersionElements40_N.elementsToExtensions(src, tgt.getExtension(), "6.0", "consent", "basedOn", "participant", "classification");
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier40_N.convertIdentifier(src.getIdentifierFirstRep()));
    CrossVersionElements40_N.extraValuesToR4(src, "identifier", tgt.getExtension());
    if (src.hasStatus())
      tgt.setStatusElement(CrossVersionElements40_N.toR4Code(src.getStatusElement(), convertCompositionStatus(src.getStatusElement()), src.fhirType(), "status"));
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getCategoryList())
      tgt.addCategory(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasSubject())
      tgt.setSubject(Reference40_N.convertReference(src.getSubjectFirstRep()));
    CrossVersionElements40_N.extraValuesToR4(src, "subject", tgt.getExtension());
    if (src.hasEncounter())
      tgt.setEncounter(Reference40_N.convertReference(src.getEncounter()));
    if (src.hasDate())
      tgt.setDateElement(DateTime40_N.convertDateTime(src.getDateElement()));
    for (org.hl7.fhir.model.core.Reference t : src.getAuthorList()) tgt.addAuthor(Reference40_N.convertReference(t));
    if (src.hasTitle())
      tgt.setTitleElement(String40_N.convertString(src.getTitleElement()));
    // the last confidentiality security label (that isn't marked as just a label) is R4 confidentiality, and not a
    // security label as well
    int conf = -1;
    for (int i = 0; i < src.getMeta().getSecurityList().size(); i++) {
      org.hl7.fhir.model.core.Coding c = src.getMeta().getSecurityList().get(i);
      if (isConfidentiality(c) && !c.hasExtension(VersionConvertorConstants.EXT_SECURITY_LABEL_ONLY))
        conf = i;
    }
    if (conf >= 0) {
      tgt.setConfidentialityElement(convertDocumentConfidentiality(src.getMeta().getSecurityList().get(conf)));
      tgt.getMeta().getSecurity().remove(conf);
    }
    for (org.hl7.fhir.r4.model.Coding c : tgt.getMeta().getSecurity())
      c.getExtension().removeIf(e -> VersionConvertorConstants.EXT_SECURITY_LABEL_ONLY.equals(e.getUrl()));
    if (tgt.getMeta().isEmpty())
      tgt.setMeta(null);
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
    tgt.setSystem(CONFIDENTIALITY_SYSTEM);
    tgt.setCode(src.getValue().toCode());
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Composition.DocumentConfidentiality> convertDocumentConfidentiality(org.hl7.fhir.model.core.Coding src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Composition.DocumentConfidentiality> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Composition.DocumentConfidentialityEnumFactory());
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    switch (java.util.Objects.toString(src.getCode(), "")) {
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
      tgt.setMode(hasKeptCodeableConcept(src.getModeElement(), ATTESTER_MODE_EXTENSION_URL) ? keptCodeableConcept(src.getModeElement(), ATTESTER_MODE_EXTENSION_URL) : convertCompositionAttestationMode(src.getModeElement()));
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
    if (src.hasMode()) {
      tgt.setModeElement(convertCompositionAttestationMode(src.getMode()));
      keepCodeableConcept(src.getMode(), tgt.getModeElement(), convertCompositionAttestationMode(tgt.getModeElement()), ATTESTER_MODE_EXTENSION_URL);
    }
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
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt, ATTESTER_MODE_EXTENSION_URL);
      if (src.getValue() == null) {
        // Add nothing
      } else {
          switch (src.getValue()) {
              case PERSONAL:
                  tgt.addCoding().setSystem("http://terminology.hl7.org/CodeSystem/composition-attestation-mode").setCode("personal");
                  break;
              case PROFESSIONAL:
                  tgt.addCoding().setSystem("http://terminology.hl7.org/CodeSystem/composition-attestation-mode").setCode("professional");
                  break;
              case LEGAL:
                  tgt.addCoding().setSystem("http://terminology.hl7.org/CodeSystem/composition-attestation-mode").setCode("legal");
                  break;
              case OFFICIAL:
                  tgt.addCoding().setSystem("http://terminology.hl7.org/CodeSystem/composition-attestation-mode").setCode("official");
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
    String code = src.getCode("http://terminology.hl7.org/CodeSystem/composition-attestation-mode");
    if (code == null) {
      code = src.getCode("http://hl7.org/fhir/composition-attestation-mode"); // the system before R6
    }
    switch (code == null ? "" : code) {
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
        // not a code R4 knows: leave the value empty
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.model.core.Composition.CompositionRelatesToComponent convertCompositionRelatesToComponent(org.hl7.fhir.r4.model.Composition.CompositionRelatesToComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Composition.CompositionRelatesToComponent tgt = new org.hl7.fhir.model.core.Composition.CompositionRelatesToComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt, RELATES_TO_TARGET_EXTENSION_URL);
    if (src.hasCode())
      tgt.setType(hasKeptCodeableConcept(src.getCodeElement(), RELATES_TO_TYPE_EXTENSION_URL) ? keptCodeableConcept(src.getCodeElement(), RELATES_TO_TYPE_EXTENSION_URL) : convertDocumentRelationshipType(src.getCodeElement()));
    if (src.hasTargetReference())
      tgt.setTarget(Reference40_N.convertReference(src.getTargetReference()));
    else if (src.hasTargetIdentifier())
      tgt.setTarget(new org.hl7.fhir.model.core.Reference().setIdentifier(Identifier40_N.convertIdentifier(src.getTargetIdentifier())));
    else if (src.hasExtension(RELATES_TO_TARGET_EXTENSION_URL))
      tgt.setTarget(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getExtensionByUrl(RELATES_TO_TARGET_EXTENSION_URL).getValue()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Composition.CompositionRelatesToComponent convertCompositionRelatesToComponent(org.hl7.fhir.model.core.Composition.CompositionRelatesToComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Composition.CompositionRelatesToComponent tgt = new org.hl7.fhir.r4.model.Composition.CompositionRelatesToComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasType()) {
      tgt.setCodeElement(convertDocumentRelationshipType(src.getType()));
      keepCodeableConcept(src.getType(), tgt.getCodeElement(), convertDocumentRelationshipType(tgt.getCodeElement()), RELATES_TO_TYPE_EXTENSION_URL);
    }
    // R4 target[x] is an identifier or a reference: a reference with only an identifier is the R4 identifier
    if (src.hasTargetReference()) {
      org.hl7.fhir.model.core.Reference r = src.getTargetReference();
      if (r.hasIdentifier() && !r.hasReference() && !r.hasType() && !r.hasDisplay() && !r.hasId() && !r.hasExtension())
        tgt.setTarget(Identifier40_N.convertIdentifier(r.getIdentifier()));
      else
        tgt.setTarget(Reference40_N.convertReference(r));
    } else if (src.hasTarget())
      tgt.addExtension(RELATES_TO_TARGET_EXTENSION_URL, ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getTarget()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.CodeableConcept convertDocumentRelationshipType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Composition.DocumentRelationshipType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
    org.hl7.fhir.model.core.CodeableConcept tgt = new org.hl7.fhir.model.core.CodeableConcept();
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt, RELATES_TO_TYPE_EXTENSION_URL);
      if (src.getValue() != null) {
          switch (src.getValue()) {
              case REPLACES:
                tgt.addCoding().setSystem(RELATIONSHIP_SYSTEM).setCode("replaces").setDisplay("Replaces");
                  break;
              case TRANSFORMS:
                tgt.addCoding().setSystem(RELATIONSHIP_SYSTEM).setCode("transforms").setDisplay("Transforms");
                  break;
              case SIGNS:
                tgt.addCoding().setSystem(RELATIONSHIP_SYSTEM).setCode("signs").setDisplay("Signs");
                  break;
              case APPENDS:
                tgt.addCoding().setSystem(RELATIONSHIP_SYSTEM).setCode("appends").setDisplay("Appends");
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
      if ((src.hasCoding(RELATIONSHIP_SYSTEM, "replaces") || src.hasCoding("http://terminology.hl7.org/ValueSet/artifact-relationship-type", "replaces"))) {
        tgt.setValue(Composition.DocumentRelationshipType.REPLACES);
      } else if ((src.hasCoding(RELATIONSHIP_SYSTEM, "transforms") || src.hasCoding("http://terminology.hl7.org/ValueSet/artifact-relationship-type", "transforms"))) {
        tgt.setValue(Composition.DocumentRelationshipType.TRANSFORMS);
      } else if ((src.hasCoding(RELATIONSHIP_SYSTEM, "signs") || src.hasCoding("http://terminology.hl7.org/ValueSet/artifact-relationship-type", "signs"))) {
        tgt.setValue(Composition.DocumentRelationshipType.SIGNS);
      } else if ((src.hasCoding(RELATIONSHIP_SYSTEM, "appends") || src.hasCoding("http://terminology.hl7.org/ValueSet/artifact-relationship-type", "appends"))) {
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
      tgt.addDetail(CodeableConcept40_N.convertCodeableConceptToCodeableReference(t));
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
    // concepts go to R4 code (with any reference on the concept in the extension), references to R4 detail
    for (CodeableReference t : src.getDetailList()) {
      if (t.hasConcept()) {
        tgt.addCode(CodeableConcept40_N.convertCodeableReferenceToCodeableConcept(t));
      } else if (t.hasReference()) {
        tgt.addDetail(Reference40_N.convertReference(t.getReference()));
      }
    }
    return tgt;
  }

  public static org.hl7.fhir.model.core.Composition.SectionComponent convertSectionComponent(org.hl7.fhir.r4.model.Composition.SectionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Composition.SectionComponent tgt = new org.hl7.fhir.model.core.Composition.SectionComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt, CrossVersionElements40_N.urls("Composition.section", "6.0", new String[] {"note"}));
    CrossVersionElements40_N.extensionsToElementsForPath(src.getExtension(), tgt, "Composition.section", "6.0", "note");
    if (src.hasTitle())
      tgt.setTitleElement(String40_N.convertString(src.getTitleElement()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_N.convertCodeableConcept(src.getCode()));
    for (org.hl7.fhir.r4.model.Reference t : src.getAuthor()) tgt.addAuthor(Reference40_N.convertReference(t));
    if (src.hasFocus())
      tgt.setFocus(Reference40_N.convertReference(src.getFocus()));
    if (src.hasText())
      tgt.setText(Narrative40_N.convertNarrative(src.getText()));
    // R6 dropped section.mode
    CrossVersionElements40_N.r4ElementsToExtensions(src, "Composition.section", tgt.getExtension(), "mode");
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
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt, CrossVersionElements40_N.url("Composition.section", "4.0", "mode"));
    CrossVersionElements40_N.elementsToExtensionsForPath(src, "Composition.section", tgt.getExtension(), "6.0", "note");
    if (src.hasTitle())
      tgt.setTitleElement(String40_N.convertString(src.getTitleElement()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_N.convertCodeableConcept(src.getCode()));
    for (org.hl7.fhir.model.core.Reference t : src.getAuthorList()) tgt.addAuthor(Reference40_N.convertReference(t));
    if (src.hasFocus())
      tgt.setFocus(Reference40_N.convertReference(src.getFocus()));
    if (src.hasText())
      tgt.setText(Narrative40_N.convertNarrative(src.getText()));
    CrossVersionElements40_N.extensionsToR4Elements(src.getExtension(), tgt, "Composition.section", "mode");
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