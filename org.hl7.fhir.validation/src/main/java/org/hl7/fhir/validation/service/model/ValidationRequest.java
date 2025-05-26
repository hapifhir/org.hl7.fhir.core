package org.hl7.fhir.validation.service.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public class ValidationRequest {

  @JsonProperty("validationContext")
  @JsonAlias("cliContext") // alias for jackson deserialization
  @SerializedName(value="validationContext", alternate={"cliContext"})
  private
  ValidationContext validationContext;

  @JsonProperty("filesToValidate")
  @SerializedName("filesToValidate")
  private
  List<FileInfo> filesToValidate = new ArrayList<>();

  @JsonProperty("validationContext")
  public ValidationContext getValidationContext() {
    return validationContext;
  }

  @JsonProperty("sessionId")
  @SerializedName("sessionId")
  public
  String sessionId;

  public ValidationRequest() {
  }

  public ValidationRequest(ValidationContext validationContext, List<FileInfo> filesToValidate) {
    this(validationContext, filesToValidate, null);
  }

  public ValidationRequest(ValidationContext validationContext, List<FileInfo> filesToValidate, String sessionToken) {
    this.validationContext = validationContext;
    this.filesToValidate = filesToValidate;
    this.sessionId = sessionToken;
  }

  @JsonProperty("validationContext")
  public ValidationRequest setValidationContext(ValidationContext validationContext) {
    this.validationContext = validationContext;
    return this;
  }

  @Deprecated
  @JsonProperty("cliContext")
  @SerializedName(value="cliContext")
  public ValidationRequest setCliContext(ValidationContext validationContext) {
    this.validationContext = validationContext;
    return this;
  }

  @SerializedName("filesToValidate")
  @JsonProperty("filesToValidate")
  public List<FileInfo> getFilesToValidate() {
    return filesToValidate;
  }

  @SerializedName("filesToValidate")
  @JsonProperty("filesToValidate")
  public ValidationRequest setFilesToValidate(List<FileInfo> filesToValidate) {
    this.filesToValidate = filesToValidate;
    return this;
  }

  @SerializedName("sessionId")
  @JsonProperty("sessionId")
  public String getSessionId() {
    return sessionId;
  }

  @SerializedName("sessionId")
  @JsonProperty("sessionId")
  public ValidationRequest setSessionId(String sessionId) {
    this.sessionId = sessionId;
    return this;
  }

  public String listSourceFiles() {
    List<String> fileNames = new ArrayList<>();
    for (FileInfo fp : filesToValidate) {
      fileNames.add(fp.getFileName());
    }
    return String.join(", ", fileNames);
  }
}