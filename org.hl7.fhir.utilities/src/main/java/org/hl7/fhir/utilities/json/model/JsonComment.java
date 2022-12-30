package org.hl7.fhir.utilities.json.model;

public class JsonComment {
  private JsonLocationData start;
  private JsonLocationData end;
  private String content;
  
  public JsonComment(String content, JsonLocationData start, JsonLocationData end) {
    super();
    this.content = content;
    this.start = start;
    this.end = end;
  }

  public JsonLocationData getStart() {
    return start;
  }

  public JsonLocationData getEnd() {
    return end;
  }

  public String getContent() {
    return content;
  }
  
  
}
