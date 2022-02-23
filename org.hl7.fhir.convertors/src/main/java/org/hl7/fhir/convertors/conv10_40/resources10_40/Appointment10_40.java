package org.hl7.fhir.convertors.conv10_40.resources10_40;

import org.hl7.fhir.convertors.context.ConversionContext10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.Reference10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.CodeableConcept10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.Identifier10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.Instant10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.PositiveInt10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.String10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.UnsignedInt10_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Appointment10_40 {

  public static org.hl7.fhir.r4.model.Appointment convertAppointment(org.hl7.fhir.dstu2.model.Appointment src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Appointment tgt = new org.hl7.fhir.r4.model.Appointment();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_40.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertAppointmentStatus(src.getStatusElement()));
    if (src.hasType())
      tgt.addServiceType(CodeableConcept10_40.convertCodeableConcept(src.getType()));
    if (src.hasPriorityElement())
      tgt.setPriorityElement(UnsignedInt10_40.convertUnsignedInt(src.getPriorityElement()));
    if (src.hasDescriptionElement())
      tgt.setDescriptionElement(String10_40.convertString(src.getDescriptionElement()));
    if (src.hasStartElement())
      tgt.setStartElement(Instant10_40.convertInstant(src.getStartElement()));
    if (src.hasEndElement())
      tgt.setEndElement(Instant10_40.convertInstant(src.getEndElement()));
    if (src.hasMinutesDurationElement())
      tgt.setMinutesDurationElement(PositiveInt10_40.convertPositiveInt(src.getMinutesDurationElement()));
    for (org.hl7.fhir.dstu2.model.Reference t : src.getSlot()) tgt.addSlot(Reference10_40.convertReference(t));
    if (src.hasCommentElement())
      tgt.setCommentElement(String10_40.convertString(src.getCommentElement()));
    for (org.hl7.fhir.dstu2.model.Appointment.AppointmentParticipantComponent t : src.getParticipant())
      tgt.addParticipant(convertAppointmentParticipantComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Appointment convertAppointment(org.hl7.fhir.r4.model.Appointment src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Appointment tgt = new org.hl7.fhir.dstu2.model.Appointment();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_40.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertAppointmentStatus(src.getStatusElement()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getServiceType())
      tgt.setType(CodeableConcept10_40.convertCodeableConcept(t));
    if (src.hasPriorityElement())
      tgt.setPriorityElement(UnsignedInt10_40.convertUnsignedInt(src.getPriorityElement()));
    if (src.hasDescriptionElement())
      tgt.setDescriptionElement(String10_40.convertString(src.getDescriptionElement()));
    if (src.hasStartElement())
      tgt.setStartElement(Instant10_40.convertInstant(src.getStartElement()));
    if (src.hasEndElement())
      tgt.setEndElement(Instant10_40.convertInstant(src.getEndElement()));
    if (src.hasMinutesDurationElement())
      tgt.setMinutesDurationElement(PositiveInt10_40.convertPositiveInt(src.getMinutesDurationElement()));
    for (org.hl7.fhir.r4.model.Reference t : src.getSlot()) tgt.addSlot(Reference10_40.convertReference(t));
    if (src.hasCommentElement())
      tgt.setCommentElement(String10_40.convertString(src.getCommentElement()));
    for (org.hl7.fhir.r4.model.Appointment.AppointmentParticipantComponent t : src.getParticipant())
      tgt.addParticipant(convertAppointmentParticipantComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Appointment.AppointmentParticipantComponent convertAppointmentParticipantComponent(org.hl7.fhir.dstu2.model.Appointment.AppointmentParticipantComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Appointment.AppointmentParticipantComponent tgt = new org.hl7.fhir.r4.model.Appointment.AppointmentParticipantComponent();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
    for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getType())
      tgt.addType(CodeableConcept10_40.convertCodeableConcept(t));
    if (src.hasActor())
      tgt.setActor(Reference10_40.convertReference(src.getActor()));
    if (src.hasRequired())
      tgt.setRequiredElement(convertParticipantRequired(src.getRequiredElement()));
    if (src.hasStatus())
      tgt.setStatusElement(convertParticipationStatus(src.getStatusElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Appointment.AppointmentParticipantComponent convertAppointmentParticipantComponent(org.hl7.fhir.r4.model.Appointment.AppointmentParticipantComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Appointment.AppointmentParticipantComponent tgt = new org.hl7.fhir.dstu2.model.Appointment.AppointmentParticipantComponent();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getType())
      tgt.addType(CodeableConcept10_40.convertCodeableConcept(t));
    if (src.hasActor())
      tgt.setActor(Reference10_40.convertReference(src.getActor()));
    if (src.hasRequired())
      tgt.setRequiredElement(convertParticipantRequired(src.getRequiredElement()));
    if (src.hasStatus())
      tgt.setStatusElement(convertParticipationStatus(src.getStatusElement()));
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Appointment.AppointmentStatus> convertAppointmentStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Appointment.AppointmentStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Appointment.AppointmentStatus> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Appointment.AppointmentStatusEnumFactory());
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case PROPOSED:
        tgt.setValue(org.hl7.fhir.dstu2.model.Appointment.AppointmentStatus.PROPOSED);
        break;
      case PENDING:
        tgt.setValue(org.hl7.fhir.dstu2.model.Appointment.AppointmentStatus.PENDING);
        break;
      case BOOKED:
        tgt.setValue(org.hl7.fhir.dstu2.model.Appointment.AppointmentStatus.BOOKED);
        break;
      case ARRIVED:
        tgt.setValue(org.hl7.fhir.dstu2.model.Appointment.AppointmentStatus.ARRIVED);
        break;
      case FULFILLED:
        tgt.setValue(org.hl7.fhir.dstu2.model.Appointment.AppointmentStatus.FULFILLED);
        break;
      case CANCELLED:
        tgt.setValue(org.hl7.fhir.dstu2.model.Appointment.AppointmentStatus.CANCELLED);
        break;
      case NOSHOW:
        tgt.setValue(org.hl7.fhir.dstu2.model.Appointment.AppointmentStatus.NOSHOW);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu2.model.Appointment.AppointmentStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Appointment.AppointmentStatus> convertAppointmentStatus(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Appointment.AppointmentStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Appointment.AppointmentStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Appointment.AppointmentStatusEnumFactory());
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
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
      default:
        tgt.setValue(org.hl7.fhir.r4.model.Appointment.AppointmentStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Appointment.ParticipantRequired> convertParticipantRequired(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Appointment.ParticipantRequired> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Appointment.ParticipantRequired> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Appointment.ParticipantRequiredEnumFactory());
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
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

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Appointment.ParticipantRequired> convertParticipantRequired(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Appointment.ParticipantRequired> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Appointment.ParticipantRequired> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Appointment.ParticipantRequiredEnumFactory());
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case REQUIRED:
        tgt.setValue(org.hl7.fhir.dstu2.model.Appointment.ParticipantRequired.REQUIRED);
        break;
      case OPTIONAL:
        tgt.setValue(org.hl7.fhir.dstu2.model.Appointment.ParticipantRequired.OPTIONAL);
        break;
      case INFORMATIONONLY:
        tgt.setValue(org.hl7.fhir.dstu2.model.Appointment.ParticipantRequired.INFORMATIONONLY);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu2.model.Appointment.ParticipantRequired.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Appointment.ParticipationStatus> convertParticipationStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Appointment.ParticipationStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Appointment.ParticipationStatus> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Appointment.ParticipationStatusEnumFactory());
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case ACCEPTED:
        tgt.setValue(org.hl7.fhir.dstu2.model.Appointment.ParticipationStatus.ACCEPTED);
        break;
      case DECLINED:
        tgt.setValue(org.hl7.fhir.dstu2.model.Appointment.ParticipationStatus.DECLINED);
        break;
      case TENTATIVE:
        tgt.setValue(org.hl7.fhir.dstu2.model.Appointment.ParticipationStatus.TENTATIVE);
        break;
      case NEEDSACTION:
        tgt.setValue(org.hl7.fhir.dstu2.model.Appointment.ParticipationStatus.NEEDSACTION);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu2.model.Appointment.ParticipationStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Appointment.ParticipationStatus> convertParticipationStatus(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Appointment.ParticipationStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Appointment.ParticipationStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Appointment.ParticipationStatusEnumFactory());
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
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
}