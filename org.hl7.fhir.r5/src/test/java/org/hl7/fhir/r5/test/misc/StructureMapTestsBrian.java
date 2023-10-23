package org.hl7.fhir.r5.test.misc;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.hl7.fhir.r5.utils.structuremap.StructureMapUtilities;
import org.hl7.fhir.r5.context.IWorkerContext;
import org.hl7.fhir.r5.formats.IParser;
import org.hl7.fhir.r5.formats.JsonParser;
import org.hl7.fhir.r5.formats.IParser.OutputStyle;
import org.hl7.fhir.r5.model.Bundle;
import org.hl7.fhir.r5.model.Condition;
import org.hl7.fhir.r5.model.QuestionnaireResponse;
import org.hl7.fhir.r5.model.StructureMap;
import org.hl7.fhir.r5.test.utils.TestingUtilities;

public class StructureMapTestsBrian {

  static private IWorkerContext context;

  @BeforeAll
  static public void setUp() throws Exception {
    context = TestingUtilities.getSharedWorkerContext();
  }

  @Test
  public void testMultipleSourceVariables() throws FileNotFoundException, Exception {
    // read in the test data
    String mapQR = TestingUtilities.loadTestResource("r4b", "structure-mapping", "qr-multiple-source.json");
    IParser parser = new JsonParser();
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
    var parser = new JsonParser();
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
}