package org.hl7.fhir.convertors.conv30_50;

import org.hl7.fhir.convertors.VersionConvertor_30_50;
import org.hl7.fhir.exceptions.FHIRException;

public class GraphDefinition30_50 {

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.GraphDefinition.CompartmentCode> convertCompartmentCode(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.CompartmentType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.GraphDefinition.CompartmentCode> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.GraphDefinition.CompartmentCodeEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case PATIENT:
                tgt.setValue(org.hl7.fhir.dstu3.model.GraphDefinition.CompartmentCode.PATIENT);
                break;
            case ENCOUNTER:
                tgt.setValue(org.hl7.fhir.dstu3.model.GraphDefinition.CompartmentCode.ENCOUNTER);
                break;
            case RELATEDPERSON:
                tgt.setValue(org.hl7.fhir.dstu3.model.GraphDefinition.CompartmentCode.RELATEDPERSON);
                break;
            case PRACTITIONER:
                tgt.setValue(org.hl7.fhir.dstu3.model.GraphDefinition.CompartmentCode.PRACTITIONER);
                break;
            case DEVICE:
                tgt.setValue(org.hl7.fhir.dstu3.model.GraphDefinition.CompartmentCode.DEVICE);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.GraphDefinition.CompartmentCode.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.CompartmentType> convertCompartmentCode(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.GraphDefinition.CompartmentCode> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.Enumerations.CompartmentType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.Enumerations.CompartmentTypeEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case PATIENT:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.CompartmentType.PATIENT);
                break;
            case ENCOUNTER:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.CompartmentType.ENCOUNTER);
                break;
            case RELATEDPERSON:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.CompartmentType.RELATEDPERSON);
                break;
            case PRACTITIONER:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.CompartmentType.PRACTITIONER);
                break;
            case DEVICE:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.CompartmentType.DEVICE);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.Enumerations.CompartmentType.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.GraphDefinition.GraphCompartmentRule> convertGraphCompartmentRule(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.GraphDefinition.GraphCompartmentRule> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.GraphDefinition.GraphCompartmentRule> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.GraphDefinition.GraphCompartmentRuleEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case IDENTICAL:
                tgt.setValue(org.hl7.fhir.dstu3.model.GraphDefinition.GraphCompartmentRule.IDENTICAL);
                break;
            case MATCHING:
                tgt.setValue(org.hl7.fhir.dstu3.model.GraphDefinition.GraphCompartmentRule.MATCHING);
                break;
            case DIFFERENT:
                tgt.setValue(org.hl7.fhir.dstu3.model.GraphDefinition.GraphCompartmentRule.DIFFERENT);
                break;
            case CUSTOM:
                tgt.setValue(org.hl7.fhir.dstu3.model.GraphDefinition.GraphCompartmentRule.CUSTOM);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.GraphDefinition.GraphCompartmentRule.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.GraphDefinition.GraphCompartmentRule> convertGraphCompartmentRule(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.GraphDefinition.GraphCompartmentRule> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.GraphDefinition.GraphCompartmentRule> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.GraphDefinition.GraphCompartmentRuleEnumFactory());
        VersionConvertor_30_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case IDENTICAL:
                tgt.setValue(org.hl7.fhir.r5.model.GraphDefinition.GraphCompartmentRule.IDENTICAL);
                break;
            case MATCHING:
                tgt.setValue(org.hl7.fhir.r5.model.GraphDefinition.GraphCompartmentRule.MATCHING);
                break;
            case DIFFERENT:
                tgt.setValue(org.hl7.fhir.r5.model.GraphDefinition.GraphCompartmentRule.DIFFERENT);
                break;
            case CUSTOM:
                tgt.setValue(org.hl7.fhir.r5.model.GraphDefinition.GraphCompartmentRule.CUSTOM);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.GraphDefinition.GraphCompartmentRule.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.GraphDefinition convertGraphDefinition(org.hl7.fhir.dstu3.model.GraphDefinition src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.GraphDefinition tgt = new org.hl7.fhir.r5.model.GraphDefinition();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrlElement(VersionConvertor_30_50.convertUri(src.getUrlElement()));
        if (src.hasVersion())
            tgt.setVersionElement(VersionConvertor_30_50.convertString(src.getVersionElement()));
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_30_50.convertString(src.getNameElement()));
        if (src.hasStatus())
            tgt.setStatusElement(VersionConvertor_30_50.convertPublicationStatus(src.getStatusElement()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(VersionConvertor_30_50.convertBoolean(src.getExperimentalElement()));
        if (src.hasDate())
            tgt.setDateElement(VersionConvertor_30_50.convertDateTime(src.getDateElement()));
        if (src.hasPublisher())
            tgt.setPublisherElement(VersionConvertor_30_50.convertString(src.getPublisherElement()));
        for (org.hl7.fhir.dstu3.model.ContactDetail t : src.getContact()) tgt.addContact(VersionConvertor_30_50.convertContactDetail(t));
        if (src.hasDescription())
            tgt.setDescriptionElement(VersionConvertor_30_50.convertMarkdown(src.getDescriptionElement()));
        for (org.hl7.fhir.dstu3.model.UsageContext t : src.getUseContext()) tgt.addUseContext(VersionConvertor_30_50.convertUsageContext(t));
        for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(VersionConvertor_30_50.convertCodeableConcept(t));
        if (src.hasPurpose())
            tgt.setPurposeElement(VersionConvertor_30_50.convertMarkdown(src.getPurposeElement()));
        if (src.hasStart())
            tgt.setStartElement(VersionConvertor_30_50.convertCode(src.getStartElement()));
        if (src.hasProfile())
            tgt.setProfile(src.getProfile());
        for (org.hl7.fhir.dstu3.model.GraphDefinition.GraphDefinitionLinkComponent t : src.getLink()) tgt.addLink(convertGraphDefinitionLinkComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.GraphDefinition convertGraphDefinition(org.hl7.fhir.r5.model.GraphDefinition src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.GraphDefinition tgt = new org.hl7.fhir.dstu3.model.GraphDefinition();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrlElement(VersionConvertor_30_50.convertUri(src.getUrlElement()));
        if (src.hasVersion())
            tgt.setVersionElement(VersionConvertor_30_50.convertString(src.getVersionElement()));
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_30_50.convertString(src.getNameElement()));
        if (src.hasStatus())
            tgt.setStatusElement(VersionConvertor_30_50.convertPublicationStatus(src.getStatusElement()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(VersionConvertor_30_50.convertBoolean(src.getExperimentalElement()));
        if (src.hasDate())
            tgt.setDateElement(VersionConvertor_30_50.convertDateTime(src.getDateElement()));
        if (src.hasPublisher())
            tgt.setPublisherElement(VersionConvertor_30_50.convertString(src.getPublisherElement()));
        for (org.hl7.fhir.r5.model.ContactDetail t : src.getContact()) tgt.addContact(VersionConvertor_30_50.convertContactDetail(t));
        if (src.hasDescription())
            tgt.setDescriptionElement(VersionConvertor_30_50.convertMarkdown(src.getDescriptionElement()));
        for (org.hl7.fhir.r5.model.UsageContext t : src.getUseContext()) tgt.addUseContext(VersionConvertor_30_50.convertUsageContext(t));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(VersionConvertor_30_50.convertCodeableConcept(t));
        if (src.hasPurpose())
            tgt.setPurposeElement(VersionConvertor_30_50.convertMarkdown(src.getPurposeElement()));
        if (src.hasStart())
            tgt.setStartElement(VersionConvertor_30_50.convertCode(src.getStartElement()));
        if (src.hasProfile())
            tgt.setProfile(src.getProfile());
        for (org.hl7.fhir.r5.model.GraphDefinition.GraphDefinitionLinkComponent t : src.getLink()) tgt.addLink(convertGraphDefinitionLinkComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.GraphDefinition.GraphDefinitionLinkComponent convertGraphDefinitionLinkComponent(org.hl7.fhir.dstu3.model.GraphDefinition.GraphDefinitionLinkComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.GraphDefinition.GraphDefinitionLinkComponent tgt = new org.hl7.fhir.r5.model.GraphDefinition.GraphDefinitionLinkComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasPath())
            tgt.setPathElement(VersionConvertor_30_50.convertString(src.getPathElement()));
        if (src.hasSliceName())
            tgt.setSliceNameElement(VersionConvertor_30_50.convertString(src.getSliceNameElement()));
        if (src.hasMin())
            tgt.setMinElement(VersionConvertor_30_50.convertInteger(src.getMinElement()));
        if (src.hasMax())
            tgt.setMaxElement(VersionConvertor_30_50.convertString(src.getMaxElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(VersionConvertor_30_50.convertString(src.getDescriptionElement()));
        for (org.hl7.fhir.dstu3.model.GraphDefinition.GraphDefinitionLinkTargetComponent t : src.getTarget()) tgt.addTarget(convertGraphDefinitionLinkTargetComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.GraphDefinition.GraphDefinitionLinkComponent convertGraphDefinitionLinkComponent(org.hl7.fhir.r5.model.GraphDefinition.GraphDefinitionLinkComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.GraphDefinition.GraphDefinitionLinkComponent tgt = new org.hl7.fhir.dstu3.model.GraphDefinition.GraphDefinitionLinkComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasPath())
            tgt.setPathElement(VersionConvertor_30_50.convertString(src.getPathElement()));
        if (src.hasSliceName())
            tgt.setSliceNameElement(VersionConvertor_30_50.convertString(src.getSliceNameElement()));
        if (src.hasMin())
            tgt.setMinElement(VersionConvertor_30_50.convertInteger(src.getMinElement()));
        if (src.hasMax())
            tgt.setMaxElement(VersionConvertor_30_50.convertString(src.getMaxElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(VersionConvertor_30_50.convertString(src.getDescriptionElement()));
        for (org.hl7.fhir.r5.model.GraphDefinition.GraphDefinitionLinkTargetComponent t : src.getTarget()) tgt.addTarget(convertGraphDefinitionLinkTargetComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.GraphDefinition.GraphDefinitionLinkTargetCompartmentComponent convertGraphDefinitionLinkTargetCompartmentComponent(org.hl7.fhir.dstu3.model.GraphDefinition.GraphDefinitionLinkTargetCompartmentComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.GraphDefinition.GraphDefinitionLinkTargetCompartmentComponent tgt = new org.hl7.fhir.r5.model.GraphDefinition.GraphDefinitionLinkTargetCompartmentComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCodeElement(convertCompartmentCode(src.getCodeElement()));
        if (src.hasRule())
            tgt.setRuleElement(convertGraphCompartmentRule(src.getRuleElement()));
        if (src.hasExpression())
            tgt.setExpressionElement(VersionConvertor_30_50.convertString(src.getExpressionElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(VersionConvertor_30_50.convertString(src.getDescriptionElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.GraphDefinition.GraphDefinitionLinkTargetCompartmentComponent convertGraphDefinitionLinkTargetCompartmentComponent(org.hl7.fhir.r5.model.GraphDefinition.GraphDefinitionLinkTargetCompartmentComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.GraphDefinition.GraphDefinitionLinkTargetCompartmentComponent tgt = new org.hl7.fhir.dstu3.model.GraphDefinition.GraphDefinitionLinkTargetCompartmentComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCodeElement(convertCompartmentCode(src.getCodeElement()));
        if (src.hasRule())
            tgt.setRuleElement(convertGraphCompartmentRule(src.getRuleElement()));
        if (src.hasExpression())
            tgt.setExpressionElement(VersionConvertor_30_50.convertString(src.getExpressionElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(VersionConvertor_30_50.convertString(src.getDescriptionElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.GraphDefinition.GraphDefinitionLinkTargetComponent convertGraphDefinitionLinkTargetComponent(org.hl7.fhir.r5.model.GraphDefinition.GraphDefinitionLinkTargetComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.GraphDefinition.GraphDefinitionLinkTargetComponent tgt = new org.hl7.fhir.dstu3.model.GraphDefinition.GraphDefinitionLinkTargetComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasType())
            tgt.setTypeElement(VersionConvertor_30_50.convertCode(src.getTypeElement()));
        if (src.hasProfile())
            tgt.setProfile(src.getProfile());
        for (org.hl7.fhir.r5.model.GraphDefinition.GraphDefinitionLinkTargetCompartmentComponent t : src.getCompartment()) tgt.addCompartment(convertGraphDefinitionLinkTargetCompartmentComponent(t));
        for (org.hl7.fhir.r5.model.GraphDefinition.GraphDefinitionLinkComponent t : src.getLink()) tgt.addLink(convertGraphDefinitionLinkComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.GraphDefinition.GraphDefinitionLinkTargetComponent convertGraphDefinitionLinkTargetComponent(org.hl7.fhir.dstu3.model.GraphDefinition.GraphDefinitionLinkTargetComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.GraphDefinition.GraphDefinitionLinkTargetComponent tgt = new org.hl7.fhir.r5.model.GraphDefinition.GraphDefinitionLinkTargetComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasType())
            tgt.setTypeElement(VersionConvertor_30_50.convertCode(src.getTypeElement()));
        if (src.hasProfile())
            tgt.setProfile(src.getProfile());
        for (org.hl7.fhir.dstu3.model.GraphDefinition.GraphDefinitionLinkTargetCompartmentComponent t : src.getCompartment()) tgt.addCompartment(convertGraphDefinitionLinkTargetCompartmentComponent(t));
        for (org.hl7.fhir.dstu3.model.GraphDefinition.GraphDefinitionLinkComponent t : src.getLink()) tgt.addLink(convertGraphDefinitionLinkComponent(t));
        return tgt;
    }
}