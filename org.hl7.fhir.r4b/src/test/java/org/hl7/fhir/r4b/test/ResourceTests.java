package org.hl7.fhir.r4b.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.hl7.fhir.r4b.formats.IParser.OutputStyle;
import org.hl7.fhir.r4b.formats.XmlParser;
import org.hl7.fhir.r4b.model.CapabilityStatement;
import org.hl7.fhir.r4b.model.CodeSystem;
import org.hl7.fhir.r4b.model.CompartmentDefinition;
import org.hl7.fhir.r4b.model.ConceptMap;
import org.hl7.fhir.r4b.model.ExampleScenario;
import org.hl7.fhir.r4b.model.GraphDefinition;
import org.hl7.fhir.r4b.model.ImplementationGuide;
import org.hl7.fhir.r4b.model.MessageDefinition;
import org.hl7.fhir.r4b.model.NamingSystem;
import org.hl7.fhir.r4b.model.OperationDefinition;
import org.hl7.fhir.r4b.model.Resource;
import org.hl7.fhir.r4b.model.SearchParameter;
import org.hl7.fhir.r4b.model.StructureDefinition;
import org.hl7.fhir.r4b.model.StructureMap;
import org.hl7.fhir.r4b.model.TerminologyCapabilities;
import org.hl7.fhir.r4b.model.ValueSet;
import org.junit.jupiter.api.Test;

class ResourceTests {

  @Test
  void testSupportsCopyright() {
    assertTrue(new CodeSystem().supportsCopyright());
    assertTrue(new ValueSet().supportsCopyright());
    assertTrue(new ConceptMap().supportsCopyright());
    assertTrue(new TerminologyCapabilities().supportsCopyright());
    assertTrue(new CapabilityStatement().supportsCopyright());
    assertTrue(new StructureDefinition().supportsCopyright());
    assertTrue(new ImplementationGuide().supportsCopyright());
    assertTrue(new MessageDefinition().supportsCopyright());
    assertTrue(new StructureMap().supportsCopyright());
    assertTrue(new ExampleScenario().supportsCopyright());
    assertFalse(new SearchParameter().supportsCopyright());
    assertFalse(new NamingSystem().supportsCopyright());
    assertFalse(new OperationDefinition().supportsCopyright());
    assertFalse(new CompartmentDefinition().supportsCopyright());
    assertFalse(new GraphDefinition().supportsCopyright());
  }

  private String SRC = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n\r\n"
      + "<Patient xmlns=\"http://hl7.org/fhir\">\r\n" + "  <name>\r\n" + "    <text value=\"Job Bloggs\"/>\r\n"
      + "  </name>\r\n" + "</Patient>\r\n";

  private String TGT = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
      + "<Patient xmlns=\"http://hl7.org/fhir\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://hl7.org/fhir http://test.org/Patient.xsd\">"
      + "<name>" + "<text value=\"Job Bloggs\"/>" + "</name>" + "</Patient>";

  @Test
  void testSchemaLocation() throws IOException {
    XmlParser xml = new XmlParser();
    xml.setSchemaPath("http://test.org");
    xml.setOutputStyle(OutputStyle.NORMAL);
    Resource res = xml.parse(SRC);
    String output = xml.composeString(res);
    assertEquals(TGT, output);
  }
}
