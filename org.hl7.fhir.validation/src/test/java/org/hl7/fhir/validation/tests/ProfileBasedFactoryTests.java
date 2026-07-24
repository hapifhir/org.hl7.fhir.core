package org.hl7.fhir.validation.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.charset.StandardCharsets;

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
 * Exercises the requiredOnly + mappings features of ProfileBasedFactory through
 * ValidationEngine.generateTestData() — the same entry point used by the ITB
 * REST API (/itb/testdata) and the validator CLI.
 *
 * Tests target two related additions:
 *   1. requiredOnly mode (skip optional elements at resource top level)
 *   2. mapping entries / parts accepting a literal "value" alongside "expression"
 *
 * Note: generateTestData() downloads the FHIR base test-data SQLite file
 * (~30MB) on first invocation. Subsequent runs reuse the cached copy.
 */
class ProfileBasedFactoryTests {

  private static ValidationEngine engine;

  @BeforeAll
  static void setup() throws Exception {
    engine = TestUtilities.getValidationEngine(
      "hl7.fhir.r4.core#4.0.1",
      FhirSettings.getTxFhirDevelopment(),
      FhirPublication.R4, "4.0.1");
  }

  private static JsonObject generate(String profileUrl, JsonArray mappings, boolean requiredOnly) throws Exception {
    byte[] bytes = engine.generateTestData(
      profileUrl,
      new JsonArray(),
      mappings,
      FhirFormat.JSON,
      false,
      requiredOnly);
    return JsonParser.parseObject(new String(bytes, StandardCharsets.UTF_8));
  }

  @Test
  @DisplayName("requiredOnly skips optional elements at the resource top level")
  void requiredOnly_skipsOptionalElements() throws Exception {
    JsonObject patient = generate(
      "http://hl7.org/fhir/StructureDefinition/Patient", null, true);

    assertEquals("Patient", patient.asString("resourceType"));
    // Patient has no required fields beyond resourceType — none of these should appear
    assertFalse(patient.has("photo"),      "photo (optional) should be skipped");
    assertFalse(patient.has("identifier"), "identifier (optional) should be skipped");
    assertFalse(patient.has("name"),       "name (optional) should be skipped");
    assertFalse(patient.has("telecom"),    "telecom (optional) should be skipped");
  }

  @Test
  @DisplayName("requiredOnly populates required elements (AllergyIntolerance.patient)")
  void requiredOnly_populatesRequiredReference() throws Exception {
    JsonObject allergy = generate(
      "http://hl7.org/fhir/StructureDefinition/AllergyIntolerance", null, true);

    assertEquals("AllergyIntolerance", allergy.asString("resourceType"));
    // AllergyIntolerance.patient is min=1 in base FHIR — must be populated
    assertTrue(allergy.has("patient"), "patient (min=1) must be populated");
    assertNotNull(allergy.getJsonObject("patient").asString("reference"),
      "patient.reference must be set (Reference required-children fix)");
  }

  @Test
  @DisplayName("Mapping with literal 'value' field populates a primitive without FHIRPath")
  void mapping_literalValue_primitive() throws Exception {
    JsonArray mappings = new JsonArray();
    JsonObject m = new JsonObject();
    m.add("path", "Patient.id");
    m.add("value", "patient-001"); // literal string — no FHIRPath quoting needed
    mappings.add(m);

    JsonObject patient = generate(
      "http://hl7.org/fhir/StructureDefinition/Patient", mappings, true);

    assertEquals("patient-001", patient.asString("id"),
      "literal 'value' field should be used as-is");
  }

  @Test
  @DisplayName("Mapping with descendant path keeps the optional parent element")
  void mapping_descendant_keepsOptionalParent() throws Exception {
    // AllergyIntolerance.clinicalStatus is min=0 in base FHIR — would be skipped
    // by requiredOnly. The mapping targets clinicalStatus.coding (a descendant)
    // so the parent CodeableConcept must be generated.
    JsonArray mappings = new JsonArray();
    JsonObject m = new JsonObject();
    m.add("path", "AllergyIntolerance.clinicalStatus.coding");
    JsonArray parts = new JsonArray();
    parts.add(part("system", "http://terminology.hl7.org/CodeSystem/allergyintolerance-clinical"));
    parts.add(part("code", "active"));
    m.add("parts", parts);
    mappings.add(m);

    JsonObject allergy = generate(
      "http://hl7.org/fhir/StructureDefinition/AllergyIntolerance", mappings, true);

    assertTrue(allergy.has("clinicalStatus"),
      "clinicalStatus should be generated because the mapping targets a descendant path");

    JsonArray coding = allergy.getJsonObject("clinicalStatus").getJsonArray("coding");
    assertTrue(coding.size() > 0, "clinicalStatus.coding must have at least one entry");
    JsonObject c = coding.get(0).asJsonObject();
    assertEquals("http://terminology.hl7.org/CodeSystem/allergyintolerance-clinical",
      c.asString("system"));
    assertEquals("active", c.asString("code"));
  }

  private static JsonObject part(String name, String value) {
    JsonObject p = new JsonObject();
    p.add("name", name);
    p.add("value", value); // literal value field — no FHIRPath evaluation
    return p;
  }
}
