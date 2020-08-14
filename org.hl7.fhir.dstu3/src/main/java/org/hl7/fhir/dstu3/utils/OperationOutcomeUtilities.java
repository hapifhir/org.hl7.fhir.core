package org.hl7.fhir.dstu3.utils;

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



import org.hl7.fhir.dstu3.model.CodeableConcept;
import org.hl7.fhir.dstu3.model.OperationOutcome;
import org.hl7.fhir.dstu3.model.OperationOutcome.IssueSeverity;
import org.hl7.fhir.dstu3.model.OperationOutcome.IssueType;
import org.hl7.fhir.dstu3.model.OperationOutcome.OperationOutcomeIssueComponent;
import org.hl7.fhir.dstu3.model.StringType;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.validation.ValidationMessage;

public class OperationOutcomeUtilities {


  public static OperationOutcomeIssueComponent convertToIssue(ValidationMessage message, OperationOutcome op) {
    OperationOutcomeIssueComponent issue = new OperationOutcome.OperationOutcomeIssueComponent();
    issue.setCode(convert(message.getType()));
    if (message.getLocation() != null) {
      // message location has a fhirPath in it. We need to populate the expression
      issue.addExpression(message.getLocation());
      // also, populate the XPath variant
      StringType s = new StringType();
      s.setValue(Utilities.fhirPathToXPath(message.getLocation())+(message.getLine()>= 0 && message.getCol() >= 0 ? " (line "+Integer.toString(message.getLine())+", col"+Integer.toString(message.getCol())+")" : "") );
      issue.getLocation().add(s);
    }
    issue.setSeverity(convert(message.getLevel()));
    CodeableConcept c = new CodeableConcept();
    c.setText(message.getMessage());
    issue.setDetails(c);
    if (message.getSource() != null) {
      issue.getExtension().add(ToolingExtensions.makeIssueSource(message.getSource()));
    }
    return issue;
  }

  private static IssueSeverity convert(org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity level) {
    switch (level) {
    case FATAL : return IssueSeverity.FATAL;
    case ERROR : return IssueSeverity.ERROR;
    case WARNING : return IssueSeverity.WARNING;
    case INFORMATION : return IssueSeverity.INFORMATION;
    }
    return IssueSeverity.NULL;
  }

  private static IssueType convert(org.hl7.fhir.utilities.validation.ValidationMessage.IssueType type) {
    switch (type) {
    case INVALID: 
    case STRUCTURE: return IssueType.STRUCTURE;
    case REQUIRED: return IssueType.REQUIRED;
    case VALUE: return IssueType.VALUE;
    case INVARIANT: return IssueType.INVARIANT;
    case SECURITY: return IssueType.SECURITY;
    case LOGIN: return IssueType.LOGIN;
    case UNKNOWN: return IssueType.UNKNOWN;
    case EXPIRED: return IssueType.EXPIRED;
    case FORBIDDEN: return IssueType.FORBIDDEN;
    case SUPPRESSED: return IssueType.SUPPRESSED;
    case PROCESSING: return IssueType.PROCESSING;
    case NOTSUPPORTED: return IssueType.NOTSUPPORTED;
    case DUPLICATE: return IssueType.DUPLICATE;
    case NOTFOUND: return IssueType.NOTFOUND;
    case TOOLONG: return IssueType.TOOLONG;
    case CODEINVALID: return IssueType.CODEINVALID;
    case EXTENSION: return IssueType.EXTENSION;
    case TOOCOSTLY: return IssueType.TOOCOSTLY;
    case BUSINESSRULE: return IssueType.BUSINESSRULE;
    case CONFLICT: return IssueType.CONFLICT;
    case INCOMPLETE: return IssueType.INCOMPLETE;
    case TRANSIENT: return IssueType.TRANSIENT;
    case LOCKERROR: return IssueType.LOCKERROR;
    case NOSTORE: return IssueType.NOSTORE;
    case EXCEPTION: return IssueType.EXCEPTION;
    case TIMEOUT: return IssueType.TIMEOUT;
    case THROTTLED: return IssueType.THROTTLED;
    case INFORMATIONAL: return IssueType.INFORMATIONAL;
    }
    return IssueType.NULL;
  }
}