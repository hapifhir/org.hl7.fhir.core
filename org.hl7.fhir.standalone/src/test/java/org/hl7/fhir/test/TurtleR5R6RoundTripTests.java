package org.hl7.fhir.test;

import static org.hl7.fhir.test.TurtleGeneratorTestUtils.assertJsonEquals;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.hl7.fhir.model.utilities.formats.FhirFormat;
import org.hl7.fhir.services.elementmodel.Element;
import org.hl7.fhir.services.elementmodel.Manager;
import org.hl7.fhir.services.elementmodel.ParserBase;
import org.hl7.fhir.services.elementmodel.TurtleParser;
import org.hl7.fhir.services.elementmodel.TurtleParserBase.ConceptIriHandling;
import org.hl7.fhir.standalone.testing.TestingUtilities;
import org.hl7.fhir.test.TurtleGeneratorTestUtils.ParserContext;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

/** Services-family port of org.hl7.fhir.r5.test.TurtleR5R6RoundTripTests; keep the two in step. */
class TurtleR5R6RoundTripTests {
  // Matches VersionUtilities.getCurrentVersion and the standalone TestingUtilities default.
  private static final String R6_CORE_VERSION = "6.0.0-snapshot1";
  private static final Map<String, ParserContext> contexts = new HashMap<>();

  @BeforeAll
  static void setup() throws Exception {
    contexts.put("5.0.0", ParserContext.fromWorkerContext(TestingUtilities.getSharedWorkerContext("5.0.0")));
    contexts.put("6.0.0", ParserContext.fromWorkerContext(TestingUtilities.getSharedWorkerContext(R6_CORE_VERSION)));
    Assertions.assertEquals(R6_CORE_VERSION, contexts.get("6.0.0").getFhirVersion());
    contexts.values().forEach(parsers -> parsers.setCanonicalizeXhtml(false));
  }

  @ParameterizedTest
  @ValueSource(strings = {"5.0.0", "6.0.0"})
  void restoresShortPredicates(String version) throws Exception {
    ParserContext parsers = contexts.get(version);
    Assertions.assertTrue(parsers.getFhirVersion().startsWith(version), parsers.getFhirVersion());
    String json = "{\"resourceType\":\"Patient\",\"id\":\"example\",\"active\":true,\"name\":[{\"given\":[\"First\",\"Second\"]}]}";
    String turtle = parsers.compose(parsers.parse(json, FhirFormat.JSON), FhirFormat.TURTLE);
    Assertions.assertTrue(turtle.contains("fhir:v"), turtle);
    Assertions.assertTrue(turtle.contains("fhir:name ("), turtle);
    Assertions.assertFalse(turtle.contains("fhir:index"), turtle);
    assertJsonEquals(JsonParser.parseString(json),
        JsonParser.parseString(parsers.compose(parsers.parse(turtle, FhirFormat.TURTLE), FhirFormat.JSON)));
  }

