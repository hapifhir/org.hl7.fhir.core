package org.hl7.fhir.convertors.conv30_40;

import org.hl7.fhir.convertors.VersionConvertor_30_40;
import org.hl7.fhir.exceptions.FHIRException;

public class AppointmentResponse30_40 {

    public static org.hl7.fhir.r4.model.AppointmentResponse convertAppointmentResponse(org.hl7.fhir.dstu3.model.AppointmentResponse src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.AppointmentResponse tgt = new org.hl7.fhir.r4.model.AppointmentResponse();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        if (src.hasAppointment())
            tgt.setAppointment(VersionConvertor_30_40.convertReference(src.getAppointment()));
        if (src.hasStart())
            tgt.setStartElement(VersionConvertor_30_40.convertInstant(src.getStartElement()));
        if (src.hasEnd())
            tgt.setEnd(src.getEnd());
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getParticipantType()) tgt.addParticipantType(VersionConvertor_30_40.convertCodeableConcept(t));
        if (src.hasActor())
            tgt.setActor(VersionConvertor_30_40.convertReference(src.getActor()));
        if (src.hasParticipantStatus())
            tgt.setParticipantStatus(convertParticipantStatus(src.getParticipantStatus()));
        if (src.hasComment())
            tgt.setComment(src.getComment());
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.AppointmentResponse convertAppointmentResponse(org.hl7.fhir.r4.model.AppointmentResponse src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.AppointmentResponse tgt = new org.hl7.fhir.dstu3.model.AppointmentResponse();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        if (src.hasAppointment())
            tgt.setAppointment(VersionConvertor_30_40.convertReference(src.getAppointment()));
        if (src.hasStart())
            tgt.setStartElement(VersionConvertor_30_40.convertInstant(src.getStartElement()));
        if (src.hasEnd())
            tgt.setEnd(src.getEnd());
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getParticipantType()) tgt.addParticipantType(VersionConvertor_30_40.convertCodeableConcept(t));
        if (src.hasActor())
            tgt.setActor(VersionConvertor_30_40.convertReference(src.getActor()));
        if (src.hasParticipantStatus())
            tgt.setParticipantStatus(convertParticipantStatus(src.getParticipantStatus()));
        if (src.hasComment())
            tgt.setComment(src.getComment());
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.AppointmentResponse.ParticipantStatus convertParticipantStatus(org.hl7.fhir.r4.model.AppointmentResponse.ParticipantStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case ACCEPTED:
                return org.hl7.fhir.dstu3.model.AppointmentResponse.ParticipantStatus.ACCEPTED;
            case DECLINED:
                return org.hl7.fhir.dstu3.model.AppointmentResponse.ParticipantStatus.DECLINED;
            case TENTATIVE:
                return org.hl7.fhir.dstu3.model.AppointmentResponse.ParticipantStatus.TENTATIVE;
            case NEEDSACTION:
                return org.hl7.fhir.dstu3.model.AppointmentResponse.ParticipantStatus.NEEDSACTION;
            default:
                return org.hl7.fhir.dstu3.model.AppointmentResponse.ParticipantStatus.NULL;
        }
    }

    static public org.hl7.fhir.r4.model.AppointmentResponse.ParticipantStatus convertParticipantStatus(org.hl7.fhir.dstu3.model.AppointmentResponse.ParticipantStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case ACCEPTED:
                return org.hl7.fhir.r4.model.AppointmentResponse.ParticipantStatus.ACCEPTED;
            case DECLINED:
                return org.hl7.fhir.r4.model.AppointmentResponse.ParticipantStatus.DECLINED;
            case TENTATIVE:
                return org.hl7.fhir.r4.model.AppointmentResponse.ParticipantStatus.TENTATIVE;
            case NEEDSACTION:
                return org.hl7.fhir.r4.model.AppointmentResponse.ParticipantStatus.NEEDSACTION;
            default:
                return org.hl7.fhir.r4.model.AppointmentResponse.ParticipantStatus.NULL;
        }
    }
}
