package org.hl7.fhir.validation.cli.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hl7.fhir.r5.model.OperationOutcome;

import java.util.ArrayList;
import java.util.List;

public class ValidationOutcome {

  @JsonProperty("fileInfo")
  private FileInfo fileInfo;
  @JsonProperty("issues")
  private List<ValidationIssue> issues = new ArrayList<>();

  @JsonProperty("fileInfo")
  public FileInfo getFileInfo() {
    return fileInfo;
  }

  @JsonProperty("fileInfo")
  public ValidationOutcome setFileInfo(FileInfo fileInfo) {
    this.fileInfo = fileInfo;
    return this;
  }

  @JsonProperty("issues")
  public List<ValidationIssue> getIssues() {
    return issues;
  }

  @JsonProperty("issues")
  public ValidationOutcome setIssues(List<ValidationIssue> issues) {
    this.issues = issues;
    return this;
  }

  public ValidationOutcome addIssue(OperationOutcome.OperationOutcomeIssueComponent outcome) {
    String text = outcome.getDetails().getText();
    text.replace("\'", "\"");
    issues.add(new ValidationIssue()
      .setSeverity(outcome.getSeverity().getDisplay())
      .setDetails(outcome.getDetails().getText()));
    return this;
  }

}