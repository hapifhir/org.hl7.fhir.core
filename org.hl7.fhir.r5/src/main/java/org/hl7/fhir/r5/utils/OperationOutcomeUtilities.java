package org.hl7.fhir.r5.utils;

import java.util.List;

import org.hl7.fhir.r5.extensions.ExtensionDefinitions;
import org.hl7.fhir.r5.extensions.ExtensionUtilities;
import org.hl7.fhir.r5.model.CodeType;

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



import org.hl7.fhir.r5.model.CodeableConcept;
import org.hl7.fhir.r5.model.Extension;
import org.hl7.fhir.r5.model.IntegerType;
import org.hl7.fhir.r5.model.Narrative.NarrativeStatus;
import org.hl7.fhir.r5.model.OperationOutcome;
import org.hl7.fhir.r5.model.OperationOutcome.IssueSeverity;
import org.hl7.fhir.r5.model.OperationOutcome.IssueType;
import org.hl7.fhir.r5.model.OperationOutcome.OperationOutcomeIssueComponent;
import org.hl7.fhir.r5.model.StringType;
import org.hl7.fhir.r5.model.UrlType;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.xhtml.NodeType;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;

public class OperationOutcomeUtilities {


  public static OperationOutcomeIssueComponent convertToIssue(ValidationMessage message, OperationOutcome op) {
    OperationOutcomeIssueComponent issue = new OperationOutcome.OperationOutcomeIssueComponent();
    issue.setUserData(UserDataNames.validator_source_vm, message);   
    issue.setCode(convert(message.getType()));
    
    if (message.getLocation() != null) {
      // message location has a fhirPath in it. We need to populate the expression
      issue.addExpression(message.getLocation());
    }
    // pass through line/col if they're present
    if (message.getLine() >= 0) {
      issue.addExtension().setUrl(ExtensionDefinitions.EXT_ISSUE_LINE).setValue(new IntegerType(message.getLine()));
    }
    if (message.getCol() >= 0) {
      issue.addExtension().setUrl(ExtensionDefinitions.EXT_ISSUE_COL).setValue(new IntegerType(message.getCol()));
    }
    issue.setSeverity(convert(message.getLevel()));
    CodeableConcept c = new CodeableConcept();
    c.setText(message.getMessage());
    issue.setDetails(c);
    if (message.getSource() != null) {
      issue.getExtension().add(ExtensionUtilities.makeIssueSource(message.getSource()));
    }
    if (message.getMessageId() != null) {
      issue.getExtension().add(ExtensionUtilities.makeIssueMessageId(message.getMessageId()));
    }
    issue.setUserData(UserDataNames.validator_source_msg, message);
    return issue;
  }

  public static IssueSeverity convert(org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity level) {
    switch (level) {
    case FATAL : return IssueSeverity.FATAL;
    case ERROR : return IssueSeverity.ERROR;
    case WARNING : return IssueSeverity.WARNING;
    case INFORMATION : return IssueSeverity.INFORMATION;
   case NULL : return IssueSeverity.NULL;
    }
    return IssueSeverity.NULL;
  }

  public static org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity convert(IssueSeverity level) {
    switch (level) {
    case FATAL : return org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity.FATAL;
    case ERROR : return org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity.ERROR;
    case WARNING : return org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity.WARNING;
    case INFORMATION : return org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity.INFORMATION;
   case NULL : return org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity.NULL;
    }
    return org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity.NULL;
  }

  private static IssueType convert(org.hl7.fhir.utilities.validation.ValidationMessage.IssueType type) {
    switch (type) {
    case INVALID: return IssueType.INVALID; 
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
    case DELETED: return IssueType.DELETED;
    case MULTIPLEMATCHES: return IssueType.MULTIPLEMATCHES;
    default:
      return IssueType.NULL;
    }
  }

  public static OperationOutcome createOutcome(List<ValidationMessage> messages) {
    OperationOutcome res = new OperationOutcome();
    for (ValidationMessage vm : messages) {
      res.addIssue(convertToIssue(vm, res));
    }
    return res;
  }
  

  public static OperationOutcomeIssueComponent convertToIssueSimple(ValidationMessage message, OperationOutcome op) {
    OperationOutcomeIssueComponent issue = new OperationOutcome.OperationOutcomeIssueComponent();
    issue.setUserData(UserDataNames.validator_source_vm, message);   
    issue.setCode(convert(message.getType()));
    
    if (message.getLocation() != null) {
      // message location has a fhirPath in it. We need to populate the expression
      issue.addExpression(message.getLocation());
    }
    if (message.getLine() >= 0 && message.getCol() >= 0) {
      issue.setDiagnostics("["+message.getLine()+","+message.getCol()+"]");
    }
    issue.setSeverity(convert(message.getLevel()));
    CodeableConcept c = new CodeableConcept();
    c.setText(message.getMessage());
    issue.setDetails(c);
    if (message.hasSliceInfo()) {
      // issue.addExtension(ExtensionDefinitions.EXT_ISSUE_SLICE_INFO, new StringType(errorSummaryForSlicingAsText(message.getSliceInfo())));
      for (ValidationMessage vm : message.getSliceInfo()) {
        Extension ext = issue.addExtension();
        ext.setUrl(ExtensionDefinitions.EXT_ISSUE_INNER_MESSAGE);
        ext.addExtension("severity", new CodeType(vm.getLevel().toCode()));
        ext.addExtension("type", new CodeType(vm.getType().toCode()));
        ext.addExtension("path", new StringType(vm.getLocation()));
        ext.addExtension("message", new StringType(vm.getMessage()));
      }
    }
    if (message.getServer() != null) {
      issue.addExtension(ExtensionDefinitions.EXT_ISSUE_SERVER, new UrlType(message.getServer()));
    }
    return issue;
  }

  private static String errorSummaryForSlicingAsText(List<ValidationMessage> list) {
    StringBuilder b = new StringBuilder();
    for (ValidationMessage vm : list) {
      if (vm.isSlicingHint()) {
        if (vm.hasSliceInfo()) {
          for (ValidationMessage s : vm.getSliceInfo()) {
            b.append(vm.getLocation() + ": " + s);
          }
        } else {
          b.append(vm.getLocation() + ": " + vm.getMessage());
        }
      } else if (vm.getLevel() == org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity.ERROR || vm.getLevel() == org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity.FATAL) {
        b.append(vm.getLocation() + ": " + vm.getHtml());
      }
    }
    return b.toString();
  }

  public static OperationOutcome createOutcomeSimple(List<ValidationMessage> messages) {
    OperationOutcome res = new OperationOutcome();
    for (ValidationMessage vm : messages) {
      res.addIssue(convertToIssueSimple(vm, res));
    }
    return res;
  }

  public static OperationOutcome outcomeFromTextError(String text) {
    OperationOutcome oo = new OperationOutcome();
    oo.getText().setStatus(NarrativeStatus.GENERATED);
    oo.getText().setDiv(new XhtmlNode(NodeType.Element, "div"));
    oo.getText().getDiv().tx(text);
    OperationOutcomeIssueComponent issue = oo.addIssue();
    issue.setSeverity(IssueSeverity.ERROR);
    issue.setCode(IssueType.EXCEPTION);
    issue.getDetails().setText(text);
    return oo;
  }

}