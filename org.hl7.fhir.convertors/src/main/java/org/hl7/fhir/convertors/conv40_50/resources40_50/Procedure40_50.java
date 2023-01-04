package org.hl7.fhir.convertors.conv40_50.resources40_50;

import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Annotation40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.CodeableConcept40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Identifier40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Canonical40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Uri40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.special40_50.Reference40_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CodeableReference;

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
public class Procedure40_50 {

  public static org.hl7.fhir.r5.model.Procedure convertProcedure(org.hl7.fhir.r4.model.Procedure src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Procedure tgt = new org.hl7.fhir.r5.model.Procedure();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_50.convertIdentifier(t));
    for (org.hl7.fhir.r4.model.CanonicalType t : src.getInstantiatesCanonical())
      tgt.getInstantiatesCanonical().add(Canonical40_50.convertCanonical(t));
    for (org.hl7.fhir.r4.model.UriType t : src.getInstantiatesUri())
      tgt.getInstantiatesUri().add(Uri40_50.convertUri(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getBasedOn()) tgt.addBasedOn(Reference40_50.convertReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getPartOf()) tgt.addPartOf(Reference40_50.convertReference(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertProcedureStatus(src.getStatusElement()));
    if (src.hasStatusReason())
      tgt.setStatusReason(CodeableConcept40_50.convertCodeableConcept(src.getStatusReason()));
    if (src.hasCategory())
      tgt.addCategory(CodeableConcept40_50.convertCodeableConcept(src.getCategory()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_50.convertCodeableConcept(src.getCode()));
    if (src.hasSubject())
      tgt.setSubject(Reference40_50.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference40_50.convertReference(src.getEncounter()));
    if (src.hasPerformed())
      tgt.setOccurrence(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getPerformed()));
    if (src.hasRecorder())
      tgt.setRecorder(Reference40_50.convertReference(src.getRecorder()));
    if (src.hasAsserter())
      tgt.setReported(Reference40_50.convertReference(src.getAsserter()));
    for (org.hl7.fhir.r4.model.Procedure.ProcedurePerformerComponent t : src.getPerformer())
      tgt.addPerformer(convertProcedurePerformerComponent(t));
    if (src.hasLocation())
      tgt.setLocation(Reference40_50.convertReference(src.getLocation()));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReasonCode())
      tgt.addReason(CodeableConcept40_50.convertCodeableConceptToCodeableReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getReasonReference())
      tgt.addReason(Reference40_50.convertReferenceToCodeableReference(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getBodySite())
      tgt.addBodySite(CodeableConcept40_50.convertCodeableConcept(t));
    if (src.hasOutcome())
      tgt.setOutcome(CodeableConcept40_50.convertCodeableConcept(src.getOutcome()));
    for (org.hl7.fhir.r4.model.Reference t : src.getReport()) tgt.addReport(Reference40_50.convertReference(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getComplication())
      tgt.addComplication().setConcept(CodeableConcept40_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getComplicationDetail())
      tgt.addComplication().setReference(Reference40_50.convertReference(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getFollowUp())
      tgt.addFollowUp(CodeableConcept40_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.addNote(Annotation40_50.convertAnnotation(t));
    for (org.hl7.fhir.r4.model.Procedure.ProcedureFocalDeviceComponent t : src.getFocalDevice())
      tgt.addFocalDevice(convertProcedureFocalDeviceComponent(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getUsedReference())
      tgt.addUsed(Reference40_50.convertReferenceToCodeableReference(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getUsedCode())
      tgt.addUsed(CodeableConcept40_50.convertCodeableConceptToCodeableReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Procedure convertProcedure(org.hl7.fhir.r5.model.Procedure src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Procedure tgt = new org.hl7.fhir.r4.model.Procedure();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_50.convertIdentifier(t));
    for (org.hl7.fhir.r5.model.CanonicalType t : src.getInstantiatesCanonical())
      tgt.getInstantiatesCanonical().add(Canonical40_50.convertCanonical(t));
    for (org.hl7.fhir.r5.model.UriType t : src.getInstantiatesUri())
      tgt.getInstantiatesUri().add(Uri40_50.convertUri(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getBasedOn()) tgt.addBasedOn(Reference40_50.convertReference(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getPartOf()) tgt.addPartOf(Reference40_50.convertReference(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertProcedureStatus(src.getStatusElement()));
    if (src.hasStatusReason())
      tgt.setStatusReason(CodeableConcept40_50.convertCodeableConcept(src.getStatusReason()));
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept40_50.convertCodeableConcept(src.getCategoryFirstRep()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept40_50.convertCodeableConcept(src.getCode()));
    if (src.hasSubject())
      tgt.setSubject(Reference40_50.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference40_50.convertReference(src.getEncounter()));
    if (src.hasOccurrence())
      tgt.setPerformed(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getOccurrence()));
    if (src.hasRecorder())
      tgt.setRecorder(Reference40_50.convertReference(src.getRecorder()));
    if (src.hasReportedReference())
      tgt.setAsserter(Reference40_50.convertReference(src.getReportedReference()));
    for (org.hl7.fhir.r5.model.Procedure.ProcedurePerformerComponent t : src.getPerformer())
      tgt.addPerformer(convertProcedurePerformerComponent(t));
    if (src.hasLocation())
      tgt.setLocation(Reference40_50.convertReference(src.getLocation()));
    for (CodeableReference t : src.getReason())
      if (t.hasConcept())
        tgt.addReasonCode(CodeableConcept40_50.convertCodeableConcept(t.getConcept()));
    for (CodeableReference t : src.getReason())
      if (t.hasReference())
        tgt.addReasonReference(Reference40_50.convertReference(t.getReference()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getBodySite())
      tgt.addBodySite(CodeableConcept40_50.convertCodeableConcept(t));
    if (src.hasOutcome())
      tgt.setOutcome(CodeableConcept40_50.convertCodeableConcept(src.getOutcome()));
    for (org.hl7.fhir.r5.model.Reference t : src.getReport()) tgt.addReport(Reference40_50.convertReference(t));
    for (CodeableReference t : src.getComplication()) {
      if (t.hasConcept()) {
        tgt.addComplication(CodeableConcept40_50.convertCodeableConcept(t.getConcept()));
      }
      if (t.hasReference()) {
        tgt.addComplicationDetail(Reference40_50.convertReference(t.getReference()));
      }
    }
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getFollowUp())
      tgt.addFollowUp(CodeableConcept40_50.convertCodeableConcept(t));
    for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.addNote(Annotation40_50.convertAnnotation(t));
    for (org.hl7.fhir.r5.model.Procedure.ProcedureFocalDeviceComponent t : src.getFocalDevice())
      tgt.addFocalDevice(convertProcedureFocalDeviceComponent(t));
    for (CodeableReference t : src.getUsed())
      if (t.hasReference())
        tgt.addUsedReference(Reference40_50.convertReference(t.getReference()));
    for (CodeableReference t : src.getUsed())
      if (t.hasConcept())
        tgt.addUsedCode(CodeableConcept40_50.convertCodeableConcept(t.getConcept()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.EventStatus> convertProcedureStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Procedure.ProcedureStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.EventStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.EventStatusEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case PREPARATION:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.EventStatus.PREPARATION);
        break;
      case INPROGRESS:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.EventStatus.INPROGRESS);
        break;
      case NOTDONE:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.EventStatus.NOTDONE);
        break;
      case ONHOLD:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.EventStatus.ONHOLD);
        break;
      case STOPPED:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.EventStatus.STOPPED);
        break;
      case COMPLETED:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.EventStatus.COMPLETED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.EventStatus.ENTEREDINERROR);
        break;
      case UNKNOWN:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.EventStatus.UNKNOWN);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.Enumerations.EventStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Procedure.ProcedureStatus> convertProcedureStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.EventStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Procedure.ProcedureStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Procedure.ProcedureStatusEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case PREPARATION:
        tgt.setValue(org.hl7.fhir.r4.model.Procedure.ProcedureStatus.PREPARATION);
        break;
      case INPROGRESS:
        tgt.setValue(org.hl7.fhir.r4.model.Procedure.ProcedureStatus.INPROGRESS);
        break;
      case NOTDONE:
        tgt.setValue(org.hl7.fhir.r4.model.Procedure.ProcedureStatus.NOTDONE);
        break;
      case ONHOLD:
        tgt.setValue(org.hl7.fhir.r4.model.Procedure.ProcedureStatus.ONHOLD);
        break;
      case STOPPED:
        tgt.setValue(org.hl7.fhir.r4.model.Procedure.ProcedureStatus.STOPPED);
        break;
      case COMPLETED:
        tgt.setValue(org.hl7.fhir.r4.model.Procedure.ProcedureStatus.COMPLETED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r4.model.Procedure.ProcedureStatus.ENTEREDINERROR);
        break;
      case UNKNOWN:
        tgt.setValue(org.hl7.fhir.r4.model.Procedure.ProcedureStatus.UNKNOWN);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.Procedure.ProcedureStatus.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Procedure.ProcedurePerformerComponent convertProcedurePerformerComponent(org.hl7.fhir.r4.model.Procedure.ProcedurePerformerComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Procedure.ProcedurePerformerComponent tgt = new org.hl7.fhir.r5.model.Procedure.ProcedurePerformerComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasFunction())
      tgt.setFunction(CodeableConcept40_50.convertCodeableConcept(src.getFunction()));
    if (src.hasActor())
      tgt.setActor(Reference40_50.convertReference(src.getActor()));
    if (src.hasOnBehalfOf())
      tgt.setOnBehalfOf(Reference40_50.convertReference(src.getOnBehalfOf()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Procedure.ProcedurePerformerComponent convertProcedurePerformerComponent(org.hl7.fhir.r5.model.Procedure.ProcedurePerformerComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Procedure.ProcedurePerformerComponent tgt = new org.hl7.fhir.r4.model.Procedure.ProcedurePerformerComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasFunction())
      tgt.setFunction(CodeableConcept40_50.convertCodeableConcept(src.getFunction()));
    if (src.hasActor())
      tgt.setActor(Reference40_50.convertReference(src.getActor()));
    if (src.hasOnBehalfOf())
      tgt.setOnBehalfOf(Reference40_50.convertReference(src.getOnBehalfOf()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Procedure.ProcedureFocalDeviceComponent convertProcedureFocalDeviceComponent(org.hl7.fhir.r4.model.Procedure.ProcedureFocalDeviceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Procedure.ProcedureFocalDeviceComponent tgt = new org.hl7.fhir.r5.model.Procedure.ProcedureFocalDeviceComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasAction())
      tgt.setAction(CodeableConcept40_50.convertCodeableConcept(src.getAction()));
    if (src.hasManipulated())
      tgt.setManipulated(Reference40_50.convertReference(src.getManipulated()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Procedure.ProcedureFocalDeviceComponent convertProcedureFocalDeviceComponent(org.hl7.fhir.r5.model.Procedure.ProcedureFocalDeviceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Procedure.ProcedureFocalDeviceComponent tgt = new org.hl7.fhir.r4.model.Procedure.ProcedureFocalDeviceComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasAction())
      tgt.setAction(CodeableConcept40_50.convertCodeableConcept(src.getAction()));
    if (src.hasManipulated())
      tgt.setManipulated(Reference40_50.convertReference(src.getManipulated()));
    return tgt;
  }
}