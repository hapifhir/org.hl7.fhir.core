package org.hl7.fhir.convertors.conv30_40;

import org.hl7.fhir.convertors.VersionConvertor_30_40;
import org.hl7.fhir.exceptions.FHIRException;
import java.util.Collections;

public class MessageDefinition30_40 {

    public static org.hl7.fhir.dstu3.model.MessageDefinition convertMessageDefinition(org.hl7.fhir.r4.model.MessageDefinition src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.MessageDefinition tgt = new org.hl7.fhir.dstu3.model.MessageDefinition();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        if (src.hasUrlElement())
            tgt.setUrlElement((org.hl7.fhir.dstu3.model.UriType) VersionConvertor_30_40.convertType(src.getUrlElement()));
        if (src.hasIdentifier())
            tgt.setIdentifier(VersionConvertor_30_40.convertIdentifier(src.getIdentifierFirstRep()));
        if (src.hasVersionElement())
            tgt.setVersionElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_40.convertType(src.getVersionElement()));
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_40.convertType(src.getNameElement()));
        if (src.hasTitleElement())
            tgt.setTitleElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_40.convertType(src.getTitleElement()));
        if (src.hasStatus())
            tgt.setStatus(VersionConvertor_30_40.convertPublicationStatus(src.getStatus()));
        if (src.hasExperimentalElement())
            tgt.setExperimentalElement((org.hl7.fhir.dstu3.model.BooleanType) VersionConvertor_30_40.convertType(src.getExperimentalElement()));
        if (src.hasDateElement())
            tgt.setDateElement(VersionConvertor_30_40.convertDateTime(src.getDateElement()));
        if (src.hasPublisherElement())
            tgt.setPublisherElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_40.convertType(src.getPublisherElement()));
        if (src.hasContact()) {
            for (org.hl7.fhir.r4.model.ContactDetail t : src.getContact()) tgt.addContact(VersionConvertor_30_40.convertContactDetail(t));
        }
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.dstu3.model.MarkdownType) VersionConvertor_30_40.convertType(src.getDescriptionElement()));
        if (src.hasUseContext()) {
            for (org.hl7.fhir.r4.model.UsageContext t : src.getUseContext()) tgt.addUseContext(VersionConvertor_30_40.convertUsageContext(t));
        }
        if (src.hasJurisdiction()) {
            for (org.hl7.fhir.r4.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        if (src.hasPurposeElement())
            tgt.setPurposeElement((org.hl7.fhir.dstu3.model.MarkdownType) VersionConvertor_30_40.convertType(src.getPurposeElement()));
        if (src.hasCopyrightElement())
            tgt.setCopyrightElement((org.hl7.fhir.dstu3.model.MarkdownType) VersionConvertor_30_40.convertType(src.getCopyrightElement()));
        if (src.hasBase())
            tgt.setBase(VersionConvertor_30_40.convertCanonicalToReference(src.getBaseElement()));
        if (src.hasParent()) {
            for (org.hl7.fhir.r4.model.CanonicalType t : src.getParent()) tgt.addParent(VersionConvertor_30_40.convertCanonicalToReference(t));
        }
        if (src.hasReplaces()) {
            for (org.hl7.fhir.r4.model.CanonicalType t : src.getReplaces()) tgt.addReplaces(VersionConvertor_30_40.convertCanonicalToReference(t));
        }
        if (src.hasEventCoding())
            tgt.setEvent(VersionConvertor_30_40.convertCoding(src.getEventCoding()));
        if (src.hasCategory())
            tgt.setCategory(convertMessageSignificanceCategory(src.getCategory()));
        if (src.hasFocus()) {
            for (org.hl7.fhir.r4.model.MessageDefinition.MessageDefinitionFocusComponent t : src.getFocus()) tgt.addFocus(convertMessageDefinitionFocusComponent(t));
        }
        if (src.hasResponseRequired())
            tgt.setResponseRequired(src.getResponseRequired() != org.hl7.fhir.r4.model.MessageDefinition.MessageheaderResponseRequest.NEVER);
        if (src.hasAllowedResponse()) {
            for (org.hl7.fhir.r4.model.MessageDefinition.MessageDefinitionAllowedResponseComponent t : src.getAllowedResponse()) tgt.addAllowedResponse(convertMessageDefinitionAllowedResponseComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.MessageDefinition convertMessageDefinition(org.hl7.fhir.dstu3.model.MessageDefinition src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.MessageDefinition tgt = new org.hl7.fhir.r4.model.MessageDefinition();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        if (src.hasUrlElement())
            tgt.setUrlElement((org.hl7.fhir.r4.model.UriType) VersionConvertor_30_40.convertType(src.getUrlElement()));
        if (src.hasIdentifier())
            tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(src.getIdentifier()));
        if (src.hasVersionElement())
            tgt.setVersionElement((org.hl7.fhir.r4.model.StringType) VersionConvertor_30_40.convertType(src.getVersionElement()));
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.r4.model.StringType) VersionConvertor_30_40.convertType(src.getNameElement()));
        if (src.hasTitleElement())
            tgt.setTitleElement((org.hl7.fhir.r4.model.StringType) VersionConvertor_30_40.convertType(src.getTitleElement()));
        if (src.hasStatus())
            tgt.setStatus(VersionConvertor_30_40.convertPublicationStatus(src.getStatus()));
        if (src.hasExperimentalElement())
            tgt.setExperimentalElement((org.hl7.fhir.r4.model.BooleanType) VersionConvertor_30_40.convertType(src.getExperimentalElement()));
        if (src.hasDateElement())
            tgt.setDateElement(VersionConvertor_30_40.convertDateTime(src.getDateElement()));
        if (src.hasPublisherElement())
            tgt.setPublisherElement((org.hl7.fhir.r4.model.StringType) VersionConvertor_30_40.convertType(src.getPublisherElement()));
        if (src.hasContact()) {
            for (org.hl7.fhir.dstu3.model.ContactDetail t : src.getContact()) tgt.addContact(VersionConvertor_30_40.convertContactDetail(t));
        }
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.r4.model.MarkdownType) VersionConvertor_30_40.convertType(src.getDescriptionElement()));
        if (src.hasUseContext()) {
            for (org.hl7.fhir.dstu3.model.UsageContext t : src.getUseContext()) tgt.addUseContext(VersionConvertor_30_40.convertUsageContext(t));
        }
        if (src.hasJurisdiction()) {
            for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        if (src.hasPurposeElement())
            tgt.setPurposeElement((org.hl7.fhir.r4.model.MarkdownType) VersionConvertor_30_40.convertType(src.getPurposeElement()));
        if (src.hasCopyrightElement())
            tgt.setCopyrightElement((org.hl7.fhir.r4.model.MarkdownType) VersionConvertor_30_40.convertType(src.getCopyrightElement()));
        if (src.hasBase())
            tgt.setBaseElement(VersionConvertor_30_40.convertReferenceToCanonical(src.getBase()));
        if (src.hasParent()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getParent()) tgt.getParent().add(VersionConvertor_30_40.convertReferenceToCanonical(t));
        }
        if (src.hasReplaces()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getReplaces()) tgt.getReplaces().add(VersionConvertor_30_40.convertReferenceToCanonical(t));
        }
        if (src.hasEvent())
            tgt.setEvent(VersionConvertor_30_40.convertCoding(src.getEvent()));
        if (src.hasCategory())
            tgt.setCategory(convertMessageSignificanceCategory(src.getCategory()));
        if (src.hasFocus()) {
            for (org.hl7.fhir.dstu3.model.MessageDefinition.MessageDefinitionFocusComponent t : src.getFocus()) tgt.addFocus(convertMessageDefinitionFocusComponent(t));
        }
        if (src.hasResponseRequired())
            tgt.setResponseRequired(src.getResponseRequired() ? org.hl7.fhir.r4.model.MessageDefinition.MessageheaderResponseRequest.ALWAYS : org.hl7.fhir.r4.model.MessageDefinition.MessageheaderResponseRequest.NEVER);
        if (src.hasAllowedResponse()) {
            for (org.hl7.fhir.dstu3.model.MessageDefinition.MessageDefinitionAllowedResponseComponent t : src.getAllowedResponse()) tgt.addAllowedResponse(convertMessageDefinitionAllowedResponseComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.MessageDefinition.MessageDefinitionAllowedResponseComponent convertMessageDefinitionAllowedResponseComponent(org.hl7.fhir.r4.model.MessageDefinition.MessageDefinitionAllowedResponseComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.MessageDefinition.MessageDefinitionAllowedResponseComponent tgt = new org.hl7.fhir.dstu3.model.MessageDefinition.MessageDefinitionAllowedResponseComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasMessage())
            tgt.setMessage(VersionConvertor_30_40.convertCanonicalToReference(src.getMessageElement()));
        if (src.hasSituationElement())
            tgt.setSituationElement((org.hl7.fhir.dstu3.model.MarkdownType) VersionConvertor_30_40.convertType(src.getSituationElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.MessageDefinition.MessageDefinitionAllowedResponseComponent convertMessageDefinitionAllowedResponseComponent(org.hl7.fhir.dstu3.model.MessageDefinition.MessageDefinitionAllowedResponseComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.MessageDefinition.MessageDefinitionAllowedResponseComponent tgt = new org.hl7.fhir.r4.model.MessageDefinition.MessageDefinitionAllowedResponseComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasMessage())
            tgt.setMessageElement(VersionConvertor_30_40.convertReferenceToCanonical(src.getMessage()));
        if (src.hasSituationElement())
            tgt.setSituationElement((org.hl7.fhir.r4.model.MarkdownType) VersionConvertor_30_40.convertType(src.getSituationElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.MessageDefinition.MessageDefinitionFocusComponent convertMessageDefinitionFocusComponent(org.hl7.fhir.dstu3.model.MessageDefinition.MessageDefinitionFocusComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.MessageDefinition.MessageDefinitionFocusComponent tgt = new org.hl7.fhir.r4.model.MessageDefinition.MessageDefinitionFocusComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasCodeElement())
            tgt.setCodeElement((org.hl7.fhir.r4.model.CodeType) VersionConvertor_30_40.convertType(src.getCodeElement()));
        if (src.hasProfile())
            tgt.setProfileElement(VersionConvertor_30_40.convertReferenceToCanonical(src.getProfile()));
        if (src.hasMinElement())
            tgt.setMinElement((org.hl7.fhir.r4.model.UnsignedIntType) VersionConvertor_30_40.convertType(src.getMinElement()));
        if (src.hasMaxElement())
            tgt.setMaxElement((org.hl7.fhir.r4.model.StringType) VersionConvertor_30_40.convertType(src.getMaxElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.MessageDefinition.MessageDefinitionFocusComponent convertMessageDefinitionFocusComponent(org.hl7.fhir.r4.model.MessageDefinition.MessageDefinitionFocusComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.MessageDefinition.MessageDefinitionFocusComponent tgt = new org.hl7.fhir.dstu3.model.MessageDefinition.MessageDefinitionFocusComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasCodeElement())
            tgt.setCodeElement((org.hl7.fhir.dstu3.model.CodeType) VersionConvertor_30_40.convertType(src.getCodeElement()));
        if (src.hasProfile())
            tgt.setProfile(VersionConvertor_30_40.convertCanonicalToReference(src.getProfileElement()));
        if (src.hasMinElement())
            tgt.setMinElement((org.hl7.fhir.dstu3.model.UnsignedIntType) VersionConvertor_30_40.convertType(src.getMinElement()));
        if (src.hasMaxElement())
            tgt.setMaxElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_40.convertType(src.getMaxElement()));
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.MessageDefinition.MessageSignificanceCategory convertMessageSignificanceCategory(org.hl7.fhir.r4.model.MessageDefinition.MessageSignificanceCategory src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case CONSEQUENCE:
                return org.hl7.fhir.dstu3.model.MessageDefinition.MessageSignificanceCategory.CONSEQUENCE;
            case CURRENCY:
                return org.hl7.fhir.dstu3.model.MessageDefinition.MessageSignificanceCategory.CURRENCY;
            case NOTIFICATION:
                return org.hl7.fhir.dstu3.model.MessageDefinition.MessageSignificanceCategory.NOTIFICATION;
            default:
                return org.hl7.fhir.dstu3.model.MessageDefinition.MessageSignificanceCategory.NULL;
        }
    }

    static public org.hl7.fhir.r4.model.MessageDefinition.MessageSignificanceCategory convertMessageSignificanceCategory(org.hl7.fhir.dstu3.model.MessageDefinition.MessageSignificanceCategory src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case CONSEQUENCE:
                return org.hl7.fhir.r4.model.MessageDefinition.MessageSignificanceCategory.CONSEQUENCE;
            case CURRENCY:
                return org.hl7.fhir.r4.model.MessageDefinition.MessageSignificanceCategory.CURRENCY;
            case NOTIFICATION:
                return org.hl7.fhir.r4.model.MessageDefinition.MessageSignificanceCategory.NOTIFICATION;
            default:
                return org.hl7.fhir.r4.model.MessageDefinition.MessageSignificanceCategory.NULL;
        }
    }
}
