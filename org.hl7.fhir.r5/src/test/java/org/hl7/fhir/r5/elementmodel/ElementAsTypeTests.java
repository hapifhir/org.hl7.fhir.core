package org.hl7.fhir.r5.elementmodel;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

import org.hl7.fhir.r5.model.DataType;
import org.hl7.fhir.r5.model.StructureDefinition;
import org.hl7.fhir.r5.model.StructureDefinition.StructureDefinitionKind;
import org.hl7.fhir.r5.model.StructureDefinition.TypeDerivationRule;
import org.hl7.fhir.r5.model.XhtmlType;
import org.hl7.fhir.r5.formats.JsonCreatorDirect;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.utilities.json.model.JsonArray;
import org.hl7.fhir.utilities.json.model.JsonElement;
import org.hl7.fhir.utilities.json.model.JsonObject;
import org.hl7.fhir.utilities.json.model.JsonPrimitive;
import org.hl7.fhir.utilities.json.model.JsonProperty;
import org.hl7.fhir.utilities.json.parser.JsonParser;
import org.hl7.fhir.utilities.xhtml.XhtmlComposer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * Tests for Element.asType() in the element model - converting an element model node into the
 * equivalent object model DataType (this is what TypeConvertor.castToType etc use when handed an
 * element model node).
 *
 * Every R5 data type is tested with a sample value, in several variants:
 *
 *   primitives: with a value; with a value, an id and an extension; with an extension and no value
 *   complex:    plain; with id + extensions (+ modifierExtension for BackboneTypes) on the type itself;
 *               with an extension on every primitive child (values kept); with an extension on every
 *               primitive child and the values removed
 *
 * The same JSON is parsed by the element model parser (then asType()) and by the object model
 * parser, and the two results must be the same class and serialise identically.
 */
class ElementAsTypeTests {

  private static final String EXT_URL = "http://example.org/fhir/StructureDefinition/astype-test";

  // -- sample values -------------------------------------------------------------------------

  private static final Map<String, String> PRIMITIVES = new LinkedHashMap<>();
  static {
    PRIMITIVES.put("base64Binary", "\"SGVsbG8gV29ybGQ=\"");
    PRIMITIVES.put("boolean", "true");
    PRIMITIVES.put("canonical", "\"http://example.org/fhir/StructureDefinition/test|1.0.0\"");
    PRIMITIVES.put("code", "\"active\"");
    PRIMITIVES.put("date", "\"2026-09-19\"");
    PRIMITIVES.put("dateTime", "\"2026-09-19T10:15:30+10:00\"");
    PRIMITIVES.put("decimal", "1.50");
    PRIMITIVES.put("id", "\"a-1.b\"");
    PRIMITIVES.put("instant", "\"2026-09-19T10:15:30.123Z\"");
    PRIMITIVES.put("integer", "-42");
    PRIMITIVES.put("integer64", "\"9007199254740993\"");
    PRIMITIVES.put("markdown", "\"Some **bold** text\"");
    PRIMITIVES.put("oid", "\"urn:oid:1.2.36.146.595.217.0.1\"");
    PRIMITIVES.put("positiveInt", "5");
    PRIMITIVES.put("string", "\"hello world\"");
    PRIMITIVES.put("time", "\"10:15:30\"");
    PRIMITIVES.put("unsignedInt", "0");
    PRIMITIVES.put("uri", "\"http://example.org/fhir\"");
    PRIMITIVES.put("url", "\"https://example.org/page.html\"");
    PRIMITIVES.put("uuid", "\"urn:uuid:c757873d-ec9a-4326-a141-556f43239520\"");
    PRIMITIVES.put("xhtml", "\"<div xmlns=\\\"http://www.w3.org/1999/xhtml\\\"><p>Hello <b>World</b></p></div>\"");
  }

  private static final String CODING = """
      {"system":"http://snomed.info/sct","version":"http://snomed.info/sct/32506021000036107/version/20260831","code":"38341003","display":"Hypertension","userSelected":true}""";
  private static final String QUANTITY = """
      {"value":5.50,"comparator":"<","unit":"mg","system":"http://unitsofmeasure.org","code":"mg"}""";

