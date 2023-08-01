package org.hl7.fhir.convertors.conv43_50.resources43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.CodeableConcept43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Identifier43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Period43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.special43_50.Reference43_50;
import org.hl7.fhir.exceptions.FHIRException;

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
public class EpisodeOfCare43_50 {

  public static org.hl7.fhir.r5.model.EpisodeOfCare convertEpisodeOfCare(org.hl7.fhir.r4b.model.EpisodeOfCare src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.EpisodeOfCare tgt = new org.hl7.fhir.r5.model.EpisodeOfCare();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertEpisodeOfCareStatus(src.getStatusElement()));
    for (org.hl7.fhir.r4b.model.EpisodeOfCare.EpisodeOfCareStatusHistoryComponent t : src.getStatusHistory())
      tgt.addStatusHistory(convertEpisodeOfCareStatusHistoryComponent(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getType())
      tgt.addType(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r4b.model.EpisodeOfCare.DiagnosisComponent t : src.getDiagnosis())
      tgt.addDiagnosis(convertDiagnosisComponent(t));
    if (src.hasPatient())
      tgt.setPatient(Reference43_50.convertReference(src.getPatient()));
    if (src.hasManagingOrganization())
      tgt.setManagingOrganization(Reference43_50.convertReference(src.getManagingOrganization()));
    if (src.hasPeriod())
      tgt.setPeriod(Period43_50.convertPeriod(src.getPeriod()));
    for (org.hl7.fhir.r4b.model.Reference t : src.getReferralRequest())
      tgt.addReferralRequest(Reference43_50.convertReference(t));
    if (src.hasCareManager())
      tgt.setCareManager(Reference43_50.convertReference(src.getCareManager()));
    for (org.hl7.fhir.r4b.model.Reference t : src.getTeam()) tgt.addCareTeam(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getAccount()) tgt.addAccount(Reference43_50.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.EpisodeOfCare convertEpisodeOfCare(org.hl7.fhir.r5.model.EpisodeOfCare src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.EpisodeOfCare tgt = new org.hl7.fhir.r4b.model.EpisodeOfCare();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertEpisodeOfCareStatus(src.getStatusElement()));
    for (org.hl7.fhir.r5.model.EpisodeOfCare.EpisodeOfCareStatusHistoryComponent t : src.getStatusHistory())
      tgt.addStatusHistory(convertEpisodeOfCareStatusHistoryComponent(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getType())
      tgt.addType(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.EpisodeOfCare.DiagnosisComponent t : src.getDiagnosis())
      tgt.addDiagnosis(convertDiagnosisComponent(t));
    if (src.hasPatient())
      tgt.setPatient(Reference43_50.convertReference(src.getPatient()));
    if (src.hasManagingOrganization())
      tgt.setManagingOrganization(Reference43_50.convertReference(src.getManagingOrganization()));
    if (src.hasPeriod())
      tgt.setPeriod(Period43_50.convertPeriod(src.getPeriod()));
    for (org.hl7.fhir.r5.model.Reference t : src.getReferralRequest())
      tgt.addReferralRequest(Reference43_50.convertReference(t));
    if (src.hasCareManager())
      tgt.setCareManager(Reference43_50.convertReference(src.getCareManager()));
    for (org.hl7.fhir.r5.model.Reference t : src.getCareTeam()) tgt.addTeam(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getAccount()) tgt.addAccount(Reference43_50.convertReference(t));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.EpisodeOfCare.EpisodeOfCareStatus> convertEpisodeOfCareStatus(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.EpisodeOfCare.EpisodeOfCareStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.EpisodeOfCare.EpisodeOfCareStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.EpisodeOfCare.EpisodeOfCareStatusEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case PLANNED:
        tgt.setValue(org.hl7.fhir.r5.model.EpisodeOfCare.EpisodeOfCareStatus.PLANNED);
        break;
      case WAITLIST:
        tgt.setValue(org.hl7.fhir.r5.model.EpisodeOfCare.EpisodeOfCareStatus.WAITLIST);
        break;
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.r5.model.EpisodeOfCare.EpisodeOfCareStatus.ACTIVE);
        break;
      case ONHOLD:
        tgt.setValue(org.hl7.fhir.r5.model.EpisodeOfCare.EpisodeOfCareStatus.ONHOLD);
        break;
      case FINISHED:
        tgt.setValue(org.hl7.fhir.r5.model.EpisodeOfCare.EpisodeOfCareStatus.FINISHED);
        break;
      case CANCELLED:
        tgt.setValue(org.hl7.fhir.r5.model.EpisodeOfCare.EpisodeOfCareStatus.CANCELLED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r5.model.EpisodeOfCare.EpisodeOfCareStatus.ENTEREDINERROR);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.EpisodeOfCare.EpisodeOfCareStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.EpisodeOfCare.EpisodeOfCareStatus> convertEpisodeOfCareStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.EpisodeOfCare.EpisodeOfCareStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.EpisodeOfCare.EpisodeOfCareStatus> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.EpisodeOfCare.EpisodeOfCareStatusEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
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
    return tgt;
  }

  public static org.hl7.fhir.r5.model.EpisodeOfCare.EpisodeOfCareStatusHistoryComponent convertEpisodeOfCareStatusHistoryComponent(org.hl7.fhir.r4b.model.EpisodeOfCare.EpisodeOfCareStatusHistoryComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.EpisodeOfCare.EpisodeOfCareStatusHistoryComponent tgt = new org.hl7.fhir.r5.model.EpisodeOfCare.EpisodeOfCareStatusHistoryComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasStatus())
      tgt.setStatusElement(convertEpisodeOfCareStatus(src.getStatusElement()));
    if (src.hasPeriod())
      tgt.setPeriod(Period43_50.convertPeriod(src.getPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.EpisodeOfCare.EpisodeOfCareStatusHistoryComponent convertEpisodeOfCareStatusHistoryComponent(org.hl7.fhir.r5.model.EpisodeOfCare.EpisodeOfCareStatusHistoryComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.EpisodeOfCare.EpisodeOfCareStatusHistoryComponent tgt = new org.hl7.fhir.r4b.model.EpisodeOfCare.EpisodeOfCareStatusHistoryComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasStatus())
      tgt.setStatusElement(convertEpisodeOfCareStatus(src.getStatusElement()));
    if (src.hasPeriod())
      tgt.setPeriod(Period43_50.convertPeriod(src.getPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.EpisodeOfCare.DiagnosisComponent convertDiagnosisComponent(org.hl7.fhir.r4b.model.EpisodeOfCare.DiagnosisComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.EpisodeOfCare.DiagnosisComponent tgt = new org.hl7.fhir.r5.model.EpisodeOfCare.DiagnosisComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasCondition())
      tgt.addCondition(Reference43_50.convertReferenceToCodeableReference(src.getCondition()));
    if (src.hasRole())
      tgt.setUse(CodeableConcept43_50.convertCodeableConcept(src.getRole()));
//    if (src.hasRank())
//      tgt.setRankElement(PositiveInt43_50.convertPositiveInt(src.getRankElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.EpisodeOfCare.DiagnosisComponent convertDiagnosisComponent(org.hl7.fhir.r5.model.EpisodeOfCare.DiagnosisComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.EpisodeOfCare.DiagnosisComponent tgt = new org.hl7.fhir.r4b.model.EpisodeOfCare.DiagnosisComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasCondition())
      tgt.setCondition(Reference43_50.convertCodeableReferenceToReference(src.getConditionFirstRep()));
    if (src.hasUse())
      tgt.setRole(CodeableConcept43_50.convertCodeableConcept(src.getUse()));
//    if (src.hasRank())
//      tgt.setRankElement(PositiveInt43_50.convertPositiveInt(src.getRankElement()));
    return tgt;
  }
}