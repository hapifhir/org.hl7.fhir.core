package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.CrossVersionElements40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Annotation40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.ContactPoint40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Identifier40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Period40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.String40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Reference40_N;
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

public class CareTeam40_N {

  public static org.hl7.fhir.model.core.CareTeam convertCareTeam(org.hl7.fhir.r4.model.CareTeam src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.CareTeam tgt = new org.hl7.fhir.model.core.CareTeam();
    // R6 dropped these
    CrossVersionElements40_N.r4ElementsToExtensions(src, "CareTeam", tgt.getExtension(), "encounter");
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(CrossVersionElements40_N.toR6Code(src.getStatusElement(), convertCareTeamStatus(src.getStatusElement()), src.fhirType(), "status"));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasName())
      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    if (src.hasSubject())
      tgt.setSubject(Reference40_N.convertReference(src.getSubject()));
    if (src.hasPeriod())
      tgt.setPeriod(Period40_N.convertPeriod(src.getPeriod()));
    for (org.hl7.fhir.r4.model.CareTeam.CareTeamParticipantComponent t : src.getParticipant())
      tgt.addParticipant(convertCareTeamParticipantComponent(t));
    CodeableConcept40_N.convertReasonsToR6(src.getReasonCode(), src.getReasonReference(), tgt.getReasonList());
    for (org.hl7.fhir.r4.model.Reference t : src.getManagingOrganization())
      tgt.addManagingOrganization(Reference40_N.convertReference(t));
    for (org.hl7.fhir.r4.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint40_N.convertContactPoint(t));
    for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.addNote(Annotation40_N.convertAnnotation(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CareTeam convertCareTeam(org.hl7.fhir.model.core.CareTeam src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.CareTeam tgt = new org.hl7.fhir.r4.model.CareTeam();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt, CrossVersionElements40_N.urls("CareTeam", "4.0", new String[] {"encounter"}));
    CrossVersionElements40_N.extensionsToR4Elements(src.getExtension(), tgt, "CareTeam", "encounter");
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(CrossVersionElements40_N.toR4Code(src.getStatusElement(), convertCareTeamStatus(src.getStatusElement()), src.fhirType(), "status"));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getCategoryList())
      tgt.addCategory(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasName())
      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    if (src.hasSubject())
      tgt.setSubject(Reference40_N.convertReference(src.getSubject()));
    if (src.hasPeriod())
      tgt.setPeriod(Period40_N.convertPeriod(src.getPeriod()));
    for (org.hl7.fhir.model.core.CareTeam.CareTeamParticipantComponent t : src.getParticipantList())
      tgt.addParticipant(convertCareTeamParticipantComponent(t));
    CodeableConcept40_N.convertReasonsToR4(src.getReasonList(), tgt.getReasonCode(), tgt.getReasonReference());
    for (org.hl7.fhir.model.core.Reference t : src.getManagingOrganizationList())
      tgt.addManagingOrganization(Reference40_N.convertReference(t));
    for (org.hl7.fhir.model.core.ContactPoint t : src.getTelecomList())
      tgt.addTelecom(ContactPoint40_N.convertContactPoint(t));
    for (org.hl7.fhir.model.core.Annotation t : src.getNoteList()) tgt.addNote(Annotation40_N.convertAnnotation(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.CareTeam.CareTeamStatus> convertCareTeamStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CareTeam.CareTeamStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<CareTeam.CareTeamStatus> tgt = new Enumeration<>(new CareTeam.CareTeamStatusEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CareTeam.CareTeamStatus> convertCareTeamStatus(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.CareTeam.CareTeamStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CareTeam.CareTeamStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.CareTeam.CareTeamStatusEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case PROPOSED:
                  tgt.setValue(org.hl7.fhir.r4.model.CareTeam.CareTeamStatus.PROPOSED);
                  break;
              case ACTIVE:
                  tgt.setValue(org.hl7.fhir.r4.model.CareTeam.CareTeamStatus.ACTIVE);
                  break;
              case SUSPENDED:
                  tgt.setValue(org.hl7.fhir.r4.model.CareTeam.CareTeamStatus.SUSPENDED);
                  break;
              case INACTIVE:
                  tgt.setValue(org.hl7.fhir.r4.model.CareTeam.CareTeamStatus.INACTIVE);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(org.hl7.fhir.r4.model.CareTeam.CareTeamStatus.ENTEREDINERROR);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4.model.CareTeam.CareTeamStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.CareTeam.CareTeamParticipantComponent convertCareTeamParticipantComponent(org.hl7.fhir.r4.model.CareTeam.CareTeamParticipantComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.CareTeam.CareTeamParticipantComponent tgt = new org.hl7.fhir.model.core.CareTeam.CareTeamParticipantComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt, CrossVersionElements40_N.urls("CareTeam.participant", "5.0", new String[] {}, CrossVersionElements40_N.urls("CareTeam.participant", "6.0", new String[] {"supportingInfo", "effective"}, CrossVersionElements40_N.url("CareTeam.participant", "4.0", "role"))));
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "6.0", "supportingInfo");
    // R6 role is single: the first, and the rest in 4.0 extensions
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getRole()) {
      if (!tgt.hasRole())
        tgt.setRole(CodeableConcept40_N.convertCodeableConcept(t));
      else
        tgt.addExtension(CrossVersionElements40_N.url("CareTeam.participant", "4.0", "role"), CodeableConcept40_N.convertCodeableConcept(t));
    }
    if (src.hasMember())
      tgt.setMember(Reference40_N.convertReference(src.getMember()));
    if (src.hasOnBehalfOf())
      tgt.setOnBehalfOf(Reference40_N.convertReference(src.getOnBehalfOf()));
    if (src.hasPeriod())
      tgt.setEffective(Period40_N.convertPeriod(src.getPeriod()));
    // R6 effective can also be a Timing
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "6.0", "effective");
    return tgt;
  }

  public static org.hl7.fhir.r4.model.CareTeam.CareTeamParticipantComponent convertCareTeamParticipantComponent(org.hl7.fhir.model.core.CareTeam.CareTeamParticipantComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.CareTeam.CareTeamParticipantComponent tgt = new org.hl7.fhir.r4.model.CareTeam.CareTeamParticipantComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt, CrossVersionElements40_N.url("CareTeam.participant", "4.0", "role"));
    CrossVersionElements40_N.elementsToExtensions(src, tgt.getExtension(), "6.0", "supportingInfo");
    if (src.hasRole())
      tgt.addRole(CodeableConcept40_N.convertCodeableConcept(src.getRole()));
    for (org.hl7.fhir.model.core.Extension ext : src.getExtension())
      if (CrossVersionElements40_N.url("CareTeam.participant", "4.0", "role").equals(ext.getUrl()))
        tgt.addRole(CodeableConcept40_N.convertCodeableConcept((org.hl7.fhir.model.core.CodeableConcept) ext.getValue()));
    if (src.hasMember())
      tgt.setMember(Reference40_N.convertReference(src.getMember()));
    if (src.hasOnBehalfOf())
      tgt.setOnBehalfOf(Reference40_N.convertReference(src.getOnBehalfOf()));
    if (src.hasEffectivePeriod())
      tgt.setPeriod(Period40_N.convertPeriod(src.getEffectivePeriod()));
    else if (src.hasEffective())
      tgt.addExtension(CrossVersionElements40_N.url("CareTeam.participant", "6.0", "effective"), ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getEffective()));
    return tgt;
  }
}