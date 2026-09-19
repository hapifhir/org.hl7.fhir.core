package org.hl7.fhir.r5.model;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.elementmodel.JsonParser;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * Tests for the primitive casts in TypeConvertor (castToInteger etc): the same instance when it's
 * already the right type, otherwise a new instance when the value is valid for the type (keeping
 * the id and extensions), and an exception when it isn't
 */
class TypeConvertorPrimitiveTests {

  private static final String EXT_URL = "http://example.org/fhir/StructureDefinition/tc-test";

  private static final Map<String, Function<Base, PrimitiveType<?>>> CASTS = new LinkedHashMap<>();
  static {
    CASTS.put("boolean", TypeConvertor::castToBoolean);
    CASTS.put("integer", TypeConvertor::castToInteger);
    CASTS.put("integer64", TypeConvertor::castToInteger64);
    CASTS.put("decimal", TypeConvertor::castToDecimal);
    CASTS.put("base64Binary", TypeConvertor::castToBase64Binary);
    CASTS.put("instant", TypeConvertor::castToInstant);
    CASTS.put("string", TypeConvertor::castToString);
    CASTS.put("uri", TypeConvertor::castToUri);
    CASTS.put("url", TypeConvertor::castToUrl);
    CASTS.put("uuid", TypeConvertor::castToUuid);
    CASTS.put("canonical", TypeConvertor::castToCanonical);
    CASTS.put("date", TypeConvertor::castToDate);
    CASTS.put("dateTime", TypeConvertor::castToDateTime);
    CASTS.put("time", TypeConvertor::castToTime);
    CASTS.put("code", TypeConvertor::castToCode);
    CASTS.put("oid", TypeConvertor::castToOid);
    CASTS.put("id", TypeConvertor::castToId);
    CASTS.put("unsignedInt", TypeConvertor::castToUnsignedInt);
    CASTS.put("positiveInt", TypeConvertor::castToPositiveInt);
    CASTS.put("markdown", TypeConvertor::castToMarkdown);
  }

  /** type, value, whether the value is valid for the type */
  static Stream<Arguments> values() {
    return Stream.of(
      Arguments.of("boolean", "true", true),
      Arguments.of("boolean", "yes", false),
      Arguments.of("integer", "-42", true),
      Arguments.of("integer", "4.2", false),
      Arguments.of("integer", "2147483648", false),
      Arguments.of("integer", "-2147483649", false),
      Arguments.of("integer64", "9007199254740993", true),
      Arguments.of("integer64", "x", false),
      Arguments.of("decimal", "1.50", true),
      Arguments.of("decimal", "abc", false),
      Arguments.of("base64Binary", "SGVsbG8=", true),
      Arguments.of("base64Binary", "not base64!", false),
      Arguments.of("instant", "2026-09-19T10:15:30.123Z", true),
      Arguments.of("instant", "yesterday", false),
      Arguments.of("string", "anything at all", true),
      Arguments.of("uri", "http://example.org/fhir", true),
      Arguments.of("uri", "not a uri", false),
      Arguments.of("url", "https://example.org/page.html", true),
      Arguments.of("url", "not a url", false),
      Arguments.of("uuid", "urn:uuid:c757873d-ec9a-4326-a141-556f43239520", true),
      Arguments.of("uuid", "c757873d-ec9a-4326-a141-556f43239520", false),
      Arguments.of("canonical", "http://example.org/fhir/StructureDefinition/x|1.0", true),
      Arguments.of("canonical", "not canonical", false),
      Arguments.of("date", "2026-09-19", true),
      Arguments.of("date", "19/09/2026", false),
      Arguments.of("dateTime", "2026-09-19T10:15:30+10:00", true),
      Arguments.of("dateTime", "2026-09-19", true),
      Arguments.of("dateTime", "tomorrow", false),
      Arguments.of("time", "10:15:30", true),
      Arguments.of("time", "25:00:00", false),
      Arguments.of("code", "active", true),
      Arguments.of("code", " active", false),
      Arguments.of("oid", "urn:oid:1.2.36.146.595.217.0.1", true),
      Arguments.of("oid", "1.2.36", false),
      Arguments.of("id", "a-1.b", true),
      Arguments.of("id", "a_1", false),
      Arguments.of("unsignedInt", "0", true),
      Arguments.of("unsignedInt", "-1", false),
      Arguments.of("positiveInt", "1", true),
      Arguments.of("positiveInt", "0", false),
      Arguments.of("markdown", "Some **bold** text", true)
    );
  }

