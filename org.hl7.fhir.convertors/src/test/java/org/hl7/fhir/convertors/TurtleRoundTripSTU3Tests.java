package org.hl7.fhir.convertors;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import com.google.gson.JsonParser;

import org.hl7.fhir.convertors.loaders.loaderR5.NullLoaderKnowledgeProviderR5;
import org.hl7.fhir.convertors.loaders.loaderR5.R3ToR5Loader;
import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.elementmodel.Manager;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.elementmodel.ParserBase;
import org.hl7.fhir.r5.elementmodel.TurtleParser;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TurtleRoundTripSTU3Tests {
  private static SimpleWorkerContext context;

  @BeforeAll
  static void setup() throws Exception {
    var core = new FilesystemPackageCacheManager.Builder().build().loadPackage("hl7.fhir.r3.core", "3.0.2");
    var loader = new R3ToR5Loader(SimpleWorkerContext.defaultTypesToLoad(), new NullLoaderKnowledgeProviderR5());
    context = TestingUtilities.getWorkerContext(core, loader);
    Assertions.assertEquals("3.0.2", context.getVersion());
  }

  static Stream<Arguments> formats() {
    return Stream.of(FhirFormat.JSON, FhirFormat.XML)
        .flatMap(before -> Stream.of(FhirFormat.JSON, FhirFormat.XML)
            .map(after -> Arguments.of(before, after)));
  }

  @ParameterizedTest(name = "STU3: JSON -> {0} -> Turtle -> {1}")
  @MethodSource("formats")
  void roundTripsResourceSemantics(FhirFormat beforeTurtle, FhirFormat afterTurtle) throws Exception {
    String json = """
        {"resourceType":"Bundle","id":"bundle","type":"collection","entry":[
          {"fullUrl":"http://example.org/Patient/patient","resource":{
            "resourceType":"Patient","id":"patient","active":true,
            "text":{"status":"generated","div":"<div xmlns=\\\"http://www.w3.org/1999/xhtml\\\"><p>Before <b>bold</b> &amp; after.</p></div>"},
            "_active":{"extension":[{"url":"http://example.org/flag","valueString":"reviewed"}]},
            "_birthDate":{"extension":[{"url":"http://example.org/missing","valueCode":"unknown"}]},
            "contained":[{"resourceType":"Organization","id":"org","name":"Example"}],
            "name":[{"family":"First","given":["A",null,"C"],"_given":[null,
              {"extension":[{"url":"http://example.org/missing","valueCode":"unknown"}]},null]},
              {"family":"Second","given":["D","E"]}],
            "deceasedBoolean":false,"managingOrganization":{"reference":"#org"}}},
          {"fullUrl":"http://example.org/Observation/observation","resource":{
            "resourceType":"Observation","id":"observation","status":"final",
            "code":{"coding":[{"system":"http://loinc.org","code":"8480-6"}]},
            "context":{"reference":"Encounter/stu3-encounter"},
            "subject":{"reference":"Patient/patient"},
            "performer":[{"reference":"Practitioner?identifier=http://hl7.org/fhir/sid/us-npi|9999959197"}],
            "effectiveDateTime":"2012-09-17T12:34:56.012300+10:00",
            "valueQuantity":{"value":107.12500000000000001,"unit":"mmHg"},
            "component":[{"code":{"text":"First"},"valueString":"one"},
              {"code":{"text":"Second"},"valueDateTime":"2020-02-03"}]}}]}
        """;
    Element original = parse(json, FhirFormat.JSON);
    Element before = roundTrip(original, beforeTurtle);
    String turtle = compose(before, FhirFormat.TURTLE);
    for (String fragment : List.of("fhir:Bundle.entry.resource", "fhir:Patient.name", "fhir:index",
        "fhir:value", "fhir:Observation.context", "us-npi%7C9999959197>")) {
      Assertions.assertTrue(turtle.contains(fragment), () -> fragment + " missing from\n" + turtle);
    }
    Element restored = roundTrip(parse(turtle, FhirFormat.TURTLE), afterTurtle);
    var expected = JsonParser.parseString(json);
    var actual = JsonParser.parseString(compose(restored, FhirFormat.JSON));
    Assertions.assertEquals(expected, actual);
    var expectedValue = expected.getAsJsonObject().getAsJsonArray("entry").get(1).getAsJsonObject()
        .getAsJsonObject("resource").getAsJsonObject("valueQuantity").get("value").getAsBigDecimal();
    var actualValue = actual.getAsJsonObject().getAsJsonArray("entry").get(1).getAsJsonObject()
        .getAsJsonObject("resource").getAsJsonObject("valueQuantity").get("value").getAsBigDecimal();
    Assertions.assertEquals(0, expectedValue.compareTo(actualValue));
  }

  private static Element roundTrip(Element resource, FhirFormat format) throws Exception {
    return parse(compose(resource, format), format);
  }

  private static Element parse(String source, FhirFormat format) throws Exception {
    ParserBase parser = Manager.makeParser(context, format);
    parser.setupValidation(ParserBase.ValidationPolicy.EVERYTHING);
    List<ValidationMessage> errors = new ArrayList<>();
    Element resource = parser.parseSingle(new ByteArrayInputStream(source.getBytes(StandardCharsets.UTF_8)), errors);
    Assertions.assertNotNull(resource);
    Assertions.assertFalse(errors.stream().anyMatch(message -> message.getLevel() == IssueSeverity.ERROR
        || message.getLevel() == IssueSeverity.FATAL), () -> errors.toString());
    return resource;
  }

  private static String compose(Element resource, FhirFormat format) throws Exception {
    ParserBase parser = Manager.makeParser(context, format);
    if (parser instanceof TurtleParser) {
      ((TurtleParser) parser).setCanonicalizeXhtml(false);
    }
    ByteArrayOutputStream output = new ByteArrayOutputStream();
    parser.compose(resource, output, OutputStyle.PRETTY, null);
    return output.toString(StandardCharsets.UTF_8);
  }
}