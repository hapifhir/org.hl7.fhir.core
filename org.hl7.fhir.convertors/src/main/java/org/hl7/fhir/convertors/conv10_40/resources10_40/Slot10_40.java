package org.hl7.fhir.convertors.conv10_40.resources10_40;

import org.hl7.fhir.convertors.context.ConversionContext10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.Reference10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.CodeableConcept10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.complextypes10_40.Identifier10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.Boolean10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.Instant10_40;
import org.hl7.fhir.convertors.conv10_40.datatypes10_40.primitivetypes10_40.String10_40;
import org.hl7.fhir.exceptions.FHIRException;

public class Slot10_40 {

  public static org.hl7.fhir.r4.model.Slot convertSlot(org.hl7.fhir.dstu2.model.Slot src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Slot tgt = new org.hl7.fhir.r4.model.Slot();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_40.convertIdentifier(t));
    if (src.hasType())
      tgt.addServiceType(CodeableConcept10_40.convertCodeableConcept(src.getType()));
    if (src.hasSchedule())
      tgt.setSchedule(Reference10_40.convertReference(src.getSchedule()));
    if (src.hasStartElement())
      tgt.setStartElement(Instant10_40.convertInstant(src.getStartElement()));
    if (src.hasEndElement())
      tgt.setEndElement(Instant10_40.convertInstant(src.getEndElement()));
    if (src.hasOverbookedElement())
      tgt.setOverbookedElement(Boolean10_40.convertBoolean(src.getOverbookedElement()));
    if (src.hasCommentElement())
      tgt.setCommentElement(String10_40.convertString(src.getCommentElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Slot convertSlot(org.hl7.fhir.r4.model.Slot src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Slot tgt = new org.hl7.fhir.dstu2.model.Slot();
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_40.convertIdentifier(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getServiceType())
      tgt.setType(CodeableConcept10_40.convertCodeableConcept(t));
    if (src.hasSchedule())
      tgt.setSchedule(Reference10_40.convertReference(src.getSchedule()));
    if (src.hasStartElement())
      tgt.setStartElement(Instant10_40.convertInstant(src.getStartElement()));
    if (src.hasEndElement())
      tgt.setEndElement(Instant10_40.convertInstant(src.getEndElement()));
    if (src.hasOverbookedElement())
      tgt.setOverbookedElement(Boolean10_40.convertBoolean(src.getOverbookedElement()));
    if (src.hasCommentElement())
      tgt.setCommentElement(String10_40.convertString(src.getCommentElement()));
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Slot.SlotStatus> convertSlotStatus(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Slot.SlotStatus> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Slot.SlotStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Slot.SlotStatusEnumFactory());
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.r4.model.Slot.SlotStatus.NULL);
    } else {
      switch (src.getValue()) {
        case BUSY:
          tgt.setValue(org.hl7.fhir.r4.model.Slot.SlotStatus.BUSY);
          break;
        case FREE:
          tgt.setValue(org.hl7.fhir.r4.model.Slot.SlotStatus.FREE);
          break;
        case BUSYUNAVAILABLE:
          tgt.setValue(org.hl7.fhir.r4.model.Slot.SlotStatus.BUSYUNAVAILABLE);
          break;
        case BUSYTENTATIVE:
          tgt.setValue(org.hl7.fhir.r4.model.Slot.SlotStatus.BUSYTENTATIVE);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r4.model.Slot.SlotStatus.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Slot.SlotStatus> convertSlotStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Slot.SlotStatus> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Slot.SlotStatus> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Slot.SlotStatusEnumFactory());
    ConversionContext10_40.INSTANCE.getVersionConvertor_10_40().copyElement(src, tgt);
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