package org.hl7.fhir.validation.cli.model;

import com.fasterxml.jackson.annotation.JsonProperty;

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

  public FileInfo() {}

  public FileInfo(String fileName, String fileContent, String fileType) {
    this.fileName = fileName;
    this.fileContent = fileContent;
    this.fileType = fileType;
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
  public String getFileType() {
    return fileType;
  }

  @JsonProperty("fileType")
  public FileInfo setFileType(String fileType) {
    this.fileType = fileType;
    return this;
  }

  @Override
  public String toString() {
    return "FileInfo{" +
      "fileName='" + fileName + '\'' +
      ", fileContent='" + fileContent + '\'' +
      ", fileType='" + fileType + '\'' +
      '}';
  }
}