package org.hl7.fhir.convertors.conv10_30;

import org.hl7.fhir.convertors.VersionConvertor_10_30;
import org.hl7.fhir.dstu2.utils.ToolingExtensions;
import org.hl7.fhir.exceptions.FHIRException;

public class SearchParameter10_30 {

    public static org.hl7.fhir.dstu2.model.SearchParameter convertSearchParameter(org.hl7.fhir.dstu3.model.SearchParameter src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.SearchParameter tgt = new org.hl7.fhir.dstu2.model.SearchParameter();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        tgt.setUrl(src.getUrl());
        tgt.setName(src.getName());
        tgt.setStatus(VersionConvertor_10_30.convertConformanceResourceStatus(src.getStatus()));
        if (src.hasExperimental())
            tgt.setExperimental(src.getExperimental());
        if (src.hasDate())
            tgt.setDate(src.getDate());
        tgt.setPublisher(src.getPublisher());
        for (org.hl7.fhir.dstu3.model.ContactDetail t : src.getContact()) tgt.addContact(convertSearchParameterContactComponent(t));
        tgt.setRequirements(src.getPurpose());
        tgt.setCode(src.getCode());
        for (org.hl7.fhir.dstu3.model.CodeType t : src.getBase()) tgt.setBase(t.asStringValue());
        tgt.setType(VersionConvertor_10_30.convertSearchParamType(src.getType()));
        tgt.setDescription(src.getDescription());
        org.hl7.fhir.dstu2.utils.ToolingExtensions.setStringExtension(tgt, ToolingExtensions.EXT_EXPRESSION, src.getExpression());
        tgt.setXpath(src.getXpath());
        tgt.setXpathUsage(convertXPathUsageType(src.getXpathUsage()));
        for (org.hl7.fhir.dstu3.model.CodeType t : src.getTarget()) tgt.addTarget(t.getValue());
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.SearchParameter convertSearchParameter(org.hl7.fhir.dstu2.model.SearchParameter src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.SearchParameter tgt = new org.hl7.fhir.dstu3.model.SearchParameter();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        tgt.setUrl(src.getUrl());
        tgt.setName(src.getName());
        tgt.setStatus(VersionConvertor_10_30.convertConformanceResourceStatus(src.getStatus()));
        if (src.hasExperimental())
            tgt.setExperimental(src.getExperimental());
        if (src.hasDate())
            tgt.setDate(src.getDate());
        tgt.setPublisher(src.getPublisher());
        for (org.hl7.fhir.dstu2.model.SearchParameter.SearchParameterContactComponent t : src.getContact()) tgt.addContact(convertSearchParameterContactComponent(t));
        tgt.setPurpose(src.getRequirements());
        tgt.setCode(src.getCode());
        tgt.addBase(src.getBase());
        tgt.setType(VersionConvertor_10_30.convertSearchParamType(src.getType()));
        tgt.setDescription(src.getDescription());
        tgt.setExpression(ToolingExtensions.readStringExtension(src, ToolingExtensions.EXT_EXPRESSION));
        tgt.setXpath(src.getXpath());
        tgt.setXpathUsage(convertXPathUsageType(src.getXpathUsage()));
        for (org.hl7.fhir.dstu2.model.CodeType t : src.getTarget()) tgt.addTarget(t.getValue());
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.SearchParameter.SearchParameterContactComponent convertSearchParameterContactComponent(org.hl7.fhir.dstu3.model.ContactDetail src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.SearchParameter.SearchParameterContactComponent tgt = new org.hl7.fhir.dstu2.model.SearchParameter.SearchParameterContactComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        tgt.setName(src.getName());
        for (org.hl7.fhir.dstu3.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_10_30.convertContactPoint(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ContactDetail convertSearchParameterContactComponent(org.hl7.fhir.dstu2.model.SearchParameter.SearchParameterContactComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ContactDetail tgt = new org.hl7.fhir.dstu3.model.ContactDetail();
        VersionConvertor_10_30.copyElement(src, tgt);
        tgt.setName(src.getName());
        for (org.hl7.fhir.dstu2.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_10_30.convertContactPoint(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.SearchParameter.XPathUsageType convertXPathUsageType(org.hl7.fhir.dstu3.model.SearchParameter.XPathUsageType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case NORMAL:
                return org.hl7.fhir.dstu2.model.SearchParameter.XPathUsageType.NORMAL;
            case PHONETIC:
                return org.hl7.fhir.dstu2.model.SearchParameter.XPathUsageType.PHONETIC;
            case NEARBY:
                return org.hl7.fhir.dstu2.model.SearchParameter.XPathUsageType.NEARBY;
            case DISTANCE:
                return org.hl7.fhir.dstu2.model.SearchParameter.XPathUsageType.DISTANCE;
            case OTHER:
                return org.hl7.fhir.dstu2.model.SearchParameter.XPathUsageType.OTHER;
            default:
                return org.hl7.fhir.dstu2.model.SearchParameter.XPathUsageType.NULL;
        }
    }

    public static org.hl7.fhir.dstu3.model.SearchParameter.XPathUsageType convertXPathUsageType(org.hl7.fhir.dstu2.model.SearchParameter.XPathUsageType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case NORMAL:
                return org.hl7.fhir.dstu3.model.SearchParameter.XPathUsageType.NORMAL;
            case PHONETIC:
                return org.hl7.fhir.dstu3.model.SearchParameter.XPathUsageType.PHONETIC;
            case NEARBY:
                return org.hl7.fhir.dstu3.model.SearchParameter.XPathUsageType.NEARBY;
            case DISTANCE:
                return org.hl7.fhir.dstu3.model.SearchParameter.XPathUsageType.DISTANCE;
            case OTHER:
                return org.hl7.fhir.dstu3.model.SearchParameter.XPathUsageType.OTHER;
            default:
                return org.hl7.fhir.dstu3.model.SearchParameter.XPathUsageType.NULL;
        }
    }
}
