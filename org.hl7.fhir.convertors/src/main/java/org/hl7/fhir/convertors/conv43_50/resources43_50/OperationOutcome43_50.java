package org.hl7.fhir.convertors.conv43_50.resources43_50;

import org.hl7.fhir.convertors.context.ConversionContext43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.general43_50.CodeableConcept43_50;
import org.hl7.fhir.convertors.conv43_50.datatypes43_50.primitive43_50.String43_50;
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
public class OperationOutcome43_50 {

  public static org.hl7.fhir.r5.model.OperationOutcome convertOperationOutcome(org.hl7.fhir.r4b.model.OperationOutcome src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.OperationOutcome tgt = new org.hl7.fhir.r5.model.OperationOutcome();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4b.model.OperationOutcome.OperationOutcomeIssueComponent t : src.getIssue())
      tgt.addIssue(convertOperationOutcomeIssueComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.OperationOutcome convertOperationOutcome(org.hl7.fhir.r5.model.OperationOutcome src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.OperationOutcome tgt = new org.hl7.fhir.r4b.model.OperationOutcome();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.OperationOutcome.OperationOutcomeIssueComponent t : src.getIssue())
      tgt.addIssue(convertOperationOutcomeIssueComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.OperationOutcome.OperationOutcomeIssueComponent convertOperationOutcomeIssueComponent(org.hl7.fhir.r4b.model.OperationOutcome.OperationOutcomeIssueComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.OperationOutcome.OperationOutcomeIssueComponent tgt = new org.hl7.fhir.r5.model.OperationOutcome.OperationOutcomeIssueComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasSeverity())
      tgt.setSeverityElement(convertIssueSeverity(src.getSeverityElement()));
    if (src.hasCode())
      tgt.setCodeElement(convertIssueType(src.getCodeElement()));
    if (src.hasDetails())
      tgt.setDetails(CodeableConcept43_50.convertCodeableConcept(src.getDetails()));
    if (src.hasDiagnostics())
      tgt.setDiagnosticsElement(String43_50.convertString(src.getDiagnosticsElement()));
    for (org.hl7.fhir.r4b.model.StringType t : src.getLocation()) tgt.getLocation().add(String43_50.convertString(t));
    for (org.hl7.fhir.r4b.model.StringType t : src.getExpression())
      tgt.getExpression().add(String43_50.convertString(t));
    return tgt;
  }

  public static org.hl7.fhir.r4b.model.OperationOutcome.OperationOutcomeIssueComponent convertOperationOutcomeIssueComponent(org.hl7.fhir.r5.model.OperationOutcome.OperationOutcomeIssueComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4b.model.OperationOutcome.OperationOutcomeIssueComponent tgt = new org.hl7.fhir.r4b.model.OperationOutcome.OperationOutcomeIssueComponent();
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyBackboneElement(src, tgt);
    if (src.hasSeverity())
      tgt.setSeverityElement(convertIssueSeverity(src.getSeverityElement()));
    if (src.hasCode())
      tgt.setCodeElement(convertIssueType(src.getCodeElement()));
    if (src.hasDetails())
      tgt.setDetails(CodeableConcept43_50.convertCodeableConcept(src.getDetails()));
    if (src.hasDiagnostics())
      tgt.setDiagnosticsElement(String43_50.convertString(src.getDiagnosticsElement()));
    for (org.hl7.fhir.r5.model.StringType t : src.getLocation()) tgt.getLocation().add(String43_50.convertString(t));
    for (org.hl7.fhir.r5.model.StringType t : src.getExpression())
      tgt.getExpression().add(String43_50.convertString(t));
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.OperationOutcome.IssueSeverity> convertIssueSeverity(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.OperationOutcome.IssueSeverity> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.OperationOutcome.IssueSeverity> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.OperationOutcome.IssueSeverityEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
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
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.OperationOutcome.IssueSeverity> convertIssueSeverity(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.OperationOutcome.IssueSeverity> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.OperationOutcome.IssueSeverity> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.OperationOutcome.IssueSeverityEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case FATAL:
        tgt.setValue(org.hl7.fhir.r4b.model.OperationOutcome.IssueSeverity.FATAL);
        break;
      case ERROR:
        tgt.setValue(org.hl7.fhir.r4b.model.OperationOutcome.IssueSeverity.ERROR);
        break;
      case WARNING:
        tgt.setValue(org.hl7.fhir.r4b.model.OperationOutcome.IssueSeverity.WARNING);
        break;
      case INFORMATION:
        tgt.setValue(org.hl7.fhir.r4b.model.OperationOutcome.IssueSeverity.INFORMATION);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.OperationOutcome.IssueSeverity.NULL);
        break;
    }
    return tgt;
  }

  static public org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.OperationOutcome.IssueType> convertIssueType(org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.OperationOutcome.IssueType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.OperationOutcome.IssueType> tgt = new org.hl7.fhir.r5.model.Enumeration<>(new org.hl7.fhir.r5.model.OperationOutcome.IssueTypeEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
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
      case MULTIPLEMATCHES:
        tgt.setValue(org.hl7.fhir.r5.model.OperationOutcome.IssueType.MULTIPLEMATCHES);
        break;
      case NOTFOUND:
        tgt.setValue(org.hl7.fhir.r5.model.OperationOutcome.IssueType.NOTFOUND);
        break;
      case DELETED:
        tgt.setValue(org.hl7.fhir.r5.model.OperationOutcome.IssueType.DELETED);
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
      case INCOMPLETE:
        tgt.setValue(org.hl7.fhir.r5.model.OperationOutcome.IssueType.INCOMPLETE);
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
    return tgt;
  }

  static public org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.OperationOutcome.IssueType> convertIssueType(org.hl7.fhir.r5.model.Enumeration<org.hl7.fhir.r5.model.OperationOutcome.IssueType> src) throws FHIRException {
    if (src == null || src.isEmpty())
      return null;
    org.hl7.fhir.r4b.model.Enumeration<org.hl7.fhir.r4b.model.OperationOutcome.IssueType> tgt = new org.hl7.fhir.r4b.model.Enumeration<>(new org.hl7.fhir.r4b.model.OperationOutcome.IssueTypeEnumFactory());
    ConversionContext43_50.INSTANCE.getVersionConvertor_43_50().copyElement(src, tgt);
    switch (src.getValue()) {
      case INVALID:
        tgt.setValue(org.hl7.fhir.r4b.model.OperationOutcome.IssueType.INVALID);
        break;
      case STRUCTURE:
        tgt.setValue(org.hl7.fhir.r4b.model.OperationOutcome.IssueType.STRUCTURE);
        break;
      case REQUIRED:
        tgt.setValue(org.hl7.fhir.r4b.model.OperationOutcome.IssueType.REQUIRED);
        break;
      case VALUE:
        tgt.setValue(org.hl7.fhir.r4b.model.OperationOutcome.IssueType.VALUE);
        break;
      case INVARIANT:
        tgt.setValue(org.hl7.fhir.r4b.model.OperationOutcome.IssueType.INVARIANT);
        break;
      case SECURITY:
        tgt.setValue(org.hl7.fhir.r4b.model.OperationOutcome.IssueType.SECURITY);
        break;
      case LOGIN:
        tgt.setValue(org.hl7.fhir.r4b.model.OperationOutcome.IssueType.LOGIN);
        break;
      case UNKNOWN:
        tgt.setValue(org.hl7.fhir.r4b.model.OperationOutcome.IssueType.UNKNOWN);
        break;
      case EXPIRED:
        tgt.setValue(org.hl7.fhir.r4b.model.OperationOutcome.IssueType.EXPIRED);
        break;
      case FORBIDDEN:
        tgt.setValue(org.hl7.fhir.r4b.model.OperationOutcome.IssueType.FORBIDDEN);
        break;
      case SUPPRESSED:
        tgt.setValue(org.hl7.fhir.r4b.model.OperationOutcome.IssueType.SUPPRESSED);
        break;
      case PROCESSING:
        tgt.setValue(org.hl7.fhir.r4b.model.OperationOutcome.IssueType.PROCESSING);
        break;
      case NOTSUPPORTED:
        tgt.setValue(org.hl7.fhir.r4b.model.OperationOutcome.IssueType.NOTSUPPORTED);
        break;
      case DUPLICATE:
        tgt.setValue(org.hl7.fhir.r4b.model.OperationOutcome.IssueType.DUPLICATE);
        break;
      case MULTIPLEMATCHES:
        tgt.setValue(org.hl7.fhir.r4b.model.OperationOutcome.IssueType.MULTIPLEMATCHES);
        break;
      case NOTFOUND:
        tgt.setValue(org.hl7.fhir.r4b.model.OperationOutcome.IssueType.NOTFOUND);
        break;
      case DELETED:
        tgt.setValue(org.hl7.fhir.r4b.model.OperationOutcome.IssueType.DELETED);
        break;
      case TOOLONG:
        tgt.setValue(org.hl7.fhir.r4b.model.OperationOutcome.IssueType.TOOLONG);
        break;
      case CODEINVALID:
        tgt.setValue(org.hl7.fhir.r4b.model.OperationOutcome.IssueType.CODEINVALID);
        break;
      case EXTENSION:
        tgt.setValue(org.hl7.fhir.r4b.model.OperationOutcome.IssueType.EXTENSION);
        break;
      case TOOCOSTLY:
        tgt.setValue(org.hl7.fhir.r4b.model.OperationOutcome.IssueType.TOOCOSTLY);
        break;
      case BUSINESSRULE:
        tgt.setValue(org.hl7.fhir.r4b.model.OperationOutcome.IssueType.BUSINESSRULE);
        break;
      case CONFLICT:
        tgt.setValue(org.hl7.fhir.r4b.model.OperationOutcome.IssueType.CONFLICT);
        break;
      case TRANSIENT:
        tgt.setValue(org.hl7.fhir.r4b.model.OperationOutcome.IssueType.TRANSIENT);
        break;
      case LOCKERROR:
        tgt.setValue(org.hl7.fhir.r4b.model.OperationOutcome.IssueType.LOCKERROR);
        break;
      case NOSTORE:
        tgt.setValue(org.hl7.fhir.r4b.model.OperationOutcome.IssueType.NOSTORE);
        break;
      case EXCEPTION:
        tgt.setValue(org.hl7.fhir.r4b.model.OperationOutcome.IssueType.EXCEPTION);
        break;
      case TIMEOUT:
        tgt.setValue(org.hl7.fhir.r4b.model.OperationOutcome.IssueType.TIMEOUT);
        break;
      case INCOMPLETE:
        tgt.setValue(org.hl7.fhir.r4b.model.OperationOutcome.IssueType.INCOMPLETE);
        break;
      case THROTTLED:
        tgt.setValue(org.hl7.fhir.r4b.model.OperationOutcome.IssueType.THROTTLED);
        break;
      case INFORMATIONAL:
        tgt.setValue(org.hl7.fhir.r4b.model.OperationOutcome.IssueType.INFORMATIONAL);
        break;
      default:
        tgt.setValue(org.hl7.fhir.r4b.model.OperationOutcome.IssueType.NULL);
        break;
    }
    return tgt;
  }
}