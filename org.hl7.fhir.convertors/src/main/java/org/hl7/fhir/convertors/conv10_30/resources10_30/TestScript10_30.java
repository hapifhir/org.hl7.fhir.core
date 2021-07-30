package org.hl7.fhir.convertors.conv10_30.resources10_30;

import org.hl7.fhir.convertors.conv10_30.VersionConvertor_10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.Element10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.Reference10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.CodeableConcept10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.Coding10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.ContactPoint10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.complextypes10_30.Identifier10_30;
import org.hl7.fhir.convertors.conv10_30.datatypes10_30.primitivetypes10_30.*;
import org.hl7.fhir.exceptions.FHIRException;

public class TestScript10_30 {

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.TestScript.AssertionDirectionType> convertAssertionDirectionType(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.TestScript.AssertionDirectionType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.TestScript.AssertionDirectionType> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.TestScript.AssertionDirectionTypeEnumFactory());
    Element10_30.copyElement(src, tgt);
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

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.TestScript.AssertionDirectionType> convertAssertionDirectionType(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.TestScript.AssertionDirectionType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.TestScript.AssertionDirectionType> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.TestScript.AssertionDirectionTypeEnumFactory());
    Element10_30.copyElement(src, tgt);
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

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.TestScript.AssertionOperatorType> convertAssertionOperatorType(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.TestScript.AssertionOperatorType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.TestScript.AssertionOperatorType> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.TestScript.AssertionOperatorTypeEnumFactory());
    Element10_30.copyElement(src, tgt);
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

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.TestScript.AssertionOperatorType> convertAssertionOperatorType(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.TestScript.AssertionOperatorType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.TestScript.AssertionOperatorType> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.TestScript.AssertionOperatorTypeEnumFactory());
    Element10_30.copyElement(src, tgt);
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

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.TestScript.AssertionResponseTypes> convertAssertionResponseTypes(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.TestScript.AssertionResponseTypes> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.TestScript.AssertionResponseTypes> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.TestScript.AssertionResponseTypesEnumFactory());
    Element10_30.copyElement(src, tgt);
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

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.TestScript.AssertionResponseTypes> convertAssertionResponseTypes(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.TestScript.AssertionResponseTypes> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.TestScript.AssertionResponseTypes> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.TestScript.AssertionResponseTypesEnumFactory());
    Element10_30.copyElement(src, tgt);
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

