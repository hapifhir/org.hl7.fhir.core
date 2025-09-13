package org.hl7.fhir.validation.instance.scoring;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class ScoreOutcome {
  @Getter
  private List<RuleScore> rules = new ArrayList<>();
  @Getter @Setter
  private ScoredElement element;
}
