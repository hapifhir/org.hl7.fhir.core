package org.hl7.fhir.convertors.conv40_N.resources40_N;

import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Coding40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Identifier40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Period40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.metadata40_N.ContactDetail40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.metadata40_N.UsageContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Boolean40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Canonical40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Code40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Date40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.DateTime40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Integer40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.MarkDown40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.String40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.Uri40_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemType;
import org.hl7.fhir.model.core.CodeType;
import org.hl7.fhir.model.core.Enumeration;
import org.hl7.fhir.model.core.Questionnaire;
import org.hl7.fhir.model.core.Questionnaire.QuestionnaireAnswerConstraint;

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

public class Questionnaire40_N {

  public static org.hl7.fhir.model.core.Questionnaire convertQuestionnaire(org.hl7.fhir.r4.model.Questionnaire src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Questionnaire tgt = new org.hl7.fhir.model.core.Questionnaire();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri40_N.convertUri(src.getUrlElement()));
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    if (src.hasVersion())
      tgt.setVersionElement(String40_N.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String40_N.convertString(src.getTitleElement()));
    for (org.hl7.fhir.r4.model.CanonicalType t : src.getDerivedFrom())
      tgt.getDerivedFromList().add(Canonical40_N.convertCanonical(t));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations40_N.convertPublicationStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean40_N.convertBoolean(src.getExperimentalElement()));
    for (org.hl7.fhir.r4.model.CodeType t : src.getSubjectType())
      tgt.getSubjectTypeList().add(Code40_N.convertCode(t));
    if (src.hasDate())
      tgt.setDateElement(DateTime40_N.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String40_N.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.r4.model.ContactDetail t : src.getContact())
      tgt.addContact(ContactDetail40_N.convertContactDetail(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown40_N.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r4.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(UsageContext40_N.convertUsageContext(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasPurpose())
      tgt.setPurposeElement(MarkDown40_N.convertMarkdown(src.getPurposeElement()));
    if (src.hasCopyright())
      tgt.setCopyrightElement(MarkDown40_N.convertMarkdown(src.getCopyrightElement()));
    if (src.hasApprovalDate())
      tgt.setApprovalDateElement(Date40_N.convertDate(src.getApprovalDateElement()));
    if (src.hasLastReviewDate())
      tgt.setLastReviewDateElement(Date40_N.convertDate(src.getLastReviewDateElement()));
    if (src.hasEffectivePeriod())
      tgt.setEffectivePeriod(Period40_N.convertPeriod(src.getEffectivePeriod()));
    for (org.hl7.fhir.r4.model.Coding t : src.getCode()) tgt.addCode(Coding40_N.convertCoding(t));
    for (org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemComponent t : src.getItem())
      tgt.addItem(convertQuestionnaireItemComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Questionnaire convertQuestionnaire(org.hl7.fhir.model.core.Questionnaire src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Questionnaire tgt = new org.hl7.fhir.r4.model.Questionnaire();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri40_N.convertUri(src.getUrlElement()));
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(t));
    if (src.hasVersion())
      tgt.setVersionElement(String40_N.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String40_N.convertString(src.getTitleElement()));
    for (org.hl7.fhir.model.core.CanonicalType t : src.getDerivedFromList())
      tgt.getDerivedFrom().add(Canonical40_N.convertCanonical(t));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations40_N.convertPublicationStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean40_N.convertBoolean(src.getExperimentalElement()));
    for (CodeType t : src.getSubjectTypeList()) tgt.getSubjectType().add(Code40_N.convertCode(t));
    if (src.hasDate())
      tgt.setDateElement(DateTime40_N.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String40_N.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.model.core.ContactDetail t : src.getContactList())
      tgt.addContact(ContactDetail40_N.convertContactDetail(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown40_N.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.model.core.UsageContext t : src.getUseContextList())
      tgt.addUseContext(UsageContext40_N.convertUsageContext(t));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getJurisdictionList())
      tgt.addJurisdiction(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasPurpose())
      tgt.setPurposeElement(MarkDown40_N.convertMarkdown(src.getPurposeElement()));
    if (src.hasCopyright())
      tgt.setCopyrightElement(MarkDown40_N.convertMarkdown(src.getCopyrightElement()));
    if (src.hasApprovalDate())
      tgt.setApprovalDateElement(Date40_N.convertDate(src.getApprovalDateElement()));
    if (src.hasLastReviewDate())
      tgt.setLastReviewDateElement(Date40_N.convertDate(src.getLastReviewDateElement()));
    if (src.hasEffectivePeriod())
      tgt.setEffectivePeriod(Period40_N.convertPeriod(src.getEffectivePeriod()));
    for (org.hl7.fhir.model.core.Coding t : src.getCodeList()) tgt.addCode(Coding40_N.convertCoding(t));
    for (org.hl7.fhir.model.core.Questionnaire.QuestionnaireItemComponent t : src.getItemList())
      tgt.addItem(convertQuestionnaireItemComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.model.core.Questionnaire.QuestionnaireItemComponent convertQuestionnaireItemComponent(org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Questionnaire.QuestionnaireItemComponent tgt = new org.hl7.fhir.model.core.Questionnaire.QuestionnaireItemComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasLinkId())
      tgt.setLinkIdElement(String40_N.convertString(src.getLinkIdElement()));
    if (src.hasDefinition())
      tgt.getDefinitionList().add(Uri40_N.convertUri(src.getDefinitionElement()));
    for (org.hl7.fhir.r4.model.Coding t : src.getCode()) tgt.addCode(Coding40_N.convertCoding(t));
    if (src.hasPrefix())
      tgt.setPrefixElement(String40_N.convertString(src.getPrefixElement()));
    if (src.hasText())
      tgt.setTextElement(MarkDown40_N.convertStringToMarkdown(src.getTextElement()));
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
      tgt.setRequiredElement(Boolean40_N.convertBoolean(src.getRequiredElement()));
    if (src.hasRepeats())
      tgt.setRepeatsElement(Boolean40_N.convertBoolean(src.getRepeatsElement()));
    if (src.hasReadOnly())
      tgt.setReadOnlyElement(Boolean40_N.convertBoolean(src.getReadOnlyElement()));
    if (src.hasMaxLength())
      tgt.setMaxLengthElement(Integer40_N.convertInteger(src.getMaxLengthElement()));
    if (src.hasAnswerValueSet())
      tgt.setAnswerValueSetElement(Canonical40_N.convertCanonical(src.getAnswerValueSetElement()));
    for (org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemAnswerOptionComponent t : src.getAnswerOption())
      tgt.addAnswerOption(convertQuestionnaireItemAnswerOptionComponent(t));
    for (org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemInitialComponent t : src.getInitial())
      tgt.addInitial(convertQuestionnaireItemInitialComponent(t));
    for (org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemComponent t : src.getItem())
      tgt.addItem(convertQuestionnaireItemComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemComponent convertQuestionnaireItemComponent(org.hl7.fhir.model.core.Questionnaire.QuestionnaireItemComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemComponent tgt = new org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasLinkId())
      tgt.setLinkIdElement(String40_N.convertString(src.getLinkIdElement()));
    if (src.hasDefinition())
      tgt.setDefinitionElement(Uri40_N.convertUri(src.getDefinitionList().get(0)));
    for (org.hl7.fhir.model.core.Coding t : src.getCodeList()) tgt.addCode(Coding40_N.convertCoding(t));
    if (src.hasPrefix())
      tgt.setPrefixElement(String40_N.convertString(src.getPrefixElement()));
    if (src.hasText())
      tgt.setTextElement(String40_N.convertString(src.getTextElement()));
    if (src.hasType())
      tgt.setTypeElement(convertQuestionnaireItemType(src.getTypeElement(), src.getAnswerConstraint()));
    for (org.hl7.fhir.model.core.Questionnaire.QuestionnaireItemEnableWhenComponent t : src.getEnableWhenList())
      tgt.addEnableWhen(convertQuestionnaireItemEnableWhenComponent(t));
    if (src.hasEnableBehavior())
      tgt.setEnableBehaviorElement(convertEnableWhenBehavior(src.getEnableBehaviorElement()));
    if (src.hasRequired())
      tgt.setRequiredElement(Boolean40_N.convertBoolean(src.getRequiredElement()));
    if (src.hasRepeats())
      tgt.setRepeatsElement(Boolean40_N.convertBoolean(src.getRepeatsElement()));
    if (src.hasReadOnly())
      tgt.setReadOnlyElement(Boolean40_N.convertBoolean(src.getReadOnlyElement()));
    if (src.hasMaxLength())
      tgt.setMaxLengthElement(Integer40_N.convertInteger(src.getMaxLengthElement()));
    if (src.hasAnswerValueSet())
      tgt.setAnswerValueSetElement(Canonical40_N.convertCanonical(src.getAnswerValueSetElement()));
    for (org.hl7.fhir.model.core.Questionnaire.QuestionnaireItemAnswerOptionComponent t : src.getAnswerOptionList())
      tgt.addAnswerOption(convertQuestionnaireItemAnswerOptionComponent(t));
    for (org.hl7.fhir.model.core.Questionnaire.QuestionnaireItemInitialComponent t : src.getInitialList())
      tgt.addInitial(convertQuestionnaireItemInitialComponent(t));
    for (org.hl7.fhir.model.core.Questionnaire.QuestionnaireItemComponent t : src.getItemList())
      tgt.addItem(convertQuestionnaireItemComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<Questionnaire.QuestionnaireItemTypeUsable> convertQuestionnaireItemType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Questionnaire.QuestionnaireItemTypeUsable> tgt = new Enumeration<>(new Questionnaire.QuestionnaireItemTypeUsableEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      tgt.addExtension(VersionConvertorConstants.EXT_QUESTIONNAIRE_ITEM_TYPE_ORIGINAL, new CodeType(src.getValueAsString()));
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case GROUP:
                  tgt.setValue(Questionnaire.QuestionnaireItemTypeUsable.GROUP);
                  break;
              case DISPLAY:
                  tgt.setValue(Questionnaire.QuestionnaireItemTypeUsable.DISPLAY);
                  break;
              case QUESTION:
                  tgt.setValue(Questionnaire.QuestionnaireItemTypeUsable.GROUP);
                  break;
              case BOOLEAN:
                  tgt.setValue(Questionnaire.QuestionnaireItemTypeUsable.BOOLEAN);
                  break;
              case DECIMAL:
                  tgt.setValue(Questionnaire.QuestionnaireItemTypeUsable.DECIMAL);
                  break;
              case INTEGER:
                  tgt.setValue(Questionnaire.QuestionnaireItemTypeUsable.INTEGER);
                  break;
              case DATE:
                  tgt.setValue(Questionnaire.QuestionnaireItemTypeUsable.DATE);
                  break;
              case DATETIME:
                  tgt.setValue(Questionnaire.QuestionnaireItemTypeUsable.DATETIME);
                  break;
              case TIME:
                  tgt.setValue(Questionnaire.QuestionnaireItemTypeUsable.TIME);
                  break;
              case STRING:
                  tgt.setValue(Questionnaire.QuestionnaireItemTypeUsable.STRING);
                  break;
              case TEXT:
                  tgt.setValue(Questionnaire.QuestionnaireItemTypeUsable.TEXT);
                  break;
              case URL:
                  tgt.setValue(Questionnaire.QuestionnaireItemTypeUsable.URL);
                  break;
              case CHOICE:
                  tgt.setValue(Questionnaire.QuestionnaireItemTypeUsable.CODING);
                  break;
              case OPENCHOICE:
                  tgt.setValue(Questionnaire.QuestionnaireItemTypeUsable.CODING);
                  break;
              case ATTACHMENT:
                  tgt.setValue(Questionnaire.QuestionnaireItemTypeUsable.ATTACHMENT);
                  break;
              case REFERENCE:
                  tgt.setValue(Questionnaire.QuestionnaireItemTypeUsable.REFERENCE);
                  break;
              case QUANTITY:
                  tgt.setValue(Questionnaire.QuestionnaireItemTypeUsable.QUANTITY);
                  break;
              default:
                  tgt.setValue(Questionnaire.QuestionnaireItemTypeUsable.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemType> convertQuestionnaireItemType(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Questionnaire.QuestionnaireItemTypeUsable> src, QuestionnaireAnswerConstraint constraint) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemTypeEnumFactory());
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt, VersionConvertorConstants.EXT_QUESTIONNAIRE_ITEM_TYPE_ORIGINAL);
    if (src.hasExtension(VersionConvertorConstants.EXT_QUESTIONNAIRE_ITEM_TYPE_ORIGINAL)) {
      tgt.setValueAsString(src.getExtensionString(VersionConvertorConstants.EXT_QUESTIONNAIRE_ITEM_TYPE_ORIGINAL));
    } else {
        if (src.getValue() == null) {
            tgt.setValue(null);
        } else {
            switch (src.getValue()) {
                case GROUP:
                    tgt.setValue(QuestionnaireItemType.GROUP);
                    break;
                case DISPLAY:
                    tgt.setValue(QuestionnaireItemType.DISPLAY);
                    break;
                // case QUESTION: return org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemType.QUESTION;
                case BOOLEAN:
                    tgt.setValue(QuestionnaireItemType.BOOLEAN);
                    break;
                case DECIMAL:
                    tgt.setValue(QuestionnaireItemType.DECIMAL);
                    break;
                case INTEGER:
                    tgt.setValue(QuestionnaireItemType.INTEGER);
                    break;
                case DATE:
                    tgt.setValue(QuestionnaireItemType.DATE);
                    break;
                case DATETIME:
                    tgt.setValue(QuestionnaireItemType.DATETIME);
                    break;
                case TIME:
                    tgt.setValue(QuestionnaireItemType.TIME);
                    break;
                case STRING:
                    tgt.setValue(QuestionnaireItemType.STRING);
                    break;
                case TEXT:
                    tgt.setValue(QuestionnaireItemType.TEXT);
                    break;
                case URL:
                    tgt.setValue(QuestionnaireItemType.URL);
                    break;
                case CODING:
                    if (constraint == QuestionnaireAnswerConstraint.OPTIONSORSTRING)
                        tgt.setValue(QuestionnaireItemType.OPENCHOICE);
                    else
                        tgt.setValue(QuestionnaireItemType.CHOICE);
                    break;
                case ATTACHMENT:
                    tgt.setValue(QuestionnaireItemType.ATTACHMENT);
                    break;
                case REFERENCE:
                    tgt.setValue(QuestionnaireItemType.REFERENCE);
                    break;
                case QUANTITY:
                    tgt.setValue(QuestionnaireItemType.QUANTITY);
                    break;
                default:
                    tgt.setValue(QuestionnaireItemType.NULL);
                    break;
            }
        }
    }
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Questionnaire.EnableWhenBehavior> convertEnableWhenBehavior(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Questionnaire.EnableWhenBehavior> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Questionnaire.EnableWhenBehavior> tgt = new Enumeration<>(new Questionnaire.EnableWhenBehaviorEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case ALL:
                  tgt.setValue(Questionnaire.EnableWhenBehavior.ALL);
                  break;
              case ANY:
                  tgt.setValue(Questionnaire.EnableWhenBehavior.ANY);
                  break;
              default:
                  tgt.setValue(Questionnaire.EnableWhenBehavior.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Questionnaire.EnableWhenBehavior> convertEnableWhenBehavior(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Questionnaire.EnableWhenBehavior> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Questionnaire.EnableWhenBehavior> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Questionnaire.EnableWhenBehaviorEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
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
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.Questionnaire.QuestionnaireItemEnableWhenComponent convertQuestionnaireItemEnableWhenComponent(org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemEnableWhenComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Questionnaire.QuestionnaireItemEnableWhenComponent tgt = new org.hl7.fhir.model.core.Questionnaire.QuestionnaireItemEnableWhenComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasQuestion())
      tgt.setQuestionElement(String40_N.convertString(src.getQuestionElement()));
    if (src.hasOperator())
      tgt.setOperatorElement(convertQuestionnaireItemOperator(src.getOperatorElement()));
    if (src.hasAnswer())
      tgt.setAnswer(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getAnswer()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemEnableWhenComponent convertQuestionnaireItemEnableWhenComponent(org.hl7.fhir.model.core.Questionnaire.QuestionnaireItemEnableWhenComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemEnableWhenComponent tgt = new org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemEnableWhenComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasQuestion())
      tgt.setQuestionElement(String40_N.convertString(src.getQuestionElement()));
    if (src.hasOperator())
      tgt.setOperatorElement(convertQuestionnaireItemOperator(src.getOperatorElement()));
    if (src.hasAnswer())
      tgt.setAnswer(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getAnswer()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Questionnaire.QuestionnaireItemOperator> convertQuestionnaireItemOperator(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemOperator> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<Questionnaire.QuestionnaireItemOperator> tgt = new Enumeration<>(new Questionnaire.QuestionnaireItemOperatorEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case EXISTS:
                  tgt.setValue(Questionnaire.QuestionnaireItemOperator.EXISTS);
                  break;
              case EQUAL:
                  tgt.setValue(Questionnaire.QuestionnaireItemOperator.EQUAL);
                  break;
              case NOT_EQUAL:
                  tgt.setValue(Questionnaire.QuestionnaireItemOperator.NOT_EQUAL);
                  break;
              case GREATER_THAN:
                  tgt.setValue(Questionnaire.QuestionnaireItemOperator.GREATER_THAN);
                  break;
              case LESS_THAN:
                  tgt.setValue(Questionnaire.QuestionnaireItemOperator.LESS_THAN);
                  break;
              case GREATER_OR_EQUAL:
                  tgt.setValue(Questionnaire.QuestionnaireItemOperator.GREATER_OR_EQUAL);
                  break;
              case LESS_OR_EQUAL:
                  tgt.setValue(Questionnaire.QuestionnaireItemOperator.LESS_OR_EQUAL);
                  break;
              default:
                  tgt.setValue(Questionnaire.QuestionnaireItemOperator.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemOperator> convertQuestionnaireItemOperator(org.hl7.fhir.model.core.Enumeration<org.hl7.fhir.model.core.Questionnaire.QuestionnaireItemOperator> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemOperator> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemOperatorEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
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
      }
      return tgt;
  }

  public static org.hl7.fhir.model.core.Questionnaire.QuestionnaireItemAnswerOptionComponent convertQuestionnaireItemAnswerOptionComponent(org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemAnswerOptionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Questionnaire.QuestionnaireItemAnswerOptionComponent tgt = new org.hl7.fhir.model.core.Questionnaire.QuestionnaireItemAnswerOptionComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasValue())
      tgt.setValue(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getValue()));
    if (src.hasInitialSelected())
      tgt.setInitialSelectedElement(Boolean40_N.convertBoolean(src.getInitialSelectedElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemAnswerOptionComponent convertQuestionnaireItemAnswerOptionComponent(org.hl7.fhir.model.core.Questionnaire.QuestionnaireItemAnswerOptionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemAnswerOptionComponent tgt = new org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemAnswerOptionComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasValue())
      tgt.setValue(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getValue()));
    if (src.hasInitialSelected())
      tgt.setInitialSelectedElement(Boolean40_N.convertBoolean(src.getInitialSelectedElement()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.Questionnaire.QuestionnaireItemInitialComponent convertQuestionnaireItemInitialComponent(org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemInitialComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.core.Questionnaire.QuestionnaireItemInitialComponent tgt = new org.hl7.fhir.model.core.Questionnaire.QuestionnaireItemInitialComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasValue())
      tgt.setValue(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getValue()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemInitialComponent convertQuestionnaireItemInitialComponent(org.hl7.fhir.model.core.Questionnaire.QuestionnaireItemInitialComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemInitialComponent tgt = new org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemInitialComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasValue())
      tgt.setValue(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getValue()));
    return tgt;
  }
}