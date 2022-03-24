package org.hl7.fhir.convertors;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.hl7.fhir.convertors.factory.VersionConvertorFactory_40_50;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.formats.JsonParser;
import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.Resource;
import org.hl7.fhir.r5.model.StructureMap;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.r5.utils.structuremap.ITransformerServices;
import org.hl7.fhir.r5.utils.structuremap.StructureMapUtilities;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.npm.ToolsVersion;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class Convertor_Factory_40_50Test implements ITransformerServices {

  static private SimpleWorkerContext context;

  @BeforeAll
  static public void setUp() throws Exception {
    FilesystemPackageCacheManager pcm = new FilesystemPackageCacheManager(true, ToolsVersion.TOOLS_VERSION);
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


  @Test
  public void testStructureMapConversion() {

    String content = "map \"http://example.org/qr2patgender\" = \"qr2patgender\"\n"+
      "uses \"http://hl7.org/fhir/StructureDefinition/QuestionnaireResponse\" alias QuestionnaireResponse as source\n"+
      "uses \"http://hl7.org/fhir/StructureDefinition/Patient\" alias Patient as target\n"+
      "group QuestionnaireResponse(source src : QuestionnaireResponse, target tgt : Patient) {\n"+
      "  src.item as item -> tgt as patient then item(item, patient);\n"+
      "}\n"+
      "group item(source src, target tgt : Patient) {\n"+
      "  src.item as item where linkId.value in ('patient.sex') -> tgt.gender = (item.answer.valueString);\n"+
      "}\n";

    StructureMapUtilities smu5 = new StructureMapUtilities(context, this);
    org.hl7.fhir.r5.model.StructureMap mapR5 = smu5.parse(content, "map");

    assertEquals("tgt", mapR5.getGroup().get(0).getRule().get(0).getTarget().get(0).getParameter().get(0).getValueIdType().getValue());
    assertEquals("item.answer.valueString", mapR5.getGroup().get(1).getRule().get(0).getTarget().get(0).getParameter().get(0).getValueStringType().getValue());

    org.hl7.fhir.r4.model.StructureMap mapR4 = (org.hl7.fhir.r4.model.StructureMap) VersionConvertorFactory_40_50.convertResource(mapR5);
    assertEquals("tgt", mapR4.getGroup().get(0).getRule().get(0).getTarget().get(0).getParameter().get(0).getValueIdType().getValue());
    assertEquals("item.answer.valueString", mapR4.getGroup().get(1).getRule().get(0).getTarget().get(0).getParameter().get(0).getValueStringType().getValue());

    StructureMap mapR5Back = (StructureMap) VersionConvertorFactory_40_50.convertResource(mapR4);
    assertEquals("tgt", mapR5Back.getGroup().get(0).getRule().get(0).getTarget().get(0).getParameter().get(0).getValueIdType().getValue());
    assertEquals("item.answer.valueString", mapR5Back.getGroup().get(1).getRule().get(0).getTarget().get(0).getParameter().get(0).getValueStringType().getValue());
  }

  @Override
  public void log(String message) {
  }

  @Override
  public Base createType(Object appInfo, String name) throws FHIRException {
    return null;
  }

  @Override
  public Base createResource(Object appInfo, Base res, boolean atRootofTransform) {
    return null;
  }

  @Override
  public Coding translate(Object appInfo, Coding source, String conceptMapUrl) throws FHIRException {
    return null;
  }

  @Override
  public Base resolveReference(Object appContext, String url) throws FHIRException {
    return null;
  }

  @Override
  public List<Base> performSearch(Object appContext, String url) throws FHIRException {
    return null;
  }

}