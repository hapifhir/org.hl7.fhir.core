package org.hl7.fhir.convertors.conv30_40;

import org.hl7.fhir.convertors.VersionConvertor_30_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Slot30_40 {

    public static org.hl7.fhir.r4.model.Slot convertSlot(org.hl7.fhir.dstu3.model.Slot src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Slot tgt = new org.hl7.fhir.r4.model.Slot();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        if (src.hasServiceCategory())
            tgt.addServiceCategory(VersionConvertor_30_40.convertCodeableConcept(src.getServiceCategory()));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getServiceType()) tgt.addServiceType(VersionConvertor_30_40.convertCodeableConcept(t));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getSpecialty()) tgt.addSpecialty(VersionConvertor_30_40.convertCodeableConcept(t));
        if (src.hasAppointmentType())
            tgt.setAppointmentType(VersionConvertor_30_40.convertCodeableConcept(src.getAppointmentType()));
        if (src.hasSchedule())
            tgt.setSchedule(VersionConvertor_30_40.convertReference(src.getSchedule()));
        if (src.hasStatus())
            tgt.setStatus(convertSlotStatus(src.getStatus()));
        if (src.hasStart())
            tgt.setStartElement(VersionConvertor_30_40.convertInstant(src.getStartElement()));
        if (src.hasEnd())
            tgt.setEndElement(VersionConvertor_30_40.convertInstant(src.getEndElement()));
        if (src.hasOverbooked())
            tgt.setOverbookedElement(VersionConvertor_30_40.convertBoolean(src.getOverbookedElement()));
        if (src.hasComment())
            tgt.setCommentElement(VersionConvertor_30_40.convertString(src.getCommentElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Slot convertSlot(org.hl7.fhir.r4.model.Slot src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Slot tgt = new org.hl7.fhir.dstu3.model.Slot();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        if (src.hasServiceCategory())
            tgt.setServiceCategory(VersionConvertor_30_40.convertCodeableConcept(src.getServiceCategoryFirstRep()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getServiceType()) tgt.addServiceType(VersionConvertor_30_40.convertCodeableConcept(t));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getSpecialty()) tgt.addSpecialty(VersionConvertor_30_40.convertCodeableConcept(t));
        if (src.hasAppointmentType())
            tgt.setAppointmentType(VersionConvertor_30_40.convertCodeableConcept(src.getAppointmentType()));
        if (src.hasSchedule())
            tgt.setSchedule(VersionConvertor_30_40.convertReference(src.getSchedule()));
        if (src.hasStatus())
            tgt.setStatus(convertSlotStatus(src.getStatus()));
        if (src.hasStart())
            tgt.setStartElement(VersionConvertor_30_40.convertInstant(src.getStartElement()));
        if (src.hasEnd())
            tgt.setEndElement(VersionConvertor_30_40.convertInstant(src.getEndElement()));
        if (src.hasOverbooked())
            tgt.setOverbookedElement(VersionConvertor_30_40.convertBoolean(src.getOverbookedElement()));
        if (src.hasComment())
            tgt.setCommentElement(VersionConvertor_30_40.convertString(src.getCommentElement()));
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Slot.SlotStatus convertSlotStatus(org.hl7.fhir.dstu3.model.Slot.SlotStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case BUSY:
                return org.hl7.fhir.r4.model.Slot.SlotStatus.BUSY;
            case FREE:
                return org.hl7.fhir.r4.model.Slot.SlotStatus.FREE;
            case BUSYUNAVAILABLE:
                return org.hl7.fhir.r4.model.Slot.SlotStatus.BUSYUNAVAILABLE;
            case BUSYTENTATIVE:
                return org.hl7.fhir.r4.model.Slot.SlotStatus.BUSYTENTATIVE;
            case ENTEREDINERROR:
                return org.hl7.fhir.r4.model.Slot.SlotStatus.ENTEREDINERROR;
            default:
                return org.hl7.fhir.r4.model.Slot.SlotStatus.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.Slot.SlotStatus convertSlotStatus(org.hl7.fhir.r4.model.Slot.SlotStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case BUSY:
                return org.hl7.fhir.dstu3.model.Slot.SlotStatus.BUSY;
            case FREE:
                return org.hl7.fhir.dstu3.model.Slot.SlotStatus.FREE;
            case BUSYUNAVAILABLE:
                return org.hl7.fhir.dstu3.model.Slot.SlotStatus.BUSYUNAVAILABLE;
            case BUSYTENTATIVE:
                return org.hl7.fhir.dstu3.model.Slot.SlotStatus.BUSYTENTATIVE;
            case ENTEREDINERROR:
                return org.hl7.fhir.dstu3.model.Slot.SlotStatus.ENTEREDINERROR;
            default:
                return org.hl7.fhir.dstu3.model.Slot.SlotStatus.NULL;
        }
    }
}
