package org.hl7.fhir.convertors.conv40_50;

import org.hl7.fhir.exceptions.FHIRException;

import org.hl7.fhir.convertors.VersionConvertor_40_50;


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


public class TestReport extends VersionConvertor_40_50 {

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
      tgt.setStatus(convertTestReportStatus(src.getStatus()));
    if (src.hasTestScript())
      tgt.setTestScript(convertReference(src.getTestScript()));
    if (src.hasResult())
      tgt.setResult(convertTestReportResult(src.getResult()));
    if (src.hasScore())
      tgt.setScoreElement(convertDecimal(src.getScoreElement()));
    if (src.hasTester())
      tgt.setTesterElement(convertString(src.getTesterElement()));
    if (src.hasIssued())
      tgt.setIssuedElement(convertDateTime(src.getIssuedElement()));
    for (org.hl7.fhir.r4.model.TestReport.TestReportParticipantComponent t : src.getParticipant())
      tgt.addParticipant(convertTestReportParticipantComponent(t));
    if (src.hasSetup())
      tgt.setSetup(convertTestReportSetupComponent(src.getSetup()));
    for (org.hl7.fhir.r4.model.TestReport.TestReportTestComponent t : src.getTest())
      tgt.addTest(convertTestReportTestComponent(t));
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
      tgt.setStatus(convertTestReportStatus(src.getStatus()));
    if (src.hasTestScript())
      tgt.setTestScript(convertReference(src.getTestScript()));
    if (src.hasResult())
      tgt.setResult(convertTestReportResult(src.getResult()));
    if (src.hasScore())
      tgt.setScoreElement(convertDecimal(src.getScoreElement()));
    if (src.hasTester())
      tgt.setTesterElement(convertString(src.getTesterElement()));
    if (src.hasIssued())
      tgt.setIssuedElement(convertDateTime(src.getIssuedElement()));
    for (org.hl7.fhir.r5.model.TestReport.TestReportParticipantComponent t : src.getParticipant())
      tgt.addParticipant(convertTestReportParticipantComponent(t));
    if (src.hasSetup())
      tgt.setSetup(convertTestReportSetupComponent(src.getSetup()));
    for (org.hl7.fhir.r5.model.TestReport.TestReportTestComponent t : src.getTest())
      tgt.addTest(convertTestReportTestComponent(t));
    if (src.hasTeardown())
      tgt.setTeardown(convertTestReportTeardownComponent(src.getTeardown()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestReport.TestReportStatus convertTestReportStatus(org.hl7.fhir.r4.model.TestReport.TestReportStatus src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case COMPLETED: return org.hl7.fhir.r5.model.TestReport.TestReportStatus.COMPLETED;
    case INPROGRESS: return org.hl7.fhir.r5.model.TestReport.TestReportStatus.INPROGRESS;
    case WAITING: return org.hl7.fhir.r5.model.TestReport.TestReportStatus.WAITING;
    case STOPPED: return org.hl7.fhir.r5.model.TestReport.TestReportStatus.STOPPED;
    case ENTEREDINERROR: return org.hl7.fhir.r5.model.TestReport.TestReportStatus.ENTEREDINERROR;
    default: return org.hl7.fhir.r5.model.TestReport.TestReportStatus.NULL;
  }
}

  public static org.hl7.fhir.r4.model.TestReport.TestReportStatus convertTestReportStatus(org.hl7.fhir.r5.model.TestReport.TestReportStatus src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case COMPLETED: return org.hl7.fhir.r4.model.TestReport.TestReportStatus.COMPLETED;
    case INPROGRESS: return org.hl7.fhir.r4.model.TestReport.TestReportStatus.INPROGRESS;
    case WAITING: return org.hl7.fhir.r4.model.TestReport.TestReportStatus.WAITING;
    case STOPPED: return org.hl7.fhir.r4.model.TestReport.TestReportStatus.STOPPED;
    case ENTEREDINERROR: return org.hl7.fhir.r4.model.TestReport.TestReportStatus.ENTEREDINERROR;
    default: return org.hl7.fhir.r4.model.TestReport.TestReportStatus.NULL;
  }
}

