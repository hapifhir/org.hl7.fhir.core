package org.hl7.fhir.convertors.conv30_40;

import org.hl7.fhir.convertors.VersionConvertor_30_40;
import org.hl7.fhir.exceptions.FHIRException;
import java.util.Collections;

public class GraphDefinition30_40 {

    static public org.hl7.fhir.r4.model.GraphDefinition.CompartmentCode convertCompartmentCode(org.hl7.fhir.dstu3.model.GraphDefinition.CompartmentCode src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case PATIENT:
                return org.hl7.fhir.r4.model.GraphDefinition.CompartmentCode.PATIENT;
            case ENCOUNTER:
                return org.hl7.fhir.r4.model.GraphDefinition.CompartmentCode.ENCOUNTER;
            case RELATEDPERSON:
                return org.hl7.fhir.r4.model.GraphDefinition.CompartmentCode.RELATEDPERSON;
            case PRACTITIONER:
                return org.hl7.fhir.r4.model.GraphDefinition.CompartmentCode.PRACTITIONER;
            case DEVICE:
                return org.hl7.fhir.r4.model.GraphDefinition.CompartmentCode.DEVICE;
            default:
                return org.hl7.fhir.r4.model.GraphDefinition.CompartmentCode.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.GraphDefinition.CompartmentCode convertCompartmentCode(org.hl7.fhir.r4.model.GraphDefinition.CompartmentCode src) throws FHIRException {
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

    static public org.hl7.fhir.r4.model.GraphDefinition.GraphCompartmentRule convertGraphCompartmentRule(org.hl7.fhir.dstu3.model.GraphDefinition.GraphCompartmentRule src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case IDENTICAL:
                return org.hl7.fhir.r4.model.GraphDefinition.GraphCompartmentRule.IDENTICAL;
            case MATCHING:
                return org.hl7.fhir.r4.model.GraphDefinition.GraphCompartmentRule.MATCHING;
            case DIFFERENT:
                return org.hl7.fhir.r4.model.GraphDefinition.GraphCompartmentRule.DIFFERENT;
            case CUSTOM:
                return org.hl7.fhir.r4.model.GraphDefinition.GraphCompartmentRule.CUSTOM;
            default:
                return org.hl7.fhir.r4.model.GraphDefinition.GraphCompartmentRule.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.GraphDefinition.GraphCompartmentRule convertGraphCompartmentRule(org.hl7.fhir.r4.model.GraphDefinition.GraphCompartmentRule src) throws FHIRException {
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

    public static org.hl7.fhir.dstu3.model.GraphDefinition convertGraphDefinition(org.hl7.fhir.r4.model.GraphDefinition src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.GraphDefinition tgt = new org.hl7.fhir.dstu3.model.GraphDefinition();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        if (src.hasUrlElement())
            tgt.setUrlElement((org.hl7.fhir.dstu3.model.UriType) VersionConvertor_30_40.convertType(src.getUrlElement()));
        if (src.hasVersionElement())
            tgt.setVersionElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_40.convertType(src.getVersionElement()));
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_40.convertType(src.getNameElement()));
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
        if (src.hasStart())
            tgt.setStartElement(VersionConvertor_30_40.convertCode(src.getStartElement()));
        if (src.hasProfileElement())
            tgt.setProfileElement((org.hl7.fhir.dstu3.model.UriType) VersionConvertor_30_40.convertType(src.getProfileElement()));
        if (src.hasLink()) {
            for (org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkComponent t : src.getLink()) tgt.addLink(convertGraphDefinitionLinkComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.GraphDefinition convertGraphDefinition(org.hl7.fhir.dstu3.model.GraphDefinition src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.GraphDefinition tgt = new org.hl7.fhir.r4.model.GraphDefinition();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        if (src.hasUrlElement())
            tgt.setUrlElement((org.hl7.fhir.r4.model.UriType) VersionConvertor_30_40.convertType(src.getUrlElement()));
        if (src.hasVersionElement())
            tgt.setVersionElement((org.hl7.fhir.r4.model.StringType) VersionConvertor_30_40.convertType(src.getVersionElement()));
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.r4.model.StringType) VersionConvertor_30_40.convertType(src.getNameElement()));
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
        if (src.hasStart())
            tgt.setStartElement(VersionConvertor_30_40.convertCode(src.getStartElement()));
        if (src.hasProfileElement())
            tgt.setProfileElement((org.hl7.fhir.r4.model.CanonicalType) VersionConvertor_30_40.convertType(src.getProfileElement()));
        if (src.hasLink()) {
            for (org.hl7.fhir.dstu3.model.GraphDefinition.GraphDefinitionLinkComponent t : src.getLink()) tgt.addLink(convertGraphDefinitionLinkComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkComponent convertGraphDefinitionLinkComponent(org.hl7.fhir.dstu3.model.GraphDefinition.GraphDefinitionLinkComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkComponent tgt = new org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasPathElement())
            tgt.setPathElement((org.hl7.fhir.r4.model.StringType) VersionConvertor_30_40.convertType(src.getPathElement()));
        if (src.hasSliceNameElement())
            tgt.setSliceNameElement((org.hl7.fhir.r4.model.StringType) VersionConvertor_30_40.convertType(src.getSliceNameElement()));
        if (src.hasMinElement())
            tgt.setMinElement((org.hl7.fhir.r4.model.IntegerType) VersionConvertor_30_40.convertType(src.getMinElement()));
        if (src.hasMaxElement())
            tgt.setMaxElement((org.hl7.fhir.r4.model.StringType) VersionConvertor_30_40.convertType(src.getMaxElement()));
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.r4.model.StringType) VersionConvertor_30_40.convertType(src.getDescriptionElement()));
        if (src.hasTarget()) {
            for (org.hl7.fhir.dstu3.model.GraphDefinition.GraphDefinitionLinkTargetComponent t : src.getTarget()) tgt.addTarget(convertGraphDefinitionLinkTargetComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.GraphDefinition.GraphDefinitionLinkComponent convertGraphDefinitionLinkComponent(org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.GraphDefinition.GraphDefinitionLinkComponent tgt = new org.hl7.fhir.dstu3.model.GraphDefinition.GraphDefinitionLinkComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasPathElement())
            tgt.setPathElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_40.convertType(src.getPathElement()));
        if (src.hasSliceNameElement())
            tgt.setSliceNameElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_40.convertType(src.getSliceNameElement()));
        if (src.hasMinElement())
            tgt.setMinElement((org.hl7.fhir.dstu3.model.IntegerType) VersionConvertor_30_40.convertType(src.getMinElement()));
        if (src.hasMaxElement())
            tgt.setMaxElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_40.convertType(src.getMaxElement()));
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_40.convertType(src.getDescriptionElement()));
        if (src.hasTarget()) {
            for (org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkTargetComponent t : src.getTarget()) tgt.addTarget(convertGraphDefinitionLinkTargetComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkTargetCompartmentComponent convertGraphDefinitionLinkTargetCompartmentComponent(org.hl7.fhir.dstu3.model.GraphDefinition.GraphDefinitionLinkTargetCompartmentComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkTargetCompartmentComponent tgt = new org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkTargetCompartmentComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCode(convertCompartmentCode(src.getCode()));
        if (src.hasRule())
            tgt.setRule(convertGraphCompartmentRule(src.getRule()));
        if (src.hasExpressionElement())
            tgt.setExpressionElement((org.hl7.fhir.r4.model.StringType) VersionConvertor_30_40.convertType(src.getExpressionElement()));
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.r4.model.StringType) VersionConvertor_30_40.convertType(src.getDescriptionElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.GraphDefinition.GraphDefinitionLinkTargetCompartmentComponent convertGraphDefinitionLinkTargetCompartmentComponent(org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkTargetCompartmentComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.GraphDefinition.GraphDefinitionLinkTargetCompartmentComponent tgt = new org.hl7.fhir.dstu3.model.GraphDefinition.GraphDefinitionLinkTargetCompartmentComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasCode())
            tgt.setCode(convertCompartmentCode(src.getCode()));
        if (src.hasRule())
            tgt.setRule(convertGraphCompartmentRule(src.getRule()));
        if (src.hasExpressionElement())
            tgt.setExpressionElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_40.convertType(src.getExpressionElement()));
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_40.convertType(src.getDescriptionElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.GraphDefinition.GraphDefinitionLinkTargetComponent convertGraphDefinitionLinkTargetComponent(org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkTargetComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.GraphDefinition.GraphDefinitionLinkTargetComponent tgt = new org.hl7.fhir.dstu3.model.GraphDefinition.GraphDefinitionLinkTargetComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasTypeElement())
            tgt.setTypeElement((org.hl7.fhir.dstu3.model.CodeType) VersionConvertor_30_40.convertType(src.getTypeElement()));
        if (src.hasProfileElement())
            tgt.setProfileElement((org.hl7.fhir.dstu3.model.UriType) VersionConvertor_30_40.convertType(src.getProfileElement()));
        if (src.hasCompartment()) {
            for (org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkTargetCompartmentComponent t : src.getCompartment()) tgt.addCompartment(convertGraphDefinitionLinkTargetCompartmentComponent(t));
        }
        if (src.hasLink()) {
            for (org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkComponent t : src.getLink()) tgt.addLink(convertGraphDefinitionLinkComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkTargetComponent convertGraphDefinitionLinkTargetComponent(org.hl7.fhir.dstu3.model.GraphDefinition.GraphDefinitionLinkTargetComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkTargetComponent tgt = new org.hl7.fhir.r4.model.GraphDefinition.GraphDefinitionLinkTargetComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasTypeElement())
            tgt.setTypeElement((org.hl7.fhir.r4.model.CodeType) VersionConvertor_30_40.convertType(src.getTypeElement()));
        if (src.hasProfileElement())
            tgt.setProfileElement((org.hl7.fhir.r4.model.CanonicalType) VersionConvertor_30_40.convertType(src.getProfileElement()));
        if (src.hasCompartment()) {
            for (org.hl7.fhir.dstu3.model.GraphDefinition.GraphDefinitionLinkTargetCompartmentComponent t : src.getCompartment()) tgt.addCompartment(convertGraphDefinitionLinkTargetCompartmentComponent(t));
        }
        if (src.hasLink()) {
            for (org.hl7.fhir.dstu3.model.GraphDefinition.GraphDefinitionLinkComponent t : src.getLink()) tgt.addLink(convertGraphDefinitionLinkComponent(t));
        }
        return tgt;
    }
}
