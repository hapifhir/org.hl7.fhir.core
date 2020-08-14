package org.hl7.fhir.convertors.conv40_50;


import org.hl7.fhir.convertors.VersionConvertor_40_50;
import org.hl7.fhir.exceptions.FHIRException;

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
public class ImmunizationEvaluation40_50 extends VersionConvertor_40_50 {

    public static org.hl7.fhir.r5.model.ImmunizationEvaluation convertImmunizationEvaluation(org.hl7.fhir.r4.model.ImmunizationEvaluation src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.ImmunizationEvaluation tgt = new org.hl7.fhir.r5.model.ImmunizationEvaluation();
        copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        if (src.hasStatus())
            tgt.setStatusElement(convertImmunizationEvaluationStatus(src.getStatusElement()));
        if (src.hasPatient())
            tgt.setPatient(convertReference(src.getPatient()));
        if (src.hasDate())
            tgt.setDateElement(convertDateTime(src.getDateElement()));
        if (src.hasAuthority())
            tgt.setAuthority(convertReference(src.getAuthority()));
        if (src.hasTargetDisease())
            tgt.setTargetDisease(convertCodeableConcept(src.getTargetDisease()));
        if (src.hasImmunizationEvent())
            tgt.setImmunizationEvent(convertReference(src.getImmunizationEvent()));
        if (src.hasDoseStatus())
            tgt.setDoseStatus(convertCodeableConcept(src.getDoseStatus()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getDoseStatusReason()) tgt.addDoseStatusReason(convertCodeableConcept(t));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        if (src.hasSeries())
            tgt.setSeriesElement(convertString(src.getSeriesElement()));
        if (src.hasDoseNumber())
            tgt.setDoseNumber(src.getDoseNumber().primitiveValue());
        if (src.hasSeriesDoses())
            tgt.setSeriesDoses(src.getSeriesDoses().primitiveValue());
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ImmunizationEvaluation convertImmunizationEvaluation(org.hl7.fhir.r5.model.ImmunizationEvaluation src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.ImmunizationEvaluation tgt = new org.hl7.fhir.r4.model.ImmunizationEvaluation();
        copyDomainResource(src, tgt);
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        if (src.hasStatus())
            tgt.setStatusElement(convertImmunizationEvaluationStatus(src.getStatusElement()));
        if (src.hasPatient())
            tgt.setPatient(convertReference(src.getPatient()));
        if (src.hasDate())
            tgt.setDateElement(convertDateTime(src.getDateElement()));
        if (src.hasAuthority())
            tgt.setAuthority(convertReference(src.getAuthority()));
        if (src.hasTargetDisease())
            tgt.setTargetDisease(convertCodeableConcept(src.getTargetDisease()));
        if (src.hasImmunizationEvent())
            tgt.setImmunizationEvent(convertReference(src.getImmunizationEvent()));
        if (src.hasDoseStatus())
            tgt.setDoseStatus(convertCodeableConcept(src.getDoseStatus()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getDoseStatusReason()) tgt.addDoseStatusReason(convertCodeableConcept(t));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        if (src.hasSeries())
            tgt.setSeriesElement(convertString(src.getSeriesElement()));
        if (src.hasDoseNumber())
            tgt.setDoseNumber(convertType(src.getDoseNumberElement()));
        if (src.hasSeriesDoses())
            tgt.setSeriesDoses(convertType(src.getSeriesDosesElement()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ImmunizationEvaluation.ImmunizationEvaluationStatusCodes> convertImmunizationEvaluationStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ImmunizationEvaluation.ImmunizationEvaluationStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ImmunizationEvaluation.ImmunizationEvaluationStatusCodes> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.ImmunizationEvaluation.ImmunizationEvaluationStatusCodesEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case COMPLETED:
                tgt.setValue(org.hl7.fhir.r5.model.ImmunizationEvaluation.ImmunizationEvaluationStatusCodes.COMPLETED);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.r5.model.ImmunizationEvaluation.ImmunizationEvaluationStatusCodes.ENTEREDINERROR);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.ImmunizationEvaluation.ImmunizationEvaluationStatusCodes.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ImmunizationEvaluation.ImmunizationEvaluationStatus> convertImmunizationEvaluationStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.ImmunizationEvaluation.ImmunizationEvaluationStatusCodes> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.ImmunizationEvaluation.ImmunizationEvaluationStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.ImmunizationEvaluation.ImmunizationEvaluationStatusEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case COMPLETED:
                tgt.setValue(org.hl7.fhir.r4.model.ImmunizationEvaluation.ImmunizationEvaluationStatus.COMPLETED);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.r4.model.ImmunizationEvaluation.ImmunizationEvaluationStatus.ENTEREDINERROR);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.ImmunizationEvaluation.ImmunizationEvaluationStatus.NULL);
                break;
        }
        return tgt;
    }
}