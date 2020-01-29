package org.hl7.fhir.convertors.conv10_30;

import org.hl7.fhir.convertors.VersionConvertor_10_30;
import org.hl7.fhir.exceptions.FHIRException;

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
        if (src.hasLabel()) {
            tgt.setLabel(src.getLabel());
        }
        if (src.hasDescription()) {
            tgt.setDescription(src.getDescription());
        }
        if (src.hasDirection()) {
            tgt.setDirection(convertAssertionDirectionType(src.getDirection()));
        }
        if (src.hasCompareToSourceId()) {
            tgt.setCompareToSourceId(src.getCompareToSourceId());
        }
        if (src.hasCompareToSourcePath()) {
            tgt.setCompareToSourcePath(src.getCompareToSourcePath());
        }
        if (src.hasContentType()) {
            tgt.setContentType(convertContentType(src.getContentType()));
        }
        if (src.hasHeaderField()) {
            tgt.setHeaderField(src.getHeaderField());
        }
        if (src.hasMinimumId()) {
            tgt.setMinimumId(src.getMinimumId());
        }
        if (src.hasNavigationLinks()) {
            tgt.setNavigationLinks(src.getNavigationLinks());
        }
        if (src.hasOperator()) {
            tgt.setOperator(convertAssertionOperatorType(src.getOperator()));
        }
        if (src.hasPath()) {
            tgt.setPath(src.getPath());
        }
        if (src.hasResource()) {
            tgt.setResource(src.getResource());
        }
        if (src.hasResponse()) {
            tgt.setResponse(convertAssertionResponseTypes(src.getResponse()));
        }
        if (src.hasResponseCode()) {
            tgt.setResponseCode(src.getResponseCode());
        }
        if (src.hasSourceId()) {
            tgt.setSourceId(src.getSourceId());
        }
        if (src.hasValidateProfileId()) {
            tgt.setValidateProfileId(src.getValidateProfileId());
        }
        if (src.hasValue()) {
            tgt.setValue(src.getValue());
        }
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
        if (src.hasLabel()) {
            tgt.setLabel(src.getLabel());
        }
        if (src.hasDescription()) {
            tgt.setDescription(src.getDescription());
        }
        if (src.hasDirection()) {
            tgt.setDirection(convertAssertionDirectionType(src.getDirection()));
        }
        if (src.hasCompareToSourceId()) {
            tgt.setCompareToSourceId(src.getCompareToSourceId());
        }
        if (src.hasCompareToSourcePath()) {
            tgt.setCompareToSourcePath(src.getCompareToSourcePath());
        }
        if (src.hasContentType()) {
            tgt.setContentType(convertContentType(src.getContentType()));
        }
        if (src.hasHeaderField()) {
            tgt.setHeaderField(src.getHeaderField());
        }
        if (src.hasMinimumId()) {
            tgt.setMinimumId(src.getMinimumId());
        }
        if (src.hasNavigationLinks()) {
            tgt.setNavigationLinks(src.getNavigationLinks());
        }
        if (src.hasOperator()) {
            tgt.setOperator(convertAssertionOperatorType(src.getOperator()));
        }
        if (src.hasPath()) {
            tgt.setPath(src.getPath());
        }
        if (src.hasResource()) {
            tgt.setResource(src.getResource());
        }
        if (src.hasResponse()) {
            tgt.setResponse(convertAssertionResponseTypes(src.getResponse()));
        }
        if (src.hasResponseCode()) {
            tgt.setResponseCode(src.getResponseCode());
        }
        if (src.hasSourceId()) {
            tgt.setSourceId(src.getSourceId());
        }
        if (src.hasValidateProfileId()) {
            tgt.setValidateProfileId(src.getValidateProfileId());
        }
        if (src.hasValue()) {
            tgt.setValue(src.getValue());
        }
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
        if (src.hasResource()) {
            tgt.setResource(src.getResource());
        }
        if (src.hasLabel()) {
            tgt.setLabel(src.getLabel());
        }
        if (src.hasDescription()) {
            tgt.setDescription(src.getDescription());
        }
        if (src.hasAccept()) {
            tgt.setAccept(convertContentType(src.getAccept()));
        }
        if (src.hasContentType()) {
            tgt.setContentType(convertContentType(src.getContentType()));
        }
        if (src.hasDestination()) {
            tgt.setDestination(src.getDestination());
        }
        if (src.hasEncodeRequestUrl()) {
            tgt.setEncodeRequestUrl(src.getEncodeRequestUrl());
        }
        if (src.hasParams()) {
            tgt.setParams(src.getParams());
        }
        if (src.hasRequestHeader()) {
            for (org.hl7.fhir.dstu3.model.TestScript.SetupActionOperationRequestHeaderComponent t : src.getRequestHeader()) tgt.addRequestHeader(convertSetupActionOperationRequestHeaderComponent(t));
        }
        if (src.hasResponseId()) {
            tgt.setResponseId(src.getResponseId());
        }
        if (src.hasSourceId()) {
            tgt.setSourceId(src.getSourceId());
        }
        if (src.hasTargetId()) {
            tgt.setTargetId(src.getTargetId());
        }
        if (src.hasUrl()) {
            tgt.setUrl(src.getUrl());
        }
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
        if (src.hasResource()) {
            tgt.setResource(src.getResource());
        }
        if (src.hasLabel()) {
            tgt.setLabel(src.getLabel());
        }
        if (src.hasDescription()) {
            tgt.setDescription(src.getDescription());
        }
        if (src.hasAccept()) {
            tgt.setAccept(convertContentType(src.getAccept()));
        }
        if (src.hasContentType()) {
            tgt.setContentType(convertContentType(src.getContentType()));
        }
        if (src.hasDestination()) {
            tgt.setDestination(src.getDestination());
        }
        if (src.hasEncodeRequestUrl()) {
            tgt.setEncodeRequestUrl(src.getEncodeRequestUrl());
        }
        if (src.hasParams()) {
            tgt.setParams(src.getParams());
        }
        if (src.hasRequestHeader()) {
            for (org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupActionOperationRequestHeaderComponent t : src.getRequestHeader()) tgt.addRequestHeader(convertSetupActionOperationRequestHeaderComponent(t));
        }
        if (src.hasResponseId()) {
            tgt.setResponseId(src.getResponseId());
        }
        if (src.hasSourceId()) {
            tgt.setSourceId(src.getSourceId());
        }
        if (src.hasTargetId()) {
            tgt.setTargetId(src.getTargetId());
        }
        if (src.hasUrl()) {
            tgt.setUrl(src.getUrl());
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TestScript.SetupActionOperationRequestHeaderComponent convertSetupActionOperationRequestHeaderComponent(org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupActionOperationRequestHeaderComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.TestScript.SetupActionOperationRequestHeaderComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.SetupActionOperationRequestHeaderComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasField()) {
            tgt.setField(src.getField());
        }
        if (src.hasValue()) {
            tgt.setValue(src.getValue());
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupActionOperationRequestHeaderComponent convertSetupActionOperationRequestHeaderComponent(org.hl7.fhir.dstu3.model.TestScript.SetupActionOperationRequestHeaderComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupActionOperationRequestHeaderComponent tgt = new org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupActionOperationRequestHeaderComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasField()) {
            tgt.setField(src.getField());
        }
        if (src.hasValue()) {
            tgt.setValue(src.getValue());
        }
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
        if (src.hasUrl()) {
            tgt.setUrl(src.getUrl());
        }
        if (src.hasVersion()) {
            tgt.setVersion(src.getVersion());
        }
        if (src.hasName()) {
            tgt.setName(src.getName());
        }
        if (src.hasStatus()) {
            tgt.setStatus(VersionConvertor_10_30.convertConformanceResourceStatus(src.getStatus()));
        }
        if (src.hasIdentifier()) {
            tgt.setIdentifier(VersionConvertor_10_30.convertIdentifier(src.getIdentifier()));
        }
        if (src.hasExperimental())
            tgt.setExperimental(src.getExperimental());
        if (src.hasPublisher()) {
            tgt.setPublisher(src.getPublisher());
        }
        if (src.hasContact()) {
            for (org.hl7.fhir.dstu3.model.ContactDetail t : src.getContact()) tgt.addContact(convertTestScriptContactComponent(t));
        }
        if (src.hasDate())
            tgt.setDate(src.getDate());
        if (src.hasDescription()) {
            tgt.setDescription(src.getDescription());
        }
        for (org.hl7.fhir.dstu3.model.UsageContext t : src.getUseContext()) if (t.hasValueCodeableConcept())
            tgt.addUseContext(VersionConvertor_10_30.convertCodeableConcept(t.getValueCodeableConcept()));
        if (src.hasJurisdiction()) {
            for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getJurisdiction()) tgt.addUseContext(VersionConvertor_10_30.convertCodeableConcept(t));
        }
        if (src.hasPurpose()) {
            tgt.setRequirements(src.getPurpose());
        }
        if (src.hasCopyright()) {
            tgt.setCopyright(src.getCopyright());
        }
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
        if (src.hasUrl()) {
            tgt.setUrl(src.getUrl());
        }
        if (src.hasVersion()) {
            tgt.setVersion(src.getVersion());
        }
        if (src.hasName()) {
            tgt.setName(src.getName());
        }
        if (src.hasStatus()) {
            tgt.setStatus(VersionConvertor_10_30.convertConformanceResourceStatus(src.getStatus()));
        }
        if (src.hasIdentifier()) {
            tgt.setIdentifier(VersionConvertor_10_30.convertIdentifier(src.getIdentifier()));
        }
        if (src.hasExperimental())
            tgt.setExperimental(src.getExperimental());
        if (src.hasPublisher()) {
            tgt.setPublisher(src.getPublisher());
        }
        if (src.hasContact()) {
            for (org.hl7.fhir.dstu2.model.TestScript.TestScriptContactComponent t : src.getContact()) tgt.addContact(convertTestScriptContactComponent(t));
        }
        if (src.hasDate())
            tgt.setDate(src.getDate());
        if (src.hasDescription()) {
            tgt.setDescription(src.getDescription());
        }
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getUseContext()) if (VersionConvertor_10_30.isJurisdiction(t))
            tgt.addJurisdiction(VersionConvertor_10_30.convertCodeableConcept(t));
        else
            tgt.addUseContext(VersionConvertor_10_30.convertCodeableConceptToUsageContext(t));
        if (src.hasRequirements()) {
            tgt.setPurpose(src.getRequirements());
        }
        if (src.hasCopyright()) {
            tgt.setCopyright(src.getCopyright());
        }
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
        if (src.hasName()) {
            tgt.setName(src.getName());
        }
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
        if (src.hasName()) {
            tgt.setName(src.getName());
        }
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
        if (src.hasAutocreate()) {
            tgt.setAutocreate(src.getAutocreate());
        }
        if (src.hasAutodelete()) {
            tgt.setAutodelete(src.getAutodelete());
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
        if (src.hasAutocreate()) {
            tgt.setAutocreate(src.getAutocreate());
        }
        if (src.hasAutodelete()) {
            tgt.setAutodelete(src.getAutodelete());
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
        if (src.hasRequired()) {
            tgt.setRequired(src.getRequired());
        }
        if (src.hasValidated()) {
            tgt.setValidated(src.getValidated());
        }
        if (src.hasDescription()) {
            tgt.setDescription(src.getDescription());
        }
        if (src.hasDestination()) {
            tgt.setDestination(src.getDestination());
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
        if (src.hasRequired()) {
            tgt.setRequired(src.getRequired());
        }
        if (src.hasValidated()) {
            tgt.setValidated(src.getValidated());
        }
        if (src.hasDescription()) {
            tgt.setDescription(src.getDescription());
        }
        if (src.hasDestination()) {
            tgt.setDestination(src.getDestination());
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
        if (src.hasUrl()) {
            tgt.setUrl(src.getUrl());
        }
        if (src.hasDescription()) {
            tgt.setDescription(src.getDescription());
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.TestScript.TestScriptMetadataLinkComponent convertTestScriptMetadataLinkComponent(org.hl7.fhir.dstu3.model.TestScript.TestScriptMetadataLinkComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.TestScript.TestScriptMetadataLinkComponent tgt = new org.hl7.fhir.dstu2.model.TestScript.TestScriptMetadataLinkComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasUrl()) {
            tgt.setUrl(src.getUrl());
        }
        if (src.hasDescription()) {
            tgt.setDescription(src.getDescription());
        }
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
        if (src.hasName()) {
            tgt.setName(src.getName());
        }
        if (src.hasDescription()) {
            tgt.setDescription(src.getDescription());
        }
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
        if (src.hasName()) {
            tgt.setName(src.getName());
        }
        if (src.hasDescription()) {
            tgt.setDescription(src.getDescription());
        }
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
        if (src.hasName()) {
            tgt.setName(src.getName());
        }
        if (src.hasHeaderField()) {
            tgt.setHeaderField(src.getHeaderField());
        }
        if (src.hasPath()) {
            tgt.setPath(src.getPath());
        }
        if (src.hasSourceId()) {
            tgt.setSourceId(src.getSourceId());
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.TestScript.TestScriptVariableComponent convertTestScriptVariableComponent(org.hl7.fhir.dstu3.model.TestScript.TestScriptVariableComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.TestScript.TestScriptVariableComponent tgt = new org.hl7.fhir.dstu2.model.TestScript.TestScriptVariableComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasName()) {
            tgt.setName(src.getName());
        }
        if (src.hasHeaderField()) {
            tgt.setHeaderField(src.getHeaderField());
        }
        if (src.hasPath()) {
            tgt.setPath(src.getPath());
        }
        if (src.hasSourceId()) {
            tgt.setSourceId(src.getSourceId());
        }
        return tgt;
    }
}
