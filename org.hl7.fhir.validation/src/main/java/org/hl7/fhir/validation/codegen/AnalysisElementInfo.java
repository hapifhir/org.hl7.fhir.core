package org.hl7.fhir.validation.codegen;

public class AnalysisElementInfo {

  private String javaType;
  private String classFile;

  public AnalysisElementInfo(String classFile, String javaType) {
    this.classFile = classFile;
    this.javaType = javaType;
  }

  public String getJavaType() {
    return javaType;
  }

  public String getClassFile() {
    return classFile;
  }

}