  private static final Map<String, String> COMPLEX = new LinkedHashMap<>();
  static {
    COMPLEX.put("Address", """
        {"use":"home","type":"both","text":"1 Main St, Brisbane","line":["1 Main St","Unit 2"],"city":"Brisbane","district":"Brisbane City",
         "state":"QLD","postalCode":"4000","country":"AU","period":{"start":"2020-01-01"}}""");
    COMPLEX.put("Age", """
        {"value":42,"unit":"years","system":"http://unitsofmeasure.org","code":"a"}""");
    COMPLEX.put("Annotation", """
        {"authorString":"Dr Smith","time":"2026-09-19T10:00:00Z","text":"A **note**"}""");
    COMPLEX.put("Attachment", """
        {"contentType":"text/plain","language":"en","data":"SGVsbG8=","url":"http://example.org/doc.txt","size":"5","hash":"SGVsbG8=",
         "title":"Greeting","creation":"2026-09-19","height":10,"width":20,"frames":1,"duration":1.5,"pages":2}""");
    COMPLEX.put("Availability", """
        {"availableTime":[{"daysOfWeek":["mon","tue"],"allDay":false,"availableStartTime":"09:00:00","availableEndTime":"17:00:00"}],
         "notAvailableTime":[{"description":"Christmas","during":{"start":"2026-12-25","end":"2026-12-26"}}]}""");
    COMPLEX.put("CodeableConcept", """
        {"coding":[CODING],"text":"Hypertension"}""".replace("CODING", CODING));
    COMPLEX.put("CodeableReference", """
        {"concept":{"text":"a concept"},"reference":{"reference":"Patient/example"}}""");
    COMPLEX.put("Coding", CODING);
    COMPLEX.put("ContactDetail", """
        {"name":"Contact","telecom":[{"system":"email","value":"a@example.org"}]}""");
    COMPLEX.put("ContactPoint", """
        {"system":"phone","value":"+61 7 5555 5555","use":"work","rank":1,"period":{"start":"2020-01-01"}}""");
    COMPLEX.put("Contributor", """
        {"type":"author","name":"John Smith","contact":[{"name":"John","telecom":[{"system":"email","value":"john@example.org"}]}]}""");
    COMPLEX.put("Count", """
        {"value":3,"system":"http://unitsofmeasure.org","code":"1"}""");
    COMPLEX.put("DataRequirement", """
        {"type":"Observation","profile":["http://example.org/fhir/StructureDefinition/obs"],"subjectCodeableConcept":{"text":"Patient"},
         "mustSupport":["code","value"],
         "codeFilter":[{"path":"code","valueSet":"http://example.org/fhir/ValueSet/codes","code":[CODING]}],
         "dateFilter":[{"path":"effective","valuePeriod":{"start":"2026-01-01"}}],
         "valueFilter":[{"path":"value","comparator":"gt","valueDateTime":"2026-01-01T00:00:00Z"}],
         "limit":10,"sort":[{"path":"effective","direction":"descending"}]}""".replace("CODING", CODING));
    COMPLEX.put("Distance", """
        {"value":1.2,"unit":"km","system":"http://unitsofmeasure.org","code":"km"}""");
    COMPLEX.put("Dosage", """
        {"sequence":1,"text":"1 tablet daily","additionalInstruction":[{"text":"with food"}],"patientInstruction":"Take with water",
         "timing":{"repeat":{"frequency":1,"period":1,"periodUnit":"d"}},"asNeeded":false,"asNeededFor":[{"text":"pain"}],
         "site":{"text":"arm"},"route":{"text":"oral"},"method":{"text":"swallow"},
         "doseAndRate":[{"type":{"text":"ordered"},"doseQuantity":QUANTITY,"rateRatio":{"numerator":{"value":1,"unit":"tablet"},"denominator":{"value":1,"unit":"d"}}}],
         "maxDosePerPeriod":[{"numerator":{"value":4,"unit":"tablet"},"denominator":{"value":1,"unit":"d"}}],
         "maxDosePerAdministration":{"value":2,"unit":"tablet"},"maxDosePerLifetime":{"value":100,"unit":"tablet"}}""".replace("QUANTITY", QUANTITY));
    COMPLEX.put("Duration", """
        {"value":30,"unit":"min","system":"http://unitsofmeasure.org","code":"min"}""");
    COMPLEX.put("ElementDefinition", """
        {"path":"Patient.name","representation":["xmlAttr"],"sliceName":"official","sliceIsConstraining":false,"label":"Name","code":[CODING],
         "slicing":{"discriminator":[{"type":"value","path":"use"}],"description":"by use","ordered":false,"rules":"open"},
         "short":"A name","definition":"The **name**","comment":"A comment","requirements":"Requirements","alias":["n","nm"],
         "min":0,"max":"*","base":{"path":"Patient.name","min":0,"max":"*"},
         "type":[{"code":"HumanName","profile":["http://example.org/fhir/StructureDefinition/hn"],"aggregation":["contained"],"versioning":"either"}],
         "defaultValueString":"x","meaningWhenMissing":"nothing","orderMeaning":"by preference","patternHumanName":{"use":"official"},
         "example":[{"label":"example","valueHumanName":{"family":"Smith"}}],"minValueInteger":1,"maxValueQuantity":QUANTITY,"maxLength":100,"condition":["ele-1"],
         "constraint":[{"key":"test-1","severity":"error","human":"must have a family name","expression":"family.exists()",
                        "source":"http://example.org/fhir/StructureDefinition/hn"}],
         "mustHaveValue":false,"valueAlternatives":["http://example.org/fhir/StructureDefinition/alt"],"mustSupport":true,"isModifier":false,"isSummary":true,
         "binding":{"strength":"required","description":"name uses","valueSet":"http://hl7.org/fhir/ValueSet/name-use",
                    "additional":[{"purpose":"extensible","valueSet":"http://example.org/fhir/ValueSet/extra",
                                   "usage":[{"code":{"system":"http://terminology.hl7.org/CodeSystem/usage-context-type","code":"focus"},"valueCodeableConcept":{"text":"x"}}],
                                   "any":false}]},
         "mapping":[{"identity":"rim","language":"text/plain","map":"PN","comment":"a note"}]}""".replace("CODING", CODING).replace("QUANTITY", QUANTITY));
    COMPLEX.put("Expression", """
        {"description":"test expression","name":"expr1","language":"text/fhirpath","expression":"Patient.name","reference":"http://example.org/expr"}""");
    COMPLEX.put("ExtendedContactDetail", """
        {"purpose":{"text":"billing"},"name":[{"family":"Smith"}],"telecom":[{"system":"phone","value":"123"}],"address":{"city":"Brisbane"},
         "organization":{"reference":"Organization/1"},"period":{"start":"2020-01-01"}}""");
    COMPLEX.put("Extension", """
        {"url":"http://example.org/fhir/StructureDefinition/sample","valueString":"sample value"}""");
    COMPLEX.put("HumanName", """
        {"use":"official","text":"Dr John Q Smith Jr","family":"Smith","given":["John","Q"],"prefix":["Dr"],"suffix":["Jr"],"period":{"start":"2000-01-01"}}""");
    COMPLEX.put("Identifier", """
        {"use":"official","type":{"text":"MRN"},"system":"http://example.org/mrn","value":"12345","period":{"start":"2020-01-01"},
         "assigner":{"display":"Example Hospital"}}""");
    COMPLEX.put("MarketingStatus", """
        {"country":{"text":"AU"},"jurisdiction":{"text":"QLD"},"status":{"text":"active"},"dateRange":{"start":"2020-01-01"},"restoreDate":"2026-01-01T00:00:00Z"}""");
    COMPLEX.put("Meta", """
        {"versionId":"1","lastUpdated":"2026-09-19T10:15:30.123Z","source":"http://example.org/source","profile":["http://example.org/fhir/StructureDefinition/p"],
         "security":[{"system":"http://terminology.hl7.org/CodeSystem/v3-Confidentiality","code":"N"}],"tag":[{"system":"http://example.org/tags","code":"t1"}]}""");
    COMPLEX.put("MonetaryComponent", """
        {"type":"base","code":{"text":"base price"},"factor":1.5,"amount":{"value":10.00,"currency":"AUD"}}""");
    COMPLEX.put("Money", """
        {"value":10.50,"currency":"AUD"}""");
    COMPLEX.put("Narrative", """
        {"status":"generated","div":"<div xmlns=\\"http://www.w3.org/1999/xhtml\\"><p>Hello <b>World</b></p></div>"}""");
    COMPLEX.put("ParameterDefinition", """
        {"name":"p1","use":"in","min":0,"max":"1","documentation":"a parameter","type":"string","profile":"http://example.org/fhir/StructureDefinition/p"}""");
    COMPLEX.put("Period", """
        {"start":"2026-01-01","end":"2026-12-31T23:59:59Z"}""");
    COMPLEX.put("ProductShelfLife", """
        {"type":{"text":"shelf life"},"periodDuration":{"value":2,"unit":"a"},"specialPrecautionsForStorage":[{"text":"keep cool"}]}""");
    COMPLEX.put("Quantity", QUANTITY);
    COMPLEX.put("Range", """
        {"low":{"value":1,"unit":"mg"},"high":{"value":5,"unit":"mg"}}""");
    COMPLEX.put("Ratio", """
        {"numerator":{"value":1,"unit":"mg"},"denominator":{"value":1,"unit":"mL"}}""");
    COMPLEX.put("RatioRange", """
        {"lowNumerator":{"value":1,"unit":"mg"},"highNumerator":{"value":5,"unit":"mg"},"denominator":{"value":1,"unit":"mL"}}""");
    COMPLEX.put("Reference", """
        {"reference":"Patient/example","type":"Patient","identifier":{"system":"http://example.org/mrn","value":"12345"},"display":"John Smith"}""");
    COMPLEX.put("RelatedArtifact", """
        {"type":"citation","classifier":[{"text":"journal article"}],"label":"1","display":"A paper","citation":"Smith J. *A paper*",
         "document":{"contentType":"application/pdf","url":"http://example.org/paper.pdf"},"resource":"http://example.org/fhir/Library/lib",
         "resourceReference":{"reference":"Library/lib"},"publicationStatus":"active","publicationDate":"2026-01-01"}""");
    COMPLEX.put("SampledData", """
        {"origin":{"value":0,"unit":"mV"},"interval":10,"intervalUnit":"ms","factor":1.5,"lowerLimit":-100,"upperLimit":100,"dimensions":1,
         "codeMap":"http://example.org/fhir/ConceptMap/cm","offsets":"0 10 20","data":"1 2 3 E U L"}""");
    COMPLEX.put("Signature", """
        {"type":[{"system":"urn:iso-astm:E1762-95:2013","code":"1.2.840.10065.1.12.1.1"}],"when":"2026-09-19T10:15:30Z","who":{"reference":"Practitioner/1"},
         "onBehalfOf":{"reference":"Organization/1"},"targetFormat":"application/fhir+json","sigFormat":"application/jose","data":"SGVsbG8="}""");
    COMPLEX.put("Timing", """
        {"event":["2026-09-19T08:00:00Z","2026-09-20T08:00:00Z"],
         "repeat":{"boundsPeriod":{"start":"2026-09-19"},"count":10,"countMax":12,"duration":1.5,"durationMax":2,"durationUnit":"h",
                   "frequency":2,"frequencyMax":3,"period":1,"periodMax":2,"periodUnit":"d",
                   "dayOfWeek":["mon","wed"],"timeOfDay":["08:00:00","20:00:00"],"when":["MORN"],"offset":30},
         "code":{"text":"BID"}}""");
    COMPLEX.put("TriggerDefinition", """
        {"type":"named-event","name":"admission","code":{"text":"admit"},"subscriptionTopic":"http://example.org/fhir/SubscriptionTopic/t",
         "timingDateTime":"2026-09-19T10:00:00Z","data":[{"type":"Encounter"}],"condition":{"language":"text/fhirpath","expression":"true"}}""");
    COMPLEX.put("UsageContext", """
        {"code":{"system":"http://terminology.hl7.org/CodeSystem/usage-context-type","code":"focus"},"valueCodeableConcept":{"text":"adults"}}""");
    COMPLEX.put("VirtualServiceDetail", """
        {"channelType":{"system":"http://hl7.org/fhir/virtual-service-type","code":"zoom"},"addressUrl":"https://zoom.example.org/j/123",
         "additionalInfo":["https://example.org/info"],"maxParticipants":10,"sessionKey":"abc"}""");
  }

