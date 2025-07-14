package org.hl7.fhir.convertors.conv30_40.resources30_40;

import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.convertors.context.ConversionContext30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Reference30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Annotation30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.CodeableConcept30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Identifier30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.DateTime30_40;
import org.hl7.fhir.exceptions.FHIRException;


/**
 * Conversion mapping for communication request, mapping is based on conversion map found at:
 * https://hl7.org/fhir/R4/communicationrequest-version-maps.html
 */
public class CommunicationRequest30_40 {

  public static org.hl7.fhir.dstu3.model.CommunicationRequest convertCommunicationRequest(org.hl7.fhir.r4.model.CommunicationRequest src) throws FHIRException {
    if (src == null) {
      return null;
    }

    org.hl7.fhir.dstu3.model.CommunicationRequest tgt = new org.hl7.fhir.dstu3.model.CommunicationRequest();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyDomainResource(src, tgt, VersionConvertorConstants.EXT_COM_REQ_ONBEHALF);

    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) {
      tgt.addIdentifier(Identifier30_40.convertIdentifier(t));
    }
    for (org.hl7.fhir.r4.model.Reference t : src.getBasedOn()) {
      tgt.addBasedOn(Reference30_40.convertReference(t));
    }
    for (org.hl7.fhir.r4.model.Reference t : src.getReplaces()) {
      tgt.addReplaces(Reference30_40.convertReference(t));
    }

