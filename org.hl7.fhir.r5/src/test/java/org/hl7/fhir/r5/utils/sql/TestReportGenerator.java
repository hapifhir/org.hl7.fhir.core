package org.hl7.fhir.r5.utils.sql;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.utilities.json.model.JsonArray;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;

/**
 * Generates test reports conforming to the SQL on FHIR test report schema.
 * Report structure follows: https://github.com/FHIR/sql-on-fhir-v2/blob/master/test_report/test-report.schema.json
 *
 * @author John Grimes
 */
@Slf4j
public class TestReportGenerator {

  private Map<String, JsonArray> testResults = new HashMap<>();

  /**
   * Add a test result to the report.
   *
   * @param testFileName The name of the test file (e.g., "basic.json")
   * @param result The test result
   */
  public void addResult(String testFileName, SqlOnFhirRunnerTests.TestResult result) {
    JsonArray tests = testResults.computeIfAbsent(testFileName, k -> new JsonArray());

    JsonObject testResult = new JsonObject();
    testResult.add("name", result.name);

    JsonObject resultObject = new JsonObject();
    resultObject.add("passed", result.passed);

    if (!result.passed && result.error != null) {
      resultObject.add("error", result.error);
    }

    testResult.add("result", resultObject);
    tests.add(testResult);
  }

  /**
   * Write the test report to a file.
   *
   * @param filePath Path to write the report to
   */
  public void writeReport(String filePath) {
    try {
      JsonObject report = new JsonObject();

      // Build the report structure.
      for (Map.Entry<String, JsonArray> entry : testResults.entrySet()) {
        JsonObject testSuite = new JsonObject();
        testSuite.add("tests", entry.getValue());
        report.add(entry.getKey(), testSuite);
      }

      // Write to file.
      String json = JsonParser.compose(report, true);
      try (FileWriter writer = new FileWriter(filePath)) {
        writer.write(json);
      }

      log.info("Test report written to: {}", filePath);
      printSummary();

    } catch (IOException e) {
      log.error("Failed to write test report: {}", e.getMessage());
      e.printStackTrace();
    }
  }

  /**
   * Print a summary of test results to console.
   */
  private void printSummary() {
    int totalTests = 0;
    int passedTests = 0;
    int failedTests = 0;

    log.info("\n=== SQL on FHIR Test Results Summary ===");

    for (Map.Entry<String, JsonArray> entry : testResults.entrySet()) {
      String fileName = entry.getKey();
      JsonArray tests = entry.getValue();

      int filePassed = 0;
      int fileFailed = 0;

      for (int i = 0; i < tests.size(); i++) {
        JsonObject test = (JsonObject) tests.get(i);
        JsonObject result = test.getJsonObject("result");
        if (result != null && result.has("passed")) {
          boolean passed = result.asBoolean("passed");
          if (passed) {
            filePassed++;
            passedTests++;
          } else {
            fileFailed++;
            failedTests++;
          }
          totalTests++;
        }
      }

      log.info("{}: {} passed, {} failed (total: {})",
               fileName, filePassed, fileFailed, filePassed + fileFailed);
    }

    log.info("\n=== Overall Summary ===");
    log.info("Total tests: {}", totalTests);
    log.info("Passed: {} ({:.1f}%)", passedTests,
             totalTests > 0 ? (100.0 * passedTests / totalTests) : 0);
    log.info("Failed: {} ({:.1f}%)", failedTests,
             totalTests > 0 ? (100.0 * failedTests / totalTests) : 0);

    if (failedTests > 0) {
      log.info("\nFailed tests:");
      for (Map.Entry<String, JsonArray> entry : testResults.entrySet()) {
        String fileName = entry.getKey();
        JsonArray tests = entry.getValue();

        for (int i = 0; i < tests.size(); i++) {
          JsonObject test = (JsonObject) tests.get(i);
          String name = test.asString("name");
          JsonObject result = test.getJsonObject("result");
          if (result != null && result.has("passed") && !result.asBoolean("passed")) {
            String error = result.has("error") ? result.asString("error") : "Unknown error";
            log.info("  - {}: {} - {}", fileName, name, error);
          }
        }
      }
    }
  }

  /**
   * Clear all test results.
   */
  public void clear() {
    testResults.clear();
  }
}