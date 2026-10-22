package org.hl7.fhir.test;

import static org.hl7.fhir.test.TurtleGeneratorTestUtils.assertJsonEquals;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.hl7.fhir.model.utilities.formats.FhirFormat;
import org.hl7.fhir.services.elementmodel.Element;
import org.hl7.fhir.services.elementmodel.TurtleParserBase.ConceptIriHandling;
import org.hl7.fhir.standalone.testing.TestingUtilities;
import org.hl7.fhir.test.TurtleGeneratorTestUtils.ParserContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/** Services-family port of org.hl7.fhir.r5.test.TurtleR4RoundTripTests; keep the two in step. */
class TurtleR4RoundTripTests {
  private static ParserContext parsers;

  @BeforeAll
  static void setup() throws Exception {
    parsers = ParserContext.fromWorkerContext(TestingUtilities.getSharedWorkerContext("4.0.1"));
    parsers.setCanonicalizeXhtml(false);
    Assertions.assertEquals("4.0.1", parsers.getFhirVersion());
  }

  @ParameterizedTest
  @ValueSource(strings = {"JSON", "XML"})
  void roundTripsPopulatedPatient(String formatName) throws Exception {
    String narrative = "<div xmlns=\"http://www.w3.org/1999/xhtml\"><p>Before <b>bold</b> &amp; after.</p><p>Second paragraph.</p></div>";
    String json = "{\"resourceType\":\"Patient\",\"id\":\"example\",\"active\":true,"
        + "\"text\":{\"status\":\"generated\",\"div\":" + new com.google.gson.JsonPrimitive(narrative) + "},"
        + "\"name\":[{\"family\":\"Example\",\"given\":[\"First\",\"Second\"]}]}";
    String xml = "<Patient xmlns=\"http://hl7.org/fhir\"><id value=\"example\"/>"
        + "<text><status value=\"generated\"/>" + narrative + "</text><active value=\"true\"/>"
        + "<name><family value=\"Example\"/><given value=\"First\"/><given value=\"Second\"/></name></Patient>";
    FhirFormat format = FhirFormat.valueOf(formatName);
    Element original = parsers.parse(format == FhirFormat.JSON ? json : xml, format);
    String turtle = parsers.compose(original, FhirFormat.TURTLE);
    Assertions.assertTrue(turtle.contains("fhir:Patient.name"), turtle);
    Assertions.assertTrue(turtle.contains("fhir:value"), turtle);
    Element reversed = parsers.parse(turtle, FhirFormat.TURTLE);
    Element reparsed = parsers.parse(parsers.compose(reversed, format), format);
    assertJsonEquals(JsonParser.parseString(json), JsonParser.parseString(parsers.compose(reparsed, FhirFormat.JSON)));
  }

  @ParameterizedTest
  @ValueSource(strings = {"rdf:type", "a", "<http://www.w3.org/1999/02/22-rdf-syntax-ns#type>"})
  void restoresIndexedNamedAndAnonymousRepetitions(String typePredicate) throws Exception {
    String turtle = """
        @prefix fhir: <http://hl7.org/fhir/> .
        @prefix rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> .
        @prefix rdfs: <http://www.w3.org/2000/01/rdf-schema#> .
        <http://example.org/patient> rdf:type fhir:Patient;
          fhir:nodeRole fhir:treeRoot;
          fhir:Patient.name [ fhir:index 10; fhir:HumanName.family [ fhir:value "Third" ] ],
            [ fhir:index 2; fhir:HumanName.family [ fhir:value "Second" ] ],
            [ fhir:index 0; fhir:HumanName.family [ fhir:value "First" ];
              fhir:HumanName.given [ fhir:index 1; fhir:value "B" ], [ fhir:index 0; fhir:value "A" ] ];
          fhir:DomainResource.contained <http://example.org/second>, <http://example.org/first>.
        <http://example.org/second> rdf:type fhir:Organization; fhir:index 1; fhir:Resource.id [ fhir:value "second" ].
        <http://example.org/first> rdf:type fhir:Organization; fhir:index 0; fhir:Resource.id [ fhir:value "first" ].
        """.replace("rdf:type", typePredicate);
    String expected = """
        {"resourceType":"Patient","name":[{"family":"First","given":["A","B"]},{"family":"Second"},{"family":"Third"}],
         "contained":[{"resourceType":"Organization","id":"first"},{"resourceType":"Organization","id":"second"}]}
        """;
    assertJsonEquals(JsonParser.parseString(expected),
        JsonParser.parseString(parsers.compose(parsers.parse(turtle, FhirFormat.TURTLE), FhirFormat.JSON)));
  }

