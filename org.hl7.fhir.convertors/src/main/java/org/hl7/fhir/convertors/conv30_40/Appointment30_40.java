package org.hl7.fhir.convertors.conv30_40;

import org.hl7.fhir.convertors.VersionConvertor_30_40;
import org.hl7.fhir.exceptions.FHIRException;
import java.util.Collections;

public class Appointment30_40 {

    public static org.hl7.fhir.r4.model.Appointment convertAppointment(org.hl7.fhir.dstu3.model.Appointment src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Appointment tgt = new org.hl7.fhir.r4.model.Appointment();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        }
        if (src.hasStatus())
            tgt.setStatus(convertAppointmentStatus(src.getStatus()));
        if (src.hasServiceCategory())
            tgt.addServiceCategory(VersionConvertor_30_40.convertCodeableConcept(src.getServiceCategory()));
        if (src.hasServiceType()) {
            for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getServiceType()) tgt.addServiceType(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        if (src.hasSpecialty()) {
            for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getSpecialty()) tgt.addSpecialty(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        if (src.hasAppointmentType())
            tgt.setAppointmentType(VersionConvertor_30_40.convertCodeableConcept(src.getAppointmentType()));
        if (src.hasReason()) {
            for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getReason()) tgt.addReasonCode(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        if (src.hasIndication()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getIndication()) tgt.addReasonReference(VersionConvertor_30_40.convertReference(t));
        }
        if (src.hasPriorityElement())
            tgt.setPriorityElement((org.hl7.fhir.r4.model.UnsignedIntType) VersionConvertor_30_40.convertType(src.getPriorityElement()));
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.r4.model.StringType) VersionConvertor_30_40.convertType(src.getDescriptionElement()));
        if (src.hasSupportingInformation()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getSupportingInformation()) tgt.addSupportingInformation(VersionConvertor_30_40.convertReference(t));
        }
        if (src.hasStart())
            tgt.setStartElement(VersionConvertor_30_40.convertInstant(src.getStartElement()));
        if (src.hasEndElement())
            tgt.setEndElement((org.hl7.fhir.r4.model.InstantType) VersionConvertor_30_40.convertType(src.getEndElement()));
        if (src.hasMinutesDurationElement())
            tgt.setMinutesDurationElement((org.hl7.fhir.r4.model.PositiveIntType) VersionConvertor_30_40.convertType(src.getMinutesDurationElement()));
        if (src.hasSlot()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getSlot()) tgt.addSlot(VersionConvertor_30_40.convertReference(t));
        }
        if (src.hasCreated())
            tgt.setCreatedElement(VersionConvertor_30_40.convertDateTime(src.getCreatedElement()));
        if (src.hasCommentElement())
            tgt.setCommentElement((org.hl7.fhir.r4.model.StringType) VersionConvertor_30_40.convertType(src.getCommentElement()));
        if (src.hasIncomingReferral()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getIncomingReferral()) tgt.addBasedOn(VersionConvertor_30_40.convertReference(t));
        }
        if (src.hasParticipant()) {
            for (org.hl7.fhir.dstu3.model.Appointment.AppointmentParticipantComponent t : src.getParticipant()) tgt.addParticipant(convertAppointmentParticipantComponent(t));
        }
        if (src.hasRequestedPeriod()) {
            for (org.hl7.fhir.dstu3.model.Period t : src.getRequestedPeriod()) tgt.addRequestedPeriod(VersionConvertor_30_40.convertPeriod(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Appointment convertAppointment(org.hl7.fhir.r4.model.Appointment src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Appointment tgt = new org.hl7.fhir.dstu3.model.Appointment();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        }
        if (src.hasStatus())
            tgt.setStatus(convertAppointmentStatus(src.getStatus()));
        if (src.hasServiceCategory())
            tgt.setServiceCategory(VersionConvertor_30_40.convertCodeableConcept(src.getServiceCategoryFirstRep()));
        if (src.hasServiceType()) {
            for (org.hl7.fhir.r4.model.CodeableConcept t : src.getServiceType()) tgt.addServiceType(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        if (src.hasSpecialty()) {
            for (org.hl7.fhir.r4.model.CodeableConcept t : src.getSpecialty()) tgt.addSpecialty(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        if (src.hasAppointmentType())
            tgt.setAppointmentType(VersionConvertor_30_40.convertCodeableConcept(src.getAppointmentType()));
        if (src.hasReasonCode()) {
            for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReasonCode()) tgt.addReason(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        if (src.hasReasonReference()) {
            for (org.hl7.fhir.r4.model.Reference t : src.getReasonReference()) tgt.addIndication(VersionConvertor_30_40.convertReference(t));
        }
        if (src.hasPriorityElement())
            tgt.setPriorityElement((org.hl7.fhir.dstu3.model.UnsignedIntType) VersionConvertor_30_40.convertType(src.getPriorityElement()));
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_40.convertType(src.getDescriptionElement()));
        if (src.hasSupportingInformation()) {
            for (org.hl7.fhir.r4.model.Reference t : src.getSupportingInformation()) tgt.addSupportingInformation(VersionConvertor_30_40.convertReference(t));
        }
        if (src.hasStart())
            tgt.setStartElement(VersionConvertor_30_40.convertInstant(src.getStartElement()));
        if (src.hasEndElement())
            tgt.setEndElement((org.hl7.fhir.dstu3.model.InstantType) VersionConvertor_30_40.convertType(src.getEndElement()));
        if (src.hasMinutesDurationElement())
            tgt.setMinutesDurationElement((org.hl7.fhir.dstu3.model.PositiveIntType) VersionConvertor_30_40.convertType(src.getMinutesDurationElement()));
        if (src.hasSlot()) {
            for (org.hl7.fhir.r4.model.Reference t : src.getSlot()) tgt.addSlot(VersionConvertor_30_40.convertReference(t));
        }
        if (src.hasCreated())
            tgt.setCreatedElement(VersionConvertor_30_40.convertDateTime(src.getCreatedElement()));
        if (src.hasCommentElement())
            tgt.setCommentElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_40.convertType(src.getCommentElement()));
        if (src.hasBasedOn()) {
            for (org.hl7.fhir.r4.model.Reference t : src.getBasedOn()) tgt.addIncomingReferral(VersionConvertor_30_40.convertReference(t));
        }
        if (src.hasParticipant()) {
            for (org.hl7.fhir.r4.model.Appointment.AppointmentParticipantComponent t : src.getParticipant()) tgt.addParticipant(convertAppointmentParticipantComponent(t));
        }
        if (src.hasRequestedPeriod()) {
            for (org.hl7.fhir.r4.model.Period t : src.getRequestedPeriod()) tgt.addRequestedPeriod(VersionConvertor_30_40.convertPeriod(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Appointment.AppointmentParticipantComponent convertAppointmentParticipantComponent(org.hl7.fhir.r4.model.Appointment.AppointmentParticipantComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Appointment.AppointmentParticipantComponent tgt = new org.hl7.fhir.dstu3.model.Appointment.AppointmentParticipantComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasType()) {
            for (org.hl7.fhir.r4.model.CodeableConcept t : src.getType()) tgt.addType(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        if (src.hasActor())
            tgt.setActor(VersionConvertor_30_40.convertReference(src.getActor()));
        if (src.hasRequired())
            tgt.setRequired(convertParticipantRequired(src.getRequired()));
        if (src.hasStatus())
            tgt.setStatus(convertParticipationStatus(src.getStatus()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Appointment.AppointmentParticipantComponent convertAppointmentParticipantComponent(org.hl7.fhir.dstu3.model.Appointment.AppointmentParticipantComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Appointment.AppointmentParticipantComponent tgt = new org.hl7.fhir.r4.model.Appointment.AppointmentParticipantComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasType()) {
            for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getType()) tgt.addType(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        if (src.hasActor())
            tgt.setActor(VersionConvertor_30_40.convertReference(src.getActor()));
        if (src.hasRequired())
            tgt.setRequired(convertParticipantRequired(src.getRequired()));
        if (src.hasStatus())
            tgt.setStatus(convertParticipationStatus(src.getStatus()));
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Appointment.AppointmentStatus convertAppointmentStatus(org.hl7.fhir.r4.model.Appointment.AppointmentStatus src) throws FHIRException {
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

    static public org.hl7.fhir.r4.model.Appointment.AppointmentStatus convertAppointmentStatus(org.hl7.fhir.dstu3.model.Appointment.AppointmentStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case PROPOSED:
                return org.hl7.fhir.r4.model.Appointment.AppointmentStatus.PROPOSED;
            case PENDING:
                return org.hl7.fhir.r4.model.Appointment.AppointmentStatus.PENDING;
            case BOOKED:
                return org.hl7.fhir.r4.model.Appointment.AppointmentStatus.BOOKED;
            case ARRIVED:
                return org.hl7.fhir.r4.model.Appointment.AppointmentStatus.ARRIVED;
            case FULFILLED:
                return org.hl7.fhir.r4.model.Appointment.AppointmentStatus.FULFILLED;
            case CANCELLED:
                return org.hl7.fhir.r4.model.Appointment.AppointmentStatus.CANCELLED;
            case NOSHOW:
                return org.hl7.fhir.r4.model.Appointment.AppointmentStatus.NOSHOW;
            case ENTEREDINERROR:
                return org.hl7.fhir.r4.model.Appointment.AppointmentStatus.ENTEREDINERROR;
            default:
                return org.hl7.fhir.r4.model.Appointment.AppointmentStatus.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.Appointment.ParticipantRequired convertParticipantRequired(org.hl7.fhir.r4.model.Appointment.ParticipantRequired src) throws FHIRException {
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

    static public org.hl7.fhir.r4.model.Appointment.ParticipantRequired convertParticipantRequired(org.hl7.fhir.dstu3.model.Appointment.ParticipantRequired src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case REQUIRED:
                return org.hl7.fhir.r4.model.Appointment.ParticipantRequired.REQUIRED;
            case OPTIONAL:
                return org.hl7.fhir.r4.model.Appointment.ParticipantRequired.OPTIONAL;
            case INFORMATIONONLY:
                return org.hl7.fhir.r4.model.Appointment.ParticipantRequired.INFORMATIONONLY;
            default:
                return org.hl7.fhir.r4.model.Appointment.ParticipantRequired.NULL;
        }
    }

    static public org.hl7.fhir.r4.model.Appointment.ParticipationStatus convertParticipationStatus(org.hl7.fhir.dstu3.model.Appointment.ParticipationStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case ACCEPTED:
                return org.hl7.fhir.r4.model.Appointment.ParticipationStatus.ACCEPTED;
            case DECLINED:
                return org.hl7.fhir.r4.model.Appointment.ParticipationStatus.DECLINED;
            case TENTATIVE:
                return org.hl7.fhir.r4.model.Appointment.ParticipationStatus.TENTATIVE;
            case NEEDSACTION:
                return org.hl7.fhir.r4.model.Appointment.ParticipationStatus.NEEDSACTION;
            default:
                return org.hl7.fhir.r4.model.Appointment.ParticipationStatus.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.Appointment.ParticipationStatus convertParticipationStatus(org.hl7.fhir.r4.model.Appointment.ParticipationStatus src) throws FHIRException {
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
