package org.hl7.fhir.convertors.conv10_50.resources10_50;

import org.hl7.fhir.convertors.conv10_50.VersionConvertor_10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.Element10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.ContactPoint10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.*;
import org.hl7.fhir.dstu2.utils.ToolingExtensions;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CodeType;

public class SearchParameter10_50 {

    public static org.hl7.fhir.dstu2.model.SearchParameter convertSearchParameter(org.hl7.fhir.r5.model.SearchParameter src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.SearchParameter tgt = new org.hl7.fhir.dstu2.model.SearchParameter();
        VersionConvertor_10_50.copyDomainResource(src, tgt);
        if (src.hasUrlElement())
            tgt.setUrlElement(Uri10_50.convertUri(src.getUrlElement()));
        if (src.hasNameElement())
            tgt.setNameElement(String10_50.convertString(src.getNameElement()));
        if (src.hasStatus())
            tgt.setStatusElement(Enumerations10_50.convertConformanceResourceStatus(src.getStatusElement()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(Boolean10_50.convertBoolean(src.getExperimentalElement()));
        if (src.hasDate())
            tgt.setDateElement(DateTime10_50.convertDateTime(src.getDateElement()));
        if (src.hasPublisherElement())
            tgt.setPublisherElement(String10_50.convertString(src.getPublisherElement()));
        for (org.hl7.fhir.r5.model.ContactDetail t : src.getContact()) tgt.addContact(convertSearchParameterContactComponent(t));
        if (src.hasPurpose())
            tgt.setRequirements(src.getPurpose());
        if (src.hasCodeElement())
            tgt.setCodeElement(Code10_50.convertCode(src.getCodeElement()));
        for (CodeType t : src.getBase()) tgt.setBase(t.asStringValue());
        if (src.hasType())
            tgt.setTypeElement(Enumerations10_50.convertSearchParamType(src.getTypeElement()));
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        org.hl7.fhir.dstu2.utils.ToolingExtensions.setStringExtension(tgt, ToolingExtensions.EXT_EXPRESSION, src.getExpression());
        if (src.hasXpathElement())
            tgt.setXpathElement(String10_50.convertString(src.getXpathElement()));
        if (src.hasXpathUsage())
            tgt.setXpathUsageElement(convertXPathUsageType(src.getXpathUsageElement()));
        for (CodeType t : src.getTarget()) tgt.addTarget(t.getValue());
        return tgt;
    }

    public static org.hl7.fhir.r5.model.SearchParameter convertSearchParameter(org.hl7.fhir.dstu2.model.SearchParameter src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.SearchParameter tgt = new org.hl7.fhir.r5.model.SearchParameter();
        VersionConvertor_10_50.copyDomainResource(src, tgt);
        if (src.hasUrlElement())
            tgt.setUrlElement(Uri10_50.convertUri(src.getUrlElement()));
        if (src.hasNameElement())
            tgt.setNameElement(String10_50.convertString(src.getNameElement()));
        if (src.hasStatus())
            tgt.setStatusElement(Enumerations10_50.convertConformanceResourceStatus(src.getStatusElement()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(Boolean10_50.convertBoolean(src.getExperimentalElement()));
        if (src.hasDate())
            tgt.setDateElement(DateTime10_50.convertDateTime(src.getDateElement()));
        if (src.hasPublisherElement())
            tgt.setPublisherElement(String10_50.convertString(src.getPublisherElement()));
        for (org.hl7.fhir.dstu2.model.SearchParameter.SearchParameterContactComponent t : src.getContact()) tgt.addContact(convertSearchParameterContactComponent(t));
        if (src.hasRequirements())
            tgt.setPurpose(src.getRequirements());
        if (src.hasCodeElement())
            tgt.setCodeElement(Code10_50.convertCode(src.getCodeElement()));
        tgt.addBase(src.getBase());
        if (src.hasType())
            tgt.setTypeElement(Enumerations10_50.convertSearchParamType(src.getTypeElement()));
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        tgt.setExpression(ToolingExtensions.readStringExtension(src, ToolingExtensions.EXT_EXPRESSION));
        if (src.hasXpathElement())
            tgt.setXpathElement(String10_50.convertString(src.getXpathElement()));
        if (src.hasXpathUsage())
            tgt.setXpathUsageElement(convertXPathUsageType(src.getXpathUsageElement()));
        for (org.hl7.fhir.dstu2.model.CodeType t : src.getTarget()) tgt.addTarget(t.getValue());
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.SearchParameter.SearchParameterContactComponent convertSearchParameterContactComponent(org.hl7.fhir.r5.model.ContactDetail src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.SearchParameter.SearchParameterContactComponent tgt = new org.hl7.fhir.dstu2.model.SearchParameter.SearchParameterContactComponent();
        Element10_50.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement(String10_50.convertString(src.getNameElement()));
        for (org.hl7.fhir.r5.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(ContactPoint10_50.convertContactPoint(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ContactDetail convertSearchParameterContactComponent(org.hl7.fhir.dstu2.model.SearchParameter.SearchParameterContactComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.ContactDetail tgt = new org.hl7.fhir.r5.model.ContactDetail();
        Element10_50.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement(String10_50.convertString(src.getNameElement()));
        for (org.hl7.fhir.dstu2.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(ContactPoint10_50.convertContactPoint(t));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.SearchParameter.XPathUsageType> convertXPathUsageType(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.SearchParameter.XPathUsageType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.SearchParameter.XPathUsageType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.SearchParameter.XPathUsageTypeEnumFactory());
        Element10_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case NORMAL:
                tgt.setValue(org.hl7.fhir.r5.model.SearchParameter.XPathUsageType.NORMAL);
                break;
            case PHONETIC:
                tgt.setValue(org.hl7.fhir.r5.model.SearchParameter.XPathUsageType.PHONETIC);
                break;
            case NEARBY:
                tgt.setValue(org.hl7.fhir.r5.model.SearchParameter.XPathUsageType.NEARBY);
                break;
            case DISTANCE:
                tgt.setValue(org.hl7.fhir.r5.model.SearchParameter.XPathUsageType.DISTANCE);
                break;
            case OTHER:
                tgt.setValue(org.hl7.fhir.r5.model.SearchParameter.XPathUsageType.OTHER);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.SearchParameter.XPathUsageType.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.SearchParameter.XPathUsageType> convertXPathUsageType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.SearchParameter.XPathUsageType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.SearchParameter.XPathUsageType> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.SearchParameter.XPathUsageTypeEnumFactory());
        Element10_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case NORMAL:
                tgt.setValue(org.hl7.fhir.dstu2.model.SearchParameter.XPathUsageType.NORMAL);
                break;
            case PHONETIC:
                tgt.setValue(org.hl7.fhir.dstu2.model.SearchParameter.XPathUsageType.PHONETIC);
                break;
            case NEARBY:
                tgt.setValue(org.hl7.fhir.dstu2.model.SearchParameter.XPathUsageType.NEARBY);
                break;
            case DISTANCE:
                tgt.setValue(org.hl7.fhir.dstu2.model.SearchParameter.XPathUsageType.DISTANCE);
                break;
            case OTHER:
                tgt.setValue(org.hl7.fhir.dstu2.model.SearchParameter.XPathUsageType.OTHER);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2.model.SearchParameter.XPathUsageType.NULL);
                break;
        }
        return tgt;
    }
}