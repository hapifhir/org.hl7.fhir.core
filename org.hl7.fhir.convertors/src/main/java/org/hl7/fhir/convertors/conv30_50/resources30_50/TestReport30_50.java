package org.hl7.fhir.convertors.conv30_50.resources30_50;

import org.hl7.fhir.convertors.context.ConversionContext30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.Reference30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.complextypes30_50.Identifier30_50;
import org.hl7.fhir.convertors.conv30_50.datatypes30_50.primitivetypes30_50.*;
import org.hl7.fhir.dstu3.model.Reference;
import org.hl7.fhir.exceptions.FHIRException;

public class TestReport30_50 {

  public static org.hl7.fhir.dstu3.model.TestReport convertTestReport(org.hl7.fhir.r5.model.TestReport src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.TestReport tgt = new org.hl7.fhir.dstu3.model.TestReport();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyDomainResource(src, tgt);
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier30_50.convertIdentifier(src.getIdentifier()));
    if (src.hasName())
      tgt.setNameElement(String30_50.convertString(src.getNameElement()));
    if (src.hasStatus())
      tgt.setStatusElement(convertTestReportStatus(src.getStatusElement()));
    if (src.hasTestScript())
      tgt.setTestScript(new Reference().setReference(src.getTestScript()));
    if (src.hasResult())
      tgt.setResultElement(convertTestReportResult(src.getResultElement()));
    if (src.hasScore())
      tgt.setScoreElement(Decimal30_50.convertDecimal(src.getScoreElement()));
    if (src.hasTester())
      tgt.setTesterElement(String30_50.convertString(src.getTesterElement()));
    if (src.hasIssued())
      tgt.setIssuedElement(DateTime30_50.convertDateTime(src.getIssuedElement()));
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

