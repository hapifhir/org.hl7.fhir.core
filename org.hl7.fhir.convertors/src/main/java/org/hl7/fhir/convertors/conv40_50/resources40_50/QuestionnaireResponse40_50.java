package org.hl7.fhir.convertors.conv40_50.resources40_50;

import org.hl7.fhir.convertors.VersionConvertor_40_50;
import org.hl7.fhir.convertors.VersionConvertor_40_50_Context;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Identifier40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Canonical40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.DateTime40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.String40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Uri40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.special40_50.Reference40_50;
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
public class QuestionnaireResponse40_50 {

  public static org.hl7.fhir.r5.model.QuestionnaireResponse convertQuestionnaireResponse(org.hl7.fhir.r4.model.QuestionnaireResponse src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.QuestionnaireResponse tgt = new org.hl7.fhir.r5.model.QuestionnaireResponse();
    VersionConvertor_40_50_Context.INSTANCE.getVersionConvertor_40_50_a().copyDomainResource(src, tgt);
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier40_50.convertIdentifier(src.getIdentifier()));
    for (org.hl7.fhir.r4.model.Reference t : src.getBasedOn()) tgt.addBasedOn(Reference40_50.convertReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getPartOf()) tgt.addPartOf(Reference40_50.convertReference(t));
    if (src.hasQuestionnaire())
      tgt.setQuestionnaireElement(Canonical40_50.convertCanonical(src.getQuestionnaireElement()));
    if (src.hasStatus())
      tgt.setStatusElement(convertQuestionnaireResponseStatus(src.getStatusElement()));
    if (src.hasSubject())
      tgt.setSubject(Reference40_50.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference40_50.convertReference(src.getEncounter()));
    if (src.hasAuthored())
      tgt.setAuthoredElement(DateTime40_50.convertDateTime(src.getAuthoredElement()));
    if (src.hasAuthor())
      tgt.setAuthor(Reference40_50.convertReference(src.getAuthor()));
    if (src.hasSource())
      tgt.setSource(Reference40_50.convertReference(src.getSource()));
    for (org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseItemComponent t : src.getItem())
      tgt.addItem(convertQuestionnaireResponseItemComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.QuestionnaireResponse convertQuestionnaireResponse(org.hl7.fhir.r5.model.QuestionnaireResponse src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.QuestionnaireResponse tgt = new org.hl7.fhir.r4.model.QuestionnaireResponse();
    VersionConvertor_40_50_Context.INSTANCE.getVersionConvertor_40_50_a().copyDomainResource(src, tgt);
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier40_50.convertIdentifier(src.getIdentifier()));
    for (org.hl7.fhir.r5.model.Reference t : src.getBasedOn()) tgt.addBasedOn(Reference40_50.convertReference(t));
    for (org.hl7.fhir.r5.model.Reference t : src.getPartOf()) tgt.addPartOf(Reference40_50.convertReference(t));
    if (src.hasQuestionnaire())
      tgt.setQuestionnaireElement(Canonical40_50.convertCanonical(src.getQuestionnaireElement()));
    if (src.hasStatus())
      tgt.setStatusElement(convertQuestionnaireResponseStatus(src.getStatusElement()));
    if (src.hasSubject())
      tgt.setSubject(Reference40_50.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference40_50.convertReference(src.getEncounter()));
    if (src.hasAuthored())
      tgt.setAuthoredElement(DateTime40_50.convertDateTime(src.getAuthoredElement()));
    if (src.hasAuthor())
      tgt.setAuthor(Reference40_50.convertReference(src.getAuthor()));
    if (src.hasSource())
      tgt.setSource(Reference40_50.convertReference(src.getSource()));
    for (org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseItemComponent t : src.getItem())
      tgt.addItem(convertQuestionnaireResponseItemComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseStatus> convertQuestionnaireResponseStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseStatusEnumFactory());
    VersionConvertor_40_50_Context.INSTANCE.getVersionConvertor_40_50_a().copyElement(src, tgt);
    switch (src.getValue()) {
      case INPROGRESS:
        tgt.setValue(org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseStatus.INPROGRESS);
        break;
      case COMPLETED:
        tgt.setValue(org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseStatus.COMPLETED);
        break;
      case AMENDED:
        tgt.setValue(org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseStatus.AMENDED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseStatus.ENTEREDINERROR);
        break;
      case STOPPED:
        tgt.setValue(org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseStatus.STOPPED);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseStatus> convertQuestionnaireResponseStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseStatusEnumFactory());
    VersionConvertor_40_50_Context.INSTANCE.getVersionConvertor_40_50_a().copyElement(src, tgt);
    switch (src.getValue()) {
      case INPROGRESS:
        tgt.setValue(org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseStatus.INPROGRESS);
        break;
      case COMPLETED:
        tgt.setValue(org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseStatus.COMPLETED);
        break;
      case AMENDED:
        tgt.setValue(org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseStatus.AMENDED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseStatus.ENTEREDINERROR);
        break;
      case STOPPED:
        tgt.setValue(org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseStatus.STOPPED);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseStatus.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseItemComponent convertQuestionnaireResponseItemComponent(org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseItemComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseItemComponent tgt = new org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseItemComponent();
    VersionConvertor_40_50_Context.INSTANCE.getVersionConvertor_40_50_a().copyElement(src, tgt);
    if (src.hasLinkId())
      tgt.setLinkIdElement(String40_50.convertString(src.getLinkIdElement()));
    if (src.hasDefinition())
      tgt.setDefinitionElement(Uri40_50.convertUri(src.getDefinitionElement()));
    if (src.hasText())
      tgt.setTextElement(String40_50.convertString(src.getTextElement()));
    for (org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent t : src.getAnswer())
      tgt.addAnswer(convertQuestionnaireResponseItemAnswerComponent(t));
    for (org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseItemComponent t : src.getItem())
      tgt.addItem(convertQuestionnaireResponseItemComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseItemComponent convertQuestionnaireResponseItemComponent(org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseItemComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseItemComponent tgt = new org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseItemComponent();
    VersionConvertor_40_50_Context.INSTANCE.getVersionConvertor_40_50_a().copyElement(src, tgt);
    if (src.hasLinkId())
      tgt.setLinkIdElement(String40_50.convertString(src.getLinkIdElement()));
    if (src.hasDefinition())
      tgt.setDefinitionElement(Uri40_50.convertUri(src.getDefinitionElement()));
    if (src.hasText())
      tgt.setTextElement(String40_50.convertString(src.getTextElement()));
    for (org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent t : src.getAnswer())
      tgt.addAnswer(convertQuestionnaireResponseItemAnswerComponent(t));
    for (org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseItemComponent t : src.getItem())
      tgt.addItem(convertQuestionnaireResponseItemComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent convertQuestionnaireResponseItemAnswerComponent(org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent tgt = new org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent();
    VersionConvertor_40_50_Context.INSTANCE.getVersionConvertor_40_50_a().copyElement(src, tgt);
    if (src.hasValue())
      tgt.setValue(VersionConvertor_40_50.convertType(src.getValue()));
    for (org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseItemComponent t : src.getItem())
      tgt.addItem(convertQuestionnaireResponseItemComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent convertQuestionnaireResponseItemAnswerComponent(org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent tgt = new org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent();
    VersionConvertor_40_50_Context.INSTANCE.getVersionConvertor_40_50_a().copyElement(src, tgt);
    if (src.hasValue())
      tgt.setValue(VersionConvertor_40_50.convertType(src.getValue()));
    for (org.hl7.fhir.r5.model.QuestionnaireResponse.QuestionnaireResponseItemComponent t : src.getItem())
      tgt.addItem(convertQuestionnaireResponseItemComponent(t));
    return tgt;
  }
}