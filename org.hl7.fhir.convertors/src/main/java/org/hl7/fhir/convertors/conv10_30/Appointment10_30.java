package org.hl7.fhir.convertors.conv10_30;

import org.hl7.fhir.convertors.VersionConvertor_10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class Appointment10_30 {

    public static org.hl7.fhir.dstu2.model.Appointment convertAppointment(org.hl7.fhir.dstu3.model.Appointment src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Appointment tgt = new org.hl7.fhir.dstu2.model.Appointment();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_30.convertIdentifier(t));
        tgt.setStatus(convertAppointmentStatus(src.getStatus()));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getServiceType()) tgt.setType(VersionConvertor_10_30.convertCodeableConcept(t));
        tgt.setPriority(src.getPriority());
        tgt.setDescription(src.getDescription());
        tgt.setStart(src.getStart());
        tgt.setEnd(src.getEnd());
        tgt.setMinutesDuration(src.getMinutesDuration());
        for (org.hl7.fhir.dstu3.model.Reference t : src.getSlot()) tgt.addSlot(VersionConvertor_10_30.convertReference(t));
        tgt.setComment(src.getComment());
        for (org.hl7.fhir.dstu3.model.Appointment.AppointmentParticipantComponent t : src.getParticipant()) tgt.addParticipant(convertAppointmentParticipantComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Appointment convertAppointment(org.hl7.fhir.dstu2.model.Appointment src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Appointment tgt = new org.hl7.fhir.dstu3.model.Appointment();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_30.convertIdentifier(t));
        tgt.setStatus(convertAppointmentStatus(src.getStatus()));
        if (src.hasType())
            tgt.addServiceType(VersionConvertor_10_30.convertCodeableConcept(src.getType()));
        tgt.setPriority(src.getPriority());
        tgt.setDescription(src.getDescription());
        tgt.setStart(src.getStart());
        tgt.setEnd(src.getEnd());
        tgt.setMinutesDuration(src.getMinutesDuration());
        for (org.hl7.fhir.dstu2.model.Reference t : src.getSlot()) tgt.addSlot(VersionConvertor_10_30.convertReference(t));
        tgt.setComment(src.getComment());
        for (org.hl7.fhir.dstu2.model.Appointment.AppointmentParticipantComponent t : src.getParticipant()) tgt.addParticipant(convertAppointmentParticipantComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Appointment.AppointmentParticipantComponent convertAppointmentParticipantComponent(org.hl7.fhir.dstu3.model.Appointment.AppointmentParticipantComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Appointment.AppointmentParticipantComponent tgt = new org.hl7.fhir.dstu2.model.Appointment.AppointmentParticipantComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getType()) tgt.addType(VersionConvertor_10_30.convertCodeableConcept(t));
        tgt.setActor(VersionConvertor_10_30.convertReference(src.getActor()));
        tgt.setRequired(convertParticipantRequired(src.getRequired()));
        tgt.setStatus(convertParticipationStatus(src.getStatus()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Appointment.AppointmentParticipantComponent convertAppointmentParticipantComponent(org.hl7.fhir.dstu2.model.Appointment.AppointmentParticipantComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Appointment.AppointmentParticipantComponent tgt = new org.hl7.fhir.dstu3.model.Appointment.AppointmentParticipantComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getType()) tgt.addType(VersionConvertor_10_30.convertCodeableConcept(t));
        tgt.setActor(VersionConvertor_10_30.convertReference(src.getActor()));
        tgt.setRequired(convertParticipantRequired(src.getRequired()));
        tgt.setStatus(convertParticipationStatus(src.getStatus()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Appointment.AppointmentStatus convertAppointmentStatus(org.hl7.fhir.dstu3.model.Appointment.AppointmentStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case PROPOSED:
                return org.hl7.fhir.dstu2.model.Appointment.AppointmentStatus.PROPOSED;
            case PENDING:
                return org.hl7.fhir.dstu2.model.Appointment.AppointmentStatus.PENDING;
            case BOOKED:
                return org.hl7.fhir.dstu2.model.Appointment.AppointmentStatus.BOOKED;
            case ARRIVED:
                return org.hl7.fhir.dstu2.model.Appointment.AppointmentStatus.ARRIVED;
            case FULFILLED:
                return org.hl7.fhir.dstu2.model.Appointment.AppointmentStatus.FULFILLED;
            case CANCELLED:
                return org.hl7.fhir.dstu2.model.Appointment.AppointmentStatus.CANCELLED;
            case NOSHOW:
                return org.hl7.fhir.dstu2.model.Appointment.AppointmentStatus.NOSHOW;
            default:
                return org.hl7.fhir.dstu2.model.Appointment.AppointmentStatus.NULL;
        }
    }

    public static org.hl7.fhir.dstu3.model.Appointment.AppointmentStatus convertAppointmentStatus(org.hl7.fhir.dstu2.model.Appointment.AppointmentStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case PROPOSED:
                return org.hl7.fhir.dstu3.model.Appointment.AppointmentStatus.PROPOSED;
            case PENDING:
                return org.hl7.fhir.dstu3.model.Appointment.AppointmentStatus.PENDING;
            case BOOKED:
                return org.hl7.fhir.dstu3.model.Appointment.AppointmentStatus.BOOKED;
            case ARRIVED:
                return org.hl7.fhir.dstu3.model.Appointment.AppointmentStatus.ARRIVED;
            case FULFILLED:
                return org.hl7.fhir.dstu3.model.Appointment.AppointmentStatus.FULFILLED;
            case CANCELLED:
                return org.hl7.fhir.dstu3.model.Appointment.AppointmentStatus.CANCELLED;
            case NOSHOW:
                return org.hl7.fhir.dstu3.model.Appointment.AppointmentStatus.NOSHOW;
            default:
                return org.hl7.fhir.dstu3.model.Appointment.AppointmentStatus.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.Appointment.ParticipantRequired convertParticipantRequired(org.hl7.fhir.dstu3.model.Appointment.ParticipantRequired src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case REQUIRED:
                return org.hl7.fhir.dstu2.model.Appointment.ParticipantRequired.REQUIRED;
            case OPTIONAL:
                return org.hl7.fhir.dstu2.model.Appointment.ParticipantRequired.OPTIONAL;
            case INFORMATIONONLY:
                return org.hl7.fhir.dstu2.model.Appointment.ParticipantRequired.INFORMATIONONLY;
            default:
                return org.hl7.fhir.dstu2.model.Appointment.ParticipantRequired.NULL;
        }
    }

    public static org.hl7.fhir.dstu3.model.Appointment.ParticipantRequired convertParticipantRequired(org.hl7.fhir.dstu2.model.Appointment.ParticipantRequired src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case REQUIRED:
                return org.hl7.fhir.dstu3.model.Appointment.ParticipantRequired.REQUIRED;
            case OPTIONAL:
                return org.hl7.fhir.dstu3.model.Appointment.ParticipantRequired.OPTIONAL;
            case INFORMATIONONLY:
                return org.hl7.fhir.dstu3.model.Appointment.ParticipantRequired.INFORMATIONONLY;
            default:
                return org.hl7.fhir.dstu3.model.Appointment.ParticipantRequired.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.Appointment.ParticipationStatus convertParticipationStatus(org.hl7.fhir.dstu3.model.Appointment.ParticipationStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case ACCEPTED:
                return org.hl7.fhir.dstu2.model.Appointment.ParticipationStatus.ACCEPTED;
            case DECLINED:
                return org.hl7.fhir.dstu2.model.Appointment.ParticipationStatus.DECLINED;
            case TENTATIVE:
                return org.hl7.fhir.dstu2.model.Appointment.ParticipationStatus.TENTATIVE;
            case NEEDSACTION:
                return org.hl7.fhir.dstu2.model.Appointment.ParticipationStatus.NEEDSACTION;
            default:
                return org.hl7.fhir.dstu2.model.Appointment.ParticipationStatus.NULL;
        }
    }

    public static org.hl7.fhir.dstu3.model.Appointment.ParticipationStatus convertParticipationStatus(org.hl7.fhir.dstu2.model.Appointment.ParticipationStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case ACCEPTED:
                return org.hl7.fhir.dstu3.model.Appointment.ParticipationStatus.ACCEPTED;
            case DECLINED:
                return org.hl7.fhir.dstu3.model.Appointment.ParticipationStatus.DECLINED;
            case TENTATIVE:
                return org.hl7.fhir.dstu3.model.Appointment.ParticipationStatus.TENTATIVE;
            case NEEDSACTION:
                return org.hl7.fhir.dstu3.model.Appointment.ParticipationStatus.NEEDSACTION;
            default:
                return org.hl7.fhir.dstu3.model.Appointment.ParticipationStatus.NULL;
        }
    }
}
