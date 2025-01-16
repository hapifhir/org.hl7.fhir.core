package org.hl7.fhir.validation.ai;

import org.hl7.fhir.validation.instance.utils.NodeStack;

public class CodeAndTextValidationRequest {
  private Object data;
  
  private NodeStack location;
  private String lang;
  private String system;
  private String code;
  private String display;
  private String text;
  public CodeAndTextValidationRequest(NodeStack location, String lang, String system, String code, String display, String text) {
    super();
    this.location = location;
    this.lang = lang == null ? "en" : lang;
    this.system = system;
    this.code = code;
    this.display = display;
    this.text = text;
  }
  public NodeStack getLocation() {
    return location;
  }
  public String getSystem() {
    return system;
  }
  public String getCode() {
    return code;
  }
  public String getText() {
    return text;
  }
  public String getDisplay() {
    return display;
  }
  public String getLang() {
    return lang;
  }
  public Object getData() {
    return data;
  }
  public CodeAndTextValidationRequest setData(Object data) {
    this.data = data;
    return this;
  }
}