package org.hl7.fhir.convertors.conv10_40;

import org.hl7.fhir.convertors.VersionConvertor_10_40;
import org.hl7.fhir.exceptions.FHIRException;

public class AppointmentResponse10_40 {

    public static org.hl7.fhir.r4.model.AppointmentResponse convertAppointmentResponse(org.hl7.fhir.dstu2.model.AppointmentResponse src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.AppointmentResponse tgt = new org.hl7.fhir.r4.model.AppointmentResponse();
        VersionConvertor_10_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_40.convertIdentifier(t));
        if (src.hasAppointment())
            tgt.setAppointment(VersionConvertor_10_40.convertReference(src.getAppointment()));
        if (src.hasStartElement())
            tgt.setStartElement(VersionConvertor_10_40.convertInstant(src.getStartElement()));
        if (src.hasEndElement())
            tgt.setEndElement(VersionConvertor_10_40.convertInstant(src.getEndElement()));
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getParticipantType()) tgt.addParticipantType(VersionConvertor_10_40.convertCodeableConcept(t));
        if (src.hasActor())
            tgt.setActor(VersionConvertor_10_40.convertReference(src.getActor()));
        if (src.hasParticipantStatus())
            tgt.setParticipantStatus(convertParticipantStatus(src.getParticipantStatus()));
        if (src.hasCommentElement())
            tgt.setCommentElement(VersionConvertor_10_40.convertString(src.getCommentElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.AppointmentResponse convertAppointmentResponse(org.hl7.fhir.r4.model.AppointmentResponse src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.AppointmentResponse tgt = new org.hl7.fhir.dstu2.model.AppointmentResponse();
        VersionConvertor_10_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_40.convertIdentifier(t));
        if (src.hasAppointment())
            tgt.setAppointment(VersionConvertor_10_40.convertReference(src.getAppointment()));
        if (src.hasStartElement())
            tgt.setStartElement(VersionConvertor_10_40.convertInstant(src.getStartElement()));
        if (src.hasEndElement())
            tgt.setEndElement(VersionConvertor_10_40.convertInstant(src.getEndElement()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getParticipantType()) tgt.addParticipantType(VersionConvertor_10_40.convertCodeableConcept(t));
        if (src.hasActor())
            tgt.setActor(VersionConvertor_10_40.convertReference(src.getActor()));
        if (src.hasParticipantStatus())
            tgt.setParticipantStatus(convertParticipantStatus(src.getParticipantStatus()));
        if (src.hasCommentElement())
            tgt.setCommentElement(VersionConvertor_10_40.convertString(src.getCommentElement()));
        return tgt;
    }

    static public org.hl7.fhir.dstu2.model.AppointmentResponse.ParticipantStatus convertParticipantStatus(org.hl7.fhir.r4.model.AppointmentResponse.ParticipantStatus src) {
        if (src == null)
            return null;
        switch(src) {
            case ACCEPTED:
                return org.hl7.fhir.dstu2.model.AppointmentResponse.ParticipantStatus.ACCEPTED;
            case DECLINED:
                return org.hl7.fhir.dstu2.model.AppointmentResponse.ParticipantStatus.DECLINED;
            case TENTATIVE:
                return org.hl7.fhir.dstu2.model.AppointmentResponse.ParticipantStatus.TENTATIVE;
            case NEEDSACTION:
                return org.hl7.fhir.dstu2.model.AppointmentResponse.ParticipantStatus.NEEDSACTION;
            default:
                return org.hl7.fhir.dstu2.model.AppointmentResponse.ParticipantStatus.NULL;
        }
    }

    static public org.hl7.fhir.r4.model.AppointmentResponse.ParticipantStatus convertParticipantStatus(org.hl7.fhir.dstu2.model.AppointmentResponse.ParticipantStatus src) {
        if (src == null)
            return null;
        switch(src) {
            case ACCEPTED:
                return org.hl7.fhir.r4.model.AppointmentResponse.ParticipantStatus.ACCEPTED;
            case DECLINED:
                return org.hl7.fhir.r4.model.AppointmentResponse.ParticipantStatus.DECLINED;
            case TENTATIVE:
                return org.hl7.fhir.r4.model.AppointmentResponse.ParticipantStatus.TENTATIVE;
            case INPROCESS:
                return org.hl7.fhir.r4.model.AppointmentResponse.ParticipantStatus.ACCEPTED;
            case COMPLETED:
                return org.hl7.fhir.r4.model.AppointmentResponse.ParticipantStatus.ACCEPTED;
            case NEEDSACTION:
                return org.hl7.fhir.r4.model.AppointmentResponse.ParticipantStatus.NEEDSACTION;
            default:
                return org.hl7.fhir.r4.model.AppointmentResponse.ParticipantStatus.NULL;
        }
    }
}
