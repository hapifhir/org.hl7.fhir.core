package org.hl7.fhir.convertors.conv43_50.resources43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.special40_50.Reference40_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Annotation43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.CodeableConcept43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Identifier43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Boolean43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Canonical43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.DateTime43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.String43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Uri43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.special43_50.Reference43_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CodeableReference;
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
public class ServiceRequest43_50 {

  public static org.hl7.fhir.r5.model.ServiceRequest convertServiceRequest(org.hl7.fhir.r4b.model.ServiceRequest src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.ServiceRequest tgt = new org.hl7.fhir.r5.model.ServiceRequest();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    for (org.hl7.fhir.r4b.model.CanonicalType t : src.getInstantiatesCanonical())
      tgt.getInstantiatesCanonical().add(Canonical43_50.convertCanonical(t));
    for (org.hl7.fhir.r4b.model.UriType t : src.getInstantiatesUri())
      tgt.getInstantiatesUri().add(Uri43_50.convertUri(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getBasedOn()) tgt.addBasedOn(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getReplaces()) tgt.addReplaces(Reference43_50.convertReference(t));
    if (src.hasRequisition())
      tgt.setRequisition(Identifier43_50.convertIdentifier(src.getRequisition()));
    if (src.hasStatus())
      tgt.setStatusElement(convertServiceRequestStatus(src.getStatusElement()));
    if (src.hasIntent())
      tgt.setIntentElement(convertServiceRequestIntent(src.getIntentElement()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasPriority())
      tgt.setPriorityElement(convertServiceRequestPriority(src.getPriorityElement()));
    if (src.hasDoNotPerform())
      tgt.setDoNotPerformElement(Boolean43_50.convertBoolean(src.getDoNotPerformElement()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_50.convertCodeableConceptToCodeableReference(src.getCode()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getOrderDetail())
      tgt.addOrderDetail().getParameter().setValue(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasQuantity())
      tgt.setQuantity(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getQuantity()));
    if (src.hasSubject())
      tgt.setSubject(Reference43_50.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference43_50.convertReference(src.getEncounter()));
    if (src.hasOccurrence())
      tgt.setOccurrence(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getOccurrence()));
    if (src.hasAsNeeded())
      tgt.setAsNeeded(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getAsNeeded()));
    if (src.hasAuthoredOn())
      tgt.setAuthoredOnElement(DateTime43_50.convertDateTime(src.getAuthoredOnElement()));
    if (src.hasRequester())
      tgt.setRequester(Reference43_50.convertReference(src.getRequester()));
    if (src.hasPerformerType())
      tgt.setPerformerType(CodeableConcept43_50.convertCodeableConcept(src.getPerformerType()));
    for (org.hl7.fhir.r4b.model.Reference t : src.getPerformer()) tgt.addPerformer(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getLocationCode())
      tgt.addLocation(CodeableConcept43_50.convertCodeableConceptToCodeableReference(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getLocationReference())
      tgt.addLocation(Reference43_50.convertReferenceToCodeableReference(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getReasonCode())
      tgt.addReason(CodeableConcept43_50.convertCodeableConceptToCodeableReference(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getReasonReference())
      tgt.addReason(Reference43_50.convertReferenceToCodeableReference(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getInsurance()) tgt.addInsurance(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getSupportingInfo())
      tgt.addSupportingInfo(Reference43_50.convertReferenceToCodeableReference(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getSpecimen()) tgt.addSpecimen(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getBodySite())
      tgt.addBodySite(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r4b.model.Annotation t : src.getNote()) tgt.addNote(Annotation43_50.convertAnnotation(t));
    if (src.hasPatientInstruction())
      tgt.addPatientInstruction().setInstruction(String43_50.convertStringToMarkdown(src.getPatientInstructionElement()));
    for (org.hl7.fhir.r4b.model.Reference t : src.getRelevantHistory())
      tgt.addRelevantHistory(Reference43_50.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ServiceRequest convertServiceRequest(org.hl7.fhir.r5.model.ServiceRequest src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ServiceRequest tgt = new org.hl7.fhir.r4b.model.ServiceRequest();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    for (org.hl7.fhir.r5.model.CanonicalType t : src.getInstantiatesCanonical())
      tgt.getInstantiatesCanonical().add(Canonical43_50.convertCanonical(t));
    for (org.hl7.fhir.r5.model.UriType t : src.getInstantiatesUri())
      tgt.getInstantiatesUri().add(Uri43_50.convertUri(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getBasedOn()) tgt.addBasedOn(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getReplaces()) tgt.addReplaces(Reference43_50.convertReference(t));
    if (src.hasRequisition())
      tgt.setRequisition(Identifier43_50.convertIdentifier(src.getRequisition()));
    if (src.hasStatus())
      tgt.setStatusElement(convertServiceRequestStatus(src.getStatusElement()));
    if (src.hasIntent())
      tgt.setIntentElement(convertServiceRequestIntent(src.getIntentElement()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept43_50.convertCodeableConcept(t));
    if (src.hasPriority())
      tgt.setPriorityElement(convertServiceRequestPriority(src.getPriorityElement()));
    if (src.hasDoNotPerform())
      tgt.setDoNotPerformElement(Boolean43_50.convertBoolean(src.getDoNotPerformElement()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_50.convertCodeableReferenceToCodeableConcept(src.getCode()));
    for (ServiceRequestOrderDetailComponent t : src.getOrderDetail()) {
      if (t.getParameter().hasValueCodeableConcept()) {
       tgt.addOrderDetail(CodeableConcept43_50.convertCodeableConcept(t.getParameter().getValueCodeableConcept()));
      }
    }
    if (src.hasQuantity())
      tgt.setQuantity(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getQuantity()));
    if (src.hasSubject())
      tgt.setSubject(Reference43_50.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference43_50.convertReference(src.getEncounter()));
    if (src.hasOccurrence())
      tgt.setOccurrence(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getOccurrence()));
    if (src.hasAsNeeded())
      tgt.setAsNeeded(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getAsNeeded()));
    if (src.hasAuthoredOn())
      tgt.setAuthoredOnElement(DateTime43_50.convertDateTime(src.getAuthoredOnElement()));
    if (src.hasRequester())
      tgt.setRequester(Reference43_50.convertReference(src.getRequester()));
    if (src.hasPerformerType())
      tgt.setPerformerType(CodeableConcept43_50.convertCodeableConcept(src.getPerformerType()));
    for (org.hl7.fhir.r5.model.Reference t : src.getPerformer()) tgt.addPerformer(Reference43_50.convertReference(t));
    for (CodeableReference t : src.getLocation())
      if (t.hasConcept())
        tgt.addLocationCode(CodeableConcept43_50.convertCodeableConcept(t.getConcept()));
    for (CodeableReference t : src.getLocation())
      if (t.hasReference())
        tgt.addLocationReference(Reference43_50.convertReference(t.getReference()));
    for (CodeableReference t : src.getReason())
      if (t.hasConcept())
        tgt.addReasonCode(CodeableConcept43_50.convertCodeableConcept(t.getConcept()));
    for (CodeableReference t : src.getReason())
      if (t.hasReference())
        tgt.addReasonReference(Reference43_50.convertReference(t.getReference()));
    for (org.hl7.fhir.r5.model.Reference t : src.getInsurance()) tgt.addInsurance(Reference43_50.convertReference(t));
    for (CodeableReference t : src.getSupportingInfo())
      if (t.hasReference())
        tgt.addSupportingInfo(Reference43_50.convertReference(t.getReference()));
    for (org.hl7.fhir.r5.model.Reference t : src.getSpecimen()) tgt.addSpecimen(Reference43_50.convertReference(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getBodySite())
      tgt.addBodySite(CodeableConcept43_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.addNote(Annotation43_50.convertAnnotation(t));
    if (src.getPatientInstructionFirstRep().hasInstructionMarkdownType())
      tgt.setPatientInstructionElement(String43_50.convertString(src.getPatientInstructionFirstRep().getInstructionMarkdownType()));
    for (org.hl7.fhir.r5.model.Reference t : src.getRelevantHistory())
      tgt.addRelevantHistory(Reference43_50.convertReference(t));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestStatus> convertServiceRequestStatus(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.RequestStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.RequestStatusEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case DRAFT:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestStatus.DRAFT);
        break;
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestStatus.ACTIVE);
        break;
      case ONHOLD:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestStatus.ONHOLD);
        break;
      case REVOKED:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestStatus.REVOKED);
        break;
      case COMPLETED:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestStatus.COMPLETED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestStatus.ENTEREDINERROR);
        break;
      case UNKNOWN:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestStatus.UNKNOWN);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.RequestStatus> convertServiceRequestStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.RequestStatus> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.RequestStatusEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case DRAFT:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestStatus.DRAFT);
        break;
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestStatus.ACTIVE);
        break;
      case ONHOLD:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestStatus.ONHOLD);
        break;
      case REVOKED:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestStatus.REVOKED);
        break;
      case COMPLETED:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestStatus.COMPLETED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestStatus.ENTEREDINERROR);
        break;
      case UNKNOWN:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestStatus.UNKNOWN);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestIntent> convertServiceRequestIntent(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.RequestIntent> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestIntent> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.RequestIntentEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case PROPOSAL:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestIntent.PROPOSAL);
        break;
      case PLAN:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestIntent.PLAN);
        break;
      case DIRECTIVE:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestIntent.DIRECTIVE);
        break;
      case ORDER:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestIntent.ORDER);
        break;
      case ORIGINALORDER:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestIntent.ORIGINALORDER);
        break;
      case REFLEXORDER:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestIntent.REFLEXORDER);
        break;
      case FILLERORDER:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestIntent.FILLERORDER);
        break;
      case INSTANCEORDER:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestIntent.INSTANCEORDER);
        break;
      case OPTION:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestIntent.OPTION);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestIntent.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.RequestIntent> convertServiceRequestIntent(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestIntent> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.RequestIntent> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.RequestIntentEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case PROPOSAL:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestIntent.PROPOSAL);
        break;
      case PLAN:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestIntent.PLAN);
        break;
      case DIRECTIVE:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestIntent.DIRECTIVE);
        break;
      case ORDER:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestIntent.ORDER);
        break;
      case ORIGINALORDER:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestIntent.ORIGINALORDER);
        break;
      case REFLEXORDER:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestIntent.REFLEXORDER);
        break;
      case FILLERORDER:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestIntent.FILLERORDER);
        break;
      case INSTANCEORDER:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestIntent.INSTANCEORDER);
        break;
      case OPTION:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestIntent.OPTION);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestIntent.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestPriority> convertServiceRequestPriority(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.RequestPriority> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestPriority> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.RequestPriorityEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case ROUTINE:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestPriority.ROUTINE);
        break;
      case URGENT:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestPriority.URGENT);
        break;
      case ASAP:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestPriority.ASAP);
        break;
      case STAT:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestPriority.STAT);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.RequestPriority.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.RequestPriority> convertServiceRequestPriority(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.RequestPriority> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.RequestPriority> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.RequestPriorityEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case ROUTINE:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestPriority.ROUTINE);
        break;
      case URGENT:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestPriority.URGENT);
        break;
      case ASAP:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestPriority.ASAP);
        break;
      case STAT:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestPriority.STAT);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.RequestPriority.NULL);
        break;
    }
    return tgt;
  }
}