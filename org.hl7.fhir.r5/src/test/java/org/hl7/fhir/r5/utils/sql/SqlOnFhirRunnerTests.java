package org.hl7.fhir.r5.utils.sql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import lombok.extern.slf4j.Slf4j;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.r5.utils.sql.Runner;
import org.hl7.fhir.utilities.json.model.JsonArray;
import org.hl7.fhir.utilities.json.model.JsonElement;
import org.hl7.fhir.utilities.json.model.JsonNull;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * Tests for SQL on FHIR Runner implementation based on the official test suite.
 * Tests are loaded from JSON files in the resources/sof directory.
 *
 * @author John Grimes
 */
@Slf4j
public class SqlOnFhirRunnerTests {

  private static IWorkerContext context;
  private static TestReportGenerator reportGenerator;
  private static Map<String, JsonObject> testFiles = new HashMap<>();

  @BeforeAll
  public static void setUp() throws Exception {
    context = TestingUtilities.getSharedWorkerContext();
    reportGenerator = new TestReportGenerator();
    loadTestFiles();
  }

  @AfterAll
  public static void tearDown() {
    reportGenerator.writeReport("target/sof-test-report.json");
  }

  private static void loadTestFiles() throws IOException {
    File testDir = new File("src/test/resources/sof");
    if (testDir.exists() && testDir.isDirectory()) {
      File[] files = testDir.listFiles((dir, name) -> name.endsWith(".json"));
      if (files != null) {
        for (File file : files) {
          String content = Files.readString(file.toPath());
          JsonObject testFile = org.hl7.fhir.utilities.json.parser.JsonParser.parseObject(content);
          testFiles.put(file.getName(), testFile);
        }
      }
    }
  }

  public static Stream<Arguments> testCases() {
    List<Arguments> arguments = new ArrayList<>();

    for (Map.Entry<String, JsonObject> entry : testFiles.entrySet()) {
      String fileName = entry.getKey();
      JsonObject testFile = entry.getValue();

      if (testFile.has("tests")) {
        JsonArray tests = testFile.getJsonArray("tests");
        for (JsonElement element : tests) {
          if (element instanceof JsonObject) {
            JsonObject test = (JsonObject) element;
            String testName = test.asString("title");
            arguments.add(Arguments.of(fileName, testName, testFile, test));
          }
        }
      }
    }

    return arguments.stream();
  }

  @ParameterizedTest(name = "{0}: {1}")
  @MethodSource("testCases")
  @DisplayName("SQL on FHIR Runner Test")
  public void testRunner(String fileName, String testName, JsonObject testFile, JsonObject test) throws Exception {
    log.info("Running test: {} - {}", fileName, testName);

    TestResult result = new TestResult();
    result.name = testName;

    try {
      // Extract view definition.
      JsonObject view = test.getJsonObject("view");
      if (view == null) {
        throw new IllegalArgumentException("Test missing 'view' definition");
      }

      // Create test provider with resources.
      TestProvider provider = new TestProvider();
      if (testFile.has("resources")) {
        JsonElement resources = testFile.get("resources");
        if (resources instanceof JsonArray) {
          loadResources((JsonArray) resources, provider);
        }
      }

      // Create test storage.
      TestStorage storage = new TestStorage();

      // Create and configure runner.
      Runner runner = new Runner();
      runner.setContext(context);
      runner.setProvider(provider);
      runner.setStorage(storage);

      // Check for expectError.
      boolean expectError = test.has("expectError");

      try {
        // Execute the view.
        runner.execute(view);

        if (expectError) {
          fail("Expected error but none was thrown");
        }

        // Get actual results.
        JsonArray actualResults = storage.getResults();

        // Compare with expected results.
        if (test.has("expect")) {
          JsonArray expectedResults = test.getJsonArray("expect");
          compareResults(expectedResults, actualResults, result);
        }

        // Check column ordering if specified.
        if (test.has("expectColumns")) {
          JsonArray expectedColumns = test.getJsonArray("expectColumns");
          checkColumnOrder(expectedColumns, actualResults, result);
        }

        result.passed = true;

      } catch (Exception e) {
        if (expectError) {
          // Check if error matches expected error pattern.
          if (test.has("expectErrorPattern")) {
            String pattern = test.asString("expectErrorPattern");
            if (!e.getMessage().contains(pattern)) {
              result.passed = false;
              result.error = "Error message did not match expected pattern: " + e.getMessage();
            } else {
              result.passed = true;
            }
          } else {
            result.passed = true;
          }
        } else {
          throw e;
        }
      }

    } catch (Exception e) {
      result.passed = false;
      result.error = e.getClass().getSimpleName() + ": " + e.getMessage();
      if (test.has("expectError")) {
        // If we expected an error and got one, it's still a pass.
        result.passed = true;
      }
    }

    // Add result to report.
    reportGenerator.addResult(fileName, result);

    // Assert test passed.
    if (!result.passed) {
      fail("SQL on FHIR test failed: " + fileName + " - " + testName +
           (result.error != null ? " - " + result.error : ""));
    }
  }

