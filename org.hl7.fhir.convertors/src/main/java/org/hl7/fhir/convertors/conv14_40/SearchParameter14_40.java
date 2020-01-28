package org.hl7.fhir.convertors.conv14_40;

import org.hl7.fhir.convertors.VersionConvertor_14_40;
import org.hl7.fhir.exceptions.FHIRException;

public class SearchParameter14_40 {

    public static org.hl7.fhir.r4.model.SearchParameter convertSearchParameter(org.hl7.fhir.dstu2016may.model.SearchParameter src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.SearchParameter tgt = new org.hl7.fhir.r4.model.SearchParameter();
        VersionConvertor_14_40.copyDomainResource(src, tgt);
        tgt.setUrl(src.getUrl());
        tgt.setName(src.getName());
        tgt.setStatus(VersionConvertor_14_40.convertConformanceResourceStatus(src.getStatus()));
        if (src.hasExperimental())
            tgt.setExperimental(src.getExperimental());
        if (src.hasDate())
            tgt.setDate(src.getDate());
        if (src.hasPublisher())
            tgt.setPublisher(src.getPublisher());
        for (org.hl7.fhir.dstu2016may.model.SearchParameter.SearchParameterContactComponent t : src.getContact()) tgt.addContact(convertSearchParameterContactComponent(t));
        for (org.hl7.fhir.dstu2016may.model.CodeableConcept t : src.getUseContext()) if (VersionConvertor_14_40.isJurisdiction(t))
            tgt.addJurisdiction(VersionConvertor_14_40.convertCodeableConcept(t));
        else
            tgt.addUseContext(VersionConvertor_14_40.convertCodeableConceptToUsageContext(t));
        if (src.hasRequirements())
            tgt.setPurpose(src.getRequirements());
        tgt.setCode(src.getCode());
        tgt.addBase(src.getBase());
        tgt.setType(VersionConvertor_14_40.convertSearchParamType(src.getType()));
        tgt.setDescription(src.getDescription());
        if (src.hasExpression())
            tgt.setExpression(VersionConvertor_14_40.convertToR4Expression(src.getExpression()));
        if (src.hasXpath())
            tgt.setXpath(src.getXpath());
        tgt.setXpathUsage(convertXPathUsageType(src.getXpathUsage()));
        for (org.hl7.fhir.dstu2016may.model.CodeType t : src.getTarget()) tgt.addTarget(t.getValue());
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.SearchParameter convertSearchParameter(org.hl7.fhir.r4.model.SearchParameter src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.SearchParameter tgt = new org.hl7.fhir.dstu2016may.model.SearchParameter();
        VersionConvertor_14_40.copyDomainResource(src, tgt);
        tgt.setUrl(src.getUrl());
        tgt.setName(src.getName());
        tgt.setStatus(VersionConvertor_14_40.convertConformanceResourceStatus(src.getStatus()));
        if (src.hasExperimental())
            tgt.setExperimental(src.getExperimental());
        if (src.hasDate())
            tgt.setDate(src.getDate());
        if (src.hasPublisher())
            tgt.setPublisher(src.getPublisher());
        for (org.hl7.fhir.r4.model.ContactDetail t : src.getContact()) tgt.addContact(convertSearchParameterContactComponent(t));
        for (org.hl7.fhir.r4.model.UsageContext t : src.getUseContext()) if (t.hasValueCodeableConcept())
            tgt.addUseContext(VersionConvertor_14_40.convertCodeableConcept(t.getValueCodeableConcept()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getJurisdiction()) tgt.addUseContext(VersionConvertor_14_40.convertCodeableConcept(t));
        if (src.hasPurpose())
            tgt.setRequirements(src.getPurpose());
        tgt.setCode(src.getCode());
        for (org.hl7.fhir.r4.model.CodeType t : src.getBase()) tgt.setBase(t.asStringValue());
        tgt.setType(VersionConvertor_14_40.convertSearchParamType(src.getType()));
        tgt.setDescription(src.getDescription());
        if (src.hasExpression())
            tgt.setExpression(VersionConvertor_14_40.convertTo2016MayExpression(src.getExpression()));
        if (src.hasXpath())
            tgt.setXpath(src.getXpath());
        tgt.setXpathUsage(convertXPathUsageType(src.getXpathUsage()));
        for (org.hl7.fhir.r4.model.CodeType t : src.getTarget()) tgt.addTarget(t.getValue());
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ContactDetail convertSearchParameterContactComponent(org.hl7.fhir.dstu2016may.model.SearchParameter.SearchParameterContactComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.ContactDetail tgt = new org.hl7.fhir.r4.model.ContactDetail();
        VersionConvertor_14_40.copyElement(src, tgt);
        if (src.hasName())
            tgt.setName(src.getName());
        for (org.hl7.fhir.dstu2016may.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_14_40.convertContactPoint(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.SearchParameter.SearchParameterContactComponent convertSearchParameterContactComponent(org.hl7.fhir.r4.model.ContactDetail src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.SearchParameter.SearchParameterContactComponent tgt = new org.hl7.fhir.dstu2016may.model.SearchParameter.SearchParameterContactComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        if (src.hasName())
            tgt.setName(src.getName());
        for (org.hl7.fhir.r4.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_14_40.convertContactPoint(t));
        return tgt;
    }

    static public org.hl7.fhir.r4.model.SearchParameter.XPathUsageType convertXPathUsageType(org.hl7.fhir.dstu2016may.model.SearchParameter.XPathUsageType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case NORMAL:
                return org.hl7.fhir.r4.model.SearchParameter.XPathUsageType.NORMAL;
            case PHONETIC:
                return org.hl7.fhir.r4.model.SearchParameter.XPathUsageType.PHONETIC;
            case NEARBY:
                return org.hl7.fhir.r4.model.SearchParameter.XPathUsageType.NEARBY;
            case DISTANCE:
                return org.hl7.fhir.r4.model.SearchParameter.XPathUsageType.DISTANCE;
            case OTHER:
                return org.hl7.fhir.r4.model.SearchParameter.XPathUsageType.OTHER;
            default:
                return org.hl7.fhir.r4.model.SearchParameter.XPathUsageType.NULL;
        }
    }

    static public org.hl7.fhir.dstu2016may.model.SearchParameter.XPathUsageType convertXPathUsageType(org.hl7.fhir.r4.model.SearchParameter.XPathUsageType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case NORMAL:
                return org.hl7.fhir.dstu2016may.model.SearchParameter.XPathUsageType.NORMAL;
            case PHONETIC:
                return org.hl7.fhir.dstu2016may.model.SearchParameter.XPathUsageType.PHONETIC;
            case NEARBY:
                return org.hl7.fhir.dstu2016may.model.SearchParameter.XPathUsageType.NEARBY;
            case DISTANCE:
                return org.hl7.fhir.dstu2016may.model.SearchParameter.XPathUsageType.DISTANCE;
            case OTHER:
                return org.hl7.fhir.dstu2016may.model.SearchParameter.XPathUsageType.OTHER;
            default:
                return org.hl7.fhir.dstu2016may.model.SearchParameter.XPathUsageType.NULL;
        }
    }
}
