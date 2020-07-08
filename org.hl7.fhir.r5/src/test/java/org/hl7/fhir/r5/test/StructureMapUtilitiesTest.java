package org.hl7.fhir.r5.test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.List;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.StructureMap;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.r5.utils.StructureMapUtilities;
import org.hl7.fhir.r5.utils.StructureMapUtilities.ITransformerServices;
import org.hl7.fhir.utilities.cache.FilesystemPackageCacheManager;
import org.hl7.fhir.utilities.cache.ToolsVersion;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class StructureMapUtilitiesTest implements ITransformerServices {

  static private SimpleWorkerContext context;
  
  @BeforeAll
  static public void setUp() throws Exception {
    FilesystemPackageCacheManager pcm = new FilesystemPackageCacheManager(true, ToolsVersion.TOOLS_VERSION);
    context = SimpleWorkerContext.fromPackage(pcm.loadPackage("hl7.fhir.r4.core", "4.0.1"));
  }

  @Test
  public void testParseRuleName() throws IOException, FHIRException {
    StructureMapUtilities scu = new StructureMapUtilities(context, this);
    String fileMap = TestingUtilities.loadTestResource("r5", "fml", "ActivityDefinition.map");
    StructureMap structureMap = scu.parse(fileMap, "ActivityDefinition3To4");

    // StructureMap/ActivityDefinition3to4: StructureMap.group[3].rule[2].name error id value '"expression"' is not valid
    assertEquals("expression", structureMap.getGroup().get(2).getRule().get(1).getName());
  }
  
  @Test
  public void testSyntax() throws IOException, FHIRException {
    StructureMapUtilities scu = new StructureMapUtilities(context, this);
    String fileMap = TestingUtilities.loadTestResource("r5", "fml", "syntax.map");
    StructureMap structureMap = scu.parse(fileMap, "Syntax");

    assertEquals("syntax", structureMap.getName());
    assertEquals("http://github.com/FHIR/fhir-test-cases/r5/fml/syntax", structureMap.getUrl());
    assertEquals("Patient", structureMap.getStructure().get(0).getAlias());
    assertEquals("http://hl7.org/fhir/StructureDefinition/Patient", structureMap.getStructure().get(0).getUrl());
    assertEquals("Source Documentation", structureMap.getStructure().get(0).getDocumentation());
    assertEquals("http://hl7.org/fhir/StructureDefinition/Patient", structureMap.getStructure().get(0).getUrl());
    assertEquals("http://hl7.org/fhir/StructureDefinition/Basic", structureMap.getStructure().get(1).getUrl());
    assertEquals("Target Documentation", structureMap.getStructure().get(1).getDocumentation());
        
    System.out.println(StructureMapUtilities.render(structureMap));

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