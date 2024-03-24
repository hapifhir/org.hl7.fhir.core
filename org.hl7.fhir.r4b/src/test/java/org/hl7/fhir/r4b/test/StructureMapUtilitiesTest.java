package org.hl7.fhir.r4b.test;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4b.context.SimpleWorkerContext;
import org.hl7.fhir.r4b.model.Base;
import org.hl7.fhir.r4b.model.Coding;
import org.hl7.fhir.r4b.model.StructureMap;
import org.hl7.fhir.r4b.model.StructureMap.StructureMapGroupRuleTargetComponent;
import org.hl7.fhir.r4b.test.utils.TestingUtilities;
import org.hl7.fhir.r4b.utils.structuremap.StructureMapUtilities;
import org.hl7.fhir.r4b.utils.structuremap.ITransformerServices;
import org.hl7.fhir.utilities.npm.FilesystemPackageCacheManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class StructureMapUtilitiesTest implements ITransformerServices {

  static private SimpleWorkerContext context;

  @BeforeAll
  static public void setUp() throws Exception {
    FilesystemPackageCacheManager pcm = new FilesystemPackageCacheManager.Builder().build();
    context = SimpleWorkerContext.fromPackage(pcm.loadPackage("hl7.fhir.r4.core", "4.0.1"));
  }

  @Test
  public void testParseRuleName() throws IOException, FHIRException {
    StructureMapUtilities scu = new StructureMapUtilities(context, this);
    String fileMap = TestingUtilities.loadTestResource("r5", "structure-mapping", "ActivityDefinition.map");
    StructureMap structureMap = scu.parse(fileMap, "ActivityDefinition3To4");

    // StructureMap/ActivityDefinition3to4: StructureMap.group[3].rule[2].name error
    // id value '"expression"' is not valid
    Assertions.assertEquals("expression", structureMap.getGroup().get(2).getRule().get(1).getName());
  }

  private void assertSerializeDeserialize(StructureMap structureMap) {
    Assertions.assertEquals("syntax", structureMap.getName());
    Assertions.assertEquals("Title of this map\r\nAuthor", structureMap.getDescription());
    Assertions.assertEquals("http://github.com/FHIR/fhir-test-cases/r5/fml/syntax", structureMap.getUrl());
    Assertions.assertEquals("Patient", structureMap.getStructure().get(0).getAlias());
    Assertions.assertEquals("http://hl7.org/fhir/StructureDefinition/Patient",
        structureMap.getStructure().get(0).getUrl());
    Assertions.assertEquals("Source Documentation", structureMap.getStructure().get(0).getDocumentation());
    Assertions.assertEquals("http://hl7.org/fhir/StructureDefinition/Patient",
        structureMap.getStructure().get(0).getUrl());
    Assertions.assertEquals("http://hl7.org/fhir/StructureDefinition/Basic",
        structureMap.getStructure().get(1).getUrl());
    Assertions.assertEquals("Target Documentation", structureMap.getStructure().get(1).getDocumentation());
    Assertions.assertEquals("Groups\r\nrule for patient group", structureMap.getGroup().get(0).getDocumentation());
    Assertions.assertEquals("Comment to rule", structureMap.getGroup().get(0).getRule().get(0).getDocumentation());
    Assertions.assertEquals("Copy identifier short syntax",
        structureMap.getGroup().get(0).getRule().get(1).getDocumentation());

    StructureMapGroupRuleTargetComponent target = structureMap.getGroup().get(0).getRule().get(2).getTarget().get(1);
    Assertions.assertEquals("'urn:uuid:' + r.lower()", target.getParameter().get(0).toString());
  }

  @Test
  public void testSyntax() throws IOException, FHIRException {
    StructureMapUtilities scu = new StructureMapUtilities(context, this);
    String fileMap = TestingUtilities.loadTestResource("r4b", "structure-mapping", "syntax.map");
    System.out.println(fileMap);

    StructureMap structureMap = scu.parse(fileMap, "Syntax");
    assertSerializeDeserialize(structureMap);

    String renderedMap = StructureMapUtilities.render(structureMap);
    StructureMap map = scu.parse(renderedMap, "Syntax");
    System.out.println(map);
    assertSerializeDeserialize(map);
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