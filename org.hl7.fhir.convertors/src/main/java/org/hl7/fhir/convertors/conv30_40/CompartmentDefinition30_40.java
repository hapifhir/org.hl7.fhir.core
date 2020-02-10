package org.hl7.fhir.convertors.conv30_40;

import org.hl7.fhir.convertors.VersionConvertor_30_40;
import org.hl7.fhir.dstu3.model.StringType;
import org.hl7.fhir.exceptions.FHIRException;
import java.util.Collections;

public class CompartmentDefinition30_40 {

    public static org.hl7.fhir.dstu3.model.CompartmentDefinition convertCompartmentDefinition(org.hl7.fhir.r4.model.CompartmentDefinition src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.CompartmentDefinition tgt = new org.hl7.fhir.dstu3.model.CompartmentDefinition();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        if (src.hasUrlElement())
            tgt.setUrlElement((org.hl7.fhir.dstu3.model.UriType) VersionConvertor_30_40.convertType(src.getUrlElement()));
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_40.convertType(src.getNameElement()));
        if (src.hasTitleElement())
            tgt.setTitleElement((StringType) VersionConvertor_30_40.convertType(src.getTitleElement()));
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
        if (src.hasPurposeElement())
            tgt.setPurposeElement((org.hl7.fhir.dstu3.model.MarkdownType) VersionConvertor_30_40.convertType(src.getPurposeElement()));
        if (src.hasUseContext()) {
            for (org.hl7.fhir.r4.model.UsageContext t : src.getUseContext()) tgt.addUseContext(VersionConvertor_30_40.convertUsageContext(t));
        }
        if (src.hasJurisdiction()) {
            for (org.hl7.fhir.r4.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        if (src.hasCode())
            tgt.setCode(convertCompartmentType(src.getCode()));
        if (src.hasSearchElement())
            tgt.setSearchElement((org.hl7.fhir.dstu3.model.BooleanType) VersionConvertor_30_40.convertType(src.getSearchElement()));
        if (src.hasResource()) {
            for (org.hl7.fhir.r4.model.CompartmentDefinition.CompartmentDefinitionResourceComponent t : src.getResource()) tgt.addResource(convertCompartmentDefinitionResourceComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.CompartmentDefinition convertCompartmentDefinition(org.hl7.fhir.dstu3.model.CompartmentDefinition src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.CompartmentDefinition tgt = new org.hl7.fhir.r4.model.CompartmentDefinition();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        if (src.hasUrlElement())
            tgt.setUrlElement((org.hl7.fhir.r4.model.UriType) VersionConvertor_30_40.convertType(src.getUrlElement()));
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
        if (src.hasPurposeElement())
            tgt.setPurposeElement((org.hl7.fhir.r4.model.MarkdownType) VersionConvertor_30_40.convertType(src.getPurposeElement()));
        if (src.hasUseContext()) {
            for (org.hl7.fhir.dstu3.model.UsageContext t : src.getUseContext()) tgt.addUseContext(VersionConvertor_30_40.convertUsageContext(t));
        }
        if (src.hasJurisdiction()) {
            for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getJurisdiction()) tgt.addJurisdiction(VersionConvertor_30_40.convertCodeableConcept(t));
        }
        if (src.hasCode())
            tgt.setCode(convertCompartmentType(src.getCode()));
        if (src.hasSearchElement())
            tgt.setSearchElement((org.hl7.fhir.r4.model.BooleanType) VersionConvertor_30_40.convertType(src.getSearchElement()));
        if (src.hasResource()) {
            for (org.hl7.fhir.dstu3.model.CompartmentDefinition.CompartmentDefinitionResourceComponent t : src.getResource()) tgt.addResource(convertCompartmentDefinitionResourceComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.CompartmentDefinition.CompartmentDefinitionResourceComponent convertCompartmentDefinitionResourceComponent(org.hl7.fhir.dstu3.model.CompartmentDefinition.CompartmentDefinitionResourceComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.CompartmentDefinition.CompartmentDefinitionResourceComponent tgt = new org.hl7.fhir.r4.model.CompartmentDefinition.CompartmentDefinitionResourceComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasCodeElement())
            tgt.setCodeElement((org.hl7.fhir.r4.model.CodeType) VersionConvertor_30_40.convertType(src.getCodeElement()));
        if (src.hasParam()) {
            for (org.hl7.fhir.dstu3.model.StringType t : src.getParam()) tgt.addParam(t.getValue());
        }
        if (src.hasDocumentationElement())
            tgt.setDocumentationElement((org.hl7.fhir.r4.model.StringType) VersionConvertor_30_40.convertType(src.getDocumentationElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.CompartmentDefinition.CompartmentDefinitionResourceComponent convertCompartmentDefinitionResourceComponent(org.hl7.fhir.r4.model.CompartmentDefinition.CompartmentDefinitionResourceComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.CompartmentDefinition.CompartmentDefinitionResourceComponent tgt = new org.hl7.fhir.dstu3.model.CompartmentDefinition.CompartmentDefinitionResourceComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasCodeElement())
            tgt.setCodeElement((org.hl7.fhir.dstu3.model.CodeType) VersionConvertor_30_40.convertType(src.getCodeElement()));
        if (src.hasParam()) {
            for (org.hl7.fhir.r4.model.StringType t : src.getParam()) tgt.addParam(t.getValue());
        }
        if (src.hasDocumentationElement())
            tgt.setDocumentationElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_30_40.convertType(src.getDocumentationElement()));
        return tgt;
    }

    static public org.hl7.fhir.r4.model.CompartmentDefinition.CompartmentType convertCompartmentType(org.hl7.fhir.dstu3.model.CompartmentDefinition.CompartmentType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case PATIENT:
                return org.hl7.fhir.r4.model.CompartmentDefinition.CompartmentType.PATIENT;
            case ENCOUNTER:
                return org.hl7.fhir.r4.model.CompartmentDefinition.CompartmentType.ENCOUNTER;
            case RELATEDPERSON:
                return org.hl7.fhir.r4.model.CompartmentDefinition.CompartmentType.RELATEDPERSON;
            case PRACTITIONER:
                return org.hl7.fhir.r4.model.CompartmentDefinition.CompartmentType.PRACTITIONER;
            case DEVICE:
                return org.hl7.fhir.r4.model.CompartmentDefinition.CompartmentType.DEVICE;
            default:
                return org.hl7.fhir.r4.model.CompartmentDefinition.CompartmentType.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.CompartmentDefinition.CompartmentType convertCompartmentType(org.hl7.fhir.r4.model.CompartmentDefinition.CompartmentType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case PATIENT:
                return org.hl7.fhir.dstu3.model.CompartmentDefinition.CompartmentType.PATIENT;
            case ENCOUNTER:
                return org.hl7.fhir.dstu3.model.CompartmentDefinition.CompartmentType.ENCOUNTER;
            case RELATEDPERSON:
                return org.hl7.fhir.dstu3.model.CompartmentDefinition.CompartmentType.RELATEDPERSON;
            case PRACTITIONER:
                return org.hl7.fhir.dstu3.model.CompartmentDefinition.CompartmentType.PRACTITIONER;
            case DEVICE:
                return org.hl7.fhir.dstu3.model.CompartmentDefinition.CompartmentType.DEVICE;
            default:
                return org.hl7.fhir.dstu3.model.CompartmentDefinition.CompartmentType.NULL;
        }
    }
}
