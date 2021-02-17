package org.hl7.fhir.validation.cli.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ValidationRequest {

  @JsonProperty("cliContext")
  private CliContext cliContext;

  @JsonProperty("filesToValidate")
  private List<FileInfo> filesToValidate = new ArrayList<>();

  @JsonProperty("cliContext")
  public CliContext getCliContext() {
    return cliContext;
  }

  @JsonProperty("sessionToken")
  public String sessionToken;

  public ValidationRequest() {}

  public ValidationRequest(CliContext cliContext, List<FileInfo> filesToValidate) {
    this(cliContext, filesToValidate, null);
  }

  public ValidationRequest(CliContext cliContext, List<FileInfo> filesToValidate, String sessionToken) {
    this.cliContext = cliContext;
    this.filesToValidate = filesToValidate;
    this.sessionToken = sessionToken;
  }

  @JsonProperty("cliContext")
  public ValidationRequest setCliContext(CliContext cliContext) {
    this.cliContext = cliContext;
    return this;
  }

  @JsonProperty("filesToValidate")
  public List<FileInfo> getFilesToValidate() {
    return filesToValidate;
  }

  @JsonProperty("filesToValidate")
  public ValidationRequest setFilesToValidate(List<FileInfo> filesToValidate) {
    this.filesToValidate = filesToValidate;
    return this;
  }

  @JsonProperty("sessionToken")
  public String getSessionToken() {
    return sessionToken;
  }

  @JsonProperty("sessionToken")
  public ValidationRequest setSessionToken(String sessionToken) {
    this.sessionToken = sessionToken;
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