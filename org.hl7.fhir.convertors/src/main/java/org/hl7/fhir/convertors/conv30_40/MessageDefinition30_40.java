package org.hl7.fhir.convertors.conv30_40;

import org.hl7.fhir.convertors.VersionConvertor_30_40;
import org.hl7.fhir.exceptions.FHIRException;

public class MessageDefinition30_40 {

    public static org.hl7.fhir.dstu3.model.MessageDefinition convertMessageDefinition(org.hl7.fhir.r4.model.MessageDefinition src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.MessageDefinition tgt = new org.hl7.fhir.dstu3.model.MessageDefinition();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrl(src.getUrl());
        if (src.hasIdentifier())
            tgt.setIdentifier(VersionConvertor_30_40.convertIdentifier(src.getIdentifierFirstRep()));
        if (src.hasVersion())
            tgt.setVersion(src.getVersion());
        if (src.hasName())
            tgt.setName(src.getName());
        if (src.hasTitle())
            tgt.setTitle(src.getTitle());
        if (src.hasStatus())
            tgt.setStatus(VersionConvertor_30_40.convertPublicationStatus(src.getStatus()));
        if (src.hasExperimental())
            tgt.setExperimental(src.getExperimental());
        if (src.hasDateElement())
            tgt.setDateElement(VersionConvertor_30_40.convertDateTime(src.getDateElement()));
        if (src.hasPublisher())
            tgt.setPublisher(src.getPublisher());
        for (org.hl7.fhir.r4.model.ContactDetail t : src.getContact()) tgt.addContact(VersionConvertor_30_40.convertContactDetail(t));
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.r4.model.UsageContext t : src.getUseContext()) tgt.addUseContext(VersionConvertor_30_40.convertUsageContext(t));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(VersionConvertor_30_40.convertCodeableConcept(t));
        if (src.hasPurpose())
            tgt.setPurpose(src.getPurpose());
        if (src.hasCopyright())
            tgt.setCopyright(src.getCopyright());
        if (src.hasBase())
            tgt.setBase(VersionConvertor_30_40.convertCanonicalToReference(src.getBaseElement()));
        for (org.hl7.fhir.r4.model.CanonicalType t : src.getParent()) tgt.addParent(VersionConvertor_30_40.convertCanonicalToReference(t));
        for (org.hl7.fhir.r4.model.CanonicalType t : src.getReplaces()) tgt.addReplaces(VersionConvertor_30_40.convertCanonicalToReference(t));
        if (src.hasEventCoding())
            tgt.setEvent(VersionConvertor_30_40.convertCoding(src.getEventCoding()));
        if (src.hasCategory())
            tgt.setCategory(convertMessageSignificanceCategory(src.getCategory()));
        for (org.hl7.fhir.r4.model.MessageDefinition.MessageDefinitionFocusComponent t : src.getFocus()) tgt.addFocus(convertMessageDefinitionFocusComponent(t));
        if (src.hasResponseRequired())
            tgt.setResponseRequired(src.getResponseRequired() != org.hl7.fhir.r4.model.MessageDefinition.MessageheaderResponseRequest.NEVER);
        for (org.hl7.fhir.r4.model.MessageDefinition.MessageDefinitionAllowedResponseComponent t : src.getAllowedResponse()) tgt.addAllowedResponse(convertMessageDefinitionAllowedResponseComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.MessageDefinition convertMessageDefinition(org.hl7.fhir.dstu3.model.MessageDefinition src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.MessageDefinition tgt = new org.hl7.fhir.r4.model.MessageDefinition();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrl(src.getUrl());
        if (src.hasIdentifier())
            tgt.addIdentifier(VersionConvertor_30_40.convertIdentifier(src.getIdentifier()));
        if (src.hasVersion())
            tgt.setVersion(src.getVersion());
        if (src.hasName())
            tgt.setName(src.getName());
        if (src.hasTitle())
            tgt.setTitle(src.getTitle());
        if (src.hasStatus())
            tgt.setStatus(VersionConvertor_30_40.convertPublicationStatus(src.getStatus()));
        if (src.hasExperimental())
            tgt.setExperimental(src.getExperimental());
        if (src.hasDateElement())
            tgt.setDateElement(VersionConvertor_30_40.convertDateTime(src.getDateElement()));
        if (src.hasPublisher())
            tgt.setPublisher(src.getPublisher());
        for (org.hl7.fhir.dstu3.model.ContactDetail t : src.getContact()) tgt.addContact(VersionConvertor_30_40.convertContactDetail(t));
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.dstu3.model.UsageContext t : src.getUseContext()) tgt.addUseContext(VersionConvertor_30_40.convertUsageContext(t));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(VersionConvertor_30_40.convertCodeableConcept(t));
        if (src.hasPurpose())
            tgt.setPurpose(src.getPurpose());
        if (src.hasCopyright())
            tgt.setCopyright(src.getCopyright());
        if (src.hasBase())
            tgt.setBaseElement(VersionConvertor_30_40.convertReferenceToCanonical(src.getBase()));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getParent()) tgt.getParent().add(VersionConvertor_30_40.convertReferenceToCanonical(t));
        for (org.hl7.fhir.dstu3.model.Reference t : src.getReplaces()) tgt.getReplaces().add(VersionConvertor_30_40.convertReferenceToCanonical(t));
        if (src.hasEvent())
            tgt.setEvent(VersionConvertor_30_40.convertCoding(src.getEvent()));
        if (src.hasCategory())
            tgt.setCategory(convertMessageSignificanceCategory(src.getCategory()));
        for (org.hl7.fhir.dstu3.model.MessageDefinition.MessageDefinitionFocusComponent t : src.getFocus()) tgt.addFocus(convertMessageDefinitionFocusComponent(t));
        if (src.hasResponseRequired())
            tgt.setResponseRequired(src.getResponseRequired() ? org.hl7.fhir.r4.model.MessageDefinition.MessageheaderResponseRequest.ALWAYS : org.hl7.fhir.r4.model.MessageDefinition.MessageheaderResponseRequest.NEVER);
        for (org.hl7.fhir.dstu3.model.MessageDefinition.MessageDefinitionAllowedResponseComponent t : src.getAllowedResponse()) tgt.addAllowedResponse(convertMessageDefinitionAllowedResponseComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.MessageDefinition.MessageDefinitionAllowedResponseComponent convertMessageDefinitionAllowedResponseComponent(org.hl7.fhir.r4.model.MessageDefinition.MessageDefinitionAllowedResponseComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.MessageDefinition.MessageDefinitionAllowedResponseComponent tgt = new org.hl7.fhir.dstu3.model.MessageDefinition.MessageDefinitionAllowedResponseComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasMessage())
            tgt.setMessage(VersionConvertor_30_40.convertCanonicalToReference(src.getMessageElement()));
        if (src.hasSituation())
            tgt.setSituation(src.getSituation());
        return tgt;
    }

