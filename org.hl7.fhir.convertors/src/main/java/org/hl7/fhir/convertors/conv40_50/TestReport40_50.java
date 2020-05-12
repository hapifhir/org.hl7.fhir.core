package org.hl7.fhir.convertors.conv40_50;


import org.hl7.fhir.convertors.VersionConvertor_40_50;
import org.hl7.fhir.exceptions.FHIRException;

/*
  Copyright (c) 2011+, HL7, Inc.
  All rights reserved.
  
  Redistribution and use in source and binary forms, with or without modification, 
  are permitted provided that the following conditions are met:
  
   * Redistributions of source code must retain the above copyright notice, this 
     list of conditions and the following disclaimer.
   * Redistributions in binary form must reproduce the above copyright notice, 
     this list of conditions and the following disclaimer in the documentation 
     and/or other materials provided with the distribution.
   * Neither the name of HL7 nor the names of its contributors may be used to 
     endorse or promote products derived from this software without specific 
     prior written permission.
  
  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
  ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT 
  NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
  PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
  ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
  POSSIBILITY OF SUCH DAMAGE.
  
*/
// Generated on Sun, Feb 24, 2019 11:37+1100 for FHIR v4.0.0
public class TestReport40_50 extends VersionConvertor_40_50 {

    public static org.hl7.fhir.r5.model.TestReport convertTestReport(org.hl7.fhir.r4.model.TestReport src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.TestReport tgt = new org.hl7.fhir.r5.model.TestReport();
        copyDomainResource(src, tgt);
        if (src.hasIdentifier())
            tgt.setIdentifier(convertIdentifier(src.getIdentifier()));
        if (src.hasName())
            tgt.setNameElement(convertString(src.getNameElement()));
        if (src.hasStatus())
            tgt.setStatusElement(convertTestReportStatus(src.getStatusElement()));
        if (src.hasTestScript())
            tgt.setTestScript(convertReference(src.getTestScript()));
        if (src.hasResult())
            tgt.setResultElement(convertTestReportResult(src.getResultElement()));
        if (src.hasScore())
            tgt.setScoreElement(convertDecimal(src.getScoreElement()));
        if (src.hasTester())
            tgt.setTesterElement(convertString(src.getTesterElement()));
        if (src.hasIssued())
            tgt.setIssuedElement(convertDateTime(src.getIssuedElement()));
        for (org.hl7.fhir.r4.model.TestReport.TestReportParticipantComponent t : src.getParticipant()) tgt.addParticipant(convertTestReportParticipantComponent(t));
        if (src.hasSetup())
            tgt.setSetup(convertTestReportSetupComponent(src.getSetup()));
        for (org.hl7.fhir.r4.model.TestReport.TestReportTestComponent t : src.getTest()) tgt.addTest(convertTestReportTestComponent(t));
        if (src.hasTeardown())
            tgt.setTeardown(convertTestReportTeardownComponent(src.getTeardown()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.TestReport convertTestReport(org.hl7.fhir.r5.model.TestReport src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.TestReport tgt = new org.hl7.fhir.r4.model.TestReport();
        copyDomainResource(src, tgt);
        if (src.hasIdentifier())
            tgt.setIdentifier(convertIdentifier(src.getIdentifier()));
        if (src.hasName())
            tgt.setNameElement(convertString(src.getNameElement()));
        if (src.hasStatus())
            tgt.setStatusElement(convertTestReportStatus(src.getStatusElement()));
        if (src.hasTestScript())
            tgt.setTestScript(convertReference(src.getTestScript()));
        if (src.hasResult())
            tgt.setResultElement(convertTestReportResult(src.getResultElement()));
        if (src.hasScore())
            tgt.setScoreElement(convertDecimal(src.getScoreElement()));
        if (src.hasTester())
            tgt.setTesterElement(convertString(src.getTesterElement()));
        if (src.hasIssued())
            tgt.setIssuedElement(convertDateTime(src.getIssuedElement()));
        for (org.hl7.fhir.r5.model.TestReport.TestReportParticipantComponent t : src.getParticipant()) tgt.addParticipant(convertTestReportParticipantComponent(t));
        if (src.hasSetup())
            tgt.setSetup(convertTestReportSetupComponent(src.getSetup()));
        for (org.hl7.fhir.r5.model.TestReport.TestReportTestComponent t : src.getTest()) tgt.addTest(convertTestReportTestComponent(t));
        if (src.hasTeardown())
            tgt.setTeardown(convertTestReportTeardownComponent(src.getTeardown()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestReport.TestReportStatus> convertTestReportStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TestReport.TestReportStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestReport.TestReportStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.TestReport.TestReportStatusEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case COMPLETED:
                tgt.setValue(org.hl7.fhir.r5.model.TestReport.TestReportStatus.COMPLETED);
                break;
            case INPROGRESS:
                tgt.setValue(org.hl7.fhir.r5.model.TestReport.TestReportStatus.INPROGRESS);
                break;
            case WAITING:
                tgt.setValue(org.hl7.fhir.r5.model.TestReport.TestReportStatus.WAITING);
                break;
            case STOPPED:
                tgt.setValue(org.hl7.fhir.r5.model.TestReport.TestReportStatus.STOPPED);
                break;
            case ENTEREDINERROR:
                tgt.setValue(org.hl7.fhir.r5.model.TestReport.TestReportStatus.ENTEREDINERROR);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.TestReport.TestReportStatus.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TestReport.TestReportStatus> convertTestReportStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestReport.TestReportStatus> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TestReport.TestReportStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.TestReport.TestReportStatusEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
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

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestReport.TestReportResult> convertTestReportResult(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TestReport.TestReportResult> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestReport.TestReportResult> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.TestReport.TestReportResultEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case PASS:
                tgt.setValue(org.hl7.fhir.r5.model.TestReport.TestReportResult.PASS);
                break;
            case FAIL:
                tgt.setValue(org.hl7.fhir.r5.model.TestReport.TestReportResult.FAIL);
                break;
            case PENDING:
                tgt.setValue(org.hl7.fhir.r5.model.TestReport.TestReportResult.PENDING);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.TestReport.TestReportResult.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TestReport.TestReportResult> convertTestReportResult(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestReport.TestReportResult> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TestReport.TestReportResult> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.TestReport.TestReportResultEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
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

    public static org.hl7.fhir.r5.model.TestReport.TestReportParticipantComponent convertTestReportParticipantComponent(org.hl7.fhir.r4.model.TestReport.TestReportParticipantComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.TestReport.TestReportParticipantComponent tgt = new org.hl7.fhir.r5.model.TestReport.TestReportParticipantComponent();
        copyElement(src, tgt);
        if (src.hasType())
            tgt.setTypeElement(convertTestReportParticipantType(src.getTypeElement()));
        if (src.hasUri())
            tgt.setUriElement(convertUri(src.getUriElement()));
        if (src.hasDisplay())
            tgt.setDisplayElement(convertString(src.getDisplayElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.TestReport.TestReportParticipantComponent convertTestReportParticipantComponent(org.hl7.fhir.r5.model.TestReport.TestReportParticipantComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.TestReport.TestReportParticipantComponent tgt = new org.hl7.fhir.r4.model.TestReport.TestReportParticipantComponent();
        copyElement(src, tgt);
        if (src.hasType())
            tgt.setTypeElement(convertTestReportParticipantType(src.getTypeElement()));
        if (src.hasUri())
            tgt.setUriElement(convertUri(src.getUriElement()));
        if (src.hasDisplay())
            tgt.setDisplayElement(convertString(src.getDisplayElement()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestReport.TestReportParticipantType> convertTestReportParticipantType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TestReport.TestReportParticipantType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestReport.TestReportParticipantType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.TestReport.TestReportParticipantTypeEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case TESTENGINE:
                tgt.setValue(org.hl7.fhir.r5.model.TestReport.TestReportParticipantType.TESTENGINE);
                break;
            case CLIENT:
                tgt.setValue(org.hl7.fhir.r5.model.TestReport.TestReportParticipantType.CLIENT);
                break;
            case SERVER:
                tgt.setValue(org.hl7.fhir.r5.model.TestReport.TestReportParticipantType.SERVER);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.TestReport.TestReportParticipantType.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TestReport.TestReportParticipantType> convertTestReportParticipantType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestReport.TestReportParticipantType> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TestReport.TestReportParticipantType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.TestReport.TestReportParticipantTypeEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
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

    public static org.hl7.fhir.r5.model.TestReport.TestReportSetupComponent convertTestReportSetupComponent(org.hl7.fhir.r4.model.TestReport.TestReportSetupComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.TestReport.TestReportSetupComponent tgt = new org.hl7.fhir.r5.model.TestReport.TestReportSetupComponent();
        copyElement(src, tgt);
        for (org.hl7.fhir.r4.model.TestReport.SetupActionComponent t : src.getAction()) tgt.addAction(convertSetupActionComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.TestReport.TestReportSetupComponent convertTestReportSetupComponent(org.hl7.fhir.r5.model.TestReport.TestReportSetupComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.TestReport.TestReportSetupComponent tgt = new org.hl7.fhir.r4.model.TestReport.TestReportSetupComponent();
        copyElement(src, tgt);
        for (org.hl7.fhir.r5.model.TestReport.SetupActionComponent t : src.getAction()) tgt.addAction(convertSetupActionComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.TestReport.SetupActionComponent convertSetupActionComponent(org.hl7.fhir.r4.model.TestReport.SetupActionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.TestReport.SetupActionComponent tgt = new org.hl7.fhir.r5.model.TestReport.SetupActionComponent();
        copyElement(src, tgt);
        if (src.hasOperation())
            tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
        if (src.hasAssert())
            tgt.setAssert(convertSetupActionAssertComponent(src.getAssert()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.TestReport.SetupActionComponent convertSetupActionComponent(org.hl7.fhir.r5.model.TestReport.SetupActionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.TestReport.SetupActionComponent tgt = new org.hl7.fhir.r4.model.TestReport.SetupActionComponent();
        copyElement(src, tgt);
        if (src.hasOperation())
            tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
        if (src.hasAssert())
            tgt.setAssert(convertSetupActionAssertComponent(src.getAssert()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.TestReport.SetupActionOperationComponent convertSetupActionOperationComponent(org.hl7.fhir.r4.model.TestReport.SetupActionOperationComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.TestReport.SetupActionOperationComponent tgt = new org.hl7.fhir.r5.model.TestReport.SetupActionOperationComponent();
        copyElement(src, tgt);
        if (src.hasResult())
            tgt.setResultElement(convertTestReportActionResult(src.getResultElement()));
        if (src.hasMessage())
            tgt.setMessageElement(convertMarkdown(src.getMessageElement()));
        if (src.hasDetail())
            tgt.setDetailElement(convertUri(src.getDetailElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.TestReport.SetupActionOperationComponent convertSetupActionOperationComponent(org.hl7.fhir.r5.model.TestReport.SetupActionOperationComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.TestReport.SetupActionOperationComponent tgt = new org.hl7.fhir.r4.model.TestReport.SetupActionOperationComponent();
        copyElement(src, tgt);
        if (src.hasResult())
            tgt.setResultElement(convertTestReportActionResult(src.getResultElement()));
        if (src.hasMessage())
            tgt.setMessageElement(convertMarkdown(src.getMessageElement()));
        if (src.hasDetail())
            tgt.setDetailElement(convertUri(src.getDetailElement()));
        return tgt;
    }

    static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestReport.TestReportActionResult> convertTestReportActionResult(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TestReport.TestReportActionResult> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestReport.TestReportActionResult> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.TestReport.TestReportActionResultEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case PASS:
                tgt.setValue(org.hl7.fhir.r5.model.TestReport.TestReportActionResult.PASS);
                break;
            case SKIP:
                tgt.setValue(org.hl7.fhir.r5.model.TestReport.TestReportActionResult.SKIP);
                break;
            case FAIL:
                tgt.setValue(org.hl7.fhir.r5.model.TestReport.TestReportActionResult.FAIL);
                break;
            case WARNING:
                tgt.setValue(org.hl7.fhir.r5.model.TestReport.TestReportActionResult.WARNING);
                break;
            case ERROR:
                tgt.setValue(org.hl7.fhir.r5.model.TestReport.TestReportActionResult.ERROR);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r5.model.TestReport.TestReportActionResult.NULL);
                break;
        }
        return tgt;
    }

    static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TestReport.TestReportActionResult> convertTestReportActionResult(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestReport.TestReportActionResult> src) throws FHIRException {
        if (src == null || src.isEmpty())
            return null;
        org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TestReport.TestReportActionResult> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.TestReport.TestReportActionResultEnumFactory());
        VersionConvertor_40_50.copyElement(src, tgt);
        switch(src.getValue()) {
            case PASS:
                tgt.setValue(org.hl7.fhir.r4.model.TestReport.TestReportActionResult.PASS);
                break;
            case SKIP:
                tgt.setValue(org.hl7.fhir.r4.model.TestReport.TestReportActionResult.SKIP);
                break;
            case FAIL:
                tgt.setValue(org.hl7.fhir.r4.model.TestReport.TestReportActionResult.FAIL);
                break;
            case WARNING:
                tgt.setValue(org.hl7.fhir.r4.model.TestReport.TestReportActionResult.WARNING);
                break;
            case ERROR:
                tgt.setValue(org.hl7.fhir.r4.model.TestReport.TestReportActionResult.ERROR);
                break;
            default:
                tgt.setValue(org.hl7.fhir.r4.model.TestReport.TestReportActionResult.NULL);
                break;
        }
        return tgt;
    }

    public static org.hl7.fhir.r5.model.TestReport.SetupActionAssertComponent convertSetupActionAssertComponent(org.hl7.fhir.r4.model.TestReport.SetupActionAssertComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.TestReport.SetupActionAssertComponent tgt = new org.hl7.fhir.r5.model.TestReport.SetupActionAssertComponent();
        copyElement(src, tgt);
        if (src.hasResult())
            tgt.setResultElement(convertTestReportActionResult(src.getResultElement()));
        if (src.hasMessage())
            tgt.setMessageElement(convertMarkdown(src.getMessageElement()));
        if (src.hasDetail())
            tgt.setDetailElement(convertString(src.getDetailElement()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.TestReport.SetupActionAssertComponent convertSetupActionAssertComponent(org.hl7.fhir.r5.model.TestReport.SetupActionAssertComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.TestReport.SetupActionAssertComponent tgt = new org.hl7.fhir.r4.model.TestReport.SetupActionAssertComponent();
        copyElement(src, tgt);
        if (src.hasResult())
            tgt.setResultElement(convertTestReportActionResult(src.getResultElement()));
        if (src.hasMessage())
            tgt.setMessageElement(convertMarkdown(src.getMessageElement()));
        if (src.hasDetail())
            tgt.setDetailElement(convertString(src.getDetailElement()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.TestReport.TestReportTestComponent convertTestReportTestComponent(org.hl7.fhir.r4.model.TestReport.TestReportTestComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.TestReport.TestReportTestComponent tgt = new org.hl7.fhir.r5.model.TestReport.TestReportTestComponent();
        copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(convertString(src.getNameElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        for (org.hl7.fhir.r4.model.TestReport.TestActionComponent t : src.getAction()) tgt.addAction(convertTestActionComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.TestReport.TestReportTestComponent convertTestReportTestComponent(org.hl7.fhir.r5.model.TestReport.TestReportTestComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.TestReport.TestReportTestComponent tgt = new org.hl7.fhir.r4.model.TestReport.TestReportTestComponent();
        copyElement(src, tgt);
        if (src.hasName())
            tgt.setNameElement(convertString(src.getNameElement()));
        if (src.hasDescription())
            tgt.setDescriptionElement(convertString(src.getDescriptionElement()));
        for (org.hl7.fhir.r5.model.TestReport.TestActionComponent t : src.getAction()) tgt.addAction(convertTestActionComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.TestReport.TestActionComponent convertTestActionComponent(org.hl7.fhir.r4.model.TestReport.TestActionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.TestReport.TestActionComponent tgt = new org.hl7.fhir.r5.model.TestReport.TestActionComponent();
        copyElement(src, tgt);
        if (src.hasOperation())
            tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
        if (src.hasAssert())
            tgt.setAssert(convertSetupActionAssertComponent(src.getAssert()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.TestReport.TestActionComponent convertTestActionComponent(org.hl7.fhir.r5.model.TestReport.TestActionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.TestReport.TestActionComponent tgt = new org.hl7.fhir.r4.model.TestReport.TestActionComponent();
        copyElement(src, tgt);
        if (src.hasOperation())
            tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
        if (src.hasAssert())
            tgt.setAssert(convertSetupActionAssertComponent(src.getAssert()));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.TestReport.TestReportTeardownComponent convertTestReportTeardownComponent(org.hl7.fhir.r4.model.TestReport.TestReportTeardownComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.TestReport.TestReportTeardownComponent tgt = new org.hl7.fhir.r5.model.TestReport.TestReportTeardownComponent();
        copyElement(src, tgt);
        for (org.hl7.fhir.r4.model.TestReport.TeardownActionComponent t : src.getAction()) tgt.addAction(convertTeardownActionComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.TestReport.TestReportTeardownComponent convertTestReportTeardownComponent(org.hl7.fhir.r5.model.TestReport.TestReportTeardownComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.TestReport.TestReportTeardownComponent tgt = new org.hl7.fhir.r4.model.TestReport.TestReportTeardownComponent();
        copyElement(src, tgt);
        for (org.hl7.fhir.r5.model.TestReport.TeardownActionComponent t : src.getAction()) tgt.addAction(convertTeardownActionComponent(t));
        return tgt;
    }

    public static org.hl7.fhir.r5.model.TestReport.TeardownActionComponent convertTeardownActionComponent(org.hl7.fhir.r4.model.TestReport.TeardownActionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r5.model.TestReport.TeardownActionComponent tgt = new org.hl7.fhir.r5.model.TestReport.TeardownActionComponent();
        copyElement(src, tgt);
        if (src.hasOperation())
            tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
        return tgt;
    }

    public static org.hl7.fhir.r4.model.TestReport.TeardownActionComponent convertTeardownActionComponent(org.hl7.fhir.r5.model.TestReport.TeardownActionComponent src) throws FHIRException {
        if (src == null)
            return null;
        org.hl7.fhir.r4.model.TestReport.TeardownActionComponent tgt = new org.hl7.fhir.r4.model.TestReport.TeardownActionComponent();
        copyElement(src, tgt);
        if (src.hasOperation())
            tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
        return tgt;
    }
}