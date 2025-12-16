package org.hl7.fhir.validation.cli.picocli.commands;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.utilities.CommaSeparatedStringBuilder;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.json.JsonException;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;
import org.hl7.fhir.validation.special.TxTester;
import picocli.CommandLine;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

/**
 * Command to run terminology service tests against a terminology server.
 * <p/>
 * This hidden command executes terminology tests and generates a JSON report
 * with results. Tests can be filtered by mode and name pattern.
 * <p/>
 * This is an internal tool for terminology testing.
 */
@Slf4j
@CommandLine.Command(
  name = "txTests",
  description = """
    Run terminology service tests against a terminology server.

    Executes terminology tests and generates a JSON report with results.
    Tests can be filtered by mode and name pattern.

    Hidden internal tool for terminology testing.
    """,
  hidden = true
)
public class TxTestsCommand extends ValidationServiceCommand implements Callable<Integer> {

  @CommandLine.Option(
    names = {"-output"},
    description = "Output directory for test results (default: [tmp])"
  )
  private String output;

  @CommandLine.Option(
    names = {"-test-version"},
    description = "FHIR version for tests (default: current)"
  )
  private String testVersion;

  @CommandLine.Option(
    names = {"-tx"},
    description = "Terminology server URL"
  )
  private String tx;

  @CommandLine.Option(
    names = {"-filter"},
    description = "Filter for test names"
  )
  private String filter;

  @CommandLine.Option(
    names = {"-externals"},
    description = "Path to JSON file with external test definitions"
  )
  private String externals;

  @CommandLine.Option(
    names = {"-input"},
    description = "Additional test loaders (can be specified multiple times)"
  )
  private List<String> inputs = new ArrayList<>();

  @CommandLine.Option(
    names = {"-mode"},
    description = "Test modes to execute (default: general). Use !general to exclude general mode."
  )
  private List<String> modes = new ArrayList<>();

  @Override
  public Integer call() {
    try {
      // Set defaults
      String outputDir = (output == null) ? Utilities.path("[tmp]") : output;
      String version = (testVersion == null) ? "current" : testVersion;

      // Load externals if provided
      JsonObject externalsJson = loadExternals(externals);

      // Create TxTester instance
      TxTester txTester = new TxTester(
        new TxTester.InternalTxLoader(version),
        tx,
        false,
        externalsJson
      );

      // Add input loaders
      for (String input : inputs) {
        txTester.addLoader(new TxTester.InternalTxLoader(input, true));
      }

      // Process mode parameters
      Set<String> modeSet = new HashSet<>();
      modeSet.add("general");  // Default mode

      for (String m : modes) {
        if ("!general".equals(m)) {
          modeSet.remove("general");
        } else {
          modeSet.add(m);
        }
      }

      log.info("Testing Modes: " +
        CommaSeparatedStringBuilder.join(" | ", Utilities.sorted(modeSet)));

      // Execute tests
      boolean ok = txTester.setOutput(outputDir).execute(modeSet, filter);

      // Write report
      new org.hl7.fhir.r5.formats.JsonParser()
        .setOutputStyle(OutputStyle.PRETTY)
        .compose(
          new FileOutputStream(Utilities.path(outputDir, "report.json")),
          txTester.getTestReport()
        );

      log.info("Terminology tests completed " + (ok ? "successfully" : "with failures"));
      return ok ? 0 : 1;

    } catch (Exception e) {
      log.error("Error executing terminology tests", e);
      return 1;
    }
  }

  private JsonObject loadExternals(String externals) throws JsonException, IOException {
    if (externals == null) {
      return null;
    } else {
      return JsonParser.parseObjectFromFile(externals);
    }
  }
}
