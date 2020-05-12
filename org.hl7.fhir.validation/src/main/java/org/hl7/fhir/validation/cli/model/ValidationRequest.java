package org.hl7.fhir.validation.cli.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class ValidationRequest {

  @JsonProperty("cliContext")
  private CliContext cliContext;

  @JsonProperty("filesToValidate")
  private List<FileInfo> filesToValidate = new ArrayList<>();

  @JsonProperty("cliContext")
  public CliContext getCliContext() {
    return cliContext;
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

  public String listSourceFiles() {
    List<String> fileNames = new ArrayList<>();
    for (FileInfo fp : filesToValidate) {
      fileNames.add(fp.getFileName());
    }
    return String.join(", ", fileNames);
  }
}