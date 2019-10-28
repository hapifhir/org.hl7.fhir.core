package org.hl7.fhir.r5.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r5.context.SimpleWorkerContext;
import org.hl7.fhir.r5.model.Base;
import org.hl7.fhir.r5.model.Coding;
import org.hl7.fhir.r5.model.StructureMap;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.r5.utils.EOperationOutcome;
import org.hl7.fhir.r5.utils.StructureMapUtilities;
import org.hl7.fhir.r5.utils.StructureMapUtilities.ITransformerServices;
import org.hl7.fhir.utilities.TextFile;
import org.hl7.fhir.utilities.cache.PackageCacheManager;
import org.hl7.fhir.utilities.cache.ToolsVersion;
import org.junit.BeforeClass;
import org.junit.Test;
import org.xmlpull.v1.XmlPullParserException;

public class StructureMapUtilitiesTest implements ITransformerServices{

  static private SimpleWorkerContext context;

  @BeforeClass
  static public void setUp() throws Exception {
    if (context == null) {
      PackageCacheManager pcm = new PackageCacheManager(true, ToolsVersion.TOOLS_VERSION);
      context = SimpleWorkerContext.fromPackage(pcm.loadPackage("hl7.fhir.core", "4.0.0"));
    }
  }

  @Test
  public void testParseRuleName()
      throws FileNotFoundException, IOException, XmlPullParserException, EOperationOutcome, FHIRException {

    StructureMapUtilities scu = new StructureMapUtilities(context, this);
    String fileMap = TestingUtilities.loadTestResource("r5", "fml", "ActivityDefinition.map");
    StructureMap structureMap = scu.parse(fileMap, "ActivityDefinition3To4");
    
    // StructureMap/ActivityDefinition3to4: StructureMap.group[3].rule[2].name error id value '"expression"' is not valid
    assertEquals("expression",structureMap.getGroup().get(2).getRule().get(1).getName());
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
