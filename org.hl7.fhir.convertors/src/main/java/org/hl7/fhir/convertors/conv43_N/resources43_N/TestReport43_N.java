package org.hl7.fhir.convertors.conv43_N.resources43_N;

import org.hl7.fhir.convertors.context.ConversionContext43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.general43_N.Identifier43_N;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.primitive43_N.*;
import org.hl7.fhir.convertors.conv43_N.datatypes43_N.special43_N.Reference43_N;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.Enumeration;
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
public class TestReport43_N {

  public static org.hl7.fhir.model.testing.TestReport convertTestReport(org.hl7.fhir.r4b.model.TestReport src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.testing.TestReport tgt = new org.hl7.fhir.model.testing.TestReport();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier43_N.convertIdentifier(src.getIdentifier()));
    if (src.hasName())
      tgt.setNameElement(String43_N.convertString(src.getNameElement()));
    if (src.hasStatus())
      tgt.setStatusElement(convertTestReportStatus(src.getStatusElement()));
    if (src.hasTestScript())
      tgt.setTestScript(src.getTestScript().getReference());
    if (src.hasResult())
      tgt.setResultElement(convertTestReportResult(src.getResultElement()));
    if (src.hasScore())
      tgt.setScoreElement(Decimal43_N.convertDecimal(src.getScoreElement()));
    if (src.hasTester())
      tgt.setTesterElement(String43_N.convertString(src.getTesterElement()));
    if (src.hasIssued())
      tgt.setIssuedElement(DateTime43_N.convertDateTime(src.getIssuedElement()));
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

