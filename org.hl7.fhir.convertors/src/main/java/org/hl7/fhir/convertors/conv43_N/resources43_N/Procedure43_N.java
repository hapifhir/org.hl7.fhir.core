package org.hl7.fhir.convertors.conv43_N.resources43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Annotation43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.CodeableConcept43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Identifier43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Canonical43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Uri43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.special43_N.Reference43_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4b.model.Procedure;
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

public class Procedure43_N {

  public static org.hl7.fhir.model.core.Procedure convertProcedure(org.hl7.fhir.r4b.model.Procedure src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Procedure tgt = new org.hl7.fhir.model.core.Procedure();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getBasedOn()) tgt.addBasedOn(Reference43_N.convertReference(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getPartOf()) tgt.addPartOf(Reference43_N.convertReference(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertProcedureStatus(src.getStatusElement()));
    if (src.hasStatusReason())
      tgt.setStatusReason(CodeableConcept43_N.convertCodeableConcept(src.getStatusReason()));
    if (src.hasCategory())
      tgt.addCategory(CodeableConcept43_N.convertCodeableConcept(src.getCategory()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_N.convertCodeableConcept(src.getCode()));
    if (src.hasSubject())
      tgt.setSubject(Reference43_N.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference43_N.convertReference(src.getEncounter()));
    if (src.hasPerformed())
      tgt.setOccurrence(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getPerformed()));
    if (src.hasRecorder())
      tgt.setRecorder(Reference43_N.convertReference(src.getRecorder()));
    if (src.hasAsserter())
      tgt.setReported(Reference43_N.convertReference(src.getAsserter()));
    for (org.hl7.fhir.r4b.model.Procedure.ProcedurePerformerComponent t : src.getPerformer())
      tgt.addPerformer(convertProcedurePerformerComponent(t));
    if (src.hasLocation())
      tgt.setLocation(Reference43_N.convertReference(src.getLocation()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getReasonCode())
      tgt.addReason(CodeableConcept43_N.convertCodeableConceptToCodeableReference(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getReasonReference())
      tgt.addReason(Reference43_N.convertReferenceToCodeableReference(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getBodySite())
      tgt.addBodyStructure(new CodeableReference().setConcept(CodeableConcept43_N.convertCodeableConcept(t)));
    if (src.hasOutcome())
      tgt.addOutcome(new CodeableReference().setConcept(CodeableConcept43_N.convertCodeableConcept(src.getOutcome())));
    for (org.hl7.fhir.r4b.model.Reference t : src.getReport()) tgt.addReport(Reference43_N.convertReference(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getComplication())
      tgt.addComplication().setConcept(CodeableConcept43_N.convertCodeableConcept(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getComplicationDetail())
      tgt.addComplication().setReference(Reference43_N.convertReference(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getFollowUp())
      tgt.addFollowUp(new CodeableReference().setConcept(CodeableConcept43_N.convertCodeableConcept(t)));
    for (org.hl7.fhir.r4b.model.Annotation t : src.getNote()) tgt.addNote(Annotation43_N.convertAnnotation(t));
    for (org.hl7.fhir.r4b.model.Procedure.ProcedureFocalDeviceComponent t : src.getFocalDevice())
      tgt.addFocalDevice(convertProcedureFocalDeviceComponent(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getUsedReference())
      tgt.addUsed(Reference43_N.convertReferenceToCodeableReference(t));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getUsedCode())
      tgt.addUsed(CodeableConcept43_N.convertCodeableConceptToCodeableReference(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Procedure convertProcedure(org.hl7.fhir.model.core.Procedure src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Procedure tgt = new org.hl7.fhir.r4b.model.Procedure();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    for (org.hl7.fhir.model.core.Reference t : src.getBasedOnList()) tgt.addBasedOn(Reference43_N.convertReference(t));
    for (org.hl7.fhir.model.core.Reference t : src.getPartOfList()) tgt.addPartOf(Reference43_N.convertReference(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertProcedureStatus(src.getStatusElement()));
    if (src.hasStatusReason())
      tgt.setStatusReason(CodeableConcept43_N.convertCodeableConcept(src.getStatusReason()));
    if (src.hasCategory())
      tgt.setCategory(CodeableConcept43_N.convertCodeableConcept(src.getCategoryFirstRep()));
    if (src.hasCode())
      tgt.setCode(CodeableConcept43_N.convertCodeableConcept(src.getCode()));
    if (src.hasSubject())
      tgt.setSubject(Reference43_N.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference43_N.convertReference(src.getEncounter()));
    if (src.hasOccurrence())
      tgt.setPerformed(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getOccurrence()));
    if (src.hasRecorder())
      tgt.setRecorder(Reference43_N.convertReference(src.getRecorder()));
    if (src.hasReportedReference())
      tgt.setAsserter(Reference43_N.convertReference(src.getReportedReference()));
    for (org.hl7.fhir.model.core.Procedure.ProcedurePerformerComponent t : src.getPerformerList())
      tgt.addPerformer(convertProcedurePerformerComponent(t));
    if (src.hasLocation())
      tgt.setLocation(Reference43_N.convertReference(src.getLocation()));
    for (CodeableReference t : src.getReasonList())
      if (t.hasConcept())
        tgt.addReasonCode(CodeableConcept43_N.convertCodeableConcept(t.getConcept()));
    for (CodeableReference t : src.getReasonList())
      if (t.hasReference())
        tgt.addReasonReference(Reference43_N.convertReference(t.getReference()));
    for (org.hl7.fhir.model.core.CodeableReference t : src.getBodyStructureList())
      tgt.addBodySite(CodeableConcept43_N.convertCodeableConcept(t.getConcept()));
    for (org.hl7.fhir.model.core.CodeableReference t : src.getOutcomeList())
      tgt.setOutcome(CodeableConcept43_N.convertCodeableConcept(t.getConcept()));
    for (org.hl7.fhir.model.core.Reference t : src.getReportList()) tgt.addReport(Reference43_N.convertReference(t));
    for (CodeableReference t : src.getComplicationList()) {
      if (t.hasConcept()) {
        tgt.addComplication(CodeableConcept43_N.convertCodeableConcept(t.getConcept()));
      }
      if (t.hasReference()) {
        tgt.addComplicationDetail(Reference43_N.convertReference(t.getReference()));
      }
    }
    for (org.hl7.fhir.model.core.CodeableReference t : src.getFollowUpList())
      tgt.addFollowUp(CodeableConcept43_N.convertCodeableConcept(t.getConcept()));
    for (org.hl7.fhir.model.core.Annotation t : src.getNoteList()) tgt.addNote(Annotation43_N.convertAnnotation(t));
    for (org.hl7.fhir.model.core.Procedure.ProcedureFocalDeviceComponent t : src.getFocalDeviceList())
      tgt.addFocalDevice(convertProcedureFocalDeviceComponent(t));
    for (CodeableReference t : src.getUsedList())
      if (t.hasReference())
        tgt.addUsedReference(Reference43_N.convertReference(t.getReference()));
    for (CodeableReference t : src.getUsedList())
      if (t.hasConcept())
        tgt.addUsedCode(CodeableConcept43_N.convertCodeableConcept(t.getConcept()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.EventStatus> convertProcedureStatus(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.EventStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Enumerations.EventStatus> tgt = new Enumeration<>(new Enumerations.EventStatusEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case PREPARATION:
                  tgt.setValue(Enumerations.EventStatus.PREPARATION);
                  break;
              case INPROGRESS:
                  tgt.setValue(Enumerations.EventStatus.INPROGRESS);
                  break;
              case NOTDONE:
                  tgt.setValue(Enumerations.EventStatus.NOTDONE);
                  break;
              case ONHOLD:
                  tgt.setValue(Enumerations.EventStatus.ONHOLD);
                  break;
              case STOPPED:
                  tgt.setValue(Enumerations.EventStatus.STOPPED);
                  break;
              case COMPLETED:
                  tgt.setValue(Enumerations.EventStatus.COMPLETED);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(Enumerations.EventStatus.ENTEREDINERROR);
                  break;
              case UNKNOWN:
                  tgt.setValue(Enumerations.EventStatus.UNKNOWN);
                  break;
              default:
                  tgt.setValue(Enumerations.EventStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.EventStatus> convertProcedureStatus(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Enumerations.EventStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.Enumerations.EventStatus> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.Enumerations.EventStatusEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case PREPARATION:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.EventStatus.PREPARATION);
                  break;
              case INPROGRESS:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.EventStatus.INPROGRESS);
                  break;
              case NOTDONE:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.EventStatus.NOTDONE);
                  break;
              case ONHOLD:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.EventStatus.ONHOLD);
                  break;
              case STOPPED:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.EventStatus.STOPPED);
                  break;
              case COMPLETED:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.EventStatus.COMPLETED);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.EventStatus.ENTEREDINERROR);
                  break;
              case UNKNOWN:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.EventStatus.UNKNOWN);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4b.model.Enumerations.EventStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.Procedure.ProcedurePerformerComponent convertProcedurePerformerComponent(org.hl7.fhir.r4b.model.Procedure.ProcedurePerformerComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Procedure.ProcedurePerformerComponent tgt = new org.hl7.fhir.model.core.Procedure.ProcedurePerformerComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasFunction())
      tgt.setFunction(CodeableConcept43_N.convertCodeableConcept(src.getFunction()));
    if (src.hasActor())
      tgt.setActor(Reference43_N.convertReference(src.getActor()));
    if (src.hasOnBehalfOf())
      tgt.setOnBehalfOf(Reference43_N.convertReference(src.getOnBehalfOf()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Procedure.ProcedurePerformerComponent convertProcedurePerformerComponent(org.hl7.fhir.model.core.Procedure.ProcedurePerformerComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Procedure.ProcedurePerformerComponent tgt = new org.hl7.fhir.r4b.model.Procedure.ProcedurePerformerComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasFunction())
      tgt.setFunction(CodeableConcept43_N.convertCodeableConcept(src.getFunction()));
    if (src.hasActor())
      tgt.setActor(Reference43_N.convertReference(src.getActor()));
    if (src.hasOnBehalfOf())
      tgt.setOnBehalfOf(Reference43_N.convertReference(src.getOnBehalfOf()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.Procedure.ProcedureFocalDeviceComponent convertProcedureFocalDeviceComponent(org.hl7.fhir.r4b.model.Procedure.ProcedureFocalDeviceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Procedure.ProcedureFocalDeviceComponent tgt = new org.hl7.fhir.model.core.Procedure.ProcedureFocalDeviceComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasAction())
      tgt.setAction(CodeableConcept43_N.convertCodeableConcept(src.getAction()));
    if (src.hasManipulated())
      tgt.setManipulated(Reference43_N.convertReference(src.getManipulated()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.Procedure.ProcedureFocalDeviceComponent convertProcedureFocalDeviceComponent(org.hl7.fhir.model.core.Procedure.ProcedureFocalDeviceComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.Procedure.ProcedureFocalDeviceComponent tgt = new org.hl7.fhir.r4b.model.Procedure.ProcedureFocalDeviceComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasAction())
      tgt.setAction(CodeableConcept43_N.convertCodeableConcept(src.getAction()));
    if (src.hasManipulated())
      tgt.setManipulated(Reference43_N.convertReference(src.getManipulated()));
    return tgt;
  }
}