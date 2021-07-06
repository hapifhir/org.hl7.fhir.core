package org.hl7.fhir.convertors.conv10_30.resources10_30;

import org.hl7.fhir.convertors.conv10_30.VersionConvertor_10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.Element10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.CodeableConcept10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.Identifier10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.Boolean10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.Instant10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.String10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.Reference10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class Slot10_30 {

    public static org.hl7.fhir.dstu3.model.Slot convertSlot(org.hl7.fhir.dstu2.model.Slot src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Slot tgt = new org.hl7.fhir.dstu3.model.Slot();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(Identifier10_30.convertIdentifier(t));
        if (src.hasType())
            tgt.addServiceType(CodeableConcept10_30.convertCodeableConcept(src.getType()));
        if (src.hasSchedule())
            tgt.setSchedule(Reference10_30.convertReference(src.getSchedule()));
        if (src.hasStartElement())
            tgt.setStartElement(Instant10_30.convertInstant(src.getStartElement()));
        if (src.hasEndElement())
            tgt.setEndElement(Instant10_30.convertInstant(src.getEndElement()));
        if (src.hasOverbookedElement())
            tgt.setOverbookedElement(Boolean10_30.convertBoolean(src.getOverbookedElement()));
        if (src.hasCommentElement())
            tgt.setCommentElement(String10_30.convertString(src.getCommentElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.Slot convertSlot(org.hl7.fhir.dstu3.model.Slot src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Slot tgt = new org.hl7.fhir.dstu2.model.Slot();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(Identifier10_30.convertIdentifier(t));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getServiceType()) tgt.setType(CodeableConcept10_30.convertCodeableConcept(t));
        if (src.hasSchedule())
            tgt.setSchedule(Reference10_30.convertReference(src.getSchedule()));
        if (src.hasStartElement())
            tgt.setStartElement(Instant10_30.convertInstant(src.getStartElement()));
        if (src.hasEndElement())
            tgt.setEndElement(Instant10_30.convertInstant(src.getEndElement()));
        if (src.hasOverbookedElement())
            tgt.setOverbookedElement(Boolean10_30.convertBoolean(src.getOverbookedElement()));
        if (src.hasCommentElement())
            tgt.setCommentElement(String10_30.convertString(src.getCommentElement()));
        return tgt;
    }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Slot.SlotStatus> convertSlotStatus(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Slot.SlotStatus> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Slot.SlotStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Slot.SlotStatusEnumFactory());
    Element10_30.copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.dstu3.model.Slot.SlotStatus.NULL);
    } else {
      switch (src.getValue()) {
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
        default:
          tgt.setValue(org.hl7.fhir.dstu3.model.Slot.SlotStatus.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Slot.SlotStatus> convertSlotStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Slot.SlotStatus> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Slot.SlotStatus> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Slot.SlotStatusEnumFactory());
    Element10_30.copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.dstu2.model.Slot.SlotStatus.NULL);
    } else {
      switch (src.getValue()) {
        case BUSY:
          tgt.setValue(org.hl7.fhir.dstu2.model.Slot.SlotStatus.BUSY);
          break;
        case FREE:
          tgt.setValue(org.hl7.fhir.dstu2.model.Slot.SlotStatus.FREE);
          break;
        case BUSYUNAVAILABLE:
          tgt.setValue(org.hl7.fhir.dstu2.model.Slot.SlotStatus.BUSYUNAVAILABLE);
          break;
        case BUSYTENTATIVE:
          tgt.setValue(org.hl7.fhir.dstu2.model.Slot.SlotStatus.BUSYTENTATIVE);
          break;
        default:
          tgt.setValue(org.hl7.fhir.dstu2.model.Slot.SlotStatus.NULL);
          break;
      }
    }
    return tgt;
  }
}