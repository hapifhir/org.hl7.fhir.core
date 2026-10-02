package org.hl7.fhir.test;

import org.hl7.fhir.services.elementmodel.ParserBase.ValidationPolicy;
import org.hl7.fhir.standalone.testing.TestingUtilities;
import org.hl7.fhir.utilities.validation.ValidationMessage;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;


public class GeneralTests {

  @Test
  void testXMLParse() {
    assertDoesNotThrow(() -> {
      System.out.println(System.getProperty("java.vm.name"));
      InputStream stream = TestingUtilities.loadTestResourceStream("validator",
        "xml_v10.xml");
      org.hl7.fhir.services.elementmodel.XmlParser xp = new org.hl7.fhir.services.elementmodel.XmlParser(TestingUtilities.getSharedWorkerContext());
      xp.setAllowXsiLocation(true);
      List<ValidationMessage> errorList = new ArrayList<>();
      xp.setupValidation(ValidationPolicy.EVERYTHING);
      try {
        xp.parseSingle(stream, errorList);
      } catch (Exception e) {
        e.printStackTrace();
      }
      for (ValidationMessage message : errorList) {
        System.out.println(message.getMessage());
      }
    });
  }
  
}