  public static org.hl7.fhir.r4b.model.TestReport convertTestReport(org.hl7.fhir.model.testing.TestReport src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.TestReport tgt = new org.hl7.fhir.r4b.model.TestReport();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyDomainResource(src, tgt);
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier43_N.convertIdentifier(src.getIdentifier()));
    if (src.hasName())
      tgt.setNameElement(String43_N.convertString(src.getNameElement()));
    if (src.hasStatus())
      tgt.setStatusElement(convertTestReportStatus(src.getStatusElement()));
    if (src.hasTestScript())
      tgt.setTestScript(Reference43_N.convertCanonicalToReference(src.getTestScriptElement()));
    if (src.hasResult())
      tgt.setResultElement(convertTestReportResult(src.getResultElement()));
    if (src.hasScore())
      tgt.setScoreElement(Decimal43_N.convertDecimal(src.getScoreElement()));
    if (src.hasTester())
      tgt.setTesterElement(String43_N.convertString(src.getTesterElement()));
    if (src.hasIssued())
      tgt.setIssuedElement(DateTime43_N.convertDateTime(src.getIssuedElement()));
    for (org.hl7.fhir.model.testing.TestReport.TestReportParticipantComponent t : src.getParticipantList())
      tgt.addParticipant(convertTestReportParticipantComponent(t));
    if (src.hasSetup())
      tgt.setSetup(convertTestReportSetupComponent(src.getSetup()));
    for (org.hl7.fhir.model.testing.TestReport.TestReportTestComponent t : src.getTestList())
      tgt.addTest(convertTestReportTestComponent(t));
    if (src.hasTeardown())
      tgt.setTeardown(convertTestReportTeardownComponent(src.getTeardown()));
    return tgt;
  }

  static public Enumeration<org.hl7.fhir.model.testing.TestReport.TestReportStatusValueSet> convertTestReportStatus(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.TestReport.TestReportStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<org.hl7.fhir.model.testing.TestReport.TestReportStatusValueSet> tgt = new Enumeration<>(new org.hl7.fhir.model.testing.TestReport.TestReportStatusValueSetEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case COMPLETED:
                  tgt.setValue(org.hl7.fhir.model.testing.TestReport.TestReportStatusValueSet.COMPLETED);
                  break;
              case INPROGRESS:
                  tgt.setValue(org.hl7.fhir.model.testing.TestReport.TestReportStatusValueSet.INPROGRESS);
                  break;
              case WAITING:
                  tgt.setValue(org.hl7.fhir.model.testing.TestReport.TestReportStatusValueSet.WAITING);
                  break;
              case STOPPED:
                  tgt.setValue(org.hl7.fhir.model.testing.TestReport.TestReportStatusValueSet.STOPPED);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(org.hl7.fhir.model.testing.TestReport.TestReportStatusValueSet.ENTEREDINERROR);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.model.testing.TestReport.TestReportStatusValueSet.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.TestReport.TestReportStatus> convertTestReportStatus(Enumeration<org.hl7.fhir.model.testing.TestReport.TestReportStatusValueSet> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.TestReport.TestReportStatus> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.TestReport.TestReportStatusEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
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
      }
      return tgt;
  }

  static public Enumeration<org.hl7.fhir.model.testing.TestReport.TestReportResultValueSet> convertTestReportResult(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.TestReport.TestReportResult> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<org.hl7.fhir.model.testing.TestReport.TestReportResultValueSet> tgt = new Enumeration<>(new org.hl7.fhir.model.testing.TestReport.TestReportResultValueSetEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case PASS:
                  tgt.setValue(org.hl7.fhir.model.testing.TestReport.TestReportResultValueSet.PASS);
                  break;
              case FAIL:
                  tgt.setValue(org.hl7.fhir.model.testing.TestReport.TestReportResultValueSet.FAIL);
                  break;
              case PENDING:
                  tgt.setValue(org.hl7.fhir.model.testing.TestReport.TestReportResultValueSet.PENDING);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.model.testing.TestReport.TestReportResultValueSet.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.TestReport.TestReportResult> convertTestReportResult(Enumeration<org.hl7.fhir.model.testing.TestReport.TestReportResultValueSet> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.TestReport.TestReportResult> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.TestReport.TestReportResultEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
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
      }
      return tgt;
  }

  public static org.hl7.fhir.model.testing.TestReport.TestReportParticipantComponent convertTestReportParticipantComponent(org.hl7.fhir.r4b.model.TestReport.TestReportParticipantComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.testing.TestReport.TestReportParticipantComponent tgt = new org.hl7.fhir.model.testing.TestReport.TestReportParticipantComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setTypeElement(convertTestReportParticipantType(src.getTypeElement()));
    if (src.hasUri())
      tgt.setUriElement(Uri43_N.convertUri(src.getUriElement()));
    if (src.hasDisplay())
      tgt.setDisplayElement(String43_N.convertString(src.getDisplayElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.TestReport.TestReportParticipantComponent convertTestReportParticipantComponent(org.hl7.fhir.model.testing.TestReport.TestReportParticipantComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.TestReport.TestReportParticipantComponent tgt = new org.hl7.fhir.r4b.model.TestReport.TestReportParticipantComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setTypeElement(convertTestReportParticipantType(src.getTypeElement()));
    if (src.hasUri())
      tgt.setUriElement(Uri43_N.convertUri(src.getUriElement()));
    if (src.hasDisplay())
      tgt.setDisplayElement(String43_N.convertString(src.getDisplayElement()));
    return tgt;
  }

  static public Enumeration<org.hl7.fhir.model.testing.TestReport.TestReportParticipantTypeValueSet> convertTestReportParticipantType(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.TestReport.TestReportParticipantType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<org.hl7.fhir.model.testing.TestReport.TestReportParticipantTypeValueSet> tgt = new Enumeration<>(new org.hl7.fhir.model.testing.TestReport.TestReportParticipantTypeValueSetEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case TESTENGINE:
                  tgt.setValue(org.hl7.fhir.model.testing.TestReport.TestReportParticipantTypeValueSet.TESTENGINE);
                  break;
              case CLIENT:
                  tgt.setValue(org.hl7.fhir.model.testing.TestReport.TestReportParticipantTypeValueSet.CLIENT);
                  break;
              case SERVER:
                  tgt.setValue(org.hl7.fhir.model.testing.TestReport.TestReportParticipantTypeValueSet.SERVER);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.model.testing.TestReport.TestReportParticipantTypeValueSet.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.TestReport.TestReportParticipantType> convertTestReportParticipantType(Enumeration<org.hl7.fhir.model.testing.TestReport.TestReportParticipantTypeValueSet> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.TestReport.TestReportParticipantType> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.TestReport.TestReportParticipantTypeEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
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
      }
      return tgt;
  }

  public static org.hl7.fhir.model.testing.TestReport.TestReportSetupComponent convertTestReportSetupComponent(org.hl7.fhir.r4b.model.TestReport.TestReportSetupComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.testing.TestReport.TestReportSetupComponent tgt = new org.hl7.fhir.model.testing.TestReport.TestReportSetupComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r4b.model.TestReport.SetupActionComponent t : src.getAction())
      tgt.addAction(convertSetupActionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.TestReport.TestReportSetupComponent convertTestReportSetupComponent(org.hl7.fhir.model.testing.TestReport.TestReportSetupComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.TestReport.TestReportSetupComponent tgt = new org.hl7.fhir.r4b.model.TestReport.TestReportSetupComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.model.testing.TestReport.SetupActionComponent t : src.getActionList())
      tgt.addAction(convertSetupActionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.model.testing.TestReport.SetupActionComponent convertSetupActionComponent(org.hl7.fhir.r4b.model.TestReport.SetupActionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.testing.TestReport.SetupActionComponent tgt = new org.hl7.fhir.model.testing.TestReport.SetupActionComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasOperation())
      tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    if (src.hasAssert())
      tgt.setAssert(convertSetupActionAssertComponent(src.getAssert()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.TestReport.SetupActionComponent convertSetupActionComponent(org.hl7.fhir.model.testing.TestReport.SetupActionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.TestReport.SetupActionComponent tgt = new org.hl7.fhir.r4b.model.TestReport.SetupActionComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasOperation())
      tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    if (src.hasAssert())
      tgt.setAssert(convertSetupActionAssertComponent(src.getAssert()));
    return tgt;
  }

  public static org.hl7.fhir.model.testing.TestReport.SetupActionOperationComponent convertSetupActionOperationComponent(org.hl7.fhir.r4b.model.TestReport.SetupActionOperationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.testing.TestReport.SetupActionOperationComponent tgt = new org.hl7.fhir.model.testing.TestReport.SetupActionOperationComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasResult())
      tgt.setResultElement(convertTestReportActionResult(src.getResultElement()));
    if (src.hasMessage())
      tgt.setMessageElement(MarkDown43_N.convertMarkdown(src.getMessageElement()));
    if (src.hasDetail())
      tgt.setDetailElement(Uri43_N.convertUri(src.getDetailElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.TestReport.SetupActionOperationComponent convertSetupActionOperationComponent(org.hl7.fhir.model.testing.TestReport.SetupActionOperationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.TestReport.SetupActionOperationComponent tgt = new org.hl7.fhir.r4b.model.TestReport.SetupActionOperationComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasResult())
      tgt.setResultElement(convertTestReportActionResult(src.getResultElement()));
    if (src.hasMessage())
      tgt.setMessageElement(MarkDown43_N.convertMarkdown(src.getMessageElement()));
    if (src.hasDetail())
      tgt.setDetailElement(Uri43_N.convertUri(src.getDetailElement()));
    return tgt;
  }

  static public Enumeration<org.hl7.fhir.model.testing.TestReport.TestReportActionResultValueSet> convertTestReportActionResult(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.TestReport.TestReportActionResult> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<org.hl7.fhir.model.testing.TestReport.TestReportActionResultValueSet> tgt = new Enumeration<>(new org.hl7.fhir.model.testing.TestReport.TestReportActionResultValueSetEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case PASS:
                  tgt.setValue(org.hl7.fhir.model.testing.TestReport.TestReportActionResultValueSet.PASS);
                  break;
              case SKIP:
                  tgt.setValue(org.hl7.fhir.model.testing.TestReport.TestReportActionResultValueSet.SKIP);
                  break;
              case FAIL:
                  tgt.setValue(org.hl7.fhir.model.testing.TestReport.TestReportActionResultValueSet.FAIL);
                  break;
              case WARNING:
                  tgt.setValue(org.hl7.fhir.model.testing.TestReport.TestReportActionResultValueSet.WARNING);
                  break;
              case ERROR:
                  tgt.setValue(org.hl7.fhir.model.testing.TestReport.TestReportActionResultValueSet.ERROR);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.model.testing.TestReport.TestReportActionResultValueSet.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.TestReport.TestReportActionResult> convertTestReportActionResult(Enumeration<org.hl7.fhir.model.testing.TestReport.TestReportActionResultValueSet> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.TestReport.TestReportActionResult> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.TestReport.TestReportActionResultEnumFactory());
      ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
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
      }
      return tgt;
  }

  public static org.hl7.fhir.model.testing.TestReport.SetupActionAssertComponent convertSetupActionAssertComponent(org.hl7.fhir.r4b.model.TestReport.SetupActionAssertComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.testing.TestReport.SetupActionAssertComponent tgt = new org.hl7.fhir.model.testing.TestReport.SetupActionAssertComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasResult())
      tgt.setResultElement(convertTestReportActionResult(src.getResultElement()));
    if (src.hasMessage())
      tgt.setMessageElement(MarkDown43_N.convertMarkdown(src.getMessageElement()));
    if (src.hasDetail())
      tgt.setDetailElement(String43_N.convertString(src.getDetailElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.TestReport.SetupActionAssertComponent convertSetupActionAssertComponent(org.hl7.fhir.model.testing.TestReport.SetupActionAssertComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.TestReport.SetupActionAssertComponent tgt = new org.hl7.fhir.r4b.model.TestReport.SetupActionAssertComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasResult())
      tgt.setResultElement(convertTestReportActionResult(src.getResultElement()));
    if (src.hasMessage())
      tgt.setMessageElement(MarkDown43_N.convertMarkdown(src.getMessageElement()));
    if (src.hasDetail())
      tgt.setDetailElement(String43_N.convertString(src.getDetailElement()));
    return tgt;
  }

  public static org.hl7.fhir.model.testing.TestReport.TestReportTestComponent convertTestReportTestComponent(org.hl7.fhir.r4b.model.TestReport.TestReportTestComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.testing.TestReport.TestReportTestComponent tgt = new org.hl7.fhir.model.testing.TestReport.TestReportTestComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String43_N.convertString(src.getNameElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_N.convertString(src.getDescriptionElement()));
    for (org.hl7.fhir.r4b.model.TestReport.TestActionComponent t : src.getAction())
      tgt.addAction(convertTestActionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.TestReport.TestReportTestComponent convertTestReportTestComponent(org.hl7.fhir.model.testing.TestReport.TestReportTestComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.TestReport.TestReportTestComponent tgt = new org.hl7.fhir.r4b.model.TestReport.TestReportTestComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String43_N.convertString(src.getNameElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String43_N.convertString(src.getDescriptionElement()));
    for (org.hl7.fhir.model.testing.TestReport.TestActionComponent t : src.getActionList())
      tgt.addAction(convertTestActionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.model.testing.TestReport.TestActionComponent convertTestActionComponent(org.hl7.fhir.r4b.model.TestReport.TestActionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.testing.TestReport.TestActionComponent tgt = new org.hl7.fhir.model.testing.TestReport.TestActionComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasOperation())
      tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    if (src.hasAssert())
      tgt.setAssert(convertSetupActionAssertComponent(src.getAssert()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.TestReport.TestActionComponent convertTestActionComponent(org.hl7.fhir.model.testing.TestReport.TestActionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.TestReport.TestActionComponent tgt = new org.hl7.fhir.r4b.model.TestReport.TestActionComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasOperation())
      tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    if (src.hasAssert())
      tgt.setAssert(convertSetupActionAssertComponent(src.getAssert()));
    return tgt;
  }

  public static org.hl7.fhir.model.testing.TestReport.TestReportTeardownComponent convertTestReportTeardownComponent(org.hl7.fhir.r4b.model.TestReport.TestReportTeardownComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.testing.TestReport.TestReportTeardownComponent tgt = new org.hl7.fhir.model.testing.TestReport.TestReportTeardownComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r4b.model.TestReport.TeardownActionComponent t : src.getAction())
      tgt.addAction(convertTeardownActionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.TestReport.TestReportTeardownComponent convertTestReportTeardownComponent(org.hl7.fhir.model.testing.TestReport.TestReportTeardownComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.TestReport.TestReportTeardownComponent tgt = new org.hl7.fhir.r4b.model.TestReport.TestReportTeardownComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.model.testing.TestReport.TeardownActionComponent t : src.getActionList())
      tgt.addAction(convertTeardownActionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.model.testing.TestReport.TeardownActionComponent convertTeardownActionComponent(org.hl7.fhir.r4b.model.TestReport.TeardownActionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.model.testing.TestReport.TeardownActionComponent tgt = new org.hl7.fhir.model.testing.TestReport.TeardownActionComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasOperation())
      tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.TestReport.TeardownActionComponent convertTeardownActionComponent(org.hl7.fhir.model.testing.TestReport.TeardownActionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.TestReport.TeardownActionComponent tgt = new org.hl7.fhir.r4b.model.TestReport.TeardownActionComponent();
    ConversionContext43_N.INSTANCE.getVersionConvertor_43_N().copyBackboneElement(src, tgt);
    if (src.hasOperation())
      tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    return tgt;
  }
}