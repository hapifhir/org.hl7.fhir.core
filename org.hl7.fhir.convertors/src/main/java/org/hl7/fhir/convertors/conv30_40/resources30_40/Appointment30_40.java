package org.hl7.fhir.convertors.conv30_40.resources30_40;

import org.hl7.fhir.convertors.context.ConversionContext30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Reference30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.CodeableConcept30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Identifier30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Period30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.*;
import org.hl7.fhir.exceptions.FHIRException;

public class Appointment30_40 {

  public static org.hl7.fhir.r4.model.Appointment convertAppointment(org.hl7.fhir.dstu3.model.Appointment src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Appointment tgt = new org.hl7.fhir.r4.model.Appointment();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_40.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertAppointmentStatus(src.getStatusElement()));
    if (src.hasServiceCategory())
      tgt.addServiceCategory(CodeableConcept30_40.convertCodeableConcept(src.getServiceCategory()));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getServiceType())
      tgt.addServiceType(CodeableConcept30_40.convertCodeableConcept(t));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getSpecialty())
      tgt.addSpecialty(CodeableConcept30_40.convertCodeableConcept(t));
    if (src.hasAppointmentType())
      tgt.setAppointmentType(CodeableConcept30_40.convertCodeableConcept(src.getAppointmentType()));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getReason())
      tgt.addReasonCode(CodeableConcept30_40.convertCodeableConcept(t));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getIndication())
      tgt.addReasonReference(Reference30_40.convertReference(t));
    if (src.hasPriority())
      tgt.setPriorityElement(UnsignedInt30_40.convertUnsignedInt(src.getPriorityElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String30_40.convertString(src.getDescriptionElement()));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getSupportingInformation())
      tgt.addSupportingInformation(Reference30_40.convertReference(t));
    if (src.hasStart())
      tgt.setStartElement(Instant30_40.convertInstant(src.getStartElement()));
    if (src.hasEnd())
      tgt.setEndElement(Instant30_40.convertInstant(src.getEndElement()));
    if (src.hasMinutesDuration())
      tgt.setMinutesDurationElement(PositiveInt30_40.convertPositiveInt(src.getMinutesDurationElement()));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getSlot()) tgt.addSlot(Reference30_40.convertReference(t));
    if (src.hasCreated())
      tgt.setCreatedElement(DateTime30_40.convertDateTime(src.getCreatedElement()));
    if (src.hasComment())
      tgt.setCommentElement(String30_40.convertString(src.getCommentElement()));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getIncomingReferral())
      tgt.addBasedOn(Reference30_40.convertReference(t));
    for (org.hl7.fhir.dstu3.model.Appointment.AppointmentParticipantComponent t : src.getParticipant())
      tgt.addParticipant(convertAppointmentParticipantComponent(t));
    for (org.hl7.fhir.dstu3.model.Period t : src.getRequestedPeriod())
      tgt.addRequestedPeriod(Period30_40.convertPeriod(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Appointment convertAppointment(org.hl7.fhir.r4.model.Appointment src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.Appointment tgt = new org.hl7.fhir.dstu3.model.Appointment();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_40.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertAppointmentStatus(src.getStatusElement()));
    if (src.hasServiceCategory())
      tgt.setServiceCategory(CodeableConcept30_40.convertCodeableConcept(src.getServiceCategoryFirstRep()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getServiceType())
      tgt.addServiceType(CodeableConcept30_40.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getSpecialty())
      tgt.addSpecialty(CodeableConcept30_40.convertCodeableConcept(t));
    if (src.hasAppointmentType())
      tgt.setAppointmentType(CodeableConcept30_40.convertCodeableConcept(src.getAppointmentType()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReasonCode())
      tgt.addReason(CodeableConcept30_40.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getReasonReference())
      tgt.addIndication(Reference30_40.convertReference(t));
    if (src.hasPriority())
      tgt.setPriorityElement(UnsignedInt30_40.convertUnsignedInt(src.getPriorityElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String30_40.convertString(src.getDescriptionElement()));
    for (org.hl7.fhir.r4.model.Reference t : src.getSupportingInformation())
      tgt.addSupportingInformation(Reference30_40.convertReference(t));
    if (src.hasStart())
      tgt.setStartElement(Instant30_40.convertInstant(src.getStartElement()));
    if (src.hasEnd())
      tgt.setEndElement(Instant30_40.convertInstant(src.getEndElement()));
    if (src.hasMinutesDuration())
      tgt.setMinutesDurationElement(PositiveInt30_40.convertPositiveInt(src.getMinutesDurationElement()));
    for (org.hl7.fhir.r4.model.Reference t : src.getSlot()) tgt.addSlot(Reference30_40.convertReference(t));
    if (src.hasCreated())
      tgt.setCreatedElement(DateTime30_40.convertDateTime(src.getCreatedElement()));
    if (src.hasComment())
      tgt.setCommentElement(String30_40.convertString(src.getCommentElement()));
    for (org.hl7.fhir.r4.model.Reference t : src.getBasedOn())
      tgt.addIncomingReferral(Reference30_40.convertReference(t));
    for (org.hl7.fhir.r4.model.Appointment.AppointmentParticipantComponent t : src.getParticipant())
      tgt.addParticipant(convertAppointmentParticipantComponent(t));
    for (org.hl7.fhir.r4.model.Period t : src.getRequestedPeriod())
      tgt.addRequestedPeriod(Period30_40.convertPeriod(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Appointment.AppointmentParticipantComponent convertAppointmentParticipantComponent(org.hl7.fhir.r4.model.Appointment.AppointmentParticipantComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.Appointment.AppointmentParticipantComponent tgt = new org.hl7.fhir.dstu3.model.Appointment.AppointmentParticipantComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getType())
      tgt.addType(CodeableConcept30_40.convertCodeableConcept(t));
    if (src.hasActor())
      tgt.setActor(Reference30_40.convertReference(src.getActor()));
    if (src.hasRequired())
      tgt.setRequiredElement(convertParticipantRequired(src.getRequiredElement()));
    if (src.hasStatus())
      tgt.setStatusElement(convertParticipationStatus(src.getStatusElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Appointment.AppointmentParticipantComponent convertAppointmentParticipantComponent(org.hl7.fhir.dstu3.model.Appointment.AppointmentParticipantComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Appointment.AppointmentParticipantComponent tgt = new org.hl7.fhir.r4.model.Appointment.AppointmentParticipantComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getType())
      tgt.addType(CodeableConcept30_40.convertCodeableConcept(t));
    if (src.hasActor())
      tgt.setActor(Reference30_40.convertReference(src.getActor()));
    if (src.hasRequired())
      tgt.setRequiredElement(convertParticipantRequired(src.getRequiredElement()));
    if (src.hasStatus())
      tgt.setStatusElement(convertParticipationStatus(src.getStatusElement()));
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Appointment.AppointmentStatus> convertAppointmentStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Appointment.AppointmentStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Appointment.AppointmentStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Appointment.AppointmentStatusEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case PROPOSED:
        tgt.setValue(org.hl7.fhir.dstu3.model.Appointment.AppointmentStatus.PROPOSED);
        break;
      case PENDING:
        tgt.setValue(org.hl7.fhir.dstu3.model.Appointment.AppointmentStatus.PENDING);
        break;
      case BOOKED:
        tgt.setValue(org.hl7.fhir.dstu3.model.Appointment.AppointmentStatus.BOOKED);
        break;
      case ARRIVED:
        tgt.setValue(org.hl7.fhir.dstu3.model.Appointment.AppointmentStatus.ARRIVED);
        break;
      case FULFILLED:
        tgt.setValue(org.hl7.fhir.dstu3.model.Appointment.AppointmentStatus.FULFILLED);
        break;
      case CANCELLED:
        tgt.setValue(org.hl7.fhir.dstu3.model.Appointment.AppointmentStatus.CANCELLED);
        break;
      case NOSHOW:
        tgt.setValue(org.hl7.fhir.dstu3.model.Appointment.AppointmentStatus.NOSHOW);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.dstu3.model.Appointment.AppointmentStatus.ENTEREDINERROR);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.Appointment.AppointmentStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Appointment.AppointmentStatus> convertAppointmentStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Appointment.AppointmentStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Appointment.AppointmentStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Appointment.AppointmentStatusEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
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
      default:
        tgt.setValue(org.hl7.fhir.r4.model.Appointment.AppointmentStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Appointment.ParticipantRequired> convertParticipantRequired(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Appointment.ParticipantRequired> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Appointment.ParticipantRequired> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Appointment.ParticipantRequiredEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case REQUIRED:
        tgt.setValue(org.hl7.fhir.dstu3.model.Appointment.ParticipantRequired.REQUIRED);
        break;
      case OPTIONAL:
        tgt.setValue(org.hl7.fhir.dstu3.model.Appointment.ParticipantRequired.OPTIONAL);
        break;
      case INFORMATIONONLY:
        tgt.setValue(org.hl7.fhir.dstu3.model.Appointment.ParticipantRequired.INFORMATIONONLY);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.Appointment.ParticipantRequired.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Appointment.ParticipantRequired> convertParticipantRequired(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Appointment.ParticipantRequired> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Appointment.ParticipantRequired> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Appointment.ParticipantRequiredEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Appointment.ParticipationStatus> convertParticipationStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Appointment.ParticipationStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Appointment.ParticipationStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Appointment.ParticipationStatusEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
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

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Appointment.ParticipationStatus> convertParticipationStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Appointment.ParticipationStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Appointment.ParticipationStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Appointment.ParticipationStatusEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case ACCEPTED:
        tgt.setValue(org.hl7.fhir.dstu3.model.Appointment.ParticipationStatus.ACCEPTED);
        break;
      case DECLINED:
        tgt.setValue(org.hl7.fhir.dstu3.model.Appointment.ParticipationStatus.DECLINED);
        break;
      case TENTATIVE:
        tgt.setValue(org.hl7.fhir.dstu3.model.Appointment.ParticipationStatus.TENTATIVE);
        break;
      case NEEDSACTION:
        tgt.setValue(org.hl7.fhir.dstu3.model.Appointment.ParticipationStatus.NEEDSACTION);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.Appointment.ParticipationStatus.NULL);
        break;
    }
    return tgt;
  }
}