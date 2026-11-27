package org.hl7.fhir.support.archetypes;

import lombok.Data;

@Data
public class Cardinality {
  private String min;
  private String max;
}
