package org.hl7.fhir.utilities.http;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.With;

import javax.annotation.Nonnull;

@EqualsAndHashCode
public class HTTPHeader {
  @With @Getter @Nonnull
  private final String name;
  @With @Getter
  private final String value;

  public HTTPHeader(@Nonnull String name, String value) {
    this.name = name;
    this.value = value;
  }
}
