package org.hl7.fhir.validation.service.model;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import org.hl7.fhir.utilities.validation.ValidationMessage;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ValidationOutcome {

  @JsonProperty("fileInfo")
  @SerializedName("fileInfo")
  private
  FileInfo fileInfo;

  @JsonProperty("issues")
  @SerializedName("issues")
  private
  List<ValidationMessage> messages = new ArrayList<>();

  public ValidationOutcome() {
  }

  public ValidationOutcome(FileInfo fileInfo, List<ValidationMessage> issues) {
    this.fileInfo = fileInfo;
    this.messages = issues;
  }

  @SerializedName("fileInfo")
  @JsonProperty("fileInfo")
  public FileInfo getFileInfo() {
    return fileInfo;
  }

  @SerializedName("fileInfo")
  @JsonProperty("fileInfo")
  public ValidationOutcome setFileInfo(FileInfo fileInfo) {
    this.fileInfo = fileInfo;
    return this;
  }

  @SerializedName("issues")
  @JsonProperty("issues")
  public List<ValidationMessage> getMessages() {
    return messages;
  }

  @SerializedName("issues")
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