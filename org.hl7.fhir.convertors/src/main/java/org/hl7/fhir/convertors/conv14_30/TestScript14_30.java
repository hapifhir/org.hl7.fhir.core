package org.hl7.fhir.convertors.conv14_30;

import org.hl7.fhir.convertors.VersionConvertor_14_30;
import org.hl7.fhir.dstu2016may.model.StringType;
import org.hl7.fhir.exceptions.FHIRException;
import java.util.Collections;

public class TestScript14_30 {

    static public org.hl7.fhir.dstu3.model.TestScript.AssertionDirectionType convertAssertionDirectionType(org.hl7.fhir.dstu2016may.model.TestScript.AssertionDirectionType src) throws FHIRException {
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

    static public org.hl7.fhir.dstu2016may.model.TestScript.AssertionDirectionType convertAssertionDirectionType(org.hl7.fhir.dstu3.model.TestScript.AssertionDirectionType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case RESPONSE:
                return org.hl7.fhir.dstu2016may.model.TestScript.AssertionDirectionType.RESPONSE;
            case REQUEST:
                return org.hl7.fhir.dstu2016may.model.TestScript.AssertionDirectionType.REQUEST;
            default:
                return org.hl7.fhir.dstu2016may.model.TestScript.AssertionDirectionType.NULL;
        }
    }

