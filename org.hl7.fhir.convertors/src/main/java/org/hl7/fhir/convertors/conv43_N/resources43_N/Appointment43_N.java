package org.hl7.fhir.convertors.conv43_N.resources43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.CodeableConcept43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Identifier43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Period43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.DateTime43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Instant43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.MarkDown43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.PositiveInt43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.String43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.special43_N.Reference43_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4b.model.UnsignedIntType;
import org.hl7.fhir.model.core.*;

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

public class Appointment43_N {

  public static org.hl7.fhir.model.core.Appointment convertAppointment(org.hl7.fhir.r4b.model.Appointment src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Appointment tgt = new org.hl7.fhir.model.core.Appointment();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertAppointmentStatus(src.getStatusElement()));
    if (src.hasCancelationReason())
      tgt.setCancellationReason(CodeableConcept43_N.convertCodeableConcept(src.getCancelationReason()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getServiceCategory())
      tgt.addServiceCategory(CodeableConcept43_N.convertCodeableConcept(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getServiceType())
      tgt.addServiceType().setConcept(CodeableConcept43_N.convertCodeableConcept(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getSpecialty())
      tgt.addSpecialty(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasAppointmentType())
      tgt.setAppointmentType(CodeableConcept43_N.convertCodeableConcept(src.getAppointmentType()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getReasonCode())
      tgt.addReason(CodeableConcept43_N.convertCodeableConceptToCodeableReference(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getReasonReference())
      tgt.addReason(Reference43_N.convertReferenceToCodeableReference(t));
    if (src.hasPriority())
      tgt.setPriority(convertAppointmentPriority(src.getPriorityElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_N.convertString(src.getDescriptionElement()));
    for (org.hl7.fhir.r4b.model.Reference t : src.getSupportingInformation())
      tgt.addSupportingInformation(Reference43_N.convertReference(t));
    if (src.hasStart())
      tgt.setStartElement(Instant43_N.convertInstant(src.getStartElement()));
    if (src.hasEnd())
      tgt.setEndElement(Instant43_N.convertInstant(src.getEndElement()));
    if (src.hasMinutesDuration())
      tgt.setMinutesDurationElement(PositiveInt43_N.convertPositiveInt(src.getMinutesDurationElement()));
    for (org.hl7.fhir.r4b.model.Reference t : src.getSlot()) tgt.addSlot(Reference43_N.convertReference(t));
    if (src.hasCreated())
      tgt.setCreatedElement(DateTime43_N.convertDateTime(src.getCreatedElement()));
    if (src.hasComment())
      tgt.getNoteFirstRep().setTextElement(MarkDown43_N.convertStringToMarkdown(src.getCommentElement()));
//    if (src.hasPatientInstruction())
//      tgt.setPatientInstructionElement(String43_N.convertString(src.getPatientInstructionElement()));
    for (org.hl7.fhir.r4b.model.Reference t : src.getBasedOn()) tgt.addBasedOn(Reference43_N.convertReference(t));
    for (org.hl7.fhir.r4b.model.Appointment.AppointmentParticipantComponent t : src.getParticipant())
      tgt.addParticipant(convertAppointmentParticipantComponent(t));
    for (org.hl7.fhir.r4b.model.Period t : src.getRequestedPeriod())
      tgt.addRequestedPeriod(Period43_N.convertPeriod(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Appointment convertAppointment(org.hl7.fhir.model.core.Appointment src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Appointment tgt = new org.hl7.fhir.r4b.model.Appointment();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertAppointmentStatus(src.getStatusElement()));
    if (src.hasCancellationReason())
      tgt.setCancelationReason(CodeableConcept43_N.convertCodeableConcept(src.getCancellationReason()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getServiceCategoryList())
      tgt.addServiceCategory(CodeableConcept43_N.convertCodeableConcept(t));
    for (org.hl7.fhir.model.core.CodeableReference t : src.getServiceTypeList())
      tgt.addServiceType(CodeableConcept43_N.convertCodeableConcept(t.getConcept()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getSpecialtyList())
      tgt.addSpecialty(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasAppointmentType())
      tgt.setAppointmentType(CodeableConcept43_N.convertCodeableConcept(src.getAppointmentType()));
    for (CodeableReference t : src.getReasonList())
      if (t.hasConcept())
        tgt.addReasonCode(CodeableConcept43_N.convertCodeableConcept(t.getConcept()));
    for (CodeableReference t : src.getReasonList())
      if (t.hasReference())
        tgt.addReasonReference(Reference43_N.convertReference(t.getReference()));
    if (src.hasPriority())
      tgt.setPriorityElement(convertAppointmentPriority(src.getPriority()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_N.convertString(src.getDescriptionElement()));
    for (org.hl7.fhir.model.core.Reference t : src.getSupportingInformationList())
      tgt.addSupportingInformation(Reference43_N.convertReference(t));
    if (src.hasStart())
      tgt.setStartElement(Instant43_N.convertInstant(src.getStartElement()));
    if (src.hasEnd())
      tgt.setEndElement(Instant43_N.convertInstant(src.getEndElement()));
    if (src.hasMinutesDuration())
      tgt.setMinutesDurationElement(PositiveInt43_N.convertPositiveInt(src.getMinutesDurationElement()));
    for (org.hl7.fhir.model.core.Reference t : src.getSlotList()) tgt.addSlot(Reference43_N.convertReference(t));
    if (src.hasCreated())
      tgt.setCreatedElement(DateTime43_N.convertDateTime(src.getCreatedElement()));
    if (src.hasNote())
      tgt.setCommentElement(String43_N.convertString(src.getNoteFirstRep().getTextElement()));
//    if (src.hasPatientInstruction())
//      tgt.setPatientInstructionElement(String43_N.convertString(src.getPatientInstructionElement()));
    for (org.hl7.fhir.model.core.Reference t : src.getBasedOnList()) tgt.addBasedOn(Reference43_N.convertReference(t));
    for (org.hl7.fhir.model.core.Appointment.AppointmentParticipantComponent t : src.getParticipantList())
      tgt.addParticipant(convertAppointmentParticipantComponent(t));
    for (org.hl7.fhir.model.core.Period t : src.getRequestedPeriodList())
      tgt.addRequestedPeriod(Period43_N.convertPeriod(t));
    return tgt;
  }


  private static UnsignedIntType convertAppointmentPriority(CodeableConcept src) {
    UnsignedIntType tgt = new UnsignedIntType(convertAppointmentPriorityFromR5(src));
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    return tgt;
  }

  private static CodeableConcept convertAppointmentPriority(UnsignedIntType src) {
    CodeableConcept tgt = src.hasValue() ? convertAppointmentPriorityToR5(src.getValue()) : new CodeableConcept();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.model.core.CodeableConcept convertAppointmentPriorityToR5(int priority) {
    return null;
  }

  public static int convertAppointmentPriorityFromR5(org.hl7.fhir.model.core.CodeableConcept priority) {
    return 0;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Appointment.AppointmentStatus> convertAppointmentStatus(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Appointment.AppointmentStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Appointment.AppointmentStatus> tgt = new Enumeration<>(new Appointment.AppointmentStatusEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case PROPOSED:
                  tgt.setValue(Appointment.AppointmentStatus.PROPOSED);
                  break;
              case PENDING:
                  tgt.setValue(Appointment.AppointmentStatus.PENDING);
                  break;
              case BOOKED:
                  tgt.setValue(Appointment.AppointmentStatus.BOOKED);
                  break;
              case ARRIVED:
                  tgt.setValue(Appointment.AppointmentStatus.ARRIVED);
                  break;
              case FULFILLED:
                  tgt.setValue(Appointment.AppointmentStatus.FULFILLED);
                  break;
              case CANCELLED:
                  tgt.setValue(Appointment.AppointmentStatus.CANCELLED);
                  break;
              case NOSHOW:
                  tgt.setValue(Appointment.AppointmentStatus.NOSHOW);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(Appointment.AppointmentStatus.ENTEREDINERROR);
                  break;
              case CHECKEDIN:
                  tgt.setValue(Appointment.AppointmentStatus.CHECKEDIN);
                  break;
              case WAITLIST:
                  tgt.setValue(Appointment.AppointmentStatus.WAITLIST);
                  break;
              default:
                  tgt.setValue(Appointment.AppointmentStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Appointment.AppointmentStatus> convertAppointmentStatus(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Appointment.AppointmentStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Appointment.AppointmentStatus> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Appointment.AppointmentStatusEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
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
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.Appointment.AppointmentParticipantComponent convertAppointmentParticipantComponent(org.hl7.fhir.r4b.model.Appointment.AppointmentParticipantComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Appointment.AppointmentParticipantComponent tgt = new org.hl7.fhir.model.core.Appointment.AppointmentParticipantComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getType())
      tgt.addType(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasActor())
      tgt.setActor(Reference43_N.convertReference(src.getActor()));
    if (src.hasRequired())
      tgt.setRequiredElement(convertParticipantRequired(src.getRequiredElement()));
    if (src.hasStatus())
      tgt.setStatusElement(convertParticipationStatus(src.getStatusElement()));
    if (src.hasPeriod())
      tgt.setPeriod(Period43_N.convertPeriod(src.getPeriod()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Appointment.AppointmentParticipantComponent convertAppointmentParticipantComponent(org.hl7.fhir.model.core.Appointment.AppointmentParticipantComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Appointment.AppointmentParticipantComponent tgt = new org.hl7.fhir.r4b.model.Appointment.AppointmentParticipantComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getTypeList())
      tgt.addType(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasActor())
      tgt.setActor(Reference43_N.convertReference(src.getActor()));
    if (src.hasRequired())
      tgt.setRequiredElement(convertParticipantRequired(src.getRequiredElement()));
    if (src.hasStatus())
      tgt.setStatusElement(convertParticipationStatus(src.getStatusElement()));
    if (src.hasPeriod())
      tgt.setPeriod(Period43_N.convertPeriod(src.getPeriod()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.BooleanType convertParticipantRequired(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Appointment.ParticipantRequired> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      BooleanType tgt = new BooleanType();
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
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
      }
      return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Appointment.ParticipantRequired> convertParticipantRequired(org.hl7.fhir.model.core.BooleanType src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Appointment.ParticipantRequired> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Appointment.ParticipantRequiredEnumFactory());
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
    if (src.getValue()) { // case REQUIRED:
      tgt.setValue(org.hl7.fhir.r4b.model.Appointment.ParticipantRequired.REQUIRED);
    } else { // case OPTIONAL + others:
      tgt.setValue(org.hl7.fhir.r4b.model.Appointment.ParticipantRequired.OPTIONAL);
    }
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Appointment.ParticipationStatus> convertParticipationStatus(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.ParticipationStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Appointment.ParticipationStatus> tgt = new Enumeration<>(new Appointment.ParticipationStatusEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case ACCEPTED:
                  tgt.setValue(Appointment.ParticipationStatus.ACCEPTED);
                  break;
              case DECLINED:
                  tgt.setValue(Appointment.ParticipationStatus.DECLINED);
                  break;
              case TENTATIVE:
                  tgt.setValue(Appointment.ParticipationStatus.TENTATIVE);
                  break;
              case NEEDSACTION:
                  tgt.setValue(Appointment.ParticipationStatus.NEEDSACTION);
                  break;
              default:
                  tgt.setValue(Appointment.ParticipationStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.ParticipationStatus> convertParticipationStatus(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Appointment.ParticipationStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.ParticipationStatus> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.ParticipationStatusEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
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
      }
      return tgt;
  }
}