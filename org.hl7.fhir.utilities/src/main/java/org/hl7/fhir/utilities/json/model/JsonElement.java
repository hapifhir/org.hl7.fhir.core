package org.hl7.fhir.utilities.json.model;

import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.utilities.json.JsonException;

public abstract class JsonElement {

  private List<String> comments;
  private JsonLocationData start;
  private JsonLocationData end;
  
  public abstract JsonElementType elementType();

  public List<String> getComments() {
    if (comments == null ) {
      comments = new ArrayList<>();
    }
    return comments;
  }

  public JsonLocationData getStart() {
    return start;
  }

  public void setStart(JsonLocationData start) {
    this.start = start;
  }

  public JsonLocationData getEnd() {
    return end;
  }

  public void setEnd(JsonLocationData end) {
    this.end = end;
  }

  protected void check(boolean test, String msg) throws JsonException {
    if (!test) {
      throw new JsonException(msg);
    }    
  }

  public boolean hasComments() {
    return comments != null && !comments.isEmpty();
  }
}
