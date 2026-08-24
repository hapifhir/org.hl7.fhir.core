package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Annotation40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Identifier40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Canonical40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.DateTime40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Uri40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Reference40_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.DeviceRequest;
import org.hl7.fhir.model.core.CodeableReference;
import org.hl7.fhir.model.core.Enumeration;
import org.hl7.fhir.model.core.Enumerations;

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

public class DeviceRequest40_N {

  public static org.hl7.fhir.model.core.DeviceRequest convertDeviceRequest(org.hl7.fhir.r4.model.DeviceRequest src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.DeviceRequest tgt = new org.hl7.fhir.model.core.DeviceRequest();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getBasedOn()) tgt.addBasedOn(Reference40_N.convertReference(t));
//    for (org.hl7.fhir.r4.model.Reference t : src.getPriorRequest())
//      tgt.addPriorRequest(Reference40_N.convertReference(t));
    if (src.hasGroupIdentifier())
      tgt.setGroupIdentifier(Identifier40_N.convertIdentifier(src.getGroupIdentifier()));
    if (src.hasStatus())
      tgt.setStatusElement(convertDeviceRequestStatus(src.getStatusElement()));
    if (src.hasIntent())
      tgt.setIntentElement(convertRequestIntent(src.getIntentElement()));
    if (src.hasPriority())
      tgt.setPriorityElement(convertRequestPriority(src.getPriorityElement()));
    if (src.hasCodeCodeableConcept())
      tgt.setProduct(CodeableConcept40_N.convertCodeableConcept(src.getCodeCodeableConcept()));
    else if (src.hasCodeReference())
      tgt.setProduct(Reference40_N.convertReference(src.getCodeReference()));

