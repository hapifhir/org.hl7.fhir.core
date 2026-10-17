package org.hl7.fhir.convertors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.io.InputStream;
import java.util.List;

import org.hl7.fhir.convertors.factory.VersionConvertorFactory_40_50;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_40_N;
import org.hl7.fhir.convertors.factory.VersionConvertorFactory_50_N;
import org.hl7.fhir.r4.formats.JsonParser;
import org.hl7.fhir.r4.utils.ToolingExtensions;
import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.StructureMap;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.r5.utils.structuremap.StructureMapUtilities;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class Convertor_Factory_40_50Test  {

  static private SimpleWorkerContext context;

  @BeforeAll
  static public void setUp() throws Exception {
    FilesystemPackageCacheManager pcm = new FilesystemPackageCacheManager.Builder().build();
    context = TestingUtilities.getWorkerContext(pcm.loadPackage("hl7.fhir.r4.core", "4.0.1"));
  }


  @Test
  void convertResource() {
    assertDoesNotThrow(() -> {
      JsonParser r4parser = new JsonParser();
      org.hl7.fhir.r5.formats.JsonParser r5parser = new org.hl7.fhir.r5.formats.JsonParser();
      InputStream accountr4InputStream = this.getClass().getResourceAsStream("/account_r4.json");
      org.hl7.fhir.r4.model.Account account_r4 = (org.hl7.fhir.r4.model.Account) r4parser.parse(accountr4InputStream);
      Resource account_r5 = VersionConvertorFactory_40_50.convertResource(account_r4);
      System.out.println(r5parser.composeString(account_r5));
    });
  }

  @Test
  void convertBundleContainingAccountsToTestPathing() {
    assertDoesNotThrow(() -> {
      JsonParser r4parser = new JsonParser();
      org.hl7.fhir.r5.formats.JsonParser r5parser = new org.hl7.fhir.r5.formats.JsonParser();
      InputStream accountr4InputStream = this.getClass().getResourceAsStream("/bundle_of_accounts_path_test_r4.json");
      org.hl7.fhir.r4.model.Bundle bundle_r4 = (org.hl7.fhir.r4.model.Bundle) r4parser.parse(accountr4InputStream);
      Resource account_r5 = VersionConvertorFactory_40_50.convertResource(bundle_r4);
      System.out.println(r5parser.composeString(account_r5));
    });
  }

  static final String CONTENT = "map \"http://example.org/qr2patgender\" = \"qr2patgender\"\n"+
    "uses \"http://hl7.org/fhir/StructureDefinition/QuestionnaireResponse\" alias QuestionnaireResponse as source\n"+
    "uses \"http://hl7.org/fhir/StructureDefinition/Patient\" alias Patient as target\n"+
    "group QuestionnaireResponse(source src : QuestionnaireResponse, target tgt : Patient) {\n"+
    "  src.item as item -> tgt as patient then item(item, patient);\n"+
    "}\n"+
    "group item(source src, target tgt : Patient) {\n"+
    "  src.item as item where linkId.value in ('patient.sex') -> tgt.gender = (item.answer.valueString);\n"+
    "}\n";

  @Test
  public void testBidirectionalStructureMapConversion() {

    StructureMapUtilities smu5 = new StructureMapUtilities(context, mock(org.hl7.fhir.r5.utils.structuremap.ITransformerServices.class));
    org.hl7.fhir.r5.model.StructureMap mapR5 = smu5.parse(CONTENT, "map");

    assertEquals("tgt", mapR5.getGroup().get(0).getRule().get(0).getTarget().get(0).getContext());
    assertEquals("item.answer.valueString", mapR5.getGroup().get(1).getRule().get(0).getTarget().get(0).getParameter().get(0).getValueStringType().getValue());
    assertEquals("item", mapR5.getGroup().get(0).getRule().get(0).getDependent().get(0).getParameter().get(0).getValueIdType().getValueAsString());
    assertEquals("patient", mapR5.getGroup().get(0).getRule().get(0).getDependent().get(0).getParameter().get(1).getValueIdType().getValueAsString());


    org.hl7.fhir.r4.model.StructureMap mapR4 = (org.hl7.fhir.r4.model.StructureMap) VersionConvertorFactory_40_50.convertResource(mapR5);
    assertEquals("tgt", mapR4.getGroup().get(0).getRule().get(0).getTarget().get(0).getContext());
    assertEquals("item.answer.valueString", mapR4.getGroup().get(1).getRule().get(0).getTarget().get(0).getParameter().get(0).getValueStringType().getValue());
    assertEquals("item", mapR4.getGroup().get(0).getRule().get(0).getDependent().get(0).getVariable().get(0).getValueAsString());
    assertEquals("patient", mapR4.getGroup().get(0).getRule().get(0).getDependent().get(0).getVariable().get(1).getValueAsString());

    assertNull(mapR4.getGroup().get(0).getRule().get(0).getDependent().get(0).getVariable().get(0).getExtensionByUrl(ToolingExtensions.EXT_ORIGINAL_VARIABLE_TYPE));
    assertNull(mapR4.getGroup().get(0).getRule().get(0).getDependent().get(0).getVariable().get(1).getExtensionByUrl(ToolingExtensions.EXT_ORIGINAL_VARIABLE_TYPE));

    assertEquals("item", mapR4.getGroup().get(0).getRule().get(0).getDependent().get(0).getVariable().get(0).getValueAsString());
    assertEquals("patient", mapR4.getGroup().get(0).getRule().get(0).getDependent().get(0).getVariable().get(1).getValueAsString());



    StructureMap mapR5Back = (StructureMap) VersionConvertorFactory_40_50.convertResource(mapR4);
    assertEquals("tgt", mapR5Back.getGroup().get(0).getRule().get(0).getTarget().get(0).getContext());
    assertEquals("item.answer.valueString", mapR5Back.getGroup().get(1).getRule().get(0).getTarget().get(0).getParameter().get(0).getValueStringType().getValue());
    assertEquals("item", mapR5Back.getGroup().get(0).getRule().get(0).getDependent().get(0).getParameter().get(0).getValueIdType().getValueAsString());
    assertEquals("patient", mapR5Back.getGroup().get(0).getRule().get(0).getDependent().get(0).getParameter().get(1).getValueIdType().getValueAsString());

  }

  @Test
  public void testR4ToR5StructureMapConversion() {
    org.hl7.fhir.r4.utils.StructureMapUtilities smu5 = new org.hl7.fhir.r4.utils.StructureMapUtilities(mock(org.hl7.fhir.r4.context.SimpleWorkerContext.class), mock(org.hl7.fhir.r4.utils.StructureMapUtilities.ITransformerServices.class));
    org.hl7.fhir.r4.model.StructureMap mapR4 = smu5.parse(CONTENT, "map");

    assertEquals("tgt", mapR4.getGroup().get(0).getRule().get(0).getTarget().get(0).getParameter().get(0).getValueIdType().getValue());
    assertEquals("item.answer.valueString", mapR4.getGroup().get(1).getRule().get(0).getTarget().get(0).getParameter().get(0).getValueStringType().getValue());
    assertEquals("item", mapR4.getGroup().get(0).getRule().get(0).getDependent().get(0).getVariable().get(0).getValueAsString());
    assertEquals("patient", mapR4.getGroup().get(0).getRule().get(0).getDependent().get(0).getVariable().get(1).getValueAsString());

    StructureMap mapR5 = (StructureMap) VersionConvertorFactory_40_50.convertResource(mapR4);
    assertEquals("tgt", mapR5.getGroup().get(0).getRule().get(0).getTarget().get(0).getParameter().get(0).getValueIdType().getValue());
    assertEquals("item.answer.valueString", mapR5.getGroup().get(1).getRule().get(0).getTarget().get(0).getParameter().get(0).getValueStringType().getValue());
    assertEquals("item", mapR5.getGroup().get(0).getRule().get(0).getDependent().get(0).getParameter().get(0).getValueIdType().getValueAsString());
    assertEquals("patient", mapR5.getGroup().get(0).getRule().get(0).getDependent().get(0).getParameter().get(1).getValueIdType().getValueAsString());

    assertNull(mapR5.getGroup().get(0).getRule().get(0).getDependent().get(0).getParameter().get(0).getExtensionByUrl(ToolingExtensions.EXT_ORIGINAL_VARIABLE_TYPE));
    assertNull(mapR5.getGroup().get(0).getRule().get(0).getDependent().get(0).getParameter().get(1).getExtensionByUrl(ToolingExtensions.EXT_ORIGINAL_VARIABLE_TYPE));
  }

  // A dependent call whose parameters are not all ids: a string and an integer literal. R4 only
  // has string variables, so a non-id parameter goes to R4 as an empty variable carrying the
  // typed value in an original-variable-type extension, and must come back typed.
  static final String CONTENT_LITERALS = "map \"http://example.org/qr2patgender\" = \"qr2patgender\"\n"+
    "uses \"http://hl7.org/fhir/StructureDefinition/QuestionnaireResponse\" alias QuestionnaireResponse as source\n"+
    "uses \"http://hl7.org/fhir/StructureDefinition/Patient\" alias Patient as target\n"+
    "group QuestionnaireResponse(source src : QuestionnaireResponse, target tgt : Patient) {\n"+
    "  src.item as item -> tgt as patient then item(item, patient, 'patient.sex', 1);\n"+
    "}\n"+
    "group item(source src, target tgt : Patient, source linkId : string, source n : integer) {\n"+
    "  src.item as item where linkId.value in ('patient.sex') -> tgt.gender = (item.answer.valueString);\n"+
    "}\n";

  private StructureMap parseLiteralsMap() {
    StructureMapUtilities smu5 = new StructureMapUtilities(context, mock(org.hl7.fhir.r5.utils.structuremap.ITransformerServices.class));
    StructureMap mapR5 = smu5.parse(CONTENT_LITERALS, "map");
    List<StructureMap.StructureMapGroupRuleTargetParameterComponent> params = dependentParams(mapR5);
    assertEquals(4, params.size());
    assertEquals("item", params.get(0).getValueIdType().getValue());
    assertEquals("patient", params.get(1).getValueIdType().getValue());
    assertEquals("patient.sex", params.get(2).getValueStringType().getValue());
    assertEquals(1, params.get(3).getValueIntegerType().getValue().intValue());
    return mapR5;
  }

  private static List<StructureMap.StructureMapGroupRuleTargetParameterComponent> dependentParams(StructureMap map) {
    return map.getGroup().get(0).getRule().get(0).getDependent().get(0).getParameter();
  }

  private static List<org.hl7.fhir.r4.model.StringType> dependentVariables(org.hl7.fhir.r4.model.StructureMap map) {
    return map.getGroup().get(0).getRule().get(0).getDependent().get(0).getVariable();
  }

  private static List<org.hl7.fhir.model.fml.StructureMap.StructureMapGroupRuleTargetParameterComponent> dependentParams(org.hl7.fhir.model.fml.StructureMap map) {
    return map.getGroupList().get(0).getRuleList().get(0).getDependentList().get(0).getParameterList();
  }

  /** The R4 shape of a non-id parameter: an empty variable with the typed value in the extension. */
  private static void assertR4CarriesTypedLiterals(org.hl7.fhir.r4.model.StructureMap mapR4) {
    List<org.hl7.fhir.r4.model.StringType> vars = dependentVariables(mapR4);
    assertEquals(4, vars.size());
    assertEquals("item", vars.get(0).getValue());
    assertFalse(vars.get(0).hasExtension(ToolingExtensions.EXT_ORIGINAL_VARIABLE_TYPE));
    assertFalse(vars.get(2).hasValue());
    assertEquals("patient.sex", ((org.hl7.fhir.r4.model.StringType) vars.get(2).getExtensionByUrl(ToolingExtensions.EXT_ORIGINAL_VARIABLE_TYPE).getValue()).getValue());
    assertFalse(vars.get(3).hasValue());
    assertEquals(1, ((org.hl7.fhir.r4.model.IntegerType) vars.get(3).getExtensionByUrl(ToolingExtensions.EXT_ORIGINAL_VARIABLE_TYPE).getValue()).getValue().intValue());
  }

  private static void assertR5HasTypedLiterals(StructureMap mapR5) {
    List<StructureMap.StructureMapGroupRuleTargetParameterComponent> params = dependentParams(mapR5);
    assertEquals(4, params.size());
    assertEquals("item", params.get(0).getValueIdType().getValue());
    assertTrue(params.get(2).hasValueStringType());
    assertEquals("patient.sex", params.get(2).getValueStringType().getValue());
    assertTrue(params.get(3).hasValueIntegerType());
    assertEquals(1, params.get(3).getValueIntegerType().getValue().intValue());
  }

  private static void assertR6HasTypedLiterals(org.hl7.fhir.model.fml.StructureMap mapR6) {
    List<org.hl7.fhir.model.fml.StructureMap.StructureMapGroupRuleTargetParameterComponent> params = dependentParams(mapR6);
    assertEquals(4, params.size());
    assertEquals("item", params.get(0).getValueIdType().getValue());
    assertEquals("patient", params.get(1).getValueIdType().getValue());
    assertEquals("patient.sex", params.get(2).getValueStringType().getValue());
    assertEquals(1, params.get(3).getValueIntegerType().getValue().intValue());
  }

  @Test
  public void testNonIdDependentParametersRoundTripThroughR4() {
    StructureMap mapR5 = parseLiteralsMap();

    org.hl7.fhir.r4.model.StructureMap mapR4 = (org.hl7.fhir.r4.model.StructureMap) VersionConvertorFactory_40_50.convertResource(mapR5);
    assertR4CarriesTypedLiterals(mapR4);

    StructureMap mapR5Back = (StructureMap) VersionConvertorFactory_40_50.convertResource(mapR4);
    assertR5HasTypedLiterals(mapR5Back);
  }

  @Test
  public void testStructureMapConversionR5ToR6AndBack() {
    StructureMap mapR5 = parseLiteralsMap();

    org.hl7.fhir.model.fml.StructureMap mapR6 = (org.hl7.fhir.model.fml.StructureMap) VersionConvertorFactory_50_N.convertResource(mapR5);
    assertEquals("tgt", mapR6.getGroupList().get(0).getRuleList().get(0).getTargetList().get(0).getContext());
    assertR6HasTypedLiterals(mapR6);

    StructureMap mapR5Back = (StructureMap) VersionConvertorFactory_50_N.convertResource(mapR6);
    assertEquals("tgt", mapR5Back.getGroup().get(0).getRule().get(0).getTarget().get(0).getContext());
    assertR5HasTypedLiterals(mapR5Back);
  }

  @Test
  public void testStructureMapConversionR4ToR6AndBack() {
    // Start from the R4 shape, where the literals live in extensions, and check R6 gets them typed
    org.hl7.fhir.r4.model.StructureMap mapR4 = (org.hl7.fhir.r4.model.StructureMap) VersionConvertorFactory_40_50.convertResource(parseLiteralsMap());
    assertR4CarriesTypedLiterals(mapR4);

    org.hl7.fhir.model.fml.StructureMap mapR6 = (org.hl7.fhir.model.fml.StructureMap) VersionConvertorFactory_40_N.convertResource(mapR4);
    assertEquals("tgt", mapR6.getGroupList().get(0).getRuleList().get(0).getTargetList().get(0).getContext());
    assertR6HasTypedLiterals(mapR6);

    org.hl7.fhir.r4.model.StructureMap mapR4Back = (org.hl7.fhir.r4.model.StructureMap) VersionConvertorFactory_40_N.convertResource(mapR6);
    assertR4CarriesTypedLiterals(mapR4Back);
  }
}
