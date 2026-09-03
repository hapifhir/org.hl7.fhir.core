package org.hl7.fhir.convertors.conv43_N.resources43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Annotation43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.CodeableConcept43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Identifier43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Boolean43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Canonical43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.DateTime43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.String43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Uri43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.special43_N.Reference43_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4b.model.ServiceRequest;
import org.hl7.fhir.model.core.CodeableReference;
import org.hl7.fhir.model.core.Enumeration;
import org.hl7.fhir.model.core.Enumerations;
import org.hl7.fhir.model.core.ServiceRequest.ServiceRequestOrderDetailComponent;

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

public class ServiceRequest43_N {

  public static org.hl7.fhir.model.core.ServiceRequest convertServiceRequest(org.hl7.fhir.r4b.model.ServiceRequest src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ServiceRequest tgt = new org.hl7.fhir.model.core.ServiceRequest();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getBasedOn()) tgt.addBasedOn(Reference43_N.convertReference(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getReplaces()) tgt.addReplaces(Reference43_N.convertReference(t));
    if (src.hasRequisition())
      tgt.setRequisition(Identifier43_N.convertIdentifier(src.getRequisition()));
    if (src.hasStatus())
      tgt.setStatusElement(convertServiceRequestStatus(src.getStatusElement()));
    if (src.hasIntent())
      tgt.setIntentElement(convertServiceRequestIntent(src.getIntentElement()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasPriority())
      tgt.setPriorityElement(convertServiceRequestPriority(src.getPriorityElement()));
    if (src.hasDoNotPerform())
      tgt.setDoNotPerformElement(Boolean43_N.convertBoolean(src.getDoNotPerformElement()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_N.convertCodeableConceptToCodeableReference(src.getCode()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getOrderDetail())
      tgt.addOrderDetail().addParameter().setValue(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasQuantity())
      tgt.setQuantity(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getQuantity()));
    if (src.hasSubject())
      tgt.setSubject(Reference43_N.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference43_N.convertReference(src.getEncounter()));
    if (src.hasOccurrence())
      tgt.setOccurrence(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getOccurrence()));
    if (src.hasAsNeeded())
      tgt.setAsNeededElement(Boolean43_N.convertBoolean(src.getAsNeededBooleanType()));
    if (src.hasAuthoredOn())
      tgt.setAuthoredOnElement(DateTime43_N.convertDateTime(src.getAuthoredOnElement()));
    if (src.hasRequester())
      tgt.setRequester(Reference43_N.convertReference(src.getRequester()));
    if (src.hasPerformerType())
      tgt.setPerformerType(CodeableConcept43_N.convertCodeableConcept(src.getPerformerType()));
    for (org.hl7.fhir.r4b.model.Reference t : src.getPerformer()) tgt.addPerformer(Reference43_N.convertReference(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getLocationCode())
      tgt.addLocation(CodeableConcept43_N.convertCodeableConceptToCodeableReference(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getLocationReference())
      tgt.addLocation(Reference43_N.convertReferenceToCodeableReference(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getReasonCode())
      tgt.addReason(CodeableConcept43_N.convertCodeableConceptToCodeableReference(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getReasonReference())
      tgt.addReason(Reference43_N.convertReferenceToCodeableReference(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getInsurance()) tgt.addInsurance(Reference43_N.convertReference(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getSupportingInfo())
      tgt.addSupportingInfo(Reference43_N.convertReferenceToCodeableReference(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getBodySite())
      tgt.addBodyStructure(new CodeableReference().setConcept(CodeableConcept43_N.convertCodeableConcept(t)));
    for (org.hl7.fhir.r4b.model.Annotation t : src.getNote()) tgt.addNote(Annotation43_N.convertAnnotation(t));
    if (src.hasPatientInstruction())
      tgt.addPatientInstruction().setInstruction(String43_N.convertStringToMarkdown(src.getPatientInstructionElement()));
    for (org.hl7.fhir.r4b.model.Reference t : src.getRelevantHistory())
      tgt.addRelevantHistory(Reference43_N.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.ServiceRequest convertServiceRequest(org.hl7.fhir.model.core.ServiceRequest src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.ServiceRequest tgt = new org.hl7.fhir.r4b.model.ServiceRequest();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    for (org.hl7.fhir.model.core.Reference t : src.getBasedOnList()) tgt.addBasedOn(Reference43_N.convertReference(t));
    for (org.hl7.fhir.model.core.Reference t : src.getReplacesList()) tgt.addReplaces(Reference43_N.convertReference(t));
    if (src.hasRequisition())
      tgt.setRequisition(Identifier43_N.convertIdentifier(src.getRequisition()));
    if (src.hasStatus())
      tgt.setStatusElement(convertServiceRequestStatus(src.getStatusElement()));
    if (src.hasIntent())
      tgt.setIntentElement(convertServiceRequestIntent(src.getIntentElement()));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getCategoryList())
      tgt.addCategory(CodeableConcept43_N.convertCodeableConcept(t));
    if (src.hasPriority())
      tgt.setPriorityElement(convertServiceRequestPriority(src.getPriorityElement()));
    if (src.hasDoNotPerform())
      tgt.setDoNotPerformElement(Boolean43_N.convertBoolean(src.getDoNotPerformElement()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_N.convertCodeableReferenceToCodeableConcept(src.getCode()));
    for (ServiceRequestOrderDetailComponent t : src.getOrderDetailList()) {
      if (t.getParameterFirstRep().hasValueCodeableConcept()) {
       tgt.addOrderDetail(CodeableConcept43_N.convertCodeableConcept(t.getParameterFirstRep().getValueCodeableConcept()));
      }
    }
    if (src.hasQuantity())
      tgt.setQuantity(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getQuantity()));
    if (src.hasSubject())
      tgt.setSubject(Reference43_N.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference43_N.convertReference(src.getEncounter()));
    if (src.hasOccurrence())
      tgt.setOccurrence(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getOccurrence()));
    if (src.hasAsNeeded())
      tgt.setAsNeeded(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getAsNeededElement()));
    if (src.hasAuthoredOn())
      tgt.setAuthoredOnElement(DateTime43_N.convertDateTime(src.getAuthoredOnElement()));
    if (src.hasRequester())
      tgt.setRequester(Reference43_N.convertReference(src.getRequester()));
    if (src.hasPerformerType())
      tgt.setPerformerType(CodeableConcept43_N.convertCodeableConcept(src.getPerformerType()));
    for (org.hl7.fhir.model.core.Reference t : src.getPerformerList()) tgt.addPerformer(Reference43_N.convertReference(t));
    for (CodeableReference t : src.getLocationList())
      if (t.hasConcept())
        tgt.addLocationCode(CodeableConcept43_N.convertCodeableConcept(t.getConcept()));
    for (CodeableReference t : src.getLocationList())
      if (t.hasReference())
        tgt.addLocationReference(Reference43_N.convertReference(t.getReference()));
    for (CodeableReference t : src.getReasonList())
      if (t.hasConcept())
        tgt.addReasonCode(CodeableConcept43_N.convertCodeableConcept(t.getConcept()));
    for (CodeableReference t : src.getReasonList())
      if (t.hasReference())
        tgt.addReasonReference(Reference43_N.convertReference(t.getReference()));
    for (org.hl7.fhir.model.core.Reference t : src.getInsuranceList()) tgt.addInsurance(Reference43_N.convertReference(t));
    for (CodeableReference t : src.getSupportingInfoList())
      if (t.hasReference())
        tgt.addSupportingInfo(Reference43_N.convertReference(t.getReference()));
    for (org.hl7.fhir.model.core.CodeableReference  t : src.getBodyStructureList())
      tgt.addBodySite(CodeableConcept43_N.convertCodeableConcept(t.getConcept()));
    for (org.hl7.fhir.model.core.Annotation t : src.getNoteList()) tgt.addNote(Annotation43_N.convertAnnotation(t));
    if (src.getPatientInstructionFirstRep().hasInstructionMarkdownType())
      tgt.setPatientInstructionElement(String43_N.convertString(src.getPatientInstructionFirstRep().getInstructionMarkdownType()));
    for (org.hl7.fhir.model.core.Reference t : src.getRelevantHistoryList())
      tgt.addRelevantHistory(Reference43_N.convertReference(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.RequestStatus> convertServiceRequestStatus(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.RequestStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Enumerations.RequestStatus> tgt = new Enumeration<>(new Enumerations.RequestStatusEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.RequestStatus> convertServiceRequestStatus(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.RequestStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.RequestStatus> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.RequestStatusEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
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
      }
      return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.RequestIntent> convertServiceRequestIntent(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.RequestIntent> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Enumerations.RequestIntent> tgt = new Enumeration<>(new Enumerations.RequestIntentEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.RequestIntent> convertServiceRequestIntent(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.RequestIntent> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.RequestIntent> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.RequestIntentEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
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
      }
      return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.RequestPriority> convertServiceRequestPriority(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.RequestPriority> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Enumerations.RequestPriority> tgt = new Enumeration<>(new Enumerations.RequestPriorityEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.RequestPriority> convertServiceRequestPriority(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.RequestPriority> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.RequestPriority> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.RequestPriorityEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
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
      }
      return tgt;
  }
}