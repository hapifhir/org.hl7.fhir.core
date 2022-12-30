package org.hl7.fhir.convertors.conv10_50.resources10_50;

import org.hl7.fhir.convertors.context.ConversionContext10_50;
import org.hl7.fhir.convertors.conv10_50.VersionConvertor_10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.Reference10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.CodeableConcept10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.Coding10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.ContactPoint10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.complextypes10_50.Identifier10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.Boolean10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.DateTime10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.Id10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.Integer10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.String10_50;
import org.hl7.fhir.convertors.conv10_50.datatypes10_50.primitivetypes10_50.Uri10_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.CanonicalType;

public class TestScript10_50 {

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.TestScript.AssertionDirectionType> convertAssertionDirectionType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestScript.AssertionDirectionType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.TestScript.AssertionDirectionType> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.TestScript.AssertionDirectionTypeEnumFactory());
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case RESPONSE:
        tgt.setValue(org.hl7.fhir.dstu2.model.TestScript.AssertionDirectionType.RESPONSE);
        break;
      case REQUEST:
        tgt.setValue(org.hl7.fhir.dstu2.model.TestScript.AssertionDirectionType.REQUEST);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu2.model.TestScript.AssertionDirectionType.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestScript.AssertionDirectionType> convertAssertionDirectionType(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.TestScript.AssertionDirectionType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestScript.AssertionDirectionType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.TestScript.AssertionDirectionTypeEnumFactory());
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case RESPONSE:
        tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionDirectionType.RESPONSE);
        break;
      case REQUEST:
        tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionDirectionType.REQUEST);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionDirectionType.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.TestScript.AssertionOperatorType> convertAssertionOperatorType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestScript.AssertionOperatorType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.TestScript.AssertionOperatorType> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.TestScript.AssertionOperatorTypeEnumFactory());
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case EQUALS:
        tgt.setValue(org.hl7.fhir.dstu2.model.TestScript.AssertionOperatorType.EQUALS);
        break;
      case NOTEQUALS:
        tgt.setValue(org.hl7.fhir.dstu2.model.TestScript.AssertionOperatorType.NOTEQUALS);
        break;
      case IN:
        tgt.setValue(org.hl7.fhir.dstu2.model.TestScript.AssertionOperatorType.IN);
        break;
      case NOTIN:
        tgt.setValue(org.hl7.fhir.dstu2.model.TestScript.AssertionOperatorType.NOTIN);
        break;
      case GREATERTHAN:
        tgt.setValue(org.hl7.fhir.dstu2.model.TestScript.AssertionOperatorType.GREATERTHAN);
        break;
      case LESSTHAN:
        tgt.setValue(org.hl7.fhir.dstu2.model.TestScript.AssertionOperatorType.LESSTHAN);
        break;
      case EMPTY:
        tgt.setValue(org.hl7.fhir.dstu2.model.TestScript.AssertionOperatorType.EMPTY);
        break;
      case NOTEMPTY:
        tgt.setValue(org.hl7.fhir.dstu2.model.TestScript.AssertionOperatorType.NOTEMPTY);
        break;
      case CONTAINS:
        tgt.setValue(org.hl7.fhir.dstu2.model.TestScript.AssertionOperatorType.CONTAINS);
        break;
      case NOTCONTAINS:
        tgt.setValue(org.hl7.fhir.dstu2.model.TestScript.AssertionOperatorType.NOTCONTAINS);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu2.model.TestScript.AssertionOperatorType.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestScript.AssertionOperatorType> convertAssertionOperatorType(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.TestScript.AssertionOperatorType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestScript.AssertionOperatorType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.TestScript.AssertionOperatorTypeEnumFactory());
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case EQUALS:
        tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionOperatorType.EQUALS);
        break;
      case NOTEQUALS:
        tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionOperatorType.NOTEQUALS);
        break;
      case IN:
        tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionOperatorType.IN);
        break;
      case NOTIN:
        tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionOperatorType.NOTIN);
        break;
      case GREATERTHAN:
        tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionOperatorType.GREATERTHAN);
        break;
      case LESSTHAN:
        tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionOperatorType.LESSTHAN);
        break;
      case EMPTY:
        tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionOperatorType.EMPTY);
        break;
      case NOTEMPTY:
        tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionOperatorType.NOTEMPTY);
        break;
      case CONTAINS:
        tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionOperatorType.CONTAINS);
        break;
      case NOTCONTAINS:
        tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionOperatorType.NOTCONTAINS);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionOperatorType.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestScript.AssertionResponseTypes> convertAssertionResponseTypes(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.TestScript.AssertionResponseTypes> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestScript.AssertionResponseTypes> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.TestScript.AssertionResponseTypesEnumFactory());
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case OKAY:
        tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionResponseTypes.OKAY);
        break;
      case CREATED:
        tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionResponseTypes.CREATED);
        break;
      case NOCONTENT:
        tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionResponseTypes.NOCONTENT);
        break;
      case NOTMODIFIED:
        tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionResponseTypes.NOTMODIFIED);
        break;
      case BAD:
        tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionResponseTypes.BAD);
        break;
      case FORBIDDEN:
        tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionResponseTypes.FORBIDDEN);
        break;
      case NOTFOUND:
        tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionResponseTypes.NOTFOUND);
        break;
      case METHODNOTALLOWED:
        tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionResponseTypes.METHODNOTALLOWED);
        break;
      case CONFLICT:
        tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionResponseTypes.CONFLICT);
        break;
      case GONE:
        tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionResponseTypes.GONE);
        break;
      case PRECONDITIONFAILED:
        tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionResponseTypes.PRECONDITIONFAILED);
        break;
      case UNPROCESSABLE:
        tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionResponseTypes.UNPROCESSABLE);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionResponseTypes.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.TestScript.AssertionResponseTypes> convertAssertionResponseTypes(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestScript.AssertionResponseTypes> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.TestScript.AssertionResponseTypes> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.TestScript.AssertionResponseTypesEnumFactory());
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case OKAY:
        tgt.setValue(org.hl7.fhir.dstu2.model.TestScript.AssertionResponseTypes.OKAY);
        break;
      case CREATED:
        tgt.setValue(org.hl7.fhir.dstu2.model.TestScript.AssertionResponseTypes.CREATED);
        break;
      case NOCONTENT:
        tgt.setValue(org.hl7.fhir.dstu2.model.TestScript.AssertionResponseTypes.NOCONTENT);
        break;
      case NOTMODIFIED:
        tgt.setValue(org.hl7.fhir.dstu2.model.TestScript.AssertionResponseTypes.NOTMODIFIED);
        break;
      case BAD:
        tgt.setValue(org.hl7.fhir.dstu2.model.TestScript.AssertionResponseTypes.BAD);
        break;
      case FORBIDDEN:
        tgt.setValue(org.hl7.fhir.dstu2.model.TestScript.AssertionResponseTypes.FORBIDDEN);
        break;
      case NOTFOUND:
        tgt.setValue(org.hl7.fhir.dstu2.model.TestScript.AssertionResponseTypes.NOTFOUND);
        break;
      case METHODNOTALLOWED:
        tgt.setValue(org.hl7.fhir.dstu2.model.TestScript.AssertionResponseTypes.METHODNOTALLOWED);
        break;
      case CONFLICT:
        tgt.setValue(org.hl7.fhir.dstu2.model.TestScript.AssertionResponseTypes.CONFLICT);
        break;
      case GONE:
        tgt.setValue(org.hl7.fhir.dstu2.model.TestScript.AssertionResponseTypes.GONE);
        break;
      case PRECONDITIONFAILED:
        tgt.setValue(org.hl7.fhir.dstu2.model.TestScript.AssertionResponseTypes.PRECONDITIONFAILED);
        break;
      case UNPROCESSABLE:
        tgt.setValue(org.hl7.fhir.dstu2.model.TestScript.AssertionResponseTypes.UNPROCESSABLE);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu2.model.TestScript.AssertionResponseTypes.NULL);
        break;
    }
    return tgt;
  }

  static public String convertContentType(org.hl7.fhir.dstu2.model.TestScript.ContentType src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
      case XML:
        return "application/fhir+xml";
      case JSON:
        return "application/fhir+json";
      default:
        return null;
    }
  }

  static public org.hl7.fhir.dstu2.model.TestScript.ContentType convertContentType(String src) throws FHIRException {
    if (src == null)
      return null;
    if (src.contains("xml"))
      return org.hl7.fhir.dstu2.model.TestScript.ContentType.XML;
    if (src.contains("json"))
      return org.hl7.fhir.dstu2.model.TestScript.ContentType.JSON;
    return org.hl7.fhir.dstu2.model.TestScript.ContentType.NULL;
  }

  public static org.hl7.fhir.r5.model.TestScript.SetupActionAssertComponent convertSetupActionAssertComponent(org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupActionAssertComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.TestScript.SetupActionAssertComponent tgt = new org.hl7.fhir.r5.model.TestScript.SetupActionAssertComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    if (src.hasLabelElement())
      tgt.setLabelElement(String10_50.convertString(src.getLabelElement()));
    if (src.hasDescriptionElement())
      tgt.setDescriptionElement(String10_50.convertString(src.getDescriptionElement()));
    if (src.hasDirection())
      tgt.setDirectionElement(convertAssertionDirectionType(src.getDirectionElement()));
    if (src.hasCompareToSourceIdElement())
      tgt.setCompareToSourceIdElement(String10_50.convertString(src.getCompareToSourceIdElement()));
    if (src.hasCompareToSourcePathElement())
      tgt.setCompareToSourcePathElement(String10_50.convertString(src.getCompareToSourcePathElement()));
    if (src.hasContentType())
      tgt.setContentType(convertContentType(src.getContentType()));
    if (src.hasHeaderFieldElement())
      tgt.setHeaderFieldElement(String10_50.convertString(src.getHeaderFieldElement()));
    if (src.hasMinimumIdElement())
      tgt.setMinimumIdElement(String10_50.convertString(src.getMinimumIdElement()));
    if (src.hasNavigationLinksElement())
      tgt.setNavigationLinksElement(Boolean10_50.convertBoolean(src.getNavigationLinksElement()));
    if (src.hasOperator())
      tgt.setOperatorElement(convertAssertionOperatorType(src.getOperatorElement()));
    if (src.hasPathElement())
      tgt.setPathElement(String10_50.convertString(src.getPathElement()));
    if (src.hasResource())
      tgt.setResource(src.getResource());
    if (src.hasResponse())
      tgt.setResponseElement(convertAssertionResponseTypes(src.getResponseElement()));
    if (src.hasResponseCodeElement())
      tgt.setResponseCodeElement(String10_50.convertString(src.getResponseCodeElement()));
    if (src.hasSourceIdElement())
      tgt.setSourceIdElement(Id10_50.convertId(src.getSourceIdElement()));
    if (src.hasValidateProfileIdElement())
      tgt.setValidateProfileIdElement(Id10_50.convertId(src.getValidateProfileIdElement()));
    if (src.hasValueElement())
      tgt.setValueElement(String10_50.convertString(src.getValueElement()));
    if (src.hasWarningOnlyElement())
      tgt.setWarningOnlyElement(Boolean10_50.convertBoolean(src.getWarningOnlyElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupActionAssertComponent convertSetupActionAssertComponent(org.hl7.fhir.r5.model.TestScript.SetupActionAssertComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupActionAssertComponent tgt = new org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupActionAssertComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    if (src.hasLabelElement())
      tgt.setLabelElement(String10_50.convertString(src.getLabelElement()));
    if (src.hasDescriptionElement())
      tgt.setDescriptionElement(String10_50.convertString(src.getDescriptionElement()));
    if (src.hasDirection())
      tgt.setDirectionElement(convertAssertionDirectionType(src.getDirectionElement()));
    if (src.hasCompareToSourceIdElement())
      tgt.setCompareToSourceIdElement(String10_50.convertString(src.getCompareToSourceIdElement()));
    if (src.hasCompareToSourcePathElement())
      tgt.setCompareToSourcePathElement(String10_50.convertString(src.getCompareToSourcePathElement()));
    if (src.hasContentType())
      tgt.setContentType(convertContentType(src.getContentType()));
    if (src.hasHeaderFieldElement())
      tgt.setHeaderFieldElement(String10_50.convertString(src.getHeaderFieldElement()));
    if (src.hasMinimumIdElement())
      tgt.setMinimumIdElement(String10_50.convertString(src.getMinimumIdElement()));
    if (src.hasNavigationLinksElement())
      tgt.setNavigationLinksElement(Boolean10_50.convertBoolean(src.getNavigationLinksElement()));
    if (src.hasOperator())
      tgt.setOperatorElement(convertAssertionOperatorType(src.getOperatorElement()));
    if (src.hasPathElement())
      tgt.setPathElement(String10_50.convertString(src.getPathElement()));
    tgt.setResource(src.getResource());
    if (src.hasResponse())
      tgt.setResponseElement(convertAssertionResponseTypes(src.getResponseElement()));
    if (src.hasResponseCodeElement())
      tgt.setResponseCodeElement(String10_50.convertString(src.getResponseCodeElement()));
    if (src.hasSourceIdElement())
      tgt.setSourceIdElement(Id10_50.convertId(src.getSourceIdElement()));
    if (src.hasValidateProfileIdElement())
      tgt.setValidateProfileIdElement(Id10_50.convertId(src.getValidateProfileIdElement()));
    if (src.hasValueElement())
      tgt.setValueElement(String10_50.convertString(src.getValueElement()));
    if (src.hasWarningOnlyElement())
      tgt.setWarningOnlyElement(Boolean10_50.convertBoolean(src.getWarningOnlyElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestScript.SetupActionComponent convertSetupActionComponent(org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupActionComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.TestScript.SetupActionComponent tgt = new org.hl7.fhir.r5.model.TestScript.SetupActionComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    if (src.hasOperation())
      tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    if (src.hasAssert())
      tgt.setAssert(convertSetupActionAssertComponent(src.getAssert()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupActionComponent convertSetupActionComponent(org.hl7.fhir.r5.model.TestScript.SetupActionComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupActionComponent tgt = new org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupActionComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    if (src.hasOperation())
      tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    if (src.hasAssert())
      tgt.setAssert(convertSetupActionAssertComponent(src.getAssert()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupActionOperationComponent convertSetupActionOperationComponent(org.hl7.fhir.r5.model.TestScript.SetupActionOperationComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupActionOperationComponent tgt = new org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupActionOperationComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    if (src.hasType())
      tgt.setType(Coding10_50.convertCoding(src.getType()));
    tgt.setResource(src.getResource());
    if (src.hasLabelElement())
      tgt.setLabelElement(String10_50.convertString(src.getLabelElement()));
    if (src.hasDescriptionElement())
      tgt.setDescriptionElement(String10_50.convertString(src.getDescriptionElement()));
    if (src.hasAccept())
      tgt.setAccept(convertContentType(src.getAccept()));
    if (src.hasContentType())
      tgt.setContentType(convertContentType(src.getContentType()));
    if (src.hasDestinationElement())
      tgt.setDestinationElement(Integer10_50.convertInteger(src.getDestinationElement()));
    if (src.hasEncodeRequestUrlElement())
      tgt.setEncodeRequestUrlElement(Boolean10_50.convertBoolean(src.getEncodeRequestUrlElement()));
    if (src.hasParamsElement())
      tgt.setParamsElement(String10_50.convertString(src.getParamsElement()));
    for (org.hl7.fhir.r5.model.TestScript.SetupActionOperationRequestHeaderComponent t : src.getRequestHeader())
      tgt.addRequestHeader(convertSetupActionOperationRequestHeaderComponent(t));
    if (src.hasResponseIdElement())
      tgt.setResponseIdElement(Id10_50.convertId(src.getResponseIdElement()));
    if (src.hasSourceIdElement())
      tgt.setSourceIdElement(Id10_50.convertId(src.getSourceIdElement()));
    if (src.hasTargetId())
      tgt.setTargetId(src.getTargetId());
    if (src.hasUrlElement())
      tgt.setUrlElement(String10_50.convertString(src.getUrlElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestScript.SetupActionOperationComponent convertSetupActionOperationComponent(org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupActionOperationComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.TestScript.SetupActionOperationComponent tgt = new org.hl7.fhir.r5.model.TestScript.SetupActionOperationComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    if (src.hasType())
      tgt.setType(Coding10_50.convertCoding(src.getType()));
    if (src.hasResource())
      tgt.setResource(src.getResource());
    if (src.hasLabelElement())
      tgt.setLabelElement(String10_50.convertString(src.getLabelElement()));
    if (src.hasDescriptionElement())
      tgt.setDescriptionElement(String10_50.convertString(src.getDescriptionElement()));
    if (src.hasAccept())
      tgt.setAccept(convertContentType(src.getAccept()));
    if (src.hasContentType())
      tgt.setContentType(convertContentType(src.getContentType()));
    if (src.hasDestinationElement())
      tgt.setDestinationElement(Integer10_50.convertInteger(src.getDestinationElement()));
    if (src.hasEncodeRequestUrlElement())
      tgt.setEncodeRequestUrlElement(Boolean10_50.convertBoolean(src.getEncodeRequestUrlElement()));
    if (src.hasParamsElement())
      tgt.setParamsElement(String10_50.convertString(src.getParamsElement()));
    for (org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupActionOperationRequestHeaderComponent t : src.getRequestHeader())
      tgt.addRequestHeader(convertSetupActionOperationRequestHeaderComponent(t));
    if (src.hasResponseIdElement())
      tgt.setResponseIdElement(Id10_50.convertId(src.getResponseIdElement()));
    if (src.hasSourceIdElement())
      tgt.setSourceIdElement(Id10_50.convertId(src.getSourceIdElement()));
    if (src.hasTargetId())
      tgt.setTargetId(src.getTargetId());
    if (src.hasUrlElement())
      tgt.setUrlElement(String10_50.convertString(src.getUrlElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestScript.SetupActionOperationRequestHeaderComponent convertSetupActionOperationRequestHeaderComponent(org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupActionOperationRequestHeaderComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.TestScript.SetupActionOperationRequestHeaderComponent tgt = new org.hl7.fhir.r5.model.TestScript.SetupActionOperationRequestHeaderComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    if (src.hasFieldElement())
      tgt.setFieldElement(String10_50.convertString(src.getFieldElement()));
    if (src.hasValueElement())
      tgt.setValueElement(String10_50.convertString(src.getValueElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupActionOperationRequestHeaderComponent convertSetupActionOperationRequestHeaderComponent(org.hl7.fhir.r5.model.TestScript.SetupActionOperationRequestHeaderComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupActionOperationRequestHeaderComponent tgt = new org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupActionOperationRequestHeaderComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    if (src.hasFieldElement())
      tgt.setFieldElement(String10_50.convertString(src.getFieldElement()));
    if (src.hasValueElement())
      tgt.setValueElement(String10_50.convertString(src.getValueElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestScript.TeardownActionComponent convertTeardownActionComponent(org.hl7.fhir.dstu2.model.TestScript.TestScriptTeardownActionComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.TestScript.TeardownActionComponent tgt = new org.hl7.fhir.r5.model.TestScript.TeardownActionComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    if (src.hasOperation())
      tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.TestScript.TestScriptTeardownActionComponent convertTeardownActionComponent(org.hl7.fhir.r5.model.TestScript.TeardownActionComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.TestScript.TestScriptTeardownActionComponent tgt = new org.hl7.fhir.dstu2.model.TestScript.TestScriptTeardownActionComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    if (src.hasOperation())
      tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestScript.TestActionComponent convertTestActionComponent(org.hl7.fhir.dstu2.model.TestScript.TestScriptTestActionComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.TestScript.TestActionComponent tgt = new org.hl7.fhir.r5.model.TestScript.TestActionComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    if (src.hasOperation())
      tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    if (src.hasAssert())
      tgt.setAssert(convertSetupActionAssertComponent(src.getAssert()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.TestScript.TestScriptTestActionComponent convertTestActionComponent(org.hl7.fhir.r5.model.TestScript.TestActionComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.TestScript.TestScriptTestActionComponent tgt = new org.hl7.fhir.dstu2.model.TestScript.TestScriptTestActionComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    if (src.hasOperation())
      tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    if (src.hasAssert())
      tgt.setAssert(convertSetupActionAssertComponent(src.getAssert()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestScript convertTestScript(org.hl7.fhir.dstu2.model.TestScript src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.TestScript tgt = new org.hl7.fhir.r5.model.TestScript();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyDomainResource(src, tgt);
    if (src.hasUrlElement())
      tgt.setUrlElement(Uri10_50.convertUri(src.getUrlElement()));
    if (src.hasVersionElement())
      tgt.setVersionElement(String10_50.convertString(src.getVersionElement()));
    if (src.hasNameElement())
      tgt.setNameElement(String10_50.convertString(src.getNameElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations10_50.convertConformanceResourceStatus(src.getStatusElement()));
    if (src.hasIdentifier())
      tgt.addIdentifier(Identifier10_50.convertIdentifier(src.getIdentifier()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean10_50.convertBoolean(src.getExperimentalElement()));
    if (src.hasPublisherElement())
      tgt.setPublisherElement(String10_50.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.dstu2.model.TestScript.TestScriptContactComponent t : src.getContact())
      tgt.addContact(convertTestScriptContactComponent(t));
    if (src.hasDate())
      tgt.setDateElement(DateTime10_50.convertDateTime(src.getDateElement()));
    if (src.hasDescription())
      tgt.setDescription(src.getDescription());
    for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getUseContext())
      if (VersionConvertor_10_50.isJurisdiction(t))
        tgt.addJurisdiction(CodeableConcept10_50.convertCodeableConcept(t));
      else
        tgt.addUseContext(CodeableConcept10_50.convertCodeableConceptToUsageContext(t));
    if (src.hasRequirements())
      tgt.setPurpose(src.getRequirements());
    if (src.hasCopyright())
      tgt.setCopyright(src.getCopyright());
    if (src.hasMetadata())
      tgt.setMetadata(convertTestScriptMetadataComponent(src.getMetadata()));
    for (org.hl7.fhir.dstu2.model.TestScript.TestScriptFixtureComponent t : src.getFixture())
      tgt.addFixture(convertTestScriptFixtureComponent(t));
    for (org.hl7.fhir.dstu2.model.Reference t : src.getProfile()) tgt.getProfile().add(Reference10_50.convertReferenceToCanonical(t));
    for (org.hl7.fhir.dstu2.model.TestScript.TestScriptVariableComponent t : src.getVariable())
      tgt.addVariable(convertTestScriptVariableComponent(t));
    if (src.hasSetup())
      tgt.setSetup(convertTestScriptSetupComponent(src.getSetup()));
    for (org.hl7.fhir.dstu2.model.TestScript.TestScriptTestComponent t : src.getTest())
      tgt.addTest(convertTestScriptTestComponent(t));
    if (src.hasTeardown())
      tgt.setTeardown(convertTestScriptTeardownComponent(src.getTeardown()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.TestScript convertTestScript(org.hl7.fhir.r5.model.TestScript src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.TestScript tgt = new org.hl7.fhir.dstu2.model.TestScript();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyDomainResource(src, tgt);
    if (src.hasUrlElement())
      tgt.setUrlElement(Uri10_50.convertUri(src.getUrlElement()));
    if (src.hasVersionElement())
      tgt.setVersionElement(String10_50.convertString(src.getVersionElement()));
    if (src.hasNameElement())
      tgt.setNameElement(String10_50.convertString(src.getNameElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations10_50.convertConformanceResourceStatus(src.getStatusElement()));
    if (src.hasIdentifier()) {
      tgt.setIdentifier(Identifier10_50.convertIdentifier(src.getIdentifierFirstRep()));
    }
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean10_50.convertBoolean(src.getExperimentalElement()));
    if (src.hasPublisherElement())
      tgt.setPublisherElement(String10_50.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.r5.model.ContactDetail t : src.getContact()) tgt.addContact(convertTestScriptContactComponent(t));
    if (src.hasDate())
      tgt.setDateElement(DateTime10_50.convertDateTime(src.getDateElement()));
    if (src.hasDescription())
      tgt.setDescription(src.getDescription());
    for (org.hl7.fhir.r5.model.UsageContext t : src.getUseContext())
      if (t.hasValueCodeableConcept())
        tgt.addUseContext(CodeableConcept10_50.convertCodeableConcept(t.getValueCodeableConcept()));
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getJurisdiction())
      tgt.addUseContext(CodeableConcept10_50.convertCodeableConcept(t));
    if (src.hasPurpose())
      tgt.setRequirements(src.getPurpose());
    if (src.hasCopyright())
      tgt.setCopyright(src.getCopyright());
    if (src.hasMetadata())
      tgt.setMetadata(convertTestScriptMetadataComponent(src.getMetadata()));
    for (org.hl7.fhir.r5.model.TestScript.TestScriptFixtureComponent t : src.getFixture())
      tgt.addFixture(convertTestScriptFixtureComponent(t));
    for (CanonicalType t : src.getProfile()) tgt.addProfile(Reference10_50.convertCanonicalToReference(t));
    for (org.hl7.fhir.r5.model.TestScript.TestScriptVariableComponent t : src.getVariable())
      tgt.addVariable(convertTestScriptVariableComponent(t));
    if (src.hasSetup())
      tgt.setSetup(convertTestScriptSetupComponent(src.getSetup()));
    for (org.hl7.fhir.r5.model.TestScript.TestScriptTestComponent t : src.getTest())
      tgt.addTest(convertTestScriptTestComponent(t));
    if (src.hasTeardown())
      tgt.setTeardown(convertTestScriptTeardownComponent(src.getTeardown()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.ContactDetail convertTestScriptContactComponent(org.hl7.fhir.dstu2.model.TestScript.TestScriptContactComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.ContactDetail tgt = new org.hl7.fhir.r5.model.ContactDetail();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    if (src.hasNameElement())
      tgt.setNameElement(String10_50.convertString(src.getNameElement()));
    for (org.hl7.fhir.dstu2.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint10_50.convertContactPoint(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.TestScript.TestScriptContactComponent convertTestScriptContactComponent(org.hl7.fhir.r5.model.ContactDetail src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.TestScript.TestScriptContactComponent tgt = new org.hl7.fhir.dstu2.model.TestScript.TestScriptContactComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyElement(src, tgt);
    if (src.hasNameElement())
      tgt.setNameElement(String10_50.convertString(src.getNameElement()));
    for (org.hl7.fhir.r5.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint10_50.convertContactPoint(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestScript.TestScriptFixtureComponent convertTestScriptFixtureComponent(org.hl7.fhir.dstu2.model.TestScript.TestScriptFixtureComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.TestScript.TestScriptFixtureComponent tgt = new org.hl7.fhir.r5.model.TestScript.TestScriptFixtureComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    if (src.hasAutocreateElement())
      tgt.setAutocreateElement(Boolean10_50.convertBoolean(src.getAutocreateElement()));
    if (src.hasAutodeleteElement())
      tgt.setAutodeleteElement(Boolean10_50.convertBoolean(src.getAutodeleteElement()));
    if (src.hasResource())
      tgt.setResource(Reference10_50.convertReference(src.getResource()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.TestScript.TestScriptFixtureComponent convertTestScriptFixtureComponent(org.hl7.fhir.r5.model.TestScript.TestScriptFixtureComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.TestScript.TestScriptFixtureComponent tgt = new org.hl7.fhir.dstu2.model.TestScript.TestScriptFixtureComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    if (src.hasAutocreateElement())
      tgt.setAutocreateElement(Boolean10_50.convertBoolean(src.getAutocreateElement()));
    if (src.hasAutodeleteElement())
      tgt.setAutodeleteElement(Boolean10_50.convertBoolean(src.getAutodeleteElement()));
    if (src.hasResource())
      tgt.setResource(Reference10_50.convertReference(src.getResource()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.TestScript.TestScriptMetadataCapabilityComponent convertTestScriptMetadataCapabilityComponent(org.hl7.fhir.r5.model.TestScript.TestScriptMetadataCapabilityComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.TestScript.TestScriptMetadataCapabilityComponent tgt = new org.hl7.fhir.dstu2.model.TestScript.TestScriptMetadataCapabilityComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    if (src.hasRequiredElement())
      tgt.setRequiredElement(Boolean10_50.convertBoolean(src.getRequiredElement()));
    if (src.hasValidatedElement())
      tgt.setValidatedElement(Boolean10_50.convertBoolean(src.getValidatedElement()));
    if (src.hasDescriptionElement())
      tgt.setDescriptionElement(String10_50.convertString(src.getDescriptionElement()));
    if (src.hasDestinationElement())
      tgt.setDestinationElement(Integer10_50.convertInteger(src.getDestinationElement()));
    for (org.hl7.fhir.r5.model.UriType t : src.getLink()) tgt.addLink(t.getValue());
    if (src.hasCapabilitiesElement())
      tgt.setConformance(Reference10_50.convertCanonicalToReference(src.getCapabilitiesElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestScript.TestScriptMetadataCapabilityComponent convertTestScriptMetadataCapabilityComponent(org.hl7.fhir.dstu2.model.TestScript.TestScriptMetadataCapabilityComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.TestScript.TestScriptMetadataCapabilityComponent tgt = new org.hl7.fhir.r5.model.TestScript.TestScriptMetadataCapabilityComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    if (src.hasRequiredElement())
      tgt.setRequiredElement(Boolean10_50.convertBoolean(src.getRequiredElement()));
    if (src.hasValidatedElement())
      tgt.setValidatedElement(Boolean10_50.convertBoolean(src.getValidatedElement()));
    if (src.hasDescriptionElement())
      tgt.setDescriptionElement(String10_50.convertString(src.getDescriptionElement()));
    if (src.hasDestinationElement())
      tgt.setDestinationElement(Integer10_50.convertInteger(src.getDestinationElement()));
    for (org.hl7.fhir.dstu2.model.UriType t : src.getLink()) tgt.addLink(t.getValue());
    if (src.hasConformance())
      tgt.setCapabilitiesElement(Reference10_50.convertReferenceToCanonical(src.getConformance()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestScript.TestScriptMetadataComponent convertTestScriptMetadataComponent(org.hl7.fhir.dstu2.model.TestScript.TestScriptMetadataComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.TestScript.TestScriptMetadataComponent tgt = new org.hl7.fhir.r5.model.TestScript.TestScriptMetadataComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    for (org.hl7.fhir.dstu2.model.TestScript.TestScriptMetadataLinkComponent t : src.getLink())
      tgt.addLink(convertTestScriptMetadataLinkComponent(t));
    for (org.hl7.fhir.dstu2.model.TestScript.TestScriptMetadataCapabilityComponent t : src.getCapability())
      tgt.addCapability(convertTestScriptMetadataCapabilityComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.TestScript.TestScriptMetadataComponent convertTestScriptMetadataComponent(org.hl7.fhir.r5.model.TestScript.TestScriptMetadataComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.TestScript.TestScriptMetadataComponent tgt = new org.hl7.fhir.dstu2.model.TestScript.TestScriptMetadataComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    for (org.hl7.fhir.r5.model.TestScript.TestScriptMetadataLinkComponent t : src.getLink())
      tgt.addLink(convertTestScriptMetadataLinkComponent(t));
    for (org.hl7.fhir.r5.model.TestScript.TestScriptMetadataCapabilityComponent t : src.getCapability())
      tgt.addCapability(convertTestScriptMetadataCapabilityComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.TestScript.TestScriptMetadataLinkComponent convertTestScriptMetadataLinkComponent(org.hl7.fhir.r5.model.TestScript.TestScriptMetadataLinkComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.TestScript.TestScriptMetadataLinkComponent tgt = new org.hl7.fhir.dstu2.model.TestScript.TestScriptMetadataLinkComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    if (src.hasUrlElement())
      tgt.setUrlElement(Uri10_50.convertUri(src.getUrlElement()));
    if (src.hasDescriptionElement())
      tgt.setDescriptionElement(String10_50.convertString(src.getDescriptionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestScript.TestScriptMetadataLinkComponent convertTestScriptMetadataLinkComponent(org.hl7.fhir.dstu2.model.TestScript.TestScriptMetadataLinkComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.TestScript.TestScriptMetadataLinkComponent tgt = new org.hl7.fhir.r5.model.TestScript.TestScriptMetadataLinkComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    if (src.hasUrlElement())
      tgt.setUrlElement(Uri10_50.convertUri(src.getUrlElement()));
    if (src.hasDescriptionElement())
      tgt.setDescriptionElement(String10_50.convertString(src.getDescriptionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestScript.TestScriptSetupComponent convertTestScriptSetupComponent(org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.TestScript.TestScriptSetupComponent tgt = new org.hl7.fhir.r5.model.TestScript.TestScriptSetupComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    for (org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupActionComponent t : src.getAction())
      tgt.addAction(convertSetupActionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupComponent convertTestScriptSetupComponent(org.hl7.fhir.r5.model.TestScript.TestScriptSetupComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupComponent tgt = new org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    for (org.hl7.fhir.r5.model.TestScript.SetupActionComponent t : src.getAction())
      tgt.addAction(convertSetupActionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.TestScript.TestScriptTeardownComponent convertTestScriptTeardownComponent(org.hl7.fhir.r5.model.TestScript.TestScriptTeardownComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.TestScript.TestScriptTeardownComponent tgt = new org.hl7.fhir.dstu2.model.TestScript.TestScriptTeardownComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    for (org.hl7.fhir.r5.model.TestScript.TeardownActionComponent t : src.getAction())
      tgt.addAction(convertTeardownActionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestScript.TestScriptTeardownComponent convertTestScriptTeardownComponent(org.hl7.fhir.dstu2.model.TestScript.TestScriptTeardownComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.TestScript.TestScriptTeardownComponent tgt = new org.hl7.fhir.r5.model.TestScript.TestScriptTeardownComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    for (org.hl7.fhir.dstu2.model.TestScript.TestScriptTeardownActionComponent t : src.getAction())
      tgt.addAction(convertTeardownActionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestScript.TestScriptTestComponent convertTestScriptTestComponent(org.hl7.fhir.dstu2.model.TestScript.TestScriptTestComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.TestScript.TestScriptTestComponent tgt = new org.hl7.fhir.r5.model.TestScript.TestScriptTestComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    if (src.hasNameElement())
      tgt.setNameElement(String10_50.convertString(src.getNameElement()));
    if (src.hasDescriptionElement())
      tgt.setDescriptionElement(String10_50.convertString(src.getDescriptionElement()));
    for (org.hl7.fhir.dstu2.model.TestScript.TestScriptTestActionComponent t : src.getAction())
      tgt.addAction(convertTestActionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.TestScript.TestScriptTestComponent convertTestScriptTestComponent(org.hl7.fhir.r5.model.TestScript.TestScriptTestComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.TestScript.TestScriptTestComponent tgt = new org.hl7.fhir.dstu2.model.TestScript.TestScriptTestComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    if (src.hasNameElement())
      tgt.setNameElement(String10_50.convertString(src.getNameElement()));
    if (src.hasDescriptionElement())
      tgt.setDescriptionElement(String10_50.convertString(src.getDescriptionElement()));
    for (org.hl7.fhir.r5.model.TestScript.TestActionComponent t : src.getAction())
      tgt.addAction(convertTestActionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.TestScript.TestScriptVariableComponent convertTestScriptVariableComponent(org.hl7.fhir.r5.model.TestScript.TestScriptVariableComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.TestScript.TestScriptVariableComponent tgt = new org.hl7.fhir.dstu2.model.TestScript.TestScriptVariableComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    if (src.hasNameElement())
      tgt.setNameElement(String10_50.convertString(src.getNameElement()));
    if (src.hasHeaderFieldElement())
      tgt.setHeaderFieldElement(String10_50.convertString(src.getHeaderFieldElement()));
    if (src.hasPathElement())
      tgt.setPathElement(String10_50.convertString(src.getPathElement()));
    if (src.hasSourceIdElement())
      tgt.setSourceIdElement(Id10_50.convertId(src.getSourceIdElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestScript.TestScriptVariableComponent convertTestScriptVariableComponent(org.hl7.fhir.dstu2.model.TestScript.TestScriptVariableComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.TestScript.TestScriptVariableComponent tgt = new org.hl7.fhir.r5.model.TestScript.TestScriptVariableComponent();
    ConversionContext10_50.INSTANCE.getVersionConvertor_10_50().copyBackboneElement(src,tgt);
    if (src.hasNameElement())
      tgt.setNameElement(String10_50.convertString(src.getNameElement()));
    if (src.hasHeaderFieldElement())
      tgt.setHeaderFieldElement(String10_50.convertString(src.getHeaderFieldElement()));
    if (src.hasPathElement())
      tgt.setPathElement(String10_50.convertString(src.getPathElement()));
    if (src.hasSourceIdElement())
      tgt.setSourceIdElement(Id10_50.convertId(src.getSourceIdElement()));
    return tgt;
  }
}