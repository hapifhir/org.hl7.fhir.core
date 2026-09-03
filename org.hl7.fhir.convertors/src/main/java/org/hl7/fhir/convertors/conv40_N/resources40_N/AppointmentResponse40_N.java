package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Identifier40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Instant40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.String40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Reference40_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.AppointmentResponse;
import org.hl7.fhir.model.core.Enumeration;

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

public class AppointmentResponse40_N {

  public static org.hl7.fhir.model.core.AppointmentResponse convertAppointmentResponse(org.hl7.fhir.r4.model.AppointmentResponse src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.AppointmentResponse tgt = new org.hl7.fhir.model.core.AppointmentResponse();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    if (src.hasAppointment())
      tgt.setAppointment(Reference40_N.convertReference(src.getAppointment()));
    if (src.hasStart())
      tgt.setStartElement(Instant40_N.convertInstant(src.getStartElement()));
    if (src.hasEnd())
      tgt.setEndElement(Instant40_N.convertInstant(src.getEndElement()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getParticipantType())
      tgt.addParticipantType(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasActor())
      tgt.setActor(Reference40_N.convertReference(src.getActor()));
    if (src.hasParticipantStatus())
      tgt.setParticipantStatusElement(convertParticipantStatus(src.getParticipantStatusElement()));
    if (src.hasComment())
      tgt.setCommentElement(String40_N.convertStringToMarkdown(src.getCommentElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.AppointmentResponse convertAppointmentResponse(org.hl7.fhir.model.core.AppointmentResponse src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.AppointmentResponse tgt = new org.hl7.fhir.r4.model.AppointmentResponse();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    if (src.hasAppointment())
      tgt.setAppointment(Reference40_N.convertReference(src.getAppointment()));
    if (src.hasStart())
      tgt.setStartElement(Instant40_N.convertInstant(src.getStartElement()));
    if (src.hasEnd())
      tgt.setEndElement(Instant40_N.convertInstant(src.getEndElement()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getParticipantTypeList())
      tgt.addParticipantType(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasActor())
      tgt.setActor(Reference40_N.convertReference(src.getActor()));
    if (src.hasParticipantStatus())
      tgt.setParticipantStatusElement(convertParticipantStatus(src.getParticipantStatusElement()));
    if (src.hasComment())
      tgt.setCommentElement(String40_N.convertString(src.getCommentElement()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.AppointmentResponse.AppointmentResponseStatus> convertParticipantStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.AppointmentResponse.ParticipantStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<AppointmentResponse.AppointmentResponseStatus> tgt = new Enumeration<>(new AppointmentResponse.AppointmentResponseStatusEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case ACCEPTED:
                  tgt.setValue(AppointmentResponse.AppointmentResponseStatus.ACCEPTED);
                  break;
              case DECLINED:
                  tgt.setValue(AppointmentResponse.AppointmentResponseStatus.DECLINED);
                  break;
              case TENTATIVE:
                  tgt.setValue(AppointmentResponse.AppointmentResponseStatus.TENTATIVE);
                  break;
              case NEEDSACTION:
                  tgt.setValue(AppointmentResponse.AppointmentResponseStatus.NEEDSACTION);
                  break;
              default:
                  tgt.setValue(AppointmentResponse.AppointmentResponseStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.AppointmentResponse.ParticipantStatus> convertParticipantStatus(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.AppointmentResponse.AppointmentResponseStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.AppointmentResponse.ParticipantStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.AppointmentResponse.ParticipantStatusEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
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
      }
      return tgt;
  }
}