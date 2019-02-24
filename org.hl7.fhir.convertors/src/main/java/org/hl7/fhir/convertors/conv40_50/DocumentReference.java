package org.hl7.fhir.convertors.conv40_50;

import org.hl7.fhir.exceptions.FHIRException;

import org.hl7.fhir.convertors.VersionConvertor_40_50;


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


public class DocumentReference extends VersionConvertor_40_50 {

  public static org.hl7.fhir.r5.model.DocumentReference convertDocumentReference(org.hl7.fhir.r4.model.DocumentReference src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.DocumentReference tgt = new org.hl7.fhir.r5.model.DocumentReference();
    copyDomainResource(src, tgt);
    if (src.hasMasterIdentifier())
      tgt.setMasterIdentifier(convertIdentifier(src.getMasterIdentifier()));
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatus(Enumerations.convertDocumentReferenceStatus(src.getStatus()));
    if (src.hasDocStatus())
      tgt.setDocStatus(convertReferredDocumentStatus(src.getDocStatus()));
    if (src.hasType())
      tgt.setType(convertCodeableConcept(src.getType()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(convertCodeableConcept(t));
    if (src.hasSubject())
      tgt.setSubject(convertReference(src.getSubject()));
    if (src.hasDate())
      tgt.setDateElement(convertInstant(src.getDateElement()));
    for (org.hl7.fhir.r4.model.Reference t : src.getAuthor())
      tgt.addAuthor(convertReference(t));
    if (src.hasAuthenticator())
      tgt.setAuthenticator(convertReference(src.getAuthenticator()));
    if (src.hasCustodian())
      tgt.setCustodian(convertReference(src.getCustodian()));
    for (org.hl7.fhir.r4.model.DocumentReference.DocumentReferenceRelatesToComponent t : src.getRelatesTo())
      tgt.addRelatesTo(convertDocumentReferenceRelatesToComponent(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getSecurityLabel())
      tgt.addSecurityLabel(convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.DocumentReference.DocumentReferenceContentComponent t : src.getContent())
      tgt.addContent(convertDocumentReferenceContentComponent(t));
    if (src.hasContext())
      tgt.setContext(convertDocumentReferenceContextComponent(src.getContext()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.DocumentReference convertDocumentReference(org.hl7.fhir.r5.model.DocumentReference src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.DocumentReference tgt = new org.hl7.fhir.r4.model.DocumentReference();
    copyDomainResource(src, tgt);
    if (src.hasMasterIdentifier())
      tgt.setMasterIdentifier(convertIdentifier(src.getMasterIdentifier()));
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatus(Enumerations.convertDocumentReferenceStatus(src.getStatus()));
    if (src.hasDocStatus())
      tgt.setDocStatus(convertReferredDocumentStatus(src.getDocStatus()));
    if (src.hasType())
      tgt.setType(convertCodeableConcept(src.getType()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(convertCodeableConcept(t));
    if (src.hasSubject())
      tgt.setSubject(convertReference(src.getSubject()));
    if (src.hasDate())
      tgt.setDateElement(convertInstant(src.getDateElement()));
    for (org.hl7.fhir.r5.model.Reference t : src.getAuthor())
      tgt.addAuthor(convertReference(t));
    if (src.hasAuthenticator())
      tgt.setAuthenticator(convertReference(src.getAuthenticator()));
    if (src.hasCustodian())
      tgt.setCustodian(convertReference(src.getCustodian()));
    for (org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceRelatesToComponent t : src.getRelatesTo())
      tgt.addRelatesTo(convertDocumentReferenceRelatesToComponent(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getSecurityLabel())
      tgt.addSecurityLabel(convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceContentComponent t : src.getContent())
      tgt.addContent(convertDocumentReferenceContentComponent(t));
    if (src.hasContext())
      tgt.setContext(convertDocumentReferenceContextComponent(src.getContext()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.DocumentReference.ReferredDocumentStatus convertReferredDocumentStatus(org.hl7.fhir.r4.model.DocumentReference.ReferredDocumentStatus src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case PRELIMINARY: return org.hl7.fhir.r5.model.DocumentReference.ReferredDocumentStatus.PRELIMINARY;
    case FINAL: return org.hl7.fhir.r5.model.DocumentReference.ReferredDocumentStatus.FINAL;
    case AMENDED: return org.hl7.fhir.r5.model.DocumentReference.ReferredDocumentStatus.AMENDED;
    case ENTEREDINERROR: return org.hl7.fhir.r5.model.DocumentReference.ReferredDocumentStatus.ENTEREDINERROR;
    default: return org.hl7.fhir.r5.model.DocumentReference.ReferredDocumentStatus.NULL;
  }
}

  public static org.hl7.fhir.r4.model.DocumentReference.ReferredDocumentStatus convertReferredDocumentStatus(org.hl7.fhir.r5.model.DocumentReference.ReferredDocumentStatus src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case PRELIMINARY: return org.hl7.fhir.r4.model.DocumentReference.ReferredDocumentStatus.PRELIMINARY;
    case FINAL: return org.hl7.fhir.r4.model.DocumentReference.ReferredDocumentStatus.FINAL;
    case AMENDED: return org.hl7.fhir.r4.model.DocumentReference.ReferredDocumentStatus.AMENDED;
    case ENTEREDINERROR: return org.hl7.fhir.r4.model.DocumentReference.ReferredDocumentStatus.ENTEREDINERROR;
    default: return org.hl7.fhir.r4.model.DocumentReference.ReferredDocumentStatus.NULL;
  }
}

  public static org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceRelatesToComponent convertDocumentReferenceRelatesToComponent(org.hl7.fhir.r4.model.DocumentReference.DocumentReferenceRelatesToComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceRelatesToComponent tgt = new org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceRelatesToComponent();
    copyElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(convertDocumentRelationshipType(src.getCode()));
    if (src.hasTarget())
      tgt.setTarget(convertReference(src.getTarget()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.DocumentReference.DocumentReferenceRelatesToComponent convertDocumentReferenceRelatesToComponent(org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceRelatesToComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.DocumentReference.DocumentReferenceRelatesToComponent tgt = new org.hl7.fhir.r4.model.DocumentReference.DocumentReferenceRelatesToComponent();
    copyElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(convertDocumentRelationshipType(src.getCode()));
    if (src.hasTarget())
      tgt.setTarget(convertReference(src.getTarget()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.DocumentReference.DocumentRelationshipType convertDocumentRelationshipType(org.hl7.fhir.r4.model.DocumentReference.DocumentRelationshipType src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case REPLACES: return org.hl7.fhir.r5.model.DocumentReference.DocumentRelationshipType.REPLACES;
    case TRANSFORMS: return org.hl7.fhir.r5.model.DocumentReference.DocumentRelationshipType.TRANSFORMS;
    case SIGNS: return org.hl7.fhir.r5.model.DocumentReference.DocumentRelationshipType.SIGNS;
    case APPENDS: return org.hl7.fhir.r5.model.DocumentReference.DocumentRelationshipType.APPENDS;
    default: return org.hl7.fhir.r5.model.DocumentReference.DocumentRelationshipType.NULL;
  }
}

  public static org.hl7.fhir.r4.model.DocumentReference.DocumentRelationshipType convertDocumentRelationshipType(org.hl7.fhir.r5.model.DocumentReference.DocumentRelationshipType src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case REPLACES: return org.hl7.fhir.r4.model.DocumentReference.DocumentRelationshipType.REPLACES;
    case TRANSFORMS: return org.hl7.fhir.r4.model.DocumentReference.DocumentRelationshipType.TRANSFORMS;
    case SIGNS: return org.hl7.fhir.r4.model.DocumentReference.DocumentRelationshipType.SIGNS;
    case APPENDS: return org.hl7.fhir.r4.model.DocumentReference.DocumentRelationshipType.APPENDS;
    default: return org.hl7.fhir.r4.model.DocumentReference.DocumentRelationshipType.NULL;
  }
}

  public static org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceContentComponent convertDocumentReferenceContentComponent(org.hl7.fhir.r4.model.DocumentReference.DocumentReferenceContentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceContentComponent tgt = new org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceContentComponent();
    copyElement(src, tgt);
    if (src.hasAttachment())
      tgt.setAttachment(convertAttachment(src.getAttachment()));
    if (src.hasFormat())
      tgt.setFormat(convertCoding(src.getFormat()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.DocumentReference.DocumentReferenceContentComponent convertDocumentReferenceContentComponent(org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceContentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.DocumentReference.DocumentReferenceContentComponent tgt = new org.hl7.fhir.r4.model.DocumentReference.DocumentReferenceContentComponent();
    copyElement(src, tgt);
    if (src.hasAttachment())
      tgt.setAttachment(convertAttachment(src.getAttachment()));
    if (src.hasFormat())
      tgt.setFormat(convertCoding(src.getFormat()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceContextComponent convertDocumentReferenceContextComponent(org.hl7.fhir.r4.model.DocumentReference.DocumentReferenceContextComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceContextComponent tgt = new org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceContextComponent();
    copyElement(src, tgt);
    for (org.hl7.fhir.r4.model.Reference t : src.getEncounter())
      tgt.addEncounter(convertReference(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getEvent())
      tgt.addEvent(convertCodeableConcept(t));
    if (src.hasPeriod())
      tgt.setPeriod(convertPeriod(src.getPeriod()));
    if (src.hasFacilityType())
      tgt.setFacilityType(convertCodeableConcept(src.getFacilityType()));
    if (src.hasPracticeSetting())
      tgt.setPracticeSetting(convertCodeableConcept(src.getPracticeSetting()));
    if (src.hasSourcePatientInfo())
      tgt.setSourcePatientInfo(convertReference(src.getSourcePatientInfo()));
    for (org.hl7.fhir.r4.model.Reference t : src.getRelated())
      tgt.addRelated(convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.DocumentReference.DocumentReferenceContextComponent convertDocumentReferenceContextComponent(org.hl7.fhir.r5.model.DocumentReference.DocumentReferenceContextComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.DocumentReference.DocumentReferenceContextComponent tgt = new org.hl7.fhir.r4.model.DocumentReference.DocumentReferenceContextComponent();
    copyElement(src, tgt);
    for (org.hl7.fhir.r5.model.Reference t : src.getEncounter())
      tgt.addEncounter(convertReference(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getEvent())
      tgt.addEvent(convertCodeableConcept(t));
    if (src.hasPeriod())
      tgt.setPeriod(convertPeriod(src.getPeriod()));
    if (src.hasFacilityType())
      tgt.setFacilityType(convertCodeableConcept(src.getFacilityType()));
    if (src.hasPracticeSetting())
      tgt.setPracticeSetting(convertCodeableConcept(src.getPracticeSetting()));
    if (src.hasSourcePatientInfo())
      tgt.setSourcePatientInfo(convertReference(src.getSourcePatientInfo()));
    for (org.hl7.fhir.r5.model.Reference t : src.getRelated())
      tgt.addRelated(convertReference(t));
    return tgt;
  }


}