  @ParameterizedTest
  @ValueSource(strings = {"JSON", "XML"})
  void roundTripsExtensionsChoicesReferencesAndNamedBundleResources(String formatName) throws Exception {
    String json = """
        {"resourceType":"Bundle","id":"bundle","type":"collection","total":2,"entry":[
          {"fullUrl":"http://example.org/Patient/patient","resource":{
            "resourceType":"Patient","id":"patient","active":true,
            "_active":{"extension":[{"url":"http://example.org/flag","valueString":"reviewed"}]},
            "_birthDate":{"extension":[{"url":"http://example.org/missing","valueCode":"unknown"}]},
            "contained":[{"resourceType":"Organization","id":"first","name":"First"},
                         {"resourceType":"Organization","id":"second","name":"Second"}],
            "name":[{"given":["First",null,"Third"],"_given":[null,
              {"extension":[{"url":"http://example.org/missing","valueCode":"unknown"}]},null]}],
            "deceasedBoolean":false,"managingOrganization":{"reference":"#first"}}},
          {"fullUrl":"http://example.org/Observation/observation","resource":{
            "resourceType":"Observation","id":"observation","status":"final",
            "code":{"coding":[{"system":"http://loinc.org","code":"8480-6"}]},
            "subject":{"reference":"Patient/patient","display":"Example"},
            "performer":[{"reference":"Practitioner?identifier=http://hl7.org/fhir/sid/us-npi|9999959197"},
              {"reference":"Organization?identifier=urn:ietf:rfc:3986|urn:oid:2.16.840.1.113883.19.5"}],
            "effectiveDateTime":"2012-09-17T12:34:56+10:00",
            "valueQuantity":{"value":107.125,"unit":"mmHg","system":"http://unitsofmeasure.org","code":"mm[Hg]"}}}]}
        """;
    FhirFormat format = FhirFormat.valueOf(formatName);
    Element original = parsers.parse(json, FhirFormat.JSON);
    String source = format == FhirFormat.JSON ? json : parsers.compose(original, format);
    String turtle = parsers.compose(parsers.parse(source, format), FhirFormat.TURTLE);
    Assertions.assertTrue(turtle.contains("fhir:Bundle.entry.resource <http://example.org/Patient/patient>"), turtle);
    Assertions.assertTrue(turtle.contains("us-npi%7C9999959197>"), turtle);
    Assertions.assertFalse(turtle.contains("a fhir:Practitioner"), turtle);
    Assertions.assertFalse(turtle.contains("fhir:Organization?"), turtle);
    Element restored = parsers.parse(parsers.compose(parsers.parse(turtle, FhirFormat.TURTLE), format), format);
    assertJsonEquals(JsonParser.parseString(json), JsonParser.parseString(parsers.compose(restored, FhirFormat.JSON)));
  }

  @ParameterizedTest
  @ValueSource(strings = {
      "[ fhir:index -1 ], [ fhir:index 0 ]",
      "[ fhir:index 0 ], [ fhir:index 0 ]",
      "[ fhir:index 0 ], [ fhir:HumanName.family [ fhir:value \"missing\" ] ]",
      "[ fhir:index \"not-an-integer\" ], [ fhir:index 0 ]",
      "[ fhir:index <http://example.org/index> ], [ fhir:index 0 ]"
  })
  void rejectsInvalidIndexedRepetitions(String names) {
    String turtle = "@prefix fhir: <http://hl7.org/fhir/> . "
        + "<http://example.org/patient> <http://www.w3.org/1999/02/22-rdf-syntax-ns#type> fhir:Patient; "
        + "fhir:nodeRole fhir:treeRoot; fhir:Patient.name " + names + ".";
    IOException exception = Assertions.assertThrows(IOException.class, () -> parsers.parse(turtle, FhirFormat.TURTLE));
    Assertions.assertTrue(exception.getMessage().contains("fhir:index"), exception.getMessage());
    Assertions.assertTrue(exception.getMessage().contains("/Patient/name"), exception.getMessage());
  }

  @Test
  void retainsEncounterOrderForEntirelyUnindexedRepetitions() throws Exception {
    String turtle = """
        @prefix fhir: <http://hl7.org/fhir/> .
        <http://example.org/patient> <http://www.w3.org/1999/02/22-rdf-syntax-ns#type> fhir:Patient;
          fhir:nodeRole fhir:treeRoot;
          fhir:Patient.name [ fhir:HumanName.family [ fhir:value "Second" ] ],
            [ fhir:HumanName.family [ fhir:value "First" ] ].
        """;
    assertJsonEquals(JsonParser.parseString("{\"resourceType\":\"Patient\",\"name\":[{\"family\":\"Second\"},{\"family\":\"First\"}]}"),
        JsonParser.parseString(parsers.compose(parsers.parse(turtle, FhirFormat.TURTLE), FhirFormat.JSON)));
  }

  @Test
  void semanticComparisonPreservesTypesOrderAndNumericPrecision() {
    for (String[] pair : new String[][] {{"true", "\"true\""}, {"1", "\"1\""}, {"[1,2]", "[2,1]"},
        {"9007199254740992", "9007199254740993"}, {"1.00000000000000001", "1.00000000000000002"}}) {
      Assertions.assertThrows(AssertionError.class,
          () -> assertJsonEquals(JsonParser.parseString(pair[0]), JsonParser.parseString(pair[1])));
    }
    assertJsonEquals(JsonParser.parseString("1.0"), JsonParser.parseString("1.00"));
  }

