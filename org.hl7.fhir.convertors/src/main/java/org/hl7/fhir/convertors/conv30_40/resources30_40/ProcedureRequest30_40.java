package org.hl7.fhir.convertors.conv30_40.resources30_40;

import java.util.List;

import org.hl7.fhir.convertors.context.ConversionContext30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Reference30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Annotation30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.CodeableConcept30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Identifier30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.Boolean30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.DateTime30_40;
import org.hl7.fhir.dstu3.model.ProcedureRequest;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.Enumeration;
import org.hl7.fhir.r4.model.Reference;
import org.hl7.fhir.r4.model.ServiceRequest;

public class ProcedureRequest30_40 {

  static public org.hl7.fhir.r4.model.ServiceRequest convertProcedureRequest(org.hl7.fhir.dstu3.model.ProcedureRequest src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.ServiceRequest tgt = new org.hl7.fhir.r4.model.ServiceRequest();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) {
      tgt.addIdentifier(Identifier30_40.convertIdentifier(t));
    }
    for (org.hl7.fhir.dstu3.model.Reference t : src.getBasedOn()) {
      tgt.addBasedOn(Reference30_40.convertReference(t));
    }
    for (org.hl7.fhir.dstu3.model.Reference t : src.getReplaces()) {
      tgt.addReplaces(Reference30_40.convertReference(t));
    }
    if (src.hasRequisition()) {
      if (src.hasRequisition())
        tgt.setRequisition(Identifier30_40.convertIdentifier(src.getRequisition()));
    }
    if (src.hasStatus()) {
      if (src.hasStatus())
        tgt.setStatusElement(convertProcedureRequestStatus(src.getStatusElement()));
    }
    if (src.hasIntent()) {
      if (src.hasIntent())
        tgt.setIntentElement(convertProcedureRequestIntent(src.getIntentElement()));
    }
    if (src.hasPriority()) {
      if (src.hasPriority())
        tgt.setPriorityElement(convertProcedureRequestPriority(src.getPriorityElement()));
    }
    if (src.hasDoNotPerform()) {
      if (src.hasDoNotPerformElement())
        tgt.setDoNotPerformElement(Boolean30_40.convertBoolean(src.getDoNotPerformElement()));
    }
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getCategory()) {
      tgt.addCategory(CodeableConcept30_40.convertCodeableConcept(t));
    }
    if (src.hasCode()) {
      if (src.hasCode())
        tgt.setCode(CodeableConcept30_40.convertCodeableConcept(src.getCode()));
    }
    if (src.hasSubject()) {
      if (src.hasSubject())
        tgt.setSubject(Reference30_40.convertReference(src.getSubject()));
    }
    if (src.hasContext()) {
      if (src.hasContext())
        tgt.setEncounter(Reference30_40.convertReference(src.getContext()));
    }
    if (src.hasOccurrence()) {
      if (src.hasOccurrence())
        tgt.setOccurrence(ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().convertType(src.getOccurrence()));
    }
    if (src.hasAsNeeded()) {
      if (src.hasAsNeeded())
        tgt.setAsNeeded(ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().convertType(src.getAsNeeded()));
    }
    if (src.hasAuthoredOn()) {
      if (src.hasAuthoredOnElement())
        tgt.setAuthoredOnElement(DateTime30_40.convertDateTime(src.getAuthoredOnElement()));
    }
    if (src.hasRequester()) {
      org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestRequesterComponent requester = src.getRequester();
      if (requester.hasAgent()) {
        tgt.setRequester(Reference30_40.convertReference(requester.getAgent()));
      }
    }
    if (src.hasPerformerType()) {
      if (src.hasPerformerType())
        tgt.setPerformerType(CodeableConcept30_40.convertCodeableConcept(src.getPerformerType()));
    }
    if (src.hasPerformer()) {
      if (src.hasPerformer())
        tgt.addPerformer(Reference30_40.convertReference(src.getPerformer()));
    }
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getReasonCode()) {
      tgt.addReasonCode(CodeableConcept30_40.convertCodeableConcept(t));
    }
    for (org.hl7.fhir.dstu3.model.Reference t : src.getReasonReference()) {
      tgt.addReasonReference(Reference30_40.convertReference(t));
    }
    for (org.hl7.fhir.dstu3.model.Reference t : src.getSupportingInfo()) {
      tgt.addSupportingInfo(Reference30_40.convertReference(t));
    }
    for (org.hl7.fhir.dstu3.model.Reference t : src.getSpecimen()) {
      tgt.addSpecimen(Reference30_40.convertReference(t));
    }
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getBodySite()) {
      tgt.addBodySite(CodeableConcept30_40.convertCodeableConcept(t));
    }
    for (org.hl7.fhir.dstu3.model.Annotation t : src.getNote()) {
      tgt.addNote(Annotation30_40.convertAnnotation(t));
    }
    for (org.hl7.fhir.dstu3.model.Reference t : src.getRelevantHistory()) {
      tgt.addRelevantHistory(Reference30_40.convertReference(t));
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.ProcedureRequest convertProcedureRequest(org.hl7.fhir.r4.model.ServiceRequest src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.ProcedureRequest tgt = new org.hl7.fhir.dstu3.model.ProcedureRequest();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) {
      tgt.addIdentifier(Identifier30_40.convertIdentifier(t));
    }
    for (org.hl7.fhir.r4.model.Reference t : src.getBasedOn()) {
      tgt.addBasedOn(Reference30_40.convertReference(t));
    }
    for (org.hl7.fhir.r4.model.Reference t : src.getReplaces()) {
      tgt.addReplaces(Reference30_40.convertReference(t));
    }
    if (src.hasRequisition()) {
      if (src.hasRequisition())
        tgt.setRequisition(Identifier30_40.convertIdentifier(src.getRequisition()));
    }
    if (src.hasStatus()) {
      if (src.hasStatus())
        tgt.setStatusElement(convertProcedureRequestStatus(src.getStatusElement()));
    }
    if (src.hasIntent()) {
      if (src.hasIntent())
        tgt.setIntentElement(convertProcedureRequestIntent(src.getIntentElement()));
    }
    if (src.hasPriority()) {
      if (src.hasPriority())
        tgt.setPriorityElement(convertProcedureRequestPriority(src.getPriorityElement()));
    }
    if (src.hasDoNotPerform()) {
      if (src.hasDoNotPerformElement())
        tgt.setDoNotPerformElement(Boolean30_40.convertBoolean(src.getDoNotPerformElement()));
    }
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCategory()) {
      tgt.addCategory(CodeableConcept30_40.convertCodeableConcept(t));
    }
    if (src.hasCode()) {
      if (src.hasCode())
        tgt.setCode(CodeableConcept30_40.convertCodeableConcept(src.getCode()));
    }
    if (src.hasSubject()) {
      if (src.hasSubject())
        tgt.setSubject(Reference30_40.convertReference(src.getSubject()));
    }
    if (src.hasEncounter()) {
      if (src.hasEncounter())
        tgt.setContext(Reference30_40.convertReference(src.getEncounter()));
    }
    if (src.hasOccurrence()) {
      if (src.hasOccurrence())
        tgt.setOccurrence(ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().convertType(src.getOccurrence()));
    }
    if (src.hasAsNeeded()) {
      if (src.hasAsNeeded())
        tgt.setAsNeeded(ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().convertType(src.getAsNeeded()));
    }
    if (src.hasAuthoredOn()) {
      if (src.hasAuthoredOnElement())
        tgt.setAuthoredOnElement(DateTime30_40.convertDateTime(src.getAuthoredOnElement()));
    }
    if (src.hasRequester()) {
      tgt.setRequester(new org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestRequesterComponent(Reference30_40.convertReference(src.getRequester())));
    }
    if (src.hasPerformerType()) {
      if (src.hasPerformerType())
        tgt.setPerformerType(CodeableConcept30_40.convertCodeableConcept(src.getPerformerType()));
    }
    List<Reference> performers = src.getPerformer();
    if (performers.size() > 0) {
      tgt.setPerformer(Reference30_40.convertReference(performers.get(0)));
      if (performers.size() > 1) {
      }
    }
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReasonCode()) {
      tgt.addReasonCode(CodeableConcept30_40.convertCodeableConcept(t));
    }
    for (org.hl7.fhir.r4.model.Reference t : src.getReasonReference()) {
      tgt.addReasonReference(Reference30_40.convertReference(t));
    }
    for (org.hl7.fhir.r4.model.Reference t : src.getSupportingInfo()) {
      tgt.addSupportingInfo(Reference30_40.convertReference(t));
    }
    for (org.hl7.fhir.r4.model.Reference t : src.getSpecimen()) {
      tgt.addSpecimen(Reference30_40.convertReference(t));
    }
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getBodySite()) {
      tgt.addBodySite(CodeableConcept30_40.convertCodeableConcept(t));
    }
    for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) {
      tgt.addNote(Annotation30_40.convertAnnotation(t));
    }
    for (org.hl7.fhir.r4.model.Reference t : src.getRelevantHistory()) {
      tgt.addRelevantHistory(Reference30_40.convertReference(t));
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestIntent> convertProcedureRequestIntent(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestIntent> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<ServiceRequest.ServiceRequestIntent> tgt = new Enumeration<>(new ServiceRequest.ServiceRequestIntentEnumFactory());
      ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case FILLERORDER:
                  tgt.setValue(ServiceRequest.ServiceRequestIntent.FILLERORDER);
                  break;
              case INSTANCEORDER:
                  tgt.setValue(ServiceRequest.ServiceRequestIntent.INSTANCEORDER);
                  break;
              case OPTION:
                  tgt.setValue(ServiceRequest.ServiceRequestIntent.OPTION);
                  break;
              case ORDER:
                  tgt.setValue(ServiceRequest.ServiceRequestIntent.ORDER);
                  break;
              case ORIGINALORDER:
                  tgt.setValue(ServiceRequest.ServiceRequestIntent.ORIGINALORDER);
                  break;
              case PLAN:
                  tgt.setValue(ServiceRequest.ServiceRequestIntent.PLAN);
                  break;
              case PROPOSAL:
                  tgt.setValue(ServiceRequest.ServiceRequestIntent.PROPOSAL);
                  break;
              case REFLEXORDER:
                  tgt.setValue(ServiceRequest.ServiceRequestIntent.REFLEXORDER);
                  break;
              default:
                  tgt.setValue(ServiceRequest.ServiceRequestIntent.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestIntent> convertProcedureRequestIntent(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestIntent> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.dstu3.model.Enumeration<ProcedureRequest.ProcedureRequestIntent> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new ProcedureRequest.ProcedureRequestIntentEnumFactory());
      ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case DIRECTIVE:
                  tgt.setValue(ProcedureRequest.ProcedureRequestIntent.NULL);
                  break;
              case FILLERORDER:
                  tgt.setValue(ProcedureRequest.ProcedureRequestIntent.FILLERORDER);
                  break;
              case INSTANCEORDER:
                  tgt.setValue(ProcedureRequest.ProcedureRequestIntent.INSTANCEORDER);
                  break;
              case OPTION:
                  tgt.setValue(ProcedureRequest.ProcedureRequestIntent.OPTION);
                  break;
              case ORDER:
                  tgt.setValue(ProcedureRequest.ProcedureRequestIntent.ORDER);
                  break;
              case ORIGINALORDER:
                  tgt.setValue(ProcedureRequest.ProcedureRequestIntent.ORIGINALORDER);
                  break;
              case PLAN:
                  tgt.setValue(ProcedureRequest.ProcedureRequestIntent.PLAN);
                  break;
              case PROPOSAL:
                  tgt.setValue(ProcedureRequest.ProcedureRequestIntent.PROPOSAL);
                  break;
              case REFLEXORDER:
                  tgt.setValue(ProcedureRequest.ProcedureRequestIntent.REFLEXORDER);
                  break;
              default:
                  tgt.setValue(ProcedureRequest.ProcedureRequestIntent.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestPriority> convertProcedureRequestPriority(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestPriority> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.dstu3.model.Enumeration<ProcedureRequest.ProcedureRequestPriority> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new ProcedureRequest.ProcedureRequestPriorityEnumFactory());
      ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case ASAP:
                  tgt.setValue(ProcedureRequest.ProcedureRequestPriority.ASAP);
                  break;
              case ROUTINE:
                  tgt.setValue(ProcedureRequest.ProcedureRequestPriority.ROUTINE);
                  break;
              case STAT:
                  tgt.setValue(ProcedureRequest.ProcedureRequestPriority.STAT);
                  break;
              case URGENT:
                  tgt.setValue(ProcedureRequest.ProcedureRequestPriority.URGENT);
                  break;
              default:
                  tgt.setValue(ProcedureRequest.ProcedureRequestPriority.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestPriority> convertProcedureRequestPriority(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestPriority> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<ServiceRequest.ServiceRequestPriority> tgt = new Enumeration<>(new ServiceRequest.ServiceRequestPriorityEnumFactory());
      ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case ASAP:
                  tgt.setValue(ServiceRequest.ServiceRequestPriority.ASAP);
                  break;
              case ROUTINE:
                  tgt.setValue(ServiceRequest.ServiceRequestPriority.ROUTINE);
                  break;
              case STAT:
                  tgt.setValue(ServiceRequest.ServiceRequestPriority.STAT);
                  break;
              case URGENT:
                  tgt.setValue(ServiceRequest.ServiceRequestPriority.URGENT);
                  break;
              default:
                  tgt.setValue(ServiceRequest.ServiceRequestPriority.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestStatus> convertProcedureRequestStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.dstu3.model.Enumeration<ProcedureRequest.ProcedureRequestStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new ProcedureRequest.ProcedureRequestStatusEnumFactory());
      ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case ACTIVE:
                  tgt.setValue(ProcedureRequest.ProcedureRequestStatus.ACTIVE);
                  break;
              case COMPLETED:
                  tgt.setValue(ProcedureRequest.ProcedureRequestStatus.COMPLETED);
                  break;
              case DRAFT:
                  tgt.setValue(ProcedureRequest.ProcedureRequestStatus.DRAFT);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(ProcedureRequest.ProcedureRequestStatus.ENTEREDINERROR);
                  break;
              case ONHOLD:
                  tgt.setValue(ProcedureRequest.ProcedureRequestStatus.SUSPENDED);
                  break;
              case REVOKED:
                  tgt.setValue(ProcedureRequest.ProcedureRequestStatus.CANCELLED);
                  break;
              case UNKNOWN:
                  tgt.setValue(ProcedureRequest.ProcedureRequestStatus.UNKNOWN);
                  break;
              default:
                  tgt.setValue(ProcedureRequest.ProcedureRequestStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestStatus> convertProcedureRequestStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.ProcedureRequest.ProcedureRequestStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<ServiceRequest.ServiceRequestStatus> tgt = new Enumeration<>(new ServiceRequest.ServiceRequestStatusEnumFactory());
      ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case ACTIVE:
                  tgt.setValue(ServiceRequest.ServiceRequestStatus.ACTIVE);
                  break;
              case CANCELLED:
                  tgt.setValue(ServiceRequest.ServiceRequestStatus.REVOKED);
                  break;
              case COMPLETED:
                  tgt.setValue(ServiceRequest.ServiceRequestStatus.COMPLETED);
                  break;
              case DRAFT:
                  tgt.setValue(ServiceRequest.ServiceRequestStatus.DRAFT);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(ServiceRequest.ServiceRequestStatus.ENTEREDINERROR);
                  break;
              case SUSPENDED:
                  tgt.setValue(ServiceRequest.ServiceRequestStatus.ONHOLD);
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
}