package org.hl7.fhir.convertors.conv43_50.resources43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Attachment43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.CodeableConcept43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Identifier43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Period43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Instant43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.MarkDown43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.String43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.special43_50.Reference43_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CodeableReference;
import org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceAttesterComponent;

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
public class DocumentReference43_50 {

  public static org.hl7.fhir.r5.model.DocumentReference convertDocumentReference(org.hl7.fhir.r4b.model.DocumentReference src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.DocumentReference tgt = new org.hl7.fhir.r5.model.DocumentReference();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    if (src.hasMasterIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(src.getMasterIdentifier()));
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations43_50.convertDocumentReferenceStatus(src.getStatusElement()));
    if (src.hasDocStatus())
      tgt.setDocStatusElement(convertReferredDocumentStatus(src.getDocStatusElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasSubject())
      tgt.setSubject(Reference43_50.convertReference(src.getSubject()));
    if (src.hasDate())
      tgt.setDateElement(Instant43_50.convertInstant(src.getDateElement()));
    for (org.hl7.fhir.r4b.model.Reference t : src.getAuthor()) tgt.addAuthor(Reference43_50.convertReference(t));
    if (src.hasAuthenticator())
      tgt.addAttester().setMode(new org.hl7.fhir.r5.model.CodeableConcept().addCoding(new org.hl7.fhir.r5.model.Coding("http://hl7.org/fhir/composition-attestation-mode","official", "Official")))
        .setParty(Reference43_50.convertReference(src.getAuthenticator()));
    if (src.hasCustodian())
      tgt.setCustodian(Reference43_50.convertReference(src.getCustodian()));
    for (org.hl7.fhir.r4b.model.DocumentReference.DocumentReferenceRelatesToComponent t : src.getRelatesTo())
      tgt.addRelatesTo(convertDocumentReferenceRelatesToComponent(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown43_50.convertStringToMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getSecurityLabel())
      tgt.addSecurityLabel(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r4b.model.DocumentReference.DocumentReferenceContentComponent t : src.getContent())
      tgt.addContent(convertDocumentReferenceContentComponent(t));
    if (src.hasContext())
      convertDocumentReferenceContextComponent(src.getContext(), tgt);
    for (org.hl7.fhir.r4b.model.Reference t : src.getAuthor())
      tgt.addAuthor(Reference43_50.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.DocumentReference convertDocumentReference(org.hl7.fhir.r5.model.DocumentReference src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.DocumentReference tgt = new org.hl7.fhir.r4b.model.DocumentReference();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
//        if (src.hasMasterIdentifier())
//            tgt.setMasterIdentifier(convertIdentifier(src.getMasterIdentifier()));
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations43_50.convertDocumentReferenceStatus(src.getStatusElement()));
    if (src.hasDocStatus())
      tgt.setDocStatusElement(convertReferredDocumentStatus(src.getDocStatusElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept43_50.convertCodeableConcept(src.getType()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasSubject())
      tgt.setSubject(Reference43_50.convertReference(src.getSubject()));
    if (src.hasDate())
      tgt.setDateElement(Instant43_50.convertInstant(src.getDateElement()));
    for (org.hl7.fhir.r5.model.Reference t : src.getAuthor()) tgt.addAuthor(Reference43_50.convertReference(t));
    for (DocumentReferenceAttesterComponent t : src.getAttester()) {
      if (t.getMode().hasCoding("http://hl7.org/fhir/composition-attestation-mode", "official"))
        tgt.setAuthenticator(Reference43_50.convertReference(t.getParty()));
    }
    if (src.hasCustodian())
      tgt.setCustodian(Reference43_50.convertReference(src.getCustodian()));
    for (org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceRelatesToComponent t : src.getRelatesTo())
      tgt.addRelatesTo(convertDocumentReferenceRelatesToComponent(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_50.convertString(src.getDescriptionElement()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getSecurityLabel())
      tgt.addSecurityLabel(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceContentComponent t : src.getContent())
      tgt.addContent(convertDocumentReferenceContentComponent(t));
    convertDocumentReferenceContextComponent(src, tgt.getContext());
    for (org.hl7.fhir.r5.model.Reference t : src.getAuthor())
      tgt.addAuthor(Reference43_50.convertReference(t));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.CompositionStatus> convertReferredDocumentStatus(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.CompositionStatus> src) throws FHIRException {
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

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.CompositionStatus> convertReferredDocumentStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.CompositionStatus> src) throws FHIRException {
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

  public static org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceRelatesToComponent convertDocumentReferenceRelatesToComponent(org.hl7.fhir.r4b.model.DocumentReference.DocumentReferenceRelatesToComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceRelatesToComponent tgt = new org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceRelatesToComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(convertDocumentRelationshipType(src.getCodeElement()));
    if (src.hasTarget())
      tgt.setTarget(Reference43_50.convertReference(src.getTarget()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.DocumentReference.DocumentReferenceRelatesToComponent convertDocumentReferenceRelatesToComponent(org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceRelatesToComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.DocumentReference.DocumentReferenceRelatesToComponent tgt = new org.hl7.fhir.r4b.model.DocumentReference.DocumentReferenceRelatesToComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCodeElement(convertDocumentRelationshipType(src.getCode()));
    if (src.hasTarget())
      tgt.setTarget(Reference43_50.convertReference(src.getTarget()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.CodeableConcept convertDocumentRelationshipType(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.DocumentRelationshipType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.CodeableConcept tgt = new org.hl7.fhir.r5.model.CodeableConcept();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
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
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.DocumentRelationshipType> convertDocumentRelationshipType(org.hl7.fhir.r5.model.CodeableConcept src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.DocumentRelationshipType> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.DocumentRelationshipTypeEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getCode("http://hl7.org/fhir/document-relationship-type")) {
      case "replaces":
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.DocumentRelationshipType.REPLACES);
        break;
      case "transforms":
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.DocumentRelationshipType.TRANSFORMS);
        break;
      case "signs":
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.DocumentRelationshipType.SIGNS);
        break;
      case "appends":
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.DocumentRelationshipType.APPENDS);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.DocumentRelationshipType.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceContentComponent convertDocumentReferenceContentComponent(org.hl7.fhir.r4b.model.DocumentReference.DocumentReferenceContentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceContentComponent tgt = new org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceContentComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasAttachment())
      tgt.setAttachment(Attachment43_50.convertAttachment(src.getAttachment()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.DocumentReference.DocumentReferenceContentComponent convertDocumentReferenceContentComponent(org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceContentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.DocumentReference.DocumentReferenceContentComponent tgt = new org.hl7.fhir.r4b.model.DocumentReference.DocumentReferenceContentComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasAttachment())
      tgt.setAttachment(Attachment43_50.convertAttachment(src.getAttachment()));
    return tgt;
  }

  public static void convertDocumentReferenceContextComponent(org.hl7.fhir.r4b.model.DocumentReference.DocumentReferenceContextComponent src, org.hl7.fhir.r5.model.DocumentReference tgt) throws FHIRException {
    for (org.hl7.fhir.r4b.model.Reference t : src.getEncounter()) tgt.addContext(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getEvent())
      tgt.addEvent(new CodeableReference().setConcept(CodeableConcept43_50.convertCodeableConcept(t)));
    if (src.hasPeriod())
      tgt.setPeriod(Period43_50.convertPeriod(src.getPeriod()));
    if (src.hasFacilityType())
      tgt.setFacilityType(CodeableConcept43_50.convertCodeableConcept(src.getFacilityType()));
    if (src.hasPracticeSetting())
      tgt.setPracticeSetting(CodeableConcept43_50.convertCodeableConcept(src.getPracticeSetting()));
//    if (src.hasSourcePatientInfo())
//      tgt.setSourcePatientInfo(Reference43_50.convertReference(src.getSourcePatientInfo()));
//    for (org.hl7.fhir.r4b.model.Reference t : src.getRelated()) tgt.addRelated(Reference43_50.convertReference(t));
  }

  public static void convertDocumentReferenceContextComponent(org.hl7.fhir.r5.model.DocumentReference src, org.hl7.fhir.r4b.model.DocumentReference.DocumentReferenceContextComponent tgt) throws FHIRException {
    for (org.hl7.fhir.r5.model.Reference t : src.getContext()) tgt.addEncounter(Reference43_50.convertReference(t));
    for (CodeableReference t : src.getEvent())
      if (t.hasConcept())
      tgt.addEvent(CodeableConcept43_50.convertCodeableConcept(t.getConcept()));
    if (src.hasPeriod())
      tgt.setPeriod(Period43_50.convertPeriod(src.getPeriod()));
    if (src.hasFacilityType())
      tgt.setFacilityType(CodeableConcept43_50.convertCodeableConcept(src.getFacilityType()));
    if (src.hasPracticeSetting())
      tgt.setPracticeSetting(CodeableConcept43_50.convertCodeableConcept(src.getPracticeSetting()));
//    if (src.hasSourcePatientInfo())
//      tgt.setSourcePatientInfo(Reference43_50.convertReference(src.getSourcePatientInfo()));
//    for (org.hl7.fhir.r5.model.Reference t : src.getRelated()) tgt.addRelated(Reference43_50.convertReference(t));
  }
}
