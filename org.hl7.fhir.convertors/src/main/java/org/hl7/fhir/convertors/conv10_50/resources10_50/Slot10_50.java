package org.hl7.fhir.convertors.conv10_50.resources10_50;

import org.hl7.fhir.convertors.context.ConversionContext10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.Reference10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.CodeableConcept10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.Identifier10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.Boolean10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.Instant10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.String10_50;
import org.hl7.fhir.exceptions.FHIRException;

public class Slot10_50 {

  public static org.hl7.fhir.r5.model.Slot convertSlot(org.hl7.fhir.dstu2.model.Slot src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Slot tgt = new org.hl7.fhir.r5.model.Slot();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_50.convertIdentifier(t));
    if (src.hasType())
      tgt.addServiceType(CodeableConcept10_50.convertCodeableConcept(src.getType()));
    if (src.hasSchedule())
      tgt.setSchedule(Reference10_50.convertReference(src.getSchedule()));
    if (src.hasStartElement())
      tgt.setStartElement(Instant10_50.convertInstant(src.getStartElement()));
    if (src.hasEndElement())
      tgt.setEndElement(Instant10_50.convertInstant(src.getEndElement()));
    if (src.hasOverbookedElement())
      tgt.setOverbookedElement(Boolean10_50.convertBoolean(src.getOverbookedElement()));
    if (src.hasCommentElement())
      tgt.setCommentElement(String10_50.convertString(src.getCommentElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Slot convertSlot(org.hl7.fhir.r5.model.Slot src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Slot tgt = new org.hl7.fhir.dstu2.model.Slot();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_50.convertIdentifier(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getServiceType())
      tgt.setType(CodeableConcept10_50.convertCodeableConcept(t));
    if (src.hasSchedule())
      tgt.setSchedule(Reference10_50.convertReference(src.getSchedule()));
    if (src.hasStartElement())
      tgt.setStartElement(Instant10_50.convertInstant(src.getStartElement()));
    if (src.hasEndElement())
      tgt.setEndElement(Instant10_50.convertInstant(src.getEndElement()));
    if (src.hasOverbookedElement())
      tgt.setOverbookedElement(Boolean10_50.convertBoolean(src.getOverbookedElement()));
    if (src.hasCommentElement())
      tgt.setCommentElement(String10_50.convertString(src.getCommentElement()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Slot.SlotStatus> convertSlotStatus(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Slot.SlotStatus> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Slot.SlotStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Slot.SlotStatusEnumFactory());
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.r5.model.Slot.SlotStatus.NULL);
    } else {
      switch (src.getValue()) {
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
        default:
          tgt.setValue(org.hl7.fhir.r5.model.Slot.SlotStatus.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Slot.SlotStatus> convertSlotStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Slot.SlotStatus> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Slot.SlotStatus> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Slot.SlotStatusEnumFactory());
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
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