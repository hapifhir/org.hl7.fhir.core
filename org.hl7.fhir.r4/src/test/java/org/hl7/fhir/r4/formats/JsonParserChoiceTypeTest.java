package org.hl7.fhir.r4.formats;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import org.hl7.fhir.r4.model.CodeType;
import org.hl7.fhir.r4.model.ElementDefinition;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Quantity;
import org.hl7.fhir.r4.model.StringType;
import org.hl7.fhir.r4.model.StructureDefinition;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

class JsonParserChoiceTypeTest {

  private static org.hl7.fhir.r4.formats.JsonParser parser() {
    return new org.hl7.fhir.r4.formats.JsonParser();
  }

  @Test
  void choiceTypeWithValue() throws IOException {
    Observation obs = (Observation) parser().parse("{\"resourceType\":\"Observation\",\"status\":\"final\",\"code\":{\"text\":\"x\"},\"valueQuantity\":{\"value\":3,\"unit\":\"mg\"}}");
    assertTrue(obs.getValue() instanceof Quantity);
    assertEquals("mg", obs.getValueQuantity().getUnit());
  }

  @Test
  void choiceTypeAbsent() throws IOException {
    Observation obs = (Observation) parser().parse("{\"resourceType\":\"Observation\",\"status\":\"final\",\"code\":{\"text\":\"x\"}}");
    assertNull(obs.getValue());
  }

  @Test
  void primitiveChoiceWithOnlyExtension() throws IOException {
    Extension ext = (Extension) parser().parseType("{\"url\":\"http://example.org/ext\",\"_valueCode\":{\"extension\":[{\"url\":\"http://hl7.org/fhir/StructureDefinition/data-absent-reason\",\"valueCode\":\"unknown\"}]}}", "Extension");
    assertTrue(ext.getValue() instanceof CodeType);
    assertFalse(ext.getValue().hasPrimitiveValue());
    assertEquals("unknown", ((CodeType) ext.getValue().getExtensionFirstRep().getValue()).getValue());
  }

  @Test
  void elementDefinitionChoiceTypes() throws IOException {
    StructureDefinition sd = (StructureDefinition) parser().parse("{\"resourceType\":\"StructureDefinition\",\"url\":\"http://example.org/sd\",\"name\":\"X\",\"status\":\"draft\",\"kind\":\"resource\",\"abstract\":false,\"type\":\"Observation\","
        + "\"differential\":{\"element\":[{\"path\":\"Observation\"},{\"path\":\"Observation.status\",\"fixedCode\":\"final\",\"min\":1},{\"path\":\"Observation.code\",\"defaultValueString\":\"d\",\"patternString\":\"p\"}]}}");
    ElementDefinition root = sd.getDifferential().getElement().get(0);
    assertNull(root.getFixed());
    assertNull(root.getPattern());
    assertNull(root.getDefaultValue());
    assertNull(root.getMinValue());
    assertNull(root.getMaxValue());
    ElementDefinition status = sd.getDifferential().getElement().get(1);
    assertEquals("final", ((CodeType) status.getFixed()).getValue());
    assertNull(status.getPattern());
    ElementDefinition code = sd.getDifferential().getElement().get(2);
    assertEquals("d", ((StringType) code.getDefaultValue()).getValue());
    assertEquals("p", ((StringType) code.getPattern()).getValue());
  }

  @Test
  void propertyNamedExactlyThePrefixIsNotAType() throws IOException {
    JsonObject json = JsonParser.parseString("{\"value\":\"x\"}").getAsJsonObject();
    assertNull(parser().parseType("value", json));
    assertFalse(parser().hasTypeName(json, "value"));
  }

  @ParameterizedTest
  @CsvSource(delimiter = '|', value = {
    "{\"valueString\":\"x\"}|true",
    "{\"_valueString\":{}}|true",
    "{\"url\":\"x\"}|false",
    "{\"valueNotAType\":\"x\"}|false"
  })
  void hasTypeName(String json, boolean expected) {
    assertEquals(expected, parser().hasTypeName(JsonParser.parseString(json).getAsJsonObject(), "value"));
  }
}
