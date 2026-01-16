package org.hl7.fhir.validation.cli.picocli.commands;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.hl7.fhir.validation.special.R4R5MapTester;
import picocli.CommandLine;

import java.util.concurrent.Callable;

/**
 * Command for specialized testing operations.
 * <p/>
 * This is an internal development tool for testing FHIR version conversions
 * and other specialized operations.
 * <p/>
 * Currently supports:
 * - r4r5tests: Tests R4/R4B to R5 structure map conversions
 */
@Slf4j
@CommandLine.Command(
  name = "special",
  description = """
    Internal tool for specialized testing operations.

    Currently supports:
    - r4r5tests: Tests R4/R4B to R5 structure map conversions

    This is an internal development tool.
    """,
  hidden = true
)
public class SpecialCommand extends ValidationServiceCommand implements Callable<Integer> {

  @CommandLine.Parameters(
    index = "0",
    description = "Special mode to execute (e.g., 'r4r5tests')"
  )
  private String specialMode;

  @CommandLine.Option(
    names = {"-target"},
    description = "Target directory for test outcomes"
  )
  private String target;

  @CommandLine.Option(
    names = {"-source"},
    description = "Source directory for map definitions (optional)"
  )
  private String source;

  @CommandLine.Option(
    names = {"-filter"},
    description = "Resource name filter (use '*' for all, or specific resource name)"
  )
  private String filter;

  @Override
  public Integer call() {
    try {
      validateSpecialParameters();

      if ("r4r5tests".equals(specialMode)) {
        if (ManagedFileAccess.file(target).exists()) {
          new R4R5MapTester().testMaps(target, source, filter);
          log.info("Special mode '{}' completed successfully", specialMode);
          return 0;
        } else {
          log.error("Target directory does not exist: {}", target);
          return 1;
        }
      } else {
        log.error("Unknown special mode: {}", specialMode);
        return 1;
      }

    } catch (Exception e) {
      log.error("Error executing special mode", e);
      return 1;
    }
  }

  private void validateSpecialParameters() {
    // Validate mode
    if (specialMode == null || specialMode.isEmpty()) {
      log.error("special requires a mode parameter (e.g., 'r4r5tests')");
      System.exit(1);
    }

    // For r4r5tests mode, target is required
    if ("r4r5tests".equals(specialMode)) {
      if (target == null || target.isEmpty()) {
        log.error("r4r5tests mode requires -target parameter");
        System.exit(1);
      }
    }
  }
}