  @Test
  void roundTripsOptionalExternalR4Json() throws Exception {
    String sourcePath = System.getProperty("r4RoundTripJson");
    Assumptions.assumeTrue(sourcePath != null, "Set r4RoundTripJson to check an external R4 JSON resource");
    String source = Files.readString(Path.of(sourcePath), StandardCharsets.UTF_8);
    Element restored = parsers.parse(parsers.compose(parsers.parse(source, FhirFormat.JSON), FhirFormat.TURTLE), FhirFormat.TURTLE);
    assertJsonEquals(JsonParser.parseString(source), JsonParser.parseString(parsers.compose(restored, FhirFormat.JSON)));
  }

  @ParameterizedTest
  @ValueSource(strings = {"xml/examples/expected/R4/patient-example-f201-roel.xml",
      "xml/examples/expected/R4/AllergyIntolerance-example.xml",
      "json/examples/expected/R4/structuredefinition-us-core-patient.json"})
  void roundTripsVettedExamples(String relativePath) throws Exception {
    String resourceName = "testUtilities/" + relativePath;
    Assumptions.assumeTrue(getClass().getClassLoader().getResource(resourceName) != null,
        "Missing vetted fixture: " + resourceName);
    Path sourcePath = TurtleGeneratorTestUtils.getResourcePath(Path.of(resourceName));
    FhirFormat sourceFormat = relativePath.endsWith(".xml") ? FhirFormat.XML : FhirFormat.JSON;
    String source = Files.readString(sourcePath, StandardCharsets.UTF_8);
    Element original = parsers.parse(source, sourceFormat);
    JsonElement expected = JsonParser.parseString(sourceFormat == FhirFormat.JSON ? source : parsers.compose(original, FhirFormat.JSON));
    Element restored = parsers.parse(parsers.compose(original, FhirFormat.TURTLE), FhirFormat.TURTLE);
    for (FhirFormat finalFormat : new FhirFormat[] {FhirFormat.JSON, FhirFormat.XML}) {
      Element reparsed = parsers.parse(parsers.compose(restored, finalFormat), finalFormat);
      assertJsonEquals(expected, JsonParser.parseString(parsers.compose(reparsed, FhirFormat.JSON)));
    }
  }

  @Test
  void conceptIrisAreDroppedByDefaultOrKeptAsCodingExtensions() throws Exception {
    String json = """
        {"resourceType":"Observation","status":"final","code":{"coding":[
          {"system":"http://loinc.org","code":"8480-6"},{"system":"http://snomed.info/sct","code":"271649006"}]}}
        """;
    String turtle = parsers.compose(parsers.parse(json, FhirFormat.JSON), FhirFormat.TURTLE);
    Assertions.assertTrue(turtle.contains("loinc:8480-6") && turtle.contains("sct:271649006"), turtle);
    assertJsonEquals(JsonParser.parseString(json), JsonParser.parseString(parsers.compose(parsers.parse(turtle, FhirFormat.TURTLE), FhirFormat.JSON)));

    parsers.setConceptIriHandling(ConceptIriHandling.EXTENSION);
    try {
      String expected = """
          {"resourceType":"Observation","status":"final","code":{"coding":[
            {"extension":[{"url":"http://hl7.org/fhir/StructureDefinition/rdf-concept-iri","valueUri":"http://loinc.org/rdf/8480-6"}],
             "system":"http://loinc.org","code":"8480-6"},
            {"extension":[{"url":"http://hl7.org/fhir/StructureDefinition/rdf-concept-iri","valueUri":"http://snomed.info/id/271649006"}],
             "system":"http://snomed.info/sct","code":"271649006"}]}}
          """;
      assertJsonEquals(JsonParser.parseString(expected), JsonParser.parseString(parsers.compose(parsers.parse(turtle, FhirFormat.TURTLE), FhirFormat.JSON)));
    } finally {
      parsers.setConceptIriHandling(ConceptIriHandling.DROP);
    }
  }

  @ParameterizedTest
  @ValueSource(strings = {"JSON", "XML"})
  void strictFixtureValidationRejectsUnknownProperties(String formatName) {
    FhirFormat format = FhirFormat.valueOf(formatName);
    String source = format == FhirFormat.JSON ? "{\"resourceType\":\"Patient\",\"notARealPatientProperty\":true}"
        : "<Patient xmlns=\"http://hl7.org/fhir\"><notARealPatientProperty value=\"true\"/></Patient>";
    IOException exception = Assertions.assertThrows(IOException.class, () -> parsers.parse(source, format));
    Assertions.assertTrue(exception.getMessage().contains("notARealPatientProperty"), exception.getMessage());
  }
}
