package org.hl7.fhir.convertors.conv43_50.resources43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.CodeableConcept43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Identifier43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Period43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.DateTime43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Instant43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.MarkDown43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.PositiveInt43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.String43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.special43_50.Reference43_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4b.model.UnsignedIntType;
import org.hl7.fhir.r5.model.CodeableConcept;
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
public class Appointment43_50 {

  public static org.hl7.fhir.r5.model.Appointment convertAppointment(org.hl7.fhir.r4b.model.Appointment src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Appointment tgt = new org.hl7.fhir.r5.model.Appointment();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertAppointmentStatus(src.getStatusElement()));
    if (src.hasCancelationReason())
      tgt.setCancellationReason(CodeableConcept43_50.convertCodeableConcept(src.getCancelationReason()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getServiceCategory())
      tgt.addServiceCategory(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getServiceType())
      tgt.addServiceType().setConcept(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getSpecialty())
      tgt.addSpecialty(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasAppointmentType())
      tgt.setAppointmentType(CodeableConcept43_50.convertCodeableConcept(src.getAppointmentType()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getReasonCode())
      tgt.addReason(CodeableConcept43_50.convertCodeableConceptToCodeableReference(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getReasonReference())
      tgt.addReason(Reference43_50.convertReferenceToCodeableReference(t));
    if (src.hasPriority())
      tgt.setPriority(convertAppointmentPriority(src.getPriorityElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_50.convertString(src.getDescriptionElement()));
    for (org.hl7.fhir.r4b.model.Reference t : src.getSupportingInformation())
      tgt.addSupportingInformation(Reference43_50.convertReference(t));
    if (src.hasStart())
      tgt.setStartElement(Instant43_50.convertInstant(src.getStartElement()));
    if (src.hasEnd())
      tgt.setEndElement(Instant43_50.convertInstant(src.getEndElement()));
    if (src.hasMinutesDuration())
      tgt.setMinutesDurationElement(PositiveInt43_50.convertPositiveInt(src.getMinutesDurationElement()));
    for (org.hl7.fhir.r4b.model.Reference t : src.getSlot()) tgt.addSlot(Reference43_50.convertReference(t));
    if (src.hasCreated())
      tgt.setCreatedElement(DateTime43_50.convertDateTime(src.getCreatedElement()));
    if (src.hasComment())
      tgt.getNoteFirstRep().setTextElement(MarkDown43_50.convertStringToMarkdown(src.getCommentElement()));
//    if (src.hasPatientInstruction())
//      tgt.setPatientInstructionElement(String43_50.convertString(src.getPatientInstructionElement()));
    for (org.hl7.fhir.r4b.model.Reference t : src.getBasedOn()) tgt.addBasedOn(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r4b.model.Appointment.AppointmentParticipantComponent t : src.getParticipant())
      tgt.addParticipant(convertAppointmentParticipantComponent(t));
    for (org.hl7.fhir.r4b.model.Period t : src.getRequestedPeriod())
      tgt.addRequestedPeriod(Period43_50.convertPeriod(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Appointment convertAppointment(org.hl7.fhir.r5.model.Appointment src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Appointment tgt = new org.hl7.fhir.r4b.model.Appointment();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertAppointmentStatus(src.getStatusElement()));
    if (src.hasCancellationReason())
      tgt.setCancelationReason(CodeableConcept43_50.convertCodeableConcept(src.getCancellationReason()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getServiceCategory())
      tgt.addServiceCategory(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.CodeableReference t : src.getServiceType())
      tgt.addServiceType(CodeableConcept43_50.convertCodeableConcept(t.getConcept()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getSpecialty())
      tgt.addSpecialty(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasAppointmentType())
      tgt.setAppointmentType(CodeableConcept43_50.convertCodeableConcept(src.getAppointmentType()));
    for (CodeableReference t : src.getReason())
      if (t.hasConcept())
        tgt.addReasonCode(CodeableConcept43_50.convertCodeableConcept(t.getConcept()));
    for (CodeableReference t : src.getReason())
      if (t.hasReference())
        tgt.addReasonReference(Reference43_50.convertReference(t.getReference()));
    if (src.hasPriority())
      tgt.setPriorityElement(convertAppointmentPriority(src.getPriority()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_50.convertString(src.getDescriptionElement()));
    for (org.hl7.fhir.r5.model.Reference t : src.getSupportingInformation())
      tgt.addSupportingInformation(Reference43_50.convertReference(t));
    if (src.hasStart())
      tgt.setStartElement(Instant43_50.convertInstant(src.getStartElement()));
    if (src.hasEnd())
      tgt.setEndElement(Instant43_50.convertInstant(src.getEndElement()));
    if (src.hasMinutesDuration())
      tgt.setMinutesDurationElement(PositiveInt43_50.convertPositiveInt(src.getMinutesDurationElement()));
    for (org.hl7.fhir.r5.model.Reference t : src.getSlot()) tgt.addSlot(Reference43_50.convertReference(t));
    if (src.hasCreated())
      tgt.setCreatedElement(DateTime43_50.convertDateTime(src.getCreatedElement()));
    if (src.hasNote())
      tgt.setCommentElement(String43_50.convertString(src.getNoteFirstRep().getTextElement()));
//    if (src.hasPatientInstruction())
//      tgt.setPatientInstructionElement(String43_50.convertString(src.getPatientInstructionElement()));
    for (org.hl7.fhir.r5.model.Reference t : src.getBasedOn()) tgt.addBasedOn(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r5.model.Appointment.AppointmentParticipantComponent t : src.getParticipant())
      tgt.addParticipant(convertAppointmentParticipantComponent(t));
    for (org.hl7.fhir.r5.model.Period t : src.getRequestedPeriod())
      tgt.addRequestedPeriod(Period43_50.convertPeriod(t));
    return tgt;
  }


  private static UnsignedIntType convertAppointmentPriority(CodeableConcept src) {
    UnsignedIntType tgt = new UnsignedIntType(convertAppointmentPriorityFromR5(src));
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    return tgt;
  }

  private static CodeableConcept convertAppointmentPriority(UnsignedIntType src) {
    CodeableConcept tgt = src.hasValue() ? convertAppointmentPriorityToR5(src.getValue()) : new CodeableConcept();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r5.model.CodeableConcept convertAppointmentPriorityToR5(int priority) {
    return null;
  }

  public static int convertAppointmentPriorityFromR5(org.hl7.fhir.r5.model.CodeableConcept priority) {
    return 0;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Appointment.AppointmentStatus> convertAppointmentStatus(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Appointment.AppointmentStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Appointment.AppointmentStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Appointment.AppointmentStatusEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
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

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Appointment.AppointmentStatus> convertAppointmentStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Appointment.AppointmentStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Appointment.AppointmentStatus> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Appointment.AppointmentStatusEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case PROPOSED:
        tgt.setValue(org.hl7.fhir.r4b.model.Appointment.AppointmentStatus.PROPOSED);
        break;
      case PENDING:
        tgt.setValue(org.hl7.fhir.r4b.model.Appointment.AppointmentStatus.PENDING);
        break;
      case BOOKED:
        tgt.setValue(org.hl7.fhir.r4b.model.Appointment.AppointmentStatus.BOOKED);
        break;
      case ARRIVED:
        tgt.setValue(org.hl7.fhir.r4b.model.Appointment.AppointmentStatus.ARRIVED);
        break;
      case FULFILLED:
        tgt.setValue(org.hl7.fhir.r4b.model.Appointment.AppointmentStatus.FULFILLED);
        break;
      case CANCELLED:
        tgt.setValue(org.hl7.fhir.r4b.model.Appointment.AppointmentStatus.CANCELLED);
        break;
      case NOSHOW:
        tgt.setValue(org.hl7.fhir.r4b.model.Appointment.AppointmentStatus.NOSHOW);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r4b.model.Appointment.AppointmentStatus.ENTEREDINERROR);
        break;
      case CHECKEDIN:
        tgt.setValue(org.hl7.fhir.r4b.model.Appointment.AppointmentStatus.CHECKEDIN);
        break;
      case WAITLIST:
        tgt.setValue(org.hl7.fhir.r4b.model.Appointment.AppointmentStatus.WAITLIST);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.Appointment.AppointmentStatus.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Appointment.AppointmentParticipantComponent convertAppointmentParticipantComponent(org.hl7.fhir.r4b.model.Appointment.AppointmentParticipantComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Appointment.AppointmentParticipantComponent tgt = new org.hl7.fhir.r5.model.Appointment.AppointmentParticipantComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getType())
      tgt.addType(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasActor())
      tgt.setActor(Reference43_50.convertReference(src.getActor()));
    if (src.hasRequired())
      tgt.setRequiredElement(convertParticipantRequired(src.getRequiredElement()));
    if (src.hasStatus())
      tgt.setStatusElement(convertParticipationStatus(src.getStatusElement()));
    if (src.hasPeriod())
      tgt.setPeriod(Period43_50.convertPeriod(src.getPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Appointment.AppointmentParticipantComponent convertAppointmentParticipantComponent(org.hl7.fhir.r5.model.Appointment.AppointmentParticipantComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Appointment.AppointmentParticipantComponent tgt = new org.hl7.fhir.r4b.model.Appointment.AppointmentParticipantComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getType())
      tgt.addType(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasActor())
      tgt.setActor(Reference43_50.convertReference(src.getActor()));
    if (src.hasRequired())
      tgt.setRequiredElement(convertParticipantRequired(src.getRequiredElement()));
    if (src.hasStatus())
      tgt.setStatusElement(convertParticipationStatus(src.getStatusElement()));
    if (src.hasPeriod())
      tgt.setPeriod(Period43_50.convertPeriod(src.getPeriod()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.BooleanType convertParticipantRequired(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Appointment.ParticipantRequired> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.BooleanType tgt = new org.hl7.fhir.r5.model.BooleanType();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case REQUIRED:
        tgt.setValue(true);
        break;
      case OPTIONAL:
        tgt.setValue(false);
        break;
      case INFORMATIONONLY:
        tgt.setValue(false);
        break;
      default:
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Appointment.ParticipantRequired> convertParticipantRequired(org.hl7.fhir.r5.model.BooleanType src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Appointment.ParticipantRequired> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Appointment.ParticipantRequiredEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    if (src.getValue()) { // case REQUIRED:
      tgt.setValue(org.hl7.fhir.r4b.model.Appointment.ParticipantRequired.REQUIRED);
    } else { // case OPTIONAL + others:
      tgt.setValue(org.hl7.fhir.r4b.model.Appointment.ParticipantRequired.OPTIONAL);
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ParticipationStatus> convertParticipationStatus(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.ParticipationStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ParticipationStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.ParticipationStatusEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
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

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.ParticipationStatus> convertParticipationStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ParticipationStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.ParticipationStatus> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.ParticipationStatusEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case ACCEPTED:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.ParticipationStatus.ACCEPTED);
        break;
      case DECLINED:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.ParticipationStatus.DECLINED);
        break;
      case TENTATIVE:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.ParticipationStatus.TENTATIVE);
        break;
      case NEEDSACTION:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.ParticipationStatus.NEEDSACTION);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.ParticipationStatus.NULL);
        break;
    }
    return tgt;
  }
}