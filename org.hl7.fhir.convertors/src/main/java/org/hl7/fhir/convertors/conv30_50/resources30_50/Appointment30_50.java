package org.hl7.fhir.convertors.conv30_50.resources30_50;

import org.hl7.fhir.convertors.context.ConversionContext30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.Reference30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.CodeableConcept30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Identifier30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Period30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.DateTime30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.Instant30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.PositiveInt30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.String30_50;
import org.hl7.fhir.dstu3.model.UnsignedIntType;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CodeableConcept;
import org.hl7.fhir.r5.model.CodeableReference;

public class Appointment30_50 {

  public static org.hl7.fhir.dstu3.model.Appointment convertAppointment(org.hl7.fhir.r5.model.Appointment src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.Appointment tgt = new org.hl7.fhir.dstu3.model.Appointment();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_50.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertAppointmentStatus(src.getStatusElement()));
    if (src.hasServiceCategory())
      tgt.setServiceCategory(CodeableConcept30_50.convertCodeableConcept(src.getServiceCategoryFirstRep()));
    for (org.hl7.fhir.r5.model.CodeableReference t : src.getServiceType())
      tgt.addServiceType(CodeableConcept30_50.convertCodeableConcept(t.getConcept()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getSpecialty())
      tgt.addSpecialty(CodeableConcept30_50.convertCodeableConcept(t));
    if (src.hasAppointmentType())
      tgt.setAppointmentType(CodeableConcept30_50.convertCodeableConcept(src.getAppointmentType()));
    for (CodeableReference t : src.getReason())
      if (t.hasConcept())
        tgt.addReason(CodeableConcept30_50.convertCodeableConcept(t.getConcept()));
    for (CodeableReference t : src.getReason())
      if (t.hasReference())
        tgt.addIndication(Reference30_50.convertReference(t.getReference()));
    if (src.hasPriority())
      tgt.setPriorityElement(convertAppointmentPriority(src.getPriority()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String30_50.convertString(src.getDescriptionElement()));
    for (org.hl7.fhir.r5.model.Reference t : src.getSupportingInformation())
      tgt.addSupportingInformation(Reference30_50.convertReference(t));
    if (src.hasStart())
      tgt.setStartElement(Instant30_50.convertInstant(src.getStartElement()));
    if (src.hasEnd())
      tgt.setEndElement(Instant30_50.convertInstant(src.getEndElement()));
    if (src.hasMinutesDuration())
      tgt.setMinutesDurationElement(PositiveInt30_50.convertPositiveInt(src.getMinutesDurationElement()));
    for (org.hl7.fhir.r5.model.Reference t : src.getSlot()) tgt.addSlot(Reference30_50.convertReference(t));
    if (src.hasCreated())
      tgt.setCreatedElement(DateTime30_50.convertDateTime(src.getCreatedElement()));
    if (src.hasNote())
      tgt.setCommentElement(String30_50.convertString(src.getNoteFirstRep().getTextElement()));
    for (org.hl7.fhir.r5.model.Reference t : src.getBasedOn())
      tgt.addIncomingReferral(Reference30_50.convertReference(t));
    for (org.hl7.fhir.r5.model.Appointment.AppointmentParticipantComponent t : src.getParticipant())
      tgt.addParticipant(convertAppointmentParticipantComponent(t));
    for (org.hl7.fhir.r5.model.Period t : src.getRequestedPeriod())
      tgt.addRequestedPeriod(Period30_50.convertPeriod(t));
    return tgt;
  }


  private static UnsignedIntType convertAppointmentPriority(CodeableConcept src) {
    UnsignedIntType tgt = new UnsignedIntType(convertAppointmentPriorityFromR5(src));
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    return tgt;
  }

  private static CodeableConcept convertAppointmentPriority(UnsignedIntType src) {
    CodeableConcept tgt = src.hasValue() ? convertAppointmentPriorityToR5(src.getValue()) : new CodeableConcept();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    return tgt;
  }

  public static org.hl7.fhir.r5.model.CodeableConcept convertAppointmentPriorityToR5(int priority) {
    return null;
  }

  public static int convertAppointmentPriorityFromR5(org.hl7.fhir.r5.model.CodeableConcept priority) {
    return 0;
  }

  public static org.hl7.fhir.r5.model.Appointment convertAppointment(org.hl7.fhir.dstu3.model.Appointment src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Appointment tgt = new org.hl7.fhir.r5.model.Appointment();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_50.convertIdentifier(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertAppointmentStatus(src.getStatusElement()));
    if (src.hasServiceCategory())
      tgt.addServiceCategory(CodeableConcept30_50.convertCodeableConcept(src.getServiceCategory()));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getServiceType())
      tgt.addServiceType().setConcept(CodeableConcept30_50.convertCodeableConcept(t));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getSpecialty())
      tgt.addSpecialty(CodeableConcept30_50.convertCodeableConcept(t));
    if (src.hasAppointmentType())
      tgt.setAppointmentType(CodeableConcept30_50.convertCodeableConcept(src.getAppointmentType()));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getReason())
      tgt.addReason(Reference30_50.convertCodeableConceptToCodableReference(t));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getIndication())
      tgt.addReason(Reference30_50.convertReferenceToCodableReference(t));
    if (src.hasPriority())
      tgt.setPriority(convertAppointmentPriority(src.getPriorityElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String30_50.convertString(src.getDescriptionElement()));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getSupportingInformation())
      tgt.addSupportingInformation(Reference30_50.convertReference(t));
    if (src.hasStart())
      tgt.setStartElement(Instant30_50.convertInstant(src.getStartElement()));
    if (src.hasEnd())
      tgt.setEndElement(Instant30_50.convertInstant(src.getEndElement()));
    if (src.hasMinutesDuration())
      tgt.setMinutesDurationElement(PositiveInt30_50.convertPositiveInt(src.getMinutesDurationElement()));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getSlot()) tgt.addSlot(Reference30_50.convertReference(t));
    if (src.hasCreated())
      tgt.setCreatedElement(DateTime30_50.convertDateTime(src.getCreatedElement()));
    if (src.hasComment())
      tgt.getNoteFirstRep().setTextElement(String30_50.convertStringToMarkdown(src.getCommentElement()));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getIncomingReferral())
      tgt.addBasedOn(Reference30_50.convertReference(t));
    for (org.hl7.fhir.dstu3.model.Appointment.AppointmentParticipantComponent t : src.getParticipant())
      tgt.addParticipant(convertAppointmentParticipantComponent(t));
    for (org.hl7.fhir.dstu3.model.Period t : src.getRequestedPeriod())
      tgt.addRequestedPeriod(Period30_50.convertPeriod(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Appointment.AppointmentParticipantComponent convertAppointmentParticipantComponent(org.hl7.fhir.r5.model.Appointment.AppointmentParticipantComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.Appointment.AppointmentParticipantComponent tgt = new org.hl7.fhir.dstu3.model.Appointment.AppointmentParticipantComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getType())
      tgt.addType(CodeableConcept30_50.convertCodeableConcept(t));
    if (src.hasActor())
      tgt.setActor(Reference30_50.convertReference(src.getActor()));
    if (src.hasRequired())
      tgt.setRequiredElement(convertParticipantRequired(src.getRequiredElement()));
    if (src.hasStatus())
      tgt.setStatusElement(convertParticipationStatus(src.getStatusElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Appointment.AppointmentParticipantComponent convertAppointmentParticipantComponent(org.hl7.fhir.dstu3.model.Appointment.AppointmentParticipantComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Appointment.AppointmentParticipantComponent tgt = new org.hl7.fhir.r5.model.Appointment.AppointmentParticipantComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getType())
      tgt.addType(CodeableConcept30_50.convertCodeableConcept(t));
    if (src.hasActor())
      tgt.setActor(Reference30_50.convertReference(src.getActor()));
    if (src.hasRequired())
      tgt.setRequiredElement(convertParticipantRequired(src.getRequiredElement()));
    if (src.hasStatus())
      tgt.setStatusElement(convertParticipationStatus(src.getStatusElement()));
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Appointment.AppointmentStatus> convertAppointmentStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Appointment.AppointmentStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Appointment.AppointmentStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Appointment.AppointmentStatusEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
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

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Appointment.AppointmentStatus> convertAppointmentStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Appointment.AppointmentStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Appointment.AppointmentStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Appointment.AppointmentStatusEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
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
      default:
        tgt.setValue(org.hl7.fhir.r5.model.Appointment.AppointmentStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Appointment.ParticipantRequired> convertParticipantRequired(org.hl7.fhir.r5.model.BooleanType src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Appointment.ParticipantRequired> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Appointment.ParticipantRequiredEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.getValue()) { // case REQUIRED:
      tgt.setValue(org.hl7.fhir.dstu3.model.Appointment.ParticipantRequired.REQUIRED);
    } else { // case OPTIONAL and others:
      tgt.setValue(org.hl7.fhir.dstu3.model.Appointment.ParticipantRequired.OPTIONAL);
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.BooleanType convertParticipantRequired(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Appointment.ParticipantRequired> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.BooleanType tgt = new org.hl7.fhir.r5.model.BooleanType();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
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

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Appointment.ParticipationStatus> convertParticipationStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Appointment.ParticipationStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Appointment.ParticipationStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Appointment.ParticipationStatusEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
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

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Appointment.ParticipationStatus> convertParticipationStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Appointment.ParticipationStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Appointment.ParticipationStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Appointment.ParticipationStatusEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case ACCEPTED:
        tgt.setValue(org.hl7.fhir.r5.model.Appointment.ParticipationStatus.ACCEPTED);
        break;
      case DECLINED:
        tgt.setValue(org.hl7.fhir.r5.model.Appointment.ParticipationStatus.DECLINED);
        break;
      case TENTATIVE:
        tgt.setValue(org.hl7.fhir.r5.model.Appointment.ParticipationStatus.TENTATIVE);
        break;
      case NEEDSACTION:
        tgt.setValue(org.hl7.fhir.r5.model.Appointment.ParticipationStatus.NEEDSACTION);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.Appointment.ParticipationStatus.NULL);
        break;
    }
    return tgt;
  }
}