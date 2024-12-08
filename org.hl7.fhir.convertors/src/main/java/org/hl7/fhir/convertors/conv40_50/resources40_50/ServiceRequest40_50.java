package org.hl7.fhir.convertors.conv40_50.resources40_50;

import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Annotation40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.CodeableConcept40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Identifier40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Boolean40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Canonical40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.DateTime40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.String40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Uri40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.special40_50.Reference40_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.ServiceRequest;
import org.hl7.fhir.r5.model.CodeableReference;
import org.hl7.fhir.r5.model.Enumeration;
import org.hl7.fhir.r5.model.Enumerations;
import org.hl7.fhir.r5.model.ServiceRequest.ServiceRequestOrderDetailComponent;

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
public class ServiceRequest40_50 {

  public static org.hl7.fhir.r5.model.ServiceRequest convertServiceRequest(org.hl7.fhir.r4.model.ServiceRequest src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ServiceRequest tgt = new org.hl7.fhir.r5.model.ServiceRequest();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_50.convertIdentifier(t));
    for (org.hl7.fhir.r4.model.CanonicalType t : src.getInstantiatesCanonical())
      tgt.getInstantiatesCanonical().add(Canonical40_50.convertCanonical(t));
    for (org.hl7.fhir.r4.model.UriType t : src.getInstantiatesUri())
      tgt.getInstantiatesUri().add(Uri40_50.convertUri(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getBasedOn()) tgt.addBasedOn(Reference40_50.convertReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getReplaces()) tgt.addReplaces(Reference40_50.convertReference(t));
    if (src.hasRequisition())
      tgt.setRequisition(Identifier40_50.convertIdentifier(src.getRequisition()));
    if (src.hasStatus())
      tgt.setStatusElement(convertServiceRequestStatus(src.getStatusElement()));
    if (src.hasIntent())
      tgt.setIntentElement(convertServiceRequestIntent(src.getIntentElement()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept40_50.convertCodeableConcept(t));
    if (src.hasPriority())
      tgt.setPriorityElement(convertServiceRequestPriority(src.getPriorityElement()));
    if (src.hasDoNotPerform())
      tgt.setDoNotPerformElement(Boolean40_50.convertBoolean(src.getDoNotPerformElement()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_50.convertCodeableConceptToCodeableReference(src.getCode()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getOrderDetail())
      tgt.addOrderDetail().addParameter().setValue(CodeableConcept40_50.convertCodeableConcept(t));
    if (src.hasQuantity())
      tgt.setQuantity(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getQuantity()));
    if (src.hasSubject())
      tgt.setSubject(Reference40_50.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference40_50.convertReference(src.getEncounter()));
    if (src.hasOccurrence())
      tgt.setOccurrence(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getOccurrence()));
    if (src.hasAsNeeded())
      tgt.setAsNeeded(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getAsNeeded()));
    if (src.hasAuthoredOn())
      tgt.setAuthoredOnElement(DateTime40_50.convertDateTime(src.getAuthoredOnElement()));
    if (src.hasRequester())
      tgt.setRequester(Reference40_50.convertReference(src.getRequester()));
    if (src.hasPerformerType())
      tgt.setPerformerType(CodeableConcept40_50.convertCodeableConcept(src.getPerformerType()));
    for (org.hl7.fhir.r4.model.Reference t : src.getPerformer()) tgt.addPerformer(Reference40_50.convertReference(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getLocationCode())
      tgt.addLocation(CodeableConcept40_50.convertCodeableConceptToCodeableReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getLocationReference())
      tgt.addLocation(Reference40_50.convertReferenceToCodeableReference(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReasonCode())
      tgt.addReason(CodeableConcept40_50.convertCodeableConceptToCodeableReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getReasonReference())
      tgt.addReason(Reference40_50.convertReferenceToCodeableReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getInsurance()) tgt.addInsurance(Reference40_50.convertReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getSupportingInfo())
      tgt.addSupportingInfo(Reference40_50.convertReferenceToCodeableReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getSpecimen()) tgt.addSpecimen(Reference40_50.convertReference(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getBodySite())
      tgt.addBodySite(CodeableConcept40_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.addNote(Annotation40_50.convertAnnotation(t));
    if (src.hasPatientInstruction())
      tgt.addPatientInstruction().setInstruction(String40_50.convertStringToMarkdown(src.getPatientInstructionElement()));
    for (org.hl7.fhir.r4.model.Reference t : src.getRelevantHistory())
      tgt.addRelevantHistory(Reference40_50.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ServiceRequest convertServiceRequest(org.hl7.fhir.r5.model.ServiceRequest src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ServiceRequest tgt = new org.hl7.fhir.r4.model.ServiceRequest();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_50.convertIdentifier(t));
    for (org.hl7.fhir.r5.model.CanonicalType t : src.getInstantiatesCanonical())
      tgt.getInstantiatesCanonical().add(Canonical40_50.convertCanonical(t));
    for (org.hl7.fhir.r5.model.UriType t : src.getInstantiatesUri())
      tgt.getInstantiatesUri().add(Uri40_50.convertUri(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getBasedOn()) tgt.addBasedOn(Reference40_50.convertReference(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getReplaces()) tgt.addReplaces(Reference40_50.convertReference(t));
    if (src.hasRequisition())
      tgt.setRequisition(Identifier40_50.convertIdentifier(src.getRequisition()));
    if (src.hasStatus())
      tgt.setStatusElement(convertServiceRequestStatus(src.getStatusElement()));
    if (src.hasIntent())
      tgt.setIntentElement(convertServiceRequestIntent(src.getIntentElement()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept40_50.convertCodeableConcept(t));
    if (src.hasPriority())
      tgt.setPriorityElement(convertServiceRequestPriority(src.getPriorityElement()));
    if (src.hasDoNotPerform())
      tgt.setDoNotPerformElement(Boolean40_50.convertBoolean(src.getDoNotPerformElement()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_50.convertCodeableReferenceToCodeableConcept(src.getCode()));
    for (ServiceRequestOrderDetailComponent t : src.getOrderDetail()) {
      if (t.getParameterFirstRep().hasValueCodeableConcept()) {
       tgt.addOrderDetail(CodeableConcept40_50.convertCodeableConcept(t.getParameterFirstRep().getValueCodeableConcept()));
      }
    }
    if (src.hasQuantity())
      tgt.setQuantity(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getQuantity()));
    if (src.hasSubject())
      tgt.setSubject(Reference40_50.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference40_50.convertReference(src.getEncounter()));
    if (src.hasOccurrence())
      tgt.setOccurrence(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getOccurrence()));
    if (src.hasAsNeeded())
      tgt.setAsNeeded(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getAsNeeded()));
    if (src.hasAuthoredOn())
      tgt.setAuthoredOnElement(DateTime40_50.convertDateTime(src.getAuthoredOnElement()));
    if (src.hasRequester())
      tgt.setRequester(Reference40_50.convertReference(src.getRequester()));
    if (src.hasPerformerType())
      tgt.setPerformerType(CodeableConcept40_50.convertCodeableConcept(src.getPerformerType()));
    for (org.hl7.fhir.r5.model.Reference t : src.getPerformer()) tgt.addPerformer(Reference40_50.convertReference(t));
    for (CodeableReference t : src.getLocation())
      if (t.hasConcept())
        tgt.addLocationCode(CodeableConcept40_50.convertCodeableConcept(t.getConcept()));
    for (CodeableReference t : src.getLocation())
      if (t.hasReference())
        tgt.addLocationReference(Reference40_50.convertReference(t.getReference()));
    for (CodeableReference t : src.getReason())
      if (t.hasConcept())
        tgt.addReasonCode(CodeableConcept40_50.convertCodeableConcept(t.getConcept()));
    for (CodeableReference t : src.getReason())
      if (t.hasReference())
        tgt.addReasonReference(Reference40_50.convertReference(t.getReference()));
    for (org.hl7.fhir.r5.model.Reference t : src.getInsurance()) tgt.addInsurance(Reference40_50.convertReference(t));
    for (CodeableReference t : src.getSupportingInfo())
      if (t.hasReference())
        tgt.addSupportingInfo(Reference40_50.convertReference(t.getReference()));
    for (org.hl7.fhir.r5.model.Reference t : src.getSpecimen()) tgt.addSpecimen(Reference40_50.convertReference(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getBodySite())
      tgt.addBodySite(CodeableConcept40_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.addNote(Annotation40_50.convertAnnotation(t));
    if (src.getPatientInstructionFirstRep().hasInstructionMarkdownType())
      tgt.setPatientInstructionElement(String40_50.convertString(src.getPatientInstructionFirstRep().getInstructionMarkdownType()));
    for (org.hl7.fhir.r5.model.Reference t : src.getRelevantHistory())
      tgt.addRelevantHistory(Reference40_50.convertReference(t));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestStatus> convertServiceRequestStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Enumerations.RequestStatus> tgt = new Enumeration<>(new Enumerations.RequestStatusEnumFactory());
      ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestStatus> convertServiceRequestStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<ServiceRequest.ServiceRequestStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new ServiceRequest.ServiceRequestStatusEnumFactory());
      ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case DRAFT:
                  tgt.setValue(ServiceRequest.ServiceRequestStatus.DRAFT);
                  break;
              case ACTIVE:
                  tgt.setValue(ServiceRequest.ServiceRequestStatus.ACTIVE);
                  break;
              case ONHOLD:
                  tgt.setValue(ServiceRequest.ServiceRequestStatus.ONHOLD);
                  break;
              case REVOKED:
                  tgt.setValue(ServiceRequest.ServiceRequestStatus.REVOKED);
                  break;
              case COMPLETED:
                  tgt.setValue(ServiceRequest.ServiceRequestStatus.COMPLETED);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(ServiceRequest.ServiceRequestStatus.ENTEREDINERROR);
                  break;
              case UNKNOWN:
                  tgt.setValue(ServiceRequest.ServiceRequestStatus.UNKNOWN);
                  break;
              default:
                  tgt.setValue(ServiceRequest.ServiceRequestStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestIntent> convertServiceRequestIntent(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestIntent> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Enumerations.RequestIntent> tgt = new Enumeration<>(new Enumerations.RequestIntentEnumFactory());
      ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestIntent> convertServiceRequestIntent(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestIntent> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<ServiceRequest.ServiceRequestIntent> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new ServiceRequest.ServiceRequestIntentEnumFactory());
      ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case PROPOSAL:
                  tgt.setValue(ServiceRequest.ServiceRequestIntent.PROPOSAL);
                  break;
              case PLAN:
                  tgt.setValue(ServiceRequest.ServiceRequestIntent.PLAN);
                  break;
              case DIRECTIVE:
                  tgt.setValue(ServiceRequest.ServiceRequestIntent.DIRECTIVE);
                  break;
              case ORDER:
                  tgt.setValue(ServiceRequest.ServiceRequestIntent.ORDER);
                  break;
              case ORIGINALORDER:
                  tgt.setValue(ServiceRequest.ServiceRequestIntent.ORIGINALORDER);
                  break;
              case REFLEXORDER:
                  tgt.setValue(ServiceRequest.ServiceRequestIntent.REFLEXORDER);
                  break;
              case FILLERORDER:
                  tgt.setValue(ServiceRequest.ServiceRequestIntent.FILLERORDER);
                  break;
              case INSTANCEORDER:
                  tgt.setValue(ServiceRequest.ServiceRequestIntent.INSTANCEORDER);
                  break;
              case OPTION:
                  tgt.setValue(ServiceRequest.ServiceRequestIntent.OPTION);
                  break;
              default:
                  tgt.setValue(ServiceRequest.ServiceRequestIntent.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestPriority> convertServiceRequestPriority(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestPriority> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Enumerations.RequestPriority> tgt = new Enumeration<>(new Enumerations.RequestPriorityEnumFactory());
      ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestPriority> convertServiceRequestPriority(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestPriority> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<ServiceRequest.ServiceRequestPriority> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new ServiceRequest.ServiceRequestPriorityEnumFactory());
      ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case ROUTINE:
                  tgt.setValue(ServiceRequest.ServiceRequestPriority.ROUTINE);
                  break;
              case URGENT:
                  tgt.setValue(ServiceRequest.ServiceRequestPriority.URGENT);
                  break;
              case ASAP:
                  tgt.setValue(ServiceRequest.ServiceRequestPriority.ASAP);
                  break;
              case STAT:
                  tgt.setValue(ServiceRequest.ServiceRequestPriority.STAT);
                  break;
              default:
                  tgt.setValue(ServiceRequest.ServiceRequestPriority.NULL);
                  break;
          }
      }
      return tgt;
  }
}