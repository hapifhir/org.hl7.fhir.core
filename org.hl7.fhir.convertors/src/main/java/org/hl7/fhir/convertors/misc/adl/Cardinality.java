package org.hl7.fhir.convertors.misc.adl;

import lombok.Data;

@Data
public class Cardinality {
  private String min;
  private String max;
}
