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
   * @param source The means by which the message limit was set (from a CLI option, programmatically, etc.)
   */
  public ValidatorMaxMessages(final int maxMessages, final String source) {
    if (maxMessages < 1) {
      throw new IllegalArgumentException("maxMessages must be >= 1");
    }
    this.maxMessages = maxMessages;
    this.source = source;
  }
}
