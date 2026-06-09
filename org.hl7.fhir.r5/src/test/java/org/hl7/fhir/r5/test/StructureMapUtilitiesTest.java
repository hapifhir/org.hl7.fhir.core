package org.hl7.fhir.r5.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.List;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.conformance.profile.ProfileUtilities;
import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.elementmodel.Element;
import org.hl7.fhir.r5.elementmodel.Manager;
import org.hl7.fhir.r5.elementmodel.Manager.FhirFormat;
import org.hl7.fhir.r5.fhirpath.FHIRPathEngine;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.StructureMap;
import org.hl7.fhir.r5.model.StructureMap.StructureMapGroupRuleTargetComponent;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.r5.utils.structuremap.ITransformerServices;
import org.hl7.fhir.r5.utils.structuremap.StructureMapUtilities;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class StructureMapUtilitiesTest implements ITransformerServices {

  static private SimpleWorkerContext context;

  @BeforeAll
  static public void setUp() throws Exception {
    FilesystemPackageCacheManager pcm = new FilesystemPackageCacheManager.Builder().build();
    context = TestingUtilities.getWorkerContext(pcm.loadPackage("hl7.fhir.r4.core", "4.0.1"));
  }

  @Test
  public void testParseRuleName() throws IOException, FHIRException {
    StructureMapUtilities scu = new StructureMapUtilities(context, this);
    String fileMap = TestingUtilities.loadTestResource("r5", "structure-mapping", "ActivityDefinition.map");
    StructureMap structureMap = scu.parse(fileMap, "ActivityDefinition3To4");

    // StructureMap/ActivityDefinition3to4: StructureMap.group[3].rule[2].name error id value '"expression"' is not valid
    Assertions.assertEquals("expression", structureMap.getGroup().get(2).getRule().get(1).getName());
  }
  
  @Test
  public void testCast() throws IOException, FHIRException {
    // org.hl7.fhir.exceptions.FHIRException: Exception executing transform ext.value = cast(value, 'positiveInt') on Rule "item": cast to positiveInt not yet supported
    StructureMapUtilities scu = new StructureMapUtilities(context, this);
    String fileMap = TestingUtilities.loadTestResource("r5", "structure-mapping", "cast.map");
    Element source = Manager.parseSingle(context, TestingUtilities.loadTestResourceStream("r5", "structure-mapping", "qrext.json"), FhirFormat.JSON);
    StructureMap structureMap = scu.parse(fileMap, "cast");
    Element target = Manager.build(context, scu.getTargetType(structureMap));
    scu.transform(null, source, structureMap, target);
    checkNumberChildren(target, "");
    FHIRPathEngine fp = new FHIRPathEngine(context);
    Assertions.assertEquals("implicit",fp.evaluateToString(target, "extension[0].value"));
    Assertions.assertEquals("explicit",fp.evaluateToString(target, "extension[1].value"));
    Assertions.assertEquals("2147483647",fp.evaluateToString(target, "extension[2].value"));
    Assertions.assertEquals("2147483647",fp.evaluateToString(target, "extension[3].value"));
  }
  
  @Test
  public void testDateOpVariables() throws IOException, FHIRException {
    StructureMapUtilities scu = new StructureMapUtilities(context, this);
    String fileMap = TestingUtilities.loadTestResource("r5", "structure-mapping", "qr2patfordates.map");
    Element source = Manager.parseSingle(context, TestingUtilities.loadTestResourceStream("r5", "structure-mapping", "qrext.json"), FhirFormat.JSON);
    StructureMap structureMap = scu.parse(fileMap, "qr2patfordates");
    Element target = Manager.build(context, scu.getTargetType(structureMap));
    scu.transform(null, source, structureMap, target);
    checkNumberChildren(target, "");
    FHIRPathEngine fp = new FHIRPathEngine(context);
    assertEquals("2023-10-26", fp.evaluateToString(target, "birthDate"));
    assertEquals("2023-09-20T13:19:13.502Z", fp.evaluateToString(target, "deceased"));
  }
  
  @Test
  public void testWhereClause() throws IOException, FHIRException {
      StructureMapUtilities scu = new StructureMapUtilities(context, this);
      scu.setDebug(true);
      String fileMap = TestingUtilities.loadTestResource("r5", "structure-mapping", "whereclause.map");
      Element source = Manager.parseSingle(context, TestingUtilities.loadTestResourceStream("r4", "examples", "capabilitystatement-example.json"), FhirFormat.JSON);
      StructureMap structureMap = scu.parse(fileMap, "whereclause");
      Element target = Manager.build(context, scu.getTargetType(structureMap));
      scu.transform(null, source, structureMap, target);
      checkNumberChildren(target, "");
      FHIRPathEngine fp = new FHIRPathEngine(context);
      assertEquals("true", fp.evaluateToString(target, "rest.resource.interaction.where(code='create').exists()"));
  }

  private void assertSerializeDeserialize(StructureMap structureMap) {
    Assertions.assertEquals("syntax", structureMap.getName());
    Assertions.assertEquals("description", structureMap.getDescription());
    Assertions.assertEquals("http://github.com/FHIR/fhir-test-cases/r5/fml/syntax", structureMap.getUrl());
    Assertions.assertEquals("Patient", structureMap.getStructure().get(0).getAlias());
    Assertions.assertEquals("http://hl7.org/fhir/StructureDefinition/Patient", structureMap.getStructure().get(0).getUrl());
    Assertions.assertEquals("Source Documentation", structureMap.getStructure().get(0).getFormatCommentsPost().get(0));
    Assertions.assertEquals("http://hl7.org/fhir/StructureDefinition/Patient", structureMap.getStructure().get(0).getUrl());
    Assertions.assertEquals("http://hl7.org/fhir/StructureDefinition/Basic", structureMap.getStructure().get(1).getUrl());
    Assertions.assertEquals("Target Documentation", structureMap.getStructure().get(1).getFormatCommentsPost().get(0));
    Assertions.assertEquals("Groups\r\nrule for patient group", structureMap.getGroup().get(0).getDocumentation());
    Assertions.assertEquals("Comment to rule", structureMap.getGroup().get(0).getRule().get(0).getDocumentation());
    Assertions.assertEquals("Copy identifier short syntax", structureMap.getGroup().get(0).getRule().get(1).getDocumentation());

    StructureMapGroupRuleTargetComponent target = structureMap.getGroup().get(0).getRule().get(2).getTarget().get(1);
    Assertions.assertEquals("'urn:uuid:' + r.lower()", target.getParameter().get(0).toString());
  }

  @Test
  public void testSyntax() throws IOException, FHIRException {
    StructureMapUtilities scu = new StructureMapUtilities(context, this);
    String fileMap = TestingUtilities.loadTestResource("r5", "structure-mapping", "syntax.map");

    StructureMap structureMap = scu.parse(fileMap, "Syntax");
    assertSerializeDeserialize(structureMap);

    String renderedMap = StructureMapUtilities.render(structureMap);
    StructureMap map = scu.parse(renderedMap, "Syntax");
    assertSerializeDeserialize(map);
  }

  @Test
  public void testSourceElementDelimiter() throws IOException, FHIRException {
    StructureMapUtilities scu = new StructureMapUtilities(context, this);
    String fileMap = "map \"http://github.com/FHIR/testSourceElementDelimiter\" = \"testSourceElementDelimiter\"\r\n"
      + "uses \"http://hl7.org/fhir/StructureDefinition/Patient\" alias Patient as source\r\n"
      + "uses \"http://hl7.org/fhir/StructureDefinition/Basic\" alias Basic as target\r\n"
      + "group Patient(source src : Patient, target tgt : Basic) {\r\n"
      + "  src.identifier -> tgt.identifier;\r\n"
      + "  src.\"-quote\" -> tgt.quote;\r\n"
      + "  src.`-backtick` -> tgt.backtick;\r\n"
      + "}";
    System.out.println(fileMap);

    StructureMap structureMap = scu.parse(fileMap, "testSourceElementDelimiter");
    Assertions.assertEquals("identifier", structureMap.getGroup().get(0).getRule().get(0).getSourceFirstRep().getElement());
    Assertions.assertEquals("-quote", structureMap.getGroup().get(0).getRule().get(1).getSourceFirstRep().getElement());
    Assertions.assertEquals("-backtick", structureMap.getGroup().get(0).getRule().get(2).getSourceFirstRep().getElement());
  }

  @Test
  void testTripleQuotedDescription() throws FHIRException {
    StructureMapUtilities scu = new StructureMapUtilities(context, this);
    String fileMap = "/// url = \"http://example.com/StructureMap/triple\"\r\n"
      + "/// name = \"TripleQuotedDescription\"\r\n"
      + "/// description = \"\"\"\r\n"
      + "You should use my *awesome* map.\r\n"
      + "It does really cool things.\r\n"
      + "\"\"\"\r\n"
      + "/// status = \"draft\"\r\n"
      + "uses \"http://hl7.org/fhir/StructureDefinition/Patient\" alias Patient as source\r\n"
      + "uses \"http://hl7.org/fhir/StructureDefinition/Basic\" alias Basic as target\r\n"
      + "group Patient(source src : Patient, target tgt : Basic) {\r\n"
      + "  src.identifier -> tgt.identifier;\r\n"
      + "}";

    StructureMap structureMap = scu.parse(fileMap, "TripleQuotedDescription");
    Assertions.assertEquals("\r\nYou should use my *awesome* map.\r\nIt does really cool things.\r\n", structureMap.getDescription());
  }

  @Test
  void testSingleQuotedDescriptionStillWorks() throws FHIRException {
    StructureMapUtilities scu = new StructureMapUtilities(context, this);
    String fileMap = "/// url = \"http://example.com/StructureMap/single\"\r\n"
      + "/// name = \"SingleQuotedDescription\"\r\n"
      + "/// description = \"A simple single line description\"\r\n"
      + "/// status = \"draft\"\r\n"
      + "uses \"http://hl7.org/fhir/StructureDefinition/Patient\" alias Patient as source\r\n"
      + "uses \"http://hl7.org/fhir/StructureDefinition/Basic\" alias Basic as target\r\n"
      + "group Patient(source src : Patient, target tgt : Basic) {\r\n"
      + "  src.identifier -> tgt.identifier;\r\n"
      + "}";

    StructureMap structureMap = scu.parse(fileMap, "SingleQuotedDescription");
    Assertions.assertEquals("A simple single line description", structureMap.getDescription());
  }

  @Test
  void testEmptyQuotedDescriptionStillWorks() throws FHIRException {
    StructureMapUtilities scu = new StructureMapUtilities(context, this);
    String fileMap = "/// url = \"http://example.com/StructureMap/empty\"\r\n"
      + "/// name = \"EmptyQuotedDescription\"\r\n"
      + "/// description = \"\"\r\n"
      + "/// status = \"draft\"\r\n"
      + "uses \"http://hl7.org/fhir/StructureDefinition/Patient\" alias Patient as source\r\n"
      + "uses \"http://hl7.org/fhir/StructureDefinition/Basic\" alias Basic as target\r\n"
      + "group Patient(source src : Patient, target tgt : Basic) {\r\n"
      + "  src.identifier -> tgt.identifier;\r\n"
      + "}";

    StructureMap structureMap = scu.parse(fileMap, "EmptyQuotedDescription");
    // empty description falls back to title; title is unset, so getDescription should be empty / null
    Assertions.assertTrue(structureMap.getDescription() == null || structureMap.getDescription().isEmpty());
  }

  @Test
  void testRenderMultiLineDescriptionUsesTripleQuotes() throws FHIRException {
    StructureMap map = new StructureMap();
    map.setUrl("http://example.com/StructureMap/render-multi");
    map.setName("RenderMulti");
    map.setStatus(org.hl7.fhir.r5.model.Enumerations.PublicationStatus.DRAFT);
    map.setDescription("You should use my *awesome* map.\r\nIt does really cool things.");

    String rendered = StructureMapUtilities.render(map);
    Assertions.assertTrue(rendered.contains("/// description = \"\"\""), "Expected triple-quoted description in:\r\n" + rendered);
    Assertions.assertTrue(rendered.contains("You should use my *awesome* map."), "Expected verbatim markdown content in:\r\n" + rendered);
    Assertions.assertTrue(rendered.contains("It does really cool things.\"\"\""), "Expected triple-quoted close in:\r\n" + rendered);

    // round-trip: re-parse the rendered output and confirm description is preserved
    StructureMapUtilities scu = new StructureMapUtilities(context, this);
    StructureMap reparsed = scu.parse(rendered, "RenderMulti");
    Assertions.assertEquals("You should use my *awesome* map.\r\nIt does really cool things.", reparsed.getDescription());
  }

  @Test
  void testRenderSingleLineDescriptionUsesSingleQuotes() throws FHIRException {
    StructureMap map = new StructureMap();
    map.setUrl("http://example.com/StructureMap/render-single");
    map.setName("RenderSingle");
    map.setStatus(org.hl7.fhir.r5.model.Enumerations.PublicationStatus.DRAFT);
    map.setDescription("A simple one-line description with a \"quote\" in it.");

    String rendered = StructureMapUtilities.render(map);
    Assertions.assertTrue(rendered.contains("/// description = \"A simple one-line description with a \\\"quote\\\" in it.\""),
      "Expected escaped single-quoted description in:\r\n" + rendered);
    Assertions.assertFalse(rendered.contains("\"\"\""), "Did not expect triple quotes for a single-line description in:\r\n" + rendered);
  }

  @Test
  void testRenderDescriptionContainingTripleQuoteFallsBack() throws FHIRException {
    StructureMap map = new StructureMap();
    map.setUrl("http://example.com/StructureMap/render-fallback");
    map.setName("RenderFallback");
    map.setStatus(org.hl7.fhir.r5.model.Enumerations.PublicationStatus.DRAFT);
    // multi-line content but also contains """ which cannot live inside a verbatim block
    map.setDescription("Line one\r\nLine \"\"\" two\r\nLine three");

    String rendered = StructureMapUtilities.render(map);
    Assertions.assertFalse(rendered.contains("/// description = \"\"\""),
      "Expected fallback to single-line escaped form when description contains triple quotes, got:\r\n" + rendered);

    // round-trip still works
    StructureMapUtilities scu = new StructureMapUtilities(context, this);
    StructureMap reParsed = scu.parse(rendered, "RenderFallback");
    Assertions.assertEquals("Line one\r\nLine \"\"\" two\r\nLine three", reParsed.getDescription());
  }

  @Test
  void testRenderDescriptionEndingWithQuoteFallsBack() throws FHIRException {
    StructureMap map = new StructureMap();
    map.setUrl("http://example.com/StructureMap/render-trailing-quote");
    map.setName("RenderTrailingQuote");
    map.setStatus(org.hl7.fhir.r5.model.Enumerations.PublicationStatus.DRAFT);
    // multi-line content ending with " — would be greedily merged into the closing """
    map.setDescription("Line one\r\nLine two ends with \"");

    String rendered = StructureMapUtilities.render(map);
    Assertions.assertFalse(rendered.contains("/// description = \"\"\""),
      "Expected fallback to single-line escaped form when description ends with a quote, got:\r\n" + rendered);

    // round-trip still works
    StructureMapUtilities scu = new StructureMapUtilities(context, this);
    StructureMap reParsed = scu.parse(rendered, "RenderTrailingQuote");
    Assertions.assertEquals("Line one\r\nLine two ends with \"", reParsed.getDescription());
  }
  
  // --- Simple Form: Identity Transform round-trip --------------------------------------
  private static final String IDENTITY_BATCH_MAP_HEADER =
      "/// url = \"http://example.com/StructureMap/identity-batch\"\r\n"
    + "/// name = \"IdentityBatch\"\r\n"
    + "/// status = \"draft\"\r\n"
    + "\r\n"
    + "uses \"http://hl7.org/fhir/StructureDefinition/Patient\" alias Patient as source\r\n"
    + "uses \"http://hl7.org/fhir/StructureDefinition/Basic\" alias Basic as target\r\n"
    + "\r\n";

  @Test
  void testIdentityBatchAnonymousRoundTrip() throws FHIRException {
    String fileMap = IDENTITY_BATCH_MAP_HEADER
      + "group Patient(source src : Patient, target tgt : Basic) {\r\n"
      + "  src -> tgt: id, active, gender;\r\n"
      + "}\r\n\r\n";

    StructureMapUtilities scu = new StructureMapUtilities(context, this);
    StructureMap sm = scu.parse(fileMap, "IdentityBatch");

    // Three sibling rules whose names are makeId(BATCH_IDENTITY_UNNAMED_NAME + element).
    // The sentinel prefix lets the renderer distinguish a batch from a run of
    // singly-written `src.x -> tgt.x;` rules; it is stripped on output.
    Assertions.assertEquals(3, sm.getGroup().get(0).getRule().size());
    Assertions.assertEquals(StructureMapUtilities.BATCH_IDENTITY_UNNAMED_NAME + "id", sm.getGroup().get(0).getRule().get(0).getName());
    Assertions.assertEquals(StructureMapUtilities.BATCH_IDENTITY_UNNAMED_NAME + "active", sm.getGroup().get(0).getRule().get(1).getName());
    Assertions.assertEquals(StructureMapUtilities.BATCH_IDENTITY_UNNAMED_NAME + "gender", sm.getGroup().get(0).getRule().get(2).getName());

    String rendered = StructureMapUtilities.render(sm);
    Assertions.assertEquals(fileMap, rendered);
  }

  @Test
  void testIdentityBatchNamedRoundTrip() throws FHIRException {
    String fileMap = IDENTITY_BATCH_MAP_HEADER
      + "group Patient(source src : Patient, target tgt : Basic) {\r\n"
      + "  src -> tgt: maritalStatus, birthDate \"Others\";\r\n"
      + "}\r\n\r\n";

    StructureMapUtilities scu = new StructureMapUtilities(context, this);
    StructureMap sm = scu.parse(fileMap, "IdentityBatch");

    // Names are makeId(ruleName + element)
    Assertions.assertEquals(2, sm.getGroup().get(0).getRule().size());
    Assertions.assertEquals("OthersmaritalStatus", sm.getGroup().get(0).getRule().get(0).getName());
    Assertions.assertEquals("OthersbirthDate", sm.getGroup().get(0).getRule().get(1).getName());

    String rendered = StructureMapUtilities.render(sm);
    Assertions.assertEquals(fileMap, rendered);
  }

  @Test
  void testTwoIdentityBatchesAdjacentRoundTrip() throws FHIRException {
    // Two distinct batches one after the other; the second has a different prefix
    // so the render side should emit two separate batch lines.
    String fileMap = IDENTITY_BATCH_MAP_HEADER
      + "group Patient(source src : Patient, target tgt : Basic) {\r\n"
      + "  src -> tgt: id, active, gender;\r\n"
      + "  src -> tgt: maritalStatus, birthDate \"Others\";\r\n"
      + "}\r\n\r\n";

    StructureMapUtilities scu = new StructureMapUtilities(context, this);
    StructureMap sm = scu.parse(fileMap, "IdentityBatch");

    Assertions.assertEquals(5, sm.getGroup().get(0).getRule().size());
    String rendered = StructureMapUtilities.render(sm);
    Assertions.assertEquals(fileMap, rendered);
  }

  // assert indices are equal to Element.numberChildren()
  private void checkNumberChildren(Element e, String indent) {
    System.out.println(indent + e + ", index: " + e.getIndex());
    String last = "";
    int index = 0;
    for (Element child : e.getChildren()) {
      if (child.getProperty().isList()) {
        if (last.equals(child.getName())) {
          index++;
        } else {
          last = child.getName();
          index = 0;
        }
        // child.index = index;
        Assertions.assertEquals(index, child.getIndex());
      } else {
        // child.index = -1;
        Assertions.assertEquals(-1, child.getIndex());
      }
      checkNumberChildren(child, indent + "  ");
    }
  }
  

  @Override
  public void log(String message) {
  }

  @Override
  public Base createType(Object appInfo, String name, ProfileUtilities profileUtilities) throws FHIRException {
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