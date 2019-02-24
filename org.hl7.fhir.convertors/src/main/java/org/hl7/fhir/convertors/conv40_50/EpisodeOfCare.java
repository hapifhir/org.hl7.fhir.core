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


public class EpisodeOfCare extends VersionConvertor_40_50 {

  public static org.hl7.fhir.r5.model.EpisodeOfCare convertEpisodeOfCare(org.hl7.fhir.r4.model.EpisodeOfCare src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.EpisodeOfCare tgt = new org.hl7.fhir.r5.model.EpisodeOfCare();
    copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatus(convertEpisodeOfCareStatus(src.getStatus()));
    for (org.hl7.fhir.r4.model.EpisodeOfCare.EpisodeOfCareStatusHistoryComponent t : src.getStatusHistory())
      tgt.addStatusHistory(convertEpisodeOfCareStatusHistoryComponent(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getType())
      tgt.addType(convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.EpisodeOfCare.DiagnosisComponent t : src.getDiagnosis())
      tgt.addDiagnosis(convertDiagnosisComponent(t));
    if (src.hasPatient())
      tgt.setPatient(convertReference(src.getPatient()));
    if (src.hasManagingOrganization())
      tgt.setManagingOrganization(convertReference(src.getManagingOrganization()));
    if (src.hasPeriod())
      tgt.setPeriod(convertPeriod(src.getPeriod()));
    for (org.hl7.fhir.r4.model.Reference t : src.getReferralRequest())
      tgt.addReferralRequest(convertReference(t));
    if (src.hasCareManager())
      tgt.setCareManager(convertReference(src.getCareManager()));
    for (org.hl7.fhir.r4.model.Reference t : src.getTeam())
      tgt.addTeam(convertReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getAccount())
      tgt.addAccount(convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.EpisodeOfCare convertEpisodeOfCare(org.hl7.fhir.r5.model.EpisodeOfCare src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.EpisodeOfCare tgt = new org.hl7.fhir.r4.model.EpisodeOfCare();
    copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatus(convertEpisodeOfCareStatus(src.getStatus()));
    for (org.hl7.fhir.r5.model.EpisodeOfCare.EpisodeOfCareStatusHistoryComponent t : src.getStatusHistory())
      tgt.addStatusHistory(convertEpisodeOfCareStatusHistoryComponent(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getType())
      tgt.addType(convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.EpisodeOfCare.DiagnosisComponent t : src.getDiagnosis())
      tgt.addDiagnosis(convertDiagnosisComponent(t));
    if (src.hasPatient())
      tgt.setPatient(convertReference(src.getPatient()));
    if (src.hasManagingOrganization())
      tgt.setManagingOrganization(convertReference(src.getManagingOrganization()));
    if (src.hasPeriod())
      tgt.setPeriod(convertPeriod(src.getPeriod()));
    for (org.hl7.fhir.r5.model.Reference t : src.getReferralRequest())
      tgt.addReferralRequest(convertReference(t));
    if (src.hasCareManager())
      tgt.setCareManager(convertReference(src.getCareManager()));
    for (org.hl7.fhir.r5.model.Reference t : src.getTeam())
      tgt.addTeam(convertReference(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getAccount())
      tgt.addAccount(convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.EpisodeOfCare.EpisodeOfCareStatus convertEpisodeOfCareStatus(org.hl7.fhir.r4.model.EpisodeOfCare.EpisodeOfCareStatus src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case PLANNED: return org.hl7.fhir.r5.model.EpisodeOfCare.EpisodeOfCareStatus.PLANNED;
    case WAITLIST: return org.hl7.fhir.r5.model.EpisodeOfCare.EpisodeOfCareStatus.WAITLIST;
    case ACTIVE: return org.hl7.fhir.r5.model.EpisodeOfCare.EpisodeOfCareStatus.ACTIVE;
    case ONHOLD: return org.hl7.fhir.r5.model.EpisodeOfCare.EpisodeOfCareStatus.ONHOLD;
    case FINISHED: return org.hl7.fhir.r5.model.EpisodeOfCare.EpisodeOfCareStatus.FINISHED;
    case CANCELLED: return org.hl7.fhir.r5.model.EpisodeOfCare.EpisodeOfCareStatus.CANCELLED;
    case ENTEREDINERROR: return org.hl7.fhir.r5.model.EpisodeOfCare.EpisodeOfCareStatus.ENTEREDINERROR;
    default: return org.hl7.fhir.r5.model.EpisodeOfCare.EpisodeOfCareStatus.NULL;
  }
}

  public static org.hl7.fhir.r4.model.EpisodeOfCare.EpisodeOfCareStatus convertEpisodeOfCareStatus(org.hl7.fhir.r5.model.EpisodeOfCare.EpisodeOfCareStatus src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case PLANNED: return org.hl7.fhir.r4.model.EpisodeOfCare.EpisodeOfCareStatus.PLANNED;
    case WAITLIST: return org.hl7.fhir.r4.model.EpisodeOfCare.EpisodeOfCareStatus.WAITLIST;
    case ACTIVE: return org.hl7.fhir.r4.model.EpisodeOfCare.EpisodeOfCareStatus.ACTIVE;
    case ONHOLD: return org.hl7.fhir.r4.model.EpisodeOfCare.EpisodeOfCareStatus.ONHOLD;
    case FINISHED: return org.hl7.fhir.r4.model.EpisodeOfCare.EpisodeOfCareStatus.FINISHED;
    case CANCELLED: return org.hl7.fhir.r4.model.EpisodeOfCare.EpisodeOfCareStatus.CANCELLED;
    case ENTEREDINERROR: return org.hl7.fhir.r4.model.EpisodeOfCare.EpisodeOfCareStatus.ENTEREDINERROR;
    default: return org.hl7.fhir.r4.model.EpisodeOfCare.EpisodeOfCareStatus.NULL;
  }
}

  public static org.hl7.fhir.r5.model.EpisodeOfCare.EpisodeOfCareStatusHistoryComponent convertEpisodeOfCareStatusHistoryComponent(org.hl7.fhir.r4.model.EpisodeOfCare.EpisodeOfCareStatusHistoryComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.EpisodeOfCare.EpisodeOfCareStatusHistoryComponent tgt = new org.hl7.fhir.r5.model.EpisodeOfCare.EpisodeOfCareStatusHistoryComponent();
    copyElement(src, tgt);
    if (src.hasStatus())
      tgt.setStatus(convertEpisodeOfCareStatus(src.getStatus()));
    if (src.hasPeriod())
      tgt.setPeriod(convertPeriod(src.getPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.EpisodeOfCare.EpisodeOfCareStatusHistoryComponent convertEpisodeOfCareStatusHistoryComponent(org.hl7.fhir.r5.model.EpisodeOfCare.EpisodeOfCareStatusHistoryComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.EpisodeOfCare.EpisodeOfCareStatusHistoryComponent tgt = new org.hl7.fhir.r4.model.EpisodeOfCare.EpisodeOfCareStatusHistoryComponent();
    copyElement(src, tgt);
    if (src.hasStatus())
      tgt.setStatus(convertEpisodeOfCareStatus(src.getStatus()));
    if (src.hasPeriod())
      tgt.setPeriod(convertPeriod(src.getPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.EpisodeOfCare.DiagnosisComponent convertDiagnosisComponent(org.hl7.fhir.r4.model.EpisodeOfCare.DiagnosisComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.EpisodeOfCare.DiagnosisComponent tgt = new org.hl7.fhir.r5.model.EpisodeOfCare.DiagnosisComponent();
    copyElement(src, tgt);
    if (src.hasCondition())
      tgt.setCondition(convertReference(src.getCondition()));
    if (src.hasRole())
      tgt.setRole(convertCodeableConcept(src.getRole()));
    if (src.hasRank())
      tgt.setRankElement(convertPositiveInt(src.getRankElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.EpisodeOfCare.DiagnosisComponent convertDiagnosisComponent(org.hl7.fhir.r5.model.EpisodeOfCare.DiagnosisComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.EpisodeOfCare.DiagnosisComponent tgt = new org.hl7.fhir.r4.model.EpisodeOfCare.DiagnosisComponent();
    copyElement(src, tgt);
    if (src.hasCondition())
      tgt.setCondition(convertReference(src.getCondition()));
    if (src.hasRole())
      tgt.setRole(convertCodeableConcept(src.getRole()));
    if (src.hasRank())
      tgt.setRankElement(convertPositiveInt(src.getRankElement()));
    return tgt;
  }


}
