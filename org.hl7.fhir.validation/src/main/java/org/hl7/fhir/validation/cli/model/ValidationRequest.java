package org.hl7.fhir.validation.cli.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public class ValidationRequest {

  @JsonProperty("cliContext")
  @SerializedName("cliContext")
  private
  CliContext cliContext;

  @JsonProperty("filesToValidate")
  @SerializedName("filesToValidate")
  private
  List<FileInfo> filesToValidate = new ArrayList<>();

  @SerializedName("cliContext")
  @JsonProperty("cliContext")
  public CliContext getCliContext() {
    return cliContext;
  }

  @JsonProperty("sessionId")
  @SerializedName("sessionId")
  public
  String sessionId;

  public ValidationRequest() {
  }

  public ValidationRequest(CliContext cliContext, List<FileInfo> filesToValidate) {
    this(cliContext, filesToValidate, null);
  }

  public ValidationRequest(CliContext cliContext, List<FileInfo> filesToValidate, String sessionToken) {
    this.cliContext = cliContext;
    this.filesToValidate = filesToValidate;
    this.sessionId = sessionToken;
  }

  @SerializedName("cliContext")
  @JsonProperty("cliContext")
  public ValidationRequest setCliContext(CliContext cliContext) {
    this.cliContext = cliContext;
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