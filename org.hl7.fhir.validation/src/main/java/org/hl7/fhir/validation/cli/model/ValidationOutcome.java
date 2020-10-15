package org.hl7.fhir.validation.cli.model;

import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.utilities.validation.ValidationMessage;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ValidationOutcome {

  @JsonProperty("fileInfo")
  private FileInfo fileInfo;
  @JsonProperty("issues")
  private List<ValidationMessage> messages = new ArrayList<>();

  public ValidationOutcome() {
  }

  public ValidationOutcome(FileInfo fileInfo, List<ValidationMessage> issues) {
    this.fileInfo = fileInfo;
    this.messages = issues;
  }

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
  public List<ValidationMessage> getMessages() {
    return messages;
  }

  @JsonProperty("issues")
  public ValidationOutcome setMessages(List<ValidationMessage> issues) {
    this.messages = issues;
    return this;
  }

  public ValidationOutcome addMessage(ValidationMessage message) {
    messages.add(message);
    return this;
  }

}