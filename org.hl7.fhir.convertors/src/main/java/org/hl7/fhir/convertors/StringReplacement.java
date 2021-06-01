package org.hl7.fhir.convertors;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class StringReplacement {
  public String source;
  public String replacement;
}
