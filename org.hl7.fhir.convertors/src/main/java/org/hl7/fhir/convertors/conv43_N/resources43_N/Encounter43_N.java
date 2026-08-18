package org.hl7.fhir.convertors.conv43_N.resources43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.CodeableConcept43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Coding43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Duration43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Identifier43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Period43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.special43_N.Reference43_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4b.model.Encounter;
import org.hl7.fhir.model.core.CodeableReference;
import org.hl7.fhir.model.core.Encounter.ReasonComponent;
import org.hl7.fhir.model.core.Enumeration;
import org.hl7.fhir.model.core.Enumerations;

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

public class Encounter43_N {

  public static org.hl7.fhir.model.core.Encounter convertEncounter(org.hl7.fhir.r4b.model.Encounter src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Encounter tgt = new org.hl7.fhir.model.core.Encounter();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertEncounterStatus(src.getStatusElement()));
//    for (org.hl7.fhir.r4b.model.Encounter.StatusHistoryComponent t : src.getStatusHistory())
//      tgt.addStatusHistory(convertStatusHistoryComponent(t));
    if (src.hasClass_())
      tgt.addClass_(new org.hl7.fhir.model.core.CodeableConcept().addCoding(Coding43_N.convertCoding(src.getClass_())));
//    for (org.hl7.fhir.r4b.model.Encounter.ClassHistoryComponent t : src.getClassHistory())
//      tgt.addClassHistory(convertClassHistoryComponent(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getType())
      tgt.addType(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasServiceType())
      tgt.addServiceType(new CodeableReference(CodeableConcept43_N.convertCodeableConcept(src.getServiceType())));
    if (src.hasPriority())
      tgt.setPriority(CodeableConcept43_N.convertCodeableConcept(src.getPriority()));
    if (src.hasSubject())
      tgt.setSubject(Reference43_N.convertReference(src.getSubject()));
    for (org.hl7.fhir.r4b.model.Reference t : src.getEpisodeOfCare())
      tgt.addEpisodeOfCare(Reference43_N.convertReference(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getBasedOn()) tgt.addBasedOn(Reference43_N.convertReference(t));
    for (org.hl7.fhir.r4b.model.Encounter.EncounterParticipantComponent t : src.getParticipant())
      tgt.addParticipant(convertEncounterParticipantComponent(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getAppointment())
      tgt.addAppointment(Reference43_N.convertReference(t));
    if (src.hasPeriod())
      tgt.setActualPeriod(Period43_N.convertPeriod(src.getPeriod()));
    if (src.hasLength())
      tgt.setLength(Duration43_N.convertDuration(src.getLength()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getReasonCode())
      tgt.addReason().addValue(CodeableConcept43_N.convertCodeableConceptToCodeableReference(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getReasonReference())
      tgt.addReason().addValue(Reference43_N.convertReferenceToCodeableReference(t));
    for (org.hl7.fhir.r4b.model.Encounter.DiagnosisComponent t : src.getDiagnosis())
      tgt.addDiagnosis(convertDiagnosisComponent(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getAccount()) tgt.addAccount(Reference43_N.convertReference(t));
    if (src.hasHospitalization())
      tgt.setAdmission(convertEncounterHospitalizationComponent(src.getHospitalization(), tgt));
    for (org.hl7.fhir.r4b.model.Encounter.EncounterLocationComponent t : src.getLocation())
      tgt.addLocation(convertEncounterLocationComponent(t));
    if (src.hasServiceProvider())
      tgt.setServiceProvider(Reference43_N.convertReference(src.getServiceProvider()));
    if (src.hasPartOf())
      tgt.setPartOf(Reference43_N.convertReference(src.getPartOf()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Encounter convertEncounter(org.hl7.fhir.model.core.Encounter src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Encounter tgt = new org.hl7.fhir.r4b.model.Encounter();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertEncounterStatus(src.getStatusElement()));
//    for (org.hl7.fhir.model.core.Encounter.StatusHistoryComponent t : src.getStatusHistoryList())
//      tgt.addStatusHistory(convertStatusHistoryComponent(t));
    if (src.hasClass_())
      tgt.setClass_(Coding43_N.convertCoding(src.getClass_FirstRep().getCodingFirstRep()));
//    for (org.hl7.fhir.model.core.Encounter.ClassHistoryComponent t : src.getClassHistoryList())
//      tgt.addClassHistory(convertClassHistoryComponent(t));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getTypeList())
      tgt.addType(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.getServiceTypeFirstRep().hasConcept())
      tgt.setServiceType(CodeableConcept43_N.convertCodeableConcept(src.getServiceTypeFirstRep().getConcept()));
    if (src.hasPriority())
      tgt.setPriority(CodeableConcept43_N.convertCodeableConcept(src.getPriority()));
    if (src.hasSubject())
      tgt.setSubject(Reference43_N.convertReference(src.getSubject()));
    for (org.hl7.fhir.model.core.Reference t : src.getEpisodeOfCareList())
      tgt.addEpisodeOfCare(Reference43_N.convertReference(t));
    for (org.hl7.fhir.model.core.Reference t : src.getBasedOnList()) tgt.addBasedOn(Reference43_N.convertReference(t));
    for (org.hl7.fhir.model.core.Encounter.EncounterParticipantComponent t : src.getParticipantList())
      tgt.addParticipant(convertEncounterParticipantComponent(t));
    for (org.hl7.fhir.model.core.Reference t : src.getAppointmentList())
      tgt.addAppointment(Reference43_N.convertReference(t));
    if (src.hasActualPeriod())
      tgt.setPeriod(Period43_N.convertPeriod(src.getActualPeriod()));
    if (src.hasLength())
      tgt.setLength(Duration43_N.convertDuration(src.getLength()));
    for (ReasonComponent t1 : src.getReasonList())
      for (CodeableReference t : t1.getValueList())
        if (t.hasConcept())
          tgt.addReasonCode(CodeableConcept43_N.convertCodeableConcept(t.getConcept()));
    for (ReasonComponent t1 : src.getReasonList())
      for (CodeableReference t : t1.getValueList())
        if (t.hasReference())
          tgt.addReasonReference(Reference43_N.convertReference(t.getReference()));
    for (org.hl7.fhir.model.core.Encounter.DiagnosisComponent t : src.getDiagnosisList())
      tgt.addDiagnosis(convertDiagnosisComponent(t));
    for (org.hl7.fhir.model.core.Reference t : src.getAccountList()) tgt.addAccount(Reference43_N.convertReference(t));
    if (src.hasAdmission() || src.hasDietPreference() || src.hasSpecialArrangement() || src.hasSpecialCourtesy())
      tgt.setHospitalization(convertEncounterHospitalizationComponent(src.getAdmission(), src));
    for (org.hl7.fhir.model.core.Encounter.EncounterLocationComponent t : src.getLocationList())
      tgt.addLocation(convertEncounterLocationComponent(t));
    if (src.hasServiceProvider())
      tgt.setServiceProvider(Reference43_N.convertReference(src.getServiceProvider()));
    if (src.hasPartOf())
      tgt.setPartOf(Reference43_N.convertReference(src.getPartOf()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Encounter.EncounterStatus> convertEncounterStatus(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Encounter.EncounterStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
     Enumeration<org.hl7.fhir.model.core.Encounter.EncounterStatus> tgt = new Enumeration<>(new org.hl7.fhir.model.core.Encounter.EncounterStatusEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case PLANNED:
                  tgt.setValue(org.hl7.fhir.model.core.Encounter.EncounterStatus.PLANNED);
                  break;
              case ARRIVED:
                  tgt.setValue(org.hl7.fhir.model.core.Encounter.EncounterStatus.INPROGRESS);
                  break;
              case TRIAGED:
                  tgt.setValue(org.hl7.fhir.model.core.Encounter.EncounterStatus.INPROGRESS);
                  break;
              case INPROGRESS:
                  tgt.setValue(org.hl7.fhir.model.core.Encounter.EncounterStatus.INPROGRESS);
                  break;
              case ONLEAVE:
                  tgt.setValue(org.hl7.fhir.model.core.Encounter.EncounterStatus.INPROGRESS);
                  break;
              case FINISHED:
                  tgt.setValue(org.hl7.fhir.model.core.Encounter.EncounterStatus.COMPLETED);
                  break;
              case CANCELLED:
                  tgt.setValue(org.hl7.fhir.model.core.Encounter.EncounterStatus.CANCELLED);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(org.hl7.fhir.model.core.Encounter.EncounterStatus.ENTEREDINERROR);
                  break;
              case UNKNOWN:
                  tgt.setValue(org.hl7.fhir.model.core.Encounter.EncounterStatus.UNKNOWN);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.model.core.Encounter.EncounterStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Encounter.EncounterStatus> convertEncounterStatus(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Encounter.EncounterStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<Encounter.EncounterStatus> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new Encounter.EncounterStatusEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case PLANNED:
                  tgt.setValue(Encounter.EncounterStatus.PLANNED);
                  break;
              case INPROGRESS:
                  tgt.setValue(Encounter.EncounterStatus.INPROGRESS);
                  break;
              case CANCELLED:
                  tgt.setValue(Encounter.EncounterStatus.CANCELLED);
                  break;
              case COMPLETED:
                  tgt.setValue(Encounter.EncounterStatus.FINISHED);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(Encounter.EncounterStatus.ENTEREDINERROR);
                  break;
              case UNKNOWN:
                  tgt.setValue(Encounter.EncounterStatus.UNKNOWN);
                  break;
              default:
                  tgt.setValue(Encounter.EncounterStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

//  public static org.hl7.fhir.model.core.Encounter.StatusHistoryComponent convertStatusHistoryComponent(org.hl7.fhir.r4b.model.Encounter.StatusHistoryComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.model.core.Encounter.StatusHistoryComponent tgt = new org.hl7.fhir.model.core.Encounter.StatusHistoryComponent();
//    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
//    if (src.hasStatus())
//      tgt.setStatusElement(convertEncounterStatus(src.getStatusElement()));
//    if (src.hasPeriod())
//      tgt.setPeriod(Period43_N.convertPeriod(src.getPeriod()));
//    return tgt;
//  }
//
//  public static org.hl7.fhir.r4b.model.Encounter.StatusHistoryComponent convertStatusHistoryComponent(org.hl7.fhir.model.core.Encounter.StatusHistoryComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.r4b.model.Encounter.StatusHistoryComponent tgt = new org.hl7.fhir.r4b.model.Encounter.StatusHistoryComponent();
//    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
//    if (src.hasStatus())
//      tgt.setStatusElement(convertEncounterStatus(src.getStatusElement()));
//    if (src.hasPeriod())
//      tgt.setPeriod(Period43_N.convertPeriod(src.getPeriod()));
//    return tgt;
//  }
//
//  public static org.hl7.fhir.model.core.Encounter.ClassHistoryComponent convertClassHistoryComponent(org.hl7.fhir.r4b.model.Encounter.ClassHistoryComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.model.core.Encounter.ClassHistoryComponent tgt = new org.hl7.fhir.model.core.Encounter.ClassHistoryComponent();
//    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
//    if (src.hasClass_())
//      tgt.setClass_(Coding43_N.convertCoding(src.getClass_()));
//    if (src.hasPeriod())
//      tgt.setPeriod(Period43_N.convertPeriod(src.getPeriod()));
//    return tgt;
//  }
//
//  public static org.hl7.fhir.r4b.model.Encounter.ClassHistoryComponent convertClassHistoryComponent(org.hl7.fhir.model.core.Encounter.ClassHistoryComponent src) throws FHIRException {
//    if (src == null)
//      return null;
//    org.hl7.fhir.r4b.model.Encounter.ClassHistoryComponent tgt = new org.hl7.fhir.r4b.model.Encounter.ClassHistoryComponent();
//    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
//    if (src.hasClass_())
//      tgt.setClass_(Coding43_N.convertCoding(src.getClass_()));
//    if (src.hasPeriod())
//      tgt.setPeriod(Period43_N.convertPeriod(src.getPeriod()));
//    return tgt;
//  }

  public static org.hl7.fhir.model.core.Encounter.EncounterParticipantComponent convertEncounterParticipantComponent(org.hl7.fhir.r4b.model.Encounter.EncounterParticipantComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Encounter.EncounterParticipantComponent tgt = new org.hl7.fhir.model.core.Encounter.EncounterParticipantComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getType())
      tgt.addType(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasPeriod())
      tgt.setPeriod(Period43_N.convertPeriod(src.getPeriod()));
    if (src.hasIndividual())
      tgt.setActor(Reference43_N.convertReference(src.getIndividual()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Encounter.EncounterParticipantComponent convertEncounterParticipantComponent(org.hl7.fhir.model.core.Encounter.EncounterParticipantComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Encounter.EncounterParticipantComponent tgt = new org.hl7.fhir.r4b.model.Encounter.EncounterParticipantComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getTypeList())
      tgt.addType(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasPeriod())
      tgt.setPeriod(Period43_N.convertPeriod(src.getPeriod()));
    if (src.hasActor())
      tgt.setIndividual(Reference43_N.convertReference(src.getActor()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.Encounter.DiagnosisComponent convertDiagnosisComponent(org.hl7.fhir.r4b.model.Encounter.DiagnosisComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Encounter.DiagnosisComponent tgt = new org.hl7.fhir.model.core.Encounter.DiagnosisComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasCondition())
      tgt.addCondition(Reference43_N.convertReferenceToCodeableReference(src.getCondition()));
    if (src.hasUse())
      tgt.addUse(CodeableConcept43_N.convertCodeableConcept(src.getUse()));
//    if (src.hasRank())
//      tgt.setRankElement(PositiveInt43_N.convertPositiveInt(src.getRankElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Encounter.DiagnosisComponent convertDiagnosisComponent(org.hl7.fhir.model.core.Encounter.DiagnosisComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Encounter.DiagnosisComponent tgt = new org.hl7.fhir.r4b.model.Encounter.DiagnosisComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasCondition() && src.getConditionFirstRep().hasReference())
      tgt.setCondition(Reference43_N.convertReference(src.getConditionFirstRep().getReference()));
    if (src.hasUse())
      tgt.setUse(CodeableConcept43_N.convertCodeableConcept(src.getUseFirstRep()));
//    if (src.hasRank())
//      tgt.setRankElement(PositiveInt43_N.convertPositiveInt(src.getRankElement()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.Encounter.EncounterAdmissionComponent convertEncounterHospitalizationComponent(org.hl7.fhir.r4b.model.Encounter.EncounterHospitalizationComponent src, org.hl7.fhir.model.core.Encounter tgte) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Encounter.EncounterAdmissionComponent tgt = new org.hl7.fhir.model.core.Encounter.EncounterAdmissionComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasPreAdmissionIdentifier())
      tgt.setPreAdmissionIdentifier(Identifier43_N.convertIdentifier(src.getPreAdmissionIdentifier()));
    if (src.hasOrigin())
      tgt.setOrigin(Reference43_N.convertReference(src.getOrigin()));
    if (src.hasAdmitSource())
      tgt.setAdmitSource(CodeableConcept43_N.convertCodeableConcept(src.getAdmitSource()));
    if (src.hasReAdmission())
      tgt.setReAdmission(CodeableConcept43_N.convertCodeableConcept(src.getReAdmission()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getDietPreference())
      tgte.addDietPreference(CodeableConcept43_N.convertCodeableConcept(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getSpecialCourtesy())
      tgte.addSpecialCourtesy(CodeableConcept43_N.convertCodeableConcept(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getSpecialArrangement())
      tgte.addSpecialArrangement(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasDestination())
      tgt.setDestination(Reference43_N.convertReference(src.getDestination()));
    if (src.hasDischargeDisposition())
      tgt.setDischargeDisposition(CodeableConcept43_N.convertCodeableConcept(src.getDischargeDisposition()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Encounter.EncounterHospitalizationComponent convertEncounterHospitalizationComponent(org.hl7.fhir.model.core.Encounter.EncounterAdmissionComponent src, org.hl7.fhir.model.core.Encounter srce) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Encounter.EncounterHospitalizationComponent tgt = new org.hl7.fhir.r4b.model.Encounter.EncounterHospitalizationComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasPreAdmissionIdentifier())
      tgt.setPreAdmissionIdentifier(Identifier43_N.convertIdentifier(src.getPreAdmissionIdentifier()));
    if (src.hasOrigin())
      tgt.setOrigin(Reference43_N.convertReference(src.getOrigin()));
    if (src.hasAdmitSource())
      tgt.setAdmitSource(CodeableConcept43_N.convertCodeableConcept(src.getAdmitSource()));
    if (src.hasReAdmission())
      tgt.setReAdmission(CodeableConcept43_N.convertCodeableConcept(src.getReAdmission()));
    for (org.hl7.fhir.model.core.CodeableConcept t : srce.getDietPreferenceList())
      tgt.addDietPreference(CodeableConcept43_N.convertCodeableConcept(t));
    for (org.hl7.fhir.model.core.CodeableConcept t : srce.getSpecialCourtesyList())
      tgt.addSpecialCourtesy(CodeableConcept43_N.convertCodeableConcept(t));
    for (org.hl7.fhir.model.core.CodeableConcept t : srce.getSpecialArrangementList())
      tgt.addSpecialArrangement(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasDestination())
      tgt.setDestination(Reference43_N.convertReference(src.getDestination()));
    if (src.hasDischargeDisposition())
      tgt.setDischargeDisposition(CodeableConcept43_N.convertCodeableConcept(src.getDischargeDisposition()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.Encounter.EncounterLocationComponent convertEncounterLocationComponent(org.hl7.fhir.r4b.model.Encounter.EncounterLocationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Encounter.EncounterLocationComponent tgt = new org.hl7.fhir.model.core.Encounter.EncounterLocationComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasLocation())
      tgt.setLocation(Reference43_N.convertReference(src.getLocation()));
    if (src.hasStatus())
      tgt.setStatusElement(convertEncounterLocationStatus(src.getStatusElement()));
    if (src.hasPhysicalType())
      tgt.setForm(CodeableConcept43_N.convertCodeableConcept(src.getPhysicalType()));
    if (src.hasPeriod())
      tgt.setPeriod(Period43_N.convertPeriod(src.getPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Encounter.EncounterLocationComponent convertEncounterLocationComponent(org.hl7.fhir.model.core.Encounter.EncounterLocationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Encounter.EncounterLocationComponent tgt = new org.hl7.fhir.r4b.model.Encounter.EncounterLocationComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasLocation())
      tgt.setLocation(Reference43_N.convertReference(src.getLocation()));
    if (src.hasStatus())
      tgt.setStatusElement(convertEncounterLocationStatus(src.getStatusElement()));
    if (src.hasForm())
      tgt.setPhysicalType(CodeableConcept43_N.convertCodeableConcept(src.getForm()));
    if (src.hasPeriod())
      tgt.setPeriod(Period43_N.convertPeriod(src.getPeriod()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Encounter.EncounterLocationStatus> convertEncounterLocationStatus(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Encounter.EncounterLocationStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<org.hl7.fhir.model.core.Encounter.EncounterLocationStatus> tgt = new Enumeration<>(new org.hl7.fhir.model.core.Encounter.EncounterLocationStatusEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case PLANNED:
                  tgt.setValue(org.hl7.fhir.model.core.Encounter.EncounterLocationStatus.PLANNED);
                  break;
              case ACTIVE:
                  tgt.setValue(org.hl7.fhir.model.core.Encounter.EncounterLocationStatus.ACTIVE);
                  break;
              case RESERVED:
                  tgt.setValue(org.hl7.fhir.model.core.Encounter.EncounterLocationStatus.RESERVED);
                  break;
              case COMPLETED:
                  tgt.setValue(org.hl7.fhir.model.core.Encounter.EncounterLocationStatus.COMPLETED);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.model.core.Encounter.EncounterLocationStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Encounter.EncounterLocationStatus> convertEncounterLocationStatus(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Encounter.EncounterLocationStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<Encounter.EncounterLocationStatus> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new Encounter.EncounterLocationStatusEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case PLANNED:
                  tgt.setValue(Encounter.EncounterLocationStatus.PLANNED);
                  break;
              case ACTIVE:
                  tgt.setValue(Encounter.EncounterLocationStatus.ACTIVE);
                  break;
              case RESERVED:
                  tgt.setValue(Encounter.EncounterLocationStatus.RESERVED);
                  break;
              case COMPLETED:
                  tgt.setValue(Encounter.EncounterLocationStatus.COMPLETED);
                  break;
              default:
                  tgt.setValue(Encounter.EncounterLocationStatus.NULL);
                  break;
          }
      }
      return tgt;
  }
}