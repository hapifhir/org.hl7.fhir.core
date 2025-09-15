package org.hl7.fhir.validation.instance.scoring;

import lombok.Getter;
import org.hl7.fhir.r5.model.Extension;

import java.util.ArrayList;
import java.util.List;

public class ScoredElement {
  @Getter
  private final String fhirType;
  @Getter
  private String name;
  @Getter
  private int index;
  @Getter
  private double score;
  @Getter
  private double possibleScore;
  @Getter
  private List<String> reasons;
  @Getter
  private List<Extension> rules;

  private List<ScoredElement> children;

  public ScoredElement(String name, int index, String fhirType, double score, double possibleScore, List<String> reasons, List<Extension> rules) {
    this.name = name;
    this.index = index;
    this.fhirType = fhirType;
    this.score = score;
    this.possibleScore = possibleScore;
    this.reasons = reasons;
    this.rules = rules;
  }

  public void addChild(ScoredElement child) {
    if (children == null) {
      children = new ArrayList<>();
    }
    children.add(child);
  }

  public List<ScoredElement> getChildren() {
    if (children == null) {
      children = new ArrayList<>();
    }
    return children;
  }

}

