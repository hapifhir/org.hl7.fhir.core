package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.CrossVersionDatatype40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.CrossVersionElements40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Annotation40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Identifier40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Boolean40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Canonical40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.DateTime40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.String40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Uri40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Reference40_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.ServiceRequest;
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

public class ServiceRequest40_N {

  public static org.hl7.fhir.model.core.ServiceRequest convertServiceRequest(org.hl7.fhir.r4.model.ServiceRequest src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.ServiceRequest tgt = new org.hl7.fhir.model.core.ServiceRequest();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt, CrossVersionElements40_N.urls("ServiceRequest", "5.0", new String[] {"focus"}, CrossVersionElements40_N.urls("ServiceRequest", "6.0", new String[] {"statusReason"}, CrossVersionElements40_N.url("ServiceRequest", "5.0", "orderDetail"), CrossVersionElements40_N.url("ServiceRequest", "5.0", "supportingInfo"), CrossVersionElements40_N.url("ServiceRequest", "5.0", "patientInstruction"), CrossVersionElements40_N.url("ServiceRequest", "5.0", "asNeeded"), VersionConvertorConstants.EXT_SERVICEREQUEST_AS_NEEDED_FOR)));
    // R6 dropped these
    CrossVersionElements40_N.r4ElementsToExtensions(src, "ServiceRequest", tgt.getExtension(), "instantiatesCanonical", "instantiatesUri", "specimen");
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "5.0", "focus");
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "6.0", "statusReason");
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getBasedOn()) tgt.addBasedOn(Reference40_N.convertReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getReplaces()) tgt.addReplaces(Reference40_N.convertReference(t));
    if (src.hasRequisition())
      tgt.setRequisition(Identifier40_N.convertIdentifier(src.getRequisition()));
    if (src.hasStatus())
      tgt.setStatusElement(CrossVersionElements40_N.toR6Code(src.getStatusElement(), convertServiceRequestStatus(src.getStatusElement()), src.fhirType(), "status"));
    if (src.hasIntent())
      tgt.setIntentElement(CrossVersionElements40_N.toR6Code(src.getIntentElement(), convertServiceRequestIntent(src.getIntentElement()), src.fhirType(), "intent"));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCategory())
      tgt.addCategory(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasPriority())
      tgt.setPriorityElement(CrossVersionElements40_N.toR6Code(src.getPriorityElement(), convertServiceRequestPriority(src.getPriorityElement()), src.fhirType(), "priority"));
    if (src.hasDoNotPerform())
      tgt.setDoNotPerformElement(Boolean40_N.convertBoolean(src.getDoNotPerformElement()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_N.convertCodeableConceptToCodeableReference(src.getCode()));
    // R6 requires orderDetail.parameter.code, and R4 has nothing to put there, so this isn't valid;
    // see https://jira.hl7.org/browse/FHIR-59958
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getOrderDetail())
      tgt.addOrderDetail().addParameter().setValue(CodeableConcept40_N.convertCodeableConcept(t));
    // the order details that were more than a single concept
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "5.0", "orderDetail");
    // the types R4 and R6 allow differ: a value of a type the other version doesn't allow is an extension
    CrossVersionElements40_N.choiceToR6(src, src.getExtension(), src.fhirType(), "quantity", tgt, tgt.getExtension());
    if (src.hasSubject())
      tgt.setSubject(Reference40_N.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference40_N.convertReference(src.getEncounter()));
    // the types R4 and R6 allow differ: a value of a type the other version doesn't allow is an extension
    CrossVersionElements40_N.choiceToR6(src, src.getExtension(), src.fhirType(), "occurrence", tgt, tgt.getExtension());
    // R4 asNeeded[x] is boolean|CodeableConcept; R6 has asNeeded (boolean) and asNeededFor (0..*)
    if (src.hasAsNeededBooleanType())
      tgt.setAsNeededElement(Boolean40_N.convertBoolean(src.getAsNeededBooleanType()));
    else if (src.hasAsNeededCodeableConcept())
      tgt.addAsNeededFor(CodeableConcept40_N.convertCodeableConcept(src.getAsNeededCodeableConcept()));
    // an explicit R6 asNeeded alongside asNeededFor
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "5.0", "asNeeded");
    for (org.hl7.fhir.r4.model.Extension ext : src.getExtensionsByUrl(VersionConvertorConstants.EXT_SERVICEREQUEST_AS_NEEDED_FOR))
      tgt.addAsNeededFor(CodeableConcept40_N.convertCodeableConcept((org.hl7.fhir.r4.model.CodeableConcept) ext.getValue()));
    if (src.hasAuthoredOn())
      tgt.setAuthoredOnElement(DateTime40_N.convertDateTime(src.getAuthoredOnElement()));
    if (src.hasRequester())
      tgt.setRequester(Reference40_N.convertReference(src.getRequester()));
    if (src.hasPerformerType())
      tgt.setPerformerType(CodeableConcept40_N.convertCodeableConcept(src.getPerformerType()));
    for (org.hl7.fhir.r4.model.Reference t : src.getPerformer()) tgt.addPerformer(Reference40_N.convertReference(t));
    CodeableConcept40_N.convertReasonsToR6(src.getLocationCode(), src.getLocationReference(), tgt.getLocationList());
    CodeableConcept40_N.convertReasonsToR6(src.getReasonCode(), src.getReasonReference(), tgt.getReasonList());
    for (org.hl7.fhir.r4.model.Reference t : src.getInsurance()) tgt.addInsurance(Reference40_N.convertReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getSupportingInfo())
      tgt.addSupportingInfo(Reference40_N.convertReferenceToCodeableReference(t));
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "5.0", "supportingInfo");
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getBodySite())
      tgt.addBodyStructure(CodeableConcept40_N.convertCodeableConceptToCodeableReference(t));
    for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.addNote(Annotation40_N.convertAnnotation(t));
    if (src.hasPatientInstruction())
      tgt.addPatientInstruction().setInstruction(String40_N.convertStringToMarkdown(src.getPatientInstructionElement()));
    CrossVersionElements40_N.extensionsToElements(src.getExtension(), tgt, "5.0", "patientInstruction");
    for (org.hl7.fhir.r4.model.Reference t : src.getRelevantHistory())
      tgt.addRelevantHistory(Reference40_N.convertReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.ServiceRequest convertServiceRequest(org.hl7.fhir.model.core.ServiceRequest src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ServiceRequest tgt = new org.hl7.fhir.r4.model.ServiceRequest();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt, CrossVersionElements40_N.urls("ServiceRequest", "4.0", new String[] {"instantiatesCanonical", "instantiatesUri", "specimen"}));
    CrossVersionElements40_N.extensionsToR4Elements(src.getExtension(), tgt, "ServiceRequest", "instantiatesCanonical", "instantiatesUri", "specimen");
    CrossVersionElements40_N.elementsToExtensions(src, tgt.getExtension(), "5.0", "focus");
    CrossVersionElements40_N.elementsToExtensions(src, tgt.getExtension(), "6.0", "statusReason");
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    for (org.hl7.fhir.model.core.Reference t : src.getBasedOnList()) tgt.addBasedOn(Reference40_N.convertReference(t));
    for (org.hl7.fhir.model.core.Reference t : src.getReplacesList()) tgt.addReplaces(Reference40_N.convertReference(t));
    if (src.hasRequisition())
      tgt.setRequisition(Identifier40_N.convertIdentifier(src.getRequisition()));
    if (src.hasStatus())
      tgt.setStatusElement(CrossVersionElements40_N.toR4Code(src.getStatusElement(), convertServiceRequestStatus(src.getStatusElement()), src.fhirType(), "status"));
    if (src.hasIntent())
      tgt.setIntentElement(CrossVersionElements40_N.toR4Code(src.getIntentElement(), convertServiceRequestIntent(src.getIntentElement()), src.fhirType(), "intent"));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getCategoryList())
      tgt.addCategory(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasPriority())
      tgt.setPriorityElement(CrossVersionElements40_N.toR4Code(src.getPriorityElement(), convertServiceRequestPriority(src.getPriorityElement()), src.fhirType(), "priority"));
    if (src.hasDoNotPerform())
      tgt.setDoNotPerformElement(Boolean40_N.convertBoolean(src.getDoNotPerformElement()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_N.convertCodeableReferenceToCodeableConcept(src.getCode()));
    // R4 orderDetail is a list of concepts: an R6 orderDetail that's just a single concept parameter value is one;
    // the rest go in 5.0 extensions
    for (ServiceRequestOrderDetailComponent t : src.getOrderDetailList()) {
      if (isSimpleOrderDetail(t))
        tgt.addOrderDetail(CodeableConcept40_N.convertCodeableConcept(t.getParameterFirstRep().getValueCodeableConcept()));
      else
        tgt.addExtension(CrossVersionDatatype40_N.convertToExtension(CrossVersionElements40_N.url("ServiceRequest", "5.0", "orderDetail"), t));
    }
    CrossVersionElements40_N.choiceToR4(src, src.getExtension(), src.fhirType(), "quantity", tgt, tgt.getExtension());
    if (src.hasSubject())
      tgt.setSubject(Reference40_N.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference40_N.convertReference(src.getEncounter()));
    CrossVersionElements40_N.choiceToR4(src, src.getExtension(), src.fhirType(), "occurrence", tgt, tgt.getExtension());
    // R4 asNeeded[x] is boolean|CodeableConcept: the first asNeededFor goes there (asNeeded = true is implied), and
    // the rest go in the cross-version extension
    if (src.hasAsNeededFor()) {
      tgt.setAsNeeded(CodeableConcept40_N.convertCodeableConcept(src.getAsNeededForList().get(0)));
      for (int i = 1; i < src.getAsNeededForList().size(); i++)
        tgt.addExtension(VersionConvertorConstants.EXT_SERVICEREQUEST_AS_NEEDED_FOR, CodeableConcept40_N.convertCodeableConcept(src.getAsNeededForList().get(i)));
      // asNeeded is implied by asNeededFor, but it might be there too
      if (src.hasAsNeededElement())
        tgt.addExtension(CrossVersionElements40_N.url("ServiceRequest", "5.0", "asNeeded"), Boolean40_N.convertBoolean(src.getAsNeededElement()));
    } else if (src.hasAsNeeded())
      tgt.setAsNeeded(Boolean40_N.convertBoolean(src.getAsNeededElement()));
    if (src.hasAuthoredOn())
      tgt.setAuthoredOnElement(DateTime40_N.convertDateTime(src.getAuthoredOnElement()));
    if (src.hasRequester())
      tgt.setRequester(Reference40_N.convertReference(src.getRequester()));
    if (src.hasPerformerType())
      tgt.setPerformerType(CodeableConcept40_N.convertCodeableConcept(src.getPerformerType()));
    for (org.hl7.fhir.model.core.Reference t : src.getPerformerList()) tgt.addPerformer(Reference40_N.convertReference(t));
    CodeableConcept40_N.convertReasonsToR4(src.getLocationList(), tgt.getLocationCode(), tgt.getLocationReference());
    CodeableConcept40_N.convertReasonsToR4(src.getReasonList(), tgt.getReasonCode(), tgt.getReasonReference());
    for (org.hl7.fhir.model.core.Reference t : src.getInsuranceList()) tgt.addInsurance(Reference40_N.convertReference(t));
    for (CodeableReference t : src.getSupportingInfoList()) {
      if (t.hasReference() && !t.hasConcept() && !t.hasId() && !t.hasExtension())
        tgt.addSupportingInfo(Reference40_N.convertReference(t.getReference()));
      else
        tgt.addExtension(CrossVersionDatatype40_N.convertToExtension(CrossVersionElements40_N.url("ServiceRequest", "5.0", "supportingInfo"), t));
    }
    for (org.hl7.fhir.model.core.CodeableReference  t : src.getBodyStructureList())
      tgt.addBodySite(CodeableConcept40_N.convertCodeableReferenceToCodeableConcept(t));
    for (org.hl7.fhir.model.core.Annotation t : src.getNoteList()) tgt.addNote(Annotation40_N.convertAnnotation(t));
    // R4 patientInstruction is a single string: the first instruction that's just markdown; the rest in 5.0 extensions
    for (org.hl7.fhir.model.core.ServiceRequest.ServiceRequestPatientInstructionComponent t : src.getPatientInstructionList()) {
      if (!tgt.hasPatientInstruction() && t.hasInstructionMarkdownType() && !t.hasId() && !t.hasExtension() && !t.hasModifierExtension())
        tgt.setPatientInstructionElement(String40_N.convertString(t.getInstructionMarkdownType()));
      else
        tgt.addExtension(CrossVersionDatatype40_N.convertToExtension(CrossVersionElements40_N.url("ServiceRequest", "5.0", "patientInstruction"), t));
    }
    for (org.hl7.fhir.model.core.Reference t : src.getRelevantHistoryList())
      tgt.addRelevantHistory(Reference40_N.convertReference(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.RequestStatus> convertServiceRequestStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestStatus> src) throws FHIRException {
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestStatus> convertServiceRequestStatus(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.RequestStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<ServiceRequest.ServiceRequestStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new ServiceRequest.ServiceRequestStatusEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
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

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.RequestIntent> convertServiceRequestIntent(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestIntent> src) throws FHIRException {
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestIntent> convertServiceRequestIntent(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.RequestIntent> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<ServiceRequest.ServiceRequestIntent> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new ServiceRequest.ServiceRequestIntentEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
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

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.RequestPriority> convertServiceRequestPriority(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestPriority> src) throws FHIRException {
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestPriority> convertServiceRequestPriority(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.RequestPriority> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<ServiceRequest.ServiceRequestPriority> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new ServiceRequest.ServiceRequestPriorityEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
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

  private static boolean isSimpleOrderDetail(ServiceRequestOrderDetailComponent t) {
    return !t.hasId() && !t.hasExtension() && !t.hasModifierExtension() && !t.hasParameterFocus() && t.getParameterList().size() == 1
      && t.getParameterFirstRep().hasValueCodeableConcept() && !t.getParameterFirstRep().hasCode() && !t.getParameterFirstRep().hasId()
      && !t.getParameterFirstRep().hasExtension() && !t.getParameterFirstRep().hasModifierExtension();
  }
}
