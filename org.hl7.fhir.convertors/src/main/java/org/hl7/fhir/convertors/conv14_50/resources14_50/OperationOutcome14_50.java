package org.hl7.fhir.convertors.conv14_50.resources14_50;

import org.hl7.fhir.convertors.context.ConversionContext14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.ElementDefinition14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.complextypes14_50.CodeableConcept14_50;
import org.hl7.fhir.convertors.conv14_50.datatypes14_50.primitivetypes14_50.String14_50;
import org.hl7.fhir.dstu2016may.model.Enumeration;
import org.hl7.fhir.dstu2016may.model.OperationOutcome;
import org.hl7.fhir.exceptions.FHIRException;

public class OperationOutcome14_50 {

  static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.OperationOutcome.IssueSeverity> convertIssueSeverity(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.OperationOutcome.IssueSeverity> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<OperationOutcome.IssueSeverity> tgt = new Enumeration<>(new OperationOutcome.IssueSeverityEnumFactory());
      ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case FATAL:
                  tgt.setValue(OperationOutcome.IssueSeverity.FATAL);
                  break;
              case ERROR:
                  tgt.setValue(OperationOutcome.IssueSeverity.ERROR);
                  break;
              case WARNING:
                  tgt.setValue(OperationOutcome.IssueSeverity.WARNING);
                  break;
              case INFORMATION:
                  tgt.setValue(OperationOutcome.IssueSeverity.INFORMATION);
                  break;
              default:
                  tgt.setValue(OperationOutcome.IssueSeverity.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.OperationOutcome.IssueSeverity> convertIssueSeverity(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.OperationOutcome.IssueSeverity> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.OperationOutcome.IssueSeverity> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.OperationOutcome.IssueSeverityEnumFactory());
      ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case FATAL:
                  tgt.setValue(org.hl7.fhir.r5.model.OperationOutcome.IssueSeverity.FATAL);
                  break;
              case ERROR:
                  tgt.setValue(org.hl7.fhir.r5.model.OperationOutcome.IssueSeverity.ERROR);
                  break;
              case WARNING:
                  tgt.setValue(org.hl7.fhir.r5.model.OperationOutcome.IssueSeverity.WARNING);
                  break;
              case INFORMATION:
                  tgt.setValue(org.hl7.fhir.r5.model.OperationOutcome.IssueSeverity.INFORMATION);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r5.model.OperationOutcome.IssueSeverity.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.OperationOutcome.IssueType> convertIssueType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.OperationOutcome.IssueType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      Enumeration<OperationOutcome.IssueType> tgt = new Enumeration<>(new OperationOutcome.IssueTypeEnumFactory());
      ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case INVALID:
                  tgt.setValue(OperationOutcome.IssueType.INVALID);
                  break;
              case STRUCTURE:
                  tgt.setValue(OperationOutcome.IssueType.STRUCTURE);
                  break;
              case REQUIRED:
                  tgt.setValue(OperationOutcome.IssueType.REQUIRED);
                  break;
              case VALUE:
                  tgt.setValue(OperationOutcome.IssueType.VALUE);
                  break;
              case INVARIANT:
                  tgt.setValue(OperationOutcome.IssueType.INVARIANT);
                  break;
              case SECURITY:
                  tgt.setValue(OperationOutcome.IssueType.SECURITY);
                  break;
              case LOGIN:
                  tgt.setValue(OperationOutcome.IssueType.LOGIN);
                  break;
              case UNKNOWN:
                  tgt.setValue(OperationOutcome.IssueType.UNKNOWN);
                  break;
              case EXPIRED:
                  tgt.setValue(OperationOutcome.IssueType.EXPIRED);
                  break;
              case FORBIDDEN:
                  tgt.setValue(OperationOutcome.IssueType.FORBIDDEN);
                  break;
              case SUPPRESSED:
                  tgt.setValue(OperationOutcome.IssueType.SUPPRESSED);
                  break;
              case PROCESSING:
                  tgt.setValue(OperationOutcome.IssueType.PROCESSING);
                  break;
              case NOTSUPPORTED:
                  tgt.setValue(OperationOutcome.IssueType.NOTSUPPORTED);
                  break;
              case DUPLICATE:
                  tgt.setValue(OperationOutcome.IssueType.DUPLICATE);
                  break;
              case NOTFOUND:
                  tgt.setValue(OperationOutcome.IssueType.NOTFOUND);
                  break;
              case TOOLONG:
                  tgt.setValue(OperationOutcome.IssueType.TOOLONG);
                  break;
              case CODEINVALID:
                  tgt.setValue(OperationOutcome.IssueType.CODEINVALID);
                  break;
              case EXTENSION:
                  tgt.setValue(OperationOutcome.IssueType.EXTENSION);
                  break;
              case TOOCOSTLY:
                  tgt.setValue(OperationOutcome.IssueType.TOOCOSTLY);
                  break;
              case BUSINESSRULE:
                  tgt.setValue(OperationOutcome.IssueType.BUSINESSRULE);
                  break;
              case CONFLICT:
                  tgt.setValue(OperationOutcome.IssueType.CONFLICT);
                  break;
              case INCOMPLETE:
                  tgt.setValue(OperationOutcome.IssueType.INCOMPLETE);
                  break;
              case TRANSIENT:
                  tgt.setValue(OperationOutcome.IssueType.TRANSIENT);
                  break;
              case LOCKERROR:
                  tgt.setValue(OperationOutcome.IssueType.LOCKERROR);
                  break;
              case NOSTORE:
                  tgt.setValue(OperationOutcome.IssueType.NOSTORE);
                  break;
              case EXCEPTION:
                  tgt.setValue(OperationOutcome.IssueType.EXCEPTION);
                  break;
              case TIMEOUT:
                  tgt.setValue(OperationOutcome.IssueType.TIMEOUT);
                  break;
              case THROTTLED:
                  tgt.setValue(OperationOutcome.IssueType.THROTTLED);
                  break;
              case INFORMATIONAL:
                  tgt.setValue(OperationOutcome.IssueType.INFORMATIONAL);
                  break;
              default:
                  tgt.setValue(OperationOutcome.IssueType.NULL);
                  break;
          }
      }
      return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.OperationOutcome.IssueType> convertIssueType(org.hl7.fhir.dstu2016may.model.Enumeration<org.hl7.fhir.dstu2016may.model.OperationOutcome.IssueType> src) throws FHIRException {
      if (src == null || src.isEmpty())
          return null;
      org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.OperationOutcome.IssueType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.OperationOutcome.IssueTypeEnumFactory());
      ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyElement(src, tgt);
      if (src.getValue() == null) {
          tgt.setValue(null);
      } else {
          switch (src.getValue()) {
              case INVALID:
                  tgt.setValue(org.hl7.fhir.r5.model.OperationOutcome.IssueType.INVALID);
                  break;
              case STRUCTURE:
                  tgt.setValue(org.hl7.fhir.r5.model.OperationOutcome.IssueType.STRUCTURE);
                  break;
              case REQUIRED:
                  tgt.setValue(org.hl7.fhir.r5.model.OperationOutcome.IssueType.REQUIRED);
                  break;
              case VALUE:
                  tgt.setValue(org.hl7.fhir.r5.model.OperationOutcome.IssueType.VALUE);
                  break;
              case INVARIANT:
                  tgt.setValue(org.hl7.fhir.r5.model.OperationOutcome.IssueType.INVARIANT);
                  break;
              case SECURITY:
                  tgt.setValue(org.hl7.fhir.r5.model.OperationOutcome.IssueType.SECURITY);
                  break;
              case LOGIN:
                  tgt.setValue(org.hl7.fhir.r5.model.OperationOutcome.IssueType.LOGIN);
                  break;
              case UNKNOWN:
                  tgt.setValue(org.hl7.fhir.r5.model.OperationOutcome.IssueType.UNKNOWN);
                  break;
              case EXPIRED:
                  tgt.setValue(org.hl7.fhir.r5.model.OperationOutcome.IssueType.EXPIRED);
                  break;
              case FORBIDDEN:
                  tgt.setValue(org.hl7.fhir.r5.model.OperationOutcome.IssueType.FORBIDDEN);
                  break;
              case SUPPRESSED:
                  tgt.setValue(org.hl7.fhir.r5.model.OperationOutcome.IssueType.SUPPRESSED);
                  break;
              case PROCESSING:
                  tgt.setValue(org.hl7.fhir.r5.model.OperationOutcome.IssueType.PROCESSING);
                  break;
              case NOTSUPPORTED:
                  tgt.setValue(org.hl7.fhir.r5.model.OperationOutcome.IssueType.NOTSUPPORTED);
                  break;
              case DUPLICATE:
                  tgt.setValue(org.hl7.fhir.r5.model.OperationOutcome.IssueType.DUPLICATE);
                  break;
              case NOTFOUND:
                  tgt.setValue(org.hl7.fhir.r5.model.OperationOutcome.IssueType.NOTFOUND);
                  break;
              case TOOLONG:
                  tgt.setValue(org.hl7.fhir.r5.model.OperationOutcome.IssueType.TOOLONG);
                  break;
              case CODEINVALID:
                  tgt.setValue(org.hl7.fhir.r5.model.OperationOutcome.IssueType.CODEINVALID);
                  break;
              case EXTENSION:
                  tgt.setValue(org.hl7.fhir.r5.model.OperationOutcome.IssueType.EXTENSION);
                  break;
              case TOOCOSTLY:
                  tgt.setValue(org.hl7.fhir.r5.model.OperationOutcome.IssueType.TOOCOSTLY);
                  break;
              case BUSINESSRULE:
                  tgt.setValue(org.hl7.fhir.r5.model.OperationOutcome.IssueType.BUSINESSRULE);
                  break;
              case CONFLICT:
                  tgt.setValue(org.hl7.fhir.r5.model.OperationOutcome.IssueType.CONFLICT);
                  break;
              case INCOMPLETE:
                  tgt.setValue(org.hl7.fhir.r5.model.OperationOutcome.IssueType.INCOMPLETE);
                  break;
              case TRANSIENT:
                  tgt.setValue(org.hl7.fhir.r5.model.OperationOutcome.IssueType.TRANSIENT);
                  break;
              case LOCKERROR:
                  tgt.setValue(org.hl7.fhir.r5.model.OperationOutcome.IssueType.LOCKERROR);
                  break;
              case NOSTORE:
                  tgt.setValue(org.hl7.fhir.r5.model.OperationOutcome.IssueType.NOSTORE);
                  break;
              case EXCEPTION:
                  tgt.setValue(org.hl7.fhir.r5.model.OperationOutcome.IssueType.EXCEPTION);
                  break;
              case TIMEOUT:
                  tgt.setValue(org.hl7.fhir.r5.model.OperationOutcome.IssueType.TIMEOUT);
                  break;
              case THROTTLED:
                  tgt.setValue(org.hl7.fhir.r5.model.OperationOutcome.IssueType.THROTTLED);
                  break;
              case INFORMATIONAL:
                  tgt.setValue(org.hl7.fhir.r5.model.OperationOutcome.IssueType.INFORMATIONAL);
                  break;
              default:
                  tgt.setValue(org.hl7.fhir.r5.model.OperationOutcome.IssueType.NULL);
                  break;
          }
      }
      return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.OperationOutcome convertOperationOutcome(org.hl7.fhir.r5.model.OperationOutcome src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.OperationOutcome tgt = new org.hl7.fhir.dstu2016may.model.OperationOutcome();
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.OperationOutcome.OperationOutcomeIssueComponent t : src.getIssue())
      tgt.addIssue(convertOperationOutcomeIssueComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.OperationOutcome convertOperationOutcome(org.hl7.fhir.dstu2016may.model.OperationOutcome src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.OperationOutcome tgt = new org.hl7.fhir.r5.model.OperationOutcome();
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.dstu2016may.model.OperationOutcome.OperationOutcomeIssueComponent t : src.getIssue())
      tgt.addIssue(convertOperationOutcomeIssueComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.dstu2016may.model.OperationOutcome.OperationOutcomeIssueComponent convertOperationOutcomeIssueComponent(org.hl7.fhir.r5.model.OperationOutcome.OperationOutcomeIssueComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.dstu2016may.model.OperationOutcome.OperationOutcomeIssueComponent tgt = new org.hl7.fhir.dstu2016may.model.OperationOutcome.OperationOutcomeIssueComponent();
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyBackboneElement(src,tgt);
    if (src.hasSeverity())
      tgt.setSeverityElement(convertIssueSeverity(src.getSeverityElement()));
    if (src.hasCode())
      tgt.setCodeElement(convertIssueType(src.getCodeElement()));
    if (src.hasDetails())
      tgt.setDetails(CodeableConcept14_50.convertCodeableConcept(src.getDetails()));
    if (src.hasDiagnostics())
      tgt.setDiagnosticsElement(String14_50.convertString(src.getDiagnosticsElement()));
    for (org.hl7.fhir.r5.model.StringType t : src.getLocation()) tgt.addLocation(t.getValue());
    for (org.hl7.fhir.r5.model.StringType t : src.getExpression())
      tgt.addExpression(ElementDefinition14_50.convertTo2016MayExpression(t.getValue()));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.OperationOutcome.OperationOutcomeIssueComponent convertOperationOutcomeIssueComponent(org.hl7.fhir.dstu2016may.model.OperationOutcome.OperationOutcomeIssueComponent src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.OperationOutcome.OperationOutcomeIssueComponent tgt = new org.hl7.fhir.r5.model.OperationOutcome.OperationOutcomeIssueComponent();
    ConversionContext14_50.INSTANCE.getVersionConvertor_14_50().copyBackboneElement(src,tgt);
    if (src.hasSeverity())
      tgt.setSeverityElement(convertIssueSeverity(src.getSeverityElement()));
    if (src.hasCode())
      tgt.setCodeElement(convertIssueType(src.getCodeElement()));
    if (src.hasDetails())
      tgt.setDetails(CodeableConcept14_50.convertCodeableConcept(src.getDetails()));
    if (src.hasDiagnostics())
      tgt.setDiagnosticsElement(String14_50.convertString(src.getDiagnosticsElement()));
    for (org.hl7.fhir.dstu2016may.model.StringType t : src.getLocation()) tgt.addLocation(t.getValue());
    for (org.hl7.fhir.dstu2016may.model.StringType t : src.getExpression())
      tgt.addExpression(ElementDefinition14_50.convertToR4Expression(t.getValue()));
    return tgt;
  }
}