package org.hl7.fhir.validation.instance.scoring;

import lombok.Getter;

public class RuleScore {
  @Getter
  private String key;
  @Getter
  private int totalCount;
  @Getter
  private double points;
  @Getter
  private int passCount;

  public RuleScore(String key, double points) {
    this.key = key;
    this.points = points;
  }

  public void count(boolean passes) {
    totalCount++;
    if (passes) {
      passCount++;
    }
  }

  public String summary() {
    StringBuilder b = new StringBuilder();
    b.append(key);
    b.append("(");
    b.append(points);
    b.append("): ");
    b.append(totalCount);
    b.append(" = ");
    b.append((passCount * 100) / totalCount);
    b.append("%");
    return b.toString();
  }
}
