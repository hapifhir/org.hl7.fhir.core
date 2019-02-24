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


public class OperationOutcome extends VersionConvertor_40_50 {

  public static org.hl7.fhir.r5.model.OperationOutcome convertOperationOutcome(org.hl7.fhir.r4.model.OperationOutcome src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.OperationOutcome tgt = new org.hl7.fhir.r5.model.OperationOutcome();
    copyDomainResource(src, tgt);
    for (org.hl7.fhir.r4.model.OperationOutcome.OperationOutcomeIssueComponent t : src.getIssue())
      tgt.addIssue(convertOperationOutcomeIssueComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.OperationOutcome convertOperationOutcome(org.hl7.fhir.r5.model.OperationOutcome src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.OperationOutcome tgt = new org.hl7.fhir.r4.model.OperationOutcome();
    copyDomainResource(src, tgt);
    for (org.hl7.fhir.r5.model.OperationOutcome.OperationOutcomeIssueComponent t : src.getIssue())
      tgt.addIssue(convertOperationOutcomeIssueComponent(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.OperationOutcome.OperationOutcomeIssueComponent convertOperationOutcomeIssueComponent(org.hl7.fhir.r4.model.OperationOutcome.OperationOutcomeIssueComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r5.model.OperationOutcome.OperationOutcomeIssueComponent tgt = new org.hl7.fhir.r5.model.OperationOutcome.OperationOutcomeIssueComponent();
    copyElement(src, tgt);
    if (src.hasSeverity())
      tgt.setSeverity(convertIssueSeverity(src.getSeverity()));
    if (src.hasCode())
      tgt.setCode(convertIssueType(src.getCode()));
    if (src.hasDetails())
      tgt.setDetails(convertCodeableConcept(src.getDetails()));
    if (src.hasDiagnostics())
      tgt.setDiagnosticsElement(convertString(src.getDiagnosticsElement()));
    for (org.hl7.fhir.r4.model.StringType t : src.getLocation())
      tgt.getLocation().add(convertString(t));
    for (org.hl7.fhir.r4.model.StringType t : src.getExpression())
      tgt.getExpression().add(convertString(t));
    return tgt;
  }

  public static org.hl7.fhir.r4.model.OperationOutcome.OperationOutcomeIssueComponent convertOperationOutcomeIssueComponent(org.hl7.fhir.r5.model.OperationOutcome.OperationOutcomeIssueComponent src) throws FHIRException {
    if (src == null)
      return null;
    org.hl7.fhir.r4.model.OperationOutcome.OperationOutcomeIssueComponent tgt = new org.hl7.fhir.r4.model.OperationOutcome.OperationOutcomeIssueComponent();
    copyElement(src, tgt);
    if (src.hasSeverity())
      tgt.setSeverity(convertIssueSeverity(src.getSeverity()));
    if (src.hasCode())
      tgt.setCode(convertIssueType(src.getCode()));
    if (src.hasDetails())
      tgt.setDetails(convertCodeableConcept(src.getDetails()));
    if (src.hasDiagnostics())
      tgt.setDiagnosticsElement(convertString(src.getDiagnosticsElement()));
    for (org.hl7.fhir.r5.model.StringType t : src.getLocation())
      tgt.getLocation().add(convertString(t));
    for (org.hl7.fhir.r5.model.StringType t : src.getExpression())
      tgt.getExpression().add(convertString(t));
    return tgt;
  }

  public static org.hl7.fhir.r5.model.OperationOutcome.IssueSeverity convertIssueSeverity(org.hl7.fhir.r4.model.OperationOutcome.IssueSeverity src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case FATAL: return org.hl7.fhir.r5.model.OperationOutcome.IssueSeverity.FATAL;
    case ERROR: return org.hl7.fhir.r5.model.OperationOutcome.IssueSeverity.ERROR;
    case WARNING: return org.hl7.fhir.r5.model.OperationOutcome.IssueSeverity.WARNING;
    case INFORMATION: return org.hl7.fhir.r5.model.OperationOutcome.IssueSeverity.INFORMATION;
    default: return org.hl7.fhir.r5.model.OperationOutcome.IssueSeverity.NULL;
  }
}

  public static org.hl7.fhir.r4.model.OperationOutcome.IssueSeverity convertIssueSeverity(org.hl7.fhir.r5.model.OperationOutcome.IssueSeverity src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case FATAL: return org.hl7.fhir.r4.model.OperationOutcome.IssueSeverity.FATAL;
    case ERROR: return org.hl7.fhir.r4.model.OperationOutcome.IssueSeverity.ERROR;
    case WARNING: return org.hl7.fhir.r4.model.OperationOutcome.IssueSeverity.WARNING;
    case INFORMATION: return org.hl7.fhir.r4.model.OperationOutcome.IssueSeverity.INFORMATION;
    default: return org.hl7.fhir.r4.model.OperationOutcome.IssueSeverity.NULL;
  }
}

  public static org.hl7.fhir.r5.model.OperationOutcome.IssueType convertIssueType(org.hl7.fhir.r4.model.OperationOutcome.IssueType src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case INVALID: return org.hl7.fhir.r5.model.OperationOutcome.IssueType.INVALID;
    case STRUCTURE: return org.hl7.fhir.r5.model.OperationOutcome.IssueType.STRUCTURE;
    case REQUIRED: return org.hl7.fhir.r5.model.OperationOutcome.IssueType.REQUIRED;
    case VALUE: return org.hl7.fhir.r5.model.OperationOutcome.IssueType.VALUE;
    case INVARIANT: return org.hl7.fhir.r5.model.OperationOutcome.IssueType.INVARIANT;
    case SECURITY: return org.hl7.fhir.r5.model.OperationOutcome.IssueType.SECURITY;
    case LOGIN: return org.hl7.fhir.r5.model.OperationOutcome.IssueType.LOGIN;
    case UNKNOWN: return org.hl7.fhir.r5.model.OperationOutcome.IssueType.UNKNOWN;
    case EXPIRED: return org.hl7.fhir.r5.model.OperationOutcome.IssueType.EXPIRED;
    case FORBIDDEN: return org.hl7.fhir.r5.model.OperationOutcome.IssueType.FORBIDDEN;
    case SUPPRESSED: return org.hl7.fhir.r5.model.OperationOutcome.IssueType.SUPPRESSED;
    case PROCESSING: return org.hl7.fhir.r5.model.OperationOutcome.IssueType.PROCESSING;
    case NOTSUPPORTED: return org.hl7.fhir.r5.model.OperationOutcome.IssueType.NOTSUPPORTED;
    case DUPLICATE: return org.hl7.fhir.r5.model.OperationOutcome.IssueType.DUPLICATE;
    case MULTIPLEMATCHES: return org.hl7.fhir.r5.model.OperationOutcome.IssueType.MULTIPLEMATCHES;
    case NOTFOUND: return org.hl7.fhir.r5.model.OperationOutcome.IssueType.NOTFOUND;
    case DELETED: return org.hl7.fhir.r5.model.OperationOutcome.IssueType.DELETED;
    case TOOLONG: return org.hl7.fhir.r5.model.OperationOutcome.IssueType.TOOLONG;
    case CODEINVALID: return org.hl7.fhir.r5.model.OperationOutcome.IssueType.CODEINVALID;
    case EXTENSION: return org.hl7.fhir.r5.model.OperationOutcome.IssueType.EXTENSION;
    case TOOCOSTLY: return org.hl7.fhir.r5.model.OperationOutcome.IssueType.TOOCOSTLY;
    case BUSINESSRULE: return org.hl7.fhir.r5.model.OperationOutcome.IssueType.BUSINESSRULE;
    case CONFLICT: return org.hl7.fhir.r5.model.OperationOutcome.IssueType.CONFLICT;
    case TRANSIENT: return org.hl7.fhir.r5.model.OperationOutcome.IssueType.TRANSIENT;
    case LOCKERROR: return org.hl7.fhir.r5.model.OperationOutcome.IssueType.LOCKERROR;
    case NOSTORE: return org.hl7.fhir.r5.model.OperationOutcome.IssueType.NOSTORE;
    case EXCEPTION: return org.hl7.fhir.r5.model.OperationOutcome.IssueType.EXCEPTION;
    case TIMEOUT: return org.hl7.fhir.r5.model.OperationOutcome.IssueType.TIMEOUT;
    case INCOMPLETE: return org.hl7.fhir.r5.model.OperationOutcome.IssueType.INCOMPLETE;
    case THROTTLED: return org.hl7.fhir.r5.model.OperationOutcome.IssueType.THROTTLED;
    case INFORMATIONAL: return org.hl7.fhir.r5.model.OperationOutcome.IssueType.INFORMATIONAL;
    default: return org.hl7.fhir.r5.model.OperationOutcome.IssueType.NULL;
  }
}

  public static org.hl7.fhir.r4.model.OperationOutcome.IssueType convertIssueType(org.hl7.fhir.r5.model.OperationOutcome.IssueType src) throws FHIRException {
    if (src == null)
      return null;
    switch (src) {
    case INVALID: return org.hl7.fhir.r4.model.OperationOutcome.IssueType.INVALID;
    case STRUCTURE: return org.hl7.fhir.r4.model.OperationOutcome.IssueType.STRUCTURE;
    case REQUIRED: return org.hl7.fhir.r4.model.OperationOutcome.IssueType.REQUIRED;
    case VALUE: return org.hl7.fhir.r4.model.OperationOutcome.IssueType.VALUE;
    case INVARIANT: return org.hl7.fhir.r4.model.OperationOutcome.IssueType.INVARIANT;
    case SECURITY: return org.hl7.fhir.r4.model.OperationOutcome.IssueType.SECURITY;
    case LOGIN: return org.hl7.fhir.r4.model.OperationOutcome.IssueType.LOGIN;
    case UNKNOWN: return org.hl7.fhir.r4.model.OperationOutcome.IssueType.UNKNOWN;
    case EXPIRED: return org.hl7.fhir.r4.model.OperationOutcome.IssueType.EXPIRED;
    case FORBIDDEN: return org.hl7.fhir.r4.model.OperationOutcome.IssueType.FORBIDDEN;
    case SUPPRESSED: return org.hl7.fhir.r4.model.OperationOutcome.IssueType.SUPPRESSED;
    case PROCESSING: return org.hl7.fhir.r4.model.OperationOutcome.IssueType.PROCESSING;
    case NOTSUPPORTED: return org.hl7.fhir.r4.model.OperationOutcome.IssueType.NOTSUPPORTED;
    case DUPLICATE: return org.hl7.fhir.r4.model.OperationOutcome.IssueType.DUPLICATE;
    case MULTIPLEMATCHES: return org.hl7.fhir.r4.model.OperationOutcome.IssueType.MULTIPLEMATCHES;
    case NOTFOUND: return org.hl7.fhir.r4.model.OperationOutcome.IssueType.NOTFOUND;
    case DELETED: return org.hl7.fhir.r4.model.OperationOutcome.IssueType.DELETED;
    case TOOLONG: return org.hl7.fhir.r4.model.OperationOutcome.IssueType.TOOLONG;
    case CODEINVALID: return org.hl7.fhir.r4.model.OperationOutcome.IssueType.CODEINVALID;
    case EXTENSION: return org.hl7.fhir.r4.model.OperationOutcome.IssueType.EXTENSION;
    case TOOCOSTLY: return org.hl7.fhir.r4.model.OperationOutcome.IssueType.TOOCOSTLY;
    case BUSINESSRULE: return org.hl7.fhir.r4.model.OperationOutcome.IssueType.BUSINESSRULE;
    case CONFLICT: return org.hl7.fhir.r4.model.OperationOutcome.IssueType.CONFLICT;
    case TRANSIENT: return org.hl7.fhir.r4.model.OperationOutcome.IssueType.TRANSIENT;
    case LOCKERROR: return org.hl7.fhir.r4.model.OperationOutcome.IssueType.LOCKERROR;
    case NOSTORE: return org.hl7.fhir.r4.model.OperationOutcome.IssueType.NOSTORE;
    case EXCEPTION: return org.hl7.fhir.r4.model.OperationOutcome.IssueType.EXCEPTION;
    case TIMEOUT: return org.hl7.fhir.r4.model.OperationOutcome.IssueType.TIMEOUT;
    case INCOMPLETE: return org.hl7.fhir.r4.model.OperationOutcome.IssueType.INCOMPLETE;
    case THROTTLED: return org.hl7.fhir.r4.model.OperationOutcome.IssueType.THROTTLED;
    case INFORMATIONAL: return org.hl7.fhir.r4.model.OperationOutcome.IssueType.INFORMATIONAL;
    default: return org.hl7.fhir.r4.model.OperationOutcome.IssueType.NULL;
  }
}


}
