package org.hl7.fhir.convertors.conv43_N.resources43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Identifier43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Canonical43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.DateTime43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.String43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.Uri43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.special43_N.Reference43_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.Enumeration;
import org.hl7.fhir.model.core.QuestionnaireResponse;

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

public class QuestionnaireResponse43_N {

  public static org.hl7.fhir.model.core.QuestionnaireResponse convertQuestionnaireResponse(org.hl7.fhir.r4b.model.QuestionnaireResponse src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.QuestionnaireResponse tgt = new org.hl7.fhir.model.core.QuestionnaireResponse();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    if (src.hasIdentifier())
      tgt.addIdentifier(Identifier43_N.convertIdentifier(src.getIdentifier()));
    for (org.hl7.fhir.r4b.model.Reference t : src.getBasedOn()) tgt.addBasedOn(Reference43_N.convertReference(t));
    for (org.hl7.fhir.r4b.model.Reference t : src.getPartOf()) tgt.addPartOf(Reference43_N.convertReference(t));
    if (src.hasQuestionnaire())
      tgt.setQuestionnaireElement(Canonical43_N.convertCanonical(src.getQuestionnaireElement()));
    if (src.hasStatus())
      tgt.setStatusElement(convertQuestionnaireResponseStatus(src.getStatusElement()));
    if (src.hasSubject())
      tgt.setSubject(Reference43_N.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference43_N.convertReference(src.getEncounter()));
    if (src.hasAuthored())
      tgt.setAuthoredElement(DateTime43_N.convertDateTime(src.getAuthoredElement()));
    if (src.hasAuthor())
      tgt.setAuthor(Reference43_N.convertReference(src.getAuthor()));
    if (src.hasSource())
      tgt.setSource(Reference43_N.convertReference(src.getSource()));
    for (org.hl7.fhir.r4b.model.QuestionnaireResponse.QuestionnaireResponseItemComponent t : src.getItem())
      tgt.addItem(convertQuestionnaireResponseItemComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.QuestionnaireResponse convertQuestionnaireResponse(org.hl7.fhir.model.core.QuestionnaireResponse src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.QuestionnaireResponse tgt = new org.hl7.fhir.r4b.model.QuestionnaireResponse();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier43_N.convertIdentifier(src.getIdentifierFirstRep()));
    for (org.hl7.fhir.model.core.Reference t : src.getBasedOnList()) tgt.addBasedOn(Reference43_N.convertReference(t));
    for (org.hl7.fhir.model.core.Reference t : src.getPartOfList()) tgt.addPartOf(Reference43_N.convertReference(t));
    if (src.hasQuestionnaire())
      tgt.setQuestionnaireElement(Canonical43_N.convertCanonical(src.getQuestionnaireElement()));
    if (src.hasStatus())
      tgt.setStatusElement(convertQuestionnaireResponseStatus(src.getStatusElement()));
    if (src.hasSubject())
      tgt.setSubject(Reference43_N.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference43_N.convertReference(src.getEncounter()));
    if (src.hasAuthored())
      tgt.setAuthoredElement(DateTime43_N.convertDateTime(src.getAuthoredElement()));
    if (src.hasAuthor())
      tgt.setAuthor(Reference43_N.convertReference(src.getAuthor()));
    if (src.hasSource())
      tgt.setSource(Reference43_N.convertReference(src.getSource()));
    for (org.hl7.fhir.model.core.QuestionnaireResponse.QuestionnaireResponseItemComponent t : src.getItemList())
      tgt.addItem(convertQuestionnaireResponseItemComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.QuestionnaireResponse.QuestionnaireResponseStatus> convertQuestionnaireResponseStatus(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.QuestionnaireResponse.QuestionnaireResponseStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<QuestionnaireResponse.QuestionnaireResponseStatus> tgt = new Enumeration<>(new QuestionnaireResponse.QuestionnaireResponseStatusEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case INPROGRESS:
                  tgt.setValue(QuestionnaireResponse.QuestionnaireResponseStatus.INPROGRESS);
                  break;
              case COMPLETED:
                  tgt.setValue(QuestionnaireResponse.QuestionnaireResponseStatus.COMPLETED);
                  break;
              case AMENDED:
                  tgt.setValue(QuestionnaireResponse.QuestionnaireResponseStatus.AMENDED);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(QuestionnaireResponse.QuestionnaireResponseStatus.ENTEREDINERROR);
                  break;
              case STOPPED:
                  tgt.setValue(QuestionnaireResponse.QuestionnaireResponseStatus.STOPPED);
                  break;
              default:
                  tgt.setValue(QuestionnaireResponse.QuestionnaireResponseStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.QuestionnaireResponse.QuestionnaireResponseStatus> convertQuestionnaireResponseStatus(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.QuestionnaireResponse.QuestionnaireResponseStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.QuestionnaireResponse.QuestionnaireResponseStatus> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.QuestionnaireResponse.QuestionnaireResponseStatusEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case INPROGRESS:
                  tgt.setValue(org.hl7.fhir.r4b.model.QuestionnaireResponse.QuestionnaireResponseStatus.INPROGRESS);
                  break;
              case COMPLETED:
                  tgt.setValue(org.hl7.fhir.r4b.model.QuestionnaireResponse.QuestionnaireResponseStatus.COMPLETED);
                  break;
              case AMENDED:
                  tgt.setValue(org.hl7.fhir.r4b.model.QuestionnaireResponse.QuestionnaireResponseStatus.AMENDED);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(org.hl7.fhir.r4b.model.QuestionnaireResponse.QuestionnaireResponseStatus.ENTEREDINERROR);
                  break;
              case STOPPED:
                  tgt.setValue(org.hl7.fhir.r4b.model.QuestionnaireResponse.QuestionnaireResponseStatus.STOPPED);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4b.model.QuestionnaireResponse.QuestionnaireResponseStatus.NULL);
                  break;
          }
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.QuestionnaireResponse.QuestionnaireResponseItemComponent convertQuestionnaireResponseItemComponent(org.hl7.fhir.r4b.model.QuestionnaireResponse.QuestionnaireResponseItemComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.QuestionnaireResponse.QuestionnaireResponseItemComponent tgt = new org.hl7.fhir.model.core.QuestionnaireResponse.QuestionnaireResponseItemComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasLinkId())
      tgt.setLinkIdElement(String43_N.convertString(src.getLinkIdElement()));
    if (src.hasDefinition())
      tgt.getDefinitionList().add(Uri43_N.convertUri(src.getDefinitionElement()));
    if (src.hasText())
      tgt.setTextElement(String43_N.convertString(src.getTextElement()));
    for (org.hl7.fhir.r4b.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent t : src.getAnswer())
      tgt.addAnswer(convertQuestionnaireResponseItemAnswerComponent(t));
    for (org.hl7.fhir.r4b.model.QuestionnaireResponse.QuestionnaireResponseItemComponent t : src.getItem())
      tgt.addItem(convertQuestionnaireResponseItemComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.QuestionnaireResponse.QuestionnaireResponseItemComponent convertQuestionnaireResponseItemComponent(org.hl7.fhir.model.core.QuestionnaireResponse.QuestionnaireResponseItemComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.QuestionnaireResponse.QuestionnaireResponseItemComponent tgt = new org.hl7.fhir.r4b.model.QuestionnaireResponse.QuestionnaireResponseItemComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasLinkId())
      tgt.setLinkIdElement(String43_N.convertString(src.getLinkIdElement()));
    if (src.hasDefinition())
      tgt.setDefinitionElement(Uri43_N.convertUri(src.getDefinitionList().get(0)));
    if (src.hasText())
      tgt.setTextElement(String43_N.convertString(src.getTextElement()));
    for (org.hl7.fhir.model.core.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent t : src.getAnswerList())
      tgt.addAnswer(convertQuestionnaireResponseItemAnswerComponent(t));
    for (org.hl7.fhir.model.core.QuestionnaireResponse.QuestionnaireResponseItemComponent t : src.getItemList())
      tgt.addItem(convertQuestionnaireResponseItemComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent convertQuestionnaireResponseItemAnswerComponent(org.hl7.fhir.r4b.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent tgt = new org.hl7.fhir.model.core.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasValue())
      tgt.setValue(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getValue()));
    for (org.hl7.fhir.r4b.model.QuestionnaireResponse.QuestionnaireResponseItemComponent t : src.getItem())
      tgt.addItem(convertQuestionnaireResponseItemComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent convertQuestionnaireResponseItemAnswerComponent(org.hl7.fhir.model.core.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent tgt = new org.hl7.fhir.r4b.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasValue())
      tgt.setValue(ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().convertType(src.getValue()));
    for (org.hl7.fhir.model.core.QuestionnaireResponse.QuestionnaireResponseItemComponent t : src.getItemList())
      tgt.addItem(convertQuestionnaireResponseItemComponent(t));
    return tgt;
  }
}