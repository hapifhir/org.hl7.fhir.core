package org.hl7.fhir.convertors.conv43_N.resources43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Annotation43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.CodeableConcept43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Identifier43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.metadata43_N.DataRequirement43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.DateTime43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.special43_N.Reference43_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.CodeableReference;
import org.hl7.fhir.model.core.Enumeration;
import org.hl7.fhir.model.core.GuidanceResponse;

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

public class GuidanceResponse43_N {

  public static org.hl7.fhir.model.core.GuidanceResponse convertGuidanceResponse(org.hl7.fhir.r4b.model.GuidanceResponse src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.GuidanceResponse tgt = new org.hl7.fhir.model.core.GuidanceResponse();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    if (src.hasRequestIdentifier())
      tgt.setRequestIdentifier(Identifier43_N.convertIdentifier(src.getRequestIdentifier()));
    for (org.hl7.fhir.r4b.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    if (src.hasModule())
      tgt.setModule(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getModule()));
    if (src.hasStatus())
      tgt.setStatusElement(convertGuidanceResponseStatus(src.getStatusElement()));
    if (src.hasSubject())
      tgt.setSubject(Reference43_N.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference43_N.convertReference(src.getEncounter()));
    if (src.hasOccurrenceDateTime())
      tgt.setOccurrenceDateTimeElement(DateTime43_N.convertDateTime(src.getOccurrenceDateTimeElement()));
    if (src.hasPerformer())
      tgt.setPerformer(Reference43_N.convertReference(src.getPerformer()));
    for (org.hl7.fhir.r4b.model.CodeableConcept t : src.getReasonCode())
      tgt.addReason(CodeableConcept43_N.convertCodeableConceptToCodeableReference(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getReasonReference())
      tgt.addReason(Reference43_N.convertReferenceToCodeableReference(t));
    for (org.hl7.fhir.r4b.model.Annotation t : src.getNote()) tgt.addNote(Annotation43_N.convertAnnotation(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getEvaluationMessage())
      tgt.addEvaluationMessage(Reference43_N.convertReference(t));
    if (src.hasOutputParameters())
      tgt.setOutputParameters(Reference43_N.convertReference(src.getOutputParameters()));
    if (src.hasResult())
      tgt.addResult(Reference43_N.convertReference(src.getResult()));
    for (org.hl7.fhir.r4b.model.DataRequirement t : src.getDataRequirement())
      tgt.addDataRequirement(DataRequirement43_N.convertDataRequirement(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.GuidanceResponse convertGuidanceResponse(org.hl7.fhir.model.core.GuidanceResponse src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.GuidanceResponse tgt = new org.hl7.fhir.r4b.model.GuidanceResponse();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    if (src.hasRequestIdentifier())
      tgt.setRequestIdentifier(Identifier43_N.convertIdentifier(src.getRequestIdentifier()));
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(t));
    if (src.hasModule())
      tgt.setModule(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getModule()));
    if (src.hasStatus())
      tgt.setStatusElement(convertGuidanceResponseStatus(src.getStatusElement()));
    if (src.hasSubject())
      tgt.setSubject(Reference43_N.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference43_N.convertReference(src.getEncounter()));
    if (src.hasOccurrenceDateTime())
      tgt.setOccurrenceDateTimeElement(DateTime43_N.convertDateTime(src.getOccurrenceDateTimeElement()));
    if (src.hasPerformer())
      tgt.setPerformer(Reference43_N.convertReference(src.getPerformer()));
    for (CodeableReference t : src.getReasonList())
      if (t.hasConcept())
        tgt.addReasonCode(CodeableConcept43_N.convertCodeableConcept(t.getConcept()));
    for (CodeableReference t : src.getReasonList())
      if (t.hasReference())
        tgt.addReasonReference(Reference43_N.convertReference(t.getReference()));
    for (org.hl7.fhir.model.core.Annotation t : src.getNoteList()) tgt.addNote(Annotation43_N.convertAnnotation(t));
    if (src.hasEvaluationMessage())
      tgt.addEvaluationMessage(Reference43_N.convertReference(src.getEvaluationMessageFirstRep()));
    if (src.hasOutputParameters())
      tgt.setOutputParameters(Reference43_N.convertReference(src.getOutputParameters()));
    if (src.hasResult())
      tgt.setResult(Reference43_N.convertReference(src.getResultFirstRep()));
    for (org.hl7.fhir.model.core.DataRequirement t : src.getDataRequirementList())
      tgt.addDataRequirement(DataRequirement43_N.convertDataRequirement(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.GuidanceResponse.GuidanceResponseStatus> convertGuidanceResponseStatus(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.GuidanceResponse.GuidanceResponseStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<GuidanceResponse.GuidanceResponseStatus> tgt = new Enumeration<>(new GuidanceResponse.GuidanceResponseStatusEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case SUCCESS:
                  tgt.setValue(GuidanceResponse.GuidanceResponseStatus.SUCCESS);
                  break;
              case DATAREQUESTED:
                  tgt.setValue(GuidanceResponse.GuidanceResponseStatus.DATAREQUESTED);
                  break;
              case DATAREQUIRED:
                  tgt.setValue(GuidanceResponse.GuidanceResponseStatus.DATAREQUIRED);
                  break;
              case INPROGRESS:
                  tgt.setValue(GuidanceResponse.GuidanceResponseStatus.INPROGRESS);
                  break;
              case FAILURE:
                  tgt.setValue(GuidanceResponse.GuidanceResponseStatus.FAILURE);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(GuidanceResponse.GuidanceResponseStatus.ENTEREDINERROR);
                  break;
              default:
                  tgt.setValue(GuidanceResponse.GuidanceResponseStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.GuidanceResponse.GuidanceResponseStatus> convertGuidanceResponseStatus(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.GuidanceResponse.GuidanceResponseStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.GuidanceResponse.GuidanceResponseStatus> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.GuidanceResponse.GuidanceResponseStatusEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case SUCCESS:
                  tgt.setValue(org.hl7.fhir.r4b.model.GuidanceResponse.GuidanceResponseStatus.SUCCESS);
                  break;
              case DATAREQUESTED:
                  tgt.setValue(org.hl7.fhir.r4b.model.GuidanceResponse.GuidanceResponseStatus.DATAREQUESTED);
                  break;
              case DATAREQUIRED:
                  tgt.setValue(org.hl7.fhir.r4b.model.GuidanceResponse.GuidanceResponseStatus.DATAREQUIRED);
                  break;
              case INPROGRESS:
                  tgt.setValue(org.hl7.fhir.r4b.model.GuidanceResponse.GuidanceResponseStatus.INPROGRESS);
                  break;
              case FAILURE:
                  tgt.setValue(org.hl7.fhir.r4b.model.GuidanceResponse.GuidanceResponseStatus.FAILURE);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(org.hl7.fhir.r4b.model.GuidanceResponse.GuidanceResponseStatus.ENTEREDINERROR);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4b.model.GuidanceResponse.GuidanceResponseStatus.NULL);
                  break;
          }
      }
      return tgt;
  }
}