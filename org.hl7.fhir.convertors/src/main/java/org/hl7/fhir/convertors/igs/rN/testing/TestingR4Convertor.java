package org.hl7.fhir.convertors.igs.rN.testing;

import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_40_N;
import org.hl7.fhir.convertors.context.ConversionContext40_N;
import org.hl7.fhir.convertors.conv40_N.VersionConvertor_40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.CodeableConcept40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Coding40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.general40_N.Identifier40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.metadata40_N.ContactDetail40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.metadata40_N.Expression40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.metadata40_N.UsageContext40_N;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.primitive40_N.*;
import org.hl7.fhir.convertors.conv40_N.datatypes40_N.special40_N.Reference40_N;
import org.hl7.fhir.convertors.conv40_N.resources40_N.Enumerations40_N;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_40_N;
import org.hl7.fhir.convertors.igs.VersionConvertorIGBase;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.testing.TestPlan;
import org.hl7.fhir.r4.model.Reference;
import org.hl7.fhir.model.testing.TestReport;
import org.hl7.fhir.model.testing.TestScript;
import org.hl7.fhir.model.testing.TestScript.TestScriptScopeComponent;
import org.hl7.fhir.model.core.CanonicalType;
import org.hl7.fhir.model.core.Enumeration;
import org.hl7.fhir.model.core.Resource;

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
// Hand-maintained R4 <-> testing-IG (R6) converter for TestReport (and TestScript).
// Adapted from org.hl7.fhir.convertors...TestReport40_N, retargeted to org.hl7.fhir.model.testing.
// R6-only elements (TestReport: documentation, log, parameter, period, presentedForm, version;
// assert.requirement) have no R4 representation and are dropped when converting to R4.
public class TestingR4Convertor extends VersionConvertorIGBase {

  @Override
  public boolean handlesRNToR4(String s) {
    switch (s) {
      case "TestReport":
      case "TestPlan":
      case "TestScript":
        return true;
      default:
        return false;
    }
  }

  @Override
  public org.hl7.fhir.r4.model.Resource convertRNToR4(Resource source) {
    VersionConvertor_40_N vc = new VersionConvertor_40_N(new BaseAdvisor_40_N());
    ConversionContext40_N.INSTANCE.init(vc);
    try {
      switch (source.fhirType() ) {
        case "TestReport":
          return convertTestReport((TestReport) source);
        case "TestPlan":
          return convertTestPlan((TestPlan) source);
        case "TestScript":
          return convertTestScript((TestScript) source);
        default:
          return null;
      }
    } finally {
      ConversionContext40_N.INSTANCE.close();
    }
  }

