package org.hl7.fhir.convertors.conv10_40.resources10_40;

import org.hl7.fhir.convertors.context.ConversionContext10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.Reference10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.CodeableConcept10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.Identifier10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.Instant10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.String10_40;
import org.hl7.fhir.exceptions.FHIRException;

public class AppointmentResponse10_40 {

  public static org.hl7.fhir.r4.model.AppointmentResponse convertAppointmentResponse(org.hl7.fhir.dstu2.model.AppointmentResponse src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.AppointmentResponse tgt = new org.hl7.fhir.r4.model.AppointmentResponse();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_40.convertIdentifier(t));
    if (src.hasAppointment())
      tgt.setAppointment(Reference10_40.convertReference(src.getAppointment()));
    if (src.hasStartElement())
      tgt.setStartElement(Instant10_40.convertInstant(src.getStartElement()));
    if (src.hasEndElement())
      tgt.setEndElement(Instant10_40.convertInstant(src.getEndElement()));
    for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getParticipantType())
      tgt.addParticipantType(CodeableConcept10_40.convertCodeableConcept(t));
    if (src.hasActor())
      tgt.setActor(Reference10_40.convertReference(src.getActor()));
    if (src.hasParticipantStatus())
      tgt.setParticipantStatusElement(convertParticipantStatus(src.getParticipantStatusElement()));
    if (src.hasCommentElement())
      tgt.setCommentElement(String10_40.convertString(src.getCommentElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.AppointmentResponse convertAppointmentResponse(org.hl7.fhir.r4.model.AppointmentResponse src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.AppointmentResponse tgt = new org.hl7.fhir.dstu2.model.AppointmentResponse();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_40.convertIdentifier(t));
    if (src.hasAppointment())
      tgt.setAppointment(Reference10_40.convertReference(src.getAppointment()));
    if (src.hasStartElement())
      tgt.setStartElement(Instant10_40.convertInstant(src.getStartElement()));
    if (src.hasEndElement())
      tgt.setEndElement(Instant10_40.convertInstant(src.getEndElement()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getParticipantType())
      tgt.addParticipantType(CodeableConcept10_40.convertCodeableConcept(t));
    if (src.hasActor())
      tgt.setActor(Reference10_40.convertReference(src.getActor()));
    if (src.hasParticipantStatus())
      tgt.setParticipantStatusElement(convertParticipantStatus(src.getParticipantStatusElement()));
    if (src.hasCommentElement())
      tgt.setCommentElement(String10_40.convertString(src.getCommentElement()));
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.AppointmentResponse.ParticipantStatus> convertParticipantStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.AppointmentResponse.ParticipantStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.AppointmentResponse.ParticipantStatus> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.AppointmentResponse.ParticipantStatusEnumFactory());
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case ACCEPTED:
        tgt.setValue(org.hl7.fhir.dstu2.model.AppointmentResponse.ParticipantStatus.ACCEPTED);
        break;
      case DECLINED:
        tgt.setValue(org.hl7.fhir.dstu2.model.AppointmentResponse.ParticipantStatus.DECLINED);
        break;
      case TENTATIVE:
        tgt.setValue(org.hl7.fhir.dstu2.model.AppointmentResponse.ParticipantStatus.TENTATIVE);
        break;
      case NEEDSACTION:
        tgt.setValue(org.hl7.fhir.dstu2.model.AppointmentResponse.ParticipantStatus.NEEDSACTION);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu2.model.AppointmentResponse.ParticipantStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.AppointmentResponse.ParticipantStatus> convertParticipantStatus(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.AppointmentResponse.ParticipantStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.AppointmentResponse.ParticipantStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.AppointmentResponse.ParticipantStatusEnumFactory());
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case ACCEPTED:
        tgt.setValue(org.hl7.fhir.r4.model.AppointmentResponse.ParticipantStatus.ACCEPTED);
        break;
      case DECLINED:
        tgt.setValue(org.hl7.fhir.r4.model.AppointmentResponse.ParticipantStatus.DECLINED);
        break;
      case TENTATIVE:
        tgt.setValue(org.hl7.fhir.r4.model.AppointmentResponse.ParticipantStatus.TENTATIVE);
        break;
      case INPROCESS:
        tgt.setValue(org.hl7.fhir.r4.model.AppointmentResponse.ParticipantStatus.ACCEPTED);
        break;
      case COMPLETED:
        tgt.setValue(org.hl7.fhir.r4.model.AppointmentResponse.ParticipantStatus.ACCEPTED);
        break;
      case NEEDSACTION:
        tgt.setValue(org.hl7.fhir.r4.model.AppointmentResponse.ParticipantStatus.NEEDSACTION);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.AppointmentResponse.ParticipantStatus.NULL);
        break;
    }
    return tgt;
  }
}