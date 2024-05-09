package org.hl7.fhir.utilities.i18n.subtag;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public abstract class Subtag {


  @Getter @Setter
  private String added;

  @Getter @Setter
  private String deprecated;

  private List<String> descriptions = new ArrayList<>();

  private List<String> comments = new ArrayList<>();

  @Getter
  private final String subtag;


  protected Subtag(String subtag){
    this.subtag = subtag;
  }

  protected boolean addDescription(String description) {
    return descriptions.add(description);
  }

  public List<String> getDescriptions() {
    return List.copyOf(descriptions);
  }

  protected boolean addComments(String comment) {
    return comments.add(comment);
  }

  public List<String> getComments() {
    return List.copyOf(comments);
  }
  
  public String getDisplay() {
    if (descriptions.size() == 0) {
      return "";
    } else {
      return descriptions.get(0);
    }
  }
}
