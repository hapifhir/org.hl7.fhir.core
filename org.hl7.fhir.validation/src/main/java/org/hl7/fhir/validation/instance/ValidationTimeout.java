package org.hl7.fhir.validation.instance;

import lombok.Getter;

public class ValidationTimeout {
  @Getter
  private final long timeoutMillis;
  @Getter
  private final String source;

  /**
   *
   * @param timeoutMillis The maximum time a validation will be allowed to run before timing out
   * @param source The means by which the timeout was set (from a CLI option, programmatically, etc.)
   */
  public ValidationTimeout(final long timeoutMillis, final String source) {
    this.timeoutMillis = timeoutMillis;
    this.source = source;
  }
}
