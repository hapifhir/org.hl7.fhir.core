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


public class Encounter extends VersionConvertor_40_50 {

  public static org.hl7.fhir.r5.model.Encounter convertEncounter(org.hl7.fhir.r4.model.Encounter src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Encounter tgt = new org.hl7.fhir.r5.model.Encounter();
    copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatus(convertEncounterStatus(src.getStatus()));
    for (org.hl7.fhir.r4.model.Encounter.StatusHistoryComponent t : src.getStatusHistory())
      tgt.addStatusHistory(convertStatusHistoryComponent(t));
    if (src.hasClass_())
      tgt.setClass_(convertCoding(src.getClass_()));
    for (org.hl7.fhir.r4.model.Encounter.ClassHistoryComponent t : src.getClassHistory())
      tgt.addClassHistory(convertClassHistoryComponent(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getType())
      tgt.addType(convertCodeableConcept(t));
    if (src.hasServiceType())
      tgt.setServiceType(convertCodeableConcept(src.getServiceType()));
    if (src.hasPriority())
      tgt.setPriority(convertCodeableConcept(src.getPriority()));
    if (src.hasSubject())
      tgt.setSubject(convertReference(src.getSubject()));
    for (org.hl7.fhir.r4.model.Reference t : src.getEpisodeOfCare())
      tgt.addEpisodeOfCare(convertReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getBasedOn())
      tgt.addBasedOn(convertReference(t));
    for (org.hl7.fhir.r4.model.Encounter.EncounterParticipantComponent t : src.getParticipant())
      tgt.addParticipant(convertEncounterParticipantComponent(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getAppointment())
      tgt.addAppointment(convertReference(t));
    if (src.hasPeriod())
      tgt.setPeriod(convertPeriod(src.getPeriod()));
    if (src.hasLength())
      tgt.setLength(convertDuration(src.getLength()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReasonCode())
      tgt.addReasonCode(convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getReasonReference())
      tgt.addReasonReference(convertReference(t));
    for (org.hl7.fhir.r4.model.Encounter.DiagnosisComponent t : src.getDiagnosis())
      tgt.addDiagnosis(convertDiagnosisComponent(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getAccount())
      tgt.addAccount(convertReference(t));
    if (src.hasHospitalization())
      tgt.setHospitalization(convertEncounterHospitalizationComponent(src.getHospitalization()));
    for (org.hl7.fhir.r4.model.Encounter.EncounterLocationComponent t : src.getLocation())
      tgt.addLocation(convertEncounterLocationComponent(t));
    if (src.hasServiceProvider())
      tgt.setServiceProvider(convertReference(src.getServiceProvider()));
    if (src.hasPartOf())
      tgt.setPartOf(convertReference(src.getPartOf()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Encounter convertEncounter(org.hl7.fhir.r5.model.Encounter src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Encounter tgt = new org.hl7.fhir.r4.model.Encounter();
    copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatus(convertEncounterStatus(src.getStatus()));
    for (org.hl7.fhir.r5.model.Encounter.StatusHistoryComponent t : src.getStatusHistory())
      tgt.addStatusHistory(convertStatusHistoryComponent(t));
    if (src.hasClass_())
      tgt.setClass_(convertCoding(src.getClass_()));
    for (org.hl7.fhir.r5.model.Encounter.ClassHistoryComponent t : src.getClassHistory())
      tgt.addClassHistory(convertClassHistoryComponent(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getType())
      tgt.addType(convertCodeableConcept(t));
    if (src.hasServiceType())
      tgt.setServiceType(convertCodeableConcept(src.getServiceType()));
    if (src.hasPriority())
      tgt.setPriority(convertCodeableConcept(src.getPriority()));
    if (src.hasSubject())
      tgt.setSubject(convertReference(src.getSubject()));
    for (org.hl7.fhir.r5.model.Reference t : src.getEpisodeOfCare())
      tgt.addEpisodeOfCare(convertReference(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getBasedOn())
      tgt.addBasedOn(convertReference(t));
    for (org.hl7.fhir.r5.model.Encounter.EncounterParticipantComponent t : src.getParticipant())
      tgt.addParticipant(convertEncounterParticipantComponent(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getAppointment())
      tgt.addAppointment(convertReference(t));
    if (src.hasPeriod())
      tgt.setPeriod(convertPeriod(src.getPeriod()));
    if (src.hasLength())
      tgt.setLength(convertDuration(src.getLength()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getReasonCode())
      tgt.addReasonCode(convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getReasonReference())
      tgt.addReasonReference(convertReference(t));
    for (org.hl7.fhir.r5.model.Encounter.DiagnosisComponent t : src.getDiagnosis())
      tgt.addDiagnosis(convertDiagnosisComponent(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getAccount())
      tgt.addAccount(convertReference(t));
    if (src.hasHospitalization())
      tgt.setHospitalization(convertEncounterHospitalizationComponent(src.getHospitalization()));
    for (org.hl7.fhir.r5.model.Encounter.EncounterLocationComponent t : src.getLocation())
      tgt.addLocation(convertEncounterLocationComponent(t));
    if (src.hasServiceProvider())
      tgt.setServiceProvider(convertReference(src.getServiceProvider()));
    if (src.hasPartOf())
      tgt.setPartOf(convertReference(src.getPartOf()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Encounter.EncounterStatus convertEncounterStatus(org.hl7.fhir.r4.model.Encounter.EncounterStatus src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case PLANNED: return org.hl7.fhir.r5.model.Encounter.EncounterStatus.PLANNED;
    case ARRIVED: return org.hl7.fhir.r5.model.Encounter.EncounterStatus.ARRIVED;
    case TRIAGED: return org.hl7.fhir.r5.model.Encounter.EncounterStatus.TRIAGED;
    case INPROGRESS: return org.hl7.fhir.r5.model.Encounter.EncounterStatus.INPROGRESS;
    case ONLEAVE: return org.hl7.fhir.r5.model.Encounter.EncounterStatus.ONLEAVE;
    case FINISHED: return org.hl7.fhir.r5.model.Encounter.EncounterStatus.FINISHED;
    case CANCELLED: return org.hl7.fhir.r5.model.Encounter.EncounterStatus.CANCELLED;
    case ENTEREDINERROR: return org.hl7.fhir.r5.model.Encounter.EncounterStatus.ENTEREDINERROR;
    case UNKNOWN: return org.hl7.fhir.r5.model.Encounter.EncounterStatus.UNKNOWN;
    default: return org.hl7.fhir.r5.model.Encounter.EncounterStatus.NULL;
  }
}

  public static org.hl7.fhir.r4.model.Encounter.EncounterStatus convertEncounterStatus(org.hl7.fhir.r5.model.Encounter.EncounterStatus src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case PLANNED: return org.hl7.fhir.r4.model.Encounter.EncounterStatus.PLANNED;
    case ARRIVED: return org.hl7.fhir.r4.model.Encounter.EncounterStatus.ARRIVED;
    case TRIAGED: return org.hl7.fhir.r4.model.Encounter.EncounterStatus.TRIAGED;
    case INPROGRESS: return org.hl7.fhir.r4.model.Encounter.EncounterStatus.INPROGRESS;
    case ONLEAVE: return org.hl7.fhir.r4.model.Encounter.EncounterStatus.ONLEAVE;
    case FINISHED: return org.hl7.fhir.r4.model.Encounter.EncounterStatus.FINISHED;
    case CANCELLED: return org.hl7.fhir.r4.model.Encounter.EncounterStatus.CANCELLED;
    case ENTEREDINERROR: return org.hl7.fhir.r4.model.Encounter.EncounterStatus.ENTEREDINERROR;
    case UNKNOWN: return org.hl7.fhir.r4.model.Encounter.EncounterStatus.UNKNOWN;
    default: return org.hl7.fhir.r4.model.Encounter.EncounterStatus.NULL;
  }
}

  public static org.hl7.fhir.r5.model.Encounter.StatusHistoryComponent convertStatusHistoryComponent(org.hl7.fhir.r4.model.Encounter.StatusHistoryComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Encounter.StatusHistoryComponent tgt = new org.hl7.fhir.r5.model.Encounter.StatusHistoryComponent();
    copyElement(src, tgt);
    if (src.hasStatus())
      tgt.setStatus(convertEncounterStatus(src.getStatus()));
    if (src.hasPeriod())
      tgt.setPeriod(convertPeriod(src.getPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Encounter.StatusHistoryComponent convertStatusHistoryComponent(org.hl7.fhir.r5.model.Encounter.StatusHistoryComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Encounter.StatusHistoryComponent tgt = new org.hl7.fhir.r4.model.Encounter.StatusHistoryComponent();
    copyElement(src, tgt);
    if (src.hasStatus())
      tgt.setStatus(convertEncounterStatus(src.getStatus()));
    if (src.hasPeriod())
      tgt.setPeriod(convertPeriod(src.getPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Encounter.ClassHistoryComponent convertClassHistoryComponent(org.hl7.fhir.r4.model.Encounter.ClassHistoryComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Encounter.ClassHistoryComponent tgt = new org.hl7.fhir.r5.model.Encounter.ClassHistoryComponent();
    copyElement(src, tgt);
    if (src.hasClass_())
      tgt.setClass_(convertCoding(src.getClass_()));
    if (src.hasPeriod())
      tgt.setPeriod(convertPeriod(src.getPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Encounter.ClassHistoryComponent convertClassHistoryComponent(org.hl7.fhir.r5.model.Encounter.ClassHistoryComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Encounter.ClassHistoryComponent tgt = new org.hl7.fhir.r4.model.Encounter.ClassHistoryComponent();
    copyElement(src, tgt);
    if (src.hasClass_())
      tgt.setClass_(convertCoding(src.getClass_()));
    if (src.hasPeriod())
      tgt.setPeriod(convertPeriod(src.getPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Encounter.EncounterParticipantComponent convertEncounterParticipantComponent(org.hl7.fhir.r4.model.Encounter.EncounterParticipantComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Encounter.EncounterParticipantComponent tgt = new org.hl7.fhir.r5.model.Encounter.EncounterParticipantComponent();
    copyElement(src, tgt);
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getType())
      tgt.addType(convertCodeableConcept(t));
    if (src.hasPeriod())
      tgt.setPeriod(convertPeriod(src.getPeriod()));
    if (src.hasIndividual())
      tgt.setIndividual(convertReference(src.getIndividual()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Encounter.EncounterParticipantComponent convertEncounterParticipantComponent(org.hl7.fhir.r5.model.Encounter.EncounterParticipantComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Encounter.EncounterParticipantComponent tgt = new org.hl7.fhir.r4.model.Encounter.EncounterParticipantComponent();
    copyElement(src, tgt);
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getType())
      tgt.addType(convertCodeableConcept(t));
    if (src.hasPeriod())
      tgt.setPeriod(convertPeriod(src.getPeriod()));
    if (src.hasIndividual())
      tgt.setIndividual(convertReference(src.getIndividual()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Encounter.DiagnosisComponent convertDiagnosisComponent(org.hl7.fhir.r4.model.Encounter.DiagnosisComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Encounter.DiagnosisComponent tgt = new org.hl7.fhir.r5.model.Encounter.DiagnosisComponent();
    copyElement(src, tgt);
    if (src.hasCondition())
      tgt.setCondition(convertReference(src.getCondition()));
    if (src.hasUse())
      tgt.setUse(convertCodeableConcept(src.getUse()));
    if (src.hasRank())
      tgt.setRankElement(convertPositiveInt(src.getRankElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Encounter.DiagnosisComponent convertDiagnosisComponent(org.hl7.fhir.r5.model.Encounter.DiagnosisComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Encounter.DiagnosisComponent tgt = new org.hl7.fhir.r4.model.Encounter.DiagnosisComponent();
    copyElement(src, tgt);
    if (src.hasCondition())
      tgt.setCondition(convertReference(src.getCondition()));
    if (src.hasUse())
      tgt.setUse(convertCodeableConcept(src.getUse()));
    if (src.hasRank())
      tgt.setRankElement(convertPositiveInt(src.getRankElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Encounter.EncounterHospitalizationComponent convertEncounterHospitalizationComponent(org.hl7.fhir.r4.model.Encounter.EncounterHospitalizationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Encounter.EncounterHospitalizationComponent tgt = new org.hl7.fhir.r5.model.Encounter.EncounterHospitalizationComponent();
    copyElement(src, tgt);
    if (src.hasPreAdmissionIdentifier())
      tgt.setPreAdmissionIdentifier(convertIdentifier(src.getPreAdmissionIdentifier()));
    if (src.hasOrigin())
      tgt.setOrigin(convertReference(src.getOrigin()));
    if (src.hasAdmitSource())
      tgt.setAdmitSource(convertCodeableConcept(src.getAdmitSource()));
    if (src.hasReAdmission())
      tgt.setReAdmission(convertCodeableConcept(src.getReAdmission()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getDietPreference())
      tgt.addDietPreference(convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getSpecialCourtesy())
      tgt.addSpecialCourtesy(convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getSpecialArrangement())
      tgt.addSpecialArrangement(convertCodeableConcept(t));
    if (src.hasDestination())
      tgt.setDestination(convertReference(src.getDestination()));
    if (src.hasDischargeDisposition())
      tgt.setDischargeDisposition(convertCodeableConcept(src.getDischargeDisposition()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Encounter.EncounterHospitalizationComponent convertEncounterHospitalizationComponent(org.hl7.fhir.r5.model.Encounter.EncounterHospitalizationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Encounter.EncounterHospitalizationComponent tgt = new org.hl7.fhir.r4.model.Encounter.EncounterHospitalizationComponent();
    copyElement(src, tgt);
    if (src.hasPreAdmissionIdentifier())
      tgt.setPreAdmissionIdentifier(convertIdentifier(src.getPreAdmissionIdentifier()));
    if (src.hasOrigin())
      tgt.setOrigin(convertReference(src.getOrigin()));
    if (src.hasAdmitSource())
      tgt.setAdmitSource(convertCodeableConcept(src.getAdmitSource()));
    if (src.hasReAdmission())
      tgt.setReAdmission(convertCodeableConcept(src.getReAdmission()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getDietPreference())
      tgt.addDietPreference(convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getSpecialCourtesy())
      tgt.addSpecialCourtesy(convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getSpecialArrangement())
      tgt.addSpecialArrangement(convertCodeableConcept(t));
    if (src.hasDestination())
      tgt.setDestination(convertReference(src.getDestination()));
    if (src.hasDischargeDisposition())
      tgt.setDischargeDisposition(convertCodeableConcept(src.getDischargeDisposition()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Encounter.EncounterLocationComponent convertEncounterLocationComponent(org.hl7.fhir.r4.model.Encounter.EncounterLocationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Encounter.EncounterLocationComponent tgt = new org.hl7.fhir.r5.model.Encounter.EncounterLocationComponent();
    copyElement(src, tgt);
    if (src.hasLocation())
      tgt.setLocation(convertReference(src.getLocation()));
    if (src.hasStatus())
      tgt.setStatus(convertEncounterLocationStatus(src.getStatus()));
    if (src.hasPhysicalType())
      tgt.setPhysicalType(convertCodeableConcept(src.getPhysicalType()));
    if (src.hasPeriod())
      tgt.setPeriod(convertPeriod(src.getPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Encounter.EncounterLocationComponent convertEncounterLocationComponent(org.hl7.fhir.r5.model.Encounter.EncounterLocationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Encounter.EncounterLocationComponent tgt = new org.hl7.fhir.r4.model.Encounter.EncounterLocationComponent();
    copyElement(src, tgt);
    if (src.hasLocation())
      tgt.setLocation(convertReference(src.getLocation()));
    if (src.hasStatus())
      tgt.setStatus(convertEncounterLocationStatus(src.getStatus()));
    if (src.hasPhysicalType())
      tgt.setPhysicalType(convertCodeableConcept(src.getPhysicalType()));
    if (src.hasPeriod())
      tgt.setPeriod(convertPeriod(src.getPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Encounter.EncounterLocationStatus convertEncounterLocationStatus(org.hl7.fhir.r4.model.Encounter.EncounterLocationStatus src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case PLANNED: return org.hl7.fhir.r5.model.Encounter.EncounterLocationStatus.PLANNED;
    case ACTIVE: return org.hl7.fhir.r5.model.Encounter.EncounterLocationStatus.ACTIVE;
    case RESERVED: return org.hl7.fhir.r5.model.Encounter.EncounterLocationStatus.RESERVED;
    case COMPLETED: return org.hl7.fhir.r5.model.Encounter.EncounterLocationStatus.COMPLETED;
    default: return org.hl7.fhir.r5.model.Encounter.EncounterLocationStatus.NULL;
  }
}

  public static org.hl7.fhir.r4.model.Encounter.EncounterLocationStatus convertEncounterLocationStatus(org.hl7.fhir.r5.model.Encounter.EncounterLocationStatus src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case PLANNED: return org.hl7.fhir.r4.model.Encounter.EncounterLocationStatus.PLANNED;
    case ACTIVE: return org.hl7.fhir.r4.model.Encounter.EncounterLocationStatus.ACTIVE;
    case RESERVED: return org.hl7.fhir.r4.model.Encounter.EncounterLocationStatus.RESERVED;
    case COMPLETED: return org.hl7.fhir.r4.model.Encounter.EncounterLocationStatus.COMPLETED;
    default: return org.hl7.fhir.r4.model.Encounter.EncounterLocationStatus.NULL;
  }
}


}
