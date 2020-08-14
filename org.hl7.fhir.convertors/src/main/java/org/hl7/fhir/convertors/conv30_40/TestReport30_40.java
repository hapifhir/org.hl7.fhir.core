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
            tgt.setNameElement(VersionConvertor_30_40.convertString(src.getNameElement()));
        if (src.hasStatus())
            tgt.setStatusElement(convertTestReportStatus(src.getStatusElement()));
        if (src.hasTestScript())
            tgt.setTestScript(VersionConvertor_30_40.convertReference(src.getTestScript()));
        if (src.hasResult())
            tgt.setResultElement(convertTestReportResult(src.getResultElement()));
        if (src.hasScore())
            tgt.setScoreElement(VersionConvertor_30_40.convertDecimal(src.getScoreElement()));
        if (src.hasTester())
            tgt.setTesterElement(VersionConvertor_30_40.convertString(src.getTesterElement()));
        if (src.hasIssued())
            tgt.setIssuedElement(VersionConvertor_30_40.convertDateTime(src.getIssuedElement()));
        for (org.hl7.fhir.dstu3.model.TestReport.TestReportParticipantComponent t : src.getParticipant()) tgt.addParticipant(convertTestReportParticipantComponent(t));
        if (src.hasSetup())
            tgt.setSetup(convertTestReportSetupComponent(src.getSetup()));
        for (org.hl7.fhir.dstu3.model.TestReport.TestReportTestComponent t : src.getTest()) tgt.addTest(convertTestReportTestComponent(t));
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
            tgt.setNameElement(VersionConvertor_30_40.convertString(src.getNameElement()));
        if (src.hasStatus())
            tgt.setStatusElement(convertTestReportStatus(src.getStatusElement()));
        if (src.hasTestScript())
            tgt.setTestScript(VersionConvertor_30_40.convertReference(src.getTestScript()));
        if (src.hasResult())
            tgt.setResultElement(convertTestReportResult(src.getResultElement()));
        if (src.hasScore())
            tgt.setScoreElement(VersionConvertor_30_40.convertDecimal(src.getScoreElement()));
        if (src.hasTester())
            tgt.setTesterElement(VersionConvertor_30_40.convertString(src.getTesterElement()));
        if (src.hasIssued())
            tgt.setIssuedElement(VersionConvertor_30_40.convertDateTime(src.getIssuedElement()));
        for (org.hl7.fhir.r4.model.TestReport.TestReportParticipantComponent t : src.getParticipant()) tgt.addParticipant(convertTestReportParticipantComponent(t));
        if (src.hasSetup())
            tgt.setSetup(convertTestReportSetupComponent(src.getSetup()));
        for (org.hl7.fhir.r4.model.TestReport.TestReportTestComponent t : src.getTest()) tgt.addTest(convertTestReportTestComponent(t));
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
            tgt.setTypeElement(convertTestReportParticipantType(src.getTypeElement()));
        if (src.hasUri())
            tgt.setUriElement(VersionConvertor_30_40.convertUri(src.getUriElement()));
        if (src.hasDisplay())
            tgt.setDisplayElement(VersionConvertor_30_40.convertString(src.getDisplayElement()));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TestReport.TestReportParticipantComponent convertTestReportParticipantComponent(org.hl7.fhir.r4.model.TestReport.TestReportParticipantComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.TestReport.TestReportParticipantComponent tgt = new org.hl7.fhir.dstu3.model.TestReport.TestReportParticipantComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasType())
            tgt.setTypeElement(convertTestReportParticipantType(src.getTypeElement()));
        if (src.hasUri())
            tgt.setUriElement(VersionConvertor_30_40.convertUri(src.getUriElement()));
        if (src.hasDisplay())
            tgt.setDisplayElement(VersionConvertor_30_40.convertString(src.getDisplayElement()));
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.TestReport.TestReportParticipantType> convertTestReportParticipantType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TestReport.TestReportParticipantType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.TestReport.TestReportParticipantType> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.TestReport.TestReportParticipantTypeEnumFactory());
        VersionConvertor_30_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case TESTENGINE:
                tgt.setValue(org.hl7.fhir.dstu3.model.TestReport.TestReportParticipantType.TESTENGINE);
                break;
            case CLIENT:
                tgt.setValue(org.hl7.fhir.dstu3.model.TestReport.TestReportParticipantType.CLIENT);
                break;
            case SERVER:
                tgt.setValue(org.hl7.fhir.dstu3.model.TestReport.TestReportParticipantType.SERVER);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.TestReport.TestReportParticipantType.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TestReport.TestReportParticipantType> convertTestReportParticipantType(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.TestReport.TestReportParticipantType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TestReport.TestReportParticipantType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.TestReport.TestReportParticipantTypeEnumFactory());
        VersionConvertor_30_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case TESTENGINE:
                tgt.setValue(org.hl7.fhir.r4.model.TestReport.TestReportParticipantType.TESTENGINE);
                break;
            case CLIENT:
                tgt.setValue(org.hl7.fhir.r4.model.TestReport.TestReportParticipantType.CLIENT);
                break;
            case SERVER:
                tgt.setValue(org.hl7.fhir.r4.model.TestReport.TestReportParticipantType.SERVER);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.TestReport.TestReportParticipantType.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TestReport.TestReportResult> convertTestReportResult(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.TestReport.TestReportResult> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TestReport.TestReportResult> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.TestReport.TestReportResultEnumFactory());
        VersionConvertor_30_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case PASS:
                tgt.setValue(org.hl7.fhir.r4.model.TestReport.TestReportResult.PASS);
                break;
            case FAIL:
                tgt.setValue(org.hl7.fhir.r4.model.TestReport.TestReportResult.FAIL);
                break;
            case PENDING:
                tgt.setValue(org.hl7.fhir.r4.model.TestReport.TestReportResult.PENDING);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.TestReport.TestReportResult.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.TestReport.TestReportResult> convertTestReportResult(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TestReport.TestReportResult> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.TestReport.TestReportResult> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.TestReport.TestReportResultEnumFactory());
        VersionConvertor_30_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case PASS:
                tgt.setValue(org.hl7.fhir.dstu3.model.TestReport.TestReportResult.PASS);
                break;
            case FAIL:
                tgt.setValue(org.hl7.fhir.dstu3.model.TestReport.TestReportResult.FAIL);
                break;
            case PENDING:
                tgt.setValue(org.hl7.fhir.dstu3.model.TestReport.TestReportResult.PENDING);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.TestReport.TestReportResult.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.TestReport.TestReportSetupComponent convertTestReportSetupComponent(org.hl7.fhir.dstu3.model.TestReport.TestReportSetupComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.TestReport.TestReportSetupComponent tgt = new org.hl7.fhir.r4.model.TestReport.TestReportSetupComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        for (org.hl7.fhir.dstu3.model.TestReport.SetupActionComponent t : src.getAction()) tgt.addAction(VersionConvertor_30_40.convertSetupActionComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TestReport.TestReportSetupComponent convertTestReportSetupComponent(org.hl7.fhir.r4.model.TestReport.TestReportSetupComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.TestReport.TestReportSetupComponent tgt = new org.hl7.fhir.dstu3.model.TestReport.TestReportSetupComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        for (org.hl7.fhir.r4.model.TestReport.SetupActionComponent t : src.getAction()) tgt.addAction(VersionConvertor_30_40.convertSetupActionComponent(t));
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TestReport.TestReportStatus> convertTestReportStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.TestReport.TestReportStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TestReport.TestReportStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.TestReport.TestReportStatusEnumFactory());
        VersionConvertor_30_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case COMPLETED:
                tgt.setValue(org.hl7.fhir.r4.model.TestReport.TestReportStatus.COMPLETED);
                break;
            case INPROGRESS:
                tgt.setValue(org.hl7.fhir.r4.model.TestReport.TestReportStatus.INPROGRESS);
                break;
            case WAITING:
                tgt.setValue(org.hl7.fhir.r4.model.TestReport.TestReportStatus.WAITING);
                break;
            case STOPPED:
                tgt.setValue(org.hl7.fhir.r4.model.TestReport.TestReportStatus.STOPPED);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.r4.model.TestReport.TestReportStatus.ENTEREDINERROR);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.TestReport.TestReportStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.TestReport.TestReportStatus> convertTestReportStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TestReport.TestReportStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.TestReport.TestReportStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.TestReport.TestReportStatusEnumFactory());
        VersionConvertor_30_40.copyElement(src, tgt);
        switch(src.getValue()) {
            case COMPLETED:
                tgt.setValue(org.hl7.fhir.dstu3.model.TestReport.TestReportStatus.COMPLETED);
                break;
            case INPROGRESS:
                tgt.setValue(org.hl7.fhir.dstu3.model.TestReport.TestReportStatus.INPROGRESS);
                break;
            case WAITING:
                tgt.setValue(org.hl7.fhir.dstu3.model.TestReport.TestReportStatus.WAITING);
                break;
            case STOPPED:
                tgt.setValue(org.hl7.fhir.dstu3.model.TestReport.TestReportStatus.STOPPED);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.dstu3.model.TestReport.TestReportStatus.ENTEREDINERROR);
                break;
            default:
                tgt.setValue(org.hl7.fhir.dstu3.model.TestReport.TestReportStatus.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r4.model.TestReport.TestReportTeardownComponent convertTestReportTeardownComponent(org.hl7.fhir.dstu3.model.TestReport.TestReportTeardownComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.TestReport.TestReportTeardownComponent tgt = new org.hl7.fhir.r4.model.TestReport.TestReportTeardownComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        for (org.hl7.fhir.dstu3.model.TestReport.TeardownActionComponent t : src.getAction()) tgt.addAction(VersionConvertor_30_40.convertTeardownActionComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TestReport.TestReportTeardownComponent convertTestReportTeardownComponent(org.hl7.fhir.r4.model.TestReport.TestReportTeardownComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.TestReport.TestReportTeardownComponent tgt = new org.hl7.fhir.dstu3.model.TestReport.TestReportTeardownComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        for (org.hl7.fhir.r4.model.TestReport.TeardownActionComponent t : src.getAction()) tgt.addAction(VersionConvertor_30_40.convertTeardownActionComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.dstu3.model.TestReport.TestReportTestComponent convertTestReportTestComponent(org.hl7.fhir.r4.model.TestReport.TestReportTestComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.dstu3.model.TestReport.TestReportTestComponent tgt = new org.hl7.fhir.dstu3.model.TestReport.TestReportTestComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_30_40.convertString(src.getNameElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(VersionConvertor_30_40.convertString(src.getDescriptionElement()));
        for (org.hl7.fhir.r4.model.TestReport.TestActionComponent t : src.getAction()) tgt.addAction(VersionConvertor_30_40.convertTestActionComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.TestReport.TestReportTestComponent convertTestReportTestComponent(org.hl7.fhir.dstu3.model.TestReport.TestReportTestComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.TestReport.TestReportTestComponent tgt = new org.hl7.fhir.r4.model.TestReport.TestReportTestComponent();
        VersionConvertor_30_40.copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(VersionConvertor_30_40.convertString(src.getNameElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(VersionConvertor_30_40.convertString(src.getDescriptionElement()));
        for (org.hl7.fhir.dstu3.model.TestReport.TestActionComponent t : src.getAction()) tgt.addAction(VersionConvertor_30_40.convertTestActionComponent(t));
        return tgt;
    }
}