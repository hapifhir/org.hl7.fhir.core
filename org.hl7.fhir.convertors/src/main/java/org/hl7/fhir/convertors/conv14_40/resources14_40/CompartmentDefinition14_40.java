package org.hl7.fhir.convertors.conv14_40.resources14_40;

import org.hl7.fhir.convertors.conv14_40.VersionConvertor_14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.Element14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.complextypes14_40.ContactPoint14_40;
import org.hl7.fhir.convertors.conv14_40.datatypes14_40.primitivetypes14_40.*;
import org.hl7.fhir.exceptions.FHIRException;

public class CompartmentDefinition14_40 {

    public static org.hl7.fhir.r4.model.CompartmentDefinition convertCompartmentDefinition(org.hl7.fhir.dstu2016may.model.CompartmentDefinition src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.CompartmentDefinition tgt = new org.hl7.fhir.r4.model.CompartmentDefinition();
        VersionConvertor_14_40.copyDomainResource(src, tgt);
        if (src.hasUrlElement())
            tgt.setUrlElement(Uri14_40.convertUri(src.getUrlElement()));
        if (src.hasNameElement())
            tgt.setNameElement(String14_40.convertString(src.getNameElement()));
        if (src.hasStatus())
            tgt.setStatusElement(Enumerations14_40.convertConformanceResourceStatus(src.getStatusElement()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(Boolean14_40.convertBoolean(src.getExperimentalElement()));
        if (src.hasPublisher())
            tgt.setPublisherElement(String14_40.convertString(src.getPublisherElement()));
        for (org.hl7.fhir.dstu2016may.model.CompartmentDefinition.CompartmentDefinitionContactComponent t : src.getContact()) tgt.addContact(convertCompartmentDefinitionContactComponent(t));
        if (src.hasDate())
            tgt.setDateElement(DateTime14_40.convertDateTime(src.getDateElement()));
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        if (src.hasRequirements())
            tgt.setPurpose(src.getRequirements());
        if (src.hasCode())
            tgt.setCodeElement(convertCompartmentType(src.getCodeElement()));
        if (src.hasSearchElement())
            tgt.setSearchElement(Boolean14_40.convertBoolean(src.getSearchElement()));
        for (org.hl7.fhir.dstu2016may.model.CompartmentDefinition.CompartmentDefinitionResourceComponent t : src.getResource()) tgt.addResource(convertCompartmentDefinitionResourceComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.CompartmentDefinition convertCompartmentDefinition(org.hl7.fhir.r4.model.CompartmentDefinition src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.CompartmentDefinition tgt = new org.hl7.fhir.dstu2016may.model.CompartmentDefinition();
        VersionConvertor_14_40.copyDomainResource(src, tgt);
        if (src.hasUrlElement())
            tgt.setUrlElement(Uri14_40.convertUri(src.getUrlElement()));
        if (src.hasNameElement())
            tgt.setNameElement(String14_40.convertString(src.getNameElement()));
        if (src.hasStatus())
            tgt.setStatusElement(Enumerations14_40.convertConformanceResourceStatus(src.getStatusElement()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(Boolean14_40.convertBoolean(src.getExperimentalElement()));
        if (src.hasPublisher())
            tgt.setPublisherElement(String14_40.convertString(src.getPublisherElement()));
        for (org.hl7.fhir.r4.model.ContactDetail t : src.getContact()) tgt.addContact(convertCompartmentDefinitionContactComponent(t));
        if (src.hasDate())
            tgt.setDateElement(DateTime14_40.convertDateTime(src.getDateElement()));
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        if (src.hasPurpose())
            tgt.setRequirements(src.getPurpose());
        if (src.hasCode())
            tgt.setCodeElement(convertCompartmentType(src.getCodeElement()));
        if (src.hasSearchElement())
            tgt.setSearchElement(Boolean14_40.convertBoolean(src.getSearchElement()));
        for (org.hl7.fhir.r4.model.CompartmentDefinition.CompartmentDefinitionResourceComponent t : src.getResource()) tgt.addResource(convertCompartmentDefinitionResourceComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ContactDetail convertCompartmentDefinitionContactComponent(org.hl7.fhir.dstu2016may.model.CompartmentDefinition.CompartmentDefinitionContactComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.ContactDetail tgt = new org.hl7.fhir.r4.model.ContactDetail();
        Element14_40.copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(String14_40.convertString(src.getNameElement()));
        for (org.hl7.fhir.dstu2016may.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(ContactPoint14_40.convertContactPoint(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.CompartmentDefinition.CompartmentDefinitionContactComponent convertCompartmentDefinitionContactComponent(org.hl7.fhir.r4.model.ContactDetail src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.CompartmentDefinition.CompartmentDefinitionContactComponent tgt = new org.hl7.fhir.dstu2016may.model.CompartmentDefinition.CompartmentDefinitionContactComponent();
        Element14_40.copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(String14_40.convertString(src.getNameElement()));
        for (org.hl7.fhir.r4.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(ContactPoint14_40.convertContactPoint(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.CompartmentDefinition.CompartmentDefinitionResourceComponent convertCompartmentDefinitionResourceComponent(org.hl7.fhir.dstu2016may.model.CompartmentDefinition.CompartmentDefinitionResourceComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.CompartmentDefinition.CompartmentDefinitionResourceComponent tgt = new org.hl7.fhir.r4.model.CompartmentDefinition.CompartmentDefinitionResourceComponent();
        Element14_40.copyElement(src, tgt);
        if (src.hasCodeElement())
            tgt.setCodeElement(Code14_40.convertCode(src.getCodeElement()));
        for (org.hl7.fhir.dstu2016may.model.StringType t : src.getParam()) tgt.addParam(t.getValue());
        if (src.hasDocumentation())
            tgt.setDocumentationElement(String14_40.convertString(src.getDocumentationElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.CompartmentDefinition.CompartmentDefinitionResourceComponent convertCompartmentDefinitionResourceComponent(org.hl7.fhir.r4.model.CompartmentDefinition.CompartmentDefinitionResourceComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.CompartmentDefinition.CompartmentDefinitionResourceComponent tgt = new org.hl7.fhir.dstu2016may.model.CompartmentDefinition.CompartmentDefinitionResourceComponent();
        Element14_40.copyElement(src, tgt);
        if (src.hasCodeElement())
            tgt.setCodeElement(Code14_40.convertCode(src.getCodeElement()));
        for (org.hl7.fhir.r4.model.StringType t : src.getParam()) tgt.addParam(t.getValue());
        if (src.hasDocumentation())
            tgt.setDocumentationElement(String14_40.convertString(src.getDocumentationElement()));
        return tgt;
    }

    static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.CompartmentDefinition.CompartmentType> convertCompartmentType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CompartmentDefinition.CompartmentType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.CompartmentDefinition.CompartmentType> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.CompartmentDefinition.CompartmentTypeEnumFactory());
        Element14_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case PATIENT:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.CompartmentDefinition.CompartmentType.PATIENT);
                break;
            case ENCOUNTER:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.CompartmentDefinition.CompartmentType.ENCOUNTER);
                break;
            case RELATEDPERSON:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.CompartmentDefinition.CompartmentType.RELATEDPERSON);
                break;
            case PRACTITIONER:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.CompartmentDefinition.CompartmentType.PRACTITIONER);
                break;
            case DEVICE:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.CompartmentDefinition.CompartmentType.DEVICE);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.CompartmentDefinition.CompartmentType.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CompartmentDefinition.CompartmentType> convertCompartmentType(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.CompartmentDefinition.CompartmentType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.CompartmentDefinition.CompartmentType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.CompartmentDefinition.CompartmentTypeEnumFactory());
        Element14_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case PATIENT:
                tgt.setValue(org.hl7.fhir.r4.model.CompartmentDefinition.CompartmentType.PATIENT);
                break;
            case ENCOUNTER:
                tgt.setValue(org.hl7.fhir.r4.model.CompartmentDefinition.CompartmentType.ENCOUNTER);
                break;
            case RELATEDPERSON:
                tgt.setValue(org.hl7.fhir.r4.model.CompartmentDefinition.CompartmentType.RELATEDPERSON);
                break;
            case PRACTITIONER:
                tgt.setValue(org.hl7.fhir.r4.model.CompartmentDefinition.CompartmentType.PRACTITIONER);
                break;
            case DEVICE:
                tgt.setValue(org.hl7.fhir.r4.model.CompartmentDefinition.CompartmentType.DEVICE);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.CompartmentDefinition.CompartmentType.NULL);
                break;
        }
        return tgt;
    }
}