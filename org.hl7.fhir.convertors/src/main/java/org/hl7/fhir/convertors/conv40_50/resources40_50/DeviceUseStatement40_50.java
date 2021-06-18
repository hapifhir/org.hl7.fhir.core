package org.hl7.fhir.convertors.conv40_50.resources40_50;


import org.hl7.fhir.convertors.VersionConvertor_40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.Element40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.Type40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Annotation40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.CodeableConcept40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Identifier40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.DateTime40_50;
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
public class DeviceUseStatement40_50 extends VersionConvertor_40_50 {

    public static org.hl7.fhir.r5.model.DeviceUsage convertDeviceUseStatement(org.hl7.fhir.r4.model.DeviceUseStatement src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.DeviceUsage tgt = new org.hl7.fhir.r5.model.DeviceUsage();
        copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(Identifier40_50.convertIdentifier(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getBasedOn()) tgt.addBasedOn(Reference40_50.convertReference(t));
        if (src.hasStatus())
            tgt.setStatusElement(convertDeviceUseStatementStatus(src.getStatusElement()));
        if (src.hasSubject())
            tgt.setSubject(Reference40_50.convertReference(src.getSubject()));
        for (org.hl7.fhir.r4.model.Reference t : src.getDerivedFrom()) tgt.addDerivedFrom(Reference40_50.convertReference(t));
        if (src.hasTiming())
            tgt.setTiming(Type40_50.convertType(src.getTiming()));
        if (src.hasRecordedOn())
            tgt.setDateAssertedElement(DateTime40_50.convertDateTime(src.getRecordedOnElement()));
        if (src.hasSource())
            tgt.setInformationSource(Reference40_50.convertReference(src.getSource()));
        if (src.hasDevice())
            tgt.getDevice().setReference(Reference40_50.convertReference(src.getDevice()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReasonCode()) tgt.addReason(convertCodeableConceptToCodeableReference(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getReasonReference()) tgt.addReason(convertReferenceToCodeableReference(t));
        if (src.hasBodySite())
            tgt.getBodySite().setConcept(CodeableConcept40_50.convertCodeableConcept(src.getBodySite()));
        for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.addNote(Annotation40_50.convertAnnotation(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.DeviceUseStatement convertDeviceUseStatement(org.hl7.fhir.r5.model.DeviceUsage src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.DeviceUseStatement tgt = new org.hl7.fhir.r4.model.DeviceUseStatement();
        copyDomainResource(src, tgt);
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(Identifier40_50.convertIdentifier(t));
        for (org.hl7.fhir.r5.model.Reference t : src.getBasedOn()) tgt.addBasedOn(Reference40_50.convertReference(t));
        if (src.hasStatus())
            tgt.setStatusElement(convertDeviceUseStatementStatus(src.getStatusElement()));
        if (src.hasSubject())
            tgt.setSubject(Reference40_50.convertReference(src.getSubject()));
        for (org.hl7.fhir.r5.model.Reference t : src.getDerivedFrom()) tgt.addDerivedFrom(Reference40_50.convertReference(t));
        if (src.hasTiming())
            tgt.setTiming(Type40_50.convertType(src.getTiming()));
        if (src.hasDateAsserted())
            tgt.setRecordedOnElement(DateTime40_50.convertDateTime(src.getDateAssertedElement()));
        if (src.hasInformationSource())
            tgt.setSource(Reference40_50.convertReference(src.getInformationSource()));
        if (src.getDevice().hasReference())
            tgt.setDevice(Reference40_50.convertReference(src.getDevice().getReference()));
        for (CodeableReference t : src.getReason()) if (t.hasConcept())
            tgt.addReasonCode(CodeableConcept40_50.convertCodeableConcept(t.getConcept()));
        for (CodeableReference t : src.getReason()) if (t.hasReference())
            tgt.addReasonReference(Reference40_50.convertReference(t.getReference()));
        if (src.getBodySite().hasConcept())
            tgt.setBodySite(CodeableConcept40_50.convertCodeableConcept(src.getBodySite().getConcept()));
        for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.addNote(Annotation40_50.convertAnnotation(t));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.DeviceUsage.DeviceUsageStatus> convertDeviceUseStatementStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DeviceUseStatement.DeviceUseStatementStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.DeviceUsage.DeviceUsageStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.DeviceUsage.DeviceUsageStatusEnumFactory());
        Element40_50.copyElement(src, tgt);
        switch(src.getValue()) {
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

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DeviceUseStatement.DeviceUseStatementStatus> convertDeviceUseStatementStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.DeviceUsage.DeviceUsageStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.DeviceUseStatement.DeviceUseStatementStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.DeviceUseStatement.DeviceUseStatementStatusEnumFactory());
        Element40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case ACTIVE:
                tgt.setValue(org.hl7.fhir.r4.model.DeviceUseStatement.DeviceUseStatementStatus.ACTIVE);
                break;
            case COMPLETED:
                tgt.setValue(org.hl7.fhir.r4.model.DeviceUseStatement.DeviceUseStatementStatus.COMPLETED);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.r4.model.DeviceUseStatement.DeviceUseStatementStatus.ENTEREDINERROR);
                break;
            case INTENDED:
                tgt.setValue(org.hl7.fhir.r4.model.DeviceUseStatement.DeviceUseStatementStatus.INTENDED);
                break;
            case STOPPED:
                tgt.setValue(org.hl7.fhir.r4.model.DeviceUseStatement.DeviceUseStatementStatus.STOPPED);
                break;
            case ONHOLD:
                tgt.setValue(org.hl7.fhir.r4.model.DeviceUseStatement.DeviceUseStatementStatus.ONHOLD);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.DeviceUseStatement.DeviceUseStatementStatus.NULL);
                break;
        }
        return tgt;
    }
}