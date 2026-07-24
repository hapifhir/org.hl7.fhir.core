package org.hl7.fhir.validation.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.charset.StandardCharsets;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.utilities.FhirPublication;
import org.hl7.fhir.utilities.json.model.JsonArray;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;
import org.hl7.fhir.utilities.settings.FhirSettings;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.ValidationEngine.ManipulationResult;
import org.hl7.fhir.validation.tests.utilities.TestUtilities;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Exercises {@link org.hl7.fhir.r5.testfactory.ProfileBasedManipulator} via
 * {@link ValidationEngine#manipulateResource} — the same entry point the ITB
 * REST API uses ({@code POST /itb/testdata/process} with {@code operation: "manipulate"}).
 *
 * Three concerns:
 *   1. Each op kind (set, add, remove) writes/reads the element tree as expected.
 *   2. enforce=true returns an OperationOutcome; enforce=false skips validation.
 *   3. Op + path validation rejects obviously bad inputs.
 */
class ProfileBasedManipulatorTests {

  private static ValidationEngine engine;

  @BeforeAll
  static void setup() throws Exception {
    engine = TestUtilities.getValidationEngine(
      "hl7.fhir.r4.core#4.0.1",
      FhirSettings.getTxFhirDevelopment(),
      FhirPublication.R4, "4.0.1");
  }

  // ------------------------------------------------------------------
  // Helpers
  // ------------------------------------------------------------------

  /** Single empty data row — generateTestData requires at least one. */
  private static JsonArray oneEmptyRow() {
    JsonArray data = new JsonArray();
    data.add(new JsonObject());
    return data;
  }

  /**
   * Generate a baseline AllergyIntolerance with a coded clinicalStatus, then
   * return the JSON. requiredOnly=true keeps the noise down.
   */
  private static byte[] generateBaselineAllergy() throws Exception {
    JsonArray mappings = new JsonArray();
    JsonObject m1 = new JsonObject();
    m1.add("path", "AllergyIntolerance.clinicalStatus.coding");
    JsonArray parts1 = new JsonArray();
    parts1.add(part("system", "http://terminology.hl7.org/CodeSystem/allergyintolerance-clinical"));
    parts1.add(part("code", "active"));
    m1.add("parts", parts1);
    mappings.add(m1);

    return engine.generateTestData(
      "http://hl7.org/fhir/StructureDefinition/AllergyIntolerance",
      oneEmptyRow(),
      mappings,
      FhirFormat.JSON,
      false,
      true);
  }

  private static byte[] generateBaselinePatient() throws Exception {
    return engine.generateTestData(
      "http://hl7.org/fhir/StructureDefinition/Patient",
      oneEmptyRow(),
      null,
      FhirFormat.JSON,
      false,
      true);
  }

  private static JsonObject manipulateAndParse(byte[] resource, String profile, JsonArray operations,
      boolean enforce) throws Exception {
    ManipulationResult r = engine.manipulateResource(
      resource, FhirFormat.JSON, profile, operations, enforce, FhirFormat.JSON);
    return JsonParser.parseObject(new String(r.getResource(), StandardCharsets.UTF_8));
  }

  private static ManipulationResult manipulate(byte[] resource, String profile, JsonArray operations,
      boolean enforce) throws Exception {
    return engine.manipulateResource(
      resource, FhirFormat.JSON, profile, operations, enforce, FhirFormat.JSON);
  }

  private static JsonObject part(String name, String value) {
    JsonObject p = new JsonObject();
    p.add("name", name);
    p.add("value", value);
    return p;
  }

  private static JsonObject op(String kind, String path) {
    JsonObject o = new JsonObject();
    o.add("op", kind);
    o.add("path", path);
    return o;
  }

  private static JsonObject opWithValue(String kind, String path, String value) {
    JsonObject o = op(kind, path);
    o.add("value", value);
    return o;
  }

  private static JsonObject opWithParts(String kind, String path, JsonObject... parts) {
    JsonObject o = op(kind, path);
    JsonArray arr = new JsonArray();
    for (JsonObject p : parts) arr.add(p);
    o.add("parts", arr);
    return o;
  }

  private static JsonArray ops(JsonObject... entries) {
    JsonArray arr = new JsonArray();
    for (JsonObject e : entries) arr.add(e);
    return arr;
  }

  // ------------------------------------------------------------------
  // set
  // ------------------------------------------------------------------

  @Test
  @DisplayName("set writes a primitive at a top-level path")
  void set_primitiveTopLevel() throws Exception {
    byte[] patient = generateBaselinePatient();
    JsonArray operations = ops(opWithValue("set", "Patient.id", "manip-001"));

    JsonObject result = manipulateAndParse(patient, null, operations, false);

    assertEquals("Patient", result.asString("resourceType"));
    assertEquals("manip-001", result.asString("id"));
  }

  @Test
  @DisplayName("set creates missing intermediate elements via parts")
  void set_createsMissingPathParts() throws Exception {
    byte[] allergy = generateBaselineAllergy();
    // recordedDate is a primitive at top level; targets a missing element.
    JsonArray operations = ops(opWithValue("set", "AllergyIntolerance.recordedDate", "2026-04-01"));

    JsonObject result = manipulateAndParse(allergy, null, operations, false);

    assertEquals("2026-04-01", result.asString("recordedDate"));
  }

  @Test
  @DisplayName("set with parts overwrites the first list entry of a complex element")
  void set_partsOnListFirstEntry() throws Exception {
    byte[] allergy = generateBaselineAllergy();
    // baseline has clinicalStatus.coding[0] = {snomed allergyintolerance-clinical, active}
    // overwrite it via set on the list (no index → first entry)
    JsonArray operations = ops(opWithParts("set", "AllergyIntolerance.clinicalStatus.coding",
      part("system", "http://example.org/cs"),
      part("code", "inactive"),
      part("display", "Inactive")));

    JsonObject result = manipulateAndParse(allergy, null, operations, false);

    JsonArray coding = result.getJsonObject("clinicalStatus").getJsonArray("coding");
    assertEquals(1, coding.size(), "set should not create a new list entry, just overwrite");
    JsonObject c = coding.get(0).asJsonObject();
    assertEquals("http://example.org/cs", c.asString("system"));
    assertEquals("inactive", c.asString("code"));
    assertEquals("Inactive", c.asString("display"));
  }

  @Test
  @DisplayName("set rejects 'value' on a non-primitive element")
  void set_rejectsValueOnComplex() throws Exception {
    byte[] allergy = generateBaselineAllergy();
    JsonArray operations = ops(opWithValue("set", "AllergyIntolerance.code", "not-allowed"));

    Throwable t = assertThrows(Exception.class, () ->
      manipulate(allergy, null, operations, false));
    assertTrue(t.getCause() instanceof FHIRException || t instanceof FHIRException
        || (t.getMessage() != null && t.getMessage().contains("non-primitive")),
      "expected FHIRException about non-primitive; got " + t);
  }

  // ------------------------------------------------------------------
  // add
  // ------------------------------------------------------------------

  @Test
  @DisplayName("add appends a new entry to a list")
  void add_appendsListEntry() throws Exception {
    byte[] allergy = generateBaselineAllergy();
    // baseline has 1 coding under clinicalStatus.coding; add a second
    JsonArray operations = ops(opWithParts("add", "AllergyIntolerance.clinicalStatus.coding",
      part("system", "http://example.org/cs2"),
      part("code", "extra")));

    JsonObject result = manipulateAndParse(allergy, null, operations, false);

    JsonArray coding = result.getJsonObject("clinicalStatus").getJsonArray("coding");
    assertEquals(2, coding.size(), "add should append a new list entry");
    assertEquals("extra", coding.get(1).asJsonObject().asString("code"));
  }

  @Test
  @DisplayName("add rejects an explicit [i] index on the target")
  void add_rejectsExplicitIndex() throws Exception {
    byte[] allergy = generateBaselineAllergy();
    JsonArray operations = ops(opWithParts("add", "AllergyIntolerance.clinicalStatus.coding[0]",
      part("system", "x"), part("code", "y")));

    Throwable t = assertThrows(Exception.class, () ->
      manipulate(allergy, null, operations, false));
    String msg = t.getMessage() != null ? t.getMessage()
      : (t.getCause() != null ? t.getCause().getMessage() : "");
    assertTrue(msg.contains("[i]") || msg.contains("not permitted"),
      "expected error about [i] not permitted on add; got: " + msg);
  }

  @Test
  @DisplayName("add fails when the 0..1 target already has a child")
  void add_failsWhenScalarAlreadyPresent() throws Exception {
    byte[] patient = generateBaselinePatient();
    // First set Patient.id (creating the single allowed entry), then try to
    // add a second one — Element.addElement throws because id is not a list.
    JsonArray operations = ops(
      opWithValue("set", "Patient.id", "first"),
      opWithValue("add", "Patient.id", "second")
    );

    Throwable t = assertThrows(Exception.class, () ->
      manipulate(patient, null, operations, false));
    String msg = t.getMessage() != null ? t.getMessage()
      : (t.getCause() != null ? t.getCause().getMessage() : "");
    assertTrue(msg.contains("not a list") || msg.contains("can't add"),
      "expected error about adding to non-list; got: " + msg);
  }

  // ------------------------------------------------------------------
  // remove
  // ------------------------------------------------------------------

  @Test
  @DisplayName("remove deletes the named element")
  void remove_deletesElement() throws Exception {
    byte[] allergy = generateBaselineAllergy();

    JsonObject before = JsonParser.parseObject(new String(allergy, StandardCharsets.UTF_8));
    assertTrue(before.has("clinicalStatus"), "baseline must have clinicalStatus");

    JsonArray operations = ops(op("remove", "AllergyIntolerance.clinicalStatus"));
    JsonObject result = manipulateAndParse(allergy, null, operations, false);

    assertFalse(result.has("clinicalStatus"), "clinicalStatus should be removed");
  }

  @Test
  @DisplayName("remove with explicit index removes only that entry")
  void remove_singleListEntry() throws Exception {
    byte[] allergy = generateBaselineAllergy();
    // First, add a second coding so we have two entries to choose from
    JsonArray prep = ops(opWithParts("add", "AllergyIntolerance.clinicalStatus.coding",
      part("system", "http://example.org/cs2"),
      part("code", "second")));
    byte[] withTwoCodings = manipulate(allergy, null, prep, false).getResource();
    // sanity
    JsonObject before = JsonParser.parseObject(new String(withTwoCodings, StandardCharsets.UTF_8));
    assertEquals(2, before.getJsonObject("clinicalStatus").getJsonArray("coding").size());

    JsonArray operations = ops(op("remove", "AllergyIntolerance.clinicalStatus.coding[0]"));
    JsonObject result = manipulateAndParse(withTwoCodings, null, operations, false);

    JsonArray coding = result.getJsonObject("clinicalStatus").getJsonArray("coding");
    assertEquals(1, coding.size(), "remove[0] should drop only that entry");
    assertEquals("second", coding.get(0).asJsonObject().asString("code"),
      "the surviving entry should be the second one");
  }

  @Test
  @DisplayName("remove on a missing path is a no-op")
  void remove_missingPathIsNoop() throws Exception {
    byte[] patient = generateBaselinePatient();
    JsonArray operations = ops(op("remove", "Patient.gender")); // not present in baseline
    JsonObject result = manipulateAndParse(patient, null, operations, false);
    assertEquals("Patient", result.asString("resourceType"));
  }

  // ------------------------------------------------------------------
  // multi-op
  // ------------------------------------------------------------------

  @Test
  @DisplayName("multiple ops apply in order")
  void multipleOps_applyInOrder() throws Exception {
    byte[] patient = generateBaselinePatient();
    JsonArray operations = ops(
      opWithValue("set", "Patient.id", "before"),
      opWithValue("set", "Patient.id", "after")
    );

    JsonObject result = manipulateAndParse(patient, null, operations, false);
    assertEquals("after", result.asString("id"));
  }

  // ------------------------------------------------------------------
  // enforcement
  // ------------------------------------------------------------------

  @Test
  @DisplayName("enforce=true returns an OperationOutcome; enforce=false skips validation")
  void enforce_returnsOutcomeOnlyWhenTrue() throws Exception {
    byte[] patient = generateBaselinePatient();
    JsonArray operations = ops(opWithValue("set", "Patient.id", "abc"));

    ManipulationResult enforced = manipulate(patient,
      "http://hl7.org/fhir/StructureDefinition/Patient", operations, true);
    assertNotNull(enforced.getOutcome(), "enforce=true must return an outcome");

    ManipulationResult skipped = manipulate(patient, null, operations, false);
    assertNull(skipped.getOutcome(), "enforce=false must skip validation entirely");
  }

  @Test
  @DisplayName("enforce=true surfaces validation errors when the mutation breaks min cardinality")
  void enforce_flagsConstraintViolation() throws Exception {
    byte[] allergy = generateBaselineAllergy();
    // AllergyIntolerance.patient is min=1 in base FHIR — removing it should error
    JsonArray operations = ops(op("remove", "AllergyIntolerance.patient"));

    ManipulationResult r = manipulate(allergy,
      "http://hl7.org/fhir/StructureDefinition/AllergyIntolerance", operations, true);

    assertNotNull(r.getOutcome(), "enforce=true must return an outcome");
    boolean hasError = false;
    for (org.hl7.fhir.r5.model.OperationOutcome.OperationOutcomeIssueComponent issue
         : r.getOutcome().getIssue()) {
      org.hl7.fhir.r5.model.OperationOutcome.IssueSeverity sev = issue.getSeverity();
      if (sev == org.hl7.fhir.r5.model.OperationOutcome.IssueSeverity.ERROR
          || sev == org.hl7.fhir.r5.model.OperationOutcome.IssueSeverity.FATAL) {
        hasError = true;
        break;
      }
    }
    assertTrue(hasError, "expected at least one error/fatal issue from removing AllergyIntolerance.patient");
  }

  // ------------------------------------------------------------------
  // input validation
  // ------------------------------------------------------------------

  @Test
  @DisplayName("unknown 'op' is rejected")
  void unknownOp_rejected() throws Exception {
    byte[] patient = generateBaselinePatient();
    JsonObject bogus = new JsonObject();
    bogus.add("op", "rotate");
    bogus.add("path", "Patient.id");
    JsonArray operations = ops(bogus);

    Throwable t = assertThrows(Exception.class, () ->
      manipulate(patient, null, operations, false));
    String msg = t.getMessage() != null ? t.getMessage()
      : (t.getCause() != null ? t.getCause().getMessage() : "");
    assertTrue(msg.contains("unknown op") || msg.contains("rotate"),
      "expected error about unknown op; got: " + msg);
  }

  @Test
  @DisplayName("missing 'path' is rejected")
  void missingPath_rejected() throws Exception {
    byte[] patient = generateBaselinePatient();
    JsonObject noPath = new JsonObject();
    noPath.add("op", "set");
    noPath.add("value", "x");
    JsonArray operations = ops(noPath);

    Throwable t = assertThrows(Exception.class, () ->
      manipulate(patient, null, operations, false));
    String msg = t.getMessage() != null ? t.getMessage()
      : (t.getCause() != null ? t.getCause().getMessage() : "");
    assertTrue(msg.contains("missing 'path'"),
      "expected error about missing path; got: " + msg);
  }
}
