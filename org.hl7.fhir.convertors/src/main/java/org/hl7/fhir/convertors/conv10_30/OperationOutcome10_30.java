package org.hl7.fhir.convertors.conv10_30;

import org.hl7.fhir.convertors.VersionConvertor_10_30;
import org.hl7.fhir.exceptions.FHIRException;

public class OperationOutcome10_30 {

    public static org.hl7.fhir.dstu3.model.OperationOutcome.IssueSeverity convertIssueSeverity(org.hl7.fhir.dstu2.model.OperationOutcome.IssueSeverity src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case FATAL:
                return org.hl7.fhir.dstu3.model.OperationOutcome.IssueSeverity.FATAL;
            case ERROR:
                return org.hl7.fhir.dstu3.model.OperationOutcome.IssueSeverity.ERROR;
            case WARNING:
                return org.hl7.fhir.dstu3.model.OperationOutcome.IssueSeverity.WARNING;
            case INFORMATION:
                return org.hl7.fhir.dstu3.model.OperationOutcome.IssueSeverity.INFORMATION;
            default:
                return org.hl7.fhir.dstu3.model.OperationOutcome.IssueSeverity.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.OperationOutcome.IssueSeverity convertIssueSeverity(org.hl7.fhir.dstu3.model.OperationOutcome.IssueSeverity src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case FATAL:
                return org.hl7.fhir.dstu2.model.OperationOutcome.IssueSeverity.FATAL;
            case ERROR:
                return org.hl7.fhir.dstu2.model.OperationOutcome.IssueSeverity.ERROR;
            case WARNING:
                return org.hl7.fhir.dstu2.model.OperationOutcome.IssueSeverity.WARNING;
            case INFORMATION:
                return org.hl7.fhir.dstu2.model.OperationOutcome.IssueSeverity.INFORMATION;
            default:
                return org.hl7.fhir.dstu2.model.OperationOutcome.IssueSeverity.NULL;
        }
    }

