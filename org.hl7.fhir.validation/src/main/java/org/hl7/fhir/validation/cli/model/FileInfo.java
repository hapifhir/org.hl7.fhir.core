package org.hl7.fhir.validation.cli.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hl7.fhir.r5.elementmodel.Manager;

public class FileInfo {

  @JsonProperty("fileName")
  private String fileName;

  @JsonProperty("fileContent")
  private String fileContent;

  @JsonProperty("fileType")
  private String fileType;

  @JsonProperty("fileName")
  public String getFileName() {
    return fileName;
  }

  @JsonProperty("fileName")
  public FileInfo setFileName(String fileName) {
    this.fileName = fileName;
    return this;
  }

  @JsonProperty("fileContent")
  public String getFileContent() {
    return fileContent;
  }

  @JsonProperty("fileContent")
  public FileInfo setFileContent(String fileContent) {
    this.fileContent = fileContent;
    return this;
  }

  @JsonProperty("fileType")
  public Manager.FhirFormat getFileType() {
    return Manager.FhirFormat.JSON;
  }

  @JsonProperty("fileType")
  public FileInfo setFileType(String fileType) {
    this.fileType = fileType;
    return this;
  }
}