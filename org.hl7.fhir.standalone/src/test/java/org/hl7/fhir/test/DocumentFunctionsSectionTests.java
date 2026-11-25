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
 * The section functions - isKnown(), hasData(), and sameSubject() on a section - in the R6 engine, on an R4
 * document parsed into the element model, as the validator does it. isKnown(): no emptyReason, or nil known.
 * hasData(): an emptyReason, or else entries. sameSubject() on a section: no focus, or a focus that is the
 * Composition's subject.
 */
class DocumentFunctionsSectionTests {

  private static final String EMPTY_REASON = "http://terminology.hl7.org/CodeSystem/list-empty-reason";

  private static final String DOCUMENT = "{\"resourceType\": \"Bundle\", \"type\": \"document\", \"entry\": ["
    + "{\"fullUrl\": \"urn:uuid:c\", \"resource\": {\"resourceType\": \"Composition\", \"status\": \"final\", "
    + "\"type\": {\"coding\": [{\"system\": \"http://loinc.org\", \"code\": \"60591-5\"}]}, \"subject\": {\"reference\": \"urn:uuid:p\"}, "
    + "\"date\": \"2026-11-23\", \"author\": [{\"display\": \"x\"}], \"title\": \"x\", \"section\": ["
    // entries, no emptyReason: known, has data
    + section("11450-4", "\"entry\": [{\"reference\": \"urn:uuid:c1\"}]") + ", "
    // nil known, no entries: known, has data
    + section("48765-2", reason("nilknown")) + ", "
    // not asked: not known, has data (it says why it's empty)
    + section("10160-0", reason("notasked")) + ", "
    // nothing at all: known, but no data
    + section("46264-8", "\"text\": {\"status\": \"generated\", \"div\": \"<div xmlns=\\\"http://www.w3.org/1999/xhtml\\\">x</div>\"}") + ", "
    // an emptyReason that is only text: not known
    + section("11369-6", "\"emptyReason\": {\"text\": \"we didn't look\"}") + ", "
    // a focus that is the Composition's subject, and one that isn't
    + section("42348-3", "\"focus\": {\"reference\": \"urn:uuid:p\"}, " + reason("nilknown")) + ", "
    + section("18776-5", "\"focus\": {\"reference\": \"urn:uuid:other\"}, " + reason("nilknown")) + ", "
    // nested: withheld, inside a section that is fine
    + section("47519-4", "\"entry\": [{\"reference\": \"urn:uuid:c1\"}], \"section\": [" + section("30954-2", reason("withheld")) + "]")
    + "]}}, "
    + "{\"fullUrl\": \"urn:uuid:p\", \"resource\": {\"resourceType\": \"Patient\", \"name\": [{\"family\": \"x\"}]}}, "
    + "{\"fullUrl\": \"urn:uuid:c1\", \"resource\": {\"resourceType\": \"Condition\", \"id\": \"c1\", "
    + "\"code\": {\"coding\": [{\"system\": \"http://snomed.info/sct\", \"code\": \"38341003\"}]}, \"subject\": {\"reference\": \"urn:uuid:p\"}}}"
    + "]}";

  private static String section(String code, String rest) {
    return "{\"code\": {\"coding\": [{\"system\": \"http://loinc.org\", \"code\": \"" + code + "\"}]}, " + rest + "}";
  }

  private static String reason(String code) {
    return "\"emptyReason\": {\"coding\": [{\"system\": \"" + EMPTY_REASON + "\", \"code\": \"" + code + "\"}]}";
  }

  private static FHIRPathEngine fp;
  private static Base document;

  @BeforeAll
  static void setUp() throws Exception {
    SimpleWorkerContext context = TestingUtilities.getSharedWorkerContext("4.0.1");
    fp = new FHIRPathEngine(context);
    document = Manager.parse(context, new ByteArrayInputStream(DOCUMENT.getBytes(StandardCharsets.UTF_8)), FhirFormat.JSON).get(0).getElement();
  }

  private static String s(String code) {
    return "Bundle.section('http://loinc.org', '" + code + "')";
  }

  static Stream<Arguments> data() {
    return Stream.of(
      // isKnown(): missing or nil known
      Arguments.of(s("11450-4") + ".isKnown()", List.of("true")),
      Arguments.of(s("48765-2") + ".isKnown()", List.of("true")),
      Arguments.of(s("10160-0") + ".isKnown()", List.of("false")),
      Arguments.of(s("46264-8") + ".isKnown()", List.of("true")),
      Arguments.of(s("11369-6") + ".isKnown()", List.of("false")),
      Arguments.of(s("30954-2") + ".isKnown()", List.of("false")),
      // hasData(): an emptyReason, or else entries
      Arguments.of(s("11450-4") + ".hasData()", List.of("true")),
      Arguments.of(s("48765-2") + ".hasData()", List.of("true")),
      Arguments.of(s("10160-0") + ".hasData()", List.of("true")),
      Arguments.of(s("46264-8") + ".hasData()", List.of("false")),
      // sameSubject() on a section: no focus, or the Composition's subject
      Arguments.of(s("11450-4") + ".sameSubject()", List.of("true")),
      Arguments.of(s("42348-3") + ".sameSubject()", List.of("true")),
      Arguments.of(s("18776-5") + ".sameSubject()", List.of("false")),
      // on a resource, as before
      Arguments.of("Bundle.entry.resource.ofType(Condition).sameSubject()", List.of("true")),
      // no section: empty, so a rule on a missing section fails
      Arguments.of(s("99999-9") + ".isKnown()", List.of()),
      Arguments.of(s("99999-9") + ".hasData()", List.of()),
      // not a section: false
      Arguments.of("Bundle.entry.resource.ofType(Condition).isKnown()", List.of("false")),
      Arguments.of("Bundle.entry.resource.ofType(Condition).hasData()", List.of("false")),
      // as the clinical profile rules have them
      Arguments.of(s("11450-4") + ".where(isKnown() and hasData() and sameSubject()).exists()", List.of("true")),
      Arguments.of(s("46264-8") + ".where(isKnown() and hasData()).exists()", List.of("false")),
      Arguments.of(s("18776-5") + ".where(isKnown() and sameSubject()).exists()", List.of("false")),
      Arguments.of(s("11450-4") + ".where(hasData()).entry('http://snomed.info/sct', '38341003').exists()", List.of("true"))
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
