package org.hl7.fhir.convertors.conv30_50;

import org.hl7.fhir.convertors.VersionConvertor_30_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.Questionnaire;
import java.util.Collections;

public class Questionnaire30_50 {

    public static org.hl7.fhir.r5.model.Questionnaire convertQuestionnaire(org.hl7.fhir.dstu3.model.Questionnaire src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Questionnaire tgt = new org.hl7.fhir.r5.model.Questionnaire();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        if (src.hasUrlElement())
            tgt.setUrlElement((org.hl7.fhir.r5.model.UriType) VersionConvertor_30_50.convertType(src.getUrlElement()));
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(t));
        }
        if (src.hasVersionElement())
            tgt.setVersionElement((org.hl7.fhir.r5.model.StringType) VersionConvertor_30_50.convertType(src.getVersionElement()));
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.r5.model.StringType) VersionConvertor_30_50.convertType(src.getNameElement()));
        if (src.hasTitleElement())
            tgt.setTitleElement((org.hl7.fhir.r5.model.StringType) VersionConvertor_30_50.convertType(src.getTitleElement()));
        if (src.hasStatus())
            tgt.setStatus(VersionConvertor_30_50.convertPublicationStatus(src.getStatus()));
        if (src.hasExperimentalElement())
            tgt.setExperimentalElement((org.hl7.fhir.r5.model.BooleanType) VersionConvertor_30_50.convertType(src.getExperimentalElement()));
        if (src.hasDateElement())
            tgt.setDateElement((org.hl7.fhir.r5.model.DateTimeType) VersionConvertor_30_50.convertType(src.getDateElement()));
        if (src.hasPublisherElement())
            tgt.setPublisherElement((org.hl7.fhir.r5.model.StringType) VersionConvertor_30_50.convertType(src.getPublisherElement()));
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.r5.model.MarkdownType) VersionConvertor_30_50.convertType(src.getDescriptionElement()));
        if (src.hasPurposeElement())
            tgt.setPurposeElement((org.hl7.fhir.r5.model.MarkdownType) VersionConvertor_30_50.convertType(src.getPurposeElement()));
        if (src.hasApprovalDateElement())
            tgt.setApprovalDateElement((org.hl7.fhir.r5.model.DateType) VersionConvertor_30_50.convertType(src.getApprovalDateElement()));
        if (src.hasLastReviewDateElement())
            tgt.setLastReviewDateElement((org.hl7.fhir.r5.model.DateType) VersionConvertor_30_50.convertType(src.getLastReviewDateElement()));
        if (src.hasEffectivePeriod())
            tgt.setEffectivePeriod(VersionConvertor_30_50.convertPeriod(src.getEffectivePeriod()));
        if (src.hasUseContext()) {
            for (org.hl7.fhir.dstu3.model.UsageContext t : src.getUseContext()) tgt.addUseContext(VersionConvertor_30_50.convertUsageContext(t));
        }
        if (src.hasJurisdiction()) {
            for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(VersionConvertor_30_50.convertCodeableConcept(t));
        }
        if (src.hasContact()) {
            for (org.hl7.fhir.dstu3.model.ContactDetail t : src.getContact()) tgt.addContact(VersionConvertor_30_50.convertContactDetail(t));
        }
        if (src.hasCopyrightElement())
            tgt.setCopyrightElement((org.hl7.fhir.r5.model.MarkdownType) VersionConvertor_30_50.convertType(src.getCopyrightElement()));
        if (src.hasCode()) {
            for (org.hl7.fhir.dstu3.model.Coding t : src.getCode()) tgt.addCode(VersionConvertor_30_50.convertCoding(t));
        }
        if (src.hasSubjectType()) {
            for (org.hl7.fhir.dstu3.model.CodeType t : src.getSubjectType()) tgt.addSubjectType(t.getValue());
        }
        if (src.hasItem()) {
            for (org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemComponent t : src.getItem()) tgt.addItem(convertQuestionnaireItemComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Questionnaire convertQuestionnaire(org.hl7.fhir.r5.model.Questionnaire src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Questionnaire tgt = new org.hl7.fhir.dstu3.model.Questionnaire();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        if (src.hasUrlElement())
            tgt.setUrlElement((org.hl7.fhir.dstu3.model.UriType) VersionConvertor_30_50.convertType(src.getUrlElement()));
        if (src.hasIdentifier()) {
            for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(VersionConvertor_30_50.convertIdentifier(t));
        }
        if (src.hasVersionElement())
            tgt.setVersionElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_50.convertType(src.getVersionElement()));
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_50.convertType(src.getNameElement()));
        if (src.hasTitleElement())
            tgt.setTitleElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_50.convertType(src.getTitleElement()));
        if (src.hasStatus())
            tgt.setStatus(VersionConvertor_30_50.convertPublicationStatus(src.getStatus()));
        if (src.hasExperimentalElement())
            tgt.setExperimentalElement((org.hl7.fhir.dstu3.model.BooleanType) VersionConvertor_30_50.convertType(src.getExperimentalElement()));
        if (src.hasDateElement())
            tgt.setDateElement((org.hl7.fhir.dstu3.model.DateTimeType) VersionConvertor_30_50.convertType(src.getDateElement()));
        if (src.hasPublisherElement())
            tgt.setPublisherElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_50.convertType(src.getPublisherElement()));
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.dstu3.model.MarkdownType) VersionConvertor_30_50.convertType(src.getDescriptionElement()));
        if (src.hasPurposeElement())
            tgt.setPurposeElement((org.hl7.fhir.dstu3.model.MarkdownType) VersionConvertor_30_50.convertType(src.getPurposeElement()));
        if (src.hasApprovalDateElement())
            tgt.setApprovalDateElement((org.hl7.fhir.dstu3.model.DateType) VersionConvertor_30_50.convertType(src.getApprovalDateElement()));
        if (src.hasLastReviewDateElement())
            tgt.setLastReviewDateElement((org.hl7.fhir.dstu3.model.DateType) VersionConvertor_30_50.convertType(src.getLastReviewDateElement()));
        if (src.hasEffectivePeriod())
            tgt.setEffectivePeriod(VersionConvertor_30_50.convertPeriod(src.getEffectivePeriod()));
        if (src.hasUseContext()) {
            for (org.hl7.fhir.r5.model.UsageContext t : src.getUseContext()) tgt.addUseContext(VersionConvertor_30_50.convertUsageContext(t));
        }
        if (src.hasJurisdiction()) {
            for (org.hl7.fhir.r5.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(VersionConvertor_30_50.convertCodeableConcept(t));
        }
        if (src.hasContact()) {
            for (org.hl7.fhir.r5.model.ContactDetail t : src.getContact()) tgt.addContact(VersionConvertor_30_50.convertContactDetail(t));
        }
        if (src.hasCopyrightElement())
            tgt.setCopyrightElement((org.hl7.fhir.dstu3.model.MarkdownType) VersionConvertor_30_50.convertType(src.getCopyrightElement()));
        if (src.hasCode()) {
            for (org.hl7.fhir.r5.model.Coding t : src.getCode()) tgt.addCode(VersionConvertor_30_50.convertCoding(t));
        }
        if (src.hasSubjectType()) {
            for (org.hl7.fhir.r5.model.CodeType t : src.getSubjectType()) tgt.addSubjectType(t.getValue());
        }
        if (src.hasItem()) {
            for (org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent t : src.getItem()) tgt.addItem(convertQuestionnaireItemComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemComponent convertQuestionnaireItemComponent(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemComponent tgt = new org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasLinkIdElement())
            tgt.setLinkIdElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_50.convertType(src.getLinkIdElement()));
        if (src.hasDefinitionElement())
            tgt.setDefinitionElement((org.hl7.fhir.dstu3.model.UriType) VersionConvertor_30_50.convertType(src.getDefinitionElement()));
        if (src.hasCode()) {
            for (org.hl7.fhir.r5.model.Coding t : src.getCode()) tgt.addCode(VersionConvertor_30_50.convertCoding(t));
        }
        if (src.hasPrefixElement())
            tgt.setPrefixElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_50.convertType(src.getPrefixElement()));
        if (src.hasTextElement())
            tgt.setTextElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_50.convertType(src.getTextElement()));
        if (src.hasType())
            tgt.setType(convertQuestionnaireItemType(src.getType()));
        if (src.hasEnableWhen()) {
            for (org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemEnableWhenComponent t : src.getEnableWhen()) tgt.addEnableWhen(convertQuestionnaireItemEnableWhenComponent(t));
        }
        if (src.hasRequiredElement())
            tgt.setRequiredElement((org.hl7.fhir.dstu3.model.BooleanType) VersionConvertor_30_50.convertType(src.getRequiredElement()));
        if (src.hasRepeatsElement())
            tgt.setRepeatsElement((org.hl7.fhir.dstu3.model.BooleanType) VersionConvertor_30_50.convertType(src.getRepeatsElement()));
        if (src.hasReadOnlyElement())
            tgt.setReadOnlyElement((org.hl7.fhir.dstu3.model.BooleanType) VersionConvertor_30_50.convertType(src.getReadOnlyElement()));
        if (src.hasMaxLengthElement())
            tgt.setMaxLengthElement((org.hl7.fhir.dstu3.model.IntegerType) VersionConvertor_30_50.convertType(src.getMaxLengthElement()));
        if (src.hasAnswerValueSet())
            tgt.setOptions(VersionConvertor_30_50.convertCanonicalToReference(src.getAnswerValueSetElement()));
        if (src.hasAnswerOption()) {
            for (org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemAnswerOptionComponent t : src.getAnswerOption()) tgt.addOption(convertQuestionnaireItemOptionComponent(t));
        }
        if (src.hasInitial())
            tgt.setInitial(VersionConvertor_30_50.convertType(src.getInitialFirstRep().getValue()));
        if (src.hasItem()) {
            for (org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent t : src.getItem()) tgt.addItem(convertQuestionnaireItemComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent convertQuestionnaireItemComponent(org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent tgt = new org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasLinkIdElement())
            tgt.setLinkIdElement((org.hl7.fhir.r5.model.StringType) VersionConvertor_30_50.convertType(src.getLinkIdElement()));
        if (src.hasDefinitionElement())
            tgt.setDefinitionElement((org.hl7.fhir.r5.model.UriType) VersionConvertor_30_50.convertType(src.getDefinitionElement()));
        if (src.hasCode()) {
            for (org.hl7.fhir.dstu3.model.Coding t : src.getCode()) tgt.addCode(VersionConvertor_30_50.convertCoding(t));
        }
        if (src.hasPrefixElement())
            tgt.setPrefixElement((org.hl7.fhir.r5.model.StringType) VersionConvertor_30_50.convertType(src.getPrefixElement()));
        if (src.hasTextElement())
            tgt.setTextElement((org.hl7.fhir.r5.model.StringType) VersionConvertor_30_50.convertType(src.getTextElement()));
        if (src.hasType())
            tgt.setType(convertQuestionnaireItemType(src.getType()));
        if (src.hasEnableWhen()) {
            for (org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemEnableWhenComponent t : src.getEnableWhen()) tgt.addEnableWhen(convertQuestionnaireItemEnableWhenComponent(t));
        }
        tgt.setEnableBehavior(Questionnaire.EnableWhenBehavior.ANY);
        if (src.hasRequiredElement())
            tgt.setRequiredElement((org.hl7.fhir.r5.model.BooleanType) VersionConvertor_30_50.convertType(src.getRequiredElement()));
        if (src.hasRepeatsElement())
            tgt.setRepeatsElement((org.hl7.fhir.r5.model.BooleanType) VersionConvertor_30_50.convertType(src.getRepeatsElement()));
        if (src.hasReadOnlyElement())
            tgt.setReadOnlyElement((org.hl7.fhir.r5.model.BooleanType) VersionConvertor_30_50.convertType(src.getReadOnlyElement()));
        if (src.hasMaxLengthElement())
            tgt.setMaxLengthElement((org.hl7.fhir.r5.model.IntegerType) VersionConvertor_30_50.convertType(src.getMaxLengthElement()));
        if (src.hasOptions())
            tgt.setAnswerValueSetElement(VersionConvertor_30_50.convertReferenceToCanonical(src.getOptions()));
        if (src.hasOption()) {
            for (org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemOptionComponent t : src.getOption()) tgt.addAnswerOption(convertQuestionnaireItemOptionComponent(t));
        }
        if (src.hasInitial())
            tgt.addInitial().setValue(VersionConvertor_30_50.convertType(src.getInitial()));
        if (src.hasItem()) {
            for (org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemComponent t : src.getItem()) tgt.addItem(convertQuestionnaireItemComponent(t));
        }
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
        if (src.hasQuestionElement())
            tgt.setQuestionElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_50.convertType(src.getQuestionElement()));
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
        if (src.hasQuestionElement())
            tgt.setQuestionElement((org.hl7.fhir.r5.model.StringType) VersionConvertor_30_50.convertType(src.getQuestionElement()));
        if (src.hasHasAnswer()) {
            tgt.setOperator(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemOperator.EXISTS);
            if (src.hasHasAnswerElement()) {
                tgt.setAnswer(VersionConvertor_30_50.convertType(src.getHasAnswerElement()));
            }
        } else if (src.hasAnswer()) {
            tgt.setOperator(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemOperator.EQUAL);
            if (src.hasAnswer()) {
                tgt.setAnswer(VersionConvertor_30_50.convertType(src.getAnswer()));
            }
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

    static public org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemType convertQuestionnaireItemType(org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case GROUP:
                return org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemType.GROUP;
            case DISPLAY:
                return org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemType.DISPLAY;
            case BOOLEAN:
                return org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemType.BOOLEAN;
            case DECIMAL:
                return org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemType.DECIMAL;
            case INTEGER:
                return org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemType.INTEGER;
            case DATE:
                return org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemType.DATE;
            case DATETIME:
                return org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemType.DATETIME;
            case TIME:
                return org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemType.TIME;
            case STRING:
                return org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemType.STRING;
            case TEXT:
                return org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemType.TEXT;
            case URL:
                return org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemType.URL;
            case CHOICE:
                return org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemType.CHOICE;
            case OPENCHOICE:
                return org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemType.OPENCHOICE;
            case ATTACHMENT:
                return org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemType.ATTACHMENT;
            case REFERENCE:
                return org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemType.REFERENCE;
            case QUANTITY:
                return org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemType.QUANTITY;
            default:
                return org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemType.NULL;
        }
    }

    static public org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemType convertQuestionnaireItemType(org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case GROUP:
                return org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemType.GROUP;
            case DISPLAY:
                return org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemType.DISPLAY;
            case BOOLEAN:
                return org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemType.BOOLEAN;
            case DECIMAL:
                return org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemType.DECIMAL;
            case INTEGER:
                return org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemType.INTEGER;
            case DATE:
                return org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemType.DATE;
            case DATETIME:
                return org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemType.DATETIME;
            case TIME:
                return org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemType.TIME;
            case STRING:
                return org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemType.STRING;
            case TEXT:
                return org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemType.TEXT;
            case URL:
                return org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemType.URL;
            case CHOICE:
                return org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemType.CHOICE;
            case OPENCHOICE:
                return org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemType.OPENCHOICE;
            case ATTACHMENT:
                return org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemType.ATTACHMENT;
            case REFERENCE:
                return org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemType.REFERENCE;
            case QUANTITY:
                return org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemType.QUANTITY;
            default:
                return org.hl7.fhir.r5.model.Questionnaire.QuestionnaireItemType.NULL;
        }
    }
}
