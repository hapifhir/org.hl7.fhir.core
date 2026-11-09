package org.hl7.fhir.services.comparison;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.hl7.fhir.model.core.StructureDefinition;
import org.junit.jupiter.api.Test;

class ResourceComparerTest {

  // the id after its type prefix: 1-example-example for the first comparison
  private static String comparisonId() {
    StructureDefinition sd = new StructureDefinition();
    sd.setId("example");
    String id = new ResourceComparer.PlaceHolderComparison(sd, sd).getId();
    return id.substring(id.indexOf('-') + 1);
  }

  @Test
  void resetCounterNumbersTheComparisonsFromOneAgain() {
    comparisonId();
    comparisonId();
    ResourceComparer.resetCounter();
    assertEquals("1-example-example", comparisonId());
    assertEquals("2-example-example", comparisonId());
  }
}
