package org.hl7.fhir.convertors.conv43_50.resources43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.Identifier43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.DateTime43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Decimal43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.MarkDown43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.String43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.Uri43_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4b.model.Reference;

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
public class TestReport43_50 {

  public static org.hl7.fhir.r5.model.TestReport convertTestReport(org.hl7.fhir.r4b.model.TestReport src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestReport tgt = new org.hl7.fhir.r5.model.TestReport();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier43_50.convertIdentifier(src.getIdentifier()));
    if (src.hasName())
      tgt.setNameElement(String43_50.convertString(src.getNameElement()));
    if (src.hasStatus())
      tgt.setStatusElement(convertTestReportStatus(src.getStatusElement()));
    if (src.hasTestScript())
      tgt.setTestScript(src.getTestScript().getReference());
    if (src.hasResult())
      tgt.setResultElement(convertTestReportResult(src.getResultElement()));
    if (src.hasScore())
      tgt.setScoreElement(Decimal43_50.convertDecimal(src.getScoreElement()));
    if (src.hasTester())
      tgt.setTesterElement(String43_50.convertString(src.getTesterElement()));
    if (src.hasIssued())
      tgt.setIssuedElement(DateTime43_50.convertDateTime(src.getIssuedElement()));
    for (org.hl7.fhir.r4b.model.TestReport.TestReportParticipantComponent t : src.getParticipant())
      tgt.addParticipant(convertTestReportParticipantComponent(t));
    if (src.hasSetup())
      tgt.setSetup(convertTestReportSetupComponent(src.getSetup()));
    for (org.hl7.fhir.r4b.model.TestReport.TestReportTestComponent t : src.getTest())
      tgt.addTest(convertTestReportTestComponent(t));
    if (src.hasTeardown())
      tgt.setTeardown(convertTestReportTeardownComponent(src.getTeardown()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.TestReport convertTestReport(org.hl7.fhir.r5.model.TestReport src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.TestReport tgt = new org.hl7.fhir.r4b.model.TestReport();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier43_50.convertIdentifier(src.getIdentifier()));
    if (src.hasName())
      tgt.setNameElement(String43_50.convertString(src.getNameElement()));
    if (src.hasStatus())
      tgt.setStatusElement(convertTestReportStatus(src.getStatusElement()));
    if (src.hasTestScript())
      tgt.setTestScript(new Reference().setReference(src.getTestScript()));
    if (src.hasResult())
      tgt.setResultElement(convertTestReportResult(src.getResultElement()));
    if (src.hasScore())
      tgt.setScoreElement(Decimal43_50.convertDecimal(src.getScoreElement()));
    if (src.hasTester())
      tgt.setTesterElement(String43_50.convertString(src.getTesterElement()));
    if (src.hasIssued())
      tgt.setIssuedElement(DateTime43_50.convertDateTime(src.getIssuedElement()));
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

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestReport.TestReportStatus> convertTestReportStatus(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.TestReport.TestReportStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestReport.TestReportStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.TestReport.TestReportStatusEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
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

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.TestReport.TestReportStatus> convertTestReportStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestReport.TestReportStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.TestReport.TestReportStatus> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.TestReport.TestReportStatusEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case COMPLETED:
        tgt.setValue(org.hl7.fhir.r4b.model.TestReport.TestReportStatus.COMPLETED);
        break;
      case INPROGRESS:
        tgt.setValue(org.hl7.fhir.r4b.model.TestReport.TestReportStatus.INPROGRESS);
        break;
      case WAITING:
        tgt.setValue(org.hl7.fhir.r4b.model.TestReport.TestReportStatus.WAITING);
        break;
      case STOPPED:
        tgt.setValue(org.hl7.fhir.r4b.model.TestReport.TestReportStatus.STOPPED);
        break;
      case ENTEREDINERROR:
        tgt.setValue(org.hl7.fhir.r4b.model.TestReport.TestReportStatus.ENTEREDINERROR);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.TestReport.TestReportStatus.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestReport.TestReportResult> convertTestReportResult(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.TestReport.TestReportResult> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestReport.TestReportResult> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.TestReport.TestReportResultEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
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

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.TestReport.TestReportResult> convertTestReportResult(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestReport.TestReportResult> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.TestReport.TestReportResult> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.TestReport.TestReportResultEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case PASS:
        tgt.setValue(org.hl7.fhir.r4b.model.TestReport.TestReportResult.PASS);
        break;
      case FAIL:
        tgt.setValue(org.hl7.fhir.r4b.model.TestReport.TestReportResult.FAIL);
        break;
      case PENDING:
        tgt.setValue(org.hl7.fhir.r4b.model.TestReport.TestReportResult.PENDING);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.TestReport.TestReportResult.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestReport.TestReportParticipantComponent convertTestReportParticipantComponent(org.hl7.fhir.r4b.model.TestReport.TestReportParticipantComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestReport.TestReportParticipantComponent tgt = new org.hl7.fhir.r5.model.TestReport.TestReportParticipantComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setTypeElement(convertTestReportParticipantType(src.getTypeElement()));
    if (src.hasUri())
      tgt.setUriElement(Uri43_50.convertUri(src.getUriElement()));
    if (src.hasDisplay())
      tgt.setDisplayElement(String43_50.convertString(src.getDisplayElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.TestReport.TestReportParticipantComponent convertTestReportParticipantComponent(org.hl7.fhir.r5.model.TestReport.TestReportParticipantComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.TestReport.TestReportParticipantComponent tgt = new org.hl7.fhir.r4b.model.TestReport.TestReportParticipantComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setTypeElement(convertTestReportParticipantType(src.getTypeElement()));
    if (src.hasUri())
      tgt.setUriElement(Uri43_50.convertUri(src.getUriElement()));
    if (src.hasDisplay())
      tgt.setDisplayElement(String43_50.convertString(src.getDisplayElement()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestReport.TestReportParticipantType> convertTestReportParticipantType(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.TestReport.TestReportParticipantType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestReport.TestReportParticipantType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.TestReport.TestReportParticipantTypeEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
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

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.TestReport.TestReportParticipantType> convertTestReportParticipantType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestReport.TestReportParticipantType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.TestReport.TestReportParticipantType> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.TestReport.TestReportParticipantTypeEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case TESTENGINE:
        tgt.setValue(org.hl7.fhir.r4b.model.TestReport.TestReportParticipantType.TESTENGINE);
        break;
      case CLIENT:
        tgt.setValue(org.hl7.fhir.r4b.model.TestReport.TestReportParticipantType.CLIENT);
        break;
      case SERVER:
        tgt.setValue(org.hl7.fhir.r4b.model.TestReport.TestReportParticipantType.SERVER);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.TestReport.TestReportParticipantType.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestReport.TestReportSetupComponent convertTestReportSetupComponent(org.hl7.fhir.r4b.model.TestReport.TestReportSetupComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestReport.TestReportSetupComponent tgt = new org.hl7.fhir.r5.model.TestReport.TestReportSetupComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r4b.model.TestReport.SetupActionComponent t : src.getAction())
      tgt.addAction(convertSetupActionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.TestReport.TestReportSetupComponent convertTestReportSetupComponent(org.hl7.fhir.r5.model.TestReport.TestReportSetupComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.TestReport.TestReportSetupComponent tgt = new org.hl7.fhir.r4b.model.TestReport.TestReportSetupComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r5.model.TestReport.SetupActionComponent t : src.getAction())
      tgt.addAction(convertSetupActionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestReport.SetupActionComponent convertSetupActionComponent(org.hl7.fhir.r4b.model.TestReport.SetupActionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestReport.SetupActionComponent tgt = new org.hl7.fhir.r5.model.TestReport.SetupActionComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasOperation())
      tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    if (src.hasAssert())
      tgt.setAssert(convertSetupActionAssertComponent(src.getAssert()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.TestReport.SetupActionComponent convertSetupActionComponent(org.hl7.fhir.r5.model.TestReport.SetupActionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.TestReport.SetupActionComponent tgt = new org.hl7.fhir.r4b.model.TestReport.SetupActionComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasOperation())
      tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    if (src.hasAssert())
      tgt.setAssert(convertSetupActionAssertComponent(src.getAssert()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestReport.SetupActionOperationComponent convertSetupActionOperationComponent(org.hl7.fhir.r4b.model.TestReport.SetupActionOperationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestReport.SetupActionOperationComponent tgt = new org.hl7.fhir.r5.model.TestReport.SetupActionOperationComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasResult())
      tgt.setResultElement(convertTestReportActionResult(src.getResultElement()));
    if (src.hasMessage())
      tgt.setMessageElement(MarkDown43_50.convertMarkdown(src.getMessageElement()));
    if (src.hasDetail())
      tgt.setDetailElement(Uri43_50.convertUri(src.getDetailElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.TestReport.SetupActionOperationComponent convertSetupActionOperationComponent(org.hl7.fhir.r5.model.TestReport.SetupActionOperationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.TestReport.SetupActionOperationComponent tgt = new org.hl7.fhir.r4b.model.TestReport.SetupActionOperationComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasResult())
      tgt.setResultElement(convertTestReportActionResult(src.getResultElement()));
    if (src.hasMessage())
      tgt.setMessageElement(MarkDown43_50.convertMarkdown(src.getMessageElement()));
    if (src.hasDetail())
      tgt.setDetailElement(Uri43_50.convertUri(src.getDetailElement()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestReport.TestReportActionResult> convertTestReportActionResult(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.TestReport.TestReportActionResult> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestReport.TestReportActionResult> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.TestReport.TestReportActionResultEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
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

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.TestReport.TestReportActionResult> convertTestReportActionResult(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestReport.TestReportActionResult> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.TestReport.TestReportActionResult> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.TestReport.TestReportActionResultEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case PASS:
        tgt.setValue(org.hl7.fhir.r4b.model.TestReport.TestReportActionResult.PASS);
        break;
      case SKIP:
        tgt.setValue(org.hl7.fhir.r4b.model.TestReport.TestReportActionResult.SKIP);
        break;
      case FAIL:
        tgt.setValue(org.hl7.fhir.r4b.model.TestReport.TestReportActionResult.FAIL);
        break;
      case WARNING:
        tgt.setValue(org.hl7.fhir.r4b.model.TestReport.TestReportActionResult.WARNING);
        break;
      case ERROR:
        tgt.setValue(org.hl7.fhir.r4b.model.TestReport.TestReportActionResult.ERROR);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.TestReport.TestReportActionResult.NULL);
        break;
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestReport.SetupActionAssertComponent convertSetupActionAssertComponent(org.hl7.fhir.r4b.model.TestReport.SetupActionAssertComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestReport.SetupActionAssertComponent tgt = new org.hl7.fhir.r5.model.TestReport.SetupActionAssertComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasResult())
      tgt.setResultElement(convertTestReportActionResult(src.getResultElement()));
    if (src.hasMessage())
      tgt.setMessageElement(MarkDown43_50.convertMarkdown(src.getMessageElement()));
    if (src.hasDetail())
      tgt.setDetailElement(String43_50.convertString(src.getDetailElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.TestReport.SetupActionAssertComponent convertSetupActionAssertComponent(org.hl7.fhir.r5.model.TestReport.SetupActionAssertComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.TestReport.SetupActionAssertComponent tgt = new org.hl7.fhir.r4b.model.TestReport.SetupActionAssertComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasResult())
      tgt.setResultElement(convertTestReportActionResult(src.getResultElement()));
    if (src.hasMessage())
      tgt.setMessageElement(MarkDown43_50.convertMarkdown(src.getMessageElement()));
    if (src.hasDetail())
      tgt.setDetailElement(String43_50.convertString(src.getDetailElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestReport.TestReportTestComponent convertTestReportTestComponent(org.hl7.fhir.r4b.model.TestReport.TestReportTestComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestReport.TestReportTestComponent tgt = new org.hl7.fhir.r5.model.TestReport.TestReportTestComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String43_50.convertString(src.getNameElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_50.convertString(src.getDescriptionElement()));
    for (org.hl7.fhir.r4b.model.TestReport.TestActionComponent t : src.getAction())
      tgt.addAction(convertTestActionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.TestReport.TestReportTestComponent convertTestReportTestComponent(org.hl7.fhir.r5.model.TestReport.TestReportTestComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.TestReport.TestReportTestComponent tgt = new org.hl7.fhir.r4b.model.TestReport.TestReportTestComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String43_50.convertString(src.getNameElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_50.convertString(src.getDescriptionElement()));
    for (org.hl7.fhir.r5.model.TestReport.TestActionComponent t : src.getAction())
      tgt.addAction(convertTestActionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestReport.TestActionComponent convertTestActionComponent(org.hl7.fhir.r4b.model.TestReport.TestActionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestReport.TestActionComponent tgt = new org.hl7.fhir.r5.model.TestReport.TestActionComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasOperation())
      tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    if (src.hasAssert())
      tgt.setAssert(convertSetupActionAssertComponent(src.getAssert()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.TestReport.TestActionComponent convertTestActionComponent(org.hl7.fhir.r5.model.TestReport.TestActionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.TestReport.TestActionComponent tgt = new org.hl7.fhir.r4b.model.TestReport.TestActionComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasOperation())
      tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    if (src.hasAssert())
      tgt.setAssert(convertSetupActionAssertComponent(src.getAssert()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestReport.TestReportTeardownComponent convertTestReportTeardownComponent(org.hl7.fhir.r4b.model.TestReport.TestReportTeardownComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestReport.TestReportTeardownComponent tgt = new org.hl7.fhir.r5.model.TestReport.TestReportTeardownComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r4b.model.TestReport.TeardownActionComponent t : src.getAction())
      tgt.addAction(convertTeardownActionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.TestReport.TestReportTeardownComponent convertTestReportTeardownComponent(org.hl7.fhir.r5.model.TestReport.TestReportTeardownComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.TestReport.TestReportTeardownComponent tgt = new org.hl7.fhir.r4b.model.TestReport.TestReportTeardownComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r5.model.TestReport.TeardownActionComponent t : src.getAction())
      tgt.addAction(convertTeardownActionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestReport.TeardownActionComponent convertTeardownActionComponent(org.hl7.fhir.r4b.model.TestReport.TeardownActionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestReport.TeardownActionComponent tgt = new org.hl7.fhir.r5.model.TestReport.TeardownActionComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasOperation())
      tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.TestReport.TeardownActionComponent convertTeardownActionComponent(org.hl7.fhir.r5.model.TestReport.TeardownActionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.TestReport.TeardownActionComponent tgt = new org.hl7.fhir.r4b.model.TestReport.TeardownActionComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasOperation())
      tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    return tgt;
  }
}