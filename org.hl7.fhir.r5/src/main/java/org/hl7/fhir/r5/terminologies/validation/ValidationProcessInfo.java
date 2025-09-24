package org.hl7.fhir.r5.terminologies.validation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import org.hl7.fhir.r5.model.OperationOutcome.IssueSeverity;
import org.hl7.fhir.r5.model.OperationOutcome.OperationOutcomeIssueComponent;
import org.hl7.fhir.r5.terminologies.utilities.TerminologyServiceErrorClass;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.MarkedToMoveToAdjunctPackage;

@MarkedToMoveToAdjunctPackage
public class ValidationProcessInfo {
  private TerminologyServiceErrorClass err;
  private List<OperationOutcomeIssueComponent> issues = new ArrayList<>();
  @Getter @Setter
  private String foundVersion;

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

  public List<String> summaryList() {
    List<String> msgs = new ArrayList<>();
    for (OperationOutcomeIssueComponent issue : issues) {
      msgs.add(issue.getDetails().getText());
    }
    Collections.sort(msgs);
    return msgs;
  }

  public boolean hasMessage(String msg) {
    for (OperationOutcomeIssueComponent iss : issues) {
      if (msg.equals(iss.getDetails().getText())) {
        return true;        
      }
    }
    return false;
  }

  public boolean hasNotFound(String system) {
    for (OperationOutcomeIssueComponent iss : issues) {
      if (iss.getDetails().hasCoding("http://hl7.org/fhir/tools/CodeSystem/tx-issue-type", "not-found") &&
          iss.getDetails().hasText() && iss.getDetails().getText().contains(system)) {
        return true;
      }
    }
    return false;
  }
}