package org.hl7.fhir.convertors.conv43_N.resources43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.CodeableConcept43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Identifier43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Period43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.special43_N.Reference43_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.Enumeration;
import org.hl7.fhir.model.core.EpisodeOfCare;

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

public class EpisodeOfCare43_N {

  public static org.hl7.fhir.model.core.EpisodeOfCare convertEpisodeOfCare(org.hl7.fhir.r4b.model.EpisodeOfCare src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.EpisodeOfCare tgt = new org.hl7.fhir.model.core.EpisodeOfCare();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertEpisodeOfCareStatus(src.getStatusElement()));
    for (org.hl7.fhir.r4b.model.EpisodeOfCare.EpisodeOfCareStatusHistoryComponent t : src.getStatusHistory())
      tgt.addStatusHistory(convertEpisodeOfCareStatusHistoryComponent(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getType())
      tgt.addType(CodeableConcept43_N.convertCodeableConcept(t));
    for (org.hl7.fhir.r4b.model.EpisodeOfCare.DiagnosisComponent t : src.getDiagnosis())
      tgt.addDiagnosis(convertDiagnosisComponent(t));
    if (src.hasPatient())
      tgt.setSubject(Reference43_N.convertReference(src.getPatient()));
    if (src.hasManagingOrganization())
      tgt.setManagingOrganization(Reference43_N.convertReference(src.getManagingOrganization()));
    if (src.hasPeriod())
      tgt.setPeriod(Period43_N.convertPeriod(src.getPeriod()));
    for (org.hl7.fhir.r4b.model.Reference t : src.getReferralRequest())
      tgt.addReferralRequest(Reference43_N.convertReference(t));
    if (src.hasCareManager())
      tgt.setCareManager(Reference43_N.convertReference(src.getCareManager()));
    for (org.hl7.fhir.r4b.model.Reference t : src.getTeam()) tgt.addCareTeam(Reference43_N.convertReference(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getAccount()) tgt.addAccount(Reference43_N.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.EpisodeOfCare convertEpisodeOfCare(org.hl7.fhir.model.core.EpisodeOfCare src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.EpisodeOfCare tgt = new org.hl7.fhir.r4b.model.EpisodeOfCare();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertEpisodeOfCareStatus(src.getStatusElement()));
    for (org.hl7.fhir.model.core.EpisodeOfCare.EpisodeOfCareStatusHistoryComponent t : src.getStatusHistoryList())
      tgt.addStatusHistory(convertEpisodeOfCareStatusHistoryComponent(t));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getTypeList())
      tgt.addType(CodeableConcept43_N.convertCodeableConcept(t));
    for (org.hl7.fhir.model.core.EpisodeOfCare.DiagnosisComponent t : src.getDiagnosisList())
      tgt.addDiagnosis(convertDiagnosisComponent(t));
    if (src.hasSubject())
      tgt.setPatient(Reference43_N.convertReference(src.getSubject()));
    if (src.hasManagingOrganization())
      tgt.setManagingOrganization(Reference43_N.convertReference(src.getManagingOrganization()));
    if (src.hasPeriod())
      tgt.setPeriod(Period43_N.convertPeriod(src.getPeriod()));
    for (org.hl7.fhir.model.core.Reference t : src.getReferralRequestList())
      tgt.addReferralRequest(Reference43_N.convertReference(t));
    if (src.hasCareManager())
      tgt.setCareManager(Reference43_N.convertReference(src.getCareManager()));
    for (org.hl7.fhir.model.core.Reference t : src.getCareTeamList()) tgt.addTeam(Reference43_N.convertReference(t));
    for (org.hl7.fhir.model.core.Reference t : src.getAccountList()) tgt.addAccount(Reference43_N.convertReference(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.EpisodeOfCare.EpisodeOfCareStatus> convertEpisodeOfCareStatus(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.EpisodeOfCare.EpisodeOfCareStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<EpisodeOfCare.EpisodeOfCareStatus> tgt = new Enumeration<>(new EpisodeOfCare.EpisodeOfCareStatusEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case PLANNED:
                  tgt.setValue(EpisodeOfCare.EpisodeOfCareStatus.PLANNED);
                  break;
              case WAITLIST:
                  tgt.setValue(EpisodeOfCare.EpisodeOfCareStatus.WAITLIST);
                  break;
              case ACTIVE:
                  tgt.setValue(EpisodeOfCare.EpisodeOfCareStatus.ACTIVE);
                  break;
              case ONHOLD:
                  tgt.setValue(EpisodeOfCare.EpisodeOfCareStatus.ONHOLD);
                  break;
              case FINISHED:
                  tgt.setValue(EpisodeOfCare.EpisodeOfCareStatus.FINISHED);
                  break;
              case CANCELLED:
                  tgt.setValue(EpisodeOfCare.EpisodeOfCareStatus.CANCELLED);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(EpisodeOfCare.EpisodeOfCareStatus.ENTEREDINERROR);
                  break;
              default:
                  tgt.setValue(EpisodeOfCare.EpisodeOfCareStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.EpisodeOfCare.EpisodeOfCareStatus> convertEpisodeOfCareStatus(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.EpisodeOfCare.EpisodeOfCareStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.EpisodeOfCare.EpisodeOfCareStatus> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.EpisodeOfCare.EpisodeOfCareStatusEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case PLANNED:
                  tgt.setValue(org.hl7.fhir.r4b.model.EpisodeOfCare.EpisodeOfCareStatus.PLANNED);
                  break;
              case WAITLIST:
                  tgt.setValue(org.hl7.fhir.r4b.model.EpisodeOfCare.EpisodeOfCareStatus.WAITLIST);
                  break;
              case ACTIVE:
                  tgt.setValue(org.hl7.fhir.r4b.model.EpisodeOfCare.EpisodeOfCareStatus.ACTIVE);
                  break;
              case ONHOLD:
                  tgt.setValue(org.hl7.fhir.r4b.model.EpisodeOfCare.EpisodeOfCareStatus.ONHOLD);
                  break;
              case FINISHED:
                  tgt.setValue(org.hl7.fhir.r4b.model.EpisodeOfCare.EpisodeOfCareStatus.FINISHED);
                  break;
              case CANCELLED:
                  tgt.setValue(org.hl7.fhir.r4b.model.EpisodeOfCare.EpisodeOfCareStatus.CANCELLED);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(org.hl7.fhir.r4b.model.EpisodeOfCare.EpisodeOfCareStatus.ENTEREDINERROR);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4b.model.EpisodeOfCare.EpisodeOfCareStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.EpisodeOfCare.EpisodeOfCareStatusHistoryComponent convertEpisodeOfCareStatusHistoryComponent(org.hl7.fhir.r4b.model.EpisodeOfCare.EpisodeOfCareStatusHistoryComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.EpisodeOfCare.EpisodeOfCareStatusHistoryComponent tgt = new org.hl7.fhir.model.core.EpisodeOfCare.EpisodeOfCareStatusHistoryComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasStatus())
      tgt.setStatusElement(convertEpisodeOfCareStatus(src.getStatusElement()));
    if (src.hasPeriod())
      tgt.setPeriod(Period43_N.convertPeriod(src.getPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.EpisodeOfCare.EpisodeOfCareStatusHistoryComponent convertEpisodeOfCareStatusHistoryComponent(org.hl7.fhir.model.core.EpisodeOfCare.EpisodeOfCareStatusHistoryComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.EpisodeOfCare.EpisodeOfCareStatusHistoryComponent tgt = new org.hl7.fhir.r4b.model.EpisodeOfCare.EpisodeOfCareStatusHistoryComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasStatus())
      tgt.setStatusElement(convertEpisodeOfCareStatus(src.getStatusElement()));
    if (src.hasPeriod())
      tgt.setPeriod(Period43_N.convertPeriod(src.getPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.EpisodeOfCare.DiagnosisComponent convertDiagnosisComponent(org.hl7.fhir.r4b.model.EpisodeOfCare.DiagnosisComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.EpisodeOfCare.DiagnosisComponent tgt = new org.hl7.fhir.model.core.EpisodeOfCare.DiagnosisComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasCondition())
      tgt.addCondition(Reference43_N.convertReferenceToCodeableReference(src.getCondition()));
    if (src.hasRole())
      tgt.addUse(CodeableConcept43_N.convertCodeableConcept(src.getRole()));
//    if (src.hasRank())
//      tgt.setRankElement(PositiveInt43_N.convertPositiveInt(src.getRankElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.EpisodeOfCare.DiagnosisComponent convertDiagnosisComponent(org.hl7.fhir.model.core.EpisodeOfCare.DiagnosisComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.EpisodeOfCare.DiagnosisComponent tgt = new org.hl7.fhir.r4b.model.EpisodeOfCare.DiagnosisComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasCondition())
      tgt.setCondition(Reference43_N.convertCodeableReferenceToReference(src.getConditionFirstRep()));
    if (src.hasUse())
      tgt.setRole(CodeableConcept43_N.convertCodeableConcept(src.getUseFirstRep()));
//    if (src.hasRank())
//      tgt.setRankElement(PositiveInt43_N.convertPositiveInt(src.getRankElement()));
    return tgt;
  }
}