    static public org.hl7.fhir.dstu2016may.model.TestScript.AssertionOperatorType convertAssertionOperatorType(org.hl7.fhir.dstu3.model.TestScript.AssertionOperatorType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case EQUALS:
                return org.hl7.fhir.dstu2016may.model.TestScript.AssertionOperatorType.EQUALS;
            case NOTEQUALS:
                return org.hl7.fhir.dstu2016may.model.TestScript.AssertionOperatorType.NOTEQUALS;
            case IN:
                return org.hl7.fhir.dstu2016may.model.TestScript.AssertionOperatorType.IN;
            case NOTIN:
                return org.hl7.fhir.dstu2016may.model.TestScript.AssertionOperatorType.NOTIN;
            case GREATERTHAN:
                return org.hl7.fhir.dstu2016may.model.TestScript.AssertionOperatorType.GREATERTHAN;
            case LESSTHAN:
                return org.hl7.fhir.dstu2016may.model.TestScript.AssertionOperatorType.LESSTHAN;
            case EMPTY:
                return org.hl7.fhir.dstu2016may.model.TestScript.AssertionOperatorType.EMPTY;
            case NOTEMPTY:
                return org.hl7.fhir.dstu2016may.model.TestScript.AssertionOperatorType.NOTEMPTY;
            case CONTAINS:
                return org.hl7.fhir.dstu2016may.model.TestScript.AssertionOperatorType.CONTAINS;
            case NOTCONTAINS:
                return org.hl7.fhir.dstu2016may.model.TestScript.AssertionOperatorType.NOTCONTAINS;
            default:
                return org.hl7.fhir.dstu2016may.model.TestScript.AssertionOperatorType.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.TestScript.AssertionOperatorType convertAssertionOperatorType(org.hl7.fhir.dstu2016may.model.TestScript.AssertionOperatorType src) throws FHIRException {
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

    static public org.hl7.fhir.dstu3.model.TestScript.AssertionResponseTypes convertAssertionResponseTypes(org.hl7.fhir.dstu2016may.model.TestScript.AssertionResponseTypes src) throws FHIRException {
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

    static public org.hl7.fhir.dstu2016may.model.TestScript.AssertionResponseTypes convertAssertionResponseTypes(org.hl7.fhir.dstu3.model.TestScript.AssertionResponseTypes src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case OKAY:
                return org.hl7.fhir.dstu2016may.model.TestScript.AssertionResponseTypes.OKAY;
            case CREATED:
                return org.hl7.fhir.dstu2016may.model.TestScript.AssertionResponseTypes.CREATED;
            case NOCONTENT:
                return org.hl7.fhir.dstu2016may.model.TestScript.AssertionResponseTypes.NOCONTENT;
            case NOTMODIFIED:
                return org.hl7.fhir.dstu2016may.model.TestScript.AssertionResponseTypes.NOTMODIFIED;
            case BAD:
                return org.hl7.fhir.dstu2016may.model.TestScript.AssertionResponseTypes.BAD;
            case FORBIDDEN:
                return org.hl7.fhir.dstu2016may.model.TestScript.AssertionResponseTypes.FORBIDDEN;
            case NOTFOUND:
                return org.hl7.fhir.dstu2016may.model.TestScript.AssertionResponseTypes.NOTFOUND;
            case METHODNOTALLOWED:
                return org.hl7.fhir.dstu2016may.model.TestScript.AssertionResponseTypes.METHODNOTALLOWED;
            case CONFLICT:
                return org.hl7.fhir.dstu2016may.model.TestScript.AssertionResponseTypes.CONFLICT;
            case GONE:
                return org.hl7.fhir.dstu2016may.model.TestScript.AssertionResponseTypes.GONE;
            case PRECONDITIONFAILED:
                return org.hl7.fhir.dstu2016may.model.TestScript.AssertionResponseTypes.PRECONDITIONFAILED;
            case UNPROCESSABLE:
                return org.hl7.fhir.dstu2016may.model.TestScript.AssertionResponseTypes.UNPROCESSABLE;
            default:
                return org.hl7.fhir.dstu2016may.model.TestScript.AssertionResponseTypes.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.TestScript.ContentType convertContentType(org.hl7.fhir.dstu2016may.model.TestScript.ContentType src) throws FHIRException {
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

    static public org.hl7.fhir.dstu2016may.model.TestScript.ContentType convertContentType(org.hl7.fhir.dstu3.model.TestScript.ContentType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case XML:
                return org.hl7.fhir.dstu2016may.model.TestScript.ContentType.XML;
            case JSON:
                return org.hl7.fhir.dstu2016may.model.TestScript.ContentType.JSON;
            default:
                return org.hl7.fhir.dstu2016may.model.TestScript.ContentType.NULL;
        }
    }

    public static org.hl7.fhir.dstu2016may.model.TestScript.SetupActionAssertComponent convertSetupActionAssertComponent(org.hl7.fhir.dstu3.model.TestScript.SetupActionAssertComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.TestScript.SetupActionAssertComponent tgt = new org.hl7.fhir.dstu2016may.model.TestScript.SetupActionAssertComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasLabelElement())
            tgt.setLabelElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_30.convertType(src.getLabelElement()));
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_30.convertType(src.getDescriptionElement()));
        if (src.hasDirection()) {
            tgt.setDirection(convertAssertionDirectionType(src.getDirection()));
        }
        if (src.hasCompareToSourceIdElement())
            tgt.setCompareToSourceIdElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_30.convertType(src.getCompareToSourceIdElement()));
        if (src.hasCompareToSourcePathElement())
            tgt.setCompareToSourcePathElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_30.convertType(src.getCompareToSourcePathElement()));
        if (src.hasContentType()) {
            tgt.setContentType(convertContentType(src.getContentType()));
        }
        if (src.hasHeaderFieldElement())
            tgt.setHeaderFieldElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_30.convertType(src.getHeaderFieldElement()));
        if (src.hasMinimumIdElement())
            tgt.setMinimumIdElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_30.convertType(src.getMinimumIdElement()));
        if (src.hasNavigationLinksElement())
            tgt.setNavigationLinksElement((org.hl7.fhir.dstu2016may.model.BooleanType) VersionConvertor_14_30.convertType(src.getNavigationLinksElement()));
        if (src.hasOperator()) {
            tgt.setOperator(convertAssertionOperatorType(src.getOperator()));
        }
        if (src.hasPathElement())
            tgt.setPathElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_30.convertType(src.getPathElement()));
        if (src.hasResourceElement())
            tgt.setResourceElement((org.hl7.fhir.dstu2016may.model.CodeType) VersionConvertor_14_30.convertType(src.getResourceElement()));
        if (src.hasResponse()) {
            tgt.setResponse(convertAssertionResponseTypes(src.getResponse()));
        }
        if (src.hasResponseCodeElement())
            tgt.setResponseCodeElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_30.convertType(src.getResponseCodeElement()));
        if (src.hasRule()) {
            tgt.setRule(convertSetupActionAssertRuleComponent(src.getRule()));
        }
        if (src.hasRuleset()) {
            tgt.setRuleset(convertSetupActionAssertRulesetComponent(src.getRuleset()));
        }
        if (src.hasSourceIdElement())
            tgt.setSourceIdElement((org.hl7.fhir.dstu2016may.model.IdType) VersionConvertor_14_30.convertType(src.getSourceIdElement()));
        if (src.hasValidateProfileIdElement())
            tgt.setValidateProfileIdElement((org.hl7.fhir.dstu2016may.model.IdType) VersionConvertor_14_30.convertType(src.getValidateProfileIdElement()));
        if (src.hasValueElement())
            tgt.setValueElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_30.convertType(src.getValueElement()));
        if (src.hasWarningOnlyElement())
            tgt.setWarningOnlyElement((org.hl7.fhir.dstu2016may.model.BooleanType) VersionConvertor_14_30.convertType(src.getWarningOnlyElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TestScript.SetupActionAssertComponent convertSetupActionAssertComponent(org.hl7.fhir.dstu2016may.model.TestScript.SetupActionAssertComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.TestScript.SetupActionAssertComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.SetupActionAssertComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasLabelElement())
            tgt.setLabelElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_14_30.convertType(src.getLabelElement()));
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_14_30.convertType(src.getDescriptionElement()));
        if (src.hasDirection()) {
            tgt.setDirection(convertAssertionDirectionType(src.getDirection()));
        }
        if (src.hasCompareToSourceIdElement())
            tgt.setCompareToSourceIdElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_14_30.convertType(src.getCompareToSourceIdElement()));
        if (src.hasCompareToSourcePathElement())
            tgt.setCompareToSourcePathElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_14_30.convertType(src.getCompareToSourcePathElement()));
        if (src.hasContentType()) {
            tgt.setContentType(convertContentType(src.getContentType()));
        }
        if (src.hasHeaderFieldElement())
            tgt.setHeaderFieldElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_14_30.convertType(src.getHeaderFieldElement()));
        if (src.hasMinimumIdElement())
            tgt.setMinimumIdElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_14_30.convertType(src.getMinimumIdElement()));
        if (src.hasNavigationLinksElement())
            tgt.setNavigationLinksElement((org.hl7.fhir.dstu3.model.BooleanType) VersionConvertor_14_30.convertType(src.getNavigationLinksElement()));
        if (src.hasOperator()) {
            tgt.setOperator(convertAssertionOperatorType(src.getOperator()));
        }
        if (src.hasPathElement())
            tgt.setPathElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_14_30.convertType(src.getPathElement()));
        if (src.hasResourceElement())
            tgt.setResourceElement((org.hl7.fhir.dstu3.model.CodeType) VersionConvertor_14_30.convertType(src.getResourceElement()));
        if (src.hasResponse()) {
            tgt.setResponse(convertAssertionResponseTypes(src.getResponse()));
        }
        if (src.hasResponseCodeElement())
            tgt.setResponseCodeElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_14_30.convertType(src.getResponseCodeElement()));
        if (src.hasRule()) {
            tgt.setRule(convertSetupActionAssertRuleComponent(src.getRule()));
        }
        if (src.hasRuleset()) {
            tgt.setRuleset(convertSetupActionAssertRulesetComponent(src.getRuleset()));
        }
        if (src.hasSourceIdElement())
            tgt.setSourceIdElement((org.hl7.fhir.dstu3.model.IdType) VersionConvertor_14_30.convertType(src.getSourceIdElement()));
        if (src.hasValidateProfileIdElement())
            tgt.setValidateProfileIdElement((org.hl7.fhir.dstu3.model.IdType) VersionConvertor_14_30.convertType(src.getValidateProfileIdElement()));
        if (src.hasValueElement())
            tgt.setValueElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_14_30.convertType(src.getValueElement()));
        if (src.hasWarningOnlyElement())
            tgt.setWarningOnlyElement((org.hl7.fhir.dstu3.model.BooleanType) VersionConvertor_14_30.convertType(src.getWarningOnlyElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.TestScript.SetupActionAssertRuleComponent convertSetupActionAssertRuleComponent(org.hl7.fhir.dstu3.model.TestScript.ActionAssertRuleComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.TestScript.SetupActionAssertRuleComponent tgt = new org.hl7.fhir.dstu2016may.model.TestScript.SetupActionAssertRuleComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasParam()) {
            for (org.hl7.fhir.dstu3.model.TestScript.ActionAssertRuleParamComponent t : src.getParam()) tgt.addParam(convertSetupActionAssertRuleParamComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TestScript.ActionAssertRuleComponent convertSetupActionAssertRuleComponent(org.hl7.fhir.dstu2016may.model.TestScript.SetupActionAssertRuleComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.TestScript.ActionAssertRuleComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.ActionAssertRuleComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasParam()) {
            for (org.hl7.fhir.dstu2016may.model.TestScript.SetupActionAssertRuleParamComponent t : src.getParam()) tgt.addParam(convertSetupActionAssertRuleParamComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TestScript.ActionAssertRuleParamComponent convertSetupActionAssertRuleParamComponent(org.hl7.fhir.dstu2016may.model.TestScript.SetupActionAssertRuleParamComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.TestScript.ActionAssertRuleParamComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.ActionAssertRuleParamComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_14_30.convertType(src.getNameElement()));
        if (src.hasValueElement())
            tgt.setValueElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_14_30.convertType(src.getValueElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.TestScript.SetupActionAssertRuleParamComponent convertSetupActionAssertRuleParamComponent(org.hl7.fhir.dstu3.model.TestScript.ActionAssertRuleParamComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.TestScript.SetupActionAssertRuleParamComponent tgt = new org.hl7.fhir.dstu2016may.model.TestScript.SetupActionAssertRuleParamComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_30.convertType(src.getNameElement()));
        if (src.hasValueElement())
            tgt.setValueElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_30.convertType(src.getValueElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.TestScript.SetupActionAssertRulesetComponent convertSetupActionAssertRulesetComponent(org.hl7.fhir.dstu3.model.TestScript.ActionAssertRulesetComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.TestScript.SetupActionAssertRulesetComponent tgt = new org.hl7.fhir.dstu2016may.model.TestScript.SetupActionAssertRulesetComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasRule()) {
            for (org.hl7.fhir.dstu3.model.TestScript.ActionAssertRulesetRuleComponent t : src.getRule()) tgt.addRule(convertSetupActionAssertRulesetRuleComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TestScript.ActionAssertRulesetComponent convertSetupActionAssertRulesetComponent(org.hl7.fhir.dstu2016may.model.TestScript.SetupActionAssertRulesetComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.TestScript.ActionAssertRulesetComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.ActionAssertRulesetComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasRule()) {
            for (org.hl7.fhir.dstu2016may.model.TestScript.SetupActionAssertRulesetRuleComponent t : src.getRule()) tgt.addRule(convertSetupActionAssertRulesetRuleComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TestScript.ActionAssertRulesetRuleComponent convertSetupActionAssertRulesetRuleComponent(org.hl7.fhir.dstu2016may.model.TestScript.SetupActionAssertRulesetRuleComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.TestScript.ActionAssertRulesetRuleComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.ActionAssertRulesetRuleComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasParam()) {
            for (org.hl7.fhir.dstu2016may.model.TestScript.SetupActionAssertRulesetRuleParamComponent t : src.getParam()) tgt.addParam(convertSetupActionAssertRulesetRuleParamComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.TestScript.SetupActionAssertRulesetRuleComponent convertSetupActionAssertRulesetRuleComponent(org.hl7.fhir.dstu3.model.TestScript.ActionAssertRulesetRuleComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.TestScript.SetupActionAssertRulesetRuleComponent tgt = new org.hl7.fhir.dstu2016may.model.TestScript.SetupActionAssertRulesetRuleComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasParam()) {
            for (org.hl7.fhir.dstu3.model.TestScript.ActionAssertRulesetRuleParamComponent t : src.getParam()) tgt.addParam(convertSetupActionAssertRulesetRuleParamComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.TestScript.SetupActionAssertRulesetRuleParamComponent convertSetupActionAssertRulesetRuleParamComponent(org.hl7.fhir.dstu3.model.TestScript.ActionAssertRulesetRuleParamComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.TestScript.SetupActionAssertRulesetRuleParamComponent tgt = new org.hl7.fhir.dstu2016may.model.TestScript.SetupActionAssertRulesetRuleParamComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_30.convertType(src.getNameElement()));
        if (src.hasValueElement())
            tgt.setValueElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_30.convertType(src.getValueElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TestScript.ActionAssertRulesetRuleParamComponent convertSetupActionAssertRulesetRuleParamComponent(org.hl7.fhir.dstu2016may.model.TestScript.SetupActionAssertRulesetRuleParamComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.TestScript.ActionAssertRulesetRuleParamComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.ActionAssertRulesetRuleParamComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_14_30.convertType(src.getNameElement()));
        if (src.hasValueElement())
            tgt.setValueElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_14_30.convertType(src.getValueElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.TestScript.SetupActionComponent convertSetupActionComponent(org.hl7.fhir.dstu3.model.TestScript.SetupActionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.TestScript.SetupActionComponent tgt = new org.hl7.fhir.dstu2016may.model.TestScript.SetupActionComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasOperation()) {
            tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
        }
        if (src.hasAssert()) {
            tgt.setAssert(convertSetupActionAssertComponent(src.getAssert()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TestScript.SetupActionComponent convertSetupActionComponent(org.hl7.fhir.dstu2016may.model.TestScript.SetupActionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.TestScript.SetupActionComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.SetupActionComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasOperation()) {
            tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
        }
        if (src.hasAssert()) {
            tgt.setAssert(convertSetupActionAssertComponent(src.getAssert()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TestScript.SetupActionOperationComponent convertSetupActionOperationComponent(org.hl7.fhir.dstu2016may.model.TestScript.SetupActionOperationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.TestScript.SetupActionOperationComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.SetupActionOperationComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasType()) {
            tgt.setType(VersionConvertor_14_30.convertCoding(src.getType()));
        }
        if (src.hasResourceElement())
            tgt.setResourceElement((org.hl7.fhir.dstu3.model.CodeType) VersionConvertor_14_30.convertType(src.getResourceElement()));
        if (src.hasLabelElement())
            tgt.setLabelElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_14_30.convertType(src.getLabelElement()));
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_14_30.convertType(src.getDescriptionElement()));
        if (src.hasAccept()) {
            tgt.setAccept(convertContentType(src.getAccept()));
        }
        if (src.hasContentType()) {
            tgt.setContentType(convertContentType(src.getContentType()));
        }
        if (src.hasDestinationElement())
            tgt.setDestinationElement((org.hl7.fhir.dstu3.model.IntegerType) VersionConvertor_14_30.convertType(src.getDestinationElement()));
        if (src.hasEncodeRequestUrlElement())
            tgt.setEncodeRequestUrlElement((org.hl7.fhir.dstu3.model.BooleanType) VersionConvertor_14_30.convertType(src.getEncodeRequestUrlElement()));
        if (src.hasOriginElement())
            tgt.setOriginElement((org.hl7.fhir.dstu3.model.IntegerType) VersionConvertor_14_30.convertType(src.getOriginElement()));
        if (src.hasParamsElement())
            tgt.setParamsElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_14_30.convertType(src.getParamsElement()));
        if (src.hasRequestHeader()) {
            for (org.hl7.fhir.dstu2016may.model.TestScript.SetupActionOperationRequestHeaderComponent t : src.getRequestHeader()) tgt.addRequestHeader(convertSetupActionOperationRequestHeaderComponent(t));
        }
        if (src.hasResponseIdElement())
            tgt.setResponseIdElement((org.hl7.fhir.dstu3.model.IdType) VersionConvertor_14_30.convertType(src.getResponseIdElement()));
        if (src.hasSourceIdElement())
            tgt.setSourceIdElement((org.hl7.fhir.dstu3.model.IdType) VersionConvertor_14_30.convertType(src.getSourceIdElement()));
        if (src.hasTargetId())
            tgt.setTargetId(src.getTargetId());
        if (src.hasUrlElement())
            tgt.setUrlElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_14_30.convertType(src.getUrlElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.TestScript.SetupActionOperationComponent convertSetupActionOperationComponent(org.hl7.fhir.dstu3.model.TestScript.SetupActionOperationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.TestScript.SetupActionOperationComponent tgt = new org.hl7.fhir.dstu2016may.model.TestScript.SetupActionOperationComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasResourceElement())
            tgt.setResourceElement((org.hl7.fhir.dstu2016may.model.CodeType) VersionConvertor_14_30.convertType(src.getResourceElement()));
        if (src.hasLabelElement())
            tgt.setLabelElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_30.convertType(src.getLabelElement()));
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_30.convertType(src.getDescriptionElement()));
        if (src.hasAccept()) {
            tgt.setAccept(convertContentType(src.getAccept()));
        }
        if (src.hasContentType()) {
            tgt.setContentType(convertContentType(src.getContentType()));
        }
        if (src.hasDestinationElement())
            tgt.setDestinationElement((org.hl7.fhir.dstu2016may.model.IntegerType) VersionConvertor_14_30.convertType(src.getDestinationElement()));
        if (src.hasEncodeRequestUrlElement())
            tgt.setEncodeRequestUrlElement((org.hl7.fhir.dstu2016may.model.BooleanType) VersionConvertor_14_30.convertType(src.getEncodeRequestUrlElement()));
        if (src.hasOriginElement())
            tgt.setOriginElement((org.hl7.fhir.dstu2016may.model.IntegerType) VersionConvertor_14_30.convertType(src.getOriginElement()));
        if (src.hasParamsElement())
            tgt.setParamsElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_30.convertType(src.getParamsElement()));
        if (src.hasRequestHeader()) {
            for (org.hl7.fhir.dstu3.model.TestScript.SetupActionOperationRequestHeaderComponent t : src.getRequestHeader()) tgt.addRequestHeader(convertSetupActionOperationRequestHeaderComponent(t));
        }
        if (src.hasResponseIdElement())
            tgt.setResponseIdElement((org.hl7.fhir.dstu2016may.model.IdType) VersionConvertor_14_30.convertType(src.getResponseIdElement()));
        if (src.hasSourceIdElement())
            tgt.setSourceIdElement((org.hl7.fhir.dstu2016may.model.IdType) VersionConvertor_14_30.convertType(src.getSourceIdElement()));
        if (src.hasTargetId())
            tgt.setTargetId(src.getTargetId());
        if (src.hasUrlElement())
            tgt.setUrlElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_30.convertType(src.getUrlElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TestScript.SetupActionOperationRequestHeaderComponent convertSetupActionOperationRequestHeaderComponent(org.hl7.fhir.dstu2016may.model.TestScript.SetupActionOperationRequestHeaderComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.TestScript.SetupActionOperationRequestHeaderComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.SetupActionOperationRequestHeaderComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasFieldElement())
            tgt.setFieldElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_14_30.convertType(src.getFieldElement()));
        if (src.hasValueElement())
            tgt.setValueElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_14_30.convertType(src.getValueElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.TestScript.SetupActionOperationRequestHeaderComponent convertSetupActionOperationRequestHeaderComponent(org.hl7.fhir.dstu3.model.TestScript.SetupActionOperationRequestHeaderComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.TestScript.SetupActionOperationRequestHeaderComponent tgt = new org.hl7.fhir.dstu2016may.model.TestScript.SetupActionOperationRequestHeaderComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasFieldElement())
            tgt.setFieldElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_30.convertType(src.getFieldElement()));
        if (src.hasValueElement())
            tgt.setValueElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_30.convertType(src.getValueElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TestScript.TeardownActionComponent convertTeardownActionComponent(org.hl7.fhir.dstu2016may.model.TestScript.TeardownActionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.TestScript.TeardownActionComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.TeardownActionComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasOperation()) {
            tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.TestScript.TeardownActionComponent convertTeardownActionComponent(org.hl7.fhir.dstu3.model.TestScript.TeardownActionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.TestScript.TeardownActionComponent tgt = new org.hl7.fhir.dstu2016may.model.TestScript.TeardownActionComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasOperation()) {
            tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.TestScript.TestActionComponent convertTestActionComponent(org.hl7.fhir.dstu3.model.TestScript.TestActionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.TestScript.TestActionComponent tgt = new org.hl7.fhir.dstu2016may.model.TestScript.TestActionComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasOperation()) {
            tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
        }
        if (src.hasAssert()) {
            tgt.setAssert(convertSetupActionAssertComponent(src.getAssert()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TestScript.TestActionComponent convertTestActionComponent(org.hl7.fhir.dstu2016may.model.TestScript.TestActionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.TestScript.TestActionComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.TestActionComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasOperation()) {
            tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
        }
        if (src.hasAssert()) {
            tgt.setAssert(convertSetupActionAssertComponent(src.getAssert()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TestScript convertTestScript(org.hl7.fhir.dstu2016may.model.TestScript src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.TestScript tgt = new org.hl7.fhir.dstu3.model.TestScript();
        VersionConvertor_14_30.copyDomainResource(src, tgt);
        if (src.hasUrlElement())
            tgt.setUrlElement((org.hl7.fhir.dstu3.model.UriType) VersionConvertor_14_30.convertType(src.getUrlElement()));
        if (src.hasVersionElement())
            tgt.setVersionElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_14_30.convertType(src.getVersionElement()));
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_14_30.convertType(src.getNameElement()));
        if (src.hasStatus()) {
            tgt.setStatus(VersionConvertor_14_30.convertConformanceResourceStatus(src.getStatus()));
        }
        if (src.hasIdentifier()) {
            tgt.setIdentifier(VersionConvertor_14_30.convertIdentifier(src.getIdentifier()));
        }
        if (src.hasExperimentalElement())
            tgt.setExperimentalElement((org.hl7.fhir.dstu3.model.BooleanType) VersionConvertor_14_30.convertType(src.getExperimentalElement()));
        if (src.hasPublisherElement())
            tgt.setPublisherElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_14_30.convertType(src.getPublisherElement()));
        if (src.hasContact()) {
            for (org.hl7.fhir.dstu2016may.model.TestScript.TestScriptContactComponent t : src.getContact()) tgt.addContact(convertTestScriptContactComponent(t));
        }
        if (src.hasDateElement())
            tgt.setDateElement((org.hl7.fhir.dstu3.model.DateTimeType) VersionConvertor_14_30.convertType(src.getDateElement()));
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.dstu3.model.MarkdownType) VersionConvertor_14_30.convertType(src.getDescriptionElement()));
        for (org.hl7.fhir.dstu2016may.model.CodeableConcept t : src.getUseContext()) if (VersionConvertor_14_30.isJurisdiction(t))
            tgt.addJurisdiction(VersionConvertor_14_30.convertCodeableConcept(t));
        else
            tgt.addUseContext(VersionConvertor_14_30.convertCodeableConceptToUsageContext(t));
        if (src.hasRequirements())
            tgt.setPurpose(src.getRequirements());
        if (src.hasCopyrightElement())
            tgt.setCopyrightElement((org.hl7.fhir.dstu3.model.MarkdownType) VersionConvertor_14_30.convertType(src.getCopyrightElement()));
        if (src.hasOrigin()) {
            for (org.hl7.fhir.dstu2016may.model.TestScript.TestScriptOriginComponent t : src.getOrigin()) tgt.addOrigin(convertTestScriptOriginComponent(t));
        }
        if (src.hasDestination()) {
            for (org.hl7.fhir.dstu2016may.model.TestScript.TestScriptDestinationComponent t : src.getDestination()) tgt.addDestination(convertTestScriptDestinationComponent(t));
        }
        if (src.hasMetadata()) {
            tgt.setMetadata(convertTestScriptMetadataComponent(src.getMetadata()));
        }
        if (src.hasFixture()) {
            for (org.hl7.fhir.dstu2016may.model.TestScript.TestScriptFixtureComponent t : src.getFixture()) tgt.addFixture(convertTestScriptFixtureComponent(t));
        }
        if (src.hasProfile()) {
            for (org.hl7.fhir.dstu2016may.model.Reference t : src.getProfile()) tgt.addProfile(VersionConvertor_14_30.convertReference(t));
        }
        if (src.hasVariable()) {
            for (org.hl7.fhir.dstu2016may.model.TestScript.TestScriptVariableComponent t : src.getVariable()) tgt.addVariable(convertTestScriptVariableComponent(t));
        }
        if (src.hasRule()) {
            for (org.hl7.fhir.dstu2016may.model.TestScript.TestScriptRuleComponent t : src.getRule()) tgt.addRule(convertTestScriptRuleComponent(t));
        }
        if (src.hasRuleset()) {
            for (org.hl7.fhir.dstu2016may.model.TestScript.TestScriptRulesetComponent t : src.getRuleset()) tgt.addRuleset(convertTestScriptRulesetComponent(t));
        }
        if (src.hasSetup()) {
            tgt.setSetup(convertTestScriptSetupComponent(src.getSetup()));
        }
        if (src.hasTest()) {
            for (org.hl7.fhir.dstu2016may.model.TestScript.TestScriptTestComponent t : src.getTest()) tgt.addTest(convertTestScriptTestComponent(t));
        }
        if (src.hasTeardown()) {
            tgt.setTeardown(convertTestScriptTeardownComponent(src.getTeardown()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.TestScript convertTestScript(org.hl7.fhir.dstu3.model.TestScript src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.TestScript tgt = new org.hl7.fhir.dstu2016may.model.TestScript();
        VersionConvertor_14_30.copyDomainResource(src, tgt);
        if (src.hasUrlElement())
            tgt.setUrlElement((org.hl7.fhir.dstu2016may.model.UriType) VersionConvertor_14_30.convertType(src.getUrlElement()));
        if (src.hasVersionElement())
            tgt.setVersionElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_30.convertType(src.getVersionElement()));
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_30.convertType(src.getNameElement()));
        if (src.hasStatus()) {
            tgt.setStatus(VersionConvertor_14_30.convertConformanceResourceStatus(src.getStatus()));
        }
        if (src.hasIdentifier()) {
            tgt.setIdentifier(VersionConvertor_14_30.convertIdentifier(src.getIdentifier()));
        }
        if (src.hasExperimentalElement())
            tgt.setExperimentalElement((org.hl7.fhir.dstu2016may.model.BooleanType) VersionConvertor_14_30.convertType(src.getExperimentalElement()));
        if (src.hasPublisherElement())
            tgt.setPublisherElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_30.convertType(src.getPublisherElement()));
        if (src.hasContact()) {
            for (org.hl7.fhir.dstu3.model.ContactDetail t : src.getContact()) tgt.addContact(convertTestScriptContactComponent(t));
        }
        if (src.hasDateElement())
            tgt.setDateElement((org.hl7.fhir.dstu2016may.model.DateTimeType) VersionConvertor_14_30.convertType(src.getDateElement()));
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_30.convertType(src.getDescriptionElement()));
        for (org.hl7.fhir.dstu3.model.UsageContext t : src.getUseContext()) if (t.hasValueCodeableConcept())
            tgt.addUseContext(VersionConvertor_14_30.convertCodeableConcept(t.getValueCodeableConcept()));
        if (src.hasJurisdiction()) {
            for (org.hl7.fhir.dstu3.model.CodeableConcept t : src.getJurisdiction()) tgt.addUseContext(VersionConvertor_14_30.convertCodeableConcept(t));
        }
        if (src.hasPurpose())
            tgt.setRequirements(src.getPurpose());
        if (src.hasCopyrightElement())
            tgt.setCopyrightElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_30.convertType(src.getCopyrightElement()));
        if (src.hasOrigin()) {
            for (org.hl7.fhir.dstu3.model.TestScript.TestScriptOriginComponent t : src.getOrigin()) tgt.addOrigin(convertTestScriptOriginComponent(t));
        }
        if (src.hasDestination()) {
            for (org.hl7.fhir.dstu3.model.TestScript.TestScriptDestinationComponent t : src.getDestination()) tgt.addDestination(convertTestScriptDestinationComponent(t));
        }
        if (src.hasMetadata()) {
            tgt.setMetadata(convertTestScriptMetadataComponent(src.getMetadata()));
        }
        if (src.hasFixture()) {
            for (org.hl7.fhir.dstu3.model.TestScript.TestScriptFixtureComponent t : src.getFixture()) tgt.addFixture(convertTestScriptFixtureComponent(t));
        }
        if (src.hasProfile()) {
            for (org.hl7.fhir.dstu3.model.Reference t : src.getProfile()) tgt.addProfile(VersionConvertor_14_30.convertReference(t));
        }
        if (src.hasVariable()) {
            for (org.hl7.fhir.dstu3.model.TestScript.TestScriptVariableComponent t : src.getVariable()) tgt.addVariable(convertTestScriptVariableComponent(t));
        }
        if (src.hasRule()) {
            for (org.hl7.fhir.dstu3.model.TestScript.TestScriptRuleComponent t : src.getRule()) tgt.addRule(convertTestScriptRuleComponent(t));
        }
        if (src.hasRuleset()) {
            for (org.hl7.fhir.dstu3.model.TestScript.TestScriptRulesetComponent t : src.getRuleset()) tgt.addRuleset(convertTestScriptRulesetComponent(t));
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

    public static org.hl7.fhir.dstu2016may.model.TestScript.TestScriptContactComponent convertTestScriptContactComponent(org.hl7.fhir.dstu3.model.ContactDetail src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.TestScript.TestScriptContactComponent tgt = new org.hl7.fhir.dstu2016may.model.TestScript.TestScriptContactComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement((StringType) VersionConvertor_14_30.convertType(src.getNameElement()));
        if (src.hasTelecom()) {
            for (org.hl7.fhir.dstu3.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_14_30.convertContactPoint(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.ContactDetail convertTestScriptContactComponent(org.hl7.fhir.dstu2016may.model.TestScript.TestScriptContactComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.ContactDetail tgt = new org.hl7.fhir.dstu3.model.ContactDetail();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_14_30.convertType(src.getNameElement()));
        if (src.hasTelecom()) {
            for (org.hl7.fhir.dstu2016may.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_14_30.convertContactPoint(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.TestScript.TestScriptDestinationComponent convertTestScriptDestinationComponent(org.hl7.fhir.dstu3.model.TestScript.TestScriptDestinationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.TestScript.TestScriptDestinationComponent tgt = new org.hl7.fhir.dstu2016may.model.TestScript.TestScriptDestinationComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasIndexElement())
            tgt.setIndexElement((org.hl7.fhir.dstu2016may.model.IntegerType) VersionConvertor_14_30.convertType(src.getIndexElement()));
        if (src.hasProfile()) {
            tgt.setProfile(VersionConvertor_14_30.convertCoding(src.getProfile()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TestScript.TestScriptDestinationComponent convertTestScriptDestinationComponent(org.hl7.fhir.dstu2016may.model.TestScript.TestScriptDestinationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.TestScript.TestScriptDestinationComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.TestScriptDestinationComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasIndexElement())
            tgt.setIndexElement((org.hl7.fhir.dstu3.model.IntegerType) VersionConvertor_14_30.convertType(src.getIndexElement()));
        if (src.hasProfile()) {
            tgt.setProfile(VersionConvertor_14_30.convertCoding(src.getProfile()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TestScript.TestScriptFixtureComponent convertTestScriptFixtureComponent(org.hl7.fhir.dstu2016may.model.TestScript.TestScriptFixtureComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.TestScript.TestScriptFixtureComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.TestScriptFixtureComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasAutocreateElement())
            tgt.setAutocreateElement((org.hl7.fhir.dstu3.model.BooleanType) VersionConvertor_14_30.convertType(src.getAutocreateElement()));
        if (src.hasAutodeleteElement())
            tgt.setAutodeleteElement((org.hl7.fhir.dstu3.model.BooleanType) VersionConvertor_14_30.convertType(src.getAutodeleteElement()));
        if (src.hasResource())
            tgt.setResource(VersionConvertor_14_30.convertReference(src.getResource()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.TestScript.TestScriptFixtureComponent convertTestScriptFixtureComponent(org.hl7.fhir.dstu3.model.TestScript.TestScriptFixtureComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.TestScript.TestScriptFixtureComponent tgt = new org.hl7.fhir.dstu2016may.model.TestScript.TestScriptFixtureComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasAutocreateElement())
            tgt.setAutocreateElement((org.hl7.fhir.dstu2016may.model.BooleanType) VersionConvertor_14_30.convertType(src.getAutocreateElement()));
        if (src.hasAutodeleteElement())
            tgt.setAutodeleteElement((org.hl7.fhir.dstu2016may.model.BooleanType) VersionConvertor_14_30.convertType(src.getAutodeleteElement()));
        if (src.hasResource())
            tgt.setResource(VersionConvertor_14_30.convertReference(src.getResource()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TestScript.TestScriptMetadataCapabilityComponent convertTestScriptMetadataCapabilityComponent(org.hl7.fhir.dstu2016may.model.TestScript.TestScriptMetadataCapabilityComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.TestScript.TestScriptMetadataCapabilityComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.TestScriptMetadataCapabilityComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasRequiredElement())
            tgt.setRequiredElement((org.hl7.fhir.dstu3.model.BooleanType) VersionConvertor_14_30.convertType(src.getRequiredElement()));
        if (src.hasValidatedElement())
            tgt.setValidatedElement((org.hl7.fhir.dstu3.model.BooleanType) VersionConvertor_14_30.convertType(src.getValidatedElement()));
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_14_30.convertType(src.getDescriptionElement()));
        if (src.hasOrigin()) {
            for (org.hl7.fhir.dstu2016may.model.IntegerType t : src.getOrigin()) tgt.addOrigin(t.getValue());
        }
        if (src.hasDestinationElement())
            tgt.setDestinationElement((org.hl7.fhir.dstu3.model.IntegerType) VersionConvertor_14_30.convertType(src.getDestinationElement()));
        if (src.hasLink()) {
            for (org.hl7.fhir.dstu2016may.model.UriType t : src.getLink()) tgt.addLink(t.getValue());
        }
        if (src.hasConformance()) {
            tgt.setCapabilities(VersionConvertor_14_30.convertReference(src.getConformance()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.TestScript.TestScriptMetadataCapabilityComponent convertTestScriptMetadataCapabilityComponent(org.hl7.fhir.dstu3.model.TestScript.TestScriptMetadataCapabilityComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.TestScript.TestScriptMetadataCapabilityComponent tgt = new org.hl7.fhir.dstu2016may.model.TestScript.TestScriptMetadataCapabilityComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasRequiredElement())
            tgt.setRequiredElement((org.hl7.fhir.dstu2016may.model.BooleanType) VersionConvertor_14_30.convertType(src.getRequiredElement()));
        if (src.hasValidatedElement())
            tgt.setValidatedElement((org.hl7.fhir.dstu2016may.model.BooleanType) VersionConvertor_14_30.convertType(src.getValidatedElement()));
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_30.convertType(src.getDescriptionElement()));
        if (src.hasOrigin()) {
            for (org.hl7.fhir.dstu3.model.IntegerType t : src.getOrigin()) tgt.addOrigin(t.getValue());
        }
        if (src.hasDestinationElement())
            tgt.setDestinationElement((org.hl7.fhir.dstu2016may.model.IntegerType) VersionConvertor_14_30.convertType(src.getDestinationElement()));
        if (src.hasLink()) {
            for (org.hl7.fhir.dstu3.model.UriType t : src.getLink()) tgt.addLink(t.getValue());
        }
        if (src.hasCapabilities()) {
            tgt.setConformance(VersionConvertor_14_30.convertReference(src.getCapabilities()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TestScript.TestScriptMetadataComponent convertTestScriptMetadataComponent(org.hl7.fhir.dstu2016may.model.TestScript.TestScriptMetadataComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.TestScript.TestScriptMetadataComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.TestScriptMetadataComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasLink()) {
            for (org.hl7.fhir.dstu2016may.model.TestScript.TestScriptMetadataLinkComponent t : src.getLink()) tgt.addLink(convertTestScriptMetadataLinkComponent(t));
        }
        if (src.hasCapability()) {
            for (org.hl7.fhir.dstu2016may.model.TestScript.TestScriptMetadataCapabilityComponent t : src.getCapability()) tgt.addCapability(convertTestScriptMetadataCapabilityComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.TestScript.TestScriptMetadataComponent convertTestScriptMetadataComponent(org.hl7.fhir.dstu3.model.TestScript.TestScriptMetadataComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.TestScript.TestScriptMetadataComponent tgt = new org.hl7.fhir.dstu2016may.model.TestScript.TestScriptMetadataComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasLink()) {
            for (org.hl7.fhir.dstu3.model.TestScript.TestScriptMetadataLinkComponent t : src.getLink()) tgt.addLink(convertTestScriptMetadataLinkComponent(t));
        }
        if (src.hasCapability()) {
            for (org.hl7.fhir.dstu3.model.TestScript.TestScriptMetadataCapabilityComponent t : src.getCapability()) tgt.addCapability(convertTestScriptMetadataCapabilityComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TestScript.TestScriptMetadataLinkComponent convertTestScriptMetadataLinkComponent(org.hl7.fhir.dstu2016may.model.TestScript.TestScriptMetadataLinkComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.TestScript.TestScriptMetadataLinkComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.TestScriptMetadataLinkComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasUrlElement())
            tgt.setUrlElement((org.hl7.fhir.dstu3.model.UriType) VersionConvertor_14_30.convertType(src.getUrlElement()));
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_14_30.convertType(src.getDescriptionElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.TestScript.TestScriptMetadataLinkComponent convertTestScriptMetadataLinkComponent(org.hl7.fhir.dstu3.model.TestScript.TestScriptMetadataLinkComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.TestScript.TestScriptMetadataLinkComponent tgt = new org.hl7.fhir.dstu2016may.model.TestScript.TestScriptMetadataLinkComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasUrlElement())
            tgt.setUrlElement((org.hl7.fhir.dstu2016may.model.UriType) VersionConvertor_14_30.convertType(src.getUrlElement()));
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_30.convertType(src.getDescriptionElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.TestScript.TestScriptOriginComponent convertTestScriptOriginComponent(org.hl7.fhir.dstu3.model.TestScript.TestScriptOriginComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.TestScript.TestScriptOriginComponent tgt = new org.hl7.fhir.dstu2016may.model.TestScript.TestScriptOriginComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasIndexElement())
            tgt.setIndexElement((org.hl7.fhir.dstu2016may.model.IntegerType) VersionConvertor_14_30.convertType(src.getIndexElement()));
        if (src.hasProfile()) {
            tgt.setProfile(VersionConvertor_14_30.convertCoding(src.getProfile()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TestScript.TestScriptOriginComponent convertTestScriptOriginComponent(org.hl7.fhir.dstu2016may.model.TestScript.TestScriptOriginComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.TestScript.TestScriptOriginComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.TestScriptOriginComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasIndexElement())
            tgt.setIndexElement((org.hl7.fhir.dstu3.model.IntegerType) VersionConvertor_14_30.convertType(src.getIndexElement()));
        if (src.hasProfile()) {
            tgt.setProfile(VersionConvertor_14_30.convertCoding(src.getProfile()));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TestScript.TestScriptRuleComponent convertTestScriptRuleComponent(org.hl7.fhir.dstu2016may.model.TestScript.TestScriptRuleComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.TestScript.TestScriptRuleComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.TestScriptRuleComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasResource()) {
            tgt.setResource(VersionConvertor_14_30.convertReference(src.getResource()));
        }
        if (src.hasParam()) {
            for (org.hl7.fhir.dstu2016may.model.TestScript.TestScriptRuleParamComponent t : src.getParam()) tgt.addParam(convertTestScriptRuleParamComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.TestScript.TestScriptRuleComponent convertTestScriptRuleComponent(org.hl7.fhir.dstu3.model.TestScript.TestScriptRuleComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.TestScript.TestScriptRuleComponent tgt = new org.hl7.fhir.dstu2016may.model.TestScript.TestScriptRuleComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasResource()) {
            tgt.setResource(VersionConvertor_14_30.convertReference(src.getResource()));
        }
        if (src.hasParam()) {
            for (org.hl7.fhir.dstu3.model.TestScript.RuleParamComponent t : src.getParam()) tgt.addParam(convertTestScriptRuleParamComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TestScript.RuleParamComponent convertTestScriptRuleParamComponent(org.hl7.fhir.dstu2016may.model.TestScript.TestScriptRuleParamComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.TestScript.RuleParamComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.RuleParamComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_14_30.convertType(src.getNameElement()));
        if (src.hasValueElement())
            tgt.setValueElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_14_30.convertType(src.getValueElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.TestScript.TestScriptRuleParamComponent convertTestScriptRuleParamComponent(org.hl7.fhir.dstu3.model.TestScript.RuleParamComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.TestScript.TestScriptRuleParamComponent tgt = new org.hl7.fhir.dstu2016may.model.TestScript.TestScriptRuleParamComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_30.convertType(src.getNameElement()));
        if (src.hasValueElement())
            tgt.setValueElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_30.convertType(src.getValueElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TestScript.TestScriptRulesetComponent convertTestScriptRulesetComponent(org.hl7.fhir.dstu2016may.model.TestScript.TestScriptRulesetComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.TestScript.TestScriptRulesetComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.TestScriptRulesetComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasResource()) {
            tgt.setResource(VersionConvertor_14_30.convertReference(src.getResource()));
        }
        if (src.hasRule()) {
            for (org.hl7.fhir.dstu2016may.model.TestScript.TestScriptRulesetRuleComponent t : src.getRule()) tgt.addRule(convertTestScriptRulesetRuleComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.TestScript.TestScriptRulesetComponent convertTestScriptRulesetComponent(org.hl7.fhir.dstu3.model.TestScript.TestScriptRulesetComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.TestScript.TestScriptRulesetComponent tgt = new org.hl7.fhir.dstu2016may.model.TestScript.TestScriptRulesetComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasResource()) {
            tgt.setResource(VersionConvertor_14_30.convertReference(src.getResource()));
        }
        if (src.hasRule()) {
            for (org.hl7.fhir.dstu3.model.TestScript.RulesetRuleComponent t : src.getRule()) tgt.addRule(convertTestScriptRulesetRuleComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.TestScript.TestScriptRulesetRuleComponent convertTestScriptRulesetRuleComponent(org.hl7.fhir.dstu3.model.TestScript.RulesetRuleComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.TestScript.TestScriptRulesetRuleComponent tgt = new org.hl7.fhir.dstu2016may.model.TestScript.TestScriptRulesetRuleComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasParam()) {
            for (org.hl7.fhir.dstu3.model.TestScript.RulesetRuleParamComponent t : src.getParam()) tgt.addParam(convertTestScriptRulesetRuleParamComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TestScript.RulesetRuleComponent convertTestScriptRulesetRuleComponent(org.hl7.fhir.dstu2016may.model.TestScript.TestScriptRulesetRuleComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.TestScript.RulesetRuleComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.RulesetRuleComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasParam()) {
            for (org.hl7.fhir.dstu2016may.model.TestScript.TestScriptRulesetRuleParamComponent t : src.getParam()) tgt.addParam(convertTestScriptRulesetRuleParamComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.TestScript.TestScriptRulesetRuleParamComponent convertTestScriptRulesetRuleParamComponent(org.hl7.fhir.dstu3.model.TestScript.RulesetRuleParamComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.TestScript.TestScriptRulesetRuleParamComponent tgt = new org.hl7.fhir.dstu2016may.model.TestScript.TestScriptRulesetRuleParamComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_30.convertType(src.getNameElement()));
        if (src.hasValueElement())
            tgt.setValueElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_30.convertType(src.getValueElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TestScript.RulesetRuleParamComponent convertTestScriptRulesetRuleParamComponent(org.hl7.fhir.dstu2016may.model.TestScript.TestScriptRulesetRuleParamComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.TestScript.RulesetRuleParamComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.RulesetRuleParamComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_14_30.convertType(src.getNameElement()));
        if (src.hasValueElement())
            tgt.setValueElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_14_30.convertType(src.getValueElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.TestScript.TestScriptSetupComponent convertTestScriptSetupComponent(org.hl7.fhir.dstu3.model.TestScript.TestScriptSetupComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.TestScript.TestScriptSetupComponent tgt = new org.hl7.fhir.dstu2016may.model.TestScript.TestScriptSetupComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasAction()) {
            for (org.hl7.fhir.dstu3.model.TestScript.SetupActionComponent t : src.getAction()) tgt.addAction(convertSetupActionComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TestScript.TestScriptSetupComponent convertTestScriptSetupComponent(org.hl7.fhir.dstu2016may.model.TestScript.TestScriptSetupComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.TestScript.TestScriptSetupComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.TestScriptSetupComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasAction()) {
            for (org.hl7.fhir.dstu2016may.model.TestScript.SetupActionComponent t : src.getAction()) tgt.addAction(convertSetupActionComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.TestScript.TestScriptTeardownComponent convertTestScriptTeardownComponent(org.hl7.fhir.dstu3.model.TestScript.TestScriptTeardownComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.TestScript.TestScriptTeardownComponent tgt = new org.hl7.fhir.dstu2016may.model.TestScript.TestScriptTeardownComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasAction()) {
            for (org.hl7.fhir.dstu3.model.TestScript.TeardownActionComponent t : src.getAction()) tgt.addAction(convertTeardownActionComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TestScript.TestScriptTeardownComponent convertTestScriptTeardownComponent(org.hl7.fhir.dstu2016may.model.TestScript.TestScriptTeardownComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.TestScript.TestScriptTeardownComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.TestScriptTeardownComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasAction()) {
            for (org.hl7.fhir.dstu2016may.model.TestScript.TeardownActionComponent t : src.getAction()) tgt.addAction(convertTeardownActionComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.TestScript.TestScriptTestComponent convertTestScriptTestComponent(org.hl7.fhir.dstu3.model.TestScript.TestScriptTestComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.TestScript.TestScriptTestComponent tgt = new org.hl7.fhir.dstu2016may.model.TestScript.TestScriptTestComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_30.convertType(src.getNameElement()));
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_30.convertType(src.getDescriptionElement()));
        if (src.hasAction()) {
            for (org.hl7.fhir.dstu3.model.TestScript.TestActionComponent t : src.getAction()) tgt.addAction(convertTestActionComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TestScript.TestScriptTestComponent convertTestScriptTestComponent(org.hl7.fhir.dstu2016may.model.TestScript.TestScriptTestComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.TestScript.TestScriptTestComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.TestScriptTestComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_14_30.convertType(src.getNameElement()));
        if (src.hasDescriptionElement())
            tgt.setDescriptionElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_14_30.convertType(src.getDescriptionElement()));
        if (src.hasAction()) {
            for (org.hl7.fhir.dstu2016may.model.TestScript.TestActionComponent t : src.getAction()) tgt.addAction(convertTestActionComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.TestScript.TestScriptVariableComponent convertTestScriptVariableComponent(org.hl7.fhir.dstu3.model.TestScript.TestScriptVariableComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.TestScript.TestScriptVariableComponent tgt = new org.hl7.fhir.dstu2016may.model.TestScript.TestScriptVariableComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_30.convertType(src.getNameElement()));
        if (src.hasDefaultValueElement())
            tgt.setDefaultValueElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_30.convertType(src.getDefaultValueElement()));
        if (src.hasHeaderFieldElement())
            tgt.setHeaderFieldElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_30.convertType(src.getHeaderFieldElement()));
        if (src.hasPathElement())
            tgt.setPathElement((org.hl7.fhir.dstu2016may.model.StringType) VersionConvertor_14_30.convertType(src.getPathElement()));
        if (src.hasSourceIdElement())
            tgt.setSourceIdElement((org.hl7.fhir.dstu2016may.model.IdType) VersionConvertor_14_30.convertType(src.getSourceIdElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TestScript.TestScriptVariableComponent convertTestScriptVariableComponent(org.hl7.fhir.dstu2016may.model.TestScript.TestScriptVariableComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.TestScript.TestScriptVariableComponent tgt = new org.hl7.fhir.dstu3.model.TestScript.TestScriptVariableComponent();
        VersionConvertor_14_30.copyElement(src, tgt);
        if (src.hasNameElement())
            tgt.setNameElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_14_30.convertType(src.getNameElement()));
        if (src.hasDefaultValueElement())
            tgt.setDefaultValueElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_14_30.convertType(src.getDefaultValueElement()));
        if (src.hasHeaderFieldElement())
            tgt.setHeaderFieldElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_14_30.convertType(src.getHeaderFieldElement()));
        if (src.hasPathElement())
            tgt.setPathElement((org.hl7.fhir.dstu3.model.StringType) VersionConvertor_14_30.convertType(src.getPathElement()));
        if (src.hasSourceIdElement())
            tgt.setSourceIdElement((org.hl7.fhir.dstu3.model.IdType) VersionConvertor_14_30.convertType(src.getSourceIdElement()));
        return tgt;
    }
}
