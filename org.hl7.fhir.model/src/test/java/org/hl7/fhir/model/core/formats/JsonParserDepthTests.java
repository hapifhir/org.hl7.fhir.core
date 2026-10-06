package org.hl7.fhir.model.core.formats;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.hl7.fhir.exceptions.FHIRFormatError;
import org.hl7.fhir.model.ModelContext;
import org.hl7.fhir.model.core.Patient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class JsonParserDepthTests {

  private static String nestedExtensions(int depth) {
    StringBuilder b = new StringBuilder("{\"resourceType\":\"Patient\",\"extension\":[");
    b.append("{\"url\":\"http://example.org/u\",\"extension\":[".repeat(Math.max(0, depth)));
    b.append("{\"url\":\"http://example.org/u\",\"valueBoolean\":true}");
    b.append("]}".repeat(Math.max(0, depth)));
    b.append("]}");
    return b.toString();
  }

  private static String nestedParts(int depth) {
    StringBuilder b = new StringBuilder("{\"resourceType\":\"Parameters\",\"parameter\":[");
    b.append("{\"name\":\"p\",\"part\":[".repeat(Math.max(0, depth)));
    b.append("{\"name\":\"p\"}");
    b.append("]}".repeat(Math.max(0, depth)));
    b.append("]}");
    return b.toString();
  }

  private static String nestedResources(int depth) {
    StringBuilder b = new StringBuilder("{\"resourceType\":\"Parameters\",\"parameter\":[");
    b.append("{\"name\":\"p\",\"resource\":{\"resourceType\":\"Parameters\",\"parameter\":[".repeat(Math.max(0, depth)));
    b.append("{\"name\":\"p\"}");
    b.append("]}}".repeat(Math.max(0, depth)));
    b.append("]}");
    return b.toString();
  }

  private static Object parse(String json) throws IOException, FHIRFormatError {
    return new JsonParser(ModelContext.minimalContext(), true)
        .parse(new ByteArrayInputStream(json.getBytes(StandardCharsets.UTF_8)));
  }

  // Extension.extension may nest without limit in valid FHIR. Each level is an object inside a
  // "extension" array, so this exercises both readObject -> readArray and readArray -> readObject
  // in JsonTrackingParser. Deep nesting must fail with an IOException from the parser rather than
  // an uncaught StackOverflowError.
  @ParameterizedTest
  @ValueSource(ints = {600, 5000, 50000})
  void testDeeplyNestedExtensionsFailCleanly(int depth) {
    Assertions.assertThrowsExactly(IOException.class, () -> parse(nestedExtensions(depth)));
  }

  // Same gap through a BackboneElement (Parameters.parameter.part), so the limit is not
  // extension-specific.
  @Test
  void testDeeplyNestedPartsFailCleanly() {
    Assertions.assertThrowsExactly(IOException.class, () -> parse(nestedParts(50000)));
  }

  // Same gap through contained resources (Parameters.parameter.resource nesting Parameters).
  @Test
  void testDeeplyNestedResourcesFailCleanly() {
    Assertions.assertThrowsExactly(IOException.class, () -> parse(nestedResources(50000)));
  }

  // Nesting comfortably below the limit must still parse, guarding against the cap being too tight.
  @Test
  void testModeratelyNestedExtensionsStillParse() throws IOException, FHIRFormatError {
    Patient p = (Patient) parse(nestedExtensions(100));
    Assertions.assertEquals(1, p.getExtensionList().size());
  }
}
