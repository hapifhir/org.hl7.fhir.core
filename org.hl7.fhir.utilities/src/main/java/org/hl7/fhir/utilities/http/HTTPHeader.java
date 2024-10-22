package org.hl7.fhir.utilities.http;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.With;

@AllArgsConstructor
@EqualsAndHashCode
public class HTTPHeader {
  @With @Getter
  private final String name;
  @With @Getter
  private final String value;
}
