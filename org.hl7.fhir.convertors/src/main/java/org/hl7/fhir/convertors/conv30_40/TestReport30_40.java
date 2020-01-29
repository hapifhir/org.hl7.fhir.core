package org.hl7.fhir.convertors.conv30_40;

import org.hl7.fhir.convertors.VersionConvertor_30_40;
import org.hl7.fhir.exceptions.FHIRException;

public class TestReport30_40 {

    public static org.hl7.fhir.r4.model.TestReport convertTestReport(org.hl7.fhir.dstu3.model.TestReport src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.TestReport tgt = new org.hl7.fhir.r4.model.TestReport();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        if (src.hasIdentifier())
            tgt.setIdentifier(VersionConvertor_30_40.convertIdentifier(src.getIdentifier()));
        if (src.hasName())
            tgt.setName(src.getName());
        if (src.hasStatus())
            tgt.setStatus(convertTestReportStatus(src.getStatus()));
        if (src.hasTestScript())
            tgt.setTestScript(VersionConvertor_30_40.convertReference(src.getTestScript()));
        if (src.hasResult())
            tgt.setResult(convertTestReportResult(src.getResult()));
        if (src.hasScore())
            tgt.setScore(src.getScore());
        if (src.hasTester())
            tgt.setTester(src.getTester());
        if (src.hasIssued())
            tgt.setIssuedElement(VersionConvertor_30_40.convertDateTime(src.getIssuedElement()));
        if (src.hasParticipant()) {
            for (org.hl7.fhir.dstu3.model.TestReport.TestReportParticipantComponent t : src.getParticipant()) tgt.addParticipant(convertTestReportParticipantComponent(t));
        }
        if (src.hasSetup())
            tgt.setSetup(convertTestReportSetupComponent(src.getSetup()));
        if (src.hasTest()) {
            for (org.hl7.fhir.dstu3.model.TestReport.TestReportTestComponent t : src.getTest()) tgt.addTest(convertTestReportTestComponent(t));
        }
        if (src.hasTeardown())
            tgt.setTeardown(convertTestReportTeardownComponent(src.getTeardown()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TestReport convertTestReport(org.hl7.fhir.r4.model.TestReport src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.TestReport tgt = new org.hl7.fhir.dstu3.model.TestReport();
        VersionConvertor_30_40.copyDomainResource(src, tgt);
        if (src.hasIdentifier())
            tgt.setIdentifier(VersionConvertor_30_40.convertIdentifier(src.getIdentifier()));
        if (src.hasName())
            tgt.setName(src.getName());
        if (src.hasStatus())
            tgt.setStatus(convertTestReportStatus(src.getStatus()));
        if (src.hasTestScript())
            tgt.setTestScript(VersionConvertor_30_40.convertReference(src.getTestScript()));
        if (src.hasResult())
            tgt.setResult(convertTestReportResult(src.getResult()));
        if (src.hasScore())
            tgt.setScore(src.getScore());
        if (src.hasTester())
            tgt.setTester(src.getTester());
        if (src.hasIssued())
            tgt.setIssuedElement(VersionConvertor_30_40.convertDateTime(src.getIssuedElement()));
        if (src.hasParticipant()) {
            for (org.hl7.fhir.r4.model.TestReport.TestReportParticipantComponent t : src.getParticipant()) tgt.addParticipant(convertTestReportParticipantComponent(t));
        }
        if (src.hasSetup())
            tgt.setSetup(convertTestReportSetupComponent(src.getSetup()));
        if (src.hasTest()) {
            for (org.hl7.fhir.r4.model.TestReport.TestReportTestComponent t : src.getTest()) tgt.addTest(convertTestReportTestComponent(t));
        }
        if (src.hasTeardown())
            tgt.setTeardown(convertTestReportTeardownComponent(src.getTeardown()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.TestReport.TestReportParticipantComponent convertTestReportParticipantComponent(org.hl7.fhir.dstu3.model.TestReport.TestReportParticipantComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.TestReport.TestReportParticipantComponent tgt = new org.hl7.fhir.r4.model.TestReport.TestReportParticipantComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasType())
            tgt.setType(convertTestReportParticipantType(src.getType()));
        if (src.hasUri())
            tgt.setUri(src.getUri());
        if (src.hasDisplay())
            tgt.setDisplay(src.getDisplay());
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TestReport.TestReportParticipantComponent convertTestReportParticipantComponent(org.hl7.fhir.r4.model.TestReport.TestReportParticipantComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.TestReport.TestReportParticipantComponent tgt = new org.hl7.fhir.dstu3.model.TestReport.TestReportParticipantComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasType())
            tgt.setType(convertTestReportParticipantType(src.getType()));
        if (src.hasUri())
            tgt.setUri(src.getUri());
        if (src.hasDisplay())
            tgt.setDisplay(src.getDisplay());
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.TestReport.TestReportParticipantType convertTestReportParticipantType(org.hl7.fhir.r4.model.TestReport.TestReportParticipantType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case TESTENGINE:
                return org.hl7.fhir.dstu3.model.TestReport.TestReportParticipantType.TESTENGINE;
            case CLIENT:
                return org.hl7.fhir.dstu3.model.TestReport.TestReportParticipantType.CLIENT;
            case SERVER:
                return org.hl7.fhir.dstu3.model.TestReport.TestReportParticipantType.SERVER;
            default:
                return org.hl7.fhir.dstu3.model.TestReport.TestReportParticipantType.NULL;
        }
    }

    static public org.hl7.fhir.r4.model.TestReport.TestReportParticipantType convertTestReportParticipantType(org.hl7.fhir.dstu3.model.TestReport.TestReportParticipantType src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case TESTENGINE:
                return org.hl7.fhir.r4.model.TestReport.TestReportParticipantType.TESTENGINE;
            case CLIENT:
                return org.hl7.fhir.r4.model.TestReport.TestReportParticipantType.CLIENT;
            case SERVER:
                return org.hl7.fhir.r4.model.TestReport.TestReportParticipantType.SERVER;
            default:
                return org.hl7.fhir.r4.model.TestReport.TestReportParticipantType.NULL;
        }
    }

    static public org.hl7.fhir.r4.model.TestReport.TestReportResult convertTestReportResult(org.hl7.fhir.dstu3.model.TestReport.TestReportResult src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case PASS:
                return org.hl7.fhir.r4.model.TestReport.TestReportResult.PASS;
            case FAIL:
                return org.hl7.fhir.r4.model.TestReport.TestReportResult.FAIL;
            case PENDING:
                return org.hl7.fhir.r4.model.TestReport.TestReportResult.PENDING;
            default:
                return org.hl7.fhir.r4.model.TestReport.TestReportResult.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.TestReport.TestReportResult convertTestReportResult(org.hl7.fhir.r4.model.TestReport.TestReportResult src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case PASS:
                return org.hl7.fhir.dstu3.model.TestReport.TestReportResult.PASS;
            case FAIL:
                return org.hl7.fhir.dstu3.model.TestReport.TestReportResult.FAIL;
            case PENDING:
                return org.hl7.fhir.dstu3.model.TestReport.TestReportResult.PENDING;
            default:
                return org.hl7.fhir.dstu3.model.TestReport.TestReportResult.NULL;
        }
    }

    public static org.hl7.fhir.r4.model.TestReport.TestReportSetupComponent convertTestReportSetupComponent(org.hl7.fhir.dstu3.model.TestReport.TestReportSetupComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.TestReport.TestReportSetupComponent tgt = new org.hl7.fhir.r4.model.TestReport.TestReportSetupComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasAction()) {
            for (org.hl7.fhir.dstu3.model.TestReport.SetupActionComponent t : src.getAction()) tgt.addAction(VersionConvertor_30_40.convertSetupActionComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TestReport.TestReportSetupComponent convertTestReportSetupComponent(org.hl7.fhir.r4.model.TestReport.TestReportSetupComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.TestReport.TestReportSetupComponent tgt = new org.hl7.fhir.dstu3.model.TestReport.TestReportSetupComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasAction()) {
            for (org.hl7.fhir.r4.model.TestReport.SetupActionComponent t : src.getAction()) tgt.addAction(VersionConvertor_30_40.convertSetupActionComponent(t));
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.TestReport.TestReportStatus convertTestReportStatus(org.hl7.fhir.dstu3.model.TestReport.TestReportStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case COMPLETED:
                return org.hl7.fhir.r4.model.TestReport.TestReportStatus.COMPLETED;
            case INPROGRESS:
                return org.hl7.fhir.r4.model.TestReport.TestReportStatus.INPROGRESS;
            case WAITING:
                return org.hl7.fhir.r4.model.TestReport.TestReportStatus.WAITING;
            case STOPPED:
                return org.hl7.fhir.r4.model.TestReport.TestReportStatus.STOPPED;
            case ENTEREDINERROR:
                return org.hl7.fhir.r4.model.TestReport.TestReportStatus.ENTEREDINERROR;
            default:
                return org.hl7.fhir.r4.model.TestReport.TestReportStatus.NULL;
        }
    }

    static public org.hl7.fhir.dstu3.model.TestReport.TestReportStatus convertTestReportStatus(org.hl7.fhir.r4.model.TestReport.TestReportStatus src) throws FHIRException {
        if (src == null)
            return null;
        switch(src) {
            case COMPLETED:
                return org.hl7.fhir.dstu3.model.TestReport.TestReportStatus.COMPLETED;
            case INPROGRESS:
                return org.hl7.fhir.dstu3.model.TestReport.TestReportStatus.INPROGRESS;
            case WAITING:
                return org.hl7.fhir.dstu3.model.TestReport.TestReportStatus.WAITING;
            case STOPPED:
                return org.hl7.fhir.dstu3.model.TestReport.TestReportStatus.STOPPED;
            case ENTEREDINERROR:
                return org.hl7.fhir.dstu3.model.TestReport.TestReportStatus.ENTEREDINERROR;
            default:
                return org.hl7.fhir.dstu3.model.TestReport.TestReportStatus.NULL;
        }
    }

    public static org.hl7.fhir.r4.model.TestReport.TestReportTeardownComponent convertTestReportTeardownComponent(org.hl7.fhir.dstu3.model.TestReport.TestReportTeardownComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.TestReport.TestReportTeardownComponent tgt = new org.hl7.fhir.r4.model.TestReport.TestReportTeardownComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasAction()) {
            for (org.hl7.fhir.dstu3.model.TestReport.TeardownActionComponent t : src.getAction()) tgt.addAction(VersionConvertor_30_40.convertTeardownActionComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TestReport.TestReportTeardownComponent convertTestReportTeardownComponent(org.hl7.fhir.r4.model.TestReport.TestReportTeardownComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.TestReport.TestReportTeardownComponent tgt = new org.hl7.fhir.dstu3.model.TestReport.TestReportTeardownComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasAction()) {
            for (org.hl7.fhir.r4.model.TestReport.TeardownActionComponent t : src.getAction()) tgt.addAction(VersionConvertor_30_40.convertTeardownActionComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TestReport.TestReportTestComponent convertTestReportTestComponent(org.hl7.fhir.r4.model.TestReport.TestReportTestComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.TestReport.TestReportTestComponent tgt = new org.hl7.fhir.dstu3.model.TestReport.TestReportTestComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasName())
            tgt.setName(src.getName());
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        if (src.hasAction()) {
            for (org.hl7.fhir.r4.model.TestReport.TestActionComponent t : src.getAction()) tgt.addAction(VersionConvertor_30_40.convertTestActionComponent(t));
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.TestReport.TestReportTestComponent convertTestReportTestComponent(org.hl7.fhir.dstu3.model.TestReport.TestReportTestComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.TestReport.TestReportTestComponent tgt = new org.hl7.fhir.r4.model.TestReport.TestReportTestComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasName())
            tgt.setName(src.getName());
        if (src.hasDescription())
            tgt.setDescription(src.getDescription());
        if (src.hasAction()) {
            for (org.hl7.fhir.dstu3.model.TestReport.TestActionComponent t : src.getAction()) tgt.addAction(VersionConvertor_30_40.convertTestActionComponent(t));
        }
        return tgt;
    }
}
