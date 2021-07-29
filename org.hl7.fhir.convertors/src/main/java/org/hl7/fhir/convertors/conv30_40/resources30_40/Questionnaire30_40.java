package org.hl7.fhir.convertors.conv30_40.resources30_40;

import org.hl7.fhir.convertors.conv30_40.VersionConvertor_30_40; import org.hl7.fhir.convertors.context.ConversionContext30_40; import org.hl7.fhir.convertors.factory.VersionConvertorFactory_30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Element30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Type30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.*;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.ContactDetail30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.*;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Extension30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Reference30_40;
import org.hl7.fhir.exceptions.FHIRException; import org.hl7.fhir.convertors.context.ConversionContext30_40;
import org.hl7.fhir.r4.model.Questionnaire;

public class Questionnaire30_40 {

    public static org.hl7.fhir.r4.model.Questionnaire convertQuestionnaire(org.hl7.fhir.dstu3.model.Questionnaire src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Questionnaire tgt = new org.hl7.fhir.r4.model.Questionnaire();
        ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrlElement(Uri30_40.convertUri(src.getUrlElement()));
        for (org.hl7.fhir.dstu3.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(Identifier30_40.convertIdentifier(t));
        if (src.hasVersion())
            tgt.setVersionElement(String30_40.convertString(src.getVersionElement()));
        if (src.hasName())
            tgt.setNameElement(String30_40.convertString(src.getNameElement()));
        if (src.hasTitle())
            tgt.setTitleElement(String30_40.convertString(src.getTitleElement()));
        if (src.hasStatus())
            tgt.setStatusElement(Enumerations30_40.convertPublicationStatus(src.getStatusElement()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(Boolean30_40.convertBoolean(src.getExperimentalElement()));
        if (src.hasDateElement())
            tgt.setDateElement(DateTime30_40.convertDateTime(src.getDateElement()));
        if (src.hasPublisher())
            tgt.setPublisherElement(String30_40.convertString(src.getPublisherElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(MarkDown30_40.convertMarkdown(src.getDescriptionElement()));
        if (src.hasPurpose())
            tgt.setPurposeElement(MarkDown30_40.convertMarkdown(src.getPurposeElement()));
        if (src.hasApprovalDate())
            tgt.setApprovalDateElement(Date30_40.convertDate(src.getApprovalDateElement()));
        if (src.hasLastReviewDate())
            tgt.setLastReviewDateElement(Date30_40.convertDate(src.getLastReviewDateElement()));
        if (src.hasEffectivePeriod())
            tgt.setEffectivePeriod(Period30_40.convertPeriod(src.getEffectivePeriod()));
        for (org.hl7.fhir.dstu3.model.UsageContext t : src.getUseContext()) tgt.addUseContext(Timing30_40.convertUsageContext(t));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(CodeableConcept30_40.convertCodeableConcept(t));
        for (org.hl7.fhir.dstu3.model.ContactDetail t : src.getContact()) tgt.addContact(ContactDetail30_40.convertContactDetail(t));
        if (src.hasCopyright())
            tgt.setCopyrightElement(MarkDown30_40.convertMarkdown(src.getCopyrightElement()));
        for (org.hl7.fhir.dstu3.model.Coding t : src.getCode()) tgt.addCode(Coding30_40.convertCoding(t));
        for (org.hl7.fhir.dstu3.model.CodeType t : src.getSubjectType()) tgt.addSubjectType(t.getValue());
        for (org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemComponent t : src.getItem()) tgt.addItem(convertQuestionnaireItemComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Questionnaire convertQuestionnaire(org.hl7.fhir.r4.model.Questionnaire src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Questionnaire tgt = new org.hl7.fhir.dstu3.model.Questionnaire();
        ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrlElement(Uri30_40.convertUri(src.getUrlElement()));
        for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier()) tgt.addIdentifier(Identifier30_40.convertIdentifier(t));
        if (src.hasVersion())
            tgt.setVersionElement(String30_40.convertString(src.getVersionElement()));
        if (src.hasName())
            tgt.setNameElement(String30_40.convertString(src.getNameElement()));
        if (src.hasTitle())
            tgt.setTitleElement(String30_40.convertString(src.getTitleElement()));
        if (src.hasStatus())
            tgt.setStatusElement(Enumerations30_40.convertPublicationStatus(src.getStatusElement()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(Boolean30_40.convertBoolean(src.getExperimentalElement()));
        if (src.hasDateElement())
            tgt.setDateElement(DateTime30_40.convertDateTime(src.getDateElement()));
        if (src.hasPublisher())
            tgt.setPublisherElement(String30_40.convertString(src.getPublisherElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(MarkDown30_40.convertMarkdown(src.getDescriptionElement()));
        if (src.hasPurpose())
            tgt.setPurposeElement(MarkDown30_40.convertMarkdown(src.getPurposeElement()));
        if (src.hasApprovalDate())
            tgt.setApprovalDateElement(Date30_40.convertDate(src.getApprovalDateElement()));
        if (src.hasLastReviewDate())
            tgt.setLastReviewDateElement(Date30_40.convertDate(src.getLastReviewDateElement()));
        if (src.hasEffectivePeriod())
            tgt.setEffectivePeriod(Period30_40.convertPeriod(src.getEffectivePeriod()));
        for (org.hl7.fhir.r4.model.UsageContext t : src.getUseContext()) tgt.addUseContext(Timing30_40.convertUsageContext(t));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(CodeableConcept30_40.convertCodeableConcept(t));
        for (org.hl7.fhir.r4.model.ContactDetail t : src.getContact()) tgt.addContact(ContactDetail30_40.convertContactDetail(t));
        if (src.hasCopyright())
            tgt.setCopyrightElement(MarkDown30_40.convertMarkdown(src.getCopyrightElement()));
        for (org.hl7.fhir.r4.model.Coding t : src.getCode()) tgt.addCode(Coding30_40.convertCoding(t));
        for (org.hl7.fhir.r4.model.CodeType t : src.getSubjectType()) tgt.addSubjectType(t.getValue());
        for (org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemComponent t : src.getItem()) tgt.addItem(convertQuestionnaireItemComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemComponent convertQuestionnaireItemComponent(org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemComponent tgt = new org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemComponent();
        ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
        if (src.hasLinkId())
            tgt.setLinkIdElement(String30_40.convertString(src.getLinkIdElement()));
        if (src.hasDefinition())
            tgt.setDefinitionElement(Uri30_40.convertUri(src.getDefinitionElement()));
        for (org.hl7.fhir.r4.model.Coding t : src.getCode()) tgt.addCode(Coding30_40.convertCoding(t));
        if (src.hasPrefix())
            tgt.setPrefixElement(String30_40.convertString(src.getPrefixElement()));
        if (src.hasText())
            tgt.setTextElement(String30_40.convertString(src.getTextElement()));
        if (src.hasType())
            tgt.setTypeElement(convertQuestionnaireItemType(src.getTypeElement()));
        for (org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemEnableWhenComponent t : src.getEnableWhen()) tgt.addEnableWhen(convertQuestionnaireItemEnableWhenComponent(t));
        if (src.hasRequired())
            tgt.setRequiredElement(Boolean30_40.convertBoolean(src.getRequiredElement()));
        if (src.hasRepeats())
            tgt.setRepeatsElement(Boolean30_40.convertBoolean(src.getRepeatsElement()));
        if (src.hasReadOnly())
            tgt.setReadOnlyElement(Boolean30_40.convertBoolean(src.getReadOnlyElement()));
        if (src.hasMaxLength())
            tgt.setMaxLengthElement(Integer30_40.convertInteger(src.getMaxLengthElement()));
        if (src.hasAnswerValueSet())
            tgt.setOptions(Reference30_40.convertCanonicalToReference(src.getAnswerValueSetElement()));
        for (org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemAnswerOptionComponent t : src.getAnswerOption()) tgt.addOption(convertQuestionnaireItemOptionComponent(t));
        if (src.hasInitial())
            tgt.setInitial(VersionConvertorFactory_30_40.convertType(src.getInitialFirstRep().getValue()));
        for (org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemComponent t : src.getItem()) tgt.addItem(convertQuestionnaireItemComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemComponent convertQuestionnaireItemComponent(org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemComponent tgt = new org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemComponent();
        ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
        if (src.hasLinkId())
            tgt.setLinkIdElement(String30_40.convertString(src.getLinkIdElement()));
        if (src.hasDefinition())
            tgt.setDefinitionElement(Uri30_40.convertUri(src.getDefinitionElement()));
        for (org.hl7.fhir.dstu3.model.Coding t : src.getCode()) tgt.addCode(Coding30_40.convertCoding(t));
        if (src.hasPrefix())
            tgt.setPrefixElement(String30_40.convertString(src.getPrefixElement()));
        if (src.hasText())
            tgt.setTextElement(String30_40.convertString(src.getTextElement()));
        if (src.hasType())
            tgt.setTypeElement(convertQuestionnaireItemType(src.getTypeElement()));
        for (org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemEnableWhenComponent t : src.getEnableWhen()) tgt.addEnableWhen(convertQuestionnaireItemEnableWhenComponent(t));
        tgt.setEnableBehavior(Questionnaire.EnableWhenBehavior.ANY);
        if (src.hasRequired())
            tgt.setRequiredElement(Boolean30_40.convertBoolean(src.getRequiredElement()));
        if (src.hasRepeats())
            tgt.setRepeatsElement(Boolean30_40.convertBoolean(src.getRepeatsElement()));
        if (src.hasReadOnly())
            tgt.setReadOnlyElement(Boolean30_40.convertBoolean(src.getReadOnlyElement()));
        if (src.hasMaxLength())
            tgt.setMaxLengthElement(Integer30_40.convertInteger(src.getMaxLengthElement()));
        if (src.hasOptions())
            tgt.setAnswerValueSetElement(Reference30_40.convertReferenceToCanonical(src.getOptions()));
        for (org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemOptionComponent t : src.getOption()) tgt.addAnswerOption(convertQuestionnaireItemOptionComponent(t));
        if (src.hasInitial())
            tgt.addInitial().setValue(VersionConvertorFactory_30_40.convertType(src.getInitial()));
        for (org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemComponent t : src.getItem()) tgt.addItem(convertQuestionnaireItemComponent(t));
        for (org.hl7.fhir.dstu3.model.Extension t : src.getModifierExtension()) {
            tgt.addModifierExtension(Extension30_40.convertExtension(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemEnableWhenComponent convertQuestionnaireItemEnableWhenComponent(org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemEnableWhenComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemEnableWhenComponent tgt = new org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemEnableWhenComponent();
        ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
        if (src.hasQuestion())
            tgt.setQuestionElement(String30_40.convertString(src.getQuestionElement()));
        if (src.hasOperator() && src.getOperator() == org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemOperator.EXISTS)
            tgt.setHasAnswer(src.getAnswerBooleanType().getValue());
        else if (src.hasAnswer())
            tgt.setAnswer(VersionConvertorFactory_30_40.convertType(src.getAnswer()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemEnableWhenComponent convertQuestionnaireItemEnableWhenComponent(org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemEnableWhenComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemEnableWhenComponent tgt = new org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemEnableWhenComponent();
        ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
        if (src.hasQuestion())
            tgt.setQuestionElement(String30_40.convertString(src.getQuestionElement()));
        if (src.hasHasAnswer()) {
            tgt.setOperator(org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemOperator.EXISTS);
            if (src.hasHasAnswerElement())
                tgt.setAnswer(VersionConvertorFactory_30_40.convertType(src.getHasAnswerElement()));
        } else if (src.hasAnswer()) {
            tgt.setOperator(org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemOperator.EQUAL);
            if (src.hasAnswer())
                tgt.setAnswer(VersionConvertorFactory_30_40.convertType(src.getAnswer()));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemAnswerOptionComponent convertQuestionnaireItemOptionComponent(org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemOptionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemAnswerOptionComponent tgt = new org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemAnswerOptionComponent();
        ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
        if (src.hasValue())
            tgt.setValue(VersionConvertorFactory_30_40.convertType(src.getValue()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemOptionComponent convertQuestionnaireItemOptionComponent(org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemAnswerOptionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemOptionComponent tgt = new org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemOptionComponent();
        ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
        if (src.hasValue())
            tgt.setValue(VersionConvertorFactory_30_40.convertType(src.getValue()));
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemType> convertQuestionnaireItemType(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemTypeEnumFactory());
        ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
        switch(src.getValue()) {
            case GROUP:
                tgt.setValue(org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemType.GROUP);
                break;
            case DISPLAY:
                tgt.setValue(org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemType.DISPLAY);
                break;
            case QUESTION:
                tgt.setValue(org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemType.QUESTION);
                break;
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
            case CHOICE:
                tgt.setValue(org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemType.CHOICE);
                break;
            case OPENCHOICE:
                tgt.setValue(org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemType.OPENCHOICE);
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
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemType> convertQuestionnaireItemType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.Questionnaire.QuestionnaireItemType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemType> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemTypeEnumFactory());
        ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
        switch(src.getValue()) {
            case GROUP:
                tgt.setValue(org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemType.GROUP);
                break;
            case DISPLAY:
                tgt.setValue(org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemType.DISPLAY);
                break;
            case QUESTION:
                tgt.setValue(org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemType.QUESTION);
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
            case CHOICE:
                tgt.setValue(org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemType.CHOICE);
                break;
            case OPENCHOICE:
                tgt.setValue(org.hl7.fhir.dstu3.model.Questionnaire.QuestionnaireItemType.OPENCHOICE);
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
        return tgt;
    }
}