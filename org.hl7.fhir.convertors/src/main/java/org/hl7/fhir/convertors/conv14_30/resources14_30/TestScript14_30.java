package org.hl7.fhir.convertors.conv14_30.resources14_30;

import org.hl7.fhir.convertors.context.ConversionContext14_30;
import org.hl7.fhir.convertors.conv14_30.VersionConvertor_14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.Reference14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.complextypes14_30.CodeableConcept14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.complextypes14_30.ContactPoint14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.complextypes14_30.Identifier14_30;
import org.hl7.fhir.convertors.conv14_30.datatypes14_30.primitivetypes14_30.*;
import org.hl7.fhir.exceptions.FHIRException;

public class TestScript14_30 {

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.TestScript.AssertionDirectionType> convertAssertionDirectionType(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.TestScript.AssertionDirectionType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.TestScript.AssertionDirectionType> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.TestScript.AssertionDirectionTypeEnumFactory());
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    switch (src.getValue()) {
      case RESPONSE:
        tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionDirectionType.RESPONSE);
        break;
      case REQUEST:
        tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionDirectionType.REQUEST);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionDirectionType.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.TestScript.AssertionDirectionType> convertAssertionDirectionType(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.TestScript.AssertionDirectionType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.TestScript.AssertionDirectionType> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.TestScript.AssertionDirectionTypeEnumFactory());
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    switch (src.getValue()) {
      case RESPONSE:
        tgt.setValue(org.hl7.fhir.dstu2016may.model.TestScript.AssertionDirectionType.RESPONSE);
        break;
      case REQUEST:
        tgt.setValue(org.hl7.fhir.dstu2016may.model.TestScript.AssertionDirectionType.REQUEST);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu2016may.model.TestScript.AssertionDirectionType.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.TestScript.AssertionOperatorType> convertAssertionOperatorType(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.TestScript.AssertionOperatorType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.TestScript.AssertionOperatorType> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.TestScript.AssertionOperatorTypeEnumFactory());
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    switch (src.getValue()) {
      case EQUALS:
        tgt.setValue(org.hl7.fhir.dstu2016may.model.TestScript.AssertionOperatorType.EQUALS);
        break;
      case NOTEQUALS:
        tgt.setValue(org.hl7.fhir.dstu2016may.model.TestScript.AssertionOperatorType.NOTEQUALS);
        break;
      case IN:
        tgt.setValue(org.hl7.fhir.dstu2016may.model.TestScript.AssertionOperatorType.IN);
        break;
      case NOTIN:
        tgt.setValue(org.hl7.fhir.dstu2016may.model.TestScript.AssertionOperatorType.NOTIN);
        break;
      case GREATERTHAN:
        tgt.setValue(org.hl7.fhir.dstu2016may.model.TestScript.AssertionOperatorType.GREATERTHAN);
        break;
      case LESSTHAN:
        tgt.setValue(org.hl7.fhir.dstu2016may.model.TestScript.AssertionOperatorType.LESSTHAN);
        break;
      case EMPTY:
        tgt.setValue(org.hl7.fhir.dstu2016may.model.TestScript.AssertionOperatorType.EMPTY);
        break;
      case NOTEMPTY:
        tgt.setValue(org.hl7.fhir.dstu2016may.model.TestScript.AssertionOperatorType.NOTEMPTY);
        break;
      case CONTAINS:
        tgt.setValue(org.hl7.fhir.dstu2016may.model.TestScript.AssertionOperatorType.CONTAINS);
        break;
      case NOTCONTAINS:
        tgt.setValue(org.hl7.fhir.dstu2016may.model.TestScript.AssertionOperatorType.NOTCONTAINS);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu2016may.model.TestScript.AssertionOperatorType.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.TestScript.AssertionOperatorType> convertAssertionOperatorType(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.TestScript.AssertionOperatorType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.TestScript.AssertionOperatorType> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.TestScript.AssertionOperatorTypeEnumFactory());
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    switch (src.getValue()) {
      case EQUALS:
        tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionOperatorType.EQUALS);
        break;
      case NOTEQUALS:
        tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionOperatorType.NOTEQUALS);
        break;
      case IN:
        tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionOperatorType.IN);
        break;
      case NOTIN:
        tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionOperatorType.NOTIN);
        break;
      case GREATERTHAN:
        tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionOperatorType.GREATERTHAN);
        break;
      case LESSTHAN:
        tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionOperatorType.LESSTHAN);
        break;
      case EMPTY:
        tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionOperatorType.EMPTY);
        break;
      case NOTEMPTY:
        tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionOperatorType.NOTEMPTY);
        break;
      case CONTAINS:
        tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionOperatorType.CONTAINS);
        break;
      case NOTCONTAINS:
        tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionOperatorType.NOTCONTAINS);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionOperatorType.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.TestScript.AssertionResponseTypes> convertAssertionResponseTypes(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.TestScript.AssertionResponseTypes> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.TestScript.AssertionResponseTypes> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.TestScript.AssertionResponseTypesEnumFactory());
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    switch (src.getValue()) {
      case OKAY:
        tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionResponseTypes.OKAY);
        break;
      case CREATED:
        tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionResponseTypes.CREATED);
        break;
      case NOCONTENT:
        tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionResponseTypes.NOCONTENT);
        break;
      case NOTMODIFIED:
        tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionResponseTypes.NOTMODIFIED);
        break;
      case BAD:
        tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionResponseTypes.BAD);
        break;
      case FORBIDDEN:
        tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionResponseTypes.FORBIDDEN);
        break;
      case NOTFOUND:
        tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionResponseTypes.NOTFOUND);
        break;
      case METHODNOTALLOWED:
        tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionResponseTypes.METHODNOTALLOWED);
        break;
      case CONFLICT:
        tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionResponseTypes.CONFLICT);
        break;
      case GONE:
        tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionResponseTypes.GONE);
        break;
      case PRECONDITIONFAILED:
        tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionResponseTypes.PRECONDITIONFAILED);
        break;
      case UNPROCESSABLE:
        tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionResponseTypes.UNPROCESSABLE);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.AssertionResponseTypes.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.TestScript.AssertionResponseTypes> convertAssertionResponseTypes(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.TestScript.AssertionResponseTypes> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.TestScript.AssertionResponseTypes> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.TestScript.AssertionResponseTypesEnumFactory());
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    switch (src.getValue()) {
      case OKAY:
        tgt.setValue(org.hl7.fhir.dstu2016may.model.TestScript.AssertionResponseTypes.OKAY);
        break;
      case CREATED:
        tgt.setValue(org.hl7.fhir.dstu2016may.model.TestScript.AssertionResponseTypes.CREATED);
        break;
      case NOCONTENT:
        tgt.setValue(org.hl7.fhir.dstu2016may.model.TestScript.AssertionResponseTypes.NOCONTENT);
        break;
      case NOTMODIFIED:
        tgt.setValue(org.hl7.fhir.dstu2016may.model.TestScript.AssertionResponseTypes.NOTMODIFIED);
        break;
      case BAD:
        tgt.setValue(org.hl7.fhir.dstu2016may.model.TestScript.AssertionResponseTypes.BAD);
        break;
      case FORBIDDEN:
        tgt.setValue(org.hl7.fhir.dstu2016may.model.TestScript.AssertionResponseTypes.FORBIDDEN);
        break;
      case NOTFOUND:
        tgt.setValue(org.hl7.fhir.dstu2016may.model.TestScript.AssertionResponseTypes.NOTFOUND);
        break;
      case METHODNOTALLOWED:
        tgt.setValue(org.hl7.fhir.dstu2016may.model.TestScript.AssertionResponseTypes.METHODNOTALLOWED);
        break;
      case CONFLICT:
        tgt.setValue(org.hl7.fhir.dstu2016may.model.TestScript.AssertionResponseTypes.CONFLICT);
        break;
      case GONE:
        tgt.setValue(org.hl7.fhir.dstu2016may.model.TestScript.AssertionResponseTypes.GONE);
        break;
      case PRECONDITIONFAILED:
        tgt.setValue(org.hl7.fhir.dstu2016may.model.TestScript.AssertionResponseTypes.PRECONDITIONFAILED);
        break;
      case UNPROCESSABLE:
        tgt.setValue(org.hl7.fhir.dstu2016may.model.TestScript.AssertionResponseTypes.UNPROCESSABLE);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu2016may.model.TestScript.AssertionResponseTypes.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.TestScript.ContentType> convertContentType(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.TestScript.ContentType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.TestScript.ContentType> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.TestScript.ContentTypeEnumFactory());
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    switch (src.getValue()) {
      case XML:
        tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.ContentType.XML);
        break;
      case JSON:
        tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.ContentType.JSON);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu3.model.TestScript.ContentType.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.TestScript.ContentType> convertContentType(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.TestScript.ContentType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.TestScript.ContentType> tgt = new org.hl7.fhir.dstu2016may.model.Enumeration<>(new org.hl7.fhir.dstu2016may.model.TestScript.ContentTypeEnumFactory());
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    switch (src.getValue()) {
      case XML:
        tgt.setValue(org.hl7.fhir.dstu2016may.model.TestScript.ContentType.XML);
        break;
      case JSON:
        tgt.setValue(org.hl7.fhir.dstu2016may.model.TestScript.ContentType.JSON);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu2016may.model.TestScript.ContentType.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.TestScript.SetupActionAssertComponent convertSetupActionAssertComponent(org.hl7.fhir.dstu3.model.TestScript.SetupActionAssertComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.TestScript.SetupActionAssertComponent tgt = new org.hl7.fhir.dstu2016may.model.TestScript.SetupActionAssertComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    if (src.hasLabel())
      tgt.setLabelElement(String14_30.convertString(src.getLabelElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String14_30.convertString(src.getDescriptionElement()));
    if (src.hasDirection())
      tgt.setDirectionElement(convertAssertionDirectionType(src.getDirectionElement()));
    if (src.hasCompareToSourceId())
      tgt.setCompareToSourceIdElement(String14_30.convertString(src.getCompareToSourceIdElement()));
    if (src.hasCompareToSourcePath())
      tgt.setCompareToSourcePathElement(String14_30.convertString(src.getCompareToSourcePathElement()));
    if (src.hasContentType())
      tgt.setContentTypeElement(convertContentType(src.getContentTypeElement()));
    if (src.hasHeaderField())
      tgt.setHeaderFieldElement(String14_30.convertString(src.getHeaderFieldElement()));
    if (src.hasMinimumId())
      tgt.setMinimumIdElement(String14_30.convertString(src.getMinimumIdElement()));
    if (src.hasNavigationLinks())
      tgt.setNavigationLinksElement(Boolean14_30.convertBoolean(src.getNavigationLinksElement()));
    if (src.hasOperator())
      tgt.setOperatorElement(convertAssertionOperatorType(src.getOperatorElement()));
    if (src.hasPath())
      tgt.setPathElement(String14_30.convertString(src.getPathElement()));
    if (src.hasResource())
      tgt.setResourceElement(Code14_30.convertCode(src.getResourceElement()));
    if (src.hasResponse())
      tgt.setResponseElement(convertAssertionResponseTypes(src.getResponseElement()));
    if (src.hasResponseCode())
      tgt.setResponseCodeElement(String14_30.convertString(src.getResponseCodeElement()));
    if (src.hasRule())
      tgt.setRule(convertSetupActionAssertRuleComponent(src.getRule()));
    if (src.hasRuleset())
      tgt.setRuleset(convertSetupActionAssertRulesetComponent(src.getRuleset()));
    if (src.hasSourceId())
      tgt.setSourceIdElement(Id14_30.convertId(src.getSourceIdElement()));
    if (src.hasValidateProfileId())
      tgt.setValidateProfileIdElement(Id14_30.convertId(src.getValidateProfileIdElement()));
    if (src.hasValue())
      tgt.setValueElement(String14_30.convertString(src.getValueElement()));
    if (src.hasWarningOnly())
      tgt.setWarningOnlyElement(Boolean14_30.convertBoolean(src.getWarningOnlyElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.TestScript.SetupActionAssertComponent convertSetupActionAssertComponent(org.hl7.fhir.dstu2016may.model.TestScript.SetupActionAssertComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.TestScript.SetupActionAssertComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.SetupActionAssertComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    if (src.hasLabel())
      tgt.setLabelElement(String14_30.convertString(src.getLabelElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String14_30.convertString(src.getDescriptionElement()));
    if (src.hasDirection())
      tgt.setDirectionElement(convertAssertionDirectionType(src.getDirectionElement()));
    if (src.hasCompareToSourceId())
      tgt.setCompareToSourceIdElement(String14_30.convertString(src.getCompareToSourceIdElement()));
    if (src.hasCompareToSourcePath())
      tgt.setCompareToSourcePathElement(String14_30.convertString(src.getCompareToSourcePathElement()));
    if (src.hasContentType())
      tgt.setContentTypeElement(convertContentType(src.getContentTypeElement()));
    if (src.hasHeaderField())
      tgt.setHeaderFieldElement(String14_30.convertString(src.getHeaderFieldElement()));
    if (src.hasMinimumId())
      tgt.setMinimumIdElement(String14_30.convertString(src.getMinimumIdElement()));
    if (src.hasNavigationLinks())
      tgt.setNavigationLinksElement(Boolean14_30.convertBoolean(src.getNavigationLinksElement()));
    if (src.hasOperator())
      tgt.setOperatorElement(convertAssertionOperatorType(src.getOperatorElement()));
    if (src.hasPath())
      tgt.setPathElement(String14_30.convertString(src.getPathElement()));
    if (src.hasResource())
      tgt.setResourceElement(Code14_30.convertCode(src.getResourceElement()));
    if (src.hasResponse())
      tgt.setResponseElement(convertAssertionResponseTypes(src.getResponseElement()));
    if (src.hasResponseCode())
      tgt.setResponseCodeElement(String14_30.convertString(src.getResponseCodeElement()));
    if (src.hasRule())
      tgt.setRule(convertSetupActionAssertRuleComponent(src.getRule()));
    if (src.hasRuleset())
      tgt.setRuleset(convertSetupActionAssertRulesetComponent(src.getRuleset()));
    if (src.hasSourceId())
      tgt.setSourceIdElement(Id14_30.convertId(src.getSourceIdElement()));
    if (src.hasValidateProfileId())
      tgt.setValidateProfileIdElement(Id14_30.convertId(src.getValidateProfileIdElement()));
    if (src.hasValue())
      tgt.setValueElement(String14_30.convertString(src.getValueElement()));
    if (src.hasWarningOnly())
      tgt.setWarningOnlyElement(Boolean14_30.convertBoolean(src.getWarningOnlyElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.TestScript.SetupActionAssertRuleComponent convertSetupActionAssertRuleComponent(org.hl7.fhir.dstu3.model.TestScript.ActionAssertRuleComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.TestScript.SetupActionAssertRuleComponent tgt = new org.hl7.fhir.dstu2016may.model.TestScript.SetupActionAssertRuleComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    for (org.hl7.fhir.dstu3.model.TestScript.ActionAssertRuleParamComponent t : src.getParam())
      tgt.addParam(convertSetupActionAssertRuleParamComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.TestScript.ActionAssertRuleComponent convertSetupActionAssertRuleComponent(org.hl7.fhir.dstu2016may.model.TestScript.SetupActionAssertRuleComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.TestScript.ActionAssertRuleComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.ActionAssertRuleComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    for (org.hl7.fhir.dstu2016may.model.TestScript.SetupActionAssertRuleParamComponent t : src.getParam())
      tgt.addParam(convertSetupActionAssertRuleParamComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.TestScript.ActionAssertRuleParamComponent convertSetupActionAssertRuleParamComponent(org.hl7.fhir.dstu2016may.model.TestScript.SetupActionAssertRuleParamComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.TestScript.ActionAssertRuleParamComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.ActionAssertRuleParamComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    if (src.hasNameElement())
      tgt.setNameElement(String14_30.convertString(src.getNameElement()));
    if (src.hasValue())
      tgt.setValueElement(String14_30.convertString(src.getValueElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.TestScript.SetupActionAssertRuleParamComponent convertSetupActionAssertRuleParamComponent(org.hl7.fhir.dstu3.model.TestScript.ActionAssertRuleParamComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.TestScript.SetupActionAssertRuleParamComponent tgt = new org.hl7.fhir.dstu2016may.model.TestScript.SetupActionAssertRuleParamComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    if (src.hasNameElement())
      tgt.setNameElement(String14_30.convertString(src.getNameElement()));
    if (src.hasValue())
      tgt.setValueElement(String14_30.convertString(src.getValueElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.TestScript.SetupActionAssertRulesetComponent convertSetupActionAssertRulesetComponent(org.hl7.fhir.dstu3.model.TestScript.ActionAssertRulesetComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.TestScript.SetupActionAssertRulesetComponent tgt = new org.hl7.fhir.dstu2016may.model.TestScript.SetupActionAssertRulesetComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    for (org.hl7.fhir.dstu3.model.TestScript.ActionAssertRulesetRuleComponent t : src.getRule())
      tgt.addRule(convertSetupActionAssertRulesetRuleComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.TestScript.ActionAssertRulesetComponent convertSetupActionAssertRulesetComponent(org.hl7.fhir.dstu2016may.model.TestScript.SetupActionAssertRulesetComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.TestScript.ActionAssertRulesetComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.ActionAssertRulesetComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    for (org.hl7.fhir.dstu2016may.model.TestScript.SetupActionAssertRulesetRuleComponent t : src.getRule())
      tgt.addRule(convertSetupActionAssertRulesetRuleComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.TestScript.ActionAssertRulesetRuleComponent convertSetupActionAssertRulesetRuleComponent(org.hl7.fhir.dstu2016may.model.TestScript.SetupActionAssertRulesetRuleComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.TestScript.ActionAssertRulesetRuleComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.ActionAssertRulesetRuleComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    for (org.hl7.fhir.dstu2016may.model.TestScript.SetupActionAssertRulesetRuleParamComponent t : src.getParam())
      tgt.addParam(convertSetupActionAssertRulesetRuleParamComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.TestScript.SetupActionAssertRulesetRuleComponent convertSetupActionAssertRulesetRuleComponent(org.hl7.fhir.dstu3.model.TestScript.ActionAssertRulesetRuleComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.TestScript.SetupActionAssertRulesetRuleComponent tgt = new org.hl7.fhir.dstu2016may.model.TestScript.SetupActionAssertRulesetRuleComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    for (org.hl7.fhir.dstu3.model.TestScript.ActionAssertRulesetRuleParamComponent t : src.getParam())
      tgt.addParam(convertSetupActionAssertRulesetRuleParamComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.TestScript.SetupActionAssertRulesetRuleParamComponent convertSetupActionAssertRulesetRuleParamComponent(org.hl7.fhir.dstu3.model.TestScript.ActionAssertRulesetRuleParamComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.TestScript.SetupActionAssertRulesetRuleParamComponent tgt = new org.hl7.fhir.dstu2016may.model.TestScript.SetupActionAssertRulesetRuleParamComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    if (src.hasNameElement())
      tgt.setNameElement(String14_30.convertString(src.getNameElement()));
    if (src.hasValue())
      tgt.setValueElement(String14_30.convertString(src.getValueElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.TestScript.ActionAssertRulesetRuleParamComponent convertSetupActionAssertRulesetRuleParamComponent(org.hl7.fhir.dstu2016may.model.TestScript.SetupActionAssertRulesetRuleParamComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.TestScript.ActionAssertRulesetRuleParamComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.ActionAssertRulesetRuleParamComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    if (src.hasNameElement())
      tgt.setNameElement(String14_30.convertString(src.getNameElement()));
    if (src.hasValue())
      tgt.setValueElement(String14_30.convertString(src.getValueElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.TestScript.SetupActionComponent convertSetupActionComponent(org.hl7.fhir.dstu3.model.TestScript.SetupActionComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.TestScript.SetupActionComponent tgt = new org.hl7.fhir.dstu2016may.model.TestScript.SetupActionComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    if (src.hasOperation())
      tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    if (src.hasAssert())
      tgt.setAssert(convertSetupActionAssertComponent(src.getAssert()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.TestScript.SetupActionComponent convertSetupActionComponent(org.hl7.fhir.dstu2016may.model.TestScript.SetupActionComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.TestScript.SetupActionComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.SetupActionComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    if (src.hasOperation())
      tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    if (src.hasAssert())
      tgt.setAssert(convertSetupActionAssertComponent(src.getAssert()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.TestScript.SetupActionOperationComponent convertSetupActionOperationComponent(org.hl7.fhir.dstu2016may.model.TestScript.SetupActionOperationComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.TestScript.SetupActionOperationComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.SetupActionOperationComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    if (src.hasType())
      tgt.setType(Code14_30.convertCoding(src.getType()));
    if (src.hasResource())
      tgt.setResourceElement(Code14_30.convertCode(src.getResourceElement()));
    if (src.hasLabel())
      tgt.setLabelElement(String14_30.convertString(src.getLabelElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String14_30.convertString(src.getDescriptionElement()));
    if (src.hasAccept())
      tgt.setAcceptElement(convertContentType(src.getAcceptElement()));
    if (src.hasContentType())
      tgt.setContentTypeElement(convertContentType(src.getContentTypeElement()));
    if (src.hasDestination())
      tgt.setDestinationElement(Integer14_30.convertInteger(src.getDestinationElement()));
    if (src.hasEncodeRequestUrl())
      tgt.setEncodeRequestUrlElement(Boolean14_30.convertBoolean(src.getEncodeRequestUrlElement()));
    if (src.hasOrigin())
      tgt.setOriginElement(Integer14_30.convertInteger(src.getOriginElement()));
    if (src.hasParams())
      tgt.setParamsElement(String14_30.convertString(src.getParamsElement()));
    for (org.hl7.fhir.dstu2016may.model.TestScript.SetupActionOperationRequestHeaderComponent t : src.getRequestHeader())
      tgt.addRequestHeader(convertSetupActionOperationRequestHeaderComponent(t));
    if (src.hasResponseId())
      tgt.setResponseIdElement(Id14_30.convertId(src.getResponseIdElement()));
    if (src.hasSourceId())
      tgt.setSourceIdElement(Id14_30.convertId(src.getSourceIdElement()));
    if (src.hasTargetId())
      tgt.setTargetId(src.getTargetId());
    if (src.hasUrl())
      tgt.setUrlElement(String14_30.convertString(src.getUrlElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.TestScript.SetupActionOperationComponent convertSetupActionOperationComponent(org.hl7.fhir.dstu3.model.TestScript.SetupActionOperationComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.TestScript.SetupActionOperationComponent tgt = new org.hl7.fhir.dstu2016may.model.TestScript.SetupActionOperationComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    if (src.hasResource())
      tgt.setResourceElement(Code14_30.convertCode(src.getResourceElement()));
    if (src.hasLabel())
      tgt.setLabelElement(String14_30.convertString(src.getLabelElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String14_30.convertString(src.getDescriptionElement()));
    if (src.hasAccept())
      tgt.setAcceptElement(convertContentType(src.getAcceptElement()));
    if (src.hasContentType())
      tgt.setContentTypeElement(convertContentType(src.getContentTypeElement()));
    if (src.hasDestination())
      tgt.setDestinationElement(Integer14_30.convertInteger(src.getDestinationElement()));
    if (src.hasEncodeRequestUrl())
      tgt.setEncodeRequestUrlElement(Boolean14_30.convertBoolean(src.getEncodeRequestUrlElement()));
    if (src.hasOrigin())
      tgt.setOriginElement(Integer14_30.convertInteger(src.getOriginElement()));
    if (src.hasParams())
      tgt.setParamsElement(String14_30.convertString(src.getParamsElement()));
    for (org.hl7.fhir.dstu3.model.TestScript.SetupActionOperationRequestHeaderComponent t : src.getRequestHeader())
      tgt.addRequestHeader(convertSetupActionOperationRequestHeaderComponent(t));
    if (src.hasResponseId())
      tgt.setResponseIdElement(Id14_30.convertId(src.getResponseIdElement()));
    if (src.hasSourceId())
      tgt.setSourceIdElement(Id14_30.convertId(src.getSourceIdElement()));
    if (src.hasTargetId())
      tgt.setTargetId(src.getTargetId());
    if (src.hasUrl())
      tgt.setUrlElement(String14_30.convertString(src.getUrlElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.TestScript.SetupActionOperationRequestHeaderComponent convertSetupActionOperationRequestHeaderComponent(org.hl7.fhir.dstu2016may.model.TestScript.SetupActionOperationRequestHeaderComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.TestScript.SetupActionOperationRequestHeaderComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.SetupActionOperationRequestHeaderComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    if (src.hasFieldElement())
      tgt.setFieldElement(String14_30.convertString(src.getFieldElement()));
    if (src.hasValueElement())
      tgt.setValueElement(String14_30.convertString(src.getValueElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.TestScript.SetupActionOperationRequestHeaderComponent convertSetupActionOperationRequestHeaderComponent(org.hl7.fhir.dstu3.model.TestScript.SetupActionOperationRequestHeaderComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.TestScript.SetupActionOperationRequestHeaderComponent tgt = new org.hl7.fhir.dstu2016may.model.TestScript.SetupActionOperationRequestHeaderComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    if (src.hasFieldElement())
      tgt.setFieldElement(String14_30.convertString(src.getFieldElement()));
    if (src.hasValueElement())
      tgt.setValueElement(String14_30.convertString(src.getValueElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.TestScript.TeardownActionComponent convertTeardownActionComponent(org.hl7.fhir.dstu2016may.model.TestScript.TeardownActionComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.TestScript.TeardownActionComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.TeardownActionComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    if (src.hasOperation())
      tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.TestScript.TeardownActionComponent convertTeardownActionComponent(org.hl7.fhir.dstu3.model.TestScript.TeardownActionComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.TestScript.TeardownActionComponent tgt = new org.hl7.fhir.dstu2016may.model.TestScript.TeardownActionComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    if (src.hasOperation())
      tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.TestScript.TestActionComponent convertTestActionComponent(org.hl7.fhir.dstu3.model.TestScript.TestActionComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.TestScript.TestActionComponent tgt = new org.hl7.fhir.dstu2016may.model.TestScript.TestActionComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    if (src.hasOperation())
      tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    if (src.hasAssert())
      tgt.setAssert(convertSetupActionAssertComponent(src.getAssert()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.TestScript.TestActionComponent convertTestActionComponent(org.hl7.fhir.dstu2016may.model.TestScript.TestActionComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.TestScript.TestActionComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.TestActionComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    if (src.hasOperation())
      tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    if (src.hasAssert())
      tgt.setAssert(convertSetupActionAssertComponent(src.getAssert()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.TestScript convertTestScript(org.hl7.fhir.dstu2016may.model.TestScript src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.TestScript tgt = new org.hl7.fhir.dstu3.model.TestScript();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyDomainResource(src, tgt);
    if (src.hasUrlElement())
      tgt.setUrlElement(Uri14_30.convertUri(src.getUrlElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String14_30.convertString(src.getVersionElement()));
    if (src.hasNameElement())
      tgt.setNameElement(String14_30.convertString(src.getNameElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations14_30.convertConformanceResourceStatus(src.getStatusElement()));
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier14_30.convertIdentifier(src.getIdentifier()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean14_30.convertBoolean(src.getExperimentalElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String14_30.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.dstu2016may.model.TestScript.TestScriptContactComponent t : src.getContact())
      tgt.addContact(convertTestScriptContactComponent(t));
    if (src.hasDate())
      tgt.setDateElement(DateTime14_30.convertDateTime(src.getDateElement()));
    if (src.hasDescription())
      tgt.setDescription(src.getDescription());
    for (org.hl7.fhir.dstu2016may.model.CodeableConcept t : src.getUseContext())
      if (VersionConvertor_14_30.isJurisdiction(t))
        tgt.addJurisdiction(CodeableConcept14_30.convertCodeableConcept(t));
      else
        tgt.addUseContext(CodeableConcept14_30.convertCodeableConceptToUsageContext(t));
    if (src.hasRequirements())
      tgt.setPurpose(src.getRequirements());
    if (src.hasCopyright())
      tgt.setCopyright(src.getCopyright());
    for (org.hl7.fhir.dstu2016may.model.TestScript.TestScriptOriginComponent t : src.getOrigin())
      tgt.addOrigin(convertTestScriptOriginComponent(t));
    for (org.hl7.fhir.dstu2016may.model.TestScript.TestScriptDestinationComponent t : src.getDestination())
      tgt.addDestination(convertTestScriptDestinationComponent(t));
    if (src.hasMetadata())
      tgt.setMetadata(convertTestScriptMetadataComponent(src.getMetadata()));
    for (org.hl7.fhir.dstu2016may.model.TestScript.TestScriptFixtureComponent t : src.getFixture())
      tgt.addFixture(convertTestScriptFixtureComponent(t));
    for (org.hl7.fhir.dstu2016may.model.Reference t : src.getProfile())
      tgt.addProfile(Reference14_30.convertReference(t));
    for (org.hl7.fhir.dstu2016may.model.TestScript.TestScriptVariableComponent t : src.getVariable())
      tgt.addVariable(convertTestScriptVariableComponent(t));
    for (org.hl7.fhir.dstu2016may.model.TestScript.TestScriptRuleComponent t : src.getRule())
      tgt.addRule(convertTestScriptRuleComponent(t));
    for (org.hl7.fhir.dstu2016may.model.TestScript.TestScriptRulesetComponent t : src.getRuleset())
      tgt.addRuleset(convertTestScriptRulesetComponent(t));
    if (src.hasSetup())
      tgt.setSetup(convertTestScriptSetupComponent(src.getSetup()));
    for (org.hl7.fhir.dstu2016may.model.TestScript.TestScriptTestComponent t : src.getTest())
      tgt.addTest(convertTestScriptTestComponent(t));
    if (src.hasTeardown())
      tgt.setTeardown(convertTestScriptTeardownComponent(src.getTeardown()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.TestScript convertTestScript(org.hl7.fhir.dstu3.model.TestScript src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.TestScript tgt = new org.hl7.fhir.dstu2016may.model.TestScript();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyDomainResource(src, tgt);
    if (src.hasUrlElement())
      tgt.setUrlElement(Uri14_30.convertUri(src.getUrlElement()));
    if (src.hasVersion())
      tgt.setVersionElement(String14_30.convertString(src.getVersionElement()));
    if (src.hasNameElement())
      tgt.setNameElement(String14_30.convertString(src.getNameElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations14_30.convertConformanceResourceStatus(src.getStatusElement()));
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier14_30.convertIdentifier(src.getIdentifier()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean14_30.convertBoolean(src.getExperimentalElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String14_30.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.dstu3.model.ContactDetail t : src.getContact())
      tgt.addContact(convertTestScriptContactComponent(t));
    if (src.hasDate())
      tgt.setDateElement(DateTime14_30.convertDateTime(src.getDateElement()));
    if (src.hasDescription())
      tgt.setDescription(src.getDescription());
    for (org.hl7.fhir.dstu3.model.UsageContext t : src.getUseContext())
      if (t.hasValueCodeableConcept())
        tgt.addUseContext(CodeableConcept14_30.convertCodeableConcept(t.getValueCodeableConcept()));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getJurisdiction())
      tgt.addUseContext(CodeableConcept14_30.convertCodeableConcept(t));
    if (src.hasPurpose())
      tgt.setRequirements(src.getPurpose());
    if (src.hasCopyright())
      tgt.setCopyright(src.getCopyright());
    for (org.hl7.fhir.dstu3.model.TestScript.TestScriptOriginComponent t : src.getOrigin())
      tgt.addOrigin(convertTestScriptOriginComponent(t));
    for (org.hl7.fhir.dstu3.model.TestScript.TestScriptDestinationComponent t : src.getDestination())
      tgt.addDestination(convertTestScriptDestinationComponent(t));
    if (src.hasMetadata())
      tgt.setMetadata(convertTestScriptMetadataComponent(src.getMetadata()));
    for (org.hl7.fhir.dstu3.model.TestScript.TestScriptFixtureComponent t : src.getFixture())
      tgt.addFixture(convertTestScriptFixtureComponent(t));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getProfile()) tgt.addProfile(Reference14_30.convertReference(t));
    for (org.hl7.fhir.dstu3.model.TestScript.TestScriptVariableComponent t : src.getVariable())
      tgt.addVariable(convertTestScriptVariableComponent(t));
    for (org.hl7.fhir.dstu3.model.TestScript.TestScriptRuleComponent t : src.getRule())
      tgt.addRule(convertTestScriptRuleComponent(t));
    for (org.hl7.fhir.dstu3.model.TestScript.TestScriptRulesetComponent t : src.getRuleset())
      tgt.addRuleset(convertTestScriptRulesetComponent(t));
    if (src.hasSetup())
      tgt.setSetup(convertTestScriptSetupComponent(src.getSetup()));
    for (org.hl7.fhir.dstu3.model.TestScript.TestScriptTestComponent t : src.getTest())
      tgt.addTest(convertTestScriptTestComponent(t));
    if (src.hasTeardown())
      tgt.setTeardown(convertTestScriptTeardownComponent(src.getTeardown()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.TestScript.TestScriptContactComponent convertTestScriptContactComponent(org.hl7.fhir.dstu3.model.ContactDetail src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.TestScript.TestScriptContactComponent tgt = new org.hl7.fhir.dstu2016may.model.TestScript.TestScriptContactComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String14_30.convertString(src.getNameElement()));
    for (org.hl7.fhir.dstu3.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint14_30.convertContactPoint(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.ContactDetail convertTestScriptContactComponent(org.hl7.fhir.dstu2016may.model.TestScript.TestScriptContactComponent src) throws FHIRException {
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

  public static org.hl7.fhir.dstu2016may.model.TestScript.TestScriptDestinationComponent convertTestScriptDestinationComponent(org.hl7.fhir.dstu3.model.TestScript.TestScriptDestinationComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.TestScript.TestScriptDestinationComponent tgt = new org.hl7.fhir.dstu2016may.model.TestScript.TestScriptDestinationComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    if (src.hasIndexElement())
      tgt.setIndexElement(Integer14_30.convertInteger(src.getIndexElement()));
    if (src.hasProfile())
      tgt.setProfile(Code14_30.convertCoding(src.getProfile()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.TestScript.TestScriptDestinationComponent convertTestScriptDestinationComponent(org.hl7.fhir.dstu2016may.model.TestScript.TestScriptDestinationComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.TestScript.TestScriptDestinationComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.TestScriptDestinationComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    if (src.hasIndexElement())
      tgt.setIndexElement(Integer14_30.convertInteger(src.getIndexElement()));
    if (src.hasProfile())
      tgt.setProfile(Code14_30.convertCoding(src.getProfile()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.TestScript.TestScriptFixtureComponent convertTestScriptFixtureComponent(org.hl7.fhir.dstu2016may.model.TestScript.TestScriptFixtureComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.TestScript.TestScriptFixtureComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.TestScriptFixtureComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    if (src.hasAutocreate())
      tgt.setAutocreateElement(Boolean14_30.convertBoolean(src.getAutocreateElement()));
    if (src.hasAutodelete())
      tgt.setAutodeleteElement(Boolean14_30.convertBoolean(src.getAutodeleteElement()));
    if (src.hasResource())
      tgt.setResource(Reference14_30.convertReference(src.getResource()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.TestScript.TestScriptFixtureComponent convertTestScriptFixtureComponent(org.hl7.fhir.dstu3.model.TestScript.TestScriptFixtureComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.TestScript.TestScriptFixtureComponent tgt = new org.hl7.fhir.dstu2016may.model.TestScript.TestScriptFixtureComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    if (src.hasAutocreate())
      tgt.setAutocreateElement(Boolean14_30.convertBoolean(src.getAutocreateElement()));
    if (src.hasAutodelete())
      tgt.setAutodeleteElement(Boolean14_30.convertBoolean(src.getAutodeleteElement()));
    if (src.hasResource())
      tgt.setResource(Reference14_30.convertReference(src.getResource()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.TestScript.TestScriptMetadataCapabilityComponent convertTestScriptMetadataCapabilityComponent(org.hl7.fhir.dstu2016may.model.TestScript.TestScriptMetadataCapabilityComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.TestScript.TestScriptMetadataCapabilityComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.TestScriptMetadataCapabilityComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    if (src.hasRequired())
      tgt.setRequiredElement(Boolean14_30.convertBoolean(src.getRequiredElement()));
    if (src.hasValidated())
      tgt.setValidatedElement(Boolean14_30.convertBoolean(src.getValidatedElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String14_30.convertString(src.getDescriptionElement()));
    for (org.hl7.fhir.dstu2016may.model.IntegerType t : src.getOrigin()) tgt.addOrigin(t.getValue());
    if (src.hasDestination())
      tgt.setDestinationElement(Integer14_30.convertInteger(src.getDestinationElement()));
    for (org.hl7.fhir.dstu2016may.model.UriType t : src.getLink()) tgt.addLink(t.getValue());
    if (src.hasConformance())
      tgt.setCapabilities(Reference14_30.convertReference(src.getConformance()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.TestScript.TestScriptMetadataCapabilityComponent convertTestScriptMetadataCapabilityComponent(org.hl7.fhir.dstu3.model.TestScript.TestScriptMetadataCapabilityComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.TestScript.TestScriptMetadataCapabilityComponent tgt = new org.hl7.fhir.dstu2016may.model.TestScript.TestScriptMetadataCapabilityComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    if (src.hasRequired())
      tgt.setRequiredElement(Boolean14_30.convertBoolean(src.getRequiredElement()));
    if (src.hasValidated())
      tgt.setValidatedElement(Boolean14_30.convertBoolean(src.getValidatedElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String14_30.convertString(src.getDescriptionElement()));
    for (org.hl7.fhir.dstu3.model.IntegerType t : src.getOrigin()) tgt.addOrigin(t.getValue());
    if (src.hasDestination())
      tgt.setDestinationElement(Integer14_30.convertInteger(src.getDestinationElement()));
    for (org.hl7.fhir.dstu3.model.UriType t : src.getLink()) tgt.addLink(t.getValue());
    if (src.hasCapabilities())
      tgt.setConformance(Reference14_30.convertReference(src.getCapabilities()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.TestScript.TestScriptMetadataComponent convertTestScriptMetadataComponent(org.hl7.fhir.dstu2016may.model.TestScript.TestScriptMetadataComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.TestScript.TestScriptMetadataComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.TestScriptMetadataComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    for (org.hl7.fhir.dstu2016may.model.TestScript.TestScriptMetadataLinkComponent t : src.getLink())
      tgt.addLink(convertTestScriptMetadataLinkComponent(t));
    for (org.hl7.fhir.dstu2016may.model.TestScript.TestScriptMetadataCapabilityComponent t : src.getCapability())
      tgt.addCapability(convertTestScriptMetadataCapabilityComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.TestScript.TestScriptMetadataComponent convertTestScriptMetadataComponent(org.hl7.fhir.dstu3.model.TestScript.TestScriptMetadataComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.TestScript.TestScriptMetadataComponent tgt = new org.hl7.fhir.dstu2016may.model.TestScript.TestScriptMetadataComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    for (org.hl7.fhir.dstu3.model.TestScript.TestScriptMetadataLinkComponent t : src.getLink())
      tgt.addLink(convertTestScriptMetadataLinkComponent(t));
    for (org.hl7.fhir.dstu3.model.TestScript.TestScriptMetadataCapabilityComponent t : src.getCapability())
      tgt.addCapability(convertTestScriptMetadataCapabilityComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.TestScript.TestScriptMetadataLinkComponent convertTestScriptMetadataLinkComponent(org.hl7.fhir.dstu2016may.model.TestScript.TestScriptMetadataLinkComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.TestScript.TestScriptMetadataLinkComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.TestScriptMetadataLinkComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    if (src.hasUrlElement())
      tgt.setUrlElement(Uri14_30.convertUri(src.getUrlElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String14_30.convertString(src.getDescriptionElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.TestScript.TestScriptMetadataLinkComponent convertTestScriptMetadataLinkComponent(org.hl7.fhir.dstu3.model.TestScript.TestScriptMetadataLinkComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.TestScript.TestScriptMetadataLinkComponent tgt = new org.hl7.fhir.dstu2016may.model.TestScript.TestScriptMetadataLinkComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    if (src.hasUrlElement())
      tgt.setUrlElement(Uri14_30.convertUri(src.getUrlElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String14_30.convertString(src.getDescriptionElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.TestScript.TestScriptOriginComponent convertTestScriptOriginComponent(org.hl7.fhir.dstu3.model.TestScript.TestScriptOriginComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.TestScript.TestScriptOriginComponent tgt = new org.hl7.fhir.dstu2016may.model.TestScript.TestScriptOriginComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    if (src.hasIndexElement())
      tgt.setIndexElement(Integer14_30.convertInteger(src.getIndexElement()));
    if (src.hasProfile())
      tgt.setProfile(Code14_30.convertCoding(src.getProfile()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.TestScript.TestScriptOriginComponent convertTestScriptOriginComponent(org.hl7.fhir.dstu2016may.model.TestScript.TestScriptOriginComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.TestScript.TestScriptOriginComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.TestScriptOriginComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    if (src.hasIndexElement())
      tgt.setIndexElement(Integer14_30.convertInteger(src.getIndexElement()));
    if (src.hasProfile())
      tgt.setProfile(Code14_30.convertCoding(src.getProfile()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.TestScript.TestScriptRuleComponent convertTestScriptRuleComponent(org.hl7.fhir.dstu2016may.model.TestScript.TestScriptRuleComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.TestScript.TestScriptRuleComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.TestScriptRuleComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    if (src.hasResource())
      tgt.setResource(Reference14_30.convertReference(src.getResource()));
    for (org.hl7.fhir.dstu2016may.model.TestScript.TestScriptRuleParamComponent t : src.getParam())
      tgt.addParam(convertTestScriptRuleParamComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.TestScript.TestScriptRuleComponent convertTestScriptRuleComponent(org.hl7.fhir.dstu3.model.TestScript.TestScriptRuleComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.TestScript.TestScriptRuleComponent tgt = new org.hl7.fhir.dstu2016may.model.TestScript.TestScriptRuleComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    if (src.hasResource())
      tgt.setResource(Reference14_30.convertReference(src.getResource()));
    for (org.hl7.fhir.dstu3.model.TestScript.RuleParamComponent t : src.getParam())
      tgt.addParam(convertTestScriptRuleParamComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.TestScript.RuleParamComponent convertTestScriptRuleParamComponent(org.hl7.fhir.dstu2016may.model.TestScript.TestScriptRuleParamComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.TestScript.RuleParamComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.RuleParamComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    if (src.hasNameElement())
      tgt.setNameElement(String14_30.convertString(src.getNameElement()));
    if (src.hasValue())
      tgt.setValueElement(String14_30.convertString(src.getValueElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.TestScript.TestScriptRuleParamComponent convertTestScriptRuleParamComponent(org.hl7.fhir.dstu3.model.TestScript.RuleParamComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.TestScript.TestScriptRuleParamComponent tgt = new org.hl7.fhir.dstu2016may.model.TestScript.TestScriptRuleParamComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    if (src.hasNameElement())
      tgt.setNameElement(String14_30.convertString(src.getNameElement()));
    if (src.hasValue())
      tgt.setValueElement(String14_30.convertString(src.getValueElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.TestScript.TestScriptRulesetComponent convertTestScriptRulesetComponent(org.hl7.fhir.dstu2016may.model.TestScript.TestScriptRulesetComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.TestScript.TestScriptRulesetComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.TestScriptRulesetComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    if (src.hasResource())
      tgt.setResource(Reference14_30.convertReference(src.getResource()));
    for (org.hl7.fhir.dstu2016may.model.TestScript.TestScriptRulesetRuleComponent t : src.getRule())
      tgt.addRule(convertTestScriptRulesetRuleComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.TestScript.TestScriptRulesetComponent convertTestScriptRulesetComponent(org.hl7.fhir.dstu3.model.TestScript.TestScriptRulesetComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.TestScript.TestScriptRulesetComponent tgt = new org.hl7.fhir.dstu2016may.model.TestScript.TestScriptRulesetComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    if (src.hasResource())
      tgt.setResource(Reference14_30.convertReference(src.getResource()));
    for (org.hl7.fhir.dstu3.model.TestScript.RulesetRuleComponent t : src.getRule())
      tgt.addRule(convertTestScriptRulesetRuleComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.TestScript.TestScriptRulesetRuleComponent convertTestScriptRulesetRuleComponent(org.hl7.fhir.dstu3.model.TestScript.RulesetRuleComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.TestScript.TestScriptRulesetRuleComponent tgt = new org.hl7.fhir.dstu2016may.model.TestScript.TestScriptRulesetRuleComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    for (org.hl7.fhir.dstu3.model.TestScript.RulesetRuleParamComponent t : src.getParam())
      tgt.addParam(convertTestScriptRulesetRuleParamComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.TestScript.RulesetRuleComponent convertTestScriptRulesetRuleComponent(org.hl7.fhir.dstu2016may.model.TestScript.TestScriptRulesetRuleComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.TestScript.RulesetRuleComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.RulesetRuleComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    for (org.hl7.fhir.dstu2016may.model.TestScript.TestScriptRulesetRuleParamComponent t : src.getParam())
      tgt.addParam(convertTestScriptRulesetRuleParamComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.TestScript.TestScriptRulesetRuleParamComponent convertTestScriptRulesetRuleParamComponent(org.hl7.fhir.dstu3.model.TestScript.RulesetRuleParamComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.TestScript.TestScriptRulesetRuleParamComponent tgt = new org.hl7.fhir.dstu2016may.model.TestScript.TestScriptRulesetRuleParamComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    if (src.hasNameElement())
      tgt.setNameElement(String14_30.convertString(src.getNameElement()));
    if (src.hasValue())
      tgt.setValueElement(String14_30.convertString(src.getValueElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.TestScript.RulesetRuleParamComponent convertTestScriptRulesetRuleParamComponent(org.hl7.fhir.dstu2016may.model.TestScript.TestScriptRulesetRuleParamComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.TestScript.RulesetRuleParamComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.RulesetRuleParamComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    if (src.hasNameElement())
      tgt.setNameElement(String14_30.convertString(src.getNameElement()));
    if (src.hasValue())
      tgt.setValueElement(String14_30.convertString(src.getValueElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.TestScript.TestScriptSetupComponent convertTestScriptSetupComponent(org.hl7.fhir.dstu3.model.TestScript.TestScriptSetupComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.TestScript.TestScriptSetupComponent tgt = new org.hl7.fhir.dstu2016may.model.TestScript.TestScriptSetupComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    for (org.hl7.fhir.dstu3.model.TestScript.SetupActionComponent t : src.getAction())
      tgt.addAction(convertSetupActionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.TestScript.TestScriptSetupComponent convertTestScriptSetupComponent(org.hl7.fhir.dstu2016may.model.TestScript.TestScriptSetupComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.TestScript.TestScriptSetupComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.TestScriptSetupComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    for (org.hl7.fhir.dstu2016may.model.TestScript.SetupActionComponent t : src.getAction())
      tgt.addAction(convertSetupActionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.TestScript.TestScriptTeardownComponent convertTestScriptTeardownComponent(org.hl7.fhir.dstu3.model.TestScript.TestScriptTeardownComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.TestScript.TestScriptTeardownComponent tgt = new org.hl7.fhir.dstu2016may.model.TestScript.TestScriptTeardownComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    for (org.hl7.fhir.dstu3.model.TestScript.TeardownActionComponent t : src.getAction())
      tgt.addAction(convertTeardownActionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.TestScript.TestScriptTeardownComponent convertTestScriptTeardownComponent(org.hl7.fhir.dstu2016may.model.TestScript.TestScriptTeardownComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.TestScript.TestScriptTeardownComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.TestScriptTeardownComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    for (org.hl7.fhir.dstu2016may.model.TestScript.TeardownActionComponent t : src.getAction())
      tgt.addAction(convertTeardownActionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.TestScript.TestScriptTestComponent convertTestScriptTestComponent(org.hl7.fhir.dstu3.model.TestScript.TestScriptTestComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.TestScript.TestScriptTestComponent tgt = new org.hl7.fhir.dstu2016may.model.TestScript.TestScriptTestComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String14_30.convertString(src.getNameElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String14_30.convertString(src.getDescriptionElement()));
    for (org.hl7.fhir.dstu3.model.TestScript.TestActionComponent t : src.getAction())
      tgt.addAction(convertTestActionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.TestScript.TestScriptTestComponent convertTestScriptTestComponent(org.hl7.fhir.dstu2016may.model.TestScript.TestScriptTestComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.TestScript.TestScriptTestComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.TestScriptTestComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String14_30.convertString(src.getNameElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String14_30.convertString(src.getDescriptionElement()));
    for (org.hl7.fhir.dstu2016may.model.TestScript.TestActionComponent t : src.getAction())
      tgt.addAction(convertTestActionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.TestScript.TestScriptVariableComponent convertTestScriptVariableComponent(org.hl7.fhir.dstu3.model.TestScript.TestScriptVariableComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.TestScript.TestScriptVariableComponent tgt = new org.hl7.fhir.dstu2016may.model.TestScript.TestScriptVariableComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    if (src.hasNameElement())
      tgt.setNameElement(String14_30.convertString(src.getNameElement()));
    if (src.hasDefaultValue())
      tgt.setDefaultValueElement(String14_30.convertString(src.getDefaultValueElement()));
    if (src.hasHeaderField())
      tgt.setHeaderFieldElement(String14_30.convertString(src.getHeaderFieldElement()));
    if (src.hasPath())
      tgt.setPathElement(String14_30.convertString(src.getPathElement()));
    if (src.hasSourceId())
      tgt.setSourceIdElement(Id14_30.convertId(src.getSourceIdElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.TestScript.TestScriptVariableComponent convertTestScriptVariableComponent(org.hl7.fhir.dstu2016may.model.TestScript.TestScriptVariableComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.TestScript.TestScriptVariableComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.TestScriptVariableComponent();
    ConversionContext14_30.INSTANCE.getVersionConvertor_14_30().copyElement(src, tgt);
    if (src.hasNameElement())
      tgt.setNameElement(String14_30.convertString(src.getNameElement()));
    if (src.hasDefaultValue())
      tgt.setDefaultValueElement(String14_30.convertString(src.getDefaultValueElement()));
    if (src.hasHeaderField())
      tgt.setHeaderFieldElement(String14_30.convertString(src.getHeaderFieldElement()));
    if (src.hasPath())
      tgt.setPathElement(String14_30.convertString(src.getPathElement()));
    if (src.hasSourceId())
      tgt.setSourceIdElement(Id14_30.convertId(src.getSourceIdElement()));
    return tgt;
  }
}