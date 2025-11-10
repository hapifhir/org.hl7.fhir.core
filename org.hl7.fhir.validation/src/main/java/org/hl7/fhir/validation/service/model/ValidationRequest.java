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
  @Deprecated(since="2025-10-21")
  private
  ValidationContext validationContext;

  @JsonProperty("validationContext")
  @Deprecated(since="2025-10-21")
  public ValidationContext getValidationContext() {
    return validationContext;
  }

  @JsonProperty("validationContext")
  @Deprecated(since="2025-10-21")
  public ValidationRequest setValidationContext(ValidationContext validationContext) {
    this.validationContext = validationContext;
    return this;
  }

  @JsonProperty("filesToValidate")
  @SerializedName("filesToValidate")
  private
  List<FileInfo> filesToValidate = new ArrayList<>();


  @JsonProperty("validationEngineParameters")
  @SerializedName("validationEngineParameters")
  private
  ValidationEngineParameters validationEngineParameters;

  @JsonProperty("validationEngineParameters")
  public ValidationEngineParameters getValidationEngineParameters() {
    return validationEngineParameters;
  }

  @JsonProperty("validationEngineParameters")
  public ValidationRequest setValidationEngineParameters(ValidationEngineParameters validationEngineParameters) {
    this.validationEngineParameters = validationEngineParameters;
    return this;
  }

  @JsonProperty("instanceValidatorParameters")
  @SerializedName("instanceValidatorParameters")
  private
  InstanceValidatorParameters instanceValidatorParameters;

  @JsonProperty("instanceValidatorParameters")
  public InstanceValidatorParameters getInstanceValidatorParameters() {
    return instanceValidatorParameters;
  }

  @JsonProperty("instanceValidatorParameters")
  public ValidationRequest setInstanceValidatorParameters(InstanceValidatorParameters instanceValidatorParameters) {
    this.instanceValidatorParameters = instanceValidatorParameters;
    return this;
  }

  @JsonProperty("sources")
  @SerializedName("sources")
  private
  List<String> sources = new ArrayList<>();

  @JsonProperty("sources")
  public List<String> getSources() {
    return sources;
  }

  @JsonProperty("sources")
  public ValidationRequest setSources(List<String> sources) {
    this.sources = sources;
    return this;
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