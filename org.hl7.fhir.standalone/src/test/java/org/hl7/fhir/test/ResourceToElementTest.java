package org.hl7.fhir.test;

import org.hl7.fhir.services.context.IWorkerContext;
import org.hl7.fhir.services.elementmodel.Element;
import org.hl7.fhir.services.elementmodel.ResourceParser;
import org.hl7.fhir.model.utilities.formats.OutputStyle;
import org.hl7.fhir.model.core.formats.XmlParser;
import org.hl7.fhir.model.core.Resource;
import org.hl7.fhir.services.testing.CompareUtilities;
import org.hl7.fhir.standalone.testing.TestingUtilities;
import org.hl7.fhir.utilities.FileUtilities;
import org.hl7.fhir.utilities.Utilities;
import org.hl7.fhir.utilities.filesystem.ManagedFileAccess;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ResourceToElementTest {


  private void runTest(String filename) throws IOException, FileNotFoundException, Exception {
    String src = Utilities.path("[tmp]", FileUtilities.changeFileExt(filename, ".out.xml"));
    String dst = Utilities.path("[tmp]", FileUtilities.changeFileExt(filename, ".in.xml"));
    
    IWorkerContext ctxt = TestingUtilities.getSharedWorkerContext();
    ResourceParser p = new ResourceParser(ctxt);
    Resource res = (Resource) new XmlParser(TestingUtilities.getSharedWorkerContext()).parse(TestingUtilities.loadTestResourceStream("r6", filename));
    Element e = p.parse(res);
    new org.hl7.fhir.services.elementmodel.XmlParser(ctxt).compose(e, ManagedFileAccess.outStream(src), OutputStyle.PRETTY, null);
    new XmlParser(TestingUtilities.getSharedWorkerContext()).setOutputStyle(OutputStyle.PRETTY).compose(ManagedFileAccess.outStream(dst), res);
    String msg = new CompareUtilities().checkXMLIsSame(filename, src, dst);
    Assertions.assertNull(msg);
  }


  @Test
  public void testObservation() throws Exception {
    runTest("observation-example.xml");
  }

  @Test
  public void testPatient() throws Exception {
    runTest("patient-example.xml");
  }

  @Test
  public void testPatientGlossy() throws Exception {
    runTest("patient-glossy-example.xml");
  }

  @Test
  public void testPatientPeriod() throws Exception {
    runTest("patient-example-period.xml");
  }

  @Test
  public void testPatientXds() throws Exception {
    runTest("patient-example-xds.xml");
  }

  @Test
  public void testQuestionnaire() throws Exception {
    runTest("questionnaire-example.xml");
  }

  @Test
  public void testQuestionnaireLifelines() throws Exception {
    runTest("questionnaire-example-f201-lifelines.xml");
  }

  @Test
  public void testValueSet() throws Exception {
    runTest("valueset-example-expansion.xml");
  }
  
  @Test
  public void testParameters() throws Exception {
    runTest("parameters-example.xml");
  }

  @Test
  public void testParametersTypes() throws Exception {
    runTest("parameters-example-types.xml");
  }

  @Test
  public void testObservation2() throws Exception {
    runTest("observation-example-20minute-apgar-score.xml");
  }

  @Test
  public void testDispense() throws Exception {
    runTest("medicationdispenseexample8.xml");
  }

  @Test
  public void testDispense2() throws Exception {
    runTest("medicationdispense8.xml");
  }


  @Test
  public void testList() throws Exception {
    runTest("list-example-long.xml");
  }

  @Test
  public void testCondition() throws Exception {
    runTest("condition-example.xml");
  }


  @Test
  public void testCodesystem() throws Exception {
    runTest("codesystem-example.xml");
  }

  
}
