package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Coding40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.CrossVersionDatatype40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.CrossVersionElements40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Attachment40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Identifier40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Period40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Instant40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.MarkDown40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.String40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Reference40_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.DocumentReference;
import org.hl7.fhir.model.core.CodeableConcept;
import org.hl7.fhir.model.core.CodeableReference;
import org.hl7.fhir.model.core.DocumentReference.DocumentReferenceAttesterComponent;
import org.hl7.fhir.model.core.Enumeration;
import org.hl7.fhir.model.core.Enumerations;

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

public class DocumentReference40_N {

  private static final String RELATES_TO_CODE_URL = CrossVersionElements40_N.url("DocumentReference.relatesTo", "5.0", "code");


  public static final String ATTESTATION_MODE_SYSTEM = "http://terminology.hl7.org/CodeSystem/composition-attestation-mode";
  // marks the identifier that was the R4 masterIdentifier
  public static final String MASTER_IDENTIFIER_EXTENSION_URL = "http://hl7.org/fhir/4.0/StructureDefinition/extension-DocumentReference.masterIdentifier";
  public static final String SOURCE_PATIENT_INFO_EXTENSION_URL = "http://hl7.org/fhir/4.0/StructureDefinition/extension-DocumentReference.context.sourcePatientInfo";

  /**
   * true if the attester is what R4 authenticator says: an official attester, with nothing but the party
   */
  private static boolean isAuthenticator(DocumentReferenceAttesterComponent t) {
    org.hl7.fhir.model.core.CodeableConcept m = t.getMode();
    if (!t.hasParty() || t.hasTime() || t.hasId() || t.hasExtension() || t.hasModifierExtension())
      return false;
    if (m.getCodingList().size() != 1 || m.hasText() || m.hasId() || m.hasExtension())
      return false;
    org.hl7.fhir.model.core.Coding c = m.getCodingFirstRep();
    return (ATTESTATION_MODE_SYSTEM.equals(c.getSystem()) || "http://hl7.org/fhir/composition-attestation-mode".equals(c.getSystem())) && "official".equals(c.getCode())
      && !c.hasDisplay() && !c.hasVersion() && !c.hasUserSelected() && !c.hasId() && !c.hasExtension();
  }

