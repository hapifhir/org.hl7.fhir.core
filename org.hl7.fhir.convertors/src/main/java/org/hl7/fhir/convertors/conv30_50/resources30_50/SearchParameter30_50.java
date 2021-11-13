package org.hl7.fhir.convertors.conv30_50.resources30_50;

import org.hl7.fhir.convertors.context.ConversionContext30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.ContactDetail30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.Reference30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.UsageContext30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.CodeableConcept30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.*;
import org.hl7.fhir.exceptions.FHIRException;

import java.util.stream.Collectors;

public class SearchParameter30_50 {

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.SearchParameter.SearchComparator> convertSearchComparator(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.SearchParameter.SearchComparator> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.SearchParameter.SearchComparator> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.SearchParameter.SearchComparatorEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case EQ:
        tgt.setValue(org.hl7.fhir.r5.model.SearchParameter.SearchComparator.EQ);
        break;
      case NE:
        tgt.setValue(org.hl7.fhir.r5.model.SearchParameter.SearchComparator.NE);
        break;
      case GT:
        tgt.setValue(org.hl7.fhir.r5.model.SearchParameter.SearchComparator.GT);
        break;
      case LT:
        tgt.setValue(org.hl7.fhir.r5.model.SearchParameter.SearchComparator.LT);
        break;
      case GE:
        tgt.setValue(org.hl7.fhir.r5.model.SearchParameter.SearchComparator.GE);
        break;
      case LE:
        tgt.setValue(org.hl7.fhir.r5.model.SearchParameter.SearchComparator.LE);
        break;
      case SA:
        tgt.setValue(org.hl7.fhir.r5.model.SearchParameter.SearchComparator.SA);
        break;
      case EB:
        tgt.setValue(org.hl7.fhir.r5.model.SearchParameter.SearchComparator.EB);
        break;
      case AP:
        tgt.setValue(org.hl7.fhir.r5.model.SearchParameter.SearchComparator.AP);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.SearchParameter.SearchComparator.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.SearchParameter.SearchComparator> convertSearchComparator(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.SearchParameter.SearchComparator> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.SearchParameter.SearchComparator> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.SearchParameter.SearchComparatorEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case EQ:
        tgt.setValue(org.hl7.fhir.dstu3.model.SearchParameter.SearchComparator.EQ);
        break;
      case NE:
        tgt.setValue(org.hl7.fhir.dstu3.model.SearchParameter.SearchComparator.NE);
        break;
      case GT:
        tgt.setValue(org.hl7.fhir.dstu3.model.SearchParameter.SearchComparator.GT);
        break;
      case LT:
        tgt.setValue(org.hl7.fhir.dstu3.model.SearchParameter.SearchComparator.LT);
        break;
      case GE:
        tgt.setValue(org.hl7.fhir.dstu3.model.SearchParameter.SearchComparator.GE);
        break;
      case LE:
        tgt.setValue(org.hl7.fhir.dstu3.model.SearchParameter.SearchComparator.LE);
        break;
      case SA:
        tgt.setValue(org.hl7.fhir.dstu3.model.SearchParameter.SearchComparator.SA);
        break;
      case EB:
        tgt.setValue(org.hl7.fhir.dstu3.model.SearchParameter.SearchComparator.EB);
        break;
      case AP:
        tgt.setValue(org.hl7.fhir.dstu3.model.SearchParameter.SearchComparator.AP);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.SearchParameter.SearchComparator.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.SearchParameter.SearchModifierCode> convertSearchModifierCode(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.SearchParameter.SearchModifierCode> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.SearchParameter.SearchModifierCode> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.SearchParameter.SearchModifierCodeEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case MISSING:
        tgt.setValue(org.hl7.fhir.r5.model.SearchParameter.SearchModifierCode.MISSING);
        break;
      case EXACT:
        tgt.setValue(org.hl7.fhir.r5.model.SearchParameter.SearchModifierCode.EXACT);
        break;
      case CONTAINS:
        tgt.setValue(org.hl7.fhir.r5.model.SearchParameter.SearchModifierCode.CONTAINS);
        break;
      case NOT:
        tgt.setValue(org.hl7.fhir.r5.model.SearchParameter.SearchModifierCode.NOT);
        break;
      case TEXT:
        tgt.setValue(org.hl7.fhir.r5.model.SearchParameter.SearchModifierCode.TEXT);
        break;
      case IN:
        tgt.setValue(org.hl7.fhir.r5.model.SearchParameter.SearchModifierCode.IN);
        break;
      case NOTIN:
        tgt.setValue(org.hl7.fhir.r5.model.SearchParameter.SearchModifierCode.NOTIN);
        break;
      case BELOW:
        tgt.setValue(org.hl7.fhir.r5.model.SearchParameter.SearchModifierCode.BELOW);
        break;
      case ABOVE:
        tgt.setValue(org.hl7.fhir.r5.model.SearchParameter.SearchModifierCode.ABOVE);
        break;
      case TYPE:
        tgt.setValue(org.hl7.fhir.r5.model.SearchParameter.SearchModifierCode.TYPE);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.SearchParameter.SearchModifierCode.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.SearchParameter.SearchModifierCode> convertSearchModifierCode(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.SearchParameter.SearchModifierCode> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.SearchParameter.SearchModifierCode> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.SearchParameter.SearchModifierCodeEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case MISSING:
        tgt.setValue(org.hl7.fhir.dstu3.model.SearchParameter.SearchModifierCode.MISSING);
        break;
      case EXACT:
        tgt.setValue(org.hl7.fhir.dstu3.model.SearchParameter.SearchModifierCode.EXACT);
        break;
      case CONTAINS:
        tgt.setValue(org.hl7.fhir.dstu3.model.SearchParameter.SearchModifierCode.CONTAINS);
        break;
      case NOT:
        tgt.setValue(org.hl7.fhir.dstu3.model.SearchParameter.SearchModifierCode.NOT);
        break;
      case TEXT:
        tgt.setValue(org.hl7.fhir.dstu3.model.SearchParameter.SearchModifierCode.TEXT);
        break;
      case IN:
        tgt.setValue(org.hl7.fhir.dstu3.model.SearchParameter.SearchModifierCode.IN);
        break;
      case NOTIN:
        tgt.setValue(org.hl7.fhir.dstu3.model.SearchParameter.SearchModifierCode.NOTIN);
        break;
      case BELOW:
        tgt.setValue(org.hl7.fhir.dstu3.model.SearchParameter.SearchModifierCode.BELOW);
        break;
      case ABOVE:
        tgt.setValue(org.hl7.fhir.dstu3.model.SearchParameter.SearchModifierCode.ABOVE);
        break;
      case TYPE:
        tgt.setValue(org.hl7.fhir.dstu3.model.SearchParameter.SearchModifierCode.TYPE);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.SearchParameter.SearchModifierCode.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.SearchParameter convertSearchParameter(org.hl7.fhir.dstu3.model.SearchParameter src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.SearchParameter tgt = new org.hl7.fhir.r5.model.SearchParameter();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri30_50.convertUri(src.getUrlElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String30_50.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String30_50.convertString(src.getNameElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations30_50.convertPublicationStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean30_50.convertBoolean(src.getExperimentalElement()));
    if (src.hasDate())
      tgt.setDateElement(DateTime30_50.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String30_50.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.dstu3.model.ContactDetail t : src.getContact())
      tgt.addContact(ContactDetail30_50.convertContactDetail(t));
    for (org.hl7.fhir.dstu3.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(UsageContext30_50.convertUsageContext(t));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(CodeableConcept30_50.convertCodeableConcept(t));
    if (src.hasPurpose())
      tgt.setPurposeElement(MarkDown30_50.convertMarkdown(src.getPurposeElement()));
    if (src.hasCode())
      tgt.setCodeElement(Code30_50.convertCode(src.getCodeElement()));
    for (org.hl7.fhir.dstu3.model.CodeType t : src.getBase()) tgt.addBase(t.getValue());
    if (src.hasType())
      tgt.setTypeElement(Enumerations30_50.convertSearchParamType(src.getTypeElement()));
    if (src.hasDerivedFrom())
      tgt.setDerivedFrom(src.getDerivedFrom());
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown30_50.convertMarkdown(src.getDescriptionElement()));
    if (src.hasExpression())
      tgt.setExpressionElement(String30_50.convertString(src.getExpressionElement()));
    if (src.hasXpath())
      tgt.setXpathElement(String30_50.convertString(src.getXpathElement()));
    if (src.hasXpathUsage())
      tgt.setXpathUsageElement(convertXPathUsageType(src.getXpathUsageElement()));
    for (org.hl7.fhir.dstu3.model.CodeType t : src.getTarget()) tgt.addTarget(t.getValue());
    tgt.setComparator(src.getComparator().stream()
      .map(SearchParameter30_50::convertSearchComparator)
      .collect(Collectors.toList()));
    tgt.setModifier(src.getModifier().stream()
      .map(SearchParameter30_50::convertSearchModifierCode)
      .collect(Collectors.toList()));
    for (org.hl7.fhir.dstu3.model.StringType t : src.getChain()) tgt.addChain(t.getValue());
    for (org.hl7.fhir.dstu3.model.SearchParameter.SearchParameterComponentComponent t : src.getComponent())
      tgt.addComponent(convertSearchParameterComponentComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.SearchParameter convertSearchParameter(org.hl7.fhir.r5.model.SearchParameter src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.SearchParameter tgt = new org.hl7.fhir.dstu3.model.SearchParameter();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri30_50.convertUri(src.getUrlElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String30_50.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String30_50.convertString(src.getNameElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations30_50.convertPublicationStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean30_50.convertBoolean(src.getExperimentalElement()));
    if (src.hasDate())
      tgt.setDateElement(DateTime30_50.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String30_50.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.r5.model.ContactDetail t : src.getContact())
      tgt.addContact(ContactDetail30_50.convertContactDetail(t));
    for (org.hl7.fhir.r5.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(UsageContext30_50.convertUsageContext(t));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(CodeableConcept30_50.convertCodeableConcept(t));
    if (src.hasPurpose())
      tgt.setPurposeElement(MarkDown30_50.convertMarkdown(src.getPurposeElement()));
    if (src.hasCode())
      tgt.setCodeElement(Code30_50.convertCode(src.getCodeElement()));
    for (org.hl7.fhir.r5.model.CodeType t : src.getBase()) tgt.addBase(t.getValue());
    if (src.hasType())
      tgt.setTypeElement(Enumerations30_50.convertSearchParamType(src.getTypeElement()));
    if (src.hasDerivedFrom())
      tgt.setDerivedFrom(src.getDerivedFrom());
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown30_50.convertMarkdown(src.getDescriptionElement()));
    if (src.hasExpression())
      tgt.setExpressionElement(String30_50.convertString(src.getExpressionElement()));
    if (src.hasXpath())
      tgt.setXpathElement(String30_50.convertString(src.getXpathElement()));
    if (src.hasXpathUsage())
      tgt.setXpathUsageElement(convertXPathUsageType(src.getXpathUsageElement()));
    for (org.hl7.fhir.r5.model.CodeType t : src.getTarget()) tgt.addTarget(t.getValue());
    tgt.setComparator(src.getComparator().stream()
      .map(SearchParameter30_50::convertSearchComparator)
      .collect(Collectors.toList()));
    tgt.setModifier(src.getModifier().stream()
      .map(SearchParameter30_50::convertSearchModifierCode)
      .collect(Collectors.toList()));
    for (org.hl7.fhir.r5.model.StringType t : src.getChain()) tgt.addChain(t.getValue());
    for (org.hl7.fhir.r5.model.SearchParameter.SearchParameterComponentComponent t : src.getComponent())
      tgt.addComponent(convertSearchParameterComponentComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.SearchParameter.SearchParameterComponentComponent convertSearchParameterComponentComponent(org.hl7.fhir.dstu3.model.SearchParameter.SearchParameterComponentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.SearchParameter.SearchParameterComponentComponent tgt = new org.hl7.fhir.r5.model.SearchParameter.SearchParameterComponentComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.hasDefinition())
      tgt.setDefinitionElement(Reference30_50.convertReferenceToCanonical(src.getDefinition()));
    if (src.hasExpression())
      tgt.setExpressionElement(String30_50.convertString(src.getExpressionElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.SearchParameter.SearchParameterComponentComponent convertSearchParameterComponentComponent(org.hl7.fhir.r5.model.SearchParameter.SearchParameterComponentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.SearchParameter.SearchParameterComponentComponent tgt = new org.hl7.fhir.dstu3.model.SearchParameter.SearchParameterComponentComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.hasDefinition())
      tgt.setDefinition(Reference30_50.convertCanonicalToReference(src.getDefinitionElement()));
    if (src.hasExpression())
      tgt.setExpressionElement(String30_50.convertString(src.getExpressionElement()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.SearchParameter.XPathUsageType> convertXPathUsageType(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.SearchParameter.XPathUsageType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.SearchParameter.XPathUsageType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.SearchParameter.XPathUsageTypeEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    switch (src.getValue()) {
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

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.SearchParameter.XPathUsageType> convertXPathUsageType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.SearchParameter.XPathUsageType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.SearchParameter.XPathUsageType> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.SearchParameter.XPathUsageTypeEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
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