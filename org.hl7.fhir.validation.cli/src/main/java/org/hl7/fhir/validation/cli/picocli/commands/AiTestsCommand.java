package org.hl7.fhir.validation.cli.picocli.commands;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.validation.ai.AITests;
import picocli.CommandLine;

import java.util.concurrent.Callable;

/**
 * Command to run AI validation tests against code and text combinations.
 * <p/>
 * This hidden command executes AI-based test cases to validate that coded
 * concepts are consistent with their text representations. Uses AI services
 * to check code/text pairs and generates validation statistics and detailed reports.
 * <p/>
 * This is an internal tool for testing AI validation accuracy.
 */
@Slf4j
@CommandLine.Command(
  name = "aiTests",
  description = """
    Run AI validation tests against code and text combinations.

    Executes AI-based test cases to validate that coded concepts are
    consistent with their text representations. Uses AI services to check
    code/text pairs and generates validation statistics and detailed reports.

    Hidden internal tool for testing AI validation accuracy.
    """,
  hidden = true
)
public class AiTestsCommand extends ValidationServiceCommand implements Callable<Integer> {

  @CommandLine.Option(
    names = {"-source"},
    description = "JSON file containing test cases with code and text combinations",
    required = true
  )
  private String source;

  @CommandLine.Option(
    names = {"-config"},
    description = "JSON configuration file with AI service settings (default: built-in ai-prompts.json)"
  )
  private String config;

  @CommandLine.Option(
    names = {"-run-tests"},
    description = "Execute validation against actual AI services (default: process existing results)",
    arity = "0"
  )
  private boolean runTests = false;

  @Override
  public Integer call() {
    try {
      log.info("Starting AI validation tests");
      log.info("Source: {}", source);
      if (config != null) {
        log.info("Config: {}", config);
      }
      log.info("Run tests mode: {}", runTests);

      // Create AITests instance
      AITests ai = new AITests();

      // Execute core business logic
      ai.execute(source, config, runTests);

      log.info("AI tests completed successfully");
      return 0;

    } catch (Exception e) {
      log.error("Error executing AI tests", e);
      return 1;
    }
  }
}