  public static org.hl7.fhir.r5.model.TestReport.TestReportResult convertTestReportResult(org.hl7.fhir.r4.model.TestReport.TestReportResult src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case PASS: return org.hl7.fhir.r5.model.TestReport.TestReportResult.PASS;
    case FAIL: return org.hl7.fhir.r5.model.TestReport.TestReportResult.FAIL;
    case PENDING: return org.hl7.fhir.r5.model.TestReport.TestReportResult.PENDING;
    default: return org.hl7.fhir.r5.model.TestReport.TestReportResult.NULL;
  }
}

  public static org.hl7.fhir.r4.model.TestReport.TestReportResult convertTestReportResult(org.hl7.fhir.r5.model.TestReport.TestReportResult src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case PASS: return org.hl7.fhir.r4.model.TestReport.TestReportResult.PASS;
    case FAIL: return org.hl7.fhir.r4.model.TestReport.TestReportResult.FAIL;
    case PENDING: return org.hl7.fhir.r4.model.TestReport.TestReportResult.PENDING;
    default: return org.hl7.fhir.r4.model.TestReport.TestReportResult.NULL;
  }
}

  public static org.hl7.fhir.r5.model.TestReport.TestReportParticipantComponent convertTestReportParticipantComponent(org.hl7.fhir.r4.model.TestReport.TestReportParticipantComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestReport.TestReportParticipantComponent tgt = new org.hl7.fhir.r5.model.TestReport.TestReportParticipantComponent();
    copyElement(src, tgt);
    if (src.hasType())
      tgt.setType(convertTestReportParticipantType(src.getType()));
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
      tgt.setType(convertTestReportParticipantType(src.getType()));
    if (src.hasUri())
      tgt.setUriElement(convertUri(src.getUriElement()));
    if (src.hasDisplay())
      tgt.setDisplayElement(convertString(src.getDisplayElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestReport.TestReportParticipantType convertTestReportParticipantType(org.hl7.fhir.r4.model.TestReport.TestReportParticipantType src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case TESTENGINE: return org.hl7.fhir.r5.model.TestReport.TestReportParticipantType.TESTENGINE;
    case CLIENT: return org.hl7.fhir.r5.model.TestReport.TestReportParticipantType.CLIENT;
    case SERVER: return org.hl7.fhir.r5.model.TestReport.TestReportParticipantType.SERVER;
    default: return org.hl7.fhir.r5.model.TestReport.TestReportParticipantType.NULL;
  }
}

  public static org.hl7.fhir.r4.model.TestReport.TestReportParticipantType convertTestReportParticipantType(org.hl7.fhir.r5.model.TestReport.TestReportParticipantType src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case TESTENGINE: return org.hl7.fhir.r4.model.TestReport.TestReportParticipantType.TESTENGINE;
    case CLIENT: return org.hl7.fhir.r4.model.TestReport.TestReportParticipantType.CLIENT;
    case SERVER: return org.hl7.fhir.r4.model.TestReport.TestReportParticipantType.SERVER;
    default: return org.hl7.fhir.r4.model.TestReport.TestReportParticipantType.NULL;
  }
}

  public static org.hl7.fhir.r5.model.TestReport.TestReportSetupComponent convertTestReportSetupComponent(org.hl7.fhir.r4.model.TestReport.TestReportSetupComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestReport.TestReportSetupComponent tgt = new org.hl7.fhir.r5.model.TestReport.TestReportSetupComponent();
    copyElement(src, tgt);
    for (org.hl7.fhir.r4.model.TestReport.SetupActionComponent t : src.getAction())
      tgt.addAction(convertSetupActionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.TestReport.TestReportSetupComponent convertTestReportSetupComponent(org.hl7.fhir.r5.model.TestReport.TestReportSetupComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.TestReport.TestReportSetupComponent tgt = new org.hl7.fhir.r4.model.TestReport.TestReportSetupComponent();
    copyElement(src, tgt);
    for (org.hl7.fhir.r5.model.TestReport.SetupActionComponent t : src.getAction())
      tgt.addAction(convertSetupActionComponent(t));
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
      tgt.setResult(convertTestReportActionResult(src.getResult()));
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
      tgt.setResult(convertTestReportActionResult(src.getResult()));
    if (src.hasMessage())
      tgt.setMessageElement(convertMarkdown(src.getMessageElement()));
    if (src.hasDetail())
      tgt.setDetailElement(convertUri(src.getDetailElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestReport.TestReportActionResult convertTestReportActionResult(org.hl7.fhir.r4.model.TestReport.TestReportActionResult src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case PASS: return org.hl7.fhir.r5.model.TestReport.TestReportActionResult.PASS;
    case SKIP: return org.hl7.fhir.r5.model.TestReport.TestReportActionResult.SKIP;
    case FAIL: return org.hl7.fhir.r5.model.TestReport.TestReportActionResult.FAIL;
    case WARNING: return org.hl7.fhir.r5.model.TestReport.TestReportActionResult.WARNING;
    case ERROR: return org.hl7.fhir.r5.model.TestReport.TestReportActionResult.ERROR;
    default: return org.hl7.fhir.r5.model.TestReport.TestReportActionResult.NULL;
  }
}

  public static org.hl7.fhir.r4.model.TestReport.TestReportActionResult convertTestReportActionResult(org.hl7.fhir.r5.model.TestReport.TestReportActionResult src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case PASS: return org.hl7.fhir.r4.model.TestReport.TestReportActionResult.PASS;
    case SKIP: return org.hl7.fhir.r4.model.TestReport.TestReportActionResult.SKIP;
    case FAIL: return org.hl7.fhir.r4.model.TestReport.TestReportActionResult.FAIL;
    case WARNING: return org.hl7.fhir.r4.model.TestReport.TestReportActionResult.WARNING;
    case ERROR: return org.hl7.fhir.r4.model.TestReport.TestReportActionResult.ERROR;
    default: return org.hl7.fhir.r4.model.TestReport.TestReportActionResult.NULL;
  }
}

  public static org.hl7.fhir.r5.model.TestReport.SetupActionAssertComponent convertSetupActionAssertComponent(org.hl7.fhir.r4.model.TestReport.SetupActionAssertComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestReport.SetupActionAssertComponent tgt = new org.hl7.fhir.r5.model.TestReport.SetupActionAssertComponent();
    copyElement(src, tgt);
    if (src.hasResult())
      tgt.setResult(convertTestReportActionResult(src.getResult()));
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
      tgt.setResult(convertTestReportActionResult(src.getResult()));
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
    for (org.hl7.fhir.r4.model.TestReport.TestActionComponent t : src.getAction())
      tgt.addAction(convertTestActionComponent(t));
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
    for (org.hl7.fhir.r5.model.TestReport.TestActionComponent t : src.getAction())
      tgt.addAction(convertTestActionComponent(t));
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
    for (org.hl7.fhir.r4.model.TestReport.TeardownActionComponent t : src.getAction())
      tgt.addAction(convertTeardownActionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.TestReport.TestReportTeardownComponent convertTestReportTeardownComponent(org.hl7.fhir.r5.model.TestReport.TestReportTeardownComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.TestReport.TestReportTeardownComponent tgt = new org.hl7.fhir.r4.model.TestReport.TestReportTeardownComponent();
    copyElement(src, tgt);
    for (org.hl7.fhir.r5.model.TestReport.TeardownActionComponent t : src.getAction())
      tgt.addAction(convertTeardownActionComponent(t));
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
