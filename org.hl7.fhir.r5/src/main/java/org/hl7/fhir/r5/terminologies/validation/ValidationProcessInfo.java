package org.hl7.fhir.r5.terminologies.validation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.hl7.fhir.r5.model.OperationOutcome.IssueSeverity;
import org.hl7.fhir.r5.model.OperationOutcome.OperationOutcomeIssueComponent;
import org.hl7.fhir.r5.terminologies.utilities.TerminologyServiceErrorClass;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;

public class ValidationProcessInfo {
  private TerminologyServiceErrorClass err;
  private List<OperationOutcomeIssueComponent> issues = new ArrayList<>();
  
  public ValidationProcessInfo() {
  }
  
  public ValidationProcessInfo(List<OperationOutcomeIssueComponent> issues) {
    this.issues = issues;
  }
  public TerminologyServiceErrorClass getErr() {
    return err;
  }
  public void setErr(TerminologyServiceErrorClass err) {
    this.err = err;
  }
  
  public List<OperationOutcomeIssueComponent> getIssues() {
    return issues;
  }
  public void addIssue(List<OperationOutcomeIssueComponent> issues) {
    this.issues.addAll(issues);
    
  }
  public boolean hasErrors() {
    for (OperationOutcomeIssueComponent issue : issues) {
      if (issue.getSeverity() == IssueSeverity.FATAL || issue.getSeverity() == IssueSeverity.ERROR) {
        return true;
      }
    }
    return false;
  }
  public String summary() {
    List<String> msgs = new ArrayList<>();
    for (OperationOutcomeIssueComponent issue : issues) {
      msgs.add(issue.getDetails().getText());
    }
    Collections.sort(msgs);
    return CommaSeparatedStringBuilder.join("; ", msgs);
  }
  public List<String> summaryList() {
    List<String> msgs = new ArrayList<>();
    for (OperationOutcomeIssueComponent issue : issues) {
      msgs.add(issue.getDetails().getText());
    }
    Collections.sort(msgs);
    return msgs;
  }
}