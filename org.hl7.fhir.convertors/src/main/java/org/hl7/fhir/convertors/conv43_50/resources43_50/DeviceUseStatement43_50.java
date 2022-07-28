package org.hl7.fhir.convertors.conv43_50.resources43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Annotation43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.CodeableConcept43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Identifier43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.DateTime43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.special43_50.Reference43_50;
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
public class DeviceUseStatement43_50 {

  public static org.hl7.fhir.r5.model.DeviceUsage convertDeviceUseStatement(org.hl7.fhir.r4b.model.DeviceUseStatement src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.DeviceUsage tgt = new org.hl7.fhir.r5.model.DeviceUsage();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getBasedOn()) tgt.addBasedOn(Reference43_50.convertReference(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertDeviceUseStatementStatus(src.getStatusElement()));
    if (src.hasSubject())
      tgt.setPatient(Reference43_50.convertReference(src.getSubject()));
    for (org.hl7.fhir.r4b.model.Reference t : src.getDerivedFrom())
      tgt.addDerivedFrom(Reference43_50.convertReference(t));
    if (src.hasTiming())
      tgt.setTiming(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getTiming()));
    if (src.hasRecordedOn())
      tgt.setDateAssertedElement(DateTime43_50.convertDateTime(src.getRecordedOnElement()));
    if (src.hasSource())
      tgt.setInformationSource(Reference43_50.convertReference(src.getSource()));
    if (src.hasDevice())
      tgt.getDevice().setReference(Reference43_50.convertReference(src.getDevice()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getReasonCode())
      tgt.addReason(CodeableConcept43_50.convertCodeableConceptToCodeableReference(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getReasonReference())
      tgt.addReason(Reference43_50.convertReferenceToCodeableReference(t));
    if (src.hasBodySite())
      tgt.getBodySite().setConcept(CodeableConcept43_50.convertCodeableConcept(src.getBodySite()));
    for (org.hl7.fhir.r4b.model.Annotation t : src.getNote()) tgt.addNote(Annotation43_50.convertAnnotation(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.DeviceUseStatement convertDeviceUseStatement(org.hl7.fhir.r5.model.DeviceUsage src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.DeviceUseStatement tgt = new org.hl7.fhir.r4b.model.DeviceUseStatement();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_50.convertIdentifier(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getBasedOn()) tgt.addBasedOn(Reference43_50.convertReference(t));
    if (src.hasStatus())
      tgt.setStatusElement(convertDeviceUseStatementStatus(src.getStatusElement()));
    if (src.hasPatient())
      tgt.setSubject(Reference43_50.convertReference(src.getPatient()));
    for (org.hl7.fhir.r5.model.Reference t : src.getDerivedFrom())
      tgt.addDerivedFrom(Reference43_50.convertReference(t));
    if (src.hasTiming())
      tgt.setTiming(ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().convertType(src.getTiming()));
    if (src.hasDateAsserted())
      tgt.setRecordedOnElement(DateTime43_50.convertDateTime(src.getDateAssertedElement()));
    if (src.hasInformationSource())
      tgt.setSource(Reference43_50.convertReference(src.getInformationSource()));
    if (src.getDevice().hasReference())
      tgt.setDevice(Reference43_50.convertReference(src.getDevice().getReference()));
    for (CodeableReference t : src.getReason())
      if (t.hasConcept())
        tgt.addReasonCode(CodeableConcept43_50.convertCodeableConcept(t.getConcept()));
    for (CodeableReference t : src.getReason())
      if (t.hasReference())
        tgt.addReasonReference(Reference43_50.convertReference(t.getReference()));
    if (src.getBodySite().hasConcept())
      tgt.setBodySite(CodeableConcept43_50.convertCodeableConcept(src.getBodySite().getConcept()));
    for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.addNote(Annotation43_50.convertAnnotation(t));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.DeviceUsage.DeviceUsageStatus> convertDeviceUseStatementStatus(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.DeviceUseStatement.DeviceUseStatementStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.DeviceUsage.DeviceUsageStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.DeviceUsage.DeviceUsageStatusEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.r5.model.DeviceUsage.DeviceUsageStatus.ACTIVE);
        break;
      case COMPLETED:
        tgt.setValue(org.hl7.fhir.r5.model.DeviceUsage.DeviceUsageStatus.COMPLETED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r5.model.DeviceUsage.DeviceUsageStatus.ENTEREDINERROR);
        break;
      case INTENDED:
        tgt.setValue(org.hl7.fhir.r5.model.DeviceUsage.DeviceUsageStatus.INTENDED);
        break;
      case STOPPED:
        tgt.setValue(org.hl7.fhir.r5.model.DeviceUsage.DeviceUsageStatus.STOPPED);
        break;
      case ONHOLD:
        tgt.setValue(org.hl7.fhir.r5.model.DeviceUsage.DeviceUsageStatus.ONHOLD);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.DeviceUsage.DeviceUsageStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.DeviceUseStatement.DeviceUseStatementStatus> convertDeviceUseStatementStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.DeviceUsage.DeviceUsageStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.DeviceUseStatement.DeviceUseStatementStatus> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.DeviceUseStatement.DeviceUseStatementStatusEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case ACTIVE:
        tgt.setValue(org.hl7.fhir.r4b.model.DeviceUseStatement.DeviceUseStatementStatus.ACTIVE);
        break;
      case COMPLETED:
        tgt.setValue(org.hl7.fhir.r4b.model.DeviceUseStatement.DeviceUseStatementStatus.COMPLETED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r4b.model.DeviceUseStatement.DeviceUseStatementStatus.ENTEREDINERROR);
        break;
      case INTENDED:
        tgt.setValue(org.hl7.fhir.r4b.model.DeviceUseStatement.DeviceUseStatementStatus.INTENDED);
        break;
      case STOPPED:
        tgt.setValue(org.hl7.fhir.r4b.model.DeviceUseStatement.DeviceUseStatementStatus.STOPPED);
        break;
      case ONHOLD:
        tgt.setValue(org.hl7.fhir.r4b.model.DeviceUseStatement.DeviceUseStatementStatus.ONHOLD);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.DeviceUseStatement.DeviceUseStatementStatus.NULL);
        break;
    }
    return tgt;
  }
}