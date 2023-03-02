package org.hl7.fhir.convertors.conv40_50.resources40_50;

import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.CodeableConcept40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Identifier40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Instant40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.String40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.special40_50.Reference40_50;
import org.hl7.fhir.exceptions.FHIRException;

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
// Generated on Sun, Feb 24, 2019 11:37+1100 for FHIR v4.0.0
public class AppointmentResponse40_50 {

  public static org.hl7.fhir.r5.model.AppointmentResponse convertAppointmentResponse(org.hl7.fhir.r4.model.AppointmentResponse src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.AppointmentResponse tgt = new org.hl7.fhir.r5.model.AppointmentResponse();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_50.convertIdentifier(t));
    if (src.hasAppointment())
      tgt.setAppointment(Reference40_50.convertReference(src.getAppointment()));
    if (src.hasStart())
      tgt.setStartElement(Instant40_50.convertInstant(src.getStartElement()));
    if (src.hasEnd())
      tgt.setEndElement(Instant40_50.convertInstant(src.getEndElement()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getParticipantType())
      tgt.addParticipantType(CodeableConcept40_50.convertCodeableConcept(t));
    if (src.hasActor())
      tgt.setActor(Reference40_50.convertReference(src.getActor()));
    if (src.hasParticipantStatus())
      tgt.setParticipantStatusElement(convertParticipantStatus(src.getParticipantStatusElement()));
    if (src.hasComment())
      tgt.setCommentElement(String40_50.convertStringToMarkdown(src.getCommentElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.AppointmentResponse convertAppointmentResponse(org.hl7.fhir.r5.model.AppointmentResponse src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.AppointmentResponse tgt = new org.hl7.fhir.r4.model.AppointmentResponse();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_50.convertIdentifier(t));
    if (src.hasAppointment())
      tgt.setAppointment(Reference40_50.convertReference(src.getAppointment()));
    if (src.hasStart())
      tgt.setStartElement(Instant40_50.convertInstant(src.getStartElement()));
    if (src.hasEnd())
      tgt.setEndElement(Instant40_50.convertInstant(src.getEndElement()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getParticipantType())
      tgt.addParticipantType(CodeableConcept40_50.convertCodeableConcept(t));
    if (src.hasActor())
      tgt.setActor(Reference40_50.convertReference(src.getActor()));
    if (src.hasParticipantStatus())
      tgt.setParticipantStatusElement(convertParticipantStatus(src.getParticipantStatusElement()));
    if (src.hasComment())
      tgt.setCommentElement(String40_50.convertString(src.getCommentElement()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.AppointmentResponse.AppointmentResponseStatus> convertParticipantStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.AppointmentResponse.ParticipantStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.AppointmentResponse.AppointmentResponseStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.AppointmentResponse.AppointmentResponseStatusEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case ACCEPTED:
        tgt.setValue(org.hl7.fhir.r5.model.AppointmentResponse.AppointmentResponseStatus.ACCEPTED);
        break;
      case DECLINED:
        tgt.setValue(org.hl7.fhir.r5.model.AppointmentResponse.AppointmentResponseStatus.DECLINED);
        break;
      case TENTATIVE:
        tgt.setValue(org.hl7.fhir.r5.model.AppointmentResponse.AppointmentResponseStatus.TENTATIVE);
        break;
      case NEEDSACTION:
        tgt.setValue(org.hl7.fhir.r5.model.AppointmentResponse.AppointmentResponseStatus.NEEDSACTION);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.AppointmentResponse.AppointmentResponseStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.AppointmentResponse.ParticipantStatus> convertParticipantStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.AppointmentResponse.AppointmentResponseStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.AppointmentResponse.ParticipantStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.AppointmentResponse.ParticipantStatusEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case ACCEPTED:
        tgt.setValue(org.hl7.fhir.r4.model.AppointmentResponse.ParticipantStatus.ACCEPTED);
        break;
      case DECLINED:
        tgt.setValue(org.hl7.fhir.r4.model.AppointmentResponse.ParticipantStatus.DECLINED);
        break;
      case TENTATIVE:
        tgt.setValue(org.hl7.fhir.r4.model.AppointmentResponse.ParticipantStatus.TENTATIVE);
        break;
      case NEEDSACTION:
        tgt.setValue(org.hl7.fhir.r4.model.AppointmentResponse.ParticipantStatus.NEEDSACTION);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.AppointmentResponse.ParticipantStatus.NULL);
        break;
    }
    return tgt;
  }
}