package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
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

  public static org.hl7.fhir.model.core.DocumentReference convertDocumentReference(org.hl7.fhir.r4.model.DocumentReference src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.DocumentReference tgt = new org.hl7.fhir.model.core.DocumentReference();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    if (src.hasMasterIdentifier())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(src.getMasterIdentifier()));
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations40_N.convertDocumentReferenceStatus(src.getStatusElement()));
    if (src.hasDocStatus())
      tgt.setDocStatusElement(convertReferredDocumentStatus(src.getDocStatusElement()));
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
      tgt.addAttester().setMode(new org.hl7.fhir.model.core.CodeableConcept().addCoding(new org.hl7.fhir.model.core.Coding("http://hl7.org/fhir/composition-attestation-mode","official", "Official")))
        .setParty(Reference40_N.convertReference(src.getAuthenticator()));
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
    return tgt;
  }

  public static org.hl7.fhir.r4.model.DocumentReference convertDocumentReference(org.hl7.fhir.model.core.DocumentReference src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.DocumentReference tgt = new org.hl7.fhir.r4.model.DocumentReference();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
//        if (src.hasMasterIdentifier())
//            tgt.setMasterIdentifier(convertIdentifier(src.getMasterIdentifier()));
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations40_N.convertDocumentReferenceStatus(src.getStatusElement()));
    if (src.hasDocStatus())
      tgt.setDocStatusElement(convertReferredDocumentStatus(src.getDocStatusElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept40_N.convertCodeableConcept(src.getType()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getCategoryList())
      tgt.addCategory(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasSubject())
      tgt.setSubject(Reference40_N.convertReference(src.getSubject()));
    if (src.hasDate())
      tgt.setDateElement(Instant40_N.convertInstantFromDateTime(src.getDateElement()));
    for (org.hl7.fhir.model.core.Reference t : src.getAuthorList()) tgt.addAuthor(Reference40_N.convertReference(t));
    for (DocumentReferenceAttesterComponent t : src.getAttesterList()) {
      if (t.getMode().hasCoding("http://hl7.org/fhir/composition-attestation-mode", "official"))
        tgt.setAuthenticator(Reference40_N.convertReference(t.getParty()));
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
      CodeableConcept tgt = new CodeableConcept();
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          // Add nothing
      } else {
          switch (src.getValue()) {
              case REPLACES:
                  tgt.addCoding().setSystem("http://hl7.org/fhir/document-relationship-type").setCode("replaces");
                  break;
              case TRANSFORMS:
                  tgt.addCoding().setSystem("http://hl7.org/fhir/document-relationship-type").setCode("transforms");
                  break;
              case SIGNS:
                  tgt.addCoding().setSystem("http://hl7.org/fhir/document-relationship-type").setCode("signs");
                  break;
              case APPENDS:
                  tgt.addCoding().setSystem("http://hl7.org/fhir/document-relationship-type").setCode("appends");
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
    switch (src.getCode("http://hl7.org/fhir/document-relationship-type")) {
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
        tgt.setValue(org.hl7.fhir.r4.model.DocumentReference.DocumentRelationshipType.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.model.core.DocumentReference.DocumentReferenceContentComponent convertDocumentReferenceContentComponent(org.hl7.fhir.r4.model.DocumentReference.DocumentReferenceContentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.DocumentReference.DocumentReferenceContentComponent tgt = new org.hl7.fhir.model.core.DocumentReference.DocumentReferenceContentComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasAttachment())
      tgt.setAttachment(Attachment40_N.convertAttachment(src.getAttachment()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.DocumentReference.DocumentReferenceContentComponent convertDocumentReferenceContentComponent(org.hl7.fhir.model.core.DocumentReference.DocumentReferenceContentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.DocumentReference.DocumentReferenceContentComponent tgt = new org.hl7.fhir.r4.model.DocumentReference.DocumentReferenceContentComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasAttachment())
      tgt.setAttachment(Attachment40_N.convertAttachment(src.getAttachment()));
    return tgt;
  }

  public static void convertDocumentReferenceContextComponent(org.hl7.fhir.r4.model.DocumentReference.DocumentReferenceContextComponent src, org.hl7.fhir.model.core.DocumentReference tgt) throws FHIRException {
    for (org.hl7.fhir.r4.model.Reference t : src.getEncounter()) tgt.addContext(Reference40_N.convertReference(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getEvent())
      tgt.addEvent(new CodeableReference().setConcept(CodeableConcept40_N.convertCodeableConcept(t)));
    if (src.hasPeriod())
      tgt.setPeriod(Period40_N.convertPeriod(src.getPeriod()));
    if (src.hasFacilityType())
      tgt.setFacilityType(CodeableConcept40_N.convertCodeableConcept(src.getFacilityType()));
    if (src.hasPracticeSetting())
      tgt.setPracticeSetting(CodeableConcept40_N.convertCodeableConcept(src.getPracticeSetting()));
//    if (src.hasSourcePatientInfo())
//      tgt.setSourcePatientInfo(Reference40_N.convertReference(src.getSourcePatientInfo()));
//    for (org.hl7.fhir.r4.model.Reference t : src.getRelated()) tgt.addRelated(Reference40_N.convertReference(t));
  }

  public static void convertDocumentReferenceContextComponent(org.hl7.fhir.model.core.DocumentReference src, org.hl7.fhir.r4.model.DocumentReference.DocumentReferenceContextComponent tgt) throws FHIRException {
    for (org.hl7.fhir.model.core.Reference t : src.getContextList()) tgt.addEncounter(Reference40_N.convertReference(t));
    for (CodeableReference t : src.getEventList())
      if (t.hasConcept())
      tgt.addEvent(CodeableConcept40_N.convertCodeableConcept(t.getConcept()));
    if (src.hasPeriod())
      tgt.setPeriod(Period40_N.convertPeriod(src.getPeriod()));
    if (src.hasFacilityType())
      tgt.setFacilityType(CodeableConcept40_N.convertCodeableConcept(src.getFacilityType()));
    if (src.hasPracticeSetting())
      tgt.setPracticeSetting(CodeableConcept40_N.convertCodeableConcept(src.getPracticeSetting()));
//    if (src.hasSourcePatientInfo())
//      tgt.setSourcePatientInfo(Reference40_N.convertReference(src.getSourcePatientInfo()));
//    for (org.hl7.fhir.model.core.Reference t : src.getRelatedList()) tgt.addRelated(Reference40_N.convertReference(t));
  }
}