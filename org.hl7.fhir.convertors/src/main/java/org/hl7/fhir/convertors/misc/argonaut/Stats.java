package org.hl7.fhir.convertors.misc.argonaut;

import lombok.Data;

@Data
public class Stats {
  private int instances;
  private int errors;
  private int warnings;
}
