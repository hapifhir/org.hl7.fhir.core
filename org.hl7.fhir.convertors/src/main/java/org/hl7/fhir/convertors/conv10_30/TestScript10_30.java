package org.hl7.fhir.convertors.conv10_30;

import org.hl7.fhir.convertors.VersionConvertor_10_30;
import org.hl7.fhir.dstu2.model.BooleanType;
import org.hl7.fhir.dstu2.model.IdType;
import org.hl7.fhir.dstu2.model.IntegerType;
import org.hl7.fhir.dstu2.model.StringType;
import org.hl7.fhir.dstu3.model.MarkdownType;
import org.hl7.fhir.exceptions.FHIRException;
import java.util.Collections;

public class TestScript10_30 {

    public static org.hl7.fhir.dstu2.model.TestScript.AssertionDirectionType convertAssertionDirectionType(org.hl7.fhir.dstu3.model.TestScript.AssertionDirectionType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case RESPONSE:
                return org.hl7.fhir.dstu2.model.TestScript.AssertionDirectionType.RESPONSE;
            case REQUEST:
                return org.hl7.fhir.dstu2.model.TestScript.AssertionDirectionType.REQUEST;
            default:
                return org.hl7.fhir.dstu2.model.TestScript.AssertionDirectionType.NULL;
        }
    }

    public static org.hl7.fhir.dstu3.model.TestScript.AssertionDirectionType convertAssertionDirectionType(org.hl7.fhir.dstu2.model.TestScript.AssertionDirectionType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case RESPONSE:
                return org.hl7.fhir.dstu3.model.TestScript.AssertionDirectionType.RESPONSE;
            case REQUEST:
                return org.hl7.fhir.dstu3.model.TestScript.AssertionDirectionType.REQUEST;
            default:
                return org.hl7.fhir.dstu3.model.TestScript.AssertionDirectionType.NULL;
        }
    }

    public static org.hl7.fhir.dstu3.model.TestScript.AssertionOperatorType convertAssertionOperatorType(org.hl7.fhir.dstu2.model.TestScript.AssertionOperatorType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case EQUALS:
                return org.hl7.fhir.dstu3.model.TestScript.AssertionOperatorType.EQUALS;
            case NOTEQUALS:
                return org.hl7.fhir.dstu3.model.TestScript.AssertionOperatorType.NOTEQUALS;
            case IN:
                return org.hl7.fhir.dstu3.model.TestScript.AssertionOperatorType.IN;
            case NOTIN:
                return org.hl7.fhir.dstu3.model.TestScript.AssertionOperatorType.NOTIN;
            case GREATERTHAN:
                return org.hl7.fhir.dstu3.model.TestScript.AssertionOperatorType.GREATERTHAN;
            case LESSTHAN:
                return org.hl7.fhir.dstu3.model.TestScript.AssertionOperatorType.LESSTHAN;
            case EMPTY:
                return org.hl7.fhir.dstu3.model.TestScript.AssertionOperatorType.EMPTY;
            case NOTEMPTY:
                return org.hl7.fhir.dstu3.model.TestScript.AssertionOperatorType.NOTEMPTY;
            case CONTAINS:
                return org.hl7.fhir.dstu3.model.TestScript.AssertionOperatorType.CONTAINS;
            case NOTCONTAINS:
                return org.hl7.fhir.dstu3.model.TestScript.AssertionOperatorType.NOTCONTAINS;
            default:
                return org.hl7.fhir.dstu3.model.TestScript.AssertionOperatorType.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.TestScript.AssertionOperatorType convertAssertionOperatorType(org.hl7.fhir.dstu3.model.TestScript.AssertionOperatorType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case EQUALS:
                return org.hl7.fhir.dstu2.model.TestScript.AssertionOperatorType.EQUALS;
            case NOTEQUALS:
                return org.hl7.fhir.dstu2.model.TestScript.AssertionOperatorType.NOTEQUALS;
            case IN:
                return org.hl7.fhir.dstu2.model.TestScript.AssertionOperatorType.IN;
            case NOTIN:
                return org.hl7.fhir.dstu2.model.TestScript.AssertionOperatorType.NOTIN;
            case GREATERTHAN:
                return org.hl7.fhir.dstu2.model.TestScript.AssertionOperatorType.GREATERTHAN;
            case LESSTHAN:
                return org.hl7.fhir.dstu2.model.TestScript.AssertionOperatorType.LESSTHAN;
            case EMPTY:
                return org.hl7.fhir.dstu2.model.TestScript.AssertionOperatorType.EMPTY;
            case NOTEMPTY:
                return org.hl7.fhir.dstu2.model.TestScript.AssertionOperatorType.NOTEMPTY;
            case CONTAINS:
                return org.hl7.fhir.dstu2.model.TestScript.AssertionOperatorType.CONTAINS;
            case NOTCONTAINS:
                return org.hl7.fhir.dstu2.model.TestScript.AssertionOperatorType.NOTCONTAINS;
            default:
                return org.hl7.fhir.dstu2.model.TestScript.AssertionOperatorType.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.TestScript.AssertionResponseTypes convertAssertionResponseTypes(org.hl7.fhir.dstu3.model.TestScript.AssertionResponseTypes src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case OKAY:
                return org.hl7.fhir.dstu2.model.TestScript.AssertionResponseTypes.OKAY;
            case CREATED:
                return org.hl7.fhir.dstu2.model.TestScript.AssertionResponseTypes.CREATED;
            case NOCONTENT:
                return org.hl7.fhir.dstu2.model.TestScript.AssertionResponseTypes.NOCONTENT;
            case NOTMODIFIED:
                return org.hl7.fhir.dstu2.model.TestScript.AssertionResponseTypes.NOTMODIFIED;
            case BAD:
                return org.hl7.fhir.dstu2.model.TestScript.AssertionResponseTypes.BAD;
            case FORBIDDEN:
                return org.hl7.fhir.dstu2.model.TestScript.AssertionResponseTypes.FORBIDDEN;
            case NOTFOUND:
                return org.hl7.fhir.dstu2.model.TestScript.AssertionResponseTypes.NOTFOUND;
            case METHODNOTALLOWED:
                return org.hl7.fhir.dstu2.model.TestScript.AssertionResponseTypes.METHODNOTALLOWED;
            case CONFLICT:
                return org.hl7.fhir.dstu2.model.TestScript.AssertionResponseTypes.CONFLICT;
            case GONE:
                return org.hl7.fhir.dstu2.model.TestScript.AssertionResponseTypes.GONE;
            case PRECONDITIONFAILED:
                return org.hl7.fhir.dstu2.model.TestScript.AssertionResponseTypes.PRECONDITIONFAILED;
            case UNPROCESSABLE:
                return org.hl7.fhir.dstu2.model.TestScript.AssertionResponseTypes.UNPROCESSABLE;
            default:
                return org.hl7.fhir.dstu2.model.TestScript.AssertionResponseTypes.NULL;
        }
    }

    public static org.hl7.fhir.dstu3.model.TestScript.AssertionResponseTypes convertAssertionResponseTypes(org.hl7.fhir.dstu2.model.TestScript.AssertionResponseTypes src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case OKAY:
                return org.hl7.fhir.dstu3.model.TestScript.AssertionResponseTypes.OKAY;
            case CREATED:
                return org.hl7.fhir.dstu3.model.TestScript.AssertionResponseTypes.CREATED;
            case NOCONTENT:
                return org.hl7.fhir.dstu3.model.TestScript.AssertionResponseTypes.NOCONTENT;
            case NOTMODIFIED:
                return org.hl7.fhir.dstu3.model.TestScript.AssertionResponseTypes.NOTMODIFIED;
            case BAD:
                return org.hl7.fhir.dstu3.model.TestScript.AssertionResponseTypes.BAD;
            case FORBIDDEN:
                return org.hl7.fhir.dstu3.model.TestScript.AssertionResponseTypes.FORBIDDEN;
            case NOTFOUND:
                return org.hl7.fhir.dstu3.model.TestScript.AssertionResponseTypes.NOTFOUND;
            case METHODNOTALLOWED:
                return org.hl7.fhir.dstu3.model.TestScript.AssertionResponseTypes.METHODNOTALLOWED;
            case CONFLICT:
                return org.hl7.fhir.dstu3.model.TestScript.AssertionResponseTypes.CONFLICT;
            case GONE:
                return org.hl7.fhir.dstu3.model.TestScript.AssertionResponseTypes.GONE;
            case PRECONDITIONFAILED:
                return org.hl7.fhir.dstu3.model.TestScript.AssertionResponseTypes.PRECONDITIONFAILED;
            case UNPROCESSABLE:
                return org.hl7.fhir.dstu3.model.TestScript.AssertionResponseTypes.UNPROCESSABLE;
            default:
                return org.hl7.fhir.dstu3.model.TestScript.AssertionResponseTypes.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.TestScript.ContentType convertContentType(org.hl7.fhir.dstu3.model.TestScript.ContentType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case XML:
                return org.hl7.fhir.dstu2.model.TestScript.ContentType.XML;
            case JSON:
                return org.hl7.fhir.dstu2.model.TestScript.ContentType.JSON;
            default:
                return org.hl7.fhir.dstu2.model.TestScript.ContentType.NULL;
        }
    }

    public static org.hl7.fhir.dstu3.model.TestScript.ContentType convertContentType(org.hl7.fhir.dstu2.model.TestScript.ContentType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case XML:
                return org.hl7.fhir.dstu3.model.TestScript.ContentType.XML;
            case JSON:
                return org.hl7.fhir.dstu3.model.TestScript.ContentType.JSON;
            default:
                return org.hl7.fhir.dstu3.model.TestScript.ContentType.NULL;
        }
    }

    public static org.hl7.fhir.dstu3.model.TestScript.SetupActionAssertComponent convertSetupActionAssertComponent(org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupActionAssertComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.TestScript.SetupActionAssertComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.SetupActionAssertComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasLabelElement())
            tgt.setLabelElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_10_30.convertType(src.getLabelElement()));
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_10_30.convertType(src.getDescriptionElement()));
        if (src.hasDirection()) {
            tgt.setDirection(convertAssertionDirectionType(src.getDirection()));
        }
        if (src.hasCompareToSourceIdElement())
            tgt.setCompareToSourceIdElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_10_30.convertType(src.getCompareToSourceIdElement()));
        if (src.hasCompareToSourcePathElement())
            tgt.setCompareToSourcePathElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_10_30.convertType(src.getCompareToSourcePathElement()));
        if (src.hasContentType()) {
            tgt.setContentType(convertContentType(src.getContentType()));
        }
        if (src.hasHeaderFieldElement())
            tgt.setHeaderFieldElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_10_30.convertType(src.getHeaderFieldElement()));
        if (src.hasMinimumIdElement())
            tgt.setMinimumIdElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_10_30.convertType(src.getMinimumIdElement()));
        if (src.hasNavigationLinks()) {
            tgt.setNavigationLinks(src.getNavigationLinks());
        }
        if (src.hasOperator()) {
            tgt.setOperator(convertAssertionOperatorType(src.getOperator()));
        }
        if (src.hasPathElement())
            tgt.setPathElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_10_30.convertType(src.getPathElement()));
        if (src.hasResourceElement())
            tgt.setResourceElement((org.hl7.fhir.dstu3.model.CodeType) VersionConvertor_10_30.convertType(src.getResourceElement()));
        if (src.hasResponse()) {
            tgt.setResponse(convertAssertionResponseTypes(src.getResponse()));
        }
        if (src.hasResponseCodeElement())
            tgt.setResponseCodeElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_10_30.convertType(src.getResponseCodeElement()));
        if (src.hasSourceIdElement())
            tgt.setSourceIdElement((org.hl7.fhir.dstu3.model.IdType) VersionConvertor_10_30.convertType(src.getSourceIdElement()));
        if (src.hasValidateProfileIdElement())
            tgt.setValidateProfileIdElement((org.hl7.fhir.dstu3.model.IdType) VersionConvertor_10_30.convertType(src.getValidateProfileIdElement()));
        if (src.hasValueElement())
            tgt.setValueElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_10_30.convertType(src.getValueElement()));
        if (src.hasWarningOnly()) {
            tgt.setWarningOnly(src.getWarningOnly());
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupActionAssertComponent convertSetupActionAssertComponent(org.hl7.fhir.dstu3.model.TestScript.SetupActionAssertComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupActionAssertComponent tgt = new org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupActionAssertComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasLabelElement())
            tgt.setLabelElement((org.hl7.fhir.dstu2.model.StringType) VersionConvertor_10_30.convertType(src.getLabelElement()));
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.dstu2.model.StringType) VersionConvertor_10_30.convertType(src.getDescriptionElement()));
        if (src.hasDirection()) {
            tgt.setDirection(convertAssertionDirectionType(src.getDirection()));
        }
        if (src.hasCompareToSourceIdElement())
            tgt.setCompareToSourceIdElement((org.hl7.fhir.dstu2.model.StringType) VersionConvertor_10_30.convertType(src.getCompareToSourceIdElement()));
        if (src.hasCompareToSourcePathElement())
            tgt.setCompareToSourcePathElement((org.hl7.fhir.dstu2.model.StringType) VersionConvertor_10_30.convertType(src.getCompareToSourcePathElement()));
        if (src.hasContentType()) {
            tgt.setContentType(convertContentType(src.getContentType()));
        }
        if (src.hasHeaderFieldElement())
            tgt.setHeaderFieldElement((org.hl7.fhir.dstu2.model.StringType) VersionConvertor_10_30.convertType(src.getHeaderFieldElement()));
        if (src.hasMinimumIdElement())
            tgt.setMinimumIdElement((org.hl7.fhir.dstu2.model.StringType) VersionConvertor_10_30.convertType(src.getMinimumIdElement()));
        if (src.hasNavigationLinks()) {
            tgt.setNavigationLinks(src.getNavigationLinks());
        }
        if (src.hasOperator()) {
            tgt.setOperator(convertAssertionOperatorType(src.getOperator()));
        }
        if (src.hasPathElement())
            tgt.setPathElement((org.hl7.fhir.dstu2.model.StringType) VersionConvertor_10_30.convertType(src.getPathElement()));
        if (src.hasResourceElement())
            tgt.setResourceElement((org.hl7.fhir.dstu2.model.CodeType) VersionConvertor_10_30.convertType(src.getResourceElement()));
        if (src.hasResponse()) {
            tgt.setResponse(convertAssertionResponseTypes(src.getResponse()));
        }
        if (src.hasResponseCodeElement())
            tgt.setResponseCodeElement((org.hl7.fhir.dstu2.model.StringType) VersionConvertor_10_30.convertType(src.getResponseCodeElement()));
        if (src.hasSourceIdElement())
            tgt.setSourceIdElement((org.hl7.fhir.dstu2.model.IdType) VersionConvertor_10_30.convertType(src.getSourceIdElement()));
        if (src.hasValidateProfileIdElement())
            tgt.setValidateProfileIdElement((org.hl7.fhir.dstu2.model.IdType) VersionConvertor_10_30.convertType(src.getValidateProfileIdElement()));
        if (src.hasValueElement())
            tgt.setValueElement((org.hl7.fhir.dstu2.model.StringType) VersionConvertor_10_30.convertType(src.getValueElement()));
        if (src.hasWarningOnly()) {
            tgt.setWarningOnly(src.getWarningOnly());
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TestScript.SetupActionComponent convertSetupActionComponent(org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupActionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.TestScript.SetupActionComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.SetupActionComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasOperation()) {
            tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
        }
        if (src.hasAssert()) {
            tgt.setAssert(convertSetupActionAssertComponent(src.getAssert()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupActionComponent convertSetupActionComponent(org.hl7.fhir.dstu3.model.TestScript.SetupActionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupActionComponent tgt = new org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupActionComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasOperation()) {
            tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
        }
        if (src.hasAssert()) {
            tgt.setAssert(convertSetupActionAssertComponent(src.getAssert()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupActionOperationComponent convertSetupActionOperationComponent(org.hl7.fhir.dstu3.model.TestScript.SetupActionOperationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupActionOperationComponent tgt = new org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupActionOperationComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasType()) {
            tgt.setType(VersionConvertor_10_30.convertCoding(src.getType()));
        }
        if (src.hasResourceElement())
            tgt.setResourceElement((org.hl7.fhir.dstu2.model.CodeType) VersionConvertor_10_30.convertType(src.getResourceElement()));
        if (src.hasLabelElement())
            tgt.setLabelElement((org.hl7.fhir.dstu2.model.StringType) VersionConvertor_10_30.convertType(src.getLabelElement()));
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.dstu2.model.StringType) VersionConvertor_10_30.convertType(src.getDescriptionElement()));
        if (src.hasAccept()) {
            tgt.setAccept(convertContentType(src.getAccept()));
        }
        if (src.hasContentType()) {
            tgt.setContentType(convertContentType(src.getContentType()));
        }
        if (src.hasDestinationElement()) {
            tgt.setDestinationElement((IntegerType) VersionConvertor_10_30.convertType(src.getDestinationElement()));
        }
        if (src.hasEncodeRequestUrlElement()) {
            tgt.setEncodeRequestUrlElement((BooleanType) VersionConvertor_10_30.convertType(src.getEncodeRequestUrlElement()));
        }
        if (src.hasParamsElement())
            tgt.setParamsElement((org.hl7.fhir.dstu2.model.StringType) VersionConvertor_10_30.convertType(src.getParamsElement()));
        if (src.hasRequestHeader()) {
            for (org.hl7.fhir.dstu3.model.TestScript.SetupActionOperationRequestHeaderComponent t : src.getRequestHeader()) tgt.addRequestHeader(convertSetupActionOperationRequestHeaderComponent(t));
        }
        if (src.hasResponseIdElement())
            tgt.setResponseIdElement((org.hl7.fhir.dstu2.model.IdType) VersionConvertor_10_30.convertType(src.getResponseIdElement()));
        if (src.hasSourceIdElement())
            tgt.setSourceIdElement((org.hl7.fhir.dstu2.model.IdType) VersionConvertor_10_30.convertType(src.getSourceIdElement()));
        if (src.hasTargetIdElement()) {
            tgt.setTargetIdElement((IdType) VersionConvertor_10_30.convertType(src.getTargetIdElement()));
        }
        if (src.hasUrlElement())
            tgt.setUrlElement((org.hl7.fhir.dstu2.model.StringType) VersionConvertor_10_30.convertType(src.getUrlElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TestScript.SetupActionOperationComponent convertSetupActionOperationComponent(org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupActionOperationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.TestScript.SetupActionOperationComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.SetupActionOperationComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasType()) {
            tgt.setType(VersionConvertor_10_30.convertCoding(src.getType()));
        }
        if (src.hasResourceElement())
            tgt.setResourceElement((org.hl7.fhir.dstu3.model.CodeType) VersionConvertor_10_30.convertType(src.getResourceElement()));
        if (src.hasLabelElement())
            tgt.setLabelElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_10_30.convertType(src.getLabelElement()));
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_10_30.convertType(src.getDescriptionElement()));
        if (src.hasAccept()) {
            tgt.setAccept(convertContentType(src.getAccept()));
        }
        if (src.hasContentType()) {
            tgt.setContentType(convertContentType(src.getContentType()));
        }
        if (src.hasDestinationElement()) {
            tgt.setDestinationElement((org.hl7.fhir.dstu3.model.IntegerType) VersionConvertor_10_30.convertType(src.getDestinationElement()));
        }
        if (src.hasEncodeRequestUrlElement()) {
            tgt.setEncodeRequestUrlElement((org.hl7.fhir.dstu3.model.BooleanType) VersionConvertor_10_30.convertType(src.getEncodeRequestUrlElement()));
        }
        if (src.hasParamsElement())
            tgt.setParamsElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_10_30.convertType(src.getParamsElement()));
        if (src.hasRequestHeader()) {
            for (org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupActionOperationRequestHeaderComponent t : src.getRequestHeader()) tgt.addRequestHeader(convertSetupActionOperationRequestHeaderComponent(t));
        }
        if (src.hasResponseIdElement())
            tgt.setResponseIdElement((org.hl7.fhir.dstu3.model.IdType) VersionConvertor_10_30.convertType(src.getResponseIdElement()));
        if (src.hasSourceIdElement())
            tgt.setSourceIdElement((org.hl7.fhir.dstu3.model.IdType) VersionConvertor_10_30.convertType(src.getSourceIdElement()));
        if (src.hasTargetIdElement()) {
            tgt.setTargetIdElement((org.hl7.fhir.dstu3.model.IdType) VersionConvertor_10_30.convertType(src.getTargetIdElement()));
        }
        if (src.hasUrlElement())
            tgt.setUrlElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_10_30.convertType(src.getUrlElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TestScript.SetupActionOperationRequestHeaderComponent convertSetupActionOperationRequestHeaderComponent(org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupActionOperationRequestHeaderComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.TestScript.SetupActionOperationRequestHeaderComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.SetupActionOperationRequestHeaderComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasFieldElement())
            tgt.setFieldElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_10_30.convertType(src.getFieldElement()));
        if (src.hasValueElement())
            tgt.setValueElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_10_30.convertType(src.getValueElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupActionOperationRequestHeaderComponent convertSetupActionOperationRequestHeaderComponent(org.hl7.fhir.dstu3.model.TestScript.SetupActionOperationRequestHeaderComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupActionOperationRequestHeaderComponent tgt = new org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupActionOperationRequestHeaderComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasFieldElement())
            tgt.setFieldElement((org.hl7.fhir.dstu2.model.StringType) VersionConvertor_10_30.convertType(src.getFieldElement()));
        if (src.hasValueElement())
            tgt.setValueElement((org.hl7.fhir.dstu2.model.StringType) VersionConvertor_10_30.convertType(src.getValueElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.TestScript.TestScriptTeardownActionComponent convertTeardownActionComponent(org.hl7.fhir.dstu3.model.TestScript.TeardownActionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.TestScript.TestScriptTeardownActionComponent tgt = new org.hl7.fhir.dstu2.model.TestScript.TestScriptTeardownActionComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasOperation()) {
            tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TestScript.TeardownActionComponent convertTeardownActionComponent(org.hl7.fhir.dstu2.model.TestScript.TestScriptTeardownActionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.TestScript.TeardownActionComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.TeardownActionComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasOperation()) {
            tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TestScript.TestActionComponent convertTestActionComponent(org.hl7.fhir.dstu2.model.TestScript.TestScriptTestActionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.TestScript.TestActionComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.TestActionComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasOperation()) {
            tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
        }
        if (src.hasAssert()) {
            tgt.setAssert(convertSetupActionAssertComponent(src.getAssert()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.TestScript.TestScriptTestActionComponent convertTestActionComponent(org.hl7.fhir.dstu3.model.TestScript.TestActionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.TestScript.TestScriptTestActionComponent tgt = new org.hl7.fhir.dstu2.model.TestScript.TestScriptTestActionComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasOperation()) {
            tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
        }
        if (src.hasAssert()) {
            tgt.setAssert(convertSetupActionAssertComponent(src.getAssert()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.TestScript convertTestScript(org.hl7.fhir.dstu3.model.TestScript src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.TestScript tgt = new org.hl7.fhir.dstu2.model.TestScript();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        if (src.hasUrlElement())
            tgt.setUrlElement((org.hl7.fhir.dstu2.model.UriType) VersionConvertor_10_30.convertType(src.getUrlElement()));
        if (src.hasVersionElement())
            tgt.setVersionElement((org.hl7.fhir.dstu2.model.StringType) VersionConvertor_10_30.convertType(src.getVersionElement()));
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.dstu2.model.StringType) VersionConvertor_10_30.convertType(src.getNameElement()));
        if (src.hasStatus()) {
            tgt.setStatus(VersionConvertor_10_30.convertConformanceResourceStatus(src.getStatus()));
        }
        if (src.hasIdentifier()) {
            tgt.setIdentifier(VersionConvertor_10_30.convertIdentifier(src.getIdentifier()));
        }
        if (src.hasExperimentalElement())
            tgt.setExperimentalElement((BooleanType) VersionConvertor_10_30.convertType(src.getExperimentalElement()));
        if (src.hasPublisherElement())
            tgt.setPublisherElement((org.hl7.fhir.dstu2.model.StringType) VersionConvertor_10_30.convertType(src.getPublisherElement()));
        if (src.hasContact()) {
            for (org.hl7.fhir.dstu3.model.ContactDetail t : src.getContact()) tgt.addContact(convertTestScriptContactComponent(t));
        }
        if (src.hasDateElement())
            tgt.setDateElement((org.hl7.fhir.dstu2.model.DateTimeType) VersionConvertor_10_30.convertType(src.getDateElement()));
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.dstu2.model.StringType) VersionConvertor_10_30.convertType(src.getDescriptionElement()));
        for (org.hl7.fhir.dstu3.model.UsageContext t : src.getUseContext()) if (t.hasValueCodeableConcept())
            tgt.addUseContext(VersionConvertor_10_30.convertCodeableConcept(t.getValueCodeableConcept()));
        if (src.hasJurisdiction()) {
            for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getJurisdiction()) tgt.addUseContext(VersionConvertor_10_30.convertCodeableConcept(t));
        }
        if (src.hasPurpose()) {
            tgt.setRequirements(src.getPurpose());
        }
        if (src.hasCopyrightElement())
            tgt.setCopyrightElement((org.hl7.fhir.dstu2.model.StringType) VersionConvertor_10_30.convertType(src.getCopyrightElement()));
        if (src.hasMetadata()) {
            tgt.setMetadata(convertTestScriptMetadataComponent(src.getMetadata()));
        }
        if (src.hasFixture()) {
            for (org.hl7.fhir.dstu3.model.TestScript.TestScriptFixtureComponent t : src.getFixture()) tgt.addFixture(convertTestScriptFixtureComponent(t));
        }
        if (src.hasProfile()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getProfile()) tgt.addProfile(VersionConvertor_10_30.convertReference(t));
        }
        if (src.hasVariable()) {
            for (org.hl7.fhir.dstu3.model.TestScript.TestScriptVariableComponent t : src.getVariable()) tgt.addVariable(convertTestScriptVariableComponent(t));
        }
        if (src.hasSetup()) {
            tgt.setSetup(convertTestScriptSetupComponent(src.getSetup()));
        }
        if (src.hasTest()) {
            for (org.hl7.fhir.dstu3.model.TestScript.TestScriptTestComponent t : src.getTest()) tgt.addTest(convertTestScriptTestComponent(t));
        }
        if (src.hasTeardown()) {
            tgt.setTeardown(convertTestScriptTeardownComponent(src.getTeardown()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TestScript convertTestScript(org.hl7.fhir.dstu2.model.TestScript src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.TestScript tgt = new org.hl7.fhir.dstu3.model.TestScript();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        if (src.hasUrlElement())
            tgt.setUrlElement((org.hl7.fhir.dstu3.model.UriType) VersionConvertor_10_30.convertType(src.getUrlElement()));
        if (src.hasVersionElement())
            tgt.setVersionElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_10_30.convertType(src.getVersionElement()));
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_10_30.convertType(src.getNameElement()));
        if (src.hasStatus()) {
            tgt.setStatus(VersionConvertor_10_30.convertConformanceResourceStatus(src.getStatus()));
        }
        if (src.hasIdentifier()) {
            tgt.setIdentifier(VersionConvertor_10_30.convertIdentifier(src.getIdentifier()));
        }
        if (src.hasExperimentalElement())
            tgt.setExperimentalElement((org.hl7.fhir.dstu3.model.BooleanType) VersionConvertor_10_30.convertType(src.getExperimentalElement()));
        if (src.hasPublisherElement())
            tgt.setPublisherElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_10_30.convertType(src.getPublisherElement()));
        if (src.hasContact()) {
            for (org.hl7.fhir.dstu2.model.TestScript.TestScriptContactComponent t : src.getContact()) tgt.addContact(convertTestScriptContactComponent(t));
        }
        if (src.hasDateElement())
            tgt.setDateElement((org.hl7.fhir.dstu3.model.DateTimeType) VersionConvertor_10_30.convertType(src.getDateElement()));
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.dstu3.model.MarkdownType) VersionConvertor_10_30.convertType(src.getDescriptionElement()));
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getUseContext()) if (VersionConvertor_10_30.isJurisdiction(t))
            tgt.addJurisdiction(VersionConvertor_10_30.convertCodeableConcept(t));
        else
            tgt.addUseContext(VersionConvertor_10_30.convertCodeableConceptToUsageContext(t));
        if (src.hasRequirements()) {
            tgt.setPurpose(src.getRequirements());
        }
        if (src.hasCopyrightElement())
            tgt.setCopyrightElement((org.hl7.fhir.dstu3.model.MarkdownType) VersionConvertor_10_30.convertType(src.getCopyrightElement()));
        if (src.hasMetadata()) {
            tgt.setMetadata(convertTestScriptMetadataComponent(src.getMetadata()));
        }
        if (src.hasFixture()) {
            for (org.hl7.fhir.dstu2.model.TestScript.TestScriptFixtureComponent t : src.getFixture()) tgt.addFixture(convertTestScriptFixtureComponent(t));
        }
        if (src.hasProfile()) {
            for (org.hl7.fhir.dstu2.model.Reference t : src.getProfile()) tgt.addProfile(VersionConvertor_10_30.convertReference(t));
        }
        if (src.hasVariable()) {
            for (org.hl7.fhir.dstu2.model.TestScript.TestScriptVariableComponent t : src.getVariable()) tgt.addVariable(convertTestScriptVariableComponent(t));
        }
        if (src.hasSetup()) {
            tgt.setSetup(convertTestScriptSetupComponent(src.getSetup()));
        }
        if (src.hasTest()) {
            for (org.hl7.fhir.dstu2.model.TestScript.TestScriptTestComponent t : src.getTest()) tgt.addTest(convertTestScriptTestComponent(t));
        }
        if (src.hasTeardown()) {
            tgt.setTeardown(convertTestScriptTeardownComponent(src.getTeardown()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ContactDetail convertTestScriptContactComponent(org.hl7.fhir.dstu2.model.TestScript.TestScriptContactComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ContactDetail tgt = new org.hl7.fhir.dstu3.model.ContactDetail();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_10_30.convertType(src.getNameElement()));
        if (src.hasTelecom()) {
            for (org.hl7.fhir.dstu2.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_10_30.convertContactPoint(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.TestScript.TestScriptContactComponent convertTestScriptContactComponent(org.hl7.fhir.dstu3.model.ContactDetail src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.TestScript.TestScriptContactComponent tgt = new org.hl7.fhir.dstu2.model.TestScript.TestScriptContactComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.dstu2.model.StringType) VersionConvertor_10_30.convertType(src.getNameElement()));
        if (src.hasTelecom()) {
            for (org.hl7.fhir.dstu3.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_10_30.convertContactPoint(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TestScript.TestScriptFixtureComponent convertTestScriptFixtureComponent(org.hl7.fhir.dstu2.model.TestScript.TestScriptFixtureComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.TestScript.TestScriptFixtureComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.TestScriptFixtureComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasAutocreateElement()) {
            tgt.setAutocreateElement((org.hl7.fhir.dstu3.model.BooleanType) VersionConvertor_10_30.convertType(src.getAutocreateElement()));
        }
        if (src.hasAutodeleteElement()) {
            tgt.setAutodeleteElement((org.hl7.fhir.dstu3.model.BooleanType) VersionConvertor_10_30.convertType(src.getAutodeleteElement()));
        }
        if (src.hasResource()) {
            tgt.setResource(VersionConvertor_10_30.convertReference(src.getResource()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.TestScript.TestScriptFixtureComponent convertTestScriptFixtureComponent(org.hl7.fhir.dstu3.model.TestScript.TestScriptFixtureComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.TestScript.TestScriptFixtureComponent tgt = new org.hl7.fhir.dstu2.model.TestScript.TestScriptFixtureComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasAutocreateElement()) {
            tgt.setAutocreateElement((BooleanType) VersionConvertor_10_30.convertType(src.getAutocreateElement()));
        }
        if (src.hasAutodeleteElement()) {
            tgt.setAutodeleteElement((BooleanType) VersionConvertor_10_30.convertType(src.getAutodeleteElement()));
        }
        if (src.hasResource()) {
            tgt.setResource(VersionConvertor_10_30.convertReference(src.getResource()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.TestScript.TestScriptMetadataCapabilityComponent convertTestScriptMetadataCapabilityComponent(org.hl7.fhir.dstu3.model.TestScript.TestScriptMetadataCapabilityComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.TestScript.TestScriptMetadataCapabilityComponent tgt = new org.hl7.fhir.dstu2.model.TestScript.TestScriptMetadataCapabilityComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasRequiredElement()) {
            tgt.setRequiredElement((BooleanType) VersionConvertor_10_30.convertType(src.getRequiredElement()));
        }
        if (src.hasValidatedElement()) {
            tgt.setValidatedElement((BooleanType) VersionConvertor_10_30.convertType(src.getValidatedElement()));
        }
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.dstu2.model.StringType) VersionConvertor_10_30.convertType(src.getDescriptionElement()));
        if (src.hasDestinationElement()) {
            tgt.setDestinationElement((IntegerType) VersionConvertor_10_30.convertType(src.getDestinationElement()));
        }
        if (src.hasLink()) {
            for (org.hl7.fhir.dstu3.model.UriType t : src.getLink()) tgt.addLink(t.getValue());
        }
        if (src.hasCapabilities()) {
            tgt.setConformance(VersionConvertor_10_30.convertReference(src.getCapabilities()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TestScript.TestScriptMetadataCapabilityComponent convertTestScriptMetadataCapabilityComponent(org.hl7.fhir.dstu2.model.TestScript.TestScriptMetadataCapabilityComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.TestScript.TestScriptMetadataCapabilityComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.TestScriptMetadataCapabilityComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasRequiredElement()) {
            tgt.setRequiredElement((org.hl7.fhir.dstu3.model.BooleanType) VersionConvertor_10_30.convertType(src.getRequiredElement()));
        }
        if (src.hasValidatedElement()) {
            tgt.setValidatedElement((org.hl7.fhir.dstu3.model.BooleanType) VersionConvertor_10_30.convertType(src.getValidatedElement()));
        }
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_10_30.convertType(src.getDescriptionElement()));
        if (src.hasDestinationElement()) {
            tgt.setDestinationElement((org.hl7.fhir.dstu3.model.IntegerType) VersionConvertor_10_30.convertType(src.getDestinationElement()));
        }
        if (src.hasLink()) {
            for (org.hl7.fhir.dstu2.model.UriType t : src.getLink()) tgt.addLink(t.getValue());
        }
        if (src.hasConformance()) {
            tgt.setCapabilities(VersionConvertor_10_30.convertReference(src.getConformance()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TestScript.TestScriptMetadataComponent convertTestScriptMetadataComponent(org.hl7.fhir.dstu2.model.TestScript.TestScriptMetadataComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.TestScript.TestScriptMetadataComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.TestScriptMetadataComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasLink()) {
            for (org.hl7.fhir.dstu2.model.TestScript.TestScriptMetadataLinkComponent t : src.getLink()) tgt.addLink(convertTestScriptMetadataLinkComponent(t));
        }
        if (src.hasCapability()) {
            for (org.hl7.fhir.dstu2.model.TestScript.TestScriptMetadataCapabilityComponent t : src.getCapability()) tgt.addCapability(convertTestScriptMetadataCapabilityComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.TestScript.TestScriptMetadataComponent convertTestScriptMetadataComponent(org.hl7.fhir.dstu3.model.TestScript.TestScriptMetadataComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.TestScript.TestScriptMetadataComponent tgt = new org.hl7.fhir.dstu2.model.TestScript.TestScriptMetadataComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasLink()) {
            for (org.hl7.fhir.dstu3.model.TestScript.TestScriptMetadataLinkComponent t : src.getLink()) tgt.addLink(convertTestScriptMetadataLinkComponent(t));
        }
        if (src.hasCapability()) {
            for (org.hl7.fhir.dstu3.model.TestScript.TestScriptMetadataCapabilityComponent t : src.getCapability()) tgt.addCapability(convertTestScriptMetadataCapabilityComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TestScript.TestScriptMetadataLinkComponent convertTestScriptMetadataLinkComponent(org.hl7.fhir.dstu2.model.TestScript.TestScriptMetadataLinkComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.TestScript.TestScriptMetadataLinkComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.TestScriptMetadataLinkComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasUrlElement())
            tgt.setUrlElement((org.hl7.fhir.dstu3.model.UriType) VersionConvertor_10_30.convertType(src.getUrlElement()));
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_10_30.convertType(src.getDescriptionElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.TestScript.TestScriptMetadataLinkComponent convertTestScriptMetadataLinkComponent(org.hl7.fhir.dstu3.model.TestScript.TestScriptMetadataLinkComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.TestScript.TestScriptMetadataLinkComponent tgt = new org.hl7.fhir.dstu2.model.TestScript.TestScriptMetadataLinkComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasUrlElement())
            tgt.setUrlElement((org.hl7.fhir.dstu2.model.UriType) VersionConvertor_10_30.convertType(src.getUrlElement()));
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.dstu2.model.StringType) VersionConvertor_10_30.convertType(src.getDescriptionElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TestScript.TestScriptSetupComponent convertTestScriptSetupComponent(org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.TestScript.TestScriptSetupComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.TestScriptSetupComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasAction()) {
            for (org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupActionComponent t : src.getAction()) tgt.addAction(convertSetupActionComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupComponent convertTestScriptSetupComponent(org.hl7.fhir.dstu3.model.TestScript.TestScriptSetupComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupComponent tgt = new org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasAction()) {
            for (org.hl7.fhir.dstu3.model.TestScript.SetupActionComponent t : src.getAction()) tgt.addAction(convertSetupActionComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TestScript.TestScriptTeardownComponent convertTestScriptTeardownComponent(org.hl7.fhir.dstu2.model.TestScript.TestScriptTeardownComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.TestScript.TestScriptTeardownComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.TestScriptTeardownComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasAction()) {
            for (org.hl7.fhir.dstu2.model.TestScript.TestScriptTeardownActionComponent t : src.getAction()) tgt.addAction(convertTeardownActionComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.TestScript.TestScriptTeardownComponent convertTestScriptTeardownComponent(org.hl7.fhir.dstu3.model.TestScript.TestScriptTeardownComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.TestScript.TestScriptTeardownComponent tgt = new org.hl7.fhir.dstu2.model.TestScript.TestScriptTeardownComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasAction()) {
            for (org.hl7.fhir.dstu3.model.TestScript.TeardownActionComponent t : src.getAction()) tgt.addAction(convertTeardownActionComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TestScript.TestScriptTestComponent convertTestScriptTestComponent(org.hl7.fhir.dstu2.model.TestScript.TestScriptTestComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.TestScript.TestScriptTestComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.TestScriptTestComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_10_30.convertType(src.getNameElement()));
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_10_30.convertType(src.getDescriptionElement()));
        if (src.hasAction()) {
            for (org.hl7.fhir.dstu2.model.TestScript.TestScriptTestActionComponent t : src.getAction()) tgt.addAction(convertTestActionComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.TestScript.TestScriptTestComponent convertTestScriptTestComponent(org.hl7.fhir.dstu3.model.TestScript.TestScriptTestComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.TestScript.TestScriptTestComponent tgt = new org.hl7.fhir.dstu2.model.TestScript.TestScriptTestComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.dstu2.model.StringType) VersionConvertor_10_30.convertType(src.getNameElement()));
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.dstu2.model.StringType) VersionConvertor_10_30.convertType(src.getDescriptionElement()));
        if (src.hasAction()) {
            for (org.hl7.fhir.dstu3.model.TestScript.TestActionComponent t : src.getAction()) tgt.addAction(convertTestActionComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TestScript.TestScriptVariableComponent convertTestScriptVariableComponent(org.hl7.fhir.dstu2.model.TestScript.TestScriptVariableComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.TestScript.TestScriptVariableComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.TestScriptVariableComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_10_30.convertType(src.getNameElement()));
        if (src.hasHeaderFieldElement())
            tgt.setHeaderFieldElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_10_30.convertType(src.getHeaderFieldElement()));
        if (src.hasPathElement())
            tgt.setPathElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_10_30.convertType(src.getPathElement()));
        if (src.hasSourceIdElement())
            tgt.setSourceIdElement((org.hl7.fhir.dstu3.model.IdType) VersionConvertor_10_30.convertType(src.getSourceIdElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.TestScript.TestScriptVariableComponent convertTestScriptVariableComponent(org.hl7.fhir.dstu3.model.TestScript.TestScriptVariableComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.TestScript.TestScriptVariableComponent tgt = new org.hl7.fhir.dstu2.model.TestScript.TestScriptVariableComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.dstu2.model.StringType) VersionConvertor_10_30.convertType(src.getNameElement()));
        if (src.hasHeaderFieldElement())
            tgt.setHeaderFieldElement((org.hl7.fhir.dstu2.model.StringType) VersionConvertor_10_30.convertType(src.getHeaderFieldElement()));
        if (src.hasPathElement())
            tgt.setPathElement((org.hl7.fhir.dstu2.model.StringType) VersionConvertor_10_30.convertType(src.getPathElement()));
        if (src.hasSourceIdElement())
            tgt.setSourceIdElement((org.hl7.fhir.dstu2.model.IdType) VersionConvertor_10_30.convertType(src.getSourceIdElement()));
        return tgt;
    }
}