  static Stream<String> types() {
    return CASTS.keySet().stream();
  }

  private static StringType source(String value) {
    StringType s = new StringType(value);
    s.setId("p1");
    s.addExtension(EXT_URL, new StringType("extension value"));
    return s;
  }

  @ParameterizedTest(name = "{0} ''{1}''")
  @MethodSource("values")
  void testConvertFromString(String type, String value, boolean valid) {
    StringType src = source(value);
    if (valid) {
      PrimitiveType<?> result = CASTS.get(type).apply(src);
      Assertions.assertEquals(type, result.fhirType());
      Assertions.assertEquals(value, result.primitiveValue());
      Assertions.assertEquals("p1", result.getId());
      Assertions.assertEquals(1, result.getExtension().size());
      Assertions.assertEquals(EXT_URL, result.getExtension().get(0).getUrl());
      if (!"string".equals(type)) {
        Assertions.assertNotSame(src, result);
        Assertions.assertNotSame(src.getExtension().get(0), result.getExtension().get(0), "extensions must be copied, not shared");
      }
    } else {
      FHIRException e = Assertions.assertThrows(FHIRException.class, () -> CASTS.get(type).apply(src));
      Assertions.assertTrue(e.getMessage().contains("'" + value + "'"), e.getMessage());
    }
  }

  @ParameterizedTest(name = "{0}")
  @MethodSource("types")
  void testNull(String type) {
    Assertions.assertNull(CASTS.get(type).apply(null));
  }

  @ParameterizedTest(name = "{0}")
  @MethodSource("types")
  void testSameType(String type) {
    PrimitiveType<?> p = (PrimitiveType<?>) new Factory().create(type);
    Assertions.assertSame(p, CASTS.get(type).apply(p));
  }

  @ParameterizedTest(name = "{0}")
  @MethodSource("types")
  void testNoValue(String type) {
    // a primitive with only an id and extensions can be any type
    StringType src = source(null);
    PrimitiveType<?> result = CASTS.get(type).apply(src);
    Assertions.assertEquals(type, result.fhirType());
    Assertions.assertFalse(result.hasValue());
    Assertions.assertEquals("p1", result.getId());
    Assertions.assertEquals(1, result.getExtension().size());
  }

  @ParameterizedTest(name = "{0}")
  @MethodSource("types")
  void testNotPrimitive(String type) {
    Coding c = new Coding("http://example.org/fhir/CodeSystem/test", "c1", null);
    Assertions.assertThrows(FHIRException.class, () -> CASTS.get(type).apply(c));
  }

  @Test
  void testElementModel() throws Exception {
    Element wrapper = new JsonParser(TestingUtilities.getSharedWorkerContext())
      .parse("{\"value\":\"42\",\"_value\":{\"id\":\"p1\",\"extension\":[{\"url\":\"" + EXT_URL + "\",\"valueString\":\"x\"}]}}", "string", true);
    Element e = wrapper.getNamedChild("value", false);
    IntegerType i = TypeConvertor.castToInteger(e);
    Assertions.assertEquals(42, i.getValue());
    Assertions.assertEquals("p1", i.getId());
    Assertions.assertEquals(EXT_URL, i.getExtension().get(0).getUrl());

    // and when the element model node is already the right type
    Element wrapper2 = new JsonParser(TestingUtilities.getSharedWorkerContext()).parse("{\"value\":42}", "integer", true);
    Assertions.assertEquals(42, TypeConvertor.castToInteger(wrapper2.getNamedChild("value", false)).getValue());
  }
}