  @ParameterizedTest
  @CsvSource({"5.0.0,JSON,JSON", "5.0.0,JSON,XML", "5.0.0,XML,JSON", "5.0.0,XML,XML",
      "6.0.0,JSON,JSON", "6.0.0,JSON,XML", "6.0.0,XML,JSON", "6.0.0,XML,XML"})
  void roundTripsResourceSemantics(String version, String intermediateName, String finalName) throws Exception {
    String json = """
        {"resourceType":"Bundle","id":"bundle","type":"collection","total":2,"entry":[
          {"fullUrl":"http://example.org/Patient/patient","resource":{
            "resourceType":"Patient","id":"patient","active":true,
            "text":{"status":"generated","div":"<div xmlns=\\\"http://www.w3.org/1999/xhtml\\\"><p>Before <b>bold</b> &amp; after.</p><p>Second paragraph.</p></div>"},
            "_active":{"extension":[{"url":"http://example.org/flag","valueString":"reviewed"}]},
            "_birthDate":{"extension":[{"url":"http://example.org/missing","valueCode":"unknown"}]},
            "contained":[{"resourceType":"Organization","id":"first","name":"First"},
                         {"resourceType":"Organization","id":"second","name":"Second"}],
            "name":[{"family":"First","given":["A",null,"C"],"_given":[null,
              {"extension":[{"url":"http://example.org/missing","valueCode":"unknown"}]},null]},
              {"family":"Second","given":["D","E"]}],
            "deceasedBoolean":false,"managingOrganization":{"reference":"#first"}}},
          {"fullUrl":"http://example.org/Observation/observation","resource":{
            "resourceType":"Observation","id":"observation","status":"final",
            "code":{"coding":[{"system":"http://loinc.org","code":"8480-6"},
              {"system":"http://snomed.info/sct","code":"271649006"}]},
            "subject":{"reference":"Patient/patient","display":"Example"},
            "performer":[{"reference":"Practitioner?identifier=http://hl7.org/fhir/sid/us-npi|9999959197"},
              {"reference":"Organization?identifier=urn:ietf:rfc:3986|urn:oid:2.16.840.1.113883.19.5"}],
            "effectiveDateTime":"2012-09-17T12:34:56.012300+10:00",
            "valueQuantity":{"value":107.12500000000000001,"unit":"mmHg","system":"http://unitsofmeasure.org","code":"mm[Hg]"},
            "component":[{"code":{"text":"First"},"valueString":"one"},
              {"code":{"text":"Second"},"valueBoolean":true}]}}]}
        """;
    ParserContext parsers = contexts.get(version);
    FhirFormat intermediate = FhirFormat.valueOf(intermediateName);
    FhirFormat finalFormat = FhirFormat.valueOf(finalName);
    Element original = parsers.parse(json, FhirFormat.JSON);
    String turtle = parsers.compose(parsers.parse(parsers.compose(original, intermediate), intermediate), FhirFormat.TURTLE);
    Assertions.assertTrue(turtle.contains("fhir:resource <http://example.org/Patient/patient>"), turtle);
    Assertions.assertTrue(turtle.contains("us-npi%7C9999959197>"), turtle);
    Assertions.assertFalse(turtle.contains("a fhir:Practitioner"), turtle);
    Assertions.assertFalse(turtle.contains("fhir:Organization?"), turtle);
    Assertions.assertTrue(turtle.contains("fhir:contained ("), turtle);
    Assertions.assertTrue(turtle.contains("rdf:XMLLiteral"), turtle);
    Assertions.assertFalse(turtle.contains("fhir:index"), turtle);
    Element restored = parsers.parse(parsers.compose(parsers.parse(turtle, FhirFormat.TURTLE), finalFormat), finalFormat);
    assertJsonEquals(JsonParser.parseString(json), JsonParser.parseString(parsers.compose(restored, FhirFormat.JSON)));
  }

  @ParameterizedTest
  @ValueSource(strings = {"5.0.0", "6.0.0"})
  void restoresNamedNodesAndCollectionOrder(String version) throws Exception {
    String turtle = """
        @prefix fhir: <http://hl7.org/fhir/> .
        @prefix rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> .
        <http://example.org/patient> a fhir:Patient; fhir:nodeRole fhir:treeRoot;
          fhir:id <http://example.org/id>; fhir:active <http://example.org/flag>;
          fhir:name (<http://example.org/second> <http://example.org/first>);
          fhir:contained (<http://example.org/org>); fhir:telecom ().
        <http://example.org/first> fhir:family [ fhir:v "First" ]; fhir:given ([ fhir:v "A" ] [ fhir:v "B" ]).
        <http://example.org/org> a fhir:Organization; fhir:id [ fhir:v "org" ].
        <http://example.org/flag> fhir:v false .
        <http://example.org/second> fhir:family [ fhir:v "Second" ]; fhir:given ([ fhir:v "C" ]).
        <http://example.org/id> fhir:v "example".
        """;
    String expected = """
        {"resourceType":"Patient","id":"example","active":false,
         "name":[{"family":"Second","given":["C"]},{"family":"First","given":["A","B"]}],
         "contained":[{"resourceType":"Organization","id":"org"}]}
        """;
    ParserContext parsers = contexts.get(version);
    assertJsonEquals(JsonParser.parseString(expected),
        JsonParser.parseString(parsers.compose(parsers.parse(turtle, FhirFormat.TURTLE), FhirFormat.JSON)));
  }

