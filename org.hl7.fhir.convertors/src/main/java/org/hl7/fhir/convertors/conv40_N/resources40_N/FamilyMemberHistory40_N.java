package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Annotation40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Identifier40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Boolean40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Canonical40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.DateTime40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.String40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Uri40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Reference40_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.CodeableReference;
import org.hl7.fhir.model.core.Enumeration;
import org.hl7.fhir.model.core.FamilyMemberHistory;

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

public class FamilyMemberHistory40_N {

  public static org.hl7.fhir.model.core.FamilyMemberHistory convertFamilyMemberHistory(org.hl7.fhir.r4.model.FamilyMemberHistory src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.FamilyMemberHistory tgt = new org.hl7.fhir.model.core.FamilyMemberHistory();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertFamilyHistoryStatus(src.getStatusElement()));
    if (src.hasDataAbsentReason())
      tgt.setDataAbsentReason(CodeableConcept40_N.convertCodeableConcept(src.getDataAbsentReason()));
    if (src.hasPatient())
      tgt.setPatient(Reference40_N.convertReference(src.getPatient()));
    if (src.hasDate())
      tgt.setDateElement(DateTime40_N.convertDateTime(src.getDateElement()));
    if (src.hasName())
      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    if (src.hasRelationship())
      tgt.setRelationship(CodeableConcept40_N.convertCodeableConcept(src.getRelationship()));
    if (src.hasSex())
      tgt.setSex(CodeableConcept40_N.convertCodeableConcept(src.getSex()));
    if (src.hasBorn())
      tgt.setBorn(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getBorn()));
    if (src.hasAge())
      tgt.setAge(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getAge()));
    if (src.hasDeceased())
      tgt.setDeceased(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getDeceased()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReasonCode())
      tgt.addReason(CodeableConcept40_N.convertCodeableConceptToCodeableReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getReasonReference())
      tgt.addReason(Reference40_N.convertReferenceToCodeableReference(t));
    for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.addNote(Annotation40_N.convertAnnotation(t));
    for (org.hl7.fhir.r4.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent t : src.getCondition())
      tgt.addCondition(convertFamilyMemberHistoryConditionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.FamilyMemberHistory convertFamilyMemberHistory(org.hl7.fhir.model.core.FamilyMemberHistory src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.FamilyMemberHistory tgt = new org.hl7.fhir.r4.model.FamilyMemberHistory();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertFamilyHistoryStatus(src.getStatusElement()));
    if (src.hasDataAbsentReason())
      tgt.setDataAbsentReason(CodeableConcept40_N.convertCodeableConcept(src.getDataAbsentReason()));
    if (src.hasPatient())
      tgt.setPatient(Reference40_N.convertReference(src.getPatient()));
    if (src.hasDate())
      tgt.setDateElement(DateTime40_N.convertDateTime(src.getDateElement()));
    if (src.hasName())
      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    if (src.hasRelationship())
      tgt.setRelationship(CodeableConcept40_N.convertCodeableConcept(src.getRelationship()));
    if (src.hasSex())
      tgt.setSex(CodeableConcept40_N.convertCodeableConcept(src.getSex()));
    if (src.hasBorn())
      tgt.setBorn(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getBorn()));
    if (src.hasAge())
      tgt.setAge(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getAge()));
    if (src.hasDeceased())
      tgt.setDeceased(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getDeceased()));
    for (CodeableReference t : src.getReasonList())
      if (t.hasConcept())
        tgt.addReasonCode(CodeableConcept40_N.convertCodeableConcept(t.getConcept()));
    for (CodeableReference t : src.getReasonList())
      if (t.hasReference())
        tgt.addReasonReference(Reference40_N.convertReference(t.getReference()));
    for (org.hl7.fhir.model.core.Annotation t : src.getNoteList()) tgt.addNote(Annotation40_N.convertAnnotation(t));
    for (org.hl7.fhir.model.core.FamilyMemberHistory.FamilyMemberHistoryConditionComponent t : src.getConditionList())
      tgt.addCondition(convertFamilyMemberHistoryConditionComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.FamilyMemberHistory.FamilyHistoryStatus> convertFamilyHistoryStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.FamilyMemberHistory.FamilyHistoryStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<FamilyMemberHistory.FamilyHistoryStatus> tgt = new Enumeration<>(new FamilyMemberHistory.FamilyHistoryStatusEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case PARTIAL:
                  tgt.setValue(FamilyMemberHistory.FamilyHistoryStatus.PARTIAL);
                  break;
              case COMPLETED:
                  tgt.setValue(FamilyMemberHistory.FamilyHistoryStatus.COMPLETED);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(FamilyMemberHistory.FamilyHistoryStatus.ENTEREDINERROR);
                  break;
              case HEALTHUNKNOWN:
                  tgt.setValue(FamilyMemberHistory.FamilyHistoryStatus.HEALTHUNKNOWN);
                  break;
              default:
                  tgt.setValue(FamilyMemberHistory.FamilyHistoryStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.FamilyMemberHistory.FamilyHistoryStatus> convertFamilyHistoryStatus(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.FamilyMemberHistory.FamilyHistoryStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.FamilyMemberHistory.FamilyHistoryStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.FamilyMemberHistory.FamilyHistoryStatusEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case PARTIAL:
                  tgt.setValue(org.hl7.fhir.r4.model.FamilyMemberHistory.FamilyHistoryStatus.PARTIAL);
                  break;
              case COMPLETED:
                  tgt.setValue(org.hl7.fhir.r4.model.FamilyMemberHistory.FamilyHistoryStatus.COMPLETED);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(org.hl7.fhir.r4.model.FamilyMemberHistory.FamilyHistoryStatus.ENTEREDINERROR);
                  break;
              case HEALTHUNKNOWN:
                  tgt.setValue(org.hl7.fhir.r4.model.FamilyMemberHistory.FamilyHistoryStatus.HEALTHUNKNOWN);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4.model.FamilyMemberHistory.FamilyHistoryStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.FamilyMemberHistory.FamilyMemberHistoryConditionComponent convertFamilyMemberHistoryConditionComponent(org.hl7.fhir.r4.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.FamilyMemberHistory.FamilyMemberHistoryConditionComponent tgt = new org.hl7.fhir.model.core.FamilyMemberHistory.FamilyMemberHistoryConditionComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_N.convertCodeableConcept(src.getCode()));
    if (src.hasOutcome())
      tgt.setOutcome(CodeableConcept40_N.convertCodeableConcept(src.getOutcome()));
    if (src.hasContributedToDeath())
      tgt.setContributedToDeathElement(Boolean40_N.convertBoolean(src.getContributedToDeathElement()));
    if (src.hasOnset())
      tgt.setOnset(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getOnset()));
    for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.addNote(Annotation40_N.convertAnnotation(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent convertFamilyMemberHistoryConditionComponent(org.hl7.fhir.model.core.FamilyMemberHistory.FamilyMemberHistoryConditionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent tgt = new org.hl7.fhir.r4.model.FamilyMemberHistory.FamilyMemberHistoryConditionComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_N.convertCodeableConcept(src.getCode()));
    if (src.hasOutcome())
      tgt.setOutcome(CodeableConcept40_N.convertCodeableConcept(src.getOutcome()));
    if (src.hasContributedToDeath())
      tgt.setContributedToDeathElement(Boolean40_N.convertBoolean(src.getContributedToDeathElement()));
    if (src.hasOnset())
      tgt.setOnset(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getOnset()));
    for (org.hl7.fhir.model.core.Annotation t : src.getNoteList()) tgt.addNote(Annotation40_N.convertAnnotation(t));
    return tgt;
  }
}