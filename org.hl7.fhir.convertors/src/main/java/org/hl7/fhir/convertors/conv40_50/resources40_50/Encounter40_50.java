package org.hl7.fhir.convertors.conv40_50.resources40_50;


import org.hl7.fhir.convertors.VersionConvertor_40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.Element40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.*;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.PositiveInt40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.special40_50.Reference40_50;
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
public class Encounter40_50 extends VersionConvertor_40_50 {

    public static org.hl7.fhir.r5.model.Encounter convertEncounter(org.hl7.fhir.r4.model.Encounter src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Encounter tgt = new org.hl7.fhir.r5.model.Encounter();
        copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(Identifier40_50.convertIdentifier(t));
        if (src.hasStatus())
            tgt.setStatusElement(convertEncounterStatus(src.getStatusElement()));
        for (org.hl7.fhir.r4.model.Encounter.StatusHistoryComponent t : src.getStatusHistory()) tgt.addStatusHistory(convertStatusHistoryComponent(t));
        if (src.hasClass_())
            tgt.setClass_(Coding40_50.convertCoding(src.getClass_()));
        for (org.hl7.fhir.r4.model.Encounter.ClassHistoryComponent t : src.getClassHistory()) tgt.addClassHistory(convertClassHistoryComponent(t));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getType()) tgt.addType(CodeableConcept40_50.convertCodeableConcept(t));
        if (src.hasServiceType())
            tgt.setServiceType(CodeableConcept40_50.convertCodeableConcept(src.getServiceType()));
        if (src.hasPriority())
            tgt.setPriority(CodeableConcept40_50.convertCodeableConcept(src.getPriority()));
        if (src.hasSubject())
            tgt.setSubject(Reference40_50.convertReference(src.getSubject()));
        for (org.hl7.fhir.r4.model.Reference t : src.getEpisodeOfCare()) tgt.addEpisodeOfCare(Reference40_50.convertReference(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getBasedOn()) tgt.addBasedOn(Reference40_50.convertReference(t));
        for (org.hl7.fhir.r4.model.Encounter.EncounterParticipantComponent t : src.getParticipant()) tgt.addParticipant(convertEncounterParticipantComponent(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getAppointment()) tgt.addAppointment(Reference40_50.convertReference(t));
        if (src.hasPeriod())
            tgt.setPeriod(Period40_50.convertPeriod(src.getPeriod()));
        if (src.hasLength())
            tgt.setLength(Duration40_50.convertDuration(src.getLength()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReasonCode()) tgt.addReason(CodeableConcept40_50.convertCodeableConceptToCodeableReference(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getReasonReference()) tgt.addReason(Reference40_50.convertReferenceToCodeableReference(t));
        for (org.hl7.fhir.r4.model.Encounter.DiagnosisComponent t : src.getDiagnosis()) tgt.addDiagnosis(convertDiagnosisComponent(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getAccount()) tgt.addAccount(Reference40_50.convertReference(t));
        if (src.hasHospitalization())
            tgt.setHospitalization(convertEncounterHospitalizationComponent(src.getHospitalization()));
        for (org.hl7.fhir.r4.model.Encounter.EncounterLocationComponent t : src.getLocation()) tgt.addLocation(convertEncounterLocationComponent(t));
        if (src.hasServiceProvider())
            tgt.setServiceProvider(Reference40_50.convertReference(src.getServiceProvider()));
        if (src.hasPartOf())
            tgt.setPartOf(Reference40_50.convertReference(src.getPartOf()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Encounter convertEncounter(org.hl7.fhir.r5.model.Encounter src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Encounter tgt = new org.hl7.fhir.r4.model.Encounter();
        copyDomainResource(src, tgt);
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(Identifier40_50.convertIdentifier(t));
        if (src.hasStatus())
            tgt.setStatusElement(convertEncounterStatus(src.getStatusElement()));
        for (org.hl7.fhir.r5.model.Encounter.StatusHistoryComponent t : src.getStatusHistory()) tgt.addStatusHistory(convertStatusHistoryComponent(t));
        if (src.hasClass_())
            tgt.setClass_(Coding40_50.convertCoding(src.getClass_()));
        for (org.hl7.fhir.r5.model.Encounter.ClassHistoryComponent t : src.getClassHistory()) tgt.addClassHistory(convertClassHistoryComponent(t));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getType()) tgt.addType(CodeableConcept40_50.convertCodeableConcept(t));
        if (src.hasServiceType())
            tgt.setServiceType(CodeableConcept40_50.convertCodeableConcept(src.getServiceType()));
        if (src.hasPriority())
            tgt.setPriority(CodeableConcept40_50.convertCodeableConcept(src.getPriority()));
        if (src.hasSubject())
            tgt.setSubject(Reference40_50.convertReference(src.getSubject()));
        for (org.hl7.fhir.r5.model.Reference t : src.getEpisodeOfCare()) tgt.addEpisodeOfCare(Reference40_50.convertReference(t));
        for (org.hl7.fhir.r5.model.Reference t : src.getBasedOn()) tgt.addBasedOn(Reference40_50.convertReference(t));
        for (org.hl7.fhir.r5.model.Encounter.EncounterParticipantComponent t : src.getParticipant()) tgt.addParticipant(convertEncounterParticipantComponent(t));
        for (org.hl7.fhir.r5.model.Reference t : src.getAppointment()) tgt.addAppointment(Reference40_50.convertReference(t));
        if (src.hasPeriod())
            tgt.setPeriod(Period40_50.convertPeriod(src.getPeriod()));
        if (src.hasLength())
            tgt.setLength(Duration40_50.convertDuration(src.getLength()));
        for (CodeableReference t : src.getReason()) if (t.hasConcept())
            tgt.addReasonCode(CodeableConcept40_50.convertCodeableConcept(t.getConcept()));
        for (CodeableReference t : src.getReason()) if (t.hasReference())
            tgt.addReasonReference(Reference40_50.convertReference(t.getReference()));
        for (org.hl7.fhir.r5.model.Encounter.DiagnosisComponent t : src.getDiagnosis()) tgt.addDiagnosis(convertDiagnosisComponent(t));
        for (org.hl7.fhir.r5.model.Reference t : src.getAccount()) tgt.addAccount(Reference40_50.convertReference(t));
        if (src.hasHospitalization())
            tgt.setHospitalization(convertEncounterHospitalizationComponent(src.getHospitalization()));
        for (org.hl7.fhir.r5.model.Encounter.EncounterLocationComponent t : src.getLocation()) tgt.addLocation(convertEncounterLocationComponent(t));
        if (src.hasServiceProvider())
            tgt.setServiceProvider(Reference40_50.convertReference(src.getServiceProvider()));
        if (src.hasPartOf())
            tgt.setPartOf(Reference40_50.convertReference(src.getPartOf()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Encounter.EncounterStatus> convertEncounterStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Encounter.EncounterStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Encounter.EncounterStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Encounter.EncounterStatusEnumFactory());
        Element40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case PLANNED:
                tgt.setValue(org.hl7.fhir.r5.model.Encounter.EncounterStatus.PLANNED);
                break;
            case ARRIVED:
                tgt.setValue(org.hl7.fhir.r5.model.Encounter.EncounterStatus.INPROGRESS);
                break;
            case TRIAGED:
                tgt.setValue(org.hl7.fhir.r5.model.Encounter.EncounterStatus.INPROGRESS);
                break;
            case INPROGRESS:
                tgt.setValue(org.hl7.fhir.r5.model.Encounter.EncounterStatus.INPROGRESS);
                break;
            case ONLEAVE:
                tgt.setValue(org.hl7.fhir.r5.model.Encounter.EncounterStatus.INPROGRESS);
                break;
            case FINISHED:
                tgt.setValue(org.hl7.fhir.r5.model.Encounter.EncounterStatus.COMPLETED);
                break;
            case CANCELLED:
                tgt.setValue(org.hl7.fhir.r5.model.Encounter.EncounterStatus.CANCELLED);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.r5.model.Encounter.EncounterStatus.ENTEREDINERROR);
                break;
            case UNKNOWN:
                tgt.setValue(org.hl7.fhir.r5.model.Encounter.EncounterStatus.UNKNOWN);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Encounter.EncounterStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Encounter.EncounterStatus> convertEncounterStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Encounter.EncounterStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Encounter.EncounterStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Encounter.EncounterStatusEnumFactory());
        Element40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case PLANNED:
                tgt.setValue(org.hl7.fhir.r4.model.Encounter.EncounterStatus.PLANNED);
                break;
            case INPROGRESS:
                tgt.setValue(org.hl7.fhir.r4.model.Encounter.EncounterStatus.INPROGRESS);
                break;
            case CANCELLED:
                tgt.setValue(org.hl7.fhir.r4.model.Encounter.EncounterStatus.CANCELLED);
                break;
            case COMPLETED:
                tgt.setValue(org.hl7.fhir.r4.model.Encounter.EncounterStatus.FINISHED);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.r4.model.Encounter.EncounterStatus.ENTEREDINERROR);
                break;
            case UNKNOWN:
                tgt.setValue(org.hl7.fhir.r4.model.Encounter.EncounterStatus.UNKNOWN);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.Encounter.EncounterStatus.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Encounter.StatusHistoryComponent convertStatusHistoryComponent(org.hl7.fhir.r4.model.Encounter.StatusHistoryComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Encounter.StatusHistoryComponent tgt = new org.hl7.fhir.r5.model.Encounter.StatusHistoryComponent();
        Element40_50.copyElement(src, tgt);
        if (src.hasStatus())
            tgt.setStatusElement(convertEncounterStatus(src.getStatusElement()));
        if (src.hasPeriod())
            tgt.setPeriod(Period40_50.convertPeriod(src.getPeriod()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Encounter.StatusHistoryComponent convertStatusHistoryComponent(org.hl7.fhir.r5.model.Encounter.StatusHistoryComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Encounter.StatusHistoryComponent tgt = new org.hl7.fhir.r4.model.Encounter.StatusHistoryComponent();
        Element40_50.copyElement(src, tgt);
        if (src.hasStatus())
            tgt.setStatusElement(convertEncounterStatus(src.getStatusElement()));
        if (src.hasPeriod())
            tgt.setPeriod(Period40_50.convertPeriod(src.getPeriod()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Encounter.ClassHistoryComponent convertClassHistoryComponent(org.hl7.fhir.r4.model.Encounter.ClassHistoryComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Encounter.ClassHistoryComponent tgt = new org.hl7.fhir.r5.model.Encounter.ClassHistoryComponent();
        Element40_50.copyElement(src, tgt);
        if (src.hasClass_())
            tgt.setClass_(Coding40_50.convertCoding(src.getClass_()));
        if (src.hasPeriod())
            tgt.setPeriod(Period40_50.convertPeriod(src.getPeriod()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Encounter.ClassHistoryComponent convertClassHistoryComponent(org.hl7.fhir.r5.model.Encounter.ClassHistoryComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Encounter.ClassHistoryComponent tgt = new org.hl7.fhir.r4.model.Encounter.ClassHistoryComponent();
        Element40_50.copyElement(src, tgt);
        if (src.hasClass_())
            tgt.setClass_(Coding40_50.convertCoding(src.getClass_()));
        if (src.hasPeriod())
            tgt.setPeriod(Period40_50.convertPeriod(src.getPeriod()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Encounter.EncounterParticipantComponent convertEncounterParticipantComponent(org.hl7.fhir.r4.model.Encounter.EncounterParticipantComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Encounter.EncounterParticipantComponent tgt = new org.hl7.fhir.r5.model.Encounter.EncounterParticipantComponent();
        Element40_50.copyElement(src, tgt);
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getType()) tgt.addType(CodeableConcept40_50.convertCodeableConcept(t));
        if (src.hasPeriod())
            tgt.setPeriod(Period40_50.convertPeriod(src.getPeriod()));
        if (src.hasIndividual())
            tgt.setIndividual(Reference40_50.convertReference(src.getIndividual()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Encounter.EncounterParticipantComponent convertEncounterParticipantComponent(org.hl7.fhir.r5.model.Encounter.EncounterParticipantComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Encounter.EncounterParticipantComponent tgt = new org.hl7.fhir.r4.model.Encounter.EncounterParticipantComponent();
        Element40_50.copyElement(src, tgt);
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getType()) tgt.addType(CodeableConcept40_50.convertCodeableConcept(t));
        if (src.hasPeriod())
            tgt.setPeriod(Period40_50.convertPeriod(src.getPeriod()));
        if (src.hasIndividual())
            tgt.setIndividual(Reference40_50.convertReference(src.getIndividual()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Encounter.DiagnosisComponent convertDiagnosisComponent(org.hl7.fhir.r4.model.Encounter.DiagnosisComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Encounter.DiagnosisComponent tgt = new org.hl7.fhir.r5.model.Encounter.DiagnosisComponent();
        Element40_50.copyElement(src, tgt);
        if (src.hasCondition())
            tgt.setCondition(Reference40_50.convertReference(src.getCondition()));
        if (src.hasUse())
            tgt.setUse(CodeableConcept40_50.convertCodeableConcept(src.getUse()));
        if (src.hasRank())
            tgt.setRankElement(PositiveInt40_50.convertPositiveInt(src.getRankElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Encounter.DiagnosisComponent convertDiagnosisComponent(org.hl7.fhir.r5.model.Encounter.DiagnosisComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Encounter.DiagnosisComponent tgt = new org.hl7.fhir.r4.model.Encounter.DiagnosisComponent();
        Element40_50.copyElement(src, tgt);
        if (src.hasCondition())
            tgt.setCondition(Reference40_50.convertReference(src.getCondition()));
        if (src.hasUse())
            tgt.setUse(CodeableConcept40_50.convertCodeableConcept(src.getUse()));
        if (src.hasRank())
            tgt.setRankElement(PositiveInt40_50.convertPositiveInt(src.getRankElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Encounter.EncounterHospitalizationComponent convertEncounterHospitalizationComponent(org.hl7.fhir.r4.model.Encounter.EncounterHospitalizationComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Encounter.EncounterHospitalizationComponent tgt = new org.hl7.fhir.r5.model.Encounter.EncounterHospitalizationComponent();
        Element40_50.copyElement(src, tgt);
        if (src.hasPreAdmissionIdentifier())
            tgt.setPreAdmissionIdentifier(Identifier40_50.convertIdentifier(src.getPreAdmissionIdentifier()));
        if (src.hasOrigin())
            tgt.setOrigin(Reference40_50.convertReference(src.getOrigin()));
        if (src.hasAdmitSource())
            tgt.setAdmitSource(CodeableConcept40_50.convertCodeableConcept(src.getAdmitSource()));
        if (src.hasReAdmission())
            tgt.setReAdmission(CodeableConcept40_50.convertCodeableConcept(src.getReAdmission()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getDietPreference()) tgt.addDietPreference(CodeableConcept40_50.convertCodeableConcept(t));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getSpecialCourtesy()) tgt.addSpecialCourtesy(CodeableConcept40_50.convertCodeableConcept(t));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getSpecialArrangement()) tgt.addSpecialArrangement(CodeableConcept40_50.convertCodeableConcept(t));
        if (src.hasDestination())
            tgt.setDestination(Reference40_50.convertReference(src.getDestination()));
        if (src.hasDischargeDisposition())
            tgt.setDischargeDisposition(CodeableConcept40_50.convertCodeableConcept(src.getDischargeDisposition()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Encounter.EncounterHospitalizationComponent convertEncounterHospitalizationComponent(org.hl7.fhir.r5.model.Encounter.EncounterHospitalizationComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Encounter.EncounterHospitalizationComponent tgt = new org.hl7.fhir.r4.model.Encounter.EncounterHospitalizationComponent();
        Element40_50.copyElement(src, tgt);
        if (src.hasPreAdmissionIdentifier())
            tgt.setPreAdmissionIdentifier(Identifier40_50.convertIdentifier(src.getPreAdmissionIdentifier()));
        if (src.hasOrigin())
            tgt.setOrigin(Reference40_50.convertReference(src.getOrigin()));
        if (src.hasAdmitSource())
            tgt.setAdmitSource(CodeableConcept40_50.convertCodeableConcept(src.getAdmitSource()));
        if (src.hasReAdmission())
            tgt.setReAdmission(CodeableConcept40_50.convertCodeableConcept(src.getReAdmission()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getDietPreference()) tgt.addDietPreference(CodeableConcept40_50.convertCodeableConcept(t));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getSpecialCourtesy()) tgt.addSpecialCourtesy(CodeableConcept40_50.convertCodeableConcept(t));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getSpecialArrangement()) tgt.addSpecialArrangement(CodeableConcept40_50.convertCodeableConcept(t));
        if (src.hasDestination())
            tgt.setDestination(Reference40_50.convertReference(src.getDestination()));
        if (src.hasDischargeDisposition())
            tgt.setDischargeDisposition(CodeableConcept40_50.convertCodeableConcept(src.getDischargeDisposition()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Encounter.EncounterLocationComponent convertEncounterLocationComponent(org.hl7.fhir.r4.model.Encounter.EncounterLocationComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Encounter.EncounterLocationComponent tgt = new org.hl7.fhir.r5.model.Encounter.EncounterLocationComponent();
        Element40_50.copyElement(src, tgt);
        if (src.hasLocation())
            tgt.setLocation(Reference40_50.convertReference(src.getLocation()));
        if (src.hasStatus())
            tgt.setStatusElement(convertEncounterLocationStatus(src.getStatusElement()));
        if (src.hasPhysicalType())
            tgt.setPhysicalType(CodeableConcept40_50.convertCodeableConcept(src.getPhysicalType()));
        if (src.hasPeriod())
            tgt.setPeriod(Period40_50.convertPeriod(src.getPeriod()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Encounter.EncounterLocationComponent convertEncounterLocationComponent(org.hl7.fhir.r5.model.Encounter.EncounterLocationComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Encounter.EncounterLocationComponent tgt = new org.hl7.fhir.r4.model.Encounter.EncounterLocationComponent();
        Element40_50.copyElement(src, tgt);
        if (src.hasLocation())
            tgt.setLocation(Reference40_50.convertReference(src.getLocation()));
        if (src.hasStatus())
            tgt.setStatusElement(convertEncounterLocationStatus(src.getStatusElement()));
        if (src.hasPhysicalType())
            tgt.setPhysicalType(CodeableConcept40_50.convertCodeableConcept(src.getPhysicalType()));
        if (src.hasPeriod())
            tgt.setPeriod(Period40_50.convertPeriod(src.getPeriod()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Encounter.EncounterLocationStatus> convertEncounterLocationStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Encounter.EncounterLocationStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Encounter.EncounterLocationStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Encounter.EncounterLocationStatusEnumFactory());
        Element40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case PLANNED:
                tgt.setValue(org.hl7.fhir.r5.model.Encounter.EncounterLocationStatus.PLANNED);
                break;
            case ACTIVE:
                tgt.setValue(org.hl7.fhir.r5.model.Encounter.EncounterLocationStatus.ACTIVE);
                break;
            case RESERVED:
                tgt.setValue(org.hl7.fhir.r5.model.Encounter.EncounterLocationStatus.RESERVED);
                break;
            case COMPLETED:
                tgt.setValue(org.hl7.fhir.r5.model.Encounter.EncounterLocationStatus.COMPLETED);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Encounter.EncounterLocationStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Encounter.EncounterLocationStatus> convertEncounterLocationStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Encounter.EncounterLocationStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Encounter.EncounterLocationStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Encounter.EncounterLocationStatusEnumFactory());
        Element40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case PLANNED:
                tgt.setValue(org.hl7.fhir.r4.model.Encounter.EncounterLocationStatus.PLANNED);
                break;
            case ACTIVE:
                tgt.setValue(org.hl7.fhir.r4.model.Encounter.EncounterLocationStatus.ACTIVE);
                break;
            case RESERVED:
                tgt.setValue(org.hl7.fhir.r4.model.Encounter.EncounterLocationStatus.RESERVED);
                break;
            case COMPLETED:
                tgt.setValue(org.hl7.fhir.r4.model.Encounter.EncounterLocationStatus.COMPLETED);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.Encounter.EncounterLocationStatus.NULL);
                break;
        }
        return tgt;
    }
}