  enum Variant {
    VALUE,          // primitive: value only
    VALUE_EXT,      // primitive: value + id + extension
    EXT_ONLY,       // primitive: id + extension, no value
    PLAIN,          // complex: the sample as is
    EXT,            // complex: id + extensions (and modifierExtension on BackboneTypes) on the type itself
    CHILD_EXT,      // complex: an extension on every primitive child, values kept
    CHILD_EXT_ONLY  // complex: an extension on every primitive child, values removed
  }

  // -- test cases ----------------------------------------------------------------------------

  static Stream<Arguments> cases() {
    List<Arguments> list = new ArrayList<>();
    for (String type : PRIMITIVES.keySet()) {
      if ("xhtml".equals(type)) {
        list.add(Arguments.of(type, Variant.VALUE)); // xhtml can't have an id or extensions
      } else {
        for (Variant v : new Variant[] { Variant.VALUE, Variant.VALUE_EXT, Variant.EXT_ONLY }) {
          list.add(Arguments.of(type, v));
        }
      }
    }
    for (String type : COMPLEX.keySet()) {
      for (Variant v : new Variant[] { Variant.PLAIN, Variant.EXT, Variant.CHILD_EXT, Variant.CHILD_EXT_ONLY }) {
        list.add(Arguments.of(type, v));
      }
    }
    return list.stream();
  }

