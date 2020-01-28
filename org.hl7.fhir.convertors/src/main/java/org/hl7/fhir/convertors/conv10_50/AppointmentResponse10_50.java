package org.hl7.fhir.convertors.conv10_50;

import org.hl7.fhir.convertors.VersionConvertor_10_50;
import org.hl7.fhir.exceptions.FHIRException;

public class AppointmentResponse10_50 {

    public static org.hl7.fhir.dstu2.model.AppointmentResponse convertAppointmentResponse(org.hl7.fhir.r5.model.AppointmentResponse src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.AppointmentResponse tgt = new org.hl7.fhir.dstu2.model.AppointmentResponse();
        VersionConvertor_10_50.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_50.convertIdentifier(t));
        tgt.setAppointment(VersionConvertor_10_50.convertReference(src.getAppointment()));
        tgt.setStart(src.getStart());
        tgt.setEnd(src.getEnd());
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getParticipantType()) tgt.addParticipantType(VersionConvertor_10_50.convertCodeableConcept(t));
        tgt.setActor(VersionConvertor_10_50.convertReference(src.getActor()));
        tgt.setParticipantStatus(convertParticipantStatus(src.getParticipantStatus()));
        tgt.setComment(src.getComment());
        return tgt;
    }

    public static org.hl7.fhir.r5.model.AppointmentResponse convertAppointmentResponse(org.hl7.fhir.dstu2.model.AppointmentResponse src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.AppointmentResponse tgt = new org.hl7.fhir.r5.model.AppointmentResponse();
        VersionConvertor_10_50.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_50.convertIdentifier(t));
        tgt.setAppointment(VersionConvertor_10_50.convertReference(src.getAppointment()));
        tgt.setStart(src.getStart());
        tgt.setEnd(src.getEnd());
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getParticipantType()) tgt.addParticipantType(VersionConvertor_10_50.convertCodeableConcept(t));
        tgt.setActor(VersionConvertor_10_50.convertReference(src.getActor()));
        tgt.setParticipantStatus(convertParticipantStatus(src.getParticipantStatus()));
        tgt.setComment(src.getComment());
        return tgt;
    }

    static public org.hl7.fhir.dstu2.model.AppointmentResponse.ParticipantStatus convertParticipantStatus(org.hl7.fhir.r5.model.Enumerations.ParticipationStatus src) {
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

    static public org.hl7.fhir.r5.model.Enumerations.ParticipationStatus convertParticipantStatus(org.hl7.fhir.dstu2.model.AppointmentResponse.ParticipantStatus src) {
        if (src == null)
            return null;
        switch(src) {
            case ACCEPTED:
                return org.hl7.fhir.r5.model.Enumerations.ParticipationStatus.ACCEPTED;
            case DECLINED:
                return org.hl7.fhir.r5.model.Enumerations.ParticipationStatus.DECLINED;
            case TENTATIVE:
                return org.hl7.fhir.r5.model.Enumerations.ParticipationStatus.TENTATIVE;
            case INPROCESS:
                return org.hl7.fhir.r5.model.Enumerations.ParticipationStatus.ACCEPTED;
            case COMPLETED:
                return org.hl7.fhir.r5.model.Enumerations.ParticipationStatus.ACCEPTED;
            case NEEDSACTION:
                return org.hl7.fhir.r5.model.Enumerations.ParticipationStatus.NEEDSACTION;
            default:
                return org.hl7.fhir.r5.model.Enumerations.ParticipationStatus.NULL;
        }
    }
}
