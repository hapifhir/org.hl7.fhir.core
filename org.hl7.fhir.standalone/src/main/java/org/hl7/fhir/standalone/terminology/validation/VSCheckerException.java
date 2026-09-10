package org.hl7.fhir.standalone.terminology.validation;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.core.OperationOutcome.OperationOutcomeIssueComponent;
import org.hl7.fhir.services.terminology.TerminologyServiceErrorClass;

import java.util.List;


public class VSCheckerException extends FHIRException {

  private List<OperationOutcomeIssueComponent> issues;
  private boolean warning;
  private TerminologyServiceErrorClass type;
  
  public VSCheckerException(String message, List<OperationOutcomeIssueComponent> issues) {
    super(message);
    this.issues = issues;
  }

  public VSCheckerException(String message, List<OperationOutcomeIssueComponent> issues, boolean warning) {
    super(message);
    this.issues = issues;
    this.warning = warning;
  }

  public VSCheckerException(String message, List<OperationOutcomeIssueComponent> issues, TerminologyServiceErrorClass type) {
    super(message);
    this.issues = issues;
    this.type = type;
  }

  public List<OperationOutcomeIssueComponent> getIssues() {
    return issues;
  }

  private static final long serialVersionUID = -5889505119633054187L;

  public boolean isWarning() {
    return warning;
  }

  public TerminologyServiceErrorClass getType() {
    return type;
  }

  public void setType(TerminologyServiceErrorClass type) {
    this.type = type;
  }
  
}