    public static org.hl7.fhir.r4.model.MessageDefinition.MessageDefinitionAllowedResponseComponent convertMessageDefinitionAllowedResponseComponent(org.hl7.fhir.dstu3.model.MessageDefinition.MessageDefinitionAllowedResponseComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.MessageDefinition.MessageDefinitionAllowedResponseComponent tgt = new org.hl7.fhir.r4.model.MessageDefinition.MessageDefinitionAllowedResponseComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasMessage())
            tgt.setMessageElement(VersionConvertor_30_40.convertReferenceToCanonical(src.getMessage()));
        if (src.hasSituation())
            tgt.setSituation(src.getSituation());
        return tgt;
    }

    public static org.hl7.fhir.r4.model.MessageDefinition.MessageDefinitionFocusComponent convertMessageDefinitionFocusComponent(org.hl7.fhir.dstu3.model.MessageDefinition.MessageDefinitionFocusComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.MessageDefinition.MessageDefinitionFocusComponent tgt = new org.hl7.fhir.r4.model.MessageDefinition.MessageDefinitionFocusComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCode(src.getCode());
        if (src.hasProfile())
            tgt.setProfileElement(VersionConvertor_30_40.convertReferenceToCanonical(src.getProfile()));
        if (src.hasMin())
            tgt.setMin(src.getMin());
        if (src.hasMax())
            tgt.setMax(src.getMax());
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.MessageDefinition.MessageDefinitionFocusComponent convertMessageDefinitionFocusComponent(org.hl7.fhir.r4.model.MessageDefinition.MessageDefinitionFocusComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.MessageDefinition.MessageDefinitionFocusComponent tgt = new org.hl7.fhir.dstu3.model.MessageDefinition.MessageDefinitionFocusComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCode(src.getCode());
        if (src.hasProfile())
            tgt.setProfile(VersionConvertor_30_40.convertCanonicalToReference(src.getProfileElement()));
        if (src.hasMin())
            tgt.setMin(src.getMin());
        if (src.hasMax())
            tgt.setMax(src.getMax());
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