  public static org.hl7.fhir.model.core.DocumentReference convertDocumentReference(org.hl7.fhir.r4.model.DocumentReference src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.DocumentReference tgt = new org.hl7.fhir.model.core.DocumentReference();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt, CrossVersionElements40_N.urls("DocumentReference", "5.0", new String[] {"version", "basedOn", "modality", "attester"}, CrossVersionElements40_N.urls("DocumentReference", "6.0", new String[] {"bodyStructure", "related"}, SOURCE_PATIENT_INFO_EXTENSION_URL)));
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "5.0", "version", "basedOn", "modality");
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "6.0", "bodyStructure");
    // R6 dropped masterIdentifier: it's an identifier, marked so it can go back
    if (src.hasMasterIdentifier()) {
      org.hl7.fhir.model.core.Identifier mi = Identifier40_N.convertIdentifier(src.getMasterIdentifier());
      mi.addExtension(MASTER_IDENTIFIER_EXTENSION_URL, new org.hl7.fhir.model.core.BooleanType(true));
      tgt.addIdentifier(mi);
    }
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations40_N.convertDocumentReferenceStatus(src.getStatusElement()));
    if (src.hasDocStatus())
      tgt.setDocStatusElement(CrossVersionElements40_N.toR6Code(src.getDocStatusElement(), convertReferredDocumentStatus(src.getDocStatusElement()), src.fhirType(), "docStatus"));
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasSubject())
      tgt.setSubject(Reference40_N.convertReference(src.getSubject()));
    if (src.hasDate())
      tgt.setDateElement(Instant40_N.convertInstantToDateTime(src.getDateElement()));
    for (org.hl7.fhir.r4.model.Reference t : src.getAuthor()) tgt.addAuthor(Reference40_N.convertReference(t));
    if (src.hasAuthenticator())
      tgt.addAttester().setMode(new org.hl7.fhir.model.core.CodeableConcept().addCoding(new org.hl7.fhir.model.core.Coding(ATTESTATION_MODE_SYSTEM, "official", null)))
        .setParty(Reference40_N.convertReference(src.getAuthenticator()));
    // the other attesters
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "5.0", "attester");
    if (src.hasCustodian())
      tgt.setCustodian(Reference40_N.convertReference(src.getCustodian()));
    for (org.hl7.fhir.r4.model.DocumentReference.DocumentReferenceRelatesToComponent t : src.getRelatesTo())
      tgt.addRelatesTo(convertDocumentReferenceRelatesToComponent(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown40_N.convertStringToMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getSecurityLabel())
      tgt.addSecurityLabel(CodeableConcept40_N.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.DocumentReference.DocumentReferenceContentComponent t : src.getContent())
      tgt.addContent(convertDocumentReferenceContentComponent(t));
    if (src.hasContext())
      convertDocumentReferenceContextComponent(src.getContext(), tgt);
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "6.0", "related");
    return tgt;
  }

  public static org.hl7.fhir.r4.model.DocumentReference convertDocumentReference(org.hl7.fhir.model.core.DocumentReference src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.DocumentReference tgt = new org.hl7.fhir.r4.model.DocumentReference();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt, SOURCE_PATIENT_INFO_EXTENSION_URL);
    CrossVersionElements40_N.elementsToExtensions(src, tgt.getExtension(), "5.0", "version", "basedOn", "modality");
    CrossVersionElements40_N.elementsToExtensions(src, tgt.getExtension(), "6.0", "bodyStructure");
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList()) {
      if (t.hasExtension(MASTER_IDENTIFIER_EXTENSION_URL) && !tgt.hasMasterIdentifier()) {
        tgt.setMasterIdentifier(Identifier40_N.convertIdentifier(t));
        tgt.getMasterIdentifier().removeExtension(MASTER_IDENTIFIER_EXTENSION_URL);
      } else
        tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    }
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations40_N.convertDocumentReferenceStatus(src.getStatusElement()));
    if (src.hasDocStatus())
      tgt.setDocStatusElement(CrossVersionElements40_N.toR4Code(src.getDocStatusElement(), convertReferredDocumentStatus(src.getDocStatusElement()), src.fhirType(), "docStatus"));
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getCategoryList())
      tgt.addCategory(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasSubject())
      tgt.setSubject(Reference40_N.convertReference(src.getSubject()));
    if (src.hasDate())
      tgt.setDateElement(Instant40_N.convertInstantFromDateTime(src.getDateElement()));
    for (org.hl7.fhir.model.core.Reference t : src.getAuthorList()) tgt.addAuthor(Reference40_N.convertReference(t));
    // R4 authenticator is an official attester with only a party; the others go in the extension
    for (DocumentReferenceAttesterComponent t : src.getAttesterList()) {
      if (!tgt.hasAuthenticator() && isAuthenticator(t))
        tgt.setAuthenticator(Reference40_N.convertReference(t.getParty()));
      else
        tgt.addExtension(CrossVersionDatatype40_N.convertToExtension(CrossVersionElements40_N.url("DocumentReference", "5.0", "attester"), t));
    }
    if (src.hasCustodian())
      tgt.setCustodian(Reference40_N.convertReference(src.getCustodian()));
    for (org.hl7.fhir.model.core.DocumentReference.DocumentReferenceRelatesToComponent t : src.getRelatesToList())
      tgt.addRelatesTo(convertDocumentReferenceRelatesToComponent(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_N.convertString(src.getDescriptionElement()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getSecurityLabelList())
      tgt.addSecurityLabel(CodeableConcept40_N.convertCodeableConcept(t));
    for (org.hl7.fhir.model.core.DocumentReference.DocumentReferenceContentComponent t : src.getContentList())
      tgt.addContent(convertDocumentReferenceContentComponent(t));
    convertDocumentReferenceContextComponent(src, tgt.getContext());
    for (org.hl7.fhir.model.core.DocumentReference.DocumentReferenceRelatedComponent t : src.getRelatedList()) {
      if (!(t.hasTarget() && !t.hasCode() && !t.hasId() && !t.hasExtension() && !t.hasModifierExtension()))
        tgt.addExtension(CrossVersionDatatype40_N.convertToExtension(CrossVersionElements40_N.url("DocumentReference", "6.0", "related"), t));
    }
    if (tgt.hasContext() && tgt.getContext().isEmpty())
      tgt.setContext(null);
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.CompositionStatus> convertReferredDocumentStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DocumentReference.ReferredDocumentStatus> src) throws FHIRException {
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DocumentReference.ReferredDocumentStatus> convertReferredDocumentStatus(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.CompositionStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<DocumentReference.ReferredDocumentStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new DocumentReference.ReferredDocumentStatusEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case PRELIMINARY:
                  tgt.setValue(DocumentReference.ReferredDocumentStatus.PRELIMINARY);
                  break;
              case FINAL:
                  tgt.setValue(DocumentReference.ReferredDocumentStatus.FINAL);
                  break;
              case AMENDED:
                  tgt.setValue(DocumentReference.ReferredDocumentStatus.AMENDED);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(DocumentReference.ReferredDocumentStatus.ENTEREDINERROR);
                  break;
              default:
                  tgt.setValue(DocumentReference.ReferredDocumentStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.DocumentReference.DocumentReferenceRelatesToComponent convertDocumentReferenceRelatesToComponent(org.hl7.fhir.r4.model.DocumentReference.DocumentReferenceRelatesToComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.DocumentReference.DocumentReferenceRelatesToComponent tgt = new org.hl7.fhir.model.core.DocumentReference.DocumentReferenceRelatesToComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(convertDocumentRelationshipType(src.getCodeElement()));
    if (src.hasTarget())
      tgt.setTarget(Reference40_N.convertReference(src.getTarget()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.DocumentReference.DocumentReferenceRelatesToComponent convertDocumentReferenceRelatesToComponent(org.hl7.fhir.model.core.DocumentReference.DocumentReferenceRelatesToComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.DocumentReference.DocumentReferenceRelatesToComponent tgt = new org.hl7.fhir.r4.model.DocumentReference.DocumentReferenceRelatesToComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCodeElement(convertDocumentRelationshipType(src.getCode()));
    if (src.hasTarget())
      tgt.setTarget(Reference40_N.convertReference(src.getTarget()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.CodeableConcept convertDocumentRelationshipType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DocumentReference.DocumentRelationshipType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      // the whole R6 concept, if R4 couldn't carry it (see below)
      CodeableConcept kept = CodeableConcept40_N.keptCodeableConcept(src, RELATES_TO_CODE_URL);
      if (kept != null)
        return kept;
      CodeableConcept tgt = new CodeableConcept();
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          // Add nothing
      } else {
          switch (src.getValue()) {
              case REPLACES:
                  tgt.addCoding().setSystem("http://terminology.hl7.org/CodeSystem/document-relationship-type").setCode("replaces");
                  break;
              case TRANSFORMS:
                  tgt.addCoding().setSystem("http://terminology.hl7.org/CodeSystem/document-relationship-type").setCode("transforms");
                  break;
              case SIGNS:
                  tgt.addCoding().setSystem("http://terminology.hl7.org/CodeSystem/document-relationship-type").setCode("signs");
                  break;
              case APPENDS:
                  tgt.addCoding().setSystem("http://terminology.hl7.org/CodeSystem/document-relationship-type").setCode("appends");
                  break;
              default:
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DocumentReference.DocumentRelationshipType> convertDocumentRelationshipType(org.hl7.fhir.model.core.CodeableConcept src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DocumentReference.DocumentRelationshipType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.DocumentReference.DocumentRelationshipTypeEnumFactory());
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    String code = src.getCode("http://terminology.hl7.org/CodeSystem/document-relationship-type");
    if (code == null) {
      code = src.getCode("http://hl7.org/fhir/document-relationship-type"); // the system before R6
    }
    switch (code == null ? "" : code) {
      case "replaces":
        tgt.setValue(org.hl7.fhir.r4.model.DocumentReference.DocumentRelationshipType.REPLACES);
        break;
      case "transforms":
        tgt.setValue(org.hl7.fhir.r4.model.DocumentReference.DocumentRelationshipType.TRANSFORMS);
        break;
      case "signs":
        tgt.setValue(org.hl7.fhir.r4.model.DocumentReference.DocumentRelationshipType.SIGNS);
        break;
      case "appends":
        tgt.setValue(org.hl7.fhir.r4.model.DocumentReference.DocumentRelationshipType.APPENDS);
        break;
      default:
        // not a code R4 knows: leave the value empty
        break;
    }
    // if the R4 code doesn't make the same concept again, the concept goes in a 5.0 extension
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DocumentReference.DocumentRelationshipType> plain = tgt.copy();
    plain.getExtension().clear();
    CodeableConcept40_N.keepCodeableConcept(src, tgt, plain.hasValue() ? convertDocumentRelationshipType(plain) : null, RELATES_TO_CODE_URL);
    return tgt;
  }

  public static org.hl7.fhir.model.core.DocumentReference.DocumentReferenceContentComponent convertDocumentReferenceContentComponent(org.hl7.fhir.r4.model.DocumentReference.DocumentReferenceContentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.DocumentReference.DocumentReferenceContentComponent tgt = new org.hl7.fhir.model.core.DocumentReference.DocumentReferenceContentComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt, CrossVersionElements40_N.urls("DocumentReference.content", "5.0", new String[] {"profile"}));
    if (src.hasAttachment())
      tgt.setAttachment(Attachment40_N.convertAttachment(src.getAttachment()));
    // R4 format is the R6 profile, as a coding (any other profiles are in the extension)
    if (src.hasFormat())
      tgt.addProfile().setValue(Coding40_N.convertCoding(src.getFormat()));
    CrossVersionElements40_N.extensionsToElementsForPath(src.getExtension(), tgt, "DocumentReference.content", "5.0", "profile");
    return tgt;
  }

  public static org.hl7.fhir.r4.model.DocumentReference.DocumentReferenceContentComponent convertDocumentReferenceContentComponent(org.hl7.fhir.model.core.DocumentReference.DocumentReferenceContentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.DocumentReference.DocumentReferenceContentComponent tgt = new org.hl7.fhir.r4.model.DocumentReference.DocumentReferenceContentComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasAttachment())
      tgt.setAttachment(Attachment40_N.convertAttachment(src.getAttachment()));
    for (org.hl7.fhir.model.core.DocumentReference.DocumentReferenceContentProfileComponent p : src.getProfileList()) {
      if (!tgt.hasFormat() && p.hasValueCoding() && !p.hasId() && !p.hasExtension() && !p.hasModifierExtension())
        tgt.setFormat(Coding40_N.convertCoding(p.getValueCoding()));
      else
        tgt.addExtension(CrossVersionDatatype40_N.convertToExtension(CrossVersionElements40_N.url("DocumentReference.content", "5.0", "profile"), p));
    }
    return tgt;
  }

  public static void convertDocumentReferenceContextComponent(org.hl7.fhir.r4.model.DocumentReference.DocumentReferenceContextComponent src, org.hl7.fhir.model.core.DocumentReference tgt) throws FHIRException {
    for (org.hl7.fhir.r4.model.Reference t : src.getEncounter()) tgt.addContext(Reference40_N.convertReference(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getEvent())
      tgt.addEvent(CodeableConcept40_N.convertCodeableConceptToCodeableReference(t));
    if (src.hasPeriod())
      tgt.setPeriod(Period40_N.convertPeriod(src.getPeriod()));
    if (src.hasFacilityType())
      tgt.setFacilityType(CodeableConcept40_N.convertCodeableConcept(src.getFacilityType()));
    if (src.hasPracticeSetting())
      tgt.setPracticeSetting(CodeableConcept40_N.convertCodeableConcept(src.getPracticeSetting()));
    // R6 dropped sourcePatientInfo
    if (src.hasSourcePatientInfo())
      tgt.addExtension(SOURCE_PATIENT_INFO_EXTENSION_URL, Reference40_N.convertReference(src.getSourcePatientInfo()));
    // R6 related has a code as well as the target
    for (org.hl7.fhir.r4.model.Reference t : src.getRelated())
      tgt.addRelated().setTarget(Reference40_N.convertReference(t));
  }

  public static void convertDocumentReferenceContextComponent(org.hl7.fhir.model.core.DocumentReference src, org.hl7.fhir.r4.model.DocumentReference.DocumentReferenceContextComponent tgt) throws FHIRException {
    for (org.hl7.fhir.model.core.Reference t : src.getContextList()) tgt.addEncounter(Reference40_N.convertReference(t));
    for (CodeableReference t : src.getEventList())
      tgt.addEvent(CodeableConcept40_N.convertCodeableReferenceToCodeableConcept(t));
    if (src.hasPeriod())
      tgt.setPeriod(Period40_N.convertPeriod(src.getPeriod()));
    if (src.hasFacilityType())
      tgt.setFacilityType(CodeableConcept40_N.convertCodeableConcept(src.getFacilityType()));
    if (src.hasPracticeSetting())
      tgt.setPracticeSetting(CodeableConcept40_N.convertCodeableConcept(src.getPracticeSetting()));
    if (src.hasExtension(SOURCE_PATIENT_INFO_EXTENSION_URL))
      tgt.setSourcePatientInfo(Reference40_N.convertReference((org.hl7.fhir.model.core.Reference) src.getExtensionByUrl(SOURCE_PATIENT_INFO_EXTENSION_URL).getValue()));
    // a related with only a target is R4 context.related; the others go in the extension
    for (org.hl7.fhir.model.core.DocumentReference.DocumentReferenceRelatedComponent t : src.getRelatedList()) {
      if (t.hasTarget() && !t.hasCode() && !t.hasId() && !t.hasExtension() && !t.hasModifierExtension())
        tgt.addRelated(Reference40_N.convertReference(t.getTarget()));
    }
  }
}