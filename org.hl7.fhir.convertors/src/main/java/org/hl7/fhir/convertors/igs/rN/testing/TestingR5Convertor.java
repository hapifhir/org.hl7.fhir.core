package org.hl7.fhir.convertors.igs.rN.testing;

import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.convertors.context.ConversionContext50_N;
import org.hl7.fhir.convertors.igs.VersionConvertorIGBase;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.testing.TestReport;
import org.hl7.fhir.model.testing.TestPlan;
import org.hl7.fhir.model.testing.TestScript;
import org.hl7.fhir.model.testing.TestScript.TestScriptScopeComponent;
import org.hl7.fhir.r5.model.*;

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
public class TestingR5Convertor extends VersionConvertorIGBase {

  @Override
  public boolean handlesRNToR5(String s) {
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
  public Resource convertRNToR5(org.hl7.fhir.model.core.Resource source) {
    // the field converters get the version convertor from ConversionContext50_N, which is only
    // set up inside VersionConvertor_50_N.convertResource - so set it up here too
    org.hl7.fhir.convertors.conv50_N.VersionConvertor_50_N vc = new org.hl7.fhir.convertors.conv50_N.VersionConvertor_50_N(new org.hl7.fhir.convertors.advisors.impl.BaseAdvisor_50_N());
    ConversionContext50_N.INSTANCE.init(vc);
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
      ConversionContext50_N.INSTANCE.close();
    }
  }

