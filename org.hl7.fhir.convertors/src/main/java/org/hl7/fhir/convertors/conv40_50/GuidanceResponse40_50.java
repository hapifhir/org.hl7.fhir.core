package org.hl7.fhir.convertors.conv40_50;


import org.hl7.fhir.convertors.VersionConvertor_40_50;
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
public class GuidanceResponse40_50 extends VersionConvertor_40_50 {

    public static org.hl7.fhir.r5.model.GuidanceResponse convertGuidanceResponse(org.hl7.fhir.r4.model.GuidanceResponse src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.GuidanceResponse tgt = new org.hl7.fhir.r5.model.GuidanceResponse();
        copyDomainResource(src, tgt);
        if (src.hasRequestIdentifier())
            tgt.setRequestIdentifier(convertIdentifier(src.getRequestIdentifier()));
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        if (src.hasModule())
            tgt.setModule(convertType(src.getModule()));
        if (src.hasStatus())
            tgt.setStatusElement(convertGuidanceResponseStatus(src.getStatusElement()));
        if (src.hasSubject())
            tgt.setSubject(convertReference(src.getSubject()));
        if (src.hasEncounter())
            tgt.setEncounter(convertReference(src.getEncounter()));
        if (src.hasOccurrenceDateTime())
            tgt.setOccurrenceDateTimeElement(convertDateTime(src.getOccurrenceDateTimeElement()));
        if (src.hasPerformer())
            tgt.setPerformer(convertReference(src.getPerformer()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getReasonCode()) tgt.addReason(convertCodeableConceptToCodeableReference(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getReasonReference()) tgt.addReason(convertReferenceToCodeableReference(t));
        for (org.hl7.fhir.r4.model.Annotation t : src.getNote()) tgt.addNote(convertAnnotation(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getEvaluationMessage()) tgt.addEvaluationMessage(convertReference(t));
        if (src.hasOutputParameters())
            tgt.setOutputParameters(convertReference(src.getOutputParameters()));
        if (src.hasResult())
            tgt.setResult(convertReference(src.getResult()));
        for (org.hl7.fhir.r4.model.DataRequirement t : src.getDataRequirement()) tgt.addDataRequirement(convertDataRequirement(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.GuidanceResponse convertGuidanceResponse(org.hl7.fhir.r5.model.GuidanceResponse src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.GuidanceResponse tgt = new org.hl7.fhir.r4.model.GuidanceResponse();
        copyDomainResource(src, tgt);
        if (src.hasRequestIdentifier())
            tgt.setRequestIdentifier(convertIdentifier(src.getRequestIdentifier()));
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(convertIdentifier(t));
        if (src.hasModule())
            tgt.setModule(convertType(src.getModule()));
        if (src.hasStatus())
            tgt.setStatusElement(convertGuidanceResponseStatus(src.getStatusElement()));
        if (src.hasSubject())
            tgt.setSubject(convertReference(src.getSubject()));
        if (src.hasEncounter())
            tgt.setEncounter(convertReference(src.getEncounter()));
        if (src.hasOccurrenceDateTime())
            tgt.setOccurrenceDateTimeElement(convertDateTime(src.getOccurrenceDateTimeElement()));
        if (src.hasPerformer())
            tgt.setPerformer(convertReference(src.getPerformer()));
        for (CodeableReference t : src.getReason()) if (t.hasConcept())
            tgt.addReasonCode(convertCodeableConcept(t.getConcept()));
        for (CodeableReference t : src.getReason()) if (t.hasReference())
            tgt.addReasonReference(convertReference(t.getReference()));
        for (org.hl7.fhir.r5.model.Annotation t : src.getNote()) tgt.addNote(convertAnnotation(t));
        for (org.hl7.fhir.r5.model.Reference t : src.getEvaluationMessage()) tgt.addEvaluationMessage(convertReference(t));
        if (src.hasOutputParameters())
            tgt.setOutputParameters(convertReference(src.getOutputParameters()));
        if (src.hasResult())
            tgt.setResult(convertReference(src.getResult()));
        for (org.hl7.fhir.r5.model.DataRequirement t : src.getDataRequirement()) tgt.addDataRequirement(convertDataRequirement(t));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.GuidanceResponse.GuidanceResponseStatus> convertGuidanceResponseStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.GuidanceResponse.GuidanceResponseStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.GuidanceResponse.GuidanceResponseStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.GuidanceResponse.GuidanceResponseStatusEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case SUCCESS:
                tgt.setValue(org.hl7.fhir.r5.model.GuidanceResponse.GuidanceResponseStatus.SUCCESS);
                break;
            case DATAREQUESTED:
                tgt.setValue(org.hl7.fhir.r5.model.GuidanceResponse.GuidanceResponseStatus.DATAREQUESTED);
                break;
            case DATAREQUIRED:
                tgt.setValue(org.hl7.fhir.r5.model.GuidanceResponse.GuidanceResponseStatus.DATAREQUIRED);
                break;
            case INPROGRESS:
                tgt.setValue(org.hl7.fhir.r5.model.GuidanceResponse.GuidanceResponseStatus.INPROGRESS);
                break;
            case FAILURE:
                tgt.setValue(org.hl7.fhir.r5.model.GuidanceResponse.GuidanceResponseStatus.FAILURE);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.r5.model.GuidanceResponse.GuidanceResponseStatus.ENTEREDINERROR);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.GuidanceResponse.GuidanceResponseStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.GuidanceResponse.GuidanceResponseStatus> convertGuidanceResponseStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.GuidanceResponse.GuidanceResponseStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.GuidanceResponse.GuidanceResponseStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.GuidanceResponse.GuidanceResponseStatusEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case SUCCESS:
                tgt.setValue(org.hl7.fhir.r4.model.GuidanceResponse.GuidanceResponseStatus.SUCCESS);
                break;
            case DATAREQUESTED:
                tgt.setValue(org.hl7.fhir.r4.model.GuidanceResponse.GuidanceResponseStatus.DATAREQUESTED);
                break;
            case DATAREQUIRED:
                tgt.setValue(org.hl7.fhir.r4.model.GuidanceResponse.GuidanceResponseStatus.DATAREQUIRED);
                break;
            case INPROGRESS:
                tgt.setValue(org.hl7.fhir.r4.model.GuidanceResponse.GuidanceResponseStatus.INPROGRESS);
                break;
            case FAILURE:
                tgt.setValue(org.hl7.fhir.r4.model.GuidanceResponse.GuidanceResponseStatus.FAILURE);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.r4.model.GuidanceResponse.GuidanceResponseStatus.ENTEREDINERROR);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.GuidanceResponse.GuidanceResponseStatus.NULL);
                break;
        }
        return tgt;
    }
}