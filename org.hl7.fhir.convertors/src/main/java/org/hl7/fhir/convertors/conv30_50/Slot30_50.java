package org.hl7.fhir.convertors.conv30_50;

import org.hl7.fhir.convertors.VersionConvertor_30_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Slot30_50 {

    public static org.hl7.fhir.r5.model.Slot convertSlot(org.hl7.fhir.dstu3.model.Slot src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Slot tgt = new org.hl7.fhir.r5.model.Slot();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(t));
        if (src.hasServiceCategory())
            tgt.addServiceCategory(VersionConvertor_30_50.convertCodeableConcept(src.getServiceCategory()));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getServiceType()) tgt.addServiceType(VersionConvertor_30_50.convertCodeableConcept(t));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getSpecialty()) tgt.addSpecialty(VersionConvertor_30_50.convertCodeableConcept(t));
        if (src.hasAppointmentType())
            tgt.setAppointmentType(VersionConvertor_30_50.convertCodeableConcept(src.getAppointmentType()));
        if (src.hasSchedule())
            tgt.setSchedule(VersionConvertor_30_50.convertReference(src.getSchedule()));
        if (src.hasStatus())
            tgt.setStatusElement(convertSlotStatus(src.getStatusElement()));
        if (src.hasStart())
            tgt.setStartElement(VersionConvertor_30_50.convertInstant(src.getStartElement()));
        if (src.hasEnd())
            tgt.setEndElement(VersionConvertor_30_50.convertInstant(src.getEndElement()));
        if (src.hasOverbooked())
            tgt.setOverbookedElement(VersionConvertor_30_50.convertBoolean(src.getOverbookedElement()));
        if (src.hasComment())
            tgt.setCommentElement(VersionConvertor_30_50.convertString(src.getCommentElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Slot convertSlot(org.hl7.fhir.r5.model.Slot src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Slot tgt = new org.hl7.fhir.dstu3.model.Slot();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(t));
        if (src.hasServiceCategory())
            tgt.setServiceCategory(VersionConvertor_30_50.convertCodeableConcept(src.getServiceCategoryFirstRep()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getServiceType()) tgt.addServiceType(VersionConvertor_30_50.convertCodeableConcept(t));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getSpecialty()) tgt.addSpecialty(VersionConvertor_30_50.convertCodeableConcept(t));
        if (src.hasAppointmentType())
            tgt.setAppointmentType(VersionConvertor_30_50.convertCodeableConcept(src.getAppointmentType()));
        if (src.hasSchedule())
            tgt.setSchedule(VersionConvertor_30_50.convertReference(src.getSchedule()));
        if (src.hasStatus())
            tgt.setStatusElement(convertSlotStatus(src.getStatusElement()));
        if (src.hasStart())
            tgt.setStartElement(VersionConvertor_30_50.convertInstant(src.getStartElement()));
        if (src.hasEnd())
            tgt.setEndElement(VersionConvertor_30_50.convertInstant(src.getEndElement()));
        if (src.hasOverbooked())
            tgt.setOverbookedElement(VersionConvertor_30_50.convertBoolean(src.getOverbookedElement()));
        if (src.hasComment())
            tgt.setCommentElement(VersionConvertor_30_50.convertString(src.getCommentElement()));
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Slot.SlotStatus> convertSlotStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Slot.SlotStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Slot.SlotStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Slot.SlotStatusEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case BUSY:
                tgt.setValue(org.hl7.fhir.dstu3.model.Slot.SlotStatus.BUSY);
                break;
            case FREE:
                tgt.setValue(org.hl7.fhir.dstu3.model.Slot.SlotStatus.FREE);
                break;
            case BUSYUNAVAILABLE:
                tgt.setValue(org.hl7.fhir.dstu3.model.Slot.SlotStatus.BUSYUNAVAILABLE);
                break;
            case BUSYTENTATIVE:
                tgt.setValue(org.hl7.fhir.dstu3.model.Slot.SlotStatus.BUSYTENTATIVE);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.dstu3.model.Slot.SlotStatus.ENTEREDINERROR);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.Slot.SlotStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Slot.SlotStatus> convertSlotStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Slot.SlotStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Slot.SlotStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Slot.SlotStatusEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case BUSY:
                tgt.setValue(org.hl7.fhir.r5.model.Slot.SlotStatus.BUSY);
                break;
            case FREE:
                tgt.setValue(org.hl7.fhir.r5.model.Slot.SlotStatus.FREE);
                break;
            case BUSYUNAVAILABLE:
                tgt.setValue(org.hl7.fhir.r5.model.Slot.SlotStatus.BUSYUNAVAILABLE);
                break;
            case BUSYTENTATIVE:
                tgt.setValue(org.hl7.fhir.r5.model.Slot.SlotStatus.BUSYTENTATIVE);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.r5.model.Slot.SlotStatus.ENTEREDINERROR);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Slot.SlotStatus.NULL);
                break;
        }
        return tgt;
    }
}