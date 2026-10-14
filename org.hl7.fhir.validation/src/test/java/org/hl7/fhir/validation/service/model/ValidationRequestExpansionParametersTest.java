package org.hl7.fhir.validation.service.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Stream;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * The wire format of ValidationRequest is consumed out of this repository, by the validator-wrapper and its callers.
 * These tests pin the expansionParameters field to the property name those callers use, under both serializers.
 */
class ValidationRequestExpansionParametersTest {

  interface Serializer {
    String toJson(ValidationRequest request);
    ValidationRequest fromJson(String json);
  }

  static Serializer jackson() {
    ObjectMapper mapper = new ObjectMapper();
    return new Serializer() {
      @Override
      public String toJson(ValidationRequest request) {
        try {
          return mapper.writeValueAsString(request);
        } catch (Exception e) {
          throw new IllegalStateException(e);
        }
      }

      @Override
      public ValidationRequest fromJson(String json) {
        try {
          return mapper.readValue(json, ValidationRequest.class);
        } catch (Exception e) {
          throw new IllegalStateException(e);
        }
      }
    };
  }

  static Serializer gson() {
    Gson gson = new Gson();
    return new Serializer() {
      @Override
      public String toJson(ValidationRequest request) {
        return gson.toJson(request);
      }

      @Override
      public ValidationRequest fromJson(String json) {
        return gson.fromJson(json, ValidationRequest.class);
      }
    };
  }

  static Stream<Arguments> serializers() {
    return Stream.of(
      Arguments.of("jackson", jackson()),
      Arguments.of("gson", gson())
    );
  }

  @DisplayName("Expansion parameters survive a serialization round trip")
  @ParameterizedTest(name = "{0}")
  @MethodSource("serializers")
  void roundTripsExpansionParameters(String description, Serializer serializer) {
    ValidationRequest request = new ValidationRequest()
      .setExpansionParameters(new FileInfo("exp-params.json", "{\"resourceType\":\"Parameters\"}", "json"));

    String json = serializer.toJson(request);
    assertTrue(json.contains("\"expansionParameters\""), json);

    FileInfo roundTripped = serializer.fromJson(json).getExpansionParameters();
    assertNotNull(roundTripped);
    assertEquals("exp-params.json", roundTripped.getFileName());
    assertEquals("{\"resourceType\":\"Parameters\"}", roundTripped.getFileContent());
    assertEquals("json", roundTripped.getFileType());
  }

  @DisplayName("Payloads that predate the expansion parameters field still deserialize")
  @ParameterizedTest(name = "{0}")
  @MethodSource("serializers")
  void deserializesPayloadWithoutExpansionParameters(String description, Serializer serializer) {
    String json = "{\"filesToValidate\":[{\"fileName\":\"a.json\",\"fileContent\":\"{}\",\"fileType\":\"json\"}]}";

    ValidationRequest request = serializer.fromJson(json);

    assertNull(request.getExpansionParameters());
    assertEquals(1, request.getFilesToValidate().size());
  }
}