  public static TestReport convertTestReport(org.hl7.fhir.r4.model.TestReport src) throws FHIRException {
    if (src == null)
      return null;
    TestReport tgt = new TestReport();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt, EXT_TESTREPORT_DESCRIPTION);
    if (src.hasExtension(EXT_TESTREPORT_DESCRIPTION)) {
      // TestReport.description (top-level) is R6-only; recover it from the cross-version extension
      tgt.setDescriptionElement(MarkDown40_N.convertMarkdown((org.hl7.fhir.r4.model.MarkdownType) src.getExtensionByUrl(EXT_TESTREPORT_DESCRIPTION).getValue()));
    }
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier40_N.convertIdentifier(src.getIdentifier()));
    if (src.hasName())
      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    if (src.hasStatus())
      tgt.setStatusElement(convertTestReportStatus(src.getStatusElement()));
    if (src.hasTestScript())
      tgt.setTestScript(src.getTestScript().getReference());
    if (src.hasResult())
      tgt.setResultElement(convertTestReportResult(src.getResultElement()));
    if (src.hasScore())
      tgt.setScoreElement(Decimal40_N.convertDecimal(src.getScoreElement()));
    if (src.hasTester())
      tgt.setTesterElement(String40_N.convertString(src.getTesterElement()));
    if (src.hasIssued())
      tgt.setIssuedElement(DateTime40_N.convertDateTime(src.getIssuedElement()));
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

  public static org.hl7.fhir.r4.model.TestReport convertTestReport(TestReport src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.TestReport tgt = new org.hl7.fhir.r4.model.TestReport();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    if (src.hasDescription()) {
      // TestReport.description has no R4 home; carry it as a cross-version extension
      org.hl7.fhir.r4.model.Extension ext = tgt.addExtension();
      ext.setUrl(EXT_TESTREPORT_DESCRIPTION);
      ext.setValue(MarkDown40_N.convertMarkdown(src.getDescriptionElement()));
    }
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier40_N.convertIdentifier(src.getIdentifier()));
    if (src.hasName())
      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    if (src.hasStatus())
      tgt.setStatusElement(convertTestReportStatus(src.getStatusElement()));
    if (src.hasTestScript())
      tgt.setTestScript(new Reference().setReference(src.getTestScript()));
    if (src.hasResult())
      tgt.setResultElement(convertTestReportResult(src.getResultElement()));
    if (src.hasScore())
      tgt.setScoreElement(Decimal40_N.convertDecimal(src.getScoreElement()));
    if (src.hasTester())
      tgt.setTesterElement(String40_N.convertString(src.getTesterElement()));
    if (src.hasIssued())
      tgt.setIssuedElement(DateTime40_N.convertDateTime(src.getIssuedElement()));
    for (TestReport.TestReportParticipantComponent t : src.getParticipantList())
      tgt.addParticipant(convertTestReportParticipantComponent(t));
    if (src.hasSetup())
      tgt.setSetup(convertTestReportSetupComponent(src.getSetup()));
    for (TestReport.TestReportTestComponent t : src.getTestList())
      tgt.addTest(convertTestReportTestComponent(t));
    if (src.hasTeardown())
      tgt.setTeardown(convertTestReportTeardownComponent(src.getTeardown()));
    return tgt;
  }

  static public Enumeration<TestReport.TestReportStatusValueSet> convertTestReportStatus(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TestReport.TestReportStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<TestReport.TestReportStatusValueSet> tgt = new Enumeration<>(new TestReport.TestReportStatusValueSetEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case COMPLETED:
                  tgt.setValue(TestReport.TestReportStatusValueSet.COMPLETED);
                  break;
              case INPROGRESS:
                  tgt.setValue(TestReport.TestReportStatusValueSet.INPROGRESS);
                  break;
              case WAITING:
                  tgt.setValue(TestReport.TestReportStatusValueSet.WAITING);
                  break;
              case STOPPED:
                  tgt.setValue(TestReport.TestReportStatusValueSet.STOPPED);
                  break;
              case ENTEREDINERROR:
                  tgt.setValue(TestReport.TestReportStatusValueSet.ENTEREDINERROR);
                  break;
              default:
                  tgt.setValue(TestReport.TestReportStatusValueSet.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TestReport.TestReportStatus> convertTestReportStatus(Enumeration<TestReport.TestReportStatusValueSet> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TestReport.TestReportStatus> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.TestReport.TestReportStatusEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
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
      }
      return tgt;
  }

  static public Enumeration<TestReport.TestReportResultValueSet> convertTestReportResult(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TestReport.TestReportResult> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<TestReport.TestReportResultValueSet> tgt = new Enumeration<>(new TestReport.TestReportResultValueSetEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case PASS:
                  tgt.setValue(TestReport.TestReportResultValueSet.PASS);
                  break;
              case FAIL:
                  tgt.setValue(TestReport.TestReportResultValueSet.FAIL);
                  break;
              case PENDING:
                  tgt.setValue(TestReport.TestReportResultValueSet.PENDING);
                  break;
              default:
                  tgt.setValue(TestReport.TestReportResultValueSet.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TestReport.TestReportResult> convertTestReportResult(Enumeration<TestReport.TestReportResultValueSet> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TestReport.TestReportResult> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.TestReport.TestReportResultEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
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
      }
      return tgt;
  }

  public static TestReport.TestReportParticipantComponent convertTestReportParticipantComponent(org.hl7.fhir.r4.model.TestReport.TestReportParticipantComponent src) throws FHIRException {
    if (src == null)
      return null;
    TestReport.TestReportParticipantComponent tgt = new TestReport.TestReportParticipantComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setTypeElement(convertTestReportParticipantType(src.getTypeElement()));
    if (src.hasUri())
      tgt.setUriElement(Uri40_N.convertUri(src.getUriElement()));
    if (src.hasDisplay())
      tgt.setDisplayElement(String40_N.convertString(src.getDisplayElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.TestReport.TestReportParticipantComponent convertTestReportParticipantComponent(TestReport.TestReportParticipantComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.TestReport.TestReportParticipantComponent tgt = new org.hl7.fhir.r4.model.TestReport.TestReportParticipantComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setTypeElement(convertTestReportParticipantType(src.getTypeElement()));
    if (src.hasUri())
      tgt.setUriElement(Uri40_N.convertUri(src.getUriElement()));
    if (src.hasDisplay())
      tgt.setDisplayElement(String40_N.convertString(src.getDisplayElement()));
    return tgt;
  }

  static public Enumeration<TestReport.TestReportParticipantTypeValueSet> convertTestReportParticipantType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TestReport.TestReportParticipantType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<TestReport.TestReportParticipantTypeValueSet> tgt = new Enumeration<>(new TestReport.TestReportParticipantTypeValueSetEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case TESTENGINE:
                  tgt.setValue(TestReport.TestReportParticipantTypeValueSet.TESTENGINE);
                  break;
              case CLIENT:
                  tgt.setValue(TestReport.TestReportParticipantTypeValueSet.CLIENT);
                  break;
              case SERVER:
                  tgt.setValue(TestReport.TestReportParticipantTypeValueSet.SERVER);
                  break;
              default:
                  tgt.setValue(TestReport.TestReportParticipantTypeValueSet.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TestReport.TestReportParticipantType> convertTestReportParticipantType(Enumeration<TestReport.TestReportParticipantTypeValueSet> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TestReport.TestReportParticipantType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.TestReport.TestReportParticipantTypeEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
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
      }
      return tgt;
  }

  public static TestReport.TestReportSetupComponent convertTestReportSetupComponent(org.hl7.fhir.r4.model.TestReport.TestReportSetupComponent src) throws FHIRException {
    if (src == null)
      return null;
    TestReport.TestReportSetupComponent tgt = new TestReport.TestReportSetupComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r4.model.TestReport.SetupActionComponent t : src.getAction())
      tgt.addAction(convertSetupActionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.TestReport.TestReportSetupComponent convertTestReportSetupComponent(TestReport.TestReportSetupComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.TestReport.TestReportSetupComponent tgt = new org.hl7.fhir.r4.model.TestReport.TestReportSetupComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    for (TestReport.SetupActionComponent t : src.getActionList())
      tgt.addAction(convertSetupActionComponent(t));
    return tgt;
  }

  public static TestReport.SetupActionComponent convertSetupActionComponent(org.hl7.fhir.r4.model.TestReport.SetupActionComponent src) throws FHIRException {
    if (src == null)
      return null;
    TestReport.SetupActionComponent tgt = new TestReport.SetupActionComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasOperation())
      tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    if (src.hasAssert())
      tgt.setAssert(convertSetupActionAssertComponent(src.getAssert()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.TestReport.SetupActionComponent convertSetupActionComponent(TestReport.SetupActionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.TestReport.SetupActionComponent tgt = new org.hl7.fhir.r4.model.TestReport.SetupActionComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasOperation())
      tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    if (src.hasAssert())
      tgt.setAssert(convertSetupActionAssertComponent(src.getAssert()));
    return tgt;
  }

  public static TestReport.SetupActionOperationComponent convertSetupActionOperationComponent(org.hl7.fhir.r4.model.TestReport.SetupActionOperationComponent src) throws FHIRException {
    if (src == null)
      return null;
    TestReport.SetupActionOperationComponent tgt = new TestReport.SetupActionOperationComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasResult())
      tgt.setResultElement(convertTestReportActionResult(src.getResultElement()));
    if (src.hasMessage())
      tgt.setMessageElement(MarkDown40_N.convertMarkdown(src.getMessageElement()));
    if (src.hasDetail())
      tgt.setDetailElement(Uri40_N.convertUri(src.getDetailElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.TestReport.SetupActionOperationComponent convertSetupActionOperationComponent(TestReport.SetupActionOperationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.TestReport.SetupActionOperationComponent tgt = new org.hl7.fhir.r4.model.TestReport.SetupActionOperationComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasResult())
      tgt.setResultElement(convertTestReportActionResult(src.getResultElement()));
    if (src.hasMessage())
      tgt.setMessageElement(MarkDown40_N.convertMarkdown(src.getMessageElement()));
    if (src.hasDetail())
      tgt.setDetailElement(Uri40_N.convertUri(src.getDetailElement()));
    return tgt;
  }

  static public Enumeration<TestReport.TestReportActionResultValueSet> convertTestReportActionResult(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TestReport.TestReportActionResult> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<TestReport.TestReportActionResultValueSet> tgt = new Enumeration<>(new TestReport.TestReportActionResultValueSetEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case PASS:
                  tgt.setValue(TestReport.TestReportActionResultValueSet.PASS);
                  break;
              case SKIP:
                  tgt.setValue(TestReport.TestReportActionResultValueSet.SKIP);
                  break;
              case FAIL:
                  tgt.setValue(TestReport.TestReportActionResultValueSet.FAIL);
                  break;
              case WARNING:
                  tgt.setValue(TestReport.TestReportActionResultValueSet.WARNING);
                  break;
              case ERROR:
                  tgt.setValue(TestReport.TestReportActionResultValueSet.ERROR);
                  break;
              default:
                  tgt.setValue(TestReport.TestReportActionResultValueSet.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TestReport.TestReportActionResult> convertTestReportActionResult(Enumeration<TestReport.TestReportActionResultValueSet> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TestReport.TestReportActionResult> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.TestReport.TestReportActionResultEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
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
      }
      return tgt;
  }

  public static TestReport.SetupActionAssertComponent convertSetupActionAssertComponent(org.hl7.fhir.r4.model.TestReport.SetupActionAssertComponent src) throws FHIRException {
    if (src == null)
      return null;
    TestReport.SetupActionAssertComponent tgt = new TestReport.SetupActionAssertComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasResult())
      tgt.setResultElement(convertTestReportActionResult(src.getResultElement()));
    if (src.hasMessage())
      tgt.setMessageElement(MarkDown40_N.convertMarkdown(src.getMessageElement()));
    if (src.hasDetail())
      tgt.setDetailElement(String40_N.convertString(src.getDetailElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.TestReport.SetupActionAssertComponent convertSetupActionAssertComponent(TestReport.SetupActionAssertComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.TestReport.SetupActionAssertComponent tgt = new org.hl7.fhir.r4.model.TestReport.SetupActionAssertComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasResult())
      tgt.setResultElement(convertTestReportActionResult(src.getResultElement()));
    if (src.hasMessage())
      tgt.setMessageElement(MarkDown40_N.convertMarkdown(src.getMessageElement()));
    if (src.hasDetail())
      tgt.setDetailElement(String40_N.convertString(src.getDetailElement()));
    return tgt;
  }

  public static TestReport.TestReportTestComponent convertTestReportTestComponent(org.hl7.fhir.r4.model.TestReport.TestReportTestComponent src) throws FHIRException {
    if (src == null)
      return null;
    TestReport.TestReportTestComponent tgt = new TestReport.TestReportTestComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_N.convertString(src.getDescriptionElement()));
    for (org.hl7.fhir.r4.model.TestReport.TestActionComponent t : src.getAction())
      tgt.addAction(convertTestActionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.TestReport.TestReportTestComponent convertTestReportTestComponent(TestReport.TestReportTestComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.TestReport.TestReportTestComponent tgt = new org.hl7.fhir.r4.model.TestReport.TestReportTestComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_N.convertString(src.getDescriptionElement()));
    for (TestReport.TestActionComponent t : src.getActionList())
      tgt.addAction(convertTestActionComponent(t));
    return tgt;
  }

  public static TestReport.TestActionComponent convertTestActionComponent(org.hl7.fhir.r4.model.TestReport.TestActionComponent src) throws FHIRException {
    if (src == null)
      return null;
    TestReport.TestActionComponent tgt = new TestReport.TestActionComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasOperation())
      tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    if (src.hasAssert())
      tgt.setAssert(convertSetupActionAssertComponent(src.getAssert()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.TestReport.TestActionComponent convertTestActionComponent(TestReport.TestActionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.TestReport.TestActionComponent tgt = new org.hl7.fhir.r4.model.TestReport.TestActionComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasOperation())
      tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    if (src.hasAssert())
      tgt.setAssert(convertSetupActionAssertComponent(src.getAssert()));
    return tgt;
  }

  public static TestReport.TestReportTeardownComponent convertTestReportTeardownComponent(org.hl7.fhir.r4.model.TestReport.TestReportTeardownComponent src) throws FHIRException {
    if (src == null)
      return null;
    TestReport.TestReportTeardownComponent tgt = new TestReport.TestReportTeardownComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r4.model.TestReport.TeardownActionComponent t : src.getAction())
      tgt.addAction(convertTeardownActionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.TestReport.TestReportTeardownComponent convertTestReportTeardownComponent(TestReport.TestReportTeardownComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.TestReport.TestReportTeardownComponent tgt = new org.hl7.fhir.r4.model.TestReport.TestReportTeardownComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    for (TestReport.TeardownActionComponent t : src.getActionList())
      tgt.addAction(convertTeardownActionComponent(t));
    return tgt;
  }

  public static TestReport.TeardownActionComponent convertTeardownActionComponent(org.hl7.fhir.r4.model.TestReport.TeardownActionComponent src) throws FHIRException {
    if (src == null)
      return null;
    TestReport.TeardownActionComponent tgt = new TestReport.TeardownActionComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasOperation())
      tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.TestReport.TeardownActionComponent convertTeardownActionComponent(TestReport.TeardownActionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.TestReport.TeardownActionComponent tgt = new org.hl7.fhir.r4.model.TestReport.TeardownActionComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasOperation())
      tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    return tgt;
  }

  private static final String EXT_TESTREPORT_DESCRIPTION = "http://hl7.org/fhir/6.0/StructureDefinition/extension-TestReport.description";
  private static final String EXT_TS_STOP_ON_FAIL = "http://hl7.org/fhir/5.0/StructureDefinition/extension-TestScript.setup.action.assert.stopTestOnFail";
  private static final String EXT_TS_ORIGIN_PROFILE = "http://hl7.org/fhir/3.0/StructureDefinition/extension-TestScript.origin.profile";
  private static final String EXT_TS_TESTSYSTEM = "http://hl7.org/fhir/6.0/StructureDefinition/extension-TestScript.testSystem";
  private static final String EXT_TS_DEST_PROFILE = "http://hl7.org/fhir/3.0/StructureDefinition/extension-TestScript.destination.profile";


  public static TestScript convertTestScript(org.hl7.fhir.r4.model.TestScript src) throws FHIRException {
    if (src == null)
      return null;
    TestScript tgt = new TestScript();
    // the scope extension is turned into TestScript.scope below, so it isn't copied across as an extension
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt, EXT_TS_TESTSYSTEM, VersionConvertorConstants.EXT_TESTSCRIPT_SCOPE);
    for (org.hl7.fhir.r4.model.Extension ext : src.getExtensionsByUrl(VersionConvertorConstants.EXT_TESTSCRIPT_SCOPE)) {
      TestScriptScopeComponent scope = tgt.addScope();
      scope.setArtifact(ext.getExtensionString("artifact"));
      org.hl7.fhir.r4.model.Extension se = ext.getExtensionByUrl("conformance");
      if (se != null) {
        scope.setConformance(CodeableConcept40_N.convertCodeableConcept((org.hl7.fhir.r4.model.CodeableConcept) se.getValue()));
      }
      se = ext.getExtensionByUrl("phase");
      if (se != null) {
        scope.setPhase(CodeableConcept40_N.convertCodeableConcept((org.hl7.fhir.r4.model.CodeableConcept) se.getValue()));
      }
    }
    if (src.hasUrl())
      tgt.setUrlElement(Uri40_N.convertUri(src.getUrlElement()));
    if (src.hasIdentifier())
      tgt.addIdentifier(Identifier40_N.convertIdentifier(src.getIdentifier()));
    if (src.hasVersion())
      tgt.setVersionElement(String40_N.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String40_N.convertString(src.getTitleElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations40_N.convertPublicationStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean40_N.convertBoolean(src.getExperimentalElement()));
    if (src.hasDate())
      tgt.setDateElement(DateTime40_N.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String40_N.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.r4.model.ContactDetail t : src.getContact())
      tgt.addContact(ContactDetail40_N.convertContactDetail(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown40_N.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.r4.model.UsageContext t : src.getUseContext())
      tgt.addUseContext(UsageContext40_N.convertUsageContext(t));
    for (org.hl7.fhir.r4.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasPurpose())
      tgt.setPurposeElement(MarkDown40_N.convertMarkdown(src.getPurposeElement()));
    if (src.hasCopyright())
      tgt.setCopyrightElement(MarkDown40_N.convertMarkdown(src.getCopyrightElement()));
    for (org.hl7.fhir.r4.model.TestScript.TestScriptOriginComponent t : src.getOrigin())
      tgt.addTestSystem(convertOriginToTestSystem(t));
    for (org.hl7.fhir.r4.model.TestScript.TestScriptDestinationComponent t : src.getDestination())
      tgt.addTestSystem(convertDestinationToTestSystem(t));
    // testSystems that were neither origin nor destination were carried as cross-version extensions;
    // restore them after the origin/destination-derived testSystems
    for (org.hl7.fhir.r4.model.Extension tse : src.getExtensionsByUrl(EXT_TS_TESTSYSTEM))
      tgt.addTestSystem(convertExtensionToTestSystem(tse));
    if (src.hasMetadata())
      tgt.setMetadata(convertTestScriptMetadataComponent(src.getMetadata()));
    for (org.hl7.fhir.r4.model.TestScript.TestScriptFixtureComponent t : src.getFixture())
      tgt.addFixture(convertTestScriptFixtureComponent(t));
    for (Reference t : src.getProfile()) tgt.getProfileList().add(Reference40_N.convertReferenceToCanonical(t));
    for (org.hl7.fhir.r4.model.TestScript.TestScriptVariableComponent t : src.getVariable())
      tgt.addVariable(convertTestScriptVariableComponent(t));
    if (src.hasSetup())
      tgt.setSetup(convertTestScriptSetupComponent(src.getSetup()));
    for (org.hl7.fhir.r4.model.TestScript.TestScriptTestComponent t : src.getTest())
      tgt.addTest(convertTestScriptTestComponent(t));
    if (src.hasTeardown())
      tgt.setTeardown(convertTestScriptTeardownComponent(src.getTeardown()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.TestScript convertTestScript(TestScript src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.TestScript tgt = new org.hl7.fhir.r4.model.TestScript();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt, VersionConvertorConstants.EXT_TESTSCRIPT_SCOPE);
    if (src.hasUrl())
      tgt.setUrlElement(Uri40_N.convertUri(src.getUrlElement()));
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier40_N.convertIdentifier(src.getIdentifierFirstRep()));
    if (src.hasVersion())
      tgt.setVersionElement(String40_N.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(String40_N.convertString(src.getTitleElement()));
    if (src.hasStatus())
      tgt.setStatusElement(Enumerations40_N.convertPublicationStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(Boolean40_N.convertBoolean(src.getExperimentalElement()));
    if (src.hasDate())
      tgt.setDateElement(DateTime40_N.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(String40_N.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.model.core.ContactDetail t : src.getContactList())
      tgt.addContact(ContactDetail40_N.convertContactDetail(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(MarkDown40_N.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.model.core.UsageContext t : src.getUseContextList())
      tgt.addUseContext(UsageContext40_N.convertUsageContext(t));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getJurisdictionList())
      tgt.addJurisdiction(CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasPurpose())
      tgt.setPurposeElement(MarkDown40_N.convertMarkdown(src.getPurposeElement()));
    if (src.hasCopyright())
      tgt.setCopyrightElement(MarkDown40_N.convertMarkdown(src.getCopyrightElement()));
    for (TestScript.TestScriptTestSystemComponent t : src.getTestSystemList()) {
      if ("origin".equals(t.getTitle()))
        tgt.addOrigin(convertTestSystemToOrigin(t));
      else if ("destination".equals(t.getTitle()))
        tgt.addDestination(convertTestSystemToDestination(t));
      else
        // any other testSystem has no R4 origin/destination equivalent - carry it as a cross-version extension
        tgt.addExtension(convertTestSystemToExtension(t));
    }
    if (src.hasMetadata())
      tgt.setMetadata(convertTestScriptMetadataComponent(src.getMetadata()));
    for (TestScript.TestScriptFixtureComponent t : src.getFixtureList())
      tgt.addFixture(convertTestScriptFixtureComponent(t));
    for (CanonicalType t : src.getProfileList()) tgt.addProfile(Reference40_N.convertCanonicalToReference(t));
    for (TestScript.TestScriptVariableComponent t : src.getVariableList())
      tgt.addVariable(convertTestScriptVariableComponent(t));
    if (src.hasSetup())
      tgt.setSetup(convertTestScriptSetupComponent(src.getSetup()));
    for (TestScript.TestScriptTestComponent t : src.getTestList())
      tgt.addTest(convertTestScriptTestComponent(t));
    if (src.hasTeardown())
      tgt.setTeardown(convertTestScriptTeardownComponent(src.getTeardown()));
    for (TestScriptScopeComponent scope : src.getScopeList()) {
      org.hl7.fhir.r4.model.Extension ext = tgt.addExtension();
      ext.setUrl(VersionConvertorConstants.EXT_TESTSCRIPT_SCOPE);
      if (scope.hasArtifact()) {
        org.hl7.fhir.r4.model.Extension se = ext.addExtension();
        se.setUrl("artifact");
        se.setValue(Canonical40_N.convertCanonical(scope.getArtifactElement()));
      }
      if (scope.hasConformance()) {
        org.hl7.fhir.r4.model.Extension se = ext.addExtension();
        se.setUrl("conformance");
        se.setValue(CodeableConcept40_N.convertCodeableConcept(scope.getConformance()));
      }
      if (scope.hasPhase()) {
        org.hl7.fhir.r4.model.Extension se = ext.addExtension();
        se.setUrl("phase");
        se.setValue(CodeableConcept40_N.convertCodeableConcept(scope.getPhase()));
      }      
    }
    return tgt;
  }

  private static org.hl7.fhir.r4.model.Extension convertTestSystemToExtension(TestScript.TestScriptTestSystemComponent src) throws FHIRException {
    org.hl7.fhir.r4.model.Extension ext = new org.hl7.fhir.r4.model.Extension(EXT_TS_TESTSYSTEM);
    if (src.hasIndex())
      addTestSystemSubExtension(ext, "index", src.getIndexElement());
    if (src.hasTitle())
      addTestSystemSubExtension(ext, "title", src.getTitleElement());
    for (CanonicalType a : src.getActorList())
      addTestSystemSubExtension(ext, "actor", a);
    if (src.hasDescription())
      addTestSystemSubExtension(ext, "description", src.getDescriptionElement());
    if (src.hasUrl())
      addTestSystemSubExtension(ext, "url", src.getUrlElement());
    return ext;
  }

  private static void addTestSystemSubExtension(org.hl7.fhir.r4.model.Extension parent, String url, org.hl7.fhir.model.core.DataType value) throws FHIRException {
    org.hl7.fhir.r4.model.Extension se = parent.addExtension();
    se.setUrl(url);
    se.setValue(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(value));
  }

  private static TestScript.TestScriptTestSystemComponent convertExtensionToTestSystem(org.hl7.fhir.r4.model.Extension src) throws FHIRException {
    TestScript.TestScriptTestSystemComponent tgt = new TestScript.TestScriptTestSystemComponent();
    org.hl7.fhir.r4.model.Extension se = src.getExtensionByUrl("index");
    if (se != null)
      tgt.setIndexElement((org.hl7.fhir.model.core.PositiveIntType) ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(se.getValue()));
    se = src.getExtensionByUrl("title");
    if (se != null)
      tgt.setTitleElement((org.hl7.fhir.model.core.StringType) ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(se.getValue()));
    for (org.hl7.fhir.r4.model.Extension ae : src.getExtensionsByUrl("actor"))
      tgt.getActorList().add((CanonicalType) ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(ae.getValue()));
    se = src.getExtensionByUrl("description");
    if (se != null)
      tgt.setDescriptionElement((org.hl7.fhir.model.core.MarkdownType) ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(se.getValue()));
    se = src.getExtensionByUrl("url");
    if (se != null)
      tgt.setUrlElement((org.hl7.fhir.model.core.UrlType) ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(se.getValue()));
    return tgt;
  }

  private static TestScript.TestScriptTestSystemComponent convertOriginToTestSystem(org.hl7.fhir.r4.model.TestScript.TestScriptOriginComponent src) throws FHIRException {
    if (src == null)
      return null;
    TestScript.TestScriptTestSystemComponent tgt = new TestScript.TestScriptTestSystemComponent();
    if (src.hasIndex())
      tgt.setIndex(src.getIndex());
    tgt.setTitle("origin");
    if (src.hasProfile())
      tgt.addExtension(EXT_TS_ORIGIN_PROFILE, Coding40_N.convertCoding(src.getProfile()));
    return tgt;
  }

  private static TestScript.TestScriptTestSystemComponent convertDestinationToTestSystem(org.hl7.fhir.r4.model.TestScript.TestScriptDestinationComponent src) throws FHIRException {
    if (src == null)
      return null;
    TestScript.TestScriptTestSystemComponent tgt = new TestScript.TestScriptTestSystemComponent();
    if (src.hasIndex())
      tgt.setIndex(src.getIndex());
    tgt.setTitle("destination");
    if (src.hasProfile())
      tgt.addExtension(EXT_TS_DEST_PROFILE, Coding40_N.convertCoding(src.getProfile()));
    return tgt;
  }

  private static org.hl7.fhir.r4.model.TestScript.TestScriptOriginComponent convertTestSystemToOrigin(TestScript.TestScriptTestSystemComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.TestScript.TestScriptOriginComponent tgt = new org.hl7.fhir.r4.model.TestScript.TestScriptOriginComponent();
    if (src.hasIndex())
      tgt.setIndex(src.getIndex());
    if (src.hasExtension(EXT_TS_ORIGIN_PROFILE))
      tgt.setProfile(Coding40_N.convertCoding((org.hl7.fhir.model.core.Coding) src.getExtensionByUrl(EXT_TS_ORIGIN_PROFILE).getValue()));
    return tgt;
  }

  private static org.hl7.fhir.r4.model.TestScript.TestScriptDestinationComponent convertTestSystemToDestination(TestScript.TestScriptTestSystemComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.TestScript.TestScriptDestinationComponent tgt = new org.hl7.fhir.r4.model.TestScript.TestScriptDestinationComponent();
    if (src.hasIndex())
      tgt.setIndex(src.getIndex());
    if (src.hasExtension(EXT_TS_DEST_PROFILE))
      tgt.setProfile(Coding40_N.convertCoding((org.hl7.fhir.model.core.Coding) src.getExtensionByUrl(EXT_TS_DEST_PROFILE).getValue()));
    return tgt;
  }

  public static TestScript.TestScriptMetadataComponent convertTestScriptMetadataComponent(org.hl7.fhir.r4.model.TestScript.TestScriptMetadataComponent src) throws FHIRException {
    if (src == null)
      return null;
    TestScript.TestScriptMetadataComponent tgt = new TestScript.TestScriptMetadataComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r4.model.TestScript.TestScriptMetadataLinkComponent t : src.getLink())
      tgt.addLink(convertTestScriptMetadataLinkComponent(t));
    for (org.hl7.fhir.r4.model.TestScript.TestScriptMetadataCapabilityComponent t : src.getCapability())
      tgt.addCapability(convertTestScriptMetadataCapabilityComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.TestScript.TestScriptMetadataComponent convertTestScriptMetadataComponent(TestScript.TestScriptMetadataComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.TestScript.TestScriptMetadataComponent tgt = new org.hl7.fhir.r4.model.TestScript.TestScriptMetadataComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    for (TestScript.TestScriptMetadataLinkComponent t : src.getLinkList())
      tgt.addLink(convertTestScriptMetadataLinkComponent(t));
    for (TestScript.TestScriptMetadataCapabilityComponent t : src.getCapabilityList())
      tgt.addCapability(convertTestScriptMetadataCapabilityComponent(t));
    return tgt;
  }

  public static TestScript.TestScriptMetadataLinkComponent convertTestScriptMetadataLinkComponent(org.hl7.fhir.r4.model.TestScript.TestScriptMetadataLinkComponent src) throws FHIRException {
    if (src == null)
      return null;
    TestScript.TestScriptMetadataLinkComponent tgt = new TestScript.TestScriptMetadataLinkComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri40_N.convertUri(src.getUrlElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_N.convertString(src.getDescriptionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.TestScript.TestScriptMetadataLinkComponent convertTestScriptMetadataLinkComponent(TestScript.TestScriptMetadataLinkComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.TestScript.TestScriptMetadataLinkComponent tgt = new org.hl7.fhir.r4.model.TestScript.TestScriptMetadataLinkComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(Uri40_N.convertUri(src.getUrlElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_N.convertString(src.getDescriptionElement()));
    return tgt;
  }

  public static TestScript.TestScriptMetadataCapabilityComponent convertTestScriptMetadataCapabilityComponent(org.hl7.fhir.r4.model.TestScript.TestScriptMetadataCapabilityComponent src) throws FHIRException {
    if (src == null)
      return null;
    TestScript.TestScriptMetadataCapabilityComponent tgt = new TestScript.TestScriptMetadataCapabilityComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasRequired())
      tgt.setRequiredElement(Boolean40_N.convertBoolean(src.getRequiredElement()));
    if (src.hasValidated())
      tgt.setValidatedElement(Boolean40_N.convertBoolean(src.getValidatedElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_N.convertString(src.getDescriptionElement()));
    for (org.hl7.fhir.r4.model.IntegerType t : src.getOrigin()) tgt.getOriginList().add(Integer40_N.convertInteger(t));
    if (src.hasDestination())
      tgt.setDestinationElement(Integer40_N.convertInteger(src.getDestinationElement()));
    for (org.hl7.fhir.r4.model.UriType t : src.getLink()) tgt.getLinkList().add(Uri40_N.convertUri(t));
    if (src.hasCapabilities())
      tgt.setCapabilitiesElement(Canonical40_N.convertCanonical(src.getCapabilitiesElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.TestScript.TestScriptMetadataCapabilityComponent convertTestScriptMetadataCapabilityComponent(TestScript.TestScriptMetadataCapabilityComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.TestScript.TestScriptMetadataCapabilityComponent tgt = new org.hl7.fhir.r4.model.TestScript.TestScriptMetadataCapabilityComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasRequired())
      tgt.setRequiredElement(Boolean40_N.convertBoolean(src.getRequiredElement()));
    if (src.hasValidated())
      tgt.setValidatedElement(Boolean40_N.convertBoolean(src.getValidatedElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_N.convertString(src.getDescriptionElement()));
    for (org.hl7.fhir.model.core.IntegerType t : src.getOriginList()) tgt.getOrigin().add(Integer40_N.convertInteger(t));
    if (src.hasDestination())
      tgt.setDestinationElement(Integer40_N.convertInteger(src.getDestinationElement()));
    for (org.hl7.fhir.model.core.UriType t : src.getLinkList()) tgt.getLink().add(Uri40_N.convertUri(t));
    if (src.hasCapabilities())
      tgt.setCapabilitiesElement(Canonical40_N.convertCanonical(src.getCapabilitiesElement()));
    return tgt;
  }

  public static TestScript.TestScriptFixtureComponent convertTestScriptFixtureComponent(org.hl7.fhir.r4.model.TestScript.TestScriptFixtureComponent src) throws FHIRException {
    if (src == null)
      return null;
    TestScript.TestScriptFixtureComponent tgt = new TestScript.TestScriptFixtureComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasAutocreate())
      tgt.setAutocreateElement(Boolean40_N.convertBoolean(src.getAutocreateElement()));
    if (src.hasAutodelete())
      tgt.setAutodeleteElement(Boolean40_N.convertBoolean(src.getAutodeleteElement()));
    if (src.hasResource())
      tgt.setResource(Reference40_N.convertReference(src.getResource()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.TestScript.TestScriptFixtureComponent convertTestScriptFixtureComponent(TestScript.TestScriptFixtureComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.TestScript.TestScriptFixtureComponent tgt = new org.hl7.fhir.r4.model.TestScript.TestScriptFixtureComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasAutocreate())
      tgt.setAutocreateElement(Boolean40_N.convertBoolean(src.getAutocreateElement()));
    if (src.hasAutodelete())
      tgt.setAutodeleteElement(Boolean40_N.convertBoolean(src.getAutodeleteElement()));
    if (src.hasResource())
      tgt.setResource(Reference40_N.convertReference(src.getResource()));
    return tgt;
  }

  public static TestScript.TestScriptVariableComponent convertTestScriptVariableComponent(org.hl7.fhir.r4.model.TestScript.TestScriptVariableComponent src) throws FHIRException {
    if (src == null)
      return null;
    TestScript.TestScriptVariableComponent tgt = new TestScript.TestScriptVariableComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    if (src.hasDefaultValue())
      tgt.setDefaultValueElement(String40_N.convertString(src.getDefaultValueElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_N.convertString(src.getDescriptionElement()));
    if (src.hasExpression())
      tgt.setExpression(Expression40_N.convertExpression(src.getExpressionElement()));
    if (src.hasHeaderField())
      tgt.setHeaderFieldElement(String40_N.convertString(src.getHeaderFieldElement()));
    if (src.hasHint())
      tgt.setHintElement(String40_N.convertString(src.getHintElement()));
    if (src.hasPath())
      tgt.setPathElement(String40_N.convertString(src.getPathElement()));
    if (src.hasSourceId())
      tgt.setSourceIdElement(Id40_N.convertId(src.getSourceIdElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.TestScript.TestScriptVariableComponent convertTestScriptVariableComponent(TestScript.TestScriptVariableComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.TestScript.TestScriptVariableComponent tgt = new org.hl7.fhir.r4.model.TestScript.TestScriptVariableComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    if (src.hasDefaultValue())
      tgt.setDefaultValueElement(String40_N.convertString(src.getDefaultValueElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_N.convertString(src.getDescriptionElement()));
    if (src.hasExpression())
      tgt.setExpressionElement(Expression40_N.convertString(src.getExpression()));
    if (src.hasHeaderField())
      tgt.setHeaderFieldElement(String40_N.convertString(src.getHeaderFieldElement()));
    if (src.hasHint())
      tgt.setHintElement(String40_N.convertString(src.getHintElement()));
    if (src.hasPath())
      tgt.setPathElement(String40_N.convertString(src.getPathElement()));
    if (src.hasSourceId())
      tgt.setSourceIdElement(Id40_N.convertId(src.getSourceIdElement()));
    return tgt;
  }

  public static TestScript.TestScriptSetupComponent convertTestScriptSetupComponent(org.hl7.fhir.r4.model.TestScript.TestScriptSetupComponent src) throws FHIRException {
    if (src == null)
      return null;
    TestScript.TestScriptSetupComponent tgt = new TestScript.TestScriptSetupComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r4.model.TestScript.SetupActionComponent t : src.getAction())
      tgt.addAction(convertSetupActionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.TestScript.TestScriptSetupComponent convertTestScriptSetupComponent(TestScript.TestScriptSetupComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.TestScript.TestScriptSetupComponent tgt = new org.hl7.fhir.r4.model.TestScript.TestScriptSetupComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    for (TestScript.SetupActionComponent t : src.getActionList())
      tgt.addAction(convertSetupActionComponent(t));
    return tgt;
  }

  public static TestScript.SetupActionComponent convertSetupActionComponent(org.hl7.fhir.r4.model.TestScript.SetupActionComponent src) throws FHIRException {
    if (src == null)
      return null;
    TestScript.SetupActionComponent tgt = new TestScript.SetupActionComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasOperation())
      tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    if (src.hasAssert())
      tgt.setAssert(convertSetupActionAssertComponent(src.getAssert()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.TestScript.SetupActionComponent convertSetupActionComponent(TestScript.SetupActionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.TestScript.SetupActionComponent tgt = new org.hl7.fhir.r4.model.TestScript.SetupActionComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasOperation())
      tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    if (src.hasAssert())
      tgt.setAssert(convertSetupActionAssertComponent(src.getAssert()));
    return tgt;
  }

  public static TestScript.SetupActionOperationComponent convertSetupActionOperationComponent(org.hl7.fhir.r4.model.TestScript.SetupActionOperationComponent src) throws FHIRException {
    if (src == null)
      return null;
    TestScript.SetupActionOperationComponent tgt = new TestScript.SetupActionOperationComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(Coding40_N.convertCoding(src.getType()));
    if (src.hasResource())
      tgt.setResource(src.getResource());
    if (src.hasLabel())
      tgt.setLabelElement(String40_N.convertString(src.getLabelElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_N.convertString(src.getDescriptionElement()));
    if (src.hasAccept())
      tgt.setAcceptElement(Code40_N.convertCode(src.getAcceptElement()));
    if (src.hasContentType())
      tgt.setContentTypeElement(Code40_N.convertCode(src.getContentTypeElement()));
    if (src.hasDestination())
      tgt.setDestinationElement(Integer40_N.convertInteger(src.getDestinationElement()));
    if (src.hasEncodeRequestUrl())
      tgt.setEncodeRequestUrlElement(Boolean40_N.convertBoolean(src.getEncodeRequestUrlElement()));
    if (src.hasMethod())
      tgt.setMethodElement(convertTestScriptRequestMethodCode(src.getMethodElement()));
    if (src.hasOrigin())
      tgt.setOriginElement(Integer40_N.convertInteger(src.getOriginElement()));
    if (src.hasParams())
      tgt.setParamsElement(String40_N.convertString(src.getParamsElement()));
    for (org.hl7.fhir.r4.model.TestScript.SetupActionOperationRequestHeaderComponent t : src.getRequestHeader())
      tgt.addRequestHeader(convertSetupActionOperationRequestHeaderComponent(t));
    if (src.hasRequestId())
      tgt.setRequestIdElement(Id40_N.convertId(src.getRequestIdElement()));
    if (src.hasResponseId())
      tgt.setResponseIdElement(Id40_N.convertId(src.getResponseIdElement()));
    if (src.hasSourceId())
      tgt.setSourceIdElement(Id40_N.convertId(src.getSourceIdElement()));
    if (src.hasTargetId())
      tgt.setTargetIdElement(Id40_N.convertId(src.getTargetIdElement()));
    if (src.hasUrl())
      tgt.setUrlElement(String40_N.convertString(src.getUrlElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.TestScript.SetupActionOperationComponent convertSetupActionOperationComponent(TestScript.SetupActionOperationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.TestScript.SetupActionOperationComponent tgt = new org.hl7.fhir.r4.model.TestScript.SetupActionOperationComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(Coding40_N.convertCoding(src.getType()));
    if (src.hasResource())
      tgt.setResource(src.getResource());
    if (src.hasLabel())
      tgt.setLabelElement(String40_N.convertString(src.getLabelElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_N.convertString(src.getDescriptionElement()));
    if (src.hasAccept())
      tgt.setAcceptElement(Code40_N.convertCode(src.getAcceptElement()));
    if (src.hasContentType())
      tgt.setContentTypeElement(Code40_N.convertCode(src.getContentTypeElement()));
    if (src.hasDestination())
      tgt.setDestinationElement(Integer40_N.convertInteger(src.getDestinationElement()));
    if (src.hasEncodeRequestUrl())
      tgt.setEncodeRequestUrlElement(Boolean40_N.convertBoolean(src.getEncodeRequestUrlElement()));
    if (src.hasMethod())
      tgt.setMethodElement(convertTestScriptRequestMethodCode(src.getMethodElement()));
    if (src.hasOrigin())
      tgt.setOriginElement(Integer40_N.convertInteger(src.getOriginElement()));
    if (src.hasParams())
      tgt.setParamsElement(String40_N.convertString(src.getParamsElement()));
    for (TestScript.SetupActionOperationRequestHeaderComponent t : src.getRequestHeaderList())
      tgt.addRequestHeader(convertSetupActionOperationRequestHeaderComponent(t));
    if (src.hasRequestId())
      tgt.setRequestIdElement(Id40_N.convertId(src.getRequestIdElement()));
    if (src.hasResponseId())
      tgt.setResponseIdElement(Id40_N.convertId(src.getResponseIdElement()));
    if (src.hasSourceId())
      tgt.setSourceIdElement(Id40_N.convertId(src.getSourceIdElement()));
    if (src.hasTargetId())
      tgt.setTargetIdElement(Id40_N.convertId(src.getTargetIdElement()));
    if (src.hasUrl())
      tgt.setUrlElement(String40_N.convertString(src.getUrlElement()));
    return tgt;
  }

  static public Enumeration<TestScript.TestScriptRequestMethodCodeValueSet> convertTestScriptRequestMethodCode(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TestScript.TestScriptRequestMethodCode> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<TestScript.TestScriptRequestMethodCodeValueSet> tgt = new Enumeration<>(new TestScript.TestScriptRequestMethodCodeValueSetEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case DELETE:
                  tgt.setValue(TestScript.TestScriptRequestMethodCodeValueSet.DELETE);
                  break;
              case GET:
                  tgt.setValue(TestScript.TestScriptRequestMethodCodeValueSet.GET);
                  break;
              case OPTIONS:
                  tgt.setValue(TestScript.TestScriptRequestMethodCodeValueSet.OPTIONS);
                  break;
              case PATCH:
                  tgt.setValue(TestScript.TestScriptRequestMethodCodeValueSet.PATCH);
                  break;
              case POST:
                  tgt.setValue(TestScript.TestScriptRequestMethodCodeValueSet.POST);
                  break;
              case PUT:
                  tgt.setValue(TestScript.TestScriptRequestMethodCodeValueSet.PUT);
                  break;
              case HEAD:
                  tgt.setValue(TestScript.TestScriptRequestMethodCodeValueSet.HEAD);
                  break;
              default:
                  tgt.setValue(TestScript.TestScriptRequestMethodCodeValueSet.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TestScript.TestScriptRequestMethodCode> convertTestScriptRequestMethodCode(Enumeration<TestScript.TestScriptRequestMethodCodeValueSet> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TestScript.TestScriptRequestMethodCode> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.TestScript.TestScriptRequestMethodCodeEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case DELETE:
                  tgt.setValue(org.hl7.fhir.r4.model.TestScript.TestScriptRequestMethodCode.DELETE);
                  break;
              case GET:
                  tgt.setValue(org.hl7.fhir.r4.model.TestScript.TestScriptRequestMethodCode.GET);
                  break;
              case OPTIONS:
                  tgt.setValue(org.hl7.fhir.r4.model.TestScript.TestScriptRequestMethodCode.OPTIONS);
                  break;
              case PATCH:
                  tgt.setValue(org.hl7.fhir.r4.model.TestScript.TestScriptRequestMethodCode.PATCH);
                  break;
              case POST:
                  tgt.setValue(org.hl7.fhir.r4.model.TestScript.TestScriptRequestMethodCode.POST);
                  break;
              case PUT:
                  tgt.setValue(org.hl7.fhir.r4.model.TestScript.TestScriptRequestMethodCode.PUT);
                  break;
              case HEAD:
                  tgt.setValue(org.hl7.fhir.r4.model.TestScript.TestScriptRequestMethodCode.HEAD);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4.model.TestScript.TestScriptRequestMethodCode.NULL);
                  break;
          }
      }
      return tgt;
  }

  public static TestScript.SetupActionOperationRequestHeaderComponent convertSetupActionOperationRequestHeaderComponent(org.hl7.fhir.r4.model.TestScript.SetupActionOperationRequestHeaderComponent src) throws FHIRException {
    if (src == null)
      return null;
    TestScript.SetupActionOperationRequestHeaderComponent tgt = new TestScript.SetupActionOperationRequestHeaderComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasField())
      tgt.setFieldElement(String40_N.convertString(src.getFieldElement()));
    if (src.hasValue())
      tgt.setValueElement(String40_N.convertString(src.getValueElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.TestScript.SetupActionOperationRequestHeaderComponent convertSetupActionOperationRequestHeaderComponent(TestScript.SetupActionOperationRequestHeaderComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.TestScript.SetupActionOperationRequestHeaderComponent tgt = new org.hl7.fhir.r4.model.TestScript.SetupActionOperationRequestHeaderComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasField())
      tgt.setFieldElement(String40_N.convertString(src.getFieldElement()));
    if (src.hasValue())
      tgt.setValueElement(String40_N.convertString(src.getValueElement()));
    return tgt;
  }

  public static TestScript.SetupActionAssertComponent convertSetupActionAssertComponent(org.hl7.fhir.r4.model.TestScript.SetupActionAssertComponent src) throws FHIRException {
    if (src == null)
      return null;
    TestScript.SetupActionAssertComponent tgt = new TestScript.SetupActionAssertComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasExtension(EXT_TS_STOP_ON_FAIL)) {
      // stopTestOnFail is R5+/R6 (required) with no R4 home; recover it from the cross-version extension
      tgt.setStopTestOnFailElement(Boolean40_N.convertBoolean((org.hl7.fhir.r4.model.BooleanType) src.getExtensionByUrl(EXT_TS_STOP_ON_FAIL).getValue()));
      tgt.removeExtension(EXT_TS_STOP_ON_FAIL);
    } else {
      tgt.setStopTestOnFail(false); // required in R6; default for a genuine R4 assert that never had it
    }
    if (src.hasLabel())
      tgt.setLabelElement(String40_N.convertString(src.getLabelElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_N.convertString(src.getDescriptionElement()));
    if (src.hasDirection())
      tgt.setDirectionElement(convertAssertionDirectionType(src.getDirectionElement()));
    if (src.hasCompareToSourceId())
      tgt.setCompareToSourceIdElement(String40_N.convertString(src.getCompareToSourceIdElement()));
    if (src.hasCompareToSourceExpression())
      tgt.setCompareToSourceExpression(Expression40_N.convertExpression(src.getCompareToSourceExpressionElement()));
    if (src.hasCompareToSourcePath())
      tgt.setCompareToSourcePathElement(String40_N.convertString(src.getCompareToSourcePathElement()));
    if (src.hasContentType())
      tgt.setContentTypeElement(Code40_N.convertCode(src.getContentTypeElement()));
    if (src.hasExpression())
      tgt.setExpression(Expression40_N.convertExpression(src.getExpressionElement()));
    if (src.hasHeaderField())
      tgt.setHeaderFieldElement(String40_N.convertString(src.getHeaderFieldElement()));
    if (src.hasMinimumId())
      tgt.setMinimumIdElement(String40_N.convertString(src.getMinimumIdElement()));
    if (src.hasNavigationLinks())
      tgt.setNavigationLinksElement(Boolean40_N.convertBoolean(src.getNavigationLinksElement()));
    if (src.hasOperator())
      tgt.setOperatorElement(convertAssertionOperatorType(src.getOperatorElement()));
    if (src.hasPath())
      tgt.setPathElement(String40_N.convertString(src.getPathElement()));
    if (src.hasRequestMethod())
      tgt.setRequestMethodElement(convertTestScriptRequestMethodCode(src.getRequestMethodElement()));
    if (src.hasRequestURL())
      tgt.setRequestURLElement(String40_N.convertString(src.getRequestURLElement()));
    if (src.hasResource())
      tgt.setResource(src.getResource());
    if (src.hasResponse())
      tgt.setResponseElement(convertAssertionResponseTypes(src.getResponseElement()));
    if (src.hasResponseCode())
      tgt.setResponseCodeElement(String40_N.convertString(src.getResponseCodeElement()));
    if (src.hasSourceId())
      tgt.setSourceIdElement(Id40_N.convertId(src.getSourceIdElement()));
    if (src.hasValidateProfileId())
      tgt.setValidateProfileIdElement(Id40_N.convertId(src.getValidateProfileIdElement()));
    if (src.hasValue())
      tgt.setValueElement(String40_N.convertString(src.getValueElement()));
    if (src.hasWarningOnly())
      tgt.setWarningOnlyElement(Boolean40_N.convertBoolean(src.getWarningOnlyElement()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.TestScript.SetupActionAssertComponent convertSetupActionAssertComponent(TestScript.SetupActionAssertComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.TestScript.SetupActionAssertComponent tgt = new org.hl7.fhir.r4.model.TestScript.SetupActionAssertComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasStopTestOnFail()) {
      org.hl7.fhir.r4.model.Extension ext = tgt.addExtension();
      ext.setUrl(EXT_TS_STOP_ON_FAIL);
      ext.setValue(Boolean40_N.convertBoolean(src.getStopTestOnFailElement()));
    }
    if (src.hasLabel())
      tgt.setLabelElement(String40_N.convertString(src.getLabelElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_N.convertString(src.getDescriptionElement()));
    if (src.hasDirection())
      tgt.setDirectionElement(convertAssertionDirectionType(src.getDirectionElement()));
    if (src.hasCompareToSourceId())
      tgt.setCompareToSourceIdElement(String40_N.convertString(src.getCompareToSourceIdElement()));
    if (src.hasCompareToSourceExpression())
      tgt.setCompareToSourceExpressionElement(Expression40_N.convertString(src.getCompareToSourceExpression()));
    if (src.hasCompareToSourcePath())
      tgt.setCompareToSourcePathElement(String40_N.convertString(src.getCompareToSourcePathElement()));
    if (src.hasContentType())
      tgt.setContentTypeElement(Code40_N.convertCode(src.getContentTypeElement()));
    if (src.hasExpression())
      tgt.setExpressionElement(Expression40_N.convertString(src.getExpression()));
    if (src.hasHeaderField())
      tgt.setHeaderFieldElement(String40_N.convertString(src.getHeaderFieldElement()));
    if (src.hasMinimumId())
      tgt.setMinimumIdElement(String40_N.convertString(src.getMinimumIdElement()));
    if (src.hasNavigationLinks())
      tgt.setNavigationLinksElement(Boolean40_N.convertBoolean(src.getNavigationLinksElement()));
    if (src.hasOperator())
      tgt.setOperatorElement(convertAssertionOperatorType(src.getOperatorElement()));
    if (src.hasPath())
      tgt.setPathElement(String40_N.convertString(src.getPathElement()));
    if (src.hasRequestMethod())
      tgt.setRequestMethodElement(convertTestScriptRequestMethodCode(src.getRequestMethodElement()));
    if (src.hasRequestURL())
      tgt.setRequestURLElement(String40_N.convertString(src.getRequestURLElement()));
    if (src.hasResource())
      tgt.setResource(src.getResource());
    if (src.hasResponse())
      tgt.setResponseElement(convertAssertionResponseTypes(src.getResponseElement()));
    if (src.hasResponseCode())
      tgt.setResponseCodeElement(String40_N.convertString(src.getResponseCodeElement()));
    if (src.hasSourceId())
      tgt.setSourceIdElement(Id40_N.convertId(src.getSourceIdElement()));
    if (src.hasValidateProfileId())
      tgt.setValidateProfileIdElement(Id40_N.convertId(src.getValidateProfileIdElement()));
    if (src.hasValue())
      tgt.setValueElement(String40_N.convertString(src.getValueElement()));
    if (src.hasWarningOnly())
      tgt.setWarningOnlyElement(Boolean40_N.convertBoolean(src.getWarningOnlyElement()));
    return tgt;
  }

  static public Enumeration<TestScript.AssertionDirectionTypeValueSet> convertAssertionDirectionType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TestScript.AssertionDirectionType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<TestScript.AssertionDirectionTypeValueSet> tgt = new Enumeration<>(new TestScript.AssertionDirectionTypeValueSetEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case RESPONSE:
                  tgt.setValue(TestScript.AssertionDirectionTypeValueSet.RESPONSE);
                  break;
              case REQUEST:
                  tgt.setValue(TestScript.AssertionDirectionTypeValueSet.REQUEST);
                  break;
              default:
                  tgt.setValue(TestScript.AssertionDirectionTypeValueSet.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TestScript.AssertionDirectionType> convertAssertionDirectionType(Enumeration<TestScript.AssertionDirectionTypeValueSet> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TestScript.AssertionDirectionType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.TestScript.AssertionDirectionTypeEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case RESPONSE:
                  tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionDirectionType.RESPONSE);
                  break;
              case REQUEST:
                  tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionDirectionType.REQUEST);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionDirectionType.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public Enumeration<TestScript.AssertionOperatorTypeValueSet> convertAssertionOperatorType(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TestScript.AssertionOperatorType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<TestScript.AssertionOperatorTypeValueSet> tgt = new Enumeration<>(new TestScript.AssertionOperatorTypeValueSetEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case EQUALS:
                  tgt.setValue(TestScript.AssertionOperatorTypeValueSet.EQUALS);
                  break;
              case NOTEQUALS:
                  tgt.setValue(TestScript.AssertionOperatorTypeValueSet.NOTEQUALS);
                  break;
              case IN:
                  tgt.setValue(TestScript.AssertionOperatorTypeValueSet.IN);
                  break;
              case NOTIN:
                  tgt.setValue(TestScript.AssertionOperatorTypeValueSet.NOTIN);
                  break;
              case GREATERTHAN:
                  tgt.setValue(TestScript.AssertionOperatorTypeValueSet.GREATERTHAN);
                  break;
              case LESSTHAN:
                  tgt.setValue(TestScript.AssertionOperatorTypeValueSet.LESSTHAN);
                  break;
              case EMPTY:
                  tgt.setValue(TestScript.AssertionOperatorTypeValueSet.EMPTY);
                  break;
              case NOTEMPTY:
                  tgt.setValue(TestScript.AssertionOperatorTypeValueSet.NOTEMPTY);
                  break;
              case CONTAINS:
                  tgt.setValue(TestScript.AssertionOperatorTypeValueSet.CONTAINS);
                  break;
              case NOTCONTAINS:
                  tgt.setValue(TestScript.AssertionOperatorTypeValueSet.NOTCONTAINS);
                  break;
              case EVAL:
                  tgt.setValue(TestScript.AssertionOperatorTypeValueSet.EVAL);
                  break;
              default:
                  tgt.setValue(TestScript.AssertionOperatorTypeValueSet.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TestScript.AssertionOperatorType> convertAssertionOperatorType(Enumeration<TestScript.AssertionOperatorTypeValueSet> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TestScript.AssertionOperatorType> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.TestScript.AssertionOperatorTypeEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case EQUALS:
                  tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionOperatorType.EQUALS);
                  break;
              case NOTEQUALS:
                  tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionOperatorType.NOTEQUALS);
                  break;
              case IN:
                  tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionOperatorType.IN);
                  break;
              case NOTIN:
                  tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionOperatorType.NOTIN);
                  break;
              case GREATERTHAN:
                  tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionOperatorType.GREATERTHAN);
                  break;
              case LESSTHAN:
                  tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionOperatorType.LESSTHAN);
                  break;
              case EMPTY:
                  tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionOperatorType.EMPTY);
                  break;
              case NOTEMPTY:
                  tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionOperatorType.NOTEMPTY);
                  break;
              case CONTAINS:
                  tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionOperatorType.CONTAINS);
                  break;
              case NOTCONTAINS:
                  tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionOperatorType.NOTCONTAINS);
                  break;
              case EVAL:
                  tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionOperatorType.EVAL);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionOperatorType.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public Enumeration<TestScript.AssertionResponseTypesValueSet> convertAssertionResponseTypes(org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TestScript.AssertionResponseTypes> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<TestScript.AssertionResponseTypesValueSet> tgt = new Enumeration<>(new TestScript.AssertionResponseTypesValueSetEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case OKAY:
                  tgt.setValue(TestScript.AssertionResponseTypesValueSet.OKAY);
                  break;
              case CREATED:
                  tgt.setValue(TestScript.AssertionResponseTypesValueSet.CREATED);
                  break;
              case NOCONTENT:
                  tgt.setValue(TestScript.AssertionResponseTypesValueSet.NOCONTENT);
                  break;
              case NOTMODIFIED:
                  tgt.setValue(TestScript.AssertionResponseTypesValueSet.NOTMODIFIED);
                  break;
              case BAD:
                  tgt.setValue(TestScript.AssertionResponseTypesValueSet.BADREQUEST);
                  break;
              case FORBIDDEN:
                  tgt.setValue(TestScript.AssertionResponseTypesValueSet.FORBIDDEN);
                  break;
              case NOTFOUND:
                  tgt.setValue(TestScript.AssertionResponseTypesValueSet.NOTFOUND);
                  break;
              case METHODNOTALLOWED:
                  tgt.setValue(TestScript.AssertionResponseTypesValueSet.METHODNOTALLOWED);
                  break;
              case CONFLICT:
                  tgt.setValue(TestScript.AssertionResponseTypesValueSet.CONFLICT);
                  break;
              case GONE:
                  tgt.setValue(TestScript.AssertionResponseTypesValueSet.GONE);
                  break;
              case PRECONDITIONFAILED:
                  tgt.setValue(TestScript.AssertionResponseTypesValueSet.PRECONDITIONFAILED);
                  break;
              case UNPROCESSABLE:
                  tgt.setValue(TestScript.AssertionResponseTypesValueSet.UNPROCESSABLECONTENT);
                  break;
              default:
                  tgt.setValue(TestScript.AssertionResponseTypesValueSet.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TestScript.AssertionResponseTypes> convertAssertionResponseTypes(Enumeration<TestScript.AssertionResponseTypesValueSet> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r4.model.Enumeration<org.hl7.fhir.r4.model.TestScript.AssertionResponseTypes> tgt = new org.hl7.fhir.r4.model.Enumeration<>(new org.hl7.fhir.r4.model.TestScript.AssertionResponseTypesEnumFactory());
      ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case OKAY:
                  tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionResponseTypes.OKAY);
                  break;
              case CREATED:
                  tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionResponseTypes.CREATED);
                  break;
              case NOCONTENT:
                  tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionResponseTypes.NOCONTENT);
                  break;
              case NOTMODIFIED:
                  tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionResponseTypes.NOTMODIFIED);
                  break;
              case BADREQUEST:
                  tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionResponseTypes.BAD);
                  break;
              case FORBIDDEN:
                  tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionResponseTypes.FORBIDDEN);
                  break;
              case NOTFOUND:
                  tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionResponseTypes.NOTFOUND);
                  break;
              case METHODNOTALLOWED:
                  tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionResponseTypes.METHODNOTALLOWED);
                  break;
              case CONFLICT:
                  tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionResponseTypes.CONFLICT);
                  break;
              case GONE:
                  tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionResponseTypes.GONE);
                  break;
              case PRECONDITIONFAILED:
                  tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionResponseTypes.PRECONDITIONFAILED);
                  break;
              case UNPROCESSABLECONTENT:
                  tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionResponseTypes.UNPROCESSABLE);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r4.model.TestScript.AssertionResponseTypes.NULL);
                  break;
          }
      }
      return tgt;
  }

  public static TestScript.TestScriptTestComponent convertTestScriptTestComponent(org.hl7.fhir.r4.model.TestScript.TestScriptTestComponent src) throws FHIRException {
    if (src == null)
      return null;
    TestScript.TestScriptTestComponent tgt = new TestScript.TestScriptTestComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_N.convertString(src.getDescriptionElement()));
    for (org.hl7.fhir.r4.model.TestScript.TestActionComponent t : src.getAction())
      tgt.addAction(convertTestActionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.TestScript.TestScriptTestComponent convertTestScriptTestComponent(TestScript.TestScriptTestComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.TestScript.TestScriptTestComponent tgt = new org.hl7.fhir.r4.model.TestScript.TestScriptTestComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(String40_N.convertString(src.getNameElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String40_N.convertString(src.getDescriptionElement()));
    for (TestScript.TestActionComponent t : src.getActionList())
      tgt.addAction(convertTestActionComponent(t));
    return tgt;
  }

  public static TestScript.TestActionComponent convertTestActionComponent(org.hl7.fhir.r4.model.TestScript.TestActionComponent src) throws FHIRException {
    if (src == null)
      return null;
    TestScript.TestActionComponent tgt = new TestScript.TestActionComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasOperation())
      tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    if (src.hasAssert())
      tgt.setAssert(convertSetupActionAssertComponent(src.getAssert()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.TestScript.TestActionComponent convertTestActionComponent(TestScript.TestActionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.TestScript.TestActionComponent tgt = new org.hl7.fhir.r4.model.TestScript.TestActionComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasOperation())
      tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    if (src.hasAssert())
      tgt.setAssert(convertSetupActionAssertComponent(src.getAssert()));
    return tgt;
  }

  public static TestScript.TestScriptTeardownComponent convertTestScriptTeardownComponent(org.hl7.fhir.r4.model.TestScript.TestScriptTeardownComponent src) throws FHIRException {
    if (src == null)
      return null;
    TestScript.TestScriptTeardownComponent tgt = new TestScript.TestScriptTeardownComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r4.model.TestScript.TeardownActionComponent t : src.getAction())
      tgt.addAction(convertTeardownActionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.TestScript.TestScriptTeardownComponent convertTestScriptTeardownComponent(TestScript.TestScriptTeardownComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.TestScript.TestScriptTeardownComponent tgt = new org.hl7.fhir.r4.model.TestScript.TestScriptTeardownComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    for (TestScript.TeardownActionComponent t : src.getActionList())
      tgt.addAction(convertTeardownActionComponent(t));
    return tgt;
  }

  public static TestScript.TeardownActionComponent convertTeardownActionComponent(org.hl7.fhir.r4.model.TestScript.TeardownActionComponent src) throws FHIRException {
    if (src == null)
      return null;
    TestScript.TeardownActionComponent tgt = new TestScript.TeardownActionComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasOperation())
      tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.TestScript.TeardownActionComponent convertTeardownActionComponent(TestScript.TeardownActionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.TestScript.TeardownActionComponent tgt = new org.hl7.fhir.r4.model.TestScript.TeardownActionComponent();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyBackboneElement(src, tgt);
    if (src.hasOperation())
      tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    return tgt;
  }

  // ============================================================================================
  // TestPlan <-> Basic
  //
  // R4 has no TestPlan, and the testing-IG TestPlan is a ground-up redesign relative to the R5
  // TestPlan, so rather than converting to the R5 TestPlan we round-trip the whole resource through
  // Basic, carrying every element as an extension - the same technique Requirements40_N /
  // TestPlan40_N use for resources with no representation in the target version. The extension URLs
  // use the 6.0 namespace (the testing-IG TestPlan is R6-shaped), keeping them distinct from the 5.0
  // extension URLs the native R5 TestPlan uses. Reusable/nested backbones (scope, parameter, suite,
  // input, test, assertion) use short relative sub-extension URLs within their wrapper extension, so
  // the same component converter serves every place the component appears (including recursive suites).
  // input.resource (an inline resource) has no extension representation, so it is carried as a
  // contained resource on the Basic (id "tpc-N") and referenced from the input extension.
  // ============================================================================================

  private static final String TP_BASE = "http://hl7.org/fhir/6.0/StructureDefinition/extension-TestPlan.";
  private static final String TP_URL = TP_BASE + "url";
  private static final String TP_VERSION = TP_BASE + "version";
  private static final String TP_VERSION_ALGORITHM = TP_BASE + "versionAlgorithm";
  private static final String TP_NAME = TP_BASE + "name";
  private static final String TP_TITLE = TP_BASE + "title";
  private static final String TP_STATUS = TP_BASE + "status";
  private static final String TP_EXPERIMENTAL = TP_BASE + "experimental";
  private static final String TP_DATE = TP_BASE + "date";
  private static final String TP_PUBLISHER = TP_BASE + "publisher";
  private static final String TP_CONTACT = TP_BASE + "contact";
  private static final String TP_DESCRIPTION = TP_BASE + "description";
  private static final String TP_USE_CONTEXT = TP_BASE + "useContext";
  private static final String TP_JURISDICTION = TP_BASE + "jurisdiction";
  private static final String TP_PURPOSE = TP_BASE + "purpose";
  private static final String TP_COPYRIGHT = TP_BASE + "copyright";
  private static final String TP_COPYRIGHT_LABEL = TP_BASE + "copyrightLabel";
  private static final String TP_SCOPE = TP_BASE + "scope";
  private static final String TP_DEPENDENCY = TP_BASE + "dependency";
  private static final String TP_RUNNER = TP_BASE + "runner";
  private static final String TP_MODE = TP_BASE + "mode";
  private static final String TP_PARAMETER = TP_BASE + "parameter";
  private static final String TP_SUITE = TP_BASE + "suite";

  private static final String[] TP_IGNORED_EXTENSION_URLS = new String[] {
      TP_URL, TP_VERSION, TP_VERSION_ALGORITHM, TP_NAME, TP_TITLE, TP_STATUS, TP_EXPERIMENTAL,
      TP_DATE, TP_PUBLISHER, TP_CONTACT, TP_DESCRIPTION, TP_USE_CONTEXT, TP_JURISDICTION, TP_PURPOSE,
      TP_COPYRIGHT, TP_COPYRIGHT_LABEL, TP_SCOPE, TP_DEPENDENCY, TP_RUNNER, TP_MODE, TP_PARAMETER, TP_SUITE };

  public static org.hl7.fhir.r4.model.Basic convertTestPlan(TestPlan src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.Basic tgt = new org.hl7.fhir.r4.model.Basic();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt);
    tgt.getCode().getCodingFirstRep().setSystem("http://hl7.org/fhir/fhir-types").setCode("TestPlan");
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.getIdentifier().add(Identifier40_N.convertIdentifier(t));
    if (src.hasUrl())
      tgt.addExtension(TP_URL, Uri40_N.convertUri(src.getUrlElement()));
    if (src.hasVersion())
      tgt.addExtension(TP_VERSION, String40_N.convertString(src.getVersionElement()));
    if (src.hasVersionAlgorithm())
      tgt.addExtension(TP_VERSION_ALGORITHM, ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getVersionAlgorithm()));
    if (src.hasName())
      tgt.addExtension(TP_NAME, String40_N.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.addExtension(TP_TITLE, String40_N.convertString(src.getTitleElement()));
    if (src.hasStatus())
      tgt.addExtension(TP_STATUS, new org.hl7.fhir.r4.model.CodeType(src.getStatus().toCode()));
    if (src.hasExperimental())
      tgt.addExtension(TP_EXPERIMENTAL, Boolean40_N.convertBoolean(src.getExperimentalElement()));
    if (src.hasDate())
      tgt.addExtension(TP_DATE, DateTime40_N.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.addExtension(TP_PUBLISHER, String40_N.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.model.core.ContactDetail t : src.getContactList())
      tgt.addExtension(TP_CONTACT, ContactDetail40_N.convertContactDetail(t));
    if (src.hasDescription())
      tgt.addExtension(TP_DESCRIPTION, MarkDown40_N.convertMarkdown(src.getDescriptionElement()));
    for (org.hl7.fhir.model.core.UsageContext t : src.getUseContextList())
      tgt.addExtension(TP_USE_CONTEXT, UsageContext40_N.convertUsageContext(t));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getJurisdictionList())
      tgt.addExtension(TP_JURISDICTION, CodeableConcept40_N.convertCodeableConcept(t));
    if (src.hasPurpose())
      tgt.addExtension(TP_PURPOSE, MarkDown40_N.convertMarkdown(src.getPurposeElement()));
    if (src.hasCopyright())
      tgt.addExtension(TP_COPYRIGHT, MarkDown40_N.convertMarkdown(src.getCopyrightElement()));
    if (src.hasCopyrightLabel())
      tgt.addExtension(TP_COPYRIGHT_LABEL, String40_N.convertString(src.getCopyrightLabelElement()));
    for (org.hl7.fhir.model.testing.TestPlan.TestPlanScopeComponent t : src.getScopeList()) {
      org.hl7.fhir.r4.model.Extension tgte = new org.hl7.fhir.r4.model.Extension(TP_SCOPE);
      tgt.addExtension(tgte);
      convertTestPlanScope(t, tgte);
    }
    for (org.hl7.fhir.model.testing.TestPlan.TestPlanDependencyComponent t : src.getDependencyList()) {
      org.hl7.fhir.r4.model.Extension tgte = new org.hl7.fhir.r4.model.Extension(TP_DEPENDENCY);
      tgt.addExtension(tgte);
      convertTestPlanDependency(t, tgte);
    }
    if (src.hasRunner())
      tgt.addExtension(TP_RUNNER, Url40_N.convertUrl(src.getRunnerElement()));
    for (org.hl7.fhir.model.testing.TestPlan.TestPlanModeComponent t : src.getModeList()) {
      org.hl7.fhir.r4.model.Extension tgte = new org.hl7.fhir.r4.model.Extension(TP_MODE);
      tgt.addExtension(tgte);
      convertTestPlanMode(t, tgte);
    }
    for (org.hl7.fhir.model.testing.TestPlan.TestPlanParameterComponent t : src.getParameterList()) {
      org.hl7.fhir.r4.model.Extension tgte = new org.hl7.fhir.r4.model.Extension(TP_PARAMETER);
      tgt.addExtension(tgte);
      convertTestPlanParameter(t, tgte);
    }
    for (org.hl7.fhir.model.testing.TestPlan.TestPlanSuiteComponent t : src.getSuiteList()) {
      org.hl7.fhir.r4.model.Extension tgte = new org.hl7.fhir.r4.model.Extension(TP_SUITE);
      tgt.addExtension(tgte);
      convertTestPlanSuite(t, tgte, tgt);
    }
    return tgt;
  }

  public static org.hl7.fhir.model.testing.TestPlan convertTestPlan(org.hl7.fhir.r4.model.Basic src) throws FHIRException {
    if (src == null)
      return null;
    if (!src.getCode().hasCoding("http://hl7.org/fhir/fhir-types", "TestPlan")) {
      throw new FHIRException("Error in logic: this Basic resource is not a TestPlan");
    }
    org.hl7.fhir.model.testing.TestPlan tgt = new org.hl7.fhir.model.testing.TestPlan();
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyDomainResource(src, tgt, TP_IGNORED_EXTENSION_URLS);
    for (org.hl7.fhir.r4.model.Identifier t : src.getIdentifier())
      tgt.getIdentifierList().add(Identifier40_N.convertIdentifier(t));
    if (src.hasExtension(TP_URL))
      tgt.setUrlElement(Uri40_N.convertUri((org.hl7.fhir.r4.model.UriType) src.getExtensionByUrl(TP_URL).getValue()));
    if (src.hasExtension(TP_VERSION))
      tgt.setVersionElement(String40_N.convertString((org.hl7.fhir.r4.model.StringType) src.getExtensionByUrl(TP_VERSION).getValue()));
    if (src.hasExtension(TP_VERSION_ALGORITHM))
      tgt.setVersionAlgorithm(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getExtensionByUrl(TP_VERSION_ALGORITHM).getValue()));
    if (src.hasExtension(TP_NAME))
      tgt.setNameElement(String40_N.convertString((org.hl7.fhir.r4.model.StringType) src.getExtensionByUrl(TP_NAME).getValue()));
    if (src.hasExtension(TP_TITLE))
      tgt.setTitleElement(String40_N.convertString((org.hl7.fhir.r4.model.StringType) src.getExtensionByUrl(TP_TITLE).getValue()));
    if (src.hasExtension(TP_STATUS))
      tgt.setStatus(org.hl7.fhir.model.core.Enumerations.PublicationStatus.fromCode(src.getExtensionByUrl(TP_STATUS).getValue().primitiveValue()));
    if (src.hasExtension(TP_EXPERIMENTAL))
      tgt.setExperimentalElement(Boolean40_N.convertBoolean((org.hl7.fhir.r4.model.BooleanType) src.getExtensionByUrl(TP_EXPERIMENTAL).getValue()));
    if (src.hasExtension(TP_DATE))
      tgt.setDateElement(DateTime40_N.convertDateTime((org.hl7.fhir.r4.model.DateTimeType) src.getExtensionByUrl(TP_DATE).getValue()));
    if (src.hasExtension(TP_PUBLISHER))
      tgt.setPublisherElement(String40_N.convertString((org.hl7.fhir.r4.model.StringType) src.getExtensionByUrl(TP_PUBLISHER).getValue()));
    for (org.hl7.fhir.r4.model.Extension ext : src.getExtensionsByUrl(TP_CONTACT))
      tgt.getContactList().add(ContactDetail40_N.convertContactDetail((org.hl7.fhir.r4.model.ContactDetail) ext.getValue()));
    if (src.hasExtension(TP_DESCRIPTION))
      tgt.setDescriptionElement(MarkDown40_N.convertMarkdown((org.hl7.fhir.r4.model.MarkdownType) src.getExtensionByUrl(TP_DESCRIPTION).getValue()));
    for (org.hl7.fhir.r4.model.Extension ext : src.getExtensionsByUrl(TP_USE_CONTEXT))
      tgt.getUseContextList().add(UsageContext40_N.convertUsageContext((org.hl7.fhir.r4.model.UsageContext) ext.getValue()));
    for (org.hl7.fhir.r4.model.Extension ext : src.getExtensionsByUrl(TP_JURISDICTION))
      tgt.getJurisdictionList().add(CodeableConcept40_N.convertCodeableConcept((org.hl7.fhir.r4.model.CodeableConcept) ext.getValue()));
    if (src.hasExtension(TP_PURPOSE))
      tgt.setPurposeElement(MarkDown40_N.convertMarkdown((org.hl7.fhir.r4.model.MarkdownType) src.getExtensionByUrl(TP_PURPOSE).getValue()));
    if (src.hasExtension(TP_COPYRIGHT))
      tgt.setCopyrightElement(MarkDown40_N.convertMarkdown((org.hl7.fhir.r4.model.MarkdownType) src.getExtensionByUrl(TP_COPYRIGHT).getValue()));
    if (src.hasExtension(TP_COPYRIGHT_LABEL))
      tgt.setCopyrightLabelElement(String40_N.convertString((org.hl7.fhir.r4.model.StringType) src.getExtensionByUrl(TP_COPYRIGHT_LABEL).getValue()));
    for (org.hl7.fhir.r4.model.Extension ext : src.getExtensionsByUrl(TP_SCOPE))
      convertTestPlanScope(ext, tgt.addScope());
    for (org.hl7.fhir.r4.model.Extension ext : src.getExtensionsByUrl(TP_DEPENDENCY))
      convertTestPlanDependency(ext, tgt.addDependency());
    if (src.hasExtension(TP_RUNNER))
      tgt.setRunnerElement(Url40_N.convertUrl((org.hl7.fhir.r4.model.UrlType) src.getExtensionByUrl(TP_RUNNER).getValue()));
    for (org.hl7.fhir.r4.model.Extension ext : src.getExtensionsByUrl(TP_MODE))
      convertTestPlanMode(ext, tgt.addMode());
    for (org.hl7.fhir.r4.model.Extension ext : src.getExtensionsByUrl(TP_PARAMETER))
      convertTestPlanParameter(ext, tgt.addParameter());
    for (org.hl7.fhir.r4.model.Extension ext : src.getExtensionsByUrl(TP_SUITE))
      convertTestPlanSuite(ext, tgt.addSuite(), src);
    // the input resources were carried as contained resources (id "tpc-N") and have now been
    // re-inlined into their inputs; drop them from the resource-level contained list that
    // copyDomainResource brought across
    tgt.getContained().removeIf(r -> r.hasId() && r.getIdPart() != null && r.getIdPart().startsWith("tpc-"));
    return tgt;
  }

  private static void convertTestPlanScope(org.hl7.fhir.model.testing.TestPlan.TestPlanScopeComponent src, org.hl7.fhir.r4.model.Extension tgt) throws FHIRException {
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasReference())
      tgt.addExtension("reference", Canonical40_N.convertCanonical(src.getReferenceElement()));
    if (src.hasDescription())
      tgt.addExtension("description", String40_N.convertString(src.getDescriptionElement()));
  }

  private static void convertTestPlanScope(org.hl7.fhir.r4.model.Extension src, org.hl7.fhir.model.testing.TestPlan.TestPlanScopeComponent tgt) throws FHIRException {
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt, "reference", "description");
    if (src.hasExtension("reference"))
      tgt.setReferenceElement(Canonical40_N.convertCanonical((org.hl7.fhir.r4.model.CanonicalType) src.getExtensionByUrl("reference").getValue()));
    if (src.hasExtension("description"))
      tgt.setDescriptionElement(String40_N.convertString((org.hl7.fhir.r4.model.StringType) src.getExtensionByUrl("description").getValue()));
  }

  private static void convertTestPlanDependency(org.hl7.fhir.model.testing.TestPlan.TestPlanDependencyComponent src, org.hl7.fhir.r4.model.Extension tgt) throws FHIRException {
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasReference())
      tgt.addExtension("reference", Canonical40_N.convertCanonical(src.getReferenceElement()));
    if (src.hasDescription())
      tgt.addExtension("description", String40_N.convertString(src.getDescriptionElement()));
  }

  private static void convertTestPlanDependency(org.hl7.fhir.r4.model.Extension src, org.hl7.fhir.model.testing.TestPlan.TestPlanDependencyComponent tgt) throws FHIRException {
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt, "reference", "description");
    if (src.hasExtension("reference"))
      tgt.setReferenceElement(Canonical40_N.convertCanonical((org.hl7.fhir.r4.model.CanonicalType) src.getExtensionByUrl("reference").getValue()));
    if (src.hasExtension("description"))
      tgt.setDescriptionElement(String40_N.convertString((org.hl7.fhir.r4.model.StringType) src.getExtensionByUrl("description").getValue()));
  }

  private static void convertTestPlanMode(org.hl7.fhir.model.testing.TestPlan.TestPlanModeComponent src, org.hl7.fhir.r4.model.Extension tgt) throws FHIRException {
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasCode())
      tgt.addExtension("code", String40_N.convertString(src.getCodeElement()));
    if (src.hasDescription())
      tgt.addExtension("description", String40_N.convertString(src.getDescriptionElement()));
  }

  private static void convertTestPlanMode(org.hl7.fhir.r4.model.Extension src, org.hl7.fhir.model.testing.TestPlan.TestPlanModeComponent tgt) throws FHIRException {
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt, "code", "description");
    if (src.hasExtension("code"))
      tgt.setCodeElement(String40_N.convertString((org.hl7.fhir.r4.model.StringType) src.getExtensionByUrl("code").getValue()));
    if (src.hasExtension("description"))
      tgt.setDescriptionElement(String40_N.convertString((org.hl7.fhir.r4.model.StringType) src.getExtensionByUrl("description").getValue()));
  }

  private static void convertTestPlanParameter(org.hl7.fhir.model.testing.TestPlan.TestPlanParameterComponent src, org.hl7.fhir.r4.model.Extension tgt) throws FHIRException {
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasName())
      tgt.addExtension("name", String40_N.convertString(src.getNameElement()));
    if (src.hasValue())
      tgt.addExtension("value", ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getValue()));
    if (src.hasMode())
      tgt.addExtension("mode", Code40_N.convertCode(src.getModeElement()));
  }

  private static void convertTestPlanParameter(org.hl7.fhir.r4.model.Extension src, org.hl7.fhir.model.testing.TestPlan.TestPlanParameterComponent tgt) throws FHIRException {
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt, "name", "value", "mode");
    if (src.hasExtension("name"))
      tgt.setNameElement(String40_N.convertString((org.hl7.fhir.r4.model.StringType) src.getExtensionByUrl("name").getValue()));
    if (src.hasExtension("value"))
      tgt.setValue(ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().convertType(src.getExtensionByUrl("value").getValue()));
    if (src.hasExtension("mode"))
      tgt.setModeElement(Code40_N.convertCode((org.hl7.fhir.r4.model.CodeType) src.getExtensionByUrl("mode").getValue()));
  }

  private static void convertTestPlanSuite(org.hl7.fhir.model.testing.TestPlan.TestPlanSuiteComponent src, org.hl7.fhir.r4.model.Extension tgt, org.hl7.fhir.r4.model.Basic basic) throws FHIRException {
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasName())
      tgt.addExtension("name", String40_N.convertString(src.getNameElement()));
    if (src.hasDescription())
      tgt.addExtension("description", String40_N.convertString(src.getDescriptionElement()));
    if (src.hasMode())
      tgt.addExtension("mode", Code40_N.convertCode(src.getModeElement()));
    for (org.hl7.fhir.model.testing.TestPlan.TestPlanSuiteInputComponent t : src.getInputList()) {
      org.hl7.fhir.r4.model.Extension e = new org.hl7.fhir.r4.model.Extension("input");
      tgt.addExtension(e);
      convertTestPlanSuiteInput(t, e, basic);
    }
    for (org.hl7.fhir.model.testing.TestPlan.TestPlanParameterComponent t : src.getParameterList()) {
      org.hl7.fhir.r4.model.Extension e = new org.hl7.fhir.r4.model.Extension("parameter");
      tgt.addExtension(e);
      convertTestPlanParameter(t, e);
    }
    for (org.hl7.fhir.model.testing.TestPlan.TestPlanSuiteTestComponent t : src.getTestList()) {
      org.hl7.fhir.r4.model.Extension e = new org.hl7.fhir.r4.model.Extension("test");
      tgt.addExtension(e);
      convertTestPlanSuiteTest(t, e, basic);
    }
    for (org.hl7.fhir.model.testing.TestPlan.TestPlanSuiteComponent t : src.getSuiteList()) {
      org.hl7.fhir.r4.model.Extension e = new org.hl7.fhir.r4.model.Extension("suite");
      tgt.addExtension(e);
      convertTestPlanSuite(t, e, basic);
    }
    for (org.hl7.fhir.model.core.Reference t : src.getPlanList())
      tgt.addExtension("plan", Reference40_N.convertReference(t));
  }

  private static void convertTestPlanSuite(org.hl7.fhir.r4.model.Extension src, org.hl7.fhir.model.testing.TestPlan.TestPlanSuiteComponent tgt, org.hl7.fhir.r4.model.Basic basic) throws FHIRException {
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt, "name", "description", "mode", "input", "parameter", "test", "suite", "plan");
    if (src.hasExtension("name"))
      tgt.setNameElement(String40_N.convertString((org.hl7.fhir.r4.model.StringType) src.getExtensionByUrl("name").getValue()));
    if (src.hasExtension("description"))
      tgt.setDescriptionElement(String40_N.convertString((org.hl7.fhir.r4.model.StringType) src.getExtensionByUrl("description").getValue()));
    if (src.hasExtension("mode"))
      tgt.setModeElement(Code40_N.convertCode((org.hl7.fhir.r4.model.CodeType) src.getExtensionByUrl("mode").getValue()));
    for (org.hl7.fhir.r4.model.Extension ext : src.getExtensionsByUrl("input"))
      convertTestPlanSuiteInput(ext, tgt.addInput(), basic);
    for (org.hl7.fhir.r4.model.Extension ext : src.getExtensionsByUrl("parameter"))
      convertTestPlanParameter(ext, tgt.addParameter());
    for (org.hl7.fhir.r4.model.Extension ext : src.getExtensionsByUrl("test"))
      convertTestPlanSuiteTest(ext, tgt.addTest(), basic);
    for (org.hl7.fhir.r4.model.Extension ext : src.getExtensionsByUrl("suite"))
      convertTestPlanSuite(ext, tgt.addSuite(), basic);
    for (org.hl7.fhir.r4.model.Extension ext : src.getExtensionsByUrl("plan"))
      tgt.getPlanList().add(Reference40_N.convertReference((Reference) ext.getValue()));
  }

  private static void convertTestPlanSuiteInput(org.hl7.fhir.model.testing.TestPlan.TestPlanSuiteInputComponent src, org.hl7.fhir.r4.model.Extension tgt, org.hl7.fhir.r4.model.Basic basic) throws FHIRException {
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasName())
      tgt.addExtension("name", String40_N.convertString(src.getNameElement()));
    if (src.hasFile())
      tgt.addExtension("file", String40_N.convertString(src.getFileElement()));
    if (src.hasResource()) {
      org.hl7.fhir.r4.model.Resource r = VersionConvertorFactory_40_N.convertResource(src.getResource());
      String id = "tpc-" + (basic.getContained().size() + 1);
      r.setId(id);
      basic.getContained().add(r);
      tgt.addExtension("resource", new Reference("#" + id));
    }
    if (src.hasMode())
      tgt.addExtension("mode", Code40_N.convertCode(src.getModeElement()));
  }

  private static void convertTestPlanSuiteInput(org.hl7.fhir.r4.model.Extension src, org.hl7.fhir.model.testing.TestPlan.TestPlanSuiteInputComponent tgt, org.hl7.fhir.r4.model.Basic basic) throws FHIRException {
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt, "name", "file", "resource", "mode");
    if (src.hasExtension("name"))
      tgt.setNameElement(String40_N.convertString((org.hl7.fhir.r4.model.StringType) src.getExtensionByUrl("name").getValue()));
    if (src.hasExtension("file"))
      tgt.setFileElement(String40_N.convertString((org.hl7.fhir.r4.model.StringType) src.getExtensionByUrl("file").getValue()));
    if (src.hasExtension("resource")) {
      String ref = ((Reference) src.getExtensionByUrl("resource").getValue()).getReference();
      String id = ref != null && ref.startsWith("#") ? ref.substring(1) : ref;
      for (org.hl7.fhir.r4.model.Resource c : basic.getContained()) {
        if (id != null && id.equals(c.getIdPart())) {
          Resource r = VersionConvertorFactory_40_N.convertResource(c);
          if (r.hasId() && r.getIdPart() != null && r.getIdPart().startsWith("tpc-"))
            r.setIdBase(null);
          tgt.setResource(r);
        }
      }
    }
    if (src.hasExtension("mode"))
      tgt.setModeElement(Code40_N.convertCode((org.hl7.fhir.r4.model.CodeType) src.getExtensionByUrl("mode").getValue()));
  }

  private static void convertTestPlanSuiteTest(org.hl7.fhir.model.testing.TestPlan.TestPlanSuiteTestComponent src, org.hl7.fhir.r4.model.Extension tgt, org.hl7.fhir.r4.model.Basic basic) throws FHIRException {
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasName())
      tgt.addExtension("name", String40_N.convertString(src.getNameElement()));
    if (src.hasDescription())
      tgt.addExtension("description", String40_N.convertString(src.getDescriptionElement()));
    if (src.hasOperation())
      tgt.addExtension("operation", Code40_N.convertCode(src.getOperationElement()));
    if (src.hasMode())
      tgt.addExtension("mode", Code40_N.convertCode(src.getModeElement()));
    for (org.hl7.fhir.model.testing.TestPlan.TestPlanParameterComponent t : src.getParameterList()) {
      org.hl7.fhir.r4.model.Extension e = new org.hl7.fhir.r4.model.Extension("parameter");
      tgt.addExtension(e);
      convertTestPlanParameter(t, e);
    }
    for (org.hl7.fhir.model.testing.TestPlan.TestPlanSuiteInputComponent t : src.getInputList()) {
      org.hl7.fhir.r4.model.Extension e = new org.hl7.fhir.r4.model.Extension("input");
      tgt.addExtension(e);
      convertTestPlanSuiteInput(t, e, basic);
    }
    for (org.hl7.fhir.model.testing.TestPlan.TestPlanSuiteInputComponent t : src.getExpectedList()) {
      org.hl7.fhir.r4.model.Extension e = new org.hl7.fhir.r4.model.Extension("expected");
      tgt.addExtension(e);
      convertTestPlanSuiteInput(t, e, basic);
    }
    for (org.hl7.fhir.model.testing.TestPlan.TestPlanSuiteTestAssertionComponent t : src.getAssertionList()) {
      org.hl7.fhir.r4.model.Extension e = new org.hl7.fhir.r4.model.Extension("assertion");
      tgt.addExtension(e);
      convertTestPlanAssertion(t, e);
    }
  }

  private static void convertTestPlanSuiteTest(org.hl7.fhir.r4.model.Extension src, org.hl7.fhir.model.testing.TestPlan.TestPlanSuiteTestComponent tgt, org.hl7.fhir.r4.model.Basic basic) throws FHIRException {
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt, "name", "description", "operation", "mode", "parameter", "input", "expected", "assertion");
    if (src.hasExtension("name"))
      tgt.setNameElement(String40_N.convertString((org.hl7.fhir.r4.model.StringType) src.getExtensionByUrl("name").getValue()));
    if (src.hasExtension("description"))
      tgt.setDescriptionElement(String40_N.convertString((org.hl7.fhir.r4.model.StringType) src.getExtensionByUrl("description").getValue()));
    if (src.hasExtension("operation"))
      tgt.setOperationElement(Code40_N.convertCode((org.hl7.fhir.r4.model.CodeType) src.getExtensionByUrl("operation").getValue()));
    if (src.hasExtension("mode"))
      tgt.setModeElement(Code40_N.convertCode((org.hl7.fhir.r4.model.CodeType) src.getExtensionByUrl("mode").getValue()));
    for (org.hl7.fhir.r4.model.Extension ext : src.getExtensionsByUrl("parameter"))
      convertTestPlanParameter(ext, tgt.addParameter());
    for (org.hl7.fhir.r4.model.Extension ext : src.getExtensionsByUrl("input"))
      convertTestPlanSuiteInput(ext, tgt.addInput(), basic);
    for (org.hl7.fhir.r4.model.Extension ext : src.getExtensionsByUrl("expected"))
      convertTestPlanSuiteInput(ext, tgt.addExpected(), basic);
    for (org.hl7.fhir.r4.model.Extension ext : src.getExtensionsByUrl("assertion"))
      convertTestPlanAssertion(ext, tgt.addAssertion());
  }

  private static void convertTestPlanAssertion(org.hl7.fhir.model.testing.TestPlan.TestPlanSuiteTestAssertionComponent src, org.hl7.fhir.r4.model.Extension tgt) throws FHIRException {
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt);
    if (src.hasFocus())
      tgt.addExtension("focus", String40_N.convertString(src.getFocusElement()));
    if (src.hasSeverity())
      tgt.addExtension("severity", Code40_N.convertCode(src.getSeverityElement()));
    if (src.hasExpression())
      tgt.addExtension("expression", Expression40_N.convertExpression(src.getExpression()));
    if (src.hasHuman())
      tgt.addExtension("human", String40_N.convertString(src.getHumanElement()));
    if (src.hasMode())
      tgt.addExtension("mode", Code40_N.convertCode(src.getModeElement()));
  }

  private static void convertTestPlanAssertion(org.hl7.fhir.r4.model.Extension src, org.hl7.fhir.model.testing.TestPlan.TestPlanSuiteTestAssertionComponent tgt) throws FHIRException {
    ConversionContext40_N.INSTANCE.getVersionConvertor_40_N().copyElement(src, tgt, "focus", "severity", "expression", "human", "mode");
    if (src.hasExtension("focus"))
      tgt.setFocusElement(String40_N.convertString((org.hl7.fhir.r4.model.StringType) src.getExtensionByUrl("focus").getValue()));
    if (src.hasExtension("severity"))
      tgt.setSeverityElement(Code40_N.convertCode((org.hl7.fhir.r4.model.CodeType) src.getExtensionByUrl("severity").getValue()));
    if (src.hasExtension("expression"))
      tgt.setExpression(Expression40_N.convertExpression((org.hl7.fhir.r4.model.Expression) src.getExtensionByUrl("expression").getValue()));
    if (src.hasExtension("human"))
      tgt.setHumanElement(String40_N.convertString((org.hl7.fhir.r4.model.StringType) src.getExtensionByUrl("human").getValue()));
    if (src.hasExtension("mode"))
      tgt.setModeElement(Code40_N.convertCode((org.hl7.fhir.r4.model.CodeType) src.getExtensionByUrl("mode").getValue()));
  }

}