  /**
   * Every concrete data type in the R5 core package must have a sample here (so that new types
   * get tests), and every sample must be a concrete data type in R6
   */
  @Test
  void testAllDataTypesCovered() {
    IWorkerContext context = TestingUtilities.getSharedWorkerContext();
    Set<String> types = new TreeSet<>();
    for (StructureDefinition sd : context.fetchResourcesByType(StructureDefinition.class)) {
      if (sd.getUrl().startsWith("http://hl7.org/fhir/StructureDefinition/") && !sd.getAbstract()
          && (sd.getKind() == StructureDefinitionKind.PRIMITIVETYPE || sd.getKind() == StructureDefinitionKind.COMPLEXTYPE)
          && sd.getDerivation() == TypeDerivationRule.SPECIALIZATION) {
        types.add(sd.getType());
      }
    }
    Set<String> samples = new TreeSet<>(PRIMITIVES.keySet());
    samples.addAll(COMPLEX.keySet());
    Set<String> missing = new TreeSet<>(types);
    missing.removeAll(samples);
    Set<String> extra = new TreeSet<>(samples);
    extra.removeAll(types);
    Assertions.assertTrue(missing.isEmpty(), "Data types with no sample: " + missing);
    Assertions.assertTrue(extra.isEmpty(), "Samples that aren't R5 data types: " + extra);
  }

