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
        if (src.hasUrlElement())
            tgt.setUrlElement(VersionConvertor_10_30.convertUri(src.getUrlElement()));
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_10_30.convertString(src.getNameElement()));
        if (src.hasStatus())
            tgt.setStatusElement(VersionConvertor_10_30.convertConformanceResourceStatus(src.getStatusElement()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(VersionConvertor_10_30.convertBoolean(src.getExperimentalElement()));
        if (src.hasDate())
            tgt.setDateElement(VersionConvertor_10_30.convertDateTime(src.getDateElement()));
        if (src.hasPublisherElement())
            tgt.setPublisherElement(VersionConvertor_10_30.convertString(src.getPublisherElement()));
        for (org.hl7.fhir.dstu3.model.ContactDetail t : src.getContact()) tgt.addContact(convertSearchParameterContactComponent(t));
        if (src.hasPurpose())
            tgt.setRequirements(src.getPurpose());
        if (src.hasCodeElement())
            tgt.setCodeElement(VersionConvertor_10_30.convertCode(src.getCodeElement()));
        for (org.hl7.fhir.dstu3.model.CodeType t : src.getBase()) tgt.setBase(t.asStringValue());
        if (src.hasType())
            tgt.setTypeElement(VersionConvertor_10_30.convertSearchParamType(src.getTypeElement()));
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        org.hl7.fhir.dstu2.utils.ToolingExtensions.setStringExtension(tgt, ToolingExtensions.EXT_EXPRESSION, src.getExpression());
        if (src.hasXpathElement())
            tgt.setXpathElement(VersionConvertor_10_30.convertString(src.getXpathElement()));
        if (src.hasXpathUsage())
            tgt.setXpathUsageElement(convertXPathUsageType(src.getXpathUsageElement()));
        for (org.hl7.fhir.dstu3.model.CodeType t : src.getTarget()) tgt.addTarget(t.getValue());
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.SearchParameter convertSearchParameter(org.hl7.fhir.dstu2.model.SearchParameter src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.SearchParameter tgt = new org.hl7.fhir.dstu3.model.SearchParameter();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        if (src.hasUrlElement())
            tgt.setUrlElement(VersionConvertor_10_30.convertUri(src.getUrlElement()));
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_10_30.convertString(src.getNameElement()));
        if (src.hasStatus())
            tgt.setStatusElement(VersionConvertor_10_30.convertConformanceResourceStatus(src.getStatusElement()));
        if (src.hasExperimental())
            tgt.setExperimentalElement(VersionConvertor_10_30.convertBoolean(src.getExperimentalElement()));
        if (src.hasDate())
            tgt.setDateElement(VersionConvertor_10_30.convertDateTime(src.getDateElement()));
        if (src.hasPublisherElement())
            tgt.setPublisherElement(VersionConvertor_10_30.convertString(src.getPublisherElement()));
        for (org.hl7.fhir.dstu2.model.SearchParameter.SearchParameterContactComponent t : src.getContact()) tgt.addContact(convertSearchParameterContactComponent(t));
        if (src.hasRequirements())
            tgt.setPurpose(src.getRequirements());
        if (src.hasCodeElement())
            tgt.setCodeElement(VersionConvertor_10_30.convertCode(src.getCodeElement()));
        tgt.addBase(src.getBase());
        if (src.hasType())
            tgt.setTypeElement(VersionConvertor_10_30.convertSearchParamType(src.getTypeElement()));
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        tgt.setExpression(ToolingExtensions.readStringExtension(src, ToolingExtensions.EXT_EXPRESSION));
        if (src.hasXpathElement())
            tgt.setXpathElement(VersionConvertor_10_30.convertString(src.getXpathElement()));
        if (src.hasXpathUsage())
            tgt.setXpathUsageElement(convertXPathUsageType(src.getXpathUsageElement()));
        for (org.hl7.fhir.dstu2.model.CodeType t : src.getTarget()) tgt.addTarget(t.getValue());
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.SearchParameter.SearchParameterContactComponent convertSearchParameterContactComponent(org.hl7.fhir.dstu3.model.ContactDetail src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.SearchParameter.SearchParameterContactComponent tgt = new org.hl7.fhir.dstu2.model.SearchParameter.SearchParameterContactComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_10_30.convertString(src.getNameElement()));
        for (org.hl7.fhir.dstu3.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_10_30.convertContactPoint(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ContactDetail convertSearchParameterContactComponent(org.hl7.fhir.dstu2.model.SearchParameter.SearchParameterContactComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ContactDetail tgt = new org.hl7.fhir.dstu3.model.ContactDetail();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement(VersionConvertor_10_30.convertString(src.getNameElement()));
        for (org.hl7.fhir.dstu2.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_10_30.convertContactPoint(t));
        return tgt;
    }

    static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.SearchParameter.XPathUsageType> convertXPathUsageType(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.SearchParameter.XPathUsageType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.SearchParameter.XPathUsageType> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.SearchParameter.XPathUsageTypeEnumFactory());
        VersionConvertor_10_30.copyElement(src, tgt);
        tgt.setValue(convertXPathUsageType(src.getValue()));
        return tgt;
    }

    static public org.hl7.fhir.dstu2.model.SearchParameter.XPathUsageType convertXPathUsageType(org.hl7.fhir.dstu3.model.SearchParameter.XPathUsageType src) throws FHIRException {
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

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.SearchParameter.XPathUsageType> convertXPathUsageType(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.SearchParameter.XPathUsageType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.SearchParameter.XPathUsageType> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.SearchParameter.XPathUsageTypeEnumFactory());
        VersionConvertor_10_30.copyElement(src, tgt);
        switch(src.getValue()) {
            case NORMAL:
                tgt.setValue(org.hl7.fhir.dstu3.model.SearchParameter.XPathUsageType.NORMAL);
                break;
            case PHONETIC:
                tgt.setValue(org.hl7.fhir.dstu3.model.SearchParameter.XPathUsageType.PHONETIC);
                break;
            case NEARBY:
                tgt.setValue(org.hl7.fhir.dstu3.model.SearchParameter.XPathUsageType.NEARBY);
                break;
            case DISTANCE:
                tgt.setValue(org.hl7.fhir.dstu3.model.SearchParameter.XPathUsageType.DISTANCE);
                break;
            case OTHER:
                tgt.setValue(org.hl7.fhir.dstu3.model.SearchParameter.XPathUsageType.OTHER);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.SearchParameter.XPathUsageType.NULL);
                break;
        }
        return tgt;
    }
}