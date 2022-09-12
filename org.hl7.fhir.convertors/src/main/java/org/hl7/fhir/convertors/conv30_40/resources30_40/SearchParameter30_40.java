package org.hl7.fhir.convertors.conv30_40.resources30_40;

import java.util.stream.Collectors;

import org.hl7.fhir.convertors.context.ConversionContext30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.ContactDetail30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.Reference30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.CodeableConcept30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.complextypes30_40.Timing30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.Boolean30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.Code30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.DateTime30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.MarkDown30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.String30_40;
import org.hl7.fhir.convertors.conv30_40.datatypes30_40.primitivetypes30_40.Uri30_40;
import org.hl7.fhir.exceptions.FHIRException;

public class SearchParameter30_40 {

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.SearchParameter.SearchComparator> convertSearchComparator(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.SearchParameter.SearchComparator> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.SearchParameter.SearchComparator> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.SearchParameter.SearchComparatorEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case EQ:
        tgt.setValue(org.hl7.fhir.r4.model.SearchParameter.SearchComparator.EQ);
        break;
      case NE:
        tgt.setValue(org.hl7.fhir.r4.model.SearchParameter.SearchComparator.NE);
        break;
      case GT:
        tgt.setValue(org.hl7.fhir.r4.model.SearchParameter.SearchComparator.GT);
        break;
      case LT:
        tgt.setValue(org.hl7.fhir.r4.model.SearchParameter.SearchComparator.LT);
        break;
      case GE:
        tgt.setValue(org.hl7.fhir.r4.model.SearchParameter.SearchComparator.GE);
        break;
      case LE:
        tgt.setValue(org.hl7.fhir.r4.model.SearchParameter.SearchComparator.LE);
        break;
      case SA:
        tgt.setValue(org.hl7.fhir.r4.model.SearchParameter.SearchComparator.SA);
        break;
      case EB:
        tgt.setValue(org.hl7.fhir.r4.model.SearchParameter.SearchComparator.EB);
        break;
      case AP:
        tgt.setValue(org.hl7.fhir.r4.model.SearchParameter.SearchComparator.AP);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.SearchParameter.SearchComparator.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.SearchParameter.SearchComparator> convertSearchComparator(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.SearchParameter.SearchComparator> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.SearchParameter.SearchComparator> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.SearchParameter.SearchComparatorEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
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

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.SearchParameter.SearchModifierCode> convertSearchModifierCode(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.SearchParameter.SearchModifierCode> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.SearchParameter.SearchModifierCode> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.SearchParameter.SearchModifierCodeEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
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

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.SearchParameter.SearchModifierCode> convertSearchModifierCode(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.SearchParameter.SearchModifierCode> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.SearchParameter.SearchModifierCode> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.SearchParameter.SearchModifierCodeEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case MISSING:
        tgt.setValue(org.hl7.fhir.r4.model.SearchParameter.SearchModifierCode.MISSING);
        break;
      case EXACT:
        tgt.setValue(org.hl7.fhir.r4.model.SearchParameter.SearchModifierCode.EXACT);
        break;
      case CONTAINS:
        tgt.setValue(org.hl7.fhir.r4.model.SearchParameter.SearchModifierCode.CONTAINS);
        break;
      case NOT:
        tgt.setValue(org.hl7.fhir.r4.model.SearchParameter.SearchModifierCode.NOT);
        break;
      case TEXT:
        tgt.setValue(org.hl7.fhir.r4.model.SearchParameter.SearchModifierCode.TEXT);
        break;
      case IN:
        tgt.setValue(org.hl7.fhir.r4.model.SearchParameter.SearchModifierCode.IN);
        break;
      case NOTIN:
        tgt.setValue(org.hl7.fhir.r4.model.SearchParameter.SearchModifierCode.NOTIN);
        break;
      case BELOW:
        tgt.setValue(org.hl7.fhir.r4.model.SearchParameter.SearchModifierCode.BELOW);
        break;
      case ABOVE:
        tgt.setValue(org.hl7.fhir.r4.model.SearchParameter.SearchModifierCode.ABOVE);
        break;
      case TYPE:
        tgt.setValue(org.hl7.fhir.r4.model.SearchParameter.SearchModifierCode.TYPE);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.SearchParameter.SearchModifierCode.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.SearchParameter convertSearchParameter(org.hl7.fhir.r4.model.SearchParameter src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.SearchParameter tgt = new org.hl7.fhir.dstu3.model.SearchParameter();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri30_40.convertUri(src.getUrlElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String30_40.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String30_40.convertString(src.getNameElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations30_40.convertPublicationStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean30_40.convertBoolean(src.getExperimentalElement()));
    if (src.hasDateElement())
      tgt.setDateElement(DateTime30_40.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String30_40.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.r4.model.ContactDetail t : src.getContact())
      tgt.addContact(ContactDetail30_40.convertContactDetail(t));
    for (org.hl7.fhir.r4.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(Timing30_40.convertUsageContext(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(CodeableConcept30_40.convertCodeableConcept(t));
    if (src.hasPurpose())
      tgt.setPurposeElement(MarkDown30_40.convertMarkdown(src.getPurposeElement()));
    if (src.hasCode())
      tgt.setCodeElement(Code30_40.convertCode(src.getCodeElement()));
    for (org.hl7.fhir.r4.model.CodeType t : src.getBase()) tgt.addBase(t.getValue());
    if (src.hasType())
      tgt.setTypeElement(Enumerations30_40.convertSearchParamType(src.getTypeElement()));
    if (src.hasDerivedFrom())
      tgt.setDerivedFrom(src.getDerivedFrom());
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown30_40.convertMarkdown(src.getDescriptionElement()));
    if (src.hasExpression())
      tgt.setExpressionElement(String30_40.convertString(src.getExpressionElement()));
    if (src.hasXpath())
      tgt.setXpathElement(String30_40.convertString(src.getXpathElement()));
    if (src.hasXpathUsage())
      tgt.setXpathUsageElement(convertXPathUsageType(src.getXpathUsageElement()));
    for (org.hl7.fhir.r4.model.CodeType t : src.getTarget()) tgt.addTarget(t.getValue());
    tgt.setComparator(src.getComparator().stream()
      .map(SearchParameter30_40::convertSearchComparator)
      .collect(Collectors.toList()));
    tgt.setModifier(src.getModifier().stream()
      .map(SearchParameter30_40::convertSearchModifierCode)
      .collect(Collectors.toList()));
    for (org.hl7.fhir.r4.model.StringType t : src.getChain()) tgt.addChain(t.getValue());
    for (org.hl7.fhir.r4.model.SearchParameter.SearchParameterComponentComponent t : src.getComponent())
      tgt.addComponent(convertSearchParameterComponentComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.SearchParameter convertSearchParameter(org.hl7.fhir.dstu3.model.SearchParameter src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.SearchParameter tgt = new org.hl7.fhir.r4.model.SearchParameter();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri30_40.convertUri(src.getUrlElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String30_40.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String30_40.convertString(src.getNameElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations30_40.convertPublicationStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean30_40.convertBoolean(src.getExperimentalElement()));
    if (src.hasDateElement())
      tgt.setDateElement(DateTime30_40.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String30_40.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.dstu3.model.ContactDetail t : src.getContact())
      tgt.addContact(ContactDetail30_40.convertContactDetail(t));
    for (org.hl7.fhir.dstu3.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(Timing30_40.convertUsageContext(t));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(CodeableConcept30_40.convertCodeableConcept(t));
    if (src.hasPurpose())
      tgt.setPurposeElement(MarkDown30_40.convertMarkdown(src.getPurposeElement()));
    if (src.hasCode())
      tgt.setCodeElement(Code30_40.convertCode(src.getCodeElement()));
    for (org.hl7.fhir.dstu3.model.CodeType t : src.getBase()) tgt.addBase(t.getValue());
    if (src.hasType())
      tgt.setTypeElement(Enumerations30_40.convertSearchParamType(src.getTypeElement()));
    if (src.hasDerivedFrom())
      tgt.setDerivedFrom(src.getDerivedFrom());
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown30_40.convertMarkdown(src.getDescriptionElement()));
    if (src.hasExpression())
      tgt.setExpressionElement(String30_40.convertString(src.getExpressionElement()));
    if (src.hasXpath())
      tgt.setXpathElement(String30_40.convertString(src.getXpathElement()));
    if (src.hasXpathUsage())
      tgt.setXpathUsageElement(convertXPathUsageType(src.getXpathUsageElement()));
    for (org.hl7.fhir.dstu3.model.CodeType t : src.getTarget()) tgt.addTarget(t.getValue());
    tgt.setComparator(src.getComparator().stream()
      .map(SearchParameter30_40::convertSearchComparator)
      .collect(Collectors.toList()));
    tgt.setModifier(src.getModifier().stream()
      .map(SearchParameter30_40::convertSearchModifierCode)
      .collect(Collectors.toList()));
    for (org.hl7.fhir.dstu3.model.StringType t : src.getChain()) tgt.addChain(t.getValue());
    for (org.hl7.fhir.dstu3.model.SearchParameter.SearchParameterComponentComponent t : src.getComponent())
      tgt.addComponent(convertSearchParameterComponentComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.SearchParameter.SearchParameterComponentComponent convertSearchParameterComponentComponent(org.hl7.fhir.r4.model.SearchParameter.SearchParameterComponentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.SearchParameter.SearchParameterComponentComponent tgt = new org.hl7.fhir.dstu3.model.SearchParameter.SearchParameterComponentComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src,tgt);
    if (src.hasDefinition())
      tgt.setDefinition(Reference30_40.convertCanonicalToReference(src.getDefinitionElement()));
    if (src.hasExpression())
      tgt.setExpressionElement(String30_40.convertString(src.getExpressionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.SearchParameter.SearchParameterComponentComponent convertSearchParameterComponentComponent(org.hl7.fhir.dstu3.model.SearchParameter.SearchParameterComponentComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.SearchParameter.SearchParameterComponentComponent tgt = new org.hl7.fhir.r4.model.SearchParameter.SearchParameterComponentComponent();
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyBackboneElement(src,tgt);
    if (src.hasDefinition())
      tgt.setDefinitionElement(Reference30_40.convertReferenceToCanonical(src.getDefinition()));
    if (src.hasExpression())
      tgt.setExpressionElement(String30_40.convertString(src.getExpressionElement()));
    return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.SearchParameter.XPathUsageType> convertXPathUsageType(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.SearchParameter.XPathUsageType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.SearchParameter.XPathUsageType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.SearchParameter.XPathUsageTypeEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
    switch (src.getValue()) {
      case NORMAL:
        tgt.setValue(org.hl7.fhir.r4.model.SearchParameter.XPathUsageType.NORMAL);
        break;
      case PHONETIC:
        tgt.setValue(org.hl7.fhir.r4.model.SearchParameter.XPathUsageType.PHONETIC);
        break;
      case NEARBY:
        tgt.setValue(org.hl7.fhir.r4.model.SearchParameter.XPathUsageType.NEARBY);
        break;
      case DISTANCE:
        tgt.setValue(org.hl7.fhir.r4.model.SearchParameter.XPathUsageType.DISTANCE);
        break;
      case OTHER:
        tgt.setValue(org.hl7.fhir.r4.model.SearchParameter.XPathUsageType.OTHER);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4.model.SearchParameter.XPathUsageType.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.SearchParameter.XPathUsageType> convertXPathUsageType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.SearchParameter.XPathUsageType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.SearchParameter.XPathUsageType> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.SearchParameter.XPathUsageTypeEnumFactory());
    ConversionContext30_40.INSTANCE.getVersionConvertor_30_40().copyElement(src, tgt);
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