  @ParameterizedTest
  @ValueSource(strings = {"5.0.0", "6.0.0"})
  void acceptsSingleResourcesInLegacyOneItemLists(String version) throws Exception {
    String turtle = """
        @prefix fhir: <http://hl7.org/fhir/> .
        <http://example.org/Bundle/b> a fhir:Bundle; fhir:nodeRole fhir:treeRoot;
          fhir:type [ fhir:v "collection" ];
          fhir:entry ([ fhir:fullUrl [ fhir:v "http://example.org/Patient/p" ]; fhir:resource (<http://example.org/Patient/p>) ]).
        <http://example.org/Patient/p> a fhir:Patient; fhir:id [ fhir:v "p" ].
        """;
    String expected = """
        {"resourceType":"Bundle","type":"collection",
         "entry":[{"fullUrl":"http://example.org/Patient/p","resource":{"resourceType":"Patient","id":"p"}}]}
        """;
    ParserContext parsers = contexts.get(version);
    assertJsonEquals(JsonParser.parseString(expected),
        JsonParser.parseString(parsers.compose(parsers.parse(turtle, FhirFormat.TURTLE), FhirFormat.JSON)));
  }

  @ParameterizedTest
  @ValueSource(strings = {"5.0.0", "6.0.0"})
  void restoresExpandedCollectionsIndependentOfStatementOrder(String version) throws Exception {
    String turtle = """
        @prefix fhir: <http://hl7.org/fhir/> .
        @prefix rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> .
        <http://example.org/tail> rdf:rest rdf:nil .
        <http://example.org/first> fhir:family [ fhir:v "First" ]; fhir:given rdf:nil .
        <http://example.org/head> rdf:rest <http://example.org/tail> .
        <http://example.org/patient> fhir:name <http://example.org/head>; fhir:telecom rdf:nil .
        <http://example.org/tail> rdf:first <http://example.org/first> .
        <http://example.org/second> fhir:family [ fhir:v "Second" ];
          fhir:given [ rdf:first [ fhir:v "Only" ]; rdf:rest rdf:nil ] .
        <http://example.org/patient> a fhir:Patient; fhir:nodeRole fhir:treeRoot .
        <http://example.org/head> rdf:first <http://example.org/second> .
        """;
    ParserContext parsers = contexts.get(version);
    String expected = "{\"resourceType\":\"Patient\",\"name\":[{\"family\":\"Second\",\"given\":[\"Only\"]},{\"family\":\"First\"}]}";
    assertJsonEquals(JsonParser.parseString(expected),
        JsonParser.parseString(parsers.compose(parsers.parse(turtle, FhirFormat.TURTLE), FhirFormat.JSON)));
  }

  static Stream<Arguments> invalidGraphs() {
    return Stream.of("5.0.0", "6.0.0").flatMap(version -> Stream.of(
        "fhir:name [ rdf:first [ fhir:family [ fhir:v \"missing-rest\" ] ] ]",
        "fhir:name [ rdf:rest rdf:nil ]",
        "fhir:name [ rdf:first [ ]; rdf:rest \"literal\" ]",
        "fhir:name <http://example.org/cycle> . <http://example.org/cycle> rdf:first [ ]; rdf:rest <http://example.org/cycle>",
        "fhir:name ([ ]), ([ ])",
        "fhir:name [ rdf:first [ ], [ ]; rdf:rest rdf:nil ]",
        "fhir:active <http://example.org/unresolved>",
        "fhir:active [ fhir:v true, false ]",
        "fhir:deceased [ fhir:v true ]",
        "fhir:deceased [ a fhir:boolean, fhir:Boolean, fhir:dateTime, fhir:DateTime; fhir:v true ]",
        "fhir:notARealPatientProperty [ fhir:v \"do-not-drop\" ]",
        "fhir:name [ fhir:v \"not-a-list\" ]",
        "fhir:name (([ fhir:v \"nested\" ]))"
    ).map(predicates -> Arguments.of(version, predicates)));
  }

  @ParameterizedTest
  @MethodSource("invalidGraphs")
  void rejectsInvalidGraphsWithAPath(String version, String predicates) {
    String turtle = "@prefix fhir: <http://hl7.org/fhir/> . "
        + "@prefix rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> . "
        + "<http://example.org/patient> a fhir:Patient; fhir:nodeRole fhir:treeRoot; " + predicates + " .";
    IOException exception = Assertions.assertThrows(IOException.class,
        () -> contexts.get(version).parse(turtle, FhirFormat.TURTLE));
    Assertions.assertTrue(exception.getMessage().contains("/Patient"), exception.getMessage());
  }