  @ParameterizedTest(name = "{index}: {0} {1}")
  @MethodSource("cases")
  void testAsType(String type, Variant variant) throws Exception {
    IWorkerContext context = TestingUtilities.getSharedWorkerContext();
    TypeJsonParser modelParser = new TypeJsonParser(context);

    // the same content, in two wrappers: {"value": .., "_value": ..} for the element model
    // (a property of the stated type), and {"valueX": .., "_valueX": ..} for the object model (a choice)
    JsonElement value = null;
    JsonObject primitiveElement = null;
    if (PRIMITIVES.containsKey(type)) {
      JsonElement sample = parseFragment(PRIMITIVES.get(type));
      switch (variant) {
      case VALUE:
        value = sample;
        break;
      case VALUE_EXT:
        value = sample;
        primitiveElement = new JsonObject();
        primitiveElement.add("id", "p1");
        primitiveElement.add("extension", new JsonArray().add(simpleExtension()));
        break;
      case EXT_ONLY:
        primitiveElement = new JsonObject();
        primitiveElement.add("id", "p1");
        primitiveElement.add("extension", new JsonArray().add(simpleExtension()));
        break;
      default:
        throw new Error("Variant " + variant + " is not for primitives");
      }
    } else {
      JsonObject sample = (JsonObject) parseFragment(COMPLEX.get(type));
      switch (variant) {
      case PLAIN:
        break;
      case EXT:
        addExtensions(context, type, sample);
        break;
      case CHILD_EXT:
        extendPrimitives(sample, "Extension".equals(type), true);
        break;
      case CHILD_EXT_ONLY:
        extendPrimitives(sample, "Extension".equals(type), false);
        break;
      default:
        throw new Error("Variant " + variant + " is not for complex types");
      }
      value = sample;
    }
    String emJson = JsonParser.compose(wrap("value", value, primitiveElement), false);

    // parse with the element model, and convert
    Element wrapper = new org.hl7.fhir.r5.elementmodel.JsonParser(context).parse(emJson, type, true);
    Assertions.assertNotNull(wrapper, "Element model parse failed for " + emJson);
    Element e = wrapper.getNamedChild("value", false);
    Assertions.assertNotNull(e, "Element model parse lost the value for " + emJson);
    DataType actual = e.asType();
    Assertions.assertNotNull(actual, "asType() returned null for " + emJson);
    Assertions.assertEquals(type, actual.fhirType());

    if ("xhtml".equals(type)) {
      // not a type the object model parses on its own
      Assertions.assertInstanceOf(XhtmlType.class, actual);
      Assertions.assertNotNull(actual.getXhtml(), "No xhtml in the converted type");
      Assertions.assertEquals(value.asString(), new XhtmlComposer(true, false).compose(actual.getXhtml()));
    } else {
      // parse with the object model, which is what asType() should produce
      String choiceName = "value" + Character.toUpperCase(type.charAt(0)) + type.substring(1);
      String omJson = JsonParser.compose(wrap(choiceName, value, primitiveElement), false);
      DataType expected = modelParser.parseValue(omJson, choiceName.substring(0, 5));
      Assertions.assertNotNull(expected, "Object model parse failed for " + omJson);
      Assertions.assertEquals(expected.getClass(), actual.getClass());
      Assertions.assertEquals(modelParser.composeValue(expected), modelParser.composeValue(actual));
      Assertions.assertTrue(expected.equalsDeep(actual), "equalsDeep failed");
    }
  }