  public static org.hl7.fhir.r5.model.TestReport convertTestReport(org.hl7.fhir.dstu3.model.TestReport src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestReport tgt = new org.hl7.fhir.r5.model.TestReport();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyDomainResource(src, tgt);
    if (src.hasIdentifier())
      tgt.setIdentifier(Identifier30_50.convertIdentifier(src.getIdentifier()));
    if (src.hasName())
      tgt.setNameElement(String30_50.convertString(src.getNameElement()));
    if (src.hasStatus())
      tgt.setStatusElement(convertTestReportStatus(src.getStatusElement()));
    if (src.hasTestScript())
      tgt.setTestScript(src.getTestScript().getReference());
    if (src.hasResult())
      tgt.setResultElement(convertTestReportResult(src.getResultElement()));
    if (src.hasScore())
      tgt.setScoreElement(Decimal30_50.convertDecimal(src.getScoreElement()));
    if (src.hasTester())
      tgt.setTesterElement(String30_50.convertString(src.getTesterElement()));
    if (src.hasIssued())
      tgt.setIssuedElement(DateTime30_50.convertDateTime(src.getIssuedElement()));
    for (org.hl7.fhir.dstu3.model.TestReport.TestReportParticipantComponent t : src.getParticipant())
      tgt.addParticipant(convertTestReportParticipantComponent(t));
    if (src.hasSetup())
      tgt.setSetup(convertTestReportSetupComponent(src.getSetup()));
    for (org.hl7.fhir.dstu3.model.TestReport.TestReportTestComponent t : src.getTest())
      tgt.addTest(convertTestReportTestComponent(t));
    if (src.hasTeardown())
      tgt.setTeardown(convertTestReportTeardownComponent(src.getTeardown()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.TestReport.TestReportParticipantComponent convertTestReportParticipantComponent(org.hl7.fhir.r5.model.TestReport.TestReportParticipantComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.TestReport.TestReportParticipantComponent tgt = new org.hl7.fhir.dstu3.model.TestReport.TestReportParticipantComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    if (src.hasType())
      tgt.setTypeElement(convertTestReportParticipantType(src.getTypeElement()));
    if (src.hasUri())
      tgt.setUriElement(Uri30_50.convertUri(src.getUriElement()));
    if (src.hasDisplay())
      tgt.setDisplayElement(String30_50.convertString(src.getDisplayElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestReport.TestReportParticipantComponent convertTestReportParticipantComponent(org.hl7.fhir.dstu3.model.TestReport.TestReportParticipantComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestReport.TestReportParticipantComponent tgt = new org.hl7.fhir.r5.model.TestReport.TestReportParticipantComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    if (src.hasType())
      tgt.setTypeElement(convertTestReportParticipantType(src.getTypeElement()));
    if (src.hasUri())
      tgt.setUriElement(Uri30_50.convertUri(src.getUriElement()));
    if (src.hasDisplay())
      tgt.setDisplayElement(String30_50.convertString(src.getDisplayElement()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestReport.TestReportParticipantType> convertTestReportParticipantType(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.TestReport.TestReportParticipantType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestReport.TestReportParticipantType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.TestReport.TestReportParticipantTypeEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
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

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.TestReport.TestReportParticipantType> convertTestReportParticipantType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestReport.TestReportParticipantType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.TestReport.TestReportParticipantType> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.TestReport.TestReportParticipantTypeEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    switch (src.getValue()) {
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

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestReport.TestReportResult> convertTestReportResult(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.TestReport.TestReportResult> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestReport.TestReportResult> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.TestReport.TestReportResultEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
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

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.TestReport.TestReportResult> convertTestReportResult(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestReport.TestReportResult> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.TestReport.TestReportResult> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.TestReport.TestReportResultEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    switch (src.getValue()) {
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

  public static org.hl7.fhir.r5.model.TestReport.TestReportSetupComponent convertTestReportSetupComponent(org.hl7.fhir.dstu3.model.TestReport.TestReportSetupComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestReport.TestReportSetupComponent tgt = new org.hl7.fhir.r5.model.TestReport.TestReportSetupComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    for (org.hl7.fhir.dstu3.model.TestReport.SetupActionComponent t : src.getAction())
      tgt.addAction(convertSetupActionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.TestReport.TestReportSetupComponent convertTestReportSetupComponent(org.hl7.fhir.r5.model.TestReport.TestReportSetupComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.TestReport.TestReportSetupComponent tgt = new org.hl7.fhir.dstu3.model.TestReport.TestReportSetupComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    for (org.hl7.fhir.r5.model.TestReport.SetupActionComponent t : src.getAction())
      tgt.addAction(convertSetupActionComponent(t));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestReport.TestReportStatus> convertTestReportStatus(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.TestReport.TestReportStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestReport.TestReportStatus> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.TestReport.TestReportStatusEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
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

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.TestReport.TestReportStatus> convertTestReportStatus(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestReport.TestReportStatus> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.TestReport.TestReportStatus> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.TestReport.TestReportStatusEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    switch (src.getValue()) {
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

  public static org.hl7.fhir.dstu3.model.TestReport.TestReportTeardownComponent convertTestReportTeardownComponent(org.hl7.fhir.r5.model.TestReport.TestReportTeardownComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.TestReport.TestReportTeardownComponent tgt = new org.hl7.fhir.dstu3.model.TestReport.TestReportTeardownComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    for (org.hl7.fhir.r5.model.TestReport.TeardownActionComponent t : src.getAction())
      tgt.addAction(convertTeardownActionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestReport.TestReportTeardownComponent convertTestReportTeardownComponent(org.hl7.fhir.dstu3.model.TestReport.TestReportTeardownComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestReport.TestReportTeardownComponent tgt = new org.hl7.fhir.r5.model.TestReport.TestReportTeardownComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    for (org.hl7.fhir.dstu3.model.TestReport.TeardownActionComponent t : src.getAction())
      tgt.addAction(convertTeardownActionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.TestReport.TestReportTestComponent convertTestReportTestComponent(org.hl7.fhir.r5.model.TestReport.TestReportTestComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.dstu3.model.TestReport.TestReportTestComponent tgt = new org.hl7.fhir.dstu3.model.TestReport.TestReportTestComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    if (src.hasName())
      tgt.setNameElement(String30_50.convertString(src.getNameElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String30_50.convertString(src.getDescriptionElement()));
    for (org.hl7.fhir.r5.model.TestReport.TestActionComponent t : src.getAction())
      tgt.addAction(convertTestActionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestReport.TestReportTestComponent convertTestReportTestComponent(org.hl7.fhir.dstu3.model.TestReport.TestReportTestComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.TestReport.TestReportTestComponent tgt = new org.hl7.fhir.r5.model.TestReport.TestReportTestComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    if (src.hasName())
      tgt.setNameElement(String30_50.convertString(src.getNameElement()));
    if (src.hasDescription())
      tgt.setDescriptionElement(String30_50.convertString(src.getDescriptionElement()));
    for (org.hl7.fhir.dstu3.model.TestReport.TestActionComponent t : src.getAction())
      tgt.addAction(convertTestActionComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestReport.SetupActionComponent convertSetupActionComponent(org.hl7.fhir.dstu3.model.TestReport.SetupActionComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.TestReport.SetupActionComponent tgt = new org.hl7.fhir.r5.model.TestReport.SetupActionComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    if (src.hasOperation()) tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    if (src.hasAssert()) tgt.setAssert(convertSetupActionAssertComponent(src.getAssert()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.TestReport.SetupActionComponent convertSetupActionComponent(org.hl7.fhir.r5.model.TestReport.SetupActionComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.dstu3.model.TestReport.SetupActionComponent tgt = new org.hl7.fhir.dstu3.model.TestReport.SetupActionComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    if (src.hasOperation()) tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    if (src.hasAssert()) tgt.setAssert(convertSetupActionAssertComponent(src.getAssert()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestReport.SetupActionOperationComponent convertSetupActionOperationComponent(org.hl7.fhir.dstu3.model.TestReport.SetupActionOperationComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.TestReport.SetupActionOperationComponent tgt = new org.hl7.fhir.r5.model.TestReport.SetupActionOperationComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    if (src.hasResult()) tgt.setResultElement(convertTestReportActionResult(src.getResultElement()));
    if (src.hasMessage()) tgt.setMessageElement(MarkDown30_50.convertMarkdown(src.getMessageElement()));
    if (src.hasDetail()) tgt.setDetailElement(Uri30_50.convertUri(src.getDetailElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.TestReport.SetupActionOperationComponent convertSetupActionOperationComponent(org.hl7.fhir.r5.model.TestReport.SetupActionOperationComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.dstu3.model.TestReport.SetupActionOperationComponent tgt = new org.hl7.fhir.dstu3.model.TestReport.SetupActionOperationComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    if (src.hasResult()) tgt.setResultElement(convertTestReportActionResult(src.getResultElement()));
    if (src.hasMessage()) tgt.setMessageElement(MarkDown30_50.convertMarkdown(src.getMessageElement()));
    if (src.hasDetail()) tgt.setDetailElement(Uri30_50.convertUri(src.getDetailElement()));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestReport.TestReportActionResult> convertTestReportActionResult(org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.TestReport.TestReportActionResult> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestReport.TestReportActionResult> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.TestReport.TestReportActionResultEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.r5.model.TestReport.TestReportActionResult.NULL);
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

  static public org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.TestReport.TestReportActionResult> convertTestReportActionResult(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.TestReport.TestReportActionResult> src) throws FHIRException {
    if (src == null || src.isEmpty()) return null;
    org.hl7.fhir.dstu3.model.Enumeration<org.hl7.fhir.dstu3.model.TestReport.TestReportActionResult> tgt = new org.hl7.fhir.dstu3.model.Enumeration<>(new org.hl7.fhir.dstu3.model.TestReport.TestReportActionResultEnumFactory());
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyElement(src, tgt);
    if (src.getValue() == null) {
      tgt.setValue(org.hl7.fhir.dstu3.model.TestReport.TestReportActionResult.NULL);
    } else {
      switch (src.getValue()) {
        case PASS:
          tgt.setValue(org.hl7.fhir.dstu3.model.TestReport.TestReportActionResult.PASS);
          break;
        case SKIP:
          tgt.setValue(org.hl7.fhir.dstu3.model.TestReport.TestReportActionResult.SKIP);
          break;
        case FAIL:
          tgt.setValue(org.hl7.fhir.dstu3.model.TestReport.TestReportActionResult.FAIL);
          break;
        case WARNING:
          tgt.setValue(org.hl7.fhir.dstu3.model.TestReport.TestReportActionResult.WARNING);
          break;
        case ERROR:
          tgt.setValue(org.hl7.fhir.dstu3.model.TestReport.TestReportActionResult.ERROR);
          break;
        default:
          tgt.setValue(org.hl7.fhir.dstu3.model.TestReport.TestReportActionResult.NULL);
          break;
      }
    }
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestReport.SetupActionAssertComponent convertSetupActionAssertComponent(org.hl7.fhir.dstu3.model.TestReport.SetupActionAssertComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.TestReport.SetupActionAssertComponent tgt = new org.hl7.fhir.r5.model.TestReport.SetupActionAssertComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    if (src.hasResult()) tgt.setResultElement(convertTestReportActionResult(src.getResultElement()));
    if (src.hasMessage()) tgt.setMessageElement(MarkDown30_50.convertMarkdown(src.getMessageElement()));
    if (src.hasDetail()) tgt.setDetailElement(String30_50.convertString(src.getDetailElement()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.TestReport.SetupActionAssertComponent convertSetupActionAssertComponent(org.hl7.fhir.r5.model.TestReport.SetupActionAssertComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.dstu3.model.TestReport.SetupActionAssertComponent tgt = new org.hl7.fhir.dstu3.model.TestReport.SetupActionAssertComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    if (src.hasResult()) tgt.setResultElement(convertTestReportActionResult(src.getResultElement()));
    if (src.hasMessage()) tgt.setMessageElement(MarkDown30_50.convertMarkdown(src.getMessageElement()));
    if (src.hasDetail()) tgt.setDetailElement(String30_50.convertString(src.getDetailElement()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestReport.TestActionComponent convertTestActionComponent(org.hl7.fhir.dstu3.model.TestReport.TestActionComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.TestReport.TestActionComponent tgt = new org.hl7.fhir.r5.model.TestReport.TestActionComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    if (src.hasOperation()) tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    if (src.hasAssert()) tgt.setAssert(convertSetupActionAssertComponent(src.getAssert()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.TestReport.TestActionComponent convertTestActionComponent(org.hl7.fhir.r5.model.TestReport.TestActionComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.dstu3.model.TestReport.TestActionComponent tgt = new org.hl7.fhir.dstu3.model.TestReport.TestActionComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    if (src.hasOperation()) tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    if (src.hasAssert()) tgt.setAssert(convertSetupActionAssertComponent(src.getAssert()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.TestReport.TeardownActionComponent convertTeardownActionComponent(org.hl7.fhir.dstu3.model.TestReport.TeardownActionComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.r5.model.TestReport.TeardownActionComponent tgt = new org.hl7.fhir.r5.model.TestReport.TeardownActionComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    if (src.hasOperation()) tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    return tgt;
  }

  public static org.hl7.fhir.dstu3.model.TestReport.TeardownActionComponent convertTeardownActionComponent(org.hl7.fhir.r5.model.TestReport.TeardownActionComponent src) throws FHIRException {
    if (src == null) return null;
    org.hl7.fhir.dstu3.model.TestReport.TeardownActionComponent tgt = new org.hl7.fhir.dstu3.model.TestReport.TeardownActionComponent();
    ConversionContext30_50.INSTANCE.getVersionConvertor_30_50().copyBackboneElement(src,tgt);
    if (src.hasOperation()) tgt.setOperation(convertSetupActionOperationComponent(src.getOperation()));
    return tgt;
  }
}