  static public org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.TestScript.ContentType> convertContentType(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.TestScript.ContentType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.TestScript.ContentType> tgt = new org.hl7.fhir.dstu2.model.Enumeration<>(new org.hl7.fhir.dstu2.model.TestScript.ContentTypeEnumFactory());
    Element10_30.copyElement(src, tgt);
    switch (src.getValue()) {
      case XML:
        tgt.setValue(org.hl7.fhir.dstu2.model.TestScript.ContentType.XML);
        break;
      case JSON:
        tgt.setValue(org.hl7.fhir.dstu2.model.TestScript.ContentType.JSON);
        break;
      default:
        tgt.setValue(org.hl7.fhir.dstu2.model.TestScript.ContentType.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.TestScript.ContentType> convertContentType(org.hl7.fhir.dstu2.model.Enumeration<org.hl7.fhir.dstu2.model.TestScript.ContentType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.TestScript.ContentType> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.TestScript.ContentTypeEnumFactory());
    Element10_30.copyElement(src, tgt);
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

  public static org.hl7.fhir.dstu3.model.TestScript.SetupActionAssertComponent convertSetupActionAssertComponent(org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupActionAssertComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.TestScript.SetupActionAssertComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.SetupActionAssertComponent();
    Element10_30.copyElement(src, tgt);
    if (src.hasLabelElement())
      tgt.setLabelElement(String10_30.convertString(src.getLabelElement()));
    if (src.hasDescriptionElement())
      tgt.setDescriptionElement(String10_30.convertString(src.getDescriptionElement()));
    if (src.hasDirection())
      tgt.setDirectionElement(convertAssertionDirectionType(src.getDirectionElement()));
    if (src.hasCompareToSourceIdElement())
      tgt.setCompareToSourceIdElement(String10_30.convertString(src.getCompareToSourceIdElement()));
    if (src.hasCompareToSourcePathElement())
      tgt.setCompareToSourcePathElement(String10_30.convertString(src.getCompareToSourcePathElement()));
    if (src.hasContentType())
      tgt.setContentTypeElement(convertContentType(src.getContentTypeElement()));
    if (src.hasHeaderFieldElement())
      tgt.setHeaderFieldElement(String10_30.convertString(src.getHeaderFieldElement()));
    if (src.hasMinimumIdElement())
      tgt.setMinimumIdElement(String10_30.convertString(src.getMinimumIdElement()));
    if (src.hasNavigationLinksElement())
      tgt.setNavigationLinksElement(Boolean10_30.convertBoolean(src.getNavigationLinksElement()));
    if (src.hasOperator())
      tgt.setOperatorElement(convertAssertionOperatorType(src.getOperatorElement()));
    if (src.hasPathElement())
      tgt.setPathElement(String10_30.convertString(src.getPathElement()));
    if (src.hasResourceElement())
      tgt.setResourceElement(Code10_30.convertCode(src.getResourceElement()));
    if (src.hasResponse())
      tgt.setResponseElement(convertAssertionResponseTypes(src.getResponseElement()));
    if (src.hasResponseCodeElement())
      tgt.setResponseCodeElement(String10_30.convertString(src.getResponseCodeElement()));
    if (src.hasSourceIdElement())
      tgt.setSourceIdElement(Id10_30.convertId(src.getSourceIdElement()));
    if (src.hasValidateProfileIdElement())
      tgt.setValidateProfileIdElement(Id10_30.convertId(src.getValidateProfileIdElement()));
    if (src.hasValueElement())
      tgt.setValueElement(String10_30.convertString(src.getValueElement()));
    if (src.hasWarningOnlyElement())
      tgt.setWarningOnlyElement(Boolean10_30.convertBoolean(src.getWarningOnlyElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupActionAssertComponent convertSetupActionAssertComponent(org.hl7.fhir.dstu3.model.TestScript.SetupActionAssertComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupActionAssertComponent tgt = new org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupActionAssertComponent();
    Element10_30.copyElement(src, tgt);
    if (src.hasLabelElement())
      tgt.setLabelElement(String10_30.convertString(src.getLabelElement()));
    if (src.hasDescriptionElement())
      tgt.setDescriptionElement(String10_30.convertString(src.getDescriptionElement()));
    if (src.hasDirection())
      tgt.setDirectionElement(convertAssertionDirectionType(src.getDirectionElement()));
    if (src.hasCompareToSourceIdElement())
      tgt.setCompareToSourceIdElement(String10_30.convertString(src.getCompareToSourceIdElement()));
    if (src.hasCompareToSourcePathElement())
      tgt.setCompareToSourcePathElement(String10_30.convertString(src.getCompareToSourcePathElement()));
    if (src.hasContentType())
      tgt.setContentTypeElement(convertContentType(src.getContentTypeElement()));
    if (src.hasHeaderFieldElement())
      tgt.setHeaderFieldElement(String10_30.convertString(src.getHeaderFieldElement()));
    if (src.hasMinimumIdElement())
      tgt.setMinimumIdElement(String10_30.convertString(src.getMinimumIdElement()));
    if (src.hasNavigationLinksElement())
      tgt.setNavigationLinksElement(Boolean10_30.convertBoolean(src.getNavigationLinksElement()));
    if (src.hasOperator())
      tgt.setOperatorElement(convertAssertionOperatorType(src.getOperatorElement()));
    if (src.hasPathElement())
      tgt.setPathElement(String10_30.convertString(src.getPathElement()));
    if (src.hasResourceElement())
      tgt.setResourceElement(Code10_30.convertCode(src.getResourceElement()));
    if (src.hasResponse())
      tgt.setResponseElement(convertAssertionResponseTypes(src.getResponseElement()));
    if (src.hasResponseCodeElement())
      tgt.setResponseCodeElement(String10_30.convertString(src.getResponseCodeElement()));
    if (src.hasSourceIdElement())
      tgt.setSourceIdElement(Id10_30.convertId(src.getSourceIdElement()));
    if (src.hasValidateProfileIdElement())
      tgt.setValidateProfileIdElement(Id10_30.convertId(src.getValidateProfileIdElement()));
    if (src.hasValueElement())
      tgt.setValueElement(String10_30.convertString(src.getValueElement()));
    if (src.hasWarningOnlyElement())
      tgt.setWarningOnlyElement(Boolean10_30.convertBoolean(src.getWarningOnlyElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.TestScript.SetupActionComponent convertSetupActionComponent(org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupActionComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.TestScript.SetupActionComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.SetupActionComponent();
    Element10_30.copyElement(src, tgt);
    if (src.hasOperation())
      tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    if (src.hasAssert())
      tgt.setAssert(convertSetupActionAssertComponent(src.getAssert()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupActionComponent convertSetupActionComponent(org.hl7.fhir.dstu3.model.TestScript.SetupActionComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupActionComponent tgt = new org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupActionComponent();
    Element10_30.copyElement(src, tgt);
    if (src.hasOperation())
      tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    if (src.hasAssert())
      tgt.setAssert(convertSetupActionAssertComponent(src.getAssert()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupActionOperationComponent convertSetupActionOperationComponent(org.hl7.fhir.dstu3.model.TestScript.SetupActionOperationComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupActionOperationComponent tgt = new org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupActionOperationComponent();
    Element10_30.copyElement(src, tgt);
    if (src.hasType())
      tgt.setType(Coding10_30.convertCoding(src.getType()));
    if (src.hasResourceElement())
      tgt.setResourceElement(Code10_30.convertCode(src.getResourceElement()));
    if (src.hasLabelElement())
      tgt.setLabelElement(String10_30.convertString(src.getLabelElement()));
    if (src.hasDescriptionElement())
      tgt.setDescriptionElement(String10_30.convertString(src.getDescriptionElement()));
    if (src.hasAccept())
      tgt.setAcceptElement(convertContentType(src.getAcceptElement()));
    if (src.hasContentType())
      tgt.setContentTypeElement(convertContentType(src.getContentTypeElement()));
    if (src.hasDestinationElement())
      tgt.setDestinationElement(Integer10_30.convertInteger(src.getDestinationElement()));
    if (src.hasEncodeRequestUrlElement())
      tgt.setEncodeRequestUrlElement(Boolean10_30.convertBoolean(src.getEncodeRequestUrlElement()));
    if (src.hasParamsElement())
      tgt.setParamsElement(String10_30.convertString(src.getParamsElement()));
    for (org.hl7.fhir.dstu3.model.TestScript.SetupActionOperationRequestHeaderComponent t : src.getRequestHeader())
      tgt.addRequestHeader(convertSetupActionOperationRequestHeaderComponent(t));
    if (src.hasResponseIdElement())
      tgt.setResponseIdElement(Id10_30.convertId(src.getResponseIdElement()));
    if (src.hasSourceIdElement())
      tgt.setSourceIdElement(Id10_30.convertId(src.getSourceIdElement()));
    if (src.hasTargetId())
      tgt.setTargetId(src.getTargetId());
    if (src.hasUrlElement())
      tgt.setUrlElement(String10_30.convertString(src.getUrlElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.TestScript.SetupActionOperationComponent convertSetupActionOperationComponent(org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupActionOperationComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.TestScript.SetupActionOperationComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.SetupActionOperationComponent();
    Element10_30.copyElement(src, tgt);
    if (src.hasType())
      tgt.setType(Coding10_30.convertCoding(src.getType()));
    if (src.hasResourceElement())
      tgt.setResourceElement(Code10_30.convertCode(src.getResourceElement()));
    if (src.hasLabelElement())
      tgt.setLabelElement(String10_30.convertString(src.getLabelElement()));
    if (src.hasDescriptionElement())
      tgt.setDescriptionElement(String10_30.convertString(src.getDescriptionElement()));
    if (src.hasAccept())
      tgt.setAcceptElement(convertContentType(src.getAcceptElement()));
    if (src.hasContentType())
      tgt.setContentTypeElement(convertContentType(src.getContentTypeElement()));
    if (src.hasDestinationElement())
      tgt.setDestinationElement(Integer10_30.convertInteger(src.getDestinationElement()));
    if (src.hasEncodeRequestUrlElement())
      tgt.setEncodeRequestUrlElement(Boolean10_30.convertBoolean(src.getEncodeRequestUrlElement()));
    if (src.hasParamsElement())
      tgt.setParamsElement(String10_30.convertString(src.getParamsElement()));
    for (org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupActionOperationRequestHeaderComponent t : src.getRequestHeader())
      tgt.addRequestHeader(convertSetupActionOperationRequestHeaderComponent(t));
    if (src.hasResponseIdElement())
      tgt.setResponseIdElement(Id10_30.convertId(src.getResponseIdElement()));
    if (src.hasSourceIdElement())
      tgt.setSourceIdElement(Id10_30.convertId(src.getSourceIdElement()));
    if (src.hasTargetId())
      tgt.setTargetId(src.getTargetId());
    if (src.hasUrlElement())
      tgt.setUrlElement(String10_30.convertString(src.getUrlElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.TestScript.SetupActionOperationRequestHeaderComponent convertSetupActionOperationRequestHeaderComponent(org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupActionOperationRequestHeaderComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.TestScript.SetupActionOperationRequestHeaderComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.SetupActionOperationRequestHeaderComponent();
    Element10_30.copyElement(src, tgt);
    if (src.hasFieldElement())
      tgt.setFieldElement(String10_30.convertString(src.getFieldElement()));
    if (src.hasValueElement())
      tgt.setValueElement(String10_30.convertString(src.getValueElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupActionOperationRequestHeaderComponent convertSetupActionOperationRequestHeaderComponent(org.hl7.fhir.dstu3.model.TestScript.SetupActionOperationRequestHeaderComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupActionOperationRequestHeaderComponent tgt = new org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupActionOperationRequestHeaderComponent();
    Element10_30.copyElement(src, tgt);
    if (src.hasFieldElement())
      tgt.setFieldElement(String10_30.convertString(src.getFieldElement()));
    if (src.hasValueElement())
      tgt.setValueElement(String10_30.convertString(src.getValueElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.TestScript.TestScriptTeardownActionComponent convertTeardownActionComponent(org.hl7.fhir.dstu3.model.TestScript.TeardownActionComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.TestScript.TestScriptTeardownActionComponent tgt = new org.hl7.fhir.dstu2.model.TestScript.TestScriptTeardownActionComponent();
    Element10_30.copyElement(src, tgt);
    if (src.hasOperation())
      tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.TestScript.TeardownActionComponent convertTeardownActionComponent(org.hl7.fhir.dstu2.model.TestScript.TestScriptTeardownActionComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.TestScript.TeardownActionComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.TeardownActionComponent();
    Element10_30.copyElement(src, tgt);
    if (src.hasOperation())
      tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.TestScript.TestActionComponent convertTestActionComponent(org.hl7.fhir.dstu2.model.TestScript.TestScriptTestActionComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.TestScript.TestActionComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.TestActionComponent();
    Element10_30.copyElement(src, tgt);
    if (src.hasOperation())
      tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    if (src.hasAssert())
      tgt.setAssert(convertSetupActionAssertComponent(src.getAssert()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.TestScript.TestScriptTestActionComponent convertTestActionComponent(org.hl7.fhir.dstu3.model.TestScript.TestActionComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.TestScript.TestScriptTestActionComponent tgt = new org.hl7.fhir.dstu2.model.TestScript.TestScriptTestActionComponent();
    Element10_30.copyElement(src, tgt);
    if (src.hasOperation())
      tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    if (src.hasAssert())
      tgt.setAssert(convertSetupActionAssertComponent(src.getAssert()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.TestScript convertTestScript(org.hl7.fhir.dstu3.model.TestScript src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.TestScript tgt = new org.hl7.fhir.dstu2.model.TestScript();
    VersionConvertor_10_30.copyDomainResource(src, tgt);
    if (src.hasUrlElement())
      tgt.setUrlElement(Uri10_30.convertUri(src.getUrlElement()));
    if (src.hasVersionElement())
      tgt.setVersionElement(String10_30.convertString(src.getVersionElement()));
    if (src.hasNameElement())
      tgt.setNameElement(String10_30.convertString(src.getNameElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations10_30.convertConformanceResourceStatus(src.getStatusElement()));
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier10_30.convertIdentifier(src.getIdentifier()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean10_30.convertBoolean(src.getExperimentalElement()));
    if (src.hasPublisherElement())
      tgt.setPublisherElement(String10_30.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.dstu3.model.ContactDetail t : src.getContact())
      tgt.addContact(convertTestScriptContactComponent(t));
    if (src.hasDate())
      tgt.setDateElement(DateTime10_30.convertDateTime(src.getDateElement()));
    if (src.hasDescription())
      tgt.setDescription(src.getDescription());
    for (org.hl7.fhir.dstu3.model.UsageContext t : src.getUseContext())
      if (t.hasValueCodeableConcept())
        tgt.addUseContext(CodeableConcept10_30.convertCodeableConcept(t.getValueCodeableConcept()));
    for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getJurisdiction())
      tgt.addUseContext(CodeableConcept10_30.convertCodeableConcept(t));
    if (src.hasPurpose())
      tgt.setRequirements(src.getPurpose());
    if (src.hasCopyright())
      tgt.setCopyright(src.getCopyright());
    if (src.hasMetadata())
      tgt.setMetadata(convertTestScriptMetadataComponent(src.getMetadata()));
    for (org.hl7.fhir.dstu3.model.TestScript.TestScriptFixtureComponent t : src.getFixture())
      tgt.addFixture(convertTestScriptFixtureComponent(t));
    for (org.hl7.fhir.dstu3.model.Reference t : src.getProfile()) tgt.addProfile(Reference10_30.convertReference(t));
    for (org.hl7.fhir.dstu3.model.TestScript.TestScriptVariableComponent t : src.getVariable())
      tgt.addVariable(convertTestScriptVariableComponent(t));
    if (src.hasSetup())
      tgt.setSetup(convertTestScriptSetupComponent(src.getSetup()));
    for (org.hl7.fhir.dstu3.model.TestScript.TestScriptTestComponent t : src.getTest())
      tgt.addTest(convertTestScriptTestComponent(t));
    if (src.hasTeardown())
      tgt.setTeardown(convertTestScriptTeardownComponent(src.getTeardown()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.TestScript convertTestScript(org.hl7.fhir.dstu2.model.TestScript src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.TestScript tgt = new org.hl7.fhir.dstu3.model.TestScript();
    VersionConvertor_10_30.copyDomainResource(src, tgt);
    if (src.hasUrlElement())
      tgt.setUrlElement(Uri10_30.convertUri(src.getUrlElement()));
    if (src.hasVersionElement())
      tgt.setVersionElement(String10_30.convertString(src.getVersionElement()));
    if (src.hasNameElement())
      tgt.setNameElement(String10_30.convertString(src.getNameElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations10_30.convertConformanceResourceStatus(src.getStatusElement()));
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier10_30.convertIdentifier(src.getIdentifier()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean10_30.convertBoolean(src.getExperimentalElement()));
    if (src.hasPublisherElement())
      tgt.setPublisherElement(String10_30.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.dstu2.model.TestScript.TestScriptContactComponent t : src.getContact())
      tgt.addContact(convertTestScriptContactComponent(t));
    if (src.hasDate())
      tgt.setDateElement(DateTime10_30.convertDateTime(src.getDateElement()));
    if (src.hasDescription())
      tgt.setDescription(src.getDescription());
    for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getUseContext())
      if (VersionConvertor_10_30.isJurisdiction(t))
        tgt.addJurisdiction(CodeableConcept10_30.convertCodeableConcept(t));
      else
        tgt.addUseContext(CodeableConcept10_30.convertCodeableConceptToUsageContext(t));
    if (src.hasRequirements())
      tgt.setPurpose(src.getRequirements());
    if (src.hasCopyright())
      tgt.setCopyright(src.getCopyright());
    if (src.hasMetadata())
      tgt.setMetadata(convertTestScriptMetadataComponent(src.getMetadata()));
    for (org.hl7.fhir.dstu2.model.TestScript.TestScriptFixtureComponent t : src.getFixture())
      tgt.addFixture(convertTestScriptFixtureComponent(t));
    for (org.hl7.fhir.dstu2.model.Reference t : src.getProfile()) tgt.addProfile(Reference10_30.convertReference(t));
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

  public static org.hl7.fhir.dstu3.model.ContactDetail convertTestScriptContactComponent(org.hl7.fhir.dstu2.model.TestScript.TestScriptContactComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.ContactDetail tgt = new org.hl7.fhir.dstu3.model.ContactDetail();
    Element10_30.copyElement(src, tgt);
    if (src.hasNameElement())
      tgt.setNameElement(String10_30.convertString(src.getNameElement()));
    for (org.hl7.fhir.dstu2.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint10_30.convertContactPoint(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.TestScript.TestScriptContactComponent convertTestScriptContactComponent(org.hl7.fhir.dstu3.model.ContactDetail src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.TestScript.TestScriptContactComponent tgt = new org.hl7.fhir.dstu2.model.TestScript.TestScriptContactComponent();
    Element10_30.copyElement(src, tgt);
    if (src.hasNameElement())
      tgt.setNameElement(String10_30.convertString(src.getNameElement()));
    for (org.hl7.fhir.dstu3.model.ContactPoint t : src.getTelecom())
      tgt.addTelecom(ContactPoint10_30.convertContactPoint(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.TestScript.TestScriptFixtureComponent convertTestScriptFixtureComponent(org.hl7.fhir.dstu2.model.TestScript.TestScriptFixtureComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.TestScript.TestScriptFixtureComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.TestScriptFixtureComponent();
    Element10_30.copyElement(src, tgt);
    if (src.hasAutocreateElement())
      tgt.setAutocreateElement(Boolean10_30.convertBoolean(src.getAutocreateElement()));
    if (src.hasAutodeleteElement())
      tgt.setAutodeleteElement(Boolean10_30.convertBoolean(src.getAutodeleteElement()));
    if (src.hasResource())
      tgt.setResource(Reference10_30.convertReference(src.getResource()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.TestScript.TestScriptFixtureComponent convertTestScriptFixtureComponent(org.hl7.fhir.dstu3.model.TestScript.TestScriptFixtureComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.TestScript.TestScriptFixtureComponent tgt = new org.hl7.fhir.dstu2.model.TestScript.TestScriptFixtureComponent();
    Element10_30.copyElement(src, tgt);
    if (src.hasAutocreateElement())
      tgt.setAutocreateElement(Boolean10_30.convertBoolean(src.getAutocreateElement()));
    if (src.hasAutodeleteElement())
      tgt.setAutodeleteElement(Boolean10_30.convertBoolean(src.getAutodeleteElement()));
    if (src.hasResource())
      tgt.setResource(Reference10_30.convertReference(src.getResource()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.TestScript.TestScriptMetadataCapabilityComponent convertTestScriptMetadataCapabilityComponent(org.hl7.fhir.dstu3.model.TestScript.TestScriptMetadataCapabilityComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.TestScript.TestScriptMetadataCapabilityComponent tgt = new org.hl7.fhir.dstu2.model.TestScript.TestScriptMetadataCapabilityComponent();
    Element10_30.copyElement(src, tgt);
    if (src.hasRequiredElement())
      tgt.setRequiredElement(Boolean10_30.convertBoolean(src.getRequiredElement()));
    if (src.hasValidatedElement())
      tgt.setValidatedElement(Boolean10_30.convertBoolean(src.getValidatedElement()));
    if (src.hasDescriptionElement())
      tgt.setDescriptionElement(String10_30.convertString(src.getDescriptionElement()));
    if (src.hasDestinationElement())
      tgt.setDestinationElement(Integer10_30.convertInteger(src.getDestinationElement()));
    for (org.hl7.fhir.dstu3.model.UriType t : src.getLink()) tgt.addLink(t.getValue());
    if (src.hasCapabilities())
      tgt.setConformance(Reference10_30.convertReference(src.getCapabilities()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.TestScript.TestScriptMetadataCapabilityComponent convertTestScriptMetadataCapabilityComponent(org.hl7.fhir.dstu2.model.TestScript.TestScriptMetadataCapabilityComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.TestScript.TestScriptMetadataCapabilityComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.TestScriptMetadataCapabilityComponent();
    Element10_30.copyElement(src, tgt);
    if (src.hasRequiredElement())
      tgt.setRequiredElement(Boolean10_30.convertBoolean(src.getRequiredElement()));
    if (src.hasValidatedElement())
      tgt.setValidatedElement(Boolean10_30.convertBoolean(src.getValidatedElement()));
    if (src.hasDescriptionElement())
      tgt.setDescriptionElement(String10_30.convertString(src.getDescriptionElement()));
    if (src.hasDestinationElement())
      tgt.setDestinationElement(Integer10_30.convertInteger(src.getDestinationElement()));
    for (org.hl7.fhir.dstu2.model.UriType t : src.getLink()) tgt.addLink(t.getValue());
    if (src.hasConformance())
      tgt.setCapabilities(Reference10_30.convertReference(src.getConformance()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.TestScript.TestScriptMetadataComponent convertTestScriptMetadataComponent(org.hl7.fhir.dstu2.model.TestScript.TestScriptMetadataComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.TestScript.TestScriptMetadataComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.TestScriptMetadataComponent();
    Element10_30.copyElement(src, tgt);
    for (org.hl7.fhir.dstu2.model.TestScript.TestScriptMetadataLinkComponent t : src.getLink())
      tgt.addLink(convertTestScriptMetadataLinkComponent(t));
    for (org.hl7.fhir.dstu2.model.TestScript.TestScriptMetadataCapabilityComponent t : src.getCapability())
      tgt.addCapability(convertTestScriptMetadataCapabilityComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.TestScript.TestScriptMetadataComponent convertTestScriptMetadataComponent(org.hl7.fhir.dstu3.model.TestScript.TestScriptMetadataComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.TestScript.TestScriptMetadataComponent tgt = new org.hl7.fhir.dstu2.model.TestScript.TestScriptMetadataComponent();
    Element10_30.copyElement(src, tgt);
    for (org.hl7.fhir.dstu3.model.TestScript.TestScriptMetadataLinkComponent t : src.getLink())
      tgt.addLink(convertTestScriptMetadataLinkComponent(t));
    for (org.hl7.fhir.dstu3.model.TestScript.TestScriptMetadataCapabilityComponent t : src.getCapability())
      tgt.addCapability(convertTestScriptMetadataCapabilityComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.TestScript.TestScriptMetadataLinkComponent convertTestScriptMetadataLinkComponent(org.hl7.fhir.dstu2.model.TestScript.TestScriptMetadataLinkComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.TestScript.TestScriptMetadataLinkComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.TestScriptMetadataLinkComponent();
    Element10_30.copyElement(src, tgt);
    if (src.hasUrlElement())
      tgt.setUrlElement(Uri10_30.convertUri(src.getUrlElement()));
    if (src.hasDescriptionElement())
      tgt.setDescriptionElement(String10_30.convertString(src.getDescriptionElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.TestScript.TestScriptMetadataLinkComponent convertTestScriptMetadataLinkComponent(org.hl7.fhir.dstu3.model.TestScript.TestScriptMetadataLinkComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.TestScript.TestScriptMetadataLinkComponent tgt = new org.hl7.fhir.dstu2.model.TestScript.TestScriptMetadataLinkComponent();
    Element10_30.copyElement(src, tgt);
    if (src.hasUrlElement())
      tgt.setUrlElement(Uri10_30.convertUri(src.getUrlElement()));
    if (src.hasDescriptionElement())
      tgt.setDescriptionElement(String10_30.convertString(src.getDescriptionElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.TestScript.TestScriptSetupComponent convertTestScriptSetupComponent(org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.TestScript.TestScriptSetupComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.TestScriptSetupComponent();
    Element10_30.copyElement(src, tgt);
    for (org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupActionComponent t : src.getAction())
      tgt.addAction(convertSetupActionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupComponent convertTestScriptSetupComponent(org.hl7.fhir.dstu3.model.TestScript.TestScriptSetupComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupComponent tgt = new org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupComponent();
    Element10_30.copyElement(src, tgt);
    for (org.hl7.fhir.dstu3.model.TestScript.SetupActionComponent t : src.getAction())
      tgt.addAction(convertSetupActionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.TestScript.TestScriptTeardownComponent convertTestScriptTeardownComponent(org.hl7.fhir.dstu2.model.TestScript.TestScriptTeardownComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.TestScript.TestScriptTeardownComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.TestScriptTeardownComponent();
    Element10_30.copyElement(src, tgt);
    for (org.hl7.fhir.dstu2.model.TestScript.TestScriptTeardownActionComponent t : src.getAction())
      tgt.addAction(convertTeardownActionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.TestScript.TestScriptTeardownComponent convertTestScriptTeardownComponent(org.hl7.fhir.dstu3.model.TestScript.TestScriptTeardownComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.TestScript.TestScriptTeardownComponent tgt = new org.hl7.fhir.dstu2.model.TestScript.TestScriptTeardownComponent();
    Element10_30.copyElement(src, tgt);
    for (org.hl7.fhir.dstu3.model.TestScript.TeardownActionComponent t : src.getAction())
      tgt.addAction(convertTeardownActionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.TestScript.TestScriptTestComponent convertTestScriptTestComponent(org.hl7.fhir.dstu2.model.TestScript.TestScriptTestComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.TestScript.TestScriptTestComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.TestScriptTestComponent();
    Element10_30.copyElement(src, tgt);
    if (src.hasNameElement())
      tgt.setNameElement(String10_30.convertString(src.getNameElement()));
    if (src.hasDescriptionElement())
      tgt.setDescriptionElement(String10_30.convertString(src.getDescriptionElement()));
    for (org.hl7.fhir.dstu2.model.TestScript.TestScriptTestActionComponent t : src.getAction())
      tgt.addAction(convertTestActionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.TestScript.TestScriptTestComponent convertTestScriptTestComponent(org.hl7.fhir.dstu3.model.TestScript.TestScriptTestComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.TestScript.TestScriptTestComponent tgt = new org.hl7.fhir.dstu2.model.TestScript.TestScriptTestComponent();
    Element10_30.copyElement(src, tgt);
    if (src.hasNameElement())
      tgt.setNameElement(String10_30.convertString(src.getNameElement()));
    if (src.hasDescriptionElement())
      tgt.setDescriptionElement(String10_30.convertString(src.getDescriptionElement()));
    for (org.hl7.fhir.dstu3.model.TestScript.TestActionComponent t : src.getAction())
      tgt.addAction(convertTestActionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.TestScript.TestScriptVariableComponent convertTestScriptVariableComponent(org.hl7.fhir.dstu2.model.TestScript.TestScriptVariableComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.TestScript.TestScriptVariableComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.TestScriptVariableComponent();
    Element10_30.copyElement(src, tgt);
    if (src.hasNameElement())
      tgt.setNameElement(String10_30.convertString(src.getNameElement()));
    if (src.hasHeaderFieldElement())
      tgt.setHeaderFieldElement(String10_30.convertString(src.getHeaderFieldElement()));
    if (src.hasPathElement())
      tgt.setPathElement(String10_30.convertString(src.getPathElement()));
    if (src.hasSourceIdElement())
      tgt.setSourceIdElement(Id10_30.convertId(src.getSourceIdElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu2.model.TestScript.TestScriptVariableComponent convertTestScriptVariableComponent(org.hl7.fhir.dstu3.model.TestScript.TestScriptVariableComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2.model.TestScript.TestScriptVariableComponent tgt = new org.hl7.fhir.dstu2.model.TestScript.TestScriptVariableComponent();
    Element10_30.copyElement(src, tgt);
    if (src.hasNameElement())
      tgt.setNameElement(String10_30.convertString(src.getNameElement()));
    if (src.hasHeaderFieldElement())
      tgt.setHeaderFieldElement(String10_30.convertString(src.getHeaderFieldElement()));
    if (src.hasPathElement())
      tgt.setPathElement(String10_30.convertString(src.getPathElement()));
    if (src.hasSourceIdElement())
      tgt.setSourceIdElement(Id10_30.convertId(src.getSourceIdElement()));
    return tgt;
  }
}