  @ParameterizedTest
  @CsvSource({"5.0.0,2020", "5.0.0,2020-02", "5.0.0,2020-02-03",
      "6.0.0,2020", "6.0.0,2020-02", "6.0.0,2020-02-03"})
  void preservesDatePrecision(String version, String date) throws Exception {
    ParserContext parsers = contexts.get(version);
    String json = "{\"resourceType\":\"Patient\",\"birthDate\":\"" + date + "\"}";
    assertJsonEquals(JsonParser.parseString(json), JsonParser.parseString(parsers.compose(
        parsers.parse(parsers.compose(parsers.parse(json, FhirFormat.JSON), FhirFormat.TURTLE), FhirFormat.TURTLE),
        FhirFormat.JSON)));
  }

  @ParameterizedTest
  @CsvSource({"5.0.0,r5RoundTripJson", "6.0.0,r6RoundTripJson"})
  void roundTripsOptionalExternalJson(String version, String property) throws Exception {
    String sourcePath = System.getProperty(property);
    Assumptions.assumeTrue(sourcePath != null, "Set " + property + " to check an external resource");
    String json = Files.readString(Path.of(sourcePath), StandardCharsets.UTF_8);
    ParserContext parsers = contexts.get(version);
    for (FhirFormat intermediate : new FhirFormat[] {FhirFormat.JSON, FhirFormat.XML}) {
      String turtle = parsers.compose(parsers.parse(parsers.compose(parsers.parse(json, FhirFormat.JSON), intermediate), intermediate), FhirFormat.TURTLE);
      for (FhirFormat finalFormat : new FhirFormat[] {FhirFormat.JSON, FhirFormat.XML}) {
        Element restored = parsers.parse(parsers.compose(parsers.parse(turtle, FhirFormat.TURTLE), finalFormat), finalFormat);
        assertJsonEquals(JsonParser.parseString(json), JsonParser.parseString(parsers.compose(restored, FhirFormat.JSON)));
      }
    }
  }

  @ParameterizedTest
  @CsvSource({"5.0.0,xml/examples/expected/R5/patient-example-f201-roel.xml",
      "5.0.0,xml/examples/expected/R5/patient.profile.xml",
      "5.0.0,json/examples/expected/R5/StructureDefinition-patient-eu.json",
      "6.0.0,xml/examples/expected/R6/patient-example-f201-roel.xml",
      "6.0.0,xml/examples/expected/R6/patient.profile.xml"})
  void roundTripsVettedExamples(String version, String relativePath) throws Exception {
    String resourceName = "testUtilities/" + relativePath;
    Assumptions.assumeTrue(getClass().getClassLoader().getResource(resourceName) != null,
        "Missing vetted fixture: " + resourceName);
    Path sourcePath = TurtleGeneratorTestUtils.getResourcePath(Path.of(resourceName));
    ParserContext parsers = contexts.get(version);
    FhirFormat sourceFormat = relativePath.endsWith(".xml") ? FhirFormat.XML : FhirFormat.JSON;
    String source = Files.readString(sourcePath, StandardCharsets.UTF_8);
    Element original = parsers.parse(source, sourceFormat);
    JsonElement expected = JsonParser.parseString(sourceFormat == FhirFormat.JSON ? source : parsers.compose(original, FhirFormat.JSON));
    Element restored = parsers.parse(parsers.compose(original, FhirFormat.TURTLE), FhirFormat.TURTLE);
    for (FhirFormat finalFormat : new FhirFormat[] {FhirFormat.JSON, FhirFormat.XML}) {
      Element reparsed = parsers.parse(parsers.compose(restored, finalFormat), finalFormat);
      JsonElement actual = JsonParser.parseString(parsers.compose(reparsed, FhirFormat.JSON));
      JsonElement comparable = finalFormat == FhirFormat.XML ? normalizeNarrativeLineEndings(expected) : expected;
      Assertions.assertAll(relativePath + " via " + finalFormat,
          () -> assertJsonEquals(comparable, finalFormat == FhirFormat.XML ? normalizeNarrativeLineEndings(actual) : actual));
    }
  }

  // XML parsing must normalize CRLF to LF, so no XML leg can return a CRLF narrative verbatim; this is not a Turtle defect.
  private JsonElement normalizeNarrativeLineEndings(JsonElement resource) {
    JsonElement copy = JsonParser.parseString(resource.toString());
    normalizeNarrativeLineEndings(copy, new java.util.ArrayDeque<>());
    return copy;
  }

