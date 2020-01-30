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
            tgt.setUrl(src.getUrl());
        if (src.hasVersion())
            tgt.setVersion(src.getVersion());
        if (src.hasName())
            tgt.setName(src.getName());
        if (src.hasStatus())
            tgt.setStatus(VersionConvertor_30_50.convertPublicationStatus(src.getStatus()));
        if (src.hasExperimental())
            tgt.setExperimental(src.getExperimental());
        if (src.hasDate())
            tgt.setDate(src.getDate());
        if (src.hasPublisher())
            tgt.setPublisher(src.getPublisher());
        if (src.hasContact()) {
            for (org.hl7.fhir.dstu3.model.ContactDetail t : src.getContact()) tgt.addContact(VersionConvertor_30_50.convertContactDetail(t));
        }
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        if (src.hasUseContext()) {
            for (org.hl7.fhir.dstu3.model.UsageContext t : src.getUseContext()) tgt.addUseContext(VersionConvertor_30_50.convertUsageContext(t));
        }
        if (src.hasJurisdiction()) {
            for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(VersionConvertor_30_50.convertCodeableConcept(t));
        }
        if (src.hasPurpose())
            tgt.setPurpose(src.getPurpose());
        if (src.hasStart())
            tgt.setStart(src.getStart());
        if (src.hasProfile())
            tgt.setProfile(src.getProfile());
        if (src.hasLink()) {
            for (org.hl7.fhir.dstu3.model.GraphDefinition.GraphDefinitionLinkComponent t : src.getLink()) tgt.addLink(convertGraphDefinitionLinkComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.GraphDefinition convertGraphDefinition(org.hl7.fhir.r5.model.GraphDefinition src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.GraphDefinition tgt = new org.hl7.fhir.dstu3.model.GraphDefinition();
        VersionConvertor_30_50.copyDomainResource(src, tgt);
        if (src.hasUrl())
            tgt.setUrl(src.getUrl());
        if (src.hasVersion())
            tgt.setVersion(src.getVersion());
        if (src.hasName())
            tgt.setName(src.getName());
        if (src.hasStatus())
            tgt.setStatus(VersionConvertor_30_50.convertPublicationStatus(src.getStatus()));
        if (src.hasExperimental())
            tgt.setExperimental(src.getExperimental());
        if (src.hasDate())
            tgt.setDate(src.getDate());
        if (src.hasPublisher())
            tgt.setPublisher(src.getPublisher());
        if (src.hasContact()) {
            for (org.hl7.fhir.r5.model.ContactDetail t : src.getContact()) tgt.addContact(VersionConvertor_30_50.convertContactDetail(t));
        }
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        if (src.hasUseContext()) {
            for (org.hl7.fhir.r5.model.UsageContext t : src.getUseContext()) tgt.addUseContext(VersionConvertor_30_50.convertUsageContext(t));
        }
        if (src.hasJurisdiction()) {
            for (org.hl7.fhir.r5.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(VersionConvertor_30_50.convertCodeableConcept(t));
        }
        if (src.hasPurpose())
            tgt.setPurpose(src.getPurpose());
        if (src.hasStart())
            tgt.setStart(src.getStart());
        if (src.hasProfile())
            tgt.setProfile(src.getProfile());
        if (src.hasLink()) {
            for (org.hl7.fhir.r5.model.GraphDefinition.GraphDefinitionLinkComponent t : src.getLink()) tgt.addLink(convertGraphDefinitionLinkComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.GraphDefinition.GraphDefinitionLinkComponent convertGraphDefinitionLinkComponent(org.hl7.fhir.dstu3.model.GraphDefinition.GraphDefinitionLinkComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.GraphDefinition.GraphDefinitionLinkComponent tgt = new org.hl7.fhir.r5.model.GraphDefinition.GraphDefinitionLinkComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasPath())
            tgt.setPath(src.getPath());
        if (src.hasSliceName())
            tgt.setSliceName(src.getSliceName());
        if (src.hasMin())
            tgt.setMin(src.getMin());
        if (src.hasMax())
            tgt.setMax(src.getMax());
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        if (src.hasTarget()) {
            for (org.hl7.fhir.dstu3.model.GraphDefinition.GraphDefinitionLinkTargetComponent t : src.getTarget()) tgt.addTarget(convertGraphDefinitionLinkTargetComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.GraphDefinition.GraphDefinitionLinkComponent convertGraphDefinitionLinkComponent(org.hl7.fhir.r5.model.GraphDefinition.GraphDefinitionLinkComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.GraphDefinition.GraphDefinitionLinkComponent tgt = new org.hl7.fhir.dstu3.model.GraphDefinition.GraphDefinitionLinkComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasPath())
            tgt.setPath(src.getPath());
        if (src.hasSliceName())
            tgt.setSliceName(src.getSliceName());
        if (src.hasMin())
            tgt.setMin(src.getMin());
        if (src.hasMax())
            tgt.setMax(src.getMax());
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        if (src.hasTarget()) {
            for (org.hl7.fhir.r5.model.GraphDefinition.GraphDefinitionLinkTargetComponent t : src.getTarget()) tgt.addTarget(convertGraphDefinitionLinkTargetComponent(t));
        }
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
            tgt.setExpression(src.getExpression());
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
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
            tgt.setExpression(src.getExpression());
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.GraphDefinition.GraphDefinitionLinkTargetComponent convertGraphDefinitionLinkTargetComponent(org.hl7.fhir.r5.model.GraphDefinition.GraphDefinitionLinkTargetComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.GraphDefinition.GraphDefinitionLinkTargetComponent tgt = new org.hl7.fhir.dstu3.model.GraphDefinition.GraphDefinitionLinkTargetComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasType())
            tgt.setType(src.getType());
        if (src.hasProfile())
            tgt.setProfile(src.getProfile());
        if (src.hasCompartment()) {
            for (org.hl7.fhir.r5.model.GraphDefinition.GraphDefinitionLinkTargetCompartmentComponent t : src.getCompartment()) tgt.addCompartment(convertGraphDefinitionLinkTargetCompartmentComponent(t));
        }
        if (src.hasLink()) {
            for (org.hl7.fhir.r5.model.GraphDefinition.GraphDefinitionLinkComponent t : src.getLink()) tgt.addLink(convertGraphDefinitionLinkComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.GraphDefinition.GraphDefinitionLinkTargetComponent convertGraphDefinitionLinkTargetComponent(org.hl7.fhir.dstu3.model.GraphDefinition.GraphDefinitionLinkTargetComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.GraphDefinition.GraphDefinitionLinkTargetComponent tgt = new org.hl7.fhir.r5.model.GraphDefinition.GraphDefinitionLinkTargetComponent();
        VersionConvertor_30_50.copyElement(src, tgt);
        if (src.hasType())
            tgt.setType(src.getType());
        if (src.hasProfile())
            tgt.setProfile(src.getProfile());
        if (src.hasCompartment()) {
            for (org.hl7.fhir.dstu3.model.GraphDefinition.GraphDefinitionLinkTargetCompartmentComponent t : src.getCompartment()) tgt.addCompartment(convertGraphDefinitionLinkTargetCompartmentComponent(t));
        }
        if (src.hasLink()) {
            for (org.hl7.fhir.dstu3.model.GraphDefinition.GraphDefinitionLinkComponent t : src.getLink()) tgt.addLink(convertGraphDefinitionLinkComponent(t));
        }
        return tgt;
    }
}
