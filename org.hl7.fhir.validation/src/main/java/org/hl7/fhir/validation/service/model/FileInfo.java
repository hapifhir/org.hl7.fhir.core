package org.hl7.fhir.validation.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public class FileInfo {

  @JsonProperty("fileName")
  @SerializedName("fileName")
  private
  String fileName;

  @JsonProperty("fileContent")
  @SerializedName("fileContent")
  private
  String fileContent;

  @JsonProperty("fileType")
  @SerializedName("fileType")
  private
  String fileType;

  @SerializedName("fileName")
  @JsonProperty("fileName")
  public String getFileName() {
    return fileName;
  }

  public FileInfo() {
  }

  public FileInfo(String fileName, String fileContent, String fileType) {
    this.fileName = fileName;
    this.fileContent = fileContent;
    this.fileType = fileType;
  }

  @SerializedName("fileName")
  @JsonProperty("fileName")
  public FileInfo setFileName(String fileName) {
    this.fileName = fileName;
    return this;
  }

  @SerializedName("fileContent")
  @JsonProperty("fileContent")
  public String getFileContent() {
    return fileContent;
  }

  @SerializedName("fileContent")
  @JsonProperty("fileContent")
  public FileInfo setFileContent(String fileContent) {
    this.fileContent = fileContent;
    return this;
  }

  @SerializedName("fileType")
  @JsonProperty("fileType")
  public String getFileType() {
    return fileType;
  }

  @SerializedName("fileType")
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