    if (src.hasGroupIdentifier()) {
      tgt.setGroupIdentifier(Identifier30_40.convertIdentifier(src.getGroupIdentifier()));
    }
    if (src.hasStatus()) {
      tgt.setStatus(org.hl7.fhir.dstu3.model.CommunicationRequest.CommunicationRequestStatus.fromCode(src.getStatus().toCode()));
    }

    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getCategory()) {
      tgt.addCategory(CodeableConcept30_40.convertCodeableConcept(t));
    }

    if (src.hasPriority()) {
      tgt.setPriority(org.hl7.fhir.dstu3.model.CommunicationRequest.CommunicationPriority.fromCode(src.getPriority().toCode()));
    }

    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getMedium()) {
      tgt.addMedium(CodeableConcept30_40.convertCodeableConcept(t));
    }

    if (src.hasSubject()) {
      tgt.setSubject(Reference30_40.convertReference(src.getSubject()));
    }

    for (org.hl7.fhir.r4.model.Reference t : src.getRecipient()) {
      tgt.addRecipient(Reference30_40.convertReference(t));
    }

    for (org.hl7.fhir.r4.model.Reference t : src.getAbout()) {
      tgt.addTopic(Reference30_40.convertReference(t));
    }

    if (src.hasEncounter()) {
      tgt.setContext(Reference30_40.convertReference(src.getEncounter()));
    }

    for (org.hl7.fhir.r4.model.CommunicationRequest.CommunicationRequestPayloadComponent t : src.getPayload()) {
      tgt.addPayload(convertPayloadComponent(t));
    }

    if (src.hasOccurrence()) {
      tgt.setOccurrence(ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().convertType(src.getOccurrence()));
    }

    if (src.hasAuthoredOn()) {
      tgt.setAuthoredOnElement(DateTime30_40.convertDateTime(src.getAuthoredOnElement()));
    }

    if (src.hasSender()) {
      tgt.setSender(Reference30_40.convertReference(src.getSender()));
    }

    if (src.hasRequester()) {
      tgt.setRequester(new org.hl7.fhir.dstu3.model.CommunicationRequest.CommunicationRequestRequesterComponent());
      if (src.hasRequester()) {
        tgt.getRequester().setAgent(Reference30_40.convertReference(src.getRequester()));
      }
      if (src.hasExtension(VersionConvertorConstants.EXT_COM_REQ_ONBEHALF)) {
        org.hl7.fhir.r4.model.Extension extension = src.getExtensionByUrl(VersionConvertorConstants.EXT_COM_REQ_ONBEHALF);
        if (extension.getValue() instanceof org.hl7.fhir.r4.model.Reference) {
          tgt.getRequester().setOnBehalfOf(Reference30_40.convertReference((org.hl7.fhir.r4.model.Reference) extension.getValue()));
        }
      }
    }

    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReasonCode()) {
      tgt.addReasonCode(CodeableConcept30_40.convertCodeableConcept(t));
    }
    for (org.hl7.fhir.r4.model.Reference t : src.getReasonReference()) {
      tgt.addReasonReference(Reference30_40.convertReference(t));
    }

    for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) {
      tgt.addNote(Annotation30_40.convertAnnotation(t));
    }

    return tgt;
  }

  public static org.hl7.fhir.r4.model.CommunicationRequest convertCommunicationRequest(org.hl7.fhir.dstu3.model.CommunicationRequest src) throws FHIRException {
    if (src == null) {
      return null;
    }

    org.hl7.fhir.r4.model.CommunicationRequest tgt = new org.hl7.fhir.r4.model.CommunicationRequest();
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

    if (src.hasGroupIdentifier()) {
      tgt.setGroupIdentifier(Identifier30_40.convertIdentifier(src.getGroupIdentifier()));
    }
    if (src.hasStatus()) {
      tgt.setStatus(org.hl7.fhir.r4.model.CommunicationRequest.CommunicationRequestStatus.fromCode(src.getStatus().toCode()));
    }

    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getCategory()) {
      tgt.addCategory(CodeableConcept30_40.convertCodeableConcept(t));
    }

    if (src.hasPriority()) {
      tgt.setPriority(org.hl7.fhir.r4.model.CommunicationRequest.CommunicationPriority.fromCode(src.getPriority().toCode()));
    }


    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getMedium()) {
      tgt.addMedium(CodeableConcept30_40.convertCodeableConcept(t));
    }

    if (src.hasSubject()) {
      tgt.setSubject(Reference30_40.convertReference(src.getSubject()));
    }

    for (org.hl7.fhir.dstu3.model.Reference t : src.getRecipient()) {
      tgt.addRecipient(Reference30_40.convertReference(t));
    }

    for (org.hl7.fhir.dstu3.model.Reference t : src.getTopic()) {
      tgt.addAbout(Reference30_40.convertReference(t));
    }

    if (src.hasContext()) {
      tgt.setEncounter(Reference30_40.convertReference(src.getContext()));
    }

    for (org.hl7.fhir.dstu3.model.CommunicationRequest.CommunicationRequestPayloadComponent t : src.getPayload()) {
      tgt.addPayload(convertPayloadComponent(t));
    }

    if (src.hasOccurrence()) {
      tgt.setOccurrence(ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().convertType(src.getOccurrence()));
    }

    if (src.hasAuthoredOn()) {
      tgt.setAuthoredOnElement(DateTime30_40.convertDateTime(src.getAuthoredOnElement()));
    }

    if (src.hasSender()) {
      tgt.setSender(Reference30_40.convertReference(src.getSender()));
    }
    
    if (src.hasRequester()) {
      if (src.getRequester().hasAgent()) {
        tgt.setRequester(Reference30_40.convertReference(src.getRequester().getAgent()));
      }
      if (src.getRequester().hasOnBehalfOf()) {
        tgt.addExtension(VersionConvertorConstants.EXT_COM_REQ_ONBEHALF, Reference30_40.convertReference(src.getRequester().getOnBehalfOf()));
      }
    }

    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getReasonCode()) {
      tgt.addReasonCode(CodeableConcept30_40.convertCodeableConcept(t));
    }
    for (org.hl7.fhir.dstu3.model.Reference t : src.getReasonReference()) {
      tgt.addReasonReference(Reference30_40.convertReference(t));
    }

    for (org.hl7.fhir.dstu3.model.Annotation t : src.getNote()) {
      tgt.addNote(Annotation30_40.convertAnnotation(t));
    }


    return tgt;
  }

  public static org.hl7.fhir.r4.model.CommunicationRequest.CommunicationRequestPayloadComponent convertPayloadComponent(org.hl7.fhir.dstu3.model.CommunicationRequest.CommunicationRequestPayloadComponent src) {
    if (src == null)
      return null;

    org.hl7.fhir.r4.model.CommunicationRequest.CommunicationRequestPayloadComponent tgt = new org.hl7.fhir.r4.model.CommunicationRequest.CommunicationRequestPayloadComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src, tgt);

    if (src.hasContent()) {
      tgt.setContent(ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().convertType(src.getContent()));
    }

    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.CommunicationRequest.CommunicationRequestPayloadComponent convertPayloadComponent(org.hl7.fhir.r4.model.CommunicationRequest.CommunicationRequestPayloadComponent src) {
    if (src == null)
      return null;

    org.hl7.fhir.dstu3.model.CommunicationRequest.CommunicationRequestPayloadComponent tgt = new org.hl7.fhir.dstu3.model.CommunicationRequest.CommunicationRequestPayloadComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src, tgt);

    if (src.hasContent()) {
      tgt.setContent(ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().convertType(src.getContent()));
    }

    return tgt;
  }


}
