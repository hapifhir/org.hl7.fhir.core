package org.hl7.fhir.test;

import static org.hl7.fhir.test.TurtleGeneratorTestUtils.assertJsonEquals;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.hl7.fhir.convertors.loaders.loaderRN.NullLoaderKnowledgeProviderRN;
import org.hl7.fhir.convertors.loaders.loaderRN.R3ToRNLoader;
import org.hl7.fhir.model.ModelContext;
import org.hl7.fhir.standalone.context.SimpleWorkerContext;
import org.hl7.fhir.services.elementmodel.Element;
import org.hl7.fhir.services.elementmodel.Manager;
import org.hl7.fhir.model.utilities.formats.FhirFormat;
import org.hl7.fhir.services.elementmodel.ParserBase;
import org.hl7.fhir.services.elementmodel.TurtleParser;
import org.hl7.fhir.services.elementmodel.TurtleParserBase.ConceptIriHandling;
import org.hl7.fhir.test.TurtleGeneratorTestUtils.ParserContext;
import org.hl7.fhir.standalone.testing.TestingUtilities;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Named;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class TurtleRoundTripTests {
  private static final String STU3 = "3.0.2";
  private static final String R4 = "4.0.1";
  private static final String R4B = "4.3.0";
  private static final String R5 = "5.0.0";
  // Lookup key only. The R6 definitions actually loaded are R6_CORE_VERSION.
  private static final String R6 = "6.0.0";
  // Matches VersionUtilities.getCurrentVersion and the standalone TestingUtilities default.
  private static final String R6_CORE_VERSION = "6.0.0-snapshot1";
  private static final List<String> VERSIONS = List.of(STU3, R4, R4B, R5, R6);
  private static final List<String> R4_FORMAT_VERSIONS = List.of(STU3, R4, R4B);
  private static final List<FhirFormat> JSON_AND_XML = List.of(FhirFormat.JSON, FhirFormat.XML);
  private static final Map<String, String> EXTERNAL_JSON_PROPERTIES =
      Map.of(STU3, "stu3RoundTripJson", R4, "r4RoundTripJson", R4B, "r4bRoundTripJson", R5, "r5RoundTripJson", R6, "r6RoundTripJson");
  private static final Map<String, ParserContext> contexts = new HashMap<>();

  @BeforeAll
  static void setup() throws Exception {
    var stu3Core = new FilesystemPackageCacheManager.Builder().build().loadPackage("hl7.fhir.r3.core", STU3);
    var loader = new R3ToRNLoader(ModelContext.fullCoreContext(), SimpleWorkerContext.defaultTypesToLoad(),
        new NullLoaderKnowledgeProviderRN());
    contexts.put(STU3, ParserContext.fromWorkerContext(TestingUtilities.getWorkerContext(stu3Core, loader)));
    contexts.put(R4, ParserContext.fromWorkerContext(TestingUtilities.getSharedWorkerContext(R4)));
    contexts.put(R4B, ParserContext.fromWorkerContext(TestingUtilities.getSharedWorkerContext(R4B)));
    contexts.put(R5, ParserContext.fromWorkerContext(TestingUtilities.getSharedWorkerContext(R5)));
    contexts.put(R6, ParserContext.fromWorkerContext(TestingUtilities.getSharedWorkerContext(R6_CORE_VERSION)));
    Assertions.assertEquals(R6_CORE_VERSION, contexts.get(R6).getFhirVersion());
    contexts.forEach((version, parsers) -> {
      Assertions.assertTrue(parsers.getFhirVersion().startsWith(version), parsers.getFhirVersion());
      parsers.setCanonicalizeXhtml(false);
    });
  }

  /** Writes the resource in the given format and parses it back. */
  private static Element roundTrip(ParserContext parsers, Element resource, FhirFormat format) throws IOException {
    return parsers.parse(parsers.compose(resource, format), format);
  }

  private static JsonElement toJson(ParserContext parsers, Element resource) throws IOException {
    return JsonParser.parseString(parsers.compose(resource, FhirFormat.JSON));
  }

  static Stream<Arguments> versionsAndFormats() {
    List<Arguments> combinations = new ArrayList<>();
    for (String version : VERSIONS) {
      for (FhirFormat beforeTurtle : JSON_AND_XML) {
        for (FhirFormat afterTurtle : JSON_AND_XML) {
          combinations.add(Arguments.of(version, beforeTurtle, afterTurtle));
        }
      }
    }
    return combinations.stream();
  }

  /** JSON -> beforeTurtle -> Turtle -> afterTurtle -> JSON must reproduce the original JSON. */
  @ParameterizedTest(name = "{0}: JSON -> {1} -> Turtle -> {2}")
  @MethodSource("versionsAndFormats")
  void roundTripsResourceSemantics(String version, FhirFormat beforeTurtle, FhirFormat afterTurtle) throws Exception {
    // JSON format testing here is independent of the FHIR model changes between versions
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
              {"code":{"text":"Second"},"valueDateTime":"2020-02-03"}]}}]}
        """;
    ParserContext parsers = contexts.get(version);
    boolean r4 = R4_FORMAT_VERSIONS.contains(version);
    Element original = parsers.parse(json, FhirFormat.JSON);
    String turtle = parsers.compose(roundTrip(parsers, original, beforeTurtle), FhirFormat.TURTLE);
    List<String> expectedFragments = r4
        ? List.of("fhir:Bundle.entry.resource <http://example.org/Patient/patient>", "fhir:Patient.name", "fhir:value")
        : List.of("fhir:resource <http://example.org/Patient/patient>", "fhir:name (", "fhir:contained (", "rdf:XMLLiteral", "fhir:v");
    for (String fragment : expectedFragments) {
      Assertions.assertTrue(turtle.contains(fragment), () -> fragment + " missing from\n" + turtle);
    }
    Assertions.assertTrue(turtle.contains("us-npi%7C9999959197>"), turtle);
    Assertions.assertFalse(turtle.contains("a fhir:Practitioner"), turtle);
    Assertions.assertFalse(turtle.contains("fhir:Organization?"), turtle);
    Assertions.assertEquals(r4, turtle.contains("fhir:index"), turtle);
    Element restored = roundTrip(parsers, parsers.parse(turtle, FhirFormat.TURTLE), afterTurtle);
    assertJsonEquals(JsonParser.parseString(json), toJson(parsers, restored));
  }

  static Stream<Arguments> turtleGraphs() {
    String r4Indexed = """
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
        """;
    String r4IndexedExpected = """
        {"resourceType":"Patient","name":[{"family":"First","given":["A","B"]},{"family":"Second"},{"family":"Third"}],
         "contained":[{"resourceType":"Organization","id":"first"},{"resourceType":"Organization","id":"second"}]}
        """;
    String r4Unindexed = """
        @prefix fhir: <http://hl7.org/fhir/> .
        <http://example.org/patient> <http://www.w3.org/1999/02/22-rdf-syntax-ns#type> fhir:Patient;
          fhir:nodeRole fhir:treeRoot;
          fhir:Patient.name [ fhir:HumanName.family [ fhir:value "Second" ] ],
            [ fhir:HumanName.family [ fhir:value "First" ] ].
        """;
    String r4UnindexedExpected = "{\"resourceType\":\"Patient\",\"name\":[{\"family\":\"Second\"},{\"family\":\"First\"}]}";
    String namedNodes = """
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
    String namedNodesExpected = """
        {"resourceType":"Patient","id":"example","active":false,
         "name":[{"family":"Second","given":["C"]},{"family":"First","given":["A","B"]}],
         "contained":[{"resourceType":"Organization","id":"org"}]}
        """;
    String legacyOneItemLists = """
        @prefix fhir: <http://hl7.org/fhir/> .
        <http://example.org/Bundle/b> a fhir:Bundle; fhir:nodeRole fhir:treeRoot;
          fhir:type [ fhir:v "collection" ];
          fhir:entry ([ fhir:fullUrl [ fhir:v "http://example.org/Patient/p" ]; fhir:resource (<http://example.org/Patient/p>) ]).
        <http://example.org/Patient/p> a fhir:Patient; fhir:id [ fhir:v "p" ].
        """;
    String legacyOneItemListsExpected = """
        {"resourceType":"Bundle","type":"collection",
         "entry":[{"fullUrl":"http://example.org/Patient/p","resource":{"resourceType":"Patient","id":"p"}}]}
        """;
    String expandedCollections = """
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
    String expandedCollectionsExpected = "{\"resourceType\":\"Patient\",\"name\":[{\"family\":\"Second\",\"given\":[\"Only\"]},{\"family\":\"First\"}]}";
    List<Arguments> graphs = new ArrayList<>();
    for (String version : R4_FORMAT_VERSIONS) {
      for (String typePredicate : List.of("rdf:type", "a", "<http://www.w3.org/1999/02/22-rdf-syntax-ns#type>")) {
        graphs.add(graph(version, "indexed named and anonymous repetitions, typed with " + typePredicate,
            r4Indexed.replace("rdf:type", typePredicate), r4IndexedExpected));
      }
      graphs.add(graph(version, "encounter order of unindexed repetitions", r4Unindexed, r4UnindexedExpected));
    }
    for (String version : List.of(R5, R6)) {
      graphs.add(graph(version, "named nodes and collection order", namedNodes, namedNodesExpected));
      graphs.add(graph(version, "legacy one-item resource lists", legacyOneItemLists, legacyOneItemListsExpected));
      graphs.add(graph(version, "expanded collections in any statement order", expandedCollections, expandedCollectionsExpected));
    }
    return graphs.stream();
  }

  private static Arguments graph(String version, String description, String turtle, String expectedJson) {
    return Arguments.of(version, Named.of(description, turtle), expectedJson);
  }

  @ParameterizedTest(name = "{0}: {1}")
  @MethodSource("turtleGraphs")
  void readsTurtleGraphs(String version, String turtle, String expectedJson) throws Exception {
    ParserContext parsers = contexts.get(version);
    Element resource = parsers.parse(turtle, FhirFormat.TURTLE);
    assertJsonEquals(JsonParser.parseString(expectedJson), toJson(parsers, resource));
  }

  private static String patientTurtle(String predicates) {
    return "@prefix fhir: <http://hl7.org/fhir/> . "
        + "@prefix rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> . "
        + "<http://example.org/patient> a fhir:Patient; fhir:nodeRole fhir:treeRoot; " + predicates + " .";
  }

  static Stream<Arguments> invalidInputs() {
    // {description, fhir:Patient.name objects, expected error}
    String[][] r4InvalidNames = {
        {"negative fhir:index", "[ fhir:index -1 ], [ fhir:index 0 ]",
            "Negative or duplicate fhir:index at /Patient/name: -1"},
        {"duplicate fhir:index", "[ fhir:index 0 ], [ fhir:index 0 ]",
            "Negative or duplicate fhir:index at /Patient/name: 0"},
        {"fhir:index on only some repetitions", "[ fhir:index 0 ], [ fhir:HumanName.family [ fhir:value \"missing\" ] ]",
            "Missing fhir:index in indexed repetitions at /Patient/name"},
        {"non-integer fhir:index", "[ fhir:index \"not-an-integer\" ], [ fhir:index 0 ]",
            "Invalid integer fhir:index at /Patient/name: not-an-integer"},
        {"IRI fhir:index", "[ fhir:index <http://example.org/index> ], [ fhir:index 0 ]",
            "Expected an integer fhir:index at /Patient/name"}};
    // {description, Patient predicates, expected error}
    String[][] r5r6InvalidPredicates = {
        {"collection cell missing rdf:rest", "fhir:name [ rdf:first [ fhir:family [ fhir:v \"missing-rest\" ] ] ]",
            "Expected exactly one rdf:rest at /Patient/name"},
        {"collection cell missing rdf:first", "fhir:name [ rdf:rest rdf:nil ]",
            "Expected exactly one rdf:first at /Patient/name"},
        {"literal rdf:rest", "fhir:name [ rdf:first [ ]; rdf:rest \"literal\" ]",
            "Expected an RDF collection cell at /Patient/name"},
        {"cyclic collection",
            "fhir:name <http://example.org/cycle> . <http://example.org/cycle> rdf:first [ ]; rdf:rest <http://example.org/cycle>",
            "Cycle in RDF collection at /Patient/name"},
        {"two collections for one list", "fhir:name ([ ]), ([ ])",
            "Expected an RDF collection cell at /Patient/name"},
        {"two rdf:first values in one cell", "fhir:name [ rdf:first [ ], [ ]; rdf:rest rdf:nil ]",
            "Expected exactly one rdf:first at /Patient/name"},
        {"unresolved named node", "fhir:active <http://example.org/unresolved>",
            "Unresolved node http://example.org/unresolved at /Patient/active"},
        {"duplicate primitive value", "fhir:active [ fhir:v true, false ]",
            "Expected a literal primitive value at /Patient/active"},
        {"untyped choice", "fhir:deceased [ fhir:v true ]",
            "Missing or unsupported rdf:type for choice at /Patient/deceased"},
        {"ambiguously typed choice", "fhir:deceased [ a fhir:boolean, fhir:Boolean, fhir:dateTime, fhir:DateTime; fhir:v true ]",
            "Ambiguous rdf:type for choice at /Patient/deceased"},
        {"unknown predicate", "fhir:notARealPatientProperty [ fhir:v \"do-not-drop\" ]",
            "Unrecognized predicate 'http://hl7.org/fhir/notARealPatientProperty'"},
        {"list property given a single node", "fhir:name [ fhir:v \"not-a-list\" ]",
            "Expected exactly one rdf:first at /Patient/name"},
        {"nested collection", "fhir:name (([ fhir:v \"nested\" ]))",
            "Expected a URI or blank node at /Patient/name"}};
    String unknownJsonProperty = "{\"resourceType\":\"Patient\",\"notARealPatientProperty\":true}";
    String unknownXmlProperty = "<Patient xmlns=\"http://hl7.org/fhir\"><notARealPatientProperty value=\"true\"/></Patient>";

    List<Arguments> inputs = new ArrayList<>();
    for (String version : R4_FORMAT_VERSIONS) {
      for (String[] names : r4InvalidNames) {
        inputs.add(invalid(version, FhirFormat.TURTLE, names[0], patientTurtle("fhir:Patient.name " + names[1]), names[2]));
      }
    }
    for (String version : List.of(R5, R6)) {
      for (String[] predicates : r5r6InvalidPredicates) {
        inputs.add(invalid(version, FhirFormat.TURTLE, predicates[0], patientTurtle(predicates[1]), predicates[2]));
      }
    }
    // Guards the strict parsing that every round trip in this class relies on.
    for (String version : VERSIONS) {
      inputs.add(invalid(version, FhirFormat.JSON, "unknown property", unknownJsonProperty, "notARealPatientProperty"));
      inputs.add(invalid(version, FhirFormat.XML, "unknown property", unknownXmlProperty, "notARealPatientProperty"));
    }
    return inputs.stream();
  }

  private static Arguments invalid(String version, FhirFormat format, String description, String source, String expectedError) {
    return Arguments.of(version, format, Named.of(description, source), expectedError);
  }

  @ParameterizedTest(name = "{0} {1}: {2}")
  @MethodSource("invalidInputs")
  void rejectsInvalidInput(String version, FhirFormat format, String source, String expectedError) {
    IOException exception = Assertions.assertThrows(IOException.class, () -> contexts.get(version).parse(source, format));
    Assertions.assertTrue(exception.getMessage().contains(expectedError), exception.getMessage());
  }

  static Stream<Arguments> datesOfEachPrecision() {
    List<Arguments> dates = new ArrayList<>();
    for (String version : VERSIONS) {
      for (String date : List.of("2020", "2020-02", "2020-02-03")) {
        dates.add(Arguments.of(version, date));
      }
    }
    return dates.stream();
  }

  @ParameterizedTest
  @MethodSource("datesOfEachPrecision")
  void preservesDatePrecision(String version, String date) throws Exception {
    ParserContext parsers = contexts.get(version);
    String json = "{\"resourceType\":\"Patient\",\"birthDate\":\"" + date + "\"}";
    Element original = parsers.parse(json, FhirFormat.JSON);
    Element restored = roundTrip(parsers, original, FhirFormat.TURTLE);
    assertJsonEquals(JsonParser.parseString(json), toJson(parsers, restored));
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

  @ParameterizedTest(name = "{0}: JSON -> {1} -> Turtle -> {2}")
  @MethodSource("versionsAndFormats")
  void roundTripsOptionalExternalJson(String version, FhirFormat beforeTurtle, FhirFormat afterTurtle) throws Exception {
    String property = EXTERNAL_JSON_PROPERTIES.get(version);
    String sourcePath = System.getProperty(property);
    Assumptions.assumeTrue(sourcePath != null, "Set " + property + " to check an external resource");
    String json = Files.readString(Path.of(sourcePath), StandardCharsets.UTF_8);
    ParserContext parsers = contexts.get(version);
    Element original = parsers.parse(json, FhirFormat.JSON);
    String turtle = parsers.compose(roundTrip(parsers, original, beforeTurtle), FhirFormat.TURTLE);
    Element restored = roundTrip(parsers, parsers.parse(turtle, FhirFormat.TURTLE), afterTurtle);
    assertJsonEquals(JsonParser.parseString(json), toJson(parsers, restored));
  }

  static Stream<Arguments> vettedExamples() {
    String[][] examples = {{R4, "xml/examples/expected/R4/patient-example-f201-roel.xml"},
        {R4, "xml/examples/expected/R4/AllergyIntolerance-example.xml"},
        {R4, "json/examples/expected/R4/structuredefinition-us-core-patient.json"},
        {R4B, "xml/examples/expected/R4/patient-example-f201-roel.xml"},
        {R4B, "xml/examples/expected/R4/AllergyIntolerance-example.xml"},
        {R4B, "json/examples/expected/R4/structuredefinition-us-core-patient.json"},
        {R5, "xml/examples/expected/R5/patient-example-f201-roel.xml"},
        {R5, "xml/examples/expected/R5/patient.profile.xml"},
        {R5, "json/examples/expected/R5/StructureDefinition-patient-eu.json"},
        {R6, "xml/examples/expected/R6/patient-example-f201-roel.xml"},
        {R6, "xml/examples/expected/R6/patient.profile.xml"}};
    List<Arguments> arguments = new ArrayList<>();
    for (String[] example : examples) {
      for (FhirFormat afterTurtle : JSON_AND_XML) {
        arguments.add(Arguments.of(example[0], example[1], afterTurtle));
      }
    }
    return arguments.stream();
  }

  @ParameterizedTest(name = "{0}: {1} -> Turtle -> {2}")
  @MethodSource("vettedExamples")
  void roundTripsVettedExamples(String version, String relativePath, FhirFormat afterTurtle) throws Exception {
    // A missing fixture fails the build. To skip instead, guard with Assumptions.assumeTrue(classLoader.getResource(...) != null).
    Path sourcePath = TurtleGeneratorTestUtils.getResourcePath(Path.of("testUtilities", relativePath));
    ParserContext parsers = contexts.get(version);
    FhirFormat sourceFormat = relativePath.endsWith(".xml") ? FhirFormat.XML : FhirFormat.JSON;
    String source = Files.readString(sourcePath, StandardCharsets.UTF_8);
    Element original = parsers.parse(source, sourceFormat);
    JsonElement expected = sourceFormat == FhirFormat.JSON ? JsonParser.parseString(source) : toJson(parsers, original);
    JsonElement actual = toJson(parsers, roundTrip(parsers, roundTrip(parsers, original, FhirFormat.TURTLE), afterTurtle));
    if (afterTurtle == FhirFormat.XML) {
      expected = normalizeNarrativeLineEndings(expected);
      actual = normalizeNarrativeLineEndings(actual);
    }
    assertJsonEquals(expected, actual);
  }

  /**
   * XML parsing must normalize CRLF to LF, so no XML can return a CRLF narrative verbatim. This is
   * independent of Turtle: plain JSON-XML-JSON loses it too, and the RDF canonicalization proposal records
   * the same limitation for any resource represented as XML during its life cycle.
   */
  private JsonElement normalizeNarrativeLineEndings(JsonElement resource) {
    JsonElement copy = JsonParser.parseString(resource.toString());
    normalizeNarrativeLineEndings(copy, new ArrayDeque<>());
    return copy;
  }

  private void normalizeNarrativeLineEndings(JsonElement node, Deque<String> path) {
    if (node.isJsonObject()) {
      for (String key : new ArrayList<>(node.getAsJsonObject().keySet())) {
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
  @ValueSource(strings = {STU3, R4, R4B, R5, R6})
  void conceptIrisAreDroppedByDefaultOrKeptAsCodingExtensions(String version) throws Exception {
    String json = """
        {"resourceType":"Observation","status":"final","code":{"coding":[
          {"system":"http://loinc.org","code":"8480-6"},{"system":"http://snomed.info/sct","code":"271649006"}]}}
        """;
    ParserContext parsers = contexts.get(version);
    String turtle = parsers.compose(parsers.parse(json, FhirFormat.JSON), FhirFormat.TURTLE);
    Assertions.assertTrue(turtle.contains("loinc:8480-6") && turtle.contains("sct:271649006"), turtle);
    assertJsonEquals(JsonParser.parseString(json), toJson(parsers, parsers.parse(turtle, FhirFormat.TURTLE)));

    ParserContext extensions = ParserContext.fromWorkerContext(parsers.getWorkerContext());
    extensions.setConceptIriHandling(ConceptIriHandling.EXTENSION);
    String expected = """
        {"resourceType":"Observation","status":"final","code":{"coding":[
          {"extension":[{"url":"http://hl7.org/fhir/StructureDefinition/rdf-concept-iri","valueUri":"http://loinc.org/rdf/8480-6"}],
           "system":"http://loinc.org","code":"8480-6"},
          {"extension":[{"url":"http://hl7.org/fhir/StructureDefinition/rdf-concept-iri","valueUri":"http://snomed.info/id/271649006"}],
           "system":"http://snomed.info/sct","code":"271649006"}]}}
        """;
    assertJsonEquals(JsonParser.parseString(expected), toJson(extensions, extensions.parse(turtle, FhirFormat.TURTLE)));
  }

  @ParameterizedTest
  @ValueSource(strings = {R5, R6})
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
    String expected = "{\"resourceType\":\"Observation\",\"status\":\"final\",\"code\":{\"coding\":[{\"system\":\"http://loinc.org\",\"code\":\"8480-6\"}]}}";
    assertJsonEquals(JsonParser.parseString(expected), toJson(contexts.get(version), resource));
  }
}
