package org.hl7.fhir.convertors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;

import java.io.IOException;
import java.io.InputStream;

import org.hl7.fhir.convertors.factory.VersionConvertorFactory_40_50;
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
    FilesystemPackageCacheManager pcm = new FilesystemPackageCacheManager.FilesystemPackageCacheManagerBuilder().build();
    context = TestingUtilities.getWorkerContext(pcm.loadPackage("hl7.fhir.r4.core", "4.0.1"));
  }


  @Test
  void convertResource() throws IOException {
    JsonParser r4parser = new JsonParser();
    org.hl7.fhir.r5.formats.JsonParser r5parser = new org.hl7.fhir.r5.formats.JsonParser();
    InputStream accountr4InputStream = this.getClass().getResourceAsStream("/account_r4.json");
    org.hl7.fhir.r4.model.Account account_r4 = (org.hl7.fhir.r4.model.Account) r4parser.parse(accountr4InputStream);
    Resource account_r5 = VersionConvertorFactory_40_50.convertResource(account_r4);
    System.out.println(r5parser.composeString(account_r5));
  }

  @Test
  void convertBundleContainingAccountsToTestPathing() throws IOException {
    JsonParser r4parser = new JsonParser();
    org.hl7.fhir.r5.formats.JsonParser r5parser = new org.hl7.fhir.r5.formats.JsonParser();
    InputStream accountr4InputStream = this.getClass().getResourceAsStream("/bundle_of_accounts_path_test_r4.json");
    org.hl7.fhir.r4.model.Bundle bundle_r4 = (org.hl7.fhir.r4.model.Bundle) r4parser.parse(accountr4InputStream);
    Resource account_r5 = VersionConvertorFactory_40_50.convertResource(bundle_r4);
    System.out.println(r5parser.composeString(account_r5));
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

    assertEquals("tgt", mapR5.getGroup().get(0).getRule().get(0).getTarget().get(0).getParameter().get(0).getValueIdType().getValue());
    assertEquals("item.answer.valueString", mapR5.getGroup().get(1).getRule().get(0).getTarget().get(0).getParameter().get(0).getValueStringType().getValue());
    assertEquals("item", mapR5.getGroup().get(0).getRule().get(0).getDependent().get(0).getParameter().get(0).getValueIdType().getValueAsString());
    assertEquals("patient", mapR5.getGroup().get(0).getRule().get(0).getDependent().get(0).getParameter().get(1).getValueIdType().getValueAsString());


    org.hl7.fhir.r4.model.StructureMap mapR4 = (org.hl7.fhir.r4.model.StructureMap) VersionConvertorFactory_40_50.convertResource(mapR5);
    assertEquals("tgt", mapR4.getGroup().get(0).getRule().get(0).getTarget().get(0).getParameter().get(0).getValueIdType().getValue());
    assertEquals("item.answer.valueString", mapR4.getGroup().get(1).getRule().get(0).getTarget().get(0).getParameter().get(0).getValueStringType().getValue());
    assertEquals("item", mapR4.getGroup().get(0).getRule().get(0).getDependent().get(0).getVariable().get(0).getValueAsString());
    assertEquals("patient", mapR4.getGroup().get(0).getRule().get(0).getDependent().get(0).getVariable().get(1).getValueAsString());

    assertNull(mapR4.getGroup().get(0).getRule().get(0).getDependent().get(0).getVariable().get(0).getExtensionByUrl(ToolingExtensions.EXT_ORIGINAL_VARIABLE_TYPE));
    assertNull(mapR4.getGroup().get(0).getRule().get(0).getDependent().get(0).getVariable().get(1).getExtensionByUrl(ToolingExtensions.EXT_ORIGINAL_VARIABLE_TYPE));

    assertEquals("item", mapR4.getGroup().get(0).getRule().get(0).getDependent().get(0).getVariable().get(0).getValueAsString());
    assertEquals("patient", mapR4.getGroup().get(0).getRule().get(0).getDependent().get(0).getVariable().get(1).getValueAsString());



    StructureMap mapR5Back = (StructureMap) VersionConvertorFactory_40_50.convertResource(mapR4);
    assertEquals("tgt", mapR5Back.getGroup().get(0).getRule().get(0).getTarget().get(0).getParameter().get(0).getValueIdType().getValue());
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
}