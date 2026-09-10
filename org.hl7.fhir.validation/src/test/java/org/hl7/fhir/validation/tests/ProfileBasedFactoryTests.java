package org.hl7.fhir.validation.tests;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.utilities.FhirPublication;
import org.hl7.fhir.utilities.json.model.JsonArray;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.parser.JsonParser;
import org.hl7.fhir.utilities.settings.FhirSettings;
import org.hl7.fhir.validation.ValidationEngine;
import org.hl7.fhir.validation.tests.utilities.TestUtilities;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Exercises how {@link org.hl7.fhir.r5.testfactory.ProfileBasedFactory} sources primitive
 * values for generated test data, through {@link ValidationEngine#generateTestData}.
 *
 * A mapping entry, or one of its parts, may carry a literal {@code value} instead of a
 * FHIRPath {@code expression}. The literal is used as-is, which avoids having to quote a
 * constant as a FHIRPath string.
 *
 * Note: generateTestData() downloads the FHIR base test-data SQLite file (~30MB) on first
 * invocation. Subsequent runs reuse the cached copy.
 */
class ProfileBasedFactoryTests {

  private static final String PATIENT = "http://hl7.org/fhir/StructureDefinition/Patient";

  private static ValidationEngine engine;

  @BeforeAll
  static void setup() throws Exception {
    engine = TestUtilities.getValidationEngine(
      "hl7.fhir.r4.core#4.0.1",
      FhirSettings.getTxFhirDevelopment(),
      FhirPublication.R4, "4.0.1");
  }

  /** Single empty data row - generation needs at least one row to iterate. */
  private static JsonArray oneEmptyRow() {
    JsonArray data = new JsonArray();
    data.add(new JsonObject());
    return data;
  }

  private static JsonObject generate(String profileUrl, JsonArray mappings) throws Exception {
    byte[] bytes = engine.generateTestData(profileUrl, oneEmptyRow(), mappings, FhirFormat.JSON, false);
    return JsonParser.parseObject(new String(bytes, StandardCharsets.UTF_8));
  }

  private static JsonObject mapping(String path) {
    JsonObject m = new JsonObject();
    m.add("path", path);
    return m;
  }

  private static JsonObject part(String name, String value) {
    JsonObject p = new JsonObject();
    p.add("name", name);
    p.add("value", value);
    return p;
  }

  @Test
  @DisplayName("A mapping with a literal 'value' populates a primitive without FHIRPath")
  void mapping_literalValue_primitive() throws Exception {
    JsonArray mappings = new JsonArray();
    JsonObject m = mapping("Patient.id");
    m.add("value", "patient-001");
    mappings.add(m);

    JsonObject patient = generate(PATIENT, mappings);

    assertEquals("patient-001", patient.asString("id"),
      "the literal 'value' should be used as-is");
  }

  @Test
  @DisplayName("Mapping parts accept literal 'value' fields alongside 'name'")
  void mapping_literalValue_parts() throws Exception {
    JsonArray mappings = new JsonArray();
    JsonObject m = mapping("Patient.identifier");
    JsonArray parts = new JsonArray();
    parts.add(part("system", "http://example.org/mrn"));
    parts.add(part("value", "12345"));
    m.add("parts", parts);
    mappings.add(m);

    JsonObject patient = generate(PATIENT, mappings);

    JsonArray identifiers = patient.getJsonArray("identifier");
    assertTrue(identifiers != null && identifiers.size() > 0, "Patient.identifier should be generated");
    JsonObject first = identifiers.get(0).asJsonObject();
    assertEquals("http://example.org/mrn", first.asString("system"));
    assertEquals("12345", first.asString("value"));
  }

  @Test
  @DisplayName("A base64Binary element rejects a non-Base64 value and falls back to a valid one")
  void base64Binary_invalidValueIsReplaced() throws Exception {
    JsonArray mappings = new JsonArray();
    JsonObject m = mapping("Patient.photo.data");
    m.add("value", "not valid base64!!");
    mappings.add(m);

    JsonObject patient = generate(PATIENT, mappings);

    JsonArray photo = patient.getJsonArray("photo");
    assertTrue(photo != null && photo.size() > 0, "Patient.photo should be generated");
    String data = photo.get(0).asJsonObject().asString("data");
    assertNotNull(data, "photo.data should be populated");
    assertNotEquals("not valid base64!!", data, "the invalid literal must not be written through");
    // must be decodable - the generated fallback value, not the rejected literal
    assertDoesNotThrow(() -> Base64.getDecoder().decode(data.replace("\r", "").replace("\n", "")),
      "photo.data should be valid Base64");
  }
}
