package org.hl7.fhir.convertors.conv10_30.resources10_30;

import org.hl7.fhir.convertors.context.ConversionContext10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.Reference10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.Annotation10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.CodeableConcept10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.Identifier10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.Boolean10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class Procedure10_30 {

  public static org.hl7.fhir.dstu2.model.Procedure convertProcedure(org.hl7.fhir.dstu3.model.Procedure src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Procedure tgt = new org.hl7.fhir.dstu2.model.Procedure();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_30.convertIdentifier(t));
    if (src.hasSubject())
      tgt.setSubject(Reference10_30.convertReference(src.getSubject()));
    if (src.hasStatus())
      tgt.setStatusElement(convertProcedureStatus(src.getStatusElement()));
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept10_30.convertCodeableConcept(src.getCategory()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept10_30.convertCodeableConcept(src.getCode()));
    if (src.hasNotDoneElement())
      tgt.setNotPerformedElement(Boolean10_30.convertBoolean(src.getNotDoneElement()));
    if (src.hasNotDoneReason())
      tgt.addReasonNotPerformed(CodeableConcept10_30.convertCodeableConcept(src.getNotDoneReason()));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getBodySite())
      tgt.addBodySite(CodeableConcept10_30.convertCodeableConcept(t));
    if (src.hasReasonCode())
      tgt.setReason(ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().convertType(src.getReasonCodeFirstRep()));
    for (org.hl7.fhir.dstu3.model.Procedure.ProcedurePerformerComponent t : src.getPerformer())
      tgt.addPerformer(convertProcedurePerformerComponent(t));
    if (src.hasPerformed())
      tgt.setPerformed(ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().convertType(src.getPerformed()));
    if (src.hasContext())
      tgt.setEncounter(Reference10_30.convertReference(src.getContext()));
    if (src.hasLocation())
      tgt.setLocation(Reference10_30.convertReference(src.getLocation()));
    if (src.hasOutcome())
      tgt.setOutcome(CodeableConcept10_30.convertCodeableConcept(src.getOutcome()));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getReport()) tgt.addReport(Reference10_30.convertReference(t));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getComplication())
      tgt.addComplication(CodeableConcept10_30.convertCodeableConcept(t));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getFollowUp())
      tgt.addFollowUp(CodeableConcept10_30.convertCodeableConcept(t));
    if (src.hasBasedOn())
      tgt.setRequest(Reference10_30.convertReference(src.getBasedOnFirstRep()));
    for (org.hl7.fhir.dstu3.model.Procedure.ProcedureFocalDeviceComponent t : src.getFocalDevice())
      tgt.addFocalDevice(convertProcedureFocalDeviceComponent(t));
    for (org.hl7.fhir.dstu3.model.Annotation note : src.getNote())
      tgt.addNotes(Annotation10_30.convertAnnotation(note));
    for (org.hl7.fhir.dstu3.model.Reference r : src.getUsedReference()) tgt.addUsed(Reference10_30.convertReference(r));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Procedure convertProcedure(org.hl7.fhir.dstu2.model.Procedure src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Procedure tgt = new org.hl7.fhir.dstu3.model.Procedure();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu2.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier10_30.convertIdentifier(t));
    if (src.hasSubject())
      tgt.setSubject(Reference10_30.convertReference(src.getSubject()));
    if (src.hasStatus())
      tgt.setStatusElement(convertProcedureStatus(src.getStatusElement()));
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept10_30.convertCodeableConcept(src.getCategory()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept10_30.convertCodeableConcept(src.getCode()));
    if (src.hasNotPerformedElement())
      tgt.setNotDoneElement(Boolean10_30.convertBoolean(src.getNotPerformedElement()));
    if (src.hasReasonNotPerformed())
      tgt.setNotDoneReason(CodeableConcept10_30.convertCodeableConcept(src.getReasonNotPerformed().get(0)));
    for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getBodySite())
      tgt.addBodySite(CodeableConcept10_30.convertCodeableConcept(t));
    if (src.hasReasonCodeableConcept())
      tgt.addReasonCode(CodeableConcept10_30.convertCodeableConcept(src.getReasonCodeableConcept()));
    for (org.hl7.fhir.dstu2.model.Procedure.ProcedurePerformerComponent t : src.getPerformer())
      tgt.addPerformer(convertProcedurePerformerComponent(t));
    if (src.hasPerformed())
      tgt.setPerformed(ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().convertType(src.getPerformed()));
    if (src.hasEncounter())
      tgt.setContext(Reference10_30.convertReference(src.getEncounter()));
    if (src.hasLocation())
      tgt.setLocation(Reference10_30.convertReference(src.getLocation()));
    if (src.hasOutcome())
      tgt.setOutcome(CodeableConcept10_30.convertCodeableConcept(src.getOutcome()));
    for (org.hl7.fhir.dstu2.model.Reference t : src.getReport()) tgt.addReport(Reference10_30.convertReference(t));
    for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getComplication())
      tgt.addComplication(CodeableConcept10_30.convertCodeableConcept(t));
    for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getFollowUp())
      tgt.addFollowUp(CodeableConcept10_30.convertCodeableConcept(t));
    if (src.hasRequest())
      tgt.addBasedOn(Reference10_30.convertReference(src.getRequest()));
    for (org.hl7.fhir.dstu2.model.Procedure.ProcedureFocalDeviceComponent t : src.getFocalDevice())
      tgt.addFocalDevice(convertProcedureFocalDeviceComponent(t));
    for (org.hl7.fhir.dstu2.model.Annotation note : src.getNotes())
      tgt.addNote(Annotation10_30.convertAnnotation(note));
    for (org.hl7.fhir.dstu2.model.Reference r : src.getUsed()) tgt.addUsedReference(Reference10_30.convertReference(r));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Procedure.ProcedureFocalDeviceComponent convertProcedureFocalDeviceComponent(org.hl7.fhir.dstu2.model.Procedure.ProcedureFocalDeviceComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Procedure.ProcedureFocalDeviceComponent tgt = new org.hl7.fhir.dstu3.model.Procedure.ProcedureFocalDeviceComponent();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyBackboneElement(src,tgt);
    if (src.hasAction())
      tgt.setAction(CodeableConcept10_30.convertCodeableConcept(src.getAction()));
    if (src.hasManipulated())
      tgt.setManipulated(Reference10_30.convertReference(src.getManipulated()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Procedure.ProcedureFocalDeviceComponent convertProcedureFocalDeviceComponent(org.hl7.fhir.dstu3.model.Procedure.ProcedureFocalDeviceComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Procedure.ProcedureFocalDeviceComponent tgt = new org.hl7.fhir.dstu2.model.Procedure.ProcedureFocalDeviceComponent();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyBackboneElement(src,tgt);
    if (src.hasAction())
      tgt.setAction(CodeableConcept10_30.convertCodeableConcept(src.getAction()));
    if (src.hasManipulated())
      tgt.setManipulated(Reference10_30.convertReference(src.getManipulated()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.Procedure.ProcedurePerformerComponent convertProcedurePerformerComponent(org.hl7.fhir.dstu3.model.Procedure.ProcedurePerformerComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Procedure.ProcedurePerformerComponent tgt = new org.hl7.fhir.dstu2.model.Procedure.ProcedurePerformerComponent();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyBackboneElement(src,tgt);
    if (src.hasActor())
      tgt.setActor(Reference10_30.convertReference(src.getActor()));
    if (src.hasRole())
      tgt.setRole(CodeableConcept10_30.convertCodeableConcept(src.getRole()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.Procedure.ProcedurePerformerComponent convertProcedurePerformerComponent(org.hl7.fhir.dstu2.model.Procedure.ProcedurePerformerComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Procedure.ProcedurePerformerComponent tgt = new org.hl7.fhir.dstu3.model.Procedure.ProcedurePerformerComponent();
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyBackboneElement(src,tgt);
    if (src.hasActor())
      tgt.setActor(Reference10_30.convertReference(src.getActor()));
    if (src.hasRole())
      tgt.setRole(CodeableConcept10_30.convertCodeableConcept(src.getRole()));
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Procedure.ProcedureStatus> convertProcedureStatus(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Procedure.ProcedureStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Procedure.ProcedureStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Procedure.ProcedureStatusEnumFactory());
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    switch (src.getValue()) {
      case INPROGRESS:
        tgt.setValue(org.hl7.fhir.dstu3.model.Procedure.ProcedureStatus.INPROGRESS);
        break;
      case ABORTED:
        tgt.setValue(org.hl7.fhir.dstu3.model.Procedure.ProcedureStatus.ABORTED);
        break;
      case COMPLETED:
        tgt.setValue(org.hl7.fhir.dstu3.model.Procedure.ProcedureStatus.COMPLETED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.dstu3.model.Procedure.ProcedureStatus.ENTEREDINERROR);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.Procedure.ProcedureStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Procedure.ProcedureStatus> convertProcedureStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Procedure.ProcedureStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.Procedure.ProcedureStatus> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.Procedure.ProcedureStatusEnumFactory());
    ConversionContext10_30.INSTANCE.getVersionConvertor_10_30().copyElement(src, tgt);
    switch (src.getValue()) {
      case INPROGRESS:
        tgt.setValue(org.hl7.fhir.dstu2.model.Procedure.ProcedureStatus.INPROGRESS);
        break;
      case ABORTED:
        tgt.setValue(org.hl7.fhir.dstu2.model.Procedure.ProcedureStatus.ABORTED);
        break;
      case COMPLETED:
        tgt.setValue(org.hl7.fhir.dstu2.model.Procedure.ProcedureStatus.COMPLETED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.dstu2.model.Procedure.ProcedureStatus.ENTEREDINERROR);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu2.model.Procedure.ProcedureStatus.NULL);
        break;
    }
    return tgt;
  }
}