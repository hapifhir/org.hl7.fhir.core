package org.hl7.fhir.validation.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.standalone.context.SimpleWorkerContext;
import org.hl7.fhir.services.elementmodel.FmlParser;
import org.hl7.fhir.services.elementmodel.Manager;
import org.hl7.fhir.services.renderers.RendererFactory;
import org.hl7.fhir.services.renderers.ResourceRenderer;
import org.hl7.fhir.services.renderers.StructureMapRenderer;
import org.hl7.fhir.services.renderers.utils.RenderingContext;
import org.hl7.fhir.services.renderers.utils.RenderingContext.GenerationRules;
import org.hl7.fhir.services.renderers.utils.RenderingContext.ResourceRendererMode;
import org.hl7.fhir.services.renderers.utils.ResourceWrapper;
import org.hl7.fhir.model.utilities.formats.FhirFormat;
import org.hl7.fhir.utilities.xhtml.XhtmlNode;
import org.hl7.fhir.services.fhirpath.FHIRPathEngine;
import org.hl7.fhir.model.core.Patient;
import org.hl7.fhir.model.core.Resource;
import org.hl7.fhir.model.fml.StructureMap;
import org.hl7.fhir.services.testing.CompareUtilities;
import org.hl7.fhir.standalone.testing.TestingUtilities;
import org.hl7.fhir.model.utilities.StructureMapUtilities;
import org.hl7.fhir.services.fml.StructureMapTools;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity;
import org.hl7.fhir.validation.ValidatorUtils;
import org.hl7.fhir.validation.ValidatorSettings;
import org.hl7.fhir.validation.instance.InstanceValidator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class StructureMapConstantsTests {

  static SimpleWorkerContext context;
  static StructureMapTools utils;
  static FmlParser fmlParser;
  static FHIRPathEngine fpe;
  static InstanceValidator validator;

  // Sample test data
  private static final String SAMPLE_FML = """
/// url = 'http://hl7.org/fhir/uv/mapping-language/StructureMap/Constants'
/// version = '0.1.0'
/// name = 'Constants'
/// status = 'draft'
/// description = 'Example demonstrating reusable constants defined with the let keyword'

uses "http://hl7.org/fhir/StructureDefinition/Patient" as source
uses "http://hl7.org/fhir/StructureDefinition/Patient" as target

let defaultSystem = 'http://example.org/systems/id';
let maxLen = 20;

group ConstantsGroup(source src : Patient, target tgt : Patient) {
  src.id as v -> tgt.name as n, n.family = truncate(v, maxLen) "r1";
}
""";
  
  private static final String SAMPLE_PATIENT_JSON = """
    {
      "resourceType": "Patient",
      "id": "constant-truncation-example"
    }
    """;

  @BeforeAll
  static void setUp() throws Exception {
    FilesystemPackageCacheManager pcm = new FilesystemPackageCacheManager.Builder().build();
    context = new SimpleWorkerContext(TestingUtilities.getWorkerContext(pcm.loadPackage("hl7.fhir.r6.core", "6.0.0-snapshot1")));

    // also include the FML structure definition
    var fmlPackage = pcm.loadPackage("hl7.fhir.uv.mapping-language#current");
    context.loadFromPackage(fmlPackage, ValidatorUtils.loaderForVersion(context.getModelContext(), fmlPackage.fhirVersion()), true);
    utils = new StructureMapTools(context);
    fpe = new FHIRPathEngine(context);
    fmlParser = new FmlParser(context, fpe);
    validator = new InstanceValidator(context, null, null, null, new ValidatorSettings());
  }

  @Test
  void testFmlConstantValidation() throws IOException, FHIRException {
    List<ValidationMessage> errors = new ArrayList<>();
    org.hl7.fhir.services.elementmodel.Element map = fmlParser.parse(errors, SAMPLE_FML);
    validator.validate(null, errors, null, map);

    removeKnownIssuesToIgnore(errors);

    assertEquals(0, errors.size(), errors.toString());
  }

  static Stream<Arguments> evaluateTypes() {
    return Stream.of(
        Arguments.of("@2026-01-01T00:00:00Z", "dateTime"),
        Arguments.of("1 'mg'", "Quantity"));
  }

  @ParameterizedTest
  @MethodSource("evaluateTypes")
  void testEvaluateResolvesFhirType(String expression, String expectedType) {
    String fml = SAMPLE_FML.replace("tgt.name as n, n.family = truncate(v, maxLen)",
        "evaluate(v, " + expression + ") as result");
    List<ValidationMessage> errors = new ArrayList<>();
    org.hl7.fhir.services.elementmodel.Element map = fmlParser.parse(errors, fml);
    assertTrue(errors.isEmpty(), errors.toString());

    validator.validate(null, errors, null, map);
    removeKnownIssuesToIgnore(errors);

    assertTrue(errors.isEmpty(), "Expected evaluate output to resolve as " + expectedType + ": " + errors);
  }

  @Test
  void testFmlConstantValidationForcedErrorName() throws IOException, FHIRException {
    List<ValidationMessage> errors = new ArrayList<>();
    org.hl7.fhir.services.elementmodel.Element map = fmlParser.parse(errors, SAMPLE_FML);
    map.getChildrenByName("const").get(0).removeChild("name");
    validator.validate(null, errors, null, map);

    removeKnownIssuesToIgnore(errors);

    assertEquals(1, errors.size(), "Expected validation errors due to missing constant name: " + errors.toString());
    assertEquals(I18nConstants.SM_CONSTANT_NAME_MISSING, errors.get(0).getMessageId());
    assertEquals(IssueSeverity.ERROR, errors.get(0).getLevel());
  }

  @Test
  void testFmlConstantValidationForcedErrorValue() throws IOException, FHIRException {
    List<ValidationMessage> errors = new ArrayList<>();
    org.hl7.fhir.services.elementmodel.Element map = fmlParser.parse(errors, SAMPLE_FML);
    map.getChildrenByName("const").get(0).removeChild("value");
    validator.validate(null, errors, null, map);

    removeKnownIssuesToIgnore(errors);

    assertEquals(1, errors.size(), "Expected validation errors due to missing constant value: " + errors.toString());
    assertEquals(I18nConstants.SM_CONSTANT_VALUE_MISSING, errors.get(0).getMessageId());
    assertEquals(IssueSeverity.ERROR, errors.get(0).getLevel());
  }

  private void removeKnownIssuesToIgnore(List<ValidationMessage> errors) {
    // filter out the other issues (dom-3)
    errors.removeIf(e -> e.getInvId() != null && e.getInvId().equalsIgnoreCase("http://hl7.org/fhir/StructureDefinition/DomainResource#dom-6"));

    // the additional resources message (StructureMap is an additional resource in R6)
    errors.removeIf(e -> I18nConstants.VALIDATION_ADDITIONAL_RESOURCE_ABSENT.equals(e.getMessageId()));
  }

  @Test
  void testFmlConstantValidationForcedErrorValueType() throws IOException, FHIRException {
    List<ValidationMessage> errors = new ArrayList<>();
    org.hl7.fhir.services.elementmodel.Element map = fmlParser.parse(errors, SAMPLE_FML);
    map.getChildrenByName("const").get(0).setChildValue("value", "'Intentional Error in fhirpath");
    validator.validate(null, errors, null, map);

    removeKnownIssuesToIgnore(errors);

    assertEquals(1, errors.size(), "Expected validation errors due to missing constant value type: " + errors.toString());
    assertEquals(I18nConstants.SM_CONSTANT_TYPE_UNDETERMINED, errors.get(0).getMessageId());
    assertEquals(IssueSeverity.ERROR, errors.get(0).getLevel());
  }

  @Test
  void testFmlConstantRoundTrip() throws IOException, FHIRException {
    String originalFml = SAMPLE_FML;

    StructureMap sm1 = utils.parse(originalFml, "constant-roundtrip");
    String renderedFml = StructureMapUtilities.render(sm1);

    assertEquals(normalizeFml(originalFml), normalizeFml(renderedFml), "FML -> SM -> FML: rendered FML does not match original for constant-roundtrip");
  }

  private String normalizeFml(String fml) {
    return fml.trim().replace("\r\n", "\n");
  }

  @Test
  void testFmlConstantEvaluateObjectModel() throws IOException, FHIRException {
    String originalFml = SAMPLE_FML;
    StructureMap map = utils.parse(originalFml, "constant-evaluate");
    Resource input = new org.hl7.fhir.model.core.formats.JsonParser(context.getModelContext()).parse(SAMPLE_PATIENT_JSON);
    Patient target = new org.hl7.fhir.model.core.Patient();

    utils.transform(null, input, map, target);

    // Test that the result is a Patient resource with the expected truncated id `constant-truncation-`
    assertEquals("constant-truncation-", target.getNameList().get(0).getFamily(), "Patient id does not start with 'constant-truncation-'");  
  }

  @Test
  void testFmlConstantEvaluateElementModel() throws IOException, FHIRException {
    StructureMap map = utils.parse(SAMPLE_FML, "constant-evaluate");
    org.hl7.fhir.services.elementmodel.Element input = Manager.parseSingle(context,
        new ByteArrayInputStream(SAMPLE_PATIENT_JSON.getBytes(StandardCharsets.UTF_8)), FhirFormat.JSON);
    org.hl7.fhir.services.elementmodel.Element target = Manager.build(context, utils.getTargetType(map));

    utils.transform(null, input, map, target);

    assertEquals("constant-truncation-", target.getNamedChild("name").getNamedChildValue("family"));
  }

  @Test
  void testConstantAsRuleSourceContext() throws IOException, FHIRException {
    // a constant can be a rule's source context, but has no elements to navigate to
    String fml = SAMPLE_FML.replace("src.id as v -> tgt.name as n, n.family = truncate(v, maxLen) \"r1\";",
        "defaultSystem.length as l -> tgt.id = l \"r1\";");
    List<ValidationMessage> errors = new ArrayList<>();
    org.hl7.fhir.services.elementmodel.Element map = fmlParser.parse(errors, fml);
    validator.validate(null, errors, null, map);
    removeKnownIssuesToIgnore(errors);

    assertTrue(errors.stream().anyMatch(e -> I18nConstants.SM_SOURCE_PATH_INVALID.equals(e.getMessageId())), errors.toString());
  }

  @Test
  void testCopyOfVariableWithNoTargetContext() throws IOException, FHIRException {
    // copy(v) produces a value of v's type - not a type named 'v'
    String fml = SAMPLE_FML.replace("src.id as v -> tgt.name as n, n.family = truncate(v, maxLen) \"r1\";",
        "src.id as v -> copy(v) as x \"r1\";");
    List<ValidationMessage> errors = new ArrayList<>();
    org.hl7.fhir.services.elementmodel.Element map = fmlParser.parse(errors, fml);
    validator.validate(null, errors, null, map);
    removeKnownIssuesToIgnore(errors);

    assertTrue(errors.stream().noneMatch(e -> I18nConstants.SM_TARGET_TYPE_UNKNOWN.equals(e.getMessageId())), errors.toString());
  }

  @Test
  void testRenderElementModelMap() throws Exception {
    org.hl7.fhir.services.elementmodel.Element map = fmlParser.parse(new ArrayList<>(), SAMPLE_FML);
    RendererFactory rendererFactory = new RendererFactory();
    RenderingContext rc = new RenderingContext(context, rendererFactory, null, null, "http://hl7.org/fhir", "", null,
        ResourceRendererMode.TECHNICAL, GenerationRules.VALID_RESOURCE);
    ResourceWrapper wrapper = ResourceWrapper.forResource(rc.getContextUtilities(), map);

    ResourceRenderer renderer = rendererFactory.factory(wrapper, rc);
    XhtmlNode narrative = renderer.buildNarrative(wrapper);

    assertInstanceOf(StructureMapRenderer.class, renderer);
    assertTrue(rendererFactory.hasSpecificRenderer("StructureMap"));
    String text = narrative.allText();
    assertTrue(text.contains("http://hl7.org/fhir/uv/mapping-language/StructureMap/Constants"), text);
    assertTrue(text.contains("/// version = '0.1.0'"), text);
    assertTrue(text.contains("let maxLen"), text);
  }

  @Test
  void testFmlConstantsAnalyze() throws IOException, FHIRException {
    String originalFml = SAMPLE_FML;

    StructureMap sm1 = utils.parse(originalFml, "SAMPLE_FML");
    var analysis = utils.analyse(null, sm1);

    assertNotNull(analysis, "FML -> SM: analysis result is null for SAMPLE_FML");
  }

  @Test
  void testFmlConstantsRoundTrip() throws Exception {
    String originalFml = SAMPLE_FML;

    StructureMap sm1 = utils.parse(originalFml, "SAMPLE_FML");
    String renderedFml = StructureMapUtilities.render(sm1);
    StructureMap sm2 = utils.parse(renderedFml, "SAMPLE_FML");

    String json1 = new org.hl7.fhir.model.core.formats.JsonParser(context.getModelContext()).composeString(sm1);
    String json2 = new org.hl7.fhir.model.core.formats.JsonParser(context.getModelContext()).composeString(sm2);
    String msg = new CompareUtilities().checkJsonSrcIsSame("SAMPLE_FML", json1, json2);
    assertNull(msg, "FML -> SM -> FML -> SM: StructureMaps differ for SAMPLE_FML: " + msg);
  }

  @Test
  void testFmlConstantsParserConsistency() throws IOException, FHIRException {
    String originalFml = SAMPLE_FML;
    // parse FML text using the regular StructureMapUtilities parser (to StructureMap object)
    StructureMap sm1 = utils.parse(originalFml, "SAMPLE_FML");
    var parserR5 = new org.hl7.fhir.model.core.formats.JsonParser(context.getModelContext());
    parserR5.setOutputStyle(org.hl7.fhir.model.utilities.formats.OutputStyle.PRETTY);
    String jsonText = parserR5.composeString(sm1);

    // Now parse using the ElementModel FML parser
    var errors = new ArrayList<ValidationMessage>();
    var smAsElements = fmlParser.parse(errors, originalFml);
    smAsElements.sort();
    var parserElements = new org.hl7.fhir.services.elementmodel.JsonParser(context);
    var bs = new java.io.ByteArrayOutputStream();
    parserElements.compose(smAsElements, bs, org.hl7.fhir.model.utilities.formats.OutputStyle.PRETTY, null);
    var jsonTextFromElements = bs.toString();

    // compare the 2 JSON outputs
    assertEquals(true, errors.isEmpty(), "FML -> ElementModel: errors found for SAMPLE_FML");
    String msg = new CompareUtilities().checkJsonSrcIsSame("SAMPLE_FML", jsonText, jsonTextFromElements);
    assertNull(msg, "FML -> ElementModel -> JSON: JSON output differs for SAMPLE_FML: " + msg);
  }
}
