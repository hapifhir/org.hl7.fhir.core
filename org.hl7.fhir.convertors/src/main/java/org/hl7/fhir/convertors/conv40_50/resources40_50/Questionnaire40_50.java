package org.hl7.fhir.convertors.conv40_50.resources40_50;

import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.convertors.context.ConversionContext40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.CodeableConcept40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Coding40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Identifier40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.general40_50.Period40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.metadata40_50.ContactDetail40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.metadata40_50.UsageContext40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Boolean40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Canonical40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Code40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Date40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.DateTime40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Integer40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.MarkDown40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.String40_50;
import org.hl7.fhir.convertors.conv40_50.datatypes40_50.primitive40_50.Uri40_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemType;
import org.hl7.fhir.r5.model.CodeType;
import org.hl7.fhir.r5.model.Questionnaire.QuestionnaireAnswerConstraint;

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
public class Questionnaire40_50 {

  public static org.hl7.fhir.r5.model.Questionnaire convertQuestionnaire(org.hl7.fhir.r4.model.Questionnaire src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Questionnaire tgt = new org.hl7.fhir.r5.model.Questionnaire();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri40_50.convertUri(src.getUrlElement()));
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_50.convertIdentifier(t));
    if (src.hasVersion())
      tgt.setVersionElement(String40_50.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String40_50.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String40_50.convertString(src.getTitleElement()));
    for (org.hl7.fhir.r4.model.CanonicalType t : src.getDerivedFrom())
      tgt.getDerivedFrom().add(Canonical40_50.convertCanonical(t));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations40_50.convertPublicationStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean40_50.convertBoolean(src.getExperimentalElement()));
    for (org.hl7.fhir.r4.model.CodeType t : src.getSubjectType())
      tgt.getSubjectType().add(Code40_50.convertCode(t));
    if (src.hasDate())
      tgt.setDateElement(DateTime40_50.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String40_50.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.r4.model.ContactDetail t : src.getContact())
      tgt.addContact(ContactDetail40_50.convertContactDetail(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown40_50.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r4.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(UsageContext40_50.convertUsageContext(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(CodeableConcept40_50.convertCodeableConcept(t));
    if (src.hasPurpose())
      tgt.setPurposeElement(MarkDown40_50.convertMarkdown(src.getPurposeElement()));
    if (src.hasCopyright())
      tgt.setCopyrightElement(MarkDown40_50.convertMarkdown(src.getCopyrightElement()));
    if (src.hasApprovalDate())
      tgt.setApprovalDateElement(Date40_50.convertDate(src.getApprovalDateElement()));
    if (src.hasLastReviewDate())
      tgt.setLastReviewDateElement(Date40_50.convertDate(src.getLastReviewDateElement()));
    if (src.hasEffectivePeriod())
      tgt.setEffectivePeriod(Period40_50.convertPeriod(src.getEffectivePeriod()));
    for (org.hl7.fhir.r4.model.Coding t : src.getCode()) tgt.addCode(Coding40_50.convertCoding(t));
    for (org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemComponent t : src.getItem())
      tgt.addItem(convertQuestionnaireItemComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Questionnaire convertQuestionnaire(org.hl7.fhir.r5.model.Questionnaire src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Questionnaire tgt = new org.hl7.fhir.r4.model.Questionnaire();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri40_50.convertUri(src.getUrlElement()));
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_50.convertIdentifier(t));
    if (src.hasVersion())
      tgt.setVersionElement(String40_50.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String40_50.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String40_50.convertString(src.getTitleElement()));
    for (org.hl7.fhir.r5.model.CanonicalType t : src.getDerivedFrom())
      tgt.getDerivedFrom().add(Canonical40_50.convertCanonical(t));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations40_50.convertPublicationStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean40_50.convertBoolean(src.getExperimentalElement()));
    for (CodeType t : src.getSubjectType()) tgt.getSubjectType().add(Code40_50.convertCode(t));
    if (src.hasDate())
      tgt.setDateElement(DateTime40_50.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String40_50.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.r5.model.ContactDetail t : src.getContact())
      tgt.addContact(ContactDetail40_50.convertContactDetail(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown40_50.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r5.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(UsageContext40_50.convertUsageContext(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(CodeableConcept40_50.convertCodeableConcept(t));
    if (src.hasPurpose())
      tgt.setPurposeElement(MarkDown40_50.convertMarkdown(src.getPurposeElement()));
    if (src.hasCopyright())
      tgt.setCopyrightElement(MarkDown40_50.convertMarkdown(src.getCopyrightElement()));
    if (src.hasApprovalDate())
      tgt.setApprovalDateElement(Date40_50.convertDate(src.getApprovalDateElement()));
    if (src.hasLastReviewDate())
      tgt.setLastReviewDateElement(Date40_50.convertDate(src.getLastReviewDateElement()));
    if (src.hasEffectivePeriod())
      tgt.setEffectivePeriod(Period40_50.convertPeriod(src.getEffectivePeriod()));
    for (org.hl7.fhir.r5.model.Coding t : src.getCode()) tgt.addCode(Coding40_50.convertCoding(t));
    for (org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent t : src.getItem())
      tgt.addItem(convertQuestionnaireItemComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent convertQuestionnaireItemComponent(org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent tgt = new org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasLinkId())
      tgt.setLinkIdElement(String40_50.convertString(src.getLinkIdElement()));
    if (src.hasDefinition())
      tgt.setDefinitionElement(Uri40_50.convertUri(src.getDefinitionElement()));
    for (org.hl7.fhir.r4.model.Coding t : src.getCode()) tgt.addCode(Coding40_50.convertCoding(t));
    if (src.hasPrefix())
      tgt.setPrefixElement(String40_50.convertString(src.getPrefixElement()));
    if (src.hasText())
      tgt.setTextElement(MarkDown40_50.convertStringToMarkdown(src.getTextElement()));
    if (src.hasType()) {
      tgt.setTypeElement(convertQuestionnaireItemType(src.getTypeElement()));
      if (src.getType() == QuestionnaireItemType.CHOICE) {
        tgt.setAnswerConstraint(QuestionnaireAnswerConstraint.OPTIONSONLY);
      } else if (src.getType() == QuestionnaireItemType.OPENCHOICE) {
        tgt.setAnswerConstraint(QuestionnaireAnswerConstraint.OPTIONSORSTRING);
      }
    }
    for (org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemEnableWhenComponent t : src.getEnableWhen())
      tgt.addEnableWhen(convertQuestionnaireItemEnableWhenComponent(t));
    if (src.hasEnableBehavior())
      tgt.setEnableBehaviorElement(convertEnableWhenBehavior(src.getEnableBehaviorElement()));
    if (src.hasRequired())
      tgt.setRequiredElement(Boolean40_50.convertBoolean(src.getRequiredElement()));
    if (src.hasRepeats())
      tgt.setRepeatsElement(Boolean40_50.convertBoolean(src.getRepeatsElement()));
    if (src.hasReadOnly())
      tgt.setReadOnlyElement(Boolean40_50.convertBoolean(src.getReadOnlyElement()));
    if (src.hasMaxLength())
      tgt.setMaxLengthElement(Integer40_50.convertInteger(src.getMaxLengthElement()));
    if (src.hasAnswerValueSet())
      tgt.setAnswerValueSetElement(Canonical40_50.convertCanonical(src.getAnswerValueSetElement()));
    for (org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemAnswerOptionComponent t : src.getAnswerOption())
      tgt.addAnswerOption(convertQuestionnaireItemAnswerOptionComponent(t));
    for (org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemInitialComponent t : src.getInitial())
      tgt.addInitial(convertQuestionnaireItemInitialComponent(t));
    for (org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemComponent t : src.getItem())
      tgt.addItem(convertQuestionnaireItemComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemComponent convertQuestionnaireItemComponent(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemComponent tgt = new org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasLinkId())
      tgt.setLinkIdElement(String40_50.convertString(src.getLinkIdElement()));
    if (src.hasDefinition())
      tgt.setDefinitionElement(Uri40_50.convertUri(src.getDefinitionElement()));
    for (org.hl7.fhir.r5.model.Coding t : src.getCode()) tgt.addCode(Coding40_50.convertCoding(t));
    if (src.hasPrefix())
      tgt.setPrefixElement(String40_50.convertString(src.getPrefixElement()));
    if (src.hasText())
      tgt.setTextElement(String40_50.convertString(src.getTextElement()));
    if (src.hasType())
      tgt.setTypeElement(convertQuestionnaireItemType(src.getTypeElement(), src.getAnswerConstraint()));
    for (org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemEnableWhenComponent t : src.getEnableWhen())
      tgt.addEnableWhen(convertQuestionnaireItemEnableWhenComponent(t));
    if (src.hasEnableBehavior())
      tgt.setEnableBehaviorElement(convertEnableWhenBehavior(src.getEnableBehaviorElement()));
    if (src.hasRequired())
      tgt.setRequiredElement(Boolean40_50.convertBoolean(src.getRequiredElement()));
    if (src.hasRepeats())
      tgt.setRepeatsElement(Boolean40_50.convertBoolean(src.getRepeatsElement()));
    if (src.hasReadOnly())
      tgt.setReadOnlyElement(Boolean40_50.convertBoolean(src.getReadOnlyElement()));
    if (src.hasMaxLength())
      tgt.setMaxLengthElement(Integer40_50.convertInteger(src.getMaxLengthElement()));
    if (src.hasAnswerValueSet())
      tgt.setAnswerValueSetElement(Canonical40_50.convertCanonical(src.getAnswerValueSetElement()));
    for (org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemAnswerOptionComponent t : src.getAnswerOption())
      tgt.addAnswerOption(convertQuestionnaireItemAnswerOptionComponent(t));
    for (org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemInitialComponent t : src.getInitial())
      tgt.addInitial(convertQuestionnaireItemInitialComponent(t));
    for (org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent t : src.getItem())
      tgt.addItem(convertQuestionnaireItemComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemType> convertQuestionnaireItemType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemTypeEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    tgt.addExtension(VersionConvertorConstants.EXT_QUESTIONNAIRE_ITEM_TYPE_ORIGINAL, new CodeType(src.getValueAsString()));
    switch (src.getValue()) {
      case GROUP:
        tgt.setValue(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemType.GROUP);
        break;
      case DISPLAY:
        tgt.setValue(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemType.DISPLAY);
        break;
      case QUESTION:
        tgt.setValue(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemType.GROUP);
        break;
      case BOOLEAN:
        tgt.setValue(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemType.BOOLEAN);
        break;
      case DECIMAL:
        tgt.setValue(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemType.DECIMAL);
        break;
      case INTEGER:
        tgt.setValue(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemType.INTEGER);
        break;
      case DATE:
        tgt.setValue(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemType.DATE);
        break;
      case DATETIME:
        tgt.setValue(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemType.DATETIME);
        break;
      case TIME:
        tgt.setValue(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemType.TIME);
        break;
      case STRING:
        tgt.setValue(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemType.STRING);
        break;
      case TEXT:
        tgt.setValue(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemType.TEXT);
        break;
      case URL:
        tgt.setValue(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemType.URL);
        break;
      case CHOICE:
        tgt.setValue(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemType.CODING);
        break;
      case OPENCHOICE:
        tgt.setValue(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemType.CODING);
        break;
      case ATTACHMENT:
        tgt.setValue(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemType.ATTACHMENT);
        break;
      case REFERENCE:
        tgt.setValue(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemType.REFERENCE);
        break;
      case QUANTITY:
        tgt.setValue(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemType.QUANTITY);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemType.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemType> convertQuestionnaireItemType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemType> src, QuestionnaireAnswerConstraint constraint) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemTypeEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt, VersionConvertorConstants.EXT_QUESTIONNAIRE_ITEM_TYPE_ORIGINAL);
    if (src.hasExtension(VersionConvertorConstants.EXT_QUESTIONNAIRE_ITEM_TYPE_ORIGINAL)) {
      tgt.setValueAsString(src.getExtensionString(VersionConvertorConstants.EXT_QUESTIONNAIRE_ITEM_TYPE_ORIGINAL));
    } else {
      switch (src.getValue()) {
        case GROUP:
          tgt.setValue(org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemType.GROUP);
          break;
        case DISPLAY:
          tgt.setValue(org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemType.DISPLAY);
          break;
        // case QUESTION: return org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemType.QUESTION;
        case BOOLEAN:
          tgt.setValue(org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemType.BOOLEAN);
          break;
        case DECIMAL:
          tgt.setValue(org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemType.DECIMAL);
          break;
        case INTEGER:
          tgt.setValue(org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemType.INTEGER);
          break;
        case DATE:
          tgt.setValue(org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemType.DATE);
          break;
        case DATETIME:
          tgt.setValue(org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemType.DATETIME);
          break;
        case TIME:
          tgt.setValue(org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemType.TIME);
          break;
        case STRING:
          tgt.setValue(org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemType.STRING);
          break;
        case TEXT:
          tgt.setValue(org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemType.TEXT);
          break;
        case URL:
          tgt.setValue(org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemType.URL);
          break;
        case CODING:
          if (constraint == QuestionnaireAnswerConstraint.OPTIONSORSTRING)
            tgt.setValue(org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemType.OPENCHOICE);
          else
            tgt.setValue(org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemType.CHOICE);
          break;
        case ATTACHMENT:
          tgt.setValue(org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemType.ATTACHMENT);
          break;
        case REFERENCE:
          tgt.setValue(org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemType.REFERENCE);
          break;
        case QUANTITY:
          tgt.setValue(org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemType.QUANTITY);
          break;
        default:
          tgt.setValue(org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemType.NULL);
          break;
      }
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Questionnaire.EnableWhenBehavior> convertEnableWhenBehavior(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Questionnaire.EnableWhenBehavior> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Questionnaire.EnableWhenBehavior> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Questionnaire.EnableWhenBehaviorEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case ALL:
        tgt.setValue(org.hl7.fhir.r5.model.Questionnaire.EnableWhenBehavior.ALL);
        break;
      case ANY:
        tgt.setValue(org.hl7.fhir.r5.model.Questionnaire.EnableWhenBehavior.ANY);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.Questionnaire.EnableWhenBehavior.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Questionnaire.EnableWhenBehavior> convertEnableWhenBehavior(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Questionnaire.EnableWhenBehavior> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Questionnaire.EnableWhenBehavior> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Questionnaire.EnableWhenBehaviorEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case ALL:
        tgt.setValue(org.hl7.fhir.r4.model.Questionnaire.EnableWhenBehavior.ALL);
        break;
      case ANY:
        tgt.setValue(org.hl7.fhir.r4.model.Questionnaire.EnableWhenBehavior.ANY);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.Questionnaire.EnableWhenBehavior.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemEnableWhenComponent convertQuestionnaireItemEnableWhenComponent(org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemEnableWhenComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemEnableWhenComponent tgt = new org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemEnableWhenComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasQuestion())
      tgt.setQuestionElement(String40_50.convertString(src.getQuestionElement()));
    if (src.hasOperator())
      tgt.setOperatorElement(convertQuestionnaireItemOperator(src.getOperatorElement()));
    if (src.hasAnswer())
      tgt.setAnswer(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getAnswer()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemEnableWhenComponent convertQuestionnaireItemEnableWhenComponent(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemEnableWhenComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemEnableWhenComponent tgt = new org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemEnableWhenComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasQuestion())
      tgt.setQuestionElement(String40_50.convertString(src.getQuestionElement()));
    if (src.hasOperator())
      tgt.setOperatorElement(convertQuestionnaireItemOperator(src.getOperatorElement()));
    if (src.hasAnswer())
      tgt.setAnswer(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getAnswer()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemOperator> convertQuestionnaireItemOperator(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemOperator> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemOperator> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemOperatorEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case EXISTS:
        tgt.setValue(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemOperator.EXISTS);
        break;
      case EQUAL:
        tgt.setValue(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemOperator.EQUAL);
        break;
      case NOT_EQUAL:
        tgt.setValue(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemOperator.NOT_EQUAL);
        break;
      case GREATER_THAN:
        tgt.setValue(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemOperator.GREATER_THAN);
        break;
      case LESS_THAN:
        tgt.setValue(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemOperator.LESS_THAN);
        break;
      case GREATER_OR_EQUAL:
        tgt.setValue(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemOperator.GREATER_OR_EQUAL);
        break;
      case LESS_OR_EQUAL:
        tgt.setValue(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemOperator.LESS_OR_EQUAL);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemOperator.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemOperator> convertQuestionnaireItemOperator(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemOperator> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemOperator> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemOperatorEnumFactory());
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case EXISTS:
        tgt.setValue(org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemOperator.EXISTS);
        break;
      case EQUAL:
        tgt.setValue(org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemOperator.EQUAL);
        break;
      case NOT_EQUAL:
        tgt.setValue(org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemOperator.NOT_EQUAL);
        break;
      case GREATER_THAN:
        tgt.setValue(org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemOperator.GREATER_THAN);
        break;
      case LESS_THAN:
        tgt.setValue(org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemOperator.LESS_THAN);
        break;
      case GREATER_OR_EQUAL:
        tgt.setValue(org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemOperator.GREATER_OR_EQUAL);
        break;
      case LESS_OR_EQUAL:
        tgt.setValue(org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemOperator.LESS_OR_EQUAL);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemOperator.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemAnswerOptionComponent convertQuestionnaireItemAnswerOptionComponent(org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemAnswerOptionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemAnswerOptionComponent tgt = new org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemAnswerOptionComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasValue())
      tgt.setValue(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getValue()));
    if (src.hasInitialSelected())
      tgt.setInitialSelectedElement(Boolean40_50.convertBoolean(src.getInitialSelectedElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemAnswerOptionComponent convertQuestionnaireItemAnswerOptionComponent(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemAnswerOptionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemAnswerOptionComponent tgt = new org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemAnswerOptionComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasValue())
      tgt.setValue(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getValue()));
    if (src.hasInitialSelected())
      tgt.setInitialSelectedElement(Boolean40_50.convertBoolean(src.getInitialSelectedElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemInitialComponent convertQuestionnaireItemInitialComponent(org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemInitialComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemInitialComponent tgt = new org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemInitialComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasValue())
      tgt.setValue(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getValue()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemInitialComponent convertQuestionnaireItemInitialComponent(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemInitialComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemInitialComponent tgt = new org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemInitialComponent();
    ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().copyBackboneElement(src, tgt);
    if (src.hasValue())
      tgt.setValue(ConversionContext40_50.INSTANCE.getVersionConvertor_40_50().convertType(src.getValue()));
    return tgt;
  }
}