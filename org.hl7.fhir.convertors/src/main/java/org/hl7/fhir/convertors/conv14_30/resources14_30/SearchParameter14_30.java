package org.hl7.fhir.convertors.conv14_30.resources14_30;

import org.hl7.fhir.convertors.context.ConversionContext14_30;
import org.hl7.fhir.convertors.conv14_30.VersionConvertor_14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.complextypes14_30.CodeableConcept14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.complextypes14_30.ContactPoint14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.primitivetypes14_30.Boolean14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.primitivetypes14_30.Code14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.primitivetypes14_30.DateTime14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.primitivetypes14_30.String14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.primitivetypes14_30.Uri14_30;
import org.hl7.fhir.exceptions.FHIRException;

public class SearchParameter14_30 {

  public static org.hl7.fhir.dstu2016may.model.SearchParameter convertSearchParameter(org.hl7.fhir.dstu3.model.SearchParameter src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.SearchParameter tgt = new org.hl7.fhir.dstu2016may.model.SearchParameter();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyDomainResource(src, tgt);
    if (src.hasUrlElement())
      tgt.setUrlElement(Uri14_30.convertUri(src.getUrlElement()));
    if (src.hasNameElement())
      tgt.setNameElement(String14_30.convertString(src.getNameElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations14_30.convertConformanceResourceStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean14_30.convertBoolean(src.getExperimentalElement()));
    if (src.hasDate())
      tgt.setDateElement(DateTime14_30.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String14_30.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.dstu3.model.ContactDetail t : src.getContact())
      tgt.addContact(convertSearchParameterContactComponent(t));
    for (org.hl7.fhir.dstu3.model.UsageContext t : src.getUseContext())
      if (t.hasValueCodeableConcept())
        tgt.addUseContext(CodeableConcept14_30.convertCodeableConcept(t.getValueCodeableConcept()));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getJurisdiction())
      tgt.addUseContext(CodeableConcept14_30.convertCodeableConcept(t));
    if (src.hasPurpose())
      tgt.setRequirements(src.getPurpose());
    if (src.hasCodeElement())
      tgt.setCodeElement(Code14_30.convertCode(src.getCodeElement()));
    for (org.hl7.fhir.dstu3.model.CodeType t : src.getBase()) tgt.setBase(t.asStringValue());
    if (src.hasType())
      tgt.setTypeElement(Enumerations14_30.convertSearchParamType(src.getTypeElement()));
    if (src.hasDescription())
      tgt.setDescription(src.getDescription());
    if (src.hasExpression())
      tgt.setExpressionElement(String14_30.convertString(src.getExpressionElement()));
    if (src.hasXpath())
      tgt.setXpathElement(String14_30.convertString(src.getXpathElement()));
    if (src.hasXpathUsage())
      tgt.setXpathUsageElement(convertXPathUsageType(src.getXpathUsageElement()));
    for (org.hl7.fhir.dstu3.model.CodeType t : src.getTarget()) tgt.addTarget(t.getValue());
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.SearchParameter convertSearchParameter(org.hl7.fhir.dstu2016may.model.SearchParameter src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.SearchParameter tgt = new org.hl7.fhir.dstu3.model.SearchParameter();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyDomainResource(src, tgt);
    if (src.hasUrlElement())
      tgt.setUrlElement(Uri14_30.convertUri(src.getUrlElement()));
    if (src.hasNameElement())
      tgt.setNameElement(String14_30.convertString(src.getNameElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations14_30.convertConformanceResourceStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean14_30.convertBoolean(src.getExperimentalElement()));
    if (src.hasDate())
      tgt.setDateElement(DateTime14_30.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String14_30.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.dstu2016may.model.SearchParameter.SearchParameterContactComponent t : src.getContact())
      tgt.addContact(convertSearchParameterContactComponent(t));
    for (org.hl7.fhir.dstu2016may.model.CodeableConcept t : src.getUseContext())
      if (VersionConvertor_14_30.isJurisdiction(t))
        tgt.addJurisdiction(CodeableConcept14_30.convertCodeableConcept(t));
      else
        tgt.addUseContext(CodeableConcept14_30.convertCodeableConceptToUsageContext(t));
    if (src.hasRequirements())
      tgt.setPurpose(src.getRequirements());
    if (src.hasCodeElement())
      tgt.setCodeElement(Code14_30.convertCode(src.getCodeElement()));
    tgt.addBase(src.getBase());
    if (src.hasType())
      tgt.setTypeElement(Enumerations14_30.convertSearchParamType(src.getTypeElement()));
    if (src.hasDescription())
      tgt.setDescription(src.getDescription());
    if (src.hasExpression())
      tgt.setExpressionElement(String14_30.convertString(src.getExpressionElement()));
    if (src.hasXpath())
      tgt.setXpathElement(String14_30.convertString(src.getXpathElement()));
    if (src.hasXpathUsage())
      tgt.setXpathUsageElement(convertXPathUsageType(src.getXpathUsageElement()));
    for (org.hl7.fhir.dstu2016may.model.CodeType t : src.getTarget()) tgt.addTarget(t.getValue());
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.SearchParameter.SearchParameterContactComponent convertSearchParameterContactComponent(org.hl7.fhir.dstu3.model.ContactDetail src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.SearchParameter.SearchParameterContactComponent tgt = new org.hl7.fhir.dstu2016may.model.SearchParameter.SearchParameterContactComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String14_30.convertString(src.getNameElement()));
    for (org.hl7.fhir.dstu3.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint14_30.convertContactPoint(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.ContactDetail convertSearchParameterContactComponent(org.hl7.fhir.dstu2016may.model.SearchParameter.SearchParameterContactComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.ContactDetail tgt = new org.hl7.fhir.dstu3.model.ContactDetail();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String14_30.convertString(src.getNameElement()));
    for (org.hl7.fhir.dstu2016may.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint14_30.convertContactPoint(t));
    return tgt;
  }

  static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.SearchParameter.XPathUsageType> convertXPathUsageType(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.SearchParameter.XPathUsageType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.SearchParameter.XPathUsageType> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.SearchParameter.XPathUsageTypeEnumFactory());
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    switch (src.getValue()) {
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

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.SearchParameter.XPathUsageType> convertXPathUsageType(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.SearchParameter.XPathUsageType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.SearchParameter.XPathUsageType> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.SearchParameter.XPathUsageTypeEnumFactory());
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    switch (src.getValue()) {
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