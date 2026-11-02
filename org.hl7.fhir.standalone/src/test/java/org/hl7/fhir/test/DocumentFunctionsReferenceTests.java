package org.hl7.fhir.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.hl7.fhir.model.Base;
import org.hl7.fhir.model.utilities.formats.FhirFormat;
import org.hl7.fhir.services.elementmodel.Manager;
import org.hl7.fhir.services.fhirpath.FHIRPathEngine;
import org.hl7.fhir.standalone.context.SimpleWorkerContext;
import org.hl7.fhir.standalone.testing.TestingUtilities;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * How entry() resolves a section's references in a document: the way the validator resolves references
 * in a Bundle (BaseValidator.resolveInBundle), from R4 on. The document's Composition has a RESTful
 * fullUrl, so relative references are resolved against its base.
 */
class DocumentFunctionsReferenceTests {

  private static final String DOCUMENT = "{\"resourceType\": \"Bundle\", \"type\": \"document\", \"entry\": ["
    + composition()
    // relative, resolved against the Composition's base
    + condition("http://example.org/fhir/Condition/a", "a", null)
    // relative, but the only entry with that type and id has a urn:uuid fullUrl: not resolved
    + condition("urn:uuid:7f5d1b4e-0b0c-4a39-9a47-2d3c5a1e0b01", "b", null)
    // absolute, on another server
    + condition("http://other.org/fhir/Condition/c", "c", null)
    // a versioned reference, to the version the resource is
    + condition("http://example.org/fhir/Condition/d", "d", "2")
    // a versioned reference, to a version the resource isn't: not resolved
    + condition("http://example.org/fhir/Condition/e", "e", "2")
    // two entries with the same fullUrl: more than one match is no match
    + condition("http://example.org/fhir/Condition/f", "f1", null)
    + condition("http://example.org/fhir/Condition/f", "f2", null)
    // a reference with a fragment on the end: the resource is resolved
    + condition("http://example.org/fhir/Condition/g", "g", null).replaceAll(",$", "")
    + "]}";

  private static String composition() {
    return "{\"fullUrl\": \"http://example.org/fhir/Composition/doc\", \"resource\": {\"resourceType\": \"Composition\", \"id\": \"doc\", "
      + "\"status\": \"final\", \"type\": {\"coding\": [{\"system\": \"http://loinc.org\", \"code\": \"60591-5\"}]}, \"date\": \"2026-10-25\", "
      + "\"author\": [{\"display\": \"x\"}], \"title\": \"x\", \"section\": ["
      + section("11450-4", "Condition/a", "Condition/b", "http://other.org/fhir/Condition/c", "Condition/d/_history/2",
          "Condition/e/_history/1", "http://example.org/fhir/Condition/f", "Condition/missing")
      + ", " + section("48765-2", "Condition/g#x")
      + "]}},";
  }

  private static String section(String code, String... refs) {
    StringBuilder b = new StringBuilder();
    b.append("{\"code\": {\"coding\": [{\"system\": \"http://loinc.org\", \"code\": \"").append(code).append("\"}]}, \"entry\": [");
    for (int i = 0; i < refs.length; i++) {
      b.append(i == 0 ? "" : ", ").append("{\"reference\": \"").append(refs[i]).append("\"}");
    }
    return b.append("]}").toString();
  }

  private static String condition(String fullUrl, String id, String versionId) {
    return "{\"fullUrl\": \"" + fullUrl + "\", \"resource\": {\"resourceType\": \"Condition\", \"id\": \"" + id + "\", "
      + (versionId == null ? "" : "\"meta\": {\"versionId\": \"" + versionId + "\"}, ")
      + "\"code\": {\"coding\": [{\"system\": \"http://snomed.info/sct\", \"code\": \"404684003\"}]}, \"subject\": {\"display\": \"x\"}}},";
  }

  private static FHIRPathEngine fp;
  private static Base document;

  @BeforeAll
  static void setUp() throws Exception {
    SimpleWorkerContext context = TestingUtilities.getSharedWorkerContext("4.0.1");
    fp = new FHIRPathEngine(context);
    document = Manager.parse(context, new ByteArrayInputStream(DOCUMENT.getBytes(StandardCharsets.UTF_8)), FhirFormat.JSON).get(0).getElement();
  }

  static Stream<Arguments> data() {
    return Stream.of(
      Arguments.of("Bundle.section('http://loinc.org', '11450-4').entry('http://snomed.info/sct', '404684003').id", List.of("a", "c", "d")),
      Arguments.of("Bundle.section('http://loinc.org', '48765-2').entry('http://snomed.info/sct', '404684003').id", List.of("g"))
    );
  }

  @ParameterizedTest(name = "{0}")
  @MethodSource("data")
  void test(String expression, List<String> expected) {
    List<String> values = new ArrayList<>();
    for (Base b : fp.evaluate(document, expression)) {
      values.add(b.primitiveValue());
    }
    assertEquals(expected, values, expression);
  }
}
