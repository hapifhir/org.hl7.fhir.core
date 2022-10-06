package org.hl7.fhir.r5.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.r5.elementmodel.ParserBase.ValidationPolicy;
import org.hl7.fhir.r5.model.CodeSystem;
import org.hl7.fhir.r5.test.utils.TestingUtilities;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.junit.jupiter.api.Test;


public class GeneralTests {

  @Test
  void testXMLParse() throws IOException {
    System.out.println(System.getProperty("java.vm.name"));
    InputStream stream = TestingUtilities.loadTestResourceStream("validator",
      "xml_v10.xml");
    org.hl7.fhir.r5.elementmodel.XmlParser xp = new org.hl7.fhir.r5.elementmodel.XmlParser(TestingUtilities.getSharedWorkerContext());
    xp.setAllowXsiLocation(true);
    List<ValidationMessage> errorList = new ArrayList<>();
    xp.setupValidation(ValidationPolicy.EVERYTHING, errorList);
    try {
      Object resource = xp.parse(stream);
    } catch (Exception e) {
      e.printStackTrace();
    }
    for (ValidationMessage message : errorList) {
      System.out.println(message.getMessage());
    }
  }
  
}
