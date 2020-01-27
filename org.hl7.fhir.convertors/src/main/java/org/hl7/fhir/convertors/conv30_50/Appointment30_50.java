package org.hl7.fhir.convertors.conv30_50;

import org.hl7.fhir.convertors.VersionConvertor_30_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CodeableReference;

public class Appointment30_50 {

    public static org.hl7.fhir.dstu3.model.Appointment convertAppointment(org.hl7.fhir.r5.model.Appointment src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Appointment tgt = new org.hl7.fhir.dstu3.model.Appointment();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(t));
        if (src.hasStatus())
            tgt.setStatus(convertAppointmentStatus(src.getStatus()));
        if (src.hasServiceCategory())
            tgt.setServiceCategory(VersionConvertor_30_50.convertCodeableConcept(src.getServiceCategoryFirstRep()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getServiceType()) tgt.addServiceType(VersionConvertor_30_50.convertCodeableConcept(t));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getSpecialty()) tgt.addSpecialty(VersionConvertor_30_50.convertCodeableConcept(t));
        if (src.hasAppointmentType())
            tgt.setAppointmentType(VersionConvertor_30_50.convertCodeableConcept(src.getAppointmentType()));
        for (CodeableReference t : src.getReason()) if (t.hasConcept())
            tgt.addReason(VersionConvertor_30_50.convertCodeableConcept(t.getConcept()));
        for (CodeableReference t : src.getReason()) if (t.hasReference())
            tgt.addIndication(VersionConvertor_30_50.convertReference(t.getReference()));
        if (src.hasPriority())
            tgt.setPriority(src.getPriority());
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.r5.model.Reference t : src.getSupportingInformation()) tgt.addSupportingInformation(VersionConvertor_30_50.convertReference(t));
        if (src.hasStart())
            tgt.setStart(src.getStart());
        if (src.hasEnd())
            tgt.setEnd(src.getEnd());
        if (src.hasMinutesDuration())
            tgt.setMinutesDuration(src.getMinutesDuration());
        for (org.hl7.fhir.r5.model.Reference t : src.getSlot()) tgt.addSlot(VersionConvertor_30_50.convertReference(t));
        if (src.hasCreated())
            tgt.setCreated(src.getCreated());
        if (src.hasComment())
            tgt.setComment(src.getComment());
        for (org.hl7.fhir.r5.model.Reference t : src.getBasedOn()) tgt.addIncomingReferral(VersionConvertor_30_50.convertReference(t));
        for (org.hl7.fhir.r5.model.Appointment.AppointmentParticipantComponent t : src.getParticipant()) tgt.addParticipant(convertAppointmentParticipantComponent(t));
        for (org.hl7.fhir.r5.model.Period t : src.getRequestedPeriod()) tgt.addRequestedPeriod(VersionConvertor_30_50.convertPeriod(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Appointment convertAppointment(org.hl7.fhir.dstu3.model.Appointment src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Appointment tgt = new org.hl7.fhir.r5.model.Appointment();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(t));
        if (src.hasStatus())
            tgt.setStatus(convertAppointmentStatus(src.getStatus()));
        if (src.hasServiceCategory())
            tgt.addServiceCategory(VersionConvertor_30_50.convertCodeableConcept(src.getServiceCategory()));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getServiceType()) tgt.addServiceType(VersionConvertor_30_50.convertCodeableConcept(t));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getSpecialty()) tgt.addSpecialty(VersionConvertor_30_50.convertCodeableConcept(t));
        if (src.hasAppointmentType())
            tgt.setAppointmentType(VersionConvertor_30_50.convertCodeableConcept(src.getAppointmentType()));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getReason()) tgt.addReason(VersionConvertor_30_50.convertCodeableConceptToCodableReference(t));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getIndication()) tgt.addReason(VersionConvertor_30_50.convertReferenceToCodableReference(t));
        if (src.hasPriority())
            tgt.setPriority(src.getPriority());
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.dstu3.model.Reference t : src.getSupportingInformation()) tgt.addSupportingInformation(VersionConvertor_30_50.convertReference(t));
        if (src.hasStart())
            tgt.setStart(src.getStart());
        if (src.hasEnd())
            tgt.setEnd(src.getEnd());
        if (src.hasMinutesDuration())
            tgt.setMinutesDuration(src.getMinutesDuration());
        for (org.hl7.fhir.dstu3.model.Reference t : src.getSlot()) tgt.addSlot(VersionConvertor_30_50.convertReference(t));
        if (src.hasCreated())
            tgt.setCreated(src.getCreated());
        if (src.hasComment())
            tgt.setComment(src.getComment());
        for (org.hl7.fhir.dstu3.model.Reference t : src.getIncomingReferral()) tgt.addBasedOn(VersionConvertor_30_50.convertReference(t));
        for (org.hl7.fhir.dstu3.model.Appointment.AppointmentParticipantComponent t : src.getParticipant()) tgt.addParticipant(convertAppointmentParticipantComponent(t));
        for (org.hl7.fhir.dstu3.model.Period t : src.getRequestedPeriod()) tgt.addRequestedPeriod(VersionConvertor_30_50.convertPeriod(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Appointment.AppointmentParticipantComponent convertAppointmentParticipantComponent(org.hl7.fhir.r5.model.Appointment.AppointmentParticipantComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Appointment.AppointmentParticipantComponent tgt = new org.hl7.fhir.dstu3.model.Appointment.AppointmentParticipantComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getType()) tgt.addType(VersionConvertor_30_50.convertCodeableConcept(t));
        if (src.hasActor())
            tgt.setActor(VersionConvertor_30_50.convertReference(src.getActor()));
        if (src.hasRequired())
            tgt.setRequired(convertParticipantRequired(src.getRequired()));
        if (src.hasStatus())
            tgt.setStatus(convertParticipationStatus(src.getStatus()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Appointment.AppointmentParticipantComponent convertAppointmentParticipantComponent(org.hl7.fhir.dstu3.model.Appointment.AppointmentParticipantComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Appointment.AppointmentParticipantComponent tgt = new org.hl7.fhir.r5.model.Appointment.AppointmentParticipantComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getType()) tgt.addType(VersionConvertor_30_50.convertCodeableConcept(t));
        if (src.hasActor())
            tgt.setActor(VersionConvertor_30_50.convertReference(src.getActor()));
        if (src.hasRequired())
            tgt.setRequired(convertParticipantRequired(src.getRequired()));
        if (src.hasStatus())
            tgt.setStatus(convertParticipationStatus(src.getStatus()));
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Appointment.AppointmentStatus convertAppointmentStatus(org.hl7.fhir.r5.model.Appointment.AppointmentStatus src) throws FHIRException {
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
            case ENTEREDINERROR:
                return org.hl7.fhir.dstu3.model.Appointment.AppointmentStatus.ENTEREDINERROR;
            default:
                return org.hl7.fhir.dstu3.model.Appointment.AppointmentStatus.NULL;
        }
    }

    static public org.hl7.fhir.r5.model.Appointment.AppointmentStatus convertAppointmentStatus(org.hl7.fhir.dstu3.model.Appointment.AppointmentStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case PROPOSED:
                return org.hl7.fhir.r5.model.Appointment.AppointmentStatus.PROPOSED;
            case PENDING:
                return org.hl7.fhir.r5.model.Appointment.AppointmentStatus.PENDING;
            case BOOKED:
                return org.hl7.fhir.r5.model.Appointment.AppointmentStatus.BOOKED;
            case ARRIVED:
                return org.hl7.fhir.r5.model.Appointment.AppointmentStatus.ARRIVED;
            case FULFILLED:
                return org.hl7.fhir.r5.model.Appointment.AppointmentStatus.FULFILLED;
            case CANCELLED:
                return org.hl7.fhir.r5.model.Appointment.AppointmentStatus.CANCELLED;
            case NOSHOW:
                return org.hl7.fhir.r5.model.Appointment.AppointmentStatus.NOSHOW;
            case ENTEREDINERROR:
                return org.hl7.fhir.r5.model.Appointment.AppointmentStatus.ENTEREDINERROR;
            default:
                return org.hl7.fhir.r5.model.Appointment.AppointmentStatus.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.Appointment.ParticipantRequired convertParticipantRequired(org.hl7.fhir.r5.model.Appointment.ParticipantRequired src) throws FHIRException {
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

    static public org.hl7.fhir.r5.model.Appointment.ParticipantRequired convertParticipantRequired(org.hl7.fhir.dstu3.model.Appointment.ParticipantRequired src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case REQUIRED:
                return org.hl7.fhir.r5.model.Appointment.ParticipantRequired.REQUIRED;
            case OPTIONAL:
                return org.hl7.fhir.r5.model.Appointment.ParticipantRequired.OPTIONAL;
            case INFORMATIONONLY:
                return org.hl7.fhir.r5.model.Appointment.ParticipantRequired.INFORMATIONONLY;
            default:
                return org.hl7.fhir.r5.model.Appointment.ParticipantRequired.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.Appointment.ParticipationStatus convertParticipationStatus(org.hl7.fhir.r5.model.Enumerations.ParticipationStatus src) throws FHIRException {
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

    static public org.hl7.fhir.r5.model.Enumerations.ParticipationStatus convertParticipationStatus(org.hl7.fhir.dstu3.model.Appointment.ParticipationStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case ACCEPTED:
                return org.hl7.fhir.r5.model.Enumerations.ParticipationStatus.ACCEPTED;
            case DECLINED:
                return org.hl7.fhir.r5.model.Enumerations.ParticipationStatus.DECLINED;
            case TENTATIVE:
                return org.hl7.fhir.r5.model.Enumerations.ParticipationStatus.TENTATIVE;
            case NEEDSACTION:
                return org.hl7.fhir.r5.model.Enumerations.ParticipationStatus.NEEDSACTION;
            default:
                return org.hl7.fhir.r5.model.Enumerations.ParticipationStatus.NULL;
        }
    }
}