    public static org.hl7.fhir.dstu2.model.OperationOutcome.IssueType convertIssueType(org.hl7.fhir.dstu3.model.OperationOutcome.IssueType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case INVALID:
                return org.hl7.fhir.dstu2.model.OperationOutcome.IssueType.INVALID;
            case STRUCTURE:
                return org.hl7.fhir.dstu2.model.OperationOutcome.IssueType.STRUCTURE;
            case REQUIRED:
                return org.hl7.fhir.dstu2.model.OperationOutcome.IssueType.REQUIRED;
            case VALUE:
                return org.hl7.fhir.dstu2.model.OperationOutcome.IssueType.VALUE;
            case INVARIANT:
                return org.hl7.fhir.dstu2.model.OperationOutcome.IssueType.INVARIANT;
            case SECURITY:
                return org.hl7.fhir.dstu2.model.OperationOutcome.IssueType.SECURITY;
            case LOGIN:
                return org.hl7.fhir.dstu2.model.OperationOutcome.IssueType.LOGIN;
            case UNKNOWN:
                return org.hl7.fhir.dstu2.model.OperationOutcome.IssueType.UNKNOWN;
            case EXPIRED:
                return org.hl7.fhir.dstu2.model.OperationOutcome.IssueType.EXPIRED;
            case FORBIDDEN:
                return org.hl7.fhir.dstu2.model.OperationOutcome.IssueType.FORBIDDEN;
            case SUPPRESSED:
                return org.hl7.fhir.dstu2.model.OperationOutcome.IssueType.SUPPRESSED;
            case PROCESSING:
                return org.hl7.fhir.dstu2.model.OperationOutcome.IssueType.PROCESSING;
            case NOTSUPPORTED:
                return org.hl7.fhir.dstu2.model.OperationOutcome.IssueType.NOTSUPPORTED;
            case DUPLICATE:
                return org.hl7.fhir.dstu2.model.OperationOutcome.IssueType.DUPLICATE;
            case NOTFOUND:
                return org.hl7.fhir.dstu2.model.OperationOutcome.IssueType.NOTFOUND;
            case TOOLONG:
                return org.hl7.fhir.dstu2.model.OperationOutcome.IssueType.TOOLONG;
            case CODEINVALID:
                return org.hl7.fhir.dstu2.model.OperationOutcome.IssueType.CODEINVALID;
            case EXTENSION:
                return org.hl7.fhir.dstu2.model.OperationOutcome.IssueType.EXTENSION;
            case TOOCOSTLY:
                return org.hl7.fhir.dstu2.model.OperationOutcome.IssueType.TOOCOSTLY;
            case BUSINESSRULE:
                return org.hl7.fhir.dstu2.model.OperationOutcome.IssueType.BUSINESSRULE;
            case CONFLICT:
                return org.hl7.fhir.dstu2.model.OperationOutcome.IssueType.CONFLICT;
            case INCOMPLETE:
                return org.hl7.fhir.dstu2.model.OperationOutcome.IssueType.INCOMPLETE;
            case TRANSIENT:
                return org.hl7.fhir.dstu2.model.OperationOutcome.IssueType.TRANSIENT;
            case LOCKERROR:
                return org.hl7.fhir.dstu2.model.OperationOutcome.IssueType.LOCKERROR;
            case NOSTORE:
                return org.hl7.fhir.dstu2.model.OperationOutcome.IssueType.NOSTORE;
            case EXCEPTION:
                return org.hl7.fhir.dstu2.model.OperationOutcome.IssueType.EXCEPTION;
            case TIMEOUT:
                return org.hl7.fhir.dstu2.model.OperationOutcome.IssueType.TIMEOUT;
            case THROTTLED:
                return org.hl7.fhir.dstu2.model.OperationOutcome.IssueType.THROTTLED;
            case INFORMATIONAL:
                return org.hl7.fhir.dstu2.model.OperationOutcome.IssueType.INFORMATIONAL;
            default:
                return org.hl7.fhir.dstu2.model.OperationOutcome.IssueType.NULL;
        }
    }

    public static org.hl7.fhir.dstu3.model.OperationOutcome.IssueType convertIssueType(org.hl7.fhir.dstu2.model.OperationOutcome.IssueType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case INVALID:
                return org.hl7.fhir.dstu3.model.OperationOutcome.IssueType.INVALID;
            case STRUCTURE:
                return org.hl7.fhir.dstu3.model.OperationOutcome.IssueType.STRUCTURE;
            case REQUIRED:
                return org.hl7.fhir.dstu3.model.OperationOutcome.IssueType.REQUIRED;
            case VALUE:
                return org.hl7.fhir.dstu3.model.OperationOutcome.IssueType.VALUE;
            case INVARIANT:
                return org.hl7.fhir.dstu3.model.OperationOutcome.IssueType.INVARIANT;
            case SECURITY:
                return org.hl7.fhir.dstu3.model.OperationOutcome.IssueType.SECURITY;
            case LOGIN:
                return org.hl7.fhir.dstu3.model.OperationOutcome.IssueType.LOGIN;
            case UNKNOWN:
                return org.hl7.fhir.dstu3.model.OperationOutcome.IssueType.UNKNOWN;
            case EXPIRED:
                return org.hl7.fhir.dstu3.model.OperationOutcome.IssueType.EXPIRED;
            case FORBIDDEN:
                return org.hl7.fhir.dstu3.model.OperationOutcome.IssueType.FORBIDDEN;
            case SUPPRESSED:
                return org.hl7.fhir.dstu3.model.OperationOutcome.IssueType.SUPPRESSED;
            case PROCESSING:
                return org.hl7.fhir.dstu3.model.OperationOutcome.IssueType.PROCESSING;
            case NOTSUPPORTED:
                return org.hl7.fhir.dstu3.model.OperationOutcome.IssueType.NOTSUPPORTED;
            case DUPLICATE:
                return org.hl7.fhir.dstu3.model.OperationOutcome.IssueType.DUPLICATE;
            case NOTFOUND:
                return org.hl7.fhir.dstu3.model.OperationOutcome.IssueType.NOTFOUND;
            case TOOLONG:
                return org.hl7.fhir.dstu3.model.OperationOutcome.IssueType.TOOLONG;
            case CODEINVALID:
                return org.hl7.fhir.dstu3.model.OperationOutcome.IssueType.CODEINVALID;
            case EXTENSION:
                return org.hl7.fhir.dstu3.model.OperationOutcome.IssueType.EXTENSION;
            case TOOCOSTLY:
                return org.hl7.fhir.dstu3.model.OperationOutcome.IssueType.TOOCOSTLY;
            case BUSINESSRULE:
                return org.hl7.fhir.dstu3.model.OperationOutcome.IssueType.BUSINESSRULE;
            case CONFLICT:
                return org.hl7.fhir.dstu3.model.OperationOutcome.IssueType.CONFLICT;
            case INCOMPLETE:
                return org.hl7.fhir.dstu3.model.OperationOutcome.IssueType.INCOMPLETE;
            case TRANSIENT:
                return org.hl7.fhir.dstu3.model.OperationOutcome.IssueType.TRANSIENT;
            case LOCKERROR:
                return org.hl7.fhir.dstu3.model.OperationOutcome.IssueType.LOCKERROR;
            case NOSTORE:
                return org.hl7.fhir.dstu3.model.OperationOutcome.IssueType.NOSTORE;
            case EXCEPTION:
                return org.hl7.fhir.dstu3.model.OperationOutcome.IssueType.EXCEPTION;
            case TIMEOUT:
                return org.hl7.fhir.dstu3.model.OperationOutcome.IssueType.TIMEOUT;
            case THROTTLED:
                return org.hl7.fhir.dstu3.model.OperationOutcome.IssueType.THROTTLED;
            case INFORMATIONAL:
                return org.hl7.fhir.dstu3.model.OperationOutcome.IssueType.INFORMATIONAL;
            default:
                return org.hl7.fhir.dstu3.model.OperationOutcome.IssueType.NULL;
        }
    }

    public static org.hl7.fhir.dstu3.model.OperationOutcome convertOperationOutcome(org.hl7.fhir.dstu2.model.OperationOutcome src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.OperationOutcome tgt = new org.hl7.fhir.dstu3.model.OperationOutcome();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu2.model.OperationOutcome.OperationOutcomeIssueComponent t : src.getIssue()) tgt.addIssue(convertOperationOutcomeIssueComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.OperationOutcome convertOperationOutcome(org.hl7.fhir.dstu3.model.OperationOutcome src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.OperationOutcome tgt = new org.hl7.fhir.dstu2.model.OperationOutcome();
        VersionConvertor_10_30.copyDomainResource(src, tgt);
        for (org.hl7.fhir.dstu3.model.OperationOutcome.OperationOutcomeIssueComponent t : src.getIssue()) tgt.addIssue(convertOperationOutcomeIssueComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.OperationOutcome.OperationOutcomeIssueComponent convertOperationOutcomeIssueComponent(org.hl7.fhir.dstu2.model.OperationOutcome.OperationOutcomeIssueComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.OperationOutcome.OperationOutcomeIssueComponent tgt = new org.hl7.fhir.dstu3.model.OperationOutcome.OperationOutcomeIssueComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasSeverity())
            tgt.setSeverity(convertIssueSeverity(src.getSeverity()));
        if (src.hasCode())
            tgt.setCode(convertIssueType(src.getCode()));
        if (src.hasDetails())
            tgt.setDetails(VersionConvertor_10_30.convertCodeableConcept(src.getDetails()));
        if (src.hasDiagnosticsElement())
            tgt.setDiagnosticsElement(VersionConvertor_10_30.convertString(src.getDiagnosticsElement()));
        for (org.hl7.fhir.dstu2.model.StringType t : src.getLocation()) tgt.addLocation(t.getValue());
        return tgt;
    }

    public static org.hl7.fhir.dstu2.model.OperationOutcome.OperationOutcomeIssueComponent convertOperationOutcomeIssueComponent(org.hl7.fhir.dstu3.model.OperationOutcome.OperationOutcomeIssueComponent src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu2.model.OperationOutcome.OperationOutcomeIssueComponent tgt = new org.hl7.fhir.dstu2.model.OperationOutcome.OperationOutcomeIssueComponent();
        VersionConvertor_10_30.copyElement(src, tgt);
        if (src.hasSeverity())
            tgt.setSeverity(convertIssueSeverity(src.getSeverity()));
        if (src.hasCode())
            tgt.setCode(convertIssueType(src.getCode()));
        if (src.hasDetails())
            tgt.setDetails(VersionConvertor_10_30.convertCodeableConcept(src.getDetails()));
        if (src.hasDiagnosticsElement())
            tgt.setDiagnosticsElement(VersionConvertor_10_30.convertString(src.getDiagnosticsElement()));
        for (org.hl7.fhir.dstu3.model.StringType t : src.getLocation()) tgt.addLocation(t.getValue());
        return tgt;
    }
}
