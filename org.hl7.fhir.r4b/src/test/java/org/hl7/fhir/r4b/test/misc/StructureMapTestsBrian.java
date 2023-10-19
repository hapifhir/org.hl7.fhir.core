package org.hl7.fhir.r4b.test.misc;

import java.io.FileNotFoundException;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.hl7.fhir.r4b.utils.structuremap.ITransformerServices;
import org.hl7.fhir.r4b.utils.structuremap.StructureMapUtilities;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4b.context.IWorkerContext;
import org.hl7.fhir.r4b.formats.ParserType;
import org.hl7.fhir.r4b.formats.IParser.OutputStyle;
import org.hl7.fhir.r4b.model.Base;
import org.hl7.fhir.r4b.model.Bundle;
import org.hl7.fhir.r4b.model.Coding;
import org.hl7.fhir.r4b.model.Condition;
import org.hl7.fhir.r4b.model.QuestionnaireResponse;
import org.hl7.fhir.r4b.model.StructureMap;
import org.hl7.fhir.r4b.test.utils.TestingUtilities;

public class StructureMapTestsBrian implements ITransformerServices {

  static private IWorkerContext context;

  @BeforeAll
  static public void setUp() throws Exception {
    context = TestingUtilities.context();
  }

  @Test
  public void testMultipleSourceVariables() throws FileNotFoundException, Exception {
    // read in the test data
    String mapQR = TestingUtilities.loadTestResource("r4b", "structure-mapping", "qr-multiple-source.json");
    var parser = context.getParser(ParserType.JSON);
    QuestionnaireResponse qr = (QuestionnaireResponse) parser.parse(mapQR);
    String mapString = TestingUtilities.loadTestResource("r4b", "structure-mapping", "multiple-source.map");
    StructureMapUtilities scu = new StructureMapUtilities(context);
    StructureMap map = scu.parse(mapString, null);

    // Now that we have a map and a QR, we can run the transform
    Bundle target = new Bundle(); // new bundle to hold the transformed QR
    scu.transform(null, qr, map, target);

    // Now validate that this resource is exactly what we expected to get
    parser.setOutputStyle(OutputStyle.PRETTY);
    var jsonResult = parser.composeString(target);
    System.out.println(jsonResult);
    
    // Finally some actual assertions
    Assertions.assertEquals(3, target.getEntry().size());
    var entries = target.getEntry();
    var cond1 = (Condition)entries.get(0).getResource();
    var cond2 = (Condition)entries.get(1).getResource();
    var cond3 = (Condition)entries.get(2).getResource();
    Assertions.assertEquals("condition_71802-3_LA31994-9", cond1.getAbatementStringType().asStringValue());
    Assertions.assertEquals("condition_71802-3_LA31995-6", cond2.getAbatementStringType().asStringValue());
    Assertions.assertEquals("condition_71802-3_LA31995-3", cond3.getAbatementStringType().asStringValue());
  }

  @Test
  public void testMultipleSourceVariablesCopyId() throws FileNotFoundException, Exception {
    // read in the test data
    String mapQR = TestingUtilities.loadTestResource("r4b", "structure-mapping", "qr-multiple-source.json");
    var parser = context.getParser(ParserType.JSON);
    QuestionnaireResponse qr = (QuestionnaireResponse) parser.parse(mapQR);
    String mapString = TestingUtilities.loadTestResource("r4b", "structure-mapping", "multiple-source-id.map");
    StructureMapUtilities scu = new StructureMapUtilities(context);
    StructureMap map = scu.parse(mapString, null);

    // Now that we have a map and a QR, we can run the transform
    Bundle target = new Bundle(); // new bundle to hold the transformed QR
    scu.transform(null, qr, map, target);

    // Now validate that this resource is exactly what we expected to get
    parser.setOutputStyle(OutputStyle.PRETTY);
    var jsonResult = parser.composeString(target);
    System.out.println(jsonResult);
    
    // Finally some actual assertions
    Assertions.assertEquals(3, target.getEntry().size());
    var entries = target.getEntry();
    var cond1 = (Condition)entries.get(0).getResource();
    var cond2 = (Condition)entries.get(1).getResource();
    var cond3 = (Condition)entries.get(2).getResource();
    Assertions.assertEquals("condition_71802-3_LA31994-9", cond1.getId());
    Assertions.assertEquals("condition_71802-3_LA31995-6", cond2.getId());
    Assertions.assertEquals("condition_71802-3_LA31995-3", cond3.getId());
  }

  @Override
  public void log(String message) {
    // TODO Auto-generated method stub
    System.out.println(message);
  }

  @Override
  public Base createType(Object appInfo, String name) throws FHIRException {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'createType'");
  }

  @Override
  public Base createResource(Object appInfo, Base res, boolean atRootofTransform) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'createResource'");
  }

  @Override
  public Coding translate(Object appInfo, Coding source, String conceptMapUrl) throws FHIRException {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'translate'");
  }

  @Override
  public Base resolveReference(Object appContext, String url) throws FHIRException {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'resolveReference'");
  }

  @Override
  public List<Base> performSearch(Object appContext, String url) throws FHIRException {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'performSearch'");
  }
}