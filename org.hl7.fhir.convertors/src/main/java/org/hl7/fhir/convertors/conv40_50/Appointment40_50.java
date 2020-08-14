package org.hl7.fhir.convertors.conv40_50;


import org.hl7.fhir.convertors.VersionConvertor_40_50;
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
public class Appointment40_50 extends VersionConvertor_40_50 {

    public static org.hl7.fhir.r5.model.Appointment convertAppointment(org.hl7.fhir.r4.model.Appointment src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Appointment tgt = new org.hl7.fhir.r5.model.Appointment();
        copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        if (src.hasStatus())
            tgt.setStatusElement(convertAppointmentStatus(src.getStatusElement()));
        if (src.hasCancelationReason())
            tgt.setCancelationReason(convertCodeableConcept(src.getCancelationReason()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getServiceCategory()) tgt.addServiceCategory(convertCodeableConcept(t));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getServiceType()) tgt.addServiceType(convertCodeableConcept(t));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getSpecialty()) tgt.addSpecialty(convertCodeableConcept(t));
        if (src.hasAppointmentType())
            tgt.setAppointmentType(convertCodeableConcept(src.getAppointmentType()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReasonCode()) tgt.addReason(convertCodeableConceptToCodeableReference(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getReasonReference()) tgt.addReason(convertReferenceToCodeableReference(t));
        if (src.hasPriority())
            tgt.setPriorityElement(convertUnsignedInt(src.getPriorityElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        for (org.hl7.fhir.r4.model.Reference t : src.getSupportingInformation()) tgt.addSupportingInformation(convertReference(t));
        if (src.hasStart())
            tgt.setStartElement(convertInstant(src.getStartElement()));
        if (src.hasEnd())
            tgt.setEndElement(convertInstant(src.getEndElement()));
        if (src.hasMinutesDuration())
            tgt.setMinutesDurationElement(convertPositiveInt(src.getMinutesDurationElement()));
        for (org.hl7.fhir.r4.model.Reference t : src.getSlot()) tgt.addSlot(convertReference(t));
        if (src.hasCreated())
            tgt.setCreatedElement(convertDateTime(src.getCreatedElement()));
        if (src.hasComment())
            tgt.setCommentElement(convertString(src.getCommentElement()));
        if (src.hasPatientInstruction())
            tgt.setPatientInstructionElement(convertString(src.getPatientInstructionElement()));
        for (org.hl7.fhir.r4.model.Reference t : src.getBasedOn()) tgt.addBasedOn(convertReference(t));
        for (org.hl7.fhir.r4.model.Appointment.AppointmentParticipantComponent t : src.getParticipant()) tgt.addParticipant(convertAppointmentParticipantComponent(t));
        for (org.hl7.fhir.r4.model.Period t : src.getRequestedPeriod()) tgt.addRequestedPeriod(convertPeriod(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Appointment convertAppointment(org.hl7.fhir.r5.model.Appointment src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Appointment tgt = new org.hl7.fhir.r4.model.Appointment();
        copyDomainResource(src, tgt);
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        if (src.hasStatus())
            tgt.setStatusElement(convertAppointmentStatus(src.getStatusElement()));
        if (src.hasCancelationReason())
            tgt.setCancelationReason(convertCodeableConcept(src.getCancelationReason()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getServiceCategory()) tgt.addServiceCategory(convertCodeableConcept(t));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getServiceType()) tgt.addServiceType(convertCodeableConcept(t));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getSpecialty()) tgt.addSpecialty(convertCodeableConcept(t));
        if (src.hasAppointmentType())
            tgt.setAppointmentType(convertCodeableConcept(src.getAppointmentType()));
        for (CodeableReference t : src.getReason()) if (t.hasConcept())
            tgt.addReasonCode(convertCodeableConcept(t.getConcept()));
        for (CodeableReference t : src.getReason()) if (t.hasReference())
            tgt.addReasonReference(convertReference(t.getReference()));
        if (src.hasPriority())
            tgt.setPriorityElement(convertUnsignedInt(src.getPriorityElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        for (org.hl7.fhir.r5.model.Reference t : src.getSupportingInformation()) tgt.addSupportingInformation(convertReference(t));
        if (src.hasStart())
            tgt.setStartElement(convertInstant(src.getStartElement()));
        if (src.hasEnd())
            tgt.setEndElement(convertInstant(src.getEndElement()));
        if (src.hasMinutesDuration())
            tgt.setMinutesDurationElement(convertPositiveInt(src.getMinutesDurationElement()));
        for (org.hl7.fhir.r5.model.Reference t : src.getSlot()) tgt.addSlot(convertReference(t));
        if (src.hasCreated())
            tgt.setCreatedElement(convertDateTime(src.getCreatedElement()));
        if (src.hasComment())
            tgt.setCommentElement(convertString(src.getCommentElement()));
        if (src.hasPatientInstruction())
            tgt.setPatientInstructionElement(convertString(src.getPatientInstructionElement()));
        for (org.hl7.fhir.r5.model.Reference t : src.getBasedOn()) tgt.addBasedOn(convertReference(t));
        for (org.hl7.fhir.r5.model.Appointment.AppointmentParticipantComponent t : src.getParticipant()) tgt.addParticipant(convertAppointmentParticipantComponent(t));
        for (org.hl7.fhir.r5.model.Period t : src.getRequestedPeriod()) tgt.addRequestedPeriod(convertPeriod(t));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Appointment.AppointmentStatus> convertAppointmentStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Appointment.AppointmentStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Appointment.AppointmentStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Appointment.AppointmentStatusEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case PROPOSED:
                tgt.setValue(org.hl7.fhir.r5.model.Appointment.AppointmentStatus.PROPOSED);
                break;
            case PENDING:
                tgt.setValue(org.hl7.fhir.r5.model.Appointment.AppointmentStatus.PENDING);
                break;
            case BOOKED:
                tgt.setValue(org.hl7.fhir.r5.model.Appointment.AppointmentStatus.BOOKED);
                break;
            case ARRIVED:
                tgt.setValue(org.hl7.fhir.r5.model.Appointment.AppointmentStatus.ARRIVED);
                break;
            case FULFILLED:
                tgt.setValue(org.hl7.fhir.r5.model.Appointment.AppointmentStatus.FULFILLED);
                break;
            case CANCELLED:
                tgt.setValue(org.hl7.fhir.r5.model.Appointment.AppointmentStatus.CANCELLED);
                break;
            case NOSHOW:
                tgt.setValue(org.hl7.fhir.r5.model.Appointment.AppointmentStatus.NOSHOW);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.r5.model.Appointment.AppointmentStatus.ENTEREDINERROR);
                break;
            case CHECKEDIN:
                tgt.setValue(org.hl7.fhir.r5.model.Appointment.AppointmentStatus.CHECKEDIN);
                break;
            case WAITLIST:
                tgt.setValue(org.hl7.fhir.r5.model.Appointment.AppointmentStatus.WAITLIST);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Appointment.AppointmentStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Appointment.AppointmentStatus> convertAppointmentStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Appointment.AppointmentStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Appointment.AppointmentStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Appointment.AppointmentStatusEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case PROPOSED:
                tgt.setValue(org.hl7.fhir.r4.model.Appointment.AppointmentStatus.PROPOSED);
                break;
            case PENDING:
                tgt.setValue(org.hl7.fhir.r4.model.Appointment.AppointmentStatus.PENDING);
                break;
            case BOOKED:
                tgt.setValue(org.hl7.fhir.r4.model.Appointment.AppointmentStatus.BOOKED);
                break;
            case ARRIVED:
                tgt.setValue(org.hl7.fhir.r4.model.Appointment.AppointmentStatus.ARRIVED);
                break;
            case FULFILLED:
                tgt.setValue(org.hl7.fhir.r4.model.Appointment.AppointmentStatus.FULFILLED);
                break;
            case CANCELLED:
                tgt.setValue(org.hl7.fhir.r4.model.Appointment.AppointmentStatus.CANCELLED);
                break;
            case NOSHOW:
                tgt.setValue(org.hl7.fhir.r4.model.Appointment.AppointmentStatus.NOSHOW);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.r4.model.Appointment.AppointmentStatus.ENTEREDINERROR);
                break;
            case CHECKEDIN:
                tgt.setValue(org.hl7.fhir.r4.model.Appointment.AppointmentStatus.CHECKEDIN);
                break;
            case WAITLIST:
                tgt.setValue(org.hl7.fhir.r4.model.Appointment.AppointmentStatus.WAITLIST);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.Appointment.AppointmentStatus.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Appointment.AppointmentParticipantComponent convertAppointmentParticipantComponent(org.hl7.fhir.r4.model.Appointment.AppointmentParticipantComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Appointment.AppointmentParticipantComponent tgt = new org.hl7.fhir.r5.model.Appointment.AppointmentParticipantComponent();
        copyElement(src, tgt);
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getType()) tgt.addType(convertCodeableConcept(t));
        if (src.hasActor())
            tgt.setActor(convertReference(src.getActor()));
        if (src.hasRequired())
            tgt.setRequiredElement(convertParticipantRequired(src.getRequiredElement()));
        if (src.hasStatus())
            tgt.setStatusElement(convertParticipationStatus(src.getStatusElement()));
        if (src.hasPeriod())
            tgt.setPeriod(convertPeriod(src.getPeriod()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Appointment.AppointmentParticipantComponent convertAppointmentParticipantComponent(org.hl7.fhir.r5.model.Appointment.AppointmentParticipantComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Appointment.AppointmentParticipantComponent tgt = new org.hl7.fhir.r4.model.Appointment.AppointmentParticipantComponent();
        copyElement(src, tgt);
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getType()) tgt.addType(convertCodeableConcept(t));
        if (src.hasActor())
            tgt.setActor(convertReference(src.getActor()));
        if (src.hasRequired())
            tgt.setRequiredElement(convertParticipantRequired(src.getRequiredElement()));
        if (src.hasStatus())
            tgt.setStatusElement(convertParticipationStatus(src.getStatusElement()));
        if (src.hasPeriod())
            tgt.setPeriod(convertPeriod(src.getPeriod()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Appointment.ParticipantRequired> convertParticipantRequired(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Appointment.ParticipantRequired> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Appointment.ParticipantRequired> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Appointment.ParticipantRequiredEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case REQUIRED:
                tgt.setValue(org.hl7.fhir.r5.model.Appointment.ParticipantRequired.REQUIRED);
                break;
            case OPTIONAL:
                tgt.setValue(org.hl7.fhir.r5.model.Appointment.ParticipantRequired.OPTIONAL);
                break;
            case INFORMATIONONLY:
                tgt.setValue(org.hl7.fhir.r5.model.Appointment.ParticipantRequired.INFORMATIONONLY);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Appointment.ParticipantRequired.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Appointment.ParticipantRequired> convertParticipantRequired(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Appointment.ParticipantRequired> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Appointment.ParticipantRequired> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Appointment.ParticipantRequiredEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case REQUIRED:
                tgt.setValue(org.hl7.fhir.r4.model.Appointment.ParticipantRequired.REQUIRED);
                break;
            case OPTIONAL:
                tgt.setValue(org.hl7.fhir.r4.model.Appointment.ParticipantRequired.OPTIONAL);
                break;
            case INFORMATIONONLY:
                tgt.setValue(org.hl7.fhir.r4.model.Appointment.ParticipantRequired.INFORMATIONONLY);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.Appointment.ParticipantRequired.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ParticipationStatus> convertParticipationStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Appointment.ParticipationStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ParticipationStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.ParticipationStatusEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case ACCEPTED:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ParticipationStatus.ACCEPTED);
                break;
            case DECLINED:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ParticipationStatus.DECLINED);
                break;
            case TENTATIVE:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ParticipationStatus.TENTATIVE);
                break;
            case NEEDSACTION:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ParticipationStatus.NEEDSACTION);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ParticipationStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Appointment.ParticipationStatus> convertParticipationStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ParticipationStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Appointment.ParticipationStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Appointment.ParticipationStatusEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case ACCEPTED:
                tgt.setValue(org.hl7.fhir.r4.model.Appointment.ParticipationStatus.ACCEPTED);
                break;
            case DECLINED:
                tgt.setValue(org.hl7.fhir.r4.model.Appointment.ParticipationStatus.DECLINED);
                break;
            case TENTATIVE:
                tgt.setValue(org.hl7.fhir.r4.model.Appointment.ParticipationStatus.TENTATIVE);
                break;
            case NEEDSACTION:
                tgt.setValue(org.hl7.fhir.r4.model.Appointment.ParticipationStatus.NEEDSACTION);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.Appointment.ParticipationStatus.NULL);
                break;
        }
        return tgt;
    }
}