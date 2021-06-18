package org.hl7.fhir.convertors.conv10_50;

import org.hl7.fhir.convertors.VersionConvertor_10_50;
import org.hl7.fhir.dstu2.model.UnsignedIntType;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CodeableConcept;

public class Appointment10_50 {

    public static org.hl7.fhir.dstu2.model.Appointment convertAppointment(org.hl7.fhir.r5.model.Appointment src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Appointment tgt = new org.hl7.fhir.dstu2.model.Appointment();
        VersionConvertor_10_50.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_50.convertIdentifier(t));
        if (src.hasStatus())
            tgt.setStatusElement(convertAppointmentStatus(src.getStatusElement()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getServiceType()) tgt.setType(VersionConvertor_10_50.convertCodeableConcept(t));
        if (src.hasPriority())
            tgt.setPriorityElement(convertAppointmentPriority(src.getPriority()));
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement(VersionConvertor_10_50.convertString(src.getDescriptionElement()));
        if (src.hasStartElement())
            tgt.setStartElement(VersionConvertor_10_50.convertInstant(src.getStartElement()));
        if (src.hasEndElement())
            tgt.setEndElement(VersionConvertor_10_50.convertInstant(src.getEndElement()));
        if (src.hasMinutesDurationElement())
            tgt.setMinutesDurationElement(VersionConvertor_10_50.convertPositiveInt(src.getMinutesDurationElement()));
        for (org.hl7.fhir.r5.model.Reference t : src.getSlot()) tgt.addSlot(VersionConvertor_10_50.convertReference(t));
        if (src.hasCommentElement())
            tgt.setCommentElement(VersionConvertor_10_50.convertString(src.getCommentElement()));
        for (org.hl7.fhir.r5.model.Appointment.AppointmentParticipantComponent t : src.getParticipant()) tgt.addParticipant(convertAppointmentParticipantComponent(t));
        return tgt;
    }

    private static UnsignedIntType convertAppointmentPriority(CodeableConcept src) {
      UnsignedIntType tgt = new UnsignedIntType(convertAppointmentPriorityFromR5(src));
      VersionConvertor_10_50.copyElement(src, tgt);      
      return tgt;
    }
    
    private static CodeableConcept convertAppointmentPriority(UnsignedIntType src) {
      CodeableConcept tgt = src.hasValue() ? convertAppointmentPriorityToR5(src.getValue()) : new CodeableConcept();
      VersionConvertor_10_50.copyElement(src, tgt);      
      return tgt;
    }

    public static org.hl7.fhir.r5.model.CodeableConcept convertAppointmentPriorityToR5(int priority) {
      return null;
    }

    public static int convertAppointmentPriorityFromR5(org.hl7.fhir.r5.model.CodeableConcept priority) {
    return 0;
  }

