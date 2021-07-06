package org.hl7.fhir.convertors.conv30_50.resources30_50;

import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.convertors.VersionConvertor_30_50;
import org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemType;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CodeType;
import org.hl7.fhir.r5.model.Questionnaire;
import org.hl7.fhir.r5.model.Questionnaire.QuestionnaireAnswerConstraint;
import org.hl7.fhir.r5.utils.ToolingExtensions;

public class Questionnaire30_50 {

    public static org.hl7.fhir.r5.model.Questionnaire convertQuestionnaire(org.hl7.fhir.dstu3.model.Questionnaire src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Questionnaire tgt = new org.hl7.fhir.r5.model.Questionnaire();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrlElement(VersionConvertor_30_50.convertUri(src.getUrlElement()));
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(t));
        if (src.hasVersion())
            tgt.setVersionElement(VersionConvertor_30_50.convertString(src.getVersionElement()));
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_30_50.convertString(src.getNameElement()));
        if (src.hasTitle())
            tgt.setTitleElement(VersionConvertor_30_50.convertString(src.getTitleElement()));
        if (src.hasStatus())
            tgt.setStatusElement(VersionConvertor_30_50.convertPublicationStatus(src.getStatusElement()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(VersionConvertor_30_50.convertBoolean(src.getExperimentalElement()));
        if (src.hasDate())
            tgt.setDateElement(VersionConvertor_30_50.convertDateTime(src.getDateElement()));
        if (src.hasPublisher())
            tgt.setPublisherElement(VersionConvertor_30_50.convertString(src.getPublisherElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(VersionConvertor_30_50.convertMarkdown(src.getDescriptionElement()));
        if (src.hasPurpose())
            tgt.setPurposeElement(VersionConvertor_30_50.convertMarkdown(src.getPurposeElement()));
        if (src.hasApprovalDate())
            tgt.setApprovalDateElement(VersionConvertor_30_50.convertDate(src.getApprovalDateElement()));
        if (src.hasLastReviewDate())
            tgt.setLastReviewDateElement(VersionConvertor_30_50.convertDate(src.getLastReviewDateElement()));
        if (src.hasEffectivePeriod())
            tgt.setEffectivePeriod(VersionConvertor_30_50.convertPeriod(src.getEffectivePeriod()));
        for (org.hl7.fhir.dstu3.model.UsageContext t : src.getUseContext()) tgt.addUseContext(VersionConvertor_30_50.convertUsageContext(t));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(VersionConvertor_30_50.convertCodeableConcept(t));
        for (org.hl7.fhir.dstu3.model.ContactDetail t : src.getContact()) tgt.addContact(VersionConvertor_30_50.convertContactDetail(t));
        if (src.hasCopyright())
            tgt.setCopyrightElement(VersionConvertor_30_50.convertMarkdown(src.getCopyrightElement()));
        for (org.hl7.fhir.dstu3.model.Coding t : src.getCode()) tgt.addCode(VersionConvertor_30_50.convertCoding(t));
        for (org.hl7.fhir.dstu3.model.CodeType t : src.getSubjectType()) tgt.addSubjectType(t.getValue());
        for (org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemComponent t : src.getItem()) tgt.addItem(convertQuestionnaireItemComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Questionnaire convertQuestionnaire(org.hl7.fhir.r5.model.Questionnaire src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Questionnaire tgt = new org.hl7.fhir.dstu3.model.Questionnaire();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrlElement(VersionConvertor_30_50.convertUri(src.getUrlElement()));
        for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(t));
        if (src.hasVersion())
            tgt.setVersionElement(VersionConvertor_30_50.convertString(src.getVersionElement()));
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_30_50.convertString(src.getNameElement()));
        if (src.hasTitle())
            tgt.setTitleElement(VersionConvertor_30_50.convertString(src.getTitleElement()));
        if (src.hasStatus())
            tgt.setStatusElement(VersionConvertor_30_50.convertPublicationStatus(src.getStatusElement()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(VersionConvertor_30_50.convertBoolean(src.getExperimentalElement()));
        if (src.hasDate())
            tgt.setDateElement(VersionConvertor_30_50.convertDateTime(src.getDateElement()));
        if (src.hasPublisher())
            tgt.setPublisherElement(VersionConvertor_30_50.convertString(src.getPublisherElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(VersionConvertor_30_50.convertMarkdown(src.getDescriptionElement()));
        if (src.hasPurpose())
            tgt.setPurposeElement(VersionConvertor_30_50.convertMarkdown(src.getPurposeElement()));
        if (src.hasApprovalDate())
            tgt.setApprovalDateElement(VersionConvertor_30_50.convertDate(src.getApprovalDateElement()));
        if (src.hasLastReviewDate())
            tgt.setLastReviewDateElement(VersionConvertor_30_50.convertDate(src.getLastReviewDateElement()));
        if (src.hasEffectivePeriod())
            tgt.setEffectivePeriod(VersionConvertor_30_50.convertPeriod(src.getEffectivePeriod()));
        for (org.hl7.fhir.r5.model.UsageContext t : src.getUseContext()) tgt.addUseContext(VersionConvertor_30_50.convertUsageContext(t));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(VersionConvertor_30_50.convertCodeableConcept(t));
        for (org.hl7.fhir.r5.model.ContactDetail t : src.getContact()) tgt.addContact(VersionConvertor_30_50.convertContactDetail(t));
        if (src.hasCopyright())
            tgt.setCopyrightElement(VersionConvertor_30_50.convertMarkdown(src.getCopyrightElement()));
        for (org.hl7.fhir.r5.model.Coding t : src.getCode()) tgt.addCode(VersionConvertor_30_50.convertCoding(t));
        for (org.hl7.fhir.r5.model.CodeType t : src.getSubjectType()) tgt.addSubjectType(t.getValue());
        for (org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent t : src.getItem()) tgt.addItem(convertQuestionnaireItemComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemComponent convertQuestionnaireItemComponent(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemComponent tgt = new org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasLinkId())
            tgt.setLinkIdElement(VersionConvertor_30_50.convertString(src.getLinkIdElement()));
        if (src.hasDefinition())
            tgt.setDefinitionElement(VersionConvertor_30_50.convertUri(src.getDefinitionElement()));
        for (org.hl7.fhir.r5.model.Coding t : src.getCode()) tgt.addCode(VersionConvertor_30_50.convertCoding(t));
        if (src.hasPrefix())
            tgt.setPrefixElement(VersionConvertor_30_50.convertString(src.getPrefixElement()));
        if (src.hasText())
            tgt.setTextElement(VersionConvertor_30_50.convertString(src.getTextElement()));
        if (src.hasType()) 
            tgt.setTypeElement(convertQuestionnaireItemType(src.getTypeElement(), src.getAnswerConstraint()));
        for (org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemEnableWhenComponent t : src.getEnableWhen()) tgt.addEnableWhen(convertQuestionnaireItemEnableWhenComponent(t));
        if (src.hasRequired())
            tgt.setRequiredElement(VersionConvertor_30_50.convertBoolean(src.getRequiredElement()));
        if (src.hasRepeats())
            tgt.setRepeatsElement(VersionConvertor_30_50.convertBoolean(src.getRepeatsElement()));
        if (src.hasReadOnly())
            tgt.setReadOnlyElement(VersionConvertor_30_50.convertBoolean(src.getReadOnlyElement()));
        if (src.hasMaxLength())
            tgt.setMaxLengthElement(VersionConvertor_30_50.convertInteger(src.getMaxLengthElement()));
        if (src.hasAnswerValueSet())
            tgt.setOptions(VersionConvertor_30_50.convertCanonicalToReference(src.getAnswerValueSetElement()));
        for (org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemAnswerOptionComponent t : src.getAnswerOption()) tgt.addOption(convertQuestionnaireItemOptionComponent(t));
        if (src.hasInitial())
            tgt.setInitial(VersionConvertor_30_50.convertType(src.getInitialFirstRep().getValue()));
        for (org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent t : src.getItem()) tgt.addItem(convertQuestionnaireItemComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent convertQuestionnaireItemComponent(org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent tgt = new org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasLinkId())
            tgt.setLinkIdElement(VersionConvertor_30_50.convertString(src.getLinkIdElement()));
        if (src.hasDefinition())
            tgt.setDefinitionElement(VersionConvertor_30_50.convertUri(src.getDefinitionElement()));
        for (org.hl7.fhir.dstu3.model.Coding t : src.getCode()) tgt.addCode(VersionConvertor_30_50.convertCoding(t));
        if (src.hasPrefix())
            tgt.setPrefixElement(VersionConvertor_30_50.convertString(src.getPrefixElement()));
        if (src.hasText())
            tgt.setTextElement(VersionConvertor_30_50.convertStringToMarkdown(src.getTextElement()));
        if (src.hasType()) {
            tgt.setTypeElement(convertQuestionnaireItemType(src.getTypeElement()));
            if (src.getType() == QuestionnaireItemType.CHOICE) {
              tgt.setAnswerConstraint(QuestionnaireAnswerConstraint.OPTIONSONLY);
            } else if (src.getType() == QuestionnaireItemType.OPENCHOICE) {
              tgt.setAnswerConstraint(QuestionnaireAnswerConstraint.OPTIONSORSTRING);
            } 
        }
        for (org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemEnableWhenComponent t : src.getEnableWhen()) tgt.addEnableWhen(convertQuestionnaireItemEnableWhenComponent(t));
        tgt.setEnableBehavior(Questionnaire.EnableWhenBehavior.ANY);
        if (src.hasRequired())
            tgt.setRequiredElement(VersionConvertor_30_50.convertBoolean(src.getRequiredElement()));
        if (src.hasRepeats())
            tgt.setRepeatsElement(VersionConvertor_30_50.convertBoolean(src.getRepeatsElement()));
        if (src.hasReadOnly())
            tgt.setReadOnlyElement(VersionConvertor_30_50.convertBoolean(src.getReadOnlyElement()));
        if (src.hasMaxLength())
            tgt.setMaxLengthElement(VersionConvertor_30_50.convertInteger(src.getMaxLengthElement()));
        if (src.hasOptions())
            tgt.setAnswerValueSetElement(VersionConvertor_30_50.convertReferenceToCanonical(src.getOptions()));
        for (org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemOptionComponent t : src.getOption()) tgt.addAnswerOption(convertQuestionnaireItemOptionComponent(t));
        if (src.hasInitial())
            tgt.addInitial().setValue(VersionConvertor_30_50.convertType(src.getInitial()));
        for (org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemComponent t : src.getItem()) tgt.addItem(convertQuestionnaireItemComponent(t));
        for (org.hl7.fhir.dstu3.model.Extension t : src.getModifierExtension()) {
            tgt.addModifierExtension(VersionConvertor_30_50.convertExtension(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemEnableWhenComponent convertQuestionnaireItemEnableWhenComponent(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemEnableWhenComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemEnableWhenComponent tgt = new org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemEnableWhenComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasQuestion())
            tgt.setQuestionElement(VersionConvertor_30_50.convertString(src.getQuestionElement()));
        if (src.hasOperator() && src.getOperator() == org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemOperator.EXISTS)
            tgt.setHasAnswer(src.getAnswerBooleanType().getValue());
        else if (src.hasAnswer())
            tgt.setAnswer(VersionConvertor_30_50.convertType(src.getAnswer()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemEnableWhenComponent convertQuestionnaireItemEnableWhenComponent(org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemEnableWhenComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemEnableWhenComponent tgt = new org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemEnableWhenComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasQuestion())
            tgt.setQuestionElement(VersionConvertor_30_50.convertString(src.getQuestionElement()));
        if (src.hasHasAnswer()) {
            tgt.setOperator(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemOperator.EXISTS);
            if (src.hasHasAnswerElement())
                tgt.setAnswer(VersionConvertor_30_50.convertType(src.getHasAnswerElement()));
        } else if (src.hasAnswer()) {
            tgt.setOperator(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemOperator.EQUAL);
            if (src.hasAnswer())
                tgt.setAnswer(VersionConvertor_30_50.convertType(src.getAnswer()));
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemAnswerOptionComponent convertQuestionnaireItemOptionComponent(org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemOptionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemAnswerOptionComponent tgt = new org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemAnswerOptionComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasValue())
            tgt.setValue(VersionConvertor_30_50.convertType(src.getValue()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemOptionComponent convertQuestionnaireItemOptionComponent(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemAnswerOptionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemOptionComponent tgt = new org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemOptionComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasValue())
            tgt.setValue(VersionConvertor_30_50.convertType(src.getValue()));
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemType> convertQuestionnaireItemType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemType> src, QuestionnaireAnswerConstraint constraint) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemType> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemTypeEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt, VersionConvertorConstants.EXT_QUESTIONNAIRE_ITEM_TYPE_ORIGINAL);
        if (src.hasExtension(VersionConvertorConstants.EXT_QUESTIONNAIRE_ITEM_TYPE_ORIGINAL)) {
          tgt.setValueAsString(src.getExtensionString(VersionConvertorConstants.EXT_QUESTIONNAIRE_ITEM_TYPE_ORIGINAL));
        } else {
          switch(src.getValue()) {
            case GROUP:
                tgt.setValue(org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemType.GROUP);
                break;
            case DISPLAY:
                tgt.setValue(org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemType.DISPLAY);
                break;
            case BOOLEAN:
                tgt.setValue(org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemType.BOOLEAN);
                break;
            case DECIMAL:
                tgt.setValue(org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemType.DECIMAL);
                break;
            case INTEGER:
                tgt.setValue(org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemType.INTEGER);
                break;
            case DATE:
                tgt.setValue(org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemType.DATE);
                break;
            case DATETIME:
                tgt.setValue(org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemType.DATETIME);
                break;
            case TIME:
                tgt.setValue(org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemType.TIME);
                break;
            case STRING:
                tgt.setValue(org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemType.STRING);
                break;
            case TEXT:
                tgt.setValue(org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemType.TEXT);
                break;
            case URL:
                tgt.setValue(org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemType.URL);
                break;
            case CODING:
              if (constraint == QuestionnaireAnswerConstraint.OPTIONSORSTRING)
                tgt.setValue(org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemType.OPENCHOICE);
              else 
                tgt.setValue(org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemType.CHOICE);
              break;
            case ATTACHMENT:
                tgt.setValue(org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemType.ATTACHMENT);
                break;
            case REFERENCE:
                tgt.setValue(org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemType.REFERENCE);
                break;
            case QUANTITY:
                tgt.setValue(org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemType.QUANTITY);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemType.NULL);
                break;
          }
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemType> convertQuestionnaireItemType(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemTypeEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        tgt.addExtension(VersionConvertorConstants.EXT_QUESTIONNAIRE_ITEM_TYPE_ORIGINAL, new CodeType(src.getValueAsString()));
        switch(src.getValue()) {
            case GROUP:
                tgt.setValue(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemType.GROUP);
                break;
            case DISPLAY:
                tgt.setValue(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemType.DISPLAY);
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
}