  // -- building the test content -------------------------------------------------------------

  private static JsonElement parseFragment(String json) throws IOException {
    return JsonParser.parseObject("{\"v\":" + json + "}").get("v");
  }

  private static JsonObject wrap(String name, JsonElement value, JsonObject primitiveElement) {
    JsonObject wrapper = new JsonObject();
    if (value != null) {
      wrapper.add(name, value);
    }
    if (primitiveElement != null) {
      wrapper.add("_" + name, primitiveElement);
    }
    return wrapper;
  }

  private static JsonObject simpleExtension() {
    JsonObject ext = new JsonObject();
    ext.add("url", EXT_URL);
    ext.add("valueString", "extension value");
    return ext;
  }

  private static JsonObject complexExtension() {
    JsonObject coding = new JsonObject();
    coding.add("system", "http://example.org/fhir/CodeSystem/test");
    coding.add("code", "c1");
    JsonObject part1 = new JsonObject();
    part1.add("url", "part");
    part1.add("valueCoding", coding);
    JsonObject part2 = new JsonObject();
    part2.add("url", "when");
    part2.add("valueDateTime", "2026-09-19");
    JsonObject ext = new JsonObject();
    ext.add("url", EXT_URL + "-complex");
    ext.add("extension", new JsonArray().add(part1).add(part2));
    return ext;
  }

