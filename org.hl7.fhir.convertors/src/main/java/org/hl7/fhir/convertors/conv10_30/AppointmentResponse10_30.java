package org.hl7.fhir.convertors.conv10_30;

import org.hl7.fhir.convertors.VersionConvertor_10_30;
import org.hl7.fhir.exceptions.FHIRException;
import java.util.Collections;

public class AppointmentResponse10_30 {

    public static org.hl7.fhir.dstu2.model.AppointmentResponse convertAppointmentResponse(org.hl7.fhir.dstu3.model.AppointmentResponse src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.AppointmentResponse tgt = new org.hl7.fhir.dstu2.model.AppointmentResponse();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_30.convertIdentifier(t));
        }
        if (src.hasAppointment()) {
            tgt.setAppointment(VersionConvertor_10_30.convertReference(src.getAppointment()));
        }
        if (src.hasStartElement())
            tgt.setStartElement((org.hl7.fhir.dstu2.model.InstantType) VersionConvertor_10_30.convertType(src.getStartElement()));
        if (src.hasEndElement())
            tgt.setEndElement((org.hl7.fhir.dstu2.model.InstantType) VersionConvertor_10_30.convertType(src.getEndElement()));
        if (src.hasParticipantType()) {
            for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getParticipantType()) tgt.addParticipantType(VersionConvertor_10_30.convertCodeableConcept(t));
        }
        if (src.hasActor()) {
            tgt.setActor(VersionConvertor_10_30.convertReference(src.getActor()));
        }
        if (src.hasParticipantStatus()) {
            tgt.setParticipantStatus(convertParticipantStatus(src.getParticipantStatus()));
        }
        if (src.hasCommentElement())
            tgt.setCommentElement((org.hl7.fhir.dstu2.model.StringType) VersionConvertor_10_30.convertType(src.getCommentElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.AppointmentResponse convertAppointmentResponse(org.hl7.fhir.dstu2.model.AppointmentResponse src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.AppointmentResponse tgt = new org.hl7.fhir.dstu3.model.AppointmentResponse();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_30.convertIdentifier(t));
        }
        if (src.hasAppointment()) {
            tgt.setAppointment(VersionConvertor_10_30.convertReference(src.getAppointment()));
        }
        if (src.hasStartElement())
            tgt.setStartElement((org.hl7.fhir.dstu3.model.InstantType) VersionConvertor_10_30.convertType(src.getStartElement()));
        if (src.hasEndElement())
            tgt.setEndElement((org.hl7.fhir.dstu3.model.InstantType) VersionConvertor_10_30.convertType(src.getEndElement()));
        if (src.hasParticipantType()) {
            for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getParticipantType()) tgt.addParticipantType(VersionConvertor_10_30.convertCodeableConcept(t));
        }
        if (src.hasActor()) {
            tgt.setActor(VersionConvertor_10_30.convertReference(src.getActor()));
        }
        if (src.hasParticipantStatus()) {
            tgt.setParticipantStatus(convertParticipantStatus(src.getParticipantStatus()));
        }
        if (src.hasCommentElement())
            tgt.setCommentElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_10_30.convertType(src.getCommentElement()));
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.AppointmentResponse.ParticipantStatus convertParticipantStatus(org.hl7.fhir.dstu2.model.AppointmentResponse.ParticipantStatus src) {
        if (src == null)
            return null;
        switch(src) {
            case ACCEPTED:
                return org.hl7.fhir.dstu3.model.AppointmentResponse.ParticipantStatus.ACCEPTED;
            case DECLINED:
                return org.hl7.fhir.dstu3.model.AppointmentResponse.ParticipantStatus.DECLINED;
            case TENTATIVE:
                return org.hl7.fhir.dstu3.model.AppointmentResponse.ParticipantStatus.TENTATIVE;
            case INPROCESS:
                return org.hl7.fhir.dstu3.model.AppointmentResponse.ParticipantStatus.ACCEPTED;
            case COMPLETED:
                return org.hl7.fhir.dstu3.model.AppointmentResponse.ParticipantStatus.ACCEPTED;
            case NEEDSACTION:
                return org.hl7.fhir.dstu3.model.AppointmentResponse.ParticipantStatus.NEEDSACTION;
            default:
                return org.hl7.fhir.dstu3.model.AppointmentResponse.ParticipantStatus.NULL;
        }
    }

    static public org.hl7.fhir.dstu2.model.AppointmentResponse.ParticipantStatus convertParticipantStatus(org.hl7.fhir.dstu3.model.AppointmentResponse.ParticipantStatus src) {
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
}
