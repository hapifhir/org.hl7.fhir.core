package org.hl7.fhir.convertors.conv43_50.resources43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Annotation43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.CodeableConcept43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.ContactPoint43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Identifier43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Period43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.String43_50;
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
public class CareTeam43_50 {

  public static org.hl7.fhir.r5.model.CareTeam convertCareTeam(org.hl7.fhir.r4b.model.CareTeam src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.CareTeam tgt = new org.hl7.fhir.r5.model.CareTeam();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertCareTeamStatus(src.getStatusElement()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasName())
      tgt.setNameElement(String43_50.convertString(src.getNameElement()));
    if (src.hasSubject())
      tgt.setSubject(Reference43_50.convertReference(src.getSubject()));
    if (src.hasPeriod())
      tgt.setPeriod(Period43_50.convertPeriod(src.getPeriod()));
    for (org.hl7.fhir.r4b.model.CareTeam.CareTeamParticipantComponent t : src.getParticipant())
      tgt.addParticipant(convertCareTeamParticipantComponent(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getReasonCode())
      tgt.addReason(CodeableConcept43_50.convertCodeableConceptToCodeableReference(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getReasonReference())
      tgt.addReason(Reference43_50.convertReferenceToCodeableReference(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getManagingOrganization())
      tgt.addManagingOrganization(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r4b.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint43_50.convertContactPoint(t));
    for (org.hl7.fhir.r4b.model.Annotation t : src.getNote()) tgt.addNote(Annotation43_50.convertAnnotation(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.CareTeam convertCareTeam(org.hl7.fhir.r5.model.CareTeam src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.CareTeam tgt = new org.hl7.fhir.r4b.model.CareTeam();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertCareTeamStatus(src.getStatusElement()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasName())
      tgt.setNameElement(String43_50.convertString(src.getNameElement()));
    if (src.hasSubject())
      tgt.setSubject(Reference43_50.convertReference(src.getSubject()));
    if (src.hasPeriod())
      tgt.setPeriod(Period43_50.convertPeriod(src.getPeriod()));
    for (org.hl7.fhir.r5.model.CareTeam.CareTeamParticipantComponent t : src.getParticipant())
      tgt.addParticipant(convertCareTeamParticipantComponent(t));
    for (CodeableReference t : src.getReason())
      if (t.hasConcept())
        tgt.addReasonCode(CodeableConcept43_50.convertCodeableConcept(t.getConcept()));
    for (CodeableReference t : src.getReason())
      if (t.hasReference())
        tgt.addReasonReference(Reference43_50.convertReference(t.getReference()));
    for (org.hl7.fhir.r5.model.Reference t : src.getManagingOrganization())
      tgt.addManagingOrganization(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r5.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint43_50.convertContactPoint(t));
    for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.addNote(Annotation43_50.convertAnnotation(t));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CareTeam.CareTeamStatus> convertCareTeamStatus(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.CareTeam.CareTeamStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CareTeam.CareTeamStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.CareTeam.CareTeamStatusEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case PROPOSED:
        tgt.setValue(org.hl7.fhir.r5.model.CareTeam.CareTeamStatus.PROPOSED);
        break;
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.r5.model.CareTeam.CareTeamStatus.ACTIVE);
        break;
      case SUSPENDED:
        tgt.setValue(org.hl7.fhir.r5.model.CareTeam.CareTeamStatus.SUSPENDED);
        break;
      case INACTIVE:
        tgt.setValue(org.hl7.fhir.r5.model.CareTeam.CareTeamStatus.INACTIVE);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r5.model.CareTeam.CareTeamStatus.ENTEREDINERROR);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.CareTeam.CareTeamStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.CareTeam.CareTeamStatus> convertCareTeamStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.CareTeam.CareTeamStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.CareTeam.CareTeamStatus> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.CareTeam.CareTeamStatusEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
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
    return tgt;
  }

  public static org.hl7.fhir.r5.model.CareTeam.CareTeamParticipantComponent convertCareTeamParticipantComponent(org.hl7.fhir.r4b.model.CareTeam.CareTeamParticipantComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.CareTeam.CareTeamParticipantComponent tgt = new org.hl7.fhir.r5.model.CareTeam.CareTeamParticipantComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getRole())
      tgt.setRole(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasMember())
      tgt.setMember(Reference43_50.convertReference(src.getMember()));
    if (src.hasOnBehalfOf())
      tgt.setOnBehalfOf(Reference43_50.convertReference(src.getOnBehalfOf()));
    if (src.hasPeriod())
      tgt.setCoverage(Period43_50.convertPeriod(src.getPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.CareTeam.CareTeamParticipantComponent convertCareTeamParticipantComponent(org.hl7.fhir.r5.model.CareTeam.CareTeamParticipantComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.CareTeam.CareTeamParticipantComponent tgt = new org.hl7.fhir.r4b.model.CareTeam.CareTeamParticipantComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasRole())
      tgt.addRole(CodeableConcept43_50.convertCodeableConcept(src.getRole()));
    if (src.hasMember())
      tgt.setMember(Reference43_50.convertReference(src.getMember()));
    if (src.hasOnBehalfOf())
      tgt.setOnBehalfOf(Reference43_50.convertReference(src.getOnBehalfOf()));
    if (src.hasCoveragePeriod())
      tgt.setPeriod(Period43_50.convertPeriod(src.getCoveragePeriod()));
    return tgt;
  }
}