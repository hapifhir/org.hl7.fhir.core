package org.hl7.fhir.convertors.conv40_50.resources40_50;

import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.*;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Instant40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.MarkDown40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.String40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.special40_50.Reference40_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.DocumentReference.DocumentAttestationMode;
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
public class DocumentReference40_50 {

  public static org.hl7.fhir.r5.model.DocumentReference convertDocumentReference(org.hl7.fhir.r4.model.DocumentReference src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.DocumentReference tgt = new org.hl7.fhir.r5.model.DocumentReference();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyDomainResource(src, tgt);
    if (src.hasMasterIdentifier())
      tgt.addIdentifier(Identifier40_50.convertIdentifier(src.getMasterIdentifier()));
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_50.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations40_50.convertDocumentReferenceStatus(src.getStatusElement()));
    if (src.hasDocStatus())
      tgt.setDocStatusElement(convertReferredDocumentStatus(src.getDocStatusElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept40_50.convertCodeableConcept(src.getType()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept40_50.convertCodeableConcept(t));
    if (src.hasSubject())
      tgt.setSubject(Reference40_50.convertReference(src.getSubject()));
    if (src.hasDate())
      tgt.setDateElement(Instant40_50.convertInstant(src.getDateElement()));
    for (org.hl7.fhir.r4.model.Reference t : src.getAuthor()) tgt.addAuthor(Reference40_50.convertReference(t));
    if (src.hasAuthenticator())
      tgt.addAttester().setMode(DocumentAttestationMode.OFFICIAL).setParty(Reference40_50.convertReference(src.getAuthenticator()));
    if (src.hasCustodian())
      tgt.setCustodian(Reference40_50.convertReference(src.getCustodian()));
    for (org.hl7.fhir.r4.model.DocumentReference.DocumentReferenceRelatesToComponent t : src.getRelatesTo())
      tgt.addRelatesTo(convertDocumentReferenceRelatesToComponent(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown40_50.convertStringToMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getSecurityLabel())
      tgt.addSecurityLabel(CodeableConcept40_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.DocumentReference.DocumentReferenceContentComponent t : src.getContent())
      tgt.addContent(convertDocumentReferenceContentComponent(t));
    if (src.hasContext())
      convertDocumentReferenceContextComponent(src.getContext(), tgt);
    return tgt;
  }

  public static org.hl7.fhir.r4.model.DocumentReference convertDocumentReference(org.hl7.fhir.r5.model.DocumentReference src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.DocumentReference tgt = new org.hl7.fhir.r4.model.DocumentReference();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyDomainResource(src, tgt);
//        if (src.hasMasterIdentifier())
//            tgt.setMasterIdentifier(convertIdentifier(src.getMasterIdentifier()));
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_50.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations40_50.convertDocumentReferenceStatus(src.getStatusElement()));
    if (src.hasDocStatus())
      tgt.setDocStatusElement(convertReferredDocumentStatus(src.getDocStatusElement()));
    if (src.hasType())
      tgt.setType(CodeableConcept40_50.convertCodeableConcept(src.getType()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept40_50.convertCodeableConcept(t));
    if (src.hasSubject())
      tgt.setSubject(Reference40_50.convertReference(src.getSubject()));
    if (src.hasDate())
      tgt.setDateElement(Instant40_50.convertInstant(src.getDateElement()));
    for (org.hl7.fhir.r5.model.Reference t : src.getAuthor()) tgt.addAuthor(Reference40_50.convertReference(t));
    for (DocumentReferenceAttesterComponent t : src.getAttester()) {
      if (t.getMode() == DocumentAttestationMode.OFFICIAL)
        tgt.setAuthenticator(Reference40_50.convertReference(t.getParty()));
    }
    if (src.hasCustodian())
      tgt.setCustodian(Reference40_50.convertReference(src.getCustodian()));
    for (org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceRelatesToComponent t : src.getRelatesTo())
      tgt.addRelatesTo(convertDocumentReferenceRelatesToComponent(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_50.convertString(src.getDescriptionElement()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getSecurityLabel())
      tgt.addSecurityLabel(CodeableConcept40_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceContentComponent t : src.getContent())
      tgt.addContent(convertDocumentReferenceContentComponent(t));
    convertDocumentReferenceContextComponent(src, tgt.getContext());
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.CompositionStatus> convertReferredDocumentStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DocumentReference.ReferredDocumentStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.CompositionStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.CompositionStatusEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DocumentReference.ReferredDocumentStatus> convertReferredDocumentStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.CompositionStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DocumentReference.ReferredDocumentStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.DocumentReference.ReferredDocumentStatusEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case PRELIMINARY:
        tgt.setValue(org.hl7.fhir.r4.model.DocumentReference.ReferredDocumentStatus.PRELIMINARY);
        break;
      case FINAL:
        tgt.setValue(org.hl7.fhir.r4.model.DocumentReference.ReferredDocumentStatus.FINAL);
        break;
      case AMENDED:
        tgt.setValue(org.hl7.fhir.r4.model.DocumentReference.ReferredDocumentStatus.AMENDED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r4.model.DocumentReference.ReferredDocumentStatus.ENTEREDINERROR);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.DocumentReference.ReferredDocumentStatus.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceRelatesToComponent convertDocumentReferenceRelatesToComponent(org.hl7.fhir.r4.model.DocumentReference.DocumentReferenceRelatesToComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceRelatesToComponent tgt = new org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceRelatesToComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasCode())
      tgt.setCodeElement(convertDocumentRelationshipType(src.getCodeElement()));
    if (src.hasTarget())
      tgt.setTarget(Reference40_50.convertReference(src.getTarget()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.DocumentReference.DocumentReferenceRelatesToComponent convertDocumentReferenceRelatesToComponent(org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceRelatesToComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.DocumentReference.DocumentReferenceRelatesToComponent tgt = new org.hl7.fhir.r4.model.DocumentReference.DocumentReferenceRelatesToComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasCode())
      tgt.setCodeElement(convertDocumentRelationshipType(src.getCodeElement()));
    if (src.hasTarget())
      tgt.setTarget(Reference40_50.convertReference(src.getTarget()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.DocumentRelationshipType> convertDocumentRelationshipType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DocumentReference.DocumentRelationshipType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.DocumentRelationshipType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.DocumentRelationshipTypeEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case REPLACES:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DocumentRelationshipType.REPLACES);
        break;
      case TRANSFORMS:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DocumentRelationshipType.TRANSFORMS);
        break;
      case SIGNS:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DocumentRelationshipType.SIGNS);
        break;
      case APPENDS:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DocumentRelationshipType.APPENDS);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.DocumentRelationshipType.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DocumentReference.DocumentRelationshipType> convertDocumentRelationshipType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.DocumentRelationshipType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DocumentReference.DocumentRelationshipType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.DocumentReference.DocumentRelationshipTypeEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case REPLACES:
        tgt.setValue(org.hl7.fhir.r4.model.DocumentReference.DocumentRelationshipType.REPLACES);
        break;
      case TRANSFORMS:
        tgt.setValue(org.hl7.fhir.r4.model.DocumentReference.DocumentRelationshipType.TRANSFORMS);
        break;
      case SIGNS:
        tgt.setValue(org.hl7.fhir.r4.model.DocumentReference.DocumentRelationshipType.SIGNS);
        break;
      case APPENDS:
        tgt.setValue(org.hl7.fhir.r4.model.DocumentReference.DocumentRelationshipType.APPENDS);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.DocumentReference.DocumentRelationshipType.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceContentComponent convertDocumentReferenceContentComponent(org.hl7.fhir.r4.model.DocumentReference.DocumentReferenceContentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceContentComponent tgt = new org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceContentComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasAttachment())
      tgt.setAttachment(Attachment40_50.convertAttachment(src.getAttachment()));
    if (src.hasFormat())
      tgt.setFormat(Coding40_50.convertCoding(src.getFormat()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.DocumentReference.DocumentReferenceContentComponent convertDocumentReferenceContentComponent(org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceContentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.DocumentReference.DocumentReferenceContentComponent tgt = new org.hl7.fhir.r4.model.DocumentReference.DocumentReferenceContentComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    if (src.hasAttachment())
      tgt.setAttachment(Attachment40_50.convertAttachment(src.getAttachment()));
    if (src.hasFormat())
      tgt.setFormat(Coding40_50.convertCoding(src.getFormat()));
    return tgt;
  }

  public static void convertDocumentReferenceContextComponent(org.hl7.fhir.r4.model.DocumentReference.DocumentReferenceContextComponent src, org.hl7.fhir.r5.model.DocumentReference tgt) throws FHIRException {
    for (org.hl7.fhir.r4.model.Reference t : src.getEncounter()) tgt.addEncounter(Reference40_50.convertReference(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getEvent())
      tgt.addEvent(CodeableConcept40_50.convertCodeableConcept(t));
    if (src.hasPeriod())
      tgt.setPeriod(Period40_50.convertPeriod(src.getPeriod()));
    if (src.hasFacilityType())
      tgt.setFacilityType(CodeableConcept40_50.convertCodeableConcept(src.getFacilityType()));
    if (src.hasPracticeSetting())
      tgt.setPracticeSetting(CodeableConcept40_50.convertCodeableConcept(src.getPracticeSetting()));
    if (src.hasSourcePatientInfo())
      tgt.setSourcePatientInfo(Reference40_50.convertReference(src.getSourcePatientInfo()));
    for (org.hl7.fhir.r4.model.Reference t : src.getRelated()) tgt.addRelated(Reference40_50.convertReference(t));
  }

  public static void convertDocumentReferenceContextComponent(org.hl7.fhir.r5.model.DocumentReference src, org.hl7.fhir.r4.model.DocumentReference.DocumentReferenceContextComponent tgt) throws FHIRException {
    for (org.hl7.fhir.r5.model.Reference t : src.getEncounter()) tgt.addEncounter(Reference40_50.convertReference(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getEvent())
      tgt.addEvent(CodeableConcept40_50.convertCodeableConcept(t));
    if (src.hasPeriod())
      tgt.setPeriod(Period40_50.convertPeriod(src.getPeriod()));
    if (src.hasFacilityType())
      tgt.setFacilityType(CodeableConcept40_50.convertCodeableConcept(src.getFacilityType()));
    if (src.hasPracticeSetting())
      tgt.setPracticeSetting(CodeableConcept40_50.convertCodeableConcept(src.getPracticeSetting()));
    if (src.hasSourcePatientInfo())
      tgt.setSourcePatientInfo(Reference40_50.convertReference(src.getSourcePatientInfo()));
    for (org.hl7.fhir.r5.model.Reference t : src.getRelated()) tgt.addRelated(Reference40_50.convertReference(t));
  }
}