package org.hl7.fhir.r4.utils;

/*-
 * #%L
 * org.hl7.fhir.r4
 * %%
 * Copyright (C) 2014 - 2019 Health Level 7
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */


import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.IntegerType;
import org.hl7.fhir.r4.model.OperationOutcome;
import org.hl7.fhir.r4.model.OperationOutcome.IssueSeverity;
import org.hl7.fhir.r4.model.OperationOutcome.IssueType;
import org.hl7.fhir.r4.model.OperationOutcome.OperationOutcomeIssueComponent;
import org.hl7.fhir.r4.model.StringType;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.validation.ValidationMessage;

public class OperationOutcomeUtilities {


  public static OperationOutcomeIssueComponent convertToIssue(ValidationMessage message, OperationOutcome op) {
    OperationOutcomeIssueComponent issue = new OperationOutcome.OperationOutcomeIssueComponent();
    issue.setCode(convert(message.getType()));
    
    if (message.getLocation() != null) {
      // message location has a fhirPath in it. We need to populate the expression
      issue.addExpression(message.getLocation());
    }
    // pass through line/col if they're present
    if (message.getLine() != 0)
      issue.addExtension().setUrl(ToolingExtensions.EXT_ISSUE_LINE).setValue(new IntegerType(message.getLine()));
    if (message.getCol() != 0)
      issue.addExtension().setUrl(ToolingExtensions.EXT_ISSUE_COL).setValue(new IntegerType(message.getCol()));
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
	 case NULL : return IssueSeverity.NULL;
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
	 case NULL: return IssueType.NULL;
    }
    return IssueType.NULL;
  }
}
