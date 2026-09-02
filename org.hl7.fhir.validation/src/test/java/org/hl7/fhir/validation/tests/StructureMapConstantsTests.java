package org.hl7.fhir.validation.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.elementmodel.FmlParser;
import org.hl7.fhir.r5.fhirpath.FHIRPathEngine;
import org.hl7.fhir.r5.model.Patient;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.StructureMap;
import org.hl7.fhir.r5.test.utils.CompareUtilities;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.r5.utils.structuremap.StructureMapUtilities;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.i18n.I18nConstants;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.hl7.fhir.utilities.validation.ValidationMessage.IssueSeverity;
import org.hl7.fhir.validation.ValidatorSettings;
import org.hl7.fhir.validation.instance.InstanceValidator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class StructureMapConstantsTests {

  static SimpleWorkerContext context;
  static StructureMapUtilities utils;
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
    context = new SimpleWorkerContext(TestingUtilities.getWorkerContext(pcm.loadPackage("hl7.fhir.r5.core", "5.0.0")));
    utils = new StructureMapUtilities(context);
    fpe = new FHIRPathEngine(context);
    fmlParser = new FmlParser(context, fpe);
    validator = new InstanceValidator(context, null, null, null, new ValidatorSettings());
  }

  @Test
  void testFmlConstantValidation() throws IOException, FHIRException {
    List<ValidationMessage> errors = new ArrayList<>();
    org.hl7.fhir.r5.elementmodel.Element map = fmlParser.parse(errors, SAMPLE_FML);
    validator.validate(null, errors, null, map);

    // filter out all the information messages, we only care about errors and warnings
    errors.removeIf(e -> e.getLevel() == IssueSeverity.INFORMATION);
    assertEquals(0, errors.size(), errors.toString());
    // assertTrue(errors.stream().noneMatch(this::isTransformRuleMessage), errors.toString());
  }

  @Test
  void testFmlConstantValidationForcedErrorName() throws IOException, FHIRException {
    List<ValidationMessage> errors = new ArrayList<>();
    org.hl7.fhir.r5.elementmodel.Element map = fmlParser.parse(errors, SAMPLE_FML);
    map.getChildrenByName("const").get(0).removeChild("name");
    validator.validate(null, errors, null, map);
    assertEquals(1, errors.size(), "Expected validation errors due to missing constant name: " + errors.toString());
  }

  @Test
  void testFmlConstantValidationForcedErrorValue() throws IOException, FHIRException {
    List<ValidationMessage> errors = new ArrayList<>();
    org.hl7.fhir.r5.elementmodel.Element map = fmlParser.parse(errors, SAMPLE_FML);
    map.getChildrenByName("const").get(0).removeChild("value");
    validator.validate(null, errors, null, map);
    assertEquals(1, errors.size(), "Expected validation errors due to missing constant value: " + errors.toString());
  }

  @Test
  void testFmlConstantValidationForcedErrorValueType() throws IOException, FHIRException {
    List<ValidationMessage> errors = new ArrayList<>();
    org.hl7.fhir.r5.elementmodel.Element map = fmlParser.parse(errors, SAMPLE_FML);
    map.getChildrenByName("const").get(0).setChildValue("value", "'Intentional Error in fhirpath");
    validator.validate(null, errors, null, map);
    assertEquals(1, errors.size(), "Expected validation errors due to missing constant value type: " + errors.toString());
  }

  private boolean isTransformRuleMessage(ValidationMessage message) {
    return Utilities.existsInList(message.getMessageId(), I18nConstants.SM_TARGET_TRANSFORM_PARAM_COUNT_RANGE,
      I18nConstants.SM_TARGET_TRANSFORM_TRANSLATE_NO_PARAM, I18nConstants.SM_TARGET_TRANSFORM_OP_UNKNOWN_SOURCE,
      I18nConstants.SM_TARGET_TRANSFORM_OP_INVALID_TYPE, I18nConstants.SM_TARGET_TRANSFORM_NOT_CHECKED);
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
    Resource input = new org.hl7.fhir.r5.formats.JsonParser().parse(SAMPLE_PATIENT_JSON);
    Patient target = new org.hl7.fhir.r5.model.Patient();

    utils.transform(null, input, map, target);

    // Test that the result is a Patient resource with the expected truncated id `constant-truncation-`
    assertEquals("constant-truncation-", target.getName().get(0).getFamily(), "Patient id does not start with 'constant-truncation-'");  
  }

  @Test
  void testFmlConstantEvaluateElementModel() throws IOException, FHIRException {
  //   String originalFml = SAMPLE_FML;
  //   StructureMap map = utils.parse(originalFml, "constant-evaluate");
  //   Base input = new org.hl7.fhir.r5.formats.JsonParser().parse(SAMPLE_PATIENT_JSON);

  //   var result = utils.transform(null, map, input);

  //   // Test that the result is a Patient resource with the expected truncated id `constant-truncation-`
  //   assertTrue(result instanceof org.hl7.fhir.r5.model.Patient, "Result is not a Patient resource");
  //   org.hl7.fhir.r5.model.Patient patient = (org.hl7.fhir.r5.model.Patient) result;
  //   assertTrue(patient.getId().startsWith("constant-truncation-"), "Patient id does not start with 'constant-truncation-'");
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

    String json1 = new org.hl7.fhir.r5.formats.JsonParser().composeString(sm1);
    String json2 = new org.hl7.fhir.r5.formats.JsonParser().composeString(sm2);
    String msg = new CompareUtilities().checkJsonSrcIsSame("SAMPLE_FML", json1, json2);
    assertNull(msg, "FML -> SM -> FML -> SM: StructureMaps differ for SAMPLE_FML: " + msg);
  }

  @Test
  void testFmlConstantsParserConsistency() throws IOException, FHIRException {
    String originalFml = SAMPLE_FML;
    // parse FML text using the regular StructureMapUtilities parser (to StructureMap object)
    StructureMap sm1 = utils.parse(originalFml, "SAMPLE_FML");
    org.hl7.fhir.r5.formats.IParser parserR5 = new org.hl7.fhir.r5.formats.JsonParser();
    parserR5.setOutputStyle(org.hl7.fhir.r5.formats.IParser.OutputStyle.PRETTY);
    String jsonText = parserR5.composeString(sm1);

    // Now parse using the ElementModel FML parser
    var errors = new ArrayList<ValidationMessage>();
    var smAsElements = fmlParser.parse(errors, originalFml);
    smAsElements.sort();
    var parserElements = new org.hl7.fhir.r5.elementmodel.JsonParser(context);
    var bs = new java.io.ByteArrayOutputStream();
    parserElements.compose(smAsElements, bs, org.hl7.fhir.r5.formats.IParser.OutputStyle.PRETTY, null);
    var jsonTextFromElements = bs.toString();

    // compare the 2 JSON outputs
    assertEquals(true, errors.isEmpty(), "FML -> ElementModel: errors found for SAMPLE_FML");
    String msg = new CompareUtilities().checkJsonSrcIsSame("SAMPLE_FML", jsonText, jsonTextFromElements);
    assertNull(msg, "FML -> ElementModel -> JSON: JSON output differs for SAMPLE_FML: " + msg);
  }
}
