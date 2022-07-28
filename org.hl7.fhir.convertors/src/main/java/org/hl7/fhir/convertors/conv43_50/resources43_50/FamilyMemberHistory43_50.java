package org.hl7.fhir.convertors.conv43_50.resources43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Annotation43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.CodeableConcept43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Identifier43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.*;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.special43_50.Reference43_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CodeableReference;

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
public class FamilyMemberHistory43_50 {

  public static org.hl7.fhir.r5.model.FamilyMemberHistory convertFamilyMemberHistory(org.hl7.fhir.r4b.model.FamilyMemberHistory src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.FamilyMemberHistory tgt = new org.hl7.fhir.r5.model.FamilyMemberHistory();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    for (org.hl7.fhir.r4b.model.CanonicalType t : src.getInstantiatesCanonical())
      tgt.getInstantiatesCanonical().add(Canonical43_50.convertCanonical(t));
    for (org.hl7.fhir.r4b.model.UriType t : src.getInstantiatesUri())
      tgt.getInstantiatesUri().add(Uri43_50.convertUri(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertFamilyHistoryStatus(src.getStatusElement()));
    if (src.hasDataAbsentReason())
      tgt.setDataAbsentReason(CodeableConcept43_50.convertCodeableConcept(src.getDataAbsentReason()));
    if (src.hasPatient())
      tgt.setPatient(Reference43_50.convertReference(src.getPatient()));
    if (src.hasDate())
      tgt.setDateElement(DateTime43_50.convertDateTime(src.getDateElement()));
    if (src.hasName())
      tgt.setNameElement(String43_50.convertString(src.getNameElement()));
    if (src.hasRelationship())
      tgt.setRelationship(CodeableConcept43_50.convertCodeableConcept(src.getRelationship()));
    if (src.hasSex())
      tgt.setSex(CodeableConcept43_50.convertCodeableConcept(src.getSex()));
    if (src.hasBorn())
      tgt.setBorn(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getBorn()));
    if (src.hasAge())
      tgt.setAge(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getAge()));
    if (src.hasEstimatedAge())
      tgt.setEstimatedAgeElement(Boolean43_50.convertBoolean(src.getEstimatedAgeElement()));
    if (src.hasDeceased())
      tgt.setDeceased(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getDeceased()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getReasonCode())
      tgt.addReason(CodeableConcept43_50.convertCodeableConceptToCodeableReference(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getReasonReference())
      tgt.addReason(Reference43_50.convertReferenceToCodeableReference(t));
    for (org.hl7.fhir.r4b.model.Annotation t : src.getNote()) tgt.addNote(Annotation43_50.convertAnnotation(t));
    for (org.hl7.fhir.r4b.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent t : src.getCondition())
      tgt.addCondition(convertFamilyMemberHistoryConditionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.FamilyMemberHistory convertFamilyMemberHistory(org.hl7.fhir.r5.model.FamilyMemberHistory src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.FamilyMemberHistory tgt = new org.hl7.fhir.r4b.model.FamilyMemberHistory();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    for (org.hl7.fhir.r5.model.CanonicalType t : src.getInstantiatesCanonical())
      tgt.getInstantiatesCanonical().add(Canonical43_50.convertCanonical(t));
    for (org.hl7.fhir.r5.model.UriType t : src.getInstantiatesUri())
      tgt.getInstantiatesUri().add(Uri43_50.convertUri(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertFamilyHistoryStatus(src.getStatusElement()));
    if (src.hasDataAbsentReason())
      tgt.setDataAbsentReason(CodeableConcept43_50.convertCodeableConcept(src.getDataAbsentReason()));
    if (src.hasPatient())
      tgt.setPatient(Reference43_50.convertReference(src.getPatient()));
    if (src.hasDate())
      tgt.setDateElement(DateTime43_50.convertDateTime(src.getDateElement()));
    if (src.hasName())
      tgt.setNameElement(String43_50.convertString(src.getNameElement()));
    if (src.hasRelationship())
      tgt.setRelationship(CodeableConcept43_50.convertCodeableConcept(src.getRelationship()));
    if (src.hasSex())
      tgt.setSex(CodeableConcept43_50.convertCodeableConcept(src.getSex()));
    if (src.hasBorn())
      tgt.setBorn(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getBorn()));
    if (src.hasAge())
      tgt.setAge(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getAge()));
    if (src.hasEstimatedAge())
      tgt.setEstimatedAgeElement(Boolean43_50.convertBoolean(src.getEstimatedAgeElement()));
    if (src.hasDeceased())
      tgt.setDeceased(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getDeceased()));
    for (CodeableReference t : src.getReason())
      if (t.hasConcept())
        tgt.addReasonCode(CodeableConcept43_50.convertCodeableConcept(t.getConcept()));
    for (CodeableReference t : src.getReason())
      if (t.hasReference())
        tgt.addReasonReference(Reference43_50.convertReference(t.getReference()));
    for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.addNote(Annotation43_50.convertAnnotation(t));
    for (org.hl7.fhir.r5.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent t : src.getCondition())
      tgt.addCondition(convertFamilyMemberHistoryConditionComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.FamilyMemberHistory.FamilyHistoryStatus> convertFamilyHistoryStatus(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.FamilyMemberHistory.FamilyHistoryStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.FamilyMemberHistory.FamilyHistoryStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.FamilyMemberHistory.FamilyHistoryStatusEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case PARTIAL:
        tgt.setValue(org.hl7.fhir.r5.model.FamilyMemberHistory.FamilyHistoryStatus.PARTIAL);
        break;
      case COMPLETED:
        tgt.setValue(org.hl7.fhir.r5.model.FamilyMemberHistory.FamilyHistoryStatus.COMPLETED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r5.model.FamilyMemberHistory.FamilyHistoryStatus.ENTEREDINERROR);
        break;
      case HEALTHUNKNOWN:
        tgt.setValue(org.hl7.fhir.r5.model.FamilyMemberHistory.FamilyHistoryStatus.HEALTHUNKNOWN);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.FamilyMemberHistory.FamilyHistoryStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.FamilyMemberHistory.FamilyHistoryStatus> convertFamilyHistoryStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.FamilyMemberHistory.FamilyHistoryStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.FamilyMemberHistory.FamilyHistoryStatus> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.FamilyMemberHistory.FamilyHistoryStatusEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case PARTIAL:
        tgt.setValue(org.hl7.fhir.r4b.model.FamilyMemberHistory.FamilyHistoryStatus.PARTIAL);
        break;
      case COMPLETED:
        tgt.setValue(org.hl7.fhir.r4b.model.FamilyMemberHistory.FamilyHistoryStatus.COMPLETED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r4b.model.FamilyMemberHistory.FamilyHistoryStatus.ENTEREDINERROR);
        break;
      case HEALTHUNKNOWN:
        tgt.setValue(org.hl7.fhir.r4b.model.FamilyMemberHistory.FamilyHistoryStatus.HEALTHUNKNOWN);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.FamilyMemberHistory.FamilyHistoryStatus.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent convertFamilyMemberHistoryConditionComponent(org.hl7.fhir.r4b.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent tgt = new org.hl7.fhir.r5.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_50.convertCodeableConcept(src.getCode()));
    if (src.hasOutcome())
      tgt.setOutcome(CodeableConcept43_50.convertCodeableConcept(src.getOutcome()));
    if (src.hasContributedToDeath())
      tgt.setContributedToDeathElement(Boolean43_50.convertBoolean(src.getContributedToDeathElement()));
    if (src.hasOnset())
      tgt.setOnset(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getOnset()));
    for (org.hl7.fhir.r4b.model.Annotation t : src.getNote()) tgt.addNote(Annotation43_50.convertAnnotation(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent convertFamilyMemberHistoryConditionComponent(org.hl7.fhir.r5.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent tgt = new org.hl7.fhir.r4b.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_50.convertCodeableConcept(src.getCode()));
    if (src.hasOutcome())
      tgt.setOutcome(CodeableConcept43_50.convertCodeableConcept(src.getOutcome()));
    if (src.hasContributedToDeath())
      tgt.setContributedToDeathElement(Boolean43_50.convertBoolean(src.getContributedToDeathElement()));
    if (src.hasOnset())
      tgt.setOnset(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getOnset()));
    for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.addNote(Annotation43_50.convertAnnotation(t));
    return tgt;
  }
}