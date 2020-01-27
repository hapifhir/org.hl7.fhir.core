package org.hl7.fhir.convertors.conv14_40;

import org.hl7.fhir.convertors.VersionConvertor_14_40;
import org.hl7.fhir.exceptions.FHIRException;

public class OperationOutcome14_40 {

    static public org.hl7.fhir.r4.model.OperationOutcome.IssueSeverity convertIssueSeverity(org.hl7.fhir.dstu2016may.model.OperationOutcome.IssueSeverity src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case FATAL:
                return org.hl7.fhir.r4.model.OperationOutcome.IssueSeverity.FATAL;
            case ERROR:
                return org.hl7.fhir.r4.model.OperationOutcome.IssueSeverity.ERROR;
            case WARNING:
                return org.hl7.fhir.r4.model.OperationOutcome.IssueSeverity.WARNING;
            case INFORMATION:
                return org.hl7.fhir.r4.model.OperationOutcome.IssueSeverity.INFORMATION;
            default:
                return org.hl7.fhir.r4.model.OperationOutcome.IssueSeverity.NULL;
        }
    }

    static public org.hl7.fhir.dstu2016may.model.OperationOutcome.IssueSeverity convertIssueSeverity(org.hl7.fhir.r4.model.OperationOutcome.IssueSeverity src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case FATAL:
                return org.hl7.fhir.dstu2016may.model.OperationOutcome.IssueSeverity.FATAL;
            case ERROR:
                return org.hl7.fhir.dstu2016may.model.OperationOutcome.IssueSeverity.ERROR;
            case WARNING:
                return org.hl7.fhir.dstu2016may.model.OperationOutcome.IssueSeverity.WARNING;
            case INFORMATION:
                return org.hl7.fhir.dstu2016may.model.OperationOutcome.IssueSeverity.INFORMATION;
            default:
                return org.hl7.fhir.dstu2016may.model.OperationOutcome.IssueSeverity.NULL;
        }
    }

    static public org.hl7.fhir.r4.model.OperationOutcome.IssueType convertIssueType(org.hl7.fhir.dstu2016may.model.OperationOutcome.IssueType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case INVALID:
                return org.hl7.fhir.r4.model.OperationOutcome.IssueType.INVALID;
            case STRUCTURE:
                return org.hl7.fhir.r4.model.OperationOutcome.IssueType.STRUCTURE;
            case REQUIRED:
                return org.hl7.fhir.r4.model.OperationOutcome.IssueType.REQUIRED;
            case VALUE:
                return org.hl7.fhir.r4.model.OperationOutcome.IssueType.VALUE;
            case INVARIANT:
                return org.hl7.fhir.r4.model.OperationOutcome.IssueType.INVARIANT;
            case SECURITY:
                return org.hl7.fhir.r4.model.OperationOutcome.IssueType.SECURITY;
            case LOGIN:
                return org.hl7.fhir.r4.model.OperationOutcome.IssueType.LOGIN;
            case UNKNOWN:
                return org.hl7.fhir.r4.model.OperationOutcome.IssueType.UNKNOWN;
            case EXPIRED:
                return org.hl7.fhir.r4.model.OperationOutcome.IssueType.EXPIRED;
            case FORBIDDEN:
                return org.hl7.fhir.r4.model.OperationOutcome.IssueType.FORBIDDEN;
            case SUPPRESSED:
                return org.hl7.fhir.r4.model.OperationOutcome.IssueType.SUPPRESSED;
            case PROCESSING:
                return org.hl7.fhir.r4.model.OperationOutcome.IssueType.PROCESSING;
            case NOTSUPPORTED:
                return org.hl7.fhir.r4.model.OperationOutcome.IssueType.NOTSUPPORTED;
            case DUPLICATE:
                return org.hl7.fhir.r4.model.OperationOutcome.IssueType.DUPLICATE;
            case NOTFOUND:
                return org.hl7.fhir.r4.model.OperationOutcome.IssueType.NOTFOUND;
            case TOOLONG:
                return org.hl7.fhir.r4.model.OperationOutcome.IssueType.TOOLONG;
            case CODEINVALID:
                return org.hl7.fhir.r4.model.OperationOutcome.IssueType.CODEINVALID;
            case EXTENSION:
                return org.hl7.fhir.r4.model.OperationOutcome.IssueType.EXTENSION;
            case TOOCOSTLY:
                return org.hl7.fhir.r4.model.OperationOutcome.IssueType.TOOCOSTLY;
            case BUSINESSRULE:
                return org.hl7.fhir.r4.model.OperationOutcome.IssueType.BUSINESSRULE;
            case CONFLICT:
                return org.hl7.fhir.r4.model.OperationOutcome.IssueType.CONFLICT;
            case INCOMPLETE:
                return org.hl7.fhir.r4.model.OperationOutcome.IssueType.INCOMPLETE;
            case TRANSIENT:
                return org.hl7.fhir.r4.model.OperationOutcome.IssueType.TRANSIENT;
            case LOCKERROR:
                return org.hl7.fhir.r4.model.OperationOutcome.IssueType.LOCKERROR;
            case NOSTORE:
                return org.hl7.fhir.r4.model.OperationOutcome.IssueType.NOSTORE;
            case EXCEPTION:
                return org.hl7.fhir.r4.model.OperationOutcome.IssueType.EXCEPTION;
            case TIMEOUT:
                return org.hl7.fhir.r4.model.OperationOutcome.IssueType.TIMEOUT;
            case THROTTLED:
                return org.hl7.fhir.r4.model.OperationOutcome.IssueType.THROTTLED;
            case INFORMATIONAL:
                return org.hl7.fhir.r4.model.OperationOutcome.IssueType.INFORMATIONAL;
            default:
                return org.hl7.fhir.r4.model.OperationOutcome.IssueType.NULL;
        }
    }

    static public org.hl7.fhir.dstu2016may.model.OperationOutcome.IssueType convertIssueType(org.hl7.fhir.r4.model.OperationOutcome.IssueType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case INVALID:
                return org.hl7.fhir.dstu2016may.model.OperationOutcome.IssueType.INVALID;
            case STRUCTURE:
                return org.hl7.fhir.dstu2016may.model.OperationOutcome.IssueType.STRUCTURE;
            case REQUIRED:
                return org.hl7.fhir.dstu2016may.model.OperationOutcome.IssueType.REQUIRED;
            case VALUE:
                return org.hl7.fhir.dstu2016may.model.OperationOutcome.IssueType.VALUE;
            case INVARIANT:
                return org.hl7.fhir.dstu2016may.model.OperationOutcome.IssueType.INVARIANT;
            case SECURITY:
                return org.hl7.fhir.dstu2016may.model.OperationOutcome.IssueType.SECURITY;
            case LOGIN:
                return org.hl7.fhir.dstu2016may.model.OperationOutcome.IssueType.LOGIN;
            case UNKNOWN:
                return org.hl7.fhir.dstu2016may.model.OperationOutcome.IssueType.UNKNOWN;
            case EXPIRED:
                return org.hl7.fhir.dstu2016may.model.OperationOutcome.IssueType.EXPIRED;
            case FORBIDDEN:
                return org.hl7.fhir.dstu2016may.model.OperationOutcome.IssueType.FORBIDDEN;
            case SUPPRESSED:
                return org.hl7.fhir.dstu2016may.model.OperationOutcome.IssueType.SUPPRESSED;
            case PROCESSING:
                return org.hl7.fhir.dstu2016may.model.OperationOutcome.IssueType.PROCESSING;
            case NOTSUPPORTED:
                return org.hl7.fhir.dstu2016may.model.OperationOutcome.IssueType.NOTSUPPORTED;
            case DUPLICATE:
                return org.hl7.fhir.dstu2016may.model.OperationOutcome.IssueType.DUPLICATE;
            case NOTFOUND:
                return org.hl7.fhir.dstu2016may.model.OperationOutcome.IssueType.NOTFOUND;
            case TOOLONG:
                return org.hl7.fhir.dstu2016may.model.OperationOutcome.IssueType.TOOLONG;
            case CODEINVALID:
                return org.hl7.fhir.dstu2016may.model.OperationOutcome.IssueType.CODEINVALID;
            case EXTENSION:
                return org.hl7.fhir.dstu2016may.model.OperationOutcome.IssueType.EXTENSION;
            case TOOCOSTLY:
                return org.hl7.fhir.dstu2016may.model.OperationOutcome.IssueType.TOOCOSTLY;
            case BUSINESSRULE:
                return org.hl7.fhir.dstu2016may.model.OperationOutcome.IssueType.BUSINESSRULE;
            case CONFLICT:
                return org.hl7.fhir.dstu2016may.model.OperationOutcome.IssueType.CONFLICT;
            case INCOMPLETE:
                return org.hl7.fhir.dstu2016may.model.OperationOutcome.IssueType.INCOMPLETE;
            case TRANSIENT:
                return org.hl7.fhir.dstu2016may.model.OperationOutcome.IssueType.TRANSIENT;
            case LOCKERROR:
                return org.hl7.fhir.dstu2016may.model.OperationOutcome.IssueType.LOCKERROR;
            case NOSTORE:
                return org.hl7.fhir.dstu2016may.model.OperationOutcome.IssueType.NOSTORE;
            case EXCEPTION:
                return org.hl7.fhir.dstu2016may.model.OperationOutcome.IssueType.EXCEPTION;
            case TIMEOUT:
                return org.hl7.fhir.dstu2016may.model.OperationOutcome.IssueType.TIMEOUT;
            case THROTTLED:
                return org.hl7.fhir.dstu2016may.model.OperationOutcome.IssueType.THROTTLED;
            case INFORMATIONAL:
                return org.hl7.fhir.dstu2016may.model.OperationOutcome.IssueType.INFORMATIONAL;
            default:
                return org.hl7.fhir.dstu2016may.model.OperationOutcome.IssueType.NULL;
        }
    }

    public static org.hl7.fhir.dstu2016may.model.OperationOutcome convertOperationOutcome(org.hl7.fhir.r4.model.OperationOutcome src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.OperationOutcome tgt = new org.hl7.fhir.dstu2016may.model.OperationOutcome();
        VersionConvertor_14_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.r4.model.OperationOutcome.OperationOutcomeIssueComponent t : src.getIssue()) tgt.addIssue(convertOperationOutcomeIssueComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.OperationOutcome convertOperationOutcome(org.hl7.fhir.dstu2016may.model.OperationOutcome src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.OperationOutcome tgt = new org.hl7.fhir.r4.model.OperationOutcome();
        VersionConvertor_14_40.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu2016may.model.OperationOutcome.OperationOutcomeIssueComponent t : src.getIssue()) tgt.addIssue(convertOperationOutcomeIssueComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2016may.model.OperationOutcome.OperationOutcomeIssueComponent convertOperationOutcomeIssueComponent(org.hl7.fhir.r4.model.OperationOutcome.OperationOutcomeIssueComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2016may.model.OperationOutcome.OperationOutcomeIssueComponent tgt = new org.hl7.fhir.dstu2016may.model.OperationOutcome.OperationOutcomeIssueComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        tgt.setSeverity(convertIssueSeverity(src.getSeverity()));
        tgt.setCode(convertIssueType(src.getCode()));
        tgt.setDetails(VersionConvertor_14_40.convertCodeableConcept(src.getDetails()));
        if (src.hasDiagnostics())
            tgt.setDiagnostics(src.getDiagnostics());
        for (org.hl7.fhir.r4.model.StringType t : src.getLocation()) tgt.addLocation(t.getValue());
        for (org.hl7.fhir.r4.model.StringType t : src.getExpression()) tgt.addExpression(VersionConvertor_14_40.convertTo2016MayExpression(t.getValue()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.OperationOutcome.OperationOutcomeIssueComponent convertOperationOutcomeIssueComponent(org.hl7.fhir.dstu2016may.model.OperationOutcome.OperationOutcomeIssueComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.OperationOutcome.OperationOutcomeIssueComponent tgt = new org.hl7.fhir.r4.model.OperationOutcome.OperationOutcomeIssueComponent();
        VersionConvertor_14_40.copyElement(src, tgt);
        tgt.setSeverity(convertIssueSeverity(src.getSeverity()));
        tgt.setCode(convertIssueType(src.getCode()));
        tgt.setDetails(VersionConvertor_14_40.convertCodeableConcept(src.getDetails()));
        if (src.hasDiagnostics())
            tgt.setDiagnostics(src.getDiagnostics());
        for (org.hl7.fhir.dstu2016may.model.StringType t : src.getLocation()) tgt.addLocation(t.getValue());
        for (org.hl7.fhir.dstu2016may.model.StringType t : src.getExpression()) tgt.addExpression(VersionConvertor_14_40.convertToR4Expression(t.getValue()));
        return tgt;
    }
}