    for (org.hl7.fhir.r4.model.DeviceRequest.DeviceRequestParameterComponent t : src.getParameter())
      tgt.addParameter(convertDeviceRequestParameterComponent(t));
    if (src.hasSubject())
      tgt.setSubject(Reference40_N.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference40_N.convertReference(src.getEncounter()));
    if (src.hasOccurrence())
      tgt.setOccurrence(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getOccurrence()));
    if (src.hasAuthoredOn())
      tgt.setAuthoredOnElement(DateTime40_N.convertDateTime(src.getAuthoredOnElement()));
    if (src.hasRequester())
      tgt.setRequester(Reference40_N.convertReference(src.getRequester()));
    if (src.hasPerformerType())
      tgt.getPerformer().setConcept(CodeableConcept40_N.convertCodeableConcept(src.getPerformerType()));
    if (src.hasPerformer())
      tgt.getPerformer().setReference(Reference40_N.convertReference(src.getPerformer()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReasonCode())
      tgt.addReason(CodeableConcept40_N.convertCodeableConceptToCodeableReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getReasonReference())
      tgt.addReason(Reference40_N.convertReferenceToCodeableReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getInsurance()) tgt.addInsurance(Reference40_N.convertReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getSupportingInfo())
      tgt.addSupportingInfo(Reference40_N.convertReference(t));
    for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.addNote(Annotation40_N.convertAnnotation(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getRelevantHistory())
      tgt.addRelevantHistory(Reference40_N.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.DeviceRequest convertDeviceRequest(org.hl7.fhir.model.core.DeviceRequest src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.DeviceRequest tgt = new org.hl7.fhir.r4.model.DeviceRequest();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    for (org.hl7.fhir.model.core.Reference t : src.getBasedOnList()) tgt.addBasedOn(Reference40_N.convertReference(t));
//    for (org.hl7.fhir.model.core.Reference t : src.getPriorRequestList())
//      tgt.addPriorRequest(Reference40_N.convertReference(t));
    if (src.hasGroupIdentifier())
      tgt.setGroupIdentifier(Identifier40_N.convertIdentifier(src.getGroupIdentifier()));
    if (src.hasStatus())
      tgt.setStatusElement(convertDeviceRequestStatus(src.getStatusElement()));
    if (src.hasIntent())
      tgt.setIntentElement(convertRequestIntent(src.getIntentElement()));
    if (src.hasPriority())
      tgt.setPriorityElement(convertRequestPriority(src.getPriorityElement()));
    if (src.hasProductCodeableConcept())
      tgt.setCode(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getProductCodeableConcept()));
    if (src.hasProductReference())
      tgt.setCode(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getProductReference()));
    for (org.hl7.fhir.model.core.DeviceRequest.DeviceRequestParameterComponent t : src.getParameterList())
      tgt.addParameter(convertDeviceRequestParameterComponent(t));
    if (src.hasSubject())
      tgt.setSubject(Reference40_N.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference40_N.convertReference(src.getEncounter()));
    if (src.hasOccurrence())
      tgt.setOccurrence(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getOccurrence()));
    if (src.hasAuthoredOn())
      tgt.setAuthoredOnElement(DateTime40_N.convertDateTime(src.getAuthoredOnElement()));
    if (src.hasRequester())
      tgt.setRequester(Reference40_N.convertReference(src.getRequester()));
    if (src.getPerformer().hasConcept())
      tgt.setPerformerType(CodeableConcept40_N.convertCodeableConcept(src.getPerformer().getConcept()));
    if (src.getPerformer().hasReference())
      tgt.setPerformer(Reference40_N.convertReference(src.getPerformer().getReference()));
    for (CodeableReference t : src.getReasonList())
      if (t.hasConcept())
        tgt.addReasonCode(CodeableConcept40_N.convertCodeableConcept(t.getConcept()));
    for (CodeableReference t : src.getReasonList())
      if (t.hasReference())
        tgt.addReasonReference(Reference40_N.convertReference(t.getReference()));
    for (org.hl7.fhir.model.core.Reference t : src.getInsuranceList()) tgt.addInsurance(Reference40_N.convertReference(t));
    for (org.hl7.fhir.model.core.Reference t : src.getSupportingInfoList())
      tgt.addSupportingInfo(Reference40_N.convertReference(t));
    for (org.hl7.fhir.model.core.Annotation t : src.getNoteList()) tgt.addNote(Annotation40_N.convertAnnotation(t));
    for (org.hl7.fhir.model.core.Reference t : src.getRelevantHistoryList())
      tgt.addRelevantHistory(Reference40_N.convertReference(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.RequestStatus> convertDeviceRequestStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DeviceRequest.DeviceRequestStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Enumerations.RequestStatus> tgt = new Enumeration<>(new Enumerations.RequestStatusEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case DRAFT:
                  tgt.setValue(Enumerations.RequestStatus.DRAFT);
                  break;
              case ACTIVE:
                  tgt.setValue(Enumerations.RequestStatus.ACTIVE);
                  break;
              case ONHOLD:
                  tgt.setValue(Enumerations.RequestStatus.ONHOLD);
                  break;
              case REVOKED:
                  tgt.setValue(Enumerations.RequestStatus.REVOKED);
                  break;
              case COMPLETED:
                  tgt.setValue(Enumerations.RequestStatus.COMPLETED);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(Enumerations.RequestStatus.ENTEREDINERROR);
                  break;
              case UNKNOWN:
                  tgt.setValue(Enumerations.RequestStatus.UNKNOWN);
                  break;
              default:
                  tgt.setValue(Enumerations.RequestStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DeviceRequest.DeviceRequestStatus> convertDeviceRequestStatus(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.RequestStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<DeviceRequest.DeviceRequestStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new DeviceRequest.DeviceRequestStatusEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case DRAFT:
                  tgt.setValue(DeviceRequest.DeviceRequestStatus.DRAFT);
                  break;
              case ACTIVE:
                  tgt.setValue(DeviceRequest.DeviceRequestStatus.ACTIVE);
                  break;
              case ONHOLD:
                  tgt.setValue(DeviceRequest.DeviceRequestStatus.ONHOLD);
                  break;
              case REVOKED:
                  tgt.setValue(DeviceRequest.DeviceRequestStatus.REVOKED);
                  break;
              case COMPLETED:
                  tgt.setValue(DeviceRequest.DeviceRequestStatus.COMPLETED);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(DeviceRequest.DeviceRequestStatus.ENTEREDINERROR);
                  break;
              case UNKNOWN:
                  tgt.setValue(DeviceRequest.DeviceRequestStatus.UNKNOWN);
                  break;
              default:
                  tgt.setValue(DeviceRequest.DeviceRequestStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.RequestIntent> convertRequestIntent(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DeviceRequest.RequestIntent> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Enumerations.RequestIntent> tgt = new Enumeration<>(new Enumerations.RequestIntentEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case PROPOSAL:
                  tgt.setValue(Enumerations.RequestIntent.PROPOSAL);
                  break;
              case PLAN:
                  tgt.setValue(Enumerations.RequestIntent.PLAN);
                  break;
              case DIRECTIVE:
                  tgt.setValue(Enumerations.RequestIntent.DIRECTIVE);
                  break;
              case ORDER:
                  tgt.setValue(Enumerations.RequestIntent.ORDER);
                  break;
              case ORIGINALORDER:
                  tgt.setValue(Enumerations.RequestIntent.ORIGINALORDER);
                  break;
              case REFLEXORDER:
                  tgt.setValue(Enumerations.RequestIntent.REFLEXORDER);
                  break;
              case FILLERORDER:
                  tgt.setValue(Enumerations.RequestIntent.FILLERORDER);
                  break;
              case INSTANCEORDER:
                  tgt.setValue(Enumerations.RequestIntent.INSTANCEORDER);
                  break;
              case OPTION:
                  tgt.setValue(Enumerations.RequestIntent.OPTION);
                  break;
              default:
                  tgt.setValue(Enumerations.RequestIntent.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DeviceRequest.RequestIntent> convertRequestIntent(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.RequestIntent> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<DeviceRequest.RequestIntent> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new DeviceRequest.RequestIntentEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case PROPOSAL:
                  tgt.setValue(DeviceRequest.RequestIntent.PROPOSAL);
                  break;
              case PLAN:
                  tgt.setValue(DeviceRequest.RequestIntent.PLAN);
                  break;
              case DIRECTIVE:
                  tgt.setValue(DeviceRequest.RequestIntent.DIRECTIVE);
                  break;
              case ORDER:
                  tgt.setValue(DeviceRequest.RequestIntent.ORDER);
                  break;
              case ORIGINALORDER:
                  tgt.setValue(DeviceRequest.RequestIntent.ORIGINALORDER);
                  break;
              case REFLEXORDER:
                  tgt.setValue(DeviceRequest.RequestIntent.REFLEXORDER);
                  break;
              case FILLERORDER:
                  tgt.setValue(DeviceRequest.RequestIntent.FILLERORDER);
                  break;
              case INSTANCEORDER:
                  tgt.setValue(DeviceRequest.RequestIntent.INSTANCEORDER);
                  break;
              case OPTION:
                  tgt.setValue(DeviceRequest.RequestIntent.OPTION);
                  break;
              default:
                  tgt.setValue(DeviceRequest.RequestIntent.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.RequestPriority> convertRequestPriority(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DeviceRequest.RequestPriority> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Enumerations.RequestPriority> tgt = new Enumeration<>(new Enumerations.RequestPriorityEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case ROUTINE:
                  tgt.setValue(Enumerations.RequestPriority.ROUTINE);
                  break;
              case URGENT:
                  tgt.setValue(Enumerations.RequestPriority.URGENT);
                  break;
              case ASAP:
                  tgt.setValue(Enumerations.RequestPriority.ASAP);
                  break;
              case STAT:
                  tgt.setValue(Enumerations.RequestPriority.STAT);
                  break;
              default:
                  tgt.setValue(Enumerations.RequestPriority.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DeviceRequest.RequestPriority> convertRequestPriority(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.RequestPriority> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<DeviceRequest.RequestPriority> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new DeviceRequest.RequestPriorityEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case ROUTINE:
                  tgt.setValue(DeviceRequest.RequestPriority.ROUTINE);
                  break;
              case URGENT:
                  tgt.setValue(DeviceRequest.RequestPriority.URGENT);
                  break;
              case ASAP:
                  tgt.setValue(DeviceRequest.RequestPriority.ASAP);
                  break;
              case STAT:
                  tgt.setValue(DeviceRequest.RequestPriority.STAT);
                  break;
              default:
                  tgt.setValue(DeviceRequest.RequestPriority.NULL);
                  break;
          }
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.DeviceRequest.DeviceRequestParameterComponent convertDeviceRequestParameterComponent(org.hl7.fhir.r4.model.DeviceRequest.DeviceRequestParameterComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.DeviceRequest.DeviceRequestParameterComponent tgt = new org.hl7.fhir.model.core.DeviceRequest.DeviceRequestParameterComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_N.convertCodeableConcept(src.getCode()));
    if (src.hasValue())
      tgt.setValue(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getValue()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.DeviceRequest.DeviceRequestParameterComponent convertDeviceRequestParameterComponent(org.hl7.fhir.model.core.DeviceRequest.DeviceRequestParameterComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.DeviceRequest.DeviceRequestParameterComponent tgt = new org.hl7.fhir.r4.model.DeviceRequest.DeviceRequestParameterComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_N.convertCodeableConcept(src.getCode()));
    if (src.hasValue())
      tgt.setValue(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getValue()));
    return tgt;
  }
}