  private void normalizeNarrativeLineEndings(JsonElement node, java.util.Deque<String> path) {
    if (node.isJsonObject()) {
      for (String key : new java.util.ArrayList<>(node.getAsJsonObject().keySet())) {
        JsonElement child = node.getAsJsonObject().get(key);
        if ("div".equals(key) && "text".equals(path.peek()) && child.isJsonPrimitive() && child.getAsJsonPrimitive().isString()) {
          node.getAsJsonObject().addProperty(key, child.getAsString().replace("\r\n", "\n").replace("\r", "\n"));
        } else {
          path.push(key);
          normalizeNarrativeLineEndings(child, path);
          path.pop();
        }
      }
    } else if (node.isJsonArray()) {
      for (JsonElement item : node.getAsJsonArray()) {
        normalizeNarrativeLineEndings(item, path);
      }
    }
  }

  @ParameterizedTest
  @ValueSource(strings = {"5.0.0", "6.0.0"})
  void conceptIrisAreDroppedByDefaultOrKeptAsCodingExtensions(String version) throws Exception {
    String json = """
        {"resourceType":"Observation","status":"final","code":{"coding":[
          {"system":"http://loinc.org","code":"8480-6"},{"system":"http://snomed.info/sct","code":"271649006"}]}}
        """;
    ParserContext parsers = contexts.get(version);
    String turtle = parsers.compose(parsers.parse(json, FhirFormat.JSON), FhirFormat.TURTLE);
    Assertions.assertTrue(turtle.contains("loinc:8480-6") && turtle.contains("sct:271649006"), turtle);
    assertJsonEquals(JsonParser.parseString(json),
        JsonParser.parseString(parsers.compose(parsers.parse(turtle, FhirFormat.TURTLE), FhirFormat.JSON)));

    ParserContext extensions = ParserContext.fromWorkerContext(parsers.getWorkerContext());
    extensions.setConceptIriHandling(ConceptIriHandling.EXTENSION);
    String expected = """
        {"resourceType":"Observation","status":"final","code":{"coding":[
          {"extension":[{"url":"http://hl7.org/fhir/StructureDefinition/rdf-concept-iri","valueUri":"http://loinc.org/rdf/8480-6"}],
           "system":"http://loinc.org","code":"8480-6"},
          {"extension":[{"url":"http://hl7.org/fhir/StructureDefinition/rdf-concept-iri","valueUri":"http://snomed.info/id/271649006"}],
           "system":"http://snomed.info/sct","code":"271649006"}]}}
        """;
    assertJsonEquals(JsonParser.parseString(expected),
        JsonParser.parseString(extensions.compose(extensions.parse(turtle, FhirFormat.TURTLE), FhirFormat.JSON)));
  }

  @ParameterizedTest
  @ValueSource(strings = {"5.0.0", "6.0.0"})
  void warnsAndDropsConceptIrisThatMatchNoCoding(String version) throws Exception {
    String turtle = """
        @prefix fhir: <http://hl7.org/fhir/> .
        <http://example.org/obs> a fhir:Observation; fhir:nodeRole fhir:treeRoot; fhir:status [ fhir:v "final" ];
          fhir:code [ a <http://loinc.org/rdf#8480-6>;
            fhir:coding ([ fhir:system [ fhir:v "http://loinc.org" ]; fhir:code [ fhir:v "8480-6" ] ]) ] .
        """;
    TurtleParser parser = (TurtleParser) Manager.makeParser(contexts.get(version).getWorkerContext(), FhirFormat.TURTLE);
    parser.setupValidation(ParserBase.ValidationPolicy.EVERYTHING);
    parser.setConceptIriHandling(ConceptIriHandling.EXTENSION);
    List<ValidationMessage> messages = new ArrayList<>();
    Element resource = parser.parseSingle(new ByteArrayInputStream(turtle.getBytes(StandardCharsets.UTF_8)), messages);
    Assertions.assertEquals(1, messages.size(), messages.toString());
    Assertions.assertEquals(IssueSeverity.WARNING, messages.get(0).getLevel());
    Assertions.assertTrue(messages.get(0).getMessage().contains("http://loinc.org/rdf#8480-6"), messages.get(0).getMessage());
    assertJsonEquals(JsonParser.parseString(
        "{\"resourceType\":\"Observation\",\"status\":\"final\",\"code\":{\"coding\":[{\"system\":\"http://loinc.org\",\"code\":\"8480-6\"}]}}"),
        JsonParser.parseString(contexts.get(version).compose(resource, FhirFormat.JSON)));
  }
}
