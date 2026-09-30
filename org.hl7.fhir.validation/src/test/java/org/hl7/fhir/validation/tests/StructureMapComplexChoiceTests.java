package org.hl7.fhir.validation.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.stream.Stream;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.model.Base;
import org.hl7.fhir.model.core.Observation;
import org.hl7.fhir.model.core.StructureDefinition;
import org.hl7.fhir.model.utilities.formats.FhirFormat;
import org.hl7.fhir.model.utilities.formats.OutputStyle;
import org.hl7.fhir.services.elementmodel.Element;
import org.hl7.fhir.services.elementmodel.JsonParser;
import org.hl7.fhir.services.elementmodel.Manager;
import org.hl7.fhir.services.elementmodel.ObjectConverter;
import org.hl7.fhir.services.fml.StructureMapTools;
import org.hl7.fhir.services.testing.CompareUtilities;
import org.hl7.fhir.standalone.context.SimpleWorkerContext;
import org.hl7.fhir.standalone.testing.TestingUtilities;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class StructureMapComplexChoiceTests {

  private enum Model {
    ELEMENT, OBJECT
  }

  private record TransformCase(String name, String rule, String inputJson, String expectedJson) {
  }

  private static final String OBSERVATION_URL = "http://hl7.org/fhir/StructureDefinition/Observation";
  private static final String INPUT_JSON = """
    {"resourceType": "Observation"}
    """;
  private static final String FML = """
    map "http://example.org/StructureMap/ComplexChoice" = "ComplexChoice"

    uses "http://hl7.org/fhir/StructureDefinition/Observation" as source
    uses "http://hl7.org/fhir/StructureDefinition/Observation" as target

    group ComplexChoice(source src : Observation, target tgt : Observation) {
      %s
    }
    """;
  private static final String QUANTITY_JSON = """
    {
      "resourceType": "Observation",
      "valueQuantity": {
        "value": 42,
        "unit": "kg",
        "system": "http://unitsofmeasure.org",
        "code": "kg"
      }
    }
    """;
  private static final String CODEABLE_CONCEPT_JSON = """
    {
      "resourceType": "Observation",
      "valueCodeableConcept": {
        "coding": [{
          "system": "Non coded text",
          "code": "oth"
        }]
      }
    }
    """;

  private static org.hl7.fhir.r5.context.SimpleWorkerContext contextR5;
  private static SimpleWorkerContext contextR6;

  @BeforeAll
  static void setUp() throws Exception {
    var pcm = new FilesystemPackageCacheManager.Builder().build();
    contextR5 = org.hl7.fhir.r5.test.utils.TestingUtilities.getWorkerContext(pcm.loadPackage("hl7.fhir.r5.core", "5.0.0"));
    contextR6 = TestingUtilities.getWorkerContext(pcm.loadPackage("hl7.fhir.r6.core", "6.0.0-snapshot1"));
  }

  static Stream<Arguments> complexChoiceTransforms() {
    return Stream.of(
      new TransformCase("qty into value",
        "src -> tgt.value = qty(42, 'kg', 'http://unitsofmeasure.org', 'kg') \"quantity\";",
        INPUT_JSON, QUANTITY_JSON),
      new TransformCase("cc into value",
        "src -> tgt.value = cc('Non coded text', 'oth') \"codeableConcept\";",
        INPUT_JSON, CODEABLE_CONCEPT_JSON),
      new TransformCase("qty into valueQuantity",
        "src -> tgt.valueQuantity = qty(42, 'kg', 'http://unitsofmeasure.org', 'kg') \"quantity\";",
        INPUT_JSON, QUANTITY_JSON),
      new TransformCase("c into Extension.valueCodeableConcept.coding",
        """
        src -> tgt.extension as ext,
          ext.url = 'http://example.org/StructureDefinition/complex-choice',
          ext.value = cc('A coded value') as v then {
          src -> v.coding = c('http://example.org/cs', 'test', 'Test Coding') "coding";
        } "extension";
        """,
        INPUT_JSON,
        """
        {
          "resourceType": "Observation",
          "extension": [{
            "url": "http://example.org/StructureDefinition/complex-choice",
            "valueCodeableConcept": {
              "text": "A coded value",
              "coding": [{
                "system": "http://example.org/cs",
                "code": "test",
                "display": "Test Coding"
              }]
            }
          }]
        }
        """),
      new TransformCase("copy Quantity into value",
        "src.value as v -> tgt.value = copy(v) \"copyQuantity\";",
        QUANTITY_JSON, QUANTITY_JSON),
      new TransformCase("copy CodeableConcept into value",
        "src.value as v -> tgt.value = copy(v) \"copyCodeableConcept\";",
        CODEABLE_CONCEPT_JSON, CODEABLE_CONCEPT_JSON),
      new TransformCase("primitive into value",
        "src -> tgt.value = 'some text' \"stringValue\";",
        INPUT_JSON,
        """
        {"resourceType": "Observation", "valueString": "some text"}
        """),
      new TransformCase("primitive into non-choice status",
        "src -> tgt.status = 'final' \"status\";",
        INPUT_JSON,
        """
        {"resourceType": "Observation", "status": "final"}
        """),
      new TransformCase("cc into valueCodeableConcept",
        "src -> tgt.valueCodeableConcept = cc('Non coded text', 'oth') \"codeableConcept\";",
        INPUT_JSON, CODEABLE_CONCEPT_JSON),
      new TransformCase("copy Quantity into valueQuantity",
        "src.value as v -> tgt.valueQuantity = copy(v) \"copyQuantity\";",
        QUANTITY_JSON, QUANTITY_JSON),
      new TransformCase("copy CodeableConcept into valueCodeableConcept",
        "src.value as v -> tgt.valueCodeableConcept = copy(v) \"copyCodeableConcept\";",
        CODEABLE_CONCEPT_JSON, CODEABLE_CONCEPT_JSON),
      new TransformCase("primitive into valueString",
        "src -> tgt.valueString = 'some text' \"stringValue\";",
        INPUT_JSON,
        """
        {"resourceType": "Observation", "valueString": "some text"}
        """),
      new TransformCase("replace valueString without repeating its suffix",
        """
        src -> tgt.valueString = 'before' "first";
        src -> tgt.valueString = 'after' "second";
        """,
        INPUT_JSON,
        """
        {"resourceType": "Observation", "valueString": "after"}
        """)
    ).flatMap(testCase -> Stream.of(Model.values()).flatMap(sourceModel ->
      Stream.of(Model.values()).map(targetModel ->
        Arguments.of(testCase.name(), testCase.rule(), testCase.inputJson(), testCase.expectedJson(), sourceModel, targetModel))));
  }

  static Stream<Arguments> convertedChoiceValues() {
    return Stream.of(
      Arguments.of("Quantity", QUANTITY_JSON),
      Arguments.of("CodeableConcept", CODEABLE_CONCEPT_JSON)
    );
  }

  static Stream<Arguments> choicePropertyNames() {
    return Stream.of("Quantity", "CodeableConcept").flatMap(type ->
      Stream.of("value", "value[x]", "value" + type).map(name ->
        Arguments.of(name, type, "Quantity".equals(type) ? QUANTITY_JSON : CODEABLE_CONCEPT_JSON)));
  }

  static Stream<Arguments> invalidChoiceTargets() {
    return Stream.of("valueNotAType", "valueString").flatMap(name ->
      Stream.of(Model.values()).map(model -> Arguments.of(name, model)));
  }

  @ParameterizedTest(name = "R5 {4} -> {5}: {0}")
  @MethodSource("complexChoiceTransforms")
  void testComplexChoiceTransformR5(String name, String rule, String inputJson, String expectedJson, Model sourceModel, Model targetModel) throws Exception {
    var utils = new org.hl7.fhir.r5.utils.structuremap.StructureMapUtilities(contextR5);
    var map = utils.parse(FML.formatted(rule), name);
    org.hl7.fhir.r5.model.Base input = sourceModel == Model.ELEMENT
      ? org.hl7.fhir.r5.elementmodel.Manager.parseSingle(contextR5,
        new ByteArrayInputStream(inputJson.getBytes(StandardCharsets.UTF_8)),
        org.hl7.fhir.r5.elementmodel.Manager.FhirFormat.JSON)
      : new org.hl7.fhir.r5.formats.JsonParser().parse(inputJson);
    org.hl7.fhir.r5.model.Base target = targetModel == Model.ELEMENT
      ? org.hl7.fhir.r5.elementmodel.Manager.build(contextR5, utils.getTargetType(map))
      : new org.hl7.fhir.r5.model.Observation();

    utils.transform(null, input, map, target);

    var output = new ByteArrayOutputStream();
    if (target instanceof org.hl7.fhir.r5.elementmodel.Element element) {
      new org.hl7.fhir.r5.elementmodel.JsonParser(contextR5).compose(element, output,
        org.hl7.fhir.r5.formats.IParser.OutputStyle.PRETTY, null);
    } else {
      new org.hl7.fhir.r5.formats.JsonParser().compose(output,
        assertInstanceOf(org.hl7.fhir.r5.model.Observation.class, target));
    }
    assertNull(new CompareUtilities().checkJsonSrcIsSame(name, expectedJson, output.toString(StandardCharsets.UTF_8)));
  }

  @ParameterizedTest(name = "R6 {4} -> {5}: {0}")
  @MethodSource("complexChoiceTransforms")
  void testComplexChoiceTransformR6(String name, String rule, String inputJson, String expectedJson, Model sourceModel, Model targetModel) throws Exception {
    var utils = new StructureMapTools(contextR6);
    var map = utils.parse(FML.formatted(rule), name);
    Base input = sourceModel == Model.ELEMENT
      ? Manager.parseSingle(contextR6, new ByteArrayInputStream(inputJson.getBytes(StandardCharsets.UTF_8)), FhirFormat.JSON)
      : new org.hl7.fhir.model.core.formats.JsonParser(contextR6.getModelContext()).parse(inputJson);
    Base target = targetModel == Model.ELEMENT
      ? Manager.build(contextR6, utils.getTargetType(map))
      : new Observation();

    utils.transform(null, input, map, target);

    var output = new ByteArrayOutputStream();
    if (target instanceof Element element) {
      new JsonParser(contextR6).compose(element, output, OutputStyle.PRETTY, null);
    } else {
      new org.hl7.fhir.model.core.formats.JsonParser(contextR6.getModelContext()).compose(output,
        assertInstanceOf(Observation.class, target));
    }
    assertNull(new CompareUtilities().checkJsonSrcIsSame(name, expectedJson, output.toString(StandardCharsets.UTF_8)));
  }

  @ParameterizedTest(name = "R5 converted choice name and type: {0}")
  @MethodSource("convertedChoiceValues")
  void testConvertedChoiceNameR5(String type, String observationJson) throws Exception {
    var observation = assertInstanceOf(org.hl7.fhir.r5.model.Observation.class,
      new org.hl7.fhir.r5.formats.JsonParser().parse(observationJson));
    var target = org.hl7.fhir.r5.elementmodel.Manager.build(contextR5,
      contextR5.fetchResource(org.hl7.fhir.r5.model.StructureDefinition.class, OBSERVATION_URL));
    var property = target.getProperty().getChildSimpleName(target.getName(), "value");
    assertNotNull(property);

    var converted = new org.hl7.fhir.r5.elementmodel.ObjectConverter(contextR5).convert(property, observation.getValue());

    assertEquals("value" + type, converted.getName());
    assertEquals(type, converted.fhirType());
  }

  @ParameterizedTest(name = "R6 converted choice name and type: {0}")
  @MethodSource("convertedChoiceValues")
  void testConvertedChoiceNameR6(String type, String observationJson) throws Exception {
    var observation = assertInstanceOf(Observation.class,
      new org.hl7.fhir.model.core.formats.JsonParser(contextR6.getModelContext()).parse(observationJson));
    var target = Manager.build(contextR6, contextR6.fetchResource(StructureDefinition.class, OBSERVATION_URL));
    var property = target.getProperty().getChildSimpleName(target.getName(), "value");
    assertNotNull(property);

    var converted = new ObjectConverter(contextR6).convert(property, observation.getValue());

    assertEquals("value" + type, converted.getName());
    assertEquals(type, converted.fhirType());
  }

  @ParameterizedTest(name = "R5 direct element assignment: {0} = {1}")
  @MethodSource("choicePropertyNames")
  void testChoicePropertyNamesR5(String name, String type, String observationJson) throws Exception {
    var observation = assertInstanceOf(org.hl7.fhir.r5.model.Observation.class,
      new org.hl7.fhir.r5.formats.JsonParser().parse(observationJson));
    var target = org.hl7.fhir.r5.elementmodel.Manager.build(contextR5,
      contextR5.fetchResource(org.hl7.fhir.r5.model.StructureDefinition.class, OBSERVATION_URL));

    var assigned = assertInstanceOf(org.hl7.fhir.r5.elementmodel.Element.class,
      target.setProperty(name.hashCode(), name, observation.getValue()));

    assertEquals("value" + type, assigned.getName());
    assertEquals(type, assigned.fhirType());
    var output = new ByteArrayOutputStream();
    new org.hl7.fhir.r5.elementmodel.JsonParser(contextR5).compose(target, output,
      org.hl7.fhir.r5.formats.IParser.OutputStyle.PRETTY, null);
    assertNull(new CompareUtilities().checkJsonSrcIsSame(name, observationJson, output.toString(StandardCharsets.UTF_8)));
  }

  @ParameterizedTest(name = "R6 direct element assignment: {0} = {1}")
  @MethodSource("choicePropertyNames")
  void testChoicePropertyNamesR6(String name, String type, String observationJson) throws Exception {
    var observation = assertInstanceOf(Observation.class,
      new org.hl7.fhir.model.core.formats.JsonParser(contextR6.getModelContext()).parse(observationJson));
    var target = Manager.build(contextR6, contextR6.fetchResource(StructureDefinition.class, OBSERVATION_URL));

    var assigned = assertInstanceOf(Element.class, target.setProperty(name, observation.getValue()));

    assertEquals("value" + type, assigned.getName());
    assertEquals(type, assigned.fhirType());
    var output = new ByteArrayOutputStream();
    new JsonParser(contextR6).compose(target, output, OutputStyle.PRETTY, null);
    assertNull(new CompareUtilities().checkJsonSrcIsSame(name, observationJson, output.toString(StandardCharsets.UTF_8)));
  }

  @ParameterizedTest(name = "R5 rejects Quantity assigned to {0} on {1}")
  @MethodSource("invalidChoiceTargets")
  void testInvalidChoiceTargetR5(String name, Model targetModel) throws Exception {
    var utils = new org.hl7.fhir.r5.utils.structuremap.StructureMapUtilities(contextR5);
    var map = utils.parse(FML.formatted("src -> tgt." + name + " = qty(42, 'kg') \"invalidChoice\";"), name);
    org.hl7.fhir.r5.model.Base target = targetModel == Model.ELEMENT
      ? org.hl7.fhir.r5.elementmodel.Manager.build(contextR5, utils.getTargetType(map))
      : new org.hl7.fhir.r5.model.Observation();

    var error = assertThrows(FHIRException.class,
      () -> utils.transform(null, new org.hl7.fhir.r5.model.Observation(), map, target));

    assertTrue(error.getMessage().contains(name), error.getMessage());
    assertTrue(target.isEmpty(), "An invalid choice assignment must not populate the target");
  }

  @ParameterizedTest(name = "R6 rejects Quantity assigned to {0} on {1}")
  @MethodSource("invalidChoiceTargets")
  void testInvalidChoiceTargetR6(String name, Model targetModel) throws Exception {
    var utils = new StructureMapTools(contextR6);
    var map = utils.parse(FML.formatted("src -> tgt." + name + " = qty(42, 'kg') \"invalidChoice\";"), name);
    Base target = targetModel == Model.ELEMENT
      ? Manager.build(contextR6, utils.getTargetType(map))
      : new Observation();

    var error = assertThrows(FHIRException.class, () -> utils.transform(null, new Observation(), map, target));

    assertTrue(error.getMessage().contains(name), error.getMessage());
    assertTrue(target.isEmpty(), "An invalid choice assignment must not populate the target");
  }
}
