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
 * Command to run the terminology service test cases against a terminology server.
 * <p/>
 * Executes the tests published by the tx-ecosystem IG and generates a JSON report with the
 * results. Tests can be filtered by suite, mode and name.
 * <p/>
 * This is a documented, publicly used conformance workflow - see
 * https://hl7.org/fhir/uv/tx-ecosystem/testcases.html - so it is deliberately NOT hidden:
 * someone who mistypes an option has to be able to find the right one in the help.
 */
@Slf4j
@CommandLine.Command(
  name = "txTests",
  description = """
    Run the terminology service test cases against a terminology server.

    Executes the test cases published by the tx-ecosystem IG and writes a JSON report of the
    results, along with the actual response for each failed test. Tests can be filtered by
    suite, mode and name.

    The tests are fetched for you - there is nothing to download. The version of FHIR tested is
    the server's own, so it is not a parameter.

    Documentation: https://hl7.org/fhir/uv/tx-ecosystem/testcases.html
    """
)
public class TxTestsCommand extends ValidationServiceCommand implements Callable<Integer> {

  @CommandLine.Option(
    names = {"-output"},
    description = "Output directory for test results (default: [tmp])"
  )
  private String output;

  @CommandLine.Option(
    names = {"-test-version"},
    description = "Version of the tx-ecosystem test cases to run, e.g. 1.9.3 - NOT a FHIR version "
      + "(the FHIR version tested is whatever the server reports). Released versions are listed at "
      + "https://hl7.org/fhir/uv/tx-ecosystem/history.html. Default: current, the tests as they "
      + "stand in the ci-build of the IG, which change whenever the IG's master branch changes"
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
    names = {"-suite"},
    description = "Run only tests belonging to the named suite"
  )
  private String suite;

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
    split = ",",
    description = "Test modes to execute, comma-separated or repeated (default: general). Use !general to exclude general mode."
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

      // Create TxTester instance. -test-version names the tx-ecosystem package to load the
      // tests from; it is NOT a FHIR version, so it must not be passed as one. The suites'
      // and tests' version gates are FHIR version gates, and TxTester evaluates them against
      // the version the server under test reports.
      TxTester txTester = new TxTester(
        new TxTester.InternalTxLoader(version),
        tx,
        false,
        externalsJson,
        null
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
      boolean ok = txTester.setOutput(outputDir).execute(modeSet, filter, suite);

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
