package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.CrossVersionElements40_N;
import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Identifier40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Canonical40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.DateTime40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.String40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Uri40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Reference40_N;
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

public class QuestionnaireResponse40_N {

  public static org.hl7.fhir.model.core.QuestionnaireResponse convertQuestionnaireResponse(org.hl7.fhir.r4.model.QuestionnaireResponse src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.QuestionnaireResponse tgt = new org.hl7.fhir.model.core.QuestionnaireResponse();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    if (src.hasIdentifier())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(src.getIdentifier()));
    CrossVersionElements40_N.extraValuesToR6(src.getExtension(), tgt, "identifier", tgt.getExtension());
    for (org.hl7.fhir.r4.model.Reference t : src.getBasedOn()) tgt.addBasedOn(Reference40_N.convertReference(t));
    for (org.hl7.fhir.r4.model.Reference t : src.getPartOf()) tgt.addPartOf(Reference40_N.convertReference(t));
    if (src.hasQuestionnaire())
      tgt.setQuestionnaireElement(Canonical40_N.convertCanonical(src.getQuestionnaireElement()));
    if (src.hasStatus())
      tgt.setStatusElement(CrossVersionElements40_N.toR6Code(src.getStatusElement(), convertQuestionnaireResponseStatus(src.getStatusElement()), src.fhirType(), "status"));
    if (src.hasSubject())
      tgt.setSubject(Reference40_N.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference40_N.convertReference(src.getEncounter()));
    if (src.hasAuthored())
      tgt.setAuthoredElement(DateTime40_N.convertDateTime(src.getAuthoredElement()));
    if (src.hasAuthor())
      tgt.setAuthor(Reference40_N.convertReference(src.getAuthor()));
    if (src.hasSource())
      tgt.setSource(Reference40_N.convertReference(src.getSource()));
    for (org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseItemComponent t : src.getItem())
      tgt.addItem(convertQuestionnaireResponseItemComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.QuestionnaireResponse convertQuestionnaireResponse(org.hl7.fhir.model.core.QuestionnaireResponse src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.QuestionnaireResponse tgt = new org.hl7.fhir.r4.model.QuestionnaireResponse();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier40_N.convertIdentifier(src.getIdentifierFirstRep()));
    CrossVersionElements40_N.extraValuesToR4(src, "identifier", tgt.getExtension());
    for (org.hl7.fhir.model.core.Reference t : src.getBasedOnList()) tgt.addBasedOn(Reference40_N.convertReference(t));
    for (org.hl7.fhir.model.core.Reference t : src.getPartOfList()) tgt.addPartOf(Reference40_N.convertReference(t));
    if (src.hasQuestionnaire())
      tgt.setQuestionnaireElement(Canonical40_N.convertCanonical(src.getQuestionnaireElement()));
    if (src.hasStatus())
      tgt.setStatusElement(CrossVersionElements40_N.toR4Code(src.getStatusElement(), convertQuestionnaireResponseStatus(src.getStatusElement()), src.fhirType(), "status"));
    if (src.hasSubject())
      tgt.setSubject(Reference40_N.convertReference(src.getSubject()));
    if (src.hasEncounter())
      tgt.setEncounter(Reference40_N.convertReference(src.getEncounter()));
    if (src.hasAuthored())
      tgt.setAuthoredElement(DateTime40_N.convertDateTime(src.getAuthoredElement()));
    if (src.hasAuthor())
      tgt.setAuthor(Reference40_N.convertReference(src.getAuthor()));
    if (src.hasSource())
      tgt.setSource(Reference40_N.convertReference(src.getSource()));
    for (org.hl7.fhir.model.core.QuestionnaireResponse.QuestionnaireResponseItemComponent t : src.getItemList())
      tgt.addItem(convertQuestionnaireResponseItemComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.QuestionnaireResponse.QuestionnaireResponseStatus> convertQuestionnaireResponseStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<QuestionnaireResponse.QuestionnaireResponseStatus> tgt = new Enumeration<>(new QuestionnaireResponse.QuestionnaireResponseStatusEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseStatus> convertQuestionnaireResponseStatus(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.QuestionnaireResponse.QuestionnaireResponseStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseStatusEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
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
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.QuestionnaireResponse.QuestionnaireResponseItemComponent convertQuestionnaireResponseItemComponent(org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseItemComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.QuestionnaireResponse.QuestionnaireResponseItemComponent tgt = new org.hl7.fhir.model.core.QuestionnaireResponse.QuestionnaireResponseItemComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasLinkId())
      tgt.setLinkIdElement(String40_N.convertString(src.getLinkIdElement()));
    if (src.hasDefinition())
      tgt.getDefinitionList().add(Uri40_N.convertUri(src.getDefinitionElement()));
    CrossVersionElements40_N.extraValuesToR6(src.getExtension(), tgt, "definition", tgt.getExtension());
    if (src.hasText())
      tgt.setTextElement(String40_N.convertString(src.getTextElement()));
    for (org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent t : src.getAnswer())
      tgt.addAnswer(convertQuestionnaireResponseItemAnswerComponent(t));
    for (org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseItemComponent t : src.getItem())
      tgt.addItem(convertQuestionnaireResponseItemComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseItemComponent convertQuestionnaireResponseItemComponent(org.hl7.fhir.model.core.QuestionnaireResponse.QuestionnaireResponseItemComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseItemComponent tgt = new org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseItemComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasLinkId())
      tgt.setLinkIdElement(String40_N.convertString(src.getLinkIdElement()));
    if (src.hasDefinition())
      tgt.setDefinitionElement(Uri40_N.convertUri(src.getDefinitionList().get(0)));
    CrossVersionElements40_N.extraValuesToR4(src, "definition", tgt.getExtension());
    if (src.hasText())
      tgt.setTextElement(String40_N.convertString(src.getTextElement()));
    for (org.hl7.fhir.model.core.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent t : src.getAnswerList())
      tgt.addAnswer(convertQuestionnaireResponseItemAnswerComponent(t));
    for (org.hl7.fhir.model.core.QuestionnaireResponse.QuestionnaireResponseItemComponent t : src.getItemList())
      tgt.addItem(convertQuestionnaireResponseItemComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent convertQuestionnaireResponseItemAnswerComponent(org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent tgt = new org.hl7.fhir.model.core.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    // the types R4 and R6 allow differ: a value of a type the other version doesn't allow is an extension
    CrossVersionElements40_N.choiceToR6(src, src.getExtension(), src.fhirType(), "value", tgt, tgt.getExtension());
    for (org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseItemComponent t : src.getItem())
      tgt.addItem(convertQuestionnaireResponseItemComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent convertQuestionnaireResponseItemAnswerComponent(org.hl7.fhir.model.core.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent tgt = new org.hl7.fhir.r4.model.QuestionnaireResponse.QuestionnaireResponseItemAnswerComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    CrossVersionElements40_N.choiceToR4(src, src.getExtension(), src.fhirType(), "value", tgt, tgt.getExtension());
    for (org.hl7.fhir.model.core.QuestionnaireResponse.QuestionnaireResponseItemComponent t : src.getItemList())
      tgt.addItem(convertQuestionnaireResponseItemComponent(t));
    return tgt;
  }
}