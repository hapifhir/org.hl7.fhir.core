package org.hl7.fhir.convertors.conv10_40;

import org.hl7.fhir.convertors.VersionConvertor_10_40;
import org.hl7.fhir.exceptions.FHIRException;

public class TestScript10_40 {

    public static org.hl7.fhir.dstu2.model.TestScript.AssertionDirectionType convertAssertionDirectionType(org.hl7.fhir.r4.model.TestScript.AssertionDirectionType src) throws FHIRException {
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

    public static org.hl7.fhir.r4.model.TestScript.AssertionDirectionType convertAssertionDirectionType(org.hl7.fhir.dstu2.model.TestScript.AssertionDirectionType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case RESPONSE:
                return org.hl7.fhir.r4.model.TestScript.AssertionDirectionType.RESPONSE;
            case REQUEST:
                return org.hl7.fhir.r4.model.TestScript.AssertionDirectionType.REQUEST;
            default:
                return org.hl7.fhir.r4.model.TestScript.AssertionDirectionType.NULL;
        }
    }

    public static org.hl7.fhir.r4.model.TestScript.AssertionOperatorType convertAssertionOperatorType(org.hl7.fhir.dstu2.model.TestScript.AssertionOperatorType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case EQUALS:
                return org.hl7.fhir.r4.model.TestScript.AssertionOperatorType.EQUALS;
            case NOTEQUALS:
                return org.hl7.fhir.r4.model.TestScript.AssertionOperatorType.NOTEQUALS;
            case IN:
                return org.hl7.fhir.r4.model.TestScript.AssertionOperatorType.IN;
            case NOTIN:
                return org.hl7.fhir.r4.model.TestScript.AssertionOperatorType.NOTIN;
            case GREATERTHAN:
                return org.hl7.fhir.r4.model.TestScript.AssertionOperatorType.GREATERTHAN;
            case LESSTHAN:
                return org.hl7.fhir.r4.model.TestScript.AssertionOperatorType.LESSTHAN;
            case EMPTY:
                return org.hl7.fhir.r4.model.TestScript.AssertionOperatorType.EMPTY;
            case NOTEMPTY:
                return org.hl7.fhir.r4.model.TestScript.AssertionOperatorType.NOTEMPTY;
            case CONTAINS:
                return org.hl7.fhir.r4.model.TestScript.AssertionOperatorType.CONTAINS;
            case NOTCONTAINS:
                return org.hl7.fhir.r4.model.TestScript.AssertionOperatorType.NOTCONTAINS;
            default:
                return org.hl7.fhir.r4.model.TestScript.AssertionOperatorType.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.TestScript.AssertionOperatorType convertAssertionOperatorType(org.hl7.fhir.r4.model.TestScript.AssertionOperatorType src) throws FHIRException {
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

    public static org.hl7.fhir.dstu2.model.TestScript.AssertionResponseTypes convertAssertionResponseTypes(org.hl7.fhir.r4.model.TestScript.AssertionResponseTypes src) throws FHIRException {
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

    public static org.hl7.fhir.r4.model.TestScript.AssertionResponseTypes convertAssertionResponseTypes(org.hl7.fhir.dstu2.model.TestScript.AssertionResponseTypes src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case OKAY:
                return org.hl7.fhir.r4.model.TestScript.AssertionResponseTypes.OKAY;
            case CREATED:
                return org.hl7.fhir.r4.model.TestScript.AssertionResponseTypes.CREATED;
            case NOCONTENT:
                return org.hl7.fhir.r4.model.TestScript.AssertionResponseTypes.NOCONTENT;
            case NOTMODIFIED:
                return org.hl7.fhir.r4.model.TestScript.AssertionResponseTypes.NOTMODIFIED;
            case BAD:
                return org.hl7.fhir.r4.model.TestScript.AssertionResponseTypes.BAD;
            case FORBIDDEN:
                return org.hl7.fhir.r4.model.TestScript.AssertionResponseTypes.FORBIDDEN;
            case NOTFOUND:
                return org.hl7.fhir.r4.model.TestScript.AssertionResponseTypes.NOTFOUND;
            case METHODNOTALLOWED:
                return org.hl7.fhir.r4.model.TestScript.AssertionResponseTypes.METHODNOTALLOWED;
            case CONFLICT:
                return org.hl7.fhir.r4.model.TestScript.AssertionResponseTypes.CONFLICT;
            case GONE:
                return org.hl7.fhir.r4.model.TestScript.AssertionResponseTypes.GONE;
            case PRECONDITIONFAILED:
                return org.hl7.fhir.r4.model.TestScript.AssertionResponseTypes.PRECONDITIONFAILED;
            case UNPROCESSABLE:
                return org.hl7.fhir.r4.model.TestScript.AssertionResponseTypes.UNPROCESSABLE;
            default:
                return org.hl7.fhir.r4.model.TestScript.AssertionResponseTypes.NULL;
        }
    }

    static public String convertContentType(org.hl7.fhir.dstu2.model.TestScript.ContentType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
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

    public static org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupActionAssertComponent convertSetupActionAssertComponent(org.hl7.fhir.r4.model.TestScript.SetupActionAssertComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupActionAssertComponent tgt = new org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupActionAssertComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        tgt.setLabel(src.getLabel());
        tgt.setDescription(src.getDescription());
        tgt.setDirection(convertAssertionDirectionType(src.getDirection()));
        tgt.setCompareToSourceId(src.getCompareToSourceId());
        tgt.setCompareToSourcePath(src.getCompareToSourcePath());
        tgt.setContentType(convertContentType(src.getContentType()));
        tgt.setHeaderField(src.getHeaderField());
        tgt.setMinimumId(src.getMinimumId());
        tgt.setNavigationLinks(src.getNavigationLinks());
        tgt.setOperator(convertAssertionOperatorType(src.getOperator()));
        tgt.setPath(src.getPath());
        tgt.setResource(src.getResource());
        tgt.setResponse(convertAssertionResponseTypes(src.getResponse()));
        tgt.setResponseCode(src.getResponseCode());
        tgt.setSourceId(src.getSourceId());
        tgt.setValidateProfileId(src.getValidateProfileId());
        tgt.setValue(src.getValue());
        tgt.setWarningOnly(src.getWarningOnly());
        return tgt;
    }

    public static org.hl7.fhir.r4.model.TestScript.SetupActionAssertComponent convertSetupActionAssertComponent(org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupActionAssertComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.TestScript.SetupActionAssertComponent tgt = new org.hl7.fhir.r4.model.TestScript.SetupActionAssertComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        tgt.setLabel(src.getLabel());
        tgt.setDescription(src.getDescription());
        tgt.setDirection(convertAssertionDirectionType(src.getDirection()));
        tgt.setCompareToSourceId(src.getCompareToSourceId());
        tgt.setCompareToSourcePath(src.getCompareToSourcePath());
        tgt.setContentType(convertContentType(src.getContentType()));
        tgt.setHeaderField(src.getHeaderField());
        tgt.setMinimumId(src.getMinimumId());
        tgt.setNavigationLinks(src.getNavigationLinks());
        tgt.setOperator(convertAssertionOperatorType(src.getOperator()));
        tgt.setPath(src.getPath());
        tgt.setResource(src.getResource());
        tgt.setResponse(convertAssertionResponseTypes(src.getResponse()));
        tgt.setResponseCode(src.getResponseCode());
        tgt.setSourceId(src.getSourceId());
        tgt.setValidateProfileId(src.getValidateProfileId());
        tgt.setValue(src.getValue());
        tgt.setWarningOnly(src.getWarningOnly());
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupActionComponent convertSetupActionComponent(org.hl7.fhir.r4.model.TestScript.SetupActionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupActionComponent tgt = new org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupActionComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
        tgt.setAssert(convertSetupActionAssertComponent(src.getAssert()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.TestScript.SetupActionComponent convertSetupActionComponent(org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupActionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.TestScript.SetupActionComponent tgt = new org.hl7.fhir.r4.model.TestScript.SetupActionComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
        tgt.setAssert(convertSetupActionAssertComponent(src.getAssert()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupActionOperationComponent convertSetupActionOperationComponent(org.hl7.fhir.r4.model.TestScript.SetupActionOperationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupActionOperationComponent tgt = new org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupActionOperationComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        tgt.setType(VersionConvertor_10_40.convertCoding(src.getType()));
        tgt.setResource(src.getResource());
        tgt.setLabel(src.getLabel());
        tgt.setDescription(src.getDescription());
        tgt.setAccept(convertContentType(src.getAccept()));
        tgt.setContentType(convertContentType(src.getContentType()));
        tgt.setDestination(src.getDestination());
        tgt.setEncodeRequestUrl(src.getEncodeRequestUrl());
        tgt.setParams(src.getParams());
        for (org.hl7.fhir.r4.model.TestScript.SetupActionOperationRequestHeaderComponent t : src.getRequestHeader()) tgt.addRequestHeader(convertSetupActionOperationRequestHeaderComponent(t));
        tgt.setResponseId(src.getResponseId());
        tgt.setSourceId(src.getSourceId());
        tgt.setTargetId(src.getTargetId());
        tgt.setUrl(src.getUrl());
        return tgt;
    }

    public static org.hl7.fhir.r4.model.TestScript.SetupActionOperationComponent convertSetupActionOperationComponent(org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupActionOperationComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.TestScript.SetupActionOperationComponent tgt = new org.hl7.fhir.r4.model.TestScript.SetupActionOperationComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        tgt.setType(VersionConvertor_10_40.convertCoding(src.getType()));
        tgt.setResource(src.getResource());
        tgt.setLabel(src.getLabel());
        tgt.setDescription(src.getDescription());
        tgt.setAccept(convertContentType(src.getAccept()));
        tgt.setContentType(convertContentType(src.getContentType()));
        tgt.setDestination(src.getDestination());
        tgt.setEncodeRequestUrl(src.getEncodeRequestUrl());
        tgt.setParams(src.getParams());
        for (org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupActionOperationRequestHeaderComponent t : src.getRequestHeader()) tgt.addRequestHeader(convertSetupActionOperationRequestHeaderComponent(t));
        tgt.setResponseId(src.getResponseId());
        tgt.setSourceId(src.getSourceId());
        tgt.setTargetId(src.getTargetId());
        tgt.setUrl(src.getUrl());
        return tgt;
    }

    public static org.hl7.fhir.r4.model.TestScript.SetupActionOperationRequestHeaderComponent convertSetupActionOperationRequestHeaderComponent(org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupActionOperationRequestHeaderComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.TestScript.SetupActionOperationRequestHeaderComponent tgt = new org.hl7.fhir.r4.model.TestScript.SetupActionOperationRequestHeaderComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        tgt.setField(src.getField());
        tgt.setValue(src.getValue());
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupActionOperationRequestHeaderComponent convertSetupActionOperationRequestHeaderComponent(org.hl7.fhir.r4.model.TestScript.SetupActionOperationRequestHeaderComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupActionOperationRequestHeaderComponent tgt = new org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupActionOperationRequestHeaderComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        tgt.setField(src.getField());
        tgt.setValue(src.getValue());
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.TestScript.TestScriptTeardownActionComponent convertTeardownActionComponent(org.hl7.fhir.r4.model.TestScript.TeardownActionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.TestScript.TestScriptTeardownActionComponent tgt = new org.hl7.fhir.dstu2.model.TestScript.TestScriptTeardownActionComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.TestScript.TeardownActionComponent convertTeardownActionComponent(org.hl7.fhir.dstu2.model.TestScript.TestScriptTeardownActionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.TestScript.TeardownActionComponent tgt = new org.hl7.fhir.r4.model.TestScript.TeardownActionComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.TestScript.TestScriptTestActionComponent convertTestActionComponent(org.hl7.fhir.r4.model.TestScript.TestActionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.TestScript.TestScriptTestActionComponent tgt = new org.hl7.fhir.dstu2.model.TestScript.TestScriptTestActionComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
        tgt.setAssert(convertSetupActionAssertComponent(src.getAssert()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.TestScript.TestActionComponent convertTestActionComponent(org.hl7.fhir.dstu2.model.TestScript.TestScriptTestActionComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.TestScript.TestActionComponent tgt = new org.hl7.fhir.r4.model.TestScript.TestActionComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
        tgt.setAssert(convertSetupActionAssertComponent(src.getAssert()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.TestScript convertTestScript(org.hl7.fhir.r4.model.TestScript src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.TestScript tgt = new org.hl7.fhir.dstu2.model.TestScript();
        VersionConvertor_10_40.copyDomainResource(src, tgt);
        tgt.setUrl(src.getUrl());
        tgt.setVersion(src.getVersion());
        tgt.setName(src.getName());
        tgt.setStatus(VersionConvertor_10_40.convertConformanceResourceStatus(src.getStatus()));
        tgt.setIdentifier(VersionConvertor_10_40.convertIdentifier(src.getIdentifier()));
        if (src.hasExperimental())
            tgt.setExperimental(src.getExperimental());
        tgt.setPublisher(src.getPublisher());
        for (org.hl7.fhir.r4.model.ContactDetail t : src.getContact()) tgt.addContact(convertTestScriptContactComponent(t));
        if (src.hasDate())
            tgt.setDate(src.getDate());
        tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.r4.model.UsageContext t : src.getUseContext()) if (t.hasValueCodeableConcept())
            tgt.addUseContext(VersionConvertor_10_40.convertCodeableConcept(t.getValueCodeableConcept()));
        for (org.hl7.fhir.r4.model.CodeableConcept t : src.getJurisdiction()) tgt.addUseContext(VersionConvertor_10_40.convertCodeableConcept(t));
        tgt.setRequirements(src.getPurpose());
        tgt.setCopyright(src.getCopyright());
        tgt.setMetadata(convertTestScriptMetadataComponent(src.getMetadata()));
        for (org.hl7.fhir.r4.model.TestScript.TestScriptFixtureComponent t : src.getFixture()) tgt.addFixture(convertTestScriptFixtureComponent(t));
        for (org.hl7.fhir.r4.model.Reference t : src.getProfile()) tgt.addProfile(VersionConvertor_10_40.convertReference(t));
        for (org.hl7.fhir.r4.model.TestScript.TestScriptVariableComponent t : src.getVariable()) tgt.addVariable(convertTestScriptVariableComponent(t));
        tgt.setSetup(convertTestScriptSetupComponent(src.getSetup()));
        for (org.hl7.fhir.r4.model.TestScript.TestScriptTestComponent t : src.getTest()) tgt.addTest(convertTestScriptTestComponent(t));
        tgt.setTeardown(convertTestScriptTeardownComponent(src.getTeardown()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.TestScript convertTestScript(org.hl7.fhir.dstu2.model.TestScript src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.TestScript tgt = new org.hl7.fhir.r4.model.TestScript();
        VersionConvertor_10_40.copyDomainResource(src, tgt);
        tgt.setUrl(src.getUrl());
        tgt.setVersion(src.getVersion());
        tgt.setName(src.getName());
        tgt.setStatus(VersionConvertor_10_40.convertConformanceResourceStatus(src.getStatus()));
        tgt.setIdentifier(VersionConvertor_10_40.convertIdentifier(src.getIdentifier()));
        if (src.hasExperimental())
            tgt.setExperimental(src.getExperimental());
        tgt.setPublisher(src.getPublisher());
        for (org.hl7.fhir.dstu2.model.TestScript.TestScriptContactComponent t : src.getContact()) tgt.addContact(convertTestScriptContactComponent(t));
        if (src.hasDate())
            tgt.setDate(src.getDate());
        tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.dstu2.model.CodeableConcept t : src.getUseContext()) if (VersionConvertor_10_40.isJurisdiction(t))
            tgt.addJurisdiction(VersionConvertor_10_40.convertCodeableConcept(t));
        else
            tgt.addUseContext(VersionConvertor_10_40.convertCodeableConceptToUsageContext(t));
        tgt.setPurpose(src.getRequirements());
        tgt.setCopyright(src.getCopyright());
        tgt.setMetadata(convertTestScriptMetadataComponent(src.getMetadata()));
        for (org.hl7.fhir.dstu2.model.TestScript.TestScriptFixtureComponent t : src.getFixture()) tgt.addFixture(convertTestScriptFixtureComponent(t));
        for (org.hl7.fhir.dstu2.model.Reference t : src.getProfile()) tgt.addProfile(VersionConvertor_10_40.convertReference(t));
        for (org.hl7.fhir.dstu2.model.TestScript.TestScriptVariableComponent t : src.getVariable()) tgt.addVariable(convertTestScriptVariableComponent(t));
        tgt.setSetup(convertTestScriptSetupComponent(src.getSetup()));
        for (org.hl7.fhir.dstu2.model.TestScript.TestScriptTestComponent t : src.getTest()) tgt.addTest(convertTestScriptTestComponent(t));
        tgt.setTeardown(convertTestScriptTeardownComponent(src.getTeardown()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.TestScript.TestScriptContactComponent convertTestScriptContactComponent(org.hl7.fhir.r4.model.ContactDetail src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.TestScript.TestScriptContactComponent tgt = new org.hl7.fhir.dstu2.model.TestScript.TestScriptContactComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        tgt.setName(src.getName());
        for (org.hl7.fhir.r4.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_10_40.convertContactPoint(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.ContactDetail convertTestScriptContactComponent(org.hl7.fhir.dstu2.model.TestScript.TestScriptContactComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.ContactDetail tgt = new org.hl7.fhir.r4.model.ContactDetail();
        VersionConvertor_10_40.copyElement(src, tgt);
        tgt.setName(src.getName());
        for (org.hl7.fhir.dstu2.model.ContactPoint t : src.getTelecom()) tgt.addTelecom(VersionConvertor_10_40.convertContactPoint(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.TestScript.TestScriptFixtureComponent convertTestScriptFixtureComponent(org.hl7.fhir.dstu2.model.TestScript.TestScriptFixtureComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.TestScript.TestScriptFixtureComponent tgt = new org.hl7.fhir.r4.model.TestScript.TestScriptFixtureComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        tgt.setAutocreate(src.getAutocreate());
        tgt.setAutodelete(src.getAutodelete());
        tgt.setResource(VersionConvertor_10_40.convertReference(src.getResource()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.TestScript.TestScriptFixtureComponent convertTestScriptFixtureComponent(org.hl7.fhir.r4.model.TestScript.TestScriptFixtureComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.TestScript.TestScriptFixtureComponent tgt = new org.hl7.fhir.dstu2.model.TestScript.TestScriptFixtureComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        tgt.setAutocreate(src.getAutocreate());
        tgt.setAutodelete(src.getAutodelete());
        tgt.setResource(VersionConvertor_10_40.convertReference(src.getResource()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.TestScript.TestScriptMetadataCapabilityComponent convertTestScriptMetadataCapabilityComponent(org.hl7.fhir.r4.model.TestScript.TestScriptMetadataCapabilityComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.TestScript.TestScriptMetadataCapabilityComponent tgt = new org.hl7.fhir.dstu2.model.TestScript.TestScriptMetadataCapabilityComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        tgt.setRequired(src.getRequired());
        tgt.setValidated(src.getValidated());
        tgt.setDescription(src.getDescription());
        tgt.setDestination(src.getDestination());
        for (org.hl7.fhir.r4.model.UriType t : src.getLink()) tgt.addLink(t.getValue());
        tgt.setConformance(VersionConvertor_10_40.convertCanonicalToReference(src.getCapabilitiesElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.TestScript.TestScriptMetadataCapabilityComponent convertTestScriptMetadataCapabilityComponent(org.hl7.fhir.dstu2.model.TestScript.TestScriptMetadataCapabilityComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.TestScript.TestScriptMetadataCapabilityComponent tgt = new org.hl7.fhir.r4.model.TestScript.TestScriptMetadataCapabilityComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        tgt.setRequired(src.getRequired());
        tgt.setValidated(src.getValidated());
        tgt.setDescription(src.getDescription());
        tgt.setDestination(src.getDestination());
        for (org.hl7.fhir.dstu2.model.UriType t : src.getLink()) tgt.addLink(t.getValue());
        tgt.setCapabilitiesElement(VersionConvertor_10_40.convertReferenceToCanonical(src.getConformance()));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.TestScript.TestScriptMetadataComponent convertTestScriptMetadataComponent(org.hl7.fhir.r4.model.TestScript.TestScriptMetadataComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.TestScript.TestScriptMetadataComponent tgt = new org.hl7.fhir.dstu2.model.TestScript.TestScriptMetadataComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        for (org.hl7.fhir.r4.model.TestScript.TestScriptMetadataLinkComponent t : src.getLink()) tgt.addLink(convertTestScriptMetadataLinkComponent(t));
        for (org.hl7.fhir.r4.model.TestScript.TestScriptMetadataCapabilityComponent t : src.getCapability()) tgt.addCapability(convertTestScriptMetadataCapabilityComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.TestScript.TestScriptMetadataComponent convertTestScriptMetadataComponent(org.hl7.fhir.dstu2.model.TestScript.TestScriptMetadataComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.TestScript.TestScriptMetadataComponent tgt = new org.hl7.fhir.r4.model.TestScript.TestScriptMetadataComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        for (org.hl7.fhir.dstu2.model.TestScript.TestScriptMetadataLinkComponent t : src.getLink()) tgt.addLink(convertTestScriptMetadataLinkComponent(t));
        for (org.hl7.fhir.dstu2.model.TestScript.TestScriptMetadataCapabilityComponent t : src.getCapability()) tgt.addCapability(convertTestScriptMetadataCapabilityComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.TestScript.TestScriptMetadataLinkComponent convertTestScriptMetadataLinkComponent(org.hl7.fhir.dstu2.model.TestScript.TestScriptMetadataLinkComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.TestScript.TestScriptMetadataLinkComponent tgt = new org.hl7.fhir.r4.model.TestScript.TestScriptMetadataLinkComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        tgt.setUrl(src.getUrl());
        tgt.setDescription(src.getDescription());
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.TestScript.TestScriptMetadataLinkComponent convertTestScriptMetadataLinkComponent(org.hl7.fhir.r4.model.TestScript.TestScriptMetadataLinkComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.TestScript.TestScriptMetadataLinkComponent tgt = new org.hl7.fhir.dstu2.model.TestScript.TestScriptMetadataLinkComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        tgt.setUrl(src.getUrl());
        tgt.setDescription(src.getDescription());
        return tgt;
    }

    public static org.hl7.fhir.r4.model.TestScript.TestScriptSetupComponent convertTestScriptSetupComponent(org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.TestScript.TestScriptSetupComponent tgt = new org.hl7.fhir.r4.model.TestScript.TestScriptSetupComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        for (org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupActionComponent t : src.getAction()) tgt.addAction(convertSetupActionComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupComponent convertTestScriptSetupComponent(org.hl7.fhir.r4.model.TestScript.TestScriptSetupComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupComponent tgt = new org.hl7.fhir.dstu2.model.TestScript.TestScriptSetupComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        for (org.hl7.fhir.r4.model.TestScript.SetupActionComponent t : src.getAction()) tgt.addAction(convertSetupActionComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.TestScript.TestScriptTeardownComponent convertTestScriptTeardownComponent(org.hl7.fhir.r4.model.TestScript.TestScriptTeardownComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.TestScript.TestScriptTeardownComponent tgt = new org.hl7.fhir.dstu2.model.TestScript.TestScriptTeardownComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        for (org.hl7.fhir.r4.model.TestScript.TeardownActionComponent t : src.getAction()) tgt.addAction(convertTeardownActionComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.TestScript.TestScriptTeardownComponent convertTestScriptTeardownComponent(org.hl7.fhir.dstu2.model.TestScript.TestScriptTeardownComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.TestScript.TestScriptTeardownComponent tgt = new org.hl7.fhir.r4.model.TestScript.TestScriptTeardownComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        for (org.hl7.fhir.dstu2.model.TestScript.TestScriptTeardownActionComponent t : src.getAction()) tgt.addAction(convertTeardownActionComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.TestScript.TestScriptTestComponent convertTestScriptTestComponent(org.hl7.fhir.dstu2.model.TestScript.TestScriptTestComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.TestScript.TestScriptTestComponent tgt = new org.hl7.fhir.r4.model.TestScript.TestScriptTestComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        tgt.setName(src.getName());
        tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.dstu2.model.TestScript.TestScriptTestActionComponent t : src.getAction()) tgt.addAction(convertTestActionComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.TestScript.TestScriptTestComponent convertTestScriptTestComponent(org.hl7.fhir.r4.model.TestScript.TestScriptTestComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.TestScript.TestScriptTestComponent tgt = new org.hl7.fhir.dstu2.model.TestScript.TestScriptTestComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        tgt.setName(src.getName());
        tgt.setDescription(src.getDescription());
        for (org.hl7.fhir.r4.model.TestScript.TestActionComponent t : src.getAction()) tgt.addAction(convertTestActionComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.TestScript.TestScriptVariableComponent convertTestScriptVariableComponent(org.hl7.fhir.r4.model.TestScript.TestScriptVariableComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.TestScript.TestScriptVariableComponent tgt = new org.hl7.fhir.dstu2.model.TestScript.TestScriptVariableComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        tgt.setName(src.getName());
        tgt.setHeaderField(src.getHeaderField());
        tgt.setPath(src.getPath());
        tgt.setSourceId(src.getSourceId());
        return tgt;
    }

    public static org.hl7.fhir.r4.model.TestScript.TestScriptVariableComponent convertTestScriptVariableComponent(org.hl7.fhir.dstu2.model.TestScript.TestScriptVariableComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.TestScript.TestScriptVariableComponent tgt = new org.hl7.fhir.r4.model.TestScript.TestScriptVariableComponent();
        VersionConvertor_10_40.copyElement(src, tgt);
        tgt.setName(src.getName());
        tgt.setHeaderField(src.getHeaderField());
        tgt.setPath(src.getPath());
        tgt.setSourceId(src.getSourceId());
        return tgt;
    }
}
