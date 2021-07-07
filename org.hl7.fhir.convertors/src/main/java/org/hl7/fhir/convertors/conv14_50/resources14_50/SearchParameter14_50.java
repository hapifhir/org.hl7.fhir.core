package org.hl7.fhir.convertors.conv14_50.resources14_50;

import org.hl7.fhir.convertors.conv14_50.VersionConvertor_14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.Element14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.complextypes14_50.CodeableConcept14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.complextypes14_50.ContactPoint14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50.*;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.ElementDefinition14_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CodeType;

public class SearchParameter14_50 {

    public static org.hl7.fhir.dstu2016may.model.SearchParameter convertSearchParameter(org.hl7.fhir.r5.model.SearchParameter src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.SearchParameter tgt = new org.hl7.fhir.dstu2016may.model.SearchParameter();
        VersionConvertor_14_50.copyDomainResource(src, tgt);
        if (src.hasUrlElement())
            tgt.setUrlElement(Uri14_50.convertUri(src.getUrlElement()));
        if (src.hasNameElement())
            tgt.setNameElement(String14_50.convertString(src.getNameElement()));
        if (src.hasStatus())
            tgt.setStatusElement(Enumerations14_50.convertConformanceResourceStatus(src.getStatusElement()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(Boolean14_50.convertBoolean(src.getExperimentalElement()));
        if (src.hasDate())
            tgt.setDateElement(DateTime14_50.convertDateTime(src.getDateElement()));
        if (src.hasPublisher())
            tgt.setPublisherElement(String14_50.convertString(src.getPublisherElement()));
        for (org.hl7.fhir.r5.model.ContactDetail t : src.getContact()) tgt.addContact(convertSearchParameterContactComponent(t));
        for (org.hl7.fhir.r5.model.UsageContext t : src.getUseContext()) if (t.hasValueCodeableConcept())
            tgt.addUseContext(CodeableConcept14_50.convertCodeableConcept(t.getValueCodeableConcept()));
        for (org.hl7.fhir.r5.model.CodeableConcept t : src.getJurisdiction()) tgt.addUseContext(CodeableConcept14_50.convertCodeableConcept(t));
        if (src.hasPurpose())
            tgt.setRequirements(src.getPurpose());
        if (src.hasCodeElement())
            tgt.setCodeElement(Code14_50.convertCode(src.getCodeElement()));
        for (CodeType t : src.getBase()) tgt.setBase(t.asStringValue());
        if (src.hasType())
            tgt.setTypeElement(Enumerations14_50.convertSearchParamType(src.getTypeElement()));
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        if (src.hasExpression())
            tgt.setExpression(ElementDefinition14_50.convertTo2016MayExpression(src.getExpression()));
        if (src.hasXpath())
            tgt.setXpathElement(String14_50.convertString(src.getXpathElement()));
        if (src.hasXpathUsage())
            tgt.setXpathUsageElement(convertXPathUsageType(src.getXpathUsageElement()));
        for (CodeType t : src.getTarget()) tgt.addTarget(t.getValue());
        return tgt;
    }

    public static org.hl7.fhir.r5.model.SearchParameter convertSearchParameter(org.hl7.fhir.dstu2016may.model.SearchParameter src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.SearchParameter tgt = new org.hl7.fhir.r5.model.SearchParameter();
        VersionConvertor_14_50.copyDomainResource(src, tgt);
        if (src.hasUrlElement())
            tgt.setUrlElement(Uri14_50.convertUri(src.getUrlElement()));
        if (src.hasNameElement())
            tgt.setNameElement(String14_50.convertString(src.getNameElement()));
        if (src.hasStatus())
            tgt.setStatusElement(Enumerations14_50.convertConformanceResourceStatus(src.getStatusElement()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(Boolean14_50.convertBoolean(src.getExperimentalElement()));
        if (src.hasDate())
            tgt.setDateElement(DateTime14_50.convertDateTime(src.getDateElement()));
        if (src.hasPublisher())
            tgt.setPublisherElement(String14_50.convertString(src.getPublisherElement()));
        for (org.hl7.fhir.dstu2016may.model.SearchParameter.SearchParameterContactComponent t : src.getContact()) tgt.addContact(convertSearchParameterContactComponent(t));
        for (org.hl7.fhir.dstu2016may.model.CodeableConcept t : src.getUseContext()) if (CodeableConcept14_50.isJurisdiction(t))
            tgt.addJurisdiction(CodeableConcept14_50.convertCodeableConcept(t));
        else
            tgt.addUseContext(CodeableConcept14_50.convertCodeableConceptToUsageContext(t));
        if (src.hasRequirements())
            tgt.setPurpose(src.getRequirements());
        if (src.hasCodeElement())
            tgt.setCodeElement(Code14_50.convertCode(src.getCodeElement()));
        tgt.addBase(src.getBase());
        if (src.hasType())
            tgt.setTypeElement(Enumerations14_50.convertSearchParamType(src.getTypeElement()));
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        if (src.hasExpression())
            tgt.setExpression(ElementDefinition14_50.convertToR4Expression(src.getExpression()));
        if (src.hasXpath())
            tgt.setXpathElement(String14_50.convertString(src.getXpathElement()));
        if (src.hasXpathUsage())
            tgt.setXpathUsageElement(convertXPathUsageType(src.getXpathUsageElement()));
        for (org.hl7.fhir.dstu2016may.model.CodeType t : src.getTarget()) tgt.addTarget(t.getValue());
        return tgt;
    }

    public static org.hl7.fhir.r5.model.ContactDetail convertSearchParameterContactComponent(org.hl7.fhir.dstu2016may.model.SearchParameter.SearchParameterContactComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.ContactDetail tgt = new org.hl7.fhir.r5.model.ContactDetail();
        Element14_50.copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(String14_50.convertString(src.getNameElement()));
        for (org.hl7.fhir.dstu2016may.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(ContactPoint14_50.convertContactPoint(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.SearchParameter.SearchParameterContactComponent convertSearchParameterContactComponent(org.hl7.fhir.r5.model.ContactDetail src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.SearchParameter.SearchParameterContactComponent tgt = new org.hl7.fhir.dstu2016may.model.SearchParameter.SearchParameterContactComponent();
        Element14_50.copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(String14_50.convertString(src.getNameElement()));
        for (org.hl7.fhir.r5.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(ContactPoint14_50.convertContactPoint(t));
        return tgt;
    }

    static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.SearchParameter.XPathUsageType> convertXPathUsageType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.SearchParameter.XPathUsageType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.SearchParameter.XPathUsageType> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.SearchParameter.XPathUsageTypeEnumFactory());
        Element14_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case NORMAL:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.SearchParameter.XPathUsageType.NORMAL);
                break;
            case PHONETIC:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.SearchParameter.XPathUsageType.PHONETIC);
                break;
            case NEARBY:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.SearchParameter.XPathUsageType.NEARBY);
                break;
            case DISTANCE:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.SearchParameter.XPathUsageType.DISTANCE);
                break;
            case OTHER:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.SearchParameter.XPathUsageType.OTHER);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu2016may.model.SearchParameter.XPathUsageType.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.SearchParameter.XPathUsageType> convertXPathUsageType(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.SearchParameter.XPathUsageType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.SearchParameter.XPathUsageType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.SearchParameter.XPathUsageTypeEnumFactory());
        Element14_50.copyElement(src, tgt);
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
}