package org.hl7.fhir.convertors.igs.testing;

import org.hl7.fhir.convertors.VersionConvertorConstants;
import org.hl7.fhir.convertors.igs.VersionConvertorIGBase;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.model.*;
import org.hl7.fhir.r5.igs.testing.TestReport;
import org.hl7.fhir.r5.igs.testing.TestScript;
import org.hl7.fhir.r5.igs.testing.TestScript.TestScriptScopeComponent;

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
// Hand-maintained R4 <-> testing-IG (R6-shaped) converter for TestReport (and TestScript).
// Adapted from org.hl7.fhir.convertors...TestReport40_50, retargeted to org.hl7.fhir.r5.igs.testing.
// R6-only elements (TestReport: documentation, log, parameter, period, presentedForm, version;
// assert.requirement) have no R4 representation and are dropped when converting to R4.
public class TestingR5Convertor extends VersionConvertorIGBase {

  @Override
  public boolean handlesR5ToR5(String s) {
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
  public Resource convertR5ToR5(Resource source) {
    switch (source.fhirType() ) {
      case "TestReport":
        return convertTestReport((org.hl7.fhir.r5.igs.testing.TestReport) source);
      case "TestPlan":
        return convertTestPlan((org.hl7.fhir.r5.igs.testing.TestPlan) source);
      case "TestScript":
        return convertTestScript((org.hl7.fhir.r5.igs.testing.TestScript) source);
      default:
        return source;
    }
  }

  // r5 -> r5: the two models share the r5 datatypes, so elements are copied (not converted). These
  // mirror the copyDomainResource / copyBackboneElement / copyElement used by the 40_50 framework.
  private static void copyDomainResource(org.hl7.fhir.r5.model.DomainResource src, org.hl7.fhir.r5.model.DomainResource tgt, String... ignoreExtensionUrls) {
    if (src.hasId()) tgt.setId(src.getId());
    if (src.hasMeta()) tgt.setMeta(src.getMeta().copy());
    if (src.hasImplicitRules()) tgt.setImplicitRulesElement(src.getImplicitRulesElement().copy());
    if (src.hasLanguage()) tgt.setLanguageElement(src.getLanguageElement().copy());
    if (src.hasText()) tgt.setText(src.getText().copy());
    for (org.hl7.fhir.r5.model.Resource r : src.getContained()) tgt.getContained().add(r.copy());
    for (org.hl7.fhir.r5.model.Extension e : src.getExtension()) {
      boolean ignore = false;
      for (String u : ignoreExtensionUrls) { if (u.equals(e.getUrl())) { ignore = true; break; } }
      if (!ignore) tgt.getExtension().add(e.copy());
    }
    for (org.hl7.fhir.r5.model.Extension e : src.getModifierExtension()) tgt.getModifierExtension().add(e.copy());
  }

  private static void copyBackboneElement(org.hl7.fhir.r5.model.BackboneElement src, org.hl7.fhir.r5.model.BackboneElement tgt) {
    copyElement(src, tgt);
    for (org.hl7.fhir.r5.model.Extension e : src.getModifierExtension()) tgt.getModifierExtension().add(e.copy());
  }

  private static void copyElement(org.hl7.fhir.r5.model.Element src, org.hl7.fhir.r5.model.Element tgt, String... ignoreExtensionUrls) {
    if (src.hasId()) tgt.setId(src.getId());
    for (org.hl7.fhir.r5.model.Extension e : src.getExtension()) {
      boolean ignore = false;
      for (String u : ignoreExtensionUrls) { if (u.equals(e.getUrl())) { ignore = true; break; } }
      if (!ignore) tgt.getExtension().add(e.copy());
    }
  }

  // TestScript.scope exists natively in both R5 and the testing-IG (R6) model, so it is mapped
  // component-to-component (unlike the R4 converter, which has to carry it as a cross-version extension).
  public static org.hl7.fhir.r5.igs.testing.TestScript.TestScriptScopeComponent convertTestScriptScopeComponent(org.hl7.fhir.r5.model.TestScript.TestScriptScopeComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.igs.testing.TestScript.TestScriptScopeComponent tgt = new org.hl7.fhir.r5.igs.testing.TestScript.TestScriptScopeComponent();
    copyBackboneElement(src, tgt);
    if (src.hasArtifact())
      tgt.setArtifactElement((src.getArtifactElement()).copy());
    if (src.hasConformance())
      tgt.setConformance((src.getConformance()).copy());
    if (src.hasPhase())
      tgt.setPhase((src.getPhase()).copy());
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestScript.TestScriptScopeComponent convertTestScriptScopeComponent(org.hl7.fhir.r5.igs.testing.TestScript.TestScriptScopeComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestScript.TestScriptScopeComponent tgt = new org.hl7.fhir.r5.model.TestScript.TestScriptScopeComponent();
    copyBackboneElement(src, tgt);
    if (src.hasArtifact())
      tgt.setArtifactElement((src.getArtifactElement()).copy());
    if (src.hasConformance())
      tgt.setConformance((src.getConformance()).copy());
    if (src.hasPhase())
      tgt.setPhase((src.getPhase()).copy());
    return tgt;
  }


  public static org.hl7.fhir.r5.igs.testing.TestReport convertTestReport(org.hl7.fhir.r5.model.TestReport src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.igs.testing.TestReport tgt = new org.hl7.fhir.r5.igs.testing.TestReport();
    copyDomainResource(src, tgt, EXT_TESTREPORT_DESCRIPTION);
    if (src.hasExtension(EXT_TESTREPORT_DESCRIPTION)) {
      // TestReport.description (top-level) is R6-only; recover it from the cross-version extension
      tgt.setDescriptionElement(((org.hl7.fhir.r5.model.MarkdownType) src.getExtensionByUrl(EXT_TESTREPORT_DESCRIPTION).getValue()).copy());
    }
    if (src.hasIdentifier())
      tgt.setIdentifier((src.getIdentifier()).copy());
    if (src.hasName())
      tgt.setNameElement((src.getNameElement()).copy());
    if (src.hasStatus())
      tgt.setStatusElement(convertTestReportStatus(src.getStatusElement()));
    if (src.hasTestScript())
      tgt.setTestScriptElement(src.getTestScriptElement().copy());
    if (src.hasResult())
      tgt.setResultElement(convertTestReportResult(src.getResultElement()));
    if (src.hasScore())
      tgt.setScoreElement((src.getScoreElement()).copy());
    if (src.hasTester())
      tgt.setTesterElement((src.getTesterElement()).copy());
    if (src.hasIssued())
      tgt.setIssuedElement((src.getIssuedElement()).copy());
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

  public static org.hl7.fhir.r5.model.TestReport convertTestReport(org.hl7.fhir.r5.igs.testing.TestReport src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestReport tgt = new org.hl7.fhir.r5.model.TestReport();
    copyDomainResource(src, tgt);
    if (src.hasDescription()) {
      // TestReport.description has no R4 home; carry it as a cross-version extension
      org.hl7.fhir.r5.model.Extension ext = tgt.addExtension();
      ext.setUrl(EXT_TESTREPORT_DESCRIPTION);
      ext.setValue((src.getDescriptionElement()).copy());
    }
    if (src.hasIdentifier())
      tgt.setIdentifier((src.getIdentifier()).copy());
    if (src.hasName())
      tgt.setNameElement((src.getNameElement()).copy());
    if (src.hasStatus())
      tgt.setStatusElement(convertTestReportStatusToR5(src.getStatusElement()));
    if (src.hasTestScript())
      tgt.setTestScriptElement(src.getTestScriptElement().copy());
    if (src.hasResult())
      tgt.setResultElement(convertTestReportResultToR5(src.getResultElement()));
    if (src.hasScore())
      tgt.setScoreElement((src.getScoreElement()).copy());
    if (src.hasTester())
      tgt.setTesterElement((src.getTesterElement()).copy());
    if (src.hasIssued())
      tgt.setIssuedElement((src.getIssuedElement()).copy());
    for (org.hl7.fhir.r5.igs.testing.TestReport.TestReportParticipantComponent t : src.getParticipantList())
      tgt.addParticipant(convertTestReportParticipantComponent(t));
    if (src.hasSetup())
      tgt.setSetup(convertTestReportSetupComponent(src.getSetup()));
    for (org.hl7.fhir.r5.igs.testing.TestReport.TestReportTestComponent t : src.getTestList())
      tgt.addTest(convertTestReportTestComponent(t));
    if (src.hasTeardown())
      tgt.setTeardown(convertTestReportTeardownComponent(src.getTeardown()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.igs.testing.TestReport.TestReportStatusValueSet> convertTestReportStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestReport.TestReportStatus> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<TestReport.TestReportStatusValueSet> tgt = new Enumeration<>(new TestReport.TestReportStatusValueSetEnumFactory());
      copyElement(src, tgt);
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

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestReport.TestReportStatus> convertTestReportStatusToR5(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.igs.testing.TestReport.TestReportStatusValueSet> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestReport.TestReportStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.TestReport.TestReportStatusEnumFactory());
      copyElement(src, tgt);
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

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.igs.testing.TestReport.TestReportResultValueSet> convertTestReportResult(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestReport.TestReportResult> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<TestReport.TestReportResultValueSet> tgt = new Enumeration<>(new TestReport.TestReportResultValueSetEnumFactory());
      copyElement(src, tgt);
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

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestReport.TestReportResult> convertTestReportResultToR5(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.igs.testing.TestReport.TestReportResultValueSet> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestReport.TestReportResult> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.TestReport.TestReportResultEnumFactory());
      copyElement(src, tgt);
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

  public static org.hl7.fhir.r5.igs.testing.TestReport.TestReportParticipantComponent convertTestReportParticipantComponent(org.hl7.fhir.r5.model.TestReport.TestReportParticipantComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.igs.testing.TestReport.TestReportParticipantComponent tgt = new org.hl7.fhir.r5.igs.testing.TestReport.TestReportParticipantComponent();
    copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setTypeElement(convertTestReportParticipantType(src.getTypeElement()));
    if (src.hasUri())
      tgt.setUriElement((src.getUriElement()).copy());
    if (src.hasDisplay())
      tgt.setDisplayElement((src.getDisplayElement()).copy());
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestReport.TestReportParticipantComponent convertTestReportParticipantComponent(org.hl7.fhir.r5.igs.testing.TestReport.TestReportParticipantComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestReport.TestReportParticipantComponent tgt = new org.hl7.fhir.r5.model.TestReport.TestReportParticipantComponent();
    copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setTypeElement(convertTestReportParticipantTypeToR5(src.getTypeElement()));
    if (src.hasUri())
      tgt.setUriElement((src.getUriElement()).copy());
    if (src.hasDisplay())
      tgt.setDisplayElement((src.getDisplayElement()).copy());
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.igs.testing.TestReport.TestReportParticipantTypeValueSet> convertTestReportParticipantType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestReport.TestReportParticipantType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<TestReport.TestReportParticipantTypeValueSet> tgt = new Enumeration<>(new TestReport.TestReportParticipantTypeValueSetEnumFactory());
      copyElement(src, tgt);
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

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestReport.TestReportParticipantType> convertTestReportParticipantTypeToR5(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.igs.testing.TestReport.TestReportParticipantTypeValueSet> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestReport.TestReportParticipantType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.TestReport.TestReportParticipantTypeEnumFactory());
      copyElement(src, tgt);
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

  public static org.hl7.fhir.r5.igs.testing.TestReport.TestReportSetupComponent convertTestReportSetupComponent(org.hl7.fhir.r5.model.TestReport.TestReportSetupComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.igs.testing.TestReport.TestReportSetupComponent tgt = new org.hl7.fhir.r5.igs.testing.TestReport.TestReportSetupComponent();
    copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r5.model.TestReport.SetupActionComponent t : src.getAction())
      tgt.addAction(convertSetupActionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestReport.TestReportSetupComponent convertTestReportSetupComponent(org.hl7.fhir.r5.igs.testing.TestReport.TestReportSetupComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestReport.TestReportSetupComponent tgt = new org.hl7.fhir.r5.model.TestReport.TestReportSetupComponent();
    copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r5.igs.testing.TestReport.SetupActionComponent t : src.getActionList())
      tgt.addAction(convertSetupActionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.igs.testing.TestReport.SetupActionComponent convertSetupActionComponent(org.hl7.fhir.r5.model.TestReport.SetupActionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.igs.testing.TestReport.SetupActionComponent tgt = new org.hl7.fhir.r5.igs.testing.TestReport.SetupActionComponent();
    copyBackboneElement(src, tgt);
    if (src.hasOperation())
      tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    if (src.hasAssert())
      tgt.setAssert(convertSetupActionAssertComponent(src.getAssert()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestReport.SetupActionComponent convertSetupActionComponent(org.hl7.fhir.r5.igs.testing.TestReport.SetupActionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestReport.SetupActionComponent tgt = new org.hl7.fhir.r5.model.TestReport.SetupActionComponent();
    copyBackboneElement(src, tgt);
    if (src.hasOperation())
      tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    if (src.hasAssert())
      tgt.setAssert(convertSetupActionAssertComponent(src.getAssert()));
    return tgt;
  }

  public static org.hl7.fhir.r5.igs.testing.TestReport.SetupActionOperationComponent convertSetupActionOperationComponent(org.hl7.fhir.r5.model.TestReport.SetupActionOperationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.igs.testing.TestReport.SetupActionOperationComponent tgt = new org.hl7.fhir.r5.igs.testing.TestReport.SetupActionOperationComponent();
    copyBackboneElement(src, tgt);
    if (src.hasResult())
      tgt.setResultElement(convertTestReportActionResult(src.getResultElement()));
    if (src.hasMessage())
      tgt.setMessageElement((src.getMessageElement()).copy());
    if (src.hasDetail())
      tgt.setDetailElement((src.getDetailElement()).copy());
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestReport.SetupActionOperationComponent convertSetupActionOperationComponent(org.hl7.fhir.r5.igs.testing.TestReport.SetupActionOperationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestReport.SetupActionOperationComponent tgt = new org.hl7.fhir.r5.model.TestReport.SetupActionOperationComponent();
    copyBackboneElement(src, tgt);
    if (src.hasResult())
      tgt.setResultElement(convertTestReportActionResultToR5(src.getResultElement()));
    if (src.hasMessage())
      tgt.setMessageElement((src.getMessageElement()).copy());
    if (src.hasDetail())
      tgt.setDetailElement((src.getDetailElement()).copy());
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.igs.testing.TestReport.TestReportActionResultValueSet> convertTestReportActionResult(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestReport.TestReportActionResult> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<TestReport.TestReportActionResultValueSet> tgt = new Enumeration<>(new TestReport.TestReportActionResultValueSetEnumFactory());
      copyElement(src, tgt);
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

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestReport.TestReportActionResult> convertTestReportActionResultToR5(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.igs.testing.TestReport.TestReportActionResultValueSet> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestReport.TestReportActionResult> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.TestReport.TestReportActionResultEnumFactory());
      copyElement(src, tgt);
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

  public static org.hl7.fhir.r5.igs.testing.TestReport.SetupActionAssertComponent convertSetupActionAssertComponent(org.hl7.fhir.r5.model.TestReport.SetupActionAssertComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.igs.testing.TestReport.SetupActionAssertComponent tgt = new org.hl7.fhir.r5.igs.testing.TestReport.SetupActionAssertComponent();
    copyBackboneElement(src, tgt);
    if (src.hasResult())
      tgt.setResultElement(convertTestReportActionResult(src.getResultElement()));
    if (src.hasMessage())
      tgt.setMessageElement((src.getMessageElement()).copy());
    if (src.hasDetail())
      tgt.setDetailElement((src.getDetailElement()).copy());
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestReport.SetupActionAssertComponent convertSetupActionAssertComponent(org.hl7.fhir.r5.igs.testing.TestReport.SetupActionAssertComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestReport.SetupActionAssertComponent tgt = new org.hl7.fhir.r5.model.TestReport.SetupActionAssertComponent();
    copyBackboneElement(src, tgt);
    if (src.hasResult())
      tgt.setResultElement(convertTestReportActionResultToR5(src.getResultElement()));
    if (src.hasMessage())
      tgt.setMessageElement((src.getMessageElement()).copy());
    if (src.hasDetail())
      tgt.setDetailElement((src.getDetailElement()).copy());
    return tgt;
  }

  public static org.hl7.fhir.r5.igs.testing.TestReport.TestReportTestComponent convertTestReportTestComponent(org.hl7.fhir.r5.model.TestReport.TestReportTestComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.igs.testing.TestReport.TestReportTestComponent tgt = new org.hl7.fhir.r5.igs.testing.TestReport.TestReportTestComponent();
    copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement((src.getNameElement()).copy());
    if (src.hasDescription())
      tgt.setDescriptionElement((src.getDescriptionElement()).copy());
    for (org.hl7.fhir.r5.model.TestReport.TestActionComponent t : src.getAction())
      tgt.addAction(convertTestActionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestReport.TestReportTestComponent convertTestReportTestComponent(org.hl7.fhir.r5.igs.testing.TestReport.TestReportTestComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestReport.TestReportTestComponent tgt = new org.hl7.fhir.r5.model.TestReport.TestReportTestComponent();
    copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement((src.getNameElement()).copy());
    if (src.hasDescription())
      tgt.setDescriptionElement((src.getDescriptionElement()).copy());
    for (org.hl7.fhir.r5.igs.testing.TestReport.TestActionComponent t : src.getActionList())
      tgt.addAction(convertTestActionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.igs.testing.TestReport.TestActionComponent convertTestActionComponent(org.hl7.fhir.r5.model.TestReport.TestActionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.igs.testing.TestReport.TestActionComponent tgt = new org.hl7.fhir.r5.igs.testing.TestReport.TestActionComponent();
    copyBackboneElement(src, tgt);
    if (src.hasOperation())
      tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    if (src.hasAssert())
      tgt.setAssert(convertSetupActionAssertComponent(src.getAssert()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestReport.TestActionComponent convertTestActionComponent(org.hl7.fhir.r5.igs.testing.TestReport.TestActionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestReport.TestActionComponent tgt = new org.hl7.fhir.r5.model.TestReport.TestActionComponent();
    copyBackboneElement(src, tgt);
    if (src.hasOperation())
      tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    if (src.hasAssert())
      tgt.setAssert(convertSetupActionAssertComponent(src.getAssert()));
    return tgt;
  }

  public static org.hl7.fhir.r5.igs.testing.TestReport.TestReportTeardownComponent convertTestReportTeardownComponent(org.hl7.fhir.r5.model.TestReport.TestReportTeardownComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.igs.testing.TestReport.TestReportTeardownComponent tgt = new org.hl7.fhir.r5.igs.testing.TestReport.TestReportTeardownComponent();
    copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r5.model.TestReport.TeardownActionComponent t : src.getAction())
      tgt.addAction(convertTeardownActionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestReport.TestReportTeardownComponent convertTestReportTeardownComponent(org.hl7.fhir.r5.igs.testing.TestReport.TestReportTeardownComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestReport.TestReportTeardownComponent tgt = new org.hl7.fhir.r5.model.TestReport.TestReportTeardownComponent();
    copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r5.igs.testing.TestReport.TeardownActionComponent t : src.getActionList())
      tgt.addAction(convertTeardownActionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.igs.testing.TestReport.TeardownActionComponent convertTeardownActionComponent(org.hl7.fhir.r5.model.TestReport.TeardownActionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.igs.testing.TestReport.TeardownActionComponent tgt = new org.hl7.fhir.r5.igs.testing.TestReport.TeardownActionComponent();
    copyBackboneElement(src, tgt);
    if (src.hasOperation())
      tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestReport.TeardownActionComponent convertTeardownActionComponent(org.hl7.fhir.r5.igs.testing.TestReport.TeardownActionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestReport.TeardownActionComponent tgt = new org.hl7.fhir.r5.model.TestReport.TeardownActionComponent();
    copyBackboneElement(src, tgt);
    if (src.hasOperation())
      tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    return tgt;
  }

  private static final String EXT_TESTREPORT_DESCRIPTION = "http://hl7.org/fhir/6.0/StructureDefinition/extension-TestReport.description";
  private static final String EXT_TS_ORIGIN_PROFILE = "http://hl7.org/fhir/3.0/StructureDefinition/extension-TestScript.origin.profile";
  private static final String EXT_TS_TESTSYSTEM = "http://hl7.org/fhir/6.0/StructureDefinition/extension-TestScript.testSystem";
  private static final String EXT_TS_DEST_PROFILE = "http://hl7.org/fhir/3.0/StructureDefinition/extension-TestScript.destination.profile";


  public static org.hl7.fhir.r5.igs.testing.TestScript convertTestScript(org.hl7.fhir.r5.model.TestScript src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.igs.testing.TestScript tgt = new org.hl7.fhir.r5.igs.testing.TestScript();
    copyDomainResource(src, tgt, EXT_TS_TESTSYSTEM);
    for (org.hl7.fhir.r5.model.TestScript.TestScriptScopeComponent t : src.getScope())
      tgt.addScope(convertTestScriptScopeComponent(t));
    if (src.hasUrl())
      tgt.setUrlElement((src.getUrlElement()).copy());
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.addIdentifier(t.copy());
    if (src.hasVersion())
      tgt.setVersionElement((src.getVersionElement()).copy());
    if (src.hasName())
      tgt.setNameElement((src.getNameElement()).copy());
    if (src.hasTitle())
      tgt.setTitleElement((src.getTitleElement()).copy());
    if (src.hasStatus())
      tgt.setStatusElement((src.getStatusElement()).copy());
    if (src.hasExperimental())
      tgt.setExperimentalElement((src.getExperimentalElement()).copy());
    if (src.hasDate())
      tgt.setDateElement((src.getDateElement()).copy());
    if (src.hasPublisher())
      tgt.setPublisherElement((src.getPublisherElement()).copy());
    for (org.hl7.fhir.r5.model.ContactDetail t : src.getContact())
      tgt.addContact((t).copy());
    if (src.hasDescription())
      tgt.setDescriptionElement((src.getDescriptionElement()).copy());
    for (org.hl7.fhir.r5.model.UsageContext t : src.getUseContext())
      tgt.addUseContext((t).copy());
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction((t).copy());
    if (src.hasPurpose())
      tgt.setPurposeElement((src.getPurposeElement()).copy());
    if (src.hasCopyright())
      tgt.setCopyrightElement((src.getCopyrightElement()).copy());
    for (org.hl7.fhir.r5.model.TestScript.TestScriptOriginComponent t : src.getOrigin())
      tgt.addTestSystem(convertOriginToTestSystem(t));
    for (org.hl7.fhir.r5.model.TestScript.TestScriptDestinationComponent t : src.getDestination())
      tgt.addTestSystem(convertDestinationToTestSystem(t));
    // testSystems that were neither origin nor destination were carried as cross-version extensions;
    // restore them after the origin/destination-derived testSystems
    for (org.hl7.fhir.r5.model.Extension tse : src.getExtensionsByUrl(EXT_TS_TESTSYSTEM))
      tgt.addTestSystem(convertExtensionToTestSystem(tse));
    if (src.hasMetadata())
      tgt.setMetadata(convertTestScriptMetadataComponent(src.getMetadata()));
    for (org.hl7.fhir.r5.model.TestScript.TestScriptFixtureComponent t : src.getFixture())
      tgt.addFixture(convertTestScriptFixtureComponent(t));
    for (org.hl7.fhir.r5.model.CanonicalType t : src.getProfile()) tgt.getProfileList().add((t).copy());
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

  public static org.hl7.fhir.r5.model.TestScript convertTestScript(org.hl7.fhir.r5.igs.testing.TestScript src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestScript tgt = new org.hl7.fhir.r5.model.TestScript();
    copyDomainResource(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement((src.getUrlElement()).copy());
    if (src.hasIdentifier())
      tgt.addIdentifier((src.getIdentifierFirstRep()).copy());
    if (src.hasVersion())
      tgt.setVersionElement((src.getVersionElement()).copy());
    if (src.hasName())
      tgt.setNameElement((src.getNameElement()).copy());
    if (src.hasTitle())
      tgt.setTitleElement((src.getTitleElement()).copy());
    if (src.hasStatus())
      tgt.setStatusElement((src.getStatusElement()).copy());
    if (src.hasExperimental())
      tgt.setExperimentalElement((src.getExperimentalElement()).copy());
    if (src.hasDate())
      tgt.setDateElement((src.getDateElement()).copy());
    if (src.hasPublisher())
      tgt.setPublisherElement((src.getPublisherElement()).copy());
    for (org.hl7.fhir.r5.model.ContactDetail t : src.getContact())
      tgt.addContact((t).copy());
    if (src.hasDescription())
      tgt.setDescriptionElement((src.getDescriptionElement()).copy());
    for (org.hl7.fhir.r5.model.UsageContext t : src.getUseContext())
      tgt.addUseContext((t).copy());
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getJurisdiction())
      tgt.addJurisdiction((t).copy());
    if (src.hasPurpose())
      tgt.setPurposeElement((src.getPurposeElement()).copy());
    if (src.hasCopyright())
      tgt.setCopyrightElement((src.getCopyrightElement()).copy());
    for (org.hl7.fhir.r5.igs.testing.TestScript.TestScriptTestSystemComponent t : src.getTestSystemList()) {
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
    for (org.hl7.fhir.r5.igs.testing.TestScript.TestScriptFixtureComponent t : src.getFixtureList())
      tgt.addFixture(convertTestScriptFixtureComponent(t));
    for (CanonicalType t : src.getProfileList()) tgt.getProfile().add((t).copy());
    for (org.hl7.fhir.r5.igs.testing.TestScript.TestScriptVariableComponent t : src.getVariableList())
      tgt.addVariable(convertTestScriptVariableComponent(t));
    if (src.hasSetup())
      tgt.setSetup(convertTestScriptSetupComponent(src.getSetup()));
    for (org.hl7.fhir.r5.igs.testing.TestScript.TestScriptTestComponent t : src.getTestList())
      tgt.addTest(convertTestScriptTestComponent(t));
    if (src.hasTeardown())
      tgt.setTeardown(convertTestScriptTeardownComponent(src.getTeardown()));
    for (TestScriptScopeComponent t : src.getScopeList())
      tgt.addScope(convertTestScriptScopeComponent(t));
    return tgt;
  }

  private static org.hl7.fhir.r5.model.Extension convertTestSystemToExtension(org.hl7.fhir.r5.igs.testing.TestScript.TestScriptTestSystemComponent src) throws FHIRException {
    org.hl7.fhir.r5.model.Extension ext = new org.hl7.fhir.r5.model.Extension(EXT_TS_TESTSYSTEM);
    if (src.hasIndex())
      addTestSystemSubExtension(ext, "index", src.getIndexElement());
    if (src.hasTitle())
      addTestSystemSubExtension(ext, "title", src.getTitleElement());
    for (org.hl7.fhir.r5.model.CanonicalType a : src.getActorList())
      addTestSystemSubExtension(ext, "actor", a);
    if (src.hasDescription())
      addTestSystemSubExtension(ext, "description", src.getDescriptionElement());
    if (src.hasUrl())
      addTestSystemSubExtension(ext, "url", src.getUrlElement());
    return ext;
  }

  private static void addTestSystemSubExtension(org.hl7.fhir.r5.model.Extension parent, String url, org.hl7.fhir.r5.model.DataType value) throws FHIRException {
    org.hl7.fhir.r5.model.Extension se = parent.addExtension();
    se.setUrl(url);
    se.setValue((value).copy());
  }

  private static org.hl7.fhir.r5.igs.testing.TestScript.TestScriptTestSystemComponent convertExtensionToTestSystem(org.hl7.fhir.r5.model.Extension src) throws FHIRException {
    org.hl7.fhir.r5.igs.testing.TestScript.TestScriptTestSystemComponent tgt = new org.hl7.fhir.r5.igs.testing.TestScript.TestScriptTestSystemComponent();
    org.hl7.fhir.r5.model.Extension se = src.getExtensionByUrl("index");
    if (se != null)
      tgt.setIndexElement((org.hl7.fhir.r5.model.PositiveIntType) (se.getValue()).copy());
    se = src.getExtensionByUrl("title");
    if (se != null)
      tgt.setTitleElement((org.hl7.fhir.r5.model.StringType) (se.getValue()).copy());
    for (org.hl7.fhir.r5.model.Extension ae : src.getExtensionsByUrl("actor"))
      tgt.getActorList().add((org.hl7.fhir.r5.model.CanonicalType) (ae.getValue()).copy());
    se = src.getExtensionByUrl("description");
    if (se != null)
      tgt.setDescriptionElement((org.hl7.fhir.r5.model.MarkdownType) (se.getValue()).copy());
    se = src.getExtensionByUrl("url");
    if (se != null)
      tgt.setUrlElement((org.hl7.fhir.r5.model.UrlType) (se.getValue()).copy());
    return tgt;
  }

  private static org.hl7.fhir.r5.igs.testing.TestScript.TestScriptTestSystemComponent convertOriginToTestSystem(org.hl7.fhir.r5.model.TestScript.TestScriptOriginComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.igs.testing.TestScript.TestScriptTestSystemComponent tgt = new org.hl7.fhir.r5.igs.testing.TestScript.TestScriptTestSystemComponent();
    if (src.hasIndex())
      tgt.setIndex(src.getIndex());
    tgt.setTitle("origin");
    if (src.hasProfile())
      tgt.addExtension(EXT_TS_ORIGIN_PROFILE, (src.getProfile()).copy());
    return tgt;
  }

  private static org.hl7.fhir.r5.igs.testing.TestScript.TestScriptTestSystemComponent convertDestinationToTestSystem(org.hl7.fhir.r5.model.TestScript.TestScriptDestinationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.igs.testing.TestScript.TestScriptTestSystemComponent tgt = new org.hl7.fhir.r5.igs.testing.TestScript.TestScriptTestSystemComponent();
    if (src.hasIndex())
      tgt.setIndex(src.getIndex());
    tgt.setTitle("destination");
    if (src.hasProfile())
      tgt.addExtension(EXT_TS_DEST_PROFILE, (src.getProfile()).copy());
    return tgt;
  }

  private static org.hl7.fhir.r5.model.TestScript.TestScriptOriginComponent convertTestSystemToOrigin(org.hl7.fhir.r5.igs.testing.TestScript.TestScriptTestSystemComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestScript.TestScriptOriginComponent tgt = new org.hl7.fhir.r5.model.TestScript.TestScriptOriginComponent();
    if (src.hasIndex())
      tgt.setIndex(src.getIndex());
    if (src.hasExtension(EXT_TS_ORIGIN_PROFILE))
      tgt.setProfile(((org.hl7.fhir.r5.model.Coding) src.getExtensionByUrl(EXT_TS_ORIGIN_PROFILE).getValue()).copy());
    return tgt;
  }

  private static org.hl7.fhir.r5.model.TestScript.TestScriptDestinationComponent convertTestSystemToDestination(org.hl7.fhir.r5.igs.testing.TestScript.TestScriptTestSystemComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestScript.TestScriptDestinationComponent tgt = new org.hl7.fhir.r5.model.TestScript.TestScriptDestinationComponent();
    if (src.hasIndex())
      tgt.setIndex(src.getIndex());
    if (src.hasExtension(EXT_TS_DEST_PROFILE))
      tgt.setProfile(((org.hl7.fhir.r5.model.Coding) src.getExtensionByUrl(EXT_TS_DEST_PROFILE).getValue()).copy());
    return tgt;
  }

  public static org.hl7.fhir.r5.igs.testing.TestScript.TestScriptMetadataComponent convertTestScriptMetadataComponent(org.hl7.fhir.r5.model.TestScript.TestScriptMetadataComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.igs.testing.TestScript.TestScriptMetadataComponent tgt = new org.hl7.fhir.r5.igs.testing.TestScript.TestScriptMetadataComponent();
    copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r5.model.TestScript.TestScriptMetadataLinkComponent t : src.getLink())
      tgt.addLink(convertTestScriptMetadataLinkComponent(t));
    for (org.hl7.fhir.r5.model.TestScript.TestScriptMetadataCapabilityComponent t : src.getCapability())
      tgt.addCapability(convertTestScriptMetadataCapabilityComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestScript.TestScriptMetadataComponent convertTestScriptMetadataComponent(org.hl7.fhir.r5.igs.testing.TestScript.TestScriptMetadataComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestScript.TestScriptMetadataComponent tgt = new org.hl7.fhir.r5.model.TestScript.TestScriptMetadataComponent();
    copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r5.igs.testing.TestScript.TestScriptMetadataLinkComponent t : src.getLinkList())
      tgt.addLink(convertTestScriptMetadataLinkComponent(t));
    for (org.hl7.fhir.r5.igs.testing.TestScript.TestScriptMetadataCapabilityComponent t : src.getCapabilityList())
      tgt.addCapability(convertTestScriptMetadataCapabilityComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.igs.testing.TestScript.TestScriptMetadataLinkComponent convertTestScriptMetadataLinkComponent(org.hl7.fhir.r5.model.TestScript.TestScriptMetadataLinkComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.igs.testing.TestScript.TestScriptMetadataLinkComponent tgt = new org.hl7.fhir.r5.igs.testing.TestScript.TestScriptMetadataLinkComponent();
    copyBackboneElement(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement((src.getUrlElement()).copy());
    if (src.hasDescription())
      tgt.setDescriptionElement((src.getDescriptionElement()).copy());
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestScript.TestScriptMetadataLinkComponent convertTestScriptMetadataLinkComponent(org.hl7.fhir.r5.igs.testing.TestScript.TestScriptMetadataLinkComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestScript.TestScriptMetadataLinkComponent tgt = new org.hl7.fhir.r5.model.TestScript.TestScriptMetadataLinkComponent();
    copyBackboneElement(src, tgt);
    if (src.hasUrl())
      tgt.setUrlElement((src.getUrlElement()).copy());
    if (src.hasDescription())
      tgt.setDescriptionElement((src.getDescriptionElement()).copy());
    return tgt;
  }

  public static org.hl7.fhir.r5.igs.testing.TestScript.TestScriptMetadataCapabilityComponent convertTestScriptMetadataCapabilityComponent(org.hl7.fhir.r5.model.TestScript.TestScriptMetadataCapabilityComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.igs.testing.TestScript.TestScriptMetadataCapabilityComponent tgt = new org.hl7.fhir.r5.igs.testing.TestScript.TestScriptMetadataCapabilityComponent();
    copyBackboneElement(src, tgt);
    if (src.hasRequired())
      tgt.setRequiredElement((src.getRequiredElement()).copy());
    if (src.hasValidated())
      tgt.setValidatedElement((src.getValidatedElement()).copy());
    if (src.hasDescription())
      tgt.setDescriptionElement((src.getDescriptionElement()).copy());
    for (org.hl7.fhir.r5.model.IntegerType t : src.getOrigin()) tgt.getOriginList().add((t).copy());
    if (src.hasDestination())
      tgt.setDestinationElement((src.getDestinationElement()).copy());
    for (org.hl7.fhir.r5.model.UriType t : src.getLink()) tgt.getLinkList().add((t).copy());
    if (src.hasCapabilities())
      tgt.setCapabilitiesElement((src.getCapabilitiesElement()).copy());
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestScript.TestScriptMetadataCapabilityComponent convertTestScriptMetadataCapabilityComponent(org.hl7.fhir.r5.igs.testing.TestScript.TestScriptMetadataCapabilityComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestScript.TestScriptMetadataCapabilityComponent tgt = new org.hl7.fhir.r5.model.TestScript.TestScriptMetadataCapabilityComponent();
    copyBackboneElement(src, tgt);
    if (src.hasRequired())
      tgt.setRequiredElement((src.getRequiredElement()).copy());
    if (src.hasValidated())
      tgt.setValidatedElement((src.getValidatedElement()).copy());
    if (src.hasDescription())
      tgt.setDescriptionElement((src.getDescriptionElement()).copy());
    for (org.hl7.fhir.r5.model.IntegerType t : src.getOriginList()) tgt.getOrigin().add((t).copy());
    if (src.hasDestination())
      tgt.setDestinationElement((src.getDestinationElement()).copy());
    for (org.hl7.fhir.r5.model.UriType t : src.getLinkList()) tgt.getLink().add((t).copy());
    if (src.hasCapabilities())
      tgt.setCapabilitiesElement((src.getCapabilitiesElement()).copy());
    return tgt;
  }

  public static org.hl7.fhir.r5.igs.testing.TestScript.TestScriptFixtureComponent convertTestScriptFixtureComponent(org.hl7.fhir.r5.model.TestScript.TestScriptFixtureComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.igs.testing.TestScript.TestScriptFixtureComponent tgt = new org.hl7.fhir.r5.igs.testing.TestScript.TestScriptFixtureComponent();
    copyBackboneElement(src, tgt);
    if (src.hasAutocreate())
      tgt.setAutocreateElement((src.getAutocreateElement()).copy());
    if (src.hasAutodelete())
      tgt.setAutodeleteElement((src.getAutodeleteElement()).copy());
    if (src.hasResource())
      tgt.setResource((src.getResource()).copy());
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestScript.TestScriptFixtureComponent convertTestScriptFixtureComponent(org.hl7.fhir.r5.igs.testing.TestScript.TestScriptFixtureComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestScript.TestScriptFixtureComponent tgt = new org.hl7.fhir.r5.model.TestScript.TestScriptFixtureComponent();
    copyBackboneElement(src, tgt);
    if (src.hasAutocreate())
      tgt.setAutocreateElement((src.getAutocreateElement()).copy());
    if (src.hasAutodelete())
      tgt.setAutodeleteElement((src.getAutodeleteElement()).copy());
    if (src.hasResource())
      tgt.setResource((src.getResource()).copy());
    return tgt;
  }

  public static org.hl7.fhir.r5.model.Expression convertExpression(org.hl7.fhir.r5.model.StringType src) throws FHIRException {
    Expression tgt = new Expression();
    for (Extension ext : src.getExtension()) {
      if (VersionConvertorConstants.EXT_EXPRESSION_LANGUAGE.equals(ext.getUrl())) {
        tgt.setLanguage(ext.getValue().primitiveValue());
      } else {
        tgt.addExtension(ext.copy());
      }
    }
    tgt.setExpression(src.getValue());
    return tgt;
  }

  public static org.hl7.fhir.r5.model.StringType convertExpression(org.hl7.fhir.r5.model.Expression src) throws FHIRException {
    StringType tgt = new StringType();
    for (Extension ext : src.getExtension()) {
      tgt.addExtension(ext.copy());
    }
    if (src.hasLanguage()) {
      tgt.addExtension(new Extension(VersionConvertorConstants.EXT_EXPRESSION_LANGUAGE, new CodeType(src.getLanguage())));
    }
    tgt.setValue(src.getExpression());
    return tgt;
  }

  public static org.hl7.fhir.r5.igs.testing.TestScript.TestScriptVariableComponent convertTestScriptVariableComponent(org.hl7.fhir.r5.model.TestScript.TestScriptVariableComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.igs.testing.TestScript.TestScriptVariableComponent tgt = new org.hl7.fhir.r5.igs.testing.TestScript.TestScriptVariableComponent();
    copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement((src.getNameElement()).copy());
    if (src.hasDefaultValue())
      tgt.setDefaultValueElement((src.getDefaultValueElement()).copy());
    if (src.hasDescription())
      tgt.setDescriptionElement((src.getDescriptionElement()).copy());
    if (src.hasExpression())
      tgt.setExpression(convertExpression(src.getExpressionElement()));
    if (src.hasHeaderField())
      tgt.setHeaderFieldElement((src.getHeaderFieldElement()).copy());
    if (src.hasHint())
      tgt.setHintElement((src.getHintElement()).copy());
    if (src.hasPath())
      tgt.setPathElement((src.getPathElement()).copy());
    if (src.hasSourceId())
      tgt.setSourceIdElement((src.getSourceIdElement()).copy());
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestScript.TestScriptVariableComponent convertTestScriptVariableComponent(org.hl7.fhir.r5.igs.testing.TestScript.TestScriptVariableComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestScript.TestScriptVariableComponent tgt = new org.hl7.fhir.r5.model.TestScript.TestScriptVariableComponent();
    copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement((src.getNameElement()).copy());
    if (src.hasDefaultValue())
      tgt.setDefaultValueElement((src.getDefaultValueElement()).copy());
    if (src.hasDescription())
      tgt.setDescriptionElement((src.getDescriptionElement()).copy());
    if (src.hasExpression())
      tgt.setExpressionElement(convertExpression(src.getExpression()));
    if (src.hasHeaderField())
      tgt.setHeaderFieldElement((src.getHeaderFieldElement()).copy());
    if (src.hasHint())
      tgt.setHintElement((src.getHintElement()).copy());
    if (src.hasPath())
      tgt.setPathElement((src.getPathElement()).copy());
    if (src.hasSourceId())
      tgt.setSourceIdElement((src.getSourceIdElement()).copy());
    return tgt;
  }

  public static org.hl7.fhir.r5.igs.testing.TestScript.TestScriptSetupComponent convertTestScriptSetupComponent(org.hl7.fhir.r5.model.TestScript.TestScriptSetupComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.igs.testing.TestScript.TestScriptSetupComponent tgt = new org.hl7.fhir.r5.igs.testing.TestScript.TestScriptSetupComponent();
    copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r5.model.TestScript.SetupActionComponent t : src.getAction())
      tgt.addAction(convertSetupActionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestScript.TestScriptSetupComponent convertTestScriptSetupComponent(org.hl7.fhir.r5.igs.testing.TestScript.TestScriptSetupComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestScript.TestScriptSetupComponent tgt = new org.hl7.fhir.r5.model.TestScript.TestScriptSetupComponent();
    copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r5.igs.testing.TestScript.SetupActionComponent t : src.getActionList())
      tgt.addAction(convertSetupActionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.igs.testing.TestScript.SetupActionComponent convertSetupActionComponent(org.hl7.fhir.r5.model.TestScript.SetupActionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.igs.testing.TestScript.SetupActionComponent tgt = new org.hl7.fhir.r5.igs.testing.TestScript.SetupActionComponent();
    copyBackboneElement(src, tgt);
    if (src.hasOperation())
      tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    if (src.hasAssert())
      tgt.setAssert(convertSetupActionAssertComponent(src.getAssert()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestScript.SetupActionComponent convertSetupActionComponent(org.hl7.fhir.r5.igs.testing.TestScript.SetupActionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestScript.SetupActionComponent tgt = new org.hl7.fhir.r5.model.TestScript.SetupActionComponent();
    copyBackboneElement(src, tgt);
    if (src.hasOperation())
      tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    if (src.hasAssert())
      tgt.setAssert(convertSetupActionAssertComponent(src.getAssert()));
    return tgt;
  }

  public static org.hl7.fhir.r5.igs.testing.TestScript.SetupActionOperationComponent convertSetupActionOperationComponent(org.hl7.fhir.r5.model.TestScript.SetupActionOperationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.igs.testing.TestScript.SetupActionOperationComponent tgt = new org.hl7.fhir.r5.igs.testing.TestScript.SetupActionOperationComponent();
    copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType((src.getType()).copy());
    if (src.hasResource())
      tgt.setResource(src.getResource());
    if (src.hasLabel())
      tgt.setLabelElement((src.getLabelElement()).copy());
    if (src.hasDescription())
      tgt.setDescriptionElement((src.getDescriptionElement()).copy());
    if (src.hasAccept())
      tgt.setAcceptElement((src.getAcceptElement()).copy());
    if (src.hasContentType())
      tgt.setContentTypeElement((src.getContentTypeElement()).copy());
    if (src.hasDestination())
      tgt.setDestinationElement((src.getDestinationElement()).copy());
    if (src.hasEncodeRequestUrl())
      tgt.setEncodeRequestUrlElement((src.getEncodeRequestUrlElement()).copy());
    if (src.hasMethod())
      tgt.setMethodElement(convertTestScriptRequestMethodCode(src.getMethodElement()));
    if (src.hasOrigin())
      tgt.setOriginElement((src.getOriginElement()).copy());
    if (src.hasParams())
      tgt.setParamsElement((src.getParamsElement()).copy());
    for (org.hl7.fhir.r5.model.TestScript.SetupActionOperationRequestHeaderComponent t : src.getRequestHeader())
      tgt.addRequestHeader(convertSetupActionOperationRequestHeaderComponent(t));
    if (src.hasRequestId())
      tgt.setRequestIdElement((src.getRequestIdElement()).copy());
    if (src.hasResponseId())
      tgt.setResponseIdElement((src.getResponseIdElement()).copy());
    if (src.hasSourceId())
      tgt.setSourceIdElement((src.getSourceIdElement()).copy());
    if (src.hasTargetId())
      tgt.setTargetIdElement((src.getTargetIdElement()).copy());
    if (src.hasUrl())
      tgt.setUrlElement((src.getUrlElement()).copy());
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestScript.SetupActionOperationComponent convertSetupActionOperationComponent(org.hl7.fhir.r5.igs.testing.TestScript.SetupActionOperationComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestScript.SetupActionOperationComponent tgt = new org.hl7.fhir.r5.model.TestScript.SetupActionOperationComponent();
    copyBackboneElement(src, tgt);
    if (src.hasType())
      tgt.setType((src.getType()).copy());
    if (src.hasResource())
      tgt.setResource(src.getResource());
    if (src.hasLabel())
      tgt.setLabelElement((src.getLabelElement()).copy());
    if (src.hasDescription())
      tgt.setDescriptionElement((src.getDescriptionElement()).copy());
    if (src.hasAccept())
      tgt.setAcceptElement((src.getAcceptElement()).copy());
    if (src.hasContentType())
      tgt.setContentTypeElement((src.getContentTypeElement()).copy());
    if (src.hasDestination())
      tgt.setDestinationElement((src.getDestinationElement()).copy());
    if (src.hasEncodeRequestUrl())
      tgt.setEncodeRequestUrlElement((src.getEncodeRequestUrlElement()).copy());
    if (src.hasMethod())
      tgt.setMethodElement(convertTestScriptRequestMethodCodeToR5(src.getMethodElement()));
    if (src.hasOrigin())
      tgt.setOriginElement((src.getOriginElement()).copy());
    if (src.hasParams())
      tgt.setParamsElement((src.getParamsElement()).copy());
    for (org.hl7.fhir.r5.igs.testing.TestScript.SetupActionOperationRequestHeaderComponent t : src.getRequestHeaderList())
      tgt.addRequestHeader(convertSetupActionOperationRequestHeaderComponent(t));
    if (src.hasRequestId())
      tgt.setRequestIdElement((src.getRequestIdElement()).copy());
    if (src.hasResponseId())
      tgt.setResponseIdElement((src.getResponseIdElement()).copy());
    if (src.hasSourceId())
      tgt.setSourceIdElement((src.getSourceIdElement()).copy());
    if (src.hasTargetId())
      tgt.setTargetIdElement((src.getTargetIdElement()).copy());
    if (src.hasUrl())
      tgt.setUrlElement((src.getUrlElement()).copy());
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.igs.testing.TestScript.TestScriptRequestMethodCodeValueSet> convertTestScriptRequestMethodCode(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestScript.TestScriptRequestMethodCode> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<TestScript.TestScriptRequestMethodCodeValueSet> tgt = new Enumeration<>(new TestScript.TestScriptRequestMethodCodeValueSetEnumFactory());
      copyElement(src, tgt);
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

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestScript.TestScriptRequestMethodCode> convertTestScriptRequestMethodCodeToR5(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.igs.testing.TestScript.TestScriptRequestMethodCodeValueSet> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestScript.TestScriptRequestMethodCode> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.TestScript.TestScriptRequestMethodCodeEnumFactory());
      copyElement(src, tgt);
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

  public static org.hl7.fhir.r5.igs.testing.TestScript.SetupActionOperationRequestHeaderComponent convertSetupActionOperationRequestHeaderComponent(org.hl7.fhir.r5.model.TestScript.SetupActionOperationRequestHeaderComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.igs.testing.TestScript.SetupActionOperationRequestHeaderComponent tgt = new org.hl7.fhir.r5.igs.testing.TestScript.SetupActionOperationRequestHeaderComponent();
    copyBackboneElement(src, tgt);
    if (src.hasField())
      tgt.setFieldElement((src.getFieldElement()).copy());
    if (src.hasValue())
      tgt.setValueElement((src.getValueElement()).copy());
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestScript.SetupActionOperationRequestHeaderComponent convertSetupActionOperationRequestHeaderComponent(org.hl7.fhir.r5.igs.testing.TestScript.SetupActionOperationRequestHeaderComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestScript.SetupActionOperationRequestHeaderComponent tgt = new org.hl7.fhir.r5.model.TestScript.SetupActionOperationRequestHeaderComponent();
    copyBackboneElement(src, tgt);
    if (src.hasField())
      tgt.setFieldElement((src.getFieldElement()).copy());
    if (src.hasValue())
      tgt.setValueElement((src.getValueElement()).copy());
    return tgt;
  }

  public static org.hl7.fhir.r5.igs.testing.TestScript.SetupActionAssertComponent convertSetupActionAssertComponent(org.hl7.fhir.r5.model.TestScript.SetupActionAssertComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.igs.testing.TestScript.SetupActionAssertComponent tgt = new org.hl7.fhir.r5.igs.testing.TestScript.SetupActionAssertComponent();
    copyBackboneElement(src, tgt);
    if (src.hasStopTestOnFail())
      tgt.setStopTestOnFailElement(src.getStopTestOnFailElement().copy());
    if (src.hasLabel())
      tgt.setLabelElement((src.getLabelElement()).copy());
    if (src.hasDescription())
      tgt.setDescriptionElement((src.getDescriptionElement()).copy());
    if (src.hasDirection())
      tgt.setDirectionElement(convertAssertionDirectionType(src.getDirectionElement()));
    if (src.hasCompareToSourceId())
      tgt.setCompareToSourceIdElement((src.getCompareToSourceIdElement()).copy());
    if (src.hasCompareToSourceExpression())
      tgt.setCompareToSourceExpression(convertExpression(src.getCompareToSourceExpressionElement()));
    if (src.hasCompareToSourcePath())
      tgt.setCompareToSourcePathElement((src.getCompareToSourcePathElement()).copy());
    if (src.hasContentType())
      tgt.setContentTypeElement((src.getContentTypeElement()).copy());
    if (src.hasExpression())
      tgt.setExpression(convertExpression(src.getExpressionElement()));
    if (src.hasHeaderField())
      tgt.setHeaderFieldElement((src.getHeaderFieldElement()).copy());
    if (src.hasMinimumId())
      tgt.setMinimumIdElement((src.getMinimumIdElement()).copy());
    if (src.hasNavigationLinks())
      tgt.setNavigationLinksElement((src.getNavigationLinksElement()).copy());
    if (src.hasOperator())
      tgt.setOperatorElement(convertAssertionOperatorType(src.getOperatorElement()));
    if (src.hasPath())
      tgt.setPathElement((src.getPathElement()).copy());
    if (src.hasRequestMethod())
      tgt.setRequestMethodElement(convertTestScriptRequestMethodCode(src.getRequestMethodElement()));
    if (src.hasRequestURL())
      tgt.setRequestURLElement((src.getRequestURLElement()).copy());
    if (src.hasResource())
      tgt.setResource(src.getResource());
    if (src.hasResponse())
      tgt.setResponseElement(convertAssertionResponseTypes(src.getResponseElement()));
    if (src.hasResponseCode())
      tgt.setResponseCodeElement((src.getResponseCodeElement()).copy());
    if (src.hasSourceId())
      tgt.setSourceIdElement((src.getSourceIdElement()).copy());
    if (src.hasValidateProfileId())
      tgt.setValidateProfileIdElement((src.getValidateProfileIdElement()).copy());
    if (src.hasValue())
      tgt.setValueElement((src.getValueElement()).copy());
    if (src.hasWarningOnly())
      tgt.setWarningOnlyElement((src.getWarningOnlyElement()).copy());
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestScript.SetupActionAssertComponent convertSetupActionAssertComponent(org.hl7.fhir.r5.igs.testing.TestScript.SetupActionAssertComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestScript.SetupActionAssertComponent tgt = new org.hl7.fhir.r5.model.TestScript.SetupActionAssertComponent();
    copyBackboneElement(src, tgt);
    if (src.hasStopTestOnFail())
      tgt.setStopTestOnFailElement(src.getStopTestOnFailElement().copy());
    if (src.hasLabel())
      tgt.setLabelElement((src.getLabelElement()).copy());
    if (src.hasDescription())
      tgt.setDescriptionElement((src.getDescriptionElement()).copy());
    if (src.hasDirection())
      tgt.setDirectionElement(convertAssertionDirectionTypeToR5(src.getDirectionElement()));
    if (src.hasCompareToSourceId())
      tgt.setCompareToSourceIdElement((src.getCompareToSourceIdElement()).copy());
    if (src.hasCompareToSourceExpression())
      tgt.setCompareToSourceExpressionElement(convertExpression(src.getCompareToSourceExpression()));
    if (src.hasCompareToSourcePath())
      tgt.setCompareToSourcePathElement((src.getCompareToSourcePathElement()).copy());
    if (src.hasContentType())
      tgt.setContentTypeElement((src.getContentTypeElement()).copy());
    if (src.hasExpression())
      tgt.setExpressionElement(convertExpression(src.getExpression()));
    if (src.hasHeaderField())
      tgt.setHeaderFieldElement((src.getHeaderFieldElement()).copy());
    if (src.hasMinimumId())
      tgt.setMinimumIdElement((src.getMinimumIdElement()).copy());
    if (src.hasNavigationLinks())
      tgt.setNavigationLinksElement((src.getNavigationLinksElement()).copy());
    if (src.hasOperator())
      tgt.setOperatorElement(convertAssertionOperatorTypeToR5(src.getOperatorElement()));
    if (src.hasPath())
      tgt.setPathElement((src.getPathElement()).copy());
    if (src.hasRequestMethod())
      tgt.setRequestMethodElement(convertTestScriptRequestMethodCodeToR5(src.getRequestMethodElement()));
    if (src.hasRequestURL())
      tgt.setRequestURLElement((src.getRequestURLElement()).copy());
    if (src.hasResource())
      tgt.setResource(src.getResource());
    if (src.hasResponse())
      tgt.setResponseElement(convertAssertionResponseTypesToR5(src.getResponseElement()));
    if (src.hasResponseCode())
      tgt.setResponseCodeElement((src.getResponseCodeElement()).copy());
    if (src.hasSourceId())
      tgt.setSourceIdElement((src.getSourceIdElement()).copy());
    if (src.hasValidateProfileId())
      tgt.setValidateProfileIdElement((src.getValidateProfileIdElement()).copy());
    if (src.hasValue())
      tgt.setValueElement((src.getValueElement()).copy());
    if (src.hasWarningOnly())
      tgt.setWarningOnlyElement((src.getWarningOnlyElement()).copy());
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.igs.testing.TestScript.AssertionDirectionTypeValueSet> convertAssertionDirectionType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestScript.AssertionDirectionType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<TestScript.AssertionDirectionTypeValueSet> tgt = new Enumeration<>(new TestScript.AssertionDirectionTypeValueSetEnumFactory());
      copyElement(src, tgt);
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

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestScript.AssertionDirectionType> convertAssertionDirectionTypeToR5(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.igs.testing.TestScript.AssertionDirectionTypeValueSet> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestScript.AssertionDirectionType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.TestScript.AssertionDirectionTypeEnumFactory());
      copyElement(src, tgt);
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

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.igs.testing.TestScript.AssertionOperatorTypeValueSet> convertAssertionOperatorType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestScript.AssertionOperatorType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<TestScript.AssertionOperatorTypeValueSet> tgt = new Enumeration<>(new TestScript.AssertionOperatorTypeValueSetEnumFactory());
      copyElement(src, tgt);
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

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestScript.AssertionOperatorType> convertAssertionOperatorTypeToR5(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.igs.testing.TestScript.AssertionOperatorTypeValueSet> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestScript.AssertionOperatorType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.TestScript.AssertionOperatorTypeEnumFactory());
      copyElement(src, tgt);
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

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.igs.testing.TestScript.AssertionResponseTypesValueSet> convertAssertionResponseTypes(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestScript.AssertionResponseTypes> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<TestScript.AssertionResponseTypesValueSet> tgt = new Enumeration<>(new TestScript.AssertionResponseTypesValueSetEnumFactory());
      copyElement(src, tgt);
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

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestScript.AssertionResponseTypes> convertAssertionResponseTypesToR5(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.igs.testing.TestScript.AssertionResponseTypesValueSet> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestScript.AssertionResponseTypes> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.TestScript.AssertionResponseTypesEnumFactory());
      copyElement(src, tgt);
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

  public static org.hl7.fhir.r5.igs.testing.TestScript.TestScriptTestComponent convertTestScriptTestComponent(org.hl7.fhir.r5.model.TestScript.TestScriptTestComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.igs.testing.TestScript.TestScriptTestComponent tgt = new org.hl7.fhir.r5.igs.testing.TestScript.TestScriptTestComponent();
    copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement((src.getNameElement()).copy());
    if (src.hasDescription())
      tgt.setDescriptionElement((src.getDescriptionElement()).copy());
    for (org.hl7.fhir.r5.model.TestScript.TestActionComponent t : src.getAction())
      tgt.addAction(convertTestActionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestScript.TestScriptTestComponent convertTestScriptTestComponent(org.hl7.fhir.r5.igs.testing.TestScript.TestScriptTestComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestScript.TestScriptTestComponent tgt = new org.hl7.fhir.r5.model.TestScript.TestScriptTestComponent();
    copyBackboneElement(src, tgt);
    if (src.hasName())
      tgt.setNameElement((src.getNameElement()).copy());
    if (src.hasDescription())
      tgt.setDescriptionElement((src.getDescriptionElement()).copy());
    for (org.hl7.fhir.r5.igs.testing.TestScript.TestActionComponent t : src.getActionList())
      tgt.addAction(convertTestActionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.igs.testing.TestScript.TestActionComponent convertTestActionComponent(org.hl7.fhir.r5.model.TestScript.TestActionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.igs.testing.TestScript.TestActionComponent tgt = new org.hl7.fhir.r5.igs.testing.TestScript.TestActionComponent();
    copyBackboneElement(src, tgt);
    if (src.hasOperation())
      tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    if (src.hasAssert())
      tgt.setAssert(convertSetupActionAssertComponent(src.getAssert()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestScript.TestActionComponent convertTestActionComponent(org.hl7.fhir.r5.igs.testing.TestScript.TestActionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestScript.TestActionComponent tgt = new org.hl7.fhir.r5.model.TestScript.TestActionComponent();
    copyBackboneElement(src, tgt);
    if (src.hasOperation())
      tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    if (src.hasAssert())
      tgt.setAssert(convertSetupActionAssertComponent(src.getAssert()));
    return tgt;
  }

  public static org.hl7.fhir.r5.igs.testing.TestScript.TestScriptTeardownComponent convertTestScriptTeardownComponent(org.hl7.fhir.r5.model.TestScript.TestScriptTeardownComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.igs.testing.TestScript.TestScriptTeardownComponent tgt = new org.hl7.fhir.r5.igs.testing.TestScript.TestScriptTeardownComponent();
    copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r5.model.TestScript.TeardownActionComponent t : src.getAction())
      tgt.addAction(convertTeardownActionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestScript.TestScriptTeardownComponent convertTestScriptTeardownComponent(org.hl7.fhir.r5.igs.testing.TestScript.TestScriptTeardownComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestScript.TestScriptTeardownComponent tgt = new org.hl7.fhir.r5.model.TestScript.TestScriptTeardownComponent();
    copyBackboneElement(src, tgt);
    for (org.hl7.fhir.r5.igs.testing.TestScript.TeardownActionComponent t : src.getActionList())
      tgt.addAction(convertTeardownActionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.igs.testing.TestScript.TeardownActionComponent convertTeardownActionComponent(org.hl7.fhir.r5.model.TestScript.TeardownActionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.igs.testing.TestScript.TeardownActionComponent tgt = new org.hl7.fhir.r5.igs.testing.TestScript.TeardownActionComponent();
    copyBackboneElement(src, tgt);
    if (src.hasOperation())
      tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestScript.TeardownActionComponent convertTeardownActionComponent(org.hl7.fhir.r5.igs.testing.TestScript.TeardownActionComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestScript.TeardownActionComponent tgt = new org.hl7.fhir.r5.model.TestScript.TeardownActionComponent();
    copyBackboneElement(src, tgt);
    if (src.hasOperation())
      tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    return tgt;
  }

  // ============================================================================================
  // TestPlan <-> Basic
  //
  // The testing-IG TestPlan is a ground-up redesign relative to the R5
  // TestPlan, so rather than converting to the R5 TestPlan we round-trip the whole resource through
  // Basic, carrying every element as an extension - the same technique Requirements40_50 /
  // TestPlan40_50 use for resources with no representation in the target version. The extension URLs
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

  public static org.hl7.fhir.r5.model.Basic convertTestPlan(org.hl7.fhir.r5.igs.testing.TestPlan src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.Basic tgt = new org.hl7.fhir.r5.model.Basic();
    copyDomainResource(src, tgt);
    tgt.getCode().getCodingFirstRep().setSystem("http://hl7.org/fhir/fhir-types").setCode("TestPlan");
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifierList())
      tgt.getIdentifier().add((t).copy());
    if (src.hasUrl())
      tgt.addExtension(TP_URL, (src.getUrlElement()).copy());
    if (src.hasVersion())
      tgt.addExtension(TP_VERSION, (src.getVersionElement()).copy());
    if (src.hasVersionAlgorithm())
      tgt.addExtension(TP_VERSION_ALGORITHM, (src.getVersionAlgorithm()).copy());
    if (src.hasName())
      tgt.addExtension(TP_NAME, (src.getNameElement()).copy());
    if (src.hasTitle())
      tgt.addExtension(TP_TITLE, (src.getTitleElement()).copy());
    if (src.hasStatus())
      tgt.addExtension(TP_STATUS, new org.hl7.fhir.r5.model.CodeType(src.getStatus().toCode()));
    if (src.hasExperimental())
      tgt.addExtension(TP_EXPERIMENTAL, (src.getExperimentalElement()).copy());
    if (src.hasDate())
      tgt.addExtension(TP_DATE, (src.getDateElement()).copy());
    if (src.hasPublisher())
      tgt.addExtension(TP_PUBLISHER, (src.getPublisherElement()).copy());
    for (org.hl7.fhir.r5.model.ContactDetail t : src.getContactList())
      tgt.addExtension(TP_CONTACT, (t).copy());
    if (src.hasDescription())
      tgt.addExtension(TP_DESCRIPTION, (src.getDescriptionElement()).copy());
    for (org.hl7.fhir.r5.model.UsageContext t : src.getUseContextList())
      tgt.addExtension(TP_USE_CONTEXT, (t).copy());
    for (org.hl7.fhir.r5.model.CodeableConcept t : src.getJurisdictionList())
      tgt.addExtension(TP_JURISDICTION, (t).copy());
    if (src.hasPurpose())
      tgt.addExtension(TP_PURPOSE, (src.getPurposeElement()).copy());
    if (src.hasCopyright())
      tgt.addExtension(TP_COPYRIGHT, (src.getCopyrightElement()).copy());
    if (src.hasCopyrightLabel())
      tgt.addExtension(TP_COPYRIGHT_LABEL, (src.getCopyrightLabelElement()).copy());
    for (org.hl7.fhir.r5.igs.testing.TestPlan.TestPlanScopeComponent t : src.getScopeList()) {
      org.hl7.fhir.r5.model.Extension tgte = new org.hl7.fhir.r5.model.Extension(TP_SCOPE);
      tgt.addExtension(tgte);
      convertTestPlanScope(t, tgte);
    }
    for (org.hl7.fhir.r5.igs.testing.TestPlan.TestPlanDependencyComponent t : src.getDependencyList()) {
      org.hl7.fhir.r5.model.Extension tgte = new org.hl7.fhir.r5.model.Extension(TP_DEPENDENCY);
      tgt.addExtension(tgte);
      convertTestPlanDependency(t, tgte);
    }
    if (src.hasRunner())
      tgt.addExtension(TP_RUNNER, (src.getRunnerElement()).copy());
    for (org.hl7.fhir.r5.igs.testing.TestPlan.TestPlanModeComponent t : src.getModeList()) {
      org.hl7.fhir.r5.model.Extension tgte = new org.hl7.fhir.r5.model.Extension(TP_MODE);
      tgt.addExtension(tgte);
      convertTestPlanMode(t, tgte);
    }
    for (org.hl7.fhir.r5.igs.testing.TestPlan.TestPlanParameterComponent t : src.getParameterList()) {
      org.hl7.fhir.r5.model.Extension tgte = new org.hl7.fhir.r5.model.Extension(TP_PARAMETER);
      tgt.addExtension(tgte);
      convertTestPlanParameter(t, tgte);
    }
    for (org.hl7.fhir.r5.igs.testing.TestPlan.TestPlanSuiteComponent t : src.getSuiteList()) {
      org.hl7.fhir.r5.model.Extension tgte = new org.hl7.fhir.r5.model.Extension(TP_SUITE);
      tgt.addExtension(tgte);
      convertTestPlanSuite(t, tgte, tgt);
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.igs.testing.TestPlan convertTestPlan(org.hl7.fhir.r5.model.Basic src) throws FHIRException {
    if (src == null)
      return null;
    if (!src.getCode().hasCoding("http://hl7.org/fhir/fhir-types", "TestPlan")) {
      throw new FHIRException("Error in logic: this Basic resource is not a TestPlan");
    }
    org.hl7.fhir.r5.igs.testing.TestPlan tgt = new org.hl7.fhir.r5.igs.testing.TestPlan();
    copyDomainResource(src, tgt, TP_IGNORED_EXTENSION_URLS);
    for (org.hl7.fhir.r5.model.Identifier t : src.getIdentifier())
      tgt.getIdentifierList().add((t).copy());
    if (src.hasExtension(TP_URL))
      tgt.setUrlElement(((org.hl7.fhir.r5.model.UriType) src.getExtensionByUrl(TP_URL).getValue()).copy());
    if (src.hasExtension(TP_VERSION))
      tgt.setVersionElement(((org.hl7.fhir.r5.model.StringType) src.getExtensionByUrl(TP_VERSION).getValue()).copy());
    if (src.hasExtension(TP_VERSION_ALGORITHM))
      tgt.setVersionAlgorithm((src.getExtensionByUrl(TP_VERSION_ALGORITHM).getValue()).copy());
    if (src.hasExtension(TP_NAME))
      tgt.setNameElement(((org.hl7.fhir.r5.model.StringType) src.getExtensionByUrl(TP_NAME).getValue()).copy());
    if (src.hasExtension(TP_TITLE))
      tgt.setTitleElement(((org.hl7.fhir.r5.model.StringType) src.getExtensionByUrl(TP_TITLE).getValue()).copy());
    if (src.hasExtension(TP_STATUS))
      tgt.setStatus(org.hl7.fhir.r5.model.Enumerations.PublicationStatus.fromCode(src.getExtensionByUrl(TP_STATUS).getValue().primitiveValue()));
    if (src.hasExtension(TP_EXPERIMENTAL))
      tgt.setExperimentalElement(((org.hl7.fhir.r5.model.BooleanType) src.getExtensionByUrl(TP_EXPERIMENTAL).getValue()).copy());
    if (src.hasExtension(TP_DATE))
      tgt.setDateElement(((org.hl7.fhir.r5.model.DateTimeType) src.getExtensionByUrl(TP_DATE).getValue()).copy());
    if (src.hasExtension(TP_PUBLISHER))
      tgt.setPublisherElement(((org.hl7.fhir.r5.model.StringType) src.getExtensionByUrl(TP_PUBLISHER).getValue()).copy());
    for (org.hl7.fhir.r5.model.Extension ext : src.getExtensionsByUrl(TP_CONTACT))
      tgt.getContactList().add(((org.hl7.fhir.r5.model.ContactDetail) ext.getValue()).copy());
    if (src.hasExtension(TP_DESCRIPTION))
      tgt.setDescriptionElement(((org.hl7.fhir.r5.model.MarkdownType) src.getExtensionByUrl(TP_DESCRIPTION).getValue()).copy());
    for (org.hl7.fhir.r5.model.Extension ext : src.getExtensionsByUrl(TP_USE_CONTEXT))
      tgt.getUseContextList().add(((org.hl7.fhir.r5.model.UsageContext) ext.getValue()).copy());
    for (org.hl7.fhir.r5.model.Extension ext : src.getExtensionsByUrl(TP_JURISDICTION))
      tgt.getJurisdictionList().add(((org.hl7.fhir.r5.model.CodeableConcept) ext.getValue()).copy());
    if (src.hasExtension(TP_PURPOSE))
      tgt.setPurposeElement(((org.hl7.fhir.r5.model.MarkdownType) src.getExtensionByUrl(TP_PURPOSE).getValue()).copy());
    if (src.hasExtension(TP_COPYRIGHT))
      tgt.setCopyrightElement(((org.hl7.fhir.r5.model.MarkdownType) src.getExtensionByUrl(TP_COPYRIGHT).getValue()).copy());
    if (src.hasExtension(TP_COPYRIGHT_LABEL))
      tgt.setCopyrightLabelElement(((org.hl7.fhir.r5.model.StringType) src.getExtensionByUrl(TP_COPYRIGHT_LABEL).getValue()).copy());
    for (org.hl7.fhir.r5.model.Extension ext : src.getExtensionsByUrl(TP_SCOPE))
      convertTestPlanScope(ext, tgt.addScope());
    for (org.hl7.fhir.r5.model.Extension ext : src.getExtensionsByUrl(TP_DEPENDENCY))
      convertTestPlanDependency(ext, tgt.addDependency());
    if (src.hasExtension(TP_RUNNER))
      tgt.setRunnerElement(((org.hl7.fhir.r5.model.UrlType) src.getExtensionByUrl(TP_RUNNER).getValue()).copy());
    for (org.hl7.fhir.r5.model.Extension ext : src.getExtensionsByUrl(TP_MODE))
      convertTestPlanMode(ext, tgt.addMode());
    for (org.hl7.fhir.r5.model.Extension ext : src.getExtensionsByUrl(TP_PARAMETER))
      convertTestPlanParameter(ext, tgt.addParameter());
    for (org.hl7.fhir.r5.model.Extension ext : src.getExtensionsByUrl(TP_SUITE))
      convertTestPlanSuite(ext, tgt.addSuite(), src);
    // the input resources were carried as contained resources (id "tpc-N") and have now been
    // re-inlined into their inputs; drop them from the resource-level contained list that
    // copyDomainResource brought across
    tgt.getContained().removeIf(r -> r.hasId() && r.getIdPart() != null && r.getIdPart().startsWith("tpc-"));
    return tgt;
  }

  private static void convertTestPlanScope(org.hl7.fhir.r5.igs.testing.TestPlan.TestPlanScopeComponent src, org.hl7.fhir.r5.model.Extension tgt) throws FHIRException {
    copyElement(src, tgt);
    if (src.hasReference())
      tgt.addExtension("reference", (src.getReferenceElement()).copy());
    if (src.hasDescription())
      tgt.addExtension("description", (src.getDescriptionElement()).copy());
  }

  private static void convertTestPlanScope(org.hl7.fhir.r5.model.Extension src, org.hl7.fhir.r5.igs.testing.TestPlan.TestPlanScopeComponent tgt) throws FHIRException {
    copyElement(src, tgt, "reference", "description");
    if (src.hasExtension("reference"))
      tgt.setReferenceElement(((org.hl7.fhir.r5.model.CanonicalType) src.getExtensionByUrl("reference").getValue()).copy());
    if (src.hasExtension("description"))
      tgt.setDescriptionElement(((org.hl7.fhir.r5.model.StringType) src.getExtensionByUrl("description").getValue()).copy());
  }

  private static void convertTestPlanDependency(org.hl7.fhir.r5.igs.testing.TestPlan.TestPlanDependencyComponent src, org.hl7.fhir.r5.model.Extension tgt) throws FHIRException {
    copyElement(src, tgt);
    if (src.hasReference())
      tgt.addExtension("reference", (src.getReferenceElement()).copy());
    if (src.hasDescription())
      tgt.addExtension("description", (src.getDescriptionElement()).copy());
  }

  private static void convertTestPlanDependency(org.hl7.fhir.r5.model.Extension src, org.hl7.fhir.r5.igs.testing.TestPlan.TestPlanDependencyComponent tgt) throws FHIRException {
    copyElement(src, tgt, "reference", "description");
    if (src.hasExtension("reference"))
      tgt.setReferenceElement(((org.hl7.fhir.r5.model.CanonicalType) src.getExtensionByUrl("reference").getValue()).copy());
    if (src.hasExtension("description"))
      tgt.setDescriptionElement(((org.hl7.fhir.r5.model.StringType) src.getExtensionByUrl("description").getValue()).copy());
  }

  private static void convertTestPlanMode(org.hl7.fhir.r5.igs.testing.TestPlan.TestPlanModeComponent src, org.hl7.fhir.r5.model.Extension tgt) throws FHIRException {
    copyElement(src, tgt);
    if (src.hasCode())
      tgt.addExtension("code", (src.getCodeElement()).copy());
    if (src.hasDescription())
      tgt.addExtension("description", (src.getDescriptionElement()).copy());
  }

  private static void convertTestPlanMode(org.hl7.fhir.r5.model.Extension src, org.hl7.fhir.r5.igs.testing.TestPlan.TestPlanModeComponent tgt) throws FHIRException {
    copyElement(src, tgt, "code", "description");
    if (src.hasExtension("code"))
      tgt.setCodeElement(((org.hl7.fhir.r5.model.StringType) src.getExtensionByUrl("code").getValue()).copy());
    if (src.hasExtension("description"))
      tgt.setDescriptionElement(((org.hl7.fhir.r5.model.StringType) src.getExtensionByUrl("description").getValue()).copy());
  }

  private static void convertTestPlanParameter(org.hl7.fhir.r5.igs.testing.TestPlan.TestPlanParameterComponent src, org.hl7.fhir.r5.model.Extension tgt) throws FHIRException {
    copyElement(src, tgt);
    if (src.hasName())
      tgt.addExtension("name", (src.getNameElement()).copy());
    if (src.hasValue())
      tgt.addExtension("value", (src.getValue()).copy());
    if (src.hasMode())
      tgt.addExtension("mode", (src.getModeElement()).copy());
  }

  private static void convertTestPlanParameter(org.hl7.fhir.r5.model.Extension src, org.hl7.fhir.r5.igs.testing.TestPlan.TestPlanParameterComponent tgt) throws FHIRException {
    copyElement(src, tgt, "name", "value", "mode");
    if (src.hasExtension("name"))
      tgt.setNameElement(((org.hl7.fhir.r5.model.StringType) src.getExtensionByUrl("name").getValue()).copy());
    if (src.hasExtension("value"))
      tgt.setValue((src.getExtensionByUrl("value").getValue()).copy());
    if (src.hasExtension("mode"))
      tgt.setModeElement(((org.hl7.fhir.r5.model.CodeType) src.getExtensionByUrl("mode").getValue()).copy());
  }

  private static void convertTestPlanSuite(org.hl7.fhir.r5.igs.testing.TestPlan.TestPlanSuiteComponent src, org.hl7.fhir.r5.model.Extension tgt, org.hl7.fhir.r5.model.Basic basic) throws FHIRException {
    copyElement(src, tgt);
    if (src.hasName())
      tgt.addExtension("name", (src.getNameElement()).copy());
    if (src.hasDescription())
      tgt.addExtension("description", (src.getDescriptionElement()).copy());
    if (src.hasMode())
      tgt.addExtension("mode", (src.getModeElement()).copy());
    for (org.hl7.fhir.r5.igs.testing.TestPlan.TestPlanSuiteInputComponent t : src.getInputList()) {
      org.hl7.fhir.r5.model.Extension e = new org.hl7.fhir.r5.model.Extension("input");
      tgt.addExtension(e);
      convertTestPlanSuiteInput(t, e, basic);
    }
    for (org.hl7.fhir.r5.igs.testing.TestPlan.TestPlanParameterComponent t : src.getParameterList()) {
      org.hl7.fhir.r5.model.Extension e = new org.hl7.fhir.r5.model.Extension("parameter");
      tgt.addExtension(e);
      convertTestPlanParameter(t, e);
    }
    for (org.hl7.fhir.r5.igs.testing.TestPlan.TestPlanSuiteTestComponent t : src.getTestList()) {
      org.hl7.fhir.r5.model.Extension e = new org.hl7.fhir.r5.model.Extension("test");
      tgt.addExtension(e);
      convertTestPlanSuiteTest(t, e, basic);
    }
    for (org.hl7.fhir.r5.igs.testing.TestPlan.TestPlanSuiteComponent t : src.getSuiteList()) {
      org.hl7.fhir.r5.model.Extension e = new org.hl7.fhir.r5.model.Extension("suite");
      tgt.addExtension(e);
      convertTestPlanSuite(t, e, basic);
    }
    for (org.hl7.fhir.r5.model.Reference t : src.getPlanList())
      tgt.addExtension("plan", (t).copy());
  }

  private static void convertTestPlanSuite(org.hl7.fhir.r5.model.Extension src, org.hl7.fhir.r5.igs.testing.TestPlan.TestPlanSuiteComponent tgt, org.hl7.fhir.r5.model.Basic basic) throws FHIRException {
    copyElement(src, tgt, "name", "description", "mode", "input", "parameter", "test", "suite", "plan");
    if (src.hasExtension("name"))
      tgt.setNameElement(((org.hl7.fhir.r5.model.StringType) src.getExtensionByUrl("name").getValue()).copy());
    if (src.hasExtension("description"))
      tgt.setDescriptionElement(((org.hl7.fhir.r5.model.StringType) src.getExtensionByUrl("description").getValue()).copy());
    if (src.hasExtension("mode"))
      tgt.setModeElement(((org.hl7.fhir.r5.model.CodeType) src.getExtensionByUrl("mode").getValue()).copy());
    for (org.hl7.fhir.r5.model.Extension ext : src.getExtensionsByUrl("input"))
      convertTestPlanSuiteInput(ext, tgt.addInput(), basic);
    for (org.hl7.fhir.r5.model.Extension ext : src.getExtensionsByUrl("parameter"))
      convertTestPlanParameter(ext, tgt.addParameter());
    for (org.hl7.fhir.r5.model.Extension ext : src.getExtensionsByUrl("test"))
      convertTestPlanSuiteTest(ext, tgt.addTest(), basic);
    for (org.hl7.fhir.r5.model.Extension ext : src.getExtensionsByUrl("suite"))
      convertTestPlanSuite(ext, tgt.addSuite(), basic);
    for (org.hl7.fhir.r5.model.Extension ext : src.getExtensionsByUrl("plan"))
      tgt.getPlanList().add(((org.hl7.fhir.r5.model.Reference) ext.getValue()).copy());
  }

  private static void convertTestPlanSuiteInput(org.hl7.fhir.r5.igs.testing.TestPlan.TestPlanSuiteInputComponent src, org.hl7.fhir.r5.model.Extension tgt, org.hl7.fhir.r5.model.Basic basic) throws FHIRException {
    copyElement(src, tgt);
    if (src.hasName())
      tgt.addExtension("name", (src.getNameElement()).copy());
    if (src.hasFile())
      tgt.addExtension("file", (src.getFileElement()).copy());
    if (src.hasResource()) {
      org.hl7.fhir.r5.model.Resource r = (src.getResource()).copy();
      String id = "tpc-" + (basic.getContained().size() + 1);
      r.setId(id);
      basic.getContained().add(r);
      tgt.addExtension("resource", new org.hl7.fhir.r5.model.Reference("#" + id));
    }
    if (src.hasMode())
      tgt.addExtension("mode", (src.getModeElement()).copy());
  }

  private static void convertTestPlanSuiteInput(org.hl7.fhir.r5.model.Extension src, org.hl7.fhir.r5.igs.testing.TestPlan.TestPlanSuiteInputComponent tgt, org.hl7.fhir.r5.model.Basic basic) throws FHIRException {
    copyElement(src, tgt, "name", "file", "resource", "mode");
    if (src.hasExtension("name"))
      tgt.setNameElement(((org.hl7.fhir.r5.model.StringType) src.getExtensionByUrl("name").getValue()).copy());
    if (src.hasExtension("file"))
      tgt.setFileElement(((org.hl7.fhir.r5.model.StringType) src.getExtensionByUrl("file").getValue()).copy());
    if (src.hasExtension("resource")) {
      String ref = ((org.hl7.fhir.r5.model.Reference) src.getExtensionByUrl("resource").getValue()).getReference();
      String id = ref != null && ref.startsWith("#") ? ref.substring(1) : ref;
      for (org.hl7.fhir.r5.model.Resource c : basic.getContained()) {
        if (id != null && id.equals(c.getIdPart())) {
          org.hl7.fhir.r5.model.Resource r = (c).copy();
          if (r.hasId() && r.getIdPart() != null && r.getIdPart().startsWith("tpc-"))
            r.setIdBase(null);
          tgt.setResource(r);
        }
      }
    }
    if (src.hasExtension("mode"))
      tgt.setModeElement(((org.hl7.fhir.r5.model.CodeType) src.getExtensionByUrl("mode").getValue()).copy());
  }

  private static void convertTestPlanSuiteTest(org.hl7.fhir.r5.igs.testing.TestPlan.TestPlanSuiteTestComponent src, org.hl7.fhir.r5.model.Extension tgt, org.hl7.fhir.r5.model.Basic basic) throws FHIRException {
    copyElement(src, tgt);
    if (src.hasName())
      tgt.addExtension("name", (src.getNameElement()).copy());
    if (src.hasDescription())
      tgt.addExtension("description", (src.getDescriptionElement()).copy());
    if (src.hasOperation())
      tgt.addExtension("operation", (src.getOperationElement()).copy());
    if (src.hasMode())
      tgt.addExtension("mode", (src.getModeElement()).copy());
    for (org.hl7.fhir.r5.igs.testing.TestPlan.TestPlanParameterComponent t : src.getParameterList()) {
      org.hl7.fhir.r5.model.Extension e = new org.hl7.fhir.r5.model.Extension("parameter");
      tgt.addExtension(e);
      convertTestPlanParameter(t, e);
    }
    for (org.hl7.fhir.r5.igs.testing.TestPlan.TestPlanSuiteInputComponent t : src.getInputList()) {
      org.hl7.fhir.r5.model.Extension e = new org.hl7.fhir.r5.model.Extension("input");
      tgt.addExtension(e);
      convertTestPlanSuiteInput(t, e, basic);
    }
    for (org.hl7.fhir.r5.igs.testing.TestPlan.TestPlanSuiteInputComponent t : src.getExpectedList()) {
      org.hl7.fhir.r5.model.Extension e = new org.hl7.fhir.r5.model.Extension("expected");
      tgt.addExtension(e);
      convertTestPlanSuiteInput(t, e, basic);
    }
    for (org.hl7.fhir.r5.igs.testing.TestPlan.TestPlanSuiteTestAssertionComponent t : src.getAssertionList()) {
      org.hl7.fhir.r5.model.Extension e = new org.hl7.fhir.r5.model.Extension("assertion");
      tgt.addExtension(e);
      convertTestPlanAssertion(t, e);
    }
  }

  private static void convertTestPlanSuiteTest(org.hl7.fhir.r5.model.Extension src, org.hl7.fhir.r5.igs.testing.TestPlan.TestPlanSuiteTestComponent tgt, org.hl7.fhir.r5.model.Basic basic) throws FHIRException {
    copyElement(src, tgt, "name", "description", "operation", "mode", "parameter", "input", "expected", "assertion");
    if (src.hasExtension("name"))
      tgt.setNameElement(((org.hl7.fhir.r5.model.StringType) src.getExtensionByUrl("name").getValue()).copy());
    if (src.hasExtension("description"))
      tgt.setDescriptionElement(((org.hl7.fhir.r5.model.StringType) src.getExtensionByUrl("description").getValue()).copy());
    if (src.hasExtension("operation"))
      tgt.setOperationElement(((org.hl7.fhir.r5.model.CodeType) src.getExtensionByUrl("operation").getValue()).copy());
    if (src.hasExtension("mode"))
      tgt.setModeElement(((org.hl7.fhir.r5.model.CodeType) src.getExtensionByUrl("mode").getValue()).copy());
    for (org.hl7.fhir.r5.model.Extension ext : src.getExtensionsByUrl("parameter"))
      convertTestPlanParameter(ext, tgt.addParameter());
    for (org.hl7.fhir.r5.model.Extension ext : src.getExtensionsByUrl("input"))
      convertTestPlanSuiteInput(ext, tgt.addInput(), basic);
    for (org.hl7.fhir.r5.model.Extension ext : src.getExtensionsByUrl("expected"))
      convertTestPlanSuiteInput(ext, tgt.addExpected(), basic);
    for (org.hl7.fhir.r5.model.Extension ext : src.getExtensionsByUrl("assertion"))
      convertTestPlanAssertion(ext, tgt.addAssertion());
  }

  private static void convertTestPlanAssertion(org.hl7.fhir.r5.igs.testing.TestPlan.TestPlanSuiteTestAssertionComponent src, org.hl7.fhir.r5.model.Extension tgt) throws FHIRException {
    copyElement(src, tgt);
    if (src.hasFocus())
      tgt.addExtension("focus", (src.getFocusElement()).copy());
    if (src.hasSeverity())
      tgt.addExtension("severity", (src.getSeverityElement()).copy());
    if (src.hasExpression())
      tgt.addExtension("expression", (src.getExpression()).copy());
    if (src.hasHuman())
      tgt.addExtension("human", (src.getHumanElement()).copy());
    if (src.hasMode())
      tgt.addExtension("mode", (src.getModeElement()).copy());
  }

  private static void convertTestPlanAssertion(org.hl7.fhir.r5.model.Extension src, org.hl7.fhir.r5.igs.testing.TestPlan.TestPlanSuiteTestAssertionComponent tgt) throws FHIRException {
    copyElement(src, tgt, "focus", "severity", "expression", "human", "mode");
    if (src.hasExtension("focus"))
      tgt.setFocusElement(((org.hl7.fhir.r5.model.StringType) src.getExtensionByUrl("focus").getValue()).copy());
    if (src.hasExtension("severity"))
      tgt.setSeverityElement(((org.hl7.fhir.r5.model.CodeType) src.getExtensionByUrl("severity").getValue()).copy());
    if (src.hasExtension("expression"))
      tgt.setExpression(((org.hl7.fhir.r5.model.Expression) src.getExtensionByUrl("expression").getValue()).copy());
    if (src.hasExtension("human"))
      tgt.setHumanElement(((org.hl7.fhir.r5.model.StringType) src.getExtensionByUrl("human").getValue()).copy());
    if (src.hasExtension("mode"))
      tgt.setModeElement(((org.hl7.fhir.r5.model.CodeType) src.getExtensionByUrl("mode").getValue()).copy());
  }

}