  // TestScript.scope exists natively in both R5 and the testing-IG (R6) model, so it is mapped
  // component-to-component (unlike the R4 converter, which has to carry it as a cross-version extension).
  public static TestScriptScopeComponent convertTestScriptScopeComponent(org.hl7.fhir.r5.model.TestScript.TestScriptScopeComponent src) throws FHIRException {
    if (src == null)
      return null;
    TestScriptScopeComponent tgt = new TestScriptScopeComponent();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyBackboneElement(src, tgt);
    if (src.hasArtifact())
      tgt.setArtifactElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Canonical50_N.convertCanonical(src.getArtifactElement()));
    if (src.hasConformance())
      tgt.setConformance(org.hl7.fhir.convertors.conv50_N.datatypes50_N.general50_N.CodeableConcept50_N.convertCodeableConcept(src.getConformance()));
    if (src.hasPhase())
      tgt.setPhase(org.hl7.fhir.convertors.conv50_N.datatypes50_N.general50_N.CodeableConcept50_N.convertCodeableConcept(src.getPhase()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestScript.TestScriptScopeComponent convertTestScriptScopeComponent(TestScriptScopeComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestScript.TestScriptScopeComponent tgt = new org.hl7.fhir.r5.model.TestScript.TestScriptScopeComponent();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyBackboneElement(src, tgt);
    if (src.hasArtifact())
      tgt.setArtifactElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Canonical50_N.convertCanonical(src.getArtifactElement()));
    if (src.hasConformance())
      tgt.setConformance(org.hl7.fhir.convertors.conv50_N.datatypes50_N.general50_N.CodeableConcept50_N.convertCodeableConcept(src.getConformance()));
    if (src.hasPhase())
      tgt.setPhase(org.hl7.fhir.convertors.conv50_N.datatypes50_N.general50_N.CodeableConcept50_N.convertCodeableConcept(src.getPhase()));
    return tgt;
  }


  public static TestReport convertTestReport(org.hl7.fhir.r5.model.TestReport src) throws FHIRException {
    if (src == null)
      return null;
    TestReport tgt = new TestReport();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyDomainResource(src, tgt, EXT_TESTREPORT_DESCRIPTION);
    if (src.hasExtension(EXT_TESTREPORT_DESCRIPTION)) {
      // TestReport.description (top-level) is R6-only; recover it from the cross-version extension
      tgt.setDescriptionElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.MarkDown50_N.convertMarkDown((MarkdownType) src.getExtensionByUrl(EXT_TESTREPORT_DESCRIPTION).getValue()));
    }
    if (src.hasIdentifier())
      tgt.setIdentifier(org.hl7.fhir.convertors.conv50_N.datatypes50_N.general50_N.Identifier50_N.convertIdentifier(src.getIdentifier()));
    if (src.hasName())
      tgt.setNameElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getNameElement()));
    if (src.hasStatus())
      tgt.setStatusElement(convertTestReportStatus(src.getStatusElement()));
    if (src.hasTestScript())
      tgt.setTestScriptElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Canonical50_N.convertCanonical(src.getTestScriptElement()));
    if (src.hasResult())
      tgt.setResultElement(convertTestReportResult(src.getResultElement()));
    if (src.hasScore())
      tgt.setScoreElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Decimal50_N.convertDecimal(src.getScoreElement()));
    if (src.hasTester())
      tgt.setTesterElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getTesterElement()));
    if (src.hasIssued())
      tgt.setIssuedElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.DateTime50_N.convertDateTime(src.getIssuedElement()));
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

  public static org.hl7.fhir.r5.model.TestReport convertTestReport(TestReport src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestReport tgt = new org.hl7.fhir.r5.model.TestReport();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyDomainResource(src, tgt);
    if (src.hasDescription()) {
      // TestReport.description has no R4 home; carry it as a cross-version extension
      Extension ext = tgt.addExtension();
      ext.setUrl(EXT_TESTREPORT_DESCRIPTION);
      ext.setValue(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.MarkDown50_N.convertMarkDown(src.getDescriptionElement()));
    }
    if (src.hasIdentifier())
      tgt.setIdentifier(org.hl7.fhir.convertors.conv50_N.datatypes50_N.general50_N.Identifier50_N.convertIdentifier(src.getIdentifier()));
    if (src.hasName())
      tgt.setNameElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getNameElement()));
    if (src.hasStatus())
      tgt.setStatusElement(convertTestReportStatusToR5(src.getStatusElement()));
    if (src.hasTestScript())
      tgt.setTestScriptElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Canonical50_N.convertCanonical(src.getTestScriptElement()));
    if (src.hasResult())
      tgt.setResultElement(convertTestReportResultToR5(src.getResultElement()));
    if (src.hasScore())
      tgt.setScoreElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Decimal50_N.convertDecimal(src.getScoreElement()));
    if (src.hasTester())
      tgt.setTesterElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getTesterElement()));
    if (src.hasIssued())
      tgt.setIssuedElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.DateTime50_N.convertDateTime(src.getIssuedElement()));
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

  static public org.hl7.fhir.model.core.Enumeration<TestReport.TestReportStatusValueSet> convertTestReportStatus(Enumeration<org.hl7.fhir.r5.model.TestReport.TestReportStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.model.core.Enumeration<TestReport.TestReportStatusValueSet> tgt = new org.hl7.fhir.model.core.Enumeration<>(new TestReport.TestReportStatusValueSetEnumFactory());
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
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

  static public Enumeration<org.hl7.fhir.r5.model.TestReport.TestReportStatus> convertTestReportStatusToR5(org.hl7.fhir.model.core.Enumeration<TestReport.TestReportStatusValueSet> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<org.hl7.fhir.r5.model.TestReport.TestReportStatus> tgt = new Enumeration<>(new org.hl7.fhir.r5.model.TestReport.TestReportStatusEnumFactory());
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
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
      }
      return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<TestReport.TestReportResultValueSet> convertTestReportResult(Enumeration<org.hl7.fhir.r5.model.TestReport.TestReportResult> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.model.core.Enumeration<TestReport.TestReportResultValueSet> tgt = new org.hl7.fhir.model.core.Enumeration<>(new TestReport.TestReportResultValueSetEnumFactory());
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
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

  static public Enumeration<org.hl7.fhir.r5.model.TestReport.TestReportResult> convertTestReportResultToR5(org.hl7.fhir.model.core.Enumeration<TestReport.TestReportResultValueSet> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<org.hl7.fhir.r5.model.TestReport.TestReportResult> tgt = new Enumeration<>(new org.hl7.fhir.r5.model.TestReport.TestReportResultEnumFactory());
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
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
      }
      return tgt;
  }

  public static TestReport.TestReportParticipantComponent convertTestReportParticipantComponent(org.hl7.fhir.r5.model.TestReport.TestReportParticipantComponent src) throws FHIRException {
    if (src == null)
      return null;
    TestReport.TestReportParticipantComponent tgt = new TestReport.TestReportParticipantComponent();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setTypeElement(convertTestReportParticipantType(src.getTypeElement()));
    if (src.hasUri())
      tgt.setUriElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Uri50_N.convertUri(src.getUriElement()));
    if (src.hasDisplay())
      tgt.setDisplayElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getDisplayElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestReport.TestReportParticipantComponent convertTestReportParticipantComponent(TestReport.TestReportParticipantComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestReport.TestReportParticipantComponent tgt = new org.hl7.fhir.r5.model.TestReport.TestReportParticipantComponent();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setTypeElement(convertTestReportParticipantTypeToR5(src.getTypeElement()));
    if (src.hasUri())
      tgt.setUriElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Uri50_N.convertUri(src.getUriElement()));
    if (src.hasDisplay())
      tgt.setDisplayElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getDisplayElement()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<TestReport.TestReportParticipantTypeValueSet> convertTestReportParticipantType(Enumeration<org.hl7.fhir.r5.model.TestReport.TestReportParticipantType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.model.core.Enumeration<TestReport.TestReportParticipantTypeValueSet> tgt = new org.hl7.fhir.model.core.Enumeration<>(new TestReport.TestReportParticipantTypeValueSetEnumFactory());
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
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

  static public Enumeration<org.hl7.fhir.r5.model.TestReport.TestReportParticipantType> convertTestReportParticipantTypeToR5(org.hl7.fhir.model.core.Enumeration<TestReport.TestReportParticipantTypeValueSet> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<org.hl7.fhir.r5.model.TestReport.TestReportParticipantType> tgt = new Enumeration<>(new org.hl7.fhir.r5.model.TestReport.TestReportParticipantTypeEnumFactory());
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
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
      }
      return tgt;
  }

  public static TestReport.TestReportSetupComponent convertTestReportSetupComponent(org.hl7.fhir.r5.model.TestReport.TestReportSetupComponent src) throws FHIRException {
    if (src == null)
      return null;
    TestReport.TestReportSetupComponent tgt = new TestReport.TestReportSetupComponent();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r5.model.TestReport.SetupActionComponent t : src.getAction())
      tgt.addAction(convertSetupActionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestReport.TestReportSetupComponent convertTestReportSetupComponent(TestReport.TestReportSetupComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestReport.TestReportSetupComponent tgt = new org.hl7.fhir.r5.model.TestReport.TestReportSetupComponent();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyBackboneElement(src, tgt);
    for (TestReport.SetupActionComponent t : src.getActionList())
      tgt.addAction(convertSetupActionComponent(t));
    return tgt;
  }

  public static TestReport.SetupActionComponent convertSetupActionComponent(org.hl7.fhir.r5.model.TestReport.SetupActionComponent src) throws FHIRException {
    if (src == null)
      return null;
    TestReport.SetupActionComponent tgt = new TestReport.SetupActionComponent();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyBackboneElement(src, tgt);
    if (src.hasOperation())
      tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    if (src.hasAssert())
      tgt.setAssert(convertSetupActionAssertComponent(src.getAssert()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestReport.SetupActionComponent convertSetupActionComponent(TestReport.SetupActionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestReport.SetupActionComponent tgt = new org.hl7.fhir.r5.model.TestReport.SetupActionComponent();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyBackboneElement(src, tgt);
    if (src.hasOperation())
      tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    if (src.hasAssert())
      tgt.setAssert(convertSetupActionAssertComponent(src.getAssert()));
    return tgt;
  }

  public static TestReport.SetupActionOperationComponent convertSetupActionOperationComponent(org.hl7.fhir.r5.model.TestReport.SetupActionOperationComponent src) throws FHIRException {
    if (src == null)
      return null;
    TestReport.SetupActionOperationComponent tgt = new TestReport.SetupActionOperationComponent();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyBackboneElement(src, tgt);
    if (src.hasResult())
      tgt.setResultElement(convertTestReportActionResult(src.getResultElement()));
    if (src.hasMessage())
      tgt.setMessageElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.MarkDown50_N.convertMarkDown(src.getMessageElement()));
    if (src.hasDetail())
      tgt.setDetailElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Uri50_N.convertUri(src.getDetailElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestReport.SetupActionOperationComponent convertSetupActionOperationComponent(TestReport.SetupActionOperationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestReport.SetupActionOperationComponent tgt = new org.hl7.fhir.r5.model.TestReport.SetupActionOperationComponent();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyBackboneElement(src, tgt);
    if (src.hasResult())
      tgt.setResultElement(convertTestReportActionResultToR5(src.getResultElement()));
    if (src.hasMessage())
      tgt.setMessageElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.MarkDown50_N.convertMarkDown(src.getMessageElement()));
    if (src.hasDetail())
      tgt.setDetailElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Uri50_N.convertUri(src.getDetailElement()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<TestReport.TestReportActionResultValueSet> convertTestReportActionResult(Enumeration<org.hl7.fhir.r5.model.TestReport.TestReportActionResult> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.model.core.Enumeration<TestReport.TestReportActionResultValueSet> tgt = new org.hl7.fhir.model.core.Enumeration<>(new TestReport.TestReportActionResultValueSetEnumFactory());
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
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

  static public Enumeration<org.hl7.fhir.r5.model.TestReport.TestReportActionResult> convertTestReportActionResultToR5(org.hl7.fhir.model.core.Enumeration<TestReport.TestReportActionResultValueSet> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<org.hl7.fhir.r5.model.TestReport.TestReportActionResult> tgt = new Enumeration<>(new org.hl7.fhir.r5.model.TestReport.TestReportActionResultEnumFactory());
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
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
      }
      return tgt;
  }

  public static TestReport.SetupActionAssertComponent convertSetupActionAssertComponent(org.hl7.fhir.r5.model.TestReport.SetupActionAssertComponent src) throws FHIRException {
    if (src == null)
      return null;
    TestReport.SetupActionAssertComponent tgt = new TestReport.SetupActionAssertComponent();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyBackboneElement(src, tgt);
    if (src.hasResult())
      tgt.setResultElement(convertTestReportActionResult(src.getResultElement()));
    if (src.hasMessage())
      tgt.setMessageElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.MarkDown50_N.convertMarkDown(src.getMessageElement()));
    if (src.hasDetail())
      tgt.setDetailElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getDetailElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestReport.SetupActionAssertComponent convertSetupActionAssertComponent(TestReport.SetupActionAssertComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestReport.SetupActionAssertComponent tgt = new org.hl7.fhir.r5.model.TestReport.SetupActionAssertComponent();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyBackboneElement(src, tgt);
    if (src.hasResult())
      tgt.setResultElement(convertTestReportActionResultToR5(src.getResultElement()));
    if (src.hasMessage())
      tgt.setMessageElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.MarkDown50_N.convertMarkDown(src.getMessageElement()));
    if (src.hasDetail())
      tgt.setDetailElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getDetailElement()));
    return tgt;
  }

  public static TestReport.TestReportTestComponent convertTestReportTestComponent(org.hl7.fhir.r5.model.TestReport.TestReportTestComponent src) throws FHIRException {
    if (src == null)
      return null;
    TestReport.TestReportTestComponent tgt = new TestReport.TestReportTestComponent();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getNameElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getDescriptionElement()));
    for (org.hl7.fhir.r5.model.TestReport.TestActionComponent t : src.getAction())
      tgt.addAction(convertTestActionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestReport.TestReportTestComponent convertTestReportTestComponent(TestReport.TestReportTestComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestReport.TestReportTestComponent tgt = new org.hl7.fhir.r5.model.TestReport.TestReportTestComponent();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getNameElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getDescriptionElement()));
    for (TestReport.TestActionComponent t : src.getActionList())
      tgt.addAction(convertTestActionComponent(t));
    return tgt;
  }

  public static TestReport.TestActionComponent convertTestActionComponent(org.hl7.fhir.r5.model.TestReport.TestActionComponent src) throws FHIRException {
    if (src == null)
      return null;
    TestReport.TestActionComponent tgt = new TestReport.TestActionComponent();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyBackboneElement(src, tgt);
    if (src.hasOperation())
      tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    if (src.hasAssert())
      tgt.setAssert(convertSetupActionAssertComponent(src.getAssert()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestReport.TestActionComponent convertTestActionComponent(TestReport.TestActionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestReport.TestActionComponent tgt = new org.hl7.fhir.r5.model.TestReport.TestActionComponent();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyBackboneElement(src, tgt);
    if (src.hasOperation())
      tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    if (src.hasAssert())
      tgt.setAssert(convertSetupActionAssertComponent(src.getAssert()));
    return tgt;
  }

  public static TestReport.TestReportTeardownComponent convertTestReportTeardownComponent(org.hl7.fhir.r5.model.TestReport.TestReportTeardownComponent src) throws FHIRException {
    if (src == null)
      return null;
    TestReport.TestReportTeardownComponent tgt = new TestReport.TestReportTeardownComponent();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r5.model.TestReport.TeardownActionComponent t : src.getAction())
      tgt.addAction(convertTeardownActionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestReport.TestReportTeardownComponent convertTestReportTeardownComponent(TestReport.TestReportTeardownComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestReport.TestReportTeardownComponent tgt = new org.hl7.fhir.r5.model.TestReport.TestReportTeardownComponent();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyBackboneElement(src, tgt);
    for (TestReport.TeardownActionComponent t : src.getActionList())
      tgt.addAction(convertTeardownActionComponent(t));
    return tgt;
  }

  public static TestReport.TeardownActionComponent convertTeardownActionComponent(org.hl7.fhir.r5.model.TestReport.TeardownActionComponent src) throws FHIRException {
    if (src == null)
      return null;
    TestReport.TeardownActionComponent tgt = new TestReport.TeardownActionComponent();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyBackboneElement(src, tgt);
    if (src.hasOperation())
      tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestReport.TeardownActionComponent convertTeardownActionComponent(TestReport.TeardownActionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestReport.TeardownActionComponent tgt = new org.hl7.fhir.r5.model.TestReport.TeardownActionComponent();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyBackboneElement(src, tgt);
    if (src.hasOperation())
      tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    return tgt;
  }

  private static final String EXT_TESTREPORT_DESCRIPTION = "http://hl7.org/fhir/6.0/StructureDefinition/extension-TestReport.description";
  private static final String EXT_TS_ORIGIN_PROFILE = "http://hl7.org/fhir/3.0/StructureDefinition/extension-TestScript.origin.profile";
  private static final String EXT_TS_TESTSYSTEM = "http://hl7.org/fhir/6.0/StructureDefinition/extension-TestScript.testSystem";
  private static final String EXT_TS_DEST_PROFILE = "http://hl7.org/fhir/3.0/StructureDefinition/extension-TestScript.destination.profile";


  public static TestScript convertTestScript(org.hl7.fhir.r5.model.TestScript src) throws FHIRException {
    if (src == null)
      return null;
    TestScript tgt = new TestScript();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyDomainResource(src, tgt, EXT_TS_TESTSYSTEM);
    for (org.hl7.fhir.r5.model.TestScript.TestScriptScopeComponent t : src.getScope())
      tgt.addScope(convertTestScriptScopeComponent(t));
    if (src.hasUrl())
      tgt.setUrlElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Uri50_N.convertUri(src.getUrlElement()));
    for (Identifier t : src.getIdentifier())
      tgt.addIdentifier(org.hl7.fhir.convertors.conv50_N.datatypes50_N.general50_N.Identifier50_N.convertIdentifier(t));
    if (src.hasVersion())
      tgt.setVersionElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getTitleElement()));
    if (src.hasStatus())
      tgt.setStatusElement(org.hl7.fhir.convertors.conv50_N.resources50_N.Enumerations50_N.convertPublicationStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Boolean50_N.convertBoolean(src.getExperimentalElement()));
    if (src.hasDate())
      tgt.setDateElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.DateTime50_N.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getPublisherElement()));
    for (ContactDetail t : src.getContact())
      tgt.addContact(org.hl7.fhir.convertors.conv50_N.datatypes50_N.metadata50_N.ContactDetail50_N.convertContactDetail(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.MarkDown50_N.convertMarkDown(src.getDescriptionElement()));
    for (UsageContext t : src.getUseContext())
      tgt.addUseContext(org.hl7.fhir.convertors.conv50_N.datatypes50_N.metadata50_N.UsageContext50_N.convertUsageContext(t));
    for (CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction(org.hl7.fhir.convertors.conv50_N.datatypes50_N.general50_N.CodeableConcept50_N.convertCodeableConcept(t));
    if (src.hasPurpose())
      tgt.setPurposeElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.MarkDown50_N.convertMarkDown(src.getPurposeElement()));
    if (src.hasCopyright())
      tgt.setCopyrightElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.MarkDown50_N.convertMarkDown(src.getCopyrightElement()));
    for (org.hl7.fhir.r5.model.TestScript.TestScriptOriginComponent t : src.getOrigin())
      tgt.addTestSystem(convertOriginToTestSystem(t));
    for (org.hl7.fhir.r5.model.TestScript.TestScriptDestinationComponent t : src.getDestination())
      tgt.addTestSystem(convertDestinationToTestSystem(t));
    // testSystems that were neither origin nor destination were carried as cross-version extensions;
    // restore them after the origin/destination-derived testSystems
    for (Extension tse : src.getExtensionsByUrl(EXT_TS_TESTSYSTEM))
      tgt.addTestSystem(convertExtensionToTestSystem(tse));
    if (src.hasMetadata())
      tgt.setMetadata(convertTestScriptMetadataComponent(src.getMetadata()));
    for (org.hl7.fhir.r5.model.TestScript.TestScriptFixtureComponent t : src.getFixture())
      tgt.addFixture(convertTestScriptFixtureComponent(t));
    for (CanonicalType t : src.getProfile()) tgt.getProfileList().add(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Canonical50_N.convertCanonical(t));
    for (org.hl7.fhir.r5.model.TestScript.TestScriptVariableComponent t : src.getVariable())
      tgt.addVariable(convertTestScriptVariableComponent(t));
    if (src.hasSetup())
      tgt.setSetup(convertTestScriptSetupComponent(src.getSetup()));
    for (org.hl7.fhir.r5.model.TestScript.TestScriptTestComponent t : src.getTest())
      tgt.addTest(convertTestScriptTestComponent(t));
    if (src.hasTeardown())
      tgt.setTeardown(convertTestScriptTeardownComponent(src.getTeardown()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestScript convertTestScript(TestScript src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestScript tgt = new org.hl7.fhir.r5.model.TestScript();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Uri50_N.convertUri(src.getUrlElement()));
    if (src.hasIdentifier())
      tgt.addIdentifier(org.hl7.fhir.convertors.conv50_N.datatypes50_N.general50_N.Identifier50_N.convertIdentifier(src.getIdentifierFirstRep()));
    if (src.hasVersion())
      tgt.setVersionElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getVersionElement()));
    if (src.hasName())
      tgt.setNameElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.setTitleElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getTitleElement()));
    if (src.hasStatus())
      tgt.setStatusElement(org.hl7.fhir.convertors.conv50_N.resources50_N.Enumerations50_N.convertPublicationStatus(src.getStatusElement()));
    if (src.hasExperimental())
      tgt.setExperimentalElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Boolean50_N.convertBoolean(src.getExperimentalElement()));
    if (src.hasDate())
      tgt.setDateElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.DateTime50_N.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.setPublisherElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.model.core.ContactDetail t : src.getContactList())
      tgt.addContact(org.hl7.fhir.convertors.conv50_N.datatypes50_N.metadata50_N.ContactDetail50_N.convertContactDetail(t));
    if (src.hasDescription())
      tgt.setDescriptionElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.MarkDown50_N.convertMarkDown(src.getDescriptionElement()));
    for (org.hl7.fhir.model.core.UsageContext t : src.getUseContextList())
      tgt.addUseContext(org.hl7.fhir.convertors.conv50_N.datatypes50_N.metadata50_N.UsageContext50_N.convertUsageContext(t));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getJurisdictionList())
      tgt.addJurisdiction(org.hl7.fhir.convertors.conv50_N.datatypes50_N.general50_N.CodeableConcept50_N.convertCodeableConcept(t));
    if (src.hasPurpose())
      tgt.setPurposeElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.MarkDown50_N.convertMarkDown(src.getPurposeElement()));
    if (src.hasCopyright())
      tgt.setCopyrightElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.MarkDown50_N.convertMarkDown(src.getCopyrightElement()));
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
    for (org.hl7.fhir.model.core.CanonicalType t : src.getProfileList()) tgt.getProfile().add(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Canonical50_N.convertCanonical(t));
    for (TestScript.TestScriptVariableComponent t : src.getVariableList())
      tgt.addVariable(convertTestScriptVariableComponent(t));
    if (src.hasSetup())
      tgt.setSetup(convertTestScriptSetupComponent(src.getSetup()));
    for (TestScript.TestScriptTestComponent t : src.getTestList())
      tgt.addTest(convertTestScriptTestComponent(t));
    if (src.hasTeardown())
      tgt.setTeardown(convertTestScriptTeardownComponent(src.getTeardown()));
    for (TestScriptScopeComponent t : src.getScopeList())
      tgt.addScope(convertTestScriptScopeComponent(t));
    return tgt;
  }

  private static Extension convertTestSystemToExtension(TestScript.TestScriptTestSystemComponent src) throws FHIRException {
    Extension ext = new Extension(EXT_TS_TESTSYSTEM);
    if (src.hasIndex())
      addTestSystemSubExtension(ext, "index", org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.PositiveInt50_N.convertPositiveInt(src.getIndexElement()));
    if (src.hasTitle())
      addTestSystemSubExtension(ext, "title", org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getTitleElement()));
    for (org.hl7.fhir.model.core.CanonicalType a : src.getActorList())
      addTestSystemSubExtension(ext, "actor", org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Canonical50_N.convertCanonical(a));
    if (src.hasDescription())
      addTestSystemSubExtension(ext, "description", org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.MarkDown50_N.convertMarkDown(src.getDescriptionElement()));
    if (src.hasUrl())
      addTestSystemSubExtension(ext, "url", org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Url50_N.convertUrl(src.getUrlElement()));
    return ext;
  }

  private static void addTestSystemSubExtension(Extension parent, String url, DataType value) throws FHIRException {
    Extension se = parent.addExtension();
    se.setUrl(url);
    se.setValue((value).copy());
  }

  private static TestScript.TestScriptTestSystemComponent convertExtensionToTestSystem(Extension src) throws FHIRException {
    TestScript.TestScriptTestSystemComponent tgt = new TestScript.TestScriptTestSystemComponent();
    Extension se = src.getExtensionByUrl("index");
    if (se != null)
      tgt.setIndexElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.PositiveInt50_N.convertPositiveInt((PositiveIntType) se.getValue()));
    se = src.getExtensionByUrl("title");
    if (se != null)
      tgt.setTitleElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString((StringType) se.getValue()));
    for (Extension ae : src.getExtensionsByUrl("actor"))
      tgt.getActorList().add(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Canonical50_N.convertCanonical((CanonicalType) ae.getValue()));
    se = src.getExtensionByUrl("description");
    if (se != null)
      tgt.setDescriptionElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.MarkDown50_N.convertMarkDown((MarkdownType) se.getValue()));
    se = src.getExtensionByUrl("url");
    if (se != null)
      tgt.setUrlElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Url50_N.convertUrl((UrlType) se.getValue()));
    return tgt;
  }

  private static TestScript.TestScriptTestSystemComponent convertOriginToTestSystem(org.hl7.fhir.r5.model.TestScript.TestScriptOriginComponent src) throws FHIRException {
    if (src == null)
      return null;
    TestScript.TestScriptTestSystemComponent tgt = new TestScript.TestScriptTestSystemComponent();
    if (src.hasIndex())
      tgt.setIndex(src.getIndex());
    tgt.setTitle("origin");
    if (src.hasProfile())
      tgt.addExtension(EXT_TS_ORIGIN_PROFILE, org.hl7.fhir.convertors.conv50_N.datatypes50_N.general50_N.Coding50_N.convertCoding(src.getProfile()));
    return tgt;
  }

  private static TestScript.TestScriptTestSystemComponent convertDestinationToTestSystem(org.hl7.fhir.r5.model.TestScript.TestScriptDestinationComponent src) throws FHIRException {
    if (src == null)
      return null;
    TestScript.TestScriptTestSystemComponent tgt = new TestScript.TestScriptTestSystemComponent();
    if (src.hasIndex())
      tgt.setIndex(src.getIndex());
    tgt.setTitle("destination");
    if (src.hasProfile())
      tgt.addExtension(EXT_TS_DEST_PROFILE, org.hl7.fhir.convertors.conv50_N.datatypes50_N.general50_N.Coding50_N.convertCoding(src.getProfile()));
    return tgt;
  }

  private static org.hl7.fhir.r5.model.TestScript.TestScriptOriginComponent convertTestSystemToOrigin(TestScript.TestScriptTestSystemComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestScript.TestScriptOriginComponent tgt = new org.hl7.fhir.r5.model.TestScript.TestScriptOriginComponent();
    if (src.hasIndex())
      tgt.setIndex(src.getIndex());
    if (src.hasExtension(EXT_TS_ORIGIN_PROFILE))
      tgt.setProfile(org.hl7.fhir.convertors.conv50_N.datatypes50_N.general50_N.Coding50_N.convertCoding((org.hl7.fhir.model.core.Coding) src.getExtensionByUrl(EXT_TS_ORIGIN_PROFILE).getValue()));
    return tgt;
  }

  private static org.hl7.fhir.r5.model.TestScript.TestScriptDestinationComponent convertTestSystemToDestination(TestScript.TestScriptTestSystemComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestScript.TestScriptDestinationComponent tgt = new org.hl7.fhir.r5.model.TestScript.TestScriptDestinationComponent();
    if (src.hasIndex())
      tgt.setIndex(src.getIndex());
    if (src.hasExtension(EXT_TS_DEST_PROFILE))
      tgt.setProfile(org.hl7.fhir.convertors.conv50_N.datatypes50_N.general50_N.Coding50_N.convertCoding((org.hl7.fhir.model.core.Coding) src.getExtensionByUrl(EXT_TS_DEST_PROFILE).getValue()));
    return tgt;
  }

  public static TestScript.TestScriptMetadataComponent convertTestScriptMetadataComponent(org.hl7.fhir.r5.model.TestScript.TestScriptMetadataComponent src) throws FHIRException {
    if (src == null)
      return null;
    TestScript.TestScriptMetadataComponent tgt = new TestScript.TestScriptMetadataComponent();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r5.model.TestScript.TestScriptMetadataLinkComponent t : src.getLink())
      tgt.addLink(convertTestScriptMetadataLinkComponent(t));
    for (org.hl7.fhir.r5.model.TestScript.TestScriptMetadataCapabilityComponent t : src.getCapability())
      tgt.addCapability(convertTestScriptMetadataCapabilityComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestScript.TestScriptMetadataComponent convertTestScriptMetadataComponent(TestScript.TestScriptMetadataComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestScript.TestScriptMetadataComponent tgt = new org.hl7.fhir.r5.model.TestScript.TestScriptMetadataComponent();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyBackboneElement(src, tgt);
    for (TestScript.TestScriptMetadataLinkComponent t : src.getLinkList())
      tgt.addLink(convertTestScriptMetadataLinkComponent(t));
    for (TestScript.TestScriptMetadataCapabilityComponent t : src.getCapabilityList())
      tgt.addCapability(convertTestScriptMetadataCapabilityComponent(t));
    return tgt;
  }

  public static TestScript.TestScriptMetadataLinkComponent convertTestScriptMetadataLinkComponent(org.hl7.fhir.r5.model.TestScript.TestScriptMetadataLinkComponent src) throws FHIRException {
    if (src == null)
      return null;
    TestScript.TestScriptMetadataLinkComponent tgt = new TestScript.TestScriptMetadataLinkComponent();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyBackboneElement(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Uri50_N.convertUri(src.getUrlElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getDescriptionElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestScript.TestScriptMetadataLinkComponent convertTestScriptMetadataLinkComponent(TestScript.TestScriptMetadataLinkComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestScript.TestScriptMetadataLinkComponent tgt = new org.hl7.fhir.r5.model.TestScript.TestScriptMetadataLinkComponent();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyBackboneElement(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Uri50_N.convertUri(src.getUrlElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getDescriptionElement()));
    return tgt;
  }

  public static TestScript.TestScriptMetadataCapabilityComponent convertTestScriptMetadataCapabilityComponent(org.hl7.fhir.r5.model.TestScript.TestScriptMetadataCapabilityComponent src) throws FHIRException {
    if (src == null)
      return null;
    TestScript.TestScriptMetadataCapabilityComponent tgt = new TestScript.TestScriptMetadataCapabilityComponent();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyBackboneElement(src, tgt);
    if (src.hasRequired())
      tgt.setRequiredElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Boolean50_N.convertBoolean(src.getRequiredElement()));
    if (src.hasValidated())
      tgt.setValidatedElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Boolean50_N.convertBoolean(src.getValidatedElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getDescriptionElement()));
    for (IntegerType t : src.getOrigin()) tgt.getOriginList().add(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Integer50_N.convertInteger(t));
    if (src.hasDestination())
      tgt.setDestinationElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Integer50_N.convertInteger(src.getDestinationElement()));
    for (UriType t : src.getLink()) tgt.getLinkList().add(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Uri50_N.convertUri(t));
    if (src.hasCapabilities())
      tgt.setCapabilitiesElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Canonical50_N.convertCanonical(src.getCapabilitiesElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestScript.TestScriptMetadataCapabilityComponent convertTestScriptMetadataCapabilityComponent(TestScript.TestScriptMetadataCapabilityComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestScript.TestScriptMetadataCapabilityComponent tgt = new org.hl7.fhir.r5.model.TestScript.TestScriptMetadataCapabilityComponent();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyBackboneElement(src, tgt);
    if (src.hasRequired())
      tgt.setRequiredElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Boolean50_N.convertBoolean(src.getRequiredElement()));
    if (src.hasValidated())
      tgt.setValidatedElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Boolean50_N.convertBoolean(src.getValidatedElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getDescriptionElement()));
    for (org.hl7.fhir.model.core.IntegerType t : src.getOriginList()) tgt.getOrigin().add(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Integer50_N.convertInteger(t));
    if (src.hasDestination())
      tgt.setDestinationElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Integer50_N.convertInteger(src.getDestinationElement()));
    for (org.hl7.fhir.model.core.UriType t : src.getLinkList()) tgt.getLink().add(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Uri50_N.convertUri(t));
    if (src.hasCapabilities())
      tgt.setCapabilitiesElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Canonical50_N.convertCanonical(src.getCapabilitiesElement()));
    return tgt;
  }

  public static TestScript.TestScriptFixtureComponent convertTestScriptFixtureComponent(org.hl7.fhir.r5.model.TestScript.TestScriptFixtureComponent src) throws FHIRException {
    if (src == null)
      return null;
    TestScript.TestScriptFixtureComponent tgt = new TestScript.TestScriptFixtureComponent();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyBackboneElement(src, tgt);
    if (src.hasAutocreate())
      tgt.setAutocreateElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Boolean50_N.convertBoolean(src.getAutocreateElement()));
    if (src.hasAutodelete())
      tgt.setAutodeleteElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Boolean50_N.convertBoolean(src.getAutodeleteElement()));
    if (src.hasResource())
      tgt.setResource(org.hl7.fhir.convertors.conv50_N.datatypes50_N.special50_N.Reference50_N.convertReference(src.getResource()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestScript.TestScriptFixtureComponent convertTestScriptFixtureComponent(TestScript.TestScriptFixtureComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestScript.TestScriptFixtureComponent tgt = new org.hl7.fhir.r5.model.TestScript.TestScriptFixtureComponent();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyBackboneElement(src, tgt);
    if (src.hasAutocreate())
      tgt.setAutocreateElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Boolean50_N.convertBoolean(src.getAutocreateElement()));
    if (src.hasAutodelete())
      tgt.setAutodeleteElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Boolean50_N.convertBoolean(src.getAutodeleteElement()));
    if (src.hasResource())
      tgt.setResource(org.hl7.fhir.convertors.conv50_N.datatypes50_N.special50_N.Reference50_N.convertReference(src.getResource()));
    return tgt;
  }

  public static org.hl7.fhir.model.core.Expression convertExpression(StringType src) throws FHIRException {
    org.hl7.fhir.model.core.Expression tgt = new org.hl7.fhir.model.core.Expression();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt, VersionConvertorConstants.EXT_EXPRESSION_LANGUAGE);
    if (src.hasExtension(VersionConvertorConstants.EXT_EXPRESSION_LANGUAGE)) {
      tgt.setLanguage(src.getExtensionByUrl(VersionConvertorConstants.EXT_EXPRESSION_LANGUAGE).getValue().primitiveValue());
    }
    tgt.setExpression(src.getValue());
    return tgt;
  }

  public static StringType convertExpression(org.hl7.fhir.model.core.Expression src) throws FHIRException {
    StringType tgt = new StringType();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    if (src.hasLanguage()) {
      tgt.addExtension(new Extension(VersionConvertorConstants.EXT_EXPRESSION_LANGUAGE, new CodeType(src.getLanguage())));
    }
    tgt.setValue(src.getExpression());
    return tgt;
  }

  public static TestScript.TestScriptVariableComponent convertTestScriptVariableComponent(org.hl7.fhir.r5.model.TestScript.TestScriptVariableComponent src) throws FHIRException {
    if (src == null)
      return null;
    TestScript.TestScriptVariableComponent tgt = new TestScript.TestScriptVariableComponent();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getNameElement()));
    if (src.hasDefaultValue())
      tgt.setDefaultValueElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getDefaultValueElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getDescriptionElement()));
    if (src.hasExpression())
      tgt.setExpression(convertExpression(src.getExpressionElement()));
    if (src.hasHeaderField())
      tgt.setHeaderFieldElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getHeaderFieldElement()));
    if (src.hasHint())
      tgt.setHintElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getHintElement()));
    if (src.hasPath())
      tgt.setPathElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getPathElement()));
    if (src.hasSourceId())
      tgt.setSourceIdElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Id50_N.convertId(src.getSourceIdElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestScript.TestScriptVariableComponent convertTestScriptVariableComponent(TestScript.TestScriptVariableComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestScript.TestScriptVariableComponent tgt = new org.hl7.fhir.r5.model.TestScript.TestScriptVariableComponent();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getNameElement()));
    if (src.hasDefaultValue())
      tgt.setDefaultValueElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getDefaultValueElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getDescriptionElement()));
    if (src.hasExpression())
      tgt.setExpressionElement(convertExpression(src.getExpression()));
    if (src.hasHeaderField())
      tgt.setHeaderFieldElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getHeaderFieldElement()));
    if (src.hasHint())
      tgt.setHintElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getHintElement()));
    if (src.hasPath())
      tgt.setPathElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getPathElement()));
    if (src.hasSourceId())
      tgt.setSourceIdElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Id50_N.convertId(src.getSourceIdElement()));
    return tgt;
  }

  public static TestScript.TestScriptSetupComponent convertTestScriptSetupComponent(org.hl7.fhir.r5.model.TestScript.TestScriptSetupComponent src) throws FHIRException {
    if (src == null)
      return null;
    TestScript.TestScriptSetupComponent tgt = new TestScript.TestScriptSetupComponent();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r5.model.TestScript.SetupActionComponent t : src.getAction())
      tgt.addAction(convertSetupActionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestScript.TestScriptSetupComponent convertTestScriptSetupComponent(TestScript.TestScriptSetupComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestScript.TestScriptSetupComponent tgt = new org.hl7.fhir.r5.model.TestScript.TestScriptSetupComponent();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyBackboneElement(src, tgt);
    for (TestScript.SetupActionComponent t : src.getActionList())
      tgt.addAction(convertSetupActionComponent(t));
    return tgt;
  }

  public static TestScript.SetupActionComponent convertSetupActionComponent(org.hl7.fhir.r5.model.TestScript.SetupActionComponent src) throws FHIRException {
    if (src == null)
      return null;
    TestScript.SetupActionComponent tgt = new TestScript.SetupActionComponent();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyBackboneElement(src, tgt);
    if (src.hasOperation())
      tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    if (src.hasAssert())
      tgt.setAssert(convertSetupActionAssertComponent(src.getAssert()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestScript.SetupActionComponent convertSetupActionComponent(TestScript.SetupActionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestScript.SetupActionComponent tgt = new org.hl7.fhir.r5.model.TestScript.SetupActionComponent();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyBackboneElement(src, tgt);
    if (src.hasOperation())
      tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    if (src.hasAssert())
      tgt.setAssert(convertSetupActionAssertComponent(src.getAssert()));
    return tgt;
  }

  public static TestScript.SetupActionOperationComponent convertSetupActionOperationComponent(org.hl7.fhir.r5.model.TestScript.SetupActionOperationComponent src) throws FHIRException {
    if (src == null)
      return null;
    TestScript.SetupActionOperationComponent tgt = new TestScript.SetupActionOperationComponent();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(org.hl7.fhir.convertors.conv50_N.datatypes50_N.general50_N.Coding50_N.convertCoding(src.getType()));
    if (src.hasResource())
      tgt.setResource(src.getResource());
    if (src.hasLabel())
      tgt.setLabelElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getLabelElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getDescriptionElement()));
    if (src.hasAccept())
      tgt.setAcceptElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Code50_N.convertCode(src.getAcceptElement()));
    if (src.hasContentType())
      tgt.setContentTypeElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Code50_N.convertCode(src.getContentTypeElement()));
    if (src.hasDestination())
      tgt.setDestinationElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Integer50_N.convertInteger(src.getDestinationElement()));
    if (src.hasEncodeRequestUrl())
      tgt.setEncodeRequestUrlElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Boolean50_N.convertBoolean(src.getEncodeRequestUrlElement()));
    if (src.hasMethod())
      tgt.setMethodElement(convertTestScriptRequestMethodCode(src.getMethodElement()));
    if (src.hasOrigin())
      tgt.setOriginElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Integer50_N.convertInteger(src.getOriginElement()));
    if (src.hasParams())
      tgt.setParamsElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getParamsElement()));
    for (org.hl7.fhir.r5.model.TestScript.SetupActionOperationRequestHeaderComponent t : src.getRequestHeader())
      tgt.addRequestHeader(convertSetupActionOperationRequestHeaderComponent(t));
    if (src.hasRequestId())
      tgt.setRequestIdElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Id50_N.convertId(src.getRequestIdElement()));
    if (src.hasResponseId())
      tgt.setResponseIdElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Id50_N.convertId(src.getResponseIdElement()));
    if (src.hasSourceId())
      tgt.setSourceIdElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Id50_N.convertId(src.getSourceIdElement()));
    if (src.hasTargetId())
      tgt.setTargetIdElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Id50_N.convertId(src.getTargetIdElement()));
    if (src.hasUrl())
      tgt.setUrlElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getUrlElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestScript.SetupActionOperationComponent convertSetupActionOperationComponent(TestScript.SetupActionOperationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestScript.SetupActionOperationComponent tgt = new org.hl7.fhir.r5.model.TestScript.SetupActionOperationComponent();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType(org.hl7.fhir.convertors.conv50_N.datatypes50_N.general50_N.Coding50_N.convertCoding(src.getType()));
    if (src.hasResource())
      tgt.setResource(src.getResource());
    if (src.hasLabel())
      tgt.setLabelElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getLabelElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getDescriptionElement()));
    if (src.hasAccept())
      tgt.setAcceptElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Code50_N.convertCode(src.getAcceptElement()));
    if (src.hasContentType())
      tgt.setContentTypeElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Code50_N.convertCode(src.getContentTypeElement()));
    if (src.hasDestination())
      tgt.setDestinationElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Integer50_N.convertInteger(src.getDestinationElement()));
    if (src.hasEncodeRequestUrl())
      tgt.setEncodeRequestUrlElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Boolean50_N.convertBoolean(src.getEncodeRequestUrlElement()));
    if (src.hasMethod())
      tgt.setMethodElement(convertTestScriptRequestMethodCodeToR5(src.getMethodElement()));
    if (src.hasOrigin())
      tgt.setOriginElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Integer50_N.convertInteger(src.getOriginElement()));
    if (src.hasParams())
      tgt.setParamsElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getParamsElement()));
    for (TestScript.SetupActionOperationRequestHeaderComponent t : src.getRequestHeaderList())
      tgt.addRequestHeader(convertSetupActionOperationRequestHeaderComponent(t));
    if (src.hasRequestId())
      tgt.setRequestIdElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Id50_N.convertId(src.getRequestIdElement()));
    if (src.hasResponseId())
      tgt.setResponseIdElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Id50_N.convertId(src.getResponseIdElement()));
    if (src.hasSourceId())
      tgt.setSourceIdElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Id50_N.convertId(src.getSourceIdElement()));
    if (src.hasTargetId())
      tgt.setTargetIdElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Id50_N.convertId(src.getTargetIdElement()));
    if (src.hasUrl())
      tgt.setUrlElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getUrlElement()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<TestScript.TestScriptRequestMethodCodeValueSet> convertTestScriptRequestMethodCode(Enumeration<org.hl7.fhir.r5.model.TestScript.TestScriptRequestMethodCode> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.model.core.Enumeration<TestScript.TestScriptRequestMethodCodeValueSet> tgt = new org.hl7.fhir.model.core.Enumeration<>(new TestScript.TestScriptRequestMethodCodeValueSetEnumFactory());
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
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

  static public Enumeration<org.hl7.fhir.r5.model.TestScript.TestScriptRequestMethodCode> convertTestScriptRequestMethodCodeToR5(org.hl7.fhir.model.core.Enumeration<TestScript.TestScriptRequestMethodCodeValueSet> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<org.hl7.fhir.r5.model.TestScript.TestScriptRequestMethodCode> tgt = new Enumeration<>(new org.hl7.fhir.r5.model.TestScript.TestScriptRequestMethodCodeEnumFactory());
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case DELETE:
                  tgt.setValue(org.hl7.fhir.r5.model.TestScript.TestScriptRequestMethodCode.DELETE);
                  break;
              case GET:
                  tgt.setValue(org.hl7.fhir.r5.model.TestScript.TestScriptRequestMethodCode.GET);
                  break;
              case OPTIONS:
                  tgt.setValue(org.hl7.fhir.r5.model.TestScript.TestScriptRequestMethodCode.OPTIONS);
                  break;
              case PATCH:
                  tgt.setValue(org.hl7.fhir.r5.model.TestScript.TestScriptRequestMethodCode.PATCH);
                  break;
              case POST:
                  tgt.setValue(org.hl7.fhir.r5.model.TestScript.TestScriptRequestMethodCode.POST);
                  break;
              case PUT:
                  tgt.setValue(org.hl7.fhir.r5.model.TestScript.TestScriptRequestMethodCode.PUT);
                  break;
              case HEAD:
                  tgt.setValue(org.hl7.fhir.r5.model.TestScript.TestScriptRequestMethodCode.HEAD);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r5.model.TestScript.TestScriptRequestMethodCode.NULL);
                  break;
          }
      }
      return tgt;
  }

  public static TestScript.SetupActionOperationRequestHeaderComponent convertSetupActionOperationRequestHeaderComponent(org.hl7.fhir.r5.model.TestScript.SetupActionOperationRequestHeaderComponent src) throws FHIRException {
    if (src == null)
      return null;
    TestScript.SetupActionOperationRequestHeaderComponent tgt = new TestScript.SetupActionOperationRequestHeaderComponent();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyBackboneElement(src, tgt);
    if (src.hasField())
      tgt.setFieldElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getFieldElement()));
    if (src.hasValue())
      tgt.setValueElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getValueElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestScript.SetupActionOperationRequestHeaderComponent convertSetupActionOperationRequestHeaderComponent(TestScript.SetupActionOperationRequestHeaderComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestScript.SetupActionOperationRequestHeaderComponent tgt = new org.hl7.fhir.r5.model.TestScript.SetupActionOperationRequestHeaderComponent();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyBackboneElement(src, tgt);
    if (src.hasField())
      tgt.setFieldElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getFieldElement()));
    if (src.hasValue())
      tgt.setValueElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getValueElement()));
    return tgt;
  }

  public static TestScript.SetupActionAssertComponent convertSetupActionAssertComponent(org.hl7.fhir.r5.model.TestScript.SetupActionAssertComponent src) throws FHIRException {
    if (src == null)
      return null;
    TestScript.SetupActionAssertComponent tgt = new TestScript.SetupActionAssertComponent();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyBackboneElement(src, tgt);
    if (src.hasStopTestOnFail())
      tgt.setStopTestOnFailElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Boolean50_N.convertBoolean(src.getStopTestOnFailElement()));
    if (src.hasLabel())
      tgt.setLabelElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getLabelElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getDescriptionElement()));
    if (src.hasDirection())
      tgt.setDirectionElement(convertAssertionDirectionType(src.getDirectionElement()));
    if (src.hasCompareToSourceId())
      tgt.setCompareToSourceIdElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getCompareToSourceIdElement()));
    if (src.hasCompareToSourceExpression())
      tgt.setCompareToSourceExpression(convertExpression(src.getCompareToSourceExpressionElement()));
    if (src.hasCompareToSourcePath())
      tgt.setCompareToSourcePathElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getCompareToSourcePathElement()));
    if (src.hasContentType())
      tgt.setContentTypeElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Code50_N.convertCode(src.getContentTypeElement()));
    if (src.hasExpression())
      tgt.setExpression(convertExpression(src.getExpressionElement()));
    if (src.hasHeaderField())
      tgt.setHeaderFieldElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getHeaderFieldElement()));
    if (src.hasMinimumId())
      tgt.setMinimumIdElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getMinimumIdElement()));
    if (src.hasNavigationLinks())
      tgt.setNavigationLinksElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Boolean50_N.convertBoolean(src.getNavigationLinksElement()));
    if (src.hasOperator())
      tgt.setOperatorElement(convertAssertionOperatorType(src.getOperatorElement()));
    if (src.hasPath())
      tgt.setPathElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getPathElement()));
    if (src.hasRequestMethod())
      tgt.setRequestMethodElement(convertTestScriptRequestMethodCode(src.getRequestMethodElement()));
    if (src.hasRequestURL())
      tgt.setRequestURLElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getRequestURLElement()));
    if (src.hasResource())
      tgt.setResource(src.getResource());
    if (src.hasResponse())
      tgt.setResponseElement(convertAssertionResponseTypes(src.getResponseElement()));
    if (src.hasResponseCode())
      tgt.setResponseCodeElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getResponseCodeElement()));
    if (src.hasSourceId())
      tgt.setSourceIdElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Id50_N.convertId(src.getSourceIdElement()));
    if (src.hasValidateProfileId())
      tgt.setValidateProfileIdElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Id50_N.convertId(src.getValidateProfileIdElement()));
    if (src.hasValue())
      tgt.setValueElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getValueElement()));
    if (src.hasWarningOnly())
      tgt.setWarningOnlyElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Boolean50_N.convertBoolean(src.getWarningOnlyElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestScript.SetupActionAssertComponent convertSetupActionAssertComponent(TestScript.SetupActionAssertComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestScript.SetupActionAssertComponent tgt = new org.hl7.fhir.r5.model.TestScript.SetupActionAssertComponent();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyBackboneElement(src, tgt);
    if (src.hasStopTestOnFail())
      tgt.setStopTestOnFailElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Boolean50_N.convertBoolean(src.getStopTestOnFailElement()));
    if (src.hasLabel())
      tgt.setLabelElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getLabelElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getDescriptionElement()));
    if (src.hasDirection())
      tgt.setDirectionElement(convertAssertionDirectionTypeToR5(src.getDirectionElement()));
    if (src.hasCompareToSourceId())
      tgt.setCompareToSourceIdElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getCompareToSourceIdElement()));
    if (src.hasCompareToSourceExpression())
      tgt.setCompareToSourceExpressionElement(convertExpression(src.getCompareToSourceExpression()));
    if (src.hasCompareToSourcePath())
      tgt.setCompareToSourcePathElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getCompareToSourcePathElement()));
    if (src.hasContentType())
      tgt.setContentTypeElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Code50_N.convertCode(src.getContentTypeElement()));
    if (src.hasExpression())
      tgt.setExpressionElement(convertExpression(src.getExpression()));
    if (src.hasHeaderField())
      tgt.setHeaderFieldElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getHeaderFieldElement()));
    if (src.hasMinimumId())
      tgt.setMinimumIdElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getMinimumIdElement()));
    if (src.hasNavigationLinks())
      tgt.setNavigationLinksElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Boolean50_N.convertBoolean(src.getNavigationLinksElement()));
    if (src.hasOperator())
      tgt.setOperatorElement(convertAssertionOperatorTypeToR5(src.getOperatorElement()));
    if (src.hasPath())
      tgt.setPathElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getPathElement()));
    if (src.hasRequestMethod())
      tgt.setRequestMethodElement(convertTestScriptRequestMethodCodeToR5(src.getRequestMethodElement()));
    if (src.hasRequestURL())
      tgt.setRequestURLElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getRequestURLElement()));
    if (src.hasResource())
      tgt.setResource(src.getResource());
    if (src.hasResponse())
      tgt.setResponseElement(convertAssertionResponseTypesToR5(src.getResponseElement()));
    if (src.hasResponseCode())
      tgt.setResponseCodeElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getResponseCodeElement()));
    if (src.hasSourceId())
      tgt.setSourceIdElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Id50_N.convertId(src.getSourceIdElement()));
    if (src.hasValidateProfileId())
      tgt.setValidateProfileIdElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Id50_N.convertId(src.getValidateProfileIdElement()));
    if (src.hasValue())
      tgt.setValueElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getValueElement()));
    if (src.hasWarningOnly())
      tgt.setWarningOnlyElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Boolean50_N.convertBoolean(src.getWarningOnlyElement()));
    return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<TestScript.AssertionDirectionTypeValueSet> convertAssertionDirectionType(Enumeration<org.hl7.fhir.r5.model.TestScript.AssertionDirectionType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.model.core.Enumeration<TestScript.AssertionDirectionTypeValueSet> tgt = new org.hl7.fhir.model.core.Enumeration<>(new TestScript.AssertionDirectionTypeValueSetEnumFactory());
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
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

  static public Enumeration<org.hl7.fhir.r5.model.TestScript.AssertionDirectionType> convertAssertionDirectionTypeToR5(org.hl7.fhir.model.core.Enumeration<TestScript.AssertionDirectionTypeValueSet> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<org.hl7.fhir.r5.model.TestScript.AssertionDirectionType> tgt = new Enumeration<>(new org.hl7.fhir.r5.model.TestScript.AssertionDirectionTypeEnumFactory());
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case RESPONSE:
                  tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionDirectionType.RESPONSE);
                  break;
              case REQUEST:
                  tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionDirectionType.REQUEST);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionDirectionType.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<TestScript.AssertionOperatorTypeValueSet> convertAssertionOperatorType(Enumeration<org.hl7.fhir.r5.model.TestScript.AssertionOperatorType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.model.core.Enumeration<TestScript.AssertionOperatorTypeValueSet> tgt = new org.hl7.fhir.model.core.Enumeration<>(new TestScript.AssertionOperatorTypeValueSetEnumFactory());
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
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

  static public Enumeration<org.hl7.fhir.r5.model.TestScript.AssertionOperatorType> convertAssertionOperatorTypeToR5(org.hl7.fhir.model.core.Enumeration<TestScript.AssertionOperatorTypeValueSet> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<org.hl7.fhir.r5.model.TestScript.AssertionOperatorType> tgt = new Enumeration<>(new org.hl7.fhir.r5.model.TestScript.AssertionOperatorTypeEnumFactory());
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case EQUALS:
                  tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionOperatorType.EQUALS);
                  break;
              case NOTEQUALS:
                  tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionOperatorType.NOTEQUALS);
                  break;
              case IN:
                  tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionOperatorType.IN);
                  break;
              case NOTIN:
                  tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionOperatorType.NOTIN);
                  break;
              case GREATERTHAN:
                  tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionOperatorType.GREATERTHAN);
                  break;
              case LESSTHAN:
                  tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionOperatorType.LESSTHAN);
                  break;
              case EMPTY:
                  tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionOperatorType.EMPTY);
                  break;
              case NOTEMPTY:
                  tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionOperatorType.NOTEMPTY);
                  break;
              case CONTAINS:
                  tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionOperatorType.CONTAINS);
                  break;
              case NOTCONTAINS:
                  tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionOperatorType.NOTCONTAINS);
                  break;
              case EVAL:
                  tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionOperatorType.EVAL);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionOperatorType.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.model.core.Enumeration<TestScript.AssertionResponseTypesValueSet> convertAssertionResponseTypes(Enumeration<org.hl7.fhir.r5.model.TestScript.AssertionResponseTypes> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.model.core.Enumeration<TestScript.AssertionResponseTypesValueSet> tgt = new org.hl7.fhir.model.core.Enumeration<>(new TestScript.AssertionResponseTypesValueSetEnumFactory());
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
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
            case BADREQUEST:
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
            case UNPROCESSABLECONTENT:
                  tgt.setValue(TestScript.AssertionResponseTypesValueSet.UNPROCESSABLECONTENT);
                  break;
              default:
                  tgt.setValue(TestScript.AssertionResponseTypesValueSet.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public Enumeration<org.hl7.fhir.r5.model.TestScript.AssertionResponseTypes> convertAssertionResponseTypesToR5(org.hl7.fhir.model.core.Enumeration<TestScript.AssertionResponseTypesValueSet> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<org.hl7.fhir.r5.model.TestScript.AssertionResponseTypes> tgt = new Enumeration<>(new org.hl7.fhir.r5.model.TestScript.AssertionResponseTypesEnumFactory());
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case OKAY:
                  tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionResponseTypes.OKAY);
                  break;
              case CREATED:
                  tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionResponseTypes.CREATED);
                  break;
              case NOCONTENT:
                  tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionResponseTypes.NOCONTENT);
                  break;
              case NOTMODIFIED:
                  tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionResponseTypes.NOTMODIFIED);
                  break;
              case BADREQUEST:
                  tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionResponseTypes.BADREQUEST);
                  break;
              case FORBIDDEN:
                  tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionResponseTypes.FORBIDDEN);
                  break;
              case NOTFOUND:
                  tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionResponseTypes.NOTFOUND);
                  break;
              case METHODNOTALLOWED:
                  tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionResponseTypes.METHODNOTALLOWED);
                  break;
              case CONFLICT:
                  tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionResponseTypes.CONFLICT);
                  break;
              case GONE:
                  tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionResponseTypes.GONE);
                  break;
              case PRECONDITIONFAILED:
                  tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionResponseTypes.PRECONDITIONFAILED);
                  break;
              case UNPROCESSABLECONTENT:
                  tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionResponseTypes.UNPROCESSABLECONTENT);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r5.model.TestScript.AssertionResponseTypes.NULL);
                  break;
          }
      }
      return tgt;
  }

  public static TestScript.TestScriptTestComponent convertTestScriptTestComponent(org.hl7.fhir.r5.model.TestScript.TestScriptTestComponent src) throws FHIRException {
    if (src == null)
      return null;
    TestScript.TestScriptTestComponent tgt = new TestScript.TestScriptTestComponent();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getNameElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getDescriptionElement()));
    for (org.hl7.fhir.r5.model.TestScript.TestActionComponent t : src.getAction())
      tgt.addAction(convertTestActionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestScript.TestScriptTestComponent convertTestScriptTestComponent(TestScript.TestScriptTestComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestScript.TestScriptTestComponent tgt = new org.hl7.fhir.r5.model.TestScript.TestScriptTestComponent();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getNameElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getDescriptionElement()));
    for (TestScript.TestActionComponent t : src.getActionList())
      tgt.addAction(convertTestActionComponent(t));
    return tgt;
  }

  public static TestScript.TestActionComponent convertTestActionComponent(org.hl7.fhir.r5.model.TestScript.TestActionComponent src) throws FHIRException {
    if (src == null)
      return null;
    TestScript.TestActionComponent tgt = new TestScript.TestActionComponent();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyBackboneElement(src, tgt);
    if (src.hasOperation())
      tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    if (src.hasAssert())
      tgt.setAssert(convertSetupActionAssertComponent(src.getAssert()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestScript.TestActionComponent convertTestActionComponent(TestScript.TestActionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestScript.TestActionComponent tgt = new org.hl7.fhir.r5.model.TestScript.TestActionComponent();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyBackboneElement(src, tgt);
    if (src.hasOperation())
      tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    if (src.hasAssert())
      tgt.setAssert(convertSetupActionAssertComponent(src.getAssert()));
    return tgt;
  }

  public static TestScript.TestScriptTeardownComponent convertTestScriptTeardownComponent(org.hl7.fhir.r5.model.TestScript.TestScriptTeardownComponent src) throws FHIRException {
    if (src == null)
      return null;
    TestScript.TestScriptTeardownComponent tgt = new TestScript.TestScriptTeardownComponent();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r5.model.TestScript.TeardownActionComponent t : src.getAction())
      tgt.addAction(convertTeardownActionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestScript.TestScriptTeardownComponent convertTestScriptTeardownComponent(TestScript.TestScriptTeardownComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestScript.TestScriptTeardownComponent tgt = new org.hl7.fhir.r5.model.TestScript.TestScriptTeardownComponent();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyBackboneElement(src, tgt);
    for (TestScript.TeardownActionComponent t : src.getActionList())
      tgt.addAction(convertTeardownActionComponent(t));
    return tgt;
  }

  public static TestScript.TeardownActionComponent convertTeardownActionComponent(org.hl7.fhir.r5.model.TestScript.TeardownActionComponent src) throws FHIRException {
    if (src == null)
      return null;
    TestScript.TeardownActionComponent tgt = new TestScript.TeardownActionComponent();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyBackboneElement(src, tgt);
    if (src.hasOperation())
      tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestScript.TeardownActionComponent convertTeardownActionComponent(TestScript.TeardownActionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestScript.TeardownActionComponent tgt = new org.hl7.fhir.r5.model.TestScript.TeardownActionComponent();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyBackboneElement(src, tgt);
    if (src.hasOperation())
      tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    return tgt;
  }

  // ============================================================================================
  // TestPlan <-> Basic
  //
  // The testing-IG TestPlan is a ground-up redesign relative to the R5
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

  public static Basic convertTestPlan(org.hl7.fhir.model.testing.TestPlan src) throws FHIRException {
    if (src == null)
      return null;
    Basic tgt = new Basic();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyDomainResource(src, tgt);
    tgt.getCode().getCodingFirstRep().setSystem("http://hl7.org/fhir/fhir-types").setCode("TestPlan");
    for (org.hl7.fhir.model.core.Identifier t : src.getIdentifierList())
      tgt.getIdentifier().add(org.hl7.fhir.convertors.conv50_N.datatypes50_N.general50_N.Identifier50_N.convertIdentifier(t));
    if (src.hasUrl())
      tgt.addExtension(TP_URL, org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Uri50_N.convertUri(src.getUrlElement()));
    if (src.hasVersion())
      tgt.addExtension(TP_VERSION, org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getVersionElement()));
    if (src.hasVersionAlgorithm())
      tgt.addExtension(TP_VERSION_ALGORITHM, ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().convertType(src.getVersionAlgorithm()));
    if (src.hasName())
      tgt.addExtension(TP_NAME, org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getNameElement()));
    if (src.hasTitle())
      tgt.addExtension(TP_TITLE, org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getTitleElement()));
    if (src.hasStatus())
      tgt.addExtension(TP_STATUS, new CodeType(src.getStatus().toCode()));
    if (src.hasExperimental())
      tgt.addExtension(TP_EXPERIMENTAL, org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Boolean50_N.convertBoolean(src.getExperimentalElement()));
    if (src.hasDate())
      tgt.addExtension(TP_DATE, org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.DateTime50_N.convertDateTime(src.getDateElement()));
    if (src.hasPublisher())
      tgt.addExtension(TP_PUBLISHER, org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getPublisherElement()));
    for (org.hl7.fhir.model.core.ContactDetail t : src.getContactList())
      tgt.addExtension(TP_CONTACT, org.hl7.fhir.convertors.conv50_N.datatypes50_N.metadata50_N.ContactDetail50_N.convertContactDetail(t));
    if (src.hasDescription())
      tgt.addExtension(TP_DESCRIPTION, org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.MarkDown50_N.convertMarkDown(src.getDescriptionElement()));
    for (org.hl7.fhir.model.core.UsageContext t : src.getUseContextList())
      tgt.addExtension(TP_USE_CONTEXT, org.hl7.fhir.convertors.conv50_N.datatypes50_N.metadata50_N.UsageContext50_N.convertUsageContext(t));
    for (org.hl7.fhir.model.core.CodeableConcept t : src.getJurisdictionList())
      tgt.addExtension(TP_JURISDICTION, org.hl7.fhir.convertors.conv50_N.datatypes50_N.general50_N.CodeableConcept50_N.convertCodeableConcept(t));
    if (src.hasPurpose())
      tgt.addExtension(TP_PURPOSE, org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.MarkDown50_N.convertMarkDown(src.getPurposeElement()));
    if (src.hasCopyright())
      tgt.addExtension(TP_COPYRIGHT, org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.MarkDown50_N.convertMarkDown(src.getCopyrightElement()));
    if (src.hasCopyrightLabel())
      tgt.addExtension(TP_COPYRIGHT_LABEL, org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getCopyrightLabelElement()));
    for (org.hl7.fhir.model.testing.TestPlan.TestPlanScopeComponent t : src.getScopeList()) {
      Extension tgte = new Extension(TP_SCOPE);
      tgt.addExtension(tgte);
      convertTestPlanScope(t, tgte);
    }
    for (org.hl7.fhir.model.testing.TestPlan.TestPlanDependencyComponent t : src.getDependencyList()) {
      Extension tgte = new Extension(TP_DEPENDENCY);
      tgt.addExtension(tgte);
      convertTestPlanDependency(t, tgte);
    }
    if (src.hasRunner())
      tgt.addExtension(TP_RUNNER, org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Url50_N.convertUrl(src.getRunnerElement()));
    for (org.hl7.fhir.model.testing.TestPlan.TestPlanModeComponent t : src.getModeList()) {
      Extension tgte = new Extension(TP_MODE);
      tgt.addExtension(tgte);
      convertTestPlanMode(t, tgte);
    }
    for (org.hl7.fhir.model.testing.TestPlan.TestPlanParameterComponent t : src.getParameterList()) {
      Extension tgte = new Extension(TP_PARAMETER);
      tgt.addExtension(tgte);
      convertTestPlanParameter(t, tgte);
    }
    for (org.hl7.fhir.model.testing.TestPlan.TestPlanSuiteComponent t : src.getSuiteList()) {
      Extension tgte = new Extension(TP_SUITE);
      tgt.addExtension(tgte);
      convertTestPlanSuite(t, tgte, tgt);
    }
    return tgt;
  }

  public static org.hl7.fhir.model.testing.TestPlan convertTestPlan(Basic src) throws FHIRException {
    if (src == null)
      return null;
    if (!src.getCode().hasCoding("http://hl7.org/fhir/fhir-types", "TestPlan")) {
      throw new FHIRException("Error in logic: this Basic resource is not a TestPlan");
    }
    org.hl7.fhir.model.testing.TestPlan tgt = new org.hl7.fhir.model.testing.TestPlan();
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyDomainResource(src, tgt, TP_IGNORED_EXTENSION_URLS);
    for (Identifier t : src.getIdentifier())
      tgt.getIdentifierList().add(org.hl7.fhir.convertors.conv50_N.datatypes50_N.general50_N.Identifier50_N.convertIdentifier(t));
    if (src.hasExtension(TP_URL))
      tgt.setUrlElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Uri50_N.convertUri((UriType) src.getExtensionByUrl(TP_URL).getValue()));
    if (src.hasExtension(TP_VERSION))
      tgt.setVersionElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString((StringType) src.getExtensionByUrl(TP_VERSION).getValue()));
    if (src.hasExtension(TP_VERSION_ALGORITHM))
      tgt.setVersionAlgorithm(ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().convertType(src.getExtensionByUrl(TP_VERSION_ALGORITHM).getValue()));
    if (src.hasExtension(TP_NAME))
      tgt.setNameElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString((StringType) src.getExtensionByUrl(TP_NAME).getValue()));
    if (src.hasExtension(TP_TITLE))
      tgt.setTitleElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString((StringType) src.getExtensionByUrl(TP_TITLE).getValue()));
    if (src.hasExtension(TP_STATUS))
      tgt.setStatus(org.hl7.fhir.model.core.Enumerations.PublicationStatus.fromCode(src.getExtensionByUrl(TP_STATUS).getValue().primitiveValue()));
    if (src.hasExtension(TP_EXPERIMENTAL))
      tgt.setExperimentalElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Boolean50_N.convertBoolean((BooleanType) src.getExtensionByUrl(TP_EXPERIMENTAL).getValue()));
    if (src.hasExtension(TP_DATE))
      tgt.setDateElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.DateTime50_N.convertDateTime((DateTimeType) src.getExtensionByUrl(TP_DATE).getValue()));
    if (src.hasExtension(TP_PUBLISHER))
      tgt.setPublisherElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString((StringType) src.getExtensionByUrl(TP_PUBLISHER).getValue()));
    for (Extension ext : src.getExtensionsByUrl(TP_CONTACT))
      tgt.getContactList().add(org.hl7.fhir.convertors.conv50_N.datatypes50_N.metadata50_N.ContactDetail50_N.convertContactDetail((ContactDetail) ext.getValue()));
    if (src.hasExtension(TP_DESCRIPTION))
      tgt.setDescriptionElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.MarkDown50_N.convertMarkDown((MarkdownType) src.getExtensionByUrl(TP_DESCRIPTION).getValue()));
    for (Extension ext : src.getExtensionsByUrl(TP_USE_CONTEXT))
      tgt.getUseContextList().add(org.hl7.fhir.convertors.conv50_N.datatypes50_N.metadata50_N.UsageContext50_N.convertUsageContext((UsageContext) ext.getValue()));
    for (Extension ext : src.getExtensionsByUrl(TP_JURISDICTION))
      tgt.getJurisdictionList().add(org.hl7.fhir.convertors.conv50_N.datatypes50_N.general50_N.CodeableConcept50_N.convertCodeableConcept((CodeableConcept) ext.getValue()));
    if (src.hasExtension(TP_PURPOSE))
      tgt.setPurposeElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.MarkDown50_N.convertMarkDown((MarkdownType) src.getExtensionByUrl(TP_PURPOSE).getValue()));
    if (src.hasExtension(TP_COPYRIGHT))
      tgt.setCopyrightElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.MarkDown50_N.convertMarkDown((MarkdownType) src.getExtensionByUrl(TP_COPYRIGHT).getValue()));
    if (src.hasExtension(TP_COPYRIGHT_LABEL))
      tgt.setCopyrightLabelElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString((StringType) src.getExtensionByUrl(TP_COPYRIGHT_LABEL).getValue()));
    for (Extension ext : src.getExtensionsByUrl(TP_SCOPE))
      convertTestPlanScope(ext, tgt.addScope());
    for (Extension ext : src.getExtensionsByUrl(TP_DEPENDENCY))
      convertTestPlanDependency(ext, tgt.addDependency());
    if (src.hasExtension(TP_RUNNER))
      tgt.setRunnerElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Url50_N.convertUrl((UrlType) src.getExtensionByUrl(TP_RUNNER).getValue()));
    for (Extension ext : src.getExtensionsByUrl(TP_MODE))
      convertTestPlanMode(ext, tgt.addMode());
    for (Extension ext : src.getExtensionsByUrl(TP_PARAMETER))
      convertTestPlanParameter(ext, tgt.addParameter());
    for (Extension ext : src.getExtensionsByUrl(TP_SUITE))
      convertTestPlanSuite(ext, tgt.addSuite(), src);
    // the input resources were carried as contained resources (id "tpc-N") and have now been
    // re-inlined into their inputs; drop them from the resource-level contained list that
    // copyDomainResource brought across
    tgt.getContained().removeIf(r -> r.hasId() && r.getIdPart() != null && r.getIdPart().startsWith("tpc-"));
    return tgt;
  }

  private static void convertTestPlanScope(org.hl7.fhir.model.testing.TestPlan.TestPlanScopeComponent src, Extension tgt) throws FHIRException {
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    if (src.hasReference())
      tgt.addExtension("reference", org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Canonical50_N.convertCanonical(src.getReferenceElement()));
    if (src.hasDescription())
      tgt.addExtension("description", org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getDescriptionElement()));
  }

  private static void convertTestPlanScope(Extension src, org.hl7.fhir.model.testing.TestPlan.TestPlanScopeComponent tgt) throws FHIRException {
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt, "reference", "description");
    if (src.hasExtension("reference"))
      tgt.setReferenceElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Canonical50_N.convertCanonical((CanonicalType) src.getExtensionByUrl("reference").getValue()));
    if (src.hasExtension("description"))
      tgt.setDescriptionElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString((StringType) src.getExtensionByUrl("description").getValue()));
  }

  private static void convertTestPlanDependency(org.hl7.fhir.model.testing.TestPlan.TestPlanDependencyComponent src, Extension tgt) throws FHIRException {
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    if (src.hasReference())
      tgt.addExtension("reference", org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Canonical50_N.convertCanonical(src.getReferenceElement()));
    if (src.hasDescription())
      tgt.addExtension("description", org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getDescriptionElement()));
  }

  private static void convertTestPlanDependency(Extension src, org.hl7.fhir.model.testing.TestPlan.TestPlanDependencyComponent tgt) throws FHIRException {
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt, "reference", "description");
    if (src.hasExtension("reference"))
      tgt.setReferenceElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Canonical50_N.convertCanonical((CanonicalType) src.getExtensionByUrl("reference").getValue()));
    if (src.hasExtension("description"))
      tgt.setDescriptionElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString((StringType) src.getExtensionByUrl("description").getValue()));
  }

  private static void convertTestPlanMode(org.hl7.fhir.model.testing.TestPlan.TestPlanModeComponent src, Extension tgt) throws FHIRException {
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    if (src.hasCode())
      tgt.addExtension("code", org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getCodeElement()));
    if (src.hasDescription())
      tgt.addExtension("description", org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getDescriptionElement()));
  }

  private static void convertTestPlanMode(Extension src, org.hl7.fhir.model.testing.TestPlan.TestPlanModeComponent tgt) throws FHIRException {
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt, "code", "description");
    if (src.hasExtension("code"))
      tgt.setCodeElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString((StringType) src.getExtensionByUrl("code").getValue()));
    if (src.hasExtension("description"))
      tgt.setDescriptionElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString((StringType) src.getExtensionByUrl("description").getValue()));
  }

  private static void convertTestPlanParameter(org.hl7.fhir.model.testing.TestPlan.TestPlanParameterComponent src, Extension tgt) throws FHIRException {
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    if (src.hasName())
      tgt.addExtension("name", org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getNameElement()));
    if (src.hasValue())
      tgt.addExtension("value", ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().convertType(src.getValue()));
    if (src.hasMode())
      tgt.addExtension("mode", org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Code50_N.convertCode(src.getModeElement()));
  }

  private static void convertTestPlanParameter(Extension src, org.hl7.fhir.model.testing.TestPlan.TestPlanParameterComponent tgt) throws FHIRException {
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt, "name", "value", "mode");
    if (src.hasExtension("name"))
      tgt.setNameElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString((StringType) src.getExtensionByUrl("name").getValue()));
    if (src.hasExtension("value"))
      tgt.setValue(ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().convertType(src.getExtensionByUrl("value").getValue()));
    if (src.hasExtension("mode"))
      tgt.setModeElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Code50_N.convertCode((CodeType) src.getExtensionByUrl("mode").getValue()));
  }

  private static void convertTestPlanSuite(org.hl7.fhir.model.testing.TestPlan.TestPlanSuiteComponent src, Extension tgt, Basic basic) throws FHIRException {
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    if (src.hasName())
      tgt.addExtension("name", org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getNameElement()));
    if (src.hasDescription())
      tgt.addExtension("description", org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getDescriptionElement()));
    if (src.hasMode())
      tgt.addExtension("mode", org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Code50_N.convertCode(src.getModeElement()));
    for (org.hl7.fhir.model.testing.TestPlan.TestPlanSuiteInputComponent t : src.getInputList()) {
      Extension e = new Extension("input");
      tgt.addExtension(e);
      convertTestPlanSuiteInput(t, e, basic);
    }
    for (org.hl7.fhir.model.testing.TestPlan.TestPlanParameterComponent t : src.getParameterList()) {
      Extension e = new Extension("parameter");
      tgt.addExtension(e);
      convertTestPlanParameter(t, e);
    }
    for (org.hl7.fhir.model.testing.TestPlan.TestPlanSuiteTestComponent t : src.getTestList()) {
      Extension e = new Extension("test");
      tgt.addExtension(e);
      convertTestPlanSuiteTest(t, e, basic);
    }
    for (org.hl7.fhir.model.testing.TestPlan.TestPlanSuiteComponent t : src.getSuiteList()) {
      Extension e = new Extension("suite");
      tgt.addExtension(e);
      convertTestPlanSuite(t, e, basic);
    }
    for (org.hl7.fhir.model.core.Reference t : src.getPlanList())
      tgt.addExtension("plan", org.hl7.fhir.convertors.conv50_N.datatypes50_N.special50_N.Reference50_N.convertReference(t));
  }

  private static void convertTestPlanSuite(Extension src, org.hl7.fhir.model.testing.TestPlan.TestPlanSuiteComponent tgt, Basic basic) throws FHIRException {
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt, "name", "description", "mode", "input", "parameter", "test", "suite", "plan");
    if (src.hasExtension("name"))
      tgt.setNameElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString((StringType) src.getExtensionByUrl("name").getValue()));
    if (src.hasExtension("description"))
      tgt.setDescriptionElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString((StringType) src.getExtensionByUrl("description").getValue()));
    if (src.hasExtension("mode"))
      tgt.setModeElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Code50_N.convertCode((CodeType) src.getExtensionByUrl("mode").getValue()));
    for (Extension ext : src.getExtensionsByUrl("input"))
      convertTestPlanSuiteInput(ext, tgt.addInput(), basic);
    for (Extension ext : src.getExtensionsByUrl("parameter"))
      convertTestPlanParameter(ext, tgt.addParameter());
    for (Extension ext : src.getExtensionsByUrl("test"))
      convertTestPlanSuiteTest(ext, tgt.addTest(), basic);
    for (Extension ext : src.getExtensionsByUrl("suite"))
      convertTestPlanSuite(ext, tgt.addSuite(), basic);
    for (Extension ext : src.getExtensionsByUrl("plan"))
      tgt.getPlanList().add(org.hl7.fhir.convertors.conv50_N.datatypes50_N.special50_N.Reference50_N.convertReference((Reference) ext.getValue()));
  }

  private static void convertTestPlanSuiteInput(org.hl7.fhir.model.testing.TestPlan.TestPlanSuiteInputComponent src, Extension tgt, Basic basic) throws FHIRException {
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    if (src.hasName())
      tgt.addExtension("name", org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getNameElement()));
    if (src.hasFile())
      tgt.addExtension("file", org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getFileElement()));
    if (src.hasResource()) {
      Resource r = ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().convertResource(src.getResource());
      String id = "tpc-" + (basic.getContained().size() + 1);
      r.setId(id);
      basic.getContained().add(r);
      tgt.addExtension("resource", new Reference("#" + id));
    }
    if (src.hasMode())
      tgt.addExtension("mode", org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Code50_N.convertCode(src.getModeElement()));
  }

  private static void convertTestPlanSuiteInput(Extension src, org.hl7.fhir.model.testing.TestPlan.TestPlanSuiteInputComponent tgt, Basic basic) throws FHIRException {
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt, "name", "file", "resource", "mode");
    if (src.hasExtension("name"))
      tgt.setNameElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString((StringType) src.getExtensionByUrl("name").getValue()));
    if (src.hasExtension("file"))
      tgt.setFileElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString((StringType) src.getExtensionByUrl("file").getValue()));
    if (src.hasExtension("resource")) {
      String ref = ((Reference) src.getExtensionByUrl("resource").getValue()).getReference();
      String id = ref != null && ref.startsWith("#") ? ref.substring(1) : ref;
      for (Resource c : basic.getContained()) {
        if (id != null && id.equals(c.getIdPart())) {
          org.hl7.fhir.model.core.Resource r = ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().convertResource(c);
          if (r.hasId() && r.getIdPart() != null && r.getIdPart().startsWith("tpc-"))
            r.setIdBase(null);
          tgt.setResource(r);
        }
      }
    }
    if (src.hasExtension("mode"))
      tgt.setModeElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Code50_N.convertCode((CodeType) src.getExtensionByUrl("mode").getValue()));
  }

  private static void convertTestPlanSuiteTest(org.hl7.fhir.model.testing.TestPlan.TestPlanSuiteTestComponent src, Extension tgt, Basic basic) throws FHIRException {
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    if (src.hasName())
      tgt.addExtension("name", org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getNameElement()));
    if (src.hasDescription())
      tgt.addExtension("description", org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getDescriptionElement()));
    if (src.hasOperation())
      tgt.addExtension("operation", org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Code50_N.convertCode(src.getOperationElement()));
    if (src.hasMode())
      tgt.addExtension("mode", org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Code50_N.convertCode(src.getModeElement()));
    for (org.hl7.fhir.model.testing.TestPlan.TestPlanParameterComponent t : src.getParameterList()) {
      Extension e = new Extension("parameter");
      tgt.addExtension(e);
      convertTestPlanParameter(t, e);
    }
    for (org.hl7.fhir.model.testing.TestPlan.TestPlanSuiteInputComponent t : src.getInputList()) {
      Extension e = new Extension("input");
      tgt.addExtension(e);
      convertTestPlanSuiteInput(t, e, basic);
    }
    for (org.hl7.fhir.model.testing.TestPlan.TestPlanSuiteInputComponent t : src.getExpectedList()) {
      Extension e = new Extension("expected");
      tgt.addExtension(e);
      convertTestPlanSuiteInput(t, e, basic);
    }
    for (org.hl7.fhir.model.testing.TestPlan.TestPlanSuiteTestAssertionComponent t : src.getAssertionList()) {
      Extension e = new Extension("assertion");
      tgt.addExtension(e);
      convertTestPlanAssertion(t, e);
    }
  }

  private static void convertTestPlanSuiteTest(Extension src, org.hl7.fhir.model.testing.TestPlan.TestPlanSuiteTestComponent tgt, Basic basic) throws FHIRException {
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt, "name", "description", "operation", "mode", "parameter", "input", "expected", "assertion");
    if (src.hasExtension("name"))
      tgt.setNameElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString((StringType) src.getExtensionByUrl("name").getValue()));
    if (src.hasExtension("description"))
      tgt.setDescriptionElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString((StringType) src.getExtensionByUrl("description").getValue()));
    if (src.hasExtension("operation"))
      tgt.setOperationElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Code50_N.convertCode((CodeType) src.getExtensionByUrl("operation").getValue()));
    if (src.hasExtension("mode"))
      tgt.setModeElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Code50_N.convertCode((CodeType) src.getExtensionByUrl("mode").getValue()));
    for (Extension ext : src.getExtensionsByUrl("parameter"))
      convertTestPlanParameter(ext, tgt.addParameter());
    for (Extension ext : src.getExtensionsByUrl("input"))
      convertTestPlanSuiteInput(ext, tgt.addInput(), basic);
    for (Extension ext : src.getExtensionsByUrl("expected"))
      convertTestPlanSuiteInput(ext, tgt.addExpected(), basic);
    for (Extension ext : src.getExtensionsByUrl("assertion"))
      convertTestPlanAssertion(ext, tgt.addAssertion());
  }

  private static void convertTestPlanAssertion(org.hl7.fhir.model.testing.TestPlan.TestPlanSuiteTestAssertionComponent src, Extension tgt) throws FHIRException {
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt);
    if (src.hasFocus())
      tgt.addExtension("focus", org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getFocusElement()));
    if (src.hasSeverity())
      tgt.addExtension("severity", org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Code50_N.convertCode(src.getSeverityElement()));
    if (src.hasExpression())
      tgt.addExtension("expression", org.hl7.fhir.convertors.conv50_N.datatypes50_N.metadata50_N.Expression50_N.convertExpression(src.getExpression()));
    if (src.hasHuman())
      tgt.addExtension("human", org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString(src.getHumanElement()));
    if (src.hasMode())
      tgt.addExtension("mode", org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Code50_N.convertCode(src.getModeElement()));
  }

  private static void convertTestPlanAssertion(Extension src, org.hl7.fhir.model.testing.TestPlan.TestPlanSuiteTestAssertionComponent tgt) throws FHIRException {
    ConversionContext50_N.INSTANCE.getVersionConvertor_50_N().copyElement(src, tgt, "focus", "severity", "expression", "human", "mode");
    if (src.hasExtension("focus"))
      tgt.setFocusElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString((StringType) src.getExtensionByUrl("focus").getValue()));
    if (src.hasExtension("severity"))
      tgt.setSeverityElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Code50_N.convertCode((CodeType) src.getExtensionByUrl("severity").getValue()));
    if (src.hasExtension("expression"))
      tgt.setExpression(org.hl7.fhir.convertors.conv50_N.datatypes50_N.metadata50_N.Expression50_N.convertExpression((Expression) src.getExtensionByUrl("expression").getValue()));
    if (src.hasExtension("human"))
      tgt.setHumanElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.String50_N.convertString((StringType) src.getExtensionByUrl("human").getValue()));
    if (src.hasExtension("mode"))
      tgt.setModeElement(org.hl7.fhir.convertors.conv50_N.datatypes50_N.primitive50_N.Code50_N.convertCode((CodeType) src.getExtensionByUrl("mode").getValue()));
  }

}