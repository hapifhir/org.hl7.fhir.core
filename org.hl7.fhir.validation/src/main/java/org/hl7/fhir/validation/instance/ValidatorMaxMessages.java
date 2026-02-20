package org.hl7.fhir.validation.instance;

import lombok.Getter;

public class ValidatorMaxMessages {
  @Getter
  private final int maxMessages;
  @Getter
  private final String source;

  /**
   *
   * @param maxMessages The maximum messages validation will be allowed to collect before stopping
   * @param source The means by which the timeout was set (from a CLI option, programmatically, etc.)
   */
  public ValidatorMaxMessages(final int maxMessages, final String source) {
    if (maxMessages < 0) {
      throw new IllegalArgumentException();
    }
    this.maxMessages = maxMessages;
    this.source = source;
  }
}