    public static org.hl7.fhir.r5.model.Appointment convertAppointment(org.hl7.fhir.dstu2.model.Appointment src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Appointment tgt = new org.hl7.fhir.r5.model.Appointment();
        VersionConvertor_10_50.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_10_50.convertIdentifier(t));
        if (src.hasStatus())
            tgt.setStatusElement(convertAppointmentStatus(src.getStatusElement()));
        if (src.hasType())
            tgt.addServiceType(VersionConvertor_10_50.convertCodeableConcept(src.getType()));
        if (src.hasPriorityElement())
            tgt.setPriority(convertAppointmentPriority(src.getPriorityElement()));
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement(VersionConvertor_10_50.convertString(src.getDescriptionElement()));
        if (src.hasStartElement())
            tgt.setStartElement(VersionConvertor_10_50.convertInstant(src.getStartElement()));
        if (src.hasEndElement())
            tgt.setEndElement(VersionConvertor_10_50.convertInstant(src.getEndElement()));
        if (src.hasMinutesDurationElement())
            tgt.setMinutesDurationElement(VersionConvertor_10_50.convertPositiveInt(src.getMinutesDurationElement()));
        for (org.hl7.fhir.dstu2.model.Reference t : src.getSlot()) tgt.addSlot(VersionConvertor_10_50.convertReference(t));
        if (src.hasCommentElement())
            tgt.setCommentElement(VersionConvertor_10_50.convertString(src.getCommentElement()));
        for (org.hl7.fhir.dstu2.model.Appointment.AppointmentParticipantComponent t : src.getParticipant()) tgt.addParticipant(convertAppointmentParticipantComponent(t));
        return tgt;
    }


    public static org.hl7.fhir.dstu2.model.Appointment.AppointmentParticipantComponent convertAppointmentParticipantComponent(org.hl7.fhir.r5.model.Appointment.AppointmentParticipantComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Appointment.AppointmentParticipantComponent tgt = new org.hl7.fhir.dstu2.model.Appointment.AppointmentParticipantComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getType()) tgt.addType(VersionConvertor_10_50.convertCodeableConcept(t));
        if (src.hasActor())
            tgt.setActor(VersionConvertor_10_50.convertReference(src.getActor()));
        if (src.hasRequired())
            tgt.setRequiredElement(convertParticipantRequired(src.getRequiredElement()));
        if (src.hasStatus())
            tgt.setStatusElement(convertParticipationStatus(src.getStatusElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Appointment.AppointmentParticipantComponent convertAppointmentParticipantComponent(org.hl7.fhir.dstu2.model.Appointment.AppointmentParticipantComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Appointment.AppointmentParticipantComponent tgt = new org.hl7.fhir.r5.model.Appointment.AppointmentParticipantComponent();
        VersionConvertor_10_50.copyElement(src, tgt);
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getType()) tgt.addType(VersionConvertor_10_50.convertCodeableConcept(t));
        if (src.hasActor())
            tgt.setActor(VersionConvertor_10_50.convertReference(src.getActor()));
        if (src.hasRequired())
            tgt.setRequiredElement(convertParticipantRequired(src.getRequiredElement()));
        if (src.hasStatus())
            tgt.setStatusElement(convertParticipationStatus(src.getStatusElement()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Appointment.AppointmentStatus> convertAppointmentStatus(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Appointment.AppointmentStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Appointment.AppointmentStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Appointment.AppointmentStatusEnumFactory());
        VersionConvertor_10_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case PROPOSED:
                tgt.setValue(org.hl7.fhir.r5.model.Appointment.AppointmentStatus.PROPOSED);
                break;
            case PENDING:
                tgt.setValue(org.hl7.fhir.r5.model.Appointment.AppointmentStatus.PENDING);
                break;
            case BOOKED:
                tgt.setValue(org.hl7.fhir.r5.model.Appointment.AppointmentStatus.BOOKED);
                break;
            case ARRIVED:
                tgt.setValue(org.hl7.fhir.r5.model.Appointment.AppointmentStatus.ARRIVED);
                break;
            case FULFILLED:
                tgt.setValue(org.hl7.fhir.r5.model.Appointment.AppointmentStatus.FULFILLED);
                break;
            case CANCELLED:
                tgt.setValue(org.hl7.fhir.r5.model.Appointment.AppointmentStatus.CANCELLED);
                break;
            case NOSHOW:
                tgt.setValue(org.hl7.fhir.r5.model.Appointment.AppointmentStatus.NOSHOW);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Appointment.AppointmentStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Appointment.AppointmentStatus> convertAppointmentStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Appointment.AppointmentStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Appointment.AppointmentStatus> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Appointment.AppointmentStatusEnumFactory());
        VersionConvertor_10_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case PROPOSED:
                tgt.setValue(org.hl7.fhir.dstu2.model.Appointment.AppointmentStatus.PROPOSED);
                break;
            case PENDING:
                tgt.setValue(org.hl7.fhir.dstu2.model.Appointment.AppointmentStatus.PENDING);
                break;
            case BOOKED:
                tgt.setValue(org.hl7.fhir.dstu2.model.Appointment.AppointmentStatus.BOOKED);
                break;
            case ARRIVED:
                tgt.setValue(org.hl7.fhir.dstu2.model.Appointment.AppointmentStatus.ARRIVED);
                break;
            case FULFILLED:
                tgt.setValue(org.hl7.fhir.dstu2.model.Appointment.AppointmentStatus.FULFILLED);
                break;
            case CANCELLED:
                tgt.setValue(org.hl7.fhir.dstu2.model.Appointment.AppointmentStatus.CANCELLED);
                break;
            case NOSHOW:
                tgt.setValue(org.hl7.fhir.dstu2.model.Appointment.AppointmentStatus.NOSHOW);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2.model.Appointment.AppointmentStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Appointment.ParticipantRequired> convertParticipantRequired(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Appointment.ParticipantRequired> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Appointment.ParticipantRequired> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Appointment.ParticipantRequiredEnumFactory());
        VersionConvertor_10_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case REQUIRED:
                tgt.setValue(org.hl7.fhir.dstu2.model.Appointment.ParticipantRequired.REQUIRED);
                break;
            case OPTIONAL:
                tgt.setValue(org.hl7.fhir.dstu2.model.Appointment.ParticipantRequired.OPTIONAL);
                break;
            case INFORMATIONONLY:
                tgt.setValue(org.hl7.fhir.dstu2.model.Appointment.ParticipantRequired.INFORMATIONONLY);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2.model.Appointment.ParticipantRequired.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Appointment.ParticipantRequired> convertParticipantRequired(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Appointment.ParticipantRequired> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Appointment.ParticipantRequired> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Appointment.ParticipantRequiredEnumFactory());
        VersionConvertor_10_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case REQUIRED:
                tgt.setValue(org.hl7.fhir.r5.model.Appointment.ParticipantRequired.REQUIRED);
                break;
            case OPTIONAL:
                tgt.setValue(org.hl7.fhir.r5.model.Appointment.ParticipantRequired.OPTIONAL);
                break;
            case INFORMATIONONLY:
                tgt.setValue(org.hl7.fhir.r5.model.Appointment.ParticipantRequired.INFORMATIONONLY);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Appointment.ParticipantRequired.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ParticipationStatus> convertParticipationStatus(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Appointment.ParticipationStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ParticipationStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.ParticipationStatusEnumFactory());
        VersionConvertor_10_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case ACCEPTED:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ParticipationStatus.ACCEPTED);
                break;
            case DECLINED:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ParticipationStatus.DECLINED);
                break;
            case TENTATIVE:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ParticipationStatus.TENTATIVE);
                break;
            case NEEDSACTION:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ParticipationStatus.NEEDSACTION);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.ParticipationStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Appointment.ParticipationStatus> convertParticipationStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.ParticipationStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Appointment.ParticipationStatus> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Appointment.ParticipationStatusEnumFactory());
        VersionConvertor_10_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case ACCEPTED:
                tgt.setValue(org.hl7.fhir.dstu2.model.Appointment.ParticipationStatus.ACCEPTED);
                break;
            case DECLINED:
                tgt.setValue(org.hl7.fhir.dstu2.model.Appointment.ParticipationStatus.DECLINED);
                break;
            case TENTATIVE:
                tgt.setValue(org.hl7.fhir.dstu2.model.Appointment.ParticipationStatus.TENTATIVE);
                break;
            case NEEDSACTION:
                tgt.setValue(org.hl7.fhir.dstu2.model.Appointment.ParticipationStatus.NEEDSACTION);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2.model.Appointment.ParticipationStatus.NULL);
                break;
        }
        return tgt;
    }
}