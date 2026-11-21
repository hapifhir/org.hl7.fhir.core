package org.hl7.fhir.validation.cli.picocli.options;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.hl7.fhir.validation.service.model.InstanceValidatorParameters;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.Test;

import picocli.CommandLine;

/**
 * -check-display never had any effect. It's deprecated: still accepted, so existing command lines keep working,
 * but hidden, and ignored
 */
class CheckDisplayDeprecationTests {

  @ParameterizedTest
  @ValueSource(strings = {"Ignore", "Check", "CheckCase", "CheckSpace", "CheckCaseAndSpace", "anything"})
  void checkDisplayIsStillAcceptedAndIgnored(String value) {
    InstanceValidatorOptions options = new InstanceValidatorOptions();
    new CommandLine(options).parseArgs("-check-display", value, "-resource-id-rule", "required");
    assertEquals(value, options.checkDisplay);

    InstanceValidatorParameters parameters = new InstanceValidatorOptionsConvertor().convert(options);
    InstanceValidatorOptions withoutIt = new InstanceValidatorOptions();
    new CommandLine(withoutIt).parseArgs("-resource-id-rule", "required");
    assertEquals(new InstanceValidatorOptionsConvertor().convert(withoutIt), parameters);
  }

  @Test
  void checkDisplayIsNotInTheHelp() {
    String usage = new CommandLine(new InstanceValidatorOptions()).getUsageMessage();
    assertFalse(usage.contains("-check-display"), usage);
  }
}
