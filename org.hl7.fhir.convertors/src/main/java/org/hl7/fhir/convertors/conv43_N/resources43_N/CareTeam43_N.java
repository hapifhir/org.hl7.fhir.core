package org.hl7.fhir.convertors.conv43_N.resources43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Annotation43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.CodeableConcept43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.ContactPoint43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Identifier43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Period43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.String43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.special43_N.Reference43_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.CareTeam;
import org.hl7.fhir.model.core.CodeableReference;
import org.hl7.fhir.model.core.Enumeration;

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

public class CareTeam43_N {

  public static org.hl7.fhir.model.core.CareTeam convertCareTeam(org.hl7.fhir.r4b.model.CareTeam src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.CareTeam tgt = new org.hl7.fhir.model.core.CareTeam();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertCareTeamStatus(src.getStatusElement()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasName())
      tgt.setNameElement(String43_N.convertString(src.getNameElement()));
    if (src.hasSubject())
      tgt.setSubject(Reference43_N.convertReference(src.getSubject()));
    if (src.hasPeriod())
      tgt.setPeriod(Period43_N.convertPeriod(src.getPeriod()));
    for (org.hl7.fhir.r4b.model.CareTeam.CareTeamParticipantComponent t : src.getParticipant())
      tgt.addParticipant(convertCareTeamParticipantComponent(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getReasonCode())
      tgt.addReason(CodeableConcept43_N.convertCodeableConceptToCodeableReference(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getReasonReference())
      tgt.addReason(Reference43_N.convertReferenceToCodeableReference(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getManagingOrganization())
      tgt.addManagingOrganization(Reference43_N.convertReference(t));
    for (org.hl7.fhir.r4b.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint43_N.convertContactPoint(t));
    for (org.hl7.fhir.r4b.model.Annotation t : src.getNote()) tgt.addNote(Annotation43_N.convertAnnotation(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.CareTeam convertCareTeam(org.hl7.fhir.model.core.CareTeam src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.CareTeam tgt = new org.hl7.fhir.r4b.model.CareTeam();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertCareTeamStatus(src.getStatusElement()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getCategoryList())
      tgt.addCategory(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasName())
      tgt.setNameElement(String43_N.convertString(src.getNameElement()));
    if (src.hasSubject())
      tgt.setSubject(Reference43_N.convertReference(src.getSubject()));
    if (src.hasPeriod())
      tgt.setPeriod(Period43_N.convertPeriod(src.getPeriod()));
    for (org.hl7.fhir.model.core.CareTeam.CareTeamParticipantComponent t : src.getParticipantList())
      tgt.addParticipant(convertCareTeamParticipantComponent(t));
    for (CodeableReference t : src.getReasonList())
      if (t.hasConcept())
        tgt.addReasonCode(CodeableConcept43_N.convertCodeableConcept(t.getConcept()));
    for (CodeableReference t : src.getReasonList())
      if (t.hasReference())
        tgt.addReasonReference(Reference43_N.convertReference(t.getReference()));
    for (org.hl7.fhir.model.core.Reference t : src.getManagingOrganizationList())
      tgt.addManagingOrganization(Reference43_N.convertReference(t));
    for (org.hl7.fhir.model.core.ContactPoint t : src.getTelecomList())
      tgt.addTelecom(ContactPoint43_N.convertContactPoint(t));
    for (org.hl7.fhir.model.core.Annotation t : src.getNoteList()) tgt.addNote(Annotation43_N.convertAnnotation(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.CareTeam.CareTeamStatus> convertCareTeamStatus(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.CareTeam.CareTeamStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<CareTeam.CareTeamStatus> tgt = new Enumeration<>(new CareTeam.CareTeamStatusEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case PROPOSED:
                  tgt.setValue(CareTeam.CareTeamStatus.PROPOSED);
                  break;
              case ACTIVE:
                  tgt.setValue(CareTeam.CareTeamStatus.ACTIVE);
                  break;
              case SUSPENDED:
                  tgt.setValue(CareTeam.CareTeamStatus.SUSPENDED);
                  break;
              case INACTIVE:
                  tgt.setValue(CareTeam.CareTeamStatus.INACTIVE);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(CareTeam.CareTeamStatus.ENTEREDINERROR);
                  break;
              default:
                  tgt.setValue(CareTeam.CareTeamStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.CareTeam.CareTeamStatus> convertCareTeamStatus(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.CareTeam.CareTeamStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.CareTeam.CareTeamStatus> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.CareTeam.CareTeamStatusEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case PROPOSED:
                  tgt.setValue(org.hl7.fhir.r4b.model.CareTeam.CareTeamStatus.PROPOSED);
                  break;
              case ACTIVE:
                  tgt.setValue(org.hl7.fhir.r4b.model.CareTeam.CareTeamStatus.ACTIVE);
                  break;
              case SUSPENDED:
                  tgt.setValue(org.hl7.fhir.r4b.model.CareTeam.CareTeamStatus.SUSPENDED);
                  break;
              case INACTIVE:
                  tgt.setValue(org.hl7.fhir.r4b.model.CareTeam.CareTeamStatus.INACTIVE);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(org.hl7.fhir.r4b.model.CareTeam.CareTeamStatus.ENTEREDINERROR);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4b.model.CareTeam.CareTeamStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.CareTeam.CareTeamParticipantComponent convertCareTeamParticipantComponent(org.hl7.fhir.r4b.model.CareTeam.CareTeamParticipantComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.CareTeam.CareTeamParticipantComponent tgt = new org.hl7.fhir.model.core.CareTeam.CareTeamParticipantComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getRole())
      tgt.setRole(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasMember())
      tgt.setMember(Reference43_N.convertReference(src.getMember()));
    if (src.hasOnBehalfOf())
      tgt.setOnBehalfOf(Reference43_N.convertReference(src.getOnBehalfOf()));
    if (src.hasPeriod())
      tgt.setEffective(Period43_N.convertPeriod(src.getPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.CareTeam.CareTeamParticipantComponent convertCareTeamParticipantComponent(org.hl7.fhir.model.core.CareTeam.CareTeamParticipantComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.CareTeam.CareTeamParticipantComponent tgt = new org.hl7.fhir.r4b.model.CareTeam.CareTeamParticipantComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasRole())
      tgt.addRole(CodeableConcept43_N.convertCodeableConcept(src.getRole()));
    if (src.hasMember())
      tgt.setMember(Reference43_N.convertReference(src.getMember()));
    if (src.hasOnBehalfOf())
      tgt.setOnBehalfOf(Reference43_N.convertReference(src.getOnBehalfOf()));
    if (src.hasEffectivePeriod())
      tgt.setPeriod(Period43_N.convertPeriod(src.getEffectivePeriod()));
    return tgt;
  }
}