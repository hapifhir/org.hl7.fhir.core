package org.hl7.fhir.convertors.conv43_N.resources43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.CodeableConcept43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Identifier43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Boolean43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Instant43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.String43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.special43_N.Reference43_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.CodeableReference;
import org.hl7.fhir.model.core.Enumeration;
import org.hl7.fhir.model.core.Slot;

/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.
  
  Redistribution and use in source and binary forms, with or without modification, 
  are permitted provided that the following conditions are met:
  
   * Redistributions of source code must retain the above copyright notice, this 
     list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright notice, 
     this list of conditions and the following disclaimer in the documentation 
     and/or other materials provided with the distribution.
   * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.
  
  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
  POSSIBILITY OF SUCH DAMAGE.
  
*/

public class Slot43_N {

  public static org.hl7.fhir.model.core.Slot convertSlot(org.hl7.fhir.r4b.model.Slot src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Slot tgt = new org.hl7.fhir.model.core.Slot();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getServiceCategory())
      tgt.addServiceCategory(CodeableConcept43_N.convertCodeableConcept(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getServiceType())
      tgt.addServiceType(new CodeableReference().setConcept(CodeableConcept43_N.convertCodeableConcept(t)));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getSpecialty())
      tgt.addSpecialty(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasAppointmentType())
      tgt.addAppointmentType(CodeableConcept43_N.convertCodeableConcept(src.getAppointmentType()));
    if (src.hasSchedule())
      tgt.setSchedule(Reference43_N.convertReference(src.getSchedule()));
    if (src.hasStatus())
      tgt.setStatusElement(convertSlotStatus(src.getStatusElement()));
    if (src.hasStart())
      tgt.setStartElement(Instant43_N.convertInstant(src.getStartElement()));
    if (src.hasEnd())
      tgt.setEndElement(Instant43_N.convertInstant(src.getEndElement()));
    if (src.hasOverbooked())
      tgt.setOverbookedElement(Boolean43_N.convertBoolean(src.getOverbookedElement()));
    if (src.hasComment())
      tgt.setCommentElement(String43_N.convertString(src.getCommentElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Slot convertSlot(org.hl7.fhir.model.core.Slot src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Slot tgt = new org.hl7.fhir.r4b.model.Slot();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getServiceCategoryList())
      tgt.addServiceCategory(CodeableConcept43_N.convertCodeableConcept(t));
    for (CodeableReference t : src.getServiceTypeList())
      if (t.hasConcept())
        tgt.addServiceType(CodeableConcept43_N.convertCodeableConcept(t.getConcept()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getSpecialtyList())
      tgt.addSpecialty(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasAppointmentType())
      tgt.setAppointmentType(CodeableConcept43_N.convertCodeableConcept(src.getAppointmentTypeFirstRep()));
    if (src.hasSchedule())
      tgt.setSchedule(Reference43_N.convertReference(src.getSchedule()));
    if (src.hasStatus())
      tgt.setStatusElement(convertSlotStatus(src.getStatusElement()));
    if (src.hasStart())
      tgt.setStartElement(Instant43_N.convertInstant(src.getStartElement()));
    if (src.hasEnd())
      tgt.setEndElement(Instant43_N.convertInstant(src.getEndElement()));
    if (src.hasOverbooked())
      tgt.setOverbookedElement(Boolean43_N.convertBoolean(src.getOverbookedElement()));
    if (src.hasComment())
      tgt.setCommentElement(String43_N.convertString(src.getCommentElement()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Slot.SlotStatus> convertSlotStatus(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Slot.SlotStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Slot.SlotStatus> tgt = new Enumeration<>(new Slot.SlotStatusEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case BUSY:
                  tgt.setValue(Slot.SlotStatus.BUSY);
                  break;
              case FREE:
                  tgt.setValue(Slot.SlotStatus.FREE);
                  break;
              case BUSYUNAVAILABLE:
                  tgt.setValue(Slot.SlotStatus.BUSYUNAVAILABLE);
                  break;
              case BUSYTENTATIVE:
                  tgt.setValue(Slot.SlotStatus.BUSYTENTATIVE);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(Slot.SlotStatus.ENTEREDINERROR);
                  break;
              default:
                  tgt.setValue(Slot.SlotStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Slot.SlotStatus> convertSlotStatus(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Slot.SlotStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Slot.SlotStatus> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Slot.SlotStatusEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case BUSY:
                  tgt.setValue(org.hl7.fhir.r4b.model.Slot.SlotStatus.BUSY);
                  break;
              case FREE:
                  tgt.setValue(org.hl7.fhir.r4b.model.Slot.SlotStatus.FREE);
                  break;
              case BUSYUNAVAILABLE:
                  tgt.setValue(org.hl7.fhir.r4b.model.Slot.SlotStatus.BUSYUNAVAILABLE);
                  break;
              case BUSYTENTATIVE:
                  tgt.setValue(org.hl7.fhir.r4b.model.Slot.SlotStatus.BUSYTENTATIVE);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(org.hl7.fhir.r4b.model.Slot.SlotStatus.ENTEREDINERROR);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4b.model.Slot.SlotStatus.NULL);
                  break;
          }
      }
      return tgt;
  }
}