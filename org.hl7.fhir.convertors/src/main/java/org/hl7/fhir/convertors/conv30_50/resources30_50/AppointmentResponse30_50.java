package org.hl7.fhir.convertors.conv30_50.resources30_50;

import org.hl7.fhir.convertors.context.ConversionContext30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.Reference30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.CodeableConcept30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Identifier30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.Instant30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.String30_50;
import org.hl7.fhir.exceptions.FHIRException;

public class AppointmentResponse30_50 {

  public static org.hl7.fhir.r5.model.AppointmentResponse convertAppointmentResponse(org.hl7.fhir.dstu3.model.AppointmentResponse src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.AppointmentResponse tgt = new org.hl7.fhir.r5.model.AppointmentResponse();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_50.convertIdentifier(t));
    if (src.hasAppointment())
      tgt.setAppointment(Reference30_50.convertReference(src.getAppointment()));
    if (src.hasStart())
      tgt.setStartElement(Instant30_50.convertInstant(src.getStartElement()));
    if (src.hasEnd())
      tgt.setEndElement(Instant30_50.convertInstant(src.getEndElement()));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getParticipantType())
      tgt.addParticipantType(CodeableConcept30_50.convertCodeableConcept(t));
    if (src.hasActor())
      tgt.setActor(Reference30_50.convertReference(src.getActor()));
    if (src.hasParticipantStatus())
      tgt.setParticipantStatusElement(convertParticipantStatus(src.getParticipantStatusElement()));
    if (src.hasComment())
      tgt.setCommentElement(String30_50.convertStringToMarkdown(src.getCommentElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.AppointmentResponse convertAppointmentResponse(org.hl7.fhir.r5.model.AppointmentResponse src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.AppointmentResponse tgt = new org.hl7.fhir.dstu3.model.AppointmentResponse();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier30_50.convertIdentifier(t));
    if (src.hasAppointment())
      tgt.setAppointment(Reference30_50.convertReference(src.getAppointment()));
    if (src.hasStart())
      tgt.setStartElement(Instant30_50.convertInstant(src.getStartElement()));
    if (src.hasEnd())
      tgt.setEndElement(Instant30_50.convertInstant(src.getEndElement()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getParticipantType())
      tgt.addParticipantType(CodeableConcept30_50.convertCodeableConcept(t));
    if (src.hasActor())
      tgt.setActor(Reference30_50.convertReference(src.getActor()));
    if (src.hasParticipantStatus())
      tgt.setParticipantStatusElement(convertParticipantStatus(src.getParticipantStatusElement()));
    if (src.hasComment())
      tgt.setCommentElement(String30_50.convertString(src.getCommentElement()));
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.AppointmentResponse.ParticipantStatus> convertParticipantStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.AppointmentResponse.AppointmentResponseStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.AppointmentResponse.ParticipantStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.AppointmentResponse.ParticipantStatusEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case ACCEPTED:
        tgt.setValue(org.hl7.fhir.dstu3.model.AppointmentResponse.ParticipantStatus.ACCEPTED);
        break;
      case DECLINED:
        tgt.setValue(org.hl7.fhir.dstu3.model.AppointmentResponse.ParticipantStatus.DECLINED);
        break;
      case TENTATIVE:
        tgt.setValue(org.hl7.fhir.dstu3.model.AppointmentResponse.ParticipantStatus.TENTATIVE);
        break;
      case NEEDSACTION:
        tgt.setValue(org.hl7.fhir.dstu3.model.AppointmentResponse.ParticipantStatus.NEEDSACTION);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.AppointmentResponse.ParticipantStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.AppointmentResponse.AppointmentResponseStatus> convertParticipantStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.AppointmentResponse.ParticipantStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.AppointmentResponse.AppointmentResponseStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.AppointmentResponse.AppointmentResponseStatusEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case ACCEPTED:
        tgt.setValue(org.hl7.fhir.r5.model.AppointmentResponse.AppointmentResponseStatus.ACCEPTED);
        break;
      case DECLINED:
        tgt.setValue(org.hl7.fhir.r5.model.AppointmentResponse.AppointmentResponseStatus.DECLINED);
        break;
      case TENTATIVE:
        tgt.setValue(org.hl7.fhir.r5.model.AppointmentResponse.AppointmentResponseStatus.TENTATIVE);
        break;
      case NEEDSACTION:
        tgt.setValue(org.hl7.fhir.r5.model.AppointmentResponse.AppointmentResponseStatus.NEEDSACTION);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.AppointmentResponse.AppointmentResponseStatus.NULL);
        break;
    }
    return tgt;
  }
}