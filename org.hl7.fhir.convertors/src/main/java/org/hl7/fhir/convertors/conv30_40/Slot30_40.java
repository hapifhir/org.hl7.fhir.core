package org.hl7.fhir.convertors.conv30_40;

import org.hl7.fhir.convertors.VersionConvertor_30_40;
import org.hl7.fhir.exceptions.FHIRException;
import java.util.Collections;

public class Slot30_40 {

    public static org.hl7.fhir.r4.model.Slot convertSlot(org.hl7.fhir.dstu3.model.Slot src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Slot tgt = new org.hl7.fhir.r4.model.Slot();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        }
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
        if (src.hasSchedule())
            tgt.setSchedule(VersionConvertor_30_40.convertReference(src.getSchedule()));
        if (src.hasStatus())
            tgt.setStatus(convertSlotStatus(src.getStatus()));
        if (src.hasStart())
            tgt.setStartElement(VersionConvertor_30_40.convertInstant(src.getStartElement()));
        if (src.hasEndElement())
            tgt.setEndElement((org.hl7.fhir.r4.model.InstantType) VersionConvertor_30_40.convertType(src.getEndElement()));
        if (src.hasOverbookedElement())
            tgt.setOverbookedElement((org.hl7.fhir.r4.model.BooleanType) VersionConvertor_30_40.convertType(src.getOverbookedElement()));
        if (src.hasCommentElement())
            tgt.setCommentElement((org.hl7.fhir.r4.model.StringType) VersionConvertor_30_40.convertType(src.getCommentElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Slot convertSlot(org.hl7.fhir.r4.model.Slot src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Slot tgt = new org.hl7.fhir.dstu3.model.Slot();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(t));
        }
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
        if (src.hasSchedule())
            tgt.setSchedule(VersionConvertor_30_40.convertReference(src.getSchedule()));
        if (src.hasStatus())
            tgt.setStatus(convertSlotStatus(src.getStatus()));
        if (src.hasStart())
            tgt.setStartElement(VersionConvertor_30_40.convertInstant(src.getStartElement()));
        if (src.hasEndElement())
            tgt.setEndElement((org.hl7.fhir.dstu3.model.InstantType) VersionConvertor_30_40.convertType(src.getEndElement()));
        if (src.hasOverbookedElement())
            tgt.setOverbookedElement((org.hl7.fhir.dstu3.model.BooleanType) VersionConvertor_30_40.convertType(src.getOverbookedElement()));
        if (src.hasCommentElement())
            tgt.setCommentElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_40.convertType(src.getCommentElement()));
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
