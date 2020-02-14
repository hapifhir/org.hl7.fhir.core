package org.hl7.fhir.convertors.conv30_50;

import org.hl7.fhir.convertors.VersionConvertor_30_50;
import org.hl7.fhir.exceptions.FHIRException;

public class GraphDefinition30_50 {

    static public org.hl7.fhir.dstu3.model.GraphDefinition.CompartmentCode convertCompartmentCode(org.hl7.fhir.r5.model.Enumerations.CompartmentType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case PATIENT:
                return org.hl7.fhir.dstu3.model.GraphDefinition.CompartmentCode.PATIENT;
            case ENCOUNTER:
                return org.hl7.fhir.dstu3.model.GraphDefinition.CompartmentCode.ENCOUNTER;
            case RELATEDPERSON:
                return org.hl7.fhir.dstu3.model.GraphDefinition.CompartmentCode.RELATEDPERSON;
            case PRACTITIONER:
                return org.hl7.fhir.dstu3.model.GraphDefinition.CompartmentCode.PRACTITIONER;
            case DEVICE:
                return org.hl7.fhir.dstu3.model.GraphDefinition.CompartmentCode.DEVICE;
            default:
                return org.hl7.fhir.dstu3.model.GraphDefinition.CompartmentCode.NULL;
        }
    }

    static public org.hl7.fhir.r5.model.Enumerations.CompartmentType convertCompartmentCode(org.hl7.fhir.dstu3.model.GraphDefinition.CompartmentCode src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case PATIENT:
                return org.hl7.fhir.r5.model.Enumerations.CompartmentType.PATIENT;
            case ENCOUNTER:
                return org.hl7.fhir.r5.model.Enumerations.CompartmentType.ENCOUNTER;
            case RELATEDPERSON:
                return org.hl7.fhir.r5.model.Enumerations.CompartmentType.RELATEDPERSON;
            case PRACTITIONER:
                return org.hl7.fhir.r5.model.Enumerations.CompartmentType.PRACTITIONER;
            case DEVICE:
                return org.hl7.fhir.r5.model.Enumerations.CompartmentType.DEVICE;
            default:
                return org.hl7.fhir.r5.model.Enumerations.CompartmentType.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.GraphDefinition.GraphCompartmentRule convertGraphCompartmentRule(org.hl7.fhir.r5.model.GraphDefinition.GraphCompartmentRule src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case IDENTICAL:
                return org.hl7.fhir.dstu3.model.GraphDefinition.GraphCompartmentRule.IDENTICAL;
            case MATCHING:
                return org.hl7.fhir.dstu3.model.GraphDefinition.GraphCompartmentRule.MATCHING;
            case DIFFERENT:
                return org.hl7.fhir.dstu3.model.GraphDefinition.GraphCompartmentRule.DIFFERENT;
            case CUSTOM:
                return org.hl7.fhir.dstu3.model.GraphDefinition.GraphCompartmentRule.CUSTOM;
            default:
                return org.hl7.fhir.dstu3.model.GraphDefinition.GraphCompartmentRule.NULL;
        }
    }

    static public org.hl7.fhir.r5.model.GraphDefinition.GraphCompartmentRule convertGraphCompartmentRule(org.hl7.fhir.dstu3.model.GraphDefinition.GraphCompartmentRule src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case IDENTICAL:
                return org.hl7.fhir.r5.model.GraphDefinition.GraphCompartmentRule.IDENTICAL;
            case MATCHING:
                return org.hl7.fhir.r5.model.GraphDefinition.GraphCompartmentRule.MATCHING;
            case DIFFERENT:
                return org.hl7.fhir.r5.model.GraphDefinition.GraphCompartmentRule.DIFFERENT;
            case CUSTOM:
                return org.hl7.fhir.r5.model.GraphDefinition.GraphCompartmentRule.CUSTOM;
            default:
                return org.hl7.fhir.r5.model.GraphDefinition.GraphCompartmentRule.NULL;
        }
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
            tgt.setStatus(VersionConvertor_30_50.convertPublicationStatus(src.getStatus()));
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
            tgt.setStatus(VersionConvertor_30_50.convertPublicationStatus(src.getStatus()));
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
            tgt.setCode(convertCompartmentCode(src.getCode()));
        if (src.hasRule())
            tgt.setRule(convertGraphCompartmentRule(src.getRule()));
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
            tgt.setCode(convertCompartmentCode(src.getCode()));
        if (src.hasRule())
            tgt.setRule(convertGraphCompartmentRule(src.getRule()));
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