  private void loadResources(JsonArray resources, TestProvider provider) throws IOException {
    org.hl7.fhir.r5.formats.JsonParser fhirParser = new org.hl7.fhir.r5.formats.JsonParser();

    for (JsonElement element : resources) {
      if (element instanceof JsonObject) {
        JsonObject resourceJson = (JsonObject) element;
        String json = org.hl7.fhir.utilities.json.parser.JsonParser.compose(resourceJson, true);
        try (InputStream inputStream = new ByteArrayInputStream(json.getBytes(StandardCharsets.UTF_8))) {
          Resource resource = fhirParser.parse(inputStream);
          provider.addResource(resource);
        }
      }
    }
  }

  private void compareResults(JsonArray expected, JsonArray actual, TestResult result) {
    if (expected.size() != actual.size()) {
      result.passed = false;
      result.error = String.format("Result count mismatch: expected %d, got %d",
                                   expected.size(), actual.size());
      return;
    }

    // Deep comparison of JSON results.
    for (int i = 0; i < expected.size(); i++) {
      JsonElement expectedRow = expected.get(i);
      JsonElement actualRow = actual.get(i);

      if (!compareJsonElements(expectedRow, actualRow)) {
        result.passed = false;
        result.error = String.format("Row %d mismatch: expected %s, got %s",
                                     i, expectedRow, actualRow);
        return;
      }
    }
  }

  private boolean compareJsonElements(JsonElement expected, JsonElement actual) {
    if (expected instanceof JsonNull && actual instanceof JsonNull) {
      return true;
    }
    if (expected instanceof JsonNull || actual instanceof JsonNull) {
      return false;
    }
    if (expected.getClass() != actual.getClass()) {
      return false;
    }

    if (expected instanceof JsonObject) {
      JsonObject expectedObj = (JsonObject) expected;
      JsonObject actualObj = (JsonObject) actual;

      if (expectedObj.getNames().size() != actualObj.getNames().size()) {
        return false;
      }

      for (String key : expectedObj.getNames()) {
        if (!actualObj.has(key)) {
          return false;
        }
        if (!compareJsonElements(expectedObj.get(key), actualObj.get(key))) {
          return false;
        }
      }
      return true;
    } else if (expected instanceof JsonArray) {
      JsonArray expectedArr = (JsonArray) expected;
      JsonArray actualArr = (JsonArray) actual;

      if (expectedArr.size() != actualArr.size()) {
        return false;
      }

      for (int i = 0; i < expectedArr.size(); i++) {
        if (!compareJsonElements(expectedArr.get(i), actualArr.get(i))) {
          return false;
        }
      }
      return true;
    } else {
      // Primitive comparison.
      return expected.toString().equals(actual.toString());
    }
  }

  private void checkColumnOrder(JsonArray expectedColumns, JsonArray results, TestResult result) {
    if (results.size() == 0) {
      return;
    }

    JsonElement firstRow = results.get(0);
    if (firstRow instanceof JsonObject) {
      JsonObject row = (JsonObject) firstRow;
      List<String> actualColumns = new ArrayList<>(row.getNames());

      List<String> expected = new ArrayList<>();
      for (JsonElement col : expectedColumns) {
        expected.add(col.toString().replaceAll("\"", ""));
      }

      if (!actualColumns.equals(expected)) {
        result.passed = false;
        result.error = String.format("Column order mismatch: expected %s, got %s",
                                     expected, actualColumns);
      }
    }
  }

  /**
   * Simple test result class.
   */
  static class TestResult {
    String name;
    boolean passed;
    String error;
  }
}