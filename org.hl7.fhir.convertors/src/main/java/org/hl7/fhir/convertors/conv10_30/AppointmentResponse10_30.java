package org.hl7.fhir.convertors.conv10_30;

import org.hl7.fhir.convertors.VersionConvertor_10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class AppointmentResponse10_30 {

    public static org.hl7.fhir.dstu2.model.AppointmentResponse convertAppointmentResponse(org.hl7.fhir.dstu3.model.AppointmentResponse src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.AppointmentResponse tgt = new org.hl7.fhir.dstu2.model.AppointmentResponse();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_30.convertIdentifier(t));
        if (src.hasAppointment())
            tgt.setAppointment(VersionConvertor_10_30.convertReference(src.getAppointment()));
        if (src.hasStartElement())
            tgt.setStartElement(VersionConvertor_10_30.convertInstant(src.getStartElement()));
        if (src.hasEndElement())
            tgt.setEndElement(VersionConvertor_10_30.convertInstant(src.getEndElement()));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getParticipantType()) tgt.addParticipantType(VersionConvertor_10_30.convertCodeableConcept(t));
        if (src.hasActor())
            tgt.setActor(VersionConvertor_10_30.convertReference(src.getActor()));
        if (src.hasParticipantStatus())
            tgt.setParticipantStatusElement(convertParticipantStatus(src.getParticipantStatusElement()));
        if (src.hasCommentElement())
            tgt.setCommentElement(VersionConvertor_10_30.convertString(src.getCommentElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.AppointmentResponse convertAppointmentResponse(org.hl7.fhir.dstu2.model.AppointmentResponse src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.AppointmentResponse tgt = new org.hl7.fhir.dstu3.model.AppointmentResponse();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_30.convertIdentifier(t));
        if (src.hasAppointment())
            tgt.setAppointment(VersionConvertor_10_30.convertReference(src.getAppointment()));
        if (src.hasStartElement())
            tgt.setStartElement(VersionConvertor_10_30.convertInstant(src.getStartElement()));
        if (src.hasEndElement())
            tgt.setEndElement(VersionConvertor_10_30.convertInstant(src.getEndElement()));
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getParticipantType()) tgt.addParticipantType(VersionConvertor_10_30.convertCodeableConcept(t));
        if (src.hasActor())
            tgt.setActor(VersionConvertor_10_30.convertReference(src.getActor()));
        if (src.hasParticipantStatus())
            tgt.setParticipantStatusElement(convertParticipantStatus(src.getParticipantStatusElement()));
        if (src.hasCommentElement())
            tgt.setCommentElement(VersionConvertor_10_30.convertString(src.getCommentElement()));
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.AppointmentResponse.ParticipantStatus> convertParticipantStatus(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.AppointmentResponse.ParticipantStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.AppointmentResponse.ParticipantStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.AppointmentResponse.ParticipantStatusEnumFactory());
        VersionConvertor_10_30.copyElement(src, tgt);
        switch(src.getValue()) {
            case ACCEPTED:
                tgt.setValue(org.hl7.fhir.dstu3.model.AppointmentResponse.ParticipantStatus.ACCEPTED);
                break;
            case DECLINED:
                tgt.setValue(org.hl7.fhir.dstu3.model.AppointmentResponse.ParticipantStatus.DECLINED);
                break;
            case TENTATIVE:
                tgt.setValue(org.hl7.fhir.dstu3.model.AppointmentResponse.ParticipantStatus.TENTATIVE);
                break;
            case INPROCESS:
                tgt.setValue(org.hl7.fhir.dstu3.model.AppointmentResponse.ParticipantStatus.ACCEPTED);
                break;
            case COMPLETED:
                tgt.setValue(org.hl7.fhir.dstu3.model.AppointmentResponse.ParticipantStatus.ACCEPTED);
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

    static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.AppointmentResponse.ParticipantStatus> convertParticipantStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.AppointmentResponse.ParticipantStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.AppointmentResponse.ParticipantStatus> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.AppointmentResponse.ParticipantStatusEnumFactory());
        VersionConvertor_10_30.copyElement(src, tgt);
        switch(src.getValue()) {
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
}