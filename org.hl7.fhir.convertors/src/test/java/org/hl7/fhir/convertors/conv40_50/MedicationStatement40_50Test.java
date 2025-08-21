package org.hl7.fhir.convertors.conv40_50;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.hl7.fhir.convertors.factory.VersionConvertorFactory_40_50;
import org.hl7.fhir.r4.model.MedicationStatement;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MedicationStatement40_50Test {

  @Test
  @DisplayName("Test R4 -> R5 -> R4 MedicationStatement round-trip conversion")
  public void testR4_R5_R4_RoundTrip() throws IOException {
    InputStream testInput = this.getClass().getResourceAsStream("/medication-statement-tests.json");
    ObjectMapper mapper = new ObjectMapper();
    JsonNode testData = mapper.readTree(testInput);

    JsonNode r4Resources = testData.get("r4_resources");

    for (JsonNode r4Json : r4Resources) {
      String originalStatus = r4Json.get("status").asText();
      String resourceId = r4Json.get("id").asText();

      // Parse R4 resource
      org.hl7.fhir.r4.model.MedicationStatement r4_original =
        (org.hl7.fhir.r4.model.MedicationStatement) new org.hl7.fhir.r4.formats.JsonParser().parse(r4Json.toString());

      // Convert R4 -> R5
      org.hl7.fhir.r5.model.Resource r5_conv = VersionConvertorFactory_40_50.convertResource(r4_original);

      // Serialize and deserialize R5 to ensure serialization works
      org.hl7.fhir.r5.formats.JsonParser r5_parser = new org.hl7.fhir.r5.formats.JsonParser();
      ByteArrayOutputStream stream = new ByteArrayOutputStream();
      r5_parser.compose(stream, r5_conv);

      org.hl7.fhir.r5.model.Resource r5_streamed =
        new org.hl7.fhir.r5.formats.JsonParser().parse(new ByteArrayInputStream(stream.toByteArray()));

      // Convert R5 -> R4
      org.hl7.fhir.r4.model.Resource r4_final = VersionConvertorFactory_40_50.convertResource(r5_streamed);
      org.hl7.fhir.r4.model.MedicationStatement r4_final_typed = (org.hl7.fhir.r4.model.MedicationStatement) r4_final;

      String finalStatus = r4_final_typed.getStatus().toCode();

      // Status should be preserved through round-trip conversion
      assertEquals(originalStatus, finalStatus,
        String.format("Status should be preserved for %s (%s) after R4->R5->R4 conversion", originalStatus, resourceId));

      // Full resource should be equal after round-trip
      assertTrue(r4_original.equalsDeep(r4_final_typed),
        String.format("R4 MedicationStatement %s should be identical after round-trip conversion", resourceId));
    }
  }

  @Test
  @DisplayName("Test R5 -> R4 -> R5 MedicationStatement round-trip conversion")
  public void testR5_R4_R5_RoundTrip() throws IOException {
    InputStream testInput = this.getClass().getResourceAsStream("/medication-statement-tests.json");
    ObjectMapper mapper = new ObjectMapper();
    JsonNode testData = mapper.readTree(testInput);

    JsonNode r5Resources = testData.get("r5_resources");

    for (JsonNode r5Json : r5Resources) {
      String originalStatus = r5Json.get("status").asText();
      String resourceId = r5Json.get("id").asText();

      // Parse R5 resource
      org.hl7.fhir.r5.model.MedicationStatement r5_original =
        (org.hl7.fhir.r5.model.MedicationStatement) new org.hl7.fhir.r5.formats.JsonParser().parse(r5Json.toString());

      // Convert R5 -> R4
      org.hl7.fhir.r4.model.Resource r4_conv = VersionConvertorFactory_40_50.convertResource(r5_original);

      // Serialize and deserialize R4 to ensure serialization works
      org.hl7.fhir.r4.formats.JsonParser r4_parser = new org.hl7.fhir.r4.formats.JsonParser();
      ByteArrayOutputStream stream = new ByteArrayOutputStream();
      r4_parser.compose(stream, r4_conv);

      org.hl7.fhir.r4.model.Resource r4_streamed =
        new org.hl7.fhir.r4.formats.JsonParser().parse(new ByteArrayInputStream(stream.toByteArray()));

      // Convert R4 -> R5
      org.hl7.fhir.r5.model.Resource r5_final = VersionConvertorFactory_40_50.convertResource(r4_streamed);
      org.hl7.fhir.r5.model.MedicationStatement r5_final_typed = (org.hl7.fhir.r5.model.MedicationStatement) r5_final;

      String finalStatus = r5_final_typed.getStatus().toCode();

      // Status should be preserved through round-trip conversion
      assertEquals(originalStatus, finalStatus,
        String.format("Status should be preserved for %s (%s) after R5->R4->R5 conversion", originalStatus, resourceId));

      // Full resource should be equal after round-trip
      assertTrue(r5_original.equalsDeep(r5_final_typed),
        String.format("R5 MedicationStatement %s should be identical after round-trip conversion", resourceId));
    }
  }

  @ParameterizedTest
  @ValueSource(strings = {"active", "completed", "entered-in-error", "intended", "stopped", "on-hold", "unknown", "not-taken"})
  @DisplayName("Test each R4 status code round-trip conversion")
  public void testIndividualR4StatusRoundTrip(String statusCode) throws IOException {
    InputStream testInput = this.getClass().getResourceAsStream("/medication-statement-tests.json");
    ObjectMapper mapper = new ObjectMapper();
    JsonNode testData = mapper.readTree(testInput);

    JsonNode r4Resources = testData.get("r4_resources");

    for (JsonNode r4Json : r4Resources) {
      if (r4Json.get("status").asText().equals(statusCode)) {

        org.hl7.fhir.r4.model.MedicationStatement r4_original =
          (org.hl7.fhir.r4.model.MedicationStatement) new org.hl7.fhir.r4.formats.JsonParser().parse(r4Json.toString());

        // R4 -> R5 -> R4
        org.hl7.fhir.r5.model.Resource r5_conv = VersionConvertorFactory_40_50.convertResource(r4_original);
        org.hl7.fhir.r4.model.Resource r4_final = VersionConvertorFactory_40_50.convertResource(r5_conv);
        org.hl7.fhir.r4.model.MedicationStatement r4_final_typed = (org.hl7.fhir.r4.model.MedicationStatement) r4_final;

        // Status must be preserved
        assertEquals(statusCode, r4_final_typed.getStatus().toCode(),
          String.format("R4 status '%s' must be preserved through round-trip conversion", statusCode));

        // Full resource must be equal
        assertTrue(r4_original.equalsDeep(r4_final_typed),
          String.format("R4 MedicationStatement with status '%s' must round-trip successfully", statusCode));

        break;
      }
    }
  }

  @ParameterizedTest
  @ValueSource(strings = {"recorded", "entered-in-error", "draft"})
  @DisplayName("Test each R5 status code round-trip conversion")
  public void testIndividualR5StatusRoundTrip(String statusCode) throws IOException {
    InputStream testInput = this.getClass().getResourceAsStream("/medication-statement-tests.json");
    ObjectMapper mapper = new ObjectMapper();
    JsonNode testData = mapper.readTree(testInput);

    JsonNode r5Resources = testData.get("r5_resources");

    for (JsonNode r5Json : r5Resources) {
      if (r5Json.get("status").asText().equals(statusCode)) {

        org.hl7.fhir.r5.model.MedicationStatement r5_original =
          (org.hl7.fhir.r5.model.MedicationStatement) new org.hl7.fhir.r5.formats.JsonParser().parse(r5Json.toString());

        // R5 -> R4 -> R5
        org.hl7.fhir.r4.model.Resource r4_conv = VersionConvertorFactory_40_50.convertResource(r5_original);
        org.hl7.fhir.r5.model.Resource r5_final = VersionConvertorFactory_40_50.convertResource(r4_conv);
        org.hl7.fhir.r5.model.MedicationStatement r5_final_typed = (org.hl7.fhir.r5.model.MedicationStatement) r5_final;

        // Status must be preserved
        assertEquals(statusCode, r5_final_typed.getStatus().toCode(),
          String.format("R5 status '%s' must be preserved through round-trip conversion", statusCode));

        // Full resource must be equal
        assertTrue(r5_original.getStatusElement().equalsDeep(r5_final_typed.getStatusElement()),
          String.format("R5 MedicationStatement with status '%s' must round-trip successfully", statusCode));

        break;
      }
    }
  }

  @Test
  @DisplayName("Test medication field conversion consistency")
  public void testMedicationFieldConsistency() throws IOException {
    InputStream testInput = this.getClass().getResourceAsStream("/medication-statement-tests.json");
    ObjectMapper mapper = new ObjectMapper();
    JsonNode testData = mapper.readTree(testInput);

    // Test R4 medicationCodeableConcept -> R5 medication.concept -> R4 medicationCodeableConcept
    JsonNode r4Resources = testData.get("r4_resources");
    for (JsonNode r4Json : r4Resources) {

      org.hl7.fhir.r4.model.MedicationStatement r4_original =
        (org.hl7.fhir.r4.model.MedicationStatement) new org.hl7.fhir.r4.formats.JsonParser().parse(r4Json.toString());

      String originalMedicationText = r4_original.getMedicationCodeableConcept().getText();

      // R4 -> R5 -> R4
      org.hl7.fhir.r5.model.Resource r5_conv = VersionConvertorFactory_40_50.convertResource(r4_original);
      org.hl7.fhir.r4.model.Resource r4_final = VersionConvertorFactory_40_50.convertResource(r5_conv);
      org.hl7.fhir.r4.model.MedicationStatement r4_final_typed = (org.hl7.fhir.r4.model.MedicationStatement) r4_final;

      String finalMedicationText = r4_final_typed.getMedicationCodeableConcept().getText();

      assertEquals(originalMedicationText, finalMedicationText,
        "Medication text should be preserved through R4->R5->R4 conversion");
    }

    // Test R5 medication.concept -> R4 medicationCodeableConcept -> R5 medication.concept
    JsonNode r5Resources = testData.get("r5_resources");
    for (JsonNode r5Json : r5Resources) {

      org.hl7.fhir.r5.model.MedicationStatement r5_original =
        (org.hl7.fhir.r5.model.MedicationStatement) new org.hl7.fhir.r5.formats.JsonParser().parse(r5Json.toString());

      String originalMedicationText = r5_original.getMedication().getConcept().getText();

      // R5 -> R4 -> R5
      org.hl7.fhir.r4.model.Resource r4_conv = VersionConvertorFactory_40_50.convertResource(r5_original);
      org.hl7.fhir.r5.model.Resource r5_final = VersionConvertorFactory_40_50.convertResource(r4_conv);
      org.hl7.fhir.r5.model.MedicationStatement r5_final_typed = (org.hl7.fhir.r5.model.MedicationStatement) r5_final;

      String finalMedicationText = r5_final_typed.getMedication().getConcept().getText();

      assertEquals(originalMedicationText, finalMedicationText,
        "Medication text should be preserved through R5->R4->R5 conversion");
    }
  }
}