  private static void addExtensions(IWorkerContext context, String type, JsonObject sample) {
    List<JsonProperty> props = new ArrayList<>(sample.getProperties());
    sample.clear();
    sample.add("id", "c1");
    sample.add("extension", new JsonArray().add(simpleExtension()).add(complexExtension()));
    StructureDefinition sd = context.fetchTypeDefinition(type);
    if (sd.getBaseDefinition().endsWith("/BackboneType")) {
      JsonObject mod = new JsonObject();
      mod.add("url", EXT_URL + "-modifier");
      mod.add("valueBoolean", true);
      sample.add("modifierExtension", new JsonArray().add(mod));
    }
    for (JsonProperty p : props) {
      sample.add(p.getName(), p.getValue());
    }
  }

  /**
   * give every primitive property (in any object, at any depth) an extension, with or without
   * keeping its value. Skips things that are not FHIR primitive elements in JSON (id, extension url,
   * Narrative.div)
   */
  private static void extendPrimitives(JsonObject obj, boolean isExtension, boolean keepValue) {
    List<JsonProperty> props = new ArrayList<>(obj.getProperties());
    obj.clear();
    for (JsonProperty p : props) {
      String name = p.getName();
      JsonElement v = p.getValue();
      boolean skip = name.startsWith("_") || "id".equals(name) || "div".equals(name) || (isExtension && "url".equals(name));
      if (skip) {
        obj.add(name, v);
      } else if (v instanceof JsonPrimitive) {
        if (keepValue) {
          obj.add(name, v);
        }
        obj.add("_" + name, primitiveExtension());
      } else if (v instanceof JsonArray && isPrimitiveArray((JsonArray) v)) {
        JsonArray ext = new JsonArray();
        for (int i = 0; i < ((JsonArray) v).size(); i++) {
          ext.add(primitiveExtension());
        }
        if (keepValue) {
          obj.add(name, v);
        }
        obj.add("_" + name, ext);
      } else if (v instanceof JsonArray) {
        boolean ext = "extension".equals(name) || "modifierExtension".equals(name);
        for (JsonElement item : ((JsonArray) v).getItems()) {
          if (item instanceof JsonObject) {
            extendPrimitives((JsonObject) item, ext, keepValue);
          }
        }
        obj.add(name, v);
      } else if (v instanceof JsonObject) {
        extendPrimitives((JsonObject) v, false, keepValue);
        obj.add(name, v);
      } else {
        obj.add(name, v);
      }
    }
  }

  private static boolean isPrimitiveArray(JsonArray arr) {
    for (JsonElement item : arr.getItems()) {
      if (!(item instanceof JsonPrimitive)) {
        return false;
      }
    }
    return arr.size() > 0;
  }

  private static JsonObject primitiveExtension() {
    JsonObject pe = new JsonObject();
    pe.add("extension", new JsonArray().add(simpleExtension()));
    return pe;
  }

  // -- object model access -------------------------------------------------------------------

  /**
   * gives access to the object model parser's choice type parsing and composing (protected)
   */
  private static class TypeJsonParser extends org.hl7.fhir.r5.formats.JsonParser {

    TypeJsonParser(IWorkerContext context) {
      super();
    }

    DataType parseValue(String json, String prefix) throws Exception {
      com.google.gson.JsonObject obj = com.google.gson.JsonParser.parseString(json).getAsJsonObject();
      return parseType(prefix, obj);
    }

    String composeValue(DataType value) throws IOException {
      StringWriter sw = new StringWriter();
      json = new JsonCreatorDirect(sw, true, false);
      json.beginObject();
      composeType("value", value);
      json.endObject();
      json.finish();
      return sw.